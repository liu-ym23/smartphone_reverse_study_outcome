package com.ttnet.org.chromium.base;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ApiCompatibilityUtils$ApisO {
    private ApiCompatibilityUtils$ApisO() {
    }

    public static Bundle createLaunchDisplayIdActivityOptions(int r1) {
        ActivityOptions r0 = ActivityOptions.makeBasic();
        r0.setLaunchDisplayId(r1);
        return r0.toBundle();
    }

    public static void disableSmartSelectionTextClassifier(TextView r1) {
        r1.setTextClassifier(TextClassifier.NO_OP);
    }

    public static void initNotificationSettingsIntent(Intent r1, String r2) {
        r1.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        r1.putExtra("android.provider.extra.APP_PACKAGE", r2);
    }
}
