package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class e extends r22.a<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
    public final Deque<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> c;
    public final r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> d;
    public final BarrageWidgetContext e;

    @Override // r22.a
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.d j() {
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) ((LinkedList) this.c).pollFirst();
    }

    @Override // r22.a
    public final r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> f() {
        return this.d;
    }

    @Override // r22.a
    public final Queue<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> h() {
        return this.c;
    }

    @Override // r22.a
    public final void e(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r2) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "danmaku");
        ((LinkedList) this.c).add(r3);
        k();
    }

    public e(r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r2, BarrageWidgetContext r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2);
        this.d = r2;
        this.e = r3;
        this.c = new LinkedList();
    }

    @Override // r22.a
    public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r6, r22.a.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r7) {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r8 = r6;
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r7, "notifier");
        String r1 = null;
        if ((r8 instanceof q72.b) == true) goto L5;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d r0 = null;
    L6:
        q72.b r2 = (q72.b) r0;
        if (r8.isSelfSendFake() == false) goto L13;
        IBaseUser r3 = r8.getUserInfo();
        if (r3 == null) goto L11;
        py.k r4 = r3.getAvatarThumbKt();
    L12:
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r4, new d(r2, r7, r8));
        goto L13
    L11:
        r4 = null;
    L13:
        int r5 = 0;
        if (r2 == null) goto L16;
        int r9 = r2.e;
    L17:
        BarrageWidgetContext r10 = this.e;
        if (r10 == null) goto L26;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r11 = r10.getChatCarnivalMessage();
        if (r11 == null) goto L26;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r13 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r11.getValue();
        if (r13 == null) goto L26;
        List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> r14 = r13.q();
        if (r14 == null) goto L26;
        r5 = r14.size();
    L26:
        if (r9 >= r5) goto L52;
        BarrageWidgetContext r15 = this.e;
        if (r15 == null) goto L47;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r16 = r15.getChatCarnivalMessage();
        if (r16 == null) goto L47;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r17 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r16.getValue();
        if (r17 == null) goto L47;
        List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> r18 = r17.q();
        if (r18 == null) goto L47;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.f r19 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.f) ListProtector.get(r18, r9);
        if (r19 == null) goto L47;
        py.i r20 = r19.a();
        py.k r21 = vh7.f.c(py.k.class);
        if (r20 == null) goto L41;
        r1 = r20.getUri();
    L41:
        r21.setUri(r1);
        if (r20 == null) goto L45;
        List r23 = r20.getUrlList();
        if (r23 == null) goto L45;
    L46:
        r21.setUrls(r23);
        a1.u(r21, new c(r2, r8, r7));
        return;
    L45:
        r23 = CollectionsKt.emptyList();
    L47:
        if (r2 == null) goto L51;
        r2.c = true;
        return;
    L51:
        return;
    L52:
        return;
    L16:
        r9 = 0;
        goto L17
    L5:
        r0 = r8;
        goto L6
    }
}
