package ao0;

import com.bytedance.android.livesdkapi.ILiveResponseExtraInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements ILiveResponseExtraInfo {
    public final /* synthetic */ e a;
    public final /* synthetic */ Throwable b;

    public final long getServerTimestamp() {
        return -1;
    }

    public final ILiveResponseExtraInfo.IStatusInfo getStatusInfo() {
        e r0 = this.a;
        int r1 = this.b.getErrorCode();
        String r2 = this.b.getMessage();
        r0.getClass();
        return new a(r1, r2, "");
    }

    public c(e r1, Throwable r2) {
        this.a = r1;
        this.b = r2;
    }
}
