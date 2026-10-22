package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LiveAvatarViewAnimManager {
    public final List<a> a;
    public final int b;
    public final int c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    public static final class a {
        public final LiveAvatarCircleView a;
        public final View b;
        public final View c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            LiveAvatarCircleView r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            View r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            View r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "LiveAnimViews(circleView=" + this.a + ", tagView=" + this.b + ", avatarView=" + this.c + ")";
        }

        public a(LiveAvatarCircleView r1, View r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public LiveAvatarViewAnimManager() {
        this.a = new ArrayList();
        this.b = 1100;
        this.c = 640;
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.d = LazyKt.lazy(r0, new LiveAvatarViewAnimManager$animatorSet$2(this));
        this.e = LazyKt.lazy(r0, new LiveAvatarViewAnimManager$valueAnimator$2(this));
        this.f = LazyKt.lazy(r0, new LiveAvatarViewAnimManager$animator$2(this));
    }
}
