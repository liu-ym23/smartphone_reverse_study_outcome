package com.bytedance.ai.applet.grantingV2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.QSMusicLoginStrategy", f = "QSMusicLoginStrategy.kt", i = {0, 0, 0, 0}, l = {62}, m = "onGrantingIntent", n = {"context", "meta", "granted", "isHistory"}, s = {"L$0", "L$1", "Z$0", "Z$1"})
public final class QSMusicLoginStrategy$onGrantingIntent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QSMusicLoginStrategy this$0;

    public QSMusicLoginStrategy$onGrantingIntent$1(QSMusicLoginStrategy r1, Continuation<? super QSMusicLoginStrategy$onGrantingIntent$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, false, false, this);
    }
}
