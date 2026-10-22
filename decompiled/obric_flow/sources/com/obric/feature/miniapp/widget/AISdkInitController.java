package com.obric.feature.miniapp.widget;

import android.app.Activity;
import android.app.Application;
import cn.nubia.neopush.commons.Constant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import u0.b;
import u0.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B¯\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\b¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lcom/obric/feature/miniapp/widget/AISdkInitController;", "", "Landroid/app/Application;", "context", "Lkotlin/Function0;", "Landroid/app/Activity;", "currentActivityProvider", "mainActivityProvider", "", "deviceId", "appName", "", Constant.APPID, "appVersion", "appVersionCode", "appPackageName", "appChannel", "updateVersionCode", "", "isOversea", "isDebug", "isTestChannel", "bid", "boeEnable", "boeEnv", "ppeEnable", "ppeEnv", "<init>", "(Landroid/app/Application;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;)V", "Lu0/a;", "d", "Lu0/a;", "getConfig", "()Lu0/a;", "config", "Lt0/b;", "e", "Lt0/b;", "getAbility", "()Lt0/b;", "ability", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AISdkInitController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f11381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f11382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0 f11383c;
    public final u0.a d;
    public final AISdkInitController$ability$1 e;

    /* JADX WARN: Type inference failed for: r1v5, types: [com.obric.feature.miniapp.widget.AISdkInitController$ability$1] */
    public AISdkInitController(Application r23, Function0<? extends Activity> r24, Function0<? extends Activity> r25, String r26, String r27, int r28, String r29, String r30, String r31, String r32, String r33, boolean r34, boolean r35, boolean r36, String r37, boolean r38, String r39, boolean r40, String r41) {
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r24, "currentActivityProvider");
        Intrinsics.checkNotNullParameter(r25, "mainActivityProvider");
        Intrinsics.checkNotNullParameter(r26, "deviceId");
        Intrinsics.checkNotNullParameter(r27, "appName");
        Intrinsics.checkNotNullParameter(r29, "appVersion");
        Intrinsics.checkNotNullParameter(r30, "appVersionCode");
        Intrinsics.checkNotNullParameter(r31, "appPackageName");
        Intrinsics.checkNotNullParameter(r32, "appChannel");
        Intrinsics.checkNotNullParameter(r33, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r37, "bid");
        Intrinsics.checkNotNullParameter(r39, "boeEnv");
        Intrinsics.checkNotNullParameter(r41, "ppeEnv");
        this.f11381a = r23;
        this.f11382b = r24;
        this.f11383c = r25;
        u0.a r5 = new u0.a(r23, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41);
        Map r10 = b.f22207a;
        c r11 = new c();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        b.f22207a.put(r5, r11);
        this.d = r5;
        this.e = new AISdkInitController$ability$1(this);
    }

    public static final /* synthetic */ Application access$getContext$p(AISdkInitController r5) {
        return r5.f11381a;
    }

    public static final /* synthetic */ Function0 access$getCurrentActivityProvider$p(AISdkInitController r5) {
        return r5.f11382b;
    }

    public static final /* synthetic */ Function0 access$getMainActivityProvider$p(AISdkInitController r5) {
        return r5.f11383c;
    }

    public final t0.b getAbility() {
        return this.e;
    }

    public final u0.a getConfig() {
        return this.d;
    }
}
