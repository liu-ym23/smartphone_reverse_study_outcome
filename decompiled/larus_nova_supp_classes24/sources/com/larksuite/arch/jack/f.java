package com.larksuite.arch.jack;

import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface f {

    public static final class a {
        public static void h(f r1, JackViewModel r2, Function1 r3) {
            r1.nH(r2, new l(), r3);
        }

        public static void e(f r1, JackViewModel r2, PropertyReference1Impl r3, Function1 r4) {
            r1.Ik(r2, r3, new l(), r4);
        }

        public static <S extends j> c g(f r1, JackViewModel<S> r2, l<S> r3, Function1<? super S, Unit> r4) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            Intrinsics.checkNotNullParameter(r3, "config");
            Intrinsics.checkNotNullParameter(r4, "subscriber");
            return r2.subscribeInternal$jack_release(r1.getLifecycleOwnerHolder().getLifecycleOwner(), r3, r4);
        }

        public static <S extends j, A> c a(f r1, JackViewModel<S> r2, KProperty1<S, ? extends A> r3, l<n<A>> r4, Function1<? super S, Unit> r5) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            Intrinsics.checkNotNullParameter(r3, "prop1");
            Intrinsics.checkNotNullParameter(r4, "config");
            Intrinsics.checkNotNullParameter(r5, "subscriber");
            return r2.selectSubscribeInternal$jack_release(r1.getLifecycleOwnerHolder().getLifecycleOwner(), r3, r4, r5);
        }

        public static void f(f r6, JackViewModel r7, PropertyReference1Impl r8, PropertyReference1Impl r9, Function1 r10) {
            r6.Ki(r7, r8, r9, new l(), r10);
        }

        public static <S extends j, A, B> c b(f r6, JackViewModel<S> r7, KProperty1<S, ? extends A> r8, KProperty1<S, ? extends B> r9, l<o<A, B>> r10, Function1<? super S, Unit> r11) {
            Intrinsics.checkNotNullParameter(r7, "$receiver");
            Intrinsics.checkNotNullParameter(r8, "prop1");
            Intrinsics.checkNotNullParameter(r9, "prop2");
            Intrinsics.checkNotNullParameter(r10, "config");
            Intrinsics.checkNotNullParameter(r11, "subscriber");
            return r7.selectSubscribeInternal$jack_release(r6.getLifecycleOwnerHolder().getLifecycleOwner(), r8, r9, r10, r11);
        }

        public static void d(f r7, FilePickerViewModel r8, PropertyReference1Impl r9, PropertyReference1Impl r10, PropertyReference1Impl r11, Function1 r12) {
            r7.O60(r8, r9, r10, r11, new l(), r12);
        }

        public static <S extends j, A, B, C> c c(f r7, JackViewModel<S> r8, KProperty1<S, ? extends A> r9, KProperty1<S, ? extends B> r10, KProperty1<S, ? extends C> r11, l<p<A, B, C>> r12, Function1<? super S, Unit> r13) {
            Intrinsics.checkNotNullParameter(r8, "$receiver");
            Intrinsics.checkNotNullParameter(r9, "prop1");
            Intrinsics.checkNotNullParameter(r10, "prop2");
            Intrinsics.checkNotNullParameter(r11, "prop3");
            Intrinsics.checkNotNullParameter(r12, "config");
            Intrinsics.checkNotNullParameter(r13, "subscriber");
            return r8.selectSubscribeInternal$jack_release(r7.getLifecycleOwnerHolder().getLifecycleOwner(), r9, r10, r11, r12, r13);
        }
    }

    c Ik(JackViewModel r1, PropertyReference1Impl r2, l r3, Function1 r4);

    c Ki(JackViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, l r4, Function1 r5);

    c O60(FilePickerViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, PropertyReference1Impl r4, l r5, Function1 r6);

    i getLifecycleOwnerHolder();

    <S extends j> c nH(JackViewModel<S> r1, l<S> r2, Function1<? super S, Unit> r3);
}
