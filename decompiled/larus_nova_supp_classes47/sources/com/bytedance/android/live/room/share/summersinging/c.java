package com.bytedance.android.live.room.share.summersinging;

import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements Runnable {
    public final /* synthetic */ GroupPhotoDialogFragment a;

    public c(GroupPhotoDialogFragment r1) {
        this.a = r1;
    }

    public final void a() {
        com.bytedance.android.live.base.model.data.f.a r0 = GroupPhotoDialogFragment.q;
        List r1 = this.a.n.locationList;
        if (r1 == null) goto L7;
        List r2 = r1;
        if ((!r2.isEmpty()) == false) goto L7;
        r0 = (com.bytedance.android.live.base.model.data.f.a) CollectionsKt.random(r2, Random.Default);
    L7:
        ALogger.i("GroupPhotoDialogFragment", "offsetXY: " + r0);
        ImageView r3 = this.a.h;
        if (r3 != null) goto L10;
    L18:
        ImageView r4 = this.a.h;
        if (r4 != null) goto L21;
    L29:
        GroupPhotoDialogFragment r5 = this.a;
        ImageView r6 = r5.h;
        com.bytedance.android.live.base.model.data.f r7 = r5.n;
        GroupPhotoDialogFragment.S90(r6, r7.width, r7.height);
        return;
    L21:
        if (o.a() == false) goto L27;
        double r8 = r0.locationY;
        double r9 = 400;
        py.k r10 = this.a.n.groupPhoto;
        if (r10 == null) goto L25;
        int r12 = r10.getHeight();
    L26:
        int r13 = (int) UtilityKotlinExtentionsKt.h((float) (r8 * (r9 / ((double) r12))));
    L28:
        a1.o(r4, r13);
        goto L29
    L25:
        r12 = 475;
        goto L26
    L27:
        r13 = UtilityKotlinExtentionsKt.i(r0.locationY);
        goto L28
    L10:
        if (o.a() == false) goto L16;
        double r14 = r0.locationX;
        double r15 = 260;
        py.k r16 = this.a.n.groupPhoto;
        if (r16 == null) goto L14;
        int r17 = r16.getWidth();
    L15:
        int r18 = (int) UtilityKotlinExtentionsKt.h((float) (r14 * (r15 / ((double) r17))));
    L17:
        a1.m(r3, r18);
        goto L18
    L14:
        r17 = 308;
        goto L15
    L16:
        r18 = UtilityKotlinExtentionsKt.i(r0.locationX);
        goto L17
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
