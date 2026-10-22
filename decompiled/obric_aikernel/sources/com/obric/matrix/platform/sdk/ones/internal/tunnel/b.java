package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.annotation.SuppressLint;
import android.content.Context;
import com.obric.matrix.platform.sdk.ones.internal.config.SdkConfigManager;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.SdkAllConfig;
import com.obric.matrix.proto.SdkSendCmdConfig;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"CheckResult"})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5893a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f5894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashSet<Integer> f5895c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<Integer> f5896d;

    static {
        f5893a = new b();
        f5894b = 35;
        f5895c = SetsKt.hashSetOf(new Integer[]{Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK.getValue()), Integer.valueOf(MATRIX_CMD.CMD_PRIVATE_START_PICO_LINKS.getValue())});
        f5896d = CollectionsKt.listOf(Integer.valueOf(MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue()));
        new HashSet();
    }

    private b() {
    }

    public static /* synthetic */ void a() {
        d();
    }

    public static final /* synthetic */ void b(b r10, int r11, xb.i r12, z8.e r13, int r14, String r15) {
        r10.c(r11, r12, r13, r14, r15);
    }

    private final void c(int r10, xb.i<Pair<Integer, Response>> r11, z8.e r12, int r13, String r14) {
        String r15 = null;
        e9.b.b("CmdManager", "handleBinderCallFail, errorCode: " + r13 + ", errorMsg: " + r14, null, 4, null);
        Response r16 = new Response.a().i(Integer.valueOf(r13)).e(r14).c();
        d9.a r17 = d9.a.f8514a;
        Context r18 = z8.c.f13804a.e();
        if (r18 == null) goto L5;
        r15 = r18.getPackageName();
    L5:
        if (r15 != null) goto L7;
        String r19 = "";
    L8:
        Intrinsics.checkNotNullExpressionValue(r16, "response");
        r17.b(r10, 1, r19, r16, null);
        if (r11 == null) goto L11;
        r11.onSuccess(new Pair(Integer.valueOf(r10), r16));
    L11:
        if (r12 == null) goto L14;
        r12.a(r10, r16);
        return;
    L14:
        return;
    L7:
        r19 = r15;
        goto L8
    }

    private static final void d() {
        f5893a.f();
        d r10 = new d();
        e9.b.b("CmdManager", "call on bind default  " + z8.c.f13804a.d() + " onbinder " + r10 + ' ', null, 4, null);
        i.f5899a.g(r10);
    }

    public final void e() {
        r1.c.b(a.f5892c);
    }

    public final void f() {
        if (z8.c.f13804a.e() != null) goto L6;
        e9.b.b("CmdManager", "updateConfig, context is null", null, 4, null);
        return;
    L6:
        e9.b.b("CmdManager", "start update cmd config", null, 4, null);
        SdkAllConfig r10 = SdkConfigManager.f5883a.c();
        if (r10 == null) goto L9;
        SdkSendCmdConfig r11 = r10.sdkSendCmdConfig;
    L10:
        if (r11 == null) goto L27;
        Integer r12 = r11.sendCmdTimeout;
        Intrinsics.checkNotNullExpressionValue(r12, "it.sendCmdTimeout");
        if (r12.intValue() <= 0) goto L14;
        Integer r13 = r11.sendCmdTimeout;
        Intrinsics.checkNotNullExpressionValue(r13, "it.sendCmdTimeout");
        f5894b = r13.intValue();
        e9.b.b("CmdManager", "update config sendCmdTimeout = " + f5894b, null, 4, null);
    L14:
        List<Integer> r14 = r11.useBindCmd;
        if (r14 != null) goto L17;
    L20:
        boolean r15 = true;
    L21:
        if (r15 == true) goto L23;
        List<Integer> r16 = r11.useBindCmd;
        Intrinsics.checkNotNullExpressionValue(r16, "it.useBindCmd");
        f5896d = r16;
    L23:
        List<Integer> r17 = r11.forceUseOldBindCmd;
        if (r17 == null) goto L28;
        Intrinsics.checkNotNullExpressionValue(r17, "forceUseOldBindCmd");
        HashSet<Integer> r18 = f5895c;
        r18.addAll(r17);
        e9.b.b("CmdManager", "update forceUseOldBindCmd " + r18, null, 4, null);
        return;
    L28:
        return;
    L17:
        if (r14.isEmpty() == true) goto L20;
        r15 = false;
        goto L21
    L27:
        return;
    L9:
        r11 = null;
        goto L10
    }
}
