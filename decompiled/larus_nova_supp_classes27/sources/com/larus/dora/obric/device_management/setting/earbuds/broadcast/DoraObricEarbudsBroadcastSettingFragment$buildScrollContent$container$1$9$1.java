package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.noti_v3.social_message.model.MessageModeSheetSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$9$1 extends FunctionReferenceImpl implements Function0<Unit> {
    public DoraObricEarbudsBroadcastSettingFragment$buildScrollContent$container$1$9$1(Object r8) {
        super(0, r8, DoraObricEarbudsBroadcastSettingFragment.class, "openFrequencySheet", "openFrequencySheet()V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m264invoke() {
        DoraObricEarbudsBroadcastSettingFragment r0 = (DoraObricEarbudsBroadcastSettingFragment) ((CallableReference) this).receiver;
        int r1 = DoraObricEarbudsBroadcastSettingFragment.F;
        q59.a r2 = ((com.larus.dora.impl.noti_v3.overview.viewmodel.b) r0.ea0().getUiState$impl_mainlandRelease().getValue()).h;
        if (r2 == null) goto L6;
        String r3 = r2.b;
        if (r3 == null) goto L6;
    L7:
        int r4 = r3.hashCode();
        String r5 = "3";
        if (r4 == 48) goto L24;
        if (r4 == 51) goto L21;
        if (r4 != 1567) goto L14;
        r3.equals("10");
    L25:
        r5 = "10";
    L26:
        int r6 = DoraObricEarbudsMessageModeSheet.f;
        DoraObricEarbudsBroadcastSettingFragment.W90(DoraObricEarbudsMessageModeSheet.a.a(MessageModeSheetSource.RHYTHM, r5), r0.getParentFragmentManager());
        return;
    L14:
        if (r4 != 1629) goto L25;
        r5 = "30";
        if (r3.equals("30") == true) goto L26;
    L21:
        if (r3.equals("3") == true) goto L26;
    L24:
        if (r3.equals("0") == true) goto L26;
    L6:
        r3 = String.valueOf(((Number) DoraUserSettingsManager.i.getValue()).intValue());
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m264invoke();
        return Unit.INSTANCE;
    }
}
