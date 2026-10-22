package com.mammon.samicorenui;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SAMICoreNuiEngine {
    private native int Native_createAsrContext(long r1, Object r3);

    private native int Native_createVadWithJson(long r1, String r3);

    private native int Native_initEngine(long r1, String r3);

    public native long Native_createEngine();

    public native void Native_destroyEngine(long r1);

    public native int Native_resetVad(long r1);

    public native int Native_sendAudioData(long r1, byte[] r3, int r4);

    public native int Native_sendAudioDataWithRef(long r1, byte[] r3, int r4, byte[] r5, int r6);

    public native int Native_sendDirective(long r1, int r3, String r4);

    public native int Native_setParameterBool(long r1, int r3, boolean r4);

    public native int Native_setParameterByteArray(long r1, int r3, byte[] r4);

    public native int Native_setParameterFloat(long r1, int r3, float r4);

    public native int Native_setParameterInt(long r1, int r3, int r4);

    public native int Native_setParameterString(long r1, int r3, String r4);

    public native int Native_setParameterString(long r1, String r3, String r4);

    static {
        Intrinsics.checkNotNullParameter(BuildConfig.LIBNAME, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> audioeffect");
        a.c(BuildConfig.LIBNAME);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> audioeffect");
    }

    public SAMICoreNuiEngine() {
    }
}
