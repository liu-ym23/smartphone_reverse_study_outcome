package com.byted.cast.sdk;

import android.opengl.GLSurfaceView;
import com.byted.cast.engine.VoipVideoRender;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RTCVideoRender extends VoipVideoRender {

    /* JADX INFO: renamed from: com.byted.cast.sdk.RTCVideoRender$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ContextFactory implements GLSurfaceView.EGLContextFactory {
        private static int EGL_CONTEXT_CLIENT_VERSION = 12440;

        private ContextFactory() {
        }

        public /* synthetic */ ContextFactory(AnonymousClass1 r1) {
            this();
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 r10, EGLDisplay r11, EGLConfig r12) {
            return r10.eglCreateContext(r11, r12, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 r1, EGLDisplay r10, EGLContext r11) {
            r1.eglDestroyContext(r10, r11);
        }
    }

    public interface StatusListener {
        void onVideoSimulcasted(int r1);

        void onVideoStatusChanged(boolean r1);
    }

    public boolean clearSource() {
        return super.clearSource();
    }

    public RTCMediaKind getMediaKind() {
        return super.getMediaKind();
    }

    public String getUserId() {
        return super.getUserId();
    }

    public boolean isSetSource() {
        return super.isSetSource();
    }

    public boolean isSubscribed() {
        return super.isSubscribed();
    }

    public boolean subscribe() {
        return super.subscribe();
    }

    public boolean unsubscribe() {
        return super.unsubscribe();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RTCVideoRender(GLSurfaceView r10, String r11) {
        super(r10, r11);
        r10.setEGLContextFactory(new ContextFactory(null));
        r10.setEGLContextClientVersion(2);
        r10.setRenderer(this);
        r10.setRenderMode(0);
    }

    public boolean setSource(String r1, RTCMediaKind r10, StatusListener r11) {
        return super.setSource(r1, r10, r11);
    }
}
