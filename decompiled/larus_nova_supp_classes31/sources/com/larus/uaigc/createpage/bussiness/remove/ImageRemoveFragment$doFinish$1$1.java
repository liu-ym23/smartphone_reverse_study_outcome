package com.larus.uaigc.createpage.bussiness.remove;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.larus.uaigc.impl.databinding.LarusFragmentImageRemoveBinding;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment$doFinish$1$1", f = "ImageRemoveFragment.kt", i = {0, 0, 2, 3, 4, 5}, l = {666, 676, 699, 702, 704, 707}, m = "invokeSuspend", n = {"resultData", "startTime", "startTime", "startTime", "startTime", "startTime"}, s = {"L$1", "J$0", "J$0", "J$0", "J$0", "J$0"})
final class ImageRemoveFragment$doFinish$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusFragmentImageRemoveBinding $this_run;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ImageRemoveFragment this$0;

    public ImageRemoveFragment$doFinish$1$1(LarusFragmentImageRemoveBinding r1, ImageRemoveFragment r2, Continuation<? super ImageRemoveFragment$doFinish$1$1> r3) {
        this.$this_run = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ImageRemoveFragment$doFinish$1$1 r0 = new ImageRemoveFragment$doFinish$1$1(this.$this_run, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r30) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r9 = false;
        switch(this.label) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L7;
            default: goto L5;
        };
    L6:
        long r2 = this.J$0;
        final ImageRemoveFragment r6 = (ImageRemoveFragment) this.L$0;
        ResultKt.throwOnFailure(r30);
        long r4 = r2;
        Object r3 = r30;
    L84:
        if (((Boolean) r3).booleanValue() == true) goto L86;
        this.L$0 = r6;
        this.J$0 = r4;
        this.label = 6;
        if (DelayKt.delay(500, this) == r1) goto L89;
    L77:
        long r5 = r4;
        ImageRemoveFragment r7 = r6;
    L90:
        r4 = r5;
        r6 = r7;
    L94:
        FragmentActivity r8 = r6.getActivity();
        if (r8 == null) goto L97;
        r8.finish();
    L97:
        FLogger.a.d("ImageRemoveFragment", "process bitmaps cost " + (System.currentTimeMillis() - r4) + "ms");
    L99:
        return Unit.INSTANCE;
    L89:
        return r1;
    L86:
        return Unit.INSTANCE;
    L7:
        r5 = this.J$0;
        r7 = (ImageRemoveFragment) this.L$0;
        ResultKt.throwOnFailure(r30);
        goto L90
    L8:
        long r10 = this.J$0;
        r6 = (ImageRemoveFragment) this.L$0;
        ResultKt.throwOnFailure(r30);
        r4 = r10;
        Object r11 = r30;
    L71:
        if (((Boolean) r11).booleanValue() == true) goto L73;
        this.L$0 = r6;
        this.J$0 = r4;
        this.label = 4;
        if (DelayKt.delay(500, this) != r1) goto L77;
        return r1;
    L73:
        return Unit.INSTANCE;
    L9:
        ImageRemoveFragment r12 = (ImageRemoveFragment) this.L$0;
        ResultKt.throwOnFailure(r30);
        Object r13 = r30;
    L52:
        if (((Boolean) r13).booleanValue() == true) goto L54;
        int r14 = ImageRemoveFragment.v;
        r12.ha0();
        return Unit.INSTANCE;
    L54:
        return Unit.INSTANCE;
    L10:
        long r15 = this.J$0;
        ImageEditDataWithMask r16 = (ImageEditDataWithMask) this.L$1;
        ImageRemoveFragment r17 = (ImageRemoveFragment) this.L$0;
        ResultKt.throwOnFailure(r30);
        r4 = r15;
        r6 = r17;
    L27:
        String r18 = r16.getSendMsgImgStoragePath();
        if (r18 != null) goto L30;
    L33:
        boolean r19 = true;
    L34:
        if (r19 == false) goto L37;
        t19.s r20 = t19.s.a;
        Context r21 = r6.getContext();
        r20.getClass();
        t19.s.s(r21, 2131908214);
        return Unit.INSTANCE;
    L37:
        Bundle r22 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("image_edit_data.with_mask", r16)});
        xy9.a r23 = r6.q;
        if (r23 == null) goto L41;
        r23.a(r22);
        return Unit.INSTANCE;
    L41:
        ImageRemoveFragment.ImageRemoveHostUiPolicy r24 = r6.aa0();
        CreationSendMessageConfig r25 = r6.t;
        if (r24.a == false) goto L45;
        if (r25 == null) goto L45;
        boolean r26 = true;
    L46:
        if (r26 == false) goto L57;
        this.L$0 = r6;
        this.L$1 = null;
        this.label = 2;
        r13 = ImageRemoveFragment.U90(r6, r22, this);
        if (r13 != r1) goto L50;
        return r1;
    L50:
        r12 = r6;
        goto L52
    L57:
        ImageRemoveFragment.ImageRemoveHostUiPolicy r27 = r6.aa0();
        if (r27.a == true) goto L60;
    L62:
        if (r9 == false) goto L66;
        r6.getParentFragmentManager().setFragmentResult("ai_creation_applet_image_remove_result", r22);
        ICreationWorkflowService.a.H(new r(r6));
        return Unit.INSTANCE;
    L66:
        if (o0.d(r6.m) == false) goto L79;
        JSONObject r28 = new JSONObject();
        r28.put("id", r6.m);
        Unit r29 = Unit.INSTANCE;
        r22.putParcelable("actionbar_instruction_message_ext_map", new ICoreInputAbility.MessageExtMap(MapsKt.mapOf(TuplesKt.to("creation_template", r28.toString()))));
        this.L$0 = r6;
        this.L$1 = null;
        this.J$0 = r4;
        this.label = 3;
        r11 = ImageRemoveFragment.U90(r6, r22, this);
        if (r11 != r1) goto L71;
        return r1;
    L79:
        if (r6.p == false) goto L91;
        this.L$0 = r6;
        this.L$1 = null;
        this.J$0 = r4;
        this.label = 5;
        r3 = ImageRemoveFragment.U90(r6, r22, this);
        if (r3 != r1) goto L84;
        return r1;
    L91:
        FragmentActivity r31 = r6.getActivity();
        if (r31 == null) goto L94;
        Intent r32 = new Intent();
        r32.putExtras(r22);
        Unit r33 = Unit.INSTANCE;
        r31.setResult(366, r32);
        goto L94
    L60:
        if (r27.b == false) goto L62;
        r9 = true;
    L45:
        r26 = false;
        goto L46
    L30:
        if (r18.length() == 0) goto L33;
        r19 = false;
        goto L34
    L11:
        ResultKt.throwOnFailure(r30);
        CoroutineScope r34 = (CoroutineScope) this.L$0;
        long r110 = System.currentTimeMillis();
        Bitmap r111 = this.$this_run.h.getViewBitmap();
        if (r111 == null) goto L99;
        LarusFragmentImageRemoveBinding r112 = this.$this_run;
        ImageRemoveFragment r113 = this.this$0;
        Pair<Bitmap, Bitmap> r114 = r112.h.getMaskBitmap();
        if (r114 == null) goto L99;
        Bitmap r35 = (Bitmap) r114.getFirst();
        if (r35 == null) goto L18;
        Bitmap r36 = (Bitmap) r114.getSecond();
        if (r36 == null) goto L22;
        FLogger.a.i("ImageRemoveFragment", "getMaskBitmap success, width: " + r36.getWidth() + ", height: " + r36.getHeight());
        ImageEditDataWithMask r37 = new ImageEditDataWithMask(null, null, null, null, null, null, 63, null);
        List r38 = CollectionsKt.listOf(new Deferred[]{BuildersKt.async$default(r34, null, null, new ImageRemoveFragment$doFinish$1$1$1$1$jobList$1(r35, r37, r111, null), 3, null), BuildersKt.async$default(r34, null, null, new ImageRemoveFragment$doFinish$1$1$1$1$jobList$2(r113, r36, r37, null), 3, null), BuildersKt.async$default(r34, null, null, new ImageRemoveFragment$doFinish$1$1$1$1$jobList$3(r113, r37, r111, null), 3, null)});
        this.L$0 = r113;
        this.L$1 = r37;
        r4 = r110;
        this.J$0 = r4;
        this.label = 1;
        if (AwaitKt.a(r38, this) != r1) goto L26;
        return r1;
    L26:
        r16 = r37;
        r6 = r113;
        goto L27
    L22:
        return Unit.INSTANCE;
    L18:
        return Unit.INSTANCE;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
