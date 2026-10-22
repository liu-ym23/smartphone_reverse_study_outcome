package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import com.bytedance.android.live.openplatform.impl.base.utils.w;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/utils/w;", "", "invoke", "(Lcom/bytedance/android/live/openplatform/impl/base/utils/w;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class AudienceExplainCardContextService$hideExplainCard$1 extends Lambda implements Function1<w, Unit> {
    final /* synthetic */ boolean $byUser;
    final /* synthetic */ AudienceExplainCardWidget $widget;
    final /* synthetic */ AudienceExplainCardContextService this$0;

    public AudienceExplainCardContextService$hideExplainCard$1(AudienceExplainCardContextService r1, AudienceExplainCardWidget r2, boolean r3) {
        this.this$0 = r1;
        this.$widget = r2;
        this.$byUser = r3;
        super(1);
    }

    public final void invoke(final w r6) {
        Intrinsics.checkNotNullParameter(r6, "$receiver");
        qo0.a.c("AudienceExplainCardContextService", "hide explain card");
        if (this.$widget.c == false) goto L9;
        r6.a("hide explain card", new AnonymousClass1(this));
        r6.a("dismiss widget", new AnonymousClass2(this));
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        j r1 = r0.getToolbarBubbleManager();
        if (r1 == null) goto L9;
        r1.c(new AnonymousClass3(r6));
    L9:
        r6.b();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((w) r1);
        return Unit.INSTANCE;
    }
}
