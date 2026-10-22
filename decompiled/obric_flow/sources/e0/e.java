package e0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d0.q;
import d0.r;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class e implements com.bumptech.glide.load.data.e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f16730k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f16731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f16732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f16733c;
    public final Uri d;
    public final int e;
    public final int f;
    public final z.f g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Class f16734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f16735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile com.bumptech.glide.load.data.e f16736j;

    static {
        f16730k = new String[]{"_data"};
    }

    public e(Context r5, r r10, r r11, Uri r12, int r13, int r14, z.f r15, Class r16) {
        this.f16731a = r5.getApplicationContext();
        this.f16732b = r10;
        this.f16733c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f16734h = r16;
    }

    public final com.bumptech.glide.load.data.e a() {
        boolean r5 = Environment.isExternalStorageLegacy();
        Cursor r10 = null;
        z.f r11 = this.g;
        int r12 = this.f;
        int r13 = this.e;
        Context r14 = this.f16731a;
        if (r5 == false) goto L23;
        Uri r15 = this.d;
        Cursor r16 = r14.getContentResolver().query(r15, f16730k, null, null, null);     // Catch: Throwable -> L19
        if (r16 == null) goto L18;
    L13:
        th = th;
        r10 = r16;
    L20:
        if (r10 == null) goto L22;
        r10.close();
    L22:
        throw th;
    L8:
        if (r16.moveToFirst() == false) goto L18;
        String r17 = r16.getString(r16.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r17) == true) goto L16;
        File r18 = new File(r17);     // Catch: Throwable -> L13
        r16.close();
        q r19 = this.f16732b.b(r18, r13, r12, r11);
    L27:
        if (r19 != null) goto L29;
        return null;
    L29:
        return r19.f16567c;
    L16:
        throw new FileNotFoundException("File path was empty in media store for: " + r15);     // Catch: Throwable -> L13
    L18:
        throw new FileNotFoundException("Failed to media store entry for: " + r15);     // Catch: Throwable -> L13
    L19:
        th = th;
        goto L20
    L23:
        int r20 = r14.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION");
        Uri r21 = this.d;
        if (r20 != 0) goto L26;
        r21 = MediaStore.setRequireOriginal(r21);
    L26:
        r19 = this.f16733c.b(r21, r13, r12, r11);
        goto L27
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        com.bumptech.glide.load.data.e r5 = this.f16736j;
        if (r5 == null) goto L6;
        r5.b();
        return;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class c() {
        return this.f16734h;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f16735i = true;
        com.bumptech.glide.load.data.e r5 = this.f16736j;
        if (r5 == null) goto L6;
        r5.cancel();
        return;
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource d() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(Priority r5, com.bumptech.glide.load.data.d r10) {
        com.bumptech.glide.load.data.e r11 = a();     // Catch: FileNotFoundException -> L7
        if (r11 != null) goto L9;
        r10.a(new IllegalArgumentException("Failed to build fetcher for: " + this.d));     // Catch: FileNotFoundException -> L7
        return;
    L9:
        this.f16736j = r11;     // Catch: FileNotFoundException -> L7
        if (this.f16735i == false) goto L12;
        cancel();     // Catch: FileNotFoundException -> L7
        return;
    L12:
        r11.e(r5, r10);     // Catch: FileNotFoundException -> L7
        return;
    L7:
        e = move-exception;
        r10.a(e);
    }
}
