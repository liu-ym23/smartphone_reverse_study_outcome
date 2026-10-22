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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper$onGetAvatarBase64$1$base64Result$1", f = "MmEndWindowWebHelper.kt", i = {}, l = {664}, m = "invokeSuspend", n = {}, s = {})
public final class MmEndWindowWebHelper$onGetAvatarBase64$1$base64Result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ int $avatarSize;
    final /* synthetic */ MmGetAvatarBase64Param $getAvatarParam;
    int label;
    final /* synthetic */ MmEndWindowWebHelper this$0;

    public MmEndWindowWebHelper$onGetAvatarBase64$1$base64Result$1(MmGetAvatarBase64Param r1, MmEndWindowWebHelper r2, int r3, Continuation<? super MmEndWindowWebHelper$onGetAvatarBase64$1$base64Result$1> r4) {
        this.$getAvatarParam = r1;
        this.this$0 = r2;
        this.$avatarSize = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmEndWindowWebHelper$onGetAvatarBase64$1$base64Result$1(this.$getAvatarParam, this.this$0, this.$avatarSize, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        Bitmap r7 = (Bitmap) r6;
        if (r7 == null) goto L23;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();
        r7.compress(Bitmap.CompressFormat.PNG, 100, r2);     // Catch: Throwable -> L18
        String r8 = Base64.encodeToString(r2.toByteArray(), 2);     // Catch: Throwable -> L18
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L18
        r3.put("base64", r8);     // Catch: Throwable -> L18
        String r9 = r3.toString();     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r2, null);
        if (r9 == null) goto L23;
        return r9;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L23:
        return "";
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        String r10 = this.$getAvatarParam.getAvatarKey();
        String r4 = this.$getAvatarParam.getUserId();
        w r5 = this.this$0.e;
        int r11 = this.$avatarSize;
        this.label = 1;
        r6 = r5.c(r10, r4, r11, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
