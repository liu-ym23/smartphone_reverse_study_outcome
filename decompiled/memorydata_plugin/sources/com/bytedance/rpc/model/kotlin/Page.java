package com.bytedance.rpc.model.kotlin;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/Page;", "Ljava/io/Serializable;", "num", "", "size", LBSLightLocationTraceLogger.TOTAL, "(III)V", "getNum", "()I", "setNum", "(I)V", "getSize", "setSize", "getTotal", "setTotal", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class Page implements Serializable {

    @SerializedName("num")
    private int num;

    @SerializedName("size")
    private int size;

    @SerializedName(LBSLightLocationTraceLogger.TOTAL)
    private int total;

    public Page(int r1, int r2, int r3) {
        this.num = r1;
        this.size = r2;
        this.total = r3;
    }

    public static /* synthetic */ Page copy$default(Page r0, int r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.num;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.size;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.total;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.num;
    }

    public final int component2() {
        return this.size;
    }

    public final int component3() {
        return this.total;
    }

    public final Page copy(int r1, int r2, int r3) {
        return new Page(r1, r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, Page.class) == false) goto L13;
        Page r4 = (Page) ZeusTransformUtils.preCheckCast(r3, Page.class, "com.obric.memorydata.plugin");
        if (this.num == r4.num) goto L9;
        return false;
    L9:
        if (this.size == r4.size) goto L11;
        return false;
    L11:
        if (this.total == r4.total) goto L20;
        return false;
    L20:
        return true;
    L13:
        return false;
    }

    public final int getNum() {
        return this.num;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.num) * 31) + Integer.hashCode(this.size)) * 31) + Integer.hashCode(this.total);
    }

    public final void setNum(int r1) {
        this.num = r1;
    }

    public final void setSize(int r1) {
        this.size = r1;
    }

    public final void setTotal(int r1) {
        this.total = r1;
    }

    public String toString() {
        return "Page(num=" + this.num + ", size=" + this.size + ", total=" + this.total + ")";
    }
}
