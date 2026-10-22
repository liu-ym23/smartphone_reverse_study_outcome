package vd;

import android.net.Uri;
import com.ss.android.token.AuthTokenMultiProcessSharedProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f12842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12843b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ AuthTokenMultiProcessSharedProvider f12844m;

    public a(AuthTokenMultiProcessSharedProvider r8, String r10, String r11) {
        this.f12844m = r8;
        this.f12842a = r10;
        this.f12843b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AuthTokenMultiProcessSharedProvider r8 = this.f12844m;
        Uri r10 = AuthTokenMultiProcessSharedProvider.b(r8.getContext(), this.f12842a, this.f12843b);
        r8.getContext().getContentResolver().notifyChange(r10, null);
    }
}
