package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.plugin;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.PanelMenuItem;
import com.ss.android.lark.keyboard.keyboard2.i;
import com.ss.android.lark.keyboard.plugin.tool.face.FacePagerNewAdapter;
import com.ss.android.lark.keyboard.plugin.tool.face.FaceViewPager;
import com.ss.android.lark.keyboard.plugin.tool.face.StickerTabItemView;
import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.reaction.widget.emojipanel.EmojiPageNewFragment2;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.widget.FixTouchBugViewPager;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class VoiceFaceKBPlugin extends PanelMenuItem {
    public final boolean d;
    public final FragmentManager e;
    public final IVoiceFaceDependency f;
    public View g;
    public FaceViewPager h;
    public View i;
    public View j;
    public TabLayout k;
    public EmojiPageNewFragmentNoHitPoint l;
    public FacePagerNewAdapter m;
    public final List<Fragment> n;
    public final List<Fragment> o;
    public final Function0<Unit> p;
    public boolean q;
    public final KeyboardMenuItemKey r;
    public final PanelMenuItem.InitialStrategy s;
    public final b t;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/plugin/VoiceFaceKBPlugin$EmojiPageNewFragmentNoHitPoint;", "Lcom/ss/android/lark/reaction/widget/emojipanel/EmojiPageNewFragment2;", "<init>", "()V", "notifyEmojiView", "", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class EmojiPageNewFragmentNoHitPoint extends EmojiPageNewFragment2 {
        public final void Z90() {
        }

        public EmojiPageNewFragmentNoHitPoint() {
        }
    }

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.reaction.widget.emojipanel.c {
        public final /* synthetic */ VoiceFaceKBPlugin a;

        public final void c() {
            VoiceFaceKBPlugin.H(this.a);
        }

        public b(VoiceFaceKBPlugin r1) {
            this.a = r1;
        }

        public final void e(String r8) {
            Intrinsics.checkNotNullParameter(r8, "reactionKey");
            EditText r0 = this.a.n().L().c();
            if (r0 == null) goto L31;
            String r1 = "[" + qsb.b.a().df(r8) + ']';
            qsb.a r2 = qsb.b.a().Yd(r8);
            if (r2 == null) goto L7;
            String r3 = r2.a;
        L8:
            if (r3 != null) goto L10;
        L13:
            boolean r4 = true;
        L15:
            if (r4 == false) goto L18;
            Log.i("FaceKBPluginNew", "click reaction = " + r8 + " from emoji panel failed: emoji key is null");
            return;
        L18:
            Drawable r5 = EmojiHandler.c(r3, null, null);
            Intrinsics.checkNotNullParameter(r0, "<this>");
            if ((r0 instanceof FunctionEditText) == false) goto L22;
            if (r5 == null) goto L22;
            ExtensionEditTextCompatKt.a(r0, r0.getContext(), r5, r3, r1);
            Unit r9 = Unit.INSTANCE;
        L29:
            this.a.f.b(r3);
            return;
        L22:
            Log.i("FaceKBPluginNew", "click reaction = " + r8 + " from emoji panel failed: emoji drawable is null");
            int r10 = r0.getSelectionStart();
            Editable r6 = r0.getEditableText();
            if (r10 >= 0) goto L25;
        L28:
            r6.append(r1);
            goto L29
        L25:
            if (r10 >= r6.length()) goto L28;
            r6.insert(r10, r1);
            goto L29
        L10:
            if (r3.length() == 0) goto L13;
            r4 = false;
            goto L15
        L7:
            r3 = null;
            goto L8
        }
    }

    static {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return 2131254312;
    }

    public final void J() {
        if (this.g == null) goto L5;
        return;
    L5:
        Activity r0 = n().l().getContext();
        RelativeLayout r1 = new RelativeLayout(r0);
        r1.setId(2131389089);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        RelativeLayout r2 = new RelativeLayout(r0);
        r2.setId(2131364535);
        RelativeLayout.LayoutParams r6 = new RelativeLayout.LayoutParams(-1, UIUtils.dp2px(r0, 40.0f));
        r2.setBackgroundColor(UIUtils.getColor(r0, 2131100548));
        r6.addRule(12, -1);
        r1.addView(r2, r6);
        ViewPager r9 = null;
        View r7 = LayoutInflater.from(r0).inflate(2131561736, null);
        r7.setId(2131371556);
        RelativeLayout.LayoutParams r10 = new RelativeLayout.LayoutParams(-2, UIUtils.dp2px(r0, 40.0f));
        r10.addRule(0, 2131364509);
        r10.addRule(9, -1);
        r2.addView(r7, r10);
        FrameLayout r8 = new FrameLayout(r0);
        r8.setId(2131364509);
        RelativeLayout.LayoutParams r11 = new RelativeLayout.LayoutParams(-2, -1);
        r11.addRule(11, -1);
        r11.addRule(15, -1);
        r2.addView(r8, r11);
        ImageView r3 = new ImageView(r0);
        r3.setId(2131363777);
        FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(UIUtils.dp2px(r0, 49.5f), UIUtils.dp2px(r0, 40.0f));
        r12.gravity = 17;
        r3.setBackground(UIUtils.getDrawable(r0, 2131235943));
        r3.setPadding(UIUtils.dp2px(r0, 14.5f), UIUtils.dp2px(r0, 8.5f), UIUtils.dp2px(r0, 14.5f), UIUtils.dp2px(r0, 8.0f));
        r3.setImageDrawable(UDIconUtils.getIconDrawable(r0, 2131254198, UIUtils.getColor(r0, 2131102420)));
        r3.setVisibility(0);
        r8.addView(r3, r12);
        FixTouchBugViewPager r4 = new FaceViewPager(r0, null);
        r4.setId(2131389092);
        RelativeLayout.LayoutParams r13 = new RelativeLayout.LayoutParams(-1, -1);
        r13.addRule(2, 2131364535);
        r4.setBackgroundColor(UIUtils.getColor(r0, 2131100545));
        r1.addView(r4, r13);
        this.g = r1;
        ViewPager r5 = (FaceViewPager) r1.findViewById(2131389092);
        this.h = r5;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r5 = null;
    L8:
        r5.setOffscreenPageLimit(1);
        View r14 = this.g;
        if (r14 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r14 = null;
    L11:
        this.k = r14.findViewById(2131371556);
        View r15 = this.g;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r15 = null;
    L14:
        View r16 = r15.findViewById(2131363777);
        this.j = r16;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDeleteEmojiBtn");
        r16 = null;
    L17:
        r16.setOnClickListener(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.plugin.b(this));
        TabLayout r17 = this.k;
        if (r17 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r17 = null;
    L20:
        FaceViewPager r18 = this.h;
        if (r18 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r18 = null;
    L23:
        r17.addOnTabSelectedListener(new c(this, r18));
        FacePagerNewAdapter r19 = new FacePagerNewAdapter(this.e, this.n);
        this.m = r19;
        b r20 = this.t;
        Intrinsics.checkNotNullParameter(r20, "onEmojiOperationListener");
        r19.b = r20;
        ViewPager r21 = this.h;
        if (r21 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r21 = null;
    L26:
        PagerAdapter r22 = this.m;
        if (r22 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("newAdapter");
        r22 = null;
    L29:
        r21.setAdapter(r22);
        TabLayout r23 = this.k;
        if (r23 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r23 = null;
    L32:
        ViewPager r24 = this.h;
        if (r24 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r24 = null;
    L35:
        r23.setupWithViewPager(r24);
        ViewPager r25 = this.h;
        if (r25 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
    L39:
        r9.addOnPageChangeListener(new VoiceFaceKBPlugin$initAdapter$1(this));
        return;
    L38:
        r9 = r25;
        goto L39
    }

    public final void K() {
        ((ArrayList) this.o).clear();
        int r0 = com.ss.android.lark.reaction.widget.emojipanel.a.a;
        d r1 = this.f.d().getValue();
        if (this.f.a().c() == false) goto L5;
        s5c.a r2 = z0.c;
    L6:
        d r3 = r1.plus(r2);
        Intrinsics.checkNotNullParameter(r3, "extraParam");
        Statistics.sendEvent("public_emoji_panel_select_view", r3.toJson());
        EmojiPageNewFragmentNoHitPoint r4 = this.l;
        if (r4 != null) goto L9;
        r4 = new EmojiPageNewFragmentNoHitPoint();
        r4.Y90();
        d r5 = this.f.d().getValue();
        Intrinsics.checkNotNullParameter(r5, "scene");
        ((EmojiPageNewFragment2) r4).h = r5;
        this.f.c();
        Intrinsics.checkNotNullParameter("", "chatId");
        ((EmojiPageNewFragment2) r4).i = "";
        this.l = r4;
    L9:
        r4.Y90();
        ((ArrayList) this.o).add(r4);
        Log.d("FaceKBPluginNew", "initSticker: Preparing to update adapter with " + ((ArrayList) this.o).size() + " fragments.");
        ((ArrayList) this.n).clear();
        ((ArrayList) this.n).addAll(this.o);
        TabLayout r6 = this.k;
        TabLayout r7 = null;
        if (r6 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r6 = null;
    L12:
        r6.removeAllTabs();
        FacePagerNewAdapter r8 = this.m;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("newAdapter");
        r8 = null;
    L15:
        r8.notifyDataSetChanged();
        TabLayout r9 = this.k;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r9 = null;
    L18:
        int r10 = r9.getTabCount();
        int r11 = 0;
    L19:
        if (r11 >= r10) goto L37;
        TabLayout r12 = this.k;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r12 = null;
    L23:
        TabLayout.Tab r13 = r12.getTabAt(r11);
        if (r13 == null) goto L37;
        HorizontalScrollView r14 = this.k;
        if (r14 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
        r14 = null;
    L29:
        StickerTabItemView r15 = new StickerTabItemView(r14.getContext(), null, 6, 0);
        if (r13.getCustomView() != null) goto L32;
    L34:
        if (r11 != 0) goto L36;
        r15.setTabIcon(2131248343);
    L36:
        r13.setCustomView(r15);
        r11 = r11 + 1;
        goto L19
    L32:
        if ((r13.getCustomView() instanceof StickerTabItemView) == false) goto L34;
        r13.setCustomView(null);
    L37:
        TabLayout r16 = this.k;
        if (r16 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mEmoticonTabs");
    L41:
        r7.setTabMode(0);
        return;
    L40:
        r7 = r16;
        goto L41
    L5:
        r2 = z0.d;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int b() {
        if (this.d == false) goto L5;
        return 2131102418;
    L5:
        return 2131102419;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final PanelMenuItem.InitialStrategy C() {
        return this.s;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return this.r;
    }

    public static final void H(VoiceFaceKBPlugin r13) {
        r13.getClass();
        KeyEvent r12 = new KeyEvent(0, 0, 0, 67, 0, 0, 0, 0, 6);
        r13.n().L().c().dispatchKeyEvent(r12);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.o
    public final void A(boolean r8) {
        Log.i("FaceKBPluginNew", "onSelectChange: " + r8);
        View r2 = null;
        FaceViewPager r3 = null;
        FaceViewPager r4 = null;
        if (r8 == false) goto L58;
        this.p.invoke();
        if (this.q == true) goto L35;
        this.f.e();
        View r9 = this.i;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r9 = null;
    L10:
        if ((r9 instanceof ImageView) == false) goto L12;
        ImageView r10 = (ImageView) r9;
    L13:
        if (r10 == null) goto L15;
        r10.setImageResource(2131254311);
    L15:
        View r11 = this.i;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r11 = null;
    L18:
        r11.setSelected(false);
        View r12 = this.g;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r12 = null;
    L21:
        r12.setVisibility(0);
        View r13 = this.g;
        if (r13 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r13 = null;
    L24:
        View r5 = this.g;
        if (r5 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r5 = null;
    L27:
        ViewGroup.LayoutParams r0 = r5.getLayoutParams();
        r0.height = -2;
        r13.setLayoutParams(r0);
        K();
        ViewPager r14 = this.h;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r14 = null;
    L30:
        r14.setCurrentItem(0, false);
        FaceViewPager r15 = this.h;
        if (r15 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
    L34:
        r3.setEnableScroll(false);
        int r16 = com.ss.android.lark.reaction.widget.emojipanel.a.a;
        Statistics.sendEvent("public_emoji_panel_widget_view");
        this.q = true;
        return;
    L33:
        r3 = r15;
        goto L34
    L12:
        r10 = null;
        goto L13
    L35:
        this.f.e();
        View r17 = this.i;
        if (r17 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r17 = null;
    L39:
        if ((r17 instanceof ImageView) == false) goto L41;
        ImageView r18 = (ImageView) r17;
    L42:
        if (r18 == null) goto L44;
        r18.setImageResource(2131254311);
    L44:
        View r19 = this.i;
        if (r19 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r19 = null;
    L47:
        r19.setSelected(false);
        View r20 = this.g;
        if (r20 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r20 = null;
    L50:
        r20.setVisibility(0);
        K();
        ViewPager r21 = this.h;
        if (r21 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
        r21 = null;
    L53:
        r21.setCurrentItem(0, false);
        FaceViewPager r22 = this.h;
        if (r22 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mVoicePagerFaceCategory");
    L57:
        r4.setEnableScroll(false);
        return;
    L56:
        r4 = r22;
        goto L57
    L41:
        r18 = null;
        goto L42
    L58:
        View r23 = this.i;
        if (r23 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r23 = null;
    L62:
        if ((r23 instanceof ImageView) == false) goto L64;
        ImageView r24 = (ImageView) r23;
    L65:
        if (r24 == null) goto L67;
        r24.setImageResource(2131254312);
    L67:
        View r25 = this.i;
        if (r25 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r25 = null;
    L70:
        r25.setSelected(false);
        View r26 = this.g;
        if (r26 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
    L74:
        r2.setVisibility(8);
        return;
    L73:
        r2 = r26;
        goto L74
    L64:
        r24 = null;
        goto L65
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final View G(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Log.i("FaceKBPluginNew", "onCreatePluginPanel initPanelView");
        if (this.g != null) goto L9;
        J();
        View r0 = this.g;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        r0 = null;
    L8:
        r4.addView(r0);
        K();
    L9:
        View r5 = this.g;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceRootView");
        return null;
    L13:
        return r5;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(i r2) {
        Intrinsics.checkNotNullParameter(r2, "iconHolder");
        Intrinsics.checkNotNullParameter(r2, "iconHolder");
        View r3 = r2.a;
        this.i = r3;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mVoiceIcon");
        r3 = null;
    L5:
        r3.setActivated(this.d);
    }

    public VoiceFaceKBPlugin(boolean r2, FragmentManager r3, IVoiceFaceDependency r4) {
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        Intrinsics.checkNotNullParameter(r4, "faceDependency");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = VoiceFaceKBPlugin$mPluginClickListener$1.INSTANCE;
        this.r = KeyboardMenuItemKey.Emoji;
        this.s = PanelMenuItem.InitialStrategy.Idle;
        this.t = new b(this);
    }
}
