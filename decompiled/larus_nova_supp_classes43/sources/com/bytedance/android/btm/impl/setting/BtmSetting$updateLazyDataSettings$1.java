package com.bytedance.android.btm.impl.setting;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.impl.thread.b;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.lazydata.LazyDataManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zc.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class BtmSetting$updateLazyDataSettings$1 extends Lambda implements Function0<Unit> {
    public static final BtmSetting$updateLazyDataSettings$1 INSTANCE = null;

    public static final class a implements Runnable {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static void a() {
            LazyDataManager r0 = LazyDataManager.e;
            BtmHostDependManager r1 = BtmHostDependManager.F;
            r1.getClass();
            h r10 = (h) BtmHostDependManager.f.getValue(r1, BtmHostDependManager.a[4]);
            if (r10 == null) goto L5;
            String r11 = r10.getSetting();
        L6:
            r0.getClass();
            Intrinsics.checkNotNullParameter("btm_sdk_config", "key");
            Intrinsics.checkNotNullParameter(g.class, "clazz");
            if (r11 == null) goto L15;
            Object r12 = new Gson().fromJson(r11, g.class);     // Catch: Exception -> L10
            LazyDataManager.d("btm_sdk_config", r12, r12.getClass(), LazyDataManager.b());     // Catch: Exception -> L10
            LazyDataManager.b().storeLong("lazy_data_update_time-btm_sdk_config", System.currentTimeMillis());     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            return;
        L15:
            return;
        L5:
            r11 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        INSTANCE = new BtmSetting$updateLazyDataSettings$1();
    }

    public BtmSetting$updateLazyDataSettings$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m922invoke() {
        b.e.a(a.a, false);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m922invoke();
        return Unit.INSTANCE;
    }
}
