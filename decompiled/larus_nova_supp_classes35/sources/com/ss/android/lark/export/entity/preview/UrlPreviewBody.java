package com.ss.android.lark.export.entity.preview;

import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0005\u0012&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012T\b\u0002\u0010\u0013\u001aN\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u00010\u000ej&\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u0001`\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0096\u0002J\b\u00104\u001a\u000205H\u0016J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\u0019\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0005HÆ\u0003J)\u0010;\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010HÆ\u0003J\t\u0010<\u001a\u00020\u0012HÆ\u0003JU\u0010=\u001aN\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u00010\u000ej&\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u0001`\u0010HÆ\u0003Jç\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00052(\b\u0002\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122T\b\u0002\u0010\u0013\u001aN\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u00010\u000ej&\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u0001`\u0010HÆ\u0001J\t\u0010?\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR*\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR:\u0010\r\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000ej\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R]\u0010\u0013\u001aN\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u00010\u000ej&\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0005j\u0004\u0018\u0001`\u0015\u0018\u0001`\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(¨\u0006@"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewBody;", "Ljava/io/Serializable;", "urlPreviewComponents", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewComponents;", "actions", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ss/android/lark/export/entity/preview/UrlPreviewAction;", "cardUrl", "Lcom/ss/android/lark/export/entity/preview/Url;", "currentStateId", "states", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewState;", "templates", "Ljava/util/HashMap;", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewTemplate;", "Lkotlin/collections/HashMap;", "uiRenderTime", BuildConfig.FLAVOR, "componentHangPoints", "Lcom/ss/android/lark/export/entity/PreviewHangPoint;", "Lcom/ss/android/lark/export/entity/PreviewHangPointPair;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/UrlPreviewComponents;Ljava/util/Map;Lcom/ss/android/lark/export/entity/preview/Url;Ljava/lang/String;Ljava/util/Map;Ljava/util/HashMap;JLjava/util/HashMap;)V", "getUrlPreviewComponents$annotations", "()V", "getUrlPreviewComponents", "()Lcom/ss/android/lark/export/entity/preview/UrlPreviewComponents;", "getActions$annotations", "getActions", "()Ljava/util/Map;", "getCardUrl$annotations", "getCardUrl", "()Lcom/ss/android/lark/export/entity/preview/Url;", "getCurrentStateId", "()Ljava/lang/String;", "setCurrentStateId", "(Ljava/lang/String;)V", "getStates", "getTemplates", "()Ljava/util/HashMap;", "setTemplates", "(Ljava/util/HashMap;)V", "getUiRenderTime", "()J", "setUiRenderTime", "(J)V", "getComponentHangPoints", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewBody implements Serializable {
    private final Map<String, UrlPreviewAction> actions;
    private final Url cardUrl;
    private final HashMap<String, Map<String, PreviewHangPoint>> componentHangPoints;
    private String currentStateId;
    private final Map<String, UrlPreviewState> states;
    private HashMap<String, UrlPreviewTemplate> templates;
    private long uiRenderTime;
    private final UrlPreviewComponents urlPreviewComponents;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UrlPreviewBody copy$default(UrlPreviewBody r10, UrlPreviewComponents r11, Map r12, Url r13, String r14, Map r15, HashMap r16, long r17, HashMap r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        UrlPreviewComponents r2 = r10.urlPreviewComponents;
    L7:
        if ((r20 & 2) == 0) goto L9;
        Map r3 = r10.actions;
    L11:
        if ((r20 & 4) == 0) goto L13;
        Url r4 = r10.cardUrl;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.currentStateId;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Map r6 = r10.states;
    L23:
        if ((r20 & 32) == 0) goto L25;
        HashMap r7 = r10.templates;
    L27:
        if ((r20 & 64) == 0) goto L29;
        long r8 = r10.uiRenderTime;
    L31:
        if ((r20 & 128) == 0) goto L33;
        HashMap r1 = r10.componentHangPoints;
    L35:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r19;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    @Deprecated(message = "state")
    public static /* synthetic */ void getActions$annotations() {
    }

    @Deprecated(message = "state")
    public static /* synthetic */ void getCardUrl$annotations() {
    }

    @Deprecated(message = "template")
    public static /* synthetic */ void getUrlPreviewComponents$annotations() {
    }

    public final UrlPreviewComponents component1() {
        return this.urlPreviewComponents;
    }

    public final Map<String, UrlPreviewAction> component2() {
        return this.actions;
    }

    public final Url component3() {
        return this.cardUrl;
    }

    public final String component4() {
        return this.currentStateId;
    }

    public final Map<String, UrlPreviewState> component5() {
        return this.states;
    }

    public final HashMap<String, UrlPreviewTemplate> component6() {
        return this.templates;
    }

    public final long component7() {
        return this.uiRenderTime;
    }

    public final HashMap<String, Map<String, PreviewHangPoint>> component8() {
        return this.componentHangPoints;
    }

    public final UrlPreviewBody copy(UrlPreviewComponents r12, Map<String, UrlPreviewAction> r13, Url r14, String r15, Map<String, UrlPreviewState> r16, HashMap<String, UrlPreviewTemplate> r17, long r18, HashMap<String, Map<String, PreviewHangPoint>> r20) {
        Intrinsics.checkNotNullParameter(r15, "currentStateId");
        Intrinsics.checkNotNullParameter(r17, "templates");
        return new UrlPreviewBody(r12, r13, r14, r15, r16, r17, r18, r20);
    }

    public String toString() {
        return "UrlPreviewBody(urlPreviewComponents=" + this.urlPreviewComponents + ", actions=" + this.actions + ", cardUrl=" + this.cardUrl + ", currentStateId=" + this.currentStateId + ", states=" + this.states + ", templates=" + this.templates + ", uiRenderTime=" + this.uiRenderTime + ", componentHangPoints=" + this.componentHangPoints + ')';
    }

    public int hashCode() {
        UrlPreviewComponents r0 = this.urlPreviewComponents;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, UrlPreviewAction> r4 = this.actions;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Url r7 = this.cardUrl;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + this.currentStateId.hashCode()) * 31;
        Map<String, UrlPreviewState> r10 = this.states;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        HashMap<String, UrlPreviewTemplate> r13 = this.templates;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        HashMap<String, Map<String, PreviewHangPoint>> r16 = this.componentHangPoints;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
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

    public final Map<String, UrlPreviewAction> getActions() {
        return this.actions;
    }

    public final Url getCardUrl() {
        return this.cardUrl;
    }

    public final HashMap<String, Map<String, PreviewHangPoint>> getComponentHangPoints() {
        return this.componentHangPoints;
    }

    public final String getCurrentStateId() {
        return this.currentStateId;
    }

    public final Map<String, UrlPreviewState> getStates() {
        return this.states;
    }

    public final HashMap<String, UrlPreviewTemplate> getTemplates() {
        return this.templates;
    }

    public final long getUiRenderTime() {
        return this.uiRenderTime;
    }

    public final UrlPreviewComponents getUrlPreviewComponents() {
        return this.urlPreviewComponents;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrlPreviewBody) == true) goto L8;
        return false;
    L8:
        UrlPreviewBody r6 = (UrlPreviewBody) r5;
        if (Intrinsics.areEqual(this.urlPreviewComponents, r6.urlPreviewComponents) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardUrl, r6.cardUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.currentStateId, r6.currentStateId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.states, r6.states) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.templates, r6.templates) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.componentHangPoints, r6.componentHangPoints) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final void setCurrentStateId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.currentStateId = r2;
    }

    public final void setTemplates(HashMap<String, UrlPreviewTemplate> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.templates = r2;
    }

    public final void setUiRenderTime(long r1) {
        this.uiRenderTime = r1;
    }

    public UrlPreviewBody(UrlPreviewComponents r2, Map<String, UrlPreviewAction> r3, Url r4, String r5, Map<String, UrlPreviewState> r6, HashMap<String, UrlPreviewTemplate> r7, long r8, HashMap<String, Map<String, PreviewHangPoint>> r10) {
        Intrinsics.checkNotNullParameter(r5, "currentStateId");
        Intrinsics.checkNotNullParameter(r7, "templates");
        this.urlPreviewComponents = r2;
        this.actions = r3;
        this.cardUrl = r4;
        this.currentStateId = r5;
        this.states = r6;
        this.templates = r7;
        this.uiRenderTime = r8;
        this.componentHangPoints = r10;
    }

    public /* synthetic */ UrlPreviewBody(UrlPreviewComponents r13, Map r14, Url r15, String r16, Map r17, HashMap r18, long r19, HashMap r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 8) == 0) goto L5;
        String r6 = BuildConfig.FLAVOR;
    L7:
        if ((r22 & 16) == 0) goto L9;
        Map r7 = null;
    L11:
        if ((r22 & 64) == 0) goto L13;
        long r9 = 0;
    L15:
        if ((r22 & 128) == 0) goto L17;
        HashMap r11 = null;
    L18:
        this(r13, r14, r15, r6, r7, r18, r9, r11);
        return;
    L17:
        r11 = r21;
        goto L18
    L13:
        r9 = r19;
        goto L15
    L9:
        r7 = r17;
        goto L11
    L5:
        r6 = r16;
        goto L7
    }
}
