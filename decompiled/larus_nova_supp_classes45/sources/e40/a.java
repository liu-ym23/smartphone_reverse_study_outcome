package e40;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.cloudgrouplive.core.CloudGroupLiveManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends FrameLayout {
    public ViewGroup a;
    public ImageView b;
    public TextView c;
    public ViewGroup d;
    public final CloudGroupLiveManager e;

    /* JADX INFO: renamed from: e40.a$a, reason: collision with other inner class name */
    public static final class C0227a {
    }

    static {
    }

    public a(Context r2, CloudGroupLiveManager r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "cloudGroupLiveService");
        super(r2);
        this.e = r3;
        View r4 = LayoutInflater.from(getContext()).inflate(2131567632, this);
        this.a = (ViewGroup) r4.findViewById(2131382912);
        this.b = (ImageView) r4.findViewById(2131387301);
        this.c = (TextView) r4.findViewById(2131387312);
        ViewGroup r5 = (ViewGroup) r4.findViewById(2131363771);
        this.d = r5;
        if (r5 == null) goto L6;
        r5.setOnClickListener(new c(this));
        return;
    }
}
