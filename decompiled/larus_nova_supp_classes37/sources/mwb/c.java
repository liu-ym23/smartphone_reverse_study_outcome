package mwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.wavebar.MmAudioWaveBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final /* synthetic */ int j = 0;
    public final View a;
    public final TextView b;
    public final MmAudioWaveBarView c;
    public final View d;
    public final View e;
    public final LinearLayout f;
    public final View g;
    public final ImageView h;
    public final View i;

    public static final class a {
    }

    static {
    }

    public c(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131390023);
        if (r0 == null) goto L35;
        this.b = (TextView) r0;
        View r1 = r3.findViewById(2131383984);
        if (r1 == null) goto L33;
        this.c = (MmAudioWaveBarView) r1;
        View r2 = r3.findViewById(2131373884);
        if (r2 == null) goto L31;
        this.d = r2;
        View r4 = r3.findViewById(2131373885);
        if (r4 == null) goto L29;
        this.e = r4;
        View r5 = r3.findViewById(2131389058);
        if (r5 == null) goto L27;
        this.f = (LinearLayout) r5;
        View r6 = r3.findViewById(2131383980);
        if (r6 == null) goto L25;
        this.g = r6;
        View r7 = r3.findViewById(2131375939);
        if (r7 == null) goto L23;
        this.h = (ImageView) r7;
        View r8 = r3.findViewById(2131375945);
        if (r8 == null) goto L21;
        this.i = r8;
        return;
    L21:
        throw new IllegalStateException("Required view not found, id=2131375945, type=".concat(View.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131375939, type=".concat(ImageView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131383980, type=".concat(View.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131389058, type=".concat(LinearLayout.class.getSimpleName()));
    L29:
        throw new IllegalStateException("Required view not found, id=2131373885, type=".concat(View.class.getSimpleName()));
    L31:
        throw new IllegalStateException("Required view not found, id=2131373884, type=".concat(View.class.getSimpleName()));
    L33:
        throw new IllegalStateException("Required view not found, id=2131383984, type=MmAudioWaveBarView");
    L35:
        throw new IllegalStateException("Required view not found, id=2131390023, type=".concat(TextView.class.getSimpleName()));
    }
}
