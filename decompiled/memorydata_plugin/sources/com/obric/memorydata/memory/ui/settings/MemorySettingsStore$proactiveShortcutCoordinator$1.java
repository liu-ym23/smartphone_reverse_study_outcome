package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class MemorySettingsStore$proactiveShortcutCoordinator$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    MemorySettingsStore$proactiveShortcutCoordinator$1(Object r8) {
        super(0, r8, l.class, "isEnterpriseAccount", "isEnterpriseAccount()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(l.c((l) ZeusTransformUtils.preCheckCast(this.receiver, l.class, "com.obric.memorydata.plugin")));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
