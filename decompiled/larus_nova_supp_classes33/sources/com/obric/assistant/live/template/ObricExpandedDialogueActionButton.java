package com.obric.assistant.live.template;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.livecard.api.entity.ColorToken;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.Text;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003JP\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00062"}, d2 = {"Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;", "", "id", "", "icon", "Lcom/obric/livecard/api/entity/Icon;", "text", "Lcom/obric/livecard/api/entity/Text;", "dismissKeyguard", "", "backgroundColor", "color", "Lcom/obric/livecard/api/entity/ColorToken;", "<init>", "(Ljava/lang/String;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Ljava/lang/Boolean;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;)V", "getId", "()Ljava/lang/String;", "getIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getText", "()Lcom/obric/livecard/api/entity/Text;", "setText", "(Lcom/obric/livecard/api/entity/Text;)V", "getDismissKeyguard", "()Ljava/lang/Boolean;", "setDismissKeyguard", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getBackgroundColor", "setBackgroundColor", "(Ljava/lang/String;)V", "getColor", "()Lcom/obric/livecard/api/entity/ColorToken;", "setColor", "(Lcom/obric/livecard/api/entity/ColorToken;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Ljava/lang/Boolean;Ljava/lang/String;Lcom/obric/livecard/api/entity/ColorToken;)Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricExpandedDialogueActionButton {
    private String backgroundColor;
    private ColorToken color;
    private Boolean dismissKeyguard;
    private Icon icon;
    private final String id;
    private Text text;

    public static /* synthetic */ ObricExpandedDialogueActionButton copy$default(ObricExpandedDialogueActionButton r4, String r5, Icon r6, Text r7, Boolean r8, String r9, ColorToken r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.icon;
    L8:
        Icon r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.text;
    L11:
        Text r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.dismissKeyguard;
    L14:
        Boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.backgroundColor;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.color;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.id;
    }

    public final Icon component2() {
        return this.icon;
    }

    public final Text component3() {
        return this.text;
    }

    public final Boolean component4() {
        return this.dismissKeyguard;
    }

    public final String component5() {
        return this.backgroundColor;
    }

    public final ColorToken component6() {
        return this.color;
    }

    public final ObricExpandedDialogueActionButton copy(String r9, Icon r10, Text r11, Boolean r12, String r13, ColorToken r14) {
        Intrinsics.checkNotNullParameter(r9, "id");
        Intrinsics.checkNotNullParameter(r10, "icon");
        Intrinsics.checkNotNullParameter(r11, "text");
        return new ObricExpandedDialogueActionButton(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricExpandedDialogueActionButton) == true) goto L8;
        return false;
    L8:
        ObricExpandedDialogueActionButton r6 = (ObricExpandedDialogueActionButton) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.dismissKeyguard, r6.dismissKeyguard) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.backgroundColor, r6.backgroundColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.color, r6.color) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.id.hashCode() * 31) + this.icon.hashCode()) * 31) + this.text.hashCode()) * 31;
        Boolean r1 = this.dismissKeyguard;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.backgroundColor;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        ColorToken r8 = this.color;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricExpandedDialogueActionButton(id=" + this.id + ", icon=" + this.icon + ", text=" + this.text + ", dismissKeyguard=" + this.dismissKeyguard + ", backgroundColor=" + this.backgroundColor + ", color=" + this.color + ')';
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final ColorToken getColor() {
        return this.color;
    }

    public final Boolean getDismissKeyguard() {
        return this.dismissKeyguard;
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final Text getText() {
        return this.text;
    }

    public final void setBackgroundColor(String r1) {
        this.backgroundColor = r1;
    }

    public final void setColor(ColorToken r1) {
        this.color = r1;
    }

    public final void setDismissKeyguard(Boolean r1) {
        this.dismissKeyguard = r1;
    }

    public final void setIcon(Icon r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.icon = r2;
    }

    public final void setText(Text r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }

    public ObricExpandedDialogueActionButton(String r2, Icon r3, Text r4, Boolean r5, String r6, ColorToken r7) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "icon");
        Intrinsics.checkNotNullParameter(r4, "text");
        this.id = r2;
        this.icon = r3;
        this.text = r4;
        this.dismissKeyguard = r5;
        this.backgroundColor = r6;
        this.color = r7;
    }

    public /* synthetic */ ObricExpandedDialogueActionButton(String r8, Icon r9, Text r10, Boolean r11, String r12, ColorToken r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = "actionBtn";
    L5:
        String r1 = r8;
        if ((r14 & 8) == 0) goto L8;
        Boolean r4 = null;
    L10:
        if ((r14 & 16) == 0) goto L12;
        String r5 = null;
    L14:
        if ((r14 & 32) == 0) goto L16;
        ColorToken r6 = null;
    L17:
        this(r1, r9, r10, r4, r5, r6);
        return;
    L16:
        r6 = r13;
        goto L17
    L12:
        r5 = r12;
        goto L14
    L8:
        r4 = r11;
        goto L10
    }
}
