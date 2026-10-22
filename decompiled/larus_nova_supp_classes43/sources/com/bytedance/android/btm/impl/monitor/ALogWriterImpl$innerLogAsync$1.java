package com.bytedance.android.btm.impl.monitor;

import com.byted.cast.sink.api.IAPI;
import java.util.concurrent.LinkedBlockingDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
final class ALogWriterImpl$innerLogAsync$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0 $lazyMsg;
    final /* synthetic */ String $tag;

    public ALogWriterImpl$innerLogAsync$1(String r1, Function0 r10) {
        this.$tag = r1;
        this.$lazyMsg = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m646invoke() {
        ALogHandlerThreadV2 r0 = ALogHandlerThreadV2.w;
        String r1 = this.$tag;
        Function0 r10 = this.$lazyMsg;
        r0.getClass();
        if (com.bytedance.android.btm.impl.util.a.a() == false) goto L10;
        e r11 = new e(r1, r10, Long.valueOf(System.currentTimeMillis()), null);     // Catch: Exception -> L7
        ((LinkedBlockingDeque) ALogHandlerThreadV2.v.getValue()).offer(r11);     // Catch: Exception -> L7
        return;
    L11:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m646invoke();
        return Unit.INSTANCE;
    }
}
