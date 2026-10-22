package com.bytedance.android.livesdk.interactivity.service.textrender.utils;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.h5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.PublicAreaBadgeInfo;
import com.bytedance.android.live.base.model.user.h0;
import com.bytedance.android.live.base.model.user.r;
import com.bytedance.android.live.base.model.user.s;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class UserDslBadgeUtils {
    public static final /* synthetic */ int a = 0;

    public interface a {
        void a(ak6.g r1, boolean r2);
    }

    public UserDslBadgeUtils() {
    }

    public static long c() {
        IMiddleWareHostContext r0 = k.f(IMiddleWareHostContext.class);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.appId();
    }

    public static long d() {
        IMiddleWareHostContext r0 = k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L9;
        String r1 = r0.getVersionCode();
        if (r1 == null) goto L9;
        Long r2 = StringsKt.toLongOrNull(r1);
        if (r2 == null) goto L9;
        return r2.longValue();
    L9:
        return 0;
    }

    static {
    }

    public static final String a(List r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return "[" + TextUtils.join(",", r2) + ']';
    }

    @JvmStatic
    public static final List<tb2.c> b(List<h0> r9) {
        Intrinsics.checkNotNullParameter(r9, "badgeList");
        ArrayList r0 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L38;
        h0 r1 = (h0) r10.next();
        py.k r2 = r1.b;
        py.k.b.a r3 = py.k.b.Companion;
        py.k.b r4 = r2.getImageContent();
        r3.getClass();
        if (py.k.b.a.a(r4) == false) goto L36;
        tb2.c r5 = d.d(r2);
        ITextPieceImage r6 = r5.getImageValue();
        if (r6 == null) goto L12;
        py.k r7 = r6.getImageModel();
        if (r7 == null) goto L12;
        r7.setIsResizableImg(true);
    L12:
        h5 r8 = r5.getImageValue();
        if (r8 == null) goto L35;
        r8.setTextType(5);
        h5 r11 = r5.getImageValue();
        if (r11 == null) goto L33;
        h5 r13 = r11;
        py.k.b r14 = r2.getImageContent();
        String r15 = null;
        if (r14 == null) goto L19;
        String r16 = r14.getName();
    L20:
        r13.setTextContent(r16);
        h5 r17 = r5.getImageValue();
        if (r17 == null) goto L31;
        h5 r18 = r17;
        py.k.b r19 = r2.getImageContent();
        if (r19 == null) goto L25;
        r15 = r19.getFontColor();
    L25:
        r18.setTextColor(d.f(String.valueOf(r15)));
        h5 r20 = r5.getImageValue();
        if (r20 == null) goto L29;
        r20.setTextSizeRate(0.55f);
    L37:
        r5.setBadgePiece(true);
        r5.setBadge(r1);
        r0.add(r5);
        goto L4
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L19:
        r16 = null;
        goto L20
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L35:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.message.ITextPieceTextImage");
    L36:
        r5 = d.c(r2);
        goto L37
    L38:
        return r0;
    }

    @JvmStatic
    public static final List<h0> e(IBaseUser r1) {
        if (r1 == null) goto L8;
        com.bytedance.android.livesdk.interactivity.service.model.d r2 = (com.bytedance.android.livesdk.interactivity.service.model.d) r1.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.d.class);
        if (r2 == null) goto L8;
        return f(r2.getPublicAreaBadgeInfo());
    L8:
        return CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final List f(final PublicAreaBadgeInfo r9) {
        if (r9 != null) goto L6;
        return CollectionsKt.emptyList();
    L6:
        if (r9.getPublicAreaBadgeList() != null) goto L60;
        i(UserDslBadgeUtils$processDsl$1.INSTANCE);
        List r0 = r9.dslBadgeList();
        if (r0 != null) goto L11;
    L14:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L18;
        i(new UserDslBadgeUtils$processDsl$badgeListKey$1(r9));
        final List r2 = r9.badgeList();
    L48:
        ArrayList r3 = new ArrayList();
        if (r2 == null) goto L59;
        Iterator r4 = r2.iterator();
    L52:
        if (r4.hasNext() == false) goto L59;
        long r5 = ((Number) r4.next()).longValue();
        Map r6 = r9.badgeInfoMap();
        if (r6 == null) goto L56;
        py.k r7 = (py.k) r6.get(Long.valueOf(r5));
    L57:
        if (r7 == null) goto L52;
        r3.add(new h0(r5, r7));
        goto L52
    L56:
        r7 = null;
    L59:
        r9.setPublicAreaBadgeList(r3);
        goto L60
    L18:
        List r8 = r9.dslBadgeList();
        if (r8 == null) goto L39;
        Iterator r10 = r8.iterator();
    L22:
        if (r10.hasNext() == false) goto L37;
        Object r11 = r10.next();
        r r13 = (r) r11;
        s r14 = r13.targetDslRule();
        s r15 = r13.filterDslRule();
        if (r14 == null) goto L26;
        final boolean r16 = h("target", r14);
    L27:
        if (r15 == null) goto L29;
        final boolean r17 = h("filter", r15);
    L30:
        if (r16 == false) goto L33;
        if (r17 == true) goto L33;
        final boolean r18 = true;
    L34:
        i(new UserDslBadgeUtils$processDsl$badgeListKey$matchDslBadgeList$1$1(r18, r16, r17));
        if (r18 == false) goto L22;
    L38:
        r r19 = (r) r11;
    L40:
        if (r19 == null) goto L42;
        r2 = r19.badgeList();
    L43:
        if (r2 == null) goto L45;
        i(new UserDslBadgeUtils$processDsl$badgeListKey$2(r2));
    L46:
        if (r2 != null) goto L48;
        r2 = r9.badgeList();
        goto L48
    L45:
        i(new UserDslBadgeUtils$processDsl$badgeListKey$3(r9));
        goto L46
    L42:
        r2 = null;
    L33:
        r18 = false;
        goto L34
    L29:
        r17 = false;
        goto L30
    L26:
        r16 = true;
        goto L27
    L37:
        r11 = null;
        goto L38
    L39:
        r19 = null;
        goto L40
    L11:
        if (r0.isEmpty() == true) goto L14;
        r1 = false;
    L60:
        List r20 = r9.getPublicAreaBadgeList();
        if (r20 == null) goto L63;
        return r20;
    L63:
        return CollectionsKt.emptyList();
    }

    public static String g(String r1) {
        Object r2 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.toString();
    }

    public static void i(Function0 r3) {
        LocalTestManager.a(new Class[]{wy.a.class});
        if (v.a() == false) goto L10;
        if (r3 == null) goto L11;
        String r4 = (String) r3.invoke();
        if (r4 == null) goto L12;
        ALogger.i("UserDslBadge", r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public static boolean h(final String r11, s r13) {
        final List r0 = r13.appId();
        List r1 = r0;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L18;
        i(new UserDslBadgeUtils$matchDslRule$1(r11, r0));
        return false;
    L18:
        final List r4 = r13.versionCode();
        if (r4 != null) goto L21;
    L32:
        boolean r5 = true;
    L33:
        if (r5 == true) goto L36;
        i(new UserDslBadgeUtils$matchDslRule$2(r11, r4));
        return false;
    L36:
        final Map r14 = r13.abParams();
        if (r14 != null) goto L39;
    L42:
        boolean r6 = true;
    L43:
        if (r6 == false) goto L45;
    L53:
        boolean r7 = true;
    L54:
        if (r7 == true) goto L57;
        i(new UserDslBadgeUtils$matchDslRule$4(r11, r14));
        return false;
    L57:
        i(new UserDslBadgeUtils$matchDslRule$5(r11, r0, r4, r14));
        return true;
    L45:
        if (r14.isEmpty() == true) goto L53;
        Iterator r8 = r14.entrySet().iterator();
    L49:
        if (r8.hasNext() == false) goto L53;
        Map.Entry r9 = (Map.Entry) r8.next();
        if (Intrinsics.areEqual((String) r9.getValue(), g((String) r9.getKey())) == true) goto L49;
        r7 = false;
        goto L54
    L39:
        if (r14.isEmpty() == true) goto L42;
        r6 = false;
        goto L43
    L21:
        if (r4.size() != 2) goto L32;
        long r10 = ((Number) ListProtector.get(r4, 0)).longValue();
        long r15 = ((Number) ListProtector.get(r4, 1)).longValue();
        if (r15 != 0) goto L25;
        r15 = Long.MAX_VALUE;
    L25:
        long r16 = d();
        if (r10 <= r16) goto L29;
    L31:
        r5 = false;
        goto L33
    L29:
        if (r15 < r16) goto L31;
    L11:
        if (r0.contains(Long.valueOf(c())) == true) goto L14;
        r3 = false;
        goto L15
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }
}
