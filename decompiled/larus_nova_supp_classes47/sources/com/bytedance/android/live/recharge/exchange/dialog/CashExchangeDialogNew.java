package com.bytedance.android.live.recharge.exchange.dialog;

import am2.x;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.incentive.exchange.i;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.exchange.model.g;
import com.bytedance.android.live.recharge.exchange.trace.ExchangeTraceKey;
import com.bytedance.android.live.recharge.model.ExchangeInfo;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.bytedance.android.live.recharge.trace.ExchangeTraceEvent;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import com.bytedance.android.live.recharge.utils.q;
import com.bytedance.android.live.recharge.utils.r;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.live.kmp.core.KmpEnv;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jw0.h;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import org.json.JSONObject;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/dialog/CashExchangeDialogNew;", "Lcom/bytedance/android/live/recharge/exchange/dialog/AbsCashExchangeDialog;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "a", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CashExchangeDialogNew extends AbsCashExchangeDialog implements LifecycleOwnerCompat {
    public static final /* synthetic */ int u = 0;
    public final CompositeDisposable a;
    public View b;
    public HSImageView c;
    public TextView d;
    public View e;
    public TextView f;
    public ToggleButton g;
    public View h;
    public Button i;
    public String j;
    public TextView k;
    public ImageView l;
    public ViewGroup m;
    public TextView n;
    public final yw0.a o;
    public com.bytedance.android.live.recharge.exchange.a p;
    public final LifecycleRegistry q;
    public final boolean r;
    public JSONObject s;
    public String t;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CashExchangeDialogNew a;

        public b(CashExchangeDialogNew r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            g r5 = (g) r4;
            CashExchangeDialogNew r0 = this.a;
            int r1 = CashExchangeDialogNew.u;
            r0.getClass();
            if (r5 == null) goto L5;
            Integer r6 = Integer.valueOf(r5.a);
        L6:
            if (r6 != null) goto L9;
        L11:
            if (r6 != null) goto L14;
            return;
        L14:
            if (r6.intValue() != 6) goto L17;
        L15:
            r0.q.markState(Lifecycle.State.DESTROYED);
            return;
        L17:
            return;
        L9:
            if (r6.intValue() != 5) goto L11;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ CashExchangeDialogNew a;
        public final /* synthetic */ zv0.e b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ int e;

        public c(CashExchangeDialogNew r1, zv0.e r2, long r3, long r5, int r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r7;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            zv0.e r13 = this.b;
            if (r13 == null) goto L5;
            r13.b();
        L5:
            int r14 = h.a;
            long r0 = this.c;
            long r4 = this.d;
            long r2 = r0 + r4;
            ToggleButton r15 = this.a.g;
            if (r15 == null) goto L8;
            Boolean r7 = Boolean.valueOf(r15.isChecked());
        L9:
            h.d(r2, r4, 3, r7, Integer.valueOf(this.e), "close");
            if (r.a() >= 3) goto L12;
            r.c.setValue(null, r.a[1], Integer.valueOf(r.a() + 1));
        L12:
            this.a.q.markState(Lifecycle.State.DESTROYED);
            LifecycleOwnerCompat r16 = this.a;
            Handler r1 = DialogLancet.resolveDialogHandler(r16);
            if (r1 != null) goto L15;
        L17:
            DialogLancet.beforeDialogDismiss(r16);
            r16.dismiss();     // Catch: Throwable -> L20 Exception -> L22
        L26:
            DialogLancet.afterDialogDismiss(r16);
            return;
        L20:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r16);
            throw th;
        L22:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L20
            Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L20
            if (r3 == null) goto L26;
            com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L20
            goto L26
        L15:
            if (Looper.myLooper() == r1.getLooper()) goto L17;
            r1.post(DialogLancet.createDismissRunnable(r16));
            return;
        L8:
            r7 = null;
            goto L9
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ CashExchangeDialogNew a;

        public d(CashExchangeDialogNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            ToggleButton r6 = this.a.g;
            boolean r0 = false;
            if (r6 == null) goto L9;
            boolean r2 = true;
            if (r6.isChecked() != true) goto L8;
            r2 = false;
        L8:
            r6.setChecked(r2);
        L9:
            ToggleButton r7 = this.a.g;
            if (r7 == null) goto L12;
            r0 = r7.isChecked();
        L12:
            StringBuilder r8 = new StringBuilder();
            if (r0 == false) goto L15;
            String r1 = DataType.TRUE;
        L16:
            r8.append(r1);
            r8.append('_');
            r8.append(System.currentTimeMillis());
            String r9 = r8.toString();
            com.bytedance.android.live.recharge.util.a r3 = com.bytedance.android.live.recharge.util.a.i;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            com.bytedance.android.live.recharge.util.a.e.setValue(r3, com.bytedance.android.live.recharge.util.a.a[3], r9);
            return;
        L15:
            r1 = DataType.FALSE;
            goto L16
        }
    }

    static {
    }

    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final void onStop() {
        super.onStop();
        this.a.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r0 = getWindow();
        if (r0 == null) goto L10;
        WindowManager.LayoutParams r1 = new WindowManager.LayoutParams();
        r1.copyFrom(r0.getAttributes());
        r1.width = s1.f(280.0f);
        r1.height = -2;
        r0.setAttributes(r1);
    L10:
        com.bytedance.tools.kcp.spongepreference.runtime.a r2 = r.b;
        KProperty[] r3 = r.a;
        Map r4 = MapsKt.toMutableMap((Map) r2.getValue(null, r3[0]));
        String r5 = jta.g.d();
        this.o.getClass();
        r4.put(r5, new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date(System.currentTimeMillis())));
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.setValue(null, r3[0], r4);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L6:
        DialogLancet.beforeDialogShow(this);
        super/*android.app.Dialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public final Lifecycle getLifecycleCompat() {
        return this.q;
    }

    public CashExchangeDialogNew(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, 0);
        init(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void init(Context r4) {
        xw0.a r1 = null;
        View r5 = LayoutInflater.from(getContext()).inflate(2131565413, null);
        this.b = r5;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L5:
        setContentView(r5);
        View r6 = this.b;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L8:
        this.c = r6.findViewById(2131373724);
        View r7 = this.b;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L11:
        this.d = (TextView) r7.findViewById(2131388772);
        View r8 = this.b;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L14:
        this.e = r8.findViewById(2131367862);
        View r9 = this.b;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L17:
        this.f = (TextView) r9.findViewById(2131367794);
        View r10 = this.b;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L20:
        this.g = (ToggleButton) r10.findViewById(2131389031);
        View r12 = this.b;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L23:
        this.h = r12.findViewById(2131389032);
        View r13 = this.b;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L26:
        this.i = (Button) r13.findViewById(2131371843);
        View r14 = this.b;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L29:
        this.m = (ViewGroup) r14.findViewById(2131388198);
        View r15 = this.b;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L32:
        this.n = (TextView) r15.findViewById(2131388200);
        View r16 = this.b;
        if (r16 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L35:
        this.k = (TextView) r16.findViewById(2131367972);
        View r17 = this.b;
        if (r17 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L38:
        this.l = (ImageView) r17.findViewById(2131371852);
        RechargeFacadeUtilsKt.a().getClass();
        xw0.a r18 = (xw0.a) ((dy0.d) f.d(j.C0.a(), xw0.a.class));
        if ((r18 instanceof com.bytedance.android.live.recharge.exchange.a) == false) goto L42;
        r1 = r18;
    L42:
        this.p = (com.bytedance.android.live.recharge.exchange.a) r1;
        this.q.markState(Lifecycle.State.STARTED);
        com.bytedance.android.live.recharge.exchange.a r19 = this.p;
        if (r19 == null) goto L48;
        MutableLiveData<g> r20 = r19.a;
        if (r20 == null) goto L49;
        r20.observe(this, new b(this));
        return;
    L49:
        return;
    }

    public CashExchangeDialogNew(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        super(r1);
        this.a = new CompositeDisposable();
        this.o = new yw0.a();
        this.q = new LifecycleRegistry(this);
        this.r = com.bytedance.android.live.recharge.utils.e.c();
        this.s = new JSONObject();
        this.t = "";
        init(r1);
    }

    @Override // com.bytedance.android.live.recharge.exchange.dialog.AbsCashExchangeDialog
    public final void I0(ExchangeType r29, k r30, long r32, String r33, boolean r34, Map<String, String> r35, zv0.e r36) {
        Intrinsics.checkNotNullParameter(r29, "type");
        Intrinsics.checkNotNullParameter(r35, "extraMap");
        Map<String, String> r1 = com.bytedance.android.live.recharge.exchange.trace.a.a;
        com.bytedance.android.live.recharge.exchange.trace.a.c(r35);
        com.bytedance.android.live.recharge.exchange.trace.a.b(ExchangeTraceKey.KEY_IS_LACK_DIAMOND_DIALOG, DataType.TRUE);
        Integer r3 = null;
        if (r30 == null) goto L16;
        List r4 = r30.getUrls();
        if (r4 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L16;
        HSImageView r6 = this.c;
        if (r6 == null) goto L37;
        Intrinsics.checkNotNullParameter(r6, "$this$bindImage");
        ImageLoader.bindImage(r6, r30);
    L37:
        ExchangeInfo r8 = ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getExchangeInfo();
        String r16 = q.a(r32 * 10);
        if (i.a() == false) goto L41;
        com.bytedance.android.live.incentive.balance.b.b r0 = com.bytedance.android.live.incentive.balance.b.b.a;
    L44:
        com.bytedance.android.live.incentive.exchange.d r7 = qa0.c.b.getService(com.bytedance.android.live.incentive.exchange.d.class);
        Intrinsics.checkNotNull(r7);
        long r9 = r7.c(r0);
        int r2 = (int) r32;
        String r10 = q.b(r9 - (((long) r2) * 10));
        int r12 = com.bytedance.android.live.recharge.util.d.a;
        if (r8 == null) goto L47;
        Integer r13 = Integer.valueOf(r8.getLeftAmount());
    L48:
        Integer r14 = Integer.valueOf(r2);
        if (r8 == null) goto L51;
        Integer r15 = Integer.valueOf(r8.getRebateLimit());
    L52:
        if (r8 == null) goto L54;
        r3 = Integer.valueOf(r8.getGiftAmount());
    L54:
        if (r15 != null) goto L56;
    L62:
        int r17 = 0;
    L63:
        Button r18 = this.i;
        if (r18 == null) goto L66;
        r18.setText(s1.C(2131915510, new Object[]{r3.c()}));
    L66:
        this.j = r3.b();
        TextView r19 = this.k;
        if (r19 == null) goto L69;
        r19.setText(s1.C(2131915489, new Object[]{q.b(r9), r10}));
    L69:
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        String r20 = "";
        r110.element = "";
        Ref.ObjectRef r22 = new Ref.ObjectRef();
        r22.element = "";
        if (com.bytedance.android.live.recharge.utils.e.d() == false) goto L84;
        if (i.a() == true) goto L84;
        tz0.b r23 = tz0.b.a;
        uz0.c r24 = new uz0.c();
        r23.getClass();
        Intrinsics.checkNotNullParameter(r24, "$this$beforeConfigureRequest");
        Map<String, String> r25 = r24.b;
        Intrinsics.checkNotNullParameter(r25, "queriesMap");
        String r26 = Long.valueOf(r32).toString();
        Intrinsics.checkNotNullParameter("diamond_count", "$this$setTo");
        if (r26 == null) goto L76;
        r25.put("diamond_count", r26);
    L76:
        Integer r27 = 0;
        String r28 = r27.toString();
        Intrinsics.checkNotNullParameter("source", "$this$setTo");
        if (r28 == null) goto L79;
        r25.put("source", r28);
    L79:
        Integer r37 = 1;
        String r38 = r37.toString();
        Intrinsics.checkNotNullParameter("exchange_type", "$this$setTo");
        if (r38 == null) goto L82;
        r25.put("exchange_type", r38);
    L82:
        Intrinsics.checkNotNullParameter(r24, "$this$afterConfigureRequest");
        RxUtilKt.c(((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/wallet_api/trial_exchange_income/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.recharge.platform.business.model.income.e.class)), Extra.class, r24.d, r24.a, r24.b, r24.c).singleOrError().compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.recharge.exchange.dialog.b(this, r110, r22, r32, r9, r8, r33, r29, r34, r17, r35, r36), new com.bytedance.android.live.recharge.exchange.dialog.c(this, r110, r22, r16, r32, r33, r29, r34, r17, r35, r36)), this.a);
        return;
    L84:
        if (i.a() == false) goto L86;
        String r39 = s1.B(2131915486);
    L88:
        switch(com.bytedance.android.live.recharge.exchange.dialog.a.a[r29.ordinal()]) {
            case 1: goto L97;
            case 2: goto L97;
            case 3: goto L94;
            case 4: goto L93;
            case 5: goto L92;
            case 6: goto L92;
            case 7: goto L92;
            case 8: goto L91;
            case 9: goto L90;
            default: goto L89;
        };
    L89:
        Ref.ObjectRef r111 = r110;
        r111.element = s1.C(2131915515, new Object[]{r3.c()});
        String r40 = s1.B(2131915481);
    L105:
        String r42 = String.valueOf(r32);
        String r43 = this.j;
        if (r43 == null) goto L109;
        r20 = r43;
    L109:
        String r44 = s1.C(2131915487, new Object[]{r16, r39, r42, r20, r40});
        r22.element = r44;
        J0(r33, r29, (String) r111.element, r44, r32, r34, r17, r35, r36);
        return;
    L90:
        r111 = r110;
        r111.element = s1.C(2131915477, new Object[]{r3.c()});
        r40 = s1.B(2131915482);
        goto L105
    L91:
        r111 = r110;
        r111.element = s1.C(2131915515, new Object[]{r3.c()});
        r40 = s1.B(2131915481);
        goto L105
    L92:
        r111 = r110;
        r111.element = s1.C(2131915515, new Object[]{r3.c()});
        r40 = s1.B(2131915481);
        goto L105
    L93:
        r111 = r110;
        r111.element = s1.C(2131915515, new Object[]{r3.c()});
        r40 = s1.B(2131915483);
        goto L105
    L94:
        r111 = r110;
        r111.element = s1.C(2131915550, new Object[]{r3.c()});
        r40 = s1.B(2131915484);
        Button r45 = this.i;
        if (r45 == null) goto L105;
        r45.setText(s1.C(2131915547, new Object[]{r3.c()}));
        goto L105
    L97:
        r111 = r110;
        r111.element = s1.C(2131915505, new Object[]{r3.c()});
        String r46 = s1.B(2131915480);
        TextView r47 = this.k;
        if (r47 == null) goto L100;
        int r48 = 1;
        r47.setText(s1.C(2131915494, new Object[]{q.b(r9), r10}));
    L101:
        Button r49 = this.i;
        if (r49 == null) goto L104;
        Object[] r50 = new Object[r48];
        r50[0] = r3.c();
        r49.setText(s1.C(2131915521, r50));
    L104:
        r40 = r46;
        goto L105
    L100:
        r48 = 1;
        goto L101
    L86:
        r39 = s1.B(2131915485);
        goto L88
    L56:
        if (r15.intValue() == 0) goto L62;
        if (r13 == null) goto L62;
        if (r14 == null) goto L62;
        if (r3 == null) goto L62;
        r17 = ((r13.intValue() + r14.intValue()) / r15.intValue()) * r3.intValue();
        goto L63
    L51:
        r15 = null;
        goto L52
    L47:
        r13 = null;
        goto L48
    L41:
        if (va0.a.a == false) goto L43;
        r0 = com.bytedance.android.live.incentive.balance.b.a.a;
        goto L44
    L43:
        r0 = com.bytedance.android.live.incentive.balance.b.e.a;
        goto L44
    L7:
        if (r4.isEmpty() == true) goto L10;
        r5 = false;
    L16:
        HSImageView r52 = this.c;
        if (r52 == null) goto L19;
        ViewUtilsKt.e(r52);
    L19:
        View r53 = this.e;
        if (r53 == null) goto L22;
        ViewGroup.LayoutParams r54 = r53.getLayoutParams();
    L24:
        if ((r54 instanceof ViewGroup.MarginLayoutParams) == false) goto L28;
        ((ViewGroup.MarginLayoutParams) r54).topMargin = 0;
        View r55 = this.e;
        if (r55 == null) goto L28;
        r55.setLayoutParams(r54);
    L28:
        TextView r56 = this.d;
        if (r56 == null) goto L31;
        ViewGroup.LayoutParams r57 = r56.getLayoutParams();
    L33:
        if ((r57 instanceof ViewGroup.MarginLayoutParams) == false) goto L37;
        ((ViewGroup.MarginLayoutParams) r57).topMargin = s1.f(24.0f);
        TextView r58 = this.d;
        if (r58 == null) goto L37;
        r58.setLayoutParams(r57);
        goto L37
    L31:
        r57 = null;
        goto L33
    L22:
        r54 = null;
        goto L24
    }

    public final void J0(String r17, ExchangeType r18, String r19, String r20, final long r22, final boolean r23, final int r24, Map<String, String> r25, final zv0.e r26) {
        String r1 = "";
        switch(com.bytedance.android.live.recharge.exchange.dialog.a.b[r18.ordinal()]) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        this.t = "";
    L22:
        HashMap<Class<?>, com.bytedance.android.livesdk.revenue.log.d<?>> r0 = com.bytedance.android.live.recharge.utils.f.a;
        Intrinsics.checkNotNullParameter(hx0.b.class, "logClass");
        Intrinsics.checkNotNullParameter(hx0.b.class, "logClass");
        com.bytedance.android.livesdk.revenue.log.d<?> r2 = com.bytedance.android.live.recharge.utils.f.a.get(hx0.b.class);
        if (r2 == null) goto L116;
        r2.b(new gx0.a(this.t, 6));
        TextView r3 = this.d;
        if (r3 == null) goto L27;
        r3.setText(r19);
    L27:
        TextView r4 = this.f;
        if (r4 == null) goto L30;
        r4.setText(r20);
    L30:
        final long r13 = ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getAvailableDiamonds();
        ImageView r8 = this.l;
        if (r8 == null) goto L33;
        r8.setOnClickListener(new c(this, r26, r13, r22, r24));
    L33:
        Button r15 = this.i;
        if (r15 == null) goto L36;
        r15.setOnClickListener(new CashExchangeDialogNew$setDialogUI$2(this, r13, r22, r24, r26, r23));
    L36:
        View r5 = this.h;
        if (r5 == null) goto L39;
        r5.setOnClickListener(new d(this));
    L39:
        int r6 = com.bytedance.android.live.recharge.util.d.a;
        KmpEnv r7 = KmpEnv.a;
        if (KmpEnv.b() == true) goto L42;
    L44:
        boolean r9 = false;
    L46:
        if (r9 == false) goto L48;
    L56:
        boolean r10 = true;
    L57:
        if (r10 == false) goto L91;
        TextView r12 = this.d;
        if (r12 == null) goto L61;
        ViewUtilsKt.e(r12);
    L61:
        TextView r14 = this.f;
        int r16 = s1.f(25.0f);
        if (r14 == null) goto L64;
        ViewGroup.LayoutParams r27 = r14.getLayoutParams();
    L66:
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == false) goto L68;
        ((ViewGroup.MarginLayoutParams) r27).topMargin = r16;
        r14.setLayoutParams(r27);
    L68:
        TextView r28 = this.f;
        if (r28 == null) goto L71;
        r28.setTypeface(Typeface.DEFAULT_BOLD);
    L71:
        TextView r29 = this.k;
        if (r29 == null) goto L74;
        r29.setTextSize(14.0f);
    L74:
        Button r30 = this.i;
        if (r30 == null) goto L77;
        r30.setText(r19);
    L77:
        if (r24 <= 0) goto L91;
        Button r32 = this.i;
        if (r32 == null) goto L82;
        r32.setText(s1.C(2131915508, new Object[]{r19, String.valueOf(r24)}));
    L82:
        if (r18 != ExchangeType.EXCHANGE_TYPE_GIFT) goto L84;
    L87:
        Button r33 = this.i;
        if (r33 == null) goto L91;
        r33.setText(s1.C(2131915551, new Object[]{String.valueOf(r24)}));
        goto L91
    L84:
        if (r18 == ExchangeType.EXCHANGE_TYPE_FAST_GIFT) goto L87;
        if (r18 != ExchangeType.EXCHANGE_TYPE_GIFT_GUIDE) goto L91;
    L64:
        r27 = null;
    L91:
        if (KmpEnv.b() == false) goto L93;
    L94:
        ((com.bytedance.android.live.recharge.utils.d) com.bytedance.android.live.recharge.utils.j.b.getValue(null, com.bytedance.android.live.recharge.utils.j.a[0])).getClass();
    L95:
        ((ToggleButton) findViewById(2131389031)).setChecked(r23);
        TextView r34 = (TextView) findViewById(2131390184);
        if (this.r == false) goto L98;
        String r35 = s1.B(2131916495);
    L99:
        r34.setText(r35);
        if (TextUtils.isEmpty(r17) == true) goto L107;
        ViewGroup r36 = this.m;
        if (r36 == null) goto L104;
        ViewUtilsKt.f(r36);
    L104:
        TextView r37 = this.n;
        if (r37 == null) goto L107;
        r37.setText(r17);
    L107:
        int r38 = h.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_exchange_paypopup_show", new HashMap(), new Class[]{IRoom.class, x.class, hx0.b.class});
        int r39 = com.bytedance.android.live.recharge.trace.a.a;
        com.bytedance.android.live.recharge.trace.a.a(ExchangeTraceEvent.DIAMOND_AUTO_EXCHANGE.getEventType(), "show_prompt_dialog", new CashExchangeDialogNew$setDialogUI$4(this));
        if (com.bytedance.android.live.recharge.utils.e.d() == true) goto L110;
        return;
    L110:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L118;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L118:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L117
    L113:
        DialogLancet.beforeDialogShow(this);
        show();
        DialogLancet.afterDialogShow(this);
        return;
    L98:
        r35 = s1.C(2131920817, new Object[]{r3.c()});
        goto L99
    L93:
        if (KmpEnv.c() == false) goto L95;
    L48:
        if (KmpEnv.b() == true) goto L50;
    L52:
        boolean r40 = false;
    L53:
        if (r40 == true) goto L56;
        r10 = false;
        goto L57
    L50:
        if (((Number) com.bytedance.android.live.recharge.util.e.c.getValue(null, com.bytedance.android.live.recharge.util.e.a[1])).intValue() != 2) goto L52;
        r40 = true;
        goto L53
    L42:
        if (((Number) com.bytedance.android.live.recharge.util.e.c.getValue(null, com.bytedance.android.live.recharge.util.e.a[1])).intValue() != 1) goto L44;
        r9 = true;
        goto L46
    L116:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.log.IRevLiveLogFilter<T>");
    L5:
        this.t = "5";
        String r42 = r25.get("gift_source");
        if (StringUtils.isEmpty(r42) == true) goto L22;
        if (Intrinsics.areEqual(r42, "convenient") == false) goto L10;
        r1 = "7";
    L14:
        this.t = r1;
        goto L22
    L10:
        String r43 = (String) ((Map) com.bytedance.android.live.recharge.utils.j.g.getValue(null, com.bytedance.android.live.recharge.utils.j.a[5])).get(r42);
        if (r43 == null) goto L14;
        r1 = r43;
        goto L14
    L15:
        this.t = "14";
        goto L22
    L16:
        this.t = "13";
        goto L22
    L17:
        this.t = "12";
        goto L22
    L18:
        this.t = "11";
        goto L22
    L19:
        this.t = "10";
        goto L22
    L20:
        this.t = "9";
        goto L22
    L21:
        this.t = "7";
        goto L22
    }
}
