package com.bytedance.lynx.service.security;

import android.content.Context;
import androidx.annotation.Keep;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.h;
import com.lynx.tasm.service.security.ILynxSecurityService;
import java.nio.ByteBuffer;
import ko.l;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004JD\u0010\u0011\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0082 ¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0082 ¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b!\u0010\"J?\u0010)\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\f8\u0006X\u0086D¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010/¨\u00062"}, d2 = {"Lcom/bytedance/lynx/service/security/LynxSecurityService;", "Lcom/lynx/tasm/service/security/ILynxSecurityService;", "Lko/l;", "<init>", "()V", "", "template", "Ljava/nio/ByteBuffer;", "buffer", "", "signIdBuffer", "", "", "extras", "", "errorCodeBuffer", "", "nativeVerifySignBlock", "([BLjava/nio/ByteBuffer;[J[Ljava/lang/String;[I)Z", "publicKeys", "nativeUpdateRsaPublicKeys", "(Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "", "onInitialize", "(Landroid/content/Context;)V", "doInitialize", "()Z", "Lcom/bytedance/lynx/service/security/a;", "delegate", "setSecurityDelegate", "(Lcom/bytedance/lynx/service/security/a;)V", "updateRSAPublicKeys", "(Ljava/lang/String;)V", "Lcom/lynx/tasm/LynxView;", "lynxView", "url", "Lcom/lynx/tasm/service/security/ILynxSecurityService$LynxTasmType;", "type", "Llo/a;", "verifyTASM", "(Lcom/lynx/tasm/LynxView;[BLjava/nio/ByteBuffer;Ljava/lang/String;Lcom/lynx/tasm/service/security/ILynxSecurityService$LynxTasmType;)Llo/a;", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lcom/bytedance/lynx/service/security/a;", "Companion", "com/bytedance/lynx/service/security/b", "LynxSecurityService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxSecurityService extends l implements ILynxSecurityService {
    public static final b Companion = null;
    private static final Lazy<LynxSecurityService> INSTANCE$delegate = null;
    private final String TAG;
    private a delegate;

    static {
        Companion = new b();
        INSTANCE$delegate = LazyKt.lazy(LynxSecurityService$Companion$INSTANCE$2.f6861a);
    }

    public LynxSecurityService() {
        this.TAG = "LynxSecurityService";
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$delegate$cp() {
        return INSTANCE$delegate;
    }

    private final native boolean nativeUpdateRsaPublicKeys(String r5);

    private final native boolean nativeVerifySignBlock(byte[] r5, ByteBuffer r10, long[] r11, String[] r12, int[] r13);

    @Override // ko.l
    public boolean doInitialize() {
        h r5 = LynxEnv.inst().getLibraryLoader();     // Catch: UnsatisfiedLinkError -> L7 Exception -> L9
        if (r5 == null) goto L11;
        r5.a("lynxsecurity");     // Catch: UnsatisfiedLinkError -> L7 Exception -> L9
        Unit r10 = Unit.INSTANCE;     // Catch: UnsatisfiedLinkError -> L7 Exception -> L9
    L12:
        if (r10 != null) goto L22;
        System.loadLibrary("lynxsecurity");     // Catch: UnsatisfiedLinkError -> L7 Exception -> L9
        return true;
    L22:
        return true;
    L11:
        r10 = null;
    L9:
        e = move-exception;
        LynxLog.b(4, this.TAG, "fail to load lynxsecurity.so, error message is: " + e);
        return false;
    L7:
        e = move-exception;
        LynxLog.b(4, this.TAG, "fail to load lynxsecurity.so, error message is: " + e);
        return false;
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public void onInitialize(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        initialize();
    }

    public final void setSecurityDelegate(a r5) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
    }

    public final void updateRSAPublicKeys(String r5) {
        Intrinsics.checkNotNullParameter(r5, "publicKeys");
        if (ensureInitialized() == true) goto L6;
        LynxLog.b(4, "LynxSecurityService", "lynxsecurity.so load failed.");
        return;
    L6:
        nativeUpdateRsaPublicKeys(r5);
    }

    @Override // com.lynx.tasm.service.security.ILynxSecurityService
    public lo.a verifyTASM(LynxView r5, byte[] r10, ByteBuffer r11, String r12, ILynxSecurityService.LynxTasmType r13) {
        Intrinsics.checkNotNullParameter(r13, "type");
        if (ensureInitialized() == true) goto L6;
        LynxLog.b(4, this.TAG, "lynxsecurity.so load failed");
        lo.a r14 = new lo.a();
        r14.f19688a = true;
        return r14;
    L6:
        if (r10 != null) goto L10;
        if (r11 != null) goto L10;
        lo.a r15 = new lo.a();
        r15.f19688a = false;
        r15.f19689b = "empty tasm file.";
        return r15;
    L10:
        lo.a r16 = new lo.a();
        r16.f19688a = true;
        return r16;
    }
}
