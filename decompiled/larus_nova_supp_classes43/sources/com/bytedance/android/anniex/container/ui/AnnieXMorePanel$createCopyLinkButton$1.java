package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXMorePanel$createCopyLinkButton$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ia.c $container;
    final /* synthetic */ Context $context;

    public AnnieXMorePanel$createCopyLinkButton$1(ia.c r1, Context r10) {
        this.$container = r1;
        this.$context = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m208invoke() {
        s26.d r0 = s26.d.c;
        if (s26.d.c.d(this.$container.getBid(), com.bytedance.android.anniex.base.service.a.class) == null) goto L6;
        Context r1 = this.$context;
        la.a r10 = new la.a(0);
        r10.a = this.$container.getCurrentUrl();
        com.bytedance.android.anniex.base.service.a.G0(r1, r10);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m208invoke();
        return Unit.INSTANCE;
    }
}
