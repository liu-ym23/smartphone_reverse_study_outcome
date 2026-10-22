package arb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import com.ss.android.lark.mention.base.impl.atselector.model.ChatAtModel;
import com.ss.android.lark.utils.ApiUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements b {
    public static final a b = null;
    public final /* synthetic */ b a;

    /* JADX INFO: renamed from: arb.a$a, reason: collision with other inner class name */
    public static final class C0009a implements b {
        public C0009a() {
        }

        @Override // arb.b
        public final void V(Object r1, String r2) {
        }

        @Override // arb.b
        public final void W() {
        }

        @Override // arb.b
        public final boolean X() {
            return false;
        }

        @Override // arb.b
        public final void Y(Context r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "botId");
        }

        @Override // arb.b
        public final void Z(SparseArray<drb.a<? extends BaseAtBean, ?>> r2, IItemContainer r3) {
            Intrinsics.checkNotNullParameter(r2, "binderMap");
            Intrinsics.checkNotNullParameter(r3, "container");
        }

        @Override // arb.b
        public final String a0(String r2) {
            Intrinsics.checkNotNullParameter(r2, "defaultName");
            return "";
        }

        @Override // arb.b
        public final void b0() {
        }

        @Override // arb.b
        public final void c0(Object r1, String r2, ChatAtModel.a r3) {
        }

        @Override // arb.b
        public final void d0(boolean r1) {
        }

        @Override // arb.b
        public final Drawable e0(Context r1, List r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            return null;
        }
    }

    static {
        b = new a();
    }

    @Override // arb.b
    public final void V(Object r2, String r3) {
        this.a.V(r2, r3);
    }

    @Override // arb.b
    public final void W() {
        this.a.W();
    }

    @Override // arb.b
    public final boolean X() {
        return this.a.X();
    }

    @Override // arb.b
    public final void Y(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "botId");
        this.a.Y(r2, r3);
    }

    @Override // arb.b
    public final void Z(SparseArray<drb.a<? extends BaseAtBean, ?>> r2, IItemContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "binderMap");
        Intrinsics.checkNotNullParameter(r3, "container");
        this.a.Z(r2, r3);
    }

    @Override // arb.b
    public final String a0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "defaultName");
        return this.a.a0(r2);
    }

    @Override // arb.b
    public final void b0() {
        this.a.b0();
    }

    @Override // arb.b
    public final void c0(Object r2, String r3, ChatAtModel.a r4) {
        this.a.c0(r2, r3, r4);
    }

    @Override // arb.b
    public final void d0(boolean r2) {
        this.a.d0(r2);
    }

    @Override // arb.b
    public final Drawable e0(Context r2, List r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.e0(r2, r3);
    }

    public a() {
        b r0 = (b) ApiUtils.getApi(b.class);
        if (r0 != null) goto L5;
        r0 = new C0009a();
    L5:
        this.a = r0;
    }
}
