package rp0;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j extends vq0.a {
    public j(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r13) {
        if (r13 == null) goto L50;
        String r14 = r13.getString("current_page");
        int r1 = qo0.a.a;
        qo0.a.c("OnUpdateScreenPageEventListener", "anchor page: " + r14);
        AnchorCastContextService r2 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        if (r14 != null) goto L7;
        r14 = "";
    L7:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r14, "page");
        uq0.a r3 = r2.a;
        if (r3 != null) goto L51;
    L22:
        uq0.a r4 = r2.a;
        if (r4 == null) goto L50;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L26
        Object r15 = Result.constructor-impl(UriProtector.parse(r14));     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r15) == false) goto L31;
        r15 = null;
    L31:
        Uri r16 = (Uri) r15;
        if (r16 == null) goto L34;
        String r6 = r16.getQuery();
    L35:
        LinkedHashMap r17 = new LinkedHashMap();
        if (r6 == null) goto L49;
        List r7 = StringsKt.split$default(r6, new String[]{"&"}, false, 0, 6, null);
        if (r7 == null) goto L49;
        Iterator r8 = r7.iterator();
    L42:
        if (r8.hasNext() == false) goto L49;
        List r9 = StringsKt.split$default((String) r8.next(), new String[]{"="}, false, 0, 6, null);
        if (r9.size() != 2) goto L47;
        r17.put(ListProtector.get(r9, 0), ListProtector.get(r9, 1));
    L47:
        if (r9.size() != 1) goto L42;
        r17.put(ListProtector.get(r9, 0), "");
    L49:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r4.c = r17;
        goto L50
    L34:
        r6 = null;
    L26:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L51:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L11
        Object r12 = Result.constructor-impl(UriProtector.parse(r14));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r12) == false) goto L16;
        r12 = null;
    L16:
        Uri r18 = (Uri) r12;
        if (r18 == null) goto L20;
        String r19 = r18.getPath();
        if (r19 == null) goto L20;
    L21:
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r3.b = r19;
    L20:
        r19 = "";
    L11:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L50:
        return null;
    }
}
