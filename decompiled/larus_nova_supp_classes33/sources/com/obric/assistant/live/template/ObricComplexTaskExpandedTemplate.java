package com.obric.assistant.live.template;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.livecard.api.entity.IslandWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u001aJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J0\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lcom/obric/assistant/live/template/ObricComplexTaskExpandedTemplate;", "Lcom/obric/assistant/live/template/IObricTemplate;", "dialogue", "Lcom/obric/assistant/live/template/ObricExpandedDialogueTemplate;", "normal", "Lcom/obric/assistant/live/template/ObricComplexTaskNormalExpandedTemplate;", "showPro", "", "<init>", "(Lcom/obric/assistant/live/template/ObricExpandedDialogueTemplate;Lcom/obric/assistant/live/template/ObricComplexTaskNormalExpandedTemplate;Ljava/lang/Boolean;)V", "getDialogue", "()Lcom/obric/assistant/live/template/ObricExpandedDialogueTemplate;", "setDialogue", "(Lcom/obric/assistant/live/template/ObricExpandedDialogueTemplate;)V", "getNormal", "()Lcom/obric/assistant/live/template/ObricComplexTaskNormalExpandedTemplate;", "setNormal", "(Lcom/obric/assistant/live/template/ObricComplexTaskNormalExpandedTemplate;)V", "getShowPro", "()Ljava/lang/Boolean;", "setShowPro", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "create", "Lcom/obric/livecard/api/entity/IslandWidget;", "isDefault", "(Ljava/lang/Boolean;)Lcom/obric/livecard/api/entity/IslandWidget;", "component1", "component2", "component3", "copy", "(Lcom/obric/assistant/live/template/ObricExpandedDialogueTemplate;Lcom/obric/assistant/live/template/ObricComplexTaskNormalExpandedTemplate;Ljava/lang/Boolean;)Lcom/obric/assistant/live/template/ObricComplexTaskExpandedTemplate;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "", "toString", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricComplexTaskExpandedTemplate implements IObricTemplate {
    public static final a Companion = null;
    private static final String TEMPLATE_ID = "com.obric.island_assistant:complex_task_dialogue_island";
    private ObricExpandedDialogueTemplate dialogue;
    private ObricComplexTaskNormalExpandedTemplate normal;
    private Boolean showPro;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ObricComplexTaskExpandedTemplate copy$default(ObricComplexTaskExpandedTemplate r0, ObricExpandedDialogueTemplate r1, ObricComplexTaskNormalExpandedTemplate r2, Boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.dialogue;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.normal;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.showPro;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final ObricExpandedDialogueTemplate component1() {
        return this.dialogue;
    }

    public final ObricComplexTaskNormalExpandedTemplate component2() {
        return this.normal;
    }

    public final Boolean component3() {
        return this.showPro;
    }

    public final ObricComplexTaskExpandedTemplate copy(ObricExpandedDialogueTemplate r2, ObricComplexTaskNormalExpandedTemplate r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "normal");
        return new ObricComplexTaskExpandedTemplate(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricComplexTaskExpandedTemplate) == true) goto L8;
        return false;
    L8:
        ObricComplexTaskExpandedTemplate r6 = (ObricComplexTaskExpandedTemplate) r5;
        if (Intrinsics.areEqual(this.dialogue, r6.dialogue) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.normal, r6.normal) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.showPro, r6.showPro) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        ObricExpandedDialogueTemplate r0 = this.dialogue;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.normal.hashCode()) * 31;
        Boolean r4 = this.showPro;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricComplexTaskExpandedTemplate(dialogue=" + this.dialogue + ", normal=" + this.normal + ", showPro=" + this.showPro + ')';
    }

    public final ObricExpandedDialogueTemplate getDialogue() {
        return this.dialogue;
    }

    public final ObricComplexTaskNormalExpandedTemplate getNormal() {
        return this.normal;
    }

    public final Boolean getShowPro() {
        return this.showPro;
    }

    @Override // com.obric.assistant.live.template.IObricTemplate
    public IslandWidget create(Boolean r14) {
        return new IslandWidget(TEMPLATE_ID, this, r14, null, null, null, null, null, null, 504, null);
    }

    public final void setDialogue(ObricExpandedDialogueTemplate r1) {
        this.dialogue = r1;
    }

    public final void setNormal(ObricComplexTaskNormalExpandedTemplate r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.normal = r2;
    }

    public final void setShowPro(Boolean r1) {
        this.showPro = r1;
    }

    public ObricComplexTaskExpandedTemplate(ObricExpandedDialogueTemplate r2, ObricComplexTaskNormalExpandedTemplate r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "normal");
        this.dialogue = r2;
        this.normal = r3;
        this.showPro = r4;
    }

    public /* synthetic */ ObricComplexTaskExpandedTemplate(ObricExpandedDialogueTemplate r1, ObricComplexTaskNormalExpandedTemplate r2, Boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }
}
