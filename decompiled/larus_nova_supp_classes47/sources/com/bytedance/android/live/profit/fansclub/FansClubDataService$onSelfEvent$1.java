package com.bytedance.android.live.profit.fansclub;

import com.bytedance.android.livesdk.message.model.f7;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/c;", "p1", "", "invoke", "(Lcom/bytedance/android/live/profit/fansclub/c;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class FansClubDataService$onSelfEvent$1 extends FunctionReferenceImpl implements Function1<c, Boolean> {
    public FansClubDataService$onSelfEvent$1(FansClubDataService r8) {
        super(1, r8, FansClubDataService.class, "filterOthersEvent", "filterOthersEvent(Lcom/bytedance/android/live/profit/fansclub/FansClubEvent;)Z", 0);
    }

    public final boolean invoke(c r9) {
        Intrinsics.checkNotNullParameter(r9, "p1");
        FansClubDataService r0 = (FansClubDataService) ((CallableReference) this).receiver;
        int r1 = FansClubDataService.h;
        r0.getClass();
        if ((r9 instanceof c.b) == false) goto L13;
        c.b r10 = (c.b) r9;
        if (r10.a.getIdString().length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r10.a.getIdString(), r0.e.getUser().getIdString()) == false) goto L27;
    L24:
        return true;
    L27:
        return false;
    L7:
        r2 = false;
        goto L8
    L13:
        if ((r9 instanceof c.a) == false) goto L24;
        c.a r12 = (c.a) r9;
        f7.b r3 = r12.a;
        if (r3 != null) goto L17;
    L18:
        f7.b r13 = r12.a;
        if (r13 == null) goto L21;
        String r14 = String.valueOf(r13.getUserId());
    L23:
        if (Intrinsics.areEqual(r14, r0.e.getUser().getIdString()) == true) goto L24;
        return false;
    L21:
        r14 = null;
        goto L23
    L17:
        if (r3.getUserId() != 0) goto L18;
        return false;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((c) r1));
    }
}
