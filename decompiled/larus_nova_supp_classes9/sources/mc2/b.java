package mc2;

import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.zdanmaku.j;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;
import py.d;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class b extends r22.a<j> {
    public final Deque<j> c;

    @Override // r22.a
    public final j j() {
        return (j) ((LinkedList) this.c).pollFirst();
    }

    @Override // r22.a
    public final Queue<j> h() {
        return this.c;
    }

    public b(r22.b<j> r2) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2);
        this.c = new LinkedList();
    }

    @Override // r22.a
    public final void e(j r2) {
        j r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "danmaku");
        ((LinkedList) this.c).add(r3);
        k();
    }

    @Override // r22.a
    public final void b(j r7, r22.a.b<j> r8) {
        j r9 = r7;
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r8, "notifier");
        IBaseUser r0 = r9.a.getUser2();
        k r1 = null;
        if (r0 == null) goto L11;
        d r2 = r0.getUserHonor();
        if (r2 == null) goto L11;
        k r3 = r2.getHonorBuffBadge();
        if (r3 == null) goto L11;
        if (r3.isValid() == false) goto L11;
    L12:
        float r4 = 16.0f;
        if (r3 == null) goto L23;
        r9.a.setBadgeDrawable(a1.e(r3, true));
        s3 r5 = r9.a;
        if (r3.getHeight() <= 0) goto L17;
        int r6 = s1.f(r3.getHeight());
    L18:
        r5.setBadgeHeight(r6);
        s3 r10 = r9.a;
        if (r3.getWidth() <= 0) goto L21;
        float r11 = r3.getWidth();
    L22:
        r10.setBadgeWidth(s1.f(r11));
        goto L23
    L21:
        r11 = 32.0f;
        goto L22
    L17:
        r6 = s1.f(16.0f);
    L23:
        IBaseUser r13 = r9.a.getUser2();
        if (r13 == null) goto L32;
        d r14 = r13.getUserHonor();
        if (r14 == null) goto L32;
        k r15 = r14.getRecentConsume();
        if (r15 == null) goto L32;
        if (r15.isValid() == false) goto L32;
        r1 = r15;
    L32:
        if (r1 == null) goto L41;
        r9.a.setRecentBadgeDrawable(a1.e(r1, true));
        s3 r16 = r9.a;
        if (r1.getHeight() <= 0) goto L36;
        r4 = r1.getHeight();
    L36:
        r16.setRecentBadgeHeight(s1.f(r4));
        s3 r17 = r9.a;
        if (r1.getWidth() <= 0) goto L39;
        float r18 = r1.getWidth();
    L40:
        r17.setRecentBadgeWidth(s1.f(r18));
        goto L41
    L39:
        r18 = 21.0f;
    L41:
        r8.a(r9);
        return;
    L11:
        r3 = null;
        goto L12
    }
}
