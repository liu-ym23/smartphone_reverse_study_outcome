package com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class LinkBackground$onReceiveBgUpdateEvent$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RectF $contentInScreen;
    final /* synthetic */ b this$0;

    public LinkBackground$onReceiveBgUpdateEvent$2(b r1, RectF r2) {
        this.$contentInScreen = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m682invoke() {
        jy0.b.d("LinkBackground", "notify onBgShowVertical");
        RectF r0 = this.$contentInScreen;
        float r1 = r0.top;
        float r2 = r0.bottom;
        d51.c r3 = d51.c.A0;
        r3.k();
        r3.j();
        int r4 = b.a;
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m682invoke();
        return Unit.INSTANCE;
    }
}
