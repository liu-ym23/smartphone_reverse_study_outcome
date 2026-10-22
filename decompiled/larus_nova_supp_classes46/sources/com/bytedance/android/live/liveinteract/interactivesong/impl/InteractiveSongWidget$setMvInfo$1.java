package com.bytedance.android.live.liveinteract.interactivesong.impl;

import com.bytedance.android.live.liveinteract.interactivesong.panel.InteractiveSongMvManager;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVBaseInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.IOrderSingMVInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
final class InteractiveSongWidget$setMvInfo$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ InteractiveSongWidget this$0;

    public InteractiveSongWidget$setMvInfo$1(InteractiveSongWidget r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m143invoke() {
        InteractiveSongWidget r0 = this.this$0;
        int r1 = InteractiveSongWidget.C;
        r0.getClass();
        InteractiveSongWidget r2 = this.this$0;
        InteractiveSongMvManager r3 = r2.x;
        String r4 = "";
        if (r3 == null) goto L10;
        IOrderSingMVInfo r5 = r3.g;
        if (r5 == null) goto L10;
        IMVBaseInfo r6 = r5.getMvBaseInfo();
        if (r6 == null) goto L10;
        String r7 = r6.getVid();
        if (r7 == null) goto L10;
    L11:
        InteractiveSongContext r8 = InteractiveSongContext.Companion.getContext();
        if (r8 == null) goto L17;
        String r9 = r8.getCurOrderSongItemId();
        if (r9 == null) goto L17;
        r4 = r9;
    L17:
        of0.b.a.a(r2, r7, r4, "manual");
        return;
    L10:
        r7 = "";
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m143invoke();
        return Unit.INSTANCE;
    }
}
