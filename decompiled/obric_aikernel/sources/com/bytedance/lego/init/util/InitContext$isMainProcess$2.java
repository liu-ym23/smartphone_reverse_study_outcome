package com.bytedance.lego.init.util;

import com.bytedance.lego.init.InitScheduler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class InitContext$isMainProcess$2 extends Lambda implements Function0<Boolean> {
    public static final InitContext$isMainProcess$2 INSTANCE = null;

    static {
        INSTANCE = new InitContext$isMainProcess$2();
    }

    InitContext$isMainProcess$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess();
    }
}
