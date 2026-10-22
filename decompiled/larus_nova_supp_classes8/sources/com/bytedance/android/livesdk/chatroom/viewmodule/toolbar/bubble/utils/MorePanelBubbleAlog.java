package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class MorePanelBubbleAlog {

    public static final class SimpleAlogArgsBuilder {
        public final Lazy a;

        public final a b() {
            return new a(((StringBuilder) this.a.getValue()).toString());
        }

        public SimpleAlogArgsBuilder() {
            this.a = LazyKt.lazy(MorePanelBubbleAlog$SimpleAlogArgsBuilder$strBuilder$2.INSTANCE);
        }

        public final void c(String r3) {
            Intrinsics.checkNotNullParameter(r3, "msg");
            ((StringBuilder) this.a.getValue()).append(r3 + '.');
        }

        public final void d(String r4) {
            Intrinsics.checkNotNullParameter(r4, "tag");
            ((StringBuilder) this.a.getValue()).append("tag:" + r4 + '\t');
        }

        public final void a(String r4, Object r5) {
            Intrinsics.checkNotNullParameter(r4, "key");
            Intrinsics.checkNotNullParameter(r5, "value");
            ((StringBuilder) this.a.getValue()).append("the " + r4 + " is " + r5 + '.');
        }
    }

    public static final class a {
        public final String a;
        public final Throwable b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Throwable r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "SimpleAlogArgs(msg=" + this.a + ", error=" + this.b + ")";
        }

        public a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            this.a = r2;
            this.b = null;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(a r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        Throwable r0 = r2.b;
        if (r0 == null) goto L5;
        ALogger.e("MorePanelBubbleAlog", r2.a, r0);
        return;
    L5:
        ALogger.i("MorePanelBubbleAlog", r2.a);
        Unit r3 = Unit.INSTANCE;
    }
}
