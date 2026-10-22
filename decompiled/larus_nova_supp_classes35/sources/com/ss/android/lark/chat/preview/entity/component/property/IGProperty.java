package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/IGProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", IPortraitService.TYPE, "Lcom/ss/android/lark/export/entity/preview/Type;", "maskColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/Type;Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/Type;", "getMaskColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "setMaskColor", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "Lcom/ss/android/lark/tangram/base/props/Props;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IGProperty extends BaseProperty {
    private ThemeColor maskColor;
    private final Type type;

    public Props clone() {
        return new IGProperty(getType(), this.maskColor);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = ((super.hashCode() * 31) + getType().hashCode()) * 31;
        ThemeColor r1 = this.maskColor;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final ThemeColor getMaskColor() {
        return this.maskColor;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public Type getType() {
        return this.type;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IGProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L11;
        return false;
    L11:
        IGProperty r6 = (IGProperty) r5;
        if (getType() == r6.getType()) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maskColor, r6.maskColor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r5 = r4.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L14;
        Map.Entry<Integer, PreviewData> r0 = r5.next();
        if (r0.getKey().intValue() != ComponentAttribute.theme_color.getValue()) goto L6;
        PreviewData r1 = r0.getValue();
        if (r1 == null) goto L12;
        ThemeColor r2 = r1.getThemeColor();
    L13:
        this.maskColor = r2;
        goto L6
    L12:
        r2 = null;
        goto L13
    }

    public final void setMaskColor(ThemeColor r1) {
        this.maskColor = r1;
    }

    public IGProperty(Type r2, ThemeColor r3) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        super(r2);
        this.type = r2;
        this.maskColor = r3;
    }

    public /* synthetic */ IGProperty(Type r1, ThemeColor r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
