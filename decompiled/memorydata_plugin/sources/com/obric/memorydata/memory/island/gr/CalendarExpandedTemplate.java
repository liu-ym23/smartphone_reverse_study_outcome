package com.obric.memorydata.memory.island.gr;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Parcelable;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001+B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0017J\b\u0010\u001e\u001a\u00020\u001dH\u0017J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006,"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/CalendarExpandedTemplate;", "Lcom/obric/memorydata/memory/island/gr/ITemplateData;", "iconTextInfo", "Lcom/obric/memorydata/memory/island/gr/ExpandedIconTextInfo;", "textButton", "", "Lcom/obric/memorydata/memory/island/gr/ExpandedButtonActionInfo;", "picInfo", "Lcom/obric/memorydata/memory/island/gr/ExpandedIdentifyPicInfo;", "bgInfo", "Lcom/obric/memorydata/memory/island/gr/ExpandedBgInfo;", "<init>", "(Lcom/obric/memorydata/memory/island/gr/ExpandedIconTextInfo;Ljava/util/List;Lcom/obric/memorydata/memory/island/gr/ExpandedIdentifyPicInfo;Lcom/obric/memorydata/memory/island/gr/ExpandedBgInfo;)V", "getIconTextInfo", "()Lcom/obric/memorydata/memory/island/gr/ExpandedIconTextInfo;", "getTextButton", "()Ljava/util/List;", "getPicInfo", "()Lcom/obric/memorydata/memory/island/gr/ExpandedIdentifyPicInfo;", "getBgInfo", "()Lcom/obric/memorydata/memory/island/gr/ExpandedBgInfo;", "create", "Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "toJSONObject", "Lorg/json/JSONObject;", "getPics", "Landroid/os/Bundle;", "getActions", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CalendarExpandedTemplate implements b {
    public static final a Companion = null;
    public static final String TEMPLATE_ID = "com.obric.island_assistant:gr_common_expand_template_18";
    private final ExpandedBgInfo bgInfo;
    private final ExpandedIconTextInfo iconTextInfo;
    private final ExpandedIdentifyPicInfo picInfo;
    private final List<ExpandedButtonActionInfo> textButton;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/CalendarExpandedTemplate$Companion;", "", "<init>", "()V", "TEMPLATE_ID", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public CalendarExpandedTemplate(ExpandedIconTextInfo r3, List<ExpandedButtonActionInfo> r4, ExpandedIdentifyPicInfo r5, ExpandedBgInfo r6) {
        List<ExpandedButtonActionInfo> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "iconTextInfo");
        Intrinsics.checkNotNullParameter(r7, "textButton");
        this.iconTextInfo = r3;
        this.textButton = r7;
        this.picInfo = r5;
        this.bgInfo = r6;
    }

    public /* synthetic */ CalendarExpandedTemplate(ExpandedIconTextInfo r2, List r3, ExpandedIdentifyPicInfo r4, ExpandedBgInfo r5, int r6, DefaultConstructorMarker r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r2, r8, r4, r5);
    }

    public static /* synthetic */ CalendarExpandedTemplate copy$default(CalendarExpandedTemplate r1, ExpandedIconTextInfo r2, List r3, ExpandedIdentifyPicInfo r4, ExpandedBgInfo r5, int r6, Object r7) {
        List<ExpandedButtonActionInfo> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.iconTextInfo;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.textButton;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.picInfo;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.bgInfo;
    L15:
        return r1.copy(r2, r8, r4, r5);
    }

    public static /* synthetic */ IslandWidget create$default(CalendarExpandedTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    public final ExpandedIconTextInfo component1() {
        return this.iconTextInfo;
    }

    public final List<ExpandedButtonActionInfo> component2() {
        return this.textButton;
    }

    public final ExpandedIdentifyPicInfo component3() {
        return this.picInfo;
    }

    public final ExpandedBgInfo component4() {
        return this.bgInfo;
    }

    public final CalendarExpandedTemplate copy(ExpandedIconTextInfo r2, List<ExpandedButtonActionInfo> r3, ExpandedIdentifyPicInfo r4, ExpandedBgInfo r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "iconTextInfo");
        Intrinsics.checkNotNullParameter(r1, "textButton");
        return new CalendarExpandedTemplate(r2, r1, r4, r5);
    }

    public final IslandWidget create(Boolean r4) {
        RunLog.INSTANCE.debug("IslandTemplates", "CalendarExpandedTemplate.create: isDefault=" + r4 + ", buttons=" + this.textButton.size());
        return new IslandWidget(TEMPLATE_ID, (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin"), r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CalendarExpandedTemplate.class) == true) goto L8;
        return false;
    L8:
        CalendarExpandedTemplate r6 = (CalendarExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, CalendarExpandedTemplate.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.iconTextInfo, r6.iconTextInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textButton, r6.textButton) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.picInfo, r6.picInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgInfo, r6.bgInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public Bundle getActions() {
        Bundle r0 = new Bundle();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(this.textButton, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L13;
        ExpandedButtonActionInfo r3 = (ExpandedButtonActionInfo) ZeusTransformUtils.preCheckCast(r10.next(), ExpandedButtonActionInfo.class, "com.obric.memorydata.plugin");
        String r4 = r3.getAction();
        if (r4 == null) goto L4;
        Intent r5 = r3.getIntent();
        if (r5 == null) goto L4;
        PendingIntent r6 = PendingIntent.getBroadcast(r1, r4.hashCode(), r5, 201326592);
        Icon r7 = c.f10208a.a(r1, r3.getActionIconResId());
        String r8 = r3.getActionTitle();
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        Notification.Action r9 = new Notification.Action.Builder(r7, (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"), r6).build();
        Intrinsics.checkNotNullExpressionValue(r9, "build(...)");
        r0.putParcelable(r4, (Parcelable) ZeusTransformUtils.preCheckCast(r9, Parcelable.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("IslandTemplates", "CalendarExpandedTemplate.getActions: key=" + r4 + ", title=" + r3.getActionTitle());
        goto L4
    L13:
        return r0;
    }

    public final ExpandedBgInfo getBgInfo() {
        return this.bgInfo;
    }

    public final ExpandedIconTextInfo getIconTextInfo() {
        return this.iconTextInfo;
    }

    public final ExpandedIdentifyPicInfo getPicInfo() {
        return this.picInfo;
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public Bundle getPics() {
        Bundle r0 = new Bundle();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        ExpandedAnimIconInfo r3 = this.iconTextInfo.getAnimIconInfo();
        if (r3.getIconOverride() == null) goto L6;
        r0.putParcelable(r3.getSrc(), (Parcelable) ZeusTransformUtils.preCheckCast(r3.getIconOverride(), Parcelable.class, "com.obric.memorydata.plugin"));
        RunLog r4 = RunLog.INSTANCE;
        StringBuilder r6 = new StringBuilder().append("CalendarExpandedTemplate.getPics: using iconOverride for key=");
        String r7 = r3.getSrc();
    L5:
        r4.debug("IslandTemplates", r6.append(r7).toString());
    L9:
        String r5 = r3.getSrcDark();
        if (r5 == null) goto L16;
        Integer r8 = r3.getSrcDarkResId();
        if (r8 == null) goto L16;
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue();
        Icon r10 = c.f10208a.a(r1, r9);
        if (r10 == null) goto L16;
        r0.putParcelable(r5, (Parcelable) ZeusTransformUtils.preCheckCast(r10, Parcelable.class, "com.obric.memorydata.plugin"));
    L16:
        ExpandedIdentifyPicInfo r11 = this.picInfo;
        if (r11 == null) goto L25;
        String r12 = r11.getPic();
        if (r12 == null) goto L25;
        Integer r13 = r11.getPicResId();
        if (r13 == null) goto L25;
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue();
        Icon r15 = c.f10208a.a(r1, r14);
        if (r15 == null) goto L25;
        r0.putParcelable(r12, (Parcelable) ZeusTransformUtils.preCheckCast(r15, Parcelable.class, "com.obric.memorydata.plugin"));
    L25:
        return r0;
    L6:
        Icon r16 = c.f10208a.a(r1, r3.getSrcResId());
        if (r16 == null) goto L9;
        r0.putParcelable(r3.getSrc(), (Parcelable) ZeusTransformUtils.preCheckCast(r16, Parcelable.class, "com.obric.memorydata.plugin"));
        r4 = RunLog.INSTANCE;
        r6 = new StringBuilder().append("CalendarExpandedTemplate.getPics: key=").append(r3.getSrc());
        r7 = " (bitmap icon)";
        goto L5
    }

    public final List<ExpandedButtonActionInfo> getTextButton() {
        return this.textButton;
    }

    public int hashCode() {
        int r0 = ((this.iconTextInfo.hashCode() * 31) + this.textButton.hashCode()) * 31;
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
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    @Override // com.obric.memorydata.memory.island.gr.b
    public JSONObject toJSONObject() {
        RunLog.INSTANCE.debug("IslandTemplates", "CalendarExpandedTemplate.toJSONObject: title=" + this.iconTextInfo.getTitle() + ", buttons=" + this.textButton.size());
        JSONObject r0 = new JSONObject();
        r0.put("iconTextInfo", this.iconTextInfo.toJSONObject());
        ExpandedIdentifyPicInfo r1 = this.picInfo;
        if (r1 == null) goto L5;
        r0.put("picInfo", r1.toJSONObject());
    L5:
        ExpandedBgInfo r2 = this.bgInfo;
        if (r2 == null) goto L8;
        r0.put("bgInfo", r2.toJSONObject());
    L8:
        JSONArray r3 = new JSONArray();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.textButton, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r3.put(((ExpandedButtonActionInfo) ZeusTransformUtils.preCheckCast(r5.next(), ExpandedButtonActionInfo.class, "com.obric.memorydata.plugin")).toJSONObject());
        goto L10
    L12:
        Unit r6 = Unit.INSTANCE;
        r0.put("textButton", r3);
        return r0;
    }

    public String toString() {
        return "CalendarExpandedTemplate(iconTextInfo=" + this.iconTextInfo + ", textButton=" + this.textButton + ", picInfo=" + this.picInfo + ", bgInfo=" + this.bgInfo + ')';
    }
}
