package id;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import b3.m;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends m {
    @Override // b3.m
    public final long d(String r10) {
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        long r5 = super.d(r10);
        if (r5 >= 0) goto L6;
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("get negative duration: " + r10 + ' ' + r5, LogLevel.f5955c, "Monitor-Timeline");
        return 0;
    L6:
        return r5;
    }
}
