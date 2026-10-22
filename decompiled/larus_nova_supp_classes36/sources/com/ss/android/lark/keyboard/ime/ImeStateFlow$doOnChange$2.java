package com.ss.android.lark.keyboard.ime;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "old", "Lcom/ss/android/lark/keyboard/ime/ImeStateDetail;", "new", "invoke", "(Lcom/ss/android/lark/keyboard/ime/ImeStateDetail;Lcom/ss/android/lark/keyboard/ime/ImeStateDetail;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImeStateFlow$doOnChange$2 extends Lambda implements Function2<ImeStateDetail, ImeStateDetail, Boolean> {
    final /* synthetic */ Function2<ImeStateDetail, ImeStateDetail, Unit> $collector;

    /* JADX WARN: Multi-variable type inference failed */
    public ImeStateFlow$doOnChange$2(Function2<? super ImeStateDetail, ? super ImeStateDetail, Unit> r1) {
        this.$collector = r1;
        super(2);
    }

    public final Boolean invoke(ImeStateDetail r2, ImeStateDetail r3) {
        Intrinsics.checkNotNullParameter(r2, "old");
        Intrinsics.checkNotNullParameter(r3, "new");
        if (r2 == r3) goto L6;
        this.$collector.invoke(r2, r3);
    L6:
        return Boolean.FALSE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ImeStateDetail) r1, (ImeStateDetail) r2);
    }
}
