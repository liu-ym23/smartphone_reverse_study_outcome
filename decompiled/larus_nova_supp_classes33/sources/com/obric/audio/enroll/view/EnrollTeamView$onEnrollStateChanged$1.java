package com.obric.audio.enroll.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.view.EnrollTeamView", f = "EnrollTeamView.kt", i = {}, l = {773, 848}, m = "onEnrollStateChanged", n = {}, s = {})
final class EnrollTeamView$onEnrollStateChanged$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnrollTeamView this$0;

    public EnrollTeamView$onEnrollStateChanged$1(EnrollTeamView r1, Continuation<? super EnrollTeamView$onEnrollStateChanged$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return EnrollTeamView.S5(this.this$0, null, null, this);
    }
}
