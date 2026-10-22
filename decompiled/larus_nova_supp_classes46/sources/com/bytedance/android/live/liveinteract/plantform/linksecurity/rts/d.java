package com.bytedance.android.live.liveinteract.plantform.linksecurity.rts;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static boolean a(String r3, String r4, ILinkPlayerInfoBridge r5) {
            if (r2.a(r3) == true) goto L5;
        L7:
            String r0 = null;
            if (r5 == null) goto L10;
            IBaseUser r2 = r5.getUser();
        L11:
            if (r2 != null) goto L14;
            return false;
        L14:
            if (r2.a(r3) == false) goto L21;
            IBaseUser r6 = r5.getUser();
            if (r6 == null) goto L19;
            r0 = r6.getIdString();
        L19:
            if (Intrinsics.areEqual(r0, r3) == false) goto L21;
        L24:
            return true;
        L21:
            if (TextUtils.isEmpty(r4) == false) goto L23;
            return false;
        L23:
            if (TextUtils.equals(r5.getInteractId(), r4) == true) goto L24;
            return false;
        L10:
            r2 = null;
            goto L11
        L5:
            if (TextUtils.isEmpty(r4) == false) goto L7;
            return false;
        }

        public static void b(i r8, String r9, String r10, int r11) {
            Intrinsics.checkNotNullParameter(r9, "targetUserId");
            ILinkPlayerInfoBridge r0 = null;
            int r1 = -1;
            boolean r2 = false;
            if (r8 == null) goto L19;
            List r3 = r8.getOnlineUserList();
            if (r3 == null) goto L19;
            Iterator r4 = r3.iterator();
            int r5 = 0;
        L8:
            if (r4.hasNext() == false) goto L19;
            Object r6 = r4.next();
            int r7 = r5 + 1;
            if (r5 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            ILinkPlayerInfoBridge r12 = (ILinkPlayerInfoBridge) r6;
            int r13 = d.a;
            if (a(r9, r10, r12) == false) goto L18;
            r0 = n.a(r12);
            if (r0.getSilenceStatus() == r11) goto L17;
            r0.setSilenceStatus(r11);
            r2 = true;
        L17:
            r1 = r5;
        L18:
            r5 = r7;
        L19:
            if (r2 == true) goto L22;
            ALogger.w("UpdateLinkUserInfoUtil", "updateUserSilenceStatusAndNotify: not need refresh list");
            return;
        L22:
            if (r1 < 0) goto L28;
            if (r0 == null) goto L28;
            if (r8 == null) goto L28;
            List r14 = r8.getOnlineUserList();
            if (r14 == null) goto L28;
            ILinkPlayerInfoBridge r15 = (ILinkPlayerInfoBridge) ListProtector.set(r14, r1, r0);
        L28:
            if (r8 == null) goto L34;
            r8.W4();
            return;
        }
    }

    static {
    }
}
