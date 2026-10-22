package com.obric.livecard.api.entity;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000eJ\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003Jc\u0010,\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0017\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u000100¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002002\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u000207HÖ\u0001R*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001e¨\u00068"}, d2 = {"Lcom/obric/livecard/api/entity/CommonExpandedTemplate;", "", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", Params.CONTENT, "Lcom/obric/livecard/api/entity/Text;", "icon", "Lcom/obric/livecard/api/entity/Icon;", "title", "titleIcon", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "contentIcon", "(Ljava/util/List;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Ljava/util/List;Lcom/obric/livecard/api/entity/Icon;)V", "getButtonList$annotations", "()V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getButtonV2List", "setButtonV2List", "getContent", "()Lcom/obric/livecard/api/entity/Text;", "setContent", "(Lcom/obric/livecard/api/entity/Text;)V", "getContentIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setContentIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getIcon", "setIcon", "getTitle", "setTitle", "getTitleIcon", "setTitleIcon", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "equals", "other", "hashCode", "", "toString", "", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommonExpandedTemplate {
    private List<Button> buttonList;
    private List<ButtonV2> buttonV2List;
    private Text content;
    private Icon contentIcon;
    private Icon icon;
    private Text title;
    private Icon titleIcon;

    public CommonExpandedTemplate(List<Button> r3, Text r4, Icon r5, Text r6, Icon r7, List<ButtonV2> r8, Icon r9) {
        List<Button> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<ButtonV2> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "buttonList");
        Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r11, "buttonV2List");
        this.buttonList = r10;
        this.content = r4;
        this.icon = r5;
        this.title = r6;
        this.titleIcon = r7;
        this.buttonV2List = r11;
        this.contentIcon = r9;
    }

    public /* synthetic */ CommonExpandedTemplate(List r11, Text r12, Icon r13, Text r14, Icon r15, List r16, Icon r17, int r18, DefaultConstructorMarker r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        if ((r18 & 1) == 0) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        List r3 = r0;
        if ((r18 & 4) == 0) goto L8;
        Icon r5 = null;
    L10:
        if ((r18 & 8) == 0) goto L12;
        Text r6 = null;
    L14:
        if ((r18 & 16) == 0) goto L16;
        Icon r7 = null;
    L18:
        if ((r18 & 32) == 0) goto L20;
        r1 = CollectionsKt.emptyList();
    L20:
        List r8 = r1;
        if ((r18 & 64) == 0) goto L23;
        Icon r9 = null;
    L24:
        this(r3, r12, r5, r6, r7, r8, r9);
        return;
    L23:
        r9 = r17;
        goto L24
    L16:
        r7 = r15;
        goto L18
    L12:
        r6 = r14;
        goto L14
    L8:
        r5 = r13;
        goto L10
    }

    public static /* synthetic */ CommonExpandedTemplate copy$default(CommonExpandedTemplate r8, List r9, Text r10, Icon r11, Text r12, Icon r13, List r14, Icon r15, int r16, Object r17) {
        List<Button> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<ButtonV2> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        if ((r16 & 1) == 0) goto L6;
        r1 = r8.buttonList;
    L6:
        if ((r16 & 2) == 0) goto L8;
        Text r3 = r8.content;
    L10:
        if ((r16 & 4) == 0) goto L12;
        Icon r4 = r8.icon;
    L14:
        if ((r16 & 8) == 0) goto L16;
        Text r5 = r8.title;
    L18:
        if ((r16 & 16) == 0) goto L20;
        Icon r6 = r8.titleIcon;
    L22:
        if ((r16 & 32) == 0) goto L25;
        r2 = r8.buttonV2List;
    L25:
        if ((r16 & 64) == 0) goto L27;
        Icon r7 = r8.contentIcon;
    L29:
        return r8.copy(r1, r3, r4, r5, r6, r2, r7);
    L27:
        r7 = r15;
        goto L29
    L20:
        r6 = r13;
        goto L22
    L16:
        r5 = r12;
        goto L18
    L12:
        r4 = r11;
        goto L14
    L8:
        r3 = r10;
        goto L10
    }

    public static /* synthetic */ IslandWidget create$default(CommonExpandedTemplate r0, Boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.create(r1);
    }

    @Deprecated(message = "请使用buttonV2List")
    public static /* synthetic */ void getButtonList$annotations() {
    }

    public final List<Button> component1() {
        return this.buttonList;
    }

    public final Text component2() {
        return this.content;
    }

    public final Icon component3() {
        return this.icon;
    }

    public final Text component4() {
        return this.title;
    }

    public final Icon component5() {
        return this.titleIcon;
    }

    public final List<ButtonV2> component6() {
        return this.buttonV2List;
    }

    public final Icon component7() {
        return this.contentIcon;
    }

    public final CommonExpandedTemplate copy(List<Button> r11, Text r12, Icon r13, Text r14, Icon r15, List<ButtonV2> r16, Icon r17) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "buttonList");
        Intrinsics.checkNotNullParameter(r12, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r8, "buttonV2List");
        return new CommonExpandedTemplate(r3, r12, r13, r14, r15, r8, r17);
    }

    public final IslandWidget create(Boolean r14) {
        return new IslandWidget("com.obric.island_applet:common_expand_template", this, r14, null, null, null, null, null, null, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CommonExpandedTemplate.class) == true) goto L8;
        return false;
    L8:
        CommonExpandedTemplate r6 = (CommonExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, CommonExpandedTemplate.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.buttonList, r6.buttonList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.titleIcon, r6.titleIcon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonV2List, r6.buttonV2List) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.contentIcon, r6.contentIcon) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final List<Button> getButtonList() {
        return this.buttonList;
    }

    public final List<ButtonV2> getButtonV2List() {
        return this.buttonV2List;
    }

    public final Text getContent() {
        return this.content;
    }

    public final Icon getContentIcon() {
        return this.contentIcon;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final Text getTitle() {
        return this.title;
    }

    public final Icon getTitleIcon() {
        return this.titleIcon;
    }

    public int hashCode() {
        int r0 = ((this.buttonList.hashCode() * 31) + this.content.hashCode()) * 31;
        Icon r1 = this.icon;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Text r5 = this.title;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Icon r8 = this.titleIcon;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + this.buttonV2List.hashCode()) * 31;
        Icon r11 = this.contentIcon;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setButtonList(List<Button> r3) {
        List<Button> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.buttonList = r4;
    }

    public final void setButtonV2List(List<ButtonV2> r3) {
        List<ButtonV2> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.buttonV2List = r4;
    }

    public final void setContent(Text r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setContentIcon(Icon r1) {
        this.contentIcon = r1;
    }

    public final void setIcon(Icon r1) {
        this.icon = r1;
    }

    public final void setTitle(Text r1) {
        this.title = r1;
    }

    public final void setTitleIcon(Icon r1) {
        this.titleIcon = r1;
    }

    public String toString() {
        return "CommonExpandedTemplate(buttonList=" + this.buttonList + ", content=" + this.content + ", icon=" + this.icon + ", title=" + this.title + ", titleIcon=" + this.titleIcon + ", buttonV2List=" + this.buttonV2List + ", contentIcon=" + this.contentIcon + ')';
    }
}
