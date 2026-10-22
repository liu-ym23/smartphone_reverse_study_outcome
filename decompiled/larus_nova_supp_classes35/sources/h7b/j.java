package h7b;

import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.utils.z0;
import com.ss.android.lark.log.Log;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j {
    public final Chat a;
    public final com.ss.android.lark.im.sdk.service.h b;

    public static final class a {
        public final ChatChatter a;
        public final OpenApp b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            ChatChatter r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            OpenApp r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ChatterInfo(chatChatter=" + this.a + ", openApp=" + this.b + ')';
        }

        public a(ChatChatter r1, OpenApp r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
    }

    static {
    }

    public final a a() {
        z0.a();
        if (this.a.isP2PChat() == true) goto L5;
        return null;
    L5:
        ChatChatter r0 = this.b.H5(this.a.getId(), this.a.getP2pChatterId());
        if (r0 != null) goto L19;
        Pair r1 = this.b.qb(this.a.getId(), this.a.getP2pChatterId());
        if (r1 == null) goto L20;
        StringBuilder r2 = new StringBuilder("append chat ");
        r2.append(this.a.getId());
        r2.append(" chatter ");
        r2.append(this.a.getP2pChatterId());
        r2.append(" and openApp from net chatter is null: ");
        boolean r3 = true;
        if (r1.getFirst() != null) goto L12;
        boolean r4 = true;
    L13:
        r2.append(r4);
        r2.append(" openApp is null: ");
        if (r1.getSecond() == null) goto L17;
        r3 = false;
    L17:
        r2.append(r3);
        Log.i("LauncherChatterComplete", r2.toString());
        return new a((ChatChatter) r1.getFirst(), (OpenApp) r1.getSecond());
    L12:
        r4 = false;
        goto L13
    L20:
        return null;
    L19:
        return new a(r0, null);
    }

    public j(Chat r2, com.ss.android.lark.im.sdk.service.h r3) {
        Intrinsics.checkNotNullParameter(r2, "chat");
        Intrinsics.checkNotNullParameter(r3, "chatterService");
        this.a = r2;
        this.b = r3;
    }
}
