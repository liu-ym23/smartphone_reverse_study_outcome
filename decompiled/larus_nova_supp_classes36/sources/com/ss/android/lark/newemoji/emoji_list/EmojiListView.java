package com.ss.android.lark.newemoji.emoji_list;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.location_ui.statistics.LocationHitPoint$ResultType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.adapter.EmojiListAdapter;
import com.ss.android.lark.newemoji.emoji_list.adapter.EmojiListAdapter$setData$diffCallback$1;
import com.ss.android.lark.newemoji.emoji_list.adapter.d;
import com.ss.android.lark.newemoji.emoji_list.adapter.e;
import com.ss.android.lark.newemoji.emoji_list.adapter.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ssb.b;
import ssb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 /2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001/B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0019\u001a\u00020\u0014J\u0006\u0010\u001a\u001a\u00020\u0014J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020\u00142\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#J\u0006\u0010%\u001a\u00020\u0014J\u0006\u0010&\u001a\u00020\u0014J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)2\u0006\u0010-\u001a\u00020)H\u0016J\b\u0010.\u001a\u00020\u0014H\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/ss/android/lark/newemoji/emoji_list/EmojiListView;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/newemoji/emoji_list/IEmojiDataChangeListener;", "Lcom/ss/android/lark/newemoji/emoji_list/adapter/OnEmojiSelectListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "emojiAdapter", "Lcom/ss/android/lark/newemoji/emoji_list/adapter/EmojiListAdapter;", "targetEmojiSelectListener", "initRV", "", "params", "Lcom/ss/android/lark/newemoji/emoji_list/CreateItemParams;", "setOnEmojiSelectListener", "listener", "registerEmojiDataChangeListener", "setOwnerView", "setWindowTokenProvider", "provider", "Lcom/ss/android/lark/newemoji/emoji_list/adapter/IWindowTokenProvider;", "setShowOnDialog", "showOnDialog", "", "setData", LocationHitPoint$ResultType.LIST, "", "Lcom/ss/android/lark/newemoji/emoji_list/EmojiItemData;", "unRegisterListener", "unRegisterEmojiDataChangeListener", "onEmojiSelect", "reactionKey", "", "param", "Lcom/ss/android/lark/statistics/extensions/IParam;", "onEmojiSkinUpdate", "skinedKey", "notifyEmojiDataChange", "Companion", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class EmojiListView extends FrameLayout implements c, e {
    public final RecyclerView a;
    public EmojiListAdapter b;
    public e c;

    public static final class a {
    }

    static {
    }

    @Override // ssb.c
    public final void c() {
        EmojiListAdapter r0 = this.b;
        if (r0 == null) goto L6;
        r0.notifyDataSetChanged();
        return;
    }

    public EmojiListView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        RecyclerView r4 = new RecyclerView(getContext());
        this.a = r4;
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r4);
    }

    public final void d(ssb.a r5) {
        Intrinsics.checkNotNullParameter(r5, "params");
        final Context r0 = getContext();
        FlexboxLayoutManager r1 = new EmojiListView$initRV$flexboxManager$1(r0);
        r1.D(1);
        r1.C(0);
        r1.B(4);
        EmojiListAdapter r2 = new EmojiListAdapter(r5);
        r2.c = this;
        this.b = r2;
        RecyclerView r3 = this.a;
        r3.setItemAnimator(null);
        r3.setLayoutManager(r1);
        r3.setAdapter(this.b);
        r3.setOverScrollMode(2);
        r3.setMotionEventSplittingEnabled(false);
        r3.setPadding(r5.f, 0, r5.g, 0);
    }

    public final void setData(final List<? extends b> r4) {
        final EmojiListAdapter r0 = this.b;
        if (r0 == null) goto L15;
        Log.i("EmojiListAdapter", "set data called");
        List<? extends b> r1 = r4;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L16;
        DiffUtil.calculateDiff(new EmojiListAdapter$setData$diffCallback$1(r0, r4)).dispatchUpdatesTo(r0);
        ((ArrayList) r0.b).clear();
        ((ArrayList) r0.b).addAll(r1);
        return;
    L16:
        return;
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
        goto L11
    }

    public final void setOnEmojiSelectListener(e r1) {
        this.c = r1;
    }

    public final void setShowOnDialog(boolean r3) {
        EmojiListAdapter r0 = this.b;
        if (r0 == null) goto L8;
        f r1 = (f) r0.d.get(1);
        if (r1 == null) goto L9;
        r1.c = r3;
        return;
    L9:
        return;
    }

    public final void setWindowTokenProvider(d r4) {
        Intrinsics.checkNotNullParameter(r4, "provider");
        EmojiListAdapter r1 = this.b;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r4, "provider");
        f r2 = (f) r1.d.get(1);
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r4, "provider");
        r2.b = r4;
        return;
    L9:
        return;
    }

    public EmojiListView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        RecyclerView r4 = new RecyclerView(getContext());
        this.a = r4;
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r4);
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.e
    public final void a(String r2, s5c.d r3) {
        Intrinsics.checkNotNullParameter(r2, "reactionKey");
        Intrinsics.checkNotNullParameter(r3, "param");
        e r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    @Override // com.ss.android.lark.newemoji.emoji_list.adapter.e
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "reactionKey");
        Intrinsics.checkNotNullParameter(r3, "skinedKey");
        e r0 = this.c;
        if (r0 == null) goto L6;
        r0.b(r2, r3);
        return;
    }

    public EmojiListView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        RecyclerView r5 = new RecyclerView(getContext());
        this.a = r5;
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r5);
    }
}
