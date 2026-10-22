package w5;

import android.net.Uri;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f12982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f12983b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ WsChannelMultiProcessSharedProvider f12984m;

    public b(WsChannelMultiProcessSharedProvider r8, String r10, String r11) {
        this.f12984m = r8;
        this.f12982a = r10;
        this.f12983b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WsChannelMultiProcessSharedProvider r8 = this.f12984m;
        Uri r10 = WsChannelMultiProcessSharedProvider.a(r8.getContext(), this.f12982a, this.f12983b);
        r8.getContext().getContentResolver().notifyChange(r10, null);
    }
}
