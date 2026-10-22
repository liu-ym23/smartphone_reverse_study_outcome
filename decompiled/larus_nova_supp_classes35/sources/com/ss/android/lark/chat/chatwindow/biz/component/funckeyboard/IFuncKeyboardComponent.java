package com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard;

import com.ss.android.lark.biz.im.api.extension.chat_window.e;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.KeyboardWrapperConfigurator;
import com.ss.android.lark.scaffold.IComponent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0003\u0019\u001a\u001bJ\u0014\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0017ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent;", "Lcom/ss/android/lark/scaffold/IComponent;", "Lcom/ss/android/lark/biz/im/api/component/callback/IComponentCallbackManager;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent$IFuncKeyboardComponentCallbacks;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/IKeyboardCommon;", "registerFuncKeyboardContent", BuildConfig.FLAVOR, "contentPlugin", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardContent;", "addKeyboardStatusListener", "listener", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent$IFuncKeyboardStatusListener;", "removeKeyboardStatusListener", "registerKeyboardControlStatusChangeListener", "Lcom/ss/android/lark/chat/chatwindow/biz/component/funckeyboard/IFuncKeyboardComponent$OnKeyboardControlStatusChangeListener;", "unRegisterKeyboardControlStatusChangeListener", "isKeyboardBanned", BuildConfig.FLAVOR, "bannedKeyboardShown", "reason", BuildConfig.FLAVOR, "banReason", "Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/BannedKeyboardReason;", "hideKeyboard", "showKeyboard", "IFuncKeyboardComponentCallbacks", "IFuncKeyboardStatusListener", "OnKeyboardControlStatusChangeListener", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFuncKeyboardComponent extends IComponent, oxa.c<a>, com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.b {

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard.IFuncKeyboardComponent$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$addKeyboardStatusListener(IFuncKeyboardComponent r0, b r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
        }

        public static void $default$bannedKeyboardShown(IFuncKeyboardComponent r0, String r1, com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a r2) {
            Intrinsics.checkNotNullParameter(r1, "reason");
            Intrinsics.checkNotNullParameter(r2, "banReason");
        }

        @Deprecated(message = "use keyboard wrapper hideKeyboard()")
        public static void $default$hideKeyboard(IFuncKeyboardComponent r0) {
        }

        public static void $default$registerKeyboardControlStatusChangeListener(IFuncKeyboardComponent r0, c r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
        }

        public static void $default$removeKeyboardStatusListener(IFuncKeyboardComponent r0, b r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
        }

        @Deprecated(message = "use keyboard wrapper showKeyboard()")
        public static void $default$showKeyboard(IFuncKeyboardComponent r0) {
        }

        public static void $default$unRegisterKeyboardControlStatusChangeListener(IFuncKeyboardComponent r0, c r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
        }
    }

    public interface a extends e {
        void b();
    }

    public interface b {
        void b(int r1);
    }

    public interface c {
        void a(boolean r1);
    }

    void FE(KeyboardWrapperConfigurator.d r1);

    @Deprecated(message = "use keyboard wrapper showKeyboard()")
    void I();

    void aV(KeyboardWrapperConfigurator.d r1);

    void f6(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a r1);

    @Deprecated(message = "use keyboard wrapper hideKeyboard()")
    void hideKeyboard();

    void pL(KeyboardWrapperConfigurator.c r1);

    void rk(KeyboardWrapperConfigurator.c r1);
}
