package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a<\u0010\u0000\u001a\u00020\u00012\u001a\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t\"\u0006\u0012\u0002\b\u00030\n2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001a0\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0005\u001a \u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0005¨\u0006\u0013"}, d2 = {"CompositionLocalProvider", "", "context", "Landroidx/compose/runtime/CompositionLocalContext;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionLocalContext;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "([Landroidx/compose/runtime/ProvidedValue;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "compositionLocalOf", "Landroidx/compose/runtime/ProvidableCompositionLocal;", ExifInterface.GPS_DIRECTION_TRUE, "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "defaultFactory", "staticCompositionLocalOf", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCompositionLocal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocalKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,255:1\n125#2:256\n152#2,3:257\n37#3,2:260\n*S KotlinDebug\n*F\n+ 1 CompositionLocal.kt\nandroidx/compose/runtime/CompositionLocalKt\n*L\n250#1:256\n250#1:257,3\n251#1:260,2\n*E\n"})
public final class CompositionLocalKt {
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void CompositionLocalProvider(final ProvidedValue<?>[] r5, final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12) {
        Intrinsics.checkNotNullParameter(r5, "values");
        Intrinsics.checkNotNullParameter(r10, "content");
        Composer r13 = r11.startRestartGroup(-1390796515);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1390796515, r12, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:225)");
    L5:
        r13.startProviders(r5);
        r10.mo2invoke(r13, Integer.valueOf((r12 >> 3) & 14));
        r13.endProviders();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L13;
        r14.updateScope(new AnonymousClass1(r5, r10, r12));
        return;
    }

    public static final <T> ProvidableCompositionLocal<T> compositionLocalOf(SnapshotMutationPolicy<T> r5, Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "policy");
        Intrinsics.checkNotNullParameter(r10, "defaultFactory");
        return new DynamicProvidableCompositionLocal(r5, r10);
    }

    public static /* synthetic */ ProvidableCompositionLocal compositionLocalOf$default(SnapshotMutationPolicy r5, Function0 r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = SnapshotStateKt.structuralEqualityPolicy();
    L6:
        return compositionLocalOf(r5, r10);
    }

    public static final <T> ProvidableCompositionLocal<T> staticCompositionLocalOf(Function0<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "defaultFactory");
        return new StaticProvidableCompositionLocal(r5);
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void CompositionLocalProvider(final CompositionLocalContext r10, final Function2<? super Composer, ? super Integer, Unit> r11, Composer r12, final int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "content");
        Composer r14 = r12.startRestartGroup(1853897736);
        if ((r13 & 14) == 0) goto L5;
        int r5 = r13;
    L11:
        if ((r13 & 112) != 0) goto L18;
        if (r14.changedInstance(r11) == false) goto L15;
        int r15 = 32;
    L16:
        r5 = r5 | r15;
        goto L18
    L15:
        r15 = 16;
    L18:
        if ((r5 & 91) != 18) goto L24;
        if (r14.getSkipping() == false) goto L24;
        r14.skipToGroupEnd();
    L33:
        ScopeUpdateScope r16 = r14.endRestartGroup();
        if (r16 == null) goto L39;
        r16.updateScope(new AnonymousClass3(r10, r11, r13));
        return;
    L39:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(1853897736, r5, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:246)");
    L26:
        PersistentCompositionLocalMap r17 = r10.getCompositionLocals$runtime_release();
        ArrayList r18 = new ArrayList(r17.size());
        Iterator<Map.Entry<CompositionLocal<Object>, State<? extends Object>>> r19 = r17.entrySet().iterator();
    L28:
        if (r19.hasNext() == false) goto L30;
        Map.Entry<CompositionLocal<Object>, State<? extends Object>> r20 = r19.next();
        CompositionLocal<Object> r21 = r20.getKey();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type androidx.compose.runtime.ProvidableCompositionLocal<kotlin.Any?>");
        r18.add(((ProvidableCompositionLocal) r21).provides(r20.getValue().getValue()));
        goto L28
    L30:
        ProvidedValue[] r22 = (ProvidedValue[]) r18.toArray(new ProvidedValue[0]);
        CompositionLocalProvider((ProvidedValue[]) Arrays.copyOf(r22, r22.length), r11, r14, (r5 & 112) | 8);
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
        goto L33
    L5:
        if (r14.changed(r10) == false) goto L7;
        int r23 = 4;
    L8:
        r5 = r23 | r13;
        goto L11
    L7:
        r23 = 2;
        goto L8
    }
}
