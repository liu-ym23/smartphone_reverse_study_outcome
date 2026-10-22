package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lnp1/g;", "", "invoke", "(Lnp1/g;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class DegradeItem$provide$2 extends Lambda implements Function1<np1.g, Unit> {
    final /* synthetic */ np1.c $panelContext;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.experencepanel.DegradeItem$provide$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lnp1/f;", "", "invoke", "(Lnp1/f;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function1<np1.f, Unit> {
        final /* synthetic */ np1.g $this_create;
        final /* synthetic */ DegradeItem$provide$2 this$0;

        public AnonymousClass2(DegradeItem$provide$2 r1, np1.g r2) {
            this.this$0 = r1;
            this.$this_create = r2;
            super(1);
        }

        public final void invoke(final np1.f r3) {
            Intrinsics.checkNotNullParameter(r3, "$receiver");
            this.$this_create.a(new AnonymousClass1(this, r3));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((np1.f) r1);
            return Unit.INSTANCE;
        }
    }

    public DegradeItem$provide$2(np1.c r1) {
        this.$panelContext = r1;
        super(1);
    }

    public final void invoke(np1.g r5) {
        Intrinsics.checkNotNullParameter(r5, "$receiver");
        List<np1.a> r0 = r5.d;
        np1.a.C0403a r1 = np1.a.a;
        Function0<np1.f> r2 = new AnonymousClass1(this);
        AnonymousClass2 r3 = new AnonymousClass2(this, r5);
        r1.getClass();
        ArrayList r4 = (ArrayList) r0;
        r4.add(np1.a.C0403a.a(r2, r3));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((np1.g) r1);
        return Unit.INSTANCE;
    }
}
