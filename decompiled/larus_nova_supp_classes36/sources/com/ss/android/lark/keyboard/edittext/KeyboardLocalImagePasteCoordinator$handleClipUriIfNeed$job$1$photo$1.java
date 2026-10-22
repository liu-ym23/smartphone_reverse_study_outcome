package com.ss.android.lark.keyboard.edittext;

import android.database.Cursor;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/photopicker/entity/Photo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext.KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1$photo$1", f = "KeyboardLocalImagePasteCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1$photo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Photo>, Object> {
    final /* synthetic */ Cursor $cursor;
    int label;
    final /* synthetic */ d this$0;

    public KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1$photo$1(d r1, Cursor r2, Continuation<? super KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1$photo$1> r3) {
        this.this$0 = r1;
        this.$cursor = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1$photo$1(this.this$0, this.$cursor, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Photo> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r15);
        Log.i("KeyboardLocalImagePasteCoordinator", "query image, start");
        d r16 = this.this$0;
        Cursor r1 = this.$cursor;
        int r2 = d.d;
        r16.getClass();
        r1.moveToFirst();     // Catch: Exception -> L22
    L7:
        if (r1.isClosed() == true) goto L24;
        int r3 = r1.getInt(r1.getColumnIndexOrThrow("_id"));     // Catch: Exception -> L22
        String r17 = r1.getString(r1.getColumnIndexOrThrow("_data"));     // Catch: Exception -> L22
        String r12 = r1.getString(r1.getColumnIndexOrThrow("mime_type"));     // Catch: Exception -> L22
        if (com.ss.android.lark.widget.photopicker.filter.a.a(r17, r12) == true) goto L10;
        Photo r13 = new Photo(r3, r17, r12, 0, r1.getInt(r1.getColumnIndexOrThrow("width")), r1.getInt(r1.getColumnIndexOrThrow("height")), r1.getLong(r1.getColumnIndexOrThrow("_size")));     // Catch: Exception -> L22
        String r4 = r13.getPath();     // Catch: Exception -> L22
        if (r4 != null) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        r1.moveToNext();     // Catch: Exception -> L22
        goto L7
    L20:
        r13.isAnimatedImage = com.ss.android.lark.widget.utils.d.b(r17, r12);     // Catch: Exception -> L22
        return r13;
    L14:
        if (r4.length() == 0) goto L17;
        r5 = false;
        goto L18
    L10:
        r1.moveToNext();     // Catch: Exception -> L22
    L24:
        return null;
    L22:
        e = move-exception;
        Log.e("KeyboardLocalImagePasteCoordinator", "loading media data error: " + e.getMessage());
        goto L24
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
