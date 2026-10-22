package com.obric.memorydata.memory.island.gr;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Parcelable;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0017J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006!"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/MemoryCollapseTemplate;", "Lcom/obric/memorydata/memory/island/gr/ITemplateData;", "imageTextInfoLeft", "Lcom/obric/memorydata/memory/island/gr/BigIslandImageTextInfoLeft;", "textInfo", "Lcom/obric/memorydata/memory/island/gr/BigIslandTextInfo;", "<init>", "(Lcom/obric/memorydata/memory/island/gr/BigIslandImageTextInfoLeft;Lcom/obric/memorydata/memory/island/gr/BigIslandTextInfo;)V", "getImageTextInfoLeft", "()Lcom/obric/memorydata/memory/island/gr/BigIslandImageTextInfoLeft;", "getTextInfo", "()Lcom/obric/memorydata/memory/island/gr/BigIslandTextInfo;", "create", "Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "toJSONObject", "Lorg/json/JSONObject;", "getPics", "Landroid/os/Bundle;", "getActions", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryCollapseTemplate implements b {
    public static final a Companion = null;
    public static final String TEMPLATE_ID = "com.obric.island_assistant:gr_common_collapse_template2";
    private final BigIslandImageTextInfoLeft imageTextInfoLeft;
    private final BigIslandTextInfo textInfo;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/MemoryCollapseTemplate$Companion;", "", "<init>", "()V", "TEMPLATE_ID", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryCollapseTemplate(BigIslandImageTextInfoLeft r2, BigIslandTextInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "imageTextInfoLeft");
        Intrinsics.checkNotNullParameter(r3, "textInfo");
        this.imageTextInfoLeft = r2;
        this.textInfo = r3;
    }

    public static /* synthetic */ MemoryCollapseTemplate copy$default(MemoryCollapseTemplate r0, BigIslandImageTextInfoLeft r1, BigIslandTextInfo r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.imageTextInfoLeft;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.textInfo;
    L9:
        return r0.copy(r1, r2);
    }

    public static /* synthetic */ IslandWidget create$default(MemoryCollapseTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.create(r1);
    }

    public final BigIslandImageTextInfoLeft component1() {
        return this.imageTextInfoLeft;
    }

    public final BigIslandTextInfo component2() {
        return this.textInfo;
    }

    public final MemoryCollapseTemplate copy(BigIslandImageTextInfoLeft r1, BigIslandTextInfo r2) {
        Intrinsics.checkNotNullParameter(r1, "imageTextInfoLeft");
        Intrinsics.checkNotNullParameter(r2, "textInfo");
        return new MemoryCollapseTemplate(r1, r2);
    }

    public final IslandWidget create(Boolean r4) {
        RunLog.INSTANCE.debug("IslandTemplates", "MemoryCollapseTemplate.create: isDefault=" + r4);
        return new IslandWidget(TEMPLATE_ID, (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin"), r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MemoryCollapseTemplate.class) == true) goto L8;
        return false;
    L8:
        MemoryCollapseTemplate r6 = (MemoryCollapseTemplate) ZeusTransformUtils.preCheckCast(r5, MemoryCollapseTemplate.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.imageTextInfoLeft, r6.imageTextInfoLeft) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textInfo, r6.textInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public Bundle getActions() {
        return new Bundle();
    }

    public final BigIslandImageTextInfoLeft getImageTextInfoLeft() {
        return this.imageTextInfoLeft;
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public Bundle getPics() {
        Bundle r0 = new Bundle();
        BigIslandPicInfo r8 = this.imageTextInfoLeft.getPicInfo();
        if (r8 == null) goto L8;
        Icon r1 = c.f10208a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8.getPicResId());
        if (r1 == null) goto L7;
        r0.putParcelable(r8.getPic(), (Parcelable) ZeusTransformUtils.preCheckCast(r1, Parcelable.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("IslandTemplates", "MemoryCollapseTemplate.getPics: key=" + r8.getPic() + " (bitmap icon)");
        goto L8
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandTemplates", "MemoryCollapseTemplate.getPics: failed to create bitmap icon for " + r8.getPic(), null, 4, null);
    L8:
        return r0;
    }

    public final BigIslandTextInfo getTextInfo() {
        return this.textInfo;
    }

    public int hashCode() {
        return (this.imageTextInfoLeft.hashCode() * 31) + this.textInfo.hashCode();
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandTemplates", "MemoryCollapseTemplate.toJSONObject");
        JSONObject r0 = new JSONObject();
        r0.put("imageTextInfoLeft", this.imageTextInfoLeft.toJSONObject());
        r0.put("textInfo", this.textInfo.toJSONObject());
        return r0;
    }

    public String toString() {
        return "MemoryCollapseTemplate(imageTextInfoLeft=" + this.imageTextInfoLeft + ", textInfo=" + this.textInfo + ')';
    }
}
