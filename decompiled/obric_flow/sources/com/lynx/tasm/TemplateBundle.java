package com.lynx.tasm;

import android.text.TextUtils;
import com.lynx.jsbridge.LynxBytecodeCallback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.service.security.ILynxSecurityService;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class TemplateBundle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10053c;
    public final u0 d;

    public TemplateBundle(long r5, int r10, String r11, ReadableMap r12) {
        this.f10051a = r5;
        this.f10053c = r10;
        this.f10052b = r11;
        this.d = new u0(r12);
    }

    public static TemplateBundle a(byte[] r13) {
        if (r13 != null) goto L5;
        return null;
    L5:
        int r5 = r13.length;
        TraceEvent.c("TemplateBundle.fromTemplate");
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L16;
        ILynxSecurityService r10 = (ILynxSecurityService) ko.r.g().e(ILynxSecurityService.class);
        if (r10 == null) goto L10;
        lo.a r11 = r10.verifyTASM(null, r13, null, null, ILynxSecurityService.LynxTasmType.f10958a);
    L12:
        if (r11.f19688a == false) goto L14;
        Object[] r12 = new Object[2];
        TemplateBundle r14 = new TemplateBundle(nativeParseTemplateFromByteArray(r13, r12), r5, (String) r12[0], (ReadableMap) r12[1]);
    L17:
        TraceEvent.a(0, "TemplateBundle.fromTemplate");
        return r14;
    L14:
        return new TemplateBundle(0, r13.length, "template verify failed, error message: " + r11.f19689b, null);
    L10:
        r11 = new lo.a();
        r11.f19688a = true;
        goto L12
    L16:
        r14 = new TemplateBundle(0, r5, "Lynx Env is not prepared", null);
        goto L17
    }

    @CalledByNative
    private static Object decodeByteBuffer(ByteBuffer r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        return kn.b.a(r5);
    }

    @CalledByNative
    private static TemplateBundle fromNative(long r10, ReadableMap r11) {
        if (r10 != 0) goto L6;
        String r5 = "native TemplateBundle doesn't exist";
    L8:
        return new TemplateBundle(r10, 0, r5, r11);
    L6:
        r5 = null;
        goto L8
    }

    private static native boolean nativeConstructContext(long r5, int r10);

    private static native boolean nativeGetContainsElementTree(long r5);

    private static native Object nativeGetExtraInfo(long r5);

    private static native void nativeInitWithOption(long r5, int r10, boolean r11);

    private static native long nativeParseTemplateFromByteArray(byte[] r5, Object[] r10);

    private static native long nativeParseTemplateFromByteBuffer(ByteBuffer r5, Object[] r10);

    private static native void nativePostJsCacheGenerationTask(long r5, String r10, boolean r11, LynxBytecodeCallback r12);

    private static native void nativeReleaseBundle(long r5);

    public final void b(String r5) {
        if (d() == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L10;
        nativePostJsCacheGenerationTask(this.f10051a, r5, false, null);
        return;
    }

    public final boolean c() {
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L5;
        return false;
    L5:
        if (d() == true) goto L7;
        return false;
    L7:
        return nativeGetContainsElementTree(this.f10051a);
    }

    public final boolean d() {
        if (this.f10051a == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final void e() {
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L8;
        long r5 = this.f10051a;
        if (r5 == 0) goto L9;
        nativeReleaseBundle(r5);
        this.f10051a = 0;
        return;
    L9:
        return;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L15:
        return false;
    L8:
        if (TemplateBundle.class != r10.getClass()) goto L15;
        TemplateBundle r11 = (TemplateBundle) r10;
        if (this.f10051a != r11.f10051a) goto L15;
        if (this.f10053c != r11.f10053c) goto L15;
        return true;
    }

    public final void finalize() {
        e();
    }
}
