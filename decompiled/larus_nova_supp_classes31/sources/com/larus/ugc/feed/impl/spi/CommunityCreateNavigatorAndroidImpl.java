package com.larus.ugc.feed.impl.spi;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.im.internal.delegate.c0;
import com.larus.ugc.feed.impl.home.CommunityCreateFragment;
import com.larus.utils.f;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g0a.k;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CommunityCreateNavigatorAndroidImpl implements g0a.c {
    public final WeakReference<Activity> a;

    public static final class a {
    }

    static {
    }

    @Override // g0a.c
    public final void kF(k r15) {
        Intrinsics.checkNotNullParameter(r15, "params");
        WeakReference<Activity> r0 = this.a;
        if (r0 == null) goto L9;
        Activity r1 = r0.get();
        if (r1 == null) goto L9;
        if ((!r1.isFinishing()) == false) goto L9;
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        e0 r3 = (e0) AuthModelDelegate.b.e().getValue();
        if (r3 == null) goto L18;
        LaunchInfo r4 = r3.a;
        if (r4 == null) goto L18;
        String r5 = r4.W();
        if (r5 == null) goto L18;
    L19:
        List r6 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r5);
        if (r6 == null) goto L37;
        Iterator r7 = r6.iterator();
    L23:
        if (r7.hasNext() == false) goto L35;
        Object r8 = r7.next();
        r r9 = ((z0) r8).q;
        if (r9 == null) goto L32;
        Integer r10 = r9.a;
        if (r10 == null) goto L32;
        if (r10.intValue() != 28) goto L32;
        boolean r11 = true;
    L33:
        if (r11 == false) goto L23;
    L36:
        z0 r12 = (z0) r8;
    L38:
        if (r12 != null) goto L58;
        if (r6 == null) goto L56;
        Iterator r13 = r6.iterator();
    L42:
        if (r13.hasNext() == false) goto L54;
        Object r14 = r13.next();
        r r16 = ((z0) r14).q;
        if (r16 == null) goto L51;
        Integer r17 = r16.a;
        if (r17 == null) goto L51;
        if (r17.intValue() != 4) goto L51;
        boolean r18 = true;
    L52:
        if (r18 == false) goto L42;
    L55:
        r12 = (z0) r14;
    L51:
        r18 = false;
        goto L52
    L54:
        r14 = null;
        goto L55
    L56:
        r12 = null;
    L58:
        if (r12 != null) goto L62;
        c0.b.d("CommunityCreateNavigatorAndroidImpl", "openMixCreationPage abort: no actionBar item (mainBotId=" + r5 + ')');
        return;
    L62:
        if ((r1 instanceof FragmentActivity) == false) goto L64;
        FragmentActivity r2 = (FragmentActivity) r1;
    L65:
        if (r2 == null) goto L67;
        CoroutineScope r19 = LifecycleOwnerKt.getLifecycleScope(r2);
    L68:
        if (r19 != null) goto L71;
        c0.b.d("CommunityCreateNavigatorAndroidImpl", "openMixCreationPage abort: activity not FragmentActivity");
        return;
    L71:
        BuildersKt.launch$default(r19, null, null, new CommunityCreateNavigatorAndroidImpl$openMixCreationPage$1(this, r15, r12, null), 3, null);
        return;
    L67:
        r19 = null;
        goto L68
    L64:
        r2 = null;
    L32:
        r11 = false;
        goto L33
    L35:
        r8 = null;
        goto L36
    L37:
        r12 = null;
    L18:
        r5 = "";
    L9:
        r1 = null;
        goto L10
    }

    public CommunityCreateNavigatorAndroidImpl(FragmentActivity r2, CommunityCreateFragment r3) {
        if (r2 == null) goto L5;
        WeakReference<Activity> r0 = new WeakReference(r2);
    L6:
        this.a = r0;
        if (r3 == null) goto L10;
        new WeakReference(r3);
        return;
    L10:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // g0a.c
    public final void bY(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "enterMethod");
        WeakReference<Activity> r0 = this.a;
        if (r0 == null) goto L9;
        Activity r1 = r0.get();
        if (r1 == null) goto L9;
        if ((!r1.isFinishing()) == false) goto L9;
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        if (r4 != null) goto L14;
        r4 = "PROFILE_CREATION_LIST_PRIVATE";
    L14:
        i r2 = SmartRouter.buildRoute(r1, "//flow/profile_mine");
        r2.c.putExtras(f.c(new Pair[]{TuplesKt.to("landing_tab", r4)}));
        r2.c.putExtra("enter_method", r5);
        r2.c.putExtra("ignore_side_bar", "1");
        r2.c.addFlags(536870912);
        r2.d();
        return;
    L9:
        r1 = null;
        goto L10
    }
}
