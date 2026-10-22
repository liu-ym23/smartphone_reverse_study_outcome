package com.ss.android.lark.contact.customized.newcontact.viewmodel;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.lark.pb.basic.v1.Command;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.contact.base.entity.ExternalContactSummary;
import com.ss.android.lark.contact.base.service.d;
import com.ss.android.lark.contact.base.service.n;
import com.ss.android.lark.contact.base.service.q;
import com.ss.android.lark.contact.customized.newcontact.repository.OfficeNewContactRepository$deleteFriendRequest$1;
import com.ss.android.lark.contact.customized.newcontact.repository.OfficeNewContactRepository$getFriendRequestsFromServer$1;
import com.ss.android.lark.contact.customized.newcontact.repository.OfficeNewContactRepository$loadInitialFromLocal$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.f;
import com.ss.android.lark.sdk.g;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\nJ\u0006\u0010+\u001a\u00020)J\u0006\u0010,\u001a\u00020\u0007J\u0006\u0010-\u001a\u00020)J\u000e\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u0012J\u0016\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020%J\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0011H\u0002J\u0010\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u000205H\u0002J\b\u00108\u001a\u00020)H\u0014J\"\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010=H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00110\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\"\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010$0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010&\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010$0\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016¨\u0006@"}, d2 = {"Lcom/ss/android/lark/contact/customized/newcontact/viewmodel/OfficeNewContactViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "repository", "Lcom/ss/android/lark/contact/customized/newcontact/repository/OfficeNewContactRepository;", "serverDisplayed", BuildConfig.FLAVOR, "anyDisplayed", "pageStartElapsed", BuildConfig.FLAVOR, "localPerfReported", "serverPerfReported", "firstPerfReported", "_friendRequests", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/contact/customized/common/model/StatefulModel;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/contact/base/contact_new/mvp/NewContactView$FriendRequestViewData;", "friendRequests", "Landroidx/lifecycle/LiveData;", "getFriendRequests", "()Landroidx/lifecycle/LiveData;", "_showEmptyView", "showEmptyView", "getShowEmptyView", "_updateFriendRequests", "updateFriendRequests", "getUpdateFriendRequests", "_loadMoreFinished", "loadMoreFinished", "getLoadMoreFinished", "_removeFriendRequest", "removeFriendRequest", "getRemoveFriendRequest", "_openProfile", "Lkotlin/Pair;", BuildConfig.FLAVOR, "openProfile", "getOpenProfile", "onPageViewCreated", BuildConfig.FLAVOR, "startElapsed", "loadInitial", "canLoadMore", "loadMore", "onFriendRequestDeleted", "viewData", "onClickFriendRequest", "userId", "friendRequestId", "parseToViewDataList", "chatApplications", "Lcom/ss/android/lark/contact/base/dto/ChatApplication;", "parseToViewData", "chatApplication", "onCleared", "reportPerf", "isCache", "isSucceed", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "Companion", "ModelDelegate", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeNewContactViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String SCENE = "page_new_contact";
    private static final String TAG = "Contact_NewContactVM";
    private final MutableLiveData<i9b.a<List<NewContactView.a>>> _friendRequests;
    private final MutableLiveData<Boolean> _loadMoreFinished;
    private final MutableLiveData<Pair<String, String>> _openProfile;
    private final MutableLiveData<NewContactView.a> _removeFriendRequest;
    private final MutableLiveData<Boolean> _showEmptyView;
    private final MutableLiveData<List<NewContactView.a>> _updateFriendRequests;
    private boolean anyDisplayed;
    private boolean firstPerfReported;
    private final LiveData<i9b.a<List<NewContactView.a>>> friendRequests;
    private final LiveData<Boolean> loadMoreFinished;
    private boolean localPerfReported;
    private final LiveData<Pair<String, String>> openProfile;
    private long pageStartElapsed;
    private final LiveData<NewContactView.a> removeFriendRequest;
    private final com.ss.android.lark.contact.customized.newcontact.repository.a repository;
    private boolean serverDisplayed;
    private boolean serverPerfReported;
    private final LiveData<Boolean> showEmptyView;
    private final LiveData<List<NewContactView.a>> updateFriendRequests;

    public static final class a {
        public a() {
        }
    }

    public final class b implements com.ss.android.lark.contact.base.contact_new.mvp.a.InterfaceC0166a {
        public final /* synthetic */ OfficeNewContactViewModel a;

        public static final class a implements Runnable {
            public final /* synthetic */ OfficeNewContactViewModel a;
            public final /* synthetic */ List<ChatApplication> b;

            /* JADX WARN: Multi-variable type inference failed */
            public a(OfficeNewContactViewModel r1, List<? extends ChatApplication> r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                OfficeNewContactViewModel.access$get_updateFriendRequests$p(this.a).setValue(OfficeNewContactViewModel.access$parseToViewDataList(this.a, this.b));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(OfficeNewContactViewModel r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.contact.base.contact_new.mvp.a.InterfaceC0166a
        public final void a(List<? extends ChatApplication> r3) {
            Intrinsics.checkNotNullParameter(r3, "chatApplications");
            Log.i(OfficeNewContactViewModel.TAG, "onUpdateFriendRequest=" + r3.size());
            UICallbackExecutor.execute(new a(this.a, r3));
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public final boolean canLoadMore() {
        return this.repository.a;
    }

    public final void loadInitial() {
        this._friendRequests.setValue(i9b.a.b.a);
        this.serverDisplayed = false;
        this.anyDisplayed = false;
        final UIGetDataCallback r1 = new UIGetDataCallback(new OfficeNewContactViewModel$loadInitial$localCallback$1(this));
        UIGetDataCallback r2 = new UIGetDataCallback(new OfficeNewContactViewModel$loadInitial$serverCallback$1(this));
        this.repository.getClass();
        Intrinsics.checkNotNullParameter(r1, "callback");
        int r4 = d.a;
        d.c(DocTabPayload.DocType.UNKNOWN, true, true, new OfficeNewContactRepository$loadInitialFromLocal$1(r1));
        com.ss.android.lark.contact.customized.newcontact.repository.a r5 = this.repository;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r2, "callback");
        r5.c = DocTabPayload.DocType.UNKNOWN;
        r5.a = true;
        ((ArrayList) r5.d).clear();
        if (r5.b == true) goto L7;
        r5.b = true;
        d.c(r5.c, false, true, new OfficeNewContactRepository$getFriendRequestsFromServer$1(r5, r2));
        return;
    }

    public final void loadMore() {
        UIGetDataCallback r0 = new UIGetDataCallback(new OfficeNewContactViewModel$loadMore$requestCallback$1(this));
        com.ss.android.lark.contact.customized.newcontact.repository.a r1 = this.repository;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "callback");
        if (r1.b == true) goto L7;
        r1.b = true;
        int r2 = d.a;
        d.c(r1.c, false, false, new OfficeNewContactRepository$getFriendRequestsFromServer$1(r1, r0));
        return;
    }

    public void onCleared() {
        com.ss.android.lark.contact.customized.newcontact.repository.a r0 = this.repository;
        r0.getClass();
        q r1 = q.a.a;
        com.ss.android.lark.contact.customized.newcontact.repository.a.b r2 = r0.f;
        List<f9b.a> r3 = r1.a;
        if (r2 == null) goto L19;
        monitor-enter(r3);
        CopyOnWriteArrayList r4 = (CopyOnWriteArrayList) r3;     // Catch: Throwable -> L21
        r4.remove(r2);     // Catch: Throwable -> L21
        monitor-exit(r3);     // Catch: Throwable -> L21
        if (r4.isEmpty() == false) goto L19;
        monitor-enter(r3);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (r4.isEmpty() == false) goto L14;
        g.e.a.c(Command.PUSH_CHAT_APPLICATIONS);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r3);     // Catch: Throwable -> L16
    L21:
        th = move-exception;
        throw th;
    L19:
        r0.e = null;
        super.onCleared();
    }

    public OfficeNewContactViewModel() {
        com.ss.android.lark.contact.customized.newcontact.repository.a r0 = new com.ss.android.lark.contact.customized.newcontact.repository.a();
        this.repository = r0;
        MutableLiveData<i9b.a<List<NewContactView.a>>> r1 = new MutableLiveData();
        this._friendRequests = r1;
        this.friendRequests = r1;
        MutableLiveData<Boolean> r2 = new MutableLiveData();
        this._showEmptyView = r2;
        this.showEmptyView = r2;
        MutableLiveData<List<NewContactView.a>> r3 = new MutableLiveData();
        this._updateFriendRequests = r3;
        this.updateFriendRequests = r3;
        MutableLiveData<Boolean> r4 = new MutableLiveData();
        this._loadMoreFinished = r4;
        this.loadMoreFinished = r4;
        MutableLiveData<NewContactView.a> r5 = new MutableLiveData();
        this._removeFriendRequest = r5;
        this.removeFriendRequest = r5;
        MutableLiveData<Pair<String, String>> r6 = new MutableLiveData();
        this._openProfile = r6;
        this.openProfile = r6;
        r0.e = new b(this);
        q r7 = q.a.a;
        com.ss.android.lark.contact.customized.newcontact.repository.a.b r8 = r0.f;
        f.a(r7.a, r8, new n(r7));
    }

    public final LiveData<i9b.a<List<NewContactView.a>>> getFriendRequests() {
        return this.friendRequests;
    }

    public final LiveData<Boolean> getLoadMoreFinished() {
        return this.loadMoreFinished;
    }

    public final LiveData<Pair<String, String>> getOpenProfile() {
        return this.openProfile;
    }

    public final LiveData<NewContactView.a> getRemoveFriendRequest() {
        return this.removeFriendRequest;
    }

    public final LiveData<Boolean> getShowEmptyView() {
        return this.showEmptyView;
    }

    public final LiveData<List<NewContactView.a>> getUpdateFriendRequests() {
        return this.updateFriendRequests;
    }

    public static final /* synthetic */ boolean access$getAnyDisplayed$p(OfficeNewContactViewModel r0) {
        return r0.anyDisplayed;
    }

    public static final /* synthetic */ com.ss.android.lark.contact.customized.newcontact.repository.a access$getRepository$p(OfficeNewContactViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ boolean access$getServerDisplayed$p(OfficeNewContactViewModel r0) {
        return r0.serverDisplayed;
    }

    public static final /* synthetic */ MutableLiveData access$get_friendRequests$p(OfficeNewContactViewModel r0) {
        return r0._friendRequests;
    }

    public static final /* synthetic */ MutableLiveData access$get_loadMoreFinished$p(OfficeNewContactViewModel r0) {
        return r0._loadMoreFinished;
    }

    public static final /* synthetic */ MutableLiveData access$get_removeFriendRequest$p(OfficeNewContactViewModel r0) {
        return r0._removeFriendRequest;
    }

    public static final /* synthetic */ MutableLiveData access$get_showEmptyView$p(OfficeNewContactViewModel r0) {
        return r0._showEmptyView;
    }

    public static final /* synthetic */ MutableLiveData access$get_updateFriendRequests$p(OfficeNewContactViewModel r0) {
        return r0._updateFriendRequests;
    }

    private final NewContactView.a parseToViewData(ChatApplication r5) {
        ExternalContactSummary r0 = r5.getExternalContactSummary();
        NewContactView.a r1 = new NewContactView.a();
        r1.c = r0.getAvatarKey();
        r1.d = m.c(r0.getI18nName(), r0.getUserName());
        r1.a = r5.getId();
        r1.b = r0.getUseId();
        r1.e = r0.getTenantName();
        r1.f = r0.getTenantNameStatus();
        r1.g = r5.getExtraMessage();
        r1.h = r5.getStatus();
        r1.i = r5.getCertificationInfo();
        return r1;
    }

    private final List<NewContactView.a> parseToViewDataList(List<? extends ChatApplication> r3) {
        ArrayList r0 = new ArrayList();
        if (r3 == null) goto L11;
        Iterator<? extends ChatApplication> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        ChatApplication r1 = r4.next();
        Intrinsics.checkNotNull(r1);
        NewContactView.a r2 = access$parseToViewData(this, r1);
        if (r2 == null) goto L6;
        r0.add(r2);
    L11:
        return CollectionsKt.filterNotNull(r0);
    }

    public final void onFriendRequestDeleted(final NewContactView.a r5) {
        Intrinsics.checkNotNullParameter(r5, "viewData");
        final com.ss.android.lark.contact.customized.newcontact.repository.a r0 = this.repository;
        final String r1 = r5.a;
        final UIGetDataCallback r2 = new UIGetDataCallback(new AnonymousClass1(this, r5));
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "friendRequestId");
        Intrinsics.checkNotNullParameter(r2, "callback");
        int r6 = d.a;
        IGetDataCallback<Boolean> r7 = new OfficeNewContactRepository$deleteFriendRequest$1(r0, r1, r2);
        d.d(r1, ChatApplication.Status.DELETED, Boolean.FALSE, r7);
    }

    public final void onPageViewCreated(long r1) {
        this.pageStartElapsed = r1;
        this.localPerfReported = false;
        this.serverPerfReported = false;
        this.firstPerfReported = false;
    }

    public static final /* synthetic */ NewContactView.a access$parseToViewData(OfficeNewContactViewModel r0, ChatApplication r1) {
        return r0.parseToViewData(r1);
    }

    public static final /* synthetic */ List access$parseToViewDataList(OfficeNewContactViewModel r0, List r1) {
        return r0.parseToViewDataList(r1);
    }

    public static final /* synthetic */ void access$setAnyDisplayed$p(OfficeNewContactViewModel r0, boolean r1) {
        r0.anyDisplayed = r1;
    }

    public static final /* synthetic */ void access$setServerDisplayed$p(OfficeNewContactViewModel r0, boolean r1) {
        r0.serverDisplayed = r1;
    }

    public final void onClickFriendRequest(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "friendRequestId");
        this._openProfile.setValue(TuplesKt.to(r2, r3));
    }

    private final void reportPerf(boolean r10, boolean r11, ErrorResult r12) {
        if (this.pageStartElapsed > 0) goto L6;
        return;
    L6:
        if (r10 == false) goto L12;
        if (this.localPerfReported == false) goto L10;
        return;
    L10:
        this.localPerfReported = true;
    L15:
        boolean r8 = !this.firstPerfReported;
        if (r8 == false) goto L18;
        this.firstPerfReported = true;
    L18:
        int r0 = com.ss.android.lark.contact.customized.common.a.a;
        com.ss.android.lark.contact.customized.common.a.a(SCENE, SystemClock.elapsedRealtime() - this.pageStartElapsed, r11, r12, r10, r8);
        return;
    L12:
        if (this.serverPerfReported == false) goto L14;
        return;
    L14:
        this.serverPerfReported = true;
        goto L15
    }

    public static final /* synthetic */ void access$reportPerf(OfficeNewContactViewModel r0, boolean r1, boolean r2, ErrorResult r3) {
        r0.reportPerf(r1, r2, r3);
    }
}
