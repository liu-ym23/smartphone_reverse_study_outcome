package com.obric.livecard.api.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/obric/livecard/api/entity/NotificationSceneEntity;", "Lcom/obric/livecard/api/entity/ISceneEntity;", "sceneType", "Lcom/obric/livecard/api/entity/SceneType;", "runtimeState", "Lcom/obric/livecard/api/entity/RuntimeState;", "sceneDesc", "", "(Lcom/obric/livecard/api/entity/SceneType;Lcom/obric/livecard/api/entity/RuntimeState;Ljava/lang/String;)V", "getRuntimeState", "()Lcom/obric/livecard/api/entity/RuntimeState;", "setRuntimeState", "(Lcom/obric/livecard/api/entity/RuntimeState;)V", "getSceneDesc", "()Ljava/lang/String;", "setSceneDesc", "(Ljava/lang/String;)V", "getSceneType", "()Lcom/obric/livecard/api/entity/SceneType;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NotificationSceneEntity implements ISceneEntity {
    private RuntimeState runtimeState;
    private String sceneDesc;
    private final SceneType sceneType;

    public NotificationSceneEntity() {
        this(null, null, null, 7, null);
    }

    public NotificationSceneEntity(SceneType r2, RuntimeState r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "sceneType");
        this.sceneType = r2;
        this.runtimeState = r3;
        this.sceneDesc = r4;
    }

    public /* synthetic */ NotificationSceneEntity(SceneType r1, RuntimeState r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = SceneType.NOTIFICATION;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = RuntimeState.PROCESSING;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }

    public static /* synthetic */ NotificationSceneEntity copy$default(NotificationSceneEntity r0, SceneType r1, RuntimeState r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getSceneType();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getRuntimeState();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.getSceneDesc();
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final SceneType component1() {
        return getSceneType();
    }

    public final RuntimeState component2() {
        return getRuntimeState();
    }

    public final String component3() {
        return getSceneDesc();
    }

    public final NotificationSceneEntity copy(SceneType r1, RuntimeState r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "sceneType");
        return new NotificationSceneEntity(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NotificationSceneEntity.class) == true) goto L8;
        return false;
    L8:
        NotificationSceneEntity r6 = (NotificationSceneEntity) ZeusTransformUtils.preCheckCast(r5, NotificationSceneEntity.class, "com.obric.memorydata.plugin");
        if (getSceneType() == r6.getSceneType()) goto L12;
        return false;
    L12:
        if (getRuntimeState() == r6.getRuntimeState()) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(getSceneDesc(), r6.getSceneDesc()) == true) goto L17;
        return false;
    L17:
        return true;
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
        int r0 = getSceneType().hashCode() * 31;
        int r2 = 0;
        if (getRuntimeState() != null) goto L5;
        int r1 = 0;
    L6:
        int r3 = (r0 + r1) * 31;
        if (getSceneDesc() == null) goto L11;
        r2 = getSceneDesc().hashCode();
    L11:
        return r3 + r2;
    L5:
        r1 = getRuntimeState().hashCode();
        goto L6
    }

    public void setRuntimeState(RuntimeState r1) {
        this.runtimeState = r1;
    }

    @Override // com.obric.livecard.api.entity.ISceneEntity
    public void setSceneDesc(String r1) {
        this.sceneDesc = r1;
    }

    public String toString() {
        return "NotificationSceneEntity(sceneType=" + getSceneType() + ", runtimeState=" + getRuntimeState() + ", sceneDesc=" + getSceneDesc() + ')';
    }
}
