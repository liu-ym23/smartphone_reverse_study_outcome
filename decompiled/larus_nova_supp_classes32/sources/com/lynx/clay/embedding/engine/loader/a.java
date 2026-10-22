package com.lynx.clay.embedding.engine.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.lynx.tasm.event.LynxTouchEvent;
import java.io.IOException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final String a = null;

    static {
        a = FlutterLoader.class.getName().concat(".flutter-assets-dir");
    }

    public static b a(Context r9) {
        ApplicationInfo r0 = r9.getPackageManager().getApplicationInfo(r9.getPackageName(), LynxTouchEvent.kPseudoStateFocusTransition);     // Catch: PackageManager.NameNotFoundException -> L34
        if (Build.VERSION.SDK_INT < 23) goto L6;
        NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    L6:
        Bundle r2 = r0.metaData;
        String r3 = a;
        String r4 = null;
        if (r2 != null) goto L9;
        String r5 = null;
    L10:
        Bundle r6 = r0.metaData;
        if (r6 == null) goto L28;
        int r7 = r6.getInt("com.lynx.clay.network-policy", 0);
        if (r7 <= 0) goto L28;
        JSONArray r8 = new JSONArray();
        XmlResourceParser r10 = r9.getResources().getXml(r7);     // Catch: Throwable -> L27
        r10.next();     // Catch: Throwable -> L27
        int r11 = r10.getEventType();     // Catch: Throwable -> L27
    L18:
        if (r11 == 1) goto L26;
        if (r11 != 2) goto L24;
        if (r10.getName().equals("domain-config") == false) goto L24;
        b(r10, r8, false);     // Catch: Throwable -> L27
    L24:
        r11 = r10.next();     // Catch: Throwable -> L27
        goto L18
    L26:
        r4 = r8.toString();
    L28:
        String r12 = r0.nativeLibraryDir;
        Bundle r1 = r0.metaData;
        if (r1 == null) goto L33;
        r1.getBoolean("com.lynx.clay.automatically-register-plugins", true);
    L33:
        return new b(r5, r4, r12);
    L9:
        r5 = r2.getString(r3, null);
    L34:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void b(XmlResourceParser r5, JSONArray r6, boolean r7) throws IOException, XmlPullParserException {
        boolean r8 = r5.getAttributeBooleanValue(null, "cleartextTrafficPermitted", r7);
    L3:
        int r1 = r5.next();
        if (r1 == 2) goto L6;
        if (r1 != 3) goto L3;
        return;
    L6:
        if (r5.getName().equals("domain") == true) goto L7;
        if (r5.getName().equals("domain-config") == true) goto L18;
        String r2 = r5.getName();
        int r3 = r5.getEventType();
    L20:
        if (r3 != 3) goto L23;
        if (r5.getName() == r2) goto L3;
    L23:
        r3 = r5.next();
        goto L20
    L18:
        b(r5, r6, r8);
        goto L3
    L7:
        boolean r4 = r5.getAttributeBooleanValue(null, "includeSubdomains", false);
        r5.next();
        if (r5.getEventType() != 4) goto L15;
        String r9 = r5.getText().trim();
        JSONArray r10 = new JSONArray();
        r10.put(r9);
        r10.put(r4);
        r10.put(r8);
        r6.put(r10);
        r5.next();
        if (r5.getEventType() == 3) goto L3;
        throw new IllegalStateException("Expected end of domain tag");
    L15:
        throw new IllegalStateException("Expected text");
    }
}
