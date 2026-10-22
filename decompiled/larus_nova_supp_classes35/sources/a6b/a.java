package a6b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.ContentMessageActionViewHolder;
import com.ss.android.lark.chat.message.menu.v2.i0;
import com.ss.android.lark.chat.message.menu.v2.j0;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a implements e<zya.b, ContentMessageActionViewHolder> {
    public j0 a;

    /* JADX INFO: renamed from: a6b.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0002a implements View.OnClickListener {
        public final /* synthetic */ zya.b a;
        public final /* synthetic */ Ref.BooleanRef b;
        public final /* synthetic */ a c;

        public ViewOnClickListenerC0002a(zya.b r1, Ref.BooleanRef r2, a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            zya.d r0 = this.a.j;
            boolean r1 = true;
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L11;
            Log.i(this.c.e(), "item click is intercepted");
            return;
        L11:
            if (this.b.element == false) goto L28;
            zya.d r3 = this.a.j;
            if (r3 == null) goto L15;
            Intrinsics.checkNotNull(r6);
            r3.b(r6, true);
        L15:
            List<zya.b> r7 = this.a.k;
            List<zya.b> r4 = r7;
            if (r4 != null) goto L18;
        L21:
            if (r1 == true) goto L25;
            j0 r5 = this.c.a;
            if (r5 == null) goto L36;
            r5.c(this.a, r7);
            return;
        L36:
            return;
        L25:
            j0 r8 = this.c.a;
            if (r8 == null) goto L38;
            i0.a(r8, false, null, 7);
            return;
        L38:
            return;
        L18:
            if (r4.isEmpty() == true) goto L21;
            r1 = false;
            goto L21
        L28:
            zya.d r9 = this.a.j;
            if (r9 == null) goto L31;
            Intrinsics.checkNotNull(r6);
            r9.b(r6, false);
        L31:
            j0 r10 = this.c.a;
            if (r10 == null) goto L40;
            i0.a(r10, false, null, 7);
            return;
        L40:
            return;
        L5:
            if (r0.c(this.b.element) != true) goto L7;
            r2 = true;
            goto L8
        }
    }

    public static final class b implements zya.f {
        public final /* synthetic */ ContentMessageActionViewHolder a;

        public Context getContext() {
            return ((RecyclerView.ViewHolder) this.a).itemView.getContext();
        }

        public b(ContentMessageActionViewHolder r1) {
            this.a = r1;
        }
    }

    public a() {
    }

    public abstract int d();

    public abstract String e();

    @Override // a6b.e
    public final RecyclerView.ViewHolder a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(d(), r4, false);
        Intrinsics.checkNotNull(r5);
        return new ContentMessageActionViewHolder(r5);
    }

    @Override // a6b.e
    public final void b(j0 r1) {
        this.a = r1;
    }

    @Override // a6b.e
    public /* bridge */ /* synthetic */ void c(RecyclerView.ViewHolder r1, zya.e r2) {
        f((ContentMessageActionViewHolder) r1, (zya.b) r2);
    }

    public void f(ContentMessageActionViewHolder r8, zya.b r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        Intrinsics.checkNotNullParameter(r9, "itemData");
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = r9.g;
        zya.d r1 = r9.j;
        boolean r2 = true;
        int r3 = 0;
        if (r1 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        r0.element = false;
    L11:
        if (r9.i != null) goto L14;
        r2 = false;
    L14:
        FrameLayout r5 = r8.b;
        if (r2 == false) goto L17;
        int r6 = 0;
    L18:
        r5.setVisibility(r6);
        View r7 = r8.a;
        if ((!r2) == false) goto L21;
        int r10 = 0;
    L22:
        r7.setVisibility(r10);
        if (r2 == false) goto L25;
        r8.b.removeAllViews();
        r8.b.addView(r9.i);
    L42:
        ((RecyclerView.ViewHolder) r8).itemView.setOnClickListener(new ViewOnClickListenerC0002a(r9, r0, this));
        zya.d r11 = r9.j;
        if (r11 == null) goto L45;
        r11.d(new b(r8));
    L45:
        zya.d r12 = r9.j;
        if (r12 == null) goto L49;
        r12.onShow();
        return;
    L49:
        return;
    L25:
        Drawable r13 = r9.b;
        r13.mutate();
        int r14 = 2131102416;
        if (r9.c == true) goto L28;
        Context r15 = ((RecyclerView.ViewHolder) r8).itemView.getContext();
        if (r0.element == false) goto L33;
        r14 = 2131102418;
    L33:
        r13.setTint(UIUtils.getColor(r15, r14));
    L34:
        r8.c.setImageDrawable(r13);
        r8.d.setText(r9.e);
        View r16 = r8.e;
        if (r9.f == true) goto L38;
        r3 = 8;
    L38:
        r16.setVisibility(r3);
        String r17 = r9.m;
        if (r17 == null) goto L41;
        ((RecyclerView.ViewHolder) r8).itemView.setTag(2131388363, r17);
    L41:
        r8.c.setEnabled(r0.element);
        r8.d.setEnabled(r0.element);
        r8.e.setEnabled(r0.element);
        goto L42
    L28:
        if (r0.element == true) goto L34;
        r13.setTint(UIUtils.getColor(((RecyclerView.ViewHolder) r8).itemView.getContext(), 2131102416));
        goto L34
    L21:
        r10 = 8;
        goto L22
    L17:
        r6 = 8;
        goto L18
    L5:
        if (r1.a() != true) goto L7;
        r4 = true;
        goto L8
    }
}
