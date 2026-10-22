package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.widget.SlideGuideView;
import com.bytedance.android.livesdk.config.tl;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v0<T> implements Consumer {
    public final /* synthetic */ RecordCompositeWidget a;

    public v0(RecordCompositeWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        RecordCompositeWidget r9 = this.a;
        r9.getClass();
        com.bytedance.android.livesdk.e.b().getClass();
        if (com.bytedance.android.livesdk.e.c() == true) goto L26;
        IBroadcastService r0 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r0 == null) goto L10;
        if (r0.isPlayingGame() != true) goto L10;
        return;
    L10:
        if (f22.a.a("broadcast_has_used_long_press") == true) goto L28;
        Boolean r1 = (Boolean) ((Widget) r9).dataCenter.get("from_promote_live", Boolean.FALSE);
        if (r1.booleanValue() == true) goto L15;
    L17:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r2 = r9.c;
        if (r2 == null) goto L30;
        SlideGuideView r3 = new SlideGuideView(r9.getContext());
        r9.e = r3;
        r3.d("ttlive_broadcast_record_long_press_guide.json", "recordimages/");
        if (r1.booleanValue() == false) goto L23;
        String r4 = "你正在参与全民任务\n长按屏幕可打开录屏";
    L24:
        r3.setDestText(r4);
        r3.setDestTextSize(24);
        r3.e();
        r3.setOnClickListener(new r0(r9));
        r3.setOnLongClickListener(new s0(r9));
        f22.a.d(f22.a.b() + 1);
        r2.af(r3);
        com.bytedance.android.livesdk.e.b().a();
        RxUtilKt.c(Single.timer(15000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new t0(r9), u0.a), r9.f);
        return;
    L23:
        r4 = "长按屏幕可以打开录屏";
        goto L24
    L30:
        return;
    L15:
        if (tl.a.getValue().c() != 1) goto L17;
        return;
    L28:
        return;
    }
}
