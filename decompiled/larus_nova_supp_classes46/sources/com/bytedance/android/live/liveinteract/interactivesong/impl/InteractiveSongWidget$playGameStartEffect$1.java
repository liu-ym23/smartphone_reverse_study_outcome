package com.bytedance.android.live.liveinteract.interactivesong.impl;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class InteractiveSongWidget$playGameStartEffect$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ InteractiveSongWidget this$0;

    public InteractiveSongWidget$playGameStartEffect$1(InteractiveSongWidget r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m142invoke() {
        HSImageView r0 = this.this$0.v;
        if (r0 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r0);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m142invoke();
        return Unit.INSTANCE;
    }
}
