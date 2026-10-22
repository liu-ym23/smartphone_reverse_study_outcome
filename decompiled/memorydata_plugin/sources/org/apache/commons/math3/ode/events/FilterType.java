package org.apache.commons.math3.ode.events;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract enum FilterType extends Enum<FilterType> {
    private static final /* synthetic */ FilterType[] $VALUES = null;
    public static final FilterType TRIGGER_ONLY_DECREASING_EVENTS = null;
    public static final FilterType TRIGGER_ONLY_INCREASING_EVENTS = null;

    /* JADX INFO: renamed from: org.apache.commons.math3.ode.events.FilterType$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$ode$events$Transformer = null;

        static {
            int[] r0 = new int[Transformer.values().length];
            $SwitchMap$org$apache$commons$math3$ode$events$Transformer = r0;
            r0[Transformer.UNINITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$commons$math3$ode$events$Transformer[Transformer.PLUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$commons$math3$ode$events$Transformer[Transformer.MINUS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$apache$commons$math3$ode$events$Transformer[Transformer.MIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$apache$commons$math3$ode$events$Transformer[Transformer.MAX.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        final String r1 = "TRIGGER_ONLY_DECREASING_EVENTS";
        final int r2 = 0;
        FilterType r0 = new AnonymousClass1(r1, r2);
        TRIGGER_ONLY_DECREASING_EVENTS = r0;
        final String r3 = "TRIGGER_ONLY_INCREASING_EVENTS";
        final int r4 = 1;
        FilterType r5 = new AnonymousClass2(r3, r4);
        TRIGGER_ONLY_INCREASING_EVENTS = r5;
        $VALUES = new FilterType[]{r0, r5};
    }

    private FilterType(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ FilterType(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static FilterType valueOf(String r2) {
        return (FilterType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FilterType.class, r2), FilterType.class, "com.obric.memorydata.plugin");
    }

    public static FilterType[] values() {
        return (FilterType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FilterType[].class, "com.obric.memorydata.plugin");
    }

    public abstract boolean getTriggeredIncreasing();

    public abstract Transformer selectTransformer(Transformer r1, double r2, boolean r4);
}
