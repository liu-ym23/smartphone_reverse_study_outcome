package com.ss.android.lark.export.entity.preview;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001b\u001a\u00020\u0000J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u000b\u0010\u0013R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewComponent;", "Ljava/io/Serializable;", IPortraitService.TYPE, "Lcom/ss/android/lark/export/entity/preview/Type;", "canSkipWhenUnknown", BuildConfig.FLAVOR, "style", "Lcom/ss/android/lark/export/entity/preview/Style;", "childIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isFontZoomable", "property", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/Type;Ljava/lang/Boolean;Lcom/ss/android/lark/export/entity/preview/Style;Ljava/util/List;Ljava/lang/Boolean;Lcom/ss/android/lark/export/entity/preview/BaseProperty;)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/Type;", "getCanSkipWhenUnknown", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStyle", "()Lcom/ss/android/lark/export/entity/preview/Style;", "getChildIds", "()Ljava/util/List;", "getProperty", "()Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "clone", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewComponent implements Serializable {
    private final Boolean canSkipWhenUnknown;
    private final List<String> childIds;
    private final Boolean isFontZoomable;
    private final BaseProperty property;
    private final Style style;
    private final Type type;

    public final UrlPreviewComponent clone() {
        Type r1 = this.type;
        Boolean r2 = this.canSkipWhenUnknown;
        Style r0 = this.style;
        if (r0 == null) goto L5;
        Style r3 = r0.clone();
    L7:
        return new UrlPreviewComponent(r1, r2, r3, this.childIds, this.isFontZoomable, this.property);
    L5:
        r3 = null;
        goto L7
    }

    public int hashCode() {
        int r0 = this.type.hashCode() * 31;
        Boolean r1 = this.canSkipWhenUnknown;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Style r5 = this.style;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        List<String> r8 = this.childIds;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.isFontZoomable;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return ((r10 + r2) * 31) + this.property.hashCode();
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final Boolean getCanSkipWhenUnknown() {
        return this.canSkipWhenUnknown;
    }

    public final List<String> getChildIds() {
        return this.childIds;
    }

    public final BaseProperty getProperty() {
        return this.property;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final Type getType() {
        return this.type;
    }

    public final Boolean isFontZoomable() {
        return this.isFontZoomable;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(UrlPreviewComponent.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.UrlPreviewComponent");
        UrlPreviewComponent r6 = (UrlPreviewComponent) r5;
        if (this.type == r6.type) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.canSkipWhenUnknown, r6.canSkipWhenUnknown) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.style, r6.style) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.childIds, r6.childIds) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.isFontZoomable, r6.isFontZoomable) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.property, r6.property) == true) goto L30;
        return false;
    L30:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public UrlPreviewComponent(Type r2, Boolean r3, Style r4, List<String> r5, Boolean r6, BaseProperty r7) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r7, "property");
        this.type = r2;
        this.canSkipWhenUnknown = r3;
        this.style = r4;
        this.childIds = r5;
        this.isFontZoomable = r6;
        this.property = r7;
    }

    public /* synthetic */ UrlPreviewComponent(Type r8, Boolean r9, Style r10, List r11, Boolean r12, BaseProperty r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = Boolean.TRUE;
    L5:
        Boolean r2 = r9;
        if ((r14 & 16) == 0) goto L8;
        r12 = Boolean.TRUE;
    L8:
        this(r8, r2, r10, r11, r12, r13);
    }
}
