package com.ss.android.lark.keyboard.component;

import com.ss.android.lark.biz.im.api.extension.scroll.ScrollAlign;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollEvent;
import com.ss.android.lark.biz.im.api.extension.scroll.ScrollScene;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class KeyboardComponent$imeWrapperHeightChangeListener$1$onAnimateHeightChange$invokeScroll$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ KeyboardComponent this$0;

    public KeyboardComponent$imeWrapperHeightChangeListener$1$onAnimateHeightChange$invokeScroll$1(KeyboardComponent r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1047invoke() {
        this.this$0.getClass();
        ScrollScene r2 = ScrollScene.KEYBOARD;
        Intrinsics.checkNotNullParameter(r2, "scene");
        Function1 r3 = ScrollEvent.j;
        Intrinsics.checkNotNullParameter(r3, "value");
        ScrollAlign r5 = ScrollAlign.BOTTOM;
        Intrinsics.checkNotNullParameter(r5, "value");
        new ScrollEvent(r2, r3, null, r5, false, 0, new b(null));
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1047invoke();
        return Unit.INSTANCE;
    }
}
