package com.google.android.material.d;

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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static PorterDuffColorFilter a(Drawable r1, ColorStateList r2, PorterDuff.Mode r3) {
        if (r2 == null) goto L7;
        if (r3 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r2.getColorForState(r1.getState(), 0), r3);
    L7:
        return null;
    }

    public static AttributeSet a(Context r3, int r4, CharSequence r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.memorydata.plugin");
        XmlResourceParser r8 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getXml(r4);     // Catch: Throwable -> L17
    L4:
        int r0 = r8.next();     // Catch: Throwable -> L17
        if (r0 == 2) goto L8;
        if (r0 != 1) goto L4;
    L8:
        if (r0 != 2) goto L16;
        if (TextUtils.equals(r8.getName(), r7) == false) goto L14;
        return Xml.asAttributeSet(r8);
    L14:
        throw new XmlPullParserException("Must have a <" + r7 + "> start tag");     // Catch: Throwable -> L17
    L16:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L17
    L17:
        e = move-exception;
        Resources.NotFoundException r9 = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(r4));
        r9.initCause(e);
        throw r9;
    }

    public static void a(RippleDrawable r6, int r7) {
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r6.setRadius(r7);
        return;
    L10:
        RippleDrawable.class.getDeclaredMethod("setMaxRadius", new Class[]{Integer.TYPE}).invoke(r6, new Object[]{Integer.valueOf(r7)});     // Catch: Throwable -> L7
        return;
    L7:
        e = move-exception;
        throw new IllegalStateException("Couldn't set RippleDrawable radius", e);
    }
}
