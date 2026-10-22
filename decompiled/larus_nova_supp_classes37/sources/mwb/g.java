package mwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.wavebar.MmAudioWaveBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public static final /* synthetic */ int h = 0;
    public final View a;
    public final MmAudioWaveBarView b;
    public final View c;
    public final View d;
    public final TextView e;
    public final ImageView f;
    public final View g;

    public static final class a {
    }

    static {
    }

    public g(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131383984);
        if (r0 == null) goto L27;
        this.b = (MmAudioWaveBarView) r0;
        View r1 = r3.findViewById(2131373884);
        if (r1 == null) goto L25;
        this.c = r1;
        View r2 = r3.findViewById(2131373885);
        if (r2 == null) goto L23;
        this.d = r2;
        View r4 = r3.findViewById(2131390023);
        if (r4 == null) goto L21;
        this.e = (TextView) r4;
        View r5 = r3.findViewById(2131375939);
        if (r5 == null) goto L19;
        this.f = (ImageView) r5;
        View r6 = r3.findViewById(2131375945);
        if (r6 == null) goto L17;
        this.g = r6;
        return;
    L17:
        throw new IllegalStateException("Required view not found, id=2131375945, type=".concat(View.class.getSimpleName()));
    L19:
        throw new IllegalStateException("Required view not found, id=2131375939, type=".concat(ImageView.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131390023, type=".concat(TextView.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131373885, type=".concat(View.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131373884, type=".concat(View.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131383984, type=MmAudioWaveBarView");
    }
}
