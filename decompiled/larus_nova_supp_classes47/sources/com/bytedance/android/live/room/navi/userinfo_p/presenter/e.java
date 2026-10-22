package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import u32.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements u32.d.a {
    public final /* synthetic */ UserInfoTabPresenter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ n c;

    public final View b() {
        return null;
    }

    public final List<Pair<String, String>> d() {
        return null;
    }

    public final View g() {
        return null;
    }

    public final View a() {
        ViewGroup r0 = this.a.k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0;
    }

    public final View f() {
        if (this.a.g() == false) goto L7;
        return null;
    L7:
        return this.a.k;
    }

    public final String c() {
        return this.b;
    }

    public final n e() {
        return this.c;
    }

    public final void setContentDescription(String r4) {
        Intrinsics.checkNotNullParameter(r4, "contentDescription");
        IRoom r0 = this.a.e.getRoom();
        if (r0 == null) goto L8;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L8;
        String r2 = r1.getNickName();
        if (r2 == null) goto L8;
    L9:
        this.a.getClass();
        UserInfoTabPresenter.x(r2 + r4);
        return;
    L8:
        r2 = "";
        goto L9
    }

    public e(UserInfoTabPresenter r1, String r2, d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
