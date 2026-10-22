package ic;

import android.view.MotionEvent;
import com.obric.oui.forms.OInputView;
import ge.l;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends he.j implements l<MotionEvent, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OInputView f8304a;

    public b(OInputView r8) {
        this.f8304a = r8;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(MotionEvent r8) {
        MotionEvent r10 = r8;
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.getActionMasked());
    L6:
        OInputView r12 = this.f8304a;
        if (r11 != null) goto L10;
    L12:
        if (r11 != null) goto L15;
    L17:
        if (r11 != null) goto L20;
    L23:
        return xd.j.f13877a;
    L20:
        if (r11.intValue() != 1) goto L23;
    L21:
        int r13 = OInputView.f6291v0;
        r12.y(false);
        goto L23
    L15:
        if (r11.intValue() != 3) goto L17;
    L10:
        if (r11.intValue() != 0) goto L12;
        int r14 = OInputView.f6291v0;
        r12.y(true);
        goto L23
    L5:
        r11 = null;
        goto L6
    }
}
