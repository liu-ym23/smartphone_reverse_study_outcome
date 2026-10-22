package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nAssertionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AssertionsJVM.kt\nkotlin/PreconditionsKt__AssertionsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,39:1\n1#2:40\n*E\n"})
class PreconditionsKt__AssertionsJVMKt {
    public PreconditionsKt__AssertionsJVMKt() {
    }

    @InlineOnly
    /* JADX INFO: renamed from: assert, reason: not valid java name */
    private static final void m29assert(boolean r10) {
    }

    @InlineOnly
    /* JADX INFO: renamed from: assert, reason: not valid java name */
    private static final void m30assert(boolean r10, Function0<? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r11, "lazyMessage");
    }
}
