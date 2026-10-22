package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.ui.BasePopupWindow;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chat.utils.ReplyInThreadUtil;
import com.ss.android.lark.chat.utils.f1;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ss.android.lark.widget.richtext.RichText;
import com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.AudioWaveBar;
import com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.PlayControlBar;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class AudioContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<AudioContentVO>, AudioContentVO> implements e6b.a {
    public static final e6b.c o = null;
    public static final e6b.c p = null;
    public final IMMessageKeys$Blocks g;
    public final List<com.ss.android.lark.blueprint.j> h;
    public AudioWaveBar i;
    public BasePopupWindow j;
    public final b3b.f k;
    public final b3b.f l;
    public final Lazy m;
    public final Lazy n;

    public static final class AudioPlayCallbackHandler implements com.ss.android.lark.audio.opus.e.a {
        public final b3b.b a;
        public final com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a b;
        public final String c;
        public final Handler d;

        public static final class a implements Runnable {
            public final /* synthetic */ AudioPlayCallbackHandler a;
            public final /* synthetic */ Function0<Unit> b;

            public a(AudioPlayCallbackHandler r1, Function0<Unit> r2) {
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

        public final void a() {
            c(new AudioContentBlock$AudioPlayCallbackHandler$error$1(this));
        }

        public final void pause() {
            c(new AudioContentBlock$AudioPlayCallbackHandler$pause$1(this));
        }

        public final void resume() {
            c(new AudioContentBlock$AudioPlayCallbackHandler$resume$1(this));
        }

        public final void stop() {
            c(new AudioContentBlock$AudioPlayCallbackHandler$stop$1(this));
        }

        public final void start() {
            tob.a.a();
            b3b.b r0 = this.a;
            if (r0 == null) goto L5;
            r0.k(this.c);
        L5:
            c(new AudioContentBlock$AudioPlayCallbackHandler$start$1(this));
        }

        public final void b(final float r2) {
            c(new AudioContentBlock$AudioPlayCallbackHandler$updateProgress$1(this, r2));
        }

        public final void c(Function0<Unit> r3) {
            this.d.post(new a(this, r3));
        }

        public AudioPlayCallbackHandler(b3b.f r2, PlayControlBar r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "mAudioView");
            Intrinsics.checkNotNullParameter(r4, "mMessageId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = new Handler(Looper.getMainLooper());
        }
    }

    public static final class a implements com.ss.android.lark.blueprint.k<View>, e9c.a {
        public final View a;
        public final n2b.d b;

        public final TextView d() {
            return this.b.f;
        }

        public final ImageView e() {
            return this.b.g;
        }

        public final View getView() {
            return this.a;
        }

        public a(View r27) {
            Intrinsics.checkNotNullParameter(r27, "view");
            this.a = r27;
            int r3 = n2b.a.v;
            Intrinsics.checkNotNullParameter(r27, "root");
            View r6 = ViewCompat.requireViewById(r27, 2131364930);
            View r7 = ViewCompat.requireViewById(r27, 2131364901);
            ImageView r8 = (ImageView) ViewCompat.requireViewById(r27, 2131384095);
            View r9 = ViewCompat.requireViewById(r27, 2131377792);
            View r10 = ViewCompat.requireViewById(r27, 2131389181);
            View r11 = ViewCompat.requireViewById(r27, 2131364481);
            LKUILightTextView r12 = ViewCompat.requireViewById(r27, 2131388367);
            LKUILightTextView r4 = ViewCompat.requireViewById(r27, 2131384497);
            r4.setTextSize((int) UIHelper.sp2px(16.0f));
            Unit r5 = Unit.INSTANCE;
            n2b.d r2 = new n2b.d(new n2b.a((ConstraintLayout) r27, r6, r7, r8, r9, r10, r11, r12, r4, ViewCompat.requireViewById(r27, 2131388504), (ViewStub) ViewCompat.requireViewById(r27, 2131388520), ViewCompat.requireViewById(r27, 2131388519), ViewCompat.requireViewById(r27, 2131382427), ViewCompat.requireViewById(r27, 2131382426), ViewCompat.requireViewById(r27, 2131383915), ViewCompat.requireViewById(r27, 2131383917), (ViewStub) ViewCompat.requireViewById(r27, 2131383921), ViewCompat.requireViewById(r27, 2131383920), (TextView) ViewCompat.requireViewById(r27, 2131383913), ViewCompat.requireViewById(r27, 2131383914), ViewCompat.requireViewById(r27, 2131363448)));
            r2.a.s.setText(2131890342);
            n2b.a r1 = r2.a;
            r1.h.setTextSize((int) zz7.b.i(r1.o.getContext(), LarkFont.HEADLINE));
            LKUILightTextView r13 = r2.a.o;
            r13.setTextSize((int) zz7.b.i(r13.getContext(), LarkFont.TITLE4));
            zz7.a.d(r2.a.s, LarkFont.CAPTION0);
            Context r14 = r2.a.a.getContext();
            Intrinsics.checkNotNull(r14);
            int r15 = zz7.b.g(r14, 12);
            Drawable r16 = UIUtils.getDrawable(r14, 2131237537);
            r16.setBounds(0, 0, r15, r15);
            r2.a.s.setCompoundDrawables(r16, null, null, null);
            this.b = r2;
        }
    }

    public static final class b {
    }

    public static final class c implements com.ss.android.lark.blueprint.k<View> {
        public final View a;
        public final AnimationDrawable b;
        public final a c;

        public static final class a implements View.OnAttachStateChangeListener {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View r2) {
                Intrinsics.checkNotNullParameter(r2, "v");
                this.a.b.start();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View r2) {
                Intrinsics.checkNotNullParameter(r2, "v");
                this.a.b.stop();
            }
        }

        public final View getView() {
            return this.a;
        }

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.a = r2;
            Drawable r3 = ((ImageView) r2.findViewById(2131384058)).getDrawable();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
            this.b = (AnimationDrawable) r3;
            this.c = new a(this);
        }
    }

    static {
        o = new e6b.c(null);
        p = new e6b.c(null);
    }

    public final com.ss.android.lark.blueprint.j getKey() {
        return this.g;
    }

    public AudioContentBlock(com.ss.android.lark.blueprint.g r3) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        super(r3);
        IMMessageKeys$Blocks r4 = IMMessageKeys$Blocks.AUDIO_CONTENT;
        this.g = r4;
        this.h = CollectionsKt.listOf(new com.ss.android.lark.blueprint.j[]{r4, o, p});
        b3b.f r5 = this.d;
        this.k = r5;
        this.l = r5;
        LazyThreadSafetyMode r6 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.m = LazyKt.lazy(r6, AudioContentBlock$mFeatureConfigDependency$2.INSTANCE);
        this.n = LazyKt.lazy(r6, new AudioContentBlock$mHideRead$2(this));
    }

    @Override // e6b.a
    public final e6b.a.C0216a e(com.ss.android.lark.blueprint.j r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return new e6b.a.C0216a(this.h.indexOf(r3), this.h.size());
    }

    public final boolean i(y6b.a<AudioContentVO> r8) {
        AudioContentVO r0 = r8.b();
        if (r0.f() <= 0) goto L5;
        long r1 = r0.f();
    L7:
        if (r0.l() == false) goto L9;
    L13:
        return false;
    L9:
        if (r8.isPreMessage() == true) goto L13;
        if ((System.currentTimeMillis() - (r1 * ((long) 1000))) >= 30000) goto L13;
        return true;
    L5:
        r1 = r8.getCreateTime();
        goto L7
    }

    public final boolean j(y6b.a<AudioContentVO> r5) {
        AudioContentVO r0 = r5.b();
        if (r0.k() == true) goto L22;
        String r1 = r0.i();
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L17;
        if (i(r5) == true) goto L17;
        if (((RichText) r0.n.getValue()) != null) goto L17;
        return false;
    L17:
        if (r0.w == false) goto L19;
        return false;
    L19:
        if (((w4b.k) this.m.getValue()).b() == false) goto L25;
        return true;
    L25:
        return false;
    L7:
        if (r1.length() == 0) goto L10;
        r2 = false;
        goto L11
    L22:
        return false;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<AudioContentVO>> r2, com.ss.android.lark.blueprint.q<y6b.a<AudioContentVO>> r3) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "layout");
        com.ss.android.lark.blueprint.i.a.a(r2, r3);
        com.ss.android.lark.blueprint.k r4 = r3.f(o, IMMessageKeys$Slots.CONTENT);
        if ((r4 instanceof c) == false) goto L5;
        c r5 = (c) r4;
    L6:
        if (r5 == null) goto L9;
        r5.a.removeOnAttachStateChangeListener(r5.c);
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public static final void h(AudioContentBlock r9, PlayControlBar r10, boolean r11) {
        if (r9.i != null) goto L5;
    L6:
        r9.i = new AudioWaveBar(r9.getContext());
        BasePopupWindow r0 = new BasePopupWindow(r9.i, -2, -2);
        r0.setOutsideTouchable(true);
        r9.j = r0;
    L7:
        Context r1 = r9.getContext();
        BasePopupWindow r12 = r9.j;
        if (r1 == null) goto L31;
        if (r12 == null) goto L35;
        if (r11 == true) goto L13;
    L28:
        if (r11 == true) goto L34;
        PopupWindowLancet.handleDismissBeforeOrigin(r12);
        r12.dismiss();
        return;
    L34:
        return;
    L13:
        if (r12.isShowing() == true) goto L28;
        int[] r13 = new int[2];
        r10.getLocationOnScreen(r13);
        if (r13[1] <= (UIHelper.dp2px(64.0f) + DeviceUtils.getStatusHeight(r1))) goto L17;
        int r14 = r13[1] - UIHelper.dp2px(64.0f);
    L19:
        if (PopupWindowLancet.hasSubWindowToken(r10) == false) goto L22;
        return;
    L22:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r12) == false) goto L24;
        r12.showAtLocation(r10, 49, 0, r14);
        return;
    L24:
        OverlaySource r2 = PopupWindowLancet.resolveSource(r10);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r12, r10, r2, 49, 0, r14) == true) goto L37;
        r12.showAtLocation(r10, 49, 0, r14);
        PopupWindowLancet.trackAfterShow(r12, r2, r10);
        return;
    L37:
        return;
    L17:
        r14 = r13[1] + UIHelper.dp2px(20.0f);
        goto L19
    L35:
        return;
    L31:
        return;
    L5:
        if (r9.j != null) goto L7;
        goto L6
    }

    public final void k(final com.ss.android.lark.blueprint.m<y6b.a<AudioContentVO>> r3, final LKUILightTextView r4, final y6b.a<AudioContentVO> r5) {
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("messenger.message_voice_copy") == true) goto L5;
        return;
    L5:
        if (this.c.e0() == true) goto L10;
        r4.setOnLongClickListener(new AudioContentBlock$supportRichTextCopy$1(r4, this, r5, r3));
        return;
    }

    public final void l(boolean r8, CharSequence r9, LKUILightTextView r10) {
        if (r8 == false) goto L16;
        Context r11 = getContext();
        String r0 = r9.toString();
        int r12 = ((String) r9).length() - 3;
        pl.droidsonroids.gif.d r1 = f1.a;
        SpannableStringBuilder r2 = new SpannableStringBuilder(r0);
        int r3 = r2.length();
        r2.setSpan(new ForegroundColorSpan(r11.getResources().getColor(2131106620)), Math.max(Math.min(r12, r3), 0), r3, 33);
        getContext();
        int r13 = UIUtils.dp2px(getContext(), 12.0f);
        int r4 = r2.length();
        r2.append(" ");
        int r5 = r2.length();
        if (f1.a == null) goto L18;
    L10:
        pl.droidsonroids.gif.d r6 = f1.a;
        if (r6 != null) goto L13;
    L15:
        Intrinsics.checkNotNull(r2);
        r10.setContentText(r2);
        return;
    L13:
        if (f1.b == null) goto L15;
        pl.droidsonroids.gif.m r7 = f1.b;
        r7.a(r10);
        r6.setCallback(r7);
        int r14 = r13 / 2;
        r6.setBounds(0, r14, r13, r14 + r13);
        r2.setSpan(new ImageSpan(r6, 1), r4, r5, 33);
        goto L15
    L18:
        pl.droidsonroids.gif.d r15 = new pl.droidsonroids.gif.d(UIHelper.getResources(), 2131231319);     // Catch: IOException -> L8
    L9:
        f1.a = r15;
    L8:
        r15 = null;
        goto L9
    L16:
        r10.setContentText(new SpannableString(r9));
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public void update2(com.ss.android.lark.blueprint.m<y6b.a<AudioContentVO>> r26, com.ss.android.lark.blueprint.q<y6b.a<AudioContentVO>> r27, y6b.a<AudioContentVO> r28) {
        Intrinsics.checkNotNullParameter(r26, "cell");
        Intrinsics.checkNotNullParameter(r27, "layout");
        Intrinsics.checkNotNullParameter(r28, Keys.API_RETURN_KEY_DATA);
        AudioContent.a r4 = r28.b().s;
        AudioContent.AudioState r5 = AudioContent.AudioState.RECORDING;
        e6b.c r6 = o;
        if (r4 != r5) goto L5;
        IMMessageKeys$Blocks r1 = this.g;
        IMMessageKeys$Slots r3 = IMMessageKeys$Slots.CONTENT;
        g(r27, r1, r3);
        c r2 = (c) r27.c(r6, r3, new AudioContentBlock$update$blockView$1(this));
        r2.a.addOnAttachStateChangeListener(r2.c);
        return;
    L5:
        IMMessageKeys$Slots r7 = IMMessageKeys$Slots.CONTENT;
        g(r27, r6, r7);
        a r8 = (a) r27.c(this.g, r7, new AudioContentBlock$update$blockView$2(this));
        n2b.d r9 = r8.b;
        v4b.d r10 = this.e;
        if (r10 != null) goto L8;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == false) goto L13;
        Log.i("AudioContentBlock", "message link ,audio no permission or disable click, no click");
        r9.a.n.setEnabled(false);
    L14:
        AudioContentVO r12 = r28.b();
        int r13 = ((r12.g() / 1000) - 1) / 10;
        if (r13 <= 6) goto L17;
        r13 = 6;
    L17:
        int r14 = UIHelper.dp2px((r13 * 20) + 140);
        View r15 = r9.a.b;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L331;
        ConstraintLayout.LayoutParams r17 = (ConstraintLayout.LayoutParams) r16;
        ((ViewGroup.MarginLayoutParams) r17).width = r14;
        r15.setLayoutParams(r17);
        PlayControlBar r18 = r9.a.n;
        if (r12.s != AudioContent.AudioState.DOWNLOADING) goto L22;
        boolean r19 = true;
    L23:
        ProgressBar r110 = r18.b;
        int r111 = 4;
        if (r19 == false) goto L26;
        int r112 = 0;
    L27:
        r110.setVisibility(r112);
        CheckBox r20 = r18.a;
        if (r19 == false) goto L30;
        int r21 = 4;
    L31:
        r20.setVisibility(r21);
        r9.a.n.setTag(2131363449, r28.getId());
        AudioContentVO r22 = r28.b();
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.c r23 = new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.c(r22, this, r9, r28);
        Map r113 = com.ss.android.lark.audio.f.e;
        com.ss.android.lark.audio.f r114 = com.ss.android.lark.audio.f.b.a(getContext());
        v4b.d r115 = this.e;
        if (r115 != null) goto L34;
    L36:
        boolean r116 = false;
    L37:
        if (r116 == false) goto L39;
        r114.c(r28.getcId() + r28.getId(), r23);
    L40:
        float r117 = com.ss.android.lark.audio.f.b(r22.t);
        if (com.ss.android.lark.audio.opus.e.d().e(r22.t) == false) goto L43;
        r9.a.n.startPlay();
    L45:
        if (r9.a.n.getDuration() == r22.g()) goto L47;
        r9.a.n.setDuration(r22.g());
    L47:
        r9.a.n.setProgress(r117);
        r9.a.n.setTag(r23);
        r9.a.n.setListener(new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.b(r28, this, r26, r114));
        AudioContentVO r24 = r28.b();
        if (r9.a.n.a.isChecked() == true) goto L55;
        AudioContent.a r25 = r24.s;
        AudioContent.AudioState r118 = AudioContent.AudioState.DONE_OPEN;
        if (r25 != r118) goto L55;
        AudioContent.AudioState r29 = AudioContent.AudioState.DONE;
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r24.s = r29;
        AudioContent r30 = (AudioContent) r24.a;
        if (r118 != r30.getFileState()) goto L54;
        r30.setFileState(r29);
    L54:
        r9.a.n.c();
    L55:
        FragmentActivity r31 = this.c.getContext();
        boolean r32 = r28.b().w;
        if (TextUtils.isEmpty(r28.F()) == true) goto L58;
    L60:
        boolean r119 = false;
    L62:
        if (r28.h() == false) goto L71;
        if (r32 == false) goto L65;
        int r120 = 2131237577;
    L66:
        Drawable r121 = UIUtils.getDrawable(r31, r120);
        if (r32 == false) goto L69;
        int r122 = 2131105554;
    L70:
        int r123 = UIUtils.getColor(r31, r122);
        Drawable r124 = UIUtils.getDrawable(r31, 2131247637);
        Drawable r125 = UIUtils.getDrawable(r31, 2131247640);
    L83:
        r9.a.n.setResourceAvailable(!r32);
        if (this.c.j5().b(mya.c.class) == null) goto L86;
    L87:
        v4b.d r33 = this.e;
        if (r33 != null) goto L90;
    L92:
        boolean r34 = false;
    L93:
        if (r34 == true) goto L95;
        r9.a.n.setPlayBtnDrawable(r121);
    L100:
        r9.a.n.setDurationTvColor(r123);
        r9.a.n.setProgressBarDrawable(r124);
        r9.a.n.setThumbDrawable(r125);
        TextView r35 = r9.a.s;
        boolean r36 = r28.h();
        int r126 = p3b.a.W;
        if (r36 == false) goto L103;
        int r37 = v4b.a.w;
    L104:
        r35.setTextColor(r37);
        if (r28.h() == false) goto L107;
        int r38 = 2131237539;
    L108:
        r9.a.s.setCompoundDrawablesWithIntrinsicBounds(UIUtils.getDrawable(r31, r38), null, null, null);
        View r39 = r9.a.c;
        int r40 = n2b.c.a;
        Intrinsics.checkNotNullParameter(r31, "context");
        Intrinsics.checkNotNullParameter(r28, "item");
        if (ReplyInThreadUtil.b(r28) == true) goto L111;
    L116:
        if (r119 == false) goto L119;
        int r127 = p3b.a.b(r28.h());
    L123:
        if (r119 == false) goto L128;
        float[] r128 = com.ss.android.lark.chat.utils.f0.a(r28, 10.0f, 2.0f);
        ArrayList r129 = new ArrayList(4);
        int r130 = 0;
    L125:
        if (r130 >= r111) goto L127;
        r129.add(Float.valueOf(h18.d.a(r31, r128[r130])));
        r130 = r130 + 1;
        r111 = 4;
        goto L125
    L127:
        float[] r41 = {((Number) ListProtector.get(r129, 0)).floatValue(), ((Number) ListProtector.get(r129, 0)).floatValue(), ((Number) ListProtector.get(r129, 2)).floatValue(), ((Number) ListProtector.get(r129, 2)).floatValue(), ((Number) ListProtector.get(r129, 3)).floatValue(), ((Number) ListProtector.get(r129, 3)).floatValue(), ((Number) ListProtector.get(r129, 1)).floatValue(), ((Number) ListProtector.get(r129, 1)).floatValue()};
    L132:
        Log.i("AudioMessageCellUtils", "audio radii:" + ArraysKt.joinToString$default(r41, null, null, null, 0, null, null, 63, null));
        ShapeDrawable r131 = new ShapeDrawable(new RoundRectShape(r41, null, null));
        r131.getPaint().setColor(r127);
        r39.setBackground(r131);
        boolean r42 = j(r28);
        if (((Boolean) this.n.getValue()).booleanValue() == false) goto L135;
    L149:
        r9.a.d.setVisibility(8);
    L150:
        RichText r43 = (RichText) r28.b().n.getValue();
        String r132 = BuildConfig.FLAVOR;
        if (r43 != null) goto L153;
    L200:
        boolean r44 = r28.b().j();
        boolean r45 = i(r28);
        boolean r133 = j(r28);
        n2b.a r134 = r9.a;
        if (r133 == false) goto L219;
        LKUILightTextView r135 = r134.h;
        if (r44 == false) goto L205;
        int r136 = 0;
    L206:
        r135.setVisibility(r136);
        LKUILightTextView r137 = r134.i;
        if (r44 == false) goto L209;
        int r138 = 8;
    L210:
        r137.setVisibility(r138);
        LKUILightTextView r139 = r134.o;
        if (r44 == false) goto L213;
        int r140 = 8;
    L214:
        r139.setVisibility(r140);
        TextView r141 = r134.s;
        if (r44 == false) goto L217;
        int r142 = 8;
    L218:
        r141.setVisibility(r142);
    L220:
        if (r44 == false) goto L222;
        LKUILightTextView r143 = r134.h;
    L223:
        if (r133 == false) goto L240;
        r9.a.i.setVisibility(8);
        r143.setVisibility(0);
        k(r26, r143, r28);
        String r144 = r28.b().i();
        if (r144 == null) goto L229;
        r132 = r144;
    L229:
        l(r45, r132, r143);
        TextView r145 = r9.a.s;
        if (r44 == true) goto L235;
        if (r45 == true) goto L235;
        if (r28.b().l() == false) goto L235;
        boolean r46 = true;
    L236:
        if (r46 == false) goto L238;
        int r47 = 0;
    L239:
        r145.setVisibility(r47);
        goto L240
    L238:
        r47 = 8;
    L235:
        r46 = false;
    L240:
        AudioContentVO r48 = r28.b();
        boolean r49 = r28.b().j();
        boolean r146 = j(r28);
        if (r146 == true) goto L243;
    L245:
        boolean r147 = false;
    L246:
        if (r147 == false) goto L270;
        if (r146 == false) goto L270;
        if (r49 == false) goto L260;
        n2b.a r50 = r9.a;
        View r148 = r9.b;
        if (r148 != null) goto L257;
        r148 = dwa.j.d(r50.a.getContext()).f(r50.k);
        if (r148 == null) goto L256;
        r9.b = r148;
        goto L257
    L256:
        throw new IllegalStateException("Required value was null.".toString());
    L257:
        r9.a(r148);
        r148.setVisibility(0);
        View r51 = r9.c;
        if (r51 == null) goto L276;
        r51.setVisibility(8);
    L276:
        v5b.a r52 = r48.g;
        if (r52 == null) goto L281;
        AudioContent r53 = (AudioContent) r52.a;
        if (r53 == null) goto L281;
        RichText r149 = r53.getRecognizedRichText();
    L283:
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_at_name", null) == false) goto L306;
        if (r52 == null) goto L288;
        AudioContent r54 = (AudioContent) r52.a;
        if (r54 == null) goto L288;
        String r55 = r54.getRecognizedText();
    L289:
        if (r147 == false) goto L320;
        if (r149 == null) goto L299;
        Layout r56 = c3b.b.a(r149, getContext(), r28.h(), r28.b().x, r28.b().y);
        if (r56 == null) goto L320;
        LKUILightTextView r57 = r9.e;
        if (r57 == null) goto L296;
        r57.setVisibility(0);
        r57.setContentLayout(r56);
    L296:
        LKUILightTextView r58 = r9.d;
        if (r58 == null) goto L320;
        r58.setVisibility(8);
        goto L320
    L299:
        if (r55 == null) goto L320;
        LKUILightTextView r59 = r9.d;
        if (r59 == null) goto L303;
        r59.setVisibility(0);
        r59.setContentText(r55);
    L303:
        LKUILightTextView r60 = r9.e;
        if (r60 == null) goto L320;
        r60.setVisibility(8);
    L320:
        if (e9c.b.a(r8, r28, this.c) == false) goto L335;
        TextView r61 = r9.f;
        b3b.f r62 = this.l;
        m2b.a r63 = this.c;
        Intrinsics.checkNotNullParameter(r28, "item");
        if (r61 == null) goto L325;
        r61.setOnClickListener(new e9c.c(r62, r28, r63));
    L325:
        TextView r64 = r9.f;
        if (r64 == null) goto L328;
        r64.setOnLongClickListener(new com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.a(this, r26, r28));
    L328:
        e9c.b.c(r9.g, this.l, r28, this.c);
        return;
    L335:
        return;
    L288:
        r55 = null;
        goto L289
    L306:
        if (r52 == null) goto L310;
        AudioContent r65 = (AudioContent) r52.a;
        if (r65 == null) goto L310;
        String r150 = r65.getRecognizedText();
    L311:
        if (r147 == false) goto L320;
        if (r150 == null) goto L320;
        LKUILightTextView r66 = r9.d;
        if (r66 == null) goto L316;
        r66.setVisibility(0);
        r66.setContentText(r150);
    L316:
        LKUILightTextView r67 = r9.e;
        if (r67 == null) goto L320;
        r67.setVisibility(8);
    L310:
        r150 = null;
    L281:
        r149 = null;
        goto L283
    L260:
        n2b.a r68 = r9.a;
        View r151 = r9.c;
        if (r151 != null) goto L267;
        r151 = dwa.j.d(r68.a.getContext()).f(r68.q);
        if (r151 == null) goto L266;
        r9.c = r151;
        goto L267
    L266:
        throw new IllegalStateException("Required value was null.".toString());
    L267:
        r9.a(r151);
        r151.setVisibility(0);
        View r69 = r9.b;
        if (r69 == null) goto L276;
        r69.setVisibility(8);
    L270:
        View r70 = r9.b;
        if (r70 == null) goto L273;
        r70.setVisibility(8);
    L273:
        View r71 = r9.c;
        if (r71 == null) goto L276;
        r71.setVisibility(8);
        goto L276
    L243:
        if (h7b.l.d(r48) == true) goto L245;
        r147 = true;
        goto L246
    L222:
        r143 = r134.o;
        goto L223
    L217:
        r142 = 0;
        goto L218
    L213:
        r140 = 0;
        goto L214
    L209:
        r138 = 0;
        goto L210
    L205:
        r136 = 8;
        goto L206
    L219:
        r134.h.setVisibility(8);
        r134.i.setVisibility(8);
        r134.o.setVisibility(8);
        r134.s.setVisibility(8);
        goto L220
    L153:
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_at_name", null) == false) goto L200;
        boolean r72 = r28.b().j();
        boolean r152 = i(r28);
        boolean r153 = j(r28);
        n2b.a r154 = r9.a;
        if (r153 == false) goto L173;
        LKUILightTextView r155 = r154.i;
        if (r72 == false) goto L159;
        int r73 = 0;
    L160:
        r155.setVisibility(r73);
        LKUILightTextView r74 = r154.h;
        if (r72 == false) goto L163;
        int r156 = 8;
    L164:
        r74.setVisibility(r156);
        LKUILightTextView r75 = r154.o;
        if (r72 == false) goto L167;
        int r157 = 8;
    L168:
        r75.setVisibility(r157);
        TextView r76 = r154.s;
        if (r72 == false) goto L171;
        int r158 = 8;
    L172:
        r76.setVisibility(r158);
    L174:
        if (r153 == false) goto L240;
        if (((RichText) r28.b().n.getValue()) == null) goto L240;
        if (r72 == false) goto L184;
        r9.a.i.setAtSpanClickListener(new c3b.c(this.c.getChat(), getContext()));
        RichText r77 = (RichText) r28.b().n.getValue();
        if (r77 == null) goto L189;
        Layout r78 = c3b.b.a(r77, getContext(), r28.h(), r28.b().x, r28.b().y);
        if (r78 == null) goto L189;
        r9.a.i.setContentLayout(r78);
    L189:
        k(r26, r9.a.i, r28);
        TextView r79 = r9.a.s;
        if (r72 == true) goto L195;
        if (r152 == true) goto L195;
        if (r28.b().l() == false) goto L195;
        boolean r80 = true;
    L196:
        if (r80 == false) goto L198;
        int r81 = 0;
    L199:
        r79.setVisibility(r81);
        goto L240
    L198:
        r81 = 8;
    L195:
        r80 = false;
        goto L196
    L184:
        r9.a.h.setVisibility(0);
        r9.a.i.setVisibility(8);
        String r82 = r28.b().i();
        if (r82 == null) goto L188;
        r132 = r82;
    L188:
        l(r152, r132, r9.a.o);
        goto L189
    L171:
        r158 = 0;
        goto L172
    L167:
        r157 = 0;
        goto L168
    L163:
        r156 = 0;
        goto L164
    L159:
        r73 = 8;
        goto L160
    L173:
        r154.i.setVisibility(8);
        r154.h.setVisibility(8);
        r154.o.setVisibility(8);
        r154.s.setVisibility(8);
        goto L174
    L135:
        if (r28.h() == true) goto L149;
        if (r28.C() >= 2) goto L149;
        ImageView r83 = r9.a.d;
        if ((!r42) == false) goto L141;
        int r159 = 0;
    L142:
        r83.setVisibility(r159);
        if (r42 == false) goto L150;
        if (TextUtils.isEmpty(r28.b().i()) == true) goto L150;
        b3b.f r84 = this.k;
        if (r84 == null) goto L150;
        r84.k(r28.getId());
        goto L150
    L141:
        r159 = 8;
        goto L142
    L128:
        float r85 = h18.d.a(r31, 10.0f);
        float[] r160 = new float[8];
        int r161 = 0;
    L129:
        if (r161 >= 8) goto L131;
        r160[r161] = r85;
        r161 = r161 + 1;
        goto L129
    L131:
        r41 = r160;
        goto L132
    L119:
        if (r28.h() == false) goto L121;
        r127 = v4b.a.d;
        goto L123
    L121:
        r127 = v4b.a.C;
        goto L123
    L111:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.message.thread_reply_bubble_optimize") == false) goto L116;
        if (r28.h() == false) goto L115;
        r127 = v4b.a.d;
        goto L123
    L115:
        r127 = v4b.a.C;
        goto L123
    L107:
        r38 = 2131237538;
        goto L108
    L103:
        r37 = v4b.a.S;
    L95:
        if (r28.h() == false) goto L97;
        Drawable r86 = UIUtils.getDrawable(r31, 2131237582);
    L98:
        Intrinsics.checkNotNull(r86);
        r9.a.n.setPlayBtnDrawable(r86);
        goto L100
    L97:
        r86 = UIUtils.getDrawable(r31, 2131237581);
        goto L98
    L90:
        if (r33.h != true) goto L92;
        r34 = true;
        goto L93
    L86:
        if (this.k == null) goto L95;
    L69:
        r122 = 2131102470;
        goto L70
    L65:
        r120 = 2131236125;
        goto L66
    L71:
        if (r32 == false) goto L75;
        if (r119 == false) goto L74;
        int r162 = 2131237575;
    L76:
        r121 = UIUtils.getDrawable(r31, r162);
        if (r32 == false) goto L81;
        if (r119 == false) goto L80;
        int r163 = 2131108718;
    L82:
        r123 = UIUtils.getColor(r31, r163);
        r124 = UIUtils.getDrawable(r31, 2131247636);
        r125 = UIUtils.getDrawable(r31, 2131247639);
        goto L83
    L80:
        r163 = 2131106610;
        goto L82
    L81:
        r163 = 2131102471;
        goto L82
    L74:
        r162 = 2131237576;
        goto L76
    L75:
        r162 = 2131236124;
        goto L76
    L58:
        if (r28.l() == true) goto L60;
        r119 = true;
        goto L62
    L43:
        r9.a.n.pausePlay();
        goto L45
    L39:
        r114.c(r28.getcId(), r23);
        goto L40
    L34:
        if (r115.h != true) goto L36;
        r116 = true;
        goto L37
    L30:
        r21 = 0;
        goto L31
    L26:
        r112 = 4;
        goto L27
    L22:
        r19 = false;
        goto L23
    L331:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L13:
        r9.a.n.setEnabled(true);
        AudioContentVO r87 = r28.b();
        f r88 = new f(r26, this, r28);
        OnSingleClickListener r89 = new e(this, r26, r28);
        r9.a.o.setOnLongClickListener(r88);
        r9.a.d.setOnLongClickListener(r88);
        r9.a.c.setOnLongClickListener(r88);
        r9.a.m.setOnLongClickListener(r88);
        r9.a.n.setOnLongClickListener(r88);
        r9.a.o.setOnClickListener(r89);
        r9.a.d.setOnClickListener(r89);
        r9.a.c.setOnClickListener(r89);
        OnSingleClickListener r90 = new g(this, r26, r28, r9);
        r9.a.n.setOnClickListener(r90);
        r9.a.m.setOnClickListener(r90);
        Rect r91 = com.larksuite.framework.ui.a.b;
        com.larksuite.framework.ui.a.a.a(r9.a.m, UIUtils.dp2px(getContext(), 12.0f));
        r9.a.n.setDelegate(new d(r87, this, r9, r28));
        goto L14
    L8:
        if (r10.h != true) goto L10;
        r11 = true;
        goto L11
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m<y6b.a<AudioContentVO>> r1, com.ss.android.lark.blueprint.q<y6b.a<AudioContentVO>> r2, y6b.a<AudioContentVO> r3) {
        update2(r1, r2, r3);
    }
}
