package com.larus.bmhome.chat.screenshot;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import f06.d;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c extends f {
    @Override // com.larus.bmhome.chat.screenshot.f
    public final void b() {
        this.c = System.currentTimeMillis();
        String[] r5 = {"_data", "date_added"};
        Context r3 = getContext().get();
        if (r3 != null) goto L5;
        return;
    L5:
        ContentResolver r14 = r3.getContentResolver();
        Uri r4 = this.a;
        f06.c r16 = new f06.c();
        Object[] r6 = {r4, r5, null, null, "date_modified desc"};
        f06.b r17 = new f06.b();
        d r13 = r16.b(240004, "android/content/ContentResolver", "query", r14, r6, "android.database.Cursor", r17);
        if (r13.a == false) goto L8;
        r16.a(240004, "android/content/ContentResolver", "query", r14, r6, null, r17, false);
        Cursor r7 = (Cursor) r13.b;
    L9:
        if (r7 == null) goto L26;
        Cursor r8 = r7;
        Cursor r9 = r8;     // Catch: Throwable -> L20
        int r10 = r9.getCount();     // Catch: Throwable -> L20
        if (this.d < r10) goto L14;
        this.d = r10;     // Catch: Throwable -> L20
    L18:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r8, null);
        return;
    L14:
        this.d = r10;     // Catch: Throwable -> L20
        if (r9.moveToFirst() == false) goto L18;
        int r2 = r9.getColumnIndex("date_added");     // Catch: Throwable -> L20
        int r1 = r9.getColumnIndex("_data");     // Catch: Throwable -> L20
        int r11 = r9.getColumnIndex("_id");     // Catch: Throwable -> L20
        long r12 = r9.getLong(r2);     // Catch: Throwable -> L20
        String r15 = r9.getString(r1);     // Catch: Throwable -> L20
        Uri r18 = ContentUris.withAppendedId(this.a, r9.getLong(r11));     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L20
        a(r15, r12, r18);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);
        throw th;
    L26:
        return;
    L8:
        r7 = r14.query(r4, r5, null, null, "date_modified desc");
        r16.a(240004, "android/content/ContentResolver", "query", r14, r6, r7, r17, true);
        goto L9
    }

    public c(Uri r2, WeakReference<Context> r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r2, r3);
    }
}
