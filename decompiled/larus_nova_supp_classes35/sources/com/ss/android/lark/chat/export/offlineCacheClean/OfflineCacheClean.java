package com.ss.android.lark.chat.export.offlineCacheClean;

import com.bytedance.lark.pb.im.v1.OfflineDataCleanPush;
import com.ss.android.eventbus.EventBus;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import f0c.h;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class OfflineCacheClean implements a, r {
    public final m a;
    public final g b;
    public final b38.b c;
    public final CoroutineScope d;
    public final Lazy e;
    public final CopyOnWriteArrayList<b> f;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.export.offlineCacheClean.OfflineCacheClean$onUserOnline$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.export.offlineCacheClean.OfflineCacheClean$onUserOnline$1", f = "OfflineCacheClean.kt", i = {}, l = {90, 96}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ OfflineCacheClean this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.export.offlineCacheClean.OfflineCacheClean$onUserOnline$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.chat.export.offlineCacheClean.OfflineCacheClean$onUserOnline$1$1", f = "OfflineCacheClean.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ OfflineCacheClean this$0;

            public C00971(OfflineCacheClean r1, Continuation<? super C00971> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00971(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r3);
                boolean r4 = !this.this$0.f.isEmpty();
                Iterator<T> r0 = this.this$0.f.iterator();
            L6:
                if (r0.hasNext() == false) goto L8;
                ((b) r0.next()).a();
                goto L6
            L8:
                if (r4 == false) goto L11;
                EventBus.getDefault().trigger(new zdb.b());
            L11:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(OfflineCacheClean r1, Continuation<? super AnonymousClass1> r2) {
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

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0086 -> B:12:0x003f). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            com.larksuite.rucket.job.extension.a r2 = (com.larksuite.rucket.job.extension.a) this.L$0;
            ResultKt.throwOnFailure(r10);
        L11:
            AnonymousClass1 r11 = this;
        L12:
            r11.L$0 = r2;
            r11.label = 1;
            Object r4 = r2.hasNext(r11);
            if (r4 != r0) goto L15;
            return r0;
        L15:
            Object r8 = r0;
            AnonymousClass1 r3 = r11;
            r10 = r4;
            com.larksuite.rucket.job.extension.a r5 = r2;
            Object r6 = r8;
        L17:
            if (((Boolean) r10).booleanValue() == false) goto L28;
            com.larksuite.rucket.job.base.b r12 = r5.a();
            r12.getClass();
            if ((r12 instanceof com.larksuite.rucket.job.base.b.b) == false) goto L22;
        L26:
            r11 = r3;
            r0 = r6;
            r2 = r5;
            goto L12
        L22:
            if (((OfflineDataCleanPush) r12.b()).status != OfflineDataCleanPush.Status.START_CLEAN) goto L26;
            MainCoroutineDispatcher r13 = Dispatchers.getMain();
            C00971 r7 = new C00971(r3.this$0, null);
            r3.L$0 = r5;
            r3.label = 2;
            if (BuildersKt.withContext(r13, r7, r3) != r6) goto L26;
            return r6;
        L28:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            com.larksuite.rucket.job.extension.a r9 = (com.larksuite.rucket.job.extension.a) this.L$0;
            ResultKt.throwOnFailure(r10);
            r5 = r9;
            r6 = r0;
            r3 = this;
            goto L17
        L10:
            ResultKt.throwOnFailure(r10);
            r2 = ((c) this.this$0.e.getValue()).pushOfflineDataClean().iterator();
            goto L11
        }
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final m getPassport() {
        return this.a;
    }

    @Override // com.ss.android.lark.chat.export.offlineCacheClean.a
    public final void Ib(b r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this.f.remove(r2);
    }

    @Override // com.ss.android.lark.chat.export.offlineCacheClean.a
    public final void Wa(b r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        if (this.f.contains(r2) == true) goto L6;
        this.f.add(r2);
        return;
    }

    public final void onUserOffline(h r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r3, "state");
        this.f.clear();
        CoroutineScopeKt.cancel$default(this.d, null, 1, null);
    }

    public final void onUserOnline(h r7) {
        Intrinsics.checkNotNullParameter(r7, "state");
        Intrinsics.checkNotNullParameter(r7, "state");
        if (this.b.isEnable("lark.security.offline_caching_policy") == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.d, Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    @Inject
    public OfflineCacheClean(m r2, g r3, b38.b r4) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "fgService");
        Intrinsics.checkNotNullParameter(r4, "rucket");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.e = LazyKt.lazy(new OfflineCacheClean$service$2(this));
        this.f = new CopyOnWriteArrayList();
        r2.d(this);
    }
}
