package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowHitPointContext;", "Ljava/io/Serializable;", "source", "", "<init>", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmEndWindowHitPointContext implements Serializable {
    private final String source;

    public MmEndWindowHitPointContext() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ MmEndWindowHitPointContext copy$default(MmEndWindowHitPointContext r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.source;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.source;
    }

    public final MmEndWindowHitPointContext copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        return new MmEndWindowHitPointContext(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MmEndWindowHitPointContext) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.source, ((MmEndWindowHitPointContext) r4).source) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.source.hashCode();
    }

    public String toString() {
        return "MmEndWindowHitPointContext(source=" + this.source + ')';
    }

    public final String getSource() {
        return this.source;
    }

    public MmEndWindowHitPointContext(String r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        this.source = r2;
    }

    public /* synthetic */ MmEndWindowHitPointContext(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }
}
