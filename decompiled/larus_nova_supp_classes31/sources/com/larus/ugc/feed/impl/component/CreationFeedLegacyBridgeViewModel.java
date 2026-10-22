package com.larus.ugc.feed.impl.component;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationModelKmp;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001&B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\r\u001a\u00020\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\b*\b\u0012\u0004\u0012\u00020\u00110\bH\u0002J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0016H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0016H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J(\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/ugc/feed/impl/component/CreationFeedLegacyBridgeViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/ugc/feed/impl/component/EmptyBridgeState;", "Lcom/larus/profile/api/model/ICreationFeedDataViewModel;", "<init>", "()V", "internalFeedLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/profile/api/bean/UserCreationModel;", "loadMoreCallback", "Lkotlin/Function0;", "", "setLoadMoreCallback", "callback", "projectFromKmp", "creationModelList", "Lcom/larus/ugc/feed/api/model/UserCreationModelKmp;", "moreState", "Lcom/larus/ugc/feed/api/state/LoadMoreState;", "toPlatformModelList", "getFeedDataLiveData", "Landroidx/lifecycle/LiveData;", "getMoreState", "Lcom/larus/profile/api/model/MoreState;", "checkLoadMore", "updateCreationContent", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "deleteUserCreation", "creationId", "", "modelAllDeleted", "", "updateCreationModelPrivacy", "privacy", "", "splitMode", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationFeedLegacyBridgeViewModel extends ComponentViewModel<EmptyBridgeState> implements gs9.e {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String TAG = "CreationFeedLegacyBridgeViewModel";
    private final MutableLiveData<List<UserCreationModel>> internalFeedLiveData;
    private Function0<Unit> loadMoreCallback;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    @Override // gs9.e
    public void checkLoadMore() {
        w0a.a.c(TAG, "checkLoadMore");
        Function0<Unit> r0 = this.loadMoreCallback;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    @Override // gs9.e
    public LiveData<gs9.i> getMoreState() {
        return new MutableLiveData();
    }

    public CreationFeedLegacyBridgeViewModel() {
        this.internalFeedLiveData = new MutableLiveData(CollectionsKt.emptyList());
    }

    @Override // gs9.e
    public LiveData<List<UserCreationModel>> getFeedDataLiveData() {
        return this.internalFeedLiveData;
    }

    private final List<UserCreationModel> toPlatformModelList(List<UserCreationModelKmp> r8) {
        List<UserCreationModelKmp> r9 = r8;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L20;
        UserCreationModelKmp r2 = (UserCreationModelKmp) r10.next();
        int r3 = r2.getDataType();
        int r4 = 1;
        if (r3 == 1) goto L10;
        r4 = 2;
        if (r3 == 2) goto L10;
        r4 = 0;
    L10:
        List<UserCreationKmp> r5 = r2.getCreationList();
        if (r5 == null) goto L18;
        List<UserCreationKmp> r6 = r5;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r11 = r6.iterator();
    L14:
        if (r11.hasNext() == false) goto L16;
        r7.add(com.larus.ugc.feed.impl.mapper.c.d((UserCreationKmp) r11.next()));
        goto L14
    L16:
        List r12 = CollectionsKt.toMutableList(r7);
        if (r12 == null) goto L18;
    L19:
        UserCreationModel r13 = new UserCreationModel(r4, r12, r2.getModelId());
        fs9.a0.c(r13);
        r0.add(r13);
    L18:
        r12 = new ArrayList();
        goto L19
    L20:
        return r0;
    }

    public final void setLoadMoreCallback(Function0<Unit> r1) {
        this.loadMoreCallback = r1;
    }

    @Override // gs9.e
    public void updateCreationContent(UserCreation r2) {
        Intrinsics.checkNotNullParameter(r2, "userCreation");
        w0a.a.c(TAG, "updateCreationContent delegated to Component → ability");
    }

    @Override // gs9.e
    public void deleteUserCreation(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "creationId");
        w0a.a.c(TAG, "deleteUserCreation delegated to Component → ability");
    }

    public final List<UserCreationModel> projectFromKmp(List<UserCreationModelKmp> r2, n0a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "creationModelList");
        Intrinsics.checkNotNullParameter(r3, "moreState");
        List<UserCreationModel> r4 = toPlatformModelList(r2);
        this.internalFeedLiveData.setValue(r4);
        return r4;
    }

    @Override // gs9.e
    public void updateCreationModelPrivacy(int r1, boolean r2, UserCreation r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "userCreation");
        w0a.a.c(TAG, "updateCreationModelPrivacy delegated to Component → ability");
    }
}
