package com.ss.android.lark.officesdk.minutes.api.recording.doubao;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/DoubaoStatisticInfo;", "Ljava/io/Serializable;", "rawParams", "", "<init>", "(Ljava/lang/String;)V", "getRawParams", "()Ljava/lang/String;", "toJSONObject", "Lorg/json/JSONObject;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoStatisticInfo implements Serializable {
    private final String rawParams;

    public static /* synthetic */ DoubaoStatisticInfo copy$default(DoubaoStatisticInfo r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.rawParams;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.rawParams;
    }

    public final DoubaoStatisticInfo copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "rawParams");
        return new DoubaoStatisticInfo(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof DoubaoStatisticInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.rawParams, ((DoubaoStatisticInfo) r4).rawParams) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.rawParams.hashCode();
    }

    public String toString() {
        return "DoubaoStatisticInfo(rawParams=" + this.rawParams + ')';
    }

    public final JSONObject toJSONObject() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(new JSONObject(this.rawParams));     // Catch: Throwable -> L4
    L6:
        JSONObject r2 = new JSONObject();
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = r2;
    L10:
        return (JSONObject) r1;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final String getRawParams() {
        return this.rawParams;
    }

    public DoubaoStatisticInfo(String r2) {
        Intrinsics.checkNotNullParameter(r2, "rawParams");
        this.rawParams = r2;
    }
}
