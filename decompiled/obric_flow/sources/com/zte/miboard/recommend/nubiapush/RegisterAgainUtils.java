package com.zte.miboard.recommend.nubiapush;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import m.h;

/* JADX INFO: loaded from: classes3.dex */
public class RegisterAgainUtils {
    private static final String TAG = "Mi_R_RegisterAgainUtils";
    private static RegisterAgainUtils gRegisterAgainUtils;
    private final SharedPreferences.OnSharedPreferenceChangeListener mListener;
    private boolean mNetConnected;
    private final BroadcastReceiver mNetReceiver;

    public RegisterAgainUtils() {
        this.mNetConnected = false;
        this.mNetReceiver = new AnonymousClass1(this);
        a r5 = new a();
        this.mListener = r5;
        this.mNetConnected = isNetworkConnected(h.a());
        registerNetChangeReceiver();
        h.a().getSharedPreferences("my_preferences", 0).registerOnSharedPreferenceChangeListener(r5);
        ContentResolver r10 = h.a().getContentResolver();
        Uri r11 = Settings.System.getUriFor("zte_float");
        final Handler r12 = new Handler();
        r10.registerContentObserver(r11, true, new AnonymousClass2(this, r12));
    }

    public static /* synthetic */ void a(SharedPreferences r5, String r10) {
        lambda$new$0(r5, r10);
    }

    public static /* synthetic */ boolean access$000(RegisterAgainUtils r5, Context r10) {
        return r5.isNetworkConnected(r10);
    }

    public static /* synthetic */ void access$100(RegisterAgainUtils r5, boolean r10) {
        r5.onNetConnectStateChange(r10);
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public static RegisterAgainUtils getInstance() {
        if (gRegisterAgainUtils != null) goto L6;
        gRegisterAgainUtils = new RegisterAgainUtils();
    L6:
        return gRegisterAgainUtils;
    }

    private boolean isNetworkConnected(Context r5) {
        if (r5 == null) goto L7;
        NetworkInfo r10 = ((ConnectivityManager) r5.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r10 != null) goto L6;
        return false;
    L6:
        return r10.isAvailable();
    L7:
        return false;
    }

    private static /* synthetic */ void lambda$new$0(SharedPreferences r5, String r10) {
        if ("zte_float_recmd".equals(r10) == false) goto L6;
        Log.d(TAG, "RegisterAgainUtils mListener SharedPreferences change.");
        new VeryZhunRegister().tryRegisterAgain();
        return;
    }

    private void onNetConnectStateChange(boolean r5) {
        if (this.mNetConnected == r5) goto L8;
        this.mNetConnected = r5;
        Log.d(TAG, "onNetConnectStateChange netConnected=" + r5);
        if (this.mNetConnected == false) goto L9;
        new VeryZhunRegister().tryRegisterAgain();
        return;
    L9:
        return;
    }

    private void registerNetChangeReceiver() {
        IntentFilter r5 = new IntentFilter();     // Catch: Exception -> L4
        r5.addAction("android.net.conn.CONNECTIVITY_CHANGE");     // Catch: Exception -> L4
        h.a().registerReceiver(this.mNetReceiver, r5, 4);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        kotlin.collections.a.m(e, "registerNetChangeReceiver e=", TAG);
    }
}
