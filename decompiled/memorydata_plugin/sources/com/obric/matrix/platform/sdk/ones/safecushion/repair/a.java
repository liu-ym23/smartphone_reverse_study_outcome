package com.obric.matrix.platform.sdk.ones.safecushion.repair;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0014\u001a\u00020\u00152\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/BaseRepair;", "Ljava/lang/Runnable;", "alias", "", "(Ljava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "repairHandler", "Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionRepairHandler;", "getRepairHandler$sdk_platform_ones_release", "()Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionRepairHandler;", "setRepairHandler$sdk_platform_ones_release", "(Lcom/obric/matrix/platform/sdk/ones/safecushion/repair/SafeCushionRepairHandler;)V", "repairResult", "Lkotlin/Pair;", "", "getRepairResult", "()Lkotlin/Pair;", "setRepairResult", "(Lkotlin/Pair;)V", "repairFinish", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8136a;

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "alias");
        this.f8136a = r2;
    }

    public /* synthetic */ a(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }
}
