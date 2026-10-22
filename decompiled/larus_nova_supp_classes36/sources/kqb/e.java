package kqb;

import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.storage.LarkKVStorage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static com.ss.android.lark.storage.kv.repo.a a() {
        return LarkKVStorage.q(new com.ss.android.lark.storage.a("location_message"), true);
    }

    public static void b(@LocationHitPoint$ResultType String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        a().putString("result_type", r2);
    }
}
