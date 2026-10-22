package com.obric.assistant.window;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.util.m2;
import com.obric.assistant.view.GradientEffectView;
import com.obric.assistant.view.ObricIconSwipeUpView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000Ê\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 ü\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004ü\u0001ý\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010¡\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020m2\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0016J\u000b\u0010\u0082\u0001\u001a\u0004\u0018\u00010WH\u0016J\"\u0010°\u0001\u001a\u00030¢\u00012\f\b\u0002\u0010±\u0001\u001a\u0005\u0018\u00010²\u00012\b\u0010³\u0001\u001a\u00030²\u0001H\u0002J\n\u0010´\u0001\u001a\u00030¢\u0001H\u0016J\n\u0010µ\u0001\u001a\u00030¢\u0001H\u0016J\n\u0010¶\u0001\u001a\u00030¢\u0001H\u0002J\u0013\u0010·\u0001\u001a\u00030¢\u00012\u0007\u0010¸\u0001\u001a\u00020mH\u0002J\n\u0010¹\u0001\u001a\u00030¢\u0001H\u0002J\n\u0010º\u0001\u001a\u00030¢\u0001H\u0002J\u001b\u0010»\u0001\u001a\u00030¢\u00012\t\u0010¼\u0001\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0003\u0010½\u0001J\"\u0010¾\u0001\u001a\u00030¢\u00012\u0016\u0010¿\u0001\u001a\u0011\u0012\u0005\u0012\u00030²\u0001\u0012\u0005\u0012\u00030Á\u00010À\u0001H\u0016J\n\u0010Â\u0001\u001a\u00030¢\u0001H\u0016J\n\u0010Ã\u0001\u001a\u00030¢\u0001H\u0002J\n\u0010Ä\u0001\u001a\u00030¢\u0001H\u0016J\n\u0010Å\u0001\u001a\u00030¢\u0001H\u0016J\u0013\u0010Æ\u0001\u001a\u00030¢\u00012\u0007\u0010¸\u0001\u001a\u00020mH\u0016J\u0014\u0010Ç\u0001\u001a\u00030¢\u00012\b\u0010È\u0001\u001a\u00030É\u0001H\u0016J\u0013\u0010Ê\u0001\u001a\u00030¢\u00012\u0007\u0010Ë\u0001\u001a\u00020\u0007H\u0016J\u001b\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00072\b\u0010Í\u0001\u001a\u00030Î\u0001H\u0016¢\u0006\u0003\u0010Ï\u0001J\u0013\u0010Ð\u0001\u001a\u00030¢\u00012\u0007\u0010Ñ\u0001\u001a\u00020mH\u0016J\u0013\u0010Ò\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020mH\u0016J\u001c\u0010Ó\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020m2\u0007\u0010Ô\u0001\u001a\u00020mH\u0016J\u0013\u0010Õ\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020mH\u0016J\u0013\u0010Ö\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020mH\u0016J\n\u0010×\u0001\u001a\u00030¢\u0001H\u0002J\u0013\u0010Ø\u0001\u001a\u00030¢\u00012\u0007\u0010Ù\u0001\u001a\u00020mH\u0016J\u0013\u0010Ú\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020mH\u0016J\u0013\u0010Û\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020mH\u0016J\u001b\u0010®\u0001\u001a\u00030¢\u00012\u000f\u0010Ü\u0001\u001a\n\u0012\u0005\u0012\u00030¢\u00010¯\u0001H\u0016J\u0013\u0010Ý\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020mH\u0016J\u001c\u0010Ý\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020m2\u0007\u0010Þ\u0001\u001a\u00020mH\u0016J4\u0010Ý\u0001\u001a\u00030¢\u00012\u0007\u0010£\u0001\u001a\u00020m2\u0007\u0010Þ\u0001\u001a\u00020m2\n\u0010ß\u0001\u001a\u0005\u0018\u00010à\u00012\n\u0010á\u0001\u001a\u0005\u0018\u00010²\u0001H\u0016J\n\u0010â\u0001\u001a\u00030¢\u0001H\u0016J\u001c\u0010ã\u0001\u001a\u00030¢\u00012\u0007\u0010ä\u0001\u001a\u00020\u00072\u0007\u0010å\u0001\u001a\u00020mH\u0016JE\u0010æ\u0001\u001a\u00030¢\u00012\u0007\u0010ç\u0001\u001a\u00020W2\u000e\u0010è\u0001\u001a\t\u0012\u0004\u0012\u00020W0é\u00012\u000f\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030Á\u00010é\u00012\u000f\u0010ë\u0001\u001a\n\u0012\u0005\u0012\u00030ì\u00010é\u0001H\u0002J\u001e\u0010í\u0001\u001a\u00030¢\u00012\u0007\u0010¸\u0001\u001a\u00020m2\t\b\u0002\u0010Ù\u0001\u001a\u00020mH\u0002J\u0014\u0010î\u0001\u001a\u00030¢\u00012\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\u0014\u0010ï\u0001\u001a\u00030¢\u00012\b\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\t\u0010ð\u0001\u001a\u00020mH\u0002J\t\u0010ñ\u0001\u001a\u00020mH\u0002J\f\u0010ò\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0016J\u0013\u0010ó\u0001\u001a\u00030¢\u00012\u0007\u0010ô\u0001\u001a\u00020mH\u0002J\t\u0010õ\u0001\u001a\u00020mH\u0002J\n\u0010ö\u0001\u001a\u00030¢\u0001H\u0002J\t\u0010÷\u0001\u001a\u00020\u0007H\u0002J\t\u0010ø\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010ù\u0001\u001a\u00020m2\b\u0010ú\u0001\u001a\u00030û\u0001H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0010\u001a\u0004\b;\u0010<R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0010\u001a\u0004\b@\u0010AR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0010\u001a\u0004\bE\u0010FR\u001d\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0010\u001a\u0004\bJ\u0010KR\u001d\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0010\u001a\u0004\bO\u0010PR\u0016\u0010R\u001a\u0004\u0018\u00010S8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0016\u0010V\u001a\u0004\u0018\u00010W8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0016\u0010Z\u001a\u0004\u0018\u00010I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b[\u0010KR\u0016\u0010\\\u001a\u0004\u0018\u00010]8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u001d\u0010`\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u0010\u001a\u0004\ba\u0010PR\u0016\u0010c\u001a\u0004\u0018\u00010I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010KR\u0016\u0010e\u001a\u0004\u0018\u00010W8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bf\u0010YR\u001b\u0010g\u001a\u00020h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u0010\u001a\u0004\bi\u0010jR\u000e\u0010l\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010w\u001a\u00060xR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\u0010\u001a\u0004\by\u0010zR\u0010\u0010|\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010~\u001a\u00020\u007fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0080\u0001\u001a\u00030\u0081\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0084\u0001\u0010\u0010\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001e\u0010\u0085\u0001\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010\u0010\u001a\u0005\b\u0086\u0001\u0010YR\u001e\u0010\u0088\u0001\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\u0010\u001a\u0005\b\u0089\u0001\u0010YR \u0010\u008b\u0001\u001a\u00030\u008c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008f\u0001\u0010\u0010\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u0090\u0001\u001a\u00030\u008c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0092\u0001\u0010\u0010\u001a\u0006\b\u0091\u0001\u0010\u008e\u0001R \u0010\u0093\u0001\u001a\u00030\u008c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0095\u0001\u0010\u0010\u001a\u0006\b\u0094\u0001\u0010\u008e\u0001R \u0010\u0096\u0001\u001a\u00030\u008c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0098\u0001\u0010\u0010\u001a\u0006\b\u0097\u0001\u0010\u008e\u0001R \u0010\u0099\u0001\u001a\u00030\u008c\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009b\u0001\u0010\u0010\u001a\u0006\b\u009a\u0001\u0010\u008e\u0001R \u0010\u009c\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b \u0001\u0010\u0010\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001e\u0010¦\u0001\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b¨\u0001\u0010\u0010\u001a\u0005\b§\u0001\u0010YR \u0010©\u0001\u001a\u00030ª\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u00ad\u0001\u0010\u0010\u001a\u0006\b«\u0001\u0010¬\u0001R\u0019\u0010®\u0001\u001a\f\u0012\u0005\u0012\u00030¢\u0001\u0018\u00010¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006þ\u0001"}, d2 = {"Lcom/obric/assistant/window/ObricWindowExtraViewComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/window/ability/IObricWindowExtraViewAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "<init>", "()V", "minLightAlpha", "", "maxLightAlpha", "minShadowAlpha", "maxShadowAlpha", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "Lkotlin/Lazy;", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "msgAbility", "Lcom/obric/assistant/window/ability/IObricMsgAbility;", "getMsgAbility", "()Lcom/obric/assistant/window/ability/IObricMsgAbility;", "msgAbility$delegate", "actionBarAbility", "Lcom/obric/assistant/ability/IObricActionBarAbility;", "getActionBarAbility", "()Lcom/obric/assistant/ability/IObricActionBarAbility;", "actionBarAbility$delegate", "specialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "specialInputAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "conversationAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getConversationAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "conversationAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "bottomMenuAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "input", "Landroid/widget/FrameLayout;", "getInput", "()Landroid/widget/FrameLayout;", "input$delegate", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "actionSend", "Landroid/view/View;", "getActionSend", "()Landroid/view/View;", "actionBarContainer", "getActionBarContainer", "actionBarRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getActionBarRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "bottomLayout", "getBottomLayout", "bottomLayout$delegate", "speakArea", "getSpeakArea", "actionFullScreen", "getActionFullScreen", "windowActionView", "Landroidx/appcompat/widget/AppCompatImageView;", "getWindowActionView", "()Landroidx/appcompat/widget/AppCompatImageView;", "windowActionView$delegate", "speakerVisible", "", "voiceVisible", "mockSpeakerVisible", "instructionPanelVisible", "attachmentPanelVisible", "inputReplyPanelVisible", "messageModifyPanelVisible", "mentionPanelVisible", "voiceViewAppearAnimator", "Landroid/animation/AnimatorSet;", "actionBarSwipeGestureForwarder", "Lcom/obric/assistant/window/ObricWindowExtraViewComponent$ActionBarSwipeGestureForwarder;", "getActionBarSwipeGestureForwarder", "()Lcom/obric/assistant/window/ObricWindowExtraViewComponent$ActionBarSwipeGestureForwarder;", "actionBarSwipeGestureForwarder$delegate", "monitorSpecialInputJob", "Lkotlinx/coroutines/Job;", "windowBottomMenuColorStyle", "Lcom/larus/bmhome/view/BottomMenuColorStyle;", "lightView", "Lcom/obric/assistant/view/GradientEffectView;", "getLightView", "()Lcom/obric/assistant/view/GradientEffectView;", "lightView$delegate", "lightReferView", "getLightReferView", "lightReferView$delegate", "bgTopView", "getBgTopView", "bgTopView$delegate", "spaceLeft", "Landroid/widget/Space;", "getSpaceLeft", "()Landroid/widget/Space;", "spaceLeft$delegate", "spaceRight", "getSpaceRight", "spaceRight$delegate", "spaceTop", "getSpaceTop", "spaceTop$delegate", "spaceBottom", "getSpaceBottom", "spaceBottom$delegate", "gestureReferView", "getGestureReferView", "gestureReferView$delegate", "gestureView", "Lcom/obric/assistant/view/ObricIconSwipeUpView;", "getGestureView", "()Lcom/obric/assistant/view/ObricIconSwipeUpView;", "gestureView$delegate", "setVoiceViewVisibleAnimated", "", "visible", "duration", "", "interceptView", "getInterceptView", "interceptView$delegate", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", "animator$delegate", "onCancel", "Lkotlin/Function0;", "mobWindowSwipeUp", "beforeSwipePageState", "", "afterState", "onCreate", "init", "setupWindowActionView", "updateWindowActionView", "isChatWindow", "updateActionBarLayoutForWindowActionView", "setupActionBarContainerSwipeGesture", "swipeIcon", "distance", "(Ljava/lang/Float;)V", "setTagForBottomMenuIcon", "iconMap", "", "Landroid/widget/ImageView;", "onParentViewCreated", "monitorSpecialInputOpenState", "setupBottomMenuStyleCallback", "onDestroy", "onChatStyleChanged", "onPageStateChanged", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "updateBottomMenuProgress", "progress", "getBaseAlpha", "id", "", "(I)Ljava/lang/Float;", "onInstructionVisibleChanged", "instructionOpen", "onAttachmentPanelVisibleChanged", "onInputReplyPanelVisibleChange", "inVisibleState", "onMessageModifyPanelVisibleChange", "onMentionPanelVisibleChange", "checkInputAboveLayoutVisible", "onSpeakerStatusSwitch", "toCancel", "onSpeakerVisibilityChanged", "onMockSpeakerVisibleChanged", "callback", "setVoiceViewVisible", "isResumeClickTalk", "listeningUiHandle", "Lcom/obric/assistant/ability/ObricListeningUiHandle;", "startupAttemptId", "setInputTextListener", "resetChatWindowLightAlpha", "alpha", "half", "setBottomMenuStyle", "rootView", "areaViews", "", "iconArray", "textViews", "Landroid/widget/TextView;", "updateLightViewAlpha", "animateVoiceViewAppear", "animateVoiceViewDisappear", "isSpeakerVisible", "isLandscapeFullWindow", "getBottomGestureView", "onInputHeightChanged", "panelVisible", "hasInputAbovePanelVisible", "invalidateLatestMessageBottomInset", "getShadowViewBaseAlpha", "getLightViewBaseAlpha", "isActivatePhase", "phase", "Lcom/obric/assistant/state/api/multitask/ForegroundInteractionPhase;", "Companion", "ActionBarSwipeGestureForwarder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricWindowExtraViewComponent extends BaseContentWidget implements xha.e, hca.b {
    public static final /* synthetic */ int k0 = 0;
    public final Lazy A;
    public final Lazy B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public AnimatorSet K;
    public final Lazy L;
    public Job M;
    public final com.larus.bmhome.view.b N;
    public final Lazy O;
    public final Lazy P;
    public final Lazy Q;
    public final Lazy R;
    public final Lazy S;
    public final Lazy T;
    public final Lazy U;
    public final Lazy V;
    public final Lazy W;
    public final Lazy X;
    public final Lazy Y;
    public Function0<Unit> Z;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public final class a {
        public final int a;
        public MotionEvent b;
        public float c;
        public float d;
        public boolean e;
        public final /* synthetic */ ObricWindowExtraViewComponent f;

        public final boolean a() {
            ObricWindowExtraViewComponent r0 = this.f;
            int r1 = ObricWindowExtraViewComponent.k0;
            if (r0.B3().isEnabled() == true) goto L5;
            return false;
        L5:
            if (this.f.B3().getVisibility() != 0) goto L7;
            boolean r2 = true;
        L8:
            if (r2 == false) goto L12;
            return true;
        L12:
            return false;
        L7:
            r2 = false;
            goto L8
        }

        public final void b() {
            MotionEvent r0 = this.b;
            if (r0 == null) goto L5;
            r0.recycle();
        L5:
            this.b = null;
            this.e = false;
        }

        public a(ObricWindowExtraViewComponent r1) {
            this.f = r1;
            this.a = ViewConfiguration.get(r1.getContext()).getScaledTouchSlop();
        }

        public final void c(MotionEvent r3) {
            MotionEvent r4 = MotionEvent.obtain(r3);
            ObricWindowExtraViewComponent r0 = this.f;
            int r1 = ObricWindowExtraViewComponent.k0;
            r0.B3().dispatchTouchEvent(r4);
            r4.recycle();
        }

        public final void e(MotionEvent r2) {
            b();
            this.b = MotionEvent.obtain(r2);
            this.c = r2.getRawX();
            this.d = r2.getRawY();
        }

        public final boolean f(MotionEvent r3) {
            float r0 = r3.getRawY() - this.d;
            float r4 = r3.getRawX() - this.c;
            if (r0 < (-this.a)) goto L5;
        L7:
            return false;
        L5:
            if (Math.abs(r0) <= Math.abs(r4)) goto L7;
            return true;
        }

        public static boolean d(View r3, MotionEvent r4) {
            if (r4.getX() >= 0.0f) goto L5;
        L11:
            return false;
        L5:
            if (r4.getX() >= r3.getWidth()) goto L11;
            if (r4.getY() < 0.0f) goto L11;
            if (r4.getY() >= r3.getHeight()) goto L11;
            return true;
        }
    }

    public static final class b {
    }

    public static final class c implements ObricIconSwipeUpView.c {
        public final /* synthetic */ ObricWindowExtraViewComponent a;
        public final /* synthetic */ Ref.ObjectRef<String> b;
        public final /* synthetic */ ObricIconSwipeUpView c;

        @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
        public final void c() {
            ObricWindowExtraViewComponent r0 = this.a;
            int r1 = ObricWindowExtraViewComponent.k0;
            laa.d r2 = r0.E3();
            String r3 = null;
            if (r2 == null) goto L5;
            ObricFloatChatPageState r4 = r2.getPageState();
        L6:
            Ref.ObjectRef<String> r5 = this.b;
            if (r4 == null) goto L9;
            r3 = r4.getClass().getSimpleName();
        L9:
            r5.element = r3;
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
        public final void b(float r10) {
            ObricWindowExtraViewComponent r0 = this.a;
            int r1 = ObricWindowExtraViewComponent.k0;
            if (r0.V3() == false) goto L5;
            return;
        L5:
            laa.d r2 = this.a.E3();
            if (r2 == null) goto L8;
            laa.d.a.d(r2, true, m2.b, Float.valueOf(r10), true, false, PageStateChangedReason.SWIPE_UP_VIEW, 16);
        L8:
            this.c.c();
            ObricWindowExtraViewComponent r11 = this.a;
            String r3 = (String) this.b.element;
            ObricFloatChatPageData.Companion.getClass();
            ObricWindowExtraViewComponent.Y2(r11, r3, ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp());
        }

        @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
        public final void onClick(boolean r9) {
            ObricWindowExtraViewComponent r0 = this.a;
            int r1 = ObricWindowExtraViewComponent.k0;
            if (r0.V3() == false) goto L5;
            return;
        L5:
            if (r9 == false) goto L10;
            laa.d r2 = this.a.E3();
            if (r2 == null) goto L9;
            laa.d.a.d(r2, true, m2.b, null, true, false, PageStateChangedReason.SWIPE_UP_VIEW, 20);
        L9:
            ObricWindowExtraViewComponent r10 = this.a;
            String r3 = (String) this.b.element;
            ObricFloatChatPageData.Companion.getClass();
            ObricWindowExtraViewComponent.Y2(r10, r3, ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp());
            return;
        L10:
            laa.d r11 = this.a.E3();
            if (r11 == null) goto L15;
            r11.Gm(false);
            return;
        }

        @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
        public final void d(float r13, boolean r14) {
            ObricWindowExtraViewComponent r0 = this.a;
            int r1 = ObricWindowExtraViewComponent.k0;
            laa.d r2 = r0.E3();
            if (r2 == null) goto L5;
            ObricFloatChatPageState r3 = r2.getPageState();
        L6:
            ObricFloatChatPageData.Companion.getClass();
            boolean r4 = r3 instanceof vda.a;
            boolean r5 = r3 instanceof vda.e;
            boolean r6 = r3 instanceof vda.c;
            if (r3 == null) goto L9;
            ObricFloatChatPageState r7 = r3.getPreviousState();
        L10:
            boolean r8 = r7 instanceof vda.e;
            boolean r9 = true;
            if (r5 == true) goto L16;
            if (r6 == false) goto L15;
            if (r8 == true) goto L16;
        L15:
            boolean r10 = false;
        L17:
            FLogger.a.i("ObricWindowExtraViewComponent", "onSwipeFinish distance=" + r13 + ", swipeUp=" + r14 + ", isChatWindow=" + r4 + ", isHalfWindow=" + r5 + ", isDragging=" + r6 + ", isPreviousHalfWindow=" + r8 + ", pageState=" + r3);
            if (this.a.V3() == false) goto L21;
            this.c.c();
            return;
        L21:
            if (r3 != null) goto L23;
        L25:
            r9 = false;
        L26:
            int r11 = Integer.MAX_VALUE;
            if (r9 == true) goto L38;
            if (r3 == null) goto L30;
            int r12 = r3.getHeight();
        L32:
            if (r12 > m2.e) goto L38;
            laa.d r15 = this.a.E3();
            if (r15 == null) goto L36;
            laa.d.a.c(r15, null, false, "swipe_up", 3);
        L36:
            String r16 = ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp();
        L53:
            this.c.c();
            ObricWindowExtraViewComponent.Y2(this.a, (String) this.b.element, r16);
            return;
        L30:
            r12 = Integer.MAX_VALUE;
        L38:
            if (r13 <= (-i5.k0())) goto L44;
            if (r10 == false) goto L49;
            if (r3 == null) goto L43;
            r11 = r3.getHeight();
        L43:
            if (r11 <= m2.b) goto L44;
        L49:
            laa.d r17 = this.a.E3();
            if (r17 == null) goto L52;
            laa.d.a.a(r17, 0.0f, false, 3);
        L52:
            r16 = ObricFloatChatPageData.access$getCHAT_WINDOW_SIMPLE_NAME$cp();
        L44:
            if (r14 == false) goto L49;
            laa.d r18 = this.a.E3();
            if (r18 == null) goto L48;
            laa.d.a.d(r18, true, m2.b, null, true, false, PageStateChangedReason.SWIPE_UP_VIEW, 20);
        L48:
            r16 = ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp();
            goto L53
        L23:
            if (r3.getHeight() != 0) goto L25;
        L16:
            r10 = true;
            goto L17
        L9:
            r7 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }

        public c(ObricWindowExtraViewComponent r1, Ref.ObjectRef<String> r2, ObricIconSwipeUpView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // com.obric.assistant.view.ObricIconSwipeUpView.c
        public final void a(float r4, float r5, boolean r6) {
            ObricWindowExtraViewComponent r0 = this.a;
            int r1 = ObricWindowExtraViewComponent.k0;
            if (r0.V3() == false) goto L5;
            return;
        L5:
            if (r6 == false) goto L27;
            laa.d r7 = this.a.E3();
            int r2 = 0;
            if (r7 == null) goto L13;
            ObricFloatChatPageState r8 = r7.getPageState();
            if (r8 == null) goto L13;
            ObricFloatChatPageData.Companion.getClass();
            boolean r3 = true;
            if ((r8 instanceof vda.a) != true) goto L13;
        L14:
            if (r3 == false) goto L16;
            int r9 = yha.w.c;
            r2 = yha.w.a.a((ViewGroup) this.a.y.getValue(), (FrameLayout) this.a.z.getValue(), (FrameLayout) this.a.A.getValue(), this.a.m3());
        L21:
            laa.d r10 = this.a.E3();
            if (r10 == null) goto L25;
            r10.o2(r2 + ((int) r5));
        L25:
            if (r4 < (-i5.k0())) goto L32;
            this.c.d(r4);
            return;
        L32:
            return;
        L16:
            laa.d r11 = this.a.E3();
            if (r11 == null) goto L21;
            ObricFloatChatPageState r12 = r11.getPageState();
            if (r12 == null) goto L21;
            r2 = r12.getHeight();
        L13:
            r3 = false;
            goto L14
        L27:
            laa.d r13 = this.a.E3();
            if (r13 == null) goto L30;
            int r14 = yha.w.c;
            r13.o2(yha.w.a.a((ViewGroup) this.a.y.getValue(), (FrameLayout) this.a.z.getValue(), (FrameLayout) this.a.A.getValue(), this.a.m3()));
        L30:
            this.c.d(((i5.q() * 0.15f) * r4) / (i5.q() + (r4 * 0.15f)));
        }
    }

    public static final class d implements Function0<va8.a0> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.a0.class));
        }
    }

    public static final class e implements Function0<com.larus.bmhome.chat.component.bottom.bottommenu.f1> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class));
        }
    }

    public static final class f implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class g implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class h implements Function0<com.larus.bmhome.chat.component.bottom.attachment.g1> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.attachment.g1.class));
        }
    }

    public static final class i implements Function0<laa.f> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.f.class));
        }
    }

    public static final class j implements Function0<xha.b> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(xha.b.class));
        }
    }

    public static final class k implements Function0<laa.b> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.b.class));
        }
    }

    public static final class l implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    public static final class m implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class n implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    static {
    }

    public final void L10(float r1) {
    }

    public final void Rb() {
        GC(false, false, null, null);
    }

    public final void Tb() {
        GC(true, true, null, null);
    }

    public final void B2() {
        FLogger.a.i("ObricWindowExtraViewComponent", "onParentViewCreated " + hashCode());
        Job r0 = this.M;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        laa.j r1 = (laa.j) this.s.getValue();
        if (r1 == null) goto L12;
        kotlinx.coroutines.flow.b1 r2 = r1.O4();
        if (r2 == null) goto L13;
        this.M = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricWindowExtraViewComponent$monitorSpecialInputOpenState$1(r2, this, null), 3, null);
        return;
    L13:
        return;
    }

    public final ObricIconSwipeUpView B3() {
        return (ObricIconSwipeUpView) this.W.getValue();
    }

    public final va8.c C3() {
        va8.o r0 = (va8.o) this.u.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Uv();
    }

    @Override // xha.e
    public final void Cq() {
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r0 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) this.w.getValue();
        if (r0 == null) goto L5;
        r0.t00(new v3(this));
        return;
    L5:
        FLogger.a.w("ObricWindowExtraViewComponent", "setupBottomMenuStyleCallback skipped, bottomMenuAbility is null");
    }

    public final GradientEffectView D3() {
        return (GradientEffectView) this.O.getValue();
    }

    public final laa.d E3() {
        return (laa.d) this.m.getValue();
    }

    public final AppCompatImageView H3() {
        return (AppCompatImageView) this.B.getValue();
    }

    public final boolean Q3() {
        if (this.F == false) goto L5;
        return true;
    L5:
        if (this.G == false) goto L7;
        return true;
    L7:
        if (this.H == false) goto L9;
        return true;
    L9:
        if (this.I == false) goto L11;
        return true;
    L11:
        if (this.J == true) goto L28;
        laa.j r0 = (laa.j) this.s.getValue();
        if (r0 == null) goto L19;
        kotlinx.coroutines.flow.b1 r1 = r0.O4();
        if (r1 == null) goto L19;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L19;
        boolean r2 = true;
    L20:
        if (r2 == true) goto L29;
        return false;
    L29:
        return true;
    L19:
        r2 = false;
        goto L20
    L28:
        return true;
    }

    public final boolean V3() {
        ObricFloatChatPageData.a r0 = ObricFloatChatPageData.Companion;
        laa.d r1 = E3();
        if (r1 == null) goto L5;
        ObricFloatChatPageState r2 = r1.getPageState();
    L6:
        r0.getClass();
        if ((r2 instanceof vda.f) == false) goto L9;
        return true;
    L9:
        if (s1a.a.e(this) == false) goto L20;
        Resources r3 = getContext().getResources();
        if (r3 == null) goto L17;
        Configuration r4 = r3.getConfiguration();
        if (r4 == null) goto L17;
        if (r4.orientation != 2) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        return true;
    L17:
        r5 = false;
    L20:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    @Override // xha.e
    public final void init() {
        ViewGroup r0 = (ViewGroup) this.y.getValue();
        if (r0 == null) goto L5;
        int r1 = r0.indexOfChild((FrameLayout) this.z.getValue()) - 1;
        Space r2 = (Space) this.R.getValue();
        ViewGroup.LayoutParams r3 = new ConstraintLayout.LayoutParams(i5.m0(), 0);
        ((ConstraintLayout.LayoutParams) r3).endToStart = 2131375324;
        ((ConstraintLayout.LayoutParams) r3).topToTop = 2131375324;
        ((ConstraintLayout.LayoutParams) r3).bottomToBottom = 2131375324;
        Unit r6 = Unit.INSTANCE;
        r0.addView(r2, r1, r3);
        Space r4 = (Space) this.S.getValue();
        ViewGroup.LayoutParams r5 = new ConstraintLayout.LayoutParams(i5.m0(), 0);
        ((ConstraintLayout.LayoutParams) r5).startToEnd = 2131375324;
        ((ConstraintLayout.LayoutParams) r5).topToTop = 2131375324;
        ((ConstraintLayout.LayoutParams) r5).bottomToBottom = 2131375324;
        r0.addView(r4, r1, r5);
        Space r7 = (Space) this.T.getValue();
        ViewGroup.LayoutParams r8 = new ConstraintLayout.LayoutParams(0, i5.A());
        ((ConstraintLayout.LayoutParams) r8).bottomToTop = 2131375324;
        ((ConstraintLayout.LayoutParams) r8).startToStart = 2131375324;
        ((ConstraintLayout.LayoutParams) r8).endToEnd = 2131375324;
        r0.addView(r7, r1, r8);
        Space r9 = (Space) this.U.getValue();
        ViewGroup.LayoutParams r10 = new ConstraintLayout.LayoutParams(0, i5.m0());
        ((ConstraintLayout.LayoutParams) r10).topToBottom = 2131375324;
        ((ConstraintLayout.LayoutParams) r10).startToStart = 2131375324;
        ((ConstraintLayout.LayoutParams) r10).endToEnd = 2131375324;
        r0.addView(r9, r1, r10);
        View r11 = (View) this.P.getValue();
        ViewGroup.LayoutParams r12 = new ConstraintLayout.LayoutParams(0, i5.a0());
        ((ConstraintLayout.LayoutParams) r12).topToTop = 2131364480;
        ((ConstraintLayout.LayoutParams) r12).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r12).endToEnd = 0;
        r0.addView(r11, r1, r12);
        GradientEffectView r13 = D3();
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(0, 0);
        r14.startToStart = 2131381256;
        r14.endToEnd = 2131381257;
        r14.topToTop = 2131381258;
        r14.bottomToBottom = 2131381255;
        r14.setMarginStart(i5.l0());
        r14.setMarginEnd(i5.l0());
        ((ViewGroup.MarginLayoutParams) r14).topMargin = i5.l0();
        ((ViewGroup.MarginLayoutParams) r14).bottomMargin = i5.l0();
        r0.addView(r13, r1, r14);
        View r15 = (View) this.Q.getValue();
        ConstraintLayout.LayoutParams r16 = new ConstraintLayout.LayoutParams(0, i5.d());
        r16.bottomToTop = 2131375324;
        r16.startToStart = 2131375324;
        r16.endToEnd = 2131375324;
        ((ViewGroup.MarginLayoutParams) r16).bottomMargin = i5.c0();
        r0.addView(r15, r1, r16);
        Space r17 = (Space) this.V.getValue();
        ViewGroup.LayoutParams r18 = new ConstraintLayout.LayoutParams(0, i5.h());
        ((ConstraintLayout.LayoutParams) r18).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r18).topToTop = 2131375324;
        r0.addView(r17, 0, r18);
        ObricIconSwipeUpView r19 = B3();
        ConstraintLayout.LayoutParams r20 = new ConstraintLayout.LayoutParams(0, c7.b(160));
        r20.startToStart = 0;
        r20.endToEnd = 0;
        r20.bottomToBottom = 2131381194;
        ((ViewGroup.MarginLayoutParams) r20).bottomMargin = i5.h();
        r0.addView(r19, r20);
        View r21 = (View) this.X.getValue();
        ViewGroup.LayoutParams r22 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams) r22).startToStart = 0;
        ((ConstraintLayout.LayoutParams) r22).endToEnd = 0;
        ((ConstraintLayout.LayoutParams) r22).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r22).bottomToBottom = 0;
        r0.addView(r21, r22);
    L5:
        ViewGroup r23 = m3();
        if (r23 == null) goto L8;
        r23.setOnTouchListener(new t3(this));
    L8:
        RecyclerView r24 = p3();
        if (r24 == null) goto L11;
        r24.addOnItemTouchListener(new ObricWindowExtraViewComponent$setupActionBarContainerSwipeGesture$2(this));
    L11:
        X3();
    }

    public ObricWindowExtraViewComponent() {
        this.m = LazyKt.lazy(new f(this));
        this.n = LazyKt.lazy(new g(this));
        this.o = LazyKt.lazy(new h(this));
        this.p = LazyKt.lazy(new i(this));
        this.q = LazyKt.lazy(new j(this));
        this.r = LazyKt.lazy(new k(this));
        this.s = LazyKt.lazy(new l(this));
        this.t = LazyKt.lazy(new m(this));
        this.u = LazyKt.lazy(new n(this));
        this.v = LazyKt.lazy(new d(this));
        this.w = LazyKt.lazy(new e(this));
        this.x = LazyKt.lazy(new y3(this));
        this.y = LazyKt.lazy(new h3(this));
        this.z = LazyKt.lazy(new i3(this));
        this.A = LazyKt.lazy(new j3(this));
        this.B = LazyKt.lazy(new k3(this));
        this.L = LazyKt.lazy(new l3(this));
        this.N = new com.larus.bmhome.view.b(2131104354, 1.0f, -1, 21, 2131245964);
        this.O = LazyKt.lazy(new m3(this));
        this.P = LazyKt.lazy(new n3(this));
        this.Q = LazyKt.lazy(new o3(this));
        this.R = LazyKt.lazy(new p3(this));
        this.S = LazyKt.lazy(new z3(this));
        this.T = LazyKt.lazy(new a4(this));
        this.U = LazyKt.lazy(new b4(this));
        this.V = LazyKt.lazy(new c4(this));
        this.W = LazyKt.lazy(new d4(this));
        this.X = LazyKt.lazy(new e4(this));
        this.Y = LazyKt.lazy(new g3());
    }

    public final ViewGroup G3() {
        com.larus.bmhome.chat.component.bottom.core.a r0 = C3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.H();
    }

    public final View LD() {
        return D3();
    }

    public final void P00() {
        if (s1a.a.e(this) == false) goto L8;
        xha.b r0 = (xha.b) this.q.getValue();
        if (r0 == null) goto L9;
        r0.P00();
        return;
    L9:
        return;
    }

    public final void X3() {
        if (s1a.a.e(this) == true) goto L5;
        return;
    L5:
        laa.d r0 = E3();
        if (r0 == null) goto L12;
        ObricFloatChatPageState r1 = r0.getPageState();
        if (r1 == null) goto L12;
        ObricFloatChatPageData.Companion.getClass();
        boolean r2 = true;
        if ((r1 instanceof vda.a) != true) goto L12;
    L13:
        AppCompatImageView r3 = H3();
        if (r2 == false) goto L16;
        int r4 = 2131238103;
    L17:
        r3.setImageResource(r4);
        H3().clearColorFilter();
        boolean r5 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L20;
        H3().setColorFilter(ContextCompat.getColor(getContext(), 2131104350));
    L20:
        ViewGroup r6 = m3();
        ConstraintLayout.LayoutParams r7 = null;
        if ((r6 instanceof ViewGroup) == true) goto L24;
        r6 = null;
    L24:
        if (r6 != null) goto L27;
        return;
    L27:
        if (H3().getParent() == r6) goto L35;
        ViewParent r8 = H3().getParent();
        if ((r8 instanceof ViewGroup) == false) goto L31;
        ViewGroup r9 = (ViewGroup) r8;
    L32:
        if (r9 == null) goto L34;
        r9.removeView(H3());
    L34:
        r6.addView(H3());
        goto L35
    L31:
        r9 = null;
    L35:
        RecyclerView r10 = p3();
        if (r10 == null) goto L38;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
    L40:
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L42;
        r7 = (ConstraintLayout.LayoutParams) r11;
    L42:
        if (r7 == null) goto L47;
        RecyclerView r12 = p3();
        if (r12 == null) goto L48;
        ((ViewGroup.MarginLayoutParams) r7).width = 0;
        r7.startToStart = 0;
        r7.endToStart = H3().getId();
        r7.topToTop = 0;
        r7.bottomToBottom = 0;
        r12.setLayoutParams(r7);
        return;
    L48:
        return;
    L47:
        return;
    L38:
        r11 = null;
        goto L40
    L16:
        r4 = 2131238102;
    L12:
        r2 = false;
        goto L13
    }

    public final void h3() {
        boolean r0 = Q3();
        FLogger.a.i("ObricWindowExtraViewComponent", "checkInputAboveLayoutVisible " + r0);
        laa.b r1 = (laa.b) this.r.getValue();
        if (r1 == null) goto L6;
        r1.XQ(r0);
        return;
    }

    public final ViewGroup m3() {
        com.larus.bmhome.chat.component.bottom.core.a r0 = C3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        laa.d r0 = E3();
        if (r0 == null) goto L6;
        r0.HU(this);
        return;
    }

    public final void onDestroy() {
        laa.d r0 = E3();
        if (r0 == null) goto L5;
        r0.AN(this);
    L5:
        ViewParent r1 = H3().getParent();
        if ((r1 instanceof ViewGroup) == false) goto L8;
        ViewGroup r2 = (ViewGroup) r1;
    L9:
        if (r2 == null) goto L11;
        r2.removeView(H3());
    L11:
        Job r3 = this.M;
        if (r3 == null) goto L14;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L14:
        this.M = null;
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final RecyclerView p3() {
        va8.c r0 = C3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    public final ObricIconSwipeUpView qR() {
        return B3();
    }

    public final void x8() {
        va8.c r0 = C3();
        if (r0 == null) goto L6;
        r0.g(new w3(this));
        return;
    }

    public final View z3() {
        com.larus.bmhome.chat.component.bottom.core.a r0 = C3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.y();
    }

    public final void DH(boolean r14) {
        AnimatorSet r0 = this.K;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.K = null;
        boolean r2 = true;
        float r9 = 0.0f;
        if (r14 == false) goto L91;
        ICoreInputAbility r15 = (ICoreInputAbility) this.t.getValue();
        if (r15 == null) goto L10;
        r15.g2(2, true);
    L10:
        va8.o r16 = (va8.o) this.u.getValue();
        if (r16 == null) goto L13;
        r16.ra();
    L13:
        ICoreInputAbility r17 = (ICoreInputAbility) this.t.getValue();
        if (r17 == null) goto L16;
        r17.qp(false);
    L16:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r18 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.o.getValue();
        if (r18 != null) goto L19;
    L21:
        boolean r19 = false;
    L22:
        if (r19 == false) goto L30;
        View r110 = z3();
        if (r110 == null) goto L46;
        ViewGroup.LayoutParams r11 = r110.getLayoutParams();
        if (r11 == null) goto L29;
        r11.width = 0;
        r110.setLayoutParams(r11);
        goto L46
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L46:
        laa.f r111 = (laa.f) this.p.getValue();
        if (r111 != null) goto L49;
    L51:
        boolean r112 = false;
    L52:
        if (r112 == false) goto L72;
        laa.f r113 = (laa.f) this.p.getValue();
        if (r113 == null) goto L56;
        r113.LE(true);
    L56:
        laa.d r114 = E3();
        if (r114 == null) goto L59;
        r114.C00(true);
    L59:
        this.D = true;
        ViewGroup r115 = G3();
        if (r115 == null) goto L62;
        r115.setScaleX(0.0f);
    L62:
        ViewGroup r116 = G3();
        if (r116 == null) goto L65;
        r116.setScaleY(0.0f);
    L65:
        laa.d r117 = E3();
        if (r117 != null) goto L68;
    L70:
        r2 = false;
    L71:
        Z3(this, r2);
        return;
    L68:
        if (r117.aF() != true) goto L70;
    L72:
        com.larus.utils.t0.d(new x3(this), 150);
        laa.d r118 = E3();
        if (r118 == null) goto L75;
        r118.C00(true);
    L75:
        this.D = true;
        ArrayList r119 = new ArrayList();
        ViewGroup r8 = G3();
        if (r8 == null) goto L78;
        r8.setAlpha(1.0f);
        r8.setScaleX(1.0f);
        r8.setScaleY(1.0f);
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r8, View.ALPHA, new float[]{1.0f, 0.0f});
        r10.setDuration(150);
        r10.addListener(new f4(this, r8));
        r119.add(r10);
    L78:
        laa.d r12 = E3();
        if (r12 != null) goto L81;
    L83:
        boolean r13 = false;
    L84:
        boolean r20 = v19.h.a;
        boolean r21 = v19.h.b(getContext());
        if (r13 == false) goto L87;
        float r22 = 1.0f;
    L90:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(D3(), View.ALPHA, new float[]{D3().getAlpha(), r22});
        r3.setDuration(150);
        r3.setStartDelay(150);
        r119.add(r3);
        AnimatorSet r4 = new AnimatorSet();
        r4.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r4.playTogether(r119);
        r4.addListener(new g4(this));
        r4.start();
        this.K = r4;
        return;
    L87:
        if (r21 == false) goto L89;
        r22 = 0.6f;
        goto L90
    L89:
        r22 = 0.32f;
        goto L90
    L81:
        if (r12.aF() != true) goto L83;
        r13 = true;
        goto L84
    L49:
        if (r111.kT() != true) goto L51;
        r112 = true;
        goto L52
    L30:
        View r120 = z3();
        if (r120 == null) goto L37;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        if (r121 == null) goto L37;
        if (r121.width != i5.c0()) goto L37;
        boolean r122 = true;
    L38:
        if (r122 == true) goto L46;
        View r123 = z3();
        if (r123 == null) goto L46;
        ViewGroup.LayoutParams r124 = r123.getLayoutParams();
        if (r124 == null) goto L45;
        r124.width = i5.c0();
        r123.setLayoutParams(r124);
        goto L46
    L45:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L37:
        r122 = false;
        goto L38
    L19:
        if (r18.isVisible() != true) goto L21;
        r19 = true;
        goto L22
    L91:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r125 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.o.getValue();
        if (r125 != null) goto L94;
    L96:
        boolean r126 = false;
    L97:
        if (r126 == true) goto L114;
        View r127 = z3();
        if (r127 == null) goto L105;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if (r128 == null) goto L105;
        if (r128.width != i5.c0()) goto L105;
        boolean r129 = true;
    L106:
        if (r129 == true) goto L114;
        View r130 = z3();
        if (r130 == null) goto L114;
        ViewGroup.LayoutParams r131 = r130.getLayoutParams();
        if (r131 == null) goto L113;
        r131.width = i5.c0();
        r130.setLayoutParams(r131);
        goto L114
    L113:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L105:
        r129 = false;
    L114:
        Function0<Unit> r132 = this.Z;
        if (r132 == null) goto L117;
        r132.invoke();
    L117:
        laa.d r133 = E3();
        if (r133 == null) goto L120;
        r133.C00(false);
    L120:
        this.D = false;
        ArrayList r134 = new ArrayList();
        ViewGroup r23 = G3();
        if (r23 == null) goto L123;
        r23.setAlpha(0.0f);
        r23.setScaleX(1.0f);
        r23.setScaleY(1.0f);
        ObjectAnimator r24 = ObjectAnimator.ofFloat(r23, View.ALPHA, new float[]{0.0f, 1.0f});
        r24.setDuration(150);
        r24.setStartDelay(150);
        r134.add(r24);
    L123:
        laa.d r25 = E3();
        if (r25 != null) goto L126;
    L128:
        boolean r26 = false;
    L129:
        if (r26 == false) goto L131;
        r9 = 0.4f;
    L131:
        ObjectAnimator r5 = ObjectAnimator.ofFloat(D3(), View.ALPHA, new float[]{D3().getAlpha(), r9});
        r5.setDuration(150);
        r134.add(r5);
        com.larus.utils.t0.d(new f3(this), 150);
        AnimatorSet r6 = new AnimatorSet();
        r6.setInterpolator(new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f));
        r6.playTogether(r134);
        r6.addListener(new h4(this));
        r6.start();
        this.K = r6;
        return;
    L126:
        if (r25.aF() != true) goto L128;
        r26 = true;
        goto L129
    L94:
        if (r125.isVisible() != true) goto L96;
        r126 = true;
        goto L97
    }

    public final void F0(boolean r1) {
        this.G = r1;
        W3(Q3());
        P00();
        h3();
    }

    public final void I2(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.Z = r2;
    }

    public final void MP(laa.n r4) {
        GC(true, false, r4, null);
    }

    public final void N60(boolean r4) {
        laa.d r0 = E3();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L18;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("onSpeakerStatusSwitch toCancel ");
        r3.append(r4);
        r3.append(", pageState is ");
        laa.d r5 = E3();
        if (r5 == null) goto L11;
        ObricFloatChatPageState r6 = r5.getPageState();
    L12:
        r3.append(r6);
        r2.i("ObricWindowExtraViewComponent", r3.toString());
        GradientEffectView r7 = D3();
        if (r4 == false) goto L15;
        float r8 = 0.0f;
    L16:
        r7.setAlpha(r8);
        return;
    L15:
        r8 = 1.0f;
        goto L16
    L11:
        r6 = null;
        goto L12
    L18:
        return;
    L5:
        if (r0.aF() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void W3(final boolean r3) {
        if (((Space) this.T.getValue()).getParent() != null) goto L5;
        return;
    L5:
        if (((Space) this.T.getValue()).getLayoutParams() == null) goto L13;
        FrameLayout r0 = (FrameLayout) this.z.getValue();
        if (r0 == null) goto L12;
        r0.post(new q3(this, r3));
        return;
    L12:
        return;
    }

    @Override // xha.e
    public final void Z20(Float r4) {
        FLogger.a.i("ObricIconSwipeUpView", "swipeIcon distance is " + r4);
        if (r4 == null) goto L5;
        B3().d(r4.floatValue());
        return;
    L5:
        B3().c();
    }

    public final void a7(boolean r1) {
        this.I = r1;
    }

    @Override // xha.e
    public final void ia(Map<String, ? extends ImageView> r4) {
        Intrinsics.checkNotNullParameter(r4, "iconMap");
        Iterator r5 = ((LinkedHashMap) r4).entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r5.next();
        String r1 = (String) r0.getKey();
        ((ImageView) r0.getValue()).setTag(2131381159, r1);
        goto L4
    }

    public final void j1(boolean r1) {
        this.F = r1;
        W3(Q3());
        P00();
        h3();
    }

    public final void r2(boolean r4) {
        FLogger.a.i("ObricWindowExtraViewComponent", "onChatStyleChanged isChatWindow " + r4);
        if (s1a.a.e(this) == false) goto L6;
        X3();
        return;
    }

    public final void rT(boolean r2) {
        this.E = r2;
        if (r2 == false) goto L12;
        laa.d r3 = E3();
        if (r3 == null) goto L9;
        boolean r0 = true;
        if (r3.aF() != true) goto L9;
    L10:
        Z3(this, r0);
        return;
    L9:
        r0 = false;
        goto L10
    }

    @Override // xha.e
    public final void uV(boolean r1) {
        this.J = r1;
        W3(Q3());
        P00();
        h3();
    }

    public final void v00(boolean r2) {
        this.C = r2;
        laa.d r3 = E3();
        if (r3 == null) goto L7;
        boolean r0 = true;
        if (r3.aF() != true) goto L7;
    L8:
        Z3(this, r0);
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void x1(ObricFloatChatPageState r3) {
        Intrinsics.checkNotNullParameter(r3, "pageState");
        ObricIconSwipeUpView r0 = B3();
        ObricFloatChatPageData.Companion.getClass();
        if ((r3 instanceof vda.e) == false) goto L5;
    L9:
        boolean r4 = false;
    L10:
        r0.setEnabled(r4);
        return;
    L5:
        if ((r3 instanceof vda.b) == true) goto L9;
        if (V3() == true) goto L9;
        r4 = true;
        goto L10
    }

    public static void Z3(ObricWindowExtraViewComponent r4, boolean r5) {
        r4.getClass();
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        r4.D3().setVisibility(8);
        return;
    L10:
        r4.D3().setVisibility(0);
        GradientEffectView r3 = r4.D3();
        if (r4.C == false) goto L13;
    L18:
        if (r1 == false) goto L25;
        boolean r6 = v19.h.a;
        boolean r7 = v19.h.b(r4.getContext());
        if (r5 == false) goto L22;
        float r8 = 1.0f;
    L28:
        r3.setAlpha(r8);
        return;
    L22:
        if (r7 == false) goto L24;
        r8 = 0.6f;
        goto L28
    L24:
        r8 = 0.32f;
        goto L28
    L25:
        if (r5 == false) goto L27;
        r8 = 0.4f;
        goto L28
    L27:
        r8 = 0.0f;
        goto L28
    L13:
        if (r4.D == true) goto L18;
        if (r4.E == true) goto L18;
        r1 = false;
        goto L18
    L5:
        if (r0.isWindowMode() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final void C0(boolean r1, boolean r2) {
        P00();
        this.H = r1;
        if (r1 == true) goto L6;
        h3();
        return;
    }

    public final void uA(float r4, boolean r5) {
        FLogger.a.i("ObricWindowExtraViewComponent", "resetChatWindowLightAlpha " + r4 + ' ' + r5);
        D3().setAlpha(r4);
        Z3(this, r5 ^ true);
    }

    public static final void Y2(ObricWindowExtraViewComponent r2, String r3, String r4) {
        r2.getClass();
        FLogger.a.i("ObricWindowExtraViewComponent", "mob swipe up before page state: " + r3 + ", after state: " + r4);
        if (Intrinsics.areEqual(r3, r4) == false) goto L5;
        fia.a.b(null);
        return;
    L5:
        fia.a.b(r4);
    }

    public final void GC(boolean r6, boolean r7, laa.n r8, String r9) {
        FLogger.a.i("ObricWindowExtraViewComponent", "setVoiceViewVisible " + r6 + ", playWelcomeAnimation " + r7);
        boolean r0 = true;
        if (r6 == false) goto L20;
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == true) goto L20;
        ICoreInputAbility r4 = (ICoreInputAbility) this.t.getValue();
        if (r4 == null) goto L14;
        r4.g2(2, true);
    L14:
        va8.o r5 = (va8.o) this.u.getValue();
        if (r5 == null) goto L17;
        r5.ra();
    L17:
        ICoreInputAbility r10 = (ICoreInputAbility) this.t.getValue();
        if (r10 == null) goto L20;
        r10.qp(false);
        goto L20
    L7:
        if (r2.isWindowMode() != true) goto L9;
        r3 = true;
    L20:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r11 = (com.larus.bmhome.chat.component.bottom.attachment.g1) this.o.getValue();
        if (r11 != null) goto L23;
    L25:
        boolean r12 = false;
    L27:
        if (r12 == false) goto L36;
        if (r6 == false) goto L36;
        View r13 = z3();
        if (r13 == null) goto L53;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L35;
        r14.width = 0;
        r13.setLayoutParams(r14);
        goto L53
    L35:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L53:
        if (r6 == false) goto L55;
        float r15 = 0.0f;
    L56:
        ViewGroup r16 = G3();
        if (r16 == null) goto L59;
        r16.setScaleX(r15);
    L59:
        ViewGroup r17 = G3();
        if (r17 == null) goto L62;
        r17.setScaleY(r15);
    L62:
        ViewGroup r18 = G3();
        if (r18 == null) goto L65;
        r18.setAlpha(1.0f);
    L65:
        if (r6 == true) goto L69;
        Function0<Unit> r19 = this.Z;
        if (r19 == null) goto L69;
        r19.invoke();
    L69:
        laa.f r20 = (laa.f) this.p.getValue();
        if (r20 == null) goto L72;
        r20.Fj(r6, r7, r8, r9);
    L72:
        laa.d r21 = E3();
        if (r21 == null) goto L75;
        r21.C00(r6);
    L75:
        this.D = r6;
        laa.d r22 = E3();
        if (r22 != null) goto L78;
    L80:
        r0 = false;
    L81:
        Z3(this, r0);
        return;
    L78:
        if (r22.aF() != true) goto L80;
    L55:
        r15 = 1.0f;
    L36:
        View r23 = z3();
        if (r23 == null) goto L43;
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        if (r24 == null) goto L43;
        if (r24.width != i5.c0()) goto L43;
        boolean r25 = true;
    L44:
        if (r25 == true) goto L53;
        View r26 = z3();
        if (r26 == null) goto L53;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if (r27 == null) goto L51;
        r27.width = i5.c0();
        r26.setLayoutParams(r27);
        goto L53
    L51:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L43:
        r25 = false;
        goto L44
    L23:
        if (r11.isVisible() != true) goto L25;
        r12 = true;
        goto L27
    }
}
