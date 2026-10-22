package com.larus.bmhome.chat.component.bottom.bottommenu;

import android.net.Uri;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.g1;
import com.larus.platform.api.DriveFileSelectScene;
import com.larus.platform.api.IFlowDriveSdkService;
import com.larus.platform.api.fileselect.SelectDialogParam;
import com.larus.platform.service.FlowDriveSdkService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d1 implements aq9.b {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ BottomMenuComponent b;

    public final void a(List<? extends Uri> r11) {
        Intrinsics.checkNotNullParameter(r11, "uris");
        BottomMenuComponent r0 = this.b;
        int r1 = BottomMenuComponent.x1;
        com.larus.bmhome.chat.component.bottom.multimodal.g r2 = r0.r5();
        boolean r3 = true;
        if (r2 == null) goto L10;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r4.add(new com.larus.bmhome.chat.component.bottom.multimodal.a.C0050a((Uri) r12.next(), null, 2));
        goto L6
    L8:
        g1 r5 = new g1(true, MultimodalBizScene.ChatInputFile, false);
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("scene", "file");
        r7.put("upload_file_click_from", "plus_panel");
        Unit r13 = Unit.INSTANCE;
        r2.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(r4, r5, null, r7, null, 20));
    L10:
        if (com.larus.platform.exp.g.a() == false) goto L23;
        com.larus.bmhome.chat.component.bottom.multimodal.g r14 = this.b.r5();
        if (r14 != null) goto L14;
    L16:
        r3 = false;
    L17:
        if (r3 == true) goto L24;
        ICoreInputAbility r15 = this.b.Q3();
        if (r15 == null) goto L25;
        r15.C1(false, false, "chatFileSelectionCallback");
        return;
    L25:
        return;
    L24:
        return;
    L14:
        if (r14.xE() != true) goto L16;
    }

    public final void b(com.larus.platform.api.fileselect.a r11) {
        Intrinsics.checkNotNullParameter(r11, "selectionStore");
        if (this.a == true) goto L5;
    L7:
        BottomMenuComponent r0 = this.b;
        int r1 = BottomMenuComponent.x1;
        r0.k4();
        IFlowDriveSdkService.a.b(FlowDriveSdkService.a, s1a.a.c(this.b).getParentFragmentManager(), DriveFileSelectScene.CHAT_SELECTOR, r11, new SelectDialogParam(null, this.b.f1().p(), null, 5, null));
        return;
    L5:
        if (s1a.a.c(this.b).isAdded() == true) goto L7;
    }

    public d1(boolean r1, BottomMenuComponent r2) {
        this.a = r1;
        this.b = r2;
    }
}
