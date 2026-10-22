package com.obric.oui.c;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.appcompat.app.AppCompatDelegate;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007J\f\u0010\r\u001a\u00020\u0006*\u00020\bH\u0007J\f\u0010\u000e\u001a\u00020\u0006*\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/utils/ActivityUtils;", "", "()V", "TAG", "", "hideNavBar", "", "activity", "Landroid/app/Activity;", "hideNavBar$OUI_standardRelease", "isAppInDarkTheme", "", "isSystemInDarkTheme", "adaptLightDarkStatusBar", "adaptLightDarkSystemBars", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13397a = null;

    static {
        f13397a = new a();
    }

    private a() {
    }

    @JvmStatic
    public static final void a(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Window r5 = ZeusTransformUtils.getWindow(r4, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        WindowInsetsController r6 = null;
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        if (a() == false) goto L10;
    L13:
        r6.setSystemBarsAppearance(0, 8);
        r6.setSystemBarsAppearance(0, 16);
        return;
    L10:
        if (b() == true) goto L13;
        r6.setSystemBarsAppearance(8, 8);
        r6.setSystemBarsAppearance(16, 16);
        return;
    L5:
        r6 = r5.getInsetsController();
        goto L6
    }

    @JvmStatic
    public static final boolean a() {
        int r0 = Resources.getSystem().getConfiguration().uiMode & 48;
        if (r0 != 32) goto L5;
        boolean r1 = true;
    L6:
        com.obric.oui.c.a.b.b("ActivityUtils", "isSystemInDarkTheme: " + r1 + ", currentNightMode" + r0);
        return r1;
    L5:
        r1 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean b() {
        if (AppCompatDelegate.getDefaultNightMode() != 2) goto L5;
        boolean r0 = true;
    L6:
        com.obric.oui.c.a.b.b("ActivityUtils", Intrinsics.stringPlus("isAppInDarkTheme: ", Boolean.valueOf(r0)));
        return r0;
    L5:
        r0 = false;
        goto L6
    }
}
