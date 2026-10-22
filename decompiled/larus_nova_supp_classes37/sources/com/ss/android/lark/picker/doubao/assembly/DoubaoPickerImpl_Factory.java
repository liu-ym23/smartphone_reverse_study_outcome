package com.ss.android.lark.picker.doubao.assembly;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DoubaoPickerImpl_Factory implements Factory<DoubaoPickerImpl> {

    public static final class InstanceHolder {
        private static final DoubaoPickerImpl_Factory INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new DoubaoPickerImpl_Factory();
        }

        public static /* synthetic */ DoubaoPickerImpl_Factory access$000() {
            return INSTANCE;
        }
    }

    public DoubaoPickerImpl_Factory() {
    }

    public static DoubaoPickerImpl newInstance() {
        return new DoubaoPickerImpl();
    }

    public static DoubaoPickerImpl_Factory create() {
        return InstanceHolder.access$000();
    }

    public DoubaoPickerImpl get() {
        return newInstance();
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m3382get() {
        return get();
    }
}
