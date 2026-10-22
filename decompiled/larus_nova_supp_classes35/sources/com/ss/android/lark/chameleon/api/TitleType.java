package com.ss.android.lark.chameleon.api;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chameleon/api/TitleType;", "Ljava/io/Serializable;", "size", BuildConfig.FLAVOR, "position", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getPosition", "()Ljava/lang/Integer;", "setPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSize", "setSize", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/ss/android/lark/chameleon/api/TitleType;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TitleType implements Serializable {
    private Integer position;
    private Integer size;

    public TitleType() {
        Integer r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ TitleType copy$default(TitleType r0, Integer r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.size;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.position;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.size;
    }

    public final Integer component2() {
        return this.position;
    }

    public final TitleType copy(Integer r2, Integer r3) {
        return new TitleType(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TitleType) == true) goto L8;
        return false;
    L8:
        TitleType r6 = (TitleType) r5;
        if (Intrinsics.areEqual(this.size, r6.size) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.position, r6.position) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.size;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.position;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TitleType(size=" + this.size + ", position=" + this.position + ')';
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final void setPosition(Integer r1) {
        this.position = r1;
    }

    public final void setSize(Integer r1) {
        this.size = r1;
    }

    public TitleType(Integer r1, Integer r2) {
        this.size = r1;
        this.position = r2;
    }

    public /* synthetic */ TitleType(Integer r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 1;
    L8:
        this(r2, r3);
    }
}
