package v4b;

import com.ss.android.lark.chat.entity.message.MessageLink;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int k = 0;
    public final a a;
    public final float b;
    public final int c;
    public final List<MessageType> d;
    public final boolean e;
    public final boolean f;
    public final MessageLink.ChatInfo g;
    public final boolean h;
    public final boolean i;
    public final boolean j;

    public static final class a {
        public final int a;
        public final float b;
        public List<MessageType> c;
        public boolean d;
        public boolean e;
        public boolean f;

        public a() {
            this.a = 32;
            this.b = 12.0f;
            int r0 = c.k;
            ArrayList r1 = new ArrayList();
            r1.add(MessageType.FILE);
            r1.add(MessageType.FOLDER);
            r1.add(MessageType.MERGE_FORWARD);
            this.c = r1;
            this.d = true;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        new b();
    }

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
        return "MessageBubbleConfig(build=" + this.a + ')';
    }

    public c(a r3) {
        Intrinsics.checkNotNullParameter(r3, "build");
        this.a = r3;
        this.b = 16.0f;
        this.c = 32;
        UIHelper.dp2px(150.0f);
        ArrayList r0 = new ArrayList();
        r0.add(MessageType.FILE);
        r0.add(MessageType.FOLDER);
        r0.add(MessageType.MERGE_FORWARD);
        this.d = r0;
        this.e = true;
        this.f = true;
        this.g = null;
        this.h = r3.e;
        this.i = false;
        this.j = r3.f;
        this.c = r3.a;
        this.b = r3.b;
        this.d = r3.c;
        this.e = r3.d;
    }
}
