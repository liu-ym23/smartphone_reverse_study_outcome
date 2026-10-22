package z54;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.awemeopen.servicesapi.storage.AoKVStorageService;
import j64.b;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    static {
    }

    public static /* synthetic */ SharedPreferences b(String r1) {
        return a(y54.a.a(), r1);
    }

    @JvmStatic
    public static final SharedPreferences a(Context r1, String r2) {
        int r0 = b.a;
        return b.a(AoKVStorageService.class).h(r1, r2);
    }
}
