package com.suite.lark.platform.feature.forward.doubao.assembly.dependency;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.auditsdk.v2.utils.AuditUtilsV2;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.im.api.StickerContent;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.forwardv3.configuration.dto.StickImage;
import com.ss.android.lark.forwardv3.configuration.listener.OnCustomForwardConfirmDialogContentView;
import com.ss.android.lark.forwardv3.dependency.ExternalForwardDirection;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.picker.base.view.avatar.ExternalTargetAvatarProvider;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.RichText;
import com.suite.lark.platform.feature.forward.doubao.DoubaoForwardPicker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import mpc.e;
import tib.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ClaymoreImpl(g.class)
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 K2\u00020\u0001:\u0003KLMB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J2\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0016J\b\u0010#\u001a\u00020\u0016H\u0016J\u0012\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0016J\"\u0010&\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00162\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0016J*\u0010&\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\b\u0010(\u001a\u0004\u0018\u00010\u001fH\u0016J\u0018\u0010+\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0016H\u0016J\b\u0010-\u001a\u00020\u0016H\u0016J*\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002000/2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u000202\u0018\u00010/H\u0016J\b\u00103\u001a\u00020\u0016H\u0016J\u001a\u00104\u001a\u0004\u0018\u0001052\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u000107H\u0016J\b\u00108\u001a\u00020\u001cH\u0016J\u0018\u00109\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0016H\u0016J\"\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140/2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001607H\u0002J\b\u0010<\u001a\u00020\u0012H\u0016J\b\u0010=\u001a\u00020\u0012H\u0016J\n\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010@\u001a\u00020\u0016H\u0016J@\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00162\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u0016072\u0006\u0010F\u001a\u00020\u00162\u0006\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\u0016H\u0016J\n\u0010I\u001a\u0004\u0018\u00010JH\u0002¨\u0006N"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/assembly/dependency/ForwardNewDependency;", "Lcom/ss/android/lark/forwardv3/dependency/IForwardNewDependency;", "<init>", "()V", "createForwardChatPicker", "Lcom/ss/android/lark/forwardv3/dependency/ForwardChatPickerHolder;", "context", "Landroid/content/Context;", "showSquareMessageStickerThumb", "", "imageView", "Landroid/widget/ImageView;", LoadParams.ImageFormat.IMAGE, "Lcom/ss/android/lark/forwardv3/configuration/dto/StickImage;", "attachGlobalWatermark", "dialog", "Landroid/app/Dialog;", "hasFilePreviewPermissionFromMessage", "", INotificationHitPoint.NoticeType.MESSAGE, "Lcom/ss/android/lark/chat/entity/message/Message;", "getLoginUserId", "", "startCreateGroup", "fragment", "Landroidx/fragment/app/Fragment;", "isEnableChatPreview", "requestCode", "", "startCreateGroupWithFilter", "param", "Landroid/os/Bundle;", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getCreateGroupChatResultKey", "showNoIMPermissionDialog", "msg", "go2Chat", "chatId", "bundle", "chatMode", "Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "go2Thread", "threadId", "getAppLinkDomain", "getChatterMap", "", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "recommendAtList", "Lcom/bytedance/lark/pb/basic/v1/Chatter;", "getCreateGroupSelectedDataKey", "getEventParams", "Lcom/ss/android/lark/forwardv3/statistics/EventParamsV3;", "messageIds", "", "getLoginUserAuthorityDeniedReason", "startProfile", "userid", "getMessageByIds", "isEnterSendEnabled", "isDoubaoWorkTabEnabled", "getExternalTargetItem", "Lcom/ss/android/lark/forwardv3/dependency/ExternalTargetItem;", "getExternalTargetId", "getExternalForwardExecutor", "Lcom/ss/android/lark/forwardv3/dependency/IExternalForwardExecutor;", "direction", "Lcom/ss/android/lark/forwardv3/dependency/ExternalForwardDirection;", "quasiTitle", "sourceChatId", "isThreadRootMsg", "originMergeForwardId", "getDoubaoForwardProtocol", "Lcom/suite/lark/platform/feature/forward/doubao/api/IDoubaoForwardProtocal;", "Companion", "LarkToDoubaoExternalForwardExecutor", "MockExternalForwardExecutor", "forward-doubao-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardNewDependency implements g {
    private static final a Companion = null;
    private static final long MOCK_EXECUTE_DELAY_MS = 1000;
    private static final String TAG = "ForwardNewDependency";

    public static final class LarkToDoubaoExternalForwardExecutor implements IExternalForwardExecutor {
        public final e a;
        public final String b;
        public final List<String> c;
        public final String d;
        public final boolean e;
        public final String f;

        public LarkToDoubaoExternalForwardExecutor(e r2, String r3, List<String> r4, String r5, boolean r6, String r7) {
            Intrinsics.checkNotNullParameter(r3, "quasiTitle");
            Intrinsics.checkNotNullParameter(r4, "messageIds");
            Intrinsics.checkNotNullParameter(r5, "sourceChatId");
            Intrinsics.checkNotNullParameter(r7, "originMergeForwardId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        @Override // com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor
        public final void a(CoroutineScope r8, Context r9, List<? extends SearchBaseInfo> r10, String r11, RichText r12, IExternalForwardExecutor.a r13) {
            Intrinsics.checkNotNullParameter(r8, "scope");
            Intrinsics.checkNotNullParameter(r9, "context");
            Intrinsics.checkNotNullParameter(r10, "items");
            Intrinsics.checkNotNullParameter(r11, "note");
            Intrinsics.checkNotNullParameter(r12, "richText");
            Intrinsics.checkNotNullParameter(r13, "callback");
            e r1 = this.a;
            if (r1 != null) goto L6;
            r13.onFailure("doubao forward protocol is null");
            return;
        L6:
            List<String> r14 = this.c;
            ArrayList r2 = new ArrayList();
            Iterator<T> r15 = r14.iterator();
        L8:
            if (r15.hasNext() == false) goto L13;
            Object r16 = r15.next();
            if ((!StringsKt.isBlank((String) r16)) == false) goto L8;
            r2.add(r16);
            goto L8
        L13:
            if (r2.isEmpty() == false) goto L16;
            r13.onFailure("lark message is empty");
            return;
        L16:
            BuildersKt.launch$default(r8, null, null, new ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1(r1, r2, r11, this, r13, null), 3, null);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b implements IExternalForwardExecutor {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ExternalForwardDirection.values().length];
            r0[ExternalForwardDirection.DOUBAO_TO_LARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ExternalForwardDirection.LARK_TO_DOUBAO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class d implements ExternalTargetAvatarProvider {
        public final /* synthetic */ e a;

        public d(e r1) {
            this.a = r1;
        }

        public final Drawable createDrawable() {
            return this.a.K0().c;
        }
    }

    static {
        Companion = new a();
    }

    public ForwardNewDependency() {
    }

    public OnCustomForwardConfirmDialogContentView getDoubaoForwardConfirmDialogContentView() {
        return null;
    }

    @Override // tib.g
    public String getExternalTargetId() {
        return "doubao_external_forward_target";
    }

    @Override // tib.g
    public boolean isDoubaoWorkTabEnabled() {
        return true;
    }

    @Override // tib.g
    public void startProfile(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "userid");
    }

    private final e getDoubaoForwardProtocol() {
        return (e) OfficeSDKManager.getHostGlobalService(e.class);
    }

    @Override // tib.g
    public String getCreateGroupChatResultKey() {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getCreateGroupChatResultKey();
    }

    @Override // tib.g
    public String getCreateGroupSelectedDataKey() {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getCreateGroupSelectedDataKey();
    }

    @Override // tib.g
    public tib.a getExternalTargetItem() {
        e r1 = getDoubaoForwardProtocol();
        if (r1 != null) goto L30;
        return null;
    L30:
        mpc.a r3 = r1.K0();     // Catch: Throwable -> L7
    L9:
        StringBuilder r4 = new StringBuilder("getExternalTargetItem: getDoubaoForwardItem iconDrawable==null? ");
        if (r3 == null) goto L12;
        Drawable r5 = r3.c;
    L13:
        if (r5 != null) goto L15;
        boolean r6 = true;
    L16:
        r4.append(r6);
        Log.i(TAG, r4.toString());
        if (r3 != null) goto L20;
        return null;
    L20:
        if (StringsKt.isBlank(r3.a) == false) goto L22;
    L28:
        Log.w(TAG, "getExternalTargetItem skip: invalid doubao forward item");
        return null;
    L22:
        if (StringsKt.isBlank(r3.b) == true) goto L28;
        if (r3.c == null) goto L28;
        return new tib.a(new d(r1), r3.b);
    L15:
        r6 = false;
        goto L16
    L12:
        r5 = null;
    L7:
        th = move-exception;
        Log.e(TAG, "get doubao forward item failed", th);
        r3 = null;
        goto L9
    }

    @Override // tib.g
    public String getLoginUserId() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
    }

    @Override // tib.g
    public boolean isEnterSendEnabled() {
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).isEnterSendEnabled();
    }

    @Override // tib.g
    public String getAppLinkDomain() {
        String r0 = jcb.b.c().a("applink");
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // tib.g
    public int getLoginUserAuthorityDeniedReason() {
        owa.a.b().getClass();
        return 10;
    }

    private final Map<String, Message> getMessageByIds(List<String> r3) {
        ArrayList r0 = new ArrayList();
        Iterator<String> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        String r1 = r4.next();
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return ImSdkService.f().ta(r0);
    }

    @Override // tib.g
    public void attachGlobalWatermark(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        ljb.a.a().attachGlobalWatermark(r2);
    }

    @Override // tib.g
    public tib.c createForwardChatPicker(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        DoubaoForwardPicker r0 = new DoubaoForwardPicker(r2);
        return new tib.c(r0, r0);
    }

    @Override // tib.g
    public Map<String, Chatter> getChatterMap(Map<String, com.bytedance.lark.pb.basic.v1.Chatter> r2) {
        return ((IIMApi) ApiUtils.getApi(IIMApi.class)).getChatterMap(r2);
    }

    @Override // tib.g
    public zib.a getEventParams(List<String> r8) {
        String r2 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
        List<String> r0 = r8;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        Map<String, Message> r6 = getMessageByIds(r8);
        if (CollectionUtils.isEmpty(r6) == false) goto L15;
        String r3 = null;
    L17:
        if (CollectionUtils.isEmpty(r6) == false) goto L19;
        String r4 = null;
    L20:
        Chat r9 = ((IIMApi) ApiUtils.getApi(IIMApi.class)).getChatById(r3);
        if (r9 == null) goto L25;
        Chat.Type r10 = r9.getType();
        if (r10 == null) goto L25;
        int r5 = r10.getNumber();
    L27:
        return new zib.a(r2, r3, r4, r5, r6);
    L25:
        r5 = -1;
        goto L27
    L19:
        r4 = ((Message) CollectionsKt.first(r6.values())).getThreadId();
        goto L20
    L15:
        r3 = ((Message) CollectionsKt.first(r6.values())).getChatId();
        goto L17
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    @Override // tib.g
    public boolean hasFilePreviewPermissionFromMessage(Message r5) {
        if (r5 != null) goto L5;
        return true;
    L5:
        boolean r1 = !owa.a.c().i(true);
        String r2 = getLoginUserId();
        if (TextUtils.isEmpty(r5.getOriginalSenderId()) == true) goto L8;
        String r3 = r5.getOriginalSenderId();
    L10:
        if (TextUtils.equals(r2, r3) == false) goto L13;
        Lazy r4 = AuditUtilsV2.a;
        if (AuditUtilsV2.b() == true) goto L13;
        return true;
    L13:
        if (r1 == true) goto L15;
        return true;
    L15:
        if (r5.getType() != Message.Type.MEDIA) goto L17;
    L25:
        return false;
    L17:
        if (r5.getType() == Message.Type.IMAGE) goto L25;
        if (r5.getType() == Message.Type.FILE) goto L25;
        if (r5.getType() == Message.Type.FOLDER) goto L25;
        if (r5.getType() == Message.Type.STICKER) goto L25;
        return true;
    L8:
        r3 = r5.getFromId();
        goto L10
    }

    public String resolveDoubaoQuasiTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "quasiTitle");
        return r2;
    }

    @Override // tib.g
    public void showNoIMPermissionDialog(String r2) {
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.showNoIMPermissionDialog(r2);
    }

    @Override // tib.g
    public void go2Thread(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "threadId");
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L5;
        return;
    L5:
        l1.a r1 = new l1.a();
        r1.e = r4;
        r1.w = Boolean.TRUE;
        r0.openReplyInThread(r3, new l1(r1));
    }

    @Override // tib.g
    public void go2Chat(Context r3, String r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "chatId");
        if (Intrinsics.areEqual(r4, "doubao_external_forward_target") == false) goto L7;
        e r6 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r6 == null) goto L12;
        r6.D0();
        return;
    L12:
        return;
    L7:
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L10;
        return;
    L10:
        ChatBundle.a r1 = new ChatBundle.a();
        r1.a = r4;
        r1.x = r5;
        r1.b(Boolean.TRUE);
        r0.openChat(r3, new ChatBundle(r1));
    }

    @Override // tib.g
    public void showSquareMessageStickerThumb(Context r6, ImageView r7, StickImage r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "imageView");
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r8 == null) goto L6;
        String r2 = r8.a;
        if (r2 == null) goto L6;
    L7:
        int r3 = 0;
        if (r8 == null) goto L10;
        int r4 = r8.b;
    L11:
        if (r8 == null) goto L13;
        r3 = r8.c;
    L13:
        r0.showSquareMessageStickerThumb(r6, r7, new StickerContent(r2, r4, r3));
        return;
    L10:
        r4 = 0;
    L6:
        r2 = "";
        goto L7
    }

    @Override // tib.g
    public void startCreateGroup(Fragment r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.openCreateGroupChatModuleForForward(r2, r3, r4);
    }

    @Override // tib.g
    public void go2Chat(Context r3, String r4, Chat.ChatMode r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "chatId");
        Intrinsics.checkNotNullParameter(r5, "chatMode");
        if (Intrinsics.areEqual(r4, "doubao_external_forward_target") == false) goto L7;
        e r7 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r7 == null) goto L12;
        r7.D0();
        return;
    L12:
        return;
    L7:
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L10;
        return;
    L10:
        ChatBundle.a r1 = new ChatBundle.a();
        r1.a = r4;
        r1.x = r6;
        r1.a(r5);
        r1.b(Boolean.TRUE);
        r0.openChat(r3, new ChatBundle(r1));
    }

    @Override // tib.g
    public void startCreateGroupWithFilter(Context r2, Fragment r3, Bundle r4, IGetDataCallback<Chat> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "param");
        IIMApi r0 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r0 != null) goto L5;
        return;
    L5:
        r0.createGroupChatFromForward(r2, r3, r4, r5);
    }

    @Override // tib.g
    public IExternalForwardExecutor getExternalForwardExecutor(ExternalForwardDirection r9, String r10, List<String> r11, String r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "direction");
        Intrinsics.checkNotNullParameter(r10, "quasiTitle");
        Intrinsics.checkNotNullParameter(r11, "messageIds");
        Intrinsics.checkNotNullParameter(r12, "sourceChatId");
        Intrinsics.checkNotNullParameter(r14, "originMergeForwardId");
        int r15 = c.a[r9.ordinal()];
        if (r15 == 1) goto L10;
        if (r15 != 2) goto L8;
        return new LarkToDoubaoExternalForwardExecutor(getDoubaoForwardProtocol(), r10, r11, r12, r13, r14);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return new DoubaoToLarkExternalForwardExecutor(com.suite.lark.platform.feature.forward.doubao.assembly.d.a());
    }
}
