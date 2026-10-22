package o0c;

import android.app.Activity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {

    /* JADX INFO: renamed from: o0c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0171a {
        void dismiss();

        void show();
    }

    boolean enablePurposeDialog();

    String getAppDisplayName();

    boolean isLarkPackage();

    InterfaceC0171a newPermissionPurposeWindow(Activity r1);
}
