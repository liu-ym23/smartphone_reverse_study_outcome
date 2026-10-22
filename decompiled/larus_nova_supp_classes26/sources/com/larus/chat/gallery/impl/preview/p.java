package com.larus.chat.gallery.impl.preview;

import android.graphics.Bitmap;
import android.view.View;
import com.larus.bmhome.chat.api.q0;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.community.impl.component.g0;
import com.larus.im.bean.conversation.BotConversationType;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class p {
    public final Lazy a;

    public static final class a extends p {
        public final String b;
        public final String c;
        public final Message d;
        public final q0 e;
        public final int f;
        public final int g;
        public final View h;
        public final Integer i;
        public final Bitmap j;
        public final PreviewScene k;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
            return false;
        L21:
            if (this.f == r6.f) goto L24;
            return false;
        L24:
            if (this.g == r6.g) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L36;
            return false;
        L36:
            if (this.k == r6.k) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.b.hashCode() * 31) + this.c.hashCode()) * 31;
            Message r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            q0 r5 = this.e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((((r4 + r6) * 31) + this.f) * 31) + this.g) * 31;
            View r8 = this.h;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Integer r11 = this.i;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Bitmap r14 = this.j;
            if (r14 == null) goto L23;
            r2 = r14.hashCode();
        L23:
            return ((r13 + r2) * 31) + this.k.hashCode();
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ChatMessage(conversationId=" + this.b + ", selectMessageId=" + this.c + ", selectMessage=" + this.d + ", adapter=" + this.e + ", botConversationType=" + this.f + ", clickIndex=" + this.g + ", startView=" + this.h + ", initialVideoStartTime=" + this.i + ", initialVideoCoverBitmap=" + this.j + ", scene=" + this.k + ')';
        }

        @Override // com.larus.chat.gallery.impl.preview.p
        public final PreviewScene a() {
            return this.k;
        }

        public a(String r2, String r3, Message r4, q0 r5, @BotConversationType int r6, int r7, View r8, Integer r9, Bitmap r10, PreviewScene r11) {
            Intrinsics.checkNotNullParameter(r2, "conversationId");
            Intrinsics.checkNotNullParameter(r3, "selectMessageId");
            Intrinsics.checkNotNullParameter(r11, "scene");
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
        }
    }

    public static final class b extends p {
        public final com.larus.chat.gallery.api.i b;
        public final String c;
        public final PreviewScene d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (this.d == r6.d) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "CreationRecord(dataBridge=" + this.b + ", selectCreationId=" + this.c + ", scene=" + this.d + ')';
        }

        @Override // com.larus.chat.gallery.impl.preview.p
        public final PreviewScene a() {
            return this.d;
        }

        public b(g0 r2, String r3, PreviewScene r4) {
            Intrinsics.checkNotNullParameter(r2, "dataBridge");
            Intrinsics.checkNotNullParameter(r3, "selectCreationId");
            Intrinsics.checkNotNullParameter(r4, "scene");
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c extends p {
        public final List<com.larus.chat.gallery.api.o> b;
        public final int c;
        public final com.larus.chat.gallery.api.q d;
        public final com.larus.chat.gallery.api.l e;
        public final PreviewScene f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (this.c == r6.c) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
            return false;
        L21:
            if (this.f == r6.f) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.b.hashCode() * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        }

        public final String toString() {
            return "MediaSource(items=" + this.b + ", initialPosition=" + this.c + ", session=" + this.d + ", capability=" + this.e + ", scene=" + this.f + ')';
        }

        @Override // com.larus.chat.gallery.impl.preview.p
        public final PreviewScene a() {
            return this.f;
        }

        public c(List r2, int r3, com.larus.chat.gallery.api.a r4, com.larus.chat.gallery.api.l r5, PreviewScene r6) {
            Intrinsics.checkNotNullParameter(r2, "items");
            Intrinsics.checkNotNullParameter(r4, "session");
            Intrinsics.checkNotNullParameter(r5, "capability");
            Intrinsics.checkNotNullParameter(r6, "scene");
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PreviewScene.values().length];
            r0[PreviewScene.CREATION_CARD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[PreviewScene.CREATION_RECORD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[PreviewScene.SEARCH_IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public abstract PreviewScene a();

    public p() {
        this.a = LazyKt.lazy(new o(this));
    }
}
