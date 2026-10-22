package mwb;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSubtitleSpeakerAvatarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j {
    public static final /* synthetic */ int l = 0;
    public final View a;
    public final ConstraintLayout b;
    public final View c;
    public final ConstraintLayout d;
    public final MmSubtitleSpeakerAvatarView e;
    public final TextView f;
    public final ImageView g;
    public final View h;
    public final TextView i;
    public final TextView j;
    public final TextView k;

    public static final class a {
    }

    static {
    }

    public j(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        ConstraintLayout r0 = r3.findViewById(2131367728);
        if (r0 == null) goto L43;
        this.b = r0;
        View r1 = r3.findViewById(2131387642);
        if (r1 == null) goto L41;
        this.c = r1;
        ConstraintLayout r2 = r3.findViewById(2131371385);
        if (r2 == null) goto L39;
        this.d = r2;
        View r4 = r3.findViewById(2131387058);
        if (r4 == null) goto L37;
        this.e = (MmSubtitleSpeakerAvatarView) r4;
        View r5 = r3.findViewById(2131391985);
        if (r5 == null) goto L35;
        this.f = (TextView) r5;
        View r6 = r3.findViewById(2131371386);
        if (r6 == null) goto L33;
        this.g = (ImageView) r6;
        View r7 = r3.findViewById(2131375688);
        if (r7 == null) goto L31;
        this.h = r7;
        View r8 = r3.findViewById(2131388654);
        if (r8 == null) goto L29;
        this.i = (TextView) r8;
        View r9 = r3.findViewById(2131375672);
        if (r9 == null) goto L27;
        this.j = (TextView) r9;
        View r10 = r3.findViewById(2131375673);
        if (r10 == null) goto L25;
        this.k = (TextView) r10;
        return;
    L25:
        throw new IllegalStateException("Required view not found, id=2131375673, type=".concat(TextView.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131375672, type=".concat(TextView.class.getSimpleName()));
    L29:
        throw new IllegalStateException("Required view not found, id=2131388654, type=".concat(TextView.class.getSimpleName()));
    L31:
        throw new IllegalStateException("Required view not found, id=2131375688, type=".concat(View.class.getSimpleName()));
    L33:
        throw new IllegalStateException("Required view not found, id=2131371386, type=".concat(ImageView.class.getSimpleName()));
    L35:
        throw new IllegalStateException("Required view not found, id=2131391985, type=".concat(TextView.class.getSimpleName()));
    L37:
        throw new IllegalStateException("Required view not found, id=2131387058, type=MmSubtitleSpeakerAvatarView");
    L39:
        throw new IllegalStateException("Required view not found, id=2131371385, type=ConstraintLayout");
    L41:
        throw new IllegalStateException("Required view not found, id=2131387642, type=".concat(View.class.getSimpleName()));
    L43:
        throw new IllegalStateException("Required view not found, id=2131367728, type=ConstraintLayout");
    }
}
