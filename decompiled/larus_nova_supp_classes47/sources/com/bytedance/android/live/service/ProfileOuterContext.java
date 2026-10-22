package com.bytedance.android.live.service;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.live.service.prerequest.f;
import com.bytedance.android.live.service.prerequest.g;
import com.bytedance.android.live.service.prerequest.h;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import ps0.c;
import ps0.d;
import rs0.q0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u000f\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R2\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110\u001aj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0011`\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b+\u0010,R\"\u0010/\u001a\u00020.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020.8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u00100\u001a\u0004\b6\u00102\"\u0004\b7\u00104¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/service/ProfileOuterContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lns0/a;", "Lua1/a;", "", "destroy", "", "uid", "clearData", "", "getTimeAfterEnterRoom", "Landroid/view/View;", "anchorView", "noticeGroupPurchaseShowing", "", "showAnchorSetButtonRedDot", "noticeAnchorSetButtonClick", "Lps0/c;", Constants.Keys.DATA, "setPersonCardData", "getPersonCardData", "Landroid/content/Context;", "context", "schema", "prepareTransitionDialogRequest", "openTransitionDialog", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "personCardDataMap", "Ljava/util/HashMap;", "Lcom/bytedance/android/live/service/prerequest/b;", "preRequestManager$delegate", "Lkotlin/Lazy;", "getPreRequestManager", "()Lcom/bytedance/android/live/service/prerequest/b;", "preRequestManager", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "initTime", "J", "Lcom/bytedance/android/live/service/grouppurchasetip/a;", "anchorGroupPurchaseTipManager$delegate", "getAnchorGroupPurchaseTipManager", "()Lcom/bytedance/android/live/service/grouppurchasetip/a;", "anchorGroupPurchaseTipManager", "", "openPanelCount", "I", "getOpenPanelCount", "()I", "setOpenPanelCount", "(I)V", "openAnchorPanelCount", "getOpenAnchorPanelCount", "setOpenAnchorPanelCount", "Lcom/bytedance/android/livesdk/chatroom/o;", "roomContext", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/o;)V", "Companion", "b", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileOuterContext extends DataContext implements ns0.a, ua1.a {
    public static final b Companion = null;
    private static final String TAG = "ProfileOuterContext";
    private final Lazy anchorGroupPurchaseTipManager$delegate;
    private final CompositeDisposable compositeDisposable;
    private final long initTime;
    private int openAnchorPanelCount;
    private int openPanelCount;
    private HashMap<String, c> personCardDataMap;
    private final Lazy preRequestManager$delegate;

    public static final class a implements Action {
        public final /* synthetic */ ProfileOuterContext a;

        public a(ProfileOuterContext r1) {
            this.a = r1;
        }

        public final void run() {
            ProfileOuterContext.access$destroy(this.a);
            ProfileOuterContext.access$getCompositeDisposable$p(this.a).clear();
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    private final com.bytedance.android.live.service.grouppurchasetip.a getAnchorGroupPurchaseTipManager() {
        return (com.bytedance.android.live.service.grouppurchasetip.a) this.anchorGroupPurchaseTipManager$delegate.getValue();
    }

    @Override // ua1.a
    public com.bytedance.android.live.service.prerequest.b getPreRequestManager() {
        return (com.bytedance.android.live.service.prerequest.b) this.preRequestManager$delegate.getValue();
    }

    @Override // ns0.a
    public void openTransitionDialog() {
        ALogger.i(TAG, "open transition dialog");
        xs2.b.a().post(new d(true));
    }

    private final void destroy() {
        com.bytedance.android.live.service.prerequest.b r0 = getPreRequestManager();
        r0.a.clear();
        ((LinkedHashMap) r0.b).clear();
        ((HashMap) r0.c).clear();
        ((HashMap) r0.d).clear();
        ((ArrayList) r0.f).clear();
        IFeatureService r1 = k.f(IFeatureService.class);
        if (r1 == null) goto L7;
        z90.a r2 = r1.getFeatureManager();
        if (r2 == null) goto L7;
        r2.h(r0.e);
    L7:
        r0.e = null;
        setOpenPanelCount(0);
        setOpenAnchorPanelCount(0);
    }

    @Override // ua1.a
    public /* bridge */ /* synthetic */ com.bytedance.android.live.service.prerequest.a getPreRequestManager() {
        return getPreRequestManager();
    }

    @Override // ua1.a
    public long getTimeAfterEnterRoom() {
        return System.currentTimeMillis() - this.initTime;
    }

    @Override // ns0.a
    public void noticeAnchorSetButtonClick() {
        com.bytedance.android.live.service.grouppurchasetip.a r0 = getAnchorGroupPurchaseTipManager();
        if (r0.b == false) goto L5;
        return;
    L5:
        if (r0.a == false) goto L9;
        r0.b = true;
        return;
    }

    @Override // ns0.a
    public boolean showAnchorSetButtonRedDot() {
        com.bytedance.android.live.service.grouppurchasetip.a r0 = getAnchorGroupPurchaseTipManager();
        if (r0.b == false) goto L5;
    L8:
        return false;
    L5:
        if (r0.a == false) goto L8;
        return true;
    }

    @Override // ua1.a
    public int getOpenAnchorPanelCount() {
        return this.openAnchorPanelCount;
    }

    @Override // ua1.a
    public int getOpenPanelCount() {
        return this.openPanelCount;
    }

    public ProfileOuterContext(final o r12) {
        Intrinsics.checkNotNullParameter(r12, "roomContext");
        this.personCardDataMap = new HashMap();
        this.preRequestManager$delegate = LazyKt.lazy(new ProfileOuterContext$preRequestManager$2(r12));
        CompositeDisposable r0 = new CompositeDisposable();
        this.compositeDisposable = r0;
        this.initTime = System.currentTimeMillis();
        Completable r1 = r12.J2();
        if (r1 == null) goto L7;
        Disposable r2 = r1.subscribe(new a(this));
        if (r2 == null) goto L7;
        RxUtilKt.c(r2, r0);
    L7:
        com.bytedance.android.live.service.prerequest.b r3 = getPreRequestManager();
        r3.getClass();
        if (com.bytedance.android.live.service.prerequest.b.f() == false) goto L60;
        m r4 = r3.h.getRoom();
        boolean r5 = true;
        if (r4 == null) goto L17;
        IRoom r6 = (IRoom) r4.getValue();
        if (r6 == null) goto L17;
        if (r6.isMergeVSRoom() == true) goto L60;
    L17:
        IMiddlewareUserService r7 = k.f(IMiddlewareUserService.class);
        if (r7 == null) goto L36;
        e r8 = r7.user();
        if (r8 == null) goto L36;
        m r9 = r3.h.getRoom();
        if (r9 == null) goto L26;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L26;
        String r13 = r10.getOwnerUserIdString();
    L27:
        Observable r14 = r8.u0(r13);
        if (r14 == null) goto L36;
        Observable r15 = r14.subscribeOn(Schedulers.io());
        if (r15 == null) goto L36;
        Observable r16 = r15.observeOn(AndroidSchedulers.mainThread());
        if (r16 == null) goto L36;
        Disposable r17 = r16.subscribe(new f(r3), g.a);
        if (r17 == null) goto L36;
        RxUtilKt.c(r17, r3.a);
    L26:
        r13 = null;
    L36:
        q0 r18 = q0.a;
        if (((ss0.d) r18.getValue()).f() == true) goto L39;
        long r19 = ((ss0.d) r18.getValue()).a();
        ALogger.i("NewUserProfile_ProfilePre", "PreRequestManager init, delay time is " + r19);
        if (r19 < 0) goto L59;
        int r20 = ((ss0.d) r18.getValue()).h();
        ALogger.i("NewUserProfile_ProfilePre", "sampling: " + r20);
        if (Random.Default.nextInt(1, WebcastRedirectException.MISS_REDIRECT_RULE) <= r20) goto L57;
        r5 = false;
    L57:
        if (r5 == false) goto L59;
        ALogger.i("NewUserProfile_ProfilePre", "PreRequestManager init, after sampling, timer");
        RxUtilKt.c(Observable.timer(r19, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.service.prerequest.d(r3)), r3.a);
    L59:
        RxUtilKt.c(Observable.timer(((ss0.d) r18.getValue()).d(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.service.prerequest.e(r3)), r3.a);
        goto L60
    L39:
        if (r3.e != null) goto L41;
        r3.e = new h(r3);
    L41:
        h r22 = r3.e;
        if (r22 == null) goto L48;
        IFeatureService r23 = k.f(IFeatureService.class);
        if (r23 == null) goto L48;
        z90.a r24 = r23.getFeatureManager();
        if (r24 == null) goto L48;
        r24.e(r22, CollectionsKt.listOf("profile_card_preload_predict_result"));
    L48:
        long r25 = ((ss0.d) r18.getValue()).e();
        ALogger.i("NewUserProfile_ProfilePre", "PreRequestManager init, is predict, predict delay time is " + r25);
        if (r25 < 0) goto L59;
        ALogger.i("NewUserProfile_ProfilePre", "PreRequestManager init, is predict, set timer");
        RxUtilKt.c(Observable.timer(r25, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.service.prerequest.c(r3)), r3.a);
    L60:
        this.anchorGroupPurchaseTipManager$delegate = LazyKt.lazy(new ProfileOuterContext$anchorGroupPurchaseTipManager$2(r12));
    }

    public static final /* synthetic */ void access$destroy(ProfileOuterContext r0) {
        r0.destroy();
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(ProfileOuterContext r0) {
        return r0.compositeDisposable;
    }

    private final void clearData(String r1) {
        this.personCardDataMap.clear();
    }

    @Override // ns0.a
    public c getPersonCardData(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L8;
        Iterator<Map.Entry<String, c>> r0 = this.personCardDataMap.entrySet().iterator();
        if (r0.hasNext() == false) goto L8;
        return r0.next().getValue();
    L8:
        HashMap<String, c> r1 = this.personCardDataMap;
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        c r4 = r1.get(r3);
        if (r4 == null) goto L14;
        return r4;
    L14:
        return new c("", "");
    }

    @Override // ns0.a
    public void noticeGroupPurchaseShowing(View r8) {
        com.bytedance.android.live.service.grouppurchasetip.a r0 = getAnchorGroupPurchaseTipManager();
        if (r0.a == true) goto L14;
        Disposable r1 = r0.c;
        boolean r2 = true;
        if (r1 != null) goto L8;
    L10:
        us0.a r3 = (us0.a) ts0.a.a.getValue();
        if (r3.a() == true) goto L14;
        if (r3.b() >= 5) goto L14;
    L15:
        if (r2 == false) goto L54;
        HashMap r4 = new HashMap();
        m r5 = r0.e.getRoom();
        if (r5 == null) goto L55;
        r4.put("anchor_id", ((IRoom) r5.getValue()).getOwnerUserIdString());
        IBaseUser r6 = ((IRoom) r5.getValue()).getOwner();
        String r7 = "";
        if (r6 == null) goto L24;
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        String r9 = r6.getCastSecUid();
        if (r9 == null) goto L24;
    L25:
        r4.put("sec_anchor_id", r9);
        r4.put("target_uid", ((IRoom) r5.getValue()).getOwnerUserIdString());
        IBaseUser r10 = ((IRoom) r5.getValue()).getOwner();
        if (r10 == null) goto L29;
        Intrinsics.checkNotNullParameter(r10, "$this$secUidExt");
        String r12 = r10.getCastSecUid();
        if (r12 == null) goto L29;
    L30:
        r4.put("sec_target_uid", r12);
        r4.put("packed_level", String.valueOf(2));
        String r13 = ((IRoom) r5.getValue()).getIdStr();
        if (r13 == null) goto L34;
        r7 = r13;
    L34:
        r4.put("current_room_id", r7);
        r4.put("request_from", "data_life_component");
        IMiddlewareUserService r14 = k.f(IMiddlewareUserService.class);
        if (r14 == null) goto L48;
        e r15 = r14.user();
        if (r15 == null) goto L49;
        Single r16 = r15.o(r4);
        if (r16 == null) goto L50;
        Single r17 = r16.subscribeOn(Schedulers.io());
        if (r17 == null) goto L51;
        Single r18 = r17.observeOn(AndroidSchedulers.mainThread());
        if (r18 == null) goto L52;
        Single r19 = r18.map(com.bytedance.android.live.service.grouppurchasetip.b.a);
        if (r19 == null) goto L53;
        r19.subscribe(new com.bytedance.android.live.service.grouppurchasetip.c(r0, r8));
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L29:
        r12 = "";
    L24:
        r9 = "";
        goto L25
    L55:
        return;
    L54:
        return;
    L8:
        if (r1.isDisposed() == true) goto L10;
    L14:
        r2 = false;
        goto L15
    }

    @Override // ua1.a
    public void setOpenAnchorPanelCount(int r1) {
        this.openAnchorPanelCount = r1;
    }

    @Override // ua1.a
    public void setOpenPanelCount(int r1) {
        this.openPanelCount = r1;
    }

    @Override // ns0.a
    public void prepareTransitionDialogRequest(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "schema");
        ALogger.i(TAG, "prepare request, schema: " + r4);
        IBaseLiveActionHandler r0 = k.f(IBaseLiveActionHandler.class);     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.handle(r3, r4);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        SafetyGuard.a(null, e, "ProfileOuterContext prepareTransitionDialogRequest");
    }

    @Override // ns0.a
    public void setPersonCardData(String r2, c r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, Constants.Keys.DATA);
        clearData(r2);
        this.personCardDataMap.put(r2, r3);
    }
}
