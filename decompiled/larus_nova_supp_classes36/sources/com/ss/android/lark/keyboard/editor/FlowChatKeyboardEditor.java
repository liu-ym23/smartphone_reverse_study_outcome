package com.ss.android.lark.keyboard.editor;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.k0;
import com.ss.android.lark.dto.draft.QueryStatusInfo;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.keyboard.base.IKeyboardSwitcherPlugin;
import com.ss.android.lark.keyboard.base.KeyboardLogicPluginController;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.base.l;
import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.keyboard.base.r;
import com.ss.android.lark.keyboard.biz.voice.inject.VoiceInnerEndPlugin;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin;
import com.ss.android.lark.keyboard.editor.input.ChatEditorEnable;
import com.ss.android.lark.keyboard.editor.input.RichTextInputExpandPlugin;
import com.ss.android.lark.keyboard.editor.input.RichTextInputShrinkPlugin;
import com.ss.android.lark.keyboard.editor.input.SendPluginController;
import com.ss.android.lark.keyboard.editor.input.j;
import com.ss.android.lark.keyboard.editor.input.k;
import com.ss.android.lark.keyboard.editor.input.q;
import com.ss.android.lark.keyboard.edittext2.compat.ExtensionEditTextCompatKt;
import com.ss.android.lark.keyboard.inputstate.InputStateController;
import com.ss.android.lark.keyboard.keyboard2.BasicKeyboard;
import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowChatKeyboardEditor implements com.ss.android.lark.keyboard.base.f, l, cya.c, k, com.ss.android.lark.keyboard.keyboard2.e, com.ss.android.lark.keyboard.base.i {
    public static final Set<Function1<FlowChatKeyboardEditor, Unit>> z = null;
    public final Fragment a;
    public final Function0<yxa.a> b;
    public InputStateController c;
    public final RichTextInputShrinkPlugin d;
    public final RichTextInputExpandPlugin e;
    public final List<BaseRichTextInputPlugin> f;
    public BaseRichTextInputPlugin g;
    public final Set<l> h;
    public a i;
    public SendPluginController j;
    public com.ss.android.lark.keyboard.editor.inject.b k;
    public InputInnerController l;
    public KeyboardLogicPluginController m;
    public View n;
    public ViewGroup o;
    public Activity p;
    public com.ss.android.lark.keyboard.b q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final lob.b u;
    public final LinkedList<Function1<FlowChatKeyboardEditor, Unit>> v;
    public boolean w;
    public boolean x;
    public boolean y;

    public final class a implements j {
        public final /* synthetic */ FlowChatKeyboardEditor a;

        @Override // com.ss.android.lark.keyboard.editor.input.j
        public final InputStateController a() {
            InputStateController r0 = this.a.c;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inputStateController");
            return null;
        L6:
            return r0;
        }

        @Override // com.ss.android.lark.keyboard.editor.input.j
        public final InputInnerController b() {
            InputInnerController r0 = this.a.l;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("inputInnerController");
            return null;
        L6:
            return r0;
        }

        @Override // com.ss.android.lark.keyboard.editor.input.j
        public final void e() {
            k0.b(64, 16);
        }

        @Override // com.ss.android.lark.keyboard.editor.input.j
        public final void f() {
            InputStateController r0 = this.a.c;
            InputStateController r1 = null;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("inputStateController");
            r0 = null;
        L5:
            cya.h r2 = r0.d();
            Log.i("ChatInputEditor", "finishCurrentInputState: state is " + r2.a());
            if (r2.a() != 2) goto L8;
            r2.a.b(cya.b.h, Boolean.TRUE);
        L8:
            InputStateController r3 = this.a.c;
            if (r3 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("inputStateController");
        L12:
            r1.pop();
            return;
        L11:
            r1 = r3;
            goto L12
        }

        @Override // com.ss.android.lark.keyboard.editor.input.j
        public final com.ss.android.lark.keyboard.b n() {
            return this.a.J();
        }

        public a(FlowChatKeyboardEditor r2) {
            this.a = r2;
            k0.b(64, 16);
        }

        @Override // com.ss.android.lark.keyboard.editor.input.j
        public final void d(boolean r2) {
            FlowChatKeyboardEditor r0 = this.a;
            r0.w = r2;
            r0.J().H().m();
        }

        @Override // com.ss.android.lark.keyboard.editor.input.j
        public final void c(InputSupportType r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "inputType");
            if (r10 != this.a.g.getInputType()) goto L6;
            Log.i("ChatInputEditor", "InputContextWrapper#startInputPlugin, find same input plugin, method return");
            return;
        L6:
            String r1 = null;
            if (r10 != InputSupportType.Post) goto L12;
            BaseRichTextInputPlugin r0 = this.a.e;
            if (r0 == null) goto L12;
        L15:
            if (r0 != null) goto L17;
            return;
        L17:
            BaseRichTextInputPlugin r12 = this.a.g;
            r12.getClass();
            Editable r2 = r12.Z().getText();
            if (r2 == null) goto L20;
            r1 = r2.toString();
        L20:
            if (r1 != null) goto L22;
            r1 = "";
        L22:
            String r3 = r1;
            SpannableStringBuilder r4 = new SpannableStringBuilder(r12.L().getEditableText());
            if (Intrinsics.areEqual(r12.z, r12.Z()) == false) goto L25;
            String r5 = "title";
        L26:
            String r6 = r5;
            EditText r13 = r12.z;
            if (r13 == null) goto L29;
            int r7 = r13.getSelectionStart();
        L30:
            BaseRichTextInputPlugin.c r8 = new BaseRichTextInputPlugin.c(r3, r4, r6, r7, false);
            FlowChatKeyboardEditor r14 = this.a;
            BaseRichTextInputPlugin r9 = r14.g;
            com.ss.android.lark.keyboard.b r15 = r14.J();
            if ((r9 instanceof RichTextInputShrinkPlugin) == true) goto L33;
        L37:
            BaseRichTextInputPlugin r16 = this.a.g;
            r16.p0();
            r0.o0(r11);
            FlowChatKeyboardEditor r17 = this.a;
            BaseRichTextInputPlugin r18 = r17.g;
            r17.g = r0;
            r18.E(r17);
            r0.p(r17);
            g(r16, r0);
            r0.H = true;
            r0.B(r8);
            return;
        L33:
            if ((r0 instanceof RichTextInputExpandPlugin) == false) goto L37;
            if ((r15 instanceof BasicKeyboard) == false) goto L37;
            r15.v().e().i(FlowChatKeyboardEditor$InputContextWrapper$suppressKeyboardAnimationIfNeed$1.INSTANCE);
            goto L37
        L29:
            r7 = -1;
            goto L30
        L25:
            r5 = "content";
        L12:
            if (r10 != InputSupportType.Text) goto L14;
            r0 = this.a.d;
            goto L15
        L14:
            r0 = null;
            goto L15
        }

        public final void g(BaseRichTextInputPlugin r4, BaseRichTextInputPlugin r5) {
            Intrinsics.checkNotNullParameter(r5, "to");
            SendPluginController r0 = this.a.j;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("sendPluginController");
            r0 = null;
        L5:
            r0.getClass();
            Intrinsics.checkNotNullParameter(r5, "inputPlugin");
            if (Intrinsics.areEqual(r5, r0.g) == true) goto L13;
            Iterator<T> r1 = r0.i.iterator();
        L10:
            if (r1.hasNext() == false) goto L12;
            ((com.ss.android.lark.keyboard.base.h) r1.next()).a();
            goto L10
        L12:
            r0.a(r0.f, r5);
            r0.g = r5;
        L13:
            if (r4 == null) goto L16;
            InputSupportType r6 = r4.getInputType();
            if (r6 == null) goto L16;
        L17:
            com.ss.android.lark.keyboard.event.k.a.a(this.a.J().e(), com.ss.android.lark.keyboard.event.e.a(r6, r5.getInputType()));
            return;
        L16:
            r6 = InputSupportType.None;
            goto L17
        }
    }

    public final class b implements com.ss.android.lark.keyboard.inputstate.a {
        public final /* synthetic */ FlowChatKeyboardEditor a;

        @Override // com.ss.android.lark.keyboard.inputstate.a
        public final void e() {
            SendPluginController r0 = this.a.j;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("sendPluginController");
            r0 = null;
        L6:
            if (r0.f == 0) goto L12;
            com.ss.android.lark.keyboard.base.f r1 = r0.g;
            if (r1 == null) goto L13;
            r0.f = 0;
            Intrinsics.checkNotNull(r1);
            r0.a(0, r1);
            return;
        L13:
            return;
        }

        public final com.ss.android.lark.keyboard.b n() {
            return this.a.J();
        }

        @Override // com.ss.android.lark.keyboard.inputstate.a
        public final void v() {
            Iterator<T> r0 = this.a.f.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((BaseRichTextInputPlugin) r0.next()).K();
            goto L4
        }

        @Override // com.ss.android.lark.keyboard.inputstate.a
        public final n y() {
            BaseRichTextInputPlugin r0 = this.a.g;
            r0.w0();
            n r1 = new n();
            String r2 = r0.k0();
            Editable r3 = r0.L().getEditableText();
            Intrinsics.checkNotNull(r3);
            int r6 = 0;
            q r4 = (q) ArraysKt.firstOrNull(r3.getSpans(0, r3.length(), q.class));
            if (r4 != null) goto L5;
            RichText r5 = ExtensionEditTextCompatKt.b(r0.L());
        L11:
            cya.a r7 = new cya.a(r5, r2);
            r1.b(cya.a.c, r7);
            Editable r8 = r0.V().L().c().getEditableText();
            if (r8 == null) goto L22;
            com.ss.android.lark.keyboard.plugin.tool.at.b[] r9 = (com.ss.android.lark.keyboard.plugin.tool.at.b[]) r8.getSpans(0, r8.length(), com.ss.android.lark.keyboard.plugin.tool.at.b.class);
            if (r9.length != 0) goto L16;
            int r10 = 1;
        L17:
            int r11 = r10 ^ 1;
            if (r11 == 0) goto L20;
            int r12 = r8.getSpanStart(r9[0]);
            r6 = r8.getSpanEnd(r9[0]);
        L21:
            int r13 = r6;
            r6 = r11;
        L23:
            if (r6 == 0) goto L25;
            QueryStatusInfo r14 = new QueryStatusInfo(true, r12, r13, null);
        L26:
            r1.b(QueryStatusInfo.Companion, r14);
            return r1;
        L25:
            QueryStatusInfo.Companion.getClass();
            r14 = new QueryStatusInfo(false, 0, 0, null, 15, null);
            goto L26
        L20:
            r12 = 0;
            goto L21
        L16:
            r10 = 0;
            goto L17
        L22:
            r13 = 0;
            r12 = 0;
            goto L23
        L5:
            Pair r15 = TuplesKt.to(Integer.valueOf(r3.getSpanStart(r4)), Integer.valueOf(r3.getSpanEnd(r4)));
            int r16 = ((Number) r15.component1()).intValue();
            int r17 = ((Number) r15.component2()).intValue();
            if (r16 == 0) goto L8;
        L10:
            r5 = ExtensionEditTextCompatKt.b(r0.L());
            goto L11
        L8:
            if (r17 != r0.L().length()) goto L10;
            r5 = com.ss.android.lark.widget.richtext.c.a();
            goto L11
        }

        @Override // com.ss.android.lark.keyboard.inputstate.a
        public final void z() {
            Iterator<T> r0 = this.a.f.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((BaseRichTextInputPlugin) r0.next()).J();
            goto L4
        }

        @Override // com.ss.android.lark.keyboard.inputstate.a
        public final FlowChatKeyboardEditor r() {
            return this.a;
        }

        public b(FlowChatKeyboardEditor r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.keyboard.inputstate.a
        public final void l(n r4) {
            Intrinsics.checkNotNullParameter(r4, "keyboardParams");
            FlowChatKeyboardEditor r0 = this.a;
            r0.u.b = true;
            r0.g.n0(r4);
            this.a.u.b = false;
        }

        @Override // com.ss.android.lark.keyboard.inputstate.a
        public final void u(cya.i r3) {
            Intrinsics.checkNotNullParameter(r3, "replyData");
            Iterator<T> r0 = this.a.f.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((BaseRichTextInputPlugin) r0.next()).y(r3);
            goto L4
        }

        @Override // com.ss.android.lark.keyboard.inputstate.a
        public final void g(ReEditInfo r3, cya.i r4) {
            Intrinsics.checkNotNullParameter(r3, "reEditData");
            Iterator<T> r0 = this.a.f.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((BaseRichTextInputPlugin) r0.next()).v(r3, r4);
            goto L4
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor$onViewCreated$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<FlowChatKeyboardEditor, Unit> {
        public AnonymousClass3(Object r8) {
            super(1, r8, FlowChatKeyboardEditor.class, "popReEditModeWhenActivityChange", "popReEditModeWhenActivityChange(Lcom/ss/android/lark/keyboard/editor/FlowChatKeyboardEditor;)V", 0);
        }

        public final void invoke(FlowChatKeyboardEditor r2) {
            Intrinsics.checkNotNullParameter(r2, "p0");
            FlowChatKeyboardEditor.z((FlowChatKeyboardEditor) ((CallableReference) this).receiver, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((FlowChatKeyboardEditor) r1);
            return Unit.INSTANCE;
        }
    }

    @Override // mob.a
    public final void A() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.e
    public final boolean u(m r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return true;
    }

    static {
        z = new LinkedHashSet();
    }

    public final void B() {
        Editable r0 = this.g.L().getEditableText();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        return;
    L11:
        boolean r2 = this.x;
        if (r2 == this.y) goto L43;
        this.y = r2;
        if (r2 == false) goto L16;
        int r3 = UIHelper.getColor(2131106620);
    L17:
        Iterator<T> r4 = this.f.iterator();
    L19:
        if (r4.hasNext() == false) goto L24;
        BaseRichTextInputPlugin r5 = (BaseRichTextInputPlugin) r4.next();
        r5.setEnable(this.y);
        if (r5.G == false) goto L19;
        r5.L().setHintTextColor(r3);
        goto L19
    L24:
        KeyboardLogicPluginController r6 = this.m;
        if (r6 == null) goto L30;
        Iterator r7 = CollectionsKt.toList(((LinkedHashMap) r6.c).values()).iterator();
    L28:
        if (r7.hasNext() == false) goto L30;
        ((com.ss.android.lark.keyboard.base.g) r7.next()).n();
    L30:
        SendPluginController r8 = this.j;
        if (r8 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("sendPluginController");
        r8 = null;
    L33:
        Iterator r9 = ((HashMap) r8.d).entrySet().iterator();
    L35:
        if (r9.hasNext() == false) goto L38;
        ((uxa.a) ((Map.Entry) r9.next()).getValue()).b();
        goto L35
    L38:
        if (this.y == false) goto L40;
        ChatEditorEnable r10 = ChatEditorEnable.Enable;
    L41:
        com.ss.android.lark.keyboard.event.k.a.a(J().e(), r10);
        goto L43
    L40:
        r10 = ChatEditorEnable.Disable;
        goto L41
    L16:
        r3 = UIHelper.getColor(2131108718);
    L43:
        if (this.y == true) goto L53;
        com.ss.android.lark.c.c(J());
        return;
    L53:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void D() {
        this.g.D();
    }

    public final wnb.b H() {
        VoiceInnerEndPlugin.b r0 = VoiceInnerEndPlugin.t;
        Intrinsics.checkNotNullParameter(r0, TabAppInfo.IMAGE_JSON_KEY);
        a r1 = this.i;
        if (r1 == null) goto L7;
        InputInnerController r2 = r1.b();
        if (r2 == null) goto L7;
        return r2.d(r0);
    L7:
        return null;
    }

    public final com.ss.android.lark.keyboard.b J() {
        com.ss.android.lark.keyboard.b r0 = this.q;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("innerKeyboard");
        return null;
    L6:
        return r0;
    }

    public final String K() {
        return this.g.k0();
    }

    public final void L() {
        View r0 = this.n;
        InputStateController r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r0 = null;
    L5:
        r0.setVisibility(8);
        KeyboardLogicPluginController r2 = this.m;
        if (r2 == null) goto L11;
        Iterator r3 = CollectionsKt.toList(((LinkedHashMap) r2.c).values()).iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        ((com.ss.android.lark.keyboard.base.g) r3.next()).d();
    L11:
        this.g.p0();
        a r4 = this.i;
        if (r4 == null) goto L14;
        r4.g(null, this.g);
    L14:
        InputStateController r5 = this.c;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("inputStateController");
    L18:
        r1.getClass();
        Log.i("InputStateController", "onStop");
        cya.h r6 = r1.d();
        cya.g<?> r7 = r1.g(r6);
        if (r7 == null) goto L21;
        r7.c(r6);
    L21:
        cya.g<?> r8 = r1.g(r6);
        if (r8 == null) goto L26;
        r8.d(r6, 61441);
        return;
    L26:
        return;
    L17:
        r1 = r5;
        goto L18
    }

    public final cya.d a() {
        InputStateController r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("inputStateController");
        return null;
    L6:
        return r0;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final EditText c() {
        return this.g.L();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
        vxa.a r0 = (vxa.a) this.r.getValue();
        if (r0 == null) goto L5;
        r0.a(this.a);
    L5:
        Iterator<T> r1 = this.f.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((BaseRichTextInputPlugin) r1.next()).getClass();
        goto L7
    L9:
        J().e().of(this).c(com.ss.android.lark.keyboard.event.q.a.class, new FlowChatKeyboardEditor$onAttached$2(this));
        Lifecycle r2 = J().l().b;
        if (r2 == null) goto L12;
        r2.addObserver(new FlowChatKeyboardEditor$onAttached$3(this));
    L12:
        View r3 = this.n;
        Activity r4 = null;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r3 = null;
    L15:
        int r5 = 0;
        r3.setVisibility(0);
        KeyboardLogicPluginController r6 = this.m;
        if (r6 == null) goto L21;
        Iterator r7 = CollectionsKt.toList(((LinkedHashMap) r6.c).values()).iterator();
    L19:
        if (r7.hasNext() == false) goto L21;
        ((com.ss.android.lark.keyboard.base.g) r7.next()).f();
    L21:
        BaseRichTextInputPlugin r8 = this.g;
        int r9 = BaseRichTextInputPlugin.J;
        r8.o0(false);
        this.g.B(new BaseRichTextInputPlugin.c(r5));
        a r10 = this.i;
        if (r10 == null) goto L24;
        r10.g(null, this.g);
    L24:
        com.ss.android.lark.insets.f r11 = WindowInsetsUtils.b(this.a);
        Activity r12 = this.p;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
    L28:
        r11.i(UDColorUtils.getColor(r4, 2131100549));
        return;
    L27:
        r4 = r12;
        goto L28
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final RichText getContent() {
        return this.g.getContent();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final InputSupportType getInputType() {
        return this.g.getInputType();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((BaseRichTextInputPlugin) r0.next()).getClass();
        goto L4
    L6:
        L();
    }

    @Override // com.ss.android.lark.keyboard.base.i
    public final void v() {
        KeyboardLogicPluginController r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("keyboardLogicPluginController");
        r0 = null;
    L5:
        Iterator r1 = CollectionsKt.toList(((LinkedHashMap) r0.c).values()).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((com.ss.android.lark.keyboard.base.g) r1.next()).a();
        goto L7
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void E(l r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.h.remove(r2);
        this.g.E(r2);
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void I(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        this.d.I(r2);
        RichTextInputExpandPlugin r3 = this.e;
        if (r3 == null) goto L6;
        r3.I(UIHelper.getString(2131890160));
        return;
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final com.ss.android.lark.keyboard.base.q N(boolean r2) {
        return this.g.N(r2);
    }

    public final void P(boolean r3) {
        com.ss.android.lark.keyboard.biz.mention.inject.h.a r0 = com.ss.android.lark.keyboard.biz.mention.inject.h.d;
        Intrinsics.checkNotNullParameter(r0, TabAppInfo.IMAGE_JSON_KEY);
        a r1 = this.i;
        if (r1 == null) goto L7;
        InputInnerController r2 = r1.b();
        if (r2 == null) goto L7;
        wnb.b r4 = r2.d(r0);
    L8:
        if (r4 != null) goto L10;
        return;
    L10:
        if (r3 == false) goto L13;
        r4.h().a(r4.getKey());
        return;
    L13:
        r4.h().b(r4.getKey());
        return;
    L7:
        r4 = null;
        goto L8
    }

    @Override // mob.a
    public final View b(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        dwa.d r0 = J().l().getContext();
        if ((r0 instanceof dwa.d) == true) goto L5;
        View r1 = LayoutInflater.from(r0).inflate(2131563292, r6, false);
        ViewGroup r2 = (ViewGroup) r1.findViewById(2131375355);
        List<BaseRichTextInputPlugin> r3 = this.f;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r4.add(((BaseRichTextInputPlugin) r5.next()).b(r6));
        goto L8
    L10:
        Iterator r7 = r4.iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        r2.addView((View) r7.next());
        goto L12
    L14:
        Intrinsics.checkNotNull(r1);
        return r1;
    L5:
        return r0.Ey().b(r0, 2131563293, r6);
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final boolean g(com.ss.android.lark.keyboard.base.q r3) {
        Iterator<l> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().g(r3) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.ss.android.lark.keyboard.editor.input.k
    public final void l(IKeyboardSwitcherPlugin r2) {
        Intrinsics.checkNotNullParameter(r2, "switcher");
        this.d.l(r2);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.e
    public final boolean n(m r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return this.w;
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void o(boolean r2) {
        this.g.o(r2);
    }

    @Override // com.ss.android.lark.keyboard.base.c
    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        KeyboardLogicPluginController r1 = this.m;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        Iterator r0 = CollectionsKt.toList(((LinkedHashMap) r1.c).values()).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((com.ss.android.lark.keyboard.base.g) r0.next()).b();
    L8:
        Iterator<T> r2 = this.f.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        ((BaseRichTextInputPlugin) r2.next()).onConfigurationChanged(r3);
        goto L10
    }

    @Override // mob.a
    public final View onViewCreated(View r18) {
        Intrinsics.checkNotNullParameter(r18, "rootView");
        Activity r2 = J().l().getContext();
        a r3 = this.i;
        if (r3 == null) goto L34;
        ViewGroup r4 = (ViewGroup) r18.findViewById(2131375343);
        ViewGroup r7 = (ViewGroup) r18.findViewById(2131375418);
        ViewGroup r8 = (ViewGroup) r18.findViewById(2131375419);
        ViewGroup r9 = (ViewGroup) r18.findViewById(2131375420);
        ViewGroup r10 = (ViewGroup) r18.findViewById(2131375382);
        ViewGroup r11 = (ViewGroup) r18.findViewById(2131375383);
        ViewGroup r12 = (ViewGroup) r18.findViewById(2131375381);
        ViewGroup r13 = (ViewGroup) r18.findViewById(2131375380);
        ViewGroup r14 = (ViewGroup) r18.findViewById(2131375379);
        View r15 = r18.findViewById(2131375384);
        Intrinsics.checkNotNull(r4);
        this.k = new com.ss.android.lark.keyboard.editor.inject.b(r4, r3.n());
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNull(r9);
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNull(r13);
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r15);
        this.l = new InputInnerController(r7, r8, r9, r10, r11, r12, r13, r14, r15, r3.n());
        ViewGroup r5 = this.o;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("sendButtonWrapper");
        r5 = null;
    L7:
        this.j = new SendPluginController(r5, J());
        Iterator<T> r6 = this.f.iterator();
    L9:
        if (r6.hasNext() == false) goto L14;
        BaseRichTextInputPlugin r16 = (BaseRichTextInputPlugin) r6.next();
        SendPluginController r17 = this.j;
        if (r17 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("sendPluginController");
        r17 = null;
    L13:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r16, "plugin");
        ((HashMap) r17.c).put(r16, r16.t(r17.a));
        goto L9
    L14:
        Iterator<T> r19 = this.f.iterator();
    L16:
        if (r19.hasNext() == false) goto L18;
        ((BaseRichTextInputPlugin) r19.next()).s(this.u);
        goto L16
    L18:
        this.d.onViewCreated(r18.findViewById(2131375409));
        RichTextInputExpandPlugin r20 = this.e;
        if (r20 == null) goto L21;
        r20.onViewCreated(r18.findViewById(2131376761));
    L21:
        AnonymousClass3 r21 = new AnonymousClass3(this);
        Intrinsics.checkNotNullParameter(r21, "action");
        Set<Function1<FlowChatKeyboardEditor, Unit>> r22 = z;
        r22.add(r21);
        Intrinsics.checkNotNullParameter(this, "keyBoard");
        Iterator<T> r23 = r22.iterator();
    L23:
        if (r23.hasNext() == false) goto L25;
        ((Function1) r23.next()).invoke(this);
        goto L23
    L25:
        this.p = r2;
        this.n = r18;
    L26:
        Function1<FlowChatKeyboardEditor, Unit> r24 = this.v.pollLast();
        if (r24 == null) goto L29;
        r24.invoke(this);
        Unit r25 = Unit.INSTANCE;
    L30:
        if (r25 != null) goto L26;
        return r18;
    L29:
        r25 = null;
        goto L30
    L34:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void p(l r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.h.add(r2);
        this.g.p(r2);
    }

    @Override // com.ss.android.lark.keyboard.base.i
    public final void r(com.ss.android.lark.keyboard.base.g<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "plugin");
        KeyboardLogicPluginController r1 = this.m;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("keyboardLogicPluginController");
        r1 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "plugin");
        r4.e();
        r4.c();
        Map<com.ss.android.lark.keyboard.base.g.a<?>, com.ss.android.lark.keyboard.base.g<?>> r0 = r1.c;
        r4.getKey();
        r0.put(null, r4);
        r4.onAttach();
    }

    @Override // mob.a
    public final void s(lob.a r3) {
        Intrinsics.checkNotNullParameter(r3, "watcher");
        lob.b r1 = this.u;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "watcher");
        ((ArrayList) r1.a).add(r3);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.b
    public final void setEnable(boolean r1) {
        this.x = r1;
        B();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        this.q = r5;
        this.m = new KeyboardLogicPluginController(r5);
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        BaseRichTextInputPlugin r1 = (BaseRichTextInputPlugin) r0.next();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r1.F = r5;
        r1.j0();
        goto L4
    L6:
        a r6 = new a(this);
        this.i = r6;
        Iterator<T> r2 = this.f.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        BaseRichTextInputPlugin r3 = (BaseRichTextInputPlugin) r2.next();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.o = r6;
        goto L8
    }

    @Override // mob.a
    public final View t(ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        FrameLayout r0 = new FrameLayout(r3.getContext());
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-2, -2);
        r4.gravity = 17;
        r0.setLayoutParams(r4);
        this.o = r0;
        return r0;
    }

    @Override // com.ss.android.lark.keyboard.base.l
    public final void y(boolean r3) {
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((l) r0.next()).y(r3);
        goto L4
    }

    public static final void z(FlowChatKeyboardEditor r1, FlowChatKeyboardEditor r2) {
        r1.getClass();
        if (Intrinsics.areEqual(r2, r1) == false) goto L6;
        return;
    L6:
        if (r1.c != null) goto L8;
        return;
    L8:
        if (((InputStateController) r1.a()).a(4) == false) goto L15;
        InputStateController r3 = r1.c;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("inputStateController");
        r3 = null;
    L12:
        r3.pop();
        return;
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void O(CharSequence r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        this.d.O(r2, r3);
        RichTextInputExpandPlugin r4 = this.e;
        if (r4 == null) goto L6;
        r4.O(UIHelper.getString(2131890160), r3);
        return;
    }

    @Override // com.ss.android.lark.keyboard.base.b
    public final void e(int r3, Intent r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        KeyboardLogicPluginController r0 = this.m;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r4, "data");
        Iterator r1 = CollectionsKt.toList(((LinkedHashMap) r0.c).values()).iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((com.ss.android.lark.keyboard.base.g) r1.next()).onActivityResult();
    L8:
        this.g.getClass();
        Intrinsics.checkNotNullParameter(r4, "data");
    }

    @Override // com.ss.android.lark.keyboard.base.f
    public final void F(boolean r7, Long r8, boolean r9, String r10, r r11) {
        this.g.F(r7, r8, r9, r10, r11);
    }

    public FlowChatKeyboardEditor(f r16, e r17, String r18, boolean r19, boolean r20, Fragment r21) {
        Intrinsics.checkNotNullParameter(r16, "sendCallBack");
        Intrinsics.checkNotNullParameter(r18, "curChatId");
        Intrinsics.checkNotNullParameter(r21, "applyInsetsFragment");
        this.a = r21;
        Function0<yxa.a> r13 = new FlowChatKeyboardEditor$keyboardConfigProvider$1(this);
        this.b = r13;
        RichTextInputShrinkPlugin r14 = new RichTextInputShrinkPlugin(r16, r17, false, true, r18, r19, r21, r13);
        this.d = r14;
        RichTextInputExpandPlugin r7 = new RichTextInputExpandPlugin(r16, r17, r18, r21, r13);
        this.e = r7;
        this.f = ArraysKt.filterNotNull(new BaseRichTextInputPlugin[]{r14, r7});
        this.g = r14;
        this.h = new LinkedHashSet();
        this.r = LazyKt.lazy(new FlowChatKeyboardEditor$adapterExtension$2(this));
        this.s = LazyKt.lazy(new FlowChatKeyboardEditor$keyboardConfigExtension$2(this));
        this.t = LazyKt.lazy(new FlowChatKeyboardEditor$plusExtension$2(this));
        lob.b r1 = new lob.b();
        h r3 = new h(this);
        Intrinsics.checkNotNullParameter(r3, "watcher");
        ((ArrayList) r1.a).add(r3);
        this.u = r1;
        this.v = new LinkedList();
        this.w = true;
        this.x = true;
        this.y = true;
    }
}
