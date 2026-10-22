package fj0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rj0.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
        new SimpleDateFormat("yyyy-MM-dd");
    }

    @JvmStatic
    public static final String b() {
        StringBuilder r0 = new StringBuilder();
        if (((Number) com.bytedance.android.livesdk.sharedpref.c.r.getValue()).intValue() != 2) goto L5;
        String r1 = s1.B(2131917520);
    L6:
        r0.append(r1);
        r0.append("，");
        if (((String) com.bytedance.android.livesdk.sharedpref.c.s.getValue()).length() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        String r3 = s1.B(2131917522);
    L13:
        r0.append(r3);
        return r0.toString();
    L12:
        r3 = s1.B(2131917521);
        goto L13
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = s1.B(2131917518);
        goto L6
    }

    @JvmStatic
    public static final String c() {
        StringBuilder r0 = new StringBuilder();
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r0.append(com.bytedance.android.live.liveinteract.api.data.a.C0017a.d() + r3.b());
        r0.append(" ");
        int r1 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.c();
        if (r1 >= 120) goto L5;
        String r2 = r1 + "秒";
    L6:
        r0.append(r2);
        return r0.toString();
    L5:
        r2 = (r1 / 60) + "分钟";
        goto L6
    }

    @JvmStatic
    public static final boolean e() {
        return ((Boolean) vm2.d.d7.getValue(null, vm2.d.a[416(0x1a0, float:5.83E-43)])).booleanValue();
    }

    @JvmStatic
    public static final boolean f() {
        cj0.c r0 = PaidLinkMicContext.Companion.a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isIncreasePriceOn() != true) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean h() {
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (c.a() == false) goto L5;
        return true;
    L5:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == false) goto L8;
        boolean r0 = ((Boolean) com.bytedance.android.livesdk.sharedpref.d.K.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[35])).booleanValue();
    L11:
        if (r0 == true) goto L16;
        return false;
    L16:
        return true;
    L8:
        if (((Number) com.bytedance.android.livesdk.sharedpref.d.F.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[30])).intValue() == (-1)) goto L10;
        r0 = true;
        goto L11
    L10:
        r0 = false;
        goto L11
    }

    @JvmStatic
    public static final boolean i() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getInteractAudienceService() == null) goto L7;
        return com.bytedance.android.live.liveinteract.api.data.a.a().c;
    }

    @JvmStatic
    public static final boolean k() {
        PaidLinkMicContext.a r0 = PaidLinkMicContext.Companion;
        if (r0 == null) goto L9;
        cj0.c r1 = r0.a();
        if (r1 == null) goto L9;
        if (r1.isPaidLinkOn() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @JvmStatic
    public static final boolean l() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L9;
        m r1 = r0.getVideoTalkService();
        if (r1 == null) goto L9;
        com.bytedance.android.live.liveinteract.api.data.a r2 = r1.j();
        if (r2 == null) goto L9;
        return r2.c;
    L9:
        return false;
    }

    public static int a() {
        int r1 = 0;
        if (c.a() == false) goto L39;
        cj0.c r0 = PaidLinkMicContext.Companion.a();
        if (r0 == null) goto L49;
        List<String> r2 = r0.getIncreaseUserList();
        if (r2 != null) goto L9;
        return 0;
    L9:
        if (r2.isEmpty() == true) goto L52;
        IInteractService r3 = (IInteractService) k.f(IInteractService.class);
        ArrayList r4 = null;
        if (r3 == null) goto L16;
        i<ILinkPlayerInfoBridge> r5 = r3.getLinkUserInfoCenter();
        if (r5 == null) goto L16;
        Iterable r6 = r5.V4();
    L17:
        if (r6 == null) goto L28;
        Iterable r7 = r6;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L20:
        if (r9.hasNext() == false) goto L26;
        IBaseUser r10 = ((ILinkPlayerInfoBridge) r9.next()).getUser();
        if (r10 == null) goto L24;
        String r11 = r10.getIdString();
    L25:
        r8.add(r11);
        goto L20
    L24:
        r11 = null;
        goto L25
    L26:
        r4 = r8;
    L28:
        if (Lists.isEmpty(r4) == true) goto L51;
        Iterator<T> r12 = r2.iterator();
    L32:
        if (r12.hasNext() == false) goto L53;
        String r13 = (String) r12.next();
        if (r4 == null) goto L38;
        if (r4.contains(r13) == true) goto L32;
    L38:
        r1 = r1 + 1;
        goto L32
    L53:
        return r1;
    L51:
        return 0 + r2.size();
    L16:
        r6 = null;
        goto L17
    L52:
        return 0;
    L49:
        return 0;
    L39:
        return 0;
    }

    public static boolean d() {
        if (c.a() == false) goto L11;
        PaidLinkMicContext r0 = PaidLinkMicContext.Companion.getContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isAnonymous();
        if (r1 == null) goto L11;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L11;
        return r2.booleanValue();
    L11:
        return false;
    }

    @JvmStatic
    public static final boolean g(IRoom r1) {
        if (r1 == null) goto L8;
        Map r2 = r1.getAnchorABMap();
        if (r2 == null) goto L8;
        String r3 = (String) r2.get("optran_paid_linkmic");
        if (r3 == null) goto L8;
        Integer r4 = StringsKt.toIntOrNull(r3);
    L9:
        if (r4 != null) goto L12;
    L14:
        return false;
    L12:
        if (r4.intValue() != 2) goto L14;
        return true;
    L8:
        r4 = null;
        goto L9
    }

    @JvmStatic
    public static final boolean j(IRoom r2) {
        if (r2 == null) goto L10;
        z5 r3 = r2.getLinkerDetail();
        if (r3 == null) goto L10;
        List r4 = r3.getPlayModes();
        if (r4 == null) goto L10;
        if (r4.contains(Long.valueOf(11)) != true) goto L10;
        return true;
    L10:
        return false;
    }

    @JvmStatic
    public static final long m(ILinkPlayerInfoBridge r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().j();
        if (r0 != null) goto L5;
    L11:
        long r1 = r4.getPaidLinkCurrentTime();
        if (r1 <= 0) goto L15;
        return r1;
    L15:
        return p6.b();
    L5:
        if (((Boolean) r0.getValue()).booleanValue() != true) goto L11;
        com.bytedance.live.datacontext.m r5 = com.bytedance.android.live.liveinteract.api.utils.m.d().j();
        if (r5 == null) goto L10;
        r5.setValue(Boolean.FALSE);
    L10:
        return p6.b() / ((long) 1000);
    }

    public static void n(boolean r1) {
        if (c.a() == false) goto L10;
        PaidLinkMicContext r0 = PaidLinkMicContext.Companion.getContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r2 = r0.isAnonymous();
        if (r2 == null) goto L12;
        r2.setValue(Boolean.valueOf(r1));
        return;
    L12:
        return;
    L11:
        return;
    }
}
