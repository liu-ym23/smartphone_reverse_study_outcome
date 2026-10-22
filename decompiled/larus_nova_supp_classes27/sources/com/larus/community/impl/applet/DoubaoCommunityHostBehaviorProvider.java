package com.larus.community.impl.applet;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.community.api.spi.ICommunityHostBehaviorProvider;
import com.larus.community.impl.detail.CreationDetailActivity;
import com.larus.community.impl.detail.CreationDetailFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\u0012\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J2\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u000eH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010&\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0017H\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010+\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010,\u001a\u0004\u0018\u00010\u0014H\u0016JH\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010,\u001a\u0004\u0018\u00010\u00142\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u0005012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000501H\u0016J\u0010\u00103\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00104\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00105\u001a\u00020\tH\u0016J\u0010\u00106\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u00107\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00108\u001a\u00020\tH\u0016J!\u00109\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010:J\u0012\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006>"}, d2 = {"Lcom/larus/community/impl/applet/DoubaoCommunityHostBehaviorProvider;", "Lcom/larus/community/api/spi/ICommunityHostBehaviorProvider;", "<init>", "()V", "onCreationPublishSuccess", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "handleCreationPublishLanding", "", "currentActivity", "Landroid/app/Activity;", "getPendingPublishedCreation", "arguments", "Landroid/os/Bundle;", "showPendingPublishedCreationNotice", "fragment", "Landroidx/fragment/app/Fragment;", "consumePendingPublishedCreation", "creationId", "", "openCreationDetailFromFeed", "creationFeedType", "", "detailArguments", "sourceProfileUserId", "openCreationDetailFromRoute", "context", "Landroid/content/Context;", "openChatBelowCommunityHostIfNeeded", "isChatDoublePage", "params", "getCommunityHostUiPolicy", "Lcom/larus/community/api/spi/CommunityHostUiPolicy;", "getCommunityCreatePageExtra", "shouldShowCreationFeedDebugLabel", "getCreationDetailChromePolicy", "Lcom/larus/community/api/spi/CommunityDetailChromePolicy;", "getCreationDetailBottomPadding", "rootView", "Landroid/view/View;", "nativeNavigationHeight", "handleCreationDetailExit", "handleCreationDetailAuthorClick", "currentUserId", "updateCreationDetailOwnerMenu", "owner", "", "onSetPrivate", "Lkotlin/Function0;", "onDelete", "clearCreationDetailOwnerMenu", "onCreationDetailFullscreenChanged", "isFullscreen", "shouldShowCreationDetailBottomShareAction", "getCreationDetailOpenNewChatPageOnSend", "defaultValue", "getCreationDetailDoSameLandingType", "(Landroidx/fragment/app/Fragment;Ljava/lang/Integer;)Ljava/lang/Integer;", "findRouteActivityBelowPublish", "Landroidx/fragment/app/FragmentActivity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoCommunityHostBehaviorProvider implements ICommunityHostBehaviorProvider {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CreationAppletUiHelper.PageExitBehavior.values().length];
            r0[CreationAppletUiHelper.PageExitBehavior.HOST_BACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CreationAppletUiHelper.PageExitBehavior.HOST_CLOSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CreationAppletUiHelper.PageExitBehavior.NATIVE_FINISH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public DoubaoCommunityHostBehaviorProvider() {
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final Bundle a(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Bundle r4 = new Bundle();
        r4.putBoolean("suppress_action_bar_item_id_on_send", true);
        return r4;
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final Integer c(Fragment r6) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        int r0 = CreationAppletUiHelper.a;
        Bundle r7 = r6.getArguments();
        Bundle r1 = cy9.a.a.c(r7);
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L18;
        if (r7 != null) goto L12;
    L14:
        if (r2 == true) goto L19;
        return null;
    L19:
        return Integer.valueOf(r7.getInt("creation_dosame_landing_type"));
    L12:
        if (r7.containsKey("creation_dosame_landing_type") != true) goto L14;
        r2 = true;
        goto L14
    L18:
        return Integer.valueOf(r1.getInt("creation_dosame_landing_type"));
    L5:
        if (r1.containsKey("creation_dosame_landing_type") != true) goto L7;
        r4 = true;
        goto L8
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final e29.e d(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        int r0 = CreationAppletUiHelper.a;
        Bundle r4 = r3.getArguments();
        int r1 = cy9.f.d;
        return new e29.e(cy9.f.a.a(r4).a, 0);
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final boolean f(final Fragment r4) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        int r0 = CreationAppletUiHelper.a;
        Bundle r1 = r4.getArguments();
        if (CreationAppletUiHelper.h(r1) == true) goto L5;
        CreationAppletUiHelper.PageExitBehavior r2 = CreationAppletUiHelper.PageExitBehavior.NATIVE_FINISH;
    L9:
        int r3 = b.a[r2.ordinal()];
        if (r3 != 1) goto L12;
        ICreationWorkflowService.a.H(new u(r4));
        return true;
    L12:
        if (r3 == 2) goto L19;
        if (r3 != 3) goto L17;
        return false;
    L17:
        throw new NoWhenBranchMatchedException();
    L19:
        if (ICreationWorkflowService.a.L() == true) goto L26;
        FragmentActivity r5 = r4.getActivity();
        if (r5 == null) goto L27;
        r5.finish();
        return true;
    L27:
        return true;
    L26:
        return true;
    L5:
        cy9.a.a.getClass();
        if (cy9.a.h(r1) == false) goto L8;
        r2 = CreationAppletUiHelper.PageExitBehavior.HOST_BACK;
        goto L9
    L8:
        r2 = CreationAppletUiHelper.PageExitBehavior.HOST_CLOSE;
        goto L9
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final boolean g(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        int r0 = CreationAppletUiHelper.a;
        return CreationAppletUiHelper.b(r2.getArguments(), r2.getActivity()).a;
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final boolean h(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        int r0 = CreationAppletUiHelper.a;
        return !CreationAppletUiHelper.f(r2.getArguments(), r2.getActivity());
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final boolean l(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        int r0 = CreationAppletUiHelper.a;
        Bundle r6 = r5.getArguments();
        Bundle r1 = cy9.a.a.c(r6);
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L13;
        if (r6 != null) goto L12;
        return true;
    L12:
        return r6.getBoolean("open_new_chat_page_on_send", true);
    L13:
        return r1.getBoolean("open_new_chat_page_on_send", true);
    L5:
        if (r1.containsKey("open_new_chat_page_on_send") != true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final void n(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        ICreationWorkflowService.a.R(r2);
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final UserCreation o(Bundle r1) {
        return cy9.e.b(r1);
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final e29.a p(Fragment r8) {
        Intrinsics.checkNotNullParameter(r8, "fragment");
        int r0 = CreationAppletUiHelper.a;
        t r9 = CreationAppletUiHelper.b(r8.getArguments(), r8.getActivity());
        boolean r1 = r9.a;
        boolean r2 = r9.b;
        int r3 = r9.c;
        if (r1 == false) goto L6;
        if (r2 == true) goto L6;
        int r4 = 2131240148;
    L7:
        if (r1 == false) goto L9;
        int r5 = 2131240142;
    L11:
        return new e29.a(r1, r2, r3, r4, r5);
    L9:
        r5 = 0;
    L6:
        r4 = 0;
        goto L7
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final void s(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        cy9.d.e(r2);
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final void b(Fragment r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        int r0 = CreationAppletUiHelper.a;
        FragmentActivity r1 = r2.getActivity();
        boolean r4 = !r3;
        if (CreationAppletUiHelper.f(r2.getArguments(), r1) == false) goto L21;
        if (r1 == null) goto L19;
        View r5 = CreationAppletUiHelper.d(r1, "applet_action_bar");
        if (r5 != null) goto L10;
        r5 = CreationAppletUiHelper.c(r1);
    L10:
        if (r5 == null) goto L22;
        if (r4 == false) goto L14;
        int r6 = 0;
    L16:
        if (r5.getVisibility() == r6) goto L20;
        r5.setVisibility(r6);
        return;
    L20:
        return;
    L14:
        r6 = 4;
        goto L16
    L22:
        return;
    L19:
        return;
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final void i(Fragment r3, UserCreation r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "userCreation");
        FragmentActivity r0 = r3.getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        IUgcAIGCService.Companion r1 = IUgcAIGCService.a;
        View r5 = r3.getView();
        if (r5 != null) goto L8;
        r5 = new View(r0);
    L8:
        IUgcAIGCService.a.a(r1, r4, r0, r5);
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final boolean j(Bundle r5, String r6) {
        UserCreation r0 = cy9.e.b(r5);
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r6 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
    L16:
        FLogger.a.i("DoubaoCommunityHostBehavior", "消费已插入 Feed 的宿主发布作品：" + r0.a);
        cy9.e.a(r5);
        return true;
    L14:
        if (Intrinsics.areEqual(r0.a, r6) == true) goto L16;
        return false;
    L8:
        if (r6.length() == 0) goto L11;
        r3 = false;
        goto L12
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final void k(FragmentActivity r9, UserCreation r10) {
        Intrinsics.checkNotNullParameter(r9, "currentActivity");
        Intrinsics.checkNotNullParameter(r10, "userCreation");
        UserCreation r1 = cy9.e.a;
        Intrinsics.checkNotNullParameter(r10, "userCreation");
        cy9.e.a = r10;
        cy9.e.b = System.currentTimeMillis();
        cy9.e.c = null;
        Iterator r2 = CollectionsKt.asReversed(AppHost.a.a().g()).iterator();
    L4:
        if (r2.hasNext() == false) goto L19;
        Object r3 = r2.next();
        FragmentActivity r5 = (Activity) r3;
        if (r5 != r9) goto L8;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L4;
    L21:
        if ((r3 instanceof FragmentActivity) == false) goto L23;
        FragmentActivity r4 = (FragmentActivity) r3;
    L24:
        if (r4 == null) goto L26;
        r9 = r4;
    L26:
        int r7 = gb9.a.a;
        Bundle r8 = new Bundle();
        r8.putBoolean("key_disable_initial_auto_refresh_once", true);
        r8.putBoolean("disable_ai_creation_home_restore", true);
        r8.putString("clear_dialog_fragment", "1");
        UserCreation r11 = cy9.e.a;
        Intrinsics.checkNotNullParameter(r8, "bundle");
        Intrinsics.checkNotNullParameter(r10, "userCreation");
        r8.putParcelable("ai_creation_applet_pending_user_creation", r10);
        Unit r0 = Unit.INSTANCE;
        if (gb9.a.a(r9, r8, "chat_action_bar") == true) goto L35;
        cy9.e.a(null);
        com.bytedance.router.i r12 = SmartRouter.buildRoute(r9, "//flow/community_create");
        r12.c.putExtra("is_side_bar", "1");
        r12.c.putExtra("clear_dialog_fragment", "1");
        r12.c.putExtra("creation", r10);
        r12.c.addFlags(67108864);
        r12.d();
        return;
    L35:
        return;
    L23:
        r4 = null;
        goto L24
    L8:
        if ((r5 instanceof FragmentActivity) == false) goto L16;
        FragmentActivity r13 = r5;
        if (r13.isFinishing() == true) goto L16;
        if (r13.isDestroyed() == true) goto L16;
        cy9.a.a.getClass();
        if (cy9.a.d(r5) == true) goto L16;
        r6 = true;
        goto L17
    L19:
        r3 = null;
        goto L21
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final boolean r(Context r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "arguments");
        cy9.a.a.getClass();
        if (cy9.a.e(r4) == true) goto L5;
    L8:
        boolean r0 = true;
    L10:
        return ICreationWorkflowService.a.O(r3, r4, r0);
    L5:
        if (cy9.a.g(r4) == true) goto L8;
        r0 = false;
        goto L10
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final boolean e(Fragment r7, UserCreation r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "fragment");
        String r0 = null;
        if (r8 == null) goto L7;
        AuthorInfo r1 = r8.g;
        if (r1 == null) goto L7;
        String r2 = r1.b;
    L8:
        int r3 = CreationAppletUiHelper.a;
        if (CreationAppletUiHelper.g(r7.getArguments(), r2) == true) goto L11;
    L13:
        Bundle r4 = r7.getArguments();
        if (CreationAppletUiHelper.h(r4) == false) goto L29;
        if (r2 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == true) goto L29;
        if (CreationAppletUiHelper.g(r4, r2) == true) goto L29;
        if (Intrinsics.areEqual(r2, r9) == false) goto L28;
        cy9.a.a.getClass();
        if (cy9.a.h(r4) == false) goto L29;
    L28:
        boolean r6 = true;
    L30:
        if (r6 == false) goto L39;
        ICreationWorkflowService.Companion r10 = ICreationWorkflowService.a;
        Context r11 = r7.requireContext();
        Bundle r12 = new Bundle();
        r12.putString("key_user_id", r2);
        if (r8 == null) goto L36;
        UserCreationTrackParams r13 = r8.n;
        if (r13 == null) goto L36;
        r0 = r13.a;
    L36:
        r12.putString("recommend_request_id", r0);
        r12.putString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "click_profile");
        Unit r14 = Unit.INSTANCE;
        if (r10.K(r11, r12) == false) goto L58;
        return true;
    L58:
        return false;
    L39:
        Bundle r15 = r7.getArguments();
        if (CreationAppletUiHelper.h(r15) == false) goto L53;
        cy9.a.a.getClass();
        if (cy9.a.g(r15) == false) goto L53;
        if (r2 != null) goto L45;
    L48:
        boolean r16 = true;
    L49:
        if (r16 == true) goto L53;
        if (Intrinsics.areEqual(r2, r9) == false) goto L53;
        boolean r17 = true;
    L54:
        if (r17 == false) goto L58;
        if (ICreationWorkflowService.a.d0(r7.requireContext()) == false) goto L58;
        return true;
    L45:
        if (r2.length() == 0) goto L48;
        r16 = false;
    L53:
        r17 = false;
        goto L54
    L17:
        if (r2.length() == 0) goto L20;
        r5 = false;
    L29:
        r6 = false;
        goto L30
    L11:
        if (ICreationWorkflowService.a.V() == false) goto L13;
        return true;
    L7:
        r2 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final boolean t(CreationDetailActivity r3, boolean r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "params");
        return ICreationWorkflowService.a.U(r3, r4, r5, true);
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final int u(CreationDetailFragment r2, ConstraintLayout r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        int r0 = CreationAppletUiHelper.a;
        Bundle r5 = r2.getArguments();
        int r1 = cy9.f.d;
        cy9.f r6 = cy9.f.a.a(r5);
        int r7 = cy9.b.a;
        int r8 = cy9.b.a(r3, c7.b(16));
        if (r6.a == true) goto L5;
        return r4;
    L5:
        return r8;
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final boolean q(Fragment r4, UserCreation r5, int r6, Bundle r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "userCreation");
        Intrinsics.checkNotNullParameter(r7, "detailArguments");
        int r0 = CreationAppletUiHelper.a;
        if (CreationAppletUiHelper.f(r4.getArguments(), r4.getActivity()) == false) goto L22;
        boolean r1 = true;
        if (r5.b == 1) goto L22;
        if (CollectionsKt.listOf(new Integer[]{4, 1}).contains(Integer.valueOf(r6)) == false) goto L22;
        Bundle r9 = r4.getArguments();
        Intrinsics.checkNotNullParameter(r7, "target");
        if (CreationAppletUiHelper.h(r9) == false) goto L18;
        if (r8 != null) goto L13;
    L16:
        if (r1 == true) goto L18;
        r7.putString("ai_creation_host_source_profile_user_id", r8);
        goto L18
    L13:
        if (r8.length() == 0) goto L16;
        r1 = false;
    L18:
        boolean r10 = ICreationWorkflowService.a.O(r4.requireContext(), r7, false);
        if (r10 == true) goto L21;
        FLogger.a.e("DoubaoCommunityHostBehavior", "从 Community Feed 打开豆包 AI 创作详情失败");
    L21:
        return r10;
    L22:
        return false;
    }

    @Override // com.larus.community.api.spi.ICommunityHostBehaviorProvider
    public final void m(Object r5, Fragment r6, UserCreation r7, String r8, Function0<Unit> r9, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r5, "owner");
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r9, "onSetPrivate");
        Intrinsics.checkNotNullParameter(r10, "onDelete");
        int r1 = CreationAppletUiHelper.a;
        Bundle r11 = r6.getArguments();
        if (r7 == null) goto L7;
        AuthorInfo r12 = r7.g;
        if (r12 == null) goto L7;
        String r13 = r12.b;
    L8:
        boolean r2 = false;
        if (CreationAppletUiHelper.h(r11) == true) goto L11;
    L26:
        if (r2 == false) goto L28;
        WeakReference r14 = cy9.d.a;
        cy9.d.a r15 = new cy9.d.a(r9, r10);
        Intrinsics.checkNotNullParameter(r5, "owner");
        Intrinsics.checkNotNullParameter(r15, "actions");
        cy9.d.a(r5);
        cy9.d.c = r15;
        cy9.d.d = null;
        return;
    L28:
        cy9.d.e(r5);
        return;
    L11:
        if (r13 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == true) goto L26;
        if (r8.length() != 0) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == true) goto L26;
        if (Intrinsics.areEqual(r13, r8) == false) goto L26;
        r2 = true;
        goto L26
    L21:
        r4 = false;
        goto L22
    L13:
        if (r13.length() == 0) goto L16;
        r3 = false;
    L7:
        r13 = null;
        goto L8
    }
}
