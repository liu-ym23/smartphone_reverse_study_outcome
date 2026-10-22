package com.ss.android.lark.picker.base.calendar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import h18.e;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/picker/base/calendar/EmailAvatarUtil;", "", "<init>", "()V", "getEmailAvatarBitmapByName", "Landroid/graphics/Bitmap;", "localizedDisplayName", "", "avatarSize", "", "context", "Landroid/content/Context;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class EmailAvatarUtil {
    public static final EmailAvatarUtil INSTANCE = null;

    static {
        INSTANCE = new EmailAvatarUtil();
    }

    private EmailAvatarUtil() {
    }

    @JvmStatic
    public static final Bitmap getEmailAvatarBitmapByName(String r8, float r9, Context r10) {
        Intrinsics.checkNotNullParameter(r8, "localizedDisplayName");
        Intrinsics.checkNotNullParameter(r10, "context");
        int r11 = UIUtils.dp2px(LarkContext.getApplication(), r9);
        if (TextUtils.isEmpty(r8) == false) goto L6;
        String r12 = "";
    L10:
        Bitmap r0 = Bitmap.createBitmap(r11, r11, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(r0);
        RectF r3 = new RectF(0.0f, 0.0f, r2.getWidth(), r2.getHeight());
        Paint r4 = new Paint(257);
        r4.setTypeface(e.a(r10));
        r4.setColor(-1);
        r2.drawOval(r3, r4);
        r4.setColor(UIHelper.getColor(2131103404));
        float r13 = r11;
        r2.drawRect(new RectF(r13, r13, r3.width() - r13, r3.height() - r13), r4);
        r4.setColor(-1);
        r4.setTextSize(r13 * 0.4f);
        r4.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetricsInt r14 = r4.getFontMetricsInt();
        r2.drawText(r12, r3.centerX(), (((r3.bottom + r3.top) - r14.bottom) - r14.top) / 2, r4);
        return r0;
    L6:
        if (r8.length() >= 2) goto L8;
        int r1 = r8.length();
    L9:
        r12 = r8.substring(0, r1).toUpperCase(Locale.ENGLISH);
        goto L10
    L8:
        r1 = 2;
        goto L9
    }
}
