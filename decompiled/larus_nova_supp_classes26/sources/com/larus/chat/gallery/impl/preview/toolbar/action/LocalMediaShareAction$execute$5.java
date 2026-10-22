package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.i1;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.gallery.api.GalleryType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.LocalMediaShareAction$execute$5", f = "LocalMediaShareAction.kt", i = {0}, l = {35}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class LocalMediaShareAction$execute$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ l0 $context;
    final /* synthetic */ xy8.d $data;
    private /* synthetic */ Object L$0;
    int label;

    public LocalMediaShareAction$execute$5(l0 r1, xy8.d r2, Continuation<? super LocalMediaShareAction$execute$5> r3) {
        this.$context = r1;
        this.$data = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        LocalMediaShareAction$execute$5 r0 = new LocalMediaShareAction$execute$5(this.$context, this.$data, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
    L63:
        Uri r12 = (Uri) r11;
        if (r12 != null) goto L67;
        t19.s r13 = t19.s.a;
        Context r3 = this.$context.getContext();
        r13.getClass();
        t19.s.b(r3, 2131909342, false);
        return Unit.INSTANCE;
    L67:
        xy8.d r4 = this.$data;
        l0 r5 = this.$context;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L74
        if (r4.e != GalleryType.Video) goto L71;
        String r7 = "video/*";
    L72:
        Intent r8 = new Intent("android.intent.action.SEND");     // Catch: Throwable -> L74
        r8.setType(r7);     // Catch: Throwable -> L74
        r8.putExtra("android.intent.extra.STREAM", r12);     // Catch: Throwable -> L74
        r8.addFlags(1);     // Catch: Throwable -> L74
        r8.addFlags(268435456);     // Catch: Throwable -> L74
        Context r9 = r5.getContext();     // Catch: Throwable -> L74
        Intent r10 = Intent.createChooser(r8, null);     // Catch: Throwable -> L74
        r10.addFlags(268435456);     // Catch: Throwable -> L74
        r9.startActivity(r10);     // Catch: Throwable -> L74
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L74
    L76:
        l0 r15 = this.$context;
        Throwable r16 = Result.exceptionOrNull-impl(r14);
        if (r16 == null) goto L80;
        FLogger.a.e("LocalMediaShareAction", "local media share failed", r16);
        t19.s r17 = t19.s.a;
        Context r18 = r15.getContext();
        r17.getClass();
        t19.s.b(r18, 2131909342, false);
    L80:
        return Unit.INSTANCE;
    L71:
        r7 = "image/*";
    L74:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L76
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        r r20 = r.a;
        Context r21 = this.$context.getContext();
        xy8.d r22 = this.$data;
        this.L$0 = r110;
        this.label = 1;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r22, "data");
        xy8.c r111 = r22.p;
        if (r111 != null) goto L11;
        r11 = null;
    L61:
        if (r11 != r0) goto L63;
        return r0;
    L11:
        String r23 = r111.c;
        if (r23 != null) goto L15;
        r23 = r.a(r111.b);
    L15:
        if (r23 != null) goto L17;
    L30:
        Uri r24 = null;
    L31:
        if (r24 == null) goto L58;
        boolean r25 = Intrinsics.areEqual(r24.getScheme(), "content");
        Object r26 = r24;
        if (r25 == true) goto L60;
        String r27 = r24.getScheme();
        if (r27 != null) goto L39;
    L44:
        String r28 = r24.toString();
        Intrinsics.checkNotNull(r28);
        if (StringsKt.startsWith$default(r28, "/", false, 2, null) == false) goto L47;
        String r112 = r28;
    L48:
        if (r112 == null) goto L58;
        if (StringsKt.isBlank(r112) == true) goto L58;
        Uri r29 = i1.c(r21, new PolarisFileWrapper(r112));
        r26 = r29;
        if (r29 != null) goto L60;
        if (new PolarisFileWrapper(r112).exists() == false) goto L58;
        r26 = ImageSave.l(ImageSave.a, r21, r112, new PolarisFileWrapper(r112).getName(), this);
        goto L60
    L47:
        r112 = null;
        goto L48
    L39:
        if (r27.hashCode() != 3143036) goto L44;
        if (r27.equals(ShareType.FILE) == false) goto L44;
        r112 = r24.getPath();
    L60:
        r11 = r26;
    L58:
        r26 = null;
        goto L60
    L17:
        if ((!StringsKt.isBlank(r23)) == true) goto L20;
        r23 = null;
    L20:
        if (r23 == null) goto L30;
        if (StringsKt.startsWith$default(r23, "/", false, 2, null) == false) goto L26;
        r24 = Uri.fromFile(new PolarisFileWrapper(r23));
        goto L31
    L26:
        if (StringsKt.startsWith$default(r23, "file://", false, 2, null) == false) goto L28;
    L29:
        r24 = UriProtector.parse(r23);
        goto L31
    L28:
        if (StringsKt.startsWith$default(r23, "content://", false, 2, null) == false) goto L30;
        goto L29
    }
}
