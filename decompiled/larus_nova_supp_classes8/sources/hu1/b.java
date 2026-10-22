package hu1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.android.livesdk.dsl.util.c;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yt1.h;
import yt1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements h {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // yt1.h
    public final String a() {
        return null;
    }

    @Override // yt1.h
    public final DSLActionEnum getName() {
        return DSLActionEnum.LiveLocalALogger;
    }

    @Override // yt1.h
    public final void b(Map r6, j r7) {
        String r0 = c.d(r6, "tag");
        if (r0 == null) goto L19;
        StringBuilder r1 = new StringBuilder();
        if (r6 == null) goto L12;
        Iterator r8 = r6.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) r8.next();
        if ((!Intrinsics.areEqual((String) r2.getKey(), "tag")) == false) goto L8;
        r1.append(((String) r2.getKey()) + "=" + String.valueOf(r2.getValue()));
        r1.append(",");
    L12:
        ALogger.i(r0, r1.toString());
        return;
    }
}
