package com.larus.voice_setting.voice;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.IconItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.AccountService;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \t*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \t*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \t*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \t*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \t*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/voice_setting/voice/VoiceItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/voice_setting/voice/BaseVoiceItem;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "moreBtn", "Landroidx/appcompat/widget/AppCompatImageView;", "uploadingIcon", "Landroid/widget/ProgressBar;", "errorIcon", "selectedIcon", "stateText", "Landroidx/appcompat/widget/AppCompatTextView;", "voiceAvatar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "voiceName", "creatorName", "selectingIcon", "divider", "bindData", NameKeys.UnloadStrategy_No_Strategy, "voiceItem", "Lcom/larus/voice_setting/voice/VoiceItem;", "config", "Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;", "changeDividerVisibility", "isVisible", NameKeys.UnloadStrategy_No_Strategy, "setMoreBtnClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceItemViewHolder extends RecyclerView.ViewHolder implements a {
    public final Context a;
    public final AppCompatImageView b;
    public final ProgressBar c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final AppCompatTextView f;
    public final SimpleDraweeView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final ProgressBar j;
    public final View k;

    @Override // com.larus.voice_setting.voice.a
    public final void detach() {
    }

    public VoiceItemViewHolder(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2.getContext();
        this.b = r2.findViewById(2131392757);
        this.c = (ProgressBar) r2.findViewById(2131392762);
        this.d = r2.findViewById(2131392756);
        this.e = r2.findViewById(2131392758);
        this.f = r2.findViewById(2131392761);
        this.g = r2.findViewById(2131392707);
        this.h = r2.findViewById(2131392763);
        this.i = r2.findViewById(2131392755);
        this.j = (ProgressBar) r2.findViewById(2131392759);
        this.k = r2.findViewById(2131369197);
    }

    @Override // com.larus.voice_setting.voice.a
    public final void W1(r2 r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
    }

    @Override // com.larus.voice_setting.voice.a
    public final void l3(boolean r2) {
        View r0 = this.k;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    @Override // com.larus.voice_setting.voice.a
    public final void x1(q2 r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
        com.larus.utils.e1.c(this.b, r2);
    }

    @Override // com.larus.voice_setting.voice.a
    public final void d2(o2 r10, t2 r11) {
        Intrinsics.checkNotNullParameter(r11, "config");
        Integer r12 = null;
        if (r10 == null) goto L5;
        SpeakerVoice r0 = r10.a;
    L6:
        SimpleDraweeView r1 = this.g;
        int r2 = com.larus.voice_setting.voice.utils.l.a;
        if (AppHost.a.isOversea() == true) goto L9;
    L12:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        int r4 = 0;
    L17:
        r1.setVisibility(r4);
        if (r10 != null) goto L20;
    L22:
        boolean r5 = false;
    L23:
        if (r5 == false) goto L25;
        this.b.setVisibility(8);
    L35:
        if (r0 == null) goto L37;
        String r6 = r0.getId();
    L39:
        if (Intrinsics.areEqual(r6, "0") == false) goto L41;
        this.h.setText(this.a.getString(2131908048));
        this.g.setActualImageResource(2131239981);
        this.i.setVisibility(8);
    L78:
        if (r0 != null) goto L80;
    L82:
        boolean r7 = false;
    L84:
        if (r7 == false) goto L86;
        this.d.setVisibility(0);
        this.f.setVisibility(0);
        this.c.setVisibility(8);
        this.f.setTextColor(ContextCompat.getColor(this.a, 2131102650));
        this.f.setText(this.a.getString(2131911117));
    L120:
        if (r10 == null) goto L122;
        r12 = Integer.valueOf(r10.b);
    L122:
        if (r12 != null) goto L125;
    L127:
        if (r12 != null) goto L130;
    L132:
        if (r12 != null) goto L135;
        return;
    L135:
        if (r12.intValue() != 10) goto L140;
        this.j.setVisibility(8);
        this.e.setVisibility(8);
        return;
    L140:
        return;
    L130:
        if (r12.intValue() != 30) goto L132;
        this.j.setVisibility(8);
        this.e.setVisibility(0);
        return;
    L125:
        if (r12.intValue() != 20) goto L127;
        this.j.setVisibility(0);
        this.e.setVisibility(8);
        return;
    L86:
        if (r0 != null) goto L88;
    L90:
        boolean r8 = false;
    L91:
        if (r8 == false) goto L93;
        this.d.setVisibility(0);
        this.f.setVisibility(0);
        this.c.setVisibility(8);
        this.f.setTextColor(ContextCompat.getColor(this.a, 2131102650));
        this.f.setText(this.a.getString(2131911106));
        goto L120
    L93:
        if (r0 != null) goto L95;
    L97:
        boolean r9 = false;
    L98:
        if (r9 == true) goto L100;
    L102:
        if (r10 == null) goto L104;
        Integer r13 = Integer.valueOf(r10.c);
    L105:
        if (r13 != null) goto L108;
    L110:
        if (r13 != null) goto L113;
    L115:
        if (r13 == null) goto L120;
        if (r13.intValue() != 1) goto L120;
        this.d.setVisibility(8);
        this.f.setVisibility(8);
        this.c.setVisibility(8);
        goto L120
    L113:
        if (r13.intValue() != 3) goto L115;
        this.d.setVisibility(0);
        this.f.setVisibility(0);
        this.c.setVisibility(8);
        this.f.setTextColor(ContextCompat.getColor(this.a, 2131102650));
        this.f.setText(this.a.getString(2131911070));
        goto L120
    L108:
        if (r13.intValue() != 2) goto L110;
        this.d.setVisibility(8);
        this.f.setVisibility(0);
        this.c.setVisibility(0);
        AppCompatTextView r14 = this.f;
        Context r15 = this.a;
        r14.setTextColor(ContextCompat.getColor(r15, v19.c.b(2130972081, r15, 2131103143)));
        this.f.setText(this.a.getString(2131911057));
        this.g.setActualImageResource(v19.c.b(2130970909, ((RecyclerView.ViewHolder) this).itemView.getContext(), 2131239978));
        goto L120
    L104:
        r13 = null;
        goto L105
    L100:
        if (Intrinsics.areEqual(r0.getCreatorId(), AccountService.a.getUserId()) == false) goto L102;
        this.d.setVisibility(0);
        this.f.setVisibility(0);
        this.c.setVisibility(8);
        this.f.setTextColor(ContextCompat.getColor(this.a, 2131102650));
        this.f.setText(this.a.getString(2131911123));
        goto L120
    L95:
        if (r0.getNameStatus() != 3) goto L97;
        r9 = true;
        goto L98
    L88:
        if (r0.getStatus() != 4) goto L90;
        r8 = true;
        goto L91
    L80:
        if (r0.getStatus() != 3) goto L82;
        r7 = true;
        goto L84
    L41:
        AppCompatTextView r16 = this.h;
        if (r0 == null) goto L44;
        String r17 = r0.getName();
    L45:
        r16.setText(r17);
        SimpleDraweeView r18 = this.g;
        if (r18 == null) goto L48;
        r18.setActualImageResource(2131239977);
    L48:
        if (r0 == null) goto L54;
        IconItem r19 = r0.getIcon();
        if (r19 == null) goto L54;
        String r20 = r19.getUrl();
        if (r20 == null) goto L54;
        ImageLoaderKt.u(this.g, r20, "voice_item_avatar");
    L54:
        if (r0 != null) goto L56;
    L58:
        boolean r21 = false;
    L59:
        if (r21 == true) goto L76;
        if (r0 == null) goto L62;
        String r22 = r0.getCreatorUserName();
    L63:
        if (r22 != null) goto L65;
    L68:
        boolean r23 = true;
    L69:
        if (r23 == true) goto L76;
        this.i.setVisibility(0);
        AppCompatTextView r24 = this.i;
        StringBuilder r25 = new StringBuilder("@");
        if (r0 == null) goto L74;
        String r26 = r0.getCreatorUserName();
    L75:
        r25.append(r26);
        r24.setText(r25.toString());
        goto L78
    L74:
        r26 = null;
        goto L75
    L65:
        if (r22.length() == 0) goto L68;
        r23 = false;
        goto L69
    L62:
        r22 = null;
    L76:
        this.i.setVisibility(8);
        goto L78
    L56:
        if (r0.isUgcVoice() != true) goto L58;
        r21 = true;
        goto L59
    L44:
        r17 = null;
        goto L45
    L37:
        r6 = null;
        goto L39
    L25:
        AppCompatImageView r27 = this.b;
        if (r0 != null) goto L28;
    L30:
        boolean r28 = false;
    L31:
        if (r28 == false) goto L33;
        int r29 = 0;
    L34:
        r27.setVisibility(r29);
        goto L35
    L33:
        r29 = 8;
        goto L34
    L28:
        if (r0.isUgcVoice() != true) goto L30;
        r28 = true;
        goto L31
    L20:
        if (r10.c != 2) goto L22;
        r5 = true;
        goto L23
    L16:
        r4 = 8;
        goto L17
    L9:
        if (com.larus.voice_setting.voice.utils.l.a() == false) goto L12;
        r3 = false;
        goto L14
    L5:
        r0 = null;
        goto L6
    }
}
