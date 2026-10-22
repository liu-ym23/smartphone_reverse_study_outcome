package cub;

import android.app.Application;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponentManager;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.dwarf.UserScope;
import dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class a implements ComponentLifecycleAware {
    public final OfficeSDKUserComponentManager a;
    public final String b;

    /* JADX INFO: renamed from: cub.a$a, reason: collision with other inner class name */
    public static final class C0132a {
    }

    static {
    }

    public final void onComponentCreate() {
        Log.i("OfficeSDKUserLifecycle", "onComponentCreate: creating OfficeSDKUserComponent, userId: " + this.b);
        OfficeSDKUserComponent r0 = this.a.generatedComponent();
        if (r0 == null) goto L6;
        OfficeSDKManager.registerOfficeSDKUserComponent(this.b, r0);
        Log.i("OfficeSDKUserLifecycle", "onComponentCreate: OfficeSDKUserComponent created and registered to OfficeSDKManager");
        OfficeSDKManager.notifyOfficeSDKUserComponentReady$officesdk_core_release(this.b, r0);
        return;
    }

    public final void onComponentDestroy() {
        Log.i("OfficeSDKUserLifecycle", "onComponentDestroy: clearing OfficeSDKUserComponent, userId: " + this.b);
        OfficeSDKUserComponent r0 = this.a.findComponent();
        if (r0 == null) goto L6;
        OfficeSDKManager.unregisterOfficeSDKUserComponent(this.b, r0);
        return;
    }

    @Inject
    public a(Application r2, OfficeSDKUserComponentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "application");
        Intrinsics.checkNotNullParameter(r3, "officeSDKUserComponentManager");
        Intrinsics.checkNotNullParameter(r4, "userId");
        this.a = r3;
        this.b = r4;
    }
}
