package com.bytedance.lynx.service.log;

import android.util.Log;
import androidx.annotation.Keep;
import com.lynx.tasm.service.ILynxLogService;
import com.lynx.tasm.utils.e;
import com.ss.android.agilelogger.ALog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xs.b;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/lynx/service/log/LynxLogService;", "Lcom/lynx/tasm/service/ILynxLogService;", "<init>", "()V", "", "functionName", "", "getALogNativeFunctionAddress", "(Ljava/lang/String;)J", "", "level", "tag", "msg", "", "logByPlatform", "(ILjava/lang/String;Ljava/lang/String;)V", "", "isLogOutputByPlatform", "()Z", "getDefaultWriteFunction", "()J", "enableSystemLog", "switchLogToSystem", "(Z)V", "getLogToSystemStatus", "Lcom/lynx/tasm/service/ILynxLogService$LogOutputChannelType;", "logOutputChannel", "Lcom/lynx/tasm/service/ILynxLogService$LogOutputChannelType;", "Companion", "com/bytedance/lynx/service/log/a", "LynxLogService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxLogService implements ILynxLogService {
    public static final a Companion = null;
    private static final Lazy<LynxLogService> INSTANCE$delegate = null;
    private ILynxLogService.LogOutputChannelType logOutputChannel;

    static {
        Companion = new a();
        INSTANCE$delegate = LazyKt.lazy(LynxLogService$Companion$INSTANCE$2.f6826a);
    }

    public LynxLogService() {
        this.logOutputChannel = ILynxLogService.LogOutputChannelType.f10955a;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$delegate$cp() {
        return INSTANCE$delegate;
    }

    private final long getALogNativeFunctionAddress(String r5) {
        b r10 = ALog.sConfig;     // Catch: Exception -> L6
        Method r11 = ALog.class.getDeclaredMethod(r5, null);     // Catch: Exception -> L6
        r11.setAccessible(true);     // Catch: Exception -> L6
        Object r12 = r11.invoke(null, null);     // Catch: Exception -> L6
        if (r12 == null) goto L9;
        return ((Long) r12).longValue();
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");     // Catch: Exception -> L6
    L6:
        e = move-exception;
        String r13 = androidx.room.jarjarred.org.antlr.runtime.a.o(e, e.b("The ALog ", r5, " function was not successfully retrieved [ "));
        if (r13 != null) goto L13;
        r13 = " ]";
    L13:
        Log.e("lynx", r13);
        return 0;
    }

    @Override // com.lynx.tasm.service.ILynxLogService
    public long getDefaultWriteFunction() {
        return getALogNativeFunctionAddress("getALogSimpleWriteFuncAddr");
    }

    @Override // com.lynx.tasm.service.ILynxLogService
    public boolean getLogToSystemStatus() {
        b r5 = ALog.sConfig;     // Catch: NoSuchMethodException -> L4 IllegalAccessException -> L6 ClassNotFoundException -> L8
        Field r10 = ALog.class.getDeclaredField("sDebug");     // Catch: NoSuchMethodException -> L4 IllegalAccessException -> L6 ClassNotFoundException -> L8
        r10.setAccessible(true);     // Catch: NoSuchMethodException -> L4 IllegalAccessException -> L6 ClassNotFoundException -> L8
        return r10.getBoolean(ALog.class);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxLogService
    public boolean isLogOutputByPlatform() {
        if (this.logOutputChannel != ILynxLogService.LogOutputChannelType.f10956b) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.lynx.tasm.service.ILynxLogService
    public void logByPlatform(int r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
    }

    @Override // com.lynx.tasm.service.ILynxLogService
    public void switchLogToSystem(boolean r5) {
        b r10 = ALog.sConfig;     // Catch: InvocationTargetException -> L4 NoSuchMethodException -> L6 IllegalAccessException -> L8 ClassNotFoundException -> L10
        ALog.class.getMethod("setDebug", new Class[]{Boolean.TYPE}).invoke(null, new Object[]{Boolean.valueOf(r5)});     // Catch: InvocationTargetException -> L4 NoSuchMethodException -> L6 IllegalAccessException -> L8 ClassNotFoundException -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
