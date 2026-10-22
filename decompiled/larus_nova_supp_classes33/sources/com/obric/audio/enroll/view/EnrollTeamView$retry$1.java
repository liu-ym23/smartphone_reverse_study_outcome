package com.obric.audio.enroll.view;

import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.view.EnrollTeamView", f = "EnrollTeamView.kt", i = {}, l = {886}, m = "retry", n = {}, s = {})
public final class EnrollTeamView$retry$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EnrollTeamView this$0;

    public EnrollTeamView$retry$1(EnrollTeamView r1, Continuation<? super EnrollTeamView$retry$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        EnrollTeamView r3 = this.this$0;
        Lazy<List<Integer>> r0 = EnrollTeamView.G;
        return r3.H6(this);
    }
}
