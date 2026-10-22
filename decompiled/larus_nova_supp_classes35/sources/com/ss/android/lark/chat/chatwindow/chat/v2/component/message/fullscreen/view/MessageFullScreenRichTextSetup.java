package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.ContentData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.RichTextData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.ContentLongClickListener;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.ActionContextCreator;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.span.e0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@RichTextSetupDsl
public final class MessageFullScreenRichTextSetup {
    public static final /* synthetic */ int k = 0;
    public final Context a;
    public boolean b;
    public com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c c;
    public c d;
    public ActionContextCreator e;
    public Function0<Integer> f;
    public final Map<Integer, com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.a> g;
    public ContentLongClickListener h;
    public ContentLongClickListener i;
    public l j;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/view/MessageFullScreenRichTextSetup$ClickHandlerDsl;", BuildConfig.FLAVOR, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface ClickHandlerDsl {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/view/MessageFullScreenRichTextSetup$ContentViewsDsl;", BuildConfig.FLAVOR, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface ContentViewsDsl {
    }

    @ClickHandlerDsl
    public static final class a {
        public static final /* synthetic */ int m = 0;
        public mcc.l a;
        public mcc.o b;
        public mcc.b c;
        public mcc.i d;
        public mcc.g e;
        public mcc.h f;
        public mcc.e g;
        public mcc.n h;
        public mcc.f i;
        public mcc.a j;
        public View.OnClickListener k;
        public View.OnLongClickListener l;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.MessageFullScreenRichTextSetup$a$a, reason: collision with other inner class name */
        public static final class C0070a {
        }

        static {
        }

        public a() {
        }
    }

    public static final class b {
    }

    @ContentViewsDsl
    public static final class c {
        public static final /* synthetic */ int f = 0;
        public LKUILightTextView a;
        public LKUILightTextView b;
        public View c;
        public ViewGroup d;
        public ViewGroup e;

        public static final class a {
        }

        static {
        }

        public c() {
        }
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public MessageFullScreenRichTextSetup(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.g = new HashMap();
    }

    public static void f(LKUILightTextView r2) {
        r2.setTextSize(p.a(r2.getContext()));
        Context r0 = r2.getContext();
        Intrinsics.checkNotNullParameter(r0, "context");
        r2.setSpacingExtra(zz7.b.g(r0, 19));
    }

    public final void a(MessageFullScreenViewModel.c r12) {
        Intrinsics.checkNotNullParameter(r12, "initData");
        ContentLongClickListener r0 = this.h;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        ContentLongClickListener r1 = this.i;
        if (r1 == null) goto L8;
        r1.d();
    L8:
        ContentData r2 = r12.a.getContentData();
        if (r2 == null) goto L238;
        int r3 = r2.getContentType();
        c r4 = this.d;
        if (r4 == null) goto L15;
        LKUILightTextView r5 = r4.a;
        if (r5 == null) goto L15;
        f(r5);
    L15:
        c r6 = this.d;
        if (r6 == null) goto L20;
        LKUILightTextView r7 = r6.b;
        if (r7 == null) goto L20;
        f(r7);
    L20:
        c r8 = this.d;
        if (r8 == null) goto L26;
        ViewGroup r9 = r8.d;
        if (r9 == null) goto L26;
        r9.setVisibility(0);
    L26:
        if (r3 == 0) goto L95;
        if (r3 == 1) goto L71;
        if (r3 != 2) goto L119;
        c r10 = this.d;
        if (r10 == null) goto L35;
        LKUILightTextView r11 = r10.a;
        if (r11 == null) goto L35;
        r11.setVisibility(0);
    L35:
        c r13 = this.d;
        if (r13 == null) goto L40;
        View r14 = r13.c;
        if (r14 == null) goto L40;
        r14.setVisibility(0);
    L40:
        c r15 = this.d;
        if (r15 == null) goto L45;
        LKUILightTextView r16 = r15.b;
        if (r16 == null) goto L45;
        r16.setVisibility(0);
    L45:
        c r17 = this.d;
        if (r17 == null) goto L54;
        LKUILightTextView r18 = r17.b;
        if (r18 == null) goto L54;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L53;
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r19;
        Context r21 = this.a;
        Intrinsics.checkNotNullParameter(r21, "context");
        r20.topMargin = UIUtils.dp2px(r21, 16.0f);
        r18.setLayoutParams(r20);
        goto L54
    L53:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L54:
        c r22 = this.d;
        ConstraintLayout r23 = null;
        if (r22 == null) goto L57;
        ViewGroup r24 = r22.d;
    L59:
        if ((r24 instanceof ConstraintLayout) == false) goto L61;
        r23 = (ConstraintLayout) r24;
    L61:
        if (r23 == null) goto L119;
        if (r22 == null) goto L119;
        LKUILightTextView r25 = r22.a;
        if (r25 == null) goto L119;
        LKUILightTextView r26 = r22.b;
        if (r26 == null) goto L119;
        ConstraintSet r27 = new ConstraintSet();
        r27.clone(r23);
        r27.connect(r25.getId(), 6, 0, 6);
        r27.clear(r25.getId(), 7);
        r27.connect(r26.getId(), 6, 0, 6);
        r27.clear(r26.getId(), 7);
        r27.applyTo(r23);
        goto L119
    L57:
        r24 = null;
    L119:
        MessageFullScreenLaunchData r28 = r12.a;
        Chat r110 = r12.c;
        if (r110 == null) goto L244;
        Log.i("MsgFSRichTextSetup", "render launch data for " + r28.getMessageId());
        ContentData r29 = r28.getContentData();
        if (r29 == null) goto L239;
        int r30 = r29.getContentType();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r31 = this.c;
        if (r31 == null) goto L176;
        if (r30 == 0) goto L155;
        if (r30 == 1) goto L146;
        if (r30 != 2) goto L164;
        c r32 = this.d;
        if (r32 == null) goto L176;
        LKUILightTextView r33 = r32.a;
        if (r33 == null) goto L176;
        LKUILightTextView r34 = r32.b;
        if (r34 == null) goto L176;
        ContentLongClickListener r35 = this.i;
        if (r35 == null) goto L142;
        r35.b();
    L142:
        this.i = new ContentLongClickListener(r34, r31, this.e, new MessageFullScreenRichTextSetup$prepareLongClickListener$1(this));
        ContentLongClickListener r36 = this.h;
        if (r36 == null) goto L145;
        r36.b();
    L145:
        this.h = new ContentLongClickListener(r33, r31, this.e, new MessageFullScreenRichTextSetup$prepareLongClickListener$2(this));
    L164:
        c r37 = this.d;
        if (r37 == null) goto L171;
        ViewGroup r38 = r37.e;
        if (r38 == null) goto L171;
        ViewTreeObserver r39 = r38.getViewTreeObserver();
        if (r39 == null) goto L171;
        r39.addOnPreDrawListener(new m(this));
    L171:
        GestureDetector r40 = new GestureDetector(r31.getContext(), new o(this, r31));
        c r41 = this.d;
        if (r41 == null) goto L176;
        ViewGroup r42 = r41.e;
        if (r42 == null) goto L176;
        r42.setOnTouchListener(new n(r40));
        goto L176
    L146:
        c r43 = this.d;
        if (r43 == null) goto L176;
        LKUILightTextView r44 = r43.b;
        if (r44 == null) goto L176;
        ContentLongClickListener r45 = this.i;
        if (r45 == null) goto L154;
        r45.b();
    L154:
        this.i = new ContentLongClickListener(r44, r31, this.e);
        goto L164
    L155:
        c r46 = this.d;
        if (r46 == null) goto L176;
        LKUILightTextView r47 = r46.a;
        if (r47 == null) goto L176;
        ContentLongClickListener r48 = this.h;
        if (r48 == null) goto L163;
        r48.b();
    L163:
        this.h = new ContentLongClickListener(r47, r31, this.e);
    L176:
        if (r30 == 0) goto L210;
        if (r30 == 1) goto L200;
        if (r30 != 2) goto L220;
        RichTextData r49 = r28.getContentData().getOriginText();
        if (r49 == null) goto L245;
        Layout r50 = b(r30, r49, c(r28, r110));
        if (r50 == null) goto L190;
        c r51 = this.d;
        if (r51 == null) goto L190;
        LKUILightTextView r52 = r51.a;
        if (r52 == null) goto L190;
        r52.setContentLayout(r50);
        g(r52, r50);
        e(r52, r49.getRichText(), false);
    L190:
        RichTextData r53 = r28.getContentData().getTranslateText();
        if (r53 == null) goto L246;
        Layout r111 = b(r30, r53, d(r28, r110));
        if (r111 == null) goto L220;
        c r54 = this.d;
        if (r54 == null) goto L220;
        LKUILightTextView r55 = r54.b;
        if (r55 == null) goto L220;
        r55.setContentLayout(r111);
        g(r55, r111);
        e(r55, r53.getRichText(), true);
        goto L220
    L246:
        return;
    L245:
        return;
    L220:
        Function0<c> r112 = new MessageFullScreenRichTextSetup$bindContent$updateContentGroupGravity$1(this);
        c r56 = this.d;
        if (r56 == null) goto L228;
        ViewGroup r57 = r56.d;
        if (r57 == null) goto L228;
        l r58 = this.j;
        if (r58 == null) goto L227;
        r57.removeOnLayoutChangeListener(r58);
    L227:
        l r59 = new l(r112);
        this.j = r59;
        r57.addOnLayoutChangeListener(r59);
    L228:
        r112.invoke();
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r113 = this.c;
        if (r113 == null) goto L240;
        Fragment r114 = r113.b;
        if (r114 == null) goto L241;
        LifecycleOwner r115 = r114.getViewLifecycleOwner();
        if (r115 == null) goto L242;
        final Lifecycle r116 = r115.getLifecycle();
        if (r116 == null) goto L243;
        r116.addObserver(new MessageFullScreenRichTextSetup$bindContent$6$1(this, r116));
        return;
    L243:
        return;
    L242:
        return;
    L241:
        return;
    L240:
        return;
    L200:
        RichTextData r60 = r28.getContentData().getTranslateText();
        if (r60 == null) goto L247;
        Layout r117 = b(r30, r60, d(r28, r110));
        if (r117 == null) goto L220;
        c r61 = this.d;
        if (r61 == null) goto L220;
        LKUILightTextView r62 = r61.b;
        if (r62 == null) goto L220;
        r62.setContentLayout(r117);
        g(r62, r117);
        e(r62, r60.getRichText(), true);
        goto L220
    L247:
        return;
    L210:
        RichTextData r63 = r28.getContentData().getOriginText();
        if (r63 == null) goto L248;
        Layout r118 = b(r30, r63, c(r28, r110));
        if (r118 == null) goto L220;
        c r64 = this.d;
        if (r64 == null) goto L220;
        LKUILightTextView r65 = r64.a;
        if (r65 == null) goto L220;
        r65.setContentLayout(r118);
        g(r65, r118);
        e(r65, r63.getRichText(), false);
        goto L220
    L248:
        return;
    L239:
        return;
    L244:
        return;
    L71:
        c r66 = this.d;
        if (r66 == null) goto L76;
        LKUILightTextView r67 = r66.a;
        if (r67 == null) goto L76;
        r67.setVisibility(8);
    L76:
        c r68 = this.d;
        if (r68 == null) goto L81;
        View r69 = r68.c;
        if (r69 == null) goto L81;
        r69.setVisibility(8);
    L81:
        c r70 = this.d;
        if (r70 == null) goto L86;
        LKUILightTextView r71 = r70.b;
        if (r71 == null) goto L86;
        r71.setVisibility(0);
    L86:
        c r72 = this.d;
        if (r72 == null) goto L119;
        LKUILightTextView r73 = r72.b;
        if (r73 == null) goto L119;
        ViewGroup.LayoutParams r74 = r73.getLayoutParams();
        if (r74 == null) goto L94;
        ViewGroup.MarginLayoutParams r75 = (ViewGroup.MarginLayoutParams) r74;
        Context r76 = this.a;
        Intrinsics.checkNotNullParameter(r76, "context");
        r75.topMargin = UIUtils.dp2px(r76, 0.0f);
        r73.setLayoutParams(r75);
        goto L119
    L94:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L95:
        c r77 = this.d;
        if (r77 == null) goto L100;
        LKUILightTextView r78 = r77.a;
        if (r78 == null) goto L100;
        r78.setVisibility(0);
    L100:
        c r79 = this.d;
        if (r79 == null) goto L105;
        View r80 = r79.c;
        if (r80 == null) goto L105;
        r80.setVisibility(8);
    L105:
        c r81 = this.d;
        if (r81 == null) goto L110;
        LKUILightTextView r82 = r81.b;
        if (r82 == null) goto L110;
        r82.setVisibility(8);
    L110:
        c r83 = this.d;
        if (r83 == null) goto L119;
        LKUILightTextView r84 = r83.b;
        if (r84 == null) goto L119;
        ViewGroup.LayoutParams r85 = r84.getLayoutParams();
        if (r85 == null) goto L118;
        ViewGroup.MarginLayoutParams r86 = (ViewGroup.MarginLayoutParams) r85;
        Context r87 = this.a;
        Intrinsics.checkNotNullParameter(r87, "context");
        r86.topMargin = UIUtils.dp2px(r87, 16.0f);
        r84.setLayoutParams(r86);
        goto L119
    L118:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public static void g(LKUILightTextView r2, Layout r3) {
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        if (r0 == null) goto L11;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r3.getLineCount() != 1) goto L7;
        int r4 = -2;
    L8:
        r1.width = r4;
        r2.setLayoutParams(r1);
        return;
    L7:
        r4 = -1;
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final q c(MessageFullScreenLaunchData r9, Chat r10) {
        int r0 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.d.a;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("messener.im.refactor_richtext_biz") == true) goto L5;
        int r2 = j.b;
        Context r3 = this.a;
        Function0<Integer> r4 = this.f;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r10, "chat");
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r5 = j.a.b(r9);
        j.a.d(r5, r3);
        r5.h = false;
        Message r6 = r9.getMessage();
        if (r6 == null) goto L11;
        MessageEditInfo r7 = r6.getEditInfo();
        if (r7 == null) goto L11;
        boolean r8 = r7.isEdited();
    L12:
        r5.r = r8;
        r5.i = false;
        r5.u = 21;
        r5.m = true;
        Message r11 = r9.getMessage();
        if (r11 == null) goto L15;
        boolean r12 = r11.isPreMessage();
    L16:
        r5.c = r12;
        Message r13 = r9.getMessage();
        if (r13 == null) goto L19;
        boolean r14 = r13.isFromMe();
    L20:
        r5.d = r14;
        Message r15 = r9.getMessage();
        if (r15 == null) goto L24;
        List<String> r16 = r15.getReadAtChatterIds();
        if (r16 == null) goto L24;
    L25:
        Intrinsics.checkNotNullParameter(r16, "readAtChatterIds");
        r5.a = r16;
        Message r17 = r9.getMessage();
        if (r17 == null) goto L28;
        Message.Status r18 = r17.getStatus();
    L30:
        if (r18 != Message.Status.DELETED) goto L32;
        boolean r19 = true;
    L33:
        r5.e = r19;
        Message r20 = r9.getMessage();
        if (r20 == null) goto L36;
        boolean r21 = r20.isFlag();
    L37:
        r5.g = r21;
        String r22 = r10.getAnonymousId();
        if (r22 == null) goto L40;
        r5.l = r22;
    L40:
        r5.k = false;
        r5.J = true;
        r5.K = true;
        j.a.c(r5, r3, r4);
        return new r(r5, this.f);
    L36:
        r21 = false;
        goto L37
    L32:
        r19 = false;
        goto L33
    L28:
        r18 = null;
    L24:
        r16 = CollectionsKt.emptyList();
        goto L25
    L19:
        r14 = false;
        goto L20
    L15:
        r12 = true;
    L11:
        r8 = false;
        goto L12
    L5:
        return new s(false, this.c, r9, this.f);
    }

    public final q d(MessageFullScreenLaunchData r9, Chat r10) {
        int r0 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.d.a;
        if (FeatureGatingModule.getFeatureGatingService().isCurrentEnable("messener.im.refactor_richtext_biz") == true) goto L5;
        int r2 = j.b;
        Context r3 = this.a;
        Function0<Integer> r4 = this.f;
        Intrinsics.checkNotNullParameter(r9, "<this>");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r10, "chat");
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r5 = j.a.b(r9);
        j.a.d(r5, r3);
        boolean r6 = false;
        r5.h = false;
        Message r7 = r9.getMessage();
        if (r7 == null) goto L11;
        MessageEditInfo r8 = r7.getEditInfo();
        if (r8 == null) goto L11;
        boolean r11 = r8.isEdited();
    L12:
        r5.r = r11;
        r5.i = false;
        r5.u = 21;
        r5.m = true;
        Message r12 = r9.getMessage();
        if (r12 == null) goto L15;
        boolean r13 = r12.isPreMessage();
    L16:
        r5.c = r13;
        Message r14 = r9.getMessage();
        if (r14 == null) goto L19;
        boolean r15 = r14.isFromMe();
    L20:
        r5.d = r15;
        List<String> r16 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r16, "readAtChatterIds");
        r5.a = r16;
        Message r17 = r9.getMessage();
        if (r17 == null) goto L23;
        Message.Status r18 = r17.getStatus();
    L25:
        if (r18 != Message.Status.DELETED) goto L27;
        boolean r19 = true;
    L28:
        r5.e = r19;
        Message r20 = r9.getMessage();
        if (r20 == null) goto L31;
        r6 = r20.isFlag();
    L31:
        r5.g = r6;
        String r21 = r10.getAnonymousId();
        if (r21 == null) goto L34;
        r5.l = r21;
    L34:
        r5.k = true;
        r5.J = true;
        r5.K = true;
        j.a.c(r5, r3, r4);
        return new r(r5, this.f);
    L27:
        r19 = false;
        goto L28
    L23:
        r18 = null;
        goto L25
    L19:
        r15 = false;
        goto L20
    L15:
        r13 = true;
    L11:
        r11 = false;
        goto L12
    L5:
        return new s(true, this.c, r9, this.f);
    }

    public final Layout b(int r8, RichTextData r9, q r10) {
        if ((r10 instanceof r) == false) goto L5;
        j r0 = new j(this.a);
    L6:
        ((HashMap) this.g).put(Integer.valueOf(r8), r0);
        CharSequence r11 = r0.a(r9.getRichText(), r10);
        if (r11 != null) goto L10;
        Log.e("MsgFSRichTextSetup", "no charSequence parsed");
        return null;
    L10:
        String r12 = r9.getTitle();
        Intrinsics.checkNotNullParameter(r11, "charSequence");
        Intrinsics.checkNotNullParameter(r10, "config");
        SpannableStringBuilder r13 = new SpannableStringBuilder();
        if (r12 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
        SpannableStringBuilder r5 = new SpannableStringBuilder();
        StyleSpan r6 = new StyleSpan(1);
        int r3 = r5.length();
        r5.append(r12);
        r5.setSpan(r6, r3, r5.length(), 17);
        r5.append("\n");
        int r7 = zz7.b.g(r0.a, 10);
        e0.a r14 = new e0.a();
        r14.a = r7;
        e0 r15 = new e0(r14);
        Intrinsics.checkNotNull(r15);
        int r16 = r5.length();
        r5.append("\n");
        r5.setSpan(r15, r16, r5.length(), 17);
        new AbsoluteSizeSpan(p.a(r0.a));
        r13.append(new SpannedString(r5));
    L19:
        r13.append(r11);
        TextLayoutBuilder r17 = new TextLayoutBuilder();
        r17.h(r13);
        r17.j(p.a(r0.a));
        r17.c(Layout.Alignment.ALIGN_NORMAL);
        r17.l(1.0f);
        r17.k(UIHelper.dp2px(8.0f));
        r17.i(UIUtils.getColor(r0.a, 2131106622));
        Layout r18 = r17.a();
        if (r18 != null) goto L23;
        Log.e("MsgFSRichTextSetup", "no layout generated");
        return null;
    L23:
        return r18;
    L13:
        if (r12.length() == 0) goto L16;
        r4 = false;
        goto L17
    L5:
        r0 = new MessageFullScreenRichTextParser2(this.a);
        goto L6
    }

    public final void e(final LKUILightTextView r8, final RichText r9, final boolean r10) {
        if (r9 != null) goto L4;
        return;
    L4:
        final com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.c r1 = this.c;
        if (r1 == null) goto L43;
        int r0 = a.m;
        Function1<a, Unit> r6 = new MessageFullScreenRichTextSetup$setClickHandler$1$1(r1, r9, r10, r8, this);
        Intrinsics.checkNotNullParameter(r6, "click");
        a r11 = new a();
        r6.invoke(r11);
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r11, "clickHandler");
        mcc.l r12 = r11.a;
        if (r12 == null) goto L9;
        r8.setPhoneSpanClickListener(r12);
    L9:
        mcc.o r13 = r11.b;
        if (r13 == null) goto L12;
        r8.setUrlSpanClickListener(r13);
    L12:
        mcc.b r14 = r11.c;
        if (r14 == null) goto L15;
        r8.setAtSpanClickListener(r14);
    L15:
        mcc.i r15 = r11.d;
        if (r15 == null) goto L18;
        r8.setMentionSpanClickListener(r15);
    L18:
        mcc.g r16 = r11.e;
        if (r16 == null) goto L21;
        r8.setImageSpanClickListener(r16);
    L21:
        mcc.h r17 = r11.f;
        if (r17 == null) goto L24;
        r8.setMediaSpanClickListener(r17);
    L24:
        mcc.e r18 = r11.g;
        if (r18 == null) goto L27;
        r8.setCodeBlockV2SpanCLickListener(r18);
    L27:
        mcc.n r19 = r11.h;
        if (r19 == null) goto L30;
        r8.setTableSpanClickListener(r19);
    L30:
        mcc.f r110 = r11.i;
        if (r110 == null) goto L33;
        r8.setColumnsSpanClickListener(r110);
    L33:
        mcc.a r111 = r11.j;
        if (r111 == null) goto L36;
        r8.setAbbreviationClickListener(r111);
    L36:
        View.OnClickListener r112 = r11.k;
        if (r112 == null) goto L39;
        r8.setOnClickListener(r112);
    L39:
        View.OnLongClickListener r20 = r11.l;
        if (r20 == null) goto L44;
        r8.setOnLongClickListener(r20);
        return;
    L44:
        return;
    }
}
