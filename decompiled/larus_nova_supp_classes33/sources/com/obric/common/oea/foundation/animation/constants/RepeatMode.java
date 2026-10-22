package com.obric.common.oea.foundation.animation.constants;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "", "NORMAL", "LOOP", "REVERSE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum RepeatMode extends Enum<RepeatMode> {
    public static final RepeatMode LOOP = null;
    public static final RepeatMode NORMAL = null;
    public static final RepeatMode REVERSE = null;
    public static final /* synthetic */ RepeatMode[] a = null;

    static {
        RepeatMode r1 = new RepeatMode("NORMAL", 0);
        NORMAL = r1;
        RepeatMode r2 = new RepeatMode("LOOP", 1);
        LOOP = r2;
        RepeatMode r3 = new RepeatMode("REVERSE", 2);
        REVERSE = r3;
        a = new RepeatMode[]{r1, r2, r3};
    }

    public static RepeatMode valueOf(String r1) {
        return (RepeatMode) a.a(RepeatMode.class, r1);
    }

    public static RepeatMode[] values() {
        return (RepeatMode[]) a.clone();
    }

    public RepeatMode(String r1, int r2) {
        super(r1, r2);
    }
}
