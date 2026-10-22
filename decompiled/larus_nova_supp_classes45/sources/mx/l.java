package mx;

import android.view.View;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import io.reactivex.disposables.Disposable;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class l extends mx.a {
    public static final /* synthetic */ int o = 0;
    public boolean l;
    public Disposable m;
    public boolean n;

    public static final class a {
        public static void a(l r1, SwitchSettingViewHolder r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "item");
            Intrinsics.checkNotNullParameter(r2, "holder");
            r1.l = r3;
            if (r2.d.isChecked() == r3) goto L6;
            r2.d.f(false, true);
            return;
        }

        public static void b(MultiTypeAdapter r1, l r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "adapter");
            Intrinsics.checkNotNullParameter(r2, "item");
            int r0 = CollectionsKt.indexOf(r1.a, r2);
            r2.l = r3;
            int r4 = r1.a.size();
            if (r0 < 0) goto L9;
            if (r4 <= r0) goto L8;
            r1.notifyItemChanged(r0);
            return;
        L8:
            return;
        }
    }

    static {
    }

    public boolean b(boolean r1) {
        return false;
    }

    public void d() {
    }

    public View.OnClickListener f() {
        return null;
    }

    public void e() {
        if (this.n == false) goto L5;
        d();
    L5:
        this.n = false;
    }

    public void c(SwitchSettingViewHolder r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.l = r3;
    }

    public l(String r12, String r13, boolean r14, boolean r15, boolean r16, String r17, int r18) {
        if ((r18 & 2) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r18 & 4) == 0) goto L9;
        boolean r9 = false;
    L11:
        if ((r18 & 8) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r18 & 16) == 0) goto L17;
        boolean r5 = true;
    L19:
        if ((r18 & 32) == 0) goto L21;
        String r6 = "";
    L22:
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r2, "description");
        Intrinsics.checkNotNullParameter(r6, "disableToast");
        super(r12, r2, r9, r4, r5, r6, 192);
        this.l = r9;
        this.n = true;
        return;
    L21:
        r6 = r17;
        goto L22
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r9 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }
}
