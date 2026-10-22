package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k1;
import kotlinx.coroutines.l1;
import kotlinx.coroutines.v;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001a0\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000e\u001a:\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0010\u001aD\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0012\u001a>\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0014\"\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0015\u001aW\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001aM\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aC\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001aQ\u0010\u0016\u001a\u00020\u00062\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0014\"\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a9\u0010\u0016\u001a\u00020\u00062'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a\u001b\u0010 \u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060!H\u0007¢\u0006\u0002\u0010\"\u001a\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001\u001a&\u0010(\u001a\u00020\u00192\u0013\b\u0006\u0010)\u001a\r\u0012\u0004\u0012\u00020%0!¢\u0006\u0002\b*H\u0087\bø\u0001\u0001¢\u0006\u0002\u0010+\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006,"}, d2 = {"DisposableEffectNoParamError", "", "InternalDisposableEffectScope", "Landroidx/compose/runtime/DisposableEffectScope;", "LaunchedEffectNoParamError", "DisposableEffect", "", "effect", "Lkotlin/Function1;", "Landroidx/compose/runtime/DisposableEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key1", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "keys", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LaunchedEffect", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SideEffect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "createCompositionCoroutineScope", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "composer", "Landroidx/compose/runtime/Composer;", "rememberCoroutineScope", "getContext", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlinx/coroutines/CoroutineScope;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEffects.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Effects.kt\nandroidx/compose/runtime/EffectsKt\n+ 2 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 3 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,496:1\n36#2:497\n50#2:504\n49#2:505\n67#2,3:512\n66#2:515\n83#2,3:522\n36#2:531\n50#2:538\n49#2:539\n67#2,3:546\n66#2:549\n83#2,3:556\n25#2:565\n1097#3,6:498\n1097#3,6:506\n1097#3,6:516\n1097#3,6:525\n1097#3,6:532\n1097#3,6:540\n1097#3,6:550\n1097#3,6:559\n1097#3,6:566\n*S KotlinDebug\n*F\n+ 1 Effects.kt\nandroidx/compose/runtime/EffectsKt\n*L\n156#1:497\n196#1:504\n196#1:505\n237#1:512,3\n237#1:515\n277#1:522,3\n339#1:531\n362#1:538\n362#1:539\n386#1:546,3\n386#1:549\n419#1:556,3\n489#1:565\n156#1:498,6\n196#1:506,6\n237#1:516,6\n277#1:525,6\n339#1:532,6\n362#1:540,6\n386#1:550,6\n419#1:559,6\n489#1:566,6\n*E\n"})
public final class EffectsKt {
    private static final String DisposableEffectNoParamError = "DisposableEffect must provide one or more 'key' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.";
    private static final DisposableEffectScope InternalDisposableEffectScope = null;
    private static final String LaunchedEffectNoParamError = "LaunchedEffect must provide one or more 'key' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    static {
        InternalDisposableEffectScope = new DisposableEffectScope();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = DisposableEffectNoParamError)
    @Composable
    public static final void DisposableEffect(Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> r5, Composer r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "effect");
        r10.startReplaceableGroup(-904483903);
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-904483903, r11, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:116)");
    L6:
        throw new IllegalStateException(DisposableEffectNoParamError);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = LaunchedEffectNoParamError)
    @Composable
    public static final void LaunchedEffect(final Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r5, Composer r10, final int r11) {
        Intrinsics.checkNotNullParameter(r5, "block");
        Composer r12 = r10.startRestartGroup(-805415771);
        if ((r11 & 1) != 0) goto L13;
        if (r12.getSkipping() == false) goto L13;
        r12.skipToGroupEnd();
        ScopeUpdateScope r13 = r12.endRestartGroup();
        if (r13 == null) goto L17;
        r13.updateScope(new AnonymousClass1(r5, r11));
        return;
    L17:
        return;
    L13:
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventStart(-805415771, r11, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:315)");
    L16:
        throw new IllegalStateException(LaunchedEffectNoParamError);
    }

    @Composable
    public static final void SideEffect(Function0<Unit> r5, Composer r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "effect");
        r10.startReplaceableGroup(-1288466761);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1288466761, r11, -1, "androidx.compose.runtime.SideEffect (Effects.kt:45)");
    L5:
        r10.recordSideEffect(r5);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r10.endReplaceableGroup();
    }

    public static final /* synthetic */ DisposableEffectScope access$getInternalDisposableEffectScope$p() {
        return InternalDisposableEffectScope;
    }

    @PublishedApi
    public static final CoroutineScope createCompositionCoroutineScope(CoroutineContext r5, Composer r10) {
        Intrinsics.checkNotNullParameter(r5, "coroutineContext");
        Intrinsics.checkNotNullParameter(r10, "composer");
        k1 r11 = Job.Key;
        if (r5.get(r11) == null) goto L5;
        l1 r12 = new l1(null);
        r12.N(new v(false, new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job")));
        return h0.a(r12);
    L5:
        CoroutineContext r13 = r10.getApplyCoroutineContext();
        return h0.a(r13.plus(new l1((Job) r13.get(r11))).plus(r5));
    }

    @Composable
    public static final CoroutineScope rememberCoroutineScope(Function0<? extends CoroutineContext> r5, Composer r10, int r11, int r12) {
        r10.startReplaceableGroup(773894976);
        if ((r12 & 1) == 0) goto L5;
        r5 = C00521.INSTANCE;
    L5:
        r10.startReplaceableGroup(-492369756);
        Object r13 = r10.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L8;
        r13 = new CompositionScopedCoroutineScopeCanceller(createCompositionCoroutineScope(r5.invoke(), r10));
        r10.updateRememberedValue(r13);
    L8:
        r10.endReplaceableGroup();
        CoroutineScope r14 = ((CompositionScopedCoroutineScopeCanceller) r13).getCoroutineScope();
        r10.endReplaceableGroup();
        return r14;
    }

    @Composable
    public static final void DisposableEffect(Object r5, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "effect");
        r11.startReplaceableGroup(-1371986847);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1371986847, r12, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:151)");
    L5:
        r11.startReplaceableGroup(1157296644);
        boolean r13 = r11.changed(r5);
        Object r14 = r11.rememberedValue();
        if (r13 == false) goto L8;
    L9:
        r11.updateRememberedValue(new DisposableEffectImpl(r10));
    L10:
        r11.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r11.endReplaceableGroup();
        return;
    L8:
        if (r14 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    @Composable
    public static final void LaunchedEffect(Object r5, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "block");
        r11.startReplaceableGroup(1179185413);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1179185413, r12, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:333)");
    L5:
        CoroutineContext r13 = r11.getApplyCoroutineContext();
        r11.startReplaceableGroup(1157296644);
        boolean r14 = r11.changed(r5);
        Object r15 = r11.rememberedValue();
        if (r14 == false) goto L8;
    L9:
        r11.updateRememberedValue(new LaunchedEffectImpl(r13, r10));
    L10:
        r11.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r11.endReplaceableGroup();
        return;
    L8:
        if (r15 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    @Composable
    public static final void DisposableEffect(Object r5, Object r10, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> r11, Composer r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "effect");
        r12.startReplaceableGroup(1429097729);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1429097729, r13, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:190)");
    L5:
        r12.startReplaceableGroup(511388516);
        boolean r14 = r12.changed(r5) | r12.changed(r10);
        Object r15 = r12.rememberedValue();
        if (r14 == false) goto L8;
    L9:
        r12.updateRememberedValue(new DisposableEffectImpl(r11));
    L10:
        r12.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r12.endReplaceableGroup();
        return;
    L8:
        if (r15 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    @Composable
    public static final void LaunchedEffect(Object r5, Object r10, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r11, Composer r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "block");
        r12.startReplaceableGroup(590241125);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(590241125, r13, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:355)");
    L5:
        CoroutineContext r14 = r12.getApplyCoroutineContext();
        r12.startReplaceableGroup(511388516);
        boolean r15 = r12.changed(r5) | r12.changed(r10);
        Object r16 = r12.rememberedValue();
        if (r15 == false) goto L8;
    L9:
        r12.updateRememberedValue(new LaunchedEffectImpl(r14, r11));
    L10:
        r12.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r12.endReplaceableGroup();
        return;
    L8:
        if (r16 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    @Composable
    public static final void DisposableEffect(Object r5, Object r10, Object r11, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> r12, Composer r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "effect");
        r13.startReplaceableGroup(-1239538271);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1239538271, r14, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:230)");
    L5:
        r13.startReplaceableGroup(1618982084);
        boolean r15 = (r13.changed(r5) | r13.changed(r10)) | r13.changed(r11);
        Object r16 = r13.rememberedValue();
        if (r15 == false) goto L8;
    L9:
        r13.updateRememberedValue(new DisposableEffectImpl(r12));
    L10:
        r13.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r13.endReplaceableGroup();
        return;
    L8:
        if (r16 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    @Composable
    public static final void LaunchedEffect(Object r5, Object r10, Object r11, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r12, Composer r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "block");
        r13.startReplaceableGroup(-54093371);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-54093371, r14, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:378)");
    L5:
        CoroutineContext r15 = r13.getApplyCoroutineContext();
        r13.startReplaceableGroup(1618982084);
        boolean r16 = (r13.changed(r5) | r13.changed(r10)) | r13.changed(r11);
        Object r17 = r13.rememberedValue();
        if (r16 == false) goto L8;
    L9:
        r13.updateRememberedValue(new LaunchedEffectImpl(r15, r12));
    L10:
        r13.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        r13.endReplaceableGroup();
        return;
    L8:
        if (r17 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    @Composable
    public static final void DisposableEffect(Object[] r5, Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        Intrinsics.checkNotNullParameter(r10, "effect");
        r11.startReplaceableGroup(-1307627122);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1307627122, r12, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:272)");
    L5:
        Object[] r13 = Arrays.copyOf(r5, r5.length);
        r11.startReplaceableGroup(-568225417);
        int r14 = r13.length;
        int r15 = 0;
        boolean r16 = false;
    L6:
        if (r15 >= r14) goto L8;
        r16 = r16 | r11.changed(r13[r15]);
        r15 = r15 + 1;
        goto L6
    L8:
        Object r17 = r11.rememberedValue();
        if (r16 == false) goto L11;
    L12:
        r11.updateRememberedValue(new DisposableEffectImpl(r10));
    L13:
        r11.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
    L16:
        r11.endReplaceableGroup();
        return;
    L11:
        if (r17 != Composer.Companion.getEmpty()) goto L13;
        goto L12
    }

    @Composable
    public static final void LaunchedEffect(Object[] r5, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        Intrinsics.checkNotNullParameter(r10, "block");
        r11.startReplaceableGroup(-139560008);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-139560008, r12, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:413)");
    L5:
        CoroutineContext r13 = r11.getApplyCoroutineContext();
        Object[] r14 = Arrays.copyOf(r5, r5.length);
        r11.startReplaceableGroup(-568225417);
        int r15 = r14.length;
        int r16 = 0;
        boolean r17 = false;
    L6:
        if (r16 >= r15) goto L8;
        r17 = r17 | r11.changed(r14[r16]);
        r16 = r16 + 1;
        goto L6
    L8:
        Object r18 = r11.rememberedValue();
        if (r17 == false) goto L11;
    L12:
        r11.updateRememberedValue(new LaunchedEffectImpl(r13, r10));
    L13:
        r11.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
    L16:
        r11.endReplaceableGroup();
        return;
    L11:
        if (r18 != Composer.Companion.getEmpty()) goto L13;
        goto L12
    }
}
