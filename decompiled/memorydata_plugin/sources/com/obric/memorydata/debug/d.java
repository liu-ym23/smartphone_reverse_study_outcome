package com.obric.memorydata.debug;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\u0006\u001a0\u0010\u0007\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0000\u001a\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH\u0000¨\u0006\u000e"}, d2 = {"decodeAiProactiveAdbEnabled", "", "rawEnabled", "", "channel", "", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Boolean;", "executeAiProactiveAdbCommand", "Lcom/obric/memorydata/debug/AiProactiveAdbCommandStatus;", "updateWakeUpEnabled", "Lkotlin/Function1;", "", "aiProactiveAdbCommandStatusJson", "status", "app_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class d {
    public static final AiProactiveAdbCommandStatus a(Object r2, String r3, Function1<? super Boolean, Unit> r4) {
        Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "channel");
        Boolean r6 = a(r2, r3);
        if (r6 == null) goto L13;
        boolean r7 = r6.booleanValue();
        if (r5 == null) goto L7;
        r5.invoke(Boolean.valueOf(r7));     // Catch: Exception -> L10
        return AiProactiveAdbCommandStatus.SUCCESS;
    L11:
        return AiProactiveAdbCommandStatus.FAILURE;
    L7:
        return AiProactiveAdbCommandStatus.FAILURE;
    L13:
        return AiProactiveAdbCommandStatus.UNSUPPORTED;
    }

    public static final Boolean a(Object r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "channel");
        if (ZeusTransformUtils.instanceOf(r3, Boolean.class) == false) goto L5;
        Boolean r5 = (Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 == null) goto L17;
        r5.booleanValue();
        if (Intrinsics.areEqual(r4, "auto_test") == false) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == true) goto L16;
        return null;
    L16:
        return r5;
    L10:
        if (Intrinsics.areEqual(r4, "local_test") == true) goto L13;
        r6 = false;
        goto L14
    L17:
        return null;
    L5:
        r5 = null;
        goto L6
    }

    public static final String a(AiProactiveAdbCommandStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        String r3 = new JSONObject().put("status", r2.getValue()).toString();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        return r3;
    }
}
