package com.obric.oui.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 {2\u00020\u0001:\u0007{|}~\u007f\u0080\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u0007H'J\b\u0010Z\u001a\u00020[H&J\b\u0010\\\u001a\u00020XH\u0014J\b\u0010]\u001a\u00020XH$J\b\u0010^\u001a\u00020XH$J\b\u0010_\u001a\u00020XH$J\b\u0010`\u001a\u00020XH$J\b\u0010a\u001a\u00020\u0007H\u0004J\b\u0010b\u001a\u00020XH\u0002J\u0010\u0010c\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u0007H&J\u0006\u0010d\u001a\u00020XJ\b\u0010e\u001a\u00020XH\u0004J\b\u0010f\u001a\u00020XH\u0004J\b\u0010g\u001a\u00020XH\u0004J\b\u0010h\u001a\u00020XH\u0002J\b\u0010i\u001a\u00020XH&J\u0010\u0010j\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u0007H'J\b\u0010k\u001a\u00020XH\u0004J\u000e\u0010l\u001a\u00020X2\u0006\u0010m\u001a\u00020\u0007J\u000e\u0010n\u001a\u00020X2\u0006\u0010o\u001a\u00020\u0007J&\u0010p\u001a\u00020X2\u0006\u0010o\u001a\u00020\u00072\b\b\u0002\u0010m\u001a\u00020\u00072\n\b\u0002\u0010q\u001a\u0004\u0018\u00010rH\u0007J\u0010\u0010s\u001a\u00020X2\u0006\u0010t\u001a\u00020uH\u0007J\u001c\u0010s\u001a\u00020X2\u0006\u0010t\u001a\u00020u2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070vJ\u0016\u0010s\u001a\u00020X2\u0006\u0010t\u001a\u00020u2\u0006\u0010o\u001a\u00020\u0007J\u001c\u0010w\u001a\u00020X2\u0006\u0010t\u001a\u00020x2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020\u00070vJ\u0016\u0010w\u001a\u00020X2\u0006\u0010t\u001a\u00020x2\u0006\u0010o\u001a\u00020\u0007J\u0014\u0010y\u001a\u00020\u0007*\u00020\u00072\u0006\u0010z\u001a\u00020\u0007H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00078TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R$\u0010(\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R&\u0010+\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u001eR$\u0010.\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R$\u00101\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\u0012\u00104\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u00105R\u0012\u00106\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u00105R\u001a\u00107\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R$\u0010:\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0011\"\u0004\b<\u0010\u001eR(\u0010>\u001a\u0004\u0018\u00010=2\b\u0010\u001a\u001a\u0004\u0018\u00010=@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u0004\u0018\u00010C2\b\u0010\u001a\u001a\u0004\u0018\u00010C@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0017\"\u0004\bM\u0010\u0019R$\u0010N\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010\u0011\"\u0004\bP\u0010\u001eR$\u0010Q\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0011\"\u0004\bS\u0010\u001eR$\u0010T\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010\u0011\"\u0004\bV\u0010\u001e¨\u0006\u0081\u0001"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "custom", "Lcom/obric/oui/indicator/OBaseIndicator$CustomDot;", "getCustom", "()Lcom/obric/oui/indicator/OBaseIndicator$CustomDot;", "defaultSidePadding", "getDefaultSidePadding", "()I", "defaultVerticalSidePadding", "getDefaultVerticalSidePadding", "dotsClickable", "", "getDotsClickable", "()Z", "setDotsClickable", "(Z)V", EventBody.KEY_VALUE, "dotsColor", "getDotsColor", "setDotsColor", "(I)V", "", "dotsCornerRadius", "getDotsCornerRadius", "()F", "setDotsCornerRadius", "(F)V", "dotsHeight", "getDotsHeight", "setDotsHeight", "dotsSpacing", "getDotsSpacing", "setDotsSpacing", "dotsStrokeColor", "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeWidth", "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsWidth", "getDotsWidth", "setDotsWidth", "explicitSidePadding", "Ljava/lang/Integer;", "explicitVerticalSidePadding", "initialized", "getInitialized", "setInitialized", "layoutHeight", "getLayoutHeight", "setLayoutHeight", "Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "pager", "getPager", "()Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "setPager", "(Lcom/obric/oui/indicator/OBaseIndicator$Pager;)V", "Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "pagerDataSetObserver", "setPagerDataSetObserver", "(Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;)V", "pendingRefreshDots", "pendingRefreshDotsDraws", "pendingRefreshDotsSize", "pendingRefreshDotsSpacing", "pendingRefreshParentLayout", "getPendingRefreshParentLayout", "setPendingRefreshParentLayout", "sidePadding", "getSidePadding", "setSidePadding", "type", "getType", "setType", "verticalSidePadding", "getVerticalSidePadding", "setVerticalSidePadding", "addDot", "", "index", "buildOnPageChangedListener", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "onAttachedToWindow", "onRefreshDotsDraws", "onRefreshDotsSize", "onRefreshDotsSpacing", "onRefreshIndicator", "pagerCount", "postPendingRefresh", "refreshDotDraw", "refreshDots", "refreshDotsDraws", "refreshDotsSize", "refreshDotsSpacing", "refreshOnPageChangedListener", "refreshParentLayout", "removeDot", "setInitComplete", "setManualCurrentItem", "currentItem", "setManualPageCount", "pageCount", "setManualPager", "onPageSelected", "Lcom/obric/oui/indicator/OBaseIndicator$OnManualPageSelectedListener;", "setViewPager", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "Lkotlin/Function0;", "setViewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "mod", "num", "Companion", "CustomDot", "ManualPager", "OnManualPageSelectedListener", "Pager", "ReleaseMe", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OBaseIndicator extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13932a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13933b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private float i;
    private float j;
    private int k;
    private Integer l;
    private Integer m;
    private float n;
    private int o;
    private int p;
    private float q;
    private boolean r;
    private int s;
    private float t;
    private e u;
    private f v;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$Companion;", "", "()V", "DEFAULT_SIDE_PADDING_DP", "", "DEFAULT_VERTICAL_SIDE_PADDING_DP", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\t\u0012\b\b\u0001\u0010\f\u001a\u00020\t\u0012\b\b\u0001\u0010\r\u001a\u00020\t\u0012\b\b\u0001\u0010\u000e\u001a\u00020\t\u0012\b\b\u0001\u0010\u000f\u001a\u00020\t\u0012\b\b\u0001\u0010\u0010\u001a\u00020\t\u0012\b\b\u0001\u0010\u0011\u001a\u00020\t\u0012\b\b\u0001\u0010\u0012\u001a\u00020\t¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\tHÆ\u0003J\t\u0010/\u001a\u00020\tHÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\u0095\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0003\u0010\f\u001a\u00020\t2\b\b\u0003\u0010\r\u001a\u00020\t2\b\b\u0003\u0010\u000e\u001a\u00020\t2\b\b\u0003\u0010\u000f\u001a\u00020\t2\b\b\u0003\u0010\u0010\u001a\u00020\t2\b\b\u0003\u0010\u0011\u001a\u00020\t2\b\b\u0003\u0010\u0012\u001a\u00020\tHÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\tHÖ\u0001J\t\u00108\u001a\u000209HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019¨\u0006:"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$CustomDot;", "", "defaultWidth", "", "defaultHeight", "defaultSpacing", "styleableId", "", "typeId", "", "layoutHeightId", "dotsWidthId", "dotsHeightId", "dotsSpacingId", "dotsColorId", "dotsCornerRadiusId", "dotsClickableId", "dotsStrokeColorId", "dotsStrokeWidthId", "(FFF[IIIIIIIIIII)V", "getDefaultHeight", "()F", "getDefaultSpacing", "getDefaultWidth", "getDotsClickableId", "()I", "getDotsColorId", "getDotsCornerRadiusId", "getDotsHeightId", "getDotsSpacingId", "getDotsStrokeColorId", "getDotsStrokeWidthId", "getDotsWidthId", "getLayoutHeightId", "getStyleableId", "()[I", "getTypeId", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f13934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f13935b;
        private final float c;
        private final int[] d;
        private final int e;
        private final int f;
        private final int g;
        private final int h;
        private final int i;
        private final int j;
        private final int k;
        private final int l;
        private final int m;
        private final int n;

        public b(float r2, float r3, float r4, int[] r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
            Intrinsics.checkNotNullParameter(r5, "styleableId");
            this.f13934a = r2;
            this.f13935b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
            this.n = r15;
        }

        public final float a() {
            return this.f13934a;
        }

        public final float b() {
            return this.f13935b;
        }

        public final float c() {
            return this.c;
        }

        public final int[] d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(Float.valueOf(this.f13934a), Float.valueOf(r6.f13934a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f13935b), Float.valueOf(r6.f13935b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (this.l == r6.l) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L50;
            return false;
        L50:
            return true;
        }

        public final int f() {
            return this.f;
        }

        public final int g() {
            return this.g;
        }

        public final int h() {
            return this.h;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((Float.hashCode(this.f13934a) * 31) + Float.hashCode(this.f13935b)) * 31) + Float.hashCode(this.c)) * 31) + Arrays.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31) + Integer.hashCode(this.l)) * 31) + Integer.hashCode(this.m)) * 31) + Integer.hashCode(this.n);
        }

        public final int i() {
            return this.i;
        }

        public final int j() {
            return this.j;
        }

        public final int k() {
            return this.k;
        }

        public final int l() {
            return this.l;
        }

        public final int m() {
            return this.m;
        }

        public final int n() {
            return this.n;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("CustomDot(defaultWidth=").append(this.f13934a).append(", defaultHeight=").append(this.f13935b).append(", defaultSpacing=").append(this.c).append(", styleableId=").append(Arrays.toString(this.d)).append(", typeId=").append(this.e).append(", layoutHeightId=").append(this.f).append(", dotsWidthId=").append(this.g).append(", dotsHeightId=").append(this.h).append(", dotsSpacingId=").append(this.i).append(", dotsColorId=").append(this.j).append(", dotsCornerRadiusId=").append(this.k).append(", dotsClickableId=");
            r0.append(this.l).append(", dotsStrokeColorId=").append(this.m).append(", dotsStrokeWidthId=").append(this.n).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003R\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$ManualPager;", "Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "pageCount", "", "currentItem", "pageSelectedListener", "Lcom/obric/oui/indicator/OBaseIndicator$OnManualPageSelectedListener;", "(Lcom/obric/oui/indicator/OBaseIndicator;IILcom/obric/oui/indicator/OBaseIndicator$OnManualPageSelectedListener;)V", "<set-?>", CommonConsts.COUNT_TYPE, "getCount", "()I", "getCurrentItem", "isEmpty", "", "()Z", "isNotEmpty", "onPageChangeListenerHelper", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "addOnPageChangeListener", "", "notifyCurrentItemChanged", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "updateCurrentItem", "updatePageCount", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f13936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f13937b;
        private com.obric.oui.indicator.e c;
        private int d;
        private int e;

        public c(OBaseIndicator r3, int r4, int r5, d r6) {
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "this$0");
            this.f13936a = r3;
            this.f13937b = r7;
            if (r4 <= 0) goto L12;
            boolean r8 = false;
            if (r5 < 0) goto L8;
            if (r5 >= r4) goto L8;
            r8 = true;
        L8:
            if (r8 == true) goto L12;
            String r2 = "setManualPager requires currentItem in 0 until pageCount, currentItem=" + r5 + " pageCount=" + r4;
            com.obric.oui.c.a.b.d(OBaseIndicator.a(r3), r2);
            throw new IllegalArgumentException(r2);
        L12:
            this.d = r4;
            this.e = r5;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public int a() {
            return this.d;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public void a(int r1, boolean r2) {
            if (b(r1) == true) goto L5;
            return;
        L5:
            e();
            d r3 = this.f13937b;
            if (r3 == null) goto L10;
            r3.a(b());
            return;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public void a(com.obric.oui.indicator.e r2) {
            Intrinsics.checkNotNullParameter(r2, "onPageChangeListenerHelper");
            this.c = r2;
        }

        public final boolean a(int r4) {
            if (r4 < 0) goto L25;
            if (r4 > 0) goto L10;
            if (b() == 0) goto L10;
            String r5 = "setManualPageCount requires currentItem=0 when pageCount=" + r4 + ", currentItem=" + b();
            com.obric.oui.c.a.b.d(OBaseIndicator.a(this.f13936a), r5);
            throw new IllegalArgumentException(r5);
        L10:
            if (r4 <= 0) goto L21;
            int r2 = b();
            if (r2 < 0) goto L15;
            if (r2 >= r4) goto L15;
            boolean r3 = true;
        L16:
            if (r3 == true) goto L21;
            String r6 = "setManualPageCount requires currentItem in 0 until pageCount, currentItem=" + b() + " pageCount=" + r4;
            com.obric.oui.c.a.b.d(OBaseIndicator.a(this.f13936a), r6);
            throw new IllegalArgumentException(r6);
        L15:
            r3 = false;
        L21:
            if (a() != r4) goto L23;
            return false;
        L23:
            this.d = r4;
            return true;
        L25:
            String r7 = Intrinsics.stringPlus("setManualPageCount requires pageCount >= 0, pageCount=", Integer.valueOf(r4));
            com.obric.oui.c.a.b.d(OBaseIndicator.a(this.f13936a), r7);
            throw new IllegalArgumentException(r7);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public int b() {
            return this.e;
        }

        public final boolean b(int r4) {
            if (a() > 0) goto L9;
            if (r4 == 0) goto L9;
            String r5 = "ManualPager requires currentItem=0 when pageCount=" + a() + ", currentItem=" + r4;
            com.obric.oui.c.a.b.d(OBaseIndicator.a(this.f13936a), r5);
            throw new IllegalArgumentException(r5);
        L9:
            if (a() <= 0) goto L20;
            if (r4 >= 0) goto L12;
        L14:
            boolean r0 = false;
        L15:
            if (r0 == true) goto L20;
            String r6 = "ManualPager requires currentItem in 0 until pageCount, currentItem=" + r4 + " pageCount=" + a();
            com.obric.oui.c.a.b.d(OBaseIndicator.a(this.f13936a), r6);
            throw new IllegalArgumentException(r6);
        L12:
            if (r4 >= a()) goto L14;
            r0 = true;
        L20:
            if (b() != r4) goto L22;
            return false;
        L22:
            this.e = r4;
            return true;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public boolean c() {
            if (a() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public void d() {
            this.c = null;
        }

        public final void e() {
            com.obric.oui.indicator.e r0 = this.c;
            if (r0 != null) goto L5;
        L7:
            this.f13936a.h();
            return;
        L5:
            if (c() == false) goto L7;
            r0.a(b(), 0.0f);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$OnManualPageSelectedListener;", "", "onPageSelected", "", "position", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface d {
        void a(int r1);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\rH&J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u000b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$Pager;", "", CommonConsts.COUNT_TYPE, "", "getCount", "()I", "currentItem", "getCurrentItem", "isEmpty", "", "()Z", "isNotEmpty", "addOnPageChangeListener", "", "onPageChangeListenerHelper", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface e {
        int a();

        void a(int r1, boolean r2);

        void a(com.obric.oui.indicator.e r1);

        int b();

        boolean c();

        void d();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "", "releaseAction", "Lkotlin/Function1;", "", "getReleaseAction", "()Lkotlin/jvm/functions/Function1;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface f {
        Function1<f, Unit> getReleaseAction();
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"com/obric/oui/indicator/OBaseIndicator$setViewPager$2", "Landroid/database/DataSetObserver;", "Lcom/obric/oui/indicator/OBaseIndicator$ReleaseMe;", "releaseAction", "Lkotlin/Function1;", "", "getReleaseAction", "()Lkotlin/jvm/functions/Function1;", "onChanged", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g extends DataSetObserver implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f13938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPager f13939b;

        g(OBaseIndicator r1, ViewPager r2) {
            this.f13938a = r1;
            this.f13939b = r2;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.f
        public Function1<f, Unit> getReleaseAction() {
            final ViewPager r2 = this.f13939b;
            return (Function1) ZeusTransformUtils.preCheckCast(new OBaseIndicator$setViewPager$2$releaseAction$1(r2), Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            this.f13938a.h();
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"com/obric/oui/indicator/OBaseIndicator$setViewPager$3", "Lcom/obric/oui/indicator/OBaseIndicator$Pager;", CommonConsts.COUNT_TYPE, "", "getCount", "()I", "currentItem", "getCurrentItem", "isEmpty", "", "()Z", "isNotEmpty", "onPageChangeListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "getOnPageChangeListener", "()Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "setOnPageChangeListener", "(Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;)V", "addOnPageChangeListener", "", "onPageChangeListenerHelper", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class h implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager f13940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f13941b;
        final /* synthetic */ Function0<Integer> c;
        private ViewPager.OnPageChangeListener d;

        h(ViewPager r3, OBaseIndicator r4, Function0<Integer> r5) {
            Function0<Integer> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            this.f13940a = r3;
            this.f13941b = r4;
            this.c = r6;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public int a() {
            return ((Number) ZeusTransformUtils.preCheckCast(this.c.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue();
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public void a(int r1, boolean r2) {
            this.f13940a.setCurrentItem(r1, r2);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public void a(final com.obric.oui.indicator.e r3) {
            Intrinsics.checkNotNullParameter(r3, "onPageChangeListenerHelper");
            final OBaseIndicator r1 = this.f13941b;
            ViewPager.OnPageChangeListener r4 = (ViewPager.OnPageChangeListener) ZeusTransformUtils.preCheckCast(new OBaseIndicator$setViewPager$3$addOnPageChangeListener$1(r3, r1, this), ViewPager.OnPageChangeListener.class, "com.obric.memorydata.plugin");
            this.d = r4;
            ViewPager r2 = this.f13940a;
            Intrinsics.checkNotNull(r4);
            r2.addOnPageChangeListener(r4);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public int b() {
            return OBaseIndicator.a(this.f13941b, this.f13940a.getCurrentItem(), a());
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public boolean c() {
            return com.obric.oui.indicator.a.a(this.f13940a);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public void d() {
            ViewPager.OnPageChangeListener r0 = this.d;
            if (r0 == null) goto L7;
            this.f13940a.removeOnPageChangeListener(r0);
            return;
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0014\u0010\u000b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"com/obric/oui/indicator/OBaseIndicator$setViewPager2$3", "Lcom/obric/oui/indicator/OBaseIndicator$Pager;", CommonConsts.COUNT_TYPE, "", "getCount", "()I", "currentItem", "getCurrentItem", "isEmpty", "", "()Z", "isNotEmpty", "onPageChangeListener", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "getOnPageChangeListener", "()Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "setOnPageChangeListener", "(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;)V", "addOnPageChangeListener", "", "onPageChangeListenerHelper", "Lcom/obric/oui/indicator/OnPageChangeListenerHelper;", "removeOnPageChangeListener", "setCurrentItem", "item", "smoothScroll", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class i implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewPager2 f13942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f13943b;
        final /* synthetic */ Function0<Integer> c;
        private ViewPager2.OnPageChangeCallback d;

        i(ViewPager2 r3, OBaseIndicator r4, Function0<Integer> r5) {
            Function0<Integer> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            this.f13942a = r3;
            this.f13943b = r4;
            this.c = r6;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public int a() {
            return ((Number) ZeusTransformUtils.preCheckCast(this.c.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue();
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public void a(int r1, boolean r2) {
            this.f13942a.setCurrentItem(r1, r2);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public void a(final com.obric.oui.indicator.e r3) {
            Intrinsics.checkNotNullParameter(r3, "onPageChangeListenerHelper");
            final OBaseIndicator r1 = this.f13943b;
            ViewPager2.OnPageChangeCallback r4 = (ViewPager2.OnPageChangeCallback) ZeusTransformUtils.preCheckCast(new OBaseIndicator$setViewPager2$3$addOnPageChangeListener$1(r3, r1, this), ViewPager2.OnPageChangeCallback.class, "com.obric.memorydata.plugin");
            this.d = r4;
            ViewPager2 r2 = this.f13942a;
            Intrinsics.checkNotNull(r4);
            r2.registerOnPageChangeCallback(r4);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public int b() {
            return OBaseIndicator.a(this.f13943b, this.f13942a.getCurrentItem(), a());
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public boolean c() {
            if (((ViewGroup) ZeusTransformUtils.preCheckCast(this.f13942a, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount() == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.e
        public void d() {
            ViewPager2.OnPageChangeCallback r0 = this.d;
            if (r0 == null) goto L7;
            this.f13942a.unregisterOnPageChangeCallback(r0);
            return;
        }
    }

    static {
        f13932a = new a(null);
    }

    public OBaseIndicator(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBaseIndicator(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OBaseIndicator(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r8);
        this.f13933b = "OBaseIndicator";
        this.i = getCustom().a();
        this.j = getCustom().b();
        this.k = -2;
        this.n = getCustom().c();
        this.p = ContextCompat.getColor(r9, ZeusTransformUtils.mapRes(R.color.oui_text_4, TypedValues.Custom.S_COLOR, "oui_text_4"));
        this.q = this.j / 2;
        this.r = true;
        this.s = ContextCompat.getColor(r9, ZeusTransformUtils.mapRes(R.color.Transparent, TypedValues.Custom.S_COLOR, "Transparent"));
        this.t = com.obric.oui.common.util.h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0);
        if (r10 == null) goto L6;
        TypedArray r11 = r9.obtainStyledAttributes(r10, getCustom().d());
        Intrinsics.checkNotNullExpressionValue(r11, "context.obtainStyledAttr…ttrs, custom.styleableId)");
        setType(r11.getInt(getCustom().e(), this.o));
        setDotsWidth(r11.getDimension(getCustom().g(), this.i));
        setDotsHeight(r11.getDimension(getCustom().h(), this.j));
        setLayoutHeight(r11.getDimensionPixelSize(getCustom().f(), -2));
        setDotsSpacing(r11.getDimension(getCustom().i(), this.n));
        setDotsColor(r11.getColor(getCustom().j(), this.p));
        setDotsCornerRadius(r11.getDimension(getCustom().k(), this.q));
        this.r = r11.getBoolean(getCustom().l(), true);
        setDotsStrokeColor(r11.getColor(getCustom().m(), this.s));
        setDotsStrokeWidth(r11.getDimension(getCustom().n(), this.t));
        r11.recycle();
        return;
    }

    public /* synthetic */ OBaseIndicator(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final int a(int r2, int r3) {
        if (r3 != 0) goto L14;
        com.obric.oui.c.a.b.d(this.f13933b, "mod num is 0");
        return r2;
    L14:
        return r2 % r3;
    L7:
        e = move-exception;
        boolean r0 = ZeusTransformUtils.instanceOf(e, ArithmeticException.class);
        String r1 = this.f13933b;
        String r4 = e.getMessage();
        if (r0 == false) goto L11;
        String r5 = "不要乱除0呀 ";
    L12:
        com.obric.oui.c.a.b.d(r1, Intrinsics.stringPlus(r5, r4));
        return r2;
    L11:
        r5 = "抓住了一个Exception并ignore, ";
        goto L12
    }

    public static final /* synthetic */ int a(OBaseIndicator r0, int r1, int r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ String a(OBaseIndicator r0) {
        return r0.f13933b;
    }

    public static /* synthetic */ void a(OBaseIndicator r2, int r3, int r4, d r5, int r6, Object r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L13;
        if ((r6 & 2) == 0) goto L8;
        r4 = 0;
    L8:
        if ((r6 & 4) == 0) goto L10;
        r8 = null;
    L10:
        r2.a(r3, r4, r8);
        return;
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setManualPager");
    }

    private static final void b(OBaseIndicator r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        boolean r1 = true;
        if (r3.c == true) goto L6;
        r3.e = true;
        return;
    L6:
        r3.e = false;
        r3.b();
        r3.k();
        r3.j();
        r3.l();
        r3.n();
        e r2 = r3.u;
        if (r2 != null) goto L10;
    L8:
        r1 = false;
    L12:
        if (r1 == false) goto L14;
        o.c((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        return;
    L14:
        o.a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin"));
        return;
    L10:
        if (r2.a() != 1) goto L8;
        goto L8
    }

    private static final void c(OBaseIndicator r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r1.d == false) goto L6;
        r1.f();
    L6:
        if (r1.e == false) goto L10;
        r1.h();
        return;
    L10:
        if (r1.g == false) goto L13;
        r1.k();
    L13:
        if (r1.f == false) goto L16;
        r1.j();
    L16:
        if (r1.h == false) goto L19;
        r1.l();
        return;
    }

    /* JADX INFO: renamed from: lambda$6sox-iJ6TQWAdxNC2wUk9OlNXIQ, reason: not valid java name */
    public static /* synthetic */ void m1315lambda$6soxiJ6TQWAdxNC2wUk9OlNXIQ(OBaseIndicator r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$ck9HB2sYuWQ_K9jnGXlblyWwlw0(OBaseIndicator r0) {
        c(r0);
    }

    private final void m() {
        post(new $$Lambda$OBaseIndicator$ck9HB2sYuWQ_K9jnGXlblyWwlw0(this));
    }

    private final void n() {
        e r0 = this.u;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.c() == true) goto L8;
        return;
    L8:
        r0.d();
        com.obric.oui.indicator.e r2 = g();
        r0.a(r2);
        r2.a(r0.b(), 0.0f);
    }

    private final void setPagerDataSetObserver(f r3) {
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
        f r0 = this.v;
        if (r0 == null) goto L9;
        Function1<f, Unit> r1 = r0.getReleaseAction();
        if (r1 == null) goto L9;
        f r2 = this.v;
        Intrinsics.checkNotNull(r2);
        r1.invoke(r2);
    L9:
        this.v = r4;
    }

    public final void a() {
        this.c = true;
    }

    public final void a(int r3, int r4, d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
        setPagerDataSetObserver(null);
        setPager((e) ZeusTransformUtils.preCheckCast(new c(this, r3, r4, r6), e.class, "com.obric.memorydata.plugin"));
        h();
    }

    public final void a(ViewPager r3, final int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        a(r3, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), Function0.class, "com.obric.memorydata.plugin"));
    }

    public final void a(ViewPager r5, Function0<Integer> r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "viewPager");
        Intrinsics.checkNotNullParameter(r7, "pageCount");
        if (r5.getAdapter() == null) goto L7;
        setPagerDataSetObserver((f) ZeusTransformUtils.preCheckCast(new g(this, r5), f.class, "com.obric.memorydata.plugin"));
        PagerAdapter r0 = r5.getAdapter();
        Intrinsics.checkNotNull(r0);
        f r2 = this.v;
        Objects.requireNonNull(r2, "null cannot be cast to non-null type android.database.DataSetObserver");
        r0.registerDataSetObserver((DataSetObserver) ZeusTransformUtils.preCheckCast(r2, DataSetObserver.class, "com.obric.memorydata.plugin"));
        setPager((e) ZeusTransformUtils.preCheckCast(new h(r5, this, r7), e.class, "com.obric.memorydata.plugin"));
        h();
        return;
    L7:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    }

    public final void a(ViewPager2 r3, final int r4) {
        Intrinsics.checkNotNullParameter(r3, "viewPager");
        a(r3, (Function0) ZeusTransformUtils.preCheckCast(new OBaseIndicator$setViewPager2$1(r4), Function0.class, "com.obric.memorydata.plugin"));
    }

    public final void a(ViewPager2 r5, Function0<Integer> r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "viewPager");
        Intrinsics.checkNotNullParameter(r7, "pageCount");
        if (r5.getAdapter() == null) goto L7;
        setPagerDataSetObserver((f) ZeusTransformUtils.preCheckCast(new OBaseIndicator$setViewPager2$2(this, r5), f.class, "com.obric.memorydata.plugin"));
        RecyclerView.Adapter r0 = r5.getAdapter();
        Intrinsics.checkNotNull(r0);
        f r2 = this.v;
        Objects.requireNonNull(r2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.AdapterDataObserver");
        r0.registerAdapterDataObserver((RecyclerView.AdapterDataObserver) ZeusTransformUtils.preCheckCast(r2, RecyclerView.AdapterDataObserver.class, "com.obric.memorydata.plugin"));
        setPager((e) ZeusTransformUtils.preCheckCast(new i(r5, this, r7), e.class, "com.obric.memorydata.plugin"));
        h();
        return;
    L7:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract com.obric.oui.indicator.e g();

    public abstract b getCustom();

    public int getDefaultSidePadding() {
        return com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 10);
    }

    public int getDefaultVerticalSidePadding() {
        return com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 7);
    }

    public final boolean getDotsClickable() {
        return this.r;
    }

    public final int getDotsColor() {
        return this.p;
    }

    public final float getDotsCornerRadius() {
        return this.q;
    }

    public final float getDotsHeight() {
        return this.j;
    }

    public final float getDotsSpacing() {
        return this.n;
    }

    public final int getDotsStrokeColor() {
        return this.s;
    }

    public final float getDotsStrokeWidth() {
        return this.t;
    }

    public final float getDotsWidth() {
        return this.i;
    }

    public final boolean getInitialized() {
        return this.c;
    }

    public final int getLayoutHeight() {
        return this.k;
    }

    public final e getPager() {
        return this.u;
    }

    public final boolean getPendingRefreshParentLayout() {
        return this.d;
    }

    public final int getSidePadding() {
        Integer r0 = this.m;
        if (r0 != null) goto L6;
        return getDefaultSidePadding();
    L6:
        return r0.intValue();
    }

    public final int getType() {
        return this.o;
    }

    public final int getVerticalSidePadding() {
        Integer r0 = this.l;
        if (r0 != null) goto L6;
        return getDefaultVerticalSidePadding();
    L6:
        return r0.intValue();
    }

    public final void h() {
        if (this.u != null) goto L6;
        return;
    L6:
        if (this.c == true) goto L9;
        this.e = true;
        return;
    L9:
        post(new $$Lambda$OBaseIndicator$6soxiJ6TQWAdxNC2wUk9OlNXIQ(this));
    }

    public final int i() {
        e r0 = this.u;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.a();
    }

    public final void j() {
        if (this.c == true) goto L6;
        this.f = true;
        return;
    L6:
        this.f = false;
        c();
    }

    public final void k() {
        if (this.c == true) goto L6;
        this.g = true;
        return;
    L6:
        this.g = false;
        d();
    }

    public final void l() {
        if (this.c == true) goto L6;
        this.h = true;
        return;
    L6:
        this.h = false;
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        m();
    }

    public final void setDotsClickable(boolean r1) {
        this.r = r1;
    }

    public final void setDotsColor(int r4) {
        if (this.o != 1) goto L6;
        r4 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_4, TypedValues.Custom.S_COLOR, "oui_on_accent_text_4"));
    L6:
        this.p = r4;
        j();
    }

    public final void setDotsCornerRadius(float r2) {
        if (this.q != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.q = r2;
        j();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setDotsHeight(float r2) {
        if (this.j != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.j = r2;
        l();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setDotsSpacing(float r2) {
        if (this.n != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.n = r2;
        k();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setDotsStrokeColor(int r2) {
        if (this.s == r2) goto L6;
        this.s = r2;
        j();
        return;
    }

    public final void setDotsStrokeWidth(float r2) {
        if (this.t != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.t = r2;
        j();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setDotsWidth(float r2) {
        if (this.i != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.i = r2;
        l();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setInitialized(boolean r1) {
        this.c = r1;
    }

    public final void setLayoutHeight(int r2) {
        if (this.k == r2) goto L6;
        this.k = r2;
        f();
        return;
    }

    public final void setManualCurrentItem(int r4) {
        e r0 = this.u;
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L5;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        com.obric.oui.c.a.b.d(this.f13933b, "setManualCurrentItem requires setManualPager before manual updates");
        throw new IllegalStateException("setManualCurrentItem requires setManualPager before manual updates");
    L8:
        if (r1.b(r4) == false) goto L13;
        r1.e();
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setManualPageCount(int r4) {
        e r0 = this.u;
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L5;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        com.obric.oui.c.a.b.d(this.f13933b, "setManualPageCount requires setManualPager before manual updates");
        throw new IllegalStateException("setManualPageCount requires setManualPager before manual updates");
    L8:
        if (r1.a(r4) == false) goto L13;
        h();
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setManualPager(int r7) {
        a(this, r7, 0, null, 6, null);
    }

    public final void setPager(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
        e r0 = this.u;
        if (r0 == null) goto L6;
        r0.d();
    L6:
        this.u = r4;
    }

    public final void setPendingRefreshParentLayout(boolean r1) {
        this.d = r1;
    }

    public final void setSidePadding(int r2) {
        Integer r0 = this.m;
        if (r0 != null) goto L6;
    L7:
        this.m = Integer.valueOf(r2);
        f();
        return;
    L6:
        if (r0.intValue() != r2) goto L7;
    }

    public final void setType(int r2) {
        if (this.o == r2) goto L6;
        this.o = r2;
        f();
        j();
        return;
    }

    public final void setVerticalSidePadding(int r2) {
        Integer r0 = this.l;
        if (r0 != null) goto L6;
    L7:
        this.l = Integer.valueOf(r2);
        f();
        return;
    L6:
        if (r0.intValue() != r2) goto L7;
    }

    @Deprecated(message = "需要 pageCount, 否则搭配banner的无限横划时可能出错", replaceWith = @ReplaceWith(expression = "setViewPager(ViewPager, Int) or setViewPager(ViewPager, () -> Int)", imports = {}))
    public final void setViewPager(ViewPager r2) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        PagerAdapter r0 = r2.getAdapter();
        if (r0 != null) goto L5;
        int r1 = 1;
    L6:
        a(r2, r1);
        return;
    L5:
        r1 = r0.getCount();
        goto L6
    }
}
