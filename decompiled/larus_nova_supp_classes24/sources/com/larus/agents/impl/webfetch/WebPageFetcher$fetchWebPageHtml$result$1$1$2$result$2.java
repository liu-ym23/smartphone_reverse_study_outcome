package com.larus.agents.impl.webfetch;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    final /* synthetic */ String $logCommandId;
    final /* synthetic */ long $startedAtNanos;

    public WebPageFetcher$fetchWebPageHtml$result$1$1$2$result$2(String r7, long r8) {
        this.$logCommandId = r7;
        this.$startedAtNanos = r8;
        super(1, Intrinsics.Kotlin.class, "log", "fetchWebPageHtml$log(Ljava/lang/String;JLjava/lang/String;)V", 0);
    }

    public final void invoke(String r4) {
        Intrinsics.checkNotNullParameter(r4, IP0SubProcess.P0_PROCESS_NAME);
        WebPageFetcher.d(this.$logCommandId, this.$startedAtNanos, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
