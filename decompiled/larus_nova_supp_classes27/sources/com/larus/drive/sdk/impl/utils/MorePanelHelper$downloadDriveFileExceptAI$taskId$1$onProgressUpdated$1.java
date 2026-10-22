package com.larus.drive.sdk.impl.utils;

import android.content.Context;
import android.os.Parcelable;
import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.MorePanelHelper$downloadDriveFileExceptAI$taskId$1$onProgressUpdated$1", f = "MorePanelHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MorePanelHelper$downloadDriveFileExceptAI$taskId$1$onProgressUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ DriveFileItem $file;
    int label;

    public MorePanelHelper$downloadDriveFileExceptAI$taskId$1$onProgressUpdated$1(DriveFileItem r1, Context r2, Continuation<? super MorePanelHelper$downloadDriveFileExceptAI$taskId$1$onProgressUpdated$1> r3) {
        this.$file = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MorePanelHelper$downloadDriveFileExceptAI$taskId$1$onProgressUpdated$1(this.$file, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        Lazy r4 = MorePanelHelper.a;
        List r5 = (List) MorePanelHelper.b.getValue();
        DriveFileItem r0 = this.$file;
        Parcelable.Creator<DriveFileItem> r1 = DriveFileItem.CREATOR;
        if (r5.contains(r0.d(true).toLowerCase(Locale.ROOT)) == false) goto L7;
        t19.s r6 = t19.s.a;
        Context r2 = this.$context;
        r6.getClass();
        t19.s.o(r2, 2131905398, false);
    L9:
        return Unit.INSTANCE;
    L7:
        t19.s r7 = t19.s.a;
        Context r8 = this.$context;
        r7.getClass();
        t19.s.o(r8, 2131905399, false);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
