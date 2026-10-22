package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.presenter.RoomPushPresenter;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.message.model.kk;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class RoomPushWidget extends LiveRecyclableWidget implements RoomPushPresenter.IView, Observer<KVData> {
    public RoomPushPresenter a;
    public boolean b;
    public TextView c;
    public Room d;
    public ImageView e;
    public View f;
    public boolean g;
    public Disposable h;
    public Animation i;

    public class a implements Animation.AnimationListener {
        public final /* synthetic */ RoomPushWidget a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public a(RoomPushWidget r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            UIUtils.setViewVisibility(this.a.f, 8);
            RoomPushPresenter r3 = this.a.a;
            if (r3 == null) goto L6;
            r3.h0();
            return;
        }
    }

    public final int getLayoutId() {
        return 2131567833;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ String getLogTag() {
        return IWidget.CC.$default$getLogTag(this);
    }

    public final String getSpm() {
        return "a100.a100.a123";
    }

    public final void onUnload() {
        this.a.detachView();
        ((Widget) this).dataCenter.removeObserver(this);
        this.f.setVisibility(8);
        this.b = false;
        Disposable r0 = this.h;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Animation r1 = this.i;
        if (r1 == null) goto L9;
        r1.cancel();
        return;
    }

    public final void xq() {
        Disposable r0 = this.h;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Animation r1 = AnimationUtils.loadAnimation(((Widget) this).context, 2130772671);
        this.i = r1;
        r1.setAnimationListener(new a(this));
        this.f.startAnimation(this.i);
        this.b = false;
    }

    public RoomPushWidget() {
    }

    public final boolean eS() {
        return this.b;
    }

    public static DisplayMetrics wq(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public final void eO(final kk r15) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (this.b == true) goto L99;
        this.e.setVisibility(0);
        String r0 = r15.getSource();
        HashMap r2 = new HashMap();
        r2.put("anchor_id", this.d.getOwnerUserIdString());
        r2.put("room_id", String.valueOf(this.d.getId()));
        r2.put("message_type", r0);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_bottom_message_show", r2, new Object[0]);
        String r3 = null;
        if (r15.H() == null) goto L11;
        jc1.k.f(INetworkService.class).loadNinePatchDrawable(r15.H(), this.f, RTLUtil.isAppRTL(com.bytedance.android.live.core.utils.s1.getContext()), null);
    L26:
        if (TextUtils.isEmpty(null) == true) goto L32;
        this.c.setTextColor(Color.parseColor(null));     // Catch: Exception -> L29
    L29:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r4 = com.bytedance.android.livesdk.log.b0.o();
        String r1 = "RoomPushWidget load text color error, color is null/n error is " + e.getMessage();
        r4.getClass();
        com.bytedance.android.live.core.log.g.c("ttlive_msg", r1);
        this.c.setTextColor(com.bytedance.android.live.core.utils.s1.h(2131107181));
    L32:
        if (r15.E() == null) goto L34;
        ImageUtil.loadImage(this.e, r15.E(), 0);
    L37:
        final String r5 = String.valueOf(r15.G());
        if ("0".equals(r5) == false) goto L41;
        this.e.setVisibility(8);
    L41:
        if ("7".equals(r5) == false) goto L57;
        if (TextUtils.isEmpty(r15.getActionContent()) == true) goto L57;
        JsonObject r6 = new JsonParser().parse(r15.getActionContent()).getAsJsonObject();     // Catch: Exception -> L55
        if (r6 != null) goto L47;
    L51:
        if (r3 == null) goto L53;
        this.c.setText(r3);     // Catch: Exception -> L55
    L74:
        if (TextUtils.isEmpty(r5) == true) goto L76;
        this.f.setOnClickListener(new r2(this, r15, r5));
    L76:
        TranslateAnimation r7 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        r7.setDuration(200);
        this.f.startAnimation(r7);
        this.f.setVisibility(0);
        this.h = Observable.timer(r15.P(), TimeUnit.SECONDS).compose(getAutoUnbindTransformer()).observeOn(AndroidSchedulers.mainThread()).subscribe(new s2(this), new t2(this));
        this.b = true;
        if (TextUtils.isEmpty(r15.getTraceId()) == false) goto L90;
        return;
    L90:
        new JSONObject().put("trace_id", r15.getTraceId());     // Catch: JSONException -> L85
        IUser r16 = TTLiveSDKContext.getHostService().h().a;     // Catch: JSONException -> L85
        if (r16 == null) goto L83;
        r16.getIdString();     // Catch: JSONException -> L85
        com.bytedance.android.live.base.model.user.n0.d();     // Catch: JSONException -> L85
    L83:
        this.d.getId();     // Catch: JSONException -> L85
        return;
    L85:
        e = move-exception;
        e.printStackTrace();
        return;
    L53:
        this.c.setText(r15.getContent());     // Catch: Exception -> L55
        goto L74
    L47:
        if (r6.entrySet().size() <= 0) goto L51;
        long r8 = r6.get("gift_id").getAsLong();     // Catch: Exception -> L55
        int r9 = r6.get(LiveEndPageData.TAG_COUNT).getAsInt();     // Catch: Exception -> L55
        com.bytedance.android.livesdk.gift.model.h2 r10 = jc1.k.f(IGiftServiceExternal.class).findLiteGiftById(r8);     // Catch: Exception -> L55
        if (r10 == null) goto L51;
        r3 = com.bytedance.android.live.core.utils.s1.C(2131919077, new Object[]{Integer.valueOf(r9), r10.getName()});     // Catch: Exception -> L55
    L55:
        this.c.setText(r15.getContent());
    L57:
        if (r15.supportDisplayText() == false) goto L72;
        Text r11 = r15.getBaseMessage().getDisplayText();
        if (r11.getKey() != null) goto L61;
    L65:
        String r12 = r11.getDefaultPattern();
    L67:
        if (TextUtils.isEmpty(r12) == false) goto L69;
    L71:
        Logger.e("I18N_MESSAGE", "pattern:" + r12 + "default_pattern:" + r11.getDefaultPattern());
        StringBuilder r13 = new StringBuilder("spannable:");
        r13.append(sb2.a.i(r12, r11).toString());
        Logger.e("I18N_MESSAGE", r13.toString());
        this.c.setText(r15.getContent());
        goto L74
    L69:
        if (sb2.a.i(r12, r11) == sb2.a.a) goto L71;
        this.c.setText(sb2.a.i(r12, r11));
        goto L74
    L61:
        if (TextUtils.isEmpty(com.bytedance.android.live.core.i18n.a.b().a(r11.getKey())) == true) goto L65;
        r12 = com.bytedance.android.live.core.i18n.a.b().a(r11.getKey());
        if (TextUtils.isEmpty(r11.getDefaultPattern()) == false) goto L67;
        w50.h.a().b(r11.getKey(), r12, "");
        goto L67
    L72:
        this.c.setText(r15.getContent());
        goto L74
    L34:
        int r14 = r15.a;
        if (r14 == 0) goto L37;
        this.e.setImageDrawable(com.bytedance.android.live.core.utils.s1.m(r14));
        goto L37
    L11:
        if (TextUtils.isEmpty(r15.getColor()) == false) goto L13;
        this.f.setBackgroundResource(2131249896);
        goto L26
    L13:
        if ((this.f.getBackground() instanceof GradientDrawable) == true) goto L93;
        GradientDrawable r17 = new GradientDrawable();
        r17.setShape(0);     // Catch: Exception -> L22
        r17.setCornerRadius(com.bytedance.android.live.core.utils.s1.f(12.0f));     // Catch: Exception -> L22
        r17.setColor(Color.parseColor(r15.getColor()));     // Catch: Exception -> L22
        this.f.setBackground(r17);     // Catch: Exception -> L22
    L22:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r18 = com.bytedance.android.livesdk.log.b0.o();
        String r19 = "RoomPushWidget load bg color error, color is " + r15.getColor() + "/n error is " + e.getMessage();
        r18.getClass();
        com.bytedance.android.live.core.log.g.c("ttlive_msg", r19);
        goto L26
    L93:
        ((GradientDrawable) this.f.getBackground()).setColor(Color.parseColor(r15.getColor()));     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.android.livesdk.log.b0 r20 = com.bytedance.android.livesdk.log.b0.o();
        String r21 = "RoomPushWidget load bg color error, color is " + r15.getColor() + "/n error is " + e.getMessage();
        r20.getClass();
        com.bytedance.android.live.core.log.g.c("ttlive_msg", r21);
        goto L26
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L13;
        String r0 = r4.getKey();
        r0.getClass();
        if (r0.equals("data_user_in_room") == false) goto L14;
        Object r5 = r4.getData();
        if ((r5 instanceof User) == false) goto L12;
        User r6 = (User) r5;
        return;
    L12:
        return;
    L14:
        return;
    }

    public final void onInit(Object... r2) {
        this.a = new RoomPushPresenter();
        this.c = (TextView) ((Widget) this).contentView.findViewById(2131383453);
        this.e = (ImageView) ((Widget) this).contentView.findViewById(2131384584);
        this.f = ((Widget) this).contentView.findViewById(2131383457);
    }

    public final void onLoad(Object... r3) {
        this.d = (Room) ((Widget) this).dataCenter.get("data_room");
        this.g = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        ((Widget) this).dataCenter.observeForever("data_user_in_room", this);
        this.a.g0(this);
    }
}
