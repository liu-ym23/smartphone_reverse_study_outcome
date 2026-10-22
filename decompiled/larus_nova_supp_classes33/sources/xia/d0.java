package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d0 implements c {
    public static final d0 a = null;

    static {
        a = new d0();
    }

    public d0() {
    }

    @Override // xia.c
    public final int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof GroupChatEntity) == false) goto L12;
        GroupChatEntity r4 = (GroupChatEntity) r3;
        int r0 = r4.getName().hashCode() + 0;
        List r1 = r4.getContacts();
        if (r1 == null) goto L7;
        r0 = (r0 * 31) + r1.hashCode();
    L7:
        FileEntity r5 = r4.getAvatar();
        if (r5 != null) goto L10;
        return r0;
    L10:
        return (r0 * 31) + r5.hashCode();
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }
}
