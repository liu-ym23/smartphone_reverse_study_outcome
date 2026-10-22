package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.Command;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c<Resp> extends a {
    public final Message.a<?, ?> e;
    public final ProtoAdapter<Resp> f;

    public c(Message.a r19, ProtoAdapter r110, Command r20, com.lark.kmp.server.pb.improto.Command r21, int r22) {
        if ((r22 & 8) == 0) goto L9;
        int r4 = jy7.a.a;
        IntRange r5 = new IntRange(1, 10);
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        IntIterator r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L8;
        r6.nextInt();
        r8.add(Character.valueOf("abcdefghijklmnopqrstuvwxyz0123456789".charAt(Random.Default.nextInt(0, 36))));
        goto L6
    L8:
        String r7 = CollectionsKt.joinToString$default(r8, "", null, null, 0, null, null, 62, null);
    L11:
        if ((r22 & 64) == 0) goto L13;
        com.lark.kmp.server.pb.improto.Command r9 = null;
    L14:
        Intrinsics.checkNotNullParameter(r19, "requestMessageBuilder");
        Intrinsics.checkNotNullParameter(r110, "responseProtoAdapter");
        Intrinsics.checkNotNullParameter(r20, "command");
        Intrinsics.checkNotNullParameter(r7, "contextId");
        super(r20, r7, null, r9);
        this.e = r19;
        this.f = r110;
        return;
    L13:
        r9 = r21;
        goto L14
    L9:
        r7 = null;
        goto L11
    }
}
