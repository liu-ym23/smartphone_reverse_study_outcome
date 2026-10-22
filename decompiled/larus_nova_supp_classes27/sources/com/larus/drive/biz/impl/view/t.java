package com.larus.drive.biz.impl.view;

import com.ixigua.lib.track.TrackParams;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t implements k79.h {
    public final /* synthetic */ AbsDriveListFragment a;

    public t(AbsDriveListFragment r1) {
        this.a = r1;
    }

    @Override // k79.h
    public final void a(DriveFileItem r8, int r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "file");
        String r0 = com.larus.drive.biz.impl.utils.e.a;
        if (r10 != null) goto L5;
        r10 = "direct_show";
    L5:
        Integer r11 = Integer.valueOf(r9);
        String r1 = r8.b;
        String r2 = r8.a;
        String r3 = com.larus.drive.biz.impl.utils.e.c(r8.j);
        String r12 = com.larus.drive.biz.impl.utils.e.b(r8);
        DriveMainFragment r4 = this.a.S90();
        JSONObject r5 = new JSONObject();
        Intrinsics.checkNotNullParameter(r5, "params");
        if (r0 == null) goto L8;
        r5.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM, r0);
    L8:
        r5.put("show_from", r10);
        if (r11 == null) goto L11;
        r5.put("index", r11.intValue());
    L11:
        if (r1 == null) goto L13;
        r5.put("collection_id", r1);
    L13:
        if (r2 == null) goto L15;
        r5.put("collection_name", r2);
    L15:
        r5.put("content_type", r3);
        if (r12 == null) goto L18;
        r5.put("content_sec_type", r12);
    L18:
        TrackParams r13 = new TrackParams().merge(r5);
        by7.a r14 = new by7.a("ai_space_file_click");
        if (r4 == null) goto L21;
        r14.b = r4;
    L21:
        r14.a.merge(r13);
        r14.b();
    }

    @Override // k79.h
    public final void b(DriveFileItem r9, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "file");
        String r0 = com.larus.drive.biz.impl.utils.e.a;
        if (r11 != null) goto L6;
        r11 = "direct_show";
    L6:
        if ((this.a instanceof DriveRecentListFragment) == false) goto L8;
        String r1 = "latest";
    L9:
        Integer r12 = Integer.valueOf(r10);
        String r2 = r9.b;
        String r3 = r9.a;
        String r4 = com.larus.drive.biz.impl.utils.e.c(r9.j);
        String r13 = com.larus.drive.biz.impl.utils.e.b(r9);
        DriveMainFragment r5 = this.a.S90();
        JSONObject r6 = new JSONObject();
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r0 == null) goto L12;
        r6.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM, r0);
    L12:
        r6.put("show_from", r11);
        r6.put("folder_tab", r1);
        if (r12 == null) goto L15;
        r6.put("index", r12.intValue());
    L15:
        if (r2 == null) goto L17;
        r6.put("collection_id", r2);
    L17:
        if (r3 == null) goto L19;
        r6.put("collection_name", r3);
    L19:
        r6.put("content_type", r4);
        if (r13 == null) goto L22;
        r6.put("content_sec_type", r13);
    L22:
        TrackParams r14 = new TrackParams().merge(r6);
        by7.a r15 = new by7.a("ai_space_file_show");
        if (r5 == null) goto L25;
        r15.b = r5;
    L25:
        r15.a.merge(r14);
        r15.b();
        return;
    L8:
        r1 = "my_file";
        goto L9
    }
}
