package com.bytedance.android.live.platformplayer.panel;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.nk;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.GameOpenPanelContentAdapterConfig;
import com.bytedance.android.livesdkapi.model.StreamAutoAdapterConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.chatroom.clearscreen.ClearScreenManagerAbility;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements d {
    public final float a;
    public LivePlayerView b;
    public float c;
    public float d;
    public final float e;
    public Animator f;
    public float g;
    public float h;
    public float i;
    public float j;
    public boolean k;
    public final b l;
    public final Lazy m;
    public final StreamAutoAdapterService n;

    /* JADX INFO: renamed from: com.bytedance.android.live.platformplayer.panel.a$a, reason: collision with other inner class name */
    public static final class C0186a {
    }

    static {
    }

    public a() {
        StreamAutoAdapterService r0 = StreamAutoAdapterService.o;
        Intrinsics.checkNotNullParameter(r0, "adapterService");
        this.n = r0;
        this.a = 0.999f;
        this.c = 0.999f;
        this.e = 0.5f;
        this.g = 1.0f;
        this.h = 1.0f;
        this.i = 1.0f;
        this.l = new b();
        this.m = LazyKt.lazy(GameStreamAutoAdapterViewHandler$config$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.platformplayer.panel.d
    public final void D() {
        if (this.c == this.a) goto L11;
        this.n.getClass();
        StreamAutoAdapterConfig r0 = StreamAutoAdapterService.b();
        if (r0 == null) goto L11;
        if (r0.getSearchSceneFix() != true) goto L11;
        LivePlayerView r1 = this.b;
        if (r1 == null) goto L11;
        r1.setScrollY((int) this.c);
    L11:
        float r2 = this.a;
        this.c = r2;
        this.d = 0.0f;
        this.b = null;
        this.f = null;
        this.g = r2;
        this.h = r2;
        this.i = r2;
    }

    public static boolean a(nk r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r1 = r5.T();
        int r2 = nk.a;
        if (r1 == 4) goto L8;
        return false;
    L8:
        if (r5.Q() >= r5.P()) goto L20;
        float r3 = 0;
        if (r5.Q() < r3) goto L21;
        float r4 = 1;
        if (r5.Q() <= r4) goto L14;
        return false;
    L14:
        if (r5.P() >= r3) goto L16;
        return false;
    L16:
        if (r5.P() > r4) goto L24;
        return true;
    L24:
        return false;
    L21:
        return false;
    L20:
        return false;
    }

    @Override // com.bytedance.android.live.platformplayer.panel.d
    public final void E(float r5) {
        if (Float.isNaN(r5) == false) goto L5;
        return;
    L5:
        LivePlayerView r0 = this.b;
        if (r0 == null) goto L9;
        float r1 = this.d + (r5 * this.e);
        this.n.e("onPanelScroll, newScrollY : " + r1);
        r0.scrollTo(r0.getScrollX(), (int) r1);
        return;
    }

    @Override // com.bytedance.android.live.platformplayer.panel.d
    public final void H(LivePlayerView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.b = r2;
    }

    @Override // com.bytedance.android.live.platformplayer.panel.d
    public final void G(ds0.b r12, String r13, Boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "panelEvent");
        this.n.e("adapterStreamOnClose ,panelEvent = " + r12.getType() + ' ');
        LivePlayerView r0 = this.b;
        if (r0 != null) goto L7;
        this.n.e("adaptStream failed. playerView is null");
        return;
    L7:
        if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L20;
        this.n.e("restoreHorizontalScale, ");
        if (this.k == false) goto L43;
        ObjectAnimator r15 = ObjectAnimator.ofFloat(r0, "scaleX", new float[]{this.g, this.h});
        r15.setDuration(200);
        r15.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r0, "scaleY", new float[]{this.g, this.i});
        r2.setDuration(200);
        r2.setInterpolator(new AccelerateInterpolator());
        float r16 = r0.getScrollY() - this.j;
        Animator r17 = this.f;
        if (r17 != null) goto L14;
    L18:
        ObjectAnimator r18 = ObjectAnimator.ofInt(r0, "scrollY", new int[]{(int) r16, (int) this.j});
        r18.setDuration(0);
        r18.start();
        Unit r19 = Unit.INSTANCE;
        this.f = r18;
        this.n.e("run restore animator");
        AnimatorSet r110 = new AnimatorSet();
        r110.playTogether(new Animator[]{r15, r2});
        r110.start();
        this.k = false;
        return;
    L14:
        if (r17.isRunning() != true) goto L18;
        Animator r111 = this.f;
        if (r111 == null) goto L18;
        r111.cancel();
        goto L18
    L43:
        return;
    L20:
        this.n.e("restoreVerticalScroll ,panelEvent = " + r12.getType() + ' ');
        if (this.k == true) goto L23;
    L41:
        this.n.e("no need restoreStream.");
        return;
    L23:
        if (r0.getScrollY() == 0) goto L41;
        float r112 = r0.getScrollY() - this.c;
        this.n.e("restoreStream. scroll y : " + r112 + ", origin y " + this.c);
        Animator r3 = this.f;
        if (r3 != null) goto L28;
    L32:
        ObjectAnimator r113 = ObjectAnimator.ofInt(r0, "scrollY", new int[]{(int) r112, (int) this.c});
        r113.setDuration(0);
        r113.start();
        Unit r1 = Unit.INSTANCE;
        this.f = r113;
        this.n.e("run restore animator");
        if (((GameOpenPanelContentAdapterConfig) this.m.getValue()).getHideInteract() == true) goto L35;
    L40:
        this.k = false;
        return;
    L35:
        if (r12.getType() == LivePanelType.INPUT) goto L40;
        jg1.b r114 = ClearScreenManagerAbility.INSTANCE.getInstance(r13);
        if (r114 == null) goto L39;
        r114.a(this.l.a);
    L39:
        xs2.b.a().post(new ToolbarClearScreenEvent(false, true));
        goto L40
    L28:
        if (r3.isRunning() != true) goto L32;
        this.n.e("cancel running animator");
        Animator r4 = this.f;
        if (r4 == null) goto L32;
        r4.cancel();
        goto L32
    }

    @Override // com.bytedance.android.live.platformplayer.panel.d
    public final void F(nk r21, ds0.b r22, String r23, Boolean r24) {
        Intrinsics.checkNotNullParameter(r22, "panelEvent");
        if (((GameOpenPanelContentAdapterConfig) this.m.getValue()).getSwitch() == true) goto L5;
        return;
    L5:
        this.n.e("game adaptStreamOnOpen isLandscape = " + r24 + ' ');
        LivePlayerView r4 = this.b;
        if (r4 != null) goto L9;
        this.n.e("adaptStream failed. playerView is null");
        return;
    L9:
        ILivePlayerClient r5 = r4.getClient();
        if (r5 != null) goto L12;
    L14:
        LivePlayerView r6 = this.b;
        if (r6 == null) goto L23;
        ILivePlayerClient r7 = r6.getClient();
        if (r7 == null) goto L23;
        Boolean r9 = (Boolean) r7.extraRenderController().eventHub().getExtraRenderIsShow().getValue();
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r9, r10) == false) goto L21;
    L22:
        boolean r8 = true;
    L24:
        float r11 = 1.0f;
        float r12 = 0.0f;
        if (Intrinsics.areEqual(r24, Boolean.TRUE) == true) goto L27;
        Integer r19 = null;
        if (r8 == false) goto L143;
        this.n.e("verticalScrollWithExtraView ,panelEvent = " + r22.getType() + ' ');
        IRenderView r13 = r4.getRenderView();
        if (r13 == null) goto L84;
        View r14 = r13.getSelfView();
        if (r14 == null) goto L84;
        int r15 = r14.getTop();
    L85:
        IRenderView r16 = r4.getRenderView();
        if (r16 == null) goto L90;
        View r17 = r16.getSelfView();
        if (r17 == null) goto L90;
        int r18 = r17.getBottom();
    L91:
        ILivePlayerClient r110 = r4.getClient();
        if (r110 == null) goto L98;
        ILivePlayerExtraRenderController r111 = r110.extraRenderController();
        if (r111 == null) goto L98;
        View r112 = r111.curExtraRenderView();
        if (r112 == null) goto L98;
        int r113 = r112.getBottom();
    L99:
        IRenderView r114 = r4.getRenderView();
        if (r114 == null) goto L102;
        r19 = Integer.valueOf(r114.getHeight());
    L102:
        int r115 = r19.intValue();
        ILivePlayerClient r116 = r4.getClient();
        if (r116 == null) goto L109;
        ILivePlayerExtraRenderController r117 = r116.extraRenderController();
        if (r117 == null) goto L109;
        View r118 = r117.curExtraRenderView();
        if (r118 == null) goto L109;
        int r119 = r118.getHeight();
    L110:
        int r3 = r22.c;
        int r20 = t6.b(r4.getContext());
        int r25 = r20 - r18;
        int r120 = r20 - r113;
        if (r120 < r3) goto L114;
        this.n.e("panelScrollOffset <= extraBottom.bottom return");
    L113:
        int r26 = 0;
    L196:
        if (r26 <= 0) goto L200;
        com.bytedance.android.livesdk.log.g r2 = u.l();
        HashMap r27 = new HashMap();
        r27.put("panel_scene", r22.getType().getIdentifier());
        r27.put("strategy_type", "4");
        r27.put("move_length", String.valueOf(r26));
        Unit r1 = Unit.INSTANCE;
        r2.sendLog("livesdk_live_screen_adaptive_strategy", r27, new Object[]{Room.class, x.class});
        return;
    L200:
        return;
    L114:
        int r121 = r115 + r3;
        if ((r119 + r121) > r20) goto L117;
        this.d = r3 - r120;
    L120:
        this.n.e("start adaptStream. scroll y : " + this.d + " , panelHeight : " + r22.c);
        this.c = (float) r4.getScrollY();
        Animator r28 = this.f;
        if (r28 != null) goto L123;
    L127:
        ObjectAnimator r29 = ObjectAnimator.ofInt(r4, "scrollY", new int[]{(int) this.c, (int) this.d});
        LivePanelType r30 = r22.getType();
        LivePanelType r31 = LivePanelType.INPUT;
        if (r30 != r31) goto L130;
        long r122 = 250;
    L131:
        r29.setDuration(r122);
        r29.setInterpolator(new AccelerateInterpolator());
        r29.start();
        Unit r32 = Unit.INSTANCE;
        this.f = r29;
        if (((GameOpenPanelContentAdapterConfig) this.m.getValue()).getHideInteract() == true) goto L134;
    L141:
        boolean r33 = true;
    L142:
        this.k = r33;
        r26 = (int) this.d;
        goto L196
    L134:
        if (r22.getType() == r31) goto L141;
        if (this.d < UtilityKotlinExtentionsKt.i(8)) goto L141;
        jg1.b r34 = ClearScreenManagerAbility.INSTANCE.getInstance(r23);
        if (r34 == null) goto L140;
        r34.b(this.l);
    L140:
        r33 = true;
        xs2.b.a().post(new ToolbarClearScreenEvent(true, true));
        goto L142
    L130:
        r122 = 200;
        goto L131
    L123:
        if (r28.isRunning() != true) goto L127;
        this.n.e("cancel running animator");
        Animator r35 = this.f;
        if (r35 == null) goto L127;
        r35.cancel();
        goto L127
    L117:
        if (r121 > r20) goto L119;
        this.d = r15;
        this.n.e("player to the top , panelScrollOffset = " + this.d);
        goto L120
    L119:
        this.d = (r22.c - r25) - ((r121 - r20) / 2);
    L109:
        r119 = 0;
    L98:
        r113 = 0;
    L90:
        r18 = 0;
    L84:
        r15 = 0;
        goto L85
    L143:
        this.n.e("verticalScroll ,panelEvent = " + r22.getType() + ' ');
        IRenderView r36 = r4.getRenderView();
        if (r36 == null) goto L146;
        r19 = Integer.valueOf(r36.getHeight());
    L146:
        int r37 = r19.intValue();
        if (a(r21) == false) goto L156;
        if (r21 == null) goto L150;
        float r123 = r21.Q();
        int r38 = 1;
    L151:
        float r39 = r38;
        if (r21 == null) goto L154;
        float r40 = r21.P();
    L155:
        float r41 = r39 - r40;
    L157:
        float r42 = r37;
        float r43 = r41 * r42;
        float r44 = (r42 - (r123 * r42)) - r43;
        IRenderView r45 = r4.getRenderView();
        if (r45 == null) goto L113;
        View r46 = r45.getSelfView();
        if (r46 == null) goto L113;
        int r47 = r46.getBottom();
        int[] r48 = new int[2];
        IRenderView r124 = r4.getRenderView();
        if (r124 == null) goto L166;
        View r125 = r124.getSelfView();
        if (r125 == null) goto L166;
        r125.getLocationOnScreen(r48);
    L166:
        int r49 = r22.c;
        int r126 = t6.b(r4.getContext());
        float r50 = (r126 - r47) + r43;
        float r51 = r49;
        if (r50 < r51) goto L169;
        this.n.e("panelScroolOffset <= playerView.bottom return");
        goto L113
    L169:
        float r52 = r51 + r44;
        float r53 = r126;
        if (r52 > r53) goto L172;
        this.d = r22.c - r50;
        this.n.e("panelHeight + playerHeight <= screenHeight , panelScrolOffset = " + this.d);
    L173:
        this.n.e("start adaptStream. scroll y : " + this.d + " , panelHeight : " + r22.c);
        this.c = (float) r4.getScrollY();
        Animator r54 = this.f;
        if (r54 != null) goto L176;
    L180:
        ObjectAnimator r55 = ObjectAnimator.ofInt(r4, "scrollY", new int[]{(int) this.c, (int) this.d});
        LivePanelType r56 = r22.getType();
        LivePanelType r57 = LivePanelType.INPUT;
        if (r56 != r57) goto L183;
        long r127 = 250;
    L184:
        r55.setDuration(r127);
        r55.setInterpolator(new AccelerateInterpolator());
        r55.start();
        Unit r58 = Unit.INSTANCE;
        this.f = r55;
        if (((GameOpenPanelContentAdapterConfig) this.m.getValue()).getHideInteract() == true) goto L187;
    L194:
        boolean r59 = true;
    L195:
        this.k = r59;
        r26 = (int) this.d;
        goto L196
    L187:
        if (r22.getType() == r57) goto L194;
        if (this.d < UtilityKotlinExtentionsKt.i(8)) goto L194;
        jg1.b r60 = ClearScreenManagerAbility.INSTANCE.getInstance(r23);
        if (r60 == null) goto L193;
        r60.b(this.l);
    L193:
        r59 = true;
        xs2.b.a().post(new ToolbarClearScreenEvent(true, true));
        goto L195
    L183:
        r127 = 200;
        goto L184
    L176:
        if (r54.isRunning() != true) goto L180;
        this.n.e("cancel running animator");
        Animator r61 = this.f;
        if (r61 == null) goto L180;
        r61.cancel();
        goto L180
    L172:
        float r62 = (r52 - r53) / 2;
        this.d = (r22.c - r50) - r62;
        this.n.e("panelHeight + contentHeight >  screenHeight , padding = " + r62 + " panelScrolOffset = " + this.d + ' ');
        goto L173
    L154:
        r40 = 1.0f;
        goto L155
    L150:
        r38 = 1;
        r123 = 0.0f;
        goto L151
    L156:
        r41 = 0.0f;
        r123 = 0.0f;
        goto L157
    L27:
        if (r22.getType() != LivePanelType.INPUT) goto L29;
        r22.c += (int) UtilityKotlinExtentionsKt.h(56);
    L29:
        int r63 = r22.c;
        this.n.e("horizontalScale, panelHeight : " + r63);
        int r65 = t6.c(r4.getContext());
        if (r8 == false) goto L45;
        float r66 = r4.getScaleX();
        float r67 = r4.getScaleY();
        float r128 = r4.getTranslationX();
        float r129 = r4.getTranslationY();
        if (r66 == 1.0f) goto L34;
    L41:
        boolean r68 = true;
    L42:
        if (r68 == false) goto L45;
        return;
    L34:
        if (r67 != 1.0f) goto L41;
        if (r128 != 0.0f) goto L41;
        if (r129 != 0.0f) goto L41;
        r68 = false;
    L45:
        if (a(r21) == false) goto L65;
        if (r8 == true) goto L65;
        float r69 = r4.getRenderView().getSelfView().getScaleX();
        float r70 = r4.getRenderView().getSelfView().getScaleY();
        float r71 = r4.getRenderView().getSelfView().getTranslationX();
        float r130 = r4.getRenderView().getSelfView().getTranslationY();
        if (r69 == 1.0f) goto L50;
    L57:
        boolean r72 = true;
    L58:
        if (r72 == true) goto L65;
        if (r21 == null) goto L61;
        r12 = r21.Q();
    L61:
        if (r21 == null) goto L63;
        float r73 = r21.P();
    L64:
        float r74 = 1.0f - r73;
    L66:
        float r75 = r65;
        float r76 = (r75 - (r12 * r75)) - (r74 * r75);
        if (r76 <= 0) goto L202;
        float r77 = (r65 - r63) / r76;
        if (r77 > 1) goto L73;
        r11 = r77;
    L73:
        this.h = r4.getScaleX();
        this.i = r4.getScaleY();
        this.j = r4.getScrollY();
        this.g = r11;
        float r78 = (r75 * r11) * r12;
        float r79 = r63;
        if (r78 <= r79) goto L76;
        r78 = r79;
    L76:
        r4.setPivotX(r4.getWidth() / 2);
        r4.setPivotY(-r78);
        ObjectAnimator r80 = ObjectAnimator.ofFloat(r4, "scaleX", new float[]{this.h, r11});
        r80.setDuration(250);
        r80.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator r81 = ObjectAnimator.ofFloat(r4, "scaleY", new float[]{this.i, r11});
        r81.setDuration(250);
        r81.setInterpolator(new AccelerateInterpolator());
        ObjectAnimator r82 = ObjectAnimator.ofInt(r4, "scrollY", new int[]{(int) this.j, (int) r78});
        r82.setDuration(250);
        r82.setInterpolator(new AccelerateInterpolator());
        this.k = true;
        AnimatorSet r83 = new AnimatorSet();
        r83.playTogether(new Animator[]{r80, r81, r82});
        r83.start();
        return;
    L202:
        return;
    L63:
        r73 = 1.0f;
        goto L64
    L50:
        if (r70 != 1.0f) goto L57;
        if (r71 != 0.0f) goto L57;
        if (r130 != 0.0f) goto L57;
        r72 = false;
    L65:
        r74 = 0.0f;
        goto L66
    L21:
        if (Intrinsics.areEqual((Boolean) r7.gameExtraRenderController().eventHub().getExtraRenderIsShow().getValue(), r10) == true) goto L22;
    L23:
        r8 = false;
        goto L24
    L12:
        if (Intrinsics.areEqual((Boolean) r5.getEventHub().getFirstFrame().getValue(), Boolean.FALSE) == false) goto L14;
    }
}
