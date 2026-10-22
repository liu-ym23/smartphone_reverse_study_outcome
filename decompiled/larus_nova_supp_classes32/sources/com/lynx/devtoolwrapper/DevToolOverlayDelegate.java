package com.lynx.devtoolwrapper;

import android.app.Dialog;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DevToolOverlayDelegate {
    private OverlayService mService;

    /* JADX INFO: renamed from: com.lynx.devtoolwrapper.DevToolOverlayDelegate$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SingletonHelper {
        private static final DevToolOverlayDelegate INSTANCE = null;

        private SingletonHelper() {
        }

        static {
            INSTANCE = new DevToolOverlayDelegate(null);
        }

        public static /* synthetic */ DevToolOverlayDelegate access$100() {
            return INSTANCE;
        }
    }

    private DevToolOverlayDelegate() {
    }

    public ArrayList<Integer> getAllVisibleOverlaySign() {
        OverlayService r0 = this.mService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAllVisibleOverlaySign();
    }

    public ArrayList<Dialog> getGlobalOverlayView() {
        OverlayService r0 = this.mService;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getGlobalOverlayView();
    }

    public static DevToolOverlayDelegate getInstance() {
        return SingletonHelper.access$100();
    }

    public /* synthetic */ DevToolOverlayDelegate(AnonymousClass1 r1) {
        this();
    }

    public void init(OverlayService r1) {
        this.mService = r1;
    }
}
