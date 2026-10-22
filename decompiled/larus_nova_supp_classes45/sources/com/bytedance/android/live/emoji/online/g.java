package com.bytedance.android.live.emoji.online;

import bolts.Continuation;
import bolts.Task;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmoji;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiResInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<TTaskResult, TContinuationResult> implements Continuation {
    public final /* synthetic */ OnlineSmallEmojiResManager a;
    public final /* synthetic */ String b;

    public g(OnlineSmallEmojiResManager r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object then(Task r15) {
        ALogger.d("OnlineEmojiResManager", "  preloadResourceInfo: " + this.b + ", result=" + ((OnlineSmallEmojiResInfo) r15.getResult()));
        OnlineSmallEmojiResInfo r16 = (OnlineSmallEmojiResInfo) r15.getResult();
        boolean r1 = false;
        if (r16 != null) goto L5;
    L50:
        this.a.f = 3;
        this.a.h = false;
        Unit r17 = Unit.INSTANCE;
    L51:
        return null;
    L5:
        if (r16.isValid() == true) goto L8;
        r16 = null;
    L8:
        if (r16 == null) goto L50;
        this.a.a = r16;
        List<OnlineSmallEmoji> r2 = r16.getStickers();
        if (r2 == null) goto L17;
        Iterator<T> r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        OnlineSmallEmoji r4 = (OnlineSmallEmoji) r3.next();
        ((LinkedHashMap) this.a.b.getValue()).put(r4.getDisplayName(), r4.getUri());
        if (r4.showInPanel() == false) goto L13;
        this.a.b().put(r4.getDisplayName(), r4.getUri());
    L17:
        OnlineSmallEmojiResManager r5 = this.a;
        int r6 = OnlineSmallEmojiCache.d;
        Intrinsics.checkNotNullParameter(r16, "resInfo");
        OnlineSmallEmojiCache r7 = new OnlineSmallEmojiCache(r16);
        LinkedHashMap<String, String> r8 = a.a;
        Intrinsics.checkNotNullParameter(r16, "info");
        a.c = r16;
        List<OnlineSmallEmoji> r18 = r16.getStickers();
        List<OnlineSmallEmoji> r9 = r18;
        if (r9 != null) goto L20;
    L21:
        r1 = true;
    L22:
        if (r1 == true) goto L35;
        LinkedHashMap r11 = new LinkedHashMap(256);
        Iterator r19 = SequencesKt.filter(CollectionsKt.asSequence(r18), HadesEmojiResManager$initEmojiNameMap$1.INSTANCE).iterator();
    L26:
        if (r19.hasNext() == false) goto L28;
        OnlineSmallEmoji r12 = (OnlineSmallEmoji) r19.next();
        r11.put(r12.getDisplayName(), r12.getUri());
        goto L26
    L28:
        Iterator r110 = CollectionsKt.listOf(new String[]{"[爱心]", "[赞]", "[看]", "[笑哭]", "[比心]", "[屎]", "[绝]", "[666]"}).iterator();
    L30:
        if (r110.hasNext() == false) goto L34;
        String r13 = (String) r110.next();
        String r14 = (String) r11.remove(r13);
        if (r14 == null) goto L30;
        a.a.put(r13, r14);
        goto L30
    L34:
        a.a.putAll(r11);
    L35:
        com.bytedance.android.live.emoji.utils.a r111 = com.bytedance.android.live.emoji.utils.a.a();
        r111.getClass();
        String r112 = r111.a.getString("recent_hades_emoji_list", "");     // Catch: Exception -> L42
        Gson r21 = com.bytedance.android.live.emoji.utils.d.a;     // Catch: Exception -> L42
        Intrinsics.checkNotNullParameter(String[].class, "clazz");     // Catch: Exception -> L42
        Object[] r113 = (Object[]) GsonProtectorUtils.fromJson(com.bytedance.android.live.emoji.utils.d.a, r112, String[].class);     // Catch: Exception -> L42
        if (r113 == null) goto L40;
        List<String> r114 = ArraysKt.toMutableList(r113);     // Catch: Exception -> L42
        if (r114 == null) goto L40;
    L43:
        if (r114 != null) goto L46;
        r114 = CollectionsKt.emptyList();
    L46:
        if (r114.size() >= 6) goto L49;
        r114 = CollectionsKt.listOf(new String[]{"[爱心]", "[赞]", "[大笑]", "[捂脸]", "[看]", "[屎]"});
    L49:
        a.b = r114;
        Unit r115 = Unit.INSTANCE;
        r5.d = r7;
        this.a.f = 2;
    L40:
        r114 = new ArrayList();     // Catch: Exception -> L42
    L42:
        r114 = null;
        goto L43
    L20:
        if (r9.isEmpty() == false) goto L22;
        goto L21
    }
}
