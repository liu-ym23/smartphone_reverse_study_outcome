package com.larus.voice_setting.voice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.voice_setting.impl.databinding.LarusItemVoiceListCreateBinding;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/larus/voice_setting/voice/VoiceItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "voiceList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/larus/voice_setting/voice/VoiceItem;", "config", "Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;", "<init>", "(Ljava/util/List;Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;)V", "getVoiceList", "()Ljava/util/List;", "setVoiceList", "(Ljava/util/List;)V", "getConfig", "()Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;", "setConfig", "(Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;)V", "itemInteractionListener", "Lcom/larus/voice_setting/voice/VoiceItemInteractionListener;", "getItemInteractionListener", "()Lcom/larus/voice_setting/voice/VoiceItemInteractionListener;", "setItemInteractionListener", "(Lcom/larus/voice_setting/voice/VoiceItemInteractionListener;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", NameKeys.UnloadStrategy_No_Strategy, "getItemCount", "getItemViewType", "position", "onBindViewHolder", NameKeys.UnloadStrategy_No_Strategy, "holder", "onViewDetachedFromWindow", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<o2> a;
    public final t2 b;
    public u2 c;

    public final int getItemCount() {
        return this.a.size();
    }

    public final int getItemViewType(int r2) {
        return ((o2) ListProtector.get(this.a, r2)).f;
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super.onViewDetachedFromWindow(r2);
        if ((r2 instanceof a) == false) goto L6;
        ((a) r2).detach();
        return;
    }

    public VoiceItemAdapter(List<o2> r2, t2 r3) {
        Intrinsics.checkNotNullParameter(r2, "voiceList");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = r2;
        this.b = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.voice_setting.voice.r2] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.voice_setting.voice.q2] */
    public final void onBindViewHolder(final RecyclerView.ViewHolder r7, final int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        final o2 r0 = (o2) CollectionsKt.getOrNull(this.a, r8);
        boolean r2 = true;
        if ((r7 instanceof a) == false) goto L26;
        ((a) r7).d2(r0, this.b);
        com.larus.utils.e1.d(r7.itemView, new p2(this, r0));
        a r1 = (a) r7;
        r1.x1(new q2(this, r0, r8));
        t2 r3 = this.b;
        if (r3.a == true) goto L7;
        r1.l3(false);
        return;
    L7:
        if (r3.b() == true) goto L21;
        o2 r4 = (o2) CollectionsKt.getOrNull(this.a, r8);
        Boolean r5 = null;
        if (r4 == null) goto L14;
        SpeakerVoice r6 = r4.a;
        if (r6 == null) goto L14;
        Boolean r9 = Boolean.valueOf(r6.isUgcVoice());
    L15:
        o2 r10 = (o2) CollectionsKt.getOrNull(this.a, r8 + 1);
        if (r10 == null) goto L20;
        SpeakerVoice r11 = r10.a;
        if (r11 == null) goto L20;
        r5 = Boolean.valueOf(r11.isUgcVoice());
    L20:
        r2 = Intrinsics.areEqual(r9, r5);
    L14:
        r9 = null;
    L21:
        r1.l3(r2);
        if (this.b.a() == false) goto L29;
        r1.W1(new r2(r0, this, r7, r8));
        return;
    L29:
        return;
    L26:
        if ((r7 instanceof VoiceCreateAdapter.VoiceCreateViewHolder) == false) goto L32;
        TextView r12 = (TextView) r7.itemView.findViewById(2131368221);
        r12.setText(r7.itemView.getContext().getString(2131907852));
        r12.setTextSize(1, 16.0f);
        r12.getPaint().setFakeBoldText(true);
        com.larus.utils.e1.d(r7.itemView, new s2(this, r0));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r17, int r18) {
        Intrinsics.checkNotNullParameter(r17, "parent");
        LayoutInflater r2 = LayoutInflater.from(r17.getContext());
        t2 r4 = this.b;
        if (r4.b == false) goto L8;
        if (r18 != 2) goto L8;
        return new VoiceCreateAdapter.VoiceCreateViewHolder(LarusItemVoiceListCreateBinding.a(r2, r17).a);
    L8:
        if (r4.b() == true) goto L10;
        ConstraintLayout r0 = r2.inflate(2131562932, r17, false);
        if (ViewBindings.findChildViewById(r0, 2131369197) != null) goto L82;
        int r3 = 2131369197;
    L113:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r3)));
    L82:
        if (ViewBindings.findChildViewById(r0, 2131392707) == null) goto L110;
        r3 = 2131392755;
        if (ViewBindings.findChildViewById(r0, 2131392755) == null) goto L113;
        if (ViewBindings.findChildViewById(r0, 2131392756) != null) goto L88;
        r3 = 2131392756;
        goto L113
    L88:
        if (ViewBindings.findChildViewById(r0, 2131392757) != null) goto L90;
        r3 = 2131392757;
        goto L113
    L90:
        if (ViewBindings.findChildViewById(r0, 2131392758) != null) goto L92;
        r3 = 2131392758;
        goto L113
    L92:
        if (((ProgressBar) ViewBindings.findChildViewById(r0, 2131392759)) != null) goto L94;
        r3 = 2131392759;
        goto L113
    L94:
        if (ViewBindings.findChildViewById(r0, 2131392760) != null) goto L96;
        r3 = 2131392760;
        goto L113
    L96:
        if (ViewBindings.findChildViewById(r0, 2131392761) != null) goto L98;
        r3 = 2131392761;
        goto L113
    L98:
        if (((ProgressBar) ViewBindings.findChildViewById(r0, 2131392762)) == null) goto L103;
        r3 = 2131392763;
        if (ViewBindings.findChildViewById(r0, 2131392763) == null) goto L113;
        return new VoiceItemViewHolder(r0);
    L103:
        r3 = 2131392762;
        goto L113
    L110:
        r3 = 2131392707;
        goto L113
    L10:
        if (r18 != 1) goto L22;
        View r1 = r2.inflate(2131562812, r17, false);
        int r5 = 2131363751;
        if (ViewBindings.findChildViewById(r1, 2131363751) == null) goto L21;
        r5 = 2131371574;
        if (ViewBindings.findChildViewById(r1, 2131371574) == null) goto L21;
        r5 = 2131371587;
        if (ViewBindings.findChildViewById(r1, 2131371587) == null) goto L21;
        r5 = 2131371605;
        if (ViewBindings.findChildViewById(r1, 2131371605) == null) goto L21;
        return new EmptyVoiceItemViewHolder((LinearLayout) r1);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r5)));
    L22:
        ConstraintLayout r6 = r2.inflate(2131562933, r17, false);
        int r7 = 2131364109;
        if (ViewBindings.findChildViewById(r6, 2131364109) == null) goto L78;
        r7 = 2131368182;
        if (ViewBindings.findChildViewById(r6, 2131368182) == null) goto L78;
        r7 = 2131368195;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131368195)) == null) goto L78;
        if (ViewBindings.findChildViewById(r6, 2131369197) == null) goto L76;
        r7 = 2131369222;
        if (ViewBindings.findChildViewById(r6, 2131369222) == null) goto L78;
        r7 = 2131377098;
        if (ViewBindings.findChildViewById(r6, 2131377098) == null) goto L78;
        r7 = 2131377107;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131377107)) == null) goto L78;
        r7 = 2131380757;
        if (ViewBindings.findChildViewById(r6, 2131380757) == null) goto L78;
        r7 = 2131382164;
        if (ViewBindings.findChildViewById(r6, 2131382164) == null) goto L78;
        r7 = 2131382170;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131382170)) == null) goto L78;
        r7 = 2131382437;
        if (ViewBindings.findChildViewById(r6, 2131382437) == null) goto L78;
        r7 = 2131384491;
        if (ViewBindings.findChildViewById(r6, 2131384491) == null) goto L78;
        r7 = 2131392644;
        if (ViewBindings.findChildViewById(r6, 2131392644) == null) goto L78;
        if (ViewBindings.findChildViewById(r6, 2131392707) != null) goto L51;
        r7 = 2131392707;
        goto L78
    L51:
        if (ViewBindings.findChildViewById(r6, 2131392756) != null) goto L53;
        r7 = 2131392756;
        goto L78
    L53:
        if (ViewBindings.findChildViewById(r6, 2131392757) != null) goto L55;
        r7 = 2131392757;
        goto L78
    L55:
        if (ViewBindings.findChildViewById(r6, 2131392758) != null) goto L57;
        r7 = 2131392758;
        goto L78
    L57:
        if (((ProgressBar) ViewBindings.findChildViewById(r6, 2131392759)) != null) goto L59;
        r7 = 2131392759;
        goto L78
    L59:
        if (ViewBindings.findChildViewById(r6, 2131392760) != null) goto L61;
        r7 = 2131392760;
        goto L78
    L61:
        if (ViewBindings.findChildViewById(r6, 2131392761) != null) goto L63;
        r7 = 2131392761;
        goto L78
    L63:
        if (((ProgressBar) ViewBindings.findChildViewById(r6, 2131392762)) != null) goto L65;
        r7 = 2131392762;
        goto L78
    L65:
        if (ViewBindings.findChildViewById(r6, 2131392763) != null) goto L116;
        r7 = 2131392763;
        goto L78
    L116:
        return new VoiceItemPublicViewHolder(r6);
    L76:
        r7 = 2131369197;
    L78:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
