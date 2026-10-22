package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.chat.entity.preview.DocType;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\u0013\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010.H\u0096\u0002J\b\u0010/\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0018R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00060"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/DocImageProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "docType", "Lcom/ss/android/lark/chat/entity/preview/DocType;", "token", BuildConfig.FLAVOR, "thumbnailUrl", "secretUrl", "secretType", BuildConfig.FLAVOR, "secretKey", "secretNonce", "supportPreview", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/chat/entity/preview/DocType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Z)V", "getDocType", "()Lcom/ss/android/lark/chat/entity/preview/DocType;", "setDocType", "(Lcom/ss/android/lark/chat/entity/preview/DocType;)V", "getToken", "()Ljava/lang/String;", "getThumbnailUrl", "setThumbnailUrl", "(Ljava/lang/String;)V", "getSecretUrl", "setSecretUrl", "getSecretType", "()Ljava/lang/Integer;", "setSecretType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSecretKey", "setSecretKey", "getSecretNonce", "setSecretNonce", "getSupportPreview", "()Z", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "Lcom/ss/android/lark/tangram/base/props/Props;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocImageProperty extends BaseProperty {
    private DocType docType;
    private String secretKey;
    private String secretNonce;
    private Integer secretType;
    private String secretUrl;
    private final boolean supportPreview;
    private String thumbnailUrl;
    private final String token;

    public DocImageProperty() {
        this(null, null, null, null, null, null, null, false, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
    }

    public Props clone() {
        return new DocImageProperty(this.docType, this.token, this.thumbnailUrl, this.secretUrl, this.secretType, this.secretKey, this.secretNonce, this.supportPreview);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = ((super.hashCode() * 31) + this.docType.hashCode()) * 31;
        String r1 = this.thumbnailUrl;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.secretUrl;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.secretType;
        if (r8 == null) goto L13;
        int r9 = r8.intValue();
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.secretKey;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.secretNonce;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        return r13 + r2;
    L17:
        r12 = 0;
        goto L18
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

    public final DocType getDocType() {
        return this.docType;
    }

    public final String getSecretKey() {
        return this.secretKey;
    }

    public final String getSecretNonce() {
        return this.secretNonce;
    }

    public final Integer getSecretType() {
        return this.secretType;
    }

    public final String getSecretUrl() {
        return this.secretUrl;
    }

    public final boolean getSupportPreview() {
        return this.supportPreview;
    }

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final String getToken() {
        return this.token;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocImageProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L11;
        return false;
    L11:
        DocImageProperty r6 = (DocImageProperty) r5;
        if (this.docType == r6.docType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.thumbnailUrl, r6.thumbnailUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.secretUrl, r6.secretUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.secretType, r6.secretType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.secretKey, r6.secretKey) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.secretNonce, r6.secretNonce) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r6 = r5.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L46;
        Map.Entry<Integer, PreviewData> r0 = r6.next();
        int r1 = r0.getKey().intValue();
        if (r1 == ComponentAttribute.doc_type.getValue()) goto L9;
        String r3 = null;
        String r4 = null;
        String r7 = null;
        Integer r8 = null;
        String r9 = null;
        if (r1 == ComponentAttribute.thumbnail_url.getValue()) goto L18;
        if (r1 == ComponentAttribute.secret_url.getValue()) goto L24;
        if (r1 == ComponentAttribute.secret_type.getValue()) goto L30;
        if (r1 == ComponentAttribute.secret_key.getValue()) goto L36;
        if (r1 != ComponentAttribute.secret_nonce.getValue()) goto L6;
        PreviewData r2 = r0.getValue();
        if (r2 == null) goto L45;
        r4 = r2.getString();
    L45:
        this.secretNonce = r4;
        goto L6
    L36:
        PreviewData r10 = r0.getValue();
        if (r10 == null) goto L39;
        r7 = r10.getString();
    L39:
        this.secretKey = r7;
        goto L6
    L30:
        PreviewData r11 = r0.getValue();
        if (r11 == null) goto L33;
        r8 = r11.getInt();
    L33:
        this.secretType = r8;
        goto L6
    L24:
        PreviewData r12 = r0.getValue();
        if (r12 == null) goto L27;
        r9 = r12.getString();
    L27:
        this.secretUrl = r9;
        goto L6
    L18:
        PreviewData r13 = r0.getValue();
        if (r13 == null) goto L21;
        r3 = r13.getString();
    L21:
        this.thumbnailUrl = r3;
        goto L6
    L9:
        DocType.a r14 = DocType.Companion;
        PreviewData r15 = r0.getValue();
        if (r15 == null) goto L14;
        Integer r16 = r15.getInt();
        if (r16 == null) goto L14;
        int r17 = r16.intValue();
    L15:
        r14.getClass();
        this.docType = DocType.a.a(r17);
    L14:
        r17 = 0;
        goto L15
    }

    public final void setDocType(DocType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.docType = r2;
    }

    public final void setSecretKey(String r1) {
        this.secretKey = r1;
    }

    public final void setSecretNonce(String r1) {
        this.secretNonce = r1;
    }

    public final void setSecretType(Integer r1) {
        this.secretType = r1;
    }

    public final void setSecretUrl(String r1) {
        this.secretUrl = r1;
    }

    public final void setThumbnailUrl(String r1) {
        this.thumbnailUrl = r1;
    }

    public DocImageProperty(DocType r2, String r3, String r4, String r5, Integer r6, String r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "docType");
        super(Type.DOC_IMAGE);
        this.docType = r2;
        this.token = r3;
        this.thumbnailUrl = r4;
        this.secretUrl = r5;
        this.secretType = r6;
        this.secretKey = r7;
        this.secretNonce = r8;
        this.supportPreview = r9;
    }

    public /* synthetic */ DocImageProperty(DocType r11, String r12, String r13, String r14, Integer r15, String r16, String r17, boolean r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 1) == 0) goto L5;
        DocType r1 = DocType.UNKNOWN;
    L6:
        String r3 = null;
        if ((r19 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r5 = null;
    L18:
        boolean r7 = false;
        if ((r19 & 16) == 0) goto L21;
        Integer r6 = 0;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r19 & 64) != 0) goto L31;
        r3 = r17;
    L31:
        if ((r19 & 128) != 0) goto L34;
        r7 = r18;
    L34:
        this(r1, r2, r4, r5, r6, r8, r3, r7);
        return;
    L25:
        r8 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L18
    L13:
        r4 = r13;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L6
    }
}
