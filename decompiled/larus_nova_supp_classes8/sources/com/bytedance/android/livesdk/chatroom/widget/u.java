package com.bytedance.android.livesdk.chatroom.widget;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.LiveStickerTtfUtil;
import com.bytedance.android.livesdk.config.ew;
import com.bytedance.android.livesdk.config.gt;
import com.bytedance.android.livesdk.config.vm;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationFontConfig;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u extends FrameLayout {
    public static final c P = null;
    public final boolean A;
    public final b B;
    public final int C;
    public final boolean D;
    public boolean E;
    public final int[] F;
    public final int[] G;
    public final Rect H;
    public final Rect I;
    public final Lazy J;
    public final r K;
    public boolean L;
    public long M;
    public final s N;
    public final a O;
    public final RoomDecoration a;
    public final ImageView b;
    public final TextView c;
    public final TextView d;
    public Button e;
    public View f;
    public View g;
    public View h;
    public View i;
    public final TextView j;
    public final ConstraintLayout k;
    public final TextView l;
    public final ImageView m;
    public int[] n;
    public int o;
    public int p;
    public int q;
    public int r;
    public final int s;
    public final int t;
    public float u;
    public float v;
    public float w;
    public float x;
    public boolean y;
    public String z;

    public interface a {
        void T9(boolean r1);

        void X6(boolean r1);

        boolean o8(boolean r1);

        boolean s9(boolean r1);
    }

    public interface b {
        void Jb(boolean r1);

        void Lf(String r1, RoomDecoration r2);

        void q8(RoomDecoration r1);

        void vd();
    }

    public static final class c {
        public c() {
        }

        @JvmStatic
        public static boolean a() {
            int r0 = jc1.k.n(IInteractService.class).getCurrentScene();
            DataContext r1 = com.bytedance.live.datacontext.d.d(RoomContext.class);
            Room r3 = null;
            if ((r1 instanceof RoomContext) == true) goto L5;
            r1 = null;
        L5:
            RoomContext r2 = (RoomContext) r1;
            if (r0 != 5) goto L14;
            if (r2 == null) goto L12;
            com.bytedance.live.datacontext.m r4 = r2.getRoom();
            if (r4 == null) goto L12;
            r3 = (Room) r4.getValue();
        L12:
            if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r3) == true) goto L14;
            return true;
        L14:
            return false;
        }

        @JvmStatic
        public static boolean b() {
            if (jc1.k.n(IInteractService.class).getCurrentScene() != 9) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public static boolean c() {
            return vm.a.getValue().booleanValue();
        }

        @JvmStatic
        public static boolean d(int r1) {
            int r2 = (int) UtilityKotlinExtentionsKt.h(r1 / 2.0f);
            if (a() == false) goto L7;
            if (r2 <= UtilityKotlinExtentionsKt.i(157)) goto L7;
        L10:
            return true;
        L7:
            if (b() == true) goto L9;
        L11:
            return false;
        L9:
            if (r2 <= UtilityKotlinExtentionsKt.i(179)) goto L11;
            goto L10
        }

        public static void e(String r2, Function1 r3) {
            Intrinsics.checkNotNullParameter(r2, "color");
            Intrinsics.checkNotNullParameter(r3, "success");
            Integer r0 = null;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            r0 = Integer.valueOf(Color.parseColor(r2));     // Catch: Throwable -> L5
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            if (r0 != null) goto L9;
            ALogger.e("DecorationView", "parse color failed, from str: " + r3);
            return;
        L9:
            Intrinsics.checkNotNull(r0);
            r3.invoke(r0);
            return;
        L5:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public static final class d extends com.bytedance.android.live.core.utils.q0 {
        public boolean a;
        public final /* synthetic */ u b;

        public d(u r1) {
            this.b = r1;
        }

        public final void h(py.k r7, int r8, int r9) {
            if (this.a == false) goto L5;
            return;
        L5:
            this.a = true;
            u r0 = this.b;
            r0.o = (int) UIUtils.dip2Px(r0.getContext(), r8 / 2.0f);
            u r10 = this.b;
            r10.p = (int) UIUtils.dip2Px(r10.getContext(), r9 / 2.0f);
            u r11 = this.b;
            r11.q = r11.o / 2;
            r11.r = r11.p / 2;
            u.c(r11);
            u r12 = this.b;
            if (r12.A == false) goto L11;
            b r13 = r12.B;
            if (r13 == null) goto L11;
            r13.vd();
        L11:
            if (1 != this.b.getRoomDecoration().getType()) goto L37;
            ViewGroup.LayoutParams r14 = this.b.c.getLayoutParams();
            if (r14 == null) goto L36;
            FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14;
            if (this.b.getRoomDecoration().getInputRect() == null) goto L20;
            if (this.b.getRoomDecoration().getInputRect().size() != 4) goto L20;
            r15.leftMargin = (int) UIUtils.dip2Px(this.b.getContext(), ((Number) ListProtector.get(this.b.getRoomDecoration().getInputRect(), 0)).floatValue() / 2.0f);
            r15.topMargin = (int) UIUtils.dip2Px(this.b.getContext(), ((Number) ListProtector.get(this.b.getRoomDecoration().getInputRect(), 1)).floatValue() / 2.0f);
            r15.width = (int) UIUtils.dip2Px(this.b.getContext(), ((Number) ListProtector.get(this.b.getRoomDecoration().getInputRect(), 2)).floatValue() / 2.0f);
            r15.height = (int) UIUtils.dip2Px(this.b.getContext(), ((Number) ListProtector.get(this.b.getRoomDecoration().getInputRect(), 3)).floatValue() / 2.0f);
        L20:
            if (this.b.getRoomDecoration().getSubType() != 3) goto L22;
            this.b.c.setGravity(8388611);
        L23:
            this.b.c.setLayoutParams(r15);
            u r16 = this.b;
            r16.c.setTextSize(1, r16.getRoomDecoration().getTextSize() / 2);
            c r17 = u.P;
            String r18 = this.b.getRoomDecoration().getTextColor();
            Function1<Integer, Unit> r1 = new DecorationView$loadImage$1$onLoadSuccess$1(this);
            r17.getClass();
            c.e(r18, r1);
            u r19 = this.b;
            String r20 = r19.z;
            if (r20 != null) goto L26;
            r20 = r19.getRoomDecoration().getContent();
        L26:
            if (r20 != null) goto L28;
            r20 = "";
        L28:
            this.b.c.setText(r20);
            u r21 = this.b;
            r21.c.setTypeface(u.b(r21));
            u r22 = this.b;
            if (r22.A == false) goto L31;
            r22.c.setOnClickListener(r22.K);
        L32:
            this.b.c.setVisibility(0);
            UIUtils.setViewVisibility(this.b.d, 8);
            u r23 = this.b;
            if (r23.L == false) goto L40;
            r23.j();
        L40:
            this.b.setVisibility(0);
            u r24 = this.b;
            if (r24.A == true) goto L46;
            ImageView r25 = r24.b;
            if (r25 == null) goto L47;
            r25.post(new w(this));
            return;
        L47:
            return;
        L46:
            return;
        L31:
            r22.c.setOnClickListener(r22.N);
            goto L32
        L22:
            this.b.c.setGravity(17);
            goto L23
        L36:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        L37:
            this.b.c.setVisibility(8);
            this.b.d.setVisibility(8);
            u r26 = this.b;
            if (r26.A == true) goto L40;
            r26.b.setOnClickListener(r26.N);
            goto L40
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ u a;
        public final /* synthetic */ TextView b;

        public e(u r1, TextView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            this.a.o = this.b.getWidth();
            float r0 = this.a.getX();
            u r1 = this.a;
            int r2 = r1.o;
            float r3 = r0 + r2;
            int r4 = r1.n[3];
            if (r3 <= r4) goto L8;
            ObjectAnimator r5 = ObjectAnimator.ofFloat(r1, "translationX", new float[]{r1.getX(), r4 - r2});
            r5.setDuration(300);
            r5.start();
            b r6 = this.a.B;
            if (r6 == null) goto L9;
            r6.vd();
            return;
        L9:
            return;
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

    private final Handler getNinePatchHandler() {
        return (Handler) this.J.getValue();
    }

    static {
        P = new c();
    }

    public final void e() {
        if (this.A == true) goto L5;
        return;
    L5:
        this.L = false;
        if (this.k.getVisibility() != 8) goto L9;
        return;
    L9:
        if (this.j.getVisibility() != 0) goto L11;
        TextView r0 = this.j;
        r0.setPadding(r0.getPaddingLeft() - UtilityKotlinExtentionsKt.i(38), r0.getPaddingTop(), r0.getPaddingRight(), r0.getPaddingBottom());
    L12:
        this.k.setVisibility(8);
        return;
    L11:
        int r1 = UtilityKotlinExtentionsKt.i(38);
        this.c.getLayoutParams().width += r1;
        TextView r2 = this.c;
        com.bytedance.android.live.core.utils.a1.m(r2, com.bytedance.android.live.core.utils.a1.f(r2) - r1);
        goto L12
    }

    public final JSONObject getDecorationInfo() {
        JSONObject r0 = new JSONObject();
        r0.put("id", getRoomDecoration().getId());     // Catch: JSONException -> L5
        r0.put("x", getRoomDecoration().getX());     // Catch: JSONException -> L5
        r0.put("y", getRoomDecoration().getY());     // Catch: JSONException -> L5
        r0.put("w", this.s);     // Catch: JSONException -> L5
        r0.put("h", this.t);     // Catch: JSONException -> L5
        r0.put("type", getRoomDecoration().getType());     // Catch: JSONException -> L5
        r0.put("content", this.z);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final RoomDecoration getRoomDecoration() {
        if (this.A == false) goto L6;
        this.a.setScreenWidth(this.s);
        this.a.setScreenHeight(this.t);
    L6:
        return this.a;
    }

    public final String getStickerInfoMonitor() {
        JSONObject r0 = new JSONObject();
        r0.put("id", String.valueOf(getRoomDecoration().getId()));
        if (getRoomDecoration().isTextSticker() == false) goto L5;
        r0.put("type", "textSticker");
        r0.put("content", this.z);
        r0.put("fontID", this.M);
    L6:
        r0.put("x", Float.valueOf(getX()));
        r0.put("y", Float.valueOf(getY()));
        r0.put("w", this.t);
        r0.put("h", this.s);
        return r0.toString();
    L5:
        r0.put("type", "imageSticker");
        goto L6
    }

    public final void h() {
        this.b.setVisibility(0);
        this.j.setVisibility(8);
        ImageUtil.loadImage(this.b, getRoomDecoration().getImage(), new d(this));
    }

    public final void j() {
        if (this.A == true) goto L5;
        return;
    L5:
        this.L = false;
        if (this.k.getVisibility() != 0) goto L9;
        return;
    L9:
        if (this.j.getVisibility() != 0) goto L16;
        TextView r1 = this.j;
        ConstraintLayout r4 = this.k;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L14;
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r5;
        r6.leftMargin = r1.getPaddingLeft();
        r6.topMargin = r1.getPaddingTop();
        r6.height = (this.p - r1.getPaddingTop()) - r1.getPaddingBottom();
        Unit r2 = Unit.INSTANCE;
        r4.setLayoutParams(r6);
        r1.setPadding(r1.getPaddingLeft() + UtilityKotlinExtentionsKt.i(38), r1.getPaddingTop(), r1.getPaddingRight(), r1.getPaddingBottom());
    L20:
        GradientDrawable r3 = new GradientDrawable();
        c r7 = P;
        String r8 = getRoomDecoration().getAuditTextColor();
        r7.getClass();
        Intrinsics.checkNotNullParameter("#FFEBA825", "defaultColor");
        int r9 = ColorProtector.parseColor("#FFEBA825");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L23
        r9 = Color.parseColor(r8);     // Catch: Throwable -> L23
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        r3.setStroke((int) UtilityKotlinExtentionsKt.h(0.5f), r9);
        r3.setCornerRadius(UtilityKotlinExtentionsKt.h(2));
        this.l.setBackground(r3);
        this.l.setTextColor(r9);
        this.k.setVisibility(0);
        return;
    L23:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L16:
        if (this.c.getVisibility() != 0) goto L29;
        TextView r12 = this.c;
        ConstraintLayout r13 = this.k;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L28;
        FrameLayout.LayoutParams r15 = (FrameLayout.LayoutParams) r14;
        r15.leftMargin = com.bytedance.android.live.core.utils.a1.f(r12);
        r15.topMargin = com.bytedance.android.live.core.utils.a1.h(r12);
        r15.height = r12.getLayoutParams().height;
        Unit r16 = Unit.INSTANCE;
        r13.setLayoutParams(r15);
        int r17 = UtilityKotlinExtentionsKt.i(38);
        r12.getLayoutParams().width -= r17;
        com.bytedance.android.live.core.utils.a1.m(r12, com.bytedance.android.live.core.utils.a1.f(r12) + r17);
        goto L20
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L29:
        this.L = true;
    }

    public final void k() {
        if (this.A == true) goto L11;
        ImageView r0 = this.m;
        if (r0 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r0);
    L7:
        a r1 = this.O;
        if (r1 == null) goto L12;
        r1.X6(getRoomDecoration().isTextSticker());
        return;
    L12:
        return;
    }

    private final Typeface getCustomTypeface() {
        DecorationFontConfig r0 = getRoomDecoration().getTextFontConfig();
        if (r0 == null) goto L5;
        long r1 = r0.getStatus();
    L6:
        Typeface r4 = null;
        if (r1 != 1) goto L33;
        DecorationFontConfig r2 = getRoomDecoration().getTextFontConfig();
        if (r2 == null) goto L11;
        Long r3 = Long.valueOf(r2.getFontId());
    L12:
        Lazy<String> r5 = LiveStickerTtfUtil.a;
        if (r3 == null) goto L33;
        long r6 = r3.longValue();
        ConcurrentHashMap r7 = (ConcurrentHashMap) LiveStickerTtfUtil.b;
        if (r7.containsKey(Long.valueOf(r6)) == false) goto L19;
        Typeface r8 = (Typeface) r7.get(Long.valueOf(r6));
    L17:
        r4 = r8;
        goto L33
    L19:
        if (LiveStickerTtfUtil.a(r3) == false) goto L33;
        String r9 = LiveStickerTtfUtil.c(r3.longValue());
        if (TypeFaceOptimizer.getSwitch() == false) goto L29;
        if (r9 == null) goto L29;
        if (TypeFaceLancet.cache.contains(r9) == false) goto L26;
        Typeface r10 = (Typeface) TypeFaceLancet.cache.get(r9);
    L30:
        if (r10 == null) goto L32;
        r7.put(Long.valueOf(r6), r10);
    L32:
        r8 = (Typeface) r7.get(Long.valueOf(r6));
        goto L17
    L26:
        Typeface r11 = Typeface.createFromFile(r9);
        if (r11 == null) goto L29;
        TypeFaceLancet.cache.put(r9, r11);
        r10 = r11;
    L29:
        r10 = Typeface.createFromFile(r9);
        goto L30
    L11:
        r3 = null;
    L33:
        if (r4 == null) goto L39;
        DecorationFontConfig r12 = getRoomDecoration().getTextFontConfig();
        if (r12 == null) goto L37;
        long r13 = r12.getFontId();
    L38:
        this.M = r13;
        goto L39
    L37:
        r13 = -1;
    L39:
        if (r4 == null) goto L41;
        return r4;
    L41:
        return Typeface.DEFAULT;
    L5:
        r1 = 0;
        goto L6
    }

    public final int getType() {
        return getRoomDecoration().getType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        setDecorationLayout(false);
        if (getRoomDecoration().getNinePatchImage() != null) goto L5;
    L9:
        h();
    L11:
        if (this.A == false) goto L14;
        com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.a.b(1);
        return;
    L14:
        return;
    L5:
        if (getRoomDecoration().isTextSticker() == false) goto L9;
        if (getRoomDecoration().isReserveDecoration() == true) goto L9;
        com.bytedance.android.livesdk.chatroom.utils.a1.u(getRoomDecoration().getNinePatchImage(), new DecorationView$loadNinePatchImage$1(this));
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public static final /* synthetic */ Typeface b(u r0) {
        return r0.getCustomTypeface();
    }

    public static final /* synthetic */ void c(u r1) {
        r1.setDecorationLayout(true);
    }

    private final void setDecorationLayout(boolean r11) {
        if (this.o <= 0) goto L5;
    L6:
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 == null) goto L10;
        r0.width = this.o;
        r0.height = this.p;
        setLayoutParams(r0);
    L10:
        if (getRoomDecoration().getX() == (-1)) goto L12;
    L20:
        float r2 = 1.0f;
        if (getRoomDecoration().getScreenWidth() <= 0) goto L23;
        float r1 = this.s / getRoomDecoration().getScreenWidth();
    L25:
        if (getRoomDecoration().getScreenHeight() <= 0) goto L27;
        r2 = this.t / getRoomDecoration().getScreenHeight();
    L27:
        int r3 = ((int) (getRoomDecoration().getX() * r1)) - this.q;
        int r4 = (int) (getRoomDecoration().getY() * r2);
        int r6 = this.r;
    L28:
        int r5 = r4 - r6;
    L29:
        int[] r7 = this.n;
        int r8 = r7[2];
        int r9 = r7[3];
        if (r3 >= r8) goto L32;
        r3 = r8;
    L35:
        int r10 = r7[0];
        int r12 = r7[1];
        if (r5 >= r10) goto L38;
        r5 = r10;
    L42:
        if (this.D == false) goto L46;
        r3 = ((r9 - r8) - this.o) / 2;
        r5 = ((r12 - r10) - this.p) / 2;
        if (r5 >= UtilityKotlinExtentionsKt.h(8)) goto L46;
        r5 = UtilityKotlinExtentionsKt.i(8);
    L46:
        setX(r3);
        setY(r5);
        l(false);
        if (r11 == false) goto L50;
        getRoomDecoration().setX(r3 + this.q);
        getRoomDecoration().setY(r5 + this.r);
        return;
    L50:
        return;
    L38:
        int r13 = this.p;
        if ((r5 + r13) <= r12) goto L42;
        r5 = r12 - r13;
        goto L42
    L32:
        int r14 = this.o;
        if ((r3 + r14) <= r9) goto L35;
        r3 = r9 - r14;
        goto L35
    L23:
        r1 = 1.0f;
        goto L25
    L12:
        if (getRoomDecoration().getY() != (-1)) goto L20;
        if (getRoomDecoration().getSit_rect() != null) goto L17;
    L19:
        r3 = (this.s / 2) - this.q;
        r4 = this.t / 3;
        r6 = this.r;
        goto L28
    L17:
        if (getRoomDecoration().getSit_rect().size() <= 1) goto L19;
        r3 = (int) (((double) this.s) * ((Number) ListProtector.get(getRoomDecoration().getSit_rect(), 0)).doubleValue());
        r5 = (int) (((double) this.t) * ((Number) ListProtector.get(getRoomDecoration().getSit_rect(), 1)).doubleValue());
        goto L29
    L5:
        if (this.p <= 0) goto L10;
        goto L6
    }

    public final void d(MotionEvent r5) {
        if (r5.getX() >= (this.d.getX() - 10.0f)) goto L5;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L15;
        this.d.performClick();
        return;
    L15:
        if (this.c.getVisibility() != 0) goto L18;
        this.c.performClick();
    L18:
        if (this.j.getVisibility() != 0) goto L22;
        this.j.performClick();
        return;
    L22:
        return;
    L5:
        if (r5.getY() < (this.d.getY() - 10.0f)) goto L11;
        if (r5.getX() > ((this.d.getX() + this.d.getWidth()) + 10.0f)) goto L11;
        if (r5.getY() > ((this.d.getY() + this.d.getHeight()) + 10.0f)) goto L11;
        r6 = true;
        goto L12
    }

    public final void l(boolean r4) {
        P.getClass();
        if (c.c() == true) goto L5;
        return;
    L5:
        if (c.b() == false) goto L17;
        float r0 = getX() + this.q;
        int r1 = this.s;
        if (r0 > (r1 / 2)) goto L10;
        float r2 = 0.0f;
    L11:
        if (r4 == false) goto L13;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this, "translationX", new float[]{getX(), r2});
        r5.setDuration(300);
        r5.start();
        return;
    L13:
        setX(r2);
        return;
    L10:
        r2 = r1 - this.o;
        goto L11
    }

    public final void m(int[] r7) {
        Intrinsics.checkNotNullParameter(r7, "validArea");
        if (r7.length >= 4) goto L5;
        return;
    L5:
        P.getClass();
        boolean r2 = false;
        if (c.c() == false) goto L43;
        if (c.a() == false) goto L22;
        View r0 = this.h;
        if (r0 == null) goto L20;
        int r3 = this.t;
        View r4 = this.g;
        if (r4 == null) goto L14;
        int r5 = com.bytedance.android.live.core.utils.a1.d(r4);
    L15:
        int r6 = r3 - r5;
        View r8 = this.i;
        if (r8 == null) goto L18;
        int r9 = com.bytedance.android.live.core.utils.a1.d(r8);
    L19:
        com.bytedance.android.live.core.utils.a1.k(r0, (r6 - r9) - UtilityKotlinExtentionsKt.i(157));
        goto L20
    L18:
        r9 = 0;
        goto L19
    L14:
        r5 = 0;
    L20:
        r7[1] = UtilityKotlinExtentionsKt.i(260);
        goto L43
    L22:
        if (c.b() == false) goto L35;
        View r1 = this.h;
        if (r1 == null) goto L34;
        int r10 = this.t;
        View r11 = this.g;
        if (r11 == null) goto L28;
        int r12 = com.bytedance.android.live.core.utils.a1.d(r11);
    L29:
        int r13 = r10 - r12;
        View r14 = this.i;
        if (r14 == null) goto L32;
        int r15 = com.bytedance.android.live.core.utils.a1.d(r14);
    L33:
        com.bytedance.android.live.core.utils.a1.k(r1, (r13 - r15) - UtilityKotlinExtentionsKt.i(179));
        goto L34
    L32:
        r15 = 0;
        goto L33
    L28:
        r12 = 0;
    L34:
        r7[1] = UtilityKotlinExtentionsKt.i(280);
        goto L43
    L35:
        View r16 = this.h;
        if (r16 == null) goto L43;
        if (getResources().getConfiguration().orientation != 1) goto L40;
        int r17 = UtilityKotlinExtentionsKt.i(177);
    L41:
        com.bytedance.android.live.core.utils.a1.k(r16, r17);
        goto L43
    L40:
        r17 = UtilityKotlinExtentionsKt.i(1);
    L43:
        if (PublicScreenStyleHelper.n == true) goto L45;
    L47:
        boolean r18 = false;
    L48:
        if (r18 == false) goto L56;
        View r19 = this.h;
        if (r19 == null) goto L56;
        int r20 = this.t - r7[1];
        View r21 = this.i;
        if (r21 == null) goto L54;
        int r22 = com.bytedance.android.live.core.utils.a1.d(r21);
    L55:
        com.bytedance.android.live.core.utils.a1.k(r19, r20 - r22);
        goto L56
    L54:
        r22 = 0;
    L56:
        this.n = r7;
        float r23 = getX();
        float r24 = this.n[2];
        if (r23 >= r24) goto L59;
        setX(r24);
    L62:
        float r25 = getY();
        float r26 = this.n[0];
        if (r25 >= r26) goto L65;
        setY(r26);
    L69:
        if (c.c() == false) goto L82;
        if (c.d((int) UtilityKotlinExtentionsKt.j(this.p * 2)) == false) goto L76;
        b r27 = this.B;
        if (r27 == null) goto L75;
        r27.q8(getRoomDecoration());
        this.B.vd();
    L75:
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(2131916157), 0);
    L92:
        Logger.i("DecorationView", "updateValidArea. bottom=" + r7[1]);
        return;
    L76:
        l(true);
        if (this.A == false) goto L92;
        getRoomDecoration().setX((int) (getX() + this.q));
        getRoomDecoration().setY((int) (getY() + this.r));
        b r28 = this.B;
        if (r28 == null) goto L92;
        r28.vd();
        goto L92
    L82:
        if (PublicScreenStyleHelper.n == true) goto L84;
    L86:
        if (r2 == false) goto L92;
        l(true);
        if (this.A == false) goto L92;
        getRoomDecoration().setX((int) (getX() + this.q));
        getRoomDecoration().setY((int) (getY() + this.r));
        b r29 = this.B;
        if (r29 == null) goto L92;
        r29.vd();
        goto L92
    L84:
        if (PublicScreenStyleHelper.b().d() == false) goto L86;
        r2 = true;
        goto L86
    L65:
        float r30 = getY();
        float r31 = this.p;
        float r32 = r30 + r31;
        float r33 = this.n[1];
        if (r32 <= r33) goto L69;
        setY(r33 - r31);
        goto L69
    L59:
        float r34 = getX() + this.o;
        float r35 = this.n[3];
        if (r34 <= r35) goto L62;
        setX(r35);
        goto L62
    L45:
        if (PublicScreenStyleHelper.b().d() == false) goto L47;
        r18 = true;
        goto L48
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        return this.A;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        if (this.D == false) goto L7;
        return super.onTouchEvent(r10);
    L7:
        if (this.A == false) goto L115;
        int r0 = r10.getAction();
        if (r0 != 0) goto L12;
        this.u = r10.getRawX();
        float r11 = r10.getRawY();
        this.v = r11;
        this.w = this.u;
        this.x = r11;
        Logger.i("DecorationView", "action_down. valid bottom=" + this.n[1]);
    L113:
        return true;
    L12:
        if (r0 == 1) goto L83;
        if (r0 == 2) goto L26;
        if (r0 != 3) goto L113;
        View r12 = this.f;
        if (r12 == null) goto L22;
        Intrinsics.checkNotNull(r12);
        r12.setVisibility(4);
        View r13 = this.f;
        Intrinsics.checkNotNull(r13);
        r13.setAlpha(1.0f);
    L22:
        if (this.B == null) goto L113;
        if (com.bytedance.android.live.core.utils.s1.F() == false) goto L113;
        this.B.Jb(false);
        goto L113
    L26:
        float r1 = Math.abs(r10.getRawX() - this.w);
        float r3 = Math.abs(r10.getRawY() - this.x);
        float r7 = this.C;
        if (r1 < r7) goto L29;
    L31:
        this.y = true;
        float r2 = r10.getRawX() - this.u;
        float r4 = r10.getRawY() - this.v;
        if ((getX() + r2) < this.n[2]) goto L37;
        if (((getX() + this.o) + r2) > this.n[3]) goto L37;
        this.u = r10.getRawX();
        setX(getX() + r2);
    L37:
        if ((getY() + r4) >= this.n[0]) goto L39;
    L41:
        boolean r14 = g(this, this.g);
        if (r14 == false) goto L57;
        if (this.E == true) goto L57;
        this.E = true;
        Button r15 = this.e;
        if (r15 == null) goto L71;
        ViewPropertyAnimator r16 = r15.animate();
        if (r16 == null) goto L71;
        ViewPropertyAnimator r17 = r16.scaleX(1.2f);
        if (r17 == null) goto L71;
        ViewPropertyAnimator r18 = r17.scaleY(1.2f);
        if (r18 == null) goto L71;
        ViewPropertyAnimator r19 = r18.setDuration(200);
        if (r19 == null) goto L71;
        r19.start();
    L71:
        if (this.B != null) goto L73;
    L75:
        View r110 = this.f;
        if (r110 == null) goto L113;
        Intrinsics.checkNotNull(r110);
        r110.setAlpha(1.0f);
        View r111 = this.f;
        Intrinsics.checkNotNull(r111);
        if (r111.getVisibility() == 0) goto L113;
        View r112 = this.f;
        Intrinsics.checkNotNull(r112);
        r112.setVisibility(0);
        goto L113
    L73:
        if (com.bytedance.android.live.core.utils.s1.F() == false) goto L75;
        this.B.Jb(true);
    L57:
        if (this.E == false) goto L71;
        if (r14 == true) goto L71;
        this.E = false;
        Button r113 = this.e;
        if (r113 == null) goto L71;
        ViewPropertyAnimator r114 = r113.animate();
        if (r114 == null) goto L71;
        ViewPropertyAnimator r115 = r114.scaleX(1.0f);
        if (r115 == null) goto L71;
        ViewPropertyAnimator r116 = r115.scaleY(1.0f);
        if (r116 == null) goto L71;
        ViewPropertyAnimator r117 = r116.setDuration(200);
        if (r117 == null) goto L71;
        r117.start();
        goto L71
    L39:
        if (((getY() + this.p) + r4) > this.n[1]) goto L41;
        this.v = r10.getRawY();
        setY(getY() + r4);
        goto L41
    L29:
        if (r3 >= r7) goto L31;
        return true;
    L83:
        if (g(this, this.g) == false) goto L88;
        b r118 = this.B;
        if (r118 == null) goto L103;
        r118.q8(getRoomDecoration());
        this.B.vd();
    L103:
        View r119 = this.f;
        if (r119 == null) goto L108;
        Intrinsics.checkNotNull(r119);
        r119.setVisibility(4);
        View r120 = this.f;
        Intrinsics.checkNotNull(r120);
        r120.setAlpha(1.0f);
    L108:
        if (this.B == null) goto L113;
        if (com.bytedance.android.live.core.utils.s1.F() == false) goto L113;
        this.B.Jb(false);
        goto L113
    L88:
        if (this.c.getVisibility() != 0) goto L93;
        if (this.y == true) goto L93;
        d(r10);
    L93:
        if (this.j.getVisibility() != 0) goto L98;
        if (this.y == true) goto L98;
        d(r10);
    L98:
        if (this.y == false) goto L103;
        l(true);
        getRoomDecoration().setX((int) (getX() + this.q));
        getRoomDecoration().setY((int) (getY() + this.r));
        b r121 = this.B;
        if (r121 == null) goto L102;
        r121.vd();
    L102:
        this.y = false;
        goto L103
    L115:
        return false;
    }

    public final void setText(String r2) {
        this.z = r2;
        this.c.setText(r2);
        if (this.j.getVisibility() != 0) goto L6;
        i(this.j, this.z);
        return;
    }

    public static final void a(u r2, Integer r3) {
        r2.getClass();
        if (r3 == null) goto L11;
        r3.intValue();
        ImageView r4 = r2.m;
        if (r4 == null) goto L12;
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 == null) goto L10;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        r1.leftMargin = r3.intValue() - UtilityKotlinExtentionsKt.i(14);
        r4.setLayoutParams(r1);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L12:
        return;
    }

    public final boolean g(View r3, View r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        r3.getLocationOnScreen(this.G);
        r4.getLocationOnScreen(this.F);
        f(r3, this.H, this.G);
        f(r4, this.I, this.F);
        return this.H.intersect(this.I);
    }

    public final void i(TextView r4, String r5) {
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r4.setText(r5);
        if (this.A == false) goto L9;
        getNinePatchHandler().postDelayed(new e(this, r4), 200);
        return;
    }

    public static void f(View r2, Rect r3, int[] r4) {
        int r0 = r4[0];
        r3.left = r0;
        r3.top = r4[1];
        Intrinsics.checkNotNull(r2);
        r3.right = r0 + r2.getMeasuredWidth();
        r3.bottom = r3.top + r2.getMeasuredHeight();
    }

    public u(ViewGroup r3, RoomDecoration r4, boolean r5, int[] r6, b r7, a r8) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNullParameter(r4, "roomDecoration");
        Intrinsics.checkNotNullParameter(r6, "validArea");
        super(r3.getContext());
        this.O = r8;
        this.F = new int[2];
        this.G = new int[2];
        this.H = new Rect();
        this.I = new Rect();
        this.J = LazyKt.lazy(DecorationView$ninePatchHandler$2.INSTANCE);
        this.M = -1;
        View.inflate(r3.getContext(), 2131565360, this);
        this.a = r4;
        this.A = r5;
        this.n = r6;
        this.B = r7;
        this.s = UIUtils.getScreenWidth(getContext());
        this.t = UIUtils.getScreenHeight(getContext());
        this.b = (ImageView) findViewById(2131384784);
        this.c = (TextView) findViewById(2131384785);
        this.d = (TextView) findViewById(2131384782);
        this.j = (TextView) findViewById(2131380905);
        this.k = findViewById(2131384780);
        this.l = (TextView) findViewById(2131384781);
        ImageView r9 = (ImageView) findViewById(2131384783);
        this.m = r9;
        this.C = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        View.inflate(r3.getContext(), 2131565356, r3);
        this.f = r3.findViewById(2131377589);
        this.g = r3.findViewById(2131368796);
        this.h = r3.findViewById(2131380007);
        this.i = r3.findViewById(2131364500);
        this.e = (Button) r3.findViewById(2131368797);
        if (ew.a.getValue().booleanValue() == false) goto L5;
        post(new v(this));
    L5:
        this.D = false;
        this.K = new r(this, r5);
        this.N = new s(this);
        r9.setOnClickListener(new t(this, r4));
        if (r8 != null) goto L8;
    L12:
        if (r9 == null) goto L14;
        UtilityKotlinExtentionsKt.t(r9);
    L14:
        if (r8 != null) goto L16;
        return;
    L16:
        if (r8.s9(r4.isTextSticker()) == true) goto L20;
        UtilityKotlinExtentionsKt.t(this);
        return;
    L20:
        return;
    L8:
        if (r8.o8(r4.isTextSticker()) != true) goto L12;
        int r10 = com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.c.a;
        if (gt.a.getValue().booleanValue() == false) goto L12;
        k();
        goto L14
    }
}
