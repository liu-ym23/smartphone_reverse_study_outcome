package ic;

import com.obric.oui.forms.OInputView;
import ge.r;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends he.j implements r<CharSequence, Integer, Integer, Integer, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OInputView f8305a;

    public c(OInputView r8) {
        this.f8305a = r8;
        super(4);
    }

    @Override // ge.r
    public final xd.j d(CharSequence r8, Integer r10, Integer r11, Integer r12) {
        CharSequence r13 = r8;
        r10.intValue();
        r11.intValue();
        r12.intValue();
        OInputView r14 = this.f8305a;
        if (r14.K <= 0) goto L23;
        boolean r15 = false;
        if (r13 == null) goto L7;
        int r16 = r13.length();
    L9:
        if (r16 <= r14.K) goto L11;
        boolean r17 = true;
    L12:
        r14.setErrorState(r17);
        if (r13 == null) goto L15;
        String r18 = r13.toString();
    L16:
        r14.D(r18);
        bc.a.d(r14.f6301k0, r14.P);
        if (r14.W == true) goto L19;
    L21:
        bc.a.d(r14.f6302l0, r15);
        goto L23
    L19:
        if (r14.P == true) goto L21;
        r15 = true;
        goto L21
    L15:
        r18 = null;
        goto L16
    L11:
        r17 = false;
        goto L12
    L7:
        r16 = 0;
    L23:
        return xd.j.f13877a;
    }
}
