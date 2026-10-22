package com.ss.android.lark.contact.customized.externalinvite.view;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.entity.bean.InvitationInfo;
import com.ss.android.lark.contact.customized.mobileinvite.OfficeInviteExternalContactActivity;
import com.ss.android.lark.contact.customized.myqrcode.OfficeMyQrCodeActivity;
import com.ss.android.lark.contact.customized.myqrcode.repository.OfficeInviteMsgRepository$asyncGetInviteMsg$1;
import com.ss.android.lark.contact.customized.myqrcode.repository.OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1;
import com.ss.android.lark.contact.customized.search.OfficeInviteExternalSearchActivity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.l;
import com.ss.android.lark.utils.n;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0016\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u000eJ\u0006\u0010%\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\"J\u0016\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\"\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\b\u0010/\u001a\u00020\u000eH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u00061"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalinvite/view/OfficeInviteExternalViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_invitationInfoGroupLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/contact/customized/common/model/StatefulModel;", "Lcom/ss/android/lark/contact/base/entity/bean/InvitationInfoGroup;", "invitationInfoGroupLiveData", "Landroidx/lifecycle/LiveData;", "getInvitationInfoGroupLiveData", "()Landroidx/lifecycle/LiveData;", "invitationInfoGroup", "contextInfoStartElapsed", BuildConfig.FLAVOR, "localPerfReported", BuildConfig.FLAVOR, "serverPerfReported", "firstPerfReported", "qrCodeHandler", "Lcom/ss/android/lark/officesdk/qrcode/api/IOpenFeishuQRCodeSDKProtocal;", "getQrCodeHandler", "()Lcom/ss/android/lark/officesdk/qrcode/api/IOpenFeishuQRCodeSDKProtocal;", "qrCodeHandler$delegate", "Lkotlin/Lazy;", "requestFinish", BuildConfig.FLAVOR, "fragment", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "onClickSearchPhoneOrEmail", "sharedSearchBar", "Landroid/view/View;", "onClickImportContact", "from", BuildConfig.FLAVOR, "onPageViewCreated", "startElapsed", "fetchContactToken", "getInviteUrl", "gotoMyQrCode", "onClickF2f", "startScanQRCodeActivity", "reportContextInfoPerf", "isCache", "isSucceed", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getContextInfoDurationMs", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteExternalViewModel extends ViewModel {
    public static final int $stable = 0;
    private static final String CONTEXT_INFO_SCENE = "invite_context_info_api";
    public static final a Companion = null;
    private static final String TAG = "Contact_InviteExternalViewModel";
    private final MutableLiveData<i9b.a<z8b.a>> _invitationInfoGroupLiveData;
    private long contextInfoStartElapsed;
    private boolean firstPerfReported;
    private z8b.a invitationInfoGroup;
    private final LiveData<i9b.a<z8b.a>> invitationInfoGroupLiveData;
    private boolean localPerfReported;
    private final Lazy qrCodeHandler$delegate;
    private boolean serverPerfReported;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public final void onClickF2f(BaseFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
    }

    private final long getContextInfoDurationMs() {
        long r0 = this.contextInfoStartElapsed;
        if (r0 > 0) goto L6;
        return 0;
    L6:
        return SystemClock.elapsedRealtime() - r0;
    }

    private final owb.b getQrCodeHandler() {
        return (owb.b) this.qrCodeHandler$delegate.getValue();
    }

    public final void fetchContactToken() {
        Log.i(TAG, "fetchContactToken");
        this._invitationInfoGroupLiveData.setValue(i9b.a.b.a);
        int r0 = com.ss.android.lark.contact.customized.myqrcode.repository.a.a;
        Function1<z8b.a, Unit> r1 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r1, "consumer");
        int r2 = com.ss.android.lark.contact.base.service.d.a;
        com.ss.android.lark.contact.base.service.d.b(new OfficeInviteMsgRepository$asyncGetInviteMsg$1(r1));
        Function1<z8b.a, Unit> r3 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r3, "consumer");
        com.ss.android.lark.contact.base.service.d.a(new OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1(r3));
    }

    public final String getInviteUrl() {
        z8b.a r0 = this.invitationInfoGroup;
        if (r0 == null) goto L18;
        InvitationInfo r2 = r0.b;
        if (r2 == null) goto L7;
        String r3 = r2.invUrl;
    L9:
        if (TextUtils.isEmpty(r3) == false) goto L14;
        InvitationInfo r1 = r0.a;
        if (r1 == null) goto L14;
        r3 = r1.invUrl;
    L14:
        if (r3 != null) goto L17;
        return BuildConfig.FLAVOR;
    L17:
        return r3;
    L7:
        r3 = BuildConfig.FLAVOR;
        goto L9
    L18:
        return BuildConfig.FLAVOR;
    }

    public OfficeInviteExternalViewModel() {
        MutableLiveData<i9b.a<z8b.a>> r0 = new MutableLiveData();
        this._invitationInfoGroupLiveData = r0;
        this.invitationInfoGroupLiveData = r0;
        this.qrCodeHandler$delegate = LazyKt.lazy(OfficeInviteExternalViewModel$qrCodeHandler$2.INSTANCE);
    }

    public final LiveData<i9b.a<z8b.a>> getInvitationInfoGroupLiveData() {
        return this.invitationInfoGroupLiveData;
    }

    public static final /* synthetic */ z8b.a access$getInvitationInfoGroup$p(OfficeInviteExternalViewModel r0) {
        return r0.invitationInfoGroup;
    }

    public static final /* synthetic */ MutableLiveData access$get_invitationInfoGroupLiveData$p(OfficeInviteExternalViewModel r0) {
        return r0._invitationInfoGroupLiveData;
    }

    public final void onPageViewCreated(long r1) {
        this.contextInfoStartElapsed = r1;
        this.localPerfReported = false;
        this.serverPerfReported = false;
        this.firstPerfReported = false;
    }

    public final void requestFinish(BaseFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        FragmentActivity r3 = r2.getActivity();
        if (r3 == null) goto L6;
        r3.finish();
        return;
    }

    public final void startScanQRCodeActivity(BaseFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        FragmentActivity r3 = r2.getActivity();
        if (r3 == null) goto L6;
        getQrCodeHandler().N0(r3);
        return;
    }

    public static final /* synthetic */ void access$setInvitationInfoGroup$p(OfficeInviteExternalViewModel r0, z8b.a r1) {
        r0.invitationInfoGroup = r1;
    }

    public final void gotoMyQrCode(BaseFragment r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "from");
        FragmentActivity r4 = r2.getActivity();
        if (r4 == null) goto L6;
        int r0 = OfficeMyQrCodeActivity.a;
        OfficeMyQrCodeActivity.a.a(r4, r3);
        return;
    }

    public final void onClickImportContact(BaseFragment r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, "from");
        FragmentActivity r12 = r10.getActivity();
        if (r12 == null) goto L6;
        int r1 = OfficeInviteExternalContactActivity.b;
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(r11, "from");
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "inviteMsg");
        Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "uniqueId");
        Intrinsics.checkNotNullParameter(r11, "from");
        com.ss.android.lark.contact.customized.mobileinvite.a r0 = new com.ss.android.lark.contact.customized.mobileinvite.a(r12, r11);
        int r13 = n.a;
        com.ss.android.lark.utils.h.d(r12, r0, "android.permission.READ_CONTACTS", null, new l(2131892786, 2131892787, 2131892786, 2131892787, null, null, 240));
        return;
    }

    public final void onClickSearchPhoneOrEmail(BaseFragment r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        FragmentActivity r0 = r5.getActivity();
        int r1 = OfficeInviteExternalSearchActivity.a;
        Intent r2 = new Intent(r0, OfficeInviteExternalSearchActivity.class);
        r2.putExtra("transition", true);
        if (r6 == null) goto L5;
        r5.startActivity(r2, ActivityOptionsCompat.makeSceneTransitionAnimation(r0, r6, "contact_db_transition_invite_search_bar").toBundle());
        return;
    L5:
        r0.startActivity(r2);
    }

    private final void reportContextInfoPerf(boolean r10, boolean r11, ErrorResult r12) {
        if (this.contextInfoStartElapsed > 0) goto L6;
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
        com.ss.android.lark.contact.customized.common.a.a(CONTEXT_INFO_SCENE, getContextInfoDurationMs(), r11, r12, r10, r8);
        return;
    L12:
        if (this.serverPerfReported == false) goto L14;
        return;
    L14:
        this.serverPerfReported = true;
        goto L15
    }

    public static final /* synthetic */ void access$reportContextInfoPerf(OfficeInviteExternalViewModel r0, boolean r1, boolean r2, ErrorResult r3) {
        r0.reportContextInfoPerf(r1, r2, r3);
    }
}
