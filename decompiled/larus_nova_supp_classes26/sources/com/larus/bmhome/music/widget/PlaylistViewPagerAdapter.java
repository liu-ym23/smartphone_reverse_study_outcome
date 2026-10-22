package com.larus.bmhome.music.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.music.databinding.LarusMusicCoverViewHolderBinding;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003'()B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u001a\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\rH\u0002J\"\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\r2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170!J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0007J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u000bJ\u0006\u0010&\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006*"}, d2 = {"Lcom/larus/bmhome/music/widget/PlaylistViewPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/bmhome/music/widget/PlaylistViewPagerAdapter$MusicCoverViewHolder;", "playerAbility", "Lcom/larus/bmhome/music/widget/PlaylistViewPagerAdapter$PlayerAbilityProvider;", "singleMode", "", "<init>", "(Lcom/larus/bmhome/music/widget/PlaylistViewPagerAdapter$PlayerAbilityProvider;Z)V", "readyPlayList", "", "Lcom/larus/im/bean/message/block/MusicCreationContent;", "value", "", "initPosition", "getInitPosition", "()I", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "", "holder", "position", "addNodesBefore", "node", "addNodesAfter", "count", "deleteWithPos", "pos", "callback", "Lkotlin/Function1;", "appendReadyPlaylist", "updateReadyPlaylist", "updateCurrentContent", "content", "tryUpdateReadyPlaylist", "Companion", "MusicCoverViewHolder", "PlayerAbilityProvider", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlaylistViewPagerAdapter extends RecyclerView.Adapter<MusicCoverViewHolder> {
    public final b a;
    public final boolean b;
    public final List<MusicCreationContent> c;
    public int d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/music/widget/PlaylistViewPagerAdapter$MusicCoverViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/music/widget/PlaylistViewPagerAdapter;Landroid/view/View;)V", "binding", "Lcom/larus/bmhome/music/databinding/LarusMusicCoverViewHolderBinding;", "getBinding", "()Lcom/larus/bmhome/music/databinding/LarusMusicCoverViewHolderBinding;", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class MusicCoverViewHolder extends RecyclerView.ViewHolder {
        public final LarusMusicCoverViewHolderBinding a;

        public MusicCoverViewHolder(View r4) {
            Intrinsics.checkNotNullParameter(r4, "itemView");
            super(r4);
            FLogger.a.i("PlaylistViewPagerAdapter", "[MusicCoverViewHolder init]");
            int r0 = 2131368155;
            LottieAdapterView r1 = ViewBindings.findChildViewById(r4, 2131368155);
            if (r1 == null) goto L9;
            r0 = 2131368167;
            SimpleDraweeView r2 = ViewBindings.findChildViewById(r4, 2131368167);
            if (r2 == null) goto L9;
            this.a = new LarusMusicCoverViewHolderBinding((ConstraintLayout) r4, r1, r2);
            return;
        L9:
            throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
        }
    }

    public static final class a {
    }

    public interface b {
        MusicCreationContent a();

        int b();

        void c(MusicCoverViewHolder r1, MusicCreationContent r2);
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    public final void z2() {
        FLogger r0 = FLogger.a;
        r0.d("PlaylistViewPagerAdapter", "[tryUpdateReadyPlaylist]");
        int r2 = ((ArrayList) this.c).size();
        MusicCreationContent r3 = (MusicCreationContent) CollectionsKt.lastOrNull(this.c);
        if (r3 == null) goto L9;
        ad9.b r4 = r3.getPlayList();
        if (r4 == null) goto L9;
        if (r4.getHasNext() == true) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L13;
        r0.d("PlaylistViewPagerAdapter", "[tryUpdateReadyPlaylist] ignore");
        return;
    L13:
        MusicCreationContent r6 = (MusicCreationContent) CollectionsKt.lastOrNull(this.c);
        if (r6 != null) goto L16;
        return;
    L16:
        y2(this, r6);
        r0.d("PlaylistViewPagerAdapter", "[tryUpdateReadyPlaylist] trigger updateReadyPlaylist");
        notifyItemRangeChanged(r2 - 1, ((ArrayList) this.c).size() - r2);
        return;
    L9:
        r5 = false;
        goto L10
    }

    public final void A2(MusicCreationContent r4) {
        Intrinsics.checkNotNullParameter(r4, "content");
        FLogger.a.d("PlaylistViewPagerAdapter", "[updateCurrentContent]");
        int r0 = this.a.b();
        ListProtector.set(this.c, r0, r4);
        notifyItemChanged(r0);
    }

    public PlaylistViewPagerAdapter(b r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "playerAbility");
        this.a = r5;
        this.b = r6;
        ArrayList r0 = new ArrayList();
        this.c = r0;
        FLogger r1 = FLogger.a;
        r1.d("PlaylistViewPagerAdapter", "[updateReadyPlaylist]");
        r0.clear();
        MusicCreationContent r7 = r5.a();
        if (r7 == null) goto L15;
        r1.d("PlaylistViewPagerAdapter", "[addNodesBefore] singleMode=" + r6);
        if (r6 == true) goto L14;
        MusicCreationContent r8 = r7;
    L10:
        if (r8.getPlayList().getHasPrevious() == false) goto L14;
        FLogger r2 = FLogger.a;
        r2.d("PlaylistViewPagerAdapter", "[addNodesBefore while]");
        r8 = r8.getPlayList().d();
        if (r8 == null) goto L14;
        r2.d("PlaylistViewPagerAdapter", "[addNodesBefore while] take list " + r8.getPlayList().a() + " item " + r8.getPlayList().getItemId());
        ListProtector.add(this.c, 0, r8);
    L14:
        this.d = ((ArrayList) this.c).size();
        ((ArrayList) this.c).add(r7);
        y2(this, r7);
    L15:
        FLogger.a.i("PlaylistViewPagerAdapter", "[PlaylistViewPagerAdapter init]");
    }

    public static void y2(PlaylistViewPagerAdapter r5, MusicCreationContent r6) {
        r5.getClass();
        FLogger.a.d("PlaylistViewPagerAdapter", "[addNodesAfter] singleMode=" + r5.b);
        if (r5.b == true) goto L18;
        int r0 = 0;
    L7:
        if (r6.getPlayList().getHasNext() == false) goto L24;
        if (r0 >= Integer.MAX_VALUE) goto L25;
        FLogger r1 = FLogger.a;
        r1.d("PlaylistViewPagerAdapter", "[addNodesAfter while]");
        r6 = r6.getPlayList().getNext();
        if (r6 == null) goto L26;
        if (com.larus.utils.o0.d(r6.getVideoModel()) == true) goto L16;
        r6 = null;
    L16:
        if (r6 == null) goto L23;
        ((ArrayList) r5.c).add(r6);
        r0 = r0 + 1;
        r1.i("PlaylistViewPagerAdapter", "[addNodesAfter] add [" + r6.getVid() + "] addedCount=" + r0);
        goto L7
    L23:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        MusicCoverViewHolder r6 = (MusicCoverViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        FLogger.a.i("PlaylistViewPagerAdapter", "[onBindViewHolder] position=" + r5);
        LottieAdapterView r0 = r6.a.b;
        r0.setRepeatCount(-1);
        r0.setAnimation(2131820617);
        Intrinsics.checkNotNull(r0);
        int r1 = c7.b(12);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        com.larus.utils.w0.e(r0, r1);
        r0.playAnimation();
        com.larus.utils.e1.x(r0);
        this.a.c(r6, (MusicCreationContent) ListProtector.get(this.c, r5));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        FLogger.a.i("PlaylistViewPagerAdapter", "[onCreateViewHolder]");
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131562977, r3, false);
        Intrinsics.checkNotNull(r5);
        return new MusicCoverViewHolder(r5);
    }
}
