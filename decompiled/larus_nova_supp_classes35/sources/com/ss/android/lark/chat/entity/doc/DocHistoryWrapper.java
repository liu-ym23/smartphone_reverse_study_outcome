package com.ss.android.lark.chat.entity.doc;

import com.ss.android.lark.chat.entity.tag.TagData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import ibb.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/entity/doc/DocHistoryWrapper;", "Ljava/io/Serializable;", "docHistory", "Lcom/ss/android/lark/doc/entity/DocHistory;", "tagData", "Lcom/ss/android/lark/chat/entity/tag/TagData;", "<init>", "(Lcom/ss/android/lark/doc/entity/DocHistory;Lcom/ss/android/lark/chat/entity/tag/TagData;)V", "getDocHistory", "()Lcom/ss/android/lark/doc/entity/DocHistory;", "getTagData", "()Lcom/ss/android/lark/chat/entity/tag/TagData;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocHistoryWrapper implements Serializable {
    private final b docHistory;
    private final TagData tagData;

    public static /* synthetic */ DocHistoryWrapper copy$default(DocHistoryWrapper r0, b r1, TagData r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r0.getClass();
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.tagData;
    L9:
        return r0.copy(r1, r2);
    }

    public final b component1() {
        return null;
    }

    public final TagData component2() {
        return this.tagData;
    }

    public final DocHistoryWrapper copy(b r2, TagData r3) {
        Intrinsics.checkNotNullParameter(r2, "docHistory");
        return new DocHistoryWrapper(r2, r3);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof DocHistoryWrapper) == true) goto L8;
        return false;
    L8:
        DocHistoryWrapper r5 = (DocHistoryWrapper) r4;
        r5.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tagData, r5.tagData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final b getDocHistory() {
        return null;
    }

    public int hashCode() {
        throw null;
    }

    public String toString() {
        return "DocHistoryWrapper(docHistory=null, tagData=" + this.tagData + ')';
    }

    public final TagData getTagData() {
        return this.tagData;
    }

    public DocHistoryWrapper(b r2, TagData r3) {
        Intrinsics.checkNotNullParameter(r2, "docHistory");
        this.tagData = r3;
    }
}
