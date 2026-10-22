package com.ss.android.lark.contact.customized.externalcontact.view;

import android.os.SystemClock;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.biz.im.api.l0;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader;
import com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u001a!\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020$J$\u0010;\u001a\u0002092\b\b\u0002\u0010)\u001a\u00020&2\b\b\u0002\u0010*\u001a\u00020&2\b\b\u0002\u0010+\u001a\u00020&J\u0010\u0010<\u001a\u0002092\b\b\u0002\u0010)\u001a\u00020&J\u0006\u0010=\u001a\u00020&J\u0006\u0010>\u001a\u000209J\u000e\u0010?\u001a\u0002092\u0006\u0010@\u001a\u00020\u0012J\u000e\u0010A\u001a\u0002092\u0006\u0010@\u001a\u00020$J\u0006\u0010B\u001a\u000209J\b\u0010C\u001a\u000209H\u0002J\b\u0010D\u001a\u000209H\u0014J\"\u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020&2\u0006\u0010G\u001a\u00020&2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b3\u0010/R\u001b\u00105\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00101\u001a\u0004\b6\u0010/¨\u0006K"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_doubaoContacts", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/contact/customized/common/model/StatefulModel;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactItemModel;", "doubaoContacts", "Landroidx/lifecycle/LiveData;", "getDoubaoContacts", "()Landroidx/lifecycle/LiveData;", "_enterpriseContacts", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeSubordinateItem;", "enterpriseContacts", "getEnterpriseContacts", "_openProfile", BuildConfig.FLAVOR, "openProfile", "getOpenProfile", "_newFriendBadge", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeNewFriendBadgeModel;", "newFriendBadge", "getNewFriendBadge", "newFriendBadgeListener", "com/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactViewModel$newFriendBadgeListener$1", "Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactViewModel$newFriendBadgeListener$1;", "_selfCardHeader", "Lcom/ss/android/lark/contact/customized/externalcontact/model/OfficeSelfCardHeaderModel;", "selfCardHeader", "getSelfCardHeader", "selfChatterPushListener", "com/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactViewModel$selfChatterPushListener$1", "Lcom/ss/android/lark/contact/customized/externalcontact/view/OfficeExternalContactViewModel$selfChatterPushListener$1;", "pageStartElapsed", BuildConfig.FLAVOR, "localPerfReported", BuildConfig.FLAVOR, "serverPerfReported", "firstPerfReported", "shouldLoadEnterpriseData", "isExternalContactScene", "shouldFetchNewFriendBadge", "personalLoader", "Lcom/ss/android/lark/contact/customized/externalcontact/data/BaseContactsLoader;", "getPersonalLoader", "()Lcom/ss/android/lark/contact/customized/externalcontact/data/BaseContactsLoader;", "personalLoader$delegate", "Lkotlin/Lazy;", "enterpriseLoader", "getEnterpriseLoader", "enterpriseLoader$delegate", "activeLoader", "getActiveLoader", "activeLoader$delegate", "onPageViewCreated", BuildConfig.FLAVOR, "startElapsed", "init", "fetchData", "canLoadMore", "loadMore", "onGotoContactProfileActivity", "chatterId", "deleteExternalContact", "fetchNewFriendBadge", "fetchSelfCardHeader", "onCleared", "reportPerf", "isCache", "isSucceed", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeExternalContactViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final String SCENE = "page_contact";
    private static final String TAG = "Contact_ExtContactVM";
    private final MutableLiveData<i9b.a<List<mtb.d>>> _doubaoContacts;
    private final MutableLiveData<i9b.a<List<mtb.m>>> _enterpriseContacts;
    private final MutableLiveData<mtb.k> _newFriendBadge;
    private final MutableLiveData<String> _openProfile;
    private final MutableLiveData<k9b.a> _selfCardHeader;
    private final Lazy activeLoader$delegate;
    private final LiveData<i9b.a<List<mtb.d>>> doubaoContacts;
    private final LiveData<i9b.a<List<mtb.m>>> enterpriseContacts;
    private final Lazy enterpriseLoader$delegate;
    private boolean firstPerfReported;
    private boolean isExternalContactScene;
    private boolean localPerfReported;
    private final LiveData<mtb.k> newFriendBadge;
    private final c newFriendBadgeListener;
    private final LiveData<String> openProfile;
    private long pageStartElapsed;
    private final Lazy personalLoader$delegate;
    private final LiveData<k9b.a> selfCardHeader;
    private final d selfChatterPushListener;
    private boolean serverPerfReported;
    private boolean shouldFetchNewFriendBadge;
    private boolean shouldLoadEnterpriseData;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ltb.a<mtb.k> {
        public final /* synthetic */ OfficeExternalContactViewModel a;

        public b(OfficeExternalContactViewModel r1) {
            this.a = r1;
        }

        public final void onSuccess(Object r3) {
            mtb.k r4 = (mtb.k) r3;
            Intrinsics.checkNotNullParameter(r4, Keys.API_RETURN_KEY_DATA);
            Log.i(OfficeExternalContactViewModel.TAG, "fetchNewFriendBadge success badge=" + r4);
            OfficeExternalContactViewModel.access$get_newFriendBadge$p(this.a).postValue(r4);
        }

        public final void onError(int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, ChameleonOpenTracker.ParamKey.ERRORMSG);
            Log.e(OfficeExternalContactViewModel.TAG, "fetchNewFriendBadge error code=" + r3 + " msg=" + r4);
        }
    }

    public static final class c implements ltb.b {
        public final /* synthetic */ OfficeExternalContactViewModel a;

        public c(OfficeExternalContactViewModel r1) {
            this.a = r1;
        }

        public final void a(mtb.k r3) {
            Intrinsics.checkNotNullParameter(r3, "badge");
            Log.i(OfficeExternalContactViewModel.TAG, "onNewFriendBadgeChanged badge=" + r3);
            OfficeExternalContactViewModel.access$get_newFriendBadge$p(this.a).setValue(r3);
        }
    }

    public static final class d implements l0 {
        public final /* synthetic */ OfficeExternalContactViewModel a;

        public d(OfficeExternalContactViewModel r1) {
            this.a = r1;
        }

        public final void a(Chatter r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            String r0 = com.ss.android.lark.chat.utils.m.b(r5, ChatterNameDisplayRule.NAME, false);
            String r1 = r5.getAvatarKey();
            Log.i(OfficeExternalContactViewModel.TAG, "selfChatterPushListener name=" + r0 + " avatarKey=" + r1);
            MutableLiveData r2 = OfficeExternalContactViewModel.access$get_selfCardHeader$p(this.a);
            String r6 = r5.getId();
            Intrinsics.checkNotNull(r0);
            r2.postValue(new k9b.a(r6, r0, r1));
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    private final BaseContactsLoader getActiveLoader() {
        return (BaseContactsLoader) this.activeLoader$delegate.getValue();
    }

    private final BaseContactsLoader getEnterpriseLoader() {
        return (BaseContactsLoader) this.enterpriseLoader$delegate.getValue();
    }

    private final BaseContactsLoader getPersonalLoader() {
        return (BaseContactsLoader) this.personalLoader$delegate.getValue();
    }

    public final void fetchNewFriendBadge() {
        Lazy r0 = NewFriendBadgeRepository.a;
        NewFriendBadgeRepository.a(NewFriendBadgeRepository.Source.INTERNAL, new b(this));
    }

    public OfficeExternalContactViewModel() {
        MutableLiveData<i9b.a<List<mtb.d>>> r0 = new MutableLiveData();
        this._doubaoContacts = r0;
        this.doubaoContacts = r0;
        MutableLiveData<i9b.a<List<mtb.m>>> r1 = new MutableLiveData();
        this._enterpriseContacts = r1;
        this.enterpriseContacts = r1;
        MutableLiveData<String> r2 = new MutableLiveData();
        this._openProfile = r2;
        this.openProfile = r2;
        MutableLiveData<mtb.k> r3 = new MutableLiveData();
        this._newFriendBadge = r3;
        this.newFriendBadge = r3;
        this.newFriendBadgeListener = new c(this);
        MutableLiveData<k9b.a> r4 = new MutableLiveData();
        this._selfCardHeader = r4;
        this.selfCardHeader = r4;
        this.selfChatterPushListener = new d(this);
        this.personalLoader$delegate = LazyKt.lazy(new OfficeExternalContactViewModel$personalLoader$2(this));
        this.enterpriseLoader$delegate = LazyKt.lazy(new OfficeExternalContactViewModel$enterpriseLoader$2(this));
        this.activeLoader$delegate = LazyKt.lazy(new OfficeExternalContactViewModel$activeLoader$2(this));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactViewModel$fetchSelfCardHeader$1] */
    private final void fetchSelfCardHeader() {
        ImSdkService.d().W8(new AnonymousClass1(this));
    }

    public final boolean canLoadMore() {
        getActiveLoader().getClass();
        return false;
    }

    public final void loadMore() {
        getActiveLoader().d();
    }

    public void onCleared() {
        getActiveLoader().e();
        ImSdkService.c().A5(this.selfChatterPushListener);
        Lazy r0 = NewFriendBadgeRepository.a;
        c r1 = this.newFriendBadgeListener;
        Intrinsics.checkNotNullParameter(r1, "listener");
        Log.i("Contact_NewFriendBadge", "removeListener");
        com.ss.android.lark.sdk.f.b((CopyOnWriteArrayList) NewFriendBadgeRepository.a.getValue(), r1, com.ss.android.lark.contact.customized.externalcontact.repository.d.a);
        super.onCleared();
    }

    public final LiveData<i9b.a<List<mtb.d>>> getDoubaoContacts() {
        return this.doubaoContacts;
    }

    public final LiveData<i9b.a<List<mtb.m>>> getEnterpriseContacts() {
        return this.enterpriseContacts;
    }

    public final LiveData<mtb.k> getNewFriendBadge() {
        return this.newFriendBadge;
    }

    public final LiveData<String> getOpenProfile() {
        return this.openProfile;
    }

    public final LiveData<k9b.a> getSelfCardHeader() {
        return this.selfCardHeader;
    }

    public static final /* synthetic */ BaseContactsLoader access$getEnterpriseLoader(OfficeExternalContactViewModel r0) {
        return r0.getEnterpriseLoader();
    }

    public static final /* synthetic */ BaseContactsLoader access$getPersonalLoader(OfficeExternalContactViewModel r0) {
        return r0.getPersonalLoader();
    }

    public static final /* synthetic */ boolean access$getShouldLoadEnterpriseData$p(OfficeExternalContactViewModel r0) {
        return r0.shouldLoadEnterpriseData;
    }

    public static final /* synthetic */ MutableLiveData access$get_doubaoContacts$p(OfficeExternalContactViewModel r0) {
        return r0._doubaoContacts;
    }

    public static final /* synthetic */ MutableLiveData access$get_enterpriseContacts$p(OfficeExternalContactViewModel r0) {
        return r0._enterpriseContacts;
    }

    public static final /* synthetic */ MutableLiveData access$get_newFriendBadge$p(OfficeExternalContactViewModel r0) {
        return r0._newFriendBadge;
    }

    public static final /* synthetic */ MutableLiveData access$get_selfCardHeader$p(OfficeExternalContactViewModel r0) {
        return r0._selfCardHeader;
    }

    public final void deleteExternalContact(long r2) {
        getActiveLoader().a(r2);
    }

    public final void fetchData(boolean r3) {
        this.shouldLoadEnterpriseData = r3;
        Log.i(TAG, "fetch data shouldLoadEnterpriseData=" + r3);
        if (this.isExternalContactScene == true) goto L6;
        fetchSelfCardHeader();
    L6:
        if (this.shouldFetchNewFriendBadge == false) goto L8;
        fetchNewFriendBadge();
    L8:
        getActiveLoader().b();
    }

    public final void onGotoContactProfileActivity(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        this._openProfile.setValue(r2);
    }

    public final void onPageViewCreated(long r1) {
        this.pageStartElapsed = r1;
        this.localPerfReported = false;
        this.serverPerfReported = false;
        this.firstPerfReported = false;
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

    public final void init(boolean r1, boolean r2, boolean r3) {
        this.shouldLoadEnterpriseData = r1;
        this.isExternalContactScene = r2;
        this.shouldFetchNewFriendBadge = r3;
        if (r2 == true) goto L5;
        ImSdkService.c().r8(this.selfChatterPushListener);
    L5:
        if (r3 == false) goto L7;
        Lazy r4 = NewFriendBadgeRepository.a;
        c r5 = this.newFriendBadgeListener;
        Intrinsics.checkNotNullParameter(r5, "listener");
        Log.i("Contact_NewFriendBadge", "addListener");
        com.ss.android.lark.sdk.f.a((CopyOnWriteArrayList) NewFriendBadgeRepository.a.getValue(), r5, com.ss.android.lark.contact.customized.externalcontact.repository.c.a);
    L7:
        getActiveLoader().c();
    }

    public static final /* synthetic */ void access$reportPerf(OfficeExternalContactViewModel r0, boolean r1, boolean r2, ErrorResult r3) {
        r0.reportPerf(r1, r2, r3);
    }

    public static /* synthetic */ void fetchData$default(OfficeExternalContactViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.fetchData(r1);
    }

    public static /* synthetic */ void init$default(OfficeExternalContactViewModel r1, boolean r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = false;
    L11:
        r1.init(r2, r3, r4);
    }
}
