package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.Text;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class s extends i {
    public static final /* synthetic */ int k = 0;
    public final v h;
    public boolean i;
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.e j;

    public static final class a extends yb2.a {
        public final int n;
        public final int o;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (this.n == r4.n) goto L8;
            return false;
        L8:
            if (this.o == r4.o) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.n * 31) + this.o;
        }

        public final String toString() {
            return "ColorConfig(nameColor=" + this.n + ", contentColor=" + this.o + ")";
        }

        public a(int r1, int r2) {
            this.n = r1;
            this.o = r2;
            this.a = r1;
            this.d = r2;
            this.b = r2;
            this.c = r2;
            this.e = r2;
        }
    }

    public static final class b {
        public b() {
        }

        public static u c(PublicScreenConfig$MessageModelType r10, Text r11, User r13, PSMessageAction r14) {
            int r0 = s.k;
            Intrinsics.checkNotNullParameter(r10, "type");
            Intrinsics.checkNotNullParameter(r11, "text");
            Intrinsics.checkNotNullParameter(r14, "actionType");
            return new u(r10, r13, null, r11, null, false, true, r14);
        }

        public static /* synthetic */ t b(PublicScreenConfig$MessageModelType r9, String r10, Integer r11, boolean r13, boolean r14, PSMessageAction r15, int r16) {
            if ((r16 & 4) == 0) goto L5;
            r11 = null;
        L5:
            Integer r2 = r11;
            if ((r16 & 8) == 0) goto L8;
            boolean r3 = false;
        L10:
            if ((r16 & 16) == 0) goto L12;
            boolean r4 = false;
        L14:
            if ((r16 & 128) == 0) goto L17;
            r15 = PSMessageAction.UNKNOW;
        L17:
            return a(r9, r10, r2, r3, r4, false, null, r15, null);
        L12:
            r4 = r14;
            goto L14
        L8:
            r3 = r13;
            goto L10
        }

        @JvmStatic
        public static t a(PublicScreenConfig$MessageModelType r11, String r13, Integer r14, boolean r15, boolean r16, boolean r17, IBaseUser r18, PSMessageAction r19, IPublicAreaCommon r110) {
            Intrinsics.checkNotNullParameter(r11, "type");
            Intrinsics.checkNotNullParameter(r13, "content");
            Intrinsics.checkNotNullParameter(r19, "actionType");
            return new t(r11, r18, r110, r14, r13, r15, r16, r17, r19);
        }
    }

    public static final class c {
        public final tb2.d a;
        public final boolean b;
        public final boolean c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L12;
            c r4 = (c) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            tb2.d r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.b;
            ?? r4 = 1;
            ?? r5 = r3;
            if (r3 == false) goto L9;
            r5 = 1;
        L9:
            int r6 = (r2 + r5) * 31;
            boolean r7 = this.c;
            if (r7 == true) goto L14;
            r4 = r7;
        L14:
            return r6 + r4;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "TextInfo(renderText=" + this.a + ", hasEmoji=" + this.b + ", hasAnim=" + this.c + ")";
        }

        public c(tb2.d r2, boolean r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "renderText");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }

        public /* synthetic */ c(tb2.d r2, boolean r3, int r4) {
            if ((r4 & 4) == 0) goto L5;
            r3 = false;
        L5:
            this(r2, false, r3);
        }
    }

    static {
        new b();
    }

    public abstract c k();

    public void l(View r1, g52.d r2, g52.c r3) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public boolean m(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return false;
    }

    public boolean n(View r1, tb2.b r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        return false;
    }

    public s() {
        this.h = v.b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.i
    public j<? extends i, ? extends PSMessageViewHolder> b() {
        return this.h;
    }
}
