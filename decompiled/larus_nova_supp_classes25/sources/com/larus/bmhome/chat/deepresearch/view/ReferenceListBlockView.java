package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.LruCache;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.adapter.MessageReferenceAdapter;
import com.larus.bmhome.chat.layout.widget.AtMostHeightRecyclerView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import com.larus.im.bean.message.TextCard;
import com.larus.im.bean.message.VideoCard;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SearchResultBlock;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusBlockItemReferenceListBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ReferenceListBlockView extends AbsBlockView {
    public Block b;
    public LarusBlockItemReferenceListBinding c;
    public MessageReferenceAdapter d;
    public final List<Object> e;
    public Message f;
    public BotModel g;
    public String h;
    public String i;
    public String j;
    public RecyclerView k;
    public boolean l;
    public Map<String, Boolean> m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void c() {
        this.b = null;
    }

    private final String getDataListIdentifier() {
        if (((ArrayList) this.e).isEmpty() == false) goto L6;
        return "";
    L6:
        Object r0 = CollectionsKt.firstOrNull(this.e);
        if ((r0 instanceof TextCard) == false) goto L11;
        return String.valueOf(((TextCard) r0).getId());
    L11:
        if ((r0 instanceof VideoCard) == false) goto L15;
        return String.valueOf(((VideoCard) r0).getId());
    L15:
        return String.valueOf(this.e.hashCode());
    }

    public final ChatParam g() {
        String r4 = this.j;
        String r3 = this.i;
        LruCache r0 = ko8.a.a;
        return new ChatParam(null, null, r3, r4, ko8.a.e(ko8.a.e), 227);
    }

    public ReferenceListBlockView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.e = new ArrayList();
        this.l = true;
    }

    public static String d(ReferenceListBlockView r0) {
        return r0.getDataListIdentifier();
    }

    public static oi8.n.a f(Object r4) {
        if ((r4 instanceof TextCard) == false) goto L7;
        TextCard r5 = (TextCard) r4;
        oi8.n.a r0 = new oi8.n.a(String.valueOf(r5.getId()), r5.getUrl(), r5.getDocId(), null);
    L9:
        return r0;
    L7:
        if ((r4 instanceof VideoCard) == false) goto L10;
        VideoCard r6 = (VideoCard) r4;
        r0 = new oi8.n.a(r6.getId(), r6.getMainSiteUrl(), r6.getItemId(), null);
        goto L9
    L10:
        return null;
    }

    public static Unit e(ReferenceListBlockView r23, boolean r24) {
        Message r1 = r23.f;
        if (r1 == null) goto L11;
        int r2 = oi8.n.a;
        ri8.c r3 = ri8.c.a;
        String r8 = ri8.c.g(Boolean.valueOf(!r24));
        BotModel r4 = r23.g;
        if (r4 == null) goto L7;
        String r5 = r4.getBotId();
    L8:
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        String r7 = r5;
        oi8.n.a(r1, r23.g(), null, 0, null, "simple_search", r7, r8, null, null, null, null, Boolean.TRUE, null, null, null, null, AbsBlockView.a.d(r23.b), null, null, null, 3923732);
        goto L11
    L7:
        r5 = null;
    L11:
        Map<String, Boolean> r6 = r23.m;
        if (r6 == null) goto L15;
        Boolean r0 = r6.put(r23.getDataListIdentifier(), Boolean.valueOf(r24));
    L15:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(final Block r9, Map<String, Object> r10) {
        this.b = r9;
        Boolean r0 = null;
        if (r10 == null) goto L5;
        Object r1 = r10.get("block_view_extra_message");
    L7:
        if ((r1 instanceof Message) == false) goto L9;
        Message r2 = (Message) r1;
    L10:
        this.f = r2;
        if (r10 == null) goto L13;
        Object r3 = r10.get("block_view_extra_bot_model");
    L15:
        if ((r3 instanceof BotModel) == false) goto L17;
        BotModel r4 = (BotModel) r3;
    L18:
        this.g = r4;
        if (r10 == null) goto L21;
        Object r5 = r10.get("block_view_extra_mob_research_id");
    L23:
        if ((r5 instanceof String) == false) goto L25;
        String r6 = (String) r5;
    L26:
        this.h = r6;
        if (r10 == null) goto L29;
        Object r7 = r10.get("block_view_extra_recycle_view");
    L31:
        if ((r7 instanceof RecyclerView) == false) goto L33;
        RecyclerView r8 = (RecyclerView) r7;
    L34:
        this.k = r8;
        if (r10 == null) goto L37;
        Object r11 = r10.get("block_view_extra_fold_states");
    L39:
        if (TypeIntrinsics.isMutableMap(r11) == false) goto L41;
        Map<String, Boolean> r12 = (Map) r11;
    L42:
        this.m = r12;
        if (r10 == null) goto L45;
        Object r13 = r10.get("block_view_extra_previous_page");
    L47:
        if ((r13 instanceof String) == false) goto L49;
        String r14 = (String) r13;
    L50:
        this.i = r14;
        if (r10 == null) goto L53;
        Object r15 = r10.get("block_view_extra_current_page");
    L55:
        if ((r15 instanceof String) == false) goto L57;
        String r16 = (String) r15;
    L58:
        this.j = r16;
        LarusBlockItemReferenceListBinding r17 = this.c;
        if (r17 == null) goto L92;
        AbsBlockView.a.e(r17.b, r9);
        we8.a.b(r17.c, i5.o(), false, null, null, 12);
        TextView r18 = r17.c;
        if (r9 == null) goto L67;
        BlockContent r19 = r9.getContent();
        if (r19 == null) goto L67;
        SearchResultBlock r20 = r19.getSearchResultBlock();
        if (r20 == null) goto L67;
        String r21 = r20.summary;
    L68:
        r18.setText(r21);
        ((ArrayList) this.e).clear();
        if (r9 == null) goto L85;
        BlockContent r110 = r9.getContent();
        if (r110 == null) goto L85;
        SearchResultBlock r111 = r110.getSearchResultBlock();
        if (r111 == null) goto L85;
        List r112 = r111.results;
        if (r112 == null) goto L85;
        Iterator r113 = r112.iterator();
    L78:
        if (r113.hasNext() == false) goto L85;
        Reference r22 = (Reference) r113.next();
        TextCard r23 = r22.getTextCard();
        if (r23 == null) goto L82;
        ((ArrayList) this.e).add(r23);
    L82:
        VideoCard r24 = r22.getVideoCard();
        if (r24 == null) goto L78;
        ((ArrayList) this.e).add(r24);
    L85:
        MessageReferenceAdapter r114 = this.d;
        if (r114 == null) goto L92;
        List<Object> r25 = this.e;
        Map<String, Boolean> r26 = this.m;
        if (r26 == null) goto L90;
        r0 = r26.get(getDataListIdentifier());
    L90:
        Intrinsics.checkNotNullParameter(r25, "list");
        r114.b.clear();
        r114.b.addAll(r25);
        r114.y2(r0);
        r114.notifyDataSetChanged();
    L67:
        r21 = null;
    L92:
        if (this.l == false) goto L105;
        LarusBlockItemReferenceListBinding r115 = this.c;
        if (r115 == null) goto L98;
        AtMostHeightRecyclerView r27 = r115.d;
        if (r27 == null) goto L98;
        y6.d(r27, new j1(this), new k1(this), this.k, new l1(this), 1);
    L98:
        ExposureTrackerExtKt.a(this, new m1(this, r9));
        this.l = false;
        return;
    L105:
        return;
    L57:
        r16 = null;
        goto L58
    L53:
        r15 = null;
        goto L55
    L49:
        r14 = null;
        goto L50
    L45:
        r13 = null;
        goto L47
    L41:
        r12 = null;
        goto L42
    L37:
        r11 = null;
        goto L39
    L33:
        r8 = null;
        goto L34
    L29:
        r7 = null;
        goto L31
    L25:
        r6 = null;
        goto L26
    L21:
        r5 = null;
        goto L23
    L17:
        r4 = null;
        goto L18
    L13:
        r3 = null;
        goto L15
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r16, AttributeSet r17) {
        Intrinsics.checkNotNullParameter(r16, "context");
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        View r1 = LayoutInflater.from(r16).inflate(2131561840, this, false);
        addView(r1);
        int r2 = 2131368711;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r1, 2131368711);
        if (r3 == null) goto L25;
        r2 = 2131368724;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r1, 2131368724);
        if (r4 == null) goto L25;
        r2 = 2131384404;
        AtMostHeightRecyclerView r5 = (AtMostHeightRecyclerView) ViewBindings.findChildViewById(r1, 2131384404);
        if (r5 == null) goto L25;
        this.c = new LarusBlockItemReferenceListBinding((LinearLayout) r1, r3, r4, r5);
        this.d = new MessageReferenceAdapter(false, new ArrayList(), new g1(this), r16, true, "default", false, false, new h1(this), 10, new i1(this));
        LarusBlockItemReferenceListBinding r6 = this.c;
        if (r6 == null) goto L13;
        AtMostHeightRecyclerView r7 = r6.d;
        if (r7 == null) goto L13;
        r7.setLayoutManager(new LinearLayoutManager(r16));
    L13:
        LarusBlockItemReferenceListBinding r8 = this.c;
        if (r8 == null) goto L18;
        AtMostHeightRecyclerView r9 = r8.d;
        if (r9 == null) goto L18;
        r9.setAdapter(this.d);
    L18:
        LarusBlockItemReferenceListBinding r10 = this.c;
        if (r10 == null) goto L26;
        AtMostHeightRecyclerView r11 = r10.d;
        if (r11 == null) goto L27;
        r11.addItemDecoration(new ReferenceListBlockView$init$4(this));
        return;
    L27:
        return;
    L26:
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r2)));
    }
}
