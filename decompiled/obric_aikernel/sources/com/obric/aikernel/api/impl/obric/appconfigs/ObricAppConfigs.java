package com.obric.aikernel.api.impl.obric.appconfigs;

import c9.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class ObricAppConfigs extends com.obric.aikernel.api.base.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f4447d;

    public ObricAppConfigs() {
        this.f4447d = LazyKt.lazy(ObricAppConfigs$matrixManager$2.INSTANCE);
    }

    private final g s() {
        return (g) this.f4447d.getValue();
    }

    @Override // com.obric.aikernel.api.base.a
    protected String d() {
        return s().r();
    }

    @Override // com.obric.aikernel.api.base.a
    public String l(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "currentProcessName");
        StringBuilder r12 = new StringBuilder();
        r12.append(r10);
        String r13 = ":infer";
        r12.append(":infer");
        if (Intrinsics.areEqual(r11, r12.toString()) == false) goto L6;
        StringBuilder r14 = new StringBuilder();
    L5:
        r14.append(r10);
        r14.append(r13);
        return r14.toString();
    L6:
        StringBuilder r15 = new StringBuilder();
        r15.append(r10);
        r13 = ":llm";
        r15.append(":llm");
        if (Intrinsics.areEqual(r11, r15.toString()) == false) goto L9;
        r14 = new StringBuilder();
        goto L5
    L9:
        return null;
    }

    @Override // com.obric.aikernel.api.base.a
    public boolean o() {
        return false;
    }

    @Override // com.obric.aikernel.api.base.a
    public boolean r() {
        return true;
    }
}
