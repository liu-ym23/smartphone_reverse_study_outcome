package com.larus.bmhome.view;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.widget.AppCompatEditText;
import com.larus.bmhome.input.api.EnterKeyAction;
import com.larus.bmhome.input.api.EnterKeyBehaviorServiceDelegate;
import com.larus.bmhome.social.MentionedUserInfo;
import com.larus.utils.logger.FLogger;
import hq9.f0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001*\u0018\u0000 Z2\u00020\u0001:\u0002Z[B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020%J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020%J\u0012\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u000e\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\nJ0\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\n2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\n0\u001b2\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bJ\u0010\u00105\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u00010\u0014J\u0010\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u000209H\u0002J\u001a\u0010:\u001a\u0016\u0012\u0004\u0012\u00020;\u0012\f\u0012\n\u0012\u0004\u0012\u00020=\u0018\u00010<0\u0016J\u000e\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020=J\u0006\u0010@\u001a\u00020\u000eJ\u000e\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020;J\u0018\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020\u0017H\u0014J\b\u0010F\u001a\u00020\u000eH\u0014J\b\u0010G\u001a\u00020\u000eH\u0014J\u000e\u0010H\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\nJ\u001a\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010KH\u0016J\u0018\u0010L\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\u00172\u0006\u0010N\u001a\u00020\u0017H\u0002J\u0014\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\u0012\u0010S\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u00010TH\u0016J\u001a\u0010U\u001a\u00020\n2\u0006\u0010J\u001a\u00020\u00172\b\u00108\u001a\u0004\u0018\u00010KH\u0016J\u0018\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u0017H\u0014R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+¨\u0006\\"}, d2 = {"Lcom/larus/bmhome/view/ChatInputText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "visibilityChangeCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "", "getVisibilityChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setVisibilityChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "inputMentionMediator", "Lcom/larus/bmhome/social/InputMentionMediator;", "mentionSearchAreaRange", "Lkotlin/Pair;", "", "inputIsFromActionBar", "isImeUseSendOption", "onImeHide", "Lkotlin/Function0;", "getOnImeHide", "()Lkotlin/jvm/functions/Function0;", "setOnImeHide", "(Lkotlin/jvm/functions/Function0;)V", "onEnterKeySend", "getOnEnterKeySend", "setOnEnterKeySend", "deleteSurroundingTextInterceptors", "", "Lcom/larus/bmhome/view/ChatInputText$DeleteSurroundingTextInterceptor;", "addDeleteSurroundingTextInterceptor", "interceptor", "removeDeleteSurroundingTextInterceptor", "textWatcher", "com/larus/bmhome/view/ChatInputText$textWatcher$1", "Lcom/larus/bmhome/view/ChatInputText$textWatcher$1;", "spanCountLog", "p0", "", "adjustFontSize", "isImmersive", "configCustomCopyAndSendActionMode", "enable", "needPasteAndSend", "onPasteAndSend", "setInputMentionMediator", "mediator", "mentionNotify", "event", "Lcom/larus/bmhome/social/InputMentionEvent;", "prepareContentWithMention", "", "", "Lcom/larus/bmhome/social/MentionedUserInfo;", "insertMentionSpan", "mentionedUserInfo", "clearSearchString", "clearMentionSpan", "id", "onSelectionChanged", "selStart", "selEnd", "onAttachedToWindow", "onDetachedFromWindow", "imeUseSendOption", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "sanitizeImeDeleteLength", "requestedLength", "editableLength", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDragEvent", "Landroid/view/DragEvent;", "onKeyPreIme", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "Companion", "DeleteSurroundingTextInterceptor", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInputText extends AppCompatEditText {
    public static final f0 h = null;
    public Function1<? super Boolean, Unit> a;
    public Pair<Integer, Integer> b;
    public boolean c;
    public Function0<Unit> d;
    public Function0<Unit> e;
    public final List<b> f;
    public final d g;

    public static final class a {
    }

    public interface b {
        boolean y9(int r1, int r2);

        boolean z9(int r1, int r2);
    }

    public static final class c extends InputConnectionWrapper {
        public final /* synthetic */ ChatInputText a;

        public c(InputConnection r1, ChatInputText r2) {
            this.a = r2;
            super(r1, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean commitText(CharSequence r2, int r3) {
            if (r2 != null) goto L6;
            FLogger.a.w("ChatInputTextLog", "commitText ignored because IME supplied null text");
            return false;
        L6:
            return super.commitText(r2, r3);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r5, int r6) {
            List<b> r0 = this.a.f;
            if ((r0 instanceof Collection) == true) goto L5;
        L7:
            Iterator r1 = ((ArrayList) r0).iterator();
        L9:
            if (r1.hasNext() == false) goto L13;
            if (((b) r1.next()).y9(r5, r6) == false) goto L9;
            boolean r2 = true;
        L14:
            if (r2 == false) goto L17;
            return true;
        L17:
            if (com.larus.platform.service.z2.a.enableChatInputDeleteOverflowFix() == false) goto L19;
            Editable r3 = this.a.getText();
            if (r3 == null) goto L23;
            int r4 = r3.length();
        L24:
            this.a.getClass();
            int r7 = RangesKt.coerceIn(r5, 0, r4);
            this.a.getClass();
            return super.deleteSurroundingText(r7, RangesKt.coerceIn(r6, 0, r4));
        L23:
            r4 = 0;
            goto L24
        L19:
            return super.deleteSurroundingText(r5, r6);
        L13:
            r2 = false;
            goto L14
        L5:
            if (((ArrayList) r0).isEmpty() == false) goto L7;
            goto L7
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingTextInCodePoints(int r5, int r6) {
            List<b> r0 = this.a.f;
            if ((r0 instanceof Collection) == true) goto L5;
        L7:
            Iterator r1 = ((ArrayList) r0).iterator();
        L9:
            if (r1.hasNext() == false) goto L13;
            if (((b) r1.next()).z9(r5, r6) == false) goto L9;
            boolean r2 = true;
        L14:
            if (r2 == false) goto L17;
            return true;
        L17:
            if (com.larus.platform.service.z2.a.enableChatInputDeleteOverflowFix() == false) goto L19;
            Editable r3 = this.a.getText();
            if (r3 == null) goto L23;
            int r4 = Character.codePointCount(r3, 0, r3.length());
        L24:
            this.a.getClass();
            int r7 = RangesKt.coerceIn(r5, 0, r4);
            this.a.getClass();
            return super.deleteSurroundingTextInCodePoints(r7, RangesKt.coerceIn(r6, 0, r4));
        L23:
            r4 = 0;
            goto L24
        L19:
            return super.deleteSurroundingTextInCodePoints(r5, r6);
        L13:
            r2 = false;
            goto L14
        L5:
            if (((ArrayList) r0).isEmpty() == false) goto L7;
            goto L7
        }
    }

    public static final class d implements TextWatcher {
        public final /* synthetic */ ChatInputText a;

        public d(ChatInputText r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r2) {
            g2a.d.b(r2);
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r4, int r5, int r6, int r7) {
            g2a.d.b(r4);
            if (r6 <= r7) goto L26;
            Editable r8 = this.a.getText();
            if (r8 == null) goto L27;
            ChatInputText r9 = this.a;
            int r10 = r6 + r5;
            if (Intrinsics.areEqual(r8.subSequence(r5, r10).toString(), "@") == false) goto L10;
            int r11 = ur8.d.a;
            f0 r12 = ChatInputText.h;
            r9.getClass();
            return;
        L10:
            z1[] r13 = (z1[]) r8.getSpans(r5, r10, z1.class);
            ArrayList r14 = new ArrayList();
            Intrinsics.checkNotNull(r13);
            int r15 = r13.length;
            int r0 = 0;
        L11:
            if (r0 >= r15) goto L21;
            Object r1 = r13[r0].a();
            if ((r1 instanceof MentionedUserInfo) == false) goto L15;
            MentionedUserInfo r2 = (MentionedUserInfo) r1;
        L16:
            if (r2 == null) goto L28;
            String r3 = r2.getId();
            if (r3 == null) goto L29;
            r14.add(r3);
            r0 = r0 + 1;
            goto L11
        L29:
            return;
        L28:
            return;
        L15:
            r2 = null;
            goto L16
        L21:
            new ur8.c(r14);
            f0 r16 = ChatInputText.h;
            r9.getClass();
            return;
        L27:
            return;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r12, int r13, int r14, int r15) {
            g2a.d.b(r12);
            ChatInputText r0 = this.a;
            f0 r1 = ChatInputText.h;
            r0.getClass();
            boolean r2 = r12 instanceof Spannable;
            Pair<Integer, Integer> r3 = null;
            if (r2 == false) goto L5;
            Spannable r4 = (Spannable) r12;
        L7:
            if (r4 == null) goto L9;
            z1[] r5 = (z1[]) r4.getSpans(0, r4.length(), z1.class);
            int r6 = r4.getSpans(0, r4.length(), ForegroundColorSpan.class).length;
        L9:
            if (r2 == false) goto L11;
            Spannable r16 = (Spannable) r12;
        L12:
            if (r16 == null) goto L62;
            ChatInputText r7 = this.a;
            z1[] r8 = (z1[]) r16.getSpans(0, r13, z1.class);
            Intrinsics.checkNotNull(r8);
            z1 r9 = (z1) ArraysKt.lastOrNull(r8);
            if (r9 == null) goto L16;
            int r10 = r16.getSpanEnd(r9);
        L17:
            if (r14 != 0) goto L20;
            if (r15 <= r14) goto L20;
            r13 = r13 + r15;
        L25:
            if (r10 > r13) goto L56;
            z1[] r17 = (z1[]) r16.getSpans(r10, r13, z1.class);
            if (StringsKt.startsWith$default(r16, "@", false, 2, null) == true) goto L30;
        L32:
            Intrinsics.checkNotNull(r17);
            if (r17.length != 0) goto L35;
            boolean r18 = true;
        L37:
            if ((!r18) == false) goto L39;
            this.a.c = true;
            goto L56
        L39:
            CharSequence r19 = r16.subSequence(r10, r13);
            int r110 = r19.length() - 1;
            if (r110 < 0) goto L50;
        L41:
            int r11 = r110 - 1;
            if (r19.charAt(r110) != '@') goto L44;
            boolean r20 = true;
        L45:
            if (r20 == true) goto L51;
            if (r11 < 0) goto L50;
            r110 = r11;
        L51:
            if (r110 == (-1)) goto L56;
            if (StringsKt.contains$default(r19.subSequence(r110, r19.length()).toString(), " ", false, 2, null) == true) goto L56;
            int r111 = r110 + r10;
            r16.subSequence(r111, r19.length() + r10).toString();
            r3 = new Pair(Integer.valueOf(r111), Integer.valueOf(r19.length() + r10));
            goto L56
        L44:
            r20 = false;
        L50:
            r110 = -1;
            goto L51
        L35:
            r18 = false;
            goto L37
        L30:
            if (StringsKt.endsWith$default(r16, " ", false, 2, null) == false) goto L32;
            ChatInputText r21 = this.a;
            int r22 = ur8.d.a;
            r21.getClass();
        L56:
            r7.b = r3;
            if (r3 == null) goto L63;
            new ur8.e(StringsKt.removePrefix(r16.subSequence(((Number) r3.getFirst()).intValue(), ((Number) r3.getSecond()).intValue()).toString(), "@"));
            return;
        L63:
            return;
        L20:
            if (r15 != 0) goto L23;
            if (r15 < r14) goto L25;
        L23:
            r13 = r10;
            goto L25
        L16:
            r10 = 0;
            goto L17
        L62:
            return;
        L11:
            r16 = null;
            goto L12
        L5:
            r4 = null;
            goto L7
        }
    }

    public final boolean onDragEvent(DragEvent r1) {
        return false;
    }

    public final void setInputMentionMediator(ur8.b r1) {
    }

    static {
        h = com.larus.platform.service.z2.a.chatInputOptConfig();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.EditText*/.onAttachedToWindow();
        if (h.a() == false) goto L5;
        return;
    L5:
        addTextChangedListener(this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.EditText*/.onDetachedFromWindow();
        if (h.a() == false) goto L5;
        return;
    L5:
        removeTextChangedListener(this.g);
    }

    public final Function0<Unit> getOnEnterKeySend() {
        return this.e;
    }

    public final Function0<Unit> getOnImeHide() {
        return this.d;
    }

    public final Function1<Boolean, Unit> getVisibilityChangeCallback() {
        return this.a;
    }

    public ChatInputText(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final InputConnection onCreateInputConnection(EditorInfo r7) {
        InputConnection r0 = super.onCreateInputConnection(r7);
        if (r0 != null) goto L6;
        return null;
    L6:
        FLogger r1 = FLogger.a;
        r1.i("ChatInputTextLog", "onCreateInputConnection");
        if (r7 == null) goto L22;
        if (r7.extras != null) goto L11;
        r7.extras = new Bundle();
    L11:
        Bundle r2 = r7.extras;
        boolean r4 = true;
        if (r2 == null) goto L15;
        r2.putBoolean("IS_DOUBAO_CHAT_EDITOR", true);
    L15:
        if (EnterKeyBehaviorServiceDelegate.b.a() == EnterKeyAction.SEND) goto L18;
        r4 = false;
    L18:
        if (r4 == false) goto L20;
        r1.d("ChatInputTextLog", "before imeOptions:" + r7.imeOptions);
        r7.imeOptions = ((r7.imeOptions & (-1073741825)) & (-256)) | 4;
        r7.inputType = r7.inputType & (-131073);
        r1.d("ChatInputTextLog", "after imeOptions:" + r7.imeOptions);
        goto L22
    L20:
        r7.imeOptions = (r7.imeOptions & (-256)) | 1073741824;
    L22:
        return new c(r0, this);
    }

    public final void setOnEnterKeySend(Function0<Unit> r1) {
        this.e = r1;
    }

    public final void setOnImeHide(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setVisibilityChangeCallback(Function1<? super Boolean, Unit> r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatInputText(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.d = new a0();
        this.f = new ArrayList();
        this.g = new d(this);
        setText(null);
        if (h.a() == true) goto L6;
        setEditableFactory(new v3(new NoCopySpan[]{new g4(Reflection.getOrCreateKotlinClass(z1.class))}));
        setOnKeyListener(new b0());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyDown(int r4, KeyEvent r5) {
        if (r4 != 66) goto L22;
        if (r5 == null) goto L22;
        if (r5.isShiftPressed() == true) goto L22;
        EnterKeyAction r0 = EnterKeyBehaviorServiceDelegate.b.a();
        if (r5.isCtrlPressed() == false) goto L16;
        if (r0 == EnterKeyAction.SEND) goto L22;
        Function0<Unit> r6 = this.e;
        if (r6 == null) goto L14;
        r6.invoke();
    L14:
        return true;
    L16:
        if (r0 != EnterKeyAction.SEND) goto L22;
        Function0<Unit> r7 = this.e;
        if (r7 == null) goto L20;
        r7.invoke();
    L20:
        return true;
    L22:
        return super/*android.widget.EditText*/.onKeyDown(r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onKeyPreIme(int r4, KeyEvent r5) {
        if (r4 != 4) goto L12;
        boolean r0 = false;
        if (r5 != null) goto L7;
    L9:
        if (r0 == false) goto L12;
        this.d.invoke();
        goto L12
    L7:
        if (r5.getAction() != 1) goto L9;
        r0 = true;
    L12:
        return super/*android.widget.EditText*/.onKeyPreIme(r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSelectionChanged(int r1, int r2) {
        super/*android.widget.EditText*/.onSelectionChanged(r1, r2);
        if (r1 == r2) goto L5;
        return;
    L5:
        Pair<Integer, Integer> r3 = this.b;
        if (r3 == null) goto L11;
        if (((Number) r3.getSecond()).intValue() == r2) goto L11;
        this.b = null;
        int r4 = ur8.d.a;
    L11:
        if (this.c == false) goto L14;
        int r5 = ur8.d.a;
        this.c = false;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super/*android.widget.EditText*/.onVisibilityChanged(r2, r3);
        Function1<? super Boolean, Unit> r4 = this.a;
        if (r4 == null) goto L9;
        if (r3 != 0) goto L6;
        boolean r5 = true;
    L7:
        r4.invoke(Boolean.valueOf(r5));
        return;
    L6:
        r5 = false;
        goto L7
    }
}
