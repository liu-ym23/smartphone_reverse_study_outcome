package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.FirstMessagePaddingType;
import com.ss.android.lark.biz.im.api.x0;
import com.ss.android.lark.im.base.page.BasePageFragment;
import g3b.v;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t6b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageListSpecPresets {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(MessageListSpecPresets$coreChat$2.INSTANCE);
    }

    public static o a(FragmentActivity r4, BasePageFragment r5, fxa.b r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r4, "hostActivity");
        Intrinsics.checkNotNullParameter(r5, "hostFragment");
        Intrinsics.checkNotNullParameter(r6, "chatBundle");
        x0.a r3 = new x0.a();
        Intrinsics.checkNotNullParameter(r4, "hostActivity");
        r3.a = r4;
        Intrinsics.checkNotNullParameter(r5, "hostFragment");
        r3.b = r5;
        Intrinsics.checkNotNullParameter(r6, "chatBundle");
        r3.c = r6;
        r3.f = true;
        r3.g = -8193;
        r3.h = -1132462081;
        FirstMessagePaddingType r8 = FirstMessagePaddingType.TITLE_AND_TAB;
        Intrinsics.checkNotNullParameter(r8, "value");
        r3.j = r8;
        Map r9 = MapsKt.mutableMapOf(new Pair[]{new Pair(v.class, new v(new v.a()))});
        Intrinsics.checkNotNullParameter(r9, "params");
        r3.i = r9;
        r3.t = true;
        List r10 = exa.a.a;
        Intrinsics.checkNotNullParameter(r10, "list");
        r3.s = r10;
        if (r7 == null) goto L9;
        x0.a r11 = (x0.a) r7.invoke(r3);
        if (r11 == null) goto L9;
        r3 = r11;
    L9:
        return MessageListFeatureSpecCompatKt.a(new x0(r3));
    }
}
