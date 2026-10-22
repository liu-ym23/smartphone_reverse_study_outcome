package com.obric.assistant.privacy;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.home.api.privacy.ICustomPrivacyService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/privacy/ObricPrivacyDowngradeService;", "Lcom/larus/home/api/privacy/ICustomPrivacyService;", "<init>", "()V", "getCustomPrivacyDialog", "Landroidx/fragment/app/DialogFragment;", "context", "Landroid/content/Context;", "agree", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "disagree", "Lcom/larus/common_ui/dialog/CancelClickListener;", "getCustomPrivacyActivityClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPrivacyDowngradeService implements ICustomPrivacyService {
    public ObricPrivacyDowngradeService() {
    }

    public final Class<? extends Activity> b() {
        return null;
    }

    public final DialogFragment d(Context r2, p0 r3, u r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "agree");
        Intrinsics.checkNotNullParameter(r4, "disagree");
        return null;
    }
}
