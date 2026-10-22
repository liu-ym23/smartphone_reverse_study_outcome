package com.bytedance.android.livesdk.interactivity.medialink.contract;

import com.bytedance.android.livesdk.chatroom.model.interact.MultiLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiRtcInfo;
import com.bytedance.android.livesdk.message.linker.MultiAnchorExtra;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public final AnchorLinkInitType a;
    public final String b;
    public final boolean c;
    public final String d;
    public final a e;
    public final MultiLiveCoreInfo f;
    public final MultiRtcInfo g;
    public final long h;

    public static final class a {
        public final int a;
        public final int b;
        public final MultiAnchorExtra c;

        public a() {
            this(0, 7);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            MultiAnchorExtra r1 = this.c;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "Extra(multiPkMode=" + this.a + ", inviterFromScene=" + this.b + ", multiAnchorExtra=" + this.c + ")";
        }

        public a(int r2, int r3) {
            if ((r3 & 1) == 0) goto L5;
            r2 = 0;
        L5:
            this.a = r2;
            this.b = 0;
            this.c = null;
        }
    }

    public final String toString() {
        return "MediaAnchorConnectionContext{Type=" + this.a + ", inviteeList=" + this.b + ", switchChannel=" + this.c + ", connectionType=" + this.d + ", extra=" + this.e + '}';
    }

    public d(AnchorLinkInitType r2, String r3, String r4, a r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = AnchorLinkInitType.NONE;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r3 = BuildConfig.FLAVOR;
    L9:
        if ((r6 & 32) == 0) goto L12;
        r4 = "manual_link";
    L12:
        if ((r6 & 64) == 0) goto L14;
        r5 = new a(0, 7);
    L14:
        Intrinsics.checkNotNullParameter(r2, "initType");
        Intrinsics.checkNotNullParameter(r3, "inviteeList");
        Intrinsics.checkNotNullParameter(r4, "linkConnectionType");
        Intrinsics.checkNotNullParameter(r5, "extra");
        this.a = r2;
        this.b = r3;
        this.c = false;
        this.d = r4;
        this.e = r5;
        this.f = null;
        this.g = null;
        this.h = 0;
    }
}
