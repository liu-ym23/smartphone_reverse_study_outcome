package com.obric.assistant.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.asr.VoiceInputType;
import com.larus.asr.view.ChatSpeaker;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.speaker.SessionType;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.bmhome.chat.component.bottom.reference.a;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.obric.assistant.spi.startup.AssistantStartupTelemetry;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.obric.assistant.spi.window.WindowOpenSource;
import com.obric.assistant.util.f2;
import com.obric.assistant.view.LongPressMockView;
import com.obric.assistant.view.continuespeech.AudioContinueGradientView;
import com.obric.assistant.view.glowui.OverlayerAudioView;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.audio.continuous_talk.ObricContinuousTalkEndType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import de8.c;
import hca.b;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import laa.f;
import s1a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000Ä\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0006\u008a\u0001\u008d\u0001\u0093\u0001\b\u0007\u0018\u0000 Å\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\bÅ\u0002Æ\u0002Ç\u0002È\u0002B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u008f\u0001\u001a\u00030\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0087\u0001H\u0002J\n\u0010Ã\u0001\u001a\u00030\u0090\u0001H\u0016J\n\u0010Ä\u0001\u001a\u00030\u0090\u0001H\u0016J\u0014\u0010Å\u0001\u001a\u00030\u0090\u00012\b\u0010Æ\u0001\u001a\u00030Ç\u0001H\u0016J\n\u0010È\u0001\u001a\u00030\u0090\u0001H\u0016J\n\u0010É\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030\u0090\u0001H\u0002J\u000b\u0010Ë\u0001\u001a\u0004\u0018\u00010TH\u0002J\n\u0010Ì\u0001\u001a\u00030\u0090\u0001H\u0016J\n\u0010Í\u0001\u001a\u00030\u0090\u0001H\u0016J\n\u0010Î\u0001\u001a\u00030\u0090\u0001H\u0016J\n\u0010Ï\u0001\u001a\u00030\u0090\u0001H\u0016J\t\u0010Ð\u0001\u001a\u00020\u007fH\u0002J\n\u0010Ñ\u0001\u001a\u00030\u0090\u0001H\u0002J\u001b\u0010Ò\u0001\u001a\u00020\u007f2\n\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001H\u0002¢\u0006\u0003\u0010Õ\u0001J\n\u0010Ö\u0001\u001a\u00030\u0090\u0001H\u0002J\n\u0010×\u0001\u001a\u00030\u0090\u0001H\u0002J\u0016\u0010Ø\u0001\u001a\u0005\u0018\u00010\u0083\u00012\b\u0010Ù\u0001\u001a\u00030\u0087\u0001H\u0002J9\u0010Ú\u0001\u001a\u00020\u007f2\u0007\u0010Û\u0001\u001a\u00020\u007f2\n\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u00012\u0007\u0010Þ\u0001\u001a\u00020\u007fH\u0002¢\u0006\u0003\u0010ß\u0001J\u0016\u0010à\u0001\u001a\u00030\u0090\u00012\n\u0010á\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0016J1\u0010â\u0001\u001a\u00030\u0090\u00012\u0007\u0010Û\u0001\u001a\u00020\u007f2\n\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u00012\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016¢\u0006\u0003\u0010ã\u0001J\n\u0010ä\u0001\u001a\u00030\u0090\u0001H\u0016J\u001d\u0010å\u0001\u001a\u00030\u0090\u00012\b\u0010æ\u0001\u001a\u00030\u0087\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u007fH\u0016J\u001e\u0010ç\u0001\u001a\u00030\u0090\u00012\b\u0010è\u0001\u001a\u00030\u0081\u00012\b\u0010Æ\u0001\u001a\u00030\u0087\u0001H\u0002J\t\u0010é\u0001\u001a\u00020\u007fH\u0016J\t\u0010ê\u0001\u001a\u00020\u007fH\u0016J\u0014\u0010ë\u0001\u001a\u00030\u0090\u00012\b\u0010ì\u0001\u001a\u00030\u0088\u0001H\u0002J\u0013\u0010í\u0001\u001a\u00030\u0090\u00012\u0007\u0010î\u0001\u001a\u00020\u007fH\u0016J5\u0010ï\u0001\u001a\u00030\u0090\u00012)\u0010\u0097\u0001\u001a$\u0012\u0016\u0012\u00140\u007f¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(î\u0001\u0012\u0005\u0012\u00030\u0090\u0001\u0018\u00010\u0098\u0001H\u0016J\u0010\u0010ð\u0001\u001a\t\u0012\u0004\u0012\u00020\u007f0ñ\u0001H\u0016J\u0013\u0010ò\u0001\u001a\u00030\u0090\u00012\u0007\u0010ó\u0001\u001a\u00020\u007fH\u0016J\u001e\u0010ô\u0001\u001a\u00030\u0090\u00012\b\u0010õ\u0001\u001a\u00030Ô\u00012\b\u0010ö\u0001\u001a\u00030Ô\u0001H\u0016J\n\u0010÷\u0001\u001a\u00030\u0090\u0001H\u0016J\n\u0010ø\u0001\u001a\u00030\u0088\u0001H\u0016J \u0010ù\u0001\u001a\u00030\u0090\u00012\b\u0010ú\u0001\u001a\u00030û\u00012\n\u0010ì\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J \u0010ü\u0001\u001a\u00030\u0090\u00012\b\u0010ý\u0001\u001a\u00030¡\u00012\n\u0010ì\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J\u0016\u0010þ\u0001\u001a\u0005\u0018\u00010\u0088\u00012\b\u0010æ\u0001\u001a\u00030\u0087\u0001H\u0016J\u0014\u0010ÿ\u0001\u001a\u00030\u0090\u00012\b\u0010\u0080\u0002\u001a\u00030\u0088\u0001H\u0016J\u0014\u0010\u0081\u0002\u001a\u00030\u0090\u00012\b\u0010æ\u0001\u001a\u00030\u0087\u0001H\u0016J\u001e\u0010\u0082\u0002\u001a\u00030\u0090\u00012\b\u0010è\u0001\u001a\u00030\u0081\u00012\b\u0010Ù\u0001\u001a\u00030\u0087\u0001H\u0002J\u0014\u0010\u0083\u0002\u001a\u00030\u0090\u00012\b\u0010è\u0001\u001a\u00030\u0081\u0001H\u0002J,\u0010\u0084\u0002\u001a\u00030\u0090\u00012\b\u0010\u0085\u0002\u001a\u00030\u0087\u00012\b\u0010Ù\u0001\u001a\u00030\u0087\u00012\f\b\u0002\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u00ad\u0001H\u0002J\u0014\u0010\u0087\u0002\u001a\u00030\u0090\u00012\b\u0010\u0088\u0002\u001a\u00030\u0089\u0002H\u0002J\u0013\u0010\u008a\u0002\u001a\u00030\u0090\u00012\u0007\u0010\u008b\u0002\u001a\u00020\u007fH\u0016J\t\u0010\u008c\u0002\u001a\u00020\u007fH\u0016J\u0016\u0010\u008d\u0002\u001a\u00030\u0090\u00012\n\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002H\u0016J\u0016\u0010\u0090\u0002\u001a\u00030\u0090\u00012\n\u0010ì\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0016J\n\u0010\u0091\u0002\u001a\u00030\u0090\u0001H\u0002J\u0013\u0010\u0092\u0002\u001a\u00030\u0090\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u007fH\u0016J4\u0010\u0092\u0002\u001a\u00030\u0090\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u007f2\u0007\u0010\u0093\u0002\u001a\u00020\u007f2\n\u0010ì\u0001\u001a\u0005\u0018\u00010\u0088\u00012\n\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0087\u0001H\u0016J\u001f\u0010\u0095\u0002\u001a\u00030\u0090\u00012\u0007\u0010\u0096\u0002\u001a\u00020Y2\n\u0010á\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0002J\u001b\u0010\u0097\u0002\u001a\u00020\u007f2\u0007\u0010\u009b\u0001\u001a\u00020\u007f2\u0007\u0010\u0093\u0002\u001a\u00020\u007fH\u0002J\u0013\u0010\u0098\u0002\u001a\u00030\u0090\u00012\u0007\u0010\u0099\u0002\u001a\u00020\u007fH\u0002J\n\u0010\u009a\u0002\u001a\u00030\u0090\u0001H\u0002J\u0010\u0010\u009b\u0002\u001a\t\u0012\u0004\u0012\u00020Y0\u009c\u0002H\u0002J\n\u0010\u009d\u0002\u001a\u00030\u0090\u0001H\u0016J\n\u0010\u009e\u0002\u001a\u00030\u009f\u0002H\u0016J'\u0010 \u0002\u001a\u00030\u0090\u00012\u001b\u0010¡\u0002\u001a\u0016\u0012\u0005\u0012\u00030£\u00020¢\u0002j\n\u0012\u0005\u0012\u00030£\u0002`¤\u0002H\u0002J)\u0010¥\u0002\u001a\u0004\u0018\u00010\u007f2\u0016\u0010¦\u0002\u001a\u0011\u0012\u0005\u0012\u00030¡\u0001\u0012\u0005\u0012\u00030¡\u00010 \u0001H\u0016¢\u0006\u0003\u0010§\u0002J$\u0010¨\u0002\u001a\u00030\u0090\u00012\u0018\u0010¦\u0002\u001a\u0013\u0012\u0005\u0012\u00030¡\u0001\u0012\u0005\u0012\u00030¡\u0001\u0018\u00010 \u0001H\u0016J\n\u0010©\u0002\u001a\u00030\u0090\u0001H\u0016J0\u0010ª\u0002\u001a\u0011\u0012\u0005\u0012\u00030¡\u0001\u0012\u0005\u0012\u00030¡\u00010 \u00012\u0016\u0010¦\u0002\u001a\u0011\u0012\u0005\u0012\u00030¡\u0001\u0012\u0005\u0012\u00030¡\u00010 \u0001H\u0002J\u000b\u0010«\u0002\u001a\u0004\u0018\u00010YH\u0016J\u000b\u0010¬\u0002\u001a\u0004\u0018\u00010YH\u0002J,\u0010\u00ad\u0002\u001a\u00030\u0090\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u007f2\f\b\u0002\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u00022\t\b\u0002\u0010\u0093\u0002\u001a\u00020\u007fH\u0002J\u0013\u0010®\u0002\u001a\u00030\u0090\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u007fH\u0002J\t\u0010¯\u0002\u001a\u00020\u007fH\u0016J\u001e\u0010°\u0002\u001a\u00030\u0090\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u007f2\t\b\u0002\u0010\u0093\u0002\u001a\u00020\u007fH\u0002J\u0017\u0010±\u0002\u001a\u00020\u007f2\f\b\u0002\u0010\u008e\u0002\u001a\u0005\u0018\u00010\u008f\u0002H\u0002J\t\u0010²\u0002\u001a\u00020\u007fH\u0002J\t\u0010³\u0002\u001a\u00020\u007fH\u0002J\t\u0010´\u0002\u001a\u00020\u007fH\u0002J\n\u0010µ\u0002\u001a\u00030\u0090\u0001H\u0002J\u0013\u0010¶\u0002\u001a\u00030\u0090\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u007fH\u0002J:\u0010·\u0002\u001a\u00030\u0090\u00012\u0007\u0010¸\u0002\u001a\u00020Y2\u0007\u0010\u009b\u0001\u001a\u00020\u007f2\u0007\u0010¹\u0002\u001a\u00020\u007f2\u0013\b\u0002\u0010º\u0002\u001a\f\u0012\u0005\u0012\u00030\u0090\u0001\u0018\u00010»\u0002H\u0002J\n\u0010¼\u0002\u001a\u00030\u0090\u0001H\u0002J\u000b\u0010½\u0002\u001a\u0004\u0018\u00010TH\u0002J\u0015\u0010¾\u0002\u001a\u00020\u007f2\n\u0010¿\u0002\u001a\u0005\u0018\u00010À\u0002H\u0002J\u0016\u0010Á\u0002\u001a\u0005\u0018\u00010À\u00022\b\u0010Â\u0002\u001a\u00030\u0087\u0001H\u0002J\t\u0010Ã\u0002\u001a\u00020\u007fH\u0002J\n\u0010Ä\u0002\u001a\u00030\u0090\u0001H\u0002R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u001d\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b(\u0010)R\u001d\u0010+\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\f\u001a\u0004\b-\u0010.R\u001d\u00100\u001a\u0004\u0018\u0001018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\f\u001a\u0004\b2\u00103R\u001d\u00105\u001a\u0004\u0018\u0001068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\f\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\f\u001a\u0004\b<\u0010=R\u001d\u0010?\u001a\u0004\u0018\u00010@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\f\u001a\u0004\bA\u0010BR\u001d\u0010D\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\f\u001a\u0004\bF\u0010GR\u001d\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\f\u001a\u0004\bK\u0010LR\u001d\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\f\u001a\u0004\bP\u0010QR\u001d\u0010S\u001a\u0004\u0018\u00010T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010\f\u001a\u0004\bU\u0010VR\u001d\u0010X\u001a\u0004\u0018\u00010Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\f\u001a\u0004\bZ\u0010[R\u001d\u0010]\u001a\u0004\u0018\u00010^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\f\u001a\u0004\b_\u0010`R\u001d\u0010b\u001a\u0004\u0018\u00010c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010\f\u001a\u0004\bd\u0010eR\u001d\u0010g\u001a\u0004\u0018\u00010h8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\f\u001a\u0004\bi\u0010jR\u001d\u0010l\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\f\u001a\u0004\bm\u0010\u0015R\u001d\u0010o\u001a\u0004\u0018\u00010p8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bs\u0010\f\u001a\u0004\bq\u0010rR\u001d\u0010t\u001a\u0004\u0018\u00010u8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\f\u001a\u0004\bv\u0010wR\u001d\u0010y\u001a\u0004\u0018\u00010z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b}\u0010\f\u001a\u0004\b{\u0010|R\u000e\u0010~\u001a\u00020\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0084\u0001\u001a\u00020\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0085\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0087\u0001\u0012\u0005\u0012\u00030\u0088\u00010\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001R\u0013\u0010\u008c\u0001\u001a\u00030\u008d\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008e\u0001R \u0010\u0092\u0001\u001a\u00030\u0093\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0096\u0001\u0010\f\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R1\u0010\u0097\u0001\u001a$\u0012\u0016\u0012\u00140\u007f¢\u0006\u000f\b\u0099\u0001\u0012\n\b\u009a\u0001\u0012\u0005\b\b(\u009b\u0001\u0012\u0005\u0012\u00030\u0090\u0001\u0018\u00010\u0098\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u009c\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u007f\u0012\u0005\u0012\u00030\u0090\u00010\u0098\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u007f0\u009e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u009f\u0001\u001a\u0013\u0012\u0005\u0012\u00030¡\u0001\u0012\u0005\u0012\u00030¡\u0001\u0018\u00010 \u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u00020\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010£\u0001\u001a\u00020\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¤\u0001\u001a\u00020\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010¥\u0001\u001a\u0005\u0018\u00010¡\u0001X\u0082\u000e¢\u0006\u0005\n\u0003\u0010¦\u0001R \u0010§\u0001\u001a\u00030¨\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b«\u0001\u0010\f\u001a\u0006\b©\u0001\u0010ª\u0001R\u0012\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010®\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0087\u0001\u0012\u0005\u0012\u00030\u00ad\u00010\u0086\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010¯\u0001\u001a\u00030°\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b³\u0001\u0010\f\u001a\u0006\b±\u0001\u0010²\u0001R \u0010´\u0001\u001a\u00030µ\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¸\u0001\u0010\f\u001a\u0006\b¶\u0001\u0010·\u0001R\u001e\u0010¹\u0001\u001a\u00020^8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b»\u0001\u0010\f\u001a\u0005\bº\u0001\u0010`R \u0010¼\u0001\u001a\u00030½\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÀ\u0001\u0010\f\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0010\u0010Á\u0001\u001a\u00030Â\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006É\u0002"}, d2 = {"Lcom/obric/assistant/component/ObricIntercomComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/obric/assistant/ability/IObricIntercomAbility;", "Lcom/obric/assistant/callback/IChatStyleChangedCallback;", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "speakerAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "getSpeakerAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IChatBottomSpeakerAbility;", "speakerAbility$delegate", "speakerExtraAbility", "Lcom/larus/bmhome/chat/component/bottom/core/speaker/IOChatBottomSpeakerExtraAbility;", "getSpeakerExtraAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/speaker/IOChatBottomSpeakerExtraAbility;", "speakerExtraAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "continuousTalkCtrlAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "getContinuousTalkCtrlAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkCtrlAbility;", "continuousTalkCtrlAbility$delegate", "continuousTalkUIAbility", "Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "getContinuousTalkUIAbility", "()Lcom/obric/audio/continuous_talk/IObricContinuousTalkAbility;", "continuousTalkUIAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "bottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "bottomAbility$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "attachmentPanelAbility", "Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "getAttachmentPanelAbility", "()Lcom/larus/bmhome/chat/component/bottom/attachment/IAttachmentPanelAbility;", "attachmentPanelAbility$delegate", "touchSpeakerEventAbility", "Lcom/obric/assistant/ability/audio/ITouchSpeakEventAbility;", "getTouchSpeakerEventAbility", "()Lcom/obric/assistant/ability/audio/ITouchSpeakEventAbility;", "touchSpeakerEventAbility$delegate", "collectMessageAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "getCollectMessageAbility", "()Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "collectMessageAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "chatRoot", "Landroid/view/ViewGroup;", "getChatRoot", "()Landroid/view/ViewGroup;", "chatRoot$delegate", "input", "Landroid/view/View;", "getInput", "()Landroid/view/View;", "input$delegate", "titleContainer", "Landroid/widget/FrameLayout;", "getTitleContainer", "()Landroid/widget/FrameLayout;", "titleContainer$delegate", "specialInputAbility", "Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "getSpecialInputAbility", "()Lcom/obric/assistant/ability/IObricSpecialInputAbility;", "specialInputAbility$delegate", "shareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "shareAbility$delegate", "bottomSpeakerAbility", "getBottomSpeakerAbility", "bottomSpeakerAbility$delegate", "referenceMsgAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getReferenceMsgAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "referenceMsgAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "paused", "", "currentTouchTask", "Lcom/obric/assistant/component/ObricIntercomComponent$TouchListeningTask;", "pendingTouchSpeakRequest", "Lcom/obric/assistant/component/ObricIntercomComponent$PendingTouchSpeakRequest;", "conversationReadyListenerRegistered", "touchListeningUiHandlesByTaskId", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/assistant/ability/ObricListeningUiHandle;", "conversationReadyListener", "com/obric/assistant/component/ObricIntercomComponent$conversationReadyListener$1", "Lcom/obric/assistant/component/ObricIntercomComponent$conversationReadyListener$1;", "touchAsrLifeStateListener", "com/obric/assistant/component/ObricIntercomComponent$touchAsrLifeStateListener$1", "Lcom/obric/assistant/component/ObricIntercomComponent$touchAsrLifeStateListener$1;", "handlePendingTouchSpeakRequest", "", "conversationId", "specialInputStateListener", "com/obric/assistant/component/ObricIntercomComponent$specialInputStateListener$2$1", "getSpecialInputStateListener", "()Lcom/obric/assistant/component/ObricIntercomComponent$specialInputStateListener$2$1;", "specialInputStateListener$delegate", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", DBDefinition.NAME, "visible", "suggestActionBarCallback", "overlayerViewVisibilityState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "lastTouchPosition", "Lkotlin/Pair;", "", "isDestroyed", "isWindowEnable", "inputHiddenForDelegatedPresentation", "chatSpeakerAlphaBeforeDelegatedPresentation", "Ljava/lang/Float;", "listeningViewController", "Lcom/obric/assistant/view/listening/ObricListeningViewController;", "getListeningViewController", "()Lcom/obric/assistant/view/listening/ObricListeningViewController;", "listeningViewController$delegate", "touchSpeakStartupSession", "Lcom/obric/assistant/spi/startup/AssistantStartupAudioSession;", "startupSessionByTaskId", "mockView", "Lcom/obric/assistant/view/LongPressMockView;", "getMockView", "()Lcom/obric/assistant/view/LongPressMockView;", "mockView$delegate", "voiceView", "Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "getVoiceView", "()Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "voiceView$delegate", "voiceViewContainer", "getVoiceViewContainer", "voiceViewContainer$delegate", "overlayContainer", "Lcom/obric/assistant/view/glowui/OverlayerAudioView;", "getOverlayContainer", "()Lcom/obric/assistant/view/glowui/OverlayerAudioView;", "overlayContainer$delegate", "selectModeCallback", "Lcom/obric/assistant/callback/ISelectModeCallback;", "onCreate", "onParentViewCreated", "onWindowOpened", "source", "Lcom/obric/assistant/spi/window/WindowOpenSource;", "onWindowStashed", "addExtraViews", "addExtraViewsV2", "getOverlayRoot", "onStart", "onStop", "onResume", "onDestroy", "isReleasedAiKeyLongPress", "consumeReleasedAiKeyLongPress", "isDoraRadioSpeak", "vuiId", "", "(Ljava/lang/Integer;)Z", "registerConversationReadyListenerIfNeeded", "unregisterConversationReadyListener", "cancelPendingTouchSpeak", "reason", "deferTouchSpeakUntilConversationReady", "needVibrate", "preStartTime", "", "isReleasedLongPress", "(ZLjava/lang/Integer;Ljava/lang/Long;Z)Z", "bindStartupAttempt", "attemptId", "startTouchSpeak", "(ZLjava/lang/Integer;Ljava/lang/Long;)V", "stopTouchSpeak", "onTouchSpeakerVisibilityChanged", DBDefinition.TASK_ID, "dispatchPendingTouchTerminal", "task", "isTouchSpeakPendingConversation", "supportIntercom", "mockLongPressAi", "listeningUiHandle", "hideLongPress", "success", "setVisibilityChangeCallback", "getOverlayerVisibilityState", "Lkotlinx/coroutines/flow/StateFlow;", "onMenuEntranceStatusChanged", "showMenu", "onUpdateBottomMenuHeight", "curHeight", "normalHeight", "onAiKeyShortClick", "captureListeningUiHandle", "setAudioData", "data", "", "setAudioVolume", "volume", "getListeningUiHandle", "finishListeningUiHandle", "handle", "finishListeningTask", "finishTouchListeningTask", "releaseTouchListeningTaskOwner", "finishTouchSpeakStartup", "result", "startupSession", "runInUiTread", "runnable", "Ljava/lang/Runnable;", "onChatStyleChanged", "isChatWindow", "isMockViewVisible", "startSpeakLoading", DBDefinition.EXTRA, "Landroid/os/Bundle;", "stopSpeakLoading", "updateMockViewBg", "setClickTalkViewVisible", "isResumeClickTalk", "startupAttemptId", "bindLocalListeningFirstFrame", "view", "renderLocalClickTalkViewVisible", "updateLocalInputVisibilityForDelegatedPresentation", "listening", "hideLocalListeningVisualForDelegatedPresentation", "externalListeningInputTargets", "", "exitSelectMode", "getAudioVisualizer", "Lcom/obric/assistant/spi/chat/IObricAudioVisualizer;", "renderLocalAmplitude", "sampleData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "shouldCancel", "xy", "(Lkotlin/Pair;)Ljava/lang/Boolean;", "updateTouchPosition", "onOverlayPositionChanged", "adaptOverlayTouchPosition", "getAudioOverlay", "getAnchorView", "updateWindowAudioVisibility", "updateIntercomVisibility", "isHideInput", "updateClickTalkVisibility", "checkStartWindowScene", "shouldKeepWindowOverlayDuringIntercomSwitch", "isAiKeyIntercomActive", "isAiKeyPressing", "switchWindowOverlayToIntercom", "updateIntercomVisibilityState", "animateAlphaVisibility", "target", "manageVisibility", "onAnimationEnd", "Lkotlin/Function0;", "ensureWindowRootOverlayZ", "getIntercomRoot", "isNotMainBotPage", "hostFragment", "Landroidx/fragment/app/Fragment;", "getSafeHostFragment", "from", "asrOnly", "checkSpeakerMargin", "Companion", "TouchTerminalIntent", "TouchListeningTask", "PendingTouchSpeakRequest", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricIntercomComponent extends BaseContentWidget implements f, b, wga.b {
    public static final /* synthetic */ int h1 = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final ConcurrentHashMap<String, uga.b> H0;
    public final Lazy I;
    public final Lazy J;
    public boolean K;
    public c L;
    public final Lazy L0;
    public volatile b M;
    public boolean N;
    public final ConcurrentHashMap<String, laa.n> O;
    public final e P;
    public final Lazy P0;
    public final c0 Q;
    public final Lazy R;
    public Function1<? super Boolean, Unit> S;
    public final l1 T;
    public final StateFlowImpl U;
    public Pair<Float, Float> V;
    public final Lazy V0;
    public boolean W;
    public boolean X;
    public boolean Y;
    public Float Z;
    public final Lazy b1;
    public final g g1;
    public final Lazy k0;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public volatile uga.b p0;
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

    public static final class a0 implements Function0<c> {
        public final /* synthetic */ AttachReceiver a;

        public a0(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).g(Reflection.getOrCreateKotlinClass(c.class));
        }
    }

    public static final class c0 implements com.larus.bmhome.chat.component.bottom.core.speaker.b {
        public final /* synthetic */ ObricIntercomComponent a;

        public c0(ObricIntercomComponent r1) {
            this.a = r1;
        }

        public final void a(y58.b r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
        }

        public final void q(AsrLifeState r4, String r5, Map<String, String> r6) {
            Intrinsics.checkNotNullParameter(r4, "lifeState");
            c r7 = this.a.L;
            if (r7 != null) goto L5;
            return;
        L5:
            boolean r0 = true;
            if (r5 != null) goto L8;
        L11:
            boolean r2 = true;
        L12:
            if (r2 == false) goto L14;
        L16:
            r0 = false;
        L17:
            if (r0 == true) goto L19;
            return;
        L19:
            ObricIntercomComponent r8 = this.a;
            v2 r1 = new v2(r8, r7, r4);
            r8.getClass();
            ObricIntercomComponent.q4(r1);
            return;
        L14:
            if (r7.g.contains(r5) == false) goto L16;
        L8:
            if (r5.length() == 0) goto L11;
            r2 = false;
            goto L12
        }
    }

    public static final class e implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
        public final /* synthetic */ ObricIntercomComponent a;

        public e(ObricIntercomComponent r1) {
            this.a = r1;
        }

        public final void c(Object r3) {
            wc9.e r4 = (wc9.e) r3;
            Intrinsics.checkNotNullParameter(r4, "new");
            String r5 = r4.a;
            if (r5 != null) goto L6;
            r5 = "";
        L6:
            if (r5.length() != 0) goto L8;
            boolean r0 = true;
        L9:
            if (r0 == false) goto L11;
            FLogger.a.i("OrionIntercomComponent", "ignore conversation change for pending TouchSpeak: empty conversationId");
            return;
        L11:
            ObricIntercomComponent r1 = this.a;
            t2 r2 = new t2(r1, r5);
            int r6 = ObricIntercomComponent.h1;
            r1.getClass();
            ObricIntercomComponent.q4(r2);
            return;
        L8:
            r0 = false;
            goto L9
        }
    }

    public static final class g implements hca.e {
        public final /* synthetic */ ObricIntercomComponent a;

        public g(ObricIntercomComponent r1) {
            this.a = r1;
        }

        public final void onSelectModeChanged(boolean r10) {
            if (r10 == false) goto L54;
            ObricIntercomComponent r11 = this.a;
            int r0 = ObricIntercomComponent.h1;
            maa.e r12 = r11.G3();
            boolean r1 = true;
            int r2 = 0;
            if (r12 != null) goto L6;
        L8:
            boolean r13 = false;
        L10:
            if (r13 == false) goto L14;
            maa.e r14 = this.a.G3();
            if (r14 == null) goto L14;
            maa.e.a.a(r14, null, null, false, 7);
        L14:
            com.obric.audio.continuous_talk.b r15 = this.a.H3();
            if (r15 != null) goto L17;
        L19:
            r1 = false;
        L20:
            if (r1 == false) goto L25;
            com.obric.audio.continuous_talk.c r3 = (com.obric.audio.continuous_talk.c) this.a.r.getValue();
            if (r3 == null) goto L25;
            com.obric.audio.continuous_talk.c.a.a(r3, ObricContinuousTalkEndType.MANUAL, null, false, false, 14);
        L25:
            if (AudioServiceDelegate.a.L().d() == false) goto L27;
        L28:
            this.a.qm();
        L29:
            View r16 = this.a.Q3();
            if (r16 == null) goto L32;
            e1.o(r16);
        L32:
            FrameLayout r17 = (FrameLayout) this.a.D.getValue();
            if (r17 == null) goto L63;
            ObricIntercomComponent r4 = this.a;
            int r5 = r17.getChildCount();
        L35:
            if (r2 >= r5) goto L65;
            NovaTitleBarEx r6 = r17.getChildAt(r2);
            if ((r6 instanceof NovaTitleBarEx) == false) goto L53;
            ViewGroup.LayoutParams r7 = r6.getLayoutParams();
            if (r7 == null) goto L41;
            Integer r8 = Integer.valueOf(r7.height);
        L42:
            FrameLayout r9 = (FrameLayout) r4.D.getValue();
            if (r9 == null) goto L45;
            Integer r18 = Integer.valueOf(r9.getHeight());
        L47:
            if (Intrinsics.areEqual(r8, r18) == false) goto L53;
            ViewGroup.LayoutParams r19 = r6.getLayoutParams();
            if (r19 == null) goto L52;
            r19.height = -1;
            r6.setLayoutParams(r19);
            goto L53
        L52:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        L45:
            r18 = null;
            goto L47
        L41:
            r8 = null;
        L53:
            r2 = r2 + 1;
            goto L35
        L65:
            return;
        L63:
            return;
        L27:
            if (this.a.M == null) goto L29;
        L17:
            if (r15.m0() != true) goto L19;
        L6:
            if (r12.x3() != true) goto L8;
            r13 = true;
            goto L10
        L54:
            ObricIntercomComponent r110 = this.a;
            int r20 = ObricIntercomComponent.h1;
            View r111 = r110.Q3();
            if (r111 == null) goto L64;
            e1.x(r111);
            return;
        }
    }

    public static final class h implements Function0<va8.m> {
        public final /* synthetic */ AttachReceiver a;

        public h(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class i implements Function0<com.larus.bmhome.instruction.g> {
        public final /* synthetic */ AttachReceiver a;

        public i(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class j implements Function0<g1> {
        public final /* synthetic */ AttachReceiver a;

        public j(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(g1.class));
        }
    }

    public static final class k implements Function0<maa.h> {
        public final /* synthetic */ AttachReceiver a;

        public k(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.h.class));
        }
    }

    public static final class l implements Function0<com.larus.bmhome.chat.component.collection.o> {
        public final /* synthetic */ AttachReceiver a;

        public l(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.collection.o.class));
        }
    }

    public static final class m implements Function0<laa.j> {
        public final /* synthetic */ AttachReceiver a;

        public m(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.j.class));
        }
    }

    public static final class n implements Function0<IChatMessageShareAbility> {
        public final /* synthetic */ AttachReceiver a;

        public n(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(IChatMessageShareAbility.class));
        }
    }

    public static final class o implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public o(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.l.class));
        }
    }

    public static final class p implements Function0<a> {
        public final /* synthetic */ AttachReceiver a;

        public p(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(a.class));
        }
    }

    public static final class q implements Function0<com.larus.bmhome.chat.component.cvs.y> {
        public final /* synthetic */ AttachReceiver a;

        public q(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        }
    }

    public static final class r implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public r(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class s implements Function0<va8.o> {
        public final /* synthetic */ AttachReceiver a;

        public s(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(va8.o.class));
        }
    }

    public static final class t implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.l> {
        public final /* synthetic */ AttachReceiver a;

        public t(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.l.class));
        }
    }

    public static final class u implements Function0<com.larus.bmhome.chat.component.bottom.core.speaker.m> {
        public final /* synthetic */ AttachReceiver a;

        public u(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.core.speaker.m.class));
        }
    }

    public static final class v implements Function0<maa.e> {
        public final /* synthetic */ AttachReceiver a;

        public v(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    public static final class w implements Function0<com.obric.audio.continuous_talk.c> {
        public final /* synthetic */ AttachReceiver a;

        public w(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.c.class));
        }
    }

    public static final class x implements Function0<com.obric.audio.continuous_talk.b> {
        public final /* synthetic */ AttachReceiver a;

        public x(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.b.class));
        }
    }

    public static final class y implements Function0<laa.d> {
        public final /* synthetic */ AttachReceiver a;

        public y(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    public static final class z implements Function0<com.larus.bmhome.chat.component.bottom.p1> {
        public final /* synthetic */ AttachReceiver a;

        public z(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.p1.class));
        }
    }

    static {
    }

    public final void h1(boolean r1) {
    }

    @Override // wga.b
    public final void onScreenRotationChanged(int r1, int r2) {
    }

    @Override // wga.b
    public final void onWindowDismissed() {
    }

    @Override // wga.b
    public final void onWindowPreDismissed() {
    }

    @Override // wga.b
    public final void onWindowPreOpenClear() {
    }

    @Override // wga.b
    public final void onWindowPreStashed() {
    }

    public static boolean h4() {
        ObricInteractDelegate r0 = ObricInteractDelegate.b;
        Boolean r1 = r0.isAiKeyPressing();
        Boolean r2 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r0.isAiKeyLongPress(), r2) == true) goto L8;
        return false;
    }

    public static boolean k4() {
        if (Intrinsics.areEqual(ObricInteractDelegate.b.isAiKeyLongPress(), Boolean.TRUE) == true) goto L5;
        return false;
    L5:
        IObricVoiceService.a.getClass();
        IObricVoiceService r0 = IObricVoiceService.a.a();
        if (r0 != null) goto L9;
        return false;
    L9:
        return !r0.isAiKeyPressing();
    }

    public final void B2() {
        FLogger.a.i("OrionIntercomComponent", "onParentViewCreated");
        if (W3().getParent() != null) goto L20;
        View r0 = Q3();
        if (r0 == null) goto L20;
        ViewGroup r4 = (ViewGroup) this.B.getValue();
        if (r4 == null) goto L20;
        if ((r4 instanceof ConstraintLayout) == false) goto L14;
        ConstraintLayout.LayoutParams r5 = new ConstraintLayout.LayoutParams(0, v19.i5.h0());
        r5.startToStart = r0.getId();
        r5.endToEnd = r0.getId();
        r5.bottomToBottom = r0.getId();
        r5.setMarginStart(v19.i5.h());
        r5.setMarginEnd(v19.i5.h());
        ((ViewGroup.MarginLayoutParams) r5).bottomMargin = v19.i5.h();
    L18:
        r4.addView(W3(), r5);
        goto L20
    L14:
        if ((r4 instanceof FrameLayout) == false) goto L16;
        ConstraintLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, v19.i5.h0());
        ((FrameLayout.LayoutParams) r1).gravity = 80;
        r1.setMarginStart(v19.i5.h());
        r1.setMarginEnd(v19.i5.h());
        ((FrameLayout.LayoutParams) r1).bottomMargin = v19.i5.h();
    L17:
        r5 = r1;
        goto L18
    L16:
        r1 = new FrameLayout.LayoutParams(-1, v19.i5.h0());
        ((FrameLayout.LayoutParams) r1).gravity = 80;
        r1.setMarginStart(v19.i5.h());
        r1.setMarginEnd(v19.i5.h());
        ((FrameLayout.LayoutParams) r1).bottomMargin = v19.i5.h();
    L20:
        if (X3().getParent() != null) goto L43;
        ViewGroup r2 = (ViewGroup) this.B.getValue();
        if (r2 != null) goto L26;
        r2 = null;
    L35:
        if (r2 == null) goto L43;
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        if ((r2 instanceof ConstraintLayout) == false) goto L40;
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(-1, -2);
        r3.startToStart = 0;
        r3.endToEnd = 0;
        r3.bottomToBottom = 0;
    L41:
        r2.addView(X3(), r3);
        goto L43
    L40:
        ConstraintLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -2);
        ((FrameLayout.LayoutParams) r6).gravity = 80;
        r3 = r6;
        goto L41
    L26:
        if (Z3() != null) goto L35;
        View r7 = r2.getRootView();
        if ((r7 instanceof ViewGroup) == false) goto L31;
        ViewGroup r8 = (ViewGroup) r7;
    L32:
        if (r8 == null) goto L35;
        r2 = r8;
        goto L35
    L31:
        r8 = null;
    L43:
        if (IWindowContextKt.isWindowContext(getContext()) == false) goto L48;
        com.obric.assistant.view.listening.f r9 = V3();
        r9.getClass();
        IObricVoiceService.a.getClass();
        IObricVoiceService r10 = IObricVoiceService.a.a();
        if (r10 == null) goto L48;
        r10.h(r9.k);
        r9.d = true;
    L48:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r11 = a4();
        if (r11 == null) goto L52;
        r11.A4(this.Q);
    L52:
        if (this.N == true) goto L59;
        com.larus.bmhome.chat.component.cvs.y r12 = (com.larus.bmhome.chat.component.cvs.y) this.I.getValue();
        if (r12 == null) goto L59;
        com.larus.bmhome.chat.component.cvs.y.b.b(r12, this.P);
        this.N = true;
    L59:
        if (IWindowContextKt.isWindowContext(getContext()) == false) goto L63;
        IAssistantChatWindow r13 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r13 == null) goto L64;
        r13.addWindowLifecycleListener(this);
    L64:
        laa.d r14 = Z3();
        if (r14 == null) goto L67;
        r14.HU(this);
    L67:
        laa.j r15 = (laa.j) this.E.getValue();
        if (r15 == null) goto L70;
        r15.e00((b0) this.R.getValue());
    L70:
        IChatMessageShareAbility r16 = (IChatMessageShareAbility) this.F.getValue();
        if (r16 == null) goto L74;
        r16.kN(this.g1);
        return;
    L74:
        return;
    L63:
        B20(false, null, null);
        goto L64
    }

    public final void F4() {
        com.larus.bmhome.instruction.g r0 = (com.larus.bmhome.instruction.g) this.w.getValue();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.z0();
    L6:
        g1 r3 = (g1) this.x.getValue();
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        laa.d r5 = Z3();
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        LongPressMockView r7 = W3();
        if (r2 == true) goto L21;
        if (r4 == true) goto L21;
    L22:
        r7.c(r6, r1);
        return;
    L21:
        r1 = true;
        goto L22
    L15:
        if (r5.aF() != true) goto L17;
        r6 = true;
        goto L18
    L9:
        if (r3.isVisible() != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    public final maa.e G3() {
        return (maa.e) this.q.getValue();
    }

    public final com.obric.audio.continuous_talk.b H3() {
        return (com.obric.audio.continuous_talk.b) this.s.getValue();
    }

    public final boolean H90() {
        if (this.M == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void Kj() {
        if (this.X == true) goto L5;
        return;
    L5:
        Pair<Float, Float> r0 = this.V;
        if (r0 != null) goto L9;
        X3().d();
        return;
    L9:
        com.larus.bmhome.chat.component.bottom.core.speaker.m r1 = c4();
        if (r1 == null) goto L14;
        ChatSpeaker r2 = r1.lM();
        if (r2 == null) goto L14;
        ChatSpeaker.C6(r2, r0);
        return;
    L14:
        X3().d();
    }

    public final View Q3() {
        return (View) this.C.getValue();
    }

    public final com.obric.assistant.view.listening.f V3() {
        return (com.obric.assistant.view.listening.f) this.k0.getValue();
    }

    public final LongPressMockView W3() {
        return (LongPressMockView) this.L0.getValue();
    }

    public final OverlayerAudioView X3() {
        return (OverlayerAudioView) this.b1.getValue();
    }

    public final laa.d Z3() {
        return (laa.d) this.t.getValue();
    }

    public final iga.a Zs() {
        if (this.X == false) goto L6;
        return X3().getAudioVisualizerView();
    L6:
        return (AudioContinueGradientView) this.P0.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.core.speaker.l a4() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.o.getValue();
    }

    public final com.larus.bmhome.chat.component.bottom.core.speaker.m c4() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.m) this.p.getValue();
    }

    public final FrameLayout d4() {
        return (FrameLayout) this.V0.getValue();
    }

    public final void hU() {
        q4(new u1(this));
    }

    public final void j() {
        IChatMessageShareAbility r0 = (IChatMessageShareAbility) this.F.getValue();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.H1() != true) goto L7;
    L8:
        if (r1 == false) goto L13;
        IChatMessageShareAbility r2 = (IChatMessageShareAbility) this.F.getValue();
        if (r2 == null) goto L14;
        r2.j();
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final boolean j4() {
        laa.j r0 = (laa.j) this.E.getValue();
        if (r0 == null) goto L9;
        b1 r1 = r0.O4();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() == true) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L41;
        g1 r3 = (g1) this.x.getValue();
        if (r3 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L42;
        a r5 = (a) this.H.getValue();
        if (r5 != null) goto L21;
    L23:
        boolean r6 = false;
    L24:
        if (r6 == false) goto L43;
        com.larus.bmhome.instruction.g r7 = (com.larus.bmhome.instruction.g) this.w.getValue();
        if (r7 != null) goto L28;
    L30:
        boolean r8 = false;
    L31:
        if (r8 == false) goto L44;
        ICoreInputAbility r9 = (ICoreInputAbility) this.m.getValue();
        if (r9 != null) goto L35;
    L37:
        boolean r10 = false;
    L38:
        if (r10 == true) goto L45;
        return true;
    L45:
        return false;
    L35:
        if (r9.c2() != true) goto L37;
        r10 = true;
        goto L38
    L44:
        return false;
    L28:
        if (r7.z0() == true) goto L30;
        r8 = true;
        goto L31
    L43:
        return false;
    L21:
        if (r5.Qj() == true) goto L23;
        r6 = true;
        goto L24
    L42:
        return false;
    L14:
        if (r3.isVisible() == true) goto L16;
        r4 = true;
        goto L17
    L41:
        return false;
    L9:
        r2 = false;
        goto L10
    }

    public final boolean kT() {
        if (this.X == false) goto L6;
        return ((Boolean) this.U.getValue()).booleanValue();
    L6:
        if (W3().getParent() != null) goto L8;
    L13:
        return false;
    L8:
        if (W3().getVisibility() != 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        return true;
    L10:
        r0 = false;
        goto L11
    }

    public final void onDestroy() {
        this.H0.clear();
        this.p0 = null;
        this.W = true;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r2 = a4();
        if (r2 == null) goto L5;
        r2.K8(this.Q);
    L5:
        LinkedHashSet r3 = new LinkedHashSet();
        c r4 = this.L;
        if (r4 == null) goto L10;
        laa.n r5 = r4.b;
        if (r5 == null) goto L10;
        r3.add(r5);
    L10:
        r3.addAll(this.O.values());
        b r6 = this.M;
        if (r6 == null) goto L15;
        laa.n r7 = r6.d;
        if (r7 == null) goto L15;
        r3.add(r7);
    L15:
        Iterator r8 = r3.iterator();
    L17:
        if (r8.hasNext() == false) goto L19;
        laa.n r9 = (laa.n) r8.next();
        V3().c(r9, "component_destroy");
        goto L17
    L19:
        com.obric.assistant.view.listening.f r10 = V3();
        r10.getClass();
        Intrinsics.checkNotNullParameter("component_destroy", "reason");
        com.obric.assistant.view.listening.b r11 = r10.e;
        if (r11 == null) goto L22;
        r10.c(r11, "component_destroy");
    L22:
        this.L = null;
        m3("onDestroy");
        this.O.clear();
        if (this.N == false) goto L29;
        com.larus.bmhome.chat.component.cvs.y r12 = (com.larus.bmhome.chat.component.cvs.y) this.I.getValue();
        if (r12 == null) goto L28;
        r12.lQ(this.P);
    L28:
        this.N = false;
    L29:
        com.obric.assistant.view.listening.f r13 = V3();
        Job r14 = r13.h;
        if (r14 == null) goto L32;
        Job.DefaultImpls.cancel$default(r14, null, 1, null);
    L32:
        r13.h = null;
        Iterator r1 = CollectionsKt.toList(r13.i).iterator();
    L34:
        if (r1.hasNext() == false) goto L37;
        com.obric.assistant.view.listening.b r15 = (com.obric.assistant.view.listening.b) r1.next();
        Intrinsics.checkNotNull(r15);
        r13.c(r15, "controller_detach");
        goto L34
    L37:
        if (r13.d == false) goto L42;
        IObricVoiceService.a.getClass();
        IObricVoiceService r16 = IObricVoiceService.a.a();
        if (r16 == null) goto L41;
        r16.g(r13.k);
    L41:
        r13.d = false;
    L42:
        r13.j = false;
        r13.g = null;
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L45;
        r0.removeWindowLifecycleListener(this);
    L45:
        laa.d r17 = Z3();
        if (r17 == null) goto L48;
        r17.AN(this);
    L48:
        laa.j r18 = (laa.j) this.E.getValue();
        if (r18 == null) goto L51;
        r18.RC((b0) this.R.getValue());
    L51:
        IChatMessageShareAbility r19 = (IChatMessageShareAbility) this.F.getValue();
        if (r19 == null) goto L54;
        r19.cG(this.g1);
    L54:
        ObricInteractDelegate.b.setAlreadyShowAuthResult(false);
    }

    public final void onResume() {
        FLogger r0 = FLogger.a;
        r0.i("OrionIntercomComponent", "onResume");
        this.K = false;
        StringBuilder r3 = new StringBuilder("onResume, isLongPressStart: ");
        ObricInteractDelegate r4 = ObricInteractDelegate.b;
        r3.append(r4.isAiKeyLongPress());
        r3.append(", isShortPressStart: ");
        r3.append(r4.isAiKeyShortPress());
        r3.append(",isAiKeyPressing: ");
        r3.append(r4.isAiKeyPressing());
        r3.append(", pageState is ");
        laa.d r5 = Z3();
        if (r5 == null) goto L5;
        ObricFloatChatPageState r6 = r5.getPageState();
    L6:
        r3.append(r6);
        r0.i("OrionIntercomComponent", r3.toString());
        Boolean r7 = r4.isAiKeyLongPress();
        Boolean r8 = Boolean.TRUE;
        if (Intrinsics.areEqual(r7, r8) == true) goto L23;
        if (Intrinsics.areEqual(r4.isAiKeyShortPress(), r8) == true) goto L23;
        if (Intrinsics.areEqual(r4.isAiKeyPressing(), r8) == true) goto L23;
        laa.d r9 = Z3();
        if (r9 == null) goto L17;
        boolean r10 = true;
        if (r9.isVisible() != true) goto L17;
    L18:
        if (r10 == false) goto L23;
        if (kT() == false) goto L23;
        qm();
        hU();
        tH(null);
    L17:
        r10 = false;
    L23:
        if (Intrinsics.areEqual(r4.isAiKeyShortPress(), r8) == false) goto L38;
        maa.e r11 = G3();
        if (r11 != null) goto L27;
        r0.i("OrionIntercomComponent", "onResume: defer AI key short press until ClickTalk ability is ready");
    L28:
        if (r11 != null) goto L30;
        return;
    L30:
        if (r11.x3() == true) goto L40;
        laa.d r1 = Z3();
        if (r1 == null) goto L34;
        r1.Hd(false);
    L34:
        maa.e r2 = G3();
        if (r2 == null) goto L41;
        maa.e.a.b(r2, 5, null, 6);
        return;
    L41:
        return;
    L40:
        return;
    L27:
        r4.notifyAiKeyEvent(0);
        r4.resetIsAiKeyLongPress();
        goto L28
    L38:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onStart() {
        FLogger.a.i("OrionIntercomComponent", "onStart");
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        this.X = r1;
        return;
    L5:
        if (r0.isWindowMode() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onStop() {
        uga.b r0 = this.p0;
        if (r0 == null) goto L5;
        E3("cancelled", "touch_speak_stopped_before_pcm", r0);
    L5:
        this.H0.clear();
        FLogger.a.i("OrionIntercomComponent", "onStop");
        this.K = true;
        if (kT() == false) goto L8;
    L9:
        qm();
        hU();
        tH(null);
    L10:
        ObricInteractDelegate r1 = ObricInteractDelegate.b;
        r1.notifyAiKeyEvent(0);
        r1.resetIsAiKeyLongPress();
        return;
    L8:
        if (this.M == null) goto L10;
        goto L9
    }

    @Override // wga.b
    public final void onWindowStashed() {
        FLogger.a.i("OrionIntercomComponent", "onWindowStashed");
    }

    public final void p90() {
        q4(new i2(this));
    }

    public final boolean xA() {
        com.larus.bmhome.chat.component.collection.o r0 = (com.larus.bmhome.chat.component.collection.o) this.z.getValue();
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.i0() != true) goto L8;
        r1 = true;
    L8:
        return !r1;
    }

    public ObricIntercomComponent() {
        this.m = LazyKt.lazy(new r(this));
        this.n = LazyKt.lazy(new s(this));
        this.o = LazyKt.lazy(new t(this));
        this.p = LazyKt.lazy(new u(this));
        this.q = LazyKt.lazy(new v(this));
        this.r = LazyKt.lazy(new w(this));
        this.s = LazyKt.lazy(new x(this));
        this.t = LazyKt.lazy(new y(this));
        this.u = LazyKt.lazy(new z(this));
        this.v = LazyKt.lazy(new h(this));
        this.w = LazyKt.lazy(new i(this));
        this.x = LazyKt.lazy(new j(this));
        this.y = LazyKt.lazy(new k(this));
        this.z = LazyKt.lazy(new l(this));
        this.A = LazyKt.lazy(new o2(this));
        this.B = LazyKt.lazy(new q2(this));
        this.C = LazyKt.lazy(new r2(this));
        this.D = LazyKt.lazy(new s2(this));
        this.E = LazyKt.lazy(new m(this));
        this.F = LazyKt.lazy(new n(this));
        this.G = LazyKt.lazy(new o(this));
        this.H = LazyKt.lazy(new p(this));
        this.I = LazyKt.lazy(new q(this));
        this.J = LazyKt.lazy(new a0(this));
        this.O = new ConcurrentHashMap();
        this.P = new e(this);
        this.Q = new c0(this);
        this.R = LazyKt.lazy(new k1(this));
        this.T = new l1(this);
        this.U = j1.a(Boolean.FALSE);
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isWindowMode() != true) goto L7;
    L8:
        this.X = r1;
        this.k0 = LazyKt.lazy(new m1(this));
        this.H0 = new ConcurrentHashMap();
        this.L0 = LazyKt.lazy(new n1(this));
        this.P0 = LazyKt.lazy(new o1(this));
        this.V0 = LazyKt.lazy(new p1(this));
        this.b1 = LazyKt.lazy(new p2(this));
        this.g1 = new g(this);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public static void z3() {
        if (k4() == true) goto L5;
        return;
    L5:
        ObricInteractDelegate r0 = ObricInteractDelegate.b;
        r0.notifyAiKeyEvent(0);
        r0.resetIsAiKeyLongPress();
    }

    public final List<View> C3() {
        View r0 = Q3();
        if (r0 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if ((r0 instanceof ViewGroup) == false) goto L9;
        ViewGroup r1 = (ViewGroup) r0;
    L10:
        View r2 = f2.a(r1);
        if (r2 == null) goto L16;
        if (r2 == r0) goto L16;
        return CollectionsKt.listOf(new View[]{r0, r2});
    L16:
        return CollectionsKt.listOf(r0);
    L9:
        r1 = null;
        goto L10
    }

    public final com.obric.assistant.view.listening.b Nf() {
        return V3().b();
    }

    public final void e4() {
        X3().f(ObricListeningViewState.d);
        X3().animate().cancel();
        X3().setAlpha(0.0f);
        X3().setVisibility(8);
        this.U.setValue(Boolean.FALSE);
    }

    public final void onCreate() {
        super/*com.larus.ui.arch.component.external.delegate.BaseComponentWidget*/.onCreate();
        this.W = false;
    }

    public final void p3() {
        com.larus.bmhome.chat.component.bottom.core.speaker.m r0 = c4();
        ViewGroup.MarginLayoutParams r1 = null;
        if (r0 == null) goto L7;
        ChatSpeaker r2 = r0.lM();
        if (r2 == null) goto L7;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
    L9:
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L12:
        if (r4 != null) goto L14;
        return;
    L14:
        ViewGroup.LayoutParams r5 = d4().getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
    L18:
        if (r6 == null) goto L20;
        r6.bottomMargin = r4.bottomMargin;
    L20:
        ViewGroup.LayoutParams r7 = W3().getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        r1 = (ViewGroup.MarginLayoutParams) r7;
    L23:
        if (r1 == null) goto L26;
        r1.bottomMargin = r4.bottomMargin;
        return;
    L26:
        return;
    L17:
        r6 = null;
        goto L18
    L11:
        r4 = null;
    L7:
        r3 = null;
        goto L9
    }

    public final void qm() {
        b r0 = m3("stopTouchSpeak");
        boolean r1 = false;
        if (r0 == null) goto L5;
        tH(r0.d);
        ObricInteractDelegate r2 = ObricInteractDelegate.b;
        r2.notifyAiKeyEvent(0);
        r2.resetIsAiKeyLongPress();
    L5:
        c r3 = this.L;
        if (r3 != null) goto L12;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("stopTouchSpeak: no active task, pendingCanceled=");
        if (r0 == null) goto L10;
        r1 = true;
    L10:
        r5.append(r1);
        r4.i("OrionIntercomComponent", r5.toString());
        E3("cancelled", "long_press_stopped_before_ready", this.p0);
        return;
    L12:
        q4(new j1(this, r3));
    }

    public final void v4() {
        AudioContinueGradientView r0 = X3().getAudioVisualizerView();
        r0.setMode(0);
        r0.setTimeOutCallback(null);
        r0.setRecognizing(false);
        r0.a();
        OverlayerAudioView r1 = X3();
        r1.i = true;
        r1.i(false, false);
    }

    public final StateFlowImpl AD() {
        return this.U;
    }

    public static boolean i4(Integer r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.intValue() == 0) goto L16;
        IDoraWakeupService r3 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L17;
        return true;
    L17:
        return false;
    L9:
        if (r3.o() != true) goto L11;
        r4 = true;
        goto L12
    L16:
        return false;
    }

    public static void q4(Runnable r2) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        r2.run();
        return;
    L5:
        com.larus.utils.y.c(r2);
    }

    public final void B4(boolean r5) {
        if (this.X == true) goto L5;
        return;
    L5:
        ChatSpeaker r1 = null;
        if (r5 == false) goto L25;
        List<View> r6 = C3();
        com.larus.bmhome.chat.component.bottom.core.speaker.m r2 = c4();
        if (r2 == null) goto L11;
        r1 = r2.lM();
    L11:
        if (r6.isEmpty() == false) goto L14;
        if (r1 != null) goto L14;
        return;
    L14:
        this.Y = true;
        Iterator<T> r7 = r6.iterator();
    L16:
        if (r7.hasNext() == false) goto L18;
        View r0 = (View) r7.next();
        r0.animate().cancel();
        r0.setAlpha(0.0f);
        goto L16
    L18:
        if (r1 != null) goto L20;
        return;
    L20:
        if (this.Z != null) goto L22;
        this.Z = Float.valueOf(r1.getAlpha());
    L22:
        r1.animate().cancel();
        r1.setAlpha(0.0f);
        return;
    L25:
        if (this.Y == true) goto L27;
        return;
    L27:
        this.Y = false;
        Iterator<T> r3 = C3().iterator();
    L29:
        if (r3.hasNext() == false) goto L31;
        h3((View) r3.next(), true, false, null);
        goto L29
    L31:
        Float r8 = this.Z;
        if (r8 == null) goto L38;
        float r9 = r8.floatValue();
        com.larus.bmhome.chat.component.bottom.core.speaker.m r4 = c4();
        if (r4 == null) goto L38;
        ChatSpeaker r10 = r4.lM();
        if (r10 == null) goto L38;
        r10.animate().cancel();
        r10.setAlpha(r9);
    L38:
        this.Z = null;
    }

    public final void B6(String r4) {
        this.H0.clear();
        uga.b r0 = null;
        if (r4 != null) goto L5;
    L10:
        this.p0 = r0;
        return;
    L5:
        if (Intrinsics.areEqual(AssistantStartupTelemetry.a.i("asr_record_ready"), r4) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L10;
        r0 = new uga.b(r4);
        goto L10
    }

    public final void D3(String r5) {
        Intrinsics.checkNotNullParameter(r5, DBDefinition.TASK_ID);
        c r0 = this.L;
        boolean r1 = false;
        if (r0 == null) goto L19;
        if (r5 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 != true) goto L19;
        r1 = true;
        goto L19
    L13:
        if (r0.g.contains(r5) == false) goto L15;
        r4 = true;
        goto L16
    L7:
        if (r5.length() == 0) goto L10;
        r3 = false;
    L19:
        if (r1 == false) goto L22;
        l4(r0);
        V3().c(r0.b, "touch_task_terminal");
        return;
    L22:
        laa.n r6 = this.O.remove(r5);
        if (r6 != null) goto L25;
        return;
    L25:
        V3().c(r6, "touch_task_terminal");
    }

    public final Boolean I4(Pair<Float, Float> r3) {
        Intrinsics.checkNotNullParameter(r3, "xy");
        if (this.X == true) goto L6;
        return null;
    L6:
        this.V = r3;
        OverlayerAudioView r1 = X3();
        Pair<Float, Float> r4 = Y2(r3);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "xy");
        r1.l = r4;
        return Boolean.valueOf(r1.e(r4));
    }

    public final void LE(boolean r3) {
        Fj(r3, false, null, null);
    }

    public final void LL(Bundle r4) {
        FLogger.a.i("OrionIntercomComponent", "startSpeakLoading");
        if (r4 == null) goto L12;
        String r0 = r4.getString("obric_startup_attempt_id");
        if (r0 == null) goto L12;
        if ((!StringsKt.isBlank(r0)) == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L12;
        B6(r0);
    L12:
        q4(new z1(this, r4));
    }

    public final void T3(Function1<? super Boolean, Unit> r2) {
        this.S = r2;
        if (r2 == null) goto L6;
        i6 r3 = (i6) r2;
        r3.invoke(Boolean.valueOf(kT()));
        return;
    }

    public final void UU(laa.n r3) {
        Intrinsics.checkNotNullParameter(r3, "handle");
        V3().c(r3, "business_handle_terminal");
    }

    public final Pair<Float, Float> Y2(Pair<Float, Float> r6) {
        View r0 = Q3();
        ConstraintLayout r1 = null;
        if (r0 == null) goto L5;
        Float r2 = Float.valueOf(r0.getAlpha());
    L7:
        if (Intrinsics.areEqual(r2, 0.0f) == false) goto L19;
        va8.o r3 = (va8.o) this.n.getValue();
        if (r3 == null) goto L13;
        com.larus.bmhome.chat.component.bottom.core.a r4 = r3.Uv();
        if (r4 == null) goto L13;
        r1 = r4.h();
    L13:
        ConstraintLayout r5 = f2.a(r1);
        if (r5 == null) goto L16;
        int r7 = r5.getPaddingStart();
    L17:
        int r8 = m0.a;
        return TuplesKt.to(Float.valueOf(RangesKt.coerceAtLeast((((Number) r6.getFirst()).floatValue() - (m0.b(getContext()) / 2.0f)) + r7, 0.0f)), r6.getSecond());
    L16:
        r7 = 0;
        goto L17
    L19:
        return r6;
    L5:
        r2 = null;
        goto L7
    }

    public final void ga(Pair<Float, Float> r2) {
        if (this.X == true) goto L5;
        return;
    L5:
        this.V = r2;
        OverlayerAudioView r0 = X3();
        if (r2 == null) goto L8;
        Pair<Float, Float> r3 = Y2(r2);
    L9:
        r0.l = r3;
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final void l4(c r5) {
        if (this.L != r5) goto L5;
        this.L = null;
        z3();
    L5:
        Iterator r0 = CollectionsKt.toSet(r5.g).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        String r1 = (String) r0.next();
        this.O.remove(r1, r5.b);
        this.H0.remove(r1);
        goto L7
    }

    public final b m3(String r5) {
        b r0 = this.M;
        if (r0 != null) goto L5;
        return null;
    L5:
        this.M = null;
        FLogger.a.i("OrionIntercomComponent", "cancel pending TouchSpeak, reason=" + r5 + ", vuiId=" + r0.b);
        return r0;
    }

    @Override // wga.b
    public final void onWindowOpened(WindowOpenSource r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        FLogger.a.i("OrionIntercomComponent", "onWindowOpened: lifecycle.currentState = " + ((BaseComponentFeatureInternal) this).a.getCurrentState() + ", isDestroyed = " + this.W + ", source = " + r4);
        if (this.W == false) goto L5;
        return;
    L5:
        if (IWindowContextKt.isWindowContext(getContext()) == false) goto L10;
        com.obric.assistant.view.listening.f r5 = V3();
        r5.getClass();
        IObricVoiceService.a.getClass();
        IObricVoiceService r0 = IObricVoiceService.a.a();
        if (r0 == null) goto L10;
        r0.h(r5.k);
        r5.d = true;
    L10:
        B20(false, null, null);
    }

    @Override // wga.b
    public final void onWindowPreOpened(WindowOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }

    public final void r2(boolean r6) {
        maa.e r0 = G3();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.gn();
    L6:
        FLogger.a.i("OrionIntercomComponent", "onChatStyleChanged isChatWindow: " + r6 + ", isClickTalking: " + r2);
        if (r6 == true) goto L21;
        ObricInteractDelegate r7 = ObricInteractDelegate.b;
        Boolean r3 = r7.isAiKeyPressing();
        Boolean r4 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r4) == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r7.isAiKeyLongPress(), r4) == true) goto L23;
        if (r2 == true) goto L24;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r8 = a4();
        if (r8 != null) goto L16;
    L18:
        if (r1 == true) goto L25;
        hU();
        return;
    L25:
        return;
    L16:
        if (r8.m0() != true) goto L18;
        r1 = true;
        goto L18
    L24:
        return;
    L23:
        return;
    L21:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final void tH(laa.n r4) {
        FLogger.a.i("OrionIntercomComponent", "stopSpeakLoading");
        q4(new f2(this, r4));
    }

    public final void x1(ObricFloatChatPageState r2) {
        Intrinsics.checkNotNullParameter(r2, "pageState");
    }

    public final void B3(c r12, String r13) {
        if (this.L == r12) goto L5;
        return;
    L5:
        if (r12.f == false) goto L8;
        return;
    L8:
        if (r12.e != TouchTerminalIntent.NONE) goto L10;
        return;
    L10:
        boolean r1 = false;
        if (r12.c == false) goto L13;
    L23:
        r12.f = true;
        E3("cancelled", "long_press_stopped_before_ready", this.p0);
        z3();
        hU();
        Rect r0 = new Rect();
        View r5 = Q3();
        if (r5 == null) goto L26;
        r5.getGlobalVisibleRect(r0);
    L26:
        com.larus.bmhome.chat.component.bottom.core.speaker.m r6 = c4();
        if (r6 == null) goto L33;
        ChatSpeaker r7 = r6.lM();
        if (r7 == null) goto L33;
        if (r7.getVisible() == true) goto L33;
        r1 = true;
    L33:
        if (r1 == false) goto L38;
        FLogger.a.i("OrionIntercomComponent", "cancel TouchSpeak without visible speaker: taskId=" + r12.a + ", source=" + r13);
        com.larus.bmhome.chat.component.bottom.core.speaker.l r14 = a4();
        if (r14 == null) goto L46;
        r14.A9();
        return;
    L46:
        return;
    L38:
        if (r5 == null) goto L42;
        FLogger.a.i("OrionIntercomComponent", "submit TouchSpeak terminal: taskId=" + r12.a + ", source=" + r13);
        com.larus.bmhome.chat.component.bottom.core.speaker.l r8 = a4();
        if (r8 == null) goto L48;
        r8.pv(-1, r0.left + 1.0f, r0.bottom + 1.0f, 0.0f, 0.0f);
        return;
    L48:
        return;
    L42:
        FLogger.a.i("OrionIntercomComponent", "cancel TouchSpeak without anchor: taskId=" + r12.a + ", source=" + r13);
        com.larus.bmhome.chat.component.bottom.core.speaker.l r15 = a4();
        if (r15 == null) goto L50;
        r15.A9();
        return;
    L50:
        return;
    L13:
        if (r12.d == true) goto L23;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r2 = a4();
        if (r2 != null) goto L17;
    L19:
        boolean r3 = false;
    L20:
        if (r3 == true) goto L23;
        FLogger.a.i("OrionIntercomComponent", "wait TouchSpeak start before terminal: taskId=" + r12.a + ", source=" + r13);
        return;
    L17:
        if (r2.m0() != true) goto L19;
        r3 = true;
        goto L20
    }

    public final void L(int r3, int r4) {
        OverlayerAudioView r0 = X3();
        r0.getClass();
        int r5 = RangesKt.coerceIn(r3, 0, RangesKt.coerceAtLeast(r4, 0));
        if (r0.s == r5) goto L7;
        r0.s = r5;
        r0.j();
        return;
    }

    public final void Ru(byte[] r7, laa.n r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        c r1 = this.L;
        boolean r3 = false;
        if (r1 == null) goto L14;
        String r2 = r1.a;
        if (r2 == null) goto L14;
        uga.b r4 = this.H0.get(r2);
        if (r4 == null) goto L14;
        if (r4 != this.p0) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
    L15:
        if (r4 != null) goto L17;
    L23:
        if (r3 == false) goto L25;
        r4.a(IAssistantStartupTelemetry.a.c(AssistantStartupTelemetry.a, r4.a, "asr_record_ready"));
    L25:
        if (r8 != null) goto L30;
        c r9 = this.L;
        if (r9 == null) goto L29;
        r8 = r9.b;
        goto L30
    L29:
        r8 = null;
    L30:
        com.obric.assistant.view.listening.f r6 = V3();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "data");
        r6.b.invoke(new com.obric.assistant.view.listening.c(r6, r8, r7));
        return;
    L17:
        if (r7.length != 0) goto L19;
        boolean r10 = true;
    L21:
        if (r4.b(!r10) != true) goto L23;
        r3 = true;
        goto L23
    L19:
        r10 = false;
        goto L21
    L11:
        r5 = false;
    L14:
        r4 = null;
        goto L15
    }

    public final boolean p4(boolean r7, boolean r8) {
        if (d4().getParent() != null) goto L19;
        View r0 = Q3();
        if (r0 != null) goto L7;
        return false;
    L7:
        ViewGroup r2 = (ViewGroup) this.B.getValue();
        if (r2 != null) goto L11;
        return false;
    L11:
        if ((r2 instanceof ConstraintLayout) == false) goto L14;
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(0, v19.i5.h0());
        r3.startToStart = r0.getId();
        r3.endToEnd = r0.getId();
        r3.bottomToBottom = r0.getId();
        r3.setMarginStart(v19.i5.h());
        r3.setMarginEnd(v19.i5.d());
        ((ViewGroup.MarginLayoutParams) r3).bottomMargin = v19.i5.h();
    L18:
        r2.addView(d4(), r3);
        d4().setPaddingRelative(v19.i5.u0(), 0, 0, 0);
        goto L19
    L14:
        if ((r2 instanceof FrameLayout) == false) goto L16;
        ConstraintLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, v19.i5.h0());
        ((FrameLayout.LayoutParams) r1).gravity = 80;
        r1.setMarginStart(v19.i5.h());
        r1.setMarginEnd(v19.i5.d());
        ((FrameLayout.LayoutParams) r1).bottomMargin = v19.i5.h();
    L17:
        r3 = r1;
        goto L18
    L16:
        r1 = new FrameLayout.LayoutParams(-1, v19.i5.h0());
        ((FrameLayout.LayoutParams) r1).gravity = 80;
        r1.setMarginStart(v19.i5.h());
        r1.setMarginEnd(v19.i5.d());
        ((FrameLayout.LayoutParams) r1).bottomMargin = v19.i5.h();
    L19:
        p3();
        if (this.X == false) goto L27;
        G4(this, r7, null, r8, 2);
        if (r7 == true) goto L42;
        Function1<? super Boolean, Unit> r9 = this.S;
        if (r9 == null) goto L26;
        r9.invoke(Boolean.FALSE);
    L26:
        this.T.invoke(Boolean.FALSE);
        return true;
    L42:
        return true;
    L27:
        if (r7 == false) goto L29;
        tH(null);
    L29:
        FrameLayout r10 = d4();
        if (r7 == false) goto L32;
        int r4 = 0;
    L33:
        r10.setVisibility(r4);
        ((AudioContinueGradientView) this.P0.getValue()).a();
        if (r7 == false) goto L36;
        ((AudioContinueGradientView) this.P0.getValue()).d(false);
        return true;
    L36:
        Function1<? super Boolean, Unit> r11 = this.S;
        if (r11 == null) goto L39;
        r11.invoke(Boolean.FALSE);
    L39:
        this.T.invoke(Boolean.FALSE);
        return true;
    L32:
        r4 = 8;
        goto L33
    }

    public final void sC(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, DBDefinition.TASK_ID);
        c r0 = this.L;
        if (r0 != null) goto L7;
        if (r4 == true) goto L9;
        D3(r3);
        return;
    L9:
        return;
    L7:
        q4(new e2(this, r0, r3, r4));
    }

    public final void us(float r4, laa.n r5) {
        com.obric.assistant.view.listening.f r0 = V3();
        r0.b.invoke(new com.obric.assistant.view.listening.d(r0, r4, r5));
    }

    public final void B20(boolean r20, Integer r21, Long r22) {
        ObricInteractDelegate r1 = ObricInteractDelegate.b;
        Boolean r2 = r1.isAiKeyShortPress();
        Boolean r3 = r1.isAiKeyPressing();
        Boolean r4 = r1.isAiKeyLongPress();
        boolean r13 = i4(r21);
        boolean r5 = true;
        if (r13 == false) goto L5;
    L7:
        boolean r6 = false;
    L8:
        FLogger r8 = FLogger.a;
        StringBuilder r9 = new StringBuilder("startTouchSpeak pageState: ");
        laa.d r10 = Z3();
        z8.a r11 = null;
        if (r10 == null) goto L11;
        ObricFloatChatPageState r12 = r10.getPageState();
    L12:
        r9.append(r12);
        r9.append(", isAiKeyShortPress is ");
        r9.append(r2);
        r9.append(", isAiKeyLongPress is ");
        r9.append(r4);
        r9.append(", isAiKeyPressing is ");
        r9.append(r3);
        r9.append(", isDoraRadioSpeak is ");
        r9.append(r13);
        r9.append(", vuiId = ");
        r9.append(r21);
        r8.i("OrionIntercomComponent", r9.toString());
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r7) == false) goto L17;
        LL(null);
        return;
    L17:
        if (Intrinsics.areEqual(r4, r7) == true) goto L19;
        return;
    L19:
        c r14 = this.L;
        if (r14 != null) goto L22;
    L39:
        if (r6 == false) goto L42;
        V3().c(V3().b(), "touch_start_after_key_release");
        AudioServiceDelegate.a.L().a(false);
        z3();
        E3("cancelled", "long_press_stopped_before_ready", this.p0);
        return;
    L42:
        com.larus.bmhome.chat.component.cvs.y r15 = (com.larus.bmhome.chat.component.cvs.y) this.I.getValue();
        if (r15 == null) goto L56;
        wc9.e r16 = r15.h();
        if (r16 == null) goto L48;
        String r17 = r16.a;
    L49:
        if (r17 != null) goto L51;
    L54:
        boolean r18 = true;
    L55:
        if (r18 == false) goto L56;
        if (this.N == true) goto L64;
        com.larus.bmhome.chat.component.cvs.y r19 = (com.larus.bmhome.chat.component.cvs.y) this.I.getValue();
        if (r19 == null) goto L64;
        com.larus.bmhome.chat.component.cvs.y.b.b(r19, this.P);
        this.N = true;
    L64:
        b r23 = this.M;
        if (r23 == null) goto L67;
        r8.i("OrionIntercomComponent", "replace pending TouchSpeak, oldVuiId=" + r23.b);
    L67:
        this.M = new b(r20, r21, r22, V3().b());
        r8.i("OrionIntercomComponent", "defer TouchSpeak until conversation ready, released=" + r6 + ", vuiId=" + r21);
        boolean r24 = true;
    L68:
        if (r24 == false) goto L70;
        return;
    L70:
        laa.n r110 = V3().b();
        uga.b r25 = this.p0;
        if (r25 != null) goto L73;
    L75:
        r25 = null;
    L76:
        this.p0 = r25;
        j();
        q4(new d2(this, r110));
        AudioServiceDelegate r111 = AudioServiceDelegate.a;
        r111.L().a(true);
        va8.o r26 = (va8.o) this.n.getValue();
        if (r26 == null) goto L79;
        r26.requestDisallowInterceptTouchEvent(true);
    L79:
        com.larus.bmhome.chat.component.bottom.p1 r27 = (com.larus.bmhome.chat.component.bottom.p1) this.u.getValue();
        if (r27 == null) goto L84;
        com.larus.bmhome.chat.model.j1 r28 = r27.Y3();
        if (r28 == null) goto L84;
        r28.q();
    L84:
        ICoreInputAbility r29 = (ICoreInputAbility) this.m.getValue();
        if (r29 == null) goto L87;
        r29.p80(false);
    L87:
        z2 r30 = z2.a;
        if (r30.m3() == false) goto L94;
        boolean r31 = com.larus.bmhome.utils.e.a;
        if (r30.disableVoiceInput() == true) goto L94;
        r5 = false;
    L94:
        if (r5 == false) goto L100;
        r111.L().a(false);
        V3().c(r110, "audio_input_disabled");
        if (r6 == false) goto L98;
        r1.notifyAiKeyEvent(0);
    L98:
        E3("blocked", "audio_input_disabled", this.p0);
        return;
    L100:
        String r32 = UUID.randomUUID().toString();
        if (r13 == false) goto L103;
        VoiceInputType r33 = VoiceInputType.DoraRadioSpeaker;
    L104:
        com.larus.bmhome.chat.component.bottom.core.speaker.l r34 = a4();
        if (r34 != null) goto L111;
        r111.L().a(false);
        V3().c(r110, "speaker_ability_missing");
        if (r6 == false) goto L109;
        r1.notifyAiKeyEvent(0);
    L109:
        E3("blocked", "speaker_ability_missing", this.p0);
        return;
    L111:
        ICoreInputAbility r35 = (ICoreInputAbility) this.m.getValue();
        if (r35 == null) goto L120;
        z8.a r36 = r35.Jd();
        if (r36 == null) goto L120;
        if (r36.a == false) goto L118;
        r11 = r36;
    L118:
        if (r11 == null) goto L120;
        boolean r37 = r11.b;
    L121:
        String r38 = com.larus.bmhome.chat.component.bottom.core.speaker.l.a.a(r34, false, r37, r33, r20, new com.larus.audio.asr.c0(r32, "AiKey", 0, 252), r21, r22, null, null, new m2(this), 384);
        if (r38 != null) goto L124;
        r111.L().a(false);
        V3().c(r110, "speak_task_create_failed");
        E3("dropped", "touch_speak_start_failed", this.p0);
    L127:
        if (r38 == null) goto L133;
        if (r13 == false) goto L130;
        return;
    L130:
        if (k4() == false) goto L135;
        SoftReference r39 = com.larus.utils.y.a;
        n2 r40 = new n2(this, r38);
        Intrinsics.checkNotNullParameter(r40, "action");
        com.larus.utils.y.c(r40);
        return;
    L135:
        return;
    L133:
        return;
    L124:
        this.L = new c(r38, r110);
        this.O.put(r38, r110);
        uga.b r41 = this.p0;
        if (r41 == null) goto L127;
        this.H0.put(r38, r41);
    L120:
        r37 = false;
        goto L121
    L103:
        r33 = VoiceInputType.TouchSpeaker;
        goto L104
    L73:
        if (Intrinsics.areEqual(AssistantStartupTelemetry.a.i("asr_record_ready"), r25.a) == false) goto L75;
    L51:
        if (r17.length() == 0) goto L54;
        r18 = false;
        goto L55
    L48:
        r17 = null;
    L56:
        r24 = false;
        goto L68
    L22:
        if (r14.c == false) goto L24;
    L34:
        boolean r42 = true;
    L35:
        if (r42 == false) goto L38;
        r8.i("OrionIntercomComponent", "ignore TouchSpeak start while previous task is recording: taskId=" + r14.a);
        return;
    L38:
        r8.i("OrionIntercomComponent", "replace unresolved TouchSpeak task: taskId=" + r14.a);
        l4(r14);
        goto L39
    L24:
        if (r14.d == true) goto L34;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r43 = a4();
        if (r43 != null) goto L28;
    L30:
        boolean r44 = false;
    L31:
        if (r44 == true) goto L34;
        r42 = false;
        goto L35
    L28:
        if (r43.m0() != true) goto L30;
        r44 = true;
        goto L31
    L11:
        r12 = null;
        goto L12
    L5:
        if (k4() == false) goto L7;
        r6 = true;
        goto L8
    }

    public final void E3(String r8, String r9, uga.b r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.c() == false) goto L8;
        IAssistantStartupTelemetry.a.a(AssistantStartupTelemetry.a, r10.a, r8, r9, null, 24);
    L8:
        if (this.p0 != r10) goto L11;
        this.p0 = null;
        return;
    }

    public final void Fj(boolean r9, boolean r10, laa.n r11, String r12) {
        if (r9 == false) goto L5;
    L15:
        laa.n r1 = null;
        if (r9 == false) goto L43;
        if (r12 != null) goto L22;
        uga.b r13 = this.p0;
        if (r13 == null) goto L21;
        r12 = r13.a;
        goto L22
    L21:
        r12 = null;
    L22:
        com.obric.assistant.view.listening.f r2 = V3();
        c r14 = this.L;
        if (r14 == null) goto L25;
        r1 = r14.b;
    L25:
        if (r14 == null) goto L27;
    L30:
        ObricListeningVisualMode r15 = ObricListeningVisualMode.PRESS_TALK;
    L31:
        ObricListeningVisualMode r4 = r15;
        q1 r6 = new q1(this, r10, r12);
        r1 r7 = new r1(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "mode");
        Intrinsics.checkNotNullParameter(r6, "renderLocal");
        Intrinsics.checkNotNullParameter(r7, "onVisible");
        com.obric.assistant.view.listening.b r16 = r2.d(r11);
        if ((r11 instanceof com.obric.assistant.view.listening.a) == false) goto L35;
        if (r16 != null) goto L35;
        FLogger.a.i("ObricListeningViewController", "child presentation cleared, reselect main View target");
    L35:
        if (r16 != null) goto L41;
        r16 = r2.d(r1);
        if (r16 != null) goto L41;
        r16 = r2.d(r2.e);
        if (r16 != null) goto L41;
        r16 = r2.b();
    L41:
        r2.f(r16, r4, "view_visible", r6, r7);
        return;
    L27:
        if (Intrinsics.areEqual(ObricInteractDelegate.b.isAiKeyLongPress(), Boolean.TRUE) == true) goto L30;
        r15 = ObricListeningVisualMode.CLICK_TALK;
        goto L31
    L43:
        p4(false, r10);
        com.obric.assistant.view.listening.f r17 = V3();
        c r18 = this.L;
        if (r18 == null) goto L46;
        r1 = r18.b;
    L46:
        com.obric.assistant.view.listening.b r19 = r17.d(r11);
        if (r19 != null) goto L53;
        r19 = r17.d(r1);
        if (r19 != null) goto L53;
        r19 = r17.d(r17.e);
        if (r19 != null) goto L53;
        return;
    L53:
        r17.c(r19, "view_hidden");
        return;
    L5:
        if (this.X == false) goto L15;
        if (((Boolean) this.U.getValue()).booleanValue() == true) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L15;
        FLogger.a.i("OrionIntercomComponent", "setClickTalkViewVisible skip hide during intercom switch");
        return;
    L9:
        if (h4() == false) goto L11;
        r3 = true;
        goto L12
    }

    public final void h3(View r10, boolean r11, boolean r12, Function0<Unit> r13) {
        float r1 = 1.0f;
        if (r11 == true) goto L5;
    L22:
        if (r11 == true) goto L25;
        r1 = 0.0f;
    L25:
        r10.animate().cancel();
        if (r12 == false) goto L31;
        if (r11 == false) goto L31;
        if (r10.getVisibility() == 0) goto L31;
        r10.setAlpha(0.0f);
        r10.setVisibility(0);
    L37:
        r10.animate().alpha(r1).setDuration(180).setListener(new d(r11, r12, r10, r13)).start();
        return;
    L31:
        if (r12 == false) goto L37;
        if (r11 == true) goto L37;
        if (r10.getVisibility() == 0) goto L37;
        r10.setAlpha(0.0f);
        return;
    L5:
        if (r10 != X3()) goto L22;
        ViewParent r3 = X3().getParent();
        if ((r3 instanceof ViewGroup) == false) goto L9;
        ViewGroup r4 = (ViewGroup) r3;
    L10:
        if (r4 == null) goto L22;
        if (r4 != X3().getRootView()) goto L22;
        int r5 = r4.getChildCount();
        int r6 = 0;
        float r7 = 0.0f;
    L16:
        if (r6 >= r5) goto L21;
        OverlayerAudioView r8 = r4.getChildAt(r6);
        if (r8 == X3()) goto L20;
        r7 = Math.max(r7, r8.getZ());
    L20:
        r6 = r6 + 1;
        goto L16
    L21:
        X3().setZ(r7 + 1.0f);
        goto L22
    L9:
        r4 = null;
        goto L10
    }

    public static void G4(ObricIntercomComponent r10, boolean r11, Bundle r12, boolean r13, int r14) {
        if ((r14 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        if (r10.V3().j == false) goto L11;
        r10.B4(true);
        r10.e4();
        return;
    L11:
        if (r11 == true) goto L13;
        r10.B4(false);
    L13:
        ObricInteractDelegate r15 = ObricInteractDelegate.b;
        Boolean r3 = r15.isAiKeyLongPress();
        Boolean r4 = Boolean.TRUE;
        boolean r5 = Intrinsics.areEqual(r3, r4);
        if (((Boolean) r10.U.getValue()).booleanValue() != r11) goto L20;
        if (r13 == true) goto L20;
        if (r11 == false) goto L19;
        if (r5 == false) goto L19;
        r10.v4();
    L19:
        FLogger.a.i("OrionIntercomComponent", "updateWindowAudioVisibility " + r11 + ", already " + r11);
        return;
    L20:
        if (r11 == true) goto L22;
    L36:
        r10.U.setValue(Boolean.valueOf(r11));
        com.larus.bmhome.chat.component.bottom.core.speaker.m r16 = r10.c4();
        if (r16 == null) goto L39;
        SessionType r17 = r16.getSessionType();
    L40:
        FLogger r18 = FLogger.a;
        r18.i("OrionIntercomComponent", "updateWindowAudioVisibility " + r11 + ", sessionType " + r17 + ", isResumeClickTalk " + r13);
        if (r11 == false) goto L73;
        if (s1a.a.d(r10) == false) goto L45;
    L53:
        Context r6 = r10.getContext();
        if ((r6 instanceof Activity) == false) goto L56;
        Activity r7 = (Activity) r6;
    L57:
        if (r7 == null) goto L66;
        View r8 = r7.getCurrentFocus();
        if (r8 == null) goto L66;
        Object r9 = r8.getContext().getSystemService("input_method");
        if ((r9 instanceof InputMethodManager) == false) goto L63;
        InputMethodManager r19 = (InputMethodManager) r9;
    L64:
        if (r19 == null) goto L66;
        r19.restartInput(r8);
        goto L66
    L63:
        r19 = null;
    L66:
        ICoreInputAbility r20 = (ICoreInputAbility) r10.m.getValue();
        if (r20 == null) goto L69;
        r20.qp(true);
    L69:
        va8.o r21 = (va8.o) r10.n.getValue();
        if (r21 == null) goto L73;
        r21.ra();
        goto L73
    L56:
        r7 = null;
        goto L57
    L45:
        if (h4() == false) goto L73;
        if (com.obric.assistant.common.utils.y.c().contains("com.bytedance.android.doubaoime") == true) goto L49;
    L51:
        boolean r22 = false;
    L52:
        if (r22 == false) goto L73;
    L49:
        if (com.obric.assistant.common.utils.y.e() == false) goto L51;
        r22 = true;
    L73:
        if (r17 != SessionType.CLICK_TALK) goto L86;
        r18.i("OrionIntercomComponent", "updateClickTalkVisibility " + r11 + ", playWelcomeAnimation " + r13);
        OverlayerAudioView r110 = r10.X3();
        if (r11 == false) goto L77;
        w1 r111 = new w1(r10, r13);
    L78:
        r10.h3(r110, r11, true, r111);
        if (r11 == true) goto L81;
    L82:
        View r112 = r10.Q3();
        if (r112 == null) goto L119;
        r10.h3(r112, !r11, false, null);
    L119:
        com.larus.bmhome.chat.component.bottom.core.speaker.m r113 = r10.c4();
        if (r113 == null) goto L129;
        ChatSpeaker r114 = r113.lM();
        if (r114 == null) goto L130;
        if (r11 == false) goto L125;
        r114.setAlpha(0.0f);
        return;
    L125:
        r114.setAlpha(1.0f);
        return;
    L130:
        return;
    L129:
        return;
    L81:
        if (r10.j4() == false) goto L119;
    L77:
        r111 = null;
        goto L78
    L86:
        if (r17 == SessionType.INTERCOM) goto L90;
        if (r5 == true) goto L90;
        r18.i("OrionIntercomComponent", "updateWindowAudioVisibility " + r11 + ", sessionType " + r17 + ", isIntercomActive " + r5);
    L90:
        laa.d r115 = r10.Z3();
        if (r115 == null) goto L93;
        ObricFloatChatPageState r116 = r115.getPageState();
    L94:
        r18.i("OrionIntercomComponent", "updateIntercomVisibility " + r11 + ", pageState " + r116 + ", isLandscape " + s1a.a.d(r10));
        boolean r117 = r10.j4();
        ObricFloatChatPageData.Companion.getClass();
        if ((r116 instanceof vda.a) == false) goto L108;
        if (r11 == false) goto L105;
        if (r117 == false) goto L101;
        View r118 = r10.Q3();
        if (r118 == null) goto L101;
        r118.setAlpha(0.0f);
    L101:
        ViewGroup r119 = (ViewGroup) r10.B.getValue();
        if (r119 == null) goto L104;
        r119.setTranslationY(0.0f);
    L104:
        r10.h3(r10.X3(), true, true, new a2(r10));
        goto L119
    L105:
        r10.h3(r10.X3(), r11, true, null);
        View r120 = r10.Q3();
        if (r120 == null) goto L119;
        r10.h3(r120, !r11, false, null);
        goto L119
    L108:
        OverlayerAudioView r121 = r10.X3();
        if (r11 == false) goto L111;
        b2 r122 = new b2(r10);
    L112:
        r10.h3(r121, r11, true, r122);
        if (r11 == true) goto L115;
    L116:
        View r123 = r10.Q3();
        if (r123 == null) goto L119;
        r10.h3(r123, !r11, false, null);
        goto L119
    L115:
        if (r10.j4() == false) goto L119;
    L111:
        r122 = null;
        goto L112
    L93:
        r116 = null;
        goto L94
    L39:
        r17 = null;
        goto L40
    L22:
        if (Intrinsics.areEqual(r15.isAiKeyPressing(), r4) == true) goto L31;
        if (r12 != null) goto L25;
    L27:
        boolean r124 = false;
    L28:
        if (r124 == true) goto L31;
        boolean r125 = false;
    L32:
        if (r125 == false) goto L36;
        IAssistantChatWindow r126 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r126 == null) goto L36;
        r126.applyWindowAnimationBoost("window_intercom_fade", 200);
        goto L36
    L25:
        if (r12.getBoolean("arg_wakeup") != true) goto L27;
        r124 = true;
    L31:
        r125 = true;
        goto L32
    }
}
