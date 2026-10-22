package com.larus.bmhome.chat.model;

import android.app.Application;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.auth.ConvRecommendBotConf;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.BotOnBoarding;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.MainBotModelStore;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.setting.IUserSettingCacheService;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.trace.appreciable.ConversationPageTrace;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.bot.ShowTagInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.conversation.ParticipantModel;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.legacy.NativeConversationServiceImpl;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.api.m4;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.UserConfigItem;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IVipFeatureService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ConversationListModel implements com.larus.bmhome.chat.api.w {
    public static boolean A;
    public static volatile boolean B;
    public static final ConversationListModel a = null;
    public static final ExecutorCoroutineDispatcher b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static PreLoginState e;
    public static CompletableDeferred<Boolean> f;
    public static final BotRepo g = null;
    public static final CopyOnWriteArrayList<wh8.b> h = null;
    public static final CopyOnWriteArrayList<Function0<Unit>> i = null;
    public static final ConcurrentHashMap<String, com.larus.im.service.d0<wc9.e>> j = null;
    public static final ConcurrentHashMap<String, BotModel> k = null;
    public static final ConcurrentHashMap<String, Pair<Message, String>> l = null;
    public static final ConcurrentHashMap<String, wc9.e> m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final c p = null;
    public static final List<wh8.a> q = null;
    public static boolean r;
    public static kotlinx.coroutines.channels.a s;
    public static Job t;
    public static CopyOnWriteArrayList<gr9.b> u;
    public static boolean v;
    public static boolean w;
    public static boolean x;
    public static int y;
    public static boolean z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/chat/model/ConversationListModel$PreLoginState;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "TOURIST", "ON_LOGIN", "ON_MINOR_IN", "ON_MINOR_OUT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum PreLoginState extends Enum<PreLoginState> {
        public static final PreLoginState NORMAL = null;
        public static final PreLoginState ON_LOGIN = null;
        public static final PreLoginState ON_MINOR_IN = null;
        public static final PreLoginState ON_MINOR_OUT = null;
        public static final PreLoginState TOURIST = null;
        public static final /* synthetic */ PreLoginState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PreLoginState> getEntries() {
            return b;
        }

        static {
            PreLoginState r0 = new PreLoginState("NORMAL", 0);
            NORMAL = r0;
            PreLoginState r1 = new PreLoginState("TOURIST", 1);
            TOURIST = r1;
            PreLoginState r3 = new PreLoginState("ON_LOGIN", 2);
            ON_LOGIN = r3;
            PreLoginState r5 = new PreLoginState("ON_MINOR_IN", 3);
            ON_MINOR_IN = r5;
            PreLoginState r7 = new PreLoginState("ON_MINOR_OUT", 4);
            ON_MINOR_OUT = r7;
            PreLoginState[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static PreLoginState[] values() {
            return (PreLoginState[]) a.clone();
        }

        public static PreLoginState valueOf(String r1) {
            return (PreLoginState) r27.a.a(PreLoginState.class, r1);
        }

        public PreLoginState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        public final void a(com.larus.platform.api.c r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            FLogger.a.i("ConversationListModel", "onLogIn and clearConversationData preLoginState=" + ConversationListModel.e + " c_uid=" + r4.b);
            if (ConversationListModel.e != PreLoginState.TOURIST) goto L5;
            ConversationListModel.h(ConversationListModel.a);
            CompletableDeferred r5 = wr8.b.a;
            wr8.b.a.a("onLogIn");
        L5:
            i3.a.e();
        }

        public final void b(com.larus.platform.api.c r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            FLogger.a.i("ConversationListModel", "onLogout and clearConversationData c_uid=" + r4.b);
            ConversationListModel.h(ConversationListModel.a);
            ConversationListModel.e = PreLoginState.ON_LOGIN;
            CompletableDeferred r5 = wr8.b.a;
            wr8.b.a.a("onLogout");
        }
    }

    public static final class b implements m4 {
        public b() {
        }

        public final void S1() {
            FLogger.a.i("ConversationListModel", "onMinorModeOn");
            ConversationListModel.h(ConversationListModel.a);
            CompletableDeferred r0 = wr8.b.a;
            wr8.b.a.a("onMinorIn");
        }

        public final void b1() {
            FLogger.a.i("ConversationListModel", "onMinorModeOff");
            ConversationListModel.h(ConversationListModel.a);
            CompletableDeferred r0 = wr8.b.a;
            wr8.b.a.a("onLogIn");
        }
    }

    public static final class c implements com.larus.im.service.z<List<? extends wc9.e>> {
        public c() {
        }

        public final void c(Object r6) {
            List r7 = (List) r6;
            Intrinsics.checkNotNullParameter(r7, "conversation");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder(" receive conversation list change: size=");
            r1.append(r7.size());
            r1.append(' ');
            List r2 = r7;
            ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
            Iterator r4 = r2.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r3.add(((wc9.e) r4.next()).a);
            goto L4
        L6:
            r1.append(r3);
            r0.w("ConversationListModel_IMSDK", r1.toString());
            ConversationListModel.a.getClass();
            ConversationListModel.H(r7);
            kotlinx.coroutines.channels.a r5 = ConversationListModel.s;
            if (r5 == null) goto L9;
            r5.trySend-JP2dKIU(r7);
        L9:
            IVipFeatureService r8 = (IVipFeatureService) ConversationListModel.n.getValue();
            if (r8 == null) goto L14;
            r8.a();
            return;
        }
    }

    public static final class d implements IIMCallback<wc9.j> {
        public final /* synthetic */ String a;

        public final boolean mustInMain() {
            return false;
        }

        public d(String r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("ConversationListModel_IMSDK", "loadMoreConversation source=" + this.a + " failed: " + r4);
            ConversationListModel.w = false;
        }

        public final void onSuccess(Object r8) {
            wc9.j r9 = (wc9.j) r8;
            Intrinsics.checkNotNullParameter(r9, "result");
            ConversationListModel r0 = ConversationListModel.a;
            ConversationListModel.t = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), ConversationListModel.b, null, new ConversationListModel$loadMoreConversation$1$onSuccess$1(this.a, r9, null), 2, null);
        }
    }

    public static final class e implements IIMCallback<wc9.j> {
        public final /* synthetic */ String a;

        public final boolean mustInMain() {
            return false;
        }

        public e(String r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("ConversationListModel_IMSDK", "queryConversationInfoFromSdkV2 source=" + this.a + " failed: " + r4);
            CompletableDeferred<Boolean> r5 = ConversationListModel.f;
            if (r5 == null) goto L6;
            r5.complete(Boolean.TRUE);
            return;
        }

        public final void onSuccess(Object r8) {
            wc9.j r9 = (wc9.j) r8;
            Intrinsics.checkNotNullParameter(r9, "result");
            ConversationListModel r0 = ConversationListModel.a;
            ConversationListModel.t = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), ConversationListModel.b, null, new ConversationListModel$queryConversationInfoFromSdk$1$onSuccess$1(this.a, r9, null), 2, null);
        }
    }

    public ConversationListModel() {
    }

    public static void z() {
        f = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        IFlowChatThemeConfigProvider r1 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r1 == null) goto L5;
        r1.a(new p0(), AdaptThemeFeatureKey.CHAT_CONVERSATION_LIST_RECOMMEND_BOT_REFRESH);
    L5:
        ((com.larus.im.service.q) c.getValue()).registerConversationChangeListener(p);
        if (s != null) goto L9;
        s = kotlinx.coroutines.channels.b.a(CoroutineScopeKt.MainScope(), b, Integer.MAX_VALUE, new ConversationListModel$initDataActor$1(null), 12);
        return;
    }

    static {
        a = new ConversationListModel();
        b = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new q0()));
        c = LazyKt.lazy(new r0());
        d = LazyKt.lazy(new s0());
        RepoDispatcher.a.getClass();
        g = RepoDispatcher.g;
        h = new CopyOnWriteArrayList();
        i = new CopyOnWriteArrayList();
        j = new ConcurrentHashMap();
        k = new ConcurrentHashMap();
        l = new ConcurrentHashMap();
        m = new ConcurrentHashMap();
        n = LazyKt.lazy(new h0());
        o = LazyKt.lazy(new i0());
        p = new c();
        q = Collections.synchronizedList(new ArrayList());
        x = true;
        FLogger.a.d("ConversationListModel", "init");
        AccountService r1 = AccountService.a;
        r1.E(new a());
        r1.H(new b());
        y = 1;
    }

    public static List l() {
        ArrayList r0 = new ArrayList();
        String r6 = null;
        if (((Boolean) ic8.n.a.getValue()).booleanValue() == false) goto L62;
        List r1 = q();
        wh8.a r7 = (wh8.a) CollectionsKt.firstOrNull(r1);
        StringBuilder r8 = new StringBuilder();
        r8.append(AppHost.a.getApplication().getString(2131908262));
        r8.append(" (");
        ArrayList r9 = (ArrayList) r1;
        r8.append(r9.size());
        r8.append(')');
        String r14 = r8.toString();
        if (r7 == null) goto L9;
        wc9.e r10 = r7.a;
        if (r10 == null) goto L9;
        IconImage r13 = r10.b;
    L10:
        if (r7 == null) goto L14;
        wc9.e r11 = r7.a;
        if (r11 == null) goto L14;
        long r32 = r11.u;
    L15:
        Iterator r12 = r9.iterator();
        int r15 = 0;
    L17:
        if (r12.hasNext() == false) goto L25;
        wc9.e r16 = ((wh8.a) r12.next()).a;
        if (r16 == null) goto L23;
        Integer r17 = r16.l;
        if (r17 == null) goto L23;
        int r18 = r17.intValue();
    L24:
        r15 = r15 + r18;
    L23:
        r18 = 0;
        goto L24
    L25:
        Iterator r19 = r9.iterator();
        int r24 = 0;
    L27:
        if (r19.hasNext() == false) goto L36;
        wc9.e r110 = ((wh8.a) r19.next()).a;
        if (r110 == null) goto L33;
        Integer r111 = r110.m;
        if (r111 == null) goto L33;
        int r112 = r111.intValue();
    L34:
        r24 = r24 + r112;
    L33:
        r112 = 0;
        goto L34
    L36:
        if (r9.isEmpty() == false) goto L38;
        int r20 = 2;
    L39:
        wc9.e r52 = new wc9.e("chat_only_cell", r13, r14, null, null, null, null, null, false, null, null, Integer.valueOf(r15), Integer.valueOf(r24), null, null, null, null, null, null, Integer.valueOf(r20), r32, null, null, null, null, null, null, null, null, null, null, 2, 0, null, null, 0, 2145904632, 63);
        if (r7 == null) goto L42;
        Message r37 = r7.c;
    L43:
        if (r7 == null) goto L47;
        wc9.e r21 = r7.a;
        if (r21 == null) goto L47;
        String r38 = r21.c;
    L49:
        if (r7 == null) goto L53;
        wc9.e r22 = r7.a;
        if (r22 == null) goto L53;
        String r42 = r22.a;
    L55:
        if (r9.size() < 2) goto L59;
        wc9.e r2 = ((wh8.a) ListProtector.get(r1, 1)).a;
        if (r2 == null) goto L59;
        IconImage r43 = r2.b;
    L60:
        r0.add(new wh8.a(r52, null, r37, r38, null, null, null, r42, r43, null, null, false, 3698));
    L59:
        r43 = null;
    L53:
        r42 = null;
    L47:
        r38 = null;
        goto L49
    L42:
        r37 = null;
        goto L43
    L38:
        r20 = 1;
    L14:
        r32 = 0;
    L9:
        r13 = null;
    L62:
        if (((Boolean) ic8.n.b.getValue()).booleanValue() == false) goto L149;
        List<wh8.a> r3 = q;
        monitor-enter(r3);
        Iterator<T> r4 = r3.iterator();     // Catch: Throwable -> L146
    L67:
        if (r4.hasNext() == false) goto L71;
        Object r5 = r4.next();     // Catch: Throwable -> L146
        if (ic8.n.w(((wh8.a) r5).a) == false) goto L67;
    L72:
        wh8.a r23 = (wh8.a) r5;     // Catch: Throwable -> L146
        monitor-exit(r3);
        if (r23 == null) goto L149;
        a.getClass();
        List r25 = s();
        wh8.a r26 = (wh8.a) CollectionsKt.firstOrNull(r25);
        wc9.e r27 = r23.a;
        if (r27 == null) goto L79;
        String r28 = r27.a;
        if (r28 == null) goto L79;
    L80:
        String r29 = r28;
        ArrayList r30 = (ArrayList) r25;
        int r31 = r30.size();
        if (r31 > 0) goto L87;
        AppHost.Companion r33 = AppHost.a;
        Application r34 = r33.getApplication();
        if (r33.isOversea() == false) goto L85;
        int r35 = 2131900621;
    L86:
        String r36 = r34.getString(r35);
    L92:
        String r113 = r36;
        Intrinsics.checkNotNull(r113);
        wc9.e r39 = r23.a;
        if (r39 == null) goto L95;
        IconImage r114 = r39.b;
    L96:
        if (r39 == null) goto L98;
        Integer r115 = r39.e;
    L99:
        if (r26 == null) goto L103;
        wc9.e r40 = r26.a;
        if (r40 == null) goto L103;
        long r116 = r40.u;
    L104:
        if (r39 == null) goto L106;
        long r41 = r39.u;
    L107:
        long r210 = Math.max(r116, r41);
        Iterator r44 = r30.iterator();
        int r211 = 0;
    L109:
        if (r44.hasNext() == false) goto L117;
        wc9.e r45 = ((wh8.a) r44.next()).a;
        if (r45 == null) goto L115;
        Integer r46 = r45.l;
        if (r46 == null) goto L115;
        int r47 = r46.intValue();
    L116:
        r211 = r211 + r47;
    L115:
        r47 = 0;
        goto L116
    L117:
        Iterator r48 = r30.iterator();
        int r49 = 0;
    L119:
        if (r48.hasNext() == false) goto L127;
        wc9.e r50 = ((wh8.a) r48.next()).a;
        if (r50 == null) goto L125;
        Integer r51 = r50.m;
        if (r51 == null) goto L125;
        int r53 = r51.intValue();
    L126:
        r49 = r49 + r53;
    L125:
        r53 = 0;
        goto L126
    L127:
        wc9.e r54 = r23.a;
        if (r54 == null) goto L130;
        String r212 = r54.s;
    L131:
        wc9.e r55 = new wc9.e(r29, r114, r113, null, r115, null, null, null, false, null, null, Integer.valueOf(r211), Integer.valueOf(r49), null, null, null, null, null, r212, 1, r210, null, null, null, null, null, null, null, null, null, null, 1, 0, null, null, 0, 2145642472, 63);
        if (r26 == null) goto L134;
        Message r310 = r26.c;
    L135:
        if (r26 == null) goto L139;
        wc9.e r56 = r26.a;
        if (r56 == null) goto L139;
        String r311 = r56.c;
    L141:
        if (r26 == null) goto L145;
        wc9.e r57 = r26.a;
        if (r57 == null) goto L145;
        r6 = r57.a;
    L145:
        r0.add(new wh8.a(r55, null, r310, r311, null, null, null, r6, null, null, null, false, 3954));
    L139:
        r311 = null;
        goto L141
    L134:
        r310 = null;
        goto L135
    L130:
        r212 = null;
        goto L131
    L106:
        r41 = 0;
    L103:
        r116 = 0;
        goto L104
    L98:
        r115 = null;
        goto L99
    L95:
        r114 = null;
        goto L96
    L85:
        r35 = 2131901362;
        goto L86
    L87:
        StringCompanionObject r58 = StringCompanionObject.INSTANCE;
        AppHost.Companion r59 = AppHost.a;
        Application r117 = r59.getApplication();
        if (r59.isOversea() == false) goto L90;
        int r60 = 2131900622;
    L91:
        r36 = String.format(r117.getString(r60), Arrays.copyOf(new Object[]{Integer.valueOf(r31)}, 1));
        goto L92
    L90:
        r60 = 2131901361;
    L79:
        r28 = "";
        goto L80
    L71:
        r5 = null;
    L146:
        th = move-exception;
        throw th;
    L149:
        return r0;
    }

    public static List q() {
        List<wh8.a> r0 = q;
        monitor-enter(r0);
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L13
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();     // Catch: Throwable -> L13
        if (ic8.n.l(((wh8.a) r3).a) == false) goto L6;
        r2.add(r3);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(r0);
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    public static List s() {
        List<wh8.a> r0 = q;
        monitor-enter(r0);
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L13
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();     // Catch: Throwable -> L13
        if (ic8.n.y(((wh8.a) r3).a) == false) goto L6;
        r2.add(r3);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(r0);
        return r2;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.bmhome.chat.api.w
    public final boolean c() {
        return v;
    }

    public static void A(String r4) {
        FLogger.a.d("ConversationListModel_IMSDK", "queryConversationInfoFromSdk start, source=" + r4);
        ((com.larus.im.service.r) d.getValue()).getConversationList(new wc9.o(null, 20, null, 9), new e(r4));
    }

    public static void D(String r4) {
        Iterator<wh8.a> r0 = q.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        wc9.e r2 = r0.next().a;
        if (r2 == null) goto L8;
        String r3 = r2.a;
    L10:
        if (Intrinsics.areEqual(r3, r4) == true) goto L14;
        r1 = r1 + 1;
    L14:
        if (r1 == (-1)) goto L21;
        List<wh8.a> r5 = q;
        if (r5.size() <= r1) goto L22;
        ListProtector.remove(r5, r1);
        return;
    L22:
        return;
    L21:
        return;
    L8:
        r3 = null;
        goto L10
    L13:
        r1 = -1;
        goto L14
    }

    public static void E(DowngradeSource r14) {
        FLogger r0 = FLogger.a;
        r0.i("ConversationListModel", "requireRecommendTagBot");
        boolean r4 = false;
        if (f1.b == true) goto L6;
        r0.i("ConversationListModel-RecommendTagBot", "canRequirePresetBot(false), alreadyEnteredCvsListPage is false");
    L68:
        if (r4 == true) goto L70;
        return;
    L70:
        FLogger.a.i("ConversationListModel", "requireRecommendTagBotImpl");
        Lazy r1 = f1.a;
        f1.b(System.currentTimeMillis());
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ConversationListModel$requireRecommendTagBot$1(r14, null), 2, null);
        return;
    L6:
        if (f1.d >= 0) goto L8;
        r0.i("ConversationListModel-RecommendTagBot", "isTimeIntervalValid, requirePresetBotTS < 0");
        boolean r11 = true;
    L26:
        if (r11 == true) goto L28;
        r0.i("ConversationListModel-RecommendTagBot", "canRequirePresetBot(false), time interval is invalid");
        goto L68
    L28:
        IUserSettingCacheService r2 = (IUserSettingCacheService) ServiceManager.get().getService(IUserSettingCacheService.class);
        if (r2 == null) goto L48;
        List r3 = r2.g();
        if (r3 == null) goto L48;
        Iterator r5 = r3.iterator();
    L34:
        if (r5.hasNext() == false) goto L44;
        Object r6 = r5.next();
        Integer r7 = ((UserConfigItem) r6).b();
        int r8 = UserConfigKey.PERSONAL_RECOMMEND.getValue();
        if (r7 != null) goto L39;
    L41:
        boolean r9 = false;
    L42:
        if (r9 == false) goto L34;
    L45:
        UserConfigItem r10 = (UserConfigItem) r6;
        if (r10 == null) goto L48;
        String r12 = r10.c();
    L50:
        if (Intrinsics.areEqual(r12, "0") == false) goto L52;
        FLogger.a.i("ConversationListModel-RecommendTagBot", "canRequirePresetBot(false), personal recommend off");
        goto L68
    L52:
        com.larus.bmhome.chat.api.e0 r13 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r13 == null) goto L57;
        LaunchInfo r15 = r13.a;
        if (r15 == null) goto L57;
        ConvRecommendBotConf r16 = r15.J();
    L58:
        if (r16 != null) goto L60;
    L62:
        boolean r17 = false;
    L63:
        if (r17 == true) goto L65;
    L67:
        FLogger.a.i("ConversationListModel-RecommendTagBot", "canRequirePresetBot(" + r4 + "), presetBotConfig(" + r16 + "), alreadyEnteredCvsListPage(" + f1.b + ')');
        goto L68
    L65:
        if (f1.b == false) goto L67;
        r4 = true;
        goto L67
    L60:
        if (r16.a() != true) goto L62;
        r17 = true;
    L57:
        r16 = null;
        goto L58
    L39:
        if (r7.intValue() != r8) goto L41;
        r9 = true;
        goto L42
    L44:
        r6 = null;
    L48:
        r12 = null;
        goto L50
    L8:
        long r18 = System.currentTimeMillis() - f1.d;
        AuthModelDelegate r19 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r20 = (com.larus.bmhome.chat.api.e0) r19.e().getValue();
        if (r20 == null) goto L13;
        LaunchInfo r21 = r20.a;
        if (r21 == null) goto L13;
        ConvRecommendBotConf r22 = r21.J();
    L14:
        if (r22 == null) goto L16;
        int r23 = r22.b();
    L17:
        long r24 = r18 / ((long) 1000);
        if (r24 <= r23) goto L20;
        r11 = true;
    L21:
        StringBuilder r110 = new StringBuilder("isTimeIntervalValid(");
        r110.append(r11);
        r110.append("), timeInterval(");
        r110.append(r24);
        r110.append("),config(");
        r110.append(r23);
        r110.append("), data(");
        com.larus.bmhome.chat.api.e0 r25 = (com.larus.bmhome.chat.api.e0) r19.e().getValue();
        if (r25 == null) goto L24;
        LaunchInfo r26 = r25.a;
    L25:
        r110.append(r26);
        r110.append(')');
        r0.i("ConversationListModel-RecommendTagBot", r110.toString());
        goto L26
    L24:
        r26 = null;
        goto L25
    L20:
        r11 = false;
        goto L21
    L16:
        r23 = 0;
    L13:
        r22 = null;
        goto L14
    }

    public static boolean F(wc9.e r4) {
        Integer r0 = r4.j;
        boolean r1 = true;
        if (r0 != null) goto L6;
    L7:
        Integer r2 = r4.j;
        if (r2 != null) goto L11;
    L13:
        r1 = false;
    L14:
        if (r1 == false) goto L16;
        FLogger.a.i("ConversationListModel", "filter legacy social conversation, conversationType=" + r4.j);
    L16:
        return r1;
    L11:
        if (r2.intValue() != 2) goto L13;
    L6:
        if (r0.intValue() == 1) goto L14;
        goto L7
    }

    public static void H(List r5) {
        List r0 = r5;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L23;
        wc9.e r2 = (wc9.e) r6.next();
        String r3 = r2.a;
        if (r3 != null) goto L17;
    L20:
        boolean r4 = true;
    L21:
        if (r4 == true) goto L13;
        m.put(r3, r2);
        goto L13
    L17:
        if (StringsKt.isBlank(r3) == true) goto L20;
        r4 = false;
        goto L21
    L23:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final void h(ConversationListModel r6) {
        r6.getClass();
        FLogger.a.i("ConversationListModel", "truly clear conversationData");
        Iterator<Function0<Unit>> r7 = i.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r7.next().invoke();
        goto L4
    L6:
        v = false;
        Job r0 = t;
        if (r0 == null) goto L9;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L9:
        ((com.larus.im.service.q) c.getValue()).unRegisterConversationChangeListener(p);
        Iterator<Map.Entry<String, com.larus.im.service.d0<wc9.e>>> r1 = j.entrySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        Map.Entry<String, com.larus.im.service.d0<wc9.e>> r3 = r1.next();
        a.getClass();
        ((com.larus.im.service.q) c.getValue()).unRegisterConversationChangeListener(r3.getKey(), r3.getValue());
        goto L11
    L13:
        h.clear();
        j.clear();
        List<wh8.a> r2 = q;
        monitor-enter(r2);
        r2.clear();     // Catch: Throwable -> L22
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r2);
        m.clear();
        l.clear();
        k.clear();
        r = false;
        kotlinx.coroutines.channels.a r5 = s;
        if (r5 == null) goto L20;
        r5.close(null);
    L20:
        s = null;
        f = null;
        ConversationPageTrace.ConversationPageRecord r8 = ConversationPageTrace.a;
        FLogger.a.d("ConversationPageTrace", "onClear");
        ConversationPageTrace.a = null;
        ConversationPageTrace.b = false;
        x = true;
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public static void o(final String r7) {
        if (r7 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        Iterator r1 = CollectionsKt.toList(q).iterator();
    L11:
        Object r2 = null;
        if (r1.hasNext() == false) goto L19;
        Object r3 = r1.next();
        wc9.e r4 = ((wh8.a) r3).a;
        if (r4 == null) goto L17;
        r2 = r4.a;
    L17:
        if (Intrinsics.areEqual(r2, r7) == false) goto L11;
        r2 = r3;
    L19:
        wh8.a r5 = (wh8.a) r2;
        List<wh8.a> r6 = q;
        if (com.larus.utils.h.h(r6, new o0(r7)) == false) goto L28;
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("deleteLocalConversation, enableRecommendBotAgain=");
        z2 r10 = z2.a;
        r9.append(r10.enableRecommendBotAgain());
        r9.append(", cvs removed from list for id: ");
        r9.append(r7);
        r8.i("ConversationListModel", r9.toString());
        if (r5 == null) goto L28;
        if (i1.b(r5) == false) goto L28;
        if (r10.enableRecommendBotAgain() == false) goto L28;
        r8.i("ConversationListModel", "deleteLocalConversation, reset recommend TimeInterval");
        f1.b(-1);
        ConversationListModel r11 = a;
        DowngradeSource r12 = DowngradeSource.CLICK_ACTION;
        r11.getClass();
        E(r12);
    L28:
        FLogger.a.i("ConversationListModel", "deleteLocalConversation notifyCvsListChange");
        x(r6, "deleteLocalConversation");
        return;
    L4:
        if (r7.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void r(String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        FLogger.a.i("ConversationListModel", "getConversationList source=" + r7 + ", firstInitData = " + x);
        if (x == true) goto L6;
        A(k(r7, "refresh"));
        return;
    L6:
        x = false;
        t = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), b, null, new ConversationListModel$getConversationList$1(r7, null), 2, null);
    }

    public static void t(boolean r9) {
        LarkSocialExp.a.getClass();
        if (LarkSocialExp.e() == true) goto L5;
    L7:
        FLogger.a.i("ConversationListModel", "getRecommendBotList loadMore=" + r9 + " c_uid=" + AccountService.a.getUserId());
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ConversationListModel$getRecommendBotList$1(r9, null), 2, null);
        return;
    L5:
        if (((Boolean) o.getValue()).booleanValue() == false) goto L7;
    }

    public static void v(boolean r4) {
        FLogger r5 = FLogger.a;
        StringBuilder r0 = new StringBuilder("initAllListeners isLogin=");
        AccountService r1 = AccountService.a;
        r0.append(r1.isLogin().booleanValue());
        r0.append(" isTourist=");
        i3 r2 = i3.a;
        r0.append(r2.i());
        r0.append(" initAllListeners=");
        r0.append(r);
        r5.i("ConversationListModel", r0.toString());
        if (r1.isLogin().booleanValue() == true) goto L7;
        if (r2.i() == true) goto L7;
        return;
    L7:
        if (r1.isLogin().booleanValue() == true) goto L9;
        z();
        e = PreLoginState.TOURIST;
        return;
    L9:
        if (r == true) goto L14;
        z();
        e = PreLoginState.NORMAL;
        r = true;
        return;
    }

    @Override // com.larus.bmhome.chat.api.w
    public final void a(com.larus.larkfeed.impl.mixedfeed.pack.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        i.add(r2);
    }

    @Override // com.larus.bmhome.chat.api.w
    public final boolean b(wc9.e r3) {
        Intrinsics.checkNotNullParameter(r3, "conversation");
        Integer r0 = r3.f;
        if (r0 != null) goto L6;
    L37:
        return false;
    L6:
        if (r0.intValue() != 0) goto L37;
        if (ic8.n.d(r3) == true) goto L37;
        vi8.c.a.getClass();
        if (vi8.c.a() == false) goto L12;
    L13:
        Integer r1 = r3.t;
        if (r1 != null) goto L17;
    L18:
        Integer r2 = r3.t;
        if (r2 != null) goto L22;
    L23:
        Integer r4 = r3.t;
        if (r4 == null) goto L31;
        if (r4.intValue() != 8) goto L31;
        if (z2.a.g2() == true) goto L37;
    L31:
        if (F(r3) == true) goto L37;
        if (ic8.n.q(r3) == false) goto L35;
    L36:
        return true;
    L35:
        if (r3.F != 0) goto L37;
    L22:
        if (r2.intValue() == 6) goto L37;
    L17:
        if (r1.intValue() == 2) goto L37;
    L12:
        if (ic8.n.B(r3) == true) goto L37;
        goto L13
    }

    @Override // com.larus.bmhome.chat.api.w
    public final void d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        if (v == false) goto L10;
        String r11 = "paging done, load more Abort. source=".concat(r10);
        AppHost.Companion r0 = AppHost.a;
        if (r0.isDebug() == false) goto L7;
        t19.s r2 = t19.s.a;
        Application r1 = r0.getApplication();
        r2.getClass();
        t19.s.c(r1, r11);
    L7:
        FLogger.a.e("ConversationListModel", r11);
        return;
    L10:
        if (w == false) goto L16;
        String r12 = "is paging, Abort. source=".concat(r10);
        AppHost.Companion r3 = AppHost.a;
        if (r3.isDebug() == false) goto L14;
        t19.s r4 = t19.s.a;
        Application r5 = r3.getApplication();
        r4.getClass();
        t19.s.c(r5, r12);
    L14:
        FLogger.a.e("ConversationListModel", r12);
        return;
    L16:
        w = true;
        AppHost.Companion r6 = AppHost.a;
        if (r6.isDebug() == false) goto L19;
        t19.s.j(t19.s.a, r6.getApplication(), "load more conversation", null, false, 28);
    L19:
        List<wh8.a> r7 = q;
        ListIterator<wh8.a> r8 = r7.listIterator(r7.size());
    L21:
        if (r8.hasPrevious() == false) goto L30;
        wh8.a r9 = r8.previous();
        wc9.e r13 = r9.a;
        if (r13 != null) goto L25;
    L27:
        boolean r14 = false;
    L28:
        if (r14 == false) goto L21;
    L31:
        wh8.a r15 = r9;
        if (r15 == null) goto L34;
        wc9.e r16 = r15.a;
    L35:
        int r17 = q.indexOf(r15);
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder("loadMoreConversation source=");
        r19.append(r10);
        r19.append(" start: index = ");
        r19.append(r17);
        r19.append(",  anchorConv = ");
        if (r16 == null) goto L38;
        String r20 = ic8.n.F(r16);
    L39:
        r19.append(r20);
        r18.i("ConversationListModel_IMSDK", r19.toString());
        ((com.larus.im.service.r) d.getValue()).getConversationList(new wc9.o(r16, 20, null, 9), new d(r10));
        return;
    L38:
        r20 = null;
        goto L39
    L34:
        r16 = null;
        goto L35
    L25:
        if (ic8.n.r(r13) == true) goto L27;
        r14 = true;
        goto L28
    L30:
        r9 = null;
        goto L31
    }

    @Override // com.larus.bmhome.chat.api.w
    public final void f(wh8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        h.remove(r2);
    }

    @Override // com.larus.bmhome.chat.api.w
    public final com.larus.bmhome.chat.api.h g(String r6) {
        Intrinsics.checkNotNullParameter(r6, "conversationId");
        List<wh8.a> r0 = q;
        monitor-enter(r0);
        Iterator<T> r1 = r0.iterator();     // Catch: Throwable -> L30
    L5:
        wh8.a r3 = null;
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();     // Catch: Throwable -> L30
        wc9.e r4 = ((wh8.a) r2).a;     // Catch: Throwable -> L30
        if (r4 == null) goto L10;
        String r5 = r4.a;     // Catch: Throwable -> L30
    L12:
        if (Intrinsics.areEqual(r5, r6) == false) goto L5;
    L15:
        wh8.a r7 = (wh8.a) r2;     // Catch: Throwable -> L30
        if (r7 == null) goto L18;
        r3 = wh8.a.a(r7, null, null, 4095);     // Catch: Throwable -> L30
    L18:
        monitor-exit(r0);
        if (r3 != null) goto L21;
        wc9.e r8 = m.get(r6);
        if (r8 == null) goto L29;
        if (b(r8) == true) goto L29;
        return new com.larus.bmhome.chat.api.h.a(r6);
    L29:
        return com.larus.bmhome.chat.api.h.c.a;
    L21:
        return new com.larus.bmhome.chat.api.h.b(r3);
    L10:
        r5 = null;
        goto L12
    L14:
        r2 = null;
    L30:
        th = move-exception;
        throw th;
    }

    public static void B(wh8.a r10, DowngradeSource r11) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("refreshRecommendTagBot, bot(");
        if (r10 == null) goto L7;
        BotModel r3 = r10.b;
        if (r3 == null) goto L7;
        String r4 = r3.getName();
    L8:
        r1.append(r4);
        r1.append(')');
        r0.i("ConversationListModel", r1.toString());
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ConversationListModel$refreshRecommendTagBot$1(r10, r11, null), 2, null);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public static void G(List r17, String r18) {
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("sortData, data size(");
        if (r17 == null) goto L5;
        Integer r4 = Integer.valueOf(r17.size());
    L6:
        r2.append(r4);
        r2.append(") source=");
        r2.append(r18);
        r0.d("ConversationListModel", r2.toString());
        if (r17 == null) goto L14;
        ArrayList r1 = new ArrayList();
        Iterator r3 = r17.iterator();
    L10:
        if (r3.hasNext() == false) goto L15;
        wc9.e r5 = ((wh8.a) r3.next()).a;
        if (r5 == null) goto L10;
        r1.add(r5);
    L15:
        H(r1);
        List<wh8.a> r6 = q;
        monitor-enter(r6);
        vi8.c.a.getClass();     // Catch: Throwable -> L204
        final boolean r7 = vi8.c.a();     // Catch: Throwable -> L204
        com.larus.utils.h.h(r6, new g0(r7));     // Catch: Throwable -> L204
        if (r17 == null) goto L202;
        Iterator r8 = r17.iterator();     // Catch: Throwable -> L204
    L21:
        if (r8.hasNext() == false) goto L201;
        wh8.a r9 = (wh8.a) r8.next();     // Catch: Throwable -> L204
        wc9.e r10 = r9.a;     // Catch: Throwable -> L204
        if (r10 == null) goto L30;
        Integer r11 = r10.t;     // Catch: Throwable -> L204
        if (r11 == null) goto L30;
        if (r11.intValue() != 2) goto L30;
        boolean r12 = true;
    L31:
        if (r12 == true) goto L196;
        wc9.e r13 = r9.a;     // Catch: Throwable -> L204
        if (r13 == null) goto L40;
        Integer r14 = r13.t;     // Catch: Throwable -> L204
        if (r14 == null) goto L40;
        if (r14.intValue() != 6) goto L40;
        boolean r15 = true;
    L41:
        if (r15 == true) goto L196;
        wc9.e r16 = r9.a;     // Catch: Throwable -> L204
        if (r16 == null) goto L50;
        Integer r19 = r16.t;     // Catch: Throwable -> L204
        if (r19 == null) goto L50;
        if (r19.intValue() != 8) goto L50;
        boolean r20 = true;
    L51:
        if (r20 == false) goto L55;
        if (z2.a.g2() == true) goto L196;
    L55:
        wc9.e r21 = r9.a;     // Catch: Throwable -> L204
        if (r21 != null) goto L58;
    L60:
        boolean r22 = false;
    L61:
        int r23 = -1;
        if (r22 == true) goto L63;
        if (ic8.n.z(r9.a) == true) goto L84;
        if (i1.b(r9) == true) goto L118;
        Iterator<T> r24 = q.iterator();     // Catch: Throwable -> L204
    L139:
        if (r24.hasNext() == false) goto L151;
        Object r110 = r24.next();     // Catch: Throwable -> L204
        BotModel r111 = ((wh8.a) r110).b;     // Catch: Throwable -> L204
        if (r111 == null) goto L143;
        String r112 = r111.getBotId();     // Catch: Throwable -> L204
    L144:
        BotModel r113 = r9.b;     // Catch: Throwable -> L204
        if (r113 == null) goto L147;
        String r114 = r113.getBotId();     // Catch: Throwable -> L204
    L149:
        if (Intrinsics.areEqual(r112, r114) == false) goto L139;
    L152:
        wh8.a r115 = (wh8.a) r110;     // Catch: Throwable -> L204
        if (r115 != null) goto L155;
    L157:
        boolean r25 = false;
    L158:
        if (r25 == false) goto L166;
        FLogger r26 = FLogger.a;     // Catch: Throwable -> L204
        StringBuilder r116 = new StringBuilder();     // Catch: Throwable -> L204
        r116.append("sortData, remove existed recommend bot(");     // Catch: Throwable -> L204
        BotModel r117 = r115.b;     // Catch: Throwable -> L204
        if (r117 == null) goto L162;
        String r118 = r117.getName();     // Catch: Throwable -> L204
    L163:
        r116.append(r118);     // Catch: Throwable -> L204
        r116.append(')');     // Catch: Throwable -> L204
        r26.i("ConversationListModel", r116.toString());     // Catch: Throwable -> L204
        q.remove(r115);     // Catch: Throwable -> L204
        if (z2.a.enableRecommendBotAgain() == false) goto L166;
        r26.i("ConversationListModel", "deleteLocalConversation, reset recommend TimeInterval");     // Catch: Throwable -> L204
        f1.b(-1);     // Catch: Throwable -> L204
        ConversationListModel r27 = a;     // Catch: Throwable -> L204
        DowngradeSource r119 = DowngradeSource.ENTER_CONVERSATION_LIST;     // Catch: Throwable -> L204
        r27.getClass();     // Catch: Throwable -> L204
        E(r119);     // Catch: Throwable -> L204
        goto L166
    L162:
        r118 = null;
    L166:
        ConversationListModel r28 = a;     // Catch: Throwable -> L204
        wc9.e r120 = r9.a;     // Catch: Throwable -> L204
        if (r120 == null) goto L169;
        String r121 = r120.a;     // Catch: Throwable -> L204
    L170:
        r28.getClass();     // Catch: Throwable -> L204
        D(r121);     // Catch: Throwable -> L204
        Iterator<wh8.a> r29 = q.iterator();     // Catch: Throwable -> L204
        int r122 = 0;
    L172:
        if (r29.hasNext() == false) goto L192;
        wh8.a r123 = r29.next();     // Catch: Throwable -> L204
        if (ic8.n.z(r123.a) == true) goto L188;
        Intrinsics.checkNotNull(r123);     // Catch: Throwable -> L204
        if (i1.b(r123) == true) goto L188;
        wc9.e r124 = r123.a;     // Catch: Throwable -> L204
        if (r124 == null) goto L180;
        long r125 = r124.u;     // Catch: Throwable -> L204
    L181:
        wc9.e r126 = r9.a;     // Catch: Throwable -> L204
        if (r126 == null) goto L184;
        long r127 = r126.u;     // Catch: Throwable -> L204
    L186:
        if (r125 >= r127) goto L188;
        boolean r128 = true;
    L189:
        if (r128 == true) goto L193;
        r122 = r122 + 1;     // Catch: Throwable -> L204
    L193:
        if (r122 == (-1)) goto L194;
        a.getClass();     // Catch: Throwable -> L204
        j(r122, r9);     // Catch: Throwable -> L204
        goto L21
    L194:
        q.add(r9);     // Catch: Throwable -> L204
        goto L21
    L184:
        r127 = 0;
        goto L186
    L180:
        r125 = 0;
    L188:
        r128 = false;
        goto L189
    L192:
        r122 = -1;
        goto L193
    L169:
        r121 = null;
        goto L170
    L155:
        if (i1.b(r115) != true) goto L157;
        r25 = true;
        goto L158
    L147:
        r114 = null;
        goto L149
    L143:
        r112 = null;
        goto L144
    L151:
        r110 = null;
        goto L152
    L118:
        ConversationListModel r30 = a;     // Catch: Throwable -> L204
        wc9.e r31 = r9.a;     // Catch: Throwable -> L204
        if (r31 == null) goto L121;
        String r32 = r31.a;     // Catch: Throwable -> L204
    L122:
        r30.getClass();     // Catch: Throwable -> L204
        D(r32);     // Catch: Throwable -> L204
        List<wh8.a> r33 = q;     // Catch: Throwable -> L204
        ListIterator<wh8.a> r34 = r33.listIterator(r33.size());     // Catch: Throwable -> L204
    L124:
        if (r34.hasPrevious() == false) goto L128;
        if (ic8.n.z(r34.previous().a) == false) goto L124;
        r23 = r34.nextIndex();     // Catch: Throwable -> L204
    L128:
        int r35 = r23 + 1;     // Catch: Throwable -> L204
        List<wh8.a> r36 = q;     // Catch: Throwable -> L204
        if (r35 > r36.size()) goto L131;
        a.getClass();     // Catch: Throwable -> L204
        j(r35, r9);     // Catch: Throwable -> L204
    L132:
        FLogger r37 = FLogger.a;     // Catch: Throwable -> L204
        StringBuilder r38 = new StringBuilder();     // Catch: Throwable -> L204
        r38.append("sortData, index(");     // Catch: Throwable -> L204
        r38.append(r35);     // Catch: Throwable -> L204
        r38.append("), botName(");     // Catch: Throwable -> L204
        BotModel r39 = r9.b;     // Catch: Throwable -> L204
        if (r39 == null) goto L135;
        String r40 = r39.getName();     // Catch: Throwable -> L204
    L136:
        r38.append(r40);     // Catch: Throwable -> L204
        r38.append("), localConversationList(");     // Catch: Throwable -> L204
        r38.append(r36.size());     // Catch: Throwable -> L204
        r38.append(')');     // Catch: Throwable -> L204
        r37.i("ConversationListModel", r38.toString());     // Catch: Throwable -> L204
        goto L21
    L135:
        r40 = null;
        goto L136
    L131:
        r36.add(r9);     // Catch: Throwable -> L204
        goto L132
    L121:
        r32 = null;
        goto L122
    L84:
        ConversationListModel r41 = a;     // Catch: Throwable -> L204
        wc9.e r129 = r9.a;     // Catch: Throwable -> L204
        if (r129 == null) goto L87;
        String r130 = r129.a;     // Catch: Throwable -> L204
    L88:
        r41.getClass();     // Catch: Throwable -> L204
        D(r130);     // Catch: Throwable -> L204
        Iterator<wh8.a> r42 = q.iterator();     // Catch: Throwable -> L204
        int r131 = 0;
    L90:
        if (r42.hasNext() == false) goto L112;
        wh8.a r132 = r42.next();     // Catch: Throwable -> L204
        if (ic8.n.z(r132.a) == false) goto L106;
        if (ic8.n.u(r132.a) == true) goto L106;
        wc9.e r133 = r132.a;     // Catch: Throwable -> L204
        if (r133 == null) goto L98;
        long r134 = r133.u;     // Catch: Throwable -> L204
    L99:
        wc9.e r135 = r9.a;     // Catch: Throwable -> L204
        if (r135 == null) goto L102;
        long r136 = r135.u;     // Catch: Throwable -> L204
    L104:
        if (r134 >= r136) goto L106;
    L107:
        boolean r137 = true;
    L109:
        if (r137 == true) goto L113;
        r131 = r131 + 1;     // Catch: Throwable -> L204
    L113:
        if (r131 == (-1)) goto L114;
        a.getClass();     // Catch: Throwable -> L204
        j(r131, r9);     // Catch: Throwable -> L204
        goto L21
    L114:
        q.add(r9);     // Catch: Throwable -> L204
        goto L21
    L102:
        r136 = 0;
        goto L104
    L98:
        r134 = 0;
    L106:
        if (ic8.n.z(r132.a) == false) goto L107;
        r137 = false;
        goto L109
    L112:
        r131 = -1;
        goto L113
    L87:
        r130 = null;
        goto L88
    L63:
        Iterator<wh8.a> r43 = q.iterator();     // Catch: Throwable -> L204
        int r44 = 0;
    L65:
        if (r43.hasNext() == false) goto L75;
        wc9.e r45 = r43.next().a;     // Catch: Throwable -> L204
        if (r45 != null) goto L69;
    L71:
        boolean r46 = false;
    L72:
        if (r46 == true) goto L76;
        r44 = r44 + 1;     // Catch: Throwable -> L204
    L76:
        a.getClass();     // Catch: Throwable -> L204
        if (r44 == (-1)) goto L81;
        List<wh8.a> r47 = q;     // Catch: Throwable -> L204
        if (r47.size() <= r44) goto L81;
        ListProtector.remove(r47, r44);     // Catch: Throwable -> L204
    L81:
        j(0, r9);     // Catch: Throwable -> L204
        goto L21
    L69:
        if (ic8.n.u(r45) != true) goto L71;
        r46 = true;
        goto L72
    L75:
        r44 = -1;
        goto L76
    L58:
        if (ic8.n.u(r21) != true) goto L60;
        r22 = true;
    L50:
        r20 = false;
    L40:
        r15 = false;
    L196:
        FLogger.a.w("ConversationListModel", "remove conversation " + r9.d());     // Catch: Throwable -> L204
        ConversationListModel r48 = a;     // Catch: Throwable -> L204
        wc9.e r49 = r9.a;     // Catch: Throwable -> L204
        if (r49 == null) goto L199;
        String r50 = r49.a;     // Catch: Throwable -> L204
    L200:
        r48.getClass();     // Catch: Throwable -> L204
        D(r50);     // Catch: Throwable -> L204
        goto L21
    L199:
        r50 = null;
    L30:
        r12 = false;
        goto L31
    L201:
        Unit r51 = Unit.INSTANCE;     // Catch: Throwable -> L204
    L202:
        monitor-exit(r6);
        return;
    L204:
        th = move-exception;
        throw th;
    L14:
        r1 = null;
        goto L15
    L5:
        r4 = null;
        goto L6
    }

    public static void j(int r2, wh8.a r3) {
        List<wh8.a> r0 = q;
        if (r0.size() >= r2) goto L5;
        return;
    L5:
        if (r2 != (-1)) goto L7;
        r2 = 0;
    L7:
        ListProtector.add(r0, r2, r3);
    }

    public static String k(String r1, String r2) {
        if (StringsKt.isBlank(r1) == false) goto L6;
        return r2;
    L6:
        return r1 + "->" + r2;
    }

    public static List m(List r18, List r19) {
        ArrayList r0 = new ArrayList();
        Iterator r1 = r18.iterator();
    L4:
        if (r1.hasNext() == false) goto L79;
        wc9.e r4 = (wc9.e) r1.next();
        boolean r2 = false;
        if (r4 == null) goto L13;
        Integer r5 = r4.t;
        if (r5 == null) goto L13;
        if (r5.intValue() != 4) goto L13;
        boolean r6 = true;
    L14:
        String r7 = null;
        if (r6 == true) goto L61;
        if (r4 == null) goto L18;
        String r8 = r4.n;
    L19:
        if (r8 != null) goto L21;
    L22:
        r2 = true;
    L23:
        if (r2 == true) goto L61;
        if (r19 == null) goto L54;
        Iterator r3 = r19.iterator();
    L28:
        if (r3.hasNext() == false) goto L39;
        Object r9 = r3.next();
        Message r10 = (Message) r9;
        if (r10 == null) goto L32;
        String r11 = r10.getConversationId();
    L33:
        if (r4 == null) goto L35;
        String r12 = r4.a;
    L37:
        if (Intrinsics.areEqual(r11, r12) == false) goto L28;
    L40:
        Message r13 = (Message) r9;
        if (r13 == null) goto L54;
        ConcurrentHashMap<String, Pair<Message, String>> r14 = l;
        if (r4 == null) goto L45;
        String r15 = r4.a;
    L46:
        if (r4 == null) goto L48;
        String r16 = r4.a;
    L49:
        Pair<Message, String> r17 = r14.get(r16);
        if (r17 == null) goto L52;
        String r20 = (String) r17.getSecond();
    L53:
        r14.put(r15, TuplesKt.to(r13, r20));
        Message r21 = r13;
    L67:
        ConcurrentHashMap<String, Pair<Message, String>> r22 = l;
        if (r4 == null) goto L70;
        String r23 = r4.a;
    L71:
        Pair<Message, String> r24 = r22.get(r23);
        if (r24 == null) goto L74;
        String r25 = (String) r24.getSecond();
    L75:
        ConcurrentHashMap<String, BotModel> r26 = k;
        if (r4 == null) goto L78;
        r7 = r4.a;
    L78:
        CollectionsKt.addAll(r0, CollectionsKt.listOf(new wh8.a(r4, r26.get(r7), r21, r25, null, null, null, null, null, null, null, false, 4080)));
        goto L4
    L74:
        r25 = null;
        goto L75
    L70:
        r23 = null;
        goto L71
    L52:
        r20 = null;
        goto L53
    L48:
        r16 = null;
        goto L49
    L45:
        r15 = null;
        goto L46
    L35:
        r12 = null;
        goto L37
    L32:
        r11 = null;
        goto L33
    L39:
        r9 = null;
    L54:
        ConcurrentHashMap<String, Pair<Message, String>> r27 = l;
        if (r4 == null) goto L57;
        String r28 = r4.a;
    L58:
        Pair<Message, String> r29 = r27.get(r28);
        if (r29 == null) goto L66;
        r21 = (Message) r29.getFirst();
    L66:
        r21 = null;
        goto L67
    L57:
        r28 = null;
        goto L58
    L21:
        if (StringsKt.isBlank(r8) == false) goto L23;
    L18:
        r8 = null;
    L61:
        ConcurrentHashMap<String, Pair<Message, String>> r30 = l;
        if (r4 == null) goto L64;
        String r31 = r4.a;
    L65:
        r30.put(r31, new Pair(null, null));
        goto L66
    L64:
        r31 = null;
    L13:
        r6 = false;
        goto L14
    L79:
        return r0;
    }

    public static void x(List r3, String r4) {
        FLogger.a.i("ConversationListModel", "notifyCvsListChange source=" + r4 + " cvsList size=" + r3.size() + " c_uid=" + AccountService.a.getUserId());
        Iterator<wh8.b> r5 = h.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().Yo(r3);
        goto L4
    }

    @Override // com.larus.bmhome.chat.api.w
    public final void e(wh8.b r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        h.add(r2);
        if (r3 == false) goto L6;
        r2.Yo(q);
        return;
    }

    public final Object p(List<wc9.e> r20, String r21, Continuation<? super Unit> r22) {
        if ((r22 instanceof ConversationListModel$findConversationBotsNew$1) == false) goto L7;
        ConversationListModel$findConversationBotsNew$1 r1 = (ConversationListModel$findConversationBotsNew$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Map r4 = (Map) r1.L$2;
        String r5 = (String) r1.L$1;
        String r6 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L65:
        String r7 = r6;
        Map r18 = r4;
        r4 = (Map) r0;
        Map r8 = r18;
    L67:
        FLogger r9 = FLogger.a;
        StringBuilder r11 = new StringBuilder("getBatchGetBotList source=");
        r11.append(r7);
        r11.append(" result=");
        r11.append(r4.size());
        r11.append(" singleConvId=");
        r11.append(r5);
        r11.append(" hitCache=");
        if (r8 == null) goto L70;
        boolean r12 = true;
    L71:
        r11.append(r12);
        r9.i("ConversationListModel_IMSDK", r11.toString());
        ArrayList r13 = new ArrayList();
        List<wh8.a> r14 = q;
        monitor-enter(r14);
        Iterator<wh8.a> r15 = r14.iterator();     // Catch: Throwable -> L106
    L75:
        if (r15.hasNext() == false) goto L99;
        wh8.a r16 = r15.next();     // Catch: Throwable -> L106
        wc9.e r17 = r16.a;     // Catch: Throwable -> L106
        if (r17 == null) goto L79;
        String r19 = r17.a;     // Catch: Throwable -> L106
    L80:
        if (r19 != null) goto L82;
    L85:
        boolean r23 = true;
    L86:
        if (r23 == true) goto L75;
        List r24 = (List) r4.get(r19);     // Catch: Throwable -> L106
        if (r24 == null) goto L91;
        BotModel r25 = (BotModel) CollectionsKt.getOrNull(r24, 0);     // Catch: Throwable -> L106
    L92:
        if (r25 == null) goto L75;
        r16.b = r25;     // Catch: Throwable -> L106
        k.put(r19, r25);     // Catch: Throwable -> L106
        if (ic8.n.l(r16.a) == false) goto L75;
        BotStatusCacheDelegate r26 = BotStatusCacheDelegate.b;     // Catch: Throwable -> L106
        String r27 = r25.getBotId();     // Catch: Throwable -> L106
        if (r27 != null) goto L98;
        r27 = "";
    L98:
        r26.d(r27, true);     // Catch: Throwable -> L106
        goto L75
    L91:
        r25 = null;
        goto L92
    L82:
        if (StringsKt.isBlank(r19) == true) goto L85;
        r23 = false;
        goto L86
    L79:
        r19 = null;
        goto L80
    L99:
        List<wh8.a> r28 = q;     // Catch: Throwable -> L106
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));     // Catch: Throwable -> L106
        Iterator<T> r30 = r28.iterator();     // Catch: Throwable -> L106
    L101:
        if (r30.hasNext() == false) goto L103;
        r29.add(wh8.a.a((wh8.a) r30.next(), null, null, 4095));     // Catch: Throwable -> L106
        goto L101
    L103:
        r13.addAll(r29);     // Catch: Throwable -> L106
        monitor-exit(r14);
        x(r13, k(r7, "getBotList"));
    L110:
        return Unit.INSTANCE;
    L106:
        th = move-exception;
        throw th;
    L70:
        r12 = false;
        goto L71
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r31 = (String) r1.L$2;
        List r32 = (List) r1.L$1;
        r7 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        List r33 = r32;
    L53:
        BotModel r34 = (BotModel) r0;
        if (r34 == null) goto L56;
        String r110 = r31;
        r4 = MapsKt.mapOf(TuplesKt.to(r31, CollectionsKt.listOf(r34)));
        List r35 = r33;
        r5 = r110;
    L58:
        if (r4 != null) goto L66;
        r1.L$0 = r7;
        r1.L$1 = r5;
        r1.L$2 = r4;
        r1.label = 2;
        kotlinx.coroutines.j r36 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r1), 1);
        r36.C();
        com.larus.im.d.a().batchGetBotByConversationId(r35, new u0(r36));
        r0 = r36.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L62;
        DebugProbesKt.probeCoroutineSuspended(r1);
    L62:
        if (r0 != r10) goto L64;
        return r10;
    L64:
        r6 = r7;
        goto L65
    L66:
        r8 = r4;
        goto L67
    L56:
        r35 = r33;
        r5 = r31;
        r4 = null;
        goto L58
    L16:
        ResultKt.throwOnFailure(r0);
        List r37 = CollectionsKt.filterNotNull(r20);
        ArrayList r38 = new ArrayList();
        Iterator r39 = r37.iterator();
    L18:
        if (r39.hasNext() == false) goto L28;
        Object r40 = r39.next();
        Integer r41 = ((wc9.e) r40).j;
        if (r41 != null) goto L23;
    L25:
        boolean r42 = false;
    L26:
        if (r42 == false) goto L18;
        r38.add(r40);
        goto L18
    L23:
        if (r41.intValue() != 3) goto L25;
        r42 = true;
        goto L26
    L28:
        ArrayList r43 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10));
        Iterator r44 = r38.iterator();
    L30:
        if (r44.hasNext() == false) goto L33;
        r43.add(((wc9.e) r44.next()).a);
        goto L30
    L33:
        if ((!r20.isEmpty()) == false) goto L110;
        String r45 = (String) CollectionsKt.singleOrNull(r43);
        if (com.larus.platform.exp.c.d == false) goto L57;
        if (r45 != null) goto L38;
    L41:
        boolean r46 = true;
    L42:
        if (r46 == true) goto L57;
        wc9.e r47 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r47 == null) goto L46;
        String r48 = r47.a;
    L48:
        if (Intrinsics.areEqual(r45, r48) == false) goto L57;
        BotRepo r49 = g;
        String r50 = (String) MainBotModelStore.i.getValue();
        r1.L$0 = r21;
        r1.L$1 = r43;
        r1.L$2 = r45;
        r1.label = 1;
        Object r51 = IBotRepoService.b.a(r49, r50, false, null, false, r1, 30);
        if (r51 != r10) goto L52;
        return r10;
    L52:
        r7 = r21;
        r33 = r43;
        r0 = r51;
        r31 = r45;
        goto L53
    L46:
        r48 = null;
        goto L48
    L38:
        if (StringsKt.isBlank(r45) == true) goto L41;
        r46 = false;
    L57:
        r7 = r21;
        r4 = null;
        r5 = r45;
        r35 = r43;
    L7:
        r1 = new ConversationListModel$findConversationBotsNew$1(this, r22);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00ee -> B:30:0x00f2). Please report as a decompilation issue!!! */
    public final Object C(List<wc9.c> r18, Map<String, Message> r19, List<wh8.a> r20, Continuation<? super Unit> r21) {
        if ((r21 instanceof ConversationListModel$refreshSenderInfo$1) == false) goto L7;
        ConversationListModel$refreshSenderInfo$1 r1 = (ConversationListModel$refreshSenderInfo$1) r21;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        int r6 = 0;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        Set r5 = (Set) r1.L$2;
        List r7 = (List) r1.L$1;
        Map<String, Message> r8 = (Map) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L49:
        wc9.b r9 = (wc9.b) r0;
        if (r9 == null) goto L52;
        List r10 = r9.a;
    L53:
        List r11 = r10;
        if (r11 != null) goto L56;
    L59:
        boolean r12 = true;
    L60:
        if (r12 == true) goto L62;
    L65:
        if (r10 != null) goto L67;
    L69:
        boolean r13 = false;
    L70:
        if (r13 == false) goto L81;
        Iterator r14 = r10.iterator();
    L73:
        if (r14.hasNext() == false) goto L81;
        wc9.d r15 = (wc9.d) r14.next();
        String r16 = r15.a;
        ParticipantModel r17 = (ParticipantModel) CollectionsKt.getOrNull(r15.b, 0);
        if ((!StringsKt.isBlank(r16)) == false) goto L73;
        r5.add(r16);
        ConcurrentHashMap<String, Pair<Message, String>> r110 = l;
        Message r111 = r8.get(r16);
        if (r17 == null) goto L79;
        String r22 = r17.getName();
    L80:
        r110.put(r16, new Pair(r111, r22));
        goto L73
    L79:
        r22 = null;
    L81:
        List<wh8.a> r23 = q;
        monitor-enter(r23);
        Iterator<wh8.a> r24 = r23.iterator();     // Catch: Throwable -> L117
    L85:
        if (r24.hasNext() == false) goto L109;
        wh8.a r25 = r24.next();     // Catch: Throwable -> L117
        wc9.e r26 = r25.a;     // Catch: Throwable -> L117
        if (r26 == null) goto L89;
        String r27 = r26.a;     // Catch: Throwable -> L117
    L90:
        if (r27 != null) goto L92;
    L95:
        boolean r112 = true;
    L96:
        if (r112 == true) goto L85;
        if (r5.contains(r27) == false) goto L85;
        ConcurrentHashMap<String, Pair<Message, String>> r113 = l;     // Catch: Throwable -> L117
        Pair<Message, String> r114 = r113.get(r27);     // Catch: Throwable -> L117
        if (r114 == null) goto L103;
        Message r115 = (Message) r114.getFirst();     // Catch: Throwable -> L117
    L104:
        r25.c = r115;     // Catch: Throwable -> L117
        Pair<Message, String> r28 = r113.get(r27);     // Catch: Throwable -> L117
        if (r28 == null) goto L107;
        String r29 = (String) r28.getSecond();     // Catch: Throwable -> L117
    L108:
        r25.d = r29;     // Catch: Throwable -> L117
        goto L85
    L107:
        r29 = null;
        goto L108
    L103:
        r115 = null;
        goto L104
    L92:
        if (StringsKt.isBlank(r27) == true) goto L95;
        r112 = false;
        goto L96
    L89:
        r27 = null;
        goto L90
    L109:
        r7.clear();     // Catch: Throwable -> L117
        FLogger r30 = FLogger.a;     // Catch: Throwable -> L117
        StringBuilder r31 = new StringBuilder();     // Catch: Throwable -> L117
        r31.append("refreshSenderInfo clearConversationData tempLocalConversationList clear localConversationListSize=");     // Catch: Throwable -> L117
        List<wh8.a> r32 = q;     // Catch: Throwable -> L117
        r31.append(r32.size());     // Catch: Throwable -> L117
        r30.i("ConversationListModel", r31.toString());     // Catch: Throwable -> L117
        List<wh8.a> r33 = r32;     // Catch: Throwable -> L117
        ArrayList r34 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10));     // Catch: Throwable -> L117
        Iterator<T> r35 = r33.iterator();     // Catch: Throwable -> L117
    L111:
        if (r35.hasNext() == false) goto L113;
        r34.add(wh8.a.a((wh8.a) r35.next(), null, null, 4095));     // Catch: Throwable -> L117
        goto L111
    L113:
        r7.addAll(r34);     // Catch: Throwable -> L117
        monitor-exit(r23);
        FLogger.a.i("ConversationListModel", "refreshSenderInfo notifyCvsListChange");
        x(r7, "refreshSenderInfo");
        return Unit.INSTANCE;
    L117:
        th = move-exception;
        throw th;
    L67:
        if ((!r10.isEmpty()) != true) goto L69;
        r13 = true;
        goto L70
    L62:
        if (r5.isEmpty() == false) goto L65;
        return Unit.INSTANCE;
    L56:
        if (r11.isEmpty() == true) goto L59;
        r12 = false;
        goto L60
    L52:
        r10 = null;
        goto L53
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        wc9.c r36 = (wc9.c) r1.L$5;
        Iterator r37 = (Iterator) r1.L$4;
        Set r116 = (Set) r1.L$3;
        List<wh8.a> r117 = (List) r1.L$2;
        Map<String, Message> r118 = (Map) r1.L$1;
        List<wc9.c> r119 = (List) r1.L$0;
        ResultKt.throwOnFailure(r0);
        ConversationListModel$refreshSenderInfo$1 r38 = r1;
        r8 = r118;
        Object r120 = r3;
        List<wh8.a> r39 = r117;
        Iterator r121 = r37;
        Set r40 = r116;
    L30:
        ParticipantModel r41 = (ParticipantModel) r0;
        if (r41 == null) goto L33;
        ConcurrentHashMap<String, Pair<Message, String>> r42 = l;
        String r122 = r36.a;
        r42.put(r122, new Pair(r8.get(r122), r41.getName()));
        r40.add(r36.a);
    L33:
        ConversationListModel$refreshSenderInfo$1 r43 = r38;
        List<wc9.c> r44 = r119;
        r6 = 0;
    L18:
        if (r121.hasNext() == false) goto L34;
        wc9.c r123 = (wc9.c) r121.next();
        ConcurrentHashMap<String, Pair<Message, String>> r124 = l;
        String r125 = r123.a;
        r124.put(r125, new Pair(r8.get(r125), null));
        ConversationListModel r45 = a;
        r43.L$0 = r44;
        r43.L$1 = r8;
        r43.L$2 = r39;
        r43.L$3 = r40;
        r43.L$4 = r121;
        r43.L$5 = r123;
        r43.label = 1;
        r45.getClass();
        kotlinx.coroutines.j r46 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r43), 1);
        r46.C();
        NativeConversationServiceImpl r126 = com.larus.im.d.d();
        String r127 = r123.a;
        wc9.q r128 = (wc9.q) CollectionsKt.getOrNull(r123.b, r6);
        if (r128 == null) goto L23;
        String r129 = r128.a;
        if (r129 == null) goto L23;
    L24:
        r126.getParticipant(r127, r129, new w0(r46));
        Object r47 = r46.B();
        if (r47 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r43);
    L27:
        if (r47 != r120) goto L29;
        return r120;
    L29:
        r119 = r44;
        r0 = r47;
        r38 = r43;
        r36 = r123;
    L23:
        r129 = "";
        goto L24
    L34:
        ArrayList r48 = new ArrayList();
        Iterator<T> r49 = r44.iterator();
    L36:
        if (r49.hasNext() == false) goto L40;
        Object r50 = r49.next();
        if ((!r40.contains(((wc9.c) r50).a)) == false) goto L36;
        r48.add(r50);
        goto L36
    L40:
        r43.L$0 = r8;
        r43.L$1 = r39;
        r43.L$2 = r40;
        r43.L$3 = null;
        r43.L$4 = null;
        r43.L$5 = null;
        r43.label = 2;
        if (r48.isEmpty() == false) goto L43;
        r0 = null;
    L46:
        if (r0 != r120) goto L48;
        return r120;
    L48:
        r7 = r39;
        r5 = r40;
        goto L49
    L43:
        kotlinx.coroutines.j r51 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r43), 1);
        r51.C();
        com.larus.im.d.d().batchGetParticipantsFromNet(new wc9.a(r48), new x0(r51));
        r0 = r51.B();
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L46;
        DebugProbesKt.probeCoroutineSuspended(r43);
        goto L46
    L16:
        ResultKt.throwOnFailure(r0);
        r40 = new LinkedHashSet();
        r120 = r3;
        r121 = r18.iterator();
        r44 = r18;
        r39 = r20;
        r43 = r1;
        r8 = r19;
    L7:
        r1 = new ConversationListModel$refreshSenderInfo$1(this, r21);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.larus.bmhome.chat.model.ConversationListModel] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v29, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v36 */
    public final Object u(List<wc9.e> r19, List<Message> r20, String r21, Continuation<? super Unit> r22) {
        if ((r22 instanceof ConversationListModel$handleConversationMessageNew$1) == false) goto L7;
        ConversationListModel$handleConversationMessageNew$1 r2 = (ConversationListModel$handleConversationMessageNew$1) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        ResultKt.throwOnFailure(r0);
    L196:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r6 = r2.I$0;
        ?? r9 = (List) r2.L$1;
        String r10 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L18
        String r12 = r10;
        r9 = r9;
    L74:
        Map r1 = (Map) r0;     // Catch: Throwable -> L88
        FLogger r11 = FLogger.a;     // Catch: Throwable -> L88
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L88
        r13.append("getBatchMessage source=");     // Catch: Throwable -> L88
        r13.append(r12);     // Catch: Throwable -> L88
        r13.append(" result=");     // Catch: Throwable -> L88
        ArrayList r14 = new ArrayList(r1.size());     // Catch: Throwable -> L88
        Iterator r15 = r1.entrySet().iterator();     // Catch: Throwable -> L88
    L76:
        if (r15.hasNext() == false) goto L86;
        Map.Entry r16 = (Map.Entry) r15.next();     // Catch: Throwable -> L88
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L88
        Message r17 = (Message) r16.getValue();     // Catch: Throwable -> L88
        if (r17 == null) goto L80;
        String r8 = r17.getMessageId();     // Catch: Throwable -> L88
    L81:
        r7.append(r8);     // Catch: Throwable -> L88
        r7.append('_');     // Catch: Throwable -> L88
        Message r18 = (Message) r16.getValue();     // Catch: Throwable -> L88
        if (r18 == null) goto L84;
        Integer r23 = Boxing.boxInt(r18.getMessageStatusLocal());     // Catch: Throwable -> L88
    L85:
        r7.append(r23);     // Catch: Throwable -> L88
        r14.add(r7.toString());     // Catch: Throwable -> L88
        goto L76
    L84:
        r23 = null;
        goto L85
    L80:
        r8 = null;
        goto L81
    L86:
        r13.append(r14);     // Catch: Throwable -> L88
        r11.i("ConversationListModel_IMSDK", r13.toString());     // Catch: Throwable -> L88
        Object r24 = Result.constructor-impl(CollectionsKt.toList(r1.values()));     // Catch: Throwable -> L88
        ?? r25 = r9;
    L93:
        Throwable r26 = Result.exceptionOrNull-impl(r24);
        if (r26 == null) goto L97;
        FLogger.a.e("ConversationListModel", "Error getting batch messages source=" + r12 + ": " + r26.getMessage(), r26);
        r24 = CollectionsKt.emptyList();
    L97:
        List<Message> r27 = (List) r24;
        ?? r28 = r25;
    L100:
        if (r27 == null) goto L102;
        List r29 = CollectionsKt.filterNotNull(r27);
    L103:
        if (r29 == null) goto L198;
        HashMap r30 = new HashMap();
        Iterable r31 = (Iterable) r28;
        LinkedHashMap r110 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r31, 10)), 16));
        Iterator r32 = r31.iterator();
    L106:
        if (r32.hasNext() == false) goto L112;
        Object r111 = r32.next();
        wc9.e r112 = (wc9.e) r111;
        if (r112 == null) goto L110;
        String r113 = r112.a;
    L111:
        r110.put(r113, r111);
        goto L106
    L110:
        r113 = null;
        goto L111
    L112:
        Iterator r33 = r29.iterator();
    L114:
        if (r33.hasNext() == false) goto L133;
        Message r34 = (Message) r33.next();
        String r114 = r34.getConversationId();
        if (r114 != null) goto L118;
        r114 = "";
    L118:
        wc9.e r115 = (wc9.e) r110.get(r114);
        if (r115 == null) goto L114;
        Integer r116 = r115.j;
        if (r116 == null) goto L131;
        if (r116.intValue() != 2) goto L131;
        if (Intrinsics.areEqual(r34.getSenderId(), AccountService.a.getUserId()) == true) goto L131;
        if (r34.getContentType() == 1001) goto L131;
        r30.put(r114, r34);
    L131:
        if (r6 == 0) goto L114;
        l.put(r114, TuplesKt.to(r34, null));
        goto L114
    L133:
        ArrayList r35 = new ArrayList();
        if (r6 == 0) goto L181;
        List<wh8.a> r36 = q;
        monitor-enter(r36);
        Iterator<wh8.a> r37 = r36.iterator();     // Catch: Throwable -> L177
    L139:
        if (r37.hasNext() == false) goto L170;
        wh8.a r117 = r37.next();     // Catch: Throwable -> L177
        wc9.e r118 = r117.a;     // Catch: Throwable -> L177
        if (r118 == null) goto L143;
        String r119 = r118.a;     // Catch: Throwable -> L177
    L144:
        if (r119 != null) goto L146;
    L149:
        boolean r120 = true;
    L150:
        if (r120 == true) goto L139;
        if (ic8.n.q(r117.a) == true) goto L154;
        ConcurrentHashMap<String, Pair<Message, String>> r121 = l;     // Catch: Throwable -> L177
        Pair<Message, String> r122 = r121.get(r119);     // Catch: Throwable -> L177
        if (r122 == null) goto L164;
        Message r123 = (Message) r122.getFirst();     // Catch: Throwable -> L177
    L165:
        r117.c = r123;     // Catch: Throwable -> L177
        Pair<Message, String> r124 = r121.get(r119);     // Catch: Throwable -> L177
        if (r124 == null) goto L168;
        String r125 = (String) r124.getSecond();     // Catch: Throwable -> L177
    L169:
        r117.d = r125;     // Catch: Throwable -> L177
        goto L139
    L168:
        r125 = null;
        goto L169
    L164:
        r123 = null;
        goto L165
    L154:
        String r126 = r117.h;     // Catch: Throwable -> L177
        if (r126 == null) goto L139;
        Pair<Message, String> r127 = l.get(r126);     // Catch: Throwable -> L177
        if (r127 == null) goto L159;
        Message r128 = (Message) r127.getFirst();     // Catch: Throwable -> L177
    L160:
        r117.c = r128;     // Catch: Throwable -> L177
        goto L139
    L159:
        r128 = null;
        goto L160
    L146:
        if (StringsKt.isBlank(r119) == true) goto L149;
        r120 = false;
        goto L150
    L143:
        r119 = null;
        goto L144
    L170:
        List<wh8.a> r38 = q;     // Catch: Throwable -> L177
        ArrayList r129 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10));     // Catch: Throwable -> L177
        Iterator r39 = r38.iterator();     // Catch: Throwable -> L177
    L172:
        if (r39.hasNext() == false) goto L174;
        r129.add(wh8.a.a((wh8.a) r39.next(), null, null, 4095));     // Catch: Throwable -> L177
        goto L172
    L174:
        r35.addAll(r129);     // Catch: Throwable -> L177
        monitor-exit(r36);
        FLogger.a.i("ConversationListModel", "handleConversationMessageNew source=" + r12 + " notifyCvsListChange");
        x(r35, k(r12, "notifyBrief"));
    L177:
        th = move-exception;
        throw th;
    L181:
        if ((!r30.isEmpty()) == false) goto L198;
        ArrayList r40 = new ArrayList();
        Iterator r41 = r30.entrySet().iterator();
    L184:
        if (r41.hasNext() == false) goto L192;
        Map.Entry r42 = (Map.Entry) r41.next();
        String r130 = (String) r42.getKey();
        Message r43 = (Message) r42.getValue();
        if (r130 != null) goto L188;
        r130 = "";
    L188:
        String r131 = r43.getSenderId();
        if (r131 != null) goto L191;
        r131 = "";
    L191:
        r40.add(new wc9.c(r130, CollectionsKt.listOf(new wc9.q(r131, r43.getUserType()))));
        goto L184
    L192:
        r2.L$0 = null;
        r2.L$1 = null;
        r2.label = 2;
        if (C(r40, r30, r35, r2) != r4) goto L196;
        return r4;
    L198:
        return Unit.INSTANCE;
    L102:
        r29 = null;
    L88:
        th = th;
    L92:
        Result.Companion r44 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        r25 = r9;
    L18:
        th = th;
        r12 = r10;
        goto L92
    L20:
        ResultKt.throwOnFailure(r0);
        r9 = new ArrayList();
        Iterator r45 = r19.iterator();
    L22:
        if (r45.hasNext() == false) goto L36;
        Object r46 = r45.next();
        wc9.e r132 = (wc9.e) r46;
        if (r132 == null) goto L32;
        Integer r133 = r132.t;
        if (r133 != null) goto L29;
    L31:
        boolean r134 = false;
    L33:
        if (r134 == true) goto L22;
        r9.add(r46);
        goto L22
    L29:
        if (r133.intValue() != 4) goto L31;
    L32:
        r134 = true;
        goto L33
    L36:
        if (r9.isEmpty() == true) goto L38;
        if (r20 == null) goto L41;
        List r47 = CollectionsKt.filterNotNull(r20);
    L42:
        List r48 = r47;
        if (r48 != null) goto L45;
    L48:
        r6 = 1;
    L49:
        if (r6 == 0) goto L99;
        ArrayList r49 = new ArrayList();
        Iterator r135 = r9.iterator();
    L52:
        if (r135.hasNext() == false) goto L67;
        wc9.e r136 = (wc9.e) r135.next();
        if (r136 == null) goto L56;
        String r137 = r136.n;
    L57:
        if (r137 != null) goto L59;
    L62:
        boolean r138 = true;
    L63:
        if (r138 == false) goto L65;
        r137 = null;
    L65:
        if (r137 == null) goto L52;
        r49.add(r137);
        goto L52
    L59:
        if (StringsKt.isBlank(r137) == true) goto L62;
        r138 = false;
        goto L63
    L56:
        r137 = null;
        goto L57
    L67:
        Set r50 = CollectionsKt.toSet(r49);
        if ((!r50.isEmpty()) == true) goto L205;
        r12 = r21;
        r27 = null;
        r28 = r9;
        goto L100
    L205:
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L90
        CoroutineDispatcher r140 = Dispatchers.getIO();     // Catch: Throwable -> L90
        ConversationListModel$handleConversationMessageNew$result$1$messageMap$1 r141 = new ConversationListModel$handleConversationMessageNew$result$1$messageMap$1(this, r50, null);     // Catch: Throwable -> L90
        r12 = r21;
        r2.L$0 = r12;     // Catch: Throwable -> L88
        r2.L$1 = r9;     // Catch: Throwable -> L88
        r2.I$0 = r6;     // Catch: Throwable -> L88
        r2.label = 1;     // Catch: Throwable -> L88
        r0 = BuildersKt.withContext(r140, r141, r2);     // Catch: Throwable -> L88
        r9 = r9;
        if (r0 != r4) goto L74;
        return r4;
    L90:
        th = th;
        r12 = r21;
        goto L92
    L99:
        r12 = r21;
        r27 = r20;
        r28 = r9;
        goto L100
    L45:
        if (r48.isEmpty() == true) goto L48;
        r6 = 0;
        goto L49
    L41:
        r47 = null;
        goto L42
    L38:
        return Unit.INSTANCE;
    L7:
        r2 = new ConversationListModel$handleConversationMessageNew$1(this, r22);
        goto L8
    }

    public static final Object i(ConversationListModel r7, List r8, boolean r9, String r10, Continuation r11) {
        r7.getClass();
        if ((r11 instanceof ConversationListModel$loadConversation$1) == false) goto L7;
        ConversationListModel$loadConversation$1 r0 = (ConversationListModel$loadConversation$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        ConversationListModel$loadConversation$1 r6 = r0;
        Object r12 = r6.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        List r14 = (List) r6.L$0;
        ResultKt.throwOnFailure(r12);
    L90:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        String r5 = k(r10, "loadCvs");
        if (r8 == null) goto L22;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r8.iterator();
    L18:
        if (r4.hasNext() == false) goto L23;
        wc9.e r15 = ((wc9.l) r4.next()).a;
        if (r15 == null) goto L18;
        r3.add(r15);
    L23:
        H(r3);
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("loadConversation source=");
        r17.append(r10);
        r17.append(", size=");
        if (r8 == null) goto L26;
        Integer r18 = Boxing.boxInt(r8.size());
    L27:
        r17.append(r18);
        r17.append(", firstPage=");
        r17.append(r9);
        r17.append(", cvsList=");
        if (r3 == null) goto L35;
        List r19 = CollectionsKt.take(r3, 30);
        if (r19 == null) goto L35;
        List r110 = r19;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r111 = r110.iterator();
    L33:
        if (r111.hasNext() == false) goto L36;
        r20.add(ic8.n.F((wc9.e) r111.next()));
    L36:
        r17.append(r20);
        r16.i("ConversationListModel_IMSDK", r17.toString());
        if (r8 == null) goto L90;
        ArrayList r112 = new ArrayList();
        Iterator r21 = r8.iterator();
    L39:
        boolean r22 = false;
        if (r21.hasNext() == false) goto L72;
        Object r23 = r21.next();
        wc9.l r24 = (wc9.l) r23;
        wc9.e r25 = r24.a;
        if (r25 == null) goto L49;
        Integer r26 = r25.f;
        if (r26 == null) goto L49;
        if (r26.intValue() != 0) goto L49;
        boolean r27 = true;
    L50:
        if (r27 == true) goto L52;
    L70:
        if (r22 == false) goto L39;
        r112.add(r23);
        goto L39
    L52:
        if (ic8.n.d(r24.a) == true) goto L70;
        if (ic8.n.q(r24.a) == true) goto L62;
        wc9.e r28 = r24.a;
        if (r28 != null) goto L58;
    L60:
        boolean r29 = false;
    L61:
        if (r29 == false) goto L70;
    L58:
        if (r28.F != 0) goto L60;
        r29 = true;
    L62:
        wc9.e r30 = r24.a;
        if (r30 == null) goto L67;
        a.getClass();
        if ((!F(r30)) != true) goto L67;
        boolean r31 = true;
    L68:
        if (r31 == false) goto L70;
        r22 = true;
    L67:
        r31 = false;
    L49:
        r27 = false;
        goto L50
    L72:
        ArrayList r32 = new ArrayList();
        Iterator r33 = r112.iterator();
    L74:
        if (r33.hasNext() == false) goto L76;
        CollectionsKt.addAll(r32, CollectionsKt.listOf(((wc9.l) r33.next()).a));
        goto L74
    L76:
        ArrayList r34 = new ArrayList();
        Iterator r35 = r112.iterator();
    L78:
        if (r35.hasNext() == false) goto L85;
        List r36 = ((wc9.l) r35.next()).b;
        if (r36 == null) goto L82;
        Message r37 = (Message) CollectionsKt.getOrNull(r36, 0);
    L83:
        CollectionsKt.addAll(r34, CollectionsKt.listOf(r37));
        goto L78
    L82:
        r37 = null;
        goto L83
    L85:
        if ((!r32.isEmpty()) == false) goto L90;
        ConversationPageTrace.ConversationPageRecord r38 = ConversationPageTrace.a;
        ConversationPageTrace.c(true, r32.size());
        ConversationListModel r39 = a;
        r39.getClass();
        G(m(r32, r34), r5);
        G(l(), "loadGroupCells");
        x(q, r5);
        r6.L$0 = r112;
        r6.label = 1;
        if (r39.n(r32, r34, r9, r5, r6) != r13) goto L90;
        return r13;
    L35:
        r20 = null;
        goto L36
    L26:
        r18 = null;
        goto L27
    L22:
        r3 = null;
    L7:
        r0 = new ConversationListModel$loadConversation$1(r7, r11);
        goto L8
    }

    public final Object n(List<wc9.e> r17, List<Message> r18, boolean r19, String r20, Continuation<? super Unit> r21) {
        String r2 = r20;
        if ((r21 instanceof ConversationListModel$batchFetchBotAndBrief$1) == false) goto L7;
        Continuation<? super Unit> r4 = (ConversationListModel$batchFetchBotAndBrief$1) r21;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L20;
        if (r7 == 1) goto L19;
        if (r7 == 2) goto L18;
        if (r7 == 3) goto L17;
        if (r7 != 4) goto L16;
        int r1 = r4.I$1;
        int r8 = r4.I$0;
        String r9 = (String) r4.L$2;
        List r10 = (List) r4.L$1;
        List r11 = (List) r4.L$0;
        ResultKt.throwOnFailure(r3);
        int r12 = r1;
        int r13 = r8;
        List r14 = r11;
        String r15 = r9;
        List r16 = r10;
    L31:
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new ConversationListModel$batchFetchBotAndBrief$2(r15, r13, r12, r14, r16, null), 2, null);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r22 = r4.I$1;
        int r23 = r4.I$0;
        String r24 = (String) r4.L$2;
        List r25 = (List) r4.L$1;
        List r26 = (List) r4.L$0;
        ResultKt.throwOnFailure(r3);
        int r27 = r23;
        r2 = r24;
        List r110 = r25;
        List r28 = r26;
    L27:
        List<wc9.e> r29 = r28.subList(0, r22);
        List<Message> r30 = r110.subList(0, r22);
        String r111 = k(r2, "handleConversationMessageNew:first20");
        r4.L$0 = r28;
        r4.L$1 = r110;
        r4.L$2 = r2;
        r4.I$0 = r27;
        r4.I$1 = r22;
        r4.label = 4;
        if (u(r29, r30, r111, r4) != r6) goto L30;
        return r6;
    L30:
        r12 = r22;
        r15 = r2;
        r13 = r27;
        r14 = r28;
        r16 = r110;
        goto L31
    L18:
        ResultKt.throwOnFailure(r3);
    L41:
        return Unit.INSTANCE;
    L19:
        String r31 = (String) r4.L$2;
        List<Message> r32 = (List) r4.L$1;
        List<wc9.e> r33 = (List) r4.L$0;
        ResultKt.throwOnFailure(r3);
        List<Message> r34 = r32;
        List<wc9.e> r35 = r33;
    L37:
        String r36 = k(r31, "handleConversationMessageNew");
        r4.L$0 = null;
        r4.L$1 = null;
        r4.L$2 = null;
        r4.label = 2;
        if (u(r35, r34, r36, r4) != r6) goto L41;
        return r6;
    L20:
        ResultKt.throwOnFailure(r3);
        ArrayList r37 = (ArrayList) r17;
        r27 = r37.size();
        FLogger r112 = FLogger.a;
        StringBuilder r113 = new StringBuilder("batchFetchBotAndBrief source=");
        r113.append(r2);
        r113.append(", convSize=");
        r113.append(r27);
        r113.append(", messageSize=");
        ArrayList r114 = (ArrayList) r18;
        r113.append(r114.size());
        r113.append(", isFirstPage=");
        r113.append(r19);
        r112.i("ConversationListModel", r113.toString());
        if (r27 <= 50) goto L33;
        if (r19 == false) goto L33;
        r22 = 20;
        List<wc9.e> r38 = r37.subList(0, 20);
        String r115 = k(r2, "findConversationBotsNew:first20");
        r4.L$0 = r37;
        r4.L$1 = r114;
        r4.L$2 = r2;
        r4.I$0 = r27;
        r4.I$1 = 20;
        r4.label = 3;
        r28 = r37;
        r110 = r114;
        if (p(r38, r115, r4) != r6) goto L27;
        return r6;
    L33:
        String r39 = k(r2, "findConversationBotsNew");
        r4.L$0 = r37;
        r4.L$1 = r114;
        r4.L$2 = r2;
        r4.label = 1;
        if (p(r37, r39, r4) != r6) goto L36;
        return r6;
    L36:
        r31 = r2;
        r34 = r114;
        r35 = r37;
    L7:
        r4 = new ConversationListModel$batchFetchBotAndBrief$1(this, r21);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0 */
    /* JADX WARN: Type inference failed for: r38v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r38v2 */
    public final Object y(List<RecommendBot> r124, String r125, int r126, wh8.a r127, Continuation<? super Unit> r128) {
        int r0 = r126;
        if ((r128 instanceof ConversationListModel$parseBotList$1) == false) goto L7;
        ConversationListModel$parseBotList$1 r2 = (ConversationListModel$parseBotList$1) r128;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        int r6 = 1;
        String r7 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        r0 = r2.I$0;
        List r8 = (List) r2.L$1;
        final wh8.a r9 = (wh8.a) r2.L$0;
        ResultKt.throwOnFailure(r1);
        List r10 = r8;
    L92:
        Boolean r11 = (Boolean) r1;
        List r12 = r10;
    L95:
        if (r0 != 10) goto L109;
        List<wh8.a> r13 = q;
        int r14 = com.larus.utils.h.g(r13, new l0(r9));
        if (r14 >= 0) goto L99;
    L102:
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("parseBotList, recommendBot(");
        if (r9 == null) goto L107;
        BotModel r17 = r9.b;
        if (r17 == null) goto L107;
        r7 = r17.getName();
    L107:
        r16.append(r7);
        r16.append(") not found, index(");
        r16.append(r14);
        r16.append(')');
        r15.w("ConversationListModel", r16.toString());
        return Unit.INSTANCE;
    L99:
        if (r14 >= r13.size()) goto L102;
        r13.remove(r9);
        j(r14, (wh8.a) CollectionsKt.first(r12));
    L122:
        FLogger.a.i("ConversationListModel", "parseBotList notifyCvsListChange");
        x(q, "parseBotList:" + r0);
        return Unit.INSTANCE;
    L109:
        List r18 = r12;
        if (r0 == 1) goto L114;
        if (r0 != 9) goto L121;
        com.larus.utils.h.h(q, new m0());
        r18 = CollectionsKt.reversed(r12);
    L121:
        G(r18, "parseBotList");
        goto L122
    L114:
        ArrayList r19 = new ArrayList();
        Iterator r20 = r12.iterator();
    L116:
        if (r20.hasNext() == false) goto L120;
        final wh8.a r21 = (wh8.a) r20.next();
        if (com.larus.utils.h.g(q, new n0(r21)) >= 0) goto L116;
        r19.add(r21);
        goto L116
    L120:
        r18 = r19;
        goto L121
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        ArrayList r22 = new ArrayList();
        Iterator r23 = r124.iterator();
    L16:
        if (r23.hasNext() == false) goto L86;
        RecommendBot r110 = (RecommendBot) r23.next();
        if (r110.M() == true) goto L85;
        if (com.larus.utils.o0.d(r110.E()) == false) goto L29;
        String r111 = r110.E();
        if (r111 == null) goto L26;
        Lazy r112 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        if (com.larus.im.j.f(r111) == true) goto L26;
        boolean r113 = true;
    L27:
        if (r113 == false) goto L29;
    L26:
        r113 = false;
    L29:
        a.getClass();
        if (r0 == 9) goto L33;
        if (r0 == 10) goto L33;
        ?? r38 = r7;
    L34:
        Lazy r114 = com.larus.im.j.a;
        String r115 = r110.o();
        if (r115 != null) goto L37;
        r115 = "";
    L37:
        String r116 = com.larus.im.j.c(r115, r7);
        BotIconImage r117 = r110.O();
        if (r117 == null) goto L40;
        String r42 = r117.getTinyUrl();
    L41:
        wc9.e r118 = new wc9.e(r116, new IconImage(null, new ImageObj(r42, 0, 0, null, null, 30, null), null, 5, null), r110.getName(), null, null, Integer.valueOf(r6), r110.F(), null, false, 3, null, null, null, null, null, null, null, null, null, null, 0, 2, null, r38, null, null, null, null, null, null, null, 0, 0, null, null, 0, -10486376, 63);
        String r119 = r110.o();
        if (r119 != null) goto L44;
        String r56 = "";
    L45:
        String r57 = r110.getName();
        BotIconImage r58 = r110.O();
        long r59 = r110.I();
        long r120 = r110.f0();
        List<BotConfItem> r87 = r110.i();
        Integer r62 = r110.r();
        ShareInfo r63 = r110.b0();
        BotCreatorInfo r64 = r110.j();
        Integer r72 = r110.Z();
        ConversationPage r67 = r110.F();
        String r69 = r110.N();
        ModelItem r73 = r110.U();
        String r75 = r110.L();
        Boolean r121 = r110.W();
        if (r121 == null) goto L48;
        boolean r76 = r121.booleanValue();
    L49:
        int r24 = (int) r110.a0();
        BotOnBoarding r25 = r110.Y();
        if (r25 == null) goto L55;
        String r26 = r25.d();
        if (r26 == null) goto L55;
        String r122 = r26;
    L56:
        BotOnBoarding r27 = r110.Y();
        if (r27 == null) goto L59;
        List<String> r123 = r27.e();
    L60:
        BotOnBoarding r28 = r110.Y();
        if (r28 == null) goto L66;
        String r29 = r28.b();
        if (r29 == null) goto L66;
        String r129 = r29;
    L67:
        BotOnBoarding r30 = r110.Y();
        if (r30 == null) goto L70;
        int r210 = r30.a();
    L71:
        BotOnBoarding r31 = r110.Y();
        if (r31 == null) goto L74;
        List<Message> r211 = r31.c();
    L75:
        com.larus.im.bean.bot.BotOnBoarding r95 = new com.larus.im.bean.bot.BotOnBoarding(r122, r123, r129, r210, r211);
        String r81 = r110.h();
        SpeakerVoice r74 = r110.i0();
        String r91 = r110.a();
        String r90 = r110.e();
        String r103 = r110.d();
        String r92 = r110.g();
        BgImageInfo r104 = r110.b();
        String r96 = r110.s();
        Boolean r97 = r110.t();
        List<ShowTagInfo> r32 = r110.c0();
        if (r32 == null) goto L78;
        ArrayList r65 = new ArrayList(r32);
    L79:
        r22.add(new wh8.a(r118, new BotModel(r56, r57, r58, r59, Long.valueOf(r120), r62, r63, r64, r65, null, r67, null, r69, 10, null, r72, r73, r74, r75, r76, Integer.valueOf(r24), null, null, null, r81, null, null, null, null, null, r87, null, 0, r90, r91, r92, null, null, r95, r96, r97, null, false, null, null, null, r103, r104, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1092597248, 2147434033, null), null, null, r125, r110.a, Integer.valueOf(r126), null, null, null, null, false, 3980));
        String r33 = r110.o();
        if (r33 != null) goto L82;
        r33 = "";
    L82:
        r7 = null;
        String r34 = com.larus.im.j.c(r33, null);
        ConcurrentHashMap<String, com.larus.im.service.d0<wc9.e>> r130 = j;
        r130.put(r34, new a1());
        com.larus.im.service.d0<wc9.e> r131 = r130.get(r34);
        if (r131 == null) goto L85;
        ((com.larus.im.service.q) c.getValue()).registerConversationChangeListener(r34, r131);
        goto L85
    L78:
        r65 = null;
        goto L79
    L74:
        r211 = null;
        goto L75
    L70:
        r210 = 0;
    L66:
        r129 = "";
        goto L67
    L59:
        r123 = null;
    L55:
        r122 = "";
        goto L56
    L48:
        r76 = false;
        goto L49
    L44:
        r56 = r119;
        goto L45
    L40:
        r42 = r7;
    L33:
        r38 = MapsKt.mapOf(new Pair("is_from_local_discovery", "1"));
    L85:
        r6 = 1;
        goto L16
    L86:
        CompletableDeferred<Boolean> r35 = f;
        if (r35 == null) goto L93;
        r2.L$0 = r127;
        r2.L$1 = r22;
        r2.I$0 = r0;
        r2.label = 1;
        Object r36 = r35.await(r2);
        if (r36 != r4) goto L91;
        return r4;
    L91:
        r10 = r22;
        r1 = r36;
        r9 = r127;
        goto L92
    L93:
        r9 = r127;
        r12 = r22;
    L7:
        r2 = new ConversationListModel$parseBotList$1(this, r128);
        goto L8
    }

    public static void w(ConversationListModel r12, final boolean r13, long r14, int r16, int r17, long r18, String r20, int r21) {
        if ((r21 & 2) == 0) goto L5;
        final long r7 = -1;
    L7:
        if ((r21 & 4) == 0) goto L9;
        final int r9 = 0;
    L11:
        if ((r21 & 8) == 0) goto L13;
        final int r10 = 0;
    L15:
        if ((r21 & 16) == 0) goto L17;
        final long r5 = -1;
    L19:
        if ((r21 & 32) == 0) goto L21;
        final String r11 = null;
    L22:
        r12.getClass();
        ThreadPlus.submitRunnable(new k0(r13, r5, r7, r9, r10, r11));
        return;
    L21:
        r11 = r20;
        goto L22
    L17:
        r5 = r18;
        goto L19
    L13:
        r10 = r17;
        goto L15
    L9:
        r9 = r16;
        goto L11
    L5:
        r7 = r14;
        goto L7
    }
}
