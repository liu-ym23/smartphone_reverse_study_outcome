package com.larus.profile.api;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.larus.network.http.a;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import fs9.b0;
import fs9.x;
import gs9.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;
import r38.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 *2\u00020\u0001:\u0001*J$\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J(\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0004H&J\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001cH¦@¢\u0006\u0002\u0010!J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&H¦@¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0004H&J\b\u0010)\u001a\u00020\u0004H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006+"}, d2 = {"Lcom/larus/profile/api/IProfileApi;", "", "creationUpdateLive", "Landroidx/lifecycle/MutableLiveData;", "", "getCreationUpdateLive", "()Landroidx/lifecycle/MutableLiveData;", "collectionUpdateLive", "getCollectionUpdateLive", "userInfoFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/account/base/model/profile/UserInfo;", "getUserInfoFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "createPageMineTabFragment", "Lcom/larus/profile/api/model/IPageMineTabFragment;", "showCreationCallback", "Lkotlin/Function0;", "", "dismissCreationCallback", "createMineTabFragment", "Lcom/larus/common_ui/tab/TabChildFragment;", "createOtherProfileFragment", "Landroidx/fragment/app/Fragment;", "showProfileAvatarViewDialog", "activity", "Landroidx/fragment/app/FragmentActivity;", "avatarUrl", "", "enterFrom", "canEditProfile", "queryUserInfoWhenCacheEmpty", "source", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUserCreationList", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/UserCreationListResponse;", "request", "Lcom/larus/profile/api/bean/RequestCreationGroupData;", "(Lcom/larus/profile/api/bean/RequestCreationGroupData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasRevisitList", "hasLikeRevisitList", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IProfileApi {
    public static final Companion a = null;

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J%\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096A¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0096A¢\u0006\u0002\u0010\u001aJ)\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u000fH\u0096\u0001R\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/larus/profile/api/IProfileApi$Companion;", "Lcom/larus/profile/api/IProfileApi;", "<init>", "()V", "createMineTabFragment", "Lcom/larus/common_ui/tab/TabChildFragment;", "createOtherProfileFragment", "Landroidx/fragment/app/Fragment;", "createPageMineTabFragment", "Lcom/larus/profile/api/model/IPageMineTabFragment;", "showCreationCallback", "Lkotlin/Function0;", "", "dismissCreationCallback", "hasLikeRevisitList", "", "hasRevisitList", "queryUserInfoWhenCacheEmpty", "source", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUserCreationList", "Lcom/larus/network/http/Async;", "Lcom/larus/profile/api/bean/UserCreationListResponse;", "request", "Lcom/larus/profile/api/bean/RequestCreationGroupData;", "(Lcom/larus/profile/api/bean/RequestCreationGroupData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showProfileAvatarViewDialog", "activity", "Landroidx/fragment/app/FragmentActivity;", "avatarUrl", "enterFrom", "canEditProfile", "collectionUpdateLive", "Landroidx/lifecycle/MutableLiveData;", "getCollectionUpdateLive", "()Landroidx/lifecycle/MutableLiveData;", "creationUpdateLive", "getCreationUpdateLive", "userInfoFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/account/base/model/profile/UserInfo;", "getUserInfoFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IProfileApi {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IProfileApi b;

        static {
            c = new Companion();
        }

        @Override // com.larus.profile.api.IProfileApi
        public final Object a(x r2, Continuation<? super a<b0>> r3) {
            return this.b.a(r2, r3);
        }

        @Override // com.larus.profile.api.IProfileApi
        public final MutableSharedFlow<b> b() {
            return this.b.b();
        }

        @Override // com.larus.profile.api.IProfileApi
        public final void c(FragmentActivity r2, String r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "avatarUrl");
            Intrinsics.checkNotNullParameter(r4, "enterFrom");
            this.b.c(r2, r3, r4, r5);
        }

        @Override // com.larus.profile.api.IProfileApi
        public final s19.a d() {
            return this.b.d();
        }

        @Override // com.larus.profile.api.IProfileApi
        public final Object e(String r2, Continuation<? super Boolean> r3) {
            return this.b.e(r2, r3);
        }

        @Override // com.larus.profile.api.IProfileApi
        public final h f(Function0<Unit> r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "showCreationCallback");
            Intrinsics.checkNotNullParameter(r3, "dismissCreationCallback");
            return this.b.f(r2, r3);
        }

        @Override // com.larus.profile.api.IProfileApi
        public final boolean g() {
            return this.b.g();
        }

        @Override // com.larus.profile.api.IProfileApi
        public final MutableLiveData<Boolean> h() {
            return this.b.h();
        }

        @Override // com.larus.profile.api.IProfileApi
        public final boolean i() {
            return this.b.i();
        }

        @Override // com.larus.profile.api.IProfileApi
        public final MutableLiveData<Boolean> j() {
            return this.b.j();
        }

        private Companion() {
            this.b = (IProfileApi) ServiceManager.get().getService(IProfileApi.class);
        }
    }

    static {
        a = Companion.c;
    }

    Object a(x r1, Continuation<? super a<b0>> r2);

    MutableSharedFlow<b> b();

    void c(FragmentActivity r1, String r2, String r3, boolean r4);

    s19.a d();

    Object e(String r1, Continuation<? super Boolean> r2);

    h f(Function0<Unit> r1, Function0<Unit> r2);

    boolean g();

    MutableLiveData<Boolean> h();

    boolean i();

    MutableLiveData<Boolean> j();
}
