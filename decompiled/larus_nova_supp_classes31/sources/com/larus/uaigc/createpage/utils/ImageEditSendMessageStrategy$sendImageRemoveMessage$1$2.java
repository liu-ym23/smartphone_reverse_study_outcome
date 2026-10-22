package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.uaigc.bean.remove.ImageEditDataWithMask;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2", f = "ImageEditSendMessageStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Map<String, String>> $extra;
    final /* synthetic */ ImageEditDataWithMask $imageEditDataWithMask;
    final /* synthetic */ String $sendImgPath;
    final /* synthetic */ hy9.f $this_run;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImageEditSendMessageStrategy this$0;

    public ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2(ImageEditDataWithMask r1, String r2, Ref.ObjectRef<Map<String, String>> r3, ImageEditSendMessageStrategy r4, hy9.f r5, Continuation<? super ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2> r6) {
        this.$imageEditDataWithMask = r1;
        this.$sendImgPath = r2;
        this.$extra = r3;
        this.this$0 = r4;
        this.$this_run = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2 r7 = new ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2(this.$imageEditDataWithMask, this.$sendImgPath, this.$extra, this.this$0, this.$this_run, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r44) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r44);
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        Deferred r8 = null;
        final Deferred r14 = BuildersKt.async$default(r1, null, null, new ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2$uploadMaskJob$1(this.$this_run, this.$imageEditDataWithMask, this.this$0, null), 3, null);
        String r2 = this.$imageEditDataWithMask.getOriImgUri();
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        r8 = BuildersKt.async$default(r1, null, null, new ImageEditSendMessageStrategy$sendImageRemoveMessage$1$2$uploadOriginalJob$1(this.$this_run, this.$imageEditDataWithMask, this.this$0, null), 3, null);
    L13:
        final Deferred r12 = r8;
        ai8.e r4 = new ai8.e(this.$sendImgPath, null, null, null, null, null, null, null, (Map) this.$extra.element, null, false, this.this$0.h(), null, null, 28158);
        ChatPageContext r5 = r4.m;
        ai8.h r6 = new ai8.h(this.$this_run.d, null, null, null, (Map) this.$extra.element, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_mock_text", "1")}), false, false, r5, null, 718);
        u1 r7 = RepoDispatcherDelegate.b.e().u1();
        final hy9.f r10 = this.$this_run;
        String r9 = r10.c;
        final String r11 = this.$sendImgPath;
        final ImageEditDataWithMask r13 = this.$imageEditDataWithMask;
        final Ref.ObjectRef<Map<String, String>> r15 = this.$extra;
        final ImageEditSendMessageStrategy r16 = this.this$0;
        r7.j(r9, r4, r6, new i(r10, r11, r12, r13, r14, r15, r16));
        return Unit.INSTANCE;
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
        goto L11
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
