package com.obric.memorydata.union.build.storage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a \u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0000\u001a \u0010\r\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"CONFIRMATION_PENDING", "", "CONFIRMATION_CONFIRMED", "CONFIRMATION_NONE", "validPendingState", "", "confidence", "", "state", "selectedConflictsBelongToTarget", "encodedConflictEntityIds", "selectedEntityIds", "", "retainExistingConflictEntityIds", "existingEntityIds", "", "memory_build_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class l {
    public static final boolean a(float r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        if (Intrinsics.areEqual(r4, "pending") == false) goto L8;
        if (r3 == 3.0f) goto L12;
        return false;
    L12:
        return true;
    L8:
        if (Intrinsics.areEqual(r4, "confirmed") == false) goto L12;
        if (r3 == 4.0f) goto L12;
        return false;
    }
}
