package com.larksuite.component.universe_design.tab;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.animation.UDAnimation$Interpolator;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 Ä\u00012\u00020\u0001:\nÀ\u0001Á\u0001Â\u0001Ã\u0001Ä\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u000e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012J\u0014\u0010;\u001a\u00020<2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120>J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\nJ\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010@\u001a\u00020!J\u001e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020!J\u000e\u0010A\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\nJ\u000e\u0010B\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012J\u000e\u0010C\u001a\u00020<2\u0006\u0010?\u001a\u00020\nJ\u0006\u0010D\u001a\u00020<J\u0006\u0010E\u001a\u00020\nJ\u0010\u0010F\u001a\u00020<2\b\b\u0001\u0010\u0015\u001a\u00020\nJ\b\u0010G\u001a\u00020\nH\u0007J\u0010\u0010H\u001a\u00020<2\b\b\u0001\u0010\u0018\u001a\u00020\nJ\b\u0010I\u001a\u00020\nH\u0007J\u0010\u0010J\u001a\u00020<2\b\u0010K\u001a\u0004\u0018\u00010LJ\u0010\u0010J\u001a\u00020<2\b\b\u0001\u0010M\u001a\u00020\nJ\b\u0010N\u001a\u0004\u0018\u00010LJ\u0010\u0010O\u001a\u00020<2\b\b\u0001\u0010P\u001a\u00020\nJ\u000e\u0010Q\u001a\u00020<2\u0006\u0010R\u001a\u00020\nJ\u000e\u0010S\u001a\u00020<2\u0006\u0010T\u001a\u00020UJ\u000e\u0010V\u001a\u00020<2\u0006\u0010W\u001a\u00020+J\u001a\u0010V\u001a\u00020<2\b\b\u0001\u0010X\u001a\u00020\n2\b\b\u0001\u0010Y\u001a\u00020\nJ\u0010\u0010Z\u001a\u00020<2\b\b\u0001\u0010P\u001a\u00020\nJ\u0010\u0010[\u001a\u00020<2\b\b\u0001\u0010\\\u001a\u00020\nJ\u0006\u0010]\u001a\u00020+J\u0010\u0010^\u001a\u00020<2\b\b\u0001\u0010P\u001a\u00020\nJ\u000e\u0010_\u001a\u00020<2\u0006\u0010W\u001a\u00020+J\u0010\u0010`\u001a\u00020<2\b\b\u0001\u0010\\\u001a\u00020\nJ\u0006\u0010a\u001a\u00020+J\u000e\u0010b\u001a\u00020<2\u0006\u0010c\u001a\u00020+J\u0010\u0010d\u001a\u00020<2\b\b\u0001\u0010e\u001a\u00020\nJ\u0010\u0010f\u001a\u00020<2\b\b\u0001\u0010g\u001a\u00020\nJ\u001a\u0010b\u001a\u00020<2\b\b\u0001\u0010X\u001a\u00020\n2\b\b\u0001\u0010Y\u001a\u00020\nJ\u0006\u0010h\u001a\u00020+J\u000e\u0010i\u001a\u00020<2\u0006\u0010j\u001a\u00020!J\u0006\u0010k\u001a\u00020!J\u000e\u0010l\u001a\u00020<2\u0006\u0010j\u001a\u00020!J\u0006\u0010m\u001a\u00020!J\u0006\u0010n\u001a\u00020\u0012J\u000e\u0010o\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012J\u001d\u0010o\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010p\u001a\u00020!H\u0000¢\u0006\u0002\bqJ\u000e\u0010r\u001a\u00020<2\u0006\u0010?\u001a\u00020\nJ\u001d\u0010r\u001a\u00020<2\u0006\u0010?\u001a\u00020\n2\u0006\u0010p\u001a\u00020!H\u0000¢\u0006\u0002\bsJ\u0006\u0010t\u001a\u00020\nJ\u000e\u0010u\u001a\u00020<2\u0006\u0010v\u001a\u00020!J\u0006\u0010w\u001a\u00020!J\u0010\u0010x\u001a\u00020<2\b\b\u0001\u0010y\u001a\u00020\nJ\u0006\u0010z\u001a\u00020\nJ\u000e\u0010{\u001a\u00020<2\u0006\u0010|\u001a\u00020\u0014J\u000e\u0010}\u001a\u00020<2\u0006\u0010|\u001a\u00020\u0014J1\u0010~\u001a\u00020<2\b\b\u0001\u0010\u007f\u001a\u00020\n2\t\b\u0001\u0010\u0080\u0001\u001a\u00020\n2\t\b\u0001\u0010\u0081\u0001\u001a\u00020\n2\t\b\u0001\u0010\u0082\u0001\u001a\u00020\nJ\u0013\u0010\u0083\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0016J\u001c\u0010\u0083\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020\nH\u0016J$\u0010\u0083\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0087\u0001\u001a\u00020\n2\u0006\u0010R\u001a\u00020\nH\u0016J\u001f\u0010\u0083\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J(\u0010\u0083\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u00020\n2\n\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J\u001b\u0010\u008a\u0001\u001a\u00020<2\u0007\u0010\u008b\u0001\u001a\u00020\n2\u0007\u0010\u008c\u0001\u001a\u00020\nH\u0014J6\u0010\u008d\u0001\u001a\u00020<2\u0007\u0010\u008e\u0001\u001a\u00020!2\u0007\u0010\u008f\u0001\u001a\u00020\n2\u0007\u0010\u0090\u0001\u001a\u00020\n2\u0007\u0010\u0091\u0001\u001a\u00020\n2\u0007\u0010\u0092\u0001\u001a\u00020\nH\u0014J\u0013\u0010\u0093\u0001\u001a\u00020<2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J-\u0010\u0096\u0001\u001a\u00020<2\u0007\u0010\u008f\u0001\u001a\u00020\n2\u0007\u0010\u0090\u0001\u001a\u00020\n2\u0007\u0010\u0097\u0001\u001a\u00020\n2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0014J2\u0010\u0099\u0001\u001a\u00020<2\u0006\u0010?\u001a\u00020\n2\b\u0010\u009a\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009c\u0001\u001a\u00020!2\u0006\u0010p\u001a\u00020!H\u0000¢\u0006\u0003\b\u009d\u0001J\u000f\u0010\u009e\u0001\u001a\u00020<H\u0000¢\u0006\u0003\b\u009f\u0001J#\u0010 \u0001\u001a\u00020<2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0013\u0010¡\u0001\u001a\u00020<2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0002J!\u0010¢\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020!H\u0002J\u0011\u0010£\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J\u0013\u0010¤\u0001\u001a\u00020<2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0002J\u0019\u0010§\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010@\u001a\u00020!H\u0002J\u0019\u0010¨\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010?\u001a\u00020\nH\u0002J\u0012\u0010©\u0001\u001a\u00020<2\u0007\u0010ª\u0001\u001a\u00020\nH\u0002J\u0011\u0010«\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J\t\u0010¬\u0001\u001a\u00020<H\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020<2\u0007\u0010®\u0001\u001a\u00020\nH\u0002J\u001b\u0010¯\u0001\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u00122\u0006\u0010p\u001a\u00020!H\u0002J\u0011\u0010°\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J\u001b\u0010±\u0001\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002J\t\u0010²\u0001\u001a\u00020<H\u0002J\u0012\u0010³\u0001\u001a\u00020<2\u0007\u0010´\u0001\u001a\u00020\nH\u0002J\u0011\u0010µ\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J\u0011\u0010¶\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J\u0011\u0010·\u0001\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0012H\u0002J&\u0010¸\u0001\u001a\u00020<2\u001a\u0010¹\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020<0º\u0001¢\u0006\u0003\b»\u0001H\u0082\bJ\t\u0010¼\u0001\u001a\u00020<H\u0002J\t\u0010½\u0001\u001a\u00020<H\u0002J\u001d\u0010¾\u0001\u001a\u00020+2\b\b\u0001\u0010X\u001a\u00020\n2\b\b\u0001\u0010Y\u001a\u00020\nH\u0002J\t\u0010¿\u0001\u001a\u000204H\u0002R\u0012\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0017R\u0012\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010.\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b6\u00107R\u000e\u0010:\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Å\u0001"}, d2 = {"Lcom/larksuite/component/universe_design/tab/UDTabLayout;", "Landroid/widget/HorizontalScrollView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "indicator", "Lcom/larksuite/component/universe_design/tab/UDTabLayout$UDTabIndicator;", "tabs", "", "Lcom/larksuite/component/universe_design/tab/UDTab;", "selectedListeners", "Lcom/larksuite/component/universe_design/tab/UDTabLayout$OnTabSelectedListener;", "tabMode", "getTabMode$annotations", "()V", "tabGravity", "getTabGravity$annotations", "tabMaxWidth", "tabMinWidth", "scrollAnimator", "Landroid/animation/ValueAnimator;", "indicatorAnimatorDuration", "", "edgeShadowShow", "", "edgeShadowEnable", "indicatorFullWidth", "tabPaddingStart", "tabPaddingTop", "tabPaddingEnd", "tabPaddingBottom", "tabMargin", "tabLayoutPaddingStart", "tabBackgroundColors", "Landroid/content/res/ColorStateList;", "tabTitleColors", "tabIconTintColors", "tabTitleTextAppearance", "tabTitleTextSize", "tabMultiLineTitleTextSize", "scrollBounds", "Landroid/graphics/Rect;", "edgeShadowDrawable", "Landroid/graphics/drawable/GradientDrawable;", "bottomDividerDrawable", "getBottomDividerDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "bottomDividerDrawable$delegate", "Lkotlin/Lazy;", "bottomDividerEnabled", "addTab", "", "tab", "", "position", "setSelected", "getTabAt", "removeTab", "removeTabAt", "removeAllTabs", "getTabCount", "setTabMode", "getTabMode", "setTabGravity", "getTabGravity", "setIndicatorDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "getIndicatorDrawable", "setIndicatorColor", "color", "setIndicatorHeight", "height", "setIndicatorInterpolator", "indicatorInterpolator", "Lcom/larksuite/component/universe_design/tab/UDTabIndicatorInterpolator;", "setTabTitleColors", "colors", "normalColor", "selectedColor", "setTabTitleColor", "setTabTitleColorResource", "colorRes", "getTabTitleColors", "setTabBackgroundColor", "setTabBackgroundColors", "setTabBackgroundColorResource", "getTabBackgroundColors", "setTabIconTintColors", "tint", "setTabIconTintColor", "tintColor", "setTabIconTintColorResource", "tintRes", "getTabIconTintColor", "setEdgeShadowEnabled", "enable", "isEdgeShadowEnabled", "setBottomDividerEnabled", "isBottomDividerEnabled", "newTab", "selectTab", "updateIndicator", "selectTab$universe_ui_tab_release", "selectTabAt", "selectTabAt$universe_ui_tab_release", "getSelectPosition", "setIndicatorFullWidth", "fullWidth", "isIndicatorFullWidth", "setTabMargin", "margin", "getTabMargin", "addOnTabSelectedListener", "listener", "removeOnTabSelectedListener", "setTabPadding", "paddingStart", "paddingTop", "paddingEnd", "paddingBottom", "addView", "child", "Landroid/view/View;", "index", "width", "params", "Landroid/view/ViewGroup$LayoutParams;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "l", "t", "r", "b", "onDrawForeground", "canvas", "Landroid/graphics/Canvas;", "onScrollChanged", "oldl", "oldt", "setScrollPosition", "offset", "", "updateSelectedText", "setScrollPosition$universe_ui_tab_release", "invaliIndicator", "invaliIndicator$universe_ui_tab_release", "applyAttrs", "addViewInternal", "addTabInternal", "removeTabInternal", "addTabFromItemView", "itemView", "Lcom/larksuite/component/universe_design/tab/UDTabItem;", "addTabView", "addTabToList", "setupTabMaxWidth", "maxWidth", "configureTabStyle", "updateTabsStyle", "updateTabsPosition", "startPosition", "selectTabInternal", "animateToTab", "calculateScrollXForTab", "updateEdgeShadow", "dispatchSelectState", "selectedPosition", "dispatchTabSelected", "dispatchTabReselected", "dispatchTabUnselected", "forEachListenersReverse", "action", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "applyTabMode", "applyTabGravity", "createColorStateList", "generateEdgeShadowDrawable", "OnTabSelectedListener", "TabMode", "TabGravity", "UDTabIndicator", "Companion", "universe-ui-tab_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDTabLayout extends HorizontalScrollView {
    public static final a Companion = null;
    public static final int NO_POSITION = -1;
    private final Lazy bottomDividerDrawable$delegate;
    private boolean bottomDividerEnabled;
    private GradientDrawable edgeShadowDrawable;
    private boolean edgeShadowEnable;
    private boolean edgeShadowShow;
    private final c indicator;
    private long indicatorAnimatorDuration;
    private boolean indicatorFullWidth;
    private ValueAnimator scrollAnimator;
    private final Rect scrollBounds;
    private final List<b> selectedListeners;
    private ColorStateList tabBackgroundColors;
    private int tabGravity;
    private ColorStateList tabIconTintColors;
    private int tabLayoutPaddingStart;
    private int tabMargin;
    private int tabMaxWidth;
    private int tabMinWidth;
    private int tabMode;
    private int tabMultiLineTitleTextSize;
    private int tabPaddingBottom;
    private int tabPaddingEnd;
    private int tabPaddingStart;
    private int tabPaddingTop;
    private ColorStateList tabTitleColors;
    private int tabTitleTextAppearance;
    private int tabTitleTextSize;
    private final List<com.larksuite.component.universe_design.tab.b> tabs;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larksuite/component/universe_design/tab/UDTabLayout$TabGravity;", "", "Companion", "universe-ui-tab_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TabGravity {
        public static final int CENTER = 0;
        public static final a Companion = null;
        public static final int FILL = 1;
        public static final int START = 2;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larksuite/component/universe_design/tab/UDTabLayout$TabMode;", "", "Companion", "universe-ui-tab_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TabMode {
        public static final int AUTO = 2;
        public static final a Companion = null;
        public static final int FIXED = 1;
        public static final int SCROLLABLE = 0;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a(com.larksuite.component.universe_design.tab.b r1);

        void b(com.larksuite.component.universe_design.tab.b r1);

        void c(com.larksuite.component.universe_design.tab.b r1);
    }

    public final class c extends LinearLayout {
        public Drawable a;
        public int b;
        public int c;
        public int d;
        public float e;
        public com.larksuite.component.universe_design.tab.c f;
        public int g;
        public ValueAnimator h;
        public boolean i;
        public final /* synthetic */ UDTabLayout j;

        public final void b() {
            int r0 = getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L24;
            View r3 = getChildAt(r2);
            Intrinsics.checkNotNull(r3);
            ViewGroup.LayoutParams r4 = r3.getLayoutParams();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams r5 = (LinearLayout.LayoutParams) r4;
            boolean r6 = true;
            if (this.c != 1) goto L16;
            if (this.b != 1) goto L16;
            if (r5.weight == 1.0f) goto L12;
            r6 = false;
        L12:
            if (r6 == true) goto L14;
            int r7 = r5.width;
        L14:
            r5.width = 0;
            r5.weight = 1.0f;
        L23:
            r2 = r2 + 1;
        L16:
            if (r5.weight == 0.0f) goto L20;
            r6 = false;
        L20:
            if (r6 == true) goto L22;
            int r8 = r5.width;
        L22:
            r5.width = -2;
            r5.weight = 0.0f;
            goto L23
        }

        public final void a(int r5) {
            Drawable r0 = this.a;
            if (r0 == null) goto L16;
            UDTabLayout r1 = this.j;
            ValueAnimator r2 = this.h;
            if (r2 == null) goto L9;
            boolean r3 = true;
            if (r2.isRunning() != true) goto L9;
        L10:
            if (r3 == false) goto L14;
            ValueAnimator r4 = this.h;
            if (r4 == null) goto L14;
            r4.cancel();
        L14:
            com.larksuite.component.universe_design.tab.c r6 = this.f;
            View r7 = getChildAt(r5);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r1, "tabLayout");
            Intrinsics.checkNotNullParameter(r0, "indicator");
            boolean r8 = r1.isIndicatorFullWidth();
            int r9 = com.larksuite.component.universe_design.tab.c.a(r7, r8);
            int r10 = com.larksuite.component.universe_design.tab.c.b(r7, r8);
            r0.setBounds(r9, r0.getBounds().top, r10, r0.getBounds().bottom);
            invalidate();
            return;
        L9:
            r3 = false;
            goto L10
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onDraw(Canvas r6) {
            Intrinsics.checkNotNullParameter(r6, "canvas");
            super.onDraw(r6);
            Drawable r0 = this.a;
            if (r0 == null) goto L12;
            int r1 = this.g;
            if (r1 > 0) goto L8;
            r1 = r0.getIntrinsicHeight();
        L8:
            if (r1 <= 0) goto L13;
            int r2 = getHeight() - r1;
            int r3 = getHeight();
            r0.setBounds(r0.getBounds().left, r2, r0.getBounds().right, r3);
            r0.draw(r6);
            return;
        L13:
            return;
        }

        public c(UDTabLayout r2, Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.j = r2;
            super(r3);
            this.a = UDIconUtils.getIconDrawable(r3, 2131256317);
            this.b = 2;
            this.c = 1;
            this.d = -1;
            this.f = new com.larksuite.component.universe_design.tab.c();
            this.g = -1;
            setWillNotDraw(false);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int r11, int r12) {
            super.onMeasure(r11, r12);
            if (View.MeasureSpec.getMode(r11) == 1073741824) goto L5;
            return;
        L5:
            boolean r2 = false;
            if (this.b != 2) goto L29;
            if (this.c != 1) goto L29;
            int r0 = getChildCount();
            int r3 = 0;
            int r5 = 0;
        L10:
            if (r3 >= r0) goto L13;
            View r6 = getChildAt(r3);
            Intrinsics.checkNotNull(r6);
            r5 = r5 + r6.getMeasuredWidth();
            r3 = r3 + 1;
            goto L10
        L13:
            if (r5 > getMeasuredWidth()) goto L25;
            int r1 = getChildCount();
            int r4 = 0;
            boolean r7 = false;
        L15:
            if (r4 >= r1) goto L26;
            View r8 = getChildAt(r4);
            Intrinsics.checkNotNull(r8);
            ViewGroup.LayoutParams r9 = r8.getLayoutParams();
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams r10 = (LinearLayout.LayoutParams) r9;
            if (r10.weight != 1.0f) goto L19;
            boolean r13 = true;
        L20:
            if (r13 == true) goto L22;
        L23:
            r10.weight = 1.0f;
            r10.width = 0;
            r7 = true;
        L24:
            r4 = r4 + 1;
            goto L15
        L22:
            if (r10.width == 0) goto L24;
        L19:
            r13 = false;
        L26:
            if (r7 == false) goto L29;
            super.onMeasure(r11, r12);
            goto L29
        L25:
            b();
            r7 = false;
        L29:
            if (this.c != 0) goto L64;
            int r14 = getChildCount();
            int r15 = 0;
            int r16 = 0;
            int r17 = 0;
        L31:
            if (r15 >= r14) goto L37;
            View r19 = getChildAt(r15);
            Intrinsics.checkNotNull(r19);
            if (r19.getVisibility() != 0) goto L35;
            r17 = Math.max(r17, r19.getMeasuredWidth());
            r16 = r16 + 1;
        L35:
            r15 = r15 + 1;
            goto L31
        L37:
            if ((r16 * r17) <= getMeasuredWidth()) goto L39;
            this.c = 1;
            b();
            b();
        L51:
            if (r2 == false) goto L65;
            super.onMeasure(r11, r12);
            return;
        L65:
            return;
        L39:
            int r20 = getChildCount();
            int r21 = 0;
            boolean r22 = false;
        L40:
            if (r21 >= r20) goto L50;
            View r23 = getChildAt(r21);
            Intrinsics.checkNotNull(r23);
            ViewGroup.LayoutParams r24 = r23.getLayoutParams();
            Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams r25 = (LinearLayout.LayoutParams) r24;
            if (r25.width == r17) goto L44;
        L48:
            r25.width = r17;
            r25.weight = 0.0f;
            r22 = true;
        L49:
            r21 = r21 + 1;
            goto L40
        L44:
            if (r25.weight != 0.0f) goto L46;
            boolean r26 = true;
        L47:
            if (r26 == true) goto L49;
        L46:
            r26 = false;
            goto L47
        L50:
            r2 = r22;
            goto L51
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
            super.onLayout(r3, r4, r5, r6, r7);
            ValueAnimator r8 = this.h;
            if (r8 == null) goto L7;
            boolean r9 = true;
            if (r8.isRunning() != true) goto L7;
        L8:
            if (r9 == true) goto L11;
            if (r3 == false) goto L11;
        L12:
            int r10 = this.d;
            int r11 = r10 + 1;
            float r12 = this.e;
            Drawable r13 = this.a;
            if (r13 == null) goto L15;
            UDTabLayout r0 = this.j;
            com.larksuite.component.universe_design.tab.c r1 = this.f;
            View r14 = getChildAt(r10);
            View r15 = getChildAt(r11);
            r1.getClass();
            com.larksuite.component.universe_design.tab.c.c(r0, r14, r15, r12, r13);
            postInvalidateOnAnimation();
        L15:
            this.i = false;
            return;
        L11:
            if (this.i == true) goto L12;
            return;
        L7:
            r9 = false;
            goto L8
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ UDTabLayout a;
        public final /* synthetic */ ValueAnimator b;

        public d(UDTabLayout r1, ValueAnimator r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            Intrinsics.checkNotNullParameter(r3, "it");
            UDTabLayout r4 = this.a;
            Object r0 = this.b.getAnimatedValue();
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Int");
            r4.scrollTo(((Integer) r0).intValue(), 0);
        }
    }

    static {
        Companion = new a();
    }

    @TabGravity
    private static /* synthetic */ void getTabGravity$annotations() {
    }

    @TabMode
    private static /* synthetic */ void getTabMode$annotations() {
    }

    private final void applyTabGravity() {
        c r0 = this.indicator;
        r0.c = this.tabGravity;
        r0.b();
        int r1 = this.tabGravity;
        if (r1 == 0) goto L9;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L10;
        this.indicator.setGravity(8388611);
    L10:
        this.indicator.i = true;
        if (isLaidOut() == false) goto L14;
        updateTabsStyle();
        return;
    L14:
        return;
    L9:
        this.indicator.setGravity(17);
        goto L10
    }

    private final void applyTabMode() {
        c r0 = this.indicator;
        r0.b = this.tabMode;
        r0.b();
        if (isLaidOut() == false) goto L6;
        updateTabsStyle();
        this.indicator.i = true;
        return;
    }

    private final GradientDrawable generateEdgeShadowDrawable() {
        GradientDrawable r0 = new GradientDrawable();
        r0.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        int[] r1 = new int[2];
        ColorStateList r2 = this.tabBackgroundColors;
        ColorStateList r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        r2 = null;
    L5:
        r1[0] = UDColorUtils.getAlphaColor(r2.getDefaultColor(), 0.0f);
        ColorStateList r4 = this.tabBackgroundColors;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
    L9:
        r1[1] = r3.getDefaultColor();
        r0.setColors(r1);
        return r0;
    L8:
        r3 = r4;
        goto L9
    }

    private final GradientDrawable getBottomDividerDrawable() {
        return (GradientDrawable) this.bottomDividerDrawable$delegate.getValue();
    }

    private final void updateEdgeShadow() {
        if (this.edgeShadowEnable == true) goto L6;
        return;
    L6:
        if (this.indicator.getWidth() > getWidth()) goto L8;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L17;
        setWillNotDraw(false);
    L17:
        if (r3 == this.edgeShadowShow) goto L20;
        this.edgeShadowShow = r3;
        invalidate();
        return;
    L20:
        return;
    L8:
        if (this.indicator.getChildCount() <= 0) goto L12;
        c r0 = this.indicator;
        r3 = true;
        View r1 = r0.getChildAt(r0.getChildCount() - 1);
        getHitRect(this.scrollBounds);
        if (((r1.getRight() - r1.getPaddingRight()) - getScrollX()) > this.scrollBounds.right) goto L14;
    }

    private final void updateTabsStyle() {
        Iterator<com.larksuite.component.universe_design.tab.b> r0 = this.tabs.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        configureTabStyle(r0.next());
        goto L4
    L6:
        ColorStateList r1 = this.tabBackgroundColors;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        r1 = null;
    L9:
        setBackgroundColor(r1.getDefaultColor());
    }

    public final Drawable getIndicatorDrawable() {
        return this.indicator.a;
    }

    public final int getSelectPosition() {
        return this.indicator.d;
    }

    public final ColorStateList getTabBackgroundColors() {
        ColorStateList r0 = this.tabBackgroundColors;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        return null;
    L6:
        return r0;
    }

    public final int getTabCount() {
        return this.tabs.size();
    }

    public final ColorStateList getTabIconTintColor() {
        ColorStateList r0 = this.tabIconTintColors;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tabIconTintColors");
        return null;
    L6:
        return r0;
    }

    public final ColorStateList getTabTitleColors() {
        ColorStateList r0 = this.tabTitleColors;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitleColors");
        return null;
    L6:
        return r0;
    }

    public final void invaliIndicator$universe_ui_tab_release() {
        this.indicator.i = true;
    }

    public final com.larksuite.component.universe_design.tab.b newTab() {
        com.larksuite.component.universe_design.tab.b r0 = new com.larksuite.component.universe_design.tab.b(getContext());
        configureTabStyle(r0);
        return r0;
    }

    public final void removeAllTabs() {
        this.tabs.clear();
        this.indicator.removeAllViews();
        selectTabAt(-1);
    }

    @TabGravity
    public final int getTabGravity() {
        return this.tabGravity;
    }

    public final int getTabMargin() {
        return this.tabMargin;
    }

    @TabMode
    public final int getTabMode() {
        return this.tabMode;
    }

    public final boolean isBottomDividerEnabled() {
        return this.bottomDividerEnabled;
    }

    public final boolean isEdgeShadowEnabled() {
        return this.edgeShadowEnable;
    }

    public final boolean isIndicatorFullWidth() {
        return this.indicatorFullWidth;
    }

    public UDTabLayout(Context r2) {
        this(r2, null);
    }

    public static final /* synthetic */ long access$getIndicatorAnimatorDuration$p(UDTabLayout r2) {
        return r2.indicatorAnimatorDuration;
    }

    private final void addTabFromItemView(UDTabItem r4) {
        com.larksuite.component.universe_design.tab.b r0 = newTab();
        r0.b(r4.getTitle$universe_ui_tab_release());
        r0.d = r4.getIcon$universe_ui_tab_release();
        r0.c();
        if (r4.getCustomView$universe_ui_tab_release() == null) goto L10;
        Integer r1 = r4.getCustomView$universe_ui_tab_release();
        if (r1 != null) goto L8;
    L9:
        View r5 = LayoutInflater.from(r0.getContext()).inflate(r4.getCustomView$universe_ui_tab_release().intValue(), null);
        Intrinsics.checkNotNullParameter(r5, "value");
        r0.e = r5;
        r0.d();
        r0.c();
        goto L10
    L8:
        if (r1.intValue() != 0) goto L9;
    L10:
        addTab(r0);
    }

    private final void addViewInternal(View r2) {
        if ((r2 instanceof UDTabItem) == false) goto L7;
        addTabFromItemView((UDTabItem) r2);
        return;
    L7:
        throw new IllegalArgumentException("Only UDTabItem instances can be added to UDTabLayout.".toString());
    }

    private final void animateToTab(com.larksuite.component.universe_design.tab.b r5) {
        ValueAnimator r0 = this.scrollAnimator;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L12;
        ValueAnimator r2 = this.scrollAnimator;
        if (r2 == null) goto L12;
        r2.cancel();
    L12:
        ValueAnimator r6 = ValueAnimator.ofInt(new int[]{getScrollX(), calculateScrollXForTab(r5.f, 0.0f)});
        r6.setInterpolator((PathInterpolator) UDAnimation$Interpolator.b.getValue());
        r6.setDuration(this.indicatorAnimatorDuration);
        r6.addUpdateListener(new d(this, r6));
        r6.start();
        this.scrollAnimator = r6;
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        r1 = true;
        goto L8
    }

    private final void configureTabStyle(com.larksuite.component.universe_design.tab.b r10) {
        r10.e.setPaddingRelative(this.tabPaddingStart, this.tabPaddingTop, this.tabPaddingEnd, this.tabPaddingBottom);
        r10.e.setMinimumWidth(this.tabMinWidth);
        ViewGroup.LayoutParams r0 = r10.e.getLayoutParams();
        f r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 != null) goto L8;
    L12:
        ColorStateList r3 = this.tabIconTintColors;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("tabIconTintColors");
        r3 = null;
    L15:
        Intrinsics.checkNotNullParameter(r3, "colors");
        ImageView r4 = (ImageView) r10.e.findViewById(2131391820);
        if (r4 == null) goto L19;
        r4.setImageTintList(r3);
    L19:
        ColorStateList r5 = this.tabBackgroundColors;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        r5 = null;
    L22:
        Intrinsics.checkNotNullParameter(r5, "colors");
        r10.e.setBackgroundTintList(r5);
        r10.e.invalidate();
        TextView r6 = r10.a();
        int r7 = 2;
        if (r6 == null) goto L29;
        r6.setTextAppearance(r6.getContext(), this.tabTitleTextAppearance);
        r6.setTextSize(0, this.tabTitleTextSize);
        if (this.tabMode != 1) goto L27;
        int r8 = 2;
    L28:
        r6.setMaxLines(r8);
        goto L29
    L27:
        r8 = 1;
    L29:
        TextView r9 = (TextView) r10.e.findViewById(2131391822);
        if (r9 == null) goto L36;
        r9.setTextAppearance(r9.getContext(), this.tabTitleTextAppearance);
        w08.a.b(r9, 1);
        r9.setTextSize(0, this.tabTitleTextSize);
        if (this.tabMode == 1) goto L35;
        r7 = 1;
    L35:
        r9.setMaxLines(r7);
    L36:
        ColorStateList r11 = this.tabTitleColors;
        if (r11 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("tabTitleColors");
        r11 = null;
    L39:
        Intrinsics.checkNotNullParameter(r11, "colors");
        TextView r12 = r10.a();
        if (r12 == null) goto L45;
        r12.setTextColor(r11);
        TextView r13 = (TextView) r10.e.findViewById(2131391822);
        if (r13 == null) goto L45;
        r13.setTextColor(r11);
    L45:
        View r14 = r10.e;
        if ((r14 instanceof f) == false) goto L48;
        r2 = (f) r14;
    L48:
        if (r2 == null) goto L50;
        r2.setMultiLineTitleTextSize$universe_ui_tab_release(this.tabMultiLineTitleTextSize);
        r2.setSingleLineTitleTextSize$universe_ui_tab_release(this.tabTitleTextSize);
        r2.setMaxWidth$universe_ui_tab_release(this.tabMaxWidth);
    L50:
        boolean r15 = r10.e.isSelected();
        r10.e.setSelected(r15);
        TextView r16 = r10.a();
        if (r16 == null) goto L56;
        if (r15 == false) goto L55;
        w08.a.b(r16, 1);
        goto L56
    L55:
        w08.a.b(r16, 0);
    L56:
        this.indicator.i = true;
        requestLayout();
        return;
    L8:
        if (r10.f <= 0) goto L10;
        int r17 = this.tabMargin;
    L11:
        r1.leftMargin = r17;
        goto L12
    L10:
        r17 = this.tabLayoutPaddingStart;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    private final void dispatchSelectState(int r8) {
        int r0 = this.tabs.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        com.larksuite.component.universe_design.tab.b r3 = (com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r2);
        if (r2 != r8) goto L7;
        boolean r5 = true;
    L8:
        r3.e.setSelected(r5);
        TextView r4 = r3.a();
        if (r4 == null) goto L14;
        if (r5 == false) goto L13;
        w08.a.b(r4, 1);
        goto L14
    L13:
        w08.a.b(r4, 0);
    L14:
        r2 = r2 + 1;
        goto L3
    L7:
        r5 = false;
        goto L8
    }

    private final void dispatchTabReselected(com.larksuite.component.universe_design.tab.b r3) {
        int r0 = CollectionsKt.getLastIndex(this.selectedListeners);
    L3:
        if (r0 < 0) goto L5;
        ((b) ListProtector.get(this.selectedListeners, r0)).c(r3);
        r0 = r0 - 1;
        goto L3
    }

    private final void dispatchTabSelected(com.larksuite.component.universe_design.tab.b r3) {
        int r0 = CollectionsKt.getLastIndex(this.selectedListeners);
    L3:
        if (r0 < 0) goto L5;
        ((b) ListProtector.get(this.selectedListeners, r0)).b(r3);
        r0 = r0 - 1;
        goto L3
    }

    private final void dispatchTabUnselected(com.larksuite.component.universe_design.tab.b r3) {
        int r0 = CollectionsKt.getLastIndex(this.selectedListeners);
    L3:
        if (r0 < 0) goto L5;
        ((b) ListProtector.get(this.selectedListeners, r0)).a(r3);
        r0 = r0 - 1;
        goto L3
    }

    private final void forEachListenersReverse(Function1<? super b, Unit> r3) {
        int r0 = CollectionsKt.getLastIndex(this.selectedListeners);
    L3:
        if (r0 < 0) goto L5;
        r3.invoke((b) ListProtector.get(this.selectedListeners, r0));
        r0 = r0 - 1;
        goto L3
    }

    private final void removeTabInternal(com.larksuite.component.universe_design.tab.b r4) {
        if (r4.f == this.indicator.d) goto L5;
    L8:
        this.tabs.remove(r4);
        c r0 = this.indicator;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "tab");
        r0.removeView(r4.e);
        r0.b();
        r0.i = true;
        updateTabsPosition(r4.f);
        return;
    L5:
        if (this.tabs.isEmpty() == false) goto L7;
        selectTabAt(-1);
        goto L8
    L7:
        selectTabAt(Math.max(0, r4.f - 1));
        goto L8
    }

    private final void setupTabMaxWidth(int r3) {
        if (r3 != this.tabMaxWidth) goto L5;
        return;
    L5:
        Iterator<com.larksuite.component.universe_design.tab.b> r4 = this.tabs.iterator();
    L7:
        if (r4.hasNext() == false) goto L14;
        View r0 = r4.next().e;
        if ((r0 instanceof f) == false) goto L11;
        f r1 = (f) r0;
    L12:
        if (r1 == null) goto L7;
        r1.setMaxWidth$universe_ui_tab_release(this.tabMaxWidth);
        goto L7
    L11:
        r1 = null;
        goto L12
    }

    private final void updateTabsPosition(int r3) {
        int r0 = this.tabs.size();
    L3:
        if (r3 >= r0) goto L5;
        ((com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r3)).f = r3;
        r3 = r3 + 1;
        goto L3
    }

    public final void addOnTabSelectedListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.selectedListeners.add(r2);
    }

    public final void addTab(List<com.larksuite.component.universe_design.tab.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "tabs");
        Iterator<com.larksuite.component.universe_design.tab.b> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        addTab(r3.next());
        goto L4
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        addViewInternal(r2);
    }

    public final com.larksuite.component.universe_design.tab.b getTabAt(int r2) {
        return (com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r2);
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        if (this.edgeShadowEnable == true) goto L5;
    L15:
        super.onDrawForeground(r6);
        if (this.bottomDividerEnabled == false) goto L19;
        int r0 = getScrollX();
        int r1 = getHeight() - ((int) h18.d.b(getContext(), 1));
        int r2 = getWidth() + getScrollX();
        int r3 = getHeight();
        getBottomDividerDrawable().setBounds(r0, r1, r2, r3);
        getBottomDividerDrawable().draw(r6);
        return;
    L19:
        return;
    L5:
        if (this.edgeShadowShow == false) goto L15;
        int r4 = (getWidth() - ((int) h18.d.b(getContext(), 64))) + getScrollX();
        int r5 = getWidth() + getScrollX();
        int r7 = getHeight();
        if (this.edgeShadowDrawable != null) goto L9;
        this.edgeShadowDrawable = generateEdgeShadowDrawable();
    L9:
        GradientDrawable r8 = this.edgeShadowDrawable;
        if (r8 == null) goto L12;
        r8.setBounds(r4, 0, r5, r7);
    L12:
        GradientDrawable r9 = this.edgeShadowDrawable;
        if (r9 == null) goto L15;
        r9.draw(r6);
        goto L15
    }

    public final void removeOnTabSelectedListener(b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.selectedListeners.remove(r2);
    }

    public final void removeTab(com.larksuite.component.universe_design.tab.b r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        removeTabInternal(r2);
    }

    public final void removeTabAt(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 >= this.tabs.size()) goto L8;
        removeTab((com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r2));
        return;
    }

    public final void selectTab(com.larksuite.component.universe_design.tab.b r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        selectTab$universe_ui_tab_release(r2, true);
    }

    public final void selectTabAt(int r2) {
        selectTabAt$universe_ui_tab_release(r2, true);
    }

    public final void setBottomDividerEnabled(boolean r2) {
        if (this.bottomDividerEnabled == r2) goto L6;
        this.bottomDividerEnabled = r2;
        invalidate();
        return;
    }

    public final void setEdgeShadowEnabled(boolean r2) {
        if (this.edgeShadowEnable == r2) goto L6;
        this.edgeShadowEnable = r2;
        updateEdgeShadow();
        return;
    }

    public final void setIndicatorColor(int r2) {
        Drawable r0 = this.indicator.a;
        if (r0 == null) goto L5;
        r0.mutate();
        r0.setTint(r2);
    L5:
        this.indicator.invalidate();
    }

    public final void setIndicatorDrawable(int r3) {
        c r0 = this.indicator;
        r0.a = UDIconUtils.getIconDrawable(getContext(), r3);
        r0.i = true;
        r0.requestLayout();
        this.indicator.invalidate();
    }

    public final void setIndicatorFullWidth(boolean r2) {
        this.indicatorFullWidth = r2;
        c r3 = this.indicator;
        r3.a(r3.d);
    }

    public final void setIndicatorHeight(int r2) {
        c r0 = this.indicator;
        r0.g = r2;
        r0.invalidate();
    }

    public final void setIndicatorInterpolator(com.larksuite.component.universe_design.tab.c r3) {
        Intrinsics.checkNotNullParameter(r3, "indicatorInterpolator");
        c r0 = this.indicator;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r0.f = r3;
    }

    public final void setTabBackgroundColor(int r1) {
        setTabBackgroundColors(ColorStateList.valueOf(r1));
    }

    public final void setTabBackgroundColorResource(int r2) {
        setTabBackgroundColors(UDColorUtils.getColorStateList(getContext(), r2));
    }

    public final void setTabBackgroundColors(ColorStateList r6) {
        Intrinsics.checkNotNullParameter(r6, "colors");
        this.tabBackgroundColors = r6;
        updateTabsStyle();
        GradientDrawable r7 = this.edgeShadowDrawable;
        if (r7 == null) goto L13;
        int[] r0 = new int[2];
        ColorStateList r1 = this.tabBackgroundColors;
        ColorStateList r2 = null;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        r1 = null;
    L7:
        r0[0] = UDColorUtils.getAlphaColor(r1.getDefaultColor(), 0.0f);
        ColorStateList r3 = this.tabBackgroundColors;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
    L11:
        r0[1] = r2.getDefaultColor();
        r7.setColors(r0);
        return;
    L10:
        r2 = r3;
        goto L11
    }

    public final void setTabGravity(@TabGravity int r1) {
        this.tabGravity = r1;
        applyTabGravity();
    }

    public final void setTabIconTintColor(int r1) {
        this.tabIconTintColors = ColorStateList.valueOf(r1);
        updateTabsStyle();
    }

    public final void setTabIconTintColorResource(int r2) {
        this.tabIconTintColors = UDColorUtils.getColorStateList(getContext(), r2);
        updateTabsStyle();
    }

    public final void setTabIconTintColors(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "tint");
        this.tabIconTintColors = r2;
        updateTabsStyle();
    }

    public final void setTabMargin(int r1) {
        this.tabMargin = r1;
        updateTabsStyle();
    }

    public final void setTabMode(@TabMode int r1) {
        this.tabMode = r1;
        applyTabMode();
    }

    public final void setTabTitleColor(int r1) {
        this.tabTitleColors = ColorStateList.valueOf(r1);
        updateTabsStyle();
    }

    public final void setTabTitleColorResource(int r2) {
        this.tabTitleColors = UDColorUtils.getColorStateList(getContext(), r2);
        updateTabsStyle();
    }

    public final void setTabTitleColors(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
        this.tabTitleColors = r2;
        updateTabsStyle();
    }

    public final void addTab(com.larksuite.component.universe_design.tab.b r2) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        addTab(r2, this.tabs.isEmpty());
    }

    public final void setIndicatorDrawable(Drawable r2) {
        c r0 = this.indicator;
        r0.a = r2;
        r0.i = true;
        r0.requestLayout();
        this.indicator.invalidate();
    }

    public UDTabLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    private final void addTabToList(com.larksuite.component.universe_design.tab.b r2, int r3) {
        ListProtector.add(this.tabs, r3, r2);
        r2.b = this;
        updateTabsPosition(r3);
        configureTabStyle(r2);
    }

    private final void addTabView(com.larksuite.component.universe_design.tab.b r4, boolean r5) {
        c r0 = this.indicator;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "tab");
        r0.addView(r4.e, r4.f);
        r0.b();
        r0.i = true;
        if (r5 == false) goto L6;
        selectTabInternal(r4, true);
        return;
    }

    private final int calculateScrollXForTab(int r5, float r6) {
        int r0 = this.tabMode;
        int r1 = 0;
        if (r0 == 0) goto L7;
        if (r0 == 2) goto L7;
        return 0;
    L7:
        View r2 = this.indicator.getChildAt(r5);
        int r7 = r5 + 1;
        if (r7 > this.indicator.getChildCount()) goto L10;
        View r8 = this.indicator.getChildAt(r7);
    L11:
        if (r2 == null) goto L13;
        int r3 = r2.getWidth();
    L14:
        if (r8 == null) goto L17;
        r1 = r8.getWidth();
    L17:
        return (-(((getWidth() / 2) - (r3 / 2)) - r2.getLeft())) + ((int) (((r1 + r3) * 0.5f) * r6));
    L13:
        r3 = 0;
        goto L14
    L10:
        r8 = null;
        goto L11
    }

    private final ColorStateList createColorStateList(int r5, int r6) {
        return new ColorStateList(new int[][]{View.SELECTED_STATE_SET, View.EMPTY_STATE_SET}, new int[]{r6, r5});
    }

    private final void selectTabInternal(com.larksuite.component.universe_design.tab.b r9, boolean r10) {
        if (r9 != null) goto L8;
        c r11 = this.indicator;
        r11.d = -1;
        if (r10 == false) goto L34;
        r11.a(-1);
        return;
    L34:
        return;
    L8:
        dispatchSelectState(r9.f);
        int r1 = getSelectPosition();
        int r2 = r9.f;
        c r3 = this.indicator;
        if (r2 != r3.d) goto L11;
        dispatchTabReselected(r9);
        animateToTab(r9);
    L32:
        dispatchTabSelected(r9);
        return;
    L11:
        if (r10 == false) goto L29;
        animateToTab(r9);
        c r12 = this.indicator;
        boolean r4 = false;
        if (r1 == (-1)) goto L15;
        boolean r5 = true;
    L16:
        r12.getClass();
        Intrinsics.checkNotNullParameter(r9, "tab");
        int r6 = r9.f;
        if (r5 == false) goto L28;
        long r7 = access$getIndicatorAnimatorDuration$p(r12.j);
        ValueAnimator r8 = r12.h;
        if (r8 != null) goto L21;
    L23:
        if (r4 == false) goto L27;
        ValueAnimator r13 = r12.h;
        if (r13 == null) goto L27;
        r13.cancel();
    L27:
        int r14 = r12.d;
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r15.setInterpolator((PathInterpolator) UDAnimation$Interpolator.b.getValue());
        r15.setDuration(r7);
        r15.addUpdateListener(new com.larksuite.component.universe_design.tab.d(r12, r14, r6, r15));
        r15.addListener(new e(r12, r6));
        r15.start();
        r12.h = r15;
    L30:
        if (r1 == (-1)) goto L32;
        dispatchTabUnselected((com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r1));
        goto L32
    L21:
        if (r8.isRunning() != true) goto L23;
        r4 = true;
        goto L23
    L28:
        r12.d = r6;
        r12.a(r6);
        r12.invalidate();
        goto L30
    L15:
        r5 = false;
        goto L16
    L29:
        r3.d = r2;
        goto L30
    }

    public final void addTab(com.larksuite.component.universe_design.tab.b r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        addTab(r2, this.tabs.size(), r3);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "child");
        addViewInternal(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r6) {
        int r0 = View.MeasureSpec.getSize(r5);
        if (View.MeasureSpec.getMode(r5) != 0) goto L5;
        r0 = this.tabMaxWidth;
    L8:
        setupTabMaxWidth(r0);
        super.onMeasure(r5, r6);
        boolean r1 = true;
        if (getChildCount() != 1) goto L27;
        boolean r7 = false;
        View r2 = getChildAt(0);
        int r3 = this.tabMode;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L20;
    L24:
        if (r7 == false) goto L28;
        r2.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), r6);
        return;
    L28:
        return;
    L17:
        if (r2.getMeasuredWidth() != getMeasuredWidth()) goto L23;
    L22:
        r1 = false;
    L23:
        r7 = r1;
    L20:
        if (r2.getMeasuredWidth() >= getMeasuredWidth()) goto L22;
    L27:
        return;
    L5:
        int r4 = this.tabMaxWidth;
        if (r4 <= 0) goto L8;
        r0 = r4;
        goto L8
    }

    public final void selectTab$universe_ui_tab_release(com.larksuite.component.universe_design.tab.b r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        selectTabInternal(r2, r3);
    }

    public final void selectTabAt$universe_ui_tab_release(int r2, boolean r3) {
        if (r2 >= 0) goto L4;
    L6:
        selectTabInternal(null, r3);
        return;
    L4:
        if (r2 >= this.tabs.size()) goto L6;
        selectTab$universe_ui_tab_release((com.larksuite.component.universe_design.tab.b) ListProtector.get(this.tabs, r2), r3);
    }

    public final void setTabIconTintColors(int r1, int r2) {
        this.tabIconTintColors = createColorStateList(r1, r2);
        updateTabsStyle();
    }

    public final void setTabTitleColors(int r1, int r2) {
        this.tabTitleColors = createColorStateList(r1, r2);
        updateTabsStyle();
    }

    public final void addTab(com.larksuite.component.universe_design.tab.b r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        addTab(r2, r3, false);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View r1, ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r1, "child");
        addViewInternal(r1);
    }

    public UDTabLayout(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 2131953906);
    }

    private final void addTabInternal(com.larksuite.component.universe_design.tab.b r1, int r2, boolean r3) {
        addTabToList(r1, r2);
        addTabView(r1, r3);
    }

    private final void applyAttrs(AttributeSet r3, int r4, int r5) {
        TypedArray r6 = getContext().obtainStyledAttributes(r3, new int[]{2130974955, 2130974956, 2130974957, 2130974958, 2130974959, 2130974960, 2130974961, 2130974962, 2130974963, 2130974964, 2130974965, 2130974966, 2130974967, 2130974968, 2130974969, 2130974970, 2130974971, 2130974972, 2130974973, 2130974974, 2130974975, 2130974976, 2130974977, 2130974978}, r4, r5);
        setTabGravity(r6.getInt(3, this.tabGravity));
        setTabMode(r6.getInt(13, this.tabMode));
        ColorStateList r7 = r6.getColorStateList(0);
        if (r7 != null) goto L5;
        r7 = ColorStateList.valueOf(UDColorUtils.getColor(getContext(), 2131100548));
    L5:
        this.tabBackgroundColors = r7;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tabBackgroundColors");
        r7 = null;
    L8:
        setBackgroundColor(r7.getDefaultColor());
        this.tabTitleTextAppearance = r6.getResourceId(23, 2131953910);
        this.tabTitleTextSize = r6.getDimensionPixelSize(22, this.tabTitleTextSize);
        this.tabMultiLineTitleTextSize = r6.getDimensionPixelSize(14, this.tabMultiLineTitleTextSize);
        ColorStateList r8 = r6.getColorStateList(21);
        if (r8 != null) goto L11;
        r8 = UDColorUtils.getColorStateList(getContext(), 2131108995);
    L11:
        this.tabTitleColors = r8;
        ColorStateList r9 = r6.getColorStateList(4);
        if (r9 != null) goto L14;
        r9 = UDColorUtils.getColorStateList(getContext(), 2131108995);
    L14:
        this.tabIconTintColors = r9;
        int r10 = r6.getDimensionPixelSize(15, 0);
        this.tabPaddingStart = r6.getDimensionPixelSize(18, r10);
        this.tabPaddingTop = r6.getDimensionPixelSize(19, r10);
        this.tabPaddingEnd = r6.getDimensionPixelSize(17, r10);
        this.tabPaddingBottom = r6.getDimensionPixelSize(16, r10);
        this.tabMargin = r6.getDimensionPixelSize(20, this.tabMargin);
        this.tabLayoutPaddingStart = r6.getDimensionPixelSize(10, 0);
        this.tabMinWidth = r6.getDimensionPixelSize(12, this.tabMinWidth);
        this.tabMaxWidth = r6.getDimensionPixelSize(11, this.tabMaxWidth);
        c r11 = this.indicator;
        r11.a = r6.getDrawable(5);
        r11.i = true;
        r11.requestLayout();
        if (r6.hasValue(7) == false) goto L17;
        setIndicatorColor(r6.getColor(7, 0));
    L17:
        setIndicatorHeight(r6.getDimensionPixelSize(9, 0));
        this.indicatorAnimatorDuration = r6.getInt(6, (int) this.indicatorAnimatorDuration);
        this.indicatorFullWidth = r6.getBoolean(8, this.indicatorFullWidth);
        this.edgeShadowEnable = r6.getBoolean(2, this.edgeShadowEnable);
        this.bottomDividerEnabled = r6.getBoolean(1, this.bottomDividerEnabled);
        r6.recycle();
    }

    public final void addTab(com.larksuite.component.universe_design.tab.b r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "tab");
        addTabInternal(r2, r3, r4);
    }

    @Override // android.view.ViewGroup
    public void addView(View r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "child");
        addViewInternal(r1);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r1, "child");
        addViewInternal(r1);
    }

    public UDTabLayout(Context r4, AttributeSet r5, int r6, int r7) {
        super(r4, r5, r6, r7);
        c r8 = new c(this, getContext());
        this.indicator = r8;
        this.tabs = new ArrayList();
        this.selectedListeners = new ArrayList();
        this.tabMode = 2;
        this.tabGravity = 1;
        this.tabMaxWidth = -1;
        this.indicatorAnimatorDuration = 300;
        this.edgeShadowEnable = true;
        this.indicatorFullWidth = true;
        this.tabTitleTextAppearance = 2131953910;
        this.tabTitleTextSize = h18.d.d(getContext(), 2131169403);
        this.tabMultiLineTitleTextSize = h18.d.d(getContext(), 2131169404);
        this.scrollBounds = new Rect();
        this.bottomDividerDrawable$delegate = LazyKt.lazy(new UDTabLayout$bottomDividerDrawable$2(this));
        this.bottomDividerEnabled = true;
        applyAttrs(r5, r6, r7);
        super.addView(r8, 0, new FrameLayout.LayoutParams(-2, -2));
    }

    @Override // android.view.View
    public void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        updateEdgeShadow();
    }

    public final void setScrollPosition$universe_ui_tab_release(int r8, float r9, boolean r10, boolean r11) {
        ValueAnimator r0 = this.scrollAnimator;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L13;
        ValueAnimator r3 = this.scrollAnimator;
        if (r3 == null) goto L13;
        r3.cancel();
    L13:
        if (Float.isNaN(r9) == false) goto L15;
        return;
    L15:
        int r4 = MathKt.roundToInt(r8 + r9);
        if (r4 >= 0) goto L18;
        return;
    L18:
        if (r4 >= this.tabs.size()) goto L39;
        scrollTo(calculateScrollXForTab(r8, r9), 0);
        if (r11 == false) goto L34;
        c r12 = this.indicator;
        int r5 = r8 + 1;
        Drawable r6 = r12.a;
        if (r6 == null) goto L34;
        UDTabLayout r7 = r12.j;
        ValueAnimator r13 = r12.h;
        if (r13 != null) goto L27;
    L29:
        if (r1 == false) goto L33;
        ValueAnimator r14 = r12.h;
        if (r14 == null) goto L33;
        r14.cancel();
    L33:
        com.larksuite.component.universe_design.tab.c r15 = r12.f;
        View r16 = r12.getChildAt(r8);
        View r17 = r12.getChildAt(r5);
        r15.getClass();
        com.larksuite.component.universe_design.tab.c.c(r7, r16, r17, r9, r6);
        r12.invalidate();
        goto L34
    L27:
        if (r13.isRunning() != true) goto L29;
        r1 = true;
    L34:
        if (r10 == false) goto L38;
        dispatchSelectState(r4);
        return;
    L38:
        return;
    L39:
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void setTabPadding(int r3, int r4, int r5, int r6) {
        Iterator<com.larksuite.component.universe_design.tab.b> r0 = this.tabs.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().e.setPaddingRelative(r3, r4, r5, r6);
        goto L4
    L6:
        this.indicator.i = true;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        updateEdgeShadow();
    }
}
