package l;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class l extends d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PointF f19497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f f19498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f19499k;

    public l(f r5, f r10) {
        super(Collections.emptyList());
        this.f19497i = new PointF();
        this.f19498j = r5;
        this.f19499k = r10;
        i(this.d);
    }

    @Override // l.d
    public final Object f() {
        return this.f19497i;
    }

    @Override // l.d
    public final Object g(v.a r5, float r10) {
        return this.f19497i;
    }

    @Override // l.d
    public final void i(float r5) {
        f r10 = this.f19498j;
        r10.i(r5);
        f r11 = this.f19499k;
        r11.i(r5);
        float r12 = ((Float) r10.f()).floatValue();
        float r13 = ((Float) r11.f()).floatValue();
        this.f19497i.set(r12, r13);
        int r14 = 0;
    L3:
        ArrayList r15 = this.f19482a;
        if (r14 >= r15.size()) goto L6;
        ((a) r15.get(r14)).a();
        r14 = r14 + 1;
        goto L3
    }
}
