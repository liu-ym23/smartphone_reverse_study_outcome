package okio.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
final class ZipFilesKt$openZip$1 extends Lambda implements Function1<f, Boolean> {
    public static final ZipFilesKt$openZip$1 INSTANCE = null;

    static {
        INSTANCE = new ZipFilesKt$openZip$1();
    }

    ZipFilesKt$openZip$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(f r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        return Boolean.TRUE;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(f r10) {
        return invoke2(r10);
    }
}
