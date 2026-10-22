package com.obric.assistant.live.template;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.livecard.api.entity.Text;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003JS\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001d¨\u00060"}, d2 = {"Lcom/obric/assistant/live/template/ObricExpandedDialogueTemplate;", "", "title", "Lcom/obric/assistant/live/template/ObricExpandedDialogueTitle;", "actionBtn", "Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;", "clarifyBtnList", "", "contentText", "Lcom/obric/livecard/api/entity/Text;", "describeText", "notify", "<init>", "(Lcom/obric/assistant/live/template/ObricExpandedDialogueTitle;Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;Ljava/util/List;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Text;Lcom/obric/livecard/api/entity/Text;)V", "getTitle", "()Lcom/obric/assistant/live/template/ObricExpandedDialogueTitle;", "setTitle", "(Lcom/obric/assistant/live/template/ObricExpandedDialogueTitle;)V", "getActionBtn", "()Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;", "setActionBtn", "(Lcom/obric/assistant/live/template/ObricExpandedDialogueActionButton;)V", "getClarifyBtnList", "()Ljava/util/List;", "setClarifyBtnList", "(Ljava/util/List;)V", "getContentText", "()Lcom/obric/livecard/api/entity/Text;", "setContentText", "(Lcom/obric/livecard/api/entity/Text;)V", "getDescribeText", "setDescribeText", "getNotify", "setNotify", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricExpandedDialogueTemplate {
    private ObricExpandedDialogueActionButton actionBtn;
    private List<ObricExpandedDialogueActionButton> clarifyBtnList;
    private Text contentText;
    private Text describeText;
    private Text notify;
    private ObricExpandedDialogueTitle title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricExpandedDialogueTemplate copy$default(ObricExpandedDialogueTemplate r4, ObricExpandedDialogueTitle r5, ObricExpandedDialogueActionButton r6, List r7, Text r8, Text r9, Text r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.title;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.actionBtn;
    L8:
        ObricExpandedDialogueActionButton r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.clarifyBtnList;
    L11:
        List r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.contentText;
    L14:
        Text r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.describeText;
    L17:
        Text r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.notify;
    L20:
        ObricExpandedDialogueTitle r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final ObricExpandedDialogueTitle component1() {
        return this.title;
    }

    public final ObricExpandedDialogueActionButton component2() {
        return this.actionBtn;
    }

    public final List<ObricExpandedDialogueActionButton> component3() {
        return this.clarifyBtnList;
    }

    public final Text component4() {
        return this.contentText;
    }

    public final Text component5() {
        return this.describeText;
    }

    public final Text component6() {
        return this.notify;
    }

    public final ObricExpandedDialogueTemplate copy(ObricExpandedDialogueTitle r9, ObricExpandedDialogueActionButton r10, List<ObricExpandedDialogueActionButton> r11, Text r12, Text r13, Text r14) {
        Intrinsics.checkNotNullParameter(r9, "title");
        Intrinsics.checkNotNullParameter(r12, "contentText");
        return new ObricExpandedDialogueTemplate(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricExpandedDialogueTemplate) == true) goto L8;
        return false;
    L8:
        ObricExpandedDialogueTemplate r6 = (ObricExpandedDialogueTemplate) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionBtn, r6.actionBtn) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.clarifyBtnList, r6.clarifyBtnList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contentText, r6.contentText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.describeText, r6.describeText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.notify, r6.notify) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = this.title.hashCode() * 31;
        ObricExpandedDialogueActionButton r1 = this.actionBtn;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<ObricExpandedDialogueActionButton> r5 = this.clarifyBtnList;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.contentText.hashCode()) * 31;
        Text r8 = this.describeText;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Text r11 = this.notify;
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

    public String toString() {
        return "ObricExpandedDialogueTemplate(title=" + this.title + ", actionBtn=" + this.actionBtn + ", clarifyBtnList=" + this.clarifyBtnList + ", contentText=" + this.contentText + ", describeText=" + this.describeText + ", notify=" + this.notify + ')';
    }

    public final ObricExpandedDialogueActionButton getActionBtn() {
        return this.actionBtn;
    }

    public final List<ObricExpandedDialogueActionButton> getClarifyBtnList() {
        return this.clarifyBtnList;
    }

    public final Text getContentText() {
        return this.contentText;
    }

    public final Text getDescribeText() {
        return this.describeText;
    }

    public final Text getNotify() {
        return this.notify;
    }

    public final ObricExpandedDialogueTitle getTitle() {
        return this.title;
    }

    public final void setActionBtn(ObricExpandedDialogueActionButton r1) {
        this.actionBtn = r1;
    }

    public final void setClarifyBtnList(List<ObricExpandedDialogueActionButton> r1) {
        this.clarifyBtnList = r1;
    }

    public final void setContentText(Text r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.contentText = r2;
    }

    public final void setDescribeText(Text r1) {
        this.describeText = r1;
    }

    public final void setNotify(Text r1) {
        this.notify = r1;
    }

    public final void setTitle(ObricExpandedDialogueTitle r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    public ObricExpandedDialogueTemplate(ObricExpandedDialogueTitle r2, ObricExpandedDialogueActionButton r3, List<ObricExpandedDialogueActionButton> r4, Text r5, Text r6, Text r7) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r5, "contentText");
        this.title = r2;
        this.actionBtn = r3;
        this.clarifyBtnList = r4;
        this.contentText = r5;
        this.describeText = r6;
        this.notify = r7;
    }

    public /* synthetic */ ObricExpandedDialogueTemplate(ObricExpandedDialogueTitle r10, ObricExpandedDialogueActionButton r11, List r12, Text r13, Text r14, Text r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 16) == 0) goto L5;
        Text r7 = null;
    L7:
        if ((r16 & 32) == 0) goto L9;
        Text r8 = null;
    L10:
        this(r10, r11, r12, r13, r7, r8);
        return;
    L9:
        r8 = r15;
        goto L10
    L5:
        r7 = r14;
        goto L7
    }
}
