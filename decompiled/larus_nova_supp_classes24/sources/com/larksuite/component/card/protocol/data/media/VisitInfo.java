package com.larksuite.component.card.protocol.data.media;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\f\u0012\"\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R6\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R6\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#¨\u0006&"}, d2 = {"Lcom/larksuite/component/card/protocol/data/media/VisitInfo;", "Ljava/io/Serializable;", "sceneType", "", "entityType", "entityId", "", "innerMsgId", "", "authFileKey", "imExt", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "ext", "<init>", "(IILjava/lang/String;JLjava/lang/String;Ljava/util/HashMap;Ljava/util/HashMap;)V", "getSceneType", "()I", "setSceneType", "(I)V", "getEntityType", "setEntityType", "getEntityId", "()Ljava/lang/String;", "setEntityId", "(Ljava/lang/String;)V", "getInnerMsgId", "()J", "setInnerMsgId", "(J)V", "getAuthFileKey", "setAuthFileKey", "getImExt", "()Ljava/util/HashMap;", "setImExt", "(Ljava/util/HashMap;)V", "getExt", "setExt", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VisitInfo implements Serializable {
    private String authFileKey;
    private String entityId;
    private int entityType;
    private HashMap<String, String> ext;
    private HashMap<String, String> imExt;
    private long innerMsgId;
    private int sceneType;

    public final String getAuthFileKey() {
        return this.authFileKey;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final int getEntityType() {
        return this.entityType;
    }

    public final HashMap<String, String> getExt() {
        return this.ext;
    }

    public final HashMap<String, String> getImExt() {
        return this.imExt;
    }

    public final long getInnerMsgId() {
        return this.innerMsgId;
    }

    public final int getSceneType() {
        return this.sceneType;
    }

    public final void setAuthFileKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.authFileKey = r2;
    }

    public final void setEntityId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.entityId = r2;
    }

    public final void setEntityType(int r1) {
        this.entityType = r1;
    }

    public final void setExt(HashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ext = r2;
    }

    public final void setImExt(HashMap<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.imExt = r2;
    }

    public final void setInnerMsgId(long r1) {
        this.innerMsgId = r1;
    }

    public final void setSceneType(int r1) {
        this.sceneType = r1;
    }

    public VisitInfo(int r2, int r3, String r4, long r5, String r7, HashMap<String, String> r8, HashMap<String, String> r9) {
        Intrinsics.checkNotNullParameter(r4, "entityId");
        Intrinsics.checkNotNullParameter(r7, "authFileKey");
        Intrinsics.checkNotNullParameter(r8, "imExt");
        Intrinsics.checkNotNullParameter(r9, "ext");
        this.sceneType = r2;
        this.entityType = r3;
        this.entityId = r4;
        this.innerMsgId = r5;
        this.authFileKey = r7;
        this.imExt = r8;
        this.ext = r9;
    }
}
