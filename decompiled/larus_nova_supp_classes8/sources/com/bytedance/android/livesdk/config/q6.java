package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/config/q6;", "", "", "enable", "Z", "getEnable", "()Z", "fullLog", "getFullLog", "", "Lcom/bytedance/android/livesdk/config/bb1;", "filters", "Ljava/util/List;", "getFilters", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/config/p01;", "legalMessage", "getLegalMessage", "Lcom/bytedance/android/livesdk/config/ii1;", "uiStyle", "Lcom/bytedance/android/livesdk/config/ii1;", "getUiStyle", "()Lcom/bytedance/android/livesdk/config/ii1;", "debugFront", "getDebugFront", "debugMessageWindow", "getDebugMessageWindow", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q6 {
    public final boolean a;

    @SerializedName("debug_front")
    private final boolean debugFront;

    @SerializedName("debug_message_window")
    private final boolean debugMessageWindow;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("filters")
    private final List<bb1> filters;

    @SerializedName("full_log")
    private final boolean fullLog;

    @SerializedName("legal_message")
    private final List<p01> legalMessage;

    @SerializedName("ui_style")
    private final ii1 uiStyle;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof q6) == false) goto L22;
        q6 r4 = (q6) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (this.fullLog == r4.fullLog) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.filters, r4.filters) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.legalMessage, r4.legalMessage) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.uiStyle, r4.uiStyle) == true) goto L16;
        return false;
    L16:
        if (this.debugFront == r4.debugFront) goto L18;
        return false;
    L18:
        if (this.debugMessageWindow == r4.debugMessageWindow) goto L20;
        return false;
    L20:
        if (this.a == r4.a) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.fullLog;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (r3 + r5) * 31;
        List<bb1> r7 = this.filters;
        int r8 = 0;
        if (r7 == null) goto L11;
        int r9 = r7.hashCode();
    L12:
        int r10 = (r6 + r9) * 31;
        List<p01> r11 = this.legalMessage;
        if (r11 == null) goto L15;
        int r12 = r11.hashCode();
    L16:
        int r13 = (r10 + r12) * 31;
        ii1 r14 = this.uiStyle;
        if (r14 == null) goto L19;
        r8 = r14.hashCode();
    L19:
        int r15 = (r13 + r8) * 31;
        boolean r16 = this.debugFront;
        ?? r17 = r16;
        if (r16 == false) goto L22;
        r17 = 1;
    L22:
        int r18 = (r15 + r17) * 31;
        boolean r19 = this.debugMessageWindow;
        ?? r20 = r19;
        if (r19 == false) goto L25;
        r20 = 1;
    L25:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.a;
        if (r22 == true) goto L30;
        r1 = r22;
    L30:
        return r21 + r1;
    L15:
        r12 = 0;
        goto L16
    L11:
        r9 = 0;
        goto L12
    }

    public final String toString() {
        return "GameNewFloatWindowConfig(enable=" + this.enable + ", fullLog=" + this.fullLog + ", filters=" + this.filters + ", legalMessage=" + this.legalMessage + ", uiStyle=" + this.uiStyle + ", debugFront=" + this.debugFront + ", debugMessageWindow=" + this.debugMessageWindow + ", messageDebug=" + this.a + ")";
    }

    public q6() {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ii1 r2 = new ii1(null);
        Intrinsics.checkNotNullParameter(r0, "filters");
        Intrinsics.checkNotNullParameter(r1, "legalMessage");
        Intrinsics.checkNotNullParameter(r2, "uiStyle");
        this.enable = false;
        this.fullLog = false;
        this.filters = r0;
        this.legalMessage = r1;
        this.uiStyle = r2;
        this.debugFront = false;
        this.debugMessageWindow = false;
        this.a = false;
    }
}
