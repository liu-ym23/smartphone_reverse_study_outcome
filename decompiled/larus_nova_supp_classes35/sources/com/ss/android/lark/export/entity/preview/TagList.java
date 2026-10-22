package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/TagList;", "Ljava/io/Serializable;", "mixedTags", BuildConfig.FLAVOR, "Lcom/ss/android/lark/export/entity/preview/KeyTag;", "<init>", "(Ljava/util/List;)V", "getMixedTags", "()Ljava/util/List;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagList implements Serializable {
    private final List<KeyTag> mixedTags;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagList copy$default(TagList r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.mixedTags;
    L6:
        return r0.copy(r1);
    }

    public final List<KeyTag> component1() {
        return this.mixedTags;
    }

    public final TagList copy(List<KeyTag> r2) {
        return new TagList(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof TagList) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.mixedTags, ((TagList) r4).mixedTags) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<KeyTag> r0 = this.mixedTags;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "TagList(mixedTags=" + this.mixedTags + ')';
    }

    public final List<KeyTag> getMixedTags() {
        return this.mixedTags;
    }

    public TagList(List<KeyTag> r1) {
        this.mixedTags = r1;
    }
}
