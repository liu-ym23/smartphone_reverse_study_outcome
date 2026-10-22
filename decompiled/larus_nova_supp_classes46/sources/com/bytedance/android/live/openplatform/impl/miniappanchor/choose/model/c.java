package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ProtoMessage("webcast.api.stamp.MicroappGroupProperty")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/model/c;", "", "", "name", "Ljava/lang/String;", "", "capacity", "J", "groupId", "liveDesc", "liveDescLinkUrl", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c implements h {

    @SerializedName("capacity")
    public long capacity;

    @SerializedName("group_id")
    public long groupId;

    @SerializedName("live_desc")
    public String liveDesc;

    @SerializedName("live_desc_link_url")
    public String liveDescLinkUrl;

    @SerializedName("name")
    public String name;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L16;
        c r7 = (c) r6;
        if (Intrinsics.areEqual(this.name, r7.name) == true) goto L8;
        return false;
    L8:
        if (this.capacity == r7.capacity) goto L10;
        return false;
    L10:
        if (this.groupId == r7.groupId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.liveDesc, r7.liveDesc) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.liveDescLinkUrl, r7.liveDescLinkUrl) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.capacity;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.groupId;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        String r7 = this.liveDesc;
        if (r7 == null) goto L9;
        int r8 = r7.hashCode();
    L10:
        int r9 = (r6 + r8) * 31;
        String r10 = this.liveDescLinkUrl;
        if (r10 == null) goto L14;
        r1 = r10.hashCode();
    L14:
        return r9 + r1;
    L9:
        r8 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniAppGroupProperty(name=" + this.name + ", capacity=" + this.capacity + ", groupId=" + this.groupId + ", liveDesc=" + this.liveDesc + ", liveDescLinkUrl=" + this.liveDescLinkUrl + ")";
    }

    public c() {
        this.name = null;
        this.capacity = 0;
        this.groupId = 0;
        this.liveDesc = null;
        this.liveDescLinkUrl = null;
    }

    public c(g r7) {
        long r0 = r7.c();
        int r2 = 0;
    L3:
        int r3 = r7.f();
        if (r3 == (-1)) goto L20;
        if (r3 != 1) goto L7;
        this.name = am3.h.c(r7);
        goto L3
    L7:
        if (r3 != 2) goto L9;
        this.capacity = r7.j();
        r2 = r2 | 1;
        goto L3
    L9:
        if (r3 != 3) goto L11;
        this.groupId = r7.i();
        r2 = r2 | 2;
        goto L3
    L11:
        if (r3 != 4) goto L13;
        this.liveDescLinkUrl = am3.h.c(r7);
        goto L3
    L13:
        if (r3 != 5) goto L14;
        this.liveDesc = am3.h.c(r7);
        goto L3
    L14:
        am3.h.e(r7);
        goto L3
    L20:
        r7.d(r0);
        if (this.name != null) goto L24;
        this.name = null;
    L24:
        if ((r2 & 1) != 0) goto L27;
        this.capacity = 0;
    L27:
        if ((r2 & 2) != 0) goto L30;
        this.groupId = 0;
    L30:
        if (this.liveDesc != null) goto L33;
        this.liveDesc = null;
    L33:
        if (this.liveDescLinkUrl != null) goto L54;
        this.liveDescLinkUrl = null;
        return;
    }
}
