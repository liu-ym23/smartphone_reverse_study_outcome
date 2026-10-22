package com.bytedance.ai.bridge.method.calendar.remote;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/ai/bridge/method/calendar/remote/Property$NodeInfo", "Ljava/io/Serializable;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Property$NodeInfo implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1814b;

    public Property$NodeInfo(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "namespace");
        Intrinsics.checkNotNullParameter(r10, "name");
        this.f1813a = r5;
        this.f1814b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Property$NodeInfo) == true) goto L8;
        return false;
    L8:
        Property$NodeInfo r10 = (Property$NodeInfo) r5;
        if (Intrinsics.areEqual(this.f1813a, r10.f1813a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1814b, r10.f1814b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f1813a.hashCode() * 31;
        return this.f1814b.hashCode() + r5;
    }

    public final String toString() {
        return this.f1813a + ':' + this.f1814b;
    }
}
