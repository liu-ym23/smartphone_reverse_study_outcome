package com.google.common.collect;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
final class bf {

    /* JADX INFO: renamed from: com.google.common.collect.bf$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<b<R, C, V>> f4667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final be<R, C, b<R, C, V>> f4668b;

        private a() {
            this.f4667a = new ArrayList();
            this.f4668b = HashBasedTable.create();
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        ImmutableTable<R, C, V> a() {
            return ImmutableTable.copyOf(this.f4667a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        a<R, C, V> a(a<R, C, V> r5, BinaryOperator<V> r6) {
            BinaryOperator r7 = (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r6, BinaryOperator.class, "com.obric.memorydata.plugin");
            Iterator<b<R, C, V>> r8 = r5.f4667a.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            b r0 = (b) ZeusTransformUtils.preCheckCast(r8.next(), b.class, "com.obric.memorydata.plugin");
            a(r0.getRowKey(), r0.getColumnKey(), r0.getValue(), r7);
            goto L4
        L6:
            return this;
        }

        void a(R r4, C r5, V r6, BinaryOperator<V> r7) {
            BinaryOperator<V> r8 = (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r7, BinaryOperator.class, "com.obric.memorydata.plugin");
            b r0 = (b) ZeusTransformUtils.preCheckCast(this.f4668b.get(r4, r5), b.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            b<R, C, V> r9 = new b(r4, r5, r6);
            this.f4667a.add(r9);
            this.f4668b.put(r4, r5, r9);
            return;
        L5:
            r0.a(r6, r8);
        }
    }

    private static final class b<R, C, V> extends Tables.a<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final R f4669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final C f4670b;
        private V c;

        b(R r2, C r3, V r4) {
            this.f4669a = (R) com.google.common.base.n.a(r2, "row");
            this.f4670b = (C) com.google.common.base.n.a(r3, "column");
            this.c = (V) com.google.common.base.n.a(r4, EventBody.KEY_VALUE);
        }

        void a(V r3, BinaryOperator<V> r4) {
            BinaryOperator r5 = (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r4, BinaryOperator.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r3, EventBody.KEY_VALUE);
            this.c = (V) com.google.common.base.n.a(r5.apply(this.c, r3), "mergeFunction.apply");
        }

        @Override // com.google.common.collect.be.a
        public C getColumnKey() {
            return this.f4670b;
        }

        @Override // com.google.common.collect.be.a
        public R getRowKey() {
            return this.f4669a;
        }

        @Override // com.google.common.collect.be.a
        public V getValue() {
            return this.c;
        }
    }

    private static /* synthetic */ ImmutableTable a(a r0) {
        return r0.a();
    }

    private static /* synthetic */ a a() {
        return new a(null);
    }

    private static /* synthetic */ a a(BinaryOperator r2, a r3, a r4) {
        return r3.a(r4, (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r2, BinaryOperator.class, "com.obric.memorydata.plugin"));
    }

    static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> a(Function<? super T, ? extends R> r2, Function<? super T, ? extends C> r3, Function<? super T, ? extends V> r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        final Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        final Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5, "rowFunction");
        com.google.common.base.n.a(r6, "columnFunction");
        com.google.common.base.n.a(r7, "valueFunction");
        return Collector.of($$Lambda$XkGzlRY_ZXvBOh9GCpdlWgA8NAI.INSTANCE, new $$Lambda$bf$dAH0Kb5OeZ2VLUhPrcqNvhPWHF8(r5, r6, r7), $$Lambda$FwJcmFSBrsKDBNlBn6TLr5vqeQQ.INSTANCE, $$Lambda$nDmZE53WzXH8F2z9r5W6bIbQo.INSTANCE, new Collector.Characteristics[0]);
    }

    static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> a(Function<? super T, ? extends R> r2, Function<? super T, ? extends C> r3, Function<? super T, ? extends V> r4, BinaryOperator<V> r5) {
        final Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        final Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        final Function r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        final BinaryOperator r9 = (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r5, BinaryOperator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6, "rowFunction");
        com.google.common.base.n.a(r7, "columnFunction");
        com.google.common.base.n.a(r8, "valueFunction");
        com.google.common.base.n.a(r9, "mergeFunction");
        return Collector.of($$Lambda$bf$jx1ulo3ghL_ccWbvn6m2uxJd_7A.INSTANCE, new $$Lambda$bf$0dbMONz5tvWN3lgaplJeASXJkBs(r6, r7, r8, r9), new $$Lambda$bf$KSyIvF9SGZmcVzKyZ8GbkIi2lc(r9), $$Lambda$bf$hD7FxthGnWlramLOCIalR9C2LAg.INSTANCE, new Collector.Characteristics[0]);
    }

    private static /* synthetic */ void a(Function r2, Function r3, Function r4, ImmutableTable.a r5, Object r6) {
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        Function r9 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        r5.a(r7.apply(r6), r8.apply(r6), r9.apply(r6));
    }

    private static /* synthetic */ void a(Function r2, Function r3, Function r4, BinaryOperator r5, a r6, Object r7) {
        Function r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r9 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        Function r10 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        BinaryOperator r11 = (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r5, BinaryOperator.class, "com.obric.memorydata.plugin");
        r6.a(r8.apply(r7), r9.apply(r7), r10.apply(r7), r11);
    }

    public static /* synthetic */ void lambda$0dbMONz5tvWN3lgaplJeASXJkBs(Function r0, Function r1, Function r2, BinaryOperator r3, a r4, Object r5) {
        a(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$KSyIvF9SGZmcVzK-yZ8GbkIi2lc, reason: not valid java name */
    public static /* synthetic */ a m133lambda$KSyIvF9SGZmcVzKyZ8GbkIi2lc(BinaryOperator r0, a r1, a r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$dAH0Kb5OeZ2VLUhPrcqNvhPWHF8(Function r0, Function r1, Function r2, ImmutableTable.a r3, Object r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ ImmutableTable lambda$hD7FxthGnWlramLOCIalR9C2LAg(a r0) {
        return a(r0);
    }

    public static /* synthetic */ a lambda$jx1ulo3ghL_ccWbvn6m2uxJd_7A() {
        return a();
    }
}
