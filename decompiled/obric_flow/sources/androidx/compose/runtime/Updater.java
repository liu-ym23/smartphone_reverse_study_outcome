package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J&\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0016¢\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u0019\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\u0002\b\u0016¢\u0006\u0004\b\u001a\u0010\u0018JI\u0010\u001b\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001c2,\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016¢\u0006\u0004\b!\u0010\"JK\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000f2.\b\b\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0001¢\u0006\u0004\b!\u0010#J\u0010\u0010$\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'JI\u0010(\u001a\u00020\u0013\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u0002H\u001c2,\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H\u001c¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016¢\u0006\u0004\b)\u0010\"JK\u0010(\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u000f2.\b\b\u0010\u0014\u001a(\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00130\u001e¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0001¢\u0006\u0004\b)\u0010#R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0004ø\u0001\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"Landroidx/compose/runtime/Updater;", ExifInterface.GPS_DIRECTION_TRUE, "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/Composer;)I", "init", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "reconcile", "reconcile-impl", "set", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "value", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "set-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Landroidx/compose/runtime/Composer;ILkotlin/jvm/functions/Function2;)V", "toString", "", "toString-impl", "(Landroidx/compose/runtime/Composer;)Ljava/lang/String;", "update", "update-impl", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Updater<T> {
    private final Composer composer;

    private /* synthetic */ Updater(Composer r5) {
        this.composer = r5;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Updater m29boximpl(Composer r5) {
        return new Updater(r5);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m30constructorimpl(Composer r5) {
        Intrinsics.checkNotNullParameter(r5, "composer");
        return r5;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m31equalsimpl(Composer r5, Object r10) {
        if ((r10 instanceof Updater) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r5, ((Updater) r10).m41unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m32equalsimpl0(Composer r5, Composer r10) {
        return Intrinsics.areEqual(r5, r10);
    }

    @PublishedApi
    public static /* synthetic */ void getComposer$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m33hashCodeimpl(Composer r5) {
        return r5.hashCode();
    }

    /* JADX INFO: renamed from: init-impl, reason: not valid java name */
    public static final void m34initimpl(Composer r5, final Function1<? super T, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        if (r5.getInserting() == false) goto L6;
        r5.apply(Unit.INSTANCE, new Updater$init$1(r10));
        return;
    }

    /* JADX INFO: renamed from: reconcile-impl, reason: not valid java name */
    public static final void m35reconcileimpl(Composer r5, final Function1<? super T, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        r5.apply(Unit.INSTANCE, new Updater$reconcile$1(r10));
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m36setimpl(Composer r5, int r10, Function2<? super T, ? super Integer, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        if (r5.getInserting() == false) goto L5;
    L6:
        r5.updateRememberedValue(Integer.valueOf(r10));
        r5.apply(Integer.valueOf(r10), r11);
        return;
    L5:
        if (Intrinsics.areEqual(r5.rememberedValue(), Integer.valueOf(r10)) == false) goto L6;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m38toStringimpl(Composer r5) {
        return "Updater(composer=" + r5 + ')';
    }

    /* JADX INFO: renamed from: update-impl, reason: not valid java name */
    public static final void m39updateimpl(Composer r5, int r10, Function2<? super T, ? super Integer, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        boolean r12 = r5.getInserting();
        if (r12 == false) goto L5;
    L6:
        r5.updateRememberedValue(Integer.valueOf(r10));
        if (r12 == true) goto L11;
        r5.apply(Integer.valueOf(r10), r11);
        return;
    L11:
        return;
    L5:
        if (Intrinsics.areEqual(r5.rememberedValue(), Integer.valueOf(r10)) == false) goto L6;
    }

    public boolean equals(Object r5) {
        return m31equalsimpl(this.composer, r5);
    }

    public int hashCode() {
        return m33hashCodeimpl(this.composer);
    }

    public String toString() {
        return m38toStringimpl(this.composer);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Composer m41unboximpl() {
        return this.composer;
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final <V> void m37setimpl(Composer r5, V r10, Function2<? super T, ? super V, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        if (r5.getInserting() == false) goto L5;
    L6:
        r5.updateRememberedValue(r10);
        r5.apply(r10, r11);
        return;
    L5:
        if (Intrinsics.areEqual(r5.rememberedValue(), r10) == false) goto L6;
    }

    /* JADX INFO: renamed from: update-impl, reason: not valid java name */
    public static final <V> void m40updateimpl(Composer r5, V r10, Function2<? super T, ? super V, Unit> r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        boolean r12 = r5.getInserting();
        if (r12 == false) goto L5;
    L6:
        r5.updateRememberedValue(r10);
        if (r12 == true) goto L11;
        r5.apply(r10, r11);
        return;
    L11:
        return;
    L5:
        if (Intrinsics.areEqual(r5.rememberedValue(), r10) == false) goto L6;
    }
}
