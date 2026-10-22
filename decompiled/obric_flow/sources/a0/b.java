package a0;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.j;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f37a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Comparable f38b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f39c;
    public Object d;

    public /* synthetic */ b(int r5, Comparable r10, Object r11) {
        this.f37a = r5;
        this.f38b = r10;
        this.f39c = r11;
    }

    private final void a() {
    }

    private final void f() {
    }

    private final void g() {
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        switch(this.f37a) {
            case 0: goto L13;
            case 1: goto L20;
            default: goto L4;
        };
    L4:
        Object r5 = this.d;
        if (r5 == null) goto L27;
        switch(((d0.c) this.f39c).f16531a) {
            case 4: goto L9;
            default: goto L8;
        };     // Catch: IOException -> L17
    L8:
        ((InputStream) r5).close();     // Catch: IOException -> L17
    L24:
        return;
    L9:
        ((ParcelFileDescriptor) r5).close();     // Catch: IOException -> L17
    L28:
        return;
    L27:
        return;
    L13:
        InputStream r10 = (InputStream) this.d;
        if (r10 == null) goto L30;
        r10.close();     // Catch: IOException -> L18
        return;
    L31:
        return;
    L30:
        return;
    L20:
        ((ByteArrayInputStream) this.d).close();     // Catch: IOException -> L19
        return;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class c() {
        switch(this.f37a) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        ((d0.c) this.f39c).getClass();
        return InputStream.class;
    L8:
        return InputStream.class;
    L5:
        return ((d0.c) this.f39c).b();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int r5 = this.f37a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final DataSource d() {
        switch(this.f37a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return DataSource.LOCAL;
    L7:
        return DataSource.LOCAL;
    L9:
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(Priority r5, com.bumptech.glide.load.data.d r10) {
        switch(this.f37a) {
            case 0: goto L31;
            case 1: goto L29;
            default: goto L33;
        };
    L29:
        ByteArrayInputStream r11 = d0.c.a((String) this.f38b);     // Catch: IllegalArgumentException -> L18
        this.d = r11;     // Catch: IllegalArgumentException -> L18
        r10.f(r11);     // Catch: IllegalArgumentException -> L18
        return;
    L18:
        e = move-exception;
        r10.a(e);
        return;
    L31:
        InputStream r12 = h();     // Catch: FileNotFoundException -> L23
        this.d = r12;     // Catch: FileNotFoundException -> L23
        r10.f(r12);
        return;
    L23:
        e = move-exception;
        if (Log.isLoggable("MediaStoreThumbFetcher", 3) == false) goto L27;
        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
    L27:
        r10.a(e);
        return;
    L33:
        d0.c r13 = (d0.c) this.f39c;     // Catch: FileNotFoundException -> L10
        File r14 = (File) this.f38b;     // Catch: FileNotFoundException -> L10
        switch(r13.f16531a) {
            case 4: goto L7;
            default: goto L6;
        };     // Catch: FileNotFoundException -> L10
    L6:
        Object r15 = new FileInputStream(r14);     // Catch: FileNotFoundException -> L10
    L8:
        this.d = r15;     // Catch: FileNotFoundException -> L10
        r10.f(r15);
        return;
    L7:
        r15 = ParcelFileDescriptor.open(r14, 268435456);     // Catch: FileNotFoundException -> L10
    L10:
        e = move-exception;
        if (Log.isLoggable("FileLoader", 3) == false) goto L14;
        Log.d("FileLoader", "Failed to open file", e);
    L14:
        r10.a(e);
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0026: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:10:0x0026 */
    public InputStream h() {
        Uri r5 = (Uri) this.f38b;
        d r11 = (d) this.f39c;
        Cursor r10 = null;
        InputStream r12 = null;
        r12 = null;
        Cursor r13 = r11.f40a.a(r5);     // Catch: Throwable -> L16 SecurityException -> L18
        if (r13 != null) goto L76;
    L13:
        if (r13 == null) goto L15;
    L14:
        r13.close();
    L15:
        String r14 = null;
    L25:
        boolean r15 = TextUtils.isEmpty(r14);
        ContentResolver r16 = r11.f42c;
        if (r15 == false) goto L28;
    L27:
        InputStream r17 = null;
    L39:
        if (r17 != null) goto L67;
    L57:
        int r18 = -1;
    L58:
        if (r18 != (-1)) goto L60;
        return r17;
    L60:
        return new j(r17, r18);
    L67:
        r12 = r16.openInputStream(r5);     // Catch: Throwable -> L45 Throwable -> L47
        r18 = f4.b.i(r11.f41b, r12, r11.d);     // Catch: Throwable -> L45 Throwable -> L47
        if (r12 == null) goto L58;
        r12.close();     // Catch: IOException -> L64
        goto L58
    L45:
        th = move-exception;
        if (r12 != null) goto L74;
    L56:
        throw th;
    L74:
        r12.close();     // Catch: IOException -> L65
    L47:
        e = move-exception;
        if (Log.isLoggable("ThumbStreamOpener", 3) == false) goto L51;
        Log.d("ThumbStreamOpener", "Failed to open uri: " + r5, e);     // Catch: Throwable -> L45
    L51:
        if (r12 == null) goto L57;
        r12.close();     // Catch: IOException -> L66
        goto L57
    L28:
        File r19 = new File(r14);
        if (r19.exists() == false) goto L27;
        if (0 >= r19.length()) goto L27;
        Uri r20 = Uri.fromFile(r19);
        r17 = r16.openInputStream(r20);     // Catch: NullPointerException -> L35
    L35:
        e = move-exception;
        throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + r5 + " -> " + r20).initCause(e));
    L76:
    L11:
        e = e;
    L21:
        if (Log.isLoggable("ThumbStreamOpener", 3) == false) goto L23;
        Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + r5, e);     // Catch: Throwable -> L9
    L23:
        if (r13 == null) goto L15;
    L6:
        if (r13.moveToFirst() == false) goto L13;
        r14 = r13.getString(0);     // Catch: Throwable -> L9 SecurityException -> L11
        r13.close();
        goto L25
    L9:
        th = th;
        r10 = r5;
    L61:
        if (r10 == null) goto L63;
        r10.close();
    L63:
        throw th;
    L18:
        e = e;
        r13 = null;
    L16:
        th = th;
        goto L61
    }
}
