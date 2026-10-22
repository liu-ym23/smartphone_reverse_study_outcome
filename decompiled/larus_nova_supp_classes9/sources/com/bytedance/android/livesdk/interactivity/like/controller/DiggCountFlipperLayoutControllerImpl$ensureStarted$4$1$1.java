package com.bytedance.android.livesdk.interactivity.like.controller;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "p1", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class DiggCountFlipperLayoutControllerImpl$ensureStarted$4$1$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public DiggCountFlipperLayoutControllerImpl$ensureStarted$4$1$1(u32.d.a r8) {
        super(1, r8, u32.d.a.class, "setContentDescription", "setContentDescription(Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((u32.d.a) ((CallableReference) this).receiver).setContentDescription(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((String) r1);
        return Unit.INSTANCE;
    }
}
