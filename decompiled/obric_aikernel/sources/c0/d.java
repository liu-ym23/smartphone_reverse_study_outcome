package c0;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.core.ActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public class d {

    static class a implements t4.d {
        a() {
        }

        @Override // t4.d
        public void onActivityCreated(Activity r10, Bundle r11) {
            d.d(System.currentTimeMillis());
            if (r11 == null) goto L5;
            boolean r12 = true;
        L6:
            d.e(r12);
            d.c(true);
            return;
        L5:
            r12 = false;
            goto L6
        }

        @Override // t4.d
        public void onActivityPause(Activity r10) {
            d.f(r10.getComponentName().getClassName());
        }

        @Override // t4.d
        public void onActivityResume(Activity r10) {
        }

        @Override // t4.d
        public void onActivityStarted(Activity r10) {
            d.g(System.currentTimeMillis());
        }

        @Override // t4.d
        public void onBackground(Activity r10) {
            d.b(true);
            d.c(false);
            d.a("");
        }

        @Override // t4.d
        public void onChange(Activity r10, Fragment r11) {
        }

        @Override // t4.d
        public void onFront(Activity r10) {
            d.a(r10.getComponentName().getClassName());
        }
    }

    static {
    }

    static /* synthetic */ String a(String r10) {
        return r10;
    }

    static /* synthetic */ boolean b(boolean r10) {
        return r10;
    }

    static /* synthetic */ boolean c(boolean r10) {
        return r10;
    }

    static /* synthetic */ long d(long r10) {
        return r10;
    }

    static /* synthetic */ boolean e(boolean r10) {
        return r10;
    }

    static /* synthetic */ String f(String r10) {
        return r10;
    }

    static /* synthetic */ long g(long r10) {
        return r10;
    }

    public static void h() {
        f.c();
        ActivityLifeObserver.getInstance().register(new a());
    }
}
