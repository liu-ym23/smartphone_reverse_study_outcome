package com.obric.oui.banner;

import android.os.Build;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u000f\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J$\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0003J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/banner/OFadingPageTransformer;", "Landroidx/viewpager/widget/ViewPager$PageTransformer;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "transformColor", "", "(I)V", "getTransformColor", "()I", "checkSdk", "", "actionWithTargetApi", "Lkotlin/Function0;", "actionWithLowerApi", "transformPage", "view", "Landroid/view/View;", "position", "", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFadingPageTransformer implements ViewPager.PageTransformer, ViewPager2.PageTransformer {
    public static final a Companion = null;
    private static final int FOREGROUND_ALPHA = 255;
    private static final float MIN_ALPHA = 0.5f;
    private final int transformColor;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/banner/OFadingPageTransformer$Companion;", "", "()V", "FOREGROUND_ALPHA", "", "MIN_ALPHA", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public OFadingPageTransformer() {
        this(0, 1, null);
    }

    public OFadingPageTransformer(int r1) {
        this.transformColor = r1;
    }

    public /* synthetic */ OFadingPageTransformer(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = ZeusTransformUtils.mapRes(R.color.Transparent, TypedValues.Custom.S_COLOR, "Transparent");
    L5:
        this(r1);
    }

    private final void checkSdk(Function0<Unit> r2, Function0<Unit> r3) {
        Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r1.invoke();
        return;
    L5:
        r4.invoke();
    }

    public final int getTransformColor() {
        return this.transformColor;
    }

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer, androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(final View r5, float r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        checkSdk((Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5, this), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(AnonymousClass2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        if (r6 >= (-1.0f)) goto L7;
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r5), Function0.class, "com.obric.memorydata.plugin");
        Function0<Unit> r0 = new AnonymousClass4(r5);
    L5:
        checkSdk(r7, (Function0) ZeusTransformUtils.preCheckCast(r0, Function0.class, "com.obric.memorydata.plugin"));
        return;
    L7:
        if (r6 > 1.0f) goto L9;
        final float r8 = Math.max(0.5f, 1 - Math.abs(r6));
        checkSdk((Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass5(r5, r8), Function0.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass6(r5, r8), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        r7 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass7(r5), Function0.class, "com.obric.memorydata.plugin");
        r0 = new AnonymousClass8(r5);
        goto L5
    }
}
