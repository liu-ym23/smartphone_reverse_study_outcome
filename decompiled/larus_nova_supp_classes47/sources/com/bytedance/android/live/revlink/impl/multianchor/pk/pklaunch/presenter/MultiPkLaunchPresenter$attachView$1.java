package com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.presenter;

import android.text.TextUtils;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.global.b;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchContext;
import com.bytedance.android.live.revlink.impl.multianchor.utils.z;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.e7;
import com.bytedance.android.livesdk.link.model.f7;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.y5;
import com.bytedance.android.livesdk.message.model.qj;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import yh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", "invoke", "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class MultiPkLaunchPresenter$attachView$1 extends FunctionReferenceImpl implements Function1<c, Unit> {
    public MultiPkLaunchPresenter$attachView$1(MultiPkLaunchPresenter r8) {
        super(1, r8, MultiPkLaunchPresenter.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
    }

    public final void invoke(c r7) {
        Intrinsics.checkNotNullParameter(r7, "p1");
        ((MultiPkLaunchPresenter) ((CallableReference) this).receiver).getClass();
        if ((r7 instanceof h1) == false) goto L34;
        i6 r8 = ((h1) r7).castTo(i6.class);
        if (((int) r8.getType2()) != 42) goto L35;
        z r0 = b.J();
        if (r0 == null) goto L21;
        Intrinsics.checkNotNullParameter(r8, Constants.OperatorKey.MSG);
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("msg_id", String.valueOf(qj.a(r8)));
        y5 r2 = r8.getLinkerChangeMultiPkTeamInfoContent();
        if (r2 == null) goto L20;
        e7 r3 = r2.getMultiPKModeInfo();
        String r4 = "";
        if (r3 == null) goto L14;
        String r5 = f7.b(r3);
        if (r5 == null) goto L14;
    L15:
        r1.put("pk_mode_info", r5);
        String r6 = r2.getToast();
        if (r6 == null) goto L19;
        r4 = r6;
    L19:
        r1.put("toast", r4);
    L14:
        r5 = "";
    L20:
        z.y(r0, "receive_multi_pk_mode_change_msg", r1, null, 12);
    L21:
        y5 r9 = r8.getLinkerChangeMultiPkTeamInfoContent();
        if (r9 != null) goto L25;
        return;
    L25:
        if (r9.getMultiPKModeInfo() == null) goto L38;
        String r10 = r9.getToast();
        MultiAnchorPkLaunchContext r12 = b.x();
        if (r12 == null) goto L31;
        r12.updateMultiPkModeInfo(r9.getMultiPKModeInfo(), r10, "changeMsg", r9.getShowModeTab());
    L31:
        if (TextUtils.isEmpty(r10) == true) goto L36;
        ToastUtil.b(r10, 0);
        return;
    L36:
        return;
    L38:
        return;
    L35:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((c) r1);
        return Unit.INSTANCE;
    }
}
