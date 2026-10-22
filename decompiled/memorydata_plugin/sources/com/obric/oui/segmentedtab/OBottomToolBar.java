package com.obric.oui.segmentedtab;

import android.R;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.oui.c.i;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.k;
import com.obric.oui.common.style.m;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.h;
import com.obric.oui.material.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 æ\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\bæ\u0001ç\u0001è\u0001é\u0001B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\t2\u0007\u0010\u0091\u0001\u001a\u00020vH\u0003J\u0013\u0010\u0092\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0093\u0001\u001a\u00020%H\u0016J\n\u0010\u0094\u0001\u001a\u00030\u008f\u0001H\u0002J\u0013\u0010\u0095\u0001\u001a\u00020%2\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\u0013\u0010\u0098\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0099\u0001\u001a\u00020%H\u0002J\u0012\u0010\u009a\u0001\u001a\u00020\t2\u0007\u0010\u009b\u0001\u001a\u00020\fH\u0002J\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010BJ\u0011\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\tJ\u0011\u0010 \u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\tJ\n\u0010¡\u0001\u001a\u00030\u008f\u0001H\u0002J\u001c\u0010¢\u0001\u001a\u00030\u008f\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010£\u0001\u001a\u00030¤\u0001H\u0002J\t\u0010¥\u0001\u001a\u00020%H\u0002J\n\u0010¦\u0001\u001a\u00030\u008f\u0001H\u0002J\u001c\u0010§\u0001\u001a\u00030\u008f\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0013\u0010¨\u0001\u001a\u00030\u008f\u00012\u0007\u0010©\u0001\u001a\u00020eH\u0016J\u0016\u0010ª\u0001\u001a\u00030\u008f\u00012\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0014J\u0014\u0010\u00ad\u0001\u001a\u00030\u008f\u00012\b\u0010®\u0001\u001a\u00030¯\u0001H\u0014J7\u0010°\u0001\u001a\u00030\u008f\u00012\u0007\u0010±\u0001\u001a\u00020%2\u0007\u0010²\u0001\u001a\u00020\t2\u0007\u0010³\u0001\u001a\u00020\t2\u0007\u0010´\u0001\u001a\u00020\t2\u0007\u0010µ\u0001\u001a\u00020\tH\u0014J\u001c\u0010¶\u0001\u001a\u00030\u008f\u00012\u0007\u0010·\u0001\u001a\u00020\t2\u0007\u0010¸\u0001\u001a\u00020\tH\u0014J\u0014\u0010¹\u0001\u001a\u00030\u008f\u00012\b\u0010º\u0001\u001a\u00030»\u0001H\u0014J\f\u0010¼\u0001\u001a\u0005\u0018\u00010»\u0001H\u0014J\n\u0010½\u0001\u001a\u00030\u008f\u0001H\u0002J\u0015\u0010¾\u0001\u001a\u00030\u008f\u00012\t\u0010¿\u0001\u001a\u0004\u0018\u00010vH\u0016J\u0013\u0010À\u0001\u001a\u00030\u008f\u00012\u0007\u0010Á\u0001\u001a\u00020%H\u0016J\u0013\u0010Â\u0001\u001a\u00030\u008f\u00012\u0007\u0010Ã\u0001\u001a\u00020\tH\u0002J\u001a\u0010Ä\u0001\u001a\u00030\u008f\u00012\u0007\u0010Å\u0001\u001a\u00020\t2\u0007\u0010Æ\u0001\u001a\u00020\tJ%\u0010Ç\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\t2\u0007\u0010È\u0001\u001a\u00020\f2\u0007\u0010É\u0001\u001a\u00020\fH\u0002J\u0013\u0010Ê\u0001\u001a\u00030\u008f\u00012\t\u0010Ë\u0001\u001a\u0004\u0018\u00010NJ\n\u0010Ì\u0001\u001a\u00030\u008f\u0001H\u0002JO\u0010Í\u0001\u001a\u00030\u008f\u00012\u000f\u0010Î\u0001\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010S2\b\u0010Ï\u0001\u001a\u00030Ð\u00012\u0007\u0010Ñ\u0001\u001a\u00020\t2\u001b\u0010Ò\u0001\u001a\u0016\u0012\u0004\u0012\u00020B\u0018\u00010Aj\n\u0012\u0004\u0012\u00020B\u0018\u0001`C¢\u0006\u0003\u0010Ó\u0001J0\u0010Ô\u0001\u001a\u00030\u008f\u00012\u000f\u0010Î\u0001\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010S2\u000f\u0010Õ\u0001\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010S¢\u0006\u0003\u0010Ö\u0001J\u0011\u0010×\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\tJ\u001c\u0010Ø\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\t2\u0007\u0010Ù\u0001\u001a\u00020\tH\u0002J\u0012\u0010Ú\u0001\u001a\u00020\t2\u0007\u0010Û\u0001\u001a\u00020\fH\u0002J\u0013\u0010Ü\u0001\u001a\u00030\u008f\u00012\u0007\u0010Ý\u0001\u001a\u00020\tH\u0016J\u0012\u0010Þ\u0001\u001a\u00030\u008f\u00012\u0006\u0010'\u001a\u00020%H\u0016J\u0011\u0010ß\u0001\u001a\u00030\u008f\u00012\u0007\u0010à\u0001\u001a\u00020\tJ\u0013\u0010á\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\tH\u0002J\n\u0010â\u0001\u001a\u00030\u008f\u0001H\u0002J\u0018\u0010ã\u0001\u001a\u00030\u008f\u0001*\u00030ä\u00012\u0007\u0010å\u0001\u001a\u00020%H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\f2\u0006\u0010!\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010)\u001a\u00020%2\u0006\u0010(\u001a\u00020%8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u00020%2\u0006\u0010-\u001a\u00020%8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u000e\u00100\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u000608R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010@\u001a\u0016\u0012\u0004\u0012\u00020B\u0018\u00010Aj\n\u0012\u0004\u0012\u00020B\u0018\u0001`CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0GX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010K\u001a\u000608R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010R\u001a\n\u0012\u0004\u0012\u00020T\u0018\u00010SX\u0082\u000e¢\u0006\u0004\n\u0002\u0010UR\u000e\u0010V\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010a\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010SX\u0082\u000e¢\u0006\u0004\n\u0002\u0010cR\u000e\u0010d\u001a\u00020eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u0004\u0018\u00010jX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010m\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010p\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010r\u001a\u00020\t2\u0006\u0010q\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\u0016R \u0010t\u001a\b\u0012\u0004\u0012\u00020v0uX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010{\u001a\u00020\f2\u0006\u0010{\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b|\u0010\u001e\"\u0004\b}\u0010 R%\u0010~\u001a\u00020\f2\u0006\u0010~\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\r\u001a\u0004\b\u007f\u0010\u001e\"\u0005\b\u0080\u0001\u0010 R(\u0010\u0081\u0001\u001a\u00020\t2\u0007\u0010\u0081\u0001\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0082\u0001\u0010\u0016\"\u0005\b\u0083\u0001\u0010\u0018R(\u0010\u0084\u0001\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0085\u0001\u0010\u0016\"\u0005\b\u0086\u0001\u0010\u0018R(\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\u0087\u0001\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0088\u0001\u0010\u0016\"\u0005\b\u0089\u0001\u0010\u0018R(\u0010\u008b\u0001\u001a\u00020\f2\u0007\u0010\u008a\u0001\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008c\u0001\u0010\u001e\"\u0005\b\u008d\u0001\u0010 ¨\u0006ê\u0001"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomToolBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/MaterialOwner;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animAccuracy", "", "barCornerRadiusPx", "barPaint", "Landroid/graphics/Paint;", "barRectF", "Landroid/graphics/RectF;", "barStrokePaint", "barStrokeRectF", "currentTab", "getCurrentTab", "()I", "setCurrentTab", "(I)V", "dividerColor", "getDividerColor", "setDividerColor", "dividerPadding", "getDividerPadding", "()F", "setDividerPadding", "(F)V", "dividerWidth", "getDividerWidth", "setDividerWidth", "enableMaterial", "", "initScale", "isBackdropView", "tabSpaceEqual", "isTabSpaceEqual", "()Z", "setTabSpaceEqual", "(Z)V", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "mBarColor", "mBarStrokeColor", "mBarStrokeWidth", "mContainerViewId", "mContentRoot", "mContext", "mCurrentIndicatorHeight", "mCurrentP", "Lcom/obric/oui/segmentedtab/OBottomToolBar$IndicatorPoint;", "mCurrentTab", "mDividerColor", "mDividerPadding", "mDividerPaint", "mDividerWidth", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "mFragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mHeight", "mIndicatorMinHeightScale", "mInitSetMap", "Landroid/util/SparseArray;", "mInterpolator", "Landroid/view/animation/PathInterpolator;", "mIsFirstDraw", "mLastP", "mLastTab", "mListener", "Lcom/obric/oui/segmentedtab/OBottomToolBar$TabSelectListener;", "mPressedTab", "mRadiusArr", "", "mTabDrawables", "", "Landroid/graphics/drawable/Drawable;", "[Landroid/graphics/drawable/Drawable;", "mTabPadding", "mTabSpaceEqual", "mTabWidth", "mTabsContainer", "Landroid/widget/LinearLayout;", "mTextAllCaps", "mTextBold", "mTextPaint", "mTextSelectColor", "mTextUnselectColor", "mTextsize", "mTitles", "", "[Ljava/lang/String;", "mValueAnimator", "Landroid/animation/ValueAnimator;", "mVibrateOnTabSelected", "materialApplied", "materialSrcType", "pressAnim", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "pressScale", "releaseAnim", "shadowsNormal", "", "Lcom/obric/oui/common/style/Shadow;", "shadowsPressed", "<set-?>", "tabCount", "getTabCount", "tabList", "", "Landroid/view/View;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabPadding", "getTabPadding", "setTabPadding", "tabWidth", "getTabWidth", "setTabWidth", "textBold", "getTextBold", "setTextBold", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textSize", "textsize", "getTextsize", "setTextsize", "addTab", "", "position", "tabView", "applyContentMaterial", "apply", "calcOffset", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "doPressAnim", "pressed", "dp2px", "dp", "getCurrentFragment", "getTitleView", "Landroid/widget/TextView;", "tab", "hideMsg", "initFragments", "initShadows", "typedArray", "Landroid/content/res/TypedArray;", "isDarkTheme", "notifyDataSetChanged", "obtainAttributes", "onAnimationUpdate", "p0", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "refreshDimensionCache", "setBackdropTarget", "view", "setEnabled", "enabled", "setFragments", "index", "setImageSize", "width", "height", "setMsgMargin", "leftPadding", "bottomPadding", "setOnTabSelectListener", "listener", "setShadow", "setTabData", "titles", "fa", "Landroidx/fragment/app/FragmentActivity;", "containerViewId", "fragments", "([Ljava/lang/String;Landroidx/fragment/app/FragmentActivity;ILjava/util/ArrayList;)V", "setTabTitleAndDrawable", "drawables", "([Ljava/lang/String;[Landroid/graphics/drawable/Drawable;)V", "showDot", "showMsg", "num", "sp2px", "sp", "updateBackdropSrcType", "srcType", "updateBackdropTargetType", "updateLayoutForInsetBottom", "insetBottom", "updateTabSelection", "updateTabStyles", "applyBold", "Landroid/text/TextPaint;", "bold", "Companion", "IndicatorPoint", "PointEvaluator", "TabSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OBottomToolBar extends OUIFrameLayout implements ValueAnimator.AnimatorUpdateListener, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14426a = null;
    private ArrayList<Fragment> A;
    private final ValueAnimator B;
    private final PathInterpolator C;
    private final float[] D;
    private List<k> E;
    private List<k> F;
    private final Paint G;
    private final Paint H;
    private final RectF I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final RectF f14427J;
    private com.obric.common.oea.foundation.animation.d.d K;
    private com.obric.common.oea.foundation.animation.d.d L;
    private float M;
    private float N;
    private float O;
    private float P;
    private boolean Q;
    private boolean R;
    private int S;
    private float T;
    private List<View> U;
    private boolean V;
    private final Paint W;
    private final SparseArray<Boolean> aa;
    private d ab;
    private final b ac;
    private final b ad;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14428b;
    private final LinearLayout c;
    private OUIFrameLayout d;
    private int e;
    private int f;
    private int g;
    private int h;
    private final Paint i;
    private float j;
    private boolean k;
    private float l;
    private int m;
    private float n;
    private float o;
    private float p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private int u;
    private int v;
    private float w;
    private int x;
    private boolean y;
    private FragmentManager z;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomToolBar$Companion;", "", "()V", "TAB_ANIM_DURATION", "", "TEXT_BOLD_BOTH", "", "TEXT_BOLD_NONE", "TEXT_BOLD_WHEN_SELECT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomToolBar$IndicatorPoint;", "", "(Lcom/obric/oui/segmentedtab/OBottomToolBar;)V", "left", "", "getLeft", "()F", "setLeft", "(F)V", "right", "getRight", "setRight", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomToolBar f14429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f14430b;
        private float c;

        public b(OBottomToolBar r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.f14429a = r2;
        }

        public final float a() {
            return this.f14430b;
        }

        public final void a(float r1) {
            this.f14430b = r1;
        }

        public final float b() {
            return this.c;
        }

        public final void b(float r1) {
            this.c = r1;
        }

        public String toString() {
            return "(left = " + this.f14430b + ", right = " + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0002R\u00020\u00032\n\u0010\t\u001a\u00060\u0002R\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomToolBar$PointEvaluator;", "Landroid/animation/TypeEvaluator;", "Lcom/obric/oui/segmentedtab/OBottomToolBar$IndicatorPoint;", "Lcom/obric/oui/segmentedtab/OBottomToolBar;", "(Lcom/obric/oui/segmentedtab/OBottomToolBar;)V", "evaluate", "fraction", "", "startValue", "endValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class c implements TypeEvaluator<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBottomToolBar f14431a;

        public c(OBottomToolBar r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.f14431a = r2;
        }

        public b a(float r4, b r5, b r6) {
            Intrinsics.checkNotNullParameter(r5, "startValue");
            Intrinsics.checkNotNullParameter(r6, "endValue");
            float r0 = r5.a() + ((r6.a() - r5.a()) * r4);
            float r1 = r5.b() + (r4 * (r6.b() - r5.b()));
            b r7 = new b(this.f14431a);
            r7.a(r0);
            r7.b(r1);
            return r7;
        }

        @Override // android.animation.TypeEvaluator
        public /* synthetic */ b evaluate(float r3, b r4, b r5) {
            return a(r3, (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomToolBar$TabSelectListener;", "", "onReselect", "", "position", "", "onSelect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface d {
    }

    static {
        f14426a = new a(null);
    }

    public OBottomToolBar(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OBottomToolBar(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OBottomToolBar(Context r13, AttributeSet r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "context");
        super(r16, r17, r15, null, 8, null);
        this.f = -1;
        this.i = new Paint(1);
        this.C = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.D = new float[8];
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.FILL);
        this.G = r0;
        Paint r1 = new Paint(1);
        r1.setStyle(Paint.Style.STROKE);
        this.H = r1;
        this.I = new RectF();
        this.f14427J = new RectF();
        this.M = 0.988f;
        this.N = 0.01f;
        this.O = 1.0f;
        this.P = 0.85f;
        this.S = -1;
        this.U = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.V = true;
        this.W = new Paint(1);
        this.aa = new SparseArray();
        b r18 = new b(this);
        this.ac = r18;
        b r2 = new b(this);
        this.ad = r2;
        b();
        setWillNotDraw(false);
        if (l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")) == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.Q = r3;
        this.R = r3;
        setClipChildren(false);
        setClipToPadding(false);
        this.f14428b = ZeusTransformUtils.wrapperContext(r16, "com.obric.memorydata.plugin");
        this.c = new LinearLayout(r16);
        OUIFrameLayout r11 = new OUIFrameLayout(r16, null, 0, null, 14, null);
        this.d = r11;
        r11.setRadius(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 99));
        addView((View) ZeusTransformUtils.preCheckCast(this.d, View.class, "com.obric.memorydata.plugin"));
        a(r16, r17);
        Intrinsics.checkNotNull(r17);
        String r4 = r17.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (Intrinsics.areEqual(r4, StructuredDataId.RESERVED) == false) goto L12;
    L15:
        ValueAnimator r19 = ValueAnimator.ofObject((TypeEvaluator) ZeusTransformUtils.preCheckCast(new c(this), TypeEvaluator.class, "com.obric.memorydata.plugin"), new Object[]{r2, r18});
        Intrinsics.checkNotNullExpressionValue(r19, "ofObject(PointEvaluator(), mLastP, mCurrentP)");
        this.B = r19;
        r19.addUpdateListener((ValueAnimator.AnimatorUpdateListener) ZeusTransformUtils.preCheckCast(this, ValueAnimator.AnimatorUpdateListener.class, "com.obric.memorydata.plugin"));
        return;
    L12:
        if (Intrinsics.areEqual(r4, "-2") == true) goto L15;
        TypedArray r110 = r16.obtainStyledAttributes(r17, new int[]{R.attr.layout_height});
        Intrinsics.checkNotNullExpressionValue(r110, "context.obtainStyledAttributes(attrs, systemAttrs)");
        this.x = r110.getDimensionPixelSize(0, -2);
        r110.recycle();
        goto L15
    L5:
        if (OMaterialHelper.d() == false) goto L7;
        r3 = true;
        goto L8
    }

    public /* synthetic */ OBottomToolBar(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    private final int a(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this.f14428b, "com.obric.memorydata.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private static final WindowInsets a(OBottomToolBar r1, View r2, WindowInsets r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$noName_0");
        Intrinsics.checkNotNullParameter(r3, "insets");
        com.obric.oui.window.a r4 = com.obric.oui.window.a.f14878a;
        r1.a(com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), r3, true).e);
        return r3;
    }

    private final void a() {
        int r0 = this.h;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L26;
        int r3 = r2 + 1;
        View r4 = this.c.getChildAt(r2);
        float r5 = this.j;
        r4.setPadding((int) r5, 0, (int) r5, 0);
        View r6 = r4.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_title_small, OaidModel.KEY_ID, "tv_tab_title_small"));
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.TextView");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin");
        int r8 = this.e;
        if (r2 != r8) goto L7;
        boolean r10 = true;
    L8:
        if (r2 != r8) goto L10;
        int r9 = this.q;
    L11:
        r7.setTextColor(r9);
        r7.setTextSize(0, this.p);
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_icon_small, OaidModel.KEY_ID, "tv_tab_icon_small")), ImageView.class, "com.obric.memorydata.plugin");
        if (r2 != this.e) goto L14;
        int r12 = this.q;
    L15:
        r11.setImageTintList(ColorStateList.valueOf(r12));
        if (this.t == false) goto L18;
        String r13 = r7.getText().toString();
        Locale r14 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r14, "ROOT");
        String r15 = r13.toUpperCase(r14);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toUpperCase(locale)");
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"));
    L18:
        int r16 = this.s;
        if (r16 != 2) goto L21;
        TextPaint r17 = r7.getPaint();
        Intrinsics.checkNotNullExpressionValue(r17, "tvTabTitle.paint");
        a(r17, true);
    L25:
        r2 = r3;
        goto L3
    L21:
        if (r16 != 0) goto L23;
        TextPaint r18 = r7.getPaint();
        Intrinsics.checkNotNullExpressionValue(r18, "tvTabTitle.paint");
        a(r18, false);
        goto L25
    L23:
        if (r16 != 1) goto L25;
        TextPaint r19 = r7.getPaint();
        Intrinsics.checkNotNullExpressionValue(r19, "tvTabTitle.paint");
        a(r19, r10);
        goto L25
    L14:
        r12 = this.r;
        goto L15
    L10:
        r9 = this.r;
        goto L11
    L7:
        r10 = false;
        goto L8
    }

    private final void a(Context r6, TypedArray r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        List<k> r0 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_shadow_normal, "styleable", "OTabLayout_shadow_normal"));
        if (r0 != null) goto L5;
        r0 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_oui_widgetShadowNormal, "styleable", "OTabLayout_oui_widgetShadowNormal"));
    L5:
        if (r0 == null) goto L7;
        this.E = r0;
        Intrinsics.checkNotNull(r0);
        k r1 = (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r0, 0), k.class, "com.obric.memorydata.plugin");
        List<k> r3 = this.E;
        Intrinsics.checkNotNull(r3);
        a(r1, (k) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r3, 1), k.class, "com.obric.memorydata.plugin"));
    L7:
        List<k> r2 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_shadow_pressed, "styleable", "OTabLayout_shadow_pressed"));
        if (r2 != null) goto L10;
        r2 = f.a(r8, r7, ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_oui_widgetShadowPressed, "styleable", "OTabLayout_oui_widgetShadowPressed"));
    L10:
        if (r2 == null) goto L13;
        this.F = r2;
        return;
    }

    private final void a(Context r18, AttributeSet r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        TypedArray r3 = r1.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r19, AttributeSet.class, "com.obric.memorydata.plugin"), com.obric.memorydata.plugin.R.styleable.OTabLayout);
        Intrinsics.checkNotNullExpressionValue(r3, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.d.addView((View) ZeusTransformUtils.preCheckCast(this.c, View.class, "com.obric.memorydata.plugin"));
        this.n = r3.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_divider_width, "styleable", "OTabLayout_divider_width"), a(1.0f));
        this.o = r3.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_divider_padding, "styleable", "OTabLayout_divider_padding"), 0.0f);
        this.p = r3.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textSize, "styleable", "OTabLayout_tab_textSize"), b(12.0f));
        this.q = r3.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textSelectColor, "styleable", "OTabLayout_tab_textSelectColor"), this.f14428b.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.color.oui_text_1, TypedValues.Custom.S_COLOR, "oui_text_1")));
        this.r = r3.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textUnselectColor, "styleable", "OTabLayout_tab_textUnselectColor"), this.f14428b.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.color.oui_text_3b, TypedValues.Custom.S_COLOR, "oui_text_3b")));
        boolean r7 = false;
        this.s = r3.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textBold, "styleable", "OTabLayout_tab_textBold"), 0);
        this.t = r3.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textAllCaps, "styleable", "OTabLayout_tab_textAllCaps"), false);
        this.k = r3.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_space_equal, "styleable", "OTabLayout_tab_space_equal"), true);
        this.l = r3.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_width, "styleable", "OTabLayout_tab_width"), a(-1.0f));
        int r4 = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_padding, "styleable", "OTabLayout_tab_padding");
        if (this.k == false) goto L5;
    L8:
        int r9 = a(0.0f);
    L9:
        this.j = r3.getDimension(r4, r9);
        this.u = r3.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_bar_color, "styleable", "OTabLayout_bar_color"), -1);
        this.v = r3.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_bar_stroke_color, "styleable", "OTabLayout_bar_stroke_color"), this.u);
        this.w = r3.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_bar_stroke_width, "styleable", "OTabLayout_bar_stroke_width"), a(0.0f));
        this.y = r3.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_vibrate_on_tab_selected, "styleable", "OTabLayout_vibrate_on_tab_selected"), false);
        a(r1, r3);
        if (r3.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_oui_widgetFitInsetBottom, "styleable", "OTabLayout_oui_widgetFitInsetBottom"), true) == false) goto L13;
        com.obric.oui.window.a r2 = com.obric.oui.window.a.f14878a;
        a(com.obric.oui.window.a.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), null, true).e);
        setOnApplyWindowInsetsListener(new $$Lambda$OBottomToolBar$iHR0U3VltPSbb6aqJ3SlPROSMT8(this));
    L13:
        if (this.Q == false) goto L28;
        this.S = r3.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_oui_widgetMaterialSrcType, "styleable", "OTabLayout_oui_widgetMaterialSrcType"), -1);
        String r5 = r3.getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_oui_widgetMaterial, "styleable", "OTabLayout_oui_widgetMaterial"));
        if (r5 != null) goto L17;
        r5 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.string.oui_material_bg_floating, TypedValues.Custom.S_STRING, "oui_material_bg_floating"));
    L17:
        com.obric.oui.material.c[] r11 = MaterialToken.parseSet(r5, !i.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")));
        r3.recycle();
        if (r11 == null) goto L20;
        r7 = true;
    L20:
        this.Q = r7;
        this.R = r7;
        if (r7 == false) goto L28;
        if (r11 == null) goto L28;
        if (this.S == (-1)) goto L27;
        l.a((View) ZeusTransformUtils.preCheckCast(this.d, View.class, "com.obric.memorydata.plugin"), r11, false, this.S, null, 10, null);
        goto L28
    L27:
        l.a((View) ZeusTransformUtils.preCheckCast(this.d, View.class, "com.obric.memorydata.plugin"), r11, false, 0, null, 14, null);
    L28:
        setShadowCornerRadius(com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 99));
        return;
    L5:
        if (this.l > 0.0f) goto L8;
        r9 = a(10.0f);
        goto L9
    }

    private final void a(TextPaint r2, boolean r3) {
        if (r3 == false) goto L4;
        int r1 = TypedValues.TransitionType.TYPE_DURATION;
    L5:
        r2.setTypeface(Typeface.create(null, r1, false));
        return;
    L4:
        r1 = 400;
        goto L5
    }

    private final void a(boolean r5) {
        com.obric.common.oea.foundation.animation.d.d r0 = this.K;
        if (r0 == null) goto L6;
        com.obric.common.oea.foundation.animation.d.d.a(r0, false, 1, null);
    L6:
        com.obric.common.oea.foundation.animation.d.d r1 = this.L;
        if (r1 == null) goto L11;
        com.obric.common.oea.foundation.animation.d.d.a(r1, false, 1, null);
    L11:
        if (r5 == false) goto L13;
        this.K = com.obric.oui.common.style.l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), this.O, this.M, getCurrentShadows(), this.F);
        return;
    L13:
        this.L = com.obric.oui.common.style.l.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), this.M, this.O, getCurrentShadows(), this.E);
    }

    private final int b(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this.f14428b, "com.obric.memorydata.plugin").getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private final void b() {
        this.T = com.obric.oui.common.util.h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 99);
    }

    private final void c(int r12) {
        int r0 = this.h;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L25;
        int r3 = r2 + 1;
        View r4 = this.c.getChildAt(r2);
        if (r2 != r12) goto L7;
        boolean r5 = true;
    L8:
        View r6 = r4.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_title_small, OaidModel.KEY_ID, "tv_tab_title_small"));
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.TextView");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_icon_small, OaidModel.KEY_ID, "tv_tab_icon_small")), ImageView.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L11;
        int r9 = this.q;
    L12:
        r8.setImageTintList(ColorStateList.valueOf(r9));
        if (this.s != 1) goto L15;
        TextPaint r10 = r7.getPaint();
        Intrinsics.checkNotNullExpressionValue(r10, "tabTitle.paint");
        a(r10, r5);
        r7.invalidate();
    L15:
        com.obric.oui.c.c r11 = com.obric.oui.c.c.f13403a;
        if (r4 != null) goto L19;
    L17:
        r4 = null;
    L20:
        OSegmentTabMiniView r13 = (OSegmentTabMiniView) ZeusTransformUtils.preCheckCast(r4, OSegmentTabMiniView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L24;
        r13.a(r5);
    L24:
        r2 = r3;
        goto L3
    L19:
        if (ZeusTransformUtils.instanceOf(r4, OSegmentTabMiniView.class) == false) goto L17;
    L11:
        r9 = this.r;
        goto L12
    L7:
        r5 = false;
        goto L8
    }

    public static /* synthetic */ WindowInsets lambda$iHR0U3VltPSbb6aqJ3SlPROSMT8(OBottomToolBar r0, View r1, WindowInsets r2) {
        return a(r0, r1, r2);
    }

    private final void setFragments(int r8) {
        ArrayList<Fragment> r0 = this.A;
        if (r0 == null) goto L17;
        int r1 = 0;
        int r2 = r0.size();
    L6:
        if (r1 >= r2) goto L12;
        int r3 = r1 + 1;
        FragmentManager r4 = this.z;
        Intrinsics.checkNotNull(r4);
        FragmentTransaction r5 = r4.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r5, "mFragmentManager!!.beginTransaction()");
        ArrayList<Fragment> r6 = this.A;
        Intrinsics.checkNotNull(r6);
        Fragment r7 = r6.get(r1);
        Intrinsics.checkNotNullExpressionValue(r7, "mFragments!![i]");
        Fragment r9 = (Fragment) ZeusTransformUtils.preCheckCast(r7, Fragment.class, "com.obric.memorydata.plugin");
        if (r1 != r8) goto L10;
        r5.show(r9);
    L11:
        r5.commit();
        r1 = r3;
        goto L6
    L10:
        r5.hide(r9);
        goto L11
    L12:
        this.e = r8;
        return;
    }

    public final void a(int r3) {
        i.c((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), RangesKt.coerceAtLeast(0, r3));
    }

    @Override // com.obric.oui.material.h
    public void b(int r3) {
        this.S = r3;
        l.a((View) ZeusTransformUtils.preCheckCast(this.d, View.class, "com.obric.memorydata.plugin"), r3);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        int r0 = r3.getAction();
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L6;
    L8:
        a(false);
    L11:
        return super.dispatchTouchEvent(r3);
    L6:
        if (r0 == 3) goto L8;
    L9:
        a(true);
        goto L11
    }

    public final Fragment getCurrentFragment() {
        ArrayList<Fragment> r0 = this.A;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (Fragment) ZeusTransformUtils.preCheckCast(r0.get(this.e), Fragment.class, "com.obric.memorydata.plugin");
    }

    public final int getCurrentTab() {
        return this.e;
    }

    public final int getDividerColor() {
        return this.m;
    }

    public final float getDividerPadding() {
        return this.o;
    }

    public final float getDividerWidth() {
        return this.n;
    }

    public final int getTabCount() {
        return this.h;
    }

    public final List<View> getTabList() {
        return this.U;
    }

    public final float getTabPadding() {
        return this.j;
    }

    public final float getTabWidth() {
        return this.l;
    }

    public final int getTextBold() {
        return this.s;
    }

    public final int getTextSelectColor() {
        return this.q;
    }

    public final int getTextUnselectColor() {
        return this.r;
    }

    public final float getTextsize() {
        return this.p;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r1) {
        Intrinsics.checkNotNullParameter(r1, "p0");
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        b();
    }

    @Override // android.view.View
    public void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.h <= 0) goto L21;
        int r0 = getHeight();
        int r1 = getPaddingLeft();
        if (this.R == true) goto L11;
        this.G.setColor(this.u);
        this.I.set(0.0f, getPaddingTop(), getWidth(), r0 - getPaddingBottom());
        m.a(r13, this.I, this.T, this.G);
    L11:
        if (this.w <= 0.0f) goto L13;
        this.H.setColor(this.v);
        this.H.setStrokeWidth(this.w);
        float r5 = 2;
        this.f14427J.set(this.w / r5, getPaddingTop() + (this.w / r5), getWidth() - (this.w / r5), (r0 - getPaddingBottom()) - (this.w / r5));
    L13:
        float r2 = this.n;
        if (r2 <= 0.0f) goto L20;
        this.i.setStrokeWidth(r2);
        this.i.setColor(this.m);
        int r3 = 0;
        int r4 = this.h - 1;
    L16:
        if (r3 >= r4) goto L22;
        int r6 = r3 + 1;
        View r7 = this.c.getChildAt(r3);
        r13.drawLine(r7.getRight() + r1, this.o, r7.getRight() + r1, r0 - this.o, this.i);
        r3 = r6;
        goto L16
    L22:
        return;
    L20:
        return;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "state");
        if (ZeusTransformUtils.instanceOf(r5, Bundle.class) == false) goto L9;
        this.e = ((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin")).getInt("mCurrentTab");
        r5 = ((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin")).getParcelable("instanceState");
        if (this.e == 0) goto L9;
        if (this.c.getChildCount() <= 0) goto L9;
        c(this.e);
    L9:
        super.onRestoreInstanceState(r5);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putParcelable("instanceState", super.onSaveInstanceState());
        r0.putInt("mCurrentTab", this.e);
        return (Parcelable) ZeusTransformUtils.preCheckCast(r0, Parcelable.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.oui.material.h
    public void setBackdropTarget(View r3) {
        l.a((View) ZeusTransformUtils.preCheckCast(this.d, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setCurrentTab(int r2) {
        int r0 = this.e;
        if (r2 != r0) goto L5;
        return;
    L5:
        this.g = r0;
        this.e = r2;
        c(r2);
        setFragments(r2);
    }

    public final void setDividerColor(int r1) {
        this.m = r1;
        invalidate();
    }

    public final void setDividerPadding(float r1) {
        this.o = a(r1);
        invalidate();
    }

    public final void setDividerWidth(float r1) {
        this.n = a(r1);
        invalidate();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        Iterator<View> r3 = this.U.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.memorydata.plugin")).setEnabled(r4);
        goto L4
    }

    public final void setOnTabSelectListener(d r3) {
        this.ab = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    public final void setTabList(List<View> r3) {
        List<View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.U = r4;
    }

    public final void setTabPadding(float r1) {
        this.j = a(r1);
        a();
    }

    public final void setTabSpaceEqual(boolean r1) {
        this.k = r1;
        a();
    }

    public final void setTabWidth(float r1) {
        this.l = a(r1);
        a();
    }

    public final void setTextAllCaps(boolean r1) {
        this.t = r1;
        a();
    }

    public final void setTextBold(int r1) {
        this.s = r1;
        a();
    }

    public final void setTextSelectColor(int r1) {
        this.q = r1;
        a();
    }

    public final void setTextUnselectColor(int r1) {
        this.r = r1;
        a();
    }

    public final void setTextsize(float r1) {
        this.p = b(r1);
        a();
    }
}
