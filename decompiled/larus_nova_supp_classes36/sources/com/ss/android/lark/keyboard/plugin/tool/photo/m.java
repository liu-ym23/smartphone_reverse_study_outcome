package com.ss.android.lark.keyboard.plugin.tool.photo;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.keyboard.dtocompat.Image;
import com.ss.android.lark.todo.impl.features.detail.comment.CommentKeyboardSection;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m extends com.ss.android.lark.utils.rxjava.d<Image> {
    public final /* synthetic */ PhotoKBPlugin$IOnUploadPhotoAPI$IUploadCallback a;
    public final /* synthetic */ PhotoKBPlugin b;

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onComplete() {
        this.a.onFinish();
    }

    public final void a(Throwable r5) {
        boolean r0 = r5 instanceof ErrorResult;
        if (r0 == false) goto L26;
        ErrorResult r6 = (ErrorResult) r5;
        if (KeyboardPhotoModule.a().isHitStorageQuotaLimit(r6.getErrorCode()) == false) goto L8;
        return;
    L8:
        if (r6.getErrorCode() != this.b.l) goto L11;
        return;
    L11:
        if (r6.getErrorCode() != this.b.j) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L18;
        this.a.onError(r6);
        return;
    L18:
        if (r6.getErrorCode() != this.b.k) goto L20;
        return;
    L20:
        PhotoKBPlugin$IOnUploadPhotoAPI$IUploadCallback r2 = this.a;
        if (r0 == false) goto L23;
        String r7 = r6.getDisplayMsg();
    L24:
        r2.onError(new ErrorResult(r7));
        return;
    L23:
        r7 = r6.getMessage();
        goto L24
    L13:
        r1 = false;
        goto L14
    L26:
        PhotoKBPlugin r3 = this.b;
        int r4 = r3.j;
        r3.getClass();
        if (r5 == null) goto L39;
        if ((r5 instanceof CompositeException) == false) goto L39;
        Iterator r8 = ((CompositeException) r5).getExceptions().iterator();
    L32:
        if (r8.hasNext() == false) goto L39;
        Throwable r9 = (Throwable) r8.next();
        if ((r9 instanceof ErrorResult) == false) goto L32;
        ErrorResult r10 = (ErrorResult) r9;
        if (r10.getErrorCode() != r4) goto L32;
    L43:
        this.a.onError(r10);
        return;
    L39:
        if (r5 == null) goto L41;
        String r11 = r5.getMessage();
    L42:
        r10 = new ErrorResult(r11);
        goto L43
    L41:
        r11 = null;
        goto L42
    }

    public final void onNext(Object r2) {
        Image r3 = (Image) r2;
        Intrinsics.checkNotNullParameter(r3, "t");
        this.a.onSuccess(r3);
    }

    public m(CommentKeyboardSection.handleActivityResult.1 r1, PhotoKBPlugin r2) {
        this.a = r1;
        this.b = r2;
    }
}
