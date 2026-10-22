package com.bytedance.ai.bridge.service;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/service/Location;", "", "lat", "", "lng", a.KEY_SHOPPING_GUIDE_NAME, "", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getLat", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLng", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/bytedance/ai/bridge/service/Location;", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Location {
    private final Double lat;
    private final Double lng;
    private final String name;

    public static /* synthetic */ Location copy$default(Location r0, Double r1, Double r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.lat;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.lng;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.name;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final Double component1() {
        return this.lat;
    }

    public final Double component2() {
        return this.lng;
    }

    public final String component3() {
        return this.name;
    }

    public final Location copy(Double r10, Double r11, String r12) {
        return new Location(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Location) == true) goto L8;
        return false;
    L8:
        Location r11 = (Location) r10;
        if (Intrinsics.areEqual(this.lat, r11.lat) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lng, r11.lng) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r11.name) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Double r0 = this.lat;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 * 31;
        Double r12 = this.lng;
        if (r12 != null) goto L9;
        int r13 = 0;
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.name;
        if (r15 == null) goto L15;
        r1 = r15.hashCode();
    L15:
        return r14 + r1;
    L9:
        r13 = r12.hashCode();
        goto L10
    L5:
        r10 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Location(lat=" + this.lat + ", lng=" + this.lng + ", name=" + this.name + ')';
    }

    public final Double getLat() {
        return this.lat;
    }

    public final Double getLng() {
        return this.lng;
    }

    public final String getName() {
        return this.name;
    }

    public Location(Double r1, Double r10, String r11) {
        this.lat = r1;
        this.lng = r10;
        this.name = r11;
    }

    public /* synthetic */ Location(Double r10, Double r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11, r12);
    }
}
