package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.param.IMConstants;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget.AudioLottieTrashButton;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.h;
import com.ss.android.lark.utils.l;
import com.ss.android.lark.utils.n;
import com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a extends PermissionPurposeWindowPermissionResult {
        public final /* synthetic */ Function1<Boolean, Unit> b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Boolean, Unit> r1) {
            this.b = r1;
        }

        @Override // com.suite.lark.platform.component.widget_biz_permissionpurposewindow.PermissionPurposeWindowPermissionResult
        public final void a(boolean r3) {
            Log.i("AudioPluginUtils", "requestAudioPermission / Audio permission status = " + r3);
            this.b.invoke(Boolean.valueOf(r3));
        }
    }

    static {
    }

    public c() {
    }

    public static int e() {
        return com.ss.android.lark.im.base.a.a().getInt("user_audio_send_tab", AudioPluginConstants.a);
    }

    public static boolean h() {
        if (KeyboardVoiceModule.a().getCurNetWorkLevel() != IMConstants.NetworkLevel.NET_UNAVAILABLE) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (ContextCompat.checkSelfPermission(r2, "android.permission.RECORD_AUDIO") != 0) goto L5;
        boolean r3 = true;
    L6:
        Log.i("AudioPluginUtils", "hasAudioPermission / " + r3);
        return r3;
    L5:
        r3 = false;
        goto L6
    }

    public static void a(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 4;
        goto L6
    }

    public static void b(boolean r3, View... r4) {
        Intrinsics.checkNotNullParameter(r4, "views");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        a(r4[r1], r3);
        r1 = r1 + 1;
        goto L3
    }

    public static int c(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return UIUtils.getColor(r1.getContext(), r2);
    }

    public static Drawable d(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return UIUtils.getDrawable(r1.getContext(), r2);
    }

    public static String f(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return UIUtils.getString(r1.getContext(), r2);
    }

    public static void j(Activity r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r12, "activity");
        Intrinsics.checkNotNullParameter(r13, "callback");
        Token r2 = new Token("LARK-PSDA-android_audio_input_request_permission");
        a r3 = new a(r13);
        int r14 = n.a;
        h.c(r12, r2, r3, "android.permission.RECORD_AUDIO", new l(2131890592, 2131890576, 2131890592, 2131890576, null, null, 240), false, 0, 0);
    }

    public static Pair l(CharSequence r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "charSequence");
        SpannableStringBuilder r0 = (SpannableStringBuilder) r3;
        int r1 = r0.length();
        if (r4 <= 0) goto L9;
        if (r4 < r1) goto L8;
        return new Pair(r3, "");
    L8:
        return new Pair(r0.subSequence(0, r4), r0.subSequence(r4, r1));
    L9:
        return new Pair("", r0.subSequence(r4, r1));
    }

    public static int m(View r1, Number r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "dp");
        return UIUtils.dp2px(r1.getContext(), r2.floatValue());
    }

    public static float n(View r1, Number r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "dp");
        return UIUtils.dp2px(r1.getContext(), r2.floatValue());
    }

    public static void p(View r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "doUpdate");
        ConstraintLayout.LayoutParams r0 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r1 = r0;
        r3.invoke(r1);
        r2.setLayoutParams(r1);
    }

    public static void k(EditText r2, CharSequence r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        if (r3 != null) goto L5;
        int r5 = 0;
    L25:
        r2.setText(r3);     // Catch: Exception -> L22
        r2.setSelection(r5);     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        Log.e("AudioPluginUtils", e.toString());
        return;
    L5:
        if (r4 != null) goto L7;
    L15:
        r5 = r2.getSelectionEnd();
        if (r5 >= 0) goto L18;
    L19:
        r5 = r3.length();
        goto L25
    L18:
        if (r5 <= r3.length()) goto L25;
    L7:
        if (r4.intValue() > r3.length()) goto L15;
        if (r4.intValue() < (-1)) goto L15;
        if (r4.intValue() != (-1)) goto L14;
        r5 = r3.length();
        goto L25
    L14:
        r5 = r4.intValue();
        goto L25
    }

    public static float o(Number r6, Number r7, Number r8) {
        Intrinsics.checkNotNullParameter(r6, "x");
        Intrinsics.checkNotNullParameter(r7, "maxValue");
        Intrinsics.checkNotNullParameter(r8, "minValue");
        float r9 = (float) (r7.doubleValue() / (Math.exp(-((r6.doubleValue() - ((double) 150)) / ((double) 60))) + 1.0d));
        float r10 = r8.floatValue();
        float r11 = r7.floatValue();
        float r0 = r11 / 5;
        if ((r9 / r11) < 0.9f) goto L6;
        r9 = r9 - (r0 * Random.Default.nextFloat());
    L6:
        return Math.max(r10, r9);
    }

    public static void i(AudioLottieTrashButton r1, int r2, int r3, float r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setSpeed(r4);
        r1.setMinAndMaxFrame(r2, r3);
        r1.playAnimation();
    }
}
