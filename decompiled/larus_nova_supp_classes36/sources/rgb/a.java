package rgb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.flow.chat.view.sheet.FlowBottomSheet;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends FlowBottomSheet {
    public final b d;
    public c e;
    public C0319a f;

    /* JADX INFO: renamed from: rgb.a$a, reason: collision with other inner class name */
    public static final class C0319a {
        public final Chat a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0319a) == true) goto L8;
            return false;
        L8:
            C0319a r6 = (C0319a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Data(chat=" + this.a + ", isExpired=" + this.b + ')';
        }

        public C0319a(Chat r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "chat");
            this.a = r2;
            this.b = r3;
        }
    }

    public interface b {
        void v(Chat r1);
    }

    public static final class c {
        public final View a;
        public final ImageView b;
        public final TextView c;
        public final TextView d;
        public final TextView e;
        public final View f;
        public final ImageView g;

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            this.a = r2;
            this.b = (ImageView) r2.findViewById(2131373927);
            this.c = (TextView) r2.findViewById(2131373984);
            this.d = (TextView) r2.findViewById(2131373948);
            this.e = (TextView) r2.findViewById(2131373969);
            this.f = r2.findViewById(2131366983);
            this.g = (ImageView) r2.findViewById(2131375582);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.b(true);
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.b(true);
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ a a;

        public f(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.b(true);
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ Chat b;

        public g(a r1, Chat r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.d.v(this.b);
        }
    }

    public final void e() {
        c r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        C0319a r1 = this.f;
        if (r1 != null) goto L8;
        return;
    L8:
        Chat r2 = r1.a;
        com.ss.android.lark.chat.utils.g.e(r0.a.getContext(), r0.b, r2.getAvatarKey(), r2.getEntityId(), UIHelper.dp2px(56.0f), UIHelper.dp2px(56.0f), Scene.Chat);
        r0.f.setOnClickListener(new d(this));
        Context r3 = r0.a.getContext();
        if (r1.a.isDissolved() == false) goto L12;
        r0.c.setText(UIUtils.getString(r3, 2131890094));
        r0.d.setVisibility(8);
        r0.g.setVisibility(0);
        r0.e.setText(UIUtils.getString(r3, 2131889965));
        r0.e.setTextColor(UIUtils.getColor(r0.a.getContext(), 2131102040));
        r0.e.setBackgroundResource(2131235421);
        r0.e.setOnClickListener(new e(this));
        return;
    L12:
        if (r1.b == false) goto L14;
        r0.c.setText(UIUtils.getString(r3, 2131890115));
        r0.d.setVisibility(8);
        r0.g.setVisibility(0);
        r0.e.setText(UIUtils.getString(r3, 2131889965));
        r0.e.setTextColor(UIUtils.getColor(r0.a.getContext(), 2131102040));
        r0.e.setBackgroundResource(2131235421);
        r0.e.setOnClickListener(new f(this));
        return;
    L14:
        r0.g.setVisibility(8);
        r0.c.setText(r2.getName());
        r0.d.setVisibility(0);
        int r4 = r2.getMemberCount();
        r0.d.setText(ICUUtils.icuFormat(UIUtils.getQuantityString(r3, 2131755046, r4), "num", Long.valueOf(r4)));
        r0.e.setText(UIUtils.getString(r3, 2131890116));
        r0.e.setTextColor(UIUtils.getColor(r0.a.getContext(), 2131102063));
        r0.e.setBackgroundResource(2131235420);
        r0.e.setOnClickListener(new g(this, r2));
    }

    @Override // com.ss.android.lark.flow.chat.view.sheet.FlowBottomSheet
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131561146, r4, false);
        Intrinsics.checkNotNull(r5);
        this.e = new c(r5);
        e();
        return r5;
    }

    public a(Activity r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "listener");
        super(r2);
        this.d = r3;
    }
}
