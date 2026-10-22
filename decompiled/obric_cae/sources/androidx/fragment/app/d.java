package androidx.fragment.app;

import android.animation.Animator;

/* JADX INFO: loaded from: classes.dex */
public final class d implements f0.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animator f1947a;

    public d(Animator r8) {
        this.f1947a = r8;
    }

    @Override // f0.d.a
    public final void onCancel() {
        this.f1947a.end();
    }
}
