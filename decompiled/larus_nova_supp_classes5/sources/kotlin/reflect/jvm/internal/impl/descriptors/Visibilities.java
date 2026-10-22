package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class Visibilities {
    private static final Public DEFAULT_VISIBILITY = null;
    public static final Visibilities INSTANCE = null;
    private static final Map<Visibility, Integer> ORDERED_VISIBILITIES = null;

    public static final class Inherited extends Visibility {
        public static final Inherited INSTANCE = null;

        static {
            INSTANCE = new Inherited();
        }

        private Inherited() {
            super("inherited", false);
        }
    }

    public static final class Internal extends Visibility {
        public static final Internal INSTANCE = null;

        static {
            INSTANCE = new Internal();
        }

        private Internal() {
            super("internal", false);
        }
    }

    public static final class InvisibleFake extends Visibility {
        public static final InvisibleFake INSTANCE = null;

        static {
            INSTANCE = new InvisibleFake();
        }

        private InvisibleFake() {
            super("invisible_fake", false);
        }
    }

    public static final class Local extends Visibility {
        public static final Local INSTANCE = null;

        static {
            INSTANCE = new Local();
        }

        private Local() {
            super("local", false);
        }
    }

    public static final class Private extends Visibility {
        public static final Private INSTANCE = null;

        static {
            INSTANCE = new Private();
        }

        private Private() {
            super("private", false);
        }
    }

    public static final class PrivateToThis extends Visibility {
        public static final PrivateToThis INSTANCE = null;

        static {
            INSTANCE = new PrivateToThis();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }

        private PrivateToThis() {
            super("private_to_this", false);
        }
    }

    public static final class Protected extends Visibility {
        public static final Protected INSTANCE = null;

        static {
            INSTANCE = new Protected();
        }

        private Protected() {
            super("protected", true);
        }
    }

    public static final class Public extends Visibility {
        public static final Public INSTANCE = null;

        static {
            INSTANCE = new Public();
        }

        private Public() {
            super("public", true);
        }
    }

    public static final class Unknown extends Visibility {
        public static final Unknown INSTANCE = null;

        static {
            INSTANCE = new Unknown();
        }

        private Unknown() {
            super("unknown", false);
        }
    }

    private Visibilities() {
    }

    static {
        INSTANCE = new Visibilities();
        Map r0 = MapsKt.createMapBuilder();
        r0.put(PrivateToThis.INSTANCE, 0);
        r0.put(Private.INSTANCE, 0);
        r0.put(Internal.INSTANCE, 1);
        r0.put(Protected.INSTANCE, 1);
        Public r1 = Public.INSTANCE;
        r0.put(r1, 2);
        ORDERED_VISIBILITIES = MapsKt.build(r0);
        DEFAULT_VISIBILITY = r1;
    }

    public final boolean isPrivate(Visibility r2) {
        Intrinsics.checkNotNullParameter(r2, "visibility");
        if (r2 != Private.INSTANCE) goto L5;
    L8:
        return true;
    L5:
        if (r2 == PrivateToThis.INSTANCE) goto L8;
        return false;
    }

    public final Integer compareLocal$compiler_common(Visibility r2, Visibility r3) {
        Intrinsics.checkNotNullParameter(r2, "first");
        Intrinsics.checkNotNullParameter(r3, "second");
        if (r2 == r3) goto L5;
        Map<Visibility, Integer> r0 = ORDERED_VISIBILITIES;
        Integer r4 = r0.get(r2);
        Integer r5 = r0.get(r3);
        if (r4 == null) goto L13;
        if (r5 == null) goto L13;
        if (Intrinsics.areEqual(r4, r5) == true) goto L13;
        return Integer.valueOf(r4.intValue() - r5.intValue());
    L13:
        return null;
    L5:
        return 0;
    }
}
