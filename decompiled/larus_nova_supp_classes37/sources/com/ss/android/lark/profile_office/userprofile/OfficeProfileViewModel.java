package com.ss.android.lark.profile_office.userprofile;

import android.text.TextUtils;
import android.util.Base64;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.StatusEffectiveInterval;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileRequest;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.google.gson.Gson;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKBizConfigProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmUploadRetryConfigSetting;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.profile.core.model.TnsReportConfig;
import com.ss.android.lark.profile.dto.ProfileFinishResult;
import com.ss.android.lark.profile_office.OfficeProfileModule;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.e0;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.f0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 i2\u00020\u0001:\u0001iB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J&\u0010-\u001a\u00020*2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020*H\u0002J\u0016\u00101\u001a\u00020\r2\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0002J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u000204052\u0006\u00106\u001a\u00020\rH\u0082@¢\u0006\u0002\u00107J\b\u00108\u001a\u00020*H\u0002J\u0016\u00109\u001a\u00020*2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002J\b\u0010=\u001a\u00020*H\u0002J\b\u0010>\u001a\u00020*H\u0002J\b\u0010?\u001a\u00020*H\u0002J\u0010\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\"H\u0002J\u0018\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020\"2\u0006\u0010D\u001a\u00020\"H\u0002J\b\u0010G\u001a\u00020*H\u0002J\u0010\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020\rH\u0002J\b\u0010J\u001a\u00020*H\u0002J\u0010\u0010K\u001a\u00020*2\u0006\u0010L\u001a\u00020\"H\u0002J\u0010\u0010M\u001a\u00020*2\u0006\u0010N\u001a\u00020\"H\u0002J!\u0010O\u001a\u00020*2\u0017\u0010P\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110Q¢\u0006\u0002\bRH\u0002J!\u0010S\u001a\u00020*2\u0017\u0010P\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170Q¢\u0006\u0002\bRH\u0002J$\u0010T\u001a\u00020\u0011*\u00020\u00112\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001052\u0006\u0010U\u001a\u00020\rH\u0002J\b\u0010V\u001a\u00020*H\u0002J\b\u0010W\u001a\u00020*H\u0002J\b\u0010X\u001a\u00020*H\u0014J\u0016\u0010Y\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010ZJ\u0010\u0010[\u001a\u00020*2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\\\u001a\u00020\"2\u0006\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u0004\u0018\u00010`J\u0006\u0010a\u001a\u00020\"J\b\u0010b\u001a\u00020\"H\u0002J\u0018\u0010c\u001a\u00020\"2\u0006\u0010F\u001a\u00020\"2\u0006\u0010d\u001a\u00020\"H\u0002J\u0018\u0010e\u001a\u00020f2\b\u0010g\u001a\u0004\u0018\u00010\"H\u0082@¢\u0006\u0002\u0010hR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/ss/android/lark/profile_office/userprofile/OfficeProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "model", "Lcom/ss/android/lark/profile_office/userprofile/OfficeProfileModel;", "officeProfileProtocol", "Lcom/ss/android/lark/profile_office_api/IOfficeProfileProtocol;", "officeSDKTokenProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;", "<init>", "(Lcom/ss/android/lark/profile_office/userprofile/OfficeProfileModel;Lcom/ss/android/lark/profile_office_api/IOfficeProfileProtocol;Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;)V", "getOfficeProfileProtocol", "()Lcom/ss/android/lark/profile_office_api/IOfficeProfileProtocol;", "isIMEnabled", "", "isLoginBUser", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/profile_office/userprofile/OfficeProfileState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "_dialogState", "Lcom/ss/android/lark/profile_office/userprofile/OfficeProfileDialogState;", "dialogState", "getDialogState", "_effect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/profile_office/userprofile/ProfileEffect;", "effect", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "userId", "", AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN, "source", "Lcom/ss/android/lark/contact/export/ContactSource;", "hasReportedEnterPage", "signUrlPreviewPushListener", "Lcom/ss/android/lark/chatpreview/ISignUrlPreviewPushListener;", "dispatch", "", "intent", "Lcom/ss/android/lark/profile_office/userprofile/ProfileIntent;", "init", "reload", "loadProfile", "updateProfile", "loadIsOnLeave", "response", "Lcom/ss/android/lark/profile/core/model/Response$Success;", "Lcom/bytedance/lark/pb/contact/v2/GetDoubaoProfileResponse;", "Lcom/ss/android/lark/profile/core/model/Response;", "fromServer", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadDescriptionSpan", "handleSignUrlPreviewPush", "entriesList", "", "Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries;", "loadDoubaoUserInfo", "loadDoubaoHomepageData", "markChatApplicationMeReadIfNeeded", "handleCtaClick", "cta", "Lcom/bytedance/lark/pb/contact/v2/GetDoubaoProfileResponse$CTAInfo;", "saveAlias", "alias", "applyFriend", "message", "acceptFriend", "blockUser", "isBlock", "deleteFriend", "reportEnterPageIfNeeded", "doubaoUserId", "reportHomePageClick", PickerReporterConstants.KEY.CLICK, "updateState", "transform", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "updateDialogState", "withProfileResponse", "isServerResponse", "registerUrlPreviewsPush", "unRegisterUrlPreviewPush", "onCleared", "emitEffect", "(Lcom/ss/android/lark/profile_office/userprofile/ProfileEffect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitEffectAsync", "getRequestFailToastMessage", "errorResult", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getFinishResult", "Lcom/ss/android/lark/profile/dto/ProfileFinishResult;", "getReportUrl", "getLanguageLocaleTag", "encrypt", "key", "parseDoubaoData", "Lcom/ss/android/lark/profile_office/userprofile/model/DoubaoData;", "extraInfo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "profile-office_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class OfficeProfileViewModel extends ViewModel {
    public static final int $stable = 0;
    private static final String AES_MODE = "AES/CBC/PKCS7Padding";
    private static final String CIPHER = "AES";
    public static final a Companion = null;
    private static final int KEY_LENGTH = 16;
    private static final String ON_LEAVE_STATUS_ICON_KEY = "GeneralVacation";
    private static final String PROVIDER = "BC";
    private static final String TAG = "OfficeProfileViewModel";
    private final z0<d> _dialogState;
    private final MutableSharedFlow<j> _effect;
    private final z0<OfficeProfileState> _state;
    private final i1<d> dialogState;
    private final d1<j> effect;
    private boolean hasReportedEnterPage;
    private final boolean isIMEnabled;
    private final boolean isLoginBUser;
    private final OfficeProfileModel model;
    private final x1c.d officeProfileProtocol;
    private final d7b.a signUrlPreviewPushListener;
    private ContactSource source;
    private final i1<OfficeProfileState> state;
    private String token;
    private String userId;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$acceptFriend$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$acceptFriend$1", f = "OfficeProfileViewModel.kt", i = {}, l = {450, 454}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public AnonymousClass1(OfficeProfileViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$acceptFriend$2$1] */
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L31:
            OfficeProfileViewModel.access$updateState(this.this$0, AnonymousClass2.INSTANCE);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L25:
            q1c.b r8 = (q1c.b) r7;
            if ((!(r8 instanceof q1c.b.a)) == false) goto L28;
            OfficeProfileViewModel.access$updateProfile(this.this$0);
            goto L31
        L28:
            OfficeProfileViewModel r2 = this.this$0;
            j.k r3 = new j.k(OfficeProfileViewModel.access$getRequestFailToastMessage(r2, ((q1c.b.a) r8).a));
            this.label = 2;
            if (OfficeProfileViewModel.access$emitEffect(r2, r3, this) != r0) goto L31;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            OfficeProfileViewModel.access$updateState(this.this$0, C01081.INSTANCE);
            OfficeProfileState r9 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            OfficeProfileModel r4 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            q1c.b<GetDoubaoProfileResponse> r10 = r9.a;
            if (r10 == null) goto L17;
            GetDoubaoProfileResponse r11 = r10.a();
            if (r11 == null) goto L17;
            GetDoubaoProfileResponse.UserInfo r12 = r11.user_info;
            if (r12 == null) goto L17;
            String r13 = r12.contact_application_id;
        L18:
            if (r13 != null) goto L20;
            r13 = "";
        L20:
            this.label = 1;
            r4.getClass();
            final kotlinx.coroutines.j r5 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r5.C();
            Log.i("OfficeProfileModel", "start acceptFriend, applicationId: ".concat(r13));
            OfficeProfileModule.a().getContactDependency().a(r13, new OfficeProfileModel$acceptFriend$2$1(r5));
            r7 = r5.B();
            if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
            DebugProbesKt.probeCoroutineSuspended(this);
        L23:
            if (r7 != r0) goto L25;
            return r0;
        L17:
            r13 = null;
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$applyFriend$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$applyFriend$1", f = "OfficeProfileViewModel.kt", i = {}, l = {430, 440}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $alias;
        final /* synthetic */ String $message;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C03781(OfficeProfileViewModel r1, String r2, String r3, Continuation<? super C03781> r4) {
            this.this$0 = r1;
            this.$message = r2;
            this.$alias = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C03781(this.this$0, this.$message, this.$alias, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v0, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$applyFriend$2$1] */
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r11);
        L21:
            OfficeProfileViewModel.access$updateDialogState(this.this$0, AnonymousClass3.INSTANCE);
        L23:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
        L15:
            q1c.b r12 = (q1c.b) r11;
            if ((!(r12 instanceof q1c.b.a)) == false) goto L18;
            OfficeProfileViewModel.access$updateDialogState(this.this$0, AnonymousClass2.INSTANCE);
            OfficeProfileViewModel.access$updateProfile(this.this$0);
            goto L23
        L18:
            OfficeProfileViewModel r2 = this.this$0;
            j.k r3 = new j.k(OfficeProfileViewModel.access$getRequestFailToastMessage(r2, ((q1c.b.a) r12).a));
            this.label = 2;
            if (OfficeProfileViewModel.access$emitEffect(r2, r3, this) != r0) goto L21;
            return r0;
        L10:
            ResultKt.throwOnFailure(r11);
            OfficeProfileViewModel.access$updateDialogState(this.this$0, C01091.INSTANCE);
            OfficeProfileState r13 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            OfficeProfileModel r4 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            String r5 = r13.l();
            String r6 = this.$message;
            String r7 = this.$alias;
            ContactSource r8 = OfficeProfileViewModel.access$getSource$p(this.this$0);
            this.label = 1;
            r4.getClass();
            final kotlinx.coroutines.j r14 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r14.C();
            Log.i("OfficeProfileModel", "start applyFriend, userId: " + r5 + ", alias: " + r7);
            OfficeProfileModule.a().getContactDependency().b(r5, r6, r7, r8, new OfficeProfileModel$applyFriend$2$1(r14));
            r11 = r14.B();
            if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
            DebugProbesKt.probeCoroutineSuspended(this);
        L13:
            if (r11 != r0) goto L15;
            return r0;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GetDoubaoProfileResponse.CTAType.values().length];
            r0[GetDoubaoProfileResponse.CTAType.CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$blockUser$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$blockUser$1", f = "OfficeProfileViewModel.kt", i = {}, l = {471, 484}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isBlock;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C03791(OfficeProfileViewModel r1, boolean r2, Continuation<? super C03791> r3) {
            this.this$0 = r1;
            this.$isBlock = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03791(this.this$0, this.$isBlock, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v3, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$blockUser$2$1] */
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L22:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
        L15:
            q1c.b r9 = (q1c.b) r8;
            if ((!(r9 instanceof q1c.b.a)) == false) goto L18;
            OfficeProfileViewModel r10 = this.this$0;
            final boolean r2 = this.$isBlock;
            OfficeProfileViewModel.access$updateState(r10, new AnonymousClass2(r2));
            OfficeProfileViewModel.access$updateProfile(this.this$0);
            goto L22
        L18:
            final OfficeProfileViewModel r3 = this.this$0;
            OfficeProfileViewModel.access$updateState(r3, new AnonymousClass3(r3));
            OfficeProfileViewModel r4 = this.this$0;
            j.k r5 = new j.k(OfficeProfileViewModel.access$getRequestFailToastMessage(r4, ((q1c.b.a) r9).a));
            this.label = 2;
            if (OfficeProfileViewModel.access$emitEffect(r4, r5, this) != r0) goto L22;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            final OfficeProfileViewModel r11 = this.this$0;
            OfficeProfileViewModel.access$updateState(r11, new C01101(r11));
            OfficeProfileState r12 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            OfficeProfileModel r6 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            String r13 = r12.l();
            boolean r7 = this.$isBlock;
            this.label = 1;
            r6.getClass();
            final kotlinx.coroutines.j r14 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r14.C();
            Log.i("OfficeProfileModel", "start blockUser, userId: " + r13 + ", isBlock: " + r7);
            OfficeProfileModule.a().getContactDependency().e(r13, r7, new OfficeProfileModel$blockUser$2$1(r14));
            r8 = r14.B();
            if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
            DebugProbesKt.probeCoroutineSuspended(this);
        L13:
            if (r8 != r0) goto L15;
            return r0;
        }
    }

    public static final class c implements d7b.a {
        public final /* synthetic */ OfficeProfileViewModel a;

        public c(OfficeProfileViewModel r1) {
            this.a = r1;
        }

        public final void onPushSignUrlPreview(List<UrlPreViewEntries> r2) {
            Intrinsics.checkNotNullParameter(r2, "entriesList");
            OfficeProfileViewModel.access$handleSignUrlPreviewPush(this.a, r2);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$deleteFriend$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$deleteFriend$1", f = "OfficeProfileViewModel.kt", i = {}, l = {492, 494, 496}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C03801(OfficeProfileViewModel r1, Continuation<? super C03801> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03801(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v1, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$deleteFriend$2$1] */
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r8);
        L26:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r8);
        L17:
            q1c.b r9 = (q1c.b) r8;
            if ((!(r9 instanceof q1c.b.a)) == false) goto L22;
            OfficeProfileViewModel r10 = this.this$0;
            j.a r2 = j.a.a;
            this.label = 2;
            if (OfficeProfileViewModel.access$emitEffect(r10, r2, this) != r0) goto L26;
            return r0;
        L22:
            OfficeProfileViewModel r3 = this.this$0;
            j.k r4 = new j.k(OfficeProfileViewModel.access$getRequestFailToastMessage(r3, ((q1c.b.a) r9).a));
            this.label = 3;
            if (OfficeProfileViewModel.access$emitEffect(r3, r4, this) != r0) goto L26;
            return r0;
        L12:
            ResultKt.throwOnFailure(r8);
            OfficeProfileState r11 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            OfficeProfileModel r5 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            String r12 = r11.l();
            this.label = 1;
            r5.getClass();
            final kotlinx.coroutines.j r6 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r6.C();
            Log.i("OfficeProfileModel", "start deleteFriend, userId: ".concat(r12));
            OfficeProfileModule.a().getContactDependency().c(r12, new OfficeProfileModel$deleteFriend$2$1(r6));
            r8 = r6.B();
            if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
            DebugProbesKt.probeCoroutineSuspended(this);
        L15:
            if (r8 != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$emitEffectAsync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$emitEffectAsync$1", f = "OfficeProfileViewModel.kt", i = {}, l = {570}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ j $effect;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C03821(OfficeProfileViewModel r1, j r2, Continuation<? super C03821> r3) {
            this.this$0 = r1;
            this.$effect = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03821(this.this$0, this.$effect, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            OfficeProfileViewModel r5 = this.this$0;
            j r2 = this.$effect;
            this.label = 1;
            if (OfficeProfileViewModel.access$emitEffect(r5, r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$handleSignUrlPreviewPush$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$handleSignUrlPreviewPush$1", f = "OfficeProfileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<UrlPreViewEntries> $entriesList;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C03831(OfficeProfileViewModel r1, List<UrlPreViewEntries> r2, Continuation<? super C03831> r3) {
            this.this$0 = r1;
            this.$entriesList = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03831(this.this$0, this.$entriesList, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L23;
            ResultKt.throwOnFailure(r9);
            OfficeProfileState r10 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            String r0 = r10.g();
            final String r1 = r10.l();
            boolean r3 = false;
            if (r0.length() != 0) goto L7;
            boolean r2 = true;
        L8:
            if (r2 == true) goto L21;
            if (r1.length() != 0) goto L12;
            boolean r4 = true;
        L13:
            if (r4 == true) goto L21;
            Log.i(OfficeProfileViewModel.TAG, "handleSignUrlPreviewPush, userId=" + r1 + ", size=" + this.$entriesList.size());
            final Map<String, RecogniseSpansResult> r5 = OfficeProfileModule.a().getChatDependency().a(this.$entriesList, r0, r1, r10.f());
            StringBuilder r6 = new StringBuilder("handleSignUrlPreviewPush parsed, userId=");
            r6.append(r1);
            r6.append(", descriptionId=");
            r6.append(r10.f());
            r6.append(", hasSpans=");
            if (r5.get(r1) == null) goto L18;
            r3 = true;
        L18:
            r6.append(r3);
            Log.i(OfficeProfileViewModel.TAG, r6.toString());
            OfficeProfileViewModel.access$updateState(this.this$0, new C01111(r5, r1));
            return Unit.INSTANCE;
        L12:
            r4 = false;
        L21:
            return Unit.INSTANCE;
        L7:
            r2 = false;
            goto L8
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDoubaoHomepageData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDoubaoHomepageData$1", f = "OfficeProfileViewModel.kt", i = {0}, l = {366}, m = "invokeSuspend", n = {"chatterId"}, s = {"L$0"})
    public static final class C03851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C03851(OfficeProfileViewModel r1, Continuation<? super C03851> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03851(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L10;
            if (r2 != 1) goto L9;
            String r3 = (String) this.L$0;
            ResultKt.throwOnFailure(r6);     // Catch: Exception -> L17
        L15:
            final List<String> r7 = ((x1c.a) r6).a;     // Catch: Exception -> L17
            Log.i(OfficeProfileViewModel.TAG, "loadDoubaoHomepageData success, images: " + r7 + " for chatterId: " + r3);     // Catch: Exception -> L17
            OfficeProfileViewModel.access$updateState(this.this$0, new C01131(r7));     // Catch: Exception -> L17
        L20:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r6);
            String r8 = ((OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue()).l();     // Catch: Exception -> L17
            x1c.d r4 = this.this$0.getOfficeProfileProtocol();     // Catch: Exception -> L17
            this.L$0 = r8;     // Catch: Exception -> L17
            this.label = 1;     // Catch: Exception -> L17
            Object r5 = r4.C(r8, this);     // Catch: Exception -> L17
            if (r5 != r1) goto L14;
            return r1;
        L14:
            r3 = r8;
            r6 = r5;
        L17:
            e = move-exception;
            Log.e(OfficeProfileViewModel.TAG, "loadDoubaoHomepageData error", e);
            goto L20
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDoubaoUserInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDoubaoUserInfo$1", f = "OfficeProfileViewModel.kt", i = {0, 1}, l = {340, 349, 352}, m = "invokeSuspend", n = {"chatterId", "chatterId"}, s = {"L$0", "L$0"})
    public static final class C03861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C03861(OfficeProfileViewModel r1, Continuation<? super C03861> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03861(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L19;
            if (r2 == 1) goto L16;
            if (r2 == 2) goto L13;
            if (r2 != 3) goto L12;
            ResultKt.throwOnFailure(r11);     // Catch: Exception -> L9
        L33:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            String r0 = (String) this.L$0;
            ResultKt.throwOnFailure(r11);     // Catch: Exception -> L9
        L28:
            OfficeProfileModel r3 = OfficeProfileViewModel.access$getModel$p(this.this$0);     // Catch: Exception -> L9
            this.L$0 = null;     // Catch: Exception -> L9
            this.label = 3;     // Catch: Exception -> L9
            if (r3.d(r0, (String) r11, this) != r1) goto L33;
            return r1;
        L16:
            String r4 = (String) this.L$0;
            ResultKt.throwOnFailure(r11);     // Catch: Exception -> L9
        L24:
            x1c.b r12 = (x1c.b) r11;     // Catch: Exception -> L9
            Log.i(OfficeProfileViewModel.TAG, "loadDoubaoUserInfo success: " + r12 + " for chatterId: " + r4);     // Catch: Exception -> L9
            final v1c.a r5 = new v1c.a(r12.a, r12.b, r12.d);     // Catch: Exception -> L9
            OfficeProfileViewModel.access$updateState(this.this$0, new C01141(r5));     // Catch: Exception -> L9
            OfficeProfileViewModel.access$reportEnterPageIfNeeded(this.this$0, r5.a());     // Catch: Exception -> L9
            CoroutineDispatcher r13 = Dispatchers.getDefault();     // Catch: Exception -> L9
            OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1 r7 = new OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1(r5, null);     // Catch: Exception -> L9
            this.L$0 = r4;     // Catch: Exception -> L9
            this.label = 2;     // Catch: Exception -> L9
            r11 = BuildersKt.withContext(r13, r7, this);     // Catch: Exception -> L9
            if (r11 != r1) goto L27;
            return r1;
        L27:
            r0 = r4;
            goto L28
        L19:
            ResultKt.throwOnFailure(r11);
            String r14 = ((OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue()).l();     // Catch: Exception -> L9
            x1c.d r6 = this.this$0.getOfficeProfileProtocol();     // Catch: Exception -> L9
            this.L$0 = r14;     // Catch: Exception -> L9
            this.label = 1;     // Catch: Exception -> L9
            Object r8 = r6.n1(r14, this);     // Catch: Exception -> L9
            if (r8 != r1) goto L23;
            return r1;
        L23:
            r4 = r14;
            r11 = r8;
        L9:
            e = move-exception;
            Log.e(OfficeProfileViewModel.TAG, "loadDoubaoUserInfo error", e);
            goto L33
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadProfile$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadProfile$1", f = "OfficeProfileViewModel.kt", i = {0, 1, 1, 2}, l = {189, 193, 206}, m = "invokeSuspend", n = {"isLocalFail", "localResult", "isLocalFail", "isLocalFail"}, s = {"I$0", "L$0", "I$0", "I$0"})
    public static final class C03871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C03871(OfficeProfileViewModel r1, Continuation<? super C03871> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03871(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            int r2 = this.I$0;
            ResultKt.throwOnFailure(r11);
        L33:
            final q1c.b r12 = (q1c.b) r11;
            if ((r12 instanceof q1c.b.C0179b) == false) goto L37;
            final boolean r3 = OfficeProfileViewModel.access$loadIsOnLeave(this.this$0, (q1c.b.C0179b) r12);
            final OfficeProfileViewModel r4 = this.this$0;
            OfficeProfileViewModel.access$updateState(r4, new AnonymousClass2(r4, r3, r12));
            OfficeProfileViewModel.access$loadDescriptionSpan(this.this$0);
            OfficeProfileViewModel.access$loadDoubaoUserInfo(this.this$0);
            OfficeProfileViewModel.access$loadDoubaoHomepageData(this.this$0);
            OfficeProfileViewModel.access$markChatApplicationMeReadIfNeeded(this.this$0);
        L41:
            return Unit.INSTANCE;
        L37:
            if ((r12 instanceof q1c.b.a) == false) goto L41;
            if (r2 == 0) goto L41;
            final OfficeProfileViewModel r5 = this.this$0;
            OfficeProfileViewModel.access$updateState(r5, new AnonymousClass3(r5, r12));
            goto L41
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r6 = this.I$0;
            final q1c.b r7 = (q1c.b) this.L$0;
            ResultKt.throwOnFailure(r11);
        L25:
            final v1c.a r13 = (v1c.a) r11;
            final boolean r8 = OfficeProfileViewModel.access$loadIsOnLeave(this.this$0, (q1c.b.C0179b) r7);
            final OfficeProfileViewModel r9 = this.this$0;
            OfficeProfileViewModel.access$updateState(r9, new C01151(r9, r13, r8, r7));
            OfficeProfileViewModel.access$loadDescriptionSpan(this.this$0);
        L29:
            OfficeProfileViewModel r14 = this.this$0;
            this.L$0 = null;
            this.I$0 = r6;
            this.label = 3;
            r11 = OfficeProfileViewModel.access$loadProfile(r14, true, this);
            if (r11 != r0) goto L32;
            return r0;
        L32:
            r2 = r6;
            goto L33
        L11:
            r6 = this.I$0;
            ResultKt.throwOnFailure(r11);
        L15:
            q1c.b r15 = (q1c.b) r11;
            if ((r15 instanceof q1c.b.C0179b) == false) goto L27;
            GetDoubaoProfileResponse.UserInfo r10 = ((GetDoubaoProfileResponse) ((q1c.b.C0179b) r15).a).user_info;
            if (r10 == null) goto L20;
            String r16 = r10.extra_info;
        L21:
            Log.i(OfficeProfileViewModel.TAG, "loadProfile local extra_info=" + r16);
            OfficeProfileViewModel r17 = this.this$0;
            this.L$0 = r15;
            this.I$0 = r6;
            this.label = 2;
            Object r18 = OfficeProfileViewModel.access$parseDoubaoData(r17, r16, this);
            if (r18 != r0) goto L24;
            return r0;
        L24:
            r7 = r15;
            r11 = r18;
            goto L25
        L20:
            r16 = null;
            goto L21
        L27:
            if ((r15 instanceof q1c.b.a) == false) goto L29;
            r6 = 1;
            goto L29
        L12:
            ResultKt.throwOnFailure(r11);
            OfficeProfileViewModel r19 = this.this$0;
            r6 = 0;
            this.I$0 = 0;
            this.label = 1;
            r11 = OfficeProfileViewModel.access$loadProfile(r19, false, this);
            if (r11 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$markChatApplicationMeReadIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$markChatApplicationMeReadIfNeeded$1", f = "OfficeProfileViewModel.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $applicationId;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C03881(OfficeProfileViewModel r1, String r2, Continuation<? super C03881> r3) {
            this.this$0 = r1;
            this.$applicationId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03881(this.this$0, this.$applicationId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v3, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileModel$updateChatApplicationMeRead$2$1] */
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            OfficeProfileModel r6 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            List r2 = CollectionsKt.listOf(this.$applicationId);
            this.label = 1;
            r6.getClass();
            final kotlinx.coroutines.j r7 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
            r7.C();
            Log.i("OfficeProfileModel", "start updateChatApplicationMeRead, applicationIds: " + r2);
            OfficeProfileModule.a().getContactDependency().d(r2, new OfficeProfileModel$updateChatApplicationMeRead$2$1(r7));
            Object r8 = r7.B();
            if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
            DebugProbesKt.probeCoroutineSuspended(this);
        L11:
            if (r8 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$parseDoubaoData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/profile_office/userprofile/model/DoubaoData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$parseDoubaoData$2", f = "OfficeProfileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03892 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super v1c.a>, Object> {
        final /* synthetic */ String $extraInfo;
        int label;

        public C03892(String r1, Continuation<? super C03892> r2) {
            this.$extraInfo = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03892(this.$extraInfo, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super v1c.a> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r3);
            String r4 = this.$extraInfo;
            if (r4 != null) goto L7;
        L10:
            boolean r5 = true;
        L11:
            if (r5 == true) goto L19;
            Gson r6 = e0.a;
            v1c.a r7 = (v1c.a) e0.a(this.$extraInfo, v1c.a.class);
            if (r7 == null) goto L16;
            return r7;
        L16:
            return new v1c.a(0);
        L19:
            return new v1c.a(0);
        L7:
            if (r4.length() == 0) goto L10;
            r5 = false;
            goto L11
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$saveAlias$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$saveAlias$1", f = "OfficeProfileViewModel.kt", i = {}, l = {410, 420}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $alias;
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C03911(OfficeProfileViewModel r1, String r2, Continuation<? super C03911> r3) {
            this.this$0 = r1;
            this.$alias = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03911(this.this$0, this.$alias, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L19:
            OfficeProfileViewModel.access$updateDialogState(this.this$0, AnonymousClass3.INSTANCE);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L13:
            q1c.b r7 = (q1c.b) r6;
            if ((!(r7 instanceof q1c.b.a)) == false) goto L16;
            OfficeProfileViewModel.access$updateDialogState(this.this$0, AnonymousClass2.INSTANCE);
            OfficeProfileViewModel.access$updateProfile(this.this$0);
            goto L21
        L16:
            OfficeProfileViewModel r2 = this.this$0;
            j.k r3 = new j.k(OfficeProfileViewModel.access$getRequestFailToastMessage(r2, ((q1c.b.a) r7).a));
            this.label = 2;
            if (OfficeProfileViewModel.access$emitEffect(r2, r3, this) != r0) goto L19;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            OfficeProfileViewModel.access$updateDialogState(this.this$0, C01161.INSTANCE);
            OfficeProfileState r8 = (OfficeProfileState) OfficeProfileViewModel.access$get_state$p(this.this$0).getValue();
            OfficeProfileModel r4 = OfficeProfileViewModel.access$getModel$p(this.this$0);
            String r9 = r8.l();
            String r5 = this.$alias;
            this.label = 1;
            r6 = r4.c(r9, r5, this);
            if (r6 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$updateProfile$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$updateProfile$1", f = "OfficeProfileViewModel.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ OfficeProfileViewModel this$0;

        public C03921(OfficeProfileViewModel r1, Continuation<? super C03921> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03921(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            final q1c.b r5 = (q1c.b) r4;
            if ((r5 instanceof q1c.b.C0179b) == false) goto L15;
            final boolean r2 = OfficeProfileViewModel.access$loadIsOnLeave(this.this$0, (q1c.b.C0179b) r5);
            final OfficeProfileViewModel r3 = this.this$0;
            OfficeProfileViewModel.access$updateState(r3, new C01171(r3, r2, r5));
            OfficeProfileViewModel.access$loadDescriptionSpan(this.this$0);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            Log.i(OfficeProfileViewModel.TAG, "start updateProfile");
            OfficeProfileViewModel r6 = this.this$0;
            this.label = 1;
            r4 = OfficeProfileViewModel.access$loadProfile(r6, true, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDescriptionSpan$2] */
    private final void loadDescriptionSpan() {
        final OfficeProfileState r0 = (OfficeProfileState) this._state.getValue();
        final String r1 = r0.g();
        final String r2 = r0.l();
        boolean r4 = false;
        if (r1.length() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        return;
    L8:
        if (r2.length() != 0) goto L10;
        r4 = true;
    L10:
        if (r4 == true) goto L18;
        int r5 = w1c.b.a;
        String r6 = k6b.c.a(r2, r1, r0.f());
        final RecogniseSpansResult r7 = f0.a.a.a(r6);
        if (r7 == null) goto L15;
        updateState(new OfficeProfileViewModel$loadDescriptionSpan$1$1(r7));
    L15:
        OfficeProfileModule.a().getChatDependency().c(r1, r2, r0.f(), new C03842(this, r2, r1, r0));
        return;
    L18:
        return;
    L5:
        r3 = false;
        goto L6
    }

    private final void markChatApplicationMeReadIfNeeded() {
        q1c.b<GetDoubaoProfileResponse> r0 = ((OfficeProfileState) this._state.getValue()).a;
        if (r0 == null) goto L9;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L9;
        String r3 = r2.contact_application_id;
    L10:
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        if (r3.length() != 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
        return;
    L18:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03881(this, r3, null), 3, null);
        return;
    L15:
        r4 = false;
    L9:
        r3 = null;
        goto L10
    }

    private final void reload() {
        updateState(new C03901(this));
        loadProfile();
    }

    public final ProfileFinishResult getFinishResult() {
        OfficeProfileState r0 = (OfficeProfileState) this._state.getValue();
        if ((r0.a instanceof q1c.b.C0179b) == true) goto L6;
        return null;
    L6:
        GetDoubaoProfileResponse.ContactStatus r1 = r0.d();
        String r2 = r0.l();
        if (r2.length() != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        r2 = this.userId;
    L12:
        String r7 = r2;
        boolean r8 = r0.n();
        if (r1 != GetDoubaoProfileResponse.ContactStatus.CONTACT_DUAL) goto L15;
        boolean r9 = true;
    L17:
        if (r1 != GetDoubaoProfileResponse.ContactStatus.CONTACT_FORWARD) goto L19;
        boolean r10 = true;
    L21:
        if (r1 != GetDoubaoProfileResponse.ContactStatus.CONTACT_REVERSE) goto L23;
        boolean r11 = true;
    L25:
        return new ProfileFinishResult(r7, r8, r9, r10, r11);
    L23:
        r11 = false;
        goto L25
    L19:
        r10 = false;
        goto L21
    L15:
        r9 = false;
        goto L17
    L9:
        r3 = false;
        goto L10
    }

    public final String getReportUrl() {
        String r1 = ((OfficeProfileState) this._state.getValue()).l();
        boolean r3 = false;
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        r1 = this.userId;
    L9:
        if (r1.length() != 0) goto L11;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        return "";
    L15:
        JSONObject r5 = new JSONObject().put("report_type", 10).put("report_params", new JSONObject().put("profile_params", new JSONObject().put("uid", r1)));
        TnsReportConfig r6 = (TnsReportConfig) SettingManager.getInstance().get(TnsReportConfig.class);     // Catch: Exception -> L18
    L20:
        if (r6 != null) goto L22;
        return "";
    L22:
        String r7 = encrypt(r5.toString(), r6.getToken());
        if (r7.length() != 0) goto L25;
        r3 = true;
    L25:
        if (r3 == false) goto L27;
        return "";
    L27:
        String r8 = "https://" + OfficeProfileModule.a().getReportHost() + r6.getReportPath() + "?params=" + r7 + "&v=2&lang=" + getLanguageLocaleTag();
        Log.i(TAG, "getReportUrl reportUrl=" + r8);
        return r8;
    L18:
        e = move-exception;
        Log.e(TAG, "get TnsReportConfig failed", e);
        r6 = null;
        goto L20
    L11:
        r4 = false;
        goto L13
    L5:
        r2 = false;
        goto L6
    }

    private final void acceptFriend() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    private final void deleteFriend() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03801(this, null), 3, null);
    }

    private final String getLanguageLocaleTag() {
        yob.e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        apb.b r1 = com.ss.android.lark.language.service.impl.a.b.a;
        return r1.d(r1.getCacheLanguageSetting());
    }

    private final void loadDoubaoHomepageData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03851(this, null), 3, null);
    }

    private final void loadDoubaoUserInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03861(this, null), 3, null);
    }

    private final void loadProfile() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03871(this, null), 3, null);
    }

    private final void registerUrlPreviewsPush() {
        OfficeProfileModule.a().getPushDependency().a(this.signUrlPreviewPushListener);
    }

    private final void unRegisterUrlPreviewPush() {
        OfficeProfileModule.a().getPushDependency().b(this.signUrlPreviewPushListener);
    }

    private final void updateProfile() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03921(this, null), 3, null);
    }

    public void onCleared() {
        unRegisterUrlPreviewPush();
        super.onCleared();
    }

    public final i1<d> getDialogState() {
        return this.dialogState;
    }

    public final d1<j> getEffect() {
        return this.effect;
    }

    public final x1c.d getOfficeProfileProtocol() {
        return this.officeProfileProtocol;
    }

    public final i1<OfficeProfileState> getState() {
        return this.state;
    }

    public static final /* synthetic */ OfficeProfileModel access$getModel$p(OfficeProfileViewModel r0) {
        return r0.model;
    }

    public static final /* synthetic */ ContactSource access$getSource$p(OfficeProfileViewModel r0) {
        return r0.source;
    }

    public static final /* synthetic */ z0 access$get_state$p(OfficeProfileViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ void access$loadDescriptionSpan(OfficeProfileViewModel r0) {
        r0.loadDescriptionSpan();
    }

    public static final /* synthetic */ void access$loadDoubaoHomepageData(OfficeProfileViewModel r0) {
        r0.loadDoubaoHomepageData();
    }

    public static final /* synthetic */ void access$loadDoubaoUserInfo(OfficeProfileViewModel r0) {
        r0.loadDoubaoUserInfo();
    }

    public static final /* synthetic */ void access$markChatApplicationMeReadIfNeeded(OfficeProfileViewModel r0) {
        r0.markChatApplicationMeReadIfNeeded();
    }

    public static final /* synthetic */ void access$updateProfile(OfficeProfileViewModel r0) {
        r0.updateProfile();
    }

    private final void blockUser(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03791(this, r7, null), 3, null);
    }

    private final void emitEffectAsync(j r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03821(this, r7, null), 3, null);
    }

    private final String getRequestFailToastMessage(ErrorResult r3) {
        if (NetworkUtils.d(LarkContext.getApplication()) == false) goto L5;
        String r4 = r3.getDisplayMsg();
        if (r4 != null) goto L10;
        r4 = "";
    L10:
        if (r4.length() != 0) goto L12;
        boolean r0 = true;
    L13:
        if (r0 == true) goto L15;
        return r4;
    L15:
        return UIHelper.getString(2131889968);
    L12:
        r0 = false;
        goto L13
    L5:
        return UIHelper.getString(2131889968);
    }

    private final void handleCtaClick(GetDoubaoProfileResponse.CTAInfo r3) {
        if (Intrinsics.areEqual(r3.key, "__mock_chat__") == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r3.enable, Boolean.TRUE) == true) goto L9;
        emitEffectAsync(new j.k(w1c.a.a(r3.denied_description)));
        return;
    L9:
        GetDoubaoProfileResponse.CTAType r4 = r3.cta_type;
        if (r4 != null) goto L12;
        int r5 = -1;
    L14:
        if (r5 != 1) goto L17;
        reportHomePageClick("send_message");
        emitEffectAsync(new j.d(((OfficeProfileState) this._state.getValue()).l()));
        return;
    L17:
        return;
    L12:
        r5 = b.a[r4.ordinal()];
        goto L14
    }

    private final void handleSignUrlPreviewPush(List<UrlPreViewEntries> r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03831(this, r7, null), 3, null);
    }

    private final boolean loadIsOnLeave(q1c.b.C0179b<GetDoubaoProfileResponse> r9) {
        long r0 = cac.b.a.a.a(MmUploadRetryConfigSetting.MAX_INTERVAL_MS) / 1000;
        GetDoubaoProfileResponse.UserInfo r10 = r9.a.user_info;
        if (r10 == null) goto L5;
        List r11 = r10.chatter_status;
    L6:
        if (r11 != null) goto L8;
        r11 = CollectionsKt.emptyList();
    L8:
        List r12 = r11;
        if ((r12 instanceof Collection) == true) goto L11;
    L13:
        Iterator r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L38;
        Chatter.ChatterCustomStatus r2 = (Chatter.ChatterCustomStatus) r13.next();
        StatusEffectiveInterval r4 = r2.effective_interval;
        if (r4 != null) goto L20;
    L18:
        boolean r3 = false;
    L29:
        if (r3 == false) goto L15;
        return true;
    L20:
        if (Intrinsics.areEqual(r2.icon_key, ON_LEAVE_STATUS_ICON_KEY) == false) goto L18;
        Long r5 = r4.start_time;
        if (r0 <= r4.end_time.longValue()) goto L24;
    L26:
        boolean r6 = false;
    L27:
        if (r6 == false) goto L18;
        r3 = true;
        goto L29
    L24:
        if (r5.longValue() > r0) goto L26;
        r6 = true;
        goto L27
    L38:
        return false;
    L11:
        if (r12.isEmpty() == false) goto L13;
        return false;
    L5:
        r11 = null;
        goto L6
    }

    private final void reportEnterPageIfNeeded(String r6) {
        if (this.hasReportedEnterPage == false) goto L5;
        return;
    L5:
        int r0 = f.a;
        ContactSource r1 = this.source;
        Intrinsics.checkNotNullParameter(r6, "doubaoUserId");
        JSONObject r2 = new JSONObject().put("current_page", "home_page");
        if (r1 == null) goto L8;
        Integer r3 = Integer.valueOf(r1.getSourceType());
    L10:
        if (r3 != null) goto L13;
    L15:
        if (r3 != null) goto L18;
    L20:
        if (r3 != null) goto L23;
    L25:
        if (r3 != null) goto L28;
    L30:
        if (r3 != null) goto L33;
    L35:
        if (r3 != null) goto L38;
    L40:
        if (r3 != null) goto L43;
    L45:
        if (r3 != null) goto L48;
    L50:
        if (r3 != null) goto L53;
    L55:
        if (r3 != null) goto L58;
    L60:
        if (r3 != null) goto L63;
    L65:
        if (r3 != null) goto L68;
    L70:
        if (r3 != null) goto L73;
    L75:
        if (r3 != null) goto L78;
    L80:
        if (r3 != null) goto L83;
    L85:
        if (r3 != null) goto L88;
    L90:
        if (r3 != null) goto L93;
    L95:
        if (r3 != null) goto L98;
    L100:
        if (r3 != null) goto L103;
    L105:
        if (r3 != null) goto L108;
    L110:
        String r4 = "unknown";
    L111:
        Statistics.sendEvent("enter_page", r2.put("enter_method", r4).put("home_page_user_id", r6));
        this.hasReportedEnterPage = true;
        return;
    L108:
        if (r3.intValue() != 10002) goto L110;
        r4 = "push";
        goto L111
    L103:
        if (r3.intValue() != 10001) goto L105;
        r4 = "meego";
        goto L111
    L98:
        if (r3.intValue() != 21) goto L100;
        r4 = "search_doubao_id";
        goto L111
    L93:
        if (r3.intValue() != 20) goto L95;
        r4 = "minutes";
        goto L111
    L88:
        if (r3.intValue() != 19) goto L90;
        r4 = "special_focus";
        goto L111
    L83:
        if (r3.intValue() != 14) goto L85;
        r4 = "contactcards";
        goto L111
    L78:
        if (r3.intValue() != 18) goto L80;
        r4 = "new_contact";
        goto L111
    L73:
        if (r3.intValue() != 17) goto L75;
        r4 = "external_contact";
        goto L111
    L68:
        if (r3.intValue() != 11) goto L70;
        r4 = "community";
        goto L111
    L63:
        if (r3.intValue() != 10) goto L65;
        r4 = "search_contact";
        goto L111
    L58:
        if (r3.intValue() != 9) goto L60;
        r4 = "search_email";
        goto L111
    L53:
        if (r3.intValue() != 8) goto L55;
        r4 = "search_phone";
        goto L111
    L48:
        if (r3.intValue() != 7) goto L50;
        r4 = "name_card";
        goto L111
    L43:
        if (r3.intValue() != 6) goto L45;
        r4 = "email";
        goto L111
    L38:
        if (r3.intValue() != 5) goto L40;
        r4 = "vc";
        goto L111
    L33:
        if (r3.intValue() != 4) goto L35;
        r4 = "docs";
        goto L111
    L28:
        if (r3.intValue() != 3) goto L30;
        r4 = "calendar";
        goto L111
    L23:
        if (r3.intValue() != 2) goto L25;
        r4 = "chat";
        goto L111
    L18:
        if (r3.intValue() != 1) goto L20;
        r4 = "link";
        goto L111
    L13:
        if (r3.intValue() != 0) goto L15;
        r4 = "unknown_source";
        goto L111
    L8:
        r3 = null;
        goto L10
    }

    private final void reportHomePageClick(String r5) {
        int r0 = f.a;
        String r1 = ((OfficeProfileState) this._state.getValue()).f.a();
        Intrinsics.checkNotNullParameter(r1, "doubaoUserId");
        Intrinsics.checkNotNullParameter(r5, PickerReporterConstants.KEY.CLICK);
        Statistics.sendEvent("home_page_click", new JSONObject().put("current_page", "home_page").put("home_page_user_id", r1).put("click_from", r5));
    }

    private final void saveAlias(String r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03911(this, r7, null), 3, null);
    }

    private final void updateDialogState(Function1<? super d, d> r3) {
        z0<d> r0 = this._dialogState;
        r0.setValue(r3.invoke(r0.getValue()));
    }

    private final void updateState(Function1<? super OfficeProfileState, OfficeProfileState> r3) {
        z0<OfficeProfileState> r0 = this._state;
        r0.setValue(r3.invoke(r0.getValue()));
    }

    public final void dispatch(final k r4) {
        Intrinsics.checkNotNullParameter(r4, "intent");
        if ((r4 instanceof k.i) == false) goto L6;
        k.i r5 = (k.i) r4;
        init(r5.a, r5.b, r5.c);
        return;
    L6:
        if (Intrinsics.areEqual(r4, k.m.a) == false) goto L9;
        reload();
        return;
    L9:
        if (Intrinsics.areEqual(r4, k.c.a) == false) goto L12;
        emitEffectAsync(j.c.a);
        return;
    L12:
        if (Intrinsics.areEqual(r4, k.l.a) == false) goto L15;
        emitEffectAsync(j.h.a);
        return;
    L15:
        if ((r4 instanceof k.e) == false) goto L18;
        handleCtaClick(((k.e) r4).a);
        return;
    L18:
        if ((r4 instanceof k.j) == false) goto L21;
        emitEffectAsync(new j.g(((k.j) r4).a));
        return;
    L21:
        if ((r4 instanceof k.h) == false) goto L24;
        emitEffectAsync(new j.f(((k.h) r4).a));
        return;
    L24:
        if ((r4 instanceof k.g) == false) goto L27;
        emitEffectAsync(new j.e(((k.g) r4).a));
        return;
    L27:
        if (Intrinsics.areEqual(r4, k.v.a) == false) goto L30;
        emitEffectAsync(j.C0118j.a);
        return;
    L30:
        if (Intrinsics.areEqual(r4, k.C0119k.a) == false) goto L33;
        reportHomePageClick("doubao_home_page");
        emitEffectAsync(j.b.a);
        return;
    L33:
        if (Intrinsics.areEqual(r4, k.n.a) == false) goto L36;
        emitEffectAsync(j.i.a);
        return;
    L36:
        if (Intrinsics.areEqual(r4, k.a.a) == false) goto L39;
        reportHomePageClick("accept");
        acceptFriend();
        return;
    L39:
        if ((r4 instanceof k.d) == false) goto L42;
        blockUser(((k.d) r4).a);
        return;
    L42:
        if (Intrinsics.areEqual(r4, k.f.a) == false) goto L45;
        deleteFriend();
        return;
    L45:
        if ((r4 instanceof k.o) == false) goto L48;
        saveAlias(((k.o) r4).a);
        return;
    L48:
        if ((r4 instanceof k.b) == false) goto L51;
        int r0 = f.a;
        String r1 = ((OfficeProfileState) this._state.getValue()).f.a();
        Intrinsics.checkNotNullParameter(r1, "doubaoUserId");
        Statistics.sendEvent("send_add_friend_apply", new JSONObject().put("home_page_user_id", r1));
        k.b r6 = (k.b) r4;
        applyFriend(r6.a, r6.b);
        return;
    L51:
        if ((r4 instanceof k.t) == false) goto L54;
        updateDialogState(new C03811(r4));
        return;
    L54:
        if ((r4 instanceof k.p) == false) goto L60;
        if (((k.p) r4).a == false) goto L58;
        reportHomePageClick("apply");
    L58:
        updateDialogState(new AnonymousClass2(r4));
        return;
    L60:
        if ((r4 instanceof k.s) == false) goto L63;
        updateState(new AnonymousClass3(r4));
        return;
    L63:
        if ((r4 instanceof k.u) == false) goto L66;
        updateDialogState(new AnonymousClass4(r4));
        return;
    L66:
        if ((r4 instanceof k.r) == false) goto L69;
        updateDialogState(new AnonymousClass5(r4));
        return;
    L69:
        if ((r4 instanceof k.q) == false) goto L73;
        updateDialogState(new AnonymousClass6(r4));
        return;
    L73:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ String access$getRequestFailToastMessage(OfficeProfileViewModel r0, ErrorResult r1) {
        return r0.getRequestFailToastMessage(r1);
    }

    public static final /* synthetic */ void access$handleSignUrlPreviewPush(OfficeProfileViewModel r0, List r1) {
        r0.handleSignUrlPreviewPush(r1);
    }

    public static final /* synthetic */ boolean access$loadIsOnLeave(OfficeProfileViewModel r0, q1c.b.C0179b r1) {
        return r0.loadIsOnLeave(r1);
    }

    public static final /* synthetic */ void access$reportEnterPageIfNeeded(OfficeProfileViewModel r0, String r1) {
        r0.reportEnterPageIfNeeded(r1);
    }

    public static final /* synthetic */ void access$updateDialogState(OfficeProfileViewModel r0, Function1 r1) {
        r0.updateDialogState(r1);
    }

    public static final /* synthetic */ void access$updateState(OfficeProfileViewModel r0, Function1 r1) {
        r0.updateState(r1);
    }

    private final void applyFriend(String r7, String r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03781(this, r7, r8, null), 3, null);
    }

    private final Object emitEffect(j r2, Continuation<? super Unit> r3) {
        Object r4 = this._effect.emit(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    private final String encrypt(String r7, String r8) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return "";
    L7:
        if (r8.length() < 16) goto L14;
        Charset r2 = Charsets.UTF_8;
        SecretKeySpec r0 = new SecretKeySpec(r8.getBytes(r2), CIPHER);
        Cipher r3 = Cipher.getInstance(AES_MODE, PROVIDER);
        r3.init(1, r0, new IvParameterSpec(r8.substring(0, 16).getBytes(r2)));
        return new String(Base64.encode(r3.doFinal(r7.getBytes(r2)), 10), r2);
    L14:
        return "";
    }

    private final Object loadProfile(boolean r4, Continuation<? super q1c.b<GetDoubaoProfileResponse>> r5) {
        boolean r1 = true;
        if (this.userId.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return this.model.b(this.userId, r4, r5);
    L10:
        if (this.token.length() > 0) goto L13;
        r1 = false;
    L13:
        if (r1 == false) goto L17;
        return this.model.a(this.token, r4, r5);
    L17:
        return new q1c.b.a(new ErrorResult("illegal arguments"));
    L5:
        r0 = false;
        goto L6
    }

    private final Object parseDoubaoData(String r4, Continuation<? super v1c.a> r5) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new C03892(r4, null), r5);
    }

    @Inject
    public OfficeProfileViewModel(OfficeProfileModel r3, x1c.d r4, IOfficeSDKTokenProvider r5) {
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "officeProfileProtocol");
        Intrinsics.checkNotNullParameter(r5, "officeSDKTokenProvider");
        this.model = r3;
        this.officeProfileProtocol = r4;
        IOfficeSDKBizConfigProvider r6 = OfficeSDKManager.getBizConfigProvider();
        if (r6 == null) goto L7;
        boolean r0 = true;
        if (r6.isEnabled(IOfficeSDKBizConfigProvider.Biz.IM) != true) goto L7;
    L8:
        this.isIMEnabled = r0;
        boolean r7 = r5.isDoubaoBUser();
        this.isLoginBUser = r7;
        StateFlowImpl r8 = j1.a(new OfficeProfileState(r0, r7, 8179));
        this._state = r8;
        this.state = kotlinx.coroutines.flow.e.b(r8);
        StateFlowImpl r9 = j1.a(new d(0));
        this._dialogState = r9;
        this.dialogState = kotlinx.coroutines.flow.e.b(r9);
        MutableSharedFlow<j> r10 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._effect = r10;
        this.effect = kotlinx.coroutines.flow.e.a(r10);
        this.userId = "";
        this.token = "";
        this.signUrlPreviewPushListener = new c(this);
        registerUrlPreviewsPush();
        return;
    L7:
        r0 = false;
        goto L8
    }

    public static final /* synthetic */ Object access$emitEffect(OfficeProfileViewModel r0, j r1, Continuation r2) {
        return r0.emitEffect(r1, r2);
    }

    public static final /* synthetic */ Object access$loadProfile(OfficeProfileViewModel r0, boolean r1, Continuation r2) {
        return r0.loadProfile(r1, r2);
    }

    public static final /* synthetic */ Object access$parseDoubaoData(OfficeProfileViewModel r0, String r1, Continuation r2) {
        return r0.parseDoubaoData(r1, r2);
    }

    private final void init(String r2, String r3, ContactSource r4) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        this.userId = r2;
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        this.token = r3;
        this.source = r4;
        Log.i(TAG, "init, isIMEnabled=" + this.isIMEnabled + ", isLoginBUser=" + this.isLoginBUser);
        loadProfile();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v28, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    private final OfficeProfileState withProfileResponse(OfficeProfileState r29, q1c.b<GetDoubaoProfileResponse> r30, boolean r31) {
        String r0 = r29.g();
        Long r1 = r29.f();
        if (r30 == null) goto L9;
        GetDoubaoProfileResponse r3 = r30.a();
        if (r3 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r4 = r3.user_info;
        if (r4 == null) goto L9;
        Chatter.Description r5 = r4.description;
    L10:
        if (r5 == null) goto L12;
        String r6 = r5.text;
    L13:
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        boolean r13 = true;
        if (Intrinsics.areEqual(r0, r6) == false) goto L24;
        if (r5 == null) goto L19;
        Long r2 = r5.description_id;
    L21:
        if (Intrinsics.areEqual(r1, r2) == false) goto L24;
        boolean r7 = false;
    L26:
        if (r30 == null) goto L28;
        GetDoubaoProfileResponse r8 = r30.a();
    L29:
        if (r8 == null) goto L49;
        GetDoubaoProfileResponse.UserInfo r9 = r8.user_info;
        if (r9 == null) goto L49;
        GetDoubaoProfileResponse.DepartmentInfo r10 = r9.department_info;
        if (r10 == null) goto L49;
        List r11 = r10.department_list;
        if (r11 == null) goto L49;
        List r12 = r11;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r15 = r12.iterator();
    L38:
        if (r15.hasNext() == false) goto L40;
        r14.add(w1c.a.a(((GetDoubaoProfileResponse.DepartmentInfo.Department) r15.next()).department_name));
        goto L38
    L40:
        ?? r16 = new ArrayList();
        Iterator r17 = r14.iterator();
    L42:
        if (r17.hasNext() == false) goto L50;
        Object r18 = r17.next();
        if (((String) r18).length() <= 0) goto L46;
        boolean r19 = true;
    L47:
        if (r19 == false) goto L42;
        r16.add(r18);
        goto L42
    L46:
        r19 = false;
    L50:
        if (r16 != 0) goto L52;
        r16 = CollectionsKt.emptyList();
    L52:
        ?? r20 = r16;
        if (r30 == null) goto L55;
        GetDoubaoProfileResponse r21 = r30.a();
    L56:
        if (r21 == null) goto L60;
        GetDoubaoProfileResponse.UserInfo r22 = r21.user_info;
        if (r22 == null) goto L60;
        GetDoubaoProfileResponse.BlockStatus r23 = r22.block_status;
    L62:
        if (r23 != GetDoubaoProfileResponse.BlockStatus.BLOCK_FORWARD) goto L64;
    L67:
        boolean r24 = true;
    L68:
        com.ss.android.lark.compose.foundation.widget.a r25 = new com.ss.android.lark.compose.foundation.widget.a(r24, false);
        if (r7 == false) goto L71;
        RecogniseSpansResult r110 = null;
    L72:
        OfficeProfileState r111 = OfficeProfileState.a(r29, r30, r31, null, null, null, r20, false, false, r25, r110, false, 4988);
        l.a.getClass();
        Intrinsics.checkNotNullParameter(r111, "state");
        q1c.b<GetDoubaoProfileResponse> r26 = r111.a;
        if (r26 == null) goto L82;
        GetDoubaoProfileResponse r27 = r26.a();
        if (r27 == null) goto L82;
        if (r111.b == true) goto L82;
        if (r27.edition != GetDoubaoProfileRequest.DoubaoProfileEdition.EDITION_UNKNOWN) goto L82;
    L83:
        if (r13 == false) goto L85;
        Set r112 = SetsKt.emptySet();
    L93:
        return OfficeProfileState.a(r111, null, false, r112, null, null, null, false, false, null, null, false, 8175);
    L85:
        Set<l> r28 = l.d.b;
        LinkedHashSet r32 = new LinkedHashSet();
        Iterator r33 = r28.iterator();
    L87:
        if (r33.hasNext() == false) goto L91;
        Object r34 = r33.next();
        if (((l) r34).a(r111) == false) goto L87;
        r32.add(r34);
        goto L87
    L91:
        r112 = r32;
    L82:
        r13 = false;
        goto L83
    L71:
        r110 = r29.l;
        goto L72
    L64:
        if (r23 == GetDoubaoProfileResponse.BlockStatus.BLOCK_DUAL) goto L67;
        r24 = false;
    L60:
        r23 = null;
        goto L62
    L55:
        r21 = null;
    L49:
        r16 = 0;
        goto L50
    L28:
        r8 = null;
        goto L29
    L19:
        r2 = null;
    L24:
        r7 = true;
        goto L26
    L12:
        r6 = null;
    L9:
        r5 = null;
        goto L10
    }

    public static final /* synthetic */ OfficeProfileState access$withProfileResponse(OfficeProfileViewModel r0, OfficeProfileState r1, q1c.b r2, boolean r3) {
        return r0.withProfileResponse(r1, r2, r3);
    }
}
