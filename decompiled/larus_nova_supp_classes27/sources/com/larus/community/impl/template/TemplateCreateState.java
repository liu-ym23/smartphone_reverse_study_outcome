package com.larus.community.impl.template;

import com.larus.platform.api.creation.TabItemInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/community/impl/template/TemplateCreateState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "tabList", "", "Lcom/larus/platform/api/creation/TabItemInfo;", "pageState", "Lcom/larus/community/impl/view/PageState;", "<init>", "(Ljava/util/List;Lcom/larus/community/impl/view/PageState;)V", "getTabList", "()Ljava/util/List;", "getPageState", "()Lcom/larus/community/impl/view/PageState;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCreateState implements w1a.b {
    private final r29.k pageState;
    private final List<TabItemInfo> tabList;

    /* JADX WARN: Multi-variable type inference failed */
    public TemplateCreateState() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TemplateCreateState copy$default(TemplateCreateState r0, List r1, r29.k r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.tabList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.pageState;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<TabItemInfo> component1() {
        return this.tabList;
    }

    public final r29.k component2() {
        return this.pageState;
    }

    public final TemplateCreateState copy(List<TabItemInfo> r2, r29.k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabList");
        Intrinsics.checkNotNullParameter(r3, "pageState");
        return new TemplateCreateState(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TemplateCreateState) == true) goto L8;
        return false;
    L8:
        TemplateCreateState r6 = (TemplateCreateState) r5;
        if (Intrinsics.areEqual(this.tabList, r6.tabList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageState, r6.pageState) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.tabList.hashCode() * 31) + this.pageState.hashCode();
    }

    public String toString() {
        return "TemplateCreateState(tabList=" + this.tabList + ", pageState=" + this.pageState + ')';
    }

    public final r29.k getPageState() {
        return this.pageState;
    }

    public final List<TabItemInfo> getTabList() {
        return this.tabList;
    }

    public TemplateCreateState(List<TabItemInfo> r2, r29.k r3) {
        Intrinsics.checkNotNullParameter(r2, "tabList");
        Intrinsics.checkNotNullParameter(r3, "pageState");
        this.tabList = r2;
        this.pageState = r3;
    }

    public /* synthetic */ TemplateCreateState(List r1, r29.k r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = r29.k.c.a;
    L8:
        this(r1, r2);
    }
}
