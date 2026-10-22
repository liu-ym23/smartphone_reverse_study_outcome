package com.bytedance.android.livesdk.gameguess.toolbar;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.android.livesdk.gameguess.api.PredictorGuessApi;
import com.bytedance.android.livesdk.gameguess.widget.GameGuessPredictorWidget;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ToolbarPredictorBehavior implements c0.b, Observer<KVData> {
    public final Context a;
    public DataCenter b;
    public View c;
    public TextView d;
    public xx1.a e;
    public CountDownTimer f;
    public ViewGroup g;
    public boolean h;
    public final CompositeDisposable i;

    public class a extends CountDownTimer {
        public final /* synthetic */ ToolbarPredictorBehavior a;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            TextView r0 = this.a.d;
            if (r0 == null) goto L5;
            r0.setVisibility(8);
            this.a.d.setText("");
        L5:
            ToolbarPredictorBehavior r1 = this.a;
            xx1.a r2 = r1.e;
            if (r2 == null) goto L9;
            r1.c(((GameGuessPredictorWidget.a) r2).a());
            return;
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r4) {
            TextView r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.setText(p6.a(r4 / 1000));
            return;
        }

        public a(ToolbarPredictorBehavior r3, long r4) {
            this.a = r3;
            super(r4, 1000);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void a() {
        final Room r0 = (Room) this.b.get("data_room", null);
        if (r0 == null) goto L8;
        Disposable r1 = ((PredictorGuessApi) com.bytedance.android.live.network.c.b().e(PredictorGuessApi.class)).requestIsGameRoomByMergeTag(r0.getId() + "", ((Boolean) this.b.get("data_is_anchor", Boolean.FALSE)).booleanValue(), PredictorGuessApi.b).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r0), new d(this));
        CompositeDisposable r2 = this.i;
        if (r2 == null) goto L9;
        r2.add(r1);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.k;
    }

    public static void b(DataCenter r6) {
        if (r6 == null) goto L10;
        Room r0 = (Room) r6.get("data_room", null);
        boolean r1 = ((Boolean) r6.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        if (r0 == null) goto L11;
        HashMap r2 = new HashMap();
        r2.put("anchor_id", r0.getOwnerUserIdString());
        r2.put("room_id", r0.getId() + "");
        r2.put("enter_from", "interaction");
        if (((Boolean) r6.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L8;
        u.l().sendLog("livesdk_anchor_prediction_entrance_show", r2, new Object[0]);
        return;
    L8:
        r2.put("liveroom_orientation", (!r1 ? 1 : 0) + "");
        u.l().sendLog("livesdk_user_prediction_entrance_show", r2, new Object[0]);
        return;
    L11:
        return;
    }

    public final void c(long r5) {
        TextView r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L10;
        r0.setVisibility(0);
        this.f = new a(this, r5 * 1000).start();
        return;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4.getKey()) == false) goto L7;
        return;
    L7:
        if (r4.getData() == null) goto L29;
        String r5 = r4.getKey();
        r5.getClass();
        if (r5.equals("data_predictor_more_entrance_shwo") == false) goto L12;
        b(this.b);
        return;
    L12:
        if (r5.equals("data_predictor_info_change") == true) goto L15;
        return;
    L15:
        if (this.e == null) goto L27;
        CountDownTimer r6 = this.f;
        if (r6 == null) goto L19;
        r6.cancel();
        this.f = null;
    L19:
        TextView r7 = this.d;
        if (r7 == null) goto L22;
        r7.setVisibility(8);
        this.d.setText("");
    L22:
        c(((GameGuessPredictorWidget.a) this.e).a());
        return;
    L27:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (k.f(IUserService.class).user().isLogin() == true) goto L8;
        Disposable r5 = TTLiveSDKContext.getHostService().h().login(r4.getContext(), new l(new l.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gameguess.toolbar.a(this), new b());
        CompositeDisposable r0 = this.i;
        if (r0 == null) goto L10;
        r0.add(r5);
        return;
    L10:
        return;
    L8:
        a();
    }

    public ToolbarPredictorBehavior(Context r1, CompositeDisposable r2) {
        this.a = r1;
        this.i = r2;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        r3.removeObserver(this);
        CountDownTimer r4 = this.f;
        if (r4 == null) goto L5;
        r4.cancel();
        this.f = null;
    L5:
        TextView r5 = this.d;
        if (r5 == null) goto L8;
        r5.setVisibility(8);
        this.d.setText("");
    L8:
        TextView r6 = this.d;
        if (r6 == null) goto L15;
        ViewGroup r0 = this.g;
        if (r0 == null) goto L13;
        r0.removeView(r6);
    L13:
        this.d = null;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r4, DataCenter r5) {
        TextView r0 = this.d;
        if (r0 == null) goto L8;
        ViewGroup r1 = this.g;
        if (r1 == null) goto L7;
        r1.removeView(r0);
    L7:
        this.d = null;
    L8:
        this.c = r4;
        this.b = r5;
        boolean r6 = ((Boolean) r5.get("data_is_portrait", Boolean.FALSE)).booleanValue();
        this.h = r6;
        View r2 = this.c;
        if (r2 != null) goto L11;
    L27:
        xx1.a r7 = this.e;
        if (r7 == null) goto L30;
        c(((GameGuessPredictorWidget.a) r7).a());
    L30:
        r5.observe("data_predictor_info_change", this);
        r5.observe("data_predictor_more_entrance_shwo", this);
        b(r5);
        return;
    L11:
        if (this.a == null) goto L27;
        if (r6 == true) goto L15;
        this.g = (ViewGroup) r2.findViewById(2131374718).getParent();
    L17:
        if (this.g == null) goto L27;
        RelativeLayout.LayoutParams r8 = new RelativeLayout.LayoutParams(s1.f(26.0f), s1.f(10.0f));
        if (this.h == false) goto L22;
        r8.setMargins(0, s1.f(4.0f), s1.f(16.0f), 0);
    L22:
        r8.addRule(10);
        r8.addRule(21);
        TextView r3 = new TextView(this.a);
        this.d = r3;
        r3.setBackgroundResource(2131253130);
        this.d.setTextColor(this.a.getResources().getColor(2131108569));
        this.d.setTextSize(1, 7.0f);
        this.d.setLayoutParams(r8);
        this.d.setVisibility(8);
        this.d.setGravity(17);
        ViewGroup r9 = this.g;
        if (r9 == null) goto L27;
        TextView r10 = this.d;
        if (r10 == null) goto L27;
        r9.addView(r10);
        goto L27
    L15:
        this.g = (ViewGroup) r2.findViewById(2131362039);
        goto L17
    }
}
