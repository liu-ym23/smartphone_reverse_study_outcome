package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.AvatarChatterInfo;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0000H\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/AvatarProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "chatterInfo", "Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;)V", "getChatterInfo", "()Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;", "setChatterInfo", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarProperty extends BaseProperty {
    private AvatarChatterInfo chatterInfo;

    public AvatarProperty() {
        AvatarChatterInfo r0 = null;
        this(r0, 1, r0);
    }

    public AvatarProperty clone() {
        AvatarChatterInfo r1 = this.chatterInfo;
        if (r1 == null) goto L5;
        AvatarChatterInfo r2 = r1.clone();
    L7:
        return new AvatarProperty(r2);
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        AvatarChatterInfo r1 = this.chatterInfo;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final AvatarChatterInfo getChatterInfo() {
        return this.chatterInfo;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Props m659clone() {
        return clone();
    }

    public AvatarProperty(AvatarChatterInfo r2) {
        super(Type.AVATAR);
        this.chatterInfo = r2;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof AvatarProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r4) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterInfo, ((AvatarProperty) r4).chatterInfo) == true) goto L14;
        return false;
    L14:
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
        if (r0.getKey().intValue() != ComponentAttribute.avatar_chatter_info.getValue()) goto L6;
        PreviewData r1 = r0.getValue();
        if (r1 == null) goto L12;
        AvatarChatterInfo r2 = r1.getChatterInfo();
    L13:
        this.chatterInfo = r2;
        goto L6
    L12:
        r2 = null;
        goto L13
    }

    public final void setChatterInfo(AvatarChatterInfo r1) {
        this.chatterInfo = r1;
    }

    public /* synthetic */ AvatarProperty(AvatarChatterInfo r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
