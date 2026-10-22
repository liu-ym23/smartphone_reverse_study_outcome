package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.view.View;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class d implements k {

    public static final class a extends d {
        public final View a;
        public final boolean b;
        public final boolean c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.c == true) goto L11;
            r2 = 1237;
        L11:
            return ((r3 + r2) * 31) + this.d.hashCode();
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "BindFishBoneWebView(webView=" + this.a + ", showThemeTransition=" + this.b + ", retryOnAttachFailure=" + this.c + ", source=" + this.d + ')';
        }

        public a(View r2, boolean r3, boolean r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "webView");
            Intrinsics.checkNotNullParameter(r5, "source");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class b extends d {
        public final long a;
        public final boolean b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            if (this.b == false) goto L5;
            int r2 = 1231;
        L7:
            return r1 + r2;
        L5:
            r2 = 1237;
            goto L7
        }

        public final String toString() {
            return "FishBoneWebScrollResult(requestId=" + this.a + ", canScroll=" + this.b + ')';
        }

        public b(long r1, boolean r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public static final class c extends d {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OpenWebPage(url=" + this.a + ')';
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            this.a = r2;
        }
    }

    public d() {
    }
}
