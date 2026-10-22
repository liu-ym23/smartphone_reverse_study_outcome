package d0;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class c0 implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f16532b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16533a;

    static {
        f16532b = new c0(0);
    }

    public /* synthetic */ c0(int r5) {
        this.f16533a = r5;
    }

    @Override // d0.s
    public final r a(z r5) {
        switch(this.f16533a) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        return new g0(r5.b(g.class, InputStream.class));
    L7:
        return new b0(r5.b(Uri.class, InputStream.class), 0);
    L9:
        return new b0(r5.b(Uri.class, ParcelFileDescriptor.class), 0);
    L11:
        return new b0(r5.b(Uri.class, AssetFileDescriptor.class), 0);
    L13:
        return new d0(1);
    L15:
        return new d(new c(1), 0);
    L17:
        return new d(new c(0), 0);
    L19:
        return d0.f16536b;
    }
}
