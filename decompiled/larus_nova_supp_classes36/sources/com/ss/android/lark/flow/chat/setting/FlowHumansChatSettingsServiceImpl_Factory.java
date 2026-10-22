package com.ss.android.lark.flow.chat.setting;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowHumansChatSettingsServiceImpl_Factory implements Factory<FlowHumansChatSettingsServiceImpl> {

    public static final class a {
        public static final FlowHumansChatSettingsServiceImpl_Factory a = null;

        static {
            a = new FlowHumansChatSettingsServiceImpl_Factory();
        }
    }

    public FlowHumansChatSettingsServiceImpl_Factory() {
    }

    public static FlowHumansChatSettingsServiceImpl newInstance() {
        return new FlowHumansChatSettingsServiceImpl();
    }

    public FlowHumansChatSettingsServiceImpl get() {
        return newInstance();
    }

    public static FlowHumansChatSettingsServiceImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m352get() {
        return get();
    }
}
