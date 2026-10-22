package com.ss.android.lark.chat.chatwindow.chat.menu.handler;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.lark.pb.basic.v1.MessageSource;
import com.bytedance.lark.pb.basic.v1.MessageSourceType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatType;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.api.service.impl.h2;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.translate.LanguageInfo;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.chat.utils.h0;
import com.ss.android.lark.dto.translate.TranslateState;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.perf.PerfChatPerformanceMonitor;
import com.ss.android.lark.statistics.translate.TranslateHitPoint;
import com.ss.android.lark.utils.ApiUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TranslateModelHandler extends ViewModel {
    public static final int ERROR_CODE_CANT_TRANSLATE = 254;
    public static final int ERROR_CODE_LOCAL_SAME_LANGUAGE = -252;
    public static final int ERROR_CODE_SAME_LANGUAGE = 252;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 1;
    private static final String KEY_LOCAL_TRANSLATE_TIMES = "key_translate_times_new";
    private static final int MAX_SUPPORT_TRANSLATE_LEVEL = 3;
    private static final String TAG = "TranslateModelHandler";
    public static final int UNKNOWN_FILTER_TYPE = 0;
    protected final jdb.g fgService;
    protected String mCurrentChatId;
    protected o mDataProvider;
    private final w4b.k mFeatureConfigDependency;
    protected final w4b.p mGuideDependency;
    protected Set<String> mTranslateIdSet;
    protected final com.ss.android.lark.translate.service.impl.a mTranslatePush;
    protected final ITranslateService mTranslateService;
    protected TranslateLanguageSetting mTranslateSetting;
    private qua.a targetLanguageOptimizer;
    private final c translateMsgInfo;

    public static class AutoTranslateStatCallback implements IGetDataCallback<fcb.a> {
        boolean hasReported;
        private final Map<String, f5b.b> msgInfoMap;

        private AutoTranslateStatCallback(Map<String, f5b.b> r2) {
            this.hasReported = false;
            this.msgInfoMap = r2;
        }

        public void onError(ErrorResult r4) {
            if (this.hasReported == true) goto L6;
            TranslateHitPoint r0 = TranslateHitPoint.a;
            String r5 = r4.getErrorMsg();
            r0.a().sendEvent("message_autotranslate", new JSONObject().put("autotranslate_results", r5));
            this.hasReported = true;
            return;
        }

        public void onSuccess(fcb.a r6) {
            boolean r0 = !r6.a.isEmpty();
            Iterator<Map.Entry<String, TranslateState>> r7 = r6.d.entrySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L16;
            Map.Entry<String, TranslateState> r2 = r7.next();
            f5b.b r3 = this.msgInfoMap.get(r2.getKey());
            Message r4 = r2.getValue().getMessage();
            if (r3 == null) goto L15;
            if (r4 == null) goto L15;
            if (h0.n(r3) == false) goto L11;
        L13:
            boolean r5 = false;
        L14:
            r0 = r0 | r5;
            goto L15
        L11:
            if (h0.m(r4) == false) goto L13;
            r5 = true;
        L15:
            if (r0 == false) goto L4;
        L16:
            Log.d(TranslateModelHandler.TAG, "hasTranslationWork = " + r0);
            if (this.hasReported == true) goto L27;
            if (r0 == false) goto L28;
            TranslateHitPoint.a.a().sendEvent("message_autotranslate", new JSONObject().put("autotranslate_results", ChameleonOpenTracker.OpenResult.SUCCESS));
            this.hasReported = true;
            return;
        L28:
            return;
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((fcb.a) r1);
        }

        public /* synthetic */ AutoTranslateStatCallback(Map r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public static final enum CanMultiMFMsgTranslate extends Enum<CanMultiMFMsgTranslate> {
        public static final CanMultiMFMsgTranslate CAN = null;
        public static final CanMultiMFMsgTranslate NOT_SUPPORT = null;
        public static final CanMultiMFMsgTranslate SAME_LANGUAGE = null;
        public static final CanMultiMFMsgTranslate UNKONWN = null;
        public static final /* synthetic */ CanMultiMFMsgTranslate[] a = null;

        static {
            CanMultiMFMsgTranslate r0 = new CanMultiMFMsgTranslate("CAN", 0);
            CAN = r0;
            CanMultiMFMsgTranslate r1 = new CanMultiMFMsgTranslate("NOT_SUPPORT", 1);
            NOT_SUPPORT = r1;
            CanMultiMFMsgTranslate r3 = new CanMultiMFMsgTranslate("SAME_LANGUAGE", 2);
            SAME_LANGUAGE = r3;
            CanMultiMFMsgTranslate r5 = new CanMultiMFMsgTranslate("UNKONWN", 3);
            UNKONWN = r5;
            a = new CanMultiMFMsgTranslate[]{r0, r1, r3, r5};
        }

        public static CanMultiMFMsgTranslate[] values() {
            return (CanMultiMFMsgTranslate[]) a.clone();
        }

        public static CanMultiMFMsgTranslate valueOf(String r1) {
            return (CanMultiMFMsgTranslate) r27.a.a(CanMultiMFMsgTranslate.class, r1);
        }

        public CanMultiMFMsgTranslate(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CanMultiMFMsgTranslate.values().length];
            a = r0;
            r0[CanMultiMFMsgTranslate.UNKONWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[CanMultiMFMsgTranslate.SAME_LANGUAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[CanMultiMFMsgTranslate.CAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[CanMultiMFMsgTranslate.NOT_SUPPORT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class b {
        public int a;
        public int b;
        public int c;

        public b() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }

        public b(int r2) {
            this.a = 1;
            this.b = 0;
            this.c = 1;
        }
    }

    public static class c {
        public final List<String> a;
        public final List<String> b;
        public final List<MessageSource> c;
        public final Map<String, Integer> d;

        public final void a() {
            ((ArrayList) this.a).clear();
            ((ArrayList) this.c).clear();
            ((HashMap) this.d).clear();
            ((ArrayList) this.b).clear();
        }

        public c() {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = new ArrayList();
            this.d = new HashMap();
        }
    }

    public static /* synthetic */ int Mo(Message r0, Message r1) {
        return lambda$completeMultiLevelMFTransInfo$0(r0, r1);
    }

    public static /* synthetic */ int No(Message r0, Message r1) {
        return lambda$handleNestedMFTranslateInfo$1(r0, r1);
    }

    public static /* synthetic */ int yo(Message r0, Message r1) {
        return lambda$completeMergeForwardTransInfo$2(r0, r1);
    }

    public void handlePushTranslateState(fcb.a r1, p r2) {
    }

    private void initTranslateSetting() {
        if (this.mFeatureConfigDependency.a() == true) goto L5;
        return;
    L5:
        this.mTranslateService.getTranslateLanguages(new AnonymousClass1(this));
    }

    public void clearCache() {
        Set<String> r0 = this.mTranslateIdSet;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public List<LanguageInfo> getSupportedLanguages() {
        TranslateLanguageSetting r0 = this.mTranslateSetting;
        if (r0 != null) goto L7;
        return Collections.emptyList();
    L7:
        return r0.getSupportedLanguageList();
    }

    public String getTargetTranslateKey() {
        TranslateLanguageSetting r0 = this.mTranslateSetting;
        if (r0 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r0.getTargetLanguageKey();
    }

    public String getTargetTranslateLanguage() {
        TranslateLanguageSetting r0 = this.mTranslateSetting;
        if (r0 != null) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r0.getTargetLanguageName();
    }

    public Map<String, String> getTranslateOptions() {
        LinkedHashMap r0 = new LinkedHashMap();
        TranslateLanguageSetting r1 = this.mTranslateSetting;
        if (r1 != null) goto L5;
        return r0;
    L5:
        Iterator<LanguageInfo> r2 = r1.getSupportedLanguageList().iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        LanguageInfo r3 = r2.next();
        boolean r4 = this.fgService.isEnable("translate.settings.v2.enable");
        String r5 = r3.getKey();
        if (r4 == false) goto L11;
        String r6 = r3.getCurLanguageDisplayName();
    L12:
        r0.put(r5, r6);
        goto L7
    L11:
        r6 = r3.getDisplayName();
        goto L12
    L13:
        return r0;
    }

    public int getTranslateTimes() {
        return ((okb.g) ImSdkProxy.h.getValue()).a().a();
    }

    public void completeAutoTranslateGuide() {
        if (ChatCoreModule.a().getGuideDependency() == null) goto L6;
        ChatCoreModule.a().getGuideDependency().b("all_auto_translation_setting");
        return;
    }

    public boolean needShowAutoTranslateGuide() {
        if (ChatCoreModule.a().isAutoTranslateEnableViaBilling() == false) goto L11;
        TranslateLanguageSetting r0 = this.mTranslateSetting;
        if (r0 == null) goto L9;
        if (r0.isGlobalAutoTranslate() == true) goto L11;
    L9:
        if (this.mGuideDependency.a("all_auto_translation_setting") == false) goto L11;
        return true;
    L11:
        return false;
    }

    public TranslateModelHandler(com.ss.android.lark.chat.chatwindow.chat.v2.push.v r2) {
        this.mGuideDependency = ChatCoreModule.a().getGuideDependency();
        this.mFeatureConfigDependency = ChatCoreModule.a().getFeatureConfigDependency();
        this.mTranslateIdSet = new HashSet();
        this.translateMsgInfo = new c();
        this.targetLanguageOptimizer = (qua.a) ApiUtils.getApi(qua.a.class);
        this.mTranslateService = r2.x();
        this.mTranslatePush = r2.A();
        this.fgService = r2.C();
    }

    private List<f5b.b> getMessageInfoList(List<String> r1) {
        throw null;
    }

    private boolean isTrgLanguageOptimizeEnabled(ITranslateService.TranslateTriggerType r3) {
        if (this.fgService.isEnable("lark.ai.optimize_translate_trglanguage") == true) goto L5;
    L7:
        return false;
    L5:
        if (r3 != ITranslateService.TranslateTriggerType.MANUAL) goto L7;
        return true;
    }

    private boolean msgSupportTranslate(Message r4) {
        if (r4.getType() != Message.Type.MERGE_FORWARD) goto L5;
    L11:
        boolean r5 = false;
    L13:
        return !r5;
    L5:
        if (r4.getType() == Message.Type.TEXT) goto L9;
        if (r4.getType() == Message.Type.POST) goto L9;
    L10:
        r5 = true;
    L9:
        if (TextUtils.equals(r4.getMessageLanguage(), "not_lang") == false) goto L11;
        goto L10
    }

    public void batchUpdateTranslateState(List<f5b.b> r3) {
        batchUpdateTranslateState(r3, BuildConfig.FLAVOR, false);
    }

    public void fetchTranslateLanguages(IGetDataCallback<TranslateLanguageSetting> r2) {
        this.mTranslateService.getTranslateLanguages(r2);
    }

    public f5b.b getMessageInfoById(String r2) {
        return getMessageInfoById(r2, 0);
    }

    public Map<String, f5b.b> getMessageInfoMap(List<String> r4) {
        List<f5b.b> r5 = getMessageInfoList(r4);
        HashMap r0 = new HashMap();
        if (r5 == null) goto L11;
        Iterator<f5b.b> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        f5b.b r1 = r6.next();
        if (r1 == null) goto L6;
        r0.put(r1.getId(), r1);
    L11:
        return r0;
    }

    public MessageSource getMessageSource(String r4) {
        boolean r0 = !TextUtils.isEmpty(r4);
        MessageSource.Builder r1 = new MessageSource.Builder();
        if (r0 == false) goto L5;
        MessageSourceType r2 = MessageSourceType.MERGE_FORWARD_MESSAGE;
    L6:
        MessageSource.Builder r3 = r1.source_type(r2);
        if (r0 == true) goto L11;
        r4 = null;
    L11:
        return r3.source_id(r4).build();
    L5:
        r2 = MessageSourceType.COMMON_MESSAGE;
        goto L6
    }

    public boolean isTranslated(String r2) {
        if (this.mTranslateIdSet.contains(r2) == false) goto L6;
        return true;
    L6:
        this.mTranslateIdSet.add(r2);
        return false;
    }

    public void setTranslateTimes(int r2) {
        ((okb.g) ImSdkProxy.h.getValue()).a().putInt(r2);
    }

    private void completeMergeForwardTransInfo(f5b.b r4, TranslateInfo r5) {
        if (r4 == null) goto L29;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r4.getMessage().getType() != Message.Type.MERGE_FORWARD) goto L33;
        MergeForwardContent r0 = (MergeForwardContent) r4.getMessage().getContent();
        MergeForwardContent r6 = (MergeForwardContent) r5.getTranslateContent();
        List<Message> r1 = r0.getMessages();
        List<Message> r2 = r6.getMessages();
        if (r1 == null) goto L31;
        if (r2 != null) goto L11;
        return;
    L11:
        if (r1.size() == r2.size()) goto L34;
        TranslateInfo r7 = r4.getTranslateInfo();
        if (r7 == null) goto L16;
        MergeForwardContent r8 = (MergeForwardContent) r7.getTranslateContent();
    L17:
        HashSet r3 = new HashSet();
        if (r6.getMessages() == null) goto L20;
        r3.addAll(r6.getMessages());
    L20:
        if (r8 == null) goto L25;
        if (r8.getMessages() == null) goto L25;
        r3.addAll(r8.getMessages());
    L25:
        if (r0.getMessages() == null) goto L27;
        r3.addAll(r0.getMessages());
    L27:
        ArrayList r9 = new ArrayList(r3);
        Collections.sort(r9, new y());
        r6.setMessages(r9);
        return;
    L16:
        r8 = null;
        goto L17
    L34:
        return;
    L31:
        return;
    L33:
        return;
    }

    private void completeMultiLevelMFTransInfo(Message r3, TranslateInfo r4) {
        if (r3 == null) goto L22;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3.getType() != Message.Type.MERGE_FORWARD) goto L26;
        MergeForwardContent r5 = (MergeForwardContent) r3.getContent();
        MergeForwardContent r6 = (MergeForwardContent) r4.getTranslateContent();
        if (r5 == null) goto L24;
        if (r6 == null) goto L27;
        List<Message> r0 = r5.getMessages();
        List<Message> r1 = r6.getMessages();
        if (r0 == null) goto L25;
        if (r1 == null) goto L28;
        ArrayList r2 = new ArrayList();
        MergeForwardContent r7 = handleNestedMFTranslateInfo(r5.clone(), r6);
        if (r7 != null) goto L18;
    L20:
        Collections.sort(r2, new x());
        r6.setMessages(r2);
        return;
    L18:
        if (r7.getMessages() == null) goto L20;
        r2.addAll(r7.getMessages());
        goto L20
    L28:
        return;
    L25:
        return;
    L27:
        return;
    L24:
        return;
    L26:
        return;
    }

    public static TranslateModelHandler from(Fragment r2, com.ss.android.lark.chat.chatwindow.chat.v2.push.v r3) {
        return (TranslateModelHandler) new ViewModelProvider(r2, new TranslateModelHandlerFactory(r3)).get(TranslateModelHandler.class);
    }

    private b getMFMsgStatusCount(Message r5, String r6) {
        b r0 = new b();
        Content r7 = r5.getContent();
        if ((r7 instanceof MergeForwardContent) == false) goto L5;
        List<Message> r8 = ((MergeForwardContent) r7).getMessages();
        if (r8 != null) goto L9;
        return r0;
    L9:
        Iterator<Message> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L24;
        Message r1 = r9.next();
        if (msgSupportTranslate(r1) == true) goto L16;
        r0.a++;
    L23:
        r0.c++;
        goto L11
    L16:
        if (r1.getType() != Message.Type.MERGE_FORWARD) goto L19;
        r0.c--;
        b r2 = getMFMsgStatusCount(r1, r6);
        r0.a += r2.a;
        r0.b += r2.b;
        r0.c += r2.c;
        goto L23
    L19:
        if (r1.getMessageLanguage() == null) goto L23;
        if (r1.getMessageLanguage().equals(r6) == false) goto L23;
        r0.b++;
        goto L23
    L24:
        return r0;
    L5:
        return new b(0);
    }

    private MessageSource getMessageSource(String r4, List<String> r5) {
        boolean r0 = !TextUtils.isEmpty(r4);
        MessageSource.Builder r1 = new MessageSource.Builder();
        if (r0 == false) goto L5;
        MessageSourceType r2 = MessageSourceType.MERGE_FORWARD_MESSAGE;
    L6:
        MessageSource.Builder r3 = r1.source_type(r2);
        if (r0 == true) goto L11;
        r4 = null;
    L11:
        return r3.source_id(r4).message_id_path(r5).build();
    L5:
        r2 = MessageSourceType.COMMON_MESSAGE;
        goto L6
    }

    private MergeForwardContent handleNestedMFTranslateInfo(MergeForwardContent r5, MergeForwardContent r6) {
        HashMap r0 = new HashMap();
        List<Message> r1 = r5.getMessages();
        List<Message> r7 = r6.getMessages();
        if (r1 == null) goto L20;
        if (r7 == null) goto L20;
        Iterator<Message> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Message r3 = r2.next();
        r0.put(r3.getId(), r3);
        goto L8
    L10:
        Iterator<Message> r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L19;
        Message r4 = r8.next();
        if (r0.get(r4.getId()) == null) goto L12;
        if (r4.getType() == Message.Type.MERGE_FORWARD) goto L17;
        r0.put(r4.getId(), r4);
        goto L12
    L17:
        handleNestedMFTranslateInfo((MergeForwardContent) ((Message) r0.get(r4.getId())).getContent(), (MergeForwardContent) r4.getContent());
        goto L12
    L19:
        ArrayList r9 = new ArrayList(r0.values());
        Collections.sort(r9, new w());
        r5.setMessages(r9);
    L20:
        return r5;
    }

    private CanMultiMFMsgTranslate isMultiMFMsgCanTranslate(Message r2, String r3) {
        if ((r2.getContent() instanceof MergeForwardContent) == false) goto L5;
        b r4 = getMFMsgStatusCount(r2, r3);
        int r5 = r4.a;
        int r0 = r4.c;
        if (r5 != r0) goto L11;
        return CanMultiMFMsgTranslate.NOT_SUPPORT;
    L11:
        if ((r5 + r4.b) != r0) goto L15;
        return CanMultiMFMsgTranslate.SAME_LANGUAGE;
    L15:
        return CanMultiMFMsgTranslate.CAN;
    L5:
        return CanMultiMFMsgTranslate.UNKONWN;
    }

    private static /* synthetic */ int lambda$completeMergeForwardTransInfo$2(Message r2, Message r3) {
        return (int) (r2.getCreateTime() - r3.getCreateTime());
    }

    private static /* synthetic */ int lambda$completeMultiLevelMFTransInfo$0(Message r2, Message r3) {
        return (int) (r2.getCreateTime() - r3.getCreateTime());
    }

    private static /* synthetic */ int lambda$handleNestedMFTranslateInfo$1(Message r2, Message r3) {
        return (int) (r2.getCreateTime() - r3.getCreateTime());
    }

    public f5b.b getMessageInfoById(String r1, int r2) {
        Collections.singletonList(r1);
        throw null;
    }

    public void handleUrlPreviewTranslateInfo(Map<String, Map<String, PreviewHangPoint>> r5, String r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (CollectionUtils.isEmpty(r5) == true) goto L26;
        Iterator<Map.Entry<String, Map<String, PreviewHangPoint>>> r7 = r5.entrySet().iterator();
    L8:
        if (r7.hasNext() == false) goto L27;
        Iterator<Map.Entry<String, PreviewHangPoint>> r0 = r7.next().getValue().entrySet().iterator();
    L11:
        if (r0.hasNext() == false) goto L8;
        PreviewHangPoint r1 = r0.next().getValue();
        if (r1 == null) goto L11;
        if (r1.getUrlCardPreviewEntity() == null) goto L11;
        int r2 = h2.a(r1, r6);
        PreviewHangPoint r3 = h2.a.put(Integer.valueOf(r2), r1);
        goto L11
    L27:
        return;
    }

    public void setInitData(String r1, o r2) {
        this.mCurrentChatId = r1;
        initTranslateSetting();
    }

    public void translateMessageList(List<String> r12, String r13) {
        MessageSource r0 = getMessageSource(BuildConfig.FLAVOR);
        Map<String, f5b.b> r3 = getMessageInfoMap(r12);
        HashMap r8 = new HashMap();
        String r1 = this.mCurrentChatId;
        Iterator<String> r2 = r12.iterator();
        boolean r4 = false;
        String r7 = r1;
    L4:
        if (r2.hasNext() == false) goto L18;
        String r5 = r2.next();
        f5b.b r6 = r3.get(r5);
        if (r6 == null) goto L7;
        if ((r6 instanceof n5b.a) == false) goto L17;
        Chat r9 = ((n5b.a) r6).l;
        if (r9 == null) goto L17;
        if (r9.getId().equals(r7) == true) goto L17;
        if (r4 == false) goto L16;
        Log.e(TAG, "chat id changed, from " + r7 + " to " + r9.getId());
    L16:
        r7 = r9.getId();
        r4 = true;
    L17:
        r8.put(r5, Integer.valueOf(r6.getMessage().getContentVersion()));
        goto L4
    L7:
        return;
    L18:
        ArrayList r10 = new ArrayList();
        r10.add(r0);
        translate(r12, r3, ITranslateService.TranslateTriggerType.MANUAL, r13, r10, r7, r8, false, null);
    }

    public void translateMsg(String r1, String r2) {
        translateMessageList(Collections.singletonList(r1), r2);
    }

    public TranslateModelHandler(com.ss.android.lark.chat.chatwindow.chat.v2.push.v r1, String r2, o r3) {
        this(r1);
        setInitData(r2, r3);
    }

    private void batchUpdateMergeForwardTranslate(List<f5b.b> r14, String r15, ITranslateService.TranslateTriggerType r16) {
        Iterator<f5b.b> r12 = r14.iterator();
    L4:
        if (r12.hasNext() == false) goto L33;
        f5b.b r1 = r12.next();
        if (r1.getMessage().getType() != Message.Type.MERGE_FORWARD) goto L4;
        if (r1.getMessage().isFromMe() == false) goto L12;
        if (r1.getMessage().isTranslatedManually() == false) goto L4;
    L12:
        MergeForwardContent r0 = (MergeForwardContent) r1.getMessage().getContent();
        if (r0.isFromPrivateTopic() == false) goto L17;
        if (this.fgService.isEnable("messenger.message.threadforward_supports_translation") == false) goto L4;
    L17:
        List<Message> r2 = r0.getMessages();
        ArrayList r3 = new ArrayList();
        ArrayList r5 = new ArrayList();
        HashMap r7 = new HashMap();
        Iterator<Message> r4 = r2.iterator();
    L19:
        if (r4.hasNext() == false) goto L27;
        Message r6 = r4.next();
        if (r6.getType() == Message.Type.TEXT) goto L25;
        if (r6.getType() != Message.Type.POST) goto L19;
    L25:
        r3.add(r6.getId());
        r7.put(r6.getId(), Integer.valueOf(r6.getContentVersion()));
        r5.add(getMessageSource(r1.getId()));
        goto L19
    L27:
        if (CollectionUtils.isEmpty(r3) == true) goto L4;
        HashMap r8 = new HashMap();
        r8.put(r1.getId(), r1);
        AnonymousClass1 r9 = null;
        if (this.fgService.isEnable("lark.ai.support_multi_layer_translation") == true) goto L31;
        translate(r3, r8, r16, r15, r5, this.mCurrentChatId, r7, false, null, new AutoTranslateStatCallback(r8, r9));
        goto L4
    L31:
        translateMultiLevelMFMessage(r1, r15, this.mCurrentChatId, r16, null, new AutoTranslateStatCallback(r8, r9));
        goto L4
    }

    private void handleTranslateResult(Map<String, TranslateState> r12, Map<String, f5b.b> r13, List<String> r14) {
        HashSet r0 = new HashSet();
        Iterator r1 = new ArrayList(r12.keySet()).iterator();
    L3:
        Message r3 = null;
        boolean r5 = true;
        if (r1.hasNext() == false) goto L37;
        String r2 = (String) r1.next();
        f5b.b r6 = r13.get(r2);
        if (r6 == null) goto L3;
        f5b.b r7 = r6.clone();
        if (this.fgService.isEnable("im.messenger.translate_loading_state_fix.reverse") == false) goto L11;
    L14:
        r7.setIsTranslating(false);
    L15:
        TranslateState r8 = r12.get(r2);
        if (r8 == null) goto L29;
        if (r8.getErrorCode() > 0) goto L29;
        if (r8.getTranslateInfo() != null) goto L22;
        TranslateInfo r9 = null;
    L24:
        if (r8.getMessage() == null) goto L27;
        r3 = r8.getMessage().clone();
    L27:
        completeMultiLevelMFTransInfo(r3, r9);
        r7.setTranslateInfo(r9);
        r7.setMessage(r8.getMessage());
        goto L29
    L22:
        r9 = r8.getTranslateInfo().clone();
    L29:
        if (r7.getMessage() == null) goto L3;
        StringBuilder r4 = new StringBuilder("handleTranslateResult,add messageInfoSet messageId:");
        r4.append(r2);
        r4.append("translateInfo is null? ");
        if (r7.getTranslateInfo() == null) goto L35;
        r5 = false;
    L35:
        r4.append(r5);
        Log.i(TAG, r4.toString());
        r0.add(r7);
        goto L3
    L11:
        if (CollectionUtils.isEmpty(r14) == true) goto L14;
        if (r14.contains(r2) == true) goto L15;
    L37:
        if (CollectionUtils.isEmpty(r0) == false) goto L41;
        Log.i(TAG, "messageInfoSet is empty");
        return;
    L41:
        if (r0.size() != 1) goto L51;
        Message r15 = ((f5b.b) r0.iterator().next()).getMessage();
        String r16 = r15.getId();
        MessageType.a r17 = MessageType.Companion;
        int r18 = r15.getType().getNumber();
        r17.getClass();
        PerfChatPerformanceMonitor.d(r16, MessageType.a.a(r18), ChatType.GROUP, null);
        throw null;
    L51:
        throw null;
    }

    private void handleTranslating(List<String> r4, boolean r5, Map<String, f5b.b> r6) {
        HashSet r0 = new HashSet();
        Iterator<String> r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L12;
        f5b.b r1 = r6.get(r7.next());
        if (r1 == null) goto L4;
        if (r1.getMessage() == null) goto L4;
        r1.setIsTranslating(r5);
        r0.add(r1);
        goto L4
    L12:
        if (CollectionUtils.isEmpty(r0) == false) goto L14;
        return;
    L14:
        new ArrayList(r0);
        throw null;
    }

    public void batchUpdateTranslateState(List<f5b.b> r10, String r11, boolean r12) {
        ArrayList r1 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList r0 = new ArrayList();
        Iterator<f5b.b> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L34;
        f5b.b r2 = r13.next();
        String r4 = h0.d(r2);
        if (isTranslated(r4) == true) goto L4;
        Log.i(TAG, "batchUpdateTranslateState, translate key:" + r4);
        Message r5 = r2.getMessage();
        if (r5.isRemoved() == true) goto L4;
        if (r5.isRecalled() == true) goto L4;
        if (r5.isBurned() == true) goto L4;
        if (r5.getType() == Message.Type.MERGE_FORWARD) goto L17;
        if (r5.getType() == Message.Type.TEXT) goto L29;
        if (r5.getType() == Message.Type.IMAGE) goto L29;
        if (r5.getType() == Message.Type.POST) goto L29;
        if (h0.j(r5) == true) goto L29;
        if (h0.k(r5) == false) goto L4;
    L29:
        if (r2.getTranslateInfo() == null) goto L33;
        if (r5.getContentVersion() == r2.getTranslateInfo().getMessageContentVersion()) goto L33;
        r3.add(r2);
        r12 = r12 | r2.getMessage().isTranslatedManually();
    L33:
        r1.add(r2);
        goto L4
    L17:
        r0.add(r2);
        goto L4
    L34:
        if (r12 == false) goto L36;
        ITranslateService.TranslateTriggerType r14 = ITranslateService.TranslateTriggerType.MANUAL;
    L38:
        if (CollectionUtils.isEmpty(r0) == true) goto L41;
        batchUpdateMergeForwardTranslate(r0, r11, r14);
    L41:
        if (CollectionUtils.isEmpty(r3) == true) goto L44;
        batchUpdateTranslateState(r3, this.mCurrentChatId, r14, r11, BuildConfig.FLAVOR, true);
    L44:
        if (CollectionUtils.isEmpty(r1) == true) goto L71;
        batchUpdateTranslateState(r1, this.mCurrentChatId, r14, r11, BuildConfig.FLAVOR, false);
        return;
    L71:
        return;
    L36:
        r14 = ITranslateService.TranslateTriggerType.AUTO;
        goto L38
    }

    public void handlePushMergeforwardMessage(fcb.a r11, String r12, List<String> r13) {
        if (CollectionUtils.isEmpty(r11.d) == false) goto L5;
        return;
    L5:
        TranslateState r0 = r11.d.get(r12);
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.getMessage() != null) goto L10;
        return;
    L10:
        if (r0.getMessage().getType() == Message.Type.MERGE_FORWARD) goto L13;
        return;
    L13:
        if (CollectionUtils.isNotEmpty(r11.c) == false) goto L79;
        Iterator<MessageSource> r14 = r11.c.iterator();
    L15:
        Message r2 = null;
        if (r14.hasNext() == false) goto L22;
        MessageSource r1 = r14.next();
        if (TextUtils.equals(r1.source_id, r12) == false) goto L15;
        if (CollectionUtils.isEmpty(r1.message_id_path) == true) goto L15;
        ArrayList r15 = new ArrayList(r1.message_id_path);
    L24:
        if (CollectionUtils.isEmpty(r13) == false) goto L26;
        return;
    L26:
        if (CollectionUtils.isEmpty(r15) == true) goto L103;
        LinkedHashMap r16 = new LinkedHashMap();
        Message r3 = r0.getMessage();
        TranslateInfo r4 = r0.getTranslateInfo();
        int r5 = 1;
    L30:
        if (r5 > r13.size()) goto L71;
        if (r5 >= r15.size()) goto L71;
        String r6 = (String) ListProtector.get(r15, r5);
        if (r3.getType() != Message.Type.MERGE_FORWARD) goto L72;
        MergeForwardContent r7 = (MergeForwardContent) r3.getContent();
        if (r4 != null) goto L40;
        MergeForwardContent r8 = null;
    L42:
        if (r7.getMessages() == null) goto L72;
        if (r8 != null) goto L46;
    L53:
        Message r9 = null;
    L54:
        Iterator<Message> r10 = r7.getMessages().iterator();
    L56:
        if (r10.hasNext() == false) goto L70;
        Message r17 = r10.next();
        if (TextUtils.equals(r6, r17.getId()) == false) goto L56;
        TranslateState r18 = new TranslateState(r6);
        r18.setMessage(r17);
        if (r9 == null) goto L63;
        r18.setTranslateInfo(new TranslateInfo(r6, r9.getTranslateLanguage(), r9.getContent()));
    L63:
        if (r5 != r13.size()) goto L65;
        r16.put(r6, r18);
    L65:
        if (r4 != null) goto L67;
    L69:
        r3 = r17;
        goto L70
    L67:
        if (r4.getSubTranslateInfoMap() == null) goto L69;
        r4 = r4.getSubTranslateInfoMap().get(r6);
    L70:
        r5 = r5 + 1;
        goto L30
    L46:
        if (CollectionUtils.isNotEmpty(r8.getMessages()) == false) goto L53;
        Iterator<Message> r19 = r8.getMessages().iterator();
    L49:
        if (r19.hasNext() == false) goto L53;
        r9 = r19.next();
        if (TextUtils.equals(r6, r9.getId()) == false) goto L49;
    L40:
        r8 = (MergeForwardContent) r4.getTranslateContent();
    L72:
        if (r2 != null) goto L74;
        return;
    L74:
        if (r2 != r0.getMessage()) goto L76;
        return;
    L76:
        if (r16.isEmpty() == true) goto L108;
        handleTranslateResult(r16, getMessageInfoMap(new ArrayList(r16.keySet())), Collections.emptyList());
        return;
    L108:
        return;
    L71:
        r2 = r3;
        goto L72
    L103:
        return;
    L22:
        r15 = null;
        goto L24
    L79:
        Map<String, TranslateState> r110 = getSubMessageTranslateState((MergeForwardContent) r0.getTranslateInfo().getTranslateContent(), (MergeForwardContent) r0.getMessage().getContent(), r13, 0);
        if (r110 != null) goto L83;
        return;
    L83:
        if (CollectionUtils.isEmpty(r110) == true) goto L110;
        handleTranslateResult(r110, getMessageInfoMap(new ArrayList(r110.keySet())), Collections.emptyList());
        return;
    }

    public void setAutoTranslate(final String r3, boolean r4, final IGetDataCallback<Boolean> r5) {
        this.mTranslateService.cb(r4, new AnonymousClass2(this, r3, r5));
    }

    public void translateUrlPreview(Map<String, f5b.b> r4, final String r5, AutoTranslateStatCallback r6) {
        r4.entrySet();
        HashMap r0 = new HashMap();
        HashMap r1 = new HashMap();
        h0.g(r4, r5, r0, r1);
        ITranslateService r7 = this.mTranslateService;
        if (r6 != null) goto L5;
        boolean r8 = true;
    L6:
        r7.W4(r8, r0, r1, new AnonymousClass5(this, r5));
        return;
    L5:
        r8 = false;
        goto L6
    }

    public static /* synthetic */ void access$100(TranslateModelHandler r0, List r1, boolean r2, Map r3) {
        r0.handleTranslating(r1, r2, r3);
    }

    public static /* synthetic */ void access$200(TranslateModelHandler r0, Map r1, Map r2, List r3) {
        r0.handleTranslateResult(r1, r2, r3);
    }

    private Map<String, TranslateState> getSubMessageTranslateState(MergeForwardContent r10, MergeForwardContent r11, List<String> r12, int r13) {
        if (r10 != null) goto L5;
    L43:
        return null;
    L5:
        if (r10.getMessages() == null) goto L43;
        if (r11 == null) goto L43;
        if (r11.getMessages() == null) goto L43;
        int r1 = r13 + 1;
        if (r1 > r12.size()) goto L43;
        HashMap r2 = new HashMap();
        Iterator<Message> r14 = r10.getMessages().iterator();
    L14:
        if (r14.hasNext() == false) goto L42;
        Message r3 = r14.next();
        if (r13 >= (r12.size() - 1)) goto L20;
        if (r3.getType() != Message.Type.MERGE_FORWARD) goto L14;
    L20:
        Iterator<Message> r4 = r11.getMessages().iterator();
        Message r5 = null;
    L22:
        if (r4.hasNext() == false) goto L26;
        Message r6 = r4.next();
        if (TextUtils.equals(r6.getId(), r3.getId()) == false) goto L22;
        r5 = r6;
        goto L22
    L26:
        if (r5 == null) goto L27;
        Message.Type r7 = r5.getType();
        Message.Type r8 = Message.Type.MERGE_FORWARD;
        if (r7 != r8) goto L40;
        if (r3.getType() != r8) goto L40;
        if (r1 >= r12.size()) goto L40;
        if (((String) ListProtector.get(r12, r1)).equals(r5.getId()) == false) goto L40;
        Map<String, TranslateState> r9 = getSubMessageTranslateState((MergeForwardContent) r3.getContent(), (MergeForwardContent) r5.getContent(), r12, r1);
        if (r9 == null) goto L40;
        r2.putAll(r9);
    L40:
        if (r13 != (r12.size() - 1)) goto L14;
        TranslateState r15 = new TranslateState(r5.getId());
        r15.setMessage(r5);
        r15.setTranslateInfo(new TranslateInfo(r5.getId(), r3.getTranslateLanguage(), r3.getContent()));
        r2.put(r3.getId(), r15);
        goto L14
    L27:
        return null;
    L42:
        return r2;
    }

    private void handleTranslateError(Map<String, TranslateState> r11, p r12, boolean r13, boolean r14) {
        if (r12 != null) goto L4;
        return;
    L4:
        int r0 = r11.size();
        Iterator<Map.Entry<String, TranslateState>> r15 = r11.entrySet().iterator();
        int r1 = 1;
        String r5 = BuildConfig.FLAVOR;
        String r6 = r5;
        int r4 = 0;
    L6:
        if (r15.hasNext() == false) goto L20;
        TranslateState r7 = r15.next().getValue();
        if (r4 != 0) goto L11;
        r4 = r7.getErrorCode();
        r5 = r7.getError();
    L13:
        MessageSource r8 = r7.getMessageSource();
        if (r8.source_type != MessageSourceType.MERGE_FORWARD_MESSAGE) goto L16;
        r6 = r8.source_id;
    L18:
        if (((ArrayList) this.translateMsgInfo.a).contains(r6) == true) goto L6;
        r6 = BuildConfig.FLAVOR;
        goto L6
    L16:
        r6 = r7.getMessageId();
        goto L18
    L11:
        if (r4 != r7.getErrorCode()) goto L13;
        r1 = r1 + 1;
        goto L13
    L20:
        TranslateState r16 = new TranslateState();
        if (r0 != r1) goto L23;
        r16.setErrorCode(r4);
        r16.setError(r5);
    L24:
        r16.setMessageId(r6);
        r16.setManual(r13);
        r16.setIsMessageVersionUpdate(r14);
        r12.onError();
        return;
    L23:
        r16.setErrorCode(0);
        goto L24
    }

    private void sendTranslateHitPoint(ITranslateService.TranslateTriggerType r8, String r9, int r10, long r11) {
        long r0 = SystemClock.elapsedRealtime() - r11;
        int r3 = 2;
        boolean r4 = false;
        if (r0 < 1000) goto L14;
        TranslateHitPoint r12 = TranslateHitPoint.a;
        if (r8 == ITranslateService.TranslateTriggerType.AUTO) goto L7;
        boolean r13 = true;
    L8:
        o5c.b r14 = r12.a();
        JSONObject r6 = new JSONObject();
        if (r13 == false) goto L11;
        int r15 = 1;
    L12:
        r14.sendEvent("translate_callback_timeout", r6.put("translateType", r15).put("callback_time", r0).put("translate_count", r10));
        goto L14
    L11:
        r15 = 2;
        goto L12
    L7:
        r13 = false;
    L14:
        if (TextUtils.isEmpty(r9) == true) goto L23;
        TranslateHitPoint r16 = TranslateHitPoint.a;
        if (r8 == ITranslateService.TranslateTriggerType.AUTO) goto L18;
        r4 = true;
    L18:
        r16.getClass();
        Intrinsics.checkNotNullParameter(r9, "error_message");
        o5c.b r17 = r16.a();
        JSONObject r18 = new JSONObject();
        if (r4 == false) goto L21;
        r3 = 1;
    L21:
        r17.sendEvent("translate_error", r18.put("translateType", r3).put("error_message", r9).put("error_count", r10));
        return;
    }

    public void batchUpdateTranslateState(List<f5b.b> r8, ITranslateService.TranslateTriggerType r9, String r10, String r11) {
        ArrayList r1 = new ArrayList();
        Iterator<f5b.b> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        f5b.b r0 = r12.next();
        if (isTranslated(h0.d(r0)) == true) goto L4;
        r1.add(r0);
        goto L4
    L9:
        batchUpdateTranslateState(r1, this.mCurrentChatId, r9, r10, r11, false);
    }

    public boolean handlePushTranslateSetting(String r3, List<String> r4, Integer r5, Map<String, Integer> r6) {
        Log.i(TAG, "onPushTranslateSetting: " + r3 + "/" + r4 + "/" + r5 + "/" + r6);
        boolean r0 = true;
        if (r3 == null) goto L8;
        TranslateLanguageSetting r1 = this.mTranslateSetting;
        if (r1 == null) goto L7;
        r1.setTargetLanguageKey(r3);
    L7:
        boolean r7 = true;
    L9:
        if (r4 == null) goto L11;
        r7 = true;
    L11:
        if (r5 == null) goto L16;
        TranslateLanguageSetting r8 = this.mTranslateSetting;
        if (r8 == null) goto L15;
        r8.setGlobalDisplayConfig(r5.intValue());
    L15:
        r7 = true;
    L16:
        if (r6 != null) goto L19;
        r0 = r7;
    L19:
        if (r0 == false) goto L21;
        clearCache();
    L21:
        return r0;
    L8:
        r7 = false;
        goto L9
    }

    public void translate(final f5b.b r8, String r9, ITranslateService.TranslateTriggerType r10, final IGetDataCallback<Map<String, TranslateState>> r11) {
        String r0 = r8.getId();
        if (PerfChatPerformanceMonitor.c != null) goto L5;
        PerfChatPerformanceMonitor.c = new PerfChatPerformanceMonitor.d();
    L5:
        PerfChatPerformanceMonitor.c.b(r0);
        PerfChatPerformanceMonitor.f(12);
        translate(r8, r9, this.mCurrentChatId, r10, new AnonymousClass3(this, r11, r8));
    }

    public void translateTexts(String[] r3, String r4, String r5, final IGetDataCallback<List<String>> r6) {
        ChatCoreModule.a().getTranslateDependency().b(r4, r5, r3, new AnonymousClass6(this, r6));
    }

    public static /* synthetic */ void access$300(TranslateModelHandler r0, ITranslateService.TranslateTriggerType r1, String r2, int r3, long r4) {
        r0.sendTranslateHitPoint(r1, r2, r3, r4);
    }

    public boolean handlePushTranslateSettingV2(String r3, List<String> r4, Integer r5, Map<String, Integer> r6, Map<String, Integer> r7) {
        Log.i(TAG, "onPushTranslateSetting: " + r3 + "/" + r4 + "/" + r5 + "/" + r6);
        boolean r0 = true;
        if (r3 == null) goto L8;
        TranslateLanguageSetting r1 = this.mTranslateSetting;
        if (r1 == null) goto L7;
        r1.setTargetLanguageKey(r3);
    L7:
        boolean r8 = true;
    L9:
        if (r4 == null) goto L11;
        r8 = true;
    L11:
        if (r5 == null) goto L16;
        TranslateLanguageSetting r9 = this.mTranslateSetting;
        if (r9 == null) goto L15;
        r9.setGlobalDisplayConfig(r5.intValue());
    L15:
        r8 = true;
    L16:
        if (r6 == null) goto L18;
        r8 = true;
    L18:
        if (r7 != null) goto L21;
        r0 = r8;
    L21:
        if (r0 == false) goto L23;
        clearCache();
    L23:
        return r0;
    L8:
        r8 = false;
        goto L9
    }

    public void translate(f5b.b r11, String r12, String r13, ITranslateService.TranslateTriggerType r14, IGetDataCallback<Map<String, TranslateState>> r15) {
        if (this.fgService.isEnable("lark.ai.support_multi_layer_translation") == false) goto L7;
        translateMultiLevelMFMessage(r11, r12, r13, r14, r15, null);
        return;
    L7:
        if (isTrgLanguageOptimizeEnabled(r14) == false) goto L9;
        String r0 = r11.getMessage().getMessageLanguage();
        r12 = this.targetLanguageOptimizer.tryOptimizeTargetLanguage(r0, r12);
    L9:
        String r4 = r12;
        String r16 = h0.d(r11);
        this.mTranslateIdSet.add(r16);
        if (r11.getMessage().getType() != Message.Type.MERGE_FORWARD) goto L48;
        boolean r17 = h0.m(r11.getMessage());
        this.translateMsgInfo.a();
        MessageSource r1 = getMessageSource(r11.getId());
        MergeForwardContent r2 = (MergeForwardContent) r11.getMessage().getContent();
        int r3 = 0;
        if (r2.getMessages() == null) goto L39;
        Iterator<Message> r5 = r2.getMessages().iterator();
    L15:
        if (r5.hasNext() == false) goto L39;
        Message r6 = r5.next();
        if (r6.getType() == Message.Type.TEXT) goto L23;
        if (r6.getType() == Message.Type.POST) goto L23;
        if (r6.getType() != Message.Type.IMAGE) goto L15;
    L23:
        if (TextUtils.equals(r6.getMessageLanguage(), "not_lang") == true) goto L15;
        if (TextUtils.isEmpty(r4) == false) goto L31;
        TranslateLanguageSetting r7 = this.mTranslateSetting;
        if (r7 == null) goto L31;
        String r8 = r7.getTargetLanguageKey();
    L33:
        if (TextUtils.equals(r8, r6.getMessageLanguage()) == true) goto L34;
        if (r17 != h0.m(r6)) goto L15;
        List<String> r9 = this.translateMsgInfo.a;
        ArrayList r10 = (ArrayList) r9;
        r10.add(r6.getId());
        ((ArrayList) this.translateMsgInfo.c).add(r1);
        Map<String, Integer> r18 = this.translateMsgInfo.d;
        HashMap r19 = (HashMap) r18;
        r19.put(r6.getId(), Integer.valueOf(r6.getContentVersion()));
        goto L15
    L34:
        r3 = r3 + 1;
    L31:
        r8 = r4;
    L39:
        if (CollectionUtils.isEmpty(this.translateMsgInfo.a) == false) goto L47;
        if (r15 != null) goto L42;
        return;
    L42:
        if (r3 <= 0) goto L44;
        int r110 = ERROR_CODE_SAME_LANGUAGE;
    L45:
        r15.onError(new ErrorResult(r110, r11.getId()));
        return;
    L44:
        r110 = ERROR_CODE_CANT_TRANSLATE;
        goto L45
    L47:
        HashMap r20 = new HashMap();
        r20.put(r11.getId(), r11);
        c r111 = this.translateMsgInfo;
        translate(r111.a, r20, r14, r4, r111.c, r13, r111.d, false, r15);
        return;
    L48:
        HashMap r21 = new HashMap();
        r21.put(r11.getId(), r11);
        MessageSource r112 = getMessageSource(BuildConfig.FLAVOR);
        this.translateMsgInfo.a();
        List<String> r22 = this.translateMsgInfo.a;
        ArrayList r23 = (ArrayList) r22;
        r23.add(r11.getId());
        ((ArrayList) this.translateMsgInfo.c).add(r112);
        Map<String, Integer> r113 = this.translateMsgInfo.d;
        HashMap r114 = (HashMap) r113;
        r114.put(r11.getId(), Integer.valueOf(r11.getMessage().getContentVersion()));
        c r115 = this.translateMsgInfo;
        translate(r115.a, r21, r14, r4, r115.c, r13, r115.d, false, r15);
        if (r11.getMessage().getType() == Message.Type.AUDIO) goto L51;
        return;
    L51:
        if (h0.n(r11) == true) goto L71;
        TranslateHitPoint.a.a().sendEvent("manually_translate_asr_message", null);
        return;
    }

    private void batchUpdateTranslateState(List<f5b.b> r14, String r15, ITranslateService.TranslateTriggerType r16, String r17, String r18, boolean r19) {
        if (CollectionUtils.isEmpty(r14) == false) goto L6;
        return;
    L6:
        if (NetworkUtils.isNetworkAvailable(ChatCoreModule.a().getContext()) == true) goto L8;
        return;
    L8:
        MessageSource r10 = getMessageSource(r18);
        int r0 = r14.size();
        if (r0 > 5) goto L12;
        updateTranslateState(r14, r15, r16, r17, r10, r19);
        return;
    L12:
        int r11 = r0 - 5;
        int r2 = 0;
    L13:
        if (r2 > r11) goto L15;
        int r12 = r2 + 5;
        updateTranslateState(r14.subList(r2, r12), r15, r16, r17, r10, r19);
        r2 = r12;
        goto L13
    L15:
        if (r2 >= r0) goto L19;
        updateTranslateState(r14.subList(r2, r0), r15, r16, r17, r10, r19);
        return;
    }

    private List<MessageSource> handleNestedMergeForwardMessage(c r20, Message r21, ArrayList<String> r22, String r23, boolean r24, int r25) {
        ArrayList r11 = new ArrayList();
        int r12 = 3;
        if (r25 <= 3) goto L6;
        return r11;
    L6:
        if ((r21.getMessageContent() instanceof MergeForwardContent) == true) goto L8;
        return r11;
    L8:
        MergeForwardContent r13 = (MergeForwardContent) r21.getMessageContent();
        if (r13.getMessages() == null) goto L61;
        Iterator<Message> r14 = r13.getMessages().iterator();
    L12:
        if (r14.hasNext() == false) goto L61;
        Message r15 = r14.next();
        if (r24 == true) goto L15;
        if (msgSupportTranslate(r15) == false) goto L12;
    L22:
        Chat r16 = r13.getOriginChat();
        if (r15.getType() != Message.Type.MERGE_FORWARD) goto L52;
        ArrayList<String> r3 = new ArrayList(r22);
        r3.add(r15.getId());
        List<MessageSource> r0 = handleNestedMergeForwardMessage(r20, r15, r3, r23, r24, r25 + 1);
        if (com.larksuite.framework.utils.q.a(r0) == true) goto L28;
        r11.addAll(r0);
    L28:
        if (this.fgService.isEnable("messenger.message.threadforward_supports_translation") == true) goto L30;
    L35:
        boolean r1 = false;
    L37:
        if (com.larksuite.framework.utils.q.a(r0) == true) goto L60;
        if (r1 == false) goto L60;
        if (this.fgService.isEnable("lark.ai.threadforward.card.mergeforward.transalte.disable") == true) goto L60;
        String r2 = r15.getId();
        Iterator<MessageSource> r4 = r0.iterator();
    L43:
        if (r4.hasNext() == false) goto L60;
        MessageSource r5 = r4.next();
        List r6 = r5.message_id_path;
        if (com.larksuite.framework.utils.q.a(r6) == true) goto L43;
        if (r6.contains(r2) == false) goto L43;
        String r7 = (String) ListProtector.get(r6, r6.size() - 1);
        MessageSource r8 = r5.newBuilder().source_id(r2).message_id_path(r6.subList(r6.indexOf(r2), r6.size())).build();
        ((ArrayList) r20.a).add(r7);
        ((ArrayList) r20.c).add(r8);
    L60:
        r12 = 3;
        goto L12
    L30:
        if (r13.isFromPrivateTopic() == false) goto L35;
        if (r16 == null) goto L35;
        if (r16.isMember() == false) goto L35;
        r1 = true;
        goto L37
    L52:
        ArrayList r9 = new ArrayList(r22);
        r9.add(r15.getId());
        ((ArrayList) r20.a).add(r15.getId());
        MessageSource r10 = getMessageSource(r23, r9);
        ((ArrayList) r20.c).add(r10);
        r11.add(r10);
        ((HashMap) r20.d).put(r15.getId(), Integer.valueOf(r15.getContentVersion()));
        if (this.fgService.isEnable("messenger.message.threadforward_supports_translation") == false) goto L60;
        if (r13.isFromPrivateTopic() == false) goto L60;
        if (r16 == null) goto L60;
        if (r16.isMember() == false) goto L60;
        ((ArrayList) r20.b).add(r15.getId());
        goto L60
    L15:
        int r17 = r15.getTranslateDisplayRule();
        if (r17 == 2) goto L22;
        if (r17 == r12) goto L22;
    L61:
        return r11;
    }

    private void translateMultiLevelMFMessage(f5b.b r14, String r15, String r16, ITranslateService.TranslateTriggerType r17, IGetDataCallback<Map<String, TranslateState>> r18, AutoTranslateStatCallback r19) {
        String r7 = r15;
        String r0 = h0.d(r14);
        this.mTranslateIdSet.add(r0);
        this.translateMsgInfo.a();
        if (r14.getMessage().getType() != Message.Type.MERGE_FORWARD) goto L50;
        int r1 = r14.getMessage().getTranslateDisplayRule();
        Message r3 = r14.getMessage();
        if (r1 != 0) goto L7;
    L19:
        CanMultiMFMsgTranslate r2 = isMultiMFMsgCanTranslate(r3, r15);
        int r4 = a.a[r2.ordinal()];
        if (r4 == 2) goto L29;
        if (r4 != 3) goto L24;
    L39:
        ArrayList<String> r5 = new ArrayList();
        r5.add(r14.getId());
        handleNestedMergeForwardMessage(this.translateMsgInfo, r3, r5, r14.getId(), false, 1);
        if (CollectionUtils.isEmpty(this.translateMsgInfo.a) == false) goto L42;
        return;
    L42:
        if (CollectionUtils.isEmpty(this.translateMsgInfo.c) == true) goto L72;
        HashMap r6 = new HashMap();
        r6.put(r14.getId(), r14);
        if (CollectionUtils.isEmpty(this.translateMsgInfo.b) == true) goto L47;
        c r8 = this.translateMsgInfo;
        List<String> r9 = r8.a;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r8.b);
    L47:
        c r11 = this.translateMsgInfo;
        String r12 = r7;
        translate(r11.a, r6, r17, r12, r11.c, r16, r11.d, false, r18, r19);
        return;
    L72:
        return;
    L24:
        if (r4 != 4) goto L80;
        if (r18 == null) goto L75;
        r18.onError(new ErrorResult(ERROR_CODE_CANT_TRANSLATE, r3.getId()));
        return;
    L75:
        return;
    L80:
        return;
    L29:
        if (isTrgLanguageOptimizeEnabled(r17) == true) goto L33;
        if (r18 == null) goto L70;
        r18.onError(new ErrorResult(ERROR_CODE_LOCAL_SAME_LANGUAGE, r3.getId()));
        return;
    L70:
        return;
    L33:
        String r13 = this.targetLanguageOptimizer.tryOptimizeTargetLanguage(r15, r15);
        if (r13.equals(r15) == false) goto L38;
        if (r18 == null) goto L71;
        r18.onError(new ErrorResult(ERROR_CODE_LOCAL_SAME_LANGUAGE, r3.getId()));
        return;
    L71:
        return;
    L38:
        r7 = r13;
        goto L39
    L7:
        if (r1 == 1) goto L19;
        ArrayList<String> r20 = new ArrayList();
        r20.add(r14.getId());
        handleNestedMergeForwardMessage(this.translateMsgInfo, r3, r20, r14.getId(), true, 1);
        if (CollectionUtils.isEmpty(this.translateMsgInfo.a) == false) goto L12;
        return;
    L12:
        if (CollectionUtils.isEmpty(this.translateMsgInfo.c) == true) goto L69;
        HashMap r21 = new HashMap();
        r21.put(r14.getId(), r14);
        if (CollectionUtils.isEmpty(this.translateMsgInfo.b) == true) goto L17;
        c r22 = this.translateMsgInfo;
        List<String> r23 = r22.a;
        ArrayList r24 = (ArrayList) r23;
        r24.addAll(r22.b);
    L17:
        c r25 = this.translateMsgInfo;
        translate(r25.a, r21, r17, r15, r25.c, r16, r25.d, false, r18, r19);
        return;
    L69:
        return;
    L50:
        if (isTrgLanguageOptimizeEnabled(r17) == false) goto L58;
        if (r7 == null) goto L58;
        String r26 = r14.getMessage().getMessageLanguage();
        String r27 = this.targetLanguageOptimizer.tryOptimizeTargetLanguage(r26, r15);
        if (TextUtils.equals(r27, r26) == false) goto L57;
        if (r18 == null) goto L73;
        r18.onError(new ErrorResult(ERROR_CODE_LOCAL_SAME_LANGUAGE, r14.getId()));
        return;
    L73:
        return;
    L57:
        String r28 = r27;
    L59:
        HashMap r29 = new HashMap();
        r29.put(r14.getId(), r14);
        List<String> r30 = r14.getMsgIdPathList();
        if (CollectionUtils.isNotEmpty(r30) == false) goto L62;
        r30.add(r14.getId());
        MessageSource r31 = getMessageSource((String) ListProtector.get(r30, 0), r30);
    L63:
        List<String> r32 = this.translateMsgInfo.a;
        ArrayList r33 = (ArrayList) r32;
        r33.add(r14.getId());
        ((ArrayList) this.translateMsgInfo.c).add(r31);
        Map<String, Integer> r34 = this.translateMsgInfo.d;
        HashMap r35 = (HashMap) r34;
        r35.put(r14.getId(), Integer.valueOf(r14.getMessage().getContentVersion()));
        c r36 = this.translateMsgInfo;
        translate(r36.a, r29, r17, r28, r36.c, r16, r36.d, false, r18, r19);
        if (r14.getMessage().getType() == Message.Type.AUDIO) goto L66;
        return;
    L66:
        if (h0.n(r14) == true) goto L79;
        TranslateHitPoint.a.a().sendEvent("manually_translate_asr_message", null);
        return;
    L79:
        return;
    L62:
        r31 = getMessageSource(BuildConfig.FLAVOR);
    L58:
        r28 = r7;
        goto L59
    }

    private void updateTranslateState(List<f5b.b> r12, String r13, ITranslateService.TranslateTriggerType r14, String r15, MessageSource r16, boolean r17) {
        HashMap r2 = new HashMap();
        HashMap r7 = new HashMap();
        Iterator<f5b.b> r0 = r12.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        f5b.b r1 = r0.next();
        String r3 = r1.getMessage().getId();
        if (TextUtils.isEmpty(r3) == true) goto L4;
        r2.put(r3, r1);
        r7.put(r3, Integer.valueOf(r1.getMessage().getContentVersion()));
        goto L4
    L10:
        if (CollectionUtils.isEmpty(r2) == false) goto L12;
        return;
    L12:
        List<String> r4 = new ArrayList(r2.keySet());
        ArrayList r5 = new ArrayList();
        r5.add(r16);
        translate(r4, r2, r14, r15, r5, r13, r7, r17, null, new AutoTranslateStatCallback(r2, null));
    }

    public void translate(List<String> r12, Map<String, f5b.b> r13, ITranslateService.TranslateTriggerType r14, String r15, List<MessageSource> r16, String r17, Map<String, Integer> r18, boolean r19, IGetDataCallback<Map<String, TranslateState>> r20) {
        translate(r12, r13, r14, r15, r16, r17, r18, r19, r20, null);
    }

    private void translate(final List<String> r15, final Map<String, f5b.b> r16, final ITranslateService.TranslateTriggerType r17, String r18, List<MessageSource> r19, String r20, Map<String, Integer> r21, boolean r22, final IGetDataCallback<Map<String, TranslateState>> r23, final AutoTranslateStatCallback r24) {
        final long r5 = SystemClock.elapsedRealtime();
        Log.i(TAG, "translate message size:" + r15.size() + "translate message list:" + r15 + "target lan:" + r18);
        this.mTranslateService.jf(r15, r17, r18, r19, r20, r21, r22, new AnonymousClass4(this, r16, r17, r15, r5, r23, r24));
        translateUrlPreview(r16, r18, r24);
    }
}
