package com.larus.profile.impl;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.collection.profile.api.CollectServiceDelegate;
import com.larus.account.base.api.IAccountService;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.platform.service.AccountService;
import com.larus.profile.api.IProfileApi;
import com.larus.profile.impl.mine.MineTabFragment;
import com.larus.profile.impl.mine.PageMineTabFragment;
import com.larus.profile.impl.view.ProfileAvatarViewerDialog;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J(\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\fH\u0016J\u0016\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020$H\u0096@¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020.H\u0096@¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\fH\u0016J\b\u00101\u001a\u00020\fH\u0016J\b\u00102\u001a\u00020\fH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u00064"}, d2 = {"Lcom/larus/profile/impl/ProfileServiceImpl;", "Lcom/larus/profile/api/IProfileApi;", "<init>", "()V", "collectListStyle", "", "getCollectListStyle", "()I", "collectListStyle$delegate", "Lkotlin/Lazy;", "creationUpdateLive", "Landroidx/lifecycle/MutableLiveData;", "", "getCreationUpdateLive", "()Landroidx/lifecycle/MutableLiveData;", "collectionUpdateLive", "getCollectionUpdateLive", "userInfoFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/account/base/model/profile/UserInfo;", "getUserInfoFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "createPageMineTabFragment", "Lcom/larus/profile/api/model/IPageMineTabFragment;", "showCreationCallback", "Lkotlin/Function0;", "", "dismissCreationCallback", "createMineTabFragment", "Lcom/larus/common_ui/tab/TabChildFragment;", "createOtherProfileFragment", "Landroidx/fragment/app/Fragment;", "showProfileAvatarViewDialog", "activity", "Landroidx/fragment/app/FragmentActivity;", "avatarUrl", "", "enterFrom", "canEditProfile", "queryUserInfoWhenCacheEmpty", "source", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUserCreationList", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/UserCreationListResponse;", "request", "Lcom/larus/profile/api/bean/RequestCreationGroupData;", "(Lcom/larus/profile/api/bean/RequestCreationGroupData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasRevisitList", "hasLikeRevisitList", "baseProfileEnable", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileServiceImpl implements IProfileApi {
    public static final /* synthetic */ int f = 0;
    public final Lazy b;
    public final MutableLiveData<Boolean> c;
    public final MutableLiveData<Boolean> d;
    public final MutableSharedFlow<r38.b> e;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.profile.api.IProfileApi
    public final s19.a d() {
        return new MineTabFragment();
    }

    @Override // com.larus.profile.api.IProfileApi
    public final boolean g() {
        int r0 = ((Number) this.b.getValue()).intValue();
        if (r0 == 1) goto L8;
        if (r0 == 2) goto L8;
        return CollectServiceDelegate.b.a();
    L8:
        return CollectServiceDelegate.b.k();
    }

    @Override // com.larus.profile.api.IProfileApi
    public final boolean i() {
        int r0 = ((Number) this.b.getValue()).intValue();
        if (r0 == 1) goto L8;
        if (r0 == 2) goto L8;
        return false;
    L8:
        return CollectServiceDelegate.b.k();
    }

    public ProfileServiceImpl() {
        this.b = LazyKt.lazy(new f2());
        this.c = new MutableLiveData();
        this.d = new MutableLiveData();
        this.e = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
    }

    @Override // com.larus.profile.api.IProfileApi
    public final MutableSharedFlow<r38.b> b() {
        return this.e;
    }

    @Override // com.larus.profile.api.IProfileApi
    public final MutableLiveData<Boolean> h() {
        return this.c;
    }

    @Override // com.larus.profile.api.IProfileApi
    public final MutableLiveData<Boolean> j() {
        return this.d;
    }

    @Override // com.larus.profile.api.IProfileApi
    public final Object a(fs9.x r2, Continuation<? super com.larus.network.http.a<fs9.b0>> r3) {
        Lazy<ProfileRepo> r0 = ProfileRepo.b;
        ProfileRepo.a.a().getClass();
        return ProfileRepo.d(r2, r3);
    }

    @Override // com.larus.profile.api.IProfileApi
    public final Object e(String r21, Continuation<? super Boolean> r22) {
        String r1 = r21;
        if ((r22 instanceof ProfileServiceImpl$queryUserInfoWhenCacheEmpty$1) == false) goto L7;
        ProfileServiceImpl$queryUserInfoWhenCacheEmpty$1 r3 = (ProfileServiceImpl$queryUserInfoWhenCacheEmpty$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r3.label;
        boolean r16 = false;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        ResultKt.throwOnFailure(r2);
    L49:
        r16 = ((Boolean) r2).booleanValue();
    L52:
        return Boxing.boxBoolean(r16);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
        String r6 = "ProfileServiceImpl";
    L45:
        if ((((com.larus.network.http.a) r2) instanceof com.larus.network.http.y) == false) goto L50;
        FLogger.a.i(r6, "updateDefaultProfile success");
        String r7 = ProfileRequestSource.LAZY_LOAD.getValue();
        r3.label = 3;
        r2 = e(r7, r3);
        if (r2 != r15) goto L49;
        return r15;
    L50:
        FLogger.a.i(r6, "updateDefaultProfile fail");
        goto L52
    L17:
        r1 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Object r8 = r2;
        int r9 = 2;
        boolean r19 = true;
    L25:
        com.larus.network.http.y r10 = (com.larus.network.http.a) r8;
        if ((r10 instanceof com.larus.network.http.y) == false) goto L36;
        fs9.s r11 = (fs9.s) ((com.larus.network.http.a) r10).b;
        if (r11 == null) goto L34;
        r38.b r12 = r11.b();
        if (r12 == null) goto L34;
        IAccountService.Companion r13 = IAccountService.a;
        r13.l(r12);
        r13.o(AccountService.a.getUserId(), r12.c(), r1);
        return Boxing.boxBoolean(r19);
    L34:
        return Boxing.boxBoolean(false);
    L36:
        if ((r10 instanceof com.larus.network.http.f) == false) goto L54;
        if (((com.larus.network.http.f) r10).d.getCode() != 710012014) goto L54;
        if (Intrinsics.areEqual(r1, "settings_page") == false) goto L54;
        r6 = "ProfileServiceImpl";
        FLogger.a.i(r6, "queryUserInfoWhenCacheEmpty fail with USER_NOT_EXISTS, try to update default profile");
        Lazy<ProfileRepo> r14 = ProfileRepo.b;
        ProfileRepo r17 = ProfileRepo.a.a();
        r3.L$0 = null;
        r3.label = r9;
        r17.getClass();
        r2 = ProfileRepo.g(r3);
        if (r2 != r15) goto L45;
        return r15;
    L54:
        return Boxing.boxBoolean(false);
    L18:
        ResultKt.throwOnFailure(r2);
        if (IAccountService.a.getUserInfo() != null) goto L21;
        FlowDowngradeServiceDelegate r18 = FlowDowngradeServiceDelegate.INSTANCE;
        JSONObject r20 = new JSONObject();
        Map r110 = MapsKt.mapOf(TuplesKt.to("source", r1));
        r3.L$0 = r1;
        r3.label = 1;
        r9 = 2;
        r19 = true;
        r8 = IFlowDowngradeService.a.b(r18, "Social", fs9.s.class, "/alice/profile/self_brief", r20, null, false, null, r110, r3, 1008);
        if (r8 != r15) goto L25;
        return r15;
    L21:
        return Boxing.boxBoolean(true);
    L7:
        r3 = new ProfileServiceImpl$queryUserInfoWhenCacheEmpty$1(this, r22);
        goto L8
    }

    @Override // com.larus.profile.api.IProfileApi
    public final gs9.h f(Function0<Unit> r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "showCreationCallback");
        Intrinsics.checkNotNullParameter(r3, "dismissCreationCallback");
        PageMineTabFragment r0 = new PageMineTabFragment();
        r0.E = r2;
        r0.F = r3;
        return r0;
    }

    @Override // com.larus.profile.api.IProfileApi
    public final void c(FragmentActivity r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "avatarUrl");
        Intrinsics.checkNotNullParameter(r4, "enterFrom");
        ProfileAvatarViewerDialog r0 = new ProfileAvatarViewerDialog(r2, r3, r4, r5);
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }
}
