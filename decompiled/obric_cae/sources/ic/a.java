package ic;

import android.view.inputmethod.InputMethodManager;
import com.obric.oui.forms.OInputView;
import ge.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends he.j implements l<Boolean, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OInputView f8303a;

    public a(OInputView r8) {
        this.f8303a = r8;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(Boolean r8) {
        boolean r10 = r8.booleanValue();
        Object r11 = null;
        OInputView r12 = this.f8303a;
        if (r10 == false) goto L12;
        int r13 = OInputView.f6291v0;
        Object r14 = r12.getContext().getSystemService("input_method");
        if ((r14 instanceof InputMethodManager) == false) goto L8;
        r11 = r14;
    L8:
        InputMethodManager r15 = (InputMethodManager) r11;
        if (r15 == null) goto L20;
        r15.showSoftInput(r12.f6294c0, 0);
    L20:
        int r16 = OInputView.f6291v0;
        r12.A();
        r12.B();
        r12.z(r10);
        r12.y(false);
        OInputView.u(r12, r10);
        return xd.j.f13877a;
    L12:
        if (r12.getAutoHideSoftInputWhenLoseFocus() == false) goto L20;
        Object r17 = r12.getContext().getSystemService("input_method");
        if ((r17 instanceof InputMethodManager) == false) goto L17;
        r11 = r17;
    L17:
        InputMethodManager r18 = (InputMethodManager) r11;
        if (r18 == null) goto L20;
        r18.hideSoftInputFromWindow(r12.f6294c0.getWindowToken(), 0);
        goto L20
    }
}
