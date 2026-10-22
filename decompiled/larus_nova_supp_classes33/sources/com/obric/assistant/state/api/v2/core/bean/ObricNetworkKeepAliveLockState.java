package com.obric.assistant.state.api.v2.core.bean;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/state/api/v2/core/bean/ObricNetworkKeepAliveLockState;", "", "currentState", "Lcom/obric/assistant/state/api/v2/core/bean/ObricNetworkKeepAliveLockStateType;", "conversationId", "", "ext", "", "<init>", "(Lcom/obric/assistant/state/api/v2/core/bean/ObricNetworkKeepAliveLockStateType;Ljava/lang/String;Ljava/util/Map;)V", "getCurrentState", "()Lcom/obric/assistant/state/api/v2/core/bean/ObricNetworkKeepAliveLockStateType;", "getConversationId", "()Ljava/lang/String;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricNetworkKeepAliveLockState {
    private final String conversationId;
    private final ObricNetworkKeepAliveLockStateType currentState;
    private final Map<String, Object> ext;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricNetworkKeepAliveLockState copy$default(ObricNetworkKeepAliveLockState r0, ObricNetworkKeepAliveLockStateType r1, String r2, Map r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.currentState;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.conversationId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.ext;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final ObricNetworkKeepAliveLockStateType component1() {
        return this.currentState;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final Map<String, Object> component3() {
        return this.ext;
    }

    public final ObricNetworkKeepAliveLockState copy(ObricNetworkKeepAliveLockStateType r2, String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "ext");
        return new ObricNetworkKeepAliveLockState(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricNetworkKeepAliveLockState) == true) goto L8;
        return false;
    L8:
        ObricNetworkKeepAliveLockState r6 = (ObricNetworkKeepAliveLockState) r5;
        if (this.currentState == r6.currentState) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.currentState.hashCode() * 31) + this.conversationId.hashCode()) * 31) + this.ext.hashCode();
    }

    public String toString() {
        return "ObricNetworkKeepAliveLockState(currentState=" + this.currentState + ", conversationId=" + this.conversationId + ", ext=" + this.ext + ')';
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final ObricNetworkKeepAliveLockStateType getCurrentState() {
        return this.currentState;
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public ObricNetworkKeepAliveLockState(ObricNetworkKeepAliveLockStateType r2, String r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "ext");
        this.currentState = r2;
        this.conversationId = r3;
        this.ext = r4;
    }

    public /* synthetic */ ObricNetworkKeepAliveLockState(ObricNetworkKeepAliveLockStateType r1, String r2, Map r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = MapsKt.emptyMap();
    L5:
        this(r1, r2, r3);
    }
}
