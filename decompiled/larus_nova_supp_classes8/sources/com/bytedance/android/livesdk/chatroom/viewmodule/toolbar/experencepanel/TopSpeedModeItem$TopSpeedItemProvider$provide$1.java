package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeManager;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.keva.Keva;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lnp1/g;", "Lnp1/a;", "invoke", "(Lnp1/g;)Lnp1/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class TopSpeedModeItem$TopSpeedItemProvider$provide$1 extends Lambda implements Function1<np1.g, np1.a> {
    final /* synthetic */ h.a this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.TopSpeedModeItem$TopSpeedItemProvider$provide$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lnp1/e;", "", "invoke", "(Lnp1/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function1<np1.e, Unit> {
        final /* synthetic */ np1.g $receiver$0;
        final /* synthetic */ TopSpeedModeItem$TopSpeedItemProvider$provide$1 this$0;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.TopSpeedModeItem$TopSpeedItemProvider$provide$1$2$a */
        public static final class a implements np1.d<np1.a> {
            public final /* synthetic */ AnonymousClass2 a;
            public final /* synthetic */ np1.e b;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.TopSpeedModeItem$TopSpeedItemProvider$provide$1$2$a$a, reason: collision with other inner class name */
            public static final class ViewOnClickListenerC0073a implements View.OnClickListener {
                public final /* synthetic */ a a;

                public ViewOnClickListenerC0073a(a r1) {
                    this.a = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View r3) {
                    ILiveActionHandler r4 = k.n(IRoomService.class).actionHandler();
                    Context r0 = this.a.b.c.getContext();
                    String r1 = TopSpeedModeUtils.d().i();
                    if (r1 != null) goto L5;
                    r1 = "sslocal://webcast_lynxview?type=popup&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fcommunity_openlive_douyin%2Fpages%2Fextreme_mode_faq%2Ftemplate.js&mix_container_type=annie&bdhm_bid=community_openlive&bdhm_pid=extreme_mode_faq&gravity=bottom&height_percent=60&width_percent=100&rate_height=700&horizontal_width=390";
                L5:
                    r4.handle(r0, r1);
                    com.bytedance.android.live.room.api.playopt.topspeed.log.a.c("rule", true, "matual");
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.TopSpeedModeItem$TopSpeedItemProvider$provide$1$2$a$b */
            public static final class b<T> implements Consumer {
                public final /* synthetic */ a a;

                public b(a r1) {
                    this.a = r1;
                }

                public final void accept(Object r2) {
                    String r3 = (String) r2;
                    TextView r0 = this.a.a.this$0.this$0.c;
                    if (r0 == null) goto L6;
                    r0.setText(r3);
                    return;
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.TopSpeedModeItem$TopSpeedItemProvider$provide$1$2$a$c */
            public static final class c<T> implements Consumer {
                public final /* synthetic */ a a;

                public c(a r1) {
                    this.a = r1;
                }

                public final void accept(Object r2) {
                    Integer r3 = (Integer) r2;
                    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r4 = this.a.a.this$0.this$0;
                    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a.a(r4.d, r4.b);
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.TopSpeedModeItem$TopSpeedItemProvider$provide$1$2$a$d */
            public static final class d<T> implements Consumer {
                public final /* synthetic */ a a;

                public d(a r1) {
                    this.a = r1;
                }

                public final void accept(Object r2) {
                    Integer r3 = (Integer) r2;
                    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r4 = this.a.a.this$0.this$0;
                    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a.a(r4.d, r4.b);
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.TopSpeedModeItem$TopSpeedItemProvider$provide$1$2$a$e */
            public static final class e implements LiveSwitchButton.e {
                public final /* synthetic */ a a;

                public e(a r1) {
                    this.a = r1;
                }

                @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
                public final void d0(LiveSwitchButton r3, boolean r4) {
                    com.bytedance.android.live.room.api.playopt.base.a.b(r4);
                    LinearLayout r5 = this.a.a.this$0.this$0.e;
                    if (r5 == null) goto L8;
                    if (r4 == false) goto L6;
                    int r1 = 0;
                L7:
                    r5.setVisibility(r1);
                    goto L8
                L6:
                    r1 = 8;
                L8:
                    if (r4 == false) goto L10;
                    f2.c("已开启极速性能模式", 0);
                L14:
                    if (this.a.a.this$0.this$0.i == true) goto L16;
                    com.bytedance.android.live.room.api.playopt.topspeed.log.a.c("topspeed_mode_on_off", r4, "matual");
                L16:
                    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r6 = this.a.a.this$0.this$0;
                    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a.a(r6.d, r6.b);
                    return;
                L10:
                    f2.c("已关闭极速性能模式", 0);
                    this.a.a.this$0.this$0.i = false;
                    com.bytedance.android.livesdk.sharedpref.e r7 = TopSpeedModeManager.l.a;
                    Boolean r2 = Boolean.TRUE;
                    r7.getClass();
                    com.bytedance.android.livesdk.sharedpref.f.d(r7, r2);
                    TextView r8 = this.a.a.this$0.this$0.c;
                    if (r8 == null) goto L14;
                    r8.setText(TopSpeedModeUtils.e(0));
                    goto L14
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.TopSpeedModeItem$TopSpeedItemProvider$provide$1$2$a$f */
            public static final class f<T> implements Consumer {
                public final /* synthetic */ a a;

                public f(a r1) {
                    this.a = r1;
                }

                public final void accept(Object r3) {
                    Boolean r4 = (Boolean) r3;
                    if (r4.booleanValue() == false) goto L8;
                    com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r0 = this.a.a.this$0.this$0;
                    r0.i = true;
                    LiveSwitchButton r1 = r0.f;
                    if (r1 == null) goto L9;
                    r1.setChecked(r4.booleanValue());
                    return;
                L9:
                    return;
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.TopSpeedModeItem$TopSpeedItemProvider$provide$1$2$a$g */
            public static final class g implements LiveSwitchButton.e {
                public static final g a = null;

                static {
                    a = new g();
                }

                public g() {
                }

                @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
                public final void d0(LiveSwitchButton r4, boolean r5) {
                    Keva r6 = com.bytedance.android.live.room.api.playopt.base.a.a;
                    StringBuilder r0 = new StringBuilder();
                    r0.append(r5);
                    r0.append(',');
                    r0.append(System.currentTimeMillis());
                    r6.storeString("base_function_switch", r0.toString());
                    com.bytedance.android.live.room.api.playopt.base.a.d.a(Boolean.valueOf(r5));
                    TopSpeedModeManager.l.e();
                    com.bytedance.android.live.room.api.playopt.topspeed.log.a.c("sub_topspeed_quality", r5, "matual");
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.TopSpeedModeItem$TopSpeedItemProvider$provide$1$2$a$h */
            public static final class h implements LiveSwitchButton.e {
                public static final h a = null;

                static {
                    a = new h();
                }

                public h() {
                }

                @Override // com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton.e
                public final void d0(LiveSwitchButton r4, boolean r5) {
                    Keva r6 = com.bytedance.android.live.room.api.playopt.base.a.a;
                    StringBuilder r0 = new StringBuilder();
                    r0.append(r5);
                    r0.append(',');
                    r0.append(System.currentTimeMillis());
                    r6.storeString("top_speed_switch", r0.toString());
                    com.bytedance.android.live.room.api.playopt.base.a.f.a(Boolean.valueOf(r5));
                    TopSpeedModeManager.l.e();
                    com.bytedance.android.live.room.api.playopt.topspeed.log.a.c("sub_topspeed_all_function", r5, "matual");
                }
            }

            @Override // np1.d
            public final View a(ViewGroup r5) {
                Intrinsics.checkNotNullParameter(r5, "parentView");
                View r0 = this.a.this$0.this$0.a;
                if (r0 != null) goto L32;
                r0 = LayoutInflater.from(r5.getContext()).inflate(2131567448, r5, false);
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r6 = this.a.this$0.this$0;
                r6.a = r0;
                TextView r1 = null;
                if (r0 == null) goto L7;
                View r2 = r0.findViewById(2131392604);
            L8:
                r6.b = r2;
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r7 = this.a.this$0.this$0;
                View r3 = r7.a;
                if (r3 == null) goto L11;
                LiveSwitchButton r4 = (LiveSwitchButton) r3.findViewById(2131387832);
            L12:
                r7.f = r4;
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r8 = this.a.this$0.this$0;
                View r9 = r8.a;
                if (r9 == null) goto L15;
                LinearLayout r10 = (LinearLayout) r9.findViewById(2131387542);
            L16:
                r8.e = r10;
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r11 = this.a.this$0.this$0;
                View r12 = r11.a;
                if (r12 == null) goto L19;
                LiveSwitchButton r13 = (LiveSwitchButton) r12.findViewById(2131387930);
            L20:
                r11.g = r13;
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r14 = this.a.this$0.this$0;
                View r15 = r14.a;
                if (r15 == null) goto L23;
                LiveSwitchButton r16 = (LiveSwitchButton) r15.findViewById(2131387874);
            L24:
                r14.h = r16;
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r17 = this.a.this$0.this$0;
                View r18 = r17.a;
                if (r18 == null) goto L27;
                TextView r19 = (TextView) r18.findViewById(2131389227);
            L28:
                r17.d = r19;
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r20 = this.a.this$0.this$0;
                View r21 = r20.a;
                if (r21 == null) goto L31;
                r1 = (TextView) r21.findViewById(2131390015);
            L31:
                r20.c = r1;
                goto L32
            L27:
                r19 = null;
                goto L28
            L23:
                r16 = null;
                goto L24
            L19:
                r13 = null;
                goto L20
            L15:
                r10 = null;
                goto L16
            L11:
                r4 = null;
                goto L12
            L7:
                r2 = null;
            L32:
                return r0;
            }

            public a(AnonymousClass2 r1, np1.e r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // np1.d
            public final void b(np1.a r2, View r3) {
                Intrinsics.checkNotNullParameter(r2, "model");
                Intrinsics.checkNotNullParameter(r3, "itemView");
                ((ImageView) r3.findViewById(2131375949)).setOnClickListener(new ViewOnClickListenerC0073a(this));
                TextView r4 = this.a.this$0.this$0.c;
                if (r4 == null) goto L5;
                Lazy r5 = TopSpeedModeUtils.a;
                r4.setText(TopSpeedModeUtils.e(((Number) TopSpeedModeManager.l.j.a).intValue()));
            L5:
                TopSpeedModeManager r6 = TopSpeedModeManager.l;
                RxUtilKt.c(r6.k.subscribe(new b(this)), this.a.$receiver$0.f);
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a r7 = this.a.this$0.this$0;
                com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.h.a.a(r7.d, r7.b);
                RxUtilKt.c(r6.e.subscribe(new c(this)), this.a.$receiver$0.f);
                RxUtilKt.c(r6.f.subscribe(new d(this)), this.a.$receiver$0.f);
                LiveSwitchButton r8 = this.a.this$0.this$0.f;
                if (r8 == null) goto L8;
                r8.setChecked(((Boolean) com.bytedance.android.live.room.api.playopt.base.a.c.a).booleanValue());
            L8:
                LinearLayout r9 = this.a.this$0.this$0.e;
                if (r9 != null) goto L11;
            L15:
                LiveSwitchButton r10 = this.a.this$0.this$0.f;
                if (r10 == null) goto L18;
                r10.setOnCheckedChangeListener(new e(this));
            L18:
                RxUtilKt.c(r6.g.subscribe(new f(this)), this.a.$receiver$0.f);
                LiveSwitchButton r11 = this.a.this$0.this$0.g;
                if (r11 == null) goto L21;
                r11.setChecked(((Boolean) com.bytedance.android.live.room.api.playopt.base.a.e.a).booleanValue());
            L21:
                LiveSwitchButton r12 = this.a.this$0.this$0.g;
                if (r12 == null) goto L24;
                r12.setOnCheckedChangeListener(g.a);
            L24:
                LiveSwitchButton r13 = this.a.this$0.this$0.h;
                if (r13 == null) goto L27;
                r13.setChecked(((Boolean) com.bytedance.android.live.room.api.playopt.base.a.g.a).booleanValue());
            L27:
                LiveSwitchButton r14 = this.a.this$0.this$0.h;
                if (r14 == null) goto L31;
                r14.setOnCheckedChangeListener(h.a);
                return;
            L31:
                return;
            L11:
                if (((Boolean) com.bytedance.android.live.room.api.playopt.base.a.c.a).booleanValue() == false) goto L13;
                int r0 = 0;
            L14:
                r9.setVisibility(r0);
                goto L15
            L13:
                r0 = 8;
                goto L14
            }
        }

        public AnonymousClass2(TopSpeedModeItem$TopSpeedItemProvider$provide$1 r1, np1.g r2) {
            this.this$0 = r1;
            this.$receiver$0 = r2;
            super(1);
        }

        public final void invoke(np1.e r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.b = new a(this, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((np1.e) r1);
            return Unit.INSTANCE;
        }
    }

    public TopSpeedModeItem$TopSpeedItemProvider$provide$1(h.a r1) {
        this.this$0 = r1;
        super(1);
    }

    public final np1.a invoke(final np1.g r4) {
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        h.a r0 = this.this$0;
        np1.c r1 = r4.j;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "panelContext");
        if (TopSpeedModeUtils.a() == true) goto L5;
        return null;
    L5:
        np1.a.C0403a r2 = np1.a.a;
        Function0<np1.e> r3 = new AnonymousClass1(r4);
        AnonymousClass2 r5 = new AnonymousClass2(this, r4);
        r2.getClass();
        return np1.a.C0403a.a(r3, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((np1.g) r1);
    }
}
