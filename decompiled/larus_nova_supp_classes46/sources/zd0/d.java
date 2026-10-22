package zd0;

import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements yd0.a {
    public d() {
    }

    @Override // yd0.a
    public final boolean a(wd0.b r5) {
        Intrinsics.checkNotNullParameter(r5, "renderContext");
        HamletAvatarContext r0 = HamletAvatarContext.Companion.getContext();
        if (r0 == null) goto L9;
        m<Boolean> r1 = r0.isStreamRending();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return false;
    L9:
        Integer r2 = r5.d;
        if (r2 != null) goto L13;
    L17:
        return true;
    L13:
        if (r2.intValue() != 28) goto L17;
        if (Intrinsics.areEqual(r5.e, Boolean.TRUE) == false) goto L17;
        return false;
    }
}
