package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class a extends androidx.core.content.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f1587c = 0;

    /* JADX INFO: renamed from: androidx.core.app.a$a, reason: collision with other inner class name */
    public static class C0010a {
        public static void a(Activity r8) {
            r8.finishAffinity();
        }

        public static void b(Activity r8, Intent r10, int r11, Bundle r12) {
            r8.startActivityForResult(r10, r11, r12);
        }

        public static void c(Activity r8, IntentSender r10, int r11, Intent r12, int r13, int r14, int r15, Bundle r16) {
            r8.startIntentSenderForResult(r10, r11, r12, r13, r14, r15, r16);
        }
    }

    public static class b {
        public static void a(Activity r8) {
            r8.finishAfterTransition();
        }

        public static void b(Activity r8) {
            r8.postponeEnterTransition();
        }

        public static void c(Activity r8, SharedElementCallback r10) {
            r8.setEnterSharedElementCallback(r10);
        }

        public static void d(Activity r8, SharedElementCallback r10) {
            r8.setExitSharedElementCallback(r10);
        }

        public static void e(Activity r8) {
            r8.startPostponedEnterTransition();
        }
    }

    public static class c {
        public static void a(Object r8) {
            ((SharedElementCallback.OnSharedElementsReadyListener) r8).onSharedElementsReady();
        }

        public static void b(Activity r8, String[] r10, int r11) {
            r8.requestPermissions(r10, r11);
        }

        public static boolean c(Activity r8, String r10) {
            return r8.shouldShowRequestPermissionRationale(r10);
        }
    }

    public interface d {
        void validateRequestPermissionsRequestCode(int r8);
    }
}
