package com.ss.android.lark.chat.entity.message.content;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J*\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/ImageTranslateProperty;", "Ljava/io/Serializable;", "canTranslate", BuildConfig.FLAVOR, "srcLanguages", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V", "getCanTranslate", "()Ljava/lang/Boolean;", "setCanTranslate", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSrcLanguages", "()Ljava/util/List;", "setSrcLanguages", "(Ljava/util/List;)V", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/ss/android/lark/chat/entity/message/content/ImageTranslateProperty;", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageTranslateProperty implements Serializable {
    private Boolean canTranslate;
    private List<String> srcLanguages;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageTranslateProperty() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageTranslateProperty copy$default(ImageTranslateProperty r0, Boolean r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.canTranslate;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.srcLanguages;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.canTranslate;
    }

    public final List<String> component2() {
        return this.srcLanguages;
    }

    public final ImageTranslateProperty copy(Boolean r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "srcLanguages");
        return new ImageTranslateProperty(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ImageTranslateProperty) == true) goto L8;
        return false;
    L8:
        ImageTranslateProperty r6 = (ImageTranslateProperty) r5;
        if (Intrinsics.areEqual(this.canTranslate, r6.canTranslate) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.srcLanguages, r6.srcLanguages) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.canTranslate;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.srcLanguages.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ImageTranslateProperty(canTranslate=" + this.canTranslate + ", srcLanguages=" + this.srcLanguages + ')';
    }

    public final Boolean getCanTranslate() {
        return this.canTranslate;
    }

    public final List<String> getSrcLanguages() {
        return this.srcLanguages;
    }

    public final void setCanTranslate(Boolean r1) {
        this.canTranslate = r1;
    }

    public final void setSrcLanguages(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.srcLanguages = r2;
    }

    public ImageTranslateProperty(Boolean r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "srcLanguages");
        this.canTranslate = r2;
        this.srcLanguages = r3;
    }

    public /* synthetic */ ImageTranslateProperty(Boolean r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        this(r1, r2);
    }
}
