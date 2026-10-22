package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class f implements f0.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f1958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k.a f1960c;

    public f(View r8, ViewGroup r10, k.a r11) {
        this.f1958a = r8;
        this.f1959b = r10;
        this.f1960c = r11;
    }

    @Override // f0.d.a
    public final void onCancel() {
        View r8 = this.f1958a;
        r8.clearAnimation();
        this.f1959b.endViewTransition(r8);
        this.f1960c.a();
    }
}
