package com.larus.bmhome.instruction.handler;

import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.bmhome.utils.q1;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.uaigc.service.ICreationWorkflowService;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0001\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.handler.PromptImageToVideoHandler$getInstructionDefaultParams$2", f = "PromptImageToVideoHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PromptImageToVideoHandler$getInstructionDefaultParams$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends Map<String, ? extends Map<String, ? extends String>>>>, Object> {
    final /* synthetic */ Image $image;
    final /* synthetic */ com.larus.bmhome.actionbar.model.r $instructionConf;
    private /* synthetic */ Object L$0;
    int label;

    public PromptImageToVideoHandler$getInstructionDefaultParams$2(com.larus.bmhome.actionbar.model.r r1, Image r2, Continuation<? super PromptImageToVideoHandler$getInstructionDefaultParams$2> r3) {
        this.$instructionConf = r1;
        this.$image = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        PromptImageToVideoHandler$getInstructionDefaultParams$2 r0 = new PromptImageToVideoHandler$getInstructionDefaultParams$2(this.$instructionConf, this.$image, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, ? extends Map<String, ? extends Map<String, String>>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L97;
        ResultKt.throwOnFailure(r9);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        hy9.c r11 = ICreationWorkflowService.a.F();
        com.larus.bmhome.actionbar.model.r r0 = this.$instructionConf;
        Image r1 = this.$image;
        int r3 = 0;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L59
        List r2 = r0.b;     // Catch: Throwable -> L59
        if (r2 == null) goto L56;
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L59
    L9:
        if (r4.hasNext() == false) goto L19;
        Object r6 = r4.next();     // Catch: Throwable -> L59
        Integer r7 = ((com.larus.bmhome.actionbar.model.u) r6).b;     // Catch: Throwable -> L59
        if (r7 != null) goto L14;
    L16:
        boolean r8 = false;
    L17:
        if (r8 == false) goto L9;
    L20:
        com.larus.bmhome.actionbar.model.u r12 = (com.larus.bmhome.actionbar.model.u) r6;     // Catch: Throwable -> L59
        if (r12 == null) goto L56;
        String r13 = r12.d;     // Catch: Throwable -> L59
        if (r13 == null) goto L56;
        com.larus.bmhome.actionbar.model.b0 r14 = (com.larus.bmhome.actionbar.model.b0) xt7.d.b.c(com.larus.bmhome.actionbar.model.b0.Companion.serializer(), r13);     // Catch: Throwable -> L59
        if (r14 == null) goto L56;
        List r15 = r14.a;     // Catch: Throwable -> L59
        if (r15 == null) goto L56;
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L59
    L30:
        if (r16.hasNext() == false) goto L37;
        Object r17 = r16.next();     // Catch: Throwable -> L59
        if (((com.larus.bmhome.actionbar.model.c0) r17).b != 3) goto L34;
        boolean r18 = true;
    L35:
        if (r18 == false) goto L30;
    L38:
        com.larus.bmhome.actionbar.model.c0 r19 = (com.larus.bmhome.actionbar.model.c0) r17;     // Catch: Throwable -> L59
        if (r19 == null) goto L56;
        String r20 = r19.c;     // Catch: Throwable -> L59
        if (r20 == null) goto L56;
        com.larus.bmhome.actionbar.model.h r21 = (com.larus.bmhome.actionbar.model.h) xt7.d.b.c(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r20);     // Catch: Throwable -> L59
        if (r21 == null) goto L56;
        Integer r22 = r21.b;     // Catch: Throwable -> L59
        if (r22 != null) goto L48;
    L50:
        boolean r23 = false;
    L51:
        if (r23 == true) goto L54;
        r21 = null;
    L54:
        if (r21 == null) goto L56;
        List r24 = r21.e;     // Catch: Throwable -> L59
    L57:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r25) == false) goto L64;
        r25 = null;
    L64:
        List r26 = (List) r25;
        if (r26 != null) goto L67;
        r26 = CollectionsKt.emptyList();
    L67:
        r11.a(r26);
        ImageObj r27 = r1.imageOri;     // Catch: Throwable -> L87
        if (r27 == null) goto L71;
        int r28 = r27.width;     // Catch: Throwable -> L87
    L72:
        if (r27 == null) goto L74;
        r3 = r27.height;     // Catch: Throwable -> L87
    L74:
        if (r28 <= 0) goto L77;
        if (r3 <= 0) goto L77;
        Long r29 = r11.b(((double) r28) / ((double) r3));     // Catch: Throwable -> L87
    L85:
        Object r30 = Result.constructor-impl(r29);     // Catch: Throwable -> L87
    L90:
        if (Result.isFailure-impl(r30) == false) goto L92;
        r30 = null;
    L92:
        Long r31 = (Long) r30;
        if (r31 != null) goto L95;
        return null;
    L95:
        return MapsKt.mapOf(TuplesKt.to("2", MapsKt.mapOf(TuplesKt.to("match_all_id", MapsKt.mapOf(TuplesKt.to("default_select_id", String.valueOf(r31.longValue())))))));
    L77:
        Uri r32 = UriProtector.parse(r1.localResPath);     // Catch: Throwable -> L87
        InputStream r33 = ContentResolverWrapper.openInputStream(AppHost.a.getApplication().getContentResolver(), r32);     // Catch: Throwable -> L87
        BitmapFactory.Options r34 = new BitmapFactory.Options();     // Catch: Throwable -> L87
        r34.inJustDecodeBounds = true;     // Catch: Throwable -> L87
        BitmapFactory.decodeStream(r33, null, r34);     // Catch: Throwable -> L87
        if (r33 == null) goto L80;
        r33.close();     // Catch: Throwable -> L87
    L80:
        q1 r35 = q1.a;     // Catch: Throwable -> L87
        Intrinsics.checkNotNull(r32);     // Catch: Throwable -> L87
        r35.getClass();     // Catch: Throwable -> L87
        if (q1.g(r32) == false) goto L83;
        double r36 = r34.outHeight;     // Catch: Throwable -> L87
        int r37 = r34.outWidth;     // Catch: Throwable -> L87
    L84:
        r29 = r11.b(r36 / ((double) r37));     // Catch: Throwable -> L87
        goto L85
    L83:
        r36 = r34.outWidth;     // Catch: Throwable -> L87
        r37 = r34.outHeight;     // Catch: Throwable -> L87
        goto L84
    L71:
        r28 = 0;
    L87:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L90
    L48:
        if (r22.intValue() != 1) goto L50;
        r23 = true;
        goto L51
    L34:
        r18 = false;
        goto L35
    L37:
        r17 = null;
        goto L38
    L14:
        if (r7.intValue() != 8) goto L16;
        r8 = true;
        goto L17
    L19:
        r6 = null;
    L56:
        r24 = null;
    L59:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L97:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
