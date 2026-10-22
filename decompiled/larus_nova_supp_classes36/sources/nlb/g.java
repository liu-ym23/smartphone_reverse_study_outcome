package nlb;

import android.graphics.drawable.Drawable;
import com.larksuite.framework.utils.LogSafetyTools;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g {
    public VFSPath a;
    public Drawable b;
    public boolean c;
    public com.ss.android.lark.imagewidget.largeimage.transform.b d;
    public int e;
    public int f;
    public ImageUtils.ImageType g;
    public boolean h;
    public boolean i;

    public g() {
    }

    public final String toString() {
        return "path=" + LogSafetyTools.a(this.a.getRealPath()) + ",width=" + this.e + ",height=" + this.f + ",imageType=" + this.g + ",isAnimatedImage=" + this.h + ",isSecret=" + this.c + ",option=" + this.d;
    }
}
