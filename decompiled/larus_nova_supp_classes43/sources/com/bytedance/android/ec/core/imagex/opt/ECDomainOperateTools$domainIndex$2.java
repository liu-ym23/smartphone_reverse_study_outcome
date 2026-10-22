package com.bytedance.android.ec.core.imagex.opt;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECDomainOperateTools$domainIndex$2 extends Lambda implements Function0<Pair<? extends Integer, ? extends Integer>> {
    final /* synthetic */ q this$0;

    public ECDomainOperateTools$domainIndex$2(q r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Pair<Integer, Integer> m1320invoke() {
        this.this$0.getClass();
        Integer r1 = null;
        int r0 = StringsKt.indexOf$default(null, "://", 0, false, 6, null);
        if (r0 < 0) goto L5;
        Integer r10 = Integer.valueOf(r0);
    L6:
        if (r10 == null) goto L13;
        r10.intValue();
        this.this$0.getClass();
        int r11 = StringsKt.indexOf$default(null, "/", r10.intValue() + 3, false, 4, null);
        if (r11 <= 0) goto L10;
        r1 = Integer.valueOf(r11);
        goto L13
    L10:
        this.this$0.getClass();
        throw null;
    L13:
        return new Pair(r10, r1);
    L5:
        r10 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1320invoke();
    }
}
