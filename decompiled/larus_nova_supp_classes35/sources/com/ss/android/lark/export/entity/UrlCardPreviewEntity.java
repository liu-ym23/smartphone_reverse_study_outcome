package com.ss.android.lark.export.entity;

import android.view.View;
import com.ss.android.lark.export.a;
import com.ss.android.lark.export.api.UrlPreviewApi;
import com.ss.android.lark.export.d;
import com.ss.android.lark.export.engine.EngineProperty;
import com.ss.android.lark.export.engine.TurtleCardEngineProperty;
import com.ss.android.lark.export.engine.smartcard.SmartCardEngineProperty;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import com.ss.android.lark.export.entity.turtle.TurtleCanvasEntity;
import com.ss.android.lark.export.parser.ModelParserRenderRouterEntity;
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
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fB3\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u0010J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010#\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0000H\u0016J\u0006\u0010$\u001a\u00020!J\u0012\u0010%\u001a\u00020!*\u00020&2\u0006\u0010'\u001a\u00020(J\n\u0010)\u001a\u00020!*\u00020&J\n\u0010*\u001a\u00020!*\u00020&J\u0006\u0010+\u001a\u00020!J\u0006\u0010,\u001a\u00020!J\b\u0010-\u001a\u0004\u0018\u00010.J\b\u0010/\u001a\u0004\u0018\u000100J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\rHÆ\u0003JA\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u00107\u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020\u001eHÖ\u0001J\t\u0010:\u001a\u00020.HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006;"}, d2 = {"Lcom/ss/android/lark/export/entity/UrlCardPreviewEntity;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "Lcom/larksuite/framework/utils/diff/Diffable;", "inlineEntity", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "previewBody", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewBody;", "renderRouterEntity", "Lcom/ss/android/lark/export/entity/RenderRouterEntity;", "componentTreeTime", BuildConfig.FLAVOR, "extTranslateInfo", "Lcom/ss/android/lark/export/entity/ExtTranslateInfo;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;Lcom/ss/android/lark/export/entity/preview/UrlPreviewBody;Lcom/ss/android/lark/export/entity/RenderRouterEntity;JLcom/ss/android/lark/export/entity/ExtTranslateInfo;)V", "(Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;Lcom/ss/android/lark/export/entity/preview/UrlPreviewBody;Lcom/ss/android/lark/export/entity/RenderRouterEntity;J)V", "getInlineEntity", "()Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "getPreviewBody", "()Lcom/ss/android/lark/export/entity/preview/UrlPreviewBody;", "getRenderRouterEntity", "()Lcom/ss/android/lark/export/entity/RenderRouterEntity;", "getComponentTreeTime", "()J", "setComponentTreeTime", "(J)V", "getExtTranslateInfo", "()Lcom/ss/android/lark/export/entity/ExtTranslateInfo;", "compareTo", BuildConfig.FLAVOR, "other", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "isValidCardData", "engineFGIsEnable", "Lcom/ss/android/lark/export/engine/EngineProperty;", "engineType", "Lcom/ss/android/lark/export/engine/EngineProperty$EngineType;", "isMessageEngine", "isTurtleEngine", "isSmartCard", "isTurtleCard", "getTurtleScriptId", BuildConfig.FLAVOR, "getTurtleCanvasEntity", "Lcom/ss/android/lark/export/entity/turtle/TurtleCanvasEntity;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "hashCode", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlCardPreviewEntity implements Serializable, Comparable<UrlCardPreviewEntity>, b<UrlCardPreviewEntity> {
    private long componentTreeTime;
    private final ExtTranslateInfo extTranslateInfo;
    private final UrlInlinePreviewEntity inlineEntity;
    private final UrlPreviewBody previewBody;
    private final RenderRouterEntity renderRouterEntity;

    public static /* synthetic */ UrlCardPreviewEntity copy$default(UrlCardPreviewEntity r4, UrlInlinePreviewEntity r5, UrlPreviewBody r6, RenderRouterEntity r7, long r8, ExtTranslateInfo r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.inlineEntity;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.previewBody;
    L8:
        UrlPreviewBody r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.renderRouterEntity;
    L11:
        RenderRouterEntity r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.componentTreeTime;
    L14:
        long r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r10 = r4.extTranslateInfo;
    L17:
        UrlInlinePreviewEntity r9 = r5;
        return r4.copy(r9, r13, r0, r1, r10);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UrlCardPreviewEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "other");
        return 0;
    }

    public final UrlInlinePreviewEntity component1() {
        return this.inlineEntity;
    }

    public final UrlPreviewBody component2() {
        return this.previewBody;
    }

    public final RenderRouterEntity component3() {
        return this.renderRouterEntity;
    }

    public final long component4() {
        return this.componentTreeTime;
    }

    public final ExtTranslateInfo component5() {
        return this.extTranslateInfo;
    }

    public final UrlCardPreviewEntity copy(UrlInlinePreviewEntity r9, UrlPreviewBody r10, RenderRouterEntity r11, long r12, ExtTranslateInfo r14) {
        Intrinsics.checkNotNullParameter(r9, "inlineEntity");
        return new UrlCardPreviewEntity(r9, r10, r11, r12, r14);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof UrlCardPreviewEntity) == true) goto L8;
        return false;
    L8:
        UrlCardPreviewEntity r9 = (UrlCardPreviewEntity) r8;
        if (Intrinsics.areEqual(this.inlineEntity, r9.inlineEntity) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previewBody, r9.previewBody) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.renderRouterEntity, r9.renderRouterEntity) == true) goto L18;
        return false;
    L18:
        if (this.componentTreeTime == r9.componentTreeTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.extTranslateInfo, r9.extTranslateInfo) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.inlineEntity.hashCode() * 31;
        UrlPreviewBody r1 = this.previewBody;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        RenderRouterEntity r5 = this.renderRouterEntity;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        long r7 = this.componentTreeTime;
        int r8 = (((r4 + r6) * 31) + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        ExtTranslateInfo r9 = this.extTranslateInfo;
        if (r9 == null) goto L15;
        r2 = r9.hashCode();
    L15:
        return r8 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "UrlCardPreviewEntity(inlineEntity=" + this.inlineEntity + ", previewBody=" + this.previewBody + ", renderRouterEntity=" + this.renderRouterEntity + ", componentTreeTime=" + this.componentTreeTime + ", extTranslateInfo=" + this.extTranslateInfo + ')';
    }

    public final TurtleCanvasEntity getTurtleCanvasEntity() {
        UrlPreviewBody r0 = this.previewBody;
        if (r0 == null) goto L17;
        Map<String, UrlPreviewState> r2 = r0.getStates();
        if (r2 == null) goto L7;
        UrlPreviewState r3 = r2.get(r0.getCurrentStateId());
    L8:
        HashMap<String, UrlPreviewTemplate> r1 = r0.getTemplates();
        if (r3 == null) goto L11;
        String r4 = r3.getTemplateId();
    L12:
        if (r4 != null) goto L14;
        r4 = BuildConfig.FLAVOR;
    L14:
        UrlPreviewTemplate r5 = r1.get(r4);
        if (r5 == null) goto L17;
        Map<String, UrlPreviewComponent> r6 = r5.getElements();
    L18:
        if (r6 == null) goto L38;
        Iterator<Map.Entry<String, UrlPreviewComponent>> r7 = r6.entrySet().iterator();
    L21:
        if (r7.hasNext() == false) goto L39;
        UrlPreviewComponent r8 = r7.next().getValue();
        if (r8 == null) goto L25;
        BaseProperty r9 = r8.getProperty();
    L27:
        if ((r9 instanceof TurtleCardEngineProperty) == false) goto L29;
        TurtleCanvasEntity r10 = ((TurtleCardEngineProperty) r9).getTurtleContent();
    L30:
        if (r10 == null) goto L21;
        return r10;
    L29:
        r10 = null;
        goto L30
    L25:
        r9 = null;
        goto L27
    L39:
        return null;
    L38:
        return null;
    L11:
        r4 = null;
        goto L12
    L7:
        r3 = null;
    L17:
        r6 = null;
        goto L18
    }

    public final boolean isSmartCard() {
        RenderRouterEntity r0 = this.renderRouterEntity;
        if (r0 == null) goto L34;
        HashMap<String, CardComponent> r1 = r0.getElements();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.isEmpty() == true) goto L25;
        Iterator<Map.Entry<String, CardComponent>> r2 = r1.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L25;
        CardComponent r3 = r2.next().getValue();
        if ((r3.getProperty() instanceof SmartCardEngineProperty) == false) goto L22;
        ModelParserRenderRouterEntity.CardEngineType r4 = ((SmartCardEngineProperty) r3.getProperty()).getEngineType();
        ModelParserRenderRouterEntity.CardEngineType r5 = ModelParserRenderRouterEntity.CardEngineType.UNIVERSAL_CARD;
        if (r4 != r5) goto L22;
        a<? extends e<? extends Props, ? extends View, ? extends r6c.a>> r6 = ((UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class)).getCardEngineComponentFactory(r5);
        if (r6 == null) goto L19;
        r6.a();
        boolean r7 = true;
    L20:
        if (r7 == false) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == false) goto L11;
        boolean r9 = true;
    L26:
        if (r9 != true) goto L36;
        return true;
    L36:
        return false;
    L19:
        r7 = false;
    L22:
        r8 = false;
    L25:
        r9 = false;
        goto L26
    L34:
        return false;
    }

    public final boolean isTurtleCard() {
        UrlPreviewBody r0 = this.previewBody;
        if (r0 == null) goto L44;
        Map<String, UrlPreviewState> r2 = r0.getStates();
        if (r2 == null) goto L7;
        UrlPreviewState r3 = r2.get(r0.getCurrentStateId());
    L8:
        HashMap<String, UrlPreviewTemplate> r1 = r0.getTemplates();
        if (r3 == null) goto L11;
        String r4 = r3.getTemplateId();
    L12:
        if (r4 != null) goto L14;
        r4 = BuildConfig.FLAVOR;
    L14:
        UrlPreviewTemplate r5 = r1.get(r4);
        if (r5 == null) goto L17;
        Map<String, UrlPreviewComponent> r6 = r5.getElements();
    L18:
        if (r6 != null) goto L21;
        return false;
    L21:
        if (r6.isEmpty() == true) goto L46;
        Iterator<Map.Entry<String, UrlPreviewComponent>> r7 = r6.entrySet().iterator();
    L25:
        if (r7.hasNext() == false) goto L47;
        UrlPreviewComponent r8 = r7.next().getValue();
        if (r8 == null) goto L29;
        BaseProperty r9 = r8.getProperty();
    L31:
        if ((r9 instanceof EngineProperty) == true) goto L33;
    L35:
        boolean r10 = false;
    L36:
        if (r10 == false) goto L25;
        return true;
    L33:
        if (isTurtleEngine((EngineProperty) r9) == false) goto L35;
        r10 = true;
        goto L36
    L29:
        r9 = null;
        goto L31
    L47:
        return false;
    L46:
        return false;
    L17:
        r6 = null;
        goto L18
    L11:
        r4 = null;
        goto L12
    L7:
        r3 = null;
        goto L8
    L44:
        return false;
    }

    public final boolean isValidCardData() {
        UrlPreviewBody r0 = this.previewBody;
        if (r0 == null) goto L44;
        Map<String, UrlPreviewState> r1 = r0.getStates();
        if (r1 == null) goto L7;
        UrlPreviewState r2 = r1.get(r0.getCurrentStateId());
    L8:
        HashMap<String, UrlPreviewTemplate> r3 = r0.getTemplates();
        if (r2 == null) goto L11;
        String r4 = r2.getTemplateId();
    L12:
        if (r4 != null) goto L14;
        r4 = BuildConfig.FLAVOR;
    L14:
        UrlPreviewTemplate r5 = r3.get(r4);
        if (r5 == null) goto L17;
        Map<String, UrlPreviewComponent> r6 = r5.getElements();
    L18:
        if (r6 == null) goto L44;
        if (r6.isEmpty() == false) goto L23;
    L22:
        boolean r7 = true;
    L38:
        if (r7 == true) goto L40;
        return false;
    L40:
        if (r6.size() <= 1) goto L51;
        return true;
    L51:
        return false;
    L23:
        Iterator<Map.Entry<String, UrlPreviewComponent>> r8 = r6.entrySet().iterator();
    L25:
        if (r8.hasNext() == false) goto L22;
        UrlPreviewComponent r9 = r8.next().getValue();
        if (r9 == null) goto L29;
        BaseProperty r10 = r9.getProperty();
    L31:
        if ((r10 instanceof EngineProperty) == false) goto L35;
        EngineProperty r11 = (EngineProperty) r10;
        if (engineFGIsEnable(r11, r11.getEngineType()) == true) goto L35;
        boolean r12 = true;
    L36:
        if (r12 == false) goto L25;
        r7 = false;
    L35:
        r12 = false;
        goto L36
    L29:
        r10 = null;
        goto L31
    L17:
        r6 = null;
        goto L18
    L11:
        r4 = null;
        goto L12
    L7:
        r2 = null;
    L44:
        return isSmartCard();
    }

    public final String getTurtleScriptId() {
        TurtleCanvasEntity r0 = getTurtleCanvasEntity();
        if (r0 == null) goto L5;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        return r0.getScriptKey() + r0.getScriptVersion();
    L5:
        return null;
    }

    public final long getComponentTreeTime() {
        return this.componentTreeTime;
    }

    public final ExtTranslateInfo getExtTranslateInfo() {
        return this.extTranslateInfo;
    }

    public final UrlInlinePreviewEntity getInlineEntity() {
        return this.inlineEntity;
    }

    public final UrlPreviewBody getPreviewBody() {
        return this.previewBody;
    }

    public final RenderRouterEntity getRenderRouterEntity() {
        return this.renderRouterEntity;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UrlCardPreviewEntity r1) {
        return compareTo2(r1);
    }

    public boolean isContentSame(UrlCardPreviewEntity r6) {
        if (this != r6) goto L5;
        return true;
    L5:
        UrlInlinePreviewEntity r1 = this.inlineEntity;
        ExtTranslateInfo r2 = null;
        if (r6 == null) goto L8;
        UrlInlinePreviewEntity r3 = r6.inlineEntity;
    L10:
        if (r1.isContentSame(r3) == true) goto L12;
        return false;
    L12:
        UrlPreviewBody r4 = this.previewBody;
        if (r6 == null) goto L15;
        UrlPreviewBody r5 = r6.previewBody;
    L17:
        if (Intrinsics.areEqual(r4, r5) == true) goto L19;
        return false;
    L19:
        RenderRouterEntity r7 = this.renderRouterEntity;
        if (r6 == null) goto L22;
        RenderRouterEntity r8 = r6.renderRouterEntity;
    L24:
        if (Intrinsics.areEqual(r7, r8) == true) goto L26;
        return false;
    L26:
        ExtTranslateInfo r9 = this.extTranslateInfo;
        if (r6 == null) goto L30;
        r2 = r6.extTranslateInfo;
    L30:
        if (Intrinsics.areEqual(r9, r2) == true) goto L32;
        return false;
    L32:
        return true;
    L22:
        r8 = null;
        goto L24
    L15:
        r5 = null;
        goto L17
    L8:
        r3 = null;
        goto L10
    }

    public boolean isItemSame(UrlCardPreviewEntity r2) {
        UrlInlinePreviewEntity r0 = this.inlineEntity;
        if (r0 == null) goto L8;
        if (r2 == null) goto L6;
        UrlInlinePreviewEntity r3 = r2.inlineEntity;
    L10:
        return r0.isItemSame(r3);
    L6:
        r3 = null;
        goto L10
    L8:
        return false;
    }

    public final boolean isMessageEngine(EngineProperty r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.getEngineType() == EngineProperty.EngineType.MESSAGE) goto L5;
    L7:
        return false;
    L5:
        if (engineFGIsEnable(r3, r3.getEngineType()) == false) goto L7;
        return true;
    }

    public final boolean isTurtleEngine(EngineProperty r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.getEngineType() == EngineProperty.EngineType.TURTLE_CANVAS) goto L5;
    L7:
        return false;
    L5:
        if (engineFGIsEnable(r3, r3.getEngineType()) == false) goto L7;
        return true;
    }

    public final void setComponentTreeTime(long r1) {
        this.componentTreeTime = r1;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((UrlCardPreviewEntity) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((UrlCardPreviewEntity) r1);
    }

    public final boolean engineFGIsEnable(EngineProperty r2, EngineProperty.EngineType r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "engineType");
        d<? extends e<? extends Props, ? extends View, ? extends r6c.a>> r4 = ((UrlPreviewApi) ApiUtils.getApi(UrlPreviewApi.class)).getEngineComponentFactory(r3);
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.a() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public UrlCardPreviewEntity(UrlInlinePreviewEntity r9, UrlPreviewBody r10, RenderRouterEntity r11, long r12) {
        Intrinsics.checkNotNullParameter(r9, "inlineEntity");
        this(r9, r10, r11, r12, null);
    }

    public UrlCardPreviewEntity(UrlInlinePreviewEntity r2, UrlPreviewBody r3, RenderRouterEntity r4, long r5, ExtTranslateInfo r7) {
        Intrinsics.checkNotNullParameter(r2, "inlineEntity");
        this.inlineEntity = r2;
        this.previewBody = r3;
        this.renderRouterEntity = r4;
        this.componentTreeTime = r5;
        this.extTranslateInfo = r7;
    }

    public /* synthetic */ UrlCardPreviewEntity(UrlInlinePreviewEntity r8, UrlPreviewBody r9, RenderRouterEntity r10, long r11, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        UrlPreviewBody r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        RenderRouterEntity r4 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        r11 = 0;
    L13:
        this(r8, r3, r4, r11);
        return;
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public /* synthetic */ UrlCardPreviewEntity(UrlInlinePreviewEntity r7, UrlPreviewBody r8, RenderRouterEntity r9, long r10, ExtTranslateInfo r12, int r13, DefaultConstructorMarker r14) {
        ExtTranslateInfo r1 = null;
        if ((r13 & 2) == 0) goto L5;
        UrlPreviewBody r0 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        RenderRouterEntity r2 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        long r3 = 0;
    L15:
        if ((r13 & 16) != 0) goto L18;
        r1 = r12;
    L18:
        this(r7, r0, r2, r3, r1);
        return;
    L13:
        r3 = r10;
        goto L15
    L9:
        r2 = r9;
        goto L11
    L5:
        r0 = r8;
        goto L7
    }
}
