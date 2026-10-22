package com.bytedance.android.ec.ab.opt;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0082@"}, d2 = {"Config", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "defaultLocalConfigInit"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.ab.opt.LazyOptGetSettings", f = "LazyOptSettings.kt", i = {}, l = {48}, m = "defaultLocalConfigInit", n = {}, s = {})
final class LazyOptGetSettings$defaultLocalConfigInit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LazyOptGetSettings this$0;

    public LazyOptGetSettings$defaultLocalConfigInit$1(LazyOptGetSettings r1, Continuation r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return LazyOptGetSettings.a(this.this$0, this);
    }
}
