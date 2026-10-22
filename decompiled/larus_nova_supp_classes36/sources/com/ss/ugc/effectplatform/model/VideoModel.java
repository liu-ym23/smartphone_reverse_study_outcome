package com.ss.ugc.effectplatform.model;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/ss/ugc/effectplatform/model/VideoModel;", "", "play_addr", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "getPlay_addr", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setPlay_addr", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class VideoModel {
    private UrlModel play_addr;

    public VideoModel() {
        UrlModel r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ VideoModel copy$default(VideoModel r0, UrlModel r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.play_addr;
    L6:
        return r0.copy(r1);
    }

    public final UrlModel component1() {
        return this.play_addr;
    }

    public final VideoModel copy(UrlModel r2) {
        return new VideoModel(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof VideoModel) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.play_addr, ((VideoModel) r2).play_addr) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        UrlModel r0 = this.play_addr;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "VideoModel(play_addr=" + this.play_addr + ")";
    }

    public final UrlModel getPlay_addr() {
        return this.play_addr;
    }

    public VideoModel(UrlModel r1) {
        this.play_addr = r1;
    }

    public final void setPlay_addr(UrlModel r1) {
        this.play_addr = r1;
    }

    public /* synthetic */ VideoModel(UrlModel r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
