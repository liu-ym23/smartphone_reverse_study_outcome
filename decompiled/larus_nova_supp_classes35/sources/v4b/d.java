package v4b;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageLink;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static final /* synthetic */ int k = 0;
    public final a a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final List<? extends MessageType> e;
    public final MessageInfo f;
    public final MessageLink.ChatInfo g;
    public final boolean h;
    public final boolean i;
    public final boolean j;

    public static final class a {
        public boolean a;
        public int b;
        public List<? extends MessageType> c;
        public final boolean d;
        public boolean e;

        public a() {
            this.a = true;
            this.b = -1;
            int r1 = d.k;
            this.c = b.a();
            this.d = true;
        }
    }

    public static final class b {
        public static List a() {
            ArrayList r0 = new ArrayList();
            r0.add(MessageType.CARD);
            r0.add(MessageType.EMAIL);
            r0.add(MessageType.CALENDAR);
            r0.add(MessageType.GENERAL_CALENDAR);
            r0.add(MessageType.SHARE_CALENDAR_EVENT);
            r0.add(MessageType.TODO);
            r0.add(MessageType.SHARE_GROUP_CHAT);
            r0.add(MessageType.PROFILE);
            r0.add(MessageType.RED_PACKET);
            r0.add(MessageType.VIDEO_CHAT);
            r0.add(MessageType.VOTE);
            r0.add(MessageType.LOCATION);
            return r0;
        }
    }

    static {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "MessageCellConfig(build=" + this.a + ')';
    }

    public d(a r4) {
        Intrinsics.checkNotNullParameter(r4, "build");
        this.a = r4;
        this.b = true;
        this.c = true;
        this.d = -1;
        this.e = b.a();
        this.g = null;
        this.i = false;
        this.j = r4.e;
        this.c = r4.a;
        this.e = r4.c;
        this.d = r4.b;
        this.b = r4.d;
        this.f = null;
        this.h = false;
    }
}
