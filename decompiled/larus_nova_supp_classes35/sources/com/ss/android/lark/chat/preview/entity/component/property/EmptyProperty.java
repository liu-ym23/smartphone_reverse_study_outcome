package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/EmptyProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", IPortraitService.TYPE, "Lcom/ss/android/lark/export/entity/preview/Type;", "actionId", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/export/entity/preview/Type;Ljava/lang/String;)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/Type;", "getActionId", "()Ljava/lang/String;", "setActionId", "(Ljava/lang/String;)V", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyProperty extends BaseProperty {
    private String actionId;
    private final Type type;

    public static /* synthetic */ EmptyProperty copy$default(EmptyProperty r0, Type r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.actionId;
    L9:
        return r0.copy(r1, r2);
    }

    public final Type component1() {
        return this.type;
    }

    public final String component2() {
        return this.actionId;
    }

    public final EmptyProperty copy(Type r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        return new EmptyProperty(r2, r3);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof EmptyProperty) == true) goto L8;
        return false;
    L8:
        EmptyProperty r6 = (EmptyProperty) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionId, r6.actionId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = this.type.hashCode() * 31;
        String r1 = this.actionId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "EmptyProperty(type=" + this.type + ", actionId=" + this.actionId + ')';
    }

    public final String getActionId() {
        return this.actionId;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public Type getType() {
        return this.type;
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
        if (r0.getKey().intValue() != ComponentAttribute.action_id.getValue()) goto L6;
        PreviewData r1 = r0.getValue();
        if (r1 == null) goto L12;
        String r2 = r1.getString();
    L13:
        this.actionId = r2;
        goto L6
    L12:
        r2 = null;
        goto L13
    }

    public final void setActionId(String r1) {
        this.actionId = r1;
    }

    public EmptyProperty(Type r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        super(r2);
        this.type = r2;
        this.actionId = r3;
    }

    public /* synthetic */ EmptyProperty(Type r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }
}
