package com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class LinkBackground$onReceiveBgUpdateEvent$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RectF $contentInScreen;
    final /* synthetic */ b this$0;

    public LinkBackground$onReceiveBgUpdateEvent$3(b r1, RectF r2) {
        this.$contentInScreen = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m683invoke() {
        b03.a r0 = b03.a.a;
        if (b03.a.b() == false) goto L6;
        int r1 = b.a;
        throw null;
    L6:
        jy0.b.d("LinkBackground", "notify onBgShowVertical");
        float r2 = this.$contentInScreen.top;
        int r3 = b.a;
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m683invoke();
        return Unit.INSTANCE;
    }
}
