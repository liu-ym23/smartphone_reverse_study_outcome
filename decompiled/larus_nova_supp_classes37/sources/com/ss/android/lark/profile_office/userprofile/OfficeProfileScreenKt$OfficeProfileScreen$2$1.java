package com.ss.android.lark.profile_office.userprofile;

import android.content.Context;
import androidx.compose.runtime.State;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.android.lark.chat.entity.message.content.ProfileContent;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.targetconfig.BotConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.Condition;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.GroupConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.ThreadConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.UserConfig;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.profile_office.OfficeProfileModule;
import com.ss.android.lark.profile_office.shareprofile.ProfileForwardContent;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewUtils;
import com.suite.lark.platform.feature.forward.doubao.u;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.d1;
import kza.o;
import kza.q;
import kza.r;
import kza.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileScreenKt$OfficeProfileScreen$2$1", f = "OfficeProfileScreen.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeProfileScreenKt$OfficeProfileScreen$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $backWithResult;
    final /* synthetic */ Context $context;
    final /* synthetic */ State<OfficeProfileState> $latestState$delegate;
    final /* synthetic */ g $navigator;
    final /* synthetic */ ContactSource $source;
    final /* synthetic */ OfficeProfileViewModel $viewModel;
    int label;

    /* JADX INFO: renamed from: com.ss.android.lark.profile_office.userprofile.OfficeProfileScreenKt$OfficeProfileScreen$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "effect", "Lcom/ss/android/lark/profile_office/userprofile/ProfileEffect;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileScreenKt$OfficeProfileScreen$2$1$1", f = "OfficeProfileScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<j, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $backWithResult;
        final /* synthetic */ Context $context;
        final /* synthetic */ State<OfficeProfileState> $latestState$delegate;
        final /* synthetic */ g $navigator;
        final /* synthetic */ ContactSource $source;
        final /* synthetic */ OfficeProfileViewModel $viewModel;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Context r1, Function1<? super Boolean, Unit> r2, g r3, ContactSource r4, OfficeProfileViewModel r5, State<OfficeProfileState> r6, Continuation<? super AnonymousClass1> r7) {
            this.$context = r1;
            this.$backWithResult = r2;
            this.$navigator = r3;
            this.$source = r4;
            this.$viewModel = r5;
            this.$latestState$delegate = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r8 = new AnonymousClass1(this.$context, this.$backWithResult, this.$navigator, this.$source, this.$viewModel, this.$latestState$delegate, r11);
            r8.L$0 = r10;
            return r8;
        }

        public final Object invoke(j r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((j) r1, (Continuation) r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v7, types: [com.ss.android.lark.profile_office.userprofile.OfficeProfileNavigator$openChat$1] */
        public final Object invokeSuspend(Object r22) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L102;
            ResultKt.throwOnFailure(r22);
            j r1 = (j) this.L$0;
            if ((r1 instanceof j.k) == false) goto L7;
            UDToast.show(this.$context, ((j.k) r1).a);
        L98:
            return Unit.INSTANCE;
        L7:
            boolean r3 = true;
            if (Intrinsics.areEqual(r1, j.a.a) == false) goto L10;
            this.$backWithResult.invoke(Boxing.boxBoolean(true));
            goto L98
        L10:
            boolean r5 = false;
            if (Intrinsics.areEqual(r1, j.c.a) == false) goto L25;
            g r2 = this.$navigator;
            String r4 = OfficeProfileScreenKt.d(this.$latestState$delegate).k();
            String r8 = OfficeProfileScreenKt.d(this.$latestState$delegate).l();
            r2.getClass();
            Intrinsics.checkNotNullParameter(r4, "userAvatarKey");
            Intrinsics.checkNotNullParameter(r8, "userId");
            if (r4.length() != 0) goto L15;
            r5 = true;
        L15:
            if (r5 == true) goto L98;
            FragmentActivity r6 = ViewUtils.getActivityByContext(r2.a);
            if ((r6 instanceof FragmentActivity) == false) goto L20;
            FragmentActivity r7 = r6;
        L21:
            if (r7 == null) goto L98;
            OfficeProfileModule.a().openAvatarPreview(new kza.k(new OfficeProfileNavigator$openAvatarPreview$request$1(r2, r4, r8, null), new OfficeProfileNavigator$openAvatarPreview$request$2(r2, r4, r8, null), new o(0, false, false, new t(new r(GalleryType.Image, null, null, r4, 118), new q(r4, true, 13)), 63)), r7);
            goto L98
        L20:
            r7 = null;
            goto L21
        L25:
            if (Intrinsics.areEqual(r1, j.h.a) == false) goto L28;
            g r9 = this.$navigator;
            r9.getClass();
            OfficeProfileModule.a().getContactDependency().M(r9.a);
            goto L98
        L28:
            if ((r1 instanceof j.g) == false) goto L31;
            g r10 = this.$navigator;
            String r11 = ((j.g) r1).a;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r11, "leaderUserId");
            IProfileLauncherV2.a.getClass();
            IProfileLauncherV2 r12 = IProfileLauncherV2.Companion.a();
            Context r13 = r10.a;
            ContactSource.a r14 = new ContactSource.a();
            r14.b = 0;
            IProfileLauncherV2.a.a(r12, r13, r11, null, new ContactSource(r14), 186);
            goto L98
        L31:
            if ((r1 instanceof j.f) == false) goto L40;
            g r15 = this.$navigator;
            String r16 = ((j.f) r1).a;
            r15.getClass();
            Intrinsics.checkNotNullParameter(r16, "url");
            if (r16.length() == 0) goto L36;
            r3 = false;
        L36:
            if (r3 == true) goto L98;
            OfficeProfileModule.a().openUrlV2(r15.a, r16);
            goto L98
        L40:
            if ((r1 instanceof j.e) == false) goto L49;
            g r17 = this.$navigator;
            String r18 = ((j.e) r1).a;
            r17.getClass();
            Intrinsics.checkNotNullParameter(r18, "phoneNumber");
            if (r18.length() == 0) goto L45;
            r3 = false;
        L45:
            if (r3 == true) goto L98;
            OfficeProfileModule.a().getPhoneDependency().a(r17.a, r18);
            goto L98
        L49:
            if ((r1 instanceof j.d) == false) goto L58;
            g r19 = this.$navigator;
            final String r20 = ((j.d) r1).a;
            r19.getClass();
            Intrinsics.checkNotNullParameter(r20, "chatterId");
            if (r20.length() == 0) goto L54;
            r3 = false;
        L54:
            if (r3 == false) goto L56;
            UDToast.show(r19.a, 2131889968);
            goto L98
        L56:
            OfficeProfileModule.a().getChatDependency().b(r19.a, r20, new OfficeProfileNavigator$openChat$1(r20));
            goto L98
        L58:
            if (Intrinsics.areEqual(r1, j.C0118j.a) == false) goto L77;
            g r21 = this.$navigator;
            String r23 = OfficeProfileScreenKt.d(this.$latestState$delegate).l();
            String r24 = OfficeProfileScreenKt.d(this.$latestState$delegate).m();
            String r25 = OfficeProfileScreenKt.d(this.$latestState$delegate).k();
            r21.getClass();
            Intrinsics.checkNotNullParameter(r23, "userId");
            Intrinsics.checkNotNullParameter(r24, "userName");
            Intrinsics.checkNotNullParameter(r25, "userAvatarKey");
            int r26 = com.ss.android.lark.profile_office.shareprofile.a.a;
            Context r27 = r21.a;
            ProfileContent r28 = new ProfileContent();
            r28.setId(r23);
            r28.setDisplayName(r24);
            r28.setAvatarKey(r25);
            Unit r29 = Unit.INSTANCE;
            if (r27 == null) goto L75;
            Log.i("ProfileForward", "start forward profile, profileContent is: " + r28.getId());
            ForwardTemplateNew.a r30 = new ForwardTemplateNew.a();
            r30.g = 4;
            ProfileForwardContent.a r31 = new ProfileForwardContent.a();
            String r32 = r28.getId();
            String r33 = "";
            if (r32 != null) goto L64;
            r32 = "";
        L64:
            Intrinsics.checkNotNullParameter(r32, "chatterId");
            r31.a = r32;
            String r34 = r28.getDisplayName();
            if (r34 != null) goto L67;
            r34 = "";
        L67:
            Intrinsics.checkNotNullParameter(r34, "displayName");
            r31.b = r34;
            String r35 = r28.getAvatarKey();
            if (r35 != null) goto L70;
            r35 = "";
        L70:
            Intrinsics.checkNotNullParameter(r35, "avatarKey");
            r31.c = r35;
            ProfileForwardContent r36 = new ProfileForwardContent();
            String r37 = r31.a;
            Intrinsics.checkNotNullParameter(r37, "<set-?>");
            r36.a = r37;
            String r38 = r31.b;
            Intrinsics.checkNotNullParameter(r38, "<set-?>");
            r36.b = r38;
            String r39 = r31.c;
            Intrinsics.checkNotNullParameter(r39, "<set-?>");
            r36.c = r39;
            r30.f = r36;
            ForwardTargetConfig.a r40 = new ForwardTargetConfig.a();
            IncludeConfig.a r41 = new IncludeConfig.a();
            EntityItem.a r42 = new EntityItem.a();
            r42.f(new UserConfig.a().a());
            r41.a(r42.c());
            EntityItem.a r43 = new EntityItem.a();
            r43.d(new GroupConfig.a().a());
            r41.a(r43.c());
            EntityItem.a r44 = new EntityItem.a();
            ThreadConfig.a r110 = new ThreadConfig.a();
            r110.b(Condition.ThreadType.MSG_THREAD);
            r44.e(r110.a());
            r41.a(r44.c());
            EntityItem.a r45 = new EntityItem.a();
            r45.b(new BotConfig());
            r41.a(r45.c());
            IncludeConfig r46 = r41.b();
            Intrinsics.checkNotNullParameter(r46, "includeConfig");
            r40.d = r46;
            ForwardTargetConfig r47 = r40.a();
            Intrinsics.checkNotNullParameter(r47, "forwardTargetConfig");
            r30.a = r47;
            ForwardConfirmDialogConfig.a r48 = new ForwardConfirmDialogConfig.a();
            BasicDialogContentConfig.a r49 = new BasicDialogContentConfig.a();
            String r50 = r28.getDisplayName();
            if (r50 == null) goto L74;
            r33 = r50;
        L74:
            String r51 = UIHelper.mustacheFormat(2131892097, "user_name", r33);
            Intrinsics.checkNotNullParameter(r51, "content");
            r49.c = r51;
            Image r52 = new Image();
            r52.setKey(r28.getAvatarKey());
            r52.setToken(r28.getId());
            r49.f = 0;
            r49.g = null;
            r49.h = r52;
            r49.i = null;
            r49.k = false;
            BasicDialogContentConfig r53 = r49.a();
            Intrinsics.checkNotNullParameter("doubao_profile", "<set-?>");
            r53.a = "doubao_profile";
            r48.d = r53;
            ForwardConfirmDialogConfig r54 = r48.a();
            Intrinsics.checkNotNullParameter(r54, "forwardConfirmDialogConfig");
            r30.e = r54;
            u.a(r27, r30.a(), 0, null, 12);
            goto L98
        L75:
            Log.e("ProfileForward", "context is null or profileContent is null");
            goto L98
        L77:
            if (Intrinsics.areEqual(r1, j.b.a) == false) goto L89;
            g r55 = this.$navigator;
            x1c.d r56 = this.$viewModel.getOfficeProfileProtocol();
            v1c.a r57 = OfficeProfileScreenKt.d(this.$latestState$delegate).f;
            r55.getClass();
            Intrinsics.checkNotNullParameter(r56, "officeProfileProtocol");
            Intrinsics.checkNotNullParameter(r57, "doubaoData");
            if (r57.c() == false) goto L82;
            UDToast.show(r55.a, 2131890177);
            goto L98
        L82:
            if (r57.a().length() > 0) goto L85;
            r3 = false;
        L85:
            if (r3 == false) goto L87;
            r56.A0(r55.a, r57.a());
            goto L98
        L87:
            UDToast.show(r55.a, 2131889968);
            goto L98
        L89:
            if (Intrinsics.areEqual(r1, j.i.a) == false) goto L100;
            g r58 = this.$navigator;
            String r59 = this.$viewModel.getReportUrl();
            r58.getClass();
            Intrinsics.checkNotNullParameter(r59, "reportUrl");
            if (r59.length() == 0) goto L94;
            r3 = false;
        L94:
            if (r3 == false) goto L96;
            UDToast.show(r58.a, 2131889968);
            goto L98
        L96:
            OfficeProfileModule.a().openUrlV2(r58.a, r59);
            goto L98
        L100:
            throw new NoWhenBranchMatchedException();
        L102:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeProfileScreenKt$OfficeProfileScreen$2$1(OfficeProfileViewModel r1, Context r2, Function1<? super Boolean, Unit> r3, g r4, ContactSource r5, State<OfficeProfileState> r6, Continuation<? super OfficeProfileScreenKt$OfficeProfileScreen$2$1> r7) {
        this.$viewModel = r1;
        this.$context = r2;
        this.$backWithResult = r3;
        this.$navigator = r4;
        this.$source = r5;
        this.$latestState$delegate = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new OfficeProfileScreenKt$OfficeProfileScreen$2$1(this.$viewModel, this.$context, this.$backWithResult, this.$navigator, this.$source, this.$latestState$delegate, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        d1<j> r13 = this.$viewModel.getEffect();
        AnonymousClass1 r2 = new AnonymousClass1(this.$context, this.$backWithResult, this.$navigator, this.$source, this.$viewModel, this.$latestState$delegate, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r13, r2, this) != r0) goto L12;
        return r0;
    }
}
