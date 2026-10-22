package com.bytedance.android.live.emoji.online;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class HadesEmojiResManager$loadEmoji$1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, Boolean> {
    final /* synthetic */ boolean $needFilterRecentKeys;

    public HadesEmojiResManager$loadEmoji$1(boolean r1) {
        this.$needFilterRecentKeys = r1;
        super(1);
    }

    public final boolean invoke(Map.Entry<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (this.$needFilterRecentKeys == false) goto L7;
        LinkedHashMap<String, String> r0 = a.a;
        if (a.b.contains(r2.getKey()) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return Boolean.valueOf(invoke((Map.Entry) r1));
    }
}
