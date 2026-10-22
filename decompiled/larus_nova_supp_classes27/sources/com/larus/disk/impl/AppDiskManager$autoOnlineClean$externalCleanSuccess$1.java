package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppDiskManager$autoOnlineClean$externalCleanSuccess$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    final /* synthetic */ String $expectedAccountScope;
    final /* synthetic */ Ref.ObjectRef<AppDiskManager$CleanExecutionStatus> $interruptionStatus;
    final /* synthetic */ boolean $requireAccountConsistency;
    final /* synthetic */ boolean $requireAppBackground;

    public AppDiskManager$autoOnlineClean$externalCleanSuccess$1(boolean r7, String r8, boolean r9, Ref.ObjectRef<AppDiskManager$CleanExecutionStatus> r10) {
        this.$requireAccountConsistency = r7;
        this.$expectedAccountScope = r8;
        this.$requireAppBackground = r9;
        this.$interruptionStatus = r10;
        super(0, Intrinsics.Kotlin.class, "shouldContinue", "autoOnlineClean$shouldContinue(ZLjava/lang/String;ZLkotlin/jvm/internal/Ref$ObjectRef;)Z", 0);
    }

    public final Boolean invoke() {
        return Boolean.valueOf(AppDiskManager.z(this.$requireAccountConsistency, this.$expectedAccountScope, this.$requireAppBackground, this.$interruptionStatus));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m26invoke() {
        return invoke();
    }
}
