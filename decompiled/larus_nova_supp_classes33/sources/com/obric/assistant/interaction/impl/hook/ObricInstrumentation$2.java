package com.obric.assistant.interaction.impl.hook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import oga.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class ObricInstrumentation$2 implements a {
    final /* synthetic */ ObricInstrumentation this$0;
    final /* synthetic */ IBinder val$contextThread;
    final /* synthetic */ Intent val$intent;
    final /* synthetic */ Bundle val$options;
    final /* synthetic */ int val$requestCode;
    final /* synthetic */ Object val$target;
    final /* synthetic */ IBinder val$token;
    final /* synthetic */ Context val$who;

    @Override // oga.a
    public void onDismissFailed() {
    }

    @Override // oga.a
    public void onDismissSucceeded() {
        ObricInstrumentation.access$000(this.this$0, this.val$who, this.val$contextThread, this.val$token, this.val$target, this.val$intent, this.val$requestCode, this.val$options);
    }

    public ObricInstrumentation$2(ObricInstrumentation r1, Context r2, IBinder r3, IBinder r4, Object r5, Intent r6, int r7, Bundle r8) {
        this.this$0 = r1;
        this.val$who = r2;
        this.val$contextThread = r3;
        this.val$token = r4;
        this.val$target = r5;
        this.val$intent = r6;
        this.val$requestCode = r7;
        this.val$options = r8;
    }
}
