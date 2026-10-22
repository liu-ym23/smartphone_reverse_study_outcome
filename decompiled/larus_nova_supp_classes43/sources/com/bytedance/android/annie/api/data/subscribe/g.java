package com.bytedance.android.annie.api.data.subscribe;

import com.google.gson.JsonElement;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface g<T> {
    JsonElement a(String r1);

    g<T> c();

    char d();

    JsonElement e(String r1, String r10);

    JsonElement f(String r1, JsonElement r10);

    T g();

    JsonElement h(List<String> r1, JsonElement r10);

    String key();
}
