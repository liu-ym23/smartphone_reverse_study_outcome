package com.larus.voice_setting.voice.mix;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.e1;
import com.larus.voice_setting.impl.databinding.LarusLayoutVoiceMixBarBinding;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import com.larus.voice_setting.voice.utils.g;
import com.lynx.lottieadapter.LottieAdapterView;
import com.lynx.tasm.LynxTemplateRender;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;
import v2a.p;
import v2a.q;
import v2a.r;
import v2a.s;
import v2a.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010)\u001a\u00020\u001a2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-J\u0018\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020,2\b\b\u0002\u00100\u001a\u00020!J\u001e\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\r2\u0006\u0010/\u001a\u00020,2\u0006\u00103\u001a\u00020\bJ\u0006\u00104\u001a\u00020\u001aJ\b\u00105\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u00020\u001aH\u0002J\b\u00107\u001a\u00020\u001aH\u0002J\b\u00108\u001a\u00020\u001aH\u0002J\b\u00109\u001a\u00020\u001aH\u0002J\b\u0010:\u001a\u00020\u001aH\u0003J\u000e\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u0015J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020@H\u0016J\u0016\u0010A\u001a\u00020\u001a2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u000e\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020ER\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0010j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR5\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001a0 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006G"}, d2 = {"Lcom/larus/voice_setting/voice/mix/VoiceMixBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/voice_setting/voice/mix/IVoicePlayButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadedVoiceListId", "Ljava/util/HashSet;", NameKeys.UnloadStrategy_No_Strategy, "Lkotlin/collections/HashSet;", "nameByKey", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mTabBarState", "Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "bindToTabLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusLayoutVoiceMixBarBinding;", "voiceRemoveListener", "Lkotlin/Function0;", NameKeys.UnloadStrategy_No_Strategy, "getVoiceRemoveListener", "()Lkotlin/jvm/functions/Function0;", "setVoiceRemoveListener", "(Lkotlin/jvm/functions/Function0;)V", "collapseCallback", "Lkotlin/Function1;", NameKeys.UnloadStrategy_No_Strategy, "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "expand", "getCollapseCallback", "()Lkotlin/jvm/functions/Function1;", "setCollapseCallback", "(Lkotlin/jvm/functions/Function1;)V", "initMixViewByVoiceList", "mixVoiceList", "Ljava/util/ArrayList;", "Lcom/larus/im/bean/bot/MixVoice;", "Lkotlin/collections/ArrayList;", "onVoiceAdd", "voice", "byReset", "onVoiceRemove", "from", "index", "onVoiceClear", "applyState", "applyVoiceCount", "applyTabBarState", "emptyState", "singleState", "mixState", "bindToAppbar", "bindToExpand", "getPlayIcon", "Landroid/widget/ImageView;", "getPlayLottieView", "Lcom/lynx/lottieadapter/LottieAdapterView;", "delegatePlayMixVoice", "callback", "processVoiceAudition", LynxTemplateRender.RENDER_PHASE_UPDATE, "Lcom/larus/voice_setting/voice/mix/res/VoiceAuditionUpdate;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceMixBar extends ConstraintLayout implements com.larus.voice_setting.voice.mix.a {
    public static final /* synthetic */ int h = 0;
    public final HashSet<String> a;
    public final HashMap<String, String> b;
    public AppBarLayoutStateListener.State c;
    public AppBarLayout d;
    public final LarusLayoutVoiceMixBarBinding e;
    public Function0<Unit> f;
    public Function1<? super Boolean, Unit> g;

    public static final class a {
    }

    static {
    }

    public VoiceMixBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceMixBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void applyState() {
        if (this.c != AppBarLayoutStateListener.State.COLLAPSED) goto L5;
    L11:
        View r0 = this.e.a;
        if (r0 == null) goto L14;
        r0.setBackgroundResource(c.b(2130970879, r0.getContext(), 2131239883));
    L14:
        e1.o(this.e.b);
        boolean r1 = true;
    L15:
        if (r1 == true) goto L17;
    L19:
        e1.q(this.e.a);
    L20:
        int r2 = this.a.size();
        if (r2 == 0) goto L25;
        if (r2 == 1) goto L24;
        e1.q(this.e.f);
        e1.q(this.e.c);
        int r3 = this.a.size();
        this.e.g.setText(getResources().getString(2131907477) + '(' + r3 + ')');
        return;
    L24:
        e1.q(this.e.f);
        e1.x(this.e.c);
        this.e.g.setText(this.b.get(CollectionsKt.firstOrNull(this.a)));
        return;
    L25:
        e1.x(this.e.f);
        e1.d(this.e.f, new u());
        View r4 = this.e.a;
        if (r4 == null) goto L28;
        r4.setBackgroundResource(c.b(2130970879, r4.getContext(), 2131239883));
    L28:
        e1.o(this.e.b);
        return;
    L17:
        if (this.a.size() <= 0) goto L19;
        e1.x(this.e.a);
        goto L20
    L5:
        if (this.a.size() == 0) goto L11;
        View r5 = this.e.a;
        if (r5 == null) goto L10;
        r5.setBackgroundResource(c.b(2130970880, r5.getContext(), 2131239886));
    L10:
        r1 = false;
        goto L15
    }

    @Override // com.larus.voice_setting.voice.mix.a
    public ImageView getPlayIcon() {
        return this.e.d;
    }

    @Override // com.larus.voice_setting.voice.mix.a
    public LottieAdapterView getPlayLottieView() {
        return this.e.e;
    }

    public final Function1<Boolean, Unit> getCollapseCallback() {
        return this.g;
    }

    public final Function0<Unit> getVoiceRemoveListener() {
        return this.f;
    }

    public final void setCollapseCallback(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setVoiceRemoveListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void R5(MixVoice r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "voice");
        if (r4 == false) goto L5;
        this.a.clear();
    L5:
        SpeakerVoice r5 = r3.getVoiceItem();
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        if (r5 == null) goto L9;
        String r6 = r5.getId();
        if (r6 == null) goto L9;
    L11:
        if (TextUtils.isEmpty(r6) == false) goto L13;
        return;
    L13:
        this.a.add(r6);
        HashMap<String, String> r1 = this.b;
        SpeakerVoice r7 = r3.getVoiceItem();
        if (r7 == null) goto L19;
        String r8 = r7.getName();
        if (r8 == null) goto L19;
        r0 = r8;
    L19:
        r1.put(r6, r0);
        applyState();
        return;
    L9:
        r6 = NameKeys.UnloadStrategy_No_Strategy;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VoiceMixBar(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.a = new HashSet();
        this.b = new HashMap();
        this.c = AppBarLayoutStateListener.State.EXPANDED;
        LayoutInflater.from(r11).inflate(2131562934, this);
        int r14 = 2131369197;
        View r2 = ViewBindings.findChildViewById(this, 2131369197);
        if (r2 == null) goto L21;
        r14 = 2131371904;
        AppCompatImageView r15 = ViewBindings.findChildViewById(this, 2131371904);
        if (r15 == null) goto L21;
        r14 = 2131382433;
        AppCompatImageView r16 = ViewBindings.findChildViewById(this, 2131382433);
        if (r16 == null) goto L21;
        r14 = 2131382437;
        LottieAdapterView r5 = ViewBindings.findChildViewById(this, 2131382437);
        if (r5 == null) goto L21;
        r14 = 2131392713;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(this, 2131392713);
        if (r6 == null) goto L21;
        r14 = 2131392725;
        if (((LinearLayout) ViewBindings.findChildViewById(this, 2131392725)) == null) goto L21;
        r14 = 2131392752;
        AppCompatImageView r9 = ViewBindings.findChildViewById(this, 2131392752);
        if (r9 == null) goto L21;
        r14 = 2131392768;
        AppCompatTextView r8 = ViewBindings.findChildViewById(this, 2131392768);
        if (r8 == null) goto L21;
        this.e = new LarusLayoutVoiceMixBarBinding(this, r2, r15, r16, r5, r6, r9, r8);
        this.f = new p();
        this.g = new q();
        setBackgroundResource(c.b(2130970879, getContext(), 2131239883));
        e1.d(r15, new r(this));
        e1.d(r9, new s(this));
        int r17 = g.a;
        g.a(r16, i5.h());
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r14)));
    }

    public /* synthetic */ VoiceMixBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
