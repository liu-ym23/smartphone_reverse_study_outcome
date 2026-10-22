package m;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.zte.aimodel.IVendorAIModelService;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f19881a;

    public j(m r5) {
        this.f19881a = r5;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r5, IBinder r10) {
        Log.d(m.g, "onServiceConnected.");
        IVendorAIModelService r11 = IVendorAIModelService.Stub.asInterface(r10);
        m r12 = this.f19881a;
        r12.f19889b = r11;
        r12.f19888a.post(r12.d);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r5) {
        Log.d(m.g, "onServiceDisconnected.");
        this.f19881a.f19889b = null;
    }
}
