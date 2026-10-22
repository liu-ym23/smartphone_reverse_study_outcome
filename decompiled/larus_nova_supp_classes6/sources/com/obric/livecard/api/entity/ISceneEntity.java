package com.obric.livecard.api.entity;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/livecard/api/entity/ISceneEntity;", "", "runtimeState", "Lcom/obric/livecard/api/entity/RuntimeState;", "getRuntimeState", "()Lcom/obric/livecard/api/entity/RuntimeState;", "sceneDesc", "", "getSceneDesc", "()Ljava/lang/String;", "setSceneDesc", "(Ljava/lang/String;)V", "sceneType", "Lcom/obric/livecard/api/entity/SceneType;", "getSceneType", "()Lcom/obric/livecard/api/entity/SceneType;", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public interface ISceneEntity {
    RuntimeState getRuntimeState();

    String getSceneDesc();

    SceneType getSceneType();

    void setSceneDesc(String r1);
}
