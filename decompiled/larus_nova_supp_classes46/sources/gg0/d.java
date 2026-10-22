package gg0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFoldButtonViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends b<MultiLinkFoldButtonViewBinder.a> {
    public d() {
    }

    @Override // gg0.b
    public final boolean a(tf0.e r4, tf0.e r5) {
        MultiLinkFoldButtonViewBinder.a r6 = (MultiLinkFoldButtonViewBinder.a) r4;
        MultiLinkFoldButtonViewBinder.a r7 = (MultiLinkFoldButtonViewBinder.a) r5;
        Intrinsics.checkNotNullParameter(r6, "oldItem");
        Intrinsics.checkNotNullParameter(r7, "newItem");
        if (r6.k == r7.k) goto L5;
    L52:
        return false;
    L5:
        if (r6.l != r7.l) goto L52;
        if (r6.m != r7.m) goto L52;
        MultiLinkNormalEmptyViewBinder.a r0 = r6.p;
        ILinkPlayerInfoBridge r1 = null;
        if (r0 == null) goto L11;
        Boolean r2 = Boolean.valueOf(r0.h());
    L12:
        MultiLinkNormalEmptyViewBinder.a r3 = r7.p;
        if (r3 == null) goto L15;
        Boolean r8 = Boolean.valueOf(r3.h());
    L17:
        if (Intrinsics.areEqual(r2, r8) == false) goto L52;
        MultiLinkFirstUserViewBinder.a r9 = r6.q;
        if (r9 == null) goto L23;
        ch0.e r10 = r9.k;
        if (r10 == null) goto L23;
        ILinkPlayerInfoBridge r11 = r10.a;
    L24:
        MultiLinkFirstUserViewBinder.a r12 = r7.q;
        if (r12 == null) goto L29;
        ch0.e r13 = r12.k;
        if (r13 == null) goto L29;
        ILinkPlayerInfoBridge r14 = r13.a;
    L30:
        if (r11 == null) goto L32;
        Integer r15 = Integer.valueOf(r11.getSilenceStatus());
    L33:
        if (r14 == null) goto L35;
        Integer r16 = Integer.valueOf(r14.getSilenceStatus());
    L37:
        if (Intrinsics.areEqual(r15, r16) == false) goto L52;
        MultiLinkFirstUserViewBinder.a r17 = r6.q;
        if (r17 == null) goto L43;
        ch0.e r18 = r17.k;
        if (r18 == null) goto L43;
        ILinkPlayerInfoBridge r19 = r18.a;
    L44:
        MultiLinkFirstUserViewBinder.a r20 = r7.q;
        if (r20 == null) goto L50;
        ch0.e r21 = r20.k;
        if (r21 == null) goto L50;
        r1 = r21.a;
    L50:
        if (e(r19, r1) == false) goto L52;
        return true;
    L43:
        r19 = null;
        goto L44
    L35:
        r16 = null;
        goto L37
    L32:
        r15 = null;
    L29:
        r14 = null;
    L23:
        r11 = null;
        goto L24
    L15:
        r8 = null;
        goto L17
    L11:
        r2 = null;
        goto L12
    }

    @Override // gg0.b
    public final boolean b(tf0.e r3, tf0.e r4) {
        MultiLinkFoldButtonViewBinder.a r5 = (MultiLinkFoldButtonViewBinder.a) r3;
        MultiLinkFoldButtonViewBinder.a r6 = (MultiLinkFoldButtonViewBinder.a) r4;
        Intrinsics.checkNotNullParameter(r5, "oldItem");
        Intrinsics.checkNotNullParameter(r6, "newItem");
        if (r5.k == r6.k) goto L5;
    L18:
        return false;
    L5:
        if (r5.l != r6.l) goto L18;
        if (r5.m != r6.m) goto L18;
        MultiLinkNormalEmptyViewBinder.a r7 = r5.p;
        Boolean r0 = null;
        if (r7 == null) goto L11;
        Boolean r8 = Boolean.valueOf(r7.h());
    L12:
        MultiLinkNormalEmptyViewBinder.a r9 = r6.p;
        if (r9 == null) goto L16;
        r0 = Boolean.valueOf(r9.h());
    L16:
        if (Intrinsics.areEqual(r8, r0) == false) goto L18;
        return true;
    L11:
        r8 = null;
        goto L12
    }

    public final boolean e(ILinkPlayerInfoBridge r4, ILinkPlayerInfoBridge r5) {
        if (r4 == null) goto L5;
        String r6 = r4.getFanTicketDisplayStr();
    L6:
        if (r5 == null) goto L8;
        String r7 = r5.getFanTicketDisplayStr();
    L10:
        return StringsKt.equals$default(r6, r7, false, 2, null);
    L8:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    @Override // gg0.b
    public final Bundle d(tf0.e r4, tf0.e r5, int r6, int r7) {
        MultiLinkFoldButtonViewBinder.a r8 = (MultiLinkFoldButtonViewBinder.a) r4;
        MultiLinkFoldButtonViewBinder.a r9 = (MultiLinkFoldButtonViewBinder.a) r5;
        Intrinsics.checkNotNullParameter(r8, "oldItem");
        Intrinsics.checkNotNullParameter(r9, "newItem");
        Bundle r10 = super.d(r8, r9, r6, r7);
        MultiLinkFirstUserViewBinder.a r11 = r8.q;
        ILinkPlayerInfoBridge r0 = null;
        if (r11 == null) goto L7;
        ch0.e r12 = r11.k;
        if (r12 == null) goto L7;
        ILinkPlayerInfoBridge r13 = r12.a;
    L8:
        MultiLinkFirstUserViewBinder.a r1 = r9.q;
        if (r1 == null) goto L13;
        ch0.e r2 = r1.k;
        if (r2 == null) goto L13;
        ILinkPlayerInfoBridge r3 = r2.a;
    L14:
        if (r13 == null) goto L16;
        Integer r14 = Integer.valueOf(r13.getSilenceStatus());
    L17:
        if (r3 == null) goto L19;
        Integer r15 = Integer.valueOf(r3.getSilenceStatus());
    L21:
        if (Intrinsics.areEqual(r14, r15) == true) goto L23;
        r10.putBoolean("payload_key_silence_status_update", true);
    L23:
        MultiLinkFirstUserViewBinder.a r16 = r8.q;
        if (r16 == null) goto L28;
        ch0.e r17 = r16.k;
        if (r17 == null) goto L28;
        ILinkPlayerInfoBridge r18 = r17.a;
    L29:
        MultiLinkFirstUserViewBinder.a r19 = r9.q;
        if (r19 == null) goto L34;
        ch0.e r20 = r19.k;
        if (r20 == null) goto L34;
        ILinkPlayerInfoBridge r21 = r20.a;
    L36:
        if (e(r18, r21) == true) goto L38;
        r10.putBoolean("payload_key_fan_ticket_str_update", true);
    L38:
        MultiLinkFirstUserViewBinder.a r22 = r8.q;
        if (r22 == null) goto L43;
        ch0.e r23 = r22.k;
        if (r23 == null) goto L43;
        ILinkPlayerInfoBridge r24 = r23.a;
    L44:
        MultiLinkFirstUserViewBinder.a r25 = r9.q;
        if (r25 == null) goto L50;
        ch0.e r26 = r25.k;
        if (r26 == null) goto L50;
        r0 = r26.a;
    L50:
        if (e(r24, r0) == true) goto L52;
        r10.putBoolean("payload_key_fan_ticket_str_update", true);
    L52:
        return r10;
    L43:
        r24 = null;
    L34:
        r21 = null;
    L28:
        r18 = null;
        goto L29
    L19:
        r15 = null;
        goto L21
    L16:
        r14 = null;
    L13:
        r3 = null;
    L7:
        r13 = null;
        goto L8
    }
}
