package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.textmessage.model.i0;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public final View a;
    public final NoMoreSpaceTextView b;
    public final com.bytedance.android.livesdk.chatroom.o c;

    public l(Context r8, com.bytedance.android.livesdk.interactivity.api.entity.l r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "event");
        View r10 = LayoutInflater.from(r8).inflate(2131566923, null);
        this.a = r10;
        NoMoreSpaceTextView r11 = r10.findViewById(2131379974);
        this.b = r11;
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, null, 0, 3);
    L6:
        this.c = r1;
        int r2 = da2.a.a;
        if (r1 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r1 == null) goto L14;
        Boolean r3 = r1.isAnchor();
    L15:
        da2.b r5 = new da2.b(new da2.c(r4, Intrinsics.areEqual(r3, Boolean.TRUE), null));
        q92.a r6 = new q92.a();
        Intrinsics.checkNotNullParameter(r6, "config");
        da2.b r7 = new da2.b(new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.b(r6));
        t r13 = r9.b;
        s r14 = r9.a;
        if (r14 == null) goto L23;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r15 = r7.b(r14, new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f(false), new k(this));
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i r16 = r15.b;
        if (r16 != null) goto L20;
    L22:
        r11.setText(r15.a);
        return;
    L20:
        if (r16.a != true) goto L22;
        r11.setAlwaysInvalidate(true);
        goto L22
    L23:
        com.bytedance.android.livesdk.interactivity.api.entity.f r17 = i0.e(r13, MessageSceneType.PUBLIC_SCREEN, null);
        if (r17 == null) goto L33;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.j r18 = r5.b(r17, new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.f(false), new j(this));
        com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i r19 = r18.b;
        if (r19 != null) goto L28;
    L30:
        r11.setText(r18.a);
        return;
    L28:
        if (r19.a != true) goto L30;
        r11.setAlwaysInvalidate(true);
        goto L30
    L33:
        return;
    L14:
        r3 = null;
        goto L15
    L9:
        if (r1.isMediaRoom() != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r1 = null;
        goto L6
    }
}
