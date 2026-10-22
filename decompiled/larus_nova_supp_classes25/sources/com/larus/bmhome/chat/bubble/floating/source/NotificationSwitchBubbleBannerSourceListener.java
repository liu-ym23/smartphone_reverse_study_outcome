package com.larus.bmhome.chat.bubble.floating.source;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.reach.api.ReachSceneInterceptor;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ns9.e;
import ns9.t;
import pc8.c;
import sc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/source/NotificationSwitchBubbleBannerSourceListener;", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerSourceListener;", "Lcom/larus/reach/api/ReachSceneInterceptor;", "<init>", "()V", "bannerSource", "", "getBannerSource", "()Ljava/lang/String;", "pushScene", "getPushScene", "canShow", "", "request", "Lcom/larus/reach/api/ReachRequest;", "popupType", "event", "Lcom/larus/bmhome/chat/bubble/floating/event/BubbleBannerEvent;", "onClick", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class NotificationSwitchBubbleBannerSourceListener implements BubbleBannerSourceListener, ReachSceneInterceptor {
    public final String a;
    public final String b;

    public static final class a {
    }

    static {
    }

    public NotificationSwitchBubbleBannerSourceListener() {
        this.a = "notification_switch";
        this.b = "notification_switch";
    }

    public final String a() {
        return this.b;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String c() {
        return this.a;
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final String b(b r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        c r4 = r3.l;
        String r0 = null;
        if (r4 == null) goto L9;
        String r5 = r4.c;
        if (r5 == null) goto L9;
        if ((!StringsKt.isBlank(r5)) == false) goto L9;
        r0 = r5;
    L9:
        if (r0 != null) goto L13;
        return "open_notice_push";
    L13:
        return "open_notice_push_".concat(r0);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void e(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final boolean f(t r6) {
        Intrinsics.checkNotNullParameter(r6, "request");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        uc8.a.a.getClass();     // Catch: Throwable -> L9
        if (uc8.a.a() == true) goto L6;
        boolean r1 = true;
    L7:
        Object r2 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L9
    L11:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L14;
        FLogger.a.w("NotificationSwitchBanner", "notification switch reach gate failed, reject display, reachUniqueId=" + r6.a.h, r3);
    L14:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r2) == false) goto L18;
        r2 = r7;
    L18:
        return ((Boolean) r2).booleanValue();
    L6:
        r1 = false;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void g(b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void i(b r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        uc8.a.a.getClass();
        Application r7 = AppHost.a.getApplication();
        Intent r0 = new Intent();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r0.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        r0.putExtra("android.provider.extra.APP_PACKAGE", r7.getPackageName());
    L6:
        r0.addFlags(268435456);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        r7.startActivity(r0);     // Catch: Throwable -> L9
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L12:
        if (Result.isSuccess-impl(r1) == true) goto L22;
        Intent r3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");     // Catch: Throwable -> L15
        r3.setData(Uri.fromParts("package", r7.getPackageName(), null));     // Catch: Throwable -> L15
        r3.addFlags(268435456);     // Catch: Throwable -> L15
        r7.startActivity(r3);     // Catch: Throwable -> L15
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L22:
        return;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L5:
        r0.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        r0.putExtra("app_package", r7.getPackageName());
        r0.putExtra("app_uid", r7.getApplicationInfo().uid);
        goto L6
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void d(b r1, BubbleBannerDismissReason r2) {
        BubbleBannerSourceListener.a.b(r1, r2);
    }

    @Override // com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener
    public final void h(b r1, sc8.a r2) {
        BubbleBannerSourceListener.a.a(r1, r2);
    }

    public final boolean j(t r2, e r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "click");
        return false;
    }
}
