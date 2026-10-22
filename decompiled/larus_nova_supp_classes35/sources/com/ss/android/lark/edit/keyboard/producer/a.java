package com.ss.android.lark.edit.keyboard.producer;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import rcb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements OnApplyWindowInsetsListener {
    public final /* synthetic */ BaseKeyboardHeightProducer a;

    public a(BaseKeyboardHeightProducer r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r14, WindowInsetsCompat r15) {
        Intrinsics.checkNotNullParameter(r14, "<unused var>");
        Intrinsics.checkNotNullParameter(r15, "insets");
        BaseKeyboardHeightProducer r16 = this.a;
        boolean r1 = true;
        if (rcb.b.a(r16.a) == true) goto L41;
        Configuration r0 = f.a;
        if (f.a(r16.a) == false) goto L41;
        Object r7 = r16.a.getSystemService("input_method");     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L9
        InputMethodManager r8 = (InputMethodManager) r7;     // Catch: Exception -> L9
        Method r9 = r8.getClass().getDeclaredMethod("getInputMethodWindowVisibleHeight", new Class[0]);     // Catch: Exception -> L9
        r9.setAccessible(true);     // Catch: Exception -> L9
        Object r10 = r9.invoke(r8, new Object[0]);     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L9
        int r11 = ((Integer) r10).intValue();     // Catch: Exception -> L9
        Log.i("BaseBaseKBH#Producer", "getKeyboardHeightByInvoke height : " + r11);     // Catch: Exception -> L9
    L11:
        Log.i("BaseBaseKBH#Producer", "invokeImpl imeHeight=" + r11 + ';');
        if (r11 > 0) goto L14;
    L16:
        if (r11 > 0) goto L18;
        r11 = 0;
    L18:
        b r17 = (b) r16;
        if (((Boolean) r17.m.getValue()).booleanValue() == false) goto L28;
        if (r11 == 0) goto L22;
    L24:
        if (r11 == 0) goto L26;
        boolean r2 = true;
    L27:
        r17.l = r2;
        goto L28
    L26:
        r2 = false;
        goto L27
    L22:
        if (r17.l == true) goto L24;
        Log.i("InsetsKBH#Producer", "notifyFromInvoke not notify, reason: mIsNotifyNotZero = false");
    L73:
        return r15.consumeSystemWindowInsets();
    L28:
        Context r3 = r17.a.getBaseContext();
        int r5 = rcb.a.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        int r6 = rcb.a.a;
        if (r6 != (-1)) goto L36;
        Resources r4 = r3.getResources();
        if (r4.getIdentifier("config_showNavigationBar", "bool", "android") == 0) goto L35;
        int r12 = r4.getIdentifier("navigation_bar_height", "dimen", "android");
        if (r12 <= 0) goto L35;
        int r13 = r4.getDimensionPixelSize(r12);
        rcb.a.a = r13;
    L37:
        BaseKeyboardHeightProducer.b r18 = new BaseKeyboardHeightProducer.b(r11, r13, 0, true);
        if (r11 >= 300) goto L40;
        r18.d = false;
    L40:
        Log.i("InsetsKBH#Producer", "notifyFromInvoke keyboard = " + r18);
        r17.b(r18);
    L35:
        r6 = 0;
    L36:
        r13 = r6;
        goto L37
    L14:
        if (f.b() == false) goto L16;
        r11 = 1;
    L9:
        e = move-exception;
        Log.e("BaseBaseKBH#Producer", "getKeyboardHeightByInvoke height : -1; " + e.getMessage());
        r11 = -1;
    L41:
        Insets r19 = r15.getInsets(WindowInsetsCompat.Type.systemBars());
        Insets r20 = r15.getInsets(WindowInsetsCompat.Type.ime());
        Insets r21 = r15.getInsets(WindowInsetsCompat.Type.captionBar());
        Insets r22 = r15.getInsets(WindowInsetsCompat.Type.navigationBars());
        int r23 = r20.bottom;
        boolean r110 = r15.isVisible(WindowInsetsCompat.Type.ime());
        Log.i("BaseBaseKBH#Producer", "handleInsertsChanged  \n imeInset = " + r20 + " ; \n captionInset = " + r21 + " ; \n navInset = " + r22 + " ; \n systemBarInset = " + r19 + " \n imeHeight = " + r23 + " \n isKeyboardVisible = " + r110);
        Configuration r24 = f.a;
        BaseKeyboardHeightProducer.b r25 = new BaseKeyboardHeightProducer.b(r23, r22.bottom, r21.bottom, r110);
        if (rcb.b.a(r16.a) == false) goto L47;
        if (r110 == false) goto L47;
        if (r25.a != 0) goto L47;
        r25.a = 1;
    L47:
        b r111 = (b) r16;
        Intrinsics.checkNotNullParameter(r25, Keys.API_RETURN_KEY_DATA);
        Log.i("InsetsKBH#Producer", "notifyFromInsert keyboard = " + r25);
        if (r25.a == 0) goto L50;
    L52:
        Log.i("InsetsKBH#Producer", "configurationChanged: " + r111.i + "; mHandleChanged: " + r111.j);
        if (r111.i == true) goto L55;
    L63:
        r111.g = r25;
    L64:
        boolean r26 = true;
    L65:
        if (r26 == false) goto L73;
        r111.b(r25);
        if (r25.a != 0) goto L71;
        r1 = false;
    L71:
        r111.h = r1;
        goto L73
    L55:
        if (r111.j == true) goto L63;
        int r27 = r25.a;
        BaseKeyboardHeightProducer.b r28 = r111.g;
        if (r28 == null) goto L59;
        int r29 = r28.a;
    L60:
        if (r27 <= 300) goto L62;
        r111.i = false;
        goto L64
    L62:
        Log.i("InsetsKBH#Producer", "not notify, reason: newKeyboardHeight = " + r27 + "; lastNotifyKeyboardHeight = " + r29);
        r26 = false;
        goto L65
    L59:
        r29 = 0;
        goto L60
    L50:
        if (r111.h == true) goto L52;
        Log.i("InsetsKBH#Producer", "not notify, reason: mIsNotifyNot0 = false");
        goto L73
    }
}
