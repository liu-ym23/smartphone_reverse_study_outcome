package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class AppDiskManager$cleanCacheWithResult$2$cacheFilesCleanSucceeded$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    final /* synthetic */ String $expectedAccountScope;
    final /* synthetic */ Ref.ObjectRef<AppDiskManager$CleanExecutionStatus> $interruptionStatus;
    final /* synthetic */ boolean $isManual;
    final /* synthetic */ boolean $requireAccountConsistency;
    final /* synthetic */ boolean $requireAppBackground;

    public AppDiskManager$cleanCacheWithResult$2$cacheFilesCleanSucceeded$1(boolean r7, boolean r8, String r9, boolean r10, Ref.ObjectRef<AppDiskManager$CleanExecutionStatus> r11) {
        this.$isManual = r7;
        this.$requireAccountConsistency = r8;
        this.$expectedAccountScope = r9;
        this.$requireAppBackground = r10;
        this.$interruptionStatus = r11;
        super(0, Intrinsics.Kotlin.class, "shouldContinue", "invokeSuspend$shouldContinue(ZZLjava/lang/String;ZLkotlin/jvm/internal/Ref$ObjectRef;)Z", 0);
    }

    public final Boolean invoke() {
        return Boolean.valueOf(AppDiskManager$cleanCacheWithResult$2.access$invokeSuspend$shouldContinue(this.$isManual, this.$requireAccountConsistency, this.$expectedAccountScope, this.$requireAppBackground, this.$interruptionStatus));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m28invoke() {
        return invoke();
    }
}
