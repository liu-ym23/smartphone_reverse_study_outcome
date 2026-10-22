package fi;

import ai.j0;
import android.text.TextUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f16911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16912c;

    public g(String r5, byte[] r10, String... r11) {
        if (r11.length <= 0) goto L5;
        String r12 = r11[0];
    L6:
        if (r5 == null) goto L8;
    L11:
        if (r10 == null) goto L15;
        this.f16910a = r5;
        this.f16911b = r10;
        this.f16912c = r12;
        return;
    L15:
        throw new NullPointerException("bytes");
    L8:
        if (TextUtils.isEmpty(r12) == false) goto L10;
        r5 = "application/unknown";
        goto L11
    L10:
        r5 = "application/octet-stream";
        goto L11
    L5:
        r12 = null;
        goto L6
    }

    @Override // fi.j
    public final String a() {
        return this.f16910a;
    }

    @Override // fi.j
    public final String b() {
        String r5 = this.f16912c;
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        return r5;
    }

    @Override // fi.i
    public final InputStream c() {
        return new ByteArrayInputStream(this.f16911b);
    }

    @Override // fi.j
    public final String d() {
        byte[] r5 = this.f16911b;
        if (r5 != null) goto L7;
        return null;
    L7:
        return b.b(r5);
    }

    @Override // fi.a
    public final boolean e() {
        byte[] r5 = this.f16911b;
        if (r5 != null) goto L5;
    L12:
        return false;
    L5:
        if (r5.length > 102400) goto L12;
        byte[] r10 = EncryptorUtil.a(r5.length, r5);
        if (r10 != null) goto L10;
        return false;
    L10:
        this.f16911b = r10;
        return true;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        g r10 = (g) r5;
        if (Arrays.equals(this.f16911b, r10.f16911b) == true) goto L14;
        return false;
    L14:
        if (this.f16910a.equals(r10.f16910a) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f16910a.hashCode() * 31;
        return Arrays.hashCode(this.f16911b) + r5;
    }

    @Override // fi.j
    public final long length() {
        return this.f16911b.length;
    }

    public String toString() {
        return j0.o(new StringBuilder("TypedByteArray[length="), this.f16911b.length, "]");
    }

    @Override // fi.j
    public final void writeTo(OutputStream r5) {
        r5.write(this.f16911b);
    }
}
