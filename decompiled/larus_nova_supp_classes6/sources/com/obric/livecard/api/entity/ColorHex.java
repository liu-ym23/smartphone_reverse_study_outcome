package com.obric.livecard.api.entity;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/livecard/api/entity/ColorHex;", "", "light", "", "night", "(Ljava/lang/String;Ljava/lang/String;)V", "getLight", "()Ljava/lang/String;", "getNight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ColorHex {
    private final String light;
    private final String night;

    public static /* synthetic */ ColorHex copy$default(ColorHex r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.light;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.night;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.light;
    }

    public final String component2() {
        return this.night;
    }

    public final ColorHex copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "light");
        Intrinsics.checkNotNullParameter(r3, "night");
        return new ColorHex(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ColorHex) == true) goto L8;
        return false;
    L8:
        ColorHex r6 = (ColorHex) r5;
        if (Intrinsics.areEqual(this.light, r6.light) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.night, r6.night) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.light.hashCode() * 31) + this.night.hashCode();
    }

    public String toString() {
        return "ColorHex(light=" + this.light + ", night=" + this.night + ')';
    }

    public final String getLight() {
        return this.light;
    }

    public final String getNight() {
        return this.night;
    }

    public ColorHex(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "light");
        Intrinsics.checkNotNullParameter(r3, "night");
        this.light = r2;
        this.night = r3;
    }
}
