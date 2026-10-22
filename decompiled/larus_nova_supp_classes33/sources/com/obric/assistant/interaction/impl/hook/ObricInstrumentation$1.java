package com.obric.assistant.interaction.impl.hook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.interaction.api.service.CheckActivityAuthenticationCallback;
import com.obric.assistant.o4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class ObricInstrumentation$1 implements CheckActivityAuthenticationCallback {
    final /* synthetic */ ObricInstrumentation this$0;
    final /* synthetic */ IBinder val$contextThread;
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ Bundle val$lockScreenAuthReportParams;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ int val$requestCode;
    final /* synthetic */ ISessionAuthenticationService val$sessionAuthenticationService;
    final /* synthetic */ Object val$target;
    final /* synthetic */ IBinder val$token;
    final /* synthetic */ Context val$who;

    @Override // com.obric.assistant.interaction.api.service.CheckActivityAuthenticationCallback
    public void onResult(boolean r11) {
        if (r11 == false) goto L5;
        FLogger.a.i("ObricInstrumentation", "checkActivityAuthenticationOnLockAsync: allow start directly");
        this.val$intent.putExtra("obric_need_activity_auth_on_lock", false);
        this.val$intent.putExtra("obric_allow_show_when_locked", true);
        ObricInstrumentation.access$000(this.this$0, this.val$who, this.val$contextThread, this.val$token, this.val$target, this.val$intent, this.val$requestCode, this.val$options);
        return;
    L5:
        this.val$sessionAuthenticationService.f(new o4(null, null, this.val$lockScreenAuthReportParams), 15000L, new AnonymousClass1(this));
    }

    public ObricInstrumentation$1(ObricInstrumentation r1, Intent r2, Context r3, IBinder r4, IBinder r5, Object r6, int r7, Bundle r8, ISessionAuthenticationService r9, Bundle r10) {
        this.this$0 = r1;
        this.val$intent = r2;
        this.val$who = r3;
        this.val$contextThread = r4;
        this.val$token = r5;
        this.val$target = r6;
        this.val$requestCode = r7;
        this.val$options = r8;
        this.val$sessionAuthenticationService = r9;
        this.val$lockScreenAuthReportParams = r10;
    }
}
