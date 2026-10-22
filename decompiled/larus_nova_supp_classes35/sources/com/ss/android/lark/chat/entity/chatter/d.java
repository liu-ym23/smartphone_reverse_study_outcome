package com.ss.android.lark.chat.entity.chatter;

import com.larksuite.component.ui.tag.LarkNameTag;
import com.larksuite.component.ui.tag.f;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    @Deprecated(message = "扩展方法在Java中调用可读性很差...", replaceWith = @ReplaceWith(expression = "TagInfo::apply", imports = {}))
    public static final void a(LarkNameTag.c r2, TagInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "tagInfo");
        int r0 = f.g;
        f.a r1 = new f.a();
        r1.b = r3.getType().getOrder();
        r1.d = r3.getText();
        r1.e = r3.getType().getTextColor();
        r1.g = r3.getType().getBgColor();
        r2.d(new f(r1), true);
    }
}
