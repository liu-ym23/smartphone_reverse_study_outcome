package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import com.bytedance.android.livesdk.interactivity.chatchannel.model.ChannelLinkUserInfo;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ ChannelMemberManagerDialog a;

    public e(ChannelMemberManagerDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        ChannelMemberManagerDialog r0 = this.a;
        boolean r8 = ((Boolean) r7).booleanValue();
        int r1 = ChannelMemberManagerDialog.k0;
        r0.b1(r8);
        List<ChannelLinkUserInfo> r9 = this.a.H;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ChannelLinkUserInfo r3 = (ChannelLinkUserInfo) r10.next();
        r2.add(new ChannelLinkUserInfo(r3.a, new ChannelLinkUserInfo.a(r3.b.a, this.a.E)));
        goto L4
    L6:
        ChannelMemberManagerDialog r11 = this.a;
        r11.c1(r11.F, r11.G, r2);
    }
}
