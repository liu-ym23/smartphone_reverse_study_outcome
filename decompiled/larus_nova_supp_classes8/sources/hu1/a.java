package hu1;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.android.livesdk.dsl.util.c;
import java.util.Map;
import yt1.h;
import yt1.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements h {

    /* JADX INFO: renamed from: hu1.a$a, reason: collision with other inner class name */
    public static final class C0390a {
    }

    static {
    }

    public a() {
    }

    @Override // yt1.h
    public final String a() {
        return null;
    }

    @Override // yt1.h
    public final DSLActionEnum getName() {
        return DSLActionEnum.LiveToast;
    }

    @Override // yt1.h
    public final void b(Map r1, j r2) {
        String r3 = c.d(r1, "toast");
        if (r3 == null) goto L6;
        f2.c(r3, 0);
        return;
    }
}
