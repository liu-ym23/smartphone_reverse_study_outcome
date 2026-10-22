package com.larus.voicecall.impl.subtitle;

import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.audio.call.subtitle.DisplayType;
import com.larus.bmhome.utils.FormatSource;
import com.larus.bmhome.utils.s2;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusItemRecyclerSubtitleTextBinding;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u0018R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/larus/voicecall/impl/subtitle/RealtimeCallTTSSubtitleHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/voicecall/impl/subtitle/TextViewHolder;", "binding", "Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleTextBinding;", "callback", "Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;", "<init>", "(Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleTextBinding;Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;)V", "getBinding", "()Lcom/larus/voicecall/impl/databinding/LarusItemRecyclerSubtitleTextBinding;", "getCallback", "()Lcom/larus/voicecall/impl/subtitle/SubtitleTextClickListener;", "lastClickTime", NameKeys.UnloadStrategy_No_Strategy, "animator", "Landroid/animation/ObjectAnimator;", LynxResourceModule.DATA_KEY, "Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "getData", "()Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;", "setData", "(Lcom/larus/voicecall/impl/subtitle/DisplaySubtitleData;)V", "bindText", NameKeys.UnloadStrategy_No_Strategy, "removeMarkdownFormat", NameKeys.UnloadStrategy_No_Strategy, "setDotVisible", LynxUIOverlay.PROP_VISIBLE, NameKeys.UnloadStrategy_No_Strategy, "detach", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallTTSSubtitleHolder extends RecyclerView.ViewHolder implements v1 {
    public static final /* synthetic */ int e = 0;
    public final LarusItemRecyclerSubtitleTextBinding a;
    public final u1 b;
    public long c;
    public ObjectAnimator d;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.voicecall.impl.subtitle.v1
    public final void K3(final c r35) {
        Intrinsics.checkNotNullParameter(r35, LynxResourceModule.DATA_KEY);
        boolean r4 = true;
        if (r35.c != DisplayType.TTS_WAITING) goto L6;
        T3(true);
        return;
    L6:
        com.larus.voicecall.impl.utils.t.a("RealtimeCallTTSSubtitleHolder-bindText", 100, new v0(r35));
        T3(false);
        final CustomMarkdownTextView r3 = this.a.b;
        r3.setOnLongClickListener(new w0(this, r3, r35));
        r3.setOnClickListener(new x0(this, r3));
        CustomMarkdownTextView r5 = this.a.b;
        String r1 = r35.a;
        m58.t r6 = m58.h.m;
        if (r6 == null) goto L9;
        int r7 = r6.getAudioCaptionDisplayChatContentScene();
    L10:
        if (r7 != 0) goto L13;
        FLogger.a.i("RealtimeCallTTSSubtitleHolder", "removeMarkdownFormat: contentScene is 0");
    L23:
        r5.setText(r1);
        tt8.b r2 = this.a.b.getTextSelector();
        if (r2 != null) goto L26;
    L28:
        r4 = false;
    L29:
        if (r4 == false) goto L34;
        tt8.b r8 = this.a.b.getTextSelector();
        if (r8 == null) goto L34;
        r8.n();
    L34:
        if (c78.a.g.getBoolean("key_realtime_subtitle_holder_debug_flag", false) == false) goto L36;
        com.larus.utils.e1.x(this.a.d);
        return;
    L36:
        com.larus.utils.e1.o(this.a.d);
        return;
    L26:
        if (((ut8.b) r2).p != true) goto L28;
    L13:
        if (r1.length() != 0) goto L15;
        boolean r9 = true;
    L16:
        if (r9 == true) goto L23;
        gw8.c.a.getClass();
        gw8.c r10 = gw8.c.a.b();
        if (r10 == null) goto L21;
        lw8.l r11 = gw8.c.b.b(r10, this.a.b, r1, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31));
    L22:
        int r12 = s2.a;
        r1 = s2.a(r11, FormatSource.REALTIME_CALL_SUBTITLE, true);
        goto L23
    L21:
        r11 = null;
        goto L22
    L15:
        r9 = false;
        goto L16
    L9:
        r7 = 0;
        goto L10
    }

    public final void T3(boolean r3) {
        LarusItemRecyclerSubtitleTextBinding r0 = this.a;
        ImageView r1 = r0.c;
        if (r3 == false) goto L18;
        com.larus.utils.e1.o(r0.b);
        r1.setAlpha(1.0f);
        Intrinsics.checkNotNull(r1);
        com.larus.utils.e1.x(r1);
        if (this.d != null) goto L15;
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r1, View.ALPHA, new float[]{1.0f, 0.5f, 1.0f});
        this.d = r4;
        if (r4 == null) goto L9;
        r4.setDuration(1000);
    L9:
        ObjectAnimator r5 = this.d;
        if (r5 == null) goto L12;
        r5.setRepeatCount(-1);
    L12:
        ObjectAnimator r6 = this.d;
        if (r6 == null) goto L15;
        r6.setRepeatMode(2);
    L15:
        ObjectAnimator r7 = this.d;
        if (r7 == null) goto L23;
        r7.start();
        return;
    L23:
        return;
    L18:
        com.larus.utils.e1.x(r0.b);
        Intrinsics.checkNotNull(r1);
        com.larus.utils.e1.o(r1);
        ObjectAnimator r8 = this.d;
        if (r8 == null) goto L21;
        r8.cancel();
    L21:
        this.d = null;
    }

    public RealtimeCallTTSSubtitleHolder(LarusItemRecyclerSubtitleTextBinding r2, u1 r3) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2.a);
        this.a = r2;
        this.b = r3;
    }
}
