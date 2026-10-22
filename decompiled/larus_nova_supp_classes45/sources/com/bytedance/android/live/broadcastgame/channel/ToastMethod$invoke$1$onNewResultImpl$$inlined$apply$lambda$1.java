package com.bytedance.android.live.broadcastgame.channel;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/live/broadcastgame/channel/ToastMethod$invoke$1$onNewResultImpl$1$1"}, k = 3, mv = {1, 4, 3})
final class ToastMethod$invoke$1$onNewResultImpl$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Bitmap $bitmap$inlined;
    final /* synthetic */ f this$0;

    public ToastMethod$invoke$1$onNewResultImpl$$inlined$apply$lambda$1(f r1, Bitmap r2) {
        this.$bitmap$inlined = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m144invoke() {
        if (this.$bitmap$inlined.copy(Bitmap.Config.ARGB_8888, true) != null) goto L5;
        return;
    L5:
        String r0 = rm3.c.a;
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m144invoke();
        return Unit.INSTANCE;
    }
}
