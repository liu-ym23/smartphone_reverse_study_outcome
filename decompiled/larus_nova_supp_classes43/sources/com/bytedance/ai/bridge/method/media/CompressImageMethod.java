package com.bytedance.ai.bridge.method.media;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.media.image.AbsCompressImageMethodIDL;
import com.bytedance.ai.file.AppletFileError;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.utils.g;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import e3.d;
import f3.h;
import java.io.File;
import k3.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/media/CompressImageMethod;", "Lcom/bytedance/ai/bridge/media/image/AbsCompressImageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/media/image/AbsCompressImageMethodIDL$CompressImageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/media/image/AbsCompressImageMethodIDL$CompressImageResultModel;", "calculateInSampleSize", "", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CompressImageMethod extends AbsCompressImageMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.media.CompressImageMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.bridge.method.media.CompressImageMethod$handle$1", f = "CompressImageMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ h<AbsCompressImageMethodIDL.b> $callback;
        final /* synthetic */ AppletFileManager $fm;
        final /* synthetic */ AbsCompressImageMethodIDL.a $params;
        int label;
        final /* synthetic */ CompressImageMethod this$0;

        public AnonymousClass1(AppletFileManager r1, AbsCompressImageMethodIDL.a r10, h<AbsCompressImageMethodIDL.b> r11, CompressImageMethod r12, Continuation<? super AnonymousClass1> r13) {
            this.$fm = r1;
            this.$params = r10;
            this.$callback = r11;
            this.this$0 = r12;
            super(2, r13);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$fm, this.$params, this.$callback, this.this$0, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r17) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L76;
            ResultKt.throwOnFailure(r17);
            AppletFileManager r0 = this.$fm;     // Catch: Exception -> L54 AppletFileError -> L63
            int r10 = com.bytedance.ai.file.a.b;     // Catch: Exception -> L54 AppletFileError -> L63
            File r1 = r0.n(com.bytedance.ai.file.a.C0040a.a(this.$params.getSrc()));     // Catch: Exception -> L54 AppletFileError -> L63
        L7:
            if (r1.exists() == true) goto L10;
            g r11 = g.a;     // Catch: Exception -> L54
            StringBuilder r12 = new StringBuilder("call failed, errNo=");     // Catch: Exception -> L54
            f3.a r13 = f3.a.t;     // Catch: Exception -> L54
            r12.append(r13.a);     // Catch: Exception -> L54
            r12.append(", msg=source file not found");     // Catch: Exception -> L54
            r11.e("AISDK_JSB_CompressImageMethod", r12.toString());     // Catch: Exception -> L54
            h.a.a(this.$callback, "source file does not exist", r13, null, 10);     // Catch: Exception -> L54
            return Unit.INSTANCE;
        L10:
            BitmapFactory.Options r14 = new BitmapFactory.Options();     // Catch: Exception -> L54
            Integer r15 = this.$params.getCompressedWidth();     // Catch: Exception -> L54
            Integer r16 = this.$params.getCompressedHeight();     // Catch: Exception -> L54
            if (r15 == null) goto L29;
            if (r16 == null) goto L29;
            if (r15.intValue() <= 0) goto L29;
            if (r16.intValue() <= 0) goto L29;
            r14.inJustDecodeBounds = true;     // Catch: Exception -> L54
            BitmapFactory.decodeFile(r1.getAbsolutePath(), r14);     // Catch: Exception -> L54
            CompressImageMethod r18 = this.this$0;     // Catch: Exception -> L54
            int r19 = r15.intValue();     // Catch: Exception -> L54
            int r110 = r16.intValue();     // Catch: Exception -> L54
            int r111 = CompressImageMethod.b;     // Catch: Exception -> L54
            r18.getClass();     // Catch: Exception -> L54
            int r112 = r14.outHeight;     // Catch: Exception -> L54
            int r113 = r14.outWidth;     // Catch: Exception -> L54
            if (r112 > r110) goto L22;
            if (r113 > r19) goto L22;
            int r114 = 1;
        L28:
            r14.inSampleSize = r114;     // Catch: Exception -> L54
            r14.inJustDecodeBounds = false;     // Catch: Exception -> L54
        L22:
            int r115 = r112 / 2;     // Catch: Exception -> L54
            int r116 = r113 / 2;     // Catch: Exception -> L54
            r114 = 1;
        L24:
            if ((r115 / r114) < r110) goto L28;
            if ((r116 / r114) < r19) goto L28;
            r114 = r114 * 2;     // Catch: Exception -> L54
        L29:
            Bitmap r20 = BitmapFactory.decodeFile(r1.getAbsolutePath(), r14);     // Catch: Exception -> L54
            if (r20 != null) goto L33;
            g r21 = g.a;     // Catch: Exception -> L54
            StringBuilder r22 = new StringBuilder();     // Catch: Exception -> L54
            r22.append("call failed, errNo=");     // Catch: Exception -> L54
            f3.a r23 = f3.a.f;     // Catch: Exception -> L54
            r22.append(r23.a);     // Catch: Exception -> L54
            r22.append(", msg=cannot decode image");     // Catch: Exception -> L54
            r21.e("AISDK_JSB_CompressImageMethod", r22.toString());     // Catch: Exception -> L54
            h.a.a(this.$callback, "cannot decode image", r23, null, 10);     // Catch: Exception -> L54
            return Unit.INSTANCE;
        L33:
            if (r15 == null) goto L47;
            if (r16 == null) goto L47;
            if (r15.intValue() <= 0) goto L47;
            if (r16.intValue() <= 0) goto L47;
            if (r20.getWidth() == r15.intValue()) goto L42;
        L43:
            Bitmap r24 = Bitmap.createScaledBitmap(r20, r15.intValue(), r16.intValue(), true);     // Catch: Exception -> L54
            if (r24 == r20) goto L46;
            r20.recycle();     // Catch: Exception -> L54
        L46:
            r20 = r24;
            goto L47
        L42:
            if (r20.getHeight() != r16.intValue()) goto L43;
        L47:
            File r25 = new PolarisFileWrapper(this.$fm.e, "compressed_" + System.currentTimeMillis() + ".jpg");     // Catch: Exception -> L54
            File r26 = r25.getParentFile();     // Catch: Exception -> L54
            if (r26 == null) goto L50;
            Boxing.boxBoolean(r26.mkdirs());     // Catch: Exception -> L54
        L50:
            PolarisFileOutputStreamWrapper r27 = new PolarisFileOutputStreamWrapper(r25);     // Catch: Exception -> L54
            r20.compress(Bitmap.CompressFormat.JPEG, this.$params.getQuality(), r27);     // Catch: Throwable -> L56
            CloseableKt.closeFinally(r27, null);     // Catch: Exception -> L54
            r20.recycle();     // Catch: Exception -> L54
            String r28 = this.$fm.e(r25).a();     // Catch: Exception -> L54
            Intrinsics.checkNotNullParameter(AbsCompressImageMethodIDL.b.class, "<this>");     // Catch: Exception -> L54
            AbsCompressImageMethodIDL.b r29 = (AbsCompressImageMethodIDL.b) c.a(AbsCompressImageMethodIDL.b.class);     // Catch: Exception -> L54
            r29.setTempFilePath(r28);     // Catch: Exception -> L54
            g.a.i("AISDK_JSB_CompressImageMethod", "call success, outputSize=" + r25.length());     // Catch: Exception -> L54
            h.a.b(this.$callback, r29);     // Catch: Exception -> L54
        L74:
            return Unit.INSTANCE;
        L56:
            th = move-exception;
            throw th;     // Catch: Throwable -> L59
        L59:
            th = move-exception;
            CloseableKt.closeFinally(r27, th);     // Catch: Exception -> L54
            throw th;     // Catch: Exception -> L54
        L63:
            e = move-exception;
            g r30 = g.a;     // Catch: Exception -> L54
            StringBuilder r31 = new StringBuilder("call failed, errNo=");     // Catch: Exception -> L54
            f3.a r32 = f3.a.v;     // Catch: Exception -> L54
            r31.append(r32.a);     // Catch: Exception -> L54
            r31.append(", msg=");     // Catch: Exception -> L54
            r31.append(e.getMessage());     // Catch: Exception -> L54
            r30.e("AISDK_JSB_CompressImageMethod", r31.toString());     // Catch: Exception -> L54
            h<AbsCompressImageMethodIDL.b> r33 = this.$callback;     // Catch: Exception -> L54
            String r34 = e.getMessage();     // Catch: Exception -> L54
            if (r34 != null) goto L67;
            r34 = "invalid file path";
        L67:
            h.a.a(r33, r34, r32, null, 10);     // Catch: Exception -> L54
            return Unit.INSTANCE;
        L54:
            e = move-exception;
            g r35 = g.a;
            StringBuilder r36 = new StringBuilder("call failed, errNo=");
            f3.a r37 = f3.a.f;
            r36.append(r37.a);
            r36.append(", msg=");
            r36.append(e.getMessage());
            r35.e("AISDK_JSB_CompressImageMethod", r36.toString());
            h<AbsCompressImageMethodIDL.b> r38 = this.$callback;
            String r39 = e.getMessage();
            if (r39 != null) goto L72;
            r39 = "compress failed";
        L72:
            h.a.a(r38, r39, r37, null, 10);
            goto L74
        L76:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public CompressImageMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsCompressImageMethodIDL.a r13 = (AbsCompressImageMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r14 = g.a;
        r14.i("AISDK_JSB_CompressImageMethod", "call start, src length=" + r13.getSrc().length() + ", quality=" + r13.getQuality());
        if (StringsKt.isBlank(r13.getSrc()) == false) goto L5;
        StringBuilder r15 = new StringBuilder("call failed, errNo=");
        f3.a r0 = f3.a.h;
        r15.append(r0.a);
        r15.append(", msg=src is empty");
        r14.w("AISDK_JSB_CompressImageMethod", r15.toString());
        h.a.a(r12, "src cannot be empty", r0, null, 10);
        return;
    L5:
        AppletFileManager r16 = x3.a.d(r10);
        if (r16 != null) goto L8;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a r1 = f3.a.f;
        r17.append(r1.a);
        r17.append(", msg=file manager not available");
        r14.e("AISDK_JSB_CompressImageMethod", r17.toString());
        h.a.a(r12, "file manager not available", r1, null, 10);
        return;
    L8:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(r16, r13, r12, this, null), 3, null);
    }
}
