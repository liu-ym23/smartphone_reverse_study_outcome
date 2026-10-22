package com.bytedance.android.livesdk.interactivity.chatchannel.config;

import android.graphics.Typeface;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.utils.w2;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import g52.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RoomChannelWidgetConfigProvider {
    public static final /* synthetic */ int a = 0;

    public static final class PublicScreenSyncConfig implements com.bytedance.android.livesdk.interactivity.chatchannel.config.a {
        public e a;
        public n42.a b;

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.config.a
        public final e a() {
            e r0 = this.a;
            if (r0 != null) goto L6;
            e r1 = a.a;
            return a.a;
        L6:
            return r0;
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.config.a
        public final int b() {
            n42.a r0 = this.b;
            if (r0 == null) goto L6;
            return r0.k;
        L6:
            return a.b.b();
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.config.a
        public final int c() {
            n42.a r0 = this.b;
            if (r0 == null) goto L6;
            return r0.j;
        L6:
            return a.b.c();
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.config.a
        public final int d() {
            n42.a r0 = this.b;
            if (r0 != null) goto L7;
            e r1 = a.a;
            return 2131249888;
        L7:
            return r0.l;
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.config.a
        public final float e() {
            n42.a r0 = this.b;
            if (r0 == null) goto L6;
            return r0.i;
        L6:
            return a.b.e();
        }

        public PublicScreenSyncConfig(RoomContext r2) {
            Intrinsics.checkNotNullParameter(r2, "roomContext");
            h r3 = i.c(r2);
            if (r3 == null) goto L8;
            j<l> r4 = r3.getPublicScreenContext();
            if (r4 == null) goto L9;
            r4.c(new AnonymousClass1(this));
            return;
        L9:
            return;
        }
    }

    public static final class a implements com.bytedance.android.livesdk.interactivity.chatchannel.config.a {
        public static final e a = null;
        public static final a b = null;

        public a() {
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.config.a
        public final int d() {
            return 2131249888;
        }

        static {
            b = new a();
            a = new e(w2.a(14.0f), (int) s1.b(24.0f), Typeface.DEFAULT_BOLD, s1.f(8.0f), s1.f(3.0f), s1.f(8.0f), s1.f(3.0f));
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.config.a
        public final int b() {
            return s1.f(24.0f);
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.config.a
        public final int c() {
            return ColorProtector.parseColor("#ff4e33");
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.config.a
        public final float e() {
            return s1.f(13.0f);
        }

        @Override // com.bytedance.android.livesdk.interactivity.chatchannel.config.a
        public final e a() {
            return a;
        }
    }

    static {
    }
}
