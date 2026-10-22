package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.model.IAudienceRecommendRoomResponse;
import com.bytedance.android.livesdk.chatroom.model.LinkmicAudienceRecommendItem;
import com.bytedance.android.livesdk.utils.f1;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements View.OnClickListener {
    public final /* synthetic */ LinkResultDialogFragmentV2 a;

    public b0(LinkResultDialogFragmentV2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r20) {
        int r1 = ((TextView) this.a.S90(2131390868)).getId();
        long r3 = 0;
        if (f1.a == r1) goto L5;
        f1.a = r1;
        f1.b = 0;
    L5:
        long r2 = System.currentTimeMillis();
        if ((r2 - f1.b) >= 1000) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == true) goto L11;
        f1.b = r2;
    L11:
        if (r5 == false) goto L14;
        IESUIUtils.displayToast(this.a.getContext(), "操作过于频繁，请稍后再试");
        return;
    L14:
        LinkResultDialogFragmentV2 r4 = this.a;
        r4.getClass();
        int r6 = wb6.b.a;
        long r7 = je0.d.a0();
        an0.b r8 = an0.b.a;
        uz0.e r9 = new uz0.e();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "$this$beforeConfigureRequest");
        Map r10 = r9.e;
        Intrinsics.checkNotNullParameter(r10, "fieldsMap");
        String r11 = Long.valueOf(r7).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r11 == null) goto L17;
        r10.put("room_id", r11);
    L17:
        Intrinsics.checkNotNullParameter(r9, "$this$afterConfigureRequest");
        Observable r12 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).L4(INetworkService.Biz.MultiLink, "/webcast/linkmic_audience/audience_recommend_room/", TypesJVMKt.getJavaType(Reflection.typeOf(IAudienceRecommendRoomResponse.class)), Extra.class, ((uz0.a) r9).d, ((uz0.a) r9).a, ((uz0.a) r9).b, ((uz0.a) r9).c, r9.e, r9.f, r9.g);
        int r13 = com.bytedance.revenue.platform.api.core.rx.p.a;
        Disposable r14 = r12.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(r4), new s(r4));
        if (r14 == null) goto L20;
        RxUtilKt.c(r14, r4.e);
    L20:
        int r15 = d0.a;
        LinkmicAudienceRecommendItem r16 = this.a.m;
        if (r16 == null) goto L25;
        Long r17 = r16.getRoomId();
        if (r17 == null) goto L25;
        r3 = r17.longValue();
    L25:
        long r18 = r3;
        LinkmicAudienceRecommendItem r19 = this.a.m;
        if (r19 == null) goto L33;
        IBaseUser r21 = r19.getAnchor();
        if (r21 == null) goto L33;
        String r22 = r21.getIdString();
        if (r22 == null) goto L33;
        String r23 = r22;
    L34:
        LinkmicAudienceRecommendItem r24 = this.a.m;
        if (r24 == null) goto L40;
        String r25 = r24.getText();
        if (r25 == null) goto L40;
        String r26 = r25;
    L41:
        LinkResultDialogFragmentV2 r27 = this.a;
        d0.d(r18, r23, r26, "more", r27.j, r27.l);
        return;
    L40:
        r26 = "";
    L33:
        r23 = "";
        goto L34
    L8:
        r5 = false;
        goto L9
    }
}
