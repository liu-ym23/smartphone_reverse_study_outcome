package com.obric.memorydata.memory.permission;

import android.app.Activity;
import android.content.Context;
import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.larus.dialog.LarusCommonDialog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/permission/PermissionRequester;", "", "<init>", "()V", "TAG", "", "goPermissionSettings", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "deniedList", "", "callback", "Lcom/obric/memorydata/memory/permission/IRequestPermissionCallback;", "showGoToSetDialog", "gotoSetting", "Lkotlin/Function0;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10344a = null;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/memory/permission/PermissionRequester$showGoToSetDialog$1$1", "Lcom/dialog/ConfirmClickListener;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM, "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f10345a;

        a(Function0<Unit> r3) {
            this.f10345a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        }

        @Override // com.d.b
        public void a() {
            this.f10345a.invoke();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/memory/permission/PermissionRequester$showGoToSetDialog$1$2", "Lcom/dialog/CancelClickListener;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.memory.permission.a f10346a;

        b(com.obric.memorydata.memory.permission.a r3) {
            this.f10346a = (com.obric.memorydata.memory.permission.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.memory.permission.a.class, "com.obric.memorydata.plugin");
        }

        @Override // com.d.a
        public void a() {
            com.obric.memorydata.memory.permission.a r0 = this.f10346a;
            if (r0 == null) goto L6;
            r0.c();
            return;
        }
    }

    static {
        f10344a = new d();
    }

    private d() {
    }

    private static final Unit a(com.obric.memorydata.memory.permission.a r6, List r7, FragmentActivity r8) {
        com.obric.memorydata.memory.permission.a r9 = (com.obric.memorydata.memory.permission.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.memorydata.memory.permission.a.class, "com.obric.memorydata.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        FragmentActivity r11 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r8, FragmentActivity.class, "com.obric.memorydata.plugin");
        String r0 = null;
        if (r9 == null) goto L9;
        r0 = r9.b(r10);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        RunLog.INSTANCE.error("PermissionRequester", "getGoSettingPagePermissionParams error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L9:
        if (e.f10347a.a((Activity) ZeusTransformUtils.preCheckCast(r11, Activity.class, "com.obric.memorydata.plugin"), r0, -1) == false) goto L12;
        if (r9 == null) goto L15;
        r9.a(r10);
    L15:
        return Unit.INSTANCE;
    L12:
        if (r9 == null) goto L15;
        r9.c();
        goto L15
    }

    private final void a(FragmentActivity r20, com.obric.memorydata.memory.permission.a r21, Function0<Unit> r22) {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r20, FragmentActivity.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.memory.permission.a r2 = (com.obric.memorydata.memory.permission.a) ZeusTransformUtils.wrapperContextForParams(r21, com.obric.memorydata.memory.permission.a.class, "com.obric.memorydata.plugin");
        Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r22, Function0.class, "com.obric.memorydata.plugin");
        FragmentManager r4 = r0.getSupportFragmentManager();
        LarusCommonDialog.a r5 = new LarusCommonDialog.a();
        String r6 = "";
        if (r2 == null) goto L6;
        String r7 = r2.a();
        if (r7 == null) goto L6;
    L7:
        LarusCommonDialog.a r8 = r5.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r2 == null) goto L13;
        String r9 = r2.b();
        if (r9 == null) goto L13;
        r6 = r9;
    L13:
        LarusCommonDialog.a.a(r8.b((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).a(GravityCompat.START).a(new com.obric.memorydata.ui.larus.dialog.a(null, Integer.valueOf(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.larus_primary_50, TypedValues.Custom.S_COLOR, "larus_primary_50"))), null, 5, null)), (com.d.b) ZeusTransformUtils.preCheckCast(new a(r3), com.d.b.class, "com.obric.memorydata.plugin"), r0.getString(ZeusTransformUtils.mapRes(R.string.obric_memory_go_to_set, TypedValues.Custom.S_STRING, "obric_memory_go_to_set")), false, 4, null).a((com.d.a) ZeusTransformUtils.preCheckCast(new b(r2), com.d.a.class, "com.obric.memorydata.plugin"), r0.getString(ZeusTransformUtils.mapRes(R.string.obric_memory_dialog_cancel, TypedValues.Custom.S_STRING, "obric_memory_dialog_cancel"))).a(false).a().show(r4, null);
        return;
    L6:
        r7 = "";
        goto L7
    }

    /* JADX INFO: renamed from: lambda$UXCXaJW4pU2199dyn8rL-pUf2Wc, reason: not valid java name */
    public static /* synthetic */ Unit m743lambda$UXCXaJW4pU2199dyn8rLpUf2Wc(com.obric.memorydata.memory.permission.a r0, List r1, FragmentActivity r2) {
        return a(r0, r1, r2);
    }

    public final void a(FragmentActivity r3, List<String> r4, com.obric.memorydata.memory.permission.a r5) {
        final FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
        final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        final com.obric.memorydata.memory.permission.a r8 = (com.obric.memorydata.memory.permission.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.memory.permission.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "deniedList");
        a(r6, r8, new $$Lambda$d$UXCXaJW4pU2199dyn8rLpUf2Wc(r8, r7, r6));
    }
}
