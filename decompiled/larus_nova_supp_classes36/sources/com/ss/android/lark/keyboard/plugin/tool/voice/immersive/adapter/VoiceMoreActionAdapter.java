package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rob.d;
import rob.g;
import rob.l;
import rob.m;
import rob.n;
import rob.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/VoiceMoreActionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/BaseActionItemViewHolder;", "<init>", "()V", "dataList", "", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/MoreActionItem;", "moreActionItemClickListener", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/IOnMoreActionItemClickListener;", "setItemClickListener", "", "listener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemViewType", "position", "getItemCount", "onBindViewHolder", "holder", "addItem", "item", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class VoiceMoreActionAdapter extends RecyclerView.Adapter<BaseActionItemViewHolder> {
    public final List<g> a;
    public d b;

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public VoiceMoreActionAdapter() {
        this.a = new ArrayList();
    }

    public final int getItemViewType(int r2) {
        return ((g) ListProtector.get(this.a, r2)).getType().value();
    }

    public final void y2(g r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        ((ArrayList) this.a).add(r2);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        BaseActionItemViewHolder r5 = (BaseActionItemViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        g r6 = (g) ListProtector.get(this.a, r4);
        r5.T3(((RecyclerView.ViewHolder) r5).itemView, r6);
        if (r6.getType() != ItemType.SendTypeAction) goto L6;
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new l(this, r6));
    L6:
        if (r6.getType() != ItemType.AsrLanguage) goto L9;
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new m(this, r6));
    L9:
        if (r6.getType() != ItemType.IconWithTitle) goto L12;
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new n(this, r6));
    L12:
        if (r6.getType() != ItemType.SwitchAction) goto L15;
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new o(this, r6));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r0 = LayoutInflater.from(r4.getContext()).inflate(2131561614, r4, false);
        if (r5 != ItemType.Header.value()) goto L6;
        Intrinsics.checkNotNull(r0);
        return new HeaderActionItemViewHolder(r0);
    L6:
        if (r5 != ItemType.SendTypeAction.value()) goto L9;
        Intrinsics.checkNotNull(r0);
        return new SendResultActionItemViewHolder(r0);
    L9:
        if (r5 != ItemType.AsrLanguage.value()) goto L12;
        Intrinsics.checkNotNull(r0);
        return new AsrLanguageActionItemViewHolder(r0);
    L12:
        if (r5 != ItemType.IconWithTitle.value()) goto L15;
        Intrinsics.checkNotNull(r0);
        return new IconWithTitleViewHolder(r0);
    L15:
        if (r5 != ItemType.Divider.value()) goto L18;
        Intrinsics.checkNotNull(r0);
        return new ItemDivider(r0);
    L18:
        if (r5 != ItemType.SwitchAction.value()) goto L20;
        View r6 = LayoutInflater.from(r4.getContext()).inflate(2131561712, r4, false);
        Intrinsics.checkNotNull(r6);
        return new SwitchActionItemViewHolder(r6);
    L20:
        Intrinsics.checkNotNull(r0);
        return new BaseActionItemViewHolder(r0);
    }
}
