package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.app.Activity;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"openHandle", "", "url", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveMgMountContextService$showStarAtlasAgreementDialog$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ LiveMgMountContextService$showStarAtlasAgreementDialog$1 $reportClick$1;

    public LiveMgMountContextService$showStarAtlasAgreementDialog$2(LiveMgMountContextService$showStarAtlasAgreementDialog$1 r1) {
        this.$reportClick$1 = r1;
        super(1);
    }

    public final void invoke(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Activity r0 = jc1.k.n(IHostApp.class).getTopActivity();
        jc1.k.n(IBaseLiveActionHandler.class).handle(r0, r3);
        this.$reportClick$1.invoke("knowmore");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
