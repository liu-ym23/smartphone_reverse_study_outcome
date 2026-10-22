package com.bytedance.android.livesdk.interactivity.service.wrds;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.livesdk.gift.model.e;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.bdlocation.BuildConfig;
import dc2.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\f\u001a\u00020\u000bH\u0004J)\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u000f\"\n\b\u0000\u0010\b\u0018\u0001*\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0084\bR*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u00118\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel;", "Landroidx/lifecycle/ViewModel;", "Lylc/b;", "wrdsManager", BuildConfig.FLAVOR, "bindManager", BuildConfig.BUILD_TYPE, BuildConfig.FLAVOR, "T", "Ljava/lang/Class;", "type", BuildConfig.FLAVOR, "key", "Ldc2/c;", "createSettingItem", "Lcom/bytedance/android/livesdk/interactivity/service/wrds/RoomDataSyncModel$a;", e.FETCH_FROM_SETTING, BuildConfig.FLAVOR, "settings", "Ljava/util/Map;", "getSettings", "()Ljava/util/Map;", "bindWrdsManager", "Lylc/b;", "<init>", "()V", "a", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoomDataSyncModel extends ViewModel {
    private ylc.b bindWrdsManager;
    private final Map<String, c<?>> settings;

    public static final class a<V> {
        public final V a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(c r1) {
            this.a = r1;
        }

        public final V a(RoomDataSyncModel r2, KProperty<?> r3) {
            Intrinsics.checkNotNullParameter(r2, "thisRef");
            Intrinsics.checkNotNullParameter(r3, "property");
            return this.a;
        }
    }

    public static final class b implements ylc.c {
        public final /* synthetic */ String a;
        public final /* synthetic */ c b;

        public final void onClear() {
            this.b.onClear();
        }

        public final void a(com.ss.ugc.live.sdk.message.wrsc.data.a r5) {
            Intrinsics.checkNotNullParameter(r5, "roomDataSync");
            b0 r0 = b0.o();
            String r1 = "wrds key: " + this.a + " notify update, version: " + r5.a + ", bizLogId: " + r5.c;
            r0.getClass();
            g.i("LiveMessageTracer", r1);
            this.b.a(r5);
        }

        public b(String r1, c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final void release() {
        ylc.b r0 = this.bindWrdsManager;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, c<?>>> r1 = this.settings.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        ylc.c r2 = r1.next().getValue().c;
        if (r2 == null) goto L7;
        r0.f(r2);
        goto L7
    }

    public RoomDataSyncModel() {
        this.settings = new HashMap();
    }

    public final Map<String, c<?>> getSettings() {
        return this.settings;
    }

    public final void bindManager(ylc.b r6) {
        Intrinsics.checkNotNullParameter(r6, "wrdsManager");
        this.bindWrdsManager = r6;
        Iterator<Map.Entry<String, c<?>>> r0 = this.settings.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry<String, c<?>> r1 = r0.next();
        String r2 = r1.getKey();
        c<?> r3 = r1.getValue();
        r3.b = r6.getRoomId();
        com.ss.ugc.live.sdk.message.wrsc.data.a r4 = r6.b(r2);
        if (r4 == null) goto L8;
        r3.a(r4);
    L8:
        b r5 = new b(r2, r3);
        r3.c = r5;
        r6.a(r2, r5);
        goto L4
    }

    public final /* synthetic */ <T> a<c<T>> setting(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return new a(access$createSettingItem(this, Object.class, r4));
    }

    public final <T> c<T> createSettingItem(Class<T> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "key");
        c<T> r0 = new c(r4);
        this.settings.put(r4, r0);
        dc2.a.a(r4, r3);
        return r0;
    }

    public static final /* synthetic */ c access$createSettingItem(RoomDataSyncModel r0, Class r1, String r2) {
        return r0.createSettingItem(r1, r2);
    }
}
