package zjb;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ss.android.lark.g;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.BaseKVStorage;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.util.share_preference.UserSP;
import com.suite.lark.component.protocol.Biz;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final Gson a;

    /* JADX INFO: renamed from: zjb.a$a, reason: collision with other inner class name */
    public static class C0354a {
        public static final a a = null;

        static {
            a = new a();
        }
    }

    public a() {
        this.a = new GsonBuilder().create();
    }

    public final void a(Map<String, xjb.b> r6) {
        if (r6 == null) goto L13;
        b r0 = new b();     // Catch: Exception -> L5
        r0.a(new HashMap(r6));     // Catch: Exception -> L5
        String r7 = this.a.toJson(r0);     // Catch: Exception -> L5
    L8:
        if (TextUtils.isEmpty(r7) == true) goto L14;
        int r1 = c.a;
        Intrinsics.checkNotNullParameter(r7, "guideString");
        Biz r2 = Biz.UG;
        LarkKVStorage r3 = LarkKVStorage.a;
        Intrinsics.checkNotNullParameter(r2, "biz");
        com.ss.android.lark.storage.a r4 = j6c.a.a(r2);
        LarkKVStorage.a.getClass();
        String r5 = BaseKVStorage.a(LarkKVStorage.m());
        Context r8 = g.getContext();
        Intrinsics.checkNotNullParameter(r5, "userId");
        LarkKVStorage.n(r8, r5, r4, "guide_mgr", new n6c.a(UserSP.getUserSPById(r5))).putString("lark.android.guide_mgr", r7);
        return;
    L14:
        return;
    L5:
        e = move-exception;
        Log.e("GuideCacheService", "save json fail", e);
        r7 = "";
        goto L8
    }
}
