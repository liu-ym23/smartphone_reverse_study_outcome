package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s {
    public long a;
    public long b;
    public final Map<String, Long> c;
    public final Map<String, Boolean> d;
    public String e;
    public String f;

    public s() {
        this.c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ksong", 0L), TuplesKt.to("clean_screen", 0L), TuplesKt.to("record", 0L), TuplesKt.to("key_board", 0L)});
        Boolean r1 = Boolean.FALSE;
        this.d = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ksong", r1), TuplesKt.to("clean_screen", r1), TuplesKt.to("record", r1), TuplesKt.to("key_board", r1)});
        this.e = "auto";
        this.f = "more";
    }
}
