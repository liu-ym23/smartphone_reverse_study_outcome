package idb;

import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import java.util.HashSet;
import java.util.concurrent.Future;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends AbstractBaseSettingHandler {
    public final Object i;
    public Future<HashSet<String>> j;

    public static class a {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    public final String a() {
        return "lark_features";
    }

    public final String f() {
        return "DefaultFeatureGatingHandler";
    }

    public c() {
        this.i = new Object();
        AbstractBaseSettingHandler.a r0 = ((AbstractBaseSettingHandler) this).d;
        Function0 r1 = new b();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "strategy");
        r0.a(r0.a, r1);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        ((AbstractBaseSettingHandler) this).f = r0;
    }
}
