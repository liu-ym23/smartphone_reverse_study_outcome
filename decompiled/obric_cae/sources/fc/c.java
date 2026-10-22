package fc;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.obric.cae.R;
import he.i;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f7373a;

    public c(a r8) {
        this.f7373a = r8;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r14, WindowInsets r15) {
        i.f(r14, "v");
        i.f(r15, "insets");
        a r13 = this.f7373a;
        int r8 = ad.a.b(r13.getContext());
        int r10 = ad.a.a(r13.f());
        String r11 = r13.f7358a;
        zc.b.g(r11, "onApplyWindowInsets, naviHeight: " + r8 + ", imeInsets: " + r10);
        Context r12 = r13.getContext();
        i.e(r12, "context");
        if (r10 >= l6.a.Q(r12)) goto L41;
        boolean r16 = r13.f7367t;
        boolean r17 = true;
        Integer r18 = null;
        if (r10 <= 0) goto L16;
        if (r16 == false) goto L8;
        r14.setPadding(0, 0, 0, r10);
        StringBuilder r19 = new StringBuilder("onApplyWindowInsets, update rootView.padding, bottomPadding: ");
        r19.append(r10);
    L27:
        zc.b.g(r11, r19.toString());
        r17 = false;
    L28:
        if (r17 == false) goto L41;
        Object r110 = r13.f().getParent();
        if (r110 != null) goto L33;
    L35:
        r110 = null;
    L36:
        View r111 = (View) r110;
        StringBuilder r20 = new StringBuilder("onApplyWindowInsets, post recheck, parentView.height: ");
        if (r111 == null) goto L39;
        r18 = Integer.valueOf(r111.getHeight());
    L39:
        r20.append(r18);
        r20.append(", rootView.height: ");
        r20.append(r13.f().getHeight());
        zc.b.g(r11, r20.toString());
        b r112 = r13.f7366s;
        r112.removeMessages(101);
        r112.sendEmptyMessageDelayed(101, 200);
        goto L41
    L33:
        if ((r110 instanceof View) == false) goto L35;
    L8:
        View r113 = r13.f();
        ViewGroup.LayoutParams r21 = r13.f().getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == true) goto L11;
        ViewGroup.LayoutParams r22 = null;
    L12:
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
        if (r23 == null) goto L15;
        Context r24 = r13.getContext();
        i.e(r24, "context");
        r23.bottomMargin = r24.getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin) + r10;
    L15:
        j r25 = j.f13877a;
        r113.setLayoutParams(r21);
        r19 = new StringBuilder("onApplyWindowInsets, update rootView.layoutParams, bottomMargin: ");
        Resources r26 = Resources.getSystem();
        i.e(r26, "Resources.getSystem()");
        r8 = l6.a.I0(TypedValue.applyDimension(1, 16, r26.getDisplayMetrics())) + r10;
    L26:
        r19.append(r8);
        goto L27
    L11:
        r22 = r21;
        goto L12
    L16:
        if (r16 == false) goto L18;
        Resources r27 = Resources.getSystem();
        i.e(r27, "Resources.getSystem()");
        int r28 = r8 - l6.a.I0(TypedValue.applyDimension(1, 16, r27.getDisplayMetrics()));
        r13.f().setPadding(0, 0, 0, r28);
        zc.b.g(r11, "onApplyWindowInsets, update rootView.padding, bottomPadding: " + r28);
        goto L28
    L18:
        View r114 = r13.f();
        ViewGroup.LayoutParams r29 = r13.f().getLayoutParams();
        if ((r29 instanceof ViewGroup.MarginLayoutParams) == true) goto L21;
        ViewGroup.LayoutParams r30 = null;
    L22:
        ViewGroup.MarginLayoutParams r31 = (ViewGroup.MarginLayoutParams) r30;
        if (r31 == null) goto L25;
        Context r32 = r13.getContext();
        i.e(r32, "context");
        r31.bottomMargin = r32.getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin);
    L25:
        j r33 = j.f13877a;
        r114.setLayoutParams(r29);
        r19 = new StringBuilder("onApplyWindowInsets, update rootView.layoutParams, bottomMargin: ");
        goto L26
    L21:
        r30 = r29;
    L41:
        return r15.consumeSystemWindowInsets();
    }
}
