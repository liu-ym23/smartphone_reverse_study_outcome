package com.ss.android.lark.feed.app.tablayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.core.math.MathUtils;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
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
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 Ú\u00012\u00020\u0001:\u0004Ú\u0001Û\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u000b2\b\b\u0002\u0010Q\u001a\u00020\u00112\b\b\u0002\u0010R\u001a\u00020\u0011J\u000e\u0010S\u001a\u00020O2\u0006\u0010T\u001a\u00020UJ+\u0010*\u001a\u00020O2\b\b\u0002\u0010V\u001a\u00020&2\u0019\b\u0002\u0010W\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020O0X¢\u0006\u0002\bYJ!\u0010Z\u001a\u00020O2\u0019\b\u0002\u0010V\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020O0X¢\u0006\u0002\bYJ\b\u0010[\u001a\u00020OH\u0014J\b\u0010\\\u001a\u00020OH\u0014J\b\u0010]\u001a\u00020OH\u0014J\u0010\u0010^\u001a\u00020O2\u0006\u0010_\u001a\u00020KH\u0016J\u0010\u0010`\u001a\u00020O2\u0006\u0010_\u001a\u00020KH\u0016J\b\u0010a\u001a\u00020OH\u0016J\u0010\u0010b\u001a\u00020O2\u0006\u0010c\u001a\u00020dH\u0016J\u0010\u0010e\u001a\u00020O2\u0006\u0010c\u001a\u00020dH\u0014J \u0010f\u001a\u00020\u00112\u0006\u0010c\u001a\u00020d2\u0006\u0010_\u001a\u00020K2\u0006\u0010g\u001a\u00020\u001eH\u0014J\u0010\u0010h\u001a\u00020\u00112\u0006\u0010i\u001a\u00020jH\u0014J\u0018\u0010q\u001a\u00020O2\u0006\u0010r\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u000bH\u0014J\u0018\u0010t\u001a\u00020O2\u0006\u0010r\u001a\u00020\u000b2\u0006\u0010s\u001a\u00020\u000bH\u0007J0\u0010u\u001a\u00020O2\u0006\u0010v\u001a\u00020\u00112\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000b2\u0006\u0010z\u001a\u00020\u000bH\u0014J(\u0010{\u001a\u00020O2\u0006\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000b2\u0006\u0010~\u001a\u00020\u000b2\u0006\u0010\u007f\u001a\u00020\u000bH\u0014J\u0012\u0010\u0084\u0001\u001a\u00020O2\u0007\u0010\u0085\u0001\u001a\u00020\u000bH\u0016J/\u0010\u0086\u0001\u001a\u00020O2\u0006\u0010v\u001a\u00020\u00112\u0006\u0010w\u001a\u00020\u000b2\u0006\u0010x\u001a\u00020\u000b2\u0006\u0010y\u001a\u00020\u000b2\u0006\u0010z\u001a\u00020\u000bJ\n\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0014J\u0015\u0010\u0089\u0001\u001a\u00030\u0088\u00012\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\u0089\u0001\u001a\u00030\u0088\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0014J\u0013\u0010\u0097\u0001\u001a\u00020\u00112\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016J\u0013\u0010\u009a\u0001\u001a\u00020\u00112\b\u0010\u009b\u0001\u001a\u00030\u0099\u0001H\u0016J\u0013\u0010ª\u0001\u001a\u00020O2\b\u0010«\u0001\u001a\u00030¬\u0001H\u0016J\"\u0010\u00ad\u0001\u001a\u00020O2\u0007\u0010«\u0001\u001a\u00020\u000b2\u0007\u0010®\u0001\u001a\u00020\u000b2\u0007\u0010¯\u0001\u001a\u00020\u000bJ\u0010\u0010°\u0001\u001a\u00020O2\u0007\u0010±\u0001\u001a\u00020\u000bJ\u0007\u0010²\u0001\u001a\u00020OJ\u0013\u0010³\u0001\u001a\u00020\u00112\b\u0010´\u0001\u001a\u00030¬\u0001H\u0016J\u001b\u0010µ\u0001\u001a\u00020O2\u0007\u0010¶\u0001\u001a\u00020\u000b2\u0007\u0010·\u0001\u001a\u00020\u000bH\u0016J\t\u0010¸\u0001\u001a\u00020OH\u0016J\u0007\u0010¹\u0001\u001a\u00020\u000bJ\u0007\u0010º\u0001\u001a\u00020\u000bJ\u0018\u0010»\u0001\u001a\u00020O2\u0006\u0010P\u001a\u00020\u000b2\u0007\u0010¼\u0001\u001a\u00020\u0011J\u0019\u0010Ã\u0001\u001a\u00020O2\u0007\u0010Ä\u0001\u001a\u00020\u000b2\u0007\u0010Å\u0001\u001a\u00020\u000bJ\u0010\u0010Æ\u0001\u001a\u00020O2\u0007\u0010\u0016\u001a\u00030¬\u0001J\u0007\u0010Ç\u0001\u001a\u00020OJ\u0010\u0010Ð\u0001\u001a\u00020O2\u0007\u0010Ñ\u0001\u001a\u00020\u000bJ#\u0010Ò\u0001\u001a\u00020O2\u0007\u0010Ó\u0001\u001a\u00020\u000b2\b\u0010Ô\u0001\u001a\u00030¬\u00012\u0007\u0010Õ\u0001\u001a\u00020\u000bJ\u0010\u0010Ö\u0001\u001a\u00020O2\u0007\u0010Ó\u0001\u001a\u00020\u000bJ\u0015\u0010×\u0001\u001a\u00020O2\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ø\u0001H\u0014J\f\u0010Ù\u0001\u001a\u0005\u0018\u00010Ø\u0001H\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR(\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\u0016\u001a\u0004\u0018\u00010&@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001a\u0010/\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015R\u001a\u00102\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010\u000fR\u001a\u00105\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010\u000fR\u001a\u00108\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR\u001a\u0010;\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR\u0011\u0010>\u001a\u00020?¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001b\u0010B\u001a\u00020C8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bD\u0010ER\u0011\u0010H\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bI\u0010\rR\u0013\u0010J\u001a\u0004\u0018\u00010K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001a\u0010k\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\r\"\u0004\bm\u0010\u000fR\u001a\u0010n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\r\"\u0004\bp\u0010\u000fR\u0013\u0010\u0080\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u0013R\u001d\u0010\u0081\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\r\"\u0005\b\u0083\u0001\u0010\u000fR \u0010\u008d\u0001\u001a\u00030\u008e\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0091\u0001\u0010G\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R \u0010\u0092\u0001\u001a\u00030\u0093\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\b\u0096\u0001\u0010G\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0013\u0010\u009c\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\b\u009d\u0001\u0010\u0013R\u0013\u0010\u009e\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b\u009f\u0001\u0010\rR\u0013\u0010 \u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010\rR\u0013\u0010¢\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b£\u0001\u0010\rR\u0013\u0010¤\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b¥\u0001\u0010\rR\u0013\u0010¦\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b§\u0001\u0010\rR\u0013\u0010¨\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b©\u0001\u0010\rR \u0010½\u0001\u001a\u00030¾\u00018FX\u0086\u0084\u0002¢\u0006\u000f\n\u0005\bÁ\u0001\u0010G\u001a\u0006\b¿\u0001\u0010À\u0001R\u0013\u0010Â\u0001\u001a\u00020\u00118F¢\u0006\u0007\u001a\u0005\bÂ\u0001\u0010\u0013R!\u0010È\u0001\u001a\u0004\u0018\u00010UX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R\u001d\u0010Í\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÎ\u0001\u0010\r\"\u0005\bÏ\u0001\u0010\u000f¨\u0006Ü\u0001"}, d2 = {"Lcom/ss/android/lark/feed/app/tablayout/RefactoredFeedTabLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getAttributeSet", "()Landroid/util/AttributeSet;", "itemDefaultHeight", BuildConfig.FLAVOR, "getItemDefaultHeight", "()I", "setItemDefaultHeight", "(I)V", "drawIndicator", BuildConfig.FLAVOR, "getDrawIndicator", "()Z", "setDrawIndicator", "(Z)V", "value", "Lcom/ss/android/lark/feed/app/tablayout/FeedTabIndicator;", "tabIndicator", "getTabIndicator", "()Lcom/ss/android/lark/feed/app/tablayout/FeedTabIndicator;", "setTabIndicator", "(Lcom/ss/android/lark/feed/app/tablayout/FeedTabIndicator;)V", "tabIndicatorAnimationDuration", BuildConfig.FLAVOR, "getTabIndicatorAnimationDuration", "()J", "setTabIndicatorAnimationDuration", "(J)V", "tabDefaultIndex", "getTabDefaultIndex", "setTabDefaultIndex", "Lcom/ss/android/lark/feed/app/tablayout/FeedTabLayoutConfig;", "tabLayoutConfig", "getTabLayoutConfig", "()Lcom/ss/android/lark/feed/app/tablayout/FeedTabLayoutConfig;", "setTabLayoutConfig", "(Lcom/ss/android/lark/feed/app/tablayout/FeedTabLayoutConfig;)V", "tabEnableSelectorMode", "getTabEnableSelectorMode", "setTabEnableSelectorMode", "layoutScrollAnim", "getLayoutScrollAnim", "setLayoutScrollAnim", "scrollAnimDuration", "getScrollAnimDuration", "setScrollAnimDuration", "_minFlingVelocity", "get_minFlingVelocity", "set_minFlingVelocity", "_maxFlingVelocity", "get_maxFlingVelocity", "set_maxFlingVelocity", "_touchSlop", "get_touchSlop", "set_touchSlop", "_tempRect", "Landroid/graphics/Rect;", "get_tempRect", "()Landroid/graphics/Rect;", "feedSelector", "Lcom/ss/android/lark/feed/app/tablayout/FeedSelector;", "getFeedSelector", "()Lcom/ss/android/lark/feed/app/tablayout/FeedSelector;", "feedSelector$delegate", "Lkotlin/Lazy;", "currentItemIndex", "getCurrentItemIndex", "currentItemView", "Landroid/view/View;", "getCurrentItemView", "()Landroid/view/View;", "setCurrentItem", BuildConfig.FLAVOR, "index", "notify", "fromUser", "setupViewPager", "viewPagerDelegate", "Lcom/ss/android/lark/feed/app/tablayout/ViewPagerDelegate;", "config", "doIt", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "configTabLayoutConfig", "onAttachedToWindow", "onDetachedFromWindow", "onFinishInflate", "onViewAdded", "child", "onViewRemoved", "updateTabLayout", "draw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "drawChild", "drawingTime", "verifyDrawable", "who", "Landroid/graphics/drawable/Drawable;", "_childAllWidthSum", "get_childAllWidthSum", "set_childAllWidthSum", "_maxConvexHeight", "get_maxConvexHeight", "set_maxConvexHeight", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measureHorizontal", "onLayout", "changed", "l", "t", "r", "b", "onSizeChanged", SRStrategy.MEDIAINFO_KEY_WIDTH, "h", "oldw", "oldh", "isLayoutRtl", "_layoutDirection", "get_layoutDirection", "set_layoutDirection", "onRtlPropertiesChanged", "layoutDirection", "layoutHorizontal", "generateDefaultLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "generateLayoutParams", "attrs", "p", "Landroid/view/ViewGroup$LayoutParams;", "_overScroller", "Landroid/widget/OverScroller;", "get_overScroller", "()Landroid/widget/OverScroller;", "_overScroller$delegate", "_gestureDetector", "Landroidx/core/view/GestureDetectorCompat;", "get_gestureDetector", "()Landroidx/core/view/GestureDetectorCompat;", "_gestureDetector$delegate", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "needScroll", "getNeedScroll", "maxScrollX", "getMaxScrollX", "maxScrollY", "getMaxScrollY", "minScrollX", "getMinScrollX", "minScrollY", "getMinScrollY", "maxWidth", "getMaxWidth", "maxHeight", "getMaxHeight", "onFlingChange", "velocity", BuildConfig.FLAVOR, "startFling", "min", "max", "startScroll", "dv", "restoreScroll", "onScrollChange", "distance", "scrollTo", "x", "y", "computeScroll", "getViewTargetX", "getViewTargetY", "scrollToTarget", "scrollAnim", "_scrollAnimator", "Landroid/animation/ValueAnimator;", "get_scrollAnimator", "()Landroid/animation/ValueAnimator;", "_scrollAnimator$delegate", "isAnimatorStart", "animateToItem", "fromIndex", "toIndex", "onAnimateValue", "onAnimateEnd", "_viewPagerDelegate", "get_viewPagerDelegate", "()Lcom/ss/android/lark/feed/app/tablayout/ViewPagerDelegate;", "set_viewPagerDelegate", "(Lcom/ss/android/lark/feed/app/tablayout/ViewPagerDelegate;)V", "_viewPagerScrollState", "get_viewPagerScrollState", "set_viewPagerScrollState", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "positionOffsetPixels", "onPageSelected", "onRestoreInstanceState", "Landroid/os/Parcelable;", "onSaveInstanceState", "Companion", "LayoutParams", "feed-tab-layout_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RefactoredFeedTabLayout extends LinearLayout {
    public final AttributeSet a;
    public int b;
    public boolean c;
    public FeedTabIndicator d;
    public long e;
    public int f;
    public FeedTabLayoutConfig g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m;
    public final Rect n;
    public final Lazy o;
    public int p;
    public int q;
    public int r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public int v;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\u000eB!\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0006\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001a\u0010&\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/ss/android/lark/feed/app/tablayout/RefactoredFeedTabLayout$LayoutParams;", "Landroid/widget/LinearLayout$LayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "source", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "width", BuildConfig.FLAVOR, "height", "(II)V", "gravity", BuildConfig.FLAVOR, "(IIF)V", "layoutWidth", BuildConfig.FLAVOR, "getLayoutWidth", "()Ljava/lang/String;", "setLayoutWidth", "(Ljava/lang/String;)V", "layoutHeight", "getLayoutHeight", "setLayoutHeight", "layoutConvexHeight", "getLayoutConvexHeight", "()I", "setLayoutConvexHeight", "(I)V", "indicatorContentIndex", "getIndicatorContentIndex", "setIndicatorContentIndex", "indicatorContentId", "getIndicatorContentId", "setIndicatorContentId", "weight", "getWeight", "()F", "setWeight", "(F)V", "highlightDrawable", "Landroid/graphics/drawable/Drawable;", "getHighlightDrawable", "()Landroid/graphics/drawable/Drawable;", "setHighlightDrawable", "(Landroid/graphics/drawable/Drawable;)V", "feed-tab-layout_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public final int a;
        public final int b;
        public final int c;

        public LayoutParams(ViewGroup.LayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super(r2);
            this.b = -1;
            this.c = -1;
            if ((r2 instanceof LayoutParams) == false) goto L6;
            LayoutParams r3 = (LayoutParams) r2;
            r3.getClass();
            this.a = r3.a;
            return;
        }

        public LayoutParams(int r2) {
            super(-2, r2);
            this.b = -1;
            this.c = -1;
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            Intrinsics.checkNotNullParameter(r3, "c");
            super(r3, r4);
            this.b = -1;
            this.c = -1;
            TypedArray r5 = r3.obtainStyledAttributes(r4, new int[]{2130972480, 2130972481, 2130972482, 2130972483, 2130972484});
            r5.getString(4);
            r5.getString(0);
            this.b = r5.getInt(2, -1);
            this.c = r5.getResourceId(1, -1);
            r5.getFloat(3, -1.0f);
            r5.recycle();
        }
    }

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.feed.app.tablayout.RefactoredFeedTabLayout$setTabLayoutConfig$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/feed/app/tablayout/FeedTabLayoutConfig;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function1<FeedTabLayoutConfig, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        public final void invoke(FeedTabLayoutConfig r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((FeedTabLayoutConfig) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final i get_viewPagerDelegate() {
        return null;
    }

    public final void set_viewPagerDelegate(i r1) {
    }

    public final void setupViewPager(i r2) {
        Intrinsics.checkNotNullParameter(r2, "viewPagerDelegate");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2);
    }

    public final e getFeedSelector() {
        return (e) this.o.getValue();
    }

    public final int getMaxHeight() {
        return (this.p + getPaddingTop()) + getPaddingBottom();
    }

    public final int getMaxWidth() {
        return (this.p + getPaddingStart()) + getPaddingEnd();
    }

    public final int getMinScrollY() {
        if (this.h == true) goto L7;
        return 0;
    L7:
        return (-c.a(this)) / 2;
    }

    public final boolean getNeedScroll() {
        if (this.h == false) goto L6;
        return true;
    L6:
        if (a() == false) goto L11;
        if (getMinScrollX() < 0) goto L16;
    L13:
        return false;
    L16:
        return true;
    L11:
        if (getMaxScrollX() <= 0) goto L13;
        return true;
    }

    public final int getViewTargetX() {
        int r0 = this.d.p;
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L11;
        return getPaddingStart() + (c.b(this) / 2);
    L11:
        return getMeasuredWidth() - getPaddingEnd();
    L9:
        return getPaddingStart();
    }

    public final int getViewTargetY() {
        int r0 = this.d.p;
        if (r0 == 1) goto L9;
        if (r0 == 2) goto L11;
        return getPaddingTop() + (c.a(this) / 2);
    L11:
        return getMeasuredHeight() - getPaddingBottom();
    L9:
        return getPaddingTop();
    }

    public final GestureDetectorCompat get_gestureDetector() {
        return (GestureDetectorCompat) this.t.getValue();
    }

    public final OverScroller get_overScroller() {
        return (OverScroller) this.s.getValue();
    }

    public final ValueAnimator get_scrollAnimator() {
        return (ValueAnimator) this.u.getValue();
    }

    public final boolean a() {
        if (ViewCompat.getLayoutDirection(this) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.View
    public final void computeScroll() {
        if (get_overScroller().computeScrollOffset() == false) goto L10;
        scrollTo(get_overScroller().getCurrX(), get_overScroller().getCurrY());
        invalidate();
        if (get_overScroller().getCurrX() >= getMinScrollX()) goto L7;
    L8:
        get_overScroller().abortAnimation();
        return;
    L7:
        if (get_overScroller().getCurrX() > getMaxScrollX()) goto L8;
        return;
    }

    public final int getCurrentItemIndex() {
        return getFeedSelector().h;
    }

    public final View getCurrentItemView() {
        return (View) CollectionsKt.getOrNull(getFeedSelector().c, getCurrentItemIndex());
    }

    public final int getMaxScrollX() {
        if (a() == true) goto L5;
        int r0 = getMaxWidth() - getMeasuredWidth();
        if (this.h == false) goto L10;
        int r2 = c.b(this) / 2;
    L12:
        return Math.max(r0 + r2, 0);
    L10:
        r2 = 0;
        goto L12
    L5:
        if (this.h == true) goto L14;
        return 0;
    L14:
        return c.b(this) / 2;
    }

    public final int getMaxScrollY() {
        int r0 = getMaxHeight() - getMeasuredHeight();
        if (this.h == false) goto L5;
        int r1 = c.a(this) / 2;
    L7:
        return Math.max(r0 + r1, 0);
    L5:
        r1 = 0;
        goto L7
    }

    public final int getMinScrollX() {
        if (a() == false) goto L10;
        int r0 = getMaxWidth() - getMeasuredWidth();
        if (this.h == false) goto L7;
        int r2 = c.b(this) / 2;
    L13:
        return Math.min(-(r0 + r2), 0);
    L7:
        r2 = 0;
        goto L13
    L10:
        if (this.h == true) goto L12;
        return 0;
    L12:
        return (-c.b(this)) / 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getFeedSelector().h >= 0) goto L6;
        e(this, this.f, false, 6);
        return;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable r0 = super.onSaveInstanceState();
        Bundle r1 = new Bundle();
        r1.putParcelable("old", r0);
        r1.putInt("defaultIndex", this.f);
        r1.putInt("currentIndex", getCurrentItemIndex());
        return r1;
    }

    public final AttributeSet getAttributeSet() {
        return this.a;
    }

    public final boolean getDrawIndicator() {
        return this.c;
    }

    public final int getItemDefaultHeight() {
        return this.b;
    }

    public final boolean getLayoutScrollAnim() {
        return this.i;
    }

    public final int getScrollAnimDuration() {
        return this.j;
    }

    public final int getTabDefaultIndex() {
        return this.f;
    }

    public final boolean getTabEnableSelectorMode() {
        return this.h;
    }

    public final FeedTabIndicator getTabIndicator() {
        return this.d;
    }

    public final long getTabIndicatorAnimationDuration() {
        return this.e;
    }

    public final FeedTabLayoutConfig getTabLayoutConfig() {
        return this.g;
    }

    public final int get_childAllWidthSum() {
        return this.p;
    }

    public final int get_layoutDirection() {
        return this.r;
    }

    public final int get_maxConvexHeight() {
        return this.q;
    }

    public final int get_maxFlingVelocity() {
        return this.l;
    }

    public final int get_minFlingVelocity() {
        return this.k;
    }

    public final Rect get_tempRect() {
        return this.n;
    }

    public final int get_touchSlop() {
        return this.m;
    }

    public final int get_viewPagerScrollState() {
        return this.v;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public final void b(float r17) {
        FeedTabIndicator r2 = this.d;
        r2.F = r17;
        r2.invalidateSelf();
        FeedTabLayoutConfig r3 = this.g;
        if (r3 == null) goto L5;
        int r4 = this.d.G;
    L5:
        if (r3 == null) goto L27;
        List<View> r5 = getFeedSelector().c;
        View r6 = (View) CollectionsKt.getOrNull(r5, this.d.H);
        if (r6 == null) goto L28;
        View r7 = (View) CollectionsKt.getOrNull(r5, this.d.G);
        Intrinsics.checkNotNullParameter(r6, "toView");
        if (Intrinsics.areEqual(r7, r6) == true) goto L29;
        int r8 = r3.h.getTabIndicator().G;
        int r9 = r3.h.getTabIndicator().H;
        if (r3.j == true) goto L13;
        return;
    L13:
        if (r7 == null) goto L20;
        View r10 = (View) r3.p.invoke(r7, Integer.valueOf(r8));
        int r11 = r3.k;
        int r12 = r3.l;
        r3.n.getClass();
        if ((r10 instanceof TextView) == false) goto L17;
        TextView r13 = (TextView) r10;
    L18:
        if (r13 == null) goto L20;
        float r14 = MathUtils.clamp(r17, 0.0f, 1.0f);
        int r15 = (r11 >> 24) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        int r16 = (r11 >> 16) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        int r18 = (r11 >> 8) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        int r19 = r11 & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        int r110 = (r12 >> 24) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        int r20 = (r12 >> 16) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        int r21 = (r18 + ((int) ((((r12 >> 8) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS) - r18) * r14))) << 8;
        r13.setTextColor((r19 + ((int) (r14 * ((r12 & ScreenUtils.MAX_SYSTEM_BRIGHTNESS) - r19)))) | (r21 | (((r16 + ((int) ((r20 - r16) * r14))) << 16) | ((r15 + ((int) ((r110 - r15) * r14))) << 24))));
        goto L20
    L17:
        r13 = null;
    L20:
        View r22 = (View) r3.p.invoke(r6, Integer.valueOf(r9));
        int r23 = r3.l;
        int r24 = r3.k;
        r3.n.getClass();
        if ((r22 instanceof TextView) == false) goto L23;
        TextView r25 = (TextView) r22;
    L24:
        if (r25 == null) goto L31;
        float r1 = MathUtils.clamp(r17, 0.0f, 1.0f);
        int r26 = (r23 >> 24) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        int r27 = (r23 >> 16) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        int r28 = (r23 >> 8) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        int r29 = r23 & ScreenUtils.MAX_SYSTEM_BRIGHTNESS;
        r25.setTextColor((r29 + ((int) (r1 * ((r24 & ScreenUtils.MAX_SYSTEM_BRIGHTNESS) - r29)))) | ((((r26 + ((int) ((((r24 >> 24) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS) - r26) * r1))) << 24) | ((r27 + ((int) ((((r24 >> 16) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS) - r27) * r1))) << 16)) | ((r28 + ((int) ((((r24 >> 8) & ScreenUtils.MAX_SYSTEM_BRIGHTNESS) - r28) * r1))) << 8)));
        return;
    L31:
        return;
    L23:
        r25 = null;
        goto L24
    L29:
        return;
    L28:
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        if (this.c == false) goto L5;
        this.d.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L5:
        super.draw(r5);
        ((ArrayList) getFeedSelector().c).size();
        if (this.c == false) goto L11;
        FeedTabIndicator r0 = this.d;
        if (r0.o <= 4096) goto L12;
        r0.draw(r5);
        return;
    L12:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        if (r2 == null) goto L5;
        return new LayoutParams(r2);
    L5:
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        super.onDraw(r4);
        if (this.c == false) goto L8;
        FeedTabIndicator r0 = this.d;
        if (r0.o >= 4096) goto L9;
        r0.draw(r4);
        return;
    L9:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (getNeedScroll() == false) goto L16;
        if (r2.getActionMasked() != 0) goto L8;
        get_overScroller().abortAnimation();
        get_scrollAnimator().cancel();
    L8:
        if (super.onInterceptTouchEvent(r2) == false) goto L10;
    L13:
        return true;
    L10:
        if (get_gestureDetector().onTouchEvent(r2) == true) goto L13;
        return false;
    L16:
        return super.onInterceptTouchEvent(r2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r3) {
        if ((r3 instanceof Bundle) == false) goto L7;
        Bundle r4 = (Bundle) r3;
        super.onRestoreInstanceState(r4.getParcelable("old"));
        this.f = r4.getInt("defaultIndex", this.f);
        int r5 = r4.getInt("currentIndex", -1);
        getFeedSelector().h = -1;
        if (r5 <= 0) goto L9;
        d(r5, true, false);
        return;
    L9:
        return;
    L7:
        super.onRestoreInstanceState(r3);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int r2) {
        super.onRtlPropertiesChanged(r2);
        if (r2 == this.r) goto L8;
        this.r = r2;
        if (getOrientation() != 0) goto L9;
        requestLayout();
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (getNeedScroll() == false) goto L15;
        get_gestureDetector().onTouchEvent(r4);
        if (r4.getActionMasked() != 3) goto L7;
    L12:
        getParent().requestDisallowInterceptTouchEvent(false);
    L13:
        return true;
    L7:
        if (r4.getActionMasked() == 1) goto L12;
        if (r4.getActionMasked() != 0) goto L13;
        get_overScroller().abortAnimation();
        goto L13
    L15:
        return super.onTouchEvent(r4);
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        super.onViewAdded(r2);
        getFeedSelector().i();
        getFeedSelector().h();
        getFeedSelector().g();
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r2) {
        Intrinsics.checkNotNullParameter(r2, "child");
        super.onViewRemoved(r2);
        getFeedSelector().i();
        getFeedSelector().h();
        getFeedSelector().g();
    }

    public final void setDrawIndicator(boolean r1) {
        this.c = r1;
    }

    public final void setItemDefaultHeight(int r1) {
        this.b = r1;
    }

    public final void setLayoutScrollAnim(boolean r1) {
        this.i = r1;
    }

    public final void setScrollAnimDuration(int r1) {
        this.j = r1;
    }

    public final void setTabDefaultIndex(int r1) {
        this.f = r1;
    }

    public final void setTabEnableSelectorMode(boolean r1) {
        this.h = r1;
    }

    public final void setTabIndicator(FeedTabIndicator r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        this.d = r3;
        r3.g(getContext(), this.a);
    }

    public final void setTabIndicatorAnimationDuration(long r1) {
        this.e = r1;
    }

    public final void setTabLayoutConfig(FeedTabLayoutConfig r4) {
        this.g = r4;
        if (r4 == null) goto L6;
        Context r0 = getContext();
        AttributeSet r1 = this.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        TypedArray r2 = r0.obtainStyledAttributes(r1, new int[]{2130970478, 2130970479, 2130974387, 2130974391, 2130974395, 2130974396, 2130974397, 2130974398, 2130974404, 2130974405, 2130974406, 2130974407, 2130974408, 2130974409, 2130974410, 2130974411, 2130974412, 2130974413, 2130974414, 2130974415, 2130974416, 2130974417, 2130974419, 2130974420, 2130974421, 2130974422, 2130974423, 2130974424, 2130974425, 2130974426, 2130974428, 2130974429, 2130974430, 2130974431, 2130974432, 2130974439, 2130974441, 2130974456});
        r4.k = r2.getColor(36, r4.k);
        r4.l = r2.getColor(2, r4.l);
        r4.i = r2.getBoolean(7, r4.i);
        r4.j = r2.getBoolean(4, r4.j);
        r4.m = r2.getBoolean(6, r4.m);
        r4.o = r2.getResourceId(37, r4.o);
        r2.recycle();
        return;
    }

    public final void set_childAllWidthSum(int r1) {
        this.p = r1;
    }

    public final void set_layoutDirection(int r1) {
        this.r = r1;
    }

    public final void set_maxConvexHeight(int r1) {
        this.q = r1;
    }

    public final void set_maxFlingVelocity(int r1) {
        this.l = r1;
    }

    public final void set_minFlingVelocity(int r1) {
        this.k = r1;
    }

    public final void set_touchSlop(int r1) {
        this.m = r1;
    }

    public final void set_viewPagerScrollState(int r1) {
        this.v = r1;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r2, this.d) == true) goto L8;
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r1) {
        return generateLayoutParams(r1);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public RefactoredFeedTabLayout(final Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6);
        this.a = r6;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Resources r0 = getContext().getResources();
        this.b = ((int) WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) * 40;
        this.c = true;
        this.d = new FeedTabIndicator(this);
        this.e = 300;
        this.j = 250;
        this.n = new Rect();
        this.o = LazyKt.lazy(new RefactoredFeedTabLayout$feedSelector$2(this));
        TypedArray r1 = r5.obtainStyledAttributes(r6, new int[]{2130970478, 2130970479, 2130974387, 2130974391, 2130974395, 2130974396, 2130974397, 2130974398, 2130974404, 2130974405, 2130974406, 2130974407, 2130974408, 2130974409, 2130974410, 2130974411, 2130974412, 2130974413, 2130974414, 2130974415, 2130974416, 2130974417, 2130974419, 2130974420, 2130974421, 2130974422, 2130974423, 2130974424, 2130974425, 2130974426, 2130974428, 2130974429, 2130974430, 2130974431, 2130974432, 2130974439, 2130974441, 2130974456});
        this.b = r1.getDimensionPixelOffset(33, this.b);
        this.f = 0;
        this.c = r1.getBoolean(3, this.c);
        this.h = r1.getBoolean(5, this.h);
        this.i = r1.getBoolean(34, this.i);
        this.j = r1.getInt(35, this.j);
        r1.recycle();
        ViewConfiguration r2 = ViewConfiguration.get(r5);
        this.k = r2.getScaledMinimumFlingVelocity();
        this.l = r2.getScaledMaximumFlingVelocity();
        if (this.c == false) goto L5;
        this.d.g(r5, r6);
    L5:
        setTabLayoutConfig(new FeedTabLayoutConfig(this));
        setWillNotDraw(false);
        setOrientation(0);
        this.r = -1;
        this.s = LazyKt.lazy(new RefactoredFeedTabLayout$_overScroller$2(r5));
        this.t = LazyKt.lazy(new RefactoredFeedTabLayout$_gestureDetector$2(r5, this));
        this.u = LazyKt.lazy(new RefactoredFeedTabLayout$_scrollAnimator$2(this));
    }

    public final void c(int r7, boolean r8) {
        if (getNeedScroll() == true) goto L5;
        return;
    L5:
        View r0 = (View) CollectionsKt.getOrNull(getFeedSelector().c, r7);
        if (r0 != null) goto L8;
    L10:
        FeedTabIndicator r1 = this.d;
        int r2 = FeedTabIndicator.I;
        int r9 = r1.c(r7, r1.p);
        int r3 = getViewTargetX();
        if (this.h == false) goto L16;
        int r10 = r9 - (getMeasuredWidth() / 2);
        int r4 = getScrollX();
    L13:
        int r11 = r10 - r4;
    L14:
        int r5 = r11;
        if (isInEditMode() == true) goto L29;
        if (r8 == false) goto L29;
        get_overScroller().abortAnimation();
        get_overScroller().startScroll(getScrollX(), getScrollY(), r5, 0, this.j);
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L29:
        get_overScroller().abortAnimation();
        scrollBy(r5, 0);
        return;
    L16:
        if (a() == false) goto L20;
        if (r9 >= r3) goto L19;
        r10 = r9 - r3;
        r4 = getScrollX();
        goto L13
    L19:
        int r12 = getScrollX();
    L23:
        r11 = -r12;
        goto L14
    L20:
        if (r9 <= r3) goto L22;
        r10 = r9 - r3;
        r4 = getScrollX();
        goto L13
    L22:
        r12 = getScrollX();
        goto L23
    L8:
        if (ViewCompat.isLaidOut(r0) == true) goto L10;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        if (getFeedSelector().h >= 0) goto L5;
        e(this, this.f, false, 6);
    L5:
        getFeedSelector().i();
        if (((ArrayList) getFeedSelector().c).size() != 0) goto L8;
        setMeasuredDimension(LinearLayout.getDefaultSize(getSuggestedMinimumWidth(), r4), LinearLayout.getDefaultSize(getSuggestedMinimumHeight(), r5));
        return;
    L8:
        super.onMeasure(r4, r5);
    }

    @Override // android.view.View
    public final void scrollTo(int r2, int r3) {
        if (r2 <= getMaxScrollX()) goto L6;
        super.scrollTo(getMaxScrollX(), 0);
        return;
    L6:
        if (r2 >= getMinScrollX()) goto L8;
        super.scrollTo(getMinScrollX(), 0);
        return;
    L8:
        super.scrollTo(r2, 0);
    }

    public final void d(int r7, boolean r8, boolean r9) {
        if (getCurrentItemIndex() != r7) goto L6;
        c(r7, this.d.E);
        return;
    L6:
        e.e(getFeedSelector(), r7, true, r8, r9, 16);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r2, View r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        Intrinsics.checkNotNullParameter(r3, "child");
        return super.drawChild(r2, r3, r4);
    }

    public final void f(int r12, int r13, int r14) {
        if (r12 <= 0) goto L8;
        int r0 = this.k;
        int r1 = this.l;
        if (r12 < r0) goto L10;
        if (r12 > r1) goto L12;
    L13:
        int r3 = r12;
        get_overScroller().abortAnimation();
        get_overScroller().fling(getScrollX(), getScrollY(), r3, 0, r13, r14, 0, 0, getMeasuredWidth(), 0);
        postInvalidate();
        return;
    L12:
        r12 = r1;
    L10:
        r12 = r0;
        goto L13
    L8:
        r0 = -this.l;
        r1 = -this.k;
        if (r12 < r0) goto L10;
        if (r12 <= r1) goto L13;
        goto L12
    }

    public static /* synthetic */ void e(RefactoredFeedTabLayout r0, int r1, boolean r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.d(r1, r2, false);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (getNeedScroll() == true) goto L10;
        if (getScrollX() == 0) goto L7;
    L8:
        scrollTo(0, 0);
        goto L10
    L7:
        if (getScrollY() != 0) goto L8;
    L10:
        if (getFeedSelector().h >= 0) goto L13;
        e(this, this.f, false, 6);
        return;
    L13:
        if (get_overScroller().isFinished() == false) goto L17;
        c(getFeedSelector().h, this.i);
        return;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        boolean r12 = a();
        int r13 = getPaddingStart();
        int r14 = getMeasuredWidth() - getPaddingEnd();
        getMeasuredHeight();
        getPaddingBottom();
        ArrayList r15 = (ArrayList) getFeedSelector().c;
        Iterator r16 = r15.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        ((View) r16.next()).getMeasuredWidth();
        goto L4
    L6:
        getMeasuredWidth();
        Iterator r17 = r15.iterator();
        int r0 = 0;
    L8:
        if (r17.hasNext() == false) goto L32;
        Object r1 = r17.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        View r3 = (View) r1;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.feed.app.tablayout.RefactoredFeedTabLayout.LayoutParams");
        LayoutParams r5 = (LayoutParams) r4;
        if (r12 == false) goto L15;
        r14 = r14 - r5.getMarginEnd();
    L16:
        int r6 = ((LinearLayout.LayoutParams) r5).gravity;
        if (r6 == 0) goto L22;
        if (r6 <= 0) goto L22;
        if ((r6 & 16) != 16) goto L22;
        boolean r18 = true;
    L23:
        if (r18 == false) goto L25;
        int r19 = getMeasuredHeight() - getPaddingBottom();
        int r20 = ((((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - this.q) / 2) - (r3.getMeasuredHeight() / 2);
    L26:
        int r21 = r19 - r20;
        if (r12 == false) goto L29;
        r3.layout(r14 - r3.getMeasuredWidth(), r21 - r3.getMeasuredHeight(), r14, r21);
        r14 = r14 - (r3.getMeasuredWidth() + r5.getMarginStart());
    L30:
        r0 = r2;
        goto L8
    L29:
        r3.layout(r13, r21 - r3.getMeasuredHeight(), r3.getMeasuredWidth() + r13, r21);
        r13 = r13 + (r3.getMeasuredWidth() + r5.getMarginEnd());
        goto L30
    L25:
        r19 = getMeasuredHeight();
        r20 = getPaddingBottom();
    L22:
        r18 = false;
        goto L23
    L15:
        r13 = r13 + r5.getMarginStart();
        goto L16
    L32:
        if (getNeedScroll() == true) goto L39;
        if (getScrollX() == 0) goto L36;
    L37:
        scrollTo(0, 0);
        goto L39
    L36:
        if (getScrollY() != 0) goto L37;
    L39:
        if (getFeedSelector().h >= 0) goto L42;
        e(this, this.f, false, 6);
        return;
    L42:
        if (get_overScroller().isFinished() == false) goto L50;
        c(getFeedSelector().h, this.i);
        return;
    }
}
