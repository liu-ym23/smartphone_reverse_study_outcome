package com.ss.android.lark.mention.base.impl.atselector.bean;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final List<? extends ChatChatter> a;
    public final List<UserGroupEntity> b;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "IMMentionResultModel(chatters=" + this.a + ", userGroups=" + this.b + ')';
    }

    public d() {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public d(List<? extends ChatChatter> r2, List<UserGroupEntity> r3) {
        Intrinsics.checkNotNullParameter(r2, "chatters");
        Intrinsics.checkNotNullParameter(r3, "userGroups");
        this.a = r2;
        this.b = r3;
    }
}
