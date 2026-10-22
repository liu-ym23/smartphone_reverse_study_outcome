package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.drawable.RoundedDrawable;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MsgBubbleUtil {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/utils/MsgBubbleUtil$GroupMode;", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GroupMode {
        public static final int ALONE = 0;
        public static final int BOTTOM = 3;
        public static final a Companion = null;
        public static final int MIDDLE = 2;
        public static final int NONE = 4;
        public static final int TOP = 1;
        public static final int UNKNOWN = -1;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    static {
    }

    public static int b(View r1, View r2) {
        if (r1 != r2) goto L5;
        return 0;
    L5:
        if (r2 != null) goto L7;
        return 0;
    L7:
        if (r1 != null) goto L10;
        return 0;
    L10:
        return ((int) r1.getY()) + b((View) r1.getParent(), r2);
    }

    public static RoundedDrawable a(View r29, @BubbleStyle.ColorType int r30, boolean r31, @GroupMode int r32, int[] r33, boolean r34) {
        if (r32 != (-1)) goto L6;
        return null;
    L6:
        if (r32 != 0) goto L8;
        if (r31 == false) goto L52;
        int r1 = UIHelper.dp2px(10.0f);
    L53:
        if (r31 == false) goto L55;
        int r10 = 0;
    L56:
        if (r31 == false) goto L58;
        int r11 = UIHelper.dp2px(10.0f);
    L59:
        if (r31 == false) goto L61;
    L60:
        int r9 = 0;
    L62:
        float[] r7 = {0.0f, 0.0f, 0.0f, 0.0f};
        if (r34 == true) goto L65;
        r7[0] = r1;
        r7[1] = r10;
        r7[2] = r11;
        r7[3] = r9;
    L66:
        if (r33 != null) goto L68;
        if (r31 == false) goto L71;
        int r28 = 2;
    L72:
        Context r2 = r29.getContext();
        if (r30 == 0) goto L105;
        if (r30 != 1) goto L76;
        int r0 = p3b.a.b(false);
    L106:
        int r17 = r0;
        int r3 = -1;
    L107:
        int r25 = UIHelper.dp2px(1.0f);
        if (r3 == (-1)) goto L111;
        return new RoundedDrawable(r7[0], r7[1], r7[2], r7[3], r3, r25, r17, r17, r28);
    L111:
        return new RoundedDrawable(r7[0], r7[1], r7[2], r7[3], 0, 0, r17, r17, 0);
    L76:
        if (r30 != 2) goto L78;
        int r4 = UIUtils.getColor(r2, 2131100548);
        r3 = UIUtils.getColor(r2, 2131103352);
    L103:
        r17 = r4;
        goto L107
    L78:
        if (r30 != 7) goto L80;
        r4 = p3b.a.b(false);
        r3 = UIUtils.getColor(r2, 2131103351);
        goto L103
    L80:
        if (r30 != 8) goto L82;
        r4 = p3b.a.b(true);
        r3 = UIUtils.getColor(r2, 2131103351);
        goto L103
    L82:
        if (r30 != 10) goto L84;
        r4 = UIUtils.getColor(r2, 2131106521);
        r3 = UIUtils.getColor(r2, 2131100796);
        goto L103
    L84:
        if (r30 != 12) goto L86;
        r4 = UIUtils.getColor(r2, 2131100557);
        r3 = UIUtils.getColor(r2, 2131102450);
        goto L103
    L86:
        if (r30 == 15) goto L97;
        switch(r30) {
            case 17: goto L93;
            case 18: goto L92;
            case 19: goto L91;
            default: goto L89;
        };
    L91:
        r4 = UIUtils.getColor(r2, 2131100557);
        r3 = UIUtils.getColor(r2, 2131103351);
        goto L103
    L92:
        r4 = UIUtils.getColor(r2, 2131109051);
        r3 = UIUtils.getColor(r2, 2131103351);
        goto L103
    L93:
        r4 = UIUtils.getColor(r2, 2131100548);
        r3 = UIUtils.getColor(r2, 2131103351);
        goto L103
    L89:
        switch(r30) {
            case 113: goto L96;
            case 114: goto L95;
            case 115: goto L94;
            default: goto L90;
        };
    L90:
        return null;
    L94:
        r4 = UIUtils.getColor(r2, 2131100557);
        r3 = UIUtils.getColor(r2, 2131109340);
        goto L103
    L95:
        r4 = UIUtils.getColor(r2, 2131100557);
        r3 = UIUtils.getColor(r2, 2131109341);
        goto L103
    L96:
        r4 = UIUtils.getColor(r2, 2131100557);
        r3 = UIUtils.getColor(r2, 2131109341);
        goto L103
    L97:
        r4 = UIUtils.getColor(r2, 2131109051);
        r3 = UIUtils.getColor(r2, 2131102450);
        goto L103
    L105:
        r0 = p3b.a.b(true);
        goto L106
    L71:
        r28 = 1;
        goto L72
    L68:
        return new RoundedDrawable(r7[0], r7[1], r7[2], r7[3], 0, 0, r33[0], r33[1], 0);
    L65:
        r7[0] = r11;
        r7[1] = r9;
        r7[2] = r1;
        r7[3] = r10;
        goto L66
    L61:
        r9 = UIHelper.dp2px(10.0f);
        goto L62
    L58:
        r11 = 0;
        goto L59
    L55:
        r10 = UIHelper.dp2px(10.0f);
        goto L56
    L52:
        r1 = 0;
        goto L53
    L8:
        if (r32 == 1) goto L38;
        if (r32 == 2) goto L26;
        if (r32 == 3) goto L14;
        if (r32 == 4) goto L13;
        return null;
    L13:
        r1 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 0;
        goto L62
    L14:
        if (r31 == false) goto L16;
        r1 = UIHelper.dp2px(2.0f);
    L17:
        if (r31 == false) goto L19;
        r10 = 0;
    L20:
        if (r31 == false) goto L22;
        r11 = UIHelper.dp2px(10.0f);
    L23:
        if (r31 == true) goto L60;
        r9 = UIHelper.dp2px(10.0f);
        goto L62
    L22:
        r11 = 0;
        goto L23
    L19:
        r10 = UIHelper.dp2px(10.0f);
        goto L20
    L16:
        r1 = 0;
        goto L17
    L26:
        if (r31 == false) goto L28;
        r1 = UIHelper.dp2px(2.0f);
    L29:
        if (r31 == false) goto L31;
        r10 = 0;
    L32:
        if (r31 == false) goto L34;
        r11 = UIHelper.dp2px(10.0f);
    L35:
        if (r31 == true) goto L60;
        r9 = UIHelper.dp2px(10.0f);
        goto L62
    L34:
        r11 = 0;
        goto L35
    L31:
        r10 = UIHelper.dp2px(2.0f);
        goto L32
    L28:
        r1 = 0;
        goto L29
    L38:
        if (r31 == false) goto L40;
        r1 = UIHelper.dp2px(10.0f);
    L41:
        if (r31 == false) goto L43;
        r10 = 0;
    L44:
        if (r31 == false) goto L46;
        r11 = UIHelper.dp2px(10.0f);
    L47:
        if (r31 == true) goto L60;
        r9 = UIHelper.dp2px(10.0f);
        goto L62
    L46:
        r11 = 0;
        goto L47
    L43:
        r10 = UIHelper.dp2px(2.0f);
        goto L44
    L40:
        r1 = 0;
        goto L41
    }

    @JvmStatic
    public static final void c(View r19, @BubbleStyle.ColorType int r20, View r21, @GroupMode int r22, int[] r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r19, "view");
        if (r20 != 3) goto L5;
        Drawable r11 = a(r19, 8, true, r22, null, r24);
        RoundedDrawable r0 = a(r19, 2, false, r22, null, r24);
    L59:
        r19.setBackground(new com.ss.android.lark.chat.drawable.a(r11, r0, new s0(r21, r19)));
        return;
    L5:
        if (r20 != 4) goto L7;
        r11 = a(r19, 7, true, r22, null, r24);
        r0 = a(r19, 2, false, r22, null, r24);
        goto L59
    L7:
        if (r20 != 6) goto L9;
        r11 = a(r19, r20, true, r22, r23, r24);
        r0 = a(r19, 2, false, r22, null, r24);
        goto L59
    L9:
        if (r20 != 11) goto L11;
        r11 = a(r19, r20, true, r22, r23, r24);
        r0 = a(r19, 10, false, r22, null, r24);
        goto L59
    L11:
        if (r20 != 13) goto L13;
        r11 = a(r19, r20, true, r22, r23, r24);
        r0 = a(r19, 12, false, r22, null, r24);
        goto L59
    L13:
        if (r20 == 14) goto L53;
        switch(r20) {
            case 100: goto L19;
            case 101: goto L19;
            case 102: goto L19;
            case 103: goto L19;
            case 104: goto L19;
            case 105: goto L19;
            case 106: goto L19;
            case 107: goto L19;
            case 108: goto L19;
            case 109: goto L19;
            case 110: goto L19;
            case 111: goto L19;
            case 112: goto L19;
            default: goto L15;
        };
    L15:
        r11 = a(r19, r20, true, r22, null, r24);
        if (r20 != 0) goto L52;
        if (r21 == null) goto L52;
        r0 = a(r19, 2, false, r22, null, r24);
    L52:
        r0 = a(r19, r20, false, r22, null, r24);
        goto L59
    L19:
        Context r3 = r19.getContext();
        Drawable r4 = new hz7.a();
        switch(r20) {
            case 101: goto L33;
            case 102: goto L32;
            case 103: goto L31;
            case 104: goto L30;
            case 105: goto L29;
            case 106: goto L28;
            case 107: goto L27;
            case 108: goto L26;
            case 109: goto L25;
            case 110: goto L24;
            case 111: goto L23;
            case 112: goto L22;
            default: goto L34;
        };
    L22:
        int r5 = 2131109050;
    L35:
        r4.setColor(UDColorUtils.getColor(r3, r5));
        if (r20 != 100) goto L38;
        int r6 = 2131109054;
    L39:
        r4.b(UDColorUtils.getColor(r3, r6));
        ((hz7.a) r4).f = DeviceUtils.getScreenDensity(r3);
        float r7 = h18.d.a(r3, 10.0f);
        float r8 = h18.d.a(r3, 2.0f);
        if (r22 == 2) goto L43;
        if (r22 == 3) goto L43;
    L44:
        float r12 = r7;
    L46:
        if (r22 == 2) goto L49;
        if (r22 == 3) goto L49;
    L51:
        GradientDrawable r13 = new GradientDrawable();
        r13.setStroke(UIHelper.dp2px(1.0f), UDColorUtils.getColor(r3, 2131102450));
        r13.setCornerRadii(new float[]{r12, r12, r7, r7, 0.0f, 0.0f, 0.0f, 0.0f});
        r11 = new LayerDrawable(new Drawable[]{r4, new InsetDrawable(r13, 0, 0, 0, -2)});
        r0 = a(r19, 12, false, r22, null, r24);
    L49:
        if (r24 == false) goto L51;
        r7 = r8;
    L43:
        if (r24 == true) goto L44;
        r12 = r8;
        goto L46
    L38:
        r6 = 2131109053;
        goto L39
    L23:
        r5 = 2131109057;
        goto L35
    L24:
        r5 = 2131109060;
        goto L35
    L25:
        r5 = 2131109048;
        goto L35
    L26:
        r5 = 2131109058;
        goto L35
    L27:
        r5 = 2131109056;
        goto L35
    L28:
        r5 = 2131109062;
        goto L35
    L29:
        r5 = 2131109052;
        goto L35
    L30:
        r5 = 2131109049;
        goto L35
    L31:
        r5 = 2131109059;
        goto L35
    L32:
        r5 = 2131109061;
        goto L35
    L33:
        r5 = 2131109047;
        goto L35
    L34:
        r5 = 2131109055;
        goto L35
    L53:
        r11 = a(r19, 15, true, r22, null, r24);
        r0 = a(r19, 12, false, r22, null, r24);
        goto L59
    }
}
