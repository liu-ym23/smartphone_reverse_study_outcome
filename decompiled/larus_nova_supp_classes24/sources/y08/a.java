package y08;

import android.view.ViewTreeObserver;
import com.larksuite.component.universe_design.notice.UDNotice;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ UDNotice a;

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.larksuite.component.universe_design.notice.UDNotice] */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ?? r0 = this.a;
        r0.w = false;
        r0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (this.a.a.d.getLineCount() != 1) goto L5;
        UDNotice r1 = this.a;
        UDNotice.R5(r1, r1.a.f, r1.r);
        UDNotice r2 = this.a;
        UDNotice.R5(r2, r2.a.e, false);
        return;
    L5:
        UDNotice r3 = this.a;
        UDNotice.R5(r3, r3.a.f, false);
        UDNotice r4 = this.a;
        UDNotice.R5(r4, r4.a.e, r4.r);
    }

    public a(UDNotice r1) {
        this.a = r1;
    }
}
