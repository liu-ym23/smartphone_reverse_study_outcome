package com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper;

import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator.KeyboardWrapperConfigurator;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IKeyboardWrapper extends com.ss.android.lark.framework.larkwidget.c {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/keyboardwrapper/IKeyboardWrapper$KeyboardType;", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.TYPE, AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface KeyboardType {
        public static final int CREATE_THREAD = 2;
        public static final a Companion = null;
        public static final int FUNC = 1;
        public static final int INPUT = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public interface a {
        void a(int r1, int r2);

        void b(int r1);
    }

    void I();

    int d0();

    void hideKeyboard();

    void i0(Function0 r1);

    void l0(KeyboardWrapperConfigurator.b r1);

    void r(com.ss.android.lark.chat.chatwindow.biz.component.keyboardwrapper.a r1);

    void start(Function1 r1);
}
