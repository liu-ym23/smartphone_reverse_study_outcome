package com.ss.android.lark.forseti.chain;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.api.api.ForsetiBaseChainFragment;
import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiWidth;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.forseti.global.ForsetiActivityChainManager;
import com.ss.android.lark.forseti.global.ForsetiAttachInfo;
import com.ss.android.lark.forseti.node.ForsetiFragmentDisplayControllerImpl;
import com.ss.android.lark.forseti.node.ForsetiNode;
import com.ss.android.lark.forseti.node.piece.FragmentLifecycleObserver;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingLayout;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroupCompat;
import com.ss.android.lark.forsetiutils.BizType;
import com.ss.android.lark.forsetiutils.ForsetiFGHelpers;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000°\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ß\u00012\u00020\u0001:\u0006ß\u0001à\u0001á\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010d\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010e\u001a\u0002052\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J$\u0010h\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020j2\b\u0010k\u001a\u0004\u0018\u00010\u000b2\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\u001a\u0010l\u001a\u0002052\u0006\u0010m\u001a\u00020\u000e2\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\b\u0010n\u001a\u000205H\u0002J\u0010\u0010o\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0-H\u0002J\b\u0010p\u001a\u000205H\u0002J\b\u0010q\u001a\u000205H\u0002J\b\u0010r\u001a\u000205H\u0002J\u000e\u0010s\u001a\u0002052\u0006\u0010;\u001a\u00020<J\u0006\u0010t\u001a\u00020#J\u0006\u0010u\u001a\u00020#J\b\u0010v\u001a\u000205H\u0002J\u0010\u0010w\u001a\u0002052\u0006\u0010x\u001a\u00020\u0014H\u0002J\b\u0010y\u001a\u000205H\u0016J\u0006\u0010z\u001a\u00020#JY\u0010{\u001a\u0002052\u0006\u0010|\u001a\u00020b2\u0006\u0010}\u001a\u00020\u00142\n\b\u0002\u0010~\u001a\u0004\u0018\u00010b2\b\b\u0002\u0010\u007f\u001a\u00020#2\t\b\u0002\u0010\u0080\u0001\u001a\u00020#2\t\b\u0002\u0010\u0081\u0001\u001a\u00020#2\f\b\u0002\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020>J\u000f\u0010\u0085\u0001\u001a\u0002052\u0006\u0010|\u001a\u00020bJ\u000f\u0010\u0086\u0001\u001a\u00020c2\u0006\u0010|\u001a\u00020bJ\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010/2\u0006\u0010|\u001a\u00020bJ\u0007\u0010\u0088\u0001\u001a\u000205J\u000f\u0010\u0089\u0001\u001a\u0002052\u0006\u0010P\u001a\u00020OJ\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010bJ\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010bJ\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010/J\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010/J\u0011\u0010\u008e\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\u0011\u0010\u0092\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0093\u0001J\u0007\u0010\u0094\u0001\u001a\u000205J\u0011\u0010\u0095\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0096\u0001J\u0007\u0010\u0097\u0001\u001a\u000205J\u0011\u0010\u0098\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0099\u0001J\u0011\u0010\u009a\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u0099\u0001J\u0007\u0010\u009b\u0001\u001a\u000205J\u0011\u0010\u009c\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u009d\u0001J\u0011\u0010\u009e\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030\u009d\u0001J\u0007\u0010\u009f\u0001\u001a\u000205J\u0011\u0010 \u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030¡\u0001J\u0011\u0010¢\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030¡\u0001J\u0007\u0010£\u0001\u001a\u000205J\u0011\u0010¤\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030¥\u0001J\u0011\u0010¦\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030¥\u0001J\u0007\u0010§\u0001\u001a\u000205J\u000f\u0010¨\u0001\u001a\u0004\u0018\u000103¢\u0006\u0003\u0010©\u0001J\u000f\u0010ª\u0001\u001a\u0004\u0018\u000103¢\u0006\u0003\u0010©\u0001J\u000f\u0010«\u0001\u001a\u0004\u0018\u000103¢\u0006\u0003\u0010©\u0001J\u001a\u0010¬\u0001\u001a\u0002052\u0006\u0010x\u001a\u00020\u00142\u0007\u0010\u00ad\u0001\u001a\u000208H\u0002J\u0011\u0010®\u0001\u001a\u00020#2\u0006\u0010x\u001a\u00020\u0014H\u0002J@\u0010¯\u0001\u001a\u00020527\u0010\u008f\u0001\u001a2\u0012\u0013\u0012\u00110/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002050.J@\u0010°\u0001\u001a\u00020527\u0010\u008f\u0001\u001a2\u0012\u0013\u0012\u00110/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002050.J\u0007\u0010±\u0001\u001a\u000205J\u0011\u0010²\u0001\u001a\u0004\u0018\u00010b2\u0006\u0010}\u001a\u00020\u0014J\u001b\u0010³\u0001\u001a\u0002052\t\u0010´\u0001\u001a\u0004\u0018\u00010/2\u0007\u0010µ\u0001\u001a\u00020#J\u0019\u0010¶\u0001\u001a\u0002052\u0007\u0010·\u0001\u001a\u00020b2\u0007\u0010µ\u0001\u001a\u00020#J\u000f\u0010¸\u0001\u001a\u0002032\u0006\u0010|\u001a\u00020bJ\u0017\u0010¹\u0001\u001a\u0004\u0018\u00010#2\u0006\u0010|\u001a\u00020b¢\u0006\u0003\u0010º\u0001J\u001e\u0010»\u0001\u001a\u0002052\u0006\u0010|\u001a\u00020b2\r\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u0002050ZJ\t\u0010½\u0001\u001a\u0004\u0018\u00010\u0005J\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u0012J\n\u0010¿\u0001\u001a\u0005\u0018\u00010À\u0001J\u0013\u0010Á\u0001\u001a\u0002052\b\u0010f\u001a\u0004\u0018\u00010gH\u0016J\t\u0010Â\u0001\u001a\u000205H\u0016J\t\u0010Ã\u0001\u001a\u000205H\u0016J\t\u0010Ä\u0001\u001a\u000205H\u0016J\t\u0010Å\u0001\u001a\u000205H\u0016J\u0012\u0010Æ\u0001\u001a\u0002052\u0007\u0010Ç\u0001\u001a\u00020gH\u0016J\t\u0010È\u0001\u001a\u000205H\u0016J\t\u0010É\u0001\u001a\u000205H\u0002J\t\u0010Ê\u0001\u001a\u000205H\u0016J\u0016\u0010Ë\u0001\u001a\u0002052\r\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u0002050ZJ\u0018\u0010Ì\u0001\u001a\u0002052\u000f\u0010Í\u0001\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010ZJ\u0012\u0010Î\u0001\u001a\u0002052\t\b\u0002\u0010Ï\u0001\u001a\u00020#J\u0012\u0010Ð\u0001\u001a\u0002052\t\b\u0002\u0010Ï\u0001\u001a\u00020#J\u0010\u0010Ñ\u0001\u001a\u0002052\u0007\u0010Ò\u0001\u001a\u000203J\b\u0010Ó\u0001\u001a\u00030Ô\u0001J\u001c\u0010Õ\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030Ö\u00012\t\b\u0002\u0010×\u0001\u001a\u00020#J\u0011\u0010Ø\u0001\u001a\u0002052\b\u0010\u008f\u0001\u001a\u00030Ö\u0001J\u0010\u0010Ù\u0001\u001a\u0002052\u0007\u0010Ú\u0001\u001a\u00020#J\u0010\u0010Û\u0001\u001a\u0002052\u0007\u0010Ü\u0001\u001a\u000203J\u0010\u0010Ý\u0001\u001a\u0002052\u0007\u0010Þ\u0001\u001a\u00020#R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+RD\u0010,\u001a8\u00124\u00122\u0012\u0013\u0012\u00110/¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0004\u0012\u0002050.0-X\u0082\u0004¢\u0006\u0002\n\u0000R \u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002080-07X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\t\u001a\u0004\b@\u0010AR\u001b\u0010C\u001a\u00020D8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\t\u001a\u0004\bE\u0010FR\u001b\u0010H\u001a\u00020<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\t\u001a\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020<8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010JR\u001e\u0010P\u001a\u00020O2\u0006\u0010N\u001a\u00020O@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0014\u0010Y\u001a\b\u0012\u0004\u0012\u0002050ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020\\X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001a\u0010a\u001a\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020c07X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006â\u0001"}, d2 = {"Lcom/ss/android/lark/forseti/chain/ForsetiChainFragment;", "Lcom/ss/android/lark/api/api/ForsetiBaseChainFragment;", "<init>", "()V", "draggingHelper", "Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "getDraggingHelper", "()Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingHelper;", "draggingHelper$delegate", "Lkotlin/Lazy;", "chainViewGroup", "Landroid/view/ViewGroup;", "parentViewGroup", "draggingLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "chainHelper", "Lcom/ss/android/lark/forseti/chain/ForsetiChainHelper;", "keyChainHelperPendingAction", "", "keyForsetiNormalChainDraggingLayout", "keyChainAdapter", "attachInfo", "Lcom/ss/android/lark/forseti/global/ForsetiAttachInfo;", "getAttachInfo", "()Lcom/ss/android/lark/forseti/global/ForsetiAttachInfo;", "attachInfo$delegate", "chainContainerClickListener", "Landroid/view/View$OnClickListener;", "getChainContainerClickListener", "()Landroid/view/View$OnClickListener;", "setChainContainerClickListener", "(Landroid/view/View$OnClickListener;)V", "provideDraggingSupport", "", "triggerAnimation", "Lcom/ss/android/lark/forseti/chain/ForsetiChainFragment$ITriggerAnimation;", "rightForsetiNodeWith", "Lcom/ss/android/lark/forseti/chain/ForsetiChainFragment$IRightForsetiNodeWith;", "getRightForsetiNodeWith", "()Lcom/ss/android/lark/forseti/chain/ForsetiChainFragment$IRightForsetiNodeWith;", "setRightForsetiNodeWith", "(Lcom/ss/android/lark/forseti/chain/ForsetiChainFragment$IRightForsetiNodeWith;)V", "nodeRemovedListeners", "", "Lkotlin/Function2;", "Lcom/ss/android/lark/forseti/node/ForsetiNode;", "Lkotlin/ParameterName;", "name", "removed", "", "count", "", "pendingActionsMap", "", "Ljava/lang/Runnable;", "forsetiStructureNotifier", "Lcom/ss/android/lark/forseti/global/ForsetiActivityChainManager$ForsetiStructureNotifier;", "forsetiChainConfig", "Lcom/ss/android/lark/api/bean/config/ForsetiChainConfig;", "forsetiInnerOptions", "Lcom/ss/android/lark/api/bean/ForsetiInnerOptions;", "multiStackDisableFG", "getMultiStackDisableFG", "()Z", "multiStackDisableFG$delegate", "chainType", "Lcom/ss/android/lark/api/bean/ForsetiChainType;", "getChainType", "()Lcom/ss/android/lark/api/bean/ForsetiChainType;", "chainType$delegate", "chainConfig", "getChainConfig", "()Lcom/ss/android/lark/api/bean/config/ForsetiChainConfig;", "chainConfig$delegate", "latestChainConfig", "getLatestChainConfig", "value", "Lcom/ss/android/lark/forseti/chain/ForsetiChainState;", "state", "getState", "()Lcom/ss/android/lark/forseti/chain/ForsetiChainState;", "chainAdapter", "Lcom/ss/android/lark/forseti/chain/IForsetiChainAdapter;", "getChainAdapter", "()Lcom/ss/android/lark/forseti/chain/IForsetiChainAdapter;", "setChainAdapter", "(Lcom/ss/android/lark/forseti/chain/IForsetiChainAdapter;)V", "closeHandler", "Lkotlin/Function0;", "status", "Lcom/ss/android/lark/forseti/chain/ForsetiStackChainStatus;", "getStatus", "()Lcom/ss/android/lark/forseti/chain/ForsetiStackChainStatus;", "setStatus", "(Lcom/ss/android/lark/forseti/chain/ForsetiStackChainStatus;)V", "fragmentDisplayControllerCache", "Landroidx/fragment/app/Fragment;", "Lcom/ss/android/lark/api/api/IForsetiFragmentDisplayController;", "onAttach", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "initListeners", "findAllViews", "setupDraggingHelper", "setupChainHelper", "setupForsetiChainConfig", "refreshForsetiChainConfig", "isDraggingSupport", "popNodeExcludeHead", "afterChainHelperInit", "executePendingActions", TabAppInfo.IMAGE_JSON_KEY, "onDestroyView", "dispatchBackPressedEvent", "addForsetiFragment", "f", "tag", "anchorFragment", "openNextNode", "half", "isNextNodeFull", "fragmentLifecycleCallbacks", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "options", "removeForsetiFragment", "getFragmentDisplayController", "findForsetiNode", "switchCModeCompact", "changeState", "findHeadFragment", "findTailFragment", "findTailForsetiNode", "findFirstForsetiNode", "addFirstNodeLayoutChangeListener", "listener", "Landroid/view/View$OnLayoutChangeListener;", "removeFirstNodeLayoutChangeListener", "addUpdateScaleFactor", "Lcom/ss/android/lark/api/ui/IForsetiNodeScaleListener;", "removeUpdateScaleFactor", "addNodeShowOverlayListener", "Lcom/ss/android/lark/api/ui/IForsetiNodeShowOverlayListener;", "removeNodeShowOverlayListener", "addForsetiNodeWidthChangeListener", "Lcom/ss/android/lark/api/ui/IForsetiNodeWidthListener;", "removeForsetiNodeWidthChangeListener", "removeForsetiNodeWidthChangeListeners", "addLastNodeLeftChangeListener", "Lcom/ss/android/lark/api/ui/IForsetiNodeLeftChangeListener;", "removeLastNodeLeftChangeListener", "removeLastNodeLeftChangeListeners", "addNavigationModeChangedListener", "Lcom/ss/android/lark/api/ui/IForsetiNavigationModeChangedListener;", "removeNavigationModeChangedListener", "removeNavigationModeChangedListeners", "addSplitRatioChangedListener", "Lcom/ss/android/lark/api/ui/IForsetiSplitRatioChangedListener;", "removeSplitRatioChangedListener", "removeSplitRatioChangedListeners", "getFirstNodeWidth", "()Ljava/lang/Integer;", "getContainerWidth", "getContainerHeight", "executeOrPendingAction", "runnable", "checkPropertyInitialized", "addForsetiNodeRemovedListener", "removeForsetiNodeRemovedListener", "removeForsetiNodeRemovedListeners", "findFragmentByTag", "clearAllForsetiNodesAfter", "anchorNode", "inclusive", "clearAllBizFragmentAfter", "bizFragment", "findIndex", "isTailNode", "(Landroidx/fragment/app/Fragment;)Ljava/lang/Boolean;", "tailNodeHandler", "handler", "getForsetiColumnsDraggingHelper", "getForsetiChainHelper", "getDraggingView", "Lcom/ss/android/lark/forseti/widget/ForsetiNormalChainDraggingView;", "onViewStateRestored", "onStart", "onResume", "onPause", "onStop", "onSaveInstanceState", "outState", "onDestroy", "clear", "onDetach", "setCloseHandler", "setClickInterceptor", "interceptor", "setSwipeToDismissDisabled", "disabled", "setSwipeToDismissDisabledV2", "setPeekHeight", "peekHeightInPx", "getCurrentPageViewType", "Lcom/ss/android/lark/api/bean/ForsetiPageViewType;", "addPageViewTypeChangeListener", "Lcom/ss/android/lark/api/ui/IForsetiPageViewTypeListener;", "isSticky", "removePageViewTypeChangeListener", "skipCollapsed", "skip", "updateStyle", "style", "setMaskVisible", "visible", "Companion", "ITriggerAnimation", "IRightForsetiNodeWith", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForsetiChainFragment extends ForsetiBaseChainFragment {
    public static final /* synthetic */ int E = 0;
    public s A;
    public Function0<Unit> B;
    public ForsetiStackChainStatus C;
    public final Map<Fragment, tua.c> D;
    public final Lazy e;
    public ViewGroup f;
    public ViewGroup g;
    public View h;
    public Context i;
    public ForsetiChainHelper j;
    public final String k;
    public final String l;
    public final String m;
    public final Lazy n;
    public View.OnClickListener o;
    public f p;
    public g q;
    public final List<Function2<ForsetiNode, Integer, Unit>> r;
    public final Map<String, List<Runnable>> s;
    public ForsetiActivityChainManager.b t;
    public com.ss.android.lark.api.bean.config.a u;
    public uua.a v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public ForsetiChainState z;

    public static final class a {
    }

    public interface b {
        void a(ForsetiWidth r1, ForsetiWidth r2);
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ForsetiChainFragment a;

        public c(ForsetiChainFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ForsetiChainHelper r0 = this.a.j;     // Catch: Throwable -> L7
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("chainHelper");     // Catch: Throwable -> L7
            r0 = null;
        L5:
            r0.b();     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    static {
    }

    public final ForsetiChainType S90() {
        return (ForsetiChainType) this.x.getValue();
    }

    public final boolean W90() {
        if (V90(this.k) == true) goto L6;
        Log.w("Forseti_ChainFragment", "chainHelper is not initialized, enqueuing back press handling.");
        X90(this.k, new c(this));
        return true;
    L6:
        ForsetiChainHelper r0 = this.j;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        r0 = null;
    L10:
        return r0.b();
    }

    public final ForsetiNode aa0() {
        ForsetiChainHelper r0 = this.j;
        if (r0 == null) goto L8;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        r0 = null;
    L7:
        return r0.i;
    L8:
        return null;
    }

    public final Fragment ba0() {
        ForsetiChainHelper r1 = null;
        if (V90(this.k) == false) goto L10;
        ForsetiChainHelper r0 = this.j;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
    L9:
        return (Fragment) CollectionsKt.lastOrNull(r1.i.i);
    L7:
        r1 = r0;
        goto L9
    L10:
        return null;
    }

    public final s ca0() {
        s r0 = this.A;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("chainAdapter");
        return null;
    }

    public final ForsetiColumnsDraggingHelper da0() {
        return (ForsetiColumnsDraggingHelper) this.e.getValue();
    }

    public ForsetiChainFragment() {
        this.e = LazyKt.lazy(new ForsetiChainFragment$draggingHelper$2(this));
        this.k = "chainHelper";
        this.l = "forsetiNormalChainDraggingLayout";
        this.m = "chainAdapter";
        this.n = LazyKt.lazy(new ForsetiChainFragment$attachInfo$2(this));
        this.r = new ArrayList();
        this.s = new ConcurrentHashMap();
        this.w = LazyKt.lazy(ForsetiChainFragment$multiStackDisableFG$2.INSTANCE);
        this.x = LazyKt.lazy(new ForsetiChainFragment$chainType$2(this));
        this.y = LazyKt.lazy(new ForsetiChainFragment$chainConfig$2(this));
        this.z = ForsetiChainState.STOPPED;
        this.B = ForsetiChainFragment$closeHandler$1.INSTANCE;
        this.C = ForsetiStackChainStatus.NORMAL;
        this.D = new LinkedHashMap();
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Log.i("Forseti_ChainFragment", "onDestroy");
        ((ConcurrentHashMap) this.s).clear();
        ((ArrayList) this.r).clear();
        this.o = null;
        this.p = null;
        this.q = null;
        View r0 = this.h;
        boolean r1 = r0 instanceof ForsetiNormalChainDraggingLayout;
        if (r1 == false) goto L5;
        ForsetiNormalChainDraggingLayout r2 = (ForsetiNormalChainDraggingLayout) r0;
    L5:
        if (r1 == false) goto L7;
        ForsetiNormalChainDraggingLayout r3 = (ForsetiNormalChainDraggingLayout) r0;
    L7:
        ForsetiColumnsDraggingHelper r4 = da0();
        r4.B.reset();
        r4.C.reset();
        r4.D.reset();
        r4.E.reset();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        Log.i("Forseti_ChainFragment", "onDestroyView");
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        Log.i("Forseti_ChainFragment", "onDetach");
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        Log.i("Forseti_ChainFragment", "onPause");
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Log.i("Forseti_ChainFragment", "onResume");
    }

    public final void onStart() {
        super/*androidx.fragment.app.Fragment*/.onStart();
        Log.i("Forseti_ChainFragment", "onStart");
    }

    public final void onStop() {
        super/*androidx.fragment.app.Fragment*/.onStop();
        Log.i("Forseti_ChainFragment", "onStop");
    }

    public final void U90(ForsetiChainState r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        if (this.z != r5) goto L5;
        return;
    L5:
        this.z = r5;
        if (this.f == null) goto L23;
        ViewGroup r1 = this.g;
        ForsetiNormalChainViewGroupCompat r2 = null;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        r1 = null;
    L11:
        if ((r1 instanceof ForsetiNormalChainViewGroupCompat) == false) goto L13;
        r2 = (ForsetiNormalChainViewGroupCompat) r1;
    L13:
        if (r2 == null) goto L24;
        Lazy r3 = ForsetiFGHelpers.a;
        if (ForsetiFGHelpers.c(BizType.IM, "opt_nav_width") == false) goto L17;
        Intrinsics.checkNotNullParameter(r5, "state");
        r2.d = r5;
    L17:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.getValue() != ForsetiChainState.RESUMED.getValue()) goto L20;
        boolean r6 = true;
    L21:
        r2.c = r6;
        r2.requestLayout();
        return;
    L20:
        r6 = false;
        goto L21
    L24:
        return;
    }

    public final boolean V90(String r4) {
        if (Intrinsics.areEqual(r4, this.k) == false) goto L9;
        if (this.j != null) goto L19;
    L7:
        return false;
    L19:
        return true;
    L9:
        if (Intrinsics.areEqual(r4, this.l) == false) goto L14;
        if (this.j == null) goto L7;
        return true;
    L14:
        if (Intrinsics.areEqual(r4, this.m) == false) goto L7;
        if (this.A == null) goto L7;
        return true;
    }

    public final ForsetiNode Y90(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "f");
        ForsetiChainHelper r1 = null;
        if (V90(this.k) == false) goto L10;
        ForsetiChainHelper r0 = this.j;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
    L9:
        return r1.c(r3);
    L7:
        r1 = r0;
        goto L9
    L10:
        return null;
    }

    public final Fragment Z90(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        ForsetiChainHelper r0 = this.j;
        Object r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        r0 = null;
    L5:
        r0.getClass();
        Function1<ForsetiNode, Fragment> r2 = new ForsetiChainHelper$findFragmentByTag$1(r4);
        Intrinsics.checkNotNullParameter(r2, "action");
        ForsetiNode r5 = r0.g.e;
    L6:
        if (r5 == null) goto L12;
        if (r2.invoke(r5) != null) goto L9;
        r5 = r5.e;
        goto L6
    L9:
        r1 = r2.invoke(r5);
    L12:
        return (Fragment) r1;
    }

    public final tua.c ea0(Fragment r5) {
        Intrinsics.checkNotNullParameter(r5, "f");
        int r0 = fib.a.a;
        ForsetiChainHelper r1 = null;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.notification_not_use_object.disabled") == true) goto L16;
        tua.c r2 = (tua.c) ((LinkedHashMap) this.D).get(r5);
        if (r2 == null) goto L7;
        return r2;
    L7:
        ForsetiChainHelper r3 = this.j;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
    L11:
        ForsetiFragmentDisplayControllerImpl r4 = new ForsetiFragmentDisplayControllerImpl(r5, r1);
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.forseti.fragment_display_controller_cache_disabled") == true) goto L14;
        r5.getLifecycle().addObserver(new FragmentLifecycleObserver(r5, this.D));
    L14:
        this.D.put(r5, r4);
        return r4;
    L10:
        r1 = r3;
        goto L11
    L16:
        ForsetiChainHelper r6 = this.j;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
    L21:
        return new ForsetiFragmentDisplayControllerImpl(r5, r1);
    L19:
        r1 = r6;
        goto L21
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        this.i = r2;
        Log.i("Forseti_ChainFragment", "onAttach, chainType: " + S90());
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.Fragment*/.onCreate(r2);
        Log.i("Forseti_ChainFragment", "onCreate");
    }

    public final void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super/*androidx.fragment.app.Fragment*/.onSaveInstanceState(r2);
        Log.i("Forseti_ChainFragment", "onSaveInstanceState");
    }

    public final void onViewStateRestored(Bundle r2) {
        super/*androidx.fragment.app.Fragment*/.onViewStateRestored(r2);
        Log.i("Forseti_ChainFragment", "onViewStateRestored");
    }

    public final void X90(String r3, Runnable r4) {
        if (V90(r3) == false) goto L5;
        r4.run();
        return;
    L5:
        ConcurrentHashMap r0 = (ConcurrentHashMap) this.s;
        Object r1 = r0.get(r3);
        if (r1 != null) goto L8;
        r1 = new ArrayList();
        r0.put(r3, r1);
    L8:
        ((List) r1).add(r4);
    }

    public final void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r17, r18);
        Log.i("Forseti_ChainFragment", "onViewCreated");
        ViewGroup r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("chainViewGroup");
        r0 = null;
    L5:
        this.h = (View) SequencesKt.lastOrNull(ViewGroupKt.getChildren(r0));
        if (S90() != ForsetiChainType.TYPE_NORMAL) goto L9;
        this.p = new f(this);
        this.q = new g(this);
    L9:
        ViewGroup r1 = this.g;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        r1 = null;
    L13:
        if ((r1 instanceof ForsetiNormalChainViewGroupCompat) == false) goto L15;
        ForsetiNormalChainViewGroupCompat r2 = (ForsetiNormalChainViewGroupCompat) r1;
    L16:
        if (r2 == null) goto L18;
        r2.setForsetiDraggingHelper(da0());
    L18:
        ViewGroup r3 = this.g;
        if (r3 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        r3 = null;
    L22:
        if ((r3 instanceof ForsetiNormalChainViewGroupCompat) == false) goto L24;
        ForsetiNormalChainViewGroupCompat r4 = (ForsetiNormalChainViewGroupCompat) r3;
    L25:
        if (r4 == null) goto L30;
        com.ss.android.lark.api.bean.config.a r5 = this.u;
        if (r5 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiChainConfig");
        r5 = null;
    L29:
        r4.setForsetiChainConfig(r5);
    L30:
        FragmentManager r14 = getChildFragmentManager();
        ViewGroup r6 = this.g;
        if (r6 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        ViewGroup r15 = null;
    L34:
        FragmentActivity r7 = requireActivity();
        ForsetiAttachInfo r8 = (ForsetiAttachInfo) this.n.getValue();
        f r9 = this.p;
        ForsetiColumnsDraggingHelper r10 = da0();
        ForsetiActivityChainManager.b r11 = this.t;
        if (r11 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiStructureNotifier");
        ForsetiActivityChainManager.b r12 = null;
    L38:
        this.j = new ForsetiChainHelper(r14, r15, new com.ss.android.lark.forseti.global.e(r7, r8, r9, r10, r12, (com.ss.android.lark.api.bean.config.a) this.y.getValue(), ca0(), this), S90());
        Log.i("Forseti_ChainFragment", "chainHelper is initialized");
        ForsetiChainHelper r13 = this.j;
        if (r13 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        r13 = null;
    L41:
        r13.h = new e(this);
        Iterator r16 = ((ConcurrentHashMap) this.s).keySet().iterator();
    L43:
        if (r16.hasNext() == false) goto L52;
        String r19 = (String) r16.next();
        List r20 = (List) ((ConcurrentHashMap) this.s).get(r19);
        if (r20 == null) goto L51;
        Iterator r21 = r20.iterator();
    L48:
        if (r21.hasNext() == false) goto L50;
        ((Runnable) r21.next()).run();
        goto L48
    L50:
        r20.clear();
    L51:
        ((ConcurrentHashMap) this.s).remove(r19);
        goto L43
    L52:
        ViewGroup r22 = this.g;
        if (r22 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        r22 = null;
    L56:
        if ((r22 instanceof ForsetiNormalChainViewGroupCompat) == false) goto L58;
        ForsetiNormalChainViewGroupCompat r23 = (ForsetiNormalChainViewGroupCompat) r22;
    L59:
        if (r23 == null) goto L70;
        ForsetiChainHelper r24 = this.j;
        if (r24 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("chainHelper");
        ForsetiChainHelper r110 = null;
    L64:
        r23.setForsetiChainHelper(r110);
        return;
    L63:
        r110 = r24;
        goto L64
    L70:
        return;
    L58:
        r23 = null;
        goto L59
    L37:
        r12 = r11;
        goto L38
    L33:
        r15 = r6;
        goto L34
    L24:
        r4 = null;
        goto L25
    L15:
        r2 = null;
        goto L16
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Log.i("Forseti_ChainFragment", "onCreateView");
        if (S90() != ForsetiChainType.TYPE_NORMAL) goto L8;
        Context r8 = this.i;
        if (r8 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r8 = null;
    L7:
        s r9 = new ForsetiNormalChainAdapter(r8, da0());
    L38:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.A = r9;
        StringBuilder r10 = new StringBuilder("ForsetiPopoverParams: ");
        uua.a r11 = this.v;
        if (r11 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiInnerOptions");
        r11 = null;
    L41:
        r10.append(r11.c);
        Log.d("Forseti_ChainFragment", r10.toString());
        ViewGroup r12 = ca0().h();
        this.f = r12;
        if (r12 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("chainViewGroup");
        r12 = null;
    L44:
        r12.setTag(this);
        ca0().e();
        ViewGroup r13 = this.f;
        if (r13 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("chainViewGroup");
        r13 = null;
    L47:
        r13.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (this.o == null) goto L53;
        ViewGroup r14 = this.f;
        if (r14 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("chainViewGroup");
        r14 = null;
    L52:
        r14.setOnClickListener(this.o);
    L53:
        this.g = ca0().j();
        ca0().i(new AnonymousClass1(this));
        ViewGroup r15 = this.f;
        if (r15 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("chainViewGroup");
        return null;
    L57:
        return r15;
    L8:
        int r16 = eib.a.a;
        uua.a r17 = this.v;
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiInnerOptions");
        r17 = null;
    L11:
        Context r18 = this.i;
        if (r18 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r18 = null;
    L14:
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r18, "context");
        vua.a r19 = r17.c;
        if (r19 == null) goto L17;
        View r20 = r19.a;
    L18:
        if (r20 != null) goto L25;
        if (r19 == null) goto L21;
        Rect r21 = r19.b;
    L22:
        if (r21 != null) goto L25;
        boolean r22 = false;
    L26:
        if (r22 == false) goto L34;
        Context r23 = this.i;
        if (r23 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r23 = null;
    L30:
        ForsetiChainType r1 = S90();
        uua.a r3 = this.v;
        if (r3 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("forsetiInnerOptions");
        r3 = null;
    L33:
        r9 = new ForsetiPopoverChainAdapter(r23, r1, r3);
        goto L38
    L34:
        Context r24 = this.i;
        if (r24 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        r24 = null;
    L37:
        r9 = new ForsetiStackChainAdapter(r24, S90());
        goto L38
    L21:
        r21 = null;
    L25:
        r22 = true;
        goto L26
    L17:
        r20 = null;
        goto L18
    }

    public static void T90(final ForsetiChainFragment r13, final Fragment r14, final String r15, Fragment r16, boolean r17, boolean r18, boolean r19, final uua.a r20, int r21) {
        if ((r21 & 4) == 0) goto L5;
        final Fragment r5 = null;
    L7:
        if ((r21 & 8) == 0) goto L9;
        final boolean r6 = true;
    L11:
        if ((r21 & 16) == 0) goto L13;
        final boolean r9 = false;
    L15:
        if ((r21 & 32) == 0) goto L17;
        final boolean r3 = false;
    L18:
        final FragmentManager.FragmentLifecycleCallbacks r7 = null;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "f");
        Intrinsics.checkNotNullParameter(r15, "tag");
        Intrinsics.checkNotNullParameter(r20, "options");
        r13.X90(r13.k, new ForsetiChainFragment$addForsetiFragment$1(r14, r13, r3, r15, r5, r6, r7, r20, r9));
        return;
    L17:
        r3 = r19;
        goto L18
    L13:
        r9 = r18;
        goto L15
    L9:
        r6 = r17;
        goto L11
    L5:
        r5 = r16;
        goto L7
    }
}
