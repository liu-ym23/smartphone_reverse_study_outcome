package f18;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import e18.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements b {
    public final /* synthetic */ WheelView a;

    @Override // e18.b
    public final void a() {
        if (this.a.getCurrentItem() != 0) goto L5;
        int r0 = 1;
    L6:
        this.a.setCurrentItem(r0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public a(WheelView r1) {
        this.a = r1;
    }
}
