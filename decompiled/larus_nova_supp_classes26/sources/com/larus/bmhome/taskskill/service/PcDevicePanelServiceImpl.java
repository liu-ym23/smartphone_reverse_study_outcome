package com.larus.bmhome.taskskill.service;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.taskskill.ui.PcAddComputerGuideFragment;
import com.larus.bmhome.taskskill.ui.PcDevicePanelFragment;
import com.larus.folder.FolderFragment;
import com.larus.project.create.CreateProjectPanelFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J2\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/taskskill/service/PcDevicePanelServiceImpl;", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService;", "<init>", "()V", "showPanel", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "selectedPcDeviceId", "", "config", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$PanelConfig;", "callback", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$Callback;", "showFolderPanel", "pcDeviceId", "currentPage", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$FolderPanelConfig;", "Lcom/larus/bmhome/taskskill/service/IPcDevicePanelService$FolderCallback;", "showAddComputerGuide", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PcDevicePanelServiceImpl implements IPcDevicePanelService {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public PcDevicePanelServiceImpl() {
    }

    @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService
    public final void c(Fragment r6) {
        Intrinsics.checkNotNullParameter(r6, "hostFragment");
        FragmentManager r7 = r6.getChildFragmentManager();
        if (r7.findFragmentByTag("PcAddComputerGuideFragment") == null) goto L5;
        return;
    L5:
        FLogger.a.i("PcDevicePanelServiceImpl", "[showAddComputerGuide]");
        int r1 = PcAddComputerGuideFragment.f;
        Intrinsics.checkNotNullParameter("pc_add_computer_guide_result", "requestKey");
        PcAddComputerGuideFragment r2 = new PcAddComputerGuideFragment();
        Bundle r3 = new Bundle();
        r3.putString("arg_request_key", "pc_add_computer_guide_result");
        r2.setArguments(r3);
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "PcAddComputerGuideFragment", r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r2, r4) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r2.show(r7, "PcAddComputerGuideFragment");
        return;
    }

    @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService
    public final void a(final Fragment r8, String r9, IPcDevicePanelService.d r10, final IPcDevicePanelService.a r11) {
        Intrinsics.checkNotNullParameter(r8, "hostFragment");
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "callback");
        final FragmentManager r0 = r8.getChildFragmentManager();
        if (r0.findFragmentByTag("PcDevicePanelFragment") == null) goto L5;
        return;
    L5:
        r0.setFragmentResultListener("pc_device_panel_result", r8, new e(r11, this, r8));
        r0.setFragmentResultListener("pc_add_computer_guide_result", r8, new f(r0));
        int r12 = PcDevicePanelFragment.o;
        Integer r13 = r10.a;
        Integer r2 = r10.b;
        Integer r3 = r10.c;
        boolean r14 = r10.d;
        Intrinsics.checkNotNullParameter("pc_device_panel_result", "requestKey");
        PcDevicePanelFragment r4 = new PcDevicePanelFragment();
        Bundle r5 = new Bundle();
        r5.putString("arg_request_key", "pc_device_panel_result");
        r5.putString("arg_selected_pc_device_id", r9);
        if (r13 == null) goto L8;
        r5.putInt("arg_title_res_id", r13.intValue());
    L8:
        if (r2 == null) goto L10;
        r5.putInt("arg_navigation_icon_res_id", r2.intValue());
    L10:
        if (r3 == null) goto L12;
        r5.putInt("arg_bottom_sheet_close_size_dp", r3.intValue());
    L12:
        r5.putBoolean("arg_show_cloud_computer", r14);
        r4.setArguments(r5);
        LandscapeRestrictionOperation r15 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "PcDevicePanelFragment", r15);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r4, r15) == true) goto L21;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L16:
        r4.show(r0, "PcDevicePanelFragment");
        return;
    }

    @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService
    public final void b(CreateProjectPanelFragment r5, String r6, IPcDevicePanelService.c r7, final ls9.i r8) {
        Intrinsics.checkNotNullParameter(r5, "hostFragment");
        Intrinsics.checkNotNullParameter(r6, "pcDeviceId");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "callback");
        FragmentManager r1 = r5.getChildFragmentManager();
        if (r1.findFragmentByTag("FolderFragment") == null) goto L5;
        return;
    L5:
        r1.setFragmentResultListener("task_folder_panel_result", r5, new g(r8));
        int r9 = FolderFragment.r;
        boolean r10 = r7.a;
        Intrinsics.checkNotNullParameter(r6, "pcDeviceId");
        FolderFragment r11 = new FolderFragment();
        Bundle r12 = new Bundle();
        r12.putString("arg_pc_device_id", r6);
        r12.putString("arg_current_page", "sidebar_create_project");
        r12.putBoolean("arg_show_do_not_use_folder", r10);
        r11.setArguments(r12);
        LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r11, "FolderFragment", r13);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r11, r13) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r11.show(r1, "FolderFragment");
        return;
    }
}
