package com.ss.android.lark.chameleon.basewebview.interfaces;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleon/basewebview/interfaces/LarkWebViewMenuItem;", BuildConfig.FLAVOR, "titleId", BuildConfig.FLAVOR, "id", "order", "groupId", "(IIII)V", "getGroupId", "()I", "setGroupId", "(I)V", "getId", "setId", "getOrder", "setOrder", "getTitleId", "setTitleId", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", BuildConfig.FLAVOR, "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LarkWebViewMenuItem {
    private int groupId;
    private int id;
    private int order;
    private int titleId;

    public static /* synthetic */ LarkWebViewMenuItem copy$default(LarkWebViewMenuItem r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.titleId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.id;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.order;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.groupId;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.titleId;
    }

    public final int component2() {
        return this.id;
    }

    public final int component3() {
        return this.order;
    }

    public final int component4() {
        return this.groupId;
    }

    public final LarkWebViewMenuItem copy(int r2, int r3, int r4, int r5) {
        return new LarkWebViewMenuItem(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LarkWebViewMenuItem) == true) goto L8;
        return false;
    L8:
        LarkWebViewMenuItem r6 = (LarkWebViewMenuItem) r5;
        if (this.titleId == r6.titleId) goto L12;
        return false;
    L12:
        if (this.id == r6.id) goto L15;
        return false;
    L15:
        if (this.order == r6.order) goto L18;
        return false;
    L18:
        if (this.groupId == r6.groupId) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.titleId * 31) + this.id) * 31) + this.order) * 31) + this.groupId;
    }

    public String toString() {
        return "LarkWebViewMenuItem(titleId=" + this.titleId + ", id=" + this.id + ", order=" + this.order + ", groupId=" + this.groupId + ')';
    }

    public final int getGroupId() {
        return this.groupId;
    }

    public final int getId() {
        return this.id;
    }

    public final int getOrder() {
        return this.order;
    }

    public final int getTitleId() {
        return this.titleId;
    }

    public final void setGroupId(int r1) {
        this.groupId = r1;
    }

    public final void setId(int r1) {
        this.id = r1;
    }

    public final void setOrder(int r1) {
        this.order = r1;
    }

    public final void setTitleId(int r1) {
        this.titleId = r1;
    }

    public LarkWebViewMenuItem(int r1, int r2, int r3, int r4) {
        this.titleId = r1;
        this.id = r2;
        this.order = r3;
        this.groupId = r4;
    }
}
