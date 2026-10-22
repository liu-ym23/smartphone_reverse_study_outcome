package com.bytedance.android.ec.common.impl.entranceinfo;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/common/impl/entranceinfo/f;", "", "", AIStateLogRequest.SOURCE_PAGE, "Ljava/lang/String;", "getPage", "()Ljava/lang/String;", "scene", "getScene", "", "actionType", "Ljava/lang/Integer;", "getActionType", "()Ljava/lang/Integer;", "", "keySet", "Ljava/util/List;", "getKeySet", "()Ljava/util/List;", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ACTION_TYPE)
    private final Integer actionType;

    @SerializedName("key_set")
    private final List<String> keySet;

    @SerializedName(AIStateLogRequest.SOURCE_PAGE)
    private final String page;

    @SerializedName("scene")
    private final String scene;

    public f() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof f) == false) goto L14;
        f r11 = (f) r10;
        if (Intrinsics.areEqual(this.page, r11.page) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.scene, r11.scene) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.actionType, r11.actionType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.keySet, r11.keySet) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.page;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.scene;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        Integer r15 = this.actionType;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        List<String> r18 = this.keySet;
        if (r18 == null) goto L18;
        r1 = r18.hashCode();
    L18:
        return r17 + r1;
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "TraceItemInfo(page=" + this.page + ", scene=" + this.scene + ", actionType=" + this.actionType + ", keySet=" + this.keySet + ")";
    }

    public f(String r1, String r10, Integer r11, List<String> r12) {
        this.page = r1;
        this.scene = r10;
        this.actionType = r11;
        this.keySet = r12;
    }
}
