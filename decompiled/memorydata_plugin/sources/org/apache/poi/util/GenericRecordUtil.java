package org.apache.poi.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes7.dex */
public final class GenericRecordUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static class AnnotatedFlag {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean exactMatch;
        private final Map<Integer, String> masks;
        private final Supplier<Number> value;

        static {
        }

        AnnotatedFlag(Supplier<Number> r3, int[] r4, String[] r5, boolean r6) {
            Supplier<Number> r7 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin");
            this.masks = new LinkedHashMap();
            this.value = r7;
            this.exactMatch = r6;
            int r8 = 0;
        L4:
            if (r8 >= r4.length) goto L6;
            this.masks.put(Integer.valueOf(r4[r8]), r5[r8]);
            r8 = r8 + 1;
            goto L4
        }

        private boolean match(int r3, int r4) {
            if (this.exactMatch == false) goto L7;
            if (r3 != r4) goto L10;
            return true;
        L10:
            return false;
        L7:
            if ((r3 & r4) != r4) goto L10;
            return true;
        }

        public String getDescription() {
            final int r0 = ((Number) ZeusTransformUtils.preCheckCast(this.value.get(), Number.class, "com.obric.memorydata.plugin")).intValue();
            return (String) ZeusTransformUtils.preCheckCast(this.masks.entrySet().stream().filter(new $$Lambda$GenericRecordUtil$AnnotatedFlag$oxlzmKMPF2kl44OEmpLLFegHuk4(this, r0)).map($$Lambda$px9UmIMTTbvVpHfaxQFQdL9ibcs.INSTANCE).collect(Collectors.joining(" | ")), String.class, "com.obric.memorydata.plugin");
        }

        public Supplier<Number> getValue() {
            return this.value;
        }

        public /* synthetic */ boolean lambda$getDescription$0$GenericRecordUtil$AnnotatedFlag(int r3, Map.Entry r4) {
            return match(r3, ((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        }
    }

    static {
    }

    private GenericRecordUtil() {
    }

    public static Supplier<AnnotatedFlag> getBitsAsString(Supplier<Number> r2, final int[] r3, final String[] r4) {
        final Supplier r5 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r2, Supplier.class, "com.obric.memorydata.plugin");
        return new $$Lambda$GenericRecordUtil$rKsOcbuWeoZZgDUefBZYMMy8yOo(r5, r3, r4);
    }

    public static Supplier<AnnotatedFlag> getBitsAsString(Supplier<Number> r2, BitField[] r3, final String[] r4) {
        final Supplier r5 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r2, Supplier.class, "com.obric.memorydata.plugin");
        final int[] r6 = Arrays.stream(r3).mapToInt($$Lambda$0PmjEAmqbeHHZEm5_RNEB5pkhMs.INSTANCE).toArray();
        return new $$Lambda$GenericRecordUtil$ET2NUMowOjgpe6m81aRTMDkuRs(r5, r6, r4);
    }

    public static Supplier<AnnotatedFlag> getEnumBitsAsString(Supplier<Number> r2, final int[] r3, final String[] r4) {
        final Supplier r5 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r2, Supplier.class, "com.obric.memorydata.plugin");
        return new $$Lambda$GenericRecordUtil$AVXo4sxXJJGAH1yWmic7vqYN6bE(r5, r3, r4);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String r2, Supplier<?> r3) {
        return Collections.singletonMap(r2, (Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin"));
    }

    public static Map<String, Supplier<?>> getGenericProperties(String r18, Supplier<?> r19, String r20, Supplier<?> r21) {
        return getGenericProperties(r18, (Supplier) ZeusTransformUtils.wrapperContextForParams(r19, Supplier.class, "com.obric.memorydata.plugin"), r20, (Supplier) ZeusTransformUtils.wrapperContextForParams(r21, Supplier.class, "com.obric.memorydata.plugin"), null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String r18, Supplier<?> r19, String r20, Supplier<?> r21, String r22, Supplier<?> r23) {
        return getGenericProperties(r18, (Supplier) ZeusTransformUtils.wrapperContextForParams(r19, Supplier.class, "com.obric.memorydata.plugin"), r20, (Supplier) ZeusTransformUtils.wrapperContextForParams(r21, Supplier.class, "com.obric.memorydata.plugin"), r22, (Supplier) ZeusTransformUtils.wrapperContextForParams(r23, Supplier.class, "com.obric.memorydata.plugin"), null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String r18, Supplier<?> r19, String r20, Supplier<?> r21, String r22, Supplier<?> r23, String r24, Supplier<?> r25) {
        return getGenericProperties(r18, (Supplier) ZeusTransformUtils.wrapperContextForParams(r19, Supplier.class, "com.obric.memorydata.plugin"), r20, (Supplier) ZeusTransformUtils.wrapperContextForParams(r21, Supplier.class, "com.obric.memorydata.plugin"), r22, (Supplier) ZeusTransformUtils.wrapperContextForParams(r23, Supplier.class, "com.obric.memorydata.plugin"), r24, (Supplier) ZeusTransformUtils.wrapperContextForParams(r25, Supplier.class, "com.obric.memorydata.plugin"), null, null, null, null, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String r18, Supplier<?> r19, String r20, Supplier<?> r21, String r22, Supplier<?> r23, String r24, Supplier<?> r25, String r26, Supplier<?> r27) {
        return getGenericProperties(r18, (Supplier) ZeusTransformUtils.wrapperContextForParams(r19, Supplier.class, "com.obric.memorydata.plugin"), r20, (Supplier) ZeusTransformUtils.wrapperContextForParams(r21, Supplier.class, "com.obric.memorydata.plugin"), r22, (Supplier) ZeusTransformUtils.wrapperContextForParams(r23, Supplier.class, "com.obric.memorydata.plugin"), r24, (Supplier) ZeusTransformUtils.wrapperContextForParams(r25, Supplier.class, "com.obric.memorydata.plugin"), r26, (Supplier) ZeusTransformUtils.wrapperContextForParams(r27, Supplier.class, "com.obric.memorydata.plugin"), null, null, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String r18, Supplier<?> r19, String r20, Supplier<?> r21, String r22, Supplier<?> r23, String r24, Supplier<?> r25, String r26, Supplier<?> r27, String r28, Supplier<?> r29) {
        return getGenericProperties(r18, (Supplier) ZeusTransformUtils.wrapperContextForParams(r19, Supplier.class, "com.obric.memorydata.plugin"), r20, (Supplier) ZeusTransformUtils.wrapperContextForParams(r21, Supplier.class, "com.obric.memorydata.plugin"), r22, (Supplier) ZeusTransformUtils.wrapperContextForParams(r23, Supplier.class, "com.obric.memorydata.plugin"), r24, (Supplier) ZeusTransformUtils.wrapperContextForParams(r25, Supplier.class, "com.obric.memorydata.plugin"), r26, (Supplier) ZeusTransformUtils.wrapperContextForParams(r27, Supplier.class, "com.obric.memorydata.plugin"), r28, (Supplier) ZeusTransformUtils.wrapperContextForParams(r29, Supplier.class, "com.obric.memorydata.plugin"), null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String r18, Supplier<?> r19, String r20, Supplier<?> r21, String r22, Supplier<?> r23, String r24, Supplier<?> r25, String r26, Supplier<?> r27, String r28, Supplier<?> r29, String r30, Supplier<?> r31) {
        return getGenericProperties(r18, (Supplier) ZeusTransformUtils.wrapperContextForParams(r19, Supplier.class, "com.obric.memorydata.plugin"), r20, (Supplier) ZeusTransformUtils.wrapperContextForParams(r21, Supplier.class, "com.obric.memorydata.plugin"), r22, (Supplier) ZeusTransformUtils.wrapperContextForParams(r23, Supplier.class, "com.obric.memorydata.plugin"), r24, (Supplier) ZeusTransformUtils.wrapperContextForParams(r25, Supplier.class, "com.obric.memorydata.plugin"), r26, (Supplier) ZeusTransformUtils.wrapperContextForParams(r27, Supplier.class, "com.obric.memorydata.plugin"), r28, (Supplier) ZeusTransformUtils.wrapperContextForParams(r29, Supplier.class, "com.obric.memorydata.plugin"), r30, (Supplier) ZeusTransformUtils.wrapperContextForParams(r31, Supplier.class, "com.obric.memorydata.plugin"), null, null, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String r18, Supplier<?> r19, String r20, Supplier<?> r21, String r22, Supplier<?> r23, String r24, Supplier<?> r25, String r26, Supplier<?> r27, String r28, Supplier<?> r29, String r30, Supplier<?> r31, String r32, Supplier<?> r33) {
        return getGenericProperties(r18, (Supplier) ZeusTransformUtils.wrapperContextForParams(r19, Supplier.class, "com.obric.memorydata.plugin"), r20, (Supplier) ZeusTransformUtils.wrapperContextForParams(r21, Supplier.class, "com.obric.memorydata.plugin"), r22, (Supplier) ZeusTransformUtils.wrapperContextForParams(r23, Supplier.class, "com.obric.memorydata.plugin"), r24, (Supplier) ZeusTransformUtils.wrapperContextForParams(r25, Supplier.class, "com.obric.memorydata.plugin"), r26, (Supplier) ZeusTransformUtils.wrapperContextForParams(r27, Supplier.class, "com.obric.memorydata.plugin"), r28, (Supplier) ZeusTransformUtils.wrapperContextForParams(r29, Supplier.class, "com.obric.memorydata.plugin"), r30, (Supplier) ZeusTransformUtils.wrapperContextForParams(r31, Supplier.class, "com.obric.memorydata.plugin"), r32, (Supplier) ZeusTransformUtils.wrapperContextForParams(r33, Supplier.class, "com.obric.memorydata.plugin"), null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String r22, Supplier<?> r23, String r24, Supplier<?> r25, String r26, Supplier<?> r27, String r28, Supplier<?> r29, String r30, Supplier<?> r31, String r32, Supplier<?> r33, String r34, Supplier<?> r35, String r36, Supplier<?> r37, String r38, Supplier<?> r39) {
        Supplier r0 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r23, Supplier.class, "com.obric.memorydata.plugin");
        Supplier r2 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r25, Supplier.class, "com.obric.memorydata.plugin");
        Supplier r3 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r27, Supplier.class, "com.obric.memorydata.plugin");
        Supplier r4 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r29, Supplier.class, "com.obric.memorydata.plugin");
        Supplier r5 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r31, Supplier.class, "com.obric.memorydata.plugin");
        Supplier r6 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r33, Supplier.class, "com.obric.memorydata.plugin");
        Supplier r7 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r35, Supplier.class, "com.obric.memorydata.plugin");
        Supplier r8 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r37, Supplier.class, "com.obric.memorydata.plugin");
        Supplier r9 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r39, Supplier.class, "com.obric.memorydata.plugin");
        LinkedHashMap r10 = new LinkedHashMap();
        int r13 = 0;
        String[] r12 = {r22, r24, r26, r28, r30, r32, r34, r36, r38};
        Supplier[] r15 = {r0, r2, r3, r4, r5, r6, r7, r8, r9};
    L3:
        if (r13 >= 9) goto L12;
        if (r12[r13] == null) goto L12;
        if ("base".equals(r12[r13]) == false) goto L9;
        r10.putAll((Map) ZeusTransformUtils.preCheckCast(r15[r13].get(), Map.class, "com.obric.memorydata.plugin"));
    L10:
        r13 = r13 + 1;
        goto L3
    L9:
        r10.put(r12[r13], r15[r13]);
    L12:
        return Collections.unmodifiableMap(r10);
    }

    static /* synthetic */ AnnotatedFlag lambda$getBitsAsString$1(Supplier r2, int[] r3, String[] r4) {
        return new AnnotatedFlag((Supplier) ZeusTransformUtils.wrapperContextForParams(r2, Supplier.class, "com.obric.memorydata.plugin"), r3, r4, false);
    }

    static /* synthetic */ AnnotatedFlag lambda$getBitsAsString$2(Supplier r2, int[] r3, String[] r4) {
        return new AnnotatedFlag((Supplier) ZeusTransformUtils.wrapperContextForParams(r2, Supplier.class, "com.obric.memorydata.plugin"), r3, r4, false);
    }

    static /* synthetic */ AnnotatedFlag lambda$getEnumBitsAsString$3(Supplier r2, int[] r3, String[] r4) {
        return new AnnotatedFlag((Supplier) ZeusTransformUtils.wrapperContextForParams(r2, Supplier.class, "com.obric.memorydata.plugin"), r3, r4, true);
    }

    static /* synthetic */ Enum lambda$safeEnum$0(int r1, Enum[] r2, Enum r3) {
        if (r1 >= 0) goto L4;
        return r3;
    L4:
        if (r1 < r2.length) goto L6;
        return r3;
    L6:
        return r2[r1];
    }

    public static <T extends Enum<?>> Supplier<T> safeEnum(T[] r2, Supplier<Number> r3) {
        return safeEnum(r2, (Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin"), null);
    }

    public static <T extends Enum<?>> Supplier<T> safeEnum(final T[] r2, Supplier<Number> r3, final T r4) {
        final int r5 = ((Number) ZeusTransformUtils.preCheckCast(((Supplier) ZeusTransformUtils.wrapperContextForParams(r3, Supplier.class, "com.obric.memorydata.plugin")).get(), Number.class, "com.obric.memorydata.plugin")).intValue();
        return new $$Lambda$GenericRecordUtil$_tgm38ndzQB3hiddzDRriXFVHPA(r5, r2, r4);
    }
}
