package ke8;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.nestedfile.NestFileService;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.mainbot.impl.databinding.LarusCotDetailUserNestfileCellBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 extends le8.a<he8.h> {
    public final Lazy b;
    public final h38.d c;
    public final Lazy d;
    public ie8.a e;

    public static final class a implements BaseResourceViewHolder.a {
        public final /* synthetic */ g0 a;
        public final /* synthetic */ Context b;

        /* JADX INFO: renamed from: ke8.g0$a$a, reason: collision with other inner class name */
        public static final class C0080a implements lr8.a {
            public final /* synthetic */ Context a;
            public final /* synthetic */ g0 b;
            public final /* synthetic */ ie8.a c;
            public final /* synthetic */ NestedFileContent d;

            public final com.larus.trace.tracknode.a f() {
                return null;
            }

            public final /* bridge */ /* synthetic */ q0 getAdapter() {
                return null;
            }

            public final /* bridge */ /* synthetic */ wc9.e h() {
                return null;
            }

            public final boolean i0() {
                return false;
            }

            public final void a() {
                g0 r0 = this.b;
                r0.c.a(this.c.a, this.d, g0.c(r0));
            }

            public final CoroutineScope c() {
                LifecycleOwner r0 = this.a;
                if ((r0 instanceof LifecycleOwner) == false) goto L5;
                LifecycleOwner r1 = r0;
            L6:
                if (r1 != null) goto L8;
                return null;
            L8:
                return LifecycleOwnerKt.getLifecycleScope(r1);
            L5:
                r1 = null;
                goto L6
            }

            public final FragmentManager getFragmentManager() {
                FragmentActivity r0 = this.a;
                if ((r0 instanceof FragmentActivity) == false) goto L5;
                FragmentActivity r1 = r0;
            L6:
                if (r1 != null) goto L8;
                return null;
            L8:
                return r1.getSupportFragmentManager();
            L5:
                r1 = null;
                goto L6
            }

            public final BotModel i() {
                return new BotModel("unknown", null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
            }

            public C0080a(Context r1, g0 r2, ie8.a r3, NestedFileContent r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }
        }

        public a(g0 r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final boolean b(String r1, View r2) {
            BaseResourceViewHolder.a.a.a(r1, r2);
            return false;
        }

        public final void a(String r16, int r17, View r18) {
            Intrinsics.checkNotNullParameter(r16, "key");
            Intrinsics.checkNotNullParameter(r18, "v");
            if (r17 != 103) goto L9;
            ie8.a r0 = this.a.e;
            if (r0 != null) goto L7;
            return;
        L7:
            NestedFileContent r4 = com.larus.bmhome.chat.bean.d.f(r0.a);
            Message r3 = r0.a;
            Context r6 = this.b;
            final g0 r8 = this.a;
            lr8.f r13 = new lr8.f(r16, r18, r3, r4, -1, this, new C0080a(r6, r8, r0, r4), new f0(r8), Boolean.TRUE, false, 512);
            NestFileService.b.c(r13);
            return;
        }
    }

    @Override // le8.a
    public final void b() {
    }

    private final LarusCotDetailUserNestfileCellBinding getBinding() {
        return (LarusCotDetailUserNestfileCellBinding) this.b.getValue();
    }

    private final BaseResourceViewHolder.a getCallback() {
        return (BaseResourceViewHolder.a) this.d.getValue();
    }

    public g0(final Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.b = LazyKt.lazy(new d0(r4, this));
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        View r0 = NestFileService.b.e(r4);
        this.c = r0;
        getBinding().b.addView(r0);
        this.d = LazyKt.lazy(new e0(this, r4));
    }

    public static final /* synthetic */ BaseResourceViewHolder.a c(g0 r0) {
        return r0.getCallback();
    }

    @Override // le8.b
    public final void a(ie8.a r4) {
        Intrinsics.checkNotNullParameter(r4, "state");
        this.e = r4;
        NestedFileContent r0 = com.larus.bmhome.chat.bean.d.f(r4.a);
        this.c.a(r4.a, r0, getCallback());
    }
}
