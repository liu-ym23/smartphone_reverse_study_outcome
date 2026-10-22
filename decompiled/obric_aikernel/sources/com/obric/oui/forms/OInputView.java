package com.obric.oui.forms;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewGroupKt;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.oui.common.util.k;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 é\u00012\u00020\u0001:\bê\u0001ë\u0001ì\u0001í\u0001B.\b\u0007\u0012\b\u0010ã\u0001\u001a\u00030â\u0001\u0012\f\b\u0002\u0010å\u0001\u001a\u0005\u0018\u00010ä\u0001\u0012\t\b\u0002\u0010æ\u0001\u001a\u00020\u0012¢\u0006\u0006\bç\u0001\u0010è\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J(\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J \u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J \u0010&\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020$H\u0002J\u0010\u0010)\u001a\u00020$2\u0006\u0010(\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u0012H\u0016J\u0012\u0010-\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\u0012\u00100\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0006\u00101\u001a\u00020\u0002J\u0010\u00104\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u000102J\u000e\u00106\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0012J\u000e\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0012J\u0006\u00109\u001a\u00020\u0012J\u000e\u0010<\u001a\u00020\u00022\u0006\u0010;\u001a\u00020:J\b\u0010=\u001a\u0004\u0018\u00010:J\u0010\u0010?\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u0007H\u0016J\u000e\u0010A\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u0007J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0007J\u000e\u0010D\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u0007J\u000e\u0010E\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0007J\u0010\u0010G\u001a\u00020\u00022\b\u0010F\u001a\u0004\u0018\u00010\rJ\u000e\u0010H\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0007J\u000e\u0010I\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0007J\u000e\u0010J\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0007J\u000e\u0010L\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u0012J\n\u0010M\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010O\u001a\u00020\u00022\b\u0010N\u001a\u0004\u0018\u00010\rJ\u0010\u0010Q\u001a\u00020\u00022\b\u0010P\u001a\u0004\u0018\u00010\rJ\u000e\u0010S\u001a\u00020\u00022\u0006\u0010R\u001a\u00020\u0007J)\u0010Z\u001a\u00020\u00022!\u0010Y\u001a\u001d\u0012\u0013\u0012\u00110U¢\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\u00020TJ)\u0010[\u001a\u00020\u00022!\u0010Y\u001a\u001d\u0012\u0013\u0012\u00110U¢\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020\u00020TJ\u000e\u0010]\u001a\u00020\u00022\u0006\u0010\\\u001a\u00020\u0012J\u000e\u0010_\u001a\u00020\u00022\u0006\u0010^\u001a\u00020\u0012J\u0010\u0010`\u001a\u00020\u00022\u0006\u0010^\u001a\u00020\u0012H\u0016J\u0006\u0010a\u001a\u00020\u0012J\u000e\u0010b\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0007J\u0010\u0010c\u001a\u00020\u00022\b\u0010N\u001a\u0004\u0018\u00010\rJ\u0010\u0010e\u001a\u00020\u00022\b\b\u0001\u0010d\u001a\u00020\u0012J\u000e\u0010f\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u0007J\u0010\u0010i\u001a\u00020\u00022\b\u0010h\u001a\u0004\u0018\u00010gJ\u0010\u0010k\u001a\u00020\u00022\b\u0010h\u001a\u0004\u0018\u00010jJ\u0010\u0010m\u001a\u00020\u00022\b\u0010l\u001a\u0004\u0018\u00010\rJ\u000e\u0010n\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0007J\u0010\u0010o\u001a\u00020\u00022\b\u0010l\u001a\u0004\u0018\u00010\rJ\u000e\u0010p\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0007J\u000e\u0010s\u001a\u00020\u00022\u0006\u0010r\u001a\u00020qJ\u0012\u0010v\u001a\u00020\u00072\b\u0010u\u001a\u0004\u0018\u00010tH\u0016J\u0012\u0010x\u001a\u00020\u00072\b\u0010w\u001a\u0004\u0018\u00010tH\u0016J\u0012\u0010y\u001a\u00020\u00072\b\u0010u\u001a\u0004\u0018\u00010tH\u0016J\n\u0010{\u001a\u0004\u0018\u00010zH\u0016J\u0012\u0010|\u001a\u00020\u00022\b\u0010h\u001a\u0004\u0018\u00010zH\u0016J\u0010\u0010\u007f\u001a\u00020\u00022\b\u0010~\u001a\u0004\u0018\u00010}J\u0011\u0010\u0080\u0001\u001a\u00020\u00022\b\u0010~\u001a\u0004\u0018\u00010}J\u0013\u0010\u0081\u0001\u001a\u00020\u00022\b\u0010h\u001a\u0004\u0018\u00010gH\u0016J\u0007\u0010\u0082\u0001\u001a\u00020\u0002J\u0007\u0010\u0083\u0001\u001a\u00020\u0002J\u0010\u0010\u0085\u0001\u001a\u00020\u00022\u0007\u0010\u0084\u0001\u001a\u00020\u0012J\u0010\u0010\u0087\u0001\u001a\u00020\u00022\u0007\u0010\u0086\u0001\u001a\u00020\u0007J\u001b\u0010\u008a\u0001\u001a\u00020\u00022\u0007\u0010\u0088\u0001\u001a\u00020\u00122\u0007\u0010\u0089\u0001\u001a\u00020\u0012H\u0014J6\u0010\u0090\u0001\u001a\u00020\u00022\u0007\u0010\u008b\u0001\u001a\u00020\u00072\u0007\u0010\u008c\u0001\u001a\u00020\u00122\u0007\u0010\u008d\u0001\u001a\u00020\u00122\u0007\u0010\u008e\u0001\u001a\u00020\u00122\u0007\u0010\u008f\u0001\u001a\u00020\u0012H\u0014R\u0019\u0010\u0091\u0001\u001a\u00020U8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0019\u0010\u0098\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0097\u0001R\u0019\u0010\u0099\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001a\u0010\u009c\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0019\u0010\u009e\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009a\u0001R\u001b\u0010\u009f\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u0019\u0010¡\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u0019\u0010£\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u009a\u0001R\u001b\u0010¤\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010 \u0001R\u001b\u0010¥\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u0019\u0010§\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010\u0097\u0001R\u001b\u0010¨\u0001\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u0019\u0010ª\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010\u0097\u0001R\u001a\u0010¬\u0001\u001a\u00030«\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0019\u0010®\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010\u0097\u0001R\u0019\u0010¯\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010\u0097\u0001R\u001a\u0010±\u0001\u001a\u00030°\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0019\u0010³\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010\u0097\u0001R\u0019\u0010´\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010\u0097\u0001R\u001a\u0010µ\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010\u0095\u0001R\u001b\u0010¶\u0001\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001b\u0010¸\u0001\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0019\u0010º\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010\u0097\u0001R\u0019\u0010P\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bP\u0010 \u0001R\u0019\u0010»\u0001\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¢\u0001R\u001b\u0010¼\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010 \u0001R\u0019\u0010½\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010\u0097\u0001R\u0019\u0010¾\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010\u009a\u0001R\u001b\u0010¿\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010 \u0001R\u001f\u0010Á\u0001\u001a\u00030À\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001R)\u0010Å\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÅ\u0001\u0010\u0097\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R\u0017\u00105\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b5\u0010\u009a\u0001R\u001b\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u001a\u0010Ì\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010\u009d\u0001R\u001b\u0010Í\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010Î\u0001R\u0019\u0010Ï\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010\u0097\u0001R\u001b\u0010Ð\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010Ñ\u0001R\u0019\u0010Ò\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010\u009a\u0001R\u001a\u0010Ô\u0001\u001a\u00030Ó\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u0017\u0010C\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bC\u0010\u0097\u0001R\u0019\u0010Ö\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010\u009a\u0001R\u0019\u0010×\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010\u009a\u0001R\u0019\u0010Ø\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010\u0097\u0001R\u001a\u0010Ù\u0001\u001a\u00030°\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÙ\u0001\u0010²\u0001R\u001a\u0010Ú\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÚ\u0001\u0010\u009d\u0001R\u0019\u0010Û\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010\u0097\u0001R\u001b\u0010Ü\u0001\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ë\u0001R\u0019\u0010Ý\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010\u0097\u0001R\u0019\u0010Þ\u0001\u001a\u00020U8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÞ\u0001\u0010\u0092\u0001R\u001a\u0010ß\u0001\u001a\u00030°\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bß\u0001\u0010²\u0001R\u001a\u0010à\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0001\u0010\u009d\u0001R\u0017\u0010p\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bp\u0010\u0097\u0001R\u001a\u0010á\u0001\u001a\u00030°\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bá\u0001\u0010²\u0001¨\u0006î\u0001"}, d2 = {"Lcom/obric/oui/forms/OInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "showSoftInput", "hideSoftInput", "updateClearVisibility", "updateEyeVisibility", "", "isPasswordMode", "focus", "updateBorder", "pressed", "updateBackground", "", "scene", "adjustInputViewAndLabel", "hasFocus", "playLabelAnim", "", "labelTextColor", "inputHintTextColor", "", "duration", "Landroid/animation/ValueAnimator;", "genLabelShowAnim", "genLabelHideAnim", "Lcom/obric/oui/forms/OInputView$LabelUIState;", "state", "Landroid/widget/TextView;", "fakeLabel", "updateLabelUIState", "showNoLabel", "showRealLabel", "showFakeLabel", "startColor", "endColor", "", "ratio", "blendColors", "getFakeInputOffsetY", "vFakeInput", "getScaleRatio", "getContentViewRes", "", "s", "getConstraintLength", "Landroid/text/Editable;", "editable", "doAfterTextStateChange", "setAutoHideSoft", "Landroid/text/method/KeyListener;", "keyListener", "setKeyListener", "radius", "setRadius", WsConstants.KEY_CONNECTION_TYPE, "setInputType", "getInputType", "Lcom/obric/oui/forms/OEditText$a;", "commitCompletionListener", "setCommitCompletionListener", "getCommitCompletionListener", "enabled", "setEnabled", "error", "setErrorState", "show", "inScrollableView", "setIsInScrollableView", "updateResizerVisibility", "label", "setLabel", "setShowLabel", "setShowLabelAnim", "setShowLabelIcon", "height", "setInputHeight", "getText", "text", "setText", "hint", "setHint", "single", "setSingleLine", "Lkotlin/Function1;", "Landroid/widget/FrameLayout;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "parent", "creator", "setLeftView", "setActionView", "max", "setMaxLines", "limit", "setLimitCountValue", "setLimitCount", "getLimitCount", "setShowLimitIndicator", "updateLimitIndicator", "mode", "setInputMode", "setComboInputEnabled", "Landroid/view/View$OnClickListener;", "l", "setOnComboArrowClickListener", "Lcom/obric/oui/forms/OInputView$f;", "setOnTextExceedLengthListener", "tip", "setErrorTip", "showErrorTip", "setCommonTip", "showCommonTip", "Lcom/obric/oui/forms/OInputView$e;", "listener", "setOnTextClearedListener", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", NotificationCompat.CATEGORY_EVENT, "onTouchEvent", "dispatchTouchEvent", "Landroid/view/View$OnFocusChangeListener;", "getOnFocusChangeListener", "setOnFocusChangeListener", "Landroid/text/TextWatcher;", "watcher", "addTextChangedListener", "removeTextChangedListener", "setOnClickListener", "enableTransparentBg", "enableTransparentBorder", "resId", "setBgResId", "hide", "setAlwaysHideEye", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "vLeftViewContainer", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "vTitleIcon", "Landroid/widget/ImageView;", "comboInputEnabled", "Z", "showLabelIcon", "bgResId", "I", "Landroid/view/View;", "vClear", "Landroid/view/View;", "inputType", "initText", "Ljava/lang/String;", "lastScrollY", "F", "inputMode", "commonTip", "digits", "Ljava/lang/CharSequence;", "alwaysHideEye", "onTextClearedListener", "Lcom/obric/oui/forms/OInputView$e;", "showLabelAnim", "Lcom/obric/oui/layout/OUIConstraintLayout;", "vBorderContainer", "Lcom/obric/oui/layout/OUIConstraintLayout;", "shouldDispatchToInput", "autoShowClear", "Lcom/obric/oui/text/OTextView;", "vLimitIndicator", "Lcom/obric/oui/text/OTextView;", "showResizer", "isEnable", "vEye", "inputHeight", "Ljava/lang/Integer;", "onTextExceedLengthListener", "Lcom/obric/oui/forms/OInputView$f;", "showLabel", "lastScrollX", "insideLabel", "singleLine", "maxLines", "errorTip", "Lcom/obric/oui/forms/OEditText;", "vInput", "Lcom/obric/oui/forms/OEditText;", "getVInput", "()Lcom/obric/oui/forms/OEditText;", "autoHideSoftInputWhenLoseFocus", "getAutoHideSoftInputWhenLoseFocus", "()Z", "setAutoHideSoftInputWhenLoseFocus", "(Z)V", "labelShowAnimator", "Landroid/animation/ValueAnimator;", "vActionContainer", "vFakeLabel", "Landroid/widget/TextView;", "transparentBorder", "onComboArrowClickListener", "Landroid/view/View$OnClickListener;", "orientation", "Landroid/widget/LinearLayout;", "vTitleContainer", "Landroid/widget/LinearLayout;", "gravity", "limitCount", "transparentBg", "vErrorTip", "vInputResizer", "isError", "labelHideAnimator", "showLimitIndicator", "vCustomActionContainer", "vCommonTip", "vComboArrow", "vTitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "d", "LabelUIState", "e", "f", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
@SuppressLint({"ClickableViewAccessibility"})
public class OInputView extends ConstraintLayout {
    public static final d Companion = null;
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
    private e onTextClearedListener;
    private f onTextExceedLengthListener;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/forms/OInputView$LabelUIState;", "", "<init>", "(Ljava/lang/String;I)V", "REAL_LABEL_SHOW", "FAKE_LABEL_SHOW", "LABEL_NONE", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LabelUIState extends Enum<LabelUIState> {
        private static final /* synthetic */ LabelUIState[] $VALUES = null;
        public static final LabelUIState FAKE_LABEL_SHOW = null;
        public static final LabelUIState LABEL_NONE = null;
        public static final LabelUIState REAL_LABEL_SHOW = null;

        static {
            LabelUIState r10 = new LabelUIState("REAL_LABEL_SHOW", 0);
            REAL_LABEL_SHOW = r10;
            LabelUIState r11 = new LabelUIState("FAKE_LABEL_SHOW", 1);
            FAKE_LABEL_SHOW = r11;
            LabelUIState r12 = new LabelUIState("LABEL_NONE", 2);
            LABEL_NONE = r12;
            $VALUES = new LabelUIState[]{r10, r11, r12};
        }

        private LabelUIState(String r10, int r11) {
            super(r10, r11);
        }

        public static LabelUIState valueOf(String r10) {
            return (LabelUIState) Enum.valueOf(LabelUIState.class, r10);
        }

        public static LabelUIState[] values() {
            return (LabelUIState[]) $VALUES.clone();
        }
    }

    static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInputView f6605c;

        a(OInputView r10) {
            this.f6605c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            e r11 = OInputView.access$getOnTextClearedListener$p(this.f6605c);
            if (r11 == null) goto L9;
            Editable r12 = this.f6605c.getVInput().getText();
            if (r12 == null) goto L7;
            String r13 = r12.toString();
        L8:
            r11.b(r13);
            goto L9
        L7:
            r13 = null;
        L9:
            this.f6605c.setText("");
            e r14 = OInputView.access$getOnTextClearedListener$p(this.f6605c);
            if (r14 == null) goto L12;
            r14.a();
        L12:
            OInputView.access$updateClearVisibility(this.f6605c);
        }
    }

    static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInputView f6606c;

        b(OInputView r10) {
            this.f6606c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            if (OInputView.access$getInputType$p(this.f6606c) != this.f6606c.getVInput().getInputType()) goto L5;
            OInputView.access$getVEye$p(this.f6606c).setImageResource(u8.e.o_input_view_eyes_open);
            OEditText r11 = this.f6606c.getVInput();
            int r12 = this.f6606c.getVInput().getInputType() | 144;
        L6:
            r11.setInputType(r12);
            if (this.f6606c.getVInput().hasFocus() == false) goto L14;
            OEditText r13 = this.f6606c.getVInput();
            Editable r14 = this.f6606c.getVInput().getText();
            if (r14 == null) goto L11;
            int r15 = r14.length();
        L12:
            r13.setSelection(r15);
            return;
        L11:
            r15 = 0;
            goto L12
        L14:
            return;
        L5:
            OInputView.access$getVEye$p(this.f6606c).setImageResource(u8.e.o_input_view_eyes_close);
            r11 = this.f6606c.getVInput();
            r12 = OInputView.access$getInputType$p(this.f6606c);
            goto L6
        }
    }

    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInputView f6607c;

        c(OInputView r10) {
            this.f6607c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.f6607c.getVInput().requestFocus();
            if (this.f6607c.getVInput().hasFocus() == true) goto L5;
        L7:
            OInputView.access$showSoftInput(this.f6607c);
            return;
        L5:
            if (this.f6607c.getVInput().isCursorVisible() == true) goto L7;
            this.f6607c.getVInput().setCursorVisible(true);
            goto L7
        }
    }

    public static final class d {
        private d() {
        }

        public /* synthetic */ d(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface e {
        void a();

        void b(String r10);
    }

    public interface f {
        void a(String r10);
    }

    static final class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInputView f6608c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f6609g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f6610h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f6611i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ float f6612j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ TextView f6613k;

        g(OInputView r10, float r11, int r12, int r13, float r14, TextView r15) {
            this.f6608c = r10;
            this.f6609g = r11;
            this.f6610h = r12;
            this.f6611i = r13;
            this.f6612j = r14;
            this.f6613k = r15;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            Object r11 = r10.getAnimatedValue();
            Objects.requireNonNull(r11, "null cannot be cast to non-null type kotlin.Float");
            float r12 = ((Float) r11).floatValue();
            float r13 = this.f6609g;
            float r14 = r13 + ((0 - r13) * r12);
            int r15 = OInputView.access$blendColors(this.f6608c, this.f6610h, this.f6611i, r12);
            float r16 = this.f6612j;
            float r17 = r16 + ((1.0f - r16) * r12);
            this.f6613k.setTextColor(r15);
            this.f6613k.setScaleX(r17);
            this.f6613k.setScaleY(r17);
            this.f6613k.setTranslationY(r14);
            ea.b.i(OInputView.TAG, "progress: " + r12 + ", transY: " + r14 + ", scale: " + r17);
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInputView f6614c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ TextView f6615g;

        h(OInputView r10, TextView r11) {
            this.f6614c = r10;
            this.f6615g = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            if (this.f6614c.getVInput().hasFocus() == false) goto L5;
            OInputView r11 = this.f6614c;
            LabelUIState r12 = LabelUIState.REAL_LABEL_SHOW;
        L6:
            OInputView.access$updateLabelUIState(r11, r12, this.f6615g, "LabelHideAnim, onAnimationCancel");
            return;
        L5:
            r11 = this.f6614c;
            r12 = LabelUIState.FAKE_LABEL_SHOW;
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            if (this.f6614c.getVInput().hasFocus() == false) goto L5;
            OInputView r11 = this.f6614c;
            LabelUIState r12 = LabelUIState.REAL_LABEL_SHOW;
        L6:
            OInputView.access$updateLabelUIState(r11, r12, this.f6615g, "LabelHideAnim, onAnimationCancel");
            return;
        L5:
            r11 = this.f6614c;
            r12 = LabelUIState.FAKE_LABEL_SHOW;
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            OInputView.access$updateLabelUIState(this.f6614c, LabelUIState.FAKE_LABEL_SHOW, this.f6615g, "LabelHideAnim, onAnimationStart");
        }
    }

    static final class i implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInputView f6616c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ float f6617g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f6618h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f6619i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ float f6620j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ TextView f6621k;

        i(OInputView r10, float r11, int r12, int r13, float r14, TextView r15) {
            this.f6616c = r10;
            this.f6617g = r11;
            this.f6618h = r12;
            this.f6619i = r13;
            this.f6620j = r14;
            this.f6621k = r15;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            Object r11 = r10.getAnimatedValue();
            Objects.requireNonNull(r11, "null cannot be cast to non-null type kotlin.Float");
            float r12 = ((Float) r11).floatValue();
            float r13 = 0;
            float r14 = r13 + ((this.f6617g - r13) * r12);
            int r15 = OInputView.access$blendColors(this.f6616c, this.f6618h, this.f6619i, r12);
            float r16 = ((this.f6620j - 1.0f) * r12) + 1.0f;
            this.f6621k.setTextColor(r15);
            this.f6621k.setScaleX(r16);
            this.f6621k.setScaleY(r16);
            this.f6621k.setTranslationY(r14);
            ea.b.i(OInputView.TAG, "progress: " + r12 + ", transY: " + r14 + ", scale: " + r16);
        }
    }

    public static final class j extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OInputView f6622c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ TextView f6623g;

        j(OInputView r10, TextView r11) {
            this.f6622c = r10;
            this.f6623g = r11;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            if (this.f6622c.getVInput().hasFocus() == false) goto L5;
            OInputView r11 = this.f6622c;
            LabelUIState r12 = LabelUIState.REAL_LABEL_SHOW;
        L6:
            OInputView.access$updateLabelUIState(r11, r12, this.f6623g, "LabelShowAnim, onAnimationCancel");
            return;
        L5:
            r11 = this.f6622c;
            r12 = LabelUIState.FAKE_LABEL_SHOW;
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            if (this.f6622c.getVInput().hasFocus() == false) goto L5;
            OInputView r11 = this.f6622c;
            LabelUIState r12 = LabelUIState.REAL_LABEL_SHOW;
        L6:
            OInputView.access$updateLabelUIState(r11, r12, this.f6623g, "LabelShowAnim, onAnimationCancel");
            return;
        L5:
            r11 = this.f6622c;
            r12 = LabelUIState.FAKE_LABEL_SHOW;
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "animation");
            OInputView.access$updateLabelUIState(this.f6622c, LabelUIState.FAKE_LABEL_SHOW, this.f6623g, "LabelShowAnim, onAnimationStart");
        }
    }

    static {
        Companion = new d(null);
    }

    @JvmOverloads
    public OInputView(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OInputView(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OInputView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        int r13 = 1;
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
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        this.radius = MathKt.roundToInt(TypedValue.applyDimension(1, 10, r14.getDisplayMetrics()));
        TypedArray r15 = r10.getTheme().obtainStyledAttributes(r11, l.OInputView, r12, 0);
        this.inScrollableView = r15.getBoolean(l.OInputView_oui_inputInScrollableView, false);
        this.autoShowClear = r15.getBoolean(l.OInputView_oui_autoShowClear, true);
        this.showResizer = r15.getBoolean(l.OInputView_oui_showResizer, true);
        this.showLabel = r15.getBoolean(l.OInputView_oui_showLabel, true);
        this.showLabelAnim = r15.getBoolean(l.OInputView_oui_showLabelAnim, false);
        this.showLabelIcon = r15.getBoolean(l.OInputView_oui_showLabelIcon, true);
        this.insideLabel = r15.getString(l.OInputView_oui_inputLabel);
        this.errorTip = r15.getString(l.OInputView_oui_errorTip);
        this.commonTip = r15.getString(l.OInputView_oui_commonTip);
        this.showCommonTip = r15.getBoolean(l.OInputView_oui_showCommonTip, false);
        this.radius = r15.getDimensionPixelSize(l.OInputView_oui_inputBorderRadius, this.radius);
        this.comboInputEnabled = r15.getBoolean(l.OInputView_oui_comboInputEnabled, true);
        this.inputMode = r15.getInt(l.OInputView_oui_inputMode, 0);
        this.singleLine = r15.getBoolean(l.OInputView_oui_inputSingleLine, true);
        int r16 = r15.getDimensionPixelSize(l.OInputView_oui_inputHeight, 0);
        if (r16 <= 0) goto L5;
        this.inputHeight = Integer.valueOf(r16);
    L5:
        this.limitCount = r15.getInt(l.OInputView_oui_limitCount, -1);
        this.showLimitIndicator = r15.getBoolean(l.OInputView_oui_showLimitIndicator, false);
        this.digits = r15.getText(l.OInputView_android_digits);
        this.hint = r15.getString(l.OInputView_android_hint);
        this.inputType = r15.getInt(l.OInputView_android_inputType, 0);
        this.initText = r15.getString(l.OInputView_android_text);
        this.isEnable = r15.getBoolean(l.OInputView_android_enabled, true);
        this.maxLines = r15.getInt(l.OInputView_android_maxLines, Integer.MAX_VALUE);
        this.orientation = r15.getInt(l.OInputView_android_orientation, 0);
        this.gravity = r15.getInt(l.OInputView_android_gravity, 16);
        r15.recycle();
        LayoutInflater.from(r10).inflate(getContentViewRes(), this);
        View r17 = findViewById(u8.f.o_input_border_container);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.o_input_border_container)");
        OUIConstraintLayout r18 = (OUIConstraintLayout) r17;
        this.vBorderContainer = r18;
        r18.setRadius(this.radius);
        View r19 = findViewById(u8.f.o_input_title_container);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.o_input_title_container)");
        this.vTitleContainer = (LinearLayout) r19;
        View r20 = findViewById(u8.f.o_input_title);
        Intrinsics.checkNotNullExpressionValue(r20, "findViewById(R.id.o_input_title)");
        this.vTitle = (OTextView) r20;
        View r21 = findViewById(u8.f.o_input_title_icon);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.o_input_title_icon)");
        this.vTitleIcon = (ImageView) r21;
        View r22 = findViewById(u8.f.o_input);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.o_input)");
        OEditText r23 = (OEditText) r22;
        this.vInput = r23;
        r23.setVerticalScrollBarEnabled(false);
        View r110 = findViewById(u8.f.o_input_left_view_container);
        Intrinsics.checkNotNullExpressionValue(r110, "findViewById(R.id.o_input_left_view_container)");
        this.vLeftViewContainer = (FrameLayout) r110;
        View r111 = findViewById(u8.f.o_input_custom_action_container);
        Intrinsics.checkNotNullExpressionValue(r111, "findViewById(R.id.o_input_custom_action_container)");
        this.vCustomActionContainer = (FrameLayout) r111;
        View r112 = findViewById(u8.f.o_input_action_container);
        Intrinsics.checkNotNullExpressionValue(r112, "findViewById(R.id.o_input_action_container)");
        this.vActionContainer = r112;
        View r113 = findViewById(u8.f.o_input_clear);
        Intrinsics.checkNotNullExpressionValue(r113, "findViewById(R.id.o_input_clear)");
        this.vClear = r113;
        View r24 = findViewById(u8.f.o_input_combo_arrow);
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.o_input_combo_arrow)");
        this.vComboArrow = r24;
        View r25 = findViewById(u8.f.o_input_eyes_slash);
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.o_input_eyes_slash)");
        ImageView r26 = (ImageView) r25;
        this.vEye = r26;
        View r27 = findViewById(u8.f.o_input_resizer);
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.o_input_resizer)");
        this.vInputResizer = r27;
        View r28 = findViewById(u8.f.o_input_error_tip);
        Intrinsics.checkNotNullExpressionValue(r28, "findViewById(R.id.o_input_error_tip)");
        this.vErrorTip = (OTextView) r28;
        View r29 = findViewById(u8.f.o_input_common_tip);
        Intrinsics.checkNotNullExpressionValue(r29, "findViewById(R.id.o_input_common_tip)");
        this.vCommonTip = (OTextView) r29;
        View r30 = findViewById(u8.f.o_input_limit_indicator);
        Intrinsics.checkNotNullExpressionValue(r30, "findViewById(R.id.o_input_limit_indicator)");
        this.vLimitIndicator = (OTextView) r30;
        this.vFakeLabel = (TextView) findViewById(u8.f.o_input_view_fake_label);
        setFocusableInTouchMode(true);
        setFocusable(true);
        setDescendantFocusability(262144);
        CharSequence r31 = this.digits;
        if (r31 == null) goto L11;
        r23.setKeyListener(DigitsKeyListener.getInstance(String.valueOf(r31)));
        int r32 = this.inputType;
        if (r32 == 0) goto L10;
        r13 = r32;
    L10:
        this.inputType = r13;
    L11:
        r23.setGravity(this.gravity);
        Integer r33 = this.inputHeight;
        if (r33 == null) goto L14;
        setInputHeight(r33.intValue());
    L14:
        r23.onFocusChange$OUI_standardRelease(new AnonymousClass3(this));
        r23.onOnTouchEvent$OUI_standardRelease(new AnonymousClass4(this));
        r23.onTextChanged$OUI_standardRelease(new AnonymousClass5(this));
        r23.afterTextChanged$OUI_standardRelease(new AnonymousClass6(this));
        r113.setOnClickListener(new a(this));
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
        setHint(this.hint);
        setText(this.initText);
        setInputMode(this.inputMode);
        setEnabled(this.isEnable);
        updateClearVisibility();
        updateBorder(r23.hasFocus());
        int r34 = this.inputType;
        if (r34 == 0) goto L17;
        setInputType(r34);
    L17:
        updateEyeVisibility();
        r26.setOnClickListener(new b(this));
        r18.setOnClickListener(new c(this));
        adjustInputViewAndLabel(CommonConsts.APM_INNER_EVENT_COST_INIT);
    }

    public /* synthetic */ OInputView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ int access$blendColors(OInputView r10, int r11, int r12, float r13) {
        return r10.blendColors(r11, r12, r13);
    }

    public static final /* synthetic */ int access$getInputType$p(OInputView r10) {
        return r10.inputType;
    }

    public static final /* synthetic */ int access$getLimitCount$p(OInputView r10) {
        return r10.limitCount;
    }

    public static final /* synthetic */ e access$getOnTextClearedListener$p(OInputView r10) {
        return r10.onTextClearedListener;
    }

    public static final /* synthetic */ f access$getOnTextExceedLengthListener$p(OInputView r10) {
        return r10.onTextExceedLengthListener;
    }

    public static final /* synthetic */ boolean access$getShowCommonTip$p(OInputView r10) {
        return r10.showCommonTip;
    }

    public static final /* synthetic */ ImageView access$getVEye$p(OInputView r10) {
        return r10.vEye;
    }

    public static final /* synthetic */ void access$hideSoftInput(OInputView r10) {
        r10.hideSoftInput();
    }

    public static final /* synthetic */ boolean access$isError$p(OInputView r10) {
        return r10.isError;
    }

    public static final /* synthetic */ void access$playLabelAnim(OInputView r10, boolean r11) {
        r10.playLabelAnim(r11);
    }

    public static final /* synthetic */ void access$setError$p(OInputView r10, boolean r11) {
        r10.isError = r11;
    }

    public static final /* synthetic */ void access$setInputType$p(OInputView r10, int r11) {
        r10.inputType = r11;
    }

    public static final /* synthetic */ void access$setLimitCount$p(OInputView r10, int r11) {
        r10.limitCount = r11;
    }

    public static final /* synthetic */ void access$setOnTextClearedListener$p(OInputView r10, e r11) {
        r10.onTextClearedListener = r11;
    }

    public static final /* synthetic */ void access$setOnTextExceedLengthListener$p(OInputView r10, f r11) {
        r10.onTextExceedLengthListener = r11;
    }

    public static final /* synthetic */ void access$setShowCommonTip$p(OInputView r10, boolean r11) {
        r10.showCommonTip = r11;
    }

    public static final /* synthetic */ void access$showSoftInput(OInputView r10) {
        r10.showSoftInput();
    }

    public static final /* synthetic */ void access$updateBackground(OInputView r10, boolean r11) {
        r10.updateBackground(r11);
    }

    public static final /* synthetic */ void access$updateBorder(OInputView r10, boolean r11) {
        r10.updateBorder(r11);
    }

    public static final /* synthetic */ void access$updateClearVisibility(OInputView r10) {
        r10.updateClearVisibility();
    }

    public static final /* synthetic */ void access$updateEyeVisibility(OInputView r10) {
        r10.updateEyeVisibility();
    }

    public static final /* synthetic */ void access$updateLabelUIState(OInputView r10, LabelUIState r11, TextView r12, String r13) {
        r10.updateLabelUIState(r11, r12, r13);
    }

    private final void adjustInputViewAndLabel(String r10) {
        if (this.showLabelAnim == true) goto L5;
        return;
    L5:
        TextView r11 = this.vFakeLabel;
        if (r11 != null) goto L8;
        return;
    L8:
        if (this.showLabel == true) goto L12;
        this.vInput.setHint(this.hint);
        LabelUIState r12 = LabelUIState.LABEL_NONE;
        StringBuilder r13 = new StringBuilder();
        r13.append("adjustInputViewAndLabel, ");
        r13.append(r10);
        String r14 = ", no label";
    L10:
        r13.append(r14);
        updateLabelUIState(r12, r11, r13.toString());
        return;
    L12:
        if (this.singleLine == true) goto L14;
        this.vInput.setHint(this.hint);
        r12 = LabelUIState.REAL_LABEL_SHOW;
        r13 = new StringBuilder();
        r13.append("adjustInputViewAndLabel, ");
        r13.append(r10);
        r14 = ", can not show label anim";
        goto L10
    L14:
        this.vInput.setHint("");
        r11.setText(this.insideLabel);
        Editable r15 = this.vInput.getText();
        if (r15 != null) goto L17;
    L20:
        boolean r16 = true;
    L21:
        if (r16 == true) goto L23;
        r12 = LabelUIState.REAL_LABEL_SHOW;
        r13 = new StringBuilder();
        r13.append("adjustInputViewAndLabel, ");
        r13.append(r10);
        r14 = ", can show label anim, vInput.text not empty";
        goto L10
    L23:
        if (this.vInput.hasFocus() == false) goto L25;
        r12 = LabelUIState.REAL_LABEL_SHOW;
        r13 = new StringBuilder();
        r13.append("adjustInputViewAndLabel, ");
        r13.append(r10);
        r14 = ", can show label anim, vInput.text empty, focused";
        goto L10
    L25:
        r12 = LabelUIState.FAKE_LABEL_SHOW;
        r13 = new StringBuilder();
        r13.append("adjustInputViewAndLabel, ");
        r13.append(r10);
        r14 = ", can show label anim, vInput.text empty, not focused";
        goto L10
    L17:
        if (r15.length() == 0) goto L20;
        r16 = false;
        goto L21
    }

    private final int blendColors(int r10, int r11, float r12) {
        return ColorUtils.blendARGB(r10, r11, RangesKt.coerceIn(r12, 0.0f, 1.0f));
    }

    private final ValueAnimator genLabelHideAnim(int r10, int r11, long r12) {
        TextView r13 = this.vFakeLabel;
        if (r13 == null) goto L6;
        float r14 = getFakeInputOffsetY();
        float r15 = getScaleRatio(r13);
        r13.setPivotX(0.0f);
        r13.setPivotY(-r14);
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        Intrinsics.checkNotNullExpressionValue(r16, "animator");
        r16.setDuration(r12);
        r16.setInterpolator(new DecelerateInterpolator());
        r16.addUpdateListener(new g(this, r14, r10, r11, r15, r13));
        r16.addListener(new h(this, r13));
        return r16;
    L6:
        return null;
    }

    static /* synthetic */ ValueAnimator genLabelHideAnim$default(OInputView r10, int r11, int r12, long r13, int r14, Object r15) {
        if (r15 != null) goto L15;
        if ((r14 & 1) == 0) goto L7;
        r11 = ContextCompat.getColor(r10.getContext(), u8.c.oui_text_3);
    L7:
        if ((r14 & 2) == 0) goto L10;
        r12 = ContextCompat.getColor(r10.getContext(), u8.c.oui_text_4);
    L10:
        if ((r14 & 4) == 0) goto L13;
        r13 = LABEL_ANIM_DURATION;
    L13:
        return r10.genLabelHideAnim(r11, r12, r13);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genLabelHideAnim");
    }

    private final ValueAnimator genLabelShowAnim(int r10, int r11, long r12) {
        TextView r13 = this.vFakeLabel;
        if (r13 == null) goto L6;
        float r14 = getFakeInputOffsetY();
        float r15 = getScaleRatio(r13);
        r13.setPivotX(0.0f);
        r13.setPivotY(-r14);
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        Intrinsics.checkNotNullExpressionValue(r16, "animator");
        r16.setDuration(r12);
        r16.setInterpolator(new DecelerateInterpolator());
        r16.addUpdateListener(new i(this, r14, r11, r10, r15, r13));
        r16.addListener(new j(this, r13));
        return r16;
    L6:
        return null;
    }

    static /* synthetic */ ValueAnimator genLabelShowAnim$default(OInputView r10, int r11, int r12, long r13, int r14, Object r15) {
        if (r15 != null) goto L15;
        if ((r14 & 1) == 0) goto L7;
        r11 = ContextCompat.getColor(r10.getContext(), u8.c.oui_text_3);
    L7:
        if ((r14 & 2) == 0) goto L10;
        r12 = ContextCompat.getColor(r10.getContext(), u8.c.oui_text_4);
    L10:
        if ((r14 & 4) == 0) goto L13;
        r13 = LABEL_ANIM_DURATION;
    L13:
        return r10.genLabelShowAnim(r11, r12, r13);
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genLabelShowAnim");
    }

    private final float getFakeInputOffsetY() {
        if (this.vTitleContainer.getHeight() > 0) goto L5;
    L7:
        ea.b.j(TAG, "getFakeInputOffsetY, use default offset, vTitleContainer.height: " + this.vTitleContainer.getHeight() + ", height: " + getHeight());
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        float r11 = TypedValue.applyDimension(1, FAKE_LABEL_OFFSET_Y, r10.getDisplayMetrics());
    L8:
        ea.b.a(TAG, "getFakeInputOffsetY, offsetY: " + r11);
        return r11;
    L5:
        if (getHeight() <= 0) goto L7;
        r11 = (this.vTitleContainer.getY() + (this.vTitleContainer.getHeight() / 2.0f)) - (getHeight() / 2.0f);
        goto L8
    }

    private final float getScaleRatio(TextView r10) {
        float r11 = 0;
        if (this.vTitle.getTextSize() > r11) goto L5;
    L7:
        ea.b.j(TAG, "getScaleRatio, use default scale, vTitle.textSize: " + this.vTitle.getTextSize() + ", vFakeInput.textSize: " + r10.getTextSize());
        float r12 = FAKE_LABEL_TARGET_SCALE;
    L8:
        ea.b.a(TAG, "getScaleRatio, scale: " + r12);
        return r12;
    L5:
        if (r10.getTextSize() <= r11) goto L7;
        r12 = this.vTitle.getTextSize() / r10.getTextSize();
        goto L8
    }

    private final void hideSoftInput() {
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == true) goto L5;
        r10 = null;
    L5:
        InputMethodManager r11 = (InputMethodManager) r10;
        if (r11 == null) goto L9;
        r11.hideSoftInputFromWindow(this.vInput.getWindowToken(), 0);
        return;
    }

    private final boolean isPasswordMode() {
        int r10 = this.inputType & 4095;
        if (r10 != 129) goto L5;
        boolean r11 = true;
    L7:
        if (r10 != 225) goto L9;
        boolean r12 = true;
    L11:
        if (r10 != 18) goto L13;
        boolean r13 = true;
    L14:
        if (r11 == true) goto L20;
        if (r12 == true) goto L21;
        if (r13 == false) goto L19;
        return true;
    L19:
        return false;
    L21:
        return true;
    L20:
        return true;
    L13:
        r13 = false;
        goto L14
    L9:
        r12 = false;
        goto L11
    L5:
        r11 = false;
        goto L7
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
        Editable r11 = this.vInput.getText();
        if (r11 != null) goto L17;
    L20:
        boolean r12 = true;
    L21:
        if (r12 == true) goto L25;
        LabelUIState r13 = LabelUIState.REAL_LABEL_SHOW;
        TextView r14 = this.vFakeLabel;
        Intrinsics.checkNotNull(r14);
        updateLabelUIState(r13, r14, "playLabelAnim, hasFocus: " + r10);
        return;
    L25:
        if (r10 == false) goto L45;
        ValueAnimator r15 = this.labelHideAnimator;
        if (r15 == null) goto L29;
        r15.cancel();
    L29:
        ValueAnimator r16 = this.labelHideAnimator;
        if (r16 == null) goto L32;
        r16.removeAllUpdateListeners();
    L32:
        ValueAnimator r17 = this.labelHideAnimator;
        if (r17 == null) goto L35;
        r17.removeAllListeners();
    L35:
        ValueAnimator r18 = this.labelShowAnimator;
        if (r18 != null) goto L38;
    L41:
        ValueAnimator r19 = genLabelShowAnim$default(this, 0, 0, 0, 7, null);
        this.labelShowAnimator = r19;
        if (r19 == null) goto L44;
        r19.start();
    L44:
        String r20 = "start label show anim";
    L65:
        ea.b.a(TAG, r20);
        return;
    L38:
        if (r18.isRunning() != true) goto L41;
        String r21 = "label show anim is running, do nothing";
    L60:
        ea.b.j(TAG, r21);
        return;
    L45:
        ValueAnimator r22 = this.labelShowAnimator;
        if (r22 == null) goto L48;
        r22.cancel();
    L48:
        ValueAnimator r23 = this.labelShowAnimator;
        if (r23 == null) goto L51;
        r23.removeAllUpdateListeners();
    L51:
        ValueAnimator r24 = this.labelShowAnimator;
        if (r24 == null) goto L54;
        r24.removeAllListeners();
    L54:
        ValueAnimator r25 = this.labelHideAnimator;
        if (r25 != null) goto L57;
    L61:
        ValueAnimator r26 = genLabelHideAnim$default(this, 0, 0, 0, 7, null);
        this.labelHideAnimator = r26;
        if (r26 == null) goto L64;
        r26.start();
    L64:
        r20 = "start label hide anim";
        goto L65
    L57:
        if (r25.isRunning() != true) goto L61;
        r21 = "label hide anim is running, do nothing";
        goto L60
    L17:
        if (r11.length() == 0) goto L20;
        r12 = false;
        goto L21
    }

    private final void showFakeLabel(TextView r10) {
        this.vTitleContainer.setVisibility(4);
        r10.setVisibility(0);
        this.vInput.setAlpha(0.0f);
    }

    private final void showNoLabel(TextView r10) {
        this.vTitleContainer.setVisibility(8);
        r10.setVisibility(8);
        this.vInput.setAlpha(1.0f);
    }

    private final void showRealLabel(TextView r10) {
        this.vTitleContainer.setVisibility(0);
        r10.setVisibility(8);
        this.vInput.setAlpha(1.0f);
    }

    private final void showSoftInput() {
        Object r10 = getContext().getSystemService("input_method");
        if ((r10 instanceof InputMethodManager) == true) goto L5;
        r10 = null;
    L5:
        InputMethodManager r11 = (InputMethodManager) r10;
        if (r11 == null) goto L9;
        r11.showSoftInput(this.vInput, 0);
        return;
    }

    private final void updateBackground(boolean r10) {
        int r11 = this.bgResId;
        if (r11 == 0) goto L7;
        this.vBorderContainer.setBackgroundResource(r11);
        return;
    L7:
        if (this.transparentBg == false) goto L11;
        this.vBorderContainer.setBackgroundResource(u8.c.Transparent);
        return;
    L11:
        if (this.isEnable == true) goto L13;
    L12:
        int r12 = u8.e.o_input_view_pressed_background;
    L19:
        this.vBorderContainer.setBackgroundResource(r12);
        return;
    L13:
        if (r10 == true) goto L12;
        if (this.vInput.hasFocus() == false) goto L18;
        r12 = u8.e.o_input_view_focused_background;
        goto L19
    L18:
        r12 = u8.e.o_input_view_normal_background;
        goto L19
    }

    private final void updateBorder(boolean r10) {
        int r11 = 0;
        if (this.transparentBorder == false) goto L7;
        this.vBorderContainer.setBorderWidth(0);
        this.vBorderContainer.setBorderColor(ContextCompat.getColor(getContext(), u8.c.Transparent));
        return;
    L7:
        if (this.isEnable == true) goto L10;
    L8:
        float r12 = 0;
    L9:
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        this.vBorderContainer.setBorderWidth(MathKt.roundToInt(TypedValue.applyDimension(1, r12, r13.getDisplayMetrics())));
        if (this.isEnable == true) goto L19;
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        r11 = MathKt.roundToInt(TypedValue.applyDimension(1, 0, r14.getDisplayMetrics()));
    L23:
        if (r11 == 0) goto L26;
        this.vBorderContainer.setBorderColor(ContextCompat.getColor(getContext(), r11));
        return;
    L26:
        return;
    L19:
        if (this.isError == false) goto L21;
        r11 = u8.c.oui_functional_red_7;
        goto L23
    L21:
        if (r10 == false) goto L23;
        r11 = u8.c.oui_basic_line_3;
        goto L23
    L10:
        if (r10 == false) goto L13;
        r12 = 2;
        goto L9
    L13:
        if (this.isError == false) goto L8;
        r12 = (float) 1.2d;
        goto L9
    }

    private final void updateClearVisibility() {
        if (this.autoShowClear == true) goto L5;
        return;
    L5:
        boolean r10 = true;
        if (isPasswordMode() == false) goto L8;
    L22:
        boolean r11 = false;
    L23:
        k.k(this.vClear, r11);
        if (r11 == false) goto L26;
        k.k(this.vEye, false);
    L26:
        View r12 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L29;
        boolean r13 = true;
    L30:
        if (r13 == false) goto L32;
    L43:
        k.k(r12, r10);
        return;
    L32:
        if (this.vEye.getVisibility() != 0) goto L34;
        boolean r14 = true;
    L35:
        if (r14 == true) goto L43;
        if (this.vComboArrow.getVisibility() != 0) goto L39;
        boolean r15 = true;
    L40:
        if (r15 == true) goto L43;
        r10 = false;
        goto L43
    L39:
        r15 = false;
        goto L40
    L34:
        r14 = false;
        goto L35
    L29:
        r13 = false;
        goto L30
    L8:
        if (this.inputMode != 0) goto L22;
        if (this.isEnable == false) goto L22;
        if (this.vInput.hasFocus() == false) goto L22;
        Editable r16 = this.vInput.getText();
        if (r16 != null) goto L16;
    L19:
        boolean r17 = true;
    L20:
        if (r17 == true) goto L22;
        r11 = true;
        goto L23
    L16:
        if (r16.length() == 0) goto L19;
        r17 = false;
        goto L20
    }

    private final void updateEyeVisibility() {
        boolean r10 = true;
        if (isPasswordMode() == true) goto L5;
    L17:
        boolean r11 = false;
    L18:
        k.k(this.vEye, r11);
        if (r11 == false) goto L21;
        k.k(this.vClear, false);
    L21:
        View r12 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L24;
        boolean r13 = true;
    L25:
        if (r13 == false) goto L27;
    L38:
        k.k(r12, r10);
        return;
    L27:
        if (this.vEye.getVisibility() != 0) goto L29;
        boolean r14 = true;
    L30:
        if (r14 == true) goto L38;
        if (this.vComboArrow.getVisibility() != 0) goto L34;
        boolean r15 = true;
    L35:
        if (r15 == true) goto L38;
        r10 = false;
        goto L38
    L34:
        r15 = false;
        goto L35
    L29:
        r14 = false;
        goto L30
    L24:
        r13 = false;
        goto L25
    L5:
        if (this.isEnable == false) goto L17;
        Editable r16 = this.vInput.getText();
        if (r16 != null) goto L9;
    L12:
        boolean r17 = true;
    L13:
        if (r17 == true) goto L17;
        if (this.alwaysHideEye == true) goto L17;
        r11 = true;
        goto L18
    L9:
        if (r16.length() == 0) goto L12;
        r17 = false;
        goto L13
    }

    private final void updateLabelUIState(LabelUIState r10, TextView r11, String r12) {
        ea.b.a(TAG, "updateLabelUIState, state: " + r10 + ", scene: [" + r12 + ']');
        int r13 = com.obric.oui.forms.a.f6685a[r10.ordinal()];
        if (r13 != 1) goto L5;
        showRealLabel(r11);
        return;
    L5:
        if (r13 != 2) goto L7;
        showFakeLabel(r11);
        return;
    L7:
        if (r13 != 3) goto L15;
        showNoLabel(r11);
        return;
    }

    public final void addTextChangedListener(TextWatcher r10) {
        this.vInput.addTextChangedListener(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L36;
        if (this.inScrollableView == false) goto L36;
        float r11 = r10.getX();
        float r12 = r10.getY();
        int r13 = r10.getAction();
        if (r13 != 0) goto L8;
        this.lastScrollY = r11;
    L34:
        this.lastScrollY = r12;
        goto L36
    L8:
        if (r13 != 1) goto L10;
    L32:
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r13 == 2) goto L15;
        if (r13 == 3) goto L32;
    L15:
        if (r11 <= this.lastScrollX) goto L19;
        if (this.vInput.canScrollHorizontally(-1) == false) goto L19;
    L30:
        super.requestDisallowInterceptTouchEvent(true);
    L31:
        this.lastScrollX = r11;
    L19:
        if (r11 >= this.lastScrollX) goto L23;
        if (this.vInput.canScrollHorizontally(1) == true) goto L30;
    L23:
        if (r12 >= this.lastScrollY) goto L27;
        if (this.vInput.canScrollVertically(1) == true) goto L30;
    L27:
        if (r12 <= this.lastScrollY) goto L31;
        if (this.vInput.canScrollVertically(-1) == false) goto L31;
    L36:
        return super.dispatchTouchEvent(r10);
    }

    public void doAfterTextStateChange(Editable r10) {
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

    public int getConstraintLength(CharSequence r10) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.length();
    }

    public int getContentViewRes() {
        return u8.h.o_input_view_layout_vertical;
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
        Editable r10 = this.vInput.getText();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.toString();
    }

    public final OEditText getVInput() {
        return this.vInput;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (r10 != null) goto L5;
    L13:
        if (r10 != null) goto L15;
    L22:
        return super.onInterceptTouchEvent(r10);
    L15:
        if (r10.getAction() == 1) goto L19;
        if (r10.getAction() != 3) goto L22;
    L19:
        if (this.shouldDispatchToInput == false) goto L22;
    L12:
        this.shouldDispatchToInput = false;
        goto L22
    L5:
        if (r10.getAction() != 0) goto L13;
        float r11 = r10.getX();
        int r12 = this.vInput.getLeft();
        int r13 = this.vInput.getRight();
        if (r11 < r12) goto L12;
        if (r11 > r13) goto L12;
        this.shouldDispatchToInput = true;
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L12;
        if (this.shouldDispatchToInput == false) goto L12;
        MotionEvent r11 = MotionEvent.obtain(r10);
        r11.offsetLocation(-this.vInput.getLeft(), -this.vInput.getTop());
        boolean r12 = this.vInput.dispatchTouchEvent(r11);
        r11.recycle();
        if (r10.getAction() != 1) goto L8;
    L9:
        this.shouldDispatchToInput = false;
    L10:
        return r12;
    L8:
        if (r10.getAction() != 3) goto L10;
    L12:
        return super.onTouchEvent(r10);
    }

    public final void removeTextChangedListener(TextWatcher r10) {
        this.vInput.removeTextChangedListener(r10);
    }

    public final void setActionView(Function1<? super FrameLayout, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "creator");
        this.vCustomActionContainer.removeAllViews();
        r10.invoke(this.vCustomActionContainer);
        FrameLayout r11 = this.vCustomActionContainer;
        if (r11.getChildCount() <= 0) goto L5;
        boolean r12 = true;
    L6:
        k.k(r11, r12);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public final void setAlwaysHideEye(boolean r10) {
        this.alwaysHideEye = r10;
        if (r10 == false) goto L6;
        k.k(this.vEye, false);
        return;
    }

    public final void setAutoHideSoft() {
        this.autoHideSoftInputWhenLoseFocus = true;
    }

    public final void setAutoHideSoftInputWhenLoseFocus(boolean r10) {
        this.autoHideSoftInputWhenLoseFocus = r10;
    }

    public final void setBgResId(int r10) {
        this.bgResId = r10;
        updateBackground(true);
    }

    public final void setComboInputEnabled(boolean r10) {
        this.comboInputEnabled = r10;
        this.vInput.setFocusable(r10);
        this.vInput.setFocusableInTouchMode(r10);
        View.OnClickListener r11 = this.onComboArrowClickListener;
        if (r11 == null) goto L6;
        this.vInput.setOnClickListener(r11);
        return;
    }

    public final void setCommitCompletionListener(OEditText.a r10) {
        Intrinsics.checkNotNullParameter(r10, "commitCompletionListener");
        this.vInput.setCommitCompletionListener(r10);
    }

    public final void setCommonTip(String r10) {
        this.commonTip = r10;
        this.vCommonTip.setText(r10);
    }

    @Override // android.view.View
    public void setEnabled(boolean r10) {
        this.isEnable = r10;
        super.setEnabled(r10);
        Iterator<View> r11 = ViewGroupKt.getChildren(this).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().setEnabled(r10);
        goto L4
    L6:
        this.vInput.setEnabled(r10);
        updateBorder(this.vInput.hasFocus());
        updateBackground(false);
    }

    public final void setErrorState(boolean r10) {
        this.isError = r10;
        updateBorder(this.vInput.hasFocus());
        updateBackground(false);
    }

    public final void setErrorTip(String r10) {
        this.errorTip = r10;
        this.vErrorTip.setText(r10);
    }

    public final void setHint(String r10) {
        this.hint = r10;
        this.vInput.setHint(r10);
        adjustInputViewAndLabel("setHint");
    }

    public final void setInputHeight(int r10) {
        this.inputHeight = Integer.valueOf(r10);
        OEditText r11 = this.vInput;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        ((ViewGroup.MarginLayoutParams) r13).height = r10;
        r11.setLayoutParams(r13);
    }

    public final void setInputMode(int r10) {
        this.inputMode = r10;
        boolean r11 = false;
        if (r10 == 0) goto L23;
        if (r10 != 1) goto L42;
        setSingleLine(true);
        k.k(this.vComboArrow, true);
        View r12 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L9;
        boolean r13 = true;
    L10:
        if (r13 == false) goto L12;
    L21:
        r11 = true;
    L22:
        k.k(r12, r11);
        setComboInputEnabled(this.comboInputEnabled);
        return;
    L12:
        if (this.vEye.getVisibility() != 0) goto L14;
        boolean r14 = true;
    L15:
        if (r14 == true) goto L21;
        if (this.vComboArrow.getVisibility() != 0) goto L19;
        boolean r15 = true;
    L20:
        if (r15 == false) goto L22;
    L19:
        r15 = false;
        goto L20
    L14:
        r14 = false;
        goto L15
    L9:
        r13 = false;
        goto L10
    L42:
        return;
    L23:
        k.k(this.vComboArrow, false);
        View r16 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L26;
        boolean r17 = true;
    L27:
        if (r17 == false) goto L29;
    L38:
        r11 = true;
    L39:
        k.k(r16, r11);
        this.vInput.setFocusable(true);
        this.vInput.setFocusableInTouchMode(true);
        return;
    L29:
        if (this.vEye.getVisibility() != 0) goto L31;
        boolean r18 = true;
    L32:
        if (r18 == true) goto L38;
        if (this.vComboArrow.getVisibility() != 0) goto L36;
        boolean r19 = true;
    L37:
        if (r19 == false) goto L39;
    L36:
        r19 = false;
        goto L37
    L31:
        r18 = false;
        goto L32
    L26:
        r17 = false;
        goto L27
    }

    public final void setInputType(int r10) {
        if ((r10 & 1) == 0) goto L5;
    L11:
        this.inputType = r10;
        if (r10 != this.vInput.getInputType()) goto L15;
    L13:
        doAfterTextStateChange(this.vInput.getText());
        return;
    L15:
        this.vInput.setInputType(this.inputType);
        updateEyeVisibility();
        goto L13
    L5:
        if ((r10 & 2) != 0) goto L11;
        if ((r10 & 3) != 0) goto L11;
        if ((r10 & 4) != 0) goto L11;
        r10 = r10 | 1;
        goto L11
    }

    public final void setIsInScrollableView(boolean r10) {
        this.inScrollableView = r10;
    }

    public final void setKeyListener(KeyListener r10) {
        this.vInput.setKeyListener(r10);
    }

    public final void setLabel(String r10) {
        this.insideLabel = r10;
        this.vTitle.setText(r10);
    }

    public final void setLeftView(Function1<? super FrameLayout, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "creator");
        this.vLeftViewContainer.removeAllViews();
        r10.invoke(this.vLeftViewContainer);
        FrameLayout r11 = this.vLeftViewContainer;
        if (r11.getChildCount() <= 0) goto L5;
        boolean r12 = true;
    L6:
        k.k(r11, r12);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void setLimitCount(int r10) {
        setLimitCountValue(r10);
        Editable r11 = this.vInput.getText();
        if (r11 == null) goto L5;
        String r12 = r11.toString();
    L6:
        updateLimitIndicator(r12);
        doAfterTextStateChange(this.vInput.getText());
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void setLimitCountValue(int r10) {
        this.limitCount = r10;
    }

    public final void setMaxLines(int r10) {
        int r11 = 1;
        if (r10 >= 1) goto L5;
        r10 = Integer.MAX_VALUE;
    L5:
        this.maxLines = r10;
        OEditText r12 = this.vInput;
        if (this.singleLine == true) goto L9;
        r11 = r10;
    L9:
        r12.setMaxLines(r11);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r10) {
        if (this.inputMode == 1) goto L5;
    L7:
        super.setOnClickListener(r10);
        return;
    L5:
        if (this.comboInputEnabled == true) goto L7;
        this.vComboArrow.setOnClickListener(r10);
        this.vInput.setOnClickListener(r10);
        goto L7
    }

    public final void setOnComboArrowClickListener(View.OnClickListener r10) {
        this.onComboArrowClickListener = r10;
        this.vComboArrow.setOnClickListener(r10);
        if (this.comboInputEnabled == true) goto L8;
        View.OnClickListener r11 = this.onComboArrowClickListener;
        if (r11 == null) goto L9;
        this.vInput.setOnClickListener(r11);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r10) {
        this.vInput.setOnFocusChangeListener(r10);
    }

    public final void setOnTextClearedListener(e r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.onTextClearedListener = r10;
    }

    public final void setOnTextExceedLengthListener(f r10) {
        this.onTextExceedLengthListener = r10;
    }

    public final void setRadius(int r10) {
        if (r10 != this.radius) goto L5;
        return;
    L5:
        this.radius = r10;
        this.vBorderContainer.setRadius(r10);
    }

    public final void setShowLabel(boolean r10) {
        this.showLabel = r10;
        k.k(this.vTitleContainer, r10);
        OEditText r11 = this.vInput;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        if (this.showLabel == false) goto L5;
        int r14 = 16;
    L6:
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        int r16 = MathKt.roundToInt(TypedValue.applyDimension(1, r14, r15.getDisplayMetrics()));
        r13.goneLeftMargin = r16;
        r13.goneStartMargin = r16;
        r11.setLayoutParams(r13);
        adjustInputViewAndLabel("setShowLabel");
        return;
    L5:
        r14 = 12;
        goto L6
    }

    public final void setShowLabelAnim(boolean r10) {
        this.showLabelAnim = r10;
        adjustInputViewAndLabel("setShowLabelAnim");
    }

    public final void setShowLabelIcon(boolean r10) {
        this.showLabelIcon = r10;
        k.k(this.vTitleIcon, r10);
    }

    public final void setShowLimitIndicator(boolean r10) {
        this.showLimitIndicator = r10;
        Editable r11 = this.vInput.getText();
        if (r11 == null) goto L5;
        String r12 = r11.toString();
    L6:
        updateLimitIndicator(r12);
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void setSingleLine(boolean r14) {
        this.singleLine = r14;
        int r10 = getResources().getDimensionPixelSize(u8.d.o_input_view_space_top_bottom);
        ViewGroup.LayoutParams r11 = null;
        if (r14 == false) goto L25;
        k.k(this.vInputResizer, false);
        this.vInput.setMaxLines(1);
        this.vInput.setSingleLine(true);
        OEditText r15 = this.vInput;
        ViewGroup.LayoutParams r12 = r15.getLayoutParams();
        Objects.requireNonNull(r12, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        ViewGroup.LayoutParams r16 = getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        r16 = null;
    L7:
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        if (r17 == null) goto L10;
        int r18 = r17.leftMargin;
    L11:
        ViewGroup.LayoutParams r19 = getLayoutParams();
        if ((r19 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        r11 = r19;
    L15:
        ViewGroup.MarginLayoutParams r20 = (ViewGroup.MarginLayoutParams) r11;
        if (r20 == null) goto L18;
        int r21 = r20.rightMargin;
    L19:
        r13.setMargins(r18, 0, r21, r10);
        r13.goneTopMargin = r10;
        if (this.showLabel == false) goto L22;
        float r22 = 16;
    L23:
        Resources r23 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r23, "Resources.getSystem()");
        int r24 = MathKt.roundToInt(TypedValue.applyDimension(1, r22, r23.getDisplayMetrics()));
        r13.goneLeftMargin = r24;
        r13.goneStartMargin = r24;
        r15.setLayoutParams(r13);
        View r110 = this.vActionContainer;
        ViewGroup.LayoutParams r25 = r110.getLayoutParams();
        Objects.requireNonNull(r25, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r26 = (ConstraintLayout.LayoutParams) r25;
        r26.topToTop = 0;
        r26.bottomToBottom = 0;
        r110.setLayoutParams(r26);
        FrameLayout r111 = this.vCustomActionContainer;
        ViewGroup.LayoutParams r27 = r111.getLayoutParams();
        Objects.requireNonNull(r27, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r28 = (ConstraintLayout.LayoutParams) r27;
        r28.topToTop = 0;
        r28.bottomToBottom = 0;
        r111.setLayoutParams(r28);
        FrameLayout r112 = this.vLeftViewContainer;
        ViewGroup.LayoutParams r29 = r112.getLayoutParams();
        Objects.requireNonNull(r29, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r30 = (ConstraintLayout.LayoutParams) r29;
        float r31 = 4;
        Resources r32 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r32, "Resources.getSystem()");
        int r33 = MathKt.roundToInt(TypedValue.applyDimension(1, r31, r32.getDisplayMetrics()));
        Resources r34 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r34, "Resources.getSystem()");
        int r35 = MathKt.roundToInt(TypedValue.applyDimension(1, r31, r34.getDisplayMetrics()));
        Resources r36 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r36, "Resources.getSystem()");
        r30.setMargins(r33, r35, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r31, r36.getDisplayMetrics())));
        r30.topToTop = 0;
        r30.bottomToBottom = 0;
    L24:
        r112.setLayoutParams(r30);
        adjustInputViewAndLabel("setSingleLine");
        return;
    L22:
        r22 = 12;
        goto L23
    L18:
        r21 = 0;
        goto L19
    L10:
        r18 = 0;
        goto L11
    L25:
        k.k(this.vInputResizer, this.showResizer);
        this.vInput.setMaxLines(this.maxLines);
        this.vInput.setSingleLine(false);
        OEditText r113 = this.vInput;
        int r37 = getPaddingLeft();
        Resources r114 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r114, "Resources.getSystem()");
        r113.setPadding(r37, MathKt.roundToInt(TypedValue.applyDimension(1, 2, r114.getDisplayMetrics())), getPaddingRight(), getPaddingBottom());
        this.vInput.setGravity(48);
        OEditText r115 = this.vInput;
        ViewGroup.LayoutParams r38 = r115.getLayoutParams();
        Objects.requireNonNull(r38, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r39 = (ConstraintLayout.LayoutParams) r38;
        ViewGroup.LayoutParams r40 = getLayoutParams();
        if ((r40 instanceof ViewGroup.MarginLayoutParams) == true) goto L28;
        r40 = null;
    L28:
        ViewGroup.MarginLayoutParams r41 = (ViewGroup.MarginLayoutParams) r40;
        if (r41 == null) goto L31;
        int r42 = r41.leftMargin;
    L32:
        ViewGroup.LayoutParams r116 = getLayoutParams();
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == true) goto L35;
        r116 = null;
    L35:
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r116;
        if (r117 == null) goto L38;
        int r118 = r117.rightMargin;
    L39:
        float r119 = 8;
        Resources r120 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r120, "Resources.getSystem()");
        r39.setMargins(r42, 0, r118, MathKt.roundToInt(TypedValue.applyDimension(1, r119, r120.getDisplayMetrics())));
        Resources r43 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r43, "Resources.getSystem()");
        r39.goneTopMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r119, r43.getDisplayMetrics()));
        if (this.showLabel == false) goto L42;
        float r44 = 16;
    L43:
        Resources r45 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r45, "Resources.getSystem()");
        int r46 = MathKt.roundToInt(TypedValue.applyDimension(1, r44, r45.getDisplayMetrics()));
        r39.goneLeftMargin = r46;
        r39.goneStartMargin = r46;
        r115.setLayoutParams(r39);
        View r121 = this.vActionContainer;
        ViewGroup.LayoutParams r47 = r121.getLayoutParams();
        Objects.requireNonNull(r47, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r48 = (ConstraintLayout.LayoutParams) r47;
        r48.topToTop = 0;
        ViewGroup.LayoutParams r49 = getLayoutParams();
        if ((r49 instanceof ViewGroup.MarginLayoutParams) == true) goto L46;
        r49 = null;
    L46:
        ViewGroup.MarginLayoutParams r50 = (ViewGroup.MarginLayoutParams) r49;
        if (r50 == null) goto L49;
        int r51 = r50.leftMargin;
    L50:
        float r52 = 4;
        Resources r53 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r53, "Resources.getSystem()");
        int r54 = MathKt.roundToInt(TypedValue.applyDimension(1, r52, r53.getDisplayMetrics()));
        ViewGroup.LayoutParams r55 = getLayoutParams();
        if ((r55 instanceof ViewGroup.MarginLayoutParams) == true) goto L53;
        r55 = null;
    L53:
        ViewGroup.MarginLayoutParams r56 = (ViewGroup.MarginLayoutParams) r55;
        if (r56 == null) goto L56;
        int r57 = r56.rightMargin;
    L57:
        ViewGroup.LayoutParams r122 = getLayoutParams();
        if ((r122 instanceof ViewGroup.MarginLayoutParams) == false) goto L61;
        r11 = r122;
    L61:
        ViewGroup.MarginLayoutParams r58 = (ViewGroup.MarginLayoutParams) r11;
        if (r58 == null) goto L64;
        int r59 = r58.bottomMargin;
    L65:
        r48.setMargins(r51, r54, r57, r59);
        r48.bottomToBottom = -1;
        r121.setLayoutParams(r48);
        FrameLayout r123 = this.vCustomActionContainer;
        ViewGroup.LayoutParams r60 = r123.getLayoutParams();
        Objects.requireNonNull(r60, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r61 = (ConstraintLayout.LayoutParams) r60;
        r61.topToTop = 0;
        r61.bottomToBottom = 0;
        r123.setLayoutParams(r61);
        r112 = this.vLeftViewContainer;
        ViewGroup.LayoutParams r62 = r112.getLayoutParams();
        Objects.requireNonNull(r62, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        r30 = (ConstraintLayout.LayoutParams) r62;
        Resources r63 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r63, "Resources.getSystem()");
        int r64 = MathKt.roundToInt(TypedValue.applyDimension(1, r52, r63.getDisplayMetrics()));
        Resources r65 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r65, "Resources.getSystem()");
        r30.setMargins(r64, MathKt.roundToInt(TypedValue.applyDimension(1, r52, r65.getDisplayMetrics())), 0, 0);
        r30.topToTop = 0;
        r30.bottomToBottom = -1;
        goto L24
    L64:
        r59 = 0;
        goto L65
    L56:
        r57 = 0;
        goto L57
    L49:
        r51 = 0;
        goto L50
    L42:
        r44 = 12;
        goto L43
    L38:
        r118 = 0;
        goto L39
    L31:
        r42 = 0;
        goto L32
    }

    public final void setText(String r10) {
        this.vInput.setText(r10);
        adjustInputViewAndLabel("setText");
        doAfterTextStateChange(this.vInput.getText());
    }

    public final void showCommonTip(boolean r10) {
        k.k(this.vCommonTip, r10);
    }

    public final void showErrorTip(boolean r10) {
        k.k(this.vErrorTip, r10);
    }

    public final void updateClearVisibility(boolean r10) {
        boolean r11 = false;
        this.autoShowClear = false;
        k.k(this.vClear, r10);
        if (r10 == false) goto L5;
    L19:
        boolean r12 = false;
    L20:
        k.k(this.vEye, r12);
        View r13 = this.vComboArrow;
        if (r10 == false) goto L23;
    L25:
        boolean r14 = false;
    L26:
        k.k(r13, r14);
        View r15 = this.vActionContainer;
        if (this.vClear.getVisibility() != 0) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L32;
    L41:
        r11 = true;
    L42:
        k.k(r15, r11);
        return;
    L32:
        if (this.vEye.getVisibility() != 0) goto L34;
        boolean r17 = true;
    L35:
        if (r17 == true) goto L41;
        if (this.vComboArrow.getVisibility() != 0) goto L39;
        boolean r18 = true;
    L40:
        if (r18 == false) goto L42;
    L39:
        r18 = false;
        goto L40
    L34:
        r17 = false;
        goto L35
    L29:
        r16 = false;
        goto L30
    L23:
        if (this.inputMode != 1) goto L25;
        r14 = true;
        goto L26
    L5:
        if (isPasswordMode() == false) goto L19;
        if (this.isEnable == false) goto L19;
        Editable r19 = this.vInput.getText();
        if (r19 != null) goto L11;
    L14:
        boolean r20 = true;
    L15:
        if (r20 == true) goto L19;
        if (this.alwaysHideEye == true) goto L19;
        r12 = true;
        goto L20
    L11:
        if (r19.length() == 0) goto L14;
        r20 = false;
        goto L15
    }

    public final void updateLimitIndicator(String r10) {
        OTextView r11 = this.vLimitIndicator;
        if (this.showLimitIndicator == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        k.k(r11, r12);
        if (this.showLimitIndicator == true) goto L11;
        return;
    L11:
        if (this.limitCount <= 0) goto L18;
        int r13 = getConstraintLength(r10);
        String r14 = getResources().getString(u8.j.oui_form_counter, new Object[]{String.valueOf(r13), String.valueOf(this.limitCount)});
        Intrinsics.checkNotNullExpressionValue(r14, "resources.getString(\n   ….toString()\n            )");
        SpannableString r15 = new SpannableString(r14);
        if (r13 <= this.limitCount) goto L15;
        r15.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), u8.c.oui_functional_red_7)), 0, String.valueOf(r13).length(), 18);
    L15:
        this.vLimitIndicator.setText(r15, TextView.BufferType.SPANNABLE);
        return;
    L18:
        return;
    L5:
        if (this.limitCount <= 0) goto L7;
        r12 = true;
        goto L8
    }

    public final void updateResizerVisibility(boolean r10) {
        this.showResizer = r10;
        View r11 = this.vInputResizer;
        if (r10 == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        k.k(r11, r12);
        return;
    L5:
        if (this.singleLine == true) goto L7;
        r12 = true;
        goto L8
    }
}
