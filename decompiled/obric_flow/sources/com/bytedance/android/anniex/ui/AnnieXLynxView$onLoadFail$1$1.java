package com.bytedance.android.anniex.ui;

import com.bytedance.android.anniex.lite.container.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXLynxView$onLoadFail$1$1 extends Lambda implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f3484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3485b;

    public AnnieXLynxView$onLoadFail$1$1(h r5, AnnieXLynxView r10, String r11, int r12) {
        this.f3484a = r5;
        this.f3485b = r11;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        h r5 = this.f3484a;
        if (r5 == null) goto L6;
        String r10 = this.f3485b;
        String r11 = r5.f3249a.e;
        Throwable r12 = new Throwable(r10);
        r5.f3250b.g(r11, r5.f3251c, r12);
    L6:
        return Unit.INSTANCE;
    }
}
