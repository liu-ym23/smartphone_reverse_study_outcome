package com.larus.bmhome.chat.list.cell.text.user;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class UserTextCell$a {
    public final Message a;
    public final NestedFileContent b;
    public final UplinkFileEntity c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UserTextCell$a) == true) goto L8;
        return false;
    L8:
        UserTextCell$a r6 = (UserTextCell$a) r5;
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
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "AttachmentReferenceTarget(message=" + this.a + ", content=" + this.b + ", entity=" + this.c + ')';
    }

    public UserTextCell$a(Message r2, NestedFileContent r3, UplinkFileEntity r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "entity");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
