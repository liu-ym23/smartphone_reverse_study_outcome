package rbb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Context f() {
        Activity r0 = AppLifecycle.a.a.f();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return LarkContext.getApplication();
    }

    public static Bitmap a() {
        Context r0 = f();
        if (r0 == null) goto L7;
        return BitmapFactory.decodeResource(r0.getResources(), kac.a.b(2131254682));
    L7:
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    }

    public static Bitmap e(Bitmap r5) {
        Context r0 = f();
        if (r0 == null) goto L16;
        if (r5 == null) goto L16;
        Drawable r1 = AppCompatResources.getDrawable(r0, kac.a.b(2131256255));
        if (r1 != null) goto L9;
        Log.e("DOCS_ICON_BitmapHelper", "shortcutDrawable null");
    L9:
        Bitmap r6 = r5.copy(Bitmap.Config.ARGB_8888, true);
        Canvas r2 = new Canvas(r6);
        if (r1 == null) goto L12;
        r1.setBounds(0, 0, r2.getWidth(), r2.getHeight());
    L12:
        if (r1 == null) goto L14;
        r1.draw(r2);
    L14:
        Intrinsics.checkNotNull(r6);
        return r6;
    L16:
        Log.e("DOCS_ICON_BitmapHelper", "activity " + r0 + " or bitmap " + r5 + ", bitmap create fail");
        return a();
    }

    public static Bitmap b(int r4, Integer r5) {
        if (r4 <= 0) goto L4;
        Context r0 = f();
        if (r0 == null) goto L19;
        int r6 = kac.a.b(r4);
        if (idb.f.a().isEnable("ccm.bitable.use_new_gradation_logo_enable") == false) goto L10;
        Drawable r7 = AppCompatResources.getDrawable(r0, r6);
    L11:
        if (r7 == null) goto L17;
        if (r5 == null) goto L14;
        DrawableCompat.setTint(r7, ContextCompat.getColor(r0, r5.intValue()));
    L14:
        int r8 = UIUtils.dp2px(f(), 44.0f);
        Bitmap r9 = Bitmap.createBitmap(r8, r8, Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r9);
        r7.setBounds(0, 0, r1.getWidth(), r1.getHeight());
        r7.draw(r1);
        return r9;
    L17:
        return a();
    L10:
        r7 = r0.getDrawable(r6);
        goto L11
    L19:
        return a();
    L4:
        return a();
    }

    public static Bitmap c(int r6, int r7, Integer r8) {
        Context r0 = f();
        if (r0 == null) goto L19;
        Drawable r9 = AppCompatResources.getDrawable(r0, kac.a.b(r6));
        if (r9 == null) goto L17;
        if (r8 == null) goto L9;
        DrawableCompat.setTint(r9, ContextCompat.getColor(r0, r8.intValue()));
    L9:
        if (h18.f.a(r0) == true) goto L11;
    L13:
        float r10 = 1.0f;
    L14:
        int r11 = d(r0, r7, r10);
        int r12 = UIUtils.dp2px(r0, 44.0f);
        Bitmap r13 = Bitmap.createBitmap(r12, r12, Bitmap.Config.ARGB_8888);
        Canvas r1 = new Canvas(r13);
        r1.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint r2 = new Paint();
        r2.setColor(r11);
        r2.setStyle(Paint.Style.FILL_AND_STROKE);
        r2.setAntiAlias(true);
        r1.drawCircle(r1.getWidth() / 2.0f, r1.getHeight() / 2.0f, r1.getWidth() / 2.0f, r2);
        int r14 = UIUtils.dp2px(r0, 10.0f);
        r9.setBounds(r14, r14, r1.getWidth() - r14, r1.getHeight() - r14);
        r9.draw(r1);
        return r13;
    L11:
        if (kac.a.a() == true) goto L13;
        r10 = 0.2f;
        goto L14
    L17:
        return a();
    L19:
        return a();
    }

    public static int d(Context r2, int r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Configuration r0 = new Configuration(r2.getResources().getConfiguration());
        if (kac.a.a() == true) goto L5;
        r0.uiMode = 16;
    L5:
        Context r5 = r2.createConfigurationContext(r0);
        NewMiraResourcesManager.getInstance().install(r5);
        Intrinsics.checkNotNull(r5);
        return UDColorUtils.getAlphaColor(r5, r3, r4);
    }
}
