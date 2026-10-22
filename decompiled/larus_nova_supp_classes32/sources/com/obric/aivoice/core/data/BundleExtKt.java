package com.obric.aivoice.core.data;

import android.os.Bundle;
import android.os.SystemClock;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.AIVoiceManagerInner;
import com.obric.aivoice.sdk.AIVoiceConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0002\u001a'\u0010\n\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u000b*\u00020\u00022\u0006\u0010\f\u001a\u0002H\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0013\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u001a\u0010\u0015\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u001a\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001¨\u0006\u0019"}, d2 = {"getModelName", NameKeys.UnloadStrategy_No_Strategy, "Landroid/os/Bundle;", "getTaskId", NameKeys.UnloadStrategy_No_Strategy, "isError", NameKeys.UnloadStrategy_No_Strategy, "isFinish", "isSuccess", "isTaskId", "setBasicTypeRes", "T", LynxResourceModule.DATA_KEY, LynxResourceModule.CODE_KEY, NameKeys.UnloadStrategy_No_Strategy, "(Landroid/os/Bundle;Ljava/lang/Object;I)Landroid/os/Bundle;", "setBizCall", "bizName", "fromPkgName", "setGlobalCall", "methodName", "setModelCall", "modelName", "setSceneCall", "sceneName", "voicesdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BundleExtKt {
    public static final String getModelName(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getString(IdlKeys.Args_ModelName);
    }

    public static final long getTaskId(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.getLong(IdlKeys.Result);
    }

    public static final boolean isError(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return !isSuccess(r1);
    }

    public static final boolean isFinish(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.getBoolean(IdlKeys.IsFinish, true);
    }

    public static final boolean isSuccess(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r3 = r2.getInt(IdlKeys.ErrorCode, 0);
        if (r3 == 0) goto L5;
        if (r3 == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static final boolean isTaskId(Bundle r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getBoolean(IdlKeys.IsTaskId);
    }

    public static final Bundle setGlobalCall(Bundle r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "methodName");
        r3.putLong(IdlKeys.Args_Time, SystemClock.elapsedRealtime());
        r3.putString(IdlKeys.Call_Type, IdlKeys.Call_Type_CallGlobal);
        r3.putString(IdlKeys.MethodName, r4);
        AIVoiceConfig r5 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r5 == null) goto L5;
        r3.putLong(IdlKeys.Args_ProjectId, r5.getProjectId());
        r3.putLong(IdlKeys.Args_AppId, r5.getAppId());
        r3.putString(IdlKeys.Args_PackageName, r5.getPackageName());
    L5:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Bundle setBasicTypeRes(Bundle r2, T r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.putInt(IdlKeys.ErrorCode, r4);
        r2.putString(IdlKeys.ErrorInfo, null);
        boolean r0 = true;
        if (r4 != 1) goto L6;
        r0 = false;
    L6:
        r2.putBoolean(IdlKeys.IsFinish, r0);
        if ((r3 instanceof Integer) == false) goto L10;
        r2.putInt(IdlKeys.Result, ((Number) r3).intValue());
    L39:
        return r2;
    L10:
        if ((r3 instanceof int[]) == false) goto L13;
        r2.putIntArray(IdlKeys.Result, (int[]) r3);
        goto L39
    L13:
        if ((r3 instanceof Float) == false) goto L16;
        r2.putFloat(IdlKeys.Result, ((Number) r3).floatValue());
        goto L39
    L16:
        if ((r3 instanceof float[]) == false) goto L19;
        r2.putFloatArray(IdlKeys.Result, (float[]) r3);
        goto L39
    L19:
        if ((r3 instanceof String) == false) goto L22;
        r2.putString(IdlKeys.Result, (String) r3);
        goto L39
    L22:
        if ((r3 instanceof Byte) == false) goto L25;
        r2.putByte(IdlKeys.Result, ((Number) r3).byteValue());
        goto L39
    L25:
        if ((r3 instanceof byte[]) == false) goto L28;
        r2.putByteArray(IdlKeys.Result, (byte[]) r3);
        goto L39
    L28:
        if ((r3 instanceof Character) == false) goto L31;
        r2.putChar(IdlKeys.Result, ((Character) r3).charValue());
        goto L39
    L31:
        if ((r3 instanceof char[]) == false) goto L34;
        r2.putCharArray(IdlKeys.Result, (char[]) r3);
        goto L39
    L34:
        if ((r3 instanceof Boolean) == false) goto L37;
        r2.putBoolean(IdlKeys.Result, ((Boolean) r3).booleanValue());
        goto L39
    L37:
        if ((r3 instanceof boolean[]) == false) goto L39;
        r2.putBooleanArray(IdlKeys.Result, (boolean[]) r3);
        goto L39
    }

    public static final Bundle setBizCall(Bundle r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "bizName");
        r2.putString(IdlKeys.Call_Type, IdlKeys.Call_Type_CallBiz);
        r2.putString(IdlKeys.MethodName, IdlKeys.Method_RunBiz);
        r2.putString(IdlKeys.Args_BizName, r3);
        r2.putString(IdlKeys.Args_PackageName, r4);
        return r2;
    }

    public static final Bundle setModelCall(Bundle r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "modelName");
        Intrinsics.checkNotNullParameter(r6, "methodName");
        r4.putLong(IdlKeys.Args_Time, SystemClock.elapsedRealtime());
        r4.putString(IdlKeys.Call_Type, IdlKeys.Call_Type_CallModel);
        AIVoiceConfig r0 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r0 == null) goto L5;
        r4.putLong(IdlKeys.Args_ProjectId, r0.getProjectId());
        r4.putLong(IdlKeys.Args_AppId, r0.getAppId());
        r4.putString(IdlKeys.Args_PackageName, r0.getPackageName());
    L5:
        r4.putString(IdlKeys.Args_ModelName, r5);
        r4.putString(IdlKeys.MethodName, r6);
        return r4;
    }

    public static final Bundle setSceneCall(Bundle r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "sceneName");
        Intrinsics.checkNotNullParameter(r6, "methodName");
        r4.putString(IdlKeys.Call_Type, IdlKeys.Call_Type_CallScene);
        AIVoiceConfig r0 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r0 == null) goto L5;
        r4.putLong(IdlKeys.Args_ProjectId, r0.getProjectId());
        r4.putLong(IdlKeys.Args_AppId, r0.getAppId());
        r4.putString(IdlKeys.Args_PackageName, r0.getPackageName());
    L5:
        r4.putString(IdlKeys.Args_ModelScene, r5);
        r4.putString(IdlKeys.MethodName, r6);
        return r4;
    }

    public static /* synthetic */ Bundle setBasicTypeRes$default(Bundle r0, Object r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return setBasicTypeRes(r0, r1, r2);
    }

    public static /* synthetic */ Bundle setBizCall$default(Bundle r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L9;
        AIVoiceConfig r5 = AIVoiceManagerInner.INSTANCE.getAiVoiceConfig();
        if (r5 == null) goto L7;
        r2 = r5.getPackageName();
        goto L9
    L7:
        r2 = null;
    L9:
        return setBizCall(r0, r1, r2);
    }
}
