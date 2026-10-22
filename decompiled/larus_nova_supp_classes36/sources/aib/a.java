package aib;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final ImSdkChatService a;
    public final h b;

    /* JADX INFO: renamed from: aib.a$a, reason: collision with other inner class name */
    public static final class C0001a {
        public final Chat a;
        public final ChatChatter b;
        public final ChatChatter c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0001a) == true) goto L8;
            return false;
        L8:
            C0001a r6 = (C0001a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Chat r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            ChatChatter r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            ChatChatter r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "FlowReplyInThreadInitData(chat=" + this.a + ", p2pChatter=" + this.b + ", selfChatter=" + this.c + ')';
        }

        public C0001a(Chat r1, ChatChatter r2, ChatChatter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public a(ImSdkChatService r2, h r3) {
        Intrinsics.checkNotNullParameter(r2, "chatService");
        Intrinsics.checkNotNullParameter(r3, "chatterService");
        this.a = r2;
        this.b = r3;
    }
}
