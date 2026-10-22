package com.bytedance.android.livesdk.commerce.coupon;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f0;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponPresenter;", "Lq46/b;", "Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponPresenter$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCouponPresenter extends q46.b<b> implements Observer<KVData> {
    public static final /* synthetic */ int r = 0;
    public long b;
    public long c;
    public com.bytedance.android.livesdk.commerce.coupon.b d;
    public final rg2.g e;
    public Disposable f;
    public final vl2.l g;
    public LiveCouponView h;
    public e i;
    public String j;
    public vl2.b k;
    public vl2.b l;
    public boolean m;
    public long n;
    public final d o;
    public final Context p;
    public final DataCenter q;

    public static final class a {
    }

    public interface b extends q46.a {
        void Be(boolean r1);

        void HT(vl2.b r1);

        void Z80();
    }

    public static final class c implements vl2.l.a {
        public final /* synthetic */ LiveCouponPresenter a;
        public final /* synthetic */ int b;

        public final void onFail() {
        }

        public final void a(vl2.a r3) {
            if ((r3 instanceof vl2.b) == true) goto L5;
            return;
        L5:
            if (this.b != 6) goto L7;
            vl2.b r1 = (vl2.b) r3;
            this.a.l = r1;
        L8:
            LiveCouponView r0 = this.a.h;
            if (r0 == null) goto L11;
            r0.a((vl2.b) r3);
        L11:
            b r2 = (b) ((q46.b) this.a).a;
            if (r2 == null) goto L16;
            r2.HT((vl2.b) r3);
            return;
        L16:
            return;
        L7:
            vl2.b r4 = (vl2.b) r3;
            this.a.k = r4;
            goto L8
        }

        public c(LiveCouponPresenter r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements LiveCouponView.b {
        public final /* synthetic */ LiveCouponPresenter a;

        @Override // com.bytedance.android.livesdk.commerce.coupon.LiveCouponView.b
        public final void b() {
            LiveCouponPresenter r0 = this.a;
            String[] r1 = {"coupon_result", "1", "button_info", s1.B(2131920025)};
            r0.getClass();
            LiveCouponPresenter.i0("livesdk_coupon_more", r1);
            this.a.h0();
        }

        @Override // com.bytedance.android.livesdk.commerce.coupon.LiveCouponView.b
        public final void onCloseClick() {
            LiveCouponPresenter r0 = this.a;
            int r1 = LiveCouponPresenter.r;
            r0.h0();
        }

        public d(LiveCouponPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.commerce.coupon.LiveCouponView.b
        public final void a(String r5, Function0<Unit> r6) {
            Intrinsics.checkNotNullParameter(r6, "callback");
            this.a.getClass();
            LiveCouponPresenter.i0("livesdk_coupon_get", new String[0]);
            LiveCouponPresenter r0 = this.a;
            r0.getClass();
            if (TextUtils.isEmpty(r5) == false) goto L5;
            r0.f0(s1.B(2131919133), true);
            return;
        L5:
            HashMap r1 = new HashMap();
            r1.put("room_id", String.valueOf(r0.b));
            if (r5 != null) goto L8;
            String r2 = "";
        L9:
            r1.put("meta_id", r2);
            com.bytedance.android.livesdk.service.l.d().getClass();
            r0.f = ((LiveCouponApi) com.bytedance.android.live.network.c.b().e(LiveCouponApi.class)).tryApplyCurCouponInfo(r1).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(r0, r6, r5), new j(r0, r5));
            return;
        L8:
            r2 = r5;
            goto L9
        }
    }

    static {
    }

    public final void detachView() {
        ((q46.b) this).a = null;
        h0();
        rg2.g r0 = this.e;
        if (r0 == null) goto L7;
        Map r1 = r0.a;
        if (r1 == null) goto L7;
        ((WeakHashMap) r1).clear();
    L7:
        Disposable r2 = this.f;
        if (r2 != null) goto L10;
    L14:
        this.q.removeObserver(this);
        return;
    L10:
        if (r2.isDisposed() != true) goto L14;
        Disposable r3 = this.f;
        if (r3 == null) goto L14;
        r3.dispose();
        goto L14
    }

    public final void h0() {
        String r0 = this.j;
        LiveCouponView r1 = this.h;
        if (r1 == null) goto L5;
        String r2 = r1.getMMetaId();
    L7:
        if (StringUtils.equal(r0, r2) == true) goto L9;
        this.m = true;
    L9:
        b r3 = (b) ((q46.b) this).a;
        if (r3 == null) goto L12;
        r3.Be(this.m);
    L12:
        e r4 = this.i;
        if (r4 == null) goto L31;
        Handler r5 = DialogLancet.resolveDialogHandler(r4);
        if (r5 != null) goto L17;
    L19:
        DialogLancet.beforeDialogDismiss(r4);
        r4.dismiss();     // Catch: Throwable -> L22 Exception -> L24
    L28:
        DialogLancet.afterDialogDismiss(r4);
        goto L31
    L22:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r4);
        throw th;
    L24:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L22
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L22
        if (r6 == null) goto L28;
        com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L22
        goto L28
    L17:
        if (Looper.myLooper() == r5.getLooper()) goto L19;
        r5.post(DialogLancet.createDismissRunnable(r4));
    L31:
        this.i = null;
        this.h = null;
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void e0() {
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L5;
        Bundle r0 = new Bundle();
        r0.putString("enter_from", "live_detail");
        r0.putString("source", "live");
        f0 r1 = TTLiveSDKContext.getHostService().h();
        Context r3 = this.p;
        com.bytedance.android.livesdk.user.l.a r6 = new com.bytedance.android.livesdk.user.l.a();
        r6.a = s1.B(2131920130);
        r6.e = "live_detail";
        r6.d = "live";
        r1.login(r3, new com.bytedance.android.livesdk.user.l(r6)).subscribe(new h(this));
        boolean r2 = false;
    L6:
        if (r2 == true) goto L8;
        return;
    L8:
        i0("livesdk_coupon_click", new String[0]);
        e r4 = this.i;
        if (r4 != null) goto L11;
    L13:
        LiveCouponView r5 = new LiveCouponView(this.p, null, 6, 0);
        this.h = r5;
        com.bytedance.android.livesdk.commerce.coupon.b r7 = this.d;
        if (r7 != null) goto L16;
    L18:
        vl2.b r8 = this.k;
    L19:
        r5.a(r8);
        LiveCouponView r9 = this.h;
        if (r9 == null) goto L22;
        r9.setMLottieHelper(this.e);
    L22:
        LiveCouponView r10 = this.h;
        if (r10 == null) goto L25;
        r10.setMMetaId(this.j);
    L25:
        LiveCouponView r11 = this.h;
        if (r11 == null) goto L28;
        r11.setActivityData(this.d);
    L28:
        this.i = new e(this.p, this.h);
        LiveCouponView r12 = this.h;
        if (r12 == null) goto L31;
        r12.setMCouponClick(this.o);
    L31:
        LiveCouponView r13 = this.h;
        if (r13 == null) goto L34;
        r13.setVisibility(0);
    L34:
        LiveCouponView r14 = this.h;
        if (r14 == null) goto L44;
        vl2.b r15 = r14.b;
        if (r15 == null) goto L43;
        WeakHandler r16 = r14.a;
        String r17 = r15.d;
        l56.b r18 = l56.b.a();
        vl2.e r19 = new vl2.e(r17);
        if (r18.a == false) goto L42;
        r18.b.execute(new l56.a(r16, r19, 200));
        goto L43
    L42:
        throw new IllegalStateException("TaskManager not init");
    L43:
        float r20 = (t6.b(r14.getContext()) / 2) + t6.a(r14.getContext(), 125.0f);
        float r21 = t6.a(r14.getContext(), 30.0f);
        ObjectAnimator r22 = ObjectAnimator.ofFloat(r14.d, View.TRANSLATION_Y, new float[]{-r20, 0.0f});
        r22.setInterpolator(new AccelerateInterpolator());
        r22.setDuration(300);
        float r23 = -r21;
        ObjectAnimator r24 = ObjectAnimator.ofFloat(r14.d, View.TRANSLATION_Y, new float[]{0.0f, r23});
        r24.setInterpolator(new DecelerateInterpolator());
        r24.setDuration(120);
        ObjectAnimator r25 = ObjectAnimator.ofFloat(r14.d, View.TRANSLATION_Y, new float[]{r23, 0.0f});
        r25.setInterpolator(new AccelerateInterpolator());
        r25.setDuration(120);
        AnimatorSet r26 = new AnimatorSet();
        r26.playSequentially(new Animator[]{r22, r24, r25});
        r26.start();
    L44:
        Context r27 = this.p;
        if ((r27 instanceof Activity) == true) goto L47;
        return;
    L47:
        if (((Activity) r27).isFinishing() == true) goto L60;
        e r28 = this.i;
        if (r28 != null) goto L51;
        return;
    L51:
        if (DialogLancet.shouldBlockDialogShow(r28) == false) goto L57;
        DialogLancet.handleBlockedDialogShow(r28);
        return;
    L57:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L56
    L54:
        DialogLancet.beforeDialogShow(r28);
        r28.show();
        DialogLancet.afterDialogShow(r28);
        return;
    L60:
        return;
    L16:
        if (r7.activityType != 1) goto L18;
        r8 = this.l;
        goto L19
    L11:
        if (r4.isShowing() != true) goto L13;
        return;
    L5:
        r2 = true;
        goto L6
    }

    public final void g0(int r6) {
        vl2.l r0 = this.g;
        if (r0 == null) goto L6;
        Context r1 = this.p;
        c r2 = new c(this, r6);
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new vl2.j(r0, r1, r6, r2)).addOnFail(new vl2.h(r2)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("LiveResourceDownloadService");
        return;
    }

    public final void onChanged(Object r8) {
        KVData r9 = (KVData) r8;
        com.bytedance.android.livesdk.commerce.coupon.b r0 = null;
        if (r9 == null) goto L5;
        com.bytedance.android.livesdk.commerce.coupon.a r10 = (com.bytedance.android.livesdk.commerce.coupon.a) r9.getData();
    L7:
        if ((r10 instanceof com.bytedance.android.livesdk.commerce.coupon.a) == true) goto L9;
        r10 = null;
    L9:
        if (r10 == null) goto L45;
        int r1 = r10.a;
        boolean r2 = false;
        if (r1 != 1) goto L35;
        this.m = true;
        b r3 = (b) ((q46.b) this).a;
        if (r3 == null) goto L15;
        r3.Z80();
    L15:
        this.j = String.valueOf(r10.e);
        String r11 = r10.getActivity();
        if (r11 != null) goto L18;
    L28:
        this.d = r0;
        if (r0 != null) goto L31;
    L33:
        g0(5);
        return;
    L31:
        if (r0.activityType != 1) goto L33;
        g0(6);
        return;
    L18:
        if (r11.length() <= 0) goto L20;
        r2 = true;
    L20:
        if (r2 == true) goto L23;
        r11 = null;
    L23:
        if (r11 == null) goto L28;
        r0 = (com.bytedance.android.livesdk.commerce.coupon.b) GsonHelper.get().fromJson(r11, com.bytedance.android.livesdk.commerce.coupon.b.class);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L35:
        if (r1 == 2) goto L37;
        if (r1 == 3) goto L37;
        return;
    L37:
        if (r1 != 3) goto L39;
        com.bytedance.android.livesdk.log.g r4 = u.l();
        HashMap r5 = new HashMap();
        r5.put("coupon_id", this.j);
        r5.put("room_id", String.valueOf(this.b));
        r5.put("anchor_id", String.valueOf(this.c));
        r5.put("coupon_type", String.valueOf(this.n));
        r5.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        r5.put("duration", String.valueOf(System.currentTimeMillis() - r10.b));
        r5.put("type", "finish");
        Unit r12 = Unit.INSTANCE;
        r4.sendLog("livesdk_send_coupons_duration", r5, new Object[0]);
    L39:
        this.m = false;
        this.j = "";
        b r13 = (b) ((q46.b) this).a;
        if (r13 == null) goto L49;
        r13.Z80();
        return;
    L49:
        return;
    L45:
        return;
    L5:
        r10 = null;
        goto L7
    }

    public LiveCouponPresenter(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.p = r2;
        this.q = r3;
        this.j = "";
        this.m = true;
        this.g = new vl2.l();
        this.e = new rg2.g();
        this.o = new d(this);
    }

    public static void i0(String r7, String... r8) {
        Intrinsics.checkNotNullParameter(r7, "event");
        Intrinsics.checkNotNullParameter(r8, "extras");
        HashMap r0 = new HashMap();     // Catch: Exception -> L17
        if (r8.length != 0) goto L6;
        boolean r1 = true;
    L8:
        if ((!r1) == true) goto L10;
    L15:
        u.l().sendLog(r7, r0, new Object[]{new x(), Room.class});     // Catch: Exception -> L17
        return;
    L10:
        if ((r8.length % 2) != 0) goto L15;
        int r2 = 0;
    L13:
        if (r2 >= r8.length) goto L15;
        r0.put(r8[r2], r8[r2 + 1]);     // Catch: Exception -> L17
        r2 = r2 + 2;     // Catch: Exception -> L17
        goto L13
    L6:
        r1 = false;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public final void f0(String r2, boolean r3) {
        if (r3 == false) goto L5;
        h0();
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L7;
        f2.i(this.p, r2, 0);
        return;
    L7:
        f2.i(this.p, s1.B(2131919133), 0);
    }

    public static final void c0(LiveCouponPresenter r29, com.bytedance.android.livesdk.commerce.coupon.c r30, boolean r31) {
        r29.getClass();
        if (r31 == false) goto L7;
        if (r30 == null) goto L6;
        boolean r4 = r30.a();
    L8:
        r29.m = r4;
        String r5 = "coupon_result";
        if (r30 == null) goto L158;
        if (r30.c() != 0) goto L158;
        if (r31 == false) goto L158;
        LiveCouponView r0 = r29.h;
        if (r0 == null) goto L155;
        com.bytedance.android.livesdk.commerce.coupon.d r1 = r30.b();
        if (r1 == null) goto L155;
        r0.n = r1;
        r0.m = 1;
        TextView r6 = r0.f;
        com.bytedance.android.livesdk.commerce.coupon.b r7 = r0.o;
        if (r7 != null) goto L21;
    L31:
        String r8 = s1.B(2131919187);
    L32:
        r6.setText(r8);
        TextView r9 = r0.e;
        com.bytedance.android.livesdk.commerce.coupon.b r10 = r0.o;
        if (r10 != null) goto L35;
    L45:
        String r11 = s1.B(2131920025);
    L46:
        r9.setText(r11);
        com.bytedance.android.livesdk.commerce.coupon.b r12 = r0.o;
        if (r12 != null) goto L49;
    L103:
        r5 = "coupon_result";
        n r3 = new n(r1.type, r0.j);
        ImageView r13 = r3.a;
        if (r13 == null) goto L110;
        vl2.b r14 = r0.b;
        if (r14 == null) goto L108;
        String r15 = r14.i;
    L109:
        r13.setImageURI(UriProtector.parse(r15));
        goto L110
    L108:
        r15 = null;
    L110:
        View r16 = r3.c;
        if (r16 == null) goto L113;
        r16.setVisibility(0);
    L113:
        long r17 = r3.b;
        if (r17 != 1) goto L125;
        String r22 = n.a(String.valueOf(r1.discount));
        String r2 = s1.B(2131919132);
        ArrayList r18 = new ArrayList();
        if (r22 == null) goto L118;
        r18.add(new m(r22, s1.I(36.0f), s1.h(2131107004), 0, r3.g));
    L118:
        if (r2 == null) goto L120;
        r18.add(new m(r2, s1.I(13.0f), s1.h(2131107004), 0, Typeface.DEFAULT_BOLD));
    L120:
        LiveAlignTextView r19 = r3.f;
        if (r19 == null) goto L123;
        r19.setTextList(CollectionsKt.toList(r18));
    L123:
        r3.b(r1);
    L147:
        vl2.m r20 = r0.p;
        if (r20 != null) goto L150;
    L156:
        i0("livesdk_coupon_result", new String[]{r5, "1"});
        return;
    L150:
        if (r20.a != 5) goto L156;
        r0.g.removeAnimatorListener(r0.t);
        r0.g.addAnimatorListener(r0.t);
        rg2.g r21 = r0.c;
        if (r21 == null) goto L156;
        r21.a(r20, r0.g, true);
        goto L156
    L125:
        if (r17 != 2) goto L136;
        String r110 = n.a(String.valueOf(r1.credit / 100.0f));
        String r23 = s1.B(2131919131);
        ArrayList r24 = new ArrayList();
        if (r110 == null) goto L129;
        r24.add(new m(r110, s1.I(36.0f), s1.h(2131107004), 0, r3.g));
    L129:
        if (r23 == null) goto L131;
        r24.add(new m(r23, s1.I(13.0f), s1.h(2131107004), s1.f(4.0f), Typeface.DEFAULT_BOLD));
    L131:
        LiveAlignTextView r25 = r3.f;
        if (r25 == null) goto L134;
        r25.setTextList(CollectionsKt.toList(r24));
    L134:
        r3.b(r1);
        goto L147
    L136:
        if (r17 != 3) goto L147;
        String r26 = n.a(String.valueOf(r1.credit / 100.0f));
        ArrayList r27 = new ArrayList();
        if (r26 == null) goto L140;
        r27.add(new m(r26, s1.I(36.0f), s1.h(2131107004), 0, r3.g));
    L140:
        LiveAlignTextView r28 = r3.f;
        if (r28 == null) goto L143;
        r28.setTextList(CollectionsKt.toList(r27));
    L143:
        TextView r32 = r3.d;
        if (r32 == null) goto L146;
        r32.setText(s1.C(2131919135, new Object[]{n.a(String.valueOf(r1.threshold / 100.0f))}));
    L146:
        r3.b(r1);
        goto L147
    L49:
        if (r12.activityType != 1) goto L103;
        o r33 = new o(r1.type, r0.j);
        ImageView r34 = r33.a;
        if (r34 == null) goto L57;
        vl2.b r35 = r0.b;
        if (r35 == null) goto L55;
        String r36 = r35.i;
    L56:
        r34.setImageURI(UriProtector.parse(r36));
        goto L57
    L55:
        r36 = null;
    L57:
        View r37 = r33.d;
        if (r37 == null) goto L60;
        r37.setVisibility(0);
    L60:
        long r38 = r33.c;
        float r111 = 44.0f;
        if (r38 != 1) goto L70;
        String r39 = o.a(String.valueOf(r1.discount));
        TextView r40 = r33.h;
        if (r40 == null) goto L65;
        SpannableString r41 = new SpannableString(r39 + s1.B(2131919132));
        r41.setSpan(new AbsoluteSizeSpan((int) UIUtils.dip2Px(r33.b, 44.0f)), 0, r39.length(), 17);
        r41.setSpan(new StyleSpan(1), 0, r39.length(), 17);
        r41.setSpan(new AbsoluteSizeSpan((int) UIUtils.dip2Px(r33.b, 11.0f)), r39.length(), r39.length() + 1, 17);
        Unit r42 = Unit.INSTANCE;
        r40.setText(r41);
    L65:
        TextView r43 = r33.f;
        if (r43 == null) goto L68;
        r43.setText(r1.typeString);
    L68:
        r33.b(r1);
    L102:
        r5 = "coupon_result";
        goto L147
    L70:
        if (r38 != 2) goto L86;
        String r44 = o.a(String.valueOf(r1.credit / 100.0f));
        TextView r45 = r33.f;
        if (r45 == null) goto L74;
        r45.setText(s1.B(2131919131));
    L74:
        LiveCouponPriceView r46 = r33.g;
        if (r46 == null) goto L77;
        r46.setPriceText(r44);
    L77:
        LiveCouponPriceView r47 = r33.g;
        if (r47 == null) goto L84;
        Context r48 = r33.b;
        if (r44.length() < 6) goto L83;
        r111 = 24.0f;
    L83:
        float r49 = UIUtils.dip2Px(r48, r111);
        float r50 = UIUtils.dip2Px(r33.b, 17.0f);
        r47.k = r49;
        r47.b.setTextSize(r49);
        r47.c.setTextSize(r50);
        r47.requestLayout();
        r47.invalidate();
    L84:
        r33.b(r1);
        goto L102
    L86:
        if (r38 != 3) goto L102;
        String r51 = o.a(String.valueOf(r1.credit / 100.0f));
        TextView r52 = r33.f;
        if (r52 == null) goto L91;
        r52.setText(s1.C(2131919135, new Object[]{o.a(String.valueOf(r1.threshold / 100.0f))}));
    L91:
        LiveCouponPriceView r53 = r33.g;
        if (r53 == null) goto L94;
        r53.setPriceText(r51);
    L94:
        LiveCouponPriceView r54 = r33.g;
        if (r54 == null) goto L101;
        Context r55 = r33.b;
        if (r51.length() < 6) goto L100;
        r111 = 24.0f;
    L100:
        float r56 = UIUtils.dip2Px(r55, r111);
        float r57 = UIUtils.dip2Px(r33.b, 17.0f);
        r54.k = r56;
        r54.b.setTextSize(r56);
        r54.c.setTextSize(r57);
        r54.requestLayout();
        r54.invalidate();
    L101:
        r33.b(r1);
        goto L147
    L35:
        if (r10.activityType != 1) goto L37;
        boolean r112 = true;
    L38:
        if (r112 == true) goto L41;
        r10 = null;
    L41:
        if (r10 == null) goto L45;
        r11 = r10.afterButton;
        if (r11 == null) goto L45;
    L37:
        r112 = false;
        goto L38
    L21:
        if (r7.activityType != 1) goto L23;
        boolean r113 = true;
    L24:
        if (r113 == true) goto L27;
        r7 = null;
    L27:
        if (r7 == null) goto L31;
        r8 = r7.afterText;
        if (r8 == null) goto L31;
    L23:
        r113 = false;
    L155:
        r5 = "coupon_result";
    L158:
        if (r31 == false) goto L166;
        if (r30 == null) goto L162;
        String r58 = r30.d();
        if (r58 == null) goto L162;
    L164:
        if (TextUtils.isEmpty(r58) == false) goto L170;
        r58 = s1.B(2131919133);
    L170:
        r29.f0(r58, r31);
        i0("livesdk_coupon_result", new String[]{"coupon_result", "0"});
        return;
    L162:
        r58 = "";
        goto L164
    L166:
        LiveCouponView r59 = r29.h;
        if (r59 == null) goto L169;
        r59.m = 0;
    L169:
        r58 = s1.B(2131919134);
        goto L170
    L6:
        r4 = false;
        goto L8
    L7:
        r4 = true;
        goto L8
    }

    public static final void d0(LiveCouponPresenter r4, String r5, Integer r6, String... r7) {
        r4.getClass();
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L19
        int r1 = 0;
        int r2 = 1;
        if (r7.length != 0) goto L6;
        boolean r0 = true;
    L8:
        if ((!r0) == true) goto L10;
    L14:
        IHostMonitor r9 = TTLiveSDK.hostService().monitor();     // Catch: Exception -> L19
        if (r6 == null) goto L17;
        r2 = r6.intValue();     // Catch: Exception -> L19
    L17:
        r9.monitorStatusRate(r5, r2, r8);     // Catch: Exception -> L19
        return;
    L10:
        if ((r7.length % 2) != 0) goto L14;
    L12:
        if (r1 >= r7.length) goto L14;
        r8.put(r7[r1], r7[r1 + 1]);     // Catch: Exception -> L19
        r1 = r1 + 2;     // Catch: Exception -> L19
        goto L12
    L6:
        r0 = false;
    }
}
