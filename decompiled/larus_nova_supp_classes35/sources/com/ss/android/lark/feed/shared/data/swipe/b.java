package com.ss.android.lark.feed.shared.data.swipe;

import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T, R> implements Function {
    public static final b<T, R> a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final Object apply(Object r2) {
        s r3 = (s) r2;
        Intrinsics.checkNotNullParameter(r3, "r");
        return t.e(r3, SwipeActionSettingStore$getFeedActionSetting$1$1.INSTANCE);
    }
}
