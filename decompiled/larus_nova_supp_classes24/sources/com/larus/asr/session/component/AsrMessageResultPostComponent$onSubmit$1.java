package com.larus.asr.session.component;

import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class AsrMessageResultPostComponent$onSubmit$1 extends FunctionReferenceImpl implements Function2<String, Boolean, Boolean> {
    public AsrMessageResultPostComponent$onSubmit$1(Object r8) {
        super(2, r8, AsrMessageResultPostComponent.class, "onNetworkUnavailable", "onNetworkUnavailable(Ljava/lang/String;Z)Z", 0);
    }

    public final Boolean invoke(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, IP0SubProcess.P0_PROCESS_NAME);
        AsrMessageResultPostComponent r0 = (AsrMessageResultPostComponent) ((CallableReference) this).receiver;
        Function2<? super String, ? super Boolean, Unit> r1 = r0.m;
        if (r1 == null) goto L6;
        r1.invoke(r4, Boolean.valueOf(r5));
    L6:
        return Boolean.valueOf(((Boolean) r0.k.invoke(new com.larus.audio.a(r4, r5))).booleanValue());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, ((Boolean) r2).booleanValue());
    }
}
