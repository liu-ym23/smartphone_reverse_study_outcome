package com.bytedance.ai.resource.core.bean;

import androidx.annotation.Keep;
import androidx.constraintlayout.motion.widget.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoList;", "", "appList", "", "Lcom/bytedance/ai/resource/core/bean/AIPackageGeckoInfoItem;", "<init>", "(Ljava/util/List;)V", "getAppList", "()Ljava/util/List;", "setAppList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIPackageGeckoInfoList {
    private List<AIPackageGeckoInfoItem> appList;

    /* JADX WARN: Multi-variable type inference failed */
    public AIPackageGeckoInfoList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageGeckoInfoList copy$default(AIPackageGeckoInfoList r5, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = r5.appList;
    L6:
        return r5.copy(r10);
    }

    public final List<AIPackageGeckoInfoItem> component1() {
        return this.appList;
    }

    public final AIPackageGeckoInfoList copy(List<AIPackageGeckoInfoItem> r5) {
        Intrinsics.checkNotNullParameter(r5, "appList");
        return new AIPackageGeckoInfoList(r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AIPackageGeckoInfoList) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.appList, ((AIPackageGeckoInfoList) r5).appList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final List<AIPackageGeckoInfoItem> getAppList() {
        return this.appList;
    }

    public int hashCode() {
        return this.appList.hashCode();
    }

    public final void setAppList(List<AIPackageGeckoInfoItem> r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.appList = r5;
    }

    public String toString() {
        return a.v(new StringBuilder("AIPackageGeckoInfoList(appList="), this.appList, ')');
    }

    public AIPackageGeckoInfoList(List<AIPackageGeckoInfoItem> r5) {
        Intrinsics.checkNotNullParameter(r5, "appList");
        this.appList = r5;
    }

    public /* synthetic */ AIPackageGeckoInfoList(List r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = new ArrayList();
    L5:
        this(r5);
    }
}
