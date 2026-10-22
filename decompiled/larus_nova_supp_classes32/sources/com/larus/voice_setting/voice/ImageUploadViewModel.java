package com.larus.voice_setting.voice;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpLiveData;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\r\b\u0002\u0010\u0010\u001a\u00070\u0011¢\u0006\u0002\b\u0012J\u001e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u000b\u0010\u0010\u001a\u00070\u0011¢\u0006\u0002\b\u0012H\u0002J%\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\u000b\u0010\u0010\u001a\u00070\u0011¢\u0006\u0002\b\u0012H\u0002R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/larus/voice_setting/voice/ImageUploadViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "upload", "Lcom/larus/network/http/HttpLiveData;", "Lcom/larus/bmhome/bot/bean/ImageUploadResult;", "getUpload", "()Lcom/larus/network/http/HttpLiveData;", "upload$delegate", "Lkotlin/Lazy;", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.URI_KEY, "Landroid/net/Uri;", "bizType", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/bmhome/bot/bean/FileBizType;", "handleUri", NameKeys.UnloadStrategy_No_Strategy, "kotlin.jvm.PlatformType", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "doUpload", "type", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.DATA_KEY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageUploadViewModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final long HANDLE_URI_ERROR_CODE = 7977;
    private static final String TAG = "ImageUploadViewModel—FLOW—SDK";
    private static final int targetSize = 1080;
    private final Lazy upload$delegate;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.ImageUploadViewModel$handleUri$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.ImageUploadViewModel$handleUri$2", f = "ImageUploadViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ ImageUploadViewModel this$0;

        public AnonymousClass2(ImageUploadViewModel r1, Uri r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$uri = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$uri, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super byte[]> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r4);
            InputStream r5 = ContentResolverWrapper.openInputStream(this.this$0.getApplication().getContentResolver(), this.$uri);
            BitmapFactory.Options r0 = new BitmapFactory.Options();
            r0.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(r5, null, r0);
            if (r5 == null) goto L7;
            r5.close();
        L7:
            r0.inSampleSize = MathKt.roundToInt((Math.min(r0.outWidth, r0.outHeight) * 1.0f) / ImageUploadViewModel.targetSize);
            r0.inJustDecodeBounds = false;
            InputStream r6 = ContentResolverWrapper.openInputStream(this.this$0.getApplication().getContentResolver(), this.$uri);
            Bitmap r1 = BitmapFactory.decodeStream(r6, null, r0);
            if (r6 == null) goto L10;
            r6.close();
        L10:
            ByteArrayOutputStream r7 = new ByteArrayOutputStream();
            Intrinsics.checkNotNull(r1);
            r1.compress(Bitmap.CompressFormat.JPEG, 100, r7);
            byte[] r2 = r7.toByteArray();
            r7.close();
            return r2;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.voice_setting.voice.ImageUploadViewModel$handleUri$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voice_setting.voice.ImageUploadViewModel$handleUri$3", f = "ImageUploadViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $bizType;
        final /* synthetic */ Uri $uri;
        int label;
        final /* synthetic */ ImageUploadViewModel this$0;

        public AnonymousClass3(ImageUploadViewModel r1, Uri r2, int r3, Continuation<? super AnonymousClass3> r4) {
            this.this$0 = r1;
            this.$uri = r2;
            this.$bizType = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass3(this.this$0, this.$uri, this.$bizType, r5);
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
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L15
        L13:
            Object r10 = Result.constructor-impl((byte[]) r9);     // Catch: Throwable -> L15
        L17:
            ImageUploadViewModel r2 = this.this$0;
            Throwable r3 = Result.exceptionOrNull-impl(r10);
            if (r3 == null) goto L25;
            com.larus.platform.service.g.a.ensureNotReachHere(r3);
            HttpLiveData<ImageUploadResult> r11 = r2.getUpload();
            String r5 = r3.getMessage();
            if (r5 != null) goto L22;
            r5 = NameKeys.UnloadStrategy_No_Strategy;
        L22:
            r11.setValue(new com.larus.network.http.b(new com.larus.network.http.f(new AsyncThrowable(ImageUploadViewModel.HANDLE_URI_ERROR_CODE, r5, r3), null), 6));
            return Unit.INSTANCE;
        L25:
            if (Result.isFailure-impl(r10) == false) goto L27;
            r10 = null;
        L27:
            byte[] r12 = (byte[]) r10;
            if (r12 == null) goto L31;
            ImageUploadViewModel.access$doUpload(this.this$0, "jpg", r12, this.$bizType);
        L31:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
            ImageUploadViewModel r13 = this.this$0;
            Uri r4 = this.$uri;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L15
            this.label = 1;     // Catch: Throwable -> L15
            r9 = ImageUploadViewModel.access$handleUri(r13, r4, this);     // Catch: Throwable -> L15
            if (r9 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L17
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

    public ImageUploadViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
        this.upload$delegate = LazyKt.lazy(new l0());
    }

    private final Job handleUri(Uri r7, int r8) {
        return BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new AnonymousClass3(this, r7, r8, null), 2, null);
    }

    public final void upload(Uri r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.URI_KEY);
        handleUri(r2, r3);
    }

    private final Object handleUri(Uri r4, Continuation<? super byte[]> r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, r4, null), r5);
    }

    public static final /* synthetic */ Object access$handleUri(ImageUploadViewModel r0, Uri r1, Continuation r2) {
        return r0.handleUri(r1, r2);
    }

    private final void doUpload(String r9, byte[] r10, int r11) {
        FLogger.a.i(TAG, "doUpload: called, type = " + r9 + ", data.size = " + r10.length);
        getUpload().a();
        HttpLiveData<ImageUploadResult> r1 = getUpload();
        JSONObject r4 = new JSONObject();
        JSONObject r0 = new JSONObject();
        r0.put("file_type", r9);
        r0.put("biz_type", r11);
        Unit r5 = Unit.INSTANCE;
        r4.put("file_head", r0);
        r4.put(LynxResourceModule.DATA_KEY, Base64.encodeToString(r10, 0));
        HttpLiveData.c(r1, "Social", "/alice/bot/upload_file", r4, true, MapsKt.mapOf(TuplesKt.to("biz_type", Integer.valueOf(r11))), 152);
    }

    public static final /* synthetic */ void access$doUpload(ImageUploadViewModel r0, String r1, byte[] r2, int r3) {
        r0.doUpload(r1, r2, r3);
    }

    public static /* synthetic */ void upload$default(ImageUploadViewModel r0, Uri r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 1;
    L5:
        r0.upload(r1, r2);
    }
}
