package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.depend.livead.ICommerceMessage;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBroadcastFunction;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.BottomToolbarViewModel;
import com.bytedance.android.livesdk.config.cb;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar_behavior/ToolbarTransformWidgetBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "h", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarTransformWidgetBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, vlc.l, Observer<KVData> {
    public Room a;
    public View b;
    public View c;
    public yo2.e d;
    public CompositeDisposable e;
    public final com.bytedance.android.livesdk.event.h0 f;
    public vlc.d g;
    public final Context h;
    public final boolean i;
    public DataCenter j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ICommerceMessage a;
        public final /* synthetic */ ToolbarTransformWidgetBehavior b;

        public a(ICommerceMessage r1, ToolbarTransformWidgetBehavior r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            if ((!Intrinsics.areEqual(((j0) r2).a(), Boolean.TRUE)) == false) goto L6;
            ToolbarTransformWidgetBehavior.a(this.b, this.a);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ICommerceMessage a;
        public final /* synthetic */ ToolbarTransformWidgetBehavior b;

        public b(ICommerceMessage r1, ToolbarTransformWidgetBehavior r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            ToolbarTransformWidgetBehavior.a(this.b, this.a);
            ((Throwable) r3).printStackTrace();
        }
    }

    public static final class c implements Action {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void run() {
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ToolbarTransformWidgetBehavior a;

        public d(ToolbarTransformWidgetBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            ToolbarTransformWidgetBehavior.b(this.a);
        }
    }

    public static final class e implements DialogInterface.OnDismissListener {
        public final /* synthetic */ ToolbarTransformWidgetBehavior a;

        public e(ToolbarTransformWidgetBehavior r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r7) {
            DataCenter r8 = this.a.j;
            if (r8 == null) goto L5;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r9 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r8.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
        L7:
            if (this.a.f.getType() != 1) goto L9;
        L17:
            if (r9 == null) goto L19;
            r9.n = true;
        L19:
            DataCenter r1 = this.a.j;
            if (r1 == null) goto L23;
            r1.put("data_live_mini_app_commerce_status", r9);
        L23:
            if (this.a.f.getType() != 2) goto L25;
            xs2.b.a().post(new zg1.g3());
        L25:
            this.a.f.a = 0;
            return;
        L9:
            if (this.a.f.getType() == 3) goto L17;
            if (this.a.f.getType() == 4) goto L17;
            if (this.a.f.getType() != 2) goto L19;
            if (r9 == null) goto L19;
            r9.n = false;
            goto L19
        L5:
            r9 = null;
            goto L7
        }
    }

    public static final class f implements DialogInterface.OnDismissListener {
        public final /* synthetic */ ToolbarTransformWidgetBehavior a;

        public f(ToolbarTransformWidgetBehavior r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r7) {
            DataCenter r8 = this.a.j;
            if (r8 == null) goto L5;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r9 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r8.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
        L7:
            if (this.a.f.getType() != 1) goto L9;
        L17:
            if (r9 == null) goto L19;
            r9.n = true;
        L19:
            DataCenter r1 = this.a.j;
            if (r1 == null) goto L23;
            r1.put("data_live_mini_app_commerce_status", r9);
        L23:
            if (this.a.f.getType() != 2) goto L25;
            xs2.b.a().post(new zg1.g3());
        L25:
            this.a.f.a = 0;
            return;
        L9:
            if (this.a.f.getType() == 3) goto L17;
            if (this.a.f.getType() == 4) goto L17;
            if (this.a.f.getType() != 2) goto L19;
            if (r9 == null) goto L19;
            r9.n = false;
            goto L19
        L5:
            r9 = null;
            goto L7
        }
    }

    public final class g implements Consumer {
        public final /* synthetic */ Function1 a;

        public g(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 c() {
        if (this.i == false) goto L6;
        return com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.f(this.j);
    L6:
        return com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.j);
    }

    public final void e() {
        String r0 = cb.a.getValue();
        if ((jc1.k.n(IHostApp.class).getCurrentActivity() instanceof FragmentActivity) == false) goto L23;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.length() <= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        if (((Boolean) SettingKeyUtils.f.getValue()).booleanValue() == true) goto L20;
        com.bytedance.android.live.browser.webview.fragment.o r2 = jc1.k.n(IBrowserService.class).buildWebDialog(r0).setWidth((int) com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.y()));
        r2.b = 484;
        r2.d(8);
        r2.c = 0;
        r2.i = 80;
        r2.a(-1);
        r2.r = true;
        BaseWebDialogFragment r3 = r2.build();
        FragmentActivity r4 = this.h;
        if ((r4 instanceof FragmentActivity) == false) goto L19;
        LiveDialogFragment.a r5 = LiveDialogFragment.Companion;
        if (r4 == null) goto L18;
        r5.getClass();
        LiveDialogFragment.a.a(r4, r3);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L19:
        r3.setOnDismissListener(new e(this));
    L21:
        d("live_icon_click");
        return;
    L20:
        jc1.k.n(IBrowserService.class).showHybridDialogWithListener(this.h, x6.a.a(r0).appendQueryParameter("type", "popup").appendQueryParameter("width", String.valueOf((int) com.bytedance.android.live.core.utils.s1.G(com.bytedance.android.live.core.utils.s1.y()))).appendQueryParameter("height", "484").appendQueryParameter("radius", "8").appendQueryParameter("margin", "0").appendQueryParameter("gravity", "bottom").appendQueryParameter("mask_click_disable", "0").build(), null, new f(this));
        goto L21
    L8:
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        DataCenter r0 = this.j;
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r1 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r0.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
    L6:
        String r2 = com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b());
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L12;
        Boolean r3 = (Boolean) com.bytedance.android.livesdk.chatroom.utils.k0.d(r2).getValue();
        if (r3 != null) goto L11;
        return false;
    L11:
        return r3.booleanValue();
    L12:
        Boolean r4 = (Boolean) com.bytedance.android.livesdk.chatroom.utils.k0.d(r2).getValue();
        if (r4 == null) goto L15;
        boolean r5 = r4.booleanValue();
    L16:
        if (r5 == false) goto L24;
        if (r1 == null) goto L19;
        boolean r6 = r1.e;
    L20:
        if (r6 == false) goto L25;
        return true;
    L25:
        return false;
    L19:
        r6 = false;
        goto L20
    L24:
        return false;
    L15:
        r5 = false;
        goto L16
    L5:
        r1 = null;
        goto L6
    }

    public final Context getContext() {
        return this.h;
    }

    public static final void b(ToolbarTransformWidgetBehavior r8) {
        r8.getClass();
        String r0 = com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b());
        int r1 = com.bytedance.android.livesdk.chatroom.utils.k0.a;
        Intrinsics.checkNotNullParameter(r0, "key");
        Boolean r5 = Boolean.FALSE;
        Boolean r2 = (Boolean) new com.bytedance.android.livesdk.sharedpref.e("transform_widget_unfold_pop_up_shown_" + r0, r5).getValue();
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        Intrinsics.checkNotNullParameter(r0, "key");
        if (Intrinsics.areEqual((Boolean) new com.bytedance.android.livesdk.sharedpref.e("is_card_shown_".concat(r0), r5).getValue(), r3) == true) goto L14;
        Intrinsics.checkNotNullParameter(r0, "key");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("transform_widget_unfold_pop_up_shown_".concat(r0), r5), r3);
        View r4 = LayoutInflater.from(r8.h).inflate(2131567899, null);
        r4.setOnClickListener(new p5(r8));
        View r6 = r4.findViewById(2131390392);
        if (r6 == null) goto L11;
        ((TextView) r6).setText(2131917417);
        yo2.e r7 = new yo2.e(r8.h);
        ((yo2.d) r7).d = r4;
        ((yo2.d) r7).e = 0;
        ((yo2.d) r7).m = 5;
        ((yo2.d) r7).n = true;
        ((yo2.d) r7).l = true;
        ((yo2.d) r7).g = true;
        r7.a();
        r8.d = r7;
        View r9 = r8.b;
        Intrinsics.checkNotNull(r9);
        r7.i(r9, 1, 0, 0, -4);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L14:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r4) {
        if (this.i == true) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r5 = c();
        if (this.i == false) goto L7;
        ToolbarButton r0 = ToolbarButton.TRANSFORM_WIDGET_MORE;
    L9:
        if (r5.n(r0) == true) goto L11;
        d("live_icon_show");
    L11:
        CompositeDisposable r6 = this.e;
        if (r6 == null) goto L14;
        r6.add(((SingleSubscribeProxy) Single.timer(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.h))).subscribe(new d(this)));
        goto L14
    L7:
        r0 = ToolbarButton.TRANSFORM_WIDGET;
    L14:
        View r7 = this.b;
        if (r7 == null) goto L18;
        r7.setAlpha(1.0f);
        return;
    }

    public final void d(String r9) {
        Pair[] r0 = new Pair[5];
        r0[0] = TuplesKt.to("tag", "live_ad");
        r0[1] = TuplesKt.to("refer", "icon");
        JSONObject r1 = new JSONObject();
        Room r3 = this.a;
        if (r3 == null) goto L5;
        String r4 = r3.getOwnerUserIdString();
    L6:
        r1.put("anchor_id", r4);
        Room r5 = this.a;
        if (r5 == null) goto L9;
        Long r6 = Long.valueOf(r5.id);
    L10:
        r1.put("room_id", r6);
        r1.put("room_type", SourceType.ANCHOR);
        if (this.i == false) goto L13;
        String r7 = "more_buttons";
    L14:
        r1.put("live_position", r7);
        Unit r8 = Unit.INSTANCE;
        r0[2] = TuplesKt.to("ad_extra_data", r1.toString());
        String r10 = "1";
        r0[3] = TuplesKt.to("is_ad_live_event", "1");
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L21;
        com.bytedance.live.datacontext.m r11 = r2.isCleanMode();
        if (r11 == null) goto L21;
        if (((Boolean) r11.getValue()).booleanValue() != true) goto L21;
    L22:
        r0[4] = TuplesKt.to("if_clear_mode", r10);
        jc1.k.n(IHostLog.class).logV3(r9, MapsKt.mapOf(r0));
        return;
    L21:
        r10 = "0";
        goto L22
    L13:
        r7 = "toolbar";
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public final void f(int r2) {
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L5;
        return;
    L5:
        if (r2 != 0) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r3 = c();
        if (this.i == false) goto L17;
        ToolbarButton r0 = ToolbarButton.TRANSFORM_WIDGET_MORE;
    L18:
        r3.c(r0.extended());
        return;
    L17:
        r0 = ToolbarButton.TRANSFORM_WIDGET;
        goto L18
    L7:
        if (r2 != 8) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r4 = c();
        if (this.i == false) goto L12;
        ToolbarButton r1 = ToolbarButton.TRANSFORM_WIDGET_MORE;
    L13:
        r4.i(r1.extended());
        return;
    L12:
        r1 = ToolbarButton.TRANSFORM_WIDGET;
        goto L13
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r0 = null;
        if (r7 == null) goto L5;
        String r1 = r7.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == 919040494) goto L12;
        return;
    L12:
        if (r1.equals("data_live_mini_app_commerce_status") == true) goto L14;
        return;
    L14:
        if (com.bytedance.android.livesdk.config.setting.s.b() == true) goto L80;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r8 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r7.getData();
        if (r8 == null) goto L70;
        DataCenter r2 = this.j;
        if (r2 == null) goto L21;
        Boolean r3 = (Boolean) r2.get("data_is_anchor", Boolean.FALSE);
    L23:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L25;
        r0 = r8;
    L25:
        if (r0 != null) goto L27;
        return;
    L27:
        if (r0.e == true) goto L29;
        f(8);
        return;
    L29:
        if (this.i == false) goto L45;
        if (tb1.c.a == true) goto L33;
    L36:
        boolean r9 = false;
    L37:
        if (r9 == true) goto L41;
        f(0);
        View r10 = this.b;
        if (r10 == null) goto L72;
        r10.setAlpha(0.5f);
        return;
    L72:
        return;
    L41:
        f(0);
        View r11 = this.b;
        if (r11 == null) goto L74;
        r11.setAlpha(1.0f);
        return;
    L74:
        return;
    L33:
        if (r0.h() != 0) goto L36;
        r9 = true;
        goto L37
    L45:
        if (r0.h() == 1) goto L48;
        f(8);
        return;
    L48:
        if (this.i == true) goto L59;
        if (r0.n == false) goto L59;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0 r12 = c();
        if (this.i == false) goto L54;
        ToolbarButton r4 = ToolbarButton.TRANSFORM_WIDGET_MORE;
    L56:
        if (r12.n(r4) == true) goto L59;
        d("live_icon_show");
        goto L59
    L54:
        r4 = ToolbarButton.TRANSFORM_WIDGET;
    L59:
        if (this.i == true) goto L63;
        CompositeDisposable r13 = this.e;
        if (r13 == null) goto L63;
        r13.add(((SingleSubscribeProxy) Single.timer(1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this.h))).subscribe(new n5(this)));
    L63:
        View r14 = this.b;
        if (r14 == null) goto L66;
        r14.setAlpha(1.0f);
    L66:
        f(0);
        return;
    L21:
        r3 = null;
        goto L23
    L70:
        return;
    L80:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        Intrinsics.checkNotNullParameter(r13, "v");
        String r14 = com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b());
        if (this.i == false) goto L47;
        Room r0 = this.a;
        if (r0 == null) goto L7;
        long r2 = r0.id;
    L8:
        long r6 = r2;
        final ToolbarBroadcastFunction r9 = ToolbarBroadcastFunction.TRANSFORM_WIDGET;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L13;
        BottomToolbarViewModel.a r1 = BottomToolbarViewModel.Companion;
        DataCenter r3 = this.j;
        r1.getClass();
        BottomToolbarViewModel r4 = BottomToolbarViewModel.a.a(r3);
        if (r4 == null) goto L42;
        r4.openChangeDialog(this.h, r6, r9, new o5(this));
    L42:
        com.bytedance.android.livesdk.sharedpref.f.d(com.bytedance.android.livesdk.chatroom.utils.k0.d(r14), Boolean.FALSE);
        View r15 = this.c;
        if (r15 == null) goto L51;
        r15.setVisibility(8);
        return;
    L51:
        return;
    L13:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r5 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.j);
        if (r5.h() != 1) goto L17;
        ToolbarBroadcastFunction r8 = r9;
    L41:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.e(this.h, r5, r6, r8, r9, new ToolbarTransformWidgetBehavior$showReplaceDialog$2(this), new ToolbarTransformWidgetBehavior$showReplaceDialog$3(this, r9));
        goto L42
    L17:
        if (r5.f() != 1) goto L20;
        ToolbarBroadcastFunction r7 = ToolbarBroadcastFunction.MINI_APP;
    L40:
        r8 = r7;
        goto L41
    L20:
        if (r5.b() != 1) goto L23;
        r7 = ToolbarBroadcastFunction.COMMERCE;
        goto L40
    L23:
        if (r5.c() != 1) goto L26;
        r7 = ToolbarBroadcastFunction.GAME_PROMOTE;
        goto L40
    L26:
        if (r5.j() != 1) goto L29;
        r7 = ToolbarBroadcastFunction.WELFARE;
        goto L40
    L29:
        if (r5.d() != 1) goto L32;
        r7 = ToolbarBroadcastFunction.GROUP_PURCHASE;
        goto L40
    L32:
        if (r5.e() != 1) goto L34;
        r7 = ToolbarBroadcastFunction.MIX_MINI_APP;
        goto L40
    L34:
        boolean r10 = tb1.c.a;
        if (r5.g() != 1) goto L38;
        r7 = ToolbarBroadcastFunction.MINI_GAME;
        goto L40
    L38:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L46;
        r7 = ToolbarBroadcastFunction.COMMERCE;
        goto L40
    L46:
        throw new IllegalStateException("cant has other button unfold");
    L7:
        r2 = 0;
        goto L8
    L47:
        e();
        int r11 = com.bytedance.android.livesdk.chatroom.utils.k0.a;
        Intrinsics.checkNotNullParameter(r14, "key");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("is_first_show_unfold_transform_widget_" + r14, Boolean.TRUE), Boolean.FALSE);
        View r16 = this.c;
        if (r16 == null) goto L53;
        r16.setVisibility(8);
        return;
    }

    public final void onMessage(tlc.d r7) {
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L5;
        return;
    L5:
        if (r7 != null) goto L7;
        return;
    L7:
        if (r7.getIntType() == 2001) goto L9;
    L11:
        boolean r0 = false;
    L13:
        if (r0 == true) goto L16;
        r7 = null;
    L16:
        if (r7 == null) goto L34;
        ICommerceMessage r8 = (ICommerceMessage) r7;
        if (r8.getMessageType() != 3) goto L20;
    L25:
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L36;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L37;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L38;
        ((GetUsingCardApi) com.bytedance.android.live.network.c.b().e(GetUsingCardApi.class)).checkUsingGroup(r3.getRoomId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r8, this), new b(r8, this), c.a);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L20:
        if (r8.getMessageType() == 5) goto L25;
        if (r8.getMessageType() == 1) goto L25;
        if (r8.getMessageType() == 2) goto L25;
        return;
    L34:
        return;
    L9:
        if ((r7 instanceof ICommerceMessage) == false) goto L11;
        r0 = true;
        goto L13
    }

    public static final void a(ToolbarTransformWidgetBehavior r9, ICommerceMessage r10) {
        r9.getClass();
        long r0 = r10.getMessageType();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2 r6 = null;
        if (r0 != 3) goto L19;
        DataCenter r1 = r9.j;
        if (r1 == null) goto L7;
        Boolean r2 = (Boolean) r1.get("data_is_anchor", Boolean.FALSE);
    L9:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L75;
        DataCenter r3 = r9.j;
        if (r3 == null) goto L13;
        r6 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r3.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
    L13:
        if (r6 == null) goto L15;
        r6.e = true;
    L15:
        DataCenter r11 = r9.j;
        if (r11 == null) goto L76;
        r11.put("data_live_mini_app_commerce_status", r6);
        return;
    L76:
        return;
    L75:
        return;
    L7:
        r2 = null;
        goto L9
    L19:
        if (r0 != 5) goto L37;
        DataCenter r12 = r9.j;
        if (r12 == null) goto L23;
        Boolean r13 = (Boolean) r12.get("data_is_anchor", Boolean.FALSE);
    L25:
        if (Intrinsics.areEqual(r13, Boolean.TRUE) == false) goto L78;
        DataCenter r14 = r9.j;
        if (r14 == null) goto L29;
        r6 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r14.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
    L29:
        if (r6 == null) goto L31;
        r6.e = false;
    L31:
        if (r6 == null) goto L33;
        r6.n = false;
    L33:
        DataCenter r15 = r9.j;
        if (r15 == null) goto L79;
        r15.put("data_live_mini_app_commerce_status", r6);
        return;
    L79:
        return;
    L78:
        return;
    L23:
        r13 = null;
        goto L25
    L37:
        if (r0 != 1) goto L58;
        DataCenter r4 = r9.j;
        if (r4 == null) goto L41;
        Boolean r5 = (Boolean) r4.get("data_is_anchor", Boolean.FALSE);
    L43:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L81;
        DataCenter r7 = r9.j;
        if (r7 == null) goto L47;
        r6 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r7.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
    L47:
        if (r6 != null) goto L49;
    L50:
        if (r6 == null) goto L52;
        r6.n = true;
    L52:
        if (r6 == null) goto L54;
        r6.k(ToolbarBroadcastFunction.TRANSFORM_WIDGET);
    L54:
        DataCenter r16 = r9.j;
        if (r16 == null) goto L83;
        r16.put("data_live_mini_app_commerce_status", r6);
        return;
    L83:
        return;
    L49:
        if (r6.n != true) goto L50;
        return;
    L81:
        return;
    L41:
        r5 = null;
        goto L43
    L58:
        if (r0 != 2) goto L85;
        DataCenter r8 = r9.j;
        if (r8 == null) goto L62;
        Boolean r17 = (Boolean) r8.get("data_is_anchor", Boolean.FALSE);
    L64:
        if (Intrinsics.areEqual(r17, Boolean.TRUE) == false) goto L86;
        DataCenter r18 = r9.j;
        if (r18 == null) goto L68;
        r6 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r18.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2());
    L68:
        if (r6 != null) goto L70;
        return;
    L70:
        if (r6.n != true) goto L88;
        r6.n = false;
        DataCenter r19 = r9.j;
        if (r19 == null) goto L89;
        r19.put("data_live_mini_app_commerce_status", r6);
        return;
    L89:
        return;
    L88:
        return;
    L86:
        return;
    L62:
        r17 = null;
        goto L64
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        vlc.d r4 = this.g;
        if (r4 == null) goto L5;
        r4.removeMessageListener(this);
    L5:
        CompositeDisposable r5 = this.e;
        if (r5 == null) goto L9;
        r5.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.b = r5;
        if (((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2) r6.get("data_live_mini_app_commerce_status", new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2())).e == false) goto L5;
        int r0 = 0;
    L6:
        f(r0);
        this.e = new CompositeDisposable();
        if (this.i == true) goto L16;
        this.c = r5.findViewById(2131392581);
        String r7 = com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b());
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        int r1 = com.bytedance.android.livesdk.chatroom.utils.k0.a;
        Intrinsics.checkNotNullParameter(r7, "key");
        String r8 = "is_first_show_unfold_transform_widget_".concat(r7);
        Boolean r3 = Boolean.TRUE;
        if (Intrinsics.areEqual((Boolean) new com.bytedance.android.livesdk.sharedpref.e(r8, r3).getValue(), r3) == false) goto L16;
        View r9 = this.c;
        if (r9 == null) goto L16;
        r9.setVisibility(0);
    L16:
        this.a = (Room) r6.get("data_room", null);
        this.j = r6;
        r6.observe("data_live_mini_app_commerce_status", this, true);
        CompositeDisposable r10 = this.e;
        if (r10 == null) goto L20;
        r10.add(xs2.b.a().b(com.bytedance.android.livesdk.event.h0.class).subscribe(new g(new ToolbarTransformWidgetBehavior$onLoad$1(this))));
    L20:
        if (this.i == false) goto L22;
        d("live_icon_show");
    L22:
        vlc.d r11 = (vlc.d) r6.get("data_message_manager", null);
        this.g = r11;
        if (r11 == null) goto L26;
        r11.addMessageListener(2001, this);
        return;
    L26:
        return;
    L5:
        r0 = 8;
        goto L6
    }

    public ToolbarTransformWidgetBehavior(Context r2, boolean r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.f = new com.bytedance.android.livesdk.event.h0(0);
    }
}
