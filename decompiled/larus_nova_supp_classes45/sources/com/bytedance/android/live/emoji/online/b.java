package com.bytedance.android.live.emoji.online;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements r90.c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // r90.c
    public final int c() {
        OnlineSmallEmojiResManager r0 = OnlineSmallEmojiResManager.i;
        return OnlineSmallEmojiResManager.i.b().size();
    }

    @Override // r90.c
    public final List b(List r8) {
        if (r8 == null) goto L35;
        OnlineSmallEmojiResManager r0 = OnlineSmallEmojiResManager.i;
        if (r0.d() == false) goto L48;
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L19;
        String r2 = (String) r9.next();
        String r3 = r0.b().get(r2);
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L8;
        r1.put(r2, r3);
        goto L8
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
        goto L16
    L19:
        if (r1.size() >= 8) goto L30;
        LinkedHashMap<String, String> r11 = r0.b();
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();
    L22:
        if (r12.hasNext() == false) goto L26;
        Map.Entry<String, String> r6 = r12.next();
        if (r1.keySet().contains(r6.getKey()) == true) goto L22;
        r5.put(r6.getKey(), r6.getValue());
        goto L22
    L26:
        Iterator r13 = CollectionsKt.take(r5.entrySet(), 8 - r1.size()).iterator();
    L28:
        if (r13.hasNext() == false) goto L30;
        Map.Entry r7 = (Map.Entry) r13.next();
        r1.put(r7.getKey(), r7.getValue());
    L30:
        ArrayList r14 = new ArrayList();
        Iterator r15 = r1.entrySet().iterator();
    L32:
        if (r15.hasNext() == false) goto L49;
        Map.Entry r16 = (Map.Entry) r15.next();
        BaseEmoji r17 = new BaseEmoji();
        r17.setDescription((String) r16.getKey());
        r17.setLocalFilePath(r0.c((String) r16.getValue()));
        Unit r18 = Unit.INSTANCE;
        r14.add(r17);
        goto L32
    L49:
        return r14;
    L48:
        return new ArrayList();
    L35:
        return new ArrayList();
    }

    @Override // r90.c
    public final List d(int r9) {
        OnlineSmallEmojiResManager r0 = OnlineSmallEmojiResManager.i;
        if (r0.d() == false) goto L28;
        ArrayList r1 = new ArrayList();
        if (r0.b().size() <= 0) goto L23;
        Iterator<Map.Entry<String, String>> r2 = r0.b().entrySet().iterator();
        int r3 = 0;
        int r4 = 0;
    L10:
        if (r2.hasNext() == false) goto L18;
        Map.Entry<String, String> r5 = r2.next();
        if (r4 >= 0) goto L14;
    L16:
        r4 = r4 + 1;
        if (r4 < (0 + r9)) goto L10;
    L14:
        if (r4 >= (0 + r9)) goto L16;
        BaseEmoji r6 = new BaseEmoji();
        r6.setDescription(r5.getKey());
        r6.setLocalFilePath(r0.c(r5.getValue()));
        Unit r7 = Unit.INSTANCE;
        r1.add(r6);
    L18:
        int r11 = r9 - r1.size();
        if (r11 <= 0) goto L23;
    L20:
        if (r3 >= r11) goto L23;
        r1.add(new BaseEmoji());
        r3 = r3 + 1;
    L23:
        return r1;
    L28:
        return new ArrayList();
    }

    @Override // r90.c
    public final Drawable a(Context r5, String r6) {
        if (r5 == null) goto L40;
        if (r6 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L41;
        OnlineSmallEmojiResManager r2 = OnlineSmallEmojiResManager.i;
        if (r2.d() == false) goto L34;
        OnlineSmallEmojiCache r3 = r2.d;
        if (r3 == null) goto L34;
        if (r2.d() == false) goto L22;
        String r4 = (String) ((LinkedHashMap) r2.b.getValue()).get(r6);
        if (r4 != null) goto L23;
        ALogger.d("OnlineEmojiResManager", "  mapResource not found: " + r6);
    L23:
        int r7 = OnlineSmallEmojiCache.d;
        if (r4 == null) goto L34;
        monitor-enter(r3);
        Bitmap r8 = (Bitmap) ((LruCache) r3.a.getValue()).get(r4);     // Catch: Throwable -> L31
        monitor-exit(r3);
        if (r8 != null) goto L35;
        r8 = r3.a(r4);
    L35:
        if (r8 != null) goto L37;
        return null;
    L37:
        return new BitmapDrawable(r5.getResources(), r8);
    L31:
        th = move-exception;
        throw th;
    L22:
        r4 = null;
    L34:
        r8 = null;
        goto L35
    L41:
        return null;
    L6:
        if (r6.length() == 0) goto L9;
        r1 = false;
        goto L10
    L40:
        return null;
    }
}
