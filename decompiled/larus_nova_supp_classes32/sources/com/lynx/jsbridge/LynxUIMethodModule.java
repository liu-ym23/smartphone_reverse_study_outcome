package com.lynx.jsbridge;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxUIMethodModule extends LynxContextModule {
    public static final String NAME = "LynxUIMethodModule";

    public class a extends f6a.e {
        public final /* synthetic */ String b;
        public final /* synthetic */ ReadableArray c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ReadableMap e;
        public final /* synthetic */ Callback f;
        public final /* synthetic */ LynxUIMethodModule g;

        @Override // f6a.e
        public final void a() {
            if (this.b.isEmpty() == true) goto L5;
            String r0 = this.b;
        L6:
            String r2 = r0;
            this.g.mLynxContext.invokeUIMethod(r2, this.c, this.d, this.e, LynxUIMethodModule.access$000(this.f));
            return;
        L5:
            r0 = "-1";
            goto L6
        }

        public a(LynxUIMethodModule r1, LynxContext r2, String r3, ReadableArray r4, String r5, ReadableMap r6, Callback r7) {
            this.g = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            super(r2);
        }
    }

    public static class b implements Callback {
        public final /* synthetic */ Callback a;

        public b(Callback r1) {
            this.a = r1;
        }

        @Override // com.lynx.react.bridge.Callback
        public final void invoke(Object... r5) {
            if (this.a != null) goto L5;
            return;
        L5:
            JavaOnlyMap r0 = new JavaOnlyMap();
            r0.putInt(LynxResourceModule.CODE_KEY, ((Integer) r5[0]).intValue());
            if (r5.length <= 1) goto L8;
            r0.put(LynxResourceModule.DATA_KEY, r5[1]);
        L8:
            this.a.invoke(new Object[]{r0});
        }
    }

    public LynxUIMethodModule(LynxContext r1) {
        super(r1);
    }

    public static /* synthetic */ Callback access$000(Callback r0) {
        return wrapCallback(r0);
    }

    private static Callback wrapCallback(Callback r1) {
        return new b(r1);
    }

    @LynxMethod
    public void invokeUIMethod(String r10, ReadableArray r11, String r12, ReadableMap r13, Callback r14) {
        UIThreadUtils.runOnUiThread(new a(this, this.mLynxContext, r10, r11, r12, r13, r14));
    }
}
