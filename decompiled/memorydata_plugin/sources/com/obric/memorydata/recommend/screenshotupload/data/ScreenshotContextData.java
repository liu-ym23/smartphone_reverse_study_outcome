package com.obric.memorydata.recommend.screenshotupload.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u001d\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000b\"\u0004\b'\u0010\u000fR\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000b\"\u0004\b*\u0010\u000fR\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010\u000fR\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u0010\u000fR&\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000502X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006@"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotContextData;", "", "currentTs", "", "zone", "", "<init>", "(JLjava/lang/String;)V", "getCurrentTs", "()J", "getZone", "()Ljava/lang/String;", "appName", "getAppName", "setAppName", "(Ljava/lang/String;)V", "dayType", "getDayType", "setDayType", "locationState", "getLocationState", "setLocationState", "location", "getLocation", "setLocation", "movementState", "getMovementState", "setMovementState", "longitude", "", "getLongitude", "()D", "setLongitude", "(D)V", "latitude", "getLatitude", "setLatitude", "triggerType", "getTriggerType", "setTriggerType", "touchAction", "getTouchAction", "setTouchAction", "clickDetail", "getClickDetail", "setClickDetail", "scrollDetail", "getScrollDetail", "setScrollDetail", "extraMeta", "", "getExtraMeta", "()Ljava/util/Map;", "setExtraMeta", "(Ljava/util/Map;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenshotContextData {
    private String appName;
    private String clickDetail;
    private final long currentTs;
    private String dayType;
    private Map<String, String> extraMeta;
    private double latitude;
    private String location;
    private String locationState;
    private double longitude;
    private String movementState;
    private String scrollDetail;
    private String touchAction;
    private String triggerType;
    private final String zone;

    public ScreenshotContextData(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "zone");
        this.currentTs = r2;
        this.zone = r4;
        this.appName = "";
        this.dayType = "";
        this.locationState = "";
        this.location = "";
        this.movementState = "";
        this.triggerType = "";
        this.touchAction = "";
        this.clickDetail = "";
        this.scrollDetail = "";
        this.extraMeta = MapsKt.emptyMap();
    }

    public static /* synthetic */ ScreenshotContextData copy$default(ScreenshotContextData r0, long r1, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.currentTs;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.zone;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.currentTs;
    }

    public final String component2() {
        return this.zone;
    }

    public final ScreenshotContextData copy(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, "zone");
        return new ScreenshotContextData(r1, r3);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ScreenshotContextData.class) == true) goto L8;
        return false;
    L8:
        ScreenshotContextData r10 = (ScreenshotContextData) ZeusTransformUtils.preCheckCast(r9, ScreenshotContextData.class, "com.obric.memorydata.plugin");
        if (this.currentTs == r10.currentTs) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.zone, r10.zone) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getClickDetail() {
        return this.clickDetail;
    }

    public final long getCurrentTs() {
        return this.currentTs;
    }

    public final String getDayType() {
        return this.dayType;
    }

    public final Map<String, String> getExtraMeta() {
        return this.extraMeta;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getLocationState() {
        return this.locationState;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getMovementState() {
        return this.movementState;
    }

    public final String getScrollDetail() {
        return this.scrollDetail;
    }

    public final String getTouchAction() {
        return this.touchAction;
    }

    public final String getTriggerType() {
        return this.triggerType;
    }

    public final String getZone() {
        return this.zone;
    }

    public int hashCode() {
        return (Long.hashCode(this.currentTs) * 31) + this.zone.hashCode();
    }

    public final void setAppName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.appName = r2;
    }

    public final void setClickDetail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.clickDetail = r2;
    }

    public final void setDayType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dayType = r2;
    }

    public final void setExtraMeta(Map<String, String> r3) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.extraMeta = r4;
    }

    public final void setLatitude(double r1) {
        this.latitude = r1;
    }

    public final void setLocation(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.location = r2;
    }

    public final void setLocationState(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.locationState = r2;
    }

    public final void setLongitude(double r1) {
        this.longitude = r1;
    }

    public final void setMovementState(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.movementState = r2;
    }

    public final void setScrollDetail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.scrollDetail = r2;
    }

    public final void setTouchAction(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.touchAction = r2;
    }

    public final void setTriggerType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.triggerType = r2;
    }

    public String toString() {
        return "ScreenshotContextData(currentTs=" + this.currentTs + ", zone=" + this.zone + ')';
    }
}
