package d28;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static Boolean a;
    public static Boolean b;

    public static com.ss.android.lark.storage.kv.repo.a b(Context r4, String r5) {
        SharedPreferences r6 = r4.getApplicationContext().getSharedPreferences(r5, 0);
        LarkKVStorage.KVStorageBuilder r0 = new LarkKVStorage.KVStorageBuilder(r4);
        r0.b = "lark";
        LarkKVStorage.b r1 = LarkKVStorage.r(r0.b());
        com.ss.android.lark.storage.a r2 = new com.ss.android.lark.storage.a("core");
        Intrinsics.checkNotNullParameter(r2, "domain");
        r1.b = r2;
        r1.c = "http";
        r1.b(new n6c.b(r6), false);
        com.ss.android.lark.storage.kv.repo.a r7 = r1.a();
        if (b != null) goto L6;
        b = Boolean.valueOf(com.ss.android.lark.featuregating.b.d.a().a("mobile.infra.cookie.cipher.cleanup"));
        Log.i("CookieStorage", "Cookie cleanup FG enabled: " + b);
    L6:
        if (b.booleanValue() == false) goto L10;
        return a(r4, r7, true);
    L10:
        if (a != null) goto L13;
        a = Boolean.valueOf(com.ss.android.lark.featuregating.b.d.a().a("mobile.infra.cookie.cipher.persisten"));
        Log.i("CookieStorage", "Cookie encryption FG enabled: " + a);
    L13:
        if (a.booleanValue() == true) goto L15;
        return r7;
    L15:
        return a(r4, r7, false);
    }

    public static com.ss.android.lark.storage.kv.repo.a a(Context r2, com.ss.android.lark.storage.kv.repo.a r3, boolean r4) {
        LarkKVStorage.KVStorageBuilder r0 = new LarkKVStorage.KVStorageBuilder(r2);
        LarkKVStorage.CipherMode r5 = LarkKVStorage.CipherMode.ONLY_VALUE;
        Intrinsics.checkNotNullParameter(r5, "cipherMode");
        r0.b = "lark";
        r0.a(r5);
        LarkKVStorage.b r6 = LarkKVStorage.r(r0.b());
        com.ss.android.lark.storage.a r1 = new com.ss.android.lark.storage.a("core");
        Intrinsics.checkNotNullParameter(r1, "domain");
        r6.b = r1;
        r6.c = "http.cok";
        r6.b(r3, r4);
        return r6.a();
    }
}
