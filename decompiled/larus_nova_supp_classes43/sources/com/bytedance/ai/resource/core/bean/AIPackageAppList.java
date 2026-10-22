package com.bytedance.ai.resource.core.bean;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageAppList;", "", "appList", "", "Lcom/bytedance/ai/resource/core/bean/AIPackageResponseItem;", "<init>", "(Ljava/util/List;)V", "getAppList", "()Ljava/util/List;", "setAppList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageAppList {
    private List<AIPackageResponseItem> appList;

    public AIPackageAppList() {
        List r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageAppList copy$default(AIPackageAppList r0, List r1, int r10, Object r11) {
        if ((r10 & 1) == 0) goto L6;
        r1 = r0.appList;
    L6:
        return r0.copy(r1);
    }

    public final List<AIPackageResponseItem> component1() {
        return this.appList;
    }

    public final AIPackageAppList copy(List<AIPackageResponseItem> r10) {
        Intrinsics.checkNotNullParameter(r10, "appList");
        return new AIPackageAppList(r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AIPackageAppList) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.appList, ((AIPackageAppList) r10).appList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.appList.hashCode();
    }

    public String toString() {
        return "AIPackageAppList(appList=" + this.appList + ')';
    }

    public final List<AIPackageResponseItem> getAppList() {
        return this.appList;
    }

    public AIPackageAppList(List<AIPackageResponseItem> r10) {
        Intrinsics.checkNotNullParameter(r10, "appList");
        this.appList = r10;
    }

    public final void setAppList(List<AIPackageResponseItem> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.appList = r10;
    }

    public /* synthetic */ AIPackageAppList(List r1, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r1 = new ArrayList();
    L5:
        this(r1);
    }
}
