package com.obric.memorydata.memory.island.gr;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0003H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J.\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0006\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "", "templateId", "", "templateData", "Lcom/obric/memorydata/memory/island/gr/ITemplateData;", "isDefault", "", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/memory/island/gr/ITemplateData;Ljava/lang/Boolean;)V", "getTemplateId", "()Ljava/lang/String;", "getTemplateData", "()Lcom/obric/memorydata/memory/island/gr/ITemplateData;", "setTemplateData", "(Lcom/obric/memorydata/memory/island/gr/ITemplateData;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "toString", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lcom/obric/memorydata/memory/island/gr/ITemplateData;Ljava/lang/Boolean;)Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "equals", "other", "hashCode", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IslandWidget {
    private final Boolean isDefault;
    private b templateData;
    private final String templateId;

    public IslandWidget(String r3, b r4, Boolean r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "templateId");
        Intrinsics.checkNotNullParameter(r6, "templateData");
        this.templateId = r3;
        this.templateData = r6;
        this.isDefault = r5;
    }

    public /* synthetic */ IslandWidget(String r2, b r3, Boolean r4, int r5, DefaultConstructorMarker r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = false;
    L5:
        this(r2, r7, r4);
    }

    public static /* synthetic */ IslandWidget copy$default(IslandWidget r1, String r2, b r3, Boolean r4, int r5, Object r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = r1.templateId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = r1.templateData;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.isDefault;
    L12:
        return r1.copy(r2, r7, r4);
    }

    public final String component1() {
        return this.templateId;
    }

    public final b component2() {
        return this.templateData;
    }

    public final Boolean component3() {
        return this.isDefault;
    }

    public final IslandWidget copy(String r2, b r3, Boolean r4) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "templateId");
        Intrinsics.checkNotNullParameter(r1, "templateData");
        return new IslandWidget(r2, r1, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IslandWidget.class) == true) goto L8;
        return false;
    L8:
        IslandWidget r6 = (IslandWidget) ZeusTransformUtils.preCheckCast(r5, IslandWidget.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.templateId, r6.templateId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateData, r6.templateData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isDefault, r6.isDefault) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final b getTemplateData() {
        return this.templateData;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public int hashCode() {
        int r0 = ((this.templateId.hashCode() * 31) + this.templateData.hashCode()) * 31;
        Boolean r2 = this.isDefault;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public final Boolean isDefault() {
        return this.isDefault;
    }

    public final void setTemplateData(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.templateData = r4;
    }

    public String toString() {
        return "IslandWidget(templateId=" + this.templateId + ", isDefault=" + this.isDefault + ')';
    }
}
