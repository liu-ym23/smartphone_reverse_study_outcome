package com.obric.miniapp.lynx;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MenuPopupLayoutUtilsKt$normalizeMenuSnapshotsToLocal$baseBounds$2 extends FunctionReferenceImpl implements Function1<l4, c6> {
    public static final MenuPopupLayoutUtilsKt$normalizeMenuSnapshotsToLocal$baseBounds$2 INSTANCE = null;

    static {
        INSTANCE = new MenuPopupLayoutUtilsKt$normalizeMenuSnapshotsToLocal$baseBounds$2();
    }

    public MenuPopupLayoutUtilsKt$normalizeMenuSnapshotsToLocal$baseBounds$2() {
        super(1, MenuPopupLayoutUtilsKt.class, "toResolvedBounds", "toResolvedBounds(Lcom/obric/miniapp/lynx/MenuContentSnapshot;)Lcom/obric/miniapp/lynx/ResolvedMenuBounds;", 1);
    }

    public final c6 invoke(l4 r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return MenuPopupLayoutUtilsKt.d(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((l4) r1);
    }
}
