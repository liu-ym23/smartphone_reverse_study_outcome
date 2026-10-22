package com.bytedance.android.annie.api.data.subscribe;

import com.google.gson.JsonElement;
import io.reactivex.Observable;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface e<T> extends g<T> {
    Pair<String, Observable<JsonElement>> b(String r1);

    void onRelease();
}
