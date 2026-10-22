package com.obric.flow.cardlistpage.ui.component.feedlist;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
final /* synthetic */ class FeedListComponent$renderInvalidationListener$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    public FeedListComponent$renderInvalidationListener$1(Object r10) {
        super(2, r10, s.class, "requestRebindMiniAppWidget", "requestRebindMiniAppWidget(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Unit mo2invoke(String r5, String r10) {
        invoke2(r5, r10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        Intrinsics.checkNotNullParameter(r10, "p1");
        s r11 = (s) this.receiver;
        r11.getClass();
        androidx.room.f r12 = new androidx.room.f(r11, 3, r5, r10);
        r11.e.post(r12);
    }
}
