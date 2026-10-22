package com.larksuite.arch.jack;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/larksuite/arch/jack/JackView;", "Lcom/larksuite/arch/jack/IdentitySubscriber;", "jack_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public interface JackView extends IdentitySubscriber {

    public static final class a {
        public static <S extends j> c d(JackView r3, JackViewModel<S> r4, l<S> r5, Function1<? super S, Unit> r6) {
            Intrinsics.checkNotNullParameter(r4, "$receiver");
            Intrinsics.checkNotNullParameter(r5, "config");
            Intrinsics.checkNotNullParameter(r6, "subscriber");
            Intrinsics.checkNotNullParameter(r4, "$receiver");
            Intrinsics.checkNotNullParameter(r5, "config");
            Intrinsics.checkNotNullParameter(r6, "subscriber");
            return f.a.g(r3, r4, r5, r6);
        }

        public static <S extends j, A> c a(JackView r4, JackViewModel<S> r5, KProperty1<S, ? extends A> r6, l<n<A>> r7, Function1<? super S, Unit> r8) {
            Intrinsics.checkNotNullParameter(r5, "$receiver");
            Intrinsics.checkNotNullParameter(r6, "prop1");
            Intrinsics.checkNotNullParameter(r7, "config");
            Intrinsics.checkNotNullParameter(r8, "subscriber");
            Intrinsics.checkNotNullParameter(r5, "$receiver");
            Intrinsics.checkNotNullParameter(r6, "prop1");
            Intrinsics.checkNotNullParameter(r7, "config");
            Intrinsics.checkNotNullParameter(r8, "subscriber");
            return f.a.a(r4, r5, r6, r7, r8);
        }

        public static <S extends j, A, B> c b(JackView r5, JackViewModel<S> r6, KProperty1<S, ? extends A> r7, KProperty1<S, ? extends B> r8, l<o<A, B>> r9, Function1<? super S, Unit> r10) {
            Intrinsics.checkNotNullParameter(r6, "$receiver");
            Intrinsics.checkNotNullParameter(r7, "prop1");
            Intrinsics.checkNotNullParameter(r8, "prop2");
            Intrinsics.checkNotNullParameter(r9, "config");
            Intrinsics.checkNotNullParameter(r10, "subscriber");
            Intrinsics.checkNotNullParameter(r6, "$receiver");
            Intrinsics.checkNotNullParameter(r7, "prop1");
            Intrinsics.checkNotNullParameter(r8, "prop2");
            Intrinsics.checkNotNullParameter(r9, "config");
            Intrinsics.checkNotNullParameter(r10, "subscriber");
            return f.a.b(r5, r6, r7, r8, r9, r10);
        }

        public static <S extends j, A, B, C> c c(JackView r6, JackViewModel<S> r7, KProperty1<S, ? extends A> r8, KProperty1<S, ? extends B> r9, KProperty1<S, ? extends C> r10, l<p<A, B, C>> r11, Function1<? super S, Unit> r12) {
            Intrinsics.checkNotNullParameter(r7, "$receiver");
            Intrinsics.checkNotNullParameter(r8, "prop1");
            Intrinsics.checkNotNullParameter(r9, "prop2");
            Intrinsics.checkNotNullParameter(r10, "prop3");
            Intrinsics.checkNotNullParameter(r11, "config");
            Intrinsics.checkNotNullParameter(r12, "subscriber");
            Intrinsics.checkNotNullParameter(r7, "$receiver");
            Intrinsics.checkNotNullParameter(r8, "prop1");
            Intrinsics.checkNotNullParameter(r9, "prop2");
            Intrinsics.checkNotNullParameter(r10, "prop3");
            Intrinsics.checkNotNullParameter(r11, "config");
            Intrinsics.checkNotNullParameter(r12, "subscriber");
            return f.a.c(r6, r7, r8, r9, r10, r11, r12);
        }
    }
}
