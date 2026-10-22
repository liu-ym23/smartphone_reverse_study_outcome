package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import np1.e;
import np1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lnp1/g;", "Lnp1/e;", "invoke", "(Lnp1/g;)Lnp1/e;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class PermissionGrantedItem$ReceiveGiftOpt$provide$1 extends Lambda implements Function1<g, e> {
    final /* synthetic */ PermissionGrantedItem.ReceiveGiftOpt this$0;

    public PermissionGrantedItem$ReceiveGiftOpt$provide$1(PermissionGrantedItem.ReceiveGiftOpt r1) {
        this.this$0 = r1;
        super(1);
    }

    public final e invoke(final g r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        np1.a.C0403a r0 = np1.a.a;
        Function0<e> r1 = new AnonymousClass1(r3);
        Function1<e, Unit> r4 = new AnonymousClass2(this);
        r0.getClass();
        return (e) np1.a.C0403a.a(r1, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((g) r1);
    }
}
