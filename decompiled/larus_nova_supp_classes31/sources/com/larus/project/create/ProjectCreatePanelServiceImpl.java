package com.larus.project.create;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.taskskill.service.IProjectCreatePanelService;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ls9.j;
import t19.s;
import tx9.p3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J2\u0010\u0004\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J2\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016JR\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J2\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\fH\u0002J\"\u0010\u001c\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\tH\u0002¨\u0006\u001f"}, d2 = {"Lcom/larus/project/create/ProjectCreatePanelServiceImpl;", "Lcom/larus/bmhome/taskskill/service/IProjectCreatePanelService;", "<init>", "()V", "showPanel", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "enterMethod", "", "callback", "Lcom/larus/bmhome/taskskill/service/IProjectCreatePanelService$Callback;", "", "config", "Lcom/larus/bmhome/taskskill/service/IProjectCreatePanelService$PanelConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observePanelResult", "resultKey", "createProject", "name", "deviceId", "deviceName", "folderName", "workspace", "notifyCreateFailed", CustomFeedPlayerEvent.EXTRA_KEY_REASON, "isBindFolder", "reportCreateProjectResult", "createResult", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProjectCreatePanelServiceImpl implements IProjectCreatePanelService {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b implements IProjectCreatePanelService.a {
        public final /* synthetic */ Fragment a;
        public final /* synthetic */ IProjectCreatePanelService.a b;

        public final void c() {
        }

        public final void a(boolean r2) {
            this.b.a(r2);
        }

        public final void b(com.larus.bmhome.taskskill.service.a r2) {
            Intrinsics.checkNotNullParameter(r2, SlashMentionConfig.SLASH_CONTENT_PROJECT);
            if (this.a.isAdded() == false) goto L6;
            this.b.b(r2);
            return;
        }

        public final void d(boolean r1) {
            if (this.a.isAdded() == false) goto L6;
            this.b.c();
            return;
        }

        public b(Fragment r1, IProjectCreatePanelService.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public ProjectCreatePanelServiceImpl() {
    }

    public static void e(String r6, boolean r7, String r8) {
        if (r6 != null) goto L4;
        return;
    L4:
        if ((!StringsKt.isBlank(r6)) == true) goto L7;
        r6 = null;
    L7:
        String r1 = r6;
        if (r1 == null) goto L13;
        p3.g("chat", r1, r7, r8, null, 16);
        return;
    }

    public final void c(Fragment r8, String r9, IProjectCreatePanelService.a r10) {
        Intrinsics.checkNotNullParameter(r8, "hostFragment");
        Intrinsics.checkNotNullParameter(r10, "callback");
        a(r8, new IProjectCreatePanelService.b("project_create_panel_service_result", false), r8, r9, new b(r8, r10));
    }

    public final boolean a(Fragment r11, IProjectCreatePanelService.b r12, LifecycleOwner r13, String r14, IProjectCreatePanelService.a r15) {
        Intrinsics.checkNotNullParameter(r11, "hostFragment");
        Intrinsics.checkNotNullParameter(r12, "config");
        Intrinsics.checkNotNullParameter(r13, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r15, "callback");
        FragmentManager r0 = r11.getChildFragmentManager();
        if (r0.isStateSaved() == false) goto L7;
        FLogger.a.i("ProjectCreatePanelService", "showPanel skipped stateSaved=" + r0.isStateSaved());
        return false;
    L7:
        if (r0.findFragmentByTag("task_create_project_panel") == null) goto L11;
        FLogger.a.i("ProjectCreatePanelService", "showPanel skipped because panel is already showing");
        return false;
    L11:
        if (StringsKt.isBlank(r12.a) == false) goto L14;
        FLogger.a.w("ProjectCreatePanelService", "showPanel skipped because resultKey is blank");
        return false;
    L14:
        b(r11, r13, r12.a, r14, r15);
        int r16 = CreateProjectPanelFragment.m;
        boolean r17 = r12.b;
        String r18 = r12.a;
        Intrinsics.checkNotNullParameter(r18, "resultKey");
        if ((!StringsKt.isBlank(r18)) == false) goto L35;
        CreateProjectPanelFragment r19 = new CreateProjectPanelFragment();
        Bundle r110 = new Bundle();
        r110.putBoolean("auto_launch_device_picker", r17);
        r110.putString("result_key", r18);
        r19.setArguments(r110);
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L24
        LandscapeRestrictionOperation r112 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Throwable -> L24
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r19, "task_create_project_panel", r112);     // Catch: Throwable -> L24
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r19, r112) == false) goto L39;
    L22:
        Object r113 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L24
    L26:
        Throwable r114 = Result.exceptionOrNull-impl(r113);
        if (r114 == null) goto L29;
        r0.clearFragmentResultListener(r12.a);
        FLogger.a.e("ProjectCreatePanelService", "showPanel transaction failed", r114);
    L29:
        Boolean r115 = Boolean.FALSE;
        if (Result.isFailure-impl(r113) == false) goto L33;
        r113 = r115;
    L33:
        return ((Boolean) r113).booleanValue();
    L39:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36 Throwable -> L24
    L21:
        r19.showNow(r0, "task_create_project_panel");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r113 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L35:
        throw new IllegalArgumentException("resultKey must not be blank".toString());
    }

    public final void b(final Fragment r10, LifecycleOwner r11, final String r12, final String r13, final IProjectCreatePanelService.a r14) {
        Intrinsics.checkNotNullParameter(r10, "hostFragment");
        Intrinsics.checkNotNullParameter(r11, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r12, "resultKey");
        Intrinsics.checkNotNullParameter(r14, "callback");
        if (StringsKt.isBlank(r12) == false) goto L6;
        FLogger.a.w("ProjectCreatePanelService", "observePanelResult skipped because resultKey is blank");
        return;
    L6:
        final FragmentManager r7 = r10.getChildFragmentManager();
        r7.setFragmentResultListener(r12, r11, new j(r7, r12, this, r13, r14, r10));
    }

    public static final void d(ProjectCreatePanelServiceImpl r6, Fragment r7, IProjectCreatePanelService.a r8, String r9, String r10, boolean r11) {
        r6.getClass();
        FLogger.a.e("ProjectCreatePanelService", "createProject failed " + r9);
        e(r10, r11, "fail");
        if (r7.isAdded() == false) goto L5;
        s.j(s.a, r7.getContext(), r7.getString(2131907216), null, false, 28);
    L5:
        r8.d(r11);
    }
}
