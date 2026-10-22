package com.bytedance.android.live.profit.redpacket;

import android.content.Context;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lwy0/e;", "it", "", "invoke", "(Lwy0/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RedPacketHybridService$hybridCardBindBridge$1 extends Lambda implements Function1<wy0.e, Unit> {
    final /* synthetic */ boolean $bindClose;
    final /* synthetic */ Context $context;
    final /* synthetic */ RedPacketHybridService this$0;

    public static final class a extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Unit> {
        public final /* synthetic */ RedPacketHybridService$hybridCardBindBridge$1 a;

        public a(RedPacketHybridService$hybridCardBindBridge$1 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2, CallContext r3) {
            Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a.this$0.c().dismissAllowingStateLoss();     // Catch: Exception -> L5
        L10:
            return Unit.INSTANCE;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L10;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L10
        }
    }

    public RedPacketHybridService$hybridCardBindBridge$1(RedPacketHybridService r1, Context r2, boolean r3) {
        this.this$0 = r1;
        this.$context = r2;
        this.$bindClose = r3;
        super(1);
    }

    public final void invoke(wy0.e r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r3.registerMethod("redEnvelopeUpdate", new AnonymousClass1(this));
        if (this.$bindClose == false) goto L6;
        r3.registerMethod("close", new a(this));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((wy0.e) r1);
        return Unit.INSTANCE;
    }
}
