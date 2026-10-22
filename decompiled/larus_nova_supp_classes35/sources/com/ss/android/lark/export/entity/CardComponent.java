package com.ss.android.lark.export.entity;

import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/ss/android/lark/export/entity/CardComponent;", "Ljava/io/Serializable;", IPortraitService.TYPE, "Lcom/ss/android/lark/export/entity/Type;", "childIds", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "style", "Lcom/ss/android/lark/tangram/base/style/TCStyle;", "property", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "<init>", "(Lcom/ss/android/lark/export/entity/Type;Ljava/util/ArrayList;Lcom/ss/android/lark/tangram/base/style/TCStyle;Lcom/ss/android/lark/export/entity/preview/BaseProperty;)V", "getType", "()Lcom/ss/android/lark/export/entity/Type;", "getChildIds", "()Ljava/util/ArrayList;", "getStyle", "()Lcom/ss/android/lark/tangram/base/style/TCStyle;", "getProperty", "()Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardComponent implements Serializable {
    private final ArrayList<String> childIds;
    private final BaseProperty property;
    private final TCStyle style;
    private final Type type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardComponent copy$default(CardComponent r0, Type r1, ArrayList r2, TCStyle r3, BaseProperty r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.childIds;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.style;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.property;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Type component1() {
        return this.type;
    }

    public final ArrayList<String> component2() {
        return this.childIds;
    }

    public final TCStyle component3() {
        return this.style;
    }

    public final BaseProperty component4() {
        return this.property;
    }

    public final CardComponent copy(Type r2, ArrayList<String> r3, TCStyle r4, BaseProperty r5) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r3, "childIds");
        return new CardComponent(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CardComponent) == true) goto L8;
        return false;
    L8:
        CardComponent r6 = (CardComponent) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.childIds, r6.childIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.style, r6.style) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.property, r6.property) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.type.hashCode() * 31) + this.childIds.hashCode()) * 31;
        TCStyle r1 = this.style;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        BaseProperty r5 = this.property;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "CardComponent(type=" + this.type + ", childIds=" + this.childIds + ", style=" + this.style + ", property=" + this.property + ')';
    }

    public final ArrayList<String> getChildIds() {
        return this.childIds;
    }

    public final BaseProperty getProperty() {
        return this.property;
    }

    public final TCStyle getStyle() {
        return this.style;
    }

    public final Type getType() {
        return this.type;
    }

    public CardComponent(Type r2, ArrayList<String> r3, TCStyle r4, BaseProperty r5) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r3, "childIds");
        this.type = r2;
        this.childIds = r3;
        this.style = r4;
        this.property = r5;
    }
}
