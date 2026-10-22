package com.obric.memorydata.memory.island.gr;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Parcelable;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001*B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0017J\b\u0010\u0013\u001a\u00020\u001dH\u0017J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J;\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/MemoryExpandedTemplate;", "Lcom/obric/memorydata/memory/island/gr/ITemplateData;", "baseInfo", "Lcom/obric/memorydata/memory/island/gr/ExpandedBaseInfo;", "picInfo", "Lcom/obric/memorydata/memory/island/gr/ExpandedIdentifyPicInfo;", "bgInfo", "Lcom/obric/memorydata/memory/island/gr/ExpandedBgInfo;", "actions", "", "Lcom/obric/memorydata/memory/island/gr/ExpandedImageTextActionInfo;", "<init>", "(Lcom/obric/memorydata/memory/island/gr/ExpandedBaseInfo;Lcom/obric/memorydata/memory/island/gr/ExpandedIdentifyPicInfo;Lcom/obric/memorydata/memory/island/gr/ExpandedBgInfo;Ljava/util/List;)V", "getBaseInfo", "()Lcom/obric/memorydata/memory/island/gr/ExpandedBaseInfo;", "getPicInfo", "()Lcom/obric/memorydata/memory/island/gr/ExpandedIdentifyPicInfo;", "getBgInfo", "()Lcom/obric/memorydata/memory/island/gr/ExpandedBgInfo;", "getActions", "()Ljava/util/List;", "create", "Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "toJSONObject", "Lorg/json/JSONObject;", "getPics", "Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryExpandedTemplate implements b {
    public static final a Companion = null;
    public static final String TEMPLATE_ID = "com.obric.island_assistant:gr_common_expand_template_16";
    private final List<ExpandedImageTextActionInfo> actions;
    private final ExpandedBaseInfo baseInfo;
    private final ExpandedBgInfo bgInfo;
    private final ExpandedIdentifyPicInfo picInfo;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/MemoryExpandedTemplate$Companion;", "", "<init>", "()V", "TEMPLATE_ID", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public MemoryExpandedTemplate(ExpandedBaseInfo r3, ExpandedIdentifyPicInfo r4, ExpandedBgInfo r5, List<ExpandedImageTextActionInfo> r6) {
        List<ExpandedImageTextActionInfo> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "baseInfo");
        Intrinsics.checkNotNullParameter(r7, "actions");
        this.baseInfo = r3;
        this.picInfo = r4;
        this.bgInfo = r5;
        this.actions = r7;
    }

    public /* synthetic */ MemoryExpandedTemplate(ExpandedBaseInfo r2, ExpandedIdentifyPicInfo r3, ExpandedBgInfo r4, List r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r8 = CollectionsKt.emptyList();
    L11:
        this(r2, r3, r4, r8);
    }

    public static /* synthetic */ MemoryExpandedTemplate copy$default(MemoryExpandedTemplate r1, ExpandedBaseInfo r2, ExpandedIdentifyPicInfo r3, ExpandedBgInfo r4, List r5, int r6, Object r7) {
        List<ExpandedImageTextActionInfo> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.baseInfo;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.picInfo;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.bgInfo;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = r1.actions;
    L15:
        return r1.copy(r2, r3, r4, r8);
    }

    public static /* synthetic */ IslandWidget create$default(MemoryExpandedTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    public final ExpandedBaseInfo component1() {
        return this.baseInfo;
    }

    public final ExpandedIdentifyPicInfo component2() {
        return this.picInfo;
    }

    public final ExpandedBgInfo component3() {
        return this.bgInfo;
    }

    public final List<ExpandedImageTextActionInfo> component4() {
        return this.actions;
    }

    public final MemoryExpandedTemplate copy(ExpandedBaseInfo r2, ExpandedIdentifyPicInfo r3, ExpandedBgInfo r4, List<ExpandedImageTextActionInfo> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "baseInfo");
        Intrinsics.checkNotNullParameter(r1, "actions");
        return new MemoryExpandedTemplate(r2, r3, r4, r1);
    }

    public final IslandWidget create(Boolean r4) {
        RunLog.INSTANCE.debug("IslandTemplates", "MemoryExpandedTemplate.create: isDefault=" + r4);
        return new IslandWidget("com.obric.island_assistant:gr_common_expand_template_16", (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin"), r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MemoryExpandedTemplate.class) == true) goto L8;
        return false;
    L8:
        MemoryExpandedTemplate r6 = (MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.baseInfo, r6.baseInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.picInfo, r6.picInfo) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bgInfo, r6.bgInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public Bundle getActions() {
        Bundle r0 = new Bundle();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(this.actions, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L16;
        ExpandedImageTextActionInfo r3 = (ExpandedImageTextActionInfo) ZeusTransformUtils.preCheckCast(r9.next(), ExpandedImageTextActionInfo.class, "com.obric.memorydata.plugin");
        Intent r4 = r3.getIntent();
        if (r3.getAction() == null) goto L4;
        if (r4 == null) goto L4;
        String r5 = r3.getAction();
        if (r5 == null) goto L11;
        int r6 = r5.hashCode();
    L12:
        PendingIntent r7 = PendingIntent.getBroadcast(r1, r6, r4, 201326592);
        Icon r8 = c.f10208a.a(r1, r3.getActionIconResId());
        String r10 = r3.getActionTitle();
        if (r10 != null) goto L15;
        r10 = "";
    L15:
        Notification.Action r11 = new Notification.Action.Builder(r8, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"), r7).build();
        Intrinsics.checkNotNullExpressionValue(r11, "build(...)");
        r0.putParcelable(r3.getAction(), (Parcelable) ZeusTransformUtils.preCheckCast(r11, Parcelable.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("IslandTemplates", "MemoryExpandedTemplate.getActions: key=" + r3.getAction());
        goto L4
    L11:
        r6 = 0;
        goto L12
    L16:
        return r0;
    }

    /* JADX INFO: renamed from: getActions, reason: collision with other method in class */
    public final List<ExpandedImageTextActionInfo> m716getActions() {
        return this.actions;
    }

    public final ExpandedBaseInfo getBaseInfo() {
        return this.baseInfo;
    }

    public final ExpandedBgInfo getBgInfo() {
        return this.bgInfo;
    }

    public final ExpandedIdentifyPicInfo getPicInfo() {
        return this.picInfo;
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public Bundle getPics() {
        Bundle r0 = new Bundle();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        ExpandedIdentifyPicInfo r3 = this.picInfo;
        if (r3 != null) goto L5;
    L18:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(this.actions, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r9.hasNext() == false) goto L26;
        ExpandedImageTextActionInfo r4 = (ExpandedImageTextActionInfo) ZeusTransformUtils.preCheckCast(r9.next(), ExpandedImageTextActionInfo.class, "com.obric.memorydata.plugin");
        String r6 = r4.getActionIcon();
        if (r6 == null) goto L20;
        Icon r5 = c.f10208a.a(r1, r4.getActionIconResId());
        if (r5 == null) goto L20;
        r0.putParcelable(r6, (Parcelable) ZeusTransformUtils.preCheckCast(r5, Parcelable.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("IslandTemplates", "MemoryExpandedTemplate.getPics: action iconKey=" + r6 + " (bitmap icon)");
        goto L20
    L26:
        return r0;
    L5:
        if (r3.getPic() != null) goto L7;
    L11:
        String r7 = r3.getPicDark();
        if (r7 == null) goto L18;
        Integer r8 = r3.getPicDarkResId();
        if (r8 == null) goto L18;
        Icon r10 = c.f10208a.a(r1, ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue());
        if (r10 == null) goto L18;
        r0.putParcelable(r7, (Parcelable) ZeusTransformUtils.preCheckCast(r10, Parcelable.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("IslandTemplates", "MemoryExpandedTemplate.getPics: darkKey=" + r7 + " (bitmap icon)");
        goto L18
    L7:
        if (r3.getPicResId() == null) goto L11;
        c r11 = c.f10208a;
        Integer r12 = r3.getPicResId();
        Intrinsics.checkNotNull(r12);
        Icon r13 = r11.a(r1, r12.intValue());
        if (r13 == null) goto L11;
        r0.putParcelable(r3.getPic(), (Parcelable) ZeusTransformUtils.preCheckCast(r13, Parcelable.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("IslandTemplates", "MemoryExpandedTemplate.getPics: key=" + r3.getPic() + " (bitmap icon)");
        goto L11
    }

    public int hashCode() {
        int r0 = this.baseInfo.hashCode() * 31;
        ExpandedIdentifyPicInfo r1 = this.picInfo;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        ExpandedBgInfo r5 = this.bgInfo;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + this.actions.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandTemplates", "MemoryExpandedTemplate.toJSONObject: title=" + this.baseInfo.getTitle());
        JSONObject r0 = new JSONObject();
        ExpandedBgInfo r1 = this.bgInfo;
        if (r1 == null) goto L5;
        r0.put("bgInfo", r1.toJSONObject());
    L5:
        JSONObject r2 = new JSONObject();
        r2.put("title", this.baseInfo.getTitle());
        r2.put(Params.CONTENT, this.baseInfo.getContent());
        String r3 = this.baseInfo.getColorTitle();
        if (r3 == null) goto L8;
        r2.put("colorTitle", r3);
    L8:
        String r4 = this.baseInfo.getColorContent();
        if (r4 == null) goto L11;
        r2.put("colorContent", r4);
    L11:
        JSONObject r5 = new JSONObject();
        r5.put("type", 0);
        ExpandedIdentifyPicInfo r6 = this.picInfo;
        if (r6 == null) goto L16;
        String r7 = r6.getPic();
        if (r7 == null) goto L16;
        r5.put("src", r7);
    L16:
        ExpandedIdentifyPicInfo r8 = this.picInfo;
        if (r8 == null) goto L21;
        String r9 = r8.getPicDark();
        if (r9 == null) goto L21;
        r5.put("srcDark", r9);
    L21:
        r2.put("animIconInfo", r5);
        r0.put("iconTextInfo", r2);
        JSONArray r10 = new JSONArray();
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(this.actions, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L23:
        if (r11.hasNext() == false) goto L25;
        r10.put(((ExpandedImageTextActionInfo) ZeusTransformUtils.preCheckCast(r11.next(), ExpandedImageTextActionInfo.class, "com.obric.memorydata.plugin")).toJSONObject());
        goto L23
    L25:
        Unit r12 = Unit.INSTANCE;
        r0.put("actions", r10);
        return r0;
    }

    public String toString() {
        return "MemoryExpandedTemplate(baseInfo=" + this.baseInfo + ", picInfo=" + this.picInfo + ", bgInfo=" + this.bgInfo + ", actions=" + this.actions + ')';
    }
}
