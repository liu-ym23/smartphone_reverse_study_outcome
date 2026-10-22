package com.bytedance.android.live.revlink.impl.multianchor.dialog;

import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.x;
import com.bytedance.live.datacontext.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class MultiLinkConfigManager$attach$1 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
    public MultiLinkConfigManager$attach$1(MultiLinkConfigManager r8) {
        super(1, r8, MultiLinkConfigManager.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
    }

    public final void invoke(yh6.c r7) {
        Intrinsics.checkNotNullParameter(r7, "p1");
        MultiLinkConfigManager r0 = (MultiLinkConfigManager) ((CallableReference) this).receiver;
        r0.getClass();
        if ((r7 instanceof h1) == false) goto L50;
        i6 r8 = ((vh7.c) r7).castTo(i6.class);
        if (((int) i1.c(r8)) != 50) goto L55;
        x r9 = r8.getAnchorUpdateLinkMicConfigContent();
        boolean r1 = true;
        MultiLinkAnchorControlContext r3 = null;
        if (r9 == null) goto L29;
        boolean r4 = r9.getForbidInviteByGeneral();
        com.bytedance.android.live.revlink.impl.global.c r5 = r0.e;
        if (r5 == null) goto L12;
        MultiLinkAnchorControlContext r6 = r5.ua();
    L13:
        if (r6 == null) goto L19;
        m<Boolean> r10 = r6.getForbidInvite();
        if (r10 == null) goto L19;
        if (((Boolean) r10.getValue()).booleanValue() != true) goto L19;
        boolean r12 = true;
    L20:
        if (r12 == r4) goto L29;
        com.bytedance.android.live.revlink.impl.global.c r13 = r0.e;
        if (r13 == null) goto L24;
        MultiLinkAnchorControlContext r14 = r13.ua();
    L25:
        if (r14 == null) goto L29;
        m<Boolean> r15 = r14.getForbidInvite();
        if (r15 == null) goto L29;
        r15.setValue(Boolean.valueOf(r4));
        goto L29
    L24:
        r14 = null;
    L19:
        r12 = false;
        goto L20
    L12:
        r6 = null;
    L29:
        if (r9 == null) goto L51;
        boolean r16 = r9.getForbidApplyFromOther();
        com.bytedance.android.live.revlink.impl.global.c r17 = r0.e;
        if (r17 == null) goto L33;
        MultiLinkAnchorControlContext r18 = r17.ua();
    L34:
        if (r18 == null) goto L40;
        m<Boolean> r19 = r18.getForbidApply();
        if (r19 == null) goto L40;
        if (((Boolean) r19.getValue()).booleanValue() != true) goto L40;
    L41:
        if (r1 == r16) goto L52;
        com.bytedance.android.live.revlink.impl.global.c r2 = r0.e;
        if (r2 == null) goto L45;
        r3 = r2.ua();
    L45:
        if (r3 == null) goto L53;
        m<Boolean> r20 = r3.getForbidApply();
        if (r20 == null) goto L54;
        r20.setValue(Boolean.valueOf(r16));
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L40:
        r1 = false;
        goto L41
    L33:
        r18 = null;
        goto L34
    L51:
        return;
    L55:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((yh6.c) r1);
        return Unit.INSTANCE;
    }
}
