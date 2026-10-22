package com.larus.xbridge.impl.choosemedia.features;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class BDXPickVideosFeature implements j4a.i {
    public final Function3<FragmentActivity, Intent, Integer, Unit> a;
    public final WeakReference<Activity> b;
    public final j4a.f c;
    public final String d;

    /* JADX INFO: renamed from: com.larus.xbridge.impl.choosemedia.features.BDXPickVideosFeature$onActivityResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.xbridge.impl.choosemedia.features.BDXPickVideosFeature$onActivityResult$1", f = "BDXPickVideosFeature.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $ctx;
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ BDXPickVideosFeature this$0;

        /* JADX INFO: renamed from: com.larus.xbridge.impl.choosemedia.features.BDXPickVideosFeature$onActivityResult$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.xbridge.impl.choosemedia.features.BDXPickVideosFeature$onActivityResult$1$1", f = "BDXPickVideosFeature.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Activity $ctx;
            final /* synthetic */ Uri $finalUri;
            int label;
            final /* synthetic */ BDXPickVideosFeature this$0;

            public C00291(Uri r1, Activity r2, BDXPickVideosFeature r3, Continuation<? super C00291> r4) {
                this.$finalUri = r1;
                this.$ctx = r2;
                this.this$0 = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00291(this.$finalUri, this.$ctx, this.this$0, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L11;
                ResultKt.throwOnFailure(r5);
                String r6 = this.$finalUri.toString();
                int r0 = j4a.e.a;
                Long r1 = j4a.e.b(this.$ctx, this.$finalUri);
                if (r1 == null) goto L7;
                long r2 = r1.longValue();
            L8:
                List r7 = CollectionsKt.listOf(new hx7.k.a(r6, r2, LynxResourceModule.VIDEO_TYPE));
                j4a.f r3 = this.this$0.c;
                hx7.k r4 = new hx7.k();
                r4.a = r7;
                r3.a(r4);
                return Unit.INSTANCE;
            L7:
                r2 = 0;
                goto L8
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(BDXPickVideosFeature r1, Uri r2, Activity r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$uri = r2;
            this.$ctx = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$uri, this.$ctx, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L51:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            BDXPickVideosFeature r10 = this.this$0;
            String r2 = r10.d;
            r10.getClass();
            Intrinsics.checkNotNullParameter(r2, "formatSuffix");
            Uri r11 = Uri.fromFile(aa9.a.a.d("video_upload", "video_" + UUID.randomUUID() + '.' + r2));
            Activity r3 = this.this$0.b.get();
            if (r3 == null) goto L11;
            BDXPickVideosFeature r4 = this.this$0;
            Uri r5 = this.$uri;
            Intrinsics.checkNotNull(r11);
            r4.getClass();
            Intrinsics.checkNotNullParameter(r3, "activity");
            Intrinsics.checkNotNullParameter(r5, "sourceUri");
            Intrinsics.checkNotNullParameter(r11, "destinationUri");
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L45
            ContentResolver r7 = r3.getContentResolver();     // Catch: Throwable -> L45
            if (r7 == null) goto L42;
            InputStream r8 = ContentResolverWrapper.openInputStream(r7, r5);     // Catch: Throwable -> L45
            if (r8 == null) goto L42;
            ContentResolver r12 = r3.getContentResolver();     // Catch: Throwable -> L37
            if (r12 == null) goto L34;
            OutputStream r13 = ContentResolverWrapper.openOutputStream(r12, r11);     // Catch: Throwable -> L37
            if (r13 == null) goto L34;
            byte[] r14 = new byte[4096];     // Catch: Throwable -> L29
        L23:
            int r15 = r8.read(r14);     // Catch: Throwable -> L29
            if (r15 == (-1)) goto L26;
            r13.write(r14, 0, r15);     // Catch: Throwable -> L29
            goto L23
        L26:
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L29
            CloseableKt.closeFinally(r13, null);     // Catch: Throwable -> L37
            Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L37
        L35:
            CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L45
        L43:
            Result.constructor-impl(r17);     // Catch: Throwable -> L45
        L47:
            MainCoroutineDispatcher r18 = Dispatchers.getMain().getImmediate();
            C00291 r19 = new C00291(r11, this.$ctx, this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(r18, r19, this) != r0) goto L51;
            return r0;
        L29:
            th = move-exception;
            throw th;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            CloseableKt.closeFinally(r13, th);     // Catch: Throwable -> L37
            throw th;     // Catch: Throwable -> L37
        L34:
            r17 = null;
        L37:
            th = move-exception;
            throw th;     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L45
            throw th;     // Catch: Throwable -> L45
        L42:
            r17 = null;
        L45:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L47
        L11:
            return Unit.INSTANCE;
        }
    }

    public BDXPickVideosFeature(WeakReference r2, h4a.d r3, i4a.a r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "onFileSelected");
        this.a = r4;
        this.b = r2;
        this.c = r3;
        this.d = "mp4";
    }

    @Override // j4a.i
    public final boolean onActivityResult(int r10, int r11, Intent r12) {
        if (r10 != 1311213) goto L21;
        if (r11 != 0) goto L7;
        this.c.onFailed(-7, "User cancelled");
        return true;
    L7:
        Activity r13 = this.b.get();
        if (r13 != null) goto L12;
        this.c.onFailed(0, "Activity not found");
        return true;
    L12:
        if (r12 == null) goto L14;
        Uri r14 = r12.getData();
    L15:
        if (r14 != null) goto L17;
    L20:
        this.c.onFailed(0, "Video doesn't exist");
        goto L21
    L17:
        if (StringUtils.isEmpty(r14.toString()) == true) goto L20;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(this, r14, r13, null), 2, null);
        goto L21
    L14:
        r14 = null;
    L21:
        return true;
    }
}
