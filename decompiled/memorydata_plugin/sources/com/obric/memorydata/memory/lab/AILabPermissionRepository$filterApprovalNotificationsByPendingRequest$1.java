package com.obric.memorydata.memory.lab;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class AILabPermissionRepository$filterApprovalNotificationsByPendingRequest$1 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    AILabPermissionRepository$filterApprovalNotificationsByPendingRequest$1(Object r8) {
        super(1, r8, AILabPermissionRepository.class, "isApprovalNotificationPending", "isApprovalNotificationPending(Ljava/lang/String;)Z", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        return Boolean.valueOf(((AILabPermissionRepository) ZeusTransformUtils.preCheckCast(this.receiver, AILabPermissionRepository.class, "com.obric.memorydata.plugin")).d(r3));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Boolean invoke(String r3) {
        return invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }
}
