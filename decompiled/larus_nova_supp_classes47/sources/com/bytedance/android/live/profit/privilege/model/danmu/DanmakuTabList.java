package com.bytedance.android.live.profit.privilege.model.danmu;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\u0019\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\f\u001a\u00020\nHÆ\u0003J\t\u0010\u000e\u001a\u00020\rHÆ\u0003JU\u0010\u0015\u001a\u00020\u00002\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\rHÆ\u0001J\t\u0010\u0016\u001a\u00020\rHÖ\u0001J\t\u0010\u0017\u001a\u00020\nHÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003R'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u0010\u0010\u001eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\u0012\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0013\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b#\u0010\"R\u0017\u0010\u0014\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/danmu/DanmakuTabList;", "", "", "isEmpty", "", "Lcom/bytedance/android/live/profit/privilege/model/danmu/b;", "Lcom/bytedance/revenue/platform/api/core/KmpMutableList;", "component1", "component2", "component3", "", "component4", "component5", "", "component6", "list", "isPrivilegeBarrageAvailable", "hasAdminTab", "adminTabIndex", "shadowType", "errorReason", "copy", "toString", "hashCode", "other", "equals", "Ljava/util/List;", "getList", "()Ljava/util/List;", "Z", "()Z", "getHasAdminTab", "I", "getAdminTabIndex", "()I", "getShadowType", "Ljava/lang/String;", "getErrorReason", "()Ljava/lang/String;", "<init>", "(Ljava/util/List;ZZIILjava/lang/String;)V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DanmakuTabList {
    private final int adminTabIndex;
    private final String errorReason;
    private final boolean hasAdminTab;
    private final boolean isPrivilegeBarrageAvailable;
    private final List<b> list;
    private final int shadowType;

    public DanmakuTabList() {
        this(null, false, false, 0, 0, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DanmakuTabList copy$default(DanmakuTabList r4, List r5, boolean r6, boolean r7, int r8, int r9, String r10, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = r4.list;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r6 = r4.isPrivilegeBarrageAvailable;
    L8:
        boolean r14 = r6;
        if ((r12 & 4) == 0) goto L11;
        r7 = r4.hasAdminTab;
    L11:
        boolean r0 = r7;
        if ((r12 & 8) == 0) goto L14;
        r8 = r4.adminTabIndex;
    L14:
        int r1 = r8;
        if ((r12 & 16) == 0) goto L17;
        r9 = r4.shadowType;
    L17:
        int r2 = r9;
        if ((r12 & 32) == 0) goto L20;
        r10 = r4.errorReason;
    L20:
        List r15 = r5;
        return r4.copy(r15, r14, r0, r1, r2, r10);
    }

    public final List<b> component1() {
        return this.list;
    }

    public final boolean component2() {
        return this.isPrivilegeBarrageAvailable;
    }

    public final boolean component3() {
        return this.hasAdminTab;
    }

    public final int component4() {
        return this.adminTabIndex;
    }

    public final int component5() {
        return this.shadowType;
    }

    public final String component6() {
        return this.errorReason;
    }

    public final DanmakuTabList copy(List<b> r9, boolean r10, boolean r12, int r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r9, "list");
        Intrinsics.checkNotNullParameter(r15, "errorReason");
        return new DanmakuTabList(r9, r10, r12, r13, r14, r15);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof DanmakuTabList) == false) goto L18;
        DanmakuTabList r4 = (DanmakuTabList) r3;
        if (Intrinsics.areEqual(this.list, r4.list) == true) goto L8;
        return false;
    L8:
        if (this.isPrivilegeBarrageAvailable == r4.isPrivilegeBarrageAvailable) goto L10;
        return false;
    L10:
        if (this.hasAdminTab == r4.hasAdminTab) goto L12;
        return false;
    L12:
        if (this.adminTabIndex == r4.adminTabIndex) goto L14;
        return false;
    L14:
        if (this.shadowType == r4.shadowType) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.errorReason, r4.errorReason) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        List<b> r0 = this.list;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.isPrivilegeBarrageAvailable;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.hasAdminTab;
        if (r8 == true) goto L13;
        r5 = r8;
    L13:
        int r9 = (((((r7 + r5) * 31) + this.adminTabIndex) * 31) + this.shadowType) * 31;
        String r10 = this.errorReason;
        if (r10 == null) goto L17;
        r1 = r10.hashCode();
    L17:
        return r9 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "DanmakuTabList(list=" + this.list + ", isPrivilegeBarrageAvailable=" + this.isPrivilegeBarrageAvailable + ", hasAdminTab=" + this.hasAdminTab + ", adminTabIndex=" + this.adminTabIndex + ", shadowType=" + this.shadowType + ", errorReason=" + this.errorReason + ")";
    }

    public final boolean isEmpty() {
        return this.list.isEmpty();
    }

    public final int getAdminTabIndex() {
        return this.adminTabIndex;
    }

    public final String getErrorReason() {
        return this.errorReason;
    }

    public final boolean getHasAdminTab() {
        return this.hasAdminTab;
    }

    public final List<b> getList() {
        return this.list;
    }

    public final int getShadowType() {
        return this.shadowType;
    }

    public final boolean isPrivilegeBarrageAvailable() {
        return this.isPrivilegeBarrageAvailable;
    }

    public DanmakuTabList(List<b> r2, boolean r3, boolean r4, int r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r7, "errorReason");
        this.list = r2;
        this.isPrivilegeBarrageAvailable = r3;
        this.hasAdminTab = r4;
        this.adminTabIndex = r5;
        this.shadowType = r6;
        this.errorReason = r7;
    }

    public /* synthetic */ DanmakuTabList(List r5, boolean r6, boolean r7, int r8, int r9, String r10, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = new ArrayList();
    L6:
        if ((r12 & 2) == 0) goto L8;
        boolean r14 = true;
    L9:
        int r0 = 0;
        if ((r12 & 4) == 0) goto L12;
        boolean r1 = false;
    L14:
        if ((r12 & 8) == 0) goto L16;
        int r2 = -1;
    L18:
        if ((r12 & 16) != 0) goto L22;
        r0 = r9;
    L22:
        if ((r12 & 32) == 0) goto L24;
        r10 = "";
    L24:
        String r3 = r10;
        this(r5, r14, r1, r2, r0, r3);
        return;
    L16:
        r2 = r8;
        goto L18
    L12:
        r1 = r7;
        goto L14
    L8:
        r14 = r6;
        goto L9
    }
}
