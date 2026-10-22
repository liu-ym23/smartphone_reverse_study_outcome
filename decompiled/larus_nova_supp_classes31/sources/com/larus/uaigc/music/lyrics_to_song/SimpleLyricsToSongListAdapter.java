package com.larus.uaigc.music.lyrics_to_song;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.music.widget.LyricsToSongCardView;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.im.bean.message.block.MusicCreationContentList;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u008b\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00122\u0010\u000b\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r0\fj\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r`\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\"\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e0\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e`\u0016¢\u0006\u0004\b\u0017\u0010\u0018JT\u0010 \u001a\u00020!2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n22\u0010\u000b\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r0\fj\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r`\u0010J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000eH\u0017J\b\u0010(\u001a\u00020\u000eH\u0016J\u0018\u0010)\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u000eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010\u000b\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r0\fj\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e0\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000e`\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001ej\b\u0012\u0004\u0012\u00020\u0002`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/uaigc/music/lyrics_to_song/SimpleLyricsToSongListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/uaigc/music/lyrics_to_song/SimpleLyricsToSongListViewHolder;", "data", "Lcom/larus/im/bean/message/Message;", "modelProvider", "Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;", "parsed", "Lcom/larus/im/bean/message/block/MusicCreationContentList;", "listLoading", "", "mapIndexed", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "Lkotlin/collections/ArrayList;", "outAdapter", "Lcom/larus/bmhome/chat/api/MessageAdapter;", "mobShowCountMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "<init>", "(Lcom/larus/im/bean/message/Message;Lcom/larus/bmhome/chat/api/MessageAdapter$ModelProvider;Lcom/larus/im/bean/message/block/MusicCreationContentList;ZLjava/util/ArrayList;Lcom/larus/bmhome/chat/api/MessageAdapter;Ljava/util/HashMap;)V", "getMapIndexed", "()Ljava/util/ArrayList;", "setMapIndexed", "(Ljava/util/ArrayList;)V", "holderGroup", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "updateDiff", "", "onViewDetachedFromWindow", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SimpleLyricsToSongListAdapter extends RecyclerView.Adapter<SimpleLyricsToSongListViewHolder> {
    public static final /* synthetic */ int h = 0;
    public Message a;
    public final q0.a b;
    public boolean c;
    public ArrayList<Pair<Integer, MusicCreationContent>> d;
    public final q0 e;
    public final HashMap<String, Integer> f;
    public final HashSet<SimpleLyricsToSongListViewHolder> g;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.d.size();
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r3) {
        SimpleLyricsToSongListViewHolder r4 = (SimpleLyricsToSongListViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        super.onViewDetachedFromWindow(r4);
        Integer r5 = r4.b;
        if (r5 == null) goto L6;
        String r6 = r5.toString();
        if (r6 == null) goto L6;
    L7:
        Integer r0 = this.f.get(r6);
        if (r0 == null) goto L10;
        int r1 = r0.intValue();
    L11:
        this.f.put(r6, Integer.valueOf(r1 + 1));
        return;
    L10:
        r1 = 0;
    L6:
        r6 = "-1";
        goto L7
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        final SimpleLyricsToSongListViewHolder r13 = (SimpleLyricsToSongListViewHolder) r11;
        Intrinsics.checkNotNullParameter(r13, "holder");
        FLogger.a.i("SimpleLyricsToSongListAdapter", "binding holder position " + r12 + " list loading " + this.c + " map size " + this.d.size());
        Pair r0 = (Pair) CollectionsKt.firstOrNull(this.d);
        if (r0 == null) goto L9;
        MusicCreationContent r1 = (MusicCreationContent) r0.getSecond();
        if (r1 == null) goto L9;
        ad9.b r2 = r1.getPlayList();
        if (r2 == null) goto L9;
        String r3 = r2.getItemId();
    L10:
        LyricsToSongCardView.j(r13.a, this.a, this.b, (MusicCreationContent) ((Pair) ListProtector.get(this.d, r12)).getSecond(), ((Number) ((Pair) ListProtector.get(this.d, r12)).getFirst()).intValue(), r3, null, new o(r13), 32);
        Message r4 = this.a;
        if (r4 == null) goto L13;
        IAIChatUgcAIGCService.a.h0(r13.a, r4, this.e, this.b);
    L13:
        r13.b = Integer.valueOf(r12);
        return;
    L9:
        r3 = null;
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        SimpleLyricsToSongListViewHolder r4 = new SimpleLyricsToSongListViewHolder(new LyricsToSongCardView(r2.getContext()));
        r4.a.setOnTouchListener(new q());
        r4.a.setRebindListener(new r(this));
        this.g.add(r4);
        return r4;
    }

    public SimpleLyricsToSongListAdapter(Message r2, q0.a r3, MusicCreationContentList r4, boolean r5, ArrayList<Pair<Integer, MusicCreationContent>> r6, q0 r7, HashMap<String, Integer> r8) {
        Intrinsics.checkNotNullParameter(r3, "modelProvider");
        Intrinsics.checkNotNullParameter(r4, "parsed");
        Intrinsics.checkNotNullParameter(r6, "mapIndexed");
        Intrinsics.checkNotNullParameter(r8, "mobShowCountMap");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = new HashSet();
    }
}
