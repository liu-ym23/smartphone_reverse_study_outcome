package com.larus.bmhome.floatchat.component;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.observer.MessageListState;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.o0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;
import v19.c7;
import v19.i5;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0080\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005*\u0006\u0081\u0001\u0084\u0001\u0090\u0001\u0018\u0000 æ\u00012\u00020\u00012\u00020\u0002:\u0002æ\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u008a\u0001\u001a\u00020|2\u0007\u0010\u008b\u0001\u001a\u00020KH\u0016J\u0013\u0010\u008c\u0001\u001a\u00020|2\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\t\u0010\u0092\u0001\u001a\u00020|H\u0002J\t\u0010\u0093\u0001\u001a\u00020|H\u0002J\u001b\u0010\u0094\u0001\u001a\u00020_2\u0007\u0010\u0095\u0001\u001a\u00020V2\u0007\u0010\u0096\u0001\u001a\u00020]H\u0002J\u0012\u0010\u0097\u0001\u001a\u00020|2\u0007\u0010\u0098\u0001\u001a\u00020_H\u0002J\t\u0010\u0099\u0001\u001a\u00020|H\u0016J\u0013\u0010\u009a\u0001\u001a\u00020|2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0002J\u0013\u0010\u009d\u0001\u001a\u00020|2\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0002J\t\u0010\u009e\u0001\u001a\u00020|H\u0002J\t\u0010\u009f\u0001\u001a\u00020_H\u0016J\u0012\u0010 \u0001\u001a\u00020|2\u0007\u0010¡\u0001\u001a\u00020gH\u0016J\u0012\u0010¢\u0001\u001a\u00020|2\u0007\u0010¡\u0001\u001a\u00020gH\u0016J\t\u0010£\u0001\u001a\u00020XH\u0016J\u0012\u0010¤\u0001\u001a\u00020|2\u0007\u0010¥\u0001\u001a\u00020>H\u0016J\u0012\u0010¦\u0001\u001a\u00020|2\u0007\u0010¥\u0001\u001a\u00020>H\u0016J\u0014\u0010§\u0001\u001a\u00020|2\t\u0010¨\u0001\u001a\u0004\u0018\u00010nH\u0016J\u0012\u0010©\u0001\u001a\u00020|2\u0007\u0010ª\u0001\u001a\u00020_H\u0016J\t\u0010«\u0001\u001a\u00020_H\u0002J\r\u0010¬\u0001\u001a\u00020n*\u00020nH\u0002J\t\u0010\u00ad\u0001\u001a\u00020_H\u0016J\u0014\u0010®\u0001\u001a\u00020|2\t\u0010¯\u0001\u001a\u0004\u0018\u00010gH\u0016J\u0012\u0010°\u0001\u001a\u00020|2\u0007\u0010±\u0001\u001a\u00020_H\u0016J\t\u0010²\u0001\u001a\u00020|H\u0016J\t\u0010³\u0001\u001a\u00020|H\u0016J\u0012\u0010´\u0001\u001a\u00020|2\u0007\u0010µ\u0001\u001a\u00020_H\u0016J\t\u0010¶\u0001\u001a\u00020_H\u0002J\u000b\u0010·\u0001\u001a\u0004\u0018\u00010uH\u0002J\t\u0010¸\u0001\u001a\u00020|H\u0002J\t\u0010¹\u0001\u001a\u00020|H\u0002J\t\u0010º\u0001\u001a\u00020|H\u0002J\t\u0010»\u0001\u001a\u00020|H\u0002J\t\u0010¼\u0001\u001a\u00020|H\u0016J\t\u0010½\u0001\u001a\u00020|H\u0002J\u0012\u0010¾\u0001\u001a\u00020|2\u0007\u0010ª\u0001\u001a\u00020_H\u0002J\u0014\u0010¿\u0001\u001a\u00020|2\t\b\u0002\u0010À\u0001\u001a\u00020_H\u0002J\u0012\u0010Á\u0001\u001a\u00020|2\u0007\u0010Â\u0001\u001a\u00020_H\u0002J\t\u0010Ã\u0001\u001a\u00020XH\u0002J\t\u0010Ä\u0001\u001a\u00020XH\u0002J\t\u0010Å\u0001\u001a\u00020XH\u0002J\u001b\u0010Æ\u0001\u001a\u00020|2\u0007\u0010Ç\u0001\u001a\u00020_2\u0007\u0010Â\u0001\u001a\u00020_H\u0002J\t\u0010È\u0001\u001a\u00020|H\u0003J\t\u0010É\u0001\u001a\u00020|H\u0002J\t\u0010Ê\u0001\u001a\u00020|H\u0002J$\u0010Ë\u0001\u001a\u00020|2\u0007\u0010Ì\u0001\u001a\u00020X2\u0007\u0010Í\u0001\u001a\u00020X2\u0007\u0010Î\u0001\u001a\u00020XH\u0002J\t\u0010Ï\u0001\u001a\u00020_H\u0002J\t\u0010Ð\u0001\u001a\u00020_H\u0002J\t\u0010Ñ\u0001\u001a\u00020|H\u0002J\t\u0010Ò\u0001\u001a\u00020|H\u0002J%\u0010Ó\u0001\u001a\u00020|2\u0007\u0010Ô\u0001\u001a\u00020u2\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0007\u0010×\u0001\u001a\u00020gH\u0002J\t\u0010Ø\u0001\u001a\u00020XH\u0002J\t\u0010Ù\u0001\u001a\u00020XH\u0002J\t\u0010Ú\u0001\u001a\u00020XH\u0002J\u0012\u0010Û\u0001\u001a\u00020|2\u0007\u0010Ü\u0001\u001a\u00020XH\u0002J\t\u0010Ý\u0001\u001a\u00020|H\u0002J\t\u0010Þ\u0001\u001a\u00020_H\u0002J\t\u0010ß\u0001\u001a\u00020_H\u0002J\t\u0010à\u0001\u001a\u00020_H\u0002J\n\u0010á\u0001\u001a\u00030â\u0001H\u0002J\t\u0010ã\u0001\u001a\u00020|H\u0002J\t\u0010ä\u0001\u001a\u00020XH\u0002J\t\u0010å\u0001\u001a\u00020XH\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001d\u0010$\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\n\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\n\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\n\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\n\u001a\u0004\b9\u0010:R\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\n\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bF\u0010GR\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010W\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\n\u001a\u0004\bY\u0010ZR\u000e\u0010\\\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010a\u001a\u00020X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\n\u001a\u0004\bb\u0010ZR\u000e\u0010d\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020XX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010v\u001a\u0016\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020_\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010x\u001a\u0016\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020_\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010z\u001a\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020|0{X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010~\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u007f\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0082\u0001R\u0013\u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0085\u0001R\u001e\u0010\u0086\u0001\u001a\u00020XX\u0096\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0087\u0001\u0010Z\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0013\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0091\u0001¨\u0006ç\u0001"}, d2 = {"Lcom/larus/bmhome/floatchat/component/FloatChatFoldHandlerComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "coreInputManager", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "getCoreInputManager", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager;", "coreInputManager$delegate", "chatListCoreAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListCoreAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListCoreAbility$delegate", "floatChatTitleAbility", "Lcom/larus/bmhome/floatchat/ability/IFloatChatTitleAbility;", "getFloatChatTitleAbility", "()Lcom/larus/bmhome/floatchat/ability/IFloatChatTitleAbility;", "floatChatTitleAbility$delegate", "chatInputCoreAbility", "Lcom/larus/bmhome/ability/IChatInputCoreAbility;", "getChatInputCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputCoreAbility;", "chatInputCoreAbility$delegate", "actionBarSceneAbility", "Lcom/larus/bmhome/ability/IChatSceneAbility;", "getActionBarSceneAbility", "()Lcom/larus/bmhome/ability/IChatSceneAbility;", "actionBarSceneAbility$delegate", "chatBottomFloatingCoreAbility", "Lcom/larus/bmhome/audio/IChatBottomFloatingApiAbility;", "getChatBottomFloatingCoreAbility", "()Lcom/larus/bmhome/audio/IChatBottomFloatingApiAbility;", "chatBottomFloatingCoreAbility$delegate", "chatFoldCoreAbility", "getChatFoldCoreAbility", "()Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "chatFoldCoreAbility$delegate", "conversationCoreAbility", "Lcom/larus/bmhome/ability/IConversationCoreAbility;", "getConversationCoreAbility", "()Lcom/larus/bmhome/ability/IConversationCoreAbility;", "conversationCoreAbility$delegate", "chatShareBottomAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getChatShareBottomAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "chatShareBottomAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/bmhome/ability/FloatChatFoldStatusChangeListener;", "chatParamCoreData", "Lcom/larus/bmhome/data/ChatParamCoreData;", "getChatParamCoreData", "()Lcom/larus/bmhome/data/ChatParamCoreData;", "chatParamCoreData$delegate", "foldHandlerVM", "Lcom/larus/bmhome/floatchat/component/FoldHandlerVM;", "getFoldHandlerVM", "()Lcom/larus/bmhome/floatchat/component/FoldHandlerVM;", "foldHandlerVM$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "root", "Landroid/view/View;", "chatInput", "messageListParent", "topHandleContainer", "titleContainer", "topHandle", "topShadow", "topShareCancel", "actionBarContainer", "actionBar", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "minPageHeight", "", "getMinPageHeight", "()I", "minPageHeight$delegate", "startTouchY", "", "shouldFold", "", "isHandlingHostScrollGesture", "hostScrollTouchSlop", "getHostScrollTouchSlop", "hostScrollTouchSlop$delegate", "hostScrollDownX", "hostScrollDownY", "queryId", "", "hasExpand", "hasPlayedDirectEnterAnimation", "conversationId", "isLocalConversation", "canExpandChatPanel", "hostChatRootBackground", "Landroid/graphics/drawable/Drawable;", "isSpeakerVisible", "directFloatSheetScreenHeight", "lastDirectFloatImeInsetsBottom", "directFloatImeLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "floatChatKeyboardAvoidanceRoot", "Lcom/larus/bmhome/view/ChatConstraintLayout;", "floatChatKeyboardAvoidanceInterceptor", "Lkotlin/Function2;", "floatChatKeyboardAvoidancePrevInterceptor", "shouldDisableKeyboardAvoidance", "keyboardAvoidanceFocusChangeListener", "Lkotlin/Function1;", "", "keyboardAvoidanceFocusListenerRegistered", "registeredConvChangeListenerId", "registeredMsgObserverId", "conversationChangeListener", "com/larus/bmhome/floatchat/component/FloatChatFoldHandlerComponent$conversationChangeListener$1", "Lcom/larus/bmhome/floatchat/component/FloatChatFoldHandlerComponent$conversationChangeListener$1;", "messageChangedObserver", "com/larus/bmhome/floatchat/component/FloatChatFoldHandlerComponent$messageChangedObserver$1", "Lcom/larus/bmhome/floatchat/component/FloatChatFoldHandlerComponent$messageChangedObserver$1;", "contentViewId", "getContentViewId", "setContentViewId", "(I)V", "onViewCreated", "view", "disallowHostScrollIfNeeded", "event", "Landroid/view/MotionEvent;", "blockListBoundaryHostScrollTouchListener", "com/larus/bmhome/floatchat/component/FloatChatFoldHandlerComponent$blockListBoundaryHostScrollTouchListener$1", "Lcom/larus/bmhome/floatchat/component/FloatChatFoldHandlerComponent$blockListBoundaryHostScrollTouchListener$1;", "beginHostScrollGesture", "endHostScrollGesture", "canListScrollVertically", "rv", "fingerDeltaY", "requestDisallowInterceptTouchEventForAncestors", "disallow", "onFragmentViewDestroyed", "onSendMessage", "msg", "Lcom/larus/im/bean/message/Message;", "onUpdateMessage", "observe", "isExpand", "fold", "from", "expand", "getShowPercent", "addFoldStatusChangeListener", "listener", "removeFoldStatusChangeListener", "setChatRootBg", "bg", "notifySpeakerVisible", "visible", "applyHostChatRootBackground", "copyForView", "canShowActionBar", "setConversationId", "convId", "setCanExpandChatPanel", "canExpand", "forceUpdateChatRootBottomPadding", "initKeyboardAvoidance", "setShouldDisableKeyboardAvoidance", "disable", "shouldDisableFloatChatKeyboardAvoidance", "chatConstraintRoot", "installFloatChatKeyboardAvoidanceGuard", "restoreFloatChatKeyboardAvoidanceGuard", "refreshFloatChatKeyboardAvoidance", "observeFloatChatKeyboardAvoidance", "expandToFullScreen", "expandDirectFloatSheetToFullScreen", "changeShareModeVisibility", "jumpToChatPage", "useFadeAnim", "foldFloatChat", "needAnim", "resolveFoldedChatBackgroundColor", "getHalfScreenHeight", "getNineSplitScreenHeight", "expandScreen", "isExpandFullScreen", "topHandleSetTouchListener", "floatChatShareInit", "exitFloatShareMode", "dealExpandOrFold", "curHeight", "lastHeight", "gestureDeltaY", "shouldUseDirectFloatSheetDragBehavior", "shouldDisallowHostScrollWhenExpanded", "installDirectFloatImeInsetsBridge", "removeDirectFloatImeLayoutListener", "updateDirectFloatImeInsets", "chatRoot", "imeInsets", "Landroidx/core/graphics/Insets;", MusicAppletPage.KEY_SOURCE, "getMaxDragHeight", "getDirectFloatSheetMaxHeight", "getDirectFloatSheetFullScreenHeight", "updateRootHeight", "height", "ensureDirectFloatHeaderVisible", "shouldHideFloatChatTitle", "shouldUseForceDarkTheme", "shouldShowSubtitleWhenFloatChatTitleHidden", "getExpandAnimDuration", "", "applyDirectFloatSheetCornerStyle", "getFloatChatPageBackgroundAttr", "getFloatChatPageBackgroundDrawable", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatChatFoldHandlerComponent extends BaseContentWidget implements g0 {
    public static final /* synthetic */ int H1 = 0;
    public View A;
    public View B;
    public View C;
    public View D;
    public View E;
    public View F;
    public View G;
    public final FloatChatFoldHandlerComponent$blockListBoundaryHostScrollTouchListener$1 G1;
    public View H;
    public com.larus.bmhome.floatchat.component.e H0;
    public View I;
    public View J;
    public RecyclerView K;
    public final Lazy L;
    public ChatConstraintLayout L0;
    public float M;
    public boolean N;
    public boolean O;
    public final Lazy P;
    public com.larus.bmhome.floatchat.component.f P0;
    public float Q;
    public float R;
    public String S;
    public boolean T;
    public boolean U;
    public String V;
    public Function2<? super Integer, ? super String, Boolean> V0;
    public boolean W;
    public boolean X;
    public Drawable Y;
    public boolean Z;
    public boolean b1;
    public final com.larus.bmhome.floatchat.component.b g1;
    public boolean h1;
    public int k0;
    public String k1;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public int p0;
    public String p1;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final b v1;
    public final Lazy w;
    public final CopyOnWriteArraySet<va8.d> x;
    public final c x1;
    public final Lazy y;
    public int y1;
    public final com.larus.ui.arch.vm.internal.l z;

    public static final class a {
    }

    public static final class b implements com.larus.im.service.d0<wc9.e> {
        public final /* synthetic */ FloatChatFoldHandlerComponent a;

        public b(FloatChatFoldHandlerComponent r1) {
            this.a = r1;
        }

        public final void c(Object r2) {
            Intrinsics.checkNotNullParameter((wc9.e) r2, "conversation");
        }

        public final void a(wc9.e r5, wc9.e r6) {
            Intrinsics.checkNotNullParameter(r6, "new");
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("On replace conversation targetId: ");
            String r2 = null;
            if (r5 == null) goto L5;
            String r3 = r5.a;
        L6:
            r1.append(r3);
            r1.append(", newId: ");
            r1.append(r6.a);
            r0.i("FloatChatFoldHandler", r1.toString());
            String r4 = this.a.V;
            if (r4 == null) goto L11;
            Lazy r7 = ic8.n.a;
            Intrinsics.checkNotNullParameter(r4, "<this>");
            boolean r8 = true;
            if (com.larus.im.j.f(r4) != true) goto L11;
        L12:
            if (r8 == false) goto L27;
            String r9 = this.a.V;
            if (r5 == null) goto L17;
            r2 = r5.a;
        L17:
            if (Intrinsics.areEqual(r9, r2) == false) goto L28;
            FloatChatFoldHandlerComponent r10 = this.a;
            r10.V = r6.a;
            if (r5 == null) goto L23;
            String r11 = r5.a;
            if (r11 == null) goto L23;
            com.larus.im.d.e().unregisterOnMessageChangedObserver(r11, r10.x1);
        L23:
            FloatChatFoldHandlerComponent r12 = this.a;
            String r13 = r12.V;
            if (r13 == null) goto L29;
            com.larus.im.d.e().registerOnMessageChangedObserver(r13, r12.x1);
            r12.p1 = r13;
            return;
        L29:
            return;
        L28:
            return;
        L27:
            return;
        L11:
            r8 = false;
            goto L12
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final class c implements nf9.b {
        public final /* synthetic */ FloatChatFoldHandlerComponent a;

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public c(FloatChatFoldHandlerComponent r1) {
            this.a = r1;
        }

        public final void a(String r8, Message r9) {
            Intrinsics.checkNotNullParameter(r8, "cid");
            Intrinsics.checkNotNullParameter(r9, "msg");
            FLogger r0 = FLogger.a;
            r0.i("TestMessageObserver", "onSendMessage, cid=" + r8 + ", queryId=" + r9.getMessageId());
            final FloatChatFoldHandlerComponent r10 = this.a;
            int r1 = FloatChatFoldHandlerComponent.H1;
            r10.getClass();
            r0.i("FloatChatFoldHandler", "onSendMessage, msgId = " + r9.getMessageId() + ", msgLocalStatus = " + r9.getMessageStatusLocal());
            String r2 = null;
        L24:
            e = move-exception;
            FLogger.a.i("FloatChatFoldHandler", "Parse json error: " + e);
        L26:
            String r3 = null;
        L28:
            if (((FoldHandlerVMState) r10.G3().getState()).getStatus() != 0) goto L45;
            if (o0.d(r3) == false) goto L45;
            va8.r r4 = (va8.r) r10.r.getValue();
            if (r4 == null) goto L34;
            String r5 = r4.WE();
        L36:
            if (Intrinsics.areEqual(r5, "aippt_new_detail") == true) goto L45;
            va8.r r6 = (va8.r) r10.r.getValue();
            if (r6 == null) goto L41;
            r2 = r6.WE();
        L41:
            if (Intrinsics.areEqual(r2, "doc_create_list") == false) goto L43;
        L48:
            Intrinsics.checkNotNullParameter(r10, "<this>");
            View r7 = com.larus.ui.arch.component.internal.attach.a.b(r10, r10).getView();
            if (r7 == null) goto L51;
            r7.post(new com.larus.bmhome.floatchat.component.c(r10));
        L51:
            r10.S = r9.getMessageId();
            r10.T = false;
            return;
        L43:
            if (z2.a.getAiDocDdxmlConfig().a() == false) goto L48;
        L34:
            r5 = null;
        L45:
            if (((FoldHandlerVMState) r10.G3().getState()).getStatus() != 0) goto L51;
            if (r9.getMessageStatusLocal() != 12) goto L51;
        L4:
            if (o0.d(r9.getContent()) == false) goto L6;
            r3 = new JSONObject(r9.getContent()).optString(ShareType.TEXT);     // Catch: Exception -> L24
            goto L28
        L6:
            List r11 = r9.getContentBlock();     // Catch: Exception -> L24
            if (r11 != null) goto L9;
        L12:
            boolean r12 = true;
        L13:
            if (r12 == true) goto L26;
            List r13 = r9.getContentBlock();     // Catch: Exception -> L24
            if (r13 == null) goto L26;
            Block r14 = (Block) ListProtector.get(r13, 0);     // Catch: Exception -> L24
            if (r14 == null) goto L26;
            BlockContent r15 = r14.getContent();     // Catch: Exception -> L24
            if (r15 == null) goto L26;
            TextBlock r16 = r15.getTextBlock();     // Catch: Exception -> L24
            if (r16 == null) goto L26;
            r3 = r16.text;     // Catch: Exception -> L24
            goto L28
        L9:
            if (r11.isEmpty() == true) goto L12;
            r12 = false;
            goto L13
        }

        public final void c(String r5, Message r6, Map<String, String> r7) {
            Intrinsics.checkNotNullParameter(r5, "cid");
            Intrinsics.checkNotNullParameter(r6, "msg");
            FLogger r8 = FLogger.a;
            r8.i("TestMessageObserver", "onUpdateMessage, cid=" + r5 + ", queryId=" + this.a.S + ", replyId=" + r6.getMessageId());
            FloatChatFoldHandlerComponent r0 = this.a;
            r0.getClass();
            if (com.larus.bmhome.chat.bean.d.G0(r6) == true) goto L33;
            StringBuilder r1 = new StringBuilder("onUpdateMessage, queryId=");
            r1.append(r0.S);
            r1.append(", replyId=");
            r1.append(r6.getReplyId());
            r1.append(", office_tool_never_user=");
            Map r9 = r6.getExt();
            String r3 = null;
            if (r9 == null) goto L8;
            String r10 = (String) r9.get("office_tool_never_used");
        L9:
            r1.append(r10);
            r1.append(", hasExpand=");
            r1.append(r0.T);
            r1.append(", canExpand=");
            r1.append(r0.X);
            r8.i("FloatChatFoldHandler", r1.toString());
            if (o0.d(r0.S) == false) goto L14;
            if (Intrinsics.areEqual(r6.getReplyId(), r0.S) == false) goto L14;
        L15:
            Map r11 = r6.getExt();
            if (r11 == null) goto L19;
            r3 = (String) r11.get("office_tool_never_used");
        L19:
            if (Intrinsics.areEqual(r3, "1") == true) goto L21;
            return;
        L21:
            if (r0.T == true) goto L30;
            r0.W = false;
            if (r0.X == false) goto L31;
            r0.T = true;
            g0 r12 = (g0) r0.t.getValue();
            if (r12 == null) goto L32;
            r12.expand("onReceiveSlidesCommonMsg");
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L14:
            if (r0.W == true) goto L15;
            return;
        L8:
            r10 = null;
            goto L9
        }
    }

    public static final class d implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
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

    public static final class e implements Function0<va8.p> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    public static final class f implements Function0<np8.a> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(np8.a.class));
        }
    }

    public static final class g implements Function0<va8.n> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.n.class));
        }
    }

    public static final class h implements Function0<va8.r> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.r.class));
        }
    }

    public static final class i implements Function0<g0> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(g0.class));
        }
    }

    public static final class j implements Function0<va8.a0> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
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

    public static final class k implements Function0<IChatMessageShareAbility> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(IChatMessageShareAbility.class));
        }
    }

    public static final class l implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
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

    public static final class m implements Function0<fp8.b> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(fp8.b.class));
        }
    }

    public static final class n implements Function0<LifecycleOwner> {
        public final /* synthetic */ ComponentFeature a;

        public n(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class o implements Function0<ViewModelStoreOwner> {
        public final /* synthetic */ ComponentFeature a;

        public o(ComponentFeature r1) {
            this.a = r1;
        }

        public final Object invoke() {
            return this.a;
        }
    }

    public static final class p implements Function0<ViewModelProvider.Factory> {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
        }

        public final Object invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    static {
    }

    public final void CI() {
        this.b1 = true;
        Z3();
    }

    public final boolean E2() {
        return false;
    }

    public final boolean Pu() {
        return false;
    }

    public final void A2() {
        com.larus.bmhome.floatchat.component.e r0 = this.H0;
        if (r0 == null) goto L17;
        View r3 = this.A;
        if (r3 == null) goto L8;
        ViewTreeObserver r4 = r3.getViewTreeObserver();
    L9:
        if (r4 == null) goto L13;
        boolean r5 = true;
        if (r4.isAlive() != true) goto L13;
    L14:
        if (r5 == false) goto L16;
        r4.removeOnGlobalLayoutListener(r0);
    L16:
        this.H0 = null;
    L13:
        r5 = false;
        goto L14
    L8:
        r4 = null;
    L17:
        RecyclerView r1 = this.K;
        if (r1 == null) goto L20;
        r1.removeOnItemTouchListener(this.G1);
    L20:
        m3();
        if (this.h1 == false) goto L26;
        va8.o r2 = (va8.o) this.w.getValue();
        if (r2 == null) goto L25;
        r2.oR(this.g1);
    L25:
        this.h1 = false;
    L26:
        d4();
        String r6 = this.k1;
        if (r6 == null) goto L29;
        com.larus.im.d.c().unRegisterConversationChangeListener(r6, this.v1);
    L29:
        String r7 = this.p1;
        if (r7 == null) goto L32;
        com.larus.im.d.e().unregisterOnMessageChangedObserver(r7, this.x1);
    L32:
        this.k1 = null;
        this.p1 = null;
        this.Y = null;
        this.Z = false;
    }

    public final int B3() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r1 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        boolean r2 = false;
        if (r1 == null) goto L5;
        int r3 = com.larus.utils.u.b(r1);
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        Integer r4 = null;
        if (r0 == null) goto L17;
        Integer r5 = Integer.valueOf(com.larus.utils.i.b(r0));
        if (r5.intValue() <= 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L17;
    L27:
        int r7 = r5.intValue();
    L29:
        Integer r8 = Integer.valueOf(r7 - r3);
        if (r8.intValue() <= 0) goto L32;
        boolean r9 = true;
    L33:
        if (r9 == true) goto L36;
        r8 = null;
    L36:
        if (r8 == null) goto L38;
        r7 = r8.intValue();
    L38:
        View r10 = this.A;
        if (r10 == null) goto L49;
        View r11 = r10.getRootView();
        if (r11 == null) goto L49;
        Integer r12 = Integer.valueOf(r11.getHeight());
        int r13 = r12.intValue();
        if (r13 > 0) goto L45;
    L47:
        if (r2 == false) goto L49;
        r4 = r12;
        goto L49
    L45:
        if (r13 < ((r7 * 4) / 5)) goto L47;
        r2 = true;
    L49:
        if (r4 == null) goto L52;
        r7 = r4.intValue();
    L52:
        if (r7 <= this.k0) goto L55;
        this.k0 = r7;
    L55:
        return RangesKt.coerceAtLeast(this.k0, Q3());
    L32:
        r9 = false;
        goto L33
    L11:
        r6 = false;
    L17:
        Context r14 = getContext();
        if (r14 == null) goto L25;
        r5 = Integer.valueOf(com.larus.utils.i.b(r14));
        if (r5.intValue() <= 0) goto L22;
        boolean r15 = true;
    L23:
        if (r15 == false) goto L25;
    L26:
        if (r5 != null) goto L27;
        int r16 = m0.a;
        r7 = m0.a(getContext());
        goto L29
    L22:
        r15 = false;
    L25:
        r5 = null;
        goto L26
    L5:
        r3 = 0;
        goto L6
    }

    public final void BW() {
        ChatConstraintLayout r0 = this.A;
        if ((r0 instanceof ChatConstraintLayout) == false) goto L5;
        ChatConstraintLayout r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r2 == null) goto L30;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L31;
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L17;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r5 = ThreadMethodProxy.currentThread();
        if (r5 == com.larus.home.impl.utils.c.a) goto L17;
        com.larus.home.impl.utils.c.a(r5, "getDecorView");
    L17:
        if (r4 == null) goto L32;
        WindowInsetsCompat r6 = ViewCompat.getRootWindowInsets(r4);
        if (r6 == null) goto L24;
        boolean r7 = true;
        if (r6.isVisible(WindowInsetsCompat.Type.ime()) != true) goto L24;
    L25:
        if (r7 == false) goto L27;
        Insets r8 = r6.getInsets(WindowInsetsCompat.Type.ime());
    L28:
        Intrinsics.checkNotNull(r8);
        r1.H6(r8, "forceUpdateChatRootBottomPadding");
        return;
    L27:
        r8 = Insets.of(0, 0, 0, 0);
    L24:
        r7 = false;
        goto L25
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final int C3() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r0 == null) goto L5;
        int r1 = com.larus.utils.u.c(r0);
    L7:
        return RangesKt.coerceAtLeast(B3() - r1, Q3());
    L5:
        r1 = 0;
        goto L7
    }

    public final np8.a E3() {
        return (np8.a) this.p.getValue();
    }

    public final FoldHandlerVM G3() {
        return (FoldHandlerVM) this.z.getValue();
    }

    public final int H3() {
        fp8.b r0 = (fp8.b) this.y.getValue();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.c;
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r3 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r3 == null) goto L9;
        int r4 = com.larus.utils.u.c(r3);
    L10:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r5 == null) goto L13;
        r1 = com.larus.utils.u.b(r5);
    L13:
        int r6 = m0.a;
        return ((int) (((double) (((m0.a(getContext()) - r2) - r4) - r1)) * 0.75d)) + c7.b(16);
    L9:
        r4 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final int Q3() {
        return ((Number) this.L.getValue()).intValue();
    }

    public final void Z3() {
        if (this.P0 != null) goto L5;
        W3();
    L5:
        ChatConstraintLayout r0 = this.L0;
        if (r0 != null) goto L8;
        return;
    L8:
        boolean r2 = false;
        if (this.b1 == false) goto L18;
        va8.o r1 = (va8.o) this.w.getValue();
        if (r1 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L18;
        r2 = true;
        goto L18
    L13:
        if (r1.n5() != true) goto L15;
        r3 = true;
    L18:
        if (r2 == true) goto L20;
        return;
    L20:
        if (r0.getBottomPadding() <= 0) goto L30;
        Function2 r4 = r0.getInterruptBottomPaddingUpdate();
        r0.setInterruptBottomPaddingUpdate(new com.larus.bmhome.floatchat.component.o());
        r0.u6();     // Catch: Throwable -> L24
        r0.setInterruptBottomPaddingUpdate(r4);
        return;
    L24:
        th = move-exception;
        r0.setInterruptBottomPaddingUpdate(r4);
        throw th;
    }

    public final int c4() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r0 != null) goto L5;
    L11:
        View r1 = this.A;
        if (r1 == null) goto L15;
        Context r2 = r1.getContext();
        if (r2 == null) goto L15;
    L17:
        return ContextCompat.getColor(r2, v19.c.b(2130970529, r2, 2131102529));
    L15:
        r2 = getContext();
        goto L17
    L5:
        if (r0.containsKey("argHostChatBackgroundColor") == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        return r0.getInt("argHostChatBackgroundColor");
    }

    public final void d4() {
        ChatConstraintLayout r0 = this.L0;
        if (r0 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.floatchat.component.f r1 = this.P0;
        if (r1 != null) goto L8;
    L13:
        this.L0 = null;
        this.P0 = null;
        this.V0 = null;
        return;
    L8:
        if (r0.getInterruptBottomPaddingUpdate() != r1) goto L13;
        Function2<? super Integer, ? super String, Boolean> r2 = this.V0;
        if (r2 != null) goto L12;
        r2 = new com.larus.bmhome.floatchat.component.a();
    L12:
        r0.setInterruptBottomPaddingUpdate(r2);
        goto L13
    }

    public final boolean e4() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
    L12:
        return false;
    L10:
        if (((FoldHandlerVMState) G3().getState()).getStatus() == 0) goto L12;
        return true;
    L5:
        if (r0.getBoolean("float_chat_disallow_host_scroll_when_expanded") != true) goto L7;
        r1 = true;
        goto L8
    }

    public final boolean h4() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r0 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getBoolean("float_chat_direct_fold_on_drag_down") != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void m3() {
        if (this.O == true) goto L5;
        return;
    L5:
        this.O = false;
        RecyclerView r1 = this.K;
        if (r1 == null) goto L8;
        r1.setNestedScrollingEnabled(true);
    L8:
        a4(false);
    }

    /* JADX WARN: Type inference failed for: r0v34, types: [com.larus.bmhome.floatchat.component.b] */
    /* JADX WARN: Type inference failed for: r0v38, types: [com.larus.bmhome.floatchat.component.FloatChatFoldHandlerComponent$blockListBoundaryHostScrollTouchListener$1] */
    public FloatChatFoldHandlerComponent() {
        this.m = LazyKt.lazy(new d(this));
        this.n = LazyKt.lazy(new s(this));
        this.o = LazyKt.lazy(new e(this));
        this.p = LazyKt.lazy(new f(this));
        this.q = LazyKt.lazy(new g(this));
        this.r = LazyKt.lazy(new h(this));
        this.s = LazyKt.lazy(new t(this));
        this.t = LazyKt.lazy(new i(this));
        this.u = LazyKt.lazy(new j(this));
        this.v = LazyKt.lazy(new k(this));
        this.w = LazyKt.lazy(new l(this));
        this.x = new CopyOnWriteArraySet();
        this.y = LazyKt.lazy(new m(this));
        this.z = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(FoldHandlerVM.class), Reflection.getOrCreateKotlinClass(FoldHandlerVMState.class), new n(this), new o(this), p.a);
        this.L = LazyKt.lazy(new u(this));
        this.P = LazyKt.lazy(new v(this));
        this.X = true;
        this.p0 = -1;
        this.g1 = new com.larus.bmhome.floatchat.component.b(this);
        this.v1 = new b(this);
        this.x1 = new c(this);
        this.y1 = 2131365588;
        this.G1 = new FloatChatFoldHandlerComponent$blockListBoundaryHostScrollTouchListener$1(this);
    }

    public final long D3() {
        if (h4() == false) goto L6;
        return 250;
    L6:
        return 150;
    }

    public final int Gt() {
        int r0 = ((FoldHandlerVMState) G3().getState()).getStatus();
        if (r0 != 1) goto L5;
        return 50;
    L5:
        if (r0 != 2) goto L7;
        return 90;
    L7:
        if (r0 == 3) goto L9;
        return 0;
    L9:
        return 100;
    }

    public final void Pb() {
        W3();
        va8.f0 r0 = s1a.d.a(this).getAbility(va8.f0.class);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L17;
        va8.o r2 = (va8.o) this.w.getValue();
        if (r2 == null) goto L17;
        i1 r3 = r2.cv();
        if (r3 == null) goto L17;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new FloatChatFoldHandlerComponent$observeFloatChatKeyboardAvoidance$1(r3, this, null), 3, null);
    L17:
        if (this.h1 == true) goto L23;
        va8.o r4 = (va8.o) this.w.getValue();
        if (r4 == null) goto L21;
        r4.GM(this.g1);
    L21:
        this.h1 = true;
        return;
    L23:
        return;
    L5:
        if (r0.R() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final int V3() {
        if (h4() == true) goto L5;
        int r0 = m0.a;
        int r1 = (int) (((double) m0.a(getContext())) * 0.85d);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragment();
        if (r2 == null) goto L11;
        View r3 = r2.getView();
        if (r3 == null) goto L11;
        int r4 = r3.getHeight();
    L13:
        return Math.min(r1, r4);
    L11:
        r4 = r1;
        goto L13
    L5:
        return RangesKt.coerceAtLeast(RangesKt.coerceAtMost((B3() * 90) / 100, C3()), Q3());
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.bmhome.floatchat.component.f, kotlin.jvm.functions.Function2] */
    public final void W3() {
        va8.f0 r0 = s1a.d.a(this).getAbility(va8.f0.class);
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.R() != true) goto L7;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        ChatConstraintLayout r2 = this.A;
        if ((r2 instanceof ChatConstraintLayout) == false) goto L13;
        ChatConstraintLayout r3 = r2;
    L14:
        if (r3 != null) goto L17;
        return;
    L17:
        if (this.L0 == r3) goto L19;
    L21:
        d4();
        this.L0 = r3;
        final Function2<? super Integer, ? super String, Boolean> r4 = r3.getInterruptBottomPaddingUpdate();
        this.V0 = r4;
        ?? r5 = new com.larus.bmhome.floatchat.component.f(this, r4);
        this.P0 = r5;
        r3.setInterruptBottomPaddingUpdate(r5);
        return;
    L19:
        if (this.P0 == null) goto L21;
        return;
    L13:
        r3 = null;
    L7:
        r1 = false;
        goto L8
    }

    public final boolean YC() {
        if (((FoldHandlerVMState) G3().getState()).getStatus() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void eA() {
        ConstraintLayout.LayoutParams r5 = null;
        if (h4() == false) goto L26;
        View r0 = this.G;
        if (r0 == null) goto L7;
        e1.o(r0);
    L7:
        View r1 = this.A;
        if (r1 == null) goto L57;
        View r6 = this.F;
        if (r6 == null) goto L12;
        e1.o(r6);
    L12:
        ViewPropertyAnimator r7 = r1.animate();
        if (r7 == null) goto L15;
        r7.cancel();
    L15:
        r1.setTranslationY(0.0f);
        ConstraintLayout.LayoutParams r8 = Integer.valueOf(r1.getLayoutParams().height);
        if (r8.intValue() <= 0) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L21;
        r5 = r8;
    L21:
        if (r5 == null) goto L23;
        int r2 = r5.intValue();
    L24:
        final int r10 = C3();
        FLogger.a.i("FloatChatFoldHandler", "expandDirectFloatSheetToFullScreen, from: " + r2 + ", to: " + r10);
        ValueAnimator r3 = ValueAnimator.ofInt(new int[]{r2, r10}).setDuration(D3());
        r3.addUpdateListener(new com.larus.bmhome.floatchat.component.k(this, r10));
        Intrinsics.checkNotNull(r3);
        d2a.g.c(r3, new com.larus.bmhome.floatchat.component.m(this));
        r3.setInterpolator(new LinearInterpolator());
        r3.start();
        return;
    L23:
        r2 = r1.getHeight();
        goto L24
    L18:
        r9 = false;
        goto L19
    L57:
        return;
    L26:
        View r4 = this.G;
        if (r4 == null) goto L29;
        e1.o(r4);
    L29:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r11 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if ((r11 instanceof FragmentActivity) == true) goto L33;
        r11 = null;
    L33:
        if (r11 == null) goto L58;
        final View r12 = this.A;
        if (r12 == null) goto L59;
        View r13 = this.F;
        if (r13 == null) goto L39;
        e1.o(r13);
    L39:
        final int r14 = r12.getLayoutParams().height;
        int r15 = com.larus.utils.u.c(r11) + r14;
        View r16 = this.D;
        if (r16 == null) goto L44;
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L44;
        int r18 = r17.height;
    L45:
        final int r19 = r18;
        View r20 = this.E;
        if (r20 == null) goto L48;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
    L50:
        if ((r21 instanceof ConstraintLayout.LayoutParams) == false) goto L52;
        r5 = (ConstraintLayout.LayoutParams) r21;
    L52:
        if (r5 == null) goto L54;
        final int r22 = ((ViewGroup.MarginLayoutParams) r5).topMargin;
    L55:
        FLogger.a.i("FloatChatFoldHandler", "Current height: " + r14 + ", target height: " + r15);
        ValueAnimator r23 = ValueAnimator.ofInt(new int[]{r14, r15}).setDuration(300);
        final int r110 = r22;
        r23.addUpdateListener(new com.larus.bmhome.floatchat.component.h(r12, r14, this, r19, r110));
        Intrinsics.checkNotNull(r23);
        d2a.g.c(r23, new com.larus.bmhome.floatchat.component.i(this, r19, r22));
        r23.setInterpolator(new LinearInterpolator());
        r23.start();
        return;
    L54:
        r22 = i5.r0();
        goto L55
    L48:
        r21 = null;
    L44:
        r18 = i5.g0();
        goto L45
    L59:
        return;
    }

    public final void p3() {
        if (h4() == true) goto L5;
        return;
    L5:
        View r0 = this.D;
        if (r0 == null) goto L8;
        e1.x(r0);
    L8:
        View r1 = this.D;
        if (r1 == null) goto L11;
        r1.bringToFront();
    L11:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r2 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        boolean r3 = false;
        if (r2 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L30;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r5 != null) goto L21;
    L23:
        if (r3 == true) goto L30;
        np8.a r6 = E3();
        if (r6 == null) goto L27;
        r6.La();
    L27:
        View r7 = this.E;
        if (r7 == null) goto L40;
        r7.bringToFront();
        return;
    L40:
        return;
    L21:
        if (r5.getBoolean("float_chat_show_subtitle_when_title_hidden") != true) goto L23;
        r3 = true;
    L30:
        View r8 = this.E;
        if (r8 == null) goto L33;
        e1.x(r8);
    L33:
        np8.a r9 = E3();
        if (r9 == null) goto L36;
        r9.n3();
    L36:
        View r10 = this.E;
        if (r10 == null) goto L42;
        r10.bringToFront();
        return;
    L42:
        return;
    L14:
        if (r2.getBoolean("float_chat_hide_title") != true) goto L16;
        r4 = true;
        goto L17
    }

    public final int U2() {
        return this.y1;
    }

    public static final void z3(FloatChatFoldHandlerComponent r3) {
        View r0 = r3.C;
        if (r0 == null) goto L5;
        e1.o(r0);
    L5:
        View r1 = r3.D;
        if (r1 == null) goto L8;
        e1.o(r1);
    L8:
        View r2 = r3.G;
        if (r2 == null) goto L11;
        e1.o(r2);
    L11:
        np8.a r4 = r3.E3();
        if (r4 == null) goto L14;
        r4.La();
    L14:
        xa8.a r5 = (xa8.a) r3.s.getValue();
        if (r5 == null) goto L17;
        r5.H9(true);
    L17:
        View r6 = r3.A;
        FrameLayout.LayoutParams r7 = null;
        if (r6 == null) goto L20;
        ViewGroup.LayoutParams r8 = r6.getLayoutParams();
    L22:
        if ((r8 instanceof FrameLayout.LayoutParams) == false) goto L24;
        r7 = (FrameLayout.LayoutParams) r8;
    L24:
        if (r7 == null) goto L26;
        r7.height = -2;
    L26:
        View r9 = r3.A;
        if (r9 == null) goto L29;
        r9.setLayoutParams(r7);
    L29:
        View r10 = r3.A;
        if (r10 == null) goto L33;
        r10.setBackground(new ColorDrawable(r3.c4()));
        return;
    L33:
        return;
    L20:
        r8 = null;
        goto L22
    }

    public final void Dj(va8.d r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        FLogger.a.i("FloatChatFoldHandler", "addFoldStatusChangeListener listener:" + r4 + ", current:" + this.x.size());
        if (this.x.contains(r4) == true) goto L6;
        this.x.add(r4);
        return;
    }

    public final void Iq(boolean r1) {
        this.X = r1;
    }

    public final void PJ(boolean r4) {
        if (((FoldHandlerVMState) G3().getState()).getStatus() == 0) goto L5;
        return;
    L5:
        View r0 = this.A;
        if (r0 == null) goto L8;
        View r1 = r0.findViewById(2131375324);
    L9:
        this.Z = r4;
        if (r4 == false) goto L17;
        if (r1 == null) goto L13;
        r1.setBackground(new ColorDrawable(c4()));
    L13:
        View r5 = this.A;
        if (r5 == null) goto L41;
        r5.setBackground(new ColorDrawable(ContextCompat.getColor(getContext(), R.color.transparent)));
        return;
    L41:
        return;
    L17:
        if (this.Y == null) goto L20;
        if (r1 == null) goto L20;
        r1.setBackground(new ColorDrawable(ContextCompat.getColor(getContext(), R.color.transparent)));
    L20:
        Drawable r6 = this.Y;
        if (r6 == null) goto L35;
        Drawable.ConstantState r2 = r6.getConstantState();
        if (r2 == null) goto L28;
        Drawable r3 = r2.newDrawable();
        if (r3 == null) goto L28;
        Drawable r7 = r3.mutate();
        if (r7 == null) goto L28;
    L29:
        if (r7 == null) goto L35;
        View r8 = this.A;
        if (r8 == null) goto L34;
        r8.setBackground(r7);
    L34:
        boolean r9 = true;
    L36:
        if (r9 == true) goto L43;
        View r10 = this.A;
        if (r10 == null) goto L44;
        r10.setBackground(new ColorDrawable(c4()));
        return;
    L44:
        return;
    L43:
        return;
    L28:
        r7 = r6.mutate();
    L35:
        r9 = false;
        goto L36
    L8:
        r1 = null;
        goto L9
    }

    public final void X2(int r1) {
        this.y1 = r1;
    }

    public final void X3(boolean r8) {
        com.bytedance.router.i r0 = SmartRouter.buildRoute(getContext(), "//flow/chat_page");
        r0.c.putExtra("landing_channel", ChatLandingChannel.CHAT_LIST.getChannel());
        va8.a0 r1 = (va8.a0) this.u.getValue();
        String r2 = null;
        if (r1 == null) goto L7;
        wc9.e r3 = r1.h();
        if (r3 == null) goto L7;
        String r4 = r3.a;
    L8:
        r0.c.putExtra("argConversationId", r4);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r5 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r5 == null) goto L21;
        String r6 = r5.getString("human_merge_forward_info");
        if (r6 == null) goto L21;
        if ((!StringsKt.isBlank(r6)) == false) goto L15;
        r2 = r6;
    L15:
        if (r2 == null) goto L21;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r7 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r7 == null) goto L19;
        r7.putBoolean("human_merge_forward_keep_cache", true);
    L19:
        r0.j("human_merge_forward_info", r2);
    L21:
        if (r8 == false) goto L23;
        r0.d = 2130772343;
        r0.e = 2130772399;
        r0.d();
        return;
    L23:
        r0.d = 2130772399;
        r0.e = 2130772399;
        r0.d();
        return;
    L7:
        r4 = null;
        goto L8
    }

    public final void Zh(va8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.x.contains(r2) == false) goto L6;
        this.x.remove(r2);
        return;
    }

    public final void a4(boolean r2) {
        View r0 = this.A;
        if (r0 == null) goto L5;
        ViewParent r1 = r0.getParent();
    L6:
        if (r1 == null) goto L8;
        r1.requestDisallowInterceptTouchEvent(r2);
        r1 = r1.getParent();
        goto L6
    L8:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void expand(String r3) {
        Intrinsics.checkNotNullParameter(r3, "from");
        if (YC() == true) goto L6;
        G3().toNineSplitScreen(true, r3);
        return;
    }

    public final void gA(Drawable r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Drawable.ConstantState r0 = r2.getConstantState();
        if (r0 == null) goto L10;
        Drawable r1 = r0.newDrawable();
        if (r1 == null) goto L10;
        Drawable r3 = r1.mutate();
        if (r3 == null) goto L10;
    L11:
        this.Y = r3;
        if (this.Z == true) goto L27;
        if (r3 == null) goto L28;
        Drawable.ConstantState r4 = r3.getConstantState();
        if (r4 == null) goto L20;
        Drawable r5 = r4.newDrawable();
        if (r5 == null) goto L20;
        Drawable r6 = r5.mutate();
        if (r6 == null) goto L20;
    L21:
        if (r6 == null) goto L30;
        View r7 = this.A;
        if (r7 == null) goto L29;
        r7.setBackground(r6);
        return;
    L29:
        return;
    L30:
        return;
    L20:
        r6 = r3.mutate();
        goto L21
    L28:
        return;
    L27:
        return;
    L10:
        r3 = r2.mutate();
        goto L11
    }

    public final void h3(boolean r1) {
        if (r1 == false) goto L9;
        View r2 = this.H;
        if (r2 == null) goto L6;
        e1.x(r2);
    L6:
        View r3 = this.B;
        if (r3 == null) goto L16;
        e1.o(r3);
        return;
    L16:
        return;
    L9:
        View r4 = this.H;
        if (r4 == null) goto L12;
        e1.o(r4);
    L12:
        View r5 = this.B;
        if (r5 == null) goto L18;
        e1.x(r5);
        return;
    }

    public final void i4(int r4) {
        View r0 = this.A;
        FrameLayout.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L9;
        r1 = (FrameLayout.LayoutParams) r2;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        r1.height = r4;
        if (h4() == false) goto L14;
        r1.gravity = 80;
    L14:
        View r5 = this.A;
        if (r5 == null) goto L17;
        r5.setLayoutParams(r1);
    L17:
        View r6 = this.A;
        if (r6 == null) goto L21;
        r6.invalidateOutline();
        return;
    L21:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void km(String r4) {
        Intrinsics.checkNotNullParameter(r4, "from");
        FLogger.a.i("FloatChatFoldHandler", "out fold " + r4);
        G3().foldFloatChat(false, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [android.view.ViewTreeObserver$OnGlobalLayoutListener, com.larus.bmhome.floatchat.component.e] */
    public final void onViewCreated(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        this.A = r10;
        if (h4() == false) goto L6;
        r10.setVisibility(4);
    L6:
        if (h4() == false) goto L11;
        View r0 = this.A;
        if (r0 == null) goto L11;
        r0.setClipToOutline(true);
        r0.setOutlineProvider(new w(r0));
    L11:
        this.B = r10.findViewById(2131375324);
        this.C = r10.findViewById(2131379994);
        this.D = r10.findViewById(2131389157);
        this.F = r10.findViewById(2131389156);
        this.G = r10.findViewById(2131389223);
        this.E = r10.findViewById(2131372935);
        View r1 = r10.findViewById(2131389224);
        this.H = r1;
        if (r1 == null) goto L14;
        e1.o(r1);
    L14:
        View r11 = r10.findViewById(2131362044);
        this.I = r11;
        if (r11 == null) goto L17;
        e1.o(r11);
    L17:
        View r12 = this.I;
        RecyclerView r2 = null;
        if (r12 == null) goto L20;
        View r13 = r12.findViewById(2131362041);
    L21:
        this.J = r13;
        View r14 = this.C;
        if (r14 == null) goto L24;
        e1.o(r14);
    L24:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r3 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r3 == null) goto L27;
        String r4 = r3.getString("argConversationId", "");
    L28:
        this.V = r4;
        if (r4 == null) goto L31;
        Lazy r5 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.W = com.larus.im.j.f(r4);
        com.larus.im.d.c().registerConversationChangeListener(r4, this.v1);
        this.k1 = r4;
        com.larus.im.d.e().registerOnMessageChangedObserver(r4, this.x1);
        this.p1 = r4;
    L31:
        z8 r15 = (z8) this.n.getValue();
        if (r15 == null) goto L34;
        r15.w9(false);
    L34:
        ComponentViewModel.onEach$default(G3(), FloatChatFoldHandlerComponent$observe$1.INSTANCE, FloatChatFoldHandlerComponent$observe$2.INSTANCE, null, new FloatChatFoldHandlerComponent$observe$3(this, null), 4, null);
        ChatConstraintLayout r16 = this.A;
        if ((r16 instanceof ChatConstraintLayout) == false) goto L37;
        ChatConstraintLayout r17 = r16;
    L38:
        if (r17 == null) goto L41;
        r17.setOnImePaddingUpdate(new com.larus.bmhome.floatchat.component.g(this));
    L41:
        if (h4() == false) goto L53;
        ChatConstraintLayout r18 = this.A;
        if ((r18 instanceof ChatConstraintLayout) == false) goto L46;
        final ChatConstraintLayout r19 = r18;
    L47:
        if (r19 == null) goto L53;
        if (this.H0 != null) goto L53;
        ?? r6 = new com.larus.bmhome.floatchat.component.e(this, r19);
        this.H0 = r6;
        r19.getViewTreeObserver().addOnGlobalLayoutListener(r6);
        goto L53
    L46:
        r19 = null;
    L53:
        y r110 = new y(this);
        View r7 = this.D;
        if (r7 == null) goto L56;
        r7.setOnTouchListener(r110);
    L56:
        View r8 = this.F;
        if (r8 == null) goto L59;
        r8.setOnTouchListener(r110);
    L59:
        View r9 = this.E;
        if (r9 == null) goto L62;
        r9.setOnTouchListener(r110);
    L62:
        View r111 = this.H;
        if (r111 == null) goto L65;
        e1.d(r111, new com.larus.bmhome.floatchat.component.d(this));
    L65:
        IChatMessageShareAbility r112 = (IChatMessageShareAbility) this.v.getValue();
        if (r112 == null) goto L68;
        r112.A60(new x(this));
    L68:
        va8.p r113 = (va8.p) this.o.getValue();
        if (r113 == null) goto L71;
        r2 = r113.Ly();
    L71:
        this.K = r2;
        if (r2 == null) goto L74;
        r2.addOnItemTouchListener(this.G1);
    L74:
        va8.p r114 = (va8.p) this.o.getValue();
        if (r114 == null) goto L78;
        r114.rW(new com.larus.bmhome.floatchat.component.l(this));
        return;
    L78:
        return;
    L37:
        r17 = null;
        goto L38
    L27:
        r4 = null;
        goto L28
    L20:
        r13 = null;
        goto L21
    }

    public final void setConversationId(String r4) {
        this.V = r4;
        if (r4 == null) goto L14;
        Lazy r0 = ic8.n.a;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        this.W = com.larus.im.j.f(r4);
        String r1 = this.p1;
        if (r1 != null) goto L7;
    L12:
        com.larus.im.d.e().registerOnMessageChangedObserver(r4, this.x1);
        this.p1 = r4;
        return;
    L7:
        if ((!Intrinsics.areEqual(r1, r4)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        com.larus.im.d.e().unregisterOnMessageChangedObserver(r1, this.x1);
        goto L12
    }

    public static final void Y2(final FloatChatFoldHandlerComponent r7, boolean r8) {
        final int r0 = r7.V3();
        boolean r1 = true;
        if (r8 == true) goto L5;
    L30:
        if (r8 == false) goto L36;
        int[] r9 = new int[2];
        View r3 = r7.A;
        if (r3 == null) goto L34;
        int r4 = r3.getHeight();
    L35:
        r9[0] = r4;
        r9[1] = r0;
        ValueAnimator r10 = ValueAnimator.ofInt(r9).setDuration(r7.D3());
        r10.addUpdateListener(new r(r7, r0));
        r10.setInterpolator(new LinearInterpolator());
        r10.start();
    L39:
        View r11 = r7.C;
        if (r11 == null) goto L42;
        e1.x(r11);
    L42:
        View r12 = r7.D;
        if (r12 == null) goto L45;
        e1.x(r12);
    L45:
        View r13 = r7.G;
        if (r13 == null) goto L48;
        e1.x(r13);
    L48:
        View r14 = r7.I;
        if (r14 == null) goto L51;
        e1.o(r14);
    L51:
        View r15 = r7.J;
        if (r15 == null) goto L54;
        e1.o(r15);
    L54:
        View r16 = r7.A;
        if (r16 == null) goto L58;
        Context r17 = r16.getContext();
        if (r17 == null) goto L58;
    L59:
        View r2 = r7.A;
        if (r2 != null) goto L62;
    L86:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Bundle r18 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getArguments();
        if (r18 != null) goto L89;
    L91:
        boolean r19 = false;
    L92:
        if (r19 == false) goto L103;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Bundle r20 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getArguments();
        if (r20 != null) goto L96;
    L98:
        r1 = false;
    L99:
        if (r1 == true) goto L103;
        np8.a r21 = r7.E3();
        if (r21 == null) goto L106;
        r21.La();
    L106:
        r7.p3();
        xa8.a r22 = (xa8.a) r7.s.getValue();
        if (r22 == null) goto L110;
        r22.H9(false);
        return;
    L110:
        return;
    L96:
        if (r20.getBoolean("float_chat_show_subtitle_when_title_hidden") != true) goto L98;
    L103:
        np8.a r23 = r7.E3();
        if (r23 == null) goto L106;
        r23.n3();
        goto L106
    L89:
        if (r18.getBoolean("float_chat_hide_title") != true) goto L91;
        r19 = true;
        goto L92
    L62:
        if (r7.h4() == false) goto L64;
        int r5 = 2130970864;
    L74:
        if (r7.h4() == false) goto L76;
        int r6 = 2131239831;
    L85:
        r2.setBackground(ContextCompat.getDrawable(r17, v19.c.b(r5, r17, r6)));
        goto L86
    L76:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Bundle r24 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getArguments();
        if (r24 != null) goto L79;
    L81:
        boolean r25 = false;
    L82:
        if (r25 == false) goto L84;
        r6 = 2131239074;
        goto L85
    L84:
        r6 = 2131239072;
        goto L85
    L79:
        if (r24.getBoolean("argForceDarkTheme") != true) goto L81;
        r25 = true;
        goto L82
    L64:
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Bundle r26 = com.larus.ui.arch.component.internal.attach.a.b(r7, r7).getArguments();
        if (r26 != null) goto L67;
    L69:
        boolean r27 = false;
    L70:
        if (r27 == false) goto L72;
        r5 = 2130970669;
        goto L74
    L72:
        r5 = 2130970668;
        goto L74
    L67:
        if (r26.getBoolean("argForceDarkTheme") != true) goto L69;
        r27 = true;
    L58:
        r17 = r7.getContext();
        goto L59
    L34:
        r4 = r0;
        goto L35
    L36:
        r7.i4(r0);
        View r28 = r7.A;
        if (r28 == null) goto L39;
        r28.setVisibility(0);
        goto L39
    L5:
        if (r7.h4() == false) goto L30;
        if (r7.U == true) goto L30;
        r7.U = true;
        r7.i4(r0);
        View r29 = r7.A;
        if (r29 == null) goto L13;
        ViewPropertyAnimator r30 = r29.animate();
        if (r30 == null) goto L13;
        r30.cancel();
    L13:
        View r31 = r7.A;
        if (r31 == null) goto L16;
        r31.setTranslationY(r0);
    L16:
        View r32 = r7.A;
        if (r32 == null) goto L19;
        r32.setVisibility(0);
    L19:
        View r33 = r7.A;
        if (r33 == null) goto L39;
        ViewPropertyAnimator r34 = r33.animate();
        if (r34 == null) goto L39;
        ViewPropertyAnimator r35 = r34.translationY(0.0f);
        if (r35 == null) goto L39;
        ViewPropertyAnimator r36 = r35.setDuration(r7.D3());
        if (r36 == null) goto L39;
        ViewPropertyAnimator r37 = r36.setInterpolator(new LinearInterpolator());
        if (r37 == null) goto L39;
        r37.start();
        goto L39
    }
}
