package com.larus.camera.impl.edulibs.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/edulibs/cameraapi/IdentifyDetectionResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.edulibs.camera.EduCameraManager$detectIdentifiable$result$1", f = "EduCameraManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EduCameraManager$detectIdentifiable$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IdentifyDetectionResult>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $imagePath;
    int label;

    public EduCameraManager$detectIdentifiable$result$1(Context r1, String r2, Continuation<? super EduCameraManager$detectIdentifiable$result$1> r3) {
        this.$context = r1;
        this.$imagePath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new EduCameraManager$detectIdentifiable$result$1(this.$context, this.$imagePath, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super IdentifyDetectionResult> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r6);
        int r7 = com.larus.camera.impl.edulibs.camera.internal.util.a.a;
        Context r8 = this.$context;
        String r0 = this.$imagePath;
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r0, MusicAppletPage.KEY_PATH);
        IdentifyDetectionResult r4 = null;
        if (StringsKt.startsWith$default(r0, "content://", false, 2, null) == false) goto L16;
        InputStream r9 = ContentResolverWrapper.openInputStream(r8.getContentResolver(), UriProtector.parse(r0));
        if (r9 != null) goto L24;
        Bitmap r1 = null;
    L17:
        if (r1 == null) goto L21;
        boolean r10 = StringsKt.startsWith$default(this.$imagePath, "content", false, 2, null);
        com.larus.camera.impl.edulibs.camera.internal.b r2 = com.larus.camera.impl.edulibs.camera.internal.b.a;
        Context r3 = this.$context;
        r2.getClass();
        r4 = com.larus.camera.impl.edulibs.camera.internal.b.a(r3, r1, r10);
        String r11 = this.$imagePath;
        if (r4.a == false) goto L21;
        a.e.put(r11, r4);
    L21:
        return r4;
    L24:
        r1 = BitmapFactory.decodeStream(r9);     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r9, null);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);
        throw th;
    L16:
        r1 = BitmapFactory.decodeFile(r0);
        goto L17
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
