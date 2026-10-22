package com.bytedance.android.live.liveinteract.view;

import com.bytedance.android.livesdk.chatroom.model.h3;
import com.bytedance.android.livesdk.message.model.ok;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final a f = null;
    public String a;
    public List<String> b;
    public b c;
    public b d;
    public String e;

    public static final class a {
        public a() {
        }

        public static c a(ok r8) {
            Intrinsics.checkNotNullParameter(r8, "syncData");
            c r0 = new c();
            r0.a = r8.getTitle();
            String r2 = r8.getDescription();
            if (r2 == null) goto L7;
            List r3 = StringsKt.split$default(r2, new String[]{"\n"}, false, 0, 6, null);
            if (r3 == null) goto L7;
            List r4 = r3;
        L8:
            ArrayList r1 = new ArrayList(r4);
            int r5 = 1;
        L10:
            if (r5 > 6) goto L12;
            r1.add("");
            r5 = r5 + 1;
            goto L10
        L12:
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.b = r1;
            b r6 = b(r8.getTitleStyle());
            if (r6 != null) goto L15;
            r6 = new b(18, 29);
        L15:
            r0.c = r6;
            b r7 = b(r8.getDescriptionStyle());
            if (r7 != null) goto L18;
            r7 = new b(0, 31);
        L18:
            r0.d = r7;
            r0.e = r8.getShowId();
            return r0;
        L7:
            r4 = new ArrayList();
            goto L8
        }

        public static b b(h3 r14) {
            if (r14 != null) goto L5;
            return null;
        L5:
            long r0 = r14.getAlgin();
            if (r0 != 0) goto L9;
            int r7 = 3;
        L16:
            if (r14.getScroll() != 1) goto L18;
            boolean r11 = true;
        L19:
            long r8 = r14.getFontSize();
            String r1 = r14.getFontColor();
            if (r1 != null) goto L23;
            r1 = "#FFFFFF";
        L23:
            return new b(r7, r8, r1, r11, r14.getScrollSpeed());
        L18:
            r11 = false;
            goto L19
        L9:
            if (r0 != 1) goto L12;
        L14:
            r7 = 17;
            goto L16
        L12:
            if (r0 != 2) goto L14;
            r7 = 5;
            goto L16
        }
    }

    static {
        f = new a();
    }

    public c() {
        this.b = new ArrayList();
    }
}
