package androidx.activity;

import android.os.Bundle;
import androidx.lifecycle.a0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements androidx.savedstate.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f479b;

    public /* synthetic */ f(Object r8, int r10) {
        this.f478a = r10;
        this.f479b = r8;
    }

    @Override // androidx.savedstate.a.b
    public final Bundle a() {
        int r8 = this.f478a;
        Object r10 = this.f479b;
        switch(r8) {
            case 0: goto L6;
            default: goto L8;
        };
    L6:
        return ComponentActivity.a((ComponentActivity) r10);
    L8:
        return a0.a((a0) r10);
    }
}
