package com.larus.platform.model.action;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/model/action/SuggestedExt;", "Ljava/io/Serializable;", "displayNameStartlingKey", "", "<init>", "(Ljava/lang/String;)V", "getDisplayNameStartlingKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SuggestedExt implements Serializable {

    @SerializedName("display_name_startling_key")
    private final String displayNameStartlingKey;

    public SuggestedExt() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ SuggestedExt copy$default(SuggestedExt r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.displayNameStartlingKey;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.displayNameStartlingKey;
    }

    public final SuggestedExt copy(String r2) {
        return new SuggestedExt(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SuggestedExt) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.displayNameStartlingKey, ((SuggestedExt) r4).displayNameStartlingKey) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.displayNameStartlingKey;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "SuggestedExt(displayNameStartlingKey=" + this.displayNameStartlingKey + ')';
    }

    public final String getDisplayNameStartlingKey() {
        return this.displayNameStartlingKey;
    }

    public SuggestedExt(String r1) {
        this.displayNameStartlingKey = r1;
    }

    public /* synthetic */ SuggestedExt(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
