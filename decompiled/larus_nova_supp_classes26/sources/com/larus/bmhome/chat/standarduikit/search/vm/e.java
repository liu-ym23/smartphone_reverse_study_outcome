package com.larus.bmhome.chat.standarduikit.search.vm;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.helper.t0;
import com.larus.bmhome.chat.layout.holder.helper.v1;
import com.larus.bmhome.chat.layout.holder.menu.item.n0;
import com.larus.bmhome.chat.layout.holder.menu.item.p;
import com.larus.bmhome.chat.layout.holder.menu.item.x;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.bmhome.view.screenmenu.y;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.SearchVideoItem;
import com.larus.platform.api.CachedVideosPreloadFrom;
import com.larus.platform.api.OuterFallbackInfo;
import com.larus.platform.api.PrefetchRecommendVideoParam;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.VideoParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public final kc8.b a;
    public final Lazy b;
    public final Lazy c;
    public String d;
    public final Set<Integer> e;

    public static final class a implements t0 {
        public a() {
        }

        public final void b(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "keys");
        }

        public final List<ot8.a> a(Context r1, Message r2, Function0<Message> r3, q0 r4, BotModel r5, wc9.e r6, q0.a r7, JSONObject r8) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "data");
            Intrinsics.checkNotNullParameter(r5, "chatBot");
            ArrayList r9 = new ArrayList();
            r9.add(new y(x.a(r2), p.a(r2)));
            Intrinsics.checkNotNullParameter(r1, "context");
            r9.add(new i0(0, ContextCompat.getColor(r1, v19.c.b(2130972086, null, 2131103159))));
            r9.add(n0.a());
            r9.addAll(com.larus.bmhome.chat.layout.holder.menu.item.n.b(new com.larus.bmhome.chat.layout.holder.menu.item.n(), r1, r5, false, 8));
            v1.a(r9);
            v1.b(r9, r7);
            return com.larus.bmhome.chat.layout.holder.helper.e.b(r9);
        }
    }

    public e(kc8.b r1) {
        this.a = r1;
        this.b = LazyKt.lazy(new b(this));
        this.c = LazyKt.lazy(new c(this));
        this.e = new LinkedHashSet();
    }

    public final PrefetchRecommendVideoParam a(boolean r35, int r36, List<SearchVideoItem> r37, SearchVideoItem r38, final Message r39, boolean r40, OuterFallbackInfo r41) {
        AppHost.Companion r2 = AppHost.a;
        if (r2.isOversea() == false) goto L6;
        return null;
    L6:
        if (r2.isPlugin() == false) goto L8;
        return null;
    L8:
        String r3 = r39.getMessageId();
        if (r3 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        return null;
    L17:
        if (r36 == 0) goto L20;
        if (r35 == false) goto L20;
        return null;
    L20:
        if (r40 == false) goto L22;
        VideoParam.RecommendType r5 = VideoParam.RecommendType.Search;
    L24:
        if (r5 == VideoParam.RecommendType.Search) goto L27;
        return null;
    L27:
        if (Intrinsics.areEqual(this.d, r39.getMessageId()) == false) goto L30;
        if (r35 == false) goto L30;
        return null;
    L30:
        List<SearchVideoItem> r6 = r37;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L32:
        if (r8.hasNext() == false) goto L34;
        SearchVideoItem r9 = (SearchVideoItem) r8.next();
        r7.add(new MediaEntity(null, r9.itemId, null, null, null, null, null, null, null, null, null, null, r9.sourceFrom, null, null, null, 0, null, null, null, null, null, null, null, 16773117, null));
        goto L32
    L34:
        this.d = r39.getMessageId();
        CachedVideosPreloadFrom r12 = CachedVideosPreloadFrom.BIND_PULL_API;
        String r10 = r39.getMessageId();
        String r11 = r39.getReplyId();
        String r13 = r38.itemId;
        if (r13 != null) goto L37;
        r13 = "";
    L37:
        List r14 = CollectionsKt.listOf(r13);
        ArrayList r15 = new ArrayList();
        Iterator r16 = r7.iterator();
    L39:
        if (r16.hasNext() == false) goto L43;
        String r17 = ((MediaEntity) r16.next()).getItem_id();
        if (r17 == null) goto L39;
        r15.add(r17);
        goto L39
    L43:
        kc8.b r18 = this.a;
        if (r18 == null) goto L50;
        kc8.y r19 = r18.a;
        if (r19 == null) goto L50;
        q0 r20 = r19.x;
        if (r20 == null) goto L50;
        List<Message> r21 = r20.getCurrentList();
    L51:
        boolean r22 = xc8.m.b(r39, r21);
        kc8.b r23 = this.a;
        if (r23 == null) goto L58;
        kc8.y r24 = r23.a;
        if (r24 == null) goto L58;
        q0 r25 = r24.x;
        if (r25 == null) goto L58;
        List<Message> r26 = r25.getCurrentList();
    L59:
        String r110 = xc8.m.a(r26);
        return new PrefetchRecommendVideoParam(r10, r11, Boolean.valueOf(r40), r14, 0, r12, r15, new d(r39, this), Boolean.valueOf(r22), r110, false, null, r41, false, null, 27648, null);
    L58:
        r26 = null;
    L50:
        r21 = null;
        goto L51
    L22:
        r5 = VideoParam.RecommendType.Non;
        goto L24
    L11:
        if (r3.length() == 0) goto L14;
        r4 = false;
        goto L15
    }
}
