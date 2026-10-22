package com.bytedance.frameworks.baselib.network.http.parser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class CacheControlParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f2526a = null;

    public static final enum Directive extends Enum<Directive> {
        private static final /* synthetic */ Directive[] $VALUES = null;
        public static final Directive MAXAGE = null;
        public static final Directive MAXSTALE = null;
        public static final Directive MINFRESH = null;
        public static final Directive MUSTREVALIDATE = null;
        public static final Directive NOCACHE = null;
        public static final Directive NOSTORE = null;
        public static final Directive NOTRANSFORM = null;
        public static final Directive ONLYIFCACHED = null;
        public static final Directive PRIVATE = null;
        public static final Directive PROXYREVALIDATE = null;
        public static final Directive PUBLIC = null;
        public static final Directive SMAXAGE = null;
        public static final Directive UNKNOWN = null;

        static {
            Directive r0 = new Directive("MAXAGE", 0);
            MAXAGE = r0;
            Directive r1 = new Directive("MAXSTALE", 1);
            MAXSTALE = r1;
            Directive r3 = new Directive("MINFRESH", 2);
            MINFRESH = r3;
            Directive r5 = new Directive("NOCACHE", 3);
            NOCACHE = r5;
            Directive r7 = new Directive("NOSTORE", 4);
            NOSTORE = r7;
            Directive r9 = new Directive("NOTRANSFORM", 5);
            NOTRANSFORM = r9;
            Directive r11 = new Directive("ONLYIFCACHED", 6);
            ONLYIFCACHED = r11;
            Directive r13 = new Directive("MUSTREVALIDATE", 7);
            MUSTREVALIDATE = r13;
            Directive r15 = new Directive("PRIVATE", 8);
            PRIVATE = r15;
            Directive r14 = new Directive("PROXYREVALIDATE", 9);
            PROXYREVALIDATE = r14;
            Directive r12 = new Directive("PUBLIC", 10);
            PUBLIC = r12;
            Directive r10 = new Directive("SMAXAGE", 11);
            SMAXAGE = r10;
            Directive r8 = new Directive("UNKNOWN", 12);
            UNKNOWN = r8;
            $VALUES = new Directive[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
        }

        private Directive(String r1, int r2) {
            super(r1, r2);
        }

        public static Directive select(String r2) {
            return valueOf(r2.toUpperCase().replaceAll("-", ""));
        L5:
            return UNKNOWN;
        }

        public static Directive valueOf(String r2) {
            return (Directive) ZeusTransformUtils.preCheckCast(Enum.valueOf(Directive.class, r2), Directive.class, "com.obric.memorydata.plugin");
        }

        public static Directive[] values() {
            return (Directive[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Directive[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f2526a = Pattern.compile("\\s*([\\w\\-]+)\\s*(=)?\\s*(\\d+|\\\"([^\"\\\\]*(\\\\.[^\"\\\\]*)*)+\\\")?\\s*");
    }
}
