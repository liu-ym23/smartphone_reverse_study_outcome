package com.bytedance.android.livesdk.interactivity.comment.share;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.Items;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        Response r9 = (Response) r8;
        if (((BaseResponse) r9).statusCode != 0) goto L37;
        com.bytedance.android.livesdk.interactivity.comment.share.model.a r10 = (com.bytedance.android.livesdk.interactivity.comment.share.model.a) ((BaseResponse) r9).data;
        if (r10 == null) goto L7;
        final List<com.bytedance.android.livesdk.interactivity.comment.share.model.a.b> r11 = r10.a();
    L8:
        List<com.bytedance.android.livesdk.interactivity.comment.share.model.a.b> r0 = r11;
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L19;
        a.InterfaceC0145a r13 = (a.InterfaceC0145a) ((q46.b) this.a).a;
        if (r13 == null) goto L45;
        r13.C10();
        return;
    L45:
        return;
    L19:
        this.a.getClass();
        Items r2 = new Items();
        Iterator<com.bytedance.android.livesdk.interactivity.comment.share.model.a.b> r3 = r11.iterator();
    L21:
        if (r3.hasNext() == false) goto L33;
        com.bytedance.android.livesdk.interactivity.comment.share.model.a.b r4 = r3.next();
        Iterator<T> r5 = r4.a().iterator();
    L24:
        if (r5.hasNext() == false) goto L26;
        com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r6 = (com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a) r5.next();
        r6.a = r4.b();
        goto L24
    L26:
        com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r7 = (com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a) CollectionsKt.firstOrNull(r4.a());
        if (r7 == null) goto L29;
        r7.b = true;
    L29:
        com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a r14 = (com.bytedance.android.livesdk.interactivity.comment.share.model.a.C0146a) CollectionsKt.lastOrNull(r4.a());
        if (r14 == null) goto L32;
        r14.c = true;
    L32:
        r2.addAll(r4.a());
        r2.add(new com.bytedance.android.livesdk.interactivity.comment.share.binder.a());
        goto L21
    L33:
        a.InterfaceC0145a r15 = (a.InterfaceC0145a) ((q46.b) this.a).a;
        if (r15 == null) goto L36;
        r15.Ux(r2);
    L36:
        int r16 = InteractivityShareAppLogger.a;
        Intrinsics.checkNotNullParameter(r11, "shareDataList");
        com.bytedance.android.livesdk.interactivity.common.utils.b.a("livesdk_room_share_panel_show", new InteractivityShareAppLogger$sendSharePanelShow$1(r11));
        return;
    L11:
        if (r0.isEmpty() == true) goto L14;
        r1 = false;
        goto L15
    L7:
        r11 = null;
        goto L8
    L37:
        a.InterfaceC0145a r17 = (a.InterfaceC0145a) ((q46.b) this.a).a;
        if (r17 == null) goto L48;
        r17.y10();
        return;
    }
}
