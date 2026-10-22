package com.bytedance.android.live.base.model.morepanel;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ProtoMessage("webcast.api.room.AreaPattern")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/base/model/morepanel/AreaPattern;", "", "()V", "columnElements", "", "Lcom/bytedance/android/live/base/model/morepanel/ColumnElement;", "getColumnElements", "()Ljava/util/List;", "setColumnElements", "(Ljava/util/List;)V", "equals", "", "other", "hashCode", "", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AreaPattern implements h {

    @SerializedName("column_list")
    protected List<ColumnElement> columnElements;

    public int hashCode() {
        List<ColumnElement> r0 = this.columnElements;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public AreaPattern() {
        this.columnElements = CollectionsKt.emptyList();
    }

    public final List<ColumnElement> getColumnElements() {
        return this.columnElements;
    }

    public AreaPattern(g r5) {
        this.columnElements = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.columnElements.add(new ColumnElement(r5));
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
        if (this.columnElements.isEmpty() == false) goto L19;
        this.columnElements = CollectionsKt.emptyList();
        return;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 == null) goto L8;
        Class<?> r2 = r4.getClass();
    L10:
        if ((!Intrinsics.areEqual(AreaPattern.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r4 == null) goto L18;
        if ((!Intrinsics.areEqual(this.columnElements, ((AreaPattern) r4).columnElements)) == false) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.morepanel.AreaPattern");
    L8:
        r2 = null;
        goto L10
    }

    public final void setColumnElements(List<ColumnElement> r1) {
        this.columnElements = r1;
    }
}
