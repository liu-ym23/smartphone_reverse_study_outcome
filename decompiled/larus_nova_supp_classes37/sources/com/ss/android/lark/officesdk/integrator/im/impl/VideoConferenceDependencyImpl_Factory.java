package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class VideoConferenceDependencyImpl_Factory implements Factory<u> {

    public static final class a {
        public static final VideoConferenceDependencyImpl_Factory a = null;

        static {
            a = new VideoConferenceDependencyImpl_Factory();
        }
    }

    public VideoConferenceDependencyImpl_Factory() {
    }

    public static u newInstance() {
        return new u();
    }

    public u get() {
        return newInstance();
    }

    public static VideoConferenceDependencyImpl_Factory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m92get() {
        return get();
    }
}
