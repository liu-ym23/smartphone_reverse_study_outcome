package com.bytedance.android.live.revlink.impl.intercomment;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import r11.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Deprecated(message = "回合前移植到lynx，内部实现不再维护")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/intercomment/InteractCommentWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/revlink/impl/intercomment/b;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class InteractCommentWidget extends LiveWidget implements com.bytedance.android.live.revlink.impl.intercomment.b {
    public static final /* synthetic */ int n = 0;
    public InteractCommentDataContext a;
    public final CompositeDisposable b;
    public InteractCommentView c;
    public final com.bytedance.android.livesdk.revenue.room.a d;
    public final boolean e;
    public i11.b f;
    public int g;
    public final com.bytedance.android.live.revlink.impl.intercomment.e h;
    public long i;
    public final l j;
    public final m k;
    public final k l;
    public final int m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ InteractCommentWidget a;

        public b(InteractCommentWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            this.a.xq();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ InteractCommentWidget a;

        public c(InteractCommentWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) r2;
            InteractCommentWidget r4 = this.a;
            int r0 = InteractCommentWidget.n;
            r4.yq(false);
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ InteractCommentWidget a;

        public d(InteractCommentWidget r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            InteractCommentDataContext r4 = this.a.a;
            if (r4 == null) goto L5;
            r4.close();
        L5:
            this.a.g++;
            r2.dismiss();
        }
    }

    public static final class e implements DialogInterface.OnClickListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.intercomment.b
    public final boolean a0() {
        InteractCommentDataContext r0 = this.a;
        if (r0 == null) goto L7;
        LiveData<Integer> r1 = r0.getInterComState();
        if (r1 == null) goto L7;
        Integer r2 = (Integer) r1.getValue();
    L8:
        if (r2 != null) goto L11;
    L13:
        return false;
    L11:
        if (r2.intValue() != 4) goto L13;
        return true;
    L7:
        r2 = null;
        goto L8
    }

    public final InteractCommentView wq() {
        if (this.m == 1) goto L7;
        return null;
    L7:
        return this.c;
    }

    public final void xq() {
        InteractCommentDataContext r0 = this.a;
        if (r0 == null) goto L8;
        LiveData<Integer> r1 = r0.getInterComState();
        if (r1 == null) goto L8;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L8;
    L9:
        int r3 = r2.intValue();
        if (this.e == true) goto L16;
        if (r3 != 4) goto L13;
        ToastUtil.a(2131917460, 0);
    L13:
        this.h.b(r3, false);
        return;
    L16:
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L35;
        ToastUtil.a(2131917461, 0);
    L50:
        if (this.e == false) goto L56;
        this.h.b(r3, true);
        return;
    L56:
        return;
    L35:
        if (r3 != 4) goto L50;
        z0 r4 = z0.a();
        Context r5 = getContext();
        r4.getClass();
        x0.b r6 = new x0.b(r5, 4);
        r6.m(2131917465);
        if (this.g < 3) goto L39;
    L47:
        int r7 = 2131917464;
    L48:
        r6.l(r7);
        r6.i(0, 2131920806, new d(this));
        r6.i(1, 2131915442, e.a);
        r6.n();
        goto L50
    L39:
        if (System.currentTimeMillis() > this.i) goto L41;
    L43:
        boolean r8 = false;
    L44:
        if (r8 == true) goto L47;
        r7 = 2131917463;
        goto L48
    L41:
        if ((System.currentTimeMillis() - this.i) > 30000) goto L43;
        r8 = true;
        goto L44
    L18:
        if (l51.a.n() == false) goto L25;
        InteractCommentInviteDialog r9 = new InteractCommentInviteDialog(((Widget) this).context, new o(this));
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r9);
    L30:
        InteractCommentView r10 = wq();
        if (r10 == null) goto L50;
        r10.a(2131374123).setVisibility(8);
        goto L50
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L53
    L23:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L30
    L25:
        if (this.e == false) goto L27;
        this.h.d(false, false);
    L27:
        InteractCommentDataContext r12 = this.a;
        if (r12 == null) goto L30;
        r12.invite();
    L8:
        r2 = 0;
        goto L9
    }

    public InteractCommentWidget() {
        this.m = 7;
        this.b = new CompositeDisposable();
        com.bytedance.android.livesdk.revenue.service.room.c r1 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r1 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r2 = r1.getRoomContext();
    L6:
        this.d = r2;
        if (r2 == null) goto L13;
        com.bytedance.live.datacontext.i r3 = r2.isAnchor();
        if (r3 == null) goto L13;
        Boolean r4 = (Boolean) r3.getValue();
        if (r4 == null) goto L13;
        boolean r5 = r4.booleanValue();
    L14:
        this.e = r5;
        this.h = new com.bytedance.android.live.revlink.impl.intercomment.e(7);
        this.j = new l(this);
        this.k = new m(this);
        this.l = new k(this);
        return;
    L13:
        r5 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final void onCreate() {
        super.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(new InteractCommentWidget$onCreate$dataPair$1(this));
        this.a = (InteractCommentDataContext) r0.getFirst();
        DataContext r1 = (DataContext) r0.getFirst();
        InteractCommentDataContext.Companion.getClass();
        com.bytedance.live.datacontext.b.a(r1, InteractCommentDataContext.access$getTAG$cp());
        ((InteractCommentDataContext) r0.getFirst()).getService().d(this);
        this.b.add((Disposable) r0.getSecond());
        if (this.m != 7) goto L11;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r2 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r2 == null) goto L7;
        i11.b r3 = r2.getLinkUserCenter();
    L8:
        this.f = r3;
        if (r3 == null) goto L11;
        r3.i(this.j);
        goto L11
    L7:
        r3 = null;
    L11:
        int r4 = this.m;
        boolean r5 = true;
        if (r4 != 1) goto L14;
        ViewGroup r6 = ((Widget) this).containerView;
    L15:
        if (r6 == null) goto L18;
        if (r4 != 1) goto L18;
        InteractCommentView r7 = new InteractCommentView(r6.getContext());
        r6.addView(r7);
        Unit r8 = Unit.INSTANCE;
        this.c = r7;
    L18:
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r9 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r9.getClass();
        ReadOnlyProperty r10 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.y;
        KProperty[] r12 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.a;
        if (((Boolean) r10.getValue(r9, r12[23])).booleanValue() == false) goto L21;
    L22:
        InteractCommentView r13 = wq();
        if (r13 == null) goto L25;
        a1.k(r13, 0);
    L25:
        InteractCommentView r14 = wq();
        if (r14 == null) goto L29;
        a1.p(r14, 0);
    L29:
        if (this.m != 1) goto L31;
        ViewGroup r15 = ((Widget) this).containerView;
    L32:
        if (r15 == null) goto L35;
        a1.p(r15, 0);
    L35:
        if (this.m != 1) goto L37;
        ViewGroup r16 = ((Widget) this).containerView;
    L38:
        if (r16 == null) goto L40;
        a1.k(r16, 0);
    L40:
        InteractCommentDataContext r17 = this.a;
        if (r17 == null) goto L45;
        LiveData<Integer> r18 = r17.getInterComState();
        if (r18 == null) goto L45;
        r18.observeForever(this.l);
    L45:
        com.bytedance.android.live.revlink.impl.pk.utils.q r19 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r19 == null) goto L52;
        PkScopeProviderService r20 = r19.a;
        if (r20 == null) goto L52;
        MutableLiveData<q11.b> r22 = r20.a;
        if (r22 == null) goto L52;
        r22.observeForever(this.k);
    L52:
        yq(true);
        InteractCommentDataContext r23 = this.a;
        if (r23 == null) goto L61;
        com.bytedance.live.datacontext.k<Object> r24 = r23.getOnIconClickEvent();
        if (r24 == null) goto L61;
        PublishSubject r25 = r24.onEvent();
        if (r25 == null) goto L61;
        Disposable r26 = r25.subscribe(new b(this));
        if (r26 == null) goto L61;
        this.b.add(r26);
    L61:
        InteractCommentView r27 = wq();
        if (r27 == null) goto L64;
        r27.setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new AnonymousClass4(this)));
    L64:
        InteractCommentView r28 = wq();
        if (r28 == null) goto L67;
        r28.a(2131374123).setVisibility(8);
    L67:
        u r29 = s41.b.c.a();
        if (r29.a() == true) goto L70;
    L72:
        r5 = false;
    L73:
        if (r5 == true) goto L75;
    L78:
        com.bytedance.android.livesdk.revenue.room.a r30 = this.d;
        if (r30 == null) goto L88;
        com.bytedance.live.datacontext.m r32 = r30.getCleanMode();
        if (r32 == null) goto L88;
        Observable r33 = r32.a();
        if (r33 == null) goto L88;
        Disposable r34 = r33.subscribe(new c(this));
        if (r34 == null) goto L88;
        RxUtilKt.c(r34, this.b);
    L88:
        if (this.e == true) goto L91;
        mz0.d.a(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.intercomment.d.class), com.bytedance.android.live.revlink.impl.intercomment.d.b);
        return;
    L91:
        return;
    L75:
        if (l51.a.n() == true) goto L77;
        l51.a.J.setValue(null, l51.a.a[36], Boolean.TRUE);
    L77:
        l51.a.I.setValue(null, l51.a.a[35], Integer.valueOf(r29.c()));
        goto L78
    L70:
        if (r29.c() <= ((Number) l51.a.I.getValue(null, l51.a.a[35])).intValue()) goto L72;
    L37:
        r16 = null;
        goto L38
    L31:
        r15 = null;
        goto L32
    L21:
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.B.getValue(r9, r12[26])).booleanValue() == false) goto L40;
    L14:
        r6 = null;
        goto L15
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.m != 1) goto L5;
        ViewGroup r0 = ((Widget) this).containerView;
    L6:
        if (r0 == null) goto L8;
        r0.setVisibility(8);
    L8:
        CompositeDisposable r1 = this.b;
        if (r1 == null) goto L11;
        r1.dispose();
    L11:
        com.bytedance.android.live.revlink.impl.pk.utils.q r2 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r2 == null) goto L18;
        PkScopeProviderService r3 = r2.a;
        if (r3 == null) goto L18;
        MutableLiveData<q11.b> r4 = r3.a;
        if (r4 == null) goto L18;
        r4.removeObserver(this.k);
    L18:
        InteractCommentDataContext r5 = this.a;
        if (r5 == null) goto L23;
        LiveData<Integer> r6 = r5.getInterComState();
        if (r6 == null) goto L23;
        r6.removeObserver(this.l);
    L23:
        i11.b r7 = this.f;
        if (r7 == null) goto L27;
        r7.l(this.j);
    L27:
        if (this.e == true) goto L30;
        mz0.d.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.intercomment.d.class));
        return;
    L30:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void yq(boolean r15) {
        com.bytedance.android.live.revlink.impl.lynxcontainer.a r2 = null;
        if (this.e == false) goto L32;
        InteractCommentDataContext r0 = this.a;
        if (r0 == null) goto L9;
        LiveData<Integer> r1 = r0.getInterComState();
        if (r1 == null) goto L9;
        Integer r3 = (Integer) r1.getValue();
    L10:
        if (r3 == null) goto L32;
        if (r3.intValue() != 4) goto L32;
        if (this.m == 1) goto L24;
        i11.b r4 = this.f;
        if (r4 == null) goto L21;
        List<com.bytedance.android.livesdk.link.model.p> r5 = r4.getOnlineUserList();
        if (r5 == null) goto L21;
        int r6 = r5.size();
    L23:
        if (r6 > 2) goto L32;
    L21:
        r6 = 0;
    L24:
        com.bytedance.android.live.revlink.impl.global.c r7 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r7 == null) goto L27;
        com.bytedance.android.live.revlink.impl.utils.b r8 = r7.getClearScreenLinkUtils();
    L28:
        if (r8 != null) goto L30;
    L31:
        boolean r9 = true;
    L33:
        if (r9 == false) goto L39;
        com.bytedance.android.live.revlink.impl.multianchor.utils.a r10 = com.bytedance.android.live.revlink.impl.global.b.c();
        if (r10 == null) goto L39;
        if (r10.a() != true) goto L39;
        r9 = a0();
    L57:
        if (this.m != 1) goto L59;
        ViewGroup r12 = ((Widget) this).containerView;
    L60:
        if (r9 == false) goto L83;
        if (r12 != null) goto L63;
    L85:
        InteractCommentDataContext r13 = this.a;
        if (r13 == null) goto L90;
        MutableLiveData<Boolean> r14 = r13.getShowInterCommentIcon();
        if (r14 == null) goto L90;
        r14.setValue(Boolean.valueOf(r9));
    L90:
        JSONObject r16 = new JSONObject();
        String r17 = DataType.TRUE;
        if (r9 == false) goto L106;
        if (r15 == true) goto L106;
        InteractCommentDataContext r18 = this.a;
        if (r18 == null) goto L98;
        LiveData<Integer> r19 = r18.getInterComState();
        if (r19 == null) goto L98;
        Integer r110 = (Integer) r19.getValue();
    L99:
        if (r110 != null) goto L102;
    L104:
        r17 = DataType.FALSE;
    L105:
        r16.put("intercom_status", r17);
    L107:
        com.bytedance.android.live.revlink.impl.global.c r111 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r111 == null) goto L110;
        r2 = r111.w2();
    L110:
        if (r2 == null) goto L113;
        r2.b("intercom_data", r16.toString());
        return;
    L113:
        return;
    L102:
        if (r110.intValue() != 4) goto L104;
    L98:
        r110 = null;
    L106:
        r16.put("intercom_status", DataType.FALSE);
        r16.put("close_reason", DataType.TRUE);
        goto L107
    L63:
        if (r12.getVisibility() == 0) goto L85;
        com.bytedance.android.live.revlink.impl.intercomment.e r20 = this.h;
        r20.getClass();
        long r22 = System.currentTimeMillis();
        long r23 = r20.a;
        if (r23 != 0) goto L67;
    L69:
        r20.a = r22;
        HashMap r24 = new HashMap();
        if (r20.b != 1) goto L72;
        String r25 = "pk";
    L73:
        r24.put("connection_scene", r25);
        r20.a(r24);
        LinkCrossRoomDataHolder r26 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r26 == null) goto L76;
        Long r27 = Long.valueOf(r26.c());
    L77:
        r24.put("channel_id", String.valueOf(r27));
        w31.c r28 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r28 == null) goto L80;
        Long r29 = Long.valueOf(r28.i());
    L81:
        r24.put("pk_id", String.valueOf(r29));
        mz0.n r30 = new mz0.n();
        Map<String, String> r32 = r30.a;
        Intrinsics.checkNotNullParameter(r32, "map");
        Intrinsics.checkNotNullParameter(r24, "map");
        r32.putAll(r24);
        mz0.m r33 = new mz0.m();
        r33.b(LogCommon.ROOM);
        r33.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r30.b).addAll(r33.a);
        cy0.e.a.getClass();
        cy0.j r34 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r35 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r35);
        ((mz0.i) ((f80.a) r35)).w3("livesdk_comment_interflow_icon_show", r30.a, r30.b);
    L82:
        r12.setVisibility(0);
        goto L85
    L80:
        r29 = null;
        goto L81
    L76:
        r27 = null;
        goto L77
    L72:
        r25 = "connection";
        goto L73
    L67:
        if (Math.abs(r23 - r22) > 1200) goto L69;
    L83:
        if (r12 == null) goto L85;
        r12.setVisibility(8);
        goto L85
    L59:
        r12 = null;
    L39:
        com.bytedance.android.live.revlink.impl.pk.utils.q r36 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r36 == null) goto L42;
        q11.b r37 = r36.a();
    L44:
        if (Intrinsics.areEqual(r37, q11.b.C0295b.b) == false) goto L57;
        InteractCommentDataContext r38 = this.a;
        if (r38 == null) goto L50;
        LiveData<Integer> r39 = r38.getInterComState();
        if (r39 == null) goto L50;
        Integer r40 = (Integer) r39.getValue();
    L51:
        if (r40 != null) goto L54;
    L55:
        r9 = false;
        goto L57
    L54:
        if (r40.intValue() == 4) goto L57;
    L50:
        r40 = null;
        goto L51
    L42:
        r37 = null;
        goto L44
    L30:
        if (r8.b() == true) goto L32;
    L27:
        r8 = null;
    L9:
        r3 = null;
    L32:
        r9 = false;
        goto L33
    }
}
