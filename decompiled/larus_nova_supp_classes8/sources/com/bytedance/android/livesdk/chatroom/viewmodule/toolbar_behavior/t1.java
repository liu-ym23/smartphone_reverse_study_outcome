package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.widget.ImageView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t1 implements com.bytedance.android.live.base.model.user.q {
    public final /* synthetic */ int a;
    public final /* synthetic */ PortraitToolbarMoreBehavior b;

    public final void a(List<com.bytedance.android.live.base.model.user.f> r5) {
        ArrayList r0 = (ArrayList) r5;
        if (r0.isEmpty() == false) goto L5;
    L7:
        this.b.M.setImageResource(2131253001);
    L8:
        this.b.Z = Observable.timer(this.a, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new s1(this), new g60.c());
        return;
    L5:
        if (r0.size() < 2) goto L7;
        ((com.bytedance.android.live.base.model.user.f) ListProtector.get(r5, 0)).getClass();
        ImageModel r1 = (ImageModel) com.bytedance.android.live.base.model.m.b(null, ImageModel.class);
        ((com.bytedance.android.live.base.model.user.f) ListProtector.get(r5, 1)).getClass();
        ImageModel r6 = (ImageModel) com.bytedance.android.live.base.model.m.b(null, ImageModel.class);
        ImageUtil.loadRoundImage((ImageView) this.b.p0.findViewById(2131363727), r1);
        ImageUtil.loadRoundImage((ImageView) this.b.p0.findViewById(2131363706), r6);
        this.b.M.setVisibility(8);
        this.b.p0.setVisibility(0);
        goto L8
    }

    public t1(PortraitToolbarMoreBehavior r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
