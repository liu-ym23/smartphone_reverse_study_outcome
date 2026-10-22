package com.ss.android.lark.inline.ai.ui.richtext;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static VFSPath b() {
        return LarkFileStorage.b().b(com.ss.android.lark.storage.f.d, new com.ss.android.lark.storage.d(new String[]{"inline_ai_res"}));
    }

    public static f c(BufferedReader r15) throws IOException {
        f r1 = new f();     // Catch: Throwable -> L30
        Ref.ObjectRef r2 = new Ref.ObjectRef();     // Catch: Throwable -> L30
    L4:
        String r3 = r15.readLine();     // Catch: Throwable -> L30
        if (r3 != null) goto L7;
        String r4 = "";
    L8:
        r2.element = r4;     // Catch: Throwable -> L30
        if (r3 != null) goto L12;
    L38:
        r15.close();     // Catch: Exception -> L27
    L29:
        return r1;
    L27:
        e = move-exception;
        Log.e("RichtextResLoader", e);
        goto L29
    L12:
        if (StringsKt.startsWith$default(r4, "version", false, 2, null) == false) goto L17;
        String[] r5 = (String[]) StringsKt.split$default((CharSequence) r2.element, new String[]{":"}, false, 0, 6, null).toArray(new String[0]);     // Catch: Throwable -> L30
        if (r5.length != 2) goto L22;
        r1.b = r5[1];     // Catch: Throwable -> L30
    L22:
        if (TextUtils.isEmpty(r1.a) == true) goto L4;
        if (TextUtils.isEmpty(r1.b) == true) goto L4;
    L17:
        if (StringsKt.startsWith$default((String) r2.element, "revision", false, 2, null) == false) goto L22;
        String[] r6 = (String[]) StringsKt.split$default((CharSequence) r2.element, new String[]{":"}, false, 0, 6, null).toArray(new String[0]);     // Catch: Throwable -> L30
        if (r6.length != 2) goto L22;
        r1.a = r6[1];     // Catch: Throwable -> L30
        goto L22
    L7:
        r4 = r3;
    L30:
        th = move-exception;
        r15.close();     // Catch: Exception -> L33
    L35:
        throw th;
    L33:
        e = move-exception;
        Log.e("RichtextResLoader", e);
        goto L35
    }

    public static void a(Context r8, String r9, VFSPath r10) {
        InputStream r2 = null;
        InputStream r3 = null;
        OutputStream r4 = null;
        r4 = null;
        r2 = null;
        String[] r5 = r8.getAssets().list(r9);     // Catch: Throwable -> L32 Exception -> L34
        if (r5 != null) goto L6;
    L16:
        InputStream r11 = r8.getAssets().open(r9);     // Catch: Throwable -> L32 Exception -> L34
        VFSPath r12 = r10.getParent();     // Catch: Throwable -> L28 Exception -> L30
        if (r12 == null) goto L20;
        com.suite.lark.component.storage.ext.b.d(r12);     // Catch: Throwable -> L28 Exception -> L30
    L20:
        VFSFiles.b.getClass();     // Catch: Throwable -> L28 Exception -> L30
        r4 = VFSFiles.b(true).s(r10, false);     // Catch: Throwable -> L28 Exception -> L30
        byte[] r13 = new byte[1024];     // Catch: Throwable -> L28 Exception -> L30
    L21:
        int r14 = r11.read(r13);     // Catch: Throwable -> L28 Exception -> L30
        if (r14 == (-1)) goto L24;
        r4.write(r13, 0, r14);     // Catch: Throwable -> L28 Exception -> L30
        goto L21
    L24:
        r4.flush();     // Catch: Throwable -> L28 Exception -> L30
        r11.close();     // Catch: Throwable -> L28 Exception -> L30
        r4.close();     // Catch: Throwable -> L28 Exception -> L30
        r3 = r11;
        OutputStream r15 = r4;
    L26:
        com.larksuite.framework.utils.d.b(new Closeable[]{r3});
        com.larksuite.framework.utils.d.b(new Closeable[]{r15});
        return;
    L30:
        Exception e = e;
        Closeable r7 = r4;
        r2 = r11;
        Closeable r16 = r7;
    L41:
        Log.e("RichtextResLoader", e);     // Catch: Throwable -> L38
        throw e;     // Catch: Throwable -> L38
    L38:
        Throwable th = th;
    L39:
        com.larksuite.framework.utils.d.b(new Closeable[]{r2});
        com.larksuite.framework.utils.d.b(new Closeable[]{r16});
        throw th;
    L28:
        th = th;
        Closeable r17 = r4;
        r2 = r11;
        r16 = r17;
        goto L39
    L6:
        if (r5.length != 0) goto L8;
        boolean r6 = true;
    L10:
        if ((!r6) == false) goto L16;
        com.suite.lark.component.storage.ext.b.d(r10);     // Catch: Throwable -> L32 Exception -> L34
        Iterator r18 = ArrayIteratorKt.iterator(r5);     // Catch: Throwable -> L32 Exception -> L34
    L13:
        if (r18.hasNext() == false) goto L15;
        String r19 = (String) r18.next();     // Catch: Throwable -> L32 Exception -> L34
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L32 Exception -> L34
        a(r8, r9 + '/' + r19, r10.subPath(r19));     // Catch: Throwable -> L32 Exception -> L34
        goto L13
    L15:
        r15 = null;
        goto L26
    L8:
        r6 = false;
    L34:
        e = move-exception;
        e = e;
        r16 = null;
    L32:
        th = move-exception;
        th = th;
        r16 = null;
        goto L39
    }
}
