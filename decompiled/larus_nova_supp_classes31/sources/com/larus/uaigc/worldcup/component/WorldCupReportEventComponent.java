package com.larus.uaigc.worldcup.component;

import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.uaigc.lynx.pocket.ClickPocketInfo;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/worldcup/component/WorldCupReportEventComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/uaigc/worldcup/ability/WorldCupReportAbility;", "<init>", "()V", "argumentData", "Lcom/larus/uaigc/worldcup/component/WorldCupArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/worldcup/component/WorldCupArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "onAttach", "", "onCreate", "onAlbumClickPocketInfoChange", "pocketInfo", "Lcom/larus/uaigc/lynx/pocket/ClickPocketInfo;", "onDestroy", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class WorldCupReportEventComponent extends BaseContentWidget implements c0a.a {
    public final Lazy m;

    public static final class a implements Function0<com.larus.uaigc.worldcup.component.a> {
        public final /* synthetic */ AttachReceiver a;

        public a(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(com.larus.uaigc.worldcup.component.a.class));
        }
    }

    public final void onDestroy() {
        IAIChatRenderTraceService.a.l();
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, c0a.a.class);
    }

    public WorldCupReportEventComponent() {
        this.m = LazyKt.lazy(new a(this));
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        IAIChatRenderTraceService.Companion r0 = IAIChatRenderTraceService.a;
        Pair[] r1 = new Pair[5];
        r1[0] = TuplesKt.to("key_current_page", "world_cup_2026");
        r1[1] = TuplesKt.to("key_click_from", "world_cup_2026");
        com.larus.uaigc.worldcup.component.a r2 = (com.larus.uaigc.worldcup.component.a) this.m.getValue();
        String r4 = null;
        if (r2 == null) goto L5;
        String r3 = r2.b();
    L6:
        r1[2] = TuplesKt.to("key_enter_method", r3);
        com.larus.uaigc.worldcup.component.a r5 = (com.larus.uaigc.worldcup.component.a) this.m.getValue();
        if (r5 == null) goto L9;
        r4 = r5.a();
    L9:
        r1[3] = TuplesKt.to("key_action_bar_key", r4);
        r1[4] = TuplesKt.to("key_enter_method", "world_cup_2026");
        r0.h(MapsKt.mapOf(r1));
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // c0a.a
    public final void O2(ClickPocketInfo r3) {
        if (r3 == null) goto L5;
        IAIChatRenderTraceService.a.h(MapsKt.mapOf(TuplesKt.to("key_has_album_pocket", "1")));
        return;
    L5:
        IAIChatRenderTraceService.a.h(MapsKt.mapOf(TuplesKt.to("key_has_album_pocket", "0")));
    }
}
