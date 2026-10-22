package com.obric.memorydata.memory.ui.automemory.memorylist;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0006HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0012HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\u0012HÆ\u0003J©\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0012HÆ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0012HÖ\u0001J\t\u0010E\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001e\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010 R\u001e\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010 R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0016\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010 R\u0016\u0010\u0014\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*¨\u0006F"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/memorylist/UserOperationEntity;", "", OaidModel.KEY_ID, "", "timestamp", "triggerType", "", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "screenshotPath", "imageTosKey", "location", "locationState", "movementState", "clickDetail", "scrollDetail", WsConstants.KEY_EXTRA, "state", "", TypedValues.AttributesType.S_TARGET, "retryTime", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getId", "()J", "getTimestamp", "getTriggerType", "()Ljava/lang/String;", "getAppName", "getPackageName", "getScreenshotPath", "setScreenshotPath", "(Ljava/lang/String;)V", "getImageTosKey", "setImageTosKey", "getLocation", "getLocationState", "getMovementState", "getClickDetail", "getScrollDetail", "getExtra", "getState", "()I", "setState", "(I)V", "getTarget", "setTarget", "getRetryTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserOperationEntity {

    @SerializedName(Api.KEY_APP_NAME)
    private final String appName;

    @SerializedName("click_detail")
    private final String clickDetail;

    @SerializedName(WsConstants.KEY_EXTRA)
    private final String extra;
    private final long id;

    @SerializedName("image_tos_key")
    private String imageTosKey;

    @SerializedName("location")
    private final String location;

    @SerializedName("location_state")
    private final String locationState;

    @SerializedName("movement_state")
    private final String movementState;

    @SerializedName("package_name")
    private final String packageName;

    @SerializedName("retry_time")
    private final int retryTime;

    @SerializedName("screenshot_path")
    private String screenshotPath;

    @SerializedName("scroll_detail")
    private final String scrollDetail;

    @SerializedName("state")
    private int state;

    @SerializedName(TypedValues.AttributesType.S_TARGET)
    private String target;
    private final long timestamp;

    @SerializedName("trigger_type")
    private final String triggerType;

    public UserOperationEntity(long r16, long r18, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, int r31, String r32, int r33) {
        Intrinsics.checkNotNullParameter(r20, "triggerType");
        Intrinsics.checkNotNullParameter(r21, "appName");
        Intrinsics.checkNotNullParameter(r22, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r23, "screenshotPath");
        Intrinsics.checkNotNullParameter(r24, "imageTosKey");
        Intrinsics.checkNotNullParameter(r25, "location");
        Intrinsics.checkNotNullParameter(r26, "locationState");
        Intrinsics.checkNotNullParameter(r27, "movementState");
        Intrinsics.checkNotNullParameter(r28, "clickDetail");
        Intrinsics.checkNotNullParameter(r29, "scrollDetail");
        Intrinsics.checkNotNullParameter(r30, WsConstants.KEY_EXTRA);
        Intrinsics.checkNotNullParameter(r32, TypedValues.AttributesType.S_TARGET);
        this.id = r16;
        this.timestamp = r18;
        this.triggerType = r20;
        this.appName = r21;
        this.packageName = r22;
        this.screenshotPath = r23;
        this.imageTosKey = r24;
        this.location = r25;
        this.locationState = r26;
        this.movementState = r27;
        this.clickDetail = r28;
        this.scrollDetail = r29;
        this.extra = r30;
        this.state = r31;
        this.target = r32;
        this.retryTime = r33;
    }

    public /* synthetic */ UserOperationEntity(long r23, long r25, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, int r38, String r39, int r40, int r41, DefaultConstructorMarker r42) {
        if ((r41 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r41 & 16384) == 0) goto L9;
        String r20 = "screenObservation";
    L11:
        if ((r41 & 32768) == 0) goto L13;
        int r21 = 0;
    L14:
        this(r4, r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r20, r21);
        return;
    L13:
        r21 = r40;
        goto L14
    L9:
        r20 = r39;
        goto L11
    L5:
        r4 = r23;
        goto L7
    }

    public static /* synthetic */ UserOperationEntity copy$default(UserOperationEntity r17, long r18, long r20, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, int r33, String r34, int r35, int r36, Object r37) {
        if ((r36 & 1) == 0) goto L5;
        long r2 = r17.id;
    L7:
        if ((r36 & 2) == 0) goto L9;
        long r4 = r17.timestamp;
    L11:
        if ((r36 & 4) == 0) goto L13;
        String r6 = r17.triggerType;
    L15:
        if ((r36 & 8) == 0) goto L17;
        String r7 = r17.appName;
    L19:
        if ((r36 & 16) == 0) goto L21;
        String r8 = r17.packageName;
    L23:
        if ((r36 & 32) == 0) goto L25;
        String r9 = r17.screenshotPath;
    L27:
        if ((r36 & 64) == 0) goto L29;
        String r10 = r17.imageTosKey;
    L31:
        if ((r36 & 128) == 0) goto L33;
        String r11 = r17.location;
    L35:
        if ((r36 & 256) == 0) goto L37;
        String r12 = r17.locationState;
    L39:
        if ((r36 & 512) == 0) goto L41;
        String r13 = r17.movementState;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        String r14 = r17.clickDetail;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        String r15 = r17.scrollDetail;
    L50:
        String r38 = r15;
        if ((r36 & 4096) == 0) goto L53;
        String r16 = r17.extra;
    L54:
        String r39 = r16;
        if ((r36 & 8192) == 0) goto L57;
        int r19 = r17.state;
    L58:
        int r310 = r19;
        if ((r36 & 16384) == 0) goto L61;
        String r110 = r17.target;
    L63:
        if ((r36 & 32768) == 0) goto L65;
        int r1 = r17.retryTime;
    L67:
        return r17.copy(r2, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r38, r39, r310, r110, r1);
    L65:
        r1 = r35;
        goto L67
    L61:
        r110 = r34;
        goto L63
    L57:
        r19 = r33;
        goto L58
    L53:
        r16 = r32;
        goto L54
    L49:
        r15 = r31;
        goto L50
    L45:
        r14 = r30;
        goto L47
    L41:
        r13 = r29;
        goto L43
    L37:
        r12 = r28;
        goto L39
    L33:
        r11 = r27;
        goto L35
    L29:
        r10 = r26;
        goto L31
    L25:
        r9 = r25;
        goto L27
    L21:
        r8 = r24;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.movementState;
    }

    public final String component11() {
        return this.clickDetail;
    }

    public final String component12() {
        return this.scrollDetail;
    }

    public final String component13() {
        return this.extra;
    }

    public final int component14() {
        return this.state;
    }

    public final String component15() {
        return this.target;
    }

    public final int component16() {
        return this.retryTime;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component3() {
        return this.triggerType;
    }

    public final String component4() {
        return this.appName;
    }

    public final String component5() {
        return this.packageName;
    }

    public final String component6() {
        return this.screenshotPath;
    }

    public final String component7() {
        return this.imageTosKey;
    }

    public final String component8() {
        return this.location;
    }

    public final String component9() {
        return this.locationState;
    }

    public final UserOperationEntity copy(long r21, long r23, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, int r36, String r37, int r38) {
        Intrinsics.checkNotNullParameter(r25, "triggerType");
        Intrinsics.checkNotNullParameter(r26, "appName");
        Intrinsics.checkNotNullParameter(r27, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r28, "screenshotPath");
        Intrinsics.checkNotNullParameter(r29, "imageTosKey");
        Intrinsics.checkNotNullParameter(r30, "location");
        Intrinsics.checkNotNullParameter(r31, "locationState");
        Intrinsics.checkNotNullParameter(r32, "movementState");
        Intrinsics.checkNotNullParameter(r33, "clickDetail");
        Intrinsics.checkNotNullParameter(r34, "scrollDetail");
        Intrinsics.checkNotNullParameter(r35, WsConstants.KEY_EXTRA);
        Intrinsics.checkNotNullParameter(r37, TypedValues.AttributesType.S_TARGET);
        return new UserOperationEntity(r21, r23, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, UserOperationEntity.class) == true) goto L8;
        return false;
    L8:
        UserOperationEntity r10 = (UserOperationEntity) ZeusTransformUtils.preCheckCast(r9, UserOperationEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (this.timestamp == r10.timestamp) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.triggerType, r10.triggerType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appName, r10.appName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.screenshotPath, r10.screenshotPath) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imageTosKey, r10.imageTosKey) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.location, r10.location) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.locationState, r10.locationState) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.movementState, r10.movementState) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.clickDetail, r10.clickDetail) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.scrollDetail, r10.scrollDetail) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.extra, r10.extra) == true) goto L48;
        return false;
    L48:
        if (this.state == r10.state) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.target, r10.target) == true) goto L54;
        return false;
    L54:
        if (this.retryTime == r10.retryTime) goto L56;
        return false;
    L56:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getClickDetail() {
        return this.clickDetail;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final long getId() {
        return this.id;
    }

    public final String getImageTosKey() {
        return this.imageTosKey;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getLocationState() {
        return this.locationState;
    }

    public final String getMovementState() {
        return this.movementState;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int getRetryTime() {
        return this.retryTime;
    }

    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    public final String getScrollDetail() {
        return this.scrollDetail;
    }

    public final int getState() {
        return this.state;
    }

    public final String getTarget() {
        return this.target;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTriggerType() {
        return this.triggerType;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.timestamp)) * 31) + this.triggerType.hashCode()) * 31) + this.appName.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.screenshotPath.hashCode()) * 31) + this.imageTosKey.hashCode()) * 31) + this.location.hashCode()) * 31) + this.locationState.hashCode()) * 31) + this.movementState.hashCode()) * 31) + this.clickDetail.hashCode()) * 31) + this.scrollDetail.hashCode()) * 31) + this.extra.hashCode()) * 31) + Integer.hashCode(this.state)) * 31) + this.target.hashCode()) * 31) + Integer.hashCode(this.retryTime);
    }

    public final void setImageTosKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.imageTosKey = r2;
    }

    public final void setScreenshotPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.screenshotPath = r2;
    }

    public final void setState(int r1) {
        this.state = r1;
    }

    public final void setTarget(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.target = r2;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("UserOperationEntity(id=").append(this.id).append(", timestamp=").append(this.timestamp).append(", triggerType=").append(this.triggerType).append(", appName=").append(this.appName).append(", packageName=").append(this.packageName).append(", screenshotPath=").append(this.screenshotPath).append(", imageTosKey=").append(this.imageTosKey).append(", location=").append(this.location).append(", locationState=").append(this.locationState).append(", movementState=").append(this.movementState).append(", clickDetail=").append(this.clickDetail).append(", scrollDetail=");
        r0.append(this.scrollDetail).append(", extra=").append(this.extra).append(", state=").append(this.state).append(", target=").append(this.target).append(", retryTime=").append(this.retryTime).append(')');
        return r0.toString();
    }
}
