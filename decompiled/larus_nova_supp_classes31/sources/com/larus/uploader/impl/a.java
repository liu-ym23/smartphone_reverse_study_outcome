package com.larus.uploader.impl;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.bduploader.BDMediaDataReader;
import java.io.BufferedInputStream;
import java.io.InputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements BDMediaDataReader {
    public final Context a;
    public final String b;
    public long c;
    public InputStream d;
    public BufferedInputStream e;

    /* JADX INFO: renamed from: com.larus.uploader.impl.a$a, reason: collision with other inner class name */
    public static final class C0051a {
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public final int close(int r2) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        BufferedInputStream r4 = this.e;     // Catch: Throwable -> L8
        if (r4 == null) goto L5;
        r4.close();     // Catch: Throwable -> L8
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.constructor-impl(r5);     // Catch: Throwable -> L8
        return 0;
    L5:
        r5 = null;
    L8:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return 0;
    }

    public final int open(int r18) {
        Context r0 = this.a;
        InputStream r2 = null;
        if (r0 == null) goto L18;
        Uri r6 = UriProtector.parse(this.b);
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r6, "uri");
        ContentResolver r1 = r0.getContentResolver();
        f06.c r4 = new f06.c();
        Object[] r15 = {r6, null, null, null, null};
        f06.b r16 = new f06.b();
        f06.d r5 = r4.b(240004, "android/content/ContentResolver", "query", r1, r15, "android.database.Cursor", r16);
        if (r5.a == false) goto L7;
        r4.a(240004, "android/content/ContentResolver", "query", r1, r15, null, r16, false);
        Cursor r3 = (Cursor) r5.b;
    L8:
        if (r3 == null) goto L18;
        Cursor r7 = r3;
        Cursor r8 = r7;     // Catch: Throwable -> L12
        int r9 = r8.getColumnIndex("_size");     // Catch: Throwable -> L12
        r8.moveToFirst();     // Catch: Throwable -> L12
        long r10 = r8.getLong(r9);     // Catch: Throwable -> L12
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r7, null);
    L19:
        this.c = r10;
        Context r12 = this.a;
        if (r12 == null) goto L24;
        ContentResolver r13 = r12.getContentResolver();
        if (r13 == null) goto L24;
        r2 = ContentResolverWrapper.openInputStream(r13, UriProtector.parse(this.b));
    L24:
        this.d = r2;
        if (r2 != null) goto L33;
        return -1;
    L33:
        return 1;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L7:
        Cursor r14 = r1.query(r6, null, null, null, null);
        r4.a(240004, "android/content/ContentResolver", "query", r1, r15, r14, r16, true);
        r3 = r14;
    L18:
        r10 = 0;
        goto L19
    }

    public a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "fileUri");
        this.a = r2;
        this.b = r3;
    }

    public final long getValue(int r1, int r2) {
        if (r2 == 0) goto L4;
        return 0;
    L4:
        return this.c;
    }

    public final int read(int r3, long r4, byte[] r6, int r7) {
        if (this.d != null) goto L7;
        return -1;
    L7:
        if (r4 <= this.c) goto L10;
        return 0;
    L10:
        BufferedInputStream r5 = new BufferedInputStream(this.d);
        this.e = r5;
        return r5.read(r6);
    }
}
