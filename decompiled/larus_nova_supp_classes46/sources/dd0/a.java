package dd0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.utils.AvatarType;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.LinkMicRecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserVirtualAvatarViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.s0;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import com.bytedance.android.livesdk.link.model.bridge.Linkmic2DAvatar;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.LynxView;
import ih0.c;
import java.util.ArrayList;
import java.util.List;
import je0.d;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    public static String g(MultiLinkGuestViewBinder.a r1) {
        if ((r1 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) == false) goto L5;
    L6:
        Linkmic2DAvatar r2 = r1.k.a.getLinkmic2DAvatar();
        if (r2 == null) goto L9;
        Boolean r3 = r2.getEnableAvatar();
    L11:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L16;
        return "rectangle";
    L16:
        return "circle";
    L9:
        r3 = null;
        goto L11
    L5:
        if ((r1 instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L6;
        return "circle";
    }

    public static Pair h(MultiLinkGuestViewBinder.a r7) {
        IBaseUser r0 = r7.k.a.getUser();
        String r1 = "";
        if (r0 == null) goto L10;
        k r2 = d.n(r0, AvatarType.AVATAR_THUMB.getValue());
        if (r2 == null) goto L10;
        List r3 = r2.getUrls();
        if (r3 == null) goto L10;
        String r4 = (String) CollectionsKt.firstOrNull(r3);
        if (r4 == null) goto L10;
    L11:
        String r5 = "audio";
        if ((r7 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) == false) goto L14;
    L22:
        Linkmic2DAvatar r6 = r7.k.a.getLinkmic2DAvatar();
        if (r6 == null) goto L25;
        Boolean r8 = r6.getEnableAvatar();
    L27:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L36;
        k r9 = r6.getImage();
        if (r9 == null) goto L46;
        List r10 = r9.getUrls();
        if (r10 == null) goto L46;
        String r11 = (String) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L46;
        r1 = r11;
    L46:
        return TuplesKt.to(r1, r5);
    L36:
        int r12 = r7.f;
        if (r12 != 28) goto L42;
        boolean r13 = r.a;
        if (r.j(Integer.valueOf(r12), 0, 6) == false) goto L46;
    L42:
        if (r7.k.a.getMLinkType() != 2) goto L46;
    L44:
        r1 = r4;
        goto L46
    L25:
        r8 = null;
        goto L27
    L14:
        if ((r7 instanceof MultiLinkAudioFirstUserViewBinder.a) == true) goto L22;
        if (r7.k.a.getMLinkType() != 1) goto L20;
        r5 = "video";
        goto L44
    L20:
        if (r7.k.a.getMLinkType() != 2) goto L46;
    L10:
        r4 = "";
        goto L11
    }

    public static boolean i(View r4) {
        if (r4 == null) goto L5;
        int r1 = r4.getWidth();
    L6:
        if (r4 == null) goto L8;
        int r2 = r4.getHeight();
    L10:
        if (r1 <= 0) goto L15;
        if (r2 <= 0) goto L15;
        if (r4 == null) goto L15;
        if (r4.isShown() != true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r2 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L6
    }

    public static List c(c r38, List r39) {
        ArrayList r1 = new ArrayList();
        if (r38 == null) goto L56;
        if (r39 == null) goto L56;
        int r2 = r39.size();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L56;
        e r4 = (e) ListProtector.get(r39, r3);
        if (r4 == null) goto L14;
        if (r4.j == true) goto L14;
    L55:
        r3 = r3 + 1;
    L14:
        if ((r38.getHybridView() instanceof LynxView) == false) goto L55;
        LynxView r5 = r38.getHybridView();
        if (r5 == null) goto L54;
        View r6 = r5.findViewByName("micseat_container_" + r3);
        if (r6 == null) goto L20;
        float r7 = r6.getScaleX();
    L21:
        LynxView r8 = r38.getHybridView();
        if (r8 == null) goto L52;
        View r10 = r8.findViewByName("micseat_guest_avatar_" + r3);
        String r9 = null;
        if (i(r10) == false) goto L37;
        EPointF r11 = f(r6, r7);
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == false) goto L35;
        MultiLinkGuestViewBinder.a r12 = (MultiLinkGuestViewBinder.a) r4;
        Pair r13 = h(r12);
        ch0.e r14 = r12.k;
        if (r14 == null) goto L34;
        ILinkPlayerInfoBridge r15 = r14.a;
        if (r15 == null) goto L34;
        IBaseUser r16 = r15.getUser();
        if (r16 == null) goto L34;
        r9 = r16.getIdString();
    L34:
        bd0.c r23 = new bd0.c(r10, null, r9, true, ((PointF) r11).x, ((PointF) r11).y, (String) r13.getFirst(), false, g(r12), null, (String) r13.getSecond(), Integer.valueOf(r4.a), 640);
    L48:
        bd0.c r17 = r23;
        View r18 = r17.a;
        if (r18 == null) goto L55;
        r1.add(a(r17, r18, r38.S0(), true, r7));
        goto L55
    L35:
        bd0.c r19 = new bd0.c(null, null, null, false, 0.0f, 0.0f, null, false, null, null, null, null, 4088);
    L47:
        r23 = r19;
        goto L48
    L37:
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == false) goto L46;
        MultiLinkGuestViewBinder.a r20 = (MultiLinkGuestViewBinder.a) r4;
        Pair r21 = h(r20);
        ch0.e r22 = r20.k;
        if (r22 == null) goto L45;
        ILinkPlayerInfoBridge r24 = r22.a;
        if (r24 == null) goto L45;
        IBaseUser r25 = r24.getUser();
        if (r25 == null) goto L45;
        r9 = r25.getIdString();
    L45:
        r23 = new bd0.c(r10, null, r9, false, 0.0f, 0.0f, (String) r21.getFirst(), false, g(r20), null, (String) r21.getSecond(), Integer.valueOf(r4.a), 696);
        goto L48
    L46:
        r19 = new bd0.c(null, null, null, false, 0.0f, 0.0f, null, false, null, null, null, null, 4088);
        goto L47
    L52:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L20:
        r7 = 1.0f;
        goto L21
    L54:
        throw new NullPointerException("null cannot be cast to non-null type com.lynx.tasm.LynxView");
    L56:
        return r1;
    }

    public static EPointF f(View r3, float r4) {
        int[] r0 = new int[2];
        if (r3 == null) goto L6;
        r3.getLocationOnScreen(r0);
    L6:
        if (r3 == null) goto L8;
        int r2 = r3.getWidth();
    L9:
        float r5 = r2 * r4;
        if (r3 == null) goto L12;
        int r6 = r3.getHeight();
    L14:
        return new EPointF(r0[0] + (r5 / 2.0f), r0[1] + ((r6 * r4) / 2.0f));
    L12:
        r6 = 0;
        goto L14
    L8:
        r2 = 0;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List b(LinkMicRecyclerView r7, hg0.d r8, List r9) {
        ArrayList r0 = new ArrayList();
        if (r7 == 0) goto L20;
        if (r8 == null) goto L20;
        int r1 = r7.getChildCount();
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L20;
        if (r9 == null) goto L14;
        e r4 = (e) CollectionsKt.getOrNull(r9, r3);
        if (r4 == null) goto L14;
        if (r4.j == true) goto L14;
    L19:
        r3 = r3 + 1;
    L14:
        bd0.c r5 = r8.a(r3);
        if (r5 == null) goto L19;
        View r6 = r5.a;
        if (r6 == null) goto L19;
        r0.add(a(r5, r6, r7, false, 1.0f));
    L20:
        return r0;
    }

    public static s0 a(bd0.c r31, View r32, View r33, boolean r34, float r35) {
        if (r31.d == true) goto L5;
        View r1 = r31.b;
        String r3 = r31.c;
        String r4 = r31.g;
        if (r4 != null) goto L20;
        String r22 = "";
    L22:
        return d(r32, r1, r3, r22, r31.h, r33, r31.i, r31.j, r34, r35, r31.k, r31.l);
    L20:
        r22 = r4;
        goto L22
    L5:
        if (r32.getWidth() > 0) goto L7;
        int r2 = s1.f(56.0f);
    L8:
        int r7 = r2;
        if (r32.getHeight() > 0) goto L11;
        int r5 = s1.f(56.0f);
    L12:
        int r8 = r5;
        float r6 = r31.e;
        float r9 = r31.f;
        float r11 = r32.getAlpha();
        View r12 = r31.b;
        String r13 = r31.c;
        String r10 = r31.g;
        if (r10 != null) goto L15;
        String r14 = "";
    L23:
        return new s0(r6, r9, r7, r8, null, r32, r11, r12, r13, r14, Boolean.valueOf(r31.h), r31.i, r31.j, r31.k, r31.l);
    L15:
        r14 = r10;
        goto L23
    L11:
        r5 = r32.getHeight();
        goto L12
    L7:
        r2 = r32.getWidth();
        goto L8
    }

    public static /* synthetic */ s0 e(View r15, View r16, String r17, String r18, boolean r19, RecyclerView r20, String r21, Integer r22, int r23) {
        Integer r2 = null;
        if ((r23 & 2) == 0) goto L5;
        View r4 = null;
    L7:
        if ((r23 & 4) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r23 & 8) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r23 & 16) == 0) goto L17;
        boolean r1 = false;
    L19:
        if ((r23 & 32) == 0) goto L21;
        RecyclerView r8 = null;
    L23:
        if ((r23 & 64) == 0) goto L25;
        String r9 = "circle";
    L27:
        if ((r23 & 128) == 0) goto L29;
        Integer r10 = 0;
    L31:
        if ((r23 & 512) == 0) goto L33;
        float r12 = 1.0f;
    L35:
        if ((r23 & 1024) == 0) goto L37;
        String r13 = "";
    L39:
        if ((r23 & 2048) == 0) goto L42;
        r2 = -1;
    L42:
        return d(r15, r4, r5, r6, r1, r8, r9, r10, false, r12, r13, r2);
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = 0.0f;
        goto L35
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r21;
        goto L27
    L21:
        r8 = r20;
        goto L23
    L17:
        r1 = r19;
        goto L19
    L13:
        r6 = r18;
        goto L15
    L9:
        r5 = r17;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public static s0 d(View r17, View r18, String r19, String r20, boolean r21, View r22, String r23, Integer r24, boolean r25, float r26, String r27, Integer r28) {
        Intrinsics.checkNotNullParameter(r17, "head");
        Intrinsics.checkNotNullParameter(r20, "url");
        Intrinsics.checkNotNullParameter(r27, "linkType");
        Object r1 = null;
        if (r25 == false) goto L5;
        Float r3 = Float.valueOf(r26);
    L9:
        int[] r4 = new int[2];
        r17.getLocationOnScreen(r4);
        int r5 = 0;
        int r7 = r4[0];
        int r9 = r4[1];
        if (r22 == null) goto L12;
        r22.getLocationOnScreen(r4);
    L12:
        if (r22 == null) goto L14;
        r5 = r4[0];
    L14:
        float r0 = r17.getWidth();
        float r6 = 1.0f;
        if (r3 == null) goto L17;
        float r11 = r3.floatValue();
    L18:
        float r2 = r0 * r11;
        float r12 = r17.getHeight();
        if (r3 == null) goto L21;
        float r8 = r3.floatValue();
    L22:
        float r13 = r12 * r8;
        float r10 = (r7 + (r2 / 2.0f)) - r5;
        float r14 = (r13 / 2.0f) + r9;
        if (r17.getWidth() > 0) goto L25;
    L54:
        Bitmap r15 = null;
    L55:
        int r16 = (int) r13;
        return new s0(r10, r14, r16, r16, r15, r17, r17.getAlpha(), r18, r19, r20, Boolean.valueOf(r21), r23, r24, r27, r28);
    L25:
        if (r17.getHeight() <= 0) goto L54;
        float r29 = r17.getAlpha();
        Object r30 = r17.getTag(2131374076);
        if ((r30 instanceof Float) == false) goto L31;
        r1 = r30;
    L31:
        Float r31 = (Float) r1;
        float r32 = r17.getWidth();
        if (r31 == null) goto L34;
        float r33 = r31.floatValue();
    L35:
        float r34 = r32 * r33;
        float r35 = r17.getHeight();
        if (r31 == null) goto L38;
        float r36 = r31.floatValue();
    L39:
        int r37 = (int) r34;
        int r38 = (int) (r35 * r36);
        r15 = Bitmap.createBitmap(r37, r38, Bitmap.Config.ARGB_4444);
        Canvas r110 = new Canvas(r15);
        if (r29 >= 1) goto L48;
        Bitmap r39 = Bitmap.createBitmap(r37, r38, Bitmap.Config.ARGB_4444);
        Canvas r40 = new Canvas(r39);
        if (r31 == null) goto L44;
        float r41 = r31.floatValue();
    L45:
        if (r31 == null) goto L47;
        r6 = r31.floatValue();
    L47:
        r40.scale(r41, r6);
        r17.draw(r40);
        Paint r42 = new Paint();
        r42.setAlpha((int) (r29 * 255));
        r42.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
        r110.drawBitmap(r39, 0.0f, 0.0f, r42);
        goto L55
    L44:
        r41 = 1.0f;
        goto L45
    L48:
        if (r31 == null) goto L50;
        float r43 = r31.floatValue();
    L51:
        if (r31 == null) goto L53;
        r6 = r31.floatValue();
    L53:
        r110.scale(r43, r6);
        r17.draw(r110);
        goto L55
    L50:
        r43 = 1.0f;
        goto L51
    L38:
        r36 = 1.0f;
        goto L39
    L34:
        r33 = 1.0f;
        goto L35
    L21:
        r8 = 1.0f;
        goto L22
    L17:
        r11 = 1.0f;
        goto L18
    L5:
        Object r44 = r17.getTag(2131374076);
        if ((r44 instanceof Float) == true) goto L8;
        r44 = null;
    L8:
        r3 = (Float) r44;
        goto L9
    }
}
