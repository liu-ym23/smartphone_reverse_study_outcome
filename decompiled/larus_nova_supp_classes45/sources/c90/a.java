package c90;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.core.widget.bubble.LiveBubbleLayout;
import com.bytedance.android.live.core.widget.bubble.LiveBubbleTextView;
import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends LivePopupWindow {
    public final Activity A;
    public final View B;
    public final d C;
    public final c D;
    public final e E;
    public int g;
    public float h;
    public float i;
    public final int j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public boolean n;
    public int o;
    public int p;
    public final long q;
    public final int r;
    public final int s;
    public final boolean t;
    public boolean u;
    public LiveBubbleLayout v;
    public LiveBubbleTextView w;
    public boolean x;
    public int y;
    public AnimatorSet z;

    /* JADX INFO: renamed from: c90.a$a, reason: collision with other inner class name */
    public static class C0006a {
        public int a;
        public boolean b;
        public int c;
        public int d;
        public long e;
        public boolean f;
        public View g;
        public int h;
        public int i;
        public String j;
        public final float k;
        public final float l;
        public int m;
        public c n;
        public d o;
        public boolean p;
        public float q;
        public boolean r;
        public boolean s;
        public final boolean t;
        public final float u;
        public final int v;
        public final int w;
        public final Activity x;

        public final Activity getActivity() {
            return this.x;
        }

        public C0006a(Activity r4) {
            Intrinsics.checkNotNullParameter(r4, "activity");
            this.x = r4;
            this.b = true;
            this.e = n5.DEFAULT_SHOW_DURATION;
            this.f = true;
            this.j = "";
            this.k = 197.0f;
            this.l = 13.0f;
            this.p = true;
            this.q = 12.0f;
            this.r = true;
            this.t = true;
            this.u = UIUtils.dip2Px(r4, 8.0f);
            this.v = (int) UIUtils.dip2Px(r4, 56.0f);
            this.w = (int) UIUtils.dip2Px(r4, 7.0f);
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "str");
            this.j = r2;
        }
    }

    public static final class b {
    }

    public interface c {
        void bubbleDismiss();
    }

    public interface d {
        void bubbleShow();
    }

    public static final class e implements Runnable {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r0 = this.a;     // Catch: Throwable -> L4
            int r1 = r0.g;     // Catch: Throwable -> L4
            r0.d(false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ a a;

        public f(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.getClass();
            a r2 = this.a;
            PopupWindowLancet.handleDismissBeforeOrigin(r2);
            r2.dismiss();
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        if (this.x == true) goto L6;
        d(false);
        getContentView().removeCallbacks(this.E);
        this.o = 0;
        this.p = 0;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        int r0 = this.r;
        if (r0 != 0) goto L5;
    L7:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        return;
    L5:
        if (this.s == 0) goto L7;
        int r1 = View.MeasureSpec.makeMeasureSpec(r0, 1073741824);
        int r2 = View.MeasureSpec.makeMeasureSpec(this.s, 1073741824);
        getContentView().measure(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        AnimatorSet r0 = this.z;
        if (r0 == null) goto L5;
        r0.removeAllListeners();
    L5:
        AnimatorSet r1 = this.z;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.z = null;
        if (this.A.isFinishing() == false) goto L11;
        return;
    L11:
        if (isShowing() == false) goto L19;
        PopupWindowLancet.handleDismissBeforeOrigin(this);     // Catch: Exception -> L15
        super.dismiss();     // Catch: Exception -> L15
        return;
    L20:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int e() {
        f();
        return getContentView().getMeasuredWidth();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.widget.TextView, com.bytedance.android.live.core.widget.bubble.LiveBubbleTextView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public a(C0006a r21) {
        Intrinsics.checkNotNullParameter(r21, "builder");
        this.k = true;
        this.l = true;
        this.q = n5.DEFAULT_SHOW_DURATION;
        this.t = true;
        Activity r3 = r21.getActivity();
        this.A = r3;
        this.g = 0;
        this.i = 0.0f;
        int r6 = r21.a;
        this.j = r6;
        boolean r7 = r21.b;
        this.k = r7;
        this.n = false;
        this.o = r21.c;
        this.p = r21.d;
        this.q = r21.e;
        boolean r8 = r21.f;
        View r9 = r21.g;
        this.B = r9;
        int r11 = r21.i;
        this.s = r11;
        int r12 = r21.h;
        this.r = r12;
        CharSequence r13 = r21.j;
        float r14 = r21.k;
        float r15 = r21.l;
        int r16 = r21.m;
        this.D = r21.n;
        this.C = r21.o;
        this.t = r21.p;
        float r5 = r21.q;
        boolean r2 = r21.r;
        this.m = r21.s;
        boolean r4 = r21.t;
        float r17 = r21.u;
        int r18 = r21.v;
        int r1 = r21.w;
        UIUtils.dip2Px(r3, 3.0f);
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setOutsideTouchable(r2);
        setClippingEnabled(false);
        setBackgroundDrawable(new ColorDrawable(0));
        setInputMethodMode(1);
        setSoftInputMode(16);
        if (r8 == true) goto L9;
        if (r9 == null) goto L9;
        h(r9);
        LiveBubbleLayout r19 = this.v;
        if (r19 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L8:
        r19.setUseDefaultView(false);
        int r22 = 2;
    L48:
        if (r12 == 0) goto L51;
        if (r11 == 0) goto L51;
        setWidth(r12);
        setHeight(r11);
        int r23 = LiveBubbleLayout.C;
        LiveBubbleLayout.G = getWidth();
    L51:
        boolean r24 = this.n;
        if (r24 == false) goto L56;
        if (r24 == false) goto L56;
        getContentView().setSystemUiVisibility(4102);
    L56:
        if (r6 == 0) goto L61;
        LiveBubbleLayout r25 = this.v;
        if (r25 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L60:
        r25.setMBgColor(r6);
    L61:
        if (r4 == true) goto L67;
        LiveBubbleLayout r26 = this.v;
        if (r26 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L65:
        r26.setNeedAddColor(false);
    L67:
        LiveBubbleLayout r27 = this.v;
        if (r27 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L70:
        r27.setMNeedPath(r7);
        LiveBubbleLayout r28 = this.v;
        if (r28 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L73:
        int r29 = this.g;
        if (r29 == 3) goto L84;
        if (r29 != 5) goto L77;
    L83:
        r22 = 1;
        goto L84
    L77:
        if (r29 != 48) goto L79;
        r22 = 3;
        goto L84
    L79:
        if (r29 != 80) goto L83;
        r22 = 0;
    L84:
        r28.setBubbleOrientation(r22);
        if (r5 == 0.0f) goto L90;
        LiveBubbleLayout r31 = this.v;
        if (r31 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L89:
        r31.setMPadding(r5);
    L90:
        LiveBubbleLayout r32 = this.v;
        if (r32 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L93:
        r32.setCornerRadius(r17);
        LiveBubbleLayout r33 = this.v;
        if (r33 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L96:
        r33.setDefaultHeight(r18);
        LiveBubbleLayout r34 = this.v;
        if (r34 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L99:
        r34.setArrowHeight(r1);
        this.E = new e(this);
        return;
    L9:
        ?? r35 = new LiveBubbleTextView(this.A, null);
        this.w = r35;
        if (r16 == 0) goto L12;
        r35.setTextColor(r16);
    L13:
        LiveBubbleTextView r36 = this.w;
        if (r36 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L16:
        r36.setTextSize(1, 13.0f);
        AppCompatTextView r37 = this.w;
        if (r37 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L19:
        r37.setTextAlignment(5);
        AppCompatTextView r38 = this.w;
        if (r38 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L22:
        r38.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        AppCompatTextView r39 = this.w;
        if (r39 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L25:
        r39.setGravity(17);
        AppCompatTextView r41 = this.w;
        if (r41 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L28:
        r41.setMaxWidth((int) UIUtils.dip2Px(r3, r14));
        AppCompatTextView r42 = this.w;
        if (r42 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L31:
        r22 = 2;
        r42.setMaxLines(2);
        AppCompatTextView r43 = this.w;
        if (r43 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L34:
        h(r43);
        this.n = true;
        if (TextUtils.isEmpty(r13) == true) goto L41;
        AppCompatTextView r44 = this.w;
        if (r44 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L39:
        r44.setText(r13);
    L41:
        if (r15 == 0.0f) goto L47;
        LiveBubbleTextView r45 = this.w;
        if (r45 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L45:
        r45.setTextSize(1, r15);
    L47:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
        goto L48
    L12:
        r35.setTextColor(r3.getResources().getColor(2131108463));
        goto L13
    }

    public final void d(boolean r3) {
        LiveBubbleLayout r0 = this.v;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L5:
        if (r3 == true) goto L7;
        this.x = true;
    L7:
        this.z = new AnimatorSet();
        if (r0 == null) goto L11;
        r0.post(new c90.b(this, r0, r3));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(View r4) {
        LiveBubbleLayout r0 = new LiveBubbleLayout(this.A);
        this.v = r0;
        r0.setBackgroundColor(0);
        LiveBubbleLayout r1 = this.v;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L5:
        r1.addView(r4);
        LiveBubbleLayout r5 = this.v;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L8:
        r5.setGravity(17);
        ViewGroup.MarginLayoutParams r6 = new ViewGroup.MarginLayoutParams(-2, -2);
        LiveBubbleLayout r2 = this.v;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L11:
        r2.setLayoutParams(r6);
        LiveBubbleLayout r7 = this.v;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L14:
        r7.setVisibility(8);
        if (this.j == 0) goto L20;
        LiveBubbleLayout r8 = this.v;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L19:
        r8.setMBgColor(this.j);
    L20:
        LiveBubbleLayout r9 = this.v;
        if (r9 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L23:
        r9.setMNeedPath(this.k);
        LiveBubbleLayout r11 = this.v;
        if (r11 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L26:
        r11.setMNeedArrow(this.t);
        LiveBubbleLayout r12 = this.v;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L29:
        r12.setMNeedPressFade(false);
        LiveBubbleLayout r13 = this.v;
        if (r13 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L32:
        r13.setMNeedShadow(this.m);
        LiveBubbleLayout r14 = this.v;
        if (r14 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L35:
        r14.setMShadowColor(0);
        LiveBubbleLayout r15 = this.v;
        if (r15 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L38:
        r15.setOnClickListener(new f(this));
        LiveBubbleLayout r16 = this.v;
        if (r16 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L41:
        setContentView(r16);
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(View r13, int r14, boolean r15) {
        if (this.A.isFinishing() == true) goto L74;
        if (r13 != null) goto L6;
        return;
    L6:
        if (r13.getWindowToken() == null) goto L78;
        r13.getMeasuredHeight();
        r13.getMeasuredWidth();
        getContentView().removeCallbacks(this.E);
        this.g = r14;
        LiveBubbleLayout r0 = this.v;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L11:
        this.y = r0.getPADDING();
        if (isShowing() == false) goto L14;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    L14:
        if (r14 == 3) goto L22;
        if (r14 == 5) goto L21;
        if (r14 == 48) goto L20;
        if (r14 != 80) goto L21;
        int r8 = 0;
    L23:
        int r9 = this.r;
        if (r9 != 0) goto L26;
    L28:
        getContentView().measure(Integer.MIN_VALUE, Integer.MIN_VALUE);
    L29:
        if (r15 == false) goto L37;
        if (r14 == 80) goto L35;
        if (r14 == 48) goto L35;
        f();
        this.h = getContentView().getMeasuredHeight() / 2.0f;
    L39:
        LiveBubbleLayout r11 = this.v;
        if (r11 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mDmtBubbleLayout");
    L42:
        r11.r = this.h + this.i;
        r11.s = r8;
        int[] r1 = new int[2];
        r13.getLocationOnScreen(r1);
        if (r14 == 3) goto L65;
        if (r14 != 5) goto L46;
        if (r15 == false) goto L63;
        int r16 = r13.getMeasuredHeight();
        f();
        int r17 = (r16 - getContentView().getMeasuredHeight()) / 2;
    L64:
        c(this, r13, (r1[0] + this.o) + r13.getWidth(), ((r1[1] + this.p) + r17) + ((int) UIUtils.dip2Px(this.A, 1.3f)));
    L69:
        this.x = false;
        if (this.q <= 0) goto L76;
        getContentView().postDelayed(this.E, this.q);
        return;
    L76:
        return;
    L63:
        r17 = 0;
        goto L64
    L46:
        if (r14 == 48) goto L57;
        if (r14 != 80) goto L69;
        if (r15 == false) goto L51;
        int r18 = (r13.getMeasuredWidth() - e()) / 2;
    L52:
        int r19 = (this.o + r18) + ((int) UIUtils.dip2Px(this.A, 1.4f));
        int r110 = this.p + ((int) UIUtils.dip2Px(this.A, 1.3f));
        OverlaySource r2 = PopupWindowLancet.resolveSource(r13);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r13, r2) == true) goto L56;
        showAsDropDown(r13, r19, r110);
        PopupWindowLancet.trackAfterShow(this, r2, r13);
    L56:
        d(true);
        goto L69
    L51:
        r18 = 0;
        goto L52
    L57:
        if (r15 == false) goto L59;
        int r111 = (r13.getMeasuredWidth() - e()) / 2;
    L60:
        int r112 = ((r1[0] + this.o) + r111) + ((int) UIUtils.dip2Px(this.A, 1.4f));
        int r113 = r1[1];
        f();
        c(this, r13, r112, ((r113 - getContentView().getMeasuredHeight()) + this.p) + ((int) UIUtils.dip2Px(this.A, 1.3f)));
        goto L69
    L59:
        r111 = 0;
        goto L60
    L65:
        if (r15 == false) goto L67;
        int r114 = r13.getMeasuredHeight();
        f();
        int r115 = (r114 - getContentView().getMeasuredHeight()) / 2;
    L68:
        c(this, r13, (r1[0] + this.o) - e(), ((r1[1] + this.p) + r115) + ((int) UIUtils.dip2Px(this.A, 1.3f)));
        goto L69
    L67:
        r115 = 0;
    L35:
        this.h = e() / 2.0f;
        goto L39
    L37:
        if (this.u == true) goto L39;
        this.i += this.y * 8;
        this.u = true;
        goto L39
    L26:
        if (this.s == 0) goto L28;
        getContentView().measure(View.MeasureSpec.makeMeasureSpec(r9, 1073741824), View.MeasureSpec.makeMeasureSpec(this.s, 1073741824));
        goto L29
    L20:
        r8 = 3;
    L21:
        r8 = 1;
        goto L23
    L22:
        r8 = 2;
        goto L23
    L78:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(a r8, View r9, int r11, int r12) {
        if (PopupWindowLancet.hasSubWindowToken(r9) == false) goto L6;
        return;
    L6:
        if ((r8 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r9);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r8, r9, r0, 0, r11, r12) == false) goto L14;
        return;
    L14:
        r8.showAtLocation(r9, 0, r11, r12);
        PopupWindowLancet.trackAfterShow(r8, r0, r9);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r8) == false) goto L11;
        r8.showAtLocation(r9, 0, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showAtLocation(View r8, int r9, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L7;
    L13:
        d(true);     // Catch: Exception -> L15
        return;
    L7:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L9;
        super.showAtLocation(r8, r9, r11, r12);     // Catch: Exception -> L15
        goto L13
    L9:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r8);     // Catch: Exception -> L15
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r8, r0, r9, r11, r12) == true) goto L13;
        super.showAtLocation(r8, r9, r11, r12);     // Catch: Exception -> L15
        PopupWindowLancet.trackAfterShow(this, r0, r8);     // Catch: Exception -> L15
    }
}
