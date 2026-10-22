package com.larus.xbridge.impl.choosemedia.features;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.io.File;
import java.io.IOException;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class BDXPickPhotosAndVideosFeature implements j4a.i {
    public static final /* synthetic */ int g = 0;
    public final Function3<FragmentActivity, Intent, Integer, Unit> a;
    public final WeakReference<Activity> b;
    public final j4a.f c;
    public boolean d;
    public final String e;
    public final String f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.xbridge.impl.choosemedia.features.BDXPickPhotosAndVideosFeature$onActivityResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.xbridge.impl.choosemedia.features.BDXPickPhotosAndVideosFeature$onActivityResult$1", f = "BDXPickPhotosAndVideosFeature.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $ctx;
        final /* synthetic */ boolean $isVideo;
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ BDXPickPhotosAndVideosFeature this$0;

        /* JADX INFO: renamed from: com.larus.xbridge.impl.choosemedia.features.BDXPickPhotosAndVideosFeature$onActivityResult$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.xbridge.impl.choosemedia.features.BDXPickPhotosAndVideosFeature$onActivityResult$1$1", f = "BDXPickPhotosAndVideosFeature.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Activity $ctx;
            final /* synthetic */ Uri $finalUri;
            final /* synthetic */ boolean $isVideo;
            int label;
            final /* synthetic */ BDXPickPhotosAndVideosFeature this$0;

            public C00281(Uri r1, Activity r2, boolean r3, BDXPickPhotosAndVideosFeature r4, Continuation<? super C00281> r5) {
                this.$finalUri = r1;
                this.$ctx = r2;
                this.$isVideo = r3;
                this.this$0 = r4;
                super(2, r5);
            }

            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new C00281(this.$finalUri, this.$ctx, this.$isVideo, this.this$0, r8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L28;
                ResultKt.throwOnFailure(r5);
                String r6 = this.$finalUri.toString();
                int r0 = j4a.e.a;     // Catch: Exception -> L9
                Long r1 = j4a.e.b(this.$ctx, this.$finalUri);     // Catch: Exception -> L9
                if (r1 == null) goto L10;
                long r2 = r1.longValue();     // Catch: Exception -> L9
            L12:
                if (this.$isVideo == false) goto L14;
                String r3 = LynxResourceModule.VIDEO_TYPE;
            L15:
                hx7.k.a r4 = new hx7.k.a(r6, r2, r3);
                boolean r7 = this.$isVideo;
                BDXPickPhotosAndVideosFeature r8 = this.this$0;
                if (r7 == false) goto L18;
            L25:
                List r9 = CollectionsKt.listOf(r4);
                j4a.f r10 = this.this$0.c;
                hx7.k r11 = new hx7.k();
                r11.a = r9;
                r10.a(r11);
                return Unit.INSTANCE;
            L18:
                if (r8.d == false) goto L25;
                int r12 = BDXPickPhotosAndVideosFeature.g;
                Application r13 = AppHost.a.getApplication();
                int r14 = l4a.a.a;
                String r15 = l4a.a.a(r13, UriProtector.parse(r6));
                String r16 = NameKeys.UnloadStrategy_No_Strategy;
                if (r15 != null) goto L30;
                r15 = NameKeys.UnloadStrategy_No_Strategy;
            L30:
                String r17 = j4a.h.a(r15);     // Catch: IOException -> L29
                Intrinsics.checkNotNull(r17);     // Catch: IOException -> L29
                r16 = r17;
            L24:
                r4.d = r16;
                goto L25
            L14:
                r3 = "image";
            L10:
                r2 = 0;
            L9:
                FLogger.a.e("BDXPickPhotosAndVideosFeature", "There have something wrong when getFileSize");
                goto L10
            L28:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(boolean r1, BDXPickPhotosAndVideosFeature r2, Uri r3, Activity r4, Continuation<? super AnonymousClass1> r5) {
            this.$isVideo = r1;
            this.this$0 = r2;
            this.$uri = r3;
            this.$ctx = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$isVideo, this.this$0, this.$uri, this.$ctx, r8);
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
        L54:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            if (this.$isVideo == false) goto L11;
            BDXPickPhotosAndVideosFeature r11 = this.this$0;
            String r4 = r11.e;
            r11.getClass();
            Intrinsics.checkNotNullParameter(r4, "formatSuffix");
            File r12 = aa9.a.a.d("video_upload", "video_" + UUID.randomUUID() + '.' + r4);
        L12:
            Uri r5 = Uri.fromFile(r12);
            Activity r13 = this.this$0.b.get();
            if (r13 == null) goto L15;
            BDXPickPhotosAndVideosFeature r2 = this.this$0;
            Uri r3 = this.$uri;
            Intrinsics.checkNotNull(r5);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r13, "activity");
            Intrinsics.checkNotNullParameter(r3, "sourceUri");
            Intrinsics.checkNotNullParameter(r5, "destinationUri");
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L48
            ContentResolver r7 = r13.getContentResolver();     // Catch: Throwable -> L48
            Unit r8 = null;
            if (r7 == null) goto L46;
            InputStream r9 = ContentResolverWrapper.openInputStream(r7, r3);     // Catch: Throwable -> L48
            if (r9 == null) goto L46;
            ContentResolver r14 = r13.getContentResolver();     // Catch: Throwable -> L41
            if (r14 == null) goto L38;
            OutputStream r15 = ContentResolverWrapper.openOutputStream(r14, r5);     // Catch: Throwable -> L41
            if (r15 == null) goto L38;
            byte[] r16 = new byte[4096];     // Catch: Throwable -> L33
        L27:
            int r17 = r9.read(r16);     // Catch: Throwable -> L33
            if (r17 == (-1)) goto L30;
            r15.write(r16, 0, r17);     // Catch: Throwable -> L33
            goto L27
        L30:
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L33
            CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L41
            Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L41
        L39:
            CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L48
            r8 = r19;
            goto L46
        L33:
            th = move-exception;
            throw th;     // Catch: Throwable -> L35
        L35:
            th = move-exception;
            CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L41
            throw th;     // Catch: Throwable -> L41
        L38:
            r19 = null;
        L41:
            th = move-exception;
            throw th;     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L46:
            Result.constructor-impl(r8);     // Catch: Throwable -> L48
        L50:
            MainCoroutineDispatcher r110 = Dispatchers.getMain().getImmediate();
            C00281 r20 = new C00281(r5, this.$ctx, this.$isVideo, this.this$0, null);
            this.label = 1;
            if (BuildersKt.withContext(r110, r20, this) != r0) goto L54;
            return r0;
        L48:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L50
        L15:
            return Unit.INSTANCE;
        L11:
            BDXPickPhotosAndVideosFeature r111 = this.this$0;
            String r22 = r111.f;
            r111.getClass();
            Intrinsics.checkNotNullParameter(r22, "formatSuffix");
            r12 = aa9.a.a.d("image_upload", "image_" + UUID.randomUUID() + '.' + r22);
            goto L12
        }
    }

    static {
    }

    public BDXPickPhotosAndVideosFeature(WeakReference r2, h4a.d r3, i4a.a r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "onFileSelected");
        this.a = r4;
        this.b = r2;
        this.c = r3;
        this.e = "mp4";
        this.f = "jpeg";
    }

    @Override // j4a.i
    public final boolean onActivityResult(int r15, int r16, Intent r17) {
        boolean r1 = false;
        if (r15 == 1311214) goto L5;
        return false;
    L5:
        if (r16 != 0) goto L8;
        this.c.onFailed(-7, "User cancelled");
        return true;
    L8:
        Activity r4 = this.b.get();
        if (r4 != null) goto L13;
        this.c.onFailed(0, "Activity not found");
        return true;
    L13:
        if (r17 == null) goto L15;
        Uri r3 = r17.getData();
    L16:
        if (r3 != null) goto L18;
    L32:
        this.c.onFailed(0, "Video doesn't exist");
        return true;
    L18:
        if (StringUtils.isEmpty(r3.toString()) == true) goto L32;
        Activity r2 = this.b.get();
        if (r2 == null) goto L25;
        ContentResolver r5 = r2.getContentResolver();
        if (r5 == null) goto L25;
        String r6 = r5.getType(r3);
    L26:
        if (r6 != null) goto L28;
    L30:
        FLogger.a.d("BDXPickPhotosAndVideosFeature", "type: " + r6 + ", isVideo: " + r1);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AnonymousClass1(r1, this, r3, r4, null), 2, null);
        return true;
    L28:
        if (StringsKt.contains$default(r6, LynxResourceModule.VIDEO_TYPE, false, 2, null) != true) goto L30;
        r1 = true;
    L25:
        r6 = null;
        goto L26
    L15:
        r3 = null;
        goto L16
    }
}
