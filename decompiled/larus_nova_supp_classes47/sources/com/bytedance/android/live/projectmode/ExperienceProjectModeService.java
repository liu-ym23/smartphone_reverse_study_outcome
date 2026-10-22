package com.bytedance.android.live.projectmode;

import android.content.Context;
import com.bytedance.android.livesdk.experience.service.IExperienceProjectModeService;
import com.bytedance.android.livesdk.projectmode.ILiveSdkProjectModeService;
import ip2.a;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/projectmode/ExperienceProjectModeService;", "Lcom/bytedance/android/livesdk/experience/service/IExperienceProjectModeService;", "Landroid/content/Context;", "context", "Lip2/a;", "info", "", "openDSLDialog", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ExperienceProjectModeService implements IExperienceProjectModeService {
    public ExperienceProjectModeService() {
        k.l(IExperienceProjectModeService.class, this);
    }

    public void openDSLDialog(Context r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "info");
        ILiveSdkProjectModeService r0 = k.f(ILiveSdkProjectModeService.class);
        if (r0 == null) goto L6;
        r0.openDSLDialog(r2, r3);
        return;
    }
}
