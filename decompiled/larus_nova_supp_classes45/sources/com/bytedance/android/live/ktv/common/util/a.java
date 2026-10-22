package com.bytedance.android.live.ktv.common.util;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final boolean g() {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L9;
        if (r1.c() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final IRoom a() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return vh7.f.c(IRoom.class);
    }

    public static final IRoom c() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L6;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L6;
    L7:
        if (r1 == null) goto L10;
        return r1;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoom");
    L6:
        r1 = a0.a;
        goto L7
    }

    public static final boolean e() {
        Boolean r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public static final String b(KtvMusic r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$recommendSongSource");
        Map r2 = r1.getExt();
        if (r2 == null) goto L6;
        String r3 = (String) r2.get("cold_start_song_source");
        if (r3 == null) goto L6;
        return r3;
    L6:
        return "";
    }

    public static final List d(MusicPanel r4) {
        if (r4 == null) goto L18;
        KtvMusic r5 = r4.a;
        if (r5 == null) goto L18;
        List r6 = r5.getTags();
        if (r6 != null) goto L9;
        r6 = new ArrayList();
    L9:
        ArrayList r0 = new ArrayList();
        String r1 = s1.B(2131918567);
        Iterator r7 = r6.iterator();
    L11:
        if (r7.hasNext() == false) goto L16;
        String r2 = (String) r7.next();
        if (Intrinsics.areEqual(NewBroadcastMonitor.STAGE.EFFECT, r2) == true) goto L11;
        Intrinsics.areEqual(r2, r1);
        r0.add(r2);
        goto L11
    L16:
        return r0;
    L18:
        return CollectionsKt.emptyList();
    }

    public static final void f(TextView r8, String r9, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r8, "$this$highlight");
        boolean r0 = true;
        if (r11 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L20:
        r8.setText(r9);
        return;
    L11:
        if (r9.length() == 0) goto L14;
        r0 = false;
    L14:
        if (r0 == true) goto L20;
        if (StringsKt.indexOf$default(r9, r11, 0, false, 6, null) == (-1)) goto L20;
        SpannableString r1 = new SpannableString(r9);
        ForegroundColorSpan r3 = new ForegroundColorSpan(r12);
        int r13 = StringsKt.indexOf$default(r9, r11, 0, false, 6, null);
        r1.setSpan(r3, r13, r11.length() + r13, 34);
        r8.setText(r1);
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
