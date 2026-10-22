package com.obric.livecard.api.entity;

import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003JG\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\nHÖ\u0001J\t\u0010)\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/obric/livecard/api/entity/TaskSceneEntity;", "Lcom/obric/livecard/api/entity/ISceneEntity;", "sceneType", "Lcom/obric/livecard/api/entity/SceneType;", "runtimeState", "Lcom/obric/livecard/api/entity/RuntimeState;", Params.CONTENT, "", "iconUrl", "priority", "", "sceneDesc", "(Lcom/obric/livecard/api/entity/SceneType;Lcom/obric/livecard/api/entity/RuntimeState;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getPriority", "()I", "getRuntimeState", "()Lcom/obric/livecard/api/entity/RuntimeState;", "setRuntimeState", "(Lcom/obric/livecard/api/entity/RuntimeState;)V", "getSceneDesc", "setSceneDesc", "getSceneType", "()Lcom/obric/livecard/api/entity/SceneType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TaskSceneEntity implements ISceneEntity {
    private String content;
    private String iconUrl;
    private final int priority;
    private RuntimeState runtimeState;
    private String sceneDesc;
    private final SceneType sceneType;

    public TaskSceneEntity(SceneType r2, RuntimeState r3, String r4, String r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        Intrinsics.checkNotNullParameter(r3, "runtimeState");
        Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r5, "iconUrl");
        this.sceneType = r2;
        this.runtimeState = r3;
        this.content = r4;
        this.iconUrl = r5;
        this.priority = r6;
        this.sceneDesc = r7;
    }

    public /* synthetic */ TaskSceneEntity(SceneType r8, RuntimeState r9, String r10, String r11, int r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = SceneType.AI_TASK;
    L5:
        SceneType r1 = r8;
        if ((r14 & 16) == 0) goto L8;
        r12 = Integer.MAX_VALUE;
    L8:
        int r5 = r12;
        if ((r14 & 32) == 0) goto L11;
        r13 = null;
    L11:
        this(r1, r9, r10, r11, r5, r13);
    }

    public static /* synthetic */ TaskSceneEntity copy$default(TaskSceneEntity r4, SceneType r5, RuntimeState r6, String r7, String r8, int r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.getSceneType();
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.getRuntimeState();
    L8:
        RuntimeState r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.content;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.iconUrl;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.priority;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.getSceneDesc();
    L20:
        SceneType r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
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
        return this.iconUrl;
    }

    public final int component5() {
        return this.priority;
    }

    public final String component6() {
        return getSceneDesc();
    }

    public final TaskSceneEntity copy(SceneType r8, RuntimeState r9, String r10, String r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r8, "sceneType");
        Intrinsics.checkNotNullParameter(r9, "runtimeState");
        Intrinsics.checkNotNullParameter(r10, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r11, "iconUrl");
        return new TaskSceneEntity(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TaskSceneEntity.class) == true) goto L8;
        return false;
    L8:
        TaskSceneEntity r6 = (TaskSceneEntity) ZeusTransformUtils.preCheckCast(r5, TaskSceneEntity.class, "com.obric.memorydata.plugin");
        if (getSceneType() == r6.getSceneType()) goto L12;
        return false;
    L12:
        if (getRuntimeState() == r6.getRuntimeState()) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.iconUrl, r6.iconUrl) == true) goto L21;
        return false;
    L21:
        if (this.priority == r6.priority) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(getSceneDesc(), r6.getSceneDesc()) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getPriority() {
        return this.priority;
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

    public int hashCode() {
        int r0 = ((((((((getSceneType().hashCode() * 31) + getRuntimeState().hashCode()) * 31) + this.content.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + Integer.hashCode(this.priority)) * 31;
        if (getSceneDesc() != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = getSceneDesc().hashCode();
        goto L7
    }

    public final void setContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.content = r2;
    }

    public final void setIconUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.iconUrl = r2;
    }

    public void setRuntimeState(RuntimeState r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.runtimeState = r2;
    }

    @Override // com.obric.livecard.api.entity.ISceneEntity
    public void setSceneDesc(String r1) {
        this.sceneDesc = r1;
    }

    public String toString() {
        return "TaskSceneEntity(sceneType=" + getSceneType() + ", runtimeState=" + getRuntimeState() + ", content=" + this.content + ", iconUrl=" + this.iconUrl + ", priority=" + this.priority + ", sceneDesc=" + getSceneDesc() + ')';
    }
}
