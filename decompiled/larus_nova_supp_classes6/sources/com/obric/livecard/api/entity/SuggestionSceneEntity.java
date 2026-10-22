package com.obric.livecard.api.entity;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/livecard/api/entity/SuggestionSceneEntity;", "Lcom/obric/livecard/api/entity/ISceneEntity;", "sceneType", "Lcom/obric/livecard/api/entity/SceneType;", "runtimeState", "Lcom/obric/livecard/api/entity/RuntimeState;", "content", "", "sceneDesc", "(Lcom/obric/livecard/api/entity/SceneType;Lcom/obric/livecard/api/entity/RuntimeState;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getRuntimeState", "()Lcom/obric/livecard/api/entity/RuntimeState;", "setRuntimeState", "(Lcom/obric/livecard/api/entity/RuntimeState;)V", "getSceneDesc", "setSceneDesc", "getSceneType", "()Lcom/obric/livecard/api/entity/SceneType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SuggestionSceneEntity implements ISceneEntity {
    private String content;
    private RuntimeState runtimeState;
    private String sceneDesc;
    private final SceneType sceneType;

    public static /* synthetic */ SuggestionSceneEntity copy$default(SuggestionSceneEntity r0, SceneType r1, RuntimeState r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.getSceneType();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.getRuntimeState();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.content;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.getSceneDesc();
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final SceneType component1() {
        return getSceneType();
    }

    public final RuntimeState component2() {
        return getRuntimeState();
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return getSceneDesc();
    }

    public final SuggestionSceneEntity copy(SceneType r2, RuntimeState r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        Intrinsics.checkNotNullParameter(r4, "content");
        return new SuggestionSceneEntity(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SuggestionSceneEntity) == true) goto L8;
        return false;
    L8:
        SuggestionSceneEntity r6 = (SuggestionSceneEntity) r5;
        if (getSceneType() == r6.getSceneType()) goto L12;
        return false;
    L12:
        if (getRuntimeState() == r6.getRuntimeState()) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getSceneDesc(), r6.getSceneDesc()) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = getSceneType().hashCode() * 31;
        int r2 = 0;
        if (getRuntimeState() != null) goto L5;
        int r1 = 0;
    L6:
        int r3 = (((r0 + r1) * 31) + this.content.hashCode()) * 31;
        if (getSceneDesc() == null) goto L11;
        r2 = getSceneDesc().hashCode();
    L11:
        return r3 + r2;
    L5:
        r1 = getRuntimeState().hashCode();
        goto L6
    }

    public String toString() {
        return "SuggestionSceneEntity(sceneType=" + getSceneType() + ", runtimeState=" + getRuntimeState() + ", content=" + this.content + ", sceneDesc=" + getSceneDesc() + ')';
    }

    public final String getContent() {
        return this.content;
    }

    @Override // com.obric.livecard.api.entity.ISceneEntity
    public RuntimeState getRuntimeState() {
        return this.runtimeState;
    }

    @Override // com.obric.livecard.api.entity.ISceneEntity
    public String getSceneDesc() {
        return this.sceneDesc;
    }

    @Override // com.obric.livecard.api.entity.ISceneEntity
    public SceneType getSceneType() {
        return this.sceneType;
    }

    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public void setRuntimeState(RuntimeState r1) {
        this.runtimeState = r1;
    }

    @Override // com.obric.livecard.api.entity.ISceneEntity
    public void setSceneDesc(String r1) {
        this.sceneDesc = r1;
    }

    public SuggestionSceneEntity(SceneType r2, RuntimeState r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        Intrinsics.checkNotNullParameter(r4, "content");
        this.sceneType = r2;
        this.runtimeState = r3;
        this.content = r4;
        this.sceneDesc = r5;
    }

    public /* synthetic */ SuggestionSceneEntity(SceneType r1, RuntimeState r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = SceneType.AI_SUGGESTION;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = RuntimeState.PROCESSING;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = null;
    L11:
        this(r1, r2, r3, r4);
    }
}
