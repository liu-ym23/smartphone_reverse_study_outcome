package com.larus.bmhome.chat.standarduikit.quickreply.viewmodel;

import android.content.Context;
import com.larus.im.bean.message.block.QuickReplyItem;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tm8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b a;
    public com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c b;
    public List<QuickReplyItem> c;
    public final c d;

    public static final class a {
    }

    public static final class b {
        public final QuickReplyItem a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "VisibleQuickReplyItem(item=" + this.a + ", clicked=" + this.b + ')';
        }

        public b(QuickReplyItem r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "item");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c implements o {
        public final /* synthetic */ d a;

        @Override // tm8.o
        public final void a() {
            d r0 = this.a;
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r1 = r0.a;
            if (r1 != null) goto L5;
            return;
        L5:
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c r2 = r0.b;
            if (r2 == null) goto L9;
            r2.c(r1);
            return;
        }

        public c(d r1) {
            this.a = r1;
        }

        @Override // tm8.o
        public final void b(int r3, int r4) {
            d r0 = this.a;
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r1 = r0.a;
            if (r1 != null) goto L5;
            return;
        L5:
            QuickReplyItem r5 = (QuickReplyItem) CollectionsKt.getOrNull(r0.c, r3);
            if (r5 != null) goto L8;
            return;
        L8:
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c r2 = this.a.b;
            if (r2 == null) goto L12;
            r2.a(r1, r5, r4);
            return;
        }

        @Override // tm8.o
        public final void c(int r8, int r9, Context r10) {
            d r0 = this.a;
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.b r2 = r0.a;
            if (r2 != null) goto L5;
            return;
        L5:
            QuickReplyItem r3 = (QuickReplyItem) CollectionsKt.getOrNull(r0.c, r8);
            if (r3 != null) goto L8;
            return;
        L8:
            com.larus.bmhome.chat.standarduikit.quickreply.viewmodel.c r1 = this.a.b;
            if (r1 == null) goto L12;
            r1.b(r2, r3, r9, r10, r8);
            return;
        }
    }

    static {
    }

    public d() {
        this.c = CollectionsKt.emptyList();
        this.d = new c(this);
    }
}
