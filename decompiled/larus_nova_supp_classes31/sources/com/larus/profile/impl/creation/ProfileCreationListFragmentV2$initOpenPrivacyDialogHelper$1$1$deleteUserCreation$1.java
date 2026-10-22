package com.larus.profile.impl.creation;

import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import com.larus.profile.impl.creation.viewmodel.ProfileCreationViewModelV2;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.ProfileCreationListFragmentV2$initOpenPrivacyDialogHelper$1$1$deleteUserCreation$1", f = "ProfileCreationListFragmentV2.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileCreationListFragmentV2$initOpenPrivacyDialogHelper$1$1$deleteUserCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserCreationModel $creation;
    int label;
    final /* synthetic */ ProfileCreationListFragmentV2 this$0;

    public ProfileCreationListFragmentV2$initOpenPrivacyDialogHelper$1$1$deleteUserCreation$1(ProfileCreationListFragmentV2 r1, UserCreationModel r2, Continuation<? super ProfileCreationListFragmentV2$initOpenPrivacyDialogHelper$1$1$deleteUserCreation$1> r3) {
        this.this$0 = r1;
        this.$creation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProfileCreationListFragmentV2$initOpenPrivacyDialogHelper$1$1$deleteUserCreation$1(this.this$0, this.$creation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        if (((Boolean) r10).booleanValue() == false) goto L24;
        List<UserCreation> r11 = this.$creation.b();
        if (r11 == null) goto L24;
        UserCreation r12 = (UserCreation) CollectionsKt.firstOrNull(r11);
        if (r12 == null) goto L24;
        ProfileCreationListFragmentV2 r2 = this.this$0;
        int r3 = ProfileCreationListFragmentV2.r;
        zp9.l r4 = r2.aa0();
        if (r4 == null) goto L24;
        String r13 = r12.a;
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        r4.deleteUserCreation(r13, true);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ProfileCreationListFragmentV2 r14 = this.this$0;
        int r5 = ProfileCreationListFragmentV2.r;
        ProfileCreationViewModelV2 r6 = r14.ca0();
        ProfileCreationListFragmentV2 r15 = this.this$0;
        String r7 = r15.p;
        Integer r8 = ProfileCreationListFragmentV2.Z90(r15);
        UserCreationModel r9 = this.$creation;
        this.label = 1;
        r10 = r6.deleteUserCreation(r9, "creation_list", r7, r8, this);
        if (r10 != r0) goto L12;
        return r0;
    }
}
