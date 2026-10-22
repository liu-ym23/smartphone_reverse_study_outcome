package com.ss.android.lark.flow.chat.message.redpacket;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.ss.android.lark.flow.chat.databinding.FlowChatMessageV2BlockRedPacketContentBinding;
import com.ss.android.lark.image.api.SimpleTarget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends SimpleTarget<Drawable> {
    public final /* synthetic */ FlowRedPacketContentBlock a;
    public final /* synthetic */ FlowChatMessageV2BlockRedPacketContentBinding b;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r8) {
        Drawable r9 = (Drawable) r8;
        if ((r9 instanceof BitmapDrawable) == false) goto L7;
        Bitmap r2 = ((BitmapDrawable) r9).getBitmap();
        byte[] r3 = BitmapFactory.decodeResource(this.a.getContext().getResources(), 2131235350).getNinePatchChunk();
        this.b.c.setBackground(new NinePatchDrawable(this.a.getContext().getResources(), r2, r3, new Rect(), null));
        return;
    }

    public b(FlowRedPacketContentBlock r1, FlowChatMessageV2BlockRedPacketContentBinding r2) {
        this.a = r1;
        this.b = r2;
    }
}
