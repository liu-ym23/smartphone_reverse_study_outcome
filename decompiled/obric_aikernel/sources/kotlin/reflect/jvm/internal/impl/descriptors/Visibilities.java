package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
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

        private PrivateToThis() {
            super("private_to_this", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "private/*private to this*/";
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

    static {
        INSTANCE = new Visibilities();
        Map r10 = MapsKt.createMapBuilder();
        r10.put(PrivateToThis.INSTANCE, 0);
        r10.put(Private.INSTANCE, 0);
        r10.put(Internal.INSTANCE, 1);
        r10.put(Protected.INSTANCE, 1);
        Public r11 = Public.INSTANCE;
        r10.put(r11, 2);
        ORDERED_VISIBILITIES = MapsKt.build(r10);
        DEFAULT_VISIBILITY = r11;
    }

    private Visibilities() {
    }

    public final Integer compareLocal$compiler_common(Visibility r10, Visibility r11) {
        Intrinsics.checkNotNullParameter(r10, "first");
        Intrinsics.checkNotNullParameter(r11, "second");
        if (r10 == r11) goto L5;
        Map<Visibility, Integer> r12 = ORDERED_VISIBILITIES;
        Integer r13 = r12.get(r10);
        Integer r14 = r12.get(r11);
        if (r13 == null) goto L13;
        if (r14 == null) goto L13;
        if (Intrinsics.areEqual(r13, r14) == true) goto L13;
        return Integer.valueOf(r13.intValue() - r14.intValue());
    L13:
        return null;
    L5:
        return 0;
    }

    public final boolean isPrivate(Visibility r10) {
        Intrinsics.checkNotNullParameter(r10, "visibility");
        if (r10 != Private.INSTANCE) goto L5;
    L8:
        return true;
    L5:
        if (r10 == PrivateToThis.INSTANCE) goto L8;
        return false;
    }
}
