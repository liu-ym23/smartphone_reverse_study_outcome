package aca;

import com.larus.platform.api.g1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.permission.IObricPermissionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w implements g1.c {
    public final /* synthetic */ v a;
    public final /* synthetic */ List<String> b;
    public final /* synthetic */ Ref.ObjectRef<v.c> c;
    public final /* synthetic */ Function1<v.c, Unit> d;

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
        IObricPermissionService r0 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r0 == null) goto L5;
        IObricPermissionService.Companion.ObricPermissionStatus r1 = r0.h();
    L7:
        if (r1 == IObricPermissionService.Companion.ObricPermissionStatus.DENIED) goto L9;
        boolean r2 = true;
    L10:
        FLogger.a.i("UserSelectBlockHolder", "request album permission onSettingPageReturn, isAlbumPermissionGranted: " + r2);
        Function1<v.c, Unit> r3 = this.d;
        v r4 = this.a;
        List<String> r5 = this.b;
        r4.getClass();
        r3.invoke(v.o(r2, r5, false));
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public final void onGoSettingsDialogDismiss(boolean r4) {
        FLogger.a.i("UserSelectBlockHolder", "request album permission onGoSettingsDialogDismiss, isConfirmed: " + r4);
        if (r4 == true) goto L9;
        Function1<v.c, Unit> r5 = this.d;
        v.c r0 = (v.c) this.c.element;
        if (r0 != null) goto L7;
        v r1 = this.a;
        List<String> r2 = this.b;
        r1.getClass();
        r0 = v.o(false, r2, true);
    L7:
        r5.invoke(r0);
        return;
    }

    public w(v r1, List r2, Ref.ObjectRef r3, f r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void onResult(boolean r6, List<String> r7, List<String> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "grantedList");
        Intrinsics.checkNotNullParameter(r8, "deniedList");
        boolean r1 = true;
        if (r6 == false) goto L5;
    L8:
        FLogger.a.i("UserSelectBlockHolder", "request album permission result, allGranted: " + r6 + ", grantedList: " + r7.size() + ", deniedList: " + r8.size() + ", isGoSettingsDialogShown: " + r9);
        v r10 = this.a;
        List<String> r11 = this.b;
        r10.getClass();
        v.c r12 = v.o(r1, r11, false);
        this.c.element = r12;
        if (r9 == true) goto L12;
        this.d.invoke(r12);
        return;
    L12:
        return;
    L5:
        if ((!r7.isEmpty()) == true) goto L8;
        r1 = false;
        goto L8
    }
}
