package com.larus.profile.impl.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.network.http.AsyncLiveData;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.f;
import com.larus.network.http.w;
import com.larus.platform.service.AccountService;
import com.tencent.open.log.TraceLevel;
import fs9.d;
import fs9.o;
import fs9.s;
import fs9.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001e\u001a\u00020\u000fJ\u0016\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0019J\u000e\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0019R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006$"}, d2 = {"Lcom/larus/profile/impl/viewmodel/ProfileRegisterViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_userNameAvailable", "Lcom/larus/network/http/AsyncLiveData;", "Lcom/larus/profile/api/bean/CheckUserNameResponse;", "userNameAvailable", "Landroidx/lifecycle/LiveData;", "Lcom/larus/network/http/Async;", "getUserNameAvailable", "()Landroidx/lifecycle/LiveData;", "checkNameJob", "Lkotlinx/coroutines/Job;", "_editProfileState", "Lcom/larus/profile/api/bean/UpdateProfileResponse;", "editProfileState", "getEditProfileState", "_initProfileState", "Lcom/larus/profile/api/bean/ProfileBriefResponse;", "initProfileState", "getInitProfileState", "uploadAvatarUrl", "", "getUploadAvatarUrl", "()Ljava/lang/String;", "setUploadAvatarUrl", "(Ljava/lang/String;)V", "initUserInfo", "editUserInfo", "nickname", "userName", "checkUserName", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileRegisterViewModel extends AndroidViewModel {
    private final AsyncLiveData<y> _editProfileState;
    private final AsyncLiveData<s> _initProfileState;
    private final AsyncLiveData<d> _userNameAvailable;
    private Job checkNameJob;
    private final LiveData<com.larus.network.http.a<y>> editProfileState;
    private final LiveData<com.larus.network.http.a<s>> initProfileState;
    private String uploadAvatarUrl;
    private final LiveData<com.larus.network.http.a<d>> userNameAvailable;

    /* JADX INFO: renamed from: com.larus.profile.impl.viewmodel.ProfileRegisterViewModel$checkUserName$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.viewmodel.ProfileRegisterViewModel$checkUserName$1", f = "ProfileRegisterViewModel.kt", i = {}, l = {143, 144}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userName;
        int label;
        final /* synthetic */ ProfileRegisterViewModel this$0;

        public AnonymousClass1(ProfileRegisterViewModel r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$userName = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$userName, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            ResultKt.throwOnFailure(r14);
            Object r1 = r14;
        L16:
            AsyncLiveData r2 = ProfileRegisterViewModel.access$get_userNameAvailable$p(this.this$0);
            r2.postValue((com.larus.network.http.a) r1);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r14);
        L13:
            JSONObject r4 = new JSONObject();
            r4.put("user_name", this.$userName);
            Unit r5 = Unit.INSTANCE;
            this.label = 2;
            r1 = HttpExtKt.k("Social", d.class, "/alice/profile/user_name_unique", r4, null, null, false, null, null, null, this, 1008);
            if (r1 != r12) goto L16;
            return r12;
        L10:
            ResultKt.throwOnFailure(r14);
            this.label = 1;
            if (DelayKt.delay(1000, this) != r12) goto L13;
            return r12;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.viewmodel.ProfileRegisterViewModel$editUserInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.viewmodel.ProfileRegisterViewModel$editUserInfo$1", f = "ProfileRegisterViewModel.kt", i = {1}, l = {88, 106}, m = "invokeSuspend", n = {"updateResult"}, s = {"L$0"})
    public static final class C01081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $nickname;
        final /* synthetic */ String $userName;
        Object L$0;
        int label;
        final /* synthetic */ ProfileRegisterViewModel this$0;

        public C01081(ProfileRegisterViewModel r1, String r2, String r3, Continuation<? super C01081> r4) {
            this.this$0 = r1;
            this.$nickname = r2;
            this.$userName = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01081(this.this$0, this.$nickname, this.$userName, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            com.larus.network.http.a r1 = (com.larus.network.http.a) this.L$0;
            ResultKt.throwOnFailure(r18);
            com.larus.network.http.a r14 = r1;
            Object r2 = r18;
        L21:
            com.larus.network.http.y r3 = (com.larus.network.http.a) r2;
            if ((r3 instanceof com.larus.network.http.y) == false) goto L33;
            s r4 = (s) ((com.larus.network.http.a) r3).b;
            if (r4 == null) goto L28;
            r38.b r5 = r4.b();
            if (r5 == null) goto L28;
            IAccountService.Companion r6 = IAccountService.a;
            r6.l(r5);
            r6.o(AccountService.a.getUserId(), r5.c(), "edit_register_profile");
        L28:
            if (r4 == null) goto L35;
            o r7 = r4.a();
            if (r7 == null) goto L35;
            IAccountService.a.j(r7.b());
        L35:
            ProfileRegisterViewModel.access$get_editProfileState$p(this.this$0).postValue(r14);
        L37:
            return Unit.INSTANCE;
        L33:
            if ((r3 instanceof f) == false) goto L35;
            IAccountService.Companion r8 = IAccountService.a;
            String r9 = ILoginService.a.getAccountInfo().c;
            String r10 = this.$nickname;
            String r11 = this.this$0.getUploadAvatarUrl();
            r8.l(new r38.b(r9, r10, null, new AvatarInfo(this.this$0.getUploadAvatarUrl(), r11, 1), 1001));
            goto L35
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r18);
            Object r13 = r18;
        L13:
            com.larus.network.http.a r15 = (com.larus.network.http.a) r13;
            if ((r15 instanceof f) == false) goto L17;
            ProfileRegisterViewModel.access$get_editProfileState$p(this.this$0).postValue(r15);
            goto L37
        L17:
            if ((r15 instanceof com.larus.network.http.y) == false) goto L37;
            IAccountService.a.m();
            FlowDowngradeServiceDelegate r16 = FlowDowngradeServiceDelegate.INSTANCE;
            JSONObject r17 = new JSONObject();
            Map r19 = MapsKt.mapOf(TuplesKt.to("source", "edit_register_profile"));
            this.L$0 = r15;
            this.label = 2;
            r14 = r15;
            r2 = IFlowDowngradeService.a.b(r16, "Social", s.class, "/alice/profile/self_brief", r17, null, false, null, r19, this, 1008);
            if (r2 != r12) goto L21;
            return r12;
        L10:
            ResultKt.throwOnFailure(r18);
            ProfileRegisterViewModel.access$get_editProfileState$p(this.this$0).postValue(new w(null));
            FlowDowngradeServiceDelegate r20 = FlowDowngradeServiceDelegate.INSTANCE;
            JSONObject r21 = new JSONObject();
            String r22 = this.$nickname;
            String r23 = this.$userName;
            ProfileRegisterViewModel r24 = this.this$0;
            r21.put("entity_id", ILoginService.a.getAccountInfo().c);
            r21.put("nickname", r22);
            r21.put("user_name", r23);
            r21.put("avatar_url", r24.getUploadAvatarUrl());
            r21.put("is_register", true);
            Unit r25 = Unit.INSTANCE;
            Map r26 = MapsKt.mapOf(TuplesKt.to("source", "edit_register_profile"));
            this.label = 1;
            r13 = IFlowDowngradeService.a.b(r20, "Social", y.class, "/alice/profile/update_profile", r21, null, true, null, r26, this, 944);
            if (r13 != r12) goto L13;
            return r12;
        }
    }

    /* JADX INFO: renamed from: com.larus.profile.impl.viewmodel.ProfileRegisterViewModel$initUserInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.viewmodel.ProfileRegisterViewModel$initUserInfo$1", f = "ProfileRegisterViewModel.kt", i = {}, l = {46, 65}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ProfileRegisterViewModel this$0;

        public C01091(ProfileRegisterViewModel r1, Continuation<? super C01091> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01091(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            ResultKt.throwOnFailure(r18);
            Object r1 = r18;
        L20:
            com.larus.network.http.y r2 = (com.larus.network.http.a) r1;
            ProfileRegisterViewModel.access$get_initProfileState$p(this.this$0).postValue(r2);
            if ((r2 instanceof com.larus.network.http.y) == false) goto L32;
            s r3 = (s) ((com.larus.network.http.a) r2).b;
            if (r3 == null) goto L27;
            r38.b r4 = r3.b();
            if (r4 == null) goto L27;
            IAccountService.Companion r5 = IAccountService.a;
            r5.l(r4);
            r5.o(AccountService.a.getUserId(), r4.c(), "enter_register_profile");
        L27:
            if (r3 == null) goto L32;
            o r6 = r3.a();
            if (r6 == null) goto L32;
            IAccountService.a.j(r6.b());
        L32:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r18);
            Object r7 = r18;
        L14:
            if ((((com.larus.network.http.a) r7) instanceof com.larus.network.http.y) == true) goto L17;
            AsyncLiveData r8 = ProfileRegisterViewModel.access$get_initProfileState$p(this.this$0);
            AsyncThrowable.Companion.getClass();
            r8.postValue(new f(AsyncThrowable.access$getDEFAULT$cp(), null));
            return Unit.INSTANCE;
        L17:
            IAccountService.a.m();
            FlowDowngradeServiceDelegate r9 = FlowDowngradeServiceDelegate.INSTANCE;
            JSONObject r10 = new JSONObject();
            Map r11 = MapsKt.mapOf(TuplesKt.to("source", "enter_register_profile"));
            this.label = 2;
            r1 = IFlowDowngradeService.a.b(r9, "Social", s.class, "/alice/profile/self_brief", r10, null, true, null, r11, this, 944);
            if (r1 != r12) goto L20;
            return r12;
        L10:
            ResultKt.throwOnFailure(r18);
            ProfileRegisterViewModel.access$get_initProfileState$p(this.this$0).postValue(new w(null));
            FlowDowngradeServiceDelegate r13 = FlowDowngradeServiceDelegate.INSTANCE;
            JSONObject r14 = new JSONObject();
            r14.put("entity_id", ILoginService.a.getAccountInfo().c);
            r14.put("nickname", "");
            r14.put("user_name", "");
            r14.put("avatar_url", "");
            r14.put("is_register", false);
            Unit r15 = Unit.INSTANCE;
            Map r16 = MapsKt.mapOf(TuplesKt.to("source", "enter_register_profile"));
            this.label = 1;
            r7 = IFlowDowngradeService.a.b(r13, "Social", y.class, "/alice/profile/update_profile", r14, null, true, null, r16, this, 944);
            if (r7 != r12) goto L14;
            return r12;
        }
    }

    public final Job initUserInfo() {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01091(this, null), 3, null);
    }

    public final LiveData<com.larus.network.http.a<y>> getEditProfileState() {
        return this.editProfileState;
    }

    public final LiveData<com.larus.network.http.a<s>> getInitProfileState() {
        return this.initProfileState;
    }

    public final String getUploadAvatarUrl() {
        return this.uploadAvatarUrl;
    }

    public final LiveData<com.larus.network.http.a<d>> getUserNameAvailable() {
        return this.userNameAvailable;
    }

    public ProfileRegisterViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        AsyncLiveData<d> r3 = new AsyncLiveData();
        this._userNameAvailable = r3;
        this.userNameAvailable = r3;
        AsyncLiveData<y> r4 = new AsyncLiveData();
        this._editProfileState = r4;
        this.editProfileState = r4;
        AsyncLiveData<s> r5 = new AsyncLiveData();
        this._initProfileState = r5;
        this.initProfileState = r5;
        this.uploadAvatarUrl = "";
    }

    public static final /* synthetic */ AsyncLiveData access$get_editProfileState$p(ProfileRegisterViewModel r0) {
        return r0._editProfileState;
    }

    public static final /* synthetic */ AsyncLiveData access$get_initProfileState$p(ProfileRegisterViewModel r0) {
        return r0._initProfileState;
    }

    public static final /* synthetic */ AsyncLiveData access$get_userNameAvailable$p(ProfileRegisterViewModel r0) {
        return r0._userNameAvailable;
    }

    public final void checkUserName(String r10) {
        Intrinsics.checkNotNullParameter(r10, "userName");
        this._userNameAvailable.setValue(new w(null));
        Job r0 = this.checkNameJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.checkNameJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r10, null), 3, null);
    }

    public final void setUploadAvatarUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.uploadAvatarUrl = r2;
    }

    public final Job editUserInfo(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "nickname");
        Intrinsics.checkNotNullParameter(r9, "userName");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01081(this, r8, r9, null), 3, null);
    }
}
