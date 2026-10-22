package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.xi;
import com.bytedance.android.livesdk.config.yi;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.ws.GlobalUnifyMessageManager;
import com.bytedance.bdlocation.BuildConfig;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@WorkThreadTask
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/init/UnifyMessageInitTask;", "Lcom/bytedance/android/live/core/launch/AbsTask;", "()V", "injectMessagePlatform", BuildConfig.FLAVOR, "run", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
@Task(businessInfo = "WTO_UnifyMessageInitTask", value = 17)
public final class UnifyMessageInitTask extends AbsTask {

    public static final class a implements slc.a {
        public a() {
        }
    }

    public static final class b<T> {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends com.ss.ugc.live.sdk.platform.bytelink.b {
        public c(vs1.a r1, vs1.b r2) {
        }
    }

    private final void injectMessagePlatform() {
        im2.d r0 = new im2.d(false);
        List r1 = com.ss.ugc.live.sdk.platform.a.a;
        Intrinsics.checkNotNullParameter(r0, "messageDecoder");
        ((CopyOnWriteArrayList) com.ss.ugc.live.sdk.platform.a.a).add(r0);
        com.bytedance.android.livesdk.wrds.a r2 = new com.bytedance.android.livesdk.wrds.a();
        Intrinsics.checkNotNullParameter(r2, "wrdsDecoder");
        ((CopyOnWriteArrayList) com.ss.ugc.live.sdk.platform.a.b).add(r2);
        if (((vs1.b) yi.a.getValue()).a() == false) goto L5;
        gm2.c r3 = gm2.c.a;
        com.ss.ugc.live.sdk.platform.a.b(new gm2.o());
    L6:
        Intrinsics.checkNotNullParameter(new a(), "depend");
        List r4 = com.ss.ugc.live.sdk.platform.a.a;
        b r5 = b.a;
        Intrinsics.checkNotNullParameter(r5, "supplier");
        ((CopyOnWriteArrayList) com.ss.ugc.live.sdk.platform.a.d).add(r5);
        return;
    L5:
        gm2.o r6 = new gm2.o();
        Intrinsics.checkNotNullParameter(r6, "decoder");
        ((CopyOnWriteArrayList) com.ss.ugc.live.sdk.platform.a.c).add(r6);
        goto L6
    }

    public void run() {
        GlobalUnifyMessageManager.getInstance().init(new rt2.a());
        injectMessagePlatform();
        int r0 = d4.a;
        xi r1 = xi.a;
        if (((vs1.a) r1.getValue()).a() == false) goto L8;
        gm2.c r2 = gm2.c.a;
        gm2.c.a();
        vs1.a r3 = (vs1.a) r1.getValue();
        c r4 = new c(r3, (vs1.b) yi.a.getValue());
        if (r3.b() == false) goto L7;
        com.ss.ugc.live.sdk.platform.a.f.getClass();
        Intrinsics.checkNotNullParameter(r2, "cursorCache");
    L7:
        com.ss.ugc.live.sdk.platform.a.f.getClass();
        Intrinsics.checkNotNullParameter(r4, "config");
        com.ss.ugc.live.sdk.platform.a.f.getClass();
    L8:
        ALogger.i("UnifyMessageInitTask", "UnifyMessageInitTask run");
    }

    public UnifyMessageInitTask() {
    }
}
