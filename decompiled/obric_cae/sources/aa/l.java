package aa;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class l extends m.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Matrix f223d;

    public l(ArrayList r8, Matrix r10) {
        this.f222c = r8;
        this.f223d = r10;
    }

    @Override // aa.m.f
    public final void a(Matrix r8, z9.a r10, int r11, Canvas r12) {
        Iterator r13 = this.f222c.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ((m.f) r13.next()).a(this.f223d, r10, r11, r12);
        goto L4
    }
}
