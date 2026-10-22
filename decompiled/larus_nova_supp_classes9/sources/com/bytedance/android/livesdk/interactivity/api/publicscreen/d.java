package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.graphics.Color;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.message.q5;
import com.bytedance.android.live.base.model.message.v0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface d {
    public static final a O0 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        @JvmStatic
        public static d a(com.bytedance.android.live.base.model.message.t r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            if ((r2 instanceof q5) == false) goto L6;
            return new d0((q5) r2);
        L6:
            if ((r2 instanceof k0) == false) goto L15;
            k0 r3 = (k0) r2;
            if (r3.getRichDisplayText() != null) goto L32;
            if (r3.getSelfFakeRichContent() != null) goto L32;
            return new z(r3);
        L32:
            return new b0(r3);
        L15:
            if ((r2 instanceof h4) == false) goto L18;
            return new c0((h4) r2);
        L18:
            if ((r2 instanceof com.bytedance.android.live.base.model.message.r) == false) goto L21;
            return new y((com.bytedance.android.live.base.model.message.r) r2);
        L21:
            if ((r2 instanceof v0) == false) goto L24;
            return new a0((v0) r2);
        L24:
            if ((r2 instanceof c4) == false) goto L28;
            c4 r4 = (c4) r2;
            if (r4.getRoomMessageType() != 4) goto L28;
            return new e0(r4);
        L28:
            return null;
        }
    }

    public static final class b {
        public static String a(d r1) {
            if (r1.h() == false) goto L6;
            return "welcome";
        L6:
            if (r1.a() == false) goto L9;
            return "official";
        L9:
            if (r1.getMedal() == null) goto L11;
            return "medal";
        L11:
            o1 r2 = r1.getLandscapeAreaCommon();
            if (r2 != null) goto L14;
        L16:
            return "normal";
        L14:
            if (r2.isStarMessage() != true) goto L16;
            return "star";
        }

        public static int b(d r3) {
            List<String> r4 = r3.b();
            if (r4 == null) goto L20;
            String r5 = (String) CollectionsKt.firstOrNull(r4);
            if (r5 == null) goto L21;
            if (r5.length() != 0) goto L9;
            boolean r2 = true;
        L10:
            if (r2 == true) goto L22;
            int r6 = Color.parseColor("#".concat(r5));     // Catch: Exception -> L17
            if (r6 != 0) goto L16;
            return -1;
        L16:
            return r6;
        L22:
            return -1;
        L9:
            r2 = false;
        L24:
            return -1;
        L21:
            return -1;
        L20:
            return -1;
        }

        public static boolean c(d r1) {
            if (r1.g() == false) goto L5;
        L8:
            return true;
        L5:
            if (r1.k() != (-1)) goto L8;
            return false;
        }

        public static boolean d(d r3) {
            o1 r0 = r3.getLandscapeAreaCommon();
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.getShowFontColor() != true) goto L14;
            List<String> r4 = r3.b();
            if (r4 == null) goto L9;
            int r5 = r4.size();
        L10:
            if (r5 <= 1) goto L15;
            return true;
        L15:
            return false;
        L9:
            r5 = 0;
            goto L10
        L14:
            return false;
        }
    }

    static {
        O0 = a.a;
    }

    boolean a();

    List<String> b();

    String d();

    String e();

    boolean f();

    boolean g();

    CharSequence getChatContent();

    com.bytedance.android.live.base.model.data.k getContentExt();

    o1 getLandscapeAreaCommon();

    j0 getMedal();

    com.bytedance.android.live.base.model.message.t getMessage();

    long getMessageId();

    int getScore();

    IBaseUser getUserInfo();

    boolean h();

    boolean i();

    boolean isSelfSendFake();

    int k();
}
