package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/m;", "", "", "Lcom/bytedance/android/live/ktv/common/model/api/o0;", "labels", "Ljava/util/List;", "c", "()Ljava/util/List;", "setLabels", "(Ljava/util/List;)V", "", "defaultTab", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "firstLevelTab", "I", "b", "()I", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class m implements vh7.h {

    @SerializedName("default_tab")
    protected String defaultTab;

    @SerializedName("default_first_level_tab")
    protected int firstLevelTab;

    @SerializedName("tabs")
    protected List<o0> labels;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof m) == false) goto L12;
        m r4 = (m) r3;
        if (Intrinsics.areEqual(this.labels, r4.labels) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.defaultTab, r4.defaultTab) == true) goto L10;
        return false;
    L10:
        if (this.firstLevelTab == r4.firstLevelTab) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<o0> r0 = this.labels;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.defaultTab;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.firstLevelTab;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "GetTabListResponse(labels=" + this.labels + ", defaultTab=" + this.defaultTab + ", firstLevelTab=" + this.firstLevelTab + ")";
    }

    public m() {
        this.labels = null;
        this.defaultTab = "";
        this.firstLevelTab = 0;
    }

    public final String a() {
        return this.defaultTab;
    }

    public final int b() {
        return this.firstLevelTab;
    }

    public final List<o0> c() {
        return this.labels;
    }

    public m(am3.g r8) {
        this.labels = new ArrayList();
        long r0 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L14;
        if (r4 != 1) goto L7;
        this.labels.add(new o0(r8));
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this.defaultTab = am3.h.c(r8);
        goto L3
    L9:
        if (r4 != 3) goto L10;
        this.firstLevelTab = r8.i();
        r3 = r3 | true;
        goto L3
    L10:
        am3.h.e(r8);
        goto L3
    L14:
        r8.d(r0);
        if (this.labels.isEmpty() == false) goto L18;
        this.labels = null;
    L18:
        if (this.defaultTab != null) goto L21;
        this.defaultTab = "";
    L21:
        if ((r3 & true) == true) goto L36;
        this.firstLevelTab = 0;
        return;
    }
}
