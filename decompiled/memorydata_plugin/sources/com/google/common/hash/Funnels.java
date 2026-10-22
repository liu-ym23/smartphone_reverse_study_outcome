package com.google.common.hash;

import com.google.common.base.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class Funnels {

    private static final enum ByteArrayFunnel extends Enum<ByteArrayFunnel> implements Funnel<byte[]> {
        private static final /* synthetic */ ByteArrayFunnel[] $VALUES = null;
        public static final ByteArrayFunnel INSTANCE = null;

        private static /* synthetic */ ByteArrayFunnel[] $values() {
            return new ByteArrayFunnel[]{INSTANCE};
        }

        static {
            INSTANCE = new ByteArrayFunnel("INSTANCE", 0);
            $VALUES = $values();
        }

        private ByteArrayFunnel(String r1, int r2) {
            super(r1, r2);
        }

        public static ByteArrayFunnel valueOf(String r2) {
            return (ByteArrayFunnel) ZeusTransformUtils.preCheckCast(Enum.valueOf(ByteArrayFunnel.class, r2), ByteArrayFunnel.class, "com.obric.memorydata.plugin");
        }

        public static ByteArrayFunnel[] values() {
            return (ByteArrayFunnel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ByteArrayFunnel[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.hash.Funnel
        public /* synthetic */ void funnel(byte[] r3, k r4) {
            k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
            funnel2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"), r5);
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(byte[] r2, k r3) {
            ((k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin")).b(r2);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }

    private static final enum IntegerFunnel extends Enum<IntegerFunnel> implements Funnel<Integer> {
        private static final /* synthetic */ IntegerFunnel[] $VALUES = null;
        public static final IntegerFunnel INSTANCE = null;

        private static /* synthetic */ IntegerFunnel[] $values() {
            return new IntegerFunnel[]{INSTANCE};
        }

        static {
            INSTANCE = new IntegerFunnel("INSTANCE", 0);
            $VALUES = $values();
        }

        private IntegerFunnel(String r1, int r2) {
            super(r1, r2);
        }

        public static IntegerFunnel valueOf(String r2) {
            return (IntegerFunnel) ZeusTransformUtils.preCheckCast(Enum.valueOf(IntegerFunnel.class, r2), IntegerFunnel.class, "com.obric.memorydata.plugin");
        }

        public static IntegerFunnel[] values() {
            return (IntegerFunnel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IntegerFunnel[].class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(Integer r2, k r3) {
            ((k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin")).b(r2.intValue());
        }

        @Override // com.google.common.hash.Funnel
        public /* synthetic */ void funnel(Integer r3, k r4) {
            k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
            funnel2((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin"), r5);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }
    }

    private static final enum LongFunnel extends Enum<LongFunnel> implements Funnel<Long> {
        private static final /* synthetic */ LongFunnel[] $VALUES = null;
        public static final LongFunnel INSTANCE = null;

        private static /* synthetic */ LongFunnel[] $values() {
            return new LongFunnel[]{INSTANCE};
        }

        static {
            INSTANCE = new LongFunnel("INSTANCE", 0);
            $VALUES = $values();
        }

        private LongFunnel(String r1, int r2) {
            super(r1, r2);
        }

        public static LongFunnel valueOf(String r2) {
            return (LongFunnel) ZeusTransformUtils.preCheckCast(Enum.valueOf(LongFunnel.class, r2), LongFunnel.class, "com.obric.memorydata.plugin");
        }

        public static LongFunnel[] values() {
            return (LongFunnel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LongFunnel[].class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(Long r2, k r3) {
            ((k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin")).b(r2.longValue());
        }

        @Override // com.google.common.hash.Funnel
        public /* synthetic */ void funnel(Long r3, k r4) {
            k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
            funnel2((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin"), r5);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }
    }

    private static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        private final Funnel<E> elementFunnel;

        SequentialFunnel(Funnel<E> r3) {
            this.elementFunnel = (Funnel) ZeusTransformUtils.preCheckCast(n.a((Funnel) ZeusTransformUtils.wrapperContextForParams(r3, Funnel.class, "com.obric.memorydata.plugin")), Funnel.class, "com.obric.memorydata.plugin");
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, SequentialFunnel.class) == false) goto L6;
            SequentialFunnel r4 = (SequentialFunnel) ZeusTransformUtils.preCheckCast(r3, SequentialFunnel.class, "com.obric.memorydata.plugin");
            return this.elementFunnel.equals(r4.elementFunnel);
        L6:
            return false;
        }

        public void funnel(Iterable<? extends E> r3, k r4) {
            Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            k r6 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
            Iterator r7 = r5.iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Object r0 = r7.next();
            this.elementFunnel.funnel((E) r0, r6);
            goto L4
        }

        @Override // com.google.common.hash.Funnel
        public /* synthetic */ void funnel(Object r3, k r4) {
            k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
            funnel((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), r5);
        }

        public int hashCode() {
            int r0 = SequentialFunnel.class.hashCode();
            return this.elementFunnel.hashCode() ^ r0;
        }

        public String toString() {
            return "Funnels.sequentialFunnel(" + this.elementFunnel + ")";
        }
    }

    private static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        private final Charset charset;

        private static class SerializedForm implements Serializable {
            private static final long serialVersionUID = 0;
            private final String charsetCanonicalName;

            SerializedForm(Charset r1) {
                this.charsetCanonicalName = r1.name();
            }

            private Object readResolve() {
                return Funnels.a(Charset.forName(this.charsetCanonicalName));
            }
        }

        StringCharsetFunnel(Charset r3) {
            this.charset = (Charset) ZeusTransformUtils.preCheckCast(n.a(r3), Charset.class, "com.obric.memorydata.plugin");
        }

        private void readObject(ObjectInputStream r1) {
            throw new InvalidObjectException("Use SerializedForm");
        }

        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, StringCharsetFunnel.class) == false) goto L6;
            StringCharsetFunnel r4 = (StringCharsetFunnel) ZeusTransformUtils.preCheckCast(r3, StringCharsetFunnel.class, "com.obric.memorydata.plugin");
            return this.charset.equals(r4.charset);
        L6:
            return false;
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(CharSequence r3, k r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
            ((k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin")).b(r5, this.charset);
        }

        @Override // com.google.common.hash.Funnel
        public /* synthetic */ void funnel(CharSequence r3, k r4) {
            k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
            funnel2((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), r5);
        }

        public int hashCode() {
            int r0 = StringCharsetFunnel.class.hashCode();
            return this.charset.hashCode() ^ r0;
        }

        public String toString() {
            return "Funnels.stringFunnel(" + this.charset.name() + ")";
        }

        Object writeReplace() {
            return new SerializedForm(this.charset);
        }
    }

    private static final enum UnencodedCharsFunnel extends Enum<UnencodedCharsFunnel> implements Funnel<CharSequence> {
        private static final /* synthetic */ UnencodedCharsFunnel[] $VALUES = null;
        public static final UnencodedCharsFunnel INSTANCE = null;

        private static /* synthetic */ UnencodedCharsFunnel[] $values() {
            return new UnencodedCharsFunnel[]{INSTANCE};
        }

        static {
            INSTANCE = new UnencodedCharsFunnel("INSTANCE", 0);
            $VALUES = $values();
        }

        private UnencodedCharsFunnel(String r1, int r2) {
            super(r1, r2);
        }

        public static UnencodedCharsFunnel valueOf(String r2) {
            return (UnencodedCharsFunnel) ZeusTransformUtils.preCheckCast(Enum.valueOf(UnencodedCharsFunnel.class, r2), UnencodedCharsFunnel.class, "com.obric.memorydata.plugin");
        }

        public static UnencodedCharsFunnel[] values() {
            return (UnencodedCharsFunnel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UnencodedCharsFunnel[].class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: funnel, reason: avoid collision after fix types in other method */
        public void funnel2(CharSequence r2, k r3) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
            ((k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin")).b(r1);
        }

        @Override // com.google.common.hash.Funnel
        public /* synthetic */ void funnel(CharSequence r3, k r4) {
            k r5 = (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin");
            funnel2((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), r5);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }
    }

    public static Funnel<CharSequence> a(Charset r1) {
        return new StringCharsetFunnel(r1);
    }
}
