package com.bytedance.android.live.broadcast.rts;

import com.bytedance.rts.foundation.u;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class PanelAnchorStatusPanelKt$AnchorStatusPanel$1$onHybridCardLoadSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0 $actvieTabIndex;
    final /* synthetic */ Ref.BooleanRef $didHybridCardLoadSuccess;
    final /* synthetic */ Function3 $onTabSelected;
    final /* synthetic */ Ref.BooleanRef $panelDataLoaded;
    final /* synthetic */ d $props;
    final /* synthetic */ Function1 $setActiveTabIndex;
    final /* synthetic */ Ref.ObjectRef $switchTabTimer;
    final /* synthetic */ Function0 $tabs;

    public PanelAnchorStatusPanelKt$AnchorStatusPanel$1$onHybridCardLoadSuccess$1(Ref.BooleanRef r1, Ref.BooleanRef r2, d r3, Function0 r4, Ref.ObjectRef r5, Function0 r6, Function1 r7, Function3 r8) {
        this.$didHybridCardLoadSuccess = r1;
        this.$panelDataLoaded = r2;
        this.$props = r3;
        this.$tabs = r4;
        this.$switchTabTimer = r5;
        this.$actvieTabIndex = r6;
        this.$setActiveTabIndex = r7;
        this.$onTabSelected = r8;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m112invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m112invoke() {
        Ref.BooleanRef r0 = this.$didHybridCardLoadSuccess;
        if (r0.element == false) goto L6;
        int r1 = k.a;
        k.a.a("Failed to process onHybridCardLoadSuccess: already succeeded before.");
        return;
    L6:
        r0.element = true;
        int r2 = k.a;
        k.a.b("AnchorStatusHybridCard loaded successfully.");
        this.$panelDataLoaded.element = true;
        String r3 = this.$props.c;
        if (r3 == null) goto L18;
        int r4 = f.a;
        Intrinsics.checkNotNull(r3);
        if (f.a.a(r3) == true) goto L19;
        final Ref.IntRef r5 = new Ref.IntRef();
        r5.element = com.bytedance.rts.foundation.j.c((ArrayList) this.$tabs.invoke(), new PanelAnchorStatusPanelKt$AnchorStatusPanel$1$onHybridCardLoadSuccess$1$index$1(this));
        final String r6 = this.$props.c;
        Intrinsics.checkNotNull(r6);
        if (r5.element >= 0) goto L13;
        k.a.a("Can't find tab for key: " + r6 + ", use index 0");
        r5.element = 0;
    L13:
        k.a.b("Set active tab index: for key: " + r6 + ", index: " + r5.element);
        Object r7 = this.$switchTabTimer.element;
        if (r7 == null) goto L16;
        Intrinsics.checkNotNull(r7);
        u.b(r7);
        this.$switchTabTimer.element = null;
    L16:
        new PanelAnchorStatusPanelKt$AnchorStatusPanel$1$onHybridCardLoadSuccess$1$doSwitchTab$1(this, r5, r6).invoke();
        return;
    L19:
        return;
    }
}
