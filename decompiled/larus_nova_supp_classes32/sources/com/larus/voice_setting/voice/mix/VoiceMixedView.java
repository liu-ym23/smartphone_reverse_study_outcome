package com.larus.voice_setting.voice.mix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import com.lynx.tasm.LynxTemplateRender;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v2a.c;
import v2a.d;
import v2a.e0;
import v2a.f0;
import v2a.g0;
import v2a.h0;
import v2a.i0;
import v2a.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ+\u0010@\u001a\u00020\u001e2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001d0B2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010,\u001a\u00020-¢\u0006\u0002\u0010CJ\u001a\u0010D\u001a\u00020\u001e2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cJ$\u0010F\u001a\u00020\u001e2\u001c\u0010G\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u001e0 J\u001c\u0010H\u001a\u00020\u001e2\u0014\u0010G\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u001e0\u001cJ\u001c\u0010I\u001a\u00020\u001e2\u0014\u0010G\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u001e0\u001cJ\u000e\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020LJ\u000e\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001dJ\u0018\u0010O\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001d2\b\b\u0002\u0010P\u001a\u00020\u0018J\u000e\u0010Q\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001dJ\u0006\u0010R\u001a\u00020\u001eJ\b\u0010S\u001a\u00020\u001eH\u0002J\u0010\u0010T\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001dH\u0002J\u001a\u0010U\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001d2\b\b\u0002\u0010V\u001a\u00020-H\u0002J\u0010\u0010W\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001dH\u0002J\u0014\u0010X\u001a\u00020\u001e2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001d0BJ\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001d0BH\u0002J\u000e\u0010Z\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020%J\u0014\u0010\\\u001a\u00020\u001e2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001e0+J\b\u0010^\u001a\u0004\u0018\u00010_R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u001e\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u001d0'j\b\u0012\u0004\u0012\u00020\u001d`(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001e0+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102RJ\u00103\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0013\u0012\u00110-¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001e0 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R,\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180=0+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00100\"\u0004\b?\u00102¨\u0006`"}, d2 = {"Lcom/larus/voice_setting/voice/mix/VoiceMixedView;", "Landroid/widget/LinearLayout;", "aContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAContext", "()Landroid/content/Context;", "setAContext", "(Landroid/content/Context;)V", "getAttrs", "()Landroid/util/AttributeSet;", "setAttrs", "(Landroid/util/AttributeSet;)V", "getDefStyleAttr", "()I", "setDefStyleAttr", "(I)V", "selectVoiceMode", "tag", NameKeys.UnloadStrategy_No_Strategy, "singleView", "Lcom/larus/voice_setting/voice/mix/IVoiceMixSingleView;", "onVoiceRemove", "Lkotlin/Function1;", "Lcom/larus/im/bean/bot/MixVoice;", NameKeys.UnloadStrategy_No_Strategy, "onVoiceProportionChanged", "Lkotlin/Function2;", "Lcom/larus/im/bean/bot/SpeakerVoice;", "onVoiceAudition", "onVoiceAuditionEnd", "mViewState", "Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "pendingAddVoice", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "nowPlayingVoiceId", "mDelegateMixVoicePlay", "Lkotlin/Function0;", "defaultExpandMixVoiceView", NameKeys.UnloadStrategy_No_Strategy, "collapseCallback", "getCollapseCallback", "()Lkotlin/jvm/functions/Function0;", "setCollapseCallback", "(Lkotlin/jvm/functions/Function0;)V", "renderCountChange", "Lkotlin/ParameterName;", EasyGoDbTable.Server.NAME, "count", "defaultCollapse", "getRenderCountChange", "()Lkotlin/jvm/functions/Function2;", "setRenderCountChange", "(Lkotlin/jvm/functions/Function2;)V", "audioObserverExtraParamsGetter", NameKeys.UnloadStrategy_No_Strategy, "getAudioObserverExtraParamsGetter", "setAudioObserverExtraParamsGetter", "initVoice", "list", NameKeys.UnloadStrategy_No_Strategy, "(Ljava/util/List;Ljava/lang/Integer;Z)V", "setRemoveCallback", "removeCallback", "setVoiceProportionCallback", "callBack", "setVoiceAuditionCallback", "setVoiceAuditionEndCallback", "updateAuditionStatus", LynxTemplateRender.RENDER_PHASE_UPDATE, "Lcom/larus/voice_setting/voice/mix/res/VoiceAuditionUpdate;", "addVoice", "voice", "removeVoice", "from", "updateVoice", "clearVoice", "applyAddVoice", "realAddVoiceView", "addSingleVoice", "isFromRemove", "addMultiVoice", "updateVoiceList", "getDisplayVoiceList", "viewState", "state", "delegatePlayMixVoice", "callback", "getExpandIconView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceMixedView extends LinearLayout {
    public static final /* synthetic */ int r = 0;
    public Context a;
    public AttributeSet b;
    public int c;
    public final String d;
    public VoiceMixSingleView e;
    public Function1<? super MixVoice, Unit> f;
    public Function2<? super SpeakerVoice, ? super Integer, Unit> g;
    public Function1<? super SpeakerVoice, Unit> h;
    public Function1<? super SpeakerVoice, Unit> i;
    public AppBarLayoutStateListener.State j;
    public final ArrayList<MixVoice> k;
    public String l;
    public Function0<Unit> m;
    public boolean n;
    public Function0<Unit> o;
    public Function2<? super Integer, ? super Boolean, Unit> p;
    public Function0<? extends Map<String, String>> q;

    public static final class a implements d {
        public final /* synthetic */ VoiceMixedView a;

        @Override // v2a.d
        public final void a() {
            this.a.getCollapseCallback().invoke();
        }

        public a(VoiceMixedView r1) {
            this.a = r1;
        }

        @Override // v2a.d
        public final void c(SpeakerVoice r2) {
            Function1<? super SpeakerVoice, Unit> r0 = this.a.i;
            if (r0 == null) goto L6;
            r0.invoke(r2);
            return;
        }

        @Override // v2a.d
        public final void d(SpeakerVoice r2) {
            Function1<? super SpeakerVoice, Unit> r0 = this.a.h;
            if (r0 == null) goto L6;
            r0.invoke(r2);
            return;
        }

        @Override // v2a.d
        public final void e(MixVoice r3) {
            Intrinsics.checkNotNullParameter(r3, "item");
            VoiceMixedView r0 = this.a;
            int r1 = VoiceMixedView.r;
            r0.e(r3, "from_mix");
        }

        @Override // v2a.d
        public final void b(SpeakerVoice r2, Integer r3) {
            Function2<? super SpeakerVoice, ? super Integer, Unit> r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.invoke(r2, r3);
            return;
        }
    }

    public VoiceMixedView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "aContext");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VoiceMixedView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "aContext");
        this(r3, r4, 4, 0);
    }

    public final synchronized void c() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.k.isEmpty() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<T> r0 = this.k.iterator();     // Catch: Throwable -> L14
    L9:
        if (r0.hasNext() == false) goto L11;
        d((MixVoice) r0.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        this.k.clear();     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    private final List<MixVoice> getDisplayVoiceList() {
        ArrayList r0 = new ArrayList();
        int r1 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L13;
        KeyEvent.Callback r3 = getChildAt(r2);
        MixVoice r5 = null;
        if ((r3 instanceof c) == false) goto L7;
        c r4 = (c) r3;
    L8:
        if (r4 == null) goto L10;
        r5 = r4.getData();
    L10:
        if (r5 == null) goto L12;
        r0.add(r5);
    L12:
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = null;
        goto L8
    L13:
        return r0;
    }

    public final View getExpandIconView() {
        VoiceMixSingleView r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getExpandIconView();
    }

    public final Context getAContext() {
        return this.a;
    }

    public final AttributeSet getAttrs() {
        return this.b;
    }

    public final Function0<Map<String, String>> getAudioObserverExtraParamsGetter() {
        return this.q;
    }

    public final Function0<Unit> getCollapseCallback() {
        return this.o;
    }

    public final int getDefStyleAttr() {
        return this.c;
    }

    public final Function2<Integer, Boolean, Unit> getRenderCountChange() {
        return this.p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.larus.voice_setting.voice.mix.VoiceMixMultiView] */
    public final void a(MixVoice r4) {
        ?? r0 = new VoiceMixMultiView(this.a);
        r0.setAudioObserverExtraParamsGetter(this.q);
        r0.setListener(new a(this));
        addView(r0);
        String r1 = this.l;
        SpeakerVoice r2 = r4.getVoiceItem();
        if (r2 == null) goto L5;
        String r3 = r2.getId();
    L6:
        r0.p1(r4, Intrinsics.areEqual(r1, r3));
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void b(MixVoice r4) {
        if (this.e != null) goto L5;
        VoiceMixSingleView r0 = new VoiceMixSingleView(this.a);
        r0.setMixVoicePlayDelegate(new i0(this));
        r0.setListener(new j0(this));
        this.e = r0;
    L5:
        ConstraintLayout r1 = this.e;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.View");
        addView(r1, 0);
        VoiceMixSingleView r2 = this.e;
        if (r2 == null) goto L13;
        String r3 = this.l;
        SpeakerVoice r5 = r4.getVoiceItem();
        if (r5 == null) goto L10;
        String r6 = r5.getId();
    L11:
        r2.p1(r4, Intrinsics.areEqual(r3, r6));
        return;
    L10:
        r6 = null;
        goto L11
    }

    public final void d(MixVoice r4) {
        if (getChildCount() != 0) goto L6;
        b(r4);
        this.p.invoke(Integer.valueOf(getChildCount()), Boolean.valueOf(true ^ this.n));
        return;
    L6:
        if (getChildCount() != 3) goto L9;
        return;
    L9:
        if (getChildCount() != 1) goto L19;
        VoiceMixSingleView r0 = this.e;
        if (r0 == null) goto L13;
        MixVoice r1 = r0.getData();
    L14:
        ConstraintLayout r2 = this.e;
        if (r2 == null) goto L17;
        removeView(r2);
    L17:
        if (r1 == null) goto L19;
        a(r1);
        goto L19
    L13:
        r1 = null;
    L19:
        a(r4);
        this.p.invoke(Integer.valueOf(getChildCount()), Boolean.FALSE);
    }

    public final void f(MixVoice r8) {
        Intrinsics.checkNotNullParameter(r8, "voice");
        Iterator<MixVoice> r0 = this.k.iterator();
        int r1 = 0;
        int r2 = 0;
    L3:
        c r5 = null;
        if (r0.hasNext() == false) goto L17;
        SpeakerVoice r3 = r0.next().getVoiceItem();
        if (r3 == null) goto L8;
        String r4 = r3.getId();
    L9:
        SpeakerVoice r6 = r8.getVoiceItem();
        if (r6 == null) goto L12;
        String r7 = r6.getId();
    L14:
        if (Intrinsics.areEqual(r4, r7) == true) goto L18;
        r2 = r2 + 1;
    L18:
        if (r2 == (-1)) goto L21;
        ListProtector.set(this.k, r2, r8);
        return;
    L21:
        Iterator<MixVoice> r9 = getDisplayVoiceList().iterator();
    L23:
        if (r9.hasNext() == false) goto L36;
        SpeakerVoice r10 = r9.next().getVoiceItem();
        if (r10 == null) goto L27;
        String r11 = r10.getId();
    L28:
        SpeakerVoice r12 = r8.getVoiceItem();
        if (r12 == null) goto L31;
        String r13 = r12.getId();
    L33:
        if (Intrinsics.areEqual(r11, r13) == true) goto L37;
        r1 = r1 + 1;
    L37:
        FLogger.a.i(this.d, "[updateVoice] list:" + r8 + ", update:" + r8 + ", index:" + r1);
        if (r1 != (-1)) goto L40;
        return;
    L40:
        KeyEvent.Callback r14 = getChildAt(r1);
        if ((r14 instanceof c) == false) goto L43;
        r5 = (c) r14;
    L43:
        if (r5 == null) goto L50;
        r5.m2(r8.getVoiceItem());
        return;
    L50:
        return;
    L31:
        r13 = null;
        goto L33
    L27:
        r11 = null;
        goto L28
    L36:
        r1 = -1;
        goto L37
    L12:
        r7 = null;
        goto L14
    L8:
        r4 = null;
        goto L9
    L17:
        r2 = -1;
        goto L18
    }

    public final void g(List<MixVoice> r10) {
        Intrinsics.checkNotNullParameter(r10, "list");
        List<MixVoice> r0 = getDisplayVoiceList();
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L33;
        MixVoice r1 = (MixVoice) r11.next();
        Iterator<MixVoice> r2 = r0.iterator();
        int r3 = 0;
    L6:
        String r6 = null;
        if (r2.hasNext() == false) goto L20;
        SpeakerVoice r4 = r2.next().getVoiceItem();
        if (r4 == null) goto L11;
        String r5 = r4.getId();
    L12:
        SpeakerVoice r7 = r1.getVoiceItem();
        if (r7 == null) goto L15;
        String r8 = r7.getId();
    L17:
        if (Intrinsics.areEqual(r5, r8) == true) goto L21;
        r3 = r3 + 1;
    L21:
        FLogger.a.i(this.d, "[updateVoice] update:" + r1 + ", index:" + r3);
        if (r3 == (-1)) goto L23;
        KeyEvent.Callback r9 = getChildAt(r3);
        if ((r9 instanceof c) == false) goto L27;
        c r12 = (c) r9;
    L28:
        if (r12 == null) goto L4;
        String r13 = this.l;
        SpeakerVoice r14 = r1.getVoiceItem();
        if (r14 == null) goto L32;
        r6 = r14.getId();
    L32:
        r12.p1(r1, Intrinsics.areEqual(r13, r6));
        goto L4
    L27:
        r12 = null;
        goto L28
    L23:
        return;
    L15:
        r8 = null;
        goto L17
    L11:
        r5 = null;
        goto L12
    L20:
        r3 = -1;
        goto L21
    }

    public final void setAContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setAttrs(AttributeSet r1) {
        this.b = r1;
    }

    public final void setAudioObserverExtraParamsGetter(Function0<? extends Map<String, String>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.q = r2;
    }

    public final void setCollapseCallback(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.o = r2;
    }

    public final void setDefStyleAttr(int r1) {
        this.c = r1;
    }

    public final void setRemoveCallback(Function1<? super MixVoice, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "removeCallback");
        this.f = r2;
    }

    public final void setRenderCountChange(Function2<? super Integer, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p = r2;
    }

    public final void setVoiceAuditionCallback(Function1<? super SpeakerVoice, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.h = r2;
    }

    public final void setVoiceAuditionEndCallback(Function1<? super SpeakerVoice, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.i = r2;
    }

    public final void setVoiceProportionCallback(Function2<? super SpeakerVoice, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callBack");
        this.g = r2;
    }

    public final void e(MixVoice r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "voice");
        Intrinsics.checkNotNullParameter(r11, "from");
        Iterator<MixVoice> r0 = this.k.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L16;
        MixVoice r1 = r0.next();
        SpeakerVoice r3 = r1.getVoiceItem();
        if (r3 == null) goto L8;
        String r4 = r3.getId();
    L9:
        SpeakerVoice r5 = r10.getVoiceItem();
        if (r5 == null) goto L12;
        String r6 = r5.getId();
    L14:
        if (Intrinsics.areEqual(r4, r6) == false) goto L3;
    L17:
        MixVoice r7 = r1;
        if (r7 == null) goto L21;
        this.k.remove(r7);
        return;
    L21:
        List<MixVoice> r8 = getDisplayVoiceList();
        Iterator<MixVoice> r9 = r8.iterator();
        boolean r12 = false;
        int r13 = 0;
    L23:
        if (r9.hasNext() == false) goto L36;
        SpeakerVoice r14 = r9.next().getVoiceItem();
        if (r14 == null) goto L27;
        String r15 = r14.getId();
    L28:
        SpeakerVoice r16 = r10.getVoiceItem();
        if (r16 == null) goto L31;
        String r17 = r16.getId();
    L33:
        if (Intrinsics.areEqual(r15, r17) == true) goto L37;
        r13 = r13 + 1;
    L37:
        FLogger.a.i(this.d, "[removeVoice] list:" + r10 + ", remove:" + r10 + ", index:" + r13);
        if (r13 != (-1)) goto L40;
        return;
    L40:
        int r18 = getChildCount();
        if (r18 != 1) goto L43;
        ConstraintLayout r19 = this.e;
        if (r19 == null) goto L66;
        removeView(r19);
    L66:
        if (Intrinsics.areEqual(r11, "from_mix") == false) goto L71;
        Function1<? super MixVoice, Unit> r110 = this.f;
        if (r110 == null) goto L71;
        r110.invoke(r10);
    L71:
        if (this.n == false) goto L74;
    L76:
        this.p.invoke(Integer.valueOf(getChildCount()), Boolean.valueOf(r12));
        return;
    L74:
        if (getChildCount() != 1) goto L76;
        r12 = true;
        goto L76
    L43:
        if (r18 == 2) goto L45;
        removeViewAt(r13);
        goto L66
    L45:
        removeAllViews();
        Iterator<T> r20 = r8.iterator();
    L47:
        if (r20.hasNext() == false) goto L59;
        Object r21 = r20.next();
        SpeakerVoice r22 = ((MixVoice) r21).getVoiceItem();
        if (r22 == null) goto L51;
        String r23 = r22.getId();
    L52:
        SpeakerVoice r24 = r10.getVoiceItem();
        if (r24 == null) goto L55;
        String r25 = r24.getId();
    L57:
        if ((!Intrinsics.areEqual(r23, r25)) == false) goto L47;
        r2 = r21;
        goto L59
    L55:
        r25 = null;
        goto L57
    L51:
        r23 = null;
    L59:
        MixVoice r26 = (MixVoice) r2;
        if (r26 == null) goto L66;
        b(r26);
        goto L66
    L31:
        r17 = null;
        goto L33
    L27:
        r15 = null;
        goto L28
    L36:
        r13 = -1;
        goto L37
    L12:
        r6 = null;
        goto L14
    L8:
        r4 = null;
        goto L9
    L16:
        r1 = null;
        goto L17
    }

    public VoiceMixedView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "aContext");
        super(r2, r3, r4);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = "VoiceMixedView";
        this.j = AppBarLayoutStateListener.State.EXPANDED;
        this.k = new ArrayList();
        this.l = NameKeys.UnloadStrategy_No_Strategy;
        this.m = new e0();
        this.o = new f0();
        this.p = new g0();
        this.q = new h0();
        setOrientation(1);
    }

    public /* synthetic */ VoiceMixedView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
