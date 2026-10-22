package com.obric.aiagent.messenger.stub;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AppIntentIDLStub$d implements com.larus.platform.api.g1.c {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ kotlinx.coroutines.i<Boolean> b;
    public final /* synthetic */ AppIntentIDLStub c;
    public final /* synthetic */ String d;

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
        boolean r0 = AppIntentIDLStub.access$isForegroundLocationPermissionGranted(this.c, AppHost.a.getApplication());
        FLogger.a.i(AppIntentIDLStub.access$getTAG$p(this.c), "requestPermission " + this.d + " return from setting page, result: " + r0);
        if (this.a.element == false) goto L5;
        return;
    L5:
        if (this.b.isActive() == false) goto L9;
        this.a.element = true;
        this.b.resumeWith(Result.constructor-impl(Boolean.valueOf(r0)));
        return;
    }

    public final void onGoSettingsDialogDismiss(boolean r5) {
        FLogger.a.i(AppIntentIDLStub.access$getTAG$p(this.c), "requestPermission " + this.d + " onGoSettingsDialogRefused");
        if (r5 == false) goto L5;
        return;
    L5:
        if (this.a.element == false) goto L7;
        return;
    L7:
        if (this.b.isActive() == false) goto L12;
        this.a.element = true;
        kotlinx.coroutines.i<Boolean> r6 = this.b;
        Result.Companion r0 = Result.Companion;
        r6.resumeWith(Result.constructor-impl(Boolean.FALSE));
        return;
    }

    public AppIntentIDLStub$d(Ref.BooleanRef r1, kotlinx.coroutines.j r2, AppIntentIDLStub r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "grantedList");
        Intrinsics.checkNotNullParameter(r4, "deniedList");
        if (r5 == false) goto L6;
        return;
    L6:
        if (this.a.element == false) goto L8;
    L10:
        FLogger.a.i(AppIntentIDLStub.access$getTAG$p(this.c), "requestPermission " + this.d + " onResult: " + r2);
        return;
    L8:
        if (this.b.isActive() == false) goto L10;
        this.a.element = true;
        this.b.resumeWith(Result.constructor-impl(Boolean.valueOf(r2)));
        goto L10
    }
}
