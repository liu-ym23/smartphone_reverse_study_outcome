package com.lynx.tasm;

import android.text.TextUtils;
import com.lynx.devtoolwrapper.LynxDevToolPool;
import com.lynx.jsbridge.LynxBytecodeCallback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.service.security.ILynxSecurityService;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class TemplateBundle implements j8a.a {
    public long a;
    public String b;
    public int c;
    public boolean d;
    public t1 e;
    public a f;
    public LynxDevToolPool g;

    public interface a {
    }

    private static native boolean nativeConstructContext(long r0, int r2);

    private static native boolean nativeGetContainsElementTree(long r0);

    private static native Object nativeGetExtraInfo(long r0);

    private static native void nativeInitWithOption(long r0, int r2, boolean r3);

    private static native long nativeParseTemplateFromByteArray(byte[] r0, Object[] r1, boolean r2, long r3);

    private static native long nativeParseTemplateFromByteBuffer(ByteBuffer r0, Object[] r1, boolean r2, long r3);

    private static native void nativePostJsCacheGenerationTask(long r0, String r2, boolean r3, LynxBytecodeCallback r4);

    private static native void nativeReleaseBundle(long r0);

    public final boolean equals(Object r1) {
        if (this != r1) goto L4;
        return true;
    L4:
        return false;
    }

    public final boolean i() {
        if (this.a == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public TemplateBundle() {
        this.a = 0;
        this.b = null;
        this.d = false;
        this.e = new t1(null);
    }

    public final boolean h() {
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L5;
    L7:
        return false;
    L5:
        if (i() == false) goto L7;
        return nativeGetContainsElementTree(this.a);
    }

    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final void k() {
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L20;
        a r4 = this.f;
        if (r4 == null) goto L20;
        u.a r5 = (u.a) r4;
        u r6 = r5.c;
        monitor-enter(r6);
        r5.a.clear();     // Catch: Throwable -> L17
        Map<TemplateBundle, LinkedList<LynxEngine>> r7 = r5.c.a;     // Catch: Throwable -> L17
        HashMap r8 = (HashMap) r7;     // Catch: Throwable -> L17
        r8.remove(r5.b);     // Catch: Throwable -> L17
        monitor-exit(r6);     // Catch: Throwable -> L17
        this.f = null;
    L17:
        th = move-exception;
        throw th;
    L20:
        LynxDevToolPool r9 = this.g;
        if (r9 == null) goto L23;
        r9.destroy();
        this.g = null;
    L23:
        if (r0 == false) goto L28;
        nativeReleaseBundle(this.a);
        this.a = 0;
        return;
    L28:
        return;
    L5:
        if (this.a == 0) goto L7;
        r0 = true;
        goto L9
    }

    public final void finalize() throws Throwable {
        k();
    }

    public static TemplateBundle b(byte[] r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return g(new TemplateBundle(), r2, null, null, null);
    }

    private static Object decodeByteBuffer(ByteBuffer r1) {
        if (r1 == null) goto L5;
        j7a.a.a.getClass();
        return j7a.a.a(r1);
    L5:
        return null;
    }

    public final void d(a2 r4) {
        if (i() == false) goto L8;
        if (r4 == null) goto L9;
        nativeInitWithOption(this.a, r4.a, r4.b);
        return;
    L9:
        return;
    }

    public final void j(String r5) {
        if (i() == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L10;
        nativePostJsCacheGenerationTask(this.a, r5, false, null);
        return;
    }

    public static TemplateBundle a(ByteBuffer r7, a2 r8) {
        String r0 = r8.d;
        if (r7.isDirect() == true) goto L6;
        LLog.i("TemplateBundle", "TemplateBundle only supports DirectByteBuffer.");
        TemplateBundle r9 = new TemplateBundle();
        r9.f(0, r7.limit(), "TemplateBundle only supports DirectByteBuffer.", null);
        return r9;
    L6:
        TemplateBundle r10 = g(new TemplateBundle(), null, r7, r0, r8);
        r10.d(r8);
        return r10;
    }

    public static TemplateBundle c(byte[] r3, a2 r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r4 == null) goto L7;
        String r1 = r4.d;
    L8:
        TemplateBundle r5 = g(new TemplateBundle(), r3, null, r1, r4);
        r5.d(r4);
        return r5;
    L7:
        r1 = null;
        goto L8
    }

    private static TemplateBundle fromNative(long r7, ReadableMap r9) {
        if (r7 != 0) goto L5;
        String r0 = "native TemplateBundle doesn't exist";
    L6:
        String r5 = r0;
        TemplateBundle r1 = new TemplateBundle();
        r1.f(r7, 0, r5, r9);
        return r1;
    L5:
        r0 = null;
        goto L6
    }

    public final boolean e(byte[] r3, a2 r4) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (this.d == false) goto L7;
        return false;
    L7:
        if (r4 == null) goto L9;
        String r1 = r4.d;
    L10:
        g(this, r3, null, r1, r4);
        d(r4);
        return true;
    L9:
        r1 = null;
        goto L10
    }

    public final synchronized void f(long r2, int r4, String r5, ReadableMap r6) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.d == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.a = r2;     // Catch: Throwable -> L10
        this.c = r4;     // Catch: Throwable -> L10
        this.b = r5;     // Catch: Throwable -> L10
        this.e = new t1(r6);     // Catch: Throwable -> L10
        this.d = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public static TemplateBundle g(TemplateBundle r10, byte[] r11, ByteBuffer r12, String r13, a2 r14) {
        if (r10 != null) goto L5;
        r10 = new TemplateBundle();
    L5:
        if (r11 != null) goto L7;
        if (r12 != null) goto L7;
    L58:
        return r10;
    L7:
        if (r12 == null) goto L9;
        int r1 = r12.limit();
    L10:
        int r7 = r1;
        TraceEvent.beginSection("TemplateBundle.fromTemplate");
        LynxDevToolPool r9 = null;
    L59:
        th = th;
    L60:
        if (r9 == null) goto L62;
        r9.destroy();
    L62:
        TraceEvent.endSection("TemplateBundle.fromTemplate");
        throw th;
    L12:
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L54;
        ILynxSecurityService r2 = (ILynxSecurityService) i8a.n.c().a(ILynxSecurityService.class);     // Catch: Throwable -> L59
        if (r2 == null) goto L16;
        j8a.b r3 = r2.verifyTASM(r10, r11, r12, r13, ILynxSecurityService.LynxTasmType.TYPE_TEMPLATE);     // Catch: Throwable -> L59
    L18:
        if (r3.a == true) goto L23;
        r10.f(0, r7, "template verify failed, error message: " + r3.b, null);     // Catch: Throwable -> L59
        TraceEvent.endSection("TemplateBundle.fromTemplate");
        return r10;
    L23:
        if (r14 != null) goto L25;
    L27:
        boolean r4 = false;
    L28:
        if (r14 != null) goto L30;
    L32:
        boolean r15 = false;
    L34:
        if (LynxEnv.inst().isLynxDebugEnabled() == true) goto L36;
        LynxDevToolPool r16 = null;
    L65:
        Object[] r5 = new Object[2];     // Catch: Throwable -> L51
        if (r16 == null) goto L42;
        long r6 = r16.getNativePtr();     // Catch: Throwable -> L51
    L43:
        if (r12 == null) goto L45;
        long r17 = nativeParseTemplateFromByteBuffer(r12, r5, r15, r6);     // Catch: Throwable -> L51
    L46:
        r10.f(r17, r7, (String) r5[0], (ReadableMap) r5[1]);     // Catch: Throwable -> L51
        if (r10.i() == false) goto L50;
        r10.g = r16;     // Catch: Throwable -> L51
    L55:
        if (r9 == null) goto L57;
        r9.destroy();
    L57:
        TraceEvent.endSection("TemplateBundle.fromTemplate");
        goto L58
    L50:
        r9 = r16;
        goto L55
    L45:
        r17 = nativeParseTemplateFromByteArray(r11, r5, r15, r6);     // Catch: Throwable -> L51
        goto L46
    L42:
        r6 = 0;
    L51:
        th = th;
        r9 = r16;
        goto L60
    L36:
        r16 = new LynxDevToolPool(r13, r4);     // Catch: Throwable -> L59
        goto L65
    L30:
        if (r14.c == false) goto L32;
        r15 = true;
        goto L34
    L25:
        if (r14.e == false) goto L27;
        r4 = true;
        goto L28
    L16:
        r3 = j8a.b.b();     // Catch: Throwable -> L59
        goto L18
    L54:
        r10.f(0, r7, "Lynx Env is not prepared", null);     // Catch: Throwable -> L59
        goto L55
    L9:
        r1 = r11.length;
        goto L10
    }
}
