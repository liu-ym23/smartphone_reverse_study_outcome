package com.ss.android.lark.flow.chat.mediapreview;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils;
import com.ss.android.lark.flow.photoeditor.FlowPhotoEditorActivity;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView$startPhotoEdit$1", f = "FlowLargeImageView.kt", i = {}, l = {491}, m = "invokeSuspend", n = {}, s = {})
public final class FlowLargeImageView$startPhotoEdit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Object $photoItem;
    int label;

    public FlowLargeImageView$startPhotoEdit$1(FragmentActivity r1, Object r2, Continuation<? super FlowLargeImageView$startPhotoEdit$1> r3) {
        this.$activity = r1;
        this.$photoItem = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FlowLargeImageView$startPhotoEdit$1(this.$activity, this.$photoItem, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r2 = "";
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L16:
        File r7 = (File) r6;
        if (r7 != null) goto L20;
        Log.e("FlowPreviewImageView", "startPhotoEdit, yunpan image no cache");
        return Unit.INSTANCE;
    L20:
        String r3 = com.ss.android.photoeditor.util.b.b(this.$activity);
        int r4 = FlowPhotoEditorActivity.b;
        FragmentActivity r5 = this.$activity;
        String r8 = r7.getAbsolutePath();
        Intrinsics.checkNotNull(r3);
        DocImageProperty r9 = ((ogb.a) this.$photoItem).a;
        if (r9 == null) goto L26;
        String r10 = r9.getToken();
        if (r10 == null) goto L26;
        r2 = r10;
    L26:
        FlowPhotoEditorActivity.a.b(r5, r8, r3, r2);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FlowYunPanFileUtils r11 = FlowYunPanFileUtils.a;
        FragmentActivity r12 = this.$activity;
        DocImageProperty r13 = ((ogb.a) this.$photoItem).a;
        if (r13 == null) goto L12;
        String r14 = r13.getToken();
        if (r14 == null) goto L12;
    L13:
        this.label = 1;
        r6 = r11.e(r12, r14, true, this);
        if (r6 != r0) goto L16;
        return r0;
    L12:
        r14 = "";
        goto L13
    }
}
