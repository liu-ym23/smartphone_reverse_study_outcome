package mwb;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i {
    public static final /* synthetic */ int f = 0;
    public final View a;
    public final RecyclerView b;
    public final View c;
    public final UDShadowLayout d;
    public final AppCompatImageView e;

    public static final class a {
    }

    static {
    }

    public i(View r2) {
        Intrinsics.checkNotNullParameter(r2, "root");
        this.a = r2;
        RecyclerView r0 = r2.findViewById(2131387643);
        if (r0 == null) goto L15;
        this.b = r0;
        this.c = r2.findViewById(2131387641);
        UDShadowLayout r1 = r2.findViewById(2131363767);
        if (r1 == null) goto L13;
        this.d = r1;
        AppCompatImageView r3 = r2.findViewById(2131363768);
        if (r3 == null) goto L11;
        this.e = r3;
        return;
    L11:
        throw new IllegalStateException("Required view not found, id=2131363768, type=AppCompatImageView");
    L13:
        throw new IllegalStateException("Required view not found, id=2131363767, type=UDShadowLayout");
    L15:
        throw new IllegalStateException("Required view not found, id=2131387643, type=RecyclerView");
    }
}
