package com.bytedance.ai.bridge.method.router;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.ai.bridge.openApp.AbsOpenAppMethodIDL;
import com.obric.flow.cardlistpage.ui.TransparentDialogActivity;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1955c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ f(int r5, Object r10, Object r11, Object r12, Object r13) {
        this.f1953a = r5;
        this.f1954b = r10;
        this.f1955c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r10 = this.f1955c;
        Object r11 = this.f1954b;
        Object r12 = this.e;
        Object r13 = this.d;
        switch(this.f1953a) {
            case 0: goto L58;
            case 1: goto L34;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        MatrixTeaManager.a((MatrixTeaManager) r11, (String) r10, (JSONObject) r13, (JSONObject) r12);
        return;
    L6:
        Context r14 = (Context) r11;
        Intrinsics.checkNotNullParameter(r14, "$context");
        String r15 = (String) r10;
        Intrinsics.checkNotNullParameter(r15, "$url");
        String r16 = (String) r13;
        Intrinsics.checkNotNullParameter(r16, "$title");
        String r17 = (String) r12;
        Intrinsics.checkNotNullParameter(r17, "$source");
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L10
        if ((r14 instanceof Activity) == false) goto L12;
        Activity r19 = (Activity) r14;     // Catch: Throwable -> L10
    L13:
        if (r19 != null) goto L15;
    L19:
        r19 = null;
    L20:
        if (r19 == null) goto L22;
        Object r110 = com.bytedance.ies.bullet.base.utils.b.t(r19, r15, r16, r17, null);     // Catch: Throwable -> L10
    L23:
        Object r111 = Result.m124constructorimpl(r110);     // Catch: Throwable -> L10
    L26:
        Throwable r112 = Result.m127exceptionOrNullimpl(r111);
        if (r112 == null) goto L33;
        String r20 = androidx.constraintlayout.motion.widget.a.p("openWithNetworkConfirm failed: source=", r17, ", url=", r15);
        Intrinsics.checkNotNullParameter("PrivacyPolicyNavigator", "tag");
        Intrinsics.checkNotNullParameter(r20, "msg");
        Intrinsics.checkNotNullParameter(r112, "t");
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L32;
        ((ju.b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("PrivacyPolicyNavigator", r20, r112);
        return;
    L32:
        throw new IllegalStateException("KoinApplication has not been started");
    L33:
        return;
    L22:
        int r113 = TransparentDialogActivity.f11565a;     // Catch: Throwable -> L10
        u8.a.y(r14.getApplicationContext(), r15, r16, r17);     // Catch: Throwable -> L10
        r110 = Unit.INSTANCE;     // Catch: Throwable -> L10
        goto L23
    L15:
        if (r19.isFinishing() == true) goto L19;
        if (r19.isDestroyed() == true) goto L19;
    L12:
        r19 = null;
    L10:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r111 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L26
    L34:
        Context r22 = (Context) r11;
        Intrinsics.checkNotNullParameter(r22, "$context");
        String r23 = (String) r10;
        Intrinsics.checkNotNullParameter(r23, "$packageName");
        Drawable r114 = (Drawable) r13;
        Intrinsics.checkNotNullParameter(r114, "$appIcon");
        String r24 = (String) r12;
        Intrinsics.checkNotNullParameter(r24, "$appName");
    L38:
        th = move-exception;
        String r25 = "showDownloadDialog failed: packageName=" + r23;
        Intrinsics.checkNotNullParameter("AppMarketDownload", "tag");
        Intrinsics.checkNotNullParameter(r25, "msg");
        Intrinsics.checkNotNullParameter(th, "t");
        org.koin.core.a r26 = su.a.f22013b;
        if (r26 == null) goto L57;
        ((ju.b) r26.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AppMarketDownload", r25, th);
        return;
    L57:
        throw new IllegalStateException("KoinApplication has not been started");
    L36:
        if ((r22 instanceof Activity) == false) goto L40;
        Activity r115 = (Activity) r22;     // Catch: Throwable -> L38
    L41:
        if (r115 != null) goto L43;
    L47:
        r115 = null;
    L48:
        if (r115 == null) goto L50;
        td.e.n(r115, r23, r114, r24, null);     // Catch: Throwable -> L38
        return;
    L50:
        int r116 = TransparentDialogActivity.f11565a;     // Catch: Throwable -> L38
        u8.a.x(r22.getApplicationContext(), r23, r24, td.e.i(r114));     // Catch: Throwable -> L38
        return;
    L43:
        if (r115.isFinishing() == true) goto L47;
        if (r115.isDestroyed() == true) goto L47;
    L40:
        r115 = null;
        goto L41
    L58:
        OpenAppMethod.b((OpenAppMethod) r11, (Activity) r10, (AbsOpenAppMethodIDL.OpenAppRequestModel) r13, (o1.f) r12);
    }
}
