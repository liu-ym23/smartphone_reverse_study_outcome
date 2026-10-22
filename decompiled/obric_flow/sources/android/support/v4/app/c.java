package android.support.v4.app;

import android.app.Notification;
import android.os.IInterface;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public interface c extends IInterface {
    public static final String f1 = null;

    static {
        f1 = "android$support$v4$app$INotificationSideChannel".replace(Typography.dollar, '.');
    }

    void cancel(String r5, int r10, String r11);

    void cancelAll(String r5);

    void notify(String r5, int r10, String r11, Notification r12);
}
