package wz7;

import android.graphics.drawable.Drawable;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.AvatarType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class d {
    public final AvatarType a;
    public final Drawable b;
    public String c;
    public final AvatarModel.Size d;

    public d() {
        this(null, 3);
    }

    public d(AvatarType r1, Drawable r2) {
        this.a = r1;
        this.b = r2;
        this.d = AvatarModel.Size.MINI;
    }

    public /* synthetic */ d(AvatarType r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        r1 = AvatarType.UNKNOWN;
    L5:
        this(r1, null);
    }
}
