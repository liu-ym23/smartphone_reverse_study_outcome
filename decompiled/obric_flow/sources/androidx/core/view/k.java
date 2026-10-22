package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f500b;

    public /* synthetic */ k(ViewConfiguration r5, int r10) {
        this.f499a = r10;
        this.f500b = r5;
    }

    @Override // androidx.core.util.Supplier
    public final Object get() {
        int r5 = this.f499a;
        ViewConfiguration r10 = this.f500b;
        switch(r5) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return Integer.valueOf(r10.getScaledMinimumFlingVelocity());
    L7:
        return Integer.valueOf(r10.getScaledMaximumFlingVelocity());
    }
}
