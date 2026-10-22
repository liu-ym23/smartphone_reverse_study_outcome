package com.larus.bmhome.notification.util;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.larus.network.http.HttpExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.notification.util.NotifyTabSchemaUtils$submitBannedAppeal$1", f = "NotifyTabSchemaUtils.kt", i = {}, l = {290}, m = "invokeSuspend", n = {}, s = {})
final class NotifyTabSchemaUtils$submitBannedAppeal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $body;
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ Uri $uri;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.notification.util.NotifyTabSchemaUtils$submitBannedAppeal$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.notification.util.NotifyTabSchemaUtils$submitBannedAppeal$1$1", f = "NotifyTabSchemaUtils.kt", i = {}, l = {291, 297}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JSONObject $body;
        final /* synthetic */ Fragment $fragment;
        final /* synthetic */ Uri $uri;
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.notification.util.NotifyTabSchemaUtils$submitBannedAppeal$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.notification.util.NotifyTabSchemaUtils$submitBannedAppeal$1$1$1", f = "NotifyTabSchemaUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Fragment $fragment;
            int label;

            public C00311(Fragment r1, Continuation<? super C00311> r2) {
                this.$fragment = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00311(this.$fragment, r3);
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
                s r4 = s.a;
                Context r0 = this.$fragment.getContext();
                r4.getClass();
                s.o(r0, 2131899895, false);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(Uri r1, JSONObject r2, Fragment r3, Continuation<? super AnonymousClass1> r4) {
            this.$uri = r1;
            this.$body = r2;
            this.$fragment = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$uri, this.$body, this.$fragment, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            ResultKt.throwOnFailure(r16);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r16);
            Object r1 = r16;
        L13:
            com.larus.network.http.a r2 = (com.larus.network.http.a) r1;
            MainCoroutineDispatcher r3 = Dispatchers.getMain();
            C00311 r4 = new C00311(this.$fragment, null);
            this.label = 2;
            if (BuildersKt.withContext(r3, r4, this) != r13) goto L17;
            return r13;
        L10:
            ResultKt.throwOnFailure(r16);
            String r5 = this.$uri.toString();
            JSONObject r6 = this.$body;
            this.label = 1;
            r1 = HttpExtKt.k("Basic", Object.class, r5, r6, null, null, false, null, null, null, this, 1008);
            if (r1 != r13) goto L13;
            return r13;
        }
    }

    public NotifyTabSchemaUtils$submitBannedAppeal$1(Uri r1, JSONObject r2, Fragment r3, Continuation<? super NotifyTabSchemaUtils$submitBannedAppeal$1> r4) {
        this.$uri = r1;
        this.$body = r2;
        this.$fragment = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new NotifyTabSchemaUtils$submitBannedAppeal$1(this.$uri, this.$body, this.$fragment, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$uri, this.$body, this.$fragment, null);
        this.label = 1;
        if (BuildersKt.withContext(r9, r2, this) != r0) goto L12;
        return r0;
    }
}
