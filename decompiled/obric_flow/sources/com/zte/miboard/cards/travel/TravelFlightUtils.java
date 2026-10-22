package com.zte.miboard.cards.travel;

import ai.j0;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import c.k0;
import c.m;
import c.q0;
import c.s0;
import c.v;
import com.google.gson.Gson;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.zte.miboard.cards.AppCallbackUtils;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.common.DialogAty;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class TravelFlightUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f16363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f16364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ArrayList<j> f16365c;
    private static ContentObserver d;
    private static long e;
    private static String f;
    private static String g;

    @Keep
    public static class MiBoardData {
        String androidId;

        private MiBoardData(String r5) {
            this.androidId = r5;
        }

        public /* synthetic */ MiBoardData(String r5, a r10) {
            this(r5);
        }
    }

    public class a implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f16367b;

        /* JADX INFO: renamed from: com.zte.miboard.cards.travel.TravelFlightUtils$a$a, reason: collision with other inner class name */
        public class C0025a implements j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f16368a;

            public C0025a(a r5) {
                this.f16368a = r5;
            }

            @Override // com.zte.miboard.cards.travel.TravelFlightUtils.j
            public void a(boolean r5) {
                TravelFlightUtils.a(this.f16368a.f16366a, r5);
            }
        }

        public a(Context r5, Runnable r10) {
            this.f16366a = r5;
            this.f16367b = r10;
        }

        public void a(i r5) {
            if (r5 != null) goto L5;
        L7:
            boolean r10 = false;
        L8:
            TravelFlightUtils.a(Boolean.valueOf(r10));
            m.i("TravelFlightUtils", "onTravelCardInited runInMainThread sRecommendSupportRegisterVeryZhun=" + TravelFlightUtils.a() + " recommendData=" + r5);
            if (TravelFlightUtils.c() == false) goto L11;
            TravelFlightUtils.a(this.f16366a);
            TravelFlightUtils.a(this.f16366a, new C0025a(this), false);
        L11:
            Runnable r11 = this.f16367b;
            if (r11 == null) goto L15;
            r11.run();
            return;
        L15:
            return;
        L5:
            if (r5.a() == false) goto L7;
            r10 = true;
            goto L8
        }

        public i b() {
            return TravelFlightUtils.k(this.f16366a);
        }

        @Override // c.q0
        public void onError(Throwable r5) {
            m.j("TravelFlightUtils", "onTravelCardInited onError", r5);
        }

        @Override // c.q0
        public /* bridge */ /* synthetic */ void a(Object r5) {
            a((i) r5);
        }

        @Override // c.q0
        public /* bridge */ /* synthetic */ Object a() {
            return b();
        }
    }

    public class b implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f16369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f16370b;

        public b(boolean r5, Context r10) {
            this.f16369a = r5;
            this.f16370b = r10;
        }

        @Override // c.q0
        public void a(Object r5) {
        }

        @Override // c.q0
        public void onError(Throwable r5) {
            m.j("TravelFlightUtils", "saveRegisterVeryZhunRecommendDeviceId error", r5);
        }

        @Override // c.q0
        public Object a() {
            String r5 = "";
            if (this.f16369a == false) goto L7;
            i r10 = TravelFlightUtils.k(this.f16370b);
            if (TextUtils.isEmpty(r10.d) == true) goto L7;
            r5 = r10.d;
        L7:
            this.f16370b.getSharedPreferences("travel_data", 0).edit().putString("register_very_zhun_recommend_device_id", r5).putBoolean("register_very_zhun_recommend_device_id_backup_boolean", true).commit();
            String r11 = TravelFlightUtils.b(this.f16370b);
            if (TextUtils.isEmpty(r11) == true) goto L10;
            this.f16370b.getSharedPreferences("travel_data", 0).edit().putString("travel_miboard_android_id", r11).commit();
        L10:
            m.i("TravelFlightUtils", "saveRegisterVeryZhunIds savedAndroidId=" + r11 + " saveDeviceId=" + r5);
            return null;
        }
    }

    public class c implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16371a;

        public c(Context r5) {
            this.f16371a = r5;
        }

        @Override // c.q0
        public void a(Object r5) {
        }

        @Override // c.q0
        public void onError(Throwable r5) {
            m.j("TravelFlightUtils", "registerAgainRecommendIfNeedForBackupAndRestoreDone onError", r5);
        }

        @Override // c.q0
        public Object a() {
            String r5 = this.f16371a.getSharedPreferences("travel_data", 0).getString("register_very_zhun_recommend_device_id", "");
            m.i("TravelFlightUtils", "registerAgainRecommendIfNeedForBackupAndRestoreDone saveDeviceId=" + r5);
            if (TextUtils.isEmpty(r5) == true) goto L9;
            boolean r10 = this.f16371a.getSharedPreferences("travel_data", 0).getBoolean("register_very_zhun_recommend_device_id_backup_boolean", false);
            m.i("TravelFlightUtils", "registerAgainRecommendIfNeedForBackupAndRestoreDone backupFlag=" + r10);
            if (r10 == true) goto L10;
            m.l("TravelFlightUtils", "registerAgainRecommendIfNeedForBackupAndRestoreDone miboarAndroidId=" + TravelFlightUtils.e(this.f16371a) + " saveDeviceId=" + r5);
            TravelFlightUtils.a(this.f16371a, true, true);
            this.f16371a.getSharedPreferences("travel_data", 0).edit().putBoolean("register_very_zhun_recommend_device_id_backup_boolean", true).commit();
            return null;
        L10:
            return null;
        L9:
            return null;
        }
    }

    public class d extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16372a;

        public d(Handler r5, Context r10) {
            this.f16372a = r10;
            super(r5);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r5) {
            super.onChange(r5);
            boolean r10 = TravelFlightUtils.g(this.f16372a);
            m.i("TravelFlightUtils", "registerVeryZhunRegisteredStateCallback onChange isVeryZhunRegistered=" + r10);
            Iterator r11 = TravelFlightUtils.b().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            ((j) r11.next()).a(r10);
            goto L4
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f16374b;

        public e(Context r5, boolean r10) {
            this.f16373a = r5;
            this.f16374b = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.i("TravelFlightUtils", "asyncCallRecommendRegisterRegisterVeryZhun not isSupportRegisterVeryZhun call onTravelCardInited isSupportRegisterVeryZhun=" + TravelFlightUtils.c());
            if (TravelFlightUtils.c() == false) goto L6;
            TravelFlightUtils.a(0);
            TravelFlightUtils.b(this.f16373a, this.f16374b);
            return;
        }
    }

    public class f implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f16376b;

        public f(Context r5, boolean r10) {
            this.f16375a = r5;
            this.f16376b = r10;
        }

        @Override // c.q0
        public void a(Object r5) {
            if ((r5 instanceof i) == false) goto L10;
            i r10 = (i) r5;
            if (r10 != null) goto L7;
            return;
        L7:
            if (r10.f16379a == true) goto L28;
            TravelFlightUtils.a(this.f16375a, r10.f16380b);
            return;
        L28:
            return;
        L10:
            if ("showInstallVeryZhunDialog".equals(r5) == false) goto L13;
            TravelFlightUtils.c(this.f16375a);
            return;
        L13:
            if (IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST.equals(r5) == false) goto L31;
            StringBuilder r11 = new StringBuilder("asyncCallRecommendRegisterRegisterVeryZhun AREADY_REGISTER size=");
            if (TravelFlightUtils.b() == null) goto L17;
            Integer r12 = Integer.valueOf(TravelFlightUtils.b().size());
        L18:
            r11.append(r12);
            m.i("TravelFlightUtils", r11.toString());
            if (TravelFlightUtils.b() != null) goto L21;
            return;
        L21:
            if (TravelFlightUtils.b().isEmpty() == true) goto L33;
            Iterator r13 = TravelFlightUtils.b().iterator();
        L24:
            if (r13.hasNext() == false) goto L34;
            ((j) r13.next()).a(true);
            goto L24
        L34:
            return;
        L33:
            return;
        L17:
            r12 = null;
            goto L18
        }

        @Override // c.q0
        public void onError(Throwable r5) {
            m.j("TravelFlightUtils", "asyncCallRecommendRegisterRegisterVeryZhun onError", r5);
        }

        @Override // c.q0
        public Object a() {
            i r5 = TravelFlightUtils.k(this.f16375a);
            if (r5 == null) goto L8;
            if (r5.f16379a == true) goto L8;
            return r5;
        L8:
            if (s0.h(this.f16375a, "com.tencent.mm") == false) goto L10;
        L13:
            String r10 = TravelFlightUtils.a(this.f16375a, false, this.f16376b);
            if (r10 != null) goto L17;
            return "";
        L17:
            return r10;
        L10:
            if (s0.h(this.f16375a, "vz.com") == true) goto L13;
            return "showInstallVeryZhunDialog";
        }
    }

    public class g extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16377a;

        public g(Context r5) {
            this.f16377a = r5;
        }

        /* JADX INFO: Removed unreachable split cross block B:24:0x006f */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r5, Intent r10) {
            LocalBroadcastManager.getInstance(this.f16377a).unregisterReceiver(this);     // Catch: Exception -> L13
            boolean r11 = r10.getBooleanExtra("local_broadcast_result", false);     // Catch: Exception -> L13
            m.i("TravelFlightUtils", "showOpenRecommendDialog LocalBroadcastManager onReceive, result=" + r11 + " context=" + this.f16377a + " receiveContext=" + r5);     // Catch: Exception -> L13
            if (r11 == true) goto L25;
            Context r12 = this.f16377a;     // Catch: Exception -> L13
            if ((r12 instanceof TravelSettingsAty) == false) goto L21;
            ((TravelSettingsAty) r12).finish();     // Catch: Exception -> L13
        L21:
            return;
        L25:
            Intent r13 = new Intent();     // Catch: Throwable -> L8
            r13.setClassName("com.zte.floatassist", "com.zte.floatassist.FloatActivity");     // Catch: Throwable -> L8
            Context r14 = this.f16377a;     // Catch: Throwable -> L8
            if ((r14 instanceof Activity) == false) goto L10;
            r14.startActivity(r13);     // Catch: Throwable -> L8
            goto L21
        L10:
            s0.g(r14, r13);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            m.j("TravelFlightUtils", "showOpenRecommendDialog startActivity error", th);     // Catch: Exception -> L13
        L13:
            e = move-exception;
            m.j("TravelFlightUtils", "showOpenRecommendDialog LocalBroadcastManager onReceive error", e);
        }
    }

    public class h extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f16378a;

        public h(boolean r5) {
            this.f16378a = r5;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            LocalBroadcastManager.getInstance(r10).unregisterReceiver(this);     // Catch: Exception -> L7
            boolean r12 = r11.getBooleanExtra("local_broadcast_result", false);     // Catch: Exception -> L7
            m.i("TravelFlightUtils", "showInstallVeryZhunDialog LocalBroadcastManager onReceive, result=" + r12);     // Catch: Exception -> L7
            if (r12 == false) goto L12;
            m.i("TravelFlightUtils", "showInstallVeryZhunDialog showDownloadAppDialog jumped=" + this.f16378a);     // Catch: Exception -> L7
            s0.i(r10, "vz.com");     // Catch: Exception -> L7
            return;
        L12:
            return;
        L7:
            e = move-exception;
            m.j("TravelFlightUtils", "showInstallVeryZhunDialog LocalBroadcastManager onReceive error", e);
        }
    }

    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected boolean f16379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected String f16380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected String f16381c;
        protected String d;
        protected String e;

        public i() {
        }

        public boolean a() {
            if (TextUtils.isEmpty(this.d) == true) goto L5;
        L8:
            return true;
        L5:
            if (TextUtils.isEmpty(this.e) == false) goto L8;
            return false;
        }
    }

    public interface j {
        void a(boolean r5);
    }

    static {
        f16365c = new ArrayList();
        f = "miboard.travel.open_recommend_dialog";
        g = "miboard.travel.install_very_zhun_dialog";
    }

    public static /* synthetic */ Boolean a() {
        return f16363a;
    }

    public static /* synthetic */ String b(Context r5) {
        return f(r5);
    }

    public static /* synthetic */ void c(Context r5) {
        j(r5);
    }

    private static Uri d(Context r5) {
        if (r5 != null) goto L4;
    L6:
        String r10 = "content://com.zte.miboard.recommend.RecommendProvider";
    L8:
        return Uri.parse(r10);
    L4:
        if (r5.getPackageName().equals("com.zte.miboard.cardsdemo") == false) goto L6;
        r10 = "content://com.zte.miboard.cardsdemo.recommend.RecommendProvider";
        goto L8
    }

    public static String e(Context r10) {
        if (c() == true) goto L6;
        m.i("TravelFlightUtils", "getRegisterVeryZhunMiBoardAndroidId not isSupportRegisterVeryZhun return");
        return "";
    L6:
        String r5 = f(r10);
        if (f16364b != null) goto L9;
        f16364b = r10.getSharedPreferences("travel_data", 0).getString("travel_miboard_android_id", "");
    L9:
        if (r5 == null) goto L16;
        if (TextUtils.isEmpty(r5) == true) goto L16;
        if (r5.equals(f16364b) == true) goto L16;
        r10.getSharedPreferences("travel_data", 0).edit().putString("travel_miboard_android_id", r5).commit();
        c(r10, true);
        m.i("TravelFlightUtils", "getRegisterVeryZhunMiBoardAndroidId save miboardData.androidId savedAndroidId=".concat(r5));
    L16:
        if (TextUtils.isEmpty(r5) == false) goto L21;
        if (TextUtils.isEmpty(f16364b) == true) goto L21;
        r5 = f16364b;
    L21:
        if (TextUtils.isEmpty(r5) == false) goto L23;
        r5 = k0.a(r10);
        r10.getSharedPreferences("travel_data", 0).edit().putString("travel_miboard_android_id", r5).commit();
        m.i("TravelFlightUtils", "getRegisterVeryZhunMiBoardAndroidId save PhoneUtils.getAndroidId savedAndroidId=" + r5);
    L23:
        StringBuilder r11 = j0.x("getRegisterVeryZhunMiBoardAndroidId result=", r5, " getAndroidId=");
        r11.append(k0.a(r10));
        m.i("TravelFlightUtils", r11.toString());
        return r5;
    }

    private static String f(Context r5) {
        if (c() == true) goto L19;
        m.i("TravelFlightUtils", "getSettingsSavedRegisterVeryZhunMiBoardId not isSupportRegisterVeryZhun return");
        return "";
    L19:
        String r10 = Settings.Global.getString(r5.getContentResolver(), "floatassist_veryzhun_state_miboard");     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r10) == true) goto L12;
        MiBoardData r11 = (MiBoardData) new Gson().fromJson(r10, MiBoardData.class);     // Catch: Throwable -> L10
    L13:
        if (r11 != null) goto L15;
    L18:
        return "";
    L15:
        if (TextUtils.isEmpty(r11.androidId) == true) goto L18;
        return r11.androidId;
    L12:
        r11 = null;
    L10:
        th = move-exception;
        m.j("TravelFlightUtils", "getSettingsSavedRegisterVeryZhunMiBoardId fromJson error", th);
        goto L12
    }

    public static boolean g(Context r5) {
        boolean r10 = false;
        if (c() == true) goto L8;
        String r11 = "isVeryZhunRegistered not isSupportRegisterVeryZhun return";
    L5:
        m.i("TravelFlightUtils", r11);
        return r10;
    L8:
        if (Settings.Global.getInt(r5.getContentResolver(), "floatassist_veryzhun_state", 0) != 1) goto L10;
        r10 = true;
    L10:
        if (r10 == true) goto L12;
        String r12 = Settings.Global.getString(r5.getContentResolver(), "floatassist_veryzhun_miboard");
        r10 = !TextUtils.isEmpty(r12);
        m.n("TravelFlightUtils", "isVeryZhunRegistered miboard state=" + r10 + " miboard=" + r12);
    L12:
        r11 = "isVeryZhunRegistered state=" + r10;
        goto L5
    }

    public static void h(Context r5) {
        m.i("TravelFlightUtils", "onTravelCardRemoved");
        l(r5);
    }

    private static void i(Context r5) {
        if (c() == true) goto L6;
        m.i("TravelFlightUtils", "registerAgainRecommendIfNeedForBackupAndRestoreDone not isSupportRegisterVeryZhun return");
        return;
    L6:
        m.h(new c(r5));
    }

    private static void j(Context r10) {
        if (c() == true) goto L14;
        m.i("TravelFlightUtils", "showInstallVeryZhunDialog not isSupportRegisterVeryZhun return");
        return;
    L14:
        boolean r5 = AppCallbackUtils.showDownloadAppDialog(r10, "vz.com", r10.getDrawable(R.drawable.app_icon_feichangzhun), r10.getString(R.string.app_title_feichangzhun));     // Catch: Exception -> L11
        m.i("TravelFlightUtils", "showInstallVeryZhunDialog showDownloadAppDialog jumped=" + r5);     // Catch: Exception -> L11
        if (r5 == false) goto L9;
        return;
    L9:
        DialogAty.a(r10, g, r10.getResources().getString(R.string.dialog_title_reminder), r10.getResources().getString(R.string.travel_third_register_very_zhun_uninstall), r10.getResources().getString(R.string.dialog_ok_download), r10.getResources().getString(R.string.dialog_button_cancel), true);     // Catch: Exception -> L11
        LocalBroadcastManager.getInstance(r10).registerReceiver(new h(r5), new IntentFilter(g));     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        m.j("TravelFlightUtils", "showInstallVeryZhunDialog error", e);
    }

    @NonNull
    public static i k(Context r10) {
        i r5 = new i();
        r5.f16379a = false;
        ContentProviderClient r11 = r10.getContentResolver().acquireContentProviderClient(d(r10));     // Catch: Throwable -> L16
        Bundle r12 = r11.call("recommend", NotificationCompat.CATEGORY_STATUS, null);     // Catch: Throwable -> L12
        StringBuilder r13 = new StringBuilder("syncCallRecommendStatus bundle=");     // Catch: Throwable -> L12
        if (r12 == null) goto L7;
        boolean r14 = true;
    L8:
        r13.append(r14);     // Catch: Throwable -> L12
        m.i("TravelFlightUtils", r13.toString());     // Catch: Throwable -> L12
        if (r12 == null) goto L14;
        r5.f16379a = r12.getBoolean("TripStatus", false);     // Catch: Throwable -> L12
        r5.f16380b = r12.getString("RecommendName", "");     // Catch: Throwable -> L12
        r5.f16381c = r12.getString("RecommendPath", "");     // Catch: Throwable -> L12
        r5.d = r12.getString("VeryZhunDevId", "");     // Catch: Throwable -> L12
        r5.e = r12.getString("VeryZhunRegId", "");     // Catch: Throwable -> L12
    L14:
        r11.close();     // Catch: Throwable -> L16
    L25:
        f16363a = Boolean.valueOf(r5.a());
        m.i("TravelFlightUtils", "syncCallRecommendStatus status=" + r5.f16379a + ", name=" + r5.f16380b + ", deviceId=" + r5.d + ", regId=" + r5.e);
        return r5;
    L7:
        r14 = false;
    L12:
        th = move-exception;
        if (r11 != null) goto L27;
    L23:
        throw th;     // Catch: Throwable -> L16
    L27:
        r11.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        m.j("TravelFlightUtils", "syncCallRecommendStatus error", th);
        goto L25
    }

    private static void l(Context r5) {
        m.i("TravelFlightUtils", "unregisterVeryZhunRegisteredStateAllCallback size=" + f16365c.size());
        Iterator r10 = new ArrayList(f16365c).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        a(r5, (j) r10.next());
        goto L4
    }

    public static /* synthetic */ Boolean a(Boolean r5) {
        f16363a = r5;
        return r5;
    }

    public static /* synthetic */ ArrayList b() {
        return f16365c;
    }

    public static boolean c() {
        if (s0.f1083a == true) goto L5;
    L9:
        return false;
    L5:
        if (f16363a == null) goto L9;
        if (f16363a.booleanValue() == false) goto L9;
        return true;
    }

    public static /* synthetic */ void a(Context r5) {
        i(r5);
    }

    public static void b(Context r10, boolean r11) {
        long r5 = System.currentTimeMillis();
        if (Math.abs(r5 - e) >= 1000) goto L6;
        m.i("TravelFlightUtils", "asyncCallRecommendRegisterRegisterVeryZhun too quick return");
        return;
    L6:
        e = r5;
        if (c() == true) goto L11;
        m.i("TravelFlightUtils", "asyncCallRecommendRegisterRegisterVeryZhun not isSupportRegisterVeryZhun call onTravelCardInited sRecommendSupportRegisterVeryZhun=" + f16363a);
        a(r10, new e(r10, r11));
        return;
    L11:
        if (v.b(r10) == true) goto L13;
        Toast.makeText(r10, R.string.net_connected_error, 0).show();
    L13:
        m.h(new f(r10, r11));
    }

    private static void c(Context r5, boolean r10) {
        if (c() == true) goto L6;
        m.i("TravelFlightUtils", "saveRegisterVeryZhunIds not isSupportRegisterVeryZhun return");
        return;
    L6:
        m.h(new b(r10, r5));
    }

    public static /* synthetic */ void a(Context r5, boolean r10) {
        c(r5, r10);
    }

    private static String b(Context r10, boolean r11, boolean r12) {
        String r5 = "";
        if (c() == true) goto L37;
        m.i("TravelFlightUtils", "callRecommendRegisterRegisterVeryZhun not isSupportRegisterVeryZhun return");
        return "";
    L37:
        ContentProviderClient r13 = r10.getContentResolver().acquireContentProviderClient(d(r10));     // Catch: Throwable -> L23
        Bundle r14 = new Bundle();     // Catch: Throwable -> L11
        r14.putString("miboard", new Gson().toJson(new MiBoardData(e(r10), null)));     // Catch: Throwable -> L11
        if (r11 == false) goto L13;
        String r15 = "registerAgain";
    L16:
        Bundle r16 = r13.call("veryzhun", r15, r14);     // Catch: Throwable -> L11
        if (r16 == null) goto L19;
        r5 = r16.getString("result", "");     // Catch: Throwable -> L11
    L20:
        m.i("TravelFlightUtils", "callRecommendRegisterRegisterVeryZhun call registerAgain=" + r11 + " register=" + r12 + " result=" + r5);     // Catch: Throwable -> L11
        r13.close();     // Catch: Throwable -> L23
    L32:
        return r5;
    L19:
        r5 = null;
        goto L20
    L13:
        if (r12 == false) goto L15;
        r15 = "register";
        goto L16
    L15:
        r15 = "unregister";
    L11:
        th = move-exception;
        if (r13 != null) goto L35;
    L30:
        throw th;     // Catch: Throwable -> L23
    L35:
        r13.close();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        m.j("TravelFlightUtils", "callRecommendRegisterRegisterVeryZhun call registerAgain=" + r11 + " register=" + r12, th);
        goto L32
    }

    public static /* synthetic */ String a(Context r5, boolean r10, boolean r11) {
        return b(r5, r10, r11);
    }

    public static /* synthetic */ long a(long r5) {
        e = r5;
        return r5;
    }

    public static void a(Context r5, Runnable r10) {
        m.i("TravelFlightUtils", "onTravelCardInited");
        m.h(new a(r5, r10));
    }

    public static void a(Context r5, j r10, boolean r11) {
        if (c() == true) goto L12;
        if (r11 == false) goto L9;
        if (r10 == null) goto L9;
        if (f16365c.contains(r10) == true) goto L9;
        f16365c.add(r10);
    L9:
        String r12 = "registerVeryZhunRegisterStateCallback not isSupportRegisterVeryZhun return";
    L10:
        m.i("TravelFlightUtils", r12);
        return;
    L12:
        if (r10 != null) goto L14;
        return;
    L14:
        if (f16365c.contains(r10) == true) goto L27;
        f16365c.add(r10);
        if (d != null) goto L23;
        d = new d(new Handler(Looper.getMainLooper()), r5);
        r5.getContentResolver().registerContentObserver(Settings.Global.getUriFor("floatassist_veryzhun_state"), false, d);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        m.j("TravelFlightUtils", "registerVeryZhunRegisteredStateCallback error", th);
    L23:
        r12 = "registerVeryZhunRegisterStateCallback add newSize=" + f16365c.size() + " callback=" + r10;
        goto L10
    }

    public static void a(Context r10, String r11) {
        m.i("TravelFlightUtils", "showOpenRecommendDialog recommendName=" + r11);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r11) == false) goto L7;
        r11 = r10.getString(R.string.travel_trip_recommend_default_title);     // Catch: Exception -> L9
    L7:
        DialogAty.a(r10, f, r10.getResources().getString(R.string.dialog_title_reminder), String.format(r10.getString(R.string.travel_trip_recommend_close_dialog_info), new Object[]{r11, r11}), r10.getResources().getString(R.string.dialog_to_setting), r10.getResources().getString(R.string.dialog_button_cancel), true);     // Catch: Exception -> L9
        LocalBroadcastManager.getInstance(r10).registerReceiver(new g(r10), new IntentFilter(f));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        m.j("TravelFlightUtils", "showOpenRecommendDialog error", e);
    }

    public static void a(Context r5, j r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (f16365c.contains(r10) == false) goto L23;
        f16365c.remove(r10);
        if (c() == true) goto L12;
        String r11 = "unregisterVeryZhunRegisterStateCallback not isSupportRegisterVeryZhun return";
    L9:
        m.i("TravelFlightUtils", r11);
        return;
    L12:
        if (f16365c.isEmpty() == true) goto L21;
    L19:
        r11 = "unregisterVeryZhunRegisterStateCallback remove newSize=" + f16365c.size() + " callback=" + r10;
        goto L9
    L21:
    L17:
        e = move-exception;
        m.j("TravelFlightUtils", "unRegisterVeryZhunRegisteredStateCallback error", e);
        goto L19
    L14:
        if (d == null) goto L19;
        r5.getContentResolver().unregisterContentObserver(d);     // Catch: Exception -> L17
        d = null;     // Catch: Exception -> L17
        goto L19
    }
}
