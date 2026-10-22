package com.ss.android.lark.flow.chat.message.block.audio;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.CheckBox;
import b3b.f;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audio.opus.e;
import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.blueprint.j;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.chatwindow.chat.model.preload.v2.AudioResourceLoadTask;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.open.message.IMMessageKeys;
import com.ss.android.lark.chatbase.view.LarkPlayModeTip;
import com.ss.android.lark.coremd.utils.MessageStyleHelper;
import com.ss.android.lark.flow.chat.databinding.FlowChatMessageV2BlockAudioContentBinding;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.light.LKUILightTextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowAudioContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<AudioContentVO>, Object> {
    public static final /* synthetic */ int j = 0;
    public String g;
    public long h;
    public final f i;

    public static final class AudioPlayCallbackHandler implements e.a {
        public final b3b.b a;
        public final com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a b;
        public final String c;
        public final Handler d;

        public static final class a {
        }

        public static final class b implements Runnable {
            public final /* synthetic */ AudioPlayCallbackHandler a;
            public final /* synthetic */ Function0<Unit> b;

            public b(AudioPlayCallbackHandler r1, Function0<Unit> r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AudioPlayCallbackHandler r0 = this.a;     // Catch: Throwable -> L6
                if (Intrinsics.areEqual(r0.c, r0.b.getTag(2131363449)) == false) goto L9;
                this.b.invoke();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        static {
        }

        public final void a() {
            c(new FlowAudioContentBlock$AudioPlayCallbackHandler$error$1(this));
        }

        public final void pause() {
            c(new FlowAudioContentBlock$AudioPlayCallbackHandler$pause$1(this));
        }

        public final void resume() {
            c(new FlowAudioContentBlock$AudioPlayCallbackHandler$resume$1(this));
        }

        public final void stop() {
            c(new FlowAudioContentBlock$AudioPlayCallbackHandler$stop$1(this));
        }

        public final void start() {
            tob.a.a();
            c(new FlowAudioContentBlock$AudioPlayCallbackHandler$start$1(this));
        }

        public final void b(final float r2) {
            c(new FlowAudioContentBlock$AudioPlayCallbackHandler$updateProgress$1(this, r2));
        }

        public final void c(Function0<Unit> r3) {
            this.d.post(new b(this, r3));
        }

        public AudioPlayCallbackHandler(f r2, FlowAudioPlayBar r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "mAudioView");
            Intrinsics.checkNotNullParameter(r4, "mMessageId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = new Handler(Looper.getMainLooper());
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SendStatus.values().length];
            r0[SendStatus.SENDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[SendStatus.FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[SendStatus.DRAFT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements FlowAudioPlayBar.b {
        public final /* synthetic */ FlowAudioContentBlock a;
        public final /* synthetic */ m<y6b.a<AudioContentVO>> b;
        public final /* synthetic */ FlowChatMessageV2BlockAudioContentBinding c;
        public final /* synthetic */ y6b.a<AudioContentVO> d;
        public final /* synthetic */ com.ss.android.lark.audio.f e;

        @Override // com.ss.android.lark.flow.chat.message.block.audio.FlowAudioWaveView.b
        public final void c(FlowAudioWaveView r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "view");
        }

        @Override // com.ss.android.lark.flow.chat.message.block.audio.FlowAudioPlayBar.b
        public final void b(CheckBox r5) {
            Intrinsics.checkNotNullParameter(r5, "checkBox");
            if (r5.isChecked() == false) goto L5;
            FlowAudioContentBlock.h(this.a, this.b, this.c, this.d, this.e);
            return;
        L5:
            this.a.getClass();
            e.d().g();
            c3b.a.a();
        }

        @Override // com.ss.android.lark.flow.chat.message.block.audio.FlowAudioWaveView.b
        public final void a(FlowAudioWaveView r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            e.d().g();
            MessageHitPoint.a.a().sendEvent("audio_play_drag", null);
        }

        @Override // com.ss.android.lark.flow.chat.message.block.audio.FlowAudioWaveView.b
        public final void d(FlowAudioWaveView r4, float r5) {
            Intrinsics.checkNotNullParameter(r4, "view");
            AudioContentVO r6 = this.d.b();
            float r1 = RangesKt.coerceIn(r5, 0.0f, 1.0f);
            r6.u = (int) (100 * r1);
            if (e.d().f(r6.t) == false) goto L9;
            e.d().j(r1);
            if (r1 < 0.999f) goto L7;
            e.d().m(true);
            c3b.a.a();
            return;
        L7:
            this.c.d.setProgress(r5);
            e.d().i();
            return;
        L9:
            if (r1 < 0.999f) goto L11;
            this.c.d.setProgress(0.0f);
            return;
        L11:
            this.c.d.setProgress(r5);
            FlowAudioContentBlock.h(this.a, this.b, this.c, this.d, this.e);
        }

        public c(FlowAudioContentBlock r1, m<y6b.a<AudioContentVO>> r2, FlowChatMessageV2BlockAudioContentBinding r3, y6b.a<AudioContentVO> r4, com.ss.android.lark.audio.f r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
    }

    public final j getKey() {
        return IMMessageKeys.Blocks.AUDIO_CONTENT;
    }

    public FlowAudioContentBlock(g r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        super(r2);
        this.i = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).d;
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [android.view.ViewGroup, com.ss.android.lark.flow.chat.message.block.audio.FlowAudioPlayBar] */
    public void update(final m<y6b.a<AudioContentVO>> r18, q<y6b.a<AudioContentVO>> r19, final y6b.a<AudioContentVO> r20) {
        Intrinsics.checkNotNullParameter(r18, "cell");
        Intrinsics.checkNotNullParameter(r19, "layout");
        Intrinsics.checkNotNullParameter(r20, "data");
        FlowChatMessageV2BlockAudioContentBinding r3 = (FlowChatMessageV2BlockAudioContentBinding) r19.c(IMMessageKeys.Blocks.AUDIO_CONTENT, IMMessageKeys.Slots.CONTENT, new FlowAudioContentBlock$update$blockView$1(this)).a;
        boolean r0 = MessageStyleHelper.b(r20);
        int r1 = p3b.a.W;
        if (r0 == false) goto L5;
        int r2 = v4b.a.y;
    L6:
        r3.d.update(r18, this, r20, r2);
        if (MessageStyleHelper.b(r20) == false) goto L9;
        int r4 = UIUtils.getColor(getContext(), 2131102003);
    L10:
        r3.e.setTextColor(r4);
        r3.b.setDotColor(r4);
        r3.e.setTextSize(itb.d.a.a((itb.d) LarkContext.spiByDwarf(itb.d.class), UIUtils.dp2px(getContext(), 17.0f)));
        final LKUILightTextView r5 = r3.e;
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("messenger.message_voice_copy") == true) goto L13;
    L16:
        String r6 = r20.b().i();
        AudioContentVO r7 = r20.b();
        if (r7.f() <= 0) goto L19;
        long r8 = r7.f();
    L20:
        boolean r12 = true;
        if ((System.currentTimeMillis() - (r8 * ((long) AudioViewModel.ASR_SESSION_IDLE))) >= 30000) goto L23;
        boolean r9 = true;
    L25:
        if (r7.l() == true) goto L28;
        if (r9 == false) goto L28;
        boolean r10 = true;
    L29:
        int r11 = b.a[r20.G().ordinal()];
        int r13 = 8;
        if (r11 == 1) goto L84;
        String r14 = null;
        if (r11 != 2) goto L34;
    L80:
        r3.b.setVisibility(0);
        r3.e.setVisibility(8);
        FlowAudioLoadingDotsView r15 = r3.b;
        ValueAnimator r16 = r15.f;
        if (r16 == null) goto L83;
        r16.cancel();
    L83:
        r15.f = null;
        float[] r17 = r15.e;
        r17[0] = 1.0f;
        r17[1] = 1.0f;
        r17[2] = 1.0f;
        r15.invalidate();
    L85:
        ?? r21 = r3.d;
        AudioContentVO r22 = r20.b();
        com.ss.android.lark.flow.chat.message.block.audio.a r23 = new com.ss.android.lark.flow.chat.message.block.audio.a(r22, new AudioPlayCallbackHandler(this.i, r21, r20.getId()), r20);
        Map r24 = com.ss.android.lark.audio.f.e;
        com.ss.android.lark.audio.f r25 = com.ss.android.lark.audio.f.b.a(getContext());
        v4b.d r26 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).e;
        if (r26 != null) goto L88;
    L90:
        r12 = false;
    L91:
        if (r12 == false) goto L93;
        r25.c(r20.getcId() + r20.getId(), r23);
    L94:
        float r27 = com.ss.android.lark.audio.f.b(r22.t);
        if (e.d().e(r22.t) == false) goto L98;
        r21.S5();
    L102:
        if (r27 >= 0.0f) goto L109;
        int r28 = r22.u;
        if (r28 <= 0) goto L107;
        r27 = RangesKt.coerceIn(r28 / 100.0f, 0.0f, 1.0f);
        goto L109
    L107:
        r27 = 0.0f;
    L109:
        if (r27 < 0.0f) goto L112;
        r21.a.d.setProgress(r27);
    L112:
        r21.setTag(r23);
        r3.d.setAudioPlayBarListener(new c(this, r18, r3, r20, r25));
        return;
    L98:
        if (r27 <= 0.0f) goto L100;
        r21.pausePlay();
        goto L102
    L100:
        r21.stopPlay();
        goto L102
    L93:
        r25.c(r20.getcId(), r23);
        goto L94
    L88:
        if (r26.h != true) goto L90;
    L34:
        if (r11 == 3) goto L80;
        FlowAudioLoadingDotsView r29 = r3.b;
        if (r10 == false) goto L38;
        int r110 = 0;
    L39:
        r29.setVisibility(r110);
        LKUILightTextView r30 = r3.e;
        if ((!r10) == false) goto L42;
        r13 = 0;
    L42:
        r30.setVisibility(r13);
        if (r10 == false) goto L67;
        r3.b.a();
        final String r31 = r20.getId();
        if (StringsKt.isBlank(r31) == false) goto L47;
    L66:
        r20.isPreMessage();
        goto L85
    L47:
        if (r20.isPreMessage() == true) goto L66;
        long r32 = System.currentTimeMillis();
        if (Intrinsics.areEqual(r31, this.g) == true) goto L52;
    L54:
        this.g = r31;
        this.h = r32;
        yob.e.a().getClass();
        int r33 = com.ss.android.lark.language.service.impl.a.f;
        String r34 = StringsKt.trim(com.ss.android.lark.language.service.impl.a.b.a.getLanguageSetting().toString()).toString();
        if (r34.length() <= 0) goto L57;
        boolean r35 = true;
    L58:
        if (r35 == false) goto L60;
        r14 = r34;
    L60:
        if (r14 == null) goto L64;
        final String r36 = r14.toLowerCase(Locale.US);
        if (r36 == null) goto L64;
    L65:
        ChatAppContainerV1.a.v().S4(r31, r36, new FlowAudioContentBlock$getAudioMessageRecognition$1(r31, r36));
    L64:
        r36 = "zh_ch";
        goto L65
    L57:
        r35 = false;
        goto L58
    L52:
        if ((r32 - this.h) >= 3000) goto L54;
    L67:
        r3.b.b();
        boolean r37 = TextUtils.isEmpty(r6);
        if (r37 == false) goto L70;
        r6 = getContext().getString(2131890240);
    L72:
        Intrinsics.checkNotNull(r6);
        r3.e.setContentText(new SpannableString(r6));
        if (MessageStyleHelper.b(r20) == false) goto L75;
        int r38 = UIUtils.getColor(getContext(), 2131102003);
    L76:
        LKUILightTextView r39 = r3.e;
        if (r37 == false) goto L79;
        r38 = (r38 & 16777215) | Target.SIZE_ORIGINAL;
    L79:
        r39.setTextColor(r38);
        goto L85
    L75:
        r38 = UIUtils.getColor(getContext(), 2131102004);
        goto L76
    L70:
        if (r6 != null) goto L72;
        r6 = "";
        goto L72
    L38:
        r110 = 8;
        goto L39
    L84:
        r3.b.setVisibility(0);
        r3.e.setVisibility(8);
        r3.b.a();
    L28:
        r10 = false;
        goto L29
    L23:
        r9 = false;
        goto L25
    L19:
        r8 = r20.getCreateTime();
        goto L20
    L13:
        if (((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) this).c.e0() == true) goto L16;
        r5.setOnLongClickListener(new FlowAudioContentBlock$supportRichTextCopy$1(this, r5, r18, r20));
        goto L16
    L9:
        r4 = UIUtils.getColor(getContext(), 2131102004);
        goto L10
    L5:
        r2 = v4b.a.U;
        goto L6
    }

    public /* bridge */ /* synthetic */ void update(m r1, q r2, Object r3) {
        update(r1, r2, (y6b.a) r3);
    }

    public static final void h(FlowAudioContentBlock r4, m r5, FlowChatMessageV2BlockAudioContentBinding r6, y6b.a r7, com.ss.android.lark.audio.f r8) {
        r4.getClass();
        c3b.a.a r0 = c3b.a.a;
        if (c3b.a.b(r4.getContext()) == false) goto L47;
        boolean r1 = e1c.d.m;
        e1c.d.b.a.n(AudioResourceLoadTask.class, r7.getId());
        AudioContentVO r2 = r7.b();
        String r3 = tob.a.a;
        tob.a.e(r2.g(), r7.getId(), r2.h());
        Log.d("FlowAudioContentBlock", "onPlay:" + r2.t);
        if (TextUtils.isEmpty(r2.t) == false) goto L21;
        r6.d.stopPlay();
        AudioContentVO r9 = r7.b();
        Log.d("FlowAudioContentBlock", "prepareAudio");
        Log.i("FlowAudioContentBlock", "click audio msg, id:" + r7.getId());
        v4b.d r10 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) r4).e;
        if (r10 == null) goto L12;
        boolean r11 = true;
        if (r10.h != true) goto L12;
    L13:
        if (r11 == true) goto L48;
        mya.c r12 = ((com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b) r4).c.j5().b(mya.c.class);
        if (r12 == null) goto L18;
        r9.h();
        r7.getId();
        r12.r();
        return;
    L18:
        f r13 = r4.i;
        if (r13 == null) goto L45;
        r13.z0(r9.h(), r7.getId());
        return;
    L45:
        return;
    L48:
        return;
    L12:
        r11 = false;
        goto L13
    L21:
        Lazy r14 = LarkPlayModeTip.a;
        LarkPlayModeTip.a.b(r4.getContext());
        ArrayList r15 = new ArrayList();
        r15.add(r7.getcId());
        if (r7.C() < 2) goto L24;
    L42:
        r8.e(r15);
        return;
    L24:
        if (r7.h() == true) goto L42;
        if (r4.i == null) goto L42;
        if ((r5 instanceof xza.a) == false) goto L30;
        xza.a r16 = (xza.a) r5;
    L31:
        if (r16 == null) goto L35;
        BlueprintCellViewHolder r17 = r16.i();
        if (r17 == null) goto L35;
        int r18 = r17.getAdapterPosition();
    L36:
        if (r18 < 0) goto L42;
        f r19 = r4.i;
        if (r19 == null) goto L42;
        List r20 = r19.y0(r18);
        if (r20 == null) goto L42;
        r15.addAll(r20);
    L35:
        r18 = -1;
        goto L36
    L30:
        r16 = null;
        goto L31
    }
}
