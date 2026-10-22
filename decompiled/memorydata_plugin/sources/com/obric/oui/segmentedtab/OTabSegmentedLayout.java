package com.obric.oui.segmentedtab;

import android.R;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.oui.common.style.m;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ì\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\nì\u0001í\u0001î\u0001ï\u0001ð\u0001B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001d\u0010\u009d\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\t2\b\u0010 \u0001\u001a\u00030\u0085\u0001H\u0003J\n\u0010¡\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010¢\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010£\u0001\u001a\u00030\u009e\u0001H\u0002J\u0012\u0010¤\u0001\u001a\u00020\t2\u0007\u0010¥\u0001\u001a\u00020\u001aH\u0002J\t\u0010¦\u0001\u001a\u0004\u0018\u00010TJ\u0011\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010\u009f\u0001\u001a\u00020\tJ\u0011\u0010©\u0001\u001a\u00030ª\u00012\u0007\u0010«\u0001\u001a\u00020\tJ\u0011\u0010¬\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\tJ\n\u0010\u00ad\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010®\u0001\u001a\u00030\u009e\u0001H\u0002J\u001c\u0010¯\u0001\u001a\u00030\u009e\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010°\u0001\u001a\u00030\u009e\u00012\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\u0014\u0010³\u0001\u001a\u00030\u009e\u00012\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\u0014\u0010´\u0001\u001a\u00030\u009e\u00012\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\u0014\u0010µ\u0001\u001a\u00030\u009e\u00012\b\u0010±\u0001\u001a\u00030²\u0001H\u0016J\u0013\u0010¶\u0001\u001a\u00030\u009e\u00012\u0007\u0010±\u0001\u001a\u00020\u007fH\u0016J\u0016\u0010·\u0001\u001a\u00030\u009e\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0014J\u0014\u0010º\u0001\u001a\u00030\u009e\u00012\b\u0010»\u0001\u001a\u00030¼\u0001H\u0014J7\u0010½\u0001\u001a\u00030\u009e\u00012\u0007\u0010¾\u0001\u001a\u0002082\u0007\u0010¿\u0001\u001a\u00020\t2\u0007\u0010À\u0001\u001a\u00020\t2\u0007\u0010Á\u0001\u001a\u00020\t2\u0007\u0010Â\u0001\u001a\u00020\tH\u0014J\u001c\u0010Ã\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ä\u0001\u001a\u00020\t2\u0007\u0010Å\u0001\u001a\u00020\tH\u0014J\u0014\u0010Æ\u0001\u001a\u00030\u009e\u00012\b\u0010Ç\u0001\u001a\u00030È\u0001H\u0014J\f\u0010É\u0001\u001a\u0005\u0018\u00010È\u0001H\u0014J\n\u0010Ê\u0001\u001a\u00030\u009e\u0001H\u0002J\u0013\u0010Ë\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ì\u0001\u001a\u000208H\u0016J\u0013\u0010Í\u0001\u001a\u00030\u009e\u00012\u0007\u0010Î\u0001\u001a\u00020\tH\u0002J\u001a\u0010Ï\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ð\u0001\u001a\u00020\t2\u0007\u0010Ñ\u0001\u001a\u00020\tJ%\u0010Ò\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\t2\u0007\u0010Ó\u0001\u001a\u00020\u001a2\u0007\u0010Ô\u0001\u001a\u00020\u001aH\u0002J\u0013\u0010Õ\u0001\u001a\u00030\u009e\u00012\t\u0010Ö\u0001\u001a\u0004\u0018\u00010kJ\u0013\u0010×\u0001\u001a\u00030\u009e\u00012\t\u0010Ö\u0001\u001a\u0004\u0018\u00010fJO\u0010Ø\u0001\u001a\u00030\u009e\u00012\u000f\u0010Ù\u0001\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010m2\b\u0010Ú\u0001\u001a\u00030Û\u00012\u0007\u0010Ü\u0001\u001a\u00020\t2\u001b\u0010Ý\u0001\u001a\u0016\u0012\u0004\u0012\u00020T\u0018\u00010Sj\n\u0012\u0004\u0012\u00020T\u0018\u0001`U¢\u0006\u0003\u0010Þ\u0001J0\u0010ß\u0001\u001a\u00030\u009e\u00012\u000f\u0010Ù\u0001\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010m2\u000f\u0010à\u0001\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010m¢\u0006\u0003\u0010á\u0001J\u0011\u0010â\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\tJ\u001c\u0010ã\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\t2\u0007\u0010ä\u0001\u001a\u00020\tH\u0002J\u0012\u0010å\u0001\u001a\u00020\t2\u0007\u0010æ\u0001\u001a\u00020\u001aH\u0002J\u0013\u0010ç\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\tH\u0002J\n\u0010è\u0001\u001a\u00030\u009e\u0001H\u0002J\u0018\u0010é\u0001\u001a\u00030\u009e\u0001*\u00030ê\u00012\u0007\u0010ë\u0001\u001a\u000208H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R$\u0010+\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR$\u0010.\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\u000e\u00101\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001cR\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R$\u0010?\u001a\u0002082\u0006\u0010>\u001a\u0002088F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u00109\"\u0004\b@\u0010;R$\u0010B\u001a\u0002082\u0006\u0010A\u001a\u0002088F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u00109\"\u0004\bC\u0010;R\u000e\u0010D\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010I\u001a\u00060JR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010R\u001a\u0016\u0012\u0004\u0012\u00020T\u0018\u00010Sj\n\u0012\u0004\u0012\u00020T\u0018\u0001`UX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\\X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080_X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010c\u001a\u00060JR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020iX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010l\u001a\n\u0012\u0004\u0012\u00020n\u0018\u00010mX\u0082\u000e¢\u0006\u0004\n\u0002\u0010oR\u000e\u0010p\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010v\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010{\u001a\n\u0012\u0004\u0012\u00020|\u0018\u00010mX\u0082\u000e¢\u0006\u0004\n\u0002\u0010}R\u000e\u0010~\u001a\u00020\u007fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0081\u0001\u001a\u00020\t2\u0006\u00104\u001a\u00020\t@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0013R'\u0010\u0083\u0001\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010\u0084\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R(\u0010\u008a\u0001\u001a\u00020\u001a2\u0007\u0010\u008a\u0001\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008b\u0001\u0010\u001c\"\u0005\b\u008c\u0001\u0010\u001eR(\u0010\u008d\u0001\u001a\u00020\u001a2\u0007\u0010\u008d\u0001\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u008e\u0001\u0010\u001c\"\u0005\b\u008f\u0001\u0010\u001eR(\u0010\u0090\u0001\u001a\u00020\t2\u0007\u0010\u0090\u0001\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0091\u0001\u0010\u0013\"\u0005\b\u0092\u0001\u0010\u0015R(\u0010\u0093\u0001\u001a\u00020\t2\u0007\u0010\u0093\u0001\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0094\u0001\u0010\u0013\"\u0005\b\u0095\u0001\u0010\u0015R(\u0010\u0096\u0001\u001a\u00020\t2\u0007\u0010\u0096\u0001\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u0097\u0001\u0010\u0013\"\u0005\b\u0098\u0001\u0010\u0015R(\u0010\u009a\u0001\u001a\u00020\u001a2\u0007\u0010\u0099\u0001\u001a\u00020\u001a8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\b\u009b\u0001\u0010\u001c\"\u0005\b\u009c\u0001\u0010\u001e¨\u0006ñ\u0001"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;", "Landroid/widget/FrameLayout;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/Animator$AnimatorListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barPaint", "Landroid/graphics/Paint;", "barRectF", "Landroid/graphics/RectF;", "barStrokePaint", "barStrokeRectF", "currentTab", "getCurrentTab", "()I", "setCurrentTab", "(I)V", "dividerColor", "getDividerColor", "setDividerColor", "dividerPadding", "", "getDividerPadding", "()F", "setDividerPadding", "(F)V", "dividerWidth", "getDividerWidth", "setDividerWidth", "indicatorAnimDuration", "", "getIndicatorAnimDuration", "()J", "setIndicatorAnimDuration", "(J)V", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "indicatorCornerRadius", "getIndicatorCornerRadius", "setIndicatorCornerRadius", "indicatorHeight", "getIndicatorHeight", "setIndicatorHeight", "indicatorShadowDxPx", "indicatorShadowDyPx", "indicatorShadowRadiusPx", "<set-?>", "indicatorSpacing", "getIndicatorSpacing", "isIndicatorAnimEnable", "", "()Z", "setIndicatorAnimEnable", "(Z)V", "isIndicatorBounceEnable", "setIndicatorBounceEnable", "tabSpaceEqual", "isTabSpaceEqual", "setTabSpaceEqual", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "mBarColor", "mBarStrokeColor", "mBarStrokeWidth", "mContainerViewId", "mContext", "mCurrentP", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$IndicatorPoint;", "mCurrentTab", "mDividerColor", "mDividerPadding", "mDividerPaint", "mDividerWidth", "mFragmentManager", "Landroidx/fragment/app/FragmentManager;", "mFragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mHeight", "mIndicatorColor", "mIndicatorCornerRadius", "mIndicatorHeight", "mIndicatorPaint", "mIndicatorPressedRect", "Landroid/graphics/Rect;", "mIndicatorRect", "mInitSetMap", "Landroid/util/SparseArray;", "mInterpolator", "Landroid/view/animation/PathInterpolator;", "mIsFirstDraw", "mLastP", "mLastTab", "mListener", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectListener;", "mPressedTab", "mRadiusArr", "", "mSelectAnimListener", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectAnimListener;", "mTabDrawables", "", "Landroid/graphics/drawable/Drawable;", "[Landroid/graphics/drawable/Drawable;", "mTabPadding", "mTabSpaceEqual", "mTabWidth", "mTabsContainer", "Landroid/widget/LinearLayout;", "mTextAllCaps", "mTextBold", "mTextPaint", "mTextSelectColor", "mTextUnselectColor", "mTextsize", "mTitles", "", "[Ljava/lang/String;", "mValueAnimator", "Landroid/animation/ValueAnimator;", "mVibrateOnTabSelected", "tabCount", "getTabCount", "tabList", "", "Landroid/view/View;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabPadding", "getTabPadding", "setTabPadding", "tabWidth", "getTabWidth", "setTabWidth", "textBold", "getTextBold", "setTextBold", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textSize", "textsize", "getTextsize", "setTextsize", "addTab", "", "position", "tabView", "calcIndicatorPressedRect", "calcIndicatorRect", "calcOffset", "dp2px", "dp", "getCurrentFragment", "getMsgView", "Lcom/obric/oui/segmentedtab/UnReadMsgView;", "getTitleView", "Landroid/widget/TextView;", "tab", "hideMsg", "initFragments", "notifyDataSetChanged", "obtainAttributes", "onAnimationCancel", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onAnimationUpdate", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "refreshDimensionCache", "setEnabled", "enabled", "setFragments", "index", "setImageSize", "width", "height", "setMsgMargin", "leftPadding", "bottomPadding", "setOnTabSelectAnimListener", "listener", "setOnTabSelectListener", "setTabData", "titles", "fa", "Landroidx/fragment/app/FragmentActivity;", "containerViewId", "fragments", "([Ljava/lang/String;Landroidx/fragment/app/FragmentActivity;ILjava/util/ArrayList;)V", "setTabTitleAndDrawable", "drawables", "([Ljava/lang/String;[Landroid/graphics/drawable/Drawable;)V", "showDot", "showMsg", "num", "sp2px", "sp", "updateTabSelection", "updateTabStyles", "applyBold", "Landroid/text/TextPaint;", "bold", "Companion", "IndicatorPoint", "PointEvaluator", "TabSelectAnimListener", "TabSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTabSegmentedLayout extends FrameLayout implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14434a = null;
    private int A;
    private int B;
    private boolean C;
    private int D;
    private int E;
    private float F;
    private int G;
    private boolean H;
    private float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private float f14435J;
    private float K;
    private FragmentManager L;
    private ArrayList<Fragment> M;
    private final ValueAnimator N;
    private final PathInterpolator O;
    private final float[] P;
    private final Paint Q;
    private final Paint R;
    private final RectF S;
    private final RectF T;
    private List<View> U;
    private boolean V;
    private final Paint W;
    private final SparseArray<Boolean> aa;
    private e ab;
    private d ac;
    private final b ad;
    private final b ae;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14436b;
    private final LinearLayout c;
    private int d;
    private int e;
    private int f;
    private int g;
    private final Rect h;
    private final Rect i;
    private final Paint j;
    private final Paint k;
    private float l;
    private boolean m;
    private float n;
    private int o;
    private float p;
    private float q;
    private float r;
    private long s;
    private boolean t;
    private boolean u;
    private int v;
    private float w;
    private float x;
    private float y;
    private int z;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$Companion;", "", "()V", "TAB_ANIM_DURATION", "", "TAG", "", "TEXT_BOLD_BOTH", "", "TEXT_BOLD_NONE", "TEXT_BOLD_WHEN_SELECT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$IndicatorPoint;", "", "(Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;)V", "left", "", "getLeft", "()F", "setLeft", "(F)V", "right", "getRight", "setRight", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabSegmentedLayout f14437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f14438b;
        private float c;

        public b(OTabSegmentedLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.f14437a = r2;
        }

        public final float a() {
            return this.f14438b;
        }

        public final void a(float r1) {
            this.f14438b = r1;
        }

        public final float b() {
            return this.c;
        }

        public final void b(float r1) {
            this.c = r1;
        }

        public String toString() {
            return "(left = " + this.f14438b + ", right = " + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\u0002R\u00020\u00032\n\u0010\t\u001a\u00060\u0002R\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$PointEvaluator;", "Landroid/animation/TypeEvaluator;", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$IndicatorPoint;", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;", "(Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;)V", "evaluate", "fraction", "", "startValue", "endValue", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class c implements TypeEvaluator<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OTabSegmentedLayout f14439a;

        public c(OTabSegmentedLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "this$0");
            this.f14439a = r2;
        }

        public b a(float r4, b r5, b r6) {
            Intrinsics.checkNotNullParameter(r5, "startValue");
            Intrinsics.checkNotNullParameter(r6, "endValue");
            float r0 = r5.a() + ((r6.a() - r5.a()) * r4);
            float r1 = r5.b() + (r4 * (r6.b() - r5.b()));
            b r7 = new b(this.f14439a);
            r7.a(r0);
            r7.b(r1);
            return r7;
        }

        @Override // android.animation.TypeEvaluator
        public /* synthetic */ b evaluate(float r3, b r4, b r5) {
            return a(r3, (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectAnimListener;", "", "onSelectAnimCancel", "", "onSelectAnimEnd", "onSelectAnimStart", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface d {
        void a();

        void b();

        void c();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$TabSelectListener;", "", "onReselect", "", "position", "", "onSelect", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface e {
    }

    static {
        f14434a = new a(null);
    }

    public OTabSegmentedLayout(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OTabSegmentedLayout(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OTabSegmentedLayout(Context r7, AttributeSet r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r9);
        this.e = -1;
        this.h = new Rect();
        this.i = new Rect();
        this.j = new Paint();
        this.k = new Paint(1);
        this.s = 350;
        this.t = true;
        this.H = true;
        this.O = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.P = new float[8];
        Paint r12 = new Paint(1);
        r12.setStyle(Paint.Style.FILL);
        this.Q = r12;
        Paint r13 = new Paint(1);
        r13.setStyle(Paint.Style.STROKE);
        this.R = r13;
        this.S = new RectF();
        this.T = new RectF();
        this.U = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.V = true;
        this.W = new Paint(1);
        this.aa = new SparseArray();
        b r14 = new b(this);
        this.ad = r14;
        b r2 = new b(this);
        this.ae = r2;
        e();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f14436b = ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin");
        LinearLayout r4 = new LinearLayout(r10);
        this.c = r4;
        addView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
        a(r10, r11);
        Intrinsics.checkNotNull(r11);
        String r5 = r11.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (Intrinsics.areEqual(r5, StructuredDataId.RESERVED) == false) goto L6;
    L9:
        ValueAnimator r15 = ValueAnimator.ofObject((TypeEvaluator) ZeusTransformUtils.preCheckCast(new c(this), TypeEvaluator.class, "com.obric.memorydata.plugin"), new Object[]{r2, r14});
        Intrinsics.checkNotNullExpressionValue(r15, "ofObject(PointEvaluator(), mLastP, mCurrentP)");
        this.N = r15;
        r15.addUpdateListener((ValueAnimator.AnimatorUpdateListener) ZeusTransformUtils.preCheckCast(this, ValueAnimator.AnimatorUpdateListener.class, "com.obric.memorydata.plugin"));
        r15.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(this, Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        if (Intrinsics.areEqual(r5, "-2") == true) goto L9;
        TypedArray r16 = r10.obtainStyledAttributes(r11, new int[]{R.attr.layout_height});
        Intrinsics.checkNotNullExpressionValue(r16, "context.obtainStyledAttributes(attrs, systemAttrs)");
        this.G = r16.getDimensionPixelSize(0, -2);
        r16.recycle();
        goto L9
    }

    public /* synthetic */ OTabSegmentedLayout(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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
        return (int) ((r2 * ZeusTransformUtils.getResources(this.f14436b, "com.obric.memorydata.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private final void a() {
        int r0 = this.g;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L26;
        int r3 = r2 + 1;
        View r4 = this.c.getChildAt(r2);
        float r5 = this.l;
        r4.setPadding((int) r5, 0, (int) r5, 0);
        View r6 = r4.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_title, OaidModel.KEY_ID, "tv_tab_title"));
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.TextView");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin");
        int r8 = this.d;
        if (r2 != r8) goto L7;
        boolean r10 = true;
    L8:
        if (r2 != r8) goto L10;
        int r9 = this.z;
    L11:
        r7.setTextColor(r9);
        r7.setTextSize(0, this.y);
        ImageView r11 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_icon, OaidModel.KEY_ID, "tv_tab_icon")), ImageView.class, "com.obric.memorydata.plugin");
        if (r2 != this.d) goto L14;
        int r12 = this.z;
    L15:
        r11.setImageTintList(ColorStateList.valueOf(r12));
        if (this.C == false) goto L18;
        String r13 = r7.getText().toString();
        Locale r14 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(r14, "ROOT");
        String r15 = r13.toUpperCase(r14);
        Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String).toUpperCase(locale)");
        r7.setText((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.memorydata.plugin"));
    L18:
        int r16 = this.B;
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
        r12 = this.A;
        goto L15
    L10:
        r9 = this.A;
        goto L11
    L7:
        r10 = false;
        goto L8
    }

    private final void a(int r12) {
        int r0 = this.g;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L25;
        int r3 = r2 + 1;
        View r4 = this.c.getChildAt(r2);
        if (r2 != r12) goto L7;
        boolean r5 = true;
    L8:
        View r6 = r4.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_title, OaidModel.KEY_ID, "tv_tab_title"));
        Objects.requireNonNull(r6, "null cannot be cast to non-null type android.widget.TextView");
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.memorydata.plugin");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r4.findViewById(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.id.tv_tab_icon, OaidModel.KEY_ID, "tv_tab_icon")), ImageView.class, "com.obric.memorydata.plugin");
        if (r5 == false) goto L11;
        int r9 = this.z;
    L12:
        r8.setImageTintList(ColorStateList.valueOf(r9));
        if (this.B != 1) goto L15;
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
        OSegmentTabView r13 = (OSegmentTabView) ZeusTransformUtils.preCheckCast(r4, OSegmentTabView.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L24;
        r13.a(r5);
    L24:
        r2 = r3;
        goto L3
    L19:
        if (ZeusTransformUtils.instanceOf(r4, OSegmentTabView.class) == false) goto L17;
    L11:
        r9 = this.A;
        goto L12
    L7:
        r5 = false;
        goto L8
    }

    private final void a(Context r7, AttributeSet r8) {
        TypedArray r9 = ((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin"), com.obric.memorydata.plugin.R.styleable.OTabLayout);
        Intrinsics.checkNotNullExpressionValue(r9, "context.obtainStyledAttr…, R.styleable.OTabLayout)");
        this.o = r9.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_color, "styleable", "OTabLayout_indicator_color"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.color.oui_fill_seg_selected, TypedValues.Custom.S_COLOR, "oui_fill_seg_selected")));
        this.p = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_height, "styleable", "OTabLayout_indicator_height"), -1.0f);
        this.q = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_corner_radius, "styleable", "OTabLayout_indicator_corner_radius"), -1.0f);
        this.r = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_spacing, "styleable", "OTabLayout_indicator_spacing"), a(4.0f));
        LinearLayout r10 = this.c;
        int r2 = (int) (getIndicatorSpacing() / 2);
        r10.setPadding(r2, 0, r2, 0);
        this.t = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_anim_enable, "styleable", "OTabLayout_indicator_anim_enable"), false);
        this.u = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_indicator_bounce_enable, "styleable", "OTabLayout_indicator_bounce_enable"), true);
        this.v = r9.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_divider_color, "styleable", "OTabLayout_divider_color"), this.o);
        this.w = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_divider_width, "styleable", "OTabLayout_divider_width"), a(1.0f));
        this.x = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_divider_padding, "styleable", "OTabLayout_divider_padding"), 0.0f);
        this.y = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textSize, "styleable", "OTabLayout_tab_textSize"), b(13.0f));
        this.z = r9.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textSelectColor, "styleable", "OTabLayout_tab_textSelectColor"), Color.parseColor("#ffffff"));
        this.A = r9.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textUnselectColor, "styleable", "OTabLayout_tab_textUnselectColor"), this.o);
        this.B = r9.getInt(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textBold, "styleable", "OTabLayout_tab_textBold"), 0);
        this.C = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_textAllCaps, "styleable", "OTabLayout_tab_textAllCaps"), false);
        this.m = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_space_equal, "styleable", "OTabLayout_tab_space_equal"), true);
        this.n = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_width, "styleable", "OTabLayout_tab_width"), a(-1.0f));
        int r11 = ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_tab_padding, "styleable", "OTabLayout_tab_padding");
        if (this.m == false) goto L5;
    L8:
        int r1 = a(0.0f);
    L9:
        this.l = r9.getDimension(r11, r1);
        this.D = r9.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_bar_color, "styleable", "OTabLayout_bar_color"), 0);
        this.E = r9.getColor(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_bar_stroke_color, "styleable", "OTabLayout_bar_stroke_color"), this.D);
        this.F = r9.getDimension(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_bar_stroke_width, "styleable", "OTabLayout_bar_stroke_width"), a(0.0f));
        this.H = r9.getBoolean(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.styleable.OTabLayout_vibrate_on_tab_selected, "styleable", "OTabLayout_vibrate_on_tab_selected"), true);
        r9.recycle();
        return;
    L5:
        if (this.n > 0.0f) goto L8;
        r1 = a(10.0f);
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

    private final int b(float r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this.f14436b, "com.obric.memorydata.plugin").getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private final void b() {
        View r0 = this.c.getChildAt(this.d);
        this.ad.a(r0.getLeft());
        this.ad.b(r0.getRight());
        View r1 = this.c.getChildAt(this.f);
        this.ae.a(r1.getLeft());
        this.ae.b(r1.getRight());
        if (this.ae.a() != this.ad.a()) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L13:
        this.N.setObjectValues(new Object[]{this.ae, this.ad});
        if (this.u == false) goto L16;
        this.N.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(this.O, TimeInterpolator.class, "com.obric.memorydata.plugin"));
    L16:
        this.N.setDuration(350);
        this.N.start();
        return;
    L8:
        if (this.ae.b() != this.ad.b()) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        invalidate();
        return;
    L10:
        r3 = false;
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    private final void c() {
        View r0 = this.c.getChildAt(this.d);
        float r1 = r0.getLeft();
        float r2 = r0.getRight();
        this.h.left = (int) r1;
        this.h.right = (int) r2;
        if (this.t == true) goto L11;
        int r3 = this.d;
        if (r3 != 0) goto L8;
        float[] r4 = this.P;
        float r11 = this.q;
        r4[0] = r11;
        r4[1] = r11;
        r4[2] = 0.0f;
        r4[3] = 0.0f;
        r4[4] = 0.0f;
        r4[5] = 0.0f;
        r4[6] = r11;
        r4[7] = r11;
        return;
    L8:
        if (r3 != (this.g - 1)) goto L10;
        float[] r5 = this.P;
        r5[0] = 0.0f;
        r5[1] = 0.0f;
        float r12 = this.q;
        r5[2] = r12;
        r5[3] = r12;
        r5[4] = r12;
        r5[5] = r12;
        r5[6] = 0.0f;
        r5[7] = 0.0f;
        return;
    L10:
        float[] r13 = this.P;
        r13[0] = 0.0f;
        r13[1] = 0.0f;
        r13[2] = 0.0f;
        r13[3] = 0.0f;
        r13[4] = 0.0f;
        r13[5] = 0.0f;
        r13[6] = 0.0f;
        r13[7] = 0.0f;
        return;
    L11:
        float[] r6 = this.P;
        float r14 = this.q;
        r6[0] = r14;
        r6[1] = r14;
        r6[2] = r14;
        r6[3] = r14;
        r6[4] = r14;
        r6[5] = r14;
        r6[6] = r14;
        r6[7] = r14;
    }

    private final void d() {
        int r0 = this.e;
        if (r0 == (-1)) goto L5;
        View r1 = this.c.getChildAt(r0);
    L6:
        if (r1 == null) goto L10;
        Rect r2 = this.i;
        r2.left = r1.getLeft();
        Rect r3 = this.i;
        r3.right = r1.getRight();
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void e() {
        this.I = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 10);
        this.f14435J = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0);
        this.K = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
    }

    private final void setFragments(int r8) {
        ArrayList<Fragment> r0 = this.M;
        if (r0 == null) goto L17;
        int r1 = 0;
        int r2 = r0.size();
    L6:
        if (r1 >= r2) goto L12;
        int r3 = r1 + 1;
        FragmentManager r4 = this.L;
        Intrinsics.checkNotNull(r4);
        FragmentTransaction r5 = r4.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r5, "mFragmentManager!!.beginTransaction()");
        ArrayList<Fragment> r6 = this.M;
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
        this.d = r8;
        return;
    }

    public final Fragment getCurrentFragment() {
        ArrayList<Fragment> r0 = this.M;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (Fragment) ZeusTransformUtils.preCheckCast(r0.get(this.d), Fragment.class, "com.obric.memorydata.plugin");
    }

    public final int getCurrentTab() {
        return this.d;
    }

    public final int getDividerColor() {
        return this.v;
    }

    public final float getDividerPadding() {
        return this.x;
    }

    public final float getDividerWidth() {
        return this.w;
    }

    public final long getIndicatorAnimDuration() {
        return this.s;
    }

    public final int getIndicatorColor() {
        return this.o;
    }

    public final float getIndicatorCornerRadius() {
        return this.q;
    }

    public final float getIndicatorHeight() {
        return this.p;
    }

    public final float getIndicatorSpacing() {
        return this.r;
    }

    public final int getTabCount() {
        return this.g;
    }

    public final List<View> getTabList() {
        return this.U;
    }

    public final float getTabPadding() {
        return this.l;
    }

    public final float getTabWidth() {
        return this.n;
    }

    public final int getTextBold() {
        return this.B;
    }

    public final int getTextSelectColor() {
        return this.z;
    }

    public final int getTextUnselectColor() {
        return this.A;
    }

    public final float getTextsize() {
        return this.y;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        d r1 = this.ac;
        if (r1 == null) goto L7;
        r1.c();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        d r1 = this.ac;
        if (r1 == null) goto L7;
        r1.b();
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
        Intrinsics.checkNotNullParameter(r1, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        d r1 = this.ac;
        if (r1 == null) goto L7;
        r1.a();
        return;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        Object r4 = r3.getAnimatedValue();
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.segmentedtab.OTabSegmentedLayout.IndicatorPoint");
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin");
        Rect r0 = this.h;
        r0.left = (int) r5.a();
        Rect r1 = this.h;
        r1.right = (int) r5.b();
        invalidate();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        e();
    }

    @Override // android.view.View
    public void onDraw(Canvas r15) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        super.onDraw(r15);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.g <= 0) goto L35;
        int r0 = getHeight();
        int r1 = getPaddingLeft();
        if (this.p >= 0.0f) goto L10;
        this.p = r0 - (this.r * 2);
    L10:
        float r2 = this.q;
        if (r2 >= 0.0f) goto L13;
    L14:
        this.q = this.p;
    L15:
        this.Q.setColor(this.D);
        this.S.set(0.0f, getPaddingTop(), getWidth(), r0 - getPaddingBottom());
        float r4 = 2;
        float r3 = this.q + (this.r / r4);
        m.a(r15, this.S, r3, this.Q);
        if (this.F <= 0.0f) goto L19;
        this.R.setColor(this.E);
        this.R.setStrokeWidth(this.F);
        this.T.set(this.F / r4, getPaddingTop() + (this.F / r4), getWidth() - (this.F / r4), (r0 - getPaddingBottom()) - (this.F / r4));
        m.a(r15, this.T, r3, this.R);
    L19:
        if (this.t == true) goto L26;
        float r5 = this.w;
        if (r5 <= 0.0f) goto L26;
        this.k.setStrokeWidth(r5);
        this.k.setColor(this.v);
        int r6 = this.g - 1;
        int r7 = 0;
    L23:
        if (r7 >= r6) goto L26;
        int r8 = r7 + 1;
        View r9 = this.c.getChildAt(r7);
        r15.drawLine(r9.getRight() + r1, this.x, r9.getRight() + r1, r0 - this.x, this.k);
        r7 = r8;
    L26:
        if (this.t == true) goto L28;
    L30:
        c();
    L31:
        d();
        float r10 = (this.r / r4) + this.F;
        Paint r11 = this.j;
        r11.setColor(this.o);
        r11.setShadowLayer(this.I, this.f14435J, this.K, ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.color.TabSegmentedShadowColor, TypedValues.Custom.S_COLOR, "TabSegmentedShadowColor")));
        m.a(r15, (r1 + r10) + this.h.left, this.r + this.F, (r1 + this.h.right) - r10, (this.r + this.p) - this.F, this.q, this.j);
        return;
    L28:
        if (this.V == false) goto L31;
        this.V = false;
        goto L30
    L13:
        if (r2 <= (this.p / 2)) goto L15;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "state");
        if (ZeusTransformUtils.instanceOf(r5, Bundle.class) == false) goto L9;
        this.d = ((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin")).getInt("mCurrentTab");
        r5 = ((Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin")).getParcelable("instanceState");
        if (this.d == 0) goto L9;
        if (this.c.getChildCount() <= 0) goto L9;
        a(this.d);
    L9:
        super.onRestoreInstanceState(r5);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle r0 = new Bundle();
        r0.putParcelable("instanceState", super.onSaveInstanceState());
        r0.putInt("mCurrentTab", this.d);
        return (Parcelable) ZeusTransformUtils.preCheckCast(r0, Parcelable.class, "com.obric.memorydata.plugin");
    }

    public final void setCurrentTab(int r3) {
        int r0 = this.d;
        if (r3 != r0) goto L5;
        return;
    L5:
        this.V = true;
        this.f = r0;
        this.d = r3;
        Log.d("OTabSegmentedLayout", "setCurrentTab, currentTab: " + r3 + ", lastTab: " + this.f);
        a(r3);
        setFragments(r3);
        if (this.t == false) goto L8;
        b();
        return;
    L8:
        invalidate();
    }

    public final void setDividerColor(int r1) {
        this.v = r1;
        invalidate();
    }

    public final void setDividerPadding(float r1) {
        this.x = a(r1);
        invalidate();
    }

    public final void setDividerWidth(float r1) {
        this.w = a(r1);
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean r4) {
        super.setEnabled(r4);
        Iterator<View> r3 = this.U.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((View) ZeusTransformUtils.preCheckCast(r3.next(), View.class, "com.obric.memorydata.plugin")).setEnabled(r4);
        goto L4
    }

    public final void setIndicatorAnimDuration(long r1) {
        this.s = r1;
    }

    public final void setIndicatorAnimEnable(boolean r1) {
        this.t = r1;
    }

    public final void setIndicatorBounceEnable(boolean r1) {
        this.u = r1;
    }

    public final void setIndicatorColor(int r1) {
        this.o = r1;
        invalidate();
    }

    public final void setIndicatorCornerRadius(float r1) {
        this.q = a(r1);
        invalidate();
    }

    public final void setIndicatorHeight(float r1) {
        this.p = a(r1);
        invalidate();
    }

    public final void setOnTabSelectAnimListener(d r3) {
        this.ac = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    public final void setOnTabSelectListener(e r3) {
        this.ab = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
    }

    public final void setTabList(List<View> r3) {
        List<View> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.U = r4;
    }

    public final void setTabPadding(float r1) {
        this.l = a(r1);
        a();
    }

    public final void setTabSpaceEqual(boolean r1) {
        this.m = r1;
        a();
    }

    public final void setTabWidth(float r1) {
        this.n = a(r1);
        a();
    }

    public final void setTextAllCaps(boolean r1) {
        this.C = r1;
        a();
    }

    public final void setTextBold(int r1) {
        this.B = r1;
        a();
    }

    public final void setTextSelectColor(int r1) {
        this.z = r1;
        a();
    }

    public final void setTextUnselectColor(int r1) {
        this.A = r1;
        a();
    }

    public final void setTextsize(float r1) {
        this.y = b(r1);
        a();
    }
}
