package com.larus.bmhome.double_post.drag_panel;

import com.larus.bmhome.databinding.LarusPageChatBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c0<T> implements FlowCollector {
    public final /* synthetic */ LarusPageChatBinding a;
    public final /* synthetic */ ChatAwemeFeedComponent b;

    public c0(LarusPageChatBinding r1, ChatAwemeFeedComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object emit(Object r4, Continuation r5) {
        rr8.a r6 = (rr8.a) r4;
        this.a.b.setEnable(!Intrinsics.areEqual(r6.a, Boxing.boxBoolean(true)));
        if (Intrinsics.areEqual(r6.a, Boxing.boxBoolean(true)) == false) goto L5;
        ChatAwemeFeedComponent r7 = this.b;
        r7.R = "to_chat";
        ChatAwemeFeedComponent.C3(r7, false, 6);
        this.a.b.i(false);
    L5:
        this.a.b.i(true);
        return Unit.INSTANCE;
    }
}
