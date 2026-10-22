package com.bytedance.android.live.broadcast.rts;

import com.relax.relaxframework.ElementAttribute;
import com.relax.relaxframework.LinearGravity;
import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.f6;
import com.relax.relaxframework.j5;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcast/rts/AnchorStatusTab;", "item", "", "index", "Lcom/relax/relaxframework/j5;", "invoke", "(Lcom/bytedance/android/live/broadcast/rts/AnchorStatusTab;I)Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
public final class PanelAnchorStatusPanelKt$AnchorStatusPanel$1$5$1$1$3$1$for__0$1 extends Lambda implements Function2<AnchorStatusTab, Integer, j5> {
    final /* synthetic */ PanelAnchorStatusPanelKt$AnchorStatusPanel$1.AnonymousClass5.AnonymousClass1.C00311.AnonymousClass3.C00341 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcast.rts.PanelAnchorStatusPanelKt$AnchorStatusPanel$1$5$1$1$3$1$for__0$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/relax/relaxframework/j5;", "invoke", "()Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<j5> {
        final /* synthetic */ int $index;
        final /* synthetic */ AnchorStatusTab $item;
        final /* synthetic */ PanelAnchorStatusPanelKt$AnchorStatusPanel$1$5$1$1$3$1$for__0$1 this$0;

        public AnonymousClass1(PanelAnchorStatusPanelKt$AnchorStatusPanel$1$5$1$1$3$1$for__0$1 r1, int r2, AnchorStatusTab r3) {
            this.this$0 = r1;
            this.$index = r2;
            this.$item = r3;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m86invoke() {
            return invoke();
        }

        public final j5 invoke() {
            f6 r0 = (f6) RelaxFrameworkKt.C.invoke();
            r0.k0(ElementAttribute.LinearGravity, LinearGravity.Center.getValue());
            r0.g0(new C00351(this));
            r0.R(new AnonymousClass2(this));
            return r0;
        }
    }

    public PanelAnchorStatusPanelKt$AnchorStatusPanel$1$5$1$1$3$1$for__0$1(PanelAnchorStatusPanelKt$AnchorStatusPanel$1.AnonymousClass5.AnonymousClass1.C00311.AnonymousClass3.C00341 r1) {
        this.this$0 = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((AnchorStatusTab) r1, ((Number) r2).intValue());
    }

    public final j5 invoke(AnchorStatusTab r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return (j5) new AnonymousClass1(this, r3, r2).invoke();
    }
}
