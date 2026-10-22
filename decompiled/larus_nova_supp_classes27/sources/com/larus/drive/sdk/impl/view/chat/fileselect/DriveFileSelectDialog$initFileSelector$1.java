package com.larus.drive.sdk.impl.view.chat.fileselect;

import androidx.collection.LruCache;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common_ui.widget.ChatFileSelectorView;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.platform.api.DriveFileSelectScene;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.fileselect.IChatFileSelectionStore;
import com.larus.platform.api.fileselect.SelectDialogParam;
import com.larus.platform.service.FlowDriveSdkService;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveFileSelectDialog$initFileSelector$1 implements ChatFileSelectorView.a {
    public final /* synthetic */ DriveFileSelectDialog a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFileSelectScene.values().length];
            r0[DriveFileSelectScene.ATTACHMENT_PANEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DriveFileSelectScene.INPUT_UPLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DriveFileSelectScene.CHAT_SELECTOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements aq9.c {
        public final /* synthetic */ DriveFileSelectDialog a;

        public final List<com.larus.platform.api.u> b() {
            return this.a.n.snapshot();
        }

        public b(DriveFileSelectDialog r1) {
            this.a = r1;
        }

        public final void a(com.larus.platform.api.u r7) {
            Intrinsics.checkNotNullParameter(r7, "item");
            DriveFileSelectDialog r0 = this.a;
            int r1 = DriveFileSelectDialog.t;
            DriveFileSelectDialog$pickerCallback$2$1 r2 = (DriveFileSelectDialog$pickerCallback$2$1) r0.q.getValue();
            String r8 = r7.a;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r8, "id");
            List r3 = r2.b.n.snapshot();
            r2.b.n.a(r8, IChatFileSelectionStore.Source.SELECTED_LIST);
            Iterator<T> r4 = r2.a.iterator();
        L3:
            DriveFileItem r5 = null;
            if (r4.hasNext() == false) goto L8;
            Object r6 = r4.next();
            if (Intrinsics.areEqual(((DriveFileItem) r6).b, r8) == false) goto L3;
        L9:
            DriveFileItem r9 = (DriveFileItem) r6;
            if (r9 != null) goto L21;
            Iterator r10 = r3.iterator();
        L13:
            if (r10.hasNext() == false) goto L17;
            Object r11 = r10.next();
            if (Intrinsics.areEqual(((com.larus.platform.api.u) r11).a, r8) == false) goto L13;
        L18:
            com.larus.platform.api.u r12 = (com.larus.platform.api.u) r11;
            if (r12 == null) goto L22;
            r2.b.getClass();
            r5 = DriveFileSelectDialog.Z90(r12);
        L22:
            if (r5 == null) goto L33;
            w79.b r13 = r2.b.r;
            if (r13 == null) goto L34;
            r13.deselectItem(CollectionsKt.listOf(r5));
            return;
        L34:
            return;
        L33:
            return;
        L17:
            r11 = null;
            goto L18
        L21:
            r5 = r9;
            goto L22
        L8:
            r6 = null;
            goto L9
        }
    }

    @Override // com.larus.common_ui.widget.ChatFileSelectorView.a
    public final void a() {
        FlowDriveSdkService.a.n(this.a.getParentFragmentManager(), null, new b(this.a));
    }

    public DriveFileSelectDialog$initFileSelector$1(DriveFileSelectDialog r1) {
        this.a = r1;
    }

    @Override // com.larus.common_ui.widget.ChatFileSelectorView.a
    public final void b(String r12) {
        List<com.larus.platform.api.u> r0 = this.a.n.snapshot();
        FragmentActivity r1 = this.a.getActivity();
        if (r1 == null) goto L5;
        LifecycleCoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(r1);
    L6:
        LifecycleCoroutineScope r7 = r2;
        if (r7 != null) goto L9;
    L10:
        c(r12, r0);
        Unit r13 = Unit.INSTANCE;
        return;
    L9:
        if (BuildersKt.launch$default(r7, Dispatchers.getIO(), null, new DriveFileSelectDialog$initFileSelector$1$onNextClick$1(this.a, r0, this, r12, null), 2, null) == null) goto L10;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void c(String r48, List<com.larus.platform.api.u> r410) {
        DriveFileSelectScene r4 = this.a.k;
        int r5 = a.a[r4.ordinal()];
        if (r5 == 1) goto L8;
        if (r5 == 2) goto L8;
        if (r5 == 3) goto L8;
    L101:
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L78
    L82:
        DriveFileSelectDialog r0 = this.a;
        if (r0.k != DriveFileSelectScene.CHAT_SELECTOR) goto L111;
        List r1 = r0.getParentFragmentManager().getFragments();
        ArrayList r6 = new ArrayList();
        Iterator r2 = r1.iterator();
    L86:
        if (r2.hasNext() == false) goto L90;
        Object r7 = r2.next();
        if ((r7 instanceof ChatFileSelectDialog) == false) goto L86;
        r6.add(r7);
        goto L86
    L90:
        ChatFileSelectDialog r3 = (ChatFileSelectDialog) CollectionsKt.firstOrNull(r6);
        if (r3 == null) goto L112;
        r3.dismissAllowingStateLoss();     // Catch: Exception -> L94
        return;
    L94:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L113;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L113:
        return;
    L112:
        return;
    L111:
        return;
    L78:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L82;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L8:
        DriveFileSelectDialog r10 = this.a;
        r10.getClass();
        FlowDriveSdkService.a.w(r48, r410);
        Iterator<T> r11 = r410.iterator();
    L10:
        if (r11.hasNext() == false) goto L101;
        com.larus.platform.api.u r12 = (com.larus.platform.api.u) r11.next();
        IChatFileSelectionStore.Source r13 = r10.n.e(r12.a);
        int r14 = r410.size();
        int r15 = com.larus.drive.sdk.impl.utils.n.a;
        Integer r16 = Integer.valueOf(r12.h);
        String r17 = r12.b;
        DriveFileType r18 = com.larus.drive.sdk.impl.utils.n.a(r16, r17);
        if (r18 == DriveFileType.BITABLE) goto L14;
        aq9.g r110 = null;
    L18:
        LruCache r111 = ko8.a.a;
        SelectDialogParam r112 = r10.m;
        if (r112 == null) goto L21;
        String r113 = r112.getBotId();
    L23:
        if (r14 <= 1) goto L25;
        boolean r114 = true;
    L26:
        FlowDriveFileType r115 = r12.f;
        if (r115 != FlowDriveFileType.IMAGE) goto L29;
        boolean r116 = true;
    L31:
        if (r115 != FlowDriveFileType.AUDIO) goto L33;
        boolean r20 = true;
    L35:
        if (r115 != FlowDriveFileType.VIDEO) goto L37;
        boolean r21 = true;
    L38:
        String r117 = r12.a;
        String r118 = r12.b;
        SelectDialogParam r119 = r10.m;
        if (r119 == null) goto L41;
        String r210 = r119.getPreviousPage();
    L42:
        Map r120 = r12.m;
        if (r120 == null) goto L46;
        String r121 = (String) r120.get("upload_from");
        if (r121 == null) goto L46;
    L54:
        String r36 = r121;
    L55:
        Map r22 = r12.m;
        if (r22 == null) goto L59;
        String r23 = (String) r22.get("upload_way");
        if (r23 == null) goto L59;
    L67:
        String r37 = r23;
    L68:
        if (r110 == null) goto L70;
        String r40 = r110.a;
    L71:
        if (r110 == null) goto L73;
        String r41 = r110.b;
    L74:
        ko8.a.m(r113, "chat", r114, null, r116, r20, r21, true, r117, r118, null, null, null, null, r210, null, null, null, null, null, null, r36, r37, null, null, r40, r41, null, null, null, null, 2040511496);
        goto L10
    L73:
        r41 = null;
        goto L74
    L70:
        r40 = null;
    L59:
        if (r13 != null) goto L61;
        int r24 = -1;
    L62:
        if (r24 == 1) goto L66;
        if (r24 == 2) goto L65;
        r37 = null;
        goto L68
    L65:
        r23 = "input_ai_space";
        goto L67
    L66:
        r23 = "recent_sent_file";
        goto L67
    L61:
        r24 = DriveFileSelectDialog.d.b[r13.ordinal()];
    L46:
        if (r13 != null) goto L48;
        int r122 = -1;
    L49:
        if (r122 == 1) goto L53;
        if (r122 == 2) goto L52;
        r36 = null;
        goto L55
    L52:
        r121 = "drive";
        goto L54
    L53:
        r121 = "local";
        goto L54
    L48:
        r122 = DriveFileSelectDialog.d.b[r13.ordinal()];
        goto L49
    L41:
        r210 = null;
        goto L42
    L37:
        r21 = false;
        goto L38
    L33:
        r20 = false;
        goto L35
    L29:
        r116 = false;
        goto L31
    L25:
        r114 = false;
        goto L26
    L21:
        r113 = null;
        goto L23
    L14:
        String r123 = com.larus.drive.sdk.impl.utils.n.e(r18);
        if (r17 != null) goto L17;
        r17 = "";
    L17:
        r110 = new aq9.g(r123, com.larus.drive.sdk.impl.utils.n.c(r18, r17));
        goto L18
    }
}
