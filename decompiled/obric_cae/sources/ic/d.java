package ic;

import android.text.Editable;
import com.obric.oui.forms.OInputView;
import ge.l;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends he.j implements l<Editable, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OInputView f8306a;

    public d(OInputView r8) {
        this.f8306a = r8;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(Editable r8) {
        Editable r10 = r8;
        OInputView r11 = this.f8306a;
        r11.getClass();
        if (r11.K <= 0) goto L18;
        boolean r12 = false;
        if (r10 == null) goto L7;
        int r13 = r10.length();
    L9:
        if (r13 <= r11.K) goto L11;
        boolean r14 = true;
    L12:
        r11.setErrorState(r14);
        bc.a.d(r11.f6301k0, r11.P);
        if (r11.W == true) goto L15;
    L17:
        bc.a.d(r11.f6302l0, r12);
        goto L18
    L15:
        if (r11.P == true) goto L17;
        r12 = true;
        goto L17
    L11:
        r14 = false;
        goto L12
    L7:
        r13 = 0;
    L18:
        r11.A();
        r11.B();
        return xd.j.f13877a;
    }
}
