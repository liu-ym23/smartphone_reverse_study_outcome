package com.larus.common_ui.widget.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import android.widget.SeekBar;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ñ\u00012\u00020\u0001:\u0006ï\u0001ð\u0001ñ\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010¸\u0001\u001a\u00030¹\u0001H\u0004J$\u0010º\u0001\u001a\u00030¹\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010»\u0001\u001a\u00030¹\u00012\b\u0010³\u0001\u001a\u00030\u0096\u0001J\u0019\u0010¼\u0001\u001a\u00030¹\u00012\t\u0010½\u0001\u001a\u0004\u0018\u00010\u0007¢\u0006\u0003\u0010¾\u0001J\n\u0010¿\u0001\u001a\u00030¹\u0001H\u0004J\n\u0010À\u0001\u001a\u00030¹\u0001H\u0004J\n\u0010Á\u0001\u001a\u00030¹\u0001H\u0002J\n\u0010Â\u0001\u001a\u00030¹\u0001H\u0002J\n\u0010Ã\u0001\u001a\u00030¹\u0001H\u0002J\u0014\u0010Ä\u0001\u001a\u00030¹\u00012\b\u0010Å\u0001\u001a\u00030Æ\u0001H\u0014J\n\u0010Ç\u0001\u001a\u00030¹\u0001H\u0004J\u001c\u0010È\u0001\u001a\u00030¹\u00012\u0007\u0010É\u0001\u001a\u00020\u00072\u0007\u0010Ê\u0001\u001a\u00020\u0007H\u0014J\n\u0010Ë\u0001\u001a\u00030¹\u0001H\u0004J\u0014\u0010Ì\u0001\u001a\u00030\u0096\u00012\b\u0010Í\u0001\u001a\u00030Î\u0001H\u0016J\n\u0010Ï\u0001\u001a\u00030¹\u0001H\u0016J\u0013\u0010Ð\u0001\u001a\u00030¹\u00012\u0007\u0010Ñ\u0001\u001a\u00020\u0007H\u0004J\u0013\u0010Ò\u0001\u001a\u00030¹\u00012\u0007\u0010Ó\u0001\u001a\u00020\u0007H\u0002J\u0010\u0010Ô\u0001\u001a\u00020\u00002\u0007\u0010Õ\u0001\u001a\u00020\u0007J\u0010\u0010Ö\u0001\u001a\u00020\u00002\u0007\u0010×\u0001\u001a\u00020\u0007J\u0007\u0010Ø\u0001\u001a\u00020\u0007J\u0007\u0010Ù\u0001\u001a\u00020\u0007J\u0010\u0010Ú\u0001\u001a\u00020\u00002\u0007\u0010Û\u0001\u001a\u00020\u0007J\u0007\u0010Ü\u0001\u001a\u00020\u0007J\u0010\u0010Ý\u0001\u001a\u00020\u00002\u0007\u0010Þ\u0001\u001a\u00020\u0007J\u0010\u0010ß\u0001\u001a\u00020\u00002\u0007\u0010à\u0001\u001a\u00020BJ\u0010\u0010á\u0001\u001a\u00020\u00002\u0007\u0010Þ\u0001\u001a\u00020\u0007J\u0013\u0010â\u0001\u001a\u00020\u00002\n\u0010ã\u0001\u001a\u0005\u0018\u00010\u009e\u0001J\u001e\u0010ä\u0001\u001a\u00020\u00002\u000f\u0010å\u0001\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010+¢\u0006\u0003\u0010æ\u0001J\u0016\u0010ç\u0001\u001a\u00030¹\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0016J\u001f\u0010ê\u0001\u001a\u00030\u0096\u00012\u0007\u0010ë\u0001\u001a\u00020\u00072\n\u0010ì\u0001\u001a\u0005\u0018\u00010í\u0001H\u0016J\t\u0010î\u0001\u001a\u00020ZH\u0002R\u001a\u0010\n\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010*\u001a\u000e\u0012\n\u0012\b\u0018\u00010,R\u00020\u00000+X\u0084.¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00102\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\f\"\u0004\b4\u0010\u000eR\u001a\u00105\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\f\"\u0004\b7\u0010\u000eR\u001a\u00108\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\f\"\u0004\b:\u0010\u000eR\u001a\u0010;\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\f\"\u0004\b=\u0010\u000eR\u001a\u0010>\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\f\"\u0004\b@\u0010\u000eR\u001a\u0010A\u001a\u00020BX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\f\"\u0004\bI\u0010\u000eR\u001a\u0010J\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\f\"\u0004\bL\u0010\u000eR\u001a\u0010M\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u000eR\u001a\u0010P\u001a\u00020BX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010D\"\u0004\bR\u0010FR\u001a\u0010S\u001a\u00020BX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010D\"\u0004\bU\u0010FR\u001a\u0010V\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\f\"\u0004\bX\u0010\u000eR\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001a\u0010_\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\f\"\u0004\ba\u0010\u000eR\u001a\u0010b\u001a\u00020BX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010D\"\u0004\bd\u0010FR\u001a\u0010e\u001a\u00020fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\f\"\u0004\bm\u0010\u000eR\u000e\u0010n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010o\u001a\u0004\u0018\u00010pX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010u\u001a\u0004\u0018\u00010%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010'\"\u0004\bw\u0010)R\u001a\u0010x\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\f\"\u0004\bz\u0010\u000eR\u001d\u0010{\u001a\u0004\u0018\u00010|X\u0084\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0081\u0001\u001a\u0004\u0018\u00010|X\u0084\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0082\u0001\u0010~\"\u0006\b\u0083\u0001\u0010\u0080\u0001R\u000f\u0010\u0084\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0086\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\f\"\u0005\b\u0088\u0001\u0010\u000eR\u001d\u0010\u0089\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\f\"\u0005\b\u008b\u0001\u0010\u000eR\u001d\u0010\u008c\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\f\"\u0005\b\u008e\u0001\u0010\u000eR\u001d\u0010\u008f\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\f\"\u0005\b\u0091\u0001\u0010\u000eR\u001d\u0010\u0092\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\f\"\u0005\b\u0094\u0001\u0010\u000eR \u0010\u0095\u0001\u001a\u00030\u0096\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0012\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R&\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020Z0¤\u0001X\u0084\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R\u001d\u0010©\u0001\u001a\u00020\u0007X\u0084\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bª\u0001\u0010\f\"\u0005\b«\u0001\u0010\u000eR\u000f\u0010¬\u0001\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u00ad\u0001\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010+X\u0086\u000e¢\u0006\u0015\n\u0003\u0010²\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u0010\u0010³\u0001\u001a\u00030\u0096\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010´\u0001\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010\f\"\u0005\b¶\u0001\u0010\u000eR\u0010\u0010·\u0001\u001a\u00030\u0096\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ò\u0001"}, d2 = {"Lcom/larus/common_ui/widget/datepicker/NumberPicker;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mWidth", "getMWidth", "()I", "setMWidth", "(I)V", "mHeight", "getMHeight", "setMHeight", "mTextPaint", "Landroid/text/TextPaint;", "getMTextPaint", "()Landroid/text/TextPaint;", "setMTextPaint", "(Landroid/text/TextPaint;)V", "mFlagTextPaint", "getMFlagTextPaint", "setMFlagTextPaint", "mTextShadowPaint", "getMTextShadowPaint", "setMTextShadowPaint", "mDividerLinePaint", "Landroid/graphics/Paint;", "getMDividerLinePaint", "()Landroid/graphics/Paint;", "setMDividerLinePaint", "(Landroid/graphics/Paint;)V", "mTextBounds", "Landroid/graphics/Rect;", "getMTextBounds", "()Landroid/graphics/Rect;", "setMTextBounds", "(Landroid/graphics/Rect;)V", "mTextYAxisArray", "", "Lcom/larus/common_ui/widget/datepicker/NumberPicker$NumberHolder;", "getMTextYAxisArray", "()[Lcom/larus/common_ui/widget/datepicker/NumberPicker$NumberHolder;", "setMTextYAxisArray", "([Lcom/larus/common_ui/widget/datepicker/NumberPicker$NumberHolder;)V", "[Lcom/larus/common_ui/widget/datepicker/NumberPicker$NumberHolder;", "mStartYPos", "getMStartYPos", "setMStartYPos", "mEndYPos", "getMEndYPos", "setMEndYPos", "mTextColor", "getMTextColor", "setMTextColor", "mTextShadowColor", "getMTextShadowColor", "setMTextShadowColor", "mDividerColor", "getMDividerColor", "setMDividerColor", "mTextSize", "", "getMTextSize", "()F", "setMTextSize", "(F)V", "mStartNumber", "getMStartNumber", "setMStartNumber", "mEndNumber", "getMEndNumber", "setMEndNumber", "mCurrentNumber", "getMCurrentNumber", "setMCurrentNumber", "mDividerStroke", "getMDividerStroke", "setMDividerStroke", "mDividerLength", "getMDividerLength", "setMDividerLength", "mVerticalSpacing", "getMVerticalSpacing", "setMVerticalSpacing", "mFlagText", "", "getMFlagText", "()Ljava/lang/String;", "setMFlagText", "(Ljava/lang/String;)V", "mFlagTextColor", "getMFlagTextColor", "setMFlagTextColor", "mFlagTextSize", "getMFlagTextSize", "setMFlagTextSize", "mNumberArray", "", "getMNumberArray", "()[I", "setMNumberArray", "([I)V", "mCurrNumIndex", "getMCurrNumIndex", "setMCurrNumIndex", "mTouchSlop", "mHighLightRect", "Landroid/graphics/RectF;", "getMHighLightRect", "()Landroid/graphics/RectF;", "setMHighLightRect", "(Landroid/graphics/RectF;)V", "mTextBoundsFlag", "getMTextBoundsFlag", "setMTextBoundsFlag", "mTouchAction", "getMTouchAction", "setMTouchAction", "mFlingScroller", "Landroid/widget/Scroller;", "getMFlingScroller", "()Landroid/widget/Scroller;", "setMFlingScroller", "(Landroid/widget/Scroller;)V", "mAdjustScroller", "getMAdjustScroller", "setMAdjustScroller", "mMinimumFlingVelocity", "mMaximumFlingVelocity", "mBackgroundColor", "getMBackgroundColor", "setMBackgroundColor", "mStartY", "getMStartY", "setMStartY", "mCurrY", "getMCurrY", "setMCurrY", "mOffsetY", "getMOffsetY", "setMOffsetY", "mSpacing", "getMSpacing", "setMSpacing", "mCanScroll", "", "getMCanScroll", "()Z", "setMCanScroll", "(Z)V", "mVelocityTracker", "Landroid/view/VelocityTracker;", "mOnValueChangeListener", "Lcom/larus/common_ui/widget/datepicker/NumberPicker$OnValueChangeListener;", "getMOnValueChangeListener", "()Lcom/larus/common_ui/widget/datepicker/NumberPicker$OnValueChangeListener;", "setMOnValueChangeListener", "(Lcom/larus/common_ui/widget/datepicker/NumberPicker$OnValueChangeListener;)V", "mDrawedText", "", "getMDrawedText", "()Ljava/util/Set;", "setMDrawedText", "(Ljava/util/Set;)V", "mRowNumber", "getMRowNumber", "setMRowNumber", "mDensity", "mTextArray", "getMTextArray", "()[Ljava/lang/String;", "setMTextArray", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "isNonRecurrent", "mCurrTextYAxisIndex", "getMCurrTextYAxisIndex", "setMCurrTextYAxisIndex", "maximizeScrollableItems", "createTextYAxisArray", "", "readAttrs", "setNonRecurrent", "increaseMaxFlingVelocity", "scrollVelocityFactor", "(Ljava/lang/Integer;)V", "init", "verifyNumber", "initPaint", "initRects", "measureText", "onDraw", "canvas", "Landroid/graphics/Canvas;", "adjustYPosition", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "initTextYAxisArray", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "computeScroll", "computeYPos", "offsetY", "fling", "startYVelocity", "setStartNumber", "startNumber", "setEndNumber", "endNumber", "getStartNumber", "getEndNumber", "setCurrentNumber", "currentNumber", "getCurrentNumber", "setTextColor", "color", "setTextSize", "textSize", "setBackground", "setOnValueChangeListener", "l", "setCustomTextArray", "textArray", "([Ljava/lang/String;)Lcom/larus/common_ui/widget/datepicker/NumberPicker;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "performAccessibilityAction", "action", "arguments", "Landroid/os/Bundle;", "getCurrentText", "NumberHolder", "OnValueChangeListener", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NumberPicker extends View {
    public static final int W = 0;
    public static final int k0 = 0;
    public static final int p0 = 0;
    public RectF A;
    public Rect B;
    public int C;
    public Scroller D;
    public Scroller E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public VelocityTracker N;
    public c O;
    public Set<String> P;
    public int Q;
    public final float R;
    public String[] S;
    public boolean T;
    public int U;
    public boolean V;
    public int a;
    public int b;
    public TextPaint c;
    public TextPaint d;
    public TextPaint e;
    public Paint f;
    public Rect g;
    public b[] h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public int o;
    public int p;
    public int q;
    public float r;
    public float s;
    public int t;
    public String u;
    public int v;
    public float w;
    public int[] x;
    public int y;
    public int z;

    public static final class a {
    }

    public final class b {
        public int a;
        public int b;

        public b(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface c {
        void a(NumberPicker r1, int r2);
    }

    public NumberPicker(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public NumberPicker(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        W = Color.rgb(0, 150, 136);
        k0 = Color.rgb(0, 150, 136);
        p0 = Color.rgb(255, 255, 255);
    }

    private final String getCurrentText() {
        String[] r0 = this.S;
        if (r0 == null) goto L6;
        String r1 = r0[this.y];
        if (r1 == null) goto L6;
        return r1;
    L6:
        Integer r2 = ArraysKt.getOrNull(getMNumberArray(), this.y);
        if (r2 != null) goto L12;
        return "";
    L12:
        return r2.toString();
    }

    public final void a() {
        Scroller r0 = this.E;
        Intrinsics.checkNotNull(r0);
        if (r0.isFinished() == false) goto L8;
        this.I = 0;
        b r1 = getMTextYAxisArray()[0];
        Intrinsics.checkNotNull(r1);
        int r2 = this.i + (Math.round((r1.b - this.i) / this.L) * this.L);
        b r3 = getMTextYAxisArray()[0];
        Intrinsics.checkNotNull(r3);
        int r7 = r2 - r3.b;
        if (r7 == 0) goto L9;
        Scroller r4 = this.E;
        Intrinsics.checkNotNull(r4);
        r4.startScroll(0, 0, 0, r7, 300);
        return;
    L9:
        return;
    }

    public final void c() {
        int r1 = 0;
        if (this.T == false) goto L8;
        this.U = getMTextYAxisArray().length / 2;
        int r0 = getMTextYAxisArray().length;
    L5:
        if (r1 >= r0) goto L7;
        getMTextYAxisArray()[r1] = new b((this.y - 3) + r1, this.i + (this.L * r1));
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L8:
        int r2 = getMTextYAxisArray().length;
    L9:
        if (r1 >= r2) goto L17;
        b r3 = new b((this.y - 3) + r1, this.i + (this.L * r1));
        if (r3.a <= (getMNumberArray().length - 1)) goto L13;
        r3.a -= getMNumberArray().length;
    L16:
        getMTextYAxisArray()[r1] = r3;
        r1 = r1 + 1;
        goto L9
    L13:
        int r4 = r3.a;
        if (r4 >= 0) goto L16;
        r3.a = r4 + getMNumberArray().length;
        goto L16
    }

    @Override // android.view.View
    public final void computeScroll() {
        Scroller r0 = this.D;
        Intrinsics.checkNotNull(r0);
        if (r0.isFinished() == false) goto L7;
        r0 = this.E;
        Intrinsics.checkNotNull(r0);
        if (r0.isFinished() == false) goto L7;
        return;
    L7:
        r0.computeScrollOffset();
        int r1 = r0.getCurrY();
        this.J = r1;
        int r2 = r1 - this.I;
        this.K = r2;
        b(r2);
        invalidate();
        this.I = this.J;
    }

    public final void f() {
        int r0 = this.o;
        int r1 = 0;
        if (r0 >= 0) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L24;
        if (r0 <= this.p) goto L13;
        this.p = r0;
    L13:
        if (this.q >= r0) goto L15;
        this.q = r0;
    L15:
        int r4 = this.q;
        int r5 = this.p;
        if (r4 <= r5) goto L18;
        this.q = r5;
    L18:
        setMNumberArray(new int[(r5 - r0) + 1]);
        int r2 = getMNumberArray().length;
    L19:
        if (r1 >= r2) goto L21;
        getMNumberArray()[r1] = this.o + r1;
        r1 = r1 + 1;
        goto L19
    L21:
        this.y = this.q - this.o;
        return;
    L24:
        throw new IllegalArgumentException("number can not be negative".toString());
    L5:
        if (this.p < 0) goto L7;
        r3 = true;
        goto L8
    }

    public final int[] getMNumberArray() {
        int[] r0 = this.x;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mNumberArray");
        return null;
    }

    public final b[] getMTextYAxisArray() {
        b[] r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mTextYAxisArray");
        return null;
    }

    public final int getCurrentNumber() {
        return this.q;
    }

    public final int getEndNumber() {
        return this.p;
    }

    public final Scroller getMAdjustScroller() {
        return this.E;
    }

    public final int getMBackgroundColor() {
        return this.H;
    }

    public final boolean getMCanScroll() {
        return this.M;
    }

    public final int getMCurrNumIndex() {
        return this.y;
    }

    public final int getMCurrTextYAxisIndex() {
        return this.U;
    }

    public final int getMCurrY() {
        return this.J;
    }

    public final int getMCurrentNumber() {
        return this.q;
    }

    public final int getMDividerColor() {
        return this.m;
    }

    public final float getMDividerLength() {
        return this.s;
    }

    public final Paint getMDividerLinePaint() {
        return this.f;
    }

    public final float getMDividerStroke() {
        return this.r;
    }

    public final Set<String> getMDrawedText() {
        return this.P;
    }

    public final int getMEndNumber() {
        return this.p;
    }

    public final int getMEndYPos() {
        return this.j;
    }

    public final String getMFlagText() {
        return this.u;
    }

    public final int getMFlagTextColor() {
        return this.v;
    }

    public final TextPaint getMFlagTextPaint() {
        return this.d;
    }

    public final float getMFlagTextSize() {
        return this.w;
    }

    public final Scroller getMFlingScroller() {
        return this.D;
    }

    public final int getMHeight() {
        return this.b;
    }

    public final RectF getMHighLightRect() {
        return this.A;
    }

    public final int getMOffsetY() {
        return this.K;
    }

    public final c getMOnValueChangeListener() {
        return this.O;
    }

    public final int getMRowNumber() {
        return this.Q;
    }

    public final int getMSpacing() {
        return this.L;
    }

    public final int getMStartNumber() {
        return this.o;
    }

    public final int getMStartY() {
        return this.I;
    }

    public final int getMStartYPos() {
        return this.i;
    }

    public final String[] getMTextArray() {
        return this.S;
    }

    public final Rect getMTextBounds() {
        return this.g;
    }

    public final Rect getMTextBoundsFlag() {
        return this.B;
    }

    public final int getMTextColor() {
        return this.k;
    }

    public final TextPaint getMTextPaint() {
        return this.c;
    }

    public final int getMTextShadowColor() {
        return this.l;
    }

    public final TextPaint getMTextShadowPaint() {
        return this.e;
    }

    public final float getMTextSize() {
        return this.n;
    }

    public final int getMTouchAction() {
        return this.C;
    }

    public final int getMVerticalSpacing() {
        return this.t;
    }

    public final int getMWidth() {
        return this.a;
    }

    public final int getStartNumber() {
        return this.o;
    }

    public final void b(int r7) {
        int r1 = 0;
        if (this.T == false) goto L51;
        b r0 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r0);
        if (r0.b <= (this.b + this.L)) goto L9;
        if (this.y >= 10) goto L9;
    L13:
        b r2 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r2);
        int r3 = r2.b + r7;
        int r4 = this.b / 2;
        if (r3 <= r4) goto L16;
        b r8 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r8);
        int r9 = r8.b;
    L28:
        r7 = r4 - r9;
    L29:
        int r5 = getMTextYAxisArray().length;
    L30:
        if (r1 >= r5) goto L50;
        b r6 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r6);
        r6.b += r7;
        b r10 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r10);
        if (r10.b < (this.j + this.L)) goto L34;
        b r11 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r11);
        r11.b -= (this.Q + 2) * this.L;
        b r12 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r12);
        r12.a -= this.Q + 2;
    L34:
        b r13 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r13);
        if (r13.b > (this.i - this.L)) goto L37;
        b r14 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r14);
        r14.b += (this.Q + 2) * this.L;
        b r15 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r15);
        r15.a += this.Q + 2;
    L37:
        b r16 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r16);
        if (Math.abs(r16.b - (this.b / 2)) >= (this.L / 4)) goto L49;
        int r17 = this.q;
        b r18 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r18);
        if (r18.a < 0) goto L45;
        b r20 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r20);
        if (r20.a >= getMNumberArray().length) goto L45;
        this.U = r1;
        b r21 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r21);
        this.y = r21.a;
        this.q = getMNumberArray()[this.y];
    L45:
        if (r17 == this.q) goto L49;
        c r22 = this.O;
        if (r22 == null) goto L49;
        Intrinsics.checkNotNull(r22);
        r22.a(this, this.q);
    L49:
        r1 = r1 + 1;
        goto L30
    L50:
        return;
    L16:
        b r23 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r23);
        if (r23.b >= 0) goto L21;
        if (this.y <= (getMNumberArray().length - 10)) goto L21;
    L25:
        b r24 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r24);
        int r25 = r24.b + r7;
        r4 = this.b / 2;
        if (r25 >= r4) goto L29;
        b r26 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r26);
        r9 = r26.b;
    L21:
        if (this.y != (getMNumberArray().length - 1)) goto L23;
        if (r7 < 0) goto L25;
    L23:
        b r27 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r27);
        if (r27.a < (getMNumberArray().length - 1)) goto L29;
    L9:
        if (this.y != 0) goto L11;
        if (r7 > 0) goto L13;
    L11:
        b r28 = getMTextYAxisArray()[this.U];
        Intrinsics.checkNotNull(r28);
        if (r28.a > 0) goto L16;
    L51:
        int r30 = getMTextYAxisArray().length;
    L52:
        if (r1 >= r30) goto L76;
        b r31 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r31);
        r31.b += r7;
        b r32 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r32);
        if (r32.b < (this.j + this.L)) goto L59;
        b r33 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r33);
        r33.b -= (this.Q + 2) * this.L;
        b r34 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r34);
        r34.a -= this.Q + 2;
    L56:
        b r35 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r35);
        if (r35.a >= 0) goto L59;
        b r36 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r36);
        r36.a += getMNumberArray().length;
    L59:
        b r37 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r37);
        if (r37.b > (this.i - this.L)) goto L65;
        b r38 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r38);
        r38.b += (this.Q + 2) * this.L;
        b r40 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r40);
        r40.a += this.Q + 2;
    L62:
        b r41 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r41);
        if (r41.a <= (getMNumberArray().length - 1)) goto L65;
        b r42 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r42);
        r42.a -= getMNumberArray().length;
    L65:
        b r43 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r43);
        if (Math.abs(r43.b - (this.b / 2)) >= (this.L / 4)) goto L75;
        b r44 = getMTextYAxisArray()[r1];
        Intrinsics.checkNotNull(r44);
        int r45 = Math.min(r44.a, getMNumberArray().length - 1);
        this.y = r45;
        int r46 = this.q;
        if (r45 < 0) goto L71;
        this.q = getMNumberArray()[this.y];
    L71:
        if (r46 == this.q) goto L75;
        c r47 = this.O;
        if (r47 == null) goto L75;
        Intrinsics.checkNotNull(r47);
        r47.a(this, this.q);
    L75:
        r1 = r1 + 1;
        goto L52
    }

    public final void d(int r1) {
        this.p = r1;
        f();
        c();
        invalidate();
    }

    public final void e(int r1) {
        this.o = r1;
        f();
        c();
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        r13.drawColor(this.H);
        int r2 = 0;
        if (this.s != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.s = this.a;
    L8:
        float r1 = this.s;
        int r3 = this.a;
        if (r1 <= r3) goto L11;
        r1 = r3;
    L11:
        float r4 = r1 / 2;
        float r5 = (r3 / 2) - r4;
        float r6 = r4 + (r3 / 2);
        RectF r7 = this.A;
        Intrinsics.checkNotNull(r7);
        float r8 = r7.top;
        RectF r9 = this.A;
        Intrinsics.checkNotNull(r9);
        float r10 = r9.top;
        Paint r11 = this.f;
        Intrinsics.checkNotNull(r11);
        r13.drawLine(r5, r8, r6, r10, r11);
        RectF r12 = this.A;
        Intrinsics.checkNotNull(r12);
        float r14 = r12.bottom;
        RectF r15 = this.A;
        Intrinsics.checkNotNull(r15);
        float r16 = r15.bottom;
        Paint r17 = this.f;
        Intrinsics.checkNotNull(r17);
        r13.drawLine(r5, r14, r6, r16, r17);
        if (this.u == null) goto L14;
        int r18 = this.a;
        Rect r20 = this.g;
        Intrinsics.checkNotNull(r20);
        int r21 = (int) (((r18 + r20.width()) / 2) + (this.R * 4));
        String r22 = this.u;
        Intrinsics.checkNotNull(r22);
        int r23 = this.b / 2;
        Rect r24 = this.g;
        Intrinsics.checkNotNull(r24);
        float r25 = (r23 + (r24.height() / 2)) - 4;
        TextPaint r26 = this.d;
        Intrinsics.checkNotNull(r26);
        r13.drawText(r22, r21, r25, r26);
    L14:
        int r27 = getMTextYAxisArray().length;
    L15:
        if (r2 >= r27) goto L35;
        b r28 = getMTextYAxisArray()[r2];
        Intrinsics.checkNotNull(r28);
        if (r28.a < 0) goto L34;
        b r30 = getMTextYAxisArray()[r2];
        Intrinsics.checkNotNull(r30);
        if (r30.a > (this.p - this.o)) goto L34;
        b r31 = getMTextYAxisArray()[r2];
        Intrinsics.checkNotNull(r31);
        if (r31.a < 0) goto L28;
        b r32 = getMTextYAxisArray()[r2];
        Intrinsics.checkNotNull(r32);
        if (r32.a >= getMNumberArray().length) goto L28;
        String[] r33 = this.S;
        if (r33 == null) goto L27;
        Intrinsics.checkNotNull(r33);
        int[] r34 = getMNumberArray();
        b r35 = getMTextYAxisArray()[r2];
        Intrinsics.checkNotNull(r35);
        String r36 = r33[r34[r35.a] - 1];
    L29:
        this.P.contains(r36);
        float r37 = this.a / 2;
        b r38 = getMTextYAxisArray()[r2];
        Intrinsics.checkNotNull(r38);
        int r40 = r38.b;
        Rect r41 = this.g;
        Intrinsics.checkNotNull(r41);
        float r42 = r40 + (r41.height() / 2);
        b r43 = getMTextYAxisArray()[r2];
        Intrinsics.checkNotNull(r43);
        if (r43.a != this.y) goto L32;
        TextPaint r44 = this.c;
    L33:
        Intrinsics.checkNotNull(r44);
        r13.drawText(r36, r37, r42, r44);
        this.P.add(r36);
        goto L34
    L32:
        r44 = this.e;
        goto L33
    L27:
        int[] r45 = getMNumberArray();
        b r46 = getMTextYAxisArray()[r2];
        Intrinsics.checkNotNull(r46);
        r36 = String.valueOf(r45[r46.a]);
    L28:
        r36 = "";
    L34:
        r2 = r2 + 1;
        goto L15
    L35:
        this.P.clear();
        if (1 != this.C) goto L45;
        Scroller r110 = this.D;
        Intrinsics.checkNotNull(r110);
        if (r110.isFinished() == false) goto L46;
        a();
        return;
    L46:
        return;
    L45:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r2) {
        super.onInitializeAccessibilityNodeInfo(r2);
        if (r2 == null) goto L6;
        r2.setScrollable(true);
        r2.setClassName(SeekBar.class.getName());
        r2.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        r2.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "event");
        if (isEnabled() == true) goto L6;
        return false;
    L6:
        if (this.N != null) goto L8;
        this.N = VelocityTracker.obtain();
    L8:
        VelocityTracker r0 = this.N;
        Intrinsics.checkNotNull(r0);
        r0.addMovement(r13);
        int r1 = MotionEventCompat.getActionMasked(r13);
        this.C = r1;
        if (r1 != 0) goto L16;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.I = (int) r13.getY();
        Scroller r14 = this.D;
        Intrinsics.checkNotNull(r14);
        if (r14.isFinished() == false) goto L14;
        Scroller r15 = this.E;
        Intrinsics.checkNotNull(r15);
        if (r15.isFinished() == false) goto L14;
    L48:
        return true;
    L14:
        Scroller r16 = this.D;
        Intrinsics.checkNotNull(r16);
        r16.forceFinished(true);
        Scroller r17 = this.E;
        Intrinsics.checkNotNull(r17);
        r17.forceFinished(true);
        goto L48
    L16:
        if (2 != r1) goto L29;
        int r18 = (int) r13.getY();
        this.J = r18;
        int r110 = r18 - this.I;
        this.K = r110;
        if (this.M == false) goto L20;
    L22:
        this.M = true;
        int r111 = this.K;
        int r2 = this.z;
        if (r111 <= r2) goto L26;
        this.K = r111 - r2;
    L28:
        this.I = this.J;
        b(this.K);
        invalidate();
        goto L48
    L26:
        if (r111 >= (-r2)) goto L28;
        this.K = r111 + r2;
        goto L28
    L20:
        if (Math.abs(r110) >= this.z) goto L22;
        return false;
    L29:
        if (1 != r1) goto L48;
        this.M = false;
        VelocityTracker r112 = this.N;
        Intrinsics.checkNotNull(r112);
        r112.computeCurrentVelocity(1000, this.G);
        int r7 = (int) r112.getYVelocity();
        if (Math.abs(r7) > this.F) goto L33;
        a();
        invalidate();
    L47:
        VelocityTracker r113 = this.N;
        Intrinsics.checkNotNull(r113);
        r113.recycle();
        this.N = null;
        goto L48
    L33:
        if (r7 > 0) goto L35;
        if (r7 < 0) goto L41;
    L45:
        invalidate();
        goto L47
    L41:
        if (this.V == false) goto L43;
        int r11 = Integer.MAX_VALUE;
    L44:
        this.I = r11;
        Scroller r3 = this.D;
        Intrinsics.checkNotNull(r3);
        r3.fling(0, r11, 0, r7, 0, 0, 0, r11);
        goto L45
    L43:
        r11 = (int) (this.n * 10);
        goto L44
    L35:
        if (this.V == false) goto L37;
        int r12 = Integer.MAX_VALUE;
    L38:
        this.I = 0;
        Scroller r4 = this.D;
        Intrinsics.checkNotNull(r4);
        r4.fling(0, 0, 0, r7, 0, 0, 0, r12);
        goto L45
    L37:
        r12 = (int) (this.n * 10);
        goto L38
    }

    public final void setMAdjustScroller(Scroller r1) {
        this.E = r1;
    }

    public final void setMBackgroundColor(int r1) {
        this.H = r1;
    }

    public final void setMCanScroll(boolean r1) {
        this.M = r1;
    }

    public final void setMCurrNumIndex(int r1) {
        this.y = r1;
    }

    public final void setMCurrTextYAxisIndex(int r1) {
        this.U = r1;
    }

    public final void setMCurrY(int r1) {
        this.J = r1;
    }

    public final void setMCurrentNumber(int r1) {
        this.q = r1;
    }

    public final void setMDividerColor(int r1) {
        this.m = r1;
    }

    public final void setMDividerLength(float r1) {
        this.s = r1;
    }

    public final void setMDividerLinePaint(Paint r1) {
        this.f = r1;
    }

    public final void setMDividerStroke(float r1) {
        this.r = r1;
    }

    public final void setMDrawedText(Set<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.P = r2;
    }

    public final void setMEndNumber(int r1) {
        this.p = r1;
    }

    public final void setMEndYPos(int r1) {
        this.j = r1;
    }

    public final void setMFlagText(String r1) {
        this.u = r1;
    }

    public final void setMFlagTextColor(int r1) {
        this.v = r1;
    }

    public final void setMFlagTextPaint(TextPaint r1) {
        this.d = r1;
    }

    public final void setMFlagTextSize(float r1) {
        this.w = r1;
    }

    public final void setMFlingScroller(Scroller r1) {
        this.D = r1;
    }

    public final void setMHeight(int r1) {
        this.b = r1;
    }

    public final void setMHighLightRect(RectF r1) {
        this.A = r1;
    }

    public final void setMNumberArray(int[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.x = r2;
    }

    public final void setMOffsetY(int r1) {
        this.K = r1;
    }

    public final void setMOnValueChangeListener(c r1) {
        this.O = r1;
    }

    public final void setMRowNumber(int r1) {
        this.Q = r1;
    }

    public final void setMSpacing(int r1) {
        this.L = r1;
    }

    public final void setMStartNumber(int r1) {
        this.o = r1;
    }

    public final void setMStartY(int r1) {
        this.I = r1;
    }

    public final void setMStartYPos(int r1) {
        this.i = r1;
    }

    public final void setMTextArray(String[] r1) {
        this.S = r1;
    }

    public final void setMTextBounds(Rect r1) {
        this.g = r1;
    }

    public final void setMTextBoundsFlag(Rect r1) {
        this.B = r1;
    }

    public final void setMTextColor(int r1) {
        this.k = r1;
    }

    public final void setMTextPaint(TextPaint r1) {
        this.c = r1;
    }

    public final void setMTextShadowColor(int r1) {
        this.l = r1;
    }

    public final void setMTextShadowPaint(TextPaint r1) {
        this.e = r1;
    }

    public final void setMTextSize(float r1) {
        this.n = r1;
    }

    public final void setMTextYAxisArray(b[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void setMTouchAction(int r1) {
        this.C = r1;
    }

    public final void setMVerticalSpacing(int r1) {
        this.t = r1;
    }

    public final void setMWidth(int r1) {
        this.a = r1;
    }

    public final void setNonRecurrent(boolean r1) {
        this.T = r1;
        c();
    }

    @Override // android.view.View
    public final void onMeasure(int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        int r1 = View.MeasureSpec.getMode(r5);
        int r6 = View.MeasureSpec.getSize(r4);
        int r7 = View.MeasureSpec.getSize(r5);
        if (r0 == 1073741824) goto L6;
        Rect r8 = this.g;
        Intrinsics.checkNotNull(r8);
        int r9 = (r8.width() + getPaddingLeft()) + getPaddingRight();
        Rect r2 = this.B;
        Intrinsics.checkNotNull(r2);
        r6 = (r9 + r2.width()) + 6;
    L6:
        this.a = r6;
        if (r1 == 1073741824) goto L10;
        int r10 = this.Q;
        Rect r11 = this.g;
        Intrinsics.checkNotNull(r11);
        r7 = getPaddingBottom() + (((r10 * r11.height()) + ((this.Q - 1) * this.t)) + getPaddingTop());
    L10:
        this.b = r7;
        setMeasuredDimension(this.a, r7);
        if (this.A != null) goto L14;
        RectF r12 = new RectF();
        this.A = r12;
        Intrinsics.checkNotNull(r12);
        r12.left = 0.0f;
        RectF r13 = this.A;
        Intrinsics.checkNotNull(r13);
        r13.right = this.a;
        RectF r14 = this.A;
        Intrinsics.checkNotNull(r14);
        int r15 = this.b;
        Rect r3 = this.g;
        Intrinsics.checkNotNull(r3);
        r14.top = ((r15 - r3.height()) - this.t) / 2;
        RectF r16 = this.A;
        Intrinsics.checkNotNull(r16);
        int r17 = this.b;
        Rect r18 = this.g;
        Intrinsics.checkNotNull(r18);
        int r20 = r17 + r18.height();
        int r21 = this.t;
        r16.bottom = (r20 + r21) / 2;
        Rect r22 = this.g;
        Intrinsics.checkNotNull(r22);
        int r23 = r21 + r22.height();
        this.L = r23;
        int r24 = this.b;
        this.i = (r24 / 2) - (r23 * 3);
        this.j = (r24 / 2) + (r23 * 3);
        c();
        return;
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int r3, Bundle r4) {
        if (r3 != 64) goto L5;
        ViewCompat.setStateDescription(this, getCurrentText());
        return super.performAccessibilityAction(r3, r4);
    L5:
        if (r3 != 4096) goto L7;
        b(-this.L);
        a();
        announceForAccessibility(getCurrentText());
        invalidate();
        return true;
    L7:
        if (r3 != 8192) goto L13;
        b(this.L);
        a();
        announceForAccessibility(getCurrentText());
        invalidate();
        return true;
    L13:
        return super.performAccessibilityAction(r3, r4);
    }

    public NumberPicker(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        this.C = 3;
        this.P = new HashSet();
        Resources r1 = getResources();
        float r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density;
        this.R = r2;
        TypedArray r11 = r8.obtainStyledAttributes(r9, new int[]{2130970518, 2130970990, 2130970998, 2130970999, 2130971000, 2130971120, 2130971121, 2130971122, 2130971583, 2130971609, 2130971610, 2130971611, 2130972024, 2130972171, 2130972308, 2130972347}, r10, 0);
        this.k = r11.getColor(2, ContextCompat.getColor(r8, v19.c.b(2130972079, r8, 2131103136)));
        this.n = r11.getDimension(4, 32.0f * r2);
        this.l = r11.getColor(3, ContextCompat.getColor(r8, v19.c.b(2130972080, r8, 2131103140)));
        this.m = r11.getColor(5, W);
        this.o = r11.getInteger(14, 0);
        this.p = r11.getInteger(8, 0);
        this.q = r11.getInteger(1, 0);
        this.t = (int) r11.getDimension(15, 16 * r2);
        this.u = r11.getString(9);
        this.v = r11.getColor(10, k0);
        this.w = r11.getDimension(11, 12.0f * r2);
        this.H = r11.getColor(0, p0);
        this.Q = r11.getInteger(13, 5);
        this.r = r11.getDimension(7, 2 * r2);
        this.s = r11.getDimension(6, 0.0f);
        r11.recycle();
        f();
        TextPaint r12 = new TextPaint();
        this.c = r12;
        Intrinsics.checkNotNull(r12);
        r12.setTextSize(this.n);
        TextPaint r13 = this.c;
        Intrinsics.checkNotNull(r13);
        r13.setColor(this.k);
        TextPaint r14 = this.c;
        Intrinsics.checkNotNull(r14);
        r14.setFlags(1);
        TextPaint r15 = this.c;
        Intrinsics.checkNotNull(r15);
        r15.setTextAlign(Paint.Align.CENTER);
        TextPaint r16 = new TextPaint(this.c);
        this.e = r16;
        Intrinsics.checkNotNull(r16);
        r16.setColor(this.l);
        TextPaint r17 = new TextPaint();
        this.d = r17;
        Intrinsics.checkNotNull(r17);
        r17.setTextSize(this.w);
        TextPaint r18 = this.d;
        Intrinsics.checkNotNull(r18);
        r18.setColor(this.v);
        TextPaint r20 = this.d;
        Intrinsics.checkNotNull(r20);
        r20.setFlags(1);
        TextPaint r21 = this.d;
        Intrinsics.checkNotNull(r21);
        r21.setTextAlign(Paint.Align.LEFT);
        Paint r22 = new Paint();
        this.f = r22;
        Intrinsics.checkNotNull(r22);
        r22.setColor(this.m);
        Paint r23 = this.f;
        Intrinsics.checkNotNull(r23);
        r23.setStyle(Paint.Style.STROKE);
        Paint r24 = this.f;
        Intrinsics.checkNotNull(r24);
        r24.setStrokeWidth(this.r);
        this.g = new Rect();
        this.B = new Rect();
        int r25 = String.valueOf(this.p).length();
        StringBuilder r110 = new StringBuilder();
        int r3 = 0;
    L3:
        if (r3 >= r25) goto L5;
        r110.append("0");
        r3 = r3 + 1;
        goto L3
    L5:
        String r26 = r110.toString();
        TextPaint r111 = this.c;
        Intrinsics.checkNotNull(r111);
        r111.getTextBounds(r26, 0, r26.length(), this.g);
        if (this.u == null) goto L8;
        TextPaint r27 = this.d;
        Intrinsics.checkNotNull(r27);
        String r112 = this.u;
        Intrinsics.checkNotNull(r112);
        r27.getTextBounds(r112, 0, r112.length(), this.B);
    L8:
        ViewConfiguration r28 = ViewConfiguration.get(getContext());
        this.z = ViewConfigurationCompat.getScaledPagingTouchSlop(r28);
        this.F = r28.getScaledMinimumFlingVelocity();
        this.G = r28.getScaledMaximumFlingVelocity() / 8;
        this.D = new Scroller(getContext(), null);
        this.E = new Scroller(getContext(), new DecelerateInterpolator(2.5f));
        setFocusable(true);
        setFocusableInTouchMode(true);
        setImportantForAccessibility(1);
        setMTextYAxisArray(new b[this.Q + 4]);
    }

    public /* synthetic */ NumberPicker(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
