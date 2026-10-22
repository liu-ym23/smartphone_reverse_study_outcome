package n9;

import android.content.Context;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Header f20215c;

    @Override // n9.c
    public final Object a(String r5) {
        if (this.f20215c != null) goto L6;
        Context r10 = n.f4057a;
        this.f20215c = Header.f();
    L6:
        return this.f20215c.f4029a.opt(r5);
    }
}
