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
import com.larus.bmhome.music.databinding.LarusViewMusicPlayerLyricBinding;
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
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 92\u00020\u0001:\u00039:;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJF\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u00112\u0006\u0010#\u001a\u00020\u00142\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0007J\u0010\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0013H\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u001fH\u0002J\u0018\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u0019H\u0002J\u0010\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0007H\u0002J\u001a\u00102\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020'0\u00132\u0006\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u0019H\u0002J\u0010\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u0014H\u0002J\u000e\u00107\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0007J\u0006\u00108\u001a\u00020\u001fR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicPlayerLyricView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/bmhome/music/databinding/LarusViewMusicPlayerLyricBinding;", "getBinding", "()Lcom/larus/bmhome/music/databinding/LarusViewMusicPlayerLyricBinding;", "binding$delegate", "Lkotlin/Lazy;", "lyricsSeekContent", "Lcom/larus/im/bean/message/block/LyricsSeekContent;", "fallbackLyrics", "", "", "curLyricIndex", "curProgress", "displayingIndex", "playing", "", "isEmpty", "isError", "authorLine", "clickListener", "Lkotlin/Function0;", "", "bindLyrics", "lyricsState", "content", "fallback", "longClickBinder", "clickEvent", "utterancesFilterByLyricsCode", "Lcom/larus/im/bean/message/block/LyricsUtterances;", "displayNextLine", "displayCurrentLine", "smoothScrollTo", "targetPosition", "fastScroll", "tryDisplayNextLine", "hasNextLine", "reachNextLine", "lyricsProgressSeekTo", "progress", "toStrByIndex", "index", "isLyricsProgressCorrect", "logAndFalse", "message", "updateProgress", "resetStatus", "Companion", "LyricsLineHolder", "BaseLyricsAdapter", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicPlayerLyricView extends ConstraintLayout {
    public static final IntRange i = null;
    public final Lazy a;
    public LyricsSeekContent b;
    public List<String> c;
    public int d;
    public int e;
    public int f;
    public String g;
    public Function0<Unit> h;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\rJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicPlayerLyricView$BaseLyricsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/music/widget/MusicPlayerLyricView$LyricsLineHolder;", "lyrics", "", "", "longClickBinder", "Lkotlin/Function0;", "", "<init>", "(Lcom/larus/bmhome/music/widget/MusicPlayerLyricView;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "holderPositionMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "currentHighLight", "highLight", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemViewType", "getItemCount", "onBindViewHolder", "holder", "onViewRecycled", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class BaseLyricsAdapter extends RecyclerView.Adapter<LyricsLineHolder> {
        public final List<String> a;
        public final Function0<Unit> b;
        public final HashMap<Integer, LyricsLineHolder> c;
        public int d;
        public final /* synthetic */ MusicPlayerLyricView e;

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
            if (TextUtils.isEmpty(this.e.g) == false) goto L6;
            return 1;
        }

        public final void onViewRecycled(RecyclerView.ViewHolder r3) {
            LyricsLineHolder r4 = (LyricsLineHolder) r3;
            Intrinsics.checkNotNullParameter(r4, "holder");
            super.onViewRecycled(r4);
            r4.a.setTextColor(ContextCompat.getColor(this.e.getContext(), 2131106540));
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
            LyricsLineHolder r6 = (LyricsLineHolder) r4;
            Intrinsics.checkNotNullParameter(r6, "holder");
            this.c.put(Integer.valueOf(r5), r6);
            if (r5 <= this.a.size()) goto L5;
            r6.a.setText("");
            return;
        L5:
            FLogger.a.d("MusicLyricView", "[onBindViewHolder] position=" + r5 + ", curLyricIndex: " + this.e.d);
            if (r5 != 0) goto L8;
            r6.a.setText(this.e.g);
        L9:
            r6.a.setOnLongClickListener(new i2(this));
            return;
        L8:
            r6.a.setText((CharSequence) ListProtector.get(this.a, r5 - 1));
            goto L9
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            if (r5 != 1) goto L5;
            View r6 = LayoutInflater.from(r4.getContext()).inflate(2131563220, r4, false);
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.widget.TextView");
            TextView r7 = (TextView) r6;
            final MusicPlayerLyricView r8 = this.e;
            com.larus.utils.e1.d(r7, new j2(r8));
            return new LyricsLineHolder(r7);
        L5:
            View r9 = LayoutInflater.from(r4.getContext()).inflate(2131563221, r4, false);
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.widget.TextView");
            TextView r10 = (TextView) r9;
            final MusicPlayerLyricView r11 = this.e;
            com.larus.utils.e1.d(r10, new k2(r11));
            return new LyricsLineHolder(r10);
        }

        public BaseLyricsAdapter(MusicPlayerLyricView r2, List<String> r3, Function0<Unit> r4) {
            Intrinsics.checkNotNullParameter(r3, "lyrics");
            Intrinsics.checkNotNullParameter(r4, "longClickBinder");
            this.e = r2;
            this.a = r3;
            this.b = r4;
            this.c = new HashMap();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicPlayerLyricView$LyricsLineHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/widget/TextView;", "<init>", "(Landroid/widget/TextView;)V", "getView", "()Landroid/widget/TextView;", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public MusicPlayerLyricView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MusicPlayerLyricView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        i = new IntRange(-300, 500);
    }

    private final LarusViewMusicPlayerLyricBinding getBinding() {
        return (LarusViewMusicPlayerLyricBinding) this.a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5() {
        FLogger r0 = FLogger.a;
        r0.i("MusicLyricView", "[displayCurrentLine] curLyricIndex: " + this.d + ", displayingIndex=" + this.f);
        int r1 = this.d;
        int r3 = this.f;
        if (r1 != r3) goto L5;
        return;
    L5:
        int r2 = Math.abs(r1 - r3);
        boolean r4 = false;
        if (r2 == 1) goto L8;
        final boolean r5 = true;
    L9:
        this.f = this.d;
        RecyclerView.Adapter r6 = getBinding().c.getAdapter();
        if (r6 == null) goto L12;
        int r7 = r6.getItemCount();
    L13:
        int r8 = this.d;
        if (r8 < 0) goto L17;
        if (r8 >= r7) goto L17;
        r4 = true;
    L17:
        if (r4 == false) goto L23;
        int r9 = RangesKt.coerceAtMost(r8 + 1, r7 - 1);
        r0.i("MusicLyricView", "[displayCurrentLine] scroll to: " + r9 + ", fastScroll=" + r5);
        final Context r10 = getContext();
        LinearSmoothScroller r11 = new MusicPlayerLyricView$smoothScrollTo$linearSmoothScroller$1(r5, r10);
        r11.setTargetPosition(r9);
        RecyclerView.LayoutManager r12 = getBinding().c.getLayoutManager();
        if (r12 == null) goto L21;
        r12.startSmoothScroll(r11);
    L21:
        getBinding().c.post(new d2(this));
        return;
    L23:
        return;
    L12:
        r7 = 0;
        goto L13
    L8:
        r5 = false;
        goto L9
    }

    public final void U5() {
        FLogger.a.d("MusicLyricView", "[resetStatus]");
        this.d = -1;
        this.e = 0;
        this.f = -1;
    }

    public final List<LyricsUtterances> Z5() {
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

    public static void R5(MusicPlayerLyricView r6) {
        RecyclerView.Adapter r0 = r6.getBinding().c.getAdapter();
        if ((r0 instanceof BaseLyricsAdapter) == false) goto L5;
        BaseLyricsAdapter r1 = (BaseLyricsAdapter) r0;
    L6:
        if (r1 == null) goto L34;
        int r7 = r6.f;
        int r2 = r1.a.size() + 1;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L15;
        LyricsLineHolder r4 = r1.c.get(Integer.valueOf(r3));
        if (r4 == null) goto L14;
        TextView r5 = r4.a;
        if (r5 == null) goto L14;
        r5.setTextColor(ContextCompat.getColor(r1.e.getContext(), 2131106539));
    L14:
        r3 = r3 + 1;
        goto L8
    L15:
        int r8 = r7 + 1;
        if (r8 >= r1.getItemCount()) goto L35;
        if (r7 < 0) goto L39;
        r1.d = r8;
        LyricsLineHolder r9 = r1.c.get(Integer.valueOf(r8));
        if (r9 == null) goto L36;
        TextView r10 = r9.a;
        if (r10 == null) goto L40;
        FLogger.a.i("MusicLyricView", "[highLight] index: " + r1.d + ", lyric: " + r10.getText());
        LyricsLineHolder r11 = r1.c.get(Integer.valueOf(r1.d));
        if (r11 == null) goto L37;
        TextView r12 = r11.a;
        if (r12 == null) goto L38;
        r12.setTextColor(ContextCompat.getColor(r1.e.getContext(), 2131103298));
        return;
    L38:
        return;
    L37:
        return;
    L40:
        return;
    L36:
        return;
    L39:
        return;
    L35:
        return;
    L34:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void Y5(int r11) {
        int r0 = r11 - this.e;
        IntRange r1 = i;
        int r2 = r1.getFirst();
        boolean r4 = false;
        if (r0 > r1.getLast()) goto L6;
        if (r2 > r0) goto L6;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L25;
        FLogger.a.d("MusicLyricView", "[updateProgress] curProgress: " + this.e + ", new: " + r11 + ", offset: " + r0 + ", trigger seek");
        List<LyricsUtterances> r5 = Z5();
        if (r5 == null) goto L25;
        if (r5.isEmpty() == true) goto L25;
        this.e = r11;
        this.d = -1;
        Iterator r7 = CollectionsKt.minus(CollectionsKt.getIndices(r5), 1).iterator();
    L17:
        if (r7.hasNext() == false) goto L22;
        int r8 = ((Number) r7.next()).intValue();
        if (r11 < ((LyricsUtterances) ListProtector.get(r5, r8)).getEndTime()) goto L17;
        this.d = r8;
        goto L17
    L22:
        if (this.d <= (-1)) goto L24;
        FLogger.a.d("MusicLyricView", "[seek to] index " + this.d + " text " + V5(r5, this.d));
        goto L25
    L24:
        FLogger.a.d("MusicLyricView", "[seek to] index " + this.d + " text " + V5(r5, 0));
    L25:
        this.e = r11;
        List<LyricsUtterances> r6 = Z5();
        if (r6 == null) goto L52;
        int r9 = this.d;
        if (r9 >= 0) goto L31;
    L34:
        boolean r10 = true;
    L35:
        if (r10 == false) goto L37;
        FLogger.a.i("MusicLyricView", "[isLyricsProgressCorrect] illegal index=" + this.d);
        goto L52
    L37:
        int r12 = ((LyricsUtterances) ListProtector.get(r6, this.d)).getEndTime();
        if (this.e <= r12) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L43;
        FLogger.a.i("MusicLyricView", "[isLyricsProgressCorrect] progress is beyond end time, " + this.e + " > " + r12);
        goto L52
    L43:
        int r14 = this.d + 1;
        if (r14 >= r6.size()) goto L53;
        int r15 = ((LyricsUtterances) ListProtector.get(r6, r14)).getStartTime();
        if (this.e < r15) goto L49;
        boolean r16 = true;
    L50:
        if (r16 == false) goto L53;
        FLogger.a.i("MusicLyricView", "[isLyricsProgressCorrect] progress reaches next start time, " + this.e + " >= " + r15);
        goto L52
    L49:
        r16 = false;
    L53:
        boolean r17 = true;
    L54:
        if (r17 == false) goto L56;
        return;
    L56:
        FLogger r18 = FLogger.a;
        r18.d("MusicLyricView", "[updateProgress] curProgress: " + this.e + ", new: " + r11 + ", curLyricIndex: [" + this.d + ':' + this.f + "], trigger try next");
        List<LyricsUtterances> r19 = Z5();
        if (r19 != null) goto L60;
    L62:
        boolean r110 = false;
    L63:
        if (r110 == true) goto L65;
        r18.d("MusicLyricView", "[tryDisplayNextLine] has no next line");
        T5();
    L82:
        StringBuilder r111 = new StringBuilder("[updateProgress] displaying line: ");
        List<LyricsUtterances> r20 = Z5();
        if (r20 == null) goto L85;
        String r21 = V5(r20, this.f);
    L86:
        r111.append(r21);
        r18.d("MusicLyricView", r111.toString());
        return;
    L85:
        r21 = null;
        goto L86
    L65:
        List<LyricsUtterances> r112 = Z5();
        if (r112 != null) goto L69;
    L79:
        if (r4 == true) goto L81;
        r18.d("MusicLyricView", "[tryDisplayNextLine] has not reached next line, trigger reset");
        U5();
        goto L82
    L81:
        this.d++;
        T5();
        goto L82
    L69:
        if ((this.d + 1) >= r112.size()) goto L79;
        int r22 = ((LyricsUtterances) ListProtector.get(r112, this.d + 1)).getStartTime();
        int r23 = this.d;
        if (r23 < 0) goto L74;
        int r113 = ((LyricsUtterances) ListProtector.get(r112, r23)).getEndTime();
    L75:
        int r24 = this.e;
        if (r24 >= r22) goto L78;
        if (r24 < r113) goto L79;
    L78:
        r4 = true;
        goto L79
    L74:
        r113 = 0;
        goto L75
    L60:
        if (RangesKt.coerceAtMost(this.e + 1, CollectionsKt.getLastIndex(r19)) == this.d) goto L62;
        r110 = true;
        goto L63
    L40:
        r13 = false;
        goto L41
    L31:
        if (r9 >= r6.size()) goto L34;
        r10 = false;
    L52:
        r17 = false;
    L6:
        r3 = false;
        goto L8
    }

    public static String V5(List r2, int r3) {
        if (r3 >= 0) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == true) goto L11;
        return "";
    L11:
        return "[" + ((LyricsUtterances) ListProtector.get(r2, r3)).getStartTime() + ':' + ((LyricsUtterances) ListProtector.get(r2, r3)).getEndTime() + "] " + ((LyricsUtterances) ListProtector.get(r2, r3)).getText();
    L4:
        if (r3 >= r2.size()) goto L6;
        r0 = true;
        goto L7
    }

    public MusicPlayerLyricView(final Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.a = LazyKt.lazy(new e2(r11, this));
        this.b = new LyricsSeekContent(0, 0.0d, null, null, null, null, 63, null);
        this.c = CollectionsKt.emptyList();
        this.d = -1;
        this.f = -1;
        this.g = "";
        this.h = new f2();
    }

    public /* synthetic */ MusicPlayerLyricView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.view.ViewGroup, com.larus.bmhome.music.widget.MusicPlayerLyricView] */
    public final void S5(int r9, String r10, LyricsSeekContent r11, String r12, Function0<Unit> r13, final Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "authorLine");
        Intrinsics.checkNotNullParameter(r12, "fallback");
        Intrinsics.checkNotNullParameter(r13, "longClickBinder");
        Intrinsics.checkNotNullParameter(r14, "clickEvent");
        FLogger.a.i("MusicLyricView", "[bindLyrics] lyricsState=" + r9);
        getBinding().c.setOnTouchListener(new g2());
        getBinding().c.setNestedScrollingEnabled(false);
        com.larus.utils.e1.d(getBinding().c, new h2(r14));
        this.h = r14;
        this.g = r10;
        RecyclerView r15 = getBinding().c;
        r15.setLayoutManager(new LinearLayoutManager(r15.getContext()));
        if (r11 == null) goto L5;
        this.b = r11;
    L5:
        U5();
        List r16 = StringsKt.split$default(r12, new String[]{"\n"}, false, 0, 6, null);
        ArrayList r17 = new ArrayList();
        Iterator r18 = r16.iterator();
    L6:
        boolean r0 = true;
        if (r18.hasNext() == false) goto L16;
        Object r19 = r18.next();
        String r2 = (String) r19;
        if (TextUtils.isEmpty(r2) == false) goto L11;
    L13:
        r0 = false;
    L14:
        if (r0 == false) goto L6;
        r17.add(r19);
        goto L6
    L11:
        if (StringsKt.contains$default(r2, "[", false, 2, null) == true) goto L13;
    L16:
        this.c = r17;
        if (r9 == 0) goto L36;
        if (r9 == 1) goto L35;
        if (r9 != 2) goto L21;
        com.larus.utils.e1.q(getBinding().b);
        getBinding().c.setAdapter(new BaseLyricsAdapter(this, this.c, r13));
        return;
    L21:
        if (r9 != 3) goto L49;
        com.larus.utils.e1.q(getBinding().b);
        RecyclerView r20 = getBinding().c;
        List<LyricsUtterances> r110 = Z5();
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
        r20.setAdapter(new BaseLyricsAdapter(this, r111, r13));
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
