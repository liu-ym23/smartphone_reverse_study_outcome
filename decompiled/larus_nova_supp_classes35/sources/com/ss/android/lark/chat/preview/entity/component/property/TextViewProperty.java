package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TextViewProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "text", BuildConfig.FLAVOR, "numberOfLines", BuildConfig.FLAVOR, "actionId", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getNumberOfLines", "()I", "setNumberOfLines", "(I)V", "getActionId", "setActionId", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextViewProperty extends BaseProperty {
    private String actionId;
    private int numberOfLines;
    private String text;

    public TextViewProperty() {
        this(null, 0, null, 7, null);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        return (((super.hashCode() * 31) + this.text.hashCode()) * 31) + this.text.hashCode();
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final int getNumberOfLines() {
        return this.numberOfLines;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TextViewProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L11;
        return false;
    L11:
        TextViewProperty r6 = (TextViewProperty) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L15;
        return false;
    L15:
        if (this.numberOfLines == r6.numberOfLines) goto L17;
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
        if (r5.hasNext() == false) goto L31;
        Map.Entry<Integer, PreviewData> r0 = r5.next();
        int r1 = r0.getKey().intValue();
        if (r1 == ComponentAttribute.text.getValue()) goto L9;
        if (r1 == ComponentAttribute.number_of_lines.getValue()) goto L17;
        if (r1 != ComponentAttribute.action_id.getValue()) goto L6;
        PreviewData r2 = r0.getValue();
        if (r2 == null) goto L29;
        String r3 = r2.getString();
    L30:
        this.actionId = r3;
        goto L6
    L29:
        r3 = null;
        goto L30
    L17:
        PreviewData r6 = r0.getValue();
        if (r6 == null) goto L22;
        Integer r7 = r6.getInt();
        if (r7 == null) goto L22;
        int r8 = r7.intValue();
    L23:
        this.numberOfLines = r8;
    L22:
        r8 = 0;
        goto L23
    L9:
        PreviewData r9 = r0.getValue();
        if (r9 == null) goto L13;
        String r10 = r9.getString();
        if (r10 == null) goto L13;
    L14:
        this.text = r10;
    L13:
        r10 = BuildConfig.FLAVOR;
        goto L14
    }

    public final void setActionId(String r1) {
        this.actionId = r1;
    }

    public final void setNumberOfLines(int r1) {
        this.numberOfLines = r1;
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }

    public TextViewProperty(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "text");
        super(Type.TEXT);
        this.text = r2;
        this.numberOfLines = r3;
        this.actionId = r4;
    }

    public /* synthetic */ TextViewProperty(String r1, int r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = BuildConfig.FLAVOR;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = null;
    L11:
        this(r1, r2, r3);
    }
}
