package com.obric.oui.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001%B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\f2\b\b\u0001\u0010\u0012\u001a\u00020\u0007J\u0010\u0010\u0013\u001a\u00020\f2\b\b\u0001\u0010\u0014\u001a\u00020\u0007J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\f2\b\b\u0001\u0010\u001c\u001a\u00020\u0007J\u0010\u0010\u001d\u001a\u00020\f2\b\b\u0001\u0010\u001e\u001a\u00020\u0007J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010 \u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020\fH\u0002J\u0019\u0010\"\u001a\u00020\f2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/oui/image/OImageAppIcon;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "styleConfig", "Lcom/obric/oui/image/OImageStyleConfig;", "clearImageBackgroundColor", "", "resolveStrokeColor", "setClipToMask", "enableClipToMask", "", "setImageBackgroundColor", "backgroundColor", "setImageBackgroundColorRes", "backgroundColorRes", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setImagePackageName", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "setStrokeColor", "strokeColor", "setStrokeColorRes", "strokeColorRes", "syncClipToMask", "syncImageBackgroundColor", "syncStrokeColor", "updateImageBackgroundColor", "(Ljava/lang/Integer;)V", "wrapForAppIconStroke", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OImageAppIcon extends AppCompatImageView {
    public static final a Companion = null;
    private static final String TAG = "OImageAppIcon";
    private b styleConfig;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/image/OImageAppIcon$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public OImageAppIcon(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OImageAppIcon(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OImageAppIcon(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r12);
        b r13 = b.a.a(b.f13891a, r3, r4, r12, 0, 8, null);
        this.styleConfig = r13;
        syncClipToMask();
        syncImageBackgroundColor();
        syncStrokeColor();
        if (r13.a() == OImageShape.STANDARD) goto L6;
        Log.w(TAG, "Ignoring oui_imageShape=" + r13.a() + " for OImageAppIcon; adaptive icon mask is always used");
        return;
    }

    public /* synthetic */ OImageAppIcon(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void syncClipToMask() {
        if (getDrawable() == null) goto L16;
        Drawable r0 = getDrawable();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.image.a.class) == false) goto L7;
        com.obric.oui.image.a r1 = (com.obric.oui.image.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.image.a.class, "com.obric.memorydata.plugin");
    L8:
        if (r1 == null) goto L17;
        b r3 = this.styleConfig;
        if (r3 != null) goto L13;
        boolean r4 = false;
    L14:
        r1.a(r4);
        return;
    L13:
        r4 = r3.e();
        goto L14
    L17:
        return;
    L7:
        r1 = null;
        goto L8
    }

    private final void syncImageBackgroundColor() {
        if (getDrawable() == null) goto L16;
        Drawable r0 = getDrawable();
        Integer r2 = null;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.image.a.class) == false) goto L7;
        com.obric.oui.image.a r1 = (com.obric.oui.image.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.image.a.class, "com.obric.memorydata.plugin");
    L8:
        if (r1 == null) goto L17;
        b r4 = this.styleConfig;
        if (r4 == null) goto L14;
        r2 = r4.c();
    L14:
        r1.a(r2);
        return;
    L17:
        return;
    L7:
        r1 = null;
        goto L8
    }

    private final void syncStrokeColor() {
        if (getDrawable() == null) goto L12;
        Drawable r0 = getDrawable();
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.image.a.class) == false) goto L7;
        com.obric.oui.image.a r1 = (com.obric.oui.image.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.image.a.class, "com.obric.memorydata.plugin");
    L8:
        if (r1 == null) goto L13;
        r1.a(resolveStrokeColor());
        return;
    L13:
        return;
    L7:
        r1 = null;
        goto L8
    }

    private final void updateImageBackgroundColor(Integer r2) {
        b r0 = this.styleConfig;
        if (r0 == null) goto L6;
        r0.a(r2);
    L6:
        syncImageBackgroundColor();
    }

    private final Drawable wrapForAppIconStroke(Drawable r14) {
        Integer r1 = null;
        if (r14 != null) goto L7;
        Log.w(TAG, "Skip wrapping because drawable is null");
        return null;
    L7:
        if (Build.VERSION.SDK_INT >= 33) goto L31;
        Log.w(TAG, "Skip AppIconDrawable wrapping on API " + Build.VERSION.SDK_INT + "; requires API 33");
        return r14;
    L31:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
        OImageAppIcon r13 = (OImageAppIcon) ZeusTransformUtils.preCheckCast(this, OImageAppIcon.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullExpressionValue(r4, "context");     // Catch: Throwable -> L21
        b r5 = r13.styleConfig;     // Catch: Throwable -> L21
        if (r5 == null) goto L14;
        r1 = r5.c();     // Catch: Throwable -> L21
    L14:
        Integer r6 = r1;
        int r7 = r13.resolveStrokeColor();     // Catch: Throwable -> L21
        b r15 = r13.styleConfig;     // Catch: Throwable -> L21
        if (r15 != null) goto L18;
        boolean r16 = false;
    L19:
        Object r17 = Result.m1421constructorimpl(new com.obric.oui.image.a(r4, r14, r6, r7, 0.0f, r16, 16, null));     // Catch: Throwable -> L21
    L23:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r17);
        if (r2 == null) goto L26;
        Log.w(TAG, "Failed to wrap drawable with AppIconDrawable; using original drawable", r2);
    L26:
        Object r18 = r14;
        if (Result.m1424exceptionOrNullimpl(r17) != null) goto L30;
        r18 = r17;
    L30:
        return (Drawable) ZeusTransformUtils.preCheckCast(r18, Drawable.class, "com.obric.memorydata.plugin");
    L18:
        r16 = r15.e();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    public final void clearImageBackgroundColor() {
        updateImageBackgroundColor(null);
    }

    public final int resolveStrokeColor() {
        b r0 = this.styleConfig;
        if (r0 != null) goto L5;
        Integer r1 = null;
    L6:
        if (r1 != null) goto L9;
        return ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_line_1, TypedValues.Custom.S_COLOR, "oui_line_1"));
    L9:
        return r1.intValue();
    L5:
        r1 = r0.d();
        goto L6
    }

    public final void setClipToMask(boolean r2) {
        b r0 = this.styleConfig;
        if (r0 == null) goto L6;
        r0.a(r2);
    L6:
        syncClipToMask();
    }

    public final void setImageBackgroundColor(int r1) {
        updateImageBackgroundColor(Integer.valueOf(r1));
    }

    public final void setImageBackgroundColorRes(int r4) {
        setImageBackgroundColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r1) {
        super.setImageDrawable(wrapForAppIconStroke(r1));
    }

    public final void setImagePackageName(String r6) {
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L17;
        Log.w(TAG, "Skip loading app icon because packageName is blank");
        return;
    L17:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r1 = Result.m1421constructorimpl(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((OImageAppIcon) ZeusTransformUtils.preCheckCast(this, OImageAppIcon.class, "com.obric.memorydata.plugin")).getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getApplicationIcon(r6));     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r1);
        if (r3 == null) goto L14;
        Log.w(TAG, Intrinsics.stringPlus("Failed to load application icon for packageName=", r6), r3);
    L14:
        if (Result.m1428isSuccessimpl(r1) == false) goto L19;
        setImageDrawable((Drawable) ZeusTransformUtils.preCheckCast(r1, Drawable.class, "com.obric.memorydata.plugin"));
        return;
    L19:
        return;
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void setStrokeColor(int r2) {
        b r0 = this.styleConfig;
        if (r0 == null) goto L6;
        r0.b(Integer.valueOf(r2));
    L6:
        syncStrokeColor();
    }

    public final void setStrokeColorRes(int r4) {
        setStrokeColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }
}
