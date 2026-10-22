package a6a;

import com.lynx.jsbridge.LynxModule;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.jsbridge.MethodDescriptor;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.core.k;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {

    public static class a implements Callback {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        @Override // com.lynx.react.bridge.Callback
        public final void invoke(Object... r5) {
            LynxEngineProxy r0 = (LynxEngineProxy) this.a.get();
            if (r0 != null) goto L7;
            LLog.i("LynxLepusModule", "triggerLepusBridgeAsync failed, LynxEngine has been released.");
            return;
        L7:
            if (r5.length > 0) goto L9;
            return;
        L9:
            if (this.b == true) goto L13;
            j7a.a r1 = j7a.a.a;
            Object r6 = r5[0];
            r1.getClass();
            ByteBuffer r7 = j7a.a.b(r6);
            UIThreadUtils.runOnUiThreadImmediately(new k(r0, this.c, this.d, r7));
            return;
        }

        public a(WeakReference r1, boolean r2, int r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX INFO: renamed from: a6a.b$b, reason: collision with other inner class name */
    public static class C0004b implements Callback {
        public final /* synthetic */ WeakReference a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        @Override // com.lynx.react.bridge.Callback
        public final void invoke(Object... r5) {
            LynxEngineProxy r0 = (LynxEngineProxy) this.a.get();
            if (r0 != null) goto L7;
            LLog.i("LynxLepusModule", "triggerLepusBridgeAsync failed, LynxEngine has been released.");
            return;
        L7:
            if (r5.length <= 0) goto L10;
            j7a.a r1 = j7a.a.a;
            Object r6 = r5[0];
            r1.getClass();
            ByteBuffer r7 = j7a.a.b(r6);
            UIThreadUtils.runOnUiThreadImmediately(new k(r0, this.b, this.c, r7));
            return;
        }

        public C0004b(WeakReference r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static void a(LynxModuleWrapper r16, LynxEngineProxy r17, ReadableMap r18, String r19) {
        ReadableMap r2 = r18.getMap("methodDetail", new JavaOnlyMap());
        r2.getString("module", null);
        String r3 = r2.getString("method", null);
        boolean r5 = r18.getBoolean("fromPiper", false);
        String r4 = r18.getString("tasmEntryName", null);
        int r0 = r18.getInt("callbackId", -1);
        char r8 = 1;
        if (r19.equals("call") == true) goto L9;
        if (r3 != null) goto L6;
    L8:
        boolean r7 = false;
    L31:
        Iterator<MethodDescriptor> r9 = r16.getMethodDescriptors().iterator();     // Catch: Exception -> L28
    L11:
        if (r9.hasNext() == false) goto L36;
        MethodDescriptor r10 = r9.next();     // Catch: Exception -> L28
        String r11 = r10.getName();     // Catch: Exception -> L28
        if (r11 == null) goto L27;
        if (r11.isEmpty() == true) goto L27;
        if (r11.equals(r19) == false) goto L27;
        WeakReference r12 = new WeakReference(r17);     // Catch: Exception -> L28
        if (r7 == false) goto L24;
        Method r13 = r10.getMethod();     // Catch: Exception -> L28
        LynxModule r14 = r16.getModule();     // Catch: Exception -> L28
        Object[] r15 = new Object[3];     // Catch: Exception -> L28
        r15[0] = r3;     // Catch: Exception -> L28
        r15[r8] = r2;     // Catch: Exception -> L28
        r15[2] = new a(r12, r5, r0, r4);     // Catch: Exception -> L28
        r13.invoke(r14, r15);     // Catch: Exception -> L28
        goto L27
    L24:
        if (r5 == false) goto L26;
        r10.getMethod().invoke(r16.getModule(), r2.getArray("param", new JavaOnlyArray()).asArrayList().toArray());     // Catch: Exception -> L28
        goto L27
    L26:
        r10.getMethod().invoke(r16.getModule(), new Object[]{r2, new C0004b(r12, r0, r4)});     // Catch: Exception -> L28
    L27:
        r8 = 1;
        goto L11
    L36:
        return;
    L28:
        e = move-exception;
        LLog.e("LynxLepusModule", "Lepus Module invokeAsync: " + e.toString());
        return;
    L6:
        if (r3.length() == 0) goto L8;
    L9:
        r7 = true;
        goto L31
    }
}
