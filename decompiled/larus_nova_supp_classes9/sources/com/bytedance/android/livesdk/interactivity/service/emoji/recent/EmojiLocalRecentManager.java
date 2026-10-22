package com.bytedance.android.livesdk.interactivity.service.emoji.recent;

import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class EmojiLocalRecentManager {
    public static final e<c> a = null;
    public static List<? extends BaseEmoji> b;
    public static final Map<String, BaseEmoji> c = null;
    public static final ArrayList<String> d = null;
    public static LinkedHashMap<String, b> e;
    public static final EmojiLocalRecentManager f = null;

    public EmojiLocalRecentManager() {
    }

    static {
        f = new EmojiLocalRecentManager();
        a = new e("live_input_recent_emoji_data", new c(new ArrayList()));
        c = new HashMap();
        d = CollectionsKt.arrayListOf(new String[]{"[赞]", "[玫瑰]", "[捂脸]", "[666]", "[鼓掌]", "[呲牙]", "[微笑]", "[耶]", "[爱心]"});
    }

    public static List a() {
        List<? extends BaseEmoji> r0 = b;
        if (r0 != null) goto L5;
    L6:
        ab2.b.a().a.getClass();
        IMiddleWareHostEmoji r1 = k.f(IMiddleWareHostEmoji.class);
        if (r1 == null) goto L9;
        List<? extends BaseEmoji> r2 = r1.loadAllBaseEmoji();
    L10:
        b = r2;
        ((HashMap) c).clear();
        List<? extends BaseEmoji> r3 = b;
        if (r3 == null) goto L26;
        Iterator<T> r4 = r3.iterator();
    L14:
        if (r4.hasNext() == false) goto L26;
        BaseEmoji r5 = (BaseEmoji) r4.next();
        if (r5 == null) goto L14;
        String r6 = r5.getDescription();
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L14;
        Map<String, BaseEmoji> r8 = c;
        HashMap r9 = (HashMap) r8;
        r9.put(r5.getDescription(), r5);
        goto L14
    L20:
        if (r6.length() == 0) goto L23;
        r7 = false;
    L26:
        List<? extends BaseEmoji> r10 = b;
        if (r10 == null) goto L29;
        return r10;
    L29:
        return new ArrayList();
    L9:
        r2 = new ArrayList();
        goto L10
    L5:
        if (r0.isEmpty() != true) goto L26;
        goto L6
    }

    public static void c() {
        if (e != null) goto L12;
        e = new LinkedHashMap();
        Iterator r0 = b().iterator();
    L6:
        if (r0.hasNext() == false) goto L20;
        b r1 = (b) r0.next();
        String r2 = r1.b();
        if (r2 == null) goto L6;
        LinkedHashMap<String, b> r3 = e;
        if (r3 == null) goto L6;
        b r4 = r3.put(r2, r1);
        goto L6
    L20:
        return;
    }

    public static List b() {
        List r0 = a();
        List<b> r1 = ((c) a.getValue()).a();     // Catch: Throwable -> L7
        if (r1 != null) goto L8;
        r1 = new ArrayList();     // Catch: Throwable -> L7
    L8:
        int r6 = 0;
        if (r1.size() >= 8) goto L16;
        List<String> r2 = d.subList(0, 8 - r1.size());
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        r7.add(new b((String) r3.next(), 0, new ArrayList()));
        goto L12
    L14:
        r1.addAll(r7);
    L16:
        if (r1.size() >= 8) goto L28;
        pm0.b r4 = om0.c.f();
        if (r4 == null) goto L20;
        r4.e("EmojiLocalRecentManager", "recent data is error!");
    L20:
        Iterator r5 = r0.iterator();
        if (r5.hasNext() == false) goto L28;
        BaseEmoji r8 = (BaseEmoji) r5.next();
        int r9 = 8 - r1.size();
    L23:
        if (r6 >= r9) goto L28;
        b r10 = new b(r8.getDescription(), 0, new ArrayList());
        if (r1.contains(r10) == true) goto L27;
        r1.add(r10);
    L27:
        r6 = r6 + 1;
    L28:
        return r1;
    L7:
        r1 = new ArrayList();
        goto L8
    }

    public static void d(BaseEmoji r8) {
        Intrinsics.checkNotNullParameter(r8, "emoji");
        c();
        LinkedHashMap<String, b> r0 = e;
        if (r0 == null) goto L6;
        b r1 = r0.remove(r8.getDescription());
        if (r1 == null) goto L6;
    L7:
        r1.e(System.currentTimeMillis());
        final long r2 = System.currentTimeMillis() / 86400000;
        ArrayList<a> r3 = r1.c();
        if (r3 == null) goto L22;
        CollectionsKt.removeAll(r3, new EmojiLocalRecentManager$updateRecentEmoji$1(r2));
        a r4 = (a) CollectionsKt.lastOrNull(r3);
        if (r4 == null) goto L15;
        if (r4.b() != r2) goto L15;
        r4.c(r4.a() + 1);
    L18:
        LinkedHashMap<String, b> r5 = e;
        if (r5 == null) goto L23;
        b r9 = r5.put(r8.getDescription(), r1);
        return;
    L23:
        return;
    L15:
        if (r3.size() < 7) goto L17;
        ListProtector.remove(r3, 0);
        r3.add(new a(r2));
        goto L18
    L17:
        r3.add(new a(r2));
        goto L18
    L22:
        return;
    L6:
        r1 = new b(r8.getDescription(), 0, new ArrayList());
        goto L7
    }
}
