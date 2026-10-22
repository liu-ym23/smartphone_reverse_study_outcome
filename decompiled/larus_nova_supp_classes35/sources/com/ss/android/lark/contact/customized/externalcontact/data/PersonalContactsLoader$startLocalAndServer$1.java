package com.ss.android.lark.contact.customized.externalcontact.data;

import com.bytedance.lark.pb.contact.v2.GetContactsScene;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mtb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.contact.customized.externalcontact.data.PersonalContactsLoader$startLocalAndServer$1", f = "PersonalContactsLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PersonalContactsLoader$startLocalAndServer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $postedState;
    final /* synthetic */ GetContactsScene $scene;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PersonalContactsLoader this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.externalcontact.data.PersonalContactsLoader$startLocalAndServer$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.externalcontact.data.PersonalContactsLoader$startLocalAndServer$1$1", f = "PersonalContactsLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<d> $local;
        final /* synthetic */ ErrorResult $localError;
        final /* synthetic */ Ref.IntRef $postedState;
        int label;
        final /* synthetic */ PersonalContactsLoader this$0;

        public AnonymousClass1(List<d> r1, Ref.IntRef r2, PersonalContactsLoader r3, ErrorResult r4, Continuation<? super AnonymousClass1> r5) {
            this.$local = r1;
            this.$postedState = r2;
            this.this$0 = r3;
            this.$localError = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$local, this.$postedState, this.this$0, this.$localError, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L35;
            ResultKt.throwOnFailure(r5);
            StringBuilder r6 = new StringBuilder("local is size? ");
            List<d> r0 = this.$local;
            if (r0 == null) goto L7;
            Integer r1 = Boxing.boxInt(r0.size());
        L8:
            r6.append(r1);
            r6.append("  postedState=");
            r6.append(this.$postedState.element);
            Log.i("Contact_PersonalLoader", r6.toString());
            List<d> r7 = this.$local;
            if (r7 != null) goto L12;
            PersonalContactsLoader r8 = this.this$0;
            r8.b.invoke(Boolean.TRUE, Boolean.FALSE, this.$localError);
        L14:
            Ref.IntRef r9 = this.$postedState;
            if (r9.element != 2) goto L24;
            r9.element = 1;
            if ((this.this$0.e.getValue() instanceof i9b.a.c) == false) goto L21;
            return Unit.INSTANCE;
        L21:
            if (this.$local == null) goto L23;
            this.this$0.h(this.$local, true);
        L33:
            return Unit.INSTANCE;
        L23:
            PersonalContactsLoader r10 = this.this$0;
            r10.getClass();
            UICallbackExecutor.execute(new c(r10, "load local failed"));
            goto L33
        L24:
            r9.element = 1;
            List<d> r11 = this.$local;
            if (r11 != null) goto L27;
        L29:
            boolean r12 = false;
        L30:
            if (r12 == false) goto L33;
            PersonalContactsLoader r13 = this.this$0;
            List<d> r2 = this.$local;
            int r3 = PersonalContactsLoader.j;
            r13.h(r2, true);
            goto L33
        L27:
            if (r11.isEmpty() == true) goto L29;
            r12 = true;
            goto L30
        L12:
            if ((!r7.isEmpty()) == false) goto L14;
            Function3<Boolean, Boolean, ErrorResult, Unit> r14 = this.this$0.b;
            Boolean r4 = Boolean.TRUE;
            r14.invoke(r4, r4, null);
            goto L14
        L7:
            r1 = null;
            goto L8
        L35:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public PersonalContactsLoader$startLocalAndServer$1(PersonalContactsLoader r1, GetContactsScene r2, Ref.IntRef r3, Continuation<? super PersonalContactsLoader$startLocalAndServer$1> r4) {
        this.this$0 = r1;
        this.$scene = r2;
        this.$postedState = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        PersonalContactsLoader$startLocalAndServer$1 r0 = new PersonalContactsLoader$startLocalAndServer$1(this.this$0, this.$scene, this.$postedState, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        Pair r11 = PersonalContactsLoader.f(this.this$0, true, this.$scene);
        List r3 = (List) r11.component1();
        ErrorResult r6 = (ErrorResult) r11.component2();
        BuildersKt.launch$default(r0, Dispatchers.getMain(), null, new AnonymousClass1(r3, this.$postedState, this.this$0, r6, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
