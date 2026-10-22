package com.larksuite.component.blockit.entity.richtext;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larksuite/component/blockit/entity/richtext/TextEntity;", "Ljava/io/Serializable;", "text", "Lcom/ss/android/lark/widget/richtext/RichText;", "docEntity", "", "", "Lcom/ss/android/lark/doc/entity/Doc;", "<init>", "(Lcom/ss/android/lark/widget/richtext/RichText;Ljava/util/Map;)V", "getText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "setText", "(Lcom/ss/android/lark/widget/richtext/RichText;)V", "getDocEntity", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TextEntity implements Serializable {
    private final Map<String, Doc> docEntity;
    private RichText text;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextEntity copy$default(TextEntity r0, RichText r1, Map r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.docEntity;
    L9:
        return r0.copy(r1, r2);
    }

    public final RichText component1() {
        return this.text;
    }

    public final Map<String, Doc> component2() {
        return this.docEntity;
    }

    public final TextEntity copy(RichText r2, Map<String, ? extends Doc> r3) {
        return new TextEntity(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextEntity) == true) goto L8;
        return false;
    L8:
        TextEntity r6 = (TextEntity) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.docEntity, r6.docEntity) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        RichText r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Map<String, Doc> r4 = this.docEntity;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "TextEntity(text=" + this.text + ", docEntity=" + this.docEntity + ')';
    }

    public final Map<String, Doc> getDocEntity() {
        return this.docEntity;
    }

    public final RichText getText() {
        return this.text;
    }

    public final void setText(RichText r1) {
        this.text = r1;
    }

    public TextEntity(RichText r1, Map<String, ? extends Doc> r2) {
        this.text = r1;
        this.docEntity = r2;
    }
}
