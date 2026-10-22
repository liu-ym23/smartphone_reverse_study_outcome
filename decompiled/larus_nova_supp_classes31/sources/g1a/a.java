package g1a;

import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.ugc.perf.impl.d;
import com.larus.ugc.perf.impl.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements d {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void c(e r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void h(e r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void a(e r8) {
        Intrinsics.checkNotNullParameter(r8, "source");
        Message r0 = r8.a;
        Integer r1 = null;
        if (r0 == null) goto L7;
        CreationMsgContentData r2 = dp8.e.c(r0);
        if (r2 == null) goto L7;
        CreationInfo r3 = r2.creationInfo;
    L8:
        long r4 = AppHost.a.getUpdateVersionCode();
        if (r3 == null) goto L15;
        String r5 = r3.supportVersion;
        if (r5 == null) goto L15;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 == null) goto L15;
        long r7 = r6.longValue();
    L17:
        if (r4 >= r7) goto L19;
        return;
    L19:
        if (r3 == null) goto L21;
        r1 = r3.layoutType;
    L21:
        if (r1 != null) goto L24;
    L25:
        if (r1 != null) goto L28;
        return;
    L28:
        if (r1.intValue() != 2) goto L31;
    L29:
        com.larus.ugc.perf.impl.genimg.d.d.a(r8);
        return;
    L31:
        return;
    L24:
        if (r1.intValue() == 1) goto L29;
    L15:
        r7 = -1;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.larus.ugc.perf.impl.d
    public final void d(e r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Message r1 = r5.a;
        if (r1 == null) goto L9;
        CreationMsgContentData r2 = dp8.e.c(r1);
        if (r2 == null) goto L9;
        CreationInfo r3 = r2.creationInfo;
        if (r3 == null) goto L9;
        Integer r4 = r3.layoutType;
    L10:
        if (r4 != null) goto L13;
    L14:
        if (r4 != null) goto L17;
        return;
    L17:
        if (r4.intValue() != 2) goto L20;
    L18:
        com.larus.ugc.perf.impl.genimg.d.d.getClass();
        Intrinsics.checkNotNullParameter(r5, "source");
        return;
    L20:
        return;
    L13:
        if (r4.intValue() == 1) goto L18;
    L9:
        r4 = null;
        goto L10
    }
}
