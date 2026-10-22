package com.larus.asr;

import b68.b;
import com.larksuite.component.blockit.sub_process.IP0SubProcess;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public /* synthetic */ class KmpAsrSessionAdapter$removeRetryAudioFileIfNeeded$1$result$1 extends FunctionReferenceImpl implements Function1<String, Boolean> {
    public KmpAsrSessionAdapter$removeRetryAudioFileIfNeeded$1$result$1(Object r8) {
        super(1, r8, b.class, "deleteFile", "deleteFile(Ljava/lang/String;)Z", 0);
    }

    public final Boolean invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, IP0SubProcess.P0_PROCESS_NAME);
        return Boolean.valueOf(((b) ((CallableReference) this).receiver).a(r2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
