package ic;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.obric.oui.forms.OInputView;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OInputView f8309a;

    public g(OInputView r8) {
        this.f8309a = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        OInputView r10 = this.f8309a;
        r10.getVInput().requestFocus();
        if (r10.getVInput().hasFocus() == true) goto L5;
    L7:
        Object r11 = r10.getContext().getSystemService("input_method");
        if ((r11 instanceof InputMethodManager) == true) goto L10;
        r11 = null;
    L10:
        InputMethodManager r12 = (InputMethodManager) r11;
        if (r12 == null) goto L14;
        r12.showSoftInput(r10.f6294c0, 0);
        return;
    L14:
        return;
    L5:
        if (r10.getVInput().isCursorVisible() == true) goto L7;
        r10.getVInput().setCursorVisible(true);
        goto L7
    }
}
