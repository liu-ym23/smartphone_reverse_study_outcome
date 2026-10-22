package com.bytedance.badger.z;

import android.content.Context;
import android.os.Looper;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends u0 {
    public c() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r5, BadgerModuleBase.BadgerRequestData r6) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        List r7 = com.bytedance.badger.y.g.a;
        Object r8 = a74.e.b;
        monitor-enter(r8);
        JSONObject r9 = new JSONObject();     // Catch: Throwable -> L32
        JSONArray r0 = new JSONArray();     // Catch: Throwable -> L32
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L32
        Iterator r2 = a74.e.g.iterator();     // Catch: Throwable -> L32
    L10:
        if (r2.hasNext() == false) goto L12;
        r0.put((String) r2.next());     // Catch: Throwable -> L32
        goto L10
    L12:
        Iterator r3 = a74.e.h.iterator();     // Catch: Throwable -> L32
    L14:
        if (r3.hasNext() == false) goto L36;
        r1.put((String) r3.next());     // Catch: Throwable -> L32
        goto L14
    L36:
        if (r0.length() <= 0) goto L21;
        r9.putOpt(DataType.TRUE, r0);     // Catch: JSONException -> L35 Throwable -> L32
    L21:
        if (r1.length() <= 0) goto L24;
        r9.putOpt("2", r1);     // Catch: JSONException -> L35 Throwable -> L32
    L24:
        com.bytedance.badger.e.f("event_behavior# ", "consume size= " + a74.e.e);     // Catch: Throwable -> L32
        monitor-exit(r8);     // Catch: Throwable -> L32
        if (r9.length() > 0) goto L31;
        return new BadgerResult.Failure(BadgerResult.ERROR, "empty");
    L31:
        return new BadgerResult.Success(new DataJson(r9));
    L32:
        th = move-exception;
        throw th;
    L5:
        return new BadgerResult.Failure(-999, "cannot be called on the main thread.");
    }
}
