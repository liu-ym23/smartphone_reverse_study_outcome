package com.ss.android.lark.newemoji.emoji_list.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.adapter.view.RecentUsedEmojiView;
import com.ss.android.lark.newemoji.emoji_list.adapter.view.SingleEmojiView;
import com.ss.android.lark.newemoji.emojioptions.OptionsSelectPopupMenu;
import com.ss.android.lark.newemoji.loader.EmojiImageResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import qsb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%J\u0016\u0010&\u001a\u00020\u00192\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010(J\b\u0010)\u001a\u00020\u0010H\u0016J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\t\u0012\u0006\b\u0001\u0012\u00020\u00020\u00110\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006,"}, d2 = {"Lcom/ss/android/lark/newemoji/emoji_list/adapter/EmojiListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "params", "Lcom/ss/android/lark/newemoji/emoji_list/CreateItemParams;", "<init>", "(Lcom/ss/android/lark/newemoji/emoji_list/CreateItemParams;)V", "items", "", "Lcom/ss/android/lark/newemoji/emoji_list/EmojiItemData;", "getItems", "()Ljava/util/List;", "listener", "Lcom/ss/android/lark/newemoji/emoji_list/adapter/OnEmojiSelectListener;", "binders", "", "", "Lcom/ss/android/lark/newemoji/emoji_list/adapter/IAdapterBinder;", "getBinders", "()Ljava/util/Map;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "setOnEmojiSelectListener", "setOwnerView", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "setWindowTokenProvider", "provider", "Lcom/ss/android/lark/newemoji/emoji_list/adapter/IWindowTokenProvider;", "setShowOnDialog", "showOnDialog", "", "setData", "data", "", "getItemCount", "getItemViewType", "Companion", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class EmojiListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final ssb.a a;
    public final List<ssb.b> b;
    public e c;
    public final Map<Integer, c<? extends ssb.b, ? extends RecyclerView.ViewHolder>> d;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public EmojiListAdapter(ssb.a r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        this.a = r4;
        this.b = new ArrayList();
        this.d = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(1, new f()), TuplesKt.to(0, new g()), TuplesKt.to(2, new com.ss.android.lark.newemoji.emoji_list.adapter.a()), TuplesKt.to(3, new b())});
    }

    public final int getItemViewType(int r2) {
        return ((ssb.b) ListProtector.get(this.b, r2)).getType();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "holder");
        ssb.b r12 = (ssb.b) ListProtector.get(this.b, r11);
        boolean r3 = true;
        if ((r12 instanceof ssb.b.d) == false) goto L18;
        if ((r10 instanceof TitleViewHolder) == false) goto L18;
        if (((g) this.d.get(0)) == null) goto L51;
        TitleViewHolder r13 = (TitleViewHolder) r10;
        ssb.b.d r14 = (ssb.b.d) r12;
        Intrinsics.checkNotNullParameter(r13, "holder");
        Intrinsics.checkNotNullParameter(r14, "data");
        r13.a.setText(r14.b);
        String r0 = r14.c;
        if (r0 != null) goto L11;
    L14:
        if (r3 == false) goto L16;
        r13.b.setVisibility(8);
        return;
    L16:
        r13.b.setVisibility(0);
        ImageLoader.with(((RecyclerView.ViewHolder) r13).itemView.getContext()).load(new EmojiImageResource(r14.c)).into(r13.b);
        return;
    L11:
        if (r0.length() == 0) goto L14;
        r3 = false;
        goto L14
    L51:
        return;
    L18:
        if ((r12 instanceof ssb.b.c) == false) goto L35;
        if ((r10 instanceof BaseEmojiViewHolder) == false) goto L35;
        final f r1 = (f) this.d.get(1);
        if (r1 == null) goto L54;
        BaseEmojiViewHolder r15 = (BaseEmojiViewHolder) r10;
        ssb.b.c r16 = (ssb.b.c) r12;
        final e r4 = this.c;
        Intrinsics.checkNotNullParameter(r15, "holder");
        Intrinsics.checkNotNullParameter(r16, "data");
        View r2 = ((RecyclerView.ViewHolder) r15).itemView;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.newemoji.emoji_list.adapter.view.SingleEmojiView");
        ((SingleEmojiView) r2).a(r16, true, r4);
        final com.ss.android.lark.newemoji.larkemoji.a r5 = r16.b;
        Handler r6 = OptionsSelectPopupMenu.x;
        View r7 = ((RecyclerView.ViewHolder) r15).itemView;
        Intrinsics.checkNotNullParameter(r7, "target");
        r7.setTag(2131382886, null);
        r7.setOnTouchListener(null);
        Log.i("SingleEmojiBinder", "enable_emoji_skin: " + r16.c + ", optionalReactionKeys: " + r5.e() + ", emojiKey: " + r5.getId());
        if (r16.c == true) goto L26;
        return;
    L26:
        if ((!r5.e().isEmpty()) == false) goto L56;
        View r17 = ((RecyclerView.ViewHolder) r15).itemView;
        Context r18 = r17.getContext();
        List<String> r8 = r5.e();
        Intrinsics.checkNotNull(r18);
        com.ss.android.lark.newemoji.emojioptions.a r9 = new com.ss.android.lark.newemoji.emojioptions.a(r8, r18);
        String r19 = (String) r5.f().getValue();
        if (r19 != null) goto L30;
        r19 = "";
    L30:
        final OptionsSelectPopupMenu r20 = new OptionsSelectPopupMenu(r18, r9, r19);
        r20.f = true;
        r20.g = r1.c;
        final d r110 = r1.b;
        if (r110 == null) goto L33;
        Function0<IBinder> r21 = new SingleEmojiBinder$bindLongPressMenu$1$1(r110);
        Intrinsics.checkNotNullParameter(r21, "provider");
        r20.e = r21;
    L33:
        Function2<String, OptionsSelectPopupMenu.SelectWay, Unit> r111 = new SingleEmojiBinder$bindLongPressMenu$2(r5, r4, r1);
        Intrinsics.checkNotNullParameter(r111, "listener");
        r20.q = r111;
        Intrinsics.checkNotNullParameter(r17, "target");
        r20.h = r17;
        r17.setTag(2131382886, r20);
        r17.setOnTouchListener(new com.ss.android.lark.newemoji.emojioptions.e(r20));
        return;
    L56:
        return;
    L54:
        return;
    L35:
        if ((r12 instanceof ssb.b.a) == false) goto L44;
        if ((r10 instanceof BaseEmojiViewHolder) == false) goto L44;
        if (((com.ss.android.lark.newemoji.emoji_list.adapter.a) this.d.get(2)) == null) goto L58;
        BaseEmojiViewHolder r112 = (BaseEmojiViewHolder) r10;
        ssb.b.a r113 = (ssb.b.a) r12;
        e r22 = this.c;
        Intrinsics.checkNotNullParameter(r112, "holder");
        Intrinsics.checkNotNullParameter(r113, "data");
        Object r114 = ((RecyclerView.ViewHolder) r112).itemView;
        if ((r114 instanceof RecentUsedEmojiView) == false) goto L59;
        RecentUsedEmojiView r115 = (RecentUsedEmojiView) r114;
        r115.setLines(r113.c);
        r115.v(r113.b, true, r22);
        return;
    L59:
        return;
    L58:
        return;
    L44:
        if ((r12 instanceof ssb.b.C0327b) == true) goto L46;
        return;
    L46:
        if ((r10 instanceof BaseEmojiViewHolder) == true) goto L48;
        return;
    L48:
        if (((b) this.d.get(3)) == null) goto L63;
        BaseEmojiViewHolder r116 = (BaseEmojiViewHolder) r10;
        ssb.b.C0327b r117 = (ssb.b.C0327b) r12;
        Intrinsics.checkNotNullParameter(r116, "holder");
        Intrinsics.checkNotNullParameter(r117, "data");
        View r23 = ((RecyclerView.ViewHolder) r116).itemView;
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        r24.height = i.a(r117.b, ((RecyclerView.ViewHolder) r116).itemView.getContext());
        r23.setLayoutParams(r24);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        Context r4 = r2.getContext();
        c<? extends ssb.b, ? extends RecyclerView.ViewHolder> r5 = this.d.get(Integer.valueOf(r3));
        if (r5 != null) goto L5;
        r5 = new g();
    L5:
        Intrinsics.checkNotNull(r4);
        return r5.a(r4, this.a);
    }
}
