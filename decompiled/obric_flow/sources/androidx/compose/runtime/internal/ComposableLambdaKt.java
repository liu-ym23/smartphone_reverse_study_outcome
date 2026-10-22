package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a \u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u0012\u001a\u00020\f*\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"BITS_PER_SLOT", "", "SLOTS_PER_INT", "bitsForSlot", "bits", "slot", "composableLambda", "Landroidx/compose/runtime/internal/ComposableLambda;", "composer", "Landroidx/compose/runtime/Composer;", STGroup.DICT_KEY, "tracked", "", "block", "", "composableLambdaInstance", "differentBits", "sameBits", "replacableWith", "Landroidx/compose/runtime/RecomposeScope;", "other", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComposableLambda.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposableLambda.kt\nandroidx/compose/runtime/internal/ComposableLambdaKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,353:1\n1#2:354\n*E\n"})
public final class ComposableLambdaKt {
    private static final int BITS_PER_SLOT = 3;
    public static final int SLOTS_PER_INT = 10;

    public static final int bitsForSlot(int r5, int r10) {
        return r5 << (((r10 % 10) * 3) + 1);
    }

    @ComposeCompilerApi
    public static final ComposableLambda composableLambda(Composer r5, int r10, boolean r11, Object r12) {
        Intrinsics.checkNotNullParameter(r5, "composer");
        Intrinsics.checkNotNullParameter(r12, "block");
        r5.startReplaceableGroup(r10);
        Object r13 = r5.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L5;
        ComposableLambdaImpl r14 = new ComposableLambdaImpl(r10, r11);
        r5.updateRememberedValue(r14);
    L6:
        r14.update(r12);
        r5.endReplaceableGroup();
        return r14;
    L5:
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
        r14 = (ComposableLambdaImpl) r13;
        goto L6
    }

    @ComposeCompilerApi
    public static final ComposableLambda composableLambdaInstance(int r5, boolean r10, Object r11) {
        Intrinsics.checkNotNullParameter(r11, "block");
        ComposableLambdaImpl r12 = new ComposableLambdaImpl(r5, r10);
        r12.update(r11);
        return r12;
    }

    public static final int differentBits(int r5) {
        return bitsForSlot(2, r5);
    }

    public static final boolean replacableWith(RecomposeScope r5, RecomposeScope r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        if (r5 != null) goto L5;
    L16:
        return true;
    L5:
        if ((r5 instanceof RecomposeScopeImpl) == true) goto L7;
    L15:
        return false;
    L7:
        if ((r10 instanceof RecomposeScopeImpl) == false) goto L15;
        RecomposeScopeImpl r11 = (RecomposeScopeImpl) r5;
        if (r11.getValid() == false) goto L16;
        if (Intrinsics.areEqual(r5, r10) == true) goto L16;
        if (Intrinsics.areEqual(r11.getAnchor(), ((RecomposeScopeImpl) r10).getAnchor()) == false) goto L15;
        goto L15
    }

    public static final int sameBits(int r5) {
        return bitsForSlot(1, r5);
    }
}
