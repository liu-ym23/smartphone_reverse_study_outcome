package com.ss.android.lark.mention.base.impl.statistics;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import z5c.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends q5c.a {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public a() {
        }

        public static final s5c.a a(com.ss.android.lark.mention.base.impl.atselector.bean.a r2) {
            int r0 = e.a;
            if (r2 == null) goto L5;
            Chatter.ChatterType r1 = r2.g;
        L7:
            if (r1 == Chatter.ChatterType.BOT) goto L18;
            if (r2 == null) goto L13;
            boolean r3 = true;
            if (r2.b() != true) goto L13;
        L14:
            if (r3 == false) goto L17;
            s5c.d.o2.getClass();
            return new s5c.a("entity_type", "ai_qa");
        L17:
            return m0.d;
        L13:
            r3 = false;
            goto L14
        L18:
            return m0.e;
        L5:
            r1 = null;
            goto L7
        }

        public static void b(boolean r1, String r2, String r3, boolean r4, boolean r5, String r6, String r7) {
            Intrinsics.checkNotNullParameter(r2, "atId");
            Intrinsics.checkNotNullParameter(r3, "loginUserId");
            Intrinsics.checkNotNullParameter(r6, "searchLocation");
            Intrinsics.checkNotNullParameter(r7, "guessType");
            if (r1 == false) goto L5;
            String r8 = "guess";
        L7:
            if (Intrinsics.areEqual(r2, r3) == false) goto L10;
            String r9 = "me";
        L13:
            if (r4 == false) goto L15;
            String r10 = "external";
        L16:
            if (r5 == false) goto L18;
            String r11 = "y";
        L19:
            Statistics.sendEvent("noticelist_choice", new JSONObject().put("choicetype", r8).put("notice", r9).put("member_type", r10).put("is_query", r11).put("search_location", r6).put("guess_type", r7));
            return;
        L18:
            r11 = "n";
            goto L19
        L15:
            r10 = "internal";
            goto L16
        L10:
            if (Intrinsics.areEqual(r2, "all") == false) goto L12;
            r9 = "atall";
            goto L13
        L12:
            r9 = "atother";
            goto L13
        L5:
            r8 = "normal";
            goto L7
        }
    }

    static {
        new a();
    }
}
