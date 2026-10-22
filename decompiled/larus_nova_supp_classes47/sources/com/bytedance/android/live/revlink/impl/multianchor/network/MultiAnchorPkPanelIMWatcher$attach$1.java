package com.bytedance.android.live.revlink.impl.multianchor.network;

import com.bytedance.android.livesdk.link.model.IBattleConfigSetting;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.e7;
import com.bytedance.android.livesdk.link.model.f7;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.y5;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class MultiAnchorPkPanelIMWatcher$attach$1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
    public MultiAnchorPkPanelIMWatcher$attach$1(f r8) {
        super(1, r8, f.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
    }

    public final void invoke(yh6.c r5) {
        Intrinsics.checkNotNullParameter(r5, "p1");
        f r0 = (f) ((CallableReference) this).receiver;
        r0.getClass();
        if ((r5 instanceof h1) == false) goto L29;
        i6 r6 = ((h1) r5).castTo(i6.class);
        if (((int) r6.getType2()) != 42) goto L30;
        y5 r7 = r6.getLinkerChangeMultiPkTeamInfoContent();
        IBattleConfigSetting r1 = r0.a;
        if (r7 == null) goto L11;
        e7 r2 = r7.getMultiPKModeInfo();
        if (r2 == null) goto L11;
        IBattleConfigSetting r3 = f7.a(r2);
    L13:
        if (com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.f.a(r1, r3) == false) goto L31;
        if (r7 == null) goto L32;
        e7 r8 = r7.getMultiPKModeInfo();
        if (r8 != null) goto L18;
        return;
    L18:
        if (r8.getModeTab() != 1) goto L22;
        a r4 = r0.c;
        if (r4 == null) goto L22;
        r4.a(r8.getVersion());
    L22:
        Intrinsics.checkNotNullParameter(r8, "$this$userIdToTeamId");
        Map<String, Long> r9 = r8.getRevUserIdToTeamId();
        if (r8.getModeTab() != 2) goto L34;
        if (r9 == null) goto L35;
        a r10 = r0.c;
        if (r10 == null) goto L36;
        r10.c(r8.getVersion(), r9);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L32:
        return;
    L31:
        return;
    L11:
        r3 = null;
        goto L13
    L30:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yh6.c) r1);
        return Unit.INSTANCE;
    }
}
