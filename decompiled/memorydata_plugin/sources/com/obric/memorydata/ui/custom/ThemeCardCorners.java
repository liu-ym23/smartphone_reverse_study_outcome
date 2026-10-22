package com.obric.memorydata.ui.custom;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nj\u0002\b\u0004j\u0002\b\u0005¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/ui/custom/ThemeCardCorners;", "", "<init>", "(Ljava/lang/String;I)V", "ALL", "TOP", "resolveCornerRadii", "", "radius", "", "resolveCornerRadii$ui_obricRelease", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ThemeCardCorners extends Enum<ThemeCardCorners> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ThemeCardCorners[] $VALUES = null;
    public static final ThemeCardCorners ALL = null;
    public static final ThemeCardCorners TOP = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12999a = null;

        static {
            int[] r0 = new int[ThemeCardCorners.values().length];
            r0[ThemeCardCorners.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ThemeCardCorners.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f12999a = r0;
        }
    }

    private static final /* synthetic */ ThemeCardCorners[] $values() {
        return new ThemeCardCorners[]{ALL, TOP};
    }

    static {
        ALL = new ThemeCardCorners("ALL", 0);
        TOP = new ThemeCardCorners("TOP", 1);
        ThemeCardCorners[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ThemeCardCorners(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<ThemeCardCorners> getEntries() {
        return $ENTRIES;
    }

    public static ThemeCardCorners valueOf(String r2) {
        return (ThemeCardCorners) ZeusTransformUtils.preCheckCast(Enum.valueOf(ThemeCardCorners.class, r2), ThemeCardCorners.class, "com.obric.memorydata.plugin");
    }

    public static ThemeCardCorners[] values() {
        return (ThemeCardCorners[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ThemeCardCorners[].class, "com.obric.memorydata.plugin");
    }

    public final float[] resolveCornerRadii$ui_obricRelease(float r4) {
        int r3 = a.f12999a[ordinal()];
        if (r3 != 1) goto L5;
        return null;
    L5:
        if (r3 != 2) goto L8;
        return new float[]{r4, r4, r4, r4, 0.0f, 0.0f, 0.0f, 0.0f};
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
