package com.obric.memorydata.personalcontext.search;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/VideoScoreEntity;", "", "entityId", "", "frameList", "Ljava/util/ArrayList;", "Lcom/obric/memorydata/personalcontext/search/FrameScoreEntity;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getFrameList", "()Ljava/util/ArrayList;", "setFrameList", "(Ljava/util/ArrayList;)V", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VideoScoreEntity {
    private String entityId;
    private ArrayList<FrameScoreEntity> frameList;

    public VideoScoreEntity(String r2, ArrayList<FrameScoreEntity> r3) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        Intrinsics.checkNotNullParameter(r3, "frameList");
        this.entityId = r2;
        this.frameList = r3;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final ArrayList<FrameScoreEntity> getFrameList() {
        return this.frameList;
    }

    public final void setEntityId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entityId = r2;
    }

    public final void setFrameList(ArrayList<FrameScoreEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.frameList = r2;
    }
}
