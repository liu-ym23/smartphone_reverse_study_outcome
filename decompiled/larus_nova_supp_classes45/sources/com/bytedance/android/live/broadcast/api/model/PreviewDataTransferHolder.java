package com.bytedance.android.live.broadcast.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/PreviewDataTransferHolder;", "Ljava/io/Serializable;", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "previewSourceParam", "Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "getPreviewSourceParam", "()Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;", "setPreviewSourceParam", "(Lcom/bytedance/android/live/broadcast/api/model/PreviewSourceParam;)V", "Lcom/bytedance/android/live/broadcast/api/model/z0;", "previewParameters", "Lcom/bytedance/android/live/broadcast/api/model/z0;", "getPreviewParameters", "()Lcom/bytedance/android/live/broadcast/api/model/z0;", "setPreviewParameters", "(Lcom/bytedance/android/live/broadcast/api/model/z0;)V", "", "", "paidLiveCreateRights", "Ljava/util/List;", "getPaidLiveCreateRights", "()Ljava/util/List;", "setPaidLiveCreateRights", "(Ljava/util/List;)V", "", "replayRight", "Z", "getReplayRight", "()Z", "setReplayRight", "(Z)V", "", "ownerIdOfSellTicket", "J", "getOwnerIdOfSellTicket", "()J", "setOwnerIdOfSellTicket", "(J)V", "<init>", "()V", "Companion", "a", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewDataTransferHolder implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;
    private long ownerIdOfSellTicket;
    private List<Integer> paidLiveCreateRights;
    private z0 previewParameters;
    private PreviewSourceParam previewSourceParam;
    private boolean replayRight;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PreviewDataTransferHolder() {
        this.previewParameters = new z0();
        this.paidLiveCreateRights = new ArrayList();
        this.ownerIdOfSellTicket = -1;
    }

    public final long getOwnerIdOfSellTicket() {
        return this.ownerIdOfSellTicket;
    }

    public final List<Integer> getPaidLiveCreateRights() {
        return this.paidLiveCreateRights;
    }

    public final z0 getPreviewParameters() {
        return this.previewParameters;
    }

    public final PreviewSourceParam getPreviewSourceParam() {
        return this.previewSourceParam;
    }

    public final boolean getReplayRight() {
        return this.replayRight;
    }

    public final void setOwnerIdOfSellTicket(long r1) {
        this.ownerIdOfSellTicket = r1;
    }

    public final void setPaidLiveCreateRights(List<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.paidLiveCreateRights = r2;
    }

    public final void setPreviewParameters(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.previewParameters = r2;
    }

    public final void setPreviewSourceParam(PreviewSourceParam r1) {
        this.previewSourceParam = r1;
    }

    public final void setReplayRight(boolean r1) {
        this.replayRight = r1;
    }
}
