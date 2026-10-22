package com.larus.drive.sdk.impl.utils;

import android.content.Context;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.file.download.DriveDownloadPriority;
import com.larus.drive.sdk.api.meta.PreviewFromPage;
import com.larus.drive.sdk.impl.view.operation.DriveRenameDialog;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class MorePanelHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public MorePanelHelper() {
    }

    static {
        a = LazyKt.lazy(new p());
        b = LazyKt.lazy(new q());
        c = LazyKt.lazy(new r());
    }

    public static e89.c c() {
        return (e89.c) c.getValue();
    }

    public static List a(Context r86, DriveFileItem r87, PreviewFromPage r88) {
        Intrinsics.checkNotNullParameter(r86, "ctx");
        Intrinsics.checkNotNullParameter(r88, "previewFromPage");
        if (r87 != null) goto L6;
        FLogger.a.i("MorePanelHelper", "[createMenuList] File is null, no menu");
        return CollectionsKt.emptyList();
    L6:
        ArrayList r3 = new ArrayList();
        if (UploadFilePolicy.e(r87.d(false)) == false) goto L9;
        CollectionsKt.listOf(new DriveFileType[]{DriveFileType.AI_SLIDES, DriveFileType.AI_DOC, DriveFileType.AI_SHEET}).contains(r87.j);
    L9:
        r3.add(new l0(AbsDriveListViewModel.MENU_ID_SHARE, 0, r86.getString(2131905331), null, null, null, null, null, null, false, false, null, 2131241253, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
        if (r87.j == DriveFileType.FOLDER) goto L20;
        if (CollectionsKt.listOf(new DriveFileType[]{DriveFileType.IMAGE, DriveFileType.VIDEO}).contains(r87.j) == true) goto L14;
        String r9 = r86.getString(2131905327);
    L18:
        r3.add(new l0(AbsDriveListViewModel.MENU_ID_DOWNLOAD, 0, r9, null, null, null, null, null, null, false, false, null, 2131241249, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
        goto L20
    L14:
        if (((List) b.getValue()).contains(r87.d(true).toLowerCase(Locale.ROOT)) == false) goto L16;
        r9 = r86.getString(2131905330);
        goto L18
    L16:
        r9 = r86.getString(2131905327);
    L20:
        if (r87.g() == false) goto L22;
    L23:
        r3.add(new i0(2, ContextCompat.getColor(r86, v19.c.b(2130972086, r86, 2131103159))));
        if (CollectionsKt.listOf(new DriveFileType[]{DriveFileType.AI_SLIDES, DriveFileType.AI_DOC, DriveFileType.AI_SHEET}).contains(r87.j) == true) goto L26;
        r3.add(new l0(AbsDriveListViewModel.MENU_ID_RENAME, 0, r86.getString(2131905329), null, null, null, null, null, null, false, false, null, 2131241252, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
    L26:
        r3.add(new l0(AbsDriveListViewModel.MENU_ID_MOVE, 0, r86.getString(2131905328), null, null, null, null, null, null, false, false, null, 2131241251, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
    L27:
        r3.add(new l0(AbsDriveListViewModel.MENU_ID_DELETE, 0, r86.getString(2131905326), null, null, 2131102650, null, null, null, false, false, null, 2131241248, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4134, 127));
        return r3;
    L22:
        if (r88 != PreviewFromPage.MINE) goto L27;
        goto L23
    }

    public static void f(CommonMenu r8, List r9, DriveFileItem r10, CoroutineScope r11) {
        Intrinsics.checkNotNullParameter(r8, "menu");
        Intrinsics.checkNotNullParameter(r9, "menuItems");
        Intrinsics.checkNotNullParameter(r11, "scope");
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator r12 = r9.iterator();
    L7:
        if (r12.hasNext() == false) goto L14;
        Object r0 = r12.next();
        if (((ot8.a) r0).getId() != 10002) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L7;
    L16:
        if ((r0 instanceof l0) == false) goto L18;
        l0 r1 = (l0) r0;
    L19:
        if (r1 != null) goto L21;
        return;
    L21:
        BuildersKt.launch$default(r11, null, null, new MorePanelHelper$refreshShareMenuItem$1(r10, r8, r1, null), 3, null);
        return;
    L18:
        r1 = null;
        goto L19
    L11:
        r2 = false;
        goto L12
    L14:
        r0 = null;
        goto L16
    }

    public static void b(DriveFileItem r11, Context r12, CoroutineScope r13, DriveDownloadPriority r14, Fragment r15) {
        Intrinsics.checkNotNullParameter(r11, "file");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "scope");
        Intrinsics.checkNotNullParameter(r14, "priority");
        BuildersKt.launch$default(r13, null, null, new MorePanelHelper$downloadDriveFile$1(r11, r12, r15, r13, r14, null), 3, null);
    }

    public static void d(ot8.a r16, DriveFileItem r17, Context r18, CoroutineScope r110, v79.e r20, Fragment r21) {
        Intrinsics.checkNotNullParameter(r16, "item");
        Intrinsics.checkNotNullParameter(r18, "context");
        Intrinsics.checkNotNullParameter(r110, "scope");
        if (r17 != null) goto L6;
        FLogger.a.i("MorePanelHelper", "[handleMenuClick] File is null, click no response");
        return;
    L6:
        Boolean r4 = null;
        switch(r16.getId()) {
            case 10001: goto L66;
            case 10002: goto L55;
            case 10003: goto L53;
            case 10004: goto L31;
            case 10005: goto L29;
            case 10006: goto L10;
            default: goto L8;
        };
    L8:
        FLogger.a.i("MorePanelHelper", "[handleMenuClick] Action no response; item=" + r16);
        String r0 = "unknown";
    L67:
        String r2 = r0;
        String r1 = r17.b;
        String r9 = r17.a;
        int r10 = n.a;
        u0.d("click_more", r2, null, null, null, "ai_space_detail", "ai_space_list", r1, r9, n.e(r17.j), n.d(r17), null, null, null, 14364);
        return;
    L29:
        c().f(r17, r18);
        r0 = "move";
        goto L67
    L53:
        b(r17, r18, r110, DriveDownloadPriority.NORMAL, null);
        r0 = "download";
        goto L67
    L66:
        r0 = "ai_read";
        goto L67
    L10:
        if ((r18 instanceof FragmentActivity) == false) goto L12;
        FragmentActivity r3 = (FragmentActivity) r18;
    L13:
        if (r3 != null) goto L15;
    L22:
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("[deleteDriveFile] Activity error; activity=");
        r6.append(r3);
        r6.append(" isStateSaved=");
        if (r3 == null) goto L27;
        FragmentManager r7 = r3.getSupportFragmentManager();
        if (r7 == null) goto L27;
        r4 = Boolean.valueOf(r7.isStateSaved());
    L27:
        r6.append(r4);
        r5.i("MorePanelHelper", r6.toString());
    L28:
        r0 = "delete";
        goto L67
    L15:
        if (r3.getSupportFragmentManager().isStateSaved() == true) goto L22;
        if (r17.g() == false) goto L20;
        int r8 = 2131899714;
    L21:
        BuildersKt.launch$default(r110, null, null, new MorePanelHelper$showDeleteDialog$1(r18, r8, r3, r21, r17, r20, null), 3, null);
        goto L28
    L20:
        r8 = 2131899711;
        goto L21
    L12:
        r3 = null;
        goto L13
    L31:
        if ((r18 instanceof FragmentActivity) == false) goto L33;
        FragmentActivity r11 = (FragmentActivity) r18;
    L34:
        if (r11 != null) goto L36;
    L46:
        FLogger r12 = FLogger.a;
        StringBuilder r13 = new StringBuilder("[deleteDriveFile] Activity error; activity=");
        r13.append(r11);
        r13.append(" isStateSaved=");
        if (r11 == null) goto L51;
        FragmentManager r14 = r11.getSupportFragmentManager();
        if (r14 == null) goto L51;
        r4 = Boolean.valueOf(r14.isStateSaved());
    L51:
        r13.append(r4);
        r12.i("MorePanelHelper", r13.toString());
    L52:
        r0 = "rename";
        goto L67
    L36:
        if (r11.getSupportFragmentManager().isStateSaved() == true) goto L46;
        int r15 = DriveRenameDialog.n;
        DriveRenameDialog.a r22 = new DriveRenameDialog.a();
        r22.a = r18.getString(2131905349);
        r22.c = r18.getString(2131905348);
        r22.d = r18.getString(2131905347);
        r22.b = r17.c();
        r22.e = r18.getString(2131905396);
        t r23 = new t(r17, r18, r20);
        Intrinsics.checkNotNullParameter(r23, "callback");
        r22.f = r23;
        DriveRenameDialog r24 = new DriveRenameDialog();
        Bundle r25 = new Bundle();
        r25.putString("arg_title", r22.a);
        r25.putString("arg_default", r22.b);
        r25.putString("arg_hint", null);
        r25.putString("arg_confirm", r22.c);
        r25.putString("arg_cancel", r22.d);
        r25.putString("arg_empty_input_warning", r22.e);
        r24.setArguments(r25);
        v79.d r26 = r22.f;
        if (r26 == null) goto L41;
        Intrinsics.checkNotNullParameter(r26, "callback");
        r24.k = r26;
    L41:
        FragmentManager r27 = r11.getSupportFragmentManager();
        LandscapeRestrictionOperation r28 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r24, "drive_rename_dialog", r28);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r27, r24, r28) == true) goto L52;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L69
    L45:
        r24.show(r27, "drive_rename_dialog");
        goto L52
    L33:
        r11 = null;
        goto L34
    L55:
        if ((r16 instanceof l0) == false) goto L57;
        r4 = (l0) r16;
    L57:
        if (r4 == null) goto L61;
        boolean r30 = true;
        if (((l0) r4).q != true) goto L61;
    L62:
        if (r30 == false) goto L64;
        t19.s.a.getClass();
        t19.s.s(r18, 2131905370);
    L65:
        r0 = "share";
        goto L67
    L64:
        kw9.c r31 = new kw9.c("ai_space_detail");
        Intrinsics.checkNotNullParameter(r17, "file");
        Intrinsics.checkNotNullParameter(r31, "param");
        c().p(r17.b, r17.d, new s(r17, r31));
    L61:
        r30 = false;
        goto L62
    }

    public static /* synthetic */ void e(ot8.a r6, DriveFileItem r7, Context r8, CoroutineScope r9, v79.e r10, int r11) {
        if ((r11 & 16) == 0) goto L5;
        r10 = null;
    L5:
        d(r6, r7, r8, r9, r10, null);
    }
}
