package com.bytedance.android.monitorV2.lynx;

import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class LynxViewMonitor$reportCustom$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxView f3622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x4.c f3623b;

    public LynxViewMonitor$reportCustom$1(LynxView r5, x4.c r10) {
        this.f3622a = r5;
        this.f3623b = r10;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        com.bytedance.android.monitorV2.lynx.impl.d.f3683k.h(this.f3622a, new com.bytedance.android.monitorV2.event.b(this.f3623b));
        return Unit.INSTANCE;
    }
}
