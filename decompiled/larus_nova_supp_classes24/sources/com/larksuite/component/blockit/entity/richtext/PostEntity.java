package com.larksuite.component.blockit.entity.richtext;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/blockit/entity/richtext/PostEntity;", "Ljava/io/Serializable;", "title", "", "content", "Lcom/ss/android/lark/widget/richtext/RichText;", "docEntity", "", "Lcom/ss/android/lark/doc/entity/Doc;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Ljava/util/Map;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getContent", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getDocEntity", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PostEntity implements Serializable {
    private final RichText content;
    private final Map<String, Doc> docEntity;
    private String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostEntity copy$default(PostEntity r0, String r1, RichText r2, Map r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.title;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.docEntity;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.title;
    }

    public final RichText component2() {
        return this.content;
    }

    public final Map<String, Doc> component3() {
        return this.docEntity;
    }

    public final PostEntity copy(String r2, RichText r3, Map<String, ? extends Doc> r4) {
        return new PostEntity(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PostEntity) == true) goto L8;
        return false;
    L8:
        PostEntity r6 = (PostEntity) r5;
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.docEntity, r6.docEntity) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        RichText r4 = this.content;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, Doc> r7 = this.docEntity;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PostEntity(title=" + this.title + ", content=" + this.content + ", docEntity=" + this.docEntity + ')';
    }

    public final RichText getContent() {
        return this.content;
    }

    public final Map<String, Doc> getDocEntity() {
        return this.docEntity;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public PostEntity(String r1, RichText r2, Map<String, ? extends Doc> r3) {
        this.title = r1;
        this.content = r2;
        this.docEntity = r3;
    }
}
