package kc;

import com.obric.oui.indexscrollbar.LettersBar;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LettersBar f9104a;

    public b(LettersBar r8) {
        this.f9104a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LettersBar r8 = this.f9104a;
        if (r8.A.b() == false) goto L6;
        r8.A.a();
        LettersBar.a(r8, -1);
        r8.setShowBg(false);
        return;
    }
}
