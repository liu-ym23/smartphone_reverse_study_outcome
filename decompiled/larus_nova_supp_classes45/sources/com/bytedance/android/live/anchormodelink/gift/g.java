package com.bytedance.android.live.anchormodelink.gift;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ String b;

    public g(Function2 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        String r6 = (String) r5;
        JsonObject r1 = null;
        if (TextUtils.isEmpty(r6) == false) goto L17;
        this.a.invoke(Boolean.FALSE, null);
        ALogger.e("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#file empty:" + this.b);
        return;
    L17:
        r1 = (JsonObject) GsonHelper.get().fromJson(r6, JsonObject.class);     // Catch: Throwable -> L7
    L9:
        if (r1 == null) goto L15;
        LruCache<String, JsonObject> r7 = j.a;
        String r8 = this.b;
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r1, "value");
        if (TextUtils.isEmpty(r8) == true) goto L14;
        j.a.put(r8, r1);
    L14:
        this.a.invoke(Boolean.TRUE, r1);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse success:" + this.b + ",data:" + r1);
        return;
    L15:
        this.a.invoke(Boolean.FALSE, r1);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse failed:" + this.b);
        return;
    L7:
        th = move-exception;
        ALogger.e("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse error:" + th);
        goto L9
    }
}
