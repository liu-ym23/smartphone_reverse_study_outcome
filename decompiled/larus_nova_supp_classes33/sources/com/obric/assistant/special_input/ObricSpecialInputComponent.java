package com.obric.assistant.special_input;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.Npth;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.google.gson.Gson;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.instruction.b2;
import com.larus.bmhome.view.TitleAvatarImageView;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.StateInfo;
import com.obric.assistant.ability.ObricSpecialInputScene;
import com.obric.assistant.actionbar.service.ObricActionBarTrackServiceExtDelegate;
import com.obric.assistant.actionbar.statemanager.state.ObricTaskMode;
import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.impl.databinding.LayoutObricSpecialInputWidgetV2Binding;
import com.obric.assistant.impl.databinding.RowObricActionBarPhoneOperationInstructionsBinding;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.live.util.ObricIslandType;
import com.obric.assistant.special_input.instruction.PanelInstructionItem;
import com.obric.assistant.special_input.instruction.PanelInstructionLoader;
import com.obric.assistant.special_input.instruction.PanelInstructionType;
import com.obric.assistant.special_input.util.SpecialTrackEventUtilsKt;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import com.obric.assistant.t1;
import com.obric.assistant.task.ObricTaskStatusManager;
import com.obric.assistant.util.VContextMessageExKt;
import com.obric.assistant.util.q2;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000î\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002È\u0001\u0018\u0000 §\u00032\u00020\u00012\u00020\u00022\u00020\u0003:\u0004¦\u0003§\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0016J\n\u0010Ì\u0001\u001a\u00030Ë\u0001H\u0016J\n\u0010Í\u0001\u001a\u00030Ë\u0001H\u0016J\n\u0010Î\u0001\u001a\u00030Ë\u0001H\u0002J\n\u0010Ï\u0001\u001a\u00030¤\u0001H\u0002J\f\u0010Ð\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0002J\u0014\u0010Ñ\u0001\u001a\u00030Ë\u00012\b\u0010Ò\u0001\u001a\u00030¬\u0001H\u0016J\u0014\u0010Ó\u0001\u001a\u00030Ë\u00012\b\u0010Ò\u0001\u001a\u00030¬\u0001H\u0016J\u0014\u0010Ô\u0001\u001a\u00030Ë\u00012\b\u0010Ò\u0001\u001a\u00030®\u0001H\u0016J\u0014\u0010Õ\u0001\u001a\u00030Ë\u00012\b\u0010Ò\u0001\u001a\u00030®\u0001H\u0016J\n\u0010Ö\u0001\u001a\u00030¤\u0001H\u0016J\n\u0010×\u0001\u001a\u00030¤\u0001H\u0016J\n\u0010Ø\u0001\u001a\u00030¤\u0001H\u0016J\n\u0010Ù\u0001\u001a\u00030¤\u0001H\u0002Jf\u0010Ú\u0001\u001a\u00030Ë\u00012\b\u0010Û\u0001\u001a\u00030¤\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\n\u0010Þ\u0001\u001a\u0005\u0018\u00010ß\u00012\n\u0010à\u0001\u001a\u0005\u0018\u00010´\u00012\b\u0010á\u0001\u001a\u00030¤\u00012\u0018\u0010â\u0001\u001a\u0013\u0012\u0005\u0012\u00030½\u0001\u0012\u0005\u0012\u00030½\u0001\u0018\u00010ã\u00012\b\u0010ä\u0001\u001a\u00030¤\u0001H\u0016J\n\u0010å\u0001\u001a\u00030Ë\u0001H\u0002J\n\u0010æ\u0001\u001a\u00030Ë\u0001H\u0002J\u0016\u0010ç\u0001\u001a\u00030Ë\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0002J\u0014\u0010ê\u0001\u001a\u00030Ë\u00012\b\u0010ë\u0001\u001a\u00030°\u0001H\u0016JI\u0010ì\u0001\u001a\u00030´\u00012\n\u0010í\u0001\u001a\u0005\u0018\u00010½\u00012\n\u0010î\u0001\u001a\u0005\u0018\u00010½\u00012\b\u0010ï\u0001\u001a\u00030ð\u00012\b\u0010ñ\u0001\u001a\u00030½\u00012\b\u0010ò\u0001\u001a\u00030½\u00012\u0007\u0010ó\u0001\u001a\u00020sH\u0002J\u0014\u0010ô\u0001\u001a\u00030¤\u00012\b\u0010Ü\u0001\u001a\u00030Ý\u0001H\u0002J<\u0010õ\u0001\u001a\u00030Ë\u00012\n\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u00012\n\u0010ø\u0001\u001a\u0005\u0018\u00010½\u00012\u0018\u0010â\u0001\u001a\u0013\u0012\u0005\u0012\u00030½\u0001\u0012\u0005\u0012\u00030½\u0001\u0018\u00010ã\u0001H\u0016J2\u0010ù\u0001\u001a\u00030Ë\u00012\n\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u00012\u001a\b\u0002\u0010â\u0001\u001a\u0013\u0012\u0005\u0012\u00030½\u0001\u0012\u0005\u0012\u00030½\u0001\u0018\u00010ã\u0001H\u0002J\u0014\u0010ú\u0001\u001a\u00030Ë\u00012\b\u0010ø\u0001\u001a\u00030½\u0001H\u0002J\n\u0010û\u0001\u001a\u00030¤\u0001H\u0002J\n\u0010ü\u0001\u001a\u00030Ë\u0001H\u0016J\n\u0010ý\u0001\u001a\u00030Ë\u0001H\u0016J\u001e\u0010ü\u0001\u001a\u00030Ë\u00012\b\u0010þ\u0001\u001a\u00030¤\u00012\b\u0010ÿ\u0001\u001a\u00030½\u0001H\u0002J\n\u0010\u0080\u0002\u001a\u00030Ë\u0001H\u0016J\n\u0010\u0081\u0002\u001a\u00030Ë\u0001H\u0016J \u0010\u0082\u0002\u001a\u00030¤\u00012\b\u0010\u0083\u0002\u001a\u00030¤\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J\u0014\u0010\u0084\u0002\u001a\u00030Ë\u00012\b\u0010\u0085\u0002\u001a\u00030¤\u0001H\u0016J\n\u0010\u0086\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010\u0087\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010\u0088\u0002\u001a\u00030Ë\u0001H\u0002J6\u0010\u0089\u0002\u001a\u00030Ë\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\b\u0010\u008a\u0002\u001a\u00030ß\u00012\b\u0010ä\u0001\u001a\u00030¤\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0002J\u0018\u0010\u008e\u0002\u001a\u0005\u0018\u00010½\u00012\n\u0010\u008f\u0002\u001a\u0005\u0018\u00010½\u0001H\u0002J\n\u0010\u0090\u0002\u001a\u00030¤\u0001H\u0002J \u0010\u0091\u0002\u001a\u00030Ë\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\b\u0010\u008a\u0002\u001a\u00030ß\u0001H\u0002J\u000f\u0010\u0092\u0002\u001a\u00030¤\u0001*\u00030´\u0001H\u0002J\u0016\u0010\u0095\u0002\u001a\u00030Ë\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0003J\n\u0010\u0096\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010\u0097\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010\u0098\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010\u0099\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010\u009a\u0002\u001a\u00030Ë\u0001H\u0002J6\u0010\u009b\u0002\u001a\u00030Ë\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\b\u0010\u008a\u0002\u001a\u00030ß\u00012\b\u0010ä\u0001\u001a\u00030¤\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0002J4\u0010\u009c\u0002\u001a\u0004\u0018\u00010}2\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\b\u0010\u008a\u0002\u001a\u00030ß\u00012\b\u0010ä\u0001\u001a\u00030¤\u00012\u0007\u0010W\u001a\u00030¸\u0001H\u0002J\u0013\u0010\u009d\u0002\u001a\u00030Ë\u00012\u0007\u0010W\u001a\u00030¸\u0001H\u0002J\u0016\u0010¡\u0002\u001a\u00030¤\u00012\n\u0010ë\u0001\u001a\u0005\u0018\u00010°\u0001H\u0002J\n\u0010¢\u0002\u001a\u00030¤\u0001H\u0002J\n\u0010£\u0002\u001a\u00030¤\u0001H\u0002J\u0016\u0010¤\u0002\u001a\u00030¤\u00012\n\u0010ë\u0001\u001a\u0005\u0018\u00010°\u0001H\u0002J\u0016\u0010¥\u0002\u001a\u00030¤\u00012\n\u0010ë\u0001\u001a\u0005\u0018\u00010°\u0001H\u0002J\u0016\u0010¦\u0002\u001a\u00030Ë\u00012\n\b\u0002\u0010§\u0002\u001a\u00030¤\u0001H\u0002J\n\u0010¨\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010©\u0002\u001a\u00030Ë\u0001H\u0002J\u0013\u0010ª\u0002\u001a\u00030Ë\u00012\u0007\u0010W\u001a\u00030¸\u0001H\u0002J\n\u0010«\u0002\u001a\u00030Ë\u0001H\u0002J\u0016\u0010¬\u0002\u001a\u00030Ë\u00012\n\b\u0002\u0010\u00ad\u0002\u001a\u00030¤\u0001H\u0002J\n\u0010®\u0002\u001a\u00030Ë\u0001H\u0002J\u0014\u0010¯\u0002\u001a\u00030Ë\u00012\b\u0010°\u0002\u001a\u00030¤\u0001H\u0002J\n\u0010±\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010²\u0002\u001a\u00030Ë\u0001H\u0002J\u000b\u0010³\u0002\u001a\u0004\u0018\u00010kH\u0002J\u0014\u0010´\u0002\u001a\u00030Ë\u00012\b\u0010µ\u0002\u001a\u00030¤\u0001H\u0002J\n\u0010¶\u0002\u001a\u00030Ë\u0001H\u0002J\f\u0010·\u0002\u001a\u0005\u0018\u00010¸\u0002H\u0002J\"\u0010¹\u0002\u001a\u00030¸\u00022\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0002J\n\u0010º\u0002\u001a\u00030¤\u0001H\u0002J\f\u0010»\u0002\u001a\u0005\u0018\u00010¼\u0002H\u0002J\n\u0010½\u0002\u001a\u00030Ë\u0001H\u0002J2\u0010¾\u0002\u001a\u00030Ë\u00012\b\u0010¿\u0002\u001a\u00030¼\u00022\b\u0010À\u0002\u001a\u00030¸\u00022\b\u0010Á\u0002\u001a\u00030½\u00012\b\u0010Â\u0002\u001a\u00030Ã\u0002H\u0002J\u0014\u0010Ä\u0002\u001a\u00030¤\u00012\b\u0010À\u0002\u001a\u00030¸\u0002H\u0002J\u001b\u0010Å\u0002\u001a\u00030Ã\u00022\b\u0010À\u0002\u001a\u00030¸\u0002H\u0082@¢\u0006\u0003\u0010Æ\u0002J\u0014\u0010Ç\u0002\u001a\u00030Ã\u00022\b\u0010À\u0002\u001a\u00030¸\u0002H\u0002J\u0014\u0010È\u0002\u001a\u00030Ã\u00022\b\u0010À\u0002\u001a\u00030¸\u0002H\u0002J\u001b\u0010É\u0002\u001a\u00030Ã\u00022\b\u0010À\u0002\u001a\u00030¸\u0002H\u0082@¢\u0006\u0003\u0010Æ\u0002J.\u0010Ê\u0002\u001a\u00030Ý\u00012\b\u0010À\u0002\u001a\u00030¸\u00022\f\b\u0002\u0010Ë\u0002\u001a\u0005\u0018\u00010½\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0002J\u0014\u0010Ì\u0002\u001a\u00030Ë\u00012\b\u0010Ü\u0001\u001a\u00030Ý\u0001H\u0002J\u001e\u0010Í\u0002\u001a\u00030Ë\u00012\b\u0010¿\u0002\u001a\u00030¼\u00022\b\u0010Î\u0002\u001a\u00030½\u0001H\u0002J\u0016\u0010Ï\u0002\u001a\u00030Ë\u00012\n\b\u0002\u0010Ð\u0002\u001a\u00030½\u0001H\u0002J\n\u0010Ñ\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010Ò\u0002\u001a\u00030Ë\u0001H\u0002J,\u0010Ó\u0002\u001a\u00030Ë\u00012\b\u0010Ô\u0002\u001a\u00030\u009a\u00012\u0016\u0010Õ\u0002\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030×\u00020Ö\u00020Ö\u0002H\u0002J\u0014\u0010Ø\u0002\u001a\u00030Ë\u00012\b\u0010Ô\u0002\u001a\u00030\u009a\u0001H\u0016J\n\u0010Ù\u0002\u001a\u00030Ë\u0001H\u0016J%\u0010Ú\u0002\u001a\u00030Ë\u00012\b\u0010Û\u0002\u001a\u00030\u009a\u00012\u000f\u0010Ü\u0002\u001a\n\u0012\u0005\u0012\u00030×\u00020Ö\u0002H\u0002J\u0014\u0010Ý\u0002\u001a\u00030Ë\u00012\b\u0010à\u0001\u001a\u00030×\u0002H\u0002J\n\u0010Þ\u0002\u001a\u00030Ë\u0001H\u0002J\"\u0010ß\u0002\u001a\u0011\u0012\u0005\u0012\u00030½\u0001\u0012\u0005\u0012\u00030½\u00010ã\u00012\b\u0010à\u0001\u001a\u00030×\u0002H\u0002J\u001e\u0010à\u0002\u001a\u00030Ë\u00012\b\u0010á\u0002\u001a\u00030\u009a\u00012\b\u0010â\u0002\u001a\u00030½\u0001H\u0002J\u001b\u0010ã\u0002\u001a\u00030Ë\u0001*\u00030ä\u00022\n\u0010å\u0002\u001a\u0005\u0018\u00010æ\u0002H\u0002J\u000f\u0010ç\u0002\u001a\u00030Ë\u0001*\u00030ä\u0002H\u0002J\n\u0010è\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010é\u0002\u001a\u00030Ë\u0001H\u0002J \u0010ê\u0002\u001a\u00030Ë\u00012\b\u0010ÿ\u0001\u001a\u00030½\u00012\n\b\u0002\u0010ë\u0002\u001a\u00030¤\u0001H\u0002J\u001f\u0010ì\u0002\u001a\u00020s2\b\u0010í\u0002\u001a\u00030\u009e\u00012\n\b\u0002\u0010ë\u0002\u001a\u00030¤\u0001H\u0002J\n\u0010î\u0002\u001a\u00030Ë\u0001H\u0002J\n\u0010ï\u0002\u001a\u00030Ë\u0001H\u0003J\n\u0010õ\u0002\u001a\u00030Ë\u0001H\u0016J\u0014\u0010ö\u0002\u001a\u00030Ë\u00012\b\u0010÷\u0002\u001a\u00030¤\u0001H\u0002J\u0018\u0010ø\u0002\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030×\u00020Ö\u00020Ö\u0002H\u0002J/\u0010ù\u0002\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030×\u00020Ö\u00020Ö\u0002*\n\u0012\u0005\u0012\u00030×\u00020Ö\u00022\t\b\u0002\u0010ú\u0002\u001a\u00020sH\u0002J\u000f\u0010û\u0002\u001a\u00030¤\u0001*\u00030×\u0002H\u0002J\u000e\u0010ü\u0002\u001a\u00020s*\u00030×\u0002H\u0002J\n\u0010ý\u0002\u001a\u00030Ë\u0001H\u0016J\n\u0010\u0086\u0003\u001a\u00030Ë\u0001H\u0002J\n\u0010\u0087\u0003\u001a\u00030Ë\u0001H\u0002J\n\u0010\u0088\u0003\u001a\u00030Ë\u0001H\u0016J\n\u0010\u0093\u0003\u001a\u00030Ë\u0001H\u0002J\u0014\u0010\u0094\u0003\u001a\u00030Ë\u00012\b\u0010¿\u0002\u001a\u00030\u0095\u0003H\u0002J\u0014\u0010\u0096\u0003\u001a\u00030Ë\u00012\b\u0010¿\u0002\u001a\u00030\u0095\u0003H\u0002J\n\u0010\u0097\u0003\u001a\u00030Ë\u0001H\u0002J\u0011\u0010\u0098\u0003\u001a\u00030¤\u0001H\u0082@¢\u0006\u0003\u0010\u0099\u0003J\n\u0010\u009a\u0003\u001a\u00030Ë\u0001H\u0002J,\u0010\u009b\u0003\u001a\u00030Ë\u00012\b\u0010Ô\u0002\u001a\u00030\u009a\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001H\u0002J\n\u0010\u009c\u0003\u001a\u00030\u009d\u0003H\u0002J\n\u0010\u009e\u0003\u001a\u00030Ë\u0001H\u0016J\n\u0010\u009f\u0003\u001a\u00030¤\u0001H\u0016J\u0010\u0010 \u0003\u001a\u0005\u0018\u00010½\u0001*\u00020sH\u0002J\u000f\u0010¡\u0003\u001a\u00030ð\u0001*\u00030½\u0001H\u0002J\u0018\u0010¢\u0003\u001a\u0005\u0018\u00010é\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0002J\n\u0010£\u0003\u001a\u00030¤\u0001H\u0002J\n\u0010¤\u0003\u001a\u00030¤\u0001H\u0002J\n\u0010¥\u0003\u001a\u00030¤\u0001H\u0002R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b'\u0010(R\u001d\u0010*\u001a\u0004\u0018\u00010+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u000b\u001a\u0004\b,\u0010-R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b1\u00102R\u001d\u00104\u001a\u0004\u0018\u0001058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u000b\u001a\u0004\b6\u00107R\u001d\u00109\u001a\u0004\u0018\u00010:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b;\u0010<R\u001d\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u000b\u001a\u0004\b@\u0010AR\u001d\u0010C\u001a\u0004\u0018\u00010D8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u000b\u001a\u0004\bE\u0010FR\u001d\u0010H\u001a\u0004\u0018\u00010I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u000b\u001a\u0004\bJ\u0010KR\u001d\u0010M\u001a\u0004\u0018\u00010N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u000b\u001a\u0004\bO\u0010PR\u001d\u0010R\u001a\u0004\u0018\u00010S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u000b\u001a\u0004\bT\u0010UR\u001d\u0010W\u001a\u0004\u0018\u00010X8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u000b\u001a\u0004\bY\u0010ZR\u001d\u0010\\\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\u000b\u001a\u0004\b^\u0010_R\u001d\u0010a\u001a\u0004\u0018\u00010b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u000b\u001a\u0004\bc\u0010dR\u0016\u0010f\u001a\u0004\u0018\u00010g8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0016\u0010j\u001a\u0004\u0018\u00010k8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0016\u0010n\u001a\u0004\u0018\u00010o8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u001b\u0010r\u001a\u00020s8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\u000b\u001a\u0004\bt\u0010uR\u001d\u0010w\u001a\u0004\u0018\u00010x8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\u000b\u001a\u0004\by\u0010zR\u0016\u0010|\u001a\u0004\u0018\u00010}8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\"\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0084\u0001\u0010\u000b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001a\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u0089\u0001\u001a\u0004\u0018\u00010k8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010mR\u0018\u0010\u008b\u0001\u001a\u0004\u0018\u00010k8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010mR\u0018\u0010\u008d\u0001\u001a\u0004\u0018\u00010]8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010_R\u0018\u0010\u008f\u0001\u001a\u0004\u0018\u00010}8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010\u007fR\u0018\u0010\u0091\u0001\u001a\u0004\u0018\u00010}8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010\u007fR\u0018\u0010\u0093\u0001\u001a\u0004\u0018\u00010k8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0094\u0001\u0010mR\u0018\u0010\u0095\u0001\u001a\u0004\u0018\u00010k8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010mR\u0018\u0010\u0097\u0001\u001a\u0004\u0018\u00010}8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0098\u0001\u0010\u007fR\u001a\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001a\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0014\u0010¡\u0001\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0005\n\u0003\u0010¢\u0001R\u0010\u0010£\u0001\u001a\u00030¤\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010¦\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010§\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010¨\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b§\u0001\u0010©\u0001R\u0017\u0010ª\u0001\u001a\n\u0012\u0005\u0012\u00030¬\u00010«\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u00ad\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00010«\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010¯\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010°\u00010¦\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010±\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010°\u00010¨\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010©\u0001R\u0012\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010µ\u0001\u001a\u00030¤\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bµ\u0001\u0010¶\u0001R\u0012\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¹\u0001\u001a\u00030¤\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010º\u0001\u001a\u00030¤\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010»\u0001\u001a\u00030¤\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¾\u0001\u001a\u0005\u0018\u00010½\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¿\u0001\u001a\u0005\u0018\u00010½\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010À\u0001\u001a\u00030¤\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Á\u0001\u001a\u00030¤\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Å\u0001\u001a\u00030Æ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010Ç\u0001\u001a\u00030È\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010É\u0001R\u001e\u0010\u008b\u0002\u001a\u00020s8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008d\u0002\u0010\u000b\u001a\u0005\b\u008c\u0002\u0010uR\u0010\u0010\u0093\u0002\u001a\u00030¤\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0094\u0002\u001a\u00030¤\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u009e\u0002\u001a\u0005\u0018\u00010°\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009f\u0002\u0010 \u0002R \u0010ð\u0002\u001a\u00030ñ\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bô\u0002\u0010\u000b\u001a\u0006\bò\u0002\u0010ó\u0002R \u0010þ\u0002\u001a\u00030ÿ\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0082\u0003\u0010\u000b\u001a\u0006\b\u0080\u0003\u0010\u0081\u0003R \u0010\u0083\u0003\u001a\u00030ÿ\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0085\u0003\u0010\u000b\u001a\u0006\b\u0084\u0003\u0010\u0081\u0003R\u0011\u0010\u0089\u0003\u001a\u0004\u0018\u00010}X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u008a\u0003\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0005\n\u0003\u0010¢\u0001R\u0014\u0010\u008b\u0003\u001a\u0004\u0018\u00010sX\u0082\u000e¢\u0006\u0005\n\u0003\u0010¢\u0001R \u0010\u008c\u0003\u001a\u00030\u008d\u00038BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0090\u0003\u0010\u000b\u001a\u0006\b\u008e\u0003\u0010\u008f\u0003R\u0012\u0010\u0091\u0003\u001a\u0005\u0018\u00010\u0092\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¨\u0003"}, d2 = {"Lcom/obric/assistant/special_input/ObricSpecialInputComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "Lcom/obric/assistant/actionbar/IObricSpecialInputCallback;", "<init>", "()V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "instructionAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "suggestedActionAbility", "Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "getSuggestedActionAbility", "()Lcom/larus/bmhome/chat/action/ISuggestedActionAbility;", "suggestedActionAbility$delegate", "extraAbility", "Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "getExtraAbility", "()Lcom/obric/assistant/ability/chat/instruction/IObricInstructionAbility;", "extraAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "photoActionAbility", "Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "getPhotoActionAbility", "()Lcom/obric/assistant/ability/IObricPhotoActionAbility;", "photoActionAbility$delegate", "chatListComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListComponentAbility$delegate", "chatInputUIAbility", "Lcom/obric/assistant/chat/bottom/sub/IObricChatInputUIAbility;", "getChatInputUIAbility", "()Lcom/obric/assistant/chat/bottom/sub/IObricChatInputUIAbility;", "chatInputUIAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "bottomMenuAbility$delegate", "skillModeAbility", "Lcom/obric/assistant/ability/IObricSkillAbility;", "getSkillModeAbility", "()Lcom/obric/assistant/ability/IObricSkillAbility;", "skillModeAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "getMessageList", "()Landroidx/recyclerview/widget/RecyclerView;", "messageList$delegate", "input", "Landroid/widget/FrameLayout;", "getInput", "()Landroid/widget/FrameLayout;", "input$delegate", "inputUiContract", "Lcom/larus/bmhome/ability/ChatInputUiContract;", "getInputUiContract", "()Lcom/larus/bmhome/ability/ChatInputUiContract;", "inputAreaHostContainer", "Landroid/view/ViewGroup;", "getInputAreaHostContainer", "()Landroid/view/ViewGroup;", "inputAreaContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getInputAreaContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "inputAreaContainerPaddingHor", "", "getInputAreaContainerPaddingHor", "()I", "inputAreaContainerPaddingHor$delegate", "actionBarAvatar", "Lcom/larus/bmhome/view/TitleAvatarImageView;", "getActionBarAvatar", "()Lcom/larus/bmhome/view/TitleAvatarImageView;", "actionBarAvatar$delegate", "divider", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "instructionUiContract", "Lcom/larus/bmhome/instruction/InstructionUiContract;", "getInstructionUiContract", "()Lcom/larus/bmhome/instruction/InstructionUiContract;", "instructionUiContract$delegate", "editorTitle", "Landroid/widget/TextView;", "getEditorTitle", "()Landroid/widget/TextView;", "editorContainer", "getEditorContainer", "actionBarContainer", "getActionBarContainer", "customActionBarView", "getCustomActionBarView", "clickArea", "getClickArea", "clickBtnIcon", "getClickBtnIcon", "titleContentContainer", "getTitleContentContainer", "actionBarTitleContainer", "getActionBarTitleContainer", "actionBarTitleClickCloseArea", "getActionBarTitleClickCloseArea", "llWidgetContainer", "Landroid/widget/LinearLayout;", "getLlWidgetContainer", "()Landroid/widget/LinearLayout;", "componentScrollContainer", "Landroid/widget/ScrollView;", "getComponentScrollContainer", "()Landroid/widget/ScrollView;", "defaultActionBarMarginTop", "Ljava/lang/Integer;", "isComponentScrollHiddenByFullScreenIme", "", "_isVariantInputOpen", "Lkotlinx/coroutines/flow/MutableStateFlow;", "isVariantInputOpen", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "stateListeners", "", "Lcom/obric/assistant/ability/ObricSpecialInputStateListener;", "closeMethodListeners", "Lcom/obric/assistant/ability/ObricSpecialInputCloseMethodListener;", "_currentStatus", "Lcom/obric/assistant/ability/ObricSpecialInputStatus;", "currentStatus", "getCurrentStatus", "currentActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "isLandscape", "()Z", "specialInputBinding", "Lcom/obric/assistant/impl/databinding/LayoutObricSpecialInputWidgetV2Binding;", "hasAttachmentInSpecialInput", "isResourceBarMovedToSpecialHolder", "hasManagedSpecialInputAttachment", "observedPhoneAttachmentDraftLocalMsgId", "", "reconciledPhoneAttachmentDraftLocalMsgId", "restoringPhoneAttachmentDraftLocalMsgId", "isDiscardingPhoneAttachmentDraft", "specialInputMenuInterceptorApplied", "previousActionEntranceMenuInterceptor", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputManager$InputActionEntranceMenuInterceptor;", "specialInputActionEntranceMenuInterceptor", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "imeListener", "com/obric/assistant/special_input/ObricSpecialInputComponent$imeListener$1", "Lcom/obric/assistant/special_input/ObricSpecialInputComponent$imeListener$1;", "onPause", "", "onStop", "onResume", "refreshInstructionsOnResumeIfNeeded", "shouldRefreshInstructionsOnResume", "findInstructionOuterContainer", "addStateListener", "listener", "removeStateListener", "addCloseMethodListener", "removeCloseMethodListener", "isInReplyPanel", "isFileInputEnabled", "shouldSuppressAttachmentSuggestedAction", "isRestoringPhoneOperationAttachmentDraft", "openSpecialInputPanel", "isToWindow", "stateInfo", "Lcom/obric/aiagent/assistant/idl/bean/StateInfo;", "scene", "Lcom/obric/assistant/ability/ObricSpecialInputScene;", "item", "isAutoOpen", "extra", "", "isIdle", "setImeListener", "removeImeListener", "openStartTaskPanel", "relatedTask", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "changeCurrentStatus", "status", "mockCustomActionBarItem", MemorySourceLinkType.URL, "darkUrl", "itemId", "", "actionBarKey", "name", "actionType", "checkIsSpecialInputOpen", "checkCloseObricSpecialInputPanel", "msg", "Lcom/larus/im/bean/message/Message;", "packageName", "onSendMessageClose", "onTaskOverClose", "isWindowDismiss", "closeSpecialInputPanel", "closeSpecialInputPanelOnWindowStashed", "dismissWindow", "from", "hideContentForFullScreenIme", "restoreContentAfterFullScreenIme", "isActionBarEnable", "isChatWindow", "onInstructionVisibleChanged", "instructionOpen", "prepareInputAreaForSpecialPanel", "hideInputActionEntrancesForSpecialPanel", "restoreInputActionEntrancesAfterSpecialPanel", "openSpecialInputInternal", "taskScene", "specialInputContentMaxWidth", "getSpecialInputContentMaxWidth", "specialInputContentMaxWidth$delegate", "removeContentPrefix", "content", "isChatWindowOrIntercom", "setupTitleContainer", "isFastInstructionActionBarItem", "isDismissWindowCloseBtn", "hasHiddenInputActionEntrancesForSpecialPanel", "setupCloseBtn", "resetCloseBtn", "setupPanelVisible", "resetChangeOnView", "setupInputBackground", "resetInputBackground", "setupContentContainer", "getContentView", "bindStartPanelView", "openedSpecialInputStatus", "getOpenedSpecialInputStatus", "()Lcom/obric/assistant/ability/ObricSpecialInputStatus;", "isAttachmentSupportedScene", "isSpecialFileUploadSupported", "isNormalFileUploadSupported", "isFileInputSupported", "isStartTaskScene", "syncFileInputState", "clearSuggestedActionState", "refreshSpecialInputAttachmentUi", "ensureAttachmentReadyToSendStatus", "alignResourceBarWithUpperContent", "suppressSpecialInputSuggestedActions", "keepInputAreaAttachedToSpecialPanel", "applyAfterPublicAttachmentRestore", "applyNoTopCornerInputBackground", "setPhoneOperationSkillActionBarVisibleForAttachment", "visible", "moveResourceBarToSpecialHolder", "restoreResourceBarToDefaultHolder", "obtainResourceBarAttachmentHolderSafely", "configureSpecialInputMenuEntranceForceShow", "enable", "persistPhoneOperationAttachmentDraftContextIfNeeded", "buildCurrentSpecialPanelDraftContext", "Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftContext;", "buildSpecialPanelDraftContext", "shouldHandleSpecialInputAttachmentDraft", "currentPhoneOperationAttachmentDraftContext", "Lcom/obric/assistant/special_input/PhoneOperationAttachmentDraftContext;", "reconcilePhoneOperationAttachmentDraftIfReady", "handleSpecialPanelRestoreResult", "context", "panelContext", "localMsgId", WindowEvent.Params.RESULT, "Lcom/obric/assistant/special_input/ObricSpecialInputComponent$SpecialPanelRestoreResult;", "isMatchingSpecialPanelDraft", "restoreSpecialPanelFromAttachmentDraft", "(Lcom/obric/assistant/special_input/PhoneOperationSpecialPanelDraftContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreQuickInstructionPanel", "restoreClarifyPanel", "restoreAdditionPanel", "buildRestoredReplyPanelState", "referenceMessageContent", "openRestoredReplyPanel", "discardPhoneOperationAttachmentDraft", WindowEvent.Params.REASON, "clearPhoneOperationAttachmentDraftContext", "conversationId", "clearFileInputOverrides", "clearSpecialInputAttachmentState", "buildMultiRowsPanelInstructions", "container", "items", "", "Lcom/obric/assistant/special_input/instruction/PanelInstructionItem;", "buildMultiRowsInstructions", "updateSuggestedInstructionItems", "buildPanelRow", "rowLayout", "row", "handlePanelInstructionClick", "prepareChatListForSuggestedSend", "getPanelInstructionSendMessageExt", "buildInnerView", "parent", "s", "applyGradient", "Landroidx/appcompat/widget/AppCompatTextView;", "gradientColor", "", "updateTextViewStyle", "setupScrollContainer", "resetContentContainer", "ensureComponentScrollContainerHeight", "forceRecalculate", "measureWidgetContainerHeight", "scrollContainer", "setupActionBarContainer", "resetActionBarContainer", "panelInstructionLoader", "Lcom/obric/assistant/special_input/instruction/PanelInstructionLoader;", "getPanelInstructionLoader", "()Lcom/obric/assistant/special_input/instruction/PanelInstructionLoader;", "panelInstructionLoader$delegate", "onCreate", "refreshStartPanelTitleActions", "startPanelOpen", "getPanelInstructionRenderRows", "toRenderRows", "maxRows", "isShortcutInstruction", "instructionTextWeight", "onDestroy", "proIcon", "Landroidx/appcompat/widget/LinearLayoutCompat;", "getProIcon", "()Landroidx/appcompat/widget/LinearLayoutCompat;", "proIcon$delegate", "instructionManagerBtn", "getInstructionManagerBtn", "instructionManagerBtn$delegate", "removeInstructionManagerBtn", "addInstructionManagerBtn", "removeProIcon", "addIconTipsBar", "defaultScrollContainerTopToBottom", "defaultScrollContainerTopMargin", "addIconTipsKeva", "Lcom/bytedance/keva/Keva;", "getAddIconTipsKeva", "()Lcom/bytedance/keva/Keva;", "addIconTipsKeva$delegate", "addIconResultReceiver", "Landroid/content/BroadcastReceiver;", "addTaskManagerShortcut", "registerAddIconResultReceiver", "Landroid/content/Context;", "unregisterAddIconResultReceiver", "removeAddIconTipsBar", "shouldShowAddIconTipsBar", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addAddIconTipsBar", "goToComplexAdditionPanel", "getHintContentStyle", "Lcom/obric/assistant/special_input/HintContentStyle;", "simulateMessageListSmallScroll", "isObricSpecialInputOpen", "getIconUrl", "atLeastLong", "findTaskByStateInfo", "isGui", "isClarify", "isAddition", "SpecialPanelRestoreResult", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSpecialInputComponent extends BaseContentWidget implements laa.j {
    public static final /* synthetic */ int G1 = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final CoroutineScope H0;
    public Integer I;
    public boolean J;
    public final StateFlowImpl K;
    public final kotlinx.coroutines.flow.b1 L;
    public final ObricSpecialInputComponent$imeListener$1 L0;
    public final List<laa.u> M;
    public final List<laa.s> N;
    public final StateFlowImpl O;
    public final kotlinx.coroutines.flow.b1 P;
    public final Lazy P0;
    public com.larus.bmhome.actionbar.model.z0 Q;
    public LayoutObricSpecialInputWidgetV2Binding R;
    public boolean S;
    public boolean T;
    public boolean U;
    public String V;
    public boolean V0;
    public String W;
    public String X;
    public boolean Y;
    public boolean Z;
    public final Lazy b1;
    public final Lazy g1;
    public final Lazy h1;
    public z8.b k0;
    public View k1;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public z8.b p0;
    public Integer p1;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public Integer v1;
    public final Lazy w;
    public final Lazy x;
    public final Lazy x1;
    public final Lazy y;
    public ObricSpecialInputComponent$registerAddIconResultReceiver$receiver$1 y1;
    public final Lazy z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/special_input/ObricSpecialInputComponent$SpecialPanelRestoreResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "PENDING", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SpecialPanelRestoreResult extends Enum<SpecialPanelRestoreResult> {
        public static final SpecialPanelRestoreResult FAILED = null;
        public static final SpecialPanelRestoreResult PENDING = null;
        public static final SpecialPanelRestoreResult SUCCESS = null;
        public static final /* synthetic */ SpecialPanelRestoreResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<SpecialPanelRestoreResult> getEntries() {
            return b;
        }

        static {
            SpecialPanelRestoreResult r0 = new SpecialPanelRestoreResult("SUCCESS", 0);
            SUCCESS = r0;
            SpecialPanelRestoreResult r1 = new SpecialPanelRestoreResult("PENDING", 1);
            PENDING = r1;
            SpecialPanelRestoreResult r3 = new SpecialPanelRestoreResult("FAILED", 2);
            FAILED = r3;
            SpecialPanelRestoreResult[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static SpecialPanelRestoreResult[] values() {
            return (SpecialPanelRestoreResult[]) a.clone();
        }

        public static SpecialPanelRestoreResult valueOf(String r1) {
            return (SpecialPanelRestoreResult) r27.a.a(SpecialPanelRestoreResult.class, r1);
        }

        public SpecialPanelRestoreResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[SpecialPanelRestoreResult.values().length];
            r0[SpecialPanelRestoreResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L26:
            r0[SpecialPanelRestoreResult.PENDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L34:
            r0[SpecialPanelRestoreResult.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L8:
            a = r0;
            int[] r1 = new int[PanelInstructionType.values().length];
            r1[PanelInstructionType.SHORTCUT_SHORT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L28:
            r1[PanelInstructionType.SHORTCUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L36:
            r1[PanelInstructionType.RECOMMEND_MEMORY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L24:
            r1[PanelInstructionType.RECOMMEND_OPERATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L30:
            r1[PanelInstructionType.RECOMMEND_LOCAL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L14:
            b = r1;
        }
    }

    public static final class c implements Function0<maa.e> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
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

    public static final class d implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
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

    public static final class e implements Function0<laa.h> {
        public final /* synthetic */ AttachReceiver a;

        public e(AttachReceiver r1) {
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

    public static final class f implements Function0<u7> {
        public final /* synthetic */ AttachReceiver a;

        public f(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(u7.class));
        }
    }

    public static final class g implements Function0<ada.c> {
        public final /* synthetic */ AttachReceiver a;

        public g(AttachReceiver r1) {
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

    public static final class h implements Function0<com.larus.bmhome.chat.component.bottom.bottommenu.f1> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
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

    public static final class i implements Function0<laa.i> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.i.class));
        }
    }

    public static final class j implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
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

    public static final class k implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
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

    public static final class l implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
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

    public static final class m implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
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

    public static final class n implements Function0<com.larus.bmhome.chat.component.bottom.attachment.g1> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
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

    public static final class o implements Function0<p1> {
        public final /* synthetic */ AttachReceiver a;

        public o(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(p1.class));
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$1", f = "ObricSpecialInputComponent.kt", i = {}, l = {2158}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricSpecialInputComponent this$0;

        public AnonymousClass1(ObricSpecialInputComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ObricSpecialInputComponent r5 = this.this$0;
            int r2 = ObricSpecialInputComponent.G1;
            PanelInstructionLoader r6 = (PanelInstructionLoader) r5.b1.getValue();
            this.label = 1;
            if (r6.e(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$2", f = "ObricSpecialInputComponent.kt", i = {}, l = {2161}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricSpecialInputComponent this$0;

        /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$2$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ObricSpecialInputComponent a;

            public a(ObricSpecialInputComponent r1) {
                this.a = r1;
            }

            public final Object emit(Object r7, Continuation r8) {
                if (((Boolean) r7).booleanValue() == false) goto L9;
                ObricSpecialInputComponent r9 = this.a;
                int r10 = ObricSpecialInputComponent.G1;
                if (r9.j6() == false) goto L9;
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), Dispatchers.getIO(), null, new ObricSpecialInputComponent$refreshInstructionsOnResumeIfNeeded$1(r9, null), 2, null);
            L9:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(ObricSpecialInputComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ObricSpecialInputComponent r6 = this.this$0;
            kotlinx.coroutines.flow.b1 r2 = r6.L;
            a r3 = new a(r6);
            this.label = 1;
            if (r2.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$3", f = "ObricSpecialInputComponent.kt", i = {}, l = {2171, 2171}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricSpecialInputComponent this$0;

        /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "isOpen", "status", "Lcom/obric/assistant/ability/ObricSpecialInputStatus;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$3$1", f = "ObricSpecialInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function3<Boolean, laa.v, Continuation<? super Boolean>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ boolean Z$0;
            int label;

            public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
                super(3, r2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
                return invoke(((Boolean) r1).booleanValue(), (laa.v) r2, (Continuation) r3);
            }

            public final Object invoke(boolean r2, laa.v r3, Continuation<? super Boolean> r4) {
                AnonymousClass1 r0 = new AnonymousClass1(r4);
                r0.Z$0 = r2;
                r0.L$0 = r3;
                return r0.invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L16;
                ResultKt.throwOnFailure(r2);
                boolean r3 = this.Z$0;
                laa.v r0 = (laa.v) this.L$0;
                if (r3 == false) goto L12;
                if (r0 == null) goto L12;
                StateInfo r4 = r0.b;
                if (r4 != null) goto L10;
            L11:
                boolean r5 = true;
            L14:
                return Boxing.boxBoolean(r5);
            L10:
                if (r4.getRequestType() == 0) goto L11;
            L12:
                r5 = false;
                goto L14
            L16:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ObricSpecialInputComponent a;

            public a(ObricSpecialInputComponent r1) {
                this.a = r1;
            }

            public final Object emit(Object r3, Continuation r4) {
                boolean r5 = ((Boolean) r3).booleanValue();
                FLogger.a.i("ObricSpecialInputComponent", "needAddInstructionEntrance: " + r5);
                ObricSpecialInputComponent.Y2(this.a, r5);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(ObricSpecialInputComponent r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L7;
            ResultKt.throwOnFailure(r7);
        L17:
            throw new KotlinNothingValueException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L13:
            a r2 = new a(this.this$0);
            this.label = 2;
            if (((i1) r7).collect(r2, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            ObricSpecialInputComponent r8 = this.this$0;
            kotlinx.coroutines.flow.v0 r5 = new kotlinx.coroutines.flow.v0(r8.L, r8.P, new AnonymousClass1(null));
            LifecycleCoroutineScope r9 = LifecycleOwnerKt.getLifecycleScope(this.this$0);
            this.label = 1;
            r7 = kotlinx.coroutines.flow.e.E(r5, r9, this);
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$4", f = "ObricSpecialInputComponent.kt", i = {}, l = {2189}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricSpecialInputComponent this$0;

        /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$4$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0006H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/bmhome/chat/component/bottom/attachment/entity/ImmutableUplinkFileEntity;", "entities", "<unused var>", "", "Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$4$1", f = "ObricSpecialInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function4<List<? extends id8.f>, String, DMStateInfo, Continuation<? super List<? extends id8.f>>, Object> {
            /* synthetic */ Object L$0;
            int label;

            public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
                super(4, r2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
                return invoke((List) r1, (String) r2, (DMStateInfo) r3, (Continuation) r4);
            }

            public final Object invoke(List<id8.f> r1, String r2, DMStateInfo r3, Continuation<? super List<id8.f>> r4) {
                AnonymousClass1 r5 = new AnonymousClass1(r4);
                r5.L$0 = r1;
                return r5.invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                return (List) this.L$0;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$4$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ObricSpecialInputComponent a;

            public a(ObricSpecialInputComponent r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                this.a.S = !((List) r1).isEmpty();
                this.a.q5();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass4(ObricSpecialInputComponent r1, Continuation<? super AnonymousClass4> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass4(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            ObricSpecialInputComponent r8 = this.this$0;
            int r2 = ObricSpecialInputComponent.G1;
            com.larus.bmhome.chat.component.bottom.attachment.g1 r9 = r8.f70();
            if (r9 == null) goto L26;
            kotlinx.coroutines.flow.b1 r10 = r9.YB();
            if (r10 == null) goto L26;
            laa.i r3 = (laa.i) this.this$0.B.getValue();
            if (r3 == null) goto L24;
            kotlinx.coroutines.flow.b1 r4 = r3.gJ();
            if (r4 == null) goto L24;
            ObricTaskStatusManager.a.getClass();
            FlowKt__ZipKt$combine$.inlined.combineUnsafe.FlowKt__ZipKt.1 r11 = kotlinx.coroutines.flow.e.j(r10, r4, ObricTaskStatusManager.f, new AnonymousClass1(null));
            a r5 = new a(this.this$0);
            this.label = 1;
            if (r11.collect(r5, this) != r0) goto L22;
            return r0;
        L24:
            return Unit.INSTANCE;
        L26:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$5", f = "ObricSpecialInputComponent.kt", i = {}, l = {2196}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricSpecialInputComponent this$0;

        /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onCreate$5$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ObricSpecialInputComponent a;

            public a(ObricSpecialInputComponent r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                boolean r3 = ((Boolean) r1).booleanValue();
                ObricSpecialInputComponent r4 = this.a;
                r4.S = r3;
                r4.s5();
                ObricSpecialInputComponent r5 = this.a;
                if (((Boolean) r5.L.getValue()).booleanValue() == true) goto L5;
            L7:
                boolean r6 = false;
            L8:
                ObricSpecialInputComponent.Y2(r5, r6);
                return Unit.INSTANCE;
            L5:
                if (ObricSpecialInputComponent.V4((laa.v) this.a.P.getValue()) == false) goto L7;
                r6 = true;
                goto L8
            }
        }

        public AnonymousClass5(ObricSpecialInputComponent r1, Continuation<? super AnonymousClass5> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass5(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            ObricSpecialInputComponent r6 = this.this$0;
            int r2 = ObricSpecialInputComponent.G1;
            com.larus.bmhome.chat.component.bottom.attachment.g1 r7 = r6.f70();
            if (r7 == null) goto L18;
            kotlinx.coroutines.flow.b1 r8 = r7.Ry();
            if (r8 == null) goto L18;
            a r3 = new a(this.this$0);
            this.label = 1;
            if (r8.collect(r3, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.special_input.ObricSpecialInputComponent$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$onResume$1", f = "ObricSpecialInputComponent.kt", i = {}, l = {329}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricSpecialInputComponent this$0;

        public C00851(ObricSpecialInputComponent r1, Continuation<? super C00851> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C00851(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            if (((Boolean) r4).booleanValue() == true) goto L15;
            FLogger.a.i("ObricSpecialInputComponent", "onResume: add icon tips bar no longer needed, remove it");
            ObricSpecialInputComponent r5 = this.this$0;
            int r2 = ObricSpecialInputComponent.G1;
            r5.w5();
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ObricSpecialInputComponent r6 = this.this$0;
            this.label = 1;
            r4 = ObricSpecialInputComponent.h3(r6, this);
            if (r4 != r0) goto L12;
            return r0;
        }
    }

    public static final class p implements Function0<bc8.a> {
        public final /* synthetic */ AttachReceiver a;

        public p(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(bc8.a.class));
        }
    }

    public static final class q implements Function0<qaa.a> {
        public final /* synthetic */ AttachReceiver a;

        public q(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(qaa.a.class));
        }
    }

    public static final class r implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public r(AttachReceiver r1) {
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

    public static final class s implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ AppCompatTextView a;
        public final /* synthetic */ ObricSpecialInputComponent b;
        public final /* synthetic */ com.obric.assistant.special_input.a c;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ObricSpecialInputComponent r0 = this.b;
            AppCompatTextView r1 = this.a;
            int[] r2 = this.c.d;
            int r3 = ObricSpecialInputComponent.G1;
            if (r2 == null) goto L5;
            float r7 = RangesKt.coerceAtMost(r1.getPaint().measureText(r1.getText().toString()), (r0.B4() - r1.getPaddingLeft()) - r1.getPaddingRight()) + 0.0f;
            AppHost.Companion r4 = AppHost.a;
            int r5 = ContextCompat.getColor(r4.getApplication(), 2131103812);
            r1.getPaint().setShader(new LinearGradient(0.0f, 0.0f, r7, 0.0f, new int[]{r5, ContextCompat.getColor(r4.getApplication(), 2131103813)}, null, Shader.TileMode.CLAMP));
            r1.setTextColor(r5);
            r1.invalidate();
        L6:
            AppCompatTextView r6 = this.a;
            if (r6.getLineCount() <= 1) goto L9;
            int r8 = 8388611;
        L10:
            r6.setGravity(r8);
            return;
        L9:
            r8 = 17;
            goto L10
        L5:
            r0.getClass();
            goto L6
        }

        public s(AppCompatTextView r1, ObricSpecialInputComponent r2, com.obric.assistant.special_input.a r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void e90() {
        D3(true, "default");
    }

    public final void ed() {
        D3(false, "window_stashed");
    }

    public final void onDestroy() {
        E3(false);
        T5();
        this.R = null;
        R5();
        ObricTaskStatusManager.a.getClass();
        FLogger.a.i("ObricTaskStatusManager", "resetOpenPanelType");
        ObricTaskStatusManager.c = null;
        ObricTaskStatusManager.g(false);
        ObricActionBarTrackServiceExtDelegate.b.e();
        ObricActionBarSendServiceDelegate.b.k(false);
        o6(AppHost.a.getApplication());
    }

    public final int B4() {
        return ((Number) this.P0.getValue()).intValue();
    }

    public final void C3() {
        String r1 = "";
        if (this.S == false) goto L5;
    L19:
        boolean r0 = true;
    L20:
        E3(false);
        T5();
        if (r0 == true) goto L23;
        return;
    L23:
        this.U = false;
        this.S = false;
        com.larus.bmhome.chat.component.cvs.y r2 = a4();
        if (r2 == null) goto L26;
        String r3 = r2.Y1();
    L27:
        if (r3 == null) goto L30;
        r1 = r3;
    L30:
        B3(r1);
        FLogger.a.i("ObricSpecialInputComponent", "[SpecialInputAttachment] clear managed attachment state");
        com.larus.bmhome.chat.component.bottom.attachment.g1 r4 = f70();
        if (r4 == null) goto L33;
        com.larus.bmhome.chat.component.bottom.attachment.g1.a.a(r4, null, 7);
    L33:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r5 = f70();
        if (r5 == null) goto L37;
        r5.W0();
        return;
    L37:
        return;
    L26:
        r3 = null;
        goto L27
    L5:
        if (this.U == true) goto L19;
        com.larus.bmhome.chat.component.cvs.y r6 = a4();
        if (r6 == null) goto L9;
        String r7 = r6.Y1();
    L10:
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        o0.a.getClass();
        k0 r8 = o0.b(r7);
        if (r8 == null) goto L15;
        q0 r9 = r8.d;
    L16:
        if (r9 != null) goto L19;
        r0 = false;
        goto L20
    L15:
        r9 = null;
        goto L16
    L9:
        r7 = null;
        goto L10
    }

    public final void HY() {
        if (this.J == true) goto L5;
        return;
    L5:
        FLogger.a.i("ObricSpecialInputComponent", "restoreContentAfterFullScreenIme");
        ScrollView r0 = Z3();
        if (r0 == null) goto L8;
        com.larus.utils.e1.x(r0);
    L8:
        ScrollView r1 = Z3();
        if (r1 == null) goto L11;
        r1.post(new a0(this));
    L11:
        View r2 = e4();
        if (r2 == null) goto L14;
        com.larus.utils.e1.x(r2);
    L14:
        this.J = false;
    }

    public final void R5() {
        if (this.V0 == true) goto L9;
        ada.c r0 = W3();
        if (r0 == null) goto L38;
        r0.b5(com.obric.assistant.task.skill.f.d());
        return;
    L38:
        return;
    L9:
        if (com.obric.assistant.task.skill.f.d() == false) goto L20;
        com.larus.bmhome.chat.component.cvs.y r1 = a4();
        if (r1 == null) goto L13;
        wc9.e r2 = r1.h();
    L15:
        if (com.larus.bmhome.utils.i.h(r2) == false) goto L20;
        FLogger.a.i("ObricSpecialInputComponent", "restoreInputActionEntrancesAfterSpecialPanel, keep phone operation media entrances");
        this.V0 = false;
        FrameLayout r3 = (FrameLayout) this.E.getValue();
        if (r3 == null) goto L39;
        r3.post(new v(this));
        return;
    L39:
        return;
    L13:
        r2 = null;
    L20:
        ICoreInputAbility r4 = c4();
        if (r4 == null) goto L25;
        CoreInputAbility r5 = r4.JO();
        if (r5 == null) goto L25;
        r5.S8(false);
    L25:
        ICoreInputAbility r6 = c4();
        if (r6 == null) goto L28;
        r6.uq(true);
    L28:
        ICoreInputAbility r7 = c4();
        if (r7 == null) goto L31;
        r7.rE();
    L31:
        ICoreInputAbility r8 = c4();
        if (r8 == null) goto L34;
        r8.zM();
    L34:
        this.V0 = false;
        ada.c r9 = W3();
        if (r9 == null) goto L40;
        r9.b5(false);
        return;
    }

    public final boolean Re() {
        kotlinx.coroutines.flow.b1 r0 = this.L;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L29;
        kotlinx.coroutines.flow.b1 r2 = this.P;
        if (r2 == null) goto L16;
        laa.v r3 = (laa.v) r2.getValue();
        if (r3 == null) goto L16;
        StateInfo r4 = r3.b;
        if (r4 == null) goto L16;
        Integer r5 = Integer.valueOf(r4.getRequestType());
    L17:
        if (r5 != null) goto L19;
    L20:
        if (r5 != null) goto L23;
    L25:
        boolean r6 = false;
    L26:
        if (r6 == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        if (r5.intValue() != 2) goto L25;
    L24:
        r6 = true;
        goto L26
    L19:
        if (r5.intValue() == 1) goto L24;
    L16:
        r5 = null;
        goto L17
    L29:
        return false;
    L5:
        if (((Boolean) r0.getValue()).booleanValue() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void T5() {
        if (this.T == true) goto L10;
        LayoutObricSpecialInputWidgetV2Binding r0 = this.R;
        if (r0 == null) goto L49;
        FrameLayout r1 = r0.b;
        if (r1 == null) goto L50;
        com.larus.utils.e1.o(r1);
        return;
    L50:
        return;
    L49:
        return;
    L10:
        ViewGroup r2 = null;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r3 = f70();     // Catch: UninitializedPropertyAccessException -> L15
        if (r3 == null) goto L17;
        ViewGroup r4 = r3.YK();     // Catch: UninitializedPropertyAccessException -> L15
    L18:
        if (r4 != null) goto L20;
        return;
    L20:
        LayoutObricSpecialInputWidgetV2Binding r5 = this.R;
        if (r5 == null) goto L23;
        FrameLayout r6 = r5.b;
    L25:
        if (r4.getChildCount() <= 0) goto L27;
        View r7 = r4.getChildAt(0);
    L32:
        if (r7 != null) goto L36;
        this.T = false;
        return;
    L36:
        if (Intrinsics.areEqual(r7.getParent(), r4) == true) goto L43;
        ViewParent r8 = r7.getParent();
        if ((r8 instanceof ViewGroup) == false) goto L40;
        r2 = (ViewGroup) r8;
    L40:
        if (r2 == null) goto L42;
        r2.removeView(r7);
    L42:
        r4.addView(r7);
        FLogger.a.i("ObricSpecialInputComponent", "[SpecialInputAttachment] resource bar restored to default holder");
    L43:
        this.T = false;
        if (r6 == null) goto L51;
        com.larus.utils.e1.o(r6);
        return;
    L51:
        return;
    L27:
        if (r6 != null) goto L29;
    L31:
        r7 = null;
        goto L32
    L29:
        if (r6.getChildCount() <= 0) goto L31;
        r7 = r6.getChildAt(0);
        goto L32
    L23:
        r6 = null;
    L17:
        r4 = null;
    L15:
        e = move-exception;
        FLogger.a.w("ObricSpecialInputComponent", "[SpecialInputAttachment] attachment panel view is not ready", e);
        goto L17
    }

    public final ada.c W3() {
        return (ada.c) this.z.getValue();
    }

    public final va8.o X3() {
        return (va8.o) this.p.getValue();
    }

    public final com.larus.bmhome.chat.component.cvs.y a4() {
        return (com.larus.bmhome.chat.component.cvs.y) this.w.getValue();
    }

    public final ICoreInputAbility c4() {
        return (ICoreInputAbility) this.o.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.attachment.g1 f70() {
        return (com.larus.bmhome.chat.component.bottom.attachment.g1) this.q.getValue();
    }

    public final void i5() {
        if (this.Y == false) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r0 = f70();
        if (r0 == null) goto L8;
        List r1 = r0.q1();
    L9:
        if (r1 != null) goto L12;
        r1 = CollectionsKt.emptyList();
    L12:
        if (r1.isEmpty() == false) goto L14;
        return;
    L14:
        com.larus.bmhome.chat.component.cvs.y r3 = a4();
        if (r3 == null) goto L17;
        String r4 = r3.Y1();
    L18:
        String r5 = "";
        if (r4 != null) goto L21;
        r4 = "";
    L21:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r6 = f70();
        if (r6 == null) goto L24;
        String r7 = r6.Wv();
    L25:
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        boolean r13 = true;
        if (r4.length() != 0) goto L30;
        boolean r8 = true;
    L31:
        if (r8 == false) goto L33;
        return;
    L33:
        if (r7.length() != 0) goto L35;
        boolean r9 = true;
    L36:
        if (r9 == true) goto L275;
        o0.a.getClass();
        k0 r10 = o0.b(r4);
        List r2 = r1;
        if ((r2 instanceof Collection) == true) goto L41;
    L43:
        Iterator r11 = r2.iterator();
    L45:
        if (r11.hasNext() == false) goto L49;
        if (Intrinsics.areEqual(((UplinkFileEntity) r11.next()).isFromDraft(), Boolean.TRUE) == false) goto L45;
        boolean r12 = true;
    L50:
        if (r12 == false) goto L61;
        if (r10 == null) goto L53;
        String r14 = r10.b;
    L55:
        if (Intrinsics.areEqual(r14, r7) == false) goto L61;
        if (Intrinsics.areEqual(this.W, r7) == true) goto L61;
        this.V = r7;
        return;
    L53:
        r14 = null;
    L61:
        if (((Boolean) this.L.getValue()).booleanValue() == true) goto L63;
    L65:
        boolean r15 = false;
    L66:
        laa.v r16 = (laa.v) this.P.getValue();
        if (((Boolean) this.L.getValue()).booleanValue() == true) goto L69;
    L168:
        q0 r17 = null;
    L169:
        if (r15 == false) goto L172;
        if (r17 != null) goto L172;
        return;
    L172:
        if (r17 != null) goto L174;
        boolean r18 = t1.a.r();
    L175:
        if (r18 == true) goto L177;
        return;
    L177:
        AtomicBoolean r19 = com.obric.assistant.task.skill.m.a;
        com.larus.bmhome.instruction.g r20 = j4();
        if (r20 == null) goto L184;
        ReplyOption r21 = r20.Ql();
        if (r21 == null) goto L184;
        ModelItemIdentity r22 = r21.getModel();
        if (r22 == null) goto L184;
        Integer r23 = Integer.valueOf(r22.getDeprecatedItemId());
    L186:
        if (com.obric.assistant.task.skill.m.j(r23) == false) goto L188;
    L191:
        boolean r24 = true;
    L192:
        if (r17 != null) goto L195;
        if (r24 == true) goto L195;
        return;
    L195:
        if (r10 != null) goto L197;
    L202:
        List<String> r25 = null;
    L203:
        if (r25 != null) goto L205;
        r25 = CollectionsKt.emptyList();
    L205:
        Set r26 = CollectionsKt.toSet(r25);
        ArrayList r27 = new ArrayList();
        Iterator r28 = r2.iterator();
    L207:
        if (r28.hasNext() == false) goto L231;
        UplinkFileEntity r29 = (UplinkFileEntity) r28.next();
        String r110 = r29.getFileIdentifier();
        if (r110 != null) goto L211;
    L228:
        r110 = null;
    L229:
        if (r110 == null) goto L207;
        r27.add(r110);
        goto L207
    L211:
        if (r110.length() <= 0) goto L213;
        boolean r111 = true;
    L214:
        if (r111 == true) goto L217;
        r110 = null;
    L217:
        if (r110 == null) goto L228;
        if (Intrinsics.areEqual(r29.isFromDraft(), Boolean.TRUE) == true) goto L222;
    L225:
        boolean r30 = true;
    L226:
        if (r30 == false) goto L228;
    L222:
        if (r26.contains(r110) == true) goto L225;
        r30 = false;
        goto L226
    L213:
        r111 = false;
        goto L214
    L231:
        List r112 = CollectionsKt.distinct(r27);
        if (r112.isEmpty() == false) goto L242;
        if (r10 == null) goto L235;
        String r31 = r10.b;
    L237:
        if (Intrinsics.areEqual(r31, r7) == true) goto L239;
        return;
    L239:
        if ((!r26.isEmpty()) == false) goto L273;
        B3(r4);
        return;
    L273:
        return;
    L235:
        r31 = null;
        goto L237
    L242:
        o0 r32 = o0.a;
        k0 r113 = new k0(true, r7, r112, r17, System.currentTimeMillis());
        r32.getClass();
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r113, "context");
        if (StringsKt.isBlank(r4) == false) goto L262;
    L252:
        this.V = r7;
        if (r17 != null) goto L256;
        r13 = false;
    L256:
        this.U = r13;
        FLogger r33 = FLogger.a;
        StringBuilder r34 = new StringBuilder("[PhoneAttachmentDraft] persisted, localMsgId=");
        r34.append(r7);
        r34.append(", count=");
        r34.append(r112.size());
        r34.append(", panel=");
        if (r17 == null) goto L259;
        Integer r35 = Integer.valueOf(r17.a);
    L260:
        r34.append(r35);
        r33.i("ObricSpecialInputComponent", r34.toString());
        return;
    L259:
        r35 = null;
        goto L260
    L262:
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L247
        Gson r37 = (Gson) o0.c.getValue();     // Catch: Throwable -> L247
        int r38 = l0.a;     // Catch: Throwable -> L247
        long r210 = System.currentTimeMillis();     // Catch: Throwable -> L247
        boolean r39 = r113.a;     // Catch: Throwable -> L247
        String r40 = r113.b;     // Catch: Throwable -> L247
        List<String> r114 = r113.c;     // Catch: Throwable -> L247
        q0 r41 = r113.d;     // Catch: Throwable -> L247
        Intrinsics.checkNotNullParameter(r40, "localMsgId");     // Catch: Throwable -> L247
        Intrinsics.checkNotNullParameter(r114, "fileIdentifiers");     // Catch: Throwable -> L247
        ((Keva) o0.d.getValue()).storeString("draft_" + r4, r37.toJson(l0.a.a(new k0(r39, r40, r114, r41, r210))));     // Catch: Throwable -> L247
        Object r42 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L247
    L249:
        Throwable r43 = Result.exceptionOrNull-impl(r42);
        if (r43 == null) goto L252;
        FLogger.a.w("PhoneAttachmentDraftStore", "save failed, conversationId=".concat(r4), r43);
    L247:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r42 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L249
    L197:
        if (Intrinsics.areEqual(r10.b, r7) == false) goto L199;
        k0 r45 = r10;
    L200:
        if (r45 == null) goto L202;
        r25 = r45.c;
        goto L203
    L199:
        r45 = null;
        goto L200
    L188:
        if (com.obric.assistant.task.skill.f.d() == true) goto L191;
        r24 = false;
    L184:
        r23 = null;
        goto L186
    L174:
        r18 = t1.a.o1();
        goto L175
    L69:
        if (F4(r16) == false) goto L168;
        if (r16 == null) goto L75;
        StateInfo r46 = r16.b;
        if (r46 == null) goto L75;
        int r47 = r46.getRequestType();
    L76:
        if (r47 != 0) goto L86;
        com.larus.bmhome.actionbar.model.z0 r115 = this.Q;
        if (r115 != null) goto L80;
    L82:
        boolean r116 = false;
    L83:
        if (r116 == true) goto L86;
    L80:
        if (Intrinsics.areEqual(r115.b, "obric_quick_instruction") != true) goto L82;
        r116 = true;
    L86:
        if (r47 != 2) goto L100;
        if (r16 == null) goto L91;
        StateInfo r48 = r16.b;
        if (r48 == null) goto L91;
        String r49 = r48.getRefMessageId();
    L92:
        if (r49 != null) goto L94;
    L97:
        boolean r50 = true;
    L98:
        if (r50 == false) goto L100;
    L94:
        if (r49.length() == 0) goto L97;
        r50 = false;
    L91:
        r49 = null;
    L100:
        if (r16 == null) goto L102;
        StateInfo r51 = r16.b;
    L103:
        if (r16 == null) goto L105;
        DMTaskState r52 = r16.a;
    L106:
        if (r51 == null) goto L108;
        Map r117 = r51.getExt();
    L109:
        if (r51 == null) goto L111;
        int r118 = r51.getRequestType();
    L112:
        if (r118 != 0) goto L114;
        boolean r119 = true;
    L115:
        if (r119 == false) goto L117;
        String r120 = "phone_operation_quick_instruction";
    L118:
        String r121 = com.obric.assistant.utils.l.d(r52);
        if (r121.length() != 0) goto L121;
        boolean r122 = true;
    L122:
        if (r122 == false) goto L129;
        if (r117 == null) goto L125;
        r121 = (String) r117.get("o_omni_task_id");
    L126:
        if (r121 != null) goto L129;
        r121 = "";
        goto L129
    L125:
        r121 = null;
    L129:
        if (r121.length() <= 0) goto L131;
        boolean r123 = true;
    L132:
        if (r123 == false) goto L134;
        String r124 = r121;
    L135:
        if (r51 == null) goto L144;
        String r125 = r51.getRefMessageId();
        if (r125 == null) goto L144;
        if (r125.length() <= 0) goto L141;
        boolean r126 = true;
    L142:
        if (r126 == false) goto L144;
        String r127 = r125;
    L145:
        if (r117 == null) goto L147;
        String r211 = (String) r117.get("source_from");
    L148:
        if (r51 == null) goto L150;
        String r53 = com.obric.assistant.utils.m.a(r51);
    L151:
        if (r53 == null) goto L155;
        r5 = r53;
    L155:
        if (r5.length() != 0) goto L157;
        boolean r54 = true;
    L158:
        if (r54 == false) goto L161;
        r5 = com.obric.assistant.utils.l.b(r52);
    L161:
        if (r5.length() <= 0) goto L163;
        boolean r55 = true;
    L164:
        if (r55 == false) goto L166;
        String r212 = r5;
    L167:
        r17 = new q0(r118, r120, r124, r127, r211, r212);
        goto L169
    L166:
        r212 = null;
        goto L167
    L163:
        r55 = false;
        goto L164
    L157:
        r54 = false;
        goto L158
    L150:
        r53 = null;
        goto L151
    L147:
        r211 = null;
        goto L148
    L141:
        r126 = false;
    L144:
        r127 = null;
        goto L145
    L134:
        r124 = null;
        goto L135
    L131:
        r123 = false;
        goto L132
    L121:
        r122 = false;
        goto L122
    L117:
        r120 = null;
        goto L118
    L114:
        r119 = false;
        goto L115
    L111:
        r118 = 0;
        goto L112
    L108:
        r117 = null;
        goto L109
    L105:
        r52 = null;
        goto L106
    L102:
        r51 = null;
    L75:
        r47 = 0;
        goto L76
    L63:
        if (F4((laa.v) this.P.getValue()) == false) goto L65;
        r15 = true;
    L49:
        r12 = false;
        goto L50
    L41:
        if (r2.isEmpty() == false) goto L43;
    L275:
        return;
    L35:
        r9 = false;
        goto L36
    L30:
        r8 = false;
        goto L31
    L24:
        r7 = null;
        goto L25
    L17:
        r4 = null;
        goto L18
    L8:
        r1 = null;
        goto L9
    }

    public final com.larus.bmhome.instruction.g j4() {
        return (com.larus.bmhome.instruction.g) this.n.getValue();
    }

    public final boolean j6() {
        laa.v r0 = (laa.v) this.P.getValue();
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L14;
        if (r0 == null) goto L6;
        ObricSpecialInputScene r1 = r0.c;
    L8:
        if (r1 != ObricSpecialInputScene.COMPLEX_TASK) goto L14;
        StateInfo r2 = r0.b;
        if (r2 != null) goto L12;
    L13:
        return true;
    L12:
        if (r2.getRequestType() != 0) goto L14;
    L6:
        r1 = null;
    L14:
        return false;
    }

    public final b2 k4() {
        return (b2) this.H.getValue();
    }

    public final void onPause() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onPause: isWindowDismiss ");
        laa.d r2 = q4();
        boolean r3 = false;
        if (r2 == null) goto L9;
        ObricFloatChatPageState r4 = r2.getPageState();
        if (r4 == null) goto L9;
        ObricFloatChatPageData.Companion.getClass();
        if ((r4 instanceof vda.b) != true) goto L9;
        boolean r5 = true;
    L10:
        r1.append(r5);
        r1.append(", isDismissWindowCloseBtn false, currentScene ");
        laa.v r6 = (laa.v) this.P.getValue();
        ObricSpecialInputScene r7 = null;
        if (r6 == null) goto L13;
        ObricSpecialInputScene r8 = r6.c;
    L14:
        r1.append(r8);
        r0.i("ObricSpecialInputComponent", r1.toString());
        laa.d r9 = q4();
        if (r9 == null) goto L21;
        ObricFloatChatPageState r10 = r9.getPageState();
        if (r10 == null) goto L21;
        ObricFloatChatPageData.Companion.getClass();
        if ((r10 instanceof vda.b) != true) goto L21;
        r3 = true;
    L21:
        if (r3 == false) goto L30;
        laa.v r11 = (laa.v) this.P.getValue();
        if (r11 == null) goto L26;
        r7 = r11.c;
    L26:
        if (r7 == ObricSpecialInputScene.COMPLEX_TASK) goto L31;
        e90();
        return;
    L31:
        return;
    L30:
        return;
    L13:
        r8 = null;
    L9:
        r5 = false;
        goto L10
    }

    public final void onResume() {
        boolean r3 = true;
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L19;
        ada.c r0 = W3();
        if (r0 == null) goto L11;
        String r1 = r0.N5();
        if (r1 == null) goto L11;
        if (com.larus.utils.o0.d(r1) != true) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L19;
        ada.b r4 = W3();
        if ((r4 instanceof ada.b) == false) goto L16;
        ada.b r5 = r4;
    L17:
        if (r5 == null) goto L19;
        r5.g2(3, true);
        goto L19
    L16:
        r5 = null;
    L11:
        r2 = false;
    L19:
        t1 r6 = t1.a;
        if (r6.getAutoGuiEnabledScene() != 0) goto L22;
        FLogger.a.i("ObricSpecialInputComponent", "auto gui switch off, close special input panel");
        e90();
    L22:
        View r7 = this.k1;
        if (r7 == null) goto L25;
        ViewParent r8 = r7.getParent();
    L26:
        if (r8 == null) goto L29;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C00851(this, null), 3, null);
    L29:
        if (AppHost.a.a().isAppBackground() == true) goto L37;
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L37;
        com.obric.assistant.live.api.j r9 = com.obric.assistant.live.api.j.a;
        if (r9.e() == false) goto L37;
        r9.m(true);
        return;
    L37:
        if (r6.o1() == false) goto L50;
        com.larus.bmhome.chat.component.cvs.y r10 = a4();
        if (r10 == null) goto L41;
        String r11 = r10.Y1();
    L42:
        if (r11 != null) goto L44;
        r11 = "";
    L44:
        o0.a.getClass();
        k0 r12 = o0.b(r11);
        if (r12 == null) goto L47;
        q0 r13 = r12.d;
    L48:
        if (r13 == null) goto L50;
    L51:
        if (r3 == false) goto L55;
        bc8.a r14 = (bc8.a) this.s.getValue();
        if (r14 == null) goto L55;
        r14.mX();
    L55:
        q5();
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L62;
        if (R4(p4()) == false) goto L60;
        m6(false);
        goto L62
    L60:
        C3();
        s5();
    L62:
        if (j6() == false) goto L66;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ObricSpecialInputComponent$refreshInstructionsOnResumeIfNeeded$1(this, null), 2, null);
        return;
    L66:
        return;
    L47:
        r13 = null;
        goto L48
    L41:
        r11 = null;
    L50:
        r3 = false;
        goto L51
    L25:
        r8 = null;
        goto L26
    }

    public final void onStop() {
        ObricLiveServiceDelegate.b.c();
    }

    public final boolean or() {
        if (((Boolean) this.L.getValue()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (R4((laa.v) this.P.getValue()) == false) goto L7;
        return true;
    }

    public final laa.v p4() {
        laa.v r0 = (laa.v) this.P.getValue();
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L7;
        return r0;
    }

    public final void ph() {
        int[] r1 = new int[2];
        RecyclerView r2 = (RecyclerView) this.D.getValue();
        if (r2 == null) goto L5;
        r2.getLocationOnScreen(r1);
    L5:
        int r3 = r1[0];
        int r4 = r1[1] + 10;
        double r5 = ((double) r4) + 0.1d;
        float r6 = r3 + 10;
        MotionEvent r7 = MotionEvent.obtain(0, 0, 0, r6, r4, 0);
        RecyclerView r8 = (RecyclerView) this.D.getValue();
        if (r8 == null) goto L8;
        r8.dispatchTouchEvent(r7);
    L8:
        r7.recycle();
        float r9 = (float) r5;
        MotionEvent r10 = MotionEvent.obtain(0, 17, 2, r6, r9, 0);
        RecyclerView r11 = (RecyclerView) this.D.getValue();
        if (r11 == null) goto L11;
        r11.dispatchTouchEvent(r10);
    L11:
        r10.recycle();
        MotionEvent r12 = MotionEvent.obtain(0, 35, 1, r6, r9, 0);
        RecyclerView r13 = (RecyclerView) this.D.getValue();
        if (r13 == null) goto L14;
        r13.dispatchTouchEvent(r12);
    L14:
        r12.recycle();
    }

    public final laa.d q4() {
        return (laa.d) this.u.getValue();
    }

    public final void q5() {
        if (this.Y == false) goto L5;
        return;
    L5:
        i5();
        com.larus.bmhome.chat.component.cvs.y r0 = a4();
        String r1 = null;
        Integer r2 = null;
        r2 = null;
        r2 = null;
        String r3 = null;
        if (r0 == null) goto L8;
        String r4 = r0.Y1();
    L10:
        if (r4 != null) goto L12;
        String r7 = "";
    L13:
        o0.a.getClass();
        k0 r8 = o0.b(r7);
        if (r8 != null) goto L16;
        return;
    L16:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r5 = f70();
        if (r5 == null) goto L19;
        String r6 = r5.Wv();
    L20:
        if (r6 != null) goto L22;
        String r9 = "";
    L23:
        com.larus.bmhome.chat.component.bottom.attachment.g1 r10 = f70();
        if (r10 == null) goto L26;
        List r11 = r10.q1();
    L27:
        if (r11 != null) goto L30;
        r11 = CollectionsKt.emptyList();
    L30:
        if (r11.isEmpty() == true) goto L32;
        boolean r12 = true;
        boolean r13 = false;
        if (r9.length() != 0) goto L38;
        boolean r14 = true;
    L39:
        if (r14 == false) goto L41;
    L163:
        B3(r7);
        return;
    L41:
        if (Intrinsics.areEqual(r8.b, r9) == false) goto L163;
        this.V = r9;
        q0 r15 = r8.d;
        if (r15 != null) goto L46;
        boolean r16 = t1.a.r();
    L47:
        if (r16 == true) goto L51;
        G3(r8, "file_upload_disabled");
        return;
    L51:
        if (Intrinsics.areEqual(this.W, r9) == false) goto L54;
        return;
    L54:
        if (r15 != null) goto L84;
        laa.i r17 = (laa.i) this.B.getValue();
        if (r17 == null) goto L60;
        kotlinx.coroutines.flow.b1 r18 = r17.gJ();
        if (r18 == null) goto L60;
        String r19 = (String) r18.getValue();
    L62:
        if (Intrinsics.areEqual(r19, r7) == true) goto L65;
        FLogger.a.i("ObricSpecialInputComponent", "[PhoneAttachmentDraft] wait reply mode restore, conversationId=".concat(r7));
        return;
    L65:
        com.larus.bmhome.instruction.g r20 = j4();
        if (r20 == null) goto L72;
        ReplyOption r21 = r20.Ql();
        if (r21 == null) goto L72;
        ModelItemIdentity r22 = r21.getModel();
        if (r22 == null) goto L72;
        r2 = Integer.valueOf(r22.getDeprecatedItemId());
    L72:
        AtomicBoolean r23 = com.obric.assistant.task.skill.m.a;
        if (com.obric.assistant.task.skill.m.j(r2) == true) goto L81;
        PhoneOperationModeRestoreResult r24 = p0.a(j4(), "normal_attachment_draft", false);
        Intrinsics.checkNotNullParameter(r24, "<this>");
        if (r24 == PhoneOperationModeRestoreResult.READY) goto L78;
        r12 = false;
    L78:
        if (r12 == true) goto L81;
        G3(r8, "phone_operation_mode_unavailable:" + r2);
        return;
    L81:
        this.W = r9;
        FLogger.a.i("ObricSpecialInputComponent", "[PhoneAttachmentDraft] normal input draft retained");
        return;
    L60:
        r19 = null;
        goto L62
    L84:
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L159;
        laa.v r25 = (laa.v) this.P.getValue();
        if (r25 != null) goto L89;
    L154:
        if (r13 == false) goto L156;
        this.W = r9;
        return;
    L156:
        FLogger.a.i("ObricSpecialInputComponent", "[PhoneAttachmentDraft] wait current special panel close, requestType=" + r15.a);
        return;
    L89:
        if (r25.c != ObricSpecialInputScene.COMPLEX_TASK) goto L154;
        StateInfo r26 = r25.b;
        if (r26 == null) goto L94;
        int r27 = r26.getRequestType();
    L96:
        if (r27 != r15.a) goto L154;
        if (r27 == 0) goto L143;
        if (r27 != 1) goto L101;
        String r28 = r15.c;
        if (r28 != null) goto L120;
    L128:
        String r29 = r15.d;
        if (r29 != null) goto L131;
    L152:
        r12 = false;
    L153:
        r13 = r12;
        goto L154
    L131:
        if (r29.length() > 0) goto L134;
        r12 = false;
    L134:
        if (r12 == true) goto L137;
        r29 = null;
    L137:
        if (r29 == null) goto L152;
        StateInfo r30 = r25.b;
        if (r30 == null) goto L141;
        r1 = r30.getRefMessageId();
    L141:
        r12 = Intrinsics.areEqual(r1, r29);
        goto L153
    L120:
        if (r28.length() <= 0) goto L122;
        boolean r31 = true;
    L123:
        if (r31 == true) goto L126;
        r28 = null;
    L126:
        if (r28 == null) goto L128;
        r12 = Intrinsics.areEqual(com.obric.assistant.utils.l.d(r25.a), r28);
        goto L153
    L122:
        r31 = false;
        goto L123
    L101:
        if (r27 != 2) goto L152;
        String r32 = r15.d;
        if (r32 == null) goto L152;
        if (r32.length() > 0) goto L109;
        r12 = false;
    L109:
        if (r12 == true) goto L112;
        r32 = null;
    L112:
        if (r32 == null) goto L152;
        StateInfo r33 = r25.b;
        if (r33 == null) goto L116;
        r3 = r33.getRefMessageId();
    L116:
        r12 = Intrinsics.areEqual(r3, r32);
        goto L153
    L143:
        if (Intrinsics.areEqual(r15.b, "phone_operation_quick_instruction") == false) goto L152;
        com.larus.bmhome.actionbar.model.z0 r34 = this.Q;
        if (r34 != null) goto L147;
    L149:
        boolean r35 = false;
    L150:
        if (r35 == false) goto L152;
    L147:
        if (Intrinsics.areEqual(r34.b, "obric_quick_instruction") != true) goto L149;
        r35 = true;
        goto L150
    L94:
        r27 = 0;
        goto L96
    L159:
        if (Intrinsics.areEqual(this.X, r9) == false) goto L161;
        return;
    L161:
        this.X = r9;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricSpecialInputComponent$reconcilePhoneOperationAttachmentDraftIfReady$1(this, r15, r9, r7, r8, null), 3, null);
        return;
    L46:
        r16 = t1.a.o1();
        goto L47
    L38:
        r14 = false;
        goto L39
    L32:
        if (Intrinsics.areEqual(this.V, r8.b) == false) goto L165;
        B3(r7);
        return;
    L165:
        return;
    L26:
        r11 = null;
        goto L27
    L22:
        r9 = r6;
        goto L23
    L19:
        r6 = null;
        goto L20
    L12:
        r7 = r4;
        goto L13
    L8:
        r4 = null;
        goto L10
    }

    public final void s5() {
        LayoutObricSpecialInputWidgetV2Binding r1 = this.R;
        if (r1 != null) goto L5;
        return;
    L5:
        laa.v r2 = p4();
        if (r2 != null) goto L9;
        r2 = (laa.v) this.P.getValue();
    L9:
        if (F4(r2) == true) goto L15;
        U5();
        com.larus.utils.e1.o(r1.c);
        com.larus.utils.e1.o(r1.b);
        com.larus.utils.e1.o(r1.f);
        View r0 = e4();
        if (r0 == null) goto L13;
        com.larus.utils.e1.o(r0);
    L13:
        T5();
        return;
    L15:
        boolean r3 = V4(r2);
        int r5 = 0;
        if (R4(r2) == true) goto L18;
    L76:
        U5();
        m3(r1);
        com.larus.utils.e1.o(r1.b);
        HorizontalScrollView r4 = r1.f;
        if (r3 == true) goto L80;
        r5 = 8;
    L80:
        r4.setVisibility(r5);
        T5();
        W4(true);
    L81:
        if (r3 == false) goto L83;
    L85:
        View r6 = e4();
        if (r6 == null) goto L88;
        com.larus.utils.e1.x(r6);
    L88:
        ScrollView r7 = Z3();
        if (r7 == null) goto L94;
        r7.post(new z(this));
        return;
    L94:
        return;
    L83:
        if (r1.c.getChildCount() <= 0) goto L85;
        com.larus.utils.e1.x(r1.c);
        goto L85
    L18:
        if (this.S == false) goto L76;
        bc8.a r8 = (bc8.a) this.s.getValue();
        if (r8 == null) goto L22;
        r8.mX();
    L22:
        U5();
        com.larus.bmhome.chat.component.bottom.attachment.g1 r9 = f70();
        if (r9 == null) goto L25;
        r9.mO();
    L25:
        m3(r1);
        LayoutObricSpecialInputWidgetV2Binding r10 = this.R;
        if (r10 == null) goto L64;
        FrameLayout r11 = r10.b;
        if (r11 == null) goto L64;
        String r12 = null;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r13 = f70();     // Catch: UninitializedPropertyAccessException -> L35
        if (r13 == null) goto L37;
        ViewGroup r14 = r13.YK();     // Catch: UninitializedPropertyAccessException -> L35
    L38:
        if (r14 == null) goto L64;
        if (r11.getChildCount() <= 0) goto L44;
        View r15 = r11.getChildAt(0);
    L47:
        if (r15 == null) goto L64;
        if (Intrinsics.areEqual(r15.getParent(), r11) == true) goto L63;
        ViewParent r16 = r15.getParent();
        if ((r16 instanceof ViewGroup) == false) goto L54;
        ViewGroup r17 = (ViewGroup) r16;
    L55:
        if (r17 == null) goto L57;
        r17.removeView(r15);
    L57:
        r11.removeAllViews();
        r11.addView(r15);
        FLogger r18 = FLogger.a;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r19 = f70();
        if (r19 == null) goto L60;
        r12 = r19.Wv();
    L60:
        if (r12 != null) goto L62;
        r12 = "";
    L62:
        r18.i("ObricSpecialInputComponent", "[SpecialInputAttachment] resource bar moved to special input, localMsgId=".concat(r12));
        goto L63
    L54:
        r17 = null;
    L63:
        this.T = Intrinsics.areEqual(r15.getParent(), r11);
        goto L64
    L44:
        if (r14.getChildCount() <= 0) goto L46;
        r15 = r14.getChildAt(0);
        goto L47
    L46:
        r15 = null;
    L37:
        r14 = null;
    L35:
        e = move-exception;
        FLogger.a.w("ObricSpecialInputComponent", "[SpecialInputAttachment] attachment panel view is not ready", e);
    L64:
        com.larus.utils.e1.x(r1.b);
        com.larus.utils.e1.o(r1.f);
        W4(false);
        ICoreInputAbility r20 = c4();
        if (r20 != null) goto L67;
    L69:
        if (r5 != 0) goto L73;
        ICoreInputAbility r21 = c4();
        if (r21 == null) goto L73;
        r21.g2(3, true);
    L73:
        ICoreInputAbility r22 = c4();
        if (r22 == null) goto L81;
        r22.eo();
        goto L81
    L67:
        if (r20.Rp() != 3) goto L69;
        r5 = 1;
        goto L69
    }

    public final void td() {
        FLogger.a.i("ObricSpecialInputComponent", "hideContentForFullScreenIme: isVariantInputOpen = " + ((Boolean) this.L.getValue()).booleanValue());
        if (((Boolean) this.L.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (this.J == true) goto L22;
        b2 r0 = k4();
        if (r0 == null) goto L10;
        ConstraintLayout r1 = r0.g();
    L11:
        if (r1 == null) goto L13;
        com.larus.utils.e1.x(r1);
    L13:
        ViewGroup r2 = V3();
        if (r2 == null) goto L16;
        com.larus.utils.e1.x(r2);
    L16:
        ScrollView r3 = Z3();
        if (r3 == null) goto L19;
        com.larus.utils.e1.o(r3);
    L19:
        this.J = true;
        return;
    L10:
        r1 = null;
        goto L11
    }

    public final List<List<PanelInstructionItem>> v4() {
        List<PanelInstructionItem> r0 = ((PanelInstructionLoader) this.b1.getValue()).f;
        if (r0.isEmpty() == true) goto L38;
        int r1 = Math.min(r0.size(), 3);
        ArrayList r2 = new ArrayList(r1);
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L7;
        r2.add(new ArrayList());
        r4 = r4 + 1;
        goto L5
    L7:
        ArrayList r5 = new ArrayList(r1);
        int r6 = 0;
    L8:
        if (r6 >= r1) goto L10;
        r5.add(0);
        r6 = r6 + 1;
        goto L8
    L10:
        Iterator<T> r3 = r0.iterator();
        int r7 = 0;
    L12:
        if (r3.hasNext() == false) goto L31;
        Object r8 = r3.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        PanelInstructionItem r10 = (PanelInstructionItem) r8;
        if (r10.getType() != PanelInstructionType.SHORTCUT_SHORT) goto L19;
    L22:
        boolean r11 = true;
    L23:
        if (r11 == false) goto L25;
        int r12 = r7 % r1;
    L30:
        ((List) ListProtector.get(r2, r12)).add(r10);
        ListProtector.set(r5, r12, Integer.valueOf(((Number) ListProtector.get(r5, r12)).intValue() + RangesKt.coerceAtLeast(r10.getDisplayText().length(), 1)));
        r7 = r9;
        goto L12
    L25:
        Integer r13 = (Integer) CollectionsKt.minOrNull(r5);
        if (r13 == null) goto L28;
        int r14 = r13.intValue();
    L29:
        r12 = r5.indexOf(Integer.valueOf(r14));
        goto L30
    L28:
        r14 = 0;
        goto L29
    L19:
        if (r10.getType() == PanelInstructionType.SHORTCUT) goto L22;
        r11 = false;
        goto L23
    L31:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r2.iterator();
    L33:
        if (r16.hasNext() == false) goto L49;
        Object r17 = r16.next();
        if ((!((List) r17).isEmpty()) == false) goto L33;
        r15.add(r17);
        goto L33
    L49:
        return r15;
    L38:
        return CollectionsKt.emptyList();
    }

    public final void w5() {
        View r0 = this.k1;
        if (r0 != null) goto L5;
        return;
    L5:
        ViewParent r1 = r0.getParent();
        ConstraintLayout.LayoutParams r3 = null;
        if ((r1 instanceof ViewGroup) == false) goto L8;
        ViewGroup r2 = (ViewGroup) r1;
    L9:
        if (r2 == null) goto L11;
        r2.removeView(r0);
    L11:
        ScrollView r4 = Z3();
        if (r4 == null) goto L14;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
    L16:
        if ((r5 instanceof ConstraintLayout.LayoutParams) == false) goto L18;
        r3 = (ConstraintLayout.LayoutParams) r5;
    L18:
        if (r3 == null) goto L29;
        Integer r6 = this.p1;
        if (r6 == null) goto L22;
        r3.topToBottom = r6.intValue();
    L22:
        Integer r7 = this.v1;
        if (r7 == null) goto L25;
        ((ViewGroup.MarginLayoutParams) r3).topMargin = r7.intValue();
    L25:
        ScrollView r8 = Z3();
        if (r8 == null) goto L30;
        r8.setLayoutParams(r3);
        return;
    L30:
        return;
    L29:
        return;
    L14:
        r5 = null;
        goto L16
    L8:
        r2 = null;
        goto L9
    }

    public final void y5() {
        FLogger r0 = FLogger.a;
        r0.i("ObricSpecialInputComponent", "removeImeListener");
        LinearLayout r1 = l4();
        if (r1 == null) goto L8;
        LinearLayout r2 = (LinearLayout) r1.findViewById(2131381259);
        if (r2 == null) goto L9;
        r0.i("ObricSpecialInputComponent", "removeImeListener: success");
        ViewCompat.setWindowInsetsAnimationCallback(r2, null);
        return;
    L9:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v53, types: [com.obric.assistant.special_input.ObricSpecialInputComponent$imeListener$1] */
    public ObricSpecialInputComponent() {
        this.m = LazyKt.lazy(new j(this));
        this.n = LazyKt.lazy(new k(this));
        this.o = LazyKt.lazy(new l(this));
        this.p = LazyKt.lazy(new m(this));
        this.q = LazyKt.lazy(new n(this));
        this.r = LazyKt.lazy(new o(this));
        this.s = LazyKt.lazy(new p(this));
        this.t = LazyKt.lazy(new q(this));
        this.u = LazyKt.lazy(new r(this));
        this.v = LazyKt.lazy(new c(this));
        this.w = LazyKt.lazy(new d(this));
        this.x = LazyKt.lazy(new e(this));
        this.y = LazyKt.lazy(new f(this));
        this.z = LazyKt.lazy(new g(this));
        this.A = LazyKt.lazy(new h(this));
        this.B = LazyKt.lazy(new i(this));
        this.C = LazyKt.lazy(new c0(this));
        this.D = LazyKt.lazy(new e0(this));
        this.E = LazyKt.lazy(new f0(this));
        this.F = LazyKt.lazy(new g0(this));
        this.G = LazyKt.lazy(new h0(this));
        this.H = LazyKt.lazy(new com.obric.assistant.special_input.p(this));
        StateFlowImpl r0 = j1.a(Boolean.FALSE);
        this.K = r0;
        this.L = kotlinx.coroutines.flow.e.b(r0);
        this.M = new ArrayList();
        this.N = new ArrayList();
        StateFlowImpl r1 = j1.a(null);
        this.O = r1;
        this.P = kotlinx.coroutines.flow.e.b(r1);
        this.H0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.L0 = new ObricSpecialInputComponent$imeListener$1(this);
        this.P0 = LazyKt.lazy(new com.obric.assistant.special_input.q(this));
        this.b1 = LazyKt.lazy(new com.obric.assistant.special_input.r());
        this.g1 = LazyKt.lazy(new com.obric.assistant.special_input.s(this));
        this.h1 = LazyKt.lazy(new t(this));
        this.x1 = LazyKt.lazy(new d0());
    }

    public final void E5() {
        ScrollView r0 = Z3();
        if (r0 == null) goto L11;
        r0.setPadding(0, 0, 0, 0);
        ConstraintLayout.LayoutParams r2 = r0.getLayoutParams();
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        ConstraintLayout.LayoutParams r3 = r2;
    L8:
        if (r3 == null) goto L10;
        ((ViewGroup.MarginLayoutParams) r3).height = -2;
        ((ViewGroup.MarginLayoutParams) r3).bottomMargin = 0;
    L10:
        r0.setVerticalFadingEdgeEnabled(false);
        r0.setFadingEdgeLength(0);
        goto L11
    L7:
        r3 = null;
    L11:
        ObricActionBarSendServiceDelegate.b.k(false);
    }

    public final boolean G4() {
        laa.d r0 = q4();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L21;
        laa.d r2 = q4();
        if (r2 == null) goto L16;
        ObricFloatChatPageState r3 = r2.getPageState();
        if (r3 == null) goto L16;
        ObricFloatChatPageData.Companion.getClass();
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof com.obric.assistant.data.a) != true) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == true) goto L22;
        return false;
    L22:
        return true;
    L16:
        r4 = false;
        goto L17
    L21:
        return true;
    L5:
        if (r0.aF() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void I5() {
        ICoreInputAbility r0 = c4();
        if (r0 == null) goto L5;
        r0.zi();
    L5:
        va8.o r1 = X3();
        if (r1 == null) goto L9;
        r1.U70(c7.b(16), 2131100493);
        return;
    }

    public final boolean J70() {
        if (or() == true) goto L43;
        String r2 = "";
        String r3 = null;
        if (t1.a.o1() == false) goto L18;
        com.larus.bmhome.chat.component.cvs.y r0 = a4();
        if (r0 == null) goto L9;
        String r1 = r0.Y1();
    L10:
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        o0.a.getClass();
        k0 r4 = o0.b(r1);
        if (r4 == null) goto L15;
        q0 r5 = r4.d;
    L16:
        if (r5 == null) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L21;
        return true;
    L21:
        if (this.V != null) goto L37;
        com.larus.bmhome.chat.component.cvs.y r7 = a4();
        if (r7 == null) goto L26;
        r3 = r7.Y1();
    L26:
        if (r3 == null) goto L30;
        r2 = r3;
    L30:
        if (r2.length() != 0) goto L32;
        boolean r8 = true;
    L33:
        if (r8 == true) goto L38;
        o0.a.getClass();
        if (o0.b(r2) != null) goto L37;
    L38:
        boolean r9 = false;
    L39:
        if (r9 == true) goto L45;
        return false;
    L45:
        return true;
    L32:
        r8 = false;
    L37:
        r9 = true;
        goto L39
    L15:
        r5 = null;
        goto L16
    L9:
        r1 = null;
    L18:
        r6 = false;
        goto L19
    L43:
        return true;
    }

    public final ViewGroup Q3() {
        com.larus.bmhome.chat.component.bottom.core.a r0 = i4();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final boolean T4() {
        Resources r0 = getContext().getResources();
        if (r0 == null) goto L7;
        Configuration r1 = r0.getConfiguration();
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(r1.orientation);
    L8:
        FLogger.a.i("ObricSpecialInputComponent", "isLandscape " + r2);
        if (r2 != null) goto L12;
    L14:
        return false;
    L12:
        if (r2.intValue() != 2) goto L14;
        return true;
    L7:
        r2 = null;
        goto L8
    }

    public final void U5() {
        ViewGroup r0 = Q3();
        if (r0 == null) goto L5;
        com.larus.utils.e1.o(r0);
    L5:
        RecyclerView r1 = d4();
        if (r1 == null) goto L8;
        com.larus.utils.e1.o(r1);
    L8:
        TitleAvatarImageView r2 = (TitleAvatarImageView) this.G.getValue();
        if (r2 == null) goto L12;
        com.larus.utils.e1.o(r2);
        return;
    }

    public final ViewGroup V3() {
        b2 r0 = k4();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public final void V5() {
        ViewGroup r0 = Q3();
        ConstraintLayout.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        r1 = (ConstraintLayout.LayoutParams) r2;
    L9:
        if (r1 == null) goto L12;
        this.I = Integer.valueOf(((ViewGroup.MarginLayoutParams) r1).topMargin);
        ((ViewGroup.MarginLayoutParams) r1).topMargin = 0;
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void W5() {
        U5();
        View r0 = e4();
        if (r0 == null) goto L5;
        com.larus.utils.e1.x(r0);
    L5:
        b2 r1 = k4();
        if (r1 == null) goto L11;
        ConstraintLayout r2 = r1.g();
        if (r2 == null) goto L12;
        com.larus.utils.e1.x(r2);
        return;
    L12:
        return;
    }

    public final void X5() {
        ScrollView r0 = Z3();
        if (r0 == null) goto L12;
        r0.setPadding(i5.q(), 0, i5.q(), 0);
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
    L8:
        if (r2 == null) goto L10;
        r2.bottomMargin = i5.q();
    L10:
        r0.setVerticalFadingEdgeEnabled(true);
        r0.setFadingEdgeLength(i5.E());
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final ScrollView Z3() {
        b2 r0 = k4();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final RecyclerView d4() {
        va8.c r0 = i4();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d();
    }

    public final View e4() {
        va8.c r0 = i4();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j();
    }

    public final va8.c i4() {
        va8.o r0 = X3();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Uv();
    }

    public final LinearLayout l4() {
        b2 r0 = k4();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f();
    }

    public final void o5() {
        va8.o r0 = X3();
        if (r0 == null) goto L9;
        ObricFloatChatPageData.a r1 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r2 = (ObricFloatChatPageState) waa.a.b.getValue();
        r1.getClass();
        if ((r2 instanceof vda.a) == false) goto L7;
        int r3 = 2131232090;
    L8:
        r0.G60(r3);
        goto L9
    L7:
        r3 = 2131232089;
    L9:
        laa.h r4 = (laa.h) this.x.getValue();
        if (r4 == null) goto L12;
        r4.X30();
    L12:
        FLogger r5 = FLogger.a;
        r5.i("ObricSpecialInputComponent", "setImeListener");
        LinearLayout r6 = l4();
        if (r6 == null) goto L17;
        LinearLayout r7 = (LinearLayout) r6.findViewById(2131381259);
        if (r7 == null) goto L17;
        r5.i("ObricSpecialInputComponent", "setImeListener: success");
        ViewCompat.setWindowInsetsAnimationCallback(r7, this.L0);
    L17:
        boolean r8 = true;
        if (com.obric.assistant.task.skill.f.d() == false) goto L23;
        this.V0 = false;
        ada.c r9 = W3();
        if (r9 == null) goto L33;
        r9.b5(true);
    L33:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r10 = (com.larus.bmhome.chat.component.bottom.bottommenu.f1) this.A.getValue();
        if (r10 != null) goto L36;
    L38:
        r8 = false;
    L39:
        if (r8 == false) goto L44;
        ICoreInputAbility r11 = c4();
        if (r11 == null) goto L45;
        r11.C1(false, false, "open_new_task_panel");
        return;
    L45:
        return;
    L44:
        return;
    L36:
        if (r10.sL() != true) goto L38;
    L23:
        if (or() == true) goto L27;
        ICoreInputAbility r12 = c4();
        if (r12 == null) goto L27;
        r12.Dr(false);
    L27:
        ICoreInputAbility r13 = c4();
        if (r13 == null) goto L32;
        CoreInputAbility r14 = r13.JO();
        if (r14 == null) goto L32;
        r14.S8(true);
    L32:
        this.V0 = true;
        goto L33
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass4(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass5(this, null), 3, null);
    }

    public final void z5() {
        ViewGroup r0 = Q3();
        ConstraintLayout.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        r1 = (ConstraintLayout.LayoutParams) r2;
    L9:
        if (r1 == null) goto L16;
        Integer r3 = this.I;
        if (r3 == null) goto L13;
        int r4 = r3.intValue();
    L14:
        ((ViewGroup.MarginLayoutParams) r1).topMargin = r4;
        goto L16
    L13:
        r4 = i5.h();
    L16:
        if (T4() == true) goto L24;
        ViewGroup r5 = Q3();
        if (r5 == null) goto L20;
        com.larus.utils.e1.x(r5);
    L20:
        RecyclerView r6 = d4();
        if (r6 == null) goto L24;
        com.larus.utils.e1.x(r6);
    L24:
        if (G4() == false) goto L28;
        TitleAvatarImageView r7 = (TitleAvatarImageView) this.G.getValue();
        if (r7 == null) goto L28;
        com.larus.utils.e1.x(r7);
    L28:
        ViewGroup r8 = Q3();
        if (r8 == null) goto L34;
        View r9 = r8.findViewById(2131381280);
        if (r9 == null) goto L35;
        com.larus.utils.e1.x(r9);
        return;
    L35:
        return;
    L34:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final kotlinx.coroutines.flow.b1 O4() {
        return this.L;
    }

    public final kotlinx.coroutines.flow.b1 i80() {
        return this.P;
    }

    public static boolean F4(laa.v r4) {
        Integer r0 = null;
        if (r4 == null) goto L5;
        ObricSpecialInputScene r1 = r4.c;
    L7:
        if (r1 == ObricSpecialInputScene.COMPLEX_TASK) goto L9;
        return false;
    L9:
        StateInfo r5 = r4.b;
        if (r5 == null) goto L13;
        r0 = Integer.valueOf(r5.getRequestType());
    L13:
        if (r0 != null) goto L15;
    L20:
        return true;
    L15:
        if (r0.intValue() == 0) goto L20;
        if (r0.intValue() == 1) goto L20;
        if (r0.intValue() == 2) goto L20;
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public static boolean R4(laa.v r0) {
        if (F4(r0) == true) goto L5;
    L7:
        return false;
    L5:
        if (t1.a.o1() == false) goto L7;
        return true;
    }

    public static boolean V4(laa.v r2) {
        if (r2 == null) goto L18;
        StateInfo r3 = r2.b;
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r3.getRequestType());
    L9:
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L19;
        return true;
    L19:
        return false;
    L11:
        if (r4.intValue() == 0) goto L14;
        r5 = false;
        goto L15
    L7:
        r4 = null;
        goto L9
    L18:
        return false;
    }

    public static String h4(int r2) {
        return com.larus.utils.y0.k(UriProtector.parse("res://" + AppHost.a.getApplication().getPackageName() + '/' + r2));
    }

    public static void m3(LayoutObricSpecialInputWidgetV2Binding r4) {
        FrameLayout r0 = r4.b;
        boolean r2 = true;
        int r3 = 0;
        if (r4.c.getVisibility() == 0) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r4.g.getVisibility() == 0) goto L12;
        r2 = false;
    L12:
        if (r1 == true) goto L14;
        if (r2 == true) goto L14;
    L15:
        ViewGroup.LayoutParams r5 = r0.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
    L19:
        if (r6 != null) goto L22;
        return;
    L22:
        if (r6.getMarginStart() != r3) goto L24;
        return;
    L24:
        r6.setMarginStart(r3);
        r0.setLayoutParams(r6);
        return;
    L18:
        r6 = null;
    L14:
        r3 = -i5.h();
        goto L15
    L5:
        if (r4.c.getChildCount() <= 0) goto L7;
        r1 = true;
        goto L9
    }

    public static String x5(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (StringsKt.startsWith$default(r5, "设置定时任务，", false, 2, null) == false) goto L8;
        r5 = StringsKt.substringAfter$default(r5, "设置定时任务，", null, 2, null);
    L11:
        return r5;
    L8:
        if (StringsKt.startsWith$default(r5, "AI 操作手机：", false, 2, null) == false) goto L11;
        r5 = StringsKt.substringAfter$default(r5, "AI 操作手机：", null, 2, null);
        goto L11
    }

    public final void B3(String r2) {
        o0.a.getClass();
        o0.a(r2);
        this.V = null;
        this.W = null;
        this.X = null;
    }

    public final void E3(boolean r5) {
        ICoreInputAbility r0 = c4();
        if (r0 == null) goto L38;
        CoreInputAbility r1 = r0.JO();
        if (r1 == null) goto L39;
        z8.b r2 = null;
        if (r5 == false) goto L24;
        if (this.Z == false) goto L12;
        return;
    L12:
        ICoreInputAbility r6 = c4();
        if (r6 == null) goto L17;
        z8.a r7 = r6.Jd();
        if (r7 == null) goto L17;
        r2 = r7.l;
    L17:
        this.k0 = r2;
        if (r2 == null) goto L20;
        z8.b r3 = new z8.b(true, r2.b);
    L21:
        this.p0 = r3;
        r1.l9(r3);
        this.Z = true;
        FLogger.a.i("ObricSpecialInputComponent", "[SpecialInputAttachment] plus menu override enabled");
        return;
    L20:
        r3 = new z8.b(true, 2);
        goto L21
    L24:
        if (this.Z == true) goto L26;
        return;
    L26:
        ICoreInputAbility r8 = c4();
        if (r8 == null) goto L31;
        z8.a r9 = r8.Jd();
        if (r9 == null) goto L31;
        z8.b r10 = r9.l;
    L33:
        if (r10 != this.p0) goto L35;
        r1.l9(this.k0);
    L36:
        this.k0 = null;
        this.p0 = null;
        this.Z = false;
        FLogger.a.i("ObricSpecialInputComponent", "[SpecialInputAttachment] plus menu override restored");
        return;
    L35:
        FLogger.a.i("ObricSpecialInputComponent", "[SpecialInputAttachment] skip plus menu restore: interceptor ownership changed");
    L31:
        r10 = null;
        goto L33
    L39:
        return;
    }

    public final void Fq(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        p3(r2, v4());
    }

    public final void RC(laa.u r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.M.remove(r2);
    }

    public final void W4(boolean r5) {
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L18;
        laa.v r0 = p4();
        if (r0 != null) goto L8;
        r0 = (laa.v) this.P.getValue();
    L8:
        if (R4(r0) == false) goto L21;
        va8.o r1 = X3();
        if (r1 == null) goto L13;
        r1.p9(v19.c.b(2130970690, getContext(), 2131239155));
    L13:
        if (r5 == false) goto L19;
        FrameLayout r6 = (FrameLayout) this.E.getValue();
        if (r6 == null) goto L20;
        r6.post(new x(this));
        return;
    L20:
        return;
    L19:
        return;
    L21:
        return;
    }

    public final void e00(laa.u r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.M.add(r2);
    }

    public final void f5(StateInfo r11) {
        laa.d r0 = q4();
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        laa.j.a.a(this, r3, r11, ObricSpecialInputScene.COMPLEX_TASK, null, true, false, 40);
        return;
    L5:
        if (r0.aF() != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void j1(boolean r8) {
        FLogger.a.i("ObricSpecialInputComponent", "onInstructionVisibleChanged: instructionOpen = " + r8);
        if (r8 == true) goto L55;
        E3(false);
        T5();
        this.R = null;
        y5();
        z5();
        ICoreInputAbility r2 = c4();
        if (r2 == null) goto L7;
        r2.g2(r2.Rp(), true);
    L7:
        Iterator r3 = ((ArrayList) this.M).iterator();
    L9:
        if (r3.hasNext() == false) goto L33;
        laa.u r4 = (laa.u) r3.next();
        laa.v r5 = (laa.v) this.P.getValue();
        if (r5 == null) goto L13;
        StateInfo r6 = r5.b;
    L14:
        if (r6 == null) goto L9;
        laa.v r7 = (laa.v) this.P.getValue();
        if (r7 == null) goto L22;
        StateInfo r9 = r7.b;
        if (r9 == null) goto L22;
        if (r9.getRequestType() != 0) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == true) goto L9;
        laa.v r11 = (laa.v) this.P.getValue();
        if (r11 == null) goto L27;
        StateInfo r12 = r11.b;
    L28:
        laa.v r13 = (laa.v) this.P.getValue();
        if (r13 == null) goto L31;
        DMTaskState r14 = r13.a;
    L32:
        r4.a(new laa.t(false, r12, null, r14));
        goto L9
    L31:
        r14 = null;
        goto L32
    L27:
        r12 = null;
    L22:
        r10 = false;
        goto L23
    L13:
        r6 = null;
        goto L14
    L33:
        laa.v r15 = (laa.v) this.P.getValue();
        if (r15 == null) goto L36;
        ObricSpecialInputScene r16 = r15.c;
    L38:
        if (r16 != ObricSpecialInputScene.COMPLEX_TASK) goto L42;
        ObricTaskStatusManager.a.getClass();
        if (Intrinsics.areEqual(ObricTaskStatusManager.b(), "clarify_complex_task") == false) goto L42;
        com.obric.assistant.live.api.j.a.m(false);
        ObricTaskStatusManager.b.set(true);
    L42:
        this.K.setValue(Boolean.FALSE);
        this.O.setValue(null);
        this.Q = null;
        R5();
        E5();
        I5();
        b2 r0 = k4();
        if (r0 == null) goto L45;
        ConstraintLayout r1 = r0.h();
    L46:
        if (r1 == null) goto L48;
        r1.removeView((LinearLayoutCompat) this.g1.getValue());
    L48:
        maa.e r17 = (maa.e) this.v.getValue();
        if (r17 == null) goto L51;
        maa.e.a.a(r17, null, null, false, 7);
    L51:
        ObricTaskStatusManager.a.getClass();
        FLogger.a.i("ObricTaskStatusManager", "resetOpenPanelType");
        ObricTaskStatusManager.c = null;
        ObricTaskStatusManager.g(false);
        ObricActionBarTrackServiceExtDelegate.b.e();
        FrameLayout r18 = (FrameLayout) this.E.getValue();
        if (r18 == null) goto L65;
        r18.post(new com.obric.assistant.special_input.o(this));
        return;
    L65:
        return;
    L45:
        r1 = null;
        goto L46
    L36:
        r16 = null;
        goto L38
    L55:
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L67;
        o5();
        m6(true);
        return;
    }

    public final void m6(boolean r3) {
        if (or() == true) goto L6;
        E3(false);
        T5();
        s5();
        return;
    L6:
        E3(true);
        ICoreInputAbility r1 = c4();
        if (r1 == null) goto L9;
        r1.uq(true);
    L9:
        i5();
        if (r3 == false) goto L14;
        bc8.a r4 = (bc8.a) this.s.getValue();
        if (r4 == null) goto L14;
        r4.mX();
    L14:
        s5();
    }

    public final void o6(Context r5) {
        ObricSpecialInputComponent$registerAddIconResultReceiver$receiver$1 r0 = this.y1;
        if (r0 == null) goto L30;
        Context r6 = r5.getApplicationContext();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        ReceiverRegisterLancet.loge(r0, false);     // Catch: Throwable -> L16
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L26;
        r6.unregisterReceiver(r0);     // Catch: Throwable -> L16
    L14:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L19:
        if (Result.isSuccess-impl(r7) == false) goto L21;
        Unit r2 = (Unit) r7;
        this.y1 = null;
    L21:
        Throwable r3 = Result.exceptionOrNull-impl(r7);
        if (r3 == null) goto L24;
        FLogger.a.w("ObricSpecialInputComponent", "unregisterAddIconResultReceiver failed", r3);
    L24:
        Result.box-impl(r7);
        return;
    L26:
    L11:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r0.toString());     // Catch: Throwable -> L16
        e.printStackTrace();     // Catch: Throwable -> L16
        goto L14
    L8:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r0, r6) == false) goto L14;
        r6.unregisterReceiver(r0);     // Catch: Exception -> L11 Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public final void r6(AppCompatTextView r14) {
        com.larus.utils.e1.x(r14);
        laa.v r0 = (laa.v) this.P.getValue();
        boolean r1 = true;
        if (r0 == null) goto L9;
        StateInfo r2 = r0.b;
        if (r2 == null) goto L9;
        if (r2.getRequestType() != 1) goto L9;
        boolean r3 = true;
    L10:
        String r4 = null;
        if (r3 == false) goto L13;
        FLogger.a.i("ObricSpecialInputComponent", "getHintContentStyle: clarify");
        com.obric.assistant.special_input.a r5 = new com.obric.assistant.special_input.a(c7.b(14), Integer.valueOf(v19.c.b(2130972082, null, 2131103146)), 0, null, null, Typeface.create("sans-serif-medium", 0));
    L45:
        String r6 = r5.e;
        String r7 = "";
        if (r6 != null) goto L49;
        r6 = "";
    L49:
        if (r6.length() != 0) goto L51;
        boolean r8 = true;
    L52:
        if (r8 == false) goto L68;
        laa.v r9 = (laa.v) this.P.getValue();
        if (r9 == null) goto L58;
        StateInfo r10 = r9.b;
        if (r10 == null) goto L58;
        r4 = r10.getContent();
    L58:
        if (r4 == null) goto L62;
        r7 = r4;
    L62:
        if (r7.length() != 0) goto L64;
        boolean r11 = true;
    L65:
        if (r11 == false) goto L67;
        r6 = r14.getContext().getString(2131912273);
        goto L68
    L67:
        r6 = r7;
        goto L68
    L64:
        r11 = false;
    L68:
        r14.setText(r6);
        r14.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r14.setTextSize(0, r5.a);
        r14.setTypeface(r5.f, r5.c);
        r14.setMaxWidth(B4());
        r14.setLineHeight((int) (r14.getTextSize() * 1.36f));
        laa.v r12 = (laa.v) this.P.getValue();
        if (r12 == null) goto L75;
        StateInfo r13 = r12.b;
        if (r13 == null) goto L75;
        if (r13.getRequestType() != 1) goto L75;
    L76:
        if (r1 == false) goto L78;
        r14.setLineHeight((int) (r14.getTextSize() * 1.5f));
        q2.a(r14);
    L78:
        r14.getViewTreeObserver().addOnGlobalLayoutListener(new s(r14, this, r5));
        return;
    L75:
        r1 = false;
        goto L76
    L51:
        r8 = false;
        goto L52
    L13:
        laa.v r15 = (laa.v) this.P.getValue();
        if (r15 == null) goto L18;
        StateInfo r16 = r15.b;
        if (r16 == null) goto L18;
        String r17 = com.obric.assistant.utils.m.a(r16);
    L20:
        if (Intrinsics.areEqual(r17, "gui") == false) goto L22;
        FLogger.a.i("ObricSpecialInputComponent", "isGui: currentStateInfo is gui");
    L31:
        boolean r18 = true;
    L33:
        if (r18 == false) goto L44;
        laa.v r19 = (laa.v) this.P.getValue();
        if (r19 == null) goto L41;
        StateInfo r20 = r19.b;
        if (r20 == null) goto L41;
        if (r20.getRequestType() != 2) goto L41;
        boolean r21 = true;
    L42:
        if (r21 == false) goto L44;
        FLogger.a.i("ObricSpecialInputComponent", "getHintContentStyle: oauto addition");
        r5 = new com.obric.assistant.special_input.a(i5.q(), null, 1, new int[]{ColorProtector.parseColor("#FFFF5D8B"), ColorProtector.parseColor("#FFFFA64D")}, AppHost.a.getApplication().getString(2131911931));
    L41:
        r21 = false;
    L44:
        FLogger.a.i("ObricSpecialInputComponent", "getHintContentStyle: no bold");
        r5 = new com.obric.assistant.special_input.a(i5.m(), Integer.valueOf(ColorProtector.parseColor("#B2000000")), 0, null, AppHost.a.getApplication().getString(2131911932));
        goto L45
    L22:
        laa.v r22 = (laa.v) this.P.getValue();
        if (r22 == null) goto L27;
        DMTaskState r23 = r22.a;
        if (r23 == null) goto L27;
        String r24 = com.obric.assistant.utils.l.b(r23);
    L29:
        if (Intrinsics.areEqual(r24, "gui") == false) goto L32;
        FLogger.a.i("ObricSpecialInputComponent", "isGui: relatedTask is gui");
        goto L31
    L32:
        FLogger.a.i("ObricSpecialInputComponent", "isGui: not gui");
        r18 = false;
    L27:
        r24 = null;
    L18:
        r17 = null;
    L9:
        r3 = false;
        goto L10
    }

    public static final void Y2(ObricSpecialInputComponent r9, boolean r10) {
        if (r9.or() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        ViewGroup r2 = null;
        if (r10 == false) goto L48;
        if (r0 == true) goto L48;
        ViewParent r11 = ((LinearLayoutCompat) r9.h1.getValue()).getParent();
        if (r11 == null) goto L20;
        if ((r11 instanceof ViewGroup) == false) goto L16;
        ViewGroup r12 = (ViewGroup) r11;
    L17:
        if (r12 == null) goto L20;
        r12.removeView((LinearLayoutCompat) r9.h1.getValue());
        goto L20
    L16:
        r12 = null;
    L20:
        if (r9.V3() != null) goto L22;
        FLogger.a.w("ObricSpecialInputComponent", "addInstructionManagerBtn failed: no actionBarTitleContainer");
    L38:
        b2 r13 = r9.k4();
        if (r13 == null) goto L41;
        ConstraintLayout r14 = r13.g();
    L42:
        ViewGroup r1 = r9.V3();
        if (r14 == null) goto L47;
        if (r1 == null) goto L47;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), null, null, new ObricSpecialInputComponent$addAddIconTipsBar$1(r9, r14, r1, null), 3, null);
        return;
    L47:
        FLogger.a.w("ObricSpecialInputComponent", "addAddIconTipsBar failed: no container");
        return;
    L41:
        r14 = null;
        goto L42
    L22:
        b2 r15 = r9.k4();
        if (r15 == null) goto L25;
        AppCompatImageView r16 = r15.i();
    L26:
        if (r16 != null) goto L28;
        FLogger.a.w("ObricSpecialInputComponent", "addInstructionManagerBtn failed: no clickBtnIcon");
        goto L38
    L28:
        FLogger.a.i("ObricSpecialInputComponent", "addInstructionManagerBtn");
        ViewGroup r17 = r9.V3();
        if (r17 == null) goto L38;
        LinearLayoutCompat r3 = (LinearLayoutCompat) r9.h1.getValue();
        ConstraintLayout.LayoutParams r4 = new ConstraintLayout.LayoutParams(-2, -2);
        b2 r5 = r9.k4();
        if (r5 == null) goto L33;
        AppCompatImageView r6 = r5.i();
    L34:
        if (r6 == null) goto L36;
        int r7 = r6.getId();
    L37:
        r4.endToStart = r7;
        r4.topToTop = 0;
        r4.bottomToBottom = 0;
        r4.setMarginEnd(i5.Y());
        r3.setLayoutParams(r4);
        r17.addView(r3);
        goto L38
    L36:
        r7 = 0;
        goto L37
    L33:
        r6 = null;
        goto L34
    L25:
        r16 = null;
    L48:
        ViewParent r18 = ((LinearLayoutCompat) r9.h1.getValue()).getParent();
        if (r18 != null) goto L51;
    L55:
        r9.w5();
        return;
    L51:
        if ((r18 instanceof ViewGroup) == false) goto L53;
        r2 = (ViewGroup) r18;
    L53:
        if (r2 == null) goto L55;
        r2.removeView((LinearLayoutCompat) r9.h1.getValue());
        goto L55
    L5:
        if (r9.S == false) goto L7;
        r0 = true;
        goto L8
    }

    public static final Object h3(ObricSpecialInputComponent r5, Continuation r6) {
        r5.getClass();
        if ((r6 instanceof ObricSpecialInputComponent$shouldShowAddIconTipsBar$1) == false) goto L7;
        ObricSpecialInputComponent$shouldShowAddIconTipsBar$1 r0 = (ObricSpecialInputComponent$shouldShowAddIconTipsBar$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L20:
        boolean r8 = ((Boolean) r7).booleanValue();
        FLogger.a.i("ObricSpecialInputComponent", "shouldShowAddIconTipsBar: " + r8);
        return Boxing.boxBoolean(r8);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (((Keva) r5.x1.getValue()).getBoolean("has_clicked_add_icon_tips", false) == false) goto L17;
        FLogger.a.i("ObricSpecialInputComponent", "shouldShowAddIconTipsBar: false, tips already clicked");
        return Boxing.boxBoolean(false);
    L17:
        CoroutineDispatcher r9 = Dispatchers.getIO();
        ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1 r10 = new ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1(null);
        r0.label = 1;
        r7 = BuildersKt.withContext(r9, r10, r0);
        if (r7 != r2) goto L20;
        return r2;
    L7:
        r0 = new ObricSpecialInputComponent$shouldShowAddIconTipsBar$1(r5, r6);
        goto L8
    }

    public final void D3(boolean r4, String r5) {
        FLogger.a.i("ObricSpecialInputComponent", "closeSpecialInputPanel: from = " + r5 + ", dismissWindow = " + r4 + ", isVariantInputOpen = " + ((Boolean) this.L.getValue()).booleanValue());
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L56;
        HY();
        y5();
        if (r4 == true) goto L7;
    L21:
        C3();
        com.larus.bmhome.instruction.g r6 = j4();
        if (r6 == null) goto L24;
        r6.A1();
    L24:
        E5();
        z5();
        View r7 = e4();
        if (r7 == null) goto L27;
        com.larus.utils.e1.o(r7);
    L27:
        I5();
        b2 r8 = k4();
        if (r8 == null) goto L30;
        r8.d(AppCompatResources.getDrawable(getContext(), 2131241428));
    L30:
        b2 r9 = k4();
        if (r9 == null) goto L33;
        ConstraintLayout r10 = r9.h();
    L34:
        if (r10 == null) goto L36;
        r10.removeView((LinearLayoutCompat) this.g1.getValue());
    L36:
        R5();
        ICoreInputAbility r11 = c4();
        if (r11 == null) goto L39;
        r11.p80(true);
    L39:
        ICoreInputAbility r12 = c4();
        if (r12 == null) goto L42;
        r12.qp(false);
    L42:
        ICoreInputAbility r13 = c4();
        if (r13 == null) goto L45;
        r13.Jc(getContext());
    L45:
        va8.o r14 = X3();
        if (r14 == null) goto L48;
        r14.ra();
    L48:
        com.larus.bmhome.instruction.g r15 = j4();
        if (r15 == null) goto L51;
        r15.S7();
    L51:
        qaa.a r16 = (qaa.a) this.t.getValue();
        if (r16 == null) goto L54;
        r16.Fo(false, null, null);
    L54:
        this.O.setValue(null);
        this.Q = null;
        this.K.setValue(Boolean.FALSE);
        return;
    L33:
        r10 = null;
        goto L34
    L7:
        if (G4() == false) goto L21;
        ObricTaskStatusManager.a.getClass();
        if (Intrinsics.areEqual(ObricTaskStatusManager.b(), "start_complex_task") == true) goto L21;
        if ((q4() instanceof hca.d) == false) goto L18;
        hca.d r17 = q4();
        if ((r17 instanceof hca.d) == false) goto L15;
        hca.d r18 = r17;
    L16:
        if (r18 == null) goto L21;
        hca.d.a.a(r18, false, 7);
        goto L21
    L15:
        r18 = null;
        goto L16
    L18:
        laa.d r19 = q4();
        if (r19 == null) goto L21;
        laa.d.a.b(r19, null, false, false, 14);
        goto L21
    }

    public final void G3(k0 r8, String r9) {
        Set r0 = CollectionsKt.toSet(r8.c);
        com.larus.bmhome.chat.component.bottom.attachment.g1 r1 = f70();
        String r2 = null;
        if (r1 == null) goto L5;
        List r3 = r1.q1();
    L6:
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        Object r6 = r5.next();
        if (CollectionsKt.contains(r0, ((UplinkFileEntity) r6).getFileIdentifier()) == false) goto L10;
        r4.add(r6);
        goto L10
    L14:
        FLogger.a.i("ObricSpecialInputComponent", "[PhoneAttachmentDraft] discard, reason=" + r9 + ", localMsgId=" + r8.b + ", count=" + r4.size());
        this.Y = true;
        com.larus.bmhome.chat.component.cvs.y r10 = a4();
        if (r10 == null) goto L17;
        r2 = r10.Y1();
    L17:
        if (r2 != null) goto L19;
        r2 = "";
    L19:
        B3(r2);
    L27:
        th = move-exception;
        this.Y = false;
        throw th;
    L21:
        if ((true ^ r4.isEmpty()) == false) goto L25;
        com.larus.bmhome.chat.component.bottom.attachment.g1 r11 = f70();     // Catch: Throwable -> L27
        if (r11 == null) goto L25;
        com.larus.bmhome.chat.component.bottom.attachment.g1.a.a(r11, r4, 6);     // Catch: Throwable -> L27
    L25:
        this.Y = false;
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void H3(String r10, boolean r11) {
        ScrollView r0 = Z3();
        if (r0 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 != null) goto L8;
        return;
    L8:
        int r2 = r1.height;
        Integer r3 = Integer.valueOf(r0.getHeight());
        boolean r5 = true;
        if (r3.intValue() <= 0) goto L11;
        boolean r4 = true;
    L12:
        Integer r7 = null;
        if (r4 == true) goto L16;
        r3 = null;
    L16:
        if (r3 == null) goto L18;
        int r6 = r3.intValue();
    L19:
        int r8 = -2;
        if (r11 == true) goto L27;
        if (r6 <= 0) goto L27;
        if (r2 > 0) goto L26;
        if (r2 != (-2)) goto L25;
        return;
    L25:
        if (r2 != (-1)) goto L27;
        return;
    L26:
        return;
    L27:
        LinearLayout r9 = l4();
        if (r9 != null) goto L30;
        int r12 = 0;
    L45:
        if (r12 <= i5.w()) goto L47;
        r8 = i5.w();
    L47:
        FLogger.a.i("ObricSpecialInputComponent", "ensureComponentScrollContainerHeight from=" + r10 + ", currentHeight=" + r2 + ", widgetHeight=" + r12 + ", targetHeight=" + r8);
        r1.height = r8;
        r0.setLayoutParams(r1);
        r0.requestLayout();
        ObricActionBarSendServiceDelegate r13 = ObricActionBarSendServiceDelegate.b;
        if (r8 == i5.w()) goto L51;
        r5 = false;
    L51:
        r13.k(r5);
        return;
    L30:
        r12 = r9.getMeasuredHeight();
        if (r11 == true) goto L34;
        if (r12 > 0) goto L45;
    L34:
        Integer r14 = Integer.valueOf((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight());
        if (r14.intValue() <= 0) goto L37;
        boolean r15 = true;
    L38:
        if (r15 == false) goto L40;
        r7 = r14;
    L40:
        if (r7 == null) goto L42;
        int r16 = r7.intValue();
    L43:
        r9.measure(View.MeasureSpec.makeMeasureSpec(r16, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        r12 = r9.getMeasuredHeight();
        goto L45
    L42:
        r16 = B4();
        goto L43
    L37:
        r15 = false;
        goto L38
    L18:
        r6 = r0.getMeasuredHeight();
        goto L19
    L11:
        r4 = false;
        goto L12
    }

    public final Object Q5(q0 r8, Continuation<? super SpecialPanelRestoreResult> r9) {
        if ((r9 instanceof ObricSpecialInputComponent$restoreAdditionPanel$1) == false) goto L7;
        ObricSpecialInputComponent$restoreAdditionPanel$1 r0 = (ObricSpecialInputComponent$restoreAdditionPanel$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        String r5 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r11 = (String) r0.L$1;
        q0 r6 = (q0) r0.L$0;
        ResultKt.throwOnFailure(r10);
        String r12 = r11;
        r8 = r6;
        Object r7 = r10;
    L28:
        Message r13 = (Message) r7;
        if (r13 == null) goto L31;
        f5(z3(r8, com.larus.bmhome.chat.bean.d.H(r13), null));
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L51;
        laa.v r14 = (laa.v) this.P.getValue();
        if (r14 == null) goto L41;
        StateInfo r15 = r14.b;
        if (r15 == null) goto L41;
        if (r15.getRequestType() != 2) goto L41;
        r4 = true;
    L41:
        if (r4 == false) goto L51;
        laa.v r16 = (laa.v) this.P.getValue();
        if (r16 == null) goto L48;
        StateInfo r17 = r16.b;
        if (r17 == null) goto L48;
        r5 = r17.getRefMessageId();
    L48:
        if (Intrinsics.areEqual(r5, r12) == false) goto L51;
        return SpecialPanelRestoreResult.SUCCESS;
    L51:
        return SpecialPanelRestoreResult.FAILED;
    L31:
        return SpecialPanelRestoreResult.FAILED;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        r12 = r8.d;
        if (r12 == null) goto L53;
        if (r12.length() <= 0) goto L19;
        boolean r18 = true;
    L20:
        if (r18 == true) goto L23;
        r12 = null;
    L23:
        if (r12 == null) goto L53;
        t1a.b r19 = s1a.d.a(this);
        r0.L$0 = r8;
        r0.L$1 = r12;
        r0.label = 1;
        r7 = VContextMessageExKt.a(r19, r12, r0);
        if (r7 != r2) goto L28;
        return r2;
    L19:
        r18 = false;
    L53:
        return SpecialPanelRestoreResult.FAILED;
    L7:
        r0 = new ObricSpecialInputComponent$restoreAdditionPanel$1(this, r9);
        goto L8
    }

    public final void d5(Message r4, Map<String, String> r5) {
        if (r5 == null) goto L9;
        if (r5.containsKey("o_task_type") == false) goto L9;
        FLogger.a.i("ObricSpecialInputComponent", "onSendMessageClose: extra = " + r5);
        e90();
        return;
    L9:
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L20;
        if (r4 == null) goto L16;
        Map r6 = r4.getExt();
        if (r6 == null) goto L16;
        boolean r7 = true;
        if (r6.containsKey("o_task_type") != true) goto L16;
    L17:
        if (r7 == false) goto L21;
        FLogger.a.i("ObricSpecialInputComponent", "onSendMessageClose: closeSpecialInputPanel");
        e90();
        return;
    L21:
        return;
    L16:
        r7 = false;
        goto L17
    }

    public final void p3(LinearLayout r17, List<? extends List<PanelInstructionItem>> r18) {
        r17.removeAllViews();
        View r1 = LayoutInflater.from(getContext()).inflate(2131564288, r17, false);
        r17.addView(r1);
        if (r1 == null) goto L36;
        RowObricActionBarPhoneOperationInstructionsBinding r0 = new RowObricActionBarPhoneOperationInstructionsBinding((LinearLayout) r1);
        Iterator<T> r2 = r18.iterator();
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L34;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        List r6 = (List) r4;
        LinearLayout r7 = new LinearLayout(getContext());
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-2, -2);
        if (r3 <= 0) goto L13;
        r8.topMargin = i5.h();
    L13:
        r7.setLayoutParams(r8);
        r7.setOrientation(0);
        r0.a.addView(r7);
        Iterator r9 = r6.iterator();
        int r10 = 0;
    L15:
        if (r9.hasNext() == false) goto L32;
        Object r11 = r9.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        final PanelInstructionItem r13 = (PanelInstructionItem) r11;
        LinearLayout r14 = new LinearLayout(getContext());
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-2, i5.X());
        r14.setPadding(i5.h(), 0, i5.h(), 0);
        if (r10 <= 0) goto L23;
        r15.setMarginStart(i5.r0());
    L23:
        if (r10 != (r6.size() - 1)) goto L25;
        r15.setMarginEnd(i5.h());
    L25:
        r14.setLayoutParams(r15);
        r14.setOrientation(0);
        r14.setGravity(128);
        r14.setBackground(AppCompatResources.getDrawable(r14.getContext(), 2131232080));
        String r16 = r13.getDisplayText();
        View r19 = LayoutInflater.from(getContext()).inflate(2131561645, r14, false);
        r14.addView(r19);
        int r110 = 2131375091;
        if (ViewBindings.findChildViewById(r19, 2131375091) == null) goto L31;
        r110 = 2131388525;
        AppCompatTextView r111 = ViewBindings.findChildViewById(r19, 2131388525);
        if (r111 == null) goto L31;
        LinearLayout r112 = (LinearLayout) r19;
        r111.setText(r16);
        r14.setClickable(true);
        com.larus.utils.e1.d(r14, new b0(this, r13));
        r7.addView(r14);
        r10 = r12;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r110)));
    L32:
        r3 = r5;
        goto L6
    L34:
        return;
    L36:
        throw new NullPointerException("rootView");
    }

    public static StateInfo z3(q0 r6, String r7, DMTaskState r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = r6.c;
        String r2 = null;
        boolean r3 = true;
        if (r1 != null) goto L5;
    L13:
        if (r7 != null) goto L15;
    L23:
        String r9 = r6.f;
        if (r9 != null) goto L27;
        r9 = "";
    L27:
        if (r9.length() != 0) goto L29;
        boolean r4 = true;
    L30:
        if (r4 == false) goto L33;
        r9 = com.obric.assistant.utils.l.b(r8);
    L33:
        if (r9.length() <= 0) goto L35;
        boolean r5 = true;
    L36:
        if (r5 == true) goto L39;
        r9 = null;
    L39:
        if (r9 == null) goto L41;
        r0.put("o_complex_source_type", r9);
    L41:
        String r10 = r6.e;
        if (r10 == null) goto L52;
        if (r10.length() > 0) goto L47;
        r3 = false;
    L47:
        if (r3 == false) goto L49;
        r2 = r10;
    L49:
        if (r2 == null) goto L52;
        r0.put("source_from", r2);
    L52:
        return com.obric.assistant.special_input.util.j.b(r6.a, false, r0, r6.d, r8);
    L35:
        r5 = false;
        goto L36
    L29:
        r4 = false;
        goto L30
    L15:
        if (r7.length() <= 0) goto L17;
        boolean r11 = true;
    L18:
        if (r11 == true) goto L21;
        r7 = null;
    L21:
        if (r7 == null) goto L23;
        r0.put("o_reference_msg_content", r7);
        goto L23
    L17:
        r11 = false;
        goto L18
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        r0.put("o_omni_task_id", r1);
        goto L13
    L7:
        r12 = false;
        goto L8
    }

    public final void Z50(Message r4, String r5, Map<String, String> r6) {
        FLogger r0 = FLogger.a;
        r0.i("ObricSpecialInputComponent", "checkCloseObricSpecialInputPanel: packageName = " + r5 + ", msg = " + r4);
        if (r5 == null) goto L13;
        if (((Boolean) this.L.getValue()).booleanValue() == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r5, "com.obric.autoaction") == false) goto L9;
    L10:
        r0.i("ObricSpecialInputComponent", "onTaskOverClose: closeSpecialInputPanel");
        e90();
        return;
    L9:
        if (Intrinsics.areEqual(r5, ObricIslandType.COMPLEX_TASK.getValue()) == true) goto L10;
        return;
    L13:
        if (r4 == null) goto L16;
        d5(r4, null);
        return;
    L16:
        if (r6 != null) goto L18;
        return;
    L18:
        if (r6.containsKey("o_task_type") == false) goto L24;
        d5(null, r6);
        return;
    }

    public final void h5(StateInfo r17, boolean r18, DMTaskState r19) {
        FLogger r2 = FLogger.a;
        r2.i("ObricSpecialInputComponent", "openSpecialInputInternal");
        com.larus.bmhome.actionbar.model.z0 r4 = this.Q;
        if (r4 != null) goto L5;
    L7:
        r4 = null;
    L8:
        if (r4 == null) goto L18;
        com.larus.bmhome.actionbar.model.g1 r6 = r4.c;
        if (r6 == null) goto L18;
        String r7 = r6.b;
        if (r7 == null) goto L18;
        if (com.larus.utils.o0.d(r7) == true) goto L17;
        r7 = null;
    L17:
        if (r7 == null) goto L18;
    L22:
        b2 r8 = k4();
        if (r8 == null) goto L25;
        r8.b(r7, Integer.valueOf(ContextCompat.getColor(getContext(), 2131103681)));
    L25:
        b2 r9 = k4();
        if (r9 == null) goto L28;
        AppCompatTextView r10 = r9.e();
    L29:
        if (r10 == null) goto L41;
        if (r4 == null) goto L39;
        String r5 = r4.e;
        if (r5 == null) goto L39;
        if (com.larus.utils.o0.d(r5) == true) goto L37;
        r5 = null;
    L37:
        if (r5 == null) goto L39;
    L40:
        r10.setText(r5);
    L39:
        r5 = AppHost.a.getApplication().getString(2131911902);
    L41:
        b2 r11 = k4();
        if (r11 == null) goto L44;
        r11.d(AppCompatResources.getDrawable(getContext(), 2131241428));
    L44:
        b2 r12 = k4();
        if (r12 == null) goto L47;
        View r13 = r12.j();
    L48:
        if (r13 == null) goto L50;
        com.larus.utils.e1.d(r13, new w(this));
    L50:
        LinearLayout r14 = l4();
        if (r14 == null) goto L53;
        r14.removeAllViews();
    L53:
        LinearLayout r15 = l4();
        boolean r16 = true;
        if (r15 == null) goto L178;
        LayoutObricSpecialInputWidgetV2Binding r20 = LayoutObricSpecialInputWidgetV2Binding.a(LayoutInflater.from(getContext()), r15);
        this.R = r20;
        ObricTaskStatusManager.a.getClass();
        String r110 = "";
        if (Intrinsics.areEqual(ObricTaskStatusManager.b(), "addition_complex_task") == false) goto L129;
        s5();
        X5();
        LinearLayout r3 = (LinearLayout) r15.findViewById(2131381259);
        LinearLayout r21 = (LinearLayout) r3.findViewById(2131381260);
        AppCompatTextView r22 = r3.findViewById(2131388367);
        if (r21 == null) goto L60;
        com.larus.utils.e1.x(r21);
    L60:
        if (r22 == null) goto L62;
        com.larus.utils.e1.x(r22);
    L62:
        r3.setGravity(0);
        if (r17 == null) goto L67;
        Map r23 = r17.getExt();
        if (r23 == null) goto L67;
        String r24 = (String) r23.get("o_reference_msg_content");
    L68:
        if (r24 != null) goto L71;
        r24 = "";
    L71:
        if (r24.length() != 0) goto L73;
        boolean r25 = true;
    L74:
        if (r25 == false) goto L84;
        if (r19 == null) goto L81;
        DMTaskInfo r26 = r19.getTaskInfo();
        if (r26 == null) goto L81;
        IMMessage r27 = r26.getMessage();
        if (r27 == null) goto L81;
        r24 = com.larus.bmhome.chat.bean.d.H(com.obric.assistant.special_input.util.i.a(r27));
    L82:
        if (r24 != null) goto L84;
        r24 = "";
    L81:
        r24 = null;
    L84:
        if (r22 == null) goto L111;
        r22.setMaxLines(1);
        r22.setEllipsize(TextUtils.TruncateAt.END);
        if (r17 == null) goto L90;
        Map r28 = r17.getExt();
        if (r28 == null) goto L90;
        String r29 = (String) r28.get("o_reference_msg_content");
    L91:
        if (r29 != null) goto L94;
        r29 = "";
    L94:
        if (r29.length() != 0) goto L96;
        boolean r30 = true;
    L97:
        if (r30 == false) goto L109;
        if (r19 == null) goto L104;
        DMTaskInfo r31 = r19.getTaskInfo();
        if (r31 == null) goto L104;
        IMMessage r32 = r31.getMessage();
        if (r32 == null) goto L104;
        String r33 = com.larus.bmhome.chat.bean.d.H(com.obric.assistant.special_input.util.i.a(r32));
    L105:
        if (r33 == null) goto L108;
        r110 = r33;
    L108:
        r29 = r110;
    L104:
        r33 = null;
    L109:
        r22.setText(r29);
        goto L111
    L96:
        r30 = false;
    L90:
        r29 = null;
    L111:
        if (r24.length() != 0) goto L113;
        boolean r34 = true;
    L114:
        if (r34 == false) goto L126;
        if (r17 == null) goto L117;
        String r35 = r17.getRefMessageId();
    L118:
        if (r35 != null) goto L120;
    L123:
        boolean r36 = true;
    L124:
        if (r36 == true) goto L126;
        BuildersKt.launch$default(this.H0, null, null, new ObricSpecialInputComponent$goToComplexAdditionPanel$2(this, r17, r22, null), 3, null);
        goto L126
    L120:
        if (r35.length() == 0) goto L123;
        r36 = false;
        goto L124
    L117:
        r35 = null;
    L126:
        View r37 = e4();
        if (r37 == null) goto L178;
        com.larus.utils.e1.x(r37);
        goto L178
    L113:
        r34 = false;
        goto L114
    L73:
        r25 = false;
    L67:
        r24 = null;
        goto L68
    L129:
        if (r17 != null) goto L131;
    L133:
        boolean r38 = false;
    L134:
        if (r38 == true) goto L147;
        if (r18 == true) goto L147;
        X5();
        if (r17 != null) goto L140;
    L142:
        boolean r39 = false;
    L143:
        if (r39 == false) goto L145;
        FrameLayout r40 = r20.c;
        r40.removeAllViews();
        AppCompatTextView r41 = new AppCompatTextView(r40.getContext());
        r6(r41);
        r40.addView(r41);
        Intrinsics.checkNotNull(r40);
        com.larus.utils.e1.x(r40);
        s5();
    L166:
        AppCompatTextView r42 = null;
    L167:
        if (r42 == null) goto L178;
        r15.addView(r42);
        r15.measure(View.MeasureSpec.makeMeasureSpec(B4(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (r15.getMeasuredHeight() <= i5.w()) goto L178;
        ScrollView r43 = Z3();
        if (r43 == null) goto L175;
        ViewGroup.LayoutParams r44 = r43.getLayoutParams();
        if (r44 == null) goto L175;
        r44.height = i5.w();
    L175:
        ObricActionBarSendServiceDelegate.b.k(true);
        ScrollView r45 = Z3();
        if (r45 == null) goto L178;
        r45.postDelayed(new u(this), 50);
        goto L178
    L145:
        E3(false);
        r42 = new AppCompatTextView(getContext());
        r6(r42);
        goto L167
    L140:
        if (r17.getRequestType() != 1) goto L142;
        r39 = true;
    L147:
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L149;
        r2.i("ObricSpecialInputComponent", "special input is open, closeSpecialInputPanel");
        e90();
    L149:
        com.larus.utils.e1.o(r20.c);
        p3(r20.d, v4());
        com.larus.utils.e1.x(r20.f);
        View r46 = e4();
        if (r46 == null) goto L152;
        com.larus.utils.e1.x(r46);
    L152:
        ObricActionBarTrackServiceExtDelegate r47 = ObricActionBarTrackServiceExtDelegate.b;
        com.larus.bmhome.chat.component.cvs.y r48 = a4();
        if (r48 == null) goto L160;
        wc9.e r49 = r48.h();
        if (r49 == null) goto L160;
        String r50 = r49.a;
        if (r50 == null) goto L160;
        r110 = r50;
    L160:
        com.larus.bmhome.chat.component.cvs.y r51 = a4();
        long r52 = 0;
        if (r51 == null) goto L165;
        String r53 = r51.getBotId();
        if (r53 == null) goto L165;
        r52 = CastLongProtector.parseLong(r53);     // Catch: Throwable -> L199
    L165:
        r47.l(r110, r52);
        goto L166
    L131:
        if (r17.getRequestType() != 0) goto L133;
        r38 = true;
    L178:
        qaa.a r54 = (qaa.a) this.t.getValue();
        if (r54 == null) goto L181;
        r54.Fo(true, null, null);
    L181:
        if (r17 != null) goto L183;
    L185:
        r16 = false;
    L186:
        if (r16 == false) goto L202;
        String r1 = x5(r17.getContent());
        if (r1 == null) goto L203;
        ICoreInputAbility r55 = c4();
        if (r55 == null) goto L192;
        ICoreInputAbility.b.d(r55, r1, false, false, null, null, false, 62);
    L192:
        qaa.a r56 = (qaa.a) this.t.getValue();
        if (r56 == null) goto L195;
        r56.yh(r1);
    L195:
        ICoreInputAbility r57 = c4();
        if (r57 == null) goto L204;
        ICoreInputAbility.b.e(r57, "obric_special_input", null, false, 6);
        return;
    L204:
        return;
    L203:
        return;
    L202:
        return;
    L183:
        if (r17.getRequestType() != 0) goto L185;
    L47:
        r13 = null;
        goto L48
    L28:
        r10 = null;
    L18:
        boolean r58 = v19.h.a;
        if (v19.h.b(getContext()) == false) goto L21;
        r7 = h4(2131244362);
        goto L22
    L21:
        r7 = h4(2131244361);
        goto L22
    L5:
        if (Intrinsics.areEqual(r4.b, "obric_quick_instruction") == false) goto L7;
        goto L7
    }

    public final void zI(boolean r41, StateInfo r42, ObricSpecialInputScene r43, com.larus.bmhome.actionbar.model.z0 r44, boolean r45, boolean r46) {
        ObricSpecialInputScene r0 = r43;
        FLogger r10 = FLogger.a;
        StringBuilder r4 = new StringBuilder("openSpecialInputPanel: isToWindow = ");
        r4.append(r41);
        r4.append(", scene = ");
        r4.append(r0);
        r4.append(", isAutoOpen = ");
        r4.append(r45);
        r4.append(", isIdle = ");
        r4.append(r46);
        r4.append(", stateInfo ");
        if (r42 == null) goto L5;
        String r5 = com.obric.assistant.utils.m.b(r42);
    L6:
        r4.append(r5);
        r4.append(", item = ");
        r4.append(r44);
        r10.i("ObricSpecialInputComponent", r4.toString());
        this.Q = r44;
        if (r42 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        String r6 = "";
        if (r2 == false) goto L16;
        DMTaskState r15 = null;
    L45:
        if (r46 == true) goto L215;
        if (r42 != null) goto L48;
    L50:
        boolean r3 = false;
    L51:
        if (r3 == true) goto L215;
        if (r42 != null) goto L56;
        r10.e("ObricSpecialInputComponent", "stateInfo is null");
        return;
    L56:
        if (r0 != null) goto L61;
        ObricSpecialInputScene.a r1 = ObricSpecialInputScene.Companion;
        String r7 = r42.getTaskType();
        r1.getClass();
        r0 = ObricSpecialInputScene.a.a(r7);
        if (r0 != null) goto L61;
        return;
    L61:
        if (r42.getRequestType() != 0) goto L88;
        laa.v r8 = (laa.v) this.P.getValue();
        if (r8 == null) goto L65;
        ObricSpecialInputScene r9 = r8.c;
    L67:
        if (r9 == ObricSpecialInputScene.OAUTO_GUI) goto L87;
        laa.v r11 = (laa.v) this.P.getValue();
        if (r11 == null) goto L71;
        ObricSpecialInputScene r12 = r11.c;
    L73:
        if (r12 == ObricSpecialInputScene.OAUTO_TIMER_TASK) goto L87;
        r10.i("ObricSpecialInputComponent", "checkIsSpecialInputOpen: create oauto task and close panel");
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L77;
        e90();
        goto L87
    L77:
        com.larus.bmhome.instruction.g r13 = j4();
        if (r13 != null) goto L80;
    L82:
        boolean r14 = false;
    L83:
        if (r14 == false) goto L87;
        com.larus.bmhome.instruction.g r16 = j4();
        if (r16 == null) goto L87;
        r16.A1();
        goto L87
    L80:
        if (r13.z0() != true) goto L82;
        r14 = true;
        goto L83
    L71:
        r12 = null;
    L87:
        r10.i("ObricSpecialInputComponent", "checkIsSpecialInputOpen: create oauto task");
    L119:
        boolean r17 = false;
    L120:
        if (r17 == false) goto L122;
        return;
    L122:
        StateFlowImpl r18 = this.O;
        ObricSpecialInputScene r19 = ObricSpecialInputScene.COMPLEX_TASK;
        if (r42.getRequestType() != 0) goto L125;
    L127:
        boolean r110 = false;
    L128:
        Map r20 = r42.getExt();
        if (r20 == null) goto L131;
        String r21 = (String) r20.get("is_condition_task");
    L132:
        r18.setValue(new laa.v(r15, r42, r19, r41, r110, Intrinsics.areEqual(r21, "1")));
        laa.v r22 = (laa.v) this.P.getValue();
        if (r22 == null) goto L135;
        ObricSpecialInputScene r23 = r22.c;
    L137:
        if (r23 != r19) goto L149;
        int r24 = r42.getRequestType();
        if (r24 == ObricComplexTaskPanelType.IDLE.getValue()) goto L148;
        if (r24 == 0) goto L148;
        if (r24 != ObricComplexTaskPanelType.ADDITION.getValue()) goto L146;
        r10.i("ObricSpecialInputComponent", "openSpecialInputPanel: ObricComplexTaskPanelType.ADDITION.value");
        ObricTaskStatusManager.a.getClass();
        ObricTaskStatusManager.f("addition_complex_task");
        SpecialTrackEventUtilsKt.f(r15, r42);
        goto L149
    L146:
        if (r24 != ObricComplexTaskPanelType.CLARIFYING.getValue()) goto L149;
        r10.i("ObricSpecialInputComponent", "openSpecialInputPanel: ObricComplexTaskPanelType.CLARIFYING.value");
        ObricTaskStatusManager.a.getClass();
        ObricTaskStatusManager.f("clarify_complex_task");
        SpecialTrackEventUtilsKt.e(r15, r42);
    L148:
        r10.i("ObricSpecialInputComponent", "openSpecialInputPanel: ObricComplexTaskPanelType.IDLE.value");
        ObricTaskStatusManager.a.getClass();
        ObricTaskStatusManager.f("start_complex_task");
    L149:
        h5(r42, false, r15);
        ICoreInputAbility r25 = c4();
        if (r25 != null) goto L152;
    L154:
        W5();
        V5();
        if (r0 != r19) goto L161;
        ObricTaskStatusManager.a.getClass();
        if (Intrinsics.areEqual(ObricTaskStatusManager.b(), "clarify_complex_task") == false) goto L161;
        com.obric.assistant.live.api.j r26 = com.obric.assistant.live.api.j.a;
        if (r26.e() == false) goto L161;
        boolean r27 = true;
        r26.m(true);
    L162:
        this.K.setValue(Boolean.TRUE);
        o5();
        m6(r27);
        Iterator r28 = ((ArrayList) this.M).iterator();
    L164:
        if (r28.hasNext() == false) goto L172;
        laa.u r29 = (laa.u) r28.next();
        if (r42.getRequestType() == 0) goto L164;
        laa.v r30 = (laa.v) this.P.getValue();
        if (r30 == null) goto L170;
        DMTaskState r31 = r30.a;
    L171:
        r29.a(new laa.t(true, r42, null, r31));
        goto L164
    L170:
        r31 = null;
        goto L171
    L172:
        Map r32 = r42.getExt();
        if (r32 == null) goto L191;
        String r33 = (String) r32.get("o_meta");
        if (r33 == null) goto L191;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L182
        if (com.larus.utils.o0.d(r33) == false) goto L179;
        w0 r35 = (w0) new Gson().fromJson(r33, w0.class);     // Catch: Throwable -> L182
    L180:
        Object r36 = Result.constructor-impl(r35);     // Catch: Throwable -> L182
    L184:
        Throwable r37 = Result.exceptionOrNull-impl(r36);
        if (r37 == null) goto L188;
        FLogger.a.w("ObricSpecialInputComponent", "parse meta failed", r37);
    L188:
        if (Result.isFailure-impl(r36) == false) goto L190;
        r36 = null;
    L190:
        w0 r38 = (w0) r36;
    L192:
        ICoreInputAbility r39 = c4();
        if (r39 != null) goto L195;
    L197:
        boolean r111 = false;
    L198:
        if (r111 == true) goto L200;
        return;
    L200:
        if (r42.getStartWithAsr() == true) goto L259;
        if (r38 == null) goto L203;
        boolean r40 = Intrinsics.areEqual(r38.a(), Boolean.TRUE);
    L204:
        if (r40 == true) goto L260;
        ObricTaskStatusManager.a.getClass();
        if (Intrinsics.areEqual(ObricTaskStatusManager.b(), "clarify_complex_task") == true) goto L208;
    L210:
        ICoreInputAbility r47 = c4();
        if (r47 == null) goto L261;
        ICoreInputAbility.b.e(r47, "obric_special_input", null, false, 6);
        return;
    L261:
        return;
    L208:
        if (T4() == false) goto L210;
        return;
    L260:
        return;
    L203:
        r40 = false;
        goto L204
    L259:
        return;
    L195:
        if (r39.Rp() != 1) goto L197;
        r111 = true;
        goto L198
    L179:
        r35 = null;
    L182:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
    L191:
        r38 = null;
    L161:
        r27 = true;
        goto L162
    L152:
        if (r25.Rp() != 2) goto L154;
        r25.g2(2, true);
        goto L154
    L135:
        r23 = null;
        goto L137
    L131:
        r21 = null;
        goto L132
    L125:
        if (r0 != ObricSpecialInputScene.OAUTO_TIMER_TASK) goto L127;
        r110 = true;
        goto L128
    L65:
        r9 = null;
        goto L67
    L88:
        laa.v r49 = (laa.v) this.P.getValue();
        if (r49 == null) goto L91;
        StateInfo r50 = r49.b;
    L92:
        if (r50 != null) goto L95;
    L103:
        boolean r51 = false;
    L104:
        if (r51 == false) goto L106;
        r10.i("ObricSpecialInputComponent", "checkIsSpecialInputOpen: same state");
        r17 = true;
        goto L120
    L106:
        r10.i("ObricSpecialInputComponent", "checkIsSpecialInputOpen: different state");
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L109;
        e90();
        goto L119
    L109:
        com.larus.bmhome.instruction.g r52 = j4();
        if (r52 != null) goto L112;
    L114:
        boolean r53 = false;
    L115:
        if (r53 == false) goto L119;
        com.larus.bmhome.instruction.g r54 = j4();
        if (r54 == null) goto L119;
        r54.A1();
        goto L119
    L112:
        if (r52.z0() != true) goto L114;
        r53 = true;
        goto L115
    L95:
        if (r42.getRequestType() != r50.getRequestType()) goto L103;
        if (Intrinsics.areEqual(r42.getContent(), r50.getContent()) == false) goto L103;
        if (Intrinsics.areEqual(r42.getRefMessageId(), r50.getRefMessageId()) == false) goto L103;
        if (Intrinsics.areEqual(r42.getTaskType(), r50.getTaskType()) == false) goto L103;
        r51 = true;
        goto L104
    L91:
        r50 = null;
        goto L92
    L48:
        if (r42.getRequestType() != 0) goto L50;
        r3 = true;
    L215:
        if (((Boolean) this.L.getValue()).booleanValue() == false) goto L217;
        r10.i("ObricSpecialInputComponent", "special input is open, closeSpecialInputPanel");
        e90();
    L217:
        ObricTaskMode r55 = ObricTaskMode.PRO;
        r10.i("ObricSpecialInputComponent", "openStartTaskPanel: taskType = " + r55);
        if (r55.isComplexTask() == false) goto L220;
        ObricTaskStatusManager.a.getClass();
        ObricTaskStatusManager.f("start_complex_task");
    L220:
        ObricTaskStatusManager.a.getClass();
        ObricTaskStatusManager.g(true);
        ObricSpecialInputScene r112 = ObricSpecialInputScene.COMPLEX_TASK;
        h5(null, true, r15);
        this.O.setValue(new laa.v(r15, null, r112, false, false, false));
        this.K.setValue(Boolean.TRUE);
        o5();
        ObricActionBarTrackServiceExtDelegate r56 = ObricActionBarTrackServiceExtDelegate.b;
        com.larus.bmhome.actionbar.model.z0 r57 = new com.larus.bmhome.actionbar.model.z0(null, "obric_omni", null, null, null, null, null, null, null, null, null, null, false, null, null, -3, 15);
        com.larus.bmhome.chat.component.cvs.y r58 = a4();
        if (r58 == null) goto L226;
        String r59 = r58.getBotId();
        if (r59 == null) goto L226;
        r6 = r59;
    L226:
        com.larus.bmhome.chat.component.cvs.y r60 = a4();
        long r61 = 0;
        if (r60 == null) goto L235;
        wc9.e r62 = r60.h();
        if (r62 == null) goto L235;
        String r63 = r62.a;
        if (r63 == null) goto L235;
        r61 = CastLongProtector.parseLong(r63);     // Catch: Throwable -> L234
    L235:
        r56.g(r57, r6, r61);
        W5();
        V5();
        m6(true);
        if (r42 == null) goto L245;
        String r64 = x5(r42.getContent());
        if (r64 == null) goto L245;
        ICoreInputAbility r65 = c4();
        if (r65 == null) goto L242;
        ICoreInputAbility.b.d(r65, r64, false, false, null, null, false, 62);
    L242:
        qaa.a r66 = (qaa.a) this.t.getValue();
        if (r66 == null) goto L245;
        r66.yh(r64);
    L245:
        ICoreInputAbility r67 = c4();
        if (r67 == null) goto L262;
        ICoreInputAbility.b.e(r67, "obric_oauto_special_input", null, false, 6);
        return;
    L262:
        return;
    L16:
        if (r42 != null) goto L18;
        r10.w("ObricSpecialInputComponent", "findTaskByStateInfo: stateInfo is null");
    L42:
        DMTaskState r68 = null;
    L43:
        r15 = r68;
        goto L45
    L18:
        Map r69 = r42.getExt();
        if (r69 == null) goto L21;
        String r70 = (String) r69.get("o_omni_task_id");
    L22:
        if (r70 != null) goto L24;
    L27:
        boolean r71 = true;
    L29:
        if (r71 == true) goto L33;
        ObricTaskStatusManager.a.getClass();
        r68 = ObricTaskStatusManager.e(r70);
        if (r68 == null) goto L33;
        r10.i("ObricSpecialInputComponent", "findTaskByStateInfo: found task by omniTaskId " + r70 + ", taskId " + r68.getTaskId());
    L33:
        String r72 = r42.getRefMessageId();
        if (r72 != null) goto L37;
        r72 = "";
    L37:
        if (com.larus.utils.o0.d(r72) == false) goto L41;
        ObricTaskStatusManager.a.getClass();
        r68 = ObricTaskStatusManager.d(r72);
        if (r68 == null) goto L41;
        r10.i("ObricSpecialInputComponent", "findTaskByStateInfo: found task by refMessageId " + r72 + ", taskId " + r68.getTaskId());
    L41:
        r10.i("ObricSpecialInputComponent", "no running related task");
        goto L42
    L24:
        if (r70.length() == 0) goto L27;
        r71 = false;
        goto L29
    L21:
        r70 = null;
        goto L22
    L10:
        if (r42.getRequestType() != 0) goto L12;
        r2 = true;
        goto L13
    L5:
        r5 = null;
        goto L6
    }
}
