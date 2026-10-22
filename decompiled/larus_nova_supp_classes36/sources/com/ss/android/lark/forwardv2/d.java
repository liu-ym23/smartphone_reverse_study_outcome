package com.ss.android.lark.forwardv2;

import android.content.Context;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.forwardv2.dto.StickImage;
import com.ss.android.lark.forwardv2.impl.ForwardPickFragment;
import com.ss.android.lark.image.entity.LoadParams;
import kotlin.jvm.internal.Intrinsics;
import pl.droidsonroids.gif.GifImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements hib.d {
    public d() {
    }

    @Override // hib.d
    public final void a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatId");
    }

    @Override // hib.d
    public final void b(ForwardPickFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
    }

    @Override // hib.d
    public final void c(Context r2, GifImageView r3, StickImage r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "imageView");
        Intrinsics.checkNotNullParameter(r4, LoadParams.ImageFormat.IMAGE);
    }

    @Override // hib.d
    public final void f() {
    }

    @Override // hib.d
    public final void getEventParams() {
    }

    @Override // hib.d
    public final void getTargetType() {
    }

    @Override // hib.d
    public final void h(LKUIDialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
    }

    @Override // hib.d
    public final void isEnterSendEnabled() {
    }

    @Override // hib.d
    public final b d() {
        return new b();
    }

    @Override // hib.d
    public final a g() {
        return new a();
    }

    @Override // hib.d
    public final c getPassportDependency() {
        return new c();
    }

    @Override // hib.d
    public final void e(IGetDataCallback r2) {
        r2.onSuccess(0);
    }
}
