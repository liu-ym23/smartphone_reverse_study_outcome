package com.obric.oui.forms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.common.util.o;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 Þ\u00012\u00020\u0001:\nÞ\u0001ß\u0001à\u0001á\u0001â\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\J\u0010\u0010]\u001a\u00020Z2\u0006\u0010^\u001a\u00020\u0014H\u0002J \u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020)H\u0002J\u0012\u0010c\u001a\u00020\n2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\u0012\u0010f\u001a\u00020Z2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0006\u0010i\u001a\u00020ZJ\u0006\u0010j\u001a\u00020ZJ(\u0010k\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010l\u001a\u00020\u00072\b\b\u0002\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020oH\u0002J(\u0010p\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010l\u001a\u00020\u00072\b\b\u0002\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020oH\u0002J\b\u0010q\u001a\u0004\u0018\u00010rJ\u0012\u0010s\u001a\u00020\u00072\b\u0010t\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010u\u001a\u00020\u0007H\u0016J\b\u0010v\u001a\u0004\u0018\u00010\u0018J\b\u0010w\u001a\u00020)H\u0002J\u0006\u0010x\u001a\u00020\u0007J\u0006\u0010y\u001a\u00020\u0007J\n\u0010z\u001a\u0004\u0018\u00010{H\u0016J\u0010\u0010|\u001a\u00020)2\u0006\u0010}\u001a\u00020MH\u0002J\n\u0010~\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u007f\u001a\u00020ZH\u0002J\t\u0010\u0080\u0001\u001a\u00020\nH\u0002J\u0013\u0010\u0081\u0001\u001a\u00020\n2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J6\u0010\u0082\u0001\u001a\u00020Z2\u0007\u0010\u0083\u0001\u001a\u00020\n2\u0007\u0010\u0084\u0001\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u0007H\u0014J\u001b\u0010\u0088\u0001\u001a\u00020Z2\u0007\u0010\u0089\u0001\u001a\u00020\u00072\u0007\u0010\u008a\u0001\u001a\u00020\u0007H\u0014J\u0014\u0010\u008b\u0001\u001a\u00020\n2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010eH\u0016J\u0014\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00182\u0007\u0010\u008e\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010\u008f\u0001\u001a\u00020Z2\u0007\u0010\u0090\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u0091\u0001\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\J/\u0010\u0092\u0001\u001a\u00020Z2&\u0010\u0093\u0001\u001a!\u0012\u0016\u0012\u00140H¢\u0006\u000f\b\u0095\u0001\u0012\n\b\u0096\u0001\u0012\u0005\b\b(\u0097\u0001\u0012\u0004\u0012\u00020Z0\u0094\u0001J\u0010\u0010\u0098\u0001\u001a\u00020Z2\u0007\u0010\u0099\u0001\u001a\u00020\nJ\u0007\u0010\u009a\u0001\u001a\u00020ZJ\u0010\u0010\u009b\u0001\u001a\u00020Z2\u0007\u0010\u009c\u0001\u001a\u00020\u0007J\u0010\u0010\u009d\u0001\u001a\u00020Z2\u0007\u0010\u009e\u0001\u001a\u00020\nJ\u0010\u0010\u009f\u0001\u001a\u00020Z2\u0007\u0010 \u0001\u001a\u00020rJ\u0012\u0010¡\u0001\u001a\u00020Z2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0014J\u0012\u0010£\u0001\u001a\u00020Z2\t\u0010¤\u0001\u001a\u0004\u0018\u00010\u0018J\u0012\u0010¥\u0001\u001a\u00020Z2\u0007\u0010\u009e\u0001\u001a\u00020\nH\u0016J\u0010\u0010¦\u0001\u001a\u00020Z2\u0007\u0010§\u0001\u001a\u00020\nJ\u0012\u0010¨\u0001\u001a\u00020Z2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u0014J\u0011\u0010©\u0001\u001a\u00020Z2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014J\u0010\u0010ª\u0001\u001a\u00020Z2\u0007\u0010«\u0001\u001a\u00020\u0007J\u0012\u0010¬\u0001\u001a\u00020Z2\t\b\u0001\u0010\u00ad\u0001\u001a\u00020\u0007J\u0010\u0010®\u0001\u001a\u00020Z2\u0007\u0010¯\u0001\u001a\u00020\u0007J\u000f\u0010°\u0001\u001a\u00020Z2\u0006\u0010\u001c\u001a\u00020\nJ\u0013\u0010±\u0001\u001a\u00020Z2\n\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001J\u0012\u0010´\u0001\u001a\u00020Z2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0014J/\u0010¶\u0001\u001a\u00020Z2&\u0010\u0093\u0001\u001a!\u0012\u0016\u0012\u00140H¢\u0006\u000f\b\u0095\u0001\u0012\n\b\u0096\u0001\u0012\u0005\b\b(\u0097\u0001\u0012\u0004\u0012\u00020Z0\u0094\u0001J\u0012\u0010·\u0001\u001a\u00020Z2\u0007\u0010¸\u0001\u001a\u00020\u0007H\u0016J\u0010\u0010¹\u0001\u001a\u00020Z2\u0007\u0010¸\u0001\u001a\u00020\u0007J\u0010\u0010º\u0001\u001a\u00020Z2\u0007\u0010»\u0001\u001a\u00020\u0007J\u0014\u0010¼\u0001\u001a\u00020Z2\t\u0010½\u0001\u001a\u0004\u0018\u00010.H\u0016J\u0012\u0010¾\u0001\u001a\u00020Z2\t\u0010½\u0001\u001a\u0004\u0018\u00010.J\u0014\u0010¿\u0001\u001a\u00020Z2\t\u0010½\u0001\u001a\u0004\u0018\u00010{H\u0016J\u0010\u0010À\u0001\u001a\u00020Z2\u0007\u0010Á\u0001\u001a\u000200J\u0012\u0010Â\u0001\u001a\u00020Z2\t\u0010½\u0001\u001a\u0004\u0018\u000102J\u000f\u0010Ã\u0001\u001a\u00020Z2\u0006\u00104\u001a\u00020\u0007J\u0010\u0010Ä\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0010\u0010Æ\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0010\u0010Ç\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0010\u0010È\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0010\u0010É\u0001\u001a\u00020Z2\u0007\u0010Ê\u0001\u001a\u00020\nJ\u0012\u0010Ë\u0001\u001a\u00020Z2\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0014J\u000f\u00106\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0010\u0010Í\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\u0012\u0010Î\u0001\u001a\u00020Z2\u0007\u0010Ï\u0001\u001a\u00020MH\u0002J\u0012\u0010Ð\u0001\u001a\u00020Z2\u0007\u0010Ï\u0001\u001a\u00020MH\u0002J\u0012\u0010Ñ\u0001\u001a\u00020Z2\u0007\u0010Ï\u0001\u001a\u00020MH\u0002J\t\u0010Ò\u0001\u001a\u00020ZH\u0002J\u0012\u0010Ó\u0001\u001a\u00020Z2\u0007\u0010Ô\u0001\u001a\u00020\nH\u0002J\u0012\u0010Õ\u0001\u001a\u00020Z2\u0007\u0010Ö\u0001\u001a\u00020\nH\u0002J\t\u0010×\u0001\u001a\u00020ZH\u0002J\u0010\u0010×\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nJ\t\u0010Ø\u0001\u001a\u00020ZH\u0002J$\u0010Ù\u0001\u001a\u00020Z2\b\u0010Ú\u0001\u001a\u00030Û\u00012\u0007\u0010Ï\u0001\u001a\u00020M2\u0006\u0010^\u001a\u00020\u0014H\u0002J\u0012\u0010Ü\u0001\u001a\u00020Z2\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0014J\u0010\u0010Ý\u0001\u001a\u00020Z2\u0007\u0010Å\u0001\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010N\u001a\u00020O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020WX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ã\u0001"}, d2 = {"Lcom/obric/oui/forms/OInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alwaysHideEye", "", "autoHideSoftInputWhenLoseFocus", "getAutoHideSoftInputWhenLoseFocus", "()Z", "setAutoHideSoftInputWhenLoseFocus", "(Z)V", "autoShowClear", "bgResId", "comboInputEnabled", "commonTip", "", "digits", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "errorTip", "gravity", "hint", "inScrollableView", "initText", "inputHeight", "Ljava/lang/Integer;", "inputMode", "inputType", "insideLabel", "isEnable", "isError", "labelHideAnimator", "Landroid/animation/ValueAnimator;", "labelShowAnimator", "lastScrollX", "", "lastScrollY", "limitCount", "maxLines", "onComboArrowClickListener", "Landroid/view/View$OnClickListener;", "onTextClearedListener", "Lcom/obric/oui/forms/OInputView$OnTextClearedListener;", "onTextExceedLengthListener", "Lcom/obric/oui/forms/OInputView$OnTextExceedLengthListener;", "orientation", "radius", "shouldDispatchToInput", "showCommonTip", "showLabel", "showLabelAnim", "showLabelIcon", "showLimitIndicator", "showResizer", "singleLine", "transparentBg", "transparentBorder", "vActionContainer", "Landroid/view/View;", "vBorderContainer", "Lcom/obric/oui/layout/OUIConstraintLayout;", "vClear", "vComboArrow", "vCommonTip", "Lcom/obric/oui/text/OTextView;", "vCustomActionContainer", "Landroid/widget/FrameLayout;", "vErrorTip", "vEye", "Landroid/widget/ImageView;", "vFakeLabel", "Landroid/widget/TextView;", "vInput", "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "vInputResizer", "vLeftViewContainer", "vLimitIndicator", "vTitle", "vTitleContainer", "Landroid/widget/LinearLayout;", "vTitleIcon", "addTextChangedListener", "", "watcher", "Landroid/text/TextWatcher;", "adjustInputViewAndLabel", MemoryInfoSectionEditActivity.KIND_SCENE, "blendColors", "startColor", "endColor", "ratio", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "doAfterTextStateChange", "editable", "Landroid/text/Editable;", "enableTransparentBg", "enableTransparentBorder", "genLabelHideAnim", "labelTextColor", "inputHintTextColor", "duration", "", "genLabelShowAnim", "getCommitCompletionListener", "Lcom/obric/oui/forms/OEditText$CommitCompletionListener;", "getConstraintLength", "s", "getContentViewRes", "getEllipsize", "getFakeInputOffsetY", "getInputType", "getLimitCount", "getOnFocusChangeListener", "Landroid/view/View$OnFocusChangeListener;", "getScaleRatio", "vFakeInput", "getText", "hideSoftInput", "isPasswordMode", "onInterceptTouchEvent", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "parseEllipsize", EventBody.KEY_VALUE, "playLabelAnim", "hasFocus", "removeTextChangedListener", "setActionView", "creator", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "parent", "setAlwaysHideEye", "hide", "setAutoHideSoft", "setBgResId", "resId", "setComboInputEnabled", "enabled", "setCommitCompletionListener", "commitCompletionListener", "setCommonTip", "tip", "setEllipsize", "where", "setEnabled", "setErrorState", "error", "setErrorTip", "setHint", "setInputHeight", "height", "setInputMode", "mode", "setInputType", "type", "setIsInScrollableView", "setKeyListener", "keyListener", "Landroid/text/method/KeyListener;", "setLabel", AnnotatedPrivateKey.LABEL, "setLeftView", "setLimitCount", "limit", "setLimitCountValue", "setMaxLines", "max", "setOnClickListener", "l", "setOnComboArrowClickListener", "setOnFocusChangeListener", "setOnTextClearedListener", "listener", "setOnTextExceedLengthListener", "setRadius", "setShowLabel", "show", "setShowLabelAnim", "setShowLabelIcon", "setShowLimitIndicator", "setSingleLine", LocationInfoConst.SINGLE, "setText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "showErrorTip", "showFakeLabel", "fakeLabel", "showNoLabel", "showRealLabel", "showSoftInput", "updateBackground", "pressed", "updateBorder", "focus", "updateClearVisibility", "updateEyeVisibility", "updateLabelUIState", "state", "Lcom/obric/oui/forms/OInputView$LabelUIState;", "updateLimitIndicator", "updateResizerVisibility", "Companion", "InputMode", "LabelUIState", "OnTextClearedListener", "OnTextExceedLengthListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OInputView extends ConstraintLayout {
    public static final a Companion = null;
    private static final float FAKE_LABEL_OFFSET_Y = -11.0f;
    private static final float FAKE_LABEL_TARGET_SCALE = 0.857143f;
    public static final int HORIZONTAL = 1;
    public static final int INPUT_MODE_COMBO = 1;
    public static final int INPUT_MODE_TEXT = 0;
    private static final long LABEL_ANIM_DURATION = 200;
    public static final String TAG = "OInputView";
    public static final int VERTICAL = 0;
    private boolean alwaysHideEye;
    private boolean autoHideSoftInputWhenLoseFocus;
    private boolean autoShowClear;
    private int bgResId;
    private boolean comboInputEnabled;
    private String commonTip;
    private CharSequence digits;
    private TextUtils.TruncateAt ellipsize;
    private String errorTip;
    private int gravity;
    private String hint;
    private boolean inScrollableView;
    private String initText;
    private Integer inputHeight;
    private int inputMode;
    private int inputType;
    private String insideLabel;
    private boolean isEnable;
    private boolean isError;
    private ValueAnimator labelHideAnimator;
    private ValueAnimator labelShowAnimator;
    private float lastScrollX;
    private float lastScrollY;
    private int limitCount;
    private int maxLines;
    private View.OnClickListener onComboArrowClickListener;
    private b onTextClearedListener;
    private c onTextExceedLengthListener;
    private int orientation;
    private int radius;
    private boolean shouldDispatchToInput;
    private boolean showCommonTip;
    private boolean showLabel;
    private boolean showLabelAnim;
    private boolean showLabelIcon;
    private boolean showLimitIndicator;
    private boolean showResizer;
    private boolean singleLine;
    private boolean transparentBg;
    private boolean transparentBorder;
    private final View vActionContainer;
    private final OUIConstraintLayout vBorderContainer;
    private final View vClear;
    private final View vComboArrow;
    private final OTextView vCommonTip;
    private final FrameLayout vCustomActionContainer;
    private final OTextView vErrorTip;
    private final ImageView vEye;
    private TextView vFakeLabel;
    private final OEditText vInput;
    private final View vInputResizer;
    private final FrameLayout vLeftViewContainer;
    private final OTextView vLimitIndicator;
    private final OTextView vTitle;
    private final LinearLayout vTitleContainer;
    private final ImageView vTitleIcon;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OInputView$LabelUIState;", "", "(Ljava/lang/String;I)V", "REAL_LABEL_SHOW", "FAKE_LABEL_SHOW", "LABEL_NONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum LabelUIState extends Enum<LabelUIState> {
        private static final /* synthetic */ LabelUIState[] $VALUES = null;
        public static final LabelUIState FAKE_LABEL_SHOW = null;
        public static final LabelUIState LABEL_NONE = null;
        public static final LabelUIState REAL_LABEL_SHOW = null;

        private static final /* synthetic */ LabelUIState[] $values() {
            return new LabelUIState[]{REAL_LABEL_SHOW, FAKE_LABEL_SHOW, LABEL_NONE};
        }

        static {
            REAL_LABEL_SHOW = new LabelUIState("REAL_LABEL_SHOW", 0);
            FAKE_LABEL_SHOW = new LabelUIState("FAKE_LABEL_SHOW", 1);
            LABEL_NONE = new LabelUIState("LABEL_NONE", 2);
            $VALUES = $values();
        }

        private LabelUIState(String r1, int r2) {
            super(r1, r2);
        }

        public static LabelUIState valueOf(String r2) {
            return (LabelUIState) ZeusTransformUtils.preCheckCast(Enum.valueOf(LabelUIState.class, r2), LabelUIState.class, "com.obric.memorydata.plugin");
        }

        public static LabelUIState[] values() {
            return (LabelUIState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LabelUIState[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/forms/OInputView$Companion;", "", "()V", "FAKE_LABEL_OFFSET_Y", "", "FAKE_LABEL_TARGET_SCALE", "HORIZONTAL", "", "INPUT_MODE_COMBO", "INPUT_MODE_TEXT", "LABEL_ANIM_DURATION", "", "TAG", "", "VERTICAL", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/forms/OInputView$OnTextClearedListener;", "", "afterClear", "", "beforeClear", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface b {
        void a();

        void a(String r1);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/forms/OInputView$OnTextExceedLengthListener;", "", "textExceedLength", "", "s", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface c {
        void a(String r1);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13866a = null;

        static {
            int[] r0 = new int[LabelUIState.values().length];
            r0[LabelUIState.REAL_LABEL_SHOW.ordinal()] = 1;
            r0[LabelUIState.FAKE_LABEL_SHOW.ordinal()] = 2;
            r0[LabelUIState.LABEL_NONE.ordinal()] = 3;
            f13866a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/obric/oui/forms/OInputView$genLabelHideAnim$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "isReverse", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputView f13867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f13868b;

        e(OInputView r1, TextView r2) {
            this.f13867a = r1;
            this.f13868b = r2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            if (this.f13867a.getVInput().hasFocus() == false) goto L5;
            OInputView r4 = this.f13867a;
            LabelUIState r1 = LabelUIState.REAL_LABEL_SHOW;
        L6:
            OInputView.access$updateLabelUIState(r4, r1, this.f13868b, "LabelHideAnim, onAnimationCancel");
            return;
        L5:
            r4 = this.f13867a;
            r1 = LabelUIState.FAKE_LABEL_SHOW;
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            if (this.f13867a.getVInput().hasFocus() == false) goto L5;
            OInputView r4 = this.f13867a;
            LabelUIState r1 = LabelUIState.REAL_LABEL_SHOW;
        L6:
            OInputView.access$updateLabelUIState(r4, r1, this.f13868b, "LabelHideAnim, onAnimationCancel");
            return;
        L5:
            r4 = this.f13867a;
            r1 = LabelUIState.FAKE_LABEL_SHOW;
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            OInputView.access$updateLabelUIState(this.f13867a, LabelUIState.FAKE_LABEL_SHOW, this.f13868b, "LabelHideAnim, onAnimationStart");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/obric/oui/forms/OInputView$genLabelShowAnim$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "isReverse", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OInputView f13869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f13870b;

        f(OInputView r1, TextView r2) {
            this.f13869a = r1;
            this.f13870b = r2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            if (this.f13869a.getVInput().hasFocus() == false) goto L5;
            OInputView r4 = this.f13869a;
            LabelUIState r1 = LabelUIState.REAL_LABEL_SHOW;
        L6:
            OInputView.access$updateLabelUIState(r4, r1, this.f13870b, "LabelShowAnim, onAnimationCancel");
            return;
        L5:
            r4 = this.f13869a;
            r1 = LabelUIState.FAKE_LABEL_SHOW;
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            if (this.f13869a.getVInput().hasFocus() == false) goto L5;
            OInputView r4 = this.f13869a;
            LabelUIState r1 = LabelUIState.REAL_LABEL_SHOW;
        L6:
            OInputView.access$updateLabelUIState(r4, r1, this.f13870b, "LabelShowAnim, onAnimationCancel");
            return;
        L5:
            r4 = this.f13869a;
            r1 = LabelUIState.FAKE_LABEL_SHOW;
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            OInputView.access$updateLabelUIState(this.f13869a, LabelUIState.FAKE_LABEL_SHOW, this.f13870b, "LabelShowAnim, onAnimationStart");
        }
    }

    static {
        Companion = new a(null);
    }

    public OInputView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OInputView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OInputView(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12, r13, r11);
        int r0 = 1;
        this.comboInputEnabled = true;
        this.singleLine = true;
        this.maxLines = Integer.MAX_VALUE;
        this.gravity = 16;
        this.autoShowClear = true;
        this.showResizer = true;
        this.limitCount = -1;
        this.showLabel = true;
        this.showLabelIcon = true;
        this.isEnable = true;
        this.radius = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 10);
        TypedArray r14 = r12.getTheme().obtainStyledAttributes(r13, R.styleable.OInputView, r11, 0);
        this.inScrollableView = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_inputInScrollableView, "styleable", "OInputView_oui_inputInScrollableView"), false);
        this.autoShowClear = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_autoShowClear, "styleable", "OInputView_oui_autoShowClear"), true);
        this.showResizer = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_showResizer, "styleable", "OInputView_oui_showResizer"), true);
        this.showLabel = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_showLabel, "styleable", "OInputView_oui_showLabel"), true);
        this.showLabelAnim = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_showLabelAnim, "styleable", "OInputView_oui_showLabelAnim"), false);
        this.showLabelIcon = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_showLabelIcon, "styleable", "OInputView_oui_showLabelIcon"), true);
        this.insideLabel = r14.getString(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_inputLabel, "styleable", "OInputView_oui_inputLabel"));
        this.errorTip = r14.getString(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_errorTip, "styleable", "OInputView_oui_errorTip"));
        this.commonTip = r14.getString(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_commonTip, "styleable", "OInputView_oui_commonTip"));
        this.showCommonTip = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_showCommonTip, "styleable", "OInputView_oui_showCommonTip"), false);
        this.radius = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_inputBorderRadius, "styleable", "OInputView_oui_inputBorderRadius"), this.radius);
        this.comboInputEnabled = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_comboInputEnabled, "styleable", "OInputView_oui_comboInputEnabled"), true);
        this.inputMode = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_inputMode, "styleable", "OInputView_oui_inputMode"), 0);
        this.singleLine = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_inputSingleLine, "styleable", "OInputView_oui_inputSingleLine"), true);
        int r15 = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_inputHeight, "styleable", "OInputView_oui_inputHeight"), 0);
        if (r15 <= 0) goto L5;
        this.inputHeight = Integer.valueOf(r15);
    L5:
        this.limitCount = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_limitCount, "styleable", "OInputView_oui_limitCount"), -1);
        this.showLimitIndicator = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputView_oui_showLimitIndicator, "styleable", "OInputView_oui_showLimitIndicator"), false);
        this.digits = r14.getText(ZeusTransformUtils.mapRes(R.styleable.OInputView_android_digits, "styleable", "OInputView_android_digits"));
        this.hint = r14.getString(ZeusTransformUtils.mapRes(R.styleable.OInputView_android_hint, "styleable", "OInputView_android_hint"));
        this.inputType = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputView_android_inputType, "styleable", "OInputView_android_inputType"), 0);
        this.initText = r14.getString(ZeusTransformUtils.mapRes(R.styleable.OInputView_android_text, "styleable", "OInputView_android_text"));
        this.isEnable = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OInputView_android_enabled, "styleable", "OInputView_android_enabled"), true);
        this.maxLines = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputView_android_maxLines, "styleable", "OInputView_android_maxLines"), Integer.MAX_VALUE);
        this.orientation = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputView_android_orientation, "styleable", "OInputView_android_orientation"), 0);
        this.gravity = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputView_android_gravity, "styleable", "OInputView_android_gravity"), 16);
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.OInputView_android_ellipsize, "styleable", "OInputView_android_ellipsize")) == false) goto L8;
        this.ellipsize = parseEllipsize(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.OInputView_android_ellipsize, "styleable", "OInputView_android_ellipsize"), 0));
    L8:
        r14.recycle();
        ZeusTransformUtils.inflate(LayoutInflater.from(r12), getContentViewRes(), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        View r16 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_border_container, OaidModel.KEY_ID, "o_input_border_container"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.o_input_border_container)");
        OUIConstraintLayout r17 = (OUIConstraintLayout) ZeusTransformUtils.preCheckCast(r16, OUIConstraintLayout.class, "com.obric.memorydata.plugin");
        this.vBorderContainer = r17;
        r17.setRadius(this.radius);
        View r18 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_title_container, OaidModel.KEY_ID, "o_input_title_container"));
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.o_input_title_container)");
        this.vTitleContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r18, LinearLayout.class, "com.obric.memorydata.plugin");
        View r19 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_title, OaidModel.KEY_ID, "o_input_title"));
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.o_input_title)");
        this.vTitle = (OTextView) ZeusTransformUtils.preCheckCast(r19, OTextView.class, "com.obric.memorydata.plugin");
        View r110 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_title_icon, OaidModel.KEY_ID, "o_input_title_icon"));
        Intrinsics.checkNotNullExpressionValue(r110, "findViewById(R.id.o_input_title_icon)");
        this.vTitleIcon = (ImageView) ZeusTransformUtils.preCheckCast(r110, ImageView.class, "com.obric.memorydata.plugin");
        View r111 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input, OaidModel.KEY_ID, "o_input"));
        Intrinsics.checkNotNullExpressionValue(r111, "findViewById(R.id.o_input)");
        OEditText r112 = (OEditText) ZeusTransformUtils.preCheckCast(r111, OEditText.class, "com.obric.memorydata.plugin");
        this.vInput = r112;
        r112.setVerticalScrollBarEnabled(false);
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_left_view_container, OaidModel.KEY_ID, "o_input_left_view_container"));
        Intrinsics.checkNotNullExpressionValue(r2, "findViewById(R.id.o_input_left_view_container)");
        this.vLeftViewContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r2, FrameLayout.class, "com.obric.memorydata.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_custom_action_container, OaidModel.KEY_ID, "o_input_custom_action_container"));
        Intrinsics.checkNotNullExpressionValue(r3, "findViewById(R.id.o_input_custom_action_container)");
        this.vCustomActionContainer = (FrameLayout) ZeusTransformUtils.preCheckCast(r3, FrameLayout.class, "com.obric.memorydata.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_action_container, OaidModel.KEY_ID, "o_input_action_container"));
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.o_input_action_container)");
        this.vActionContainer = r4;
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_clear, OaidModel.KEY_ID, "o_input_clear"));
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.o_input_clear)");
        this.vClear = r5;
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_combo_arrow, OaidModel.KEY_ID, "o_input_combo_arrow"));
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.o_input_combo_arrow)");
        this.vComboArrow = r6;
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_eyes_slash, OaidModel.KEY_ID, "o_input_eyes_slash"));
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.o_input_eyes_slash)");
        ImageView r8 = (ImageView) ZeusTransformUtils.preCheckCast(r7, ImageView.class, "com.obric.memorydata.plugin");
        this.vEye = r8;
        View r20 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_resizer, OaidModel.KEY_ID, "o_input_resizer"));
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.o_input_resizer)");
        this.vInputResizer = r20;
        View r21 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_error_tip, OaidModel.KEY_ID, "o_input_error_tip"));
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.o_input_error_tip)");
        this.vErrorTip = (OTextView) ZeusTransformUtils.preCheckCast(r21, OTextView.class, "com.obric.memorydata.plugin");
        View r22 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_common_tip, OaidModel.KEY_ID, "o_input_common_tip"));
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.o_input_common_tip)");
        this.vCommonTip = (OTextView) ZeusTransformUtils.preCheckCast(r22, OTextView.class, "com.obric.memorydata.plugin");
        View r23 = findViewById(ZeusTransformUtils.mapRes(R.id.o_input_limit_indicator, OaidModel.KEY_ID, "o_input_limit_indicator"));
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.o_input_limit_indicator)");
        this.vLimitIndicator = (OTextView) ZeusTransformUtils.preCheckCast(r23, OTextView.class, "com.obric.memorydata.plugin");
        this.vFakeLabel = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.o_input_view_fake_label, OaidModel.KEY_ID, "o_input_view_fake_label")), TextView.class, "com.obric.memorydata.plugin");
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        CharSequence r113 = this.digits;
        if (r113 == null) goto L14;
        r112.setKeyListener((KeyListener) ZeusTransformUtils.preCheckCast(DigitsKeyListener.getInstance(String.valueOf(r113)), KeyListener.class, "com.obric.memorydata.plugin"));
        int r114 = this.inputType;
        if (r114 == 0) goto L13;
        r0 = r114;
    L13:
        this.inputType = r0;
    L14:
        r112.setGravity(this.gravity);
        Integer r115 = this.inputHeight;
        if (r115 == null) goto L18;
        setInputHeight(((Number) ZeusTransformUtils.preCheckCast(r115, Number.class, "com.obric.memorydata.plugin")).intValue());
    L18:
        r112.onFocusChange$OUI_standardRelease((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this), Function1.class, "com.obric.memorydata.plugin"));
        r112.onOnTouchEvent$OUI_standardRelease((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass4(this), Function1.class, "com.obric.memorydata.plugin"));
        r112.onTextChanged$OUI_standardRelease((Function4) ZeusTransformUtils.preCheckCast(new AnonymousClass5(this), Function4.class, "com.obric.memorydata.plugin"));
        r112.afterTextChanged$OUI_standardRelease((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass6(this), Function1.class, "com.obric.memorydata.plugin"));
        r5.setOnClickListener(new $$Lambda$OInputView$EPqC_mzuaX9Ry0zElIgnKZj7W0(this));
        setCommonTip(this.commonTip);
        showCommonTip(this.showCommonTip);
        setErrorTip(this.errorTip);
        showErrorTip(false);
        setComboInputEnabled(this.comboInputEnabled);
        setLabel(this.insideLabel);
        setShowLabel(this.showLabel);
        setShowLabelIcon(this.showLabelIcon);
        setLimitCount(this.limitCount);
        setShowLimitIndicator(this.showLimitIndicator);
        setSingleLine(this.singleLine);
        setMaxLines(this.maxLines);
        setEllipsize(this.ellipsize);
        setHint(this.hint);
        setText(this.initText);
        setInputMode(this.inputMode);
        setEnabled(this.isEnable);
        updateClearVisibility();
        updateBorder(r112.hasFocus());
        int r116 = this.inputType;
        if (r116 == 0) goto L21;
        setInputType(r116);
    L21:
        updateEyeVisibility();
        r8.setOnClickListener(new $$Lambda$OInputView$KO4WQs6Bqp62Cqr4qgf4NxbZDs(this));
        r17.setOnClickListener(new $$Lambda$OInputView$SYSx3isEZPpqzYb1lP3uY2QcJJY(this));
        adjustInputViewAndLabel(CommonConsts.APM_INNER_EVENT_COST_INIT);
    }

    public /* synthetic */ OInputView(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
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

    /* JADX INFO: renamed from: _init_$lambda-2, reason: not valid java name */
    private static final void m1297_init_$lambda2(OInputView r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        b r3 = r1.onTextClearedListener;
        if (r3 == null) goto L10;
        Editable r0 = r1.vInput.getText();
        if (r0 != null) goto L8;
        String r4 = null;
    L9:
        r3.a(r4);
        goto L10
    L8:
        r4 = r0.toString();
    L10:
        r1.setText("");
        b r5 = r1.onTextClearedListener;
        if (r5 == null) goto L14;
        r5.a();
    L14:
        r1.updateClearVisibility();
    }

    /* JADX INFO: renamed from: _init_$lambda-3, reason: not valid java name */
    private static final void m1298_init_$lambda3(OInputView r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        if (r3.inputType != r3.vInput.getInputType()) goto L5;
        r3.vEye.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_input_view_eyes_open, "drawable", "o_input_view_eyes_open"));
        OEditText r5 = r3.vInput;
        int r0 = r5.getInputType() | 144;
    L6:
        r5.setInputType(r0);
        if (r3.vInput.hasFocus() == false) goto L14;
        OEditText r6 = r3.vInput;
        Editable r7 = r6.getText();
        if (r7 != null) goto L11;
        int r8 = 0;
    L12:
        r6.setSelection(r8);
        return;
    L11:
        r8 = r7.length();
        goto L12
    L14:
        return;
    L5:
        r3.vEye.setImageResource(ZeusTransformUtils.mapRes(R.drawable.o_input_view_eyes_close, "drawable", "o_input_view_eyes_close"));
        r5 = r3.vInput;
        r0 = r3.inputType;
        goto L6
    }

    /* JADX INFO: renamed from: _init_$lambda-4, reason: not valid java name */
    private static final void m1299_init_$lambda4(OInputView r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.vInput.requestFocus();
        if (r1.vInput.hasFocus() == true) goto L5;
    L7:
        r1.showSoftInput();
        return;
    L5:
        if (r1.vInput.isCursorVisible() == true) goto L7;
        r1.vInput.setCursorVisible(true);
        goto L7
    }

    public static final /* synthetic */ int access$getLimitCount$p(OInputView r0) {
        return r0.limitCount;
    }

    public static final /* synthetic */ c access$getOnTextExceedLengthListener$p(OInputView r0) {
        return r0.onTextExceedLengthListener;
    }

    public static final /* synthetic */ boolean access$getShowCommonTip$p(OInputView r0) {
        return r0.showCommonTip;
    }

    public static final /* synthetic */ void access$hideSoftInput(OInputView r0) {
        r0.hideSoftInput();
    }

    public static final /* synthetic */ boolean access$isError$p(OInputView r0) {
        return r0.isError;
    }

    public static final /* synthetic */ void access$playLabelAnim(OInputView r0, boolean r1) {
        r0.playLabelAnim(r1);
    }

    public static final /* synthetic */ void access$showSoftInput(OInputView r0) {
        r0.showSoftInput();
    }

    public static final /* synthetic */ void access$updateBackground(OInputView r0, boolean r1) {
        r0.updateBackground(r1);
    }

    public static final /* synthetic */ void access$updateBorder(OInputView r0, boolean r1) {
        r0.updateBorder(r1);
    }

    public static final /* synthetic */ void access$updateClearVisibility(OInputView r0) {
        r0.updateClearVisibility();
    }

    public static final /* synthetic */ void access$updateEyeVisibility(OInputView r0) {
        r0.updateEyeVisibility();
    }

    public static final /* synthetic */ void access$updateLabelUIState(OInputView r0, LabelUIState r1, TextView r2, String r3) {
        r0.updateLabelUIState(r1, r2, r3);
    }

    private final void adjustInputViewAndLabel(String r7) {
        if (this.showLabelAnim == true) goto L5;
        return;
    L5:
        TextView r0 = this.vFakeLabel;
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.showLabel == true) goto L13;
        this.vInput.setHint((CharSequence) ZeusTransformUtils.preCheckCast(this.hint, CharSequence.class, "com.obric.memorydata.plugin"));
        LabelUIState r1 = LabelUIState.LABEL_NONE;
        StringBuilder r8 = new StringBuilder().append("adjustInputViewAndLabel, ").append(r7);
        String r2 = ", no label";
    L11:
        updateLabelUIState(r1, r0, r8.append(r2).toString());
        return;
    L13:
        if (this.singleLine == true) goto L15;
        this.vInput.setHint((CharSequence) ZeusTransformUtils.preCheckCast(this.hint, CharSequence.class, "com.obric.memorydata.plugin"));
        r1 = LabelUIState.REAL_LABEL_SHOW;
        r8 = new StringBuilder().append("adjustInputViewAndLabel, ").append(r7);
        r2 = ", can not show label anim";
        goto L11
    L15:
        this.vInput.setHint((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.memorydata.plugin"));
        r0.setText((CharSequence) ZeusTransformUtils.preCheckCast(this.insideLabel, CharSequence.class, "com.obric.memorydata.plugin"));
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(this.vInput.getText(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L18;
    L21:
        boolean r4 = true;
    L22:
        if (r4 == true) goto L24;
        r1 = LabelUIState.REAL_LABEL_SHOW;
        r8 = new StringBuilder().append("adjustInputViewAndLabel, ").append(r7);
        r2 = ", can show label anim, vInput.text not empty";
        goto L11
    L24:
        if (this.vInput.hasFocus() == false) goto L26;
        r1 = LabelUIState.REAL_LABEL_SHOW;
        r8 = new StringBuilder().append("adjustInputViewAndLabel, ").append(r7);
        r2 = ", can show label anim, vInput.text empty, focused";
        goto L11
    L26:
        r1 = LabelUIState.FAKE_LABEL_SHOW;
        r8 = new StringBuilder().append("adjustInputViewAndLabel, ").append(r7);
        r2 = ", can show label anim, vInput.text empty, not focused";
        goto L11
    L18:
        if (r3.length() == 0) goto L21;
        r4 = false;
        goto L22
    }

    private final int blendColors(int r2, int r3, float r4) {
        return ColorUtils.blendARGB(r2, r3, RangesKt.coerceIn(r4, 0.0f, 1.0f));
    }

    private final ValueAnimator genLabelHideAnim(final int r11, final int r12, long r13) {
        final TextView r7 = this.vFakeLabel;
        if (r7 != null) goto L6;
        return null;
    L6:
        final float r1 = getFakeInputOffsetY();
        final float r5 = getScaleRatio(r7);
        r7.setPivotX(0.0f);
        r7.setPivotY(-r1);
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r8.setDuration(r13);
        r8.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r8.addUpdateListener(new $$Lambda$OInputView$hIako26qIeCTv7C0iCOxMprCrNo(r1, this, r11, r12, r5, r7));
        r8.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new e(this, r7), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        return r8;
    }

    static /* synthetic */ ValueAnimator genLabelHideAnim$default(OInputView r3, int r4, int r5, long r6, int r8, Object r9) {
        if (r9 != null) goto L15;
        if ((r8 & 1) == 0) goto L7;
        r4 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_text_3, TypedValues.Custom.S_COLOR, "oui_text_3"));
    L7:
        if ((r8 & 2) == 0) goto L10;
        r5 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_text_4, TypedValues.Custom.S_COLOR, "oui_text_4"));
    L10:
        if ((r8 & 4) == 0) goto L13;
        r6 = 200;
    L13:
        return r3.genLabelHideAnim(r4, r5, r6);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genLabelHideAnim");
    }

    /* JADX INFO: renamed from: genLabelHideAnim$lambda-18, reason: not valid java name */
    private static final void m1300genLabelHideAnim$lambda18(float r2, OInputView r3, int r4, int r5, float r6, TextView r7, ValueAnimator r8) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r7, "$vFakeInput");
        Intrinsics.checkNotNullParameter(r8, "animation");
        Object r9 = r8.getAnimatedValue();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type kotlin.Float");
        float r10 = ((Float) ZeusTransformUtils.preCheckCast(r9, Float.class, "com.obric.memorydata.plugin")).floatValue();
        float r11 = r2 + ((0 - r2) * r10);
        float r12 = r6 + ((1.0f - r6) * r10);
        r7.setTextColor(r3.blendColors(r4, r5, r10));
        r7.setScaleX(r12);
        r7.setScaleY(r12);
        r7.setTranslationY(r11);
        com.obric.oui.c.a.b.a(TAG, "progress: " + r10 + ", transY: " + r11 + ", scale: " + r12);
    }

    private final ValueAnimator genLabelShowAnim(final int r11, final int r12, long r13) {
        final TextView r7 = this.vFakeLabel;
        if (r7 != null) goto L6;
        return null;
    L6:
        final float r1 = getFakeInputOffsetY();
        final float r5 = getScaleRatio(r7);
        r7.setPivotX(0.0f);
        r7.setPivotY(-r1);
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r8.setDuration(r13);
        r8.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.memorydata.plugin"));
        r8.addUpdateListener(new $$Lambda$OInputView$gnmwHB0yD4gH05ZMpO8O2Cmdk(r1, this, r12, r11, r5, r7));
        r8.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new f(this, r7), Animator.AnimatorListener.class, "com.obric.memorydata.plugin"));
        return r8;
    }

    static /* synthetic */ ValueAnimator genLabelShowAnim$default(OInputView r3, int r4, int r5, long r6, int r8, Object r9) {
        if (r9 != null) goto L15;
        if ((r8 & 1) == 0) goto L7;
        r4 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_text_3, TypedValues.Custom.S_COLOR, "oui_text_3"));
    L7:
        if ((r8 & 2) == 0) goto L10;
        r5 = ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_text_4, TypedValues.Custom.S_COLOR, "oui_text_4"));
    L10:
        if ((r8 & 4) == 0) goto L13;
        r6 = 200;
    L13:
        return r3.genLabelShowAnim(r4, r5, r6);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genLabelShowAnim");
    }

    /* JADX INFO: renamed from: genLabelShowAnim$lambda-17, reason: not valid java name */
    private static final void m1301genLabelShowAnim$lambda17(float r2, OInputView r3, int r4, int r5, float r6, TextView r7, ValueAnimator r8) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r7, "$vFakeInput");
        Intrinsics.checkNotNullParameter(r8, "animation");
        Object r9 = r8.getAnimatedValue();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type kotlin.Float");
        float r10 = ((Float) ZeusTransformUtils.preCheckCast(r9, Float.class, "com.obric.memorydata.plugin")).floatValue();
        float r0 = 0;
        float r1 = r0 + ((r2 - r0) * r10);
        float r11 = ((r6 - 1.0f) * r10) + 1.0f;
        r7.setTextColor(r3.blendColors(r4, r5, r10));
        r7.setScaleX(r11);
        r7.setScaleY(r11);
        r7.setTranslationY(r1);
        com.obric.oui.c.a.b.a(TAG, "progress: " + r10 + ", transY: " + r1 + ", scale: " + r11);
    }

    private final float getFakeInputOffsetY() {
        if (this.vTitleContainer.getHeight() > 0) goto L5;
    L7:
        com.obric.oui.c.a.b.d(TAG, "getFakeInputOffsetY, use default offset, vTitleContainer.height: " + this.vTitleContainer.getHeight() + ", height: " + getHeight());
        float r0 = h.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), FAKE_LABEL_OFFSET_Y);
    L8:
        com.obric.oui.c.a.b.b(TAG, Intrinsics.stringPlus("getFakeInputOffsetY, offsetY: ", Float.valueOf(r0)));
        return r0;
    L5:
        if (getHeight() <= 0) goto L7;
        r0 = (this.vTitleContainer.getY() + (this.vTitleContainer.getHeight() / 2.0f)) - (getHeight() / 2.0f);
        goto L8
    }

    private final float getScaleRatio(TextView r4) {
        if (this.vTitle.getTextSize() > 0.0f) goto L5;
    L7:
        com.obric.oui.c.a.b.d(TAG, "getScaleRatio, use default scale, vTitle.textSize: " + this.vTitle.getTextSize() + ", vFakeInput.textSize: " + r4.getTextSize());
        float r3 = FAKE_LABEL_TARGET_SCALE;
    L8:
        com.obric.oui.c.a.b.b(TAG, Intrinsics.stringPlus("getScaleRatio, scale: ", Float.valueOf(r3)));
        return r3;
    L5:
        if (r4.getTextSize() <= 0.0f) goto L7;
        r3 = this.vTitle.getTextSize() / r4.getTextSize();
        goto L8
    }

    private final void hideSoftInput() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.hideSoftInputFromWindow(this.vInput.getWindowToken(), 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final boolean isPasswordMode() {
        int r5 = this.inputType & 4095;
        if (r5 != 129) goto L5;
        boolean r2 = true;
    L7:
        if (r5 != 225) goto L9;
        boolean r3 = true;
    L11:
        if (r5 != 18) goto L13;
        boolean r6 = true;
    L14:
        if (r2 == true) goto L20;
        if (r3 == true) goto L21;
        if (r6 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L20:
        return true;
    L13:
        r6 = false;
        goto L14
    L9:
        r3 = false;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    /* JADX INFO: renamed from: lambda$EPqC_mzuaX9Ry-0zElIgnKZj7W0, reason: not valid java name */
    public static /* synthetic */ void m1302lambda$EPqC_mzuaX9Ry0zElIgnKZj7W0(OInputView r0, View r1) {
        m1297_init_$lambda2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$KO4WQs6Bqp62Cqr4qgf4NxbZD-s, reason: not valid java name */
    public static /* synthetic */ void m1303lambda$KO4WQs6Bqp62Cqr4qgf4NxbZDs(OInputView r0, View r1) {
        m1298_init_$lambda3(r0, r1);
    }

    public static /* synthetic */ void lambda$SYSx3isEZPpqzYb1lP3uY2QcJJY(OInputView r0, View r1) {
        m1299_init_$lambda4(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$gnmwHB0yD4gH-05Z-MpO8O2Cmdk, reason: not valid java name */
    public static /* synthetic */ void m1304lambda$gnmwHB0yD4gH05ZMpO8O2Cmdk(float r0, OInputView r1, int r2, int r3, float r4, TextView r5, ValueAnimator r6) {
        m1301genLabelShowAnim$lambda17(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void lambda$hIako26qIeCTv7C0iCOxMprCrNo(float r0, OInputView r1, int r2, int r3, float r4, TextView r5, ValueAnimator r6) {
        m1300genLabelHideAnim$lambda18(r0, r1, r2, r3, r4, r5, r6);
    }

    private final TextUtils.TruncateAt parseEllipsize(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L17;
        return null;
    L17:
        return TextUtils.TruncateAt.MARQUEE;
    L18:
        return TextUtils.TruncateAt.END;
    L19:
        return TextUtils.TruncateAt.MIDDLE;
    L15:
        return TextUtils.TruncateAt.START;
    }

    private final void playLabelAnim(boolean r10) {
        if (this.showLabelAnim == true) goto L6;
        return;
    L6:
        if (this.showLabel == true) goto L9;
        return;
    L9:
        if (this.singleLine == true) goto L12;
        return;
    L12:
        if (this.vFakeLabel != null) goto L14;
        return;
    L14:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.vInput.getText(), CharSequence.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (r0 != null) goto L17;
    L20:
        boolean r2 = true;
    L21:
        if (r2 == true) goto L25;
        LabelUIState r3 = LabelUIState.REAL_LABEL_SHOW;
        TextView r4 = this.vFakeLabel;
        Intrinsics.checkNotNull(r4);
        updateLabelUIState(r3, r4, Intrinsics.stringPlus("playLabelAnim, hasFocus: ", Boolean.valueOf(r10)));
        return;
    L25:
        if (r10 == false) goto L51;
        ValueAnimator r11 = this.labelHideAnimator;
        if (r11 == null) goto L30;
        r11.cancel();
    L30:
        ValueAnimator r12 = this.labelHideAnimator;
        if (r12 == null) goto L34;
        r12.removeAllUpdateListeners();
    L34:
        ValueAnimator r13 = this.labelHideAnimator;
        if (r13 == null) goto L38;
        r13.removeAllListeners();
    L38:
        ValueAnimator r14 = this.labelShowAnimator;
        if (r14 != null) goto L42;
    L44:
        if (r1 == true) goto L50;
        ValueAnimator r15 = genLabelShowAnim$default(this, 0, 0, 0, 7, null);
        this.labelShowAnimator = r15;
        if (r15 == null) goto L49;
        r15.start();
    L49:
        String r9 = "start label show anim";
    L75:
        com.obric.oui.c.a.b.b(TAG, r9);
        return;
    L50:
        String r16 = "label show anim is running, do nothing";
    L77:
        com.obric.oui.c.a.b.d(TAG, r16);
        return;
    L42:
        if (r14.isRunning() != true) goto L44;
        r1 = true;
        goto L44
    L51:
        ValueAnimator r17 = this.labelShowAnimator;
        if (r17 == null) goto L55;
        r17.cancel();
    L55:
        ValueAnimator r18 = this.labelShowAnimator;
        if (r18 == null) goto L59;
        r18.removeAllUpdateListeners();
    L59:
        ValueAnimator r19 = this.labelShowAnimator;
        if (r19 == null) goto L63;
        r19.removeAllListeners();
    L63:
        ValueAnimator r110 = this.labelHideAnimator;
        if (r110 != null) goto L67;
    L69:
        if (r1 == true) goto L76;
        ValueAnimator r111 = genLabelHideAnim$default(this, 0, 0, 0, 7, null);
        this.labelHideAnimator = r111;
        if (r111 == null) goto L74;
        r111.start();
    L74:
        r9 = "start label hide anim";
        goto L75
    L76:
        r16 = "label hide anim is running, do nothing";
        goto L77
    L67:
        if (r110.isRunning() != true) goto L69;
        r1 = true;
        goto L69
    L17:
        if (r0.length() == 0) goto L20;
        r2 = false;
        goto L21
    }

    private final void showFakeLabel(TextView r3) {
        this.vTitleContainer.setVisibility(4);
        r3.setVisibility(0);
        this.vInput.setAlpha(0.0f);
    }

    private final void showNoLabel(TextView r3) {
        this.vTitleContainer.setVisibility(8);
        r3.setVisibility(8);
        this.vInput.setAlpha(1.0f);
    }

    private final void showRealLabel(TextView r3) {
        this.vTitleContainer.setVisibility(0);
        r3.setVisibility(8);
        this.vInput.setAlpha(1.0f);
    }

    private final void showSoftInput() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("input_method");
        if (ZeusTransformUtils.instanceOf(r0, InputMethodManager.class) == false) goto L5;
        InputMethodManager r1 = (InputMethodManager) ZeusTransformUtils.preCheckCast(r0, InputMethodManager.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L10;
        r1.showSoftInput((View) ZeusTransformUtils.preCheckCast(this.vInput, View.class, "com.obric.memorydata.plugin"), 0);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void updateBackground(boolean r4) {
        int r0 = this.bgResId;
        if (r0 == 0) goto L7;
        this.vBorderContainer.setBackgroundResource(r0);
        return;
    L7:
        if (this.transparentBg == false) goto L11;
        this.vBorderContainer.setBackgroundResource(ZeusTransformUtils.mapRes(R.color.Transparent, TypedValues.Custom.S_COLOR, "Transparent"));
        return;
    L11:
        if (this.isEnable == true) goto L13;
    L12:
        int r5 = ZeusTransformUtils.mapRes(R.drawable.o_input_view_pressed_background, "drawable", "o_input_view_pressed_background");
    L20:
        this.vBorderContainer.setBackgroundResource(r5);
        return;
    L13:
        if (r4 == true) goto L12;
        if (this.vInput.hasFocus() == false) goto L18;
        int r6 = R.drawable.o_input_view_focused_background;
        String r1 = "o_input_view_focused_background";
    L19:
        r5 = ZeusTransformUtils.mapRes(r6, "drawable", r1);
        goto L20
    L18:
        r6 = R.drawable.o_input_view_normal_background;
        r1 = "o_input_view_normal_background";
        goto L19
    }

    private final void updateBorder(boolean r7) {
        int r2 = 0;
        if (this.transparentBorder == false) goto L7;
        this.vBorderContainer.setBorderWidth(0);
        this.vBorderContainer.setBorderColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.Transparent, TypedValues.Custom.S_COLOR, "Transparent")));
        return;
    L7:
        if (this.isEnable == true) goto L9;
    L8:
        int r0 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0);
    L14:
        this.vBorderContainer.setBorderWidth(r0);
        if (this.isEnable == true) goto L18;
        r2 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 0);
    L23:
        if (r2 == 0) goto L26;
        this.vBorderContainer.setBorderColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2));
        return;
    L26:
        return;
    L18:
        if (this.isError == false) goto L21;
        int r8 = R.color.oui_functional_red_7;
        String r1 = "oui_functional_red_7";
    L20:
        r2 = ZeusTransformUtils.mapRes(r8, TypedValues.Custom.S_COLOR, r1);
        goto L23
    L21:
        if (r7 == false) goto L23;
        r8 = R.color.oui_basic_line_3;
        r1 = "oui_basic_line_3";
        goto L20
    L9:
        if (r7 == false) goto L12;
        r0 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2);
        goto L14
    L12:
        if (this.isError == false) goto L8;
        r0 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 1.2d);
        goto L14
    }

    private final void updateClearVisibility() {
        if (this.autoShowClear == true) goto L5;
        return;
    L5:
        boolean r2 = true;
        if (isPasswordMode() == false) goto L8;
    L22:
        boolean r0 = false;
    L23:
        o.a(this.vClear, r0);
        if (r0 == false) goto L26;
        o.a((View) ZeusTransformUtils.preCheckCast(this.vEye, View.class, "com.obric.memorydata.plugin"), false);
    L26:
        View r1 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == false) goto L32;
    L43:
        o.a(r1, r2);
        return;
    L32:
        if (((View) ZeusTransformUtils.preCheckCast(this.vEye, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L34;
        boolean r3 = true;
    L35:
        if (r3 == true) goto L43;
        if (this.vComboArrow.getVisibility() != 0) goto L39;
        boolean r6 = true;
    L40:
        if (r6 == true) goto L43;
        r2 = false;
        goto L43
    L39:
        r6 = false;
        goto L40
    L34:
        r3 = false;
        goto L35
    L29:
        r4 = false;
        goto L30
    L8:
        if (this.inputMode != 0) goto L22;
        if (this.isEnable == false) goto L22;
        if (this.vInput.hasFocus() == false) goto L22;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(this.vInput.getText(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == true) goto L22;
        r0 = true;
        goto L23
    L16:
        if (r5.length() == 0) goto L19;
        r7 = false;
        goto L20
    }

    private final void updateEyeVisibility() {
        boolean r2 = true;
        if (isPasswordMode() == true) goto L5;
    L17:
        boolean r0 = false;
    L18:
        o.a((View) ZeusTransformUtils.preCheckCast(this.vEye, View.class, "com.obric.memorydata.plugin"), r0);
        if (r0 == false) goto L21;
        o.a(this.vClear, false);
    L21:
        View r1 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L24;
        boolean r4 = true;
    L25:
        if (r4 == false) goto L27;
    L38:
        o.a(r1, r2);
        return;
    L27:
        if (((View) ZeusTransformUtils.preCheckCast(this.vEye, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L29;
        boolean r3 = true;
    L30:
        if (r3 == true) goto L38;
        if (this.vComboArrow.getVisibility() != 0) goto L34;
        boolean r6 = true;
    L35:
        if (r6 == true) goto L38;
        r2 = false;
        goto L38
    L34:
        r6 = false;
        goto L35
    L29:
        r3 = false;
        goto L30
    L24:
        r4 = false;
        goto L25
    L5:
        if (this.isEnable == false) goto L17;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(this.vInput.getText(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L9;
    L12:
        boolean r7 = true;
    L13:
        if (r7 == true) goto L17;
        if (this.alwaysHideEye == true) goto L17;
        r0 = true;
        goto L18
    L9:
        if (r5.length() == 0) goto L12;
        r7 = false;
        goto L13
    }

    private final void updateLabelUIState(LabelUIState r3, TextView r4, String r5) {
        com.obric.oui.c.a.b.b(TAG, "updateLabelUIState, state: " + r3 + ", scene: [" + r5 + ']');
        int r6 = d.f13866a[r3.ordinal()];
        if (r6 != 1) goto L5;
        showRealLabel(r4);
        return;
    L5:
        if (r6 != 2) goto L7;
        showFakeLabel(r4);
        return;
    L7:
        if (r6 != 3) goto L15;
        showNoLabel(r4);
        return;
    }

    public final void addTextChangedListener(TextWatcher r3) {
        TextWatcher r4 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r3, TextWatcher.class, "com.obric.memorydata.plugin");
        this.vInput.addTextChangedListener(r4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r7) {
        if (r7 == null) goto L36;
        if (this.inScrollableView == false) goto L36;
        float r0 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 != 0) goto L8;
        this.lastScrollY = r0;
    L34:
        this.lastScrollY = r1;
        goto L36
    L8:
        if (r2 != 1) goto L10;
    L32:
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r2 == 2) goto L15;
        if (r2 == 3) goto L32;
    L15:
        if (r0 <= this.lastScrollX) goto L19;
        if (this.vInput.canScrollHorizontally(-1) == false) goto L19;
    L30:
        super.requestDisallowInterceptTouchEvent(true);
    L31:
        this.lastScrollX = r0;
    L19:
        if (r0 >= this.lastScrollX) goto L23;
        if (this.vInput.canScrollHorizontally(1) == true) goto L30;
    L23:
        if (r1 >= this.lastScrollY) goto L27;
        if (this.vInput.canScrollVertically(1) == true) goto L30;
    L27:
        if (r1 <= this.lastScrollY) goto L31;
        if (this.vInput.canScrollVertically(-1) == false) goto L31;
    L36:
        return super.dispatchTouchEvent(r7);
    }

    public void doAfterTextStateChange(Editable r2) {
        Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.memorydata.plugin");
    }

    public final void enableTransparentBg() {
        this.transparentBg = true;
        updateBackground(true);
    }

    public final void enableTransparentBorder() {
        this.transparentBorder = true;
        updateBorder(true);
    }

    public final boolean getAutoHideSoftInputWhenLoseFocus() {
        return this.autoHideSoftInputWhenLoseFocus;
    }

    public final OEditText.a getCommitCompletionListener() {
        return this.vInput.getCommitCompletionListener();
    }

    public int getConstraintLength(CharSequence r2) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return 0;
    L6:
        return r1.length();
    }

    public int getContentViewRes() {
        return ZeusTransformUtils.mapRes(R.layout.o_input_view_layout_vertical, "layout", "o_input_view_layout_vertical");
    }

    public final TextUtils.TruncateAt getEllipsize() {
        return this.vInput.getEllipsize();
    }

    public final int getInputType() {
        return this.inputType;
    }

    public final int getLimitCount() {
        return this.limitCount;
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        return this.vInput.getOnFocusChangeListener();
    }

    public String getText() {
        Editable r0 = this.vInput.getText();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    public final OEditText getVInput() {
        return this.vInput;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        if (r6 != null) goto L5;
    L13:
        if (r6 != null) goto L15;
    L22:
        return super.onInterceptTouchEvent(r6);
    L15:
        if (r6.getAction() == 1) goto L19;
        if (r6.getAction() != 3) goto L22;
    L19:
        if (this.shouldDispatchToInput == false) goto L22;
    L12:
        this.shouldDispatchToInput = false;
        goto L22
    L5:
        if (r6.getAction() != 0) goto L13;
        float r2 = r6.getX();
        int r3 = this.vInput.getLeft();
        int r4 = this.vInput.getRight();
        if (r2 < r3) goto L12;
        if (r2 > r4) goto L12;
        this.shouldDispatchToInput = true;
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r4) {
        if (r4 == null) goto L12;
        if (this.shouldDispatchToInput == false) goto L12;
        MotionEvent r0 = MotionEvent.obtain(r4);
        r0.offsetLocation(-this.vInput.getLeft(), -this.vInput.getTop());
        boolean r1 = this.vInput.dispatchTouchEvent(r0);
        r0.recycle();
        if (r4.getAction() != 1) goto L8;
    L9:
        this.shouldDispatchToInput = false;
    L10:
        return r1;
    L8:
        if (r4.getAction() != 3) goto L10;
    L12:
        return super.onTouchEvent(r4);
    }

    public final void removeTextChangedListener(TextWatcher r3) {
        TextWatcher r4 = (TextWatcher) ZeusTransformUtils.wrapperContextForParams(r3, TextWatcher.class, "com.obric.memorydata.plugin");
        this.vInput.removeTextChangedListener(r4);
    }

    public final void setActionView(Function1<? super FrameLayout, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "creator");
        this.vCustomActionContainer.removeAllViews();
        r4.invoke(this.vCustomActionContainer);
        View r5 = (View) ZeusTransformUtils.preCheckCast(this.vCustomActionContainer, View.class, "com.obric.memorydata.plugin");
        if (this.vCustomActionContainer.getChildCount() <= 0) goto L5;
        boolean r2 = true;
    L6:
        o.a(r5, r2);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void setAlwaysHideEye(boolean r2) {
        this.alwaysHideEye = r2;
        if (r2 == false) goto L6;
        o.a((View) ZeusTransformUtils.preCheckCast(this.vEye, View.class, "com.obric.memorydata.plugin"), false);
        return;
    }

    public final void setAutoHideSoft() {
        this.autoHideSoftInputWhenLoseFocus = true;
    }

    public final void setAutoHideSoftInputWhenLoseFocus(boolean r1) {
        this.autoHideSoftInputWhenLoseFocus = r1;
    }

    public final void setBgResId(int r1) {
        this.bgResId = r1;
        updateBackground(true);
    }

    public final void setComboInputEnabled(boolean r2) {
        this.comboInputEnabled = r2;
        this.vInput.setFocusable(r2);
        this.vInput.setFocusableInTouchMode(r2);
        View.OnClickListener r3 = this.onComboArrowClickListener;
        if (r3 == null) goto L7;
        getVInput().setOnClickListener(r3);
        return;
    }

    public final void setCommitCompletionListener(OEditText.a r3) {
        OEditText.a r4 = (OEditText.a) ZeusTransformUtils.wrapperContextForParams(r3, OEditText.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "commitCompletionListener");
        this.vInput.setCommitCompletionListener(r4);
    }

    public final void setCommonTip(String r3) {
        this.commonTip = r3;
        this.vCommonTip.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final void setEllipsize(TextUtils.TruncateAt r1) {
        this.ellipsize = r1;
        this.vInput.setEllipsize(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        this.isEnable = r5;
        super.setEnabled(r5);
        Iterator<View> r0 = ViewGroupKt.getChildren((ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) ZeusTransformUtils.preCheckCast(r0.next(), View.class, "com.obric.memorydata.plugin")).setEnabled(r5);
        goto L4
    L6:
        this.vInput.setEnabled(r5);
        updateBorder(this.vInput.hasFocus());
        updateBackground(false);
    }

    public final void setErrorState(boolean r1) {
        this.isError = r1;
        updateBorder(this.vInput.hasFocus());
        updateBackground(false);
    }

    public final void setErrorTip(String r3) {
        this.errorTip = r3;
        this.vErrorTip.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final void setHint(String r4) {
        this.hint = r4;
        this.vInput.setHint((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        adjustInputViewAndLabel("setHint");
    }

    public final void setInputHeight(int r4) {
        this.inputHeight = Integer.valueOf(r4);
        View r3 = (View) ZeusTransformUtils.preCheckCast(this.vInput, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).height = r4;
        r3.setLayoutParams(r1);
    }

    public final void setInputMode(int r6) {
        this.inputMode = r6;
        boolean r1 = false;
        if (r6 == 0) goto L23;
        if (r6 != 1) goto L42;
        setSingleLine(true);
        o.a(this.vComboArrow, true);
        View r7 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
    L21:
        r1 = true;
    L22:
        o.a(r7, r1);
        setComboInputEnabled(this.comboInputEnabled);
        return;
    L12:
        if (((View) ZeusTransformUtils.preCheckCast(this.vEye, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L14;
        boolean r0 = true;
    L15:
        if (r0 == true) goto L21;
        if (this.vComboArrow.getVisibility() != 0) goto L19;
        boolean r2 = true;
    L20:
        if (r2 == false) goto L22;
    L19:
        r2 = false;
        goto L20
    L14:
        r0 = false;
        goto L15
    L9:
        r3 = false;
        goto L10
    L42:
        return;
    L23:
        o.a(this.vComboArrow, false);
        View r8 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L26;
        boolean r4 = true;
    L27:
        if (r4 == false) goto L29;
    L38:
        r1 = true;
    L39:
        o.a(r8, r1);
        this.vInput.setFocusable(true);
        this.vInput.setFocusableInTouchMode(true);
        return;
    L29:
        if (((View) ZeusTransformUtils.preCheckCast(this.vEye, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L31;
        boolean r5 = true;
    L32:
        if (r5 == true) goto L38;
        if (this.vComboArrow.getVisibility() != 0) goto L36;
        boolean r9 = true;
    L37:
        if (r9 == false) goto L39;
    L36:
        r9 = false;
        goto L37
    L31:
        r5 = false;
        goto L32
    L26:
        r4 = false;
        goto L27
    }

    public final void setInputType(int r2) {
        if ((r2 & 1) == 0) goto L5;
    L11:
        this.inputType = r2;
        if (r2 != this.vInput.getInputType()) goto L15;
    L13:
        doAfterTextStateChange(this.vInput.getText());
        return;
    L15:
        this.vInput.setInputType(this.inputType);
        updateEyeVisibility();
        goto L13
    L5:
        if ((r2 & 2) != 0) goto L11;
        if ((r2 & 3) != 0) goto L11;
        if ((r2 & 4) != 0) goto L11;
        r2 = r2 | 1;
        goto L11
    }

    public final void setIsInScrollableView(boolean r1) {
        this.inScrollableView = r1;
    }

    public final void setKeyListener(KeyListener r3) {
        KeyListener r4 = (KeyListener) ZeusTransformUtils.wrapperContextForParams(r3, KeyListener.class, "com.obric.memorydata.plugin");
        this.vInput.setKeyListener(r4);
    }

    public final void setLabel(String r3) {
        this.insideLabel = r3;
        this.vTitle.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    public final void setLeftView(Function1<? super FrameLayout, Unit> r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "creator");
        this.vLeftViewContainer.removeAllViews();
        r4.invoke(this.vLeftViewContainer);
        View r5 = (View) ZeusTransformUtils.preCheckCast(this.vLeftViewContainer, View.class, "com.obric.memorydata.plugin");
        if (this.vLeftViewContainer.getChildCount() <= 0) goto L5;
        boolean r2 = true;
    L6:
        o.a(r5, r2);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void setLimitCount(int r1) {
        setLimitCountValue(r1);
        Editable r2 = this.vInput.getText();
        if (r2 != null) goto L5;
        String r3 = null;
    L6:
        updateLimitIndicator(r3);
        doAfterTextStateChange(this.vInput.getText());
        return;
    L5:
        r3 = r2.toString();
        goto L6
    }

    public final void setLimitCountValue(int r1) {
        this.limitCount = r1;
    }

    public final void setMaxLines(int r3) {
        int r0 = 1;
        if (r3 >= 1) goto L5;
        r3 = Integer.MAX_VALUE;
    L5:
        this.maxLines = r3;
        OEditText r1 = this.vInput;
        if (this.singleLine == true) goto L9;
        r0 = r3;
    L9:
        r1.setMaxLines(r0);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        if (this.inputMode == 1) goto L5;
    L7:
        super.setOnClickListener(r4);
        return;
    L5:
        if (this.comboInputEnabled == true) goto L7;
        this.vComboArrow.setOnClickListener(r4);
        this.vInput.setOnClickListener(r4);
        goto L7
    }

    public final void setOnComboArrowClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.memorydata.plugin");
        this.onComboArrowClickListener = r4;
        this.vComboArrow.setOnClickListener(r4);
        if (this.comboInputEnabled == true) goto L9;
        View.OnClickListener r5 = this.onComboArrowClickListener;
        if (r5 == null) goto L10;
        getVInput().setOnClickListener(r5);
        return;
    L10:
        return;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r3) {
        View.OnFocusChangeListener r4 = (View.OnFocusChangeListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnFocusChangeListener.class, "com.obric.memorydata.plugin");
        this.vInput.setOnFocusChangeListener(r4);
    }

    public final void setOnTextClearedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.onTextClearedListener = r4;
    }

    public final void setOnTextExceedLengthListener(c r3) {
        this.onTextExceedLengthListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
    }

    public final void setRadius(int r2) {
        if (r2 != this.radius) goto L5;
        return;
    L5:
        this.radius = r2;
        this.vBorderContainer.setRadius(r2);
    }

    public final void setShowLabel(boolean r5) {
        this.showLabel = r5;
        o.a((View) ZeusTransformUtils.preCheckCast(this.vTitleContainer, View.class, "com.obric.memorydata.plugin"), r5);
        View r6 = (View) ZeusTransformUtils.preCheckCast(this.vInput, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r1 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r2 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (this.showLabel == false) goto L5;
        View r3 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        int r4 = 16;
    L6:
        r2.goneLeftMargin = h.a(r3, r4);
        r2.goneStartMargin = r2.goneLeftMargin;
        r6.setLayoutParams(r1);
        adjustInputViewAndLabel("setShowLabel");
        return;
    L5:
        r3 = (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin");
        r4 = 12;
        goto L6
    }

    public final void setShowLabelAnim(boolean r1) {
        this.showLabelAnim = r1;
        adjustInputViewAndLabel("setShowLabelAnim");
    }

    public final void setShowLabelIcon(boolean r3) {
        this.showLabelIcon = r3;
        o.a((View) ZeusTransformUtils.preCheckCast(this.vTitleIcon, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void setShowLimitIndicator(boolean r1) {
        this.showLimitIndicator = r1;
        Editable r2 = this.vInput.getText();
        if (r2 != null) goto L5;
        String r3 = null;
    L6:
        updateLimitIndicator(r3);
        return;
    L5:
        r3 = r2.toString();
        goto L6
    }

    public final void setSingleLine(boolean r14) {
        this.singleLine = r14;
        int r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.o_input_view_space_top_bottom, "dimen", "o_input_view_space_top_bottom"));
        ViewGroup.LayoutParams r5 = null;
        if (r14 == false) goto L25;
        o.a(this.vInputResizer, false);
        this.vInput.setMaxLines(1);
        this.vInput.setSingleLine(true);
        View r15 = (View) ZeusTransformUtils.preCheckCast(this.vInput, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r8 = r15.getLayoutParams();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r9 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r8, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r10 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r11 = ((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r11, ViewGroup.MarginLayoutParams.class) == true) goto L7;
        r11 = null;
    L7:
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r11, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L10;
        int r13 = r12.leftMargin;
    L11:
        ViewGroup.LayoutParams r16 = ((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r16, ViewGroup.MarginLayoutParams.class) == false) goto L15;
        r5 = r16;
    L15:
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L18;
        int r7 = r6.rightMargin;
    L19:
        r10.setMargins(r13, 0, r7, r1);
        r10.goneTopMargin = r1;
        if (this.showLabel == false) goto L22;
        int r2 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16);
    L23:
        r10.goneLeftMargin = r2;
        r10.goneStartMargin = r10.goneLeftMargin;
        r15.setLayoutParams(r9);
        View r17 = this.vActionContainer;
        ViewGroup.LayoutParams r3 = r17.getLayoutParams();
        Objects.requireNonNull(r3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r4 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r18.topToTop = 0;
        r18.bottomToBottom = 0;
        r17.setLayoutParams(r4);
        View r19 = (View) ZeusTransformUtils.preCheckCast(this.vCustomActionContainer, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
        Objects.requireNonNull(r20, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r21 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r20, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r22 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r21, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r22.topToTop = 0;
        r22.bottomToBottom = 0;
        r19.setLayoutParams(r21);
        View r110 = (View) ZeusTransformUtils.preCheckCast(this.vLeftViewContainer, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r23 = r110.getLayoutParams();
        Objects.requireNonNull(r23, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r24 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r23, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r25 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r24, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r25.setMargins(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4), 0, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4));
        r25.topToTop = 0;
        r25.bottomToBottom = 0;
    L24:
        r110.setLayoutParams(r24);
        adjustInputViewAndLabel("setSingleLine");
        return;
    L22:
        r2 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        goto L23
    L18:
        r7 = 0;
        goto L19
    L10:
        r13 = 0;
        goto L11
    L25:
        o.a(this.vInputResizer, this.showResizer);
        this.vInput.setMaxLines(this.maxLines);
        this.vInput.setSingleLine(false);
        this.vInput.setPadding(getPaddingLeft(), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 2), getPaddingRight(), getPaddingBottom());
        this.vInput.setGravity(48);
        View r111 = (View) ZeusTransformUtils.preCheckCast(this.vInput, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r26 = r111.getLayoutParams();
        Objects.requireNonNull(r26, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r27 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r26, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r28 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r27, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r29 = ((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r29, ViewGroup.MarginLayoutParams.class) == true) goto L28;
        r29 = null;
    L28:
        ViewGroup.MarginLayoutParams r30 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r29, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L31;
        int r31 = r30.leftMargin;
    L32:
        ViewGroup.LayoutParams r112 = ((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r112, ViewGroup.MarginLayoutParams.class) == true) goto L35;
        r112 = null;
    L35:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r112, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L38;
        int r114 = r113.rightMargin;
    L39:
        r28.setMargins(r31, 0, r114, h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8));
        r28.goneTopMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
        if (this.showLabel == false) goto L42;
        int r32 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 16);
    L43:
        r28.goneLeftMargin = r32;
        r28.goneStartMargin = r28.goneLeftMargin;
        r111.setLayoutParams(r27);
        View r115 = this.vActionContainer;
        ViewGroup.LayoutParams r33 = r115.getLayoutParams();
        Objects.requireNonNull(r33, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r34 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r33, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r35 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r34, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r35.topToTop = 0;
        ViewGroup.LayoutParams r36 = ((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r36, ViewGroup.MarginLayoutParams.class) == true) goto L46;
        r36 = null;
    L46:
        ViewGroup.MarginLayoutParams r37 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r36, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r37 == null) goto L49;
        int r38 = r37.leftMargin;
    L50:
        int r39 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4);
        ViewGroup.LayoutParams r40 = ((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r40, ViewGroup.MarginLayoutParams.class) == true) goto L53;
        r40 = null;
    L53:
        ViewGroup.MarginLayoutParams r41 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r40, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r41 == null) goto L56;
        int r42 = r41.rightMargin;
    L57:
        ViewGroup.LayoutParams r116 = ((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin")).getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r116, ViewGroup.MarginLayoutParams.class) == false) goto L61;
        r5 = r116;
    L61:
        ViewGroup.MarginLayoutParams r43 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r5, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r43 == null) goto L64;
        int r44 = r43.bottomMargin;
    L65:
        r35.setMargins(r38, r39, r42, r44);
        r35.bottomToBottom = -1;
        r115.setLayoutParams(r34);
        View r117 = (View) ZeusTransformUtils.preCheckCast(this.vCustomActionContainer, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r45 = r117.getLayoutParams();
        Objects.requireNonNull(r45, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.LayoutParams r46 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r45, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r47 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r46, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r47.topToTop = 0;
        r47.bottomToBottom = 0;
        r117.setLayoutParams(r46);
        r110 = (View) ZeusTransformUtils.preCheckCast(this.vLeftViewContainer, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r48 = r110.getLayoutParams();
        Objects.requireNonNull(r48, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        r24 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r48, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintLayout.LayoutParams r49 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r24, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r49.setMargins(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4), h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 4), 0, 0);
        r49.topToTop = 0;
        r49.bottomToBottom = -1;
        goto L24
    L64:
        r44 = 0;
        goto L65
    L56:
        r42 = 0;
        goto L57
    L49:
        r38 = 0;
        goto L50
    L42:
        r32 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        goto L43
    L38:
        r114 = 0;
        goto L39
    L31:
        r31 = 0;
        goto L32
    }

    public final void setText(String r4) {
        this.vInput.setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"));
        adjustInputViewAndLabel("setText");
        doAfterTextStateChange(this.vInput.getText());
    }

    public final void showCommonTip(boolean r3) {
        o.a((View) ZeusTransformUtils.preCheckCast(this.vCommonTip, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void showErrorTip(boolean r3) {
        o.a((View) ZeusTransformUtils.preCheckCast(this.vErrorTip, View.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void updateClearVisibility(boolean r7) {
        boolean r0 = false;
        this.autoShowClear = false;
        o.a(this.vClear, r7);
        if (r7 == false) goto L5;
    L19:
        boolean r3 = false;
    L20:
        o.a((View) ZeusTransformUtils.preCheckCast(this.vEye, View.class, "com.obric.memorydata.plugin"), r3);
        View r4 = this.vComboArrow;
        if (r7 == false) goto L23;
    L25:
        boolean r8 = false;
    L26:
        o.a(r4, r8);
        View r9 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L29;
        boolean r5 = true;
    L30:
        if (r5 == false) goto L32;
    L41:
        r0 = true;
    L42:
        o.a(r9, r0);
        return;
    L32:
        if (((View) ZeusTransformUtils.preCheckCast(this.vEye, View.class, "com.obric.memorydata.plugin")).getVisibility() != 0) goto L34;
        boolean r1 = true;
    L35:
        if (r1 == true) goto L41;
        if (this.vComboArrow.getVisibility() != 0) goto L39;
        boolean r6 = true;
    L40:
        if (r6 == false) goto L42;
    L39:
        r6 = false;
        goto L40
    L34:
        r1 = false;
        goto L35
    L29:
        r5 = false;
        goto L30
    L23:
        if (this.inputMode != 1) goto L25;
        r8 = true;
        goto L26
    L5:
        if (isPasswordMode() == false) goto L19;
        if (this.isEnable == false) goto L19;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(this.vInput.getText(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L11;
    L14:
        boolean r11 = true;
    L15:
        if (r11 == true) goto L19;
        if (this.alwaysHideEye == true) goto L19;
        r3 = true;
        goto L20
    L11:
        if (r10.length() == 0) goto L14;
        r11 = false;
        goto L15
    }

    public final void updateLimitIndicator(String r9) {
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.vLimitIndicator, View.class, "com.obric.memorydata.plugin");
        if (this.showLimitIndicator == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        o.a(r0, r1);
        if (this.showLimitIndicator == true) goto L11;
        return;
    L11:
        if (this.limitCount <= 0) goto L18;
        int r10 = getConstraintLength((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        String r2 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_form_counter, TypedValues.Custom.S_STRING, "oui_form_counter"), new Object[]{String.valueOf(r10), String.valueOf(this.limitCount)});
        Intrinsics.checkNotNullExpressionValue(r2, "resources.getString(\n   ….toString()\n            )");
        SpannableString r3 = new SpannableString((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        if (r10 <= this.limitCount) goto L15;
        r3.setSpan(new ForegroundColorSpan(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.oui_functional_red_7, TypedValues.Custom.S_COLOR, "oui_functional_red_7"))), 0, String.valueOf(r10).length(), 18);
    L15:
        this.vLimitIndicator.setText((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), TextView.BufferType.SPANNABLE);
        return;
    L18:
        return;
    L5:
        if (this.limitCount <= 0) goto L7;
        r1 = true;
        goto L8
    }

    public final void updateResizerVisibility(boolean r2) {
        this.showResizer = r2;
        View r0 = this.vInputResizer;
        if (r2 == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        o.a(r0, r1);
        return;
    L5:
        if (this.singleLine == true) goto L7;
        r1 = true;
        goto L8
    }
}
