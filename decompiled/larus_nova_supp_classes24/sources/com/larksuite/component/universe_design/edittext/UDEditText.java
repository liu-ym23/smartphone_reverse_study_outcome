package com.larksuite.component.universe_design.edittext;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import h18.d;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b&\b\u0016\u0018\u0000 \u00ad\u00012\u00020\u0001:\u0004\u00ad\u0001®\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010P\u001a\u00020Q2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010R\u001a\u00020Q2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010S\u001a\u00020QH\u0002J\b\u0010T\u001a\u00020QH\u0002J\u0010\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0010\u0010[\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010\\\u001a\u00020QH\u0002J\u0010\u0010]\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010^\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010_\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020ZH\u0002J\b\u0010`\u001a\u00020QH\u0002J\b\u0010a\u001a\u00020QH\u0002J\b\u0010b\u001a\u00020QH\u0002J$\u0010c\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010d2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u0007H\u0002J \u0010h\u001a\u00020d2\u0006\u0010e\u001a\u00020d2\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u0007H\u0002J\u0010\u0010i\u001a\u00020Q2\u0006\u0010j\u001a\u00020kH\u0014J0\u0010l\u001a\u00020Q2\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0007H\u0002J*\u0010q\u001a\u00020Q2\u0006\u0010j\u001a\u00020k2\u0006\u0010r\u001a\u00020\u00072\u0006\u0010s\u001a\u00020\u00072\b\u0010t\u001a\u0004\u0018\u00010\u001aH\u0002J0\u0010u\u001a\u00020Q2\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0007H\u0002J\b\u0010v\u001a\u00020QH\u0002J\u0018\u0010w\u001a\u00020\u00072\u0006\u0010x\u001a\u00020B2\u0006\u0010y\u001a\u00020zH\u0002J\b\u0010{\u001a\u00020BH\u0002J\u0012\u0010|\u001a\u00020\u00072\b\u0010}\u001a\u0004\u0018\u00010~H\u0002J\b\u0010\u007f\u001a\u00020\u001dH\u0002J1\u0010\u0080\u0001\u001a\u00020Q2\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0007H\u0002J\u001b\u0010\u0081\u0001\u001a\u00020\u001d2\u0007\u0010\u0082\u0001\u001a\u00020%2\u0007\u0010\u0083\u0001\u001a\u00020\u001dH\u0002J1\u0010\u0084\u0001\u001a\u00020Q2\u0006\u0010j\u001a\u00020k2\u0006\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u00072\u0006\u0010p\u001a\u00020\u0007H\u0002J\u001a\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00020\u001a2\u0006\u0010g\u001a\u00020\u0007H\u0002J\t\u0010\u0087\u0001\u001a\u00020\u0007H\u0002J\u0016\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u00012\b\u0010}\u001a\u0004\u0018\u00010BH\u0002J\u0007\u0010\u008a\u0001\u001a\u00020QJ\u0010\u0010\u008a\u0001\u001a\u00020Q2\u0007\u0010\u008b\u0001\u001a\u00020\u001aJ\u0012\u0010\u008c\u0001\u001a\u00020Q2\u0007\u0010\u008b\u0001\u001a\u00020\u001aH\u0002J\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001aJ\u0007\u0010\u008e\u0001\u001a\u00020QJ\u0010\u0010\u008e\u0001\u001a\u00020Q2\u0007\u0010\u008f\u0001\u001a\u00020\u001aJ\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001aJ\u0007\u0010\u0091\u0001\u001a\u00020\u001dJ\u0007\u0010\u0092\u0001\u001a\u00020\u001dJ\u0010\u0010\u0093\u0001\u001a\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020\u001dJ\u0010\u0010\u0094\u0001\u001a\u00020\u00002\u0007\u0010\u0083\u0001\u001a\u00020\u001dJ\u0010\u0010\u0095\u0001\u001a\u00020Q2\u0007\u0010\u0082\u0001\u001a\u00020%J\u0007\u0010\u0096\u0001\u001a\u00020%J\u0010\u0010\u0097\u0001\u001a\u00020Q2\u0007\u0010\u0082\u0001\u001a\u00020%J\u0007\u0010\u0098\u0001\u001a\u00020%J\u0010\u0010\u0099\u0001\u001a\u00020Q2\u0007\u0010\u0082\u0001\u001a\u00020%J\u0007\u0010\u009a\u0001\u001a\u00020%J\u0012\u0010\u009b\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u0007J\u0012\u0010\u009b\u0001\u001a\u00020\u00002\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001aJ\u0012\u0010\u009d\u0001\u001a\u00020\u00002\t\b\u0001\u0010\u009c\u0001\u001a\u00020\u0007J\u0012\u0010\u009d\u0001\u001a\u00020\u00002\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u009e\u0001\u001a\u00020\u00002\u0007\u0010\u009f\u0001\u001a\u00020@J\u0010\u0010 \u0001\u001a\u00020\u00002\u0007\u0010¡\u0001\u001a\u00020\u0007J\u0007\u0010¢\u0001\u001a\u00020\u0007J\u0010\u0010£\u0001\u001a\u00020\u00002\u0007\u0010¤\u0001\u001a\u00020\u001dJ\u0007\u0010¥\u0001\u001a\u00020\u001dJ\u0010\u0010¦\u0001\u001a\u00020\u00002\u0007\u0010§\u0001\u001a\u00020BJ-\u0010¨\u0001\u001a\u00020Q2\u0007\u0010©\u0001\u001a\u00020\u00072\u0007\u0010ª\u0001\u001a\u00020\u00072\u0007\u0010«\u0001\u001a\u00020\u00072\u0007\u0010¬\u0001\u001a\u00020\u0007H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010C\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010B@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bD\u0010ER\u0010\u0010F\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010G\u001a\u0004\u0018\u00010B2\b\u0010A\u001a\u0004\u0018\u00010B@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bH\u0010ER\u0010\u0010I\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¯\u0001"}, d2 = {"Lcom/larksuite/component/universe_design/edittext/UDEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mBgColor", "Landroid/content/res/ColorStateList;", "mStrokeColor", "mStrokeWidth", "mStrokeRadius", "mErrorStrokeColor", "mInnerPaddingTop", "mInnerPaddingBottom", "mInnerPaddingLeft", "mInnerPaddingRight", "mExtraPaddingTop", "mExtraPaddingBottom", "mExtraPaddingLeft", "mExtraPaddingRight", "mNormalDrawable", "Landroid/graphics/drawable/Drawable;", "mErrorDrawable", "mIsErrorState", "", "errorStateFromUser", "mClearBtnEnabled", "mClearIconDrawable", "mPasswordToggleEnabled", "mShowPasswordDrawable", "mHidePasswordDrawable", "mActionBtnShownMode", "Lcom/larksuite/component/universe_design/edittext/UDEditText$ActionButtonShownMode;", "mClearBtnShownMode", "mPasswordToggleBtnShownMode", "mPasswordIsVisible", "mIconPadding", "mIconWidth", "mIconHeight", "mActionButtonWidth", "mActionButtonHeight", "mRightIconMargin", "mLeftIconMargin", "mLeftIconTint", "mRightIconTint", "mClearIconTint", "mPasswordToggleIconTint", "mLeftIconDrawable", "mRightIconDrawable", "mMinCharacterCount", "mCounterMaxLength", "mCounterEnabled", "mBottomTextMargin", "mBottomTextHeight", "mTextPaint", "Landroid/text/TextPaint;", "mIconBgPaint", "mCharactersCountIsValid", "mLengthChecker", "Lcom/larksuite/component/universe_design/edittext/ILengthChecker;", "value", "", "mRightTagText", "setMRightTagText", "(Ljava/lang/String;)V", "rightTagDrawable", "mBottomTagText", "setMBottomTagText", "bottomTagDrawable", "mTextTagHeight", "mTextTagHorizontalPadding", "mIconShowPress", "mCornerRadius", "mTransformationMethod", "Landroid/text/method/TransformationMethod;", "initView", "", "initInnerPadding", "initEditText", "initBackground", "mActionIconTouched", "mActionIconClicking", "mIconViewClicking", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "insideIconView", "togglePasswordIconVisibility", "insideActionIcon", "insideClearActionIcon", "insideShowPasswordActionIcon", "handleSwitchPasswordInputVisibility", "initTextWatcher", "initPadding", "generateIconBitmap", "Landroid/graphics/Bitmap;", "origin", "iconWidth", "iconHeight", "scaleIcon", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawTextTag", "startX", "endX", "startY", "endY", "drawTagDrawable", "dx", "dy", "tagDrawable", "drawCharacterCounter", "checkCharactersCount", "getTextWidth", "content", "textSizeDp", "", "getCharacterCounterText", "getCharacterLength", "text", "Landroid/text/Editable;", "showCharacterCount", "drawIcons", "isShowActionButton", "mode", "enable", "drawActionButton", "getIconTop", "drawable", "getRightTagTop", "buildTagDrawable", "Lcom/larksuite/component/universe_design/tag/UDTagsDrawable;", "showErrorBg", "errorDrawable", "showErrorBgInner", "getErrorBg", "showNormalBg", "normalDrawable", "getNormalBg", "isClearBtnEnabled", "isPasswordToggleEnabled", "setClearBtnEnabled", "setPasswordToggleEnabled", "setActionButtonShownMode", "getActionButtonShownMode", "setClearButtonShownMode", "getClearButtonShownMode", "setPasswordToggleButtonShownMode", "getPasswordToggleButtonShownMode", "setIconLeft", "res", "setIconRight", "setLengthChecker", "lengthChecker", "setCounterMaxLength", "max", "getCounterMaxLength", "setCounterEnabled", "counterEnabled", "isCounterEnabled", "setRightTagText", "rightTagText", "setPadding", "left", "top", "right", "bottom", "Companion", "ActionButtonShownMode", "universe-ui-edittext_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDEditText extends AppCompatEditText {
    public static final /* synthetic */ int k0 = 0;
    public final int A;
    public final int B;
    public Drawable C;
    public final Drawable D;
    public final int E;
    public final boolean F;
    public int G;
    public int H;
    public final TextPaint I;
    public final TextPaint J;
    public boolean K;
    public String L;
    public UDTagsDrawable M;
    public String N;
    public UDTagsDrawable O;
    public int P;
    public int Q;
    public final boolean R;
    public final int S;
    public TransformationMethod T;
    public boolean U;
    public boolean V;
    public boolean W;
    public final int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Drawable i;
    public Drawable j;
    public boolean k;
    public boolean l;
    public Drawable m;
    public final boolean n;
    public Drawable o;
    public Drawable p;
    public ActionButtonShownMode q;
    public ActionButtonShownMode r;
    public ActionButtonShownMode s;
    public boolean t;
    public final int u;
    public final int v;
    public final int w;
    public int x;
    public int y;
    public final int z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/universe_design/edittext/UDEditText$ActionButtonShownMode;", "", "<init>", "(Ljava/lang/String;I)V", "SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY", "SHOW_WHEN_NOT_EMPTY", "SHOW_WHEN_HAS_FOCUS", "ALWAYS_SHOW", "universe-ui-edittext_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ActionButtonShownMode extends Enum<ActionButtonShownMode> {
        public static final ActionButtonShownMode ALWAYS_SHOW = null;
        public static final ActionButtonShownMode SHOW_WHEN_HAS_FOCUS = null;
        public static final ActionButtonShownMode SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY = null;
        public static final ActionButtonShownMode SHOW_WHEN_NOT_EMPTY = null;
        public static final /* synthetic */ ActionButtonShownMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ActionButtonShownMode> getEntries() {
            return b;
        }

        static {
            ActionButtonShownMode r0 = new ActionButtonShownMode("SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY", 0);
            SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY = r0;
            ActionButtonShownMode r1 = new ActionButtonShownMode("SHOW_WHEN_NOT_EMPTY", 1);
            SHOW_WHEN_NOT_EMPTY = r1;
            ActionButtonShownMode r3 = new ActionButtonShownMode("SHOW_WHEN_HAS_FOCUS", 2);
            SHOW_WHEN_HAS_FOCUS = r3;
            ActionButtonShownMode r5 = new ActionButtonShownMode("ALWAYS_SHOW", 3);
            ALWAYS_SHOW = r5;
            ActionButtonShownMode[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static ActionButtonShownMode[] values() {
            return (ActionButtonShownMode[]) a.clone();
        }

        public static ActionButtonShownMode valueOf(String r1) {
            return (ActionButtonShownMode) r27.a.a(ActionButtonShownMode.class, r1);
        }

        public ActionButtonShownMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public UDEditText(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 14, 0);
    }

    public UDEditText(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 12, 0);
    }

    public UDEditText(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, 8, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h() {
        this.f = 0;
        this.h = 0;
        this.g = 0;
        if (this.l == false) goto L6;
        this.h = (this.z + this.x) + 0;
    L6:
        if (this.n == false) goto L9;
        this.h += this.z + this.x;
    L9:
        if (this.D == null) goto L11;
        this.h += this.z + this.v;
    L11:
        String r0 = this.L;
        if (r0 == null) goto L15;
        this.h += (this.z + f(r0)) + this.Q;
    L15:
        if (this.C == null) goto L18;
        this.g = this.v + this.A;
    L18:
        if (u() == false) goto L21;
        this.f += this.H + this.G;
    L21:
        if (TextUtils.isEmpty(this.N) == true) goto L23;
        this.f += this.P + this.G;
    L23:
        super/*android.widget.EditText*/.setPaddingRelative(this.d + this.g, this.b, this.e + this.h, this.c + this.f);
    }

    public final void o() {
        this.C = null;
        h();
    }

    private final String getCharacterCounterText() {
        if (this.E <= 0) goto L9;
        StringBuilder r0 = new StringBuilder();
        Editable r1 = getText();
        if (r1 != null) goto L7;
        int r2 = 0;
    L8:
        r0.append(r2);
        r0.append(" / ");
        r0.append(this.E);
        return r0.toString();
    L7:
        r2 = r1.length();
        goto L8
    L9:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getRightTagTop() {
        if (TextUtils.isEmpty(this.N) == false) goto L9;
        if (u() == true) goto L9;
        return (((getHeight() - this.b) - this.c) - this.P) / 2;
    L9:
        return (((((getHeight() - this.b) - this.c) - this.P) - this.H) - this.G) / 2;
    }

    public final boolean u() {
        if (this.E > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.F == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v() {
        Drawable r0 = this.j;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r0, "errorDrawable");
        this.k = true;
        this.j = r0;
        setBackground(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w() {
        Drawable r0 = this.i;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r0, "normalDrawable");
        this.i = r0;
        setBackground(r0);
        this.k = false;
        return;
    }

    public final void d() {
        if (u() == false) goto L13;
        Editable r0 = getText();
        boolean r1 = false;
        if (r0 != null) goto L8;
        int r2 = 0;
    L9:
        if (r2 < 0) goto L14;
        int r3 = this.E;
        if (r3 <= 0) goto L13;
        if (r2 <= r3) goto L13;
    L14:
        this.K = r1;
        return;
    L8:
        r2 = r0.length();
    L13:
        r1 = true;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        int r0 = getSelectionStart();
        int r1 = getSelectionEnd();
        if (this.t == false) goto L5;
        TransformationMethod r2 = this.T;
    L6:
        setTransformationMethod(r2);
        setSelection(r0, r1);
        return;
    L5:
        this.T = getTransformationMethod();
        r2 = PasswordTransformationMethod.getInstance();
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n() {
        this.C = UDIconUtils.getIconDrawable(getContext(), 2131255040, this.B);
        h();
    }

    public final ActionButtonShownMode getActionButtonShownMode() {
        return this.q;
    }

    public final ActionButtonShownMode getClearButtonShownMode() {
        return this.r;
    }

    public final int getCounterMaxLength() {
        return this.E;
    }

    public final Drawable getErrorBg() {
        return this.j;
    }

    public final Drawable getNormalBg() {
        return this.i;
    }

    public final ActionButtonShownMode getPasswordToggleButtonShownMode() {
        return this.s;
    }

    private final void setMBottomTagText(String r2) {
        if (Intrinsics.areEqual(this.N, r2) == true) goto L6;
        this.N = r2;
        this.O = c(r2);
        return;
    }

    private final void setMRightTagText(String r2) {
        if (Intrinsics.areEqual(this.L, r2) == true) goto L6;
        this.L = r2;
        this.M = c(r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final UDTagsDrawable c(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        UDTagsDrawable.a r0 = new UDTagsDrawable.a(getContext());
        r0.d = this.P;
        UDTagsDrawable.d.a r1 = new UDTagsDrawable.d.a(getContext());
        r1.c = r4;
        r1.c(UDTagsDrawable.TagColorSet.GRAY);
        r0.a(r1.b());
        return r0.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int e(int r3) {
        if (TextUtils.isEmpty(this.N) == false) goto L9;
        if (u() == true) goto L9;
        return (((getHeight() - this.b) - this.c) - r3) / 2;
    L9:
        return (((((getHeight() - this.b) - this.c) - r3) - this.H) - this.G) / 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int f(String r4) {
        this.I.setTextSize(d.a(getContext(), 12.0f));
        return (int) this.I.measureText(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean i(MotionEvent r9) {
        if (k(r9) == false) goto L5;
        return true;
    L5:
        if (this.n == false) goto L22;
        float r0 = r9.getX();
        float r10 = r9.getY();
        int r3 = getWidth();
        int r4 = getHeight();
        int r5 = r3 - this.e;
        int r6 = this.z;
        int r7 = (r5 - r6) - this.x;
        if (this.D == null) goto L10;
        int r8 = r6 + this.v;
        r7 = r7 - r8;
        r3 = r3 - r8;
    L10:
        String r11 = this.L;
        if (r11 == null) goto L13;
        int r12 = (f(r11) + this.Q) + this.z;
        r7 = r7 - r12;
        r3 = r3 - r12;
    L13:
        int r13 = getScrollY();
        if (r0 < r7) goto L22;
        if (r0 >= r3) goto L22;
        if (r10 < r13) goto L22;
        if (r10 >= r4) goto L22;
        boolean r14 = true;
    L23:
        if (r14 == true) goto L28;
        return false;
    L28:
        return true;
    L22:
        r14 = false;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k(MotionEvent r9) {
        if (this.l == true) goto L5;
        return false;
    L5:
        float r0 = r9.getX();
        float r10 = r9.getY();
        int r2 = getWidth();
        int r3 = getHeight();
        int r4 = r2 - this.e;
        int r5 = this.z;
        int r6 = this.x;
        int r7 = (r4 - r5) - r6;
        if (this.n == false) goto L9;
        r7 = r7 - (r5 + r6);
        r2 = r2 - ((r5 / 2) + r6);
    L9:
        if (this.D == null) goto L11;
        int r8 = r5 + this.v;
        r7 = r7 - r8;
        r2 = r2 - r8;
    L11:
        String r11 = this.L;
        if (r11 == null) goto L14;
        int r12 = (f(r11) + this.Q) + this.z;
        r7 = r7 - r12;
        r2 = r2 - r12;
    L14:
        int r13 = getScrollY();
        if (r0 >= r7) goto L17;
        return false;
    L17:
        if (r0 < r2) goto L19;
        return false;
    L19:
        if (r10 >= r13) goto L21;
        return false;
    L21:
        if (r10 >= r3) goto L27;
        return true;
    L27:
        return false;
    }

    public final void m(boolean r1) {
        this.l = r1;
        h();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        int r0 = getScrollX();
        int r8 = getScrollX() + getWidth();
        int r9 = getScrollY();
        int r10 = getScrollY() + getHeight();
        Drawable r1 = this.C;
        if (r1 == null) goto L6;
        int r2 = this.d + r0;
        int r3 = (this.b + r9) + e(this.w);
        r1.setBounds(r2, r3, this.v + r2, this.w + r3);
        r1.draw(r13);
    L6:
        if (this.W == false) goto L8;
        int r4 = r8 - this.e;
        int r5 = r4 - this.v;
        int r6 = this.u * 2;
        int r7 = this.b + r9;
        int r11 = (this.w + r7) + r6;
        this.J.setColor(getContext().getResources().getColor(2131109039));
        float r12 = this.S;
        r13.drawRoundRect(r5 - r6, r7, r4, r11, r12, r12, this.J);
    L8:
        Drawable r14 = this.D;
        if (r14 == null) goto L12;
        int r15 = ((r8 - this.e) - this.v) - this.u;
        int r16 = (this.b + r9) + e(this.w);
        r14.setBounds(r15, r16, this.v + r15, this.w + r16);
        r14.draw(r13);
    L12:
        if (this.L == null) goto L22;
        UDTagsDrawable r17 = this.M;
        if (r17 == null) goto L22;
        int r19 = r17.getIntrinsicWidth();
        r17.getIntrinsicHeight();
        if (this.D == null) goto L19;
        int r20 = ((r8 - this.e) - r19) - this.v;
        r19 = this.z;
    L20:
        int r21 = r20 - r19;
        int r22 = (this.b + r9) + getRightTagTop();
        r13.save();
        r13.translate(r21, r22);
        r17.draw(r13);
        r13.restore();
        goto L22
    L19:
        r20 = r8 - this.e;
    L22:
        if (this.N == null) goto L31;
        UDTagsDrawable r23 = this.O;
        if (r23 == null) goto L31;
        int r24 = r23.getIntrinsicWidth();
        r23.getIntrinsicHeight();
        if (u() == false) goto L29;
        int r25 = (r8 - this.e) - f(getCharacterCounterText());
        int r26 = this.z;
    L30:
        int r27 = (r25 - r26) - r24;
        int r29 = (r10 - this.c) - this.P;
        r13.save();
        r13.translate(r27, r29);
        r23.draw(r13);
        r13.restore();
        goto L31
    L29:
        r26 = this.e;
        r25 = r8;
    L31:
        boolean r30 = l(this.r, this.l);
        boolean r31 = l(this.s, this.n);
        if (isEnabled() == false) goto L36;
        if (r30 == true) goto L35;
        if (r31 == false) goto L36;
    L35:
        boolean r32 = true;
    L37:
        if (r32 == false) goto L65;
        if (r30 == false) goto L51;
        int r33 = (r8 - this.e) - this.x;
        Drawable r34 = this.m;
        if (r34 == null) goto L51;
        if (this.D == null) goto L44;
        r33 = r33 - (this.v + this.z);
    L44:
        String r35 = this.L;
        if (r35 == null) goto L48;
        r33 = r33 - ((f(r35) + this.Q) + this.z);
    L48:
        if (this.n == false) goto L50;
        r33 = r33 - (this.x + this.z);
    L50:
        int r36 = (this.b + r9) + e(this.y);
        r34.setBounds(r33, r36, this.x + r33, this.y + r36);
        r34.draw(r13);
    L51:
        if (r31 == false) goto L65;
        int r37 = (r8 - this.e) - this.x;
        if (this.t == false) goto L55;
        Drawable r38 = this.o;
    L56:
        if (r38 == null) goto L65;
        if (this.D == null) goto L60;
        r37 = r37 - (this.v + this.z);
    L60:
        String r39 = this.L;
        if (r39 == null) goto L63;
        r37 = r37 - ((f(r39) + this.Q) + this.z);
    L63:
        int r40 = (r9 + this.b) + e(this.y);
        r38.setBounds(r37, r40, this.x + r37, this.y + r40);
        r38.draw(r13);
        goto L65
    L55:
        r38 = this.p;
    L65:
        if (u() == false) goto L67;
    L68:
        String r41 = getCharacterCounterText();
        int r42 = f(r41);
        Paint.FontMetrics r43 = this.I.getFontMetrics();
        float r44 = (r43.ascent + r43.descent) / 2;
        float r45 = (r8 - this.e) - (r42 / 2.0f);
        float r46 = ((r10 - this.c) - (this.H / 2.0f)) - r44;
        if (this.K == false) goto L73;
        this.I.setColor(getResources().getColor(2131106620));
        if (this.k == true) goto L78;
        w();
    L78:
        this.I.setTextAlign(Paint.Align.CENTER);
        r13.drawText(r41, r45, r46, this.I);
        this.I.setTextAlign(Paint.Align.LEFT);
    L79:
        super/*android.widget.EditText*/.onDraw(r13);
        return;
    L73:
        this.I.setColor(getResources().getColor(2131102093));
        if (this.k == true) goto L78;
        Drawable r47 = this.j;
        if (r47 == null) goto L78;
        this.j = r47;
        setBackground(r47);
        goto L78
    L67:
        if (this.K == true) goto L79;
    L36:
        r32 = false;
        goto L37
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if (hasFocus() == false) goto L73;
        if (this.l == true) goto L11;
        if (this.n == true) goto L11;
        if (this.R == false) goto L73;
    L11:
        if (isEnabled() == false) goto L73;
        int r0 = r9.getAction();
        boolean r1 = false;
        if (r0 == 0) goto L46;
        if (r0 == 1) goto L30;
        if (r0 == 2) goto L22;
        if (r0 != 3) goto L73;
        this.U = false;
        this.V = false;
        this.W = false;
        goto L73
    L22:
        if (this.V == false) goto L27;
        if (i(r9) == true) goto L27;
        this.V = false;
    L27:
        if (this.U == false) goto L73;
        return true;
    L30:
        if (this.V == false) goto L39;
        if (k(r9) == true) goto L34;
        this.t = !this.t;
        g();
    L37:
        this.V = false;
        goto L39
    L34:
        if (TextUtils.isEmpty(getText()) == true) goto L37;
        setText(null);
    L39:
        if (this.U == false) goto L42;
        this.U = false;
        return true;
    L42:
        this.U = false;
        if (this.W == false) goto L73;
        this.W = false;
        invalidate();
        goto L73
    L46:
        if (i(r9) == false) goto L50;
        this.U = true;
        this.V = true;
        return true;
    L50:
        if (this.V == false) goto L55;
        if (i(r9) == true) goto L55;
        this.V = false;
    L55:
        if (this.U == false) goto L58;
        return true;
    L58:
        if (this.D == null) goto L69;
        float r2 = r9.getX();
        float r3 = r9.getY();
        int r4 = getWidth();
        int r5 = getHeight();
        int r6 = ((r4 - this.e) - this.v) - this.u;
        int r7 = getScrollY();
        if (r2 < r6) goto L69;
        if (r2 >= r4) goto L69;
        if (r3 < r7) goto L69;
        if (r3 >= r5) goto L69;
        r1 = true;
    L69:
        if (r1 == false) goto L73;
        this.W = true;
        invalidate();
        return true;
    L73:
        return super/*android.widget.EditText*/.onTouchEvent(r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setActionButtonShownMode(ActionButtonShownMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.q = r2;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setClearButtonShownMode(ActionButtonShownMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.r = r2;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPasswordToggleButtonShownMode(ActionButtonShownMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.s = r2;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean l(ActionButtonShownMode r1, boolean r2) {
        if (r2 == true) goto L4;
    L16:
        return false;
    L4:
        if (hasFocus() == true) goto L10;
        if (r1 == ActionButtonShownMode.SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY) goto L16;
        if (r1 == ActionButtonShownMode.SHOW_WHEN_HAS_FOCUS) goto L16;
    L10:
        if (TextUtils.isEmpty(getText()) == true) goto L12;
    L15:
        return true;
    L12:
        if (r1 == ActionButtonShownMode.SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY) goto L16;
        if (r1 == ActionButtonShownMode.SHOW_WHEN_NOT_EMPTY) goto L16;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UDEditText(Context r24, AttributeSet r25, int r26, int r27) {
        Intrinsics.checkNotNullParameter(r24, "context");
        super(r24, r25, r26);
        ActionButtonShownMode r3 = ActionButtonShownMode.SHOW_WHEN_HAS_FOCUS_AND_NOT_EMPTY;
        this.q = r3;
        this.r = r3;
        this.s = r3;
        this.I = new TextPaint(1);
        this.J = new TextPaint(1);
        this.R = true;
        TypedArray r4 = r24.obtainStyledAttributes(r25, new int[]{2130974844, 2130974873, 2130974874, 2130974875, 2130974876, 2130974877, 2130974878, 2130974879, 2130974880, 2130974881, 2130974882, 2130974883, 2130974884, 2130974885, 2130974886, 2130974887, 2130974888, 2130974889, 2130974890, 2130974891, 2130974892, 2130974935, 2130974945, 2130974946}, r26, r27);
        ColorStateList r15 = r4.getColorStateList(0);
        ColorStateList r8 = r4.getColorStateList(22);
        int r16 = r4.getDimensionPixelSize(23, 0);
        int r6 = r4.getInt(21, 0);
        this.a = r6;
        if (r6 <= 0) goto L5;
        UDRadius.Companion.getClass();
        this.a = UDRadius.a.a(r6).getRadiusSize(r24);
    L5:
        int r17 = r4.getColor(8, UDColorUtils.getColor(r24, 2131102093));
        this.l = r4.getBoolean(3, false);
        boolean r13 = r4.getBoolean(16, false);
        this.n = r13;
        int r7 = r4.getInt(1, this.q.ordinal());
        ActionButtonShownMode r9 = ActionButtonShownMode.values()[r7];
        this.q = r9;
        int r10 = r4.getInt(4, r9.ordinal());
        this.r = ActionButtonShownMode.values()[r10];
        int r11 = r4.getInt(15, this.q.ordinal());
        this.s = ActionButtonShownMode.values()[r11];
        this.A = r4.getDimensionPixelSize(10, (int) d.a(r24, 8.0f));
        this.z = r4.getDimensionPixelSize(10, (int) d.a(r24, 12.0f));
        this.v = r4.getDimensionPixelSize(12, (int) d.a(r24, 20.0f));
        this.w = r4.getDimensionPixelSize(9, (int) d.a(r24, 20.0f));
        this.R = r4.getBoolean(11, true);
        this.u = (int) d.a(r24, 2.0f);
        this.S = (int) d.a(r24, 4.0f);
        int r12 = r4.getColor(14, UDColorUtils.getColor(r24, 2131102420));
        this.B = r12;
        int r14 = r4.getColor(19, UDColorUtils.getColor(r24, 2131102419));
        int r5 = r4.getColor(5, r14);
        int r19 = r4.getColor(17, r14);
        int r110 = r4.getResourceId(13, -1);
        if (r110 == (-1)) goto L8;
        this.C = UDIconUtils.getIconDrawable(r24, r110, r12);
    L8:
        int r20 = r4.getResourceId(18, -1);
        if (r20 == (-1)) goto L11;
        this.D = UDIconUtils.getIconDrawable(r24, r20, r14);
    L11:
        setMRightTagText(r4.getString(20));
        setMBottomTagText(r4.getString(2));
        this.E = r4.getInt(7, 0);
        this.F = r4.getBoolean(6, false);
        r4.recycle();
        int r21 = t08.a.e;
        t08.a r22 = t08.a.C0127a.a(r15, r16, r8, 0, 0, 0, 0, false, this.a);
        this.i = r22;
        setBackground(r22);
        this.j = t08.a.C0127a.a(r15, r16, ColorStateList.valueOf(r17), 0, 0, 0, 0, false, this.a);
        this.x = (int) d.a(getContext(), 20.0f);
        this.y = (int) d.a(getContext(), 20.0f);
        this.m = UDIconUtils.getIconDrawable(getContext(), 2131254121, r5);
        if (r13 == false) goto L14;
        g();
    L14:
        this.o = UDIconUtils.getIconDrawable(getContext(), 2131237697, r19);
        this.p = UDIconUtils.getIconDrawable(getContext(), 2131237696, r19);
        this.G = (int) d.a(getContext(), 2.0f);
        this.H = (int) d.a(getContext(), 18.0f);
        this.P = (int) d.a(getContext(), 18.0f);
        this.Q = ((int) d.a(getContext(), 4.0f)) * 2;
        TypedArray r1 = r24.obtainStyledAttributes(r25, new int[]{R.attr.padding, R.attr.paddingLeft, R.attr.paddingTop, R.attr.paddingRight, R.attr.paddingBottom});
        int r2 = r1.getDimensionPixelSize(0, 0);
        this.d = r1.getDimensionPixelSize(1, r2);
        this.b = r1.getDimensionPixelSize(2, r2);
        this.e = r1.getDimensionPixelSize(3, r2);
        this.c = r1.getDimensionPixelSize(4, r2);
        r1.recycle();
        h();
        addTextChangedListener(new u08.a(this));
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPadding(int r1, int r2, int r3, int r4) {
        this.d = r1;
        this.e = r3;
        this.b = r2;
        this.c = r4;
        h();
        postInvalidate();
    }

    public /* synthetic */ UDEditText(Context r1, AttributeSet r2, int r3, int r4, int r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3, 0);
    }
}
