package com.bytedance.android.livesdk.gameguess.widget;

import am2.x;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.gameguess.api.PredictorGuessApi;
import com.bytedance.android.livesdk.gameguess.toolbar.ToolbarPredictorBehavior;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.message.model.si;
import com.bytedance.android.livesdk.message.model.ti;
import com.bytedance.android.livesdk.message.model.ui;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.QuizExtra;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class GameGuessPredictorWidget extends LiveRecyclableWidget implements l, Observer<KVData>, View.OnClickListener {
    public TextView a;
    public List<ui.a> b;
    public Room c;
    public vlc.d d;
    public ToolbarPredictorBehavior e;
    public final CompositeDisposable f;
    public boolean g;
    public Disposable h;
    public boolean i;

    public class a implements xx1.a {
        public final /* synthetic */ GameGuessPredictorWidget a;

        public final long a() {
            GameGuessPredictorWidget r0 = this.a;
            List<ui.a> r1 = r0.b;
            r0.getClass();
            int r2 = -1;
            if (r1 != null) goto L5;
        L15:
            if (r2 >= 0) goto L25;
            return -1;
        L25:
            return (((ui.a) ListProtector.get(r1, r2)).b() + ((ui.a) ListProtector.get(r1, r2)).a()) - (System.currentTimeMillis() / 1000);
        L5:
            if (r1.size() <= 0) goto L15;
            int r4 = r1.size() - 1;
            int r5 = 0;
            int r6 = -1;
        L8:
            if (r5 > r4) goto L13;
            int r7 = ((r4 - r5) / 2) + r5;
            if ((((ui.a) ListProtector.get(r1, r7)).b() + ((ui.a) ListProtector.get(r1, r7)).a()) > (System.currentTimeMillis() / 1000)) goto L11;
            r5 = r7 + 1;
            goto L8
        L11:
            r4 = r7 - 1;
            r6 = r7;
            goto L8
        L13:
            if (r6 < 0) goto L15;
            r2 = r6;
            goto L15
        }

        public a(GameGuessPredictorWidget r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageType.values().length];
            a = r0;
            r0[MessageType.GAME_GUESS_PREDICTOR_START_MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[MessageType.PREDICTOR_ANCHOR_STATUS_MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[MessageType.PREDICTOR_AUDIENCE_STATUS_MESSAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public final int getLayoutId() {
        return 2131568027;
    }

    public final void onUnload() {
        List<ui.a> r0 = this.b;
        if (r0 == null) goto L5;
        r0.clear();
        this.b = null;
    L5:
        vlc.d r1 = this.d;
        if (r1 == null) goto L8;
        r1.removeMessageListener(this);
    L8:
        CompositeDisposable r2 = this.f;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        Disposable r3 = this.h;
        if (r3 == null) goto L15;
        r3.dispose();
    L15:
        if (this.g == false) goto L17;
        y3.b(((Widget) this).dataCenter).d(ToolbarButton.PREDICTOR_GUESS, this.e);
        return;
    L17:
        c0 r4 = y3.b(((Widget) this).dataCenter);
        ToolbarButton r5 = ToolbarButton.PREDICTOR_GUESS;
        r4.d(r5, this.e);
        y3.i(((Widget) this).dataCenter).d(r5, this.e);
        TextView r6 = this.a;
        if (r6 == null) goto L20;
        r6.setText("");
    L20:
        ((Widget) this).dataCenter.removeObserver(this);
        ((Widget) this).dataCenter.put("data_predictor_entrance_can_show", Boolean.FALSE);
        ((Widget) this).dataCenter.put("data_predictor_banner_can_show", Boolean.TRUE);
    }

    public final void xq() {
        if (this.c == null) goto L8;
        Disposable r0 = ((PredictorGuessApi) com.bytedance.android.live.network.c.b().e(PredictorGuessApi.class)).requestIsGameRoomByMergeTag(this.c.getId() + "", this.g, PredictorGuessApi.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this), new f(this));
        CompositeDisposable r1 = this.f;
        if (r1 == null) goto L9;
        r1.add(r0);
        return;
    L9:
        return;
    }

    public GameGuessPredictorWidget() {
        this.b = new ArrayList();
        this.d = null;
        this.f = new CompositeDisposable();
        this.g = false;
        this.i = false;
    }

    public static void wq(Object r3) {
        HashMap r0 = new HashMap();
        r0.put("eventName", "predictor_page_reload");
        r0.put("data", r3);
        k.f(IBrowserService.class).sendEventToAllJsBridges("H5_commonMessage", r0);
    }

    public final void onChanged(Object r11) {
        KVData r12 = (KVData) r11;
        if (r12 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r12.getKey()) == false) goto L7;
        return;
    L7:
        if (r12.getData() != null) goto L9;
        return;
    L9:
        if (isViewValid() == true) goto L11;
        return;
    L11:
        if (((Widget) this).dataCenter == null) goto L72;
        String r0 = r12.getKey();
        r0.getClass();
        int r1 = r0.hashCode();
        int r4 = 0;
        if (r1 == (-1111890595)) goto L29;
        if (r1 == 1060055221) goto L25;
        if (r1 == 1666000240) goto L21;
    L30:
        byte r2 = -1;
    L33:
        if (r2 == 0) goto L43;
        if (r2 == 1) goto L38;
        if (r2 != 2) goto L73;
        String r13 = (String) r12.getData();
        yx1.a.d(((Widget) this).context, (Room) ((Widget) this).dataCenter.get("data_room", null), yx1.a.c(((Widget) this).dataCenter, this.g, true, true, false, false), r13, "");
        i0.c().postDelayed(new d(), TimeUnit.SECONDS.toMillis(1));
        return;
    L73:
        return;
    L38:
        boolean r14 = ((Boolean) r12.getData()).booleanValue();
        View r3 = ((Widget) this).contentView;
        if (r14 == false) goto L41;
        r4 = 4;
    L41:
        UIUtils.setViewVisibility(r3, r4);
        return;
    L43:
        if (((Boolean) ((Widget) this).dataCenter.get("data_predictor_entrance_can_show", Boolean.FALSE)).booleanValue() == true) goto L45;
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
        ((Widget) this).dataCenter.put("data_predictor_banner_can_show", Boolean.TRUE);
        return;
    L45:
        if (((Widget) this).containerView.getVisibility() == 0) goto L74;
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 != null) goto L50;
        return;
    L50:
        if (this.c != null) goto L52;
        return;
    L52:
        if (((Long) r15.get("data_predictor_last_log_room_id", -100L)).longValue() == this.c.getId()) goto L68;
        ViewGroup r16 = ((Widget) this).containerView;
        if (r16 != null) goto L56;
        return;
    L56:
        if (r16.getVisibility() != 0) goto L70;
        boolean r17 = ((Boolean) ((Widget) this).dataCenter.get("data_is_portrait", Boolean.TRUE)).booleanValue();
        HashMap r5 = new HashMap();
        r5.put("anchor_id", this.c.getOwnerUserIdString());
        r5.put("room_id", this.c.getId() + "");
        r5.put("enter_from", "banner");
        r5.put("room_orientation", (!r17 ? 1 : 0) + "");
        u.l().sendLog("livesdk_user_prediction_entrance_show", r5, new Object[0]);
        ((Widget) this).dataCenter.put("data_predictor_last_log_room_id", Long.valueOf(this.c.getId()));
        return;
    L70:
        return;
    L68:
        return;
    L74:
        return;
    L21:
        if (r0.equals("data_predictor_panel_show") == false) goto L30;
        r2 = 2;
        goto L33
    L25:
        if (r0.equals("data_keyboard_status") == false) goto L30;
        r2 = 1;
        goto L33
    L29:
        if (r0.equals("data_predictor_entrance_can_show") == false) goto L30;
        r2 = 0;
        goto L33
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (k.f(IUserService.class).user().isLogin() == true) goto L6;
        this.h = TTLiveSDKContext.getHostService().h().login(r4.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.gameguess.widget.a(this), new com.bytedance.android.livesdk.gameguess.widget.b());
        return;
    L6:
        xq();
    }

    public final void onInit(Object[] r3) {
        this.i = false;
        if (((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.TRUE)).booleanValue() == true) goto L8;
        TextView r4 = (TextView) ((Widget) this).containerView.findViewById(2131382854);
        this.a = (TextView) ((Widget) this).containerView.findViewById(2131382852);
        TextView r5 = (TextView) ((Widget) this).containerView.findViewById(2131382853);
        if (r5 == null) goto L9;
        r5.setText(2131921641);
        return;
    L9:
        return;
    }

    public final void onLoad(Object[] r7) {
        this.d = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        this.g = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.c = (Room) ((Widget) this).dataCenter.get("data_room", null);
        vlc.d r8 = this.d;
        if (r8 == null) goto L5;
        r8.addMessageListener(MessageType.GAME_GUESS_PREDICTOR_START_MESSAGE.getIntType(), this);
        this.d.addMessageListener(MessageType.PREDICTOR_ANCHOR_STATUS_MESSAGE.getIntType(), this);
        this.d.addMessageListener(MessageType.PREDICTOR_AUDIENCE_STATUS_MESSAGE.getIntType(), this);
    L5:
        a r9 = new a(this);
        ToolbarPredictorBehavior r0 = new ToolbarPredictorBehavior(((Widget) this).context, this.f);
        this.e = r0;
        r0.e = r9;
        if (((Widget) this).dataCenter == null) goto L22;
        Room r1 = this.c;
        if (r1 == null) goto L22;
        QuizExtra r2 = r1.quizExtra;
        if (r2 == null) goto L22;
        if (r2.getQuizInfos() == null) goto L22;
        List<ui.a> r3 = (List) JsonUtil.parse(this.c.quizExtra.getQuizInfos(), new g().getType());     // Catch: Exception -> L17 ClassCastException -> L19
        if (r3 == null) goto L22;
        yq(r3);     // Catch: Exception -> L17 ClassCastException -> L19
    L19:
        e = move-exception;
        Logger.e("GAME_GUESS_PREDICTOR_WIDGET", "GameGuessPredictorWidget#getQuizInfosFromRoom : " + e.toString());
    L17:
        e = move-exception;
        Logger.e("GAME_GUESS_PREDICTOR_WIDGET", "GameGuessPredictorWidget#getQuizInfosFromRoom : " + e.toString());
    L22:
        if (this.g == false) goto L24;
        y3.b(((Widget) this).dataCenter).k(ToolbarButton.PREDICTOR_GUESS, this.e);
        ((Widget) this).dataCenter.observe("data_predictor_panel_show", this);
        return;
    L24:
        UIUtils.setViewVisibility(((Widget) this).containerView, 8);
        c0 r10 = y3.b(((Widget) this).dataCenter);
        ToolbarButton r4 = ToolbarButton.PREDICTOR_GUESS;
        r10.k(r4, this.e);
        y3.i(((Widget) this).dataCenter).k(r4, this.e);
        ((Widget) this).dataCenter.observe("data_predictor_entrance_can_show", this).observe("data_keyboard_status", this);
        ((Widget) this).dataCenter.put("data_predictor_entrance_can_show", Boolean.FALSE);
        if (isScreenPortrait() == true) goto L27;
    L33:
        ((Widget) this).containerView.setOnClickListener(this);
        return;
    L27:
        if (this.i == true) goto L33;
        this.i = true;
        n0 r11 = j0.l().c(x.class);
        if ((r11 instanceof n0) == false) goto L33;
        if (TextUtils.equals(r11.h("auto_open_game_quiz"), "1") == false) goto L33;
        yx1.a.d(((Widget) this).context, this.c, yx1.a.c(((Widget) this).dataCenter, false, false, true, false, false), "preview_button", "");
        goto L33
    }

    public final void onMessage(tlc.d r3) {
        if ((r3 instanceof o0) == false) goto L31;
        int r0 = b.a[((o0) r3).getMessageType().ordinal()];
        if (r0 != 1) goto L7;
        ui r4 = (ui) r3;
        if (r4.E() == null) goto L40;
        yq(r4.E());
        if (this.g == true) goto L41;
        ((Widget) this).containerView.getVisibility();
        return;
    L41:
        return;
    L40:
        return;
    L7:
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L12;
        return;
    L12:
        if (this.g == true) goto L32;
        ti r5 = (ti) r3;
        if (r5.E() != null) goto L16;
        return;
    L16:
        if (r5.E().size() <= 0) goto L34;
        wq(r5.E());
        return;
    L34:
        return;
    L32:
        return;
    L19:
        if (this.g == false) goto L36;
        si r6 = (si) r3;
        if (r6.E() != null) goto L23;
        return;
    L23:
        if (r6.E().size() <= 0) goto L38;
        wq(r6.E());
        return;
    L38:
        return;
    L36:
        return;
    }

    public final void yq(List<ui.a> r9) {
        boolean r1 = true;
        if (isViewValid() == false) goto L24;
        if (r9 == null) goto L24;
        if (r9.size() == 1) goto L8;
    L14:
        this.b = r9;
        if (r9.size() <= 0) goto L18;
        Collections.sort(r9, new c());
    L18:
        Room r0 = this.c;
        if (r0 == null) goto L23;
        QuizExtra r2 = r0.quizExtra;
        if (r2 == null) goto L23;
        r2.setQuizInfos(JsonUtil.toJSONString(r9));
    L23:
        ((Widget) this).dataCenter.put("data_predictor_info_change", Boolean.TRUE);
        goto L24
    L8:
        if (((ui.a) ListProtector.get(r9, 0)).c() == 1) goto L14;
        if (((ui.a) ListProtector.get(r9, 0)).c() == 2) goto L14;
        if (((ui.a) ListProtector.get(r9, 0)).c() == 3) goto L14;
        ListProtector.remove(r9, 0);
    L24:
        List<ui.a> r10 = this.b;
        if (r10 != null) goto L27;
    L38:
        r1 = false;
    L39:
        ((Widget) this).dataCenter.put("data_predictor_quiz_in_progress", Boolean.valueOf(r1));
        return;
    L27:
        if (r10.size() <= 0) goto L38;
        Iterator<ui.a> r11 = this.b.iterator();
    L30:
        if (r11.hasNext() == false) goto L38;
        ui.a r3 = r11.next();
        if (r3 == null) goto L30;
        if (r3.c() <= 0) goto L30;
        if (r3.c() >= 4) goto L30;
        goto L39
    }
}
