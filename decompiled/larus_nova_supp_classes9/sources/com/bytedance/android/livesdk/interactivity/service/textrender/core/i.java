package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.graphics.drawable.Drawable;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface i {
    Drawable a(ITextPieceImage r1, float r2);

    void b(ITextPieceImage r1, float r2, Function1<? super Drawable, Unit> r3);

    boolean c(ITextPieceImage r1);
}
