package com.larus.community.api.spi;

import android.content.Context;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.community.impl.detail.CreationDetailActivity;
import com.larus.community.impl.detail.CreationDetailFragment;
import com.larus.platform.api.creation.UserCreation;
import e29.a;
import e29.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J2\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010$\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0015H\u0016J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010)\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0012H\u0016JH\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010*\u001a\u0004\u0018\u00010\u00122\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030.H\u0016J\u0010\u00100\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0001H\u0016J\u0018\u00101\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u00104\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u0007H\u0016J!\u00106\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\b\u00105\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u00107¨\u00068"}, d2 = {"Lcom/larus/community/api/spi/ICommunityHostBehaviorProvider;", "", "onCreationPublishSuccess", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "handleCreationPublishLanding", "", "currentActivity", "Landroid/app/Activity;", "getPendingPublishedCreation", "arguments", "Landroid/os/Bundle;", "showPendingPublishedCreationNotice", "fragment", "Landroidx/fragment/app/Fragment;", "consumePendingPublishedCreation", "creationId", "", "openCreationDetailFromFeed", "creationFeedType", "", "detailArguments", "sourceProfileUserId", "openCreationDetailFromRoute", "context", "Landroid/content/Context;", "openChatBelowCommunityHostIfNeeded", "isChatDoublePage", "params", "getCommunityHostUiPolicy", "Lcom/larus/community/api/spi/CommunityHostUiPolicy;", "getCommunityCreatePageExtra", "shouldShowCreationFeedDebugLabel", "getCreationDetailChromePolicy", "Lcom/larus/community/api/spi/CommunityDetailChromePolicy;", "getCreationDetailBottomPadding", "rootView", "Landroid/view/View;", "nativeNavigationHeight", "handleCreationDetailExit", "handleCreationDetailAuthorClick", "currentUserId", "updateCreationDetailOwnerMenu", "owner", "onSetPrivate", "Lkotlin/Function0;", "onDelete", "clearCreationDetailOwnerMenu", "onCreationDetailFullscreenChanged", "isFullscreen", "shouldShowCreationDetailBottomShareAction", "getCreationDetailOpenNewChatPageOnSend", "defaultValue", "getCreationDetailDoSameLandingType", "(Landroidx/fragment/app/Fragment;Ljava/lang/Integer;)Ljava/lang/Integer;", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICommunityHostBehaviorProvider {
    Bundle a(Fragment r1);

    void b(Fragment r1, boolean r2);

    Integer c(Fragment r1);

    e d(Fragment r1);

    boolean e(Fragment r1, UserCreation r2, String r3);

    boolean f(Fragment r1);

    boolean g(Fragment r1);

    boolean h(Fragment r1);

    void i(Fragment r1, UserCreation r2);

    boolean j(Bundle r1, String r2);

    void k(FragmentActivity r1, UserCreation r2);

    boolean l(Fragment r1);

    void m(Object r1, Fragment r2, UserCreation r3, String r4, Function0<Unit> r5, Function0<Unit> r6);

    void n(UserCreation r1);

    UserCreation o(Bundle r1);

    a p(Fragment r1);

    boolean q(Fragment r1, UserCreation r2, int r3, Bundle r4, String r5);

    boolean r(Context r1, Bundle r2);

    void s(Object r1);

    boolean t(CreationDetailActivity r1, boolean r2, Bundle r3);

    int u(CreationDetailFragment r1, ConstraintLayout r2, int r3);
}
