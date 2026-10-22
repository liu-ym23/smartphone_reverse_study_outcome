package com.bytedance.android.live.effect.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.ss.android.ugc.effectmanager.common.listener.IJsonConverter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements IJsonConverter {
    public Gson a;

    public l() {
    }

    public final <T> String convertObjToJson(T r2) throws Exception {
        if (this.a != null) goto L6;
        this.a = new Gson();
    L6:
        return GsonProtectorUtils.toJson(this.a, r2);
    }

    public final <T> T convertJsonToObj(InputStream r4, Class<T> r5) {
        if (this.a != null) goto L5;
        this.a = new Gson();
    L5:
        JsonReader r0 = (T) null;
        JsonReader r1 = new JsonReader(new InputStreamReader(r4));     // Catch: Throwable -> L14 JsonSyntaxException -> L16
        r0 = (T) this.a.fromJson(r1, r5);
        r1.close();     // Catch: IOException -> L10
    L33:
    L21:
        return (T) r0;
    L12:
        e = e;
    L18:
        e.getMessage();     // Catch: Throwable -> L22
        if (r1 == null) goto L21;
        r1.close();     // Catch: IOException -> L10
    L22:
        th = th;
        r0 = (T) r1;
    L24:
        if (r0 != null) goto L36;
    L29:
        throw th;
    L36:
        r0.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L10:
        e = move-exception;
        e.printStackTrace();
    L16:
        e = e;
        r1 = null;
    L14:
        th = th;
        goto L24
    }
}
