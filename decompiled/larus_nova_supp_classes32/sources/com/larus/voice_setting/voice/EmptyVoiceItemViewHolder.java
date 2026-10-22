package com.larus.voice_setting.voice;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/larus/voice_setting/voice/EmptyVoiceItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/voice_setting/voice/BaseVoiceItem;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "setAnimator", "(Landroid/animation/ValueAnimator;)V", "bindData", NameKeys.UnloadStrategy_No_Strategy, "voiceItem", "Lcom/larus/voice_setting/voice/VoiceItem;", "config", "Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;", "changeDividerVisibility", "isVisible", NameKeys.UnloadStrategy_No_Strategy, "setMoreBtnClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "detach", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyVoiceItemViewHolder extends RecyclerView.ViewHolder implements a {
    public static final /* synthetic */ int b = 0;
    public ValueAnimator a;

    @Override // com.larus.voice_setting.voice.a
    public final void l3(boolean r1) {
    }

    @Override // com.larus.voice_setting.voice.a
    public final void x1(q2 r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
    }

    @Override // com.larus.voice_setting.voice.a
    public final void detach() {
        ValueAnimator r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = this.a;
        if (r1 == null) goto L8;
        r1.removeAllUpdateListeners();
    L8:
        this.a = null;
    }

    public EmptyVoiceItemViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    @Override // com.larus.voice_setting.voice.a
    public final void W1(r2 r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
    }

    @Override // com.larus.voice_setting.voice.a
    public final void d2(o2 r7, t2 r8) {
        Intrinsics.checkNotNullParameter(r8, "config");
        final WeakReference r9 = new WeakReference(((RecyclerView.ViewHolder) this).itemView.findViewById(2131363751));
        final WeakReference r10 = new WeakReference(((RecyclerView.ViewHolder) this).itemView.findViewById(2131371605));
        final WeakReference r0 = new WeakReference(((RecyclerView.ViewHolder) this).itemView.findViewById(2131371574));
        final WeakReference r1 = new WeakReference(((RecyclerView.ViewHolder) this).itemView.findViewById(2131371587));
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.05f, 0.1f});
        this.a = r3;
        if (r3 == null) goto L5;
        r3.setDuration(500);
    L5:
        ValueAnimator r4 = this.a;
        if (r4 == null) goto L8;
        r4.setRepeatCount(-1);
    L8:
        ValueAnimator r5 = this.a;
        if (r5 == null) goto L11;
        r5.setRepeatMode(2);
    L11:
        ValueAnimator r2 = this.a;
        if (r2 == null) goto L14;
        r2.addUpdateListener(new j0(r9, r10, r0, r1));
    L14:
        ValueAnimator r11 = this.a;
        if (r11 == null) goto L18;
        r11.start();
        return;
    }
}
