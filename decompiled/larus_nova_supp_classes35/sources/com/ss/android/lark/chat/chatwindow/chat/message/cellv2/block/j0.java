package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.entity.ListenerParams;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j0 implements ListenerParams.b {
    public final /* synthetic */ StickerContentBlock.b a;
    public final /* synthetic */ boolean b;

    public final void a(Exception r1) {
    }

    public j0(StickerContentBlock.b r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(Object r1, Object r2, DataSource r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "dataSource");
        Object r5 = this.a.f.getTag();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r6 = ((Boolean) r5).booleanValue();
        if (this.b == false) goto L8;
        if (r6 == false) goto L8;
        this.a.f.setText(UIHelper.getString(2131891116));
        this.a.f.setVisibility(0);
        return;
    L8:
        if ((r1 instanceof GifDrawable) == true) goto L10;
        this.a.g.setVisibility(8);
        return;
    L10:
        if (((GifDrawable) r1).isOverLimit() == false) goto L12;
        this.a.g.setVisibility(0);
        return;
    L12:
        this.a.g.setVisibility(8);
    }
}
