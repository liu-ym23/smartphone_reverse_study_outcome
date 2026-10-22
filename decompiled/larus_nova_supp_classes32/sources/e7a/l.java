package e7a;

import android.view.Choreographer;
import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.behavior.ui.list.UIList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l implements Choreographer.FrameCallback {
    public final /* synthetic */ UIList a;

    public l(UIList r1) {
        this.a = r1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r3) {
        UIList r4 = this.a;
        boolean r0 = true;
        if (r4.H > 0) goto L5;
    L6:
        UIList r5 = this.a;
        if (r5.H < 0) goto L9;
    L11:
        r0 = false;
    L12:
        if (r0 == false) goto L17;
        UIList r6 = this.a;
        if (r6.x == false) goto L16;
        ((RecyclerView) r6.getView()).scrollBy(0, this.a.H);
        goto L17
    L16:
        ((RecyclerView) r6.getView()).scrollBy(this.a.H, 0);
    L17:
        UIList r7 = this.a;
        if (r7.G == false) goto L25;
        if (r0 == true) goto L23;
        if (r7.I == true) goto L25;
    L23:
        if (r7.k0 == null) goto L27;
        Choreographer.getInstance().postFrameCallback(this.a.k0);
        return;
    L27:
        return;
    L25:
        r7.Z();
        return;
    L9:
        if (r5.R(-1) == false) goto L11;
    L5:
        if (r4.R(1) == true) goto L12;
        goto L6
    }
}
