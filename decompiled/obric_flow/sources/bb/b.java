package bb;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ttnet.tnc.TNCManager$TNCUpdateSource;
import com.google.common.reflect.w;
import com.lynx.tasm.behavior.a1;
import com.lynx.tasm.behavior.h;
import com.lynx.tasm.utils.j;
import com.obric.android.agilelogger.ALog;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.p;
import com.obric.olog.OLog;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.m;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.obric.oui.toast.ToastBackgroundView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import obric.flow.overlay.AssistantOverlayService;
import org.json.JSONException;
import org.json.JSONObject;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f894b;

    public /* synthetic */ b() {
        this.f893a = 6;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r18) {
        yj.a r10 = null;
        boolean r11 = true;
        switch(this.f893a) {
            case 0: goto L284;
            case 1: goto L213;
            case 2: goto L202;
            case 3: goto L194;
            case 4: goto L121;
            case 5: goto L99;
            case 6: goto L49;
            default: goto L5;
        };
    L99:
        Intrinsics.checkNotNullParameter(r18, "msg");
        obric.flow.overlay.b r5 = (obric.flow.overlay.b) ((WeakReference) this.f894b).get();
        if (r5 != null) goto L103;
        return;
    L103:
        if (r18.what == 100) goto L105;
        return;
    L105:
        if (r5.f20533b == false) goto L318;
        r5.f20533b = false;
        AssistantOverlayService r12 = (AssistantOverlayService) r5.f20532a.get();
        if (r12 == null) goto L319;
        CardFeedLayout r13 = r12.f20529b;
        if (r13 == null) goto L320;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("Watchdog triggered: Gesture timed out", "msg");
        org.koin.core.a r14 = su.a.f22013b;
        if (r14 == null) goto L119;
        ((ju.b) r14.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AssistantOverlayService", "Watchdog triggered: Gesture timed out");
        p r15 = r13.G;
        if (r15 == null) goto L315;
        r15.f(new com.obric.flow.cardlistpage.ui.component.overlayanimator.b(0.0f, false));
        return;
    L315:
        return;
    L119:
        throw new IllegalStateException("KoinApplication has not been started");
    L320:
        return;
    L319:
        return;
    L318:
        return;
    L121:
        Intrinsics.checkNotNullParameter(r18, "msg");
        int r16 = com.obric.oui.toast.c.f14889m;
        StringBuilder r17 = new StringBuilder("handleMessage ");
        r17.append(r18.what);
        r17.append(' ');
        com.obric.oui.toast.b r19 = (com.obric.oui.toast.b) this.f894b;
        r17.append(r19);
        Log.v("OToast", r17.toString());
        r19.getClass();
        int r20 = r18.what;
        if (r20 != 1) goto L191;
        Log.v("OToast", "HANDLE SHOW: " + r19 + " mView=" + ((View) r19.f14884h) + " mNextView=" + ((View) r19.f14885i));
        r19.b();
        Context r21 = (Context) r19.f14886j;
        if (r21 != null) goto L126;
        Activity r22 = null;
    L127:
        Context r23 = (Context) r19.f14886j;
        View r24 = (View) r19.f14885i;
        Intrinsics.checkNotNull(r24);
        int r110 = r19.f14882b;
        View r25 = r24;
        if (r23 == null) goto L158;
        if (r24 != null) goto L133;
    L131:
        View r111 = null;
    L135:
        ToastBackgroundView r112 = (ToastBackgroundView) r111;
        if (r112 != null) goto L138;
        int r113 = 24;
    L139:
        View r114 = LayoutInflater.from(r23).inflate(R$layout.o_layout_popover_shadow_frame, null);
        if (r114 == null) goto L190;
        SingleChildFrameLayout r115 = (SingleChildFrameLayout) r114;
        r115.addView(r24, new FrameLayout.LayoutParams(-2, -2));
        r115.setShadowCornerRadius(r113);
        Iterator r26 = i.o(R$style.OUIShadow_Oui_Shadow_Regular, r23).iterator();
        int r27 = 0;
        int r28 = 0;
        int r116 = 0;
        int r117 = 0;
    L143:
        if (r26.hasNext() == false) goto L157;
        m r29 = (m) r26.next();
        float r30 = r29.f12517b - r29.f12518c;
        if (r30 <= r117) goto L147;
        r117 = MathKt.roundToInt(r30);
    L147:
        float r31 = r29.f12517b + r29.f12518c;
        if (r31 <= r27) goto L150;
        r27 = MathKt.roundToInt(r31);
    L150:
        float r32 = r29.f12517b - r29.d;
        if (r32 <= r116) goto L153;
        r116 = MathKt.roundToInt(r32);
    L153:
        float r33 = r29.f12517b + r29.d;
        if (r33 <= r28) goto L143;
        r28 = MathKt.roundToInt(r33);
        goto L143
    L157:
        SingleChildFrameLayout r34 = new SingleChildFrameLayout(r23, null);
        r34.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        FrameLayout.LayoutParams r35 = new FrameLayout.LayoutParams(-2, -2);
        r35.gravity = 1;
        Unit r36 = Unit.INSTANCE;
        r34.addView(r115, r35);
        r34.setClipChildren(false);
        r34.setClipToPadding(false);
        r34.setPadding(0, r116, 0, r110);
        r25 = r34;
        goto L158
    L190:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
    L138:
        r113 = r112.getCornerRadius();
        goto L139
    L133:
        if ((r24 instanceof ToastBackgroundView) == false) goto L131;
        r111 = r24;
    L158:
        r19.f14884h = r25;
        Intrinsics.checkNotNull(r25);
        Context r37 = r25.getContext().getApplicationContext();
        View r38 = (View) r19.f14884h;
        Intrinsics.checkNotNull(r38);
        String r39 = r38.getContext().getPackageName();
        if (r37 != null) goto L161;
        View r40 = (View) r19.f14884h;
        Intrinsics.checkNotNull(r40);
        r37 = r40.getContext();
    L161:
        Intrinsics.checkNotNull(r37);
        Object r41 = r37.getSystemService("window");
        if (r41 == null) goto L188;
        r19.f14888l = (WindowManager) r41;
        View r42 = (View) r19.f14884h;
        Intrinsics.checkNotNull(r42);
        int r43 = Gravity.getAbsoluteGravity(r19.f14881a, r42.getContext().getResources().getConfiguration().getLayoutDirection());
        WindowManager.LayoutParams r44 = (WindowManager.LayoutParams) r19.e;
        r44.gravity = r43;
        if ((r43 & 7) != 7) goto L167;
        r44.horizontalWeight = 1.0f;
    L167:
        if ((r43 & 112) != 112) goto L169;
        r44.verticalWeight = 1.0f;
    L169:
        r44.x = 0;
        r44.y = r19.f14882b;
        r44.verticalMargin = 0.0f;
        r44.horizontalMargin = 0.0f;
        Integer r45 = (Integer) r19.f14887k;
        if (r45 == null) goto L174;
        r44.type = r45.intValue();
    L174:
        if (r19.d == true) goto L176;
        r44.flags |= 16;
    L176:
        j.i(r37, r44, (Boolean) r19.f);
        r44.y = 0;
        r44.width = -1;
        if (r22 == null) goto L179;
        r44.token = r22.getWindow().getAttributes().token;
    L179:
        r44.packageName = r39;
        View r46 = (View) r19.f14884h;
        Intrinsics.checkNotNull(r46);
        if (r46.getParent() == null) goto L182;
        int r47 = com.obric.oui.toast.c.f14889m;
        Log.v("OToast", "REMOVE! " + ((View) r19.f14884h) + " in " + r19);
        WindowManager r48 = (WindowManager) r19.f14888l;
        Intrinsics.checkNotNull(r48);
        r48.removeView((View) r19.f14884h);
    L182:
        int r49 = com.obric.oui.toast.c.f14889m;
        Log.v("OToast", "ADD! " + ((View) r19.f14884h) + " in " + r19);
        WindowManager r50 = (WindowManager) r19.f14888l;     // Catch: Exception -> L185
        Intrinsics.checkNotNull(r50);     // Catch: Exception -> L185
        r50.addView((View) r19.f14884h, r44);     // Catch: Exception -> L185
        return;
    L185:
        e = move-exception;
        e.printStackTrace();
        return;
    L188:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    L126:
        r22 = j.m(r21);
        goto L127
    L191:
        if (r20 != 2) goto L322;
        r19.b();
        r19.f14885i = null;
        r19.f14886j = null;
        r19.f14888l = null;
        return;
    L322:
        return;
    L194:
        Intrinsics.checkNotNullParameter(r18, "msg");
        super.handleMessage(r18);
        if (r18.what != 101) goto L324;
        com.obric.oui.dialog.v2.alert.b r51 = (com.obric.oui.dialog.v2.alert.b) this.f894b;
        j.o(r51.b());     // Catch: Exception -> L199
        return;
    L199:
        e = move-exception;
        ps.a.b(e, r51.f13103a, "recheckInset failed");
        return;
    L324:
        return;
    L202:
        int r52 = r18.what;
        h r53 = (h) this.f894b;
        if (r52 != 1) goto L205;
        r53.f10258c.getClass();
        return;
    L205:
        if (r52 == 2) goto L210;
        if (r52 != 3) goto L209;
        o r54 = r53.d;
        return;
    L209:
        throw new RuntimeException("Unknown message " + r18);
    L210:
        r53.f10257b.removeMessages(3);
        r53.e = true;
        ((a1) r53.f10258c.f23310b).m(r53.g);
        return;
    L213:
        Object r55 = r18.obj;
        if ((r55 instanceof ce.d) == false) goto L329;
        ce.d r56 = (ce.d) r55;
        ce.b r57 = (ce.b) this.f894b;
        SSWebView r58 = (SSWebView) r57.f1176c;
        if (r58 == null) goto L336;
        if (r56 != null) goto L220;
        return;
    L220:
        if (TextUtils.equals(NotificationCompat.CATEGORY_CALL, r56.f1178a) == false) goto L337;
        ConcurrentHashMap r59 = (ConcurrentHashMap) r57.g;
        if (r59 != null) goto L225;
        return;
    L225:
        if (r59.isEmpty() == true) goto L332;
        String r60 = r58.getUrl();
        if (r57.f1175b == false) goto L229;
    L270:
        JSONObject r61 = new JSONObject();
        ce.c r62 = (ce.c) ((ConcurrentHashMap) r57.g).get(r56.f1180c);     // Catch: Exception -> L275
        if (r62 == null) goto L278;
        r62.a(r56, r61);     // Catch: Exception -> L275
    L278:
        if (r56.f1183j == true) goto L280;
        return;
    L280:
        if (TextUtils.isEmpty(r56.g) == true) goto L282;
        r57.d(r56.g, r56.f1179b, r61);
        return;
    L282:
        r57.g(r56.f1179b, r61);
        return;
    L275:
        e = move-exception;
        e.printStackTrace();
        goto L278
    L229:
        if (TextUtils.isEmpty(r60) == false) goto L232;
    L251:
        String r63 = r56.f1180c;
        ArrayList r64 = (ArrayList) r57.e;
        if (r64 != null) goto L254;
    L256:
        String r65 = r56.f1180c;
        ArrayList r66 = (ArrayList) r57.f;
        if (r66 != null) goto L259;
    L261:
        JSONObject r67 = new JSONObject();
        r67.put("code", -1);     // Catch: JSONException -> L265
        if (TextUtils.isEmpty(r56.g) == true) goto L267;
        r57.d(r56.g, r56.f1179b, r67);     // Catch: JSONException -> L265
    L289:
        return;
    L267:
        r57.g(r56.f1179b, r67);     // Catch: JSONException -> L265
    L265:
        e = move-exception;
        e.printStackTrace();
        return;
    L259:
        if (r66.contains(r65) == false) goto L261;
    L254:
        if (r64.contains(r63) == false) goto L256;
    L232:
        if (r60.startsWith("http://") == false) goto L234;
    L292:
        String r68 = Uri.parse(r60).getHost();     // Catch: Exception -> L288
        if (r68 == null) goto L251;
        ArrayList r69 = (ArrayList) r57.d;     // Catch: Exception -> L288
        if (r69 == null) goto L251;
        if (r69.isEmpty() == true) goto L251;
        int r70 = 0;
    L244:
        if (r70 >= ((ArrayList) r57.d).size()) goto L251;
        String r71 = (String) ((ArrayList) r57.d).get(r70);     // Catch: Exception -> L288
        if (r68.equals(r71) == true) goto L270;
        if (r68.endsWith('.' + r71) == true) goto L270;
        r70 = r70 + 1;
        goto L244
    L234:
        if (r60.startsWith("https://") == false) goto L251;
    L332:
        return;
    L337:
        return;
    L336:
        return;
    L329:
        return;
    L284:
        a r72 = (a) r18.obj;
        r72.a();
        if (r72.f891a <= 0) goto L338;
        int r73 = r18.what;
        w r74 = (w) this.f894b;
        Message r75 = ((b) r74.f9377c).obtainMessage(r73);
        r75.obj = r72;
        ((b) r74.f9377c).sendMessageDelayed(r75, r72.f891a);
        return;
    L338:
        return;
    L5:
        if (r18.what == 10000) goto L8;
        return;
    L8:
        if (r18.arg1 != 0) goto L10;
        r11 = false;
    L10:
        int r76 = r18.arg2;
        yj.b r77 = (yj.b) this.f894b;
        r77.getClass();
        if (r76 != 7) goto L13;
        TNCManager$TNCUpdateSource r78 = TNCManager$TNCUpdateSource.PORTRETRY;
    L28:
        o r79 = r77.d;
        if (r79 == null) goto L31;
        r10 = (yj.a) r79.f23310b;
    L31:
        if (r10 != null) goto L34;
        return;
    L34:
        if (Logger.debug() == false) goto L36;
        Logger.d("TNCManager", "doUpdateRemote, " + r11);
    L36:
        long r80 = SystemClock.elapsedRealtime();
        if (r11 == false) goto L39;
    L43:
        r77.f23290a = r80;
        if (r78 != TNCManager$TNCUpdateSource.TTTNC) goto L46;
        System.currentTimeMillis();
    L46:
        sj.d.h(r77.f23292c).d(r78, false);
        return;
    L39:
        if (((((long) r10.f23287j) * 1000) + r77.f23290a) <= r80) goto L43;
        if (Logger.debug() == false) goto L307;
        Logger.d("TNCManager", "doUpdateRemote, time limit");
        return;
    L307:
        return;
    L13:
        if (r76 != 10) goto L15;
        r78 = TNCManager$TNCUpdateSource.TTREGION;
        goto L28
    L15:
        if (r76 == 20) goto L25;
        switch(r76) {
            case -2: goto L24;
            case -1: goto L23;
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            default: goto L17;
        };
    L17:
        r78 = TNCManager$TNCUpdateSource.TTSERVER;
        goto L28
    L18:
        r78 = TNCManager$TNCUpdateSource.TTTNC;
        goto L28
    L19:
        r78 = TNCManager$TNCUpdateSource.TTPOLL;
        goto L28
    L20:
        r78 = TNCManager$TNCUpdateSource.TTERROR;
        goto L28
    L21:
        r78 = TNCManager$TNCUpdateSource.TTSERVER;
        goto L28
    L22:
        r78 = TNCManager$TNCUpdateSource.TTCACHE;
        goto L28
    L23:
        r78 = TNCManager$TNCUpdateSource.TTHardCode;
        goto L28
    L24:
        r78 = TNCManager$TNCUpdateSource.TTRESUME;
        goto L28
    L25:
        r78 = TNCManager$TNCUpdateSource.TTCRONET;
        goto L28
    L49:
        if (r18.what == 1011) goto L52;
        return;
    L52:
        if (r18.sendingUid != 1000) goto L314;
        Bundle r81 = r18.getData();
        if (r81 != null) goto L57;
        Log.e("olog ConfigHandler", "receive null data");
        return;
    L57:
        Log.i("olog ConfigHandler", "receive config data");
        String r82 = r81.getString("data");     // Catch: JSONException -> L61
        Log.i("olog ConfigHandler", r82);     // Catch: JSONException -> L61
        JSONObject r118 = new JSONObject(r82);     // Catch: JSONException -> L61
        Context r83 = (Context) this.f894b;     // Catch: JSONException -> L61
        if (r83 != null) goto L63;
        Log.e("olog ConfigHandler", "context is null");     // Catch: JSONException -> L61
        return;
    L63:
        UserManager r84 = (UserManager) r83.getSystemService("user");     // Catch: JSONException -> L61
        if (r84 != null) goto L67;
    L69:
        SharedPreferences.Editor r85 = ((Context) this.f894b).createDeviceProtectedStorageContext().getSharedPreferences("olog_config", 0).edit();     // Catch: JSONException -> L61
    L71:
        if (r118.has("report") == false) goto L76;
        r85.putBoolean("report", r118.getBoolean("report"));     // Catch: JSONException -> L61
        if (OLog.d == false) goto L76;
        boolean r86 = OLog.f11908a;     // Catch: JSONException -> L61
    L76:
        if (r118.has("output_to_logd") == false) goto L81;
        boolean r87 = r118.getBoolean("output_to_logd");     // Catch: JSONException -> L61
        r85.putBoolean("output_to_logd", r87);     // Catch: JSONException -> L61
        if (OLog.d == false) goto L81;
        OLog.g(r87);     // Catch: JSONException -> L61
    L81:
        if (r118.has("log_level") == false) goto L86;
        int r88 = r118.getInt("log_level");     // Catch: JSONException -> L61
        r85.putInt("log_level", r88);     // Catch: JSONException -> L61
        if (OLog.d == false) goto L86;
        OLog.f11910c = r88;     // Catch: JSONException -> L61
        ALog.changeLevel(r88);     // Catch: JSONException -> L61
    L86:
        if (r118.has("save_to_disk") == false) goto L89;
        r85.putBoolean("save_to_disk", r118.getBoolean("save_to_disk"));     // Catch: JSONException -> L61
    L89:
        if (r118.has("max_dir_size") == false) goto L92;
        r85.putInt("max_dir_size", r118.getInt("max_dir_size"));     // Catch: JSONException -> L61
    L92:
        if (r118.has("log_expired_days") == false) goto L94;
        r85.putInt("log_expired_days", r118.getInt("log_expired_days"));     // Catch: JSONException -> L61
    L94:
        r85.apply();     // Catch: JSONException -> L61
    L97:
        super.handleMessage(r18);
        return;
    L67:
        if (r84.isUserUnlocked() == false) goto L69;
        r85 = ((Context) this.f894b).getSharedPreferences("olog_config", 0).edit();     // Catch: JSONException -> L61
    L61:
        e = move-exception;
        Log.e("olog ConfigHandler", e.getMessage());
        goto L97
    }

    public /* synthetic */ b(Object r5, Looper r10, int r11) {
        this.f893a = r11;
        this.f894b = r5;
        super(r10);
    }

    public b(h r5, Handler r10) {
        this.f893a = 2;
        this.f894b = r5;
        super(r10.getLooper());
    }

    public b(obric.flow.overlay.b r5) {
        this.f893a = 5;
        Intrinsics.checkNotNullParameter(r5, "binder");
        super(Looper.getMainLooper());
        this.f894b = new WeakReference(r5);
    }

    public b(com.obric.oui.toast.b r5) {
        this.f893a = 4;
        Intrinsics.checkNotNullParameter(r5, "tn");
        super(Looper.getMainLooper());
        this.f894b = r5;
    }
}
