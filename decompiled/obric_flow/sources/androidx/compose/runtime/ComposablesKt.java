package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ab\u0010\u0012\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u0015\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001f\u001aq\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\b!H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\"\u001a\u0097\u0001\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001e2$\b\b\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140$\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b!¢\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\b!H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010%\u001ab\u0010&\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u0015\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001f\u001aq\u0010&\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\b!H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\"\u001a\u0097\u0001\u0010&\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0014\"\u000e\b\u0001\u0010\u0016\u0018\u0001*\u0006\u0012\u0002\b\u00030\u00172\u000e\b\b\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\"\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140\u001c\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001e2$\b\b\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00140$\u0012\u0004\u0012\u00020\u00130\u001b¢\u0006\u0002\b!¢\u0006\u0002\b\u001e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\b!H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010%\u001a.\u0010'\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\b!H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010)\u001a.\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\u0013\b\u0004\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\u0002\b!H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010-\u001a\b\u0010.\u001a\u00020\u0013H\u0001\u001aB\u0010(\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0016\u0010/\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001500\"\u0004\u0018\u00010\u00152\u0011\u00101\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b!H\u0087\bø\u0001\u0000¢\u0006\u0002\u00102\u001a,\u00103\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0013\b\u0004\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b\u001dH\u0087\bø\u0001\u0000¢\u0006\u0002\u00105\u001a6\u00103\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\b\u00106\u001a\u0004\u0018\u00010\u00152\u0013\b\u0004\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b\u001dH\u0087\bø\u0001\u0000¢\u0006\u0002\u00107\u001a@\u00103\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\b\u00106\u001a\u0004\u0018\u00010\u00152\b\u00108\u001a\u0004\u0018\u00010\u00152\u0013\b\u0004\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b\u001dH\u0087\bø\u0001\u0000¢\u0006\u0002\u00109\u001aJ\u00103\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\b\u00106\u001a\u0004\u0018\u00010\u00152\b\u00108\u001a\u0004\u0018\u00010\u00152\b\u0010:\u001a\u0004\u0018\u00010\u00152\u0013\b\u0004\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b\u001dH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010;\u001aD\u00103\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u00142\u0016\u0010/\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001500\"\u0004\u0018\u00010\u00152\u0013\b\u0004\u00104\u001a\r\u0012\u0004\u0012\u0002H\u00140\u0019¢\u0006\u0002\b\u001dH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010<\u001a\r\u0010=\u001a\u00020>H\u0007¢\u0006\u0002\u0010?\"\u0011\u0010\u0000\u001a\u00020\u00018G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0017\u0010\b\u001a\u00020\t8G¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006@"}, d2 = {"currentComposer", "Landroidx/compose/runtime/Composer;", "getCurrentComposer", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/Composer;", "currentCompositeKeyHash", "", "getCurrentCompositeKeyHash", "(Landroidx/compose/runtime/Composer;I)I", "currentCompositionLocalContext", "Landroidx/compose/runtime/CompositionLocalContext;", "getCurrentCompositionLocalContext$annotations", "()V", "getCurrentCompositionLocalContext", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionLocalContext;", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getCurrentRecomposeScope", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/RecomposeScope;", "ComposeNode", "", ExifInterface.GPS_DIRECTION_TRUE, "", ExifInterface.LONGITUDE_EAST, "Landroidx/compose/runtime/Applier;", "factory", "Lkotlin/Function0;", "update", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Landroidx/compose/runtime/DisallowComposableCalls;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "skippableUpdate", "Landroidx/compose/runtime/SkippableUpdater;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ReusableComposeNode", "ReusableContent", STGroup.DICT_KEY, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ReusableContentHost", Constant.ClientMessageType.ACTIVE, "", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "invalidApplier", "keys", "", "block", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "remember", "calculation", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key1", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "rememberCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/CompositionContext;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComposables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n+ 2 Composer.kt\nandroidx/compose/runtime/ComposerKt\n*L\n1#1,484:1\n1097#2,6:485\n1097#2,6:491\n1097#2,6:497\n1097#2,6:503\n1097#2,6:509\n*S KotlinDebug\n*F\n+ 1 Composables.kt\nandroidx/compose/runtime/ComposablesKt\n*L\n25#1:485,6\n36#1:491,6\n49#1:497,6\n66#1:503,6\n85#1:509,6\n*E\n"})
public final class ComposablesKt {
    @Composable
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(final Function0<? extends T> r5, Function1<? super Updater<T>, Unit> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "factory");
        Intrinsics.checkNotNullParameter(r10, "update");
        r11.startReplaceableGroup(1886828752);
        Applier<?> r13 = r11.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (r13 != null) goto L5;
        invalidApplier();
    L5:
        r11.startNode();
        if (r11.getInserting() == false) goto L8;
        r11.createNode(new AnonymousClass1(r5));
    L9:
        r10.invoke(Updater.m29boximpl(Updater.m30constructorimpl(r11)));
        r11.endNode();
        r11.endReplaceableGroup();
        return;
    L8:
        r11.useNode();
        goto L9
    }

    @Composable
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(final Function0<? extends T> r5, Function1<? super Updater<T>, Unit> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "factory");
        Intrinsics.checkNotNullParameter(r10, "update");
        r11.startReplaceableGroup(1405779621);
        Applier<?> r13 = r11.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (r13 != null) goto L5;
        invalidApplier();
    L5:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L8;
        r11.createNode(new C00361(r5));
    L9:
        r10.invoke(Updater.m29boximpl(Updater.m30constructorimpl(r11)));
        r11.endNode();
        r11.endReplaceableGroup();
        return;
    L8:
        r11.useNode();
        goto L9
    }

    @Composable
    public static final void ReusableContent(Object r5, Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "content");
        r11.startReplaceableGroup(444418301);
        r11.startReusableGroup(ComposerKt.reuseKey, r5);
        r10.mo2invoke(r11, Integer.valueOf((r12 >> 3) & 14));
        r11.endReusableGroup();
        r11.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ReusableContentHost(boolean r5, Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "content");
        r11.startReusableGroup(ComposerKt.reuseKey, Boolean.valueOf(r5));
        boolean r13 = r11.changed(r5);
        if (r5 == false) goto L5;
        r10.mo2invoke(r11, Integer.valueOf((r12 >> 3) & 14));
    L6:
        r11.endReusableGroup();
        return;
    L5:
        r11.deactivateToEndGroup(r13);
        goto L6
    }

    @Composable
    @ReadOnlyComposable
    @JvmName(name = "getCurrentComposer")
    public static final Composer getCurrentComposer(Composer r5, int r10) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-554250212, r10, -1, "androidx.compose.runtime.<get-currentComposer> (Composables.kt:183)");
    L6:
        throw new NotImplementedError("Implemented as an intrinsic");
    }

    @Composable
    @JvmName(name = "getCurrentCompositeKeyHash")
    public static final int getCurrentCompositeKeyHash(Composer r5, int r10) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(524444915, r10, -1, "androidx.compose.runtime.<get-currentCompositeKeyHash> (Composables.kt:224)");
    L5:
        int r11 = r5.getCompoundKeyHash();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r11;
    }

    @Composable
    @JvmName(name = "getCurrentCompositionLocalContext")
    public static final CompositionLocalContext getCurrentCompositionLocalContext(Composer r5, int r10) {
        r5.startReplaceableGroup(-43352356);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-43352356, r10, -1, "androidx.compose.runtime.<get-currentCompositionLocalContext> (Composables.kt:207)");
    L5:
        CompositionLocalContext r11 = new CompositionLocalContext(r5.buildContext().getCompositionLocalScope$runtime_release());
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r5.endReplaceableGroup();
        return r11;
    }

    public static /* synthetic */ void getCurrentCompositionLocalContext$annotations() {
    }

    @Composable
    @ReadOnlyComposable
    @JvmName(name = "getCurrentRecomposeScope")
    public static final RecomposeScope getCurrentRecomposeScope(Composer r5, int r10) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(394957799, r10, -1, "androidx.compose.runtime.<get-currentRecomposeScope> (Composables.kt:192)");
    L5:
        RecomposeScope r11 = r5.getRecomposeScope();
        if (r11 == null) goto L12;
        r5.recordUsed(r11);
        if (ComposerKt.isTraceInProgress() == false) goto L10;
        ComposerKt.traceEventEnd();
    L10:
        return r11;
    L12:
        throw new IllegalStateException("no recompose scope found");
    }

    @PublishedApi
    public static final void invalidApplier() {
        throw new IllegalStateException("Invalid applier");
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> T key(Object[] r5, Function2<? super Composer, ? super Integer, ? extends T> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        Intrinsics.checkNotNullParameter(r10, "block");
        r11.startReplaceableGroup(-11941951);
        T r13 = r10.mo2invoke(r11, Integer.valueOf((r12 >> 3) & 14));
        r11.endReplaceableGroup();
        return r13;
    }

    @Composable
    public static final <T> T remember(Object r5, Function0<? extends T> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "calculation");
        r11.startReplaceableGroup(1157296644);
        boolean r13 = r11.changed(r5);
        T r14 = (T) r11.rememberedValue();
        if (r13 == false) goto L5;
    L6:
        r14 = r10.invoke();
        r11.updateRememberedValue(r14);
    L7:
        r11.endReplaceableGroup();
        return r14;
    L5:
        if (r14 != Composer.Companion.getEmpty()) goto L7;
        goto L6
    }

    @Composable
    public static final CompositionContext rememberCompositionContext(Composer r5, int r10) {
        r5.startReplaceableGroup(-1165786124);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1165786124, r10, -1, "androidx.compose.runtime.rememberCompositionContext (Composables.kt:480)");
    L5:
        CompositionContext r11 = r5.buildContext();
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r5.endReplaceableGroup();
        return r11;
    }

    @Composable
    public static final <T> T remember(Object r5, Object r10, Function0<? extends T> r11, Composer r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "calculation");
        r12.startReplaceableGroup(511388516);
        boolean r14 = r12.changed(r5) | r12.changed(r10);
        T r15 = (T) r12.rememberedValue();
        if (r14 == false) goto L5;
    L6:
        r15 = r11.invoke();
        r12.updateRememberedValue(r15);
    L7:
        r12.endReplaceableGroup();
        return r15;
    L5:
        if (r15 != Composer.Companion.getEmpty()) goto L7;
        goto L6
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(Function0<? extends T> r5, Function1<? super Updater<T>, Unit> r10, Function2<? super Composer, ? super Integer, Unit> r11, Composer r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "factory");
        Intrinsics.checkNotNullParameter(r10, "update");
        Intrinsics.checkNotNullParameter(r11, "content");
        r12.startReplaceableGroup(-548224868);
        Applier<?> r14 = r12.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (r14 != null) goto L5;
        invalidApplier();
    L5:
        r12.startNode();
        if (r12.getInserting() == false) goto L8;
        r12.createNode(r5);
    L9:
        r10.invoke(Updater.m29boximpl(Updater.m30constructorimpl(r12)));
        r11.mo2invoke(r12, Integer.valueOf((r13 >> 6) & 14));
        r12.endNode();
        r12.endReplaceableGroup();
        return;
    L8:
        r12.useNode();
        goto L9
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(Function0<? extends T> r5, Function1<? super Updater<T>, Unit> r10, Function2<? super Composer, ? super Integer, Unit> r11, Composer r12, int r13) {
        Intrinsics.checkNotNullParameter(r5, "factory");
        Intrinsics.checkNotNullParameter(r10, "update");
        Intrinsics.checkNotNullParameter(r11, "content");
        r12.startReplaceableGroup(-692256719);
        Applier<?> r14 = r12.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (r14 != null) goto L5;
        invalidApplier();
    L5:
        r12.startReusableNode();
        if (r12.getInserting() == false) goto L8;
        r12.createNode(r5);
    L9:
        r10.invoke(Updater.m29boximpl(Updater.m30constructorimpl(r12)));
        r11.mo2invoke(r12, Integer.valueOf((r13 >> 6) & 14));
        r12.endNode();
        r12.endReplaceableGroup();
        return;
    L8:
        r12.useNode();
        goto L9
    }

    @Composable
    public static final <T> T remember(Object r5, Object r10, Object r11, Function0<? extends T> r12, Composer r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "calculation");
        r13.startReplaceableGroup(1618982084);
        boolean r15 = (r13.changed(r5) | r13.changed(r10)) | r13.changed(r11);
        T r16 = (T) r13.rememberedValue();
        if (r15 == false) goto L5;
    L6:
        r16 = r12.invoke();
        r13.updateRememberedValue(r16);
    L7:
        r13.endReplaceableGroup();
        return r16;
    L5:
        if (r16 != Composer.Companion.getEmpty()) goto L7;
        goto L6
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(Function0<? extends T> r5, Function1<? super Updater<T>, Unit> r10, Function3<? super SkippableUpdater<T>, ? super Composer, ? super Integer, Unit> r11, Function2<? super Composer, ? super Integer, Unit> r12, Composer r13, int r14) {
        Intrinsics.checkNotNullParameter(r5, "factory");
        Intrinsics.checkNotNullParameter(r10, "update");
        Intrinsics.checkNotNullParameter(r11, "skippableUpdate");
        Intrinsics.checkNotNullParameter(r12, "content");
        Applier<?> r15 = r13.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (r15 != null) goto L5;
        invalidApplier();
    L5:
        r13.startNode();
        if (r13.getInserting() == false) goto L8;
        r13.createNode(r5);
    L9:
        r10.invoke(Updater.m29boximpl(Updater.m30constructorimpl(r13)));
        r11.invoke(SkippableUpdater.m21boximpl(SkippableUpdater.m22constructorimpl(r13)), r13, Integer.valueOf((r14 >> 3) & 112));
        r13.startReplaceableGroup(2058660585);
        r12.mo2invoke(r13, Integer.valueOf((r14 >> 9) & 14));
        r13.endReplaceableGroup();
        r13.endNode();
        return;
    L8:
        r13.useNode();
        goto L9
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(Function0<? extends T> r5, Function1<? super Updater<T>, Unit> r10, Function3<? super SkippableUpdater<T>, ? super Composer, ? super Integer, Unit> r11, Function2<? super Composer, ? super Integer, Unit> r12, Composer r13, int r14) {
        Intrinsics.checkNotNullParameter(r5, "factory");
        Intrinsics.checkNotNullParameter(r10, "update");
        Intrinsics.checkNotNullParameter(r11, "skippableUpdate");
        Intrinsics.checkNotNullParameter(r12, "content");
        Applier<?> r15 = r13.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (r15 != null) goto L5;
        invalidApplier();
    L5:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L8;
        r13.createNode(r5);
    L9:
        r10.invoke(Updater.m29boximpl(Updater.m30constructorimpl(r13)));
        r11.invoke(SkippableUpdater.m21boximpl(SkippableUpdater.m22constructorimpl(r13)), r13, Integer.valueOf((r14 >> 3) & 112));
        r13.startReplaceableGroup(2058660585);
        r12.mo2invoke(r13, Integer.valueOf((r14 >> 9) & 14));
        r13.endReplaceableGroup();
        r13.endNode();
        return;
    L8:
        r13.useNode();
        goto L9
    }

    @Composable
    public static final <T> T remember(Object[] r5, Function0<? extends T> r10, Composer r11, int r12) {
        Intrinsics.checkNotNullParameter(r5, "keys");
        Intrinsics.checkNotNullParameter(r10, "calculation");
        r11.startReplaceableGroup(-568225417);
        int r13 = r5.length;
        int r14 = 0;
        boolean r15 = false;
    L3:
        if (r14 >= r13) goto L5;
        r15 = r15 | r11.changed(r5[r14]);
        r14 = r14 + 1;
        goto L3
    L5:
        T r16 = (T) r11.rememberedValue();
        if (r15 == false) goto L8;
    L9:
        r16 = r10.invoke();
        r11.updateRememberedValue(r16);
    L10:
        r11.endReplaceableGroup();
        return r16;
    L8:
        if (r16 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    @Composable
    public static final <T> T remember(Function0<? extends T> r5, Composer r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "calculation");
        r10.startReplaceableGroup(-492369756);
        T r12 = (T) r10.rememberedValue();
        if (r12 != Composer.Companion.getEmpty()) goto L5;
        r12 = r5.invoke();
        r10.updateRememberedValue(r12);
    L5:
        r10.endReplaceableGroup();
        return r12;
    }
}
