package com.obric.oui.oswitch;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0017\u0018\u0000 ß\u00012\u00020\u0001:\u0002ß\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\nH\u0002J\n\u0010\u0096\u0001\u001a\u00030\u0094\u0001H\u0002J\n\u0010\u0097\u0001\u001a\u00030\u0094\u0001H\u0002J\n\u0010\u0098\u0001\u001a\u00030\u0094\u0001H\u0002J\u0014\u0010\u0099\u0001\u001a\u00030\u0094\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002J\u0014\u0010\u009c\u0001\u001a\u00030\u0094\u00012\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0016J\u001c\u0010\u009f\u0001\u001a\u00030\u0094\u00012\u0007\u0010 \u0001\u001a\u0002052\u0007\u0010¡\u0001\u001a\u000205H\u0016J\n\u0010¢\u0001\u001a\u00030\u0094\u0001H\u0014J\t\u0010£\u0001\u001a\u00020\u0007H\u0016J\t\u0010¤\u0001\u001a\u00020\u0007H\u0016J\u0007\u0010¥\u0001\u001a\u00020\nJ\u001b\u0010¦\u0001\u001a\u00020\n2\u0007\u0010 \u0001\u001a\u0002052\u0007\u0010¡\u0001\u001a\u000205H\u0002J\n\u0010§\u0001\u001a\u00030\u0094\u0001H\u0016J\u0016\u0010¨\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010©\u0001\u001a\u0004\u0018\u00010.H\u0002J\u0016\u0010ª\u0001\u001a\u00030\u0094\u00012\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0014J\u0013\u0010\u00ad\u0001\u001a\u00030®\u00012\u0007\u0010¯\u0001\u001a\u00020\u0007H\u0014J\u0014\u0010°\u0001\u001a\u00030\u0094\u00012\b\u0010±\u0001\u001a\u00030\u009e\u0001H\u0014J\u0014\u0010²\u0001\u001a\u00030\u0094\u00012\b\u0010³\u0001\u001a\u00030´\u0001H\u0016J\u0014\u0010µ\u0001\u001a\u00030\u0094\u00012\b\u0010¶\u0001\u001a\u00030·\u0001H\u0016J7\u0010¸\u0001\u001a\u00030\u0094\u00012\u0007\u0010¹\u0001\u001a\u00020\n2\u0007\u0010º\u0001\u001a\u00020\u00072\u0007\u0010»\u0001\u001a\u00020\u00072\u0007\u0010¼\u0001\u001a\u00020\u00072\u0007\u0010½\u0001\u001a\u00020\u0007H\u0014J\u001c\u0010¾\u0001\u001a\u00030\u0094\u00012\u0007\u0010¿\u0001\u001a\u00020\u00072\u0007\u0010À\u0001\u001a\u00020\u0007H\u0016J\u0014\u0010Á\u0001\u001a\u00030\u0094\u00012\b\u0010³\u0001\u001a\u00030´\u0001H\u0016J\u0013\u0010Â\u0001\u001a\u00020\n2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0016J\t\u0010Ã\u0001\u001a\u00020\nH\u0016J\u0013\u0010Ä\u0001\u001a\u00030\u0094\u00012\u0007\u0010Å\u0001\u001a\u00020\nH\u0016J\n\u0010Æ\u0001\u001a\u00030\u0094\u0001H\u0002J\u0013\u0010Ç\u0001\u001a\u00030\u0094\u00012\u0007\u0010Å\u0001\u001a\u00020\nH\u0016J\u0013\u0010È\u0001\u001a\u00030\u0094\u00012\u0007\u0010Å\u0001\u001a\u00020\nH\u0017J\u0014\u0010É\u0001\u001a\u00030\u0094\u00012\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0016J\u001b\u0010Ì\u0001\u001a\u00030\u0094\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0007\u0010Í\u0001\u001a\u00020\u0007J\u0014\u0010Î\u0001\u001a\u00030\u0094\u00012\n\u0010Ï\u0001\u001a\u0005\u0018\u00010Ð\u0001J\u001d\u0010Î\u0001\u001a\u00030\u0094\u00012\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ð\u00012\u0007\u0010Ò\u0001\u001a\u00020\u0007J\u001c\u0010Ó\u0001\u001a\u00030\u0094\u00012\u0007\u0010Ô\u0001\u001a\u00020\u00072\u0007\u0010Õ\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010Ö\u0001\u001a\u00030\u0094\u00012\u0007\u0010×\u0001\u001a\u000205J\u0011\u0010Ø\u0001\u001a\u00030\u0094\u00012\u0007\u0010Ù\u0001\u001a\u00020\u0007J\u0011\u0010Ú\u0001\u001a\u00030\u0094\u00012\u0007\u0010Ù\u0001\u001a\u00020\u0007J\u0014\u0010Û\u0001\u001a\u00030\u0094\u00012\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002J\n\u0010Ü\u0001\u001a\u00030\u0094\u0001H\u0016J\u0012\u0010Ý\u0001\u001a\u00020\n2\u0007\u0010Þ\u0001\u001a\u000207H\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u000205X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010J\u001a\n L*\u0004\u0018\u00010K0KX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010M\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\f\"\u0004\bO\u0010\u000eR$\u0010P\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010\f\"\u0004\bR\u0010\u000eR$\u0010T\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010Y\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR\u000e\u0010\\\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010]\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\fR(\u0010_\u001a\u0004\u0018\u00010.2\b\u0010_\u001a\u0004\u0018\u00010.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR(\u0010d\u001a\u0004\u0018\u00010.2\b\u0010d\u001a\u0004\u0018\u00010.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\be\u0010a\"\u0004\bf\u0010cR\u000e\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010j\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bk\u0010V\"\u0004\bl\u0010XR$\u0010m\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bn\u0010V\"\u0004\bo\u0010XR(\u0010q\u001a\u0004\u0018\u0001072\b\u0010p\u001a\u0004\u0018\u0001078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0014\u0010v\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bw\u0010VR\u0014\u0010x\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\by\u0010VR$\u0010z\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b{\u0010V\"\u0004\b|\u0010XR+\u0010~\u001a\u0004\u0018\u00010,2\b\u0010}\u001a\u0004\u0018\u00010,8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R.\u0010\u0084\u0001\u001a\u0004\u0018\u00010A2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R,\u0010\u008a\u0001\u001a\u0004\u0018\u0001072\t\u0010\u0089\u0001\u001a\u0004\u0018\u0001078F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0001\u0010s\"\u0005\b\u008c\u0001\u0010uR-\u0010\u008d\u0001\u001a\u0004\u0018\u00010,2\b\u0010}\u001a\u0004\u0018\u00010,8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u008e\u0001\u0010\u0080\u0001\"\u0006\b\u008f\u0001\u0010\u0082\u0001R.\u0010\u0090\u0001\u001a\u0004\u0018\u00010A2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010A8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b\u0091\u0001\u0010\u0086\u0001\"\u0006\b\u0092\u0001\u0010\u0088\u0001¨\u0006à\u0001"}, d2 = {"Lcom/obric/oui/oswitch/SwitchCompat;", "Landroid/widget/CompoundButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "autoCheck", "", "getAutoCheck", "()Z", "setAutoCheck", "(Z)V", "mHasThumbTint", "mHasThumbTintMode", "mHasTrackTint", "mHasTrackTintMode", "mMinFlingVelocity", "mOffLayout", "Landroid/text/Layout;", "mOnLayout", "mPositionAnimator", "Landroid/animation/ObjectAnimator;", "getMPositionAnimator", "()Landroid/animation/ObjectAnimator;", "setMPositionAnimator", "(Landroid/animation/ObjectAnimator;)V", "mShowText", "mSplitTrack", "mSwitchBottom", "mSwitchHeight", "mSwitchLeft", "mSwitchMinWidth", "mSwitchPadding", "mSwitchRight", "mSwitchTop", "mSwitchTransformationMethod", "Landroid/text/method/TransformationMethod;", "mSwitchWidth", "mTempRect", "Landroid/graphics/Rect;", "mTextColors", "Landroid/content/res/ColorStateList;", "mTextOff", "", "mTextOn", "mTextPaint", "Landroid/text/TextPaint;", "mThumbConstraintLeft", "mThumbConstraintRight", "mThumbDragPosition", "", "mThumbDrawable", "Landroid/graphics/drawable/Drawable;", "mThumbHeight", "mThumbPosition", "getMThumbPosition", "()F", "setMThumbPosition", "(F)V", "mThumbTextPadding", "mThumbTintList", "mThumbTintMode", "Landroid/graphics/PorterDuff$Mode;", "mThumbWidth", "mTouchMode", "mTouchSlop", "mTouchX", "mTouchY", "mTrackDrawable", "mTrackTintList", "mTrackTintMode", "mVelocityTracker", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "showText", "getShowText", "setShowText", "splitTrack", "getSplitTrack", "setSplitTrack", "pixels", "switchMinWidth", "getSwitchMinWidth", "()I", "setSwitchMinWidth", "(I)V", "switchPadding", "getSwitchPadding", "setSwitchPadding", "switchWidthOffsetPx", "targetCheckedState", "getTargetCheckedState", "textOff", "getTextOff", "()Ljava/lang/CharSequence;", "setTextOff", "(Ljava/lang/CharSequence;)V", "textOn", "getTextOn", "setTextOn", "thumbAnimInterpolator", "Landroid/view/animation/PathInterpolator;", EventBody.KEY_VALUE, "thumbConstraintLeft", "getThumbConstraintLeft", "setThumbConstraintLeft", "thumbConstraintRight", "getThumbConstraintRight", "setThumbConstraintRight", "thumb", "thumbDrawable", "getThumbDrawable", "()Landroid/graphics/drawable/Drawable;", "setThumbDrawable", "(Landroid/graphics/drawable/Drawable;)V", "thumbOffset", "getThumbOffset", "thumbScrollRange", "getThumbScrollRange", "thumbTextPadding", "getThumbTextPadding", "setThumbTextPadding", "tint", "thumbTintList", "getThumbTintList", "()Landroid/content/res/ColorStateList;", "setThumbTintList", "(Landroid/content/res/ColorStateList;)V", "tintMode", "thumbTintMode", "getThumbTintMode", "()Landroid/graphics/PorterDuff$Mode;", "setThumbTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "track", "trackDrawable", "getTrackDrawable", "setTrackDrawable", "trackTintList", "getTrackTintList", "setTrackTintList", "trackTintMode", "getTrackTintMode", "setTrackTintMode", "animateThumbToCheckedState", "", "newCheckedState", "applyThumbTint", "applyTrackTint", "cancelPositionAnimator", "cancelSuperTouch", "ev", "Landroid/view/MotionEvent;", "draw", "c", "Landroid/graphics/Canvas;", "drawableHotspotChanged", "x", "y", "drawableStateChanged", "getCompoundPaddingLeft", "getCompoundPaddingRight", "hasValidSize", "hitThumb", "jumpDrawablesToCurrentState", "makeLayout", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateDrawableState", "", "extraSpace", "onDraw", "canvas", "onInitializeAccessibilityEvent", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPopulateAccessibilityEvent", "onTouchEvent", "performClick", "performHapticFeedback", "checked", "refreshDimensionCache", "setChecked", "setCheckedNoAnim", "setCustomSelectionActionModeCallback", "actionModeCallback", "Landroid/view/ActionMode$Callback;", "setSwitchTextAppearance", "resid", "setSwitchTypeface", "typeface", "Landroid/graphics/Typeface;", "tf", "style", "setSwitchTypefaceByIndex", "typefaceIndex", "styleIndex", "setThumbPosition", "position", "setThumbResource", "resId", "setTrackResource", "stopDrag", "toggle", "verifyDrawable", "who", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SwitchCompat extends CompoundButton {
    private static final Property<SwitchCompat, Float> U = null;
    private static final int[] V = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14244b = null;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private final TextPaint I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private ColorStateList f14245J;
    private Layout K;
    private Layout L;
    private TransformationMethod M;
    private ObjectAnimator N;
    private final Rect O;
    private int P;
    private int Q;
    private boolean R;
    private final PathInterpolator S;
    private float T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f14246a;
    private ColorStateList c;
    private PorterDuff.Mode d;
    private boolean e;
    private boolean f;
    private Drawable g;
    private ColorStateList h;
    private PorterDuff.Mode i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private CharSequence p;
    private CharSequence q;
    private boolean r;
    private int s;
    private final int t;
    private float u;
    private float v;
    private final VelocityTracker w;
    private final int x;
    private float y;
    private int z;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/oswitch/SwitchCompat$Companion;", "", "()V", "ACCESSIBILITY_EVENT_CLASS_NAME", "", "CAN_SHOW_TEXT", "", "CHECKED_STATE_SET", "", "MONOSPACE", "", "SANS", "SERIF", "THUMB_ANIMATION_DURATION", "", "THUMB_POS", "Landroid/util/Property;", "Lcom/obric/oui/oswitch/SwitchCompat;", "", "TOUCH_MODE_DOWN", "TOUCH_MODE_DRAGGING", "TOUCH_MODE_IDLE", "TRACK_ANIMATION_DURATION_OFF", "TRACK_ANIMATION_DURATION_ON", "constrain", "amount", "low", "high", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final float a(float r1, float r2, float r3) {
            if (r1 >= r2) goto L6;
            return r2;
        L6:
            if (r1 > r3) goto L8;
            return r1;
        L8:
            return r3;
        }

        public static final /* synthetic */ float a(a r0, float r1, float r2, float r3) {
            return r0.a(r1, r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0096\u0002¨\u0006\n"}, d2 = {"com/obric/oui/oswitch/SwitchCompat$Companion$THUMB_POS$1", "Landroid/util/Property;", "Lcom/obric/oui/oswitch/SwitchCompat;", "", "get", "object", "(Lcom/obric/oui/oswitch/SwitchCompat;)Ljava/lang/Float;", "set", "", EventBody.KEY_VALUE, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Property<SwitchCompat, Float> {
        b(Class<Float> r2) {
            super(r2, "thumbPos");
        }

        public Float a(SwitchCompat r1) {
            Intrinsics.checkNotNullParameter(r1, "object");
            return Float.valueOf(r1.getMThumbPosition());
        }

        public void a(SwitchCompat r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "object");
            r1.setThumbPosition(r2);
        }

        @Override // android.util.Property
        public /* synthetic */ Float get(SwitchCompat r3) {
            return a((SwitchCompat) ZeusTransformUtils.preCheckCast(r3, SwitchCompat.class, "com.obric.memorydata.plugin"));
        }

        @Override // android.util.Property
        public /* synthetic */ void set(SwitchCompat r3, Float r4) {
            a((SwitchCompat) ZeusTransformUtils.preCheckCast(r3, SwitchCompat.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).floatValue());
        }
    }

    static {
        f14244b = new a(null);
        U = (Property) ZeusTransformUtils.preCheckCast(new b(Float.TYPE), Property.class, "com.obric.memorydata.plugin");
        V = new int[]{R.attr.state_checked};
    }

    public SwitchCompat(Context r7) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
    }

    public SwitchCompat(Context r9, AttributeSet r10) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin"), 0, 4, null);
    }

    public SwitchCompat(Context r8, AttributeSet r9, int r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r11, r12, r10);
        this.w = VelocityTracker.obtain();
        this.O = new Rect();
        this.R = true;
        this.S = new PathInterpolator(0.33f, 1.3f, 0.15f, 1.0f);
        d();
        TextPaint r2 = new TextPaint(1);
        this.I = r2;
        r2.density = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density;
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(r11, r12, com.obric.memorydata.plugin.R.styleable.SwitchCompat, r10, 0);
        Drawable r14 = r13.getDrawable(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_android_thumb, "styleable", "SwitchCompat_android_thumb"));
        this.f14246a = r14;
        if (r14 == null) goto L5;
        Intrinsics.checkNotNull(r14);
        r14.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.memorydata.plugin"));
    L5:
        Drawable r15 = r13.getDrawable(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_track, "styleable", "SwitchCompat_track"));
        this.g = r15;
        if (r15 == null) goto L8;
        Intrinsics.checkNotNull(r15);
        r15.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.memorydata.plugin"));
    L8:
        this.p = r13.getText(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_android_textOn, "styleable", "SwitchCompat_android_textOn"));
        this.q = r13.getText(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_android_textOff, "styleable", "SwitchCompat_android_textOff"));
        this.r = false;
        this.l = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_thumbTextPadding, "styleable", "SwitchCompat_thumbTextPadding"), 0);
        this.m = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_switchMinWidth, "styleable", "SwitchCompat_switchMinWidth"), 0);
        this.n = r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_switchPadding, "styleable", "SwitchCompat_switchPadding"), 0);
        this.o = r13.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_splitTrack, "styleable", "SwitchCompat_splitTrack"), false);
        ColorStateList r16 = r13.getColorStateList(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_thumbTint, "styleable", "SwitchCompat_thumbTint"));
        if (r16 == null) goto L11;
        this.c = r16;
        this.e = true;
    L11:
        PorterDuff.Mode r17 = DrawableUtils.parseTintMode(r13.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_thumbTintMode, "styleable", "SwitchCompat_thumbTintMode"), -1), null);
        if (this.d == r17) goto L15;
        this.d = r17;
        this.f = true;
    L15:
        if (this.e == false) goto L17;
    L18:
        c();
    L19:
        ColorStateList r18 = r13.getColorStateList(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_trackTint, "styleable", "SwitchCompat_trackTint"));
        if (r18 == null) goto L22;
        this.h = r18;
        this.j = true;
    L22:
        PorterDuff.Mode r19 = DrawableUtils.parseTintMode(r13.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_trackTintMode, "styleable", "SwitchCompat_trackTintMode"), -1), null);
        if (this.i == r19) goto L26;
        this.i = r19;
        this.k = true;
    L26:
        if (this.j == false) goto L28;
    L29:
        b();
    L30:
        int r110 = r13.getResourceId(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.SwitchCompat_switchTextAppearance, "styleable", "SwitchCompat_switchTextAppearance"), 0);
        if (r110 == 0) goto L33;
        a(r11, r110);
    L33:
        r13.recycle();
        if (r11 == null) goto L36;
        ViewConfiguration r20 = ViewConfiguration.get(r11);
        this.t = r20.getScaledTouchSlop();
        this.x = r20.getScaledMinimumFlingVelocity();
    L37:
        refreshDrawableState();
        setChecked(isChecked());
        return;
    L36:
        this.t = 0;
        this.x = 0;
        goto L37
    L28:
        if (this.k == false) goto L30;
    L17:
        if (this.f == false) goto L19;
        goto L18
    }

    public /* synthetic */ SwitchCompat(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.attr.switchStyle, "attr", "switchStyle");
    L8:
        this(r7, r8, r4);
    }

    private final Layout a(CharSequence r11) {
        CharSequence r12 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L6;
        return null;
    L6:
        TransformationMethod r0 = this.M;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        r12 = r0.getTransformation(r12, (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
    L9:
        CharSequence r3 = r12;
        TextPaint r4 = this.I;
        if (r3 == null) goto L12;
        int r10 = (int) Math.ceil(Layout.getDesiredWidth(r3, r4));
    L14:
        return (Layout) ZeusTransformUtils.preCheckCast(new StaticLayout(r3, r4, r10, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true), Layout.class, "com.obric.memorydata.plugin");
    L12:
        r10 = 0;
        goto L14
    }

    private final void a(int r2, int r3) {
        if (r2 != 1) goto L5;
        Typeface r4 = Typeface.SANS_SERIF;
    L12:
        a(r4, r3);
        return;
    L5:
        if (r2 != 2) goto L7;
        r4 = Typeface.SERIF;
        goto L12
    L7:
        if (r2 == 3) goto L9;
        r4 = null;
        goto L12
    L9:
        r4 = Typeface.MONOSPACE;
        goto L12
    }

    private final void a(MotionEvent r2) {
        MotionEvent r3 = MotionEvent.obtain(r2);
        r3.setAction(3);
        super.onTouchEvent(r3);
        r3.recycle();
    }

    private final boolean a(float r6, float r7) {
        if (this.f14246a != null) goto L5;
        return false;
    L5:
        int r0 = getThumbOffset();
        Drawable r2 = this.f14246a;
        Intrinsics.checkNotNull(r2);
        r2.getPadding(this.O);
        int r3 = this.F;
        int r4 = this.t;
        int r5 = r3 - r4;
        int r8 = (this.E + r0) - r4;
        int r1 = ((this.C + r8) + this.O.left) + this.O.right;
        int r9 = this.t;
        int r10 = r1 + r9;
        int r11 = this.H + r9;
        if (r6 > r8) goto L8;
        return false;
    L8:
        if (r6 < r10) goto L10;
        return false;
    L10:
        if (r7 > r5) goto L12;
        return false;
    L12:
        if (r7 >= r11) goto L18;
        return true;
    L18:
        return false;
    }

    private final void b() {
        Drawable r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.j == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r0);
        Drawable r1 = r0.mutate();
        this.g = r1;
        if (this.j == false) goto L12;
        Intrinsics.checkNotNull(r1);
        DrawableCompat.setTintList(r1, this.h);
    L12:
        if (this.k == false) goto L14;
        Drawable r2 = this.g;
        Intrinsics.checkNotNull(r2);
        PorterDuff.Mode r3 = this.i;
        Intrinsics.checkNotNull(r3);
        DrawableCompat.setTintMode(r2, r3);
    L14:
        Drawable r4 = this.g;
        Intrinsics.checkNotNull(r4);
        if (r4.isStateful() == false) goto L20;
        Drawable r5 = this.g;
        Intrinsics.checkNotNull(r5);
        r5.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.k == true) goto L8;
    }

    private final void b(MotionEvent r7) {
        this.s = 0;
        boolean r2 = true;
        if (r7.getAction() == 1) goto L5;
    L7:
        boolean r1 = false;
    L8:
        boolean r3 = isChecked();
        if (r1 == false) goto L22;
        this.w.computeCurrentVelocity(1000);
        float r4 = this.w.getXVelocity();
        if (Math.abs(r4) > this.x) goto L13;
        r2 = getTargetCheckedState();
    L23:
        if (r2 == r3) goto L25;
        playSoundEffect(0);
    L25:
        setChecked(r2);
        a(r7);
        return;
    L13:
        if (ViewUtils.isLayoutRtl((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == false) goto L18;
        if (r4 < 0.0f) goto L23;
    L20:
        r2 = false;
        goto L23
    L18:
        if (r4 <= 0.0f) goto L20;
    L22:
        r2 = r3;
        goto L23
    L5:
        if (isEnabled() == false) goto L7;
        r1 = true;
        goto L8
    }

    private final void b(boolean r5) {
        if (r5 == false) goto L4;
        float r6 = 1.0f;
    L5:
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, U, new float[]{r6});
        this.N = r7;
        if (r7 == null) goto L10;
        r7.setDuration(443);
    L10:
        if (Build.VERSION.SDK_INT < 18) goto L15;
        ObjectAnimator r8 = this.N;
        if (r8 == null) goto L15;
        r8.setAutoCancel(true);
    L15:
        ObjectAnimator r9 = this.N;
        if (r9 == null) goto L19;
        r9.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.S, TimeInterpolator.class, "com.obric.memorydata.plugin"));
    L19:
        ObjectAnimator r4 = this.N;
        if (r4 == null) goto L24;
        r4.start();
        return;
    L24:
        return;
    L4:
        r6 = 0.0f;
        goto L5
    }

    private final void c() {
        Drawable r0 = this.f14246a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.e == false) goto L7;
    L8:
        Intrinsics.checkNotNull(r0);
        Drawable r1 = r0.mutate();
        this.f14246a = r1;
        if (this.e == false) goto L12;
        Intrinsics.checkNotNull(r1);
        DrawableCompat.setTintList(r1, this.c);
    L12:
        if (this.f == false) goto L14;
        Drawable r2 = this.f14246a;
        Intrinsics.checkNotNull(r2);
        PorterDuff.Mode r3 = this.d;
        Intrinsics.checkNotNull(r3);
        DrawableCompat.setTintMode(r2, r3);
    L14:
        Drawable r4 = this.f14246a;
        Intrinsics.checkNotNull(r4);
        if (r4.isStateful() == false) goto L20;
        Drawable r5 = this.f14246a;
        Intrinsics.checkNotNull(r5);
        r5.setState(getDrawableState());
        return;
    L20:
        return;
    L7:
        if (this.f == true) goto L8;
    }

    private final void d() {
        this.A = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
    }

    private final void e() {
        ObjectAnimator r0 = this.N;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        r0.cancel();
        return;
    }

    private final boolean getTargetCheckedState() {
        if (this.T <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final int getThumbOffset() {
        if (ViewUtils.isLayoutRtl((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == false) goto L5;
        float r0 = 1 - this.y;
    L7:
        return (int) ((r0 * getThumbScrollRange()) + 0.5f);
    L5:
        r0 = this.y;
        goto L7
    }

    private final int getThumbScrollRange() {
        Drawable r0 = this.g;
        if (r0 == null) goto L9;
        Rect r1 = this.O;
        Intrinsics.checkNotNull(r0);
        r0.getPadding(r1);
        Drawable r2 = this.f14246a;
        if (r2 == null) goto L7;
        Rect r3 = DrawableUtils.getOpticalBounds(r2);
        String r4 = "{\n                Drawab…mbDrawable)\n            }";
    L8:
        Intrinsics.checkNotNullExpressionValue(r3, r4);
        return ((((((this.z - this.C) - r1.left) - r1.right) - r3.left) - r3.right) - this.Q) - this.P;
    L7:
        r3 = DrawableUtils.INSETS_NONE;
        r4 = "{\n                Drawab…INSETS_NONE\n            }";
        goto L8
    L9:
        return 0;
    }

    public final void a(Context r7, int r8) {
        TintTypedArray r9 = TintTypedArray.obtainStyledAttributes((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin"), r8, com.obric.memorydata.plugin.R.styleable.TextAppearance);
        ColorStateList r10 = r9.getColorStateList(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.TextAppearance_android_textColor, "styleable", "TextAppearance_android_textColor"));
        if (r10 != null) goto L5;
        r10 = getTextColors();
    L5:
        this.f14245J = r10;
        int r11 = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.TextAppearance_android_textSize, "styleable", "TextAppearance_android_textSize"), 0);
        if (r11 == 0) goto L13;
        float r12 = r11;
        if (r12 != this.I.getTextSize()) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
        this.I.setTextSize(r12);
        requestLayout();
        goto L13
    L10:
        r3 = false;
    L13:
        a(r9.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.TextAppearance_android_typeface, "styleable", "TextAppearance_android_typeface"), -1), r9.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.TextAppearance_android_textStyle, "styleable", "TextAppearance_android_textStyle"), -1));
        if (r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.TextAppearance_textAllCaps, "styleable", "TextAppearance_textAllCaps"), false) == false) goto L16;
        AllCapsTransformationMethod r13 = new AllCapsTransformationMethod((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L17:
        this.M = (TransformationMethod) ZeusTransformUtils.preCheckCast(r13, TransformationMethod.class, "com.obric.memorydata.plugin");
        r9.recycle();
        return;
    L16:
        r13 = null;
        goto L17
    }

    public final void a(Typeface r4, int r5) {
        float r0 = 0.0f;
        boolean r1 = false;
        if (r5 <= 0) goto L18;
        if (r4 != null) goto L6;
        Typeface r6 = Typeface.defaultFromStyle(r5);
    L7:
        setSwitchTypeface(r6);
        if (r6 != null) goto L10;
        int r7 = 0;
    L11:
        int r8 = (~r7) & r5;
        TextPaint r9 = this.I;
        if ((r8 & 1) == 0) goto L14;
        r1 = true;
    L14:
        r9.setFakeBoldText(r1);
        TextPaint r3 = this.I;
        if ((r8 & 2) == 0) goto L17;
        r0 = -0.25f;
    L17:
        r3.setTextSkewX(r0);
        return;
    L10:
        r7 = r6.getStyle();
        goto L11
    L6:
        r6 = Typeface.create(r4, r5);
        goto L7
    L18:
        this.I.setFakeBoldText(false);
        this.I.setTextSkewX(0.0f);
        setSwitchTypeface(r4);
    }

    public void a(boolean r2) {
        Context r1 = ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin");
        if (r2 == false) goto L5;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.memorydata.plugin");
        int r4 = 4;
    L6:
        com.obric.oui.a.a.a(r3, r4);
        return;
    L5:
        r3 = (Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.memorydata.plugin");
        r4 = 5;
        goto L6
    }

    public final boolean a() {
        if (getWidth() > 0) goto L5;
    L7:
        return false;
    L5:
        if (getHeight() <= 0) goto L7;
        return true;
    }

    @Override // android.view.View
    public void draw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "c");
        Rect r0 = this.O;
        int r1 = this.E;
        int r2 = this.F;
        int r3 = this.G;
        int r4 = this.H;
        int r5 = getThumbOffset() + r1;
        Drawable r6 = this.f14246a;
        if (r6 == null) goto L5;
        Rect r7 = DrawableUtils.getOpticalBounds(r6);
    L6:
        Drawable r8 = this.g;
        if (r8 == null) goto L26;
        Intrinsics.checkNotNull(r8);
        r8.getPadding(r0);
        r5 = r5 + r0.left;
        if (r7 != null) goto L11;
        int r9 = r2;
    L24:
        int r10 = r4;
    L25:
        Drawable r12 = this.g;
        Intrinsics.checkNotNull(r12);
        r12.setBounds(r1, r9, r3, r10);
        goto L26
    L11:
        if (r7.left <= r0.left) goto L14;
        r1 = r1 + (r7.left - r0.left);
    L14:
        if (r7.top <= r0.top) goto L16;
        r9 = (r7.top - r0.top) + r2;
    L18:
        if (r7.right <= r0.right) goto L21;
        r3 = r3 - (r7.right - r0.right);
    L21:
        if (r7.bottom <= r0.bottom) goto L24;
        r10 = r4 - (r7.bottom - r0.bottom);
        goto L25
    L16:
        r9 = r2;
    L26:
        Drawable r13 = this.f14246a;
        if (r13 == null) goto L31;
        Intrinsics.checkNotNull(r13);
        r13.getPadding(r0);
        int r14 = (r5 - r0.left) + this.P;
        int r15 = ((r5 + this.C) + r0.right) + this.P;
        int r16 = ((r4 - r2) - this.D) / 2;
        Drawable r17 = this.f14246a;
        Intrinsics.checkNotNull(r17);
        r17.setBounds(r14, r16, r15, this.D + r16);
        Drawable r18 = getBackground();
        if (r18 == null) goto L31;
        DrawableCompat.setHotspotBounds(r18, r14, r2, r15, r4);
    L31:
        super.draw(r11);
        return;
    L5:
        r7 = DrawableUtils.INSETS_NONE;
        goto L6
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        super.drawableHotspotChanged(r3, r4);
    L5:
        Drawable r0 = this.f14246a;
        if (r0 == null) goto L8;
        Intrinsics.checkNotNull(r0);
        DrawableCompat.setHotspot(r0, r3, r4);
    L8:
        Drawable r2 = this.g;
        if (r2 == null) goto L12;
        Intrinsics.checkNotNull(r2);
        DrawableCompat.setHotspot(r2, r3, r4);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r0 = getDrawableState();
        Drawable r1 = this.f14246a;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L7:
        Drawable r3 = this.g;
        if (r3 != null) goto L10;
    L12:
        if (r2 == false) goto L15;
        invalidate();
        return;
    L15:
        return;
    L10:
        if (r3.isStateful() == false) goto L12;
        r2 = r2 | r3.setState(r0);
        goto L12
    L5:
        if (r1.isStateful() == false) goto L7;
        r2 = false | r1.setState(r0);
        goto L7
    }

    public final boolean getAutoCheck() {
        return this.R;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (ViewUtils.isLayoutRtl((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == false) goto L5;
        int r0 = super.getCompoundPaddingLeft() + this.z;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.n;
    L5:
        return super.getCompoundPaddingLeft();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == true) goto L5;
        int r0 = super.getCompoundPaddingRight() + this.z;
        if (TextUtils.isEmpty(getText()) == false) goto L9;
        return r0;
    L9:
        return r0 + this.n;
    L5:
        return super.getCompoundPaddingRight();
    }

    public final ObjectAnimator getMPositionAnimator() {
        return this.N;
    }

    public final float getMThumbPosition() {
        return this.y;
    }

    public final boolean getShowText() {
        return this.r;
    }

    public final boolean getSplitTrack() {
        return this.o;
    }

    public final int getSwitchMinWidth() {
        return this.m;
    }

    public final int getSwitchPadding() {
        return this.n;
    }

    public final CharSequence getTextOff() {
        return this.q;
    }

    public final CharSequence getTextOn() {
        return this.p;
    }

    public final int getThumbConstraintLeft() {
        return this.P;
    }

    public final int getThumbConstraintRight() {
        return this.Q;
    }

    public final Drawable getThumbDrawable() {
        return this.f14246a;
    }

    public final int getThumbTextPadding() {
        return this.l;
    }

    public final ColorStateList getThumbTintList() {
        return this.c;
    }

    public final PorterDuff.Mode getThumbTintMode() {
        return this.d;
    }

    public final Drawable getTrackDrawable() {
        return this.g;
    }

    public final ColorStateList getTrackTintList() {
        return this.h;
    }

    public final PorterDuff.Mode getTrackTintMode() {
        return this.i;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r0 = this.f14246a;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.jumpToCurrentState();
    L5:
        Drawable r1 = this.g;
        if (r1 == null) goto L8;
        Intrinsics.checkNotNull(r1);
        r1.jumpToCurrentState();
    L8:
        ObjectAnimator r2 = this.N;
        if (r2 == null) goto L14;
        Intrinsics.checkNotNull(r2);
        if (r2.isStarted() == false) goto L15;
        ObjectAnimator r3 = this.N;
        Intrinsics.checkNotNull(r3);
        r3.end();
        this.N = null;
        return;
    L15:
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        d();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int r1) {
        int[] r2 = super.onCreateDrawableState(r1 + 1);
        if (isChecked() == false) goto L5;
        View.mergeDrawableStates(r2, V);
    L5:
        Intrinsics.checkNotNullExpressionValue(r2, "drawableState");
        return r2;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        super.onDraw(r10);
        Rect r0 = this.O;
        Drawable r1 = this.g;
        if (r1 != null) goto L5;
        Boolean r2 = null;
    L6:
        if (r2 != null) goto L8;
        r0.setEmpty();
        Unit r3 = Unit.INSTANCE;
    L8:
        int r4 = this.F;
        int r5 = this.H;
        int r6 = r4 + r0.top;
        int r7 = r5 - r0.bottom;
        Drawable r8 = this.f14246a;
        if (r1 != null) goto L11;
    L15:
        int r9 = r10.save();
        if (r8 == null) goto L20;
        r8.draw(r10);
    L20:
        if (getTargetCheckedState() == false) goto L22;
        Layout r11 = this.K;
    L23:
        if (r11 == null) goto L32;
        int[] r12 = getDrawableState();
        ColorStateList r13 = this.f14245J;
        if (r13 == null) goto L27;
        TextPaint r14 = this.I;
        Intrinsics.checkNotNull(r13);
        r14.setColor(r13.getColorForState(r12, 0));
    L27:
        this.I.drawableState = r12;
        if (r8 == null) goto L30;
        Rect r15 = r8.getBounds();
        Intrinsics.checkNotNullExpressionValue(r15, "thumbDrawable.bounds");
        int r16 = r15.left + r15.right;
    L31:
        r10.translate((r16 / 2) - (r11.getWidth() / 2), ((r6 + r7) / 2) - (r11.getHeight() / 2));
        r11.draw(r10);
        goto L32
    L30:
        r16 = getWidth();
    L32:
        r10.restoreToCount(r9);
        return;
    L22:
        r11 = this.L;
        goto L23
    L11:
        if (this.o == false) goto L14;
        if (r8 == null) goto L14;
        Rect r17 = DrawableUtils.getOpticalBounds(r8);
        r8.copyBounds(r0);
        r0.left += r17.left;
        r0.right -= r17.right;
        int r18 = r10.save();
        r10.clipRect(r0, Region.Op.DIFFERENCE);
        r1.draw(r10);
        r10.restoreToCount(r18);
    L14:
        r1.draw(r10);
        goto L15
    L5:
        r2 = Boolean.valueOf(r1.getPadding(r0));
        goto L6
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        super.onInitializeAccessibilityEvent(r3);
        r3.setClassName((CharSequence) ZeusTransformUtils.preCheckCast("android.widget.Switch", CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "info");
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName((CharSequence) ZeusTransformUtils.preCheckCast("android.widget.Switch", CharSequence.class, "com.obric.memorydata.plugin"));
        if (isChecked() == false) goto L5;
        CharSequence r4 = this.p;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L14;
        CharSequence r0 = r5.getText();
        if (TextUtils.isEmpty(r0) == true) goto L12;
        StringBuilder r1 = new StringBuilder();
        r1.append(r0).append(' ').append(r4);
        r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
    L12:
        r5.setText(r4);
        return;
    L14:
        return;
    L5:
        r4 = this.q;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = 0;
        if (this.f14246a == null) goto L9;
        Rect r7 = this.O;
        Drawable r8 = this.g;
        if (r8 == null) goto L7;
        Intrinsics.checkNotNull(r8);
        r8.getPadding(r7);
    L8:
        Rect r9 = DrawableUtils.getOpticalBounds(this.f14246a);
        int r10 = Math.max(0, r9.left - r7.left);
        r6 = Math.max(0, r9.right - r7.right);
    L11:
        if (ViewUtils.isLayoutRtl((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == false) goto L13;
        int r11 = getPaddingLeft() + r10;
        int r12 = ((this.z + r11) - r10) - r6;
    L14:
        int r13 = getGravity() & 112;
        if (r13 != 16) goto L17;
        int r14 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
        int r15 = this.B;
        int r16 = r14 - (r15 / 2);
    L24:
        int r17 = r15 + r16;
    L25:
        this.E = r11;
        this.F = r16;
        this.H = r17;
        this.G = r12;
        return;
    L17:
        if (r13 != 48) goto L19;
    L22:
        r16 = getPaddingTop();
        r15 = this.B;
        goto L24
    L19:
        if (r13 != 80) goto L22;
        r17 = getHeight() - getPaddingBottom();
        r16 = r17 - this.B;
        goto L25
    L13:
        r12 = (getWidth() - getPaddingRight()) - r6;
        r11 = ((r12 - this.z) + r10) + r6;
        goto L14
    L7:
        r7.setEmpty();
        goto L8
    L9:
        r10 = 0;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r7, int r8) {
        if (this.r == true) goto L5;
    L10:
        Rect r0 = this.O;
        Drawable r1 = this.f14246a;
        int r2 = 0;
        if (r1 == null) goto L13;
        Intrinsics.checkNotNull(r1);
        r1.getPadding(r0);
        Drawable r3 = this.f14246a;
        Intrinsics.checkNotNull(r3);
        int r4 = (r3.getIntrinsicWidth() - r0.left) - r0.right;
        Drawable r5 = this.f14246a;
        Intrinsics.checkNotNull(r5);
        int r6 = r5.getIntrinsicHeight();
    L15:
        if (this.r == false) goto L25;
        Layout r9 = this.K;
        if (r9 != null) goto L19;
        int r10 = 0;
    L20:
        Layout r11 = this.L;
        if (r11 != null) goto L23;
        int r12 = 0;
    L24:
        int r13 = Math.max(r10, r12) + (this.l * 2);
    L26:
        this.C = Math.max(r13, r4);
        this.D = r6;
        Drawable r14 = this.g;
        if (r14 == null) goto L29;
        Intrinsics.checkNotNull(r14);
        r14.getPadding(r0);
        Drawable r15 = this.g;
        Intrinsics.checkNotNull(r15);
        r2 = r15.getIntrinsicHeight();
    L30:
        int r16 = r0.left;
        int r17 = r0.right;
        Drawable r18 = this.f14246a;
        if (r18 == null) goto L33;
        Rect r19 = DrawableUtils.getOpticalBounds(r18);
        r16 = Math.max(r16, r19.left);
        r17 = Math.max(r17, r19.right);
    L33:
        int r20 = Math.max(this.m, ((this.C * 2) + r16) + r17);
        int r21 = Math.max(r2, r6);
        this.z = r20 - this.A;
        this.B = r21;
        super.onMeasure(r7, r8);
        if (getMeasuredHeight() >= r21) goto L37;
        setMeasuredDimension(getMeasuredWidthAndState(), r21);
        return;
    L37:
        return;
    L29:
        r0.setEmpty();
        goto L30
    L23:
        r12 = r11.getWidth();
        goto L24
    L19:
        r10 = r9.getWidth();
        goto L20
    L25:
        r13 = 0;
        goto L26
    L13:
        r4 = 0;
        r6 = 0;
        goto L15
    L5:
        if (this.K != null) goto L8;
        this.K = a(this.p);
    L8:
        if (this.L != null) goto L10;
        this.L = a(this.q);
        goto L10
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super.onPopulateAccessibilityEvent(r2);
        if (isChecked() == false) goto L5;
        CharSequence r1 = this.p;
    L6:
        if (r1 == null) goto L9;
        r2.getText().add(r1);
        return;
    L9:
        return;
    L5:
        r1 = this.q;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        this.w.addMovement(r8);
        int r0 = r8.getActionMasked();
        if (r0 == 0) goto L41;
        boolean r2 = false;
        if (r0 == 1) goto L37;
        if (r0 != 2) goto L8;
        int r1 = this.s;
        if (r1 == 1) goto L30;
        if (r1 != 2) goto L47;
        float r9 = r8.getX();
        int r3 = getThumbScrollRange();
        float r4 = r9 - this.u;
        if (r3 == 0) goto L18;
        float r5 = r4 / r3;
    L22:
        if (ViewUtils.isLayoutRtl((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == false) goto L24;
        r5 = -r5;
    L24:
        float r6 = a.a(f14244b, this.T + r5, 0.0f, 1.0f);
        if (r6 != this.T) goto L27;
        r2 = true;
    L27:
        if (r2 == true) goto L29;
        this.u = r9;
        this.T = r6;
    L29:
        return true;
    L18:
        if (r4 <= 0.0f) goto L20;
        r5 = 1.0f;
        goto L22
    L20:
        r5 = -1.0f;
    L47:
        return super.onTouchEvent(r8);
    L30:
        float r7 = r8.getX();
        float r10 = r8.getY();
        if (Math.abs(r7 - this.u) <= this.t) goto L33;
    L34:
        this.s = 2;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.u = r7;
        this.v = r10;
        return true;
    L33:
        if (Math.abs(r10 - this.v) <= this.t) goto L47;
    L8:
        if (r0 != 3) goto L47;
    L37:
        if (this.s != 2) goto L40;
        b(r8);
        super.onTouchEvent(r8);
        return true;
    L40:
        this.s = 0;
        this.w.clear();
        goto L47
    L41:
        float r11 = r8.getX();
        float r12 = r8.getY();
        if (isEnabled() == false) goto L47;
        if (a(r11, r12) == false) goto L47;
        this.s = 1;
        this.u = r11;
        this.v = r12;
        goto L47
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        boolean r0 = super.performClick();
        if (isHapticFeedbackEnabled() == false) goto L5;
        a(isChecked());
    L5:
        return r0;
    }

    public final void setAutoCheck(boolean r1) {
        this.R = r1;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r2) {
        super.setChecked(r2);
        boolean r3 = isChecked();
        if (getWindowToken() != null) goto L5;
    L7:
        e();
        if (r3 == false) goto L10;
        float r4 = 1.0f;
    L11:
        setThumbPosition(r4);
        return;
    L10:
        r4 = 0.0f;
        goto L11
    L5:
        if (a() == false) goto L7;
        b(r3);
    }

    public void setCheckedNoAnim(boolean r1) {
        super.setChecked(r1);
        e();
        if (isChecked() == false) goto L5;
        float r2 = 1.0f;
    L6:
        setThumbPosition(r2);
        return;
    L5:
        r2 = 0.0f;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback r3) {
        ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "actionModeCallback");
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback((TextView) ZeusTransformUtils.preCheckCast(this, TextView.class, "com.obric.memorydata.plugin"), r4));
    }

    public final void setMPositionAnimator(ObjectAnimator r1) {
        this.N = r1;
    }

    public final void setMThumbPosition(float r1) {
        this.y = r1;
    }

    public final void setShowText(boolean r1) {
    }

    public final void setSplitTrack(boolean r1) {
        this.o = r1;
        invalidate();
    }

    public final void setSwitchMinWidth(int r1) {
        this.m = r1;
        requestLayout();
    }

    public final void setSwitchPadding(int r1) {
        this.n = r1;
        requestLayout();
    }

    public final void setSwitchTypeface(Typeface r2) {
        if (this.I.getTypeface() == null) goto L7;
        if (Intrinsics.areEqual(this.I.getTypeface(), r2) == true) goto L7;
    L9:
        this.I.setTypeface(r2);
        requestLayout();
        invalidate();
        return;
    L7:
        if (this.I.getTypeface() != null) goto L11;
        if (r2 != null) goto L9;
        return;
    }

    public final void setTextOff(CharSequence r3) {
        this.q = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        requestLayout();
    }

    public final void setTextOn(CharSequence r3) {
        this.p = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        requestLayout();
    }

    public final void setThumbConstraintLeft(int r1) {
        this.P = r1;
    }

    public final void setThumbConstraintRight(int r1) {
        this.Q = r1;
    }

    public final void setThumbDrawable(Drawable r3) {
        Drawable r0 = this.f14246a;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.setCallback(null);
    L5:
        this.f14246a = r3;
        if (r3 == null) goto L8;
        r3.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.memorydata.plugin"));
    L8:
        requestLayout();
    }

    public final void setThumbPosition(float r1) {
        this.y = r1;
        invalidate();
    }

    public final void setThumbResource(int r4) {
        setThumbDrawable(AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public final void setThumbTextPadding(int r1) {
        this.l = r1;
        requestLayout();
    }

    public final void setThumbTintList(ColorStateList r1) {
        this.c = r1;
        this.e = true;
        c();
    }

    public final void setThumbTintMode(PorterDuff.Mode r1) {
        this.d = r1;
        this.f = true;
        c();
    }

    public final void setTrackDrawable(Drawable r3) {
        Drawable r0 = this.g;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.setCallback(null);
    L5:
        this.g = r3;
        if (r3 == null) goto L8;
        r3.setCallback((Drawable.Callback) ZeusTransformUtils.preCheckCast(this, Drawable.Callback.class, "com.obric.memorydata.plugin"));
    L8:
        requestLayout();
    }

    public final void setTrackResource(int r4) {
        setTrackDrawable(AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public final void setTrackTintList(ColorStateList r1) {
        this.h = r1;
        this.j = true;
        b();
    }

    public final void setTrackTintMode(PorterDuff.Mode r1) {
        this.i = r1;
        this.k = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        if (this.R == false) goto L6;
        setChecked(!isChecked());
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable r2) {
        Intrinsics.checkNotNullParameter(r2, "who");
        if (super.verifyDrawable(r2) == false) goto L5;
    L10:
        return true;
    L5:
        if (r2 == this.f14246a) goto L10;
        if (r2 == this.g) goto L10;
        return false;
    }
}
