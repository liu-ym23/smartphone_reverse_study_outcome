package com.lynx.jsbridge;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.o1;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxEmbeddedModule extends LynxContextModule {
    public static final String NAME = "LynxEmbeddedModule";
    private WeakReference<com.lynx.tasm.group.c> mLynxViewGroupRef;

    public class a implements Runnable {
        public final /* synthetic */ ReadableMap a;
        public final /* synthetic */ LynxView b;
        public final /* synthetic */ Callback c;

        @Override // java.lang.Runnable
        public final void run() {
            o1 r1 = new o1(TemplateData.fromMap(this.a.asHashMap()), null);     // Catch: Throwable -> L4
            this.b.updateMetaData(r1);     // Catch: Throwable -> L4
            this.c.invoke(new Object[0]);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ReadableMap r1, LynxView r2, Callback r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ LynxView a;
        public final /* synthetic */ Callback b;

        @Override // java.lang.Runnable
        public final void run() {
            TemplateData r0 = this.a.getTemplateData();     // Catch: Throwable -> L4
            this.b.invoke(new Object[]{r0});     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(LynxView r1, Callback r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ ReadableMap a;
        public final /* synthetic */ LynxView b;
        public final /* synthetic */ Callback c;

        @Override // java.lang.Runnable
        public final void run() {
            o1 r1 = new o1(TemplateData.fromMap(this.a.asHashMap()), null);     // Catch: Throwable -> L4
            this.b.updateMetaData(r1);     // Catch: Throwable -> L4
            this.c.invoke(new Object[0]);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(ReadableMap r1, LynxView r2, Callback r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ LynxView a;
        public final /* synthetic */ Callback b;

        @Override // java.lang.Runnable
        public final void run() {
            TemplateData r0 = this.a.getTemplateData();     // Catch: Throwable -> L4
            this.b.invoke(new Object[]{r0});     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(LynxView r1, Callback r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    private LynxView getLynxViewById(int r1) {
        WeakReference<com.lynx.tasm.group.c> r2 = this.mLynxViewGroupRef;
        if (r2 == null) goto L8;
        com.lynx.tasm.group.c r3 = r2.get();
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.f();
    L8:
        return null;
    }

    public LynxEmbeddedModule(LynxContext r1, Object r2) {
        super(r1);
        if ((r2 instanceof com.lynx.tasm.group.c) == false) goto L6;
        this.mLynxViewGroupRef = new WeakReference((com.lynx.tasm.group.c) r2);
        return;
    }

    @LynxMethod
    public void getDataV2(Callback r3, Callback r4) {
        LynxView r0 = this.mLynxContext.getLynxView();
        if (r0 != null) goto L6;
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put("message", "Cannot get related lynxView.");
        r4.invoke(new Object[]{r5});
        return;
    L6:
        UIThreadUtils.runOnUiThreadImmediately(new d(r0, r3));
    }

    @LynxMethod
    public void getData(int r3, Callback r4, Callback r5) {
        LynxView r0 = getLynxViewById(r3);
        if (r0 != null) goto L6;
        JavaOnlyMap r6 = new JavaOnlyMap();
        r6.put("message", "Cannot get related lynxView (ID: " + r3 + ")");
        r5.invoke(new Object[]{r6});
        return;
    L6:
        UIThreadUtils.runOnUiThread(new b(r0, r4));
    }

    @LynxMethod
    public void setDataV2(ReadableMap r2, Callback r3, Callback r4) {
        LynxView r0 = this.mLynxContext.getLynxView();
        if (r0 != null) goto L6;
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put("message", "Cannot get related lynxView.");
        r4.invoke(new Object[]{r5});
        return;
    L6:
        UIThreadUtils.runOnUiThreadImmediately(new c(r2, r0, r3));
    }

    @LynxMethod
    public void updateData(int r2, ReadableMap r3, Callback r4, Callback r5) {
        LynxView r0 = getLynxViewById(r2);
        if (r0 != null) goto L6;
        JavaOnlyMap r6 = new JavaOnlyMap();
        r6.put("message", "Cannot get related lynxView (ID: " + r2 + ")");
        r5.invoke(new Object[]{r6});
        return;
    L6:
        UIThreadUtils.runOnUiThread(new a(r3, r0, r4));
    }
}
