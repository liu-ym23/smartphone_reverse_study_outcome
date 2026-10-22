package com.ss.android.lark.message.lynxcard.message;

import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.message.universalcard.datachannel.MessageCardStreamingManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int g = 0;
    public final View a;
    public final v5b.c<LynxCardContentVO> b;
    public final r5b.b<LynxCardContentVO> c;
    public final CardContent d;
    public final r5b.a e;
    public final MessageCardStreamingManager f;

    public static final class a {
        public static void a(View r1, v5b.c r2) {
            Intrinsics.checkNotNullParameter(r1, "itemView");
            if (r2 != null) goto L6;
            return;
        L6:
            if (c(r1, r2) == false) goto L9;
            r2.b().w = null;
            r2.b().getClass();
            u r3 = u.a.a;
            r3.c();
            r3.c = false;
            r3.d = false;
            return;
        }

        public static boolean c(View r5, v5b.c r6) {
            Intrinsics.checkNotNullParameter(r5, "itemView");
            if (r6 != null) goto L5;
            return false;
        L5:
            LynxCardViewHolder r7 = LynxCardViewHolder.V3(r5);
            if (r7 != null) goto L8;
            return false;
        L8:
            v5b.c<LynxCardContentVO> r1 = r7.k;
            if (r1 == null) goto L12;
            LynxCardContentVO r2 = (LynxCardContentVO) r1.b();
            if (r2 == null) goto L12;
        L13:
            TextView r3 = r7.mShowMoreText;
            if (r3 != null) goto L16;
        L18:
            boolean r4 = false;
        L19:
            if (r4 == true) goto L29;
            View r8 = r7.mShowMoreView;
            if (r8 != null) goto L23;
        L25:
            boolean r9 = false;
        L26:
            if (r9 == true) goto L29;
            boolean r10 = false;
        L30:
            v5b.c<LynxCardContentVO> r11 = r7.k;
            if (r11 == null) goto L33;
            String r12 = r11.getId();
        L35:
            if (Intrinsics.areEqual(r12, r6.getId()) == true) goto L37;
            return false;
        L37:
            if (r2.l == true) goto L39;
            return false;
        L39:
            if (r7.d == false) goto L45;
            if (r10 == false) goto L46;
            return true;
        L46:
            return false;
        L45:
            return false;
        L33:
            r12 = null;
            goto L35
        L23:
            if (r8.getVisibility() != 0) goto L25;
            r9 = true;
        L29:
            r10 = true;
            goto L30
        L16:
            if (r3.getVisibility() != 0) goto L18;
            r4 = true;
        L12:
            r2 = r6.b();
            goto L13
        }

        public static void b(View r4, v5b.c r5, r5b.b r6) {
            Intrinsics.checkNotNullParameter(r4, "itemView");
            if (r5 != null) goto L5;
            return;
        L5:
            LynxCardViewHolder r0 = LynxCardViewHolder.V3(r4);
            if (r0 != null) goto L8;
            return;
        L8:
            v5b.c<LynxCardContentVO> r1 = r0.k;
            if (r1 != null) goto L12;
            return;
        L12:
            if (Intrinsics.areEqual(r1.getId(), r5.getId()) == true) goto L15;
            return;
        L15:
            if (c(r4, r5) == true) goto L17;
            return;
        L17:
            LynxCardContentVO r7 = r1.b();
            LynxCardContentVO r2 = (LynxCardContentVO) r5.b();
            r7.l = false;
            if (r7 == r2) goto L20;
            r2.l = false;
        L20:
            r0.U3();
            if (r6 == null) goto L24;
            r6.b(r5.getId());
            return;
        }
    }

    static {
    }

    public d(View r2, v5b.c<LynxCardContentVO> r3, r5b.b<LynxCardContentVO> r4, CardContent r5, r5b.a r6, MessageCardStreamingManager r7) {
        Intrinsics.checkNotNullParameter(r2, "mView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
