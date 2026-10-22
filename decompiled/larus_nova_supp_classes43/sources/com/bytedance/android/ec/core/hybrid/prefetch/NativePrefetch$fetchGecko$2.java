package com.bytedance.android.ec.core.hybrid.prefetch;

import com.bytedance.forest.model.Response;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lcom/bytedance/forest/model/Response;", "invoke"}, k = 3, mv = {1, 4, 3})
final class NativePrefetch$fetchGecko$2 extends Lambda implements Function1<Response, Unit> {
    final /* synthetic */ Channel $channel;
    final /* synthetic */ String $configUrl;
    final /* synthetic */ NativePrefetch this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ Job a;

        public a(Job r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Job.DefaultImpls.cancel$default(this.a, null, 1, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public NativePrefetch$fetchGecko$2(NativePrefetch r1, Channel r10, String r11) {
        this.this$0 = r1;
        this.$channel = r10;
        this.$configUrl = r11;
        super(1);
    }

    public final void invoke(Response r10) {
        Intrinsics.checkNotNullParameter(r10, "response");
        Job r11 = BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new NativePrefetch$fetchGecko$2$job$1(this, r10, null), 3, null);
        ConcurrentHashMap<String, NativePrefetch> r0 = NativePrefetchUtil.a;
        NativePrefetchUtil.c.postDelayed(new a(r11), 1000);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Response) r1);
        return Unit.INSTANCE;
    }
}
