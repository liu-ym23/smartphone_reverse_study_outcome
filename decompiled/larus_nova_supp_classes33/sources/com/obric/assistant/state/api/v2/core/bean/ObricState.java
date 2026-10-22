package com.obric.assistant.state.api.v2.core.bean;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0015\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eHÆ\u0003Jf\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Lcom/obric/assistant/state/api/v2/core/bean/ObricState;", "", "currentIslandState", "Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandStateType;", "conversationId", "", "scene", "Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;", "priority", "Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandPriority;", "sourceMessageId", "taskCreatedTime", "", "ext", "", "<init>", "(Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandStateType;Ljava/lang/String;Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandPriority;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)V", "getCurrentIslandState", "()Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandStateType;", "getConversationId", "()Ljava/lang/String;", "getScene", "()Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;", "getPriority", "()Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandPriority;", "getSourceMessageId", "getTaskCreatedTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandStateType;Ljava/lang/String;Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;Lcom/obric/assistant/state/api/v2/core/bean/ObricIslandPriority;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;)Lcom/obric/assistant/state/api/v2/core/bean/ObricState;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricState {
    private final String conversationId;
    private final ObricIslandStateType currentIslandState;
    private final Map<String, Object> ext;
    private final ObricIslandPriority priority;
    private final ObricInteractionScene scene;
    private final String sourceMessageId;
    private final Long taskCreatedTime;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricState copy$default(ObricState r5, ObricIslandStateType r6, String r7, ObricInteractionScene r8, ObricIslandPriority r9, String r10, Long r11, Map r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.currentIslandState;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.conversationId;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.scene;
    L11:
        ObricInteractionScene r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.priority;
    L14:
        ObricIslandPriority r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.sourceMessageId;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.taskCreatedTime;
    L20:
        Long r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.ext;
    L23:
        ObricIslandStateType r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final ObricIslandStateType component1() {
        return this.currentIslandState;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final ObricInteractionScene component3() {
        return this.scene;
    }

    public final ObricIslandPriority component4() {
        return this.priority;
    }

    public final String component5() {
        return this.sourceMessageId;
    }

    public final Long component6() {
        return this.taskCreatedTime;
    }

    public final Map<String, Object> component7() {
        return this.ext;
    }

    public final ObricState copy(ObricIslandStateType r10, String r11, ObricInteractionScene r12, ObricIslandPriority r13, String r14, Long r15, Map<String, ? extends Object> r16) {
        Intrinsics.checkNotNullParameter(r10, "currentIslandState");
        Intrinsics.checkNotNullParameter(r11, "conversationId");
        Intrinsics.checkNotNullParameter(r13, "priority");
        Intrinsics.checkNotNullParameter(r16, "ext");
        return new ObricState(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricState) == true) goto L8;
        return false;
    L8:
        ObricState r6 = (ObricState) r5;
        if (this.currentIslandState == r6.currentIslandState) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L15;
        return false;
    L15:
        if (this.scene == r6.scene) goto L18;
        return false;
    L18:
        if (this.priority == r6.priority) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sourceMessageId, r6.sourceMessageId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.taskCreatedTime, r6.taskCreatedTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.currentIslandState.hashCode() * 31) + this.conversationId.hashCode()) * 31;
        ObricInteractionScene r1 = this.scene;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.priority.hashCode()) * 31;
        String r5 = this.sourceMessageId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.taskCreatedTime;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + this.ext.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricState(currentIslandState=" + this.currentIslandState + ", conversationId=" + this.conversationId + ", scene=" + this.scene + ", priority=" + this.priority + ", sourceMessageId=" + this.sourceMessageId + ", taskCreatedTime=" + this.taskCreatedTime + ", ext=" + this.ext + ')';
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final ObricIslandStateType getCurrentIslandState() {
        return this.currentIslandState;
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public final ObricIslandPriority getPriority() {
        return this.priority;
    }

    public final ObricInteractionScene getScene() {
        return this.scene;
    }

    public final String getSourceMessageId() {
        return this.sourceMessageId;
    }

    public final Long getTaskCreatedTime() {
        return this.taskCreatedTime;
    }

    public ObricState(ObricIslandStateType r2, String r3, ObricInteractionScene r4, ObricIslandPriority r5, String r6, Long r7, Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r2, "currentIslandState");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "priority");
        Intrinsics.checkNotNullParameter(r8, "ext");
        this.currentIslandState = r2;
        this.conversationId = r3;
        this.scene = r4;
        this.priority = r5;
        this.sourceMessageId = r6;
        this.taskCreatedTime = r7;
        this.ext = r8;
    }

    public /* synthetic */ ObricState(ObricIslandStateType r10, String r11, ObricInteractionScene r12, ObricIslandPriority r13, String r14, Long r15, Map r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 4) == 0) goto L5;
        ObricInteractionScene r4 = ObricInteractionScene.DEFAULT;
    L7:
        if ((r17 & 8) == 0) goto L9;
        ObricIslandPriority r5 = ObricIslandPriority.LOW;
    L11:
        if ((r17 & 16) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r17 & 32) == 0) goto L17;
        Long r7 = null;
    L19:
        if ((r17 & 64) == 0) goto L21;
        Map r8 = MapsKt.emptyMap();
    L22:
        this(r10, r11, r4, r5, r6, r7, r8);
        return;
    L21:
        r8 = r16;
        goto L22
    L17:
        r7 = r15;
        goto L19
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }
}
