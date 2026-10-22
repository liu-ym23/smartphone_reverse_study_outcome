package n10;

import android.view.View;
import android.widget.CompoundButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public final String a;
    public final View.OnClickListener b;
    public final CompoundButton.OnCheckedChangeListener c;
    public final boolean d;

    public h(boolean r4) {
        e r0 = e.a;
        Intrinsics.checkNotNullParameter("性能面板展示开关", "title");
        Intrinsics.checkNotNullParameter(r0, "checkedBtnListener");
        this.a = "";
        this.a = "性能面板展示开关";
        this.d = r4;
        this.c = r0;
    }

    public h(String r2, View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r3, "onItemClickListener");
        this.a = "";
        this.a = r2;
        this.b = r3;
    }
}
