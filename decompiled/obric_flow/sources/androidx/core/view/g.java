package androidx.core.view;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f494b;

    public /* synthetic */ g(Object r5, int r10) {
        this.f493a = r10;
        this.f494b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = this.f493a;
        Object r10 = this.f494b;
        switch(r5) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ViewKt.a((Function0) r10);
        return;
    L6:
        SoftwareKeyboardControllerCompat.Impl20.a((View) r10);
    }
}
