package com.larus.drive.sdk.impl.gallery;

import android.content.Context;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.chat.gallery.api.y;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.utils.MorePanelHelper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.DriveGalleryHelper$DrivePreviewMediaSession$performSourceAction$1", f = "DriveGalleryHelper.kt", i = {}, l = {500}, m = "invokeSuspend", n = {}, s = {})
final class DriveGalleryHelper$DrivePreviewMediaSession$performSourceAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DriveFileItem $file;
    final /* synthetic */ Function1<y, Unit> $onResult;
    int label;
    final /* synthetic */ DriveGalleryHelper.DrivePreviewMediaSession this$0;

    public DriveGalleryHelper$DrivePreviewMediaSession$performSourceAction$1(DriveFileItem r1, DriveGalleryHelper.DrivePreviewMediaSession r2, Function1<? super y, Unit> r3, Continuation<? super DriveGalleryHelper$DrivePreviewMediaSession$performSourceAction$1> r4) {
        this.$file = r1;
        this.this$0 = r2;
        this.$onResult = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DriveGalleryHelper$DrivePreviewMediaSession$performSourceAction$1(this.$file, this.this$0, this.$onResult, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r44) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r44);
        Object r3 = r44;
    L12:
        if (((Boolean) r3).booleanValue() == true) goto L15;
        s r4 = s.a;
        Context r5 = this.this$0.c.getContext();
        r4.getClass();
        s.s(r5, 2131905370);
        this.$onResult.invoke(y.c.a);
        return Unit.INSTANCE;
    L15:
        Lazy r6 = MorePanelHelper.a;
        MorePanelHelper.e(new l0(AbsDriveListViewModel.MENU_ID_SHARE, 0, "", null, null, null, null, null, null, false, false, null, Boxing.boxInt(0), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127), this.$file, this.this$0.c.getContext(), this.this$0.c.c, null, 48);
        this.$onResult.invoke(y.a.a);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r44);
        e89.c r7 = DriveGalleryHelper.e;
        DriveFileItem r8 = this.$file;
        String r9 = r8.b;
        int r10 = r8.d;
        this.label = 1;
        r3 = r7.n(r9, r10, this);
        if (r3 != r1) goto L12;
        return r1;
    }
}
