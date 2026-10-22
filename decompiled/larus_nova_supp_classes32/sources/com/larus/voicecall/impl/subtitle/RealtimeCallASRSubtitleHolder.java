package com.larus.voicecall.impl.subtitle;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.voicecall.impl.databinding.LarusItemRecyclerAsrBinding;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/voicecall/impl/subtitle/RealtimeCallASRSubtitleHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/voicecall/impl/subtitle/TextViewHolder;", "binding", "Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerAsrBinding;", "callback", "Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;", "<init>", "(Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerAsrBinding;Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;)V", "getBinding", "()Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerAsrBinding;", "getCallback", "()Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;", "lastClickTime", NameKeys.UnloadStrategy_No_Strategy, "bindText", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.DATA_KEY, "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallASRSubtitleHolder extends RecyclerView.ViewHolder implements v1 {
    public static final /* synthetic */ int d = 0;
    public final LarusItemRecyclerAsrBinding a;
    public final u1 b;
    public long c;

    @Override // com.larus.voicecall.impl.subtitle.v1
    public final void K3(final c r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.DATA_KEY);
        boolean r1 = true;
        if (r5.a.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        com.larus.utils.e1.o(this.a.c);
        return;
    L9:
        com.larus.utils.e1.x(this.a.c);
        final CustomMarkdownTextView r2 = this.a.b;
        r2.setOnLongClickListener(new k(this, r2, r5));
        r2.setOnClickListener(new l(this, r2));
        this.a.b.setText(r5.a);
        tt8.b r6 = this.a.b.getTextSelector();
        if (r6 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == false) goto L20;
        tt8.b r7 = this.a.b.getTextSelector();
        if (r7 == null) goto L21;
        r7.n();
        return;
    L21:
        return;
    L20:
        return;
    L12:
        if (((ut8.b) r6).p != true) goto L14;
    L5:
        r0 = false;
        goto L6
    }

    public RealtimeCallASRSubtitleHolder(LarusItemRecyclerAsrBinding r2, u1 r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2.a);
        this.a = r2;
        this.b = r3;
    }
}
