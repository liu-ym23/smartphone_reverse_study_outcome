package com.larus.profile.impl;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.tencent.open.log.TraceLevel;
import com.yalantis.ucrop.UCropActivity;
import java.io.File;
import java.io.InputStream;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.ProfileEditFragment$handlePhotoPickerResult$1", f = "ProfileEditFragment.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
public final class ProfileEditFragment$handlePhotoPickerResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $act;
    final /* synthetic */ File $tmpDir;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ ProfileEditFragment this$0;

    /* JADX INFO: renamed from: com.larus.profile.impl.ProfileEditFragment$handlePhotoPickerResult$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.profile.impl.ProfileEditFragment$handlePhotoPickerResult$1$1", f = "ProfileEditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $act;
        final /* synthetic */ Uri $finalUri;
        final /* synthetic */ File $tmpDir;
        int label;
        final /* synthetic */ ProfileEditFragment this$0;

        public AnonymousClass1(Uri r1, File r2, ProfileEditFragment r3, FragmentActivity r4, Continuation<? super AnonymousClass1> r5) {
            this.$finalUri = r1;
            this.$tmpDir = r2;
            this.this$0 = r3;
            this.$act = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$finalUri, this.$tmpDir, this.this$0, this.$act, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r5);
            Uri r6 = this.$finalUri;
            Uri r0 = Uri.fromFile(new PolarisFileWrapper(this.$tmpDir, "crop_user_avatar.jpg"));
            Intent r1 = new Intent();
            Bundle r2 = new Bundle();
            r2.putParcelable("com.yalantis.ucrop.InputUri", r6);
            r2.putParcelable("com.yalantis.ucrop.OutputUri", r0);
            r2.putFloat("com.yalantis.ucrop.AspectRatioX", 1.0f);
            r2.putFloat("com.yalantis.ucrop.AspectRatioY", 1.0f);
            ActivityResultLauncher<Intent> r7 = this.this$0.n;
            if (r7 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("cropLauncher");
            r7 = null;
        L7:
            r1.setClass(this.$act, UCropActivity.class);
            r1.putExtras(r2);
            r7.launch(r1);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ProfileEditFragment$handlePhotoPickerResult$1(File r1, ProfileEditFragment r2, Uri r3, FragmentActivity r4, Continuation<? super ProfileEditFragment$handlePhotoPickerResult$1> r5) {
        this.$tmpDir = r1;
        this.this$0 = r2;
        this.$uri = r3;
        this.$act = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ProfileEditFragment$handlePhotoPickerResult$1(this.$tmpDir, this.this$0, this.$uri, this.$act, r8);
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
    L66:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        PolarisFileWrapper r11 = new PolarisFileWrapper(this.$tmpDir, "src_user_avatar.jpg");
        ProfileEditFragment r2 = this.this$0;
        Uri r3 = this.$uri;
        Pattern r4 = ProfileEditFragment.r;
        FragmentActivity r5 = r2.getActivity();
        if (r5 == null) goto L11;
        ContentResolver r6 = r5.getContentResolver();
    L71:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L27
        if (r6 == null) goto L24;
        InputStream r8 = ContentResolverWrapper.openInputStream(r6, r3);     // Catch: Throwable -> L27
        if (r8 == null) goto L24;
        Bitmap r9 = BitmapFactory.decodeStream(r8);     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L27
    L25:
        Object r12 = Result.constructor-impl(r9);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r12) == false) goto L32;
        r12 = null;
    L32:
        Bitmap r13 = (Bitmap) r12;
        if (r13 == null) goto L69;
    L47:
        if (r13 == null) goto L57;
        PolarisFileOutputStreamWrapper r14 = new PolarisFileOutputStreamWrapper(r11);
        r13.compress(Bitmap.CompressFormat.JPEG, 90, r14);     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r14, null);
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L57:
        if (r11.exists() == true) goto L59;
    L61:
        Uri r15 = this.$uri;
    L62:
        Uri r16 = r15;
        MainCoroutineDispatcher r17 = Dispatchers.getMain();
        AnonymousClass1 r18 = new AnonymousClass1(r16, this.$tmpDir, this.this$0, this.$act, null);
        this.label = 1;
        if (BuildersKt.withContext(r17, r18, this) != r0) goto L66;
        return r0;
    L59:
        if (r11.length() <= 0) goto L61;
        r15 = Uri.fromFile(r11);
        goto L62
    L69:
    L41:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Object r20 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        if (Result.isFailure-impl(r20) == false) goto L46;
        r20 = null;
    L46:
        r13 = (Bitmap) r20;
        goto L47
    L35:
        if (Build.VERSION.SDK_INT < 28) goto L38;
        if (r6 == null) goto L38;
        Bitmap r21 = ImageDecoder.decodeBitmap(ImageDecoder.createSource(r6, r3));     // Catch: Throwable -> L41
    L39:
        r20 = Result.constructor-impl(r21);     // Catch: Throwable -> L41
    L38:
        r21 = MediaStore.Images.Media.getBitmap(r6, r3);     // Catch: Throwable -> L41
        goto L39
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L24:
        r9 = null;
    L27:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L11:
        r6 = null;
        goto L71
    }
}
