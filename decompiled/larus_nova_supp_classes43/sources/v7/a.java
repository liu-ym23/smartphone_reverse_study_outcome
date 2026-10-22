package v7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends b {
    public View d;
    public TextView e;

    @Override // u7.a
    public final View b() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131558548, this.b, false);
        View r1 = r0.findViewById(2131370123);
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.d = r1;
        TextView r10 = (TextView) r0.findViewById(2131370122);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.e = r10;
        return r0;
    }

    @Override // u7.a
    public final void c() {
        super.c();
        View r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
        r0 = null;
    L6:
        r0.setVisibility(8);
    }

    @Override // u7.a
    public final void d() {
        super.d();
        View r0 = this.d;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
        r0 = null;
    L6:
        r0.setVisibility(0);
    }

    @Override // v7.b
    public final void e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "text");
        TextView r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r0 = null;
    L6:
        r0.setText(r10);
    }

    public a(Context r10, ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "parent");
        super(r10, r11);
    }
}
