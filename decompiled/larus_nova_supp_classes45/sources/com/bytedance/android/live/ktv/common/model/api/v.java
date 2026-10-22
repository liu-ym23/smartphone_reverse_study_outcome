package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/v;", "", "", "", "Lcom/bytedance/android/live/ktv/common/model/api/p;", "group_data_map", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class v implements vh7.h {

    @SerializedName("group_data_map")
    protected Map<Long, p> group_data_map;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof v) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.group_data_map, ((v) r2).group_data_map) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<Long, p> r0 = this.group_data_map;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "InGroupInfoResponse(group_data_map=" + this.group_data_map + ")";
    }

    public v() {
        this.group_data_map = null;
    }

    public final Map<Long, p> a() {
        return this.group_data_map;
    }

    public v(am3.g r11) {
        this.group_data_map = new HashMap();
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        Long r4 = null;
        if (r2 == (-1)) goto L25;
        if (r2 != 1) goto L7;
        long r6 = r11.c();
        p r3 = null;
    L9:
        int r8 = r11.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r4 = Long.valueOf(r11.j());
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r3 = new p(r11);
        goto L9
    L14:
        am3.h.e(r11);
        goto L9
    L17:
        r11.d(r6);
        Map<Long, p> r5 = this.group_data_map;
        if (r4 == null) goto L24;
        if (r3 == null) goto L22;
        r5.put(r4, r3);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.e(r11);
        goto L3
    L25:
        r11.d(r0);
        if (this.group_data_map != null) goto L46;
        this.group_data_map = null;
        return;
    }
}
