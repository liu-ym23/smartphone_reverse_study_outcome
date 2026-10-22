package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkmicSubtitleStyle;
import com.bytedance.android.livesdk.chatroom.model.interact.q2;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.interactivity.api.DragContainer;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zg1.n0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/subtitle/LinkmicSubtitleUIWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Ld42/b;", "Lnj0/f;", "Lcom/bytedance/android/live/room/api/visibilitycontrol/b;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicSubtitleUIWidget extends MiddlewareRoomWidget implements d42.b, nj0.f, com.bytedance.android.live.room.api.visibilitycontrol.b {
    public static final int r = 0;
    public static final int s = 0;
    public static final int t = 0;
    public static final int u = 0;
    public static final int v = 0;
    public static final int w = 0;
    public static final int x = 0;
    public DragContainer a;
    public View b;
    public View c;
    public View d;
    public s52.a e;
    public ViewGroup f;
    public ViewGroup g;
    public SubtitleRecyclerView h;
    public TextView i;
    public u j;
    public final CompositeDisposable k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public HybridCard p;
    public int q;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LinkmicSubtitleUIWidget a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;

        public b(LinkmicSubtitleUIWidget r1, float r2, float r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DragContainer r0 = this.a.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setTranslationX(this.b);     // Catch: Throwable -> L6
            r0.setTranslationY(this.c);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LinkmicSubtitleUIWidget a;

        public c(LinkmicSubtitleUIWidget r1) {
            this.a = r1;
        }

        public final void a() {
            ViewGroup.LayoutParams r1 = null;
            if (vm2.c.b().getSubtitlePatchLynxEnable() == false) goto L27;
            ViewGroup r0 = this.a.g;
            if (r0 == null) goto L7;
            ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        L9:
            if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L12;
            r1 = r2;
        L12:
            FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r1;
            if (r3 == null) goto L17;
            LinkmicSubtitleUIWidget r4 = this.a;
            r3.width = r4.q;
            ViewGroup r5 = r4.g;
            if (r5 == null) goto L17;
            r5.setLayoutParams(r3);
        L17:
            HybridCard r6 = this.a.p;
            if (r6 == null) goto L41;
            r6.release();
            LinkmicSubtitleUIWidget r7 = this.a;
            ViewGroup r8 = r7.g;
            if (r8 == null) goto L22;
            r8.removeView(r7.p);
        L22:
            LinkmicSubtitleUIWidget r9 = this.a;
            int r10 = g0.a;
            r9.p = g0.f(((Widget) r9).context, r9.q);
            HybridCard r11 = this.a.p;
            if (r11 == null) goto L42;
            r11.setLayoutParams(new ConstraintLayout.LayoutParams(this.a.q, LinkmicSubtitleUIWidget.u));
            ViewGroup r12 = this.a.g;
            if (r12 == null) goto L43;
            r12.addView(r11);
            return;
        L43:
            return;
        L42:
            return;
        L41:
            return;
        L7:
            r2 = null;
            goto L9
        L27:
            ViewGroup r13 = this.a.f;
            if (r13 == null) goto L30;
            ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        L32:
            if ((r14 instanceof FrameLayout.LayoutParams) == false) goto L35;
            r1 = r14;
        L35:
            FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r1;
            if (r15 == null) goto L45;
            LinkmicSubtitleUIWidget r16 = this.a;
            r15.width = r16.q;
            ViewGroup r17 = r16.f;
            if (r17 == null) goto L46;
            r17.setLayoutParams(r15);
            return;
        L46:
            return;
        L45:
            return;
        L30:
            r14 = null;
            goto L32
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        r = UtilityKotlinExtentionsKt.i(114);
        s = UtilityKotlinExtentionsKt.i(400);
        t = UtilityKotlinExtentionsKt.i(52);
        u = UtilityKotlinExtentionsKt.i(59);
        v = UtilityKotlinExtentionsKt.i(12);
        UtilityKotlinExtentionsKt.i(6);
        w = UtilityKotlinExtentionsKt.i(222);
        x = UtilityKotlinExtentionsKt.i(120);
    }

    @Override // nj0.f
    public final boolean J9() {
        DragContainer r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        return true;
    }

    @Override // nj0.f
    public final void Kj() {
        DragContainer r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        DragContainer r1 = this.a;
        if (r1 == null) goto L11;
        UtilityKotlinExtentionsKt.w(r1);
    L11:
        if (vm2.c.b().getSubtitlePatchLynxEnable() == true) goto L13;
        u r2 = this.j;
        if (r2 == null) goto L37;
        r2.e.removeCallbacksAndMessages(null);
        r2.e.sendEmptyMessage(1);
        return;
    L37:
        return;
    L13:
        if (this.p != null) goto L33;
        LinkmicSubtitleBusinessContext r3 = LinkmicSubtitleBusinessContext.Companion.getContext();
        if (r3 == null) goto L23;
        com.bytedance.live.datacontext.m<q2> r4 = r3.getLinkmicSubtitleSettingStatus();
        if (r4 == null) goto L23;
        q2 r5 = (q2) r4.getValue();
        if (r5 == null) goto L23;
        if (r5.getSubtitleStyle() != LinkmicSubtitleStyle.LONG.ordinal()) goto L23;
        int r6 = w;
    L24:
        this.q = r6;
        int r7 = g0.a;
        HybridCard r8 = g0.f(((Widget) this).context, r6);
        this.p = r8;
        if (r8 == null) goto L34;
        r8.setLayoutParams(new ConstraintLayout.LayoutParams(this.q, u));
        ViewGroup r9 = this.g;
        if (r9 == null) goto L35;
        r9.addView(r8);
        return;
    L35:
        return;
    L34:
        return;
    L23:
        r6 = x;
        goto L24
    L33:
        return;
    L5:
        if (r0.getVisibility() != 0) goto L7;
    }

    @Override // nj0.f
    public final void V7() {
        u r0 = this.j;
        if (r0 == null) goto L14;
        TextView r1 = r0.i;
        if (r1 == null) goto L7;
        r1.setText("");
    L7:
        LinkmicSubtitleAdapter r2 = r0.b;
        if (r2 == null) goto L10;
        r2.a.clear();
    L10:
        LinkmicSubtitleAdapter r3 = r0.b;
        if (r3 == null) goto L15;
        r3.notifyDataSetChanged();
        return;
    L15:
        return;
    }

    @Override // nj0.f
    public final int Vf() {
        s52.a r0 = this.e;
        if ((r0 instanceof FrameLayout) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout r1 = (FrameLayout) r0;
        if (r1 == null) goto L8;
        int r2 = r1.getHeight();
    L9:
        if (r2 == 0) goto L11;
        return r2;
    L11:
        return s1.w();
    L8:
        r2 = 0;
        goto L9
    }

    public final boolean canControlByClearScreenService() {
        nj0.b r0 = LinkmicSubtitleBusinessContext.Companion.b();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isRecording() == true) goto L7;
        return true;
    }

    @Override // nj0.f
    public final void dh() {
        DragContainer r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        DragContainer r1 = this.a;
        if (r1 == null) goto L11;
        UtilityKotlinExtentionsKt.t(r1);
    L11:
        if (vm2.c.b().getSubtitlePatchLynxEnable() == false) goto L19;
        HybridCard r2 = this.p;
        if (r2 == null) goto L15;
        r2.release();
    L15:
        ViewGroup r3 = this.g;
        if (r3 == null) goto L18;
        r3.removeView(this.p);
    L18:
        this.p = null;
        return;
    L19:
        u r4 = this.j;
        if (r4 == null) goto L24;
        r4.a();
        return;
    L24:
        return;
    L5:
        if (r0.getVisibility() != 8) goto L7;
    }

    public final IRoom getRoom() {
        return com.bytedance.android.live.core.utils.a0.n(((Widget) this).dataCenter);
    }

    public final boolean isAnchor() {
        return com.bytedance.android.live.core.utils.a0.d(((Widget) this).dataCenter, false);
    }

    public final Pair<Float, Float> xq() {
        return TuplesKt.to(Float.valueOf(v / s1.y()), Float.valueOf((this.m - yq()) / this.m));
    }

    public final int yq() {
        int r0 = g0.a;
        if (g0.a(getRoom()) == false) goto L6;
        return u;
    L6:
        return t;
    }

    @Override // nj0.f
    public final float zp() {
        DragContainer r0 = this.a;
        if (r0 == null) goto L11;
        float r1 = r0.getTranslationX();
        int r2 = w;
        float r3 = r1 + r2;
        int r4 = s1.y();
        int r5 = v;
        if (r3 <= (r4 - r5)) goto L7;
        float r6 = (s1.y() - r5) - r2;
    L8:
        int r7 = s1.y();
    L10:
        return r6 / r7;
    L7:
        r6 = r0.getTranslationX();
        goto L8
    L11:
        r6 = v;
        r7 = s1.y();
        goto L10
    }

    public final Pair<Float, Float> zq() {
        int r1 = UtilityKotlinExtentionsKt.i(90);
        int r0 = UtilityKotlinExtentionsKt.i(90);
        return TuplesKt.to(Float.valueOf((((s1.y() - r1) / 2) + r1) / s1.y()), Float.valueOf(((r0 - yq()) / 2) / this.m));
    }

    public LinkmicSubtitleUIWidget() {
        this.k = new CompositeDisposable();
        int r0 = r;
        this.l = r0;
        int r1 = s1.w() - r0;
        int r2 = s;
        this.m = r1 - r2;
        this.n = r2;
    }

    public final void onCreate() {
        super.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(LinkmicSubtitleUIWidget$initDataContext$pair$1.INSTANCE);
        LinkmicSubtitleUIContext r1 = (LinkmicSubtitleUIContext) r0.getFirst();
        r1.getService().d(this);
        com.bytedance.live.datacontext.b.a(r1, nj0.e.class);
        this.k.add((Disposable) r0.getSecond());
        ViewGroup r2 = ((Widget) this).containerView;
        boolean r3 = true;
        if (r2 == null) goto L51;
        LayoutInflater r4 = LayoutInflater.from(r2.getContext());
        int r5 = g0.a;
        if (g0.a(getRoom()) == false) goto L7;
        int r6 = 2131566845;
    L8:
        View r7 = r4.inflate(r6, r2, false);
        if ((r7 instanceof DragContainer) == true) goto L11;
        r7 = null;
    L11:
        DragContainer r8 = (DragContainer) r7;
        this.a = r8;
        if (r8 == null) goto L14;
        ViewGroup r9 = (ViewGroup) r8.findViewById(2131378053);
    L15:
        this.f = r9;
        DragContainer r10 = this.a;
        if (r10 == null) goto L18;
        ViewGroup r11 = (ViewGroup) r10.findViewById(2131378052);
    L19:
        this.g = r11;
        DragContainer r12 = this.a;
        if (r12 == null) goto L22;
        SubtitleRecyclerView r13 = (SubtitleRecyclerView) r12.findViewById(2131378055);
    L23:
        this.h = r13;
        DragContainer r14 = this.a;
        if (r14 == null) goto L26;
        TextView r15 = (TextView) r14.findViewById(2131387064);
    L27:
        this.i = r15;
        View r16 = LayoutInflater.from(r2.getContext()).inflate(2131566843, r2, false);
        this.b = r16;
        if (r16 == null) goto L30;
        View r17 = r16.findViewById(2131368790);
    L31:
        this.c = r17;
        View r18 = new View(r2.getContext());
        r18.setBackgroundColor(ColorProtector.parseColor("#33000000"));
        Unit r19 = Unit.INSTANCE;
        this.d = r18;
        if ((r2 instanceof s52.a) == true) goto L34;
        r2 = null;
    L34:
        this.e = (s52.a) r2;
        if (isAnchor() == false) goto L40;
        if (g0.a(getRoom()) == false) goto L40;
    L41:
        boolean r20 = true;
    L43:
        if (r20 == false) goto L51;
        View r21 = this.c;
        if (r21 == null) goto L47;
        UtilityKotlinExtentionsKt.t(r21);
    L47:
        s52.a r22 = this.e;
        if (r22 == null) goto L51;
        r22.setDisableDelete(true);
    L40:
        if (isAnchor() == false) goto L41;
        r20 = false;
        goto L43
    L30:
        r17 = null;
        goto L31
    L26:
        r15 = null;
        goto L27
    L22:
        r13 = null;
        goto L23
    L18:
        r11 = null;
        goto L19
    L14:
        r9 = null;
        goto L15
    L7:
        r6 = 2131566844;
    L51:
        if (isAnchor() == false) goto L57;
        int r23 = g0.a;
        if (g0.a(getRoom()) == false) goto L57;
        ViewGroup r24 = this.f;
        if (r24 == null) goto L57;
        r24.setOnClickListener(new f0(this));
    L57:
        DragContainer r25 = this.a;
        if (r25 == null) goto L71;
        int r26 = g0.a;
        int r27 = g0.c(getRoom());
        if (r27 != 0) goto L62;
    L69:
        r25.setEnableDrag(r3);
        goto L71
    L62:
        if (r27 == 2) goto L69;
        if (r27 == 3) goto L69;
        if (r27 == 4) goto L69;
        r3 = false;
    L71:
        if (vm2.c.b().getSubtitlePatchLynxEnable() == false) goto L78;
        ViewGroup r28 = this.g;
        if (r28 == null) goto L75;
        r28.setVisibility(0);
    L75:
        ViewGroup r29 = this.f;
        if (r29 == null) goto L84;
        r29.setVisibility(8);
    L84:
        ViewGroup r30 = ((Widget) this).containerView;
        if (r30 == null) goto L87;
        this.j = new u(r30.getContext(), getRoom(), this.h, this.i);
    L87:
        this.l = r;
        this.m = ((IInteractService) jc1.k.n(IInteractService.class)).getAudioTalkSeatBottomPos(getRoom()) - this.l;
        this.n = (Vf() - this.l) - this.m;
        ALogger.i("LinkmicSubtitleUIWidget", "[AudioSubtitle] initAreaHeight deleteAreaHeight=" + this.l + ", dragContainerHeight=" + this.m + ", forbiddenAreaHeight=" + this.n);
        if (((Boolean) vm2.h.K4.getValue(null, vm2.h.a[295(0x127, float:4.13E-43)])).booleanValue() == true) goto L90;
    L96:
        s52.a r31 = this.e;
        if (r31 == null) goto L115;
        View r32 = this.b;
        if (r32 == null) goto L101;
        r31.d(r32, this.l);
    L101:
        View r33 = this.d;
        if (r33 == null) goto L104;
        r31.j(r33, this.n);
    L104:
        int r34 = v;
        r31.a(r34, 0, r34);
        s52.a r35 = this.e;
        if ((r35 instanceof ViewGroup) == true) goto L107;
        r35 = null;
    L107:
        ViewGroup r36 = (ViewGroup) r35;
        if (r36 == null) goto L110;
        r36.removeView(this.a);
    L110:
        DragContainer r37 = this.a;
        if (r37 == null) goto L113;
        r37.setDragParentView(r31);
        Unit r38 = Unit.INSTANCE;
        r31.b(r37);
    L113:
        Aq(r34, (Vf() - this.n) - yq());
        r31.setDragCallback(this);
    L115:
        if (((Boolean) vm2.d.S6.getValue(null, vm2.d.a[406(0x196, float:5.69E-43)])).booleanValue() == false) goto L119;
        DataCenter r39 = ((Widget) this).dataCenter;
        if (r39 == null) goto L119;
        r39.put("cmd_linkmic_subtitle_ui_widget_load", Boolean.TRUE);
    L119:
        int r40 = g0.a;
        if (g0.a(getRoom()) == false) goto L131;
        LinkmicSubtitleBusinessContext.a r41 = LinkmicSubtitleBusinessContext.Companion;
        if (r41.d() == false) goto L132;
        LinkmicSubtitleBusinessContext r42 = r41.getContext();
        if (r42 == null) goto L133;
        com.bytedance.live.datacontext.m<q2> r43 = r42.getLinkmicSubtitleSettingStatus();
        if (r43 == null) goto L134;
        q2 r44 = (q2) r43.getValue();
        if (r44 == null) goto L135;
        dk(r44.getSubtitleStyle());
        ic((float) r44.getX(), (float) r44.getY(), "init");
        return;
    L135:
        return;
    L134:
        return;
    L133:
        return;
    L132:
        return;
    L131:
        return;
    L90:
        if (this.n > 0) goto L96;
        IInteractService r45 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r45 == null) goto L96;
        if (r45.getCurUILayout() != 28) goto L96;
        this.n = UtilityKotlinExtentionsKt.i(300);
        this.m = (s1.w() - this.l) - this.n;
        goto L96
    L78:
        ViewGroup r46 = this.g;
        if (r46 == null) goto L81;
        r46.setVisibility(8);
    L81:
        ViewGroup r47 = this.f;
        if (r47 == null) goto L84;
        r47.setVisibility(0);
        goto L84
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        DragContainer r0 = this.a;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r0);
    L5:
        u r1 = this.j;
        if (r1 == null) goto L8;
        r1.a();
    L8:
        this.k.clear();
    }

    public final void onDragStart() {
        xs2.b.a().post(new n0(true));
        s r0 = t.a;
        LinkedHashMap r1 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r1, null, null, 6);
        t.i(r1);
        j0.l().sendLog("livesdk_audience_voiceroom_caption_move", r1, new Object[]{IRoom.class});
    }

    @Override // nj0.f
    public final HybridCard Ya() {
        return this.p;
    }

    @Override // nj0.f
    public final Pair<Float, Float> Db(boolean r3) {
        if (r3 == false) goto L4;
        Pair<Float, Float> r4 = zq();
    L5:
        ALogger.i("LinkmicSubtitleUIWidget", "[AudioSubtitle] subtitleInitPosition dragContainerHeight=" + this.m + ", x=" + ((Number) r4.getFirst()).floatValue() + ", y=" + ((Number) r4.getSecond()).floatValue());
        return r4;
    L4:
        r4 = xq();
        goto L5
    }

    public final void Op(boolean r6) {
        if (r6 == false) goto L14;
        DragContainer r7 = this.a;
        if (r7 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r7);
    L6:
        nj0.b r8 = LinkmicSubtitleBusinessContext.Companion.b();
        if (r8 == null) goto L9;
        r8.Cf();
    L9:
        DragContainer r9 = this.a;
        if (r9 == null) goto L12;
        r9.setTranslationX(0.0f);
        r9.setTranslationY(0.0f);
    L12:
        Aq(v, (Vf() - this.n) - yq());
    L14:
        if (isAnchor() == false) goto L46;
        int r10 = g0.a;
        if (g0.a(getRoom()) == false) goto L47;
        DragContainer r11 = this.a;
        if (r11 == null) goto L47;
        s52.a r0 = this.e;
        if (r0 == null) goto L45;
        Pair<Float, Float> r12 = r0.h(r11);
        if (r12 == null) goto L49;
        LinkmicSubtitleBusinessContext.a r1 = LinkmicSubtitleBusinessContext.Companion;
        nj0.b r2 = r1.b();
        if (r2 == null) goto L27;
        r2.Ck(r12);
    L27:
        StringBuilder r3 = new StringBuilder("onDragFinish, dragContainer x=");
        DragContainer r4 = this.a;
        Integer r5 = null;
        if (r4 == null) goto L30;
        Float r13 = Float.valueOf(r4.getX());
    L31:
        r3.append(r13);
        r3.append(", y=");
        DragContainer r14 = this.a;
        if (r14 == null) goto L34;
        Float r15 = Float.valueOf(r14.getY());
    L35:
        r3.append(r15);
        r3.append(", newPos x=");
        r3.append(((Number) r12.getFirst()).floatValue());
        r3.append(", y=");
        r3.append(((Number) r12.getSecond()).floatValue());
        ALogger.i("LinkmicSubtitleUIWidget", r3.toString());
        LinkmicSubtitleBusinessContext r16 = r1.getContext();
        if (r16 == null) goto L42;
        com.bytedance.live.datacontext.m<q2> r17 = r16.getLinkmicSubtitleSettingStatus();
        if (r17 == null) goto L42;
        q2 r18 = (q2) r17.getValue();
        if (r18 == null) goto L42;
        r5 = Integer.valueOf(r18.getSubtitleStyle());
    L42:
        List r19 = (List) b6.q0.getValue();
        if (r19.contains(r5) == true) goto L47;
        r19.add(r5);
        goto L47
    L34:
        r15 = null;
        goto L35
    L30:
        r13 = null;
        goto L31
    L49:
        return;
    L45:
        return;
    L47:
        xs2.b.a().post(new n0(false));
        return;
    L46:
        this.o = true;
        goto L47
    }

    @Override // nj0.f
    public final void dk(int r2) {
        if (r2 != LinkmicSubtitleStyle.LONG.ordinal()) goto L5;
        int r3 = w;
    L7:
        if (this.q != r3) goto L9;
        return;
    L9:
        this.q = r3;
        ViewGroup r4 = this.f;
        if (r4 == null) goto L13;
        r4.post(new c(this));
        return;
    L13:
        return;
    L5:
        r3 = x;
        goto L7
    }

    @Override // nj0.f
    public final void dq(List<nj0.g> r3) {
        Intrinsics.checkNotNullParameter(r3, "subtitleList");
        DragContainer r0 = this.a;
        if (r0 == null) goto L8;
        if (r0.getVisibility() != 8) goto L8;
        return;
    L8:
        if (((ArrayList) r3).isEmpty() == false) goto L10;
        return;
    L10:
        u r1 = this.j;
        if (r1 == null) goto L14;
        r1.b(r3);
        return;
    }

    public final void kn(boolean r5) {
        if (r5 == false) goto L4;
        float r6 = 1.2f;
    L5:
        View r0 = this.c;
        if (r0 == null) goto L13;
        ViewPropertyAnimator r1 = r0.animate();
        if (r1 == null) goto L14;
        r1.scaleX(r6).setDuration(200).start();
        ViewPropertyAnimator r7 = r1.scaleY(r6).setDuration(200);
        if (r7 == null) goto L15;
        r7.start();
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    L4:
        r6 = 1.0f;
        goto L5
    }

    public final void Aq(float r3, float r4) {
        DragContainer r0 = this.a;
        if (r0 == null) goto L6;
        r0.post(new b(this, r3, r4));
        return;
    }

    @Override // nj0.f
    public final Pair<Float, Float> di(int r2, int r3) {
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.b(r2) == true) goto L7;
        if (r2 == 27) goto L7;
    L9:
        Pair<Float, Float> r4 = xq();
    L10:
        ALogger.i("LinkmicSubtitleUIWidget", "[AudioSubtitle] subtitleInitPosition dragContainerHeight=" + this.m + ", x=" + ((Number) r4.getFirst()).floatValue() + ", y=" + ((Number) r4.getSecond()).floatValue());
        return r4;
    L7:
        if (r3 != LinkmicSubtitleStyle.SHORT.ordinal()) goto L9;
        r4 = zq();
        goto L10
    }

    public final Pair<Float, Float> wq(float r4, float r5) {
        int r0 = v;
        if (r4 >= r0) goto L6;
        r4 = r0;
    L6:
        if (r4 <= ((s1.y() - this.q) - r0)) goto L8;
        r4 = (s1.y() - this.q) - r0;
    L8:
        int r1 = this.l;
        if (r5 >= r1) goto L11;
        float r2 = r1;
    L13:
        if (r5 <= ((r1 + this.m) - yq())) goto L16;
        r2 = (this.l + this.m) - yq();
    L16:
        return TuplesKt.to(Float.valueOf(r4), Float.valueOf(r2));
    L11:
        r2 = r5;
        goto L13
    }

    @Override // nj0.f
    public final void Sl(int r2, int r3, int r4) {
        this.l = r2;
        this.m = r3;
        this.n = r4;
        s52.a r5 = this.e;
        if (r5 == null) goto L19;
        View r6 = this.b;
        if (r6 == null) goto L7;
        r5.d(r6, r2);
    L7:
        View r7 = this.d;
        if (r7 == null) goto L10;
        r5.j(r7, this.n);
    L10:
        s52.a r8 = this.e;
        if ((r8 instanceof ViewGroup) == true) goto L13;
        r8 = null;
    L13:
        ViewGroup r9 = (ViewGroup) r8;
        if (r9 == null) goto L16;
        r9.removeView(this.a);
    L16:
        DragContainer r10 = this.a;
        if (r10 == null) goto L19;
        r10.setDragParentView(r5);
        Unit r11 = Unit.INSTANCE;
        r5.b(r10);
    L19:
        DragContainer r12 = this.a;
        float r13 = 0.0f;
        if (r12 == null) goto L22;
        float r14 = r12.getTranslationX();
    L23:
        DragContainer r15 = this.a;
        if (r15 == null) goto L26;
        r13 = r15.getTranslationY();
    L26:
        Pair<Float, Float> r16 = wq(r14, r13);
        if (((Number) r16.getFirst()).floatValue() == r14) goto L29;
    L30:
        Aq(((Number) r16.getFirst()).floatValue(), ((Number) r16.getSecond()).floatValue());
        return;
    L29:
        if (((Number) r16.getSecond()).floatValue() != r13) goto L30;
        return;
    L22:
        r14 = 0.0f;
        goto L23
    }

    @Override // nj0.f
    public final void ic(float r5, float r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "source");
        int r0 = g0.a;
        if (g0.a(getRoom()) == true) goto L6;
    L16:
        boolean r8 = true;
    L18:
        if (r8 == false) goto L20;
        return;
    L20:
        float r9 = s1.y() * r5;
        float r1 = (this.m * r6) + this.l;
        Pair<Float, Float> r2 = wq(r9, r1);
        ALogger.i("LinkmicSubtitleUIWidget", "[AudioSubtitle] updateSubtitlePosition, x=" + r5 + ", y=" + r6 + ", screenWidth=" + s1.y() + ", dragContainerHeight=" + this.m + ", deleteAreaHeight=" + this.l + ", targetX=" + r9 + ", targetY=" + r1 + ", validX=" + ((Number) r2.getFirst()).floatValue() + ", validY=" + ((Number) r2.getSecond()).floatValue());
        Aq(((Number) r2.getFirst()).floatValue(), ((Number) r2.getSecond()).floatValue());
        return;
    L6:
        if (Intrinsics.areEqual(r7, "update_position_from_playmode_im") == false) goto L11;
        if (isAnchor() == true) goto L16;
    L11:
        if (Intrinsics.areEqual(r7, "update_position_from_playmode_im") == true) goto L13;
    L17:
        r8 = false;
        goto L18
    L13:
        if (isAnchor() == true) goto L17;
        if (this.o == false) goto L17;
        goto L16
    }
}
