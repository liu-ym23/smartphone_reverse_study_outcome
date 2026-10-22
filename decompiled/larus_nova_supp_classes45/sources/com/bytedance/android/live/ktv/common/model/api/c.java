package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/c;", "", "Lcom/bytedance/android/live/ktv/common/model/api/x0;", "tagList", "Lcom/bytedance/android/live/ktv/common/model/api/x0;", "b", "()Lcom/bytedance/android/live/ktv/common/model/api/x0;", "Lcom/bytedance/android/live/ktv/common/model/api/h0;", "midiSkinList", "Lcom/bytedance/android/live/ktv/common/model/api/h0;", "a", "()Lcom/bytedance/android/live/ktv/common/model/api/h0;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c implements vh7.h {

    @SerializedName("midi_skin_list")
    protected h0 midiSkinList;

    @SerializedName("tag_list")
    protected x0 tagList;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L10;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.tagList, r4.tagList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.midiSkinList, r4.midiSkinList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        x0 r0 = this.tagList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        h0 r4 = this.midiSkinList;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "GetDressPageListResponse(tagList=" + this.tagList + ", midiSkinList=" + this.midiSkinList + ")";
    }

    public c() {
        this.tagList = null;
        this.midiSkinList = null;
    }

    public final h0 a() {
        return this.midiSkinList;
    }

    public final x0 b() {
        return this.tagList;
    }

    public c(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L12;
        if (r2 != 1) goto L8;
        this.tagList = new x0(r5);
        goto L3
    L8:
        if (r2 != 2) goto L9;
        this.midiSkinList = new h0(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r0);
        if (this.tagList != null) goto L16;
        this.tagList = null;
    L16:
        if (this.midiSkinList != null) goto L28;
        this.midiSkinList = null;
        return;
    }
}
