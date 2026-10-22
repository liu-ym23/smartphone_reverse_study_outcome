package com.bytedance.badger.z;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataByteArray;
import com.bytedance.badger.module.BadgerModuleBase;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class z0 extends u0 {
    public z0() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r5, BadgerModuleBase.BadgerRequestData r6) {
        AssetManager r7 = r5.getApplicationContext().getAssets();     // Catch: Exception -> L24
        BadgerCore.Companion.getClass();     // Catch: Exception -> L24
        InputStream r8 = r7.open(com.bytedance.badger.j.b(8514256862361902932L), 2);     // Catch: Exception -> L24
        ByteArrayOutputStream r9 = new ByteArrayOutputStream();     // Catch: Throwable -> L19
        byte[] r0 = new byte[1024];     // Catch: Throwable -> L14
        Ref.IntRef r1 = new Ref.IntRef();     // Catch: Throwable -> L14
    L6:
        int r2 = r8.read(r0);     // Catch: Throwable -> L14
        r1.element = r2;     // Catch: Throwable -> L14
        if (r2 == (-1)) goto L9;
        r9.write(r0, 0, r2);     // Catch: Throwable -> L14
        goto L6
    L9:
        byte[] r3 = r9.toByteArray();     // Catch: Throwable -> L14
    L11:
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r8, null);     // Catch: Exception -> L24
        return new BadgerResult.Success(new DataByteArray(r3));
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Exception -> L24
        throw th;     // Catch: Exception -> L24
    L24:
        e = move-exception;
        return new BadgerResult.Failure(BadgerResult.ERROR, String.valueOf(e.getMessage()));
    }
}
