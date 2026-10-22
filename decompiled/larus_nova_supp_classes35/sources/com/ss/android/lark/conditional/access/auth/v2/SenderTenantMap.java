package com.ss.android.lark.conditional.access.auth.v2;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J/\u0010\r\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R6\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/conditional/access/auth/v2/SenderTenantMap;", BuildConfig.FLAVOR, "senderIdMap", "Ljava/util/HashMap;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getSenderIdMap", "()Ljava/util/HashMap;", "setSenderIdMap", "component1", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SenderTenantMap {
    private HashMap<Long, Boolean> senderIdMap;

    public SenderTenantMap() {
        HashMap r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SenderTenantMap copy$default(SenderTenantMap r0, HashMap r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.senderIdMap;
    L6:
        return r0.copy(r1);
    }

    public final HashMap<Long, Boolean> component1() {
        return this.senderIdMap;
    }

    public final SenderTenantMap copy(HashMap<Long, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "senderIdMap");
        return new SenderTenantMap(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SenderTenantMap) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.senderIdMap, ((SenderTenantMap) r4).senderIdMap) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.senderIdMap.hashCode();
    }

    public String toString() {
        return "SenderTenantMap(senderIdMap=" + this.senderIdMap + ')';
    }

    public final HashMap<Long, Boolean> getSenderIdMap() {
        return this.senderIdMap;
    }

    public SenderTenantMap(HashMap<Long, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "senderIdMap");
        this.senderIdMap = r2;
    }

    public final void setSenderIdMap(HashMap<Long, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.senderIdMap = r2;
    }

    public /* synthetic */ SenderTenantMap(HashMap r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new HashMap();
    L5:
        this(r1);
    }
}
