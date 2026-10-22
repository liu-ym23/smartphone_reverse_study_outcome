package com.ss.android.lark.contact.customized.externalcontact.data;

import com.bytedance.lark.pb.contact.v2.GetContactsScene;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mtb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.contact.customized.externalcontact.data.PersonalContactsLoader$startLocalAndServer$2", f = "PersonalContactsLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PersonalContactsLoader$startLocalAndServer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $postedState;
    final /* synthetic */ GetContactsScene $scene;
    final /* synthetic */ boolean $updateLastFullSyncTimeOnServerSuccess;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PersonalContactsLoader this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.externalcontact.data.PersonalContactsLoader$startLocalAndServer$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.externalcontact.data.PersonalContactsLoader$startLocalAndServer$2$1", f = "PersonalContactsLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.IntRef $postedState;
        final /* synthetic */ List<d> $server;
        final /* synthetic */ ErrorResult $serverError;
        final /* synthetic */ boolean $updateLastFullSyncTimeOnServerSuccess;
        int label;
        final /* synthetic */ PersonalContactsLoader this$0;

        public AnonymousClass1(List<d> r1, Ref.IntRef r2, PersonalContactsLoader r3, ErrorResult r4, boolean r5, Continuation<? super AnonymousClass1> r6) {
            this.$server = r1;
            this.$postedState = r2;
            this.this$0 = r3;
            this.$serverError = r4;
            this.$updateLastFullSyncTimeOnServerSuccess = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$server, this.$postedState, this.this$0, this.$serverError, this.$updateLastFullSyncTimeOnServerSuccess, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L30;
            ResultKt.throwOnFailure(r6);
            StringBuilder r7 = new StringBuilder("server is size? ");
            List<d> r0 = this.$server;
            if (r0 == null) goto L7;
            Integer r1 = Boxing.boxInt(r0.size());
        L8:
            r7.append(r1);
            r7.append("  postedState=");
            r7.append(this.$postedState.element);
            Log.i("Contact_PersonalLoader", r7.toString());
            PersonalContactsLoader r8 = this.this$0;
            if (this.$server == null) goto L11;
            boolean r2 = true;
        L12:
            ErrorResult r3 = this.$serverError;
            r8.b.invoke(Boolean.FALSE, Boolean.valueOf(r2), r3);
            if (this.$server == null) goto L23;
            if (this.$updateLastFullSyncTimeOnServerSuccess == false) goto L17;
            DoubaoContactSyncStateStore r9 = (DoubaoContactSyncStateStore) this.this$0.c.getValue();
            long r4 = System.currentTimeMillis();
            ((KVRepo) r9.b.getValue()).putLong("last_full_sync_time_millis", r4);
        L17:
            PersonalContactsLoader r10 = this.this$0;
            if (r10.g == true) goto L21;
            Log.i("Contact_PersonalLoader", "registerChatterPushListenerIfNeeded");
            ImSdkService.c().J1(r10.i);
            r10.g = true;
        L21:
            this.this$0.h(this.$server, true);
        L27:
            this.$postedState.element = 2;
            return Unit.INSTANCE;
        L23:
            if (this.$postedState.element != 1) goto L27;
            if ((this.this$0.e.getValue() instanceof i9b.a.c) == true) goto L27;
            PersonalContactsLoader r11 = this.this$0;
            r11.getClass();
            UICallbackExecutor.execute(new c(r11, "sync failed"));
            goto L27
        L11:
            r2 = false;
            goto L12
        L7:
            r1 = null;
            goto L8
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public PersonalContactsLoader$startLocalAndServer$2(PersonalContactsLoader r1, GetContactsScene r2, Ref.IntRef r3, boolean r4, Continuation<? super PersonalContactsLoader$startLocalAndServer$2> r5) {
        this.this$0 = r1;
        this.$scene = r2;
        this.$postedState = r3;
        this.$updateLastFullSyncTimeOnServerSuccess = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        PersonalContactsLoader$startLocalAndServer$2 r6 = new PersonalContactsLoader$startLocalAndServer$2(this.this$0, this.$scene, this.$postedState, this.$updateLastFullSyncTimeOnServerSuccess, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r11);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        Pair r12 = PersonalContactsLoader.f(this.this$0, false, this.$scene);
        List r3 = (List) r12.component1();
        ErrorResult r6 = (ErrorResult) r12.component2();
        BuildersKt.launch$default(r0, Dispatchers.getMain(), null, new AnonymousClass1(r3, this.$postedState, this.this$0, r6, this.$updateLastFullSyncTimeOnServerSuccess, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
