package com.larus.bmhome.music.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.music.databinding.LarusViewMusicLyricVThreeBinding;
import com.larus.im.bean.message.block.LyricsSeekContent;
import com.larus.im.bean.message.block.LyricsUtterances;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 32\u00020\u0001:\u0003345B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJD\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u00112\u0006\u0010\"\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0010\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0013H\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u0018H\u0002J\b\u0010,\u001a\u00020\u0018H\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0007H\u0002J\u000e\u00100\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0007J\u0006\u00101\u001a\u00020\u001eJ\u0006\u00102\u001a\u00020\u001eR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicBoxLyricView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/music/databinding/LarusViewMusicLyricVThreeBinding;", "getBinding", "()Lcom/larus/bmhome/music/databinding/LarusViewMusicLyricVThreeBinding;", "binding$delegate", "Lkotlin/Lazy;", "lyricsSeekContent", "Lcom/larus/im/bean/message/block/LyricsSeekContent;", "fallbackLyrics", "", "", "curLyricIndex", "curProgress", "playing", "", "isEmpty", "isError", "authorLine", "clickListener", "Lkotlin/Function0;", "", "bindLyrics", "lyricsState", "content", "fallback", "longClickBinder", "clickEvent", "utterancesFilterByLyricsCode", "Lcom/larus/im/bean/message/block/LyricsUtterances;", "displayingIndex", "displayNextLine", "displayCurrentLine", "tryDisplayNextLine", "hasNextLine", "reachNextLine", "resetStatus", "seekTo", "progress", "updateProgress", "readyState", "playState", "Companion", "LyricsLineHolder", "BaseLyricsAdapter", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicBoxLyricView extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;
    public final Lazy a;
    public LyricsSeekContent b;
    public List<String> c;
    public int d;
    public int e;
    public boolean f;
    public String g;
    public Function0<Unit> h;
    public int i;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\rJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicBoxLyricView$BaseLyricsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/music/widget/MusicBoxLyricView$LyricsLineHolder;", "lyrics", "", "", "longClickBinder", "Lkotlin/Function0;", "", "<init>", "(Lcom/larus/bmhome/music/widget/MusicBoxLyricView;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "holderPositionMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "currentHighLight", "highLight", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "getItemCount", "onBindViewHolder", "holder", "onViewRecycled", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class BaseLyricsAdapter extends RecyclerView.Adapter<LyricsLineHolder> {
        public final List<String> a;
        public final Function0<Unit> b;
        public final HashMap<Integer, LyricsLineHolder> c;
        public final /* synthetic */ MusicBoxLyricView d;

        public final int getItemCount() {
            if ((!this.a.isEmpty()) == true) goto L7;
            return 0;
        L7:
            return this.a.size() + 1;
        }

        public final int getItemViewType(int r1) {
            if (r1 == 0) goto L4;
        L6:
            return 0;
        L4:
            if (TextUtils.isEmpty(this.d.g) == false) goto L6;
            return 1;
        }

        public final void onViewRecycled(RecyclerView.ViewHolder r3) {
            LyricsLineHolder r4 = (LyricsLineHolder) r3;
            Intrinsics.checkNotNullParameter(r4, "holder");
            super.onViewRecycled(r4);
            r4.a.setTextColor(ContextCompat.getColor(this.d.getContext(), 2131106540));
        }

        public final void y2(int r6) {
            int r0 = this.a.size() + 1;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L10;
            LyricsLineHolder r2 = this.c.get(Integer.valueOf(r1));
            if (r2 == null) goto L9;
            TextView r3 = r2.a;
            if (r3 == null) goto L9;
            r3.setTextColor(ContextCompat.getColor(this.d.getContext(), 2131106540));
        L9:
            r1 = r1 + 1;
            goto L3
        L10:
            int r4 = r6 + 1;
            if (r4 >= getItemCount()) goto L24;
            if (r6 < 0) goto L27;
            LyricsLineHolder r7 = this.c.get(Integer.valueOf(r4));
            if (r7 == null) goto L25;
            TextView r8 = r7.a;
            if (r8 == null) goto L26;
            r8.setTextColor(ContextCompat.getColor(this.d.getContext(), 2131103298));
            return;
        L26:
            return;
        L25:
            return;
        L27:
            return;
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [android.view.ViewGroup, com.larus.bmhome.music.widget.MusicBoxLyricView] */
        public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            LyricsLineHolder r5 = (LyricsLineHolder) r3;
            Intrinsics.checkNotNullParameter(r5, "holder");
            this.c.put(Integer.valueOf(r4), r5);
            if (r4 <= this.a.size()) goto L5;
            r5.a.setText("");
            return;
        L5:
            if (r4 != 0) goto L7;
            r5.a.setText(this.d.g);
        L13:
            r5.a.setOnLongClickListener(new l0(this));
            return;
        L7:
            int r6 = r4 - 1;
            r5.a.setText((CharSequence) ListProtector.get(this.a, r6));
            ?? r0 = this.d;
            if (r0.d == r6) goto L10;
        L12:
            r5.a.setTextColor(ContextCompat.getColor(r0.getContext(), 2131106540));
            goto L13
        L10:
            if (r0.f == false) goto L12;
            r5.a.setTextColor(ContextCompat.getColor(r0.getContext(), 2131103298));
            goto L13
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            if (r5 != 1) goto L5;
            View r6 = LayoutInflater.from(r4.getContext()).inflate(2131563215, r4, false);
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.TextView");
            TextView r7 = (TextView) r6;
            final MusicBoxLyricView r8 = this.d;
            com.larus.utils.e1.d(r7, new j0(r8));
            return new LyricsLineHolder(r7);
        L5:
            View r9 = LayoutInflater.from(r4.getContext()).inflate(2131563217, r4, false);
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.widget.TextView");
            TextView r10 = (TextView) r9;
            final MusicBoxLyricView r11 = this.d;
            com.larus.utils.e1.d(r10, new k0(r11));
            return new LyricsLineHolder(r10);
        }

        public BaseLyricsAdapter(MusicBoxLyricView r2, List<String> r3, Function0<Unit> r4) {
            Intrinsics.checkNotNullParameter(r3, "lyrics");
            Intrinsics.checkNotNullParameter(r4, "longClickBinder");
            this.d = r2;
            this.a = r3;
            this.b = r4;
            this.c = new HashMap();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicBoxLyricView$LyricsLineHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/widget/TextView;", "<init>", "(Landroid/widget/TextView;)V", "getView", "()Landroid/widget/TextView;", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LyricsLineHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public LyricsLineHolder(TextView r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = r2;
        }
    }

    public static final class a {
    }

    static {
    }

    public MusicBoxLyricView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MusicBoxLyricView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final LarusViewMusicLyricVThreeBinding getBinding() {
        return (LarusViewMusicLyricVThreeBinding) this.a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5() {
        FLogger.a.i("MusicLyricView", "display next line, " + this.d);
        int r0 = this.d;
        int r1 = this.i;
        if (r0 != r1) goto L5;
        return;
    L5:
        int r3 = 0;
        if (r1 != (r0 + 1)) goto L8;
    L10:
        boolean r2 = false;
    L11:
        this.i = r0;
        if (r0 <= (-1)) goto L35;
        RecyclerView.Adapter r4 = getBinding().c.getAdapter();
        if (r4 == null) goto L16;
        int r5 = r4.getItemCount();
    L17:
        if (r0 >= r5) goto L36;
        int r6 = this.d;
        if (r6 <= 0) goto L21;
        r3 = r6;
    L21:
        if (r2 == true) goto L25;
        final Context r7 = getContext();
        LinearSmoothScroller r8 = new MusicBoxLyricView$displayCurrentLine$linearSmoothScroller$1(r7);
        r8.setTargetPosition(r3);
        RecyclerView.LayoutManager r9 = getBinding().c.getLayoutManager();
        if (r9 == null) goto L28;
        r9.startSmoothScroll(r8);
    L28:
        RecyclerView.Adapter r10 = getBinding().c.getAdapter();
        if ((r10 instanceof BaseLyricsAdapter) == false) goto L31;
        BaseLyricsAdapter r11 = (BaseLyricsAdapter) r10;
    L32:
        if (r11 == null) goto L37;
        r11.y2(this.d);
        return;
    L37:
        return;
    L31:
        r11 = null;
        goto L32
    L25:
        final Context r12 = getContext();
        LinearSmoothScroller r13 = new MusicBoxLyricView$displayCurrentLine$linearSmoothScroller$2(r12);
        r13.setTargetPosition(r3);
        RecyclerView.LayoutManager r14 = getBinding().c.getLayoutManager();
        if (r14 == null) goto L28;
        r14.startSmoothScroll(r13);
        goto L28
    L36:
        return;
    L16:
        r5 = 0;
        goto L17
    L35:
        return;
    L8:
        if (r1 == (r0 - 1)) goto L10;
        r2 = true;
        goto L11
    }

    public final void T5() {
        FLogger.a.d("MusicLyricView", "[playState]");
        this.f = true;
        RecyclerView.Adapter r0 = getBinding().c.getAdapter();
        if ((r0 instanceof BaseLyricsAdapter) == false) goto L5;
        BaseLyricsAdapter r1 = (BaseLyricsAdapter) r0;
    L6:
        if (r1 == null) goto L9;
        r1.y2(this.d);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void U5() {
        FLogger.a.d("MusicLyricView", "[readyState]");
        this.f = false;
        RecyclerView.Adapter r0 = getBinding().c.getAdapter();
        if ((r0 instanceof BaseLyricsAdapter) == false) goto L5;
        BaseLyricsAdapter r1 = (BaseLyricsAdapter) r0;
    L6:
        if (r1 == null) goto L9;
        r1.y2(-1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final List<LyricsUtterances> V5() {
        List r0 = this.b.getUtterances();
        if (r0 == null) goto L20;
        ArrayList r2 = new ArrayList();
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L14;
        Object r3 = r1.next();
        String r4 = ((LyricsUtterances) r3).getText();
        boolean r5 = false;
        if (r4 == null) goto L11;
        r5 = StringsKt.contains$default(r4, "[", false, 2, null);
    L11:
        if ((!r5) == false) goto L6;
        r2.add(r3);
        goto L6
    L14:
        return r2;
    L20:
        return null;
    }

    public MusicBoxLyricView(final Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.a = LazyKt.lazy(new f0(r11, this));
        this.b = new LyricsSeekContent(0, 0.0d, null, null, null, null, 63, null);
        this.c = CollectionsKt.emptyList();
        this.d = -1;
        this.g = "";
        this.h = new g0();
    }

    public /* synthetic */ MusicBoxLyricView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.view.View, android.view.ViewGroup, com.larus.bmhome.music.widget.MusicBoxLyricView] */
    public final void R5(int r9, String r10, LyricsSeekContent r11, String r12, Function0<Unit> r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "authorLine");
        Intrinsics.checkNotNullParameter(r12, "fallback");
        Intrinsics.checkNotNullParameter(r13, "longClickBinder");
        Intrinsics.checkNotNullParameter(r14, "clickEvent");
        getBinding().c.setNestedScrollingEnabled(false);
        final d r3 = (d) r14;
        com.larus.utils.e1.d(getBinding().c, new h0(r3));
        com.larus.utils.e1.d(this, new i0(r3));
        this.h = r14;
        this.g = r10;
        getBinding().c.setLayoutManager(new LinearLayoutManager(getContext()));
        if (r11 == null) goto L5;
        this.b = r11;
    L5:
        this.d = -1;
        this.e = 0;
        List r15 = StringsKt.split$default(r12, new String[]{"\n"}, false, 0, 6, null);
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L6:
        boolean r0 = true;
        if (r17.hasNext() == false) goto L16;
        Object r18 = r17.next();
        String r2 = (String) r18;
        if (TextUtils.isEmpty(r2) == false) goto L11;
    L13:
        r0 = false;
    L14:
        if (r0 == false) goto L6;
        r16.add(r18);
        goto L6
    L11:
        if (StringsKt.contains$default(r2, "[", false, 2, null) == true) goto L13;
    L16:
        this.c = r16;
        if (r9 == 0) goto L36;
        if (r9 == 1) goto L35;
        if (r9 != 2) goto L21;
        com.larus.utils.e1.q(getBinding().b);
        getBinding().c.setAdapter(new BaseLyricsAdapter(this, this.c, r13));
        return;
    L21:
        if (r9 != 3) goto L49;
        com.larus.utils.e1.q(getBinding().b);
        RecyclerView r19 = getBinding().c;
        List<LyricsUtterances> r110 = V5();
        if (r110 == null) goto L32;
        ?? r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = r110.iterator();
    L27:
        if (r112.hasNext() == false) goto L33;
        String r113 = ((LyricsUtterances) r112.next()).getText();
        if (r113 != null) goto L31;
        r113 = "";
    L31:
        r111.add(r113);
    L33:
        r19.setAdapter(new BaseLyricsAdapter(this, r111, r13));
        return;
    L32:
        r111 = CollectionsKt.emptyList();
        goto L33
    L49:
        return;
    L35:
        com.larus.utils.e1.q(getBinding().b);
        getBinding().c.setAdapter(new BaseLyricsAdapter(this, CollectionsKt.arrayListOf(new String[]{getContext().getString(2131907194)}), r13));
        return;
    L36:
        com.larus.utils.e1.x(getBinding().b);
        getBinding().c.setAdapter(new BaseLyricsAdapter(this, CollectionsKt.emptyList(), r13));
    }
}
