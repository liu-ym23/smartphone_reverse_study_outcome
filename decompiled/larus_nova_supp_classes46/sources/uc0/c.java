package uc0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.live.livesdkapi.LiveSdkApiForSaaS;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livehostapi.foundation.depend.pluginstrategy.SaaSLiveResourceStrategy;
import com.bytedance.android.livesdk.chatroom.ui.AlwaysConsumeEventFrameLayout;
import com.bytedance.android.livesdk.commonpop.e;
import com.bytedance.android.livesdk.config.LiveInitSettingKeysForSaas;
import com.bytedance.android.livesdk.live.extension.plugin.api.audiosdk.ILiveWrappedAudio;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.utils.h5;
import com.bytedance.android.livesdk.widget.h;
import com.bytedance.android.livesdk.widget.i;
import com.bytedance.android.livesdk.widget.j;
import com.bytedance.android.livesdk.widget.l;
import com.bytedance.android.livesdk.widget.m;
import com.bytedance.android.openlive.realtime.IUserRealtimeSignalFeature;
import com.bytedance.android.openlive.realtime.UserRealtimeSignalFeature;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v80.g;
import y00.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class c extends LiveSdkApiForSaaS {
    @Override // il0.a
    public String getSecKey() {
        int r0 = bv1.a.a;
        return "naZ=Q%#3xu2f5vs9";
    }

    @Override // il0.a
    public IUserRealtimeSignalFeature getUserRealtimeSignalFeature() {
        return new UserRealtimeSignalFeature();
    }

    @Override // il0.a
    public boolean initAudioSDKPluginLoader() {
        if (com.bytedance.android.live.broadcast.a.a == true) goto L28;
        Context r0 = s1.getContext();
        if (r0 != null) goto L9;
    L16:
        return false;
    L9:
        if (h5.a() == false) goto L26;
        PluginType r3 = PluginType.SaaSLiveResource;
        if (r3.isInstalled() == true) goto L18;
        com.bytedance.android.live.broadcast.a r1 = com.bytedance.android.live.broadcast.a.d;
        if (com.bytedance.android.live.broadcast.a.b == true) goto L16;
        f2.b(2131915103, 0);
        r3.checkInstall(r0, "", r1, false);
        goto L16
    L18:
        if (com.bytedance.android.live.broadcast.a.c == true) goto L21;
        ClassLoader r4 = com.bytedance.android.live.broadcast.a.class.getClassLoader();
        SaaSLiveResourceStrategy.loadHostLibraryByList(r0, r4, new String[]{"c++_shared", "iesapplogger", "bytenn", "ttffmpeg", "audioeffect"});
        com.bytedance.android.live.broadcast.a.c = true;
    L21:
        ILiveWrappedAudio.Companion.getClass();
        ILiveWrappedAudio r2 = ILiveWrappedAudio.a.a();
        if (r2 == null) goto L24;
        r2.getSpeechEngineLoader();
    L24:
        com.bytedance.android.live.broadcast.a.a = true;
    L26:
        return com.bytedance.android.live.broadcast.a.a;
    L28:
        return true;
    }

    @Override // il0.a
    public void preloadOnlineEmoji() {
        if (LiveInitSettingKeysForSaas.get_LIVE_ONLINE_EMOJI_ENABLE() == false) goto L8;
        IAwemeEmojiProxy r0 = k.f(IAwemeEmojiProxy.class);
        if (r0 == null) goto L9;
        r0.preloadOnlineEmoji();
        return;
    L9:
        return;
    }

    public c() {
    }

    @Override // il0.a
    public void openAgreeToStartLiveDialog(Object r7) {
        Intrinsics.checkNotNullParameter(r7, "verifyParam");
        if ((r7 instanceof g) == true) goto L5;
        r7 = null;
    L5:
        g r8 = (g) r7;
        if (r8 != null) goto L8;
        return;
    L8:
        int r1 = d.a;
        Intrinsics.checkNotNullParameter(r8, "verifyParam");
        Activity r0 = r8.getActivity();
        View r2 = LayoutInflater.from(r0).inflate(2131563520, null);
        r2.findViewById(2131378521).setOnClickListener(new y00.a(r0));
        m.a r3 = new m.a(r0);
        r3.c = 2131250339;
        r3.i = r2;
        y00.b r4 = y00.b.a;
        r3.b = r0.getString(2131911645);
        r3.e = r4;
        r3.k = false;
        y00.c r5 = new y00.c(r8);
        r3.a = r0.getString(2131911646);
        r3.d = r5;
        r3.j = false;
        m r9 = new m(r3);
        r9.n.setAlpha(0.0f);
        AlertDialog.Builder r6 = new AlertDialog.Builder(r9.a);
        r6.setView(r9.h);
        r9.b.setText(null);
        r9.c.setText(null);
        r9.c.setGravity(17);
        r9.e.setText(r9.p);
        r9.e.setTextColor(r9.s);
        r9.l.setBackgroundColor(0);
        if (TextUtils.isEmpty(r9.q) == false) goto L11;
        r9.d.setVisibility(8);
        r9.f.setVisibility(8);
        r9.e.setBackgroundResource(2131253164);
    L13:
        if (r9.i == null) goto L16;
        r9.c.setVisibility(8);
        r9.b.setVisibility(8);
        ((ViewGroup.MarginLayoutParams) r9.j.getLayoutParams()).topMargin = 0;
        r9.o.removeAllViews();
        r9.o.addView(r9.i);
    L16:
        if (TextUtils.isEmpty(null) == false) goto L20;
        r9.b.setVisibility(8);
        if (TextUtils.isEmpty(null) == false) goto L20;
        LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) r9.c.getLayoutParams();
        r10.topMargin = (int) UIUtils.dip2Px(r9.a, 32.0f);
        r10.bottomMargin = (int) UIUtils.dip2Px(r9.a, 8.0f);
        r9.c.setLayoutParams(r10);
    L20:
        int r11 = r9.t;
        if (r11 <= 0) goto L23;
        r9.g.setImageResource(r11);
    L24:
        r6.setOnCancelListener(new h(r9));
        r9.y = r6.create();
        r9.d.setOnClickListener(new i(r9));
        r9.e.setOnClickListener(new j(r9));
        r9.k.setOnClickListener(new com.bytedance.android.livesdk.widget.k(r9));
        AlertDialog r12 = r9.y;
        RelativeLayout r13 = r9.n;     // Catch: Exception -> L46
        if (r13 == null) goto L30;
        r13.post(new l(r13, true));     // Catch: Exception -> L46
    L30:
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L49;
        DialogLancet.handleBlockedDialogShow(r12);     // Catch: Exception -> L46
    L35:
        Window r14 = r12.getWindow();     // Catch: Exception -> L46
        if (r14 == null) goto L51;
        r14.setBackgroundDrawableResource(2131100007);     // Catch: Exception -> L46
        WindowManager.LayoutParams r15 = r14.getAttributes();     // Catch: Exception -> L46
        r15.dimAmount = 0.5f;     // Catch: Exception -> L46
        r14.addFlags(2);     // Catch: Exception -> L46
        r15.gravity = 1;     // Catch: Exception -> L46
        r15.width = (int) UIUtils.dip2Px(r12.getContext(), 280.0f);     // Catch: Exception -> L46
        View r16 = r14.getDecorView();     // Catch: Exception -> L46
        if (com.larus.home.impl.utils.c.e == false) goto L43;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Exception -> L46
        Thread r17 = ThreadMethodProxy.currentThread();     // Catch: Exception -> L46
        if (r17 == com.larus.home.impl.utils.c.a) goto L43;
        com.larus.home.impl.utils.c.a(r17, "getDecorView");     // Catch: Exception -> L46
    L43:
        r16.setPadding(0, 0, 0, 0);     // Catch: Exception -> L46
        r14.setAttributes(r15);     // Catch: Exception -> L46
        return;
    L51:
        return;
    L49:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L34:
        DialogLancet.beforeDialogShow(r12);     // Catch: Exception -> L46
        r12.show();     // Catch: Exception -> L46
        DialogLancet.afterDialogShow(r12);     // Catch: Exception -> L46
    L52:
        return;
    L23:
        r9.l.setVisibility(8);
        r9.m.setBackgroundResource(2131253166);
        goto L24
    L11:
        r9.d.setText(r9.q);
        r9.d.setTextColor(r9.r);
        goto L13
    }

    @Override // il0.a
    public void readLocationForSaas(Context r18, Function1<? super String, Unit> r19) {
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "runAfter");
        int r4 = z00.m.a;
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r19, "runAfter");
        Object r2 = r18.getSystemService("location");
        if (r2 == null) goto L25;
        LocationManager r3 = (LocationManager) r2;
        List<String> r5 = r3.getProviders(true);
        String r6 = "network";
        if (r5.contains("network") == false) goto L7;
    L6:
        String r12 = r6;
        if (m60.c.d(r18, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}) == false) goto L26;
        f06.c r11 = new f06.c();
        Object[] r13 = {r12};
        f06.b r14 = new f06.b();
        f06.d r15 = r11.b(100000, "android/location/LocationManager", "getLastKnownLocation", r3, r13, "android.location.Location", r14);
        if (r15.a == false) goto L15;
        r11.a(100000, "android/location/LocationManager", "getLastKnownLocation", r3, r13, null, r14, false);
        Location r7 = (Location) r15.b;
    L16:
        if (r7 == null) goto L18;
        z00.m.b(r18, r7, r19);
        return;
    L18:
        z00.l r8 = new z00.l(r18, r19);
        if (fna.g.d() == true) goto L21;
        z00.m.a(r3, r12, r8);
        return;
    L21:
        z00.m.a(r3, r12, r8);
        nna.a.c(r8.hashCode());
        return;
    L15:
        Location r16 = r3.getLastKnownLocation(r12);
        r11.a(100000, "android/location/LocationManager", "getLastKnownLocation", r3, r13, r16, r14, true);
        r7 = r16;
        goto L16
    L26:
        return;
    L7:
        r6 = "gps";
        if (r5.contains("gps") == true) goto L6;
        f2.b(2131919785, 0);
        r18.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        r19.invoke("");
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
    }

    @Override // il0.a
    public void broadcastAuthUtilsCheckLogin(Context r4, boolean r5, Function1<? super IBaseUser, Unit> r6, Function1<? super Throwable, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "onAuth");
        Intrinsics.checkNotNullParameter(r7, "onError");
        int r2 = v00.c.a;
        Intrinsics.checkNotNullParameter(r6, "onAuth");
        Intrinsics.checkNotNullParameter(r7, "onError");
        IUserService r0 = k.f(IUserService.class);
        if (r0 == null) goto L7;
        f r1 = r0.user();
        if (r1 == null) goto L7;
        boolean r3 = r1.isLogin();
    L8:
        if (r3 == false) goto L18;
        if (r5 == true) goto L18;
        IUserService r8 = k.f(IUserService.class);
        if (r8 == null) goto L23;
        f r9 = r8.user();
        if (r9 == null) goto L24;
        IUser r10 = r9.b();
        if (r10 == null) goto L25;
        r6.invoke(r10);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L18:
        if (r5 == false) goto L20;
        String r11 = "broadcast_force_login";
    L21:
        f2.b(2131919784, 0);
        f r12 = k.n(IUserService.class).user();
        com.bytedance.android.livesdk.user.l.a r13 = new com.bytedance.android.livesdk.user.l.a();
        r13.d = r11;
        r12.login(r4, new com.bytedance.android.livesdk.user.l(r13)).compose(RxUtil.rxSchedulerHelper()).subscribe(new v00.a(r6), new v00.b(r7));
        return;
    L20:
        r11 = "broadcast";
    L7:
        r3 = false;
        goto L8
    }

    @Override // il0.a
    public void commonPopupMessageWidgetOnInRoomPushEvent(Widget r6, WeakHandler r7, Object r8, int r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r6, "widget");
        Intrinsics.checkNotNullParameter(r7, "handler");
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r10, "dismissBlock");
        int r4 = com.bytedance.android.livesdk.commonpop.g.a;
        Intrinsics.checkNotNullParameter(r6, "widget");
        Intrinsics.checkNotNullParameter(r7, "handler");
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r10, "dismissBlock");
        if ((r8 instanceof com.bytedance.android.livesdk.commonpop.i) == true) goto L5;
        r8 = null;
    L5:
        com.bytedance.android.livesdk.commonpop.i r11 = (com.bytedance.android.livesdk.commonpop.i) r8;
        if (r11 == null) goto L32;
        View r0 = r6.contentView;
        if (r0 != null) goto L12;
        return;
    L12:
        if ((r0 instanceof ViewGroup) == true) goto L14;
        View r2 = null;
    L15:
        ViewGroup r3 = (ViewGroup) r2;
        if (r3 == null) goto L34;
        Context r12 = r6.context;
        if (r12 == null) goto L35;
        com.bytedance.android.live.base.model.push.b r13 = r11.a;
        if (r13 == null) goto L36;
        r3.setVisibility(0);
        r3.removeAllViews();
        if ((r0 instanceof AlwaysConsumeEventFrameLayout) == true) goto L27;
        r0 = null;
    L27:
        AlwaysConsumeEventFrameLayout r1 = (AlwaysConsumeEventFrameLayout) r0;
        if (r1 == null) goto L30;
        r1.setAlwaysConsume(false);
    L30:
        View r5 = LayoutInflater.from(r12).inflate(2131565326, r3, false);
        r3.addView(r5);
        ImageUtil.loadRoundImage(r5.findViewById(2131383454), r13.getIcon());
        ((TextView) r5.findViewById(2131391606)).setText(r13.getTitle());
        ((TextView) r5.findViewById(2131390392)).setText(r13.getContent());
        TextView r14 = (TextView) r5.findViewById(2131390102);
        r14.setText(r13.getButtonText());
        r14.setOnClickListener(new e(r13, r12));
        Ref.FloatRef r15 = new Ref.FloatRef();
        r15.element = 0.0f;
        r5.setOnTouchListener(new com.bytedance.android.livesdk.commonpop.f(r15, r10, r5));
        Message r16 = r7.obtainMessage(r9);
        r7.removeCallbacksAndMessages(null);
        r7.sendMessageDelayed(r16, r13.getDuration() * ((long) 1000));
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L14:
        r2 = r0;
        goto L15
    }
}
