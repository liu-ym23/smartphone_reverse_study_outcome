package com.ss.android.lark.contact.customized.externalinvite.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.contact.base.entity.bean.InvitationInfo;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteExternalViewFeishuBinding;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.contact.customized.externalinvite.view.OfficeInviteExternalFragment$bindQrCard$1", f = "OfficeInviteExternalFragment.kt", i = {}, l = {283}, m = "invokeSuspend", n = {}, s = {})
final class OfficeInviteExternalFragment$bindQrCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InvitationInfo $info;
    int label;
    final /* synthetic */ OfficeInviteExternalFragment this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.externalinvite.view.OfficeInviteExternalFragment$bindQrCard$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.externalinvite.view.OfficeInviteExternalFragment$bindQrCard$1$1", f = "OfficeInviteExternalFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ InvitationInfo $info;
        int label;
        final /* synthetic */ OfficeInviteExternalFragment this$0;

        public AnonymousClass1(OfficeInviteExternalFragment r1, Bitmap r2, InvitationInfo r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$bitmap = r2;
            this.$info = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$bitmap, this.$info, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r6);
            ContactDbInviteExternalViewFeishuBinding r7 = this.this$0.e;
            ContactDbInviteExternalViewFeishuBinding r0 = null;
            if (r7 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            r7 = null;
        L7:
            r7.f.setImageBitmap(this.$bitmap);
            int r8 = UIHelper.dp2px(64.0f);
            String r2 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
            Context r3 = this.this$0.requireContext();
            ContactDbInviteExternalViewFeishuBinding r4 = this.this$0.e;
            if (r4 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        L11:
            LKUIRoundedImageView2 r1 = r0.g;
            String r5 = this.$info.userAvatarKey;
            LoadParams r9 = new LoadParams();
            r9.a = r8;
            r9.b = r8;
            ImageModule.a(r3, r1, r5, r2, r9);
            return Unit.INSTANCE;
        L10:
            r0 = r4;
            goto L11
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public OfficeInviteExternalFragment$bindQrCard$1(OfficeInviteExternalFragment r1, InvitationInfo r2, Continuation<? super OfficeInviteExternalFragment$bindQrCard$1> r3) {
        this.this$0 = r1;
        this.$info = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new OfficeInviteExternalFragment$bindQrCard$1(this.this$0, this.$info, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        int r14 = UIHelper.dp2px(180.0f);
        long r3 = SystemClock.elapsedRealtime();
        owb.b r2 = (owb.b) this.this$0.g.getValue();
        String r5 = this.$info.invUrl;
        UIHelper.dp2px(5.0f);
        UIHelper.dp2px(64.0f);
        Bitmap r15 = r2.q1(r5, new owb.c(r14, r14));
        int r4 = com.ss.android.lark.contact.customized.common.a.a;
        long r6 = SystemClock.elapsedRealtime() - r3;
        if (r15 == null) goto L11;
        boolean r8 = true;
    L13:
        if (r15 != null) goto L15;
        ErrorResult r9 = new ErrorResult("generate qr bitmap failed");
    L16:
        com.ss.android.lark.contact.customized.common.a.a("page_invite_contact", r6, r8, r9, false, true);
        MainCoroutineDispatcher r7 = Dispatchers.getMain();
        AnonymousClass1 r10 = new AnonymousClass1(this.this$0, r15, this.$info, null);
        this.label = 1;
        if (BuildersKt.withContext(r7, r10, this) != r0) goto L20;
        return r0;
    L15:
        r9 = null;
        goto L16
    L11:
        r8 = false;
        goto L13
    }
}
