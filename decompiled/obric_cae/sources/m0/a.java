package m0;

import com.obric.cae.libs.softap.CaeSoftApManager;
import com.obric.cae.libs.softap.CaeSoftApRequestCallback;
import com.obric.cae.userAware.datacollection.NetworkClient;
import com.obric.cae.userAware.datacollection.UploadWorker;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements CaeSoftApManager.d, NetworkClient.UploadProgressListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f9245a;

    public /* synthetic */ a(Object r8) {
        this.f9245a = r8;
    }

    @Override // com.obric.cae.libs.softap.CaeSoftApManager.d
    public final void onError(int r8, String r10) {
        CaeSoftApManager.c.a((CaeSoftApRequestCallback) this.f9245a, r8, r10);
    }

    @Override // com.obric.cae.userAware.datacollection.NetworkClient.UploadProgressListener
    public final void onProgress(String r8, long r10, long r11) {
        UploadWorker.a((UploadWorker) this.f9245a, r8, r10, r11);
    }
}
