package com.ss.android.lark.chat.preview.service;

import com.bytedance.lark.pb.url.v1.PushUrlPreviews;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import h6b.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "push", "Lcom/bytedance/lark/pb/url/v1/PushUrlPreviews;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.preview.service.UrlSignPreviewsPush$addPushListener$1", f = "UrlSignPreviewsPush.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UrlSignPreviewsPush$addPushListener$1 extends SuspendLambda implements Function2<PushUrlPreviews, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UrlSignPreviewsPush this$0;

    public UrlSignPreviewsPush$addPushListener$1(UrlSignPreviewsPush r1, Continuation<? super UrlSignPreviewsPush$addPushListener$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        UrlSignPreviewsPush$addPushListener$1 r0 = new UrlSignPreviewsPush$addPushListener$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(PushUrlPreviews r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((PushUrlPreviews) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r6);
        List<UrlPreViewEntries> r7 = j6b.d.e((PushUrlPreviews) this.L$0);
        Iterator r0 = ((ArrayList) r7).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        UrlPreViewEntries r1 = (UrlPreViewEntries) r0.next();
        g r2 = g.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "urlPreViewEntries");
        Intrinsics.checkNotNullParameter("[URLPreview] UrlSignPreviewsPush", "tag");
        r2.a.getClass();
        k6b.a.c(r1, "[URLPreview] UrlSignPreviewsPush");
        goto L6
    L8:
        Iterator<d7b.a> r3 = this.this$0.a.iterator();
    L10:
        if (r3.hasNext() == false) goto L13;
        r3.next().onPushSignUrlPreview(r7);
        goto L10
    L13:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
