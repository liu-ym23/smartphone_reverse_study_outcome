package com.obric.oui.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sr.a;
import sr.c;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\f2\b\b\u0001\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\f2\b\b\u0001\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0011J\u0017\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0011J\u0019\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/obric/oui/image/OImageAppIcon;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "enableClipToMask", "", "setClipToMask", "(Z)V", "backgroundColor", "setImageBackgroundColor", "(I)V", "backgroundColorRes", "setImageBackgroundColorRes", "strokeColor", "setStrokeColor", "strokeColorRes", "setStrokeColorRes", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "", "packageName", "setImagePackageName", "(Ljava/lang/String;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OImageAppIcon extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f13378a;

    @JvmOverloads
    public OImageAppIcon(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final void e() {
        if (getDrawable() == null) goto L19;
        Drawable r5 = getDrawable();
        if ((r5 instanceof a) == false) goto L7;
        a r10 = (a) r5;
    L8:
        if (r10 == null) goto L20;
        c r11 = this.f13378a;
        if (r11 != null) goto L13;
        boolean r12 = false;
    L15:
        if (r10.e == r12) goto L21;
        r10.e = r12;
        r10.invalidateSelf();
        return;
    L21:
        return;
    L13:
        r12 = r11.e;
        goto L15
    L20:
        return;
    L7:
        r10 = null;
        goto L8
    }

    public final void n() {
        if (getDrawable() == null) goto L27;
        Drawable r5 = getDrawable();
        Integer r10 = null;
        if ((r5 instanceof a) == false) goto L7;
        a r11 = (a) r5;
    L8:
        if (r11 == null) goto L28;
        c r12 = this.f13378a;
        if (r12 == null) goto L15;
        r10 = r12.f22002c;
    L15:
        if (Intrinsics.areEqual(r11.f21994b, r10) == true) goto L29;
        r11.f21994b = r10;
        if (r10 == null) goto L20;
        boolean r13 = true;
    L21:
        r11.f21996h = r13;
        Log.d("OImageAppIcon", Intrinsics.stringPlus("backgroundAvoidsStroke =  ", Boolean.valueOf(r13)));
        if (r10 == null) goto L25;
        r11.g.setColor(r10.intValue());
    L25:
        r11.invalidateSelf();
        return;
    L20:
        r13 = false;
        goto L21
    L29:
        return;
    L28:
        return;
    L7:
        r11 = null;
        goto L8
    }

    public final void o() {
        if (getDrawable() == null) goto L22;
        Drawable r5 = getDrawable();
        Integer r10 = null;
        if ((r5 instanceof a) == false) goto L7;
        a r11 = (a) r5;
    L8:
        if (r11 == null) goto L23;
        c r12 = this.f13378a;
        if (r12 == null) goto L14;
        r10 = r12.d;
    L14:
        if (r10 != null) goto L16;
        int r13 = ContextCompat.getColor(getContext(), R$color.oui_line_1);
    L18:
        if (r11.f21995c == r13) goto L24;
        r11.f21995c = r13;
        r11.f.setColor(r13);
        r11.invalidateSelf();
        return;
    L24:
        return;
    L16:
        r13 = r10.intValue();
        goto L18
    L23:
        return;
    L7:
        r11 = null;
        goto L8
    }

    public final void setClipToMask(boolean r5) {
        c r10 = this.f13378a;
        if (r10 == null) goto L6;
        r10.e = r5;
    L6:
        e();
    }

    public final void setImageBackgroundColor(@ColorInt int r5) {
        Integer r10 = Integer.valueOf(r5);
        c r11 = this.f13378a;
        if (r11 == null) goto L6;
        r11.f22002c = r10;
    L6:
        n();
    }

    public final void setImageBackgroundColorRes(@ColorRes int r5) {
        setImageBackgroundColor(ContextCompat.getColor(getContext(), r5));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r10) {
        Integer r5 = null;
        if (r10 != null) goto L5;
        Log.w("OImageAppIcon", "Skip wrapping because drawable is null");
        Drawable r11 = null;
    L35:
        super.setImageDrawable(r11);
        return;
    L5:
        int r12 = Build.VERSION.SDK_INT;
        if (r12 >= 33) goto L37;
        Log.w("OImageAppIcon", "Skip AppIconDrawable wrapping on API " + r12 + "; requires API 33");
        r11 = r10;
        goto L35
    L37:
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L26
        Context r14 = getContext();     // Catch: Throwable -> L26
        c r15 = this.f13378a;
        if (r15 != null) goto L12;
        Integer r16 = null;
    L13:
        if (r15 == null) goto L16;
        r5 = r15.d;     // Catch: Throwable -> L26
    L16:
        if (r5 != null) goto L19;
        int r17 = ContextCompat.getColor(getContext(), R$color.oui_line_1);     // Catch: Throwable -> L26
    L18:
        int r18 = r17;
        if (r15 != null) goto L23;
        boolean r19 = false;
    L24:
        Object r20 = Result.m124constructorimpl(new a(r14, r10, r16, r18, r19));     // Catch: Throwable -> L26
    L28:
        Throwable r21 = Result.m127exceptionOrNullimpl(r20);
        if (r21 == null) goto L31;
        Log.w("OImageAppIcon", "Failed to wrap drawable with AppIconDrawable; using original drawable", r21);
    L31:
        Object r110 = r10;
        if (Result.m127exceptionOrNullimpl(r20) != null) goto L34;
        r110 = r20;
    L34:
        r11 = (Drawable) r110;
        goto L35
    L23:
        r19 = r15.e;     // Catch: Throwable -> L26
        goto L24
    L19:
        r17 = r5.intValue();     // Catch: Throwable -> L26
        goto L18
    L12:
        r16 = r15.f22002c;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L28
    }

    public final void setImagePackageName(String r5) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        if (StringsKt.isBlank(r5) == false) goto L17;
        Log.w("OImageAppIcon", "Skip loading app icon because packageName is blank");
        return;
    L17:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        Object r11 = Result.m124constructorimpl(getContext().getPackageManager().getApplicationIcon(r5));     // Catch: Throwable -> L8
    L10:
        Throwable r12 = Result.m127exceptionOrNullimpl(r11);
        if (r12 == null) goto L14;
        Log.w("OImageAppIcon", Intrinsics.stringPlus("Failed to load application icon for packageName=", r5), r12);
    L14:
        if (Result.m131isSuccessimpl(r11) == false) goto L19;
        setImageDrawable((Drawable) r11);
        return;
    L19:
        return;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void setStrokeColor(@ColorInt int r5) {
        c r10 = this.f13378a;
        if (r10 == null) goto L6;
        r10.d = Integer.valueOf(r5);
    L6:
        o();
    }

    public final void setStrokeColorRes(@ColorRes int r5) {
        setStrokeColor(ContextCompat.getColor(getContext(), r5));
    }

    @JvmOverloads
    public OImageAppIcon(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OImageAppIcon(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OImageAppIcon(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        c r12 = f9.a.j(r5, r10, r11);
        this.f13378a = r12;
        e();
        n();
        o();
        if (r12.f22000a == OImageShape.STANDARD) goto L6;
        Log.w("OImageAppIcon", "Ignoring oui_imageShape=" + r12.f22000a + " for OImageAppIcon; adaptive icon mask is always used");
        return;
    }
}
