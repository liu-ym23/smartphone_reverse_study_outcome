package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class NotificationCompat$BigTextStyle extends NotificationCompat$Style {
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$BigTextStyle";
    private CharSequence mBigText;

    @Override // androidx.core.app.NotificationCompat$Style
    public String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    public NotificationCompat$BigTextStyle() {
    }

    public NotificationCompat$BigTextStyle(NotificationCompat$Builder r1) {
        setBuilder(r1);
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public void addCompatExtras(Bundle r1) {
        super.addCompatExtras(r1);
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public void apply(NotificationBuilderWithBuilderAccessor r2) {
        Notification.BigTextStyle r3 = new Notification.BigTextStyle(r2.getBuilder()).setBigContentTitle(this.mBigContentTitle).bigText(this.mBigText);
        if (this.mSummaryTextSet == false) goto L6;
        r3.setSummaryText(this.mSummaryText);
        return;
    }

    public NotificationCompat$BigTextStyle bigText(CharSequence r1) {
        this.mBigText = NotificationCompat$Builder.limitCharSequenceLength(r1);
        return this;
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public void clearCompatExtraKeys(Bundle r2) {
        super.clearCompatExtraKeys(r2);
        r2.remove("android.bigText");
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public void restoreFromCompatExtras(Bundle r2) {
        super.restoreFromCompatExtras(r2);
        this.mBigText = r2.getCharSequence("android.bigText");
    }

    public NotificationCompat$BigTextStyle setBigContentTitle(CharSequence r1) {
        this.mBigContentTitle = NotificationCompat$Builder.limitCharSequenceLength(r1);
        return this;
    }

    public NotificationCompat$BigTextStyle setSummaryText(CharSequence r1) {
        this.mSummaryText = NotificationCompat$Builder.limitCharSequenceLength(r1);
        this.mSummaryTextSet = true;
        return this;
    }
}
