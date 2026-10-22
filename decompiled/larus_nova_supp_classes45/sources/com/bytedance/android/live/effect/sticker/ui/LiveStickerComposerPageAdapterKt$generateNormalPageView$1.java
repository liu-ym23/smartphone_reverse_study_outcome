package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "index", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveStickerComposerPageAdapterKt$generateNormalPageView$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ View $normalPageView;

    public LiveStickerComposerPageAdapterKt$generateNormalPageView$1(View r1) {
        this.$normalPageView = r1;
        super(1);
    }

    public final void invoke(int r3) {
        View r0 = this.$normalPageView;     // Catch: Exception -> L8
        if (r0 == null) goto L13;
        RecyclerView r1 = r0.findViewById(2131367812);     // Catch: Exception -> L8
        if (r1 == null) goto L14;
        r1.scrollToPosition(r3);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        int r2 = x8.a.a;
        int r4 = LiveStickerComposerPageAdapterKt.a;
        x8.a.b("ttlive_anchor_effect_LiveStickerComposerPageAdapterKt", e.toString(), false);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Number) r1).intValue());
        return Unit.INSTANCE;
    }
}
