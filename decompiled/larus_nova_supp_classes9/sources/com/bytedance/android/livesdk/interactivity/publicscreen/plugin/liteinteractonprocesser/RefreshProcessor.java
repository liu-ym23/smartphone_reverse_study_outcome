package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.k;
import com.bytedance.android.livesdkapi.message.TextPiece;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RefreshProcessor extends a {
    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final String a() {
        return "RefreshProcessor";
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final boolean b(long r4) {
        if (r4 != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public RefreshProcessor() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.plugin.liteinteractonprocesser.a
    public final void c(final t42.a r4, com.bytedance.android.live.base.model.liteinteraction.a r5, CompositeDisposable r6) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "actions");
        Intrinsics.checkNotNullParameter(r6, "cd");
        final t42.b r7 = r4.a;
        if (r7 != null) goto L6;
        int r8 = k.a;
        Intrinsics.checkNotNullParameter("RefreshProcessor, messageData is null", "msg");
        ALogger.e("LiteInteractionHelper", "RefreshProcessor, messageData is null");
        return;
    L6:
        final TextPiece r9 = r5.b();
        if (r9 != null) goto L10;
        int r10 = k.a;
        Intrinsics.checkNotNullParameter("RefreshProcessor, piece is null", "msg");
        ALogger.e("LiteInteractionHelper", "RefreshProcessor, piece is null");
        return;
    L10:
        int r0 = k.a;
        k.a("processAfterClickText, piece is " + r9);
        b r1 = this.a;
        if (r1 == null) goto L14;
        r1.c(new RefreshProcessor$process$1(r7), new RefreshProcessor$process$2(r7, r4, r9));
        return;
    }
}
