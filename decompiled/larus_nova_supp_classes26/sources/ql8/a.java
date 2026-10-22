package ql8;

import bc8.b;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final com.larus.bmhome.chat.standarduikit.imagegroup.view.a a;
    public final com.larus.bmhome.chat.markdown.imagegroup.a b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final Object g;
    public final Integer h;
    public final Function0<Map<String, Object>> i;
    public final b j;
    public final Boolean k;
    public final Function1<Integer, Unit> l;

    public final Message a() {
        Object r0 = this.g;
        if ((r0 instanceof Message) == true) goto L7;
        return null;
    L7:
        return (Message) r0;
    }

    public /* synthetic */ a(com.larus.bmhome.chat.standarduikit.imagegroup.view.a r16, int r17) {
        if ((r17 & 1) == 0) goto L5;
        com.larus.bmhome.chat.standarduikit.imagegroup.view.a r3 = new com.larus.bmhome.chat.standarduikit.imagegroup.view.a(0);
    L7:
        if ((r17 & 2) == 0) goto L9;
        com.larus.bmhome.chat.markdown.imagegroup.a r4 = new com.larus.bmhome.chat.markdown.imagegroup.a(null, null, null, null, 127);
    L10:
        this(r3, r4, null, null, null, null, null, null, null, null, null, null);
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = r16;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(com.larus.bmhome.chat.standarduikit.imagegroup.view.a r2, com.larus.bmhome.chat.markdown.imagegroup.a r3, String r4, String r5, String r6, String r7, Object r8, Integer r9, Function0<? extends Map<String, ? extends Object>> r10, b r11, Boolean r12, Function1<? super Integer, Unit> r13) {
        Intrinsics.checkNotNullParameter(r2, "sizeData");
        Intrinsics.checkNotNullParameter(r3, "imageGroupData");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }
}
