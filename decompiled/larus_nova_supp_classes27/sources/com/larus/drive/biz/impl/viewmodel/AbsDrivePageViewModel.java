package com.larus.drive.biz.impl.viewmodel;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.common.apphost.AppHost;
import com.larus.doc.api.IDocService;
import com.larus.doc.api.IDocService$Companion;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.dialog.DriveInputConfirmDialog;
import com.larus.drive.biz.impl.file.DriveLocalFileSelector;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.drive.biz.impl.view.DriveMainFragment;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.c2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001 \b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\tH$J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u001cJ\u0016\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020&J\u0010\u0010.\u001a\u00020\u001c2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b!\u0010\"¨\u0006/"}, d2 = {"Lcom/larus/drive/biz/impl/viewmodel/AbsDrivePageViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "hostCallback", "Lcom/larus/drive/biz/impl/viewmodel/callback/IDrivePageHostCallback;", "needRefreshAfterOnResume", "", "currentFolderToken", "", "getCurrentFolderToken", "()Ljava/lang/String;", "setCurrentFolderToken", "(Ljava/lang/String;)V", "currentFolderDriveToken", "getCurrentFolderDriveToken", "setCurrentFolderDriveToken", "createFileCanceller", "Lcom/bytedance/ee/bear/list/callback/ICancelable;", "eventParams", "Lorg/json/JSONObject;", "larkDriveConfig", "Lcom/larus/platform/model/LarkDriveConfig;", "getLarkDriveConfig", "()Lcom/larus/platform/model/LarkDriveConfig;", "larkDriveConfig$delegate", "Lkotlin/Lazy;", "onCleared", "", "getTag", "setEventParams", "driveLocalFileSelectorListener", "com/larus/drive/biz/impl/viewmodel/AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1", "getDriveLocalFileSelectorListener", "()Lcom/larus/drive/biz/impl/viewmodel/AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1;", "driveLocalFileSelectorListener$delegate", "getMoreActionMenuList", "", "Lcom/larus/bmhome/view/screenmenu/abs/IMenuItem;", "ctx", "Landroid/content/Context;", "onResume", "handleMoreActionMenuItemClick", "fragment", "Landroidx/fragment/app/Fragment;", "item", "setHostCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDrivePageViewModel extends ViewModel {
    private nc5.b createFileCanceller;
    private String currentFolderDriveToken;
    private String currentFolderToken;
    private final Lazy driveLocalFileSelectorListener$delegate;
    private JSONObject eventParams;
    private q79.a hostCallback;
    private final Lazy larkDriveConfig$delegate;
    private boolean needRefreshAfterOnResume;

    public static final class a implements m79.g {
        public final /* synthetic */ AbsDrivePageViewModel a;
        public final /* synthetic */ Fragment b;

        @Override // m79.g
        public final void d() {
        }

        @Override // m79.g
        public final void a(String r9) {
            Intrinsics.checkNotNullParameter(r9, "input");
            nc5.b r0 = AbsDrivePageViewModel.access$getCreateFileCanceller$p(this.a);
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            AbsDrivePageViewModel r1 = this.a;
            DriveSdkService r2 = DriveSdkService.a;
            String r3 = r1.getCurrentFolderDriveToken();
            DriveFileType r4 = DriveFileType.FOLDER;
            final AbsDrivePageViewModel r5 = this.a;
            Function1<? super DriveFileItem, Unit> r6 = new w(r5);
            final Fragment r7 = this.b;
            AbsDrivePageViewModel.access$setCreateFileCanceller$p(r1, r2.R(r3, r4, r9, r6, new x(r5, r7)));
        }

        @Override // m79.g
        public final boolean b(String r4) {
            Intrinsics.checkNotNullParameter(r4, "input");
            int r0 = AbsDrivePageViewModel.access$getLarkDriveConfig(this.a).d();
            if (r4.length() <= r0) goto L6;
            t19.s r5 = t19.s.a;
            FragmentActivity r1 = this.b.getActivity();
            String r2 = this.b.getString(2131901079);
            r5.getClass();
            t19.s.t(r1, r2);
            return false;
        L6:
            return true;
        }

        @Override // m79.g
        public final Pair<Boolean, String> c(String r6) {
            Intrinsics.checkNotNullParameter(r6, "input");
            int r0 = AbsDrivePageViewModel.access$getLarkDriveConfig(this.a).d();
            if (r6.length() <= r0) goto L7;
            t19.s r1 = t19.s.a;
            FragmentActivity r2 = this.b.getActivity();
            String r3 = this.b.getString(2131901079);
            r1.getClass();
            t19.s.t(r2, r3);
            return TuplesKt.to(Boolean.TRUE, StringsKt.take(r6, r0));
        L7:
            return TuplesKt.to(Boolean.FALSE, r6);
        }

        public a(AbsDrivePageViewModel r1, Fragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static /* synthetic */ Unit Mo(AbsDrivePageViewModel r0, Fragment r1, String r2) {
        return handleMoreActionMenuItemClick$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1 No(AbsDrivePageViewModel r0) {
        return driveLocalFileSelectorListener_delegate$lambda$1(r0);
    }

    public static /* synthetic */ c2 Oo() {
        return larkDriveConfig_delegate$lambda$0();
    }

    public static /* synthetic */ Unit yo(AbsDrivePageViewModel r0, Fragment r1, DriveFileItem r2) {
        return handleMoreActionMenuItemClick$lambda$2(r0, r1, r2);
    }

    public abstract String getTag();

    private final AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1 getDriveLocalFileSelectorListener() {
        return (AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1) this.driveLocalFileSelectorListener$delegate.getValue();
    }

    private final c2 getLarkDriveConfig() {
        return (c2) this.larkDriveConfig$delegate.getValue();
    }

    private static final c2 larkDriveConfig_delegate$lambda$0() {
        return z2.a.getLarkDriveConfig();
    }

    public final void onResume() {
        if (this.needRefreshAfterOnResume == true) goto L5;
        return;
    L5:
        this.needRefreshAfterOnResume = false;
        q79.a r0 = this.hostCallback;
        if (r0 == null) goto L9;
        r0.refresh();
        return;
    }

    public AbsDrivePageViewModel() {
        this.larkDriveConfig$delegate = LazyKt.lazy(new u());
        this.driveLocalFileSelectorListener$delegate = LazyKt.lazy(new v(this));
    }

    public void onCleared() {
        super.onCleared();
        nc5.b r0 = this.createFileCanceller;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public final String getCurrentFolderDriveToken() {
        return this.currentFolderDriveToken;
    }

    public final String getCurrentFolderToken() {
        return this.currentFolderToken;
    }

    public static final /* synthetic */ nc5.b access$getCreateFileCanceller$p(AbsDrivePageViewModel r0) {
        return r0.createFileCanceller;
    }

    public static final /* synthetic */ JSONObject access$getEventParams$p(AbsDrivePageViewModel r0) {
        return r0.eventParams;
    }

    public static final /* synthetic */ q79.a access$getHostCallback$p(AbsDrivePageViewModel r0) {
        return r0.hostCallback;
    }

    public static final /* synthetic */ c2 access$getLarkDriveConfig(AbsDrivePageViewModel r0) {
        return r0.getLarkDriveConfig();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.drive.biz.impl.viewmodel.AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1] */
    private static final AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1 driveLocalFileSelectorListener_delegate$lambda$1(final AbsDrivePageViewModel r1) {
        return new AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1(r1);
    }

    public final List<ot8.a> getMoreActionMenuList(Context r129) {
        Intrinsics.checkNotNullParameter(r129, "ctx");
        int r2 = com.larus.drive.biz.impl.utils.n.a;
        Intrinsics.checkNotNullParameter(r129, "ctx");
        ArrayList r1 = new ArrayList();
        if (Build.VERSION.SDK_INT <= 29) goto L32;
        r1.add(new l0(AbsDriveListViewModel.MENU_ID_ASK, 0, r129.getString(2131905288), null, null, null, null, null, null, false, false, null, 2131241265, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
        e0 r3 = (e0) AuthModelDelegate.b.e().getValue();
        boolean r4 = false;
        if (r3 == null) goto L30;
        LaunchInfo r5 = r3.a;
        if (r5 == null) goto L30;
        String r6 = r5.W();
        if (r6 == null) goto L30;
        List r7 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r6);
        Object r8 = null;
        if (r7 == null) goto L28;
        Iterator r9 = r7.iterator();
    L15:
        if (r9.hasNext() == false) goto L27;
        Object r10 = r9.next();
        com.larus.bmhome.actionbar.model.r r11 = ((z0) r10).q;
        if (r11 == null) goto L24;
        Integer r12 = r11.a;
        if (r12 == null) goto L24;
        if (r12.intValue() != 30) goto L24;
        boolean r13 = true;
    L25:
        if (r13 == false) goto L15;
        r8 = r10;
    L24:
        r13 = false;
    L27:
        r8 = (z0) r8;
    L28:
        if (r8 == null) goto L30;
        r4 = true;
    L30:
        if (r4 == false) goto L32;
        r1.add(new l0(AbsDriveListViewModel.MENU_ID_SHARE, 0, r129.getString(2131905290), null, null, null, null, null, null, false, false, null, 2131241272, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
    L32:
        r1.add(new l0(AbsDriveListViewModel.MENU_ID_DOWNLOAD, 0, r129.getString(2131905289), null, null, null, null, null, null, false, false, null, 2131241266, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
        r1.add(new i0(1, ContextCompat.getColor(r129, v19.c.b(2130972086, r129, 2131103159))));
        r1.add(new l0(AbsDriveListViewModel.MENU_ID_RENAME, 0, r129.getString(2131909814), null, null, null, null, null, null, false, false, null, 2131241271, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
        r1.add(new l0(AbsDriveListViewModel.MENU_ID_MOVE, 0, r129.getString(2131907305), null, null, null, null, null, null, false, false, null, 2131241273, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127));
        return r1;
    }

    public final void setCurrentFolderDriveToken(String r1) {
        this.currentFolderDriveToken = r1;
    }

    public final void setCurrentFolderToken(String r1) {
        this.currentFolderToken = r1;
    }

    public void setEventParams(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "eventParams");
        this.eventParams = r2;
    }

    public final void setHostCallback(q79.a r1) {
        this.hostCallback = r1;
    }

    public static final /* synthetic */ void access$setCreateFileCanceller$p(AbsDrivePageViewModel r0, nc5.b r1) {
        r0.createFileCanceller = r1;
    }

    public final void handleMoreActionMenuItemClick(final Fragment r7, ot8.a r8) {
        Intrinsics.checkNotNullParameter(r7, "fragment");
        Intrinsics.checkNotNullParameter(r8, "item");
        String r2 = null;
        switch(r8.getId()) {
            case 10001: goto L18;
            case 10002: goto L8;
            case 10003: goto L7;
            case 10004: goto L6;
            case 10005: goto L5;
            default: goto L30;
        };
    L5:
        DriveLocalFileSelector r9 = DriveLocalFileSelector.a;
        final AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1 r3 = getDriveLocalFileSelectorListener();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r7, "fragment");
        Intrinsics.checkNotNullParameter(r3, "listener");
        DriveLocalFileSelector.b(r7, new com.larus.drive.biz.impl.file.d(r7, r3));
        return;
    L6:
        DriveLocalFileSelector r10 = DriveLocalFileSelector.a;
        final AbsDrivePageViewModel$driveLocalFileSelectorListener$2$1 r4 = getDriveLocalFileSelectorListener();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r7, "fragment");
        Intrinsics.checkNotNullParameter(r4, "listener");
        DriveLocalFileSelector.b(r7, new com.larus.drive.biz.impl.file.c(r7, r4));
        return;
    L7:
        int r11 = DriveInputConfirmDialog.n;
        DriveInputConfirmDialog.a r12 = new DriveInputConfirmDialog.a();
        r12.a = r7.getString(2131905341);
        r12.c = r7.getString(2131905342);
        r12.d = r7.getString(2131905339);
        r12.e = r7.getString(2131905340);
        r12.f = r7.getString(2131905396);
        a r0 = new a(this, r7);
        Intrinsics.checkNotNullParameter(r0, "callback");
        r12.g = r0;
        INVOKEVIRTUAL_com_larus_drive_biz_impl_viewmodel_AbsDrivePageViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r12.a(), r7.getParentFragmentManager(), null);
        return;
    L8:
        e0 r13 = (e0) AuthModelDelegate.b.e().getValue();
        if (r13 == null) goto L26;
        LaunchInfo r14 = r13.a;
        if (r14 == null) goto L27;
        String r15 = r14.W();
        if (r15 == null) goto L28;
        com.bytedance.router.i r16 = SmartRouter.buildRoute(AppHost.a.getApplication().getApplicationContext(), "//flow/chat_page");
        Pair[] r1 = new Pair[4];
        r1[0] = TuplesKt.to("bot_id", r15);
        r1[1] = TuplesKt.to("actionbar_instruction_type", 30);
        r1[2] = TuplesKt.to("slide_create_from_drive", Boolean.TRUE);
        WeakReference<DriveMainFragment> r17 = DriveMainFragment.w;
        if (DriveMainFragment.a.a() == null) goto L17;
        r2 = "ai_space_list";
    L17:
        r1[3] = TuplesKt.to("argPreviousPage", r2);
        Bundle r18 = com.larus.utils.f.c(r1);
        r16.c.putExtras(r18);
        r16.d();
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L18:
        this.needRefreshAfterOnResume = true;
        nc5.b r20 = this.createFileCanceller;
        if (r20 == null) goto L21;
        r20.cancel();
    L21:
        this.createFileCanceller = DriveSdkService.a.R(this.currentFolderDriveToken, DriveFileType.AI_DOC, null, new s(this, r7), new t(this, r7));
        return;
    }

    public static void INVOKEVIRTUAL_com_larus_drive_biz_impl_viewmodel_AbsDrivePageViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(DriveInputConfirmDialog r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        DriveInputConfirmDialog r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private static final Unit handleMoreActionMenuItemClick$lambda$2(AbsDrivePageViewModel r5, Fragment r6, DriveFileItem r7) {
        String r0 = null;
        r5.createFileCanceller = null;
        FLogger r1 = FLogger.a;
        String r2 = r5.getTag();
        StringBuilder r3 = new StringBuilder("createDriveFile success, fileToken[");
        if (r7 == null) goto L5;
        String r4 = r7.b;
    L6:
        r3.append(r4);
        r3.append("], fileDriveToken[");
        if (r7 == null) goto L9;
        String r8 = r7.c;
    L10:
        r3.append(r8);
        r3.append(']');
        r1.i(r2, r3.toString());
        q79.a r9 = r5.hostCallback;
        if (r9 == null) goto L13;
        r9.refresh();
    L13:
        Context r10 = r6.getActivity();
        if (r10 == null) goto L16;
        if (r7 == null) goto L19;
        IDocService$Companion r11 = IDocService.a;
        Pair[] r12 = new Pair[3];
        r12[0] = TuplesKt.to("key_doc_id", r7.b);
        WeakReference<DriveMainFragment> r13 = DriveMainFragment.w;
        DriveMainFragment r14 = DriveMainFragment.a.a();
        if (r14 == null) goto L23;
        r0 = r14.b();
    L23:
        r12[1] = TuplesKt.to("key_click_previous_page", r0);
        r12[2] = TuplesKt.to("key_doc_enter_from", "ai_space_create_blank_doc");
        Bundle r15 = BundleKt.bundleOf(r12);
        DriveMainFragment.a.a();
        r11.Z9(r10, r15, "ai_space_list");
        return Unit.INSTANCE;
    L19:
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    L9:
        r8 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    private static final Unit handleMoreActionMenuItemClick$lambda$3(AbsDrivePageViewModel r3, Fragment r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        r3.createFileCanceller = null;
        t19.s r0 = t19.s.a;
        FragmentActivity r1 = r4.getActivity();
        String r6 = r4.getString(2131905570);
        r0.getClass();
        t19.s.t(r1, r6);
        FLogger.a.e(r3.getTag(), "createDriveFile error, msg = " + r5);
        return Unit.INSTANCE;
    }
}
