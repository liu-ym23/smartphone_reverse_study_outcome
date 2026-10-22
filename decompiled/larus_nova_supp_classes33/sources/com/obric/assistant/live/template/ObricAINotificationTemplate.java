package com.obric.assistant.live.template;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.livecard.api.entity.Button;
import com.obric.livecard.api.entity.ButtonV2;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0001:BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0002\u0010+J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0003J[\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bHÆ\u0001J\u0013\u00103\u001a\u00020*2\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$¨\u0006;"}, d2 = {"Lcom/obric/assistant/live/template/ObricAINotificationTemplate;", "Lcom/obric/assistant/live/template/IObricTemplate;", "leftIcon", "Lcom/obric/livecard/api/entity/Icon;", "rightIcon", "Lcom/obric/assistant/live/template/ObricAINotificationTemplateIcon;", "title", "Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;", "description", "Lcom/obric/assistant/live/template/ObricAINotificationDescription;", "buttonList", "", "Lcom/obric/livecard/api/entity/Button;", "buttonV2List", "Lcom/obric/livecard/api/entity/ButtonV2;", "<init>", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/assistant/live/template/ObricAINotificationTemplateIcon;Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;Lcom/obric/assistant/live/template/ObricAINotificationDescription;Ljava/util/List;Ljava/util/List;)V", "getLeftIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setLeftIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getRightIcon", "()Lcom/obric/assistant/live/template/ObricAINotificationTemplateIcon;", "setRightIcon", "(Lcom/obric/assistant/live/template/ObricAINotificationTemplateIcon;)V", "getTitle", "()Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;", "setTitle", "(Lcom/obric/assistant/live/template/ObricAINotificationTemplateText;)V", "getDescription", "()Lcom/obric/assistant/live/template/ObricAINotificationDescription;", "setDescription", "(Lcom/obric/assistant/live/template/ObricAINotificationDescription;)V", "getButtonList", "()Ljava/util/List;", "setButtonList", "(Ljava/util/List;)V", "getButtonV2List", "setButtonV2List", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAINotificationTemplate implements IObricTemplate {
    public static final a Companion = null;
    private static final String TEMPLATE_ID = "com.obric.island_assistant:ai_notification_template";
    private List<Button> buttonList;
    private List<ButtonV2> buttonV2List;
    private ObricAINotificationDescription description;
    private Icon leftIcon;
    private ObricAINotificationTemplateIcon rightIcon;
    private ObricAINotificationTemplateText title;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricAINotificationTemplate copy$default(ObricAINotificationTemplate r4, Icon r5, ObricAINotificationTemplateIcon r6, ObricAINotificationTemplateText r7, ObricAINotificationDescription r8, List r9, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.leftIcon;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.rightIcon;
    L8:
        ObricAINotificationTemplateIcon r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.title;
    L11:
        ObricAINotificationTemplateText r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.description;
    L14:
        ObricAINotificationDescription r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.buttonList;
    L17:
        List r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.buttonV2List;
    L20:
        Icon r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Icon component1() {
        return this.leftIcon;
    }

    public final ObricAINotificationTemplateIcon component2() {
        return this.rightIcon;
    }

    public final ObricAINotificationTemplateText component3() {
        return this.title;
    }

    public final ObricAINotificationDescription component4() {
        return this.description;
    }

    public final List<Button> component5() {
        return this.buttonList;
    }

    public final List<ButtonV2> component6() {
        return this.buttonV2List;
    }

    public final ObricAINotificationTemplate copy(Icon r9, ObricAINotificationTemplateIcon r10, ObricAINotificationTemplateText r11, ObricAINotificationDescription r12, List<Button> r13, List<ButtonV2> r14) {
        Intrinsics.checkNotNullParameter(r11, "title");
        return new ObricAINotificationTemplate(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricAINotificationTemplate) == true) goto L8;
        return false;
    L8:
        ObricAINotificationTemplate r6 = (ObricAINotificationTemplate) r5;
        if (Intrinsics.areEqual(this.leftIcon, r6.leftIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightIcon, r6.rightIcon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.buttonList, r6.buttonList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buttonV2List, r6.buttonV2List) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Icon r0 = this.leftIcon;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ObricAINotificationTemplateIcon r4 = this.rightIcon;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.title.hashCode()) * 31;
        ObricAINotificationDescription r7 = this.description;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<Button> r10 = this.buttonList;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<ButtonV2> r13 = this.buttonV2List;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricAINotificationTemplate(leftIcon=" + this.leftIcon + ", rightIcon=" + this.rightIcon + ", title=" + this.title + ", description=" + this.description + ", buttonList=" + this.buttonList + ", buttonV2List=" + this.buttonV2List + ')';
    }

    public final List<Button> getButtonList() {
        return this.buttonList;
    }

    public final List<ButtonV2> getButtonV2List() {
        return this.buttonV2List;
    }

    public final ObricAINotificationDescription getDescription() {
        return this.description;
    }

    public final Icon getLeftIcon() {
        return this.leftIcon;
    }

    public final ObricAINotificationTemplateIcon getRightIcon() {
        return this.rightIcon;
    }

    public final ObricAINotificationTemplateText getTitle() {
        return this.title;
    }

    @Override // com.obric.assistant.live.template.IObricTemplate
    public IslandWidget create(Boolean r14) {
        return new IslandWidget(TEMPLATE_ID, this, r14, null, null, null, null, null, null, 504, null);
    }

    public final void setButtonList(List<Button> r1) {
        this.buttonList = r1;
    }

    public final void setButtonV2List(List<ButtonV2> r1) {
        this.buttonV2List = r1;
    }

    public final void setDescription(ObricAINotificationDescription r1) {
        this.description = r1;
    }

    public final void setLeftIcon(Icon r1) {
        this.leftIcon = r1;
    }

    public final void setRightIcon(ObricAINotificationTemplateIcon r1) {
        this.rightIcon = r1;
    }

    public final void setTitle(ObricAINotificationTemplateText r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    public ObricAINotificationTemplate(Icon r2, ObricAINotificationTemplateIcon r3, ObricAINotificationTemplateText r4, ObricAINotificationDescription r5, List<Button> r6, List<ButtonV2> r7) {
        Intrinsics.checkNotNullParameter(r4, "title");
        this.leftIcon = r2;
        this.rightIcon = r3;
        this.title = r4;
        this.description = r5;
        this.buttonList = r6;
        this.buttonV2List = r7;
    }

    public /* synthetic */ ObricAINotificationTemplate(Icon r10, ObricAINotificationTemplateIcon r11, ObricAINotificationTemplateText r12, ObricAINotificationDescription r13, List r14, List r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L5;
        Icon r3 = null;
    L7:
        if ((r16 & 2) == 0) goto L9;
        ObricAINotificationTemplateIcon r4 = null;
    L11:
        if ((r16 & 8) == 0) goto L13;
        ObricAINotificationDescription r6 = null;
    L15:
        if ((r16 & 16) == 0) goto L17;
        List r7 = null;
    L19:
        if ((r16 & 32) == 0) goto L21;
        List r8 = null;
    L22:
        this(r3, r4, r12, r6, r7, r8);
        return;
    L21:
        r8 = r15;
        goto L22
    L17:
        r7 = r14;
        goto L19
    L13:
        r6 = r13;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }
}
