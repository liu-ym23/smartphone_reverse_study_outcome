package com.obric.sva.sdk.ahm;

import android.os.Binder;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import vendor.bytedance.hardware.ahm.IAHMCallbackIDL;
import yna.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/sva/sdk/ahm/AhmCallback;", "Lvendor/bytedance/hardware/ahm/IAHMCallbackIDL$Stub;", "<init>", "()V", "setVendorStability", "", "submitBuffer", "buffer", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class AhmCallback extends IAHMCallbackIDL.Stub {
    public static /* synthetic */ void a(AhmCallback r0, byte[] r1) {
        submitBuffer$lambda$5(r0, r1);
    }

    public final void setVendorStability() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Method r3 = Binder.class.getDeclaredMethod("markVintfStability", new Class[0]);     // Catch: Throwable -> L5
        r3.setAccessible(true);     // Catch: Throwable -> L5
        r3.invoke(this, new Object[0]);     // Catch: Throwable -> L5
        LogUtils.i(AhmClient.TAG, "markVintfStability finish", new Object[0]);     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L13;
        LogUtils.i(AhmClient.TAG, "stability error: " + r5.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public AhmCallback() {
        setVendorStability();
    }

    @Override // vendor.bytedance.hardware.ahm.IAHMCallbackIDL
    public void submitBuffer(byte[] r3) {
        if (r3 != null) goto L5;
        LogUtils.i(AhmClient.TAG, "buffer is null", new Object[0]);
        return;
    L5:
        AhmSlardarLogger.INSTANCE.getSingleExecutor$libs_mainlandRelease().execute(new a(this, r3));
    }

    private static final void submitBuffer$lambda$5(AhmCallback r4, byte[] r5) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        LogUtils.i(AhmClient.TAG, "buffer.size>>>>:" + r5.length, new Object[0]);     // Catch: Throwable -> L9
        String r6 = MediaMetricsItemParser.extractJsonData(r5);     // Catch: Throwable -> L9
        LogUtils.i(AhmClient.TAG, "buffer.data>>>>: " + r6, new Object[0]);     // Catch: Throwable -> L9
        if (r6 == null) goto L6;
        AhmSlardarLogger r0 = AhmSlardarLogger.INSTANCE;     // Catch: Throwable -> L9
        r0.monitorEventForTeaAndSlardar(r6);     // Catch: Throwable -> L9
        r0.monitorEventForFaultTree(r6);     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L17;
        LogUtils.e(AhmClient.TAG, "Error processing buffer: " + r8.getMessage(), new Object[0]);
        return;
    L17:
        return;
    L6:
        LogUtils.w(AhmClient.TAG, "Failed to extract valid payload from buffer", new Object[0]);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
