package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.live.broadcastgame.api.model.q0;
import com.bytedance.android.live.broadcastgame.api.xplay.LittleWindowPos;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.g0;
import com.bytedance.android.live.broadcastgame.xplay.q1;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.config.dk1;
import com.bytedance.android.livesdk.config.k30;
import com.bytedance.android.livesdk.config.pz0;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends FrameLayout {
    public final ViewGroup a;
    public final ImageView b;
    public final LittleWindowDragIndicatorView c;
    public final LittleWindowLayoutManager d;
    public final ViewGroup e;
    public final XplayLittleWindowContext f;
    public final p g;
    public final g0 h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Unit r2 = (Unit) r1;
            d.c(this.a);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            d r4 = this.a;
            r4.f(d.b(r4));
            this.a.h();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ d a;

        public c(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            d.e(this.a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.littlewindow.d$d, reason: collision with other inner class name */
    public static final class C0105d<T> implements Consumer {
        public final /* synthetic */ d a;

        public C0105d(d r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            UtilityKotlinExtentionsKt.A(this.a.b, ((Boolean) r2).booleanValue());
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ d a;

        public e(d r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            UtilityKotlinExtentionsKt.z(this.a.c, ((Boolean) r2).booleanValue());
        }
    }

    public static final class f implements View.OnLongClickListener {
        public final /* synthetic */ d a;

        public f(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            k30 r6 = k30.a;
            Integer r0 = (Integer) r6.getValue();
            int r1 = 2;
            if (r0 != null) goto L6;
        L8:
            if (r0 != null) goto L11;
        L13:
            r1 = 1;
        L14:
            SettingUtil.updateLocal(r6, String.valueOf(r1));
            f2.c("adapt resolution downgrade: " + r0 + " -> " + r1, 0);
            this.a.h();
            return true;
        L11:
            if (r0.intValue() != 2) goto L13;
            r1 = -1;
            goto L14
        L6:
            if (r0.intValue() != 1) goto L8;
            goto L8
        }
    }

    public static final class g {
    }

    public final class h implements View.OnTouchListener {
        public int a;
        public int b;
        public final /* synthetic */ d c;

        public h(d r1) {
            this.c = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r13, MotionEvent r14) {
            if (r14 == null) goto L71;
            if (r13 == null) goto L71;
            int r15 = r14.getAction();
            if (r15 != 0) goto L9;
            this.a = (int) r14.getRawX();
            this.b = (int) r14.getRawY();
            r14.getRawX();
            r14.getRawY();
            this.c.f.getShowDragIndicator().setValue(Boolean.TRUE);
            return true;
        L9:
            if (r15 == 1) goto L14;
            if (r15 != 2) goto L68;
            int r16 = (int) r14.getRawX();
            int r17 = (int) r14.getRawY();
            int r0 = r16 - this.a;
            int r2 = r17 - this.b;
            this.a = r16;
            this.b = r17;
            ViewGroup r18 = this.c.a;
            r18.setX(r18.getX() + r0);
            r18.setY(r18.getY() + r2);
            return true;
        L68:
            return false;
        L14:
            Rect r19 = new Rect(0, 0, this.c.a.getWidth(), this.c.a.getHeight());
            r19.offsetTo((int) this.c.a.getX(), (int) this.c.a.getY());
            LittleWindowPos r3 = d.a(this.c);
            d r110 = this.c;
            r110.getClass();
            Intrinsics.checkNotNullParameter(r19, "littleWindowRect");
            LittleWindowPos[] r4 = LittleWindowPos.values();
            ArrayList r5 = new ArrayList();
            int r6 = r4.length;
            int r7 = 0;
        L15:
            if (r7 >= r6) goto L23;
            LittleWindowPos r8 = r4[r7];
            if (r8 == LittleWindowPos.CUSTOM) goto L19;
            boolean r9 = true;
        L20:
            if (r9 == false) goto L22;
            r5.add(r8);
        L22:
            r7 = r7 + 1;
            goto L15
        L19:
            r9 = false;
            goto L20
        L23:
            ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator r12 = r5.iterator();
        L25:
            if (r12.hasNext() == false) goto L27;
            r11.add(r110.d.a(LittleWindowLayoutManager.LayoutMode.DragIndicator, (LittleWindowPos) r12.next(), 0.0f, 0.0f));
            goto L25
        L27:
            Rect r111 = new Rect();
            ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
            Iterator r22 = r11.iterator();
        L29:
            if (r22.hasNext() == false) goto L35;
            if (r111.setIntersect(r19, (Rect) r22.next()) == false) goto L33;
            int r23 = r111.width() * r111.height();
        L34:
            r21.add(Integer.valueOf(r23));
            goto L29
        L33:
            r23 = 0;
            goto L34
        L35:
            Iterator r112 = CollectionsKt.withIndex(r21).iterator();
            LittleWindowPos r24 = null;
            if (r112.hasNext() == true) goto L38;
            Object r113 = null;
        L47:
            IndexedValue r114 = (IndexedValue) r113;
            if (r114 == null) goto L50;
            Integer r115 = Integer.valueOf(r114.getIndex());
        L51:
            if (r115 != null) goto L53;
        L56:
            if (r24 != null) goto L58;
            r24 = r3;
        L58:
            if (r24 != r3) goto L60;
            f2.b(2131923538, 0);
        L60:
            d r116 = this.c;
            r116.getClass();
            String r117 = d.g(r3);
            String r25 = d.g(r24);
            r116.h.c("drag", r117, r25);
            int r118 = XplayLog.a;
            XplayLog.c("LittleWindowLayout", "drag form " + r117 + " to " + r25);
            d.d(this.c, r24);
            final d r119 = this.c;
            com.bytedance.android.live.broadcastgame.xplay.littlewindow.g r120 = d.b(r119);
            LittleWindowLayoutManager r26 = r119.d;
            if (r120.b == false) goto L64;
            LittleWindowLayoutManager.LayoutMode r27 = LittleWindowLayoutManager.LayoutMode.SmallSize;
        L67:
            Rect r121 = r26.a(r27, r120.a, 0.0f, 0.0f);
            final Pair r122 = TuplesKt.to(Float.valueOf(r121.left), Float.valueOf(r121.top));
            ViewGroup r28 = r119.a;
            ObjectAnimator r29 = ObjectAnimator.ofFloat(r28, View.TRANSLATION_X, new float[]{((Number) r122.getFirst()).floatValue()});
            ObjectAnimator r31 = ObjectAnimator.ofFloat(r28, View.TRANSLATION_Y, new float[]{((Number) r122.getSecond()).floatValue()});
            AnimatorSet r32 = new AnimatorSet();
            r32.playTogether(new Animator[]{r29, r31});
            r32.setDuration(200);
            com.bytedance.android.live.core.utils.h.a(r32, new LittleWindowLayout$playTransformAnim$$inlined$let$lambda$1(r119, r122));
            r32.start();
            this.c.f.getShowDragIndicator().setValue(Boolean.FALSE);
            goto L68
        L64:
            if (r120.c == false) goto L66;
            r27 = LittleWindowLayoutManager.LayoutMode.CustomSize;
            goto L67
        L66:
            r27 = LittleWindowLayoutManager.LayoutMode.LargeSize;
            goto L67
        L53:
            if (((Number) ListProtector.get(r21, r115.intValue())).intValue() == 0) goto L56;
            r24 = r4[r115.intValue()];
            goto L56
        L50:
            r115 = null;
            goto L51
        L38:
            r113 = r112.next();
            if (r112.hasNext() == false) goto L47;
            int r33 = ((Number) ((IndexedValue) r113).getValue()).intValue();
        L42:
            Object r34 = r112.next();
            int r123 = ((Number) ((IndexedValue) r34).getValue()).intValue();
            if (r33 >= r123) goto L46;
            r113 = r34;
            r33 = r123;
        L46:
            if (r112.hasNext() == true) goto L42;
        L71:
            return false;
        }
    }

    static {
    }

    private final dk1 getCustomLittleWindow() {
        PublishSubject<Unit> r0 = q1.a;
        Map r1 = (Map) ((Map) pz0.a.getValue()).get(this.g.h.b);
        if (r1 == null) goto L20;
        dk1 r2 = new dk1();
        String r3 = (String) r1.get("x");
        float r4 = 0.0f;
        if (r3 == null) goto L7;
        float r5 = CastFloatProtector.parseFloat(r3);
    L8:
        r2.i(r5);
        String r6 = (String) r1.get("y");
        if (r6 == null) goto L11;
        float r7 = CastFloatProtector.parseFloat(r6);
    L12:
        r2.j(r7);
        String r8 = (String) r1.get("w");
        if (r8 == null) goto L15;
        float r9 = CastFloatProtector.parseFloat(r8);
    L16:
        r2.h(r9);
        String r11 = (String) r1.get("h");
        if (r11 == null) goto L19;
        r4 = CastFloatProtector.parseFloat(r11);
    L19:
        r2.g(r4);
        r2.f(Intrinsics.areEqual((String) r1.get("open"), "true"));
        return r2;
    L15:
        r9 = 0.0f;
        goto L16
    L11:
        r7 = 0.0f;
        goto L12
    L7:
        r5 = 0.0f;
        goto L8
    L20:
        return null;
    }

    private final com.bytedance.android.live.broadcastgame.xplay.littlewindow.g getLittleWindowState() {
        return (com.bytedance.android.live.broadcastgame.xplay.littlewindow.g) this.f.getLittleWindowState().getValue();
    }

    public final void h() {
        ViewGroup r0 = this.a;
        int r1 = (int) r0.getX();
        int r2 = (int) r0.getY();
        int r3 = a1.i(r0);
        int r4 = a1.d(r0);
        int r6 = XplayLog.a;
        XplayLog.a("LittleWindowLayout", "update cast little window info: width=" + r3 + ", height=" + r4 + ", left=" + r1 + ", top=" + r2);
        Rect r5 = new Rect(r1, r2, r1 + r3, r2 + r4);
        XplayLittleWindowContext r7 = this.f;
        r7.getLittleWindowRect().setValue(r5);
        r7.getUpdateMixerParams().post(Unit.INSTANCE);
    }

    private final dk1 getCustomLittleWindowLayout() {
        return getCustomLittleWindow();
    }

    private final boolean getLittleWindowIsSmall() {
        return getLittleWindowState().b;
    }

    private final LittleWindowPos getLittleWindowPos() {
        return getLittleWindowState().a;
    }

    public static final /* synthetic */ LittleWindowPos a(d r0) {
        return r0.getLittleWindowPos();
    }

    public static final /* synthetic */ com.bytedance.android.live.broadcastgame.xplay.littlewindow.g b(d r0) {
        return r0.getLittleWindowState();
    }

    public static final void c(d r4) {
        int r0 = r4.getWidth();
        int r1 = r4.getHeight();
        LittleWindowLayoutManager r2 = r4.d;
        if (r0 == r2.b) goto L5;
    L6:
        int r3 = XplayLog.a;
        XplayLog.c("LittleWindowLayout", "update container size: (" + r0 + ", " + r1 + ')');
        LittleWindowLayoutManager r5 = r4.d;
        r5.b = r0;
        r5.c = r1;
        r4.c.invalidate();
        r4.f(r4.getLittleWindowState());
        r4.h();
        return;
    L5:
        if (r1 != r2.c) goto L6;
    }

    public static final void e(d r4) {
        boolean r0 = r4.getLittleWindowIsSmall();
        boolean r1 = !r0;
        r4.setLittleWindowIsSmall(r1);
        r4.f(r4.getLittleWindowState());
        r4.h();
        String r2 = "small";
        if (r0 == false) goto L5;
        String r3 = "small";
    L6:
        if (r1 == true) goto L9;
        r2 = "large";
    L9:
        int r5 = XplayLog.a;
        XplayLog.c("LittleWindowLayout", "zoomIV from " + r3 + " to " + r2);
        r4.h.c("size", r3, r2);
        return;
    L5:
        r3 = "large";
        goto L6
    }

    public static String g(LittleWindowPos r1) {
        int r2 = com.bytedance.android.live.broadcastgame.xplay.littlewindow.e.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "A";
    L5:
        if (r2 != 2) goto L7;
        return "B";
    L7:
        if (r2 != 3) goto L9;
        return "C";
    L9:
        if (r2 == 4) goto L11;
        return "";
    L11:
        return "D";
    }

    private final void setLittleWindowIsSmall(boolean r4) {
        i(com.bytedance.android.live.broadcastgame.xplay.littlewindow.g.a(getLittleWindowState(), null, r4, 29));
    }

    private final void setLittleWindowPos(LittleWindowPos r4) {
        i(com.bytedance.android.live.broadcastgame.xplay.littlewindow.g.a(getLittleWindowState(), r4, false, 30));
    }

    private final void setLittleWindowState(com.bytedance.android.live.broadcastgame.xplay.littlewindow.g r1) {
        i(r1);
    }

    public final void f(com.bytedance.android.live.broadcastgame.xplay.littlewindow.g r6) {
        LittleWindowLayoutManager r0 = this.d;
        if (r6.b == false) goto L6;
        LittleWindowLayoutManager.LayoutMode r1 = LittleWindowLayoutManager.LayoutMode.SmallSize;
    L9:
        Rect r2 = r0.a(r1, r6.a, r6.d, r6.e);
        ViewGroup r3 = this.a;
        r3.setX(r2.left);
        r3.setY(r2.top);
        a1.p(r3, r2.width());
        a1.k(r3, r2.height());
        Intrinsics.checkNotNullParameter(r3, "$this$layoutGravity");
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof FrameLayout.LayoutParams) == true) goto L12;
        r4 = null;
    L12:
        FrameLayout.LayoutParams r5 = (FrameLayout.LayoutParams) r4;
        if (r6.b == false) goto L15;
        int r7 = 2131250130;
    L16:
        this.b.setImageResource(r7);
        return;
    L15:
        r7 = 2131250129;
        goto L16
    L6:
        if (r6.c == false) goto L8;
        r1 = LittleWindowLayoutManager.LayoutMode.CustomSize;
        goto L9
    L8:
        r1 = LittleWindowLayoutManager.LayoutMode.LargeSize;
        goto L9
    }

    public final void i(com.bytedance.android.live.broadcastgame.xplay.littlewindow.g r7) {
        this.f.getLittleWindowState().setValue(r7);
        String r0 = this.g.h.b;
        PublishSubject<Unit> r1 = q1.a;
        Intrinsics.checkNotNullParameter(r0, "appId");
        Intrinsics.checkNotNullParameter(r7, "state");
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.b.N3;
        Object r3 = r2.getValue();
        com.bytedance.android.live.broadcastgame.xplay.littlewindow.g r4 = com.bytedance.android.live.broadcastgame.xplay.littlewindow.h.a;
        Intrinsics.checkNotNullParameter(r7, "$this$serialize");
        StringBuilder r5 = new StringBuilder();
        r5.append(r7.a.getId());
        r5.append(' ');
        r5.append(r7.b);
        ((Map) r3).put(r0, r5.toString());
        Unit r8 = Unit.INSTANCE;
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
    }

    public static final /* synthetic */ void d(d r0, LittleWindowPos r1) {
        r0.setLittleWindowPos(r1);
    }

    public d(Context r19, XplayLittleWindowContext r21, p r22, g0 r23) {
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r21, "littleWindowContext");
        Intrinsics.checkNotNullParameter(r22, "newEnv");
        Intrinsics.checkNotNullParameter(r23, "xplayLogService");
        super(r19);
        this.f = r21;
        this.g = r22;
        this.h = r23;
        LittleWindowLayoutManager r4 = new LittleWindowLayoutManager(r19);
        this.d = r4;
        com.bytedance.android.live.broadcastgame.xplay.littlewindow.g r6 = null;
        LittleWindowDragIndicatorView r5 = new LittleWindowDragIndicatorView(r19, null, 6, 0);
        this.c = r5;
        r5.setVisibility(8);
        r5.setLayoutManager(r4);
        addView(r5, -1, -1);
        LayoutInflater.from(r19).inflate(2131566210, this);
        ViewGroup r1 = (ViewGroup) findViewById(2131384816);
        this.a = r1;
        ImageView r7 = (ImageView) findViewById(2131393418);
        this.b = r7;
        this.e = (ViewGroup) findViewById(2131365097);
        a1.j(r1, 51);
        int r2 = s1.y();
        int r9 = s1.w() - ((int) s1.e(52.0f));
        r4.b = r2;
        r4.c = r9;
        if (r22.f == XplayScene.Video) goto L5;
    L7:
        RxUtilKt.g(this, false).subscribe(new a(this));
        q0 r11 = r22.h.l;
        dk1 r12 = getCustomLittleWindowLayout();
        if (r12 != null) goto L10;
    L16:
        m<com.bytedance.android.live.broadcastgame.xplay.littlewindow.g> r3 = r21.getLittleWindowState();
        String r8 = r22.h.b;
        PublishSubject<Unit> r13 = q1.a;
        Intrinsics.checkNotNullParameter(r8, "appId");
        String r14 = (String) ((Map) com.bytedance.android.livesdk.sharedpref.b.N3.getValue()).get(r8);
        if (r14 == null) goto L35;
        com.bytedance.android.live.broadcastgame.xplay.littlewindow.g r15 = com.bytedance.android.live.broadcastgame.xplay.littlewindow.h.a;
        Intrinsics.checkNotNullParameter(r14, "serialized");
        List r16 = StringsKt.split$default(r14, new char[]{' '}, false, 0, 6, null);     // Catch: Throwable -> L34
        int r17 = CastIntegerProtector.parseInt((String) ListProtector.get(r16, 0));     // Catch: Throwable -> L34
        LittleWindowPos r18 = LittleWindowPos.TOP;     // Catch: Throwable -> L34
        if (r17 == r18.getId()) goto L32;
        r18 = LittleWindowPos.LEFT;     // Catch: Throwable -> L34
        if (r17 == r18.getId()) goto L32;
        r18 = LittleWindowPos.RIGHT;     // Catch: Throwable -> L34
        if (r17 == r18.getId()) goto L32;
        r18 = LittleWindowPos.RIGHT_BOTTOM;     // Catch: Throwable -> L34
        if (r17 == r18.getId()) goto L32;
        r18 = null;
    L32:
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L34
        r6 = new com.bytedance.android.live.broadcastgame.xplay.littlewindow.g(r18, Intrinsics.areEqual((String) ListProtector.get(r16, 1), "true"));     // Catch: Throwable -> L34
    L35:
        int r24 = XplayLog.a;
        XplayLog.c("XplayUtils", "loadAnchorLittleWindowState " + r8 + ' ' + r6);
        if (r6 != null) goto L38;
        r6 = com.bytedance.android.live.broadcastgame.xplay.littlewindow.h.a;
    L38:
        r3.setValue(r6);
        ViewGroup r25 = this.a;
        if (r25 == null) goto L41;
        r25.setOnTouchListener(new h(this));
    L41:
        f(getLittleWindowState());
        h();
        this.f.getLittleWindowStateChangedExternally().onEvent().subscribe(new b(this));
        this.b.setOnClickListener(new c(this));
        this.f.getZoomButtonEnabled().a().subscribe(new C0105d(this));
        this.f.getShowDragIndicator().a().subscribe(new e(this));
        if (v.a() == false) goto L49;
        ImageView r26 = this.b;
        if (r26 == null) goto L50;
        r26.setOnLongClickListener(new f(this));
        return;
    L50:
        return;
    L49:
        return;
    L10:
        if (r12.a() == false) goto L16;
        if (r11 == null) goto L16;
        Rect r27 = q1.a(new com.bytedance.android.live.broadcastgame.xplay.j(r2, r9), new com.bytedance.android.live.broadcastgame.xplay.j(r11.e(), r11.d()));
        int r28 = r27.width();
        int r29 = r27.height();
        r4.d = r28;
        r4.e = r29;
        float r31 = r12.c();
        float r32 = r12.b();
        r4.f = MathKt.roundToInt(r4.d * r31);
        r4.a.put(LittleWindowLayoutManager.LayoutMode.CustomSize, new LittleWindowLayoutManager.b(r4.h, r4.f, MathKt.roundToInt(r4.e * r32)));
        r21.getLittleWindowState().setValue(new com.bytedance.android.live.broadcastgame.xplay.littlewindow.g(LittleWindowPos.CUSTOM, false, true, r12.d(), r12.e()));
        r21.getZoomButtonEnabled().setValue(Boolean.FALSE);
        ViewGroup r33 = UtilityKotlinExtentionsKt.p(r7);
        if (r33 == null) goto L15;
        r33.removeView(r7);
    L15:
        UtilityKotlinExtentionsKt.z(r5, false);
        goto L41
    L5:
        if (q1.c(r22.h.b) == false) goto L7;
        Rect r110 = new Rect(22, 0, 22, 0);
        Intrinsics.checkNotNullParameter(r110, "rect");
        r4.g = r110;
        goto L7
    }
}
