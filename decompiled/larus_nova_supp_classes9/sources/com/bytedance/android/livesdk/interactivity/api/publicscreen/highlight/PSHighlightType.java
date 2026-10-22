package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class PSHighlightType implements n {
    public final String a;

    public static final class CommonHighlightComp extends PSHighlightType {
        public static final Lazy f = null;
        public final long b;
        public final String c;
        public final long d;
        public final long e;

        public static final class a {
        }

        public CommonHighlightComp() {
            this(0);
        }

        static {
            f = LazyKt.lazy(PSHighlightType$CommonHighlightComp$Companion$Default$2.INSTANCE);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long a() {
            return this.d;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long b() {
            return this.e;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final String getBizScene() {
            return this.c;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public long getType() {
            return this.b;
        }

        public /* synthetic */ CommonHighlightComp(int r9) {
            this(-1, BuildConfig.FLAVOR, 300, 150);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final boolean c(n r5) {
            Intrinsics.checkNotNullParameter(r5, "other");
            if (super.c(r5) == true) goto L5;
        L7:
            return false;
        L5:
            if (getType() != r5.getType()) goto L7;
            return true;
        }

        public CommonHighlightComp(long r2, String r4, long r5, long r7) {
            Intrinsics.checkNotNullParameter(r4, "bizScene");
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r7;
        }
    }

    public static final class a extends PSHighlightType {
        public final long b;
        public final long c;

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long a() {
            return this.b;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long b() {
            return this.c;
        }

        public a(long r1, long r3) {
            this.b = r1;
            this.c = r3;
        }
    }

    public static final class b extends PSHighlightType {
        public final long b;
        public final long c;

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long a() {
            return this.b;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long b() {
            return this.c;
        }

        public b(long r1, long r3) {
            this.b = r1;
            this.c = r3;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
    public long getType() {
        return 0;
    }

    public PSHighlightType() {
        this.a = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
    public String getBizScene() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
    public boolean c(n r2) {
        Intrinsics.checkNotNullParameter(r2, "other");
        Intrinsics.checkNotNullParameter(r2, "other");
        return Intrinsics.areEqual(getClass(), r2.getClass());
    }
}
