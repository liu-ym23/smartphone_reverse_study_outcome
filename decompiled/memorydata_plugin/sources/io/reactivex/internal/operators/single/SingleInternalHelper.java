package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.z;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.a.b;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleInternalHelper {

    static final enum NoSuchElementCallable extends Enum<NoSuchElementCallable> implements Callable<NoSuchElementException> {
        private static final /* synthetic */ NoSuchElementCallable[] $VALUES = null;
        public static final NoSuchElementCallable INSTANCE = null;

        static {
            NoSuchElementCallable r0 = new NoSuchElementCallable("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new NoSuchElementCallable[]{r0};
        }

        private NoSuchElementCallable(String r1, int r2) {
            super(r1, r2);
        }

        public static NoSuchElementCallable valueOf(String r2) {
            return (NoSuchElementCallable) ZeusTransformUtils.preCheckCast(Enum.valueOf(NoSuchElementCallable.class, r2), NoSuchElementCallable.class, "com.obric.memorydata.plugin");
        }

        public static NoSuchElementCallable[] values() {
            return (NoSuchElementCallable[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NoSuchElementCallable[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ NoSuchElementException call() {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public NoSuchElementException call2() {
            return new NoSuchElementException();
        }
    }

    static final enum ToFlowable extends Enum<ToFlowable> implements h<z, b> {
        private static final /* synthetic */ ToFlowable[] $VALUES = null;
        public static final ToFlowable INSTANCE = null;

        static {
            ToFlowable r0 = new ToFlowable("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new ToFlowable[]{r0};
        }

        private ToFlowable(String r1, int r2) {
            super(r1, r2);
        }

        public static ToFlowable valueOf(String r2) {
            return (ToFlowable) ZeusTransformUtils.preCheckCast(Enum.valueOf(ToFlowable.class, r2), ToFlowable.class, "com.obric.memorydata.plugin");
        }

        public static ToFlowable[] values() {
            return (ToFlowable[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ToFlowable[].class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.b.h
        public /* synthetic */ b apply(z r3) {
            return apply2((z) ZeusTransformUtils.preCheckCast(r3, z.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public b apply2(z r2) {
            return new SingleToFlowable((z) ZeusTransformUtils.wrapperContextForParams(r2, z.class, "com.obric.memorydata.plugin"));
        }
    }

    static final enum ToObservable extends Enum<ToObservable> implements h<z, Observable> {
        private static final /* synthetic */ ToObservable[] $VALUES = null;
        public static final ToObservable INSTANCE = null;

        static {
            ToObservable r0 = new ToObservable("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new ToObservable[]{r0};
        }

        private ToObservable(String r1, int r2) {
            super(r1, r2);
        }

        public static ToObservable valueOf(String r2) {
            return (ToObservable) ZeusTransformUtils.preCheckCast(Enum.valueOf(ToObservable.class, r2), ToObservable.class, "com.obric.memorydata.plugin");
        }

        public static ToObservable[] values() {
            return (ToObservable[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ToObservable[].class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public Observable apply2(z r2) {
            return new SingleToObservable((z) ZeusTransformUtils.wrapperContextForParams(r2, z.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.b.h
        public /* synthetic */ Observable apply(z r3) {
            return apply2((z) ZeusTransformUtils.preCheckCast(r3, z.class, "com.obric.memorydata.plugin"));
        }
    }
}
