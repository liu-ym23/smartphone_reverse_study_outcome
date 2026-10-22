package com.ss.android.lark.framework.assembly.filepicker;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FilePickerModuleDependencyImpl_Factory implements Factory<fjb.a> {

    public static final class a {
        public static final FilePickerModuleDependencyImpl_Factory a = null;

        static {
            a = new FilePickerModuleDependencyImpl_Factory();
        }
    }

    public FilePickerModuleDependencyImpl_Factory() {
    }

    public static fjb.a newInstance() {
        return new fjb.a();
    }

    public fjb.a get() {
        return newInstance();
    }

    public static FilePickerModuleDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m660get() {
        return get();
    }
}
