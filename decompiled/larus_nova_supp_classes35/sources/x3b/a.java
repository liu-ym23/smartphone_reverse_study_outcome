package x3b;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final boolean update(Chatter r3, Chatter r4) {
        Intrinsics.checkNotNullParameter(r3, "target");
        Intrinsics.checkNotNullParameter(r4, "pushedChatter");
        if (Intrinsics.areEqual(r3.getId(), r4.getId()) == true) goto L5;
        return false;
    L5:
        UserPrivateDescription r5 = r4.getPrivateDescription();
        if (Intrinsics.areEqual(r3.getPrivateDescription(), r5) == false) goto L8;
        return false;
    L8:
        r3.setPrivateDescription(r5);
        return true;
    }
}
