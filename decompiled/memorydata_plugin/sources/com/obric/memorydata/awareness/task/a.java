package com.obric.memorydata.awareness.task;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ&\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/awareness/task/HomeCompanyAddressLookupPolicy;", "", "<init>", "()V", "COORDINATE_DELTA", "", "shouldRequestAddress", "", "longitude", "latitude", "cachedAddress", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "isSameLocation", "firstLongitude", "firstLatitude", "secondLongitude", "secondLatitude", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8793a = null;

    static {
        f8793a = new a();
    }

    private a() {
    }

    public final boolean a(double r1, double r3, double r5, double r7) {
        if (Math.abs(r1 - r5) <= 1.0E-4d) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs(r3 - r7) > 1.0E-4d) goto L7;
        return true;
    }

    public final boolean a(double r12, double r14, com.obric.memorydata.memory.api.model.AddressInfo r16) {
        boolean r0 = false;
        if (r16 != null) goto L5;
    L7:
        if (r0 == true) goto L10;
        return true;
    L10:
        return !a(r16.getLongitude(), r16.getLatitude(), r12, r14);
    L5:
        if (com.obric.memorydata.memory.api.model.a.a(r16) != true) goto L7;
        r0 = true;
        goto L7
    }
}
