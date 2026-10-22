package com.bytedance.android.live.emoji.online;

import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiResInfo;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livehostapi/business/model/emoji/BaseEmoji;", "it", "", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class HadesEmojiResManager$loadEmoji$2 extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, BaseEmoji> {
    public static final HadesEmojiResManager$loadEmoji$2 INSTANCE = null;

    static {
        INSTANCE = new HadesEmojiResManager$loadEmoji$2();
    }

    public HadesEmojiResManager$loadEmoji$2() {
        super(1);
    }

    public final BaseEmoji invoke(Map.Entry<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        BaseEmoji r0 = new BaseEmoji();
        r0.setDescription(r5.getKey());
        LinkedHashMap<String, String> r1 = a.a;
        String r6 = r5.getValue();
        OnlineSmallEmojiResInfo r2 = a.c;
        if (r2 == null) goto L8;
        String r3 = r2.getPicFileDirPath();
        if (r3 == null) goto L8;
        String r7 = "file://" + r3 + File.separator + r6;
    L9:
        r0.setLocalFilePath(r7);
        return r0;
    L8:
        r7 = "";
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Map.Entry) r1);
    }
}
