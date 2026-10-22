package com.obric.oui.animation.easy;

import android.security.obric.guard.ObricSecurityGuardStub;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0001+\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001RB\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J/\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ?\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010!\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJg\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u001d\u0010\"\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001d0#¢\u0006\u0002\b\u001e2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001e2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJg\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u001d\u0010\"\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001d0#¢\u0006\u0002\b\u001e2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001e2\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ?\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010!\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ;\u0010&\u001a\u00020\u001d2\u000e\u0010!\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n2\u0006\u0010'\u001a\u00020\u000f2\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eH\u0002J\u0006\u0010)\u001a\u00020\u001dJK\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000+2\u001d\u0010\"\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u001d0#¢\u0006\u0002\b\u001e2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001eH\u0002¢\u0006\u0002\u0010,J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000fJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\rJ/\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ\u008d\u0001\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002)\b\u0002\u0010<\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u001d0\u001b2)\b\u0002\u0010@\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u001d0\u001b2)\b\u0002\u0010A\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u001d0\u001bJ\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007J\u000e\u0010B\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\rJ\u0006\u0010C\u001a\u00020\u001dJ\f\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J/\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ/\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0002\b\u001eJ\u001c\u0010Q\u001a\u00020\u001d*\u00020\u000b2\u000e\u0010!\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\nH\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006S"}, d2 = {"Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "", "view", "(Landroid/view/View;)V", "animatorListener", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator$AnimatorListener;", "animatorMap", "", "Lcom/obric/oui/animation/engine/FloatPropertyCompat;", "Lcom/obric/oui/animation/engine/SpringAnimation;", "animatorUpdateListener", "Lcom/obric/oui/animation/engine/DynamicAnimation$OnAnimationUpdateListener;", "defaultDampingRatio", "", "defaultStiffness", "isRunning", "", "()Z", "pendingAnimations", "", "Lcom/github/lcdsmao/springx/SpringAnimationHolder;", "Landroid/view/View;", "alpha", EventBody.KEY_VALUE, "config", "Lkotlin/Function1;", "Lcom/obric/oui/animation/easy/SpringAnimationConfig;", "", "Lkotlin/ExtensionFunctionType;", "alphaBy", "animateProperty", "property", "setter", "Lkotlin/Function2;", "getter", "animatePropertyBy", "animatePropertyInternal", "finalValue", "configBuilder", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "createCustomProperty", "com/obric/oui/animation/easy/ViewPropertySpringAnimator$createCustomProperty$1", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator$createCustomProperty$1;", "removeEndListener", "listener", "Lcom/obric/oui/animation/engine/DynamicAnimation$OnAnimationEndListener;", "removeUpdateListener", Key.ROTATION, "rotationBy", "rotationX", "rotationXBy", "rotationY", "rotationYBy", "scaleX", "scaleXBy", "scaleY", "scaleYBy", "setListener", "onStart", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "animator", "onCancel", "onEnd", "setUpdateListener", "skipToEnd", CommonConsts.APM_INNER_EVENT_COST_START, "translationX", "translationXBy", "translationY", "translationYBy", "translationZ", "translationZBy", "x", "xBy", "y", "yBy", "z", "zBy", "cleanSelfOnEnd", "AnimatorListener", "OUIAnimation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f13301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.github.a.a.a> f13302b;
    private final Map<com.obric.oui.animation.a.c<? super T>, com.obric.oui.animation.a.d> c;
    private float d;
    private float e;
    private a<T> f;
    private com.obric.oui.animation.a.b.c g;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u00020\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator$AnimatorListener;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "", "onAnimationCancel", "", "animator", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "onAnimationEnd", "onAnimationStart", "OUIAnimation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a<T extends View> {
        void a(b<T> r1);

        void b(b<T> r1);

        void c(b<T> r1);
    }

    /* JADX INFO: renamed from: com.obric.oui.animation.easy.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"com/obric/oui/animation/easy/ViewPropertySpringAnimator$cleanSelfOnEnd$listener$1", "Lcom/obric/oui/animation/engine/DynamicAnimation$OnAnimationEndListener;", "onAnimationEnd", "", "animation", "Lcom/obric/oui/animation/engine/DynamicAnimation;", "canceled", "", EventBody.KEY_VALUE, "", "velocity", "OUIAnimation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0728b implements com.obric.oui.animation.a.b.InterfaceC0726b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b<T> f13303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.oui.animation.a.c<? super T> f13304b;
        final /* synthetic */ c c;

        C0728b(b<T> r1, com.obric.oui.animation.a.c<? super T> r2, c r3) {
            this.f13303a = r1;
            this.f13304b = r2;
            this.c = r3;
        }

        @Override // com.obric.oui.animation.a.b.InterfaceC0726b
        public void a(com.obric.oui.animation.a.b<? extends com.obric.oui.animation.a.b<?>> r2, boolean r3, float r4, float r5) {
            b.b(this.f13303a).remove(this.f13304b);
            if (r2 == null) goto L6;
            r2.b((com.obric.oui.animation.a.b.InterfaceC0726b) ZeusTransformUtils.preCheckCast(this, com.obric.oui.animation.a.b.InterfaceC0726b.class, "com.obric.memorydata.plugin"));
        L6:
            if (r2 == null) goto L9;
            r2.b((com.obric.oui.animation.a.b.c) ZeusTransformUtils.preCheckCast(this.c, com.obric.oui.animation.a.b.c.class, "com.obric.memorydata.plugin"));
        L9:
            b.a(this.f13303a, null);
            if (b.b(this.f13303a).isEmpty() == false) goto L17;
            if (r3 == true) goto L18;
            a r6 = b.c(this.f13303a);
            if (r6 == null) goto L19;
            r6.c(this.f13303a);
            return;
        L19:
            return;
        L18:
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/animation/easy/ViewPropertySpringAnimator$cleanSelfOnEnd$updateListener$1", "Lcom/obric/oui/animation/engine/DynamicAnimation$OnAnimationUpdateListener;", "onAnimationUpdate", "", "animation", "Lcom/obric/oui/animation/engine/DynamicAnimation;", EventBody.KEY_VALUE, "", "velocity", "OUIAnimation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements com.obric.oui.animation.a.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b<T> f13305a;

        c(b<T> r1) {
            this.f13305a = r1;
        }

        @Override // com.obric.oui.animation.a.b.c
        public void onAnimationUpdate(com.obric.oui.animation.a.b<? extends com.obric.oui.animation.a.b<?>> r1, float r2, float r3) {
            com.obric.oui.animation.a.b.c r0 = b.a(this.f13305a);
            if (r0 == null) goto L7;
            r0.onAnimationUpdate(r1, r2, r3);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/oui/animation/easy/ViewPropertySpringAnimator$setListener$4", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator$AnimatorListener;", "onAnimationCancel", "", "animator", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "onAnimationEnd", "onAnimationStart", "OUIAnimation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<b<T>, Unit> f13306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<b<T>, Unit> f13307b;
        final /* synthetic */ Function1<b<T>, Unit> c;

        d(Function1<? super b<T>, Unit> r3, Function1<? super b<T>, Unit> r4, Function1<? super b<T>, Unit> r5) {
            Function1<b<T>, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Function1<b<T>, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            Function1<b<T>, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            this.f13306a = r6;
            this.f13307b = r7;
            this.c = r8;
        }

        @Override // com.obric.oui.animation.easy.b.a
        public void a(b<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.f13306a.invoke(r2);
        }

        @Override // com.obric.oui.animation.easy.b.a
        public void b(b<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.f13307b.invoke(r2);
        }

        @Override // com.obric.oui.animation.easy.b.a
        public void c(b<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.c.invoke(r2);
        }
    }

    public b(T r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        this.f13301a = r3;
        this.f13302b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.d = 0.5f;
        this.e = 1500.0f;
    }

    public static final /* synthetic */ com.obric.oui.animation.a.b.c a(b r0) {
        return r0.g;
    }

    public static /* synthetic */ b a(b r1, com.obric.oui.animation.a.c r2, float r3, Function1 r4, int r5, Object r6) {
        Function1<? super com.obric.oui.animation.easy.a, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L6;
        r7 = (Function1) ZeusTransformUtils.preCheckCast(ViewPropertySpringAnimator$animateProperty$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L6:
        return r1.a(r2, r3, r7);
    }

    public static /* synthetic */ b a(b r1, Function1 r2, Function1 r3, Function1 r4, int r5, Object r6) {
        Function1<? super b<T>, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super b<T>, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1<? super b<T>, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = (Function1) ZeusTransformUtils.preCheckCast(ViewPropertySpringAnimator$setListener$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L6:
        if ((r5 & 2) == 0) goto L9;
        r8 = (Function1) ZeusTransformUtils.preCheckCast(ViewPropertySpringAnimator$setListener$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L9:
        if ((r5 & 4) == 0) goto L12;
        r9 = (Function1) ZeusTransformUtils.preCheckCast(ViewPropertySpringAnimator$setListener$3.INSTANCE, Function1.class, "com.obric.memorydata.plugin");
    L12:
        return r1.a(r7, r8, r9);
    }

    private final void a(com.obric.oui.animation.a.d r4, com.obric.oui.animation.a.c<? super T> r5) {
        c r0 = new c(this);
        r4.a((com.obric.oui.animation.a.b.c) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.animation.a.b.c.class, "com.obric.memorydata.plugin"));
        r4.a((com.obric.oui.animation.a.b.InterfaceC0726b) ZeusTransformUtils.preCheckCast(new C0728b(this, r5, r0), com.obric.oui.animation.a.b.InterfaceC0726b.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(b r2, com.obric.oui.animation.a.b.c r3) {
        r2.g = (com.obric.oui.animation.a.b.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.animation.a.b.c.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ Map b(b r0) {
        return r0.c;
    }

    private final void b(com.obric.oui.animation.a.c<? super T> r4, float r5, Function1<? super com.obric.oui.animation.easy.a, Unit> r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        com.obric.oui.animation.a.d r0 = (com.obric.oui.animation.a.d) ZeusTransformUtils.preCheckCast(this.c.get(r4), com.obric.oui.animation.a.d.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new com.obric.oui.animation.a.d(this.f13301a, r4);
        a(r0, r4);
        this.c.put(r4, r0);
    L5:
        com.obric.oui.animation.easy.a r8 = new com.obric.oui.animation.easy.a(r5);
        r7.invoke(r8);
        r8.b(this.d);
        r8.d(this.e);
        ((Collection) ZeusTransformUtils.preCheckCast(this.f13302b, Collection.class, "com.obric.memorydata.plugin")).add(new com.github.a.a.a(r0, r8));
    }

    public static final /* synthetic */ a c(b r0) {
        return r0.f;
    }

    public final b<T> a(float r4) {
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).d = r4;
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
    }

    public final b<T> a(float r4, Function1<? super com.obric.oui.animation.easy.a, Unit> r5) {
        Function1<? super com.obric.oui.animation.easy.a, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "config");
        com.obric.oui.animation.a.b.d r0 = com.obric.oui.animation.a.b.f13293b;
        Intrinsics.checkNotNullExpressionValue(r0, "TRANSLATION_Y");
        return a((com.obric.oui.animation.a.c) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.animation.a.c.class, "com.obric.memorydata.plugin"), r4, r6);
    }

    public final b<T> a(com.obric.oui.animation.a.c<? super T> r4, float r5, Function1<? super com.obric.oui.animation.easy.a, Unit> r6) {
        Function1<? super com.obric.oui.animation.easy.a, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "property");
        Intrinsics.checkNotNullParameter(r7, "config");
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).b(r4, r5, r7);
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
    }

    public final b<T> a(a<T> r4) {
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).f = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
    }

    public final b<T> a(Function1<? super b<T>, Unit> r3, Function1<? super b<T>, Unit> r4, Function1<? super b<T>, Unit> r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "onStart");
        Intrinsics.checkNotNullParameter(r7, "onCancel");
        Intrinsics.checkNotNullParameter(r8, "onEnd");
        return a((a) ZeusTransformUtils.preCheckCast(new d(r6, r7, r8), a.class, "com.obric.memorydata.plugin"));
    }

    public final void a(com.obric.oui.animation.a.b.c r3) {
        com.obric.oui.animation.a.b.c r4 = (com.obric.oui.animation.a.b.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.animation.a.b.c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.g = r4;
    }

    public final boolean a() {
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
    L7:
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        if (((com.obric.oui.animation.a.d) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.oui.animation.a.d.class, "com.obric.memorydata.plugin")).c() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        return false;
    }

    public final b<T> b() {
        b<T> r2 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
        if (r2.f13302b.isEmpty() == true) goto L14;
        List r3 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2.f13302b, Iterable.class, "com.obric.memorydata.plugin"));
        r2.f13302b.clear();
        a<T> r4 = r2.f;
        if (r4 == null) goto L9;
        r4.a(r2);
    L9:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r5.hasNext() == false) goto L14;
        ((com.github.a.a.a) ZeusTransformUtils.preCheckCast(r5.next(), com.github.a.a.a.class, "com.obric.memorydata.plugin")).a();
    L14:
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
    }

    public final b<T> b(float r4) {
        ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).e = r4;
        return (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");
    }

    public final void c() {
        this.f13302b.clear();
        List r0 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin"));
        this.c.clear();
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.obric.oui.animation.a.d) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.oui.animation.a.d.class, "com.obric.memorydata.plugin")).b();
        goto L4
    L6:
        a<T> r2 = this.f;
        if (r2 == null) goto L12;
        r2.b(this);
        return;
    }

    public final void d() {
        this.f13302b.clear();
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r2 = r5.next();
        if (((com.obric.oui.animation.a.d) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.animation.a.d.class, "com.obric.memorydata.plugin")).g() == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((com.obric.oui.animation.a.d) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.oui.animation.a.d.class, "com.obric.memorydata.plugin")).f();
        goto L10
    }
}
