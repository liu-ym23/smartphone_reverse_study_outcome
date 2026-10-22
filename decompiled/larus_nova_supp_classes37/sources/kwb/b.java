package kwb;

import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSubtitleSpeakerAvatarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int e = 0;
    public final View a;
    public final MmSubtitleSpeakerAvatarView b;
    public final TextView c;
    public final TextView d;

    public static final class a {
    }

    static {
    }

    public b(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131363638);
        if (r0 == null) goto L15;
        this.b = (MmSubtitleSpeakerAvatarView) r0;
        View r1 = r3.findViewById(2131380595);
        if (r1 == null) goto L13;
        this.c = (TextView) r1;
        View r4 = r3.findViewById(2131368810);
        if (r4 == null) goto L11;
        this.d = (TextView) r4;
        return;
    L11:
        throw new IllegalStateException("Required view not found, id=2131368810, type=".concat(TextView.class.getSimpleName()));
    L13:
        throw new IllegalStateException("Required view not found, id=2131380595, type=".concat(TextView.class.getSimpleName()));
    L15:
        throw new IllegalStateException("Required view not found, id=2131363638, type=MmSubtitleSpeakerAvatarView");
    }
}
