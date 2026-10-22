package com.bytedance.android.livesdk.interactivity.api.expression;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.w;
import com.bytedance.android.livesdk.interactivity.service.emoji.recent.EmojiLocalRecentManager;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v8 */
    @JvmStatic
    public static final List<BaseEmoji> b(int r13) {
        com.bytedance.android.livesdk.interactivity.service.emoji.recent.b r0 = null;
        com.bytedance.android.livesdk.interactivity.api.h r1 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r1 == null) goto L8;
        m<w> r2 = r1.getRecommendShortcutEmoji();
        if (r2 == null) goto L8;
        w r3 = (w) r2.getValue();
        if (r3 == null) goto L8;
    L9:
        if (r3 == null) goto L16;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.f> r4 = r3.emojiItems;
        if (r4 == null) goto L16;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.api.f> r5 = r4;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r7 = r5.iterator();
    L14:
        if (r7.hasNext() == false) goto L17;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.api.f r8 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.api.f) r7.next();
        r6.add(new fb2.b(r8.content, r8.score));
    L17:
        IMiddlewareHostBusiness r9 = jc1.k.f(IMiddlewareHostBusiness.class);
        if (r9 == null) goto L20;
        ?? r10 = r9.getRecommendEmojiList();
    L21:
        int r11 = ab2.a.a;
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.interactivity.service.emoji.recent.c> r14 = EmojiLocalRecentManager.a;
        IMiddlewareHostBusiness r15 = jc1.k.f(IMiddlewareHostBusiness.class);
        int r16 = 0;
        if (r15 != null) goto L24;
    L55:
        if (r10 != 0) goto L57;
    L61:
        if (r10 != 0) goto L78;
        r10 = new ArrayList();
        Iterator r17 = EmojiLocalRecentManager.b().iterator();
    L64:
        if (r17.hasNext() == false) goto L78;
        com.bytedance.android.livesdk.interactivity.service.emoji.recent.b r18 = (com.bytedance.android.livesdk.interactivity.service.emoji.recent.b) r17.next();
        ab2.b r19 = ab2.b.a();
        String r20 = r18.b();
        r19.a.getClass();
        IMiddleWareHostEmoji r21 = jc1.k.f(IMiddleWareHostEmoji.class);
        if (r21 == null) goto L68;
        List r23 = r21.loadAllBaseEmoji();
    L69:
        Iterator r24 = r23.iterator();
    L71:
        if (r24.hasNext() == false) goto L75;
        BaseEmoji r25 = (BaseEmoji) r24.next();
        if (r20.equals(r25.getDescription()) == false) goto L71;
    L76:
        if (r25 == null) goto L64;
        r10.add(r25);
        goto L64
    L75:
        r25 = null;
        goto L76
    L68:
        r23 = new ArrayList();
    L78:
        ?? r26 = r10;
        Iterator r27 = ((Iterable) r26).iterator();
    L80:
        if (r27.hasNext() == false) goto L89;
        Object r28 = r27.next();
        int r29 = r16 + 1;
        if (r16 >= 0) goto L84;
        CollectionsKt.throwIndexOverflow();
    L84:
        BaseEmoji r30 = (BaseEmoji) r28;
        r30.isLatestUseEmoji = true;
        r30.position = r16;
        BaseEmoji r31 = (BaseEmoji) ((HashMap) EmojiLocalRecentManager.c).get(r30.getDescription());
        if (r31 == null) goto L87;
        r30.recommendScore = r31.recommendScore;
    L87:
        r16 = r29;
    L89:
        return CollectionsKt.take((Iterable) r26, r13);
    L57:
        if ((!((Collection) r10).isEmpty()) != true) goto L61;
        if (r10.size() <= 8) goto L61;
        r10 = r10.subList(0, 8);
        goto L61
    L24:
        if (r15.isEnablePersonalRecommend() != true) goto L55;
        if (r6 != null) goto L27;
    L30:
        boolean r33 = true;
    L31:
        if (r33 == true) goto L55;
        EmojiLocalRecentManager.c();
        LinkedHashMap<String, com.bytedance.android.livesdk.interactivity.service.emoji.recent.b> r34 = EmojiLocalRecentManager.e;
        int r35 = fb2.e.a;
        if (r34 != null) goto L35;
        r26 = CollectionsKt.emptyList();
        goto L89
    L35:
        Iterator<Map.Entry<String, com.bytedance.android.livesdk.interactivity.service.emoji.recent.b>> r36 = r34.entrySet().iterator();
    L37:
        if (r36.hasNext() == false) goto L43;
        Map.Entry<String, com.bytedance.android.livesdk.interactivity.service.emoji.recent.b> r37 = r36.next();
        if (r0 == null) goto L42;
        if (r37.getValue().d() <= r0.d()) goto L37;
    L42:
        r0 = r37.getValue();
        goto L37
    L43:
        if (r0 == null) goto L45;
        long r38 = r0.d();
    L46:
        long r39 = Math.max(1, r38);
        HashMap r40 = new HashMap();
        if (r6 == null) goto L54;
        Iterator r41 = r6.iterator();
    L50:
        if (r41.hasNext() == false) goto L54;
        fb2.b r43 = (fb2.b) r41.next();
        String r44 = r43.a;
        if (r44 == null) goto L50;
        r40.put(r44, r43);
    L54:
        r26 = new ArrayList();
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.interactivity.service.emoji.recent.c> r45 = EmojiLocalRecentManager.a;
        r26.addAll(EmojiLocalRecentManager.a());
        CollectionsKt.sortWith(r26, new fb2.d(r34, r40, r39, (db2.b) com.bytedance.android.livesdk.interactivity.service.settings.h.a.getValue()));
        goto L89
    L45:
        r38 = 0;
        goto L46
    L27:
        if (r6.isEmpty() == true) goto L30;
        r33 = false;
        goto L31
    L20:
        r10 = 0;
    L16:
        r6 = null;
    L8:
        r3 = (w) l42.a.j.getValue();
        goto L9
    }

    public static com.bytedance.android.live.core.widget.j a(Context r1, com.bytedance.android.live.base.model.message.h r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "guideChat");
        Intrinsics.checkNotNullParameter(r3, "text");
        com.bytedance.android.live.core.widget.j r4 = new com.bytedance.android.live.core.widget.j(r1);
        r4.setText(r3);
        r4.setTextColor(s1.h(2131107592));
        return r4;
    }
}
