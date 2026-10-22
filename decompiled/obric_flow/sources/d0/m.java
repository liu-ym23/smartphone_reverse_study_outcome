package d0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class m implements com.bumptech.glide.load.data.e {
    public static final String[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f16559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f16560c;

    static {
        d = new String[]{"_data"};
    }

    public /* synthetic */ m(int r5, Object r10, Object r11) {
        this.f16558a = r5;
        this.f16559b = r10;
        this.f16560c = r11;
    }

    private final void a() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        int r5 = this.f16558a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class c() {
        switch(this.f16558a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        return File.class;
    L5:
        return ((c) this.f16560c).b();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int r5 = this.f16558a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource d() {
        switch(this.f16558a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return DataSource.LOCAL;
    L7:
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(Priority r10, com.bumptech.glide.load.data.d r11) {
        switch(this.f16558a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        c r12 = (c) this.f16560c;
        byte[] r13 = (byte[]) this.f16559b;
        switch(r12.f16531a) {
            case 0: goto L7;
            default: goto L6;
        };
    L6:
        Object r14 = new ByteArrayInputStream(r13);
    L8:
        r11.f(r14);
        return;
    L7:
        r14 = ByteBuffer.wrap(r13);
        goto L8
    L10:
        Cursor r15 = ((Context) this.f16559b).getContentResolver().query((Uri) this.f16560c, d, null, null, null);
        String r5 = null;
        if (r15 == null) goto L22;
    L16:
        th = move-exception;
        r15.close();
        throw th;
    L13:
        if (r15.moveToFirst() == false) goto L18;
        r5 = r15.getString(r15.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L16
    L18:
        r15.close();
    L22:
        if (TextUtils.isEmpty(r5) == false) goto L24;
        r11.a(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.f16560c)));
        return;
    L24:
        r11.f(new File(r5));
    }
}
