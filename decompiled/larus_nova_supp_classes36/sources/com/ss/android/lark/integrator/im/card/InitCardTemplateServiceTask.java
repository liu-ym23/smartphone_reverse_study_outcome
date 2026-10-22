package com.ss.android.lark.integrator.im.card;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import omb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/integrator/im/card/InitCardTemplateServiceTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "<init>", "()V", "execute", "", "context", "Landroid/content/Context;", "getTaskName", "", "Companion", "officesdk-im-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InitCardTemplateServiceTask extends AbstractLaunchTask<InitCardTemplateServiceTask> {

    public static final class a {
    }

    static {
    }

    public final String f() {
        return "InitCardTemplate";
    }

    public InitCardTemplateServiceTask() {
    }

    public final void a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = e.a;
        boolean r1 = false;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("disable.flow.card.render") == true) goto L13;
        IOfficeSDKTokenProvider r2 = OfficeSDKManager.getTokenProvider();
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L13;
        r1 = true;
        goto L13
    L7:
        if (r2.isDoubaoBUser() != true) goto L9;
        r3 = true;
    L13:
        if (r1 == true) goto L16;
        Log.i("InitCardTemplate", "skip init cardTemplate");
        return;
    L16:
        Log.i("InitCardTemplate", "before init cardTemplate");
        omb.a.e(r4.getApplicationContext());
        Log.i("InitCardTemplate", "after init cardTemplate");
    }
}
