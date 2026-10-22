package com.larus.drive.biz.impl.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.utils.DriveAskDoubaoChatLauncher", f = "DriveAskDoubaoChatLauncher.kt", i = {}, l = {105}, m = "getMainBotId", n = {}, s = {})
public final class DriveAskDoubaoChatLauncher$getMainBotId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveAskDoubaoChatLauncher this$0;

    public DriveAskDoubaoChatLauncher$getMainBotId$1(DriveAskDoubaoChatLauncher r1, Continuation<? super DriveAskDoubaoChatLauncher$getMainBotId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DriveAskDoubaoChatLauncher r3 = this.this$0;
        DriveAskDoubaoChatLauncher r0 = DriveAskDoubaoChatLauncher.a;
        return r3.a(this);
    }
}
