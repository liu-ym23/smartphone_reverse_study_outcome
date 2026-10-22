package com.larus.dorag.widget.model;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u00105\u001a\u00020\u0005J\u0013\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u000108H\u0096\u0002J\b\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020\u0003H\u0016J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\tHÆ\u0003J\t\u0010@\u001a\u00020\tHÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\u000fHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u000fHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u000fHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003Jå\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u0003HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010 R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010 R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u0010\u0017\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001f¨\u0006R"}, d2 = {"Lcom/larus/dorag/widget/model/DoraWidgetEntryContent;", "Ljava/io/Serializable;", "deviceName", "", "isConnected", "", "isGlassCharging", "isBoxCharging", "glassBattery", "", "boxBattery", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "serialNumber", "productId", "date", "", "latestDiaryId", "latestDiaryDate", "latestDiaryCreateTime", "latestDiaryTitle", "latestDiaryContent", "latestDiaryEmotion", "latestDiaryEmotionUrl", "lastDiaryFetchTime", "betaDate", "betaTitle", "betaText", "betaImageUrl", "<init>", "(Ljava/lang/String;ZZZIILjava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceName", "()Ljava/lang/String;", "()Z", "getGlassBattery", "()I", "getBoxBattery", "getModel", "getSerialNumber", "getProductId", "getDate", "()J", "getLatestDiaryId", "getLatestDiaryDate", "getLatestDiaryCreateTime", "getLatestDiaryTitle", "getLatestDiaryContent", "getLatestDiaryEmotion", "getLatestDiaryEmotionUrl", "getLastDiaryFetchTime", "getBetaDate", "getBetaTitle", "getBetaText", "getBetaImageUrl", "hasBetaWidgetCard", "equals", "other", "", "hashCode", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "dorag_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWidgetEntryContent implements Serializable {
    private final String betaDate;
    private final String betaImageUrl;
    private final String betaText;
    private final String betaTitle;
    private final int boxBattery;
    private final long date;
    private final String deviceName;
    private final int glassBattery;
    private final boolean isBoxCharging;
    private final boolean isConnected;
    private final boolean isGlassCharging;
    private final long lastDiaryFetchTime;
    private final String latestDiaryContent;
    private final long latestDiaryCreateTime;
    private final String latestDiaryDate;
    private final String latestDiaryEmotion;
    private final String latestDiaryEmotionUrl;
    private final String latestDiaryId;
    private final String latestDiaryTitle;
    private final String model;
    private final int productId;
    private final String serialNumber;

    public DoraWidgetEntryContent() {
        this(null, false, false, false, 0, 0, null, null, 0, 0, null, null, 0, null, null, null, null, 0, null, null, null, null, 4194303, null);
    }

    public static /* synthetic */ DoraWidgetEntryContent copy$default(DoraWidgetEntryContent r17, String r18, boolean r110, boolean r20, boolean r21, int r22, int r23, String r24, String r25, int r26, long r27, String r210, String r30, long r31, String r33, String r34, String r35, String r36, long r37, String r310, String r40, String r41, String r42, int r43, Object r44) {
        if ((r43 & 1) == 0) goto L5;
        String r2 = r17.deviceName;
    L7:
        if ((r43 & 2) == 0) goto L9;
        boolean r3 = r17.isConnected;
    L11:
        if ((r43 & 4) == 0) goto L13;
        boolean r4 = r17.isGlassCharging;
    L15:
        if ((r43 & 8) == 0) goto L17;
        boolean r5 = r17.isBoxCharging;
    L19:
        if ((r43 & 16) == 0) goto L21;
        int r6 = r17.glassBattery;
    L23:
        if ((r43 & 32) == 0) goto L25;
        int r7 = r17.boxBattery;
    L27:
        if ((r43 & 64) == 0) goto L29;
        String r8 = r17.model;
    L31:
        if ((r43 & 128) == 0) goto L33;
        String r9 = r17.serialNumber;
    L35:
        if ((r43 & 256) == 0) goto L37;
        int r10 = r17.productId;
    L39:
        if ((r43 & 512) == 0) goto L41;
        long r11 = r17.date;
    L43:
        if ((r43 & 1024) == 0) goto L45;
        String r13 = r17.latestDiaryId;
    L47:
        if ((r43 & 2048) == 0) goto L49;
        String r14 = r17.latestDiaryDate;
    L50:
        String r32 = r14;
        if ((r43 & 4096) == 0) goto L53;
        long r15 = r17.latestDiaryCreateTime;
    L54:
        long r38 = r15;
        if ((r43 & 8192) == 0) goto L57;
        String r16 = r17.latestDiaryTitle;
    L59:
        if ((r43 & 16384) == 0) goto L61;
        String r111 = r17.latestDiaryContent;
    L62:
        String r311 = r111;
        if ((r43 & 32768) == 0) goto L65;
        String r112 = r17.latestDiaryEmotion;
    L66:
        String r312 = r112;
        if ((r43 & 65536) == 0) goto L69;
        String r113 = r17.latestDiaryEmotionUrl;
    L70:
        String r313 = r16;
        String r314 = r113;
        if ((r43 & 131072) == 0) goto L73;
        long r114 = r17.lastDiaryFetchTime;
    L74:
        long r315 = r114;
        if ((r43 & 262144) == 0) goto L77;
        String r115 = r17.betaDate;
    L79:
        if ((524288 & r43) == 0) goto L81;
        String r116 = r17.betaTitle;
    L82:
        String r45 = r116;
        if ((r43 & 1048576) == 0) goto L85;
        String r117 = r17.betaText;
    L87:
        if ((r43 & 2097152) == 0) goto L89;
        String r1 = r17.betaImageUrl;
    L91:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r32, r38, r313, r311, r312, r314, r315, r115, r45, r117, r1);
    L89:
        r1 = r42;
        goto L91
    L85:
        r117 = r41;
        goto L87
    L81:
        r116 = r40;
        goto L82
    L77:
        r115 = r310;
        goto L79
    L73:
        r114 = r37;
        goto L74
    L69:
        r113 = r36;
        goto L70
    L65:
        r112 = r35;
        goto L66
    L61:
        r111 = r34;
        goto L62
    L57:
        r16 = r33;
        goto L59
    L53:
        r15 = r31;
        goto L54
    L49:
        r14 = r30;
        goto L50
    L45:
        r13 = r210;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r110;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.deviceName;
    }

    public final long component10() {
        return this.date;
    }

    public final String component11() {
        return this.latestDiaryId;
    }

    public final String component12() {
        return this.latestDiaryDate;
    }

    public final long component13() {
        return this.latestDiaryCreateTime;
    }

    public final String component14() {
        return this.latestDiaryTitle;
    }

    public final String component15() {
        return this.latestDiaryContent;
    }

    public final String component16() {
        return this.latestDiaryEmotion;
    }

    public final String component17() {
        return this.latestDiaryEmotionUrl;
    }

    public final long component18() {
        return this.lastDiaryFetchTime;
    }

    public final String component19() {
        return this.betaDate;
    }

    public final boolean component2() {
        return this.isConnected;
    }

    public final String component20() {
        return this.betaTitle;
    }

    public final String component21() {
        return this.betaText;
    }

    public final String component22() {
        return this.betaImageUrl;
    }

    public final boolean component3() {
        return this.isGlassCharging;
    }

    public final boolean component4() {
        return this.isBoxCharging;
    }

    public final int component5() {
        return this.glassBattery;
    }

    public final int component6() {
        return this.boxBattery;
    }

    public final String component7() {
        return this.model;
    }

    public final String component8() {
        return this.serialNumber;
    }

    public final int component9() {
        return this.productId;
    }

    public final DoraWidgetEntryContent copy(String r210, boolean r30, boolean r31, boolean r32, int r33, int r34, String r35, String r36, int r37, long r38, String r40, String r41, long r42, String r44, String r45, String r46, String r47, long r48, String r50, String r51, String r52, String r53) {
        Intrinsics.checkNotNullParameter(r210, "deviceName");
        Intrinsics.checkNotNullParameter(r35, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r36, "serialNumber");
        Intrinsics.checkNotNullParameter(r40, "latestDiaryId");
        Intrinsics.checkNotNullParameter(r41, "latestDiaryDate");
        Intrinsics.checkNotNullParameter(r44, "latestDiaryTitle");
        Intrinsics.checkNotNullParameter(r45, "latestDiaryContent");
        Intrinsics.checkNotNullParameter(r46, "latestDiaryEmotion");
        Intrinsics.checkNotNullParameter(r47, "latestDiaryEmotionUrl");
        Intrinsics.checkNotNullParameter(r50, "betaDate");
        Intrinsics.checkNotNullParameter(r51, "betaTitle");
        Intrinsics.checkNotNullParameter(r52, "betaText");
        Intrinsics.checkNotNullParameter(r53, "betaImageUrl");
        return new DoraWidgetEntryContent(r210, r30, r31, r32, r33, r34, r35, r36, r37, r38, r40, r41, r42, r44, r45, r46, r47, r48, r50, r51, r52, r53);
    }

    public final boolean hasBetaWidgetCard() {
        if (this.betaTitle.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (this.betaText.length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.deviceName, Boolean.valueOf(this.isConnected), Boolean.valueOf(this.isGlassCharging), Boolean.valueOf(this.isBoxCharging), Integer.valueOf(this.glassBattery), Integer.valueOf(this.boxBattery), this.model, this.serialNumber, Integer.valueOf(this.productId), this.latestDiaryId, this.latestDiaryDate, Long.valueOf(this.latestDiaryCreateTime), this.latestDiaryTitle, this.latestDiaryContent, this.latestDiaryEmotion, this.latestDiaryEmotionUrl, Long.valueOf(this.lastDiaryFetchTime), this.betaDate, this.betaTitle, this.betaText, this.betaImageUrl});
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("deviceName: ");
        r0.append(this.deviceName);
        r0.append(", isConnected: ");
        r0.append(this.isConnected);
        r0.append(", isGlassCharging: ");
        r0.append(this.isGlassCharging);
        r0.append(", isBoxCharging: ");
        r0.append(this.isBoxCharging);
        r0.append(", glassBattery: ");
        r0.append(this.glassBattery);
        r0.append(", boxBattery: ");
        r0.append(this.boxBattery);
        r0.append(", model: ");
        r0.append(this.model);
        r0.append(", productId: ");
        r0.append(this.productId);
        r0.append(", date: ");
        r0.append(this.date);
        r0.append(", betaDate: ");
        r0.append(this.betaDate);
        r0.append(", betaTitle: ");
        r0.append(this.betaTitle);
        r0.append(", hasBetaImage: ");
        if (this.betaImageUrl.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        return r0.toString();
    L5:
        r1 = false;
        goto L6
    }

    public final String getBetaDate() {
        return this.betaDate;
    }

    public final String getBetaImageUrl() {
        return this.betaImageUrl;
    }

    public final String getBetaText() {
        return this.betaText;
    }

    public final String getBetaTitle() {
        return this.betaTitle;
    }

    public final int getBoxBattery() {
        return this.boxBattery;
    }

    public final long getDate() {
        return this.date;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final int getGlassBattery() {
        return this.glassBattery;
    }

    public final long getLastDiaryFetchTime() {
        return this.lastDiaryFetchTime;
    }

    public final String getLatestDiaryContent() {
        return this.latestDiaryContent;
    }

    public final long getLatestDiaryCreateTime() {
        return this.latestDiaryCreateTime;
    }

    public final String getLatestDiaryDate() {
        return this.latestDiaryDate;
    }

    public final String getLatestDiaryEmotion() {
        return this.latestDiaryEmotion;
    }

    public final String getLatestDiaryEmotionUrl() {
        return this.latestDiaryEmotionUrl;
    }

    public final String getLatestDiaryId() {
        return this.latestDiaryId;
    }

    public final String getLatestDiaryTitle() {
        return this.latestDiaryTitle;
    }

    public final String getModel() {
        return this.model;
    }

    public final int getProductId() {
        return this.productId;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final boolean isBoxCharging() {
        return this.isBoxCharging;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isGlassCharging() {
        return this.isGlassCharging;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DoraWidgetEntryContent) == false) goto L8;
        DoraWidgetEntryContent r1 = (DoraWidgetEntryContent) r8;
    L10:
        if (r1 != null) goto L12;
        return false;
    L12:
        DoraWidgetEntryContent r9 = (DoraWidgetEntryContent) r8;
        if (Intrinsics.areEqual(this.deviceName, r9.deviceName) == true) goto L15;
    L55:
        return false;
    L15:
        if (this.isConnected != r9.isConnected) goto L55;
        if (this.isGlassCharging != r9.isGlassCharging) goto L55;
        if (this.isBoxCharging != r9.isBoxCharging) goto L55;
        if (this.glassBattery != r9.glassBattery) goto L55;
        if (this.boxBattery != r9.boxBattery) goto L55;
        if (Intrinsics.areEqual(this.model, r9.model) == false) goto L55;
        if (Intrinsics.areEqual(this.serialNumber, r9.serialNumber) == false) goto L55;
        if (this.productId != r9.productId) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryId, r9.latestDiaryId) == false) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryDate, r9.latestDiaryDate) == false) goto L55;
        if (this.latestDiaryCreateTime != r9.latestDiaryCreateTime) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryTitle, r9.latestDiaryTitle) == false) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryContent, r9.latestDiaryContent) == false) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryEmotion, r9.latestDiaryEmotion) == false) goto L55;
        if (Intrinsics.areEqual(this.latestDiaryEmotionUrl, r9.latestDiaryEmotionUrl) == false) goto L55;
        if (this.lastDiaryFetchTime != r9.lastDiaryFetchTime) goto L55;
        if (Intrinsics.areEqual(this.betaDate, r9.betaDate) == false) goto L55;
        if (Intrinsics.areEqual(this.betaTitle, r9.betaTitle) == false) goto L55;
        if (Intrinsics.areEqual(this.betaText, r9.betaText) == false) goto L55;
        if (Intrinsics.areEqual(this.betaImageUrl, r9.betaImageUrl) == false) goto L55;
        return true;
    L8:
        r1 = null;
        goto L10
    }

    public DoraWidgetEntryContent(String r16, boolean r17, boolean r18, boolean r110, int r20, int r21, String r22, String r23, int r24, long r25, String r27, String r28, long r210, String r31, String r32, String r33, String r34, long r35, String r37, String r38, String r310, String r40) {
        Intrinsics.checkNotNullParameter(r16, "deviceName");
        Intrinsics.checkNotNullParameter(r22, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r23, "serialNumber");
        Intrinsics.checkNotNullParameter(r27, "latestDiaryId");
        Intrinsics.checkNotNullParameter(r28, "latestDiaryDate");
        Intrinsics.checkNotNullParameter(r31, "latestDiaryTitle");
        Intrinsics.checkNotNullParameter(r32, "latestDiaryContent");
        Intrinsics.checkNotNullParameter(r33, "latestDiaryEmotion");
        Intrinsics.checkNotNullParameter(r34, "latestDiaryEmotionUrl");
        Intrinsics.checkNotNullParameter(r37, "betaDate");
        Intrinsics.checkNotNullParameter(r38, "betaTitle");
        Intrinsics.checkNotNullParameter(r310, "betaText");
        Intrinsics.checkNotNullParameter(r40, "betaImageUrl");
        this.deviceName = r16;
        this.isConnected = r17;
        this.isGlassCharging = r18;
        this.isBoxCharging = r110;
        this.glassBattery = r20;
        this.boxBattery = r21;
        this.model = r22;
        this.serialNumber = r23;
        this.productId = r24;
        this.date = r25;
        this.latestDiaryId = r27;
        this.latestDiaryDate = r28;
        this.latestDiaryCreateTime = r210;
        this.latestDiaryTitle = r31;
        this.latestDiaryContent = r32;
        this.latestDiaryEmotion = r33;
        this.latestDiaryEmotionUrl = r34;
        this.lastDiaryFetchTime = r35;
        this.betaDate = r37;
        this.betaTitle = r38;
        this.betaText = r310;
        this.betaImageUrl = r40;
    }

    public /* synthetic */ DoraWidgetEntryContent(String r27, boolean r28, boolean r210, boolean r30, int r31, int r32, String r33, String r34, int r35, long r36, String r38, String r310, long r40, String r42, String r43, String r44, String r45, long r46, String r48, String r410, String r50, String r51, int r52, DefaultConstructorMarker r53) {
        if ((r52 & 1) == 0) goto L5;
        String r1 = "";
    L6:
        boolean r4 = false;
        if ((r52 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r52 & 4) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r52 & 8) != 0) goto L18;
        r4 = r30;
    L18:
        int r7 = -1;
        if ((r52 & 16) == 0) goto L21;
        int r6 = -1;
    L23:
        if ((r52 & 32) != 0) goto L27;
        r7 = r32;
    L27:
        if ((r52 & 64) == 0) goto L29;
        String r8 = "";
    L31:
        if ((r52 & 128) == 0) goto L33;
        String r9 = "";
    L35:
        if ((r52 & 256) == 0) goto L37;
        int r10 = 16;
    L39:
        if ((r52 & 512) == 0) goto L41;
        long r11 = -1;
    L43:
        if ((r52 & 1024) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r52 & 2048) == 0) goto L49;
        String r14 = "";
    L50:
        long r16 = 0;
        if ((r52 & 4096) == 0) goto L53;
        long r18 = 0;
    L55:
        if ((r52 & 8192) == 0) goto L57;
        String r15 = "";
    L59:
        if ((r52 & 16384) == 0) goto L61;
        String r2 = "";
    L63:
        if ((r52 & 32768) == 0) goto L65;
        String r20 = "";
    L67:
        if ((r52 & 65536) == 0) goto L69;
        String r21 = "";
    L71:
        if ((r52 & 131072) != 0) goto L75;
        r16 = r46;
    L75:
        if ((r52 & 262144) == 0) goto L77;
        String r22 = "";
    L79:
        if ((r52 & 524288) == 0) goto L81;
        String r23 = "";
    L83:
        if ((r52 & 1048576) == 0) goto L85;
        String r24 = "";
    L87:
        if ((r52 & 2097152) == 0) goto L89;
        String r0 = "";
    L90:
        this(r1, r3, r5, r4, r6, r7, r8, r9, r10, r11, r13, r14, r18, r15, r2, r20, r21, r16, r22, r23, r24, r0);
        return;
    L89:
        r0 = r51;
        goto L90
    L85:
        r24 = r50;
        goto L87
    L81:
        r23 = r410;
        goto L83
    L77:
        r22 = r48;
        goto L79
    L69:
        r21 = r45;
        goto L71
    L65:
        r20 = r44;
        goto L67
    L61:
        r2 = r43;
        goto L63
    L57:
        r15 = r42;
        goto L59
    L53:
        r18 = r40;
        goto L55
    L49:
        r14 = r310;
        goto L50
    L45:
        r13 = r38;
        goto L47
    L41:
        r11 = r36;
        goto L43
    L37:
        r10 = r35;
        goto L39
    L33:
        r9 = r34;
        goto L35
    L29:
        r8 = r33;
        goto L31
    L21:
        r6 = r31;
        goto L23
    L13:
        r5 = r210;
        goto L15
    L9:
        r3 = r28;
        goto L11
    L5:
        r1 = r27;
        goto L6
    }
}
