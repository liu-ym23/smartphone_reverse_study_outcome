package d0;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class a0 implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f16525b;

    public /* synthetic */ a0(Resources r5, int r10) {
        this.f16524a = r10;
        this.f16525b = r5;
    }

    @Override // d0.s
    public final r a(z r5) {
        switch(this.f16524a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        d0 r10 = d0.f16536b;
        return new b(this.f16525b, r10);
    L6:
        r r11 = r5.b(Uri.class, InputStream.class);
        return new b(this.f16525b, r11);
    L8:
        r r12 = r5.b(Uri.class, ParcelFileDescriptor.class);
        return new b(this.f16525b, r12);
    L10:
        r r13 = r5.b(Uri.class, AssetFileDescriptor.class);
        return new b(this.f16525b, r13);
    }
}
