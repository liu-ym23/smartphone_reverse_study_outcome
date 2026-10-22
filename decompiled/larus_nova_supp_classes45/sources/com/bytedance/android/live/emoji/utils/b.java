package com.bytedance.android.live.emoji.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public List<? extends BaseEmoji> a;
    public final ArrayList<String> b;

    public static final class a {
    }

    static {
    }

    public final List<BaseEmoji> a() {
        List<? extends BaseEmoji> r0 = this.a;
        if (r0 != null) goto L5;
    L6:
        this.a = r90.a.a().b();
    L7:
        Iterable r1 = this.a;
        if (r1 != null) goto L10;
        r1 = new ArrayList();
    L10:
        List r2 = (List) com.bytedance.android.livesdk.sharedpref.b.C1.getValue();
        int r3 = 0;
        if (r2.size() >= 8) goto L13;
        r2.addAll(this.b.subList(0, 8 - r2.size()));
    L13:
        LinkedHashSet r4 = new LinkedHashSet();
        Iterator r5 = r2.iterator();
    L15:
        if (r5.hasNext() == false) goto L27;
        String r6 = (String) r5.next();
        Iterator r7 = r1.iterator();
    L18:
        if (r7.hasNext() == false) goto L22;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(((BaseEmoji) r8).getDescription(), r6) == false) goto L18;
    L23:
        BaseEmoji r9 = (BaseEmoji) r8;
        if (r9 == null) goto L15;
        r4.add(r9);
        goto L15
    L22:
        r8 = null;
        goto L23
    L27:
        if (r4.size() >= 8) goto L37;
        ALogger.e("EmojiLocalRecentManager", "recent data is error!");
        Iterator r11 = r1.iterator();
        if (r11.hasNext() == false) goto L37;
        BaseEmoji r12 = (BaseEmoji) r11.next();
        int r13 = 8 - r4.size();
    L31:
        if (r3 >= r13) goto L37;
        if (r4.contains(r12) == true) goto L35;
        r4.add(r12);
    L35:
        r3 = r3 + 1;
    L37:
        return CollectionsKt.toList(r4);
    L5:
        if (r0.isEmpty() != true) goto L7;
        goto L6
    }

    public b() {
        this.b = CollectionsKt.arrayListOf(new String[]{"[赞]", "[玫瑰]", "[捂脸]", "[666]", "[鼓掌]", "[呲牙]", "[微笑]", "[耶]", "[爱心]"});
    }
}
