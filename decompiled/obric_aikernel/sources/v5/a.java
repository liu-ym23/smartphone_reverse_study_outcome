package v5;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a {
    @NonNull
    public static AttributeSet a(@NonNull Context r10, @XmlRes int r11, @NonNull CharSequence r12) {
        XmlResourceParser r13 = r10.getResources().getXml(r11);     // Catch: Throwable -> L16
    L3:
        int r14 = r13.next();     // Catch: Throwable -> L16
        if (r14 == 2) goto L7;
        if (r14 != 1) goto L3;
    L7:
        if (r14 != 2) goto L15;
        if (TextUtils.equals(r13.getName(), r12) == false) goto L13;
        return Xml.asAttributeSet(r13);
    L13:
        throw new XmlPullParserException("Must have a <" + r12 + "> start tag");     // Catch: Throwable -> L16
    L15:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L16
    L16:
        e = move-exception;
        Resources.NotFoundException r15 = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(r11));
        r15.initCause(e);
        throw r15;
    }

    @TargetApi(21)
    public static void b(@Nullable RippleDrawable r10, int r11) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r10.setRadius(r11);
        return;
    L10:
        RippleDrawable.class.getDeclaredMethod("setMaxRadius", new Class[]{Integer.TYPE}).invoke(r10, new Object[]{Integer.valueOf(r11)});     // Catch: Throwable -> L7
        return;
    L7:
        e = move-exception;
        throw new IllegalStateException("Couldn't set RippleDrawable radius", e);
    }

    @Nullable
    public static PorterDuffColorFilter c(@NonNull Drawable r10, @Nullable ColorStateList r11, @Nullable PorterDuff.Mode r12) {
        if (r11 == null) goto L7;
        if (r12 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r11.getColorForState(r10.getState(), 0), r12);
    L7:
        return null;
    }
}
