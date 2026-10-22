package l61;

import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import com.bytedance.android.live.room.api.experience.utils.PlatformExpUtils;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class d implements b {
    public final String a;
    public final LivePerfBizType b;

    public static class a extends d {
        public final LivePerfBizLevel c;
        public final String d;

        /* JADX INFO: renamed from: l61.d$a$a, reason: collision with other inner class name */
        public static final class C0267a extends a {
            public static final C0267a e = null;

            static {
                e = new C0267a();
            }

            public C0267a() {
                super("comment_carnival", "评论狂欢", 0);
            }
        }

        public static final class a0 extends a {
            public static final a0 e = null;

            static {
                e = new a0();
            }

            public a0() {
                super("disable_hour_rank", "屏蔽小时榜", 1);
            }
        }

        public static final class a1 extends a {
            public static final a1 e = null;

            static {
                e = new a1();
            }

            public a1() {
                super("disable_landscape_lottery_message", "横屏福袋弹幕", 0);
            }
        }

        public static final class b extends a {
            public static final b e = null;

            static {
                e = new b();
            }

            public b() {
                super("disable_animation_layer", "屏蔽动画层", 0);
            }
        }

        public static final class b0 extends a {
            public static final b0 e = null;

            static {
                e = new b0();
            }

            public b0() {
                super("disable_ktv_control", "屏蔽KTV能力", 0);
            }
        }

        public static final class b1 extends a {
            public static final b1 e = null;

            static {
                e = new b1();
            }

            public b1() {
                super("like_flow", "飘赞", 0);
            }
        }

        public static final class c extends a {
            public static final c e = null;

            static {
                e = new c();
            }

            public c() {
                super("disable_audience_sticker", "屏蔽观众侧贴纸", 0);
            }
        }

        public static final class c0 extends a {
            public static final c0 e = null;

            static {
                e = new c0();
            }

            public c0() {
                super("disable_live_public_screen_feedback", "屏蔽公屏区问卷", 0);
            }
        }

        public static final class c1 extends a {
            public static final c1 e = null;

            static {
                e = new c1();
            }

            public c1() {
                super("live_drawer_anim", "更多直播动画", 0);
            }
        }

        /* JADX INFO: renamed from: l61.d$a$d, reason: collision with other inner class name */
        public static final class C0268d extends a {
            public static final C0268d e = null;

            static {
                e = new C0268d();
            }

            public C0268d() {
                super("disable_backtrace_widget", "屏蔽回溯场景", 0);
            }
        }

        public static final class d0 extends a {
            public static final d0 e = null;

            static {
                e = new d0();
            }

            public d0() {
                super("disable_live_room_feedback", "屏蔽直播问卷", 0);
            }
        }

        public static final class d1 extends a {
            public static final d1 e = null;

            static {
                e = new d1();
            }

            public d1() {
                super("disable_normal_message_degrade", "普通消息降级", 0);
            }
        }

        public static final class e extends a {
            public static final e e = null;

            static {
                e = new e();
            }

            public e() {
                super("disable_carnival_danmaku_widget", "屏蔽竖屏弹幕狂欢组件", 0);
            }
        }

        public static final class e0 extends a {
            public static final e0 e = null;

            static {
                e = new e0();
            }

            public e0() {
                super("disable_long_touch", "屏蔽长触", 1);
            }
        }

        public static final class e1 extends a {
            public static final e1 e = null;

            static {
                e = new e1();
            }

            public e1() {
                super("portrait_danmaku", "竖屏场景下弹幕", 0);
            }
        }

        public static final class f extends a {
            public static final f e = null;

            static {
                e = new f();
            }

            public f() {
                super("disable_toolbar_cast_screen", "屏蔽投屏功能", 0);
            }
        }

        public static final class f0 extends a {
            public static final f0 e = null;

            static {
                e = new f0();
            }

            public f0() {
                super("disable_lynx_alpha_player_widget", "屏蔽进场动画装扮组件", 0);
            }
        }

        public static final class f1 extends a {
            public static final f1 e = null;

            static {
                e = new f1();
            }

            public f1() {
                super("public_screen_anim", "公屏动画", 1);
            }
        }

        public static final class g extends a {
            public static final g e = null;

            static {
                e = new g();
            }

            public g() {
                super("disable_ceremony_border_widget", "屏蔽庆典边框", 0);
            }
        }

        public static final class g0 extends a {
            public static final g0 e = null;

            static {
                e = new g0();
            }

            public g0() {
                super("disable_portrait_row2nd_discovery_tetris", "竖屏第二行左侧发现区", 0);
            }
        }

        public static final class g1 extends a {
            public final int e;

            public g1(int r4) {
                super("short_touch_anim", "短触动画", 1);
                this.e = r4;
            }
        }

        public static final class h extends a {
            public static final h e = null;

            static {
                e = new h();
            }

            public h() {
                super("disable_ceremony_prize_notice", "屏蔽盛典到达", 0);
            }
        }

        public static final class h0 extends a {
            public static final h0 e = null;

            static {
                e = new h0();
            }

            public h0() {
                super("disable_portrait_row4th_tetris", "竖屏第四行拖拽区", 0);
            }
        }

        public static final class h1 extends a {
            public static final h1 e = null;

            static {
                e = new h1();
            }

            public h1() {
                super("toolbar_anim", "Toolbar动画", 1);
            }
        }

        public static final class i extends a {
            public static final i e = null;

            static {
                e = new i();
            }

            public i() {
                super("disable_chat_channel_atmosphere_widget", "屏蔽聊天频道氛围彩蛋", 0);
            }
        }

        public static final class i0 extends a {
            public static final i0 e = null;

            static {
                e = new i0();
            }

            public i0() {
                super("disable_portrait_zdanmaku_widget", "屏蔽竖屏弹幕组件", 0);
            }
        }

        public static final class i1 extends a {
            public static final i1 e = null;

            static {
                e = new i1();
            }

            public i1() {
                super("disable_ultimate_message_degrade", "极致消息降级", 1);
            }
        }

        public static final class j extends a {
            public static final j e = null;

            static {
                e = new j();
            }

            public j() {
                super("disable_chat_channel_ime_emoji_anim_widget", "屏蔽IM互动表情动画", 0);
            }
        }

        public static final class j0 extends a {
            public static final j0 e = null;

            static {
                e = new j0();
            }

            public j0() {
                super("disable_quick_comment", "屏蔽快捷评论", 0);
            }
        }

        public static final class k extends a {
            public static final k e = null;

            static {
                e = new k();
            }

            public k() {
                super("disable_common_guide_widget", "屏蔽通用引导", 0);
            }
        }

        public static final class k0 extends a {
            public static final k0 e = null;

            static {
                e = new k0();
            }

            public k0() {
                super("disable_record_widget", "屏蔽录屏场景", 0);
            }
        }

        public static final class l extends a {
            public static final l e = null;

            static {
                e = new l();
            }

            public l() {
                super("disable_common_lottie_animation_widget", "屏蔽Lottie动画组件", 0);
            }
        }

        public static final class l0 extends a {
            public static final l0 e = null;

            static {
                e = new l0();
            }

            public l0() {
                super("disable_room_notify_widget", "屏蔽房间广播组件", 0);
            }
        }

        public static final class m extends a {
            public static final m e = null;

            static {
                e = new m();
            }

            public m() {
                super("disable_dig_accessibility_widget", "屏蔽无障碍场景", 0);
            }
        }

        public static final class m0 extends a {
            public static final m0 e = null;

            static {
                e = new m0();
            }

            public m0() {
                super("disable_top_atmosphere_widget", "屏蔽飘屏特效", 0);
            }
        }

        public static final class n extends a {
            public static final n e = null;

            static {
                e = new n();
            }

            public n() {
                super("disable_drawer_entrance_common", "屏蔽直播抽屉", 0);
            }
        }

        public static final class n0 extends a {
            public static final n0 e = null;

            static {
                e = new n0();
            }

            public n0() {
                super("disable_top_left_window_card", "屏蔽左上卡片", 0);
            }
        }

        public static final class o extends a {
            public static final o e = null;

            static {
                e = new o();
            }

            public o() {
                super("disable_ds_guide", "屏蔽DS专项引导动画", 0);
            }
        }

        public static final class o0 extends a {
            public static final o0 e = null;

            static {
                e = new o0();
            }

            public o0() {
                super("disable_top_right_banner", "屏蔽活动banner", 1);
            }
        }

        public static final class p extends a {
            public static final p e = null;

            static {
                e = new p();
            }

            public p() {
                super("disable_enter_anim_widget", "屏蔽进场动画组件", 0);
            }
        }

        public static final class p0 extends a {
            public static final p0 e = null;

            static {
                e = new p0();
            }

            public p0() {
                super("disable_top_right_window_card", "屏蔽右上卡片", 0);
            }
        }

        public static final class q extends a {
            public static final q e = null;

            static {
                e = new q();
            }

            public q() {
                super("disable_fans_rank_animation", "屏蔽粉丝团动画", 0);
            }
        }

        public static final class q0 extends a {
            public static final q0 e = null;

            static {
                e = new q0();
            }

            public q0() {
                super("disable_wgame_invite_control", "屏蔽WGAME游戏邀请", 0);
            }
        }

        public static final class r extends a {
            public static final r e = null;

            static {
                e = new r();
            }

            public r() {
                super("disable_game_honor_widget", "屏蔽场景荣誉成就展示", 0);
            }
        }

        public static final class r0 extends a {
            public static final r0 e = null;

            static {
                e = new r0();
            }

            public r0() {
                super("game_live_player_drop_frame", "游戏直播播放器丢帧", 1);
            }
        }

        public static final class s extends a {
            public static final s e = null;

            static {
                e = new s();
            }

            public s() {
                super("disable_game_sticker", "屏蔽游戏贴纸能力", 0);
            }
        }

        public static final class s0 extends a {
            public static final s0 e = null;

            static {
                e = new s0();
            }

            public s0() {
                super("disable_game_promote_card_anim", "游戏推广卡片动画", 0);
            }
        }

        public static final class t extends a {
            public static final t e = null;

            static {
                e = new t();
            }

            public t() {
                super("disable_gift_effect", "屏蔽大礼物效果", 1);
            }
        }

        public static final class t0 extends a {
            public static final t0 e = null;

            static {
                e = new t0();
            }

            public t0() {
                super("gift_tray_anim", "礼物托盘动画", 0);
            }
        }

        public static final class u extends a {
            public static final u e = null;

            static {
                e = new u();
            }

            public u() {
                super("disable_gift_touch", "屏蔽礼物触摸", 0);
            }
        }

        public static final class u0 extends a {
            public static final u0 e = null;

            static {
                e = new u0();
            }

            public u0() {
                super("high_level_ecom_anim", "高级购买消息", 0);
            }
        }

        public static final class v extends a {
            public static final v e = null;

            static {
                e = new v();
            }

            public v() {
                super("disable_gift_tray", "屏蔽礼物托盘", 1);
            }
        }

        public static final class v0 extends a {
            public static final v0 e = null;

            static {
                e = new v0();
            }

            public v0() {
                super("disable_high_level_ecom", "高级购买消息", 0);
            }
        }

        public static final class w extends a {
            public static final w e = null;

            static {
                e = new w();
            }

            public w() {
                super("disable_global_notify", "屏蔽全服广播", 1);
            }
        }

        public static final class w0 extends a {
            public static final w0 e = null;

            static {
                e = new w0();
            }

            public w0() {
                super("high_level_enter_anim", "高级进房消息", 2);
            }
        }

        public static final class x extends a {
            public static final x e = null;

            static {
                e = new x();
            }

            public x() {
                super("disable_guide_widget", "屏蔽引导", 0);
            }
        }

        public static final class x0 extends a {
            public static final x0 e = null;

            static {
                e = new x0();
            }

            public x0() {
                super("hot_comment_tray", "热评托盘", 0);
            }
        }

        public static final class y extends a {
            public static final y e = null;

            static {
                e = new y();
            }

            public y() {
                super("disable_high_level_enter", "屏蔽高级进场", 1);
            }
        }

        public static final class y0 extends a {
            public static final y0 e = null;

            static {
                e = new y0();
            }

            public y0() {
                super("hour_rank", "屏蔽小时榜", 1);
            }
        }

        public static final class z extends a {
            public static final z e = null;

            static {
                e = new z();
            }

            public z() {
                super("disable_highlight_tetris_widget", "屏蔽高光容器", 0);
            }
        }

        public static final class z0 extends a {
            public static final z0 e = null;

            static {
                e = new z0();
            }

            public z0() {
                super("interactive_comp_delay_for_strategy", "交互层延迟组件(策略中心)", 0);
            }
        }

        @Override // l61.b
        public final String getDesc() {
            return this.d;
        }

        @Override // l61.b
        public final LivePerfBizLevel getLevel() {
            return this.c;
        }

        public a(String r7, String r8, int r9) {
            Intrinsics.checkNotNullParameter(r7, "key");
            Intrinsics.checkNotNullParameter(r8, "defaultDesc");
            super(r7, LivePerfBizType.Degrade);
            Lazy r1 = PlatformExpUtils.a;
            Intrinsics.checkNotNullParameter(r7, "key");
            LivePerfBizLevel.a r2 = LivePerfBizLevel.Companion;
            Map r3 = PlatformExpUtils.c().b();
            LivePerfBizLevel r4 = null;
            if (r3 == null) goto L5;
            Integer r5 = (Integer) r3.get(r7);
        L6:
            r2.getClass();
            if (r5 == null) goto L10;
            int r6 = r5.intValue();
            r2.getClass();
            LivePerfBizLevel r10 = LivePerfBizLevel.a.a(r6);
            if (r10 == null) goto L10;
        L11:
            LivePerfBizLevel r12 = LivePerfBizLevel.Unknown;
            if (r10 == r12) goto L14;
            boolean r13 = true;
        L15:
            if (r13 == false) goto L17;
            r4 = r10;
        L17:
            if (r4 != null) goto L25;
            Integer r14 = Integer.valueOf(r9);
            if (r14 == null) goto L24;
            int r15 = r14.intValue();
            r2.getClass();
            LivePerfBizLevel r16 = LivePerfBizLevel.a.a(r15);
            if (r16 == null) goto L24;
            r12 = r16;
        L24:
            r4 = r12;
        L25:
            this.c = r4;
            Intrinsics.checkNotNullParameter(r7, "key");
            String r17 = (String) PlatformExpUtils.c().c().get(r7);
            if (r17 == null) goto L29;
            r8 = r17;
        L29:
            this.d = r8;
            return;
        L14:
            r13 = false;
        L10:
            r10 = LivePerfBizLevel.Unknown;
            goto L11
        L5:
            r5 = null;
            goto L6
        }
    }

    @Override // l61.b
    public final String getKey() {
        return this.a;
    }

    @Override // l61.b
    public LivePerfBizType getType() {
        return this.b;
    }

    public d(String r1, LivePerfBizType r2) {
        this.a = r1;
        this.b = r2;
    }
}
