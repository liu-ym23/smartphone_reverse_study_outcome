package com.larus.drive.sdk.impl.view.preview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.databinding.LarusLayoutDrivePreviewFileFragmentBinding;
import com.larus.drive.sdk.impl.utils.n;
import com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer;
import com.larus.drive.sdk.impl.viewmodel.preview.DrivePreviewViewModel;
import com.larus.platform.api.FlowDriveFileSendInfo;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k implements DriveFloatChatContainer.a {
    public final /* synthetic */ DrivePreviewFragment a;

    public k(DrivePreviewFragment r1) {
        this.a = r1;
    }

    @Override // com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer.a
    public final void a(boolean r2, g0 r3) {
        if (r2 == false) goto L14;
        if (r3 == null) goto L9;
        Context r4 = this.a.getContext();
        if (r4 == null) goto L7;
        Drawable r5 = ContextCompat.getDrawable(r4, 2131240729);
    L8:
        r3.gA(r5);
        goto L9
    L7:
        r5 = null;
    L9:
        LarusLayoutDrivePreviewFileFragmentBinding r6 = this.a.e;
        if (r6 == null) goto L20;
        View r7 = r6.e;
        if (r7 == null) goto L21;
        e1.x(r7);
        return;
    L21:
        return;
    L20:
        return;
    L14:
        LarusLayoutDrivePreviewFileFragmentBinding r8 = this.a.e;
        if (r8 == null) goto L23;
        View r9 = r8.e;
        if (r9 == null) goto L24;
        e1.o(r9);
        return;
    L24:
        return;
    }

    @Override // com.larus.drive.sdk.impl.view.chat.DriveFloatChatContainer.a
    public final boolean b(String r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r17, "content");
        DrivePreviewFragment r2 = this.a;
        DriveFloatChatContainer r3 = r2.g;
        String r4 = null;
        if (r3 == null) goto L7;
        DriveFloatChatContainer.c r5 = r3.g;
        if (r5 == null) goto L7;
        r79.a r6 = r5.d();
    L8:
        boolean r7 = false;
        if (r6 != null) goto L11;
        FLogger.a.i("DrivePreviewFragment", "[handleDrivePreviewSendMsg] DriveChatReceiveAbility is null");
        return false;
    L11:
        y79.c r0 = ((DrivePreviewViewModel) r2.f.getValue()).buildSendDriveFileInfo(r17, r2.j);
        DriveFloatChatContainer r8 = r2.g;
        if (r8 == null) goto L20;
        DriveFloatChatContainer.c r9 = r8.g;
        if (r9 == null) goto L20;
        g0 r10 = r9.b();
        if (r10 == null) goto L20;
        if (r10.YC() != true) goto L20;
        r7 = true;
    L20:
        if (r7 == true) goto L25;
        List<y79.d> r11 = r0.a();
        if (r11 == null) goto L25;
        List r12 = CollectionsKt.filterNotNull(r11);
    L26:
        DriveFloatChatContainer r13 = r2.g;
        if (r13 == null) goto L31;
        DriveFloatChatContainer.c r14 = r13.g;
        if (r14 == null) goto L31;
        y r15 = r14.u0();
    L32:
        String r16 = r0.b();
        String r20 = r0.c();
        if (r18 == false) goto L35;
        String r1 = "speak";
    L36:
        String r21 = r1;
        DriveFileItem r22 = r2.j;
        if (r22 == null) goto L39;
        String r110 = r22.b;
        String r111 = r22.a;
        int r112 = n.a;
        FlowDriveFileSendInfo r113 = new FlowDriveFileSendInfo(r110, r111, n.e(r22.j), n.d(r22));
    L40:
        if (r15 == null) goto L42;
        wc9.e r114 = r15.h();
    L43:
        if (r15 == null) goto L45;
        String r115 = r15.Y1();
    L46:
        if (r15 == null) goto L48;
        r4 = r15.getBotId();
    L48:
        r6.T10(r16, r12, r20, r21, r18, r113, r114, r115, r4);
        return true;
    L45:
        r115 = null;
        goto L46
    L42:
        r114 = null;
        goto L43
    L39:
        r113 = null;
        goto L40
    L35:
        r1 = "keyboard";
    L31:
        r15 = null;
    L25:
        r12 = null;
    L7:
        r6 = null;
        goto L8
    }
}
