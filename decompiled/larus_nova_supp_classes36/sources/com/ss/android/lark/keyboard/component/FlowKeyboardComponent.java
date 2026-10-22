package com.ss.android.lark.keyboard.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.ss.android.lark.biz.im.api.extension.chat_window.h;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.BaseKeyboardComponentV2;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.IKeyboardWrapper;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.keyboard.KeyboardViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.KeyboardBuilder;
import com.ss.android.lark.keyboard.base.ReEditInfo;
import com.ss.android.lark.keyboard.base.f;
import com.ss.android.lark.keyboard.base.n;
import com.ss.android.lark.keyboard.editor.FlowChatKeyboardEditor;
import com.ss.android.lark.keyboard.editor.input.interceptor.ChatEditorMenuLayoutManager;
import com.ss.android.lark.keyboard.editor.input.interceptor.ChatKeyboardMenuInterceptor;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.d;
import com.ss.android.lark.keyboard.plugin.tool.at.AtKBPlugin;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioKBPlugin;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.e;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000ñ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0019\u0018\u0000 r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001rB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0014J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'H\u0014J\b\u0010(\u001a\u00020!H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0013H\u0016J\b\u00101\u001a\u00020\u0013H\u0016J\b\u00102\u001a\u00020\u0013H\u0016J\b\u00103\u001a\u00020\u0013H\u0016J\b\u00104\u001a\u00020\u0013H\u0016J\b\u00105\u001a\u00020\u0013H\u0002J\u0016\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:J\u000e\u0010;\u001a\u00020\u00132\u0006\u00107\u001a\u000208J\u000e\u0010<\u001a\u00020!2\u0006\u00107\u001a\u000208J#\u0010=\u001a\u0004\u0018\u0001H>\"\u0004\b\u0000\u0010>2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H>0@H\u0016¢\u0006\u0002\u0010AJ\u001a\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0016J\u001a\u0010I\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010J\u001a\u00020\u0013H\u0016J(\u0010K\u001a\u00020\u00132\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020M2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0016J\u0018\u0010S\u001a\u00020\u00132\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020VH\u0016J\u001e\u0010W\u001a\u00020\u00132\u0006\u0010X\u001a\u00020M2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J(\u0010Z\u001a\u00020\u00132\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020!2\u0006\u0010^\u001a\u00020!2\u0006\u0010_\u001a\u00020!H\u0016J \u0010`\u001a\u00020\u00132\u0006\u0010^\u001a\u00020!2\u0006\u0010[\u001a\u00020\\2\u0006\u0010_\u001a\u00020!H\u0002J4\u0010a\u001a\u00020\u00132\b\u0010b\u001a\u0004\u0018\u00010P2\b\u0010N\u001a\u0004\u0018\u00010M2\b\u0010c\u001a\u0004\u0018\u00010P2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020f0eH\u0016J\u001c\u0010g\u001a\u00020\u00132\b\u0010b\u001a\u0004\u0018\u00010P2\b\u0010c\u001a\u0004\u0018\u00010PH\u0002J\n\u0010h\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010i\u001a\u00020\u0013J,\u0010j\u001a\u00020\u00132\u001a\u0010k\u001a\u0016\u0012\u0004\u0012\u00020,\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020m0l2\u0006\u0010n\u001a\u00020oH\u0016J\u0010\u0010p\u001a\u00020\u00132\u0006\u0010n\u001a\u00020oH\u0016J\b\u0010q\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006s"}, d2 = {"Lcom/ss/android/lark/keyboard/component/FlowKeyboardComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/BaseKeyboardComponentV2;", "Lcom/ss/android/lark/keyboard/editor/FlowChatKeyboardEditor;", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "context", "Landroid/content/Context;", "activity", "Landroidx/activity/ComponentActivity;", "keyboardPluginContextExtension", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/KeyboardPluginContextExtension;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Landroid/content/Context;Landroidx/activity/ComponentActivity;Lcom/ss/android/lark/biz/im/api/extension/chat_window/KeyboardPluginContextExtension;)V", "keyboardAssembler", "Lcom/ss/android/lark/keyboard/assembler/KeyboardAssembler;", "slotService", "Lcom/ss/android/lark/keyboard/slot/IKeyboardSlotService;", "storeInputStateAction", "Lkotlin/Function0;", "", "focusChangeListener", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "hintInject", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/editor/IChatEditorHintInject;", "hintInterceptor", "com/ss/android/lark/keyboard/component/FlowKeyboardComponent$hintInterceptor$1", "Lcom/ss/android/lark/keyboard/component/FlowKeyboardComponent$hintInterceptor$1;", "onPrepareKeyboard", "keyboardBuilder", "Lcom/ss/android/lark/keyboard/KeyboardBuilder;", "initData", "Lcom/ss/android/lark/chatwindow/model/data/ChatWindowInitData;", "isDraftEnable", "", "hideOuterPlaceholder", "attachKeyboardPlugin", "selectDefaultPlugin", "onKeyboardBuild", "keyboard", "Lcom/ss/android/lark/keyboard/IKeyBoard;", "needHideKeyBoard", "getKeyboardHint", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/editor/KeyboardHint;", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "chatChatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "onCreate", "onStart", "onResume", "onPause", "onStop", "onDestroy", "updateHintByInputFocus", "addSlot", "position", "Lcom/ss/android/lark/keyboard/slot/SlotPosition;", "element", "Lcom/ss/android/lark/keyboard/slot/ISlotElement;", "removeSlot", "hasSlot", "getService", "T", "serviceClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "createChatReplyDigestCreator", "Lcom/ss/android/lark/chat/chatwindow/chat/data/reply/IReplyMsgDigestCreator;", "chatContainer", "createKeyboardPluginFactory", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboard/base/IKeyboardPluginFactory;", "pluginContext", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatKeyboardPluginContext;", "setupKeyboardEnable", "performSaveInputState", "onRetryEditMessage", "messageId", "", "title", "content", "Lcom/ss/android/lark/widget/richtext/RichText;", "messageVersion", "", "onEnterReEditMode", "fromDraft", "inputState", "Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/InputState;", "checkEditInputStateAndRun", "reEditMsgId", "action", "enterReplyMode", "replyInfo", "Lcom/ss/android/lark/chatwindow/model/data/ReplyInfo;", "isReEdit", "resetOnStart", "closeIme", "enterReplyModeImpl", "appendText", "text", "postText", "fileAttachments", "", "Lcom/ss/android/lark/keyboard/base/ChatAttachmentEntity;", "appendTextImpl", "getInputEditorInner", "showTextInputKeyboard", "registerHintProvider", "inject", "Lkotlin/Function2;", "", TabAppInfo.IMAGE_JSON_KEY, "Lcom/ss/android/lark/biz/im/api/extension/keyboard/editor/KeyboardHintPriority;", "unRegisterHintProvider", "forceUpdateHint", "Companion", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowKeyboardComponent extends BaseKeyboardComponentV2<FlowChatKeyboardEditor> {
    public static final /* synthetic */ int A = 0;
    public final h w;
    public b x;
    public final com.ss.android.lark.keyboard.editor.c y;
    public final com.ss.android.lark.keyboard.component.a z;

    public static final class a {
    }

    public static final class b implements ViewTreeObserver.OnGlobalFocusChangeListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ FlowKeyboardComponent b;

        public b(EditText r1, FlowKeyboardComponent r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View r2, View r3) {
            EditText r0 = this.a;
            if (r2 == r0) goto L5;
            if (r3 == r0) goto L5;
            return;
        L5:
            FlowKeyboardComponent r4 = this.b;
            int r5 = FlowKeyboardComponent.A;
            r4.U0();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ FlowKeyboardComponent a;

        public c(FlowKeyboardComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Chatter r6 = (Chatter) r5;
            FlowKeyboardComponent r0 = this.a;
            int r1 = FlowKeyboardComponent.A;
            KeyboardViewModel r2 = ((BaseKeyboardComponentV2) r0).p;
            if (r2 == null) goto L17;
            Chat r3 = r2.getCurrentChat();
            if (r3 == null) goto L19;
            com.ss.android.lark.keyboard.b r4 = ((BaseKeyboardComponentV2) this.a).n;
            f r7 = null;
            if (r4 == null) goto L10;
            com.ss.android.lark.keyboard.keyboard2.b r8 = r4.L();
        L12:
            if ((r8 instanceof f) == false) goto L14;
            r7 = (f) r8;
        L14:
            if (r7 == null) goto L18;
            r7.I(this.a.T0(r3, r6).a);
            return;
        L18:
            return;
        L10:
            r8 = null;
            goto L12
        L19:
            return;
        }
    }

    static {
    }

    public final boolean J0() {
        KeyboardViewModel r0 = ((BaseKeyboardComponentV2) this).p;
        if (r0 == null) goto L7;
        MutableLiveData r1 = r0.getP2pChatterLiveData();
        if (r1 == null) goto L7;
        Chatter r2 = (Chatter) r1.getValue();
    L9:
        if (r2 == null) goto L13;
        boolean r3 = true;
        if (r2.isDimission() != true) goto L13;
    L14:
        if (r3 == false) goto L17;
        return false;
    L17:
        return super.J0();
    L13:
        r3 = false;
    L7:
        r2 = null;
        goto L9
    }

    public final void S0() {
        KeyboardViewModel r0 = ((BaseKeyboardComponentV2) this).p;
        if (r0 == null) goto L23;
        Chat r1 = r0.getCurrentChat();
        if (r1 == null) goto L25;
        KeyboardViewModel r2 = ((BaseKeyboardComponentV2) this).p;
        f r3 = null;
        if (r2 == null) goto L12;
        MutableLiveData r4 = r2.getP2pChatterLiveData();
        if (r4 == null) goto L12;
        Chatter r5 = (Chatter) r4.getValue();
    L13:
        com.ss.android.lark.keyboard.b r6 = ((BaseKeyboardComponentV2) this).n;
        if (r6 == null) goto L16;
        com.ss.android.lark.keyboard.keyboard2.b r7 = r6.L();
    L18:
        if ((r7 instanceof f) == false) goto L20;
        r3 = (f) r7;
    L20:
        if (r3 == null) goto L24;
        r3.I(T0(r1, r5).a);
        return;
    L24:
        return;
    L16:
        r7 = null;
    L12:
        r5 = null;
        goto L13
    L25:
        return;
    }

    public final void U0() {
        com.ss.android.lark.keyboard.b r0 = ((BaseKeyboardComponentV2) this).n;
        if (r0 == null) goto L9;
        com.ss.android.lark.keyboard.keyboard2.b r1 = r0.L();
        if (r1 == null) goto L9;
        EditText r2 = r1.c();
        if (r2 == null) goto L9;
        boolean r3 = r2.hasFocus();
    L10:
        boolean r4 = com.ss.android.lark.keyboard.utils.a.a;
        com.ss.android.lark.keyboard.utils.a.a = r3;
        S0();
        return;
    L9:
        r3 = false;
        goto L10
    }

    public final void onDestroy() {
        com.ss.android.lark.keyboard.b r0 = ((BaseKeyboardComponentV2) this).n;
        if (r0 == null) goto L7;
        com.ss.android.lark.keyboard.keyboard2.b r1 = r0.L();
        if (r1 == null) goto L7;
        EditText r2 = r1.c();
    L8:
        b r3 = this.x;
        if (r2 == null) goto L14;
        if (r3 == null) goto L14;
        ViewTreeObserver r4 = r2.getViewTreeObserver();
        if (r4.isAlive() == false) goto L14;
        r4.removeOnGlobalFocusChangeListener(r3);
    L14:
        this.x = null;
        super.onDestroy();
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void onCreate() {
        super.onCreate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onPause() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onPause();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onResume() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onResume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStart() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*com.ss.android.lark.framework.larkwidget.Widget*/.onStop();
    }

    public final void F0(i7b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "initData");
        super.F0(r2);
        if (TextUtils.equals(r2.a, "sticker_set_activity") == false) goto L10;
        com.ss.android.lark.keyboard.b r3 = ((BaseKeyboardComponentV2) this).n;
        if (r3 == null) goto L9;
        d r4 = r3.H();
        r4.h();
        r4.w(KeyboardMenuItemKey.Emoji);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.ss.android.lark.keyboard.factory.a H0(j2b.c r8) {
        Intrinsics.checkNotNullParameter(r8, "pluginContext");
        v r2 = ((BaseKeyboardComponentV2) this).m;
        com.ss.android.lark.framework.larkwidget.b r1 = this.a;
        FragmentManager r3 = null;
        if (r1 == null) goto L5;
        Fragment r4 = r1.getHostFragment();
    L6:
        if (r4 == null) goto L9;
        r3 = r4.getChildFragmentManager();
    L9:
        return new com.ss.android.lark.keyboard.factory.a(r2, r3, r8, ((BaseKeyboardComponentV2) this).l.a, this.w);
    L5:
        r4 = null;
        goto L6
    }

    public final void M0(com.ss.android.lark.keyboard.b r3) {
        Intrinsics.checkNotNullParameter(r3, "keyboard");
        super.M0(r3);
        EditText r0 = r3.L().c();
        if (this.x != null) goto L5;
        this.x = new b(r0, this);
        r0.getViewTreeObserver().addOnGlobalFocusChangeListener(this.x);
    L5:
        U0();
        KeyboardViewModel r1 = ((BaseKeyboardComponentV2) this).p;
        if (r1 == null) goto L10;
        MutableLiveData r2 = r1.getP2pChatterLiveData();
        if (r2 == null) goto L10;
        r2.observe(this, new c(this));
    L10:
        r3.v().e().h();
        r3.v().e().g();
    }

    public final com.ss.android.lark.keyboard.reply.a G0(v r1, Chat r2) {
        Intrinsics.checkNotNullParameter(r1, "chatContainer");
        return new com.ss.android.lark.keyboard.reply.a(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L0(boolean r9, final cya.h r10) {
        Intrinsics.checkNotNullParameter(r10, "inputState");
        IKeyboardWrapper r0 = u0(IKeyboardWrapper.class);
        if (r0 == null) goto L5;
        r0.i0(null);
    L5:
        if (r9 == false) goto L9;
        Intrinsics.checkNotNullParameter(r10, "state");
        cya.d r11 = I0();
        if (r11 == null) goto L41;
        r11.b(r10);
        return;
    L41:
        return;
    L9:
        n r12 = r10.a;
        ReEditInfo.a r1 = ReEditInfo.Companion;
        ReEditInfo r13 = (ReEditInfo) r12.a(r1);
        if (r13 == null) goto L13;
        String r14 = r13.getMessageId();
        if (r14 == null) goto L13;
    L14:
        final Function0<Unit> r3 = new FlowKeyboardComponent$onEnterReEditMode$1(this, r10);
        cya.d r15 = I0();
        if (r15 == null) goto L17;
        cya.h r16 = r15.d();
    L18:
        cya.d r4 = I0();
        boolean r5 = false;
        if (r4 != null) goto L21;
    L23:
        boolean r6 = false;
    L25:
        if (Intrinsics.areEqual(r14, "") == true) goto L36;
        if (r16 == null) goto L32;
        n r17 = r16.a;
        if (r17 == null) goto L32;
        ReEditInfo r18 = (ReEditInfo) r17.a(r1);
        if (r18 == null) goto L32;
        String r19 = r18.getMessageId();
    L34:
        if (Intrinsics.areEqual(r14, r19) == false) goto L36;
        r5 = true;
    L32:
        r19 = null;
    L36:
        if (r5 == true) goto L39;
        if (r6 == false) goto L39;
        Context r20 = B0();
        Function0<Unit> r110 = new FlowKeyboardComponent$checkEditInputStateAndRun$1(r3);
        Intrinsics.checkNotNullParameter(r110, "onConfirmHandler");
        new UDDialogBuilder(r20).title(2131891076).message(2131891074).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093).text(2131891073).onClickListener(new cob.a(r110))).addActionButton(2131391778, 2131891075, null).show();
        return;
    L39:
        r3.invoke();
        return;
    L21:
        if (r4.c(4) != true) goto L23;
        r6 = true;
        goto L25
    L17:
        r16 = null;
    L13:
        r14 = "";
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N0(KeyboardBuilder.b r17, i7b.a r18) {
        Intrinsics.checkNotNullParameter(r17, "keyboardBuilder");
        Intrinsics.checkNotNullParameter(r18, "initData");
        Context r1 = B0();
        ChatChatter r2 = r18.g;
        KeyboardViewModel r4 = ((BaseKeyboardComponentV2) this).p;
        if (r4 == null) goto L23;
        ArrayList r5 = ((BaseKeyboardComponentV2) this).l.a;
        Intrinsics.checkNotNullParameter(r18, "initData");
        boolean r6 = r18.f.isAIChat();
        com.ss.android.lark.keyboard.editor.c r7 = this.y;
        com.ss.android.lark.keyboard.b r0 = ((BaseKeyboardComponentV2) this).n;
        if (r0 == null) goto L11;
        d r3 = r0.H();
        if (r3 == null) goto L11;
        AudioKBPlugin r8 = (AudioKBPlugin) r3.i(KeyboardMenuItemKey.Voice, AudioKBPlugin.class);
        if (r8 == null) goto L11;
        e r9 = r8.u;
    L12:
        e r10 = r9;
        Fragment r11 = getFragment();
        if (this.w.b.length() <= 0) goto L15;
        boolean r12 = true;
    L16:
        final com.ss.android.lark.keyboard.editor.d r14 = new com.ss.android.lark.keyboard.editor.d(r1, r2, this, r4, r5, r6, r7, r10, r11, r12);
        ChatKeyboardMenuInterceptor r13 = new ChatKeyboardMenuInterceptor();
        com.ss.android.lark.keyboard.editor.input.interceptor.a r15 = new com.ss.android.lark.keyboard.editor.input.interceptor.a(r18);
        ChatEditorMenuLayoutManager r16 = new ChatEditorMenuLayoutManager();
        FlowChatKeyboardEditor r19 = r14.d();
        if (r19 == null) goto L21;
        r17.c(r19);
        r17.a(ChatKeyboardMenuInterceptor.l, r13);
        r17.a(com.ss.android.lark.keyboard.editor.input.interceptor.a.c, r15);
        r17.a(ChatEditorMenuLayoutManager.e, r16);
        new FlowKeyboardComponent$onPrepareKeyboard$2(this, r14);
        return;
    L21:
        throw new IllegalArgumentException("Required value was null.".toString());
    L15:
        r12 = false;
    L11:
        r9 = null;
        goto L12
    L23:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void O0(Chat r5, Chatter r6) {
        Intrinsics.checkNotNullParameter(r5, "chat");
        com.ss.android.lark.keyboard.b r0 = ((BaseKeyboardComponentV2) this).n;
        if (r0 == null) goto L26;
        boolean r2 = false;
        if (r5.isP2PChat() == false) goto L14;
        boolean r1 = true;
        if (r6 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L14;
    L15:
        if (r1 == true) goto L18;
        r2 = r5.isAllowPost();
    L18:
        com.ss.android.lark.keyboard.keyboard2.b r4 = r0.L();
        r4.setEnable(r2);
        if ((r4 instanceof f) == false) goto L21;
        zxa.c r7 = T0(r5, r6);
        ((f) r4).O(r7.a, r7.b);
    L21:
        AtKBPlugin r8 = (AtKBPlugin) r0.H().i(KeyboardMenuItemKey.At, AtKBPlugin.class);
        if (r8 == null) goto L24;
        r8.k = r5;
    L24:
        r0.H().m();
        return;
    L9:
        if (r6.isDimission() != true) goto L11;
        r3 = true;
    L14:
        r1 = false;
        goto L15
    }

    public final void R0(final i7b.c r3, final boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "replyInfo");
        final boolean r1 = false;
        P0(new FlowKeyboardComponent$enterReplyMode$1(this, r1, r3, r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zxa.c T0(Chat r4, Chatter r5) {
        Intrinsics.checkNotNullParameter(r4, "chat");
        return this.y.a(B0(), r4, r5, this.z);
    }

    public final void Q0(final RichText r2, final RichText r3, List r4) {
        Intrinsics.checkNotNullParameter(r4, "fileAttachments");
        P0(new FlowKeyboardComponent$appendText$1(this, r2, r3));
    }

    public FlowKeyboardComponent(v r4, Context r5, FragmentActivity r6, h r7) {
        Intrinsics.checkNotNullParameter(r4, "chatAppContainer");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "activity");
        Intrinsics.checkNotNullParameter(r7, "keyboardPluginContextExtension");
        super(r4);
        this.w = r7;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "activity");
        new LinkedHashMap();
        FlowKeyboardComponent$storeInputStateAction$1 r8 = FlowKeyboardComponent$storeInputStateAction$1.INSTANCE;
        this.y = new com.ss.android.lark.keyboard.editor.c();
        this.z = new com.ss.android.lark.keyboard.component.a(this);
    }

    public final void P3(final String r1, final String r2, final RichText r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "content");
        P0(new FlowKeyboardComponent$onRetryEditMessage$1(this, r2, r3, r1));
    }
}
