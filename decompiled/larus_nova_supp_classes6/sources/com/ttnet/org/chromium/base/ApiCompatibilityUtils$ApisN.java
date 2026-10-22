package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.os.UserManager;
import android.text.Html;
import android.text.Spanned;
import android.view.inputmethod.InputMethodSubtype;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class ApiCompatibilityUtils$ApisN {
    private ApiCompatibilityUtils$ApisN() {
    }

    public static boolean isDemoUser() {
        return ((UserManager) ContextUtils.getApplicationContext().getSystemService("user")).isDemoUser();
    }

    public static String getLocale(InputMethodSubtype r0) {
        return r0.getLanguageTag();
    }

    public static boolean isInMultiWindowMode(Activity r0) {
        return r0.isInMultiWindowMode();
    }

    public static String toHtml(Spanned r0, int r1) {
        return Html.toHtml(r0, r1);
    }
}
