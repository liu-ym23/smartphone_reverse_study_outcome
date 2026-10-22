package im.quar.autolayout.utils;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import im.quar.autolayout.AutoLayoutInfo;
import im.quar.autolayout.ViewCreator;
import im.quar.autolayout.attr.AutoAttr;
import im.quar.autolayout.attr.DrawablePaddingAttr;
import im.quar.autolayout.attr.HeightAttr;
import im.quar.autolayout.attr.MarginAttr;
import im.quar.autolayout.attr.MarginBottomAttr;
import im.quar.autolayout.attr.MarginLeftAttr;
import im.quar.autolayout.attr.MarginRightAttr;
import im.quar.autolayout.attr.MarginTopAttr;
import im.quar.autolayout.attr.MaxHeight;
import im.quar.autolayout.attr.MaxWidth;
import im.quar.autolayout.attr.MinHeightAttr;
import im.quar.autolayout.attr.MinWidthAttr;
import im.quar.autolayout.attr.PaddingAttr;
import im.quar.autolayout.attr.PaddingBottomAttr;
import im.quar.autolayout.attr.PaddingLeftAttr;
import im.quar.autolayout.attr.PaddingRightAttr;
import im.quar.autolayout.attr.PaddingTopAttr;
import im.quar.autolayout.attr.TextSizeAttr;
import im.quar.autolayout.attr.WidthAttr;
import im.quar.autolayout.config.AutoLayoutConfig;

/* JADX INFO: loaded from: classes2.dex */
public class AutoLayoutHelper {
    private static final int INDEX_DRAWABLE_PADDING = 17;
    private static final int INDEX_HEIGHT = 7;
    private static final int INDEX_MARGIN = 8;
    private static final int INDEX_MARGIN_BOTTOM = 12;
    private static final int INDEX_MARGIN_LEFT = 9;
    private static final int INDEX_MARGIN_RIGHT = 11;
    private static final int INDEX_MARGIN_TOP = 10;
    private static final int INDEX_MAX_HEIGHT = 14;
    private static final int INDEX_MAX_WIDTH = 13;
    private static final int INDEX_MIN_HEIGHT = 16;
    private static final int INDEX_MIN_WIDTH = 15;
    private static final int INDEX_PADDING = 1;
    private static final int INDEX_PADDING_BOTTOM = 5;
    private static final int INDEX_PADDING_LEFT = 2;
    private static final int INDEX_PADDING_RIGHT = 4;
    private static final int INDEX_PADDING_TOP = 3;
    private static final int INDEX_TEXT_SIZE = 0;
    private static final int INDEX_WIDTH = 6;
    private static final int[] LL = null;
    private static final ViewCreator mDefaultViewCreator = null;
    private static ViewCreator mExtViewCreator;
    private boolean mAppliedAspectRatio;
    private boolean mHasAdjustedChildren;
    private final ViewGroup mHost;

    public interface AutoLayoutParams {
        AutoLayoutInfo getAutoLayoutInfo();
    }

    static {
        mDefaultViewCreator = new DefaultViewCreator();
        mExtViewCreator = (ViewCreator) Class.forName("im.quar.autolayout.ExtViewCreator").newInstance();     // Catch: Exception -> L6
    L4:
        LL = new int[]{R.attr.textSize, R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom, R.attr.layout_width, R.attr.layout_height, R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, R.attr.drawablePadding};
    }

    public AutoLayoutHelper(ViewGroup r8) {
        this.mHost = r8;
        AutoLayoutConfig.init(r8.getContext());
    }

    public static View createAutoLayoutView(String r8, Context r10, AttributeSet r11) {
        ViewCreator r12 = mExtViewCreator;
        if (r12 != null) goto L5;
        View r13 = null;
    L6:
        if (r13 == null) goto L8;
        return r13;
    L8:
        return mDefaultViewCreator.create(r8, r10, r11);
    L5:
        r13 = r12.create(r8, r10, r11);
        goto L6
    }

    public static AutoLayoutInfo getAutoLayoutInfo(Context r10, AttributeSet r11) {
        AutoLayoutInfo r8 = new AutoLayoutInfo();
        int r12 = r11.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "textAppearance", -1);
        TypedArray r13 = r10.obtainStyledAttributes(r11, LL);
        int r14 = r13.getIndexCount();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L30;
        int r16 = r13.getIndex(r15);
        if (isPxVal(r13.peekValue(r16)) == false) goto L29;
        int r17 = r13.getDimensionPixelOffset(r16, 0);     // Catch: Exception -> L45
        switch(r16) {
            case 0: goto L28;
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            default: goto L29;
        };
    L10:
        AutoAttr r18 = new DrawablePaddingAttr(r17);
    L27:
        r8.addAttr(r18);
        goto L29
    L11:
        r18 = new MinHeightAttr(r17);
        goto L27
    L12:
        r18 = new MinWidthAttr(r17);
        goto L27
    L13:
        r18 = new MaxHeight(r17);
        goto L27
    L14:
        r18 = new MaxWidth(r17);
        goto L27
    L15:
        r18 = new MarginBottomAttr(r17);
        goto L27
    L16:
        r18 = new MarginRightAttr(r17);
        goto L27
    L17:
        r18 = new MarginTopAttr(r17);
        goto L27
    L18:
        r18 = new MarginLeftAttr(r17);
        goto L27
    L19:
        r18 = new MarginAttr(r17);
        goto L27
    L20:
        r18 = new HeightAttr(r17);
        goto L27
    L21:
        r18 = new WidthAttr(r17);
        goto L27
    L22:
        r18 = new PaddingBottomAttr(r17);
        goto L27
    L23:
        r18 = new PaddingRightAttr(r17);
        goto L27
    L24:
        r18 = new PaddingTopAttr(r17);
        goto L27
    L25:
        r18 = new PaddingLeftAttr(r17);
        goto L27
    L26:
        r18 = new PaddingAttr(r17);
        goto L27
    L28:
        r8.addAttr(new TextSizeAttr(r17));
        r12 = -1;
    L29:
        r15 = r15 + 1;
        goto L3
    L30:
        r13.recycle();
        if (r12 <= 0) goto L36;
        TypedArray r19 = r10.obtainStyledAttributes(r12, new int[]{R.attr.textSize});
        if (isPxVal(r19.peekValue(0)) == true) goto L51;
    L35:
        r19.recycle();
        goto L36
    L51:
        r8.addAttr(new TextSizeAttr(r19.getDimensionPixelSize(0, -1)));     // Catch: Exception -> L46
    L36:
        TypedArray r20 = r10.obtainStyledAttributes(r11, im.quar.autolayout.R.styleable.AutoLayout_Layout);
        float r21 = r13.getFloat(im.quar.autolayout.R.styleable.AutoLayout_Layout_auto_aspectRatio, -1.0f);     // Catch: Exception -> L39
    L41:
        if (r21 == (-1.0f)) goto L43;
        r8.aspectRatio = r21;
    L43:
        r20.recycle();
        return r8;
    L39:
        r21 = -1.0f;
        goto L41
    }

    private static int getComplexUnit(int r8) {
        return (r8 >> 0) & 15;
    }

    private static boolean isPxVal(TypedValue r8) {
        if (r8 != null) goto L4;
        return false;
    L4:
        if (r8.type == 5) goto L6;
        return false;
    L6:
        if (getComplexUnit(r8.data) != 0) goto L12;
        return true;
    L12:
        return false;
    }

    public void adjustChildren() {
        if (this.mHasAdjustedChildren == false) goto L5;
        return;
    L5:
        int r8 = this.mHost.getChildCount();
        int r10 = 0;
    L6:
        if (r10 >= r8) goto L13;
        View r11 = this.mHost.getChildAt(r10);
        Object r12 = r11.getLayoutParams();
        if ((r12 instanceof AutoLayoutParams) == false) goto L12;
        AutoLayoutInfo r13 = ((AutoLayoutParams) r12).getAutoLayoutInfo();
        if (r13 == null) goto L12;
        r13.fillAttrs(r11);
    L12:
        r10 = r10 + 1;
        goto L6
    L13:
        this.mHasAdjustedChildren = true;
    }

    public void applyAspectRatio() {
        if (this.mAppliedAspectRatio == false) goto L5;
        return;
    L5:
        int r8 = this.mHost.getChildCount();
        int r10 = 0;
    L6:
        if (r10 >= r8) goto L13;
        View r11 = this.mHost.getChildAt(r10);
        Object r12 = r11.getLayoutParams();
        if ((r12 instanceof AutoLayoutParams) == false) goto L12;
        AutoLayoutInfo r13 = ((AutoLayoutParams) r12).getAutoLayoutInfo();
        if (r13 == null) goto L12;
        r13.applyAspectRatio(r11);
    L12:
        r10 = r10 + 1;
        goto L6
    L13:
        this.mAppliedAspectRatio = true;
    }
}
