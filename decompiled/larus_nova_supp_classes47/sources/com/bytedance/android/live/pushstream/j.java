package com.bytedance.android.live.pushstream;

import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.NewPluginType;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T, R> implements Function {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Integer) r2, "it");
        return jc1.k.n(IHostPlugin.class).getNativeLibraryDir(NewPluginType.LiveResource.getPackageName());
    }
}
