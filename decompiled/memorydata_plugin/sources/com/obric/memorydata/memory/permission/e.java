package com.obric.memorydata.memory.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.os.Process;
import com.bytedance.crash.constants.Constants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.island.IslandRouter;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fJ,\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/permission/PermissionSettingsLauncher;", "", "<init>", "()V", "TAG", "", Constants.LAUNCH_TAG, "", "activity", "Landroid/app/Activity;", "permissionGroup", "requestCode", "", "buildCandidates", "", "Lkotlin/Pair;", "Landroid/content/Intent;", "ctx", "Landroid/content/Context;", "tryStart", MemorySourceLinkType.INTENT, "desc", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10347a = null;

    static {
        f10347a = new e();
    }

    private e() {
    }

    private final List<Pair<Intent, String>> a(Context r7, String r8) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        List<Pair<Intent, String>> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r10 = r6.getPackageName();
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == false) goto L14;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin");
        Intent r4 = new Intent("android.intent.action.MANAGE_APP_PERMISSION");
        r4.putExtra("android.intent.extra.PACKAGE_NAME", r10);
        r4.putExtra("android.intent.extra.PERMISSION_GROUP_NAME", r8);
        r4.putExtra("android.intent.extra.USER", (Parcelable) ZeusTransformUtils.preCheckCast(Process.myUserHandle(), Parcelable.class, "com.obric.memorydata.plugin"));
        r3.add(TuplesKt.to(r4, "ObricOS MANAGE_APP_PERMISSION"));
    L16:
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin");
        Intent r5 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r5.setData(Uri.fromParts("package", r10, null));
        r11.add(TuplesKt.to(r5, "App details"));
        ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).add(TuplesKt.to(new Intent("android.settings.APPLICATION_SETTINGS"), "Application settings"));
        ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).add(TuplesKt.to(new Intent("android.settings.SETTINGS"), "Generic settings"));
        return r9;
    L7:
        if (r1.length() == 0) goto L10;
        r2 = false;
    L14:
        if (IslandRouter.f10185a.a() != IslandRouter.IslandImpl.GR_GR) goto L16;
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin");
        Intent r13 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        r13.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        r13.putExtra("extra_pkgname", r10);
        r12.add(TuplesKt.to(r13, "MIUI PermissionsEditorActivity"));
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin");
        Intent r15 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        r15.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        r15.putExtra("extra_pkgname", r10);
        r14.add(TuplesKt.to(r15, "MIUI AppPermissionsEditorActivity"));
        goto L16
    }

    private final boolean a(Activity r10, Intent r11, String r12, int r13) {
        Activity r14 = (Activity) ZeusTransformUtils.wrapperContextForParams(r10, Activity.class, "com.obric.memorydata.plugin");
    L20:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PermissionSettingsLauncher", "tryStart: " + r12 + " failed: " + e.getMessage(), null, 4, null);
        return false;
    L4:
        if (r14.getPackageManager().resolveActivity(r11, 0) == null) goto L6;
        boolean r3 = true;
    L8:
        if (r11.getComponent() == null) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L15;
        if (r3 == true) goto L15;
        RunLog.INSTANCE.debug("PermissionSettingsLauncher", "tryStart: " + r12 + " not resolvable, skip");     // Catch: Exception -> L20
        return false;
    L15:
        if (r13 < 0) goto L17;
        ZeusTransformUtils.startActivityForResult(r14, r11, r13, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PermissionSettingsLauncher", "tryStart: launched " + r12, false, 4, null);     // Catch: Exception -> L20
        return true;
    L17:
        ZeusTransformUtils.startActivity(r14, r11, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
        goto L18
    L10:
        r4 = false;
        goto L11
    L6:
        r3 = false;
        goto L8
    }

    public final boolean a(Activity r7, String r8, int r9) {
        Activity r10 = (Activity) ZeusTransformUtils.wrapperContextForParams(r7, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "activity");
        Iterator<Pair<Intent, String>> r11 = a((Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.memorydata.plugin"), r8).iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(r11.next(), Pair.class, "com.obric.memorydata.plugin");
        if (a(r10, (Intent) ZeusTransformUtils.preCheckCast(r0.component1(), Intent.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.component2(), String.class, "com.obric.memorydata.plugin"), r9) == false) goto L4;
        return true;
    L9:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PermissionSettingsLauncher", "launch: all candidates failed", null, 4, null);
        return false;
    }
}
