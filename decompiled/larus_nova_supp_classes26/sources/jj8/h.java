package jj8;

import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.block.InteractionAskOption;
import ij8.q;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public f a;
    public g b;
    public final a c;

    public static final class a implements q {
        public final /* synthetic */ h a;

        public final BaseResourceViewHolder.a b() {
            h r0 = this.a;
            f r1 = r0.a;
            if (r1 != null) goto L5;
            return null;
        L5:
            g r2 = r0.b;
            if (r2 != null) goto L8;
            return null;
        L8:
            return r2.c(r1);
        }

        @Override // ij8.q
        public final void onCloseClick() {
            h r0 = this.a;
            f r1 = r0.a;
            if (r1 != null) goto L5;
            return;
        L5:
            g r2 = r0.b;
            if (r2 == null) goto L9;
            r2.a(r1);
            return;
        }

        public a(h r1) {
            this.a = r1;
        }

        @Override // ij8.q
        public final void a(InteractionAskOption r3) {
            Intrinsics.checkNotNullParameter(r3, "option");
            f r0 = this.a.a;
            if (r0 != null) goto L5;
            return;
        L5:
            String r4 = r3.getOptionId();
            if (r4 != null) goto L9;
            r4 = "";
        L9:
            if (StringsKt.isBlank(r4) == false) goto L11;
            return;
        L11:
            g r1 = this.a.b;
            if (r1 == null) goto L15;
            r1.b(r0, r4);
            return;
        }
    }

    public h() {
        this.c = new a(this);
    }
}
