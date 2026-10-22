package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/m0;", "", "", "", "room_ids", "Ljava/util/List;", "getRoom_ids", "()Ljava/util/List;", "", "room_ids_str", "a", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m0 implements vh7.h {

    @SerializedName("room_ids")
    protected List<Long> room_ids;

    @SerializedName("room_ids_str")
    protected List<String> room_ids_str;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m0) == false) goto L10;
        m0 r4 = (m0) r3;
        if (Intrinsics.areEqual(this.room_ids, r4.room_ids) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.room_ids_str, r4.room_ids_str) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<Long> r0 = this.room_ids;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.room_ids_str;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OwnRoom(room_ids=" + this.room_ids + ", room_ids_str=" + this.room_ids_str + ")";
    }

    public m0() {
        this.room_ids = null;
        this.room_ids_str = null;
    }

    public final List<String> a() {
        return this.room_ids_str;
    }

    public m0(am3.g r6) {
        this.room_ids = new ArrayList();
        this.room_ids_str = new ArrayList();
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L13;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L9;
        List r3 = this.room_ids_str;
        Object r4 = am3.h.c(r6);
    L12:
        r3.add(r4);
        goto L3
    L9:
        am3.h.e(r6);
        goto L3
    L11:
        r3 = this.room_ids;
        r4 = Long.valueOf(r6.j());
        goto L12
    L13:
        r6.d(r0);
        if (this.room_ids.isEmpty() == false) goto L17;
        this.room_ids = null;
    L17:
        if (this.room_ids_str.isEmpty() == false) goto L27;
        this.room_ids_str = null;
        return;
    }
}
