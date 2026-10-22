package com.bytedance.android.livesdk.chatroom.ui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class d6 {

    public static final class a extends d6 {
        public final wj0.b a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            wj0.b r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "EmojiOnEndEvent(coreInfo=" + this.a + ")";
        }

        public a(wj0.b r1) {
            this.a = r1;
        }
    }

    public static final class b extends d6 {
        public final wj0.b a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((b) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            wj0.b r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "EmojiOnRandomResultEvent(coreInfo=" + this.a + ")";
        }

        public b(wj0.b r1) {
            this.a = r1;
        }
    }

    public static final class c extends d6 {
        public final wj0.b a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((c) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            wj0.b r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "EmojiOnStartEvent(coreInfo=" + this.a + ")";
        }

        public c(wj0.b r1) {
            this.a = r1;
        }
    }

    public d6() {
    }
}
