package com.bytedance.android.live.openplatform.impl.miniappaudience.shelf;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.livesdk.message.model.dm;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends ro0.b<dm> {
    public final MessageType d;

    @Override // ro0.b
    public final MessageType a() {
        return this.d;
    }

    public a(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.d = MessageType.TOOLBAR_CONTROL_MESSAGE;
    }

    @Override // ro0.b
    public final void b(tlc.d r5) {
        dm r6 = (dm) r5;
        Intrinsics.checkNotNullParameter(r6, MultiLinkOpenSource.MESSAGE);
        if (r6.getComponentType() != 3) goto L25;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r7 = Result.constructor-impl((com.bytedance.android.live.openplatform.api.model.shelf.c) GsonHelper.get().fromJson(r6.getExtraData(), com.bytedance.android.live.openplatform.api.model.shelf.c.class));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r7) == false) goto L12;
        r7 = null;
    L12:
        com.bytedance.android.live.openplatform.api.model.shelf.c r8 = (com.bytedance.android.live.openplatform.api.model.shelf.c) r7;
        if (r8 == null) goto L23;
        ShelfInfo r9 = r8.shelfInfo;
        if (r9 != null) goto L18;
        return;
    L18:
        if (r9.status != 3) goto L24;
        ((AudienceShelfInfoService) this.b.getService(AudienceShelfInfoService.class)).j();
        return;
    L24:
        return;
    L23:
        return;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
