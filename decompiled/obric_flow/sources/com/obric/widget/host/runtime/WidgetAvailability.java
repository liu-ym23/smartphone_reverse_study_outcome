package com.obric.widget.host.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\u0085\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\nHÆ\u0001J\u0013\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001a¨\u00061"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetAvailability;", "", "appletId", "", "widgetId", "scene", "ready", "", "installState", "resolvedVersion", "", "preloadToken", "errorCode", "errorMessage", "retryable", "checkedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)V", "getAppletId", "()Ljava/lang/String;", "getWidgetId", "getScene", "getReady", "()Z", "getInstallState", "getResolvedVersion", "()J", "getPreloadToken", "getErrorCode", "getErrorMessage", "getRetryable", "getCheckedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetAvailability {
    private final String appletId;
    private final long checkedAt;
    private final String errorCode;
    private final String errorMessage;
    private final String installState;
    private final String preloadToken;
    private final boolean ready;
    private final long resolvedVersion;
    private final boolean retryable;
    private final String scene;
    private final String widgetId;

    public WidgetAvailability(String r5, String r10, String r11, boolean r12, String r13, long r14, String r15, String r16, String r17, boolean r18, long r19) {
        this.appletId = r5;
        this.widgetId = r10;
        this.scene = r11;
        this.ready = r12;
        this.installState = r13;
        this.resolvedVersion = r14;
        this.preloadToken = r15;
        this.errorCode = r16;
        this.errorMessage = r17;
        this.retryable = r18;
        this.checkedAt = r19;
    }

    public static /* synthetic */ WidgetAvailability copy$default(WidgetAvailability r15, String r16, String r17, String r18, boolean r19, String r20, long r21, String r23, String r24, String r25, boolean r26, long r27, int r29, Object r30) {
        if ((r29 & 1) == 0) goto L5;
        String r5 = r15.appletId;
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r10 = r15.widgetId;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r11 = r15.scene;
    L15:
        if ((r29 & 8) == 0) goto L17;
        boolean r12 = r15.ready;
    L19:
        if ((r29 & 16) == 0) goto L21;
        String r13 = r15.installState;
    L23:
        if ((r29 & 32) == 0) goto L25;
        long r14 = r15.resolvedVersion;
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r22 = r15.preloadToken;
    L31:
        if ((r29 & 128) == 0) goto L33;
        String r110 = r15.errorCode;
    L35:
        if ((r29 & 256) == 0) goto L37;
        String r111 = r15.errorMessage;
    L39:
        if ((r29 & 512) == 0) goto L41;
        boolean r112 = r15.retryable;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        long r113 = r15.checkedAt;
    L47:
        return r15.copy(r5, r10, r11, r12, r13, r14, r22, r110, r111, r112, r113);
    L45:
        r113 = r27;
        goto L47
    L41:
        r112 = r26;
        goto L43
    L37:
        r111 = r25;
        goto L39
    L33:
        r110 = r24;
        goto L35
    L29:
        r22 = r23;
        goto L31
    L25:
        r14 = r21;
        goto L27
    L21:
        r13 = r20;
        goto L23
    L17:
        r12 = r19;
        goto L19
    L13:
        r11 = r18;
        goto L15
    L9:
        r10 = r17;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }

    public final String component1() {
        return this.appletId;
    }

    public final boolean component10() {
        return this.retryable;
    }

    public final long component11() {
        return this.checkedAt;
    }

    public final String component2() {
        return this.widgetId;
    }

    public final String component3() {
        return this.scene;
    }

    public final boolean component4() {
        return this.ready;
    }

    public final String component5() {
        return this.installState;
    }

    public final long component6() {
        return this.resolvedVersion;
    }

    public final String component7() {
        return this.preloadToken;
    }

    public final String component8() {
        return this.errorCode;
    }

    public final String component9() {
        return this.errorMessage;
    }

    public final WidgetAvailability copy(String r16, String r17, String r18, boolean r19, String r20, long r21, String r23, String r24, String r25, boolean r26, long r27) {
        return new WidgetAvailability(r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetAvailability) == true) goto L8;
        return false;
    L8:
        WidgetAvailability r11 = (WidgetAvailability) r10;
        if (Intrinsics.areEqual(this.appletId, r11.appletId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.scene, r11.scene) == true) goto L18;
        return false;
    L18:
        if (this.ready == r11.ready) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.installState, r11.installState) == true) goto L24;
        return false;
    L24:
        if (this.resolvedVersion == r11.resolvedVersion) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.preloadToken, r11.preloadToken) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.errorCode, r11.errorCode) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.errorMessage, r11.errorMessage) == true) goto L36;
        return false;
    L36:
        if (this.retryable == r11.retryable) goto L39;
        return false;
    L39:
        if (this.checkedAt == r11.checkedAt) goto L41;
        return false;
    L41:
        return true;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final long getCheckedAt() {
        return this.checkedAt;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getInstallState() {
        return this.installState;
    }

    public final String getPreloadToken() {
        return this.preloadToken;
    }

    public final boolean getReady() {
        return this.ready;
    }

    public final long getResolvedVersion() {
        return this.resolvedVersion;
    }

    public final boolean getRetryable() {
        return this.retryable;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public int hashCode() {
        String r5 = this.appletId;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.widgetId;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.scene;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = androidx.room.jarjarred.org.antlr.runtime.a.d((r15 + r17) * 31, 31, this.ready);
        String r19 = this.installState;
        if (r19 != null) goto L17;
        int r20 = 0;
    L18:
        int r21 = androidx.room.jarjarred.org.antlr.runtime.a.e((r18 + r20) * 31, this.resolvedVersion, 31);
        String r22 = this.preloadToken;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        String r25 = this.errorCode;
        if (r25 != null) goto L25;
        int r26 = 0;
    L26:
        int r27 = (r24 + r26) * 31;
        String r28 = this.errorMessage;
        if (r28 == null) goto L31;
        r10 = r28.hashCode();
    L31:
        return Long.hashCode(this.checkedAt) + androidx.room.jarjarred.org.antlr.runtime.a.d((r27 + r10) * 31, 31, this.retryable);
    L25:
        r26 = r25.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r20 = r19.hashCode();
        goto L18
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public String toString() {
        String r5 = this.appletId;
        String r10 = this.widgetId;
        String r11 = this.scene;
        boolean r12 = this.ready;
        String r13 = this.installState;
        long r14 = this.resolvedVersion;
        String r15 = this.preloadToken;
        String r16 = this.errorCode;
        String r17 = this.errorMessage;
        boolean r18 = this.retryable;
        long r19 = this.checkedAt;
        StringBuilder r110 = androidx.constraintlayout.motion.widget.a.y("WidgetAvailability(appletId=", r5, ", widgetId=", r10, ", scene=");
        r110.append(r11);
        r110.append(", ready=");
        r110.append(r12);
        r110.append(", installState=");
        r110.append(r13);
        r110.append(", resolvedVersion=");
        r110.append(r14);
        androidx.constraintlayout.motion.widget.a.C(r110, ", preloadToken=", r15, ", errorCode=", r16);
        r110.append(", errorMessage=");
        r110.append(r17);
        r110.append(", retryable=");
        r110.append(r18);
        r110.append(", checkedAt=");
        r110.append(r19);
        r110.append(")");
        return r110.toString();
    }

    public /* synthetic */ WidgetAvailability(String r17, String r18, String r19, boolean r20, String r21, long r22, String r24, String r25, String r26, boolean r27, long r28, int r30, DefaultConstructorMarker r31) {
        if ((r30 & 1) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r11 = null;
    L14:
        this(r5, r10, r11, r20, r21, r22, r24, r25, r26, r27, r28);
        return;
    L13:
        r11 = r19;
        goto L14
    L9:
        r10 = r18;
        goto L11
    L5:
        r5 = r17;
        goto L7
    }
}
