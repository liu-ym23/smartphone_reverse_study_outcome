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
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.f;
import com.larus.network.http.w;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatService;
import com.larus.profile.api.IProfileApi;
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
import kotlin.coroutines.jvm.internal.Boxing;
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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013J\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0013R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/profile/impl/viewmodel/ProfileEditViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_userNameAvailable", "Lcom/larus/network/http/AsyncLiveData;", "Lcom/larus/profile/api/bean/CheckUserNameResponse;", "userNameAvailable", "Landroidx/lifecycle/LiveData;", "Lcom/larus/network/http/Async;", "getUserNameAvailable", "()Landroidx/lifecycle/LiveData;", "_editProfileState", "Lcom/larus/profile/api/bean/UpdateProfileResponse;", "editProfileState", "getEditProfileState", "uploadAvatarUrl", "", "getUploadAvatarUrl", "()Ljava/lang/String;", "setUploadAvatarUrl", "(Ljava/lang/String;)V", "checkNameJob", "Lkotlinx/coroutines/Job;", "checkUserName", "", "userName", "editUserInfo", "nickname", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProfileEditViewModel extends AndroidViewModel {
    private final AsyncLiveData<y> _editProfileState;
    private final AsyncLiveData<d> _userNameAvailable;
    private Job checkNameJob;
    private final LiveData<com.larus.network.http.a<y>> editProfileState;
    private String uploadAvatarUrl;
    private final LiveData<com.larus.network.http.a<d>> userNameAvailable;

    /* JADX INFO: renamed from: com.larus.profile.impl.viewmodel.ProfileEditViewModel$checkUserName$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.viewmodel.ProfileEditViewModel$checkUserName$1", f = "ProfileEditViewModel.kt", i = {}, l = {49, 50}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userName;
        int label;
        final /* synthetic */ ProfileEditViewModel this$0;

        public AnonymousClass1(ProfileEditViewModel r1, String r2, Continuation<? super AnonymousClass1> r3) {
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
            AsyncLiveData r2 = ProfileEditViewModel.access$get_userNameAvailable$p(this.this$0);
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

    /* JADX INFO: renamed from: com.larus.profile.impl.viewmodel.ProfileEditViewModel$editUserInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.viewmodel.ProfileEditViewModel$editUserInfo$1", f = "ProfileEditViewModel.kt", i = {0, 1, 1}, l = {65, 82}, m = "invokeSuspend", n = {"currentUserInfo", "currentUserInfo", "updateResult"}, s = {"L$0", "L$0", "L$1"})
    public static final class C01051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $nickname;
        final /* synthetic */ String $userName;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ProfileEditViewModel this$0;

        public C01051(ProfileEditViewModel r1, String r2, String r3, Continuation<? super C01051> r4) {
            this.this$0 = r1;
            this.$nickname = r2;
            this.$userName = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01051(this.this$0, this.$nickname, this.$userName, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            String r10 = "edit_profile";
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            com.larus.network.http.a r1 = (com.larus.network.http.a) this.L$1;
            r38.b r2 = (r38.b) this.L$0;
            ResultKt.throwOnFailure(r19);
            r38.b r15 = r2;
            r10 = "edit_profile";
            com.larus.network.http.a r3 = r1;
            Object r4 = r19;
        L37:
            com.larus.network.http.y r5 = (com.larus.network.http.a) r4;
            if ((r5 instanceof com.larus.network.http.y) == false) goto L52;
            s r6 = (s) ((com.larus.network.http.a) r5).b;
            if (r6 == null) goto L47;
            r38.b r7 = r6.b();
            if (r7 == null) goto L47;
            IAccountService.Companion r8 = IAccountService.a;
            r8.l(r7);
            r8.o(AccountService.a.getUserId(), r7.c(), r10);
            com.larus.bmhome.bot.utils.c r9 = IAIChatService.a.l7();
            String r11 = r7.d();
            if (r11 != null) goto L46;
            r11 = "";
        L46:
            r9.a(r11);
            Boxing.boxBoolean(IProfileApi.a.b().tryEmit(r7));
        L47:
            if (r6 == null) goto L80;
            o r13 = r6.a();
            if (r13 == null) goto L80;
            IAccountService.a.j(r13.b());
        L80:
            ProfileEditViewModel.access$get_editProfileState$p(this.this$0).postValue(r3);
        L82:
            return Unit.INSTANCE;
        L52:
            if ((r5 instanceof f) == false) goto L80;
            IAccountService.Companion r14 = IAccountService.a;
            String r16 = ILoginService.a.getAccountInfo().c;
            String r17 = this.$nickname;
            if (r17.length() != 0) goto L56;
            boolean r18 = true;
        L57:
            if (r18 == false) goto L61;
            if (r15 == null) goto L60;
            r17 = r15.d();
            goto L61
        L60:
            r17 = null;
        L61:
            String r20 = r17;
            String r21 = this.$userName;
            if (r21.length() != 0) goto L64;
            boolean r22 = true;
        L65:
            if (r22 == false) goto L69;
            if (r15 == null) goto L68;
            r21 = r15.g();
            goto L69
        L68:
            r21 = null;
        L69:
            String r23 = r21;
            if (this.this$0.getUploadAvatarUrl().length() <= 0) goto L72;
            boolean r24 = true;
        L73:
            if (r24 == false) goto L76;
            String r25 = this.this$0.getUploadAvatarUrl();
            AvatarInfo r110 = new AvatarInfo(this.this$0.getUploadAvatarUrl(), r25, 1);
        L75:
            AvatarInfo r26 = r110;
        L79:
            r14.l(new r38.b(r16, r20, r23, r26, 993));
            goto L80
        L76:
            if (r15 == null) goto L78;
            r110 = r15.a();
            goto L75
        L78:
            r26 = null;
            goto L79
        L72:
            r24 = false;
            goto L73
        L64:
            r22 = false;
            goto L65
        L56:
            r18 = false;
            goto L57
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r38.b r27 = (r38.b) this.L$0;
            ResultKt.throwOnFailure(r19);
            r15 = r27;
            Object r28 = r19;
        L28:
            com.larus.network.http.a r111 = (com.larus.network.http.a) r28;
            if ((r111 instanceof f) == false) goto L32;
            ProfileEditViewModel.access$get_editProfileState$p(this.this$0).postValue(r111);
            goto L82
        L32:
            if ((r111 instanceof com.larus.network.http.y) == false) goto L82;
            FlowDowngradeServiceDelegate r29 = FlowDowngradeServiceDelegate.INSTANCE;
            JSONObject r30 = new JSONObject();
            Map r31 = MapsKt.mapOf(TuplesKt.to("source", r10));
            this.L$0 = r15;
            this.L$1 = r111;
            this.label = 2;
            r4 = IFlowDowngradeService.a.b(r29, "Social", s.class, "/alice/profile/self_brief", r30, null, false, null, r31, this, 1008);
            if (r4 != r12) goto L36;
            return r12;
        L36:
            r3 = r111;
            goto L37
        L10:
            ResultKt.throwOnFailure(r19);
            ProfileEditViewModel.access$get_editProfileState$p(this.this$0).setValue(new w(null));
            r38.b r32 = IAccountService.a.getUserInfo();
            FlowDowngradeServiceDelegate r33 = FlowDowngradeServiceDelegate.INSTANCE;
            JSONObject r34 = new JSONObject();
            String r35 = this.$nickname;
            String r36 = this.$userName;
            ProfileEditViewModel r112 = this.this$0;
            r34.put("entity_id", ILoginService.a.getAccountInfo().c);
            if (r32 == null) goto L13;
            String r37 = r32.d();
        L15:
            if (Intrinsics.areEqual(r37, r35) == false) goto L17;
            r35 = "";
        L17:
            r34.put("nickname", r35);
            if (r32 == null) goto L20;
            String r38 = r32.g();
        L22:
            if (Intrinsics.areEqual(r38, r36) == false) goto L24;
            r36 = "";
        L24:
            r34.put("user_name", r36);
            r34.put("avatar_url", r112.getUploadAvatarUrl());
            r34.put("is_register", false);
            Unit r39 = Unit.INSTANCE;
            Map r113 = MapsKt.mapOf(TuplesKt.to("source", "edit_profile"));
            this.L$0 = r32;
            this.label = 1;
            r28 = IFlowDowngradeService.a.b(r33, "Social", y.class, "/alice/profile/update_profile", r34, null, true, null, r113, this, 944);
            if (r28 != r12) goto L27;
            return r12;
        L27:
            r15 = r32;
            goto L28
        L20:
            r38 = null;
            goto L22
        L13:
            r37 = null;
            goto L15
        }
    }

    public final LiveData<com.larus.network.http.a<y>> getEditProfileState() {
        return this.editProfileState;
    }

    public final String getUploadAvatarUrl() {
        return this.uploadAvatarUrl;
    }

    public final LiveData<com.larus.network.http.a<d>> getUserNameAvailable() {
        return this.userNameAvailable;
    }

    public ProfileEditViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        AsyncLiveData<d> r3 = new AsyncLiveData();
        this._userNameAvailable = r3;
        this.userNameAvailable = r3;
        AsyncLiveData<y> r4 = new AsyncLiveData();
        this._editProfileState = r4;
        this.editProfileState = r4;
        this.uploadAvatarUrl = "";
    }

    public static final /* synthetic */ AsyncLiveData access$get_editProfileState$p(ProfileEditViewModel r0) {
        return r0._editProfileState;
    }

    public static final /* synthetic */ AsyncLiveData access$get_userNameAvailable$p(ProfileEditViewModel r0) {
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
        Intrinsics.checkNotNullParameter(r8, "userName");
        Intrinsics.checkNotNullParameter(r9, "nickname");
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01051(this, r9, r8, null), 3, null);
    }
}
