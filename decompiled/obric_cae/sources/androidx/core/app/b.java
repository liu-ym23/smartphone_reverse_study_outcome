package androidx.core.app;

import com.obric.cae.smartNfc.CaeNfcEventManagerService;
import com.obric.cae.smartNfc.SmartNfcManager;
import com.obric.cae.userAware.SubwayFusionAware.SubwayEventProcessor;
import com.obric.cae.userAware.SubwayFusionAware.SubwayFusionAware;
import com.obric.cae.userAware.ui.PermissionsCheckFragment;
import com.obric.cae.userAware.ui.UserAwareLauncherActivity;
import com.obric.oui.checkbox.OCheckBox;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements k0.d, CaeNfcEventManagerService.NfcStateListener, SubwayEventProcessor.EventProcessorListener, androidx.activity.result.a, OCheckBox.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1588a;

    public /* synthetic */ b(Object r8) {
        this.f1588a = r8;
    }

    @Override // androidx.activity.result.a
    public void a(Object r8) {
        PermissionsCheckFragment.c((PermissionsCheckFragment) this.f1588a, (Map) r8);
    }

    @Override // com.obric.oui.checkbox.OCheckBox.a
    public void b(OCheckBox r8, boolean r10) {
        UserAwareLauncherActivity.g((UserAwareLauncherActivity) this.f1588a, r8, r10);
    }

    @Override // com.obric.cae.userAware.SubwayFusionAware.SubwayEventProcessor.EventProcessorListener
    public void onIndoorCheckNeeded() {
        SubwayFusionAware.a((SubwayFusionAware) this.f1588a);
    }

    @Override // com.obric.cae.smartNfc.CaeNfcEventManagerService.NfcStateListener
    public void onNfcStateChanged(int r8) {
        SmartNfcManager.a((SmartNfcManager) this.f1588a, r8);
    }
}
