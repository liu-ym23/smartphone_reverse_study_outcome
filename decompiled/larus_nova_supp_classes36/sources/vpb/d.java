package vpb;

import android.graphics.drawable.Drawable;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static final /* synthetic */ int h = 0;
    public final ArrayList<xpb.b> a;
    public final ArrayList<xpb.c> b;
    public wpb.e c;
    public Drawable d;
    public IconScene e;
    public final int f;
    public final int g;

    public static final class a {
    }

    static {
    }

    public d() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.e = IconScene.UNKNOW;
        int r0 = UIUtils.dp2px(LarkContext.getApplication(), 44.0f);
        this.f = r0;
        this.g = r0;
    }
}
