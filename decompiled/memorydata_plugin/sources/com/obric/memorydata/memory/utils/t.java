package com.obric.memorydata.memory.utils;

import android.content.ComponentName;
import android.graphics.Bitmap;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.sdk.screencapture.ViewTreeNode;
import com.obric.memorydata.utils.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u008c\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/utils/SmartMemoryUtils;", "", "<init>", "()V", "takeSmartMemory", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "appName", "screenshot", "Landroid/graphics/Bitmap;", "type", "viewTrees", "", "Lcom/obric/memorydata/sdk/screencapture/ViewTreeNode;", "useCloudModel", "", "pageContextCaptureDisabled", "sourceActivity", "Landroid/content/ComponentName;", "pageContextHandle", "Lcom/obric/memorydata/dc/PageContextHandle;", "buildControl", "Lcom/obric/memorydata/memory/llm/MemoryBuildControl;", "inAppAssociation", "Lcom/obric/memorydata/memory/memoryentity/InAppMemoryAssociation;", "logContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/util/List;ZZLandroid/content/ComponentName;Lcom/obric/memorydata/dc/PageContextHandle;Lcom/obric/memorydata/memory/llm/MemoryBuildControl;Lcom/obric/memorydata/memory/memoryentity/InAppMemoryAssociation;Lcom/obric/memorydata/middleware/api/logging/LogContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canBuildSmartMemory", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f11563a = null;

    static {
        f11563a = new t();
    }

    private t() {
    }

    public static /* synthetic */ Object a(t r17, String r18, String r19, Bitmap r20, String r21, List r22, boolean r23, boolean r24, ComponentName r25, com.obric.memorydata.dc.a r26, com.obric.memorydata.memory.llm.c r27, com.obric.memorydata.memory.memoryentity.b r28, com.obric.memorydata.middleware.api.logging.e r29, Continuation r30, int r31, Object r32) {
        List<ViewTreeNode> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r30, Continuation.class, "com.obric.memorydata.plugin");
        if ((r31 & 16) == 0) goto L5;
        List<ViewTreeNode> r8 = null;
    L7:
        if ((r31 & 32) == 0) goto L9;
        boolean r9 = false;
    L11:
        if ((r31 & 64) == 0) goto L13;
        boolean r10 = false;
    L15:
        if ((r31 & 128) == 0) goto L17;
        ComponentName r11 = null;
    L19:
        if ((r31 & 256) == 0) goto L21;
        com.obric.memorydata.dc.a r12 = null;
    L23:
        if ((r31 & 512) == 0) goto L25;
        com.obric.memorydata.memory.llm.c r13 = null;
    L27:
        if ((r31 & 1024) == 0) goto L29;
        com.obric.memorydata.memory.memoryentity.b r14 = null;
    L31:
        return r17.a(r18, r19, r20, r21, r8, r9, r10, r11, r12, r13, r14, r29, r16);
    L29:
        r14 = r28;
        goto L31
    L25:
        r13 = r27;
        goto L27
    L21:
        r12 = r26;
        goto L23
    L17:
        r11 = r25;
        goto L19
    L13:
        r10 = r24;
        goto L15
    L9:
        r9 = r23;
        goto L11
    L5:
        r8 = r1;
        goto L7
    }

    private static final Unit a(com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$mainTrace");
        r2.a(InfoRequestQPSOptTraceLogger.REASON, "enterprise_account");
        return Unit.INSTANCE;
    }

    private static final Unit a(boolean r2, String r3, List r4, boolean r5, com.obric.memorydata.middleware.api.logging.g r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "$this$mainTrace");
        if (r2 == false) goto L5;
        String r8 = "cloud";
    L6:
        r6.a("route", r8);
        r6.a("rule_type", r3);
        if (r7 == null) goto L9;
        Object r9 = Integer.valueOf(r7.size());
    L10:
        r6.a("view_tree_count", r9);
        r6.a("page_context_enabled", Boolean.valueOf(!r5));
        return Unit.INSTANCE;
    L9:
        r9 = "null";
        goto L10
    L5:
        r8 = "client";
        goto L6
    }

    private final boolean a(com.obric.memorydata.middleware.api.logging.e r16) {
        com.obric.memorydata.middleware.api.logging.e r11 = com.obric.memorydata.middleware.api.logging.e.a(r16, null, null, "trigger", 3, null);
        if (UserSettings.INSTANCE.isEnterpriseAccount() == false) goto L7;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.t.f11635a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "自动记忆已跳过企业账号", "operation_skipped", r11, $$Lambda$t$zpn01c39JjP9gINJAYhJDJMwMPQ.INSTANCE, null, 16, null);
        return false;
    L7:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L10;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.t.f11635a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "自动记忆因隐私或登录状态不可用而终止", "build_blocked", "privacy_or_login_unavailable", null, r11, null, 40, null);
        return false;
    L10:
        return true;
    }

    public static /* synthetic */ Unit lambda$7pI1yG2fRM87550KGDtEy82ZEZY(boolean r0, String r1, List r2, boolean r3, com.obric.memorydata.middleware.api.logging.g r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$zpn01c39JjP9gINJAYhJDJMwMPQ(com.obric.memorydata.middleware.api.logging.g r0) {
        return a(r0);
    }

    public final Object a(String r55, String r56, Bitmap r57, String r58, List<ViewTreeNode> r59, boolean r60, boolean r61, ComponentName r62, com.obric.memorydata.dc.a r63, com.obric.memorydata.memory.llm.c r64, com.obric.memorydata.memory.memoryentity.b r65, com.obric.memorydata.middleware.api.logging.e r66, Continuation<? super Unit> r67) {
        final String r1 = r58;
        final boolean r2 = r60;
        final boolean r3 = r61;
        com.obric.memorydata.middleware.api.logging.e r10 = r66;
        final List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r59, List.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r67, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SmartMemoryUtils$takeSmartMemory$1.class) == false) goto L7;
        SmartMemoryUtils$takeSmartMemory$1 r5 = (SmartMemoryUtils$takeSmartMemory$1) ZeusTransformUtils.preCheckCast(r4, SmartMemoryUtils$takeSmartMemory$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        SmartMemoryUtils$takeSmartMemory$1 r15 = r5;
        Object r6 = r15.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r15.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        boolean r0 = r15.Z$1;
        boolean r8 = r15.Z$0;
        ComponentName r9 = (ComponentName) ZeusTransformUtils.preCheckCast(r15.L$8, ComponentName.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r11 = (com.obric.memorydata.middleware.api.logging.e) ZeusTransformUtils.preCheckCast(r15.L$7, com.obric.memorydata.middleware.api.logging.e.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.memoryentity.b r13 = (com.obric.memorydata.memory.memoryentity.b) ZeusTransformUtils.preCheckCast(r15.L$6, com.obric.memorydata.memory.memoryentity.b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.llm.c r16 = (com.obric.memorydata.memory.llm.c) ZeusTransformUtils.preCheckCast(r15.L$5, com.obric.memorydata.memory.llm.c.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.dc.a r17 = (com.obric.memorydata.dc.a) ZeusTransformUtils.preCheckCast(r15.L$4, com.obric.memorydata.dc.a.class, "com.obric.memorydata.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r15.L$3, String.class, "com.obric.memorydata.plugin");
        Bitmap r19 = (Bitmap) ZeusTransformUtils.preCheckCast(r15.L$2, Bitmap.class, "com.obric.memorydata.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r15.L$1, String.class, "com.obric.memorydata.plugin");
        String r111 = (String) ZeusTransformUtils.preCheckCast(r15.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        r3 = r0;
        ComponentName r20 = r9;
        r2 = r8;
        r1 = r18;
        Bitmap r21 = r19;
        com.obric.memorydata.dc.a r22 = r17;
        String r23 = r110;
        r10 = r11;
        com.obric.memorydata.memory.llm.c r112 = r16;
        String r24 = r111;
    L28:
        ComponentName r32 = r20;
        String r33 = r1;
        boolean r34 = r3;
        FileEntity r30 = (FileEntity) ZeusTransformUtils.preCheckCast(r6, FileEntity.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.memoryentity.b r45 = r13;
        String r26 = r24;
        String r27 = r23;
        Bitmap r28 = r21;
        com.obric.memorydata.dc.a r43 = r22;
        com.obric.memorydata.middleware.api.logging.e r41 = r10;
        com.obric.memorydata.memory.llm.c r44 = r112;
    L29:
        com.obric.memorydata.memory.memoryentity.f r25 = new com.obric.memorydata.memory.memoryentity.f(5, r26, r27, r28, null, r30, null, r32, r33, r34, null, null, null, null, null, null, r41, true, r43, r44, r45, null, 0.0f, 0, 14744576, null);
        if (r2 == false) goto L32;
        Object r29 = new com.obric.memorydata.memory.tracker.g.b(5, false, System.currentTimeMillis());
        com.obric.memorydata.memory.e.a r31 = com.obric.memorydata.memory.e.a.f10116b.a(0);
    L33:
        com.obric.memorydata.memory.e.a.b.a(r31, (com.obric.memorydata.memory.e.b) ZeusTransformUtils.preCheckCast(r29, com.obric.memorydata.memory.e.b.class, "com.obric.memorydata.plugin"), r25, false, 4, null);
        return Unit.INSTANCE;
    L32:
        r29 = com.obric.memorydata.memory.tracker.c.f10533a.a(2);
        r31 = com.obric.memorydata.memory.e.a.f10116b.a(1);
        goto L33
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        if (a(r10) == false) goto L17;
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.t.f11635a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "自动记忆构建开始", "route_started", com.obric.memorydata.middleware.api.logging.e.a(r66, null, null, "route", 3, null), new $$Lambda$t$7pI1yG2fRM87550KGDtEy82ZEZY(r2, r1, r12, r3), null, 16, null);
        if (r62 != null) goto L21;
        r20 = ba.a();
    L22:
        if (r2 == false) goto L24;
        r26 = r55;
        r27 = r56;
        r28 = r57;
        r43 = r63;
        r44 = r64;
        r45 = r65;
        r32 = r20;
        r33 = r1;
        r34 = r3;
        r30 = null;
        r41 = r10;
        goto L29
    L24:
        com.obric.memorydata.memory.memoryentity.a.a r35 = com.obric.memorydata.memory.memoryentity.a.a.f10310a;
        r24 = r55;
        r15.L$0 = r24;
        r23 = r56;
        r15.L$1 = r23;
        r21 = r57;
        r15.L$2 = r21;
        r15.L$3 = r1;
        r22 = r63;
        r15.L$4 = r22;
        r112 = r64;
        r15.L$5 = r112;
        r13 = r65;
        r15.L$6 = r13;
        r15.L$7 = r10;
        r15.L$8 = r20;
        r15.Z$0 = r2;
        r15.Z$1 = r3;
        r15.label = 1;
        Object r113 = com.obric.memorydata.memory.memoryentity.a.a.a(r35, r57, null, 0.0f, 0, r15, 14, null);
        if (r113 != r14) goto L27;
        return r14;
    L27:
        r6 = r113;
        goto L28
    L21:
        r20 = r62;
        goto L22
    L17:
        return Unit.INSTANCE;
    L7:
        r5 = new SmartMemoryUtils$takeSmartMemory$1(this, r4);
        goto L8
    }
}
