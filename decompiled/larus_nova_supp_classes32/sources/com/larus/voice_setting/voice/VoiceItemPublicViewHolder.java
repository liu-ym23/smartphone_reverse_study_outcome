package com.larus.voice_setting.voice;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common.apphost.AppHost;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.IconItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.bot.VoiceTag;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.lynx.lottieadapter.LottieAdapterView;
import com.obric.aivoice.core.data.NameKeys;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010&\u001a\u00020'H\u0002J\u001a\u0010,\u001a\u00020%2\b\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0016J\u000e\u00105\u001a\u00020%2\u0006\u00106\u001a\u000200R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \t*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \t*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \t*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \t*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \t*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \t*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n \t*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n \t*\u0004\u0018\u00010 0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \t*\u0004\u0018\u00010 0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n \t*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n \t*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/larus/voice_setting/voice/VoiceItemPublicViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/voice_setting/voice/BaseVoiceItem;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "moreBtn", "Landroidx/appcompat/widget/AppCompatImageView;", "addBtn", "selectedIcon", "selectingIcon", "Landroid/widget/ProgressBar;", "lottiePlay", "Lcom/lynx/lottieadapter/LottieAdapterView;", "newLottiePlay", "voiceAvatar", "Lcom/facebook/drawee/view/SimpleDraweeView;", "voiceName", "Landroidx/appcompat/widget/AppCompatTextView;", "reviewingArea", "Landroidx/appcompat/widget/LinearLayoutCompat;", "uploadingIcon", "errorIcon", "stateText", "selectorGroup", "createArea", "permissionIcon", "permissionText", "Landroid/widget/TextView;", "dateText", "dividerDot", "divider", "bindData", NameKeys.UnloadStrategy_No_Strategy, "voiceItem", "Lcom/larus/voice_setting/voice/VoiceItem;", "config", "Lcom/larus/voice_setting/voice/VoiceItemAdapterConfig;", "getCreateNameTag", NameKeys.UnloadStrategy_No_Strategy, "bindTag", "preTag", "changeDividerVisibility", "isVisible", NameKeys.UnloadStrategy_No_Strategy, "setMoreBtnClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "setAddBtnClickListener", "setAddAreaAnimation", "clickAdd", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceItemPublicViewHolder extends RecyclerView.ViewHolder implements com.larus.voice_setting.voice.a {
    public final Context a;
    public final AppCompatImageView b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final ProgressBar e;
    public final LottieAdapterView f;
    public final LottieAdapterView g;
    public final SimpleDraweeView h;
    public final AppCompatTextView i;
    public final LinearLayoutCompat j;
    public final ProgressBar k;
    public final AppCompatImageView l;
    public final AppCompatTextView m;
    public final LinearLayoutCompat n;
    public final LinearLayoutCompat o;
    public final AppCompatImageView p;
    public final TextView q;
    public final TextView r;
    public final View s;
    public final View t;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.voice_setting.voice.a
    public final void detach() {
    }

    public VoiceItemPublicViewHolder(ConstraintLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2.getContext();
        this.b = r2.findViewById(2131392757);
        this.c = r2.findViewById(2131392644);
        this.d = r2.findViewById(2131392758);
        this.e = (ProgressBar) r2.findViewById(2131392759);
        this.f = r2.findViewById(2131382437);
        this.g = r2.findViewById(2131380757);
        this.h = r2.findViewById(2131392707);
        this.i = r2.findViewById(2131392763);
        this.j = r2.findViewById(2131384491);
        this.k = (ProgressBar) r2.findViewById(2131392762);
        this.l = r2.findViewById(2131392756);
        this.m = r2.findViewById(2131392761);
        this.n = r2.findViewById(2131392760);
        this.o = r2.findViewById(2131368182);
        this.p = r2.findViewById(2131382164);
        this.q = (TextView) r2.findViewById(2131382170);
        this.r = (TextView) r2.findViewById(2131368195);
        this.s = r2.findViewById(2131369222);
        this.t = r2.findViewById(2131369197);
    }

    @Override // com.larus.voice_setting.voice.a
    public final void W1(r2 r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
        com.larus.utils.e1.c(this.c, r2);
    }

    @Override // com.larus.voice_setting.voice.a
    public final void l3(boolean r2) {
        View r0 = this.t;
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
    public final void d2(o2 r17, t2 r18) {
        Intrinsics.checkNotNullParameter(r18, "config");
        if (r17 == null) goto L280;
        SpeakerVoice r3 = r17.a;
        if (r3 == null) goto L292;
        SimpleDraweeView r4 = this.h;
        int r5 = com.larus.voice_setting.voice.utils.l.a;
        int r6 = 1;
        if (AppHost.a.isOversea() == true) goto L10;
    L13:
        boolean r7 = true;
    L14:
        if (r7 == false) goto L16;
        int r8 = 0;
    L17:
        r4.setVisibility(r8);
        AppCompatImageView r9 = this.b;
        if (r3.isUgcVoice() == true) goto L20;
    L28:
        boolean r10 = false;
    L29:
        if (r10 == false) goto L31;
        int r11 = 0;
    L32:
        r9.setVisibility(r11);
        this.i.setText(r3.getName());
        IconItem r12 = r3.getIcon();
        String r13 = null;
        if (r12 == null) goto L35;
        String r14 = r12.getUrl();
    L36:
        if (r14 != null) goto L38;
    L41:
        boolean r15 = true;
    L42:
        if (r15 == false) goto L45;
        r14 = null;
    L45:
        if (r14 == null) goto L47;
        ImageLoaderKt.u(this.h, r14, "voice_item_public_1");
    L50:
        SpeakerVoice r16 = r17.a;
        if (r16 == null) goto L53;
        String r19 = r16.getCreatorUserName();
    L55:
        if (lq9.g0.b(r17.a) == false) goto L57;
    L65:
        r18.getClass();
        if (com.larus.voice_setting.voice.utils.f.a.g() == false) goto L68;
    L71:
        boolean r20 = true;
    L72:
        Page r110 = r18.c;
        if (r110 != Page.MULTI_TAB) goto L75;
    L81:
        boolean r21 = true;
    L82:
        if (r21 == false) goto L84;
    L85:
        this.n.setMinimumWidth(this.a.getResources().getDimensionPixelSize(v19.c.b(2130971299, this.a, 2131166968)));
        LinearLayoutCompat r22 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131377098);
        TextView r111 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131377107);
        SpannableStringBuilder r112 = new SpannableStringBuilder();
        if (r13 == null) goto L88;
        r112.append(r13);
        int r23 = 1;
    L89:
        SpeakerVoice r113 = r17.a;
        if (r113 == null) goto L93;
        List r114 = r113.getTagList();
        if (r114 == null) goto L93;
    L94:
        Iterator r115 = r114.iterator();
    L96:
        if (r115.hasNext() == false) goto L104;
        VoiceTag r116 = (VoiceTag) r115.next();
        if (com.larus.utils.o0.d(r116.getTagValue()) == false) goto L96;
        r23 = r23 + 1;
        if (r23 <= r6) goto L102;
        r112.append(" | ");
        int r117 = r112.length();
        Context r24 = this.a;
        r112.setSpan(new ForegroundColorSpan(ContextCompat.getColor(r24, v19.c.b(2130972080, r24, 2131103140))), r117 - 3, r117, 33);
    L102:
        r112.append(r116.getTagValue());
        r6 = 1;
        goto L96
    L104:
        if (com.larus.utils.o0.d(r112.toString()) == false) goto L106;
        Intrinsics.checkNotNull(r22);
        com.larus.utils.e1.x(r22);
        r111.setText(r112);
    L107:
        Page r25 = r18.c;
        Page r26 = Page.VOICE_RECOMMEND_TAB;
        if (r25 != r26) goto L110;
        boolean r27 = true;
    L111:
        if (r27 == false) goto L117;
        AppCompatTextView r28 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131364109);
        if (r17.a.getBestMatch() == false) goto L115;
        Intrinsics.checkNotNull(r28);
        com.larus.utils.e1.x(r28);
        goto L117
    L115:
        Intrinsics.checkNotNull(r28);
        com.larus.utils.e1.o(r28);
    L117:
        if (r18.a() == false) goto L161;
        int r29 = r17.e;
        if (r29 != 60) goto L153;
        Function1<SpeakerVoice, Boolean> r30 = r18.g;
        if (r30 == null) goto L125;
        int r31 = 1;
        if (((Boolean) r30.invoke(r17.a)).booleanValue() != true) goto L126;
        boolean r32 = true;
    L127:
        if (r32 == true) goto L129;
    L137:
        boolean r33 = false;
    L139:
        if (r33 == false) goto L148;
        AppCompatImageView r34 = this.c;
        if (r34 == null) goto L143;
        r34.setImageResource(v19.c.b(2130971891, r34.getContext(), 2131242298));
    L143:
        this.c.setAlpha(1.0f);
        this.c.setVisibility(0);
        if (z2.a.enableVoiceSettingTalkback() == false) goto L161;
        Context r35 = this.a;
        if (r35 == null) goto L161;
        this.c.setContentDescription(r35.getString(2131898886));
        goto L161
    L148:
        FlowRuntime.a().isOversea();
        AppCompatImageView r36 = this.c;
        if (r36 == null) goto L151;
        r36.setImageResource(v19.c.b(2130971891, r36.getContext(), 2131242298));
    L151:
        this.c.setAlpha(0.3f);
        this.c.setVisibility(0);
        goto L161
    L129:
        if (r17.c != r31) goto L137;
        if (r3.getStatus() != r31) goto L137;
        if (r3.getNameStatus() != r31) goto L135;
    L136:
        r33 = true;
        goto L139
    L135:
        if (r3.getNameStatus() != 4) goto L137;
    L126:
        r32 = false;
        goto L127
    L125:
        r31 = 1;
        goto L126
    L153:
        if (r29 != 70) goto L159;
        this.c.setImageResource(2131242326);
        this.c.setAlpha(1.0f);
        this.c.setVisibility(0);
        if (z2.a.enableVoiceSettingTalkback() == false) goto L161;
        Context r37 = this.a;
        if (r37 == null) goto L161;
        this.c.setContentDescription(r37.getString(2131898887));
        goto L161
    L159:
        this.c.setVisibility(8);
    L161:
        if (r18.e == true) goto L163;
    L165:
        boolean r38 = r18.a;
    L166:
        if (r38 == false) goto L177;
        int r39 = r17.b;
        if (r39 != 10) goto L170;
        this.e.setVisibility(8);
        this.d.setVisibility(8);
    L187:
        int r1 = r17.c;
        if (r1 == 1) goto L190;
        if (r1 != 3) goto L272;
        this.j.setVisibility(0);
        this.o.setVisibility(8);
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        this.m.setTextColor(ContextCompat.getColor(this.a, 2131102650));
        AppCompatTextView r2 = this.m;
        if (r3.getStatus() != 3) goto L267;
        String r40 = this.a.getString(2131911117);
    L270:
        r2.setText(r40);
        return;
    L267:
        if (r3.getNameStatus() != 3) goto L269;
        r40 = this.a.getString(2131911123);
        goto L270
    L269:
        r40 = this.a.getString(2131911070);
        goto L270
    L272:
        if (r1 != 2) goto L291;
        this.j.setVisibility(0);
        this.o.setVisibility(8);
        this.l.setVisibility(8);
        this.k.setVisibility(0);
        this.m.setText(this.a.getString(2131911057));
        AppCompatTextView r41 = this.m;
        Context r42 = this.a;
        r41.setTextColor(ContextCompat.getColor(r42, v19.c.b(2130972081, r42, 2131103143)));
        return;
    L291:
        return;
    L190:
        if (r3.getStatus() == 1) goto L192;
    L245:
        this.j.setVisibility(0);
        this.o.setVisibility(8);
        if (r3.getStatus() != 1) goto L248;
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        this.m.setTextColor(ContextCompat.getColor(this.a, 2131102650));
        if (r3.getNameStatus() != 3) goto L260;
        this.m.setText(this.a.getString(2131911123));
        return;
    L260:
        if (r3.getNameStatus() != 4) goto L288;
        this.m.setText(this.a.getString(2131911106));
        return;
    L288:
        return;
    L248:
        if (r3.getStatus() != 3) goto L251;
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        this.m.setText(this.a.getString(2131911117));
        this.m.setTextColor(ContextCompat.getColor(this.a, 2131102650));
        return;
    L251:
        if (r3.getStatus() != 4) goto L254;
        this.l.setVisibility(0);
        this.k.setVisibility(8);
        this.m.setText(this.a.getString(2131911106));
        this.m.setTextColor(ContextCompat.getColor(this.a, 2131102650));
        return;
    L254:
        if (r3.getStatus() != 10) goto L285;
        this.l.setVisibility(8);
        this.k.setVisibility(0);
        this.m.setText(this.a.getString(2131911057));
        AppCompatTextView r43 = this.m;
        Context r44 = this.a;
        r43.setTextColor(ContextCompat.getColor(r44, v19.c.b(2130972081, r44, 2131103143)));
        return;
    L285:
        return;
    L192:
        if (r3.getNameStatus() != 1) goto L245;
        this.j.setVisibility(8);
        if (r3.getPrivateStatus() != 0) goto L200;
        AppCompatImageView r45 = this.p;
        if (r45 == null) goto L198;
        r45.setImageResource(v19.c.b(2130972003, r45.getContext(), 2131242840));
    L198:
        this.q.setText(this.a.getString(2131910771));
    L228:
        if (r3.isUgcVoice() == false) goto L234;
        this.o.setVisibility(0);
        com.larus.utils.e1.x(this.r);
        if (AppHost.a.isOversea() == false) goto L232;
        this.r.setText(new SimpleDateFormat("MM/dd").format(new Date(r3.getCreateTime() * ((long) 1000))) + ' ' + this.a.getString(2131901038));
        goto L234
    L232:
        this.r.setText(new SimpleDateFormat("MM/dd").format(new Date(r3.getCreateTime() * ((long) 1000))) + ' ' + this.a.getString(2131911049));
    L234:
        if (this.p.getVisibility() != 0) goto L236;
        boolean r46 = true;
    L237:
        if (r46 == true) goto L239;
    L244:
        com.larus.utils.e1.o(this.s);
        return;
    L239:
        if (this.r.getVisibility() != 0) goto L241;
        boolean r47 = true;
    L242:
        if (r47 == false) goto L244;
        com.larus.utils.e1.x(this.s);
        return;
    L241:
        r47 = false;
        goto L242
    L236:
        r46 = false;
        goto L237
    L200:
        if (r18.c != r26) goto L207;
        com.larus.voice_setting.voice.utils.f r48 = com.larus.voice_setting.voice.utils.f.a;
        if (((Boolean) com.larus.voice_setting.voice.utils.f.e.getValue()).booleanValue() == true) goto L204;
    L206:
        boolean r49 = false;
    L208:
        if (r49 == false) goto L226;
        String r50 = r3.getDisplayHeatScore();
        if (r50 != null) goto L212;
    L215:
        boolean r51 = true;
    L216:
        if (r51 == true) goto L226;
        this.o.setVisibility(0);
        com.larus.utils.e1.x(this.p);
        com.larus.utils.e1.x(this.q);
        AppCompatImageView r52 = this.p;
        if (r52 == null) goto L221;
        r52.setImageResource(v19.c.b(2130972001, r52.getContext(), 2131242834));
    L221:
        TextView r53 = this.q;
        String r54 = r3.getDisplayHeatScore();
        if (r54 != null) goto L225;
        r54 = NameKeys.UnloadStrategy_No_Strategy;
    L225:
        r53.setText(r54);
        goto L228
    L212:
        if (r50.length() == 0) goto L215;
        r51 = false;
    L226:
        com.larus.utils.e1.o(this.p);
        com.larus.utils.e1.o(this.q);
        goto L228
    L204:
        if (r48.c().b == false) goto L206;
        r49 = true;
        goto L208
    L207:
        com.larus.voice_setting.voice.utils.f r55 = com.larus.voice_setting.voice.utils.f.a;
        r49 = ((Boolean) com.larus.voice_setting.voice.utils.f.e.getValue()).booleanValue();
        goto L208
    L170:
        if (r39 != 20) goto L172;
        this.e.setVisibility(0);
        this.d.setVisibility(8);
        goto L187
    L172:
        if (r39 != 30) goto L187;
        this.e.setVisibility(8);
        this.d.setVisibility(0);
        goto L187
    L177:
        this.e.setVisibility(8);
        this.d.setVisibility(8);
        if (r18.a() == false) goto L180;
        LottieAdapterView r56 = this.g;
    L182:
        if (r17.d == 1) goto L184;
        Intrinsics.checkNotNull(r56);
        r56.setVisibility(8);
        r56.cancelAnimation();
        goto L187
    L184:
        if (r56.isAnimating() == true) goto L187;
        z2.a.w3();
        Intrinsics.checkNotNull(r56);
        r56.setVisibility(0);
        r56.setAnimation("lottie/text_msg_voice_playing.json");
        r56.playAnimation();
        goto L187
    L180:
        r56 = this.f;
        goto L182
    L163:
        if (r18.f != 3) goto L165;
        r38 = false;
        goto L166
    L110:
        r27 = false;
        goto L111
    L106:
        Intrinsics.checkNotNull(r22);
        com.larus.utils.e1.o(r22);
    L93:
        r114 = CollectionsKt.emptyList();
        goto L94
    L88:
        r23 = 0;
        goto L89
    L84:
        if (com.larus.utils.o0.d(r13) == false) goto L107;
    L75:
        if (r110 == Page.VOICE_RECOMMEND_TAB) goto L81;
        if (r110 != Page.UGC_RECOMMEND_TAB) goto L80;
        if (r20 == true) goto L81;
    L80:
        r21 = false;
        goto L82
    L68:
        if (r18.f != 0) goto L71;
        r20 = false;
        goto L72
    L57:
        if (Intrinsics.areEqual(r19, "豆包官方") == true) goto L65;
        if (Intrinsics.areEqual(r19, "Cici Team") == true) goto L65;
        if (((Boolean) com.larus.voice_setting.voice.utils.f.d.getValue()).booleanValue() == false) goto L65;
        if (com.larus.utils.o0.d(r19) == false) goto L65;
        r13 = "@" + r19;
        goto L65
    L53:
        r19 = null;
        goto L55
    L47:
        SimpleDraweeView r57 = this.h;
        if (r57 == null) goto L50;
        ImageLoaderKt.u(r57, AccountService.a.s(), "voice_item_public_2");
        goto L50
    L38:
        if (r14.length() == 0) goto L41;
        r15 = false;
        goto L42
    L35:
        r14 = null;
        goto L36
    L31:
        r11 = 8;
        goto L32
    L20:
        if (Intrinsics.areEqual(r3.getCreatorId(), AccountService.a.getUserId()) == false) goto L28;
        if (r18.c != Page.NON) goto L28;
        if (r3.getStatus() == 10) goto L28;
        if (r17.c == 2) goto L28;
        r10 = true;
        goto L29
    L16:
        r8 = 8;
        goto L17
    L10:
        if (com.larus.voice_setting.voice.utils.l.a() == false) goto L13;
        r7 = false;
        goto L14
    L292:
        return;
    }
}
