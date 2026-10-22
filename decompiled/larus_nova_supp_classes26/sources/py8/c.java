package py8;

import android.companion.AssociationInfo;
import android.companion.CompanionDeviceManager;
import android.content.IntentSender;
import com.larus.cdm.impl.FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends CompanionDeviceManager.Callback {
    public final /* synthetic */ a a;

    public c(FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1 r1) {
        this.a = r1;
    }

    @Override // android.companion.CompanionDeviceManager.Callback
    public final void onAssociationCreated(AssociationInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "associationInfo");
        this.a.c(r2);
    }

    @Override // android.companion.CompanionDeviceManager.Callback
    public final void onAssociationPending(IntentSender r2) {
        Intrinsics.checkNotNullParameter(r2, "intentSender");
        this.a.b(r2);
    }

    @Override // android.companion.CompanionDeviceManager.Callback
    public final void onDeviceFound(IntentSender r2) {
        Intrinsics.checkNotNullParameter(r2, "intentSender");
        this.a.b(r2);
    }

    @Override // android.companion.CompanionDeviceManager.Callback
    public final void onFailure(CharSequence r2) {
        this.a.a(r2);
    }
}
