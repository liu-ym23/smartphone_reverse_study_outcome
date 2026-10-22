package com.obric.widget.host;

import android.graphics.Rect;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fHÆ\u0003J`\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0013R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/obric/widget/host/WidgetConfig;", "", "darkMode", "", "cornerRadius", "", "padding", "Landroid/graphics/Rect;", "backgroundColor", "", "elevation", "extras", "", "", "<init>", "(ZLjava/lang/Float;Landroid/graphics/Rect;Ljava/lang/Integer;Ljava/lang/Float;Ljava/util/Map;)V", "getDarkMode", "()Z", "getCornerRadius", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPadding", "()Landroid/graphics/Rect;", "getBackgroundColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getElevation", "getExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Float;Landroid/graphics/Rect;Ljava/lang/Integer;Ljava/lang/Float;Ljava/util/Map;)Lcom/obric/widget/host/WidgetConfig;", "equals", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetConfig {
    private final Integer backgroundColor;
    private final Float cornerRadius;
    private final boolean darkMode;
    private final Float elevation;
    private final Map<String, Object> extras;
    private final Rect padding;

    public WidgetConfig() {
        boolean r5 = false;
        Float r10 = null;
        Rect r11 = null;
        Integer r12 = null;
        Float r13 = null;
        Map r14 = null;
        this(r5, r10, r11, r12, r13, r14, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetConfig copy$default(WidgetConfig r5, boolean r10, Float r11, Rect r12, Integer r13, Float r14, Map r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = r5.darkMode;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r11 = r5.cornerRadius;
    L8:
        Float r18 = r11;
        if ((r16 & 4) == 0) goto L11;
        r12 = r5.padding;
    L11:
        Rect r19 = r12;
        if ((r16 & 8) == 0) goto L14;
        r13 = r5.backgroundColor;
    L14:
        Integer r20 = r13;
        if ((r16 & 16) == 0) goto L17;
        r14 = r5.elevation;
    L17:
        Float r21 = r14;
        if ((r16 & 32) == 0) goto L20;
        r15 = r5.extras;
    L20:
        boolean r22 = r10;
        return r5.copy(r22, r18, r19, r20, r21, r15);
    }

    public final boolean component1() {
        return this.darkMode;
    }

    public final Float component2() {
        return this.cornerRadius;
    }

    public final Rect component3() {
        return this.padding;
    }

    public final Integer component4() {
        return this.backgroundColor;
    }

    public final Float component5() {
        return this.elevation;
    }

    public final Map<String, Object> component6() {
        return this.extras;
    }

    public final WidgetConfig copy(boolean r10, Float r11, Rect r12, Integer r13, Float r14, Map<String, ? extends Object> r15) {
        Intrinsics.checkNotNullParameter(r15, "extras");
        return new WidgetConfig(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WidgetConfig) == true) goto L8;
        return false;
    L8:
        WidgetConfig r10 = (WidgetConfig) r5;
        if (this.darkMode == r10.darkMode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cornerRadius, r10.cornerRadius) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.padding, r10.padding) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.backgroundColor, r10.backgroundColor) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.elevation, r10.elevation) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extras, r10.extras) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final Integer getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Float getCornerRadius() {
        return this.cornerRadius;
    }

    public final boolean getDarkMode() {
        return this.darkMode;
    }

    public final Float getElevation() {
        return this.elevation;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }

    public final Rect getPadding() {
        return this.padding;
    }

    public int hashCode() {
        int r5 = Boolean.hashCode(this.darkMode) * 31;
        Float r10 = this.cornerRadius;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        Rect r14 = this.padding;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.backgroundColor;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Float r20 = this.elevation;
        if (r20 == null) goto L19;
        r11 = r20.hashCode();
    L19:
        return this.extras.hashCode() + ((r19 + r11) * 31);
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public String toString() {
        return "WidgetConfig(darkMode=" + this.darkMode + ", cornerRadius=" + this.cornerRadius + ", padding=" + this.padding + ", backgroundColor=" + this.backgroundColor + ", elevation=" + this.elevation + ", extras=" + this.extras + ")";
    }

    public WidgetConfig(boolean r5, Float r10, Rect r11, Integer r12, Float r13, Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r14, "extras");
        this.darkMode = r5;
        this.cornerRadius = r10;
        this.padding = r11;
        this.backgroundColor = r12;
        this.elevation = r13;
        this.extras = r14;
    }

    public /* synthetic */ WidgetConfig(boolean r5, Float r10, Rect r11, Integer r12, Float r13, Map r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        r5 = false;
    L5:
        Float r17 = null;
        if ((r15 & 2) == 0) goto L8;
        Float r18 = null;
    L10:
        if ((r15 & 4) == 0) goto L12;
        Rect r19 = null;
    L14:
        if ((r15 & 8) == 0) goto L16;
        Integer r20 = null;
    L18:
        if ((r15 & 16) != 0) goto L22;
        r17 = r13;
    L22:
        if ((r15 & 32) == 0) goto L24;
        r14 = MapsKt.emptyMap();
    L24:
        this(r5, r18, r19, r20, r17, r14);
        return;
    L16:
        r20 = r12;
        goto L18
    L12:
        r19 = r11;
        goto L14
    L8:
        r18 = r10;
        goto L10
    }
}
