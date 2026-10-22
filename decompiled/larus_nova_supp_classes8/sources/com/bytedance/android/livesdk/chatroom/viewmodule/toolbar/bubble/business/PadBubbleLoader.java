package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.castscreen.utils.LivePadAndPcPlayUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleEnv;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import com.bytedance.android.livesdk.config.q61;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.keva.Keva;
import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PadBubbleLoader extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.a {
    public final String b;
    public final CompositeDisposable c;
    public final Lazy d;
    public final Lazy e;
    public boolean f;
    public boolean g;
    public boolean h;
    public final Keva i;
    public final String j;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i {
        public final int a;
        public final ToolbarButton b;
        public final pp1.c c;
        public final C0058a d;
        public final /* synthetic */ PadBubbleLoader e;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business.PadBubbleLoader$a$a, reason: collision with other inner class name */
        public static final class C0058a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a {
            public final /* synthetic */ a a;

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r2) {
                Intrinsics.checkNotNullParameter(r2, "bubble");
            }

            public C0058a(a r1) {
                this.a = r1;
            }

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r2) {
                Intrinsics.checkNotNullParameter(r2, "bubble");
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r3 = this.a.e.a.a().query(r2.getId());
                if (r3 == null) goto L6;
                r3.h();
                this.a.e.a.a().f(r3);
                return;
            }

            @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a
            public final void c(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i r13) {
                Intrinsics.checkNotNullParameter(r13, "bubble");
                if (r13.getId() != 1001) goto L43;
                PadBubbleLoader r14 = this.a.e;
                String r0 = r14.i.getString(r14.j, "");
                List r2 = null;
                if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r0) == false) goto L7;
                String r3 = r0;
            L8:
                if (r3 == null) goto L27;
                List r1 = StringsKt.split$default(r3, new String[]{","}, false, 0, 6, null);
                if (r1 == null) goto L27;
                ArrayList r4 = new ArrayList();
                Iterator r5 = r1.iterator();
            L13:
                if (r5.hasNext() == false) goto L17;
                Long r6 = StringsKt.toLongOrNull((String) r5.next());
                if (r6 == null) goto L13;
                r4.add(r6);
                goto L13
            L17:
                List r7 = CollectionsKt.toMutableList(r4);
                if (r7 == null) goto L27;
                r7.add(Long.valueOf(System.currentTimeMillis()));
                Unit r8 = Unit.INSTANCE;
                List r9 = CollectionsKt.takeLast(r7, 3);
                if (r9 == null) goto L27;
                if ((!r9.isEmpty()) == false) goto L24;
                r2 = r9;
            L24:
                if (r2 == null) goto L27;
                String r10 = CollectionsKt.joinToString$default(r2, ",", null, null, 0, null, null, 62, null);
                if (r10 == null) goto L27;
            L29:
                if (v.a() == false) goto L36;
                MorePanelBubbleAlog.SimpleAlogArgsBuilder r11 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
                r11.d(r14.b);
                r11.c("vs气泡展示记录：" + r10);
                MorePanelBubbleAlog.a(r11.b());
            L36:
                r14.i.storeString(r14.j, r10);     // Catch: Exception -> L33
                return;
            L33:
                e = move-exception;
                EnsureManager.ensureNotReachHere(e, "PadBubbleLoader: 保存近3次展示时间差失败");
                return;
            L27:
                r10 = String.valueOf(System.currentTimeMillis());
                goto L29
            L7:
                r3 = null;
                goto L8
            }
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final ToolbarButton a() {
            return this.b;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i.a getCallback() {
            return this.d;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final int getId() {
            return this.a;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i
        public final pp1.c getView() {
            return this.c;
        }

        public a(PadBubbleLoader r5) {
            this.e = r5;
            RoomContext r0 = r5.a.b;
            if (r0 != null) goto L5;
        L7:
            int r1 = BubbleId.PadCast;
        L8:
            this.a = r1;
            this.b = ToolbarButton.PAD_AND_PC_PLAY;
            int r2 = pp1.c.o;
            String r3 = ((q61) r5.d.getValue()).b();
            Intrinsics.checkNotNullParameter(r3, "content");
            pp1.c.a.C0410a r4 = new pp1.c.a.C0410a(r3);
            r4.b = (int) ((q61) r5.d.getValue()).c();
            this.c = r4.a();
            this.d = new C0058a(this);
            return;
        L5:
            if (r0.isVSRoom() != true) goto L7;
            r1 = BubbleId.PadCastForVs;
            goto L8
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final boolean S8() {
        if (com.bytedance.android.livesdk.castscreen.utils.d.c() == true) goto L5;
    L11:
        boolean r1 = false;
    L12:
        RoomContext r4 = this.a.b;
        if (r4 != null) goto L15;
    L66:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r5 = this.a.a().query(BubbleId.PadCast);
        if (r5 != null) goto L69;
        return r1;
    L69:
        boolean r8 = r5.g();
        if (Math.abs(System.currentTimeMillis() - r5.c()) > 604800000) goto L72;
        boolean r6 = true;
    L73:
        if (r8 == true) goto L78;
        if (r6 == true) goto L78;
    L76:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r2 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r2.d(this.b);
        r2.c("enable load padcast bubble guide: " + r1);
        MorePanelBubbleAlog.a(r2.b());
        return r1;
    L78:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r3 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r3.d(this.b);
        r3.c("直播间无法加载pad投屏引导气泡（频控）");
        Pair[] r7 = {TuplesKt.to("interceptShowByCommonCondition", Boolean.valueOf(r8)), TuplesKt.to("onWeekShowIntercept", Boolean.valueOf(r6))};
        int r9 = 0;
    L79:
        if (r9 >= 2) goto L86;
        Pair r10 = r7[r9];
        if (r10 == null) goto L85;
        Object r11 = r10.getSecond();
        if (r11 == null) goto L85;
        r3.a((String) r10.getFirst(), r11);
    L85:
        r9 = r9 + 1;
        goto L79
    L86:
        MorePanelBubbleAlog.a(r3.b());
        return false;
    L72:
        r6 = false;
        goto L73
    L15:
        if (r4.isVSRoom() != true) goto L66;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.g.b r12 = this.a.a().query(BubbleId.PadCastForVs);
        if (r12 != null) goto L19;
        return r1;
    L19:
        Calendar r13 = Calendar.getInstance();
        r13.add(2, -3);
        long r14 = r13.getTimeInMillis();
        boolean r15 = r12.e();
        long r16 = System.currentTimeMillis();
        String r17 = this.i.getString(this.j, "");
        if (r17 != null) goto L22;
    L45:
        boolean r18 = false;
    L46:
        if (r15 == false) goto L48;
    L52:
        boolean r19 = false;
    L53:
        if (r15 == true) goto L56;
        if (r18 == true) goto L56;
        if (r19 == false) goto L76;
    L56:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r20 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r20.d(this.b);
        r20.c("vs直播间无法加载pad投屏引导气泡（频控）");
        Pair[] r21 = {TuplesKt.to("hasFinished", Boolean.valueOf(r15)), TuplesKt.to("inVsInterval", Boolean.valueOf(r18)), TuplesKt.to("isTimeout", Boolean.valueOf(r19))};
        int r22 = 0;
    L57:
        if (r22 >= 3) goto L64;
        Pair r23 = r21[r22];
        if (r23 == null) goto L63;
        Object r24 = r23.getSecond();
        if (r24 == null) goto L63;
        r20.a((String) r23.getFirst(), r24);
    L63:
        r22 = r22 + 1;
        goto L57
    L64:
        MorePanelBubbleAlog.a(r20.b());
        return false;
    L48:
        if (r12.d() < 5) goto L52;
        if (r12.c() >= r14) goto L52;
        r19 = true;
        goto L53
    L22:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r17) == true) goto L25;
        r17 = null;
    L25:
        String r110 = r17;
        if (r110 == null) goto L45;
        List r111 = StringsKt.split$default(r110, new String[]{","}, false, 0, 6, null);
        if (r111 == null) goto L45;
        ArrayList r112 = new ArrayList();
        Iterator r113 = r111.iterator();
    L31:
        if (r113.hasNext() == false) goto L35;
        Long r114 = StringsKt.toLongOrNull((String) r113.next());
        if (r114 == null) goto L31;
        r112.add(r114);
        goto L31
    L35:
        List r115 = CollectionsKt.asReversed(r112);
        if (r115 == null) goto L45;
        Iterator r116 = r115.iterator();
        int r117 = 0;
    L39:
        if (r116.hasNext() == false) goto L45;
        if (Math.abs(r16 - ((Number) r116.next()).longValue()) > 604800000) goto L44;
        if (r117 < 2) goto L44;
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r25 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r25.d(this.b);
        r25.c("展示pad引导气泡被拦截，vs房间一周最多展示3次");
        MorePanelBubbleAlog.a(r25.b());
        r18 = true;
    L44:
        r117 = r117 + 1;
        goto L39
    L5:
        if (PadConfigUtils.a() == true) goto L11;
        if (z.e(this.a.c, false) == true) goto L11;
        if (((q61) this.d.getValue()).d() != 1) goto L11;
        r1 = true;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.i T8() {
        return new a(this);
    }

    public final void b() {
        boolean r0 = LivePadAndPcPlayUtil.i(this.a.c);
        boolean r1 = LivePadAndPcPlayUtil.g(this.a.c);
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r2 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r2.d(this.b);
        r2.c("check2ShowBubble");
        int r6 = 0;
        Pair[] r4 = {TuplesKt.to("isTimeToShow", Boolean.valueOf(this.f)), TuplesKt.to("hasDevices", Boolean.valueOf(this.g)), TuplesKt.to("hasNotify2Show", Boolean.valueOf(this.h)), TuplesKt.to("pcRoomAuthEnable", Boolean.valueOf(r0)), TuplesKt.to("padRoomAuthEnable", Boolean.valueOf(r1))};
    L3:
        if (r6 >= 5) goto L10;
        Pair r5 = r4[r6];
        if (r5 == null) goto L9;
        Object r8 = r5.getSecond();
        if (r8 == null) goto L9;
        r2.a((String) r5.getFirst(), r8);
    L9:
        r6 = r6 + 1;
        goto L3
    L10:
        MorePanelBubbleAlog.a(r2.b());
        if (this.f == true) goto L13;
        return;
    L13:
        if (this.g == true) goto L15;
        return;
    L15:
        if (this.h == true) goto L26;
        if (r0 == false) goto L27;
        if (r1 == false) goto L28;
        this.h = true;
        a();
        return;
    L28:
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onLoad() {
        this.g = ((IHostBusiness) this.e.getValue()).hasPadDevice();
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r0 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r0.d(this.b);
        r0.c("checkDevices");
        r0.a("hasDevices", Boolean.valueOf(this.g));
        MorePanelBubbleAlog.a(r0.b());
        if (this.g == true) goto L7;
        Pair r1 = ((IHostBusiness) this.e.getValue()).startScanPadDevice();
        if (r1 == null) goto L8;
        this.c.add((Disposable) r1.getFirst());
        RxUtilKt.c(RxUtilKt.h((Observable) r1.getSecond()).subscribe(new f(this), g.a), this.c);
    L8:
        Function0<Unit> r2 = new PadBubbleLoader$checkTime2Show$1(this);
        ILivePlayerClient r3 = LivePlatformPlayerManager.f();
        Boolean r4 = null;
        if (r3 == null) goto L13;
        IRoomEventHub r5 = r3.getEventHub();
        if (r5 == null) goto L13;
        MutableLiveData r6 = r5.getFirstFrame();
    L14:
        if (r6 == null) goto L17;
        r4 = (Boolean) r6.getValue();
    L17:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L19;
        r2.invoke();
        return;
    L19:
        i r7 = new i(r2);
        if (r6 == null) goto L22;
        r6.observeForever(r7);
    L22:
        this.c.add(Disposables.fromAction(new h(r6, r7)));
        return;
    L13:
        r6 = null;
        goto L14
    L7:
        b();
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.h
    public final void onUnload() {
        this.c.clear();
    }

    public PadBubbleLoader(BubbleEnv r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        super(r2);
        this.b = "PadBubbleLoader";
        this.c = new CompositeDisposable();
        this.d = LazyKt.lazy(PadBubbleLoader$setting$2.INSTANCE);
        this.e = LazyKt.lazy(PadBubbleLoader$hostBusiness$2.INSTANCE);
        this.i = Keva.getRepo("PadBubble");
        this.j = "PadCastForVs";
    }
}
