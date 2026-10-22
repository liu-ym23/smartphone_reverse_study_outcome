package h6b;

import android.content.Context;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.ui.display.manager.zoom.ZoomLevel6;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.export.entity.preview.FontLevel;
import com.ss.android.lark.export.entity.preview.FontType;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: h6b.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0231a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FontType.values().length];
            r0[FontType.TITLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[FontType.HEADLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[FontType.BODY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public static boolean a(FontLevel r5) {
        if (r5 == null) goto L5;
        FontType r0 = r5.getType();
        if (r0 == null) goto L5;
    L7:
        if (r5 == null) goto L9;
        int r6 = r5.getLevel();
    L10:
        int r1 = C0231a.a[r0.ordinal()];
        if (r1 != 1) goto L13;
    L27:
        return true;
    L13:
        if (r1 == 2) goto L27;
        if (r1 == 3) goto L22;
        if (r6 == 0) goto L20;
        if (r6 == 1) goto L28;
        if (r6 == 2) goto L20;
        return false;
    L28:
        return false;
    L20:
        return true;
    L22:
        if (r6 == 0) goto L30;
        if (r6 != 1) goto L31;
        return true;
    L31:
        return false;
    L30:
        return false;
    L9:
        r6 = 0;
    L5:
        r0 = FontType.CAPTION;
        goto L7
    }

    public static LarkFont b(FontType r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, IPortraitService.TYPE);
        int r5 = C0231a.a[r3.ordinal()];
        if (r5 == 1) goto L22;
        if (r5 == 2) goto L30;
        if (r5 == 3) goto L15;
        if (r4 == 0) goto L26;
        if (r4 == 1) goto L25;
        if (r4 == 2) goto L24;
        return LarkFont.CAPTION3;
    L24:
        return LarkFont.CAPTION2;
    L25:
        return LarkFont.CAPTION1;
    L26:
        return LarkFont.CAPTION0;
    L15:
        if (r4 == 0) goto L29;
        if (r4 == 1) goto L28;
        return LarkFont.BODY2;
    L28:
        return LarkFont.BODY1;
    L29:
        return LarkFont.BODY0;
    L30:
        return LarkFont.HEADLINE;
    L22:
        return LarkFont.TITLE4;
    }

    public static float c(Context r1, FontLevel r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (r2 == null) goto L6;
        FontType r0 = r2.getType();
        if (r0 == null) goto L6;
    L7:
        if (r2 == null) goto L9;
        int r3 = r2.getLevel();
    L10:
        LarkFont r4 = b(r0, r3);
        ZoomLevel6 r5 = zz7.b.a;
        Intrinsics.checkNotNullParameter(r4, "larkFont");
        return UIUtils.dp2px(r1, zz7.b.b(r4, zz7.b.d()));
    L9:
        r3 = 0;
    L6:
        r0 = FontType.CAPTION;
        goto L7
    }
}
