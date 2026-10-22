package com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class LinkBackground$onReceiveKmpBgUpdateEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $bottom;
    final /* synthetic */ String $bottomBgUrl;
    final /* synthetic */ boolean $isAnimBg;
    final /* synthetic */ int $top;
    final /* synthetic */ String $topBgUrl;
    final /* synthetic */ b this$0;

    public LinkBackground$onReceiveKmpBgUpdateEvent$1(b r1, int r2, int r3, String r4, String r5, boolean r6) {
        this.$top = r2;
        this.$bottom = r3;
        this.$topBgUrl = r4;
        this.$bottomBgUrl = r5;
        this.$isAnimBg = r6;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m685invoke() {
        jy0.b.d("LinkBackground", "notify onBgShowVertical");
        int r0 = b.a;
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m685invoke();
        return Unit.INSTANCE;
    }
}
