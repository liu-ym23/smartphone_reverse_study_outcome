package nbb;

import android.text.TextUtils;
import android.util.LruCache;
import com.google.gson.Gson;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.callback.MemoryCallbackManager;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import qbb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final com.ss.android.lark.storage.a a = null;
    public static final String b = null;
    public static final LruCache<String, obb.b> c = null;
    public static final Gson d = null;

    static {
        a = new com.ss.android.lark.storage.a(ChameleonResConstants.CCM_ROOT_DIR);
        b = "docs_icon";
        c = new LruCache(20971520);
        d = new Gson();
        MemoryCallbackManager.getInstance().registerMemoryCallback(new a());
    }

    public static com.ss.android.lark.storage.kv.repo.a b(UserSession r6) {
        c r0 = new c(r6);
        Intrinsics.checkNotNullParameter(r0, "userScopeView");
        r0.provideComponent();
        String r1 = r0.e9().b;
        return com.ss.android.lark.storage.c.d(LarkContext.getApplication(), r1, a, b, null, 32);
    }

    public static obb.b a(String r4, UserSession r5) {
        Intrinsics.checkNotNullParameter(r4, "token");
        if (TextUtils.isEmpty(r4) == false) goto L6;
        Log.i("DOCS_ICON_DocMetaDataManager", "getMetaInfoWithTokenLocal token empty");
        return null;
    L6:
        obb.b r0 = c.get(r4);
        if (r0 == null) goto L19;
        Log.i("DOCS_ICON_DocMetaDataManager", "getMetaInfoWithTokenLocal cache");
        return r0;
    L19:
        obb.b r6 = (obb.b) d.fromJson(b(r5).getString(r4, BuildConfig.FLAVOR), obb.b.class);     // Catch: Exception -> L12
    L14:
        if (r6 == null) goto L17;
        Log.i("DOCS_ICON_DocMetaDataManager", "getMetaInfoWithTokenLocal disk");
        c.put(r4, r6);
        return r6;
    L17:
        Log.i("DOCS_ICON_DocMetaDataManager", "getMetaInfoWithTokenLocal null");
        return null;
    L12:
        e = move-exception;
        Log.e("DOCS_ICON_DocMetaDataManager", "getMetaFromDisk error " + e.getMessage());
        r6 = null;
        goto L14
    }

    public static void c(String r4, obb.b r5, UserSession r6) {
        Intrinsics.checkNotNullParameter(r5, "metaInfo");
        if (TextUtils.isEmpty(r4) == false) goto L6;
        Log.i("DOCS_ICON_DocMetaDataManager", "insertOrUpdateMetaInfo token null");
        return;
    L6:
        Log.i("DOCS_ICON_DocMetaDataManager", "insertOrUpdateMetaInfo token " + r5.getType() + ' ' + r5.d);
        LruCache<String, obb.b> r0 = c;
        obb.b r2 = r0.get(r4);
        r0.put(r4, r5);
        if (r2 != null) goto L9;
    L17:
        r5.g = Long.valueOf(System.nanoTime());
        if (r4 == null) goto L27;
        b(r6).putString(r4, d.toJson(r5));     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        Log.e("DOCS_ICON_DocMetaDataManager", "insertOrUpdateMetaInfo error " + e.getMessage());
        return;
    L27:
        return;
    L9:
        if (Intrinsics.areEqual(r5.d, r2.d) == true) goto L11;
    L15:
        boolean r1 = false;
    L16:
        if (r1 == false) goto L17;
        return;
    L11:
        if (Intrinsics.areEqual(r5.e, r2.e) == false) goto L15;
        if (Intrinsics.areEqual(r5.i, r2.i) == false) goto L15;
        r1 = true;
        goto L16
    }
}
