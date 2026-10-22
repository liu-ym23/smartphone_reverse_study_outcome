package com.ss.android.lark.export.entity;

import android.view.View;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.export.d;
import com.ss.android.lark.export.engine.EngineProperty;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import com.ss.android.lark.export.entity.turtle.TurtleCanvasEntity;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.utils.ApiUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import q6c.e;
import r6c.a;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002BW\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010BO\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0011J\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\tJ\u0006\u0010!\u001a\u00020\tJ\u0006\u0010\"\u001a\u00020\tJ\b\u0010#\u001a\u0004\u0018\u00010\u0004J\b\u0010$\u001a\u0004\u0018\u00010%J\u0013\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010-\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010.\u001a\u0004\u0018\u00010/J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\tHÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jc\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\t\u00109\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006:"}, d2 = {"Lcom/ss/android/lark/export/entity/PreviewHangPoint;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "url", BuildConfig.FLAVOR, "hangPointId", "messageId", "previewId", "needLocalPreview", BuildConfig.FLAVOR, "isLazyLoad", "sendScene", "Lcom/ss/android/lark/export/entity/SendScene;", "urlCardPreviewEntity", "Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/ss/android/lark/export/entity/SendScene;Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLcom/ss/android/lark/export/entity/UrlCardPreviewEntity;)V", "getUrl", "()Ljava/lang/String;", "getHangPointId", "getMessageId", "getPreviewId", "getNeedLocalPreview", "()Z", "getSendScene", "()Lcom/ss/android/lark/export/entity/SendScene;", "getUrlCardPreviewEntity", "()Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;", "setUrlCardPreviewEntity", "(Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;)V", "isValidCardData", "isSmartCard", "isMessageLink", "isTurtleCard", "getTurtleScriptId", "getTurtleCanvasEntity", "Lcom/ss/android/lark/export/entity/turtle/TurtleCanvasEntity;", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "isItemSame", "diffable", "isContentSame", "parseToPB", "Lcom/bytedance/lark/pb/basic/v1/PreviewHangPoint;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewHangPoint implements Serializable, b<PreviewHangPoint> {
    private final String hangPointId;
    private final boolean isLazyLoad;
    private final String messageId;
    private final boolean needLocalPreview;
    private final String previewId;
    private final SendScene sendScene;
    private final String url;
    private UrlCardPreviewEntity urlCardPreviewEntity;

    public static /* synthetic */ PreviewHangPoint copy$default(PreviewHangPoint r9, String r10, String r11, String r12, String r13, boolean r14, boolean r15, SendScene r16, UrlCardPreviewEntity r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.url;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.hangPointId;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.messageId;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.previewId;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.needLocalPreview;
    L23:
        if ((r18 & 32) == 0) goto L25;
        boolean r7 = r9.isLazyLoad;
    L27:
        if ((r18 & 64) == 0) goto L29;
        SendScene r8 = r9.sendScene;
    L31:
        if ((r18 & 128) == 0) goto L33;
        UrlCardPreviewEntity r1 = r9.urlCardPreviewEntity;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.hangPointId;
    }

    public final String component3() {
        return this.messageId;
    }

    public final String component4() {
        return this.previewId;
    }

    public final boolean component5() {
        return this.needLocalPreview;
    }

    public final boolean component6() {
        return this.isLazyLoad;
    }

    public final SendScene component7() {
        return this.sendScene;
    }

    public final UrlCardPreviewEntity component8() {
        return this.urlCardPreviewEntity;
    }

    public final PreviewHangPoint copy(String r11, String r12, String r13, String r14, boolean r15, boolean r16, SendScene r17, UrlCardPreviewEntity r18) {
        Intrinsics.checkNotNullParameter(r17, "sendScene");
        return new PreviewHangPoint(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public String toString() {
        return "PreviewHangPoint(url=" + this.url + ", hangPointId=" + this.hangPointId + ", messageId=" + this.messageId + ", previewId=" + this.previewId + ", needLocalPreview=" + this.needLocalPreview + ", isLazyLoad=" + this.isLazyLoad + ", sendScene=" + this.sendScene + ", urlCardPreviewEntity=" + this.urlCardPreviewEntity + ')';
    }

    public final TurtleCanvasEntity getTurtleCanvasEntity() {
        UrlCardPreviewEntity r0 = this.urlCardPreviewEntity;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTurtleCanvasEntity();
    }

    public final String getTurtleScriptId() {
        UrlCardPreviewEntity r0 = this.urlCardPreviewEntity;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getTurtleScriptId();
    }

    public int hashCode() {
        String r0 = this.url;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.hangPointId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.messageId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.previewId;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        int r13 = 1231;
        if (this.needLocalPreview == false) goto L21;
        int r14 = 1231;
    L22:
        int r15 = (r12 + r14) * 31;
        UrlCardPreviewEntity r16 = this.urlCardPreviewEntity;
        if (r16 == null) goto L25;
        r1 = r16.hashCode();
    L25:
        int r17 = (r15 + r1) * 31;
        if (this.isLazyLoad == true) goto L30;
        r13 = 1237;
    L30:
        return r17 + r13;
    L21:
        r14 = 1237;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final boolean isMessageLink() {
        UrlCardPreviewEntity r0 = this.urlCardPreviewEntity;
        if (r0 == null) goto L36;
        UrlPreviewBody r1 = r0.getPreviewBody();
        if (r1 == null) goto L44;
        Map<String, UrlPreviewState> r2 = r1.getStates();
        Boolean r3 = null;
        if (r2 == null) goto L9;
        UrlPreviewState r4 = r2.get(r1.getCurrentStateId());
    L10:
        HashMap<String, UrlPreviewTemplate> r5 = r1.getTemplates();
        if (r4 == null) goto L14;
        String r6 = r4.getTemplateId();
        if (r6 == null) goto L14;
    L15:
        UrlPreviewTemplate r7 = r5.get(r6);
        if (r7 == null) goto L18;
        Map<String, UrlPreviewComponent> r8 = r7.getElements();
    L19:
        if (r8 == null) goto L45;
        Iterator<Map.Entry<String, UrlPreviewComponent>> r9 = r8.entrySet().iterator();
    L22:
        if (r9.hasNext() == false) goto L46;
        UrlPreviewComponent r10 = r9.next().getValue();
        if (r10 == null) goto L26;
        BaseProperty r11 = r10.getProperty();
    L28:
        if ((r11 instanceof EngineProperty) == false) goto L22;
        BaseProperty r12 = r10.getProperty();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.ss.android.lark.export.engine.EngineProperty");
        EngineProperty.EngineType r13 = ((EngineProperty) r12).getEngineType();
        EngineProperty.EngineType r14 = EngineProperty.EngineType.MESSAGE;
        if (r13 != r14) goto L22;
        d<? extends e<? extends Props, ? extends View, ? extends a>> r15 = ((UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class)).getEngineComponentFactory(r14);
        if (r15 == null) goto L35;
        r3 = Boolean.valueOf(r15.a());
    L35:
        return Intrinsics.areEqual(r3, Boolean.TRUE);
    L26:
        r11 = null;
        goto L28
    L46:
        return false;
    L45:
        return false;
    L18:
        r8 = null;
    L14:
        r6 = BuildConfig.FLAVOR;
        goto L15
    L9:
        r4 = null;
        goto L10
    L44:
        return false;
    L36:
        return false;
    }

    public final boolean isSmartCard() {
        UrlCardPreviewEntity r0 = this.urlCardPreviewEntity;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isSmartCard() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isTurtleCard() {
        UrlCardPreviewEntity r0 = this.urlCardPreviewEntity;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isTurtleCard();
    }

    public final boolean isValidCardData() {
        String r0 = this.url;
        if (r0 != null) goto L5;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L20;
        UrlCardPreviewEntity r2 = this.urlCardPreviewEntity;
        if (r2 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == false) goto L20;
        return true;
    L15:
        if (r2.isValidCardData() != true) goto L17;
        r3 = true;
    L20:
        return false;
    L5:
        if (r0.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 != true) goto L10;
        r1 = true;
        goto L11
    L7:
        r4 = false;
        goto L8
    }

    public final com.bytedance.lark.pb.basic.v1.PreviewHangPoint parseToPB() {
        String r0 = this.url;
        if (r0 != null) goto L7;
        return null;
    L7:
        return new com.bytedance.lark.pb.basic.v1.PreviewHangPoint.Builder().url(r0).preview_id(this.previewId).close_card_preview(Boolean.FALSE).need_local_preview(Boolean.valueOf(this.needLocalPreview)).is_lazy_load(Boolean.valueOf(this.isLazyLoad)).build();
    }

    public final String getHangPointId() {
        return this.hangPointId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final boolean getNeedLocalPreview() {
        return this.needLocalPreview;
    }

    public final String getPreviewId() {
        return this.previewId;
    }

    public final SendScene getSendScene() {
        return this.sendScene;
    }

    public final String getUrl() {
        return this.url;
    }

    public final UrlCardPreviewEntity getUrlCardPreviewEntity() {
        return this.urlCardPreviewEntity;
    }

    public final boolean isLazyLoad() {
        return this.isLazyLoad;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(PreviewHangPoint.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.export.entity.PreviewHangPoint");
        PreviewHangPoint r6 = (PreviewHangPoint) r5;
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.hangPointId, r6.hangPointId) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.previewId, r6.previewId) == true) goto L25;
        return false;
    L25:
        if (this.needLocalPreview == r6.needLocalPreview) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.urlCardPreviewEntity, r6.urlCardPreviewEntity) == true) goto L31;
        return false;
    L31:
        if (this.isLazyLoad == r6.isLazyLoad) goto L33;
        return false;
    L33:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public boolean isContentSame(PreviewHangPoint r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.url, r4.url) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.hangPointId, r4.hangPointId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r4.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewId, r4.previewId) == true) goto L18;
        return false;
    L18:
        if (this.needLocalPreview == r4.needLocalPreview) goto L21;
        return false;
    L21:
        if (y28.a.c(this.urlCardPreviewEntity, r4.urlCardPreviewEntity) == true) goto L24;
        return false;
    L24:
        if (this.isLazyLoad == r4.isLazyLoad) goto L26;
        return false;
    L26:
        return true;
    }

    public boolean isItemSame(PreviewHangPoint r2) {
        UrlCardPreviewEntity r0 = this.urlCardPreviewEntity;
        if (r0 == null) goto L8;
        if (r2 == null) goto L6;
        UrlCardPreviewEntity r3 = r2.urlCardPreviewEntity;
    L10:
        return r0.isItemSame(r3);
    L6:
        r3 = null;
        goto L10
    L8:
        return false;
    }

    public final void setUrlCardPreviewEntity(UrlCardPreviewEntity r1) {
        this.urlCardPreviewEntity = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((PreviewHangPoint) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((PreviewHangPoint) r1);
    }

    public PreviewHangPoint(String r10, String r11, String r12, String r13, boolean r14, boolean r15, UrlCardPreviewEntity r16) {
        this(r10, r11, r12, r13, r14, r15, SendScene.DEFAULT, r16);
    }

    public PreviewHangPoint(String r2, String r3, String r4, String r5, boolean r6, boolean r7, SendScene r8, UrlCardPreviewEntity r9) {
        Intrinsics.checkNotNullParameter(r8, "sendScene");
        this.url = r2;
        this.hangPointId = r3;
        this.messageId = r4;
        this.previewId = r5;
        this.needLocalPreview = r6;
        this.isLazyLoad = r7;
        this.sendScene = r8;
        this.urlCardPreviewEntity = r9;
    }

    public /* synthetic */ PreviewHangPoint(String r11, String r12, String r13, String r14, boolean r15, boolean r16, UrlCardPreviewEntity r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 16) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r18 & 32) == 0) goto L9;
        boolean r8 = false;
    L10:
        this(r11, r12, r13, r14, r7, r8, r17);
        return;
    L9:
        r8 = r16;
        goto L10
    L5:
        r7 = r15;
        goto L7
    }

    public /* synthetic */ PreviewHangPoint(String r12, String r13, String r14, String r15, boolean r16, boolean r17, SendScene r18, UrlCardPreviewEntity r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 16) == 0) goto L5;
        boolean r7 = false;
    L7:
        if ((r20 & 32) == 0) goto L9;
        boolean r8 = false;
    L11:
        if ((r20 & 64) == 0) goto L13;
        SendScene r9 = SendScene.DEFAULT;
    L14:
        this(r12, r13, r14, r15, r7, r8, r9, r19);
        return;
    L13:
        r9 = r18;
        goto L14
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }
}
