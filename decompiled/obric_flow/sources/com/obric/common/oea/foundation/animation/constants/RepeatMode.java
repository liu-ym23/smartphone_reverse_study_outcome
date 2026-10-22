package com.obric.common.oea.foundation.animation.constants;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "", "NORMAL", "LOOP", "REVERSE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum RepeatMode extends Enum<RepeatMode> {
    public static final RepeatMode LOOP = null;
    public static final RepeatMode NORMAL = null;
    public static final RepeatMode REVERSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RepeatMode[] f11318a = null;

    static {
        RepeatMode r5 = new RepeatMode("NORMAL", 0);
        NORMAL = r5;
        RepeatMode r10 = new RepeatMode("LOOP", 1);
        LOOP = r10;
        RepeatMode r11 = new RepeatMode("REVERSE", 2);
        REVERSE = r11;
        f11318a = new RepeatMode[]{r5, r10, r11};
    }

    public static RepeatMode valueOf(String r5) {
        return (RepeatMode) Enum.valueOf(RepeatMode.class, r5);
    }

    public static RepeatMode[] values() {
        return (RepeatMode[]) f11318a.clone();
    }
}
