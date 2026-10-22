package gx9;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tx9.o3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class l implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;
    public final /* synthetic */ Integer d;
    public final /* synthetic */ long e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ Long h;
    public final /* synthetic */ Long i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;

    public /* synthetic */ l(String r1, String r2, List r3, Integer r4, long r5, String r7, String r8, Long r9, Long r10, String r11, String r12, String r13) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
    }

    public final Object invoke(Object r24) {
        String r1 = this.a;
        String r2 = this.b;
        List r3 = this.c;
        Integer r4 = this.d;
        long r5 = this.e;
        String r12 = this.f;
        String r14 = this.g;
        Long r15 = this.h;
        Long r13 = this.i;
        String r11 = this.j;
        String r10 = this.k;
        String r9 = this.l;
        com.larus.bmhome.chat.trace.a r7 = (com.larus.bmhome.chat.trace.a) r24;
        Intrinsics.checkNotNullParameter(r7, "$this$withChatBaseData");
        int r8 = o.a;
        boolean r16 = true;
        String r17 = null;
        if (r1 != null) goto L5;
    L10:
        String r0 = null;
    L11:
        String r6 = r7.a;
        if (r6 != null) goto L14;
    L17:
        if (r16 == true) goto L20;
        r2 = r7.a;
    L20:
        if (r2 == null) goto L22;
        Long r18 = StringsKt.toLongOrNull(r2);
    L23:
        String r19 = r7.g;
        if (r19 == null) goto L26;
        Long r20 = StringsKt.toLongOrNull(r19);
    L27:
        if (r3 == null) goto L29;
        r17 = r3.toString();
    L29:
        if (r17 != null) goto L31;
        r17 = "";
    L31:
        Long r21 = r18;
        o3.e(r21, o.d(r5), r20, r7.j, r0, r12, r17, r14, r7.k, r15, r13, r11, String.valueOf(r4), r10, r9, 786529);
        return Unit.INSTANCE;
    L26:
        r20 = null;
        goto L27
    L22:
        r18 = null;
        goto L23
    L14:
        if (r6.length() == 0) goto L17;
        r16 = false;
        goto L17
    L5:
        if (StringsKt.contains(r1, "local-", true) == false) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L10;
        r0 = StringsKt.removeSuffix(r1, ":fake_message:1");
        goto L11
    }
}
