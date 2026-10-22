package com.larus.voice_setting.voice;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.voice_setting.impl.databinding.LarusItemVoiceListCreateBinding;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/voice_setting/voice/VoiceCreateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/larus/voice_setting/voice/VoiceCreateAdapter$VoiceCreateViewHolder;", "config", "Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;", "<init>", "(Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;)V", "voiceCreateClick", "Lkotlin/Function0;", NameKeys.UnloadStrategy_No_Strategy, "getVoiceCreateClick", "()Lkotlin/jvm/functions/Function0;", "setVoiceCreateClick", "(Lkotlin/jvm/functions/Function0;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", NameKeys.UnloadStrategy_No_Strategy, "getItemCount", "onBindViewHolder", "holder", "position", "VoiceCreateViewHolder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCreateAdapter extends RecyclerView.Adapter<VoiceCreateViewHolder> {
    public final t2 a;
    public Function0<Unit> b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/voice_setting/voice/VoiceCreateAdapter$VoiceCreateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VoiceCreateViewHolder extends RecyclerView.ViewHolder {
        public VoiceCreateViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public final int getItemCount() {
        return 1;
    }

    public VoiceCreateAdapter(t2 r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        VoiceCreateViewHolder r5 = (VoiceCreateViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        TextView r6 = (TextView) ((RecyclerView.ViewHolder) r5).itemView.findViewById(2131368221);
        if (this.a.b == false) goto L5;
        r6.setText(((RecyclerView.ViewHolder) r5).itemView.getContext().getString(2131907852));
        r6.setTextSize(1, 16.0f);
        r6.getPaint().setFakeBoldText(true);
    L7:
        if (this.a.b() == false) goto L9;
        r6.setTypeface(Typeface.DEFAULT_BOLD);
    L9:
        com.larus.utils.e1.d(((RecyclerView.ViewHolder) r5).itemView, new m2(this));
        return;
    L5:
        Resources r0 = ((RecyclerView.ViewHolder) r5).itemView.getResources();
        com.larus.voice_setting.voice.utils.f r1 = com.larus.voice_setting.voice.utils.f.a;
        r6.setText(r0.getString(2131907848));
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        return new VoiceCreateViewHolder(LarusItemVoiceListCreateBinding.a(LayoutInflater.from(r1.getContext()), r1).a);
    }
}
