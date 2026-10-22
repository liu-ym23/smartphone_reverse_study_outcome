package com.bytedance.bpea.entry.api.content.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.bytedance.bpea.basics.BPEAException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ContentResolverTranslateEntry$Companion$InnerContentResolver implements c, b, d, a {
    public final qc4.c getContext() {
        return null;
    }

    public static void a() {
        throw new BPEAException(-1, "contentResolver handler state illegal: can not be reused");
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.a
    public int delete(Bundle r1) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.b
    public Uri insert(ContentValues r1) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.a
    public int delete(String r1, String[] r2) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.b
    public Uri insert(ContentValues r1, Bundle r2) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.d
    public int update(ContentValues r1, Bundle r2) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.c
    public Cursor query(String[] r1, Bundle r2, CancellationSignal r3) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.d
    public int update(ContentValues r1, String r2, String[] r3) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.c
    public Cursor query(String[] r1, String r2, String[] r3, String r4) {
        a();
        throw null;
    }

    @Override // com.bytedance.bpea.entry.api.content.provider.c
    public Cursor query(String[] r1, String r2, String[] r3, String r4, CancellationSignal r5) {
        a();
        throw null;
    }
}
