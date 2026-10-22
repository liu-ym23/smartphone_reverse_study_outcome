package com.lynx.jsbridge;

import android.os.Handler;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.e0;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxExposureModule extends LynxContextModule {
    public static final String NAME = "LynxExposureModule";

    public class a extends f6a.e {
        public final /* synthetic */ ReadableMap b;
        public final /* synthetic */ LynxExposureModule c;

        @Override // f6a.e
        public final void a() {
            com.lynx.tasm.behavior.ui.h r0 = this.c.mLynxContext.getExposure();
            if (r0 == null) goto L6;
            r0.s(this.b.asHashMap());
            return;
        }

        public a(LynxExposureModule r1, LynxContext r2, ReadableMap r3) {
            this.c = r1;
            this.b = r3;
            super(r2);
        }
    }

    public class b extends f6a.e {
        public final /* synthetic */ LynxExposureModule b;

        @Override // f6a.e
        public final void a() {
            com.lynx.tasm.behavior.ui.h r0 = this.b.mLynxContext.getExposure();
            if (r0 == null) goto L6;
            r0.p();
            return;
        }

        public b(LynxExposureModule r1, LynxContext r2) {
            this.b = r1;
            super(r2);
        }
    }

    public class c extends f6a.e {
        public final /* synthetic */ ReadableMap b;
        public final /* synthetic */ LynxExposureModule c;

        @Override // f6a.e
        public final void a() {
            com.lynx.tasm.behavior.ui.h r0 = this.c.mLynxContext.getExposure();
            if (r0 == null) goto L30;
            ReadableMap r1 = this.b;
            if (r1 == null) goto L35;
            int r4 = -1;
            if (r1.hasKey("forExposureCheck") == false) goto L10;
            int r2 = r1.getInt("forExposureCheck");
        L12:
            if (r2 <= 0) goto L15;
            r0.g = Math.max(16, 1000 / r2);
        L15:
            if (r1.hasKey("forPageRect") == false) goto L17;
            r4 = r1.getInt("forPageRect");
        L17:
            if (r4 >= 0) goto L19;
            return;
        L19:
            if (r4 == 0) goto L21;
            long r3 = Math.max(16, 1000 / r4);
        L22:
            r0.n = r3;
            if (r3 == 0) goto L32;
            Handler r5 = r0.k;
            if (r5 == null) goto L33;
            e0.f r6 = r0.l;
            if (r6 == null) goto L34;
            r5.postDelayed(r6, r3);
            return;
        L34:
            return;
        L33:
            return;
        L32:
            return;
        L21:
            r3 = 0;
            goto L22
        L10:
            r2 = -1;
            goto L12
        L35:
            return;
        }

        public c(LynxExposureModule r1, LynxContext r2, ReadableMap r3) {
            this.c = r1;
            this.b = r3;
            super(r2);
        }
    }

    @LynxMethod
    public void resumeExposure() {
        UIThreadUtils.runOnUiThread(new b(this, this.mLynxContext));
    }

    public LynxExposureModule(LynxContext r1) {
        super(r1);
    }

    @LynxMethod
    public void setObserverFrameRate(ReadableMap r3) {
        UIThreadUtils.runOnUiThread(new c(this, this.mLynxContext, r3));
    }

    @LynxMethod
    public void stopExposure(ReadableMap r3) {
        UIThreadUtils.runOnUiThread(new a(this, this.mLynxContext, r3));
    }
}
