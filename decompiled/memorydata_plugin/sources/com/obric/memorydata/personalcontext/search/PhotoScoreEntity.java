package com.obric.memorydata.personalcontext.search;

import com.bytedance.bdinstall.oaid.OaidModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\b\u0017\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/obric/memorydata/personalcontext/search/PhotoScoreEntity;", "", OaidModel.KEY_ID, "", "entityId", "", "copilotId", "copilotColumn", "vectorList", "", "score", "", "<init>", "(JLjava/lang/String;JLjava/lang/String;[FF)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getCopilotId", "setCopilotId", "getCopilotColumn", "setCopilotColumn", "getVectorList", "()[F", "setVectorList", "([F)V", "getScore", "()F", "setScore", "(F)V", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class PhotoScoreEntity {
    private String copilotColumn;
    private long copilotId;
    private String entityId;
    private long id;
    private float score;
    private float[] vectorList;

    public PhotoScoreEntity() {
        this(0, null, 0, null, null, 0.0f, 63, null);
    }

    public PhotoScoreEntity(long r2, String r4, long r5, String r7, float[] r8, float r9) {
        Intrinsics.checkNotNullParameter(r4, "entityId");
        Intrinsics.checkNotNullParameter(r7, "copilotColumn");
        this.id = r2;
        this.entityId = r4;
        this.copilotId = r5;
        this.copilotColumn = r7;
        this.vectorList = r8;
        this.score = r9;
    }

    public /* synthetic */ PhotoScoreEntity(long r3, String r5, long r6, String r8, float[] r9, float r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r5 = "";
    L9:
        if ((r11 & 4) == 0) goto L12;
        r6 = -1;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r8 = "file";
    L15:
        if ((r11 & 16) == 0) goto L18;
        r9 = null;
    L18:
        if ((r11 & 32) == 0) goto L20;
        r10 = 0.0f;
    L20:
        this(r3, r5, r6, r8, r9, r10);
    }

    public final String getCopilotColumn() {
        return this.copilotColumn;
    }

    public final long getCopilotId() {
        return this.copilotId;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final long getId() {
        return this.id;
    }

    public final float getScore() {
        return this.score;
    }

    public final float[] getVectorList() {
        return this.vectorList;
    }

    public final void setCopilotColumn(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.copilotColumn = r2;
    }

    public final void setCopilotId(long r1) {
        this.copilotId = r1;
    }

    public final void setEntityId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entityId = r2;
    }

    public final void setId(long r1) {
        this.id = r1;
    }

    public final void setScore(float r1) {
        this.score = r1;
    }

    public final void setVectorList(float[] r1) {
        this.vectorList = r1;
    }
}
