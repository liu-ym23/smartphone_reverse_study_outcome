package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.RichMediaType;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y {
    public final Map<Integer, z> a;

    public y(Message r10, String r11, f0 r12, e r13, l r14) {
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r13, "findCardSubPosition");
        Intrinsics.checkNotNullParameter(r14, "findCreationPosition");
        this.a = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(RichMediaType.CREATION.getValue()), new CreationItemDownloader(r10, r11, r12, r13, r14)), TuplesKt.to(Integer.valueOf(RichMediaType.GENERIC_IMAGE.getValue()), new b()), TuplesKt.to(Integer.valueOf(RichMediaType.GENERIC_VIDEO.getValue()), new d(r12))});
    }
}
