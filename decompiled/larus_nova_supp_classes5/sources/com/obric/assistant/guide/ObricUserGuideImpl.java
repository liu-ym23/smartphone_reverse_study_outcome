package com.obric.assistant.guide;

import android.app.KeyguardManager;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Settings;
import androidx.lifecycle.MutableLiveData;
import cea.b;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.t1;
import dea.a;
import f06.d;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0017R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00050\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/guide/ObricUserGuideImpl;", "Lcom/obric/assistant/guide/IObricUserGuide;", "<init>", "()V", "skipForEnterpriseAccountIfNeeded", "", "createUserGuideRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "_interceptComplete", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "useSystemDrawable", "hasSecureLock", "getInterceptCompleteLiveData", "Landroidx/lifecycle/LiveData;", "isInSetupWizard", "context", "Landroid/content/Context;", "markInterceptComplete", "", "resetInterceptState", "isVoicePrintExist", "isFingerPrintExist", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUserGuideImpl implements IObricUserGuide {
    public final MutableLiveData<Boolean> a;

    static {
    }

    public final boolean b() {
        ContentProviderClient r1 = null;
        Bundle r2 = null;
        r2 = null;
        r2 = null;
        ContentProviderClient r3 = k(AppHost.a.getApplication().getContentResolver(), Uri.parse("content://com.android.settings.fingerprint.doubaoprovider"));     // Catch: Throwable -> L11 RemoteException -> L13
        if (r3 != null) goto L29;
    L9:
        if (r3 == null) goto L19;
    L10:
        r3.close();
    L19:
        if (r2 != null) goto L21;
        return false;
    L21:
        if (r2.getBoolean("has_ai_fingerprint", false) != true) goto L35;
        return true;
    L35:
        return false;
    L29:
        r2 = r3.call("has_ai_fingerprint", null, null);     // Catch: RemoteException -> L7 Throwable -> L24
    L7:
        e = e;
    L15:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r3 == null) goto L19;
    L24:
        th = th;
        r1 = r3;
    L26:
        if (r1 == null) goto L28;
        r1.close();
    L28:
        throw th;
    L13:
        e = e;
        r3 = null;
    L11:
        th = th;
        goto L26
    }

    public final void c() {
        this.a.postValue(Boolean.FALSE);
    }

    public final void e() {
        this.a.postValue(Boolean.TRUE);
    }

    public final boolean g() {
        Object r0 = AppHost.a.getApplication().getSystemService("keyguard");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return ((KeyguardManager) r0).isKeyguardSecure();
    }

    public final a i() {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L7;
        return null;
    L7:
        return new a();
    }

    public final boolean j() {
        return t1.a.B();
    }

    public ObricUserGuideImpl() {
        this.a = new MutableLiveData(Boolean.FALSE);
    }

    public final boolean a() {
        return b.a();
    }

    public final boolean h() {
        return t9a.b.a().c("obric_feature_user_guide_sys_res");
    }

    public final MutableLiveData f() {
        return this.a;
    }

    public final boolean d(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        ContentResolver r9 = r8.getContentResolver();     // Catch: Exception -> L16
        if (Settings.Global.getInt(r9, "device_provisioned", 0) != 1) goto L6;
        boolean r2 = true;
    L8:
        if (Settings.Secure.getInt(r9, "user_setup_complete", 0) != 1) goto L10;
        boolean r10 = true;
    L11:
        FLogger.a.i("ObricUserGuideImpl", "deviceProvisioned=" + r2 + " userSetupComplete=" + r10);     // Catch: Exception -> L16
        if (r2 == false) goto L14;
        if (r10 == false) goto L14;
        return false;
    L14:
        return true;
    L10:
        r10 = false;
        goto L11
    L6:
        r2 = false;
    L20:
        return false;
    }

    public static ContentProviderClient k(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
