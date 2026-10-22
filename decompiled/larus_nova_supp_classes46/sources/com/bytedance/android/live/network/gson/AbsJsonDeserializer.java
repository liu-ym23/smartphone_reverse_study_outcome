package com.bytedance.android.live.network.gson;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class AbsJsonDeserializer<T> implements JsonDeserializer<T> {
    public final Gson a;

    public AbsJsonDeserializer(Gson r1) {
        this.a = r1;
    }
}
