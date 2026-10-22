package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import java.util.LinkedList;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T extends BaseMessage> {
    public final LinkedList<l62.a<T>> a;
    public final c b;
    public final boolean c;
    public final IAssetsManager d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.chatchannel.manager.a$a, reason: collision with other inner class name */
    public static final class C0106a {
    }

    public interface b<T extends BaseMessage> {
        void a(l62.a<T> r1);
    }

    public static final class c extends com.bytedance.android.livesdk.gift.platform.business.effect.assets.o {
        public b<T> a;
        public final /* synthetic */ a b;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void a(long r1) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void b(boolean r1) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o
        public final String d() {
            return "AssetFetcher";
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onFailed(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "t");
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onProgress(int r1) {
        }

        public c(a r1) {
            this.b = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void c(long r7, String r9) {
            Intrinsics.checkNotNullParameter(r9, "path");
            super.c(r7, r9);
            LinkedList<l62.a<T>> r0 = this.b.a;
            ListIterator<l62.a<T>> r1 = r0.listIterator(r0.size());
        L4:
            if (r1.hasPrevious() == false) goto L11;
            l62.a<T> r2 = r1.previous();
            if (r2.a != r7) goto L8;
            boolean r3 = true;
        L9:
            if (r3 == false) goto L4;
        L12:
            l62.a<T> r4 = r2;
            if (r4 != null) goto L16;
            return;
        L16:
            if ((!this.b.a.isEmpty()) == false) goto L20;
            if (Intrinsics.areEqual(this.b.a.removeFirst(), r4) == false) goto L16;
        L20:
            if ((System.currentTimeMillis() - r4.c) >= 3000) goto L33;
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r4.b = r9;
            b<T> r8 = this.a;
            if (r8 == null) goto L34;
            r8.a(r4);
            return;
        L34:
            return;
        L33:
            return;
        L8:
            r3 = false;
            goto L9
        L11:
            r2 = null;
            goto L12
        }
    }

    static {
    }

    public a(boolean r2, IAssetsManager r3) {
        Intrinsics.checkNotNullParameter(r3, "assetManager");
        this.c = r2;
        this.d = r3;
        this.a = new LinkedList();
        this.b = new c(this);
    }
}
