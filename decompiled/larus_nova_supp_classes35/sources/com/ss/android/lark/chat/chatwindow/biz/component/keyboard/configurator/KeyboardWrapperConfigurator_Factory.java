package com.ss.android.lark.chat.chatwindow.biz.component.keyboard.configurator;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class KeyboardWrapperConfigurator_Factory implements Factory<KeyboardWrapperConfigurator> {

    public static final class a {
        public static final KeyboardWrapperConfigurator_Factory a = null;

        static {
            a = new KeyboardWrapperConfigurator_Factory();
        }
    }

    public KeyboardWrapperConfigurator_Factory() {
    }

    public static KeyboardWrapperConfigurator newInstance() {
        return new KeyboardWrapperConfigurator();
    }

    public KeyboardWrapperConfigurator get() {
        return newInstance();
    }

    public static KeyboardWrapperConfigurator_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m200get() {
        return get();
    }
}
