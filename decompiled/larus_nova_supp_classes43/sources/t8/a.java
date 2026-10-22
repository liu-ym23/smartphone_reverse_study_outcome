package t8;

import android.os.AsyncTask;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.ng.j;
import com.bytedance.android.annie.resource.b;
import com.bytedance.android.annie.resource.c;
import com.bytedance.android.annie.resource.d;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import p9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements j {
    public a() {
    }

    @Override // com.bytedance.android.annie.ng.j
    public final void onCallback() {
        AtomicBoolean r0 = c.a;
        if (c.a.compareAndSet(false, true) == false) goto L10;
        GeckoXAdapter.Companion.addDefaultCDNMultiVersionDomains(CollectionsKt.listOf(new String[]{"lf-webcast-gr-sourcecdn.bytegecko.com", "lf-dy-gr-sourcecdn.bytegecko.com", "lf-tt-gr-sourcecdn.bytegecko.com", "lf-hs-gr-sourcecdn.bytegecko.com", "lf-xg-gr-sourcecdn.bytegecko.com", "lf-normal-gr-sourcecdn.bytegecko.com", "lf-ecom-gr-sourcecdn.bytegecko.com"}));
        ((e) Annie.getService$default(e.class, null, 2, null)).b0(new com.bytedance.android.annie.resource.a());
        Annie.registerService$default(com.bytedance.android.annie.service.resource.e.class, new d(), null, 4, null);
        if (AnnieConfigSettingKeys.PRE_INIT_FOREST_CLIENT.a().booleanValue() == false) goto L9;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(b.a);
        return;
    L9:
        return;
    }
}
