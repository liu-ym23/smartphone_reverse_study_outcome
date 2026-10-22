package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmViewTypeToJS;", "Ljava/io/Serializable;", "type", "", "<init>", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmViewTypeToJS implements Serializable {
    private final String type;

    public static /* synthetic */ MmViewTypeToJS copy$default(MmViewTypeToJS r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.type;
    }

    public final MmViewTypeToJS copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return new MmViewTypeToJS(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MmViewTypeToJS) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.type, ((MmViewTypeToJS) r4).type) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public String toString() {
        return "MmViewTypeToJS(type=" + this.type + ')';
    }

    public final String getType() {
        return this.type;
    }

    public MmViewTypeToJS(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.type = r2;
    }
}
