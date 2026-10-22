package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.lark.lark_biz_feed_android.MoltenFfiLibLarkBizFeed;
import com.bytedance.lark.lark_biz_feed_android.UnhandledException;
import com.bytedance.lark.lark_biz_feed_android.f1;
import com.bytedance.lark.lark_biz_feed_android.h;
import com.bytedance.lark.lark_biz_feed_android.k;
import com.bytedance.lark.lark_biz_feed_android.m;
import com.bytedance.lark.view_flow_wrapper.MoltenService;
import com.bytedance.lark.view_flow_wrapper.v;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lark_biz_feed.proto.FuncParamsX7a8547e12a586378;
import lark_biz_feed.proto.FuncReturnXe6e6aa990169f5b3;
import lark_biz_feed.proto.UserForegroundScope;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class FeedRepositoryServiceExportedModuleWrapper extends MoltenService<k> {
    public final Lazy e;

    /* JADX INFO: renamed from: com.bytedance.lark.lark_biz_feed_android_wrapper.FeedRepositoryServiceExportedModuleWrapper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/lark_biz_feed_android/FeedRepositoryServiceExportedModule;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.lark.lark_biz_feed_android_wrapper.FeedRepositoryServiceExportedModuleWrapper$1", f = "FeedRepositoryServiceExportedModuleWrapper.kt", i = {}, l = {13}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super k>, Object> {
        final /* synthetic */ f1 $param0;
        final /* synthetic */ v $strategy;
        int label;

        public AnonymousClass1(v r1, f1 r2, Continuation<? super AnonymousClass1> r3) {
            this.$strategy = r1;
            this.$param0 = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass1(this.$strategy, this.$param0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super k> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L11:
            f1 r12 = this.$param0;
            Intrinsics.checkNotNullParameter(r12, "arg0");
            Lazy<Long> r2 = MoltenFfiLibLarkBizFeed.a;
            ByteString r3 = MoltenFfiLibLarkBizFeed.a.a(new m("getFeedRepositoryServiceExportedModule"));
            r12.getClass();
            byte[] r9 = new FuncParamsX7a8547e12a586378(new UserForegroundScope(Long.valueOf(r12.a)), r3).encode();
            long r4 = MoltenFfiLibLarkBizFeed.a.b();     // Catch: RuntimeException -> L21
            Intrinsics.checkNotNull(r9);     // Catch: RuntimeException -> L21
            byte[] r13 = MoltenFfiLibLarkBizFeed.molten_ffi_lark_biz_feed_call(r4, 0, -5174295463393179311L, r9);     // Catch: RuntimeException -> L21
            Long r14 = ((FuncReturnXe6e6aa990169f5b3) FuncReturnXe6e6aa990169f5b3.ADAPTER.decode(r13)).ret;
            if (r14 == null) goto L16;
            k r5 = new k(r14.longValue());
        L17:
            if (r5 == null) goto L20;
            return r5;
        L20:
            throw new IllegalArgumentException("exported module accessed before ready".toString());
        L16:
            r5 = null;
        L21:
            e = move-exception;
            if (e.getMessage() == null) goto L26;
            int r6 = h.a;
            String r15 = e.getMessage();
            Intrinsics.checkNotNull(r15);
            UnhandledException r7 = new UnhandledException(r15);
            Intrinsics.checkNotNullParameter(r7, "e");
            throw r7;
        L26:
            int r16 = h.a;
            UnhandledException r17 = new UnhandledException("Rust panic");
            Intrinsics.checkNotNullParameter(r17, "e");
            throw r17;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            v r18 = this.$strategy;
            this.label = 1;
            if (r18.a(this) != r0) goto L11;
            return r0;
        }
    }

    public FeedRepositoryServiceExportedModuleWrapper(f1 r3, v r4) {
        Intrinsics.checkNotNullParameter(r3, "param0");
        Intrinsics.checkNotNullParameter(r4, "strategy");
        super(new AnonymousClass1(r4, r3, null));
        this.e = LazyKt.lazy(new FeedRepositoryServiceExportedModuleWrapper$feedBadgeService$2(this));
    }
}
