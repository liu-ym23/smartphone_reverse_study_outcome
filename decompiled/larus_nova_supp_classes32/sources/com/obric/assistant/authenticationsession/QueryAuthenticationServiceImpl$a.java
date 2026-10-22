package com.obric.assistant.authenticationsession;

import com.obric.assistant.AuthenticationType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class QueryAuthenticationServiceImpl$a {
    public final String a;
    public final int b;
    public final AuthenticationType c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof QueryAuthenticationServiceImpl$a) == true) goto L8;
        return false;
    L8:
        QueryAuthenticationServiceImpl$a r6 = (QueryAuthenticationServiceImpl$a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "AuthInfo(msgId=" + this.a + ", msgStatus=" + this.b + ", authType=" + this.c + ')';
    }

    public QueryAuthenticationServiceImpl$a(String r2, int r3, AuthenticationType r4) {
        Intrinsics.checkNotNullParameter(r2, "msgId");
        Intrinsics.checkNotNullParameter(r4, "authType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
