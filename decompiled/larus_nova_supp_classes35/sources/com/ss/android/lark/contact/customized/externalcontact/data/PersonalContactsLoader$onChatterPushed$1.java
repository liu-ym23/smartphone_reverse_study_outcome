package com.ss.android.lark.contact.customized.externalcontact.data;

import com.bytedance.lark.pb.contact.v2.GetContactsScene;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mtb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.contact.customized.externalcontact.data.PersonalContactsLoader$onChatterPushed$1", f = "PersonalContactsLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PersonalContactsLoader$onChatterPushed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PersonalContactsLoader this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.externalcontact.data.PersonalContactsLoader$onChatterPushed$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.externalcontact.data.PersonalContactsLoader$onChatterPushed$1$1", f = "PersonalContactsLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<d> $local;
        int label;
        final /* synthetic */ PersonalContactsLoader this$0;

        public AnonymousClass1(PersonalContactsLoader r1, List<d> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$local = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$local, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            PersonalContactsLoader r4 = this.this$0;
            List<d> r0 = this.$local;
            int r1 = PersonalContactsLoader.j;
            r4.h(r0, true);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public PersonalContactsLoader$onChatterPushed$1(PersonalContactsLoader r1, Continuation<? super PersonalContactsLoader$onChatterPushed$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        PersonalContactsLoader$onChatterPushed$1 r0 = new PersonalContactsLoader$onChatterPushed$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        List r8 = (List) PersonalContactsLoader.f(this.this$0, true, GetContactsScene.GET_CONTACTS_SCENE_INCR_SHORT).component1();
        if (r8 == null) goto L8;
        BuildersKt.launch$default(r0, Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, r8, null), 2, null);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
