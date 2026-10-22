package z91;

import android.text.TextUtils;
import b30.c0;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.live.room.navi.userinfo_p.mvi.UserInfoDataSource;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import l81.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ UserInfoDataSource a;
    public final /* synthetic */ long b;

    public g(UserInfoDataSource r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r8) {
        c0 r9 = (c0) r8;
        Intrinsics.checkNotNullParameter(r9, "<name for destructuring parameter 0>");
        String r5 = r9.a;
        String r10 = r9.b;
        UserInfoDataSource r0 = this.a;
        long r3 = this.b;
        if (TextUtils.isEmpty(r10) == false) goto L5;
        r10 = "join_fans_club";
    L5:
        String r6 = r10;
        r0.getClass();
        INavigationProxyService r12 = (INavigationProxyService) jc1.k.f(INavigationProxyService.class);
        if (r12 == null) goto L11;
        r r1 = r12.getRoomMessageHelper();
        if (r1 == null) goto L12;
        r1.a(r0.h.getRoomContext(), r3, r5, r6);
        return;
    L12:
        return;
    }
}
