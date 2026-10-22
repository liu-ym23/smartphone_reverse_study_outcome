package ec;

import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.obric.cae.R;
import ha.t;
import he.i;
import java.util.ArrayList;
import java.util.Iterator;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: ec.a$a, reason: collision with other inner class name */
    public static final enum EnumC0067a extends Enum<EnumC0067a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0067a f7214a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0067a f7215b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final EnumC0067a f7216m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ EnumC0067a[] f7217n = null;

        static {
            EnumC0067a r8 = new EnumC0067a("SMALL", 0, 0.4f);
            f7214a = r8;
            EnumC0067a r10 = new EnumC0067a("MEDIUM", 1, 0.8f);
            f7215b = r10;
            EnumC0067a r11 = new EnumC0067a("LARGE", 2, 1.0f);
            f7216m = r11;
            f7217n = new EnumC0067a[]{r8, r10, r11};
        }

        public EnumC0067a(String r8, int r10, float r11) {
            super(r8, r10);
        }

        public static EnumC0067a valueOf(String r8) {
            return (EnumC0067a) Enum.valueOf(EnumC0067a.class, r8);
        }

        public static EnumC0067a[] values() {
            return (EnumC0067a[]) f7217n.clone();
        }
    }

    static {
    }

    public static final void a(Window r8, float r10, float r11, float r12) {
        r8.setDimAmount(((r12 - r11) * l6.a.w(r10)) + r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.w("DialogAnimStyle", "updateWindowDimWithAnim: " + e.getMessage());
    }

    public static void b(View r8) {
        i.f(r8, "container");
        int r10 = android.aimedia.a.a("Resources.getSystem()", 1, 10);
        ViewGroup.LayoutParams r11 = r8.getLayoutParams();
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r11;
        if (r12.topMargin >= r10) goto L7;
        r12.topMargin = r10;
    L7:
        j r13 = j.f13877a;
        r8.setLayoutParams(r11);
    }

    public static EnumC0067a c(View r8, int r10) {
        if (r10 <= 0) goto L4;
        float r11 = r8.getHeight() / r10;
        EnumC0067a r12 = EnumC0067a.f7214a;
        if (r11 < 0.4f) goto L13;
        EnumC0067a r13 = EnumC0067a.f7215b;
        if (r11 >= 0.8f) goto L12;
        return r13;
    L12:
        return EnumC0067a.f7216m;
    L13:
        return r12;
    L4:
        return EnumC0067a.f7215b;
    }

    public static xd.d d(boolean r8, EnumC0067a r10, boolean r11) {
        Float r12 = Float.valueOf(1.0f);
        if (r8 == false) goto L5;
        int r13 = r10.ordinal();
        if (r11 == false) goto L17;
        if (r13 == 0) goto L29;
        if (r13 == 1) goto L28;
        if (r13 != 2) goto L14;
        return new xd.d(r12, Float.valueOf(247.0f));
    L14:
        throw new t();
    L28:
        return new xd.d(Float.valueOf(0.85f), Float.valueOf(247.0f));
    L29:
        return new xd.d(Float.valueOf(0.85f), Float.valueOf(439.0f));
    L17:
        if (r13 == 0) goto L26;
        if (r13 == 1) goto L31;
        if (r13 != 2) goto L23;
        return new xd.d(r12, Float.valueOf(322.0f));
    L23:
        throw new t();
    L31:
        return new xd.d(Float.valueOf(0.85f), Float.valueOf(322.0f));
    L26:
        return new xd.d(Float.valueOf(0.85f), Float.valueOf(632.0f));
    L5:
        return new xd.d(r12, Float.valueOf(480.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ub.b e(View r8, Window r10, boolean r11) {
        i.f(r8, "$this$dialogBottomHide");
        Resources r12 = Resources.getSystem();
        i.e(r12, "Resources.getSystem()");
        int r13 = r12.getDisplayMetrics().heightPixels;
        int r14 = r8.getHeight();
        Resources r15 = Resources.getSystem();
        i.e(r15, "Resources.getSystem()");
        int r16 = l6.a.I0(TypedValue.applyDimension(1, 32, r15.getDisplayMetrics())) + r14;
        xd.d r17 = d(true, c(r8, r13), false);
        float r18 = ((Number) r17.f13867a).floatValue();
        float r19 = ((Number) r17.f13868b).floatValue();
        Object r20 = r8.getTag(R.id.o_dialog_anim_out);
        if (r20 != null) goto L6;
    L8:
        r20 = null;
    L9:
        ub.b r21 = (ub.b) r20;
        if (r21 != null) goto L12;
        r21 = new ub.b(r8);
        r8.setTag(R.id.o_dialog_anim_out, r21);
    L12:
        float r22 = r16;
        r21.c(r22, new c(r18, r19));
        if (r10 == null) goto L20;
        if (r11 == false) goto L20;
        r10.addFlags(2);     // Catch: Exception -> L18
        r21.f12573f = new b(r22, r10.getAttributes().dimAmount, r10);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Log.w("DialogAnimStyle", "dialogBottomHide, can't show dim anim: " + e.getMessage());
    L20:
        ArrayList r23 = l6.a.K(r8);
        Object r24 = r8.getContext().getSystemService("input_method");
        if (r24 == null) goto L30;
        InputMethodManager r25 = (InputMethodManager) r24;
        Iterator r26 = r23.iterator();
    L24:
        if (r26.hasNext() == false) goto L28;
        EditText r27 = (EditText) r26.next();
        if (r25.isActive(r27) == false) goto L24;
        r25.hideSoftInputFromWindow(r27.getWindowToken(), 0);
        goto L24
    L28:
        return r21;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    L6:
        if ((r20 instanceof ub.b) == false) goto L8;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ub.b f(View r8, Window r10, boolean r11, float r12) {
        i.f(r8, "$this$dialogBottomShow");
        Resources r13 = Resources.getSystem();
        i.e(r13, "Resources.getSystem()");
        int r14 = r13.getDisplayMetrics().heightPixels;
        int r15 = r8.getHeight();
        Resources r16 = Resources.getSystem();
        i.e(r16, "Resources.getSystem()");
        int r17 = l6.a.I0(TypedValue.applyDimension(1, 32, r16.getDisplayMetrics())) + r15;
        r8.setAlpha(1.0f);
        xd.d r18 = d(true, c(r8, r14), true);
        float r19 = ((Number) r18.f13867a).floatValue();
        float r20 = ((Number) r18.f13868b).floatValue();
        Object r21 = r8.getTag(R.id.o_dialog_anim_in);
        if (r21 != null) goto L6;
    L8:
        r21 = null;
    L9:
        ub.b r22 = (ub.b) r21;
        if (r22 != null) goto L12;
        r22 = new ub.b(r8);
        r8.setTag(R.id.o_dialog_anim_in, r22);
    L12:
        r22.c(0.0f, new e(r19, r20, r17));
        if (r10 == null) goto L20;
        if (r11 == false) goto L20;
        r10.addFlags(2);     // Catch: Exception -> L18
        r22.f12573f = new d(r17, r10, r12);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Log.w("DialogAnimStyle", "dialogBottomShow, can't show dim anim: " + e.getMessage());
    L20:
        return r22;
    L6:
        if ((r21 instanceof ub.b) == false) goto L8;
        goto L8
    }
}
