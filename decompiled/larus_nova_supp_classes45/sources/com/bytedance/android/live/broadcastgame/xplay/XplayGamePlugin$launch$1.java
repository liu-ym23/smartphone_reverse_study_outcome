package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/l;", "", "invoke", "(Lcom/bytedance/android/live/broadcastgame/xplay/l;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class XplayGamePlugin$launch$1 extends Lambda implements Function1<l, Unit> {
    final /* synthetic */ u this$0;

    public XplayGamePlugin$launch$1(u r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(l r4) {
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        r4.b("pre check", new AnonymousClass1(this));
        com.bytedance.android.live.broadcastgame.api.xplay.p r0 = this.this$0.b;
        if (r0.f == XplayScene.TalkRoom) goto L5;
        return;
    L5:
        if (r0.d == false) goto L9;
        r4.b("request game start", new AnonymousClass2(this));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((l) r1);
        return Unit.INSTANCE;
    }
}
