package com.bytedance.android.ec.base.api.ai;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u001b\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\rHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u0087\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016¨\u0006-"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/AIChatInputConfig;", "", "defaultInputMode", "", "hint", "", "speakHint", "indicateActionEntrance", "actionEntranceConfig", "", "showPlusMenu", "", "plusActions", "", "enableActionBar", "useAlphaStyle", "(ILjava/lang/String;Ljava/lang/String;ILjava/util/Map;ZLjava/util/List;ZZ)V", "getActionEntranceConfig", "()Ljava/util/Map;", "getDefaultInputMode", "()I", "getEnableActionBar", "()Z", "getHint", "()Ljava/lang/String;", "getIndicateActionEntrance", "getPlusActions", "()Ljava/util/List;", "getShowPlusMenu", "getSpeakHint", "getUseAlphaStyle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AIChatInputConfig {
    private final Map<String, String> actionEntranceConfig;
    private final int defaultInputMode;
    private final boolean enableActionBar;
    private final String hint;
    private final int indicateActionEntrance;
    private final List<Map<String, String>> plusActions;
    private final boolean showPlusMenu;
    private final String speakHint;
    private final boolean useAlphaStyle;

    public AIChatInputConfig() {
        this(0, null, null, 0, null, false, null, false, false, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIChatInputConfig copy$default(AIChatInputConfig r10, int r11, String r12, String r13, int r14, Map r15, boolean r16, List r17, boolean r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r22 = r10.defaultInputMode;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r23 = r10.hint;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r24 = r10.speakHint;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r25 = r10.indicateActionEntrance;
    L19:
        if ((r20 & 16) == 0) goto L21;
        Map r26 = r10.actionEntranceConfig;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r27 = r10.showPlusMenu;
    L27:
        if ((r20 & 64) == 0) goto L29;
        List r28 = r10.plusActions;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r29 = r10.enableActionBar;
    L35:
        if ((r20 & 256) == 0) goto L37;
        boolean r1 = r10.useAlphaStyle;
    L39:
        return r10.copy(r22, r23, r24, r25, r26, r27, r28, r29, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r29 = r18;
        goto L35
    L29:
        r28 = r17;
        goto L31
    L25:
        r27 = r16;
        goto L27
    L21:
        r26 = r15;
        goto L23
    L17:
        r25 = r14;
        goto L19
    L13:
        r24 = r13;
        goto L15
    L9:
        r23 = r12;
        goto L11
    L5:
        r22 = r11;
        goto L7
    }

    public final int component1() {
        return this.defaultInputMode;
    }

    public final String component2() {
        return this.hint;
    }

    public final String component3() {
        return this.speakHint;
    }

    public final int component4() {
        return this.indicateActionEntrance;
    }

    public final Map<String, String> component5() {
        return this.actionEntranceConfig;
    }

    public final boolean component6() {
        return this.showPlusMenu;
    }

    public final List<Map<String, String>> component7() {
        return this.plusActions;
    }

    public final boolean component8() {
        return this.enableActionBar;
    }

    public final boolean component9() {
        return this.useAlphaStyle;
    }

    public final AIChatInputConfig copy(int r12, String r13, String r14, int r15, Map<String, String> r16, boolean r17, List<? extends Map<String, String>> r18, boolean r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r18, "plusActions");
        return new AIChatInputConfig(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof AIChatInputConfig) == false) goto L24;
        AIChatInputConfig r11 = (AIChatInputConfig) r10;
        if (this.defaultInputMode == r11.defaultInputMode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hint, r11.hint) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.speakHint, r11.speakHint) == true) goto L12;
        return false;
    L12:
        if (this.indicateActionEntrance == r11.indicateActionEntrance) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.actionEntranceConfig, r11.actionEntranceConfig) == true) goto L16;
        return false;
    L16:
        if (this.showPlusMenu == r11.showPlusMenu) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.plusActions, r11.plusActions) == true) goto L20;
        return false;
    L20:
        if (this.enableActionBar == r11.enableActionBar) goto L22;
        return false;
    L22:
        if (this.useAlphaStyle == r11.useAlphaStyle) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int r0 = this.defaultInputMode * 31;
        String r1 = this.hint;
        int r10 = 0;
        if (r1 == null) goto L5;
        int r11 = r1.hashCode();
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.speakHint;
        if (r13 == null) goto L9;
        int r14 = r13.hashCode();
    L10:
        int r15 = (((r12 + r14) * 31) + this.indicateActionEntrance) * 31;
        Map<String, String> r16 = this.actionEntranceConfig;
        if (r16 == null) goto L13;
        int r17 = r16.hashCode();
    L14:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.showPlusMenu;
        ?? r20 = 1;
        ?? r21 = r19;
        if (r19 == false) goto L17;
        r21 = 1;
    L17:
        int r22 = (r18 + r21) * 31;
        List<Map<String, String>> r23 = this.plusActions;
        if (r23 == null) goto L20;
        r10 = r23.hashCode();
    L20:
        int r24 = (r22 + r10) * 31;
        boolean r25 = this.enableActionBar;
        ?? r26 = r25;
        if (r25 == false) goto L23;
        r26 = 1;
    L23:
        int r27 = (r24 + r26) * 31;
        boolean r28 = this.useAlphaStyle;
        if (r28 == true) goto L28;
        r20 = r28;
    L28:
        return r27 + r20;
    L13:
        r17 = 0;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }

    public String toString() {
        return "AIChatInputConfig(defaultInputMode=" + this.defaultInputMode + ", hint=" + this.hint + ", speakHint=" + this.speakHint + ", indicateActionEntrance=" + this.indicateActionEntrance + ", actionEntranceConfig=" + this.actionEntranceConfig + ", showPlusMenu=" + this.showPlusMenu + ", plusActions=" + this.plusActions + ", enableActionBar=" + this.enableActionBar + ", useAlphaStyle=" + this.useAlphaStyle + ")";
    }

    public final Map<String, String> getActionEntranceConfig() {
        return this.actionEntranceConfig;
    }

    public final int getDefaultInputMode() {
        return this.defaultInputMode;
    }

    public final boolean getEnableActionBar() {
        return this.enableActionBar;
    }

    public final String getHint() {
        return this.hint;
    }

    public final int getIndicateActionEntrance() {
        return this.indicateActionEntrance;
    }

    public final List<Map<String, String>> getPlusActions() {
        return this.plusActions;
    }

    public final boolean getShowPlusMenu() {
        return this.showPlusMenu;
    }

    public final String getSpeakHint() {
        return this.speakHint;
    }

    public final boolean getUseAlphaStyle() {
        return this.useAlphaStyle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AIChatInputConfig(int r10, String r11, String r12, int r13, Map<String, String> r14, boolean r15, List<? extends Map<String, String>> r16, boolean r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r16, "plusActions");
        this.defaultInputMode = r10;
        this.hint = r11;
        this.speakHint = r12;
        this.indicateActionEntrance = r13;
        this.actionEntranceConfig = r14;
        this.showPlusMenu = r15;
        this.plusActions = r16;
        this.enableActionBar = r17;
        this.useAlphaStyle = r18;
    }

    public /* synthetic */ AIChatInputConfig(int r11, String r12, String r13, int r14, Map r15, boolean r16, List r17, boolean r18, boolean r19, int r20, DefaultConstructorMarker r21) {
        boolean r10 = false;
        if ((r20 & 1) == 0) goto L5;
        int r1 = 0;
    L6:
        Map r22 = null;
        if ((r20 & 2) == 0) goto L9;
        String r23 = null;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r24 = null;
    L15:
        if ((r20 & 8) == 0) goto L17;
        int r25 = 0;
    L19:
        if ((r20 & 16) != 0) goto L23;
        r22 = r15;
    L23:
        if ((r20 & 32) == 0) goto L25;
        boolean r26 = false;
    L27:
        if ((r20 & 64) == 0) goto L29;
        List r27 = CollectionsKt.emptyList();
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r28 = false;
    L35:
        if ((r20 & 256) != 0) goto L38;
        r10 = r19;
    L38:
        this(r1, r23, r24, r25, r22, r26, r27, r28, r10);
        return;
    L33:
        r28 = r18;
        goto L35
    L29:
        r27 = r17;
        goto L31
    L25:
        r26 = r16;
        goto L27
    L17:
        r25 = r14;
        goto L19
    L13:
        r24 = r13;
        goto L15
    L9:
        r23 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L6
    }
}
