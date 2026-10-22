package d0;

import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class c implements z.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16531a;

    public /* synthetic */ c(int r5) {
        this.f16531a = r5;
    }

    public static ByteArrayInputStream a(String r5) {
        if (r5.startsWith("data:image") == false) goto L15;
        int r10 = r5.indexOf(44);
        if (r10 == (-1)) goto L13;
        if (r5.substring(0, r10).endsWith(";base64") == false) goto L11;
        return new ByteArrayInputStream(Base64.decode(r5.substring(r10 + 1), 0));
    L11:
        throw new IllegalArgumentException("Not a base64 image data URL.");
    L13:
        throw new IllegalArgumentException("Missing comma in data URL.");
    L15:
        throw new IllegalArgumentException("Not a valid image data URL.");
    }

    public Class b() {
        switch(this.f16531a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L4;
            case 3: goto L4;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        return InputStream.class;
    L6:
        return ParcelFileDescriptor.class;
    L8:
        return InputStream.class;
    L10:
        return ByteBuffer.class;
    }

    @Override // z.a
    public boolean g(Object r5, File r10, z.f r11) {
        q0.b.b((ByteBuffer) r5, r10);     // Catch: IOException -> L5
        return true;
    L5:
        e = move-exception;
        if (Log.isLoggable("ByteBufferEncoder", 3) == false) goto L9;
        Log.d("ByteBufferEncoder", "Failed to write data", e);
    L9:
        return false;
    }
}
