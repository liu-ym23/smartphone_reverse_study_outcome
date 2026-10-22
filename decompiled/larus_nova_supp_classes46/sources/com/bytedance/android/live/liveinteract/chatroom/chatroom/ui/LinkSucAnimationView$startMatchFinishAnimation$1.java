package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class LinkSucAnimationView$startMatchFinishAnimation$1 extends MutablePropertyReference0Impl {
    public LinkSucAnimationView$startMatchFinishAnimation$1(LinkSucAnimationView r7) {
        super(r7, LinkSucAnimationView.class, "taskEnd", "getTaskEnd()Lkotlin/jvm/functions/Function0;", 0);
    }

    public Object get() {
        return LinkSucAnimationView.f((LinkSucAnimationView) ((CallableReference) this).receiver);
    }

    public void set(Object r2) {
        Function0<Unit> r3 = (Function0) r2;
        ((LinkSucAnimationView) ((CallableReference) this).receiver).g = r3;
    }
}
