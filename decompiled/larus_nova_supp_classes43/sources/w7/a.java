package w7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends u7.a {
    @Override // u7.a
    public final View b() {
        return LayoutInflater.from(getContext()).inflate(2131558552, this.b, false);
    }

    public a(Context r10, ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "parent");
        super(r10, r11);
    }
}
