package com.obric.oui.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.h;
import com.obric.oui.common.style.b;
import com.obric.oui.common.style.c;
import com.obric.oui.common.style.e;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b^\b\u0017\u0018\u0000 Õ\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002Õ\u0001B7\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0010H\u0002J\t\u0010.\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020\u0010H\u0096\u0001J\u0010\u00101\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u000103J\t\u00104\u001a\u00020\u0002H\u0096\u0001J\u0010\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0013H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J-\u0010;\u001a&\u0012\f\u0012\n >*\u0004\u0018\u00010=0= >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00010=0=\u0018\u00010?0<H\u0096\u0001J\t\u0010@\u001a\u00020(H\u0096\u0001J\t\u0010A\u001a\u00020\u0003H\u0096\u0001J\t\u0010B\u001a\u00020\nH\u0096\u0001J\t\u0010C\u001a\u00020\u0013H\u0096\u0001J\t\u0010D\u001a\u00020\nH\u0096\u0001J\t\u0010E\u001a\u00020\nH\u0096\u0001J\u0019\u0010F\u001a\u00020,2\u000e\u0010G\u001a\n >*\u0004\u0018\u00010H0HH\u0096\u0001J\t\u0010I\u001a\u00020\u0010H\u0096\u0001J\t\u0010J\u001a\u00020\u0010H\u0096\u0001J\t\u0010K\u001a\u00020\u0010H\u0096\u0001J\t\u0010L\u001a\u00020\u0010H\u0096\u0001J\t\u0010M\u001a\u00020\u0010H\u0096\u0001J\u001a\u0010N\u001a\u00020,2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\t\u0010O\u001a\u00020\u0010H\u0096\u0001J\t\u0010P\u001a\u00020\u0010H\u0096\u0001J\u0010\u0010Q\u001a\u00020,2\u0006\u00102\u001a\u000203H\u0014J0\u0010R\u001a\u00020,2\u0006\u0010S\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0014J\u0018\u0010X\u001a\u00020,2\u0006\u0010Y\u001a\u00020\n2\u0006\u0010Z\u001a\u00020\nH\u0014J\u0010\u0010[\u001a\u00020,2\u0006\u0010\\\u001a\u00020\nH\u0017J!\u0010]\u001a\u00020,2\u000e\u0010^\u001a\n >*\u0004\u0018\u00010_0_2\u0006\u0010`\u001a\u00020\u0010H\u0096\u0001J!\u0010a\u001a\u00020,2\u000e\u0010^\u001a\n >*\u0004\u0018\u00010_0_2\u0006\u0010`\u001a\u00020\u0010H\u0096\u0001J)\u0010b\u001a\u00020,2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\nH\u0096\u0001J)\u0010g\u001a\u00020,2\u0006\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\u0006\u0010k\u001a\u00020\nH\u0096\u0001J)\u0010l\u001a\u00020,2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\nH\u0096\u0001J)\u0010q\u001a\u00020,2\u0006\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\nH\u0096\u0001J\u0019\u0010v\u001a\u00020,2\u000e\u0010w\u001a\n >*\u0004\u0018\u00010x0xH\u0096\u0001J\t\u0010y\u001a\u00020,H\u0096\u0001J\u0013\u0010z\u001a\u00020,2\b\b\u0001\u0010{\u001a\u00020\nH\u0096\u0001J\u0011\u0010|\u001a\u00020,2\u0006\u0010}\u001a\u00020\nH\u0096\u0001J\u0011\u0010~\u001a\u00020,2\u0006\u0010\u007f\u001a\u00020\nH\u0096\u0001J\u0010\u0010\u0080\u0001\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020\nJ\u0019\u0010\u0080\u0001\u001a\u00020,2\u0007\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\nJ\u0013\u0010\u0083\u0001\u001a\u00020,2\u0007\u0010\u0084\u0001\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010\u0085\u0001\u001a\u00020,2\u0007\u0010\u0086\u0001\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010\u0087\u0001\u001a\u00020,2\u0007\u0010\u0088\u0001\u001a\u00020\u0010H\u0096\u0001J1\u0010\u0089\u0001\u001a\u00020,2\b\u0010T\u001a\u0004\u0018\u00010\u00192\b\u0010U\u001a\u0004\u0018\u00010\u00192\b\u0010V\u001a\u0004\u0018\u00010\u00192\b\u0010W\u001a\u0004\u0018\u00010\u0019H\u0016J3\u0010\u008a\u0001\u001a\u00020,2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00192\b\u0010U\u001a\u0004\u0018\u00010\u00192\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00192\b\u0010W\u001a\u0004\u0018\u00010\u0019H\u0016J\u000f\u0010\u008d\u0001\u001a\u00020,2\u0006\u0010\\\u001a\u00020\u0013J\u0013\u0010\u008e\u0001\u001a\u00020,2\u0007\u0010\u008f\u0001\u001a\u00020\u0010H\u0096\u0001J\u0012\u0010\u0090\u0001\u001a\u00020,2\u0007\u0010\u0091\u0001\u001a\u00020\u0010H\u0016J\u0013\u0010\u0092\u0001\u001a\u00020\u00102\u0007\u0010\u0093\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0094\u0001\u001a\u00020,2\u0007\u0010\u0095\u0001\u001a\u00020\u0010H\u0096\u0001J\u0012\u0010\u0096\u0001\u001a\u00020,2\u0006\u0010\u007f\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0097\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u0099\u0001\u001a\u00020,2\u0007\u0010\u009a\u0001\u001a\u00020\u0010H\u0096\u0001J*\u0010\u009b\u0001\u001a\u00020,2\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\u0006\u0010V\u001a\u00020\n2\u0006\u0010W\u001a\u00020\nH\u0096\u0001J\u0013\u0010\u009c\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u009d\u0001\u001a\u00020,2\u0006\u0010`\u001a\u00020\u0010H\u0002J\u0011\u0010\u009e\u0001\u001a\u00020,2\u0006\u0010`\u001a\u00020\u0010H\u0016J\u0013\u0010\u009f\u0001\u001a\u00020,2\u0007\u0010 \u0001\u001a\u00020\nH\u0096\u0001J.\u0010\u009f\u0001\u001a\u00020,2\u0007\u0010¡\u0001\u001a\u00020\n2\u0007\u0010¢\u0001\u001a\u00020\n2\u0007\u0010£\u0001\u001a\u00020\n2\u0007\u0010¤\u0001\u001a\u00020\nH\u0096\u0001J%\u0010¥\u0001\u001a\u00020,2\u0007\u0010 \u0001\u001a\u00020\n2\u0007\u0010¦\u0001\u001a\u00020\n2\u0007\u0010§\u0001\u001a\u00020\u0013H\u0096\u0001J.\u0010¥\u0001\u001a\u00020,2\u0007\u0010 \u0001\u001a\u00020\n2\u0007\u0010¦\u0001\u001a\u00020\n2\u0007\u0010¨\u0001\u001a\u00020\n2\u0007\u0010§\u0001\u001a\u00020\u0013H\u0096\u0001J\u0012\u0010©\u0001\u001a\u00020,2\u0006\u0010\u007f\u001a\u00020\nH\u0096\u0001J\u0012\u0010ª\u0001\u001a\u00020,2\u0007\u0010«\u0001\u001a\u00020\u0010H\u0016J-\u0010¬\u0001\u001a\u00020,2\u000b\b\u0001\u0010\u00ad\u0001\u001a\u0004\u0018\u00010=2\u000b\b\u0001\u0010®\u0001\u001a\u0004\u0018\u00010=2\u0007\u0010¯\u0001\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010°\u0001\u001a\u00020,2\u0007\u0010§\u0001\u001a\u00020\u0013H\u0096\u0001J\u0013\u0010±\u0001\u001a\u00020,2\u0007\u0010¨\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010²\u0001\u001a\u00020,2\u0007\u0010 \u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010³\u0001\u001a\u00020,2\u0007\u0010´\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010µ\u0001\u001a\u00020,2\u0007\u0010¶\u0001\u001a\u00020\n2\u0007\u0010·\u0001\u001a\u00020\nH\u0096\u0001J\u0015\u0010¸\u0001\u001a\u00020,2\t\b\u0001\u0010¹\u0001\u001a\u00020\nH\u0096\u0001J\u001c\u0010º\u0001\u001a\u00020,2\u0007\u0010»\u0001\u001a\u00020\u00102\u0007\u0010¯\u0001\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010¼\u0001\u001a\u00020,2\u0007\u0010½\u0001\u001a\u00020\u0010H\u0096\u0001J\u0012\u0010¾\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0016J\u0012\u0010¿\u0001\u001a\u00020,2\u0006\u0010\u007f\u001a\u00020\nH\u0096\u0001J\n\u0010À\u0001\u001a\u00020,H\u0096\u0001J\u0013\u0010Á\u0001\u001a\u00020\u00102\u0007\u0010Â\u0001\u001a\u00020\nH\u0096\u0001J\u0013\u0010Ã\u0001\u001a\u00020,2\u0007\u0010Ä\u0001\u001a\u00020\nH\u0096\u0001J\n\u0010Å\u0001\u001a\u00020\u0010H\u0096\u0001J*\u0010Æ\u0001\u001a\u00020,2\u0006\u0010c\u001a\u00020\n2\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\nH\u0096\u0001J\u0013\u0010Ç\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001J\u0012\u0010È\u0001\u001a\u00020,2\u0007\u0010\u0091\u0001\u001a\u00020\u0010H\u0002J\u0013\u0010É\u0001\u001a\u00020,2\u0007\u0010Ê\u0001\u001a\u00020\u0013H\u0096\u0001J\u0011\u0010Ë\u0001\u001a\u00020,2\u0006\u00106\u001a\u00020\u0013H\u0002J*\u0010Ì\u0001\u001a\u00020,2\u0006\u0010h\u001a\u00020\n2\u0006\u0010i\u001a\u00020\n2\u0006\u0010j\u001a\u00020\n2\u0006\u0010k\u001a\u00020\nH\u0096\u0001J\u0013\u0010Í\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001J*\u0010Î\u0001\u001a\u00020,2\u0006\u0010m\u001a\u00020\n2\u0006\u0010n\u001a\u00020\n2\u0006\u0010o\u001a\u00020\n2\u0006\u0010p\u001a\u00020\nH\u0096\u0001J\u0013\u0010Ï\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001J;\u0010Ð\u0001\u001a\u00020,2/\b\u0001\u0010Ñ\u0001\u001a(\u0012\f\u0012\n >*\u0004\u0018\u00010=0=\u0018\u0001 >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00010=0=\u0018\u00010?0<H\u0096\u0001J\u0011\u0010Ò\u0001\u001a\u00020,2\u0006\u00106\u001a\u00020\u0013H\u0002J*\u0010Ó\u0001\u001a\u00020,2\u0006\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\nH\u0096\u0001J\u0013\u0010Ô\u0001\u001a\u00020,2\u0007\u0010\u0098\u0001\u001a\u00020\nH\u0096\u0001R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Ö\u0001"}, d2 = {"Lcom/obric/oui/button/OButton;", "Landroid/widget/Button;", "Lcom/obric/oui/common/style/IOUIAlpha;", "Lcom/obric/oui/common/style/IOUILayout;", "Lcom/obric/oui/common/style/IOUIStyleProvider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "provider", "Lcom/obric/oui/common/style/OUIStyleProvider;", "(Landroid/content/Context;Landroid/util/AttributeSet;IILcom/obric/oui/common/style/OUIStyleProvider;)V", "changeAlphaWhenPressed", "", "customPaddingOffset", "disabledAlpha", "", "internalPressState", "isInternalTextColorChange", "mAlphaHelper", "Lcom/obric/oui/common/style/OUIAlphaHelper;", EventBody.KEY_VALUE, "Landroid/graphics/drawable/Drawable;", "mIcon", "getMIcon", "()Landroid/graphics/drawable/Drawable;", "setMIcon", "(Landroid/graphics/drawable/Drawable;)V", "mImageSourceId", "mImageTintColorId", "getMImageTintColorId", "()I", "setMImageTintColorId", "(I)V", "mLayoutHelper", "Lcom/obric/oui/common/style/OUILayoutHelper;", "mOUIEffectHelper", "Lcom/obric/oui/common/style/OUIEffectHelper;", "originIconAlpha", "originTextColor", "adjustPaddingLeft", "", "hasLeftDrawable", "decideIsNeedUpdatePressedForegroundBySelf", "disablePressReleaseAnim", "disable", "drawIcon", "canvas", "Landroid/graphics/Canvas;", "getAlphaHelper", "getAnimatedPressAlpha", "fraction", "getBitmapFromVectorDrawable", "Landroid/graphics/Bitmap;", "vectorDrawable", "Landroid/graphics/drawable/VectorDrawable;", "getCurrentShadows", "", "Lcom/obric/oui/common/style/Shadow;", "kotlin.jvm.PlatformType", "", "getEffectHelper", "getLayoutHelper", "getRadius", "getShadowAlpha", "getShadowColor", "getShadowElevation", "handleTouchEvent", "event", "Landroid/view/MotionEvent;", "hasBorder", "hasBottomSeparator", "hasLeftSeparator", "hasRightSeparator", "hasTopSeparator", "initView", "isEnableShadowWidthRadius", "isShadowVisible", "onDraw", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPressAlphaChange", "alpha", "onPressedChanged", "current", "Landroid/view/View;", "pressed", "onSelectedChanged", "onlyShowBottomDivider", "bottomInsetLeft", "bottomInsetRight", "bottomDividerHeight", "bottomDividerColor", "onlyShowLeftDivider", "leftInsetTop", "leftInsetBottom", "leftDividerWidth", "leftDividerColor", "onlyShowRightDivider", "rightInsetTop", "rightInsetBottom", "rightDividerWidth", "rightDividerColor", "onlyShowTopDivider", "topInsetLeft", "topInsetRight", "topDividerHeight", "topDividerColor", "refreshColors", MemoryInfoSectionEditActivity.KIND_SCENE, "", "resetAlphaAnim", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setBottomDividerAlpha", "dividerAlpha", "setButtonSourceBitmap", "resId", "tintColor", "setChangeAlphaWhenDisable", "changeAlphaWhenDisable", "setChangeAlphaWhenPress", "changeAlphaWhenPress", "setChangeAlphaWhenSelected", "changeAlphaWhenSelected", "setCompoundDrawables", "setCompoundDrawablesRelative", CommonConsts.APM_INNER_EVENT_COST_START, "end", "setDisabledTextAlpha", "setEnableShadowWidthRadius", "enableShadowWidthRadius", "setEnabled", "enabled", "setHeightLimit", "heightLimit", "setKeepPressAlpha", "keep", "setLeftDividerAlpha", "setOuterNormalColor", TypedValues.Custom.S_COLOR, "setOutlineExcludePadding", "outlineExcludePadding", "setOutlineInset", "setOverridePressColor", "setPressState", "setPressed", "setRadius", "radius", "tlRadius", "trRadius", "blRadius", "brRadius", "setRadiusAndShadow", "shadowElevation", "shadowAlpha", "shadowColor", "setRightDividerAlpha", "setSelected", BuildConfig.FLAVOR, "setShadow", "firstShadow", "secondShadow", "animate", "setShadowAlpha", "setShadowColor", "setShadowCornerRadius", "setShadowElevation", "elevation", "setShadowInsets", "insetX", "insetY", "setShadowStyle", "styleResId", "setShadowVisible", "visible", "setShowBorderOnlyBeforeL", "showBorderOnlyBeforeL", "setTextColor", "setTopDividerAlpha", "setUseThemeGeneralShadowElevation", "setWidthLimit", "widthLimit", "setWidthMin", "minWidth", "shouldUpdateDividerColorOnPress", "updateBottomDivider", "updateBottomSeparatorColor", "updateContentColorForState", "updateDividerColorStrength", "strength", "updateIconAlphaOnPress", "updateLeftDivider", "updateLeftSeparatorColor", "updateRightDivider", "updateRightSeparatorColor", "updateShadows", "shadows", "updateTextColorOnPress", "updateTopDivider", "updateTopSeparatorColor", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OButton extends Button implements com.obric.oui.common.style.a, b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13376a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ com.obric.oui.common.style.a f13377b;
    private final /* synthetic */ b c;
    private final /* synthetic */ i d;
    private f e;
    private c f;
    private e g;
    private Drawable h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private boolean n;
    private int o;
    private float p;
    private boolean q;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/button/OButton$Companion;", "", "()V", "ALPHA_ON_PRESS", "", "TAG", "", "createButton", "Lcom/obric/oui/button/OButton;", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "layoutResId", "", "createNeutralButton", "createPrimaryButton", "createPrimaryLightButton", "createTransButton", "createTransIconButton", "createUnderstatedButton", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13376a = new a(null);
    }

    public OButton(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, null, 28, null);
    }

    public OButton(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r13, 0, null, 24, null);
    }

    public OButton(Context r2, AttributeSet r3, int r4, int r5, i r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r6, "provider");
        super(r7, r8, r4);
        this.f13377b = r6.a();
        this.c = r6.b();
        this.d = r6;
        this.p = 1.0f;
        ((f) ZeusTransformUtils.preCheckCast(r6.b(), f.class, "com.obric.memorydata.plugin")).a(true);
        r6.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"));
        this.e = (f) ZeusTransformUtils.preCheckCast(getLayoutHelper(), f.class, "com.obric.memorydata.plugin");
        this.f = (c) ZeusTransformUtils.preCheckCast(getAlphaHelper(), c.class, "com.obric.memorydata.plugin");
        this.g = getEffectHelper();
        setChangeAlphaWhenPress(true);
        setChangeAlphaWhenDisable(true);
        a(r7, r8);
    }

    public /* synthetic */ OButton(Context r4, AttributeSet r5, int r6, int r7, i r8, int r9, DefaultConstructorMarker r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        int r0 = 0;
        if ((r9 & 4) == 0) goto L5;
        int r1 = 0;
    L7:
        if ((r9 & 8) != 0) goto L11;
        r0 = r7;
    L11:
        if ((r9 & 16) == 0) goto L13;
        r8 = new i(r11, r12, r1, r0);
    L13:
        this(r11, r12, r1, r0, r8);
        return;
    L5:
        r1 = r6;
        goto L7
    }

    private final void a(float r8) {
        int r0 = this.l;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = (r0 >> 24) & 255;
        int r2 = RangesKt.coerceIn((int) (r1 * c(r8)), 0, 255);
        int r3 = ((r0 >> 16) & 255) << 16;
        setTextColor((r0 & 255) | ((r3 | (r2 << 24)) | (((r0 >> 8) & 255) << 8)));
        com.obric.oui.c.a.b.b("OButton", "updateTextColorOnPress, fraction: " + r8 + ", newTextAlpha: " + r2 + ", originTextAlpha: " + r1);
    }

    private final void a(Context r7, AttributeSet r8) {
        TypedArray r9 = ((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.OButton);
        Intrinsics.checkNotNullExpressionValue(r9, "context.obtainStyledAttr…trs, R.styleable.OButton)");
        this.i = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OButton_icon, "styleable", "OButton_icon"), 0);
        setMImageTintColorId(r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OButton_iconTint, "styleable", "OButton_iconTint"), 0));
        int r10 = this.i;
        if (r10 == 0) goto L5;
        setButtonSourceBitmap(r10);
    L5:
        setTextAppearance(r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_buttonTextStyle, "styleable", "OButton_oui_buttonTextStyle"), ZeusTransformUtils.mapRes(R.style.Title_Title_M_Thick, "style", "Title_Title_M_Thick")));
        this.n = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_buttonChangeAlphaWhenPressed, "styleable", "OButton_oui_buttonChangeAlphaWhenPressed"), false);
        int r11 = getCurrentTextColor();
        this.l = r11;
        ColorStateList r12 = ColorStateList.valueOf(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "valueOf(textColor)");
        setCompoundDrawableTintList(r12);
        this.o = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_widgetPaddingOffset, "styleable", "OButton_oui_widgetPaddingOffset"), 0);
        Drawable[] r13 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r13, "getCompoundDrawables()");
        if (((Drawable) ZeusTransformUtils.preCheckCast(ArraysKt.getOrNull((Object[]) ZeusTransformUtils.preCheckCast(r13, Object[].class, "com.obric.memorydata.plugin"), 0), Drawable.class, "com.obric.memorydata.plugin")) == null) goto L8;
        b(true);
    L8:
        this.p = r9.getFloat(ZeusTransformUtils.mapRes(R.styleable.OButton_oui_widgetDisableAlpha, "styleable", "OButton_oui_widgetDisableAlpha"), 1.0f);
        r9.recycle();
        a(isEnabled());
    }

    private final void a(boolean r8) {
        int r0 = this.l;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r4 = 0;
        if (r8 == true) goto L14;
        int r9 = h.a(r0, this.p);
        this.q = true;
        super.setTextColor(r9);
        this.q = false;
        Drawable[] r10 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r10, "compoundDrawables");
        Object[] r11 = (Object[]) ZeusTransformUtils.preCheckCast(r10, Object[].class, "com.obric.memorydata.plugin");
        int r1 = r11.length;
    L8:
        if (r4 >= r1) goto L21;
        Drawable r2 = (Drawable) ZeusTransformUtils.preCheckCast(r11[r4], Drawable.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L13;
        r2.setAlpha((int) (this.p * 255));
    L13:
        r4 = r4 + 1;
    L21:
        invalidate();
        return;
    L14:
        this.q = true;
        super.setTextColor(r0);
        this.q = false;
        Drawable[] r12 = getCompoundDrawables();
        Intrinsics.checkNotNullExpressionValue(r12, "compoundDrawables");
        Object[] r13 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.memorydata.plugin");
        int r3 = r13.length;
    L15:
        if (r4 >= r3) goto L21;
        Drawable r5 = (Drawable) ZeusTransformUtils.preCheckCast(r13[r4], Drawable.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L20;
        r5.setAlpha(255);
    L20:
        r4 = r4 + 1;
        goto L15
    }

    private final void b(float r4) {
        int r0 = this.m;
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = RangesKt.coerceIn((int) (r0 * c(r4)), 0, 255);
        Drawable r2 = this.h;
        if (r2 == null) goto L9;
        r2.setAlpha(r1);
    L9:
        com.obric.oui.c.a.b.b("OButton", "updateIconAlphaOnPress, fraction: " + r4 + ", alpha: " + r1 + ", originIconAlpha: " + this.m);
    }

    private final void b(boolean r5) {
        int r0 = getPaddingTop();
        int r1 = getPaddingRight();
        int r2 = getPaddingBottom();
        if (r5 == false) goto L5;
        int r6 = getPaddingRight() - this.o;
    L7:
        if (r6 == getPaddingLeft()) goto L10;
        setPadding(r6, r0, r1, r2);
        return;
    L10:
        return;
    L5:
        r6 = getPaddingRight();
        goto L7
    }

    private final float c(float r2) {
        return 1 - (r2 * 0.7f);
    }

    private final void setPressState(boolean r4) {
        if (this.k != r4) goto L6;
        com.obric.oui.c.a.b.d("OButton", Intrinsics.stringPlus("setPressState, already set, skip! pressed: ", Boolean.valueOf(r4)));
        return;
    L6:
        this.k = r4;
        e r0 = this.g;
        if (r0 == null) goto L10;
        r0.b(r4);
    L10:
        c r1 = this.f;
        if (r1 == null) goto L15;
        r1.onPressedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        return;
    }

    public final void a(Canvas r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        Drawable r0 = this.h;
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = (getWidth() - r0.getIntrinsicWidth()) / 2;
        int r2 = (getHeight() - r0.getIntrinsicHeight()) / 2;
        r0.setBounds(r1, r2, r0.getIntrinsicWidth() + r1, r0.getIntrinsicHeight() + r2);
        if (this.j == 0) goto L10;
        r0.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new PorterDuffColorFilter(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(this.j), PorterDuff.Mode.SRC_IN), ColorFilter.class, "com.obric.memorydata.plugin"));
    L10:
        r0.draw(r6);
    }

    @Override // com.obric.oui.common.style.b
    public boolean decideIsNeedUpdatePressedForegroundBySelf() {
        return this.c.decideIsNeedUpdatePressedForegroundBySelf();
    }

    @Override // com.obric.oui.common.style.a
    public void disablePressReleaseAnim(boolean r1) {
        this.f13377b.disablePressReleaseAnim(r1);
    }

    public com.obric.oui.common.style.a getAlphaHelper() {
        return this.d.a();
    }

    @Override // com.obric.oui.common.style.b
    public List<k> getCurrentShadows() {
        return this.c.getCurrentShadows();
    }

    public e getEffectHelper() {
        return this.d.c();
    }

    public b getLayoutHelper() {
        return this.d.b();
    }

    public final Drawable getMIcon() {
        return this.h;
    }

    public final int getMImageTintColorId() {
        return this.j;
    }

    @Override // com.obric.oui.common.style.b
    public int getRadius() {
        return this.c.getRadius();
    }

    @Override // com.obric.oui.common.style.b
    public float getShadowAlpha() {
        return this.c.getShadowAlpha();
    }

    @Override // android.widget.TextView, com.obric.oui.common.style.b
    public int getShadowColor() {
        return this.c.getShadowColor();
    }

    @Override // com.obric.oui.common.style.b
    public int getShadowElevation() {
        return this.c.getShadowElevation();
    }

    @Override // com.obric.oui.common.style.a
    public void handleTouchEvent(MotionEvent r1) {
        this.f13377b.handleTouchEvent(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBorder() {
        return this.c.hasBorder();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasBottomSeparator() {
        return this.c.hasBottomSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasLeftSeparator() {
        return this.c.hasLeftSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasRightSeparator() {
        return this.c.hasRightSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean hasTopSeparator() {
        return this.c.hasTopSeparator();
    }

    @Override // com.obric.oui.common.style.b
    public boolean isEnableShadowWidthRadius() {
        return this.c.isEnableShadowWidthRadius();
    }

    @Override // com.obric.oui.common.style.b
    public boolean isShadowVisible() {
        return this.c.isShadowVisible();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.onDraw(r2);
        a(r2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        int r6 = getMeasuredWidth();
        int r7 = getMeasuredHeight();
        Drawable r0 = this.h;
        if (r0 == null) goto L6;
        r6 = Math.max(r6, (r0.getIntrinsicWidth() + getPaddingLeft()) + getPaddingRight());
        r7 = Math.max(r7, (r0.getIntrinsicHeight() + getPaddingTop()) + getPaddingBottom());
    L6:
        setMeasuredDimension(r6, r7);
    }

    @Override // com.obric.oui.common.style.b
    public void onPressAlphaChange(int r3) {
        if (this.n == true) goto L5;
        return;
    L5:
        float r4 = RangesKt.coerceIn(r3 / 255.0f, 0.0f, 1.0f);
        a(r4);
        b(r4);
    }

    @Override // com.obric.oui.common.style.a
    public void onPressedChanged(View r1, boolean r2) {
        this.f13377b.onPressedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.a
    public void onSelectedChanged(View r1, boolean r2) {
        this.f13377b.onSelectedChanged(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowBottomDivider(int r1, int r2, int r3, int r4) {
        this.c.onlyShowBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowLeftDivider(int r1, int r2, int r3, int r4) {
        this.c.onlyShowLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowRightDivider(int r1, int r2, int r3, int r4) {
        this.c.onlyShowRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void onlyShowTopDivider(int r1, int r2, int r3, int r4) {
        this.c.onlyShowTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.a
    public void refreshColors(String r1) {
        this.f13377b.refreshColors(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void resetAlphaAnim() {
        this.f13377b.resetAlphaAnim();
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderColor(int r1) {
        this.c.setBorderColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setBorderWidth(int r1) {
        this.c.setBorderWidth(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setBottomDividerAlpha(int r1) {
        this.c.setBottomDividerAlpha(r1);
    }

    public final void setButtonSourceBitmap(int r4) {
        if (r4 != 0) goto L4;
        return;
    L4:
        setMIcon(ContextCompat.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
        Drawable r5 = this.h;
        if (r5 != null) goto L7;
        int r6 = 0;
    L8:
        this.m = r6;
        invalidate();
        return;
    L7:
        r6 = r5.getAlpha();
        goto L8
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenDisable(boolean r1) {
        this.f13377b.setChangeAlphaWhenDisable(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenPress(boolean r1) {
        this.f13377b.setChangeAlphaWhenPress(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setChangeAlphaWhenSelected(boolean r1) {
        this.f13377b.setChangeAlphaWhenSelected(r1);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        b(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        b(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public final void setDisabledTextAlpha(float r1) {
        this.p = r1;
        if (isEnabled() == true) goto L6;
        a(false);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setEnableShadowWidthRadius(boolean r1) {
        this.c.setEnableShadowWidthRadius(r1);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        c r0 = this.f;
        if (r0 == null) goto L6;
        r0.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
    L6:
        a(r4);
    }

    @Override // com.obric.oui.common.style.b
    public boolean setHeightLimit(int r1) {
        return this.c.setHeightLimit(r1);
    }

    @Override // com.obric.oui.common.style.a
    public void setKeepPressAlpha(boolean r1) {
        this.f13377b.setKeepPressAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setLeftDividerAlpha(int r1) {
        this.c.setLeftDividerAlpha(r1);
    }

    public final void setMIcon(Drawable r1) {
        this.h = r1;
        requestLayout();
        invalidate();
    }

    public final void setMImageTintColorId(int r1) {
        this.j = r1;
        invalidate();
    }

    @Override // com.obric.oui.common.style.b
    public void setOuterNormalColor(int r1) {
        this.c.setOuterNormalColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineExcludePadding(boolean r1) {
        this.c.setOutlineExcludePadding(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setOutlineInset(int r1, int r2, int r3, int r4) {
        this.c.setOutlineInset(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.a
    public void setOverridePressColor(int r1) {
        this.f13377b.setOverridePressColor(r1);
    }

    @Override // android.view.View
    public void setPressed(boolean r4) {
        super.setPressed(r4);
        e r0 = this.g;
        if (r0 == null) goto L6;
        r0.b(r4);
    L6:
        c r1 = this.f;
        if (r1 == null) goto L11;
        r1.onPressedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setRadius(int r1) {
        this.c.setRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadius(int r1, int r2, int r3, int r4) {
        this.c.setRadius(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r1, int r2, float r3) {
        this.c.setRadiusAndShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.b
    public void setRadiusAndShadow(int r1, int r2, int r3, float r4) {
        this.c.setRadiusAndShadow(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void setRightDividerAlpha(int r1) {
        this.c.setRightDividerAlpha(r1);
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r4) {
        super.setSelected(r4);
        c r0 = this.f;
        if (r0 == null) goto L7;
        r0.onSelectedChanged((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), r4);
        return;
    }

    @Override // com.obric.oui.common.style.b
    public void setShadow(k r1, k r2, boolean r3) {
        this.c.setShadow(r1, r2, r3);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowAlpha(float r1) {
        this.c.setShadowAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowColor(int r1) {
        this.c.setShadowColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowCornerRadius(int r1) {
        this.c.setShadowCornerRadius(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowElevation(int r1) {
        this.c.setShadowElevation(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowInsets(int r1, int r2) {
        this.c.setShadowInsets(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowStyle(int r1) {
        this.c.setShadowStyle(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setShadowVisible(boolean r1, boolean r2) {
        this.c.setShadowVisible(r1, r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setShowBorderOnlyBeforeL(boolean r1) {
        this.c.setShowBorderOnlyBeforeL(r1);
    }

    @Override // android.widget.TextView
    public void setTextColor(int r2) {
        if (this.q == true) goto L5;
        this.l = r2;
    L5:
        super.setTextColor(r2);
    }

    @Override // com.obric.oui.common.style.b
    public void setTopDividerAlpha(int r1) {
        this.c.setTopDividerAlpha(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setUseThemeGeneralShadowElevation() {
        this.c.setUseThemeGeneralShadowElevation();
    }

    @Override // com.obric.oui.common.style.b
    public boolean setWidthLimit(int r1) {
        return this.c.setWidthLimit(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void setWidthMin(int r1) {
        this.c.setWidthMin(r1);
    }

    @Override // com.obric.oui.common.style.b
    public boolean shouldUpdateDividerColorOnPress() {
        return this.c.shouldUpdateDividerColorOnPress();
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomDivider(int r1, int r2, int r3, int r4) {
        this.c.updateBottomDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateBottomSeparatorColor(int r1) {
        this.c.updateBottomSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateDividerColorStrength(float r1) {
        this.c.updateDividerColorStrength(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftDivider(int r1, int r2, int r3, int r4) {
        this.c.updateLeftDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateLeftSeparatorColor(int r1) {
        this.c.updateLeftSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightDivider(int r1, int r2, int r3, int r4) {
        this.c.updateRightDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateRightSeparatorColor(int r1) {
        this.c.updateRightSeparatorColor(r1);
    }

    @Override // com.obric.oui.common.style.b
    public void updateShadows(List<k> r3) {
        List<k> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.c.updateShadows(r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopDivider(int r1, int r2, int r3, int r4) {
        this.c.updateTopDivider(r1, r2, r3, r4);
    }

    @Override // com.obric.oui.common.style.b
    public void updateTopSeparatorColor(int r1) {
        this.c.updateTopSeparatorColor(r1);
    }
}
