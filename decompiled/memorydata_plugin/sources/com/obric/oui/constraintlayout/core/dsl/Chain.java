package com.obric.oui.constraintlayout.core.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Chain extends Helper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Map<Style, String> f13526a = null;

    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style PACKED = null;
        public static final Style SPREAD = null;
        public static final Style SPREAD_INSIDE = null;

        static {
            Style r0 = new Style("PACKED", 0);
            PACKED = r0;
            Style r1 = new Style("SPREAD", 1);
            SPREAD = r1;
            Style r3 = new Style("SPREAD_INSIDE", 2);
            SPREAD_INSIDE = r3;
            $VALUES = new Style[]{r0, r1, r3};
        }

        private Style(String r1, int r2) {
            super(r1, r2);
        }

        public static Style valueOf(String r2) {
            return (Style) ZeusTransformUtils.preCheckCast(Enum.valueOf(Style.class, r2), Style.class, "com.obric.memorydata.plugin");
        }

        public static Style[] values() {
            return (Style[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Style[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        HashMap r0 = new HashMap();
        f13526a = r0;
        r0.put(Style.SPREAD, "'spread'");
        r0.put(Style.SPREAD_INSIDE, "'spread_inside'");
        r0.put(Style.PACKED, "'packed'");
    }
}
