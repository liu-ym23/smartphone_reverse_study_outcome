package com.bytedance.android.annie;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieInner$innerGetHybridCard$1$showErrorPage$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Uri $uri;
    final /* synthetic */ b this$0;

    public AnnieInner$innerGetHybridCard$1$showErrorPage$1(Uri r1, b r10) {
        this.$uri = r1;
        this.this$0 = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m83invoke() {
        ((v9.c) Annie.getService$default(v9.c.class, null, 2, null)).X0(this.$uri.toString(), this.this$0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m83invoke();
        return Unit.INSTANCE;
    }
}
