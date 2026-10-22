package com.obric.assistant.live.template;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006("}, d2 = {"Lcom/obric/assistant/live/template/ObricCommonCollapsedTemplate;", "Lcom/obric/assistant/live/template/IObricTemplate;", "endIcon", "Lcom/obric/livecard/api/entity/Icon;", "endText", "Lcom/obric/livecard/api/entity/Text;", "startIcon", "startText", "<init>", "(Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Icon;Lcom/obric/livecard/api/entity/Text;)V", "getEndIcon", "()Lcom/obric/livecard/api/entity/Icon;", "setEndIcon", "(Lcom/obric/livecard/api/entity/Icon;)V", "getEndText", "()Lcom/obric/livecard/api/entity/Text;", "setEndText", "(Lcom/obric/livecard/api/entity/Text;)V", "getStartIcon", "setStartIcon", "getStartText", "setStartText", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "component4", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricCommonCollapsedTemplate implements IObricTemplate {
    public static final a Companion = null;
    private static final String TEMPLATE_ID = "com.obric.island_assistant:common_collapse_template";
    private Icon endIcon;
    private Text endText;
    private Icon startIcon;
    private Text startText;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ObricCommonCollapsedTemplate() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ObricCommonCollapsedTemplate copy$default(ObricCommonCollapsedTemplate r0, Icon r1, Text r2, Icon r3, Text r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.endIcon;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.endText;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.startIcon;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.startText;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Icon component1() {
        return this.endIcon;
    }

    public final Text component2() {
        return this.endText;
    }

    public final Icon component3() {
        return this.startIcon;
    }

    public final Text component4() {
        return this.startText;
    }

    public final ObricCommonCollapsedTemplate copy(Icon r2, Text r3, Icon r4, Text r5) {
        return new ObricCommonCollapsedTemplate(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricCommonCollapsedTemplate) == true) goto L8;
        return false;
    L8:
        ObricCommonCollapsedTemplate r6 = (ObricCommonCollapsedTemplate) r5;
        if (Intrinsics.areEqual(this.endIcon, r6.endIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endText, r6.endText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.startIcon, r6.startIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.startText, r6.startText) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Icon r0 = this.endIcon;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Text r4 = this.endText;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Icon r7 = this.startIcon;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Text r10 = this.startText;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
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
        return "ObricCommonCollapsedTemplate(endIcon=" + this.endIcon + ", endText=" + this.endText + ", startIcon=" + this.startIcon + ", startText=" + this.startText + ')';
    }

    public final Icon getEndIcon() {
        return this.endIcon;
    }

    public final Text getEndText() {
        return this.endText;
    }

    public final Icon getStartIcon() {
        return this.startIcon;
    }

    public final Text getStartText() {
        return this.startText;
    }

    @Override // com.obric.assistant.live.template.IObricTemplate
    public IslandWidget create(Boolean r14) {
        return new IslandWidget(TEMPLATE_ID, this, r14, null, null, null, null, null, null, 504, null);
    }

    public final void setEndIcon(Icon r1) {
        this.endIcon = r1;
    }

    public final void setEndText(Text r1) {
        this.endText = r1;
    }

    public final void setStartIcon(Icon r1) {
        this.startIcon = r1;
    }

    public final void setStartText(Text r1) {
        this.startText = r1;
    }

    public ObricCommonCollapsedTemplate(Icon r1, Text r2, Icon r3, Text r4) {
        this.endIcon = r1;
        this.endText = r2;
        this.startIcon = r3;
        this.startText = r4;
    }

    public /* synthetic */ ObricCommonCollapsedTemplate(Icon r2, Text r3, Icon r4, Text r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
