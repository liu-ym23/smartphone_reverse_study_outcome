package com.bytedance.android.livesdk.interactivity.api.base;

import am2.x;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final a m = null;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public long h;
    public int i;
    public int j;
    public int k;
    public int l;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static b a() {
            Intrinsics.checkNotNullParameter(q.a, "$this$getInteractivityStat");
            h r1 = i.b(null, 3);
            if (r1 == null) goto L8;
            j<b> r2 = r1.getInteractivityStat();
            if (r2 != null) goto L7;
            return null;
        L7:
            return (b) r2.getValue();
        L8:
            return null;
        }

        @JvmStatic
        public static void b() {
            Intrinsics.checkNotNullParameter(q.a, "$this$onFollowAnchor");
            h r0 = i.b(null, 3);
            if (r0 == null) goto L10;
            j<b> r1 = r0.getInteractivityStat();
            if (r1 == null) goto L11;
            b r2 = (b) r1.getValue();
            if (r2 == null) goto L12;
            r2.k++;
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public static void d() {
            Intrinsics.checkNotNullParameter(q.a, "$this$onIntercomEnd");
            h r0 = i.b(null, 3);
            if (r0 == null) goto L10;
            j<b> r1 = r0.getInteractivityStat();
            if (r1 == null) goto L11;
            b r2 = (b) r1.getValue();
            if (r2 == null) goto L12;
            r2.a();
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public static void e() {
            Intrinsics.checkNotNullParameter(q.a, "$this$onIntercomStart");
            h r0 = i.b(null, 3);
            if (r0 == null) goto L10;
            j<b> r1 = r0.getInteractivityStat();
            if (r1 == null) goto L11;
            b r2 = (b) r1.getValue();
            if (r2 == null) goto L12;
            r2.g = true;
            r2.h = System.currentTimeMillis();
            r2.i = 0;
            r2.j = 0;
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public static void f() {
            Intrinsics.checkNotNullParameter(q.a, "$this$onUnfollowAnchor");
            h r0 = i.b(null, 3);
            if (r0 == null) goto L10;
            j<b> r1 = r0.getInteractivityStat();
            if (r1 == null) goto L11;
            b r2 = (b) r1.getValue();
            if (r2 == null) goto L12;
            r2.l++;
            return;
        L12:
            return;
        L11:
            return;
        }

        @JvmStatic
        public static void c(boolean r2) {
            Intrinsics.checkNotNullParameter(q.a, "$this$onIntercomCommentShow");
            h r0 = i.b(null, 3);
            if (r0 == null) goto L14;
            j<b> r1 = r0.getInteractivityStat();
            if (r1 == null) goto L15;
            b r3 = (b) r1.getValue();
            if (r3 != null) goto L9;
            return;
        L9:
            if (r3.g == false) goto L17;
            if (r2 == false) goto L12;
            r3.j++;
            return;
        L12:
            r3.i++;
            return;
        L17:
            return;
        L15:
            return;
        }

        public static void g(DataCenter r2) {
            h r3 = i.b(r2, 1);
            if (r3 == null) goto L8;
            m<Integer> r4 = r3.getSendCommentCount();
            if (r4 == null) goto L9;
            r4.setValue(Integer.valueOf(((Number) r4.getValue()).intValue() + 1));
            return;
        L9:
            return;
        }
    }

    public b() {
    }

    static {
        m = new a();
    }

    public final void a() {
        if (this.g == true) goto L5;
        return;
    L5:
        this.g = false;
        HashMap r1 = new HashMap();
        r1.put("duration", String.valueOf(System.currentTimeMillis() - this.h));
        r1.put("comment_show_cnt", String.valueOf(this.i));
        r1.put("other_comment_show_cnt", String.valueOf(this.j));
        IRoomContextService r2 = k.f(IRoomContextService.class);
        if (r2 == null) goto L12;
        o r3 = IRoomContextService.a.a(r2, null, 0, 3);
        if (r3 == null) goto L12;
        if (r3.isMediaRoom() != true) goto L12;
        r1.put("is_media_room", "1");
    L12:
        j0.l().sendLog("livesdk_comment_interflow_watch", r1, new Object[]{IRoom.class, x.class});
    }

    @JvmStatic
    public static final void b(DataCenter r3) {
        q r0 = q.a;
        m.getClass();
        Intrinsics.checkNotNullParameter(r0, "$this$onSendSubscribeEmojiComment");
        h r1 = i.b(r3, 1);
        if (r1 == null) goto L9;
        j<b> r2 = r1.getInteractivityStat();
        if (r2 == null) goto L9;
        b r4 = (b) r2.getValue();
        if (r4 == null) goto L9;
        r4.e++;
    L9:
        a.g(r3);
    }
}
