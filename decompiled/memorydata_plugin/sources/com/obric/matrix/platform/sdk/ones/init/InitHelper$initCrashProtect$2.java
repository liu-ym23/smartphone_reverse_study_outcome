package com.obric.matrix.platform.sdk.ones.init;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "crashPortrait", "Lcom/bytedance/platform/godzilla/common/CrashPortrait;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class InitHelper$initCrashProtect$2 extends Lambda implements Function1<com.bytedance.platform.godzilla.common.b, Unit> {
    public static final InitHelper$initCrashProtect$2 INSTANCE = null;

    static {
        INSTANCE = new InitHelper$initCrashProtect$2();
    }

    InitHelper$initCrashProtect$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(com.bytedance.platform.godzilla.common.b r3) {
        invoke2((com.bytedance.platform.godzilla.common.b) ZeusTransformUtils.preCheckCast(r3, com.bytedance.platform.godzilla.common.b.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.platform.godzilla.common.b r3) {
        Intrinsics.checkNotNullParameter(r3, "crashPortrait");
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("InitHelper", "Crash caught successfully: " + r3, null, 4, null);
    }
}
