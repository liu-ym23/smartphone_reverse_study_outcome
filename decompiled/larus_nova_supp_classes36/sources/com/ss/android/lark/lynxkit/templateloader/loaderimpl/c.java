package com.ss.android.lark.lynxkit.templateloader.loaderimpl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements uqb.b {
    public final d a;
    public final Context b;

    public static final class a {
    }

    public static final class b {
        public final byte[] a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.a) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ReadResult(bytes=" + Arrays.toString(this.a) + ", path=" + this.b + ')';
        }

        public b(byte[] r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "bytes");
            Intrinsics.checkNotNullParameter(r3, "path");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.lynxkit.templateloader.loaderimpl.c$c, reason: collision with other inner class name */
    public static final class RunnableC0173c implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ String b;
        public final /* synthetic */ uqb.a c;

        public RunnableC0173c(c r1, String r2, uqb.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            uqb.c r2 = c.b(this.a, this.b);     // Catch: Throwable -> L5
            Log.i("BuiltInZstdTemplateLoader", "load built-in zstd template success, channel:" + this.a.a.b);     // Catch: Throwable -> L5
            this.c.a(r2);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Log.e("BuiltInZstdTemplateLoader", "load built-in zstd template failed, channel:" + this.a.a.b, th);
            this.c.onFailed(th);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public c(Context r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = r3;
        Context r4 = r2.getApplicationContext();
        if (r4 == null) goto L6;
        r2 = r4;
    L6:
        this.b = r2;
    }

    public static final uqb.c b(c r14, String r15) {
        d r0 = r14.a;
        if (r0.c == false) goto L127;
        if (StringsKt.isBlank(r0.a) == true) goto L125;
        if (StringsKt.isBlank(r14.a.b) == true) goto L125;
        d r1 = r14.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r15, "templatePath");
        String r2 = r1.d;
        boolean r3 = false;
        if (r2 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == true) goto L17;
        r15 = r1.d;
    L30:
        String r16 = StringsKt.trim(r15).toString();
        if (StringsKt.contains$default(r16, '\\', false, 2, null) == true) goto L123;
        if (d.g.containsMatchIn(r16) == true) goto L121;
        String r5 = StringsKt.trim(r16, new char[]{'/'});
        if (StringsKt.isBlank(r5) == true) goto L59;
        List r6 = StringsKt.split$default(r5, new char[]{'/'}, false, 0, 6, null);
        if ((r6 instanceof Collection) == true) goto L40;
    L42:
        Iterator r17 = r6.iterator();
    L44:
        if (r17.hasNext() == false) goto L56;
        String r7 = (String) r17.next();
        if (StringsKt.isBlank(r7) == false) goto L48;
    L53:
        boolean r8 = true;
    L54:
        if (r8 == false) goto L44;
        r3 = true;
        goto L56
    L48:
        if (Intrinsics.areEqual(r7, ".") == true) goto L53;
        if (Intrinsics.areEqual(r7, "..") == true) goto L53;
        r8 = false;
    L56:
        if (r3 == true) goto L119;
        r5 = CollectionsKt.joinToString$default(r6, "/", null, null, 0, null, null, 62, null);
        goto L59
    L119:
        throw new IllegalArgumentException("built-in zstd bundle path contains invalid segment");
    L40:
        if (r6.isEmpty() == false) goto L42;
    L59:
        if (StringsKt.isBlank(r5) == true) goto L117;
        d r18 = r14.a;
        com.ss.android.lark.lynxkit.templateloader.loaderimpl.b r19 = r18.f.a(r14.b, r18.a, r18.b, r5);
        String r9 = r19.a;
        if (r9 != null) goto L67;
        String r110 = r19.c;
        if (r110 != null) goto L66;
        r110 = "built-in zstd bundle not found, channel:" + r14.a.b + ", bundle:" + r5;
    L66:
        throw new FileNotFoundException(r110);
    L67:
        Uri r111 = UriProtector.parse(r9);
        String r10 = r111.getScheme();
        if (r10 == null) goto L115;
        int r11 = r10.hashCode();
        if (r11 == (-1408207997)) goto L97;
        if (r11 == 3143036) goto L79;
        if (r11 != 93121264) goto L115;
        if (r10.equals("asset") == false) goto L115;
    L98:
        Intrinsics.checkNotNull(r111);
        String r112 = r111.getPath();
        if (r112 == null) goto L113;
        String r113 = StringsKt.removePrefix(r112, File.separator);
        if (r113 == null) goto L113;
        InputStream r114 = r14.b.getAssets().open(r113);
        Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L107
        b r115 = new b(ByteStreamsKt.readBytes(r114), r9);     // Catch: Throwable -> L107
        CloseableKt.closeFinally(r114, null);
        b r12 = r115;
    L106:
        return new uqb.c(r12.a, r12.b, c.class.getSimpleName());
    L107:
        th = move-exception;
        throw th;     // Catch: Throwable -> L109
    L109:
        th = move-exception;
        CloseableKt.closeFinally(r114, th);
        throw th;
    L113:
        throw new FileNotFoundException("asset uri path is empty:".concat(r9));
    L79:
        if (r10.equals("file") == false) goto L115;
        Intrinsics.checkNotNull(r111);
        String r116 = r111.getPath();
        if (r116 == null) goto L95;
        PolarisFileWrapper r117 = new PolarisFileWrapper(r116);
        if (r117.exists() == false) goto L93;
        PolarisFileInputStreamWrapper r118 = new PolarisFileInputStreamWrapper(r117);
        r12 = new b(ByteStreamsKt.readBytes(r118), r117.getAbsolutePath());     // Catch: Throwable -> L87
        CloseableKt.closeFinally(r118, null);
    L87:
        th = move-exception;
        throw th;     // Catch: Throwable -> L89
    L89:
        th = move-exception;
        CloseableKt.closeFinally(r118, th);
        throw th;
    L93:
        throw new FileNotFoundException("file uri does not exist:".concat(r9));
    L95:
        throw new FileNotFoundException("file uri path is empty:".concat(r9));
    L97:
        if (r10.equals("assets") == true) goto L98;
    L115:
        throw new IllegalArgumentException("unsupported built-in zstd uri scheme:" + r111.getScheme());
    L117:
        throw new IllegalArgumentException("built-in zstd bundle path is blank");
    L121:
        throw new IllegalArgumentException("built-in zstd bundle path must be relative");
    L123:
        throw new IllegalArgumentException("built-in zstd bundle path must use forward slash");
    L17:
        String r13 = r1.e;
        if (r13 != null) goto L20;
    L23:
        boolean r20 = true;
    L24:
        if (r20 == true) goto L30;
        if (StringsKt.isBlank(r15) == false) goto L29;
        r15 = r13;
        goto L30
    L29:
        r15 = StringsKt.trimEnd(r13, new char[]{File.separatorChar}) + File.separator + StringsKt.trimStart(r15, new char[]{File.separatorChar});
        goto L30
    L20:
        if (StringsKt.isBlank(r13) == true) goto L23;
        r20 = false;
        goto L24
    L11:
        if (StringsKt.isBlank(r2) == true) goto L14;
        r4 = false;
    L125:
        throw new IllegalArgumentException("built-in zstd accessKey or channel is blank");
    L127:
        throw new IllegalStateException("built-in zstd loader is disabled");
    }

    @Override // uqb.b
    public final void a(String r3, uqb.a r4) {
        Intrinsics.checkNotNullParameter(r3, "templatePath");
        Intrinsics.checkNotNullParameter(r4, "resourceCallBack");
        CoreThreadPool.getDefault().getCachedThreadPool().submit(new RunnableC0173c(this, r3, r4));
    }
}
