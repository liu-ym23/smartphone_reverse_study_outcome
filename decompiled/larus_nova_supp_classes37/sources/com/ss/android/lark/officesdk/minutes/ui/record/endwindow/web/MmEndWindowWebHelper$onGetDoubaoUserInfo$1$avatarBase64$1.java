package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import android.graphics.Bitmap;
import android.util.Base64;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper$onGetDoubaoUserInfo$1$avatarBase64$1", f = "MmEndWindowWebHelper.kt", i = {}, l = {719}, m = "invokeSuspend", n = {}, s = {})
public final class MmEndWindowWebHelper$onGetDoubaoUserInfo$1$avatarBase64$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $avatarKey;
    final /* synthetic */ MmGetDoubaoUserInfoParam $param;
    int label;
    final /* synthetic */ MmEndWindowWebHelper this$0;

    public MmEndWindowWebHelper$onGetDoubaoUserInfo$1$avatarBase64$1(String r1, MmEndWindowWebHelper r2, MmGetDoubaoUserInfoParam r3, Continuation<? super MmEndWindowWebHelper$onGetDoubaoUserInfo$1$avatarBase64$1> r4) {
        this.$avatarKey = r1;
        this.this$0 = r2;
        this.$param = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmEndWindowWebHelper$onGetDoubaoUserInfo$1$avatarBase64$1(this.$avatarKey, this.this$0, this.$param, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L20:
        Bitmap r8 = (Bitmap) r7;
        if (r8 == null) goto L33;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        r8.compress(Bitmap.CompressFormat.PNG, 100, r2);     // Catch: Throwable -> L28
        String r9 = Base64.encodeToString(r2.toByteArray(), 2);     // Catch: Throwable -> L28
        CloseableKt.closeFinally(r2, null);
        if (r9 != null) goto L38;
        return "";
    L38:
        return r9;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L33:
        return "";
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        String r10 = this.$avatarKey;
        if (r10 != null) goto L11;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == true) goto L39;
        w r12 = this.this$0.e;
        String r3 = this.$avatarKey;
        String r4 = this.$param.getUserId();
        int r5 = this.this$0.j;
        this.label = 1;
        r7 = r12.c(r3, r4, r5, this);
        if (r7 != r0) goto L20;
        return r0;
    L39:
        return "";
    L11:
        if (r10.length() == 0) goto L14;
        r11 = false;
        goto L15
    }
}
