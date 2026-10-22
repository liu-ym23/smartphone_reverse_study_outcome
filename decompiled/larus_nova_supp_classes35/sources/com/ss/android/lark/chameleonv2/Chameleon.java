package com.ss.android.lark.chameleonv2;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IChameleonApi;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class Chameleon {
    public static final Chameleon a = null;
    public static final Lazy b = null;

    public Chameleon() {
    }

    static {
        a = new Chameleon();
        b = LazyKt.lazy(Chameleon$chameleon$2.INSTANCE);
    }

    public static void c(Chameleon r1, ChameleonConfig r2) {
        r1.getClass();
        ((IChameleonApi) b.getValue()).preloadWebview(r2, null);
    }

    public static Fragment a(Context r1, ChameleonConfig r2, List r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return ((IChameleonApi) b.getValue()).getChameleonFragment(r1, r2, r3);
    }

    public static void b(Context r1, ChameleonConfig r2, List r3) {
        ((IChameleonApi) b.getValue()).open(r1, r2, r3);
    }
}
