package xy1;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.j0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.config.GiftConfigKey;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.topbar.GiftCommonHintView;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncData;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n extends com.bytedance.android.livesdk.common.b implements View.OnClickListener {
    public static final /* synthetic */ int u = 0;
    public final IBaseUser b;
    public final IBaseUser c;
    public final IRoom d;
    public final long e;
    public String f;
    public final ga0.b g;
    public HSImageView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public View l;
    public final DataCenter m;
    public Disposable n;
    public Disposable o;
    public Disposable p;
    public Boolean q;
    public long r;
    public long s;
    public View t;

    public final void c() {
        long r2 = this.e;
        SendGiftSource r9 = SendGiftSource.Guide;
        this.p = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.o(new b0(r2, r9, null, null, 0, 125, r9.getSourceName(), null, null, null, 0, null, null, false, null, 0, false, null, 0, null, false, null, false, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, -128, 8388607), 1).compose(RxUtil.rxSchedulerHelper()).subscribe(new k(this), new l(), new c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.message.e.class).b3();
        Disposable r1 = this.n;
        if (r1 != null) goto L20;
    L22:
        Disposable r2 = this.o;
        if (r2 != null) goto L25;
    L27:
        Disposable r3 = this.p;
        if (r3 != null) goto L30;
    L32:
        boolean r4 = this.q.booleanValue();
        long r5 = this.e;
        String r6 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("gift_id", String.valueOf(r5));
        if (r4 == false) goto L35;
        String r8 = "overtime";
    L36:
        r7.put("close_type", r8);
        mz0.n r9 = new mz0.n();
        Map r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r10.putAll(r7);
        mz0.m r11 = new mz0.m();
        r11.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r13 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r13, "pageSourceLog");
        List r14 = r11.a;
        ArrayList r15 = (ArrayList) r14;
        r15.add(r13.a);
        List r16 = r9.b;
        ArrayList r17 = (ArrayList) r16;
        r17.addAll(r11.a);
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r19);
        ((f80.a) r19).w3("livesdk_gift_guide_popup_close", r9.a, r9.b);
        this.q = Boolean.FALSE;
        return;
    L35:
        r8 = "manual";
        goto L36
    L30:
        if (r3.isDisposed() == true) goto L32;
        this.p.dispose();
        goto L32
    L25:
        if (r2.isDisposed() == true) goto L27;
        this.o.dispose();
        goto L27
    L20:
        if (r1.isDisposed() == true) goto L22;
        this.n.dispose();
        goto L22
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r20 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r20 == null) goto L16;
        com.bytedance.crash.d.d(r20, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void onStart() {
        super.onStart();
        boolean r0 = ((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_AUTO_DISMISS, Boolean.FALSE)).booleanValue();
        this.s = System.currentTimeMillis();
        if (r0 == false) goto L6;
        this.n = Observable.timer(10, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this));
        return;
    }

    public final void show() {
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_GUIDE_SHOW, Boolean.TRUE)).booleanValue() == true) goto L6;
        return;
    L6:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(n r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        if (r10.getId() != 2131367746) goto L6;
        a(this);
        return;
    L6:
        if (r10.getId() != 2131391395) goto L31;
        HashMap r11 = new HashMap();
        r11.put("room_id", String.valueOf(this.d.getId()));
        r11.put("anchor_id", String.valueOf(this.d.getAnchorId()));
        r11.put("guide_style", "convenient_gift");
        r11.put("gift_id", String.valueOf(this.e));
        com.bytedance.android.livesdk.gift.platform.core.utils.h.d0("gift_guide_popup_click", r11);
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L16;
        Disposable r13 = this.n;
        if (r13 != null) goto L12;
    L14:
        this.r -= System.currentTimeMillis() - this.s;
        this.s = System.currentTimeMillis();
        com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).z4(getContext(), new d()).subscribe(new m(this));
        return;
    L12:
        if (r13.isDisposed() == true) goto L14;
        this.n.dispose();
        goto L14
    L16:
        if (com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).interceptOperation("gift") == true) goto L33;
        final h1 r0 = GiftManagerKt.j(this.e, null);
        if (r0 == null) goto L34;
        final HashSet r14 = (HashSet) ay1.b.c.getValue(null, ay1.b.a[2]);
        final int r2 = r0.getDiamondCount();
        if (r2 >= 2) goto L24;
    L27:
        c();
    L28:
        long r3 = r0.getId();
        int r15 = o.a;
        Intrinsics.checkNotNullParameter("money_change", "alertType");
        Intrinsics.checkNotNullParameter("guide", "pageFrom");
        HashMap r16 = new HashMap();
        r16.put("gift_id", String.valueOf(r3));
        r16.put("money", String.valueOf(r2));
        r16.put("alert_click", "money_change");
        r16.put("page_from", "guide");
        mz0.n r1 = new mz0.n();
        Map r4 = r1.a;
        Intrinsics.checkNotNullParameter(r4, "map");
        Intrinsics.checkNotNullParameter(r16, "map");
        r4.putAll(r16);
        mz0.m r17 = new mz0.m();
        r17.b(LogCommon.ROOM);
        r17.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r1.b).addAll(r17.a);
        cy0.e.a.getClass();
        cy0.j r18 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r19 = com.bytedance.android.scope.m.b(r18).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r19);
        ((f80.a) r19).w3("livesdk_gift_send_alert_show", r1.a, r1.b);
        return;
    L24:
        if (r14.contains(String.valueOf(r2)) == true) goto L27;
        GiftCommonHintView r5 = new GiftCommonHintView(getContext());
        r5.setTitle(s1.C(2131919152, new Object[]{Integer.valueOf(r2), r3.b()}));
        com.bytedance.android.livesdk.e.b().a();
        cs2.b r6 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.ui.d.class).yn(getContext(), 6);
        r6.a.setContentView(r5);
        r6.a.a(0, 2131919151, new e(this, r14, r2, r0));
        r6.a.a(1, 2131919150, new f(r0, r2));
        r6.a.setOnDismissListener(new g());
        r6.h();
        goto L28
    L34:
        return;
    L33:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        super/*android.app.Dialog*/.onCreate(r7);
        setContentView(2131565473);
        this.h = findViewById(2131376019);
        this.i = (TextView) findViewById(2131390993);
        this.j = (TextView) findViewById(2131390479);
        this.k = (TextView) findViewById(2131391395);
        this.l = findViewById(2131367746);
        this.t = findViewById(2131367764);
        com.bytedance.android.livesdk.gift.platform.business.config.j r8 = com.bytedance.android.livesdk.gift.util.b.a();
        GiftConfigKey r0 = GiftConfigKey.KET_GIFT_GUIDE_SHOW_BLANK_HINT;
        Boolean r1 = Boolean.FALSE;
        if (((Boolean) r8.c(r0, r1)).booleanValue() == false) goto L5;
        this.l.setContentDescription(s1.B(2131918650));
    L5:
        DataCenter r9 = this.m;
        Boolean r2 = Boolean.TRUE;
        if (r9.get("data_is_portrait", r2) == null) goto L8;
        boolean r10 = ((Boolean) this.m.get("data_is_portrait", r2)).booleanValue();
    L9:
        int r3 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((!r10) == true) goto L12;
    L33:
        setCanceledOnTouchOutside(true);
        ImageLoader.bindImage(this.h, this.b.getAvatarThumbKt());
        if (this.i == null) goto L50;
        IBaseUser r11 = this.c;
        if (r11 != null) goto L39;
    L41:
        StringBuffer r13 = new StringBuffer("@");
        r13.append(s1.B(2131919153));
        this.i.setText(r13.toString());
    L43:
        if (((Boolean) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_GUIDE_SHOW_SPECIAL_NICK, r1)).booleanValue() == false) goto L50;
        IBaseUser r14 = this.c;
        if (r14 != null) goto L47;
    L49:
        this.i.setText(getContext().getResources().getString(2131917142));
        goto L50
    L47:
        if (StringUtils.isEmpty(r14.getNickName()) == true) goto L49;
        this.i.setText(getContext().getResources().getString(2131917141, new Object[]{this.c.getNickName()}));
        goto L50
    L39:
        if (StringUtils.isEmpty(r11.getNickName()) == true) goto L41;
        StringBuffer r15 = new StringBuffer("@");
        r15.append(this.c.getNickName());
        this.i.setText(r15.toString());
    L50:
        h1 r16 = GiftManagerKt.j(this.e, null);
        if (TextUtils.isEmpty(this.f) == true) goto L53;
        if (r16 == null) goto L53;
    L60:
        final SpannableString r4 = new SpannableString(this.f + " ");     // Catch: Exception -> L56
        a1.k(r16.getImage()).compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r4), new i(this, r4));     // Catch: Exception -> L56
    L58:
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        return;
    L56:
        e = move-exception;
        Logger.e(e.toString());
    L53:
        this.f = getContext().getResources().getString(((Integer) com.bytedance.android.livesdk.gift.util.b.a().c(GiftConfigKey.KEY_GIFT_GUIDE_SEND_GIFT_TIP_STR, 2131922450)).intValue());
        r16 = GiftManagerKt.p();
        goto L60
    L12:
        if (getWindow() == null) goto L29;
        getWindow().setDimAmount(0.0f);
        WindowManager.LayoutParams r17 = getWindow().getAttributes();
        float r5 = s1.f(20.0f);
        int r6 = j0.a;
        Context r18 = getContext();
        if (r18 != null) goto L16;
        int r19 = 0;
    L20:
        r17.verticalMargin = r5 / r19;
        float r20 = s1.f(34.0f);
        Context r21 = getContext();
        if (r21 != null) goto L23;
        int r23 = 0;
    L27:
        r17.horizontalMargin = r20 / r23;
        getWindow().setAttributes(r17);
        goto L29
    L23:
        r23 = UIUtils.getScreenWidth(r21);
        int r24 = UIUtils.getScreenHeight(r21);
        if (r24 < r23) goto L27;
        r23 = r24;
        goto L27
    L16:
        r19 = UIUtils.getScreenWidth(r18);
        int r25 = UIUtils.getScreenHeight(r18);
        if (r25 > r19) goto L20;
        r19 = r25;
    L29:
        if ((this.t.getLayoutParams() instanceof RelativeLayout.LayoutParams) == false) goto L31;
        RelativeLayout.LayoutParams r26 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
    L32:
        r26.addRule(11);
        r26.addRule(21);
        this.t.setLayoutParams(r26);
        goto L33
    L31:
        r26 = new RelativeLayout.LayoutParams(this.t.getLayoutParams());
        goto L32
    L8:
        r10 = true;
        goto L9
    }

    public static void b(final n r3, long r4) {
        r3.getClass();
        if (r4 > 0) goto L5;
    L7:
        a(r3);
        return;
    L5:
        if (r4 > RiskAdviseSyncData.PRIORITY) goto L7;
        r3.n = Observable.timer(r4, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(r3));
    }

    public n(Context r3, IRoom r4, IBaseUser r5, ga0.b r6, long r7, String r9, DataCenter r10) {
        super(r3, ((Boolean) r10.get("data_is_portrait", Boolean.TRUE)).booleanValue());
        this.q = Boolean.FALSE;
        this.r = RiskAdviseSyncData.PRIORITY;
        this.s = 0;
        this.d = r4;
        this.b = r4.getOwner();
        this.c = r5;
        this.g = r6;
        this.e = r7;
        this.f = r9;
        this.m = r10;
    }
}
