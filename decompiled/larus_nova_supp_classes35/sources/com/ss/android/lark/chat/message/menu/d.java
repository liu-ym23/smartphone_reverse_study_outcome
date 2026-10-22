package com.ss.android.lark.chat.message.menu;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import yya.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public final List<? extends zya.e> a;
    public final Map<MessageActionType, ? extends List<zya.b>> b;
    public final boolean c;
    public final Map<MessageActionType, List<i>> d;
    public final List<yya.e> e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((r0 + r1) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "MessageActionParseResult(actionList=" + this.a + ", typeToVOList=" + this.b + ", showReaction=" + this.c + ", actionsMapIncludingGone=" + this.d + ", featureInterceptors=" + this.e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends zya.e> r2, Map<MessageActionType, ? extends List<zya.b>> r3, boolean r4, Map<MessageActionType, ? extends List<? extends i>> r5, List<? extends yya.e> r6) {
        Intrinsics.checkNotNullParameter(r2, "actionList");
        Intrinsics.checkNotNullParameter(r3, "typeToVOList");
        Intrinsics.checkNotNullParameter(r5, "actionsMapIncludingGone");
        Intrinsics.checkNotNullParameter(r6, "featureInterceptors");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
