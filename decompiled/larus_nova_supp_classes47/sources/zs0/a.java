package zs0;

import android.widget.TextView;
import com.bytedance.android.live.base.model.user.ProfileText;
import com.bytedance.android.live.base.model.user.ProfileTextPiece;
import com.bytedance.android.live.base.model.user.ProfileTextPieceImage;
import com.bytedance.android.live.base.model.user.ProfileTextPieceString;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements b {
    public a() {
    }

    @Override // zs0.b
    public final void a(TextView r2, ProfileText r3, ProfileTextPiece r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "profileText");
        Intrinsics.checkNotNullParameter(r4, "profileTextPiece");
        ProfileTextPieceString r5 = r4.getStringValue();
        if (r5 == null) goto L5;
        String r6 = r5.getValue();
    L6:
        if (r6 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        if (r7 == true) goto L15;
        r2.setContentDescription(r6);
        return;
    L15:
        return;
    L8:
        if (r6.length() == 0) goto L11;
        r7 = false;
        goto L12
    L5:
        r6 = null;
        goto L6
    }

    @Override // zs0.b
    public final void b(HSImageView r2, ProfileText r3, ProfileTextPiece r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "profileText");
        Intrinsics.checkNotNullParameter(r4, "profileTextPiece");
        ProfileTextPieceImage r5 = r4.getImageValue();
        if (r5 == null) goto L9;
        k r6 = r5.getImageModel();
        if (r6 == null) goto L9;
        k.b r7 = r6.getImageContent();
        if (r7 == null) goto L9;
        String r8 = r7.getAccessibilityText();
    L10:
        if (r8 != null) goto L12;
    L15:
        boolean r9 = true;
    L16:
        if (r9 == true) goto L18;
        r2.setContentDescription(r8);
        return;
    L18:
        r2.setImportantForAccessibility(2);
        return;
    L12:
        if (r8.length() == 0) goto L15;
        r9 = false;
    L9:
        r8 = null;
        goto L10
    }
}
