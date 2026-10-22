package j0;

import android.view.View;
import com.obric.oui.progress.ODownloadProgressView;

/* JADX INFO: loaded from: classes.dex */
public final class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ge.l<View, xd.j> f8378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f8379b;

    public d0(View r8, ODownloadProgressView.a r10) {
        this.f8378a = r10;
        this.f8379b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8378a.invoke(this.f8379b);
    }
}
