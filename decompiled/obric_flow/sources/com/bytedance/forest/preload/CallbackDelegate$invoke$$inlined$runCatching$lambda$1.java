package com.bytedance.forest.preload;

import com.bytedance.forest.model.w;
import com.facebook.common.references.CloseableReference;
import com.lynx.tasm.ui.image.f0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/forest/preload/CallbackDelegate$invoke$1$1"}, k = 3, mv = {1, 1, 16})
final class CallbackDelegate$invoke$$inlined$runCatching$lambda$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f4556a;

    public CallbackDelegate$invoke$$inlined$runCatching$lambda$1(c r5) {
        this.f4556a = r5;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        StringBuilder r5 = new StringBuilder("image preload finished, image:");
        w r10 = this.f4556a.f4566a;
        if (r10 == null) goto L5;
        CloseableReference r11 = r10.h();
    L6:
        r5.append(r11);
        f0.h("PreLoader", 60, r5.toString(), false);
        return Unit.INSTANCE;
    L5:
        r11 = null;
        goto L6
    }
}
