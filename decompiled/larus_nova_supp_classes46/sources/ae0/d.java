package ae0;

import com.bytedance.android.livesdk.utils.ntp.e;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements a {
    public d() {
    }

    @Override // ae0.a
    public final ArrayList<IVoiceLiveTheme> a(ArrayList<IVoiceLiveTheme> r12) {
        Intrinsics.checkNotNullParameter(r12, "themes");
        long r0 = e.a() / ((long) 1000);
        ArrayList r2 = new ArrayList();
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L19;
        Object r3 = r13.next();
        IVoiceLiveTheme r4 = (IVoiceLiveTheme) r3;
        boolean r6 = true;
        if (r4.getTimeLimit() == 1) goto L8;
    L17:
        if (r6 == false) goto L4;
        r2.add(r3);
        goto L4
    L8:
        if (r4.getEndTime() > 0) goto L10;
    L16:
        r6 = false;
        goto L17
    L10:
        if (r4.getStartTime() >= r4.getEndTime()) goto L16;
        if (r0 < r4.getStartTime()) goto L16;
        if (r0 >= r4.getEndTime()) goto L16;
    L19:
        ArrayList<IVoiceLiveTheme> r14 = new ArrayList();
        r14.addAll(r2);
        return r14;
    }
}
