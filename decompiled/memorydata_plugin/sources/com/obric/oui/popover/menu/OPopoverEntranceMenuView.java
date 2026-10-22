package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.plugin.R;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.util.h;
import com.obric.oui.common.widget.MaxHeightNestedScrollView;
import com.obric.oui.divider.ODivider;
import com.obric.oui.popover.view.CheckableImageView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 ?2\u00020\u0001:\u0004>?@AB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010)\u001a\u00020\u0016H\u0002J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020+2\u0006\u0010,\u001a\u00020\"H\u0002J\b\u0010-\u001a\u00020\u0016H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010\u001b2\u0006\u0010/\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\u0007H\u0002J\u0010\u00101\u001a\u0004\u0018\u00010+2\u0006\u0010/\u001a\u00020\u0007J\b\u00102\u001a\u00020\u0016H\u0002J0\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0014J\u0018\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0014J\u0016\u0010<\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\"J\u0010\u0010=\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0007H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "Lcom/obric/oui/popover/menu/OPopoverMenuView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomView", "Landroid/view/View;", "bottomViewHeight", "defaultMaxHeight", "imgGetter", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "isOption", "itemHeight", "itemLayoutProcess", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "itemView", "", "itemVerticalMargin", "itemWidth", "items", "Ljava/util/ArrayList;", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;", "Lkotlin/collections/ArrayList;", "maxHeight", "popOverScroll", "Lcom/obric/oui/common/widget/MaxHeightNestedScrollView;", "tailImgGetter", "titleSingleLine", "", "topDividerVisibility", "topView", "topViewHeight", "verticalPadding", "widthConstraint", "Lkotlin/Pair;", "addPopoverItems", "applyItemEnabledState", "Lcom/obric/oui/popover/menu/PopoverMenuLinearLayout;", "enabled", "clearViews", "findItemByPosition", "position", "getAvailableItemWidth", "getItemView", "initView", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setItemEnabled", "setPopoverMaxHeight", "Builder", "Companion", "PopoverItem", "WidthLevel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPopoverEntranceMenuView extends OPopoverMenuView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14332a = null;
    private static final int u = 0;
    private static final int v = 0;
    private static final int w = 0;
    private static final int x = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function1<? super View, Unit> f14333b;
    private ArrayList<b> c;
    private View d;
    private View e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private Function1<? super Integer, ? extends Drawable> l;
    private Function1<? super Integer, ? extends Drawable> m;
    private final int n;
    private final int o;
    private Pair<Integer, Integer> p;
    private final int q;
    private int r;
    private boolean s;
    private MaxHeightNestedScrollView t;

    @Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010)\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010\u0006J±\u0001\u0010+\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\b\b\u0001\u00106\u001a\u00020\b2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010:JÇ\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010<\u001a\u00020\r2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\r2\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\n\b\u0002\u00104\u001a\u0004\u0018\u0001052:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010>J[\u0010?\u001a\u00020\u00002\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\b2\b\u0010/\u001a\u0004\u0018\u00010028\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108¢\u0006\u0002\u0010@J\u0006\u0010A\u001a\u00020\u001bJ§\u0001\u0010B\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010CJ³\u0001\u0010D\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010EJÇ\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010G\u001a\u00020\b2\b\b\u0002\u0010<\u001a\u00020\r2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0002¢\u0006\u0002\u0010HJ§\u0001\u0010F\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010IJ\u008f\u0001\u0010J\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010KJ\u009b\u0001\u0010L\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010MJ£\u0001\u0010N\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u0010<\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\r2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010OJ£\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010<\u001a\u00020\r2\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\r2:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010QJ\u000e\u0010R\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020SJ»\u0001\u0010T\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u0010<\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\r2\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\n\b\u0002\u00104\u001a\u0004\u0018\u0001052:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010UJÇ\u0001\u0010V\u001a\u00020\u00002\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u00103\u001a\u00020\r2\b\b\u0002\u0010<\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\r2\n\b\u0003\u00106\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\n\b\u0002\u00104\u001a\u0004\u0018\u0001052:\b\u0002\u00107\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u001b\u0018\u000108H\u0007¢\u0006\u0002\u0010WJ\u0010\u0010X\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010\u0006J\u0006\u0010Y\u001a\u00020ZJ\u0006\u0010[\u001a\u00020\u001bJ\u0006\u0010\\\u001a\u00020\u001bJ\u000e\u0010\f\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010^\u001a\u00020\rJ\u000e\u0010_\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010`\u001a\u00020\u001b2\u0016\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013J\u0010\u0010b\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\bH\u0007J)\u0010c\u001a\u00020\u00002!\u0010d\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0013J\u000e\u0010e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bJ\u0018\u0010f\u001a\u00020\u001b2\u0006\u0010g\u001a\u00020\b2\u0006\u0010h\u001a\u00020\bH\u0007J\u000e\u0010i\u001a\u00020\u00002\u0006\u0010j\u001a\u00020\bJ\u001e\u0010k\u001a\u00020\u001b2\u0016\u0010a\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013J\u000e\u0010l\u001a\u00020\u00002\u0006\u0010^\u001a\u00020\rJ\u000e\u0010m\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\rJ\u000e\u0010n\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\bJ\u000e\u0010o\u001a\u00020\u00002\u0006\u0010p\u001a\u00020qR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomView", "Landroid/view/View;", "bottomViewHeight", "", "getContext", "()Landroid/content/Context;", "setContext", "forceDark", "", "getForceDark", "()Z", "setForceDark", "(Z)V", "imgGetter", "Lkotlin/Function1;", "Landroid/graphics/drawable/Drawable;", "isOption", "itemHeight", "itemLayoutProcess", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "itemView", "", "itemWidth", "popoverItems", "Ljava/util/ArrayList;", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;", "Lkotlin/collections/ArrayList;", "pressedWithArrow", "tailImgGetter", "titleSingleLine", "topDividerVisibility", "topView", "topViewHeight", "widthConstraint", "Lkotlin/Pair;", "addBottomView", "view", "addCustomTitleColorPopoverItem", "imageRes", "tailImageRes", "resTint", "title", "", "subTitle", EventBody.KEY_VALUE, "isHighlighted", "badgeInfo", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;", "titleColor", "onClick", "Lkotlin/Function2;", "pos", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;ILkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addEndOptionItem", "enableCheckable", "checked", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLjava/lang/Integer;Ljava/lang/CharSequence;Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addHighlightPopoverItem", "(Ljava/lang/Integer;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addItemDivider", "addNormalEntryItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addNormalItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addPopoverItem", "optionPos", "(IZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addPopoverItemWithArrow", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addPopoverItemWithBadge", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addPopoverLeftOptionItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZZLkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addPopoverRightOptionItem", "(ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addSectionTitle", "", "addStartOptionEntryItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZZLjava/lang/Integer;Ljava/lang/CharSequence;Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addStartOptionItem", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZZLjava/lang/Integer;Ljava/lang/CharSequence;Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Lkotlin/jvm/functions/Function2;)Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder;", "addTopView", "build", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView;", "enableMultiOption", "enableOption", "isDark", "enable", "setBottomViewHeight", "setImgGetter", "getter", "setItemHeight", "setItemLayoutProcess", "process", "setItemWidth", "setItemWidthConstraint", "minWidth", "maxWidth", "setMenuWidth", "menuWidth", "setTailImgGetter", "setTitleSingleLine", "setTopDividerVisibility", "setTopViewHeight", "setWidthLevel", "level", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$WidthLevel;", "BadgeInfo", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f14334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Function1<? super View, Unit> f14335b;
        private View c;
        private View d;
        private ArrayList<b> e;
        private boolean f;
        private boolean g;
        private int h;
        private int i;
        private int j;
        private int k;
        private boolean l;
        private int m;
        private Function1<? super Integer, ? extends Drawable> n;
        private Function1<? super Integer, ? extends Drawable> o;
        private Pair<Integer, Integer> p;
        private boolean q;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0012B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;", "", "badgeType", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;", CommonConsts.COUNT_TYPE, "", "maxNumber", "(Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;II)V", "getBadgeType", "()Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;", "setBadgeType", "(Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;)V", "getCount", "()I", "setCount", "(I)V", "getMaxNumber", "setMaxNumber", "Style", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class BadgeInfo {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Style f14336a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f14337b;
            private int c;

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo$Style;", "", "(Ljava/lang/String;I)V", "DOT", "NUMBER", "ELLIPSIS", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
            public static final enum Style extends Enum<Style> {
                private static final /* synthetic */ Style[] $VALUES = null;
                public static final Style DOT = null;
                public static final Style ELLIPSIS = null;
                public static final Style NUMBER = null;

                private static final /* synthetic */ Style[] $values() {
                    return new Style[]{DOT, NUMBER, ELLIPSIS};
                }

                static {
                    DOT = new Style("DOT", 0);
                    NUMBER = new Style("NUMBER", 1);
                    ELLIPSIS = new Style("ELLIPSIS", 2);
                    $VALUES = $values();
                }

                private Style(String r1, int r2) {
                    super(r1, r2);
                }

                public static Style valueOf(String r2) {
                    return (Style) ZeusTransformUtils.preCheckCast(Enum.valueOf(Style.class, r2), Style.class, "com.obric.memorydata.plugin");
                }

                public static Style[] values() {
                    return (Style[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Style[].class, "com.obric.memorydata.plugin");
                }
            }

            public final Style a() {
                return this.f14336a;
            }

            public final int b() {
                return this.f14337b;
            }

            public final int c() {
                return this.c;
            }
        }

        public Builder(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "context");
            this.f14334a = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
            this.f14335b = (Function1) ZeusTransformUtils.preCheckCast(OPopoverEntranceMenuView$Builder$itemLayoutProcess$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
            this.e = new ArrayList();
            this.j = h.a(this.f14334a, OPopoverEntranceMenuView.a());
        }

        private final Builder a(int r18, boolean r19, Integer r20, Integer r21, Integer r22, CharSequence r23, CharSequence r24, CharSequence r25, boolean r26, BadgeInfo r27, Integer r28, Function2<? super View, ? super Integer, Unit> r29) {
            CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r24, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r25, CharSequence.class, "com.obric.memorydata.plugin");
            Function2 r12 = (Function2) ZeusTransformUtils.wrapperContextForParams(r29, Function2.class, "com.obric.memorydata.plugin");
            if (this.m <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L11;
            if (r18 != 0) goto L11;
            throw new IllegalArgumentException("option menu item 请使用 addStartOptionItem() 或者 addEndOptionItem()");
        L11:
            if (r1 == true) goto L16;
            if (r18 == 0) goto L16;
            throw new IllegalArgumentException("menu item 请不要使用 addStartOptionItem() 或者 addEndOptionItem()");
        L16:
            ArrayList<b> r15 = this.e;
            if (r20 != null) goto L19;
            int r4 = 0;
        L20:
            if (r21 != null) goto L22;
            int r5 = 0;
        L23:
            if (r22 != null) goto L25;
            int r6 = 0;
        L26:
            r15.add(new b(r18, r19, r4, r5, r6, r7, r8, r9, r26, true, r12, 0, r27, r28));
            return this;
        L25:
            r6 = r22.intValue();
            goto L26
        L22:
            r5 = r21.intValue();
            goto L23
        L19:
            r4 = r20.intValue();
            goto L20
        L5:
            r1 = false;
            goto L6
        }

        public static /* synthetic */ Builder a(Builder r11, Integer r12, Integer r13, Integer r14, CharSequence r15, CharSequence r16, CharSequence r17, boolean r18, BadgeInfo r19, Function2 r20, int r21, Object r22) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r16, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r17, CharSequence.class, "com.obric.memorydata.plugin");
            Function2<? super View, ? super Integer, Unit> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r20, Function2.class, "com.obric.memorydata.plugin");
            boolean r7 = false;
            Integer r8 = 0;
            if ((r21 & 1) == 0) goto L5;
            Integer r6 = r8;
        L7:
            if ((r21 & 2) == 0) goto L9;
            Integer r9 = r8;
        L11:
            if ((r21 & 4) != 0) goto L15;
            r8 = r14;
        L15:
            if ((r21 & 8) == 0) goto L18;
            r1 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        L18:
            if ((r21 & 16) == 0) goto L21;
            r3 = null;
        L21:
            if ((r21 & 32) == 0) goto L24;
            r4 = null;
        L24:
            if ((r21 & 64) != 0) goto L28;
            r7 = r18;
        L28:
            if ((r21 & 128) == 0) goto L30;
            BadgeInfo r2 = null;
        L32:
            if ((r21 & 256) == 0) goto L35;
            r5 = null;
        L35:
            return r11.a(r6, r9, r8, r1, r3, r4, r7, r2, r5);
        L30:
            r2 = r19;
            goto L32
        L9:
            r9 = r13;
            goto L11
        L5:
            r6 = r12;
            goto L7
        }

        public static /* synthetic */ Builder a(Builder r12, boolean r13, Integer r14, Integer r15, Integer r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20, Function2 r21, int r22, Object r23) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r17, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r18, CharSequence.class, "com.obric.memorydata.plugin");
            Function2<? super View, ? super Integer, Unit> r4 = (Function2) ZeusTransformUtils.wrapperContextForParams(r21, Function2.class, "com.obric.memorydata.plugin");
            if ((r22 & 1) == 0) goto L5;
            boolean r5 = true;
        L6:
            boolean r7 = false;
            if ((r22 & 2) == 0) goto L9;
            Integer r6 = 0;
        L11:
            if ((r22 & 4) == 0) goto L13;
            Integer r8 = 0;
        L15:
            if ((r22 & 8) == 0) goto L17;
            Integer r9 = 0;
        L19:
            if ((r22 & 16) == 0) goto L22;
            r1 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        L22:
            if ((r22 & 32) == 0) goto L25;
            r3 = null;
        L25:
            if ((r22 & 64) == 0) goto L27;
            boolean r2 = false;
        L29:
            if ((r22 & 128) != 0) goto L33;
            r7 = r20;
        L33:
            if ((r22 & 256) == 0) goto L36;
            r4 = null;
        L36:
            return r12.a(r5, r6, r8, r9, r1, r3, r2, r7, r4);
        L27:
            r2 = r19;
            goto L29
        L17:
            r9 = r16;
            goto L19
        L13:
            r8 = r15;
            goto L15
        L9:
            r6 = r14;
            goto L11
        L5:
            r5 = r13;
            goto L6
        }

        public final Builder a(WidthLevel r2) {
            Intrinsics.checkNotNullParameter(r2, "level");
            this.j = h.a(this.f14334a, r2.getValue());
            return this;
        }

        @Deprecated(message = "请使用 addNormalItem() 替代")
        public final Builder a(Integer r16, Integer r17, Integer r18, CharSequence r19, CharSequence r20, CharSequence r21, boolean r22, BadgeInfo r23, Function2<? super View, ? super Integer, Unit> r24) {
            return a(0, false, r16, r17, r18, (CharSequence) ZeusTransformUtils.wrapperContextForParams(r19, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.wrapperContextForParams(r20, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin"), r22, r23, null, (Function2) ZeusTransformUtils.wrapperContextForParams(r24, Function2.class, "com.obric.memorydata.plugin"));
        }

        @Deprecated(message = "请使用 addEndOptionItem() 替代")
        public final Builder a(boolean r16, Integer r17, Integer r18, Integer r19, CharSequence r20, CharSequence r21, boolean r22, boolean r23, Function2<? super View, ? super Integer, Unit> r24) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r20, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r9 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
            Function2<? super View, ? super Integer, Unit> r14 = (Function2) ZeusTransformUtils.wrapperContextForParams(r24, Function2.class, "com.obric.memorydata.plugin");
            if (r23 == false) goto L5;
            int r0 = 6;
        L7:
            return a(r0, r16, r17, r18, r19, r8, r9, null, r22, null, null, r14);
        L5:
            r0 = 2;
            goto L7
        }

        public final void a(int r3) {
            if (r3 < h.a(this.f14334a, OPopoverEntranceMenuView.b())) goto L5;
            WidthLevel r4 = WidthLevel.WIDTH_LEVEL_BROAD;
        L6:
            a(r4);
            return;
        L5:
            r4 = WidthLevel.WIDTH_LEVEL_STANDARD;
            goto L6
        }

        @Deprecated(message = "Use setWidthLevel instead")
        public final void a(int r1, int r2) {
            if (r2 < WidthLevel.WIDTH_LEVEL_BROAD.getValue()) goto L5;
            WidthLevel r3 = WidthLevel.WIDTH_LEVEL_BROAD;
        L6:
            a(r3);
            this.p = null;
            return;
        L5:
            r3 = WidthLevel.WIDTH_LEVEL_STANDARD;
            goto L6
        }

        public final boolean a() {
            return this.l;
        }

        public final void b() {
            this.m = 1;
        }

        public final OPopoverEntranceMenuView c() {
            OPopoverEntranceMenuView r6 = new OPopoverEntranceMenuView(this.f14334a, null, 0, 6, null);
            OPopoverEntranceMenuView.a(r6, this.e);
            r6.setPressedWithArrow(this.f);
            r6.setForceDark(a());
            OPopoverEntranceMenuView.a(r6, this.f14335b);
            OPopoverEntranceMenuView.a(r6, this.g);
            OPopoverEntranceMenuView.a(r6, this.h);
            OPopoverEntranceMenuView.b(r6, this.i);
            OPopoverEntranceMenuView.c(r6, this.k);
            OPopoverEntranceMenuView.a(r6, this.c);
            OPopoverEntranceMenuView.b(r6, this.d);
            OPopoverEntranceMenuView.d(r6, this.m);
            OPopoverEntranceMenuView.b(r6, this.n);
            OPopoverEntranceMenuView.c(r6, this.o);
            OPopoverEntranceMenuView.a(r6, this.p);
            OPopoverEntranceMenuView.b(r6, this.q);
            OPopoverEntranceMenuView.e(r6, this.j);
            OPopoverEntranceMenuView.a(r6);
            return r6;
        }

        public final Context getContext() {
            return this.f14334a;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$WidthLevel;", "", EventBody.KEY_VALUE, "", "(Ljava/lang/String;II)V", "getValue", "()I", "WIDTH_LEVEL_STANDARD", "WIDTH_LEVEL_BROAD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum WidthLevel extends Enum<WidthLevel> {
        private static final /* synthetic */ WidthLevel[] $VALUES = null;
        public static final WidthLevel WIDTH_LEVEL_BROAD = null;
        public static final WidthLevel WIDTH_LEVEL_STANDARD = null;
        private final int value;

        private static final /* synthetic */ WidthLevel[] $values() {
            return new WidthLevel[]{WIDTH_LEVEL_STANDARD, WIDTH_LEVEL_BROAD};
        }

        static {
            WIDTH_LEVEL_STANDARD = new WidthLevel("WIDTH_LEVEL_STANDARD", 0, OPopoverEntranceMenuView.a());
            WIDTH_LEVEL_BROAD = new WidthLevel("WIDTH_LEVEL_BROAD", 1, OPopoverEntranceMenuView.b());
            $VALUES = $values();
        }

        private WidthLevel(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static WidthLevel valueOf(String r2) {
            return (WidthLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(WidthLevel.class, r2), WidthLevel.class, "com.obric.memorydata.plugin");
        }

        public static WidthLevel[] values() {
            return (WidthLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WidthLevel[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Companion;", "", "()V", "DISABLED_ALPHA", "", "MAX_LINES", "", "MIN_AVAILABLE_HEIGHT_DP", "TAG", "", "WIDTH_BROAD_DP", "WIDTH_STANDARD_DP", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/\b\u0002\u0018\u0000 G2\u00020\u0001:\u0001GBÍ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012:\b\u0002\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001bJ\u0006\u0010C\u001a\u00020\u0005J\u0006\u0010D\u001a\u00020\u0005J\u0006\u0010E\u001a\u00020\u0005J\u0006\u0010F\u001a\u00020\u0005R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010!\"\u0004\b(\u0010#R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010!\"\u0004\b)\u0010#R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'RL\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010%\"\u0004\b1\u0010'R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010%\"\u0004\b9\u0010'R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00105\"\u0004\b;\u00107R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010@\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00105\"\u0004\bB\u00107¨\u0006H"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;", "", "radioOption", "", "enableCheckable", "", "imageRes", "tailImageRes", "resTint", "title", "", "subTitle", EventBody.KEY_VALUE, "isHighlighted", "isEnabled", "onClick", "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "view", "pos", "", "itemType", "badgeInfo", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;", "titleColor", "(IZIIILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZLkotlin/jvm/functions/Function2;ILcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;Ljava/lang/Integer;)V", "getBadgeInfo", "()Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;", "setBadgeInfo", "(Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$Builder$BadgeInfo;)V", "getEnableCheckable", "()Z", "setEnableCheckable", "(Z)V", "getImageRes", "()I", "setImageRes", "(I)V", "setEnabled", "setHighlighted", "getItemType", "setItemType", "getOnClick", "()Lkotlin/jvm/functions/Function2;", "setOnClick", "(Lkotlin/jvm/functions/Function2;)V", "getRadioOption", "setRadioOption", "getResTint", "setResTint", "getSubTitle", "()Ljava/lang/CharSequence;", "setSubTitle", "(Ljava/lang/CharSequence;)V", "getTailImageRes", "setTailImageRes", "getTitle", "setTitle", "getTitleColor", "()Ljava/lang/Integer;", "setTitleColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getValue", "setValue", "hasImage", "isLeftRadio", "isRadioChecked", "isRightRadio", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14338a = null;
        private static final b p = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14339b;
        private boolean c;
        private int d;
        private int e;
        private int f;
        private CharSequence g;
        private CharSequence h;
        private CharSequence i;
        private boolean j;
        private boolean k;
        private Function2<? super View, ? super Integer, Unit> l;
        private int m;
        private Builder.BadgeInfo n;
        private Integer o;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem$Companion;", "", "()V", "DIVIDER", "Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;", "getDIVIDER", "()Lcom/obric/oui/popover/menu/OPopoverEntranceMenuView$PopoverItem;", "MASK_RADIO_CHECKED", "", "MASK_RADIO_POS_LEFT", "MASK_RADIO_POS_RIGHT", "MULTI_OPTION", "SINGLE_OPTION", "TYPE_DIVIDER", "TYPE_ITEM", "TYPE_SECTION_BAR", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            f14338a = new a(null);
            p = new b(0, false, 0, 0, 0, null, null, null, false, false, null, 1, null, null, 14335, null);
        }

        public b() {
            this(0, false, 0, 0, 0, null, null, null, false, false, null, 0, null, null, 16383, null);
        }

        public b(int r8, boolean r9, int r10, int r11, int r12, CharSequence r13, CharSequence r14, CharSequence r15, boolean r16, boolean r17, Function2<? super View, ? super Integer, Unit> r18, int r19, Builder.BadgeInfo r20, Integer r21) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r13, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r14, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r15, CharSequence.class, "com.obric.memorydata.plugin");
            Function2<? super View, ? super Integer, Unit> r2 = (Function2) ZeusTransformUtils.wrapperContextForParams(r18, Function2.class, "com.obric.memorydata.plugin");
            this.f14339b = r8;
            this.c = r9;
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.g = r1;
            this.h = r3;
            this.i = r4;
            this.j = r16;
            this.k = r17;
            this.l = r2;
            this.m = r19;
            this.n = r20;
            this.o = r21;
        }

        public /* synthetic */ b(int r16, boolean r17, int r18, int r19, int r20, CharSequence r21, CharSequence r22, CharSequence r23, boolean r24, boolean r25, Function2 r26, int r27, Builder.BadgeInfo r28, Integer r29, int r30, DefaultConstructorMarker r31) {
            CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r21, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r22, CharSequence.class, "com.obric.memorydata.plugin");
            CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r23, CharSequence.class, "com.obric.memorydata.plugin");
            Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r26, Function2.class, "com.obric.memorydata.plugin");
            int r7 = 0;
            if ((r30 & 1) == 0) goto L5;
            int r6 = 0;
        L7:
            if ((r30 & 2) == 0) goto L9;
            boolean r8 = false;
        L11:
            if ((r30 & 4) == 0) goto L13;
            int r9 = 0;
        L15:
            if ((r30 & 8) == 0) goto L17;
            int r10 = 0;
        L19:
            if ((r30 & 16) == 0) goto L21;
            int r11 = 0;
        L23:
            if ((r30 & 32) == 0) goto L25;
            r1 = (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin");
        L25:
            Integer r12 = null;
            if ((r30 & 64) == 0) goto L29;
            r3 = null;
        L29:
            if ((r30 & 128) == 0) goto L32;
            r4 = null;
        L32:
            if ((r30 & 256) == 0) goto L34;
            boolean r2 = false;
        L36:
            if ((r30 & 512) == 0) goto L38;
            boolean r13 = true;
        L40:
            if ((r30 & 1024) == 0) goto L43;
            r5 = null;
        L43:
            if ((r30 & 2048) != 0) goto L47;
            r7 = r27;
        L47:
            if ((r30 & 4096) == 0) goto L49;
            Builder.BadgeInfo r14 = null;
        L51:
            if ((r30 & 8192) != 0) goto L54;
            r12 = r29;
        L54:
            this(r6, r8, r9, r10, r11, r1, r3, r4, r2, r13, r5, r7, r14, r12);
            return;
        L49:
            r14 = r28;
            goto L51
        L38:
            r13 = r25;
            goto L40
        L34:
            r2 = r24;
            goto L36
        L21:
            r11 = r20;
            goto L23
        L17:
            r10 = r19;
            goto L19
        L13:
            r9 = r18;
            goto L15
        L9:
            r8 = r17;
            goto L11
        L5:
            r6 = r16;
            goto L7
        }

        public final boolean a() {
            return this.c;
        }

        public final int b() {
            return this.d;
        }

        public final int c() {
            return this.e;
        }

        public final int d() {
            return this.f;
        }

        public final CharSequence e() {
            return this.g;
        }

        public final CharSequence f() {
            return this.h;
        }

        public final CharSequence g() {
            return this.i;
        }

        public final boolean h() {
            return this.j;
        }

        public final boolean i() {
            return this.k;
        }

        public final Function2<View, Integer, Unit> j() {
            return this.l;
        }

        public final int k() {
            return this.m;
        }

        public final Builder.BadgeInfo l() {
            return this.n;
        }

        public final Integer m() {
            return this.o;
        }

        public final boolean n() {
            if ((this.f14339b & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean o() {
            if ((this.f14339b & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public final boolean p() {
            if ((this.f14339b & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14340a = null;

        static {
            int[] r0 = new int[Builder.BadgeInfo.Style.values().length];
            r0[Builder.BadgeInfo.Style.DOT.ordinal()] = 1;
            r0[Builder.BadgeInfo.Style.NUMBER.ordinal()] = 2;
            r0[Builder.BadgeInfo.Style.ELLIPSIS.ordinal()] = 3;
            f14340a = r0;
        }
    }

    static {
        f14332a = new a(null);
        u = 184;
        v = 208;
        w = 6;
        x = 40;
    }

    public OPopoverEntranceMenuView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OPopoverEntranceMenuView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OPopoverEntranceMenuView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r5);
        this.f14333b = (Function1) ZeusTransformUtils.preCheckCast(OPopoverEntranceMenuView$itemLayoutProcess$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
        this.c = new ArrayList();
        this.i = h.a(r6, u);
        this.n = h.a(r6, 8);
        this.o = h.a(r6, 4);
        int r8 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getConfiguration().orientation;
        Resources r9 = ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin");
        if (r8 != 2) goto L5;
        int r10 = R.dimen.oui_popover_max_height_landscape;
        String r0 = "oui_popover_max_height_landscape";
    L6:
        int r11 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(r10, "dimen", r0));
        this.q = r11;
        this.r = r11;
        return;
    L5:
        r10 = R.dimen.oui_popover_max_height;
        r0 = "oui_popover_max_height";
        goto L6
    }

    public /* synthetic */ OPopoverEntranceMenuView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    public static final /* synthetic */ int a() {
        return u;
    }

    private static final void a(b r1, View r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "$item");
        Function2<View, Integer, Unit> r4 = r1.j();
        if (r4 == null) goto L7;
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        r4.invoke(r2, Integer.valueOf(r3));
        return;
    }

    private static final void a(final b r7, CheckableImageView r8, LinearLayout r9, OPopoverEntranceMenuView r10, final int r11, final View r12) {
        Intrinsics.checkNotNullParameter(r7, "$item");
        Intrinsics.checkNotNullParameter(r10, "this$0");
        if (r7.a() == false) goto L19;
        if (r8 == null) goto L19;
        boolean r0 = !r8.isChecked();
        if (r10.k != 1) goto L18;
        int r13 = r9.getChildCount();
        int r2 = 0;
    L9:
        if (r2 >= r13) goto L17;
        int r3 = r2 + 1;
        View r4 = r9.getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r4, PopoverMenuLinearLayout.class) == false) goto L16;
        CheckableImageView r5 = (CheckableImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(R.id.popover_menu_radio, OaidModel.KEY_ID, "popover_menu_radio")), CheckableImageView.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L16;
        r5.setChecked(false);
    L16:
        r2 = r3;
        goto L9
    L17:
        r8.setChecked(true);
        goto L19
    L18:
        r8.setChecked(r0);
    L19:
        r9.post(new $$Lambda$OPopoverEntranceMenuView$i5_DQLy546H5J0v7RKTtT7MM(r7, r12, r11));
    }

    public static final /* synthetic */ void a(OPopoverEntranceMenuView r0) {
        r0.c();
    }

    public static final /* synthetic */ void a(OPopoverEntranceMenuView r0, int r1) {
        r0.g = r1;
    }

    public static final /* synthetic */ void a(OPopoverEntranceMenuView r0, View r1) {
        r0.d = r1;
    }

    public static final /* synthetic */ void a(OPopoverEntranceMenuView r0, ArrayList r1) {
        r0.c = r1;
    }

    public static final /* synthetic */ void a(OPopoverEntranceMenuView r0, Pair r1) {
        r0.p = r1;
    }

    public static final /* synthetic */ void a(OPopoverEntranceMenuView r2, Function1 r3) {
        r2.f14333b = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(OPopoverEntranceMenuView r0, boolean r1) {
        r0.f = r1;
    }

    private final void a(PopoverMenuLinearLayout r1, boolean r2) {
        r1.setEnabled(r2);
        r1.setClickable(r2);
        if (r2 == false) goto L5;
        float r0 = 1.0f;
    L6:
        r1.setAlpha(r0);
        return;
    L5:
        r0 = 0.3f;
        goto L6
    }

    public static final /* synthetic */ int b() {
        return v;
    }

    public static final /* synthetic */ void b(OPopoverEntranceMenuView r0, int r1) {
        r0.h = r1;
    }

    public static final /* synthetic */ void b(OPopoverEntranceMenuView r0, View r1) {
        r0.e = r1;
    }

    public static final /* synthetic */ void b(OPopoverEntranceMenuView r2, Function1 r3) {
        r2.l = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void b(OPopoverEntranceMenuView r0, boolean r1) {
        r0.s = r1;
    }

    private final void c() {
        setOrientation(1);
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_view_popover_menu_type, "layout", "o_view_popover_menu_type"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), true, "com.obric.memorydata.plugin");
        MaxHeightNestedScrollView r0 = (MaxHeightNestedScrollView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.popover_scroll, OaidModel.KEY_ID, "popover_scroll")), MaxHeightNestedScrollView.class, "com.obric.memorydata.plugin");
        this.t = r0;
        if (r0 == null) goto L6;
        r0.setMaxHeight(this.r);
    L6:
        MaxHeightNestedScrollView r1 = this.t;
        if (r1 == null) goto L10;
        int r4 = this.n;
        r1.setPadding(0, r4, 0, r4);
    L10:
        MaxHeightNestedScrollView r2 = this.t;
        if (r2 == null) goto L14;
        r2.setScrollBarStyle(33554432);
    L14:
        MaxHeightNestedScrollView r3 = this.t;
        if (r3 == null) goto L18;
        r3.setClipToPadding(false);
    L18:
        int r5 = -2;
        if (this.d == null) goto L28;
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.top_container, OaidModel.KEY_ID, "top_container")), ViewGroup.class, "com.obric.memorydata.plugin");
        r6.addView(this.d, new ViewGroup.LayoutParams(-1, -2));
        if (this.p == null) goto L23;
        r6.getLayoutParams().width = -2;
    L24:
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        int r8 = this.g;
        if (r8 != 0) goto L27;
        r8 = -2;
    L27:
        r7.height = r8;
        goto L28
    L23:
        r6.getLayoutParams().width = getAvailableItemWidth();
    L28:
        e();
        if (this.e == null) goto L40;
        ViewGroup r9 = (ViewGroup) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.bottom_container, OaidModel.KEY_ID, "bottom_container")), ViewGroup.class, "com.obric.memorydata.plugin");
        r9.addView(this.e, new ViewGroup.LayoutParams(-1, -2));
        if (this.p == null) goto L33;
        r9.getLayoutParams().width = -2;
    L34:
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        int r11 = this.h;
        if (r11 == 0) goto L38;
        r5 = r11;
    L38:
        r10.height = r5;
        goto L40
    L33:
        r9.getLayoutParams().width = getAvailableItemWidth();
    L40:
        if (this.p == null) goto L43;
        measure(0, 0);
        Log.d("OPopoverEntranceMenuView", "initView, handle widthConstraint: " + this.p + ", measuredWidth: " + getMeasuredWidth());
        int r12 = getMeasuredWidth();
        Pair<Integer, Integer> r13 = this.p;
        Intrinsics.checkNotNull(r13);
        int r14 = ((Number) ZeusTransformUtils.preCheckCast(r13.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Pair<Integer, Integer> r15 = this.p;
        Intrinsics.checkNotNull(r15);
        this.i = RangesKt.coerceIn(r12, r14, ((Number) ZeusTransformUtils.preCheckCast(r15.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue());
        this.p = null;
        d();
        c();
        return;
    }

    public static final /* synthetic */ void c(OPopoverEntranceMenuView r0, int r1) {
        r0.j = r1;
    }

    public static final /* synthetic */ void c(OPopoverEntranceMenuView r2, Function1 r3) {
        r2.m = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
    }

    private final void d() {
        ((FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.top_container, OaidModel.KEY_ID, "top_container")), FrameLayout.class, "com.obric.memorydata.plugin")).removeAllViews();
        ((LinearLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.popover_container, OaidModel.KEY_ID, "popover_container")), LinearLayout.class, "com.obric.memorydata.plugin")).removeAllViews();
        ((FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.bottom_container, OaidModel.KEY_ID, "bottom_container")), FrameLayout.class, "com.obric.memorydata.plugin")).removeAllViews();
    }

    public static final /* synthetic */ void d(OPopoverEntranceMenuView r0, int r1) {
        r0.k = r1;
    }

    private final void e() {
        int r0 = R.id.popover_container;
        String r7 = OaidModel.KEY_ID;
        final LinearLayout r9 = (LinearLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(r0, OaidModel.KEY_ID, "popover_container")), LinearLayout.class, "com.obric.memorydata.plugin");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r11 = false;
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r10.hasNext() == false) goto L175;
        Object r1 = r10.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final b r15 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.memorydata.plugin");
        if (r15.k() == 1) goto L10;
        if (r15.k() == 2) goto L14;
        if (r15.o() == false) goto L19;
    L22:
        boolean r2 = true;
    L23:
        LayoutInflater r3 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r2 == false) goto L26;
        int r4 = R.layout.o_item_popover_menu_filter;
        String r16 = "o_item_popover_menu_filter";
    L27:
        View r5 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(r4, "layout", r16), (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "null cannot be cast to non-null type com.obric.oui.popover.menu.PopoverMenuLinearLayout");
        PopoverMenuLinearLayout r6 = (PopoverMenuLinearLayout) ZeusTransformUtils.preCheckCast(r5, PopoverMenuLinearLayout.class, "com.obric.memorydata.plugin");
        OStateGradientDrawable r8 = new OStateGradientDrawable();
        Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r17, "context");
        r8.setCornerRadius(h.b(r17, 20));
        ColorStateList r18 = ContextCompat.getColorStateList((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.o_pop_list_item_bg_color, TypedValues.Custom.S_COLOR, "o_pop_list_item_bg_color"));
        Intrinsics.checkNotNull(r18);
        Intrinsics.checkNotNullExpressionValue(r18, "getColorStateList(contex…pop_list_item_bg_color)!!");
        r8.setSolidColors(r18);
        r6.setBackground((Drawable) ZeusTransformUtils.preCheckCast(r8, Drawable.class, "com.obric.memorydata.plugin"));
        LinearLayout r19 = (LinearLayout) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.item_container, r7, "item_container")), LinearLayout.class, "com.obric.memorydata.plugin");
        ImageView r20 = (ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.iv_popover_action, r7, "iv_popover_action")), ImageView.class, "com.obric.memorydata.plugin");
        ImageView r21 = (ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.iv_popover_tail_image, r7, "iv_popover_tail_image")), ImageView.class, "com.obric.memorydata.plugin");
        OTextView r22 = (OTextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tv_popover_action, r7, "tv_popover_action")), OTextView.class, "com.obric.memorydata.plugin");
        OTextView r23 = (OTextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tv_popover_action_sub, r7, "tv_popover_action_sub")), OTextView.class, "com.obric.memorydata.plugin");
        OTextView r24 = (OTextView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.tv_popover_value, r7, "tv_popover_value")), OTextView.class, "com.obric.memorydata.plugin");
        LinearLayout.LayoutParams r25 = null;
        if (r2 == false) goto L30;
        CheckableImageView r26 = (CheckableImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.popover_menu_radio, r7, "popover_menu_radio")), CheckableImageView.class, "com.obric.memorydata.plugin");
    L31:
        View r27 = r6.findViewById(ZeusTransformUtils.mapRes(R.id.popover_badge_default, r7, "popover_badge_default"));
        OBadgeView r28 = (OBadgeView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.popover_badge_number, r7, "popover_badge_number")), OBadgeView.class, "com.obric.memorydata.plugin");
        OBadgeView r29 = (OBadgeView) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.popover_badge_ellipsis, r7, "popover_badge_ellipsis")), OBadgeView.class, "com.obric.memorydata.plugin");
        LinearLayout r30 = (LinearLayout) ZeusTransformUtils.preCheckCast(r6.findViewById(ZeusTransformUtils.mapRes(R.id.ll_popover_text_container, r7, "ll_popover_text_container")), LinearLayout.class, "com.obric.memorydata.plugin");
        Builder.BadgeInfo r31 = r15.l();
        if (r31 == null) goto L45;
        int r32 = c.f14340a[r31.a().ordinal()];
        if (r32 != 1) goto L37;
        r27.setVisibility(0);
    L44:
        Unit r33 = Unit.INSTANCE;
        Unit r34 = Unit.INSTANCE;
        goto L45
    L37:
        if (r32 != 2) goto L39;
        r28.setVisibility(0);
        r28.setMaxNumberInCount(r31.c());
        r28.setText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r31.b()), CharSequence.class, "com.obric.memorydata.plugin"));
        goto L44
    L39:
        if (r32 != 3) goto L44;
        r29.setVisibility(0);
    L45:
        if (r26 != null) goto L48;
    L52:
        final CheckableImageView r35 = r26;
        Iterator r110 = r10;
        int r210 = r12;
        final int r36 = r13;
        r6.setOnClickListener(new $$Lambda$OPopoverEntranceMenuView$zKndP16VeghoIjeA3328hTFBU(r15, r35, r9, this, r36));
        if (this.p == null) goto L55;
        r6.getLayoutParams().width = -2;
    L57:
        if (r15.f() != null) goto L61;
        r23.setVisibility(8);
        ViewGroup.LayoutParams r37 = r6.getLayoutParams();
        int r38 = this.j;
        if (r38 == 0) goto L63;
    L64:
        r37.height = r38;
        r23.setText(r15.f());
        r24.setText(r15.g());
        if (TextUtils.isEmpty(r15.g()) == false) goto L67;
        int r39 = 8;
    L68:
        r24.setVisibility(r39);
        if (this.c.size() != 1) goto L78;
        r6.setIndexPos(PopoverMenuLinearLayout.Index.ONLY_ONE);
        ViewGroup.LayoutParams r40 = r6.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r40, LinearLayout.LayoutParams.class) == false) goto L73;
        LinearLayout.LayoutParams r41 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r40, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L74:
        if (r41 == null) goto L95;
    L76:
        r41.topMargin = 0;
        r41.bottomMargin = 0;
        Unit r42 = Unit.INSTANCE;
    L95:
        int r43 = 0;
    L96:
        a(r6);
        if (r15.b() == 0) goto L105;
        ImageView r44 = r20;
        r44.setVisibility(r43);
        Function1<? super Integer, ? extends Drawable> r45 = this.l;
        if (r45 == null) goto L104;
        if (r45 != null) goto L102;
        Drawable r46 = null;
    L103:
        r44.setImageDrawable(r46);
    L107:
        if (r15.c() == 0) goto L115;
        ImageView r47 = r21;
        r47.setVisibility(0);
        Function1<? super Integer, ? extends Drawable> r48 = this.m;
        if (r48 == null) goto L114;
        if (r48 != null) goto L112;
        Drawable r49 = null;
    L113:
        r47.setImageDrawable(r49);
    L117:
        if (r15.e() == null) goto L119;
        OTextView r50 = r22;
        r50.setText(r15.e());
    L120:
        r50.setSingleLine(this.s);
        r50.setEllipsize(TextUtils.TruncateAt.END);
        if (this.s == false) goto L123;
        int r51 = 1;
    L124:
        r50.setMaxLines(r51);
        if (r15.d() == 0) goto L127;
        r44.setImageTintList(ColorStateList.valueOf(r15.d()));
        r47.setImageTintList(ColorStateList.valueOf(r15.d()));
    L127:
        Integer r52 = r15.m();
        if (r52 == null) goto L132;
        r50.setTextColor(((Number) ZeusTransformUtils.preCheckCast(r52, Number.class, "com.obric.memorydata.plugin")).intValue());
        Unit r53 = Unit.INSTANCE;
    L132:
        if (getForceDark() == false) goto L134;
        Context r54 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int r55 = R.color.ConstTextInverse2;
        String r111 = TypedValues.Custom.S_COLOR;
        int r56 = ContextCompat.getColor(r54, ZeusTransformUtils.mapRes(r55, r111, "ConstTextInverse2"));
        r50.setTextColor(r56);
        r44.setImageTintList(ColorStateList.valueOf(r56));
        r47.setImageTintList(ColorStateList.valueOf(r56));
        r6.setForceDark(true);
    L136:
        if (r15.h() == false) goto L139;
        int r57 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.Negative, r111, "Negative"));
        r50.setTextColor(r57);
        r44.setImageTintList(ColorStateList.valueOf(r57));
    L139:
        if (r35 != null) goto L142;
        boolean r58 = false;
    L174:
        this.f14333b.invoke(r6);
        a(r6, r15.i());
        r9.addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.memorydata.plugin"));
        r13 = r13 + 1;
        r11 = r58;
        r10 = r110;
        r12 = r14;
        r7 = r7;
        goto L4
    L142:
        if (r15.d() == 0) goto L144;
        int r59 = r15.d();
    L145:
        r35.setImageTintList(ColorStateList.valueOf(r59));
        r35.setVisibility(0);
        r35.setChecked(r15.n());
        if (r15.p() == false) goto L172;
        ViewGroup.LayoutParams r60 = r35.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r60, LinearLayout.LayoutParams.class) == false) goto L150;
        LinearLayout.LayoutParams r61 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r60, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L151:
        if (r61 != null) goto L153;
        String r62 = "context";
        r58 = false;
    L154:
        r19.removeView((View) ZeusTransformUtils.preCheckCast(r35, View.class, "com.obric.memorydata.plugin"));
        r19.addView((View) ZeusTransformUtils.preCheckCast(r35, View.class, "com.obric.memorydata.plugin"));
        ViewGroup.LayoutParams r63 = r44.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r63, LinearLayout.LayoutParams.class) == false) goto L157;
        LinearLayout.LayoutParams r64 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r63, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L159:
        if (r64 == null) goto L163;
        Context r65 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r65, r62);
        r64.setMarginStart(h.a(r65, 12));
        Unit r66 = Unit.INSTANCE;
    L163:
        if (r44.getVisibility() != 8) goto L173;
        if (r30 == null) goto L173;
        ViewGroup.LayoutParams r67 = r30.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r67, LinearLayout.LayoutParams.class) == false) goto L168;
        r25 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r67, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L168:
        LinearLayout.LayoutParams r68 = r25;
        if (r68 == null) goto L173;
        Context r69 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r69, r62);
        r68.setMarginStart(h.a(r69, 12));
        Unit r70 = Unit.INSTANCE;
    L173:
        Unit r71 = Unit.INSTANCE;
        Unit r72 = Unit.INSTANCE;
        goto L174
    L157:
        r64 = null;
        goto L159
    L153:
        r58 = false;
        r61.setMarginStart(0);
        Context r73 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        r62 = "context";
        Intrinsics.checkNotNullExpressionValue(r73, r62);
        r61.setMarginEnd(h.a(r73, 8));
        Unit r74 = Unit.INSTANCE;
        goto L154
    L150:
        r61 = null;
        goto L151
    L172:
        r58 = false;
        goto L173
    L144:
        r59 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_accent_fg, r111, "oui_accent_fg"));
        goto L145
    L134:
        r111 = TypedValues.Custom.S_COLOR;
        goto L136
    L123:
        r51 = w;
        goto L124
    L119:
        r50 = r22;
        goto L120
    L112:
        r49 = (Drawable) ZeusTransformUtils.preCheckCast(r48.invoke(Integer.valueOf(r15.c())), Drawable.class, "com.obric.memorydata.plugin");
        goto L113
    L114:
        r47.setImageResource(r15.c());
        goto L117
    L115:
        r47 = r21;
        r47.setVisibility(8);
        goto L117
    L102:
        r46 = (Drawable) ZeusTransformUtils.preCheckCast(r45.invoke(Integer.valueOf(r15.b())), Drawable.class, "com.obric.memorydata.plugin");
        goto L103
    L104:
        r44.setImageResource(r15.b());
        goto L107
    L105:
        r44 = r20;
        r44.setVisibility(8);
        goto L107
    L73:
        r41 = null;
        goto L74
    L78:
        if (r210 != (this.c.size() - 1)) goto L85;
        r6.setIndexPos(PopoverMenuLinearLayout.Index.LAST);
        ViewGroup.LayoutParams r75 = r6.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r75, LinearLayout.LayoutParams.class) == false) goto L82;
        r41 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r75, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L83:
        if (r41 != null) goto L76;
    L82:
        r41 = null;
        goto L83
    L85:
        if (r210 < 0) goto L95;
        if (r210 != 0) goto L88;
        r6.setIndexPos(PopoverMenuLinearLayout.Index.FIRST);
    L88:
        ViewGroup.LayoutParams r76 = r6.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r76, LinearLayout.LayoutParams.class) == false) goto L91;
        LinearLayout.LayoutParams r77 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r76, LinearLayout.LayoutParams.class, "com.obric.memorydata.plugin");
    L92:
        if (r77 == null) goto L95;
        r43 = 0;
        r77.topMargin = 0;
        r77.bottomMargin = this.o;
        Unit r78 = Unit.INSTANCE;
        goto L96
    L91:
        r77 = null;
        goto L92
    L67:
        r39 = 0;
    L63:
        r38 = -2;
        goto L64
    L61:
        r23.setVisibility(0);
        r37 = r6.getLayoutParams();
        r38 = this.j;
        if (r38 != 0) goto L64;
    L55:
        r6.getLayoutParams().width = getAvailableItemWidth();
        goto L57
    L48:
        if (r15.a() == false) goto L50;
        int r79 = 0;
    L51:
        r26.setVisibility(r79);
        goto L52
    L50:
        r79 = 4;
        goto L51
    L30:
        r26 = null;
        goto L31
    L26:
        r4 = R.layout.o_item_popover_menu_type;
        r16 = "o_item_popover_menu_type";
        goto L27
    L19:
        if (r15.p() == true) goto L22;
        r2 = r11 ? 1 : 0;
        goto L23
    L14:
        View r80 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.o_item_popover_menu_sectionbar, "layout", "o_item_popover_menu_sectionbar"), (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.memorydata.plugin"), r11, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r80, "null cannot be cast to non-null type com.obric.oui.sectiontitlebar.OSectionTitleBar");
        OSectionTitleBar r81 = (OSectionTitleBar) ZeusTransformUtils.preCheckCast(r80, OSectionTitleBar.class, "com.obric.memorydata.plugin");
        r81.setTitleText((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r15.e()), CharSequence.class, "com.obric.memorydata.plugin"));
        LinearLayout.LayoutParams r82 = new LinearLayout.LayoutParams(-1, -2);
        r82.bottomMargin = this.o;
        Object r83 = r81;
        Object r84 = r82;
    L11:
        r9.addView((View) ZeusTransformUtils.preCheckCast(r83, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r84, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r12 = r14;
        goto L4
    L10:
        Context r85 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r85, "context");
        ODivider r86 = new ODivider(r85, null, 0, 6, null);
        r86.setBackground(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getDrawable(ZeusTransformUtils.mapRes(R.drawable.o_item_vertical_divider, "drawable", "o_item_vertical_divider")));
        Context r87 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r87, "context");
        int r88 = h.a(r87, 8);
        r86.setPadding(r88, r11 ? 1 : 0, r88, r11 ? 1 : 0);
        ViewGroup.MarginLayoutParams r89 = new ViewGroup.MarginLayoutParams(-1, -2);
        r89.leftMargin = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_popover_divider_margin, "dimen", "oui_popover_divider_margin"));
        r89.rightMargin = r89.leftMargin;
        r89.bottomMargin = this.o;
        r83 = r86;
        r84 = r89;
        goto L11
    }

    public static final /* synthetic */ void e(OPopoverEntranceMenuView r0, int r1) {
        r0.i = r1;
    }

    private final int getAvailableItemWidth() {
        return this.i;
    }

    /* JADX INFO: renamed from: lambda$i5_D-QLy-54-6H5J0v7RKTtT7MM, reason: not valid java name */
    public static /* synthetic */ void m1339lambda$i5_DQLy546H5J0v7RKTtT7MM(b r0, View r1, int r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$zKndP16VeghoIjeA-33-28hTFBU, reason: not valid java name */
    public static /* synthetic */ void m1340lambda$zKndP16VeghoIjeA3328hTFBU(b r0, CheckableImageView r1, LinearLayout r2, OPopoverEntranceMenuView r3, int r4, View r5) {
        a(r0, r1, r2, r3, r4, r5);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r5);
        int r6 = View.MeasureSpec.getSize(r5);
        if (r0 != Integer.MIN_VALUE) goto L5;
        int r7 = RangesKt.coerceAtMost(r6, this.r);
    L9:
        int r8 = View.MeasureSpec.makeMeasureSpec(r7, Integer.MIN_VALUE);
    L10:
        super.onMeasure(r4, r8);
        if (getMeasuredHeight() <= this.r) goto L14;
        setMeasuredDimension(getMeasuredWidth(), this.r);
        return;
    L14:
        return;
    L5:
        if (r0 == 1073741824) goto L7;
        r7 = this.r;
        goto L9
    L7:
        r8 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(r6, this.r), 1073741824);
        goto L10
    }

    @Override // com.obric.oui.popover.menu.OPopoverMenuView
    public void setPopoverMaxHeight(int r3) {
        int r4 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r3, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), x)), this.q);
        if (this.r != r4) goto L5;
        return;
    L5:
        this.r = r4;
        MaxHeightNestedScrollView r0 = this.t;
        if (r0 == null) goto L9;
        r0.setMaxHeight(r4);
    L9:
        requestLayout();
    }
}
