package com.larus.drive.sdk.impl.utils.file;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.drive.sdk.api.file.download.DriveDownloadStatus;
import com.larus.drive.sdk.impl.view.operation.download.DriveDownloadDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveDownloadManager {
    public static final CoroutineScope a = null;
    public static String b;
    public static int c;
    public static boolean d;
    public static WeakReference<FragmentActivity> e;
    public static WeakReference<DriveDownloadDialog> f;

    public DriveDownloadManager() {
    }

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }

    public static final void a() {
        WeakReference<FragmentActivity> r0 = e;
        DriveDownloadDialog r1 = null;
        if (r0 == null) goto L6;
        FragmentActivity r2 = r0.get();
        if (r2 == null) goto L6;
    L13:
        if (r2.getSupportFragmentManager().isStateSaved() == true) goto L33;
        Fragment r3 = r2.getSupportFragmentManager().findFragmentByTag("DriveDownloadManager");
        if ((r3 instanceof DriveDownloadDialog) == false) goto L18;
        r1 = (DriveDownloadDialog) r3;
    L18:
        if (r1 != null) goto L24;
        r1 = new DriveDownloadDialog();
        FragmentManager r4 = r2.getSupportFragmentManager();
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, "DriveDownloadManager", r5);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r1, r5) == true) goto L24;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L23:
        r1.show(r4, "DriveDownloadManager");
    L24:
        Intrinsics.checkNotNullParameter(r1, "dialog");
        f = new WeakReference(r1);
        if (d == false) goto L31;
        r1.T90(c);
        return;
    L31:
        return;
    L33:
        return;
    L6:
        FragmentActivity r6 = AppHost.a.a().getCurrentActivity();
        if ((r6 instanceof FragmentActivity) == false) goto L9;
        r2 = r6;
    L10:
        if (r2 != null) goto L13;
        return;
    L9:
        r2 = null;
        goto L10
    }

    public static void b(FragmentActivity r7, String r8) {
        if (r7 == null) goto L5;
        e = new WeakReference(r7);
    L5:
        BuildersKt.launch$default(a, null, null, new DriveDownloadManager$onDownloadFailed$1(r8, null), 3, null);
    }

    public static void c(FragmentActivity r12, String r13, DriveDownloadStatus r14, long r15, long r17) {
        Intrinsics.checkNotNullParameter(r14, "status");
        if (r12 == null) goto L6;
        e = new WeakReference(r12);
    L6:
        BuildersKt.launch$default(a, null, null, new DriveDownloadManager$onDownloadProgress$1(r13, r14, r17, r15, null), 3, null);
    }
}
