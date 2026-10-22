package com.bytedance.android.live.lynx.ui;

import com.bytedance.bmmt.BuildConfig;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LiveLynxAlphaPlayer$$MethodInvoker implements com.lynx.tasm.behavior.utils.a<LiveLynxAlphaPlayer> {
    public LiveLynxAlphaPlayer$$MethodInvoker() {
    }

    public void invoke(LiveLynxAlphaPlayer r6, String r7, ReadableMap r8, Callback r9) {
        r7.getClass();
        byte r4 = -1;
        switch(r7.hashCode()) {
            case -1073342556: goto L66;
            case -934426579: goto L62;
            case -527962973: goto L58;
            case -407658560: goto L54;
            case -357431021: goto L50;
            case 3443508: goto L46;
            case 3540994: goto L42;
            case 47962023: goto L38;
            case 85887754: goto L34;
            case 106440182: goto L30;
            case 194959693: goto L26;
            case 692239790: goto L22;
            case 1090594823: goto L18;
            case 1419773105: goto L14;
            case 1848904985: goto L10;
            case 1908871954: goto L6;
            default: goto L69;
        };
    L69:
        switch(r4) {
            case 0: goto L86;
            case 1: goto L85;
            case 2: goto L84;
            case 3: goto L83;
            case 4: goto L82;
            case 5: goto L81;
            case 6: goto L80;
            case 7: goto L79;
            case 8: goto L78;
            case 9: goto L77;
            case 10: goto L76;
            case 11: goto L75;
            case 12: goto L74;
            case 13: goto L73;
            case 14: goto L72;
            case 15: goto L71;
            default: goto L70;
        };
    L70:
        r9.invoke(new Object[]{3});
        return;
    L71:
        r6.scrollIntoView(r8, r9);
        return;
    L72:
        r6.requestAccessibilityFocus(r8, r9);
        return;
    L73:
        r6.requestUIInfo(r8, r9);
        return;
    L74:
        r6.release(r8, r9);
        return;
    L75:
        r6.fetchAccessibilityTargets(r8, r9);
        return;
    L76:
        r6.takeScreenshot(r8, r9);
        return;
    L77:
        r6.pause(r8, r9);
        return;
    L78:
        r6.getDuration(r8, r9);
        return;
    L79:
        r6.subscribeUpdateEvent(r8, r9);
        return;
    L80:
        r6.stop(r8, r9);
        return;
    L81:
        r6.play(r8, r9);
        return;
    L82:
        r6.boundingClientRect(r8, r9);
        return;
    L83:
        r6.unsubscribeUpdateEvent(r8, r9);
        return;
    L84:
        r6.innerText(r8, r9);
        return;
    L85:
        r6.resume(r8, r9);
        return;
    L86:
        r6.isPlaying(r8, r9);
        return;
    L6:
        if (r7.equals("scrollIntoView") == false) goto L69;
        r4 = 15;
        goto L69
    L10:
        if (r7.equals("requestAccessibilityFocus") == false) goto L69;
        r4 = 14;
        goto L69
    L14:
        if (r7.equals("requestUIInfo") == false) goto L69;
        r4 = 13;
        goto L69
    L18:
        if (r7.equals(BuildConfig.BUILD_TYPE) == false) goto L69;
        r4 = 12;
        goto L69
    L22:
        if (r7.equals("fetchAccessibilityTargets") == false) goto L69;
        r4 = 11;
        goto L69
    L26:
        if (r7.equals("takeScreenshot") == false) goto L69;
        r4 = 10;
        goto L69
    L30:
        if (r7.equals("pause") == false) goto L69;
        r4 = 9;
        goto L69
    L34:
        if (r7.equals("getDuration") == false) goto L69;
        r4 = 8;
        goto L69
    L38:
        if (r7.equals("subscribeUpdateEvent") == false) goto L69;
        r4 = 7;
        goto L69
    L42:
        if (r7.equals("stop") == false) goto L69;
        r4 = 6;
        goto L69
    L46:
        if (r7.equals("play") == false) goto L69;
        r4 = 5;
        goto L69
    L50:
        if (r7.equals("boundingClientRect") == false) goto L69;
        r4 = 4;
        goto L69
    L54:
        if (r7.equals("unsubscribeUpdateEvent") == false) goto L69;
        r4 = 3;
        goto L69
    L58:
        if (r7.equals("innerText") == false) goto L69;
        r4 = 2;
        goto L69
    L62:
        if (r7.equals("resume") == false) goto L69;
        r4 = 1;
        goto L69
    L66:
        if (r7.equals("isPlaying") == false) goto L69;
        r4 = 0;
        goto L69
    }

    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r1, String r2, ReadableMap r3, Callback r4) {
        invoke((LiveLynxAlphaPlayer) r1, r2, r3, r4);
    }
}
