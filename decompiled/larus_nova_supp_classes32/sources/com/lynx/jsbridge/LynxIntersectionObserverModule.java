package com.lynx.jsbridge;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.behavior.u;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.y;
import com.lynx.tasm.behavior.z;
import com.lynx.tasm.utils.UIThreadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxIntersectionObserverModule extends LynxContextModule {
    public static final String NAME = "IntersectionObserverModule";

    public class a extends f6a.e {
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ReadableMap d;
        public final /* synthetic */ LynxIntersectionObserverModule e;

        @Override // f6a.e
        public final void a() {
            d0 r0 = this.e.mLynxContext.getIntersectionObserverManager();
            if (r0.m(this.b) == null) goto L5;
            return;
        L5:
            if (this.c.isEmpty() == true) goto L7;
            String r1 = this.c;
        L8:
            UIThreadUtils.runOnUiThreadImmediately(new y(r0, new u(r0, this.b, r1, this.d)));
            return;
        L7:
            r1 = "-1";
            goto L8
        }

        public a(LynxIntersectionObserverModule r1, LynxContext r2, int r3, String r4, ReadableMap r5) {
            this.e = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            super(r2);
        }
    }

    public class b extends f6a.e {
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ReadableMap d;
        public final /* synthetic */ LynxIntersectionObserverModule e;

        @Override // f6a.e
        public final void a() {
            u r0 = this.e.mLynxContext.getIntersectionObserverManager().m(this.b);
            if (r0 == null) goto L19;
            String r1 = this.c;
            ReadableMap r2 = this.d;
            if (r1.startsWith("#") == true) goto L8;
            return;
        L8:
            if (r0.getContext() != null) goto L10;
            LLog.e("LynxIntersectionObserver", "relativeTo failed because context is null");
            r0.e = null;
        L12:
            if (r0.e != null) goto L17;
            LLog.w("LynxIntersectionObserver", "Can't find element, finding in element");
            if (r0.c() != null) goto L16;
            LLog.e("LynxIntersectionObserver", "relativeTo failed because UIOwner is null");
            goto L17
        L16:
            r0.e = r0.c().findLynxUIByIdSelector(r1.substring(1));
        L17:
            r0.d(r2);
            return;
        L10:
            r0.e = r0.getContext().findLynxUIByIdSelector(r1.substring(1), r0.d);
            goto L12
        }

        public b(LynxIntersectionObserverModule r1, LynxContext r2, int r3, String r4, ReadableMap r5) {
            this.e = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            super(r2);
        }
    }

    public class c extends f6a.e {
        public final /* synthetic */ int b;
        public final /* synthetic */ ReadableMap c;
        public final /* synthetic */ LynxIntersectionObserverModule d;

        @Override // f6a.e
        public final void a() {
            u r0 = this.d.mLynxContext.getIntersectionObserverManager().m(this.b);
            if (r0 == null) goto L6;
            ReadableMap r1 = this.c;
            r0.e = null;
            r0.d(r1);
            return;
        }

        public c(LynxIntersectionObserverModule r1, LynxContext r2, int r3, ReadableMap r4) {
            this.d = r1;
            this.b = r3;
            this.c = r4;
            super(r2);
        }
    }

    public class d extends f6a.e {
        public final /* synthetic */ int b;
        public final /* synthetic */ ReadableMap c;
        public final /* synthetic */ LynxIntersectionObserverModule d;

        @Override // f6a.e
        public final void a() {
            u r0 = this.d.mLynxContext.getIntersectionObserverManager().m(this.b);
            if (r0 == null) goto L6;
            ReadableMap r1 = this.c;
            r0.e = null;
            r0.l = true;
            r0.d(r1);
            return;
        }

        public d(LynxIntersectionObserverModule r1, LynxContext r2, int r3, ReadableMap r4) {
            this.d = r1;
            this.b = r3;
            this.c = r4;
            super(r2);
        }
    }

    public class e extends f6a.e {
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ LynxIntersectionObserverModule e;

        @Override // f6a.e
        public final void a() {
            u r0 = this.e.mLynxContext.getIntersectionObserverManager().m(this.b);
            if (r0 == null) goto L31;
            String r1 = this.c;
            int r2 = this.d;
            if (r0.getContext() != null) goto L8;
            LLog.e("LynxIntersectionObserver", "observe failed because context is null");
            return;
        L8:
            if (r1.startsWith("#") == false) goto L27;
            LynxBaseUI r3 = r0.getContext().findLynxUIByIdSelector(r1.substring(1), r0.d);
            if (r3 != null) goto L16;
            LLog.w("LynxIntersectionObserver", "Can't find element, finding in element");
            if (r0.c() != null) goto L14;
            LLog.e("LynxIntersectionObserver", "observe failed because UIOwner is null");
            goto L16
        L14:
            r3 = r0.c().findLynxUIByIdSelector(r1.substring(1));
        L16:
            if (r3 == null) goto L33;
            int r4 = 0;
        L19:
            if (r4 >= r0.n.size()) goto L24;
            if (((u.b) ListProtector.get(r0.n, r4)).a == r3) goto L35;
            r4 = r4 + 1;
            goto L19
        L35:
            return;
        L24:
            u.b r5 = new u.b();
            r5.a = r3;
            r5.b = r2;
            r0.n.add(r5);
            r0.a(r5, r0.b(), true);
            return;
        L33:
            return;
        L27:
            int r6 = CastIntegerProtector.parseInt(r1);     // Catch: NumberFormatException -> L25
            r3 = r0.getContext().findLynxUIBySign(r6);     // Catch: NumberFormatException -> L25
        L25:
            LLog.e("LynxIntersectionObserver", "observe failed because uid is invalid");
            return;
        }

        public e(LynxIntersectionObserverModule r1, LynxContext r2, int r3, String r4, int r5) {
            this.e = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            super(r2);
        }
    }

    public class f extends f6a.e {
        public final /* synthetic */ int b;
        public final /* synthetic */ LynxIntersectionObserverModule c;

        @Override // f6a.e
        public final void a() {
            u r0 = this.c.mLynxContext.getIntersectionObserverManager().m(this.b);
            if (r0 == null) goto L6;
            r0.n.clear();
            d0 r1 = r0.b.get();
            int r2 = r0.a;
            r1.getClass();
            UIThreadUtils.runOnUiThreadImmediately(new z(r1, r2));
            return;
        }

        public f(LynxIntersectionObserverModule r1, LynxContext r2, int r3) {
            this.c = r1;
            this.b = r3;
            super(r2);
        }
    }

    public LynxIntersectionObserverModule(LynxContext r1) {
        super(r1);
    }

    @LynxMethod
    public void disconnect(int r3) {
        UIThreadUtils.runOnUiThread(new f(this, this.mLynxContext, r3));
    }

    @LynxMethod
    public void relativeToScreen(int r3, ReadableMap r4) {
        UIThreadUtils.runOnUiThread(new d(this, this.mLynxContext, r3, r4));
    }

    @LynxMethod
    public void relativeToViewport(int r3, ReadableMap r4) {
        UIThreadUtils.runOnUiThread(new c(this, this.mLynxContext, r3, r4));
    }

    @LynxMethod
    public void createIntersectionObserver(int r8, String r9, ReadableMap r10) {
        UIThreadUtils.runOnUiThread(new a(this, this.mLynxContext, r8, r9, r10));
    }

    @LynxMethod
    public void observe(int r8, String r9, int r10) {
        UIThreadUtils.runOnUiThread(new e(this, this.mLynxContext, r8, r9, r10));
    }

    @LynxMethod
    public void relativeTo(int r8, String r9, ReadableMap r10) {
        UIThreadUtils.runOnUiThread(new b(this, this.mLynxContext, r8, r9, r10));
    }
}
