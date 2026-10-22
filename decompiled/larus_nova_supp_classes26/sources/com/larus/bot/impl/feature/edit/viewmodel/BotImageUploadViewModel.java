package com.larus.bot.impl.feature.edit.viewmodel;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.HttpLiveData;
import com.larus.network.http.b;
import com.larus.network.http.f;
import com.larus.platform.service.g;
import com.larus.utils.z0;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\r\b\u0002\u0010\u0010\u001a\u00070\u0011¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014J \u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0017J%\u0010\u0015\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u000b\u0010\u0010\u001a\u00070\u0011¢\u0006\u0002\b\u0012H\u0002J1\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u000b\u0010\u0010\u001a\u00070\u0011¢\u0006\u0002\b\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001bH\u0002JA\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\r\b\u0002\u0010\u0010\u001a\u00070\u0011¢\u0006\u0002\b\u00122\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010 R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\""}, d2 = {"Lcom/larus/bot/impl/feature/edit/viewmodel/BotImageUploadViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "upload", "Lcom/larus/network/http/HttpLiveData;", "Lcom/larus/bmhome/bot/bean/ImageUploadResult;", "getUpload", "()Lcom/larus/network/http/HttpLiveData;", "upload$delegate", "Lkotlin/Lazy;", "", "uri", "Landroid/net/Uri;", "bizType", "", "Lcom/larus/bmhome/bot/bean/FileBizType;", "uriIsFile", "", "handleUri", "", "(ZLandroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "doUpload", "type", "", "data", "imgWatermarkType", "syncUpload", "Lcom/larus/network/http/Async;", "(Landroid/net/Uri;ILjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotImageUploadViewModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final long HANDLE_URI_ERROR_CODE = 7977;
    private static final String TAG = "BotImageUploadViewModel";
    private static final int targetSize = 1080;
    private final Lazy upload$delegate;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel$handleUri$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel$handleUri$2", f = "BotImageUploadViewModel.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
        final /* synthetic */ Uri $uri;
        final /* synthetic */ boolean $uriIsFile;
        int label;
        final /* synthetic */ BotImageUploadViewModel this$0;

        public AnonymousClass2(boolean r1, BotImageUploadViewModel r2, Uri r3, Continuation<? super AnonymousClass2> r4) {
            this.$uriIsFile = r1;
            this.this$0 = r2;
            this.$uri = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$uriIsFile, this.this$0, this.$uri, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super byte[]> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L21:
            CloseableReference r7 = (CloseableReference) r6;
            if (r7 == null) goto L24;
            CloseableImage r8 = (CloseableImage) r7.get();
        L26:
            if ((r8 instanceof CloseableStaticBitmap) == false) goto L28;
            CloseableStaticBitmap r9 = (CloseableStaticBitmap) r8;
        L29:
            if (r9 == null) goto L31;
            Bitmap r10 = r9.getUnderlyingBitmap();
        L32:
            if (r10 != null) goto L34;
        L37:
            return null;
        L34:
            if (r10.isRecycled() == true) goto L37;
            ByteArrayOutputStream r2 = new ByteArrayOutputStream();
            Bitmap r11 = r10.copy(z0.b(r10.getConfig()), r10.isMutable());
            Intrinsics.checkNotNull(r11);
            r11.compress(Bitmap.CompressFormat.JPEG, 100, r2);
            byte[] r12 = r2.toByteArray();
            r2.close();
            return r12;
        L31:
            r10 = null;
            goto L32
        L28:
            r9 = null;
            goto L29
        L24:
            r8 = null;
            goto L26
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            if (this.$uriIsFile == false) goto L18;
            InputStream r13 = ContentResolverWrapper.openInputStream(this.this$0.getApplication().getContentResolver(), this.$uri);
            BitmapFactory.Options r3 = new BitmapFactory.Options();
            r3.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(r13, null, r3);
            if (r13 == null) goto L13;
            r13.close();
        L13:
            r3.inSampleSize = MathKt.roundToInt((Math.min(r3.outWidth, r3.outHeight) * 1.0f) / BotImageUploadViewModel.targetSize);
            r3.inJustDecodeBounds = false;
            InputStream r14 = ContentResolverWrapper.openInputStream(this.this$0.getApplication().getContentResolver(), this.$uri);
            Bitmap r4 = BitmapFactory.decodeStream(r14, null, r3);
            if (r14 == null) goto L16;
            r14.close();
        L16:
            ByteArrayOutputStream r15 = new ByteArrayOutputStream();
            Intrinsics.checkNotNull(r4);
            r4.compress(Bitmap.CompressFormat.JPEG, 100, r15);
            byte[] r5 = r15.toByteArray();
            r15.close();
            return r5;
        L18:
            String r16 = this.$uri.toString();
            this.label = 1;
            r6 = ImageLoaderKt.i(r16, "bot_avatar_download", null, this, 60);
            if (r6 != r0) goto L21;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel$handleUri$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel$handleUri$3", f = "BotImageUploadViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $bizType;
        final /* synthetic */ Uri $uri;
        final /* synthetic */ boolean $uriIsFile;
        int label;
        final /* synthetic */ BotImageUploadViewModel this$0;

        public AnonymousClass3(BotImageUploadViewModel r1, boolean r2, Uri r3, int r4, Continuation<? super AnonymousClass3> r5) {
            this.this$0 = r1;
            this.$uriIsFile = r2;
            this.$uri = r3;
            this.$bizType = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass3(this.this$0, this.$uriIsFile, this.$uri, this.$bizType, r8);
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
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L19
        L17:
            Object r10 = Result.constructor-impl((byte[]) r9);     // Catch: Throwable -> L19
        L21:
            BotImageUploadViewModel r2 = this.this$0;
            Throwable r3 = Result.exceptionOrNull-impl(r10);
            if (r3 == null) goto L29;
            g.a.ensureNotReachHere(r3);
            HttpLiveData<ImageUploadResult> r11 = r2.getUpload();
            String r5 = r3.getMessage();
            if (r5 != null) goto L26;
            r5 = "";
        L26:
            r11.setValue(new b(new f(new AsyncThrowable(BotImageUploadViewModel.HANDLE_URI_ERROR_CODE, r5, r3), null), 6));
            return Unit.INSTANCE;
        L29:
            if (Result.isFailure-impl(r10) == false) goto L31;
            r10 = null;
        L31:
            byte[] r4 = (byte[]) r10;
            if (r4 == null) goto L35;
            BotImageUploadViewModel.doUpload$default(this.this$0, "jpg", r4, this.$bizType, null, 8, null);
        L35:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
            BotImageUploadViewModel r12 = this.this$0;
            boolean r6 = this.$uriIsFile;
            Uri r7 = this.$uri;
            Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L19
            if (r6 == false) goto L13;
            boolean r13 = true;
        L14:
            this.label = 1;     // Catch: Throwable -> L19
            r9 = BotImageUploadViewModel.access$handleUri(r12, r13, r7, this);     // Catch: Throwable -> L19
            if (r9 != r0) goto L17;
            return r0;
        L13:
            r13 = false;
        L19:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel$syncUpload$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/bot/bean/ImageUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel$syncUpload$2", f = "BotImageUploadViewModel.kt", i = {}, l = {122, 130}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02202 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends ImageUploadResult>>, Object> {
        final /* synthetic */ int $bizType;
        final /* synthetic */ String $imgWatermarkType;
        final /* synthetic */ Uri $uri;
        final /* synthetic */ boolean $uriIsFile;
        int label;
        final /* synthetic */ BotImageUploadViewModel this$0;

        public C02202(int r1, BotImageUploadViewModel r2, boolean r3, Uri r4, String r5, Continuation<? super C02202> r6) {
            this.$bizType = r1;
            this.this$0 = r2;
            this.$uriIsFile = r3;
            this.$uri = r4;
            this.$imgWatermarkType = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C02202(this.$bizType, this.this$0, this.$uriIsFile, this.$uri, this.$imgWatermarkType, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<ImageUploadResult>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            boolean r3 = true;
            if (r0 == 0) goto L11;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            ResultKt.throwOnFailure(r16);
            Object r1 = r16;
        L48:
            return (com.larus.network.http.a) r1;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L21
            Object r2 = r16;
        L19:
            Object r4 = Result.constructor-impl((byte[]) r2);     // Catch: Throwable -> L21
        L23:
            Throwable r5 = Result.exceptionOrNull-impl(r4);
            if (r5 == null) goto L31;
            g.a.ensureNotReachHere(r5);
            String r6 = r5.getMessage();
            if (r6 != null) goto L29;
            r6 = "";
        L29:
            return new f(new AsyncThrowable(BotImageUploadViewModel.HANDLE_URI_ERROR_CODE, r6, r5), null);
        L31:
            if (Result.isFailure-impl(r4) == false) goto L33;
            r4 = null;
        L33:
            byte[] r7 = (byte[]) r4;
            if (r7 == null) goto L50;
            if (r7.length == 0) goto L39;
            r3 = false;
        L39:
            if (r3 == true) goto L50;
            JSONObject r8 = new JSONObject();
            int r9 = this.$bizType;
            String r10 = this.$imgWatermarkType;
            JSONObject r11 = new JSONObject();
            r11.put("file_type", "jpg");
            r11.put("biz_type", r9);
            if (r10 == null) goto L44;
            r11.put("img_watermark_type", r10);
        L44:
            Unit r12 = Unit.INSTANCE;
            r8.put("file_head", r11);
            r8.put("data", Base64.encodeToString(r7, 0));
            Map r13 = MapsKt.mapOf(TuplesKt.to("biz_type", Boxing.boxInt(this.$bizType)));
            this.label = 2;
            r1 = HttpExtKt.k("Social", ImageUploadResult.class, "/alice/bot/upload_file", r8, null, null, true, r13, null, null, this, 816);
            if (r1 != r14) goto L48;
            return r14;
        L50:
            return new f(new AsyncThrowable(BotImageUploadViewModel.HANDLE_URI_ERROR_CODE, "handle uri failed", new Throwable()), null);
        L11:
            ResultKt.throwOnFailure(r16);
            BotImageUploadViewModel r15 = this.this$0;
            boolean r17 = this.$uriIsFile;
            Uri r18 = this.$uri;
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L21
            if (r17 == false) goto L15;
            boolean r20 = true;
        L16:
            this.label = 1;     // Catch: Throwable -> L21
            r2 = BotImageUploadViewModel.access$handleUri(r15, r20, r18, this);     // Catch: Throwable -> L21
            if (r2 != r14) goto L19;
            return r14;
        L15:
            r20 = false;
        L21:
            th = move-exception;
            Result.Companion r21 = Result.Companion;
            r4 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L23
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ HttpLiveData yo() {
        return upload_delegate$lambda$0();
    }

    private static final HttpLiveData upload_delegate$lambda$0() {
        return new HttpLiveData(ImageUploadResult.class);
    }

    public final HttpLiveData<ImageUploadResult> getUpload() {
        return (HttpLiveData) this.upload$delegate.getValue();
    }

    public BotImageUploadViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.upload$delegate = LazyKt.lazy(new com.larus.bot.impl.feature.edit.viewmodel.a());
    }

    private final Job handleUri(boolean r11, Uri r12, int r13) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass3(this, r11, r12, r13, null), 2, null);
    }

    public final void upload(Uri r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        handleUri(r4, r2, r3);
    }

    private final Object handleUri(boolean r4, Uri r5, Continuation<? super byte[]> r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(r4, this, r5, null), r6);
    }

    public static final /* synthetic */ Object access$handleUri(BotImageUploadViewModel r0, boolean r1, Uri r2, Continuation r3) {
        return r0.handleUri(r1, r2, r3);
    }

    private final void doUpload(String r9, byte[] r10, int r11, String r12) {
        int r0 = r10.length;
        getUpload().a();
        HttpLiveData<ImageUploadResult> r1 = getUpload();
        JSONObject r4 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r2.put("file_type", r9);
        r2.put("biz_type", r11);
        Unit r5 = Unit.INSTANCE;
        r4.put("file_head", r2);
        if (r12 == null) goto L5;
        r4.put("img_watermark_type", r12);
    L5:
        r4.put("data", Base64.encodeToString(r10, 0));
        HttpLiveData.c(r1, "Social", "/alice/bot/upload_file", r4, true, MapsKt.mapOf(TuplesKt.to("biz_type", Integer.valueOf(r11))), 152);
    }

    public final Object syncUpload(Uri r10, int r11, String r12, boolean r13, Continuation<? super com.larus.network.http.a<ImageUploadResult>> r14) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C02202(r11, this, r13, r10, r12, null), r14);
    }

    public static /* synthetic */ void upload$default(BotImageUploadViewModel r0, Uri r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = false;
    L8:
        r0.upload(r1, r2, r3);
    }

    public static /* synthetic */ void doUpload$default(BotImageUploadViewModel r0, String r1, byte[] r2, int r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.doUpload(r1, r2, r3, r4);
    }

    public static /* synthetic */ Object syncUpload$default(BotImageUploadViewModel r6, Uri r7, int r8, String r9, boolean r10, Continuation r11, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L5;
        int r2 = 1;
    L7:
        if ((r12 & 4) == 0) goto L9;
        r9 = null;
    L9:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L12;
        boolean r4 = false;
    L14:
        return r6.syncUpload(r7, r2, r3, r4, r11);
    L12:
        r4 = r10;
        goto L14
    L5:
        r2 = r8;
        goto L7
    }
}
