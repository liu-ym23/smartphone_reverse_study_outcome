package com.ss.android.lark.chat.message.menu.v2;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatTnsInfo;
import com.ss.android.lark.chat.entity.chat.ChatTnsOpKind;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.message.menu.MessageActionManager;
import com.ss.android.lark.chat.message.menu.v2.popup.PopupMenu;
import com.ss.android.lark.chat.message.menu.v2.popup.PopupMenuContentContainer;
import com.ss.android.lark.chat.message.menu.v2.popup.PopupMenuPartialContent;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.a1;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import y6b.a;
import z5c.n2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageActionPanelManager<MVO extends y6b.a<?>> {
    public static final /* synthetic */ int E = 0;
    public final Lazy A;
    public final CopyOnWriteArrayList<com.ss.android.lark.biz.im.api.extension.chat_window.g<Object>> B;
    public final Lazy C;
    public final Lazy D;
    public final m2b.a a;
    public final com.ss.android.lark.chat.message.menu.v2.e<MVO> b;
    public final RecyclerView c;
    public boolean d;
    public yya.f e;
    public com.ss.android.lark.biz.im.api.message.params.m f;
    public final String g;
    public MessageActionPanel h;
    public PopupMenu i;
    public PopupMenu j;
    public String k;
    public int[] l;
    public final boolean m;
    public final int[] n;
    public View o;
    public boolean p;
    public final f q;
    public final d r;
    public final e s;
    public final g t;
    public final c u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public Function1<? super Integer, Unit> y;
    public Function0<Unit> z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MessageActionType.values().length];
            r0[MessageActionType.DING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L38:
            r0[MessageActionType.REPLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L58:
            r0[MessageActionType.COPY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L42:
            r0[MessageActionType.FORWARD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L46:
            r0[MessageActionType.ADD_TO_FAVORITE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L36:
            r0[MessageActionType.MULTI_SELECT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L52:
            r0[MessageActionType.PIN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L54:
            r0[MessageActionType.RECALL.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L40:
            r0[MessageActionType.TRANSLATE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L44:
            r0[MessageActionType.DELETE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L15:
            a = r0;
            int[] r1 = new int[ReplyInThreadUtil.ReplyOptimizeFGState.values().length];
            r1[ReplyInThreadUtil.ReplyOptimizeFGState.ONLINE_STATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L34:
            r1[ReplyInThreadUtil.ReplyOptimizeFGState.EXP1_STATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L48:
            r1[ReplyInThreadUtil.ReplyOptimizeFGState.EXP2_STATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L19:
            b = r1;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ MessageActionPanelManager<MVO> a;

        public c(MessageActionPanelManager<MVO> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageActionPanel r0 = this.a.h;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.j();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.chat.utils.u r0 = com.ss.android.lark.chat.utils.u.a.a;     // Catch: Throwable -> L17
            monitor-enter(r0);     // Catch: Throwable -> L17
            com.ss.android.lark.chat.utils.u.c r1 = r0.a;     // Catch: Throwable -> L14
            if (r1 != null) goto L7;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L17
            return;
        L7:
            if (r0.d == false) goto L12;
            r1.c();     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L17
            return;
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L26;
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ MessageActionPanelManager<MVO> a;

        public e(MessageActionPanelManager<MVO> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageActionPanel r0 = this.a.h;     // Catch: Throwable -> L13
            if (r0 == null) goto L7;
            boolean r2 = true;
            if (r0.n() != true) goto L7;
        L8:
            if (r2 == false) goto L16;
            final MessageActionPanel r1 = this.a.h;     // Catch: Throwable -> L13
            if (r1 == null) goto L20;
            final a1 r3 = com.ss.android.lark.chat.utils.u.a.a.b(false);     // Catch: Throwable -> L13
            r1.k(new MessageActionPanel$restoreShow$1(r1, r3));     // Catch: Throwable -> L13
            return;
        L20:
            return;
        L16:
            return;
        L7:
            r2 = false;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ MessageActionPanelManager<MVO> a;

        public f(MessageActionPanelManager<MVO> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageActionPanelManager<MVO> r0 = this.a;     // Catch: Throwable -> L19
            if (r0.m == false) goto L22;
            com.ss.android.lark.chat.utils.u r1 = com.ss.android.lark.chat.utils.u.a.a;     // Catch: Throwable -> L19
            int[] r2 = r0.l;     // Catch: Throwable -> L19
            monitor-enter(r1);     // Catch: Throwable -> L19
            com.ss.android.lark.chat.utils.u.c r3 = r1.a;     // Catch: Throwable -> L16
            if (r3 != null) goto L9;
        L14:
            monitor-exit(r1);     // Catch: Throwable -> L19
            return;
        L9:
            if (r1.d == false) goto L14;
            r3.d(r2);     // Catch: Throwable -> L16
            monitor-exit(r1);     // Catch: Throwable -> L19
            return;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        L22:
            return;
        L19:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L29;
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ MessageActionPanelManager<MVO> a;

        public g(MessageActionPanelManager<MVO> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final MessageActionPanel r0 = this.a.h;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.k(new MessageActionPanel$tempDismiss$1(r0));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final void b() {
        this.b.getClass();
        com.ss.android.lark.chat.message.menu.v2.e<MVO> r0 = this.b;
        MessageActionPanelManager$keyboardEventCenterHandler$2.a r1 = (MessageActionPanelManager$keyboardEventCenterHandler$2.a) this.A.getValue();
        ((s2b.c) r0).e.j7(r1);
    }

    public final com.larksuite.framework.callback.c d() {
        return (com.larksuite.framework.callback.c) this.w.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map c(y6b.a r5) {
        Map r0 = ChatParamUtils.h(r5);
        T r6 = r5.b();
        if ((r6 instanceof com.ss.android.lark.chat.base.view.vo.message.e) == false) goto L6;
        DocResult r7 = ((com.ss.android.lark.chat.base.view.vo.message.e) r6).i;
    L9:
        String r1 = "none";
        if (r7 == null) goto L15;
        Doc r2 = r7.getDoc();
        if (r2 == null) goto L15;
        String r3 = r2.getId();
        if (r3 == null) goto L15;
    L16:
        if (r7 == null) goto L22;
        Doc r4 = r7.getDoc();
        if (r4 == null) goto L22;
        DocType r8 = r4.getDocType();
        if (r8 == null) goto L22;
        r1 = ChatHitPointNew.k(r8);
    L22:
        if (r7 == null) goto L24;
        String r9 = "true";
    L25:
        Map r10 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("file_id", com.ss.android.lark.utils.y.a(r3)), TuplesKt.to("file_type", r1), TuplesKt.to("is_single_doc", r9)});
        r10.putAll(r0);
        return r10;
    L24:
        r9 = "false";
    L15:
        r3 = "none";
        goto L16
    L6:
        if ((r6 instanceof PostContentVO) == false) goto L8;
        r7 = ((PostContentVO) r6).i;
        goto L9
    L8:
        r7 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [com.ss.android.lark.chat.message.menu.v2.MessageActionPanelManager$createOnScrollListener$1] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.ss.android.lark.chat.message.menu.v2.MessageActionPanelManager$createAdapterDataObserver$1] */
    public final boolean e(final y6b.a r26, com.ss.android.lark.chat.message.menu.context.a r27) {
        Intrinsics.checkNotNullParameter(r27, "itemHook");
        if (r26 != null) goto L6;
        Log.e(this.g, "generate menu failed, item == null");
        return false;
    L6:
        s2b.c r2 = (s2b.c) this.b;
        r2.getClass();
        y6b.c r8 = (y6b.c) r26;
        s2b.b r9 = new s2b.b(r2, r27, r2.g, r2.b, r2.c, r8);
        Lazy r1 = MessageActionManager.a;
        Intrinsics.checkNotNullParameter(r9, "actionContext");
        if (MessageActionManager.f(r9, MessageActionManager.d(r9)) == false) goto L10;
        Log.i(this.g, "suppress long-press menu by interceptor, msgId=" + r26.getId());
        return true;
    L10:
        s2b.c r3 = (s2b.c) this.b;
        r3.getClass();
        if (r3.b.getChat() != null) goto L14;
    L35:
        boolean r4 = true;
    L36:
        if (r4 == false) goto L38;
        return false;
    L38:
        Map r10 = c(r26);
        if (this.d == true) goto L131;
        com.ss.android.lark.chat.utils.u r15 = com.ss.android.lark.chat.utils.u.a.a;
        boolean r7 = r15.c;
        t r5 = new t(this, r7, r10, System.currentTimeMillis());
        monitor-enter(r15);
        com.ss.android.lark.chat.utils.u.c r6 = r15.a;     // Catch: Throwable -> L126
        if (r6 != null) goto L47;
        monitor-exit(r15);
    L49:
        final MessageActionPanel r11 = this.h;
        if (r11 != null) goto L53;
        boolean r12 = r7;
        Map r17 = r10;
        t r13 = r5;
        boolean r14 = false;
    L87:
        if (r14 == false) goto L89;
        Log.i(this.g, "dismiss exist message action panel, not show new panel");
    L123:
        boolean r16 = true;
    L125:
        return r16;
    L89:
        if (r12 == false) goto L92;
        Log.e(this.g, "showOverlayMessageMenu failed, wrong step: partial select but show all message action");
    L91:
        r16 = false;
        goto L125
    L92:
        s2b.c r18 = (s2b.c) this.b;
        r18.getClass();
        t r19 = r13;
        s2b.b r20 = new s2b.b(r18, r27, r18.g, r18.b, r18.c, r8);
        List<ActionGroup> r21 = FetchMessageActionListConfig.a;
        List r22 = FetchMessageActionListConfig.b((com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.C.getValue(), this.a.getChat());
        if (r22.isEmpty() == true) goto L99;
        com.ss.android.lark.chat.message.menu.d r23 = f(r20, r22, r19);
        if (r23.a.isEmpty() == false) goto L101;
        if (r23.c == false) goto L99;
    L101:
        if (r15.d == true) goto L103;
        ((s2b.c) this.b).getClass();
        r27.f();
    L103:
        u r24 = new u(System.currentTimeMillis(), r17, this);
        final com.ss.android.lark.chat.message.menu.context.a r110 = r27;
        y r25 = new y(this, r110);
        FragmentActivity r28 = this.a.getContext();
        View r29 = this.c;
        if (r29 != null) goto L107;
        r29 = r27.a();
    L107:
        Intrinsics.checkNotNullParameter(r28, "context");
        Intrinsics.checkNotNullParameter(r29, "forsetiAnchorView");
        ArrayList r30 = new ArrayList();
        i r31 = new i(r29, r28);
        List<? extends zya.e> r32 = r23.a;
        if (r32 == null) goto L113;
        if ((!r32.isEmpty()) != true) goto L113;
        boolean r33 = true;
    L114:
        if (r33 == false) goto L116;
        r30.clear();
        r30.addAll(r32);
    L116:
        x r34 = new x(r24, this, r26, r110);
        Intrinsics.checkNotNullParameter(r34, "listener");
        boolean r35 = r23.c;
        Intrinsics.checkNotNullParameter(r25, "dependency");
        final MessageActionPanel r111 = new MessageActionPanel(r28, r31, r30, r34, r35, r25);
        final Ref.BooleanRef r36 = new Ref.BooleanRef();
        v r37 = new v(this, new MessageActionPanelManager$createOnScrollListener$1(this, r36, r26, r111), r111, r26, new MessageActionPanelManager$createAdapterDataObserver$1(r111, this), r24, r27, r20);
        Intrinsics.checkNotNullParameter(r37, "listener");
        r111.T = r37;
        r15.d(new w(this));
    L117:
        if (r111 == null) goto L91;
        this.y = new MessageActionPanelManager$showOverlayMessageMenu$1(this, r110, r111, r26);
        if (((s2b.c) this.b).e.m7() == true) goto L122;
        this.y.invoke(0);
        goto L123
    L122:
        ((s2b.c) this.b).a(false);
        b();
        ((s2b.c) this.b).e.i7();
    L113:
        r33 = false;
    L99:
        r110 = r27;
        r111 = null;
        goto L117
    L53:
        if (r15.f == true) goto L55;
        i0.a(r11, false, null, 7);
        r12 = r7;
        r17 = r10;
        r13 = r5;
    L86:
        r14 = true;
        goto L87
    L55:
        int r38 = r15.g;
        if (r38 != 1) goto L58;
        boolean r39 = true;
    L59:
        r15.f = false;
        r15.g = 0;
        r15.c = true;
        s2b.c r40 = (s2b.c) this.b;
        r40.getClass();
        boolean r112 = r39;
        r17 = r10;
        r12 = r7;
        s2b.b r41 = new s2b.b(r40, r27, r40.g, r40.b, r40.c, r8);
        List r42 = (List) FetchMessageActionListConfig.d.getValue();
        if (r42.isEmpty() == false) goto L62;
        r13 = r5;
        com.ss.android.lark.chat.message.menu.d r43 = null;
    L63:
        if (r43 == null) goto L65;
        final List<? extends zya.e> r44 = r43.a;
    L66:
        List<? extends zya.e> r45 = r44;
        if (r45 != null) goto L69;
    L72:
        boolean r46 = true;
    L73:
        if (r46 == false) goto L75;
        r11.j();
        goto L86
    L75:
        final a1 r47 = r15.b(true);
        Intrinsics.checkNotNullParameter(r44, "messageActionList");
        if (r44.isEmpty() == true) goto L85;
        r11.c = r44;
        if (r47 == null) goto L84;
        r11.P = m0.a(r11.P, null, 0.0f, false, PanelActionType.PARTIAL_ACTION, 7);
        MessageActionPanelContainerLayout r48 = r11.t;
        if (r48 == null) goto L83;
        r48.i = true;
    L83:
        r11.k(new MessageActionPanel$changeMessageActionType$1(r11, r44, r47));
        goto L85
    L84:
        r11.P = m0.a(r11.P, null, 0.0f, false, PanelActionType.ALL_ACTION, 7);
        r11.k(new MessageActionPanel$changeMessageActionType$2(r11, r44));
    L85:
        Log.i(this.g, "restore overlay panel by selection update, isCursorDrag=" + r112);
        g(r26, true, r38);
        goto L86
    L69:
        if (r45.isEmpty() == true) goto L72;
        r46 = false;
        goto L73
    L65:
        r44 = null;
        goto L66
    L62:
        r13 = r5;
        r43 = f(r41, r42, r13);
        goto L63
    L58:
        r39 = false;
        goto L59
    L47:
        r6.b();     // Catch: Throwable -> L126
        monitor-exit(r15);
    L126:
        th = move-exception;
        throw th;
    L131:
        return h(r26, r27, r10, null);
    L14:
        if (r8.j() == true) goto L35;
        w4b.d0 r49 = b7b.b.a;
        if (r8.Y == true) goto L23;
        long r50 = r8.Z;
        if (r50 > 0) goto L20;
    L22:
        boolean r51 = false;
    L24:
        if (r51 == true) goto L35;
        if (r8.y == true) goto L35;
        if (r8.I == true) goto L35;
        if (r8.z == true) goto L35;
        if (r8.Q == true) goto L35;
        r4 = false;
        goto L36
    L20:
        if (r50 > b7b.b.a.a()) goto L22;
    L23:
        r51 = true;
        goto L24
    }

    public final z i(y6b.a r23, final yya.n r24) {
        Intrinsics.checkNotNullParameter(r23, "item");
        Intrinsics.checkNotNullParameter(r24, "itemHook");
        Chat r1 = this.a.getChat();
        final Integer r9 = null;
        if (r1 == null) goto L7;
        ChatTnsInfo r2 = r1.getChatTnsInfo();
        if (r2 == null) goto L7;
        ChatTnsOpKind r3 = r2.getTnsOpKind();
    L9:
        if (r3 != ChatTnsOpKind.TNS_OP_BANNED) goto L11;
        return null;
    L11:
        Activity r4 = this.a.getContext();
        if ((r4 instanceof Activity) == false) goto L14;
        Activity r10 = r4;
    L15:
        if (r10 != null) goto L17;
        return null;
    L17:
        t r11 = new t(this, false, null, System.currentTimeMillis());
        com.ss.android.lark.chat.utils.u r5 = com.ss.android.lark.chat.utils.u.a.a;
        monitor-enter(r5);
        com.ss.android.lark.chat.utils.u.c r6 = r5.a;     // Catch: Throwable -> L60
        if (r6 != null) goto L23;
        monitor-exit(r5);
    L25:
        final a1 r14 = r5.b(true);
        s2b.c r7 = (s2b.c) this.b;
        r7.getClass();
        final s2b.b r15 = new s2b.b(r7, r24, r7.g, r7.b, r7.c, (y6b.c) r23);
        ((yya.a) r15).c = true;
        if (((List) FetchMessageActionListConfig.d.getValue()).isEmpty() == false) goto L28;
        return null;
    L28:
        yya.f r8 = this.e;
        if (r8 == null) goto L31;
        r8.a(r23, r24);
    L31:
        MessageActionType r12 = MessageActionType.FLOW_ASK_DOUBAO;
        List r13 = CollectionsKt.listOf(new yya.k(CollectionsKt.listOf(new MessageActionType[]{MessageActionType.COPY, r12}), 1, 8));
        final Ref.ObjectRef r16 = new Ref.ObjectRef();
        r16.element = f(r15, r13, r11);
        if (r23.getType() != Message.Type.DOUBAO) goto L35;
        com.ss.android.lark.chat.message.menu.d r0 = (com.ss.android.lark.chat.message.menu.d) r16.element;
        List<? extends zya.e> r17 = r0.a;
        Map<MessageActionType, ? extends List<zya.b>> r18 = r0.b;
        Map<MessageActionType, List<yya.i>> r19 = r0.d;
        List<yya.e> r20 = r0.e;
        Intrinsics.checkNotNullParameter(r17, "actionList");
        Intrinsics.checkNotNullParameter(r18, "typeToVOList");
        Intrinsics.checkNotNullParameter(r19, "actionsMapIncludingGone");
        Intrinsics.checkNotNullParameter(r20, "featureInterceptors");
        r16.element = new com.ss.android.lark.chat.message.menu.d(r17, r18, false, r19, r20);
    L35:
        if (((com.ss.android.lark.chat.message.menu.d) r16.element).a.isEmpty() == false) goto L37;
        return null;
    L37:
        final boolean r21 = ((s2b.c) this.b).e.m7();
        final int[] r22 = new int[2];
        r24.a().getLocationInWindow(r22);
        final int r110 = r22[1];
        final Ref.ObjectRef r111 = new Ref.ObjectRef();
        List<zya.b> r25 = ((com.ss.android.lark.chat.message.menu.d) r16.element).b.get(r12);
        if (r25 == null) goto L40;
        zya.b r26 = (zya.b) CollectionsKt.firstOrNull(r25);
    L41:
        r111.element = r26;
        if (r26 == null) goto L44;
        r9 = ((s2b.c) this.b).e.l7();
    L44:
        final Activity r27 = r10;
        this.z = new MessageActionPanelManager$showTextSelectPopup$1(r21, r24, r22, r110, r27, r15, r16, r9, r14, this, r111);
        if (((s2b.c) this.b).e.m7() == true) goto L47;
        this.z.invoke();
    L59:
        return new z();
    L47:
        WeakReference<com.ss.android.lark.widget.select.m> r28 = com.ss.android.lark.chat.message.menu.a.a;
        if (r28 == null) goto L57;
        com.ss.android.lark.widget.select.m r29 = r28.get();
        if (r29 == null) goto L57;
        com.ss.android.lark.widget.select.m.b r30 = r29.g;
        if (r30 == null) goto L54;
        r30.setAlpha(0.0f);
    L54:
        com.ss.android.lark.widget.select.m.b r31 = r29.h;
        if (r31 == null) goto L57;
        r31.setAlpha(0.0f);
    L57:
        ((s2b.c) this.b).a(false);
        b();
        ((s2b.c) this.b).e.i7();
        goto L59
    L40:
        r26 = null;
        goto L41
    L23:
        r6.b();     // Catch: Throwable -> L60
        monitor-exit(r5);
    L60:
        th = move-exception;
        throw th;
    L14:
        r10 = null;
    L7:
        r3 = null;
        goto L9
    }

    public MessageActionPanelManager(m2b.a r2, com.ss.android.lark.chat.message.menu.v2.e<MVO> r3, RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        if (FetchMessageActionListConfig.a == null) goto L5;
    L8:
        r3.getClass();
        this.g = "ChatMessageCellClickHandler";
        this.m = true;
        this.n = new int[2];
        this.q = new f(this);
        this.r = d.a;
        this.s = new e(this);
        this.t = new g(this);
        this.u = new c(this);
        this.v = LazyKt.lazy(MessageActionPanelManager$mainHandler$2.INSTANCE);
        this.w = LazyKt.lazy(new MessageActionPanelManager$cancelableCallbackExecutor$2(this));
        this.x = LazyKt.lazy(new MessageActionPanelManager$showSelectedWindowThrottle$2(this));
        this.y = MessageActionPanelManager$startOverlayMenuAction$1.INSTANCE;
        this.z = MessageActionPanelManager$showTextSelectPopupMenu$1.INSTANCE;
        this.A = LazyKt.lazy(new MessageActionPanelManager$keyboardEventCenterHandler$2(this));
        this.B = new CopyOnWriteArrayList();
        this.C = LazyKt.lazy(new MessageActionPanelManager$chatContainer$2(this));
        this.D = LazyKt.lazy(new MessageActionPanelManager$fgService$2(this));
        return;
    L5:
        if (FetchMessageActionListConfig.b != null) goto L8;
        SettingManager.getInstance().get(NormalMessageActionListConfig.class, new FetchMessageActionListConfig$initConfig$1());
        goto L8
    }

    public static final boolean a(MessageActionPanelManager r4, RecyclerView r5, String r6) {
        r4.getClass();
        LinearLayoutManager r7 = r5.getLayoutManager();
        if ((r7 instanceof LinearLayoutManager) == false) goto L18;
        LinearLayoutManager r8 = r7;
        int r9 = r8.findFirstVisibleItemPosition();
        int r1 = r8.findLastVisibleItemPosition();
        if (r9 > r1) goto L14;
    L7:
        View r2 = r8.findViewByPosition(r9);
        if (r2 != null) goto L10;
    L12:
        if (r9 == r1) goto L19;
        r9 = r9 + 1;
        goto L7
    L19:
        return false;
    L10:
        if (Intrinsics.areEqual(r6, r2.getTag(2131379971)) == false) goto L12;
        return true;
    L14:
        return false;
    L18:
        return false;
    }

    public final com.ss.android.lark.chat.message.menu.d f(s2b.b r7, List r8, t r9) {
        Lazy r0 = MessageActionManager.a;
        Intrinsics.checkNotNullParameter(r7, "actionContext");
        if ((!MessageActionManager.f(r7, MessageActionManager.d(r7))) == true) goto L6;
        Log.i(this.g, "skip message action generation for unsupported message, msgId=" + r7.h.c + ", page=" + r7.e.name());
        return new com.ss.android.lark.chat.message.menu.d(CollectionsKt.emptyList(), MapsKt.emptyMap(), false, MapsKt.emptyMap(), CollectionsKt.emptyList());
    L6:
        List<yya.l> r1 = ((s2b.c) this.b).e.a();
        if (r1 == null) goto L14;
        Iterator<T> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L14;
        yya.l r3 = (yya.l) r2.next();
        Lazy r4 = MessageActionManager.a;
        Intrinsics.checkNotNullParameter(r3, "interceptor");
        Log.i("MessageActionManager", "addInterceptor: " + r3.getTAG());
        Lazy r5 = MessageActionManager.b;
        if (((CopyOnWriteArrayList) r5.getValue()).contains(r3) == true) goto L10;
        ((CopyOnWriteArrayList) r5.getValue()).add(r3);
    L14:
        com.ss.android.lark.chat.message.menu.d r10 = MessageActionManager.a(r7, r8, r9);
        List<yya.l> r11 = ((s2b.c) this.b).e.a();
        if (r11 == null) goto L20;
        Iterator<T> r12 = r11.iterator();
    L18:
        if (r12.hasNext() == false) goto L20;
        yya.l r13 = (yya.l) r12.next();
        Lazy r6 = MessageActionManager.a;
        Intrinsics.checkNotNullParameter(r13, "interceptor");
        Log.i("MessageActionManager", "removeInterceptor: " + r13.getTAG());
        ((CopyOnWriteArrayList) MessageActionManager.b.getValue()).remove(r13);
    L20:
        return r10;
    }

    public final void g(MVO r8, boolean r9, int r10) {
        Map r0 = MapsKt.toMutableMap(ChatParamUtils.h(r8));
        ReplyInThreadUtil.ReplyOptimizeFGState r1 = ReplyInThreadUtil.d((jdb.g) this.D.getValue());
        int r2 = b.b[r1.ordinal()];
        boolean r3 = false;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L6;
        Map r4 = MapsKt.mapOf(TuplesKt.to("ab_version", 1));
    L12:
        r0.putAll(r4);
        s5c.a r5 = n2.c;
        r5.getClass();
        s5c.d r6 = s5c.d.b.a(r5, r0);
        Chat r7 = this.a.getChat();
        if (r7 == null) goto L15;
        r6 = r6.plus(ChatParamUtils.b(r7, ChatCoreModule.a().getLoginDependency().getUserId(), 4));
    L15:
        String r11 = "double_press";
        if (r10 == 1) goto L20;
        if (r10 == 2) goto L19;
        String r12 = null;
    L21:
        this.k = r12;
        if (r9 == false) goto L26;
        if (r12 == null) goto L25;
        r6 = r6.plus(MapsKt.mapOf(TuplesKt.to("menu_open_action", r12)));
    L25:
        Statistics.sendEvent("im_msg_select_text_menu_view", r6.toJson());
    L28:
        if (com.ss.android.lark.chat.utils.u.a.a.d == false) goto L32;
        if (r10 != 2) goto L32;
        r3 = true;
    L32:
        if (r3 == true) goto L35;
        r11 = "msg_press";
    L35:
        s2b.c r13 = (s2b.c) this.b;
        r13.getClass();
        r13.c((y6b.c) r8, r11);
        return;
    L26:
        Statistics.sendEvent("im_msg_menu_view", r6.toJson());
        goto L28
    L19:
        r12 = "double_press";
        goto L21
    L20:
        r12 = "select_words";
        goto L21
    L6:
        if (r2 != 3) goto L9;
        r4 = MapsKt.mapOf(TuplesKt.to("ab_version", 2));
        goto L12
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        r4 = MapsKt.mapOf(TuplesKt.to("ab_version", 0));
        goto L12
    }

    public final boolean h(final y6b.a r23, final com.ss.android.lark.chat.message.menu.context.a r24, Map r25, List r26) {
        com.ss.android.lark.chat.utils.u r7 = com.ss.android.lark.chat.utils.u.a.a;
        int r1 = r7.g;
        if (r7.d == false) goto L7;
        if (r1 != 2) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        String r3 = "double_press";
    L11:
        List r12 = null;
        ChatHitPointNew.f(this.a.getChat(), r3, ChatHitPointNew.c(r3), ChatHitPointNew.b(this.a, r23, null, null, null));
        PopupMenu r4 = this.j;
        if (r4 != null) goto L15;
        boolean r5 = false;
    L38:
        if (r5 == false) goto L41;
        Log.i(this.g, "update existing text select popup");
        return true;
    L41:
        Chat r6 = this.a.getChat();
        if (r6 == null) goto L46;
        ChatTnsInfo r8 = r6.getChatTnsInfo();
        if (r8 == null) goto L46;
        ChatTnsOpKind r9 = r8.getTnsOpKind();
    L48:
        if (r9 != ChatTnsOpKind.TNS_OP_BANNED) goto L50;
        return true;
    L50:
        Activity r10 = this.a.getContext();
        if ((r10 instanceof Activity) == false) goto L53;
        Activity r13 = r10;
    L54:
        if (r13 != null) goto L56;
        return false;
    L56:
        t r14 = new t(this, false, r25, System.currentTimeMillis());
        monitor-enter(r7);
        com.ss.android.lark.chat.utils.u.c r11 = r7.a;     // Catch: Throwable -> L86
        if (r11 != null) goto L62;
        monitor-exit(r7);
    L64:
        s2b.c r15 = (s2b.c) this.b;
        r15.getClass();
        final s2b.b r16 = new s2b.b(r15, r24, r15.g, r15.b, r15.c, (y6b.c) r23);
        List<ActionGroup> r17 = FetchMessageActionListConfig.a;
        if (FetchMessageActionListConfig.b((com.ss.android.lark.chat.chatwindow.chat.v2.push.v) this.C.getValue(), this.a.getChat()).isEmpty() == false) goto L67;
        return false;
    L67:
        if (r26 != null) goto L77;
        yya.f r18 = this.e;
        if (r18 == null) goto L71;
        r12 = r18.b(r23, r24);
    L71:
        if (r12 == null) goto L73;
        List r19 = r12;
    L78:
        final com.ss.android.lark.chat.message.menu.d r20 = f(r16, r19, r14);
        if (r20.a.isEmpty() == false) goto L81;
        return false;
    L81:
        final u r21 = new u(System.currentTimeMillis(), r25, this);
        final Activity r22 = r13;
        this.y = new MessageActionPanelManager$showPopupMenu$1(r22, r16, r20, r24, this, r21, r23);
        if (((s2b.c) this.b).e.m7() == true) goto L84;
        this.y.invoke(0);
    L85:
        return true;
    L84:
        ((s2b.c) this.b).a(false);
        b();
        ((s2b.c) this.b).e.i7();
        goto L85
    L73:
        if (r23.t() != MessageDLPState.BLOCK) goto L75;
        r19 = CollectionsKt.listOf(new yya.k(CollectionsKt.listOf(new MessageActionType[]{MessageActionType.COPY_MESSAGE_ID, MessageActionType.DELETE}), 0, 8));
        goto L78
    L75:
        MessageActionType[] r27 = {MessageActionType.FLOW_LIKE, MessageActionType.FLOW_DISLIKE};
        MessageActionType[] r28 = {MessageActionType.COPY, MessageActionType.SELECT_TEXT, MessageActionType.ADD_STICKER, MessageActionType.IMAGE_TO_STICKER};
        MessageActionType[] r29 = {MessageActionType.REPLY, MessageActionType.FORWARD, MessageActionType.FORWARD_REPLY_IN_THREAD, MessageActionType.FOLLOW_UP_QUESTION};
        MessageActionType[] r30 = {MessageActionType.RECALL, MessageActionType.REEDIT, MessageActionType.MULTI_SELECT, MessageActionType.DELETE};
        MessageActionType r31 = MessageActionType.FLOW_MORE;
        r19 = CollectionsKt.listOf(new yya.k[]{new yya.k(CollectionsKt.listOf(r27), 1, 8), new yya.k(CollectionsKt.listOf(r28), 0, 8), new yya.k(CollectionsKt.listOf(r29), 0, 8), new yya.k(CollectionsKt.listOf(r30), 0, 8), new yya.k(BuildConfig.FLAVOR, CollectionsKt.listOf(r31), 0, MapsKt.mapOf(TuplesKt.to(r31, CollectionsKt.listOf(new yya.d[]{new yya.d(MessageActionType.REPLY_IN_THREAD), new yya.d(MessageActionType.FLOW_FEEDBACK), new yya.d(MessageActionType.COPY_MESSAGE_ID)}))))});
        goto L78
    L77:
        r19 = r26;
        goto L78
    L62:
        r11.b();     // Catch: Throwable -> L86
        monitor-exit(r7);
    L86:
        th = move-exception;
        throw th;
    L53:
        r13 = null;
    L46:
        r9 = null;
        goto L48
    L15:
        if (r7.f == true) goto L18;
        i0.a(r4, false, null, 7);
    L37:
        r5 = true;
        goto L38
    L18:
        if (r7.g != 1) goto L20;
        boolean r32 = true;
    L21:
        r7.f = false;
        r7.g = 0;
        a1 r33 = r7.b(true);
        Log.i(this.g, "restore text select popup by selection update, isCursorDrag=" + r32);
        if (r33 == null) goto L24;
        Point r34 = new Point(r33.f + ((r33.d + r33.c) / 2), r33.a);
    L25:
        if (r34 == null) goto L36;
        PopupMenuPartialContent r35 = r4.i;
        if (r35 == null) goto L29;
        ViewParent r36 = r35.getParent();
    L31:
        if ((r36 instanceof PopupMenuContentContainer) == false) goto L33;
        PopupMenuContentContainer r37 = (PopupMenuContentContainer) r36;
    L34:
        if (r37 == null) goto L36;
        r37.setAnchorPoint(r34);
        goto L36
    L33:
        r37 = null;
        goto L34
    L29:
        r36 = null;
    L36:
        r4.f().setVisibility(0);
        goto L37
    L24:
        r34 = null;
        goto L25
    L20:
        r32 = false;
        goto L21
    L10:
        r3 = "msg_press";
    L7:
        r2 = false;
        goto L8
    }
}
