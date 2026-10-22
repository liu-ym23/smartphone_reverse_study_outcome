package ic;

import android.text.Editable;
import android.view.View;
import com.obric.cae.R;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputView;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OInputView f8308a;

    public f(OInputView r8) {
        this.f8308a = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        OInputView r10 = this.f8308a;
        if (OInputView.s(r10) != r10.getVInput().getInputType()) goto L5;
        OInputView.t(r10).setImageResource(R.drawable.o_input_view_eyes_open);
        OEditText r11 = r10.getVInput();
        int r12 = r10.getVInput().getInputType() | 144;
    L6:
        r11.setInputType(r12);
        if (r10.getVInput().hasFocus() == false) goto L14;
        OEditText r13 = r10.getVInput();
        Editable r14 = r10.getVInput().getText();
        if (r14 == null) goto L11;
        int r15 = r14.length();
    L12:
        r13.setSelection(r15);
        return;
    L11:
        r15 = 0;
        goto L12
    L14:
        return;
    L5:
        OInputView.t(r10).setImageResource(R.drawable.o_input_view_eyes_close);
        r11 = r10.getVInput();
        r12 = OInputView.s(r10);
        goto L6
    }
}
