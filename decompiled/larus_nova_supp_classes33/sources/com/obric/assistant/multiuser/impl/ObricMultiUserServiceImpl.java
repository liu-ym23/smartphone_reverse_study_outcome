package com.obric.assistant.multiuser.impl;

import android.os.Build;
import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.multiuser.api.IObricMultiUserService;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/multiuser/impl/ObricMultiUserServiceImpl;", "Lcom/obric/assistant/multiuser/api/IObricMultiUserService;", "<init>", "()V", "userManager", "Landroid/os/UserManager;", "getUserManager", "()Landroid/os/UserManager;", "isMainUser", "", "myUserId", "", "myUserHandle", "Landroid/os/UserHandle;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMultiUserServiceImpl implements IObricMultiUserService {

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.multiuser.api.IObricMultiUserService
    public final boolean a() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 23) goto L5;
        UserManager r2 = (UserManager) ContextCompat.getSystemService(AppHost.a.getApplication(), UserManager.class);
    L9:
        boolean r3 = true;
        if (r0 < 23) goto L13;
        if (r2 == null) goto L13;
        r3 = r2.isSystemUser();
    L13:
        FLogger.a.i("ObricMultiUserServiceImpl", "isMainUser? " + r3 + "  userManager? " + r2);
        return r3;
    L5:
        Object r4 = AppHost.a.getApplication().getSystemService("user");
        if ((r4 instanceof UserManager) == false) goto L8;
        r2 = (UserManager) r4;
        goto L9
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.obric.assistant.multiuser.api.IObricMultiUserService
    public final int c() {
        Method r0 = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        Object r1 = r0.invoke(null, new Object[0]);     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L4
        int r2 = ((Integer) r1).intValue();     // Catch: Exception -> L4
    L5:
        FLogger.a.i("ObricMultiUserServiceImpl", "myUserId? " + r2);
        return r2;
    L4:
        r2 = Process.myUid() / 100000;
        goto L5
    }

    public ObricMultiUserServiceImpl() {
        FLogger.a.i("ObricMultiUserServiceImpl", "init...");
    }

    @Override // com.obric.assistant.multiuser.api.IObricMultiUserService
    public final UserHandle b() {
        UserHandle r0 = Process.myUserHandle();
        FLogger.a.i("ObricMultiUserServiceImpl", "myUserHandle? " + r0);
        Intrinsics.checkNotNull(r0);
        return r0;
    }
}
