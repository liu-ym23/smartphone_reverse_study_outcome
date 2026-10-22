package com.obric.assistant.component;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.actionbar.model.p0;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.g1;
import com.larus.bmhome.chat.model.j1;
import com.larus.bmhome.instruction.b2;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.IconImage;
import com.larus.im.bean.message.ImageObj;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.x1;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt;
import com.obric.assistant.actionbar.service.ObricActionBarSendServiceExtDelegate;
import com.obric.assistant.actionbar.service.ObricActionBarTrackServiceExtDelegate;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.interact.CustomBarAction;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.settings.ReferenceScreenContentConfirmFragment;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.t1;
import com.obric.assistant.task.skill.ObricOmniModeTag;
import com.obric.assistant.task.skill.ObricOmniModelTag;
import com.obric.assistant.util.t0;
import com.obric.assistant.view.ObricIconSwipeUpView;
import com.obric.assistant.window.materials.MaterialSceneType;
import com.obric.oui.material.OMaterialHelper;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import hca.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import paa.c;
import qaa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0088\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006*\u0002Ê\u0001\u0018\u0000 ß\u00022\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\bß\u0002à\u0002á\u0002â\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010Á\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Â\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Ú\u0001\u001a\u00030À\u0001H\u0016J\n\u0010Û\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Ü\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Ý\u0001\u001a\u00030À\u0001H\u0002J\n\u0010Þ\u0001\u001a\u00030À\u0001H\u0002J\n\u0010ß\u0001\u001a\u00030À\u0001H\u0002J\u0013\u0010à\u0001\u001a\u00030À\u00012\u0007\u0010á\u0001\u001a\u00020\u000fH\u0002J\u0013\u0010â\u0001\u001a\u00030À\u00012\u0007\u0010á\u0001\u001a\u00020\u000fH\u0002J\n\u0010ã\u0001\u001a\u00030À\u0001H\u0016J\u0013\u0010ä\u0001\u001a\u00030À\u00012\u0007\u0010á\u0001\u001a\u00020\u000fH\u0002J\n\u0010å\u0001\u001a\u00030À\u0001H\u0002J\u0013\u0010æ\u0001\u001a\u00030À\u00012\u0007\u0010á\u0001\u001a\u00020\u000fH\u0002J\u0013\u0010ç\u0001\u001a\u00030À\u00012\u0007\u0010è\u0001\u001a\u00020\u0005H\u0016J\u0013\u0010é\u0001\u001a\u00030À\u00012\u0007\u0010ê\u0001\u001a\u00020\u000fH\u0002J\u0014\u0010ë\u0001\u001a\u00030À\u00012\b\u0010ì\u0001\u001a\u00030¯\u0001H\u0016J\n\u0010í\u0001\u001a\u00030À\u0001H\u0003J\u0014\u0010î\u0001\u001a\u00030À\u00012\b\u0010ï\u0001\u001a\u00030ð\u0001H\u0016J\u0015\u0010ñ\u0001\u001a\u00030À\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000fH\u0002J\u0015\u0010ó\u0001\u001a\u00030×\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000fH\u0002J\n\u0010ô\u0001\u001a\u00030À\u0001H\u0016J\n\u0010õ\u0001\u001a\u00030À\u0001H\u0016J\n\u0010ö\u0001\u001a\u00030¯\u0001H\u0002J\n\u0010÷\u0001\u001a\u00030À\u0001H\u0016J\n\u0010ø\u0001\u001a\u00030¯\u0001H\u0002J\n\u0010ù\u0001\u001a\u00030¯\u0001H\u0016J\n\u0010ú\u0001\u001a\u00030¯\u0001H\u0016J\u001d\u0010û\u0001\u001a\u00030À\u00012\u0007\u0010ü\u0001\u001a\u00020\r2\b\u0010ý\u0001\u001a\u00030¯\u0001H\u0016J\n\u0010þ\u0001\u001a\u00030À\u0001H\u0016J\n\u0010ÿ\u0001\u001a\u00030¯\u0001H\u0016J\n\u0010\u0080\u0002\u001a\u00030À\u0001H\u0002J\u001d\u0010\u0081\u0002\u001a\u00030À\u00012\u0007\u0010á\u0001\u001a\u00020\u000f2\b\u0010\u0082\u0002\u001a\u00030¯\u0001H\u0002J%\u0010\u0083\u0002\u001a\n\u0012\u0005\u0012\u00030\u0085\u00020\u0084\u00022\b\u0010\u0086\u0002\u001a\u00030¯\u00012\b\u0010\u0082\u0002\u001a\u00030¯\u0001H\u0002J\u001f\u0010\u0087\u0002\u001a\u00030À\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0088\u0002\u001a\u00030¯\u0001H\u0016J\n\u0010\u0089\u0002\u001a\u00030À\u0001H\u0002J\n\u0010\u008a\u0002\u001a\u00030¯\u0001H\u0002J\u0015\u0010\u008b\u0002\u001a\u00030¯\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J+\u0010\u008c\u0002\u001a\u00030À\u00012\b\u0010\u008d\u0002\u001a\u00030¯\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000f2\n\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002H\u0016J)\u0010\u0090\u0002\u001a\u00030À\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000f2\f\b\u0002\u0010\u008e\u0002\u001a\u0005\u0018\u00010×\u0001H\u0002¢\u0006\u0003\u0010\u0091\u0002J \u0010\u0092\u0002\u001a\u00030À\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000f2\t\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u000fH\u0002J\u0016\u0010\u0094\u0002\u001a\u00030À\u00012\n\b\u0002\u0010\u0095\u0002\u001a\u00030¯\u0001H\u0002J\"\u0010\u0096\u0002\u001a\u0004\u0018\u00010\u000f2\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002H\u0002J\u001a\u0010\u0099\u0002\u001a\u00030À\u0001*\u00030\u0098\u00022\t\u0010\u0093\u0002\u001a\u0004\u0018\u00010\u000fH\u0002J\u0013\u0010\u009a\u0002\u001a\u00030À\u00012\u0007\u0010ò\u0001\u001a\u00020\u000fH\u0002J\u0015\u0010\u009b\u0002\u001a\u00030¯\u00012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\u000fH\u0002J\u0013\u0010\u009c\u0002\u001a\u00030À\u00012\u0007\u0010\u009d\u0002\u001a\u00020\u000fH\u0016J>\u0010¢\u0002\u001a\u00030À\u00012\b\u0010£\u0002\u001a\u00030\u008e\u00012\b\u0010¤\u0002\u001a\u00030¥\u00022\b\u0010¾\u0001\u001a\u00030¦\u00022\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u00022\b\u0010§\u0002\u001a\u00030¨\u0002H\u0016J\u0014\u0010©\u0002\u001a\u00030¯\u00012\b\u0010ª\u0002\u001a\u00030«\u0002H\u0002J\u000f\u0010¬\u0002\u001a\u00030À\u0001*\u00030\u0084\u0001H\u0002J\u0014\u0010\u00ad\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0002J \u0010®\u0002\u001a\u00030À\u00012\n\u0010¯\u0002\u001a\u0005\u0018\u00010¥\u00022\b\u0010°\u0002\u001a\u00030¯\u0001H\u0002J\u001e\u0010±\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010£\u0002\u001a\u00030\u008e\u0001H\u0002J\u001e\u0010²\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010£\u0002\u001a\u00030\u008e\u0001H\u0002J\u001e\u0010³\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010£\u0002\u001a\u00030´\u0002H\u0002J\u0016\u0010µ\u0002\u001a\u00030¯\u00012\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002H\u0002J\u0016\u0010¶\u0002\u001a\u00030¯\u00012\n\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0098\u0002H\u0002J\u0014\u0010·\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0002J\u001e\u0010¸\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010°\u0002\u001a\u00030«\u0002H\u0002J(\u0010¹\u0002\u001a\u00030À\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010°\u0002\u001a\u00030«\u00022\b\u0010¤\u0002\u001a\u00030¥\u0002H\u0002J\u0019\u0010º\u0002\u001a\u00030À\u0001*\u00030¦\u00022\b\u0010»\u0002\u001a\u00030¼\u0002H\u0002J\u0019\u0010½\u0002\u001a\u00030À\u0001*\u00030¦\u00022\b\u0010»\u0002\u001a\u00030¼\u0002H\u0002J\u001e\u0010¾\u0002\u001a\u00030¯\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010£\u0002\u001a\u00030´\u0002H\u0002J\u0016\u0010¿\u0002\u001a\u0005\u0018\u00010À\u00022\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0002J\u001e\u0010Á\u0002\u001a\u0005\u0018\u00010×\u00012\n\u0010Â\u0002\u001a\u0005\u0018\u00010Ã\u0002H\u0002¢\u0006\u0003\u0010Ä\u0002J(\u0010Å\u0002\u001a\u00030À\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\b\u0010£\u0002\u001a\u00030\u008e\u00012\b\u0010Æ\u0002\u001a\u00030¦\u0002H\u0002J\u0014\u0010Ç\u0002\u001a\u00030×\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u0002H\u0002J\u0014\u0010È\u0002\u001a\u00030À\u00012\b\u0010£\u0002\u001a\u00030\u008e\u0001H\u0002J6\u0010É\u0002\u001a\u00030À\u00012\b\u0010\u0097\u0002\u001a\u00030\u0098\u00022\n\u0010Ê\u0002\u001a\u0005\u0018\u00010Ë\u00022\b\u0010Ì\u0002\u001a\u00030×\u00012\n\u0010Í\u0002\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J\u001b\u0010Î\u0002\u001a\u00030À\u00012\u000f\u0010Ï\u0002\u001a\n\u0012\u0005\u0012\u00030À\u00010Ð\u0002H\u0002J\n\u0010Ñ\u0002\u001a\u00030À\u0001H\u0002J\u001e\u0010Ò\u0002\u001a\u0005\u0018\u00010×\u00012\n\u0010Í\u0002\u001a\u0005\u0018\u00010\u008e\u0001H\u0002¢\u0006\u0003\u0010Ó\u0002J\u0014\u0010Ô\u0002\u001a\u00030¯\u00012\b\u0010Õ\u0002\u001a\u00030\u0098\u0002H\u0002J\n\u0010Ö\u0002\u001a\u00030À\u0001H\u0002J\u0014\u0010×\u0002\u001a\u00030À\u00012\b\u0010Ø\u0002\u001a\u00030×\u0001H\u0016J\u0013\u0010Ù\u0002\u001a\u00030À\u00012\u0007\u0010Ú\u0002\u001a\u00020\u000fH\u0016J\u001b\u0010Û\u0002\u001a\u0014\u0012\u0007\u0012\u0005\u0018\u00010Ý\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000f0Ü\u0002H\u0016J\u000e\u0010Þ\u0002\u001a\u00030Ý\u0002*\u00020\u000fH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0015\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0015\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0015\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0015\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0015\u001a\u0004\b;\u0010<R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0015\u001a\u0004\b@\u0010AR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0015\u001a\u0004\bE\u0010FR\u001d\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0015\u001a\u0004\bJ\u0010KR\u001d\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0015\u001a\u0004\bO\u0010PR\u001d\u0010R\u001a\u0004\u0018\u00010S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0015\u001a\u0004\bT\u0010UR\u001d\u0010W\u001a\u0004\u0018\u00010X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0015\u001a\u0004\bY\u0010ZR\u001d\u0010\\\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u0015\u001a\u0004\b^\u0010_R\u001d\u0010a\u001a\u0004\u0018\u00010b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0015\u001a\u0004\bc\u0010dR\u001d\u0010f\u001a\u0004\u0018\u00010g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010\u0015\u001a\u0004\bh\u0010iR\u001d\u0010k\u001a\u0004\u0018\u00010l8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\u0015\u001a\u0004\bm\u0010nR\u001d\u0010p\u001a\u0004\u0018\u00010q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0015\u001a\u0004\br\u0010sR\u001d\u0010u\u001a\u0004\u0018\u00010v8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\by\u0010\u0015\u001a\u0004\bw\u0010xR\u001d\u0010z\u001a\u0004\u0018\u00010{8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b~\u0010\u0015\u001a\u0004\b|\u0010}R\u0019\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001a\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001a\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008a\u0001R\"\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0091\u0001\u0010\u0015\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0096\u0001\u0010\u0015\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0084\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0086\u0001R\"\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009d\u0001\u0010\u0015\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\"\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¢\u0001\u0010\u0015\u001a\u0006\b \u0001\u0010¡\u0001R\u0012\u0010£\u0001\u001a\u0005\u0018\u00010\u008e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010¤\u0001\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b¦\u0001\u0010\u0015\u001a\u0005\b¥\u0001\u0010_R\"\u0010§\u0001\u001a\u0005\u0018\u00010¨\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b«\u0001\u0010\u0015\u001a\u0006\b©\u0001\u0010ª\u0001R\u0010\u0010¬\u0001\u001a\u00030\u00ad\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010®\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010°\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010±\u0001\u001a\u00030¯\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b²\u0001\u0010³\u0001R\u0010\u0010´\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010µ\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010¶\u0001\u001a\u0005\u0018\u00010·\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bº\u0001\u0010\u0015\u001a\u0006\b¸\u0001\u0010¹\u0001R0\u0010»\u0001\u001a#\u0012\u0017\u0012\u00150¯\u0001¢\u0006\u000f\b½\u0001\u0012\n\b¾\u0001\u0012\u0005\b\b(¿\u0001\u0012\u0005\u0012\u00030À\u00010¼\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010Ã\u0001\u001a#\u0012\u0017\u0012\u00150¯\u0001¢\u0006\u000f\b½\u0001\u0012\n\b¾\u0001\u0012\u0005\b\b(¿\u0001\u0012\u0005\u0012\u00030À\u00010¼\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010Ä\u0001\u001a\u00030Å\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÈ\u0001\u0010\u0015\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0013\u0010É\u0001\u001a\u00030Ê\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Ë\u0001R\u0010\u0010Ì\u0001\u001a\u00030Í\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Î\u0001\u001a\u00030Ï\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ð\u0001\u001a\u00030Ñ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ò\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Ó\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010Ô\u0001\u001a\u0005\u0018\u00010¯\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010Õ\u0001R\u0015\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010Ø\u0001R\u0010\u0010Ù\u0001\u001a\u00030¯\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u009e\u0002\u001a\u0011\u0012\u0005\u0012\u00030 \u0002\u0012\u0005\u0012\u00030¡\u00020\u009f\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ã\u0002"}, d2 = {"Lcom/obric/assistant/component/OrionInstructionComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "Lcom/obric/assistant/ability/IObricInstructionExtAbility;", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "Lcom/obric/assistant/chat/callback/IOrionCustomActionBarCallback;", "Lcom/larus/bmhome/view/actionbar/CustomActionBarExtCallback;", "<init>", "()V", "actionBarProgress", "", "reportedObricActionPanelShowKey", "", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "chatBottomSpeakerExtraAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IOChatBottomSpeakerExtraAbility;", "getChatBottomSpeakerExtraAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IOChatBottomSpeakerExtraAbility;", "chatBottomSpeakerExtraAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "chatInputUiCoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUiCoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUiCoreAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "obricPhotoActionAbility", "Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "getObricPhotoActionAbility", "()Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "obricPhotoActionAbility$delegate", "obricSkillAbility", "Lcom/obric/assistant/ability/chat/input/IObricInputSkillAbility;", "getObricSkillAbility", "()Lcom/obric/assistant/ability/chat/input/IObricInputSkillAbility;", "obricSkillAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "continuousTalkCtrlAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "getContinuousTalkCtrlAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "continuousTalkCtrlAbility$delegate", "intercomAbility", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "getIntercomAbility", "()Lcom/obric/assistant/ability/IObricIntercomAbility;", "intercomAbility$delegate", "windowAbility", "Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "getWindowAbility", "()Lcom/obric/assistant/ability/IOrionChatWindowAbility;", "windowAbility$delegate", "obricSpecialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getObricSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "obricSpecialInputAbility$delegate", "obricActionBarAbility", "Lcom/obric/assistant/ability/IObricActionBarAbility;", "getObricActionBarAbility", "()Lcom/obric/assistant/ability/IObricActionBarAbility;", "obricActionBarAbility$delegate", "multimodalAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "bottomMenuAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "input", "Landroid/widget/FrameLayout;", "getInput", "()Landroid/widget/FrameLayout;", "input$delegate", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "actionBarContainer", "Landroid/view/ViewGroup;", "getActionBarContainer", "()Landroid/view/ViewGroup;", "actionBar", "Landroidx/recyclerview/widget/RecyclerView;", "getActionBar", "()Landroidx/recyclerview/widget/RecyclerView;", "customActionBarView", "getCustomActionBarView", "borderView", "Landroid/view/View;", "getBorderView", "()Landroid/view/View;", "borderView$delegate", "instructionUiContract", "Lcom/larus/bmhome/instruction/InstructionUiContract;", "getInstructionUiContract", "()Lcom/larus/bmhome/instruction/InstructionUiContract;", "instructionUiContract$delegate", "instructionEditorContainer", "getInstructionEditorContainer", "chatRoot", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getChatRoot", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "chatRoot$delegate", "gestureView", "Lcom/obric/assistant/view/ObricIconSwipeUpView;", "getGestureView", "()Lcom/obric/assistant/view/ObricIconSwipeUpView;", "gestureView$delegate", "deepthinkItemView", "specialInputAbility", "getSpecialInputAbility", "specialInputAbility$delegate", "obricChatInputUiAbility", "Lcom/obric/assistant/chat/bottom/sub/IObricChatInputUIAbility;", "getObricChatInputUiAbility", "()Lcom/obric/assistant/chat/bottom/sub/IObricChatInputUIAbility;", "obricChatInputUiAbility$delegate", "ignoreImeOnce", "Ljava/util/concurrent/atomic/AtomicBoolean;", "speakerVisible", "", "mockSpeakerVisible", "disableActionBarTouch", "getDisableActionBarTouch", "()Z", "isReportActionBarShow", "isMobPhoneOperationActionBarShowWhenFullScreen", "chatDraft", "Lcom/larus/bmhome/chat/model/IChatDraft;", "getChatDraft", "()Lcom/larus/bmhome/chat/model/IChatDraft;", "chatDraft$delegate", "onSpeakerVisibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", DBDefinition.NAME, "visible", "", "onSpeakerVisibleChanged", "checkIsMobActionBarShow", "onMockSpeakerVisibleCallback", "avatarView", "Lcom/larus/bmhome/view/TitleAvatarImageView;", "getAvatarView", "()Lcom/larus/bmhome/view/TitleAvatarImageView;", "avatarView$delegate", "actionBarItemTouchListener", "com/obric/assistant/component/OrionInstructionComponent$actionBarItemTouchListener$1", "Lcom/obric/assistant/component/OrionInstructionComponent$actionBarItemTouchListener$1;", "skillSelectionChangeListener", "Lcom/obric/assistant/ability/chat/input/SkillSelectionChangeListener;", "displayedSkillListChangeListener", "Lcom/obric/assistant/ability/chat/input/DisplayedSkillListChangeListener;", "phoneOperationModeChangeListener", "Lcom/obric/assistant/task/skill/ObricTaskSkillModeController$ModeChangeListener;", "phoneOperationModeActiveRefreshScheduled", "skillExtensionSettingObserverStarted", "lastObservedSkillExtensionEnabled", "Ljava/lang/Boolean;", "lastObservedOmniSkillAvailableState", "", "Ljava/lang/Integer;", "fullObricHostCallbacksRegistered", "onParentViewCreated", "observeSkillExtensionSetting", "setupWindowCustomActionBarRefresh", "observeWindowCustomBarActions", "observeActivityCustomBarActions", "observeWindowKeyguardState", "refreshWindowCustomActionBarOnMain", "reason", "refreshWindowCustomActionBar", "onDestroy", "refreshPhoneOperationActionBarOnMain", "schedulePhoneOperationActiveRefresh", "refreshPhoneOperationActionBar", "onChange", "new", "setAvatar", DBDefinition.ICON_URL, "onChatStyleChanged", "isChatWindow", "onUpdateActionBarView", "onPageStateChanged", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "setInputEditorBackground", "actionBarKey", "getInputEditorBackgroundColor", "onResume", "onStart", "isMainConversation", "onStop", "isFullObricPageHost", "isInstructionOpen", "showImeWhenOpen", "resetActionBar", "alpha", "half", "ignoreShowImeOnce", "dismissBalloon", "onCustomObricActionChanges", "applyCustomObricActionChanges", "includeScreenPerception", "buildObricActionBarSegments", "", "Lcom/obric/assistant/view/actionbar/custom/ObricBaseSegment;", "isMinorMode", "mobAssistantActionBarShow", "isFromInteractionSession", "mobPhoneOperationActionBarShow", "isShowScreenPerceptionActionBar", "isWebPerceive", "onInstructionVisibleChanged", "instructionOpen", "instructionType", "", "setupInstructionEditorView", "(Ljava/lang/String;Ljava/lang/Integer;)V", "setupPerceptionPanelTitle", "address", "resetPerceptionPanelTitle", "resetTitleWrapper", "getLatestPerceptionAddress", "item", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "syncPerceptionAddress", "reportObricActionPanelShow", "isObricPerceptionActionPanel", "switchStatus", "inputContent", "styleConfigs", "", "Lcom/obric/assistant/component/OrionInstructionComponent$ActionStyle;", "Lcom/obric/assistant/component/OrionInstructionComponent$StyleConfig;", "updateHolderStyle", "root", "icon", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "isQuickMode", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "addProIcon", "needUpdate", "updateWindowActionBarSuffixArrow", "arrow", "selected", "needRightIcon", "needRemoveRightIcon", "needRightArrow", "Lcom/larus/common_ui/widget/roundlayout/RoundConstraintLayout;", "isObricAction", "isOAutoAction", "isPhoneOperationSkillSelected", "isObricAddedSwitchSelected", "updateDeepThinkPhoneOperationIcon", "applyTextGradient", "colors", "", "doApplyGradient", "isNeedSecondaryMenu", "getRightIconConfig", "Lcom/obric/assistant/component/OrionInstructionComponent$RightIconConfig;", "getRightArrowColor", "taskState", "Lcom/obric/assistant/actionbar/statemanager/state/ObricOAutoTaskState;", "(Lcom/obric/assistant/actionbar/statemanager/state/ObricOAutoTaskState;)Ljava/lang/Integer;", "setupRightIcon", "anchorView", "getSecondaryMenuCloseSwitchView", "removeRightIcon", "onActionBarItemClick", "instructionExtraData", "Lcom/larus/bmhome/instruction/core/model/InstructionExtraData;", "openFrom", "itemView", "ensureReferenceScreenContentEnabled", "onEnabled", "Lkotlin/Function0;", "handleScreenShotActionBarClick", "resolveActionBarClickPosition", "(Landroid/view/View;)Ljava/lang/Integer;", "needCloseClickTalk", "customActionBarItem", "consumeSkillExtensionActionBarNewIfNeeded", "onActionBarScrollStateChanged", "state", "onActionBarHintChanged", "hint", "getConversationIdAndBotId", "Lkotlin/Pair;", "", "atLeastLong", "Companion", "ActionStyle", "StyleConfig", "RightIconConfig", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OrionInstructionComponent extends BaseContentWidget implements a, laa.e, com.larus.bmhome.chat.component.cvs.y.a<wc9.e>, b, IObserveToken, bda.a, rs8.f {
    public static final int p1 = 0;
    public static final int v1 = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final c7 H0;
    public final Lazy I;
    public final Lazy J;
    public final Lazy K;
    public final Lazy L;
    public final d7 L0;
    public final Lazy M;
    public final Lazy N;
    public View O;
    public final Lazy P;
    public boolean P0;
    public final Lazy Q;
    public final AtomicBoolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean V0;
    public final Lazy W;
    public final h6 X;
    public final i6 Y;
    public final Lazy Z;
    public Boolean b1;
    public Integer g1;
    public boolean h1;
    public final OrionInstructionComponent$actionBarItemTouchListener$1 k0;
    public final Map<ActionStyle, c> k1;
    public float m;
    public String n;
    public final Lazy o;
    public final Lazy p;
    public final b7 p0;
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

    public static final class d implements Function0<c> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(c.class));
        }
    }

    public static final class e implements Function0<maa.e> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    public static final class f implements Function0<com.obric.audio.continuous_talk.c> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.c.class));
        }
    }

    public static final class g implements Function0<laa.f> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
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

    public static final class h implements Function0<laa.m> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.m.class));
        }
    }

    public static final class i implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
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

    public static final class j implements Function0<laa.b> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
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

    public static final class k implements Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.multimodal.g.class));
        }
    }

    public static final class l implements Function0<f1> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(f1.class));
        }
    }

    public static final class m implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
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

    public static final class n implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    public static final class o implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public o(AttachReceiver r1) {
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

    public static final class p implements Function0<ada.c> {
        public final /* synthetic */ AttachReceiver a;

        public p(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ada.c.class));
        }
    }

    public static final class q implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public q(AttachReceiver r1) {
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

    public static final class r implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public r(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.l.class));
        }
    }

    public static final class s implements Function0<com.larus.bmhome.chat.component.bottom.p1> {
        public final /* synthetic */ AttachReceiver a;

        public s(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.p1.class));
        }
    }

    public static final class t implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.m> {
        public final /* synthetic */ AttachReceiver a;

        public t(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.m.class));
        }
    }

    public static final class u implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public u(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class v implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public v(AttachReceiver r1) {
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

    public static final class w implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public w(AttachReceiver r1) {
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

    public static final class x implements Function0<laa.h> {
        public final /* synthetic */ AttachReceiver a;

        public x(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.h.class));
        }
    }

    public static final class y implements Function0<de8.c> {
        public final /* synthetic */ AttachReceiver a;

        public y(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).g(Reflection.getOrCreateKotlinClass(de8.c.class));
        }
    }

    public final void q0() {
    }

    public final void z1(List<z0> r1) {
    }

    static {
        p1 = v19.c7.b(9);
        v1 = v19.c7.b(12);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.assistant.component.h6] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.obric.assistant.component.OrionInstructionComponent$actionBarItemTouchListener$1] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.obric.assistant.component.b7] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.obric.assistant.component.c7] */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.obric.assistant.component.d7] */
    public OrionInstructionComponent() {
        this.m = 1.0f;
        this.o = LazyKt.lazy(new y(this));
        this.p = LazyKt.lazy(new n(this));
        this.q = LazyKt.lazy(new q(this));
        this.r = LazyKt.lazy(new r(this));
        this.s = LazyKt.lazy(new s(this));
        this.t = LazyKt.lazy(new t(this));
        this.u = LazyKt.lazy(new u(this));
        this.v = LazyKt.lazy(new v(this));
        this.w = LazyKt.lazy(new w(this));
        this.x = LazyKt.lazy(new x(this));
        this.y = LazyKt.lazy(new d(this));
        this.z = LazyKt.lazy(new e(this));
        this.A = LazyKt.lazy(new f(this));
        this.B = LazyKt.lazy(new g(this));
        this.C = LazyKt.lazy(new h(this));
        this.D = LazyKt.lazy(new i(this));
        this.E = LazyKt.lazy(new j(this));
        this.F = LazyKt.lazy(new k(this));
        this.G = LazyKt.lazy(new l(this));
        this.H = LazyKt.lazy(new m(this));
        this.I = LazyKt.lazy(new q6(this));
        this.J = LazyKt.lazy(new e7(this));
        this.K = LazyKt.lazy(new f7(this));
        this.L = LazyKt.lazy(new g7(this));
        this.M = LazyKt.lazy(new h7(this));
        this.N = LazyKt.lazy(new i7(this));
        this.P = LazyKt.lazy(new o(this));
        this.Q = LazyKt.lazy(new p(this));
        this.R = new AtomicBoolean(false);
        this.U = true;
        this.V = true;
        this.W = LazyKt.lazy(new g6(this));
        this.X = new h6(this);
        this.Y = new i6(this);
        this.Z = LazyKt.lazy(new j6(this));
        this.k0 = new OrionInstructionComponent$actionBarItemTouchListener$1(this);
        this.p0 = new b7(this);
        this.H0 = new c7(this);
        this.L0 = new d7(this);
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to(ActionStyle.OBRIC, new c(2131103850, 2131103851, 2131103849, 2131103849, null, 48));
        r3[1] = TuplesKt.to(ActionStyle.NORMAL, new c(2131103805, 2131103806, 2131103849, 2131103849, null, 48));
        ActionStyle r1 = ActionStyle.SELECTED;
        if (OMaterialHelper.f() < 4) goto L5;
        c r2 = new c(2131103853, 2131103854, 2131103847, 2131103847, MaterialSceneType.ACTION_BAR_SELECTED, 16);
    L6:
        r3[2] = TuplesKt.to(r1, r2);
        this.k1 = MapsKt.mapOf(r3);
        return;
    L5:
        r2 = new c(2131103853, 2131103854, 2131105539, 2131105539, MaterialSceneType.ACTION_BAR_SELECTED, 16);
        goto L6
    }

    public final ICoreInputAbility B3() {
        return (ICoreInputAbility) this.w.getValue();
    }

    public final boolean D3() {
        if (this.S == false) goto L5;
        return true;
    L5:
        if (this.T == false) goto L21;
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == true) goto L24;
        laa.f r2 = (laa.f) this.B.getValue();
        if (r2 != null) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L21;
        return true;
    L16:
        if (r2.kT() != true) goto L18;
        r3 = true;
        goto L19
    L24:
        return true;
    L9:
        if (r0.isWindowMode() != true) goto L11;
        r1 = true;
    L21:
        return false;
    }

    public final boolean Fs() {
        return this.R.getAndSet(false);
    }

    public final va8.c G3() {
        va8.o r0 = (va8.o) this.v.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Uv();
    }

    public final b2 Q3() {
        return (b2) this.L.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.multimodal.g W3() {
        return (com.larus.bmhome.chat.component.bottom.multimodal.g) this.F.getValue();
    }

    public final laa.b X3() {
        return (laa.b) this.E.getValue();
    }

    public final ada.c Z3() {
        return (ada.c) this.Q.getValue();
    }

    public final laa.h a4() {
        return (laa.h) this.x.getValue();
    }

    public final c c4() {
        return (c) this.y.getValue();
    }

    public final laa.d d4() {
        return (laa.d) this.q.getValue();
    }

    public final void l4() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onSpeakerVisibleChanged, speakerVisible: ");
        r1.append(this.S);
        r1.append(", mockSpeakerVisible: ");
        r1.append(this.T);
        r1.append(", isMockViewVisible: ");
        laa.f r2 = (laa.f) this.B.getValue();
        GradientMaskView r3 = null;
        if (r2 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r2.kT());
    L6:
        r1.append(r4);
        r1.append(", isWindowMode: ");
        IAssistantChatWindow r5 = IAssistantChatWindowKt.getAssistantChatWindow();
        boolean r6 = true;
        if (r5 != null) goto L9;
    L11:
        boolean r7 = false;
    L12:
        r1.append(r7);
        r0.i("OrionExtraComponent", r1.toString());
        if (s1a.a.d(this) == false) goto L16;
        r0.i("OrionExtraComponent", "speakerVisibleChanged isLandscapeFullWindow, return");
        return;
    L16:
        boolean r8 = D3();
        if (r8 == false) goto L19;
    L30:
        if (r8 == false) goto L32;
        float r9 = 0.0f;
    L33:
        com.larus.bmhome.chat.component.bottom.core.a r10 = G3();
        if (r10 == null) goto L36;
        r3 = r10.a();
    L36:
        if (r3 == null) goto L38;
        r3.setAlpha(r9);
    L38:
        View r11 = (View) this.K.getValue();
        if (r11 == null) goto L41;
        r11.setAlpha(r9);
    L41:
        laa.h r12 = a4();
        if (r12 == null) goto L44;
        r12.X30();
    L44:
        if (r8 == false) goto L49;
        RecyclerView r13 = C3();
        if (r13 == null) goto L48;
        e1.q(r13);
    L48:
        p3().setClickable(false);
    L53:
        if (r8 == false) goto L57;
        r0.i("OrionExtraComponent", "hide gestureView");
        ObricIconSwipeUpView r14 = (ObricIconSwipeUpView) this.N.getValue();
        if (r14 == null) goto L68;
        e1.o(r14);
        return;
    L68:
        return;
    L57:
        r0.i("OrionExtraComponent", "check show gestureView");
        ObricIconSwipeUpView r15 = (ObricIconSwipeUpView) this.N.getValue();
        if (r15 != null) goto L60;
    L62:
        r6 = false;
    L63:
        if (r6 == false) goto L70;
        r0.i("OrionExtraComponent", "show gestureView");
        ObricIconSwipeUpView r16 = (ObricIconSwipeUpView) this.N.getValue();
        if (r16 == null) goto L71;
        e1.x(r16);
        return;
    L71:
        return;
    L70:
        return;
    L60:
        if (r15.isEnabled() != true) goto L62;
    L49:
        RecyclerView r17 = C3();
        if (r17 == null) goto L52;
        e1.x(r17);
    L52:
        p3().setClickable(true);
        goto L53
    L32:
        r9 = 1.0f;
        goto L33
    L19:
        if (s1a.a.e(this) == true) goto L30;
        laa.d r18 = d4();
        if (r18 == null) goto L27;
        ObricFloatChatPageState r19 = r18.getPageState();
        if (r19 == null) goto L27;
        ObricFloatChatPageData.Companion.getClass();
        if ((r19 instanceof vda.b) != true) goto L27;
        boolean r20 = true;
    L28:
        if (r20 == false) goto L30;
        return;
    L27:
        r20 = false;
        goto L28
    L9:
        if (r5.isWindowMode() != true) goto L11;
        r7 = true;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public final void onDestroy() {
        if (this.h1 == true) goto L5;
        return;
    L5:
        this.h1 = false;
        laa.d r0 = d4();
        if (r0 == null) goto L8;
        r0.AN(this);
    L8:
        com.larus.bmhome.instruction.g r1 = vc();
        if (r1 == null) goto L11;
        r1.LB(this);
    L11:
        c r2 = c4();
        if (r2 == null) goto L14;
        r2.p70(this.p0);
    L14:
        c r3 = c4();
        if (r3 == null) goto L17;
        r3.N40(this.H0);
    L17:
        CopyOnWriteArraySet r4 = com.obric.assistant.task.skill.f.a;
        d7 r5 = this.L0;
        Intrinsics.checkNotNullParameter(r5, "listener");
        com.obric.assistant.task.skill.f.a.remove(r5);
        ObricActionBarSendServiceExtDelegate r6 = ObricActionBarSendServiceExtDelegate.b;
        r6.h();
        r6.q();
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveCustomBarActionsState(this);
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveInteractionKeyguardLockedState(this);
        RecyclerView r7 = m3();
        if (r7 == null) goto L20;
        r7.removeOnItemTouchListener(this.k0);
    L20:
        RecyclerView r8 = m3();
        if (r8 == null) goto L23;
        r8.clearOnScrollListeners();
    L23:
        this.V = true;
    }

    public final void onResume() {
        if (this.h1 == true) goto L5;
        return;
    L5:
        p4();
    }

    public final TitleAvatarImageView p3() {
        return (TitleAvatarImageView) this.Z.getValue();
    }

    public final void rg() {
        FLogger.a.i("OrionExtraComponent", "ignoreShowImeOnce");
        this.R.set(true);
    }

    public final boolean uc() {
        View r0 = this.O;
        this.O = null;
        com.larus.bmhome.view.screenmenu.d r1 = com.larus.bmhome.view.screenmenu.d.a;
        boolean r2 = com.larus.bmhome.view.screenmenu.d.e(r0);
        FLogger.a.i("OrionExtraComponent", "dismissBalloon, showing=" + r2 + ", itemView=" + r0);
        if (r2 == false) goto L7;
        if (r0 == null) goto L9;
        com.larus.bmhome.view.screenmenu.d.b(r0);
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.u.getValue();
    }

    public final Pair<Long, String> y1() {
        com.larus.bmhome.chat.component.cvs.y r1 = z3();
        String r2 = null;
        if (r1 == null) goto L12;
        wc9.e r3 = r1.h();
        if (r3 == null) goto L12;
        String r4 = r3.a;
        if (r4 == null) goto L12;
        long r5 = CastLongProtector.parseLong(r4);     // Catch: Throwable -> L10
    L11:
        Long r6 = Long.valueOf(r5);
    L13:
        com.larus.bmhome.chat.component.cvs.y r7 = z3();
        if (r7 == null) goto L17;
        r2 = r7.getBotId();
    L17:
        return new Pair(r6, r2);
    L10:
        r5 = 0;
    L12:
        r6 = null;
        goto L13
    }

    public final boolean z0() {
        laa.j r0 = (laa.j) this.P.getValue();
        if (r0 == null) goto L9;
        b1 r1 = r0.O4();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final com.larus.bmhome.chat.component.cvs.y z3() {
        return (com.larus.bmhome.chat.component.cvs.y) this.p.getValue();
    }

    public final void B2() {
        if (s1a.a.e(this) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        FLogger.a.i("OrionExtraComponent", "onParentViewCreated: input-only host, skip full O page callbacks");
        return;
    L12:
        this.h1 = true;
        com.larus.bmhome.chat.component.cvs.y r1 = z3();
        if (r1 == null) goto L15;
        com.larus.bmhome.chat.component.cvs.y.b.b(r1, this);
    L15:
        laa.d r2 = d4();
        if (r2 == null) goto L18;
        r2.HU(this);
    L18:
        ObricActionBarSendServiceExtDelegate.b.j(this);
        com.larus.bmhome.instruction.g r3 = vc();
        if (r3 == null) goto L21;
        r3.QX(this);
    L21:
        c r4 = c4();
        if (r4 == null) goto L24;
        r4.hM(this.p0);
    L24:
        c r5 = c4();
        if (r5 == null) goto L27;
        r5.lR(this.H0);
    L27:
        CopyOnWriteArraySet r6 = com.obric.assistant.task.skill.f.a;
        com.obric.assistant.task.skill.f.a(this.L0);
        if (this.V0 == true) goto L31;
        this.V0 = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new observeSkillExtensionSetting.1(this, null), 3, null);
    L31:
        RecyclerView r7 = m3();
        if (r7 == null) goto L35;
        r7.addOnItemTouchListener(this.k0);
    L35:
        if (s1a.a.e(this) == false) goto L38;
        Y2("window_onParentViewCreated");
        IAssistantInteractionServiceKt.getInteractionStateService().observeCustomBarActionsState(this, new f6(this));
        IAssistantInteractionServiceKt.getInteractionStateService().observeInteractionKeyguardLockedState(this, new l6(this));
    L38:
        this.U = true;
        return;
    L5:
        if (d4() != null) goto L8;
        r0 = false;
        goto L9
    }

    public final RecyclerView C3() {
        va8.c r0 = G3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    public final ViewGroup H3() {
        b2 r0 = Q3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g();
    }

    public final void j4() {
        if (com.obric.assistant.task.skill.f.f() == false) goto L5;
    L15:
        this.V = false;
        if (com.obric.assistant.special_input.j.b() == false) goto L18;
        String r0 = "obric_omni_all_skills";
    L19:
        ObricActionBarTrackServiceExtDelegate.b.m(new String[]{"obric_quick_instruction", r0});
        return;
    L18:
        r0 = "obric_all_instruction";
        goto L19
    L5:
        if (this.V == true) goto L7;
        return;
    L7:
        if (com.obric.assistant.task.skill.f.d() == false) goto L22;
        laa.d r1 = d4();
        if (r1 != null) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == true) goto L15;
        return;
    L11:
        if (r1.isFullScreen() != true) goto L13;
        r2 = true;
        goto L14
    }

    public final RecyclerView m3() {
        va8.c r0 = G3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    public final void onStart() {
        if (s1a.a.e(this) == false) goto L6;
        IAssistantInteractionServiceKt.getInteractionStateService().observeCustomBarActionsState(this, new f6(this));
        Y2("window_onStart_before_dialog_show");
        return;
    L6:
        if (s1a.a.e(this) == true) goto L11;
        IAssistantInteractionServiceKt.getInteractionStateService().observeCustomBarActionsState(this, new t6(this));
        return;
    }

    public final void onStop() {
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveCustomBarActionsState(this);
    }

    public final void p4() {
        com.larus.bmhome.chat.component.cvs.y r0 = z3();
        if (r0 == null) goto L8;
        String r1 = r0.Y1();
        if (r1 == null) goto L8;
        boolean r2 = com.larus.bmhome.utils.i.g(r1);
    L9:
        if (r2 == true) goto L11;
        return;
    L11:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new onCustomObricActionChanges.1(this, null), 3, null);
        RecyclerView r3 = C3();
        if (r3 == null) goto L17;
        RecyclerView.Adapter r4 = r3.getAdapter();
        if (r4 == null) goto L18;
        r4.notifyDataSetChanged();
        return;
    L18:
        return;
    L17:
        return;
    L8:
        r2 = true;
        goto L9
    }

    public static boolean e4(z0 r3) {
        String r0 = null;
        if (r3 == null) goto L5;
        String r1 = r3.b;
    L7:
        if (Intrinsics.areEqual(r1, "obric_screen_qa") == true) goto L49;
        if (r3 == null) goto L10;
        String r2 = r3.b;
    L12:
        if (Intrinsics.areEqual(r2, "obric_document_perception") == true) goto L49;
        if (r3 == null) goto L15;
        String r4 = r3.b;
    L17:
        if (Intrinsics.areEqual(r4, "obric_web_perception") == true) goto L49;
        if (r3 == null) goto L20;
        String r5 = r3.b;
    L22:
        if (Intrinsics.areEqual(r5, "obric_video_perception") == true) goto L49;
        if (r3 == null) goto L25;
        String r6 = r3.b;
    L27:
        if (Intrinsics.areEqual(r6, "obric_photo_perception") == true) goto L49;
        if (r3 == null) goto L30;
        String r7 = r3.b;
    L32:
        if (Intrinsics.areEqual(r7, "obric_im_perception") == true) goto L49;
        if (r3 == null) goto L35;
        String r8 = r3.b;
    L37:
        if (Intrinsics.areEqual(r8, "obric_omni_all_skills") == true) goto L49;
        if (r3 == null) goto L40;
        String r9 = r3.b;
    L42:
        if (Intrinsics.areEqual(r9, "obric_all_instruction") == true) goto L49;
        if (r3 == null) goto L46;
        r0 = r3.b;
    L46:
        if (Intrinsics.areEqual(r0, "obric_quick_instruction") == true) goto L49;
        return false;
    L40:
        r9 = null;
        goto L42
    L35:
        r8 = null;
        goto L37
    L30:
        r7 = null;
        goto L32
    L25:
        r6 = null;
        goto L27
    L20:
        r5 = null;
        goto L22
    L15:
        r4 = null;
        goto L17
    L10:
        r2 = null;
    L49:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public static boolean i4(String r1) {
        if (Intrinsics.areEqual(r1, "obric_web_perception") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "obric_video_perception") == true) goto L8;
        return false;
    }

    public final void B4(String r8) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        Y2(r8);
        return;
    L6:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new refreshWindowCustomActionBarOnMain.1(this, r8, null), 3, null);
    }

    public final int E3(String r3) {
        boolean r0 = false;
        if (i4(r3) == true) goto L15;
        laa.d r4 = d4();
        if (r4 != null) goto L7;
    L9:
        if (r0 == false) goto L13;
        boolean r5 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L13;
        return 2131100491;
    L13:
        return 2131100493;
    L7:
        if (r4.aF() != true) goto L9;
        r0 = true;
        goto L9
    L15:
        laa.d r6 = d4();
        if (r6 != null) goto L18;
    L20:
        if (r0 == false) goto L22;
        return 2131103769;
    L22:
        return 2131103768;
    L18:
        if (r6.aF() != true) goto L20;
        r0 = true;
        goto L20
    }

    public final void F4(boolean r9) {
        if (H3() != null) goto L5;
        return;
    L5:
        b2 r0 = Q3();
        if (r0 == null) goto L59;
        ConstraintLayout r1 = r0.h();
        if (r1 == null) goto L62;
        b2 r2 = Q3();
        if (r2 == null) goto L60;
        SimpleDraweeView r3 = r2.k();
        if (r3 == null) goto L63;
        b2 r4 = Q3();
        if (r4 == null) goto L61;
        AppCompatTextView r5 = r4.e();
        if (r5 == null) goto L64;
        TextView r6 = (TextView) r1.findViewWithTag("obric_perception_panel_subtitle");
        if (r6 == null) goto L24;
        r1.removeView(r6);
    L24:
        if (r9 == false) goto L34;
        b2 r7 = Q3();
        if (r7 == null) goto L34;
        ConstraintLayout r8 = r7.c();
        if (r8 == null) goto L34;
        ViewGroup.LayoutParams r10 = r8.getLayoutParams();
        if (r10 == null) goto L33;
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) r10;
        ((ViewGroup.MarginLayoutParams) r11).height = v19.i5.h0();
        r8.setLayoutParams(r11);
        goto L34
    L33:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L34:
        ViewGroup.LayoutParams r12 = r1.getLayoutParams();
        if (r12 == null) goto L58;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12;
        ((ViewGroup.MarginLayoutParams) r13).width = -2;
        r13.endToStart = -1;
        r13.endToEnd = -1;
        r13.setMarginEnd(0);
        r1.setLayoutParams(r13);
        if (r9 == false) goto L47;
        b2 r14 = Q3();
        if (r14 == null) goto L47;
        AppCompatImageView r15 = r14.i();
        if (r15 == null) goto L47;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if (r16 == null) goto L46;
        ConstraintLayout.LayoutParams r17 = (ConstraintLayout.LayoutParams) r16;
        r17.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r17).topMargin = 0;
        r17.bottomToBottom = 0;
        r15.setLayoutParams(r17);
        goto L47
    L46:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L47:
        r5.setMaxLines(1);
        r5.setEllipsize(TextUtils.TruncateAt.END);
        ConstraintLayout.LayoutParams r18 = r3.getLayoutParams();
        if (r18 == null) goto L56;
        ConstraintLayout.LayoutParams r19 = r18;
        r19.topToTop = 0;
        r19.bottomToBottom = 0;
        r3.setLayoutParams(r19);
        ViewGroup.LayoutParams r20 = r5.getLayoutParams();
        if (r20 == null) goto L54;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
        ((ViewGroup.MarginLayoutParams) r21).width = -2;
        r21.startToEnd = r3.getId();
        r21.endToEnd = -1;
        r21.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r21).topMargin = 0;
        r21.bottomToTop = -1;
        r21.bottomToBottom = 0;
        r21.verticalChainStyle = 0;
        r5.setLayoutParams(r21);
        return;
    L54:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L56:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L58:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L64:
        return;
    L61:
        return;
    L63:
        return;
    L60:
        return;
    L62:
        return;
    }

    public final void S(String r2) {
        Intrinsics.checkNotNullParameter(r2, "hint");
        ICoreInputAbility r0 = B3();
        if (r0 == null) goto L6;
        r0.M5(r2);
        return;
    }

    public final void Y2(String r10) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L30
        List r4 = CollectionsKt.toMutableList(h3(x1.a.a()));     // Catch: Throwable -> L30
        int r3 = com.obric.assistant.task.skill.e.a;     // Catch: Throwable -> L30
        t1a.b r5 = s1a.d.a(this);     // Catch: Throwable -> L30
        Context r6 = getContext();     // Catch: Throwable -> L30
        Intrinsics.checkNotNullParameter(r5, "vContext");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullParameter(r6, "context");     // Catch: Throwable -> L30
        List r7 = CollectionsKt.listOf(new qha.j(r5, r6));     // Catch: Throwable -> L30
        r4.addAll(r7);     // Catch: Throwable -> L30
        if (s1a.d.a(this).a(de8.c.class) != null) goto L7;
        FLogger.a.i("OrionExtraComponent", "applyCustomObricActionChanges, chatArgumentData is null, reason=" + r10);     // Catch: Throwable -> L30
        return;
    L7:
        j1 r1 = (j1) this.W.getValue();     // Catch: Throwable -> L30
        if (r1 == null) goto L10;
        r1.b(false);     // Catch: Throwable -> L30
    L10:
        laa.b r8 = X3();     // Catch: Throwable -> L30
        if (r8 == null) goto L13;
        r8.Zw(CollectionsKt.minus(r4, CollectionsKt.toSet(r7)));     // Catch: Throwable -> L30
    L13:
        List r9 = r4;     // Catch: Throwable -> L30
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));     // Catch: Throwable -> L30
        Iterator r12 = r9.iterator();     // Catch: Throwable -> L30
    L15:
        if (r12.hasNext() == false) goto L17;
        r11.add(((qha.e) r12.next()).k());     // Catch: Throwable -> L30
        goto L15
    L17:
        Set r13 = CollectionsKt.toSet(r11);     // Catch: Throwable -> L30
        com.larus.bmhome.instruction.g r14 = vc();     // Catch: Throwable -> L30
        Unit r15 = null;
        if (r14 == null) goto L28;
        n6 r16 = new n6(r13);     // Catch: Throwable -> L30
        if (s1a.a.e(this) == false) goto L22;
        o6 r17 = new o6();     // Catch: Throwable -> L30
    L24:
        if (s1a.a.e(this) == false) goto L26;
        p6 r18 = new p6();     // Catch: Throwable -> L30
    L27:
        com.larus.bmhome.instruction.g.a.a(r14, r4, r16, r17, r18, 2);     // Catch: Throwable -> L30
        r15 = Unit.INSTANCE;     // Catch: Throwable -> L30
        goto L28
    L26:
        r18 = null;
        goto L27
    L22:
        r17 = null;
    L28:
        Object r19 = Result.constructor-impl(r15);     // Catch: Throwable -> L30
    L32:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L38;
        FLogger.a.e("OrionExtraComponent", "applyCustomObricActionChanges error, reason=" + r10, r20);
        return;
    L38:
        return;
    L30:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }

    public final void c(Object r9) {
        wc9.e r10 = (wc9.e) r9;
        Intrinsics.checkNotNullParameter(r10, "new");
        if (ic8.n.v(r10) == false) goto L31;
        IconImage r0 = r10.b;
        if (r0 == null) goto L10;
        ImageObj r1 = r0.imageThumb;
        if (r1 == null) goto L10;
        String r2 = r1.url;
    L11:
        String r3 = "";
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        if (r2.length() != 0) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L29;
        IconImage r11 = r10.b;
        if (r11 == null) goto L24;
        ImageObj r12 = r11.imageOri;
        if (r12 == null) goto L24;
        String r13 = r12.url;
    L25:
        if (r13 == null) goto L28;
        r3 = r13;
    L28:
        r2 = r3;
    L24:
        r13 = null;
    L29:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new setAvatar.1(this, r2, null), 2, null);
        return;
    L17:
        r4 = false;
    L10:
        r2 = null;
        goto L11
    }

    public final void g8(int r2) {
        laa.d r0 = d4();
        if (r0 == null) goto L6;
        r0.g8(r2);
        return;
    }

    public final List h3(boolean r6) {
        if (r6 == true) goto L4;
        boolean r0 = true;
        if (s1a.a.e(this) == true) goto L23;
        laa.d r7 = d4();
        if (r7 != null) goto L10;
    L12:
        boolean r8 = false;
    L13:
        if (r8 == true) goto L23;
        laa.d r9 = d4();
        if (r9 != null) goto L17;
    L19:
        boolean r10 = false;
    L20:
        if (r10 == true) goto L23;
        r0 = false;
        goto L23
    L17:
        if (r9.Xh() != true) goto L19;
        r10 = true;
        goto L20
    L10:
        if (r7.aF() != true) goto L12;
        r8 = true;
    L23:
        if (r0 == true) goto L27;
        return CollectionsKt.emptyList();
    L27:
        if (IAssistantInteractionServiceKt.getInteractionStateService().getInteractionKeyguardLockedState() == KeyguardLockedState.LOCKED) goto L29;
        ArrayList<CustomBarAction> r11 = IAssistantInteractionServiceKt.getInteractionStateService().getCustomBarActions();
        ArrayList r1 = new ArrayList();
        Iterator<T> r12 = r11.iterator();
    L32:
        if (r12.hasNext() == false) goto L61;
        CustomBarAction r2 = (CustomBarAction) r12.next();
        String r3 = r2.getUri();
        String r4 = r2.getKey();
        switch(r4.hashCode()) {
            case 241623133: goto L56;
            case 295367523: goto L49;
            case 596623375: goto L45;
            case 780021240: goto L41;
            case 1890683158: goto L37;
            default: goto L58;
        };
    L58:
        qha.s r5 = null;
    L59:
        if (r5 == null) goto L32;
        r1.add(r5);
        goto L32
    L37:
        if (r4.equals("obric_web_perception") == false) goto L58;
        r5 = new qha.s(s1a.d.a(this), getContext(), r3);
        goto L59
    L41:
        if (r4.equals("obric_photo_perception") == false) goto L58;
        r5 = new qha.p(s1a.d.a(this), getContext(), r3);
        goto L59
    L45:
        if (r4.equals("obric_video_perception") == false) goto L58;
        r5 = new qha.r(s1a.d.a(this), getContext(), r3);
        goto L59
    L49:
        if (r4.equals("obric_document_perception") == false) goto L58;
        laa.h r13 = a4();
        if (r13 == null) goto L54;
        r13.hK(r2.getFileSize());
    L54:
        r5 = new qha.h(s1a.d.a(this), getContext(), r3);
        goto L59
    L56:
        if (r4.equals("obric_screen_qa") == false) goto L58;
        r5 = new qha.q(s1a.d.a(this), getContext(), r3);
        goto L59
    L61:
        return r1;
    L29:
        return CollectionsKt.emptyList();
    L4:
        return CollectionsKt.emptyList();
    }

    public final boolean k60(String r7) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (i4(r7) == false) goto L41;
        String r1 = null;
        G4(r7, null);
        boolean r2 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L21;
        if (Intrinsics.areEqual(r7, "obric_web_perception") == false) goto L13;
        Integer r3 = 2131244374;
    L16:
        if (r3 == null) goto L21;
        int r4 = r3.intValue();
        b2 r5 = Q3();
        if (r5 == null) goto L21;
        r5.b(y0.k(UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + '/' + r4)), null);
        goto L21
    L13:
        if (Intrinsics.areEqual(r7, "obric_video_perception") == false) goto L15;
        r3 = 2131244372;
        goto L16
    L15:
        r3 = null;
    L21:
        if (i4(r7) == false) goto L41;
        if (Intrinsics.areEqual(this.n, r7) == true) goto L41;
        this.n = r7;
        ObricActionBarTrackServiceExtDelegate r6 = ObricActionBarTrackServiceExtDelegate.b;
        com.larus.bmhome.chat.component.cvs.y r8 = z3();
        if (r8 == null) goto L29;
        r1 = r8.getBotId();
    L29:
        if (r1 != null) goto L31;
        r1 = "";
    L31:
        com.larus.bmhome.chat.component.cvs.y r9 = z3();
        long r10 = 0;
        if (r9 == null) goto L39;
        wc9.e r11 = r9.h();
        if (r11 == null) goto L39;
        String r12 = r11.a;
        if (r12 == null) goto L39;
        r10 = CastLongProtector.parseLong(r12);     // Catch: Throwable -> L59
    L39:
        r6.s(r7, r1, r10);
    L41:
        if (i4(r7) == false) goto L43;
    L57:
        return true;
    L43:
        if (Intrinsics.areEqual(r7, "obric_oauto") == false) goto L62;
        laa.j r13 = (laa.j) this.D.getValue();
        if (r13 == null) goto L55;
        b1 r14 = r13.i80();
        if (r14 == null) goto L55;
        laa.v r15 = (laa.v) r14.getValue();
        if (r15 == null) goto L55;
        StateInfo r16 = r15.b;
        if (r16 == null) goto L55;
        if (r16.getRequestType() != 0) goto L55;
        boolean r17 = true;
    L56:
        if (r17 == true) goto L57;
        return false;
    L55:
        r17 = false;
        goto L56
    L62:
        return false;
    }

    public final void q4(String r7) {
        FLogger.a.i("OrionExtraComponent", "refreshPhoneOperationActionBar, reason=" + r7);
        laa.b r8 = X3();
        if (r8 == null) goto L8;
        List r9 = r8.i30();
        if (r9 == null) goto L8;
        List r10 = CollectionsKt.toMutableList(r9);
        if (r10 == null) goto L8;
    L9:
        List r1 = r10;
        int r11 = com.obric.assistant.task.skill.e.a;
        t1a.b r12 = s1a.d.a(this);
        Context r0 = getContext();
        Intrinsics.checkNotNullParameter(r12, "vContext");
        Intrinsics.checkNotNullParameter(r0, "context");
        List r13 = CollectionsKt.listOf(new qha.j(r12, r0));
        CollectionsKt.removeAll(r1, new r6());
        r1.addAll(r13);
        laa.b r14 = X3();
        if (r14 == null) goto L12;
        r14.Zw(r1);
    L12:
        com.larus.bmhome.instruction.g r2 = vc();
        if (r2 == null) goto L16;
        com.larus.bmhome.instruction.g.a.a(r2, r1, new s6(r1), null, null, 26);
        return;
    L16:
        return;
    L8:
        r10 = new ArrayList();
        goto L9
    }

    public final void r2(boolean r10) {
        p4();
        ConstraintLayout.LayoutParams r0 = null;
        boolean r1 = false;
        if (r10 == true) goto L5;
        laa.d r2 = d4();
        if (r2 == null) goto L24;
        ObricFloatChatPageState r3 = r2.getPageState();
    L25:
        ObricFloatChatPageData.Companion.getClass();
        boolean r4 = r3 instanceof vda.d;
        if (r4 == false) goto L28;
    L29:
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveCustomBarActionsState(this);
    L30:
        if (r4 == false) goto L35;
        if (s1a.a.e(this) == true) goto L35;
        j4();
    L35:
        if ((r3 instanceof vda.e) == false) goto L40;
        FLogger.a.i("OrionExtraComponent", "onChatStyleChanged is half window, checkIsMobActionBarShow");
        if (this.U == false) goto L39;
        this.U = false;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new checkIsMobActionBarShow.1(this, null), 3, null);
    L39:
        j4();
    L40:
        com.larus.bmhome.chat.component.bottom.core.speaker.m r5 = (com.larus.bmhome.chat.component.bottom.core.speaker.m) this.t.getValue();
        if (r5 == null) goto L43;
        r5.T3(this.X);
    L43:
        laa.f r6 = (laa.f) this.B.getValue();
        if (r6 == null) goto L46;
        r6.T3(this.Y);
    L46:
        i6 r7 = this.Y;
        laa.f r8 = (laa.f) this.B.getValue();
        if (r8 != null) goto L49;
    L51:
        boolean r9 = false;
    L52:
        r7.invoke(Boolean.valueOf(r9));
        RecyclerView r11 = C3();
        if (r11 == null) goto L60;
        r11.setFadingEdgeLength(v19.i5.d0());
        if (s1a.a.e(this) == true) goto L57;
        if (r10 == true) goto L57;
    L58:
        r11.setHorizontalFadingEdgeEnabled(r1);
        return;
    L57:
        r1 = true;
        goto L58
    L60:
        return;
    L49:
        if (r8.kT() != true) goto L51;
        r9 = true;
        goto L52
    L28:
        if ((r3 instanceof vda.f) == false) goto L30;
    L24:
        r3 = null;
        goto L25
    L5:
        if ((p3().getParent() instanceof ViewGroup) == false) goto L8;
        ViewParent r12 = p3().getParent();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r12).removeView(p3());
    L8:
        if (s1a.a.e(this) == true) goto L20;
        RecyclerView r13 = C3();
        if (r13 == null) goto L12;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
    L14:
        if ((r14 instanceof ConstraintLayout.LayoutParams) == false) goto L16;
        r0 = (ConstraintLayout.LayoutParams) r14;
    L16:
        if (r0 == null) goto L20;
        ((ViewGroup.MarginLayoutParams) r0).width = 0;
        r0.endToEnd = 0;
        r0.topToTop = 0;
        r0.bottomToBottom = 0;
        r0.startToStart = 0;
        RecyclerView r15 = C3();
        if (r15 == null) goto L20;
        r15.setLayoutParams(r0);
        goto L20
    L12:
        r14 = null;
    L20:
        e1.d(p3(), new m6(this));
        goto L40
    }

    public final void v4(String r8) {
        if (com.obric.assistant.task.skill.f.d() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
        q4(r8);
        return;
    L9:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new refreshPhoneOperationActionBarOnMain.1(this, r8, null), 3, null);
    }

    public final void x1(ObricFloatChatPageState r2) {
        Intrinsics.checkNotNullParameter(r2, "pageState");
        ObricFloatChatPageData.Companion.getClass();
        if ((r2 instanceof vda.b) == false) goto L8;
        laa.h r0 = a4();
        if (r0 == null) goto L8;
        r0.X30();
    L8:
        if ((r2 instanceof vda.d) == false) goto L10;
    L13:
        f1 r3 = (f1) this.G.getValue();
        if (r3 != null) goto L16;
        return;
    L16:
        if (r3.sL() == true) goto L18;
        return;
    L18:
        if (s1a.a.e(this) == true) goto L26;
        f1 r4 = (f1) this.G.getValue();
        if (r4 == null) goto L27;
        r4.hP(true);
        return;
    L27:
        return;
    L26:
        return;
    L10:
        if ((r2 instanceof vda.f) == true) goto L13;
        if ((r2 instanceof vda.e) == true) goto L13;
    }

    public final void yh(String r3) {
        Intrinsics.checkNotNullParameter(r3, "inputContent");
        if (o0.d(StringsKt.trim(r3).toString()) == false) goto L8;
        ICoreInputAbility r4 = B3();
        if (r4 == null) goto L9;
        r4.g2(3, true);
        return;
    L9:
        return;
    }

    public static void R4(z0 r1, String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L23;
        com.larus.bmhome.actionbar.model.r r3 = r1.q;
        if (r3 == null) goto L17;
        h1 r4 = r3.c;
        if (r4 == null) goto L17;
        r4.b = r2;
    L17:
        h1 r5 = r1.k;
        if (r5 == null) goto L22;
        r5.b = r2;
        return;
    L22:
        return;
    L23:
        return;
    L6:
        r0 = false;
        goto L7
    }

    public static String V3(String r4, z0 r5) {
        if (i4(r4) == true) goto L5;
        return null;
    L5:
        Iterator<T> r0 = IAssistantInteractionServiceKt.getInteractionStateService().getCustomBarActions().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        Object r2 = r0.next();
        if (Intrinsics.areEqual(((CustomBarAction) r2).getKey(), r4) == false) goto L7;
    L12:
        CustomBarAction r3 = (CustomBarAction) r2;
        boolean r6 = false;
        if (r3 == null) goto L22;
        String r7 = r3.getUri();
        if (r7 == null) goto L22;
        if (r7.length() <= 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L22;
    L23:
        if (r7 != null) goto L33;
        if (r5 == null) goto L37;
        String r9 = qha.f.a(r5);
        if (r9 != null) goto L28;
        return null;
    L28:
        if (r9.length() <= 0) goto L30;
        r6 = true;
    L30:
        if (r6 == true) goto L40;
        return null;
    L40:
        return r9;
    L37:
        return null;
    L33:
        return r7;
    L19:
        r8 = false;
    L22:
        r7 = null;
        goto L23
    L11:
        r2 = null;
        goto L12
    }

    public static boolean h4(z0 r3, ReplyOption r4) {
        p0 r5 = r3.o;
        if (r5 == null) goto L10;
        Integer r6 = r5.a;
        int r2 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r6 == null) goto L10;
        if (r6.intValue() != r2) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == true) goto L13;
        return false;
    L13:
        if (com.obric.assistant.task.skill.n.b(r4) == false) goto L17;
        return true;
    L17:
        return false;
    L10:
        r7 = false;
        goto L11
    }

    public static boolean k4(z0 r1, View r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundConstraintLayout");
        RoundConstraintLayout r3 = (RoundConstraintLayout) r2;
        if (Intrinsics.areEqual(r1.b, "obric_photo_perception") == false) goto L5;
    L9:
        return true;
    L5:
        if (Intrinsics.areEqual(r1.b, "obric_screen_qa") == true) goto L9;
        if (Intrinsics.areEqual(r1.b, "obric_im_perception") == true) goto L9;
        return false;
    }

    public final void F(String r1, List<com.larus.bmhome.actionbar.model.b2> r2) {
        Intrinsics.checkNotNullParameter(r2, "menuItems");
    }

    public final void G4(String r11, Integer r12) {
        com.larus.bmhome.instruction.g r0 = vc();
        Boolean r1 = null;
        if (r0 == null) goto L5;
        z0 r2 = r0.yF();
    L6:
        boolean r3 = false;
        if (i4(r11) == false) goto L93;
        String r13 = V3(r11, r2);
        if (r2 == null) goto L12;
        R4(r2, r13);
    L12:
        if (H3() == null) goto L74;
        b2 r4 = Q3();
        if (r4 == null) goto L74;
        ConstraintLayout r5 = r4.h();
        if (r5 == null) goto L74;
        b2 r6 = Q3();
        if (r6 == null) goto L74;
        SimpleDraweeView r7 = r6.k();
        if (r7 == null) goto L74;
        b2 r8 = Q3();
        if (r8 == null) goto L74;
        AppCompatImageView r9 = r8.i();
        if (r9 == null) goto L74;
        b2 r10 = Q3();
        if (r10 == null) goto L74;
        AppCompatTextView r14 = r10.e();
        if (r14 == null) goto L74;
        TextView r15 = (TextView) r5.findViewWithTag("obric_perception_panel_subtitle");
        if (r15 != null) goto L38;
        r15 = new TextView(r5.getContext());
        r15.setId(View.generateViewId());
        r15.setTag("obric_perception_panel_subtitle");
        r15.setMaxLines(1);
        r15.setEllipsize(TextUtils.TruncateAt.END);
        r15.setTextColor(ContextCompat.getColor(r15.getContext(), 2131103143));
        r15.setTextSize(0, v19.i5.h());
        r15.setIncludeFontPadding(false);
        r5.addView(r15, new ConstraintLayout.LayoutParams(0, -2));
    L38:
        if (Intrinsics.areEqual(r11, "obric_video_perception") == false) goto L40;
        String r16 = getContext().getString(2131911933);
    L41:
        r14.setText(r16);
        if (r13 != null) goto L44;
        r13 = "";
    L44:
        r15.setText(r13);
        b2 r17 = Q3();
        if (r17 == null) goto L53;
        ConstraintLayout r18 = r17.c();
        if (r18 == null) goto L53;
        ViewGroup.LayoutParams r19 = r18.getLayoutParams();
        if (r19 == null) goto L52;
        ConstraintLayout.LayoutParams r20 = (ConstraintLayout.LayoutParams) r19;
        ((ViewGroup.MarginLayoutParams) r20).height = v19.i5.l0();
        r18.setLayoutParams(r20);
        goto L53
    L52:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L53:
        ViewGroup.LayoutParams r110 = r5.getLayoutParams();
        if (r110 == null) goto L73;
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r110;
        ((ViewGroup.MarginLayoutParams) r111).width = 0;
        r111.endToStart = r9.getId();
        r111.endToEnd = -1;
        r111.setMarginEnd(v19.i5.r0());
        r5.setLayoutParams(r111);
        ViewGroup.LayoutParams r112 = r9.getLayoutParams();
        if (r112 == null) goto L71;
        ConstraintLayout.LayoutParams r113 = (ConstraintLayout.LayoutParams) r112;
        r113.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r113).topMargin = v19.i5.q();
        r113.bottomToBottom = -1;
        r9.setLayoutParams(r113);
        ConstraintLayout.LayoutParams r114 = r7.getLayoutParams();
        if (r114 == null) goto L69;
        ConstraintLayout.LayoutParams r115 = r114;
        r115.topToTop = r14.getId();
        r115.bottomToBottom = r14.getId();
        r7.setLayoutParams(r115);
        ViewGroup.LayoutParams r116 = r14.getLayoutParams();
        if (r116 == null) goto L67;
        ConstraintLayout.LayoutParams r117 = (ConstraintLayout.LayoutParams) r116;
        ((ViewGroup.MarginLayoutParams) r117).width = 0;
        r117.startToEnd = r7.getId();
        r117.endToEnd = 0;
        r117.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) r117).topMargin = v19.i5.q();
        r117.bottomToTop = -1;
        r117.bottomToBottom = -1;
        r117.verticalChainStyle = 0;
        r14.setLayoutParams(r117);
        ViewGroup.LayoutParams r118 = r15.getLayoutParams();
        if (r118 == null) goto L65;
        ConstraintLayout.LayoutParams r119 = (ConstraintLayout.LayoutParams) r118;
        ((ViewGroup.MarginLayoutParams) r119).width = 0;
        r119.startToStart = r7.getId();
        r119.endToEnd = 0;
        r119.topToBottom = r14.getId();
        r119.bottomToBottom = 0;
        ((ViewGroup.MarginLayoutParams) r119).bottomMargin = v19.i5.h();
        r119.verticalBias = 1.0f;
        r15.setLayoutParams(r119);
        goto L74
    L65:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L67:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L69:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L71:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L73:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L40:
        r16 = getContext().getString(2131911934);
    L74:
        ada.c r120 = Z3();
        if (r120 == null) goto L77;
        r120.K50();
    L77:
        ada.c r121 = Z3();
        if (r121 == null) goto L80;
        r121.Ep();
    L80:
        ICoreInputAbility r122 = B3();
        if (r122 == null) goto L83;
        r122.p80(false);
    L83:
        ICoreInputAbility r123 = B3();
        if (r123 == null) goto L86;
        r123.qp(false);
    L86:
        ICoreInputAbility r124 = B3();
        if (r124 == null) goto L89;
        r124.g2(2, false);
    L89:
        ViewGroup r125 = H3();
        if (r125 == null) goto L122;
        r125.post(new k6(this));
        return;
    L122:
        return;
    L93:
        if (s1a.a.e(this) == true) goto L111;
        ViewGroup r21 = H3();
        if (r21 == null) goto L98;
        Drawable r22 = r21.getBackground();
    L100:
        if ((r22 instanceof GradientDrawable) == false) goto L102;
        GradientDrawable r23 = (GradientDrawable) r22;
    L103:
        if (r23 == null) goto L105;
        r23.setColor(ContextCompat.getColor(getContext(), E3(r11)));
        goto L111
    L105:
        FLogger r24 = FLogger.a;
        StringBuilder r25 = new StringBuilder("setInputEditorBackground: not found instructionEditorContainer, isChatWindow = ");
        laa.d r26 = d4();
        if (r26 == null) goto L108;
        r1 = Boolean.valueOf(r26.aF());
    L108:
        r25.append(r1);
        r24.w("OrionExtraComponent", r25.toString());
        float[] r27 = {v19.i5.q(), v19.i5.q(), v19.i5.q(), v19.i5.q(), 0.0f, 0.0f, 0.0f, 0.0f};
        int r126 = ContextCompat.getColor(getContext(), E3(r11));
        GradientDrawable r28 = new GradientDrawable();
        r28.setShape(0);
        r28.setCornerRadii(r27);
        r28.setColor(r126);
        ViewGroup r127 = H3();
        if (r127 == null) goto L111;
        r127.setBackground(r28);
        goto L111
    L102:
        r23 = null;
        goto L103
    L98:
        r22 = null;
    L111:
        if (r12 != null) goto L114;
    L117:
        r3 = true;
    L118:
        F4(r3);
        ada.c r128 = Z3();
        if (r128 == null) goto L124;
        r128.jr();
        return;
    L124:
        return;
    L114:
        if (r12.intValue() != 5) goto L117;
        if (AppHost.a.isOversea() == false) goto L118;
    L5:
        r2 = null;
        goto L6
    }

    public final void Pp(String r9, boolean r10) {
        List r0 = null;
        if (r10 == false) goto L9;
        FLogger.a.i("OrionExtraComponent", "mobAssistantActionBarShow, isFromInteractionSession after notify AiKey short press");
        if (this.U == false) goto L7;
        this.U = false;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new checkIsMobActionBarShow.1(this, null), 3, null);
    L7:
        j4();
        return;
    L9:
        if (r9 == null) goto L29;
        ObricActionBarTrackServiceExtDelegate r11 = ObricActionBarTrackServiceExtDelegate.b;
        if (r11.a(r9) == false) goto L29;
        ObricInteractDelegate r12 = ObricInteractDelegate.b;
        Boolean r3 = r12.isAiKeyPressing();
        Boolean r4 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r4) == false) goto L16;
    L27:
        FLogger.a.i("OrionExtraComponent", "mobAssistantActionBarShow, is ai key pressing");
        return;
    L16:
        if (Intrinsics.areEqual(r12.isAiKeyLongPress(), r4) == true) goto L27;
        if (Intrinsics.areEqual(r12.isAiKeyShortPress(), r4) == true) goto L27;
        if (this.U == false) goto L31;
        this.U = false;
        laa.b r13 = X3();
        if (r13 == null) goto L25;
        r0 = r13.i30();
    L25:
        r11.b(r0);
        return;
    L31:
        return;
    L29:
        FLogger.a.i("OrionExtraComponent", "mobAssistantActionBarShow, actionBarKey is null or not assistant action bar");
    }

    public final void j00(float r5, boolean r6) {
        if (s1a.a.d(this) == false) goto L6;
        FLogger.a.i("OrionExtraComponent", "resetActionBar isLandscapeFullWindow");
        return;
    L6:
        com.larus.bmhome.chat.component.bottom.core.speaker.m r0 = (com.larus.bmhome.chat.component.bottom.core.speaker.m) this.t.getValue();
        if (r0 == null) goto L9;
        r0.MC(!r6);
    L9:
        float r7 = this.m;
        boolean r1 = false;
        if (r7 != 0.0f) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
    L19:
        if (r7 != 0.0f) goto L21;
        boolean r8 = true;
    L22:
        if (r8 == true) goto L24;
    L33:
        this.m = r5;
        StateFlowImpl r9 = waa.a.c;
        if (Math.abs(r5 - 0.0f) >= 1.0E-6f) goto L36;
        r1 = true;
    L36:
        r9.setValue(Boolean.valueOf(!r1));
        return;
    L24:
        if (r5 != 0.0f) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == true) goto L33;
    L28:
        this.m = r5;
        RecyclerView r11 = m3();
        if (r11 == null) goto L33;
        RecyclerView.Adapter r12 = r11.getAdapter();
        if (r12 == null) goto L33;
        r12.notifyDataSetChanged();
        goto L33
    L26:
        r10 = false;
        goto L27
    L21:
        r8 = false;
        goto L22
    L15:
        if (r5 != 0.0f) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == true) goto L28;
    L17:
        r4 = false;
        goto L18
    L12:
        r3 = false;
        goto L13
    }

    public final void l0(z0 r24, View r25) {
        View r1 = r25;
        Intrinsics.checkNotNullParameter(r24, "item");
        if (t0.a(this) == true) goto L9;
        if (s1a.a.e(this) == true) goto L9;
        FLogger.a.i("OrionExtraComponent", "onActionBarItemClick: not top chat page");
        return;
    L9:
        if (r1 == null) goto L11;
        Context r2 = r25.getContext();
    L13:
        if (Intrinsics.areEqual(r2, getContext()) == true) goto L16;
        FLogger.a.i("OrionExtraComponent", "onActionBarItemClick: itemView context not match");
        return;
    L16:
        String r3 = r24.b;
        boolean r12 = true;
        if (r3 != null) goto L19;
    L160:
        Map r4 = r24.H;
        if (r4 == null) goto L163;
        String r5 = (String) r4.get("skill_id");
    L164:
        int r6 = com.obric.assistant.task.skill.d.a;
        if (com.obric.assistant.task.skill.d.a(r24.b) == false) goto L176;
        if (r5 != null) goto L168;
    L171:
        boolean r7 = true;
    L172:
        if (r7 == true) goto L176;
        c r8 = c4();
        if (r8 == null) goto L176;
        r8.Dd(r5);
        goto L176
    L168:
        if (StringsKt.isBlank(r5) == true) goto L171;
        r7 = false;
    L176:
        Integer r9 = r24.g;
        int r10 = ActionBarExecutionType.SWITCH_STATUS.getValue();
        if (r9 == null) goto L182;
        if (r9.intValue() != r10) goto L182;
    L188:
        r12 = false;
    L189:
        if (r12 == false) goto L202;
        com.obric.audio.continuous_talk.c r11 = (com.obric.audio.continuous_talk.c) this.A.getValue();
        if (r11 == null) goto L193;
        com.obric.audio.continuous_talk.c.a.a(r11, null, null, false, true, 7);
    L193:
        Intrinsics.areEqual(r24.b, "obric_omni");
        maa.e r13 = (maa.e) this.z.getValue();
        if (r13 == null) goto L203;
        maa.e.a.a(r13, null, null, false, 7);
        return;
    L203:
        return;
    L202:
        return;
    L182:
        if (Intrinsics.areEqual(r24.b, "obric_screen_qa") == true) goto L188;
        if (Intrinsics.areEqual(r24.b, "obric_document_perception") == true) goto L188;
        if (Intrinsics.areEqual(r24.b, "obric_oauto") == true) goto L188;
    L163:
        r5 = null;
        goto L164
    L19:
        switch(r3.hashCode()) {
            case -1832688838: goto L152;
            case -1596197216: goto L94;
            case -761162256: goto L88;
            case 241623133: goto L76;
            case 295367523: goto L58;
            case 548295946: goto L52;
            case 596623375: goto L43;
            case 780021240: goto L37;
            case 1196019926: goto L31;
            case 1890683158: goto L22;
            default: goto L160;
        };
    L22:
        if (r3.equals("obric_web_perception") == false) goto L160;
        laa.d r14 = d4();
        if (r14 == null) goto L27;
        r14.C1(false, false, "web_perceive");
    L27:
        String r15 = V3("obric_web_perception", r24);
        R4(r24, r15);
        Uri r16 = y0.j(r15);
        com.larus.bmhome.chat.component.bottom.multimodal.g r17 = W3();
        if (r17 == null) goto L176;
        r17.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.a(r16, null, 2)), new g1(false, MultimodalBizScene.ObricSpecialType, false), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method_trace", "obric_web_perception"), TuplesKt.to("is_from_obric_action_bar", "obric_web_perception")}), null, 20));
        goto L176
    L31:
        if (r3.equals("obric_quick_instruction") == false) goto L160;
        laa.h r18 = a4();
        if (r18 == null) goto L176;
        r18.Hh(r1, r24);
        goto L176
    L37:
        if (r3.equals("obric_photo_perception") == false) goto L160;
        laa.h r19 = a4();
        if (r19 == null) goto L176;
        r19.zw(r24);
        goto L176
    L43:
        if (r3.equals("obric_video_perception") == false) goto L160;
        laa.d r20 = d4();
        if (r20 == null) goto L48;
        r20.C1(false, false, "video_perceive");
    L48:
        String r21 = V3("obric_video_perception", r24);
        R4(r24, r21);
        Uri r22 = y0.j(r21);
        com.larus.bmhome.chat.component.bottom.multimodal.g r23 = W3();
        if (r23 == null) goto L176;
        r23.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.a(r22, null, 2)), new g1(false, MultimodalBizScene.ObricSpecialType, false), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method_trace", "obric_video_perception"), TuplesKt.to("is_from_obric_action_bar", "obric_video_perception")}), null, 20));
        goto L176
    L52:
        if (r3.equals("obric_all_instruction") == false) goto L160;
        laa.h r26 = a4();
        if (r26 == null) goto L176;
        r26.hx();
        goto L176
    L58:
        if (r3.equals("obric_document_perception") == false) goto L160;
        laa.h r27 = a4();
        if (r27 != null) goto L63;
    L65:
        boolean r28 = false;
    L66:
        if (r28 == false) goto L69;
        t19.s r29 = t19.s.a;
        AppHost.Companion r30 = AppHost.a;
        Application r31 = r30.getApplication();
        String r32 = r30.getApplication().getString(2131907893, new Object[]{"100MB"});
        r29.getClass();
        t19.s.t(r31, r32);
        return;
    L69:
        laa.d r33 = d4();
        if (r33 == null) goto L72;
        r33.C1(false, false, "file_perceive");
    L72:
        Uri r34 = y0.j(qha.f.a(r24));
        com.larus.bmhome.chat.component.bottom.multimodal.g r35 = W3();
        if (r35 == null) goto L176;
        r35.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.a(r34, null, 2)), new g1(true, MultimodalBizScene.InstructionDocumentRead, false), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method_trace", "obric_document_perception"), TuplesKt.to("is_from_obric_action_bar", "obric_document_perception")}), null, 20));
        goto L176
    L63:
        if (r27.Vf() != true) goto L65;
        r28 = true;
        goto L66
    L76:
        if (r3.equals("obric_screen_qa") == false) goto L160;
        u6 r36 = new u6(this);
        if (t1.a.I1() == false) goto L81;
        r36.invoke();
        goto L176
    L81:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r37 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r37 != null) goto L84;
        FLogger.a.w("OrionExtraComponent", "ensureReferenceScreenContentEnabled: activity is null");
        goto L176
    L84:
        int r38 = ReferenceScreenContentConfirmFragment.f;
        MutableLiveData r39 = ReferenceScreenContentConfirmFragment.a.a(r37);
        if (r39 == null) goto L176;
        r39.observe(this, new k7(new z6(r37, r36)));
        goto L176
    L88:
        if (r3.equals("obric_phone_operation") == false) goto L160;
        laa.h r40 = a4();
        if (r40 == null) goto L176;
        r40.Hh(r1, r24);
        goto L176
    L94:
        if (r3.equals("obric_omni_all_skills") == false) goto L160;
        if (com.obric.assistant.special_input.j.b() == false) goto L111;
        t1 r41 = t1.a;
        if (r41.c0() == false) goto L111;
        if (r41.G0() == true) goto L111;
        if (System.currentTimeMillis() >= r41.Z0()) goto L111;
        r41.c1(true);
        laa.b r42 = X3();
        if (r42 == null) goto L111;
        r42.dI();
    L111:
        ObricActionBarTrackServiceExtDelegate r43 = ObricActionBarTrackServiceExtDelegate.b;
        ObricActionBarTrackType r44 = ObricActionBarTrackType.OBRIC_OMNI_ALL_SKILLS;
        com.larus.bmhome.chat.component.cvs.y r45 = z3();
        if (r45 == null) goto L114;
        String r46 = r45.getBotId();
    L115:
        com.larus.bmhome.chat.component.cvs.y r47 = z3();
        long r48 = 0;
        if (r47 == null) goto L124;
        wc9.e r49 = r47.h();
        if (r49 == null) goto L124;
        String r50 = r49.a;
        if (r50 == null) goto L124;
        r48 = CastLongProtector.parseLong(r50);     // Catch: Throwable -> L123
    L124:
        long r51 = r48;
        if (r1 == null) goto L144;
        RecyclerView r52 = r25.getParent();
    L128:
        if (r52 == null) goto L144;
        if ((r52 instanceof RecyclerView) == true) goto L131;
        if ((r52 instanceof View) == false) goto L140;
        r1 = (View) r52;
    L141:
        if (r1 == null) goto L144;
        r52 = r1.getParent();
        goto L128
    L140:
        r1 = null;
        goto L141
    L131:
        Integer r53 = Integer.valueOf(r52.getChildAdapterPosition(r1));
        if (r53.intValue() == (-1)) goto L134;
        boolean r54 = true;
    L135:
        if (r54 == false) goto L144;
    L145:
        if (r53 == null) goto L147;
        int r55 = r53.intValue();
    L148:
        IObricActionBarTrackServiceExt.a.a(r43, null, r44, r24, r46, r51, Integer.valueOf(r55), 1);
        c r56 = c4();
        if (r56 == null) goto L176;
        r56.px();
        goto L176
    L147:
        r55 = 1;
        goto L148
    L134:
        r54 = false;
    L144:
        r53 = null;
        goto L145
    L114:
        r46 = null;
        goto L115
    L152:
        if (r3.equals("obric_im_perception") == false) goto L160;
        laa.d r57 = d4();
        if (r57 == null) goto L157;
        r57.C1(false, false, "im_perceive");
    L157:
        Uri r58 = y0.j(qha.f.a(r24));
        com.larus.bmhome.chat.component.bottom.multimodal.g r59 = W3();
        if (r59 == null) goto L176;
        r59.gx(new com.larus.bmhome.chat.component.bottom.multimodal.n(CollectionsKt.listOf(new com.larus.bmhome.chat.component.bottom.multimodal.a.a(r58, null, 2)), new g1(true, MultimodalBizScene.ObricSpecialType, false), null, MapsKt.mapOf(new Pair[]{TuplesKt.to("enter_method_trace", "obric_im_perception"), TuplesKt.to("is_from_obric_action_bar", "obric_im_perception")}), null, 20));
        goto L176
    L11:
        r2 = null;
        goto L13
    }

    public final void w1(z0 r2, ReplyOption r3) {
        Intrinsics.checkNotNullParameter(r2, "item");
        Intrinsics.checkNotNullParameter(r3, "targetOption");
    }

    public final void Fo(boolean r6, String r7, Object r8) {
        if ((r8 instanceof Integer) == false) goto L5;
        Integer r0 = (Integer) r8;
    L6:
        if (r0 == null) goto L8;
        int r1 = r0.intValue();
    L9:
        FLogger r2 = FLogger.a;
        r2.i("OrionExtraComponent", "onInstructionVisibleChanged, " + r6 + ", actionBarKey: " + r7 + ", finalInstructionType: " + r1 + ", instructionType: " + r8);
        laa.m r9 = (laa.m) this.C.getValue();
        if (r9 == null) goto L12;
        r9.j1(r6);
    L12:
        laa.j r10 = (laa.j) this.D.getValue();
        if (r10 == null) goto L15;
        r10.j1(r6);
    L15:
        laa.d r11 = d4();
        if (r11 == null) goto L19;
        r11.j1(r6);
    L19:
        if (r6 == false) goto L21;
        G4(r7, Integer.valueOf(r1));
    L31:
        if (r6 == false) goto L35;
        if (r1 != 1) goto L35;
        return;
    L35:
        r2.i("OrionExtraComponent", "onInstructionVisibleChanged, override filter");
        ada.c r12 = Z3();
        if (r12 == null) goto L39;
        r12.W00();
        return;
    L39:
        return;
    L21:
        ICoreInputAbility r13 = B3();
        if (r13 == null) goto L24;
        r13.rE();
    L24:
        ICoreInputAbility r14 = B3();
        if (r14 == null) goto L27;
        r14.zM();
    L27:
        F4(true);
        ada.c r15 = Z3();
        if (r15 == null) goto L30;
        r15.jr();
    L30:
        this.n = null;
        ObricActionBarSendServiceExtDelegate.b.q();
        goto L31
    L8:
        r1 = 0;
        goto L9
    L5:
        r0 = null;
        goto L6
    }

    public final void R0(List<z0> r1, wc9.e r2, BotModel r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "itemList");
    }

    public final void t1(List<z0> r1, wc9.e r2, BotModel r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "itemList");
    }

    public final void D(View r24, ImageView r25, TextView r26, z0 r27, com.larus.bmhome.view.actionbar.custom.t1 r28) {
        Intrinsics.checkNotNullParameter(r24, "root");
        Intrinsics.checkNotNullParameter(r25, "icon");
        Intrinsics.checkNotNullParameter(r26, DBDefinition.NAME);
        Intrinsics.checkNotNullParameter(r28, "callback");
        if (Intrinsics.areEqual(r24.getContext(), getContext()) == true) goto L6;
        FLogger.a.i("OrionExtraComponent", "updateHolderStyle: root and component context not match, dont update style");
        return;
    L6:
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (Intrinsics.areEqual(com.larus.ui.arch.component.internal.attach.a.b(this, this).getClass().getSimpleName(), "InjectInputFragment") == false) goto L10;
        FLogger.a.i("OrionExtraComponent", "updateHolderStyle: inject input fragment, dont update style");
        return;
    L10:
        if (r27 == null) goto L19;
        p0 r0 = r27.o;
        if (r0 == null) goto L19;
        Integer r1 = r0.a;
        int r2 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r1 == null) goto L19;
        if (r1.intValue() != r2) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L22;
        this.O = r24;
    L22:
        if (r27 != null) goto L25;
        return;
    L25:
        if (s1a.a.e(this) == false) goto L27;
    L30:
        boolean r4 = true;
    L31:
        if (r4 == true) goto L34;
        FLogger.a.i("OrionExtraComponent", "updateHolderStyle: non O page, keep default action bar style");
        return;
    L34:
        boolean r5 = r24 instanceof RoundConstraintLayout;
        if (r5 == false) goto L38;
        c29.a r6 = ((RoundConstraintLayout) r24).getDelegate();
    L40:
        c29.a r7 = r6;
    L43:
        if (Intrinsics.areEqual(r27.b, "obric_phone_operation") == true) goto L45;
        View r8 = (LinearLayoutCompat) r24.findViewById(2131381144);
        if ((r24 instanceof ViewGroup) == false) goto L53;
        ViewGroup r9 = (ViewGroup) r24;
    L54:
        if (r9 == null) goto L56;
        r9.removeView(r8);
    L56:
        c29.a r18 = r7;
        if (k4(r27, r24) == false) goto L89;
        View r10 = (ConstraintLayout) r24.findViewById(2131381184);
        String r20 = "<this>";
        if (r10 != null) goto L61;
    L66:
        FLogger r13 = FLogger.a;
        r13.i("OrionExtraComponent", "needSecondaryMenu: item = " + r27);
        String r11 = r27.b;
        if (r11 != null) goto L69;
    L82:
        b r12 = null;
    L83:
        if (r12 != null) goto L85;
        com.larus.bmhome.view.actionbar.custom.t1 r14 = r28;
        c29.a r22 = r18;
        boolean r19 = r5;
        Object r15 = "obric_phone_operation";
    L109:
        ReplyOption r16 = r14.g(r27);
        int r17 = be8.g.a;
        boolean r21 = be8.g.a(r27.b);
        if (r21 == true) goto L112;
    L114:
        boolean r23 = false;
    L115:
        int r29 = com.obric.assistant.task.skill.d.a;
        boolean r30 = com.obric.assistant.task.skill.d.a(r27.b);
        if (com.obric.assistant.task.skill.d.a(r27.b) == false) goto L124;
        Map r31 = r27.H;
        if (r31 == null) goto L120;
        String r32 = (String) r31.get("selected");
    L122:
        if (Boolean.parseBoolean(r32) == false) goto L124;
        boolean r33 = true;
    L126:
        if (h4(r27, r16) == false) goto L128;
        ImageView r34 = r25;
        r34.setImageResource(2131244375);
    L129:
        if (r33 == false) goto L132;
        ActionStyle r35 = ActionStyle.SELECTED;
    L160:
        c r110 = this.k1.get(r35);
        if (r110 != null) goto L163;
        return;
    L163:
        laa.d r111 = d4();
        if (r111 == null) goto L168;
        Object r210 = r15;
        if (r111.isFullScreen() != true) goto L169;
        boolean r36 = true;
    L170:
        if (r36 == true) goto L172;
    L176:
        Integer r37 = r110.d;
    L177:
        FLogger r112 = FLogger.a;
        StringBuilder r38 = new StringBuilder("pageStateAbility?.isChatWindow(): ");
        laa.d r39 = d4();
        if (r39 == null) goto L180;
        Boolean r40 = Boolean.valueOf(r39.aF());
    L181:
        r38.append(r40);
        r38.append(", change actionBar progress is ");
        r38.append(this.m);
        r112.i("OrionExtraComponent", r38.toString());
        if (s1a.a.e(this) == false) goto L184;
    L225:
        c29.a r41 = r22;
        if (s1a.a.e(this) == false) goto L343;
        r112.i("OrionExtraComponent", "updateHolderStyle, isWindowHost set material drawable");
        if (r19 == false) goto L230;
        RoundConstraintLayout r42 = (RoundConstraintLayout) r24;
    L232:
        if (r42 == null) goto L254;
        r42.setUseMaterial(true);
        p0 r113 = r27.o;
        if (r113 == null) goto L241;
        Integer r114 = r113.a;
        int r115 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r114 == null) goto L241;
        if (r114.intValue() != r115) goto L241;
        boolean r116 = true;
    L242:
        if (r116 == false) goto L244;
    L246:
        Integer r117 = null;
    L247:
        if (r117 == null) goto L249;
        r117.intValue();
        r42.setPadding(r42.getPaddingStart(), r42.getPaddingTop(), r117.intValue(), r42.getPaddingBottom());
    L249:
        if (r41 == null) goto L251;
        int r43 = aia.b.a;
        r41.d(10);
    L251:
        ViewGroup.LayoutParams r44 = ((RoundConstraintLayout) r24).getLayoutParams();
        if (r44 == null) goto L254;
        int r45 = aia.b.a;
        r44.height = v19.c7.b(34);
        goto L254
    L244:
        if (k4(r27, r24) == true) goto L246;
        int r118 = aia.b.a;
        r117 = Integer.valueOf(v19.c7.b(14));
    L241:
        r116 = false;
    L254:
        ViewGroup.LayoutParams r46 = r25.getLayoutParams();
        if (r46 == null) goto L268;
        int r47 = aia.b.a;
        int r48 = v19.c7.b(18);
        r46.width = r48;
        r46.height = r48;
        r34.setLayoutParams(r46);
        if (be8.g.a(r27.b) == false) goto L268;
        Object r49 = r25.getParent();
        if ((r49 instanceof View) == false) goto L261;
        View r50 = (View) r49;
    L263:
        if ((r50 instanceof RoundConstraintLayout) == true) goto L268;
        if (r50 == null) goto L268;
        ViewGroup.LayoutParams r119 = r50.getLayoutParams();
        if (r119 == null) goto L268;
        r119.width = r48;
        r119.height = r48;
        r50.setLayoutParams(r119);
        goto L268
    L261:
        r50 = null;
    L268:
        Intrinsics.checkNotNullParameter(r27, r20);
        if (Intrinsics.areEqual(r27.b, "task_connector_entry") == false) goto L271;
        r25.clearColorFilter();
    L272:
        if (r37 == null) goto L274;
        r26.setTextColor(ContextCompat.getColor(r24.getContext(), r37.intValue()));
    L274:
        boolean r51 = r24 instanceof ViewGroup;
        if (r51 == false) goto L277;
        ViewGroup r52 = (ViewGroup) r24;
    L278:
        if (r52 == null) goto L281;
        r52.setClipChildren(false);
        r52.setClipToPadding(false);
    L281:
        if (be8.g.a(r27.b) == false) goto L286;
        if (r35 != ActionStyle.SELECTED) goto L286;
        MaterialSceneType r53 = MaterialSceneType.ACTION_BAR_TASK_SKILL_SELECTED;
    L289:
        Lazy r54 = bia.g.a;
        bia.g.a(r24, s1a.a.e(this), r53);
        r26.setLetterSpacing(0.0f);
        int r55 = aia.b.a;
        r26.setTextSize(0, v19.c7.b(14));
        if (r21 == true) goto L300;
        ViewGroup.LayoutParams r56 = r26.getLayoutParams();
        if ((r56 instanceof ViewGroup.MarginLayoutParams) == false) goto L294;
        ViewGroup.MarginLayoutParams r57 = (ViewGroup.MarginLayoutParams) r56;
    L295:
        if (r57 == null) goto L300;
        if (r30 == false) goto L298;
        int r58 = 0;
    L299:
        r57.setMarginStart(r58);
        r26.setLayoutParams(r57);
        goto L300
    L298:
        r58 = v19.c7.b(22);
        goto L299
    L294:
        r57 = null;
    L300:
        p0 r59 = r27.o;
        if (r59 == null) goto L308;
        Integer r60 = r59.a;
        int r61 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r60 == null) goto L308;
        if (r60.intValue() != r61) goto L308;
        boolean r62 = true;
    L309:
        if (r62 == true) goto L311;
        if (r21 == true) goto L311;
        return;
    L311:
        if (r51 == false) goto L313;
        ViewGroup r63 = (ViewGroup) r24;
    L314:
        if (r63 == null) goto L360;
        Sequence r64 = ViewGroupKt.getChildren(r63);
        if (r64 == null) goto L361;
        Iterator r65 = r64.iterator();
    L319:
        if (r65.hasNext() == false) goto L362;
        View r66 = (View) r65.next();
        if (r66.getId() == 2131376349) goto L325;
        if (r66.getId() != 2131376331) goto L319;
    L325:
        if ((r66 instanceof ImageView) == false) goto L327;
        ImageView r67 = (ImageView) r66;
    L329:
        if (r35 != ActionStyle.SELECTED) goto L331;
        boolean r68 = true;
    L332:
        if (r67 == null) goto L319;
        ViewGroup.LayoutParams r69 = r67.getLayoutParams();
        if (r69 == null) goto L337;
        r69.width = p1;
        r69.height = v1;
        r67.setLayoutParams(r69);
    L337:
        Context r70 = getContext();
        if (r68 == false) goto L340;
        int r71 = 2131244377;
    L341:
        r67.setImageDrawable(ContextCompat.getDrawable(r70, r71));
        goto L319
    L340:
        r71 = 2131244376;
        goto L341
    L331:
        r68 = false;
        goto L332
    L327:
        r67 = null;
        goto L329
    L362:
        return;
    L361:
        return;
    L360:
        return;
    L313:
        r63 = null;
    L308:
        r62 = false;
    L286:
        if (be8.g.a(r27.b) == false) goto L288;
        r53 = MaterialSceneType.ACTION_BAR_TASK_SKILL;
        goto L289
    L288:
        r53 = r110.f;
        goto L289
    L277:
        r52 = null;
        goto L278
    L271:
        r34.setColorFilter(getContext().getResources().getColor(r110.c));
        goto L272
    L230:
        r42 = null;
        goto L232
    L343:
        if (r41 == null) goto L346;
        r41.g(0);
        r41.h(0);
        r41.q = false;
        r41.c();
        r41.d(12);
        r41.s = true;
        r41.c();
        int r72 = r24.getContext().getResources().getColor(r110.a);
        int r73 = r24.getContext().getResources().getColor(r110.b);
        r41.s = false;
        r41.e = r72;
        r41.g = r73;
        r41.c();
    L346:
        if ((!Intrinsics.areEqual(r27.b, r210)) == false) goto L348;
        r34.setColorFilter(getContext().getResources().getColor(r110.c));
    L348:
        if (r37 == null) goto L363;
        r26.setTextColor(ContextCompat.getColor(r24.getContext(), r37.intValue()));
        return;
    L363:
        return;
    L184:
        if (this.m != 0.0f) goto L186;
        boolean r74 = true;
    L187:
        if (r74 == false) goto L225;
        r112.i("OrionExtraComponent", "updateHolderStyle: " + r27);
        c29.a r75 = r22;
        if (r75 == null) goto L208;
        r75.q = false;
        r75.c();
        r75.d(8);
        r75.s = true;
        r75.c();
        if (e4(r27) == true) goto L205;
        if (r23 == true) goto L205;
        if (h4(r27, r16) == true) goto L205;
        if (r33 == true) goto L205;
        if (Intrinsics.areEqual(r27.b, "obric_omni") == true) goto L205;
        if (Intrinsics.areEqual(r27.b, "obric_oauto") == true) goto L205;
        if (r35 == ActionStyle.SELECTED) goto L208;
        r25.clearColorFilter();
    L205:
        if (r35 == ActionStyle.SELECTED) goto L207;
        r75.g(ContextCompat.getColor(r24.getContext(), 2131103162));
    L207:
        r34.setColorFilter(ContextCompat.getColor(r24.getContext(), r110.c));
    L208:
        if (r37 == null) goto L210;
        r26.setTextColor(ContextCompat.getColor(r24.getContext(), r37.intValue()));
    L210:
        if (r75 == null) goto L212;
        r75.b(r24.getContext().getResources().getColor(2131105532));
    L212:
        boolean r76 = v19.h.a;
        Context r77 = r24.getContext();
        if (r77 != null) goto L216;
        r77 = getContext();
    L216:
        if (v19.h.b(r77) == false) goto L218;
        int r78 = 2131102564;
    L219:
        if (r75 == null) goto L359;
        Context r79 = r24.getContext();
        if (r79 != null) goto L223;
        r79 = getContext();
    L223:
        r75.a(ContextCompat.getColor(r79, r78));
        return;
    L359:
        return;
    L218:
        r78 = 2131102563;
        goto L219
    L186:
        r74 = false;
        goto L187
    L180:
        r40 = null;
        goto L181
    L172:
        if (r35 != ActionStyle.SELECTED) goto L176;
        if (AccountService.a.isEnterpriseAccount() == false) goto L176;
        r37 = 2131103849;
    L169:
        r36 = false;
        goto L170
    L168:
        r210 = r15;
        goto L169
    L132:
        if (e4(r27) == false) goto L135;
        r35 = ActionStyle.OBRIC;
        goto L160
    L135:
        AtomicBoolean r80 = com.obric.assistant.task.skill.m.a;
        boolean r81 = com.obric.assistant.task.skill.m.b.get();
        FLogger.a.i("ObricTaskSkillModeHelper", "isUseModeModelList: " + r81);
        String r82 = r16.getModeId();
        ObricOmniModeTag r120 = ObricOmniModeTag.QUICK;
        if (Intrinsics.areEqual(r82, com.obric.assistant.task.skill.m.e(r120)) == true) goto L146;
        String r83 = r16.getModeId();
        if (r83 != null) goto L140;
    L143:
        boolean r84 = true;
    L144:
        if (r84 == true) goto L146;
    L149:
        if (Intrinsics.areEqual(r16.getModeId(), com.obric.assistant.task.skill.m.e(r120)) == false) goto L152;
        if (r81 == false) goto L152;
    L151:
        boolean r85 = true;
    L153:
        if (r85 == false) goto L159;
        if (r23 == true) goto L159;
        if (h4(r27, r16) == true) goto L159;
        r35 = ActionStyle.NORMAL;
    L159:
        r35 = ActionStyle.SELECTED;
    L152:
        r85 = false;
        goto L153
    L140:
        if (r83.length() == 0) goto L143;
        r84 = false;
    L146:
        if (Intrinsics.areEqual(r16.getModel().getKey(), com.obric.assistant.task.skill.m.f(ObricOmniModelTag.QUICK)) == false) goto L149;
        if (r81 == false) goto L151;
    L128:
        r34 = r25;
        goto L129
    L120:
        r32 = null;
    L124:
        r33 = false;
        goto L126
    L112:
        if (r27.u == null) goto L114;
        r23 = true;
        goto L115
    L85:
        AppCompatImageView r86 = new AppCompatImageView(getContext());
        r86.setId(r12.a);
        ConstraintLayout.LayoutParams r87 = new ConstraintLayout.LayoutParams(-2, -2);
        r87.startToStart = 0;
        r87.topToTop = 0;
        r87.bottomToBottom = 0;
        r87.endToEnd = 0;
        r87.setMarginEnd(r12.d);
        r87.setMarginStart(r12.c);
        r86.setLayoutParams(r87);
        r86.setImageDrawable(AppCompatResources.getDrawable(r86.getContext(), r12.b));
        Integer r88 = r12.e;
        if (r88 == null) goto L88;
        r86.setColorFilter(r88.intValue());
    L88:
        r86.setVisibility(0);
        r86.setBackground(new ColorDrawable(0));
        r86.setTag("secondary_menu_tag");
        ConstraintLayout r89 = new ConstraintLayout(r24.getContext());
        r89.setId(2131381184);
        ViewGroup.LayoutParams r90 = new ConstraintLayout.LayoutParams(-2, -1);
        ((ConstraintLayout.LayoutParams) r90).startToEnd = r26.getId();
        ((ConstraintLayout.LayoutParams) r90).topToTop = 0;
        ((ConstraintLayout.LayoutParams) r90).bottomToBottom = 0;
        ((ConstraintLayout.LayoutParams) r90).endToEnd = 0;
        r89.setLayoutParams(r90);
        r89.setVisibility(0);
        r89.addView(r86);
        r89.setClickable(true);
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundConstraintLayout");
        RoundConstraintLayout r91 = (RoundConstraintLayout) r24;
        r15 = r3;
        r22 = r18;
        r19 = r5;
        e1.d(r89, new v6(r27, this, r89, r24, r86));
        r89.setTag(r27.b);
        r91.setPadding(v19.i5.h(), 0, 0, 0);
        r91.addView(r89);
        r13.i("OrionExtraComponent", "secondaryMenu set done");
    L108:
        r14 = r28;
        goto L109
    L69:
        switch(r11.hashCode()) {
            case -1832688838: goto L79;
            case -761162256: goto L77;
            case 241623133: goto L75;
            case 780021240: goto L72;
            default: goto L82;
        };
    L77:
        r11.equals("obric_phone_operation");
        goto L82
    L72:
        if (r11.equals("obric_photo_perception") == false) goto L82;
    L81:
        r12 = new b((int) getContext().getResources().getDimension(v19.c.b(2130971546, getContext(), 2131167462)), (int) getContext().getResources().getDimension(v19.c.b(2130971480, getContext(), 2131167404)));
        goto L83
    L75:
        if (r11.equals("obric_screen_qa") == false) goto L82;
    L79:
        if (r11.equals("obric_im_perception") == true) goto L81;
    L61:
        if ((r24 instanceof ViewGroup) == false) goto L63;
        ViewGroup r121 = (ViewGroup) r24;
    L64:
        if (r121 == null) goto L66;
        r121.removeView(r10);
        goto L66
    L63:
        r121 = null;
        goto L64
    L89:
        r15 = "obric_phone_operation";
        r20 = "<this>";
        r22 = r18;
        r19 = r5;
        if (Intrinsics.areEqual(r27.b, r15) == false) goto L92;
    L103:
        boolean r92 = true;
    L104:
        if (r92 == false) goto L108;
        ConstraintLayout r93 = r24.findViewById(2131381184);
        if (r93 == null) goto L108;
        Intrinsics.checkNotNull(r24, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundConstraintLayout");
        RoundConstraintLayout r94 = (RoundConstraintLayout) r24;
        int r95 = v19.i5.h();
        r94.setPadding(r95, 0, r95, 0);
        r93.removeAllViews();
        r94.removeView(r93);
        goto L108
    L92:
        if (Intrinsics.areEqual(r27.b, "obric_im_perception") == false) goto L94;
    L102:
        r92 = false;
        goto L104
    L94:
        if (Intrinsics.areEqual(r27.b, "obric_screen_qa") == true) goto L102;
        if (Intrinsics.areEqual(r27.b, "obric_photo_perception") == true) goto L102;
        if (Intrinsics.areEqual(r27.b, "obric_oauto") == true) goto L102;
        if (Intrinsics.areEqual(r27.b, "obric_omni") == true) goto L102;
    L53:
        r9 = null;
        goto L54
    L45:
        if ((r24 instanceof ViewGroup) == false) goto L47;
        ViewGroup r96 = (ViewGroup) r24;
    L48:
        if (r96 == null) goto L56;
        FLogger.a.i("OrionExtraComponent", "no need show pro icon");
        goto L56
    L47:
        r96 = null;
        goto L48
    L38:
        if ((r24 instanceof RoundFrameLayout) == false) goto L41;
        r6 = ((RoundFrameLayout) r24).getDelegate();
        goto L40
    L41:
        r7 = null;
        goto L43
    L27:
        if (d4() != null) goto L30;
        r4 = false;
    L19:
        r3 = false;
        goto L20
    }
}
