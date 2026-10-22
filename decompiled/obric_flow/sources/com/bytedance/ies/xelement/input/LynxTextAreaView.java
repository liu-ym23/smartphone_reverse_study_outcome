package com.bytedance.ies.xelement.input;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.RemoteException;
import android.text.Editable;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.bpea.entry.common.DataType;
import com.lynx.base.log.LynxLog;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.behavior.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0017¢\u0006\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/xelement/input/LynxTextAreaView;", "Lcom/bytedance/ies/xelement/input/LynxBaseInputView;", "", "value", "", "setMinHeight", "(Ljava/lang/String;)V", "setMaxHeight", "", "maxLines", "setMaxLines", "(I)V", "setRichType", "resetSelectionMenu", "()V", "Lcom/lynx/react/bridge/ReadableMap;", LynxResourceModule.PARAMS_KEY, "Lcom/lynx/react/bridge/Callback;", "callback", "addMention", "(Lcom/lynx/react/bridge/ReadableMap;Lcom/lynx/react/bridge/Callback;)V", "getTextInfo", "(Lcom/lynx/react/bridge/Callback;)V", "sendDelEvent", "x-element-input_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LynxTextAreaView extends LynxBaseInputView {
    public static final /* synthetic */ int Y = 0;
    public LynxEditText M;
    public boolean N;
    public int O;
    public ClipboardManager P;
    public boolean Q;
    public final ArrayList R;
    public final int S;
    public final int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public final Function1 X;

    public LynxTextAreaView(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        this.R = new ArrayList();
        this.S = 1;
        this.T = 16;
        this.X = LynxTextAreaView$adapterProvider$1.f6430a;
    }

    public static final void s(LynxTextAreaView r13) {
        if (r13.N == true) goto L5;
        return;
    L5:
        Pattern r5 = we.c.f22858a;
        TextView r14 = (TextView) r13.mView;
        Intrinsics.checkNotNullParameter(r14, "textView");
        if (we.c.f22859b == true) goto L75;
        we.c.f22859b = true;
        CharSequence r10 = r14.getText();
        Context r11 = r14.getContext();
        String r12 = r10.toString();
        Pattern r15 = we.c.f22858a;
        if (r11 != null) goto L11;
    L21:
        ArrayList r16 = new ArrayList();
    L22:
        int r17 = r16.size();
        if (TextUtils.isEmpty(r10) == true) goto L61;
        if (r17 <= 0) goto L61;
        SpannableString r18 = new SpannableString(r10);
        we.b[] r19 = (we.b[]) r18.getSpans(0, r10.length(), we.b.class);
        if (r19 != null) goto L29;
    L44:
        boolean r20 = r14 instanceof EditText;
        if (r20 == false) goto L47;
        r14.getSelectionStart();
    L47:
        we.a r21 = com.bytedance.android.anniex.base.service.e.k();
        Matcher r22 = r15.matcher(r10);
    L49:
        if (r22.find() == false) goto L55;
        r22.start();
        r22.end();
        r22.group();
        r14.getContext();
        com.lynx.tasm.utils.c r23 = (com.lynx.tasm.utils.c) r21.f22857a;
        if (r23 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r23 = null;
    L54:
        r23.getClass();
        goto L49
    L55:
        if (r20 == false) goto L59;
        Editable r110 = r14.getEditableText();
        if (r110 == null) goto L60;
        r110.replace(0, r10.length(), r18);
    L60:
        we.c.f22859b = false;
        return;
    L59:
        r14.setText(r18);
        goto L60
    L29:
        if (r19.length <= 0) goto L44;
        if (r19.length == r17) goto L33;
        boolean r24 = true;
    L34:
        int r111 = r19.length;
        int r112 = 0;
    L35:
        if (r112 >= r111) goto L42;
        we.b r113 = r19[r112];
        r18.removeSpan(null);
        if (r112 >= r17) goto L41;
        if (r24 == true) goto L41;
        throw null;
    L41:
        r112 = r112 + 1;
        goto L35
    L42:
        if (r24 == true) goto L44;
        we.c.f22859b = false;
        return;
    L33:
        r24 = false;
    L61:
        we.c.f22859b = false;
        return;
    L11:
        if (TextUtils.isEmpty(r12) == true) goto L21;
        r16 = new ArrayList();
        Matcher r25 = r15.matcher(r12);
    L15:
        if (r25.find() == false) goto L22;
        r25.group();
        com.lynx.tasm.utils.c r26 = (com.lynx.tasm.utils.c) com.bytedance.android.anniex.base.service.e.k().f22857a;
        if (r26 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r26 = null;
    L20:
        r26.getClass();
        goto L15
    }

    public static final void t(LynxTextAreaView r5, ClipData r10) {
        if (ko.r.g().e(ko.h.class) != null) goto L12;
        ClipboardManager r11 = r5.P;     // Catch: RemoteException -> L8
        if (r11 == null) goto L15;
        r11.setPrimaryClip(r10);     // Catch: RemoteException -> L8
        return;
    L15:
        return;
    L8:
        e = move-exception;
        LynxLog.b(4, "LynxTextAreaView", "When we tried to copy copyData, we encountered a RemoteException. " + e.getMessage());
        return;
    L12:
        throw new ClassCastException();
    }

    @f0
    public final void addMention(ReadableMap r10, Callback r11) {
        if (r10 == null) goto L46;
        int r5 = this.O;
        int r12 = this.S;
        if ((r5 & r12) == r12) goto L7;
    L41:
        if (r11 == null) goto L45;
        r11.invoke(new Object[]{4});
        return;
    L45:
        return;
    L7:
        if (r10.hasKey("name") == false) goto L41;
        if (r10.hasKey("symbol") == false) goto L12;
        se.b r13 = new se.b(r10.getString("name"), r10.getString("symbol"));
    L13:
        SpannableString r14 = new SpannableString(r13.f21890b + r13.f21889a);
        int r15 = r14.length();
        LynxEditText r16 = this.M;
        LynxEditText r17 = null;
        if (r16 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r16 = null;
    L16:
        r14.setSpan(Integer.valueOf(r16.getHeight()), 0, r15, 33);
        if (r10.hasKey("font-style") == false) goto L19;
        int r18 = r10.getInt("font-style");
    L20:
        r14.setSpan(new StyleSpan(r18), 0, r15, 33);
        if (r10.hasKey("font-color") == false) goto L23;
        int r19 = Color.parseColor(r10.getString("font-color"));
    L24:
        r14.setSpan(new zm.j(r19), 0, r15, 33);
        SpannableStringBuilder r20 = new SpannableStringBuilder();
        Object[] r21 = {r13};
        Intrinsics.checkNotNullParameter(r14, "s");
        Intrinsics.checkNotNullParameter(r21, "spans");
        SpannableString r22 = SpannableString.valueOf(r14);
        r22.setSpan(r21[0], 0, r22.length(), 33);
        r20.append(r22);
        if (r10.hasKey("extraSpace") == false) goto L27;
        r20.append(r10.getString("extraSpace"));
    L28:
        LynxEditText r110 = this.M;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r110 = null;
    L31:
        Editable r111 = r110.getText();
        if (r111 == null) goto L38;
        LynxEditText r23 = this.M;
        if (r23 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L37:
        r111.insert(r17.getSelectionEnd(), r20);
        goto L38
    L36:
        r17 = r23;
    L38:
        if (r11 == null) goto L44;
        r11.invoke(new Object[]{0});
        return;
    L44:
        return;
    L27:
        r20.append(" ");
        goto L28
    L23:
        r19 = SupportMenu.CATEGORY_MASK;
        goto L24
    L19:
        r18 = 1;
        goto L20
    L12:
        r13 = new se.b(r10.getString("name"), "@");
        goto L13
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    public final CharSequence b(CharSequence r18, int r19, int r20, Spanned r21, int r22, int r23) {
        r21 = r21;
        Intrinsics.checkNotNullParameter(r18, "source");
        Intrinsics.checkNotNullParameter(r21, "dest");
        boolean r10 = true;
        if (this.B == Integer.MAX_VALUE) goto L51;
        if (n() == false) goto L51;
        int r11 = 0;
        if ((r18 instanceof Spannable) == false) goto L16;
        LynxEditText r5 = this.M;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L12:
        if (r5.a() == null) goto L16;
        if (l.a((Spannable) r18) != true) goto L16;
    L17:
        CharSequence r12 = new SpannableStringBuilder(r18).subSequence(r19, r20);
        int r13 = r19;
        int r14 = r20;
    L19:
        if (r13 >= r14) goto L34;
        int r15 = (r13 + r14) / 2;
        SpannableStringBuilder r16 = new SpannableStringBuilder(r21);
        int r17 = r15 + 1;
        r16.replace(r22, r23, r12.subSequence(r11, r17));
        LynxEditText r110 = this.M;
        if (r110 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r110 = null;
    L23:
        LynxEditText r24 = this.M;
        if (r24 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r24 = null;
    L26:
        int r25 = r24.getWidth();
        CharSequence r111 = r12;
        LynxEditText r26 = this.M;
        if (r26 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r26 = null;
    L29:
        r26.getHeight();
        if (com.bytedance.android.anniex.base.service.e.a(r16, r110, r25).getLineCount() > this.B) goto L33;
        r13 = r17;
    L32:
        r12 = r111;
        r11 = 0;
        goto L19
    L33:
        r14 = r15;
        goto L32
    L34:
        Iterator r27 = Regex.findAll$default(new Regex("(?:[🌀-🗿]|[🤀-🧿]|[😀-🙏]|[🚀-\u1f6ff]|[☀-⛿]️?|[✀-➿]️?|Ⓜ️?|[🇦-🇿]{1,2}|[🅰🅱🅾🅿🆎🆑-🆚]️?|[#*0-9]️?⃣|[↔-↙↩-↪]️?|[⬅-⬇⬛⬜⭐⭕]️?|[⤴⤵]️?|[〰〽]️?|[㊗㊙]️?|[🈁🈂🈚🈯🈲-🈺🉐🉑]️?|[‼⁉]️?|[▪▫▶◀◻-◾]️?|[©®]️?|[™ℹ]️?|🀄️?|🃏️?|[⌚⌛⌨⏏⏩-⏳⏸-⏺]️?)"), r18, 0, 2, null).iterator();
    L36:
        if (r27.hasNext() == false) goto L42;
        MatchResult r28 = (MatchResult) r27.next();
        int r29 = r14 + r19;
        if (r28.getRange().getFirst() > r29) goto L36;
        if ((r28.getValue().length() + r28.getRange().getFirst()) <= r29) goto L36;
        r14 = r28.getRange().getFirst();
        goto L36
    L42:
        if (r14 < r20) goto L44;
    L46:
        CharSequence r30 = r18.subSequence(0, r14);
        if (r10 == false) goto L49;
        BaseInputConnection.setComposingSpans((Spannable) r30);
    L49:
        return r30;
    L44:
        if (this.f6415r == false) goto L46;
        getLynxContext().g.b(new com.lynx.animax.i(getSign(), SVGRenderEngine.LINE));
    L16:
        r10 = false;
    L51:
        if (this.B != Integer.MAX_VALUE) goto L53;
    L55:
        return r18;
    L53:
        if (n() == true) goto L55;
        this.V = true;
        goto L55
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    public final void c(LynxEditText r5) {
        Intrinsics.checkNotNullParameter(r5, "editText");
        r5.setHorizontallyScrolling(false);
        r5.setSingleLine(false);
        r5.setGravity(48);
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView, com.lynx.tasm.behavior.ui.LynxUI
    public final /* bridge */ /* synthetic */ View createView(Context r5) {
        return k(r5);
    }

    @f0
    public final void getTextInfo(Callback r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        JavaOnlyMap r10 = new JavaOnlyMap();
        LynxEditText r11 = this.M;
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r11 = null;
    L7:
        r10.put(MessageIndication.CONTENT_TYPE_TEXT, String.valueOf(r11.getText()));
        int r12 = this.O;
        int r13 = this.S;
        if ((r12 & r13) != r13) goto L10;
        r10.put("mention", r(se.b.class));
    L10:
        int r14 = this.O;
        int r15 = this.T;
        if ((r14 & r15) != r15) goto L13;
        r10.put("emoji", r(we.b.class));
    L13:
        r5.invoke(new Object[]{0, r10});
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    public final void i(LynxEditText r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "editText");
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    public final LynxEditText k(Context r5) {
        final LynxEditText r10 = super.k(r5);
        this.M = r10;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L5:
        r10.addTextChangedListener(new f(this, 1));
        r10.setOnEditorActionListener(new q(this, r10));
        LynxEditText r11 = this.M;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r11 = null;
    L8:
        c(r11);
        LynxEditText r12 = this.M;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        return null;
    L12:
        return r12;
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        super.layout();
        if (n() == false) goto L10;
        if (this.U == false) goto L10;
        o r5 = this.H;
        if (r5.d() == false) goto L10;
        r5.e();
        this.U = false;
    L10:
        if (n() == true) goto L12;
        return;
    L12:
        if (this.V == false) goto L23;
        this.V = false;
        this.f6420x = true;
        LynxEditText r10 = this.M;
        LynxEditText r11 = null;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r10 = null;
    L16:
        LynxEditText r12 = this.M;
        if (r12 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L20:
        r10.setText(r11.getText());
        return;
    L19:
        r11 = r12;
        goto L20
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.W == false) goto L22;
        v();
        LynxEditText r5 = this.M;
        AutoHeightInputShadowNode r10 = null;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L8:
        if (r5.getHint() == null) goto L20;
        LynxContext r11 = getLynxContext();
        int r12 = getSign();
        w0 r13 = (w0) r11.f10151t.get();
        if (r13 == null) goto L12;
        ShadowNode r14 = (ShadowNode) ((SparseArray) r13.g.f10812a).get(r12);
    L13:
        if (r14 != null) goto L15;
    L17:
        if (r10 == null) goto L20;
        r10.L();
        this.U = r10.M();
        goto L20
    L15:
        if ((r14 instanceof AutoHeightInputShadowNode) == false) goto L17;
        r10 = (AutoHeightInputShadowNode) r14;
        goto L17
    L12:
        r14 = null;
    L20:
        this.W = false;
        return;
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    public final void p() {
        super.p();
        v();
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    public final void q() {
        super.q();
        if (this.f6404c == null) goto L21;
        LynxEditText r5 = this.M;
        AutoHeightInputShadowNode r10 = null;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L8:
        if (r5.getHint() == null) goto L22;
        LynxContext r11 = getLynxContext();
        int r12 = getSign();
        w0 r13 = (w0) r11.f10151t.get();
        if (r13 == null) goto L12;
        ShadowNode r14 = (ShadowNode) ((SparseArray) r13.g.f10812a).get(r12);
    L13:
        if (r14 != null) goto L15;
    L17:
        if (r10 == null) goto L23;
        r10.L();
        this.U = r10.M();
        return;
    L23:
        return;
    L15:
        if ((r14 instanceof AutoHeightInputShadowNode) == false) goto L17;
        r10 = (AutoHeightInputShadowNode) r14;
        goto L17
    L12:
        r14 = null;
        goto L13
    L22:
        return;
    }

    public final JavaOnlyArray r(Class r10) {
        LynxEditText r11 = this.M;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r11 = null;
    L5:
        Editable r12 = r11.getText();
        Intrinsics.checkNotNull(r12);
        int r5 = 0;
        Object[] r13 = r12.getSpans(0, r12.length(), r10);
        JavaOnlyArray r14 = new JavaOnlyArray();
        int r15 = r13.length;
    L6:
        if (r5 >= r15) goto L8;
        Object r16 = r13[r5];
        JavaOnlyMap r17 = new JavaOnlyMap();
        r17.put("start", Integer.valueOf(r12.getSpanStart(r16)));
        r17.put("end", Integer.valueOf(r12.getSpanEnd(r16)));
        r14.add(r17);
        r5 = r5 + 1;
        goto L6
    L8:
        return r14;
    }

    @f0
    public final void resetSelectionMenu() {
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView
    @f0
    public void sendDelEvent(ReadableMap r10, Callback r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.O != 0) goto L8;
        super.sendDelEvent(r10, r11);
        return;
    L8:
        Iterator r5 = this.R.iterator();
    L9:
        boolean r12 = false;
    L10:
        LynxEditText r13 = null;
        if (r5.hasNext() == false) goto L21;
        t r14 = (t) r5.next();
        if (r12 == true) goto L20;
        LynxEditText r15 = this.M;
        if (r15 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L18:
        Editable r16 = r13.getText();
        Intrinsics.checkNotNull(r16);
        if (r14.a(r16) == false) goto L9;
    L17:
        r13 = r15;
    L20:
        r12 = true;
        goto L10
    L21:
        if (r12 == true) goto L48;
        int r17 = r10.getInt("action");     // Catch: Throwable -> L27
        if (r17 == 0) goto L29;
        if (r17 != 1) goto L36;
        ((EditText) this.mView).dispatchKeyEvent(new KeyEvent(0, 67));     // Catch: Throwable -> L27
    L36:
        if (r11 == null) goto L49;
        r11.invoke(new Object[]{0});     // Catch: Throwable -> L27
        return;
    L49:
        return;
    L29:
        int r18 = r10.getInt("length");     // Catch: Throwable -> L27
        LynxEditText r19 = this.M;     // Catch: Throwable -> L27
        if (r19 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");     // Catch: Throwable -> L27
    L33:
        l r20 = r13.a();     // Catch: Throwable -> L27
        if (r20 == null) goto L36;
        r20.deleteSurroundingText(r18, 0);     // Catch: Throwable -> L27
        goto L36
    L32:
        r13 = r19;
    L27:
        th = move-exception;
        if (r11 == null) goto L50;
        r11.invoke(new Object[]{1, th});
        return;
    L50:
        return;
    }

    @Override // com.bytedance.ies.xelement.input.LynxBaseInputView, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setEvents(Map r5) {
        super.setEvents(r5);
        if (r5 == null) goto L6;
        this.f6415r = r5.containsKey(SVGRenderEngine.LINE);
        this.Q = r5.containsKey("mention");
        return;
    }

    @c0(name = "max-height")
    public final void setMaxHeight(String r10) {
        if (r10 != null) goto L4;
        T r5 = this.mView;
        Intrinsics.checkNotNull(r5);
        ((EditText) r5).setMaxLines(Integer.MAX_VALUE);
    L4:
        float r11 = com.lynx.tasm.utils.k.c(r10, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, getLynxContext().f10152u);
        T r12 = this.mView;
        Intrinsics.checkNotNull(r12);
        ((EditText) r12).setMaxHeight((int) (((double) r11) + 0.5d));
        this.W = true;
    }

    @c0(defaultInt = Integer.MAX_VALUE, name = "maxlines")
    public final void setMaxLines(int r5) {
        this.B = r5;
    }

    @c0(name = "min-height")
    public final void setMinHeight(String r10) {
        if (r10 != null) goto L5;
        T r11 = this.mView;
        Intrinsics.checkNotNull(r11);
        ((EditText) r11).setMinLines(0);
        return;
    L5:
        float r12 = com.lynx.tasm.utils.k.c(r10, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, getLynxContext().f10152u);
        T r5 = this.mView;
        Intrinsics.checkNotNull(r5);
        ((EditText) r5).setMinHeight((int) (((double) r12) + 0.5d));
        this.W = true;
    }

    @c0(name = "richtype")
    public final void setRichType(String r10) {
        if (r10 != null) goto L5;
        r10 = "none";
    L5:
        boolean r5 = StringsKt.e(r10, "none", false);
        ArrayList r11 = this.R;
        LynxEditText r12 = null;
        if (r5 == false) goto L19;
        this.O = 0;
        r11.clear();
        LynxEditText r13 = this.M;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r13 = null;
    L10:
        l r14 = r13.f6425b;
        if (r14 == null) goto L13;
        r14.f6447a = null;
    L13:
        LynxEditText r15 = this.M;
        if (r15 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r15 = null;
    L16:
        r15.f6426c = null;
        return;
    L19:
        if (StringsKt.e(r10, "mention", false) == false) goto L25;
        this.O |= this.S;
        se.a r16 = se.a.f21888a;
        Intrinsics.checkNotNullParameter(r16, "helper");
        r11.add(r16);
        this.f6420x = true;
        se.c r17 = new se.c(new NoCopySpan[]{new se.d()});
        Intrinsics.checkNotNullParameter(r17, "factory");
        LynxEditText r18 = this.M;
        if (r18 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r18 = null;
    L23:
        r18.setEditableFactory(r17);
    L25:
        if (StringsKt.e(r10, "bracket", false) == false) goto L27;
        this.O |= this.T;
        re.a r19 = re.a.f21724a;
        Intrinsics.checkNotNullParameter(r19, "helper");
        r11.add(r19);
        u();
    L27:
        Intrinsics.checkNotNullParameter(r10, "type");
        if (this.O == 0) goto L38;
        LynxEditText r20 = this.M;
        if (r20 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r20 = null;
    L32:
        r20.setBackSpaceListener(new r(this));
        this.P = (ClipboardManager) getLynxContext().getSystemService(DataType.CLIPBOARD);
        s r21 = new s(this);
        Intrinsics.checkNotNullParameter(r21, "copyListener");
        LynxEditText r22 = this.M;
        if (r22 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L36:
        r12.setCopyListener(r21);
        return;
    L35:
        r12 = r22;
        goto L36
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setSign(int r5, String r10) {
        super.setSign(r5, r10);
        LynxContext r11 = getLynxContext();
        int r12 = getSign();
        w0 r13 = (w0) r11.f10151t.get();
        LynxEditText r14 = null;
        if (r13 == null) goto L5;
        ShadowNode r15 = (ShadowNode) ((SparseArray) r13.g.f10812a).get(r12);
    L6:
        if (r15 != null) goto L8;
    L10:
        AutoHeightInputShadowNode r16 = null;
    L11:
        if (r16 == null) goto L18;
        LynxEditText r17 = this.M;
        if (r17 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
    L16:
        Intrinsics.checkNotNullParameter(r14, "edittext");
        r16.f6401e0 = r14;
        return;
    L15:
        r14 = r17;
        goto L16
    L18:
        return;
    L8:
        if ((r15 instanceof AutoHeightInputShadowNode) == false) goto L10;
        r16 = (AutoHeightInputShadowNode) r15;
        goto L11
    L5:
        r15 = null;
        goto L6
    }

    public final void u() {
        we.a r5 = com.bytedance.android.anniex.base.service.e.k();
        Function1 r10 = this.X;
        LynxContext r11 = this.mContext;
        ((LynxTextAreaView$adapterProvider$1) r10).getClass();
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        com.lynx.tasm.utils.c r12 = new com.lynx.tasm.utils.c(17);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r5.f22857a = r12;
        this.N = true;
    }

    public final void v() {
        LynxEditText r5 = this.M;
        AutoHeightInputShadowNode r10 = null;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        r5 = null;
    L6:
        if (r5.getText() == null) goto L19;
        LynxContext r11 = getLynxContext();
        int r12 = getSign();
        w0 r13 = (w0) r11.f10151t.get();
        if (r13 == null) goto L10;
        ShadowNode r14 = (ShadowNode) ((SparseArray) r13.g.f10812a).get(r12);
    L11:
        if (r14 != null) goto L13;
    L15:
        if (r10 == null) goto L20;
        r10.N();
        this.U = r10.M();
        return;
    L20:
        return;
    L13:
        if ((r14 instanceof AutoHeightInputShadowNode) == false) goto L15;
        r10 = (AutoHeightInputShadowNode) r14;
        goto L15
    L10:
        r14 = null;
        goto L11
    }
}
