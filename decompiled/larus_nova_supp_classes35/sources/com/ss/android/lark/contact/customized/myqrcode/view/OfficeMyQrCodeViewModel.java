package com.ss.android.lark.contact.customized.myqrcode.view;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.contact.base.entity.bean.InvitationInfo;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.myqrcode.repository.OfficeInviteMsgRepository$asyncGetInviteMsg$1;
import com.ss.android.lark.contact.customized.myqrcode.repository.OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020 J\u0006\u0010(\u001a\u00020&J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020&H\u0002J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0002J\u0006\u0010.\u001a\u00020&J\u000e\u0010/\u001a\u00020&2\u0006\u00100\u001a\u000201J\b\u00102\u001a\u0004\u0018\u00010\u001aJ\b\u00103\u001a\u00020\"H\u0002J\"\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\"2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u00109\u001a\u00020 H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/ss/android/lark/contact/customized/myqrcode/view/OfficeMyQrCodeViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mInviteMsg", BuildConfig.FLAVOR, "mUniqueId", "_inviteCardLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/contact/customized/common/model/StatefulModel;", "Lcom/ss/android/lark/contact/customized/myqrcode/model/OfficeInviteExternalCardRenderModel;", "inviteCardLiveData", "getInviteCardLiveData", "()Landroidx/lifecycle/MutableLiveData;", "qrCodeHandler", "Lcom/ss/android/lark/officesdk/qrcode/api/IOpenFeishuQRCodeSDKProtocal;", "getQrCodeHandler", "()Lcom/ss/android/lark/officesdk/qrcode/api/IOpenFeishuQRCodeSDKProtocal;", "qrCodeHandler$delegate", "Lkotlin/Lazy;", "userListApi", "Lcom/ss/android/lark/passport_user/api/container/ILarkUserListApi;", "getUserListApi", "()Lcom/ss/android/lark/passport_user/api/container/ILarkUserListApi;", "userListApi$delegate", "qrcodeBitmap", "Landroid/graphics/Bitmap;", "qrcodeUrl", "cardBitmap", "captureGeneration", BuildConfig.FLAVOR, "contextInfoStartElapsed", BuildConfig.FLAVOR, "localPerfReported", BuildConfig.FLAVOR, "serverPerfReported", "firstPerfReported", "onPageViewCreated", BuildConfig.FLAVOR, "startElapsed", "fetchContactToken", "getContactToken", "getContactTokenFromLocal", "buildAndEmitInviteCard", Keys.API_RETURN_KEY_DATA, "Lcom/ss/android/lark/contact/base/entity/bean/InvitationInfoGroup;", "invalidateCardCapture", "captureCardBitmap", "cardView", "Landroid/view/View;", "getQrCodeBitmapLiveData", "isMsgEmpty", "reportContextInfoPerf", "isCache", "isSucceed", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getContextInfoDurationMs", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyQrCodeViewModel extends ViewModel {
    public static final int $stable = 0;
    private static final String CONTEXT_INFO_SCENE = "invite_context_info_api";
    public static final a Companion = null;
    private static final String PERFORMANCE_SCENE = "page_my_qr_code";
    private static final float QR_CODE_SIZE_DP = 220.0f;
    private static final String TAG = "Contact_MyQrCodeVM";
    private MutableLiveData<i9b.a<m9b.a>> _inviteCardLiveData;
    private int captureGeneration;
    private Bitmap cardBitmap;
    private long contextInfoStartElapsed;
    private boolean firstPerfReported;
    private boolean localPerfReported;
    private String mInviteMsg;
    private String mUniqueId;
    private final Lazy qrCodeHandler$delegate;
    private Bitmap qrcodeBitmap;
    private String qrcodeUrl;
    private boolean serverPerfReported;
    private final Lazy userListApi$delegate;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.myqrcode.view.OfficeMyQrCodeViewModel$buildAndEmitInviteCard$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.myqrcode.view.OfficeMyQrCodeViewModel$buildAndEmitInviteCard$1", f = "OfficeMyQrCodeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ z8b.a $data;
        int label;
        final /* synthetic */ OfficeMyQrCodeViewModel this$0;

        public AnonymousClass1(z8b.a r1, OfficeMyQrCodeViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$data = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$data, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L50;
            ResultKt.throwOnFailure(r19);
            z8b.a r1 = this.$data;
            r1.getClass();
            if (TextUtils.equals("qr_code", "qr_code") == false) goto L7;
            InvitationInfo r2 = r1.a;
        L9:
            if (r2 != null) goto L12;
            this.this$0.getInviteCardLiveData().postValue(new i9b.a.C0235a(BuildConfig.FLAVOR));
            return Unit.INSTANCE;
        L12:
            ICUUtils.FormatArgsBuilder r3 = new ICUUtils.FormatArgsBuilder();
            r3.b("brandName", UIHelper.getAppName());
            r3.b("id", ((x1c.d) OfficeContactUtils.a.getValue()).y1().b);
            List r4 = r3.a;
            if (OfficeContactUtils.f() == false) goto L17;
            String r5 = r2.teamName;
            if (r5 != null) goto L18;
            String r6 = BuildConfig.FLAVOR;
        L19:
            String r8 = OfficeMyQrCodeViewModel.access$getUserListApi(this.this$0).d();
            int r7 = UIHelper.dp2px(OfficeMyQrCodeViewModel.QR_CODE_SIZE_DP);
            if (TextUtils.equals(r2.invUrl, OfficeMyQrCodeViewModel.access$getQrcodeUrl$p(this.this$0)) == true) goto L22;
        L24:
            boolean r9 = false;
        L25:
            if (r9 == false) goto L28;
            Bitmap r10 = OfficeMyQrCodeViewModel.access$getQrcodeBitmap$p(this.this$0);
        L27:
            Bitmap r11 = r10;
            if (r11 != null) goto L39;
            this.this$0.getInviteCardLiveData().postValue(new i9b.a.C0235a("generate bitmap failed"));
            return Unit.INSTANCE;
        L39:
            MutableLiveData<i9b.a<m9b.a>> r12 = this.this$0.getInviteCardLiveData();
            String r13 = r2.userName;
            if (r13 != null) goto L42;
            String r14 = BuildConfig.FLAVOR;
        L43:
            Intrinsics.checkNotNull(r6);
            String r15 = r2.userAvatarKey;
            if (r15 != null) goto L46;
            String r16 = BuildConfig.FLAVOR;
        L47:
            r12.postValue(new i9b.a.c(new m9b.a(r14, r6, r16, r8, r11)));
            return Unit.INSTANCE;
        L46:
            r16 = r15;
            goto L47
        L42:
            r14 = r13;
            goto L43
        L28:
            long r17 = SystemClock.elapsedRealtime();
            owb.b r18 = OfficeMyQrCodeViewModel.access$getQrCodeHandler(this.this$0);
            String r110 = r2.invUrl;
            UIHelper.dp2px(8.0f);
            UIHelper.dp2px(96.0f);
            r10 = r18.q1(r110, new owb.c(r7, r7));
            int r20 = com.ss.android.lark.contact.customized.common.a.a;
            long r111 = SystemClock.elapsedRealtime() - r17;
            if (r10 == null) goto L31;
            boolean r112 = true;
        L32:
            if (r10 != null) goto L34;
            ErrorResult r21 = new ErrorResult("generate qr bitmap failed");
        L35:
            com.ss.android.lark.contact.customized.common.a.a(OfficeMyQrCodeViewModel.PERFORMANCE_SCENE, r111, r112, r21, false, true);
            OfficeMyQrCodeViewModel.access$setQrcodeUrl$p(this.this$0, r2.invUrl);
            OfficeMyQrCodeViewModel.access$setQrcodeBitmap$p(this.this$0, r10);
            goto L27
        L34:
            r21 = null;
            goto L35
        L31:
            r112 = false;
            goto L32
        L22:
            if (OfficeMyQrCodeViewModel.access$getQrcodeBitmap$p(this.this$0) == null) goto L24;
            r9 = true;
        L18:
            r6 = r5;
            goto L19
        L17:
            r5 = ICUUtils.icuFormat(UIHelper.getString(2131890051), r4);
            goto L18
        L7:
            r2 = r1.b;
            goto L9
        L50:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    private final void getContactToken() {
        int r0 = com.ss.android.lark.contact.customized.myqrcode.repository.a.a;
        Function1<z8b.a, Unit> r1 = new C04411(this);
        Intrinsics.checkNotNullParameter(r1, "consumer");
        int r2 = com.ss.android.lark.contact.base.service.d.a;
        com.ss.android.lark.contact.base.service.d.b(new OfficeInviteMsgRepository$asyncGetInviteMsg$1(r1));
    }

    private final void getContactTokenFromLocal() {
        int r0 = com.ss.android.lark.contact.customized.myqrcode.repository.a.a;
        Function1<z8b.a, Unit> r1 = new C04421(this);
        Intrinsics.checkNotNullParameter(r1, "consumer");
        int r2 = com.ss.android.lark.contact.base.service.d.a;
        com.ss.android.lark.contact.base.service.d.a(new OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1(r1));
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

    private final yzb.b getUserListApi() {
        return (yzb.b) this.userListApi$delegate.getValue();
    }

    private final boolean isMsgEmpty() {
        return TextUtils.isEmpty(this.mInviteMsg);
    }

    public final void invalidateCardCapture() {
        this.captureGeneration++;
    }

    public OfficeMyQrCodeViewModel() {
        this._inviteCardLiveData = new MutableLiveData();
        this.qrCodeHandler$delegate = LazyKt.lazy(OfficeMyQrCodeViewModel$qrCodeHandler$2.INSTANCE);
        this.userListApi$delegate = LazyKt.lazy(OfficeMyQrCodeViewModel$userListApi$2.INSTANCE);
    }

    public final void fetchContactToken() {
        getInviteCardLiveData().setValue(i9b.a.b.a);
        getContactToken();
        getContactTokenFromLocal();
    }

    public final MutableLiveData<i9b.a<m9b.a>> getInviteCardLiveData() {
        return this._inviteCardLiveData;
    }

    public final Bitmap getQrCodeBitmapLiveData() {
        return this.cardBitmap;
    }

    public static final /* synthetic */ int access$getCaptureGeneration$p(OfficeMyQrCodeViewModel r0) {
        return r0.captureGeneration;
    }

    public static final /* synthetic */ owb.b access$getQrCodeHandler(OfficeMyQrCodeViewModel r0) {
        return r0.getQrCodeHandler();
    }

    public static final /* synthetic */ Bitmap access$getQrcodeBitmap$p(OfficeMyQrCodeViewModel r0) {
        return r0.qrcodeBitmap;
    }

    public static final /* synthetic */ String access$getQrcodeUrl$p(OfficeMyQrCodeViewModel r0) {
        return r0.qrcodeUrl;
    }

    public static final /* synthetic */ yzb.b access$getUserListApi(OfficeMyQrCodeViewModel r0) {
        return r0.getUserListApi();
    }

    public static final /* synthetic */ boolean access$isMsgEmpty(OfficeMyQrCodeViewModel r0) {
        return r0.isMsgEmpty();
    }

    private final void buildAndEmitInviteCard(z8b.a r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getDefault(), null, new AnonymousClass1(r7, this, null), 2, null);
    }

    public final void captureCardBitmap(final View r4) {
        Intrinsics.checkNotNullParameter(r4, "cardView");
        final int r0 = this.captureGeneration + 1;
        this.captureGeneration = r0;
        UIUtils.getScreenViewShot(r4, UIUtils.getActivityFromView(r4).getWindow(), new C04401(r0, this, r4));
    }

    public final void onPageViewCreated(long r1) {
        this.contextInfoStartElapsed = r1;
        this.localPerfReported = false;
        this.serverPerfReported = false;
        this.firstPerfReported = false;
    }

    public static final /* synthetic */ void access$buildAndEmitInviteCard(OfficeMyQrCodeViewModel r0, z8b.a r1) {
        r0.buildAndEmitInviteCard(r1);
    }

    public static final /* synthetic */ void access$setCardBitmap$p(OfficeMyQrCodeViewModel r0, Bitmap r1) {
        r0.cardBitmap = r1;
    }

    public static final /* synthetic */ void access$setMInviteMsg$p(OfficeMyQrCodeViewModel r0, String r1) {
        r0.mInviteMsg = r1;
    }

    public static final /* synthetic */ void access$setMUniqueId$p(OfficeMyQrCodeViewModel r0, String r1) {
        r0.mUniqueId = r1;
    }

    public static final /* synthetic */ void access$setQrcodeBitmap$p(OfficeMyQrCodeViewModel r0, Bitmap r1) {
        r0.qrcodeBitmap = r1;
    }

    public static final /* synthetic */ void access$setQrcodeUrl$p(OfficeMyQrCodeViewModel r0, String r1) {
        r0.qrcodeUrl = r1;
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

    public static final /* synthetic */ void access$reportContextInfoPerf(OfficeMyQrCodeViewModel r0, boolean r1, boolean r2, ErrorResult r3) {
        r0.reportContextInfoPerf(r1, r2, r3);
    }
}
