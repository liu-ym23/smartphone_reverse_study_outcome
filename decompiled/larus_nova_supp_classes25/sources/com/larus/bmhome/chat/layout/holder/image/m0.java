package com.larus.bmhome.chat.layout.holder.image;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.kmp.chat.TemplateInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 {
    public final Message a;
    public final ImageItem b;
    public final TemplateInfo.TemplateInfo c;
    public final boolean d;
    public final String e;

    public m0(Message r2, ImageItem r3, TemplateInfo.TemplateInfo r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "imageItem");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
