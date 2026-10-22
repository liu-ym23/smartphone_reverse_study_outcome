package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.Composer;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007\u001a(\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\f"}, d2 = {"composableLambdaN", "Landroidx/compose/runtime/internal/ComposableLambdaN;", "composer", "Landroidx/compose/runtime/Composer;", STGroup.DICT_KEY, "", "tracked", "", "arity", "block", "", "composableLambdaNInstance", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComposableLambdaN.jvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComposableLambdaN.jvm.kt\nandroidx/compose/runtime/internal/ComposableLambdaN_jvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,179:1\n1#2:180\n*E\n"})
public final class ComposableLambdaN_jvmKt {
    @ComposeCompilerApi
    public static final ComposableLambdaN composableLambdaN(Composer r5, int r10, boolean r11, int r12, Object r13) {
        Intrinsics.checkNotNullParameter(r5, "composer");
        Intrinsics.checkNotNullParameter(r13, "block");
        r5.startReplaceableGroup(r10);
        Object r14 = r5.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L5;
        ComposableLambdaNImpl r15 = new ComposableLambdaNImpl(r10, r11, r12);
        r5.updateRememberedValue(r15);
    L6:
        r15.update(r13);
        r5.endReplaceableGroup();
        return r15;
    L5:
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaNImpl");
        r15 = (ComposableLambdaNImpl) r14;
        goto L6
    }

    @ComposeCompilerApi
    public static final ComposableLambdaN composableLambdaNInstance(int r5, boolean r10, int r11, Object r12) {
        Intrinsics.checkNotNullParameter(r12, "block");
        ComposableLambdaNImpl r13 = new ComposableLambdaNImpl(r5, r10, r11);
        r13.update(r12);
        return r13;
    }
}
