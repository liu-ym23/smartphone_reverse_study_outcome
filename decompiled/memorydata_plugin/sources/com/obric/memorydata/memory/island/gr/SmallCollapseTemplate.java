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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0017J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/SmallCollapseTemplate;", "Lcom/obric/memorydata/memory/island/gr/ITemplateData;", "picInfo", "Lcom/obric/memorydata/memory/island/gr/BigIslandPicInfo;", "<init>", "(Lcom/obric/memorydata/memory/island/gr/BigIslandPicInfo;)V", "getPicInfo", "()Lcom/obric/memorydata/memory/island/gr/BigIslandPicInfo;", "create", "Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "toJSONObject", "Lorg/json/JSONObject;", "getPics", "Landroid/os/Bundle;", "getActions", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SmallCollapseTemplate implements b {
    public static final a Companion = null;
    public static final String TEMPLATE_ID = "com.obric.island_assistant:gr_common_small_collapse_template";
    private final BigIslandPicInfo picInfo;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/SmallCollapseTemplate$Companion;", "", "<init>", "()V", "TEMPLATE_ID", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public SmallCollapseTemplate(BigIslandPicInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "picInfo");
        this.picInfo = r2;
    }

    public static /* synthetic */ SmallCollapseTemplate copy$default(SmallCollapseTemplate r0, BigIslandPicInfo r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.picInfo;
    L6:
        return r0.copy(r1);
    }

    public static /* synthetic */ IslandWidget create$default(SmallCollapseTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    public final BigIslandPicInfo component1() {
        return this.picInfo;
    }

    public final SmallCollapseTemplate copy(BigIslandPicInfo r1) {
        Intrinsics.checkNotNullParameter(r1, "picInfo");
        return new SmallCollapseTemplate(r1);
    }

    public final IslandWidget create(Boolean r4) {
        RunLog.INSTANCE.debug("IslandTemplates", "SmallCollapseTemplate.create: isDefault=" + r4);
        return new IslandWidget(TEMPLATE_ID, (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin"), r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SmallCollapseTemplate.class) == true) goto L8;
        return false;
    L8:
        SmallCollapseTemplate r6 = (SmallCollapseTemplate) ZeusTransformUtils.preCheckCast(r5, SmallCollapseTemplate.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.picInfo, r6.picInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public Bundle getActions() {
        return new Bundle();
    }

    public final BigIslandPicInfo getPicInfo() {
        return this.picInfo;
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public Bundle getPics() {
        Bundle r0 = new Bundle();
        Icon r1 = c.f10208a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.picInfo.getPicResId());
        if (r1 == null) goto L5;
        r0.putParcelable(this.picInfo.getPic(), (Parcelable) ZeusTransformUtils.preCheckCast(r1, Parcelable.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("IslandTemplates", "SmallCollapseTemplate.getPics: key=" + this.picInfo.getPic() + " (bitmap icon)");
    L6:
        return r0;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandTemplates", "SmallCollapseTemplate.getPics: failed to create bitmap icon for " + this.picInfo.getPic(), null, 4, null);
        goto L6
    }

    public int hashCode() {
        return this.picInfo.hashCode();
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandTemplates", "SmallCollapseTemplate.toJSONObject: pic=" + this.picInfo.getPic());
        JSONObject r0 = new JSONObject();
        r0.put("picInfo", this.picInfo.toJSONObject());
        return r0;
    }

    public String toString() {
        return "SmallCollapseTemplate(picInfo=" + this.picInfo + ')';
    }
}
