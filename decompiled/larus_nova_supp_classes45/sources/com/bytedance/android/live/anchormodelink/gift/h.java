package com.bytedance.android.live.anchormodelink.gift;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ String b;

    public h(Function2 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        this.a.invoke(Boolean.FALSE, null);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#error:" + this.b + ", " + ((Throwable) r4));
    }
}
