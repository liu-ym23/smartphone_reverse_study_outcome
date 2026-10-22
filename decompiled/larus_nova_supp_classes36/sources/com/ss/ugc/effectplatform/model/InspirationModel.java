package com.ss.ugc.effectplatform.model;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/effectplatform/model/InspirationModel;", "", "video", "Lcom/ss/ugc/effectplatform/model/VideoModel;", "author", "Lcom/ss/ugc/effectplatform/model/AuthorModel;", "(Lcom/ss/ugc/effectplatform/model/VideoModel;Lcom/ss/ugc/effectplatform/model/AuthorModel;)V", "getAuthor", "()Lcom/ss/ugc/effectplatform/model/AuthorModel;", "setAuthor", "(Lcom/ss/ugc/effectplatform/model/AuthorModel;)V", "getVideo", "()Lcom/ss/ugc/effectplatform/model/VideoModel;", "setVideo", "(Lcom/ss/ugc/effectplatform/model/VideoModel;)V", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class InspirationModel {
    private AuthorModel author;
    private VideoModel video;

    /* JADX WARN: Multi-variable type inference failed */
    public InspirationModel() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ InspirationModel copy$default(InspirationModel r0, VideoModel r1, AuthorModel r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.video;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.author;
    L9:
        return r0.copy(r1, r2);
    }

    public final VideoModel component1() {
        return this.video;
    }

    public final AuthorModel component2() {
        return this.author;
    }

    public final InspirationModel copy(VideoModel r2, AuthorModel r3) {
        return new InspirationModel(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof InspirationModel) == false) goto L10;
        InspirationModel r4 = (InspirationModel) r3;
        if (Intrinsics.areEqual(this.video, r4.video) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.author, r4.author) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        VideoModel r0 = this.video;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        AuthorModel r4 = this.author;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "InspirationModel(video=" + this.video + ", author=" + this.author + ")";
    }

    public final AuthorModel getAuthor() {
        return this.author;
    }

    public final VideoModel getVideo() {
        return this.video;
    }

    public final void setAuthor(AuthorModel r1) {
        this.author = r1;
    }

    public final void setVideo(VideoModel r1) {
        this.video = r1;
    }

    public InspirationModel(VideoModel r1, AuthorModel r2) {
        this.video = r1;
        this.author = r2;
    }

    public /* synthetic */ InspirationModel(VideoModel r2, AuthorModel r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
