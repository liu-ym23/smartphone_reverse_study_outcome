package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import com.bytedance.android.livesdk.chatroom.multitask.LiveInnerIndependentManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import np1.f;
import np1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lnp1/g;", "Lnp1/a;", "invoke", "(Lnp1/g;)Lnp1/a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class SmallWindowItem$LiveIndependentTaskWindowOpt$provide$1 extends Lambda implements Function1<g, np1.a> {
    public static final SmallWindowItem$LiveIndependentTaskWindowOpt$provide$1 INSTANCE = null;

    static {
        INSTANCE = new SmallWindowItem$LiveIndependentTaskWindowOpt$provide$1();
    }

    public SmallWindowItem$LiveIndependentTaskWindowOpt$provide$1() {
        super(1);
    }

    public final np1.a invoke(final g r4) {
        Intrinsics.checkNotNullParameter(r4, "$receiver");
        int r0 = SmallWindowItem.c.a;
        Intrinsics.checkNotNullParameter(r4.j, "panelContext");
        boolean r1 = LiveInnerIndependentManager.a;
        if (LiveInnerIndependentManager.b() == true) goto L5;
        return null;
    L5:
        np1.a.C0403a r2 = np1.a.a;
        Function0<f> r3 = new AnonymousClass1(r4);
        Function1<f, Unit> r5 = new AnonymousClass2(r4);
        r2.getClass();
        return np1.a.C0403a.a(r3, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((g) r1);
    }
}
