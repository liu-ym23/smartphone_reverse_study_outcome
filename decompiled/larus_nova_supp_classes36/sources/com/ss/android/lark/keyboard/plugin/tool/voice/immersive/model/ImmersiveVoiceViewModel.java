package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.audio.recorder.AudioRecordSettings;
import com.ss.android.lark.audio.voiceinput.AsrSessionState;
import com.ss.android.lark.audio.voiceinput.AudioPluginFeature;
import com.ss.android.lark.audio.voiceinput.CancelAsrTimeoutState;
import com.ss.android.lark.audio.voiceinput.VoiceInputMode;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.audio.voiceinput.VoiceInputService;
import com.ss.android.lark.audio.voiceinput.p;
import com.ss.android.lark.audio.voiceinput.perf.VoiceInputAppreciablePerformance;
import com.ss.android.lark.audio.voiceinput.processor.ProcessType;
import com.ss.android.lark.audio.voiceinput.processor.VoiceDataProcessDispatcher;
import com.ss.android.lark.audio.voiceinput.q;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.service.w;
import com.ss.android.lark.audio.voiceinput.t;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioRecordCoordinator;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginConstants;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SendType;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.r;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.s;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.utils.AsrAdoptionRate;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.utils.AsrNerStatisticV2;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.utils.UserInfoHitPoint;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.x;
import com.ss.android.lark.keyboard.plugin.tool.voice.processor.AudioRecordDataProcessor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.recognition.SpeechRecognitionFeedbackItem;
import com.ss.android.lark.pb.recognition.SpeechRecognitionFeedbackRequest;
import com.ss.android.lark.pb.recognition.SpeechRecognitionFeedbackResponse;
import com.ss.android.lark.pb.recognition.SpeechRecognitionReportEditItem;
import com.ss.android.lark.pb.recognition.SpeechRecognitionReportEditRequest;
import com.ss.android.lark.pb.recognition.SpeechRecognitionReportEditResponse;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.y;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okio.ByteString;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000¢\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0006½\u0001À\u0001È\u0001\u0018\u0000 å\u00022\u00020\u00012\u00020\u0002:\u0002å\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010O\u001a\u00020\u0018J\u0012\u0010Â\u0001\u001a\u00020\u00182\u0007\u0010Ã\u0001\u001a\u00020|H\u0002J\u0013\u0010Ä\u0001\u001a\u00030§\u00012\u0007\u0010Ã\u0001\u001a\u00020|H\u0002J\b\u0010Å\u0001\u001a\u00030§\u0001J\b\u0010Æ\u0001\u001a\u00030§\u0001J\n\u0010Í\u0001\u001a\u00030§\u0001H\u0014J\u000f\u0010Î\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\bÏ\u0001J\u000f\u0010Ð\u0001\u001a\u00020\u0010H\u0000¢\u0006\u0003\bÑ\u0001J4\u0010Ò\u0001\u001a\u00030§\u00012\b\u0010Ó\u0001\u001a\u00030Ô\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\b\u0010×\u0001\u001a\u00030 \u00012\f\b\u0002\u0010Ø\u0001\u001a\u0005\u0018\u00010±\u0001J\u0007\u0010Ù\u0001\u001a\u00020\u0018J\b\u0010Ú\u0001\u001a\u00030§\u0001J2\u0010Û\u0001\u001a\u00030§\u00012\b\u0010Ó\u0001\u001a\u00030Ô\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\b\u0010Ü\u0001\u001a\u00030Ý\u00012\b\u0010×\u0001\u001a\u00030 \u0001H\u0002J6\u0010Þ\u0001\u001a\u00030§\u00012\b\u0010Ó\u0001\u001a\u00030Ô\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\b\u0010×\u0001\u001a\u00030 \u00012\f\b\u0002\u0010Ø\u0001\u001a\u0005\u0018\u00010±\u0001H\u0002J\u0011\u0010ß\u0001\u001a\u00030§\u00012\u0007\u0010à\u0001\u001a\u00020\bJ\b\u0010á\u0001\u001a\u00030§\u0001J\u0012\u0010â\u0001\u001a\u00030§\u00012\b\u0010ã\u0001\u001a\u00030\u009a\u0001J\u0010\u0010ä\u0001\u001a\u00020\u00182\u0007\u0010\u0087\u0001\u001a\u00020\u0010J\b\u0010å\u0001\u001a\u00030§\u0001J\u0013\u0010æ\u0001\u001a\u00030§\u00012\t\u0010ç\u0001\u001a\u0004\u0018\u00010\u0010J\u0013\u0010è\u0001\u001a\u00030§\u00012\t\u0010é\u0001\u001a\u0004\u0018\u00010\u0010J&\u0010ê\u0001\u001a\u00020\u00182\u0007\u0010ë\u0001\u001a\u00020*2\u0007\u0010ì\u0001\u001a\u00020\u00102\t\u0010é\u0001\u001a\u0004\u0018\u00010\u0010H\u0016J\u001d\u0010í\u0001\u001a\u00020\u00182\u0007\u0010ë\u0001\u001a\u00020*2\t\u0010ì\u0001\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u0010î\u0001\u001a\u00030§\u0001H\u0016J\n\u0010ï\u0001\u001a\u00030§\u0001H\u0016J\b\u0010ð\u0001\u001a\u00030§\u0001J\b\u0010ñ\u0001\u001a\u00030§\u0001J\b\u0010ò\u0001\u001a\u00030§\u0001J\b\u0010ó\u0001\u001a\u00030§\u0001J\u001a\u0010ô\u0001\u001a\u00030§\u00012\u0007\u0010õ\u0001\u001a\u00020\u00102\u0007\u0010ö\u0001\u001a\u00020\u0010J\u0010\u0010÷\u0001\u001a\u00020\u00182\u0007\u0010ö\u0001\u001a\u00020\u0010J\u0012\u0010ø\u0001\u001a\u00030§\u00012\b\u0010ù\u0001\u001a\u00030ú\u0001J\u0007\u0010û\u0001\u001a\u00020\u0018J\b\u0010ü\u0001\u001a\u00030§\u0001Jt\u0010ý\u0001\u001a\u00030§\u00012\u0007\u0010þ\u0001\u001a\u00020\u00102\u000e\u0010ÿ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00100¬\u00012\u000e\u0010\u0080\u0002\u001a\t\u0012\u0004\u0012\u00020\u00100¬\u00012\u0007\u0010\u0081\u0002\u001a\u00020\u00102\u000f\u0010\u0082\u0002\u001a\n\u0012\u0005\u0012\u00030§\u00010¦\u00012'\u0010\u0083\u0002\u001a\"\u0012\u0017\u0012\u00150\u0084\u0002¢\u0006\u000f\b\u0085\u0002\u0012\n\b\u0086\u0002\u0012\u0005\b\b(\u0087\u0002\u0012\u0005\u0012\u00030§\u00010DJ\b\u0010\u0088\u0002\u001a\u00030§\u0001J\u0011\u0010\u0089\u0002\u001a\u00030§\u00012\u0007\u0010\u008a\u0002\u001a\u00020\u0010J#\u0010\u008b\u0002\u001a\u00030§\u00012\u0007\u0010\u008c\u0002\u001a\u00020\u00182\u0007\u0010\u008d\u0002\u001a\u00020\u00132\u0007\u0010\u008e\u0002\u001a\u00020\u0010J\u0011\u0010\u008f\u0002\u001a\u00030§\u00012\u0007\u0010\u0090\u0002\u001a\u00020\u0018J\b\u0010\u0091\u0002\u001a\u00030§\u0001J\u000f\u0010\u0092\u0002\u001a\u00020\u0018H\u0000¢\u0006\u0003\b\u0093\u0002J\u0011\u0010\u0094\u0002\u001a\u00030§\u00012\u0007\u0010\u0095\u0002\u001a\u00020\u0018J\u0011\u0010\u0096\u0002\u001a\u00030§\u00012\u0007\u0010\u0095\u0002\u001a\u00020\u0018J\b\u0010\u0097\u0002\u001a\u00030§\u0001J\u0007\u0010W\u001a\u00030§\u0001J\u001a\u0010\u0098\u0002\u001a\u00030§\u00012\u0007\u0010\u008d\u0002\u001a\u00020\u00132\u0007\u0010\u008e\u0002\u001a\u00020\u0010J(\u0010\u0099\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030\u009a\u0002\u0018\u00010¬\u00010\u00072\u0007\u0010\u009b\u0002\u001a\u00020\u0010J\u001a\u0010\u009c\u0002\u001a\u00030§\u00012\u0007\u0010\u008e\u0002\u001a\u00020\u00102\u0007\u0010\u008d\u0002\u001a\u00020\u0013J\u001a\u0010\u009d\u0002\u001a\u00030§\u00012\u0007\u0010\u008e\u0002\u001a\u00020\u00102\u0007\u0010\u008d\u0002\u001a\u00020\u0013J#\u0010\u009e\u0002\u001a\u00030§\u00012\u0007\u0010\u009f\u0002\u001a\u00020\u00132\u0007\u0010 \u0002\u001a\u00020\u00182\u0007\u0010é\u0001\u001a\u00020\u0010J\u0007\u0010¡\u0002\u001a\u00020\u0018J\u0007\u0010¢\u0002\u001a\u00020\u0018J\u0007\u0010£\u0002\u001a\u00020\u0018J\u0007\u0010¤\u0002\u001a\u00020\u0018J\u0013\u0010¥\u0002\u001a\u00030§\u00012\t\b\u0002\u0010¦\u0002\u001a\u00020\u0018J\b\u0010§\u0002\u001a\u00030§\u0001J\b\u0010¨\u0002\u001a\u00030§\u0001J\u0011\u0010©\u0002\u001a\u00030§\u00012\u0007\u0010ª\u0002\u001a\u00020\u0016J\b\u0010«\u0002\u001a\u00030§\u0001J\u001d\u0010¬\u0002\u001a\u0016\u0012\u0005\u0012\u00030®\u00020\u00ad\u0002j\n\u0012\u0005\u0012\u00030®\u0002`¯\u0002H\u0002J0\u0010°\u0002\u001a\u00030±\u00022\u0007\u0010\u008d\u0002\u001a\u00020\u00132\u001b\u0010²\u0002\u001a\u0016\u0012\u0005\u0012\u00030®\u00020\u00ad\u0002j\n\u0012\u0005\u0012\u00030®\u0002`¯\u0002H\u0002J7\u0010³\u0002\u001a\u0004\u0018\u00010w2\t\u0010´\u0002\u001a\u0004\u0018\u00010|2\f\b\u0002\u0010µ\u0002\u001a\u0005\u0018\u00010¶\u00022\u000b\b\u0002\u0010·\u0002\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0003\u0010¸\u0002J\u0013\u0010¹\u0002\u001a\u00030º\u00022\u0007\u0010\u008d\u0002\u001a\u00020\u0013H\u0002J\u0007\u0010»\u0002\u001a\u00020\u0018J\u0007\u0010¼\u0002\u001a\u00020\u0018J\u001b\u0010½\u0002\u001a\u00030§\u00012\u000f\u0010¾\u0002\u001a\n\u0012\u0005\u0012\u00030§\u00010¦\u0001H\u0002J\n\u0010¿\u0002\u001a\u00030§\u0001H\u0002J\n\u0010À\u0002\u001a\u00030§\u0001H\u0002J&\u0010Á\u0002\u001a\u00030§\u00012\b\u0010Â\u0002\u001a\u00030Ã\u00022\u0007\u0010\u008c\u0002\u001a\u00020\u00182\t\b\u0002\u0010Ä\u0002\u001a\u00020\u0018J\u001b\u0010Å\u0002\u001a\u00030§\u00012\b\u0010Â\u0002\u001a\u00030Ã\u00022\u0007\u0010\u008c\u0002\u001a\u00020\u0018J\n\u0010Æ\u0002\u001a\u00030§\u0001H\u0002J\u001a\u0010Ç\u0002\u001a\u00020\u00182\u000f\u0010È\u0002\u001a\n\u0012\u0005\u0012\u00030§\u00010¦\u0001H\u0002J\t\u0010É\u0002\u001a\u00020\u0018H\u0002J\u001e\u0010Ê\u0002\u001a\u00030§\u00012\t\u0010Ë\u0002\u001a\u0004\u0018\u00010\u00102\u0007\u0010ç\u0001\u001a\u00020|H\u0002J\n\u0010Ì\u0002\u001a\u00030§\u0001H\u0002J\u001b\u0010Í\u0002\u001a\u00020\u00102\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u00102\u0007\u0010Ï\u0002\u001a\u00020\bJ\u001b\u0010Ð\u0002\u001a\u00020\u00132\t\u0010Î\u0002\u001a\u0004\u0018\u00010\u00102\u0007\u0010Ï\u0002\u001a\u00020\bJ\u0012\u0010Ñ\u0002\u001a\u00030§\u00012\b\u0010Ò\u0002\u001a\u00030\u009c\u0001J\u0014\u0010Ó\u0002\u001a\u00030§\u00012\n\u0010Ô\u0002\u001a\u0005\u0018\u00010\u009e\u0001J\b\u0010Õ\u0002\u001a\u00030§\u0001J\u0015\u0010Ö\u0002\u001a\u00030§\u00012\t\u0010Ë\u0002\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010×\u0002\u001a\u00020\u00102\u0007\u0010Ø\u0002\u001a\u00020\bH\u0002J\n\u0010Ù\u0002\u001a\u00030§\u0001H\u0002J\b\u0010Ú\u0002\u001a\u00030§\u0001J\t\u0010Û\u0002\u001a\u00020\u0018H\u0002JJ\u0010Ü\u0002\u001a\u00030§\u00012\t\u0010ç\u0001\u001a\u0004\u0018\u00010\u00102\t\u0010Ý\u0002\u001a\u0004\u0018\u00010\u00102\u0013\b\u0002\u0010Þ\u0002\u001a\f\u0012\u0005\u0012\u00030\u009a\u0002\u0018\u00010¬\u00012\b\u0010ß\u0002\u001a\u00030à\u00022\t\u0010á\u0002\u001a\u0004\u0018\u00010\u0010H\u0002J\u0011\u0010â\u0002\u001a\u00030§\u00012\u0007\u0010ã\u0002\u001a\u000203J\b\u0010ä\u0002\u001a\u00030§\u0001R,\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR#\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00104\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u001a\u00107\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00105\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00105\"\u0004\b;\u00109R\u001a\u0010<\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00105\"\u0004\b=\u00109R\u001a\u0010>\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00105\"\u0004\b?\u00109R\u001a\u0010@\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00105\"\u0004\bB\u00109R(\u0010C\u001a\u0010\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00105\"\u0004\bM\u00109R\u000e\u0010N\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010P\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00160\u00068F¢\u0006\u0006\u001a\u0004\bT\u0010\nR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0006\u001a\u0004\bV\u0010\nR\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0006\u001a\u0004\bX\u0010\nR\u0017\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u00068F¢\u0006\u0006\u001a\u0004\b[\u0010\nR\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00020F0\u00068F¢\u0006\u0006\u001a\u0004\b]\u0010\nR\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0006\u001a\u0004\b^\u0010\nR\u0017\u0010_\u001a\b\u0012\u0004\u0012\u00020`0\u00068F¢\u0006\u0006\u001a\u0004\ba\u0010\nR\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00068F¢\u0006\u0006\u001a\u0004\bb\u0010\nR\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00100\u00068F¢\u0006\u0006\u001a\u0004\bd\u0010\nR\u0017\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0006\u001a\u0004\bf\u0010\nR\u0017\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0006\u001a\u0004\bg\u0010\nR\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0006\u001a\u0004\bi\u0010\nR\u0017\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0006\u001a\u0004\bk\u0010\nR\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0006\u001a\u0004\bm\u0010\nR\u0017\u0010n\u001a\b\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\bo\u0010\nR\u0017\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00180q8F¢\u0006\u0006\u001a\u0004\br\u0010sR\u0017\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0006\u001a\u0004\bu\u0010\nR\u0017\u0010v\u001a\b\u0012\u0004\u0012\u00020w0\u0006¢\u0006\b\n\u0000\u001a\u0004\bx\u0010\nR\u0017\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\bz\u0010\nR\u0010\u0010{\u001a\u0004\u0018\u00010|X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0006\u001a\u0004\b\u007f\u0010\nR\u001d\u0010\u0080\u0001\u001a\u00020\u0018X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u00105\"\u0005\b\u0081\u0001\u00109R\u000f\u0010\u0082\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0083\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\nR\u0019\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010\nR\u0019\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010\nR\u0016\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00108F¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\"\u0010\u008b\u0001\u001a\u00020\u00102\u0007\u0010\u008a\u0001\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u0089\u0001R\u0012\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020Z0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020F0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¢\u0001\u001a\u00020\u00188F¢\u0006\u0007\u001a\u0005\b¢\u0001\u00105R\u0010\u0010£\u0001\u001a\u00030¤\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010¥\u0001\u001a\f\u0012\u0005\u0012\u00030§\u0001\u0018\u00010¦\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010ª\u0001\u001a\u0004\u0018\u00010|X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010«\u0001\u001a\f\u0012\u0005\u0012\u00030\u00ad\u0001\u0018\u00010¬\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010®\u0001\u001a\u00030¯\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010´\u0001\u001a\u00030µ\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¸\u0001\u001a\u0005\u0018\u00010·\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020`0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¼\u0001\u001a\u00030½\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¾\u0001R\u0013\u0010¿\u0001\u001a\u00030À\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010Á\u0001R\u0013\u0010Ç\u0001\u001a\u00030È\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010É\u0001R\u0015\u0010Ê\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180qX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ë\u0001\u001a\u00030Ì\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006æ\u0002"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/base/IBaseImmerVoiceViewModel;", "<init>", "()V", "beforeInsetSelection", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "getBeforeInsetSelection", "()Landroidx/lifecycle/MutableLiveData;", "setBeforeInsetSelection", "(Landroidx/lifecycle/MutableLiveData;)V", "beforeInsertSelectionV2", "getBeforeInsertSelectionV2", "insertPeriod", "", "getInsertPeriod", "insertPeriodRichText", "Lcom/ss/android/lark/widget/richtext/RichText;", "getInsertPeriodRichText", "_immersiveVoiceState", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceState;", "_popupWindowVisible", "", "_rollbackToOldAudio", "_isShowTipsResultCanEditable", "_elapseCountDown", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ElapseCountDownData;", "_voiceDuration", "_voiceRecordTooShort", "_isAsrRecognizeFinish", "_shouldShowAsrWaitingPoorNetTips", "_shouldShowPoorNetTips", "_asrNeedRetry", "_recordingOccurException", "_asrResultFocused", "_smartPeriodOptimizer", "Lcom/ss/android/lark/audio/voiceinput/SmartPeriodOptimizer;", "_asrSessionStateChecker", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/AsrSessionStateChecker;", "_voiceInputMode", "Lcom/ss/android/lark/audio/voiceinput/VoiceInputModeWithScene;", "chatId", "hitPointPageScene", "extraAnalyticParams", "", "_beforeEditAsrResult", "_isKeyboardShowing", "_isPanelShowing", "_keyboardController", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/IKeyboardController;", "isVoiceInputMarkdownFg", "()Z", "isVoiceSecondInputV2", "isAsrEnable", "setAsrEnable", "(Z)V", "isSupportPartialUpload", "setSupportPartialUpload", "isAsrNerEnable", "setAsrNerEnable", "isEnableVoiceInputSdk", "setEnableVoiceInputSdk", "autoSendOnRecognizeFinish", "getAutoSendOnRecognizeFinish", "setAutoSendOnRecognizeFinish", "onlyAsrRecognizingTipsProvider", "Lkotlin/Function1;", "Landroid/content/Context;", "", "getOnlyAsrRecognizingTipsProvider", "()Lkotlin/jvm/functions/Function1;", "setOnlyAsrRecognizingTipsProvider", "(Lkotlin/jvm/functions/Function1;)V", "hidePopupOnReleaseKeepSession", "getHidePopupOnReleaseKeepSession", "setHidePopupOnReleaseKeepSession", "keepSessionOnNextPopupHide", "isBackgroundAsrKeepSessionMode", "immersiveVoiceMode", "getImmersiveVoiceMode", "()Lcom/ss/android/lark/audio/voiceinput/VoiceInputModeWithScene;", "immersiveVoiceState", "getImmersiveVoiceState", "popupWindowVisible", "getPopupWindowVisible", "rollbackToOldAudio", "getRollbackToOldAudio", "audioRecordVolume", "", "getAudioRecordVolume", "audioAsrResult", "getAudioAsrResult", "isShowTipsResultCanEditable", "asrSessionState", "Lcom/ss/android/lark/audio/voiceinput/AsrSessionState;", "getAsrSessionState", "isElapseCountDown", "voiceDuration", "getVoiceDuration", "voiceRecordTooShort", "getVoiceRecordTooShort", "isAsrRecognizeFinish", "shouldShowAsrWaitingPoorNetTips", "getShouldShowAsrWaitingPoorNetTips", "shouldShowPoorNetTips", "getShouldShowPoorNetTips", "asrNeedRetry", "getAsrNeedRetry", "recordingOccurException", "getRecordingOccurException", "shouldHandleTouchEvent", "Landroidx/lifecycle/MediatorLiveData;", "getShouldHandleTouchEvent", "()Landroidx/lifecycle/MediatorLiveData;", "asrResultFocused", "getAsrResultFocused", "asrResultRichText", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/AsrRichTextResult;", "getAsrResultRichText", "startMention", "getStartMention", "_lastFinishedAsrResult", "Lcom/ss/android/lark/audio/voiceinput/AudioAsrResult;", "_showOriginalButtonVisible", "showOriginalButtonVisible", "getShowOriginalButtonVisible", "isProgrammaticUpdate", "setProgrammaticUpdate", "_userEditedAfterAsr", "_userClickedShowOriginal", "isRecordHardWareReady", "isKeyboardShowing", "isPanelShowing", "sourceId", "getSourceId", "()Ljava/lang/String;", "value", "currentRecordSourceId", "getCurrentRecordSourceId", "_audioRecordDelegate", "Lcom/ss/android/lark/audio/voiceinput/IAudioRecorderDelegate;", "_audioMessageDelegate", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/IAudioMessageDelegate;", "_audioRecordVolume", "_audioAsrResult", "_audioRecordCoordinator", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioRecordCoordinator;", "_speechRecognitionStatusPush", "Lcom/ss/android/lark/audio/voiceinput/service/ISpeechRecognitionEventPush;", "collectedPcmBuffer", "Lcom/ss/android/lark/audio/voiceinput/utils/ByteBufferAggregator;", "_voiceViewModelDependency", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/IVoiceViewModelDependency;", "_getEditTextAndSelectionDependency", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/IGetEditTextAndSelectionDependency;", "_inputStateController", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/IInputStateDependency;", "_audioResourceMutex", "Lcom/ss/android/lark/audio/voiceinput/IAudioResourceMutex;", "_isCancelingSession", "isCancelingSession", "_asrPreemptiveOptimize", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/AsrPreemptiveOptimize;", "_asrFirstPiecePendingBlock", "Lkotlin/Function0;", "", "_asrUserInfoMathStrategy", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/UserSearchAndMatchStrategy;", "_asrResult", "_asrNerInfoList", "", "Lcom/ss/android/lark/audio/voiceinput/AsrNerInfo;", "_voiceInputDelegate", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/VoiceInputDelegate;", "_voiceInputResultConsumer", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/IVoiceInputResultConsumer;", "_voiceRecordEntity", "Lcom/ss/android/lark/audio/voiceinput/VoiceRecordEntity;", "_immersivePerformance", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersivePerformance;", "asrTimeOutChecker", "Lkotlinx/coroutines/Job;", "asrWaitingTipsChecker", "_asrSessionState", "_isRecordHardwareReady", "_isPopUpTransitionEnd", "_voiceRecordListener", "com/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel$_voiceRecordListener$1", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel$_voiceRecordListener$1;", "_voiceDataAsrListener", "com/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel$_voiceDataAsrListener$1", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel$_voiceDataAsrListener$1;", "shouldShowOrigin", "src", "renderOriginRichText", "onShowOriginal", "markUserEditedAfterAsr", "_vcMeetingStatusListener", "com/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel$_vcMeetingStatusListener$1", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/ImmersiveVoiceViewModel$_vcMeetingStatusListener$1;", "_shouldHandleTouchEvent", "_speechRecognitionEventPushListener", "Lcom/ss/android/lark/audio/voiceinput/service/SpeechRecognitionEventPush$IPushListener;", "onCleared", "currentChatId", "currentChatId$keyboard_biz_voice_release", "currentHitPointScene", "currentHitPointScene$keyboard_biz_voice_release", "init", "voiceInputDependency", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceInputDependency;", "voiceInputConfig", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/ImmersiveVoiceInputConfig;", "recordMutex", "voiceInputConsumer", "isNeedInit", "destroy", "initWithCoordinator", "audioDataProcessorDependency", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/dependency/IAudioDataProcessorDependency;", "initWithVoiceInputService", "setMaxRecordTime", "maxRecordTime", "whenVoiceInputStart", "injectDependency", "voiceViewModelDependency", "shouldShowPoorNetworkToast", "afterPopUpTransitionEnd", "setBeforeVoiceEditAsrResult", "asrResult", "reportAsrEndEditContent", "editContent", "startVoiceRecord", "voiceInputModeWithScene", "asrLocale", "startVoiceRecordV1Impl", "cancelVoiceRecord", "stopVoiceRecord", "switch2VoiceAsr", "switch2VoiceRecordIfNeed", "whenClickLanguageSwitcher", "triggerStartMention", "switchLanguage", "languageName", "languageKey", "retryLastVoiceInput", "whenClickSwitchSendType", "sendType", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/SendType;", "isSecondVoiceInput", "whenClickFeedbackEntrance", "submitFeedback", "inputDesc", "descriptionList", "reasonIdtList", "clientResult", "onSuccess", "onError", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "Lkotlin/ParameterName;", "name", "err", "showEditableTipsIfNeed", "whenClickAsrResultEditText", "clientAsrResult", "whenClickCancel", "hasAsrText", "richText", "content", "updatePopupWindowVisible", "isVisible", "requestHidePopupKeepSession", "consumeKeepSessionOnPopupHide", "consumeKeepSessionOnPopupHide$keyboard_biz_voice_release", "updateIsKeyboardShowing", "isShowing", "updateIsPanelShowing", "dismissPopupWindow", "onlySendAudioMsg", "packReportEditItem", "Lcom/ss/android/lark/pb/recognition/SpeechRecognitionReportEditItem;", "reportEditContent", "onlySendTextMsg", "sendAudionWithTextMsg", "advanceModeSendHitPoint", "finalRichText", "hasResult", "isSupportVoiceWithAsr", "isDisableVoiceWithAsr", "isEnterpriseAnswerScene", "isCcmCommentScene", "resetLiveData", "isClearVoiceDataAll", "clearSessionState", "whenSwitch2Recognizing", "updateVoiceStateIfNeed", "newVoiceState", "whenReleaseOrCancelTouch", "packAsrUserInfoList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/utils/UserInfoHitPoint;", "Lkotlin/collections/ArrayList;", "calculateAsrResultV2", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/utils/AsrNerStatisticV2;", "asrUserInfoList", "packAudioAsrResult2AsrRichTextResult", "asrAudioAsrResult", "loadingSpan", "Landroid/text/SpannableStringBuilder;", "isFinish", "(Lcom/ss/android/lark/audio/voiceinput/AudioAsrResult;Landroid/text/SpannableStringBuilder;Ljava/lang/Boolean;)Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/AsrRichTextResult;", "calculateAsrResult", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/utils/AsrNerStatistic;", "isAsrSessionRunning", "isSessionRunning", "delayTriggerAsrTimeOut", "onAsrTimeOut", "delayTriggerAsrWaitingTips", "cancelAsrWaitingTips", "cancelAsrTimeOut", "cancelingState", "Lcom/ss/android/lark/audio/voiceinput/CancelAsrTimeoutState;", "needNotify", "forceAsrSessionFinish", "stopAsrResultWhenRecordTimeTooShort", "needUpdateAsrState", "block", "isAsrResultEmpty", "processSessionFinish", "audio2Text", "safeClearLoading", "addPeriodIfNeed", "currentInputResult", "currentCursorPos", "addPeriodForRichTextIfNeed", "injectIGetEditTextAndSelectionDependency", "getEditTextAndSelectionDependency", "setInputStateController", "controller", "finishReplyMode", "updateCacheState", "formatTime", "millis", "registerListener", "unregisterListener", "needSendVoice", "submitAsrEditReportIfNeed", "editedAsrResult", "reportItems", "scene", "Lcom/ss/android/lark/pb/recognition/SpeechRecognitionReportEditRequest$Scene;", "firstStartAsrEditContent", "setKeyboardController", "kbController", "removeKeyboardController", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ImmersiveVoiceViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String KV_STORAGE_SHOW_EDITABLE_TIPS = "asr_result_show_editable_tips";
    public static final String TAG = "ImmersiveVoiceViewModel";
    private Function0<Unit> _asrFirstPiecePendingBlock;
    private final MutableLiveData<Boolean> _asrNeedRetry;
    private List<com.ss.android.lark.audio.voiceinput.a> _asrNerInfoList;
    private final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.a _asrPreemptiveOptimize;
    private com.ss.android.lark.audio.voiceinput.c _asrResult;
    private final MutableLiveData<Boolean> _asrResultFocused;
    private MutableLiveData<AsrSessionState> _asrSessionState;
    private final AsrSessionStateChecker _asrSessionStateChecker;
    private UserSearchAndMatchStrategy _asrUserInfoMathStrategy;
    private final MutableLiveData<CharSequence> _audioAsrResult;
    private com.ss.android.lark.keyboard.plugin.tool.voice.c _audioMessageDelegate;
    private AudioRecordCoordinator _audioRecordCoordinator;
    private com.ss.android.lark.audio.voiceinput.g _audioRecordDelegate;
    private final MutableLiveData<Double> _audioRecordVolume;
    private com.ss.android.lark.audio.voiceinput.h _audioResourceMutex;
    private String _beforeEditAsrResult;
    private final MutableLiveData<com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.f> _elapseCountDown;
    private com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.g _getEditTextAndSelectionDependency;
    private final k _immersivePerformance;
    private final MutableLiveData<l> _immersiveVoiceState;
    private r _inputStateController;
    private final MutableLiveData<Boolean> _isAsrRecognizeFinish;
    private boolean _isCancelingSession;
    private MutableLiveData<Boolean> _isKeyboardShowing;
    private MutableLiveData<Boolean> _isPanelShowing;
    private MutableLiveData<Boolean> _isPopUpTransitionEnd;
    private MutableLiveData<Boolean> _isRecordHardwareReady;
    private final MutableLiveData<Boolean> _isShowTipsResultCanEditable;
    private h _keyboardController;
    private com.ss.android.lark.audio.voiceinput.c _lastFinishedAsrResult;
    private final MutableLiveData<Boolean> _popupWindowVisible;
    private final MutableLiveData<Integer> _recordingOccurException;
    private final MutableLiveData<Boolean> _rollbackToOldAudio;
    private final MediatorLiveData<Boolean> _shouldHandleTouchEvent;
    private final MutableLiveData<Boolean> _shouldShowAsrWaitingPoorNetTips;
    private final MutableLiveData<Boolean> _shouldShowPoorNetTips;
    private final MutableLiveData<Boolean> _showOriginalButtonVisible;
    private final com.ss.android.lark.audio.voiceinput.k _smartPeriodOptimizer;
    private final w.a _speechRecognitionEventPushListener;
    private com.ss.android.lark.audio.voiceinput.service.o _speechRecognitionStatusPush;
    private boolean _userClickedShowOriginal;
    private boolean _userEditedAfterAsr;
    private final e _vcMeetingStatusListener;
    private final ImmersiveVoiceViewModel$_voiceDataAsrListener$1 _voiceDataAsrListener;
    private final MutableLiveData<String> _voiceDuration;
    private final VoiceInputDelegate _voiceInputDelegate;
    private p _voiceInputMode;
    private s _voiceInputResultConsumer;
    private com.ss.android.lark.audio.voiceinput.s _voiceRecordEntity;
    private final f _voiceRecordListener;
    private final MutableLiveData<Boolean> _voiceRecordTooShort;
    private i _voiceViewModelDependency;
    private final MutableLiveData<com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c> asrResultRichText;
    private Job asrTimeOutChecker;
    private Job asrWaitingTipsChecker;
    private boolean autoSendOnRecognizeFinish;
    private final MutableLiveData<Pair<Integer, Integer>> beforeInsertSelectionV2;
    private MutableLiveData<Pair<Integer, Integer>> beforeInsetSelection;
    private String chatId;
    private final com.ss.android.lark.audio.voiceinput.utils.a collectedPcmBuffer;
    private String currentRecordSourceId;
    private Map<String, String> extraAnalyticParams;
    private boolean hidePopupOnReleaseKeepSession;
    private String hitPointPageScene;
    private final MutableLiveData<String> insertPeriod;
    private final MutableLiveData<RichText> insertPeriodRichText;
    private boolean isAsrEnable;
    private boolean isAsrNerEnable;
    private boolean isEnableVoiceInputSdk;
    private volatile boolean isProgrammaticUpdate;
    private boolean isSupportPartialUpload;
    private final boolean isVoiceInputMarkdownFg;
    private final boolean isVoiceSecondInputV2;
    private boolean keepSessionOnNextPopupHide;
    private Function1<? super Context, ? extends CharSequence> onlyAsrRecognizingTipsProvider;
    private final MutableLiveData<String> startMention;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$advanceModeSendHitPoint$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$advanceModeSendHitPoint$1", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $editContent;
        final /* synthetic */ String $firstStartAsrEditContent;
        final /* synthetic */ List<SpeechRecognitionReportEditItem> $reportItems;
        int label;
        final /* synthetic */ ImmersiveVoiceViewModel this$0;

        public AnonymousClass1(ImmersiveVoiceViewModel r1, String r2, List<SpeechRecognitionReportEditItem> r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$editContent = r2;
            this.$reportItems = r3;
            this.$firstStartAsrEditContent = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$editContent, this.$reportItems, this.$firstStartAsrEditContent, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r8);
            ImmersiveVoiceViewModel r1 = this.this$0;
            String r9 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(r1);
            if (r9 != null) goto L7;
        L10:
            boolean r10 = true;
        L11:
            if (r10 == false) goto L13;
            String r11 = this.$editContent;
        L14:
            ImmersiveVoiceViewModel.access$submitAsrEditReportIfNeed(r1, r11, this.$editContent, this.$reportItems, SpeechRecognitionReportEditRequest.Scene.ADVANCED, this.$firstStartAsrEditContent);
            return Unit.INSTANCE;
        L13:
            r11 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            goto L14
        L7:
            if (r9.length() == 0) goto L10;
            r10 = false;
            goto L11
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[VoiceInputMode.values().length];
            r0[VoiceInputMode.VoiceAndAsr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[VoiceInputMode.OnlyVoice.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L29:
            r0[VoiceInputMode.OnlyAsr.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L23:
            r0[VoiceInputMode.SecondVoice.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L8:
            a = r0;
            int[] r1 = new int[SendType.values().length];
            r1[SendType.OnlyText.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[SendType.VoiceWithAsr.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L11:
            b = r1;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ImmersiveVoiceViewModel a;
        public final /* synthetic */ MediatorLiveData<Boolean> b;

        public c(ImmersiveVoiceViewModel r1, MediatorLiveData<Boolean> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L7;
            MutableLiveData r3 = ImmersiveVoiceViewModel.access$get_isPopUpTransitionEnd$p(this.a);
            Intrinsics.checkNotNullParameter(r3, "<this>");
            Object r4 = r3.getValue();
            Boolean r0 = Boolean.TRUE;
            if (Intrinsics.areEqual(r4, r0) == false) goto L7;
            sob.c.e(this.b, r0);
            return;
        L7:
            sob.c.e(this.b, Boolean.FALSE);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ImmersiveVoiceViewModel a;
        public final /* synthetic */ MediatorLiveData<Boolean> b;

        public d(ImmersiveVoiceViewModel r1, MediatorLiveData<Boolean> r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L7;
            MutableLiveData r3 = ImmersiveVoiceViewModel.access$get_isRecordHardwareReady$p(this.a);
            Intrinsics.checkNotNullParameter(r3, "<this>");
            Object r4 = r3.getValue();
            Boolean r0 = Boolean.TRUE;
            if (Intrinsics.areEqual(r4, r0) == false) goto L7;
            sob.c.e(this.b, r0);
            return;
        L7:
            sob.c.e(this.b, Boolean.FALSE);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$delayTriggerAsrTimeOut$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$delayTriggerAsrTimeOut$1", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {1879}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onAsrTimeOut;
        int label;
        final /* synthetic */ ImmersiveVoiceViewModel this$0;

        public C04151(ImmersiveVoiceViewModel r1, Function0<Unit> r2, Continuation<? super C04151> r3) {
            this.this$0 = r1;
            this.$onAsrTimeOut = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04151(this.this$0, this.$onAsrTimeOut, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            boolean r4 = true;
            if (r2 == 0) goto L11;
            if (r2 != 1) goto L10;
            ResultKt.throwOnFailure(r8);     // Catch: Exception -> L7
        L15:
            AsrSessionState r9 = (AsrSessionState) ImmersiveVoiceViewModel.access$get_asrSessionState$p(this.this$0).getValue();     // Catch: Exception -> L7
            if (r9 != null) goto L18;
        L20:
            r4 = false;
        L21:
            if (r4 == false) goto L23;
            this.$onAsrTimeOut.invoke();     // Catch: Exception -> L7
        L31:
            return Unit.INSTANCE;
        L23:
            StringBuilder r10 = new StringBuilder("delayTriggerAsrTimeOut cancel show toast by session end. ");     // Catch: Exception -> L7
            AsrSessionState r0 = (AsrSessionState) ImmersiveVoiceViewModel.access$get_asrSessionState$p(this.this$0).getValue();     // Catch: Exception -> L7
            if (r0 == null) goto L26;
            String r3 = r0.info();     // Catch: Exception -> L7
        L27:
            r10.append(r3);     // Catch: Exception -> L7
            Log.i(ImmersiveVoiceViewModel.TAG, r10.toString());     // Catch: Exception -> L7
            goto L31
        L26:
            r3 = null;
            goto L27
        L18:
            if (r9.isAsrSessionRunning() != true) goto L20;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r8);
            long r5 = AudioPluginConstants.a();     // Catch: Exception -> L7
            this.label = 1;     // Catch: Exception -> L7
            if (DelayKt.delay(r5, this) != r1) goto L15;
            return r1;
        L7:
            e = move-exception;
            Log.i(ImmersiveVoiceViewModel.TAG, "delayTriggerAsrTimeOut / Exception" + e);
            goto L31
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$delayTriggerAsrWaitingTips$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$delayTriggerAsrWaitingTips$1", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {1900}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $waitingTipsDelay;
        int label;
        final /* synthetic */ ImmersiveVoiceViewModel this$0;

        public C04161(long r1, ImmersiveVoiceViewModel r3, Continuation<? super C04161> r4) {
            this.$waitingTipsDelay = r1;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C04161(this.$waitingTipsDelay, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            AsrSessionState r7 = (AsrSessionState) ImmersiveVoiceViewModel.access$get_asrSessionState$p(this.this$0).getValue();
            boolean r2 = false;
            if (r7 != null) goto L14;
        L16:
            if (r2 == false) goto L19;
            sob.c.e(ImmersiveVoiceViewModel.access$get_shouldShowAsrWaitingPoorNetTips$p(this.this$0), Boxing.boxBoolean(true));
        L19:
            return Unit.INSTANCE;
        L14:
            if (r7.isAsrSessionRunning() != true) goto L16;
            r2 = true;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            long r3 = this.$waitingTipsDelay;
            this.label = 1;
            if (DelayKt.delay(r3, this) != r0) goto L11;
            return r0;
        }
    }

    public static final class e implements KeyboardVoiceModule.b {
        public e() {
        }
    }

    public static final class f implements com.ss.android.lark.audio.voiceinput.j {
        public boolean a;
        public final /* synthetic */ ImmersiveVoiceViewModel b;

        public final void c() {
            this.b.whenReleaseOrCancelTouch();
        }

        public final void d() {
            ImmersiveVoiceViewModel.access$stopAsrResultWhenRecordTimeTooShort(this.b);
            sob.c.e(ImmersiveVoiceViewModel.access$get_voiceRecordTooShort$p(this.b), Boolean.TRUE);
            if (this.b.isSecondVoiceInput() == true) goto L6;
            this.b.dismissPopupWindow();
            return;
        }

        public f(ImmersiveVoiceViewModel r1) {
            this.b = r1;
        }

        public final void b(com.ss.android.lark.audio.voiceinput.s r3) {
            Intrinsics.checkNotNullParameter(r3, "voiceRecordEntity");
            sob.c.e(ImmersiveVoiceViewModel.access$get_isRecordHardwareReady$p(this.b), Boolean.TRUE);
            this.a = false;
            sob.c.e(ImmersiveVoiceViewModel.access$get_asrSessionState$p(this.b), AsrSessionState.AsrSessionRecording);
            ImmersiveVoiceViewModel.access$set_voiceRecordEntity$p(this.b, r3);
            k.b r4 = ImmersiveVoiceViewModel.access$get_immersivePerformance$p(this.b).b;
            r4.b.d();
            r4.a = 2;
        }

        public final void e(com.ss.android.lark.audio.voiceinput.s r5) {
            Intrinsics.checkNotNullParameter(r5, "voiceRecordEntity");
            StringBuilder r0 = new StringBuilder("onRecordStop: _immersiveVoiceState:");
            l r1 = (l) ImmersiveVoiceViewModel.access$get_immersiveVoiceState$p(this.b).getValue();
            l r2 = null;
            if (r1 == null) goto L5;
            Integer r3 = Integer.valueOf(r1.getState());
        L6:
            r0.append(r3);
            r0.append(" lastState:");
            l r4 = (l) ImmersiveVoiceViewModel.access$get_immersiveVoiceState$p(this.b).getValue();
            if (r4 == null) goto L9;
            r2 = r4.c();
        L9:
            r0.append(r2);
            Log.i(ImmersiveVoiceViewModel.TAG, r0.toString());
            l r6 = (l) ImmersiveVoiceViewModel.access$get_immersiveVoiceState$p(this.b).getValue();
            boolean r7 = false;
            if (r6 != null) goto L12;
        L14:
            boolean r8 = false;
        L15:
            if (r8 == true) goto L22;
            l r9 = (l) ImmersiveVoiceViewModel.access$get_immersiveVoiceState$p(this.b).getValue();
            if (r9 != null) goto L19;
        L21:
            if (r7 == true) goto L22;
        L24:
            if (ImmersiveVoiceViewModel.access$needSendVoice(this.b) == false) goto L33;
            String r10 = this.b.getCurrentRecordSourceId();
            s r11 = ImmersiveVoiceViewModel.access$get_voiceInputResultConsumer$p(this.b);
            if (r11 == null) goto L29;
            r11.c(r5);
        L29:
            if (KeyboardVoiceFGUtils.c() == false) goto L31;
            this.b.finishReplyMode();
        L31:
            sob.d r12 = sob.d.a;
            Map r13 = ImmersiveVoiceViewModel.access$getExtraAnalyticParams$p(this.b);
            r12.getClass();
            sob.d.h(r10, r13);
            return;
        L33:
            return;
        L19:
            if (r9.getState() != 5) goto L21;
            r7 = true;
        L22:
            sob.c.e(ImmersiveVoiceViewModel.access$get_voiceDuration$p(this.b), ImmersiveVoiceViewModel.access$formatTime(this.b, r5.c));
            goto L24
        L12:
            if (r6.getState() != 3) goto L14;
            r8 = true;
            goto L15
        L5:
            r3 = null;
            goto L6
        }

        public final void g(com.ss.android.lark.audio.voiceinput.s r5) {
            Intrinsics.checkNotNullParameter(r5, "voiceRecordEntity");
            l r0 = (l) ImmersiveVoiceViewModel.access$get_immersiveVoiceState$p(this.b).getValue();
            if (r0 == null) goto L10;
            ImmersiveVoiceViewModel r1 = this.b;
            if (r0.getState() != 3) goto L8;
            sob.c.e(ImmersiveVoiceViewModel.access$get_voiceDuration$p(r1), ImmersiveVoiceViewModel.access$formatTime(r1, r5.c));
        L8:
            if (r0.getState() <= 1) goto L10;
            sob.c.e(ImmersiveVoiceViewModel.access$get_audioRecordVolume$p(r1), Double.valueOf(r5.d));
        L10:
            ImmersiveVoiceViewModel.access$set_voiceRecordEntity$p(this.b, r5);
        }

        public final void a(int r4, boolean r5) {
            if (r5 == true) goto L5;
        L9:
            l r6 = (l) ImmersiveVoiceViewModel.access$get_immersiveVoiceState$p(this.b).getValue();
            boolean r1 = false;
            if (r6 != null) goto L12;
        L14:
            boolean r7 = false;
        L15:
            if (r7 == false) goto L17;
            sob.c.e(ImmersiveVoiceViewModel.access$get_elapseCountDown$p(this.b), new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.f(r4, false));
            return;
        L17:
            l r8 = (l) ImmersiveVoiceViewModel.access$get_immersiveVoiceState$p(this.b).getValue();
            if (r8 != null) goto L20;
        L22:
            if (r1 == false) goto L26;
            sob.c.e(ImmersiveVoiceViewModel.access$get_elapseCountDown$p(this.b), new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.f(r4, true));
            return;
        L26:
            return;
        L20:
            if (r8.getState() != 2) goto L22;
            r1 = true;
            goto L22
        L12:
            if (r6.getState() != 3) goto L14;
            r7 = true;
            goto L15
        L5:
            if (this.a == true) goto L9;
            this.a = true;
            i r9 = ImmersiveVoiceViewModel.access$get_voiceViewModelDependency$p(this.b);
            if (r9 == null) goto L9;
            r9.b();
            goto L9
        }

        public final void f(int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "errorMsg");
            sob.c.e(ImmersiveVoiceViewModel.access$get_recordingOccurException$p(this.b), Integer.valueOf(r3));
            this.b.whenReleaseOrCancelTouch();
            Log.e(ImmersiveVoiceViewModel.TAG, "onAudioRecordError: " + r3 + ", " + r4);
            int r0 = VoiceInputAppreciablePerformance.a;
            i r1 = ImmersiveVoiceViewModel.access$get_voiceViewModelDependency$p(this.b);
            if (r1 == null) goto L7;
            boolean r2 = true;
            if (r1.c() != true) goto L7;
        L8:
            VoiceInputAppreciablePerformance.g(r3, r4, r2);
            return;
        L7:
            r2 = false;
            goto L8
        }
    }

    public static final class g<T> implements SdkSender.IParser {
        public static final g<T> a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final Object parse(byte[] r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            return (SpeechRecognitionReportEditResponse) SpeechRecognitionReportEditResponse.ADAPTER.decode(r2);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$onlySendAudioMsg$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$onlySendAudioMsg$2", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04212 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ RichText $richText;
        final /* synthetic */ String $sourceId;
        final /* synthetic */ ArrayList<UserInfoHitPoint> $userInfoList;
        int label;
        final /* synthetic */ ImmersiveVoiceViewModel this$0;

        public C04212(ImmersiveVoiceViewModel r1, String r2, RichText r3, ArrayList<UserInfoHitPoint> r4, String r5, Continuation<? super C04212> r6) {
            this.this$0 = r1;
            this.$sourceId = r2;
            this.$richText = r3;
            this.$userInfoList = r4;
            this.$content = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C04212(this.this$0, this.$sourceId, this.$richText, this.$userInfoList, this.$content, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r30) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L45;
            ResultKt.throwOnFailure(r30);
            if (this.this$0.isVoiceInputMarkdownFg() == false) goto L24;
            sob.d r1 = sob.d.a;
            String r9 = ImmersiveVoiceViewModel.access$getChatId$p(this.this$0);
            String r8 = this.$sourceId;
            AsrNerStatisticV2 r10 = ImmersiveVoiceViewModel.access$calculateAsrResultV2(this.this$0, this.$richText, this.$userInfoList);
            String r11 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            if (r11 != null) goto L9;
        L12:
            boolean r12 = true;
        L13:
            if (r12 == false) goto L15;
            String r13 = this.$content;
        L16:
            String r14 = this.$content;
            String r27 = r13;
            Map r15 = ImmersiveVoiceViewModel.access$getExtraAnalyticParams$p(this.this$0);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r9, "chatId");
            Intrinsics.checkNotNullParameter(r8, "sourceId");
            Intrinsics.checkNotNullParameter(r10, "asrNerStatistic");
            Intrinsics.checkNotNullParameter(r14, "finalAsrResult");
            Intrinsics.checkNotNullParameter(r15, "extraAnalyticParams");
            JSONArray r2 = sob.d.c(r10);
            Pair[] r3 = new Pair[11];
            r3[0] = new Pair("chat_id", r9);
            r3[1] = new Pair("click", "voice_only");
            r3[2] = new Pair("location", "im_input_button");
            r3[3] = new Pair("accept_cnt", 0);
            r3[4] = new Pair("sdk_result_cnt", Integer.valueOf(r10.getAdoptionRate().getAsrCount()));
            r3[5] = new Pair("user_info_list", r2);
            if (r27 != null) goto L19;
        L22:
            boolean r4 = true;
        L23:
            r3[6] = new Pair("is_result", Boolean.valueOf(!r4));
            r3[7] = new Pair("is_user_edited", Boolean.valueOf(!StringsKt.equals$default(r27, r14, false, 2, null)));
            int r5 = AudioAsrLanguageSwitcher.i;
            r3[8] = new Pair("user_lng", AudioAsrLanguageSwitcher.a.a());
            r3[9] = new Pair("source_id", r8);
            r3[10] = new Pair("text_len", Integer.valueOf(r14.length()));
            sob.d.e("im_voice_input_click", r15, r3);
        L43:
            return Unit.INSTANCE;
        L19:
            if (r27.length() == 0) goto L22;
            r4 = false;
            goto L23
        L15:
            r13 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            goto L16
        L9:
            if (r11.length() == 0) goto L12;
            r12 = false;
            goto L13
        L24:
            sob.d r21 = sob.d.a;
            String r16 = ImmersiveVoiceViewModel.access$getChatId$p(this.this$0);
            String r6 = this.$sourceId;
            sob.a r17 = ImmersiveVoiceViewModel.access$calculateAsrResult(this.this$0, this.$richText);
            String r18 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            if (r18 != null) goto L27;
        L30:
            boolean r19 = true;
        L31:
            if (r19 == false) goto L33;
            String r110 = this.$content;
        L34:
            String r26 = r110;
            String r111 = this.$content;
            Map r112 = ImmersiveVoiceViewModel.access$getExtraAnalyticParams$p(this.this$0);
            r21.getClass();
            Intrinsics.checkNotNullParameter(r16, "chatId");
            Intrinsics.checkNotNullParameter(r6, "sourceId");
            Intrinsics.checkNotNullParameter(r17, "asrNerStatistic");
            Intrinsics.checkNotNullParameter(r111, "finalAsrResult");
            Intrinsics.checkNotNullParameter(r112, "extraAnalyticParams");
            Triple r7 = new Triple(0, Integer.valueOf(r17.b.getAsrCount()), Integer.valueOf(r17.b.getSearchCount()));
            JSONArray r20 = sob.d.b(r17);
            Pair[] r22 = new Pair[12];
            r22[0] = new Pair("chat_id", r16);
            r22[1] = new Pair("click", "voice_only");
            r22[2] = new Pair("location", "im_input_button");
            r22[3] = new Pair("accept_cnt", r7.getFirst());
            r22[4] = new Pair("asr_cnt", r7.getSecond());
            r22[5] = new Pair("search_cnt", r7.getThird());
            r22[6] = new Pair("user_info_list", r20);
            if (r26 != null) goto L37;
        L40:
            boolean r23 = true;
        L41:
            r22[7] = new Pair("is_result", Boolean.valueOf(!r23));
            r22[8] = new Pair("is_user_edited", Boolean.valueOf(!StringsKt.equals$default(r26, r111, false, 2, null)));
            int r24 = AudioAsrLanguageSwitcher.i;
            r22[9] = new Pair("user_lng", AudioAsrLanguageSwitcher.a.a());
            r22[10] = new Pair("source_id", r6);
            r22[11] = new Pair("text_len", Integer.valueOf(r111.length()));
            sob.d.e("im_voice_input_click", r112, r22);
            goto L43
        L37:
            if (r26.length() == 0) goto L40;
            r23 = false;
            goto L41
        L33:
            r110 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            goto L34
        L27:
            if (r18.length() == 0) goto L30;
            r19 = false;
            goto L31
        L45:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$onlySendTextMsg$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$onlySendTextMsg$1", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ String $firstStartAsrEditContent;
        final /* synthetic */ List<SpeechRecognitionReportEditItem> $reportItems;
        final /* synthetic */ RichText $richText;
        final /* synthetic */ String $sourceId;
        final /* synthetic */ ArrayList<UserInfoHitPoint> $userInfoList;
        int label;
        final /* synthetic */ ImmersiveVoiceViewModel this$0;

        public C04221(ImmersiveVoiceViewModel r1, String r2, RichText r3, ArrayList<UserInfoHitPoint> r4, String r5, List<SpeechRecognitionReportEditItem> r6, String r7, Continuation<? super C04221> r8) {
            this.this$0 = r1;
            this.$sourceId = r2;
            this.$richText = r3;
            this.$userInfoList = r4;
            this.$content = r5;
            this.$reportItems = r6;
            this.$firstStartAsrEditContent = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C04221(this.this$0, this.$sourceId, this.$richText, this.$userInfoList, this.$content, this.$reportItems, this.$firstStartAsrEditContent, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r37) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L55;
            ResultKt.throwOnFailure(r37);
            if (this.this$0.isVoiceInputMarkdownFg() == false) goto L24;
            sob.d r1 = sob.d.a;
            String r15 = ImmersiveVoiceViewModel.access$getChatId$p(this.this$0);
            String r8 = this.$sourceId;
            AsrNerStatisticV2 r4 = ImmersiveVoiceViewModel.access$calculateAsrResultV2(this.this$0, this.$richText, this.$userInfoList);
            String r10 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            if (r10 != null) goto L9;
        L12:
            boolean r11 = true;
        L13:
            if (r11 == false) goto L15;
            String r12 = this.$content;
        L16:
            String r14 = this.$content;
            Map r6 = ImmersiveVoiceViewModel.access$getExtraAnalyticParams$p(this.this$0);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r15, "chatId");
            Intrinsics.checkNotNullParameter(r8, "sourceId");
            Intrinsics.checkNotNullParameter(r4, "asrNerStatistic");
            Intrinsics.checkNotNullParameter(r14, "finalAsrResult");
            Intrinsics.checkNotNullParameter(r6, "extraAnalyticParams");
            JSONArray r2 = sob.d.c(r4);
            float r5 = sob.d.d(r12, r14);
            Pair[] r7 = new Pair[13];
            r7[0] = new Pair("chat_id", r15);
            r7[1] = new Pair("click", "voice_input_send");
            r7[2] = new Pair("location", "im_input_button");
            r7[3] = new Pair("voice_input_send_type", "text_only");
            r7[4] = new Pair("user_info_list", r2);
            r7[5] = new Pair("cer_rate", Float.valueOf(r5));
            r7[6] = new Pair("accept_cnt", Integer.valueOf(r4.getAdoptionRate().getAcceptCount()));
            r7[7] = new Pair("sdk_result_cnt", Integer.valueOf(r4.getAdoptionRate().getAsrCount()));
            if (r12 != null) goto L19;
        L22:
            boolean r3 = true;
        L23:
            r7[8] = new Pair("is_result", Boolean.valueOf(!r3));
            r7[9] = new Pair("is_user_edited", Boolean.valueOf(!StringsKt.equals$default(r12, r14, false, 2, null)));
            int r9 = AudioAsrLanguageSwitcher.i;
            r7[10] = new Pair("user_lng", AudioAsrLanguageSwitcher.a.a());
            r7[11] = new Pair("source_id", r8);
            r7[12] = new Pair("text_len", Integer.valueOf(r14.length()));
            sob.d.e("im_voice_input_click", r6, r7);
        L42:
            ImmersiveVoiceViewModel r13 = this.this$0;
            String r16 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(r13);
            if (r16 != null) goto L45;
        L48:
            boolean r17 = true;
        L49:
            if (r17 == false) goto L51;
            String r18 = this.$content;
        L52:
            ImmersiveVoiceViewModel.access$submitAsrEditReportIfNeed(r13, r18, this.$content, this.$reportItems, SpeechRecognitionReportEditRequest.Scene.BUBBLE, this.$firstStartAsrEditContent);
            return Unit.INSTANCE;
        L51:
            r18 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            goto L52
        L45:
            if (r16.length() == 0) goto L48;
            r17 = false;
            goto L49
        L19:
            if (r12.length() == 0) goto L22;
            r3 = false;
            goto L23
        L15:
            r12 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            goto L16
        L9:
            if (r10.length() == 0) goto L12;
            r11 = false;
            goto L13
        L24:
            sob.d r28 = sob.d.a;
            String r19 = ImmersiveVoiceViewModel.access$getChatId$p(this.this$0);
            String r20 = this.$sourceId;
            sob.a r21 = ImmersiveVoiceViewModel.access$calculateAsrResult(this.this$0, this.$richText);
            String r110 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            if (r110 != null) goto L27;
        L30:
            boolean r111 = true;
        L31:
            if (r111 == false) goto L33;
            String r112 = this.$content;
        L34:
            String r113 = this.$content;
            Map r22 = ImmersiveVoiceViewModel.access$getExtraAnalyticParams$p(this.this$0);
            r28.getClass();
            Intrinsics.checkNotNullParameter(r19, "chatId");
            Intrinsics.checkNotNullParameter(r20, "sourceId");
            Intrinsics.checkNotNullParameter(r21, "asrNerStatistic");
            Intrinsics.checkNotNullParameter(r113, "finalAsrResult");
            Intrinsics.checkNotNullParameter(r22, "extraAnalyticParams");
            JSONArray r23 = sob.d.b(r21);
            float r24 = sob.d.d(r112, r113);
            Pair[] r25 = new Pair[14];
            r25[0] = new Pair("chat_id", r19);
            r25[1] = new Pair("click", "voice_input_send");
            r25[2] = new Pair("location", "im_input_button");
            r25[3] = new Pair("voice_input_send_type", "text_only");
            r25[4] = new Pair("accept_cnt", Integer.valueOf(r21.b.getAcceptCount()));
            r25[5] = new Pair("asr_cnt", Integer.valueOf(r21.b.getAsrCount()));
            r25[6] = new Pair("search_cnt", Integer.valueOf(r21.b.getSearchCount()));
            r25[7] = new Pair("user_info_list", r23);
            r25[8] = new Pair("cer_rate", Float.valueOf(r24));
            if (r112 != null) goto L37;
        L40:
            boolean r26 = true;
        L41:
            r25[9] = new Pair("is_result", Boolean.valueOf(!r26));
            r25[10] = new Pair("is_user_edited", Boolean.valueOf(!StringsKt.equals$default(r112, r113, false, 2, null)));
            int r27 = AudioAsrLanguageSwitcher.i;
            r25[11] = new Pair("user_lng", AudioAsrLanguageSwitcher.a.a());
            r25[12] = new Pair("source_id", r20);
            r25[13] = new Pair("text_len", Integer.valueOf(r113.length()));
            sob.d.e("im_voice_input_click", r22, r25);
            goto L42
        L37:
            if (r112.length() == 0) goto L40;
            r26 = false;
            goto L41
        L33:
            r112 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            goto L34
        L27:
            if (r110.length() == 0) goto L30;
            r111 = false;
            goto L31
        L55:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$safeClearLoading$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$safeClearLoading$1", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ImmersiveVoiceViewModel this$0;

        public C04241(ImmersiveVoiceViewModel r1, Continuation<? super C04241> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04241(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            i r3 = ImmersiveVoiceViewModel.access$get_voiceViewModelDependency$p(this.this$0);
            if (r3 == null) goto L8;
            r3.d();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$sendAudionWithTextMsg$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$sendAudionWithTextMsg$1", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ String $firstStartAsrEditContent;
        final /* synthetic */ List<SpeechRecognitionReportEditItem> $reportItems;
        final /* synthetic */ RichText $richText;
        final /* synthetic */ String $sourceId;
        final /* synthetic */ ArrayList<UserInfoHitPoint> $userInfoList;
        int label;
        final /* synthetic */ ImmersiveVoiceViewModel this$0;

        public C04251(ImmersiveVoiceViewModel r1, String r2, RichText r3, ArrayList<UserInfoHitPoint> r4, String r5, List<SpeechRecognitionReportEditItem> r6, String r7, Continuation<? super C04251> r8) {
            this.this$0 = r1;
            this.$sourceId = r2;
            this.$richText = r3;
            this.$userInfoList = r4;
            this.$content = r5;
            this.$reportItems = r6;
            this.$firstStartAsrEditContent = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C04251(this.this$0, this.$sourceId, this.$richText, this.$userInfoList, this.$content, this.$reportItems, this.$firstStartAsrEditContent, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r38) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L53;
            ResultKt.throwOnFailure(r38);
            if (this.this$0.isVoiceInputMarkdownFg() == false) goto L24;
            sob.d r1 = sob.d.a;
            String r8 = ImmersiveVoiceViewModel.access$getChatId$p(this.this$0);
            String r11 = this.$sourceId;
            AsrNerStatisticV2 r4 = ImmersiveVoiceViewModel.access$calculateAsrResultV2(this.this$0, this.$richText, this.$userInfoList);
            String r10 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            if (r10 != null) goto L9;
        L12:
            boolean r12 = true;
        L13:
            if (r12 == false) goto L15;
            String r13 = this.$content;
        L16:
            String r14 = this.$content;
            Map r6 = ImmersiveVoiceViewModel.access$getExtraAnalyticParams$p(this.this$0);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r8, "chatId");
            Intrinsics.checkNotNullParameter(r11, "sourceId");
            Intrinsics.checkNotNullParameter(r4, "asrNerStatistic");
            Intrinsics.checkNotNullParameter(r14, "finalAsrResult");
            Intrinsics.checkNotNullParameter(r6, "extraAnalyticParams");
            JSONArray r2 = sob.d.c(r4);
            float r5 = sob.d.d(r13, r14);
            Pair[] r7 = new Pair[13];
            r7[0] = new Pair("chat_id", r8);
            r7[1] = new Pair("click", "voice_input_send");
            r7[2] = new Pair("location", "im_input_button");
            r7[3] = new Pair("voice_input_send_type", "voice_and_text_send");
            r7[4] = new Pair("accept_cnt", Integer.valueOf(r4.getAdoptionRate().getAcceptCount()));
            r7[5] = new Pair("sdk_result_cnt", Integer.valueOf(r4.getAdoptionRate().getAsrCount()));
            r7[6] = new Pair("user_info_list", r2);
            r7[7] = new Pair("cer_rate", Float.valueOf(r5));
            if (r13 != null) goto L19;
        L22:
            boolean r3 = true;
        L23:
            r7[8] = new Pair("is_result", Boolean.valueOf(!r3));
            r7[9] = new Pair("is_user_edited", Boolean.valueOf(!StringsKt.equals$default(r13, r14, false, 2, null)));
            int r9 = AudioAsrLanguageSwitcher.i;
            r7[10] = new Pair("user_lng", AudioAsrLanguageSwitcher.a.a());
            r7[11] = new Pair("source_id", r11);
            r7[12] = new Pair("text_len", Integer.valueOf(r14.length()));
            sob.d.e("im_voice_input_click", r6, r7);
            boolean r15 = false;
        L42:
            ImmersiveVoiceViewModel r16 = this.this$0;
            String r17 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(r16);
            if (r17 != null) goto L45;
        L46:
            r15 = true;
        L47:
            if (r15 == false) goto L49;
            String r18 = this.$content;
        L50:
            ImmersiveVoiceViewModel.access$submitAsrEditReportIfNeed(r16, r18, this.$content, this.$reportItems, SpeechRecognitionReportEditRequest.Scene.BUBBLE, this.$firstStartAsrEditContent);
            return Unit.INSTANCE;
        L49:
            r18 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            goto L50
        L45:
            if (r17.length() != 0) goto L47;
        L19:
            if (r13.length() == 0) goto L22;
            r3 = false;
            goto L23
        L15:
            r13 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            goto L16
        L9:
            if (r10.length() == 0) goto L12;
            r12 = false;
            goto L13
        L24:
            sob.d r28 = sob.d.a;
            String r19 = ImmersiveVoiceViewModel.access$getChatId$p(this.this$0);
            String r20 = this.$sourceId;
            sob.a r21 = ImmersiveVoiceViewModel.access$calculateAsrResult(this.this$0, this.$richText);
            String r110 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            if (r110 != null) goto L27;
        L30:
            boolean r111 = true;
        L31:
            if (r111 == false) goto L33;
            String r112 = this.$content;
        L34:
            String r113 = this.$content;
            Map r22 = ImmersiveVoiceViewModel.access$getExtraAnalyticParams$p(this.this$0);
            r28.getClass();
            Intrinsics.checkNotNullParameter(r19, "chatId");
            Intrinsics.checkNotNullParameter(r20, "sourceId");
            Intrinsics.checkNotNullParameter(r21, "asrNerStatistic");
            Intrinsics.checkNotNullParameter(r113, "finalAsrResult");
            Intrinsics.checkNotNullParameter(r22, "extraAnalyticParams");
            JSONArray r23 = sob.d.b(r21);
            float r24 = sob.d.d(r112, r113);
            Pair[] r25 = new Pair[14];
            r25[0] = new Pair("chat_id", r19);
            r25[1] = new Pair("click", "voice_input_send");
            r25[2] = new Pair("location", "im_input_button");
            r25[3] = new Pair("voice_input_send_type", "voice_and_text_send");
            r25[4] = new Pair("accept_cnt", Integer.valueOf(r21.b.getAcceptCount()));
            r25[5] = new Pair("asr_cnt", Integer.valueOf(r21.b.getAsrCount()));
            r25[6] = new Pair("search_cnt", Integer.valueOf(r21.b.getSearchCount()));
            r25[7] = new Pair("user_info_list", r23);
            r25[8] = new Pair("cer_rate", Float.valueOf(r24));
            if (r112 != null) goto L37;
        L40:
            boolean r26 = true;
        L41:
            r25[9] = new Pair("is_result", Boolean.valueOf(!r26));
            r15 = false;
            r25[10] = new Pair("is_user_edited", Boolean.valueOf(!StringsKt.equals$default(r112, r113, false, 2, null)));
            int r27 = AudioAsrLanguageSwitcher.i;
            r25[11] = new Pair("user_lng", AudioAsrLanguageSwitcher.a.a());
            r25[12] = new Pair("source_id", r20);
            r25[13] = new Pair("text_len", Integer.valueOf(r113.length()));
            sob.d.e("im_voice_input_click", r22, r25);
            goto L42
        L37:
            if (r112.length() == 0) goto L40;
            r26 = false;
            goto L41
        L33:
            r112 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            goto L34
        L27:
            if (r110.length() == 0) goto L30;
            r111 = false;
            goto L31
        L53:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$startVoiceRecord$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$startVoiceRecord$1", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {1114, 1115}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ImmersiveVoiceViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$startVoiceRecord$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$startVoiceRecord$1$1", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ImmersiveVoiceViewModel this$0;

            public C01621(ImmersiveVoiceViewModel r1, Continuation<? super C01621> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C01621(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L12;
                ResultKt.throwOnFailure(r2);
                MutableLiveData r3 = ImmersiveVoiceViewModel.access$get_isRecordHardwareReady$p(this.this$0);
                Intrinsics.checkNotNullParameter(r3, "<this>");
                if (Intrinsics.areEqual(r3.getValue(), Boolean.FALSE) == false) goto L10;
                if (ImmersiveVoiceViewModel.access$get_isCancelingSession$p(this.this$0) == true) goto L10;
                this.this$0.updateVoiceStateIfNeed(new n());
            L10:
                return Unit.INSTANCE;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C04261(ImmersiveVoiceViewModel r1, Continuation<? super C04261> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04261(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r6);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
        L13:
            MainCoroutineDispatcher r7 = Dispatchers.getMain();
            C01621 r2 = new C01621(this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r7, r2, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(200, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$submitFeedback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$submitFeedback$1", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $clientResult;
        final /* synthetic */ List<String> $descriptionList;
        final /* synthetic */ String $inputDesc;
        final /* synthetic */ Function1<ErrorResult, Unit> $onError;
        final /* synthetic */ Function0<Unit> $onSuccess;
        int label;
        final /* synthetic */ ImmersiveVoiceViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$submitFeedback$1$a */
        public static final class a<T> implements SdkSender.IParser {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object parse(byte[] r2) {
                Intrinsics.checkNotNullParameter(r2, "data");
                return (SpeechRecognitionFeedbackResponse) SpeechRecognitionFeedbackResponse.ADAPTER.decode(r2);
            }
        }

        public C04281(ImmersiveVoiceViewModel r1, List<String> r2, String r3, String r4, Function0<Unit> r5, Function1<? super ErrorResult, Unit> r6, Continuation<? super C04281> r7) {
            this.this$0 = r1;
            this.$descriptionList = r2;
            this.$inputDesc = r3;
            this.$clientResult = r4;
            this.$onSuccess = r5;
            this.$onError = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new C04281(this.this$0, this.$descriptionList, this.$inputDesc, this.$clientResult, this.$onSuccess, this.$onError, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L33;
            ResultKt.throwOnFailure(r7);
            SpeechRecognitionFeedbackRequest.Builder r8 = new SpeechRecognitionFeedbackRequest.Builder();
            if (KeyboardVoiceFGUtils.a.f() == false) goto L14;
            ArrayList r0 = new ArrayList();
            Iterator<T> r2 = ImmersiveVoiceViewModel.access$get_voiceInputDelegate$p(this.this$0).b.iterator();
        L8:
            if (r2.hasNext() == false) goto L12;
            q r3 = (q) r2.next();
            com.ss.android.lark.audio.voiceinput.utils.a r4 = r3.b;
            if (r4 == null) goto L8;
            r0.add(new SpeechRecognitionFeedbackItem.Builder().origin_audio_data(r4.b()).source_id(r3.c).origin_audio_type("pcm").build());
            goto L8
        L12:
            r8.items(r0);
        L30:
            r8.button_desc(this.$descriptionList).desc(this.$inputDesc).client_result(this.$clientResult);
            Command r1 = Command.SPEECH_RECOGNITION_FEEDBACK;
            final ImmersiveVoiceViewModel r5 = this.this$0;
            final Function0<Unit> r6 = this.$onSuccess;
            final Function1<ErrorResult, Unit> r9 = this.$onError;
            SdkSender.sendPassThroughRequest(r1, r8, new AnonymousClass2(r5, r6, r9), a.a);
            return Unit.INSTANCE;
        L14:
            if (this.this$0.isEnableVoiceInputSdk() == false) goto L16;
            String r10 = ImmersiveVoiceViewModel.access$get_voiceInputDelegate$p(this.this$0).d();
        L22:
            if (this.this$0.isEnableVoiceInputSdk() == false) goto L28;
            VoiceInputService r11 = ImmersiveVoiceViewModel.access$get_voiceInputDelegate$p(this.this$0).a;
            if (r11 == null) goto L27;
            ByteString r12 = r11.d.b();
            if (r12 == null) goto L27;
        L29:
            Log.i(ImmersiveVoiceViewModel.TAG, "[submitFeedback] sourceId:" + r10 + ", pcmBuffer size is " + r12.size());
            r8.source_id(r10).origin_audio_data(r12).origin_audio_type("pcm");
        L27:
            r12 = ByteString.EMPTY;
            goto L29
        L28:
            r12 = ImmersiveVoiceViewModel.access$getCollectedPcmBuffer$p(this.this$0).b();
            goto L29
        L16:
            com.ss.android.lark.keyboard.plugin.tool.voice.c r13 = ImmersiveVoiceViewModel.access$get_audioMessageDelegate$p(this.this$0);
            if (r13 == null) goto L20;
            r10 = r13.a();
            if (r10 != null) goto L22;
        L20:
            r10 = "";
            goto L22
        L33:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$whenClickCancel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$whenClickCancel$1", f = "ImmersiveVoiceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ RichText $richText;
        final /* synthetic */ ArrayList<UserInfoHitPoint> $userInfoList;
        final /* synthetic */ String $voiceSourceId;
        int label;
        final /* synthetic */ ImmersiveVoiceViewModel this$0;

        public C04291(ImmersiveVoiceViewModel r1, String r2, RichText r3, ArrayList<UserInfoHitPoint> r4, String r5, Continuation<? super C04291> r6) {
            this.this$0 = r1;
            this.$voiceSourceId = r2;
            this.$richText = r3;
            this.$userInfoList = r4;
            this.$content = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C04291(this.this$0, this.$voiceSourceId, this.$richText, this.$userInfoList, this.$content, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r30) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L45;
            ResultKt.throwOnFailure(r30);
            if (this.this$0.isVoiceInputMarkdownFg() == false) goto L24;
            sob.d r1 = sob.d.a;
            String r9 = ImmersiveVoiceViewModel.access$getChatId$p(this.this$0);
            String r8 = this.$voiceSourceId;
            AsrNerStatisticV2 r10 = ImmersiveVoiceViewModel.access$calculateAsrResultV2(this.this$0, this.$richText, this.$userInfoList);
            String r11 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            if (r11 != null) goto L9;
        L12:
            boolean r12 = true;
        L13:
            if (r12 == false) goto L15;
            String r13 = this.$content;
        L16:
            String r14 = this.$content;
            String r27 = r13;
            Map r15 = ImmersiveVoiceViewModel.access$getExtraAnalyticParams$p(this.this$0);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r9, "chatId");
            Intrinsics.checkNotNullParameter(r8, "sourceId");
            Intrinsics.checkNotNullParameter(r10, "asrNerStatistic");
            Intrinsics.checkNotNullParameter(r14, "finalAsrResult");
            Intrinsics.checkNotNullParameter(r15, "extraAnalyticParams");
            JSONArray r2 = sob.d.c(r10);
            Pair[] r3 = new Pair[11];
            r3[0] = new Pair("chat_id", r9);
            r3[1] = new Pair("click", "click_cancel_trans_text");
            r3[2] = new Pair("location", "im_input_button");
            r3[3] = new Pair("accept_cnt", 0);
            r3[4] = new Pair("sdk_result_cnt", Integer.valueOf(r10.getAdoptionRate().getAsrCount()));
            r3[5] = new Pair("user_info_list", r2);
            if (r27 != null) goto L19;
        L22:
            boolean r4 = true;
        L23:
            r3[6] = new Pair("is_result", Boolean.valueOf(!r4));
            r3[7] = new Pair("is_user_edited", Boolean.valueOf(!StringsKt.equals$default(r27, r14, false, 2, null)));
            int r5 = AudioAsrLanguageSwitcher.i;
            r3[8] = new Pair("user_lng", AudioAsrLanguageSwitcher.a.a());
            r3[9] = new Pair("source_id", r8);
            r3[10] = new Pair("text_len", Integer.valueOf(r14.length()));
            sob.d.e("im_voice_input_click", r15, r3);
        L43:
            return Unit.INSTANCE;
        L19:
            if (r27.length() == 0) goto L22;
            r4 = false;
            goto L23
        L15:
            r13 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            goto L16
        L9:
            if (r11.length() == 0) goto L12;
            r12 = false;
            goto L13
        L24:
            sob.d r21 = sob.d.a;
            String r16 = ImmersiveVoiceViewModel.access$getChatId$p(this.this$0);
            String r6 = this.$voiceSourceId;
            sob.a r17 = ImmersiveVoiceViewModel.access$calculateAsrResult(this.this$0, this.$richText);
            String r18 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            if (r18 != null) goto L27;
        L30:
            boolean r19 = true;
        L31:
            if (r19 == false) goto L33;
            String r110 = this.$content;
        L34:
            String r26 = r110;
            String r111 = this.$content;
            Map r112 = ImmersiveVoiceViewModel.access$getExtraAnalyticParams$p(this.this$0);
            r21.getClass();
            Intrinsics.checkNotNullParameter(r16, "chatId");
            Intrinsics.checkNotNullParameter(r6, "sourceId");
            Intrinsics.checkNotNullParameter(r17, "asrNerStatistic");
            Intrinsics.checkNotNullParameter(r111, "finalAsrResult");
            Intrinsics.checkNotNullParameter(r112, "extraAnalyticParams");
            Triple r7 = new Triple(0, Integer.valueOf(r17.b.getAsrCount()), Integer.valueOf(r17.b.getSearchCount()));
            JSONArray r20 = sob.d.b(r17);
            Pair[] r22 = new Pair[12];
            r22[0] = new Pair("chat_id", r16);
            r22[1] = new Pair("click", "click_cancel_trans_text");
            r22[2] = new Pair("location", "im_input_button");
            r22[3] = new Pair("accept_cnt", r7.getFirst());
            r22[4] = new Pair("asr_cnt", r7.getSecond());
            r22[5] = new Pair("search_cnt", r7.getThird());
            r22[6] = new Pair("user_info_list", r20);
            if (r26 != null) goto L37;
        L40:
            boolean r23 = true;
        L41:
            r22[7] = new Pair("is_result", Boolean.valueOf(!r23));
            r22[8] = new Pair("is_user_edited", Boolean.valueOf(!StringsKt.equals$default(r26, r111, false, 2, null)));
            int r24 = AudioAsrLanguageSwitcher.i;
            r22[9] = new Pair("user_lng", AudioAsrLanguageSwitcher.a.a());
            r22[10] = new Pair("source_id", r6);
            r22[11] = new Pair("text_len", Integer.valueOf(r111.length()));
            sob.d.e("im_voice_input_click", r112, r22);
            goto L43
        L37:
            if (r26.length() == 0) goto L40;
            r23 = false;
            goto L41
        L33:
            r110 = ImmersiveVoiceViewModel.access$get_beforeEditAsrResult$p(this.this$0);
            goto L34
        L27:
            if (r18.length() == 0) goto L30;
            r19 = false;
            goto L31
        L45:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public final void removeKeyboardController() {
        this._keyboardController = null;
    }

    public final void whenReleaseOrCancelTouch() {
        this._isCancelingSession = true;
        sob.c.e(this._isRecordHardwareReady, Boolean.FALSE);
        l r1 = (l) this._immersiveVoiceState.getValue();
        if (r1 == null) goto L46;
        int r2 = r1.getState();
        if (r2 == 0) goto L44;
        if (r2 != 1) goto L8;
        dismissPopupWindow();
        cancelVoiceRecord();
        return;
    L8:
        if (r2 == 2) goto L22;
        if (r2 != 3) goto L12;
        updateVoiceStateIfNeed(new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.b());
        stopVoiceRecord();
        if (this._voiceInputMode.a == VoiceInputMode.VoiceAndAsr) goto L18;
        return;
    L18:
        if (this.isEnableVoiceInputSdk == false) goto L20;
        this._voiceInputDelegate.i.c(true);
        return;
    L20:
        this._asrPreemptiveOptimize.c(true);
        return;
    L12:
        if (r2 != 4) goto L53;
        dismissPopupWindow();
        cancelVoiceRecord();
        this._immersivePerformance.a();
        VoiceInputAppreciablePerformance.f(false);
        VoiceInputAppreciablePerformance.e(false, isAsrResultEmpty(), CancelAsrTimeoutState.CancelByClickCancel.info());
        return;
    L53:
        return;
    L22:
        if (this.isAsrEnable == true) goto L24;
    L42:
        dismissPopupWindow();
        stopVoiceRecord();
        return;
    L24:
        if (this.isEnableVoiceInputSdk == false) goto L33;
        VoiceInputService r0 = this._voiceInputDelegate.a;
        if (r0 == null) goto L37;
        VoiceDataProcessDispatcher r3 = r0.c;
        if (r3 == null) goto L30;
        r3.a(ProcessType.OnlyVoice);
    L30:
        com.ss.android.lark.audio.voiceinput.d r4 = r0.b;
        if (r4 == null) goto L37;
        r4.i = false;
    L37:
        if (this._voiceInputMode.a != VoiceInputMode.VoiceAndAsr) goto L42;
        if (this.isEnableVoiceInputSdk == false) goto L41;
        this._voiceInputDelegate.i.c(false);
        goto L42
    L41:
        this._asrPreemptiveOptimize.c(false);
        goto L42
    L33:
        AudioRecordCoordinator r5 = this._audioRecordCoordinator;
        if (r5 == null) goto L37;
        r5.d.i = false;
        goto L37
    L44:
        dismissPopupWindow();
        cancelVoiceRecord();
        return;
    }

    private final void cancelAsrWaitingTips() {
        Job r0 = this.asrWaitingTipsChecker;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.asrWaitingTipsChecker = null;
    }

    private final void delayTriggerAsrWaitingTips() {
        long r0 = ((Number) AudioPluginConstants.e.getValue()).longValue();
        if (r0 > 0) goto L5;
        return;
    L5:
        if (r0 >= AudioPluginConstants.a()) goto L13;
        sob.c.e(this._shouldShowAsrWaitingPoorNetTips, Boolean.FALSE);
        Job r2 = this.asrWaitingTipsChecker;
        if (r2 == null) goto L10;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L10:
        this.asrWaitingTipsChecker = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04161(r0, this, null), 2, null);
        return;
    }

    private final boolean isAsrResultEmpty() {
        if (this.isAsrNerEnable == false) goto L9;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c r0 = (com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c) this.asrResultRichText.getValue();
        if (r0 == null) goto L7;
        RichText r1 = r0.a;
    L17:
        return com.ss.android.lark.widget.richtext.i.l(r1);
    L7:
        r1 = null;
        goto L17
    L9:
        CharSequence r2 = (CharSequence) getAudioAsrResult().getValue();
        if (r2 != null) goto L12;
    L15:
        return true;
    L12:
        if (r2.length() == 0) goto L15;
        return false;
    }

    private final boolean needSendVoice() {
        l r0 = (l) this._immersiveVoiceState.getValue();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L19;
        l r2 = (l) this._immersiveVoiceState.getValue();
        if (r2 == null) goto L17;
        l r3 = r2.c();
        if (r3 == null) goto L17;
        if (r3.getState() != 2) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L19;
        return true;
    L17:
        r4 = false;
    L19:
        l r5 = (l) this._immersiveVoiceState.getValue();
        if (r5 != null) goto L22;
    L24:
        boolean r6 = false;
    L25:
        if (r6 == true) goto L30;
        return false;
    L30:
        return true;
    L22:
        if (r5.getState() != 2) goto L24;
        r6 = true;
        goto L25
    L5:
        if (r0.getState() != 0) goto L7;
        r1 = true;
        goto L9
    }

    private final ArrayList<UserInfoHitPoint> packAsrUserInfoList() {
        ArrayList<UserInfoHitPoint> r0 = new ArrayList();
        if (this.isVoiceInputMarkdownFg == false) goto L20;
        Iterator<T> r1 = this._voiceInputDelegate.b.iterator();
    L6:
        if (r1.hasNext() == false) goto L20;
        com.ss.android.lark.audio.voiceinput.c r2 = ((q) r1.next()).d;
        if (r2 == null) goto L6;
        List r3 = r2.g;
        if (r3 == null) goto L6;
        Iterator r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L6;
        com.ss.android.lark.audio.voiceinput.a r5 = (com.ss.android.lark.audio.voiceinput.a) r4.next();
        String r6 = r5.g;
        if (r6 == null) goto L13;
        Boolean r7 = r5.h;
        if (r7 == null) goto L13;
        r0.add(new UserInfoHitPoint(r6, r7.booleanValue()));
    L20:
        return r0;
    }

    private final void registerListener() {
        Log.i(TAG, "registerListener");
        KeyboardVoiceModule.a().getVcDependency().b();
        com.ss.android.lark.audio.voiceinput.service.o r0 = this._speechRecognitionStatusPush;
        if (r0 == null) goto L6;
        r0.M3(this._speechRecognitionEventPushListener);
        return;
    }

    private final void stopAsrResultWhenRecordTimeTooShort() {
        AsrSessionState r0 = (AsrSessionState) this._asrSessionState.getValue();
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.isAsrSessionRunning() != true) goto L7;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        Log.i(TAG, "stopAsrResultWhenRecordTimeTooShort");
        sob.c.e(this._asrNeedRetry, Boolean.FALSE);
        sob.c.e(this._asrSessionState, AsrSessionState.AsrSessionEndNoText);
        forceAsrSessionFinish(CancelAsrTimeoutState.CancelByClickCancel, false);
        if (isSecondVoiceInput() == true) goto L14;
        updateVoiceStateIfNeed(new j());
        return;
    L14:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final void afterPopUpTransitionEnd() {
        sob.c.e(this._isPopUpTransitionEnd, Boolean.TRUE);
    }

    public void cancelVoiceRecord() {
        if (this.isEnableVoiceInputSdk == false) goto L10;
        VoiceInputService r0 = this._voiceInputDelegate.a;
        if (r0 == null) goto L9;
        com.ss.android.lark.audio.voiceinput.d r1 = r0.b;
        if (r1 == null) goto L9;
        r0.a.e.a();
        r1.w.a();
    L9:
        KeyboardVoiceModule.a().getVcDependency().a();
        return;
    L10:
        com.ss.android.lark.audio.voiceinput.g r2 = this._audioRecordDelegate;
        if (r2 == null) goto L16;
        com.ss.android.lark.audio.voiceinput.h r3 = this._audioResourceMutex;
        if (r3 == null) goto L15;
        r3.a();
    L15:
        r2.a();
    L16:
        com.ss.android.lark.keyboard.plugin.tool.voice.c r4 = this._audioMessageDelegate;
        if (r4 == null) goto L21;
        r4.e();
        return;
    }

    public final boolean consumeKeepSessionOnPopupHide$keyboard_biz_voice_release() {
        boolean r0 = this.keepSessionOnNextPopupHide;
        this.keepSessionOnNextPopupHide = false;
        return r0;
    }

    public final void destroy() {
        if (this.isEnableVoiceInputSdk == false) goto L5;
        this._voiceInputDelegate.c();
    L9:
        UserSearchAndMatchStrategy r0 = this._asrUserInfoMathStrategy;
        if (r0 == null) goto L12;
        r0.c();
    L12:
        this.onlyAsrRecognizingTipsProvider = null;
        return;
    L5:
        AudioRecordCoordinator r1 = this._audioRecordCoordinator;
        if (r1 == null) goto L8;
        com.ss.android.lark.audio.voiceinput.d r2 = r1.d;
        r2.h.a();
        r2.a.onDestroy();
    L8:
        unregisterListener();
        goto L9
    }

    public final void dismissPopupWindow() {
        sob.c.e(this._popupWindowVisible, Boolean.FALSE);
        if (KeyboardVoiceFGUtils.d() == false) goto L8;
        h r0 = this._keyboardController;
        if (r0 == null) goto L8;
        r0.hideKeyboard();
    L8:
        if (this.isEnableVoiceInputSdk == true) goto L10;
        unregisterListener();
        this.collectedPcmBuffer.c();
        return;
    L10:
        if (KeyboardVoiceFGUtils.a.f() == false) goto L16;
        q r1 = (q) CollectionsKt.firstOrNull(this._voiceInputDelegate.b);
        if (r1 == null) goto L14;
        com.ss.android.lark.audio.voiceinput.s r2 = r1.a;
    L15:
        this._voiceRecordEntity = r2;
        this._voiceInputDelegate.b(true);
        sob.c.e(this.beforeInsetSelection, new Pair(0, 0));
        goto L16
    L14:
        r2 = null;
    L16:
        VoiceInputService r3 = this._voiceInputDelegate.a;
        if (r3 == null) goto L19;
        r3.g();
        r3.d.c();
    L19:
        KeyboardVoiceModule.a().getVcDependency().a();
    }

    public final void finishReplyMode() {
        r r0 = this._inputStateController;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final String getSourceId() {
        if (this.isEnableVoiceInputSdk == true) goto L10;
        com.ss.android.lark.keyboard.plugin.tool.voice.c r0 = this._audioMessageDelegate;
        if (r0 != null) goto L11;
        return null;
    L11:
        return r0.a();
    L10:
        return this._voiceInputDelegate.d();
    }

    public final boolean isAsrSessionRunning() {
        StringBuilder r0 = new StringBuilder("isAsrSessionRunning:state:");
        AsrSessionState r1 = (AsrSessionState) this._asrSessionState.getValue();
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getState());
    L6:
        r0.append(r2);
        Log.i(TAG, r0.toString());
        AsrSessionState r3 = (AsrSessionState) this._asrSessionState.getValue();
        if (r3 != null) goto L9;
        return false;
    L9:
        if (r3.isAsrSessionRunning() != true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean isBackgroundAsrKeepSessionMode() {
        if (this.hidePopupOnReleaseKeepSession == true) goto L5;
    L9:
        return false;
    L5:
        if (getImmersiveVoiceMode().b() == false) goto L9;
        if (this.autoSendOnRecognizeFinish == false) goto L9;
        return true;
    }

    public final boolean isNeedInit() {
        if (this.isEnableVoiceInputSdk == false) goto L8;
        if (this._voiceInputDelegate.a == null) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (this._audioRecordCoordinator != null) goto L10;
        return true;
    }

    public final boolean isSecondVoiceInput() {
        if (this._voiceInputDelegate.d.get() > 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isSessionRunning() {
        StringBuilder r0 = new StringBuilder("isSessionRunning:");
        l r1 = (l) this._immersiveVoiceState.getValue();
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.getState());
    L6:
        r0.append(r2);
        Log.i(TAG, r0.toString());
        l r3 = (l) this._immersiveVoiceState.getValue();
        boolean r4 = false;
        if (r3 == null) goto L12;
        if (r3.getState() != 0) goto L12;
        r4 = true;
    L12:
        return !r4;
    L5:
        r2 = null;
        goto L6
    }

    public final void markUserEditedAfterAsr() {
        if (this._userEditedAfterAsr == false) goto L5;
        return;
    L5:
        this._userEditedAfterAsr = true;
        MutableLiveData<Boolean> r0 = this._showOriginalButtonVisible;
        Boolean r1 = Boolean.FALSE;
        sob.c.e(r0, r1);
        sob.c.e(this._asrNeedRetry, r1);
    }

    public final void onShowOriginal() {
        if (this._userEditedAfterAsr == false) goto L5;
        return;
    L5:
        com.ss.android.lark.audio.voiceinput.c r0 = this._lastFinishedAsrResult;
        if (r0 != null) goto L9;
        Log.w(TAG, "[voice-input-polish] onShowOriginal: no cached result, ignore");
        return;
    L9:
        this._userClickedShowOriginal = true;
        q r2 = (q) CollectionsKt.lastOrNull(this._voiceInputDelegate.b);
        if (r2 == null) goto L12;
        r2.e = true;
    L12:
        sob.c.e(this._showOriginalButtonVisible, Boolean.FALSE);
        renderOriginRichText(r0);
    }

    public final void requestHidePopupKeepSession() {
        if (Intrinsics.areEqual(this._popupWindowVisible.getValue(), Boolean.TRUE) == true) goto L6;
        this.keepSessionOnNextPopupHide = false;
        return;
    L6:
        l r0 = (l) this._immersiveVoiceState.getValue();
        if (r0 != null) goto L9;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L15;
        this.keepSessionOnNextPopupHide = false;
        return;
    L15:
        this.keepSessionOnNextPopupHide = true;
        sob.c.e(this._popupWindowVisible, Boolean.FALSE);
        return;
    L9:
        if (r0.getState() != 4) goto L11;
        r1 = true;
        goto L12
    }

    public final void rollbackToOldAudio() {
        sob.c.e(this._rollbackToOldAudio, Boolean.TRUE);
        if (this.isEnableVoiceInputSdk == false) goto L8;
        VoiceInputDelegate r0 = this._voiceInputDelegate;
        int r1 = VoiceInputDelegate.p;
        r0.b(true);
        VoiceInputService r2 = this._voiceInputDelegate.a;
        if (r2 == null) goto L7;
        r2.g();
        r2.d.c();
    L7:
        KeyboardVoiceModule.a().getVcDependency().a();
        return;
    L8:
        unregisterListener();
        this.collectedPcmBuffer.c();
    }

    public final void showEditableTipsIfNeed() {
        sob.c.e(this._isShowTipsResultCanEditable, Boolean.valueOf(t.b().getBoolean(KV_STORAGE_SHOW_EDITABLE_TIPS, true)));
    }

    public void stopVoiceRecord() {
        if (this.isEnableVoiceInputSdk == false) goto L10;
        VoiceInputService r0 = this._voiceInputDelegate.a;
        if (r0 == null) goto L9;
        com.ss.android.lark.audio.voiceinput.d r1 = r0.b;
        if (r1 == null) goto L9;
        r0.a.e.a();
        r1.w.stopRecord();
    L9:
        KeyboardVoiceModule.a().getVcDependency().a();
        return;
    L10:
        com.ss.android.lark.audio.voiceinput.g r2 = this._audioRecordDelegate;
        if (r2 == null) goto L18;
        com.ss.android.lark.audio.voiceinput.h r3 = this._audioResourceMutex;
        if (r3 == null) goto L15;
        r3.a();
    L15:
        r2.stopRecord();
        return;
    }

    public final void switch2VoiceAsr() {
        if (this.isEnableVoiceInputSdk == false) goto L12;
        VoiceInputService r0 = this._voiceInputDelegate.a;
        if (r0 == null) goto L16;
        VoiceDataProcessDispatcher r2 = r0.c;
        if (r2 == null) goto L9;
        r2.a(ProcessType.VoiceWithAsr);
    L9:
        com.ss.android.lark.audio.voiceinput.d r1 = r0.b;
        if (r1 == null) goto L17;
        r1.i = true;
        return;
    L17:
        return;
    L16:
        return;
    L12:
        AudioRecordCoordinator r3 = this._audioRecordCoordinator;
        if (r3 == null) goto L19;
        r3.d.i = true;
        return;
    }

    public final void switch2VoiceRecordIfNeed() {
        boolean r2 = true;
        if (this.isEnableVoiceInputSdk == false) goto L27;
        VoiceInputDelegate r0 = this._voiceInputDelegate;
        VoiceInputService r3 = r0.a;
        if (r3 != null) goto L7;
        return;
    L7:
        if (r0.i.b() == true) goto L43;
        VoiceDataProcessDispatcher r1 = r3.c;
        if (r1 == null) goto L18;
        Map r4 = r1.a;
        LinkedHashMap r5 = (LinkedHashMap) r4;
        com.ss.android.lark.audio.voiceinput.processor.d r6 = (com.ss.android.lark.audio.voiceinput.processor.d) r5.get(r1.b);
        if (r6 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 != true) goto L18;
    L19:
        if (r2 == true) goto L44;
        VoiceDataProcessDispatcher r8 = r3.c;
        if (r8 == null) goto L23;
        r8.a(ProcessType.OnlyVoice);
    L23:
        com.ss.android.lark.audio.voiceinput.d r9 = r3.b;
        if (r9 == null) goto L45;
        r9.i = false;
        return;
    L45:
        return;
    L44:
        return;
    L13:
        if (r6.c() != true) goto L15;
        r7 = true;
    L18:
        r2 = false;
        goto L19
    L43:
        return;
    L27:
        if (this._asrPreemptiveOptimize.b() == true) goto L47;
        String r10 = getSourceId();
        if (r10 != null) goto L31;
    L36:
        r2 = false;
    L37:
        if (r2 == false) goto L48;
        AudioRecordCoordinator r11 = this._audioRecordCoordinator;
        if (r11 == null) goto L49;
        r11.d.i = false;
        return;
    L49:
        return;
    L48:
        return;
    L31:
        if (r10.length() != 0) goto L33;
        boolean r12 = true;
    L34:
        if (r12 != true) goto L36;
    L33:
        r12 = false;
        goto L34
    }

    public final void triggerStartMention() {
        sob.c.e(this.startMention, this.chatId);
    }

    public final void unregisterListener() {
        Log.i(TAG, "unregisterListener");
        KeyboardVoiceModule.a().getVcDependency().a();
        com.ss.android.lark.audio.voiceinput.service.o r0 = this._speechRecognitionStatusPush;
        if (r0 == null) goto L6;
        r0.x4(this._speechRecognitionEventPushListener);
        return;
    }

    public final void whenClickFeedbackEntrance() {
        sob.d r0 = sob.d.a;
        String r1 = this.chatId;
        String r2 = this.currentRecordSourceId;
        Map<String, String> r3 = this.extraAnalyticParams;
        r0.getClass();
        sob.d.g(r1, r2, "feedback", r3);
    }

    public final void whenClickLanguageSwitcher() {
        sob.d r0 = sob.d.a;
        String r1 = this.chatId;
        String r2 = this.currentRecordSourceId;
        Map<String, String> r3 = this.extraAnalyticParams;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "chatId");
        Intrinsics.checkNotNullParameter(r2, "sourceId");
        Intrinsics.checkNotNullParameter(r3, "extraAnalyticParams");
        sob.d.e("im_voice_input_click", r3, new Pair[]{new Pair("chat_id", r1), new Pair("source_id", r2), new Pair("click", "click_to_select_lng"), new Pair("location", "im_input_button")});
    }

    public final void whenSwitch2Recognizing() {
        Function0<Unit> r0 = this._asrFirstPiecePendingBlock;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this._audioAsrResult.getValue() == null) goto L15;
        CharSequence r1 = (CharSequence) this._audioAsrResult.getValue();
        boolean r2 = false;
        if (r1 != null) goto L9;
    L14:
        if (r2 == true) goto L15;
    L16:
        this._asrFirstPiecePendingBlock = null;
        return;
    L9:
        if (r1.length() != 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 != true) goto L14;
        r2 = true;
        goto L14
    L11:
        r3 = false;
    L15:
        r0.invoke();
        goto L16
    }

    public final void whenVoiceInputStart() {
        sob.d r0 = sob.d.a;
        String r1 = this.chatId;
        String r2 = this.currentRecordSourceId;
        Map<String, String> r3 = this.extraAnalyticParams;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "chatId");
        Intrinsics.checkNotNullParameter(r2, "sourceId");
        Intrinsics.checkNotNullParameter(r3, "extraAnalyticParams");
        sob.d.e("im_voice_input_click", r3, new Pair[]{new Pair("chat_id", r1), new Pair("source_id", r2), new Pair("click", "voice_input_start"), new Pair("location", "im_input_button")});
    }

    /* JADX WARN: Type inference failed for: r0v44, types: [com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel$_voiceDataAsrListener$1] */
    public ImmersiveVoiceViewModel() {
        this.beforeInsetSelection = new MutableLiveData(new Pair(0, 0));
        this.beforeInsertSelectionV2 = new MutableLiveData(new Pair(0, 0));
        this.insertPeriod = new MutableLiveData("");
        this.insertPeriodRichText = new MutableLiveData(new RichText());
        this._immersiveVoiceState = new MutableLiveData(new j());
        this._popupWindowVisible = new MutableLiveData();
        this._rollbackToOldAudio = new MutableLiveData();
        this._isShowTipsResultCanEditable = new MutableLiveData();
        this._elapseCountDown = new MutableLiveData();
        this._voiceDuration = new MutableLiveData();
        this._voiceRecordTooShort = new MutableLiveData();
        this._isAsrRecognizeFinish = new MutableLiveData();
        this._shouldShowAsrWaitingPoorNetTips = new MutableLiveData();
        this._shouldShowPoorNetTips = new MutableLiveData();
        this._asrNeedRetry = new MutableLiveData();
        this._recordingOccurException = new MutableLiveData();
        this._asrResultFocused = new MutableLiveData();
        this._smartPeriodOptimizer = new com.ss.android.lark.audio.voiceinput.k();
        this._asrSessionStateChecker = new AsrSessionStateChecker();
        this._voiceInputMode = new p(VoiceInputMode.VoiceAndAsr, VoiceInputScene.NormalChat);
        this.chatId = "";
        this.hitPointPageScene = "main";
        this.extraAnalyticParams = MapsKt.emptyMap();
        this._isKeyboardShowing = new MutableLiveData();
        this._isPanelShowing = new MutableLiveData();
        this.isVoiceInputMarkdownFg = KeyboardVoiceFGUtils.a.j();
        this.isVoiceSecondInputV2 = ((Boolean) KeyboardVoiceFGUtils.e.getValue()).booleanValue();
        this.isSupportPartialUpload = true;
        this.asrResultRichText = new MutableLiveData();
        this.startMention = new MutableLiveData();
        this._showOriginalButtonVisible = new MutableLiveData(Boolean.FALSE);
        this.currentRecordSourceId = "";
        this._audioRecordVolume = new MutableLiveData();
        this._audioAsrResult = new MutableLiveData();
        this.collectedPcmBuffer = new com.ss.android.lark.audio.voiceinput.utils.a();
        this._asrPreemptiveOptimize = new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.a();
        this._voiceInputDelegate = new VoiceInputDelegate();
        this._immersivePerformance = new k(VoiceInputAppreciablePerformance.x);
        this._asrSessionState = new MutableLiveData(AsrSessionState.AsrSessionIdle);
        this._isRecordHardwareReady = new MutableLiveData();
        this._isPopUpTransitionEnd = new MutableLiveData();
        this._voiceRecordListener = new f(this);
        this._voiceDataAsrListener = new ImmersiveVoiceViewModel$_voiceDataAsrListener$1(this);
        this._vcMeetingStatusListener = new e();
        MediatorLiveData<Boolean> r0 = new MediatorLiveData();
        r0.addSource(this._isRecordHardwareReady, new c(this, r0));
        r0.addSource(this._isPopUpTransitionEnd, new d(this, r0));
        this._shouldHandleTouchEvent = r0;
        this._speechRecognitionEventPushListener = new ImmersiveVoiceViewModel$_speechRecognitionEventPushListener$1(this);
    }

    private final void safeClearLoading() {
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == false) goto L7;
        i r0 = this._voiceViewModelDependency;
        if (r0 == null) goto L9;
        r0.d();
        return;
    L9:
        return;
    L7:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getMain(), null, new C04241(this, null), 2, null);
    }

    public final void clearSessionState() {
        cancelAsrWaitingTips();
        updateVoiceStateIfNeed(new j());
        sob.c.e(this._asrSessionState, AsrSessionState.AsrSessionIdle);
    }

    public final boolean isCcmCommentScene() {
        if (getImmersiveVoiceMode().b != VoiceInputScene.CcmComment) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isDisableVoiceWithAsr() {
        if (getImmersiveVoiceMode().b != VoiceInputScene.EnterpriseAnswer) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return true;
    L8:
        if (getImmersiveVoiceMode().b != VoiceInputScene.CcmComment) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L18;
        KeyboardVoiceFGUtils r2 = KeyboardVoiceFGUtils.a;
        if (KeyboardVoiceFGUtils.a("im.messenger.disable_audio_text", null) == true) goto L19;
        return false;
    L19:
        return true;
    L18:
        return true;
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final boolean isEnterpriseAnswerScene() {
        if (getImmersiveVoiceMode().b != VoiceInputScene.EnterpriseAnswer) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSupportVoiceWithAsr() {
        boolean r1 = false;
        if (isDisableVoiceWithAsr() == false) goto L5;
        Log.i(TAG, "did not read send type setting by this scene, voice with asr -> false");
        return false;
    L5:
        com.ss.android.lark.storage.kv.repo.a r0 = t.b();
        if (r0.contains("key_support_voice_with_asr") == false) goto L8;
        boolean r2 = r0.getBoolean("key_support_voice_with_asr", false);
        Log.i(TAG, "had voice with asr before -> " + r2);
        return r2;
    L8:
        KeyboardVoiceFGUtils r3 = KeyboardVoiceFGUtils.a;
        if (AudioRecordSettings.d().getAudioUpdateRecordText() != 1) goto L11;
        r1 = true;
    L11:
        Log.i(TAG, "did not set send type before, apply setting send voice with asr -> " + r1);
        return r1;
    }

    public void onCleared() {
        super.onCleared();
        destroy();
    }

    public final String currentChatId$keyboard_biz_voice_release() {
        return this.chatId;
    }

    public final String currentHitPointScene$keyboard_biz_voice_release() {
        return this.hitPointPageScene;
    }

    public final MutableLiveData<Boolean> getAsrNeedRetry() {
        return this._asrNeedRetry;
    }

    public final MutableLiveData<Boolean> getAsrResultFocused() {
        return this._asrResultFocused;
    }

    public final MutableLiveData<com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c> getAsrResultRichText() {
        return this.asrResultRichText;
    }

    public final MutableLiveData<AsrSessionState> getAsrSessionState() {
        return this._asrSessionState;
    }

    public final MutableLiveData<CharSequence> getAudioAsrResult() {
        return this._audioAsrResult;
    }

    public final MutableLiveData<Double> getAudioRecordVolume() {
        return this._audioRecordVolume;
    }

    public final boolean getAutoSendOnRecognizeFinish() {
        return this.autoSendOnRecognizeFinish;
    }

    public final MutableLiveData<Pair<Integer, Integer>> getBeforeInsertSelectionV2() {
        return this.beforeInsertSelectionV2;
    }

    public final MutableLiveData<Pair<Integer, Integer>> getBeforeInsetSelection() {
        return this.beforeInsetSelection;
    }

    public final String getCurrentRecordSourceId() {
        return this.currentRecordSourceId;
    }

    public final boolean getHidePopupOnReleaseKeepSession() {
        return this.hidePopupOnReleaseKeepSession;
    }

    public final p getImmersiveVoiceMode() {
        return this._voiceInputMode;
    }

    public final MutableLiveData<l> getImmersiveVoiceState() {
        return this._immersiveVoiceState;
    }

    public final MutableLiveData<String> getInsertPeriod() {
        return this.insertPeriod;
    }

    public final MutableLiveData<RichText> getInsertPeriodRichText() {
        return this.insertPeriodRichText;
    }

    public final Function1<Context, CharSequence> getOnlyAsrRecognizingTipsProvider() {
        return this.onlyAsrRecognizingTipsProvider;
    }

    public final MutableLiveData<Boolean> getPopupWindowVisible() {
        return this._popupWindowVisible;
    }

    public final MutableLiveData<Integer> getRecordingOccurException() {
        return this._recordingOccurException;
    }

    public final MutableLiveData<Boolean> getRollbackToOldAudio() {
        return this._rollbackToOldAudio;
    }

    public final MediatorLiveData<Boolean> getShouldHandleTouchEvent() {
        return this._shouldHandleTouchEvent;
    }

    public final MutableLiveData<Boolean> getShouldShowAsrWaitingPoorNetTips() {
        return this._shouldShowAsrWaitingPoorNetTips;
    }

    public final MutableLiveData<Boolean> getShouldShowPoorNetTips() {
        return this._shouldShowPoorNetTips;
    }

    public final MutableLiveData<Boolean> getShowOriginalButtonVisible() {
        return this._showOriginalButtonVisible;
    }

    public final MutableLiveData<String> getStartMention() {
        return this.startMention;
    }

    public final MutableLiveData<String> getVoiceDuration() {
        return this._voiceDuration;
    }

    public final MutableLiveData<Boolean> getVoiceRecordTooShort() {
        return this._voiceRecordTooShort;
    }

    public final boolean isAsrEnable() {
        return this.isAsrEnable;
    }

    public final boolean isAsrNerEnable() {
        return this.isAsrNerEnable;
    }

    public final MutableLiveData<Boolean> isAsrRecognizeFinish() {
        return this._isAsrRecognizeFinish;
    }

    public final boolean isCancelingSession() {
        return this._isCancelingSession;
    }

    public final MutableLiveData<com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.f> isElapseCountDown() {
        return this._elapseCountDown;
    }

    public final boolean isEnableVoiceInputSdk() {
        return this.isEnableVoiceInputSdk;
    }

    public final MutableLiveData<Boolean> isKeyboardShowing() {
        return this._isKeyboardShowing;
    }

    public final MutableLiveData<Boolean> isPanelShowing() {
        return this._isPanelShowing;
    }

    public final boolean isProgrammaticUpdate() {
        return this.isProgrammaticUpdate;
    }

    public final MutableLiveData<Boolean> isRecordHardWareReady() {
        return this._isRecordHardwareReady;
    }

    public final MutableLiveData<Boolean> isShowTipsResultCanEditable() {
        return this._isShowTipsResultCanEditable;
    }

    public final boolean isSupportPartialUpload() {
        return this.isSupportPartialUpload;
    }

    public final boolean isVoiceInputMarkdownFg() {
        return this.isVoiceInputMarkdownFg;
    }

    public final boolean isVoiceSecondInputV2() {
        return this.isVoiceSecondInputV2;
    }

    public static final /* synthetic */ void access$cancelAsrWaitingTips(ImmersiveVoiceViewModel r0) {
        r0.cancelAsrWaitingTips();
    }

    public static final /* synthetic */ void access$delayTriggerAsrWaitingTips(ImmersiveVoiceViewModel r0) {
        r0.delayTriggerAsrWaitingTips();
    }

    public static final /* synthetic */ String access$getChatId$p(ImmersiveVoiceViewModel r0) {
        return r0.chatId;
    }

    public static final /* synthetic */ com.ss.android.lark.audio.voiceinput.utils.a access$getCollectedPcmBuffer$p(ImmersiveVoiceViewModel r0) {
        return r0.collectedPcmBuffer;
    }

    public static final /* synthetic */ Map access$getExtraAnalyticParams$p(ImmersiveVoiceViewModel r0) {
        return r0.extraAnalyticParams;
    }

    public static final /* synthetic */ MutableLiveData access$get_asrNeedRetry$p(ImmersiveVoiceViewModel r0) {
        return r0._asrNeedRetry;
    }

    public static final /* synthetic */ com.ss.android.lark.audio.voiceinput.c access$get_asrResult$p(ImmersiveVoiceViewModel r0) {
        return r0._asrResult;
    }

    public static final /* synthetic */ MutableLiveData access$get_asrSessionState$p(ImmersiveVoiceViewModel r0) {
        return r0._asrSessionState;
    }

    public static final /* synthetic */ UserSearchAndMatchStrategy access$get_asrUserInfoMathStrategy$p(ImmersiveVoiceViewModel r0) {
        return r0._asrUserInfoMathStrategy;
    }

    public static final /* synthetic */ MutableLiveData access$get_audioAsrResult$p(ImmersiveVoiceViewModel r0) {
        return r0._audioAsrResult;
    }

    public static final /* synthetic */ com.ss.android.lark.keyboard.plugin.tool.voice.c access$get_audioMessageDelegate$p(ImmersiveVoiceViewModel r0) {
        return r0._audioMessageDelegate;
    }

    public static final /* synthetic */ MutableLiveData access$get_audioRecordVolume$p(ImmersiveVoiceViewModel r0) {
        return r0._audioRecordVolume;
    }

    public static final /* synthetic */ String access$get_beforeEditAsrResult$p(ImmersiveVoiceViewModel r0) {
        return r0._beforeEditAsrResult;
    }

    public static final /* synthetic */ MutableLiveData access$get_elapseCountDown$p(ImmersiveVoiceViewModel r0) {
        return r0._elapseCountDown;
    }

    public static final /* synthetic */ k access$get_immersivePerformance$p(ImmersiveVoiceViewModel r0) {
        return r0._immersivePerformance;
    }

    public static final /* synthetic */ MutableLiveData access$get_immersiveVoiceState$p(ImmersiveVoiceViewModel r0) {
        return r0._immersiveVoiceState;
    }

    public static final /* synthetic */ MutableLiveData access$get_isAsrRecognizeFinish$p(ImmersiveVoiceViewModel r0) {
        return r0._isAsrRecognizeFinish;
    }

    public static final /* synthetic */ boolean access$get_isCancelingSession$p(ImmersiveVoiceViewModel r0) {
        return r0._isCancelingSession;
    }

    public static final /* synthetic */ MutableLiveData access$get_isPopUpTransitionEnd$p(ImmersiveVoiceViewModel r0) {
        return r0._isPopUpTransitionEnd;
    }

    public static final /* synthetic */ MutableLiveData access$get_isRecordHardwareReady$p(ImmersiveVoiceViewModel r0) {
        return r0._isRecordHardwareReady;
    }

    public static final /* synthetic */ MutableLiveData access$get_recordingOccurException$p(ImmersiveVoiceViewModel r0) {
        return r0._recordingOccurException;
    }

    public static final /* synthetic */ MutableLiveData access$get_shouldShowAsrWaitingPoorNetTips$p(ImmersiveVoiceViewModel r0) {
        return r0._shouldShowAsrWaitingPoorNetTips;
    }

    public static final /* synthetic */ MutableLiveData access$get_shouldShowPoorNetTips$p(ImmersiveVoiceViewModel r0) {
        return r0._shouldShowPoorNetTips;
    }

    public static final /* synthetic */ MutableLiveData access$get_showOriginalButtonVisible$p(ImmersiveVoiceViewModel r0) {
        return r0._showOriginalButtonVisible;
    }

    public static final /* synthetic */ com.ss.android.lark.audio.voiceinput.k access$get_smartPeriodOptimizer$p(ImmersiveVoiceViewModel r0) {
        return r0._smartPeriodOptimizer;
    }

    public static final /* synthetic */ boolean access$get_userEditedAfterAsr$p(ImmersiveVoiceViewModel r0) {
        return r0._userEditedAfterAsr;
    }

    public static final /* synthetic */ MutableLiveData access$get_voiceDuration$p(ImmersiveVoiceViewModel r0) {
        return r0._voiceDuration;
    }

    public static final /* synthetic */ VoiceInputDelegate access$get_voiceInputDelegate$p(ImmersiveVoiceViewModel r0) {
        return r0._voiceInputDelegate;
    }

    public static final /* synthetic */ p access$get_voiceInputMode$p(ImmersiveVoiceViewModel r0) {
        return r0._voiceInputMode;
    }

    public static final /* synthetic */ s access$get_voiceInputResultConsumer$p(ImmersiveVoiceViewModel r0) {
        return r0._voiceInputResultConsumer;
    }

    public static final /* synthetic */ MutableLiveData access$get_voiceRecordTooShort$p(ImmersiveVoiceViewModel r0) {
        return r0._voiceRecordTooShort;
    }

    public static final /* synthetic */ i access$get_voiceViewModelDependency$p(ImmersiveVoiceViewModel r0) {
        return r0._voiceViewModelDependency;
    }

    public static final /* synthetic */ boolean access$isAsrResultEmpty(ImmersiveVoiceViewModel r0) {
        return r0.isAsrResultEmpty();
    }

    public static final /* synthetic */ boolean access$needSendVoice(ImmersiveVoiceViewModel r0) {
        return r0.needSendVoice();
    }

    public static final /* synthetic */ void access$safeClearLoading(ImmersiveVoiceViewModel r0) {
        r0.safeClearLoading();
    }

    public static final /* synthetic */ void access$stopAsrResultWhenRecordTimeTooShort(ImmersiveVoiceViewModel r0) {
        r0.stopAsrResultWhenRecordTimeTooShort();
    }

    private final sob.a calculateAsrResult(RichText r21) {
        ArrayList r0 = new ArrayList();
        RichText.RichTextElements r2 = r21.getElements();
        boolean r4 = true;
        int r5 = 0;
        if (r2 == null) goto L21;
        Map r3 = r2.getDictionary();
        if (r3 == null) goto L21;
        Set r6 = r3.entrySet();
        if (r6 == null) goto L21;
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L17;
        Object r9 = r8.next();
        if (((RichTextElement) ((Map.Entry) r9).getValue()).getTag() != RichTextElement.RichTextTag.AT) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == false) goto L10;
        r7.add(r9);
        goto L10
    L14:
        r10 = false;
        goto L15
    L17:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r12 = r7.iterator();
    L19:
        if (r12.hasNext() == false) goto L22;
        r11.add(((RichTextElement) ((Map.Entry) r12.next()).getValue()).getProperty().getUserId());
    L22:
        List<com.ss.android.lark.audio.voiceinput.a> r13 = this._asrNerInfoList;
        if (r13 == null) goto L70;
        Iterator<T> r14 = r13.iterator();
        int r15 = 0;
        int r16 = 0;
    L26:
        if (r14.hasNext() == false) goto L71;
        com.ss.android.lark.audio.voiceinput.a r17 = (com.ss.android.lark.audio.voiceinput.a) r14.next();
        UserSearchAndMatchStrategy r18 = this._asrUserInfoMathStrategy;
        if (r18 == null) goto L49;
        String r19 = "";
        if (r17 == null) goto L50;
        UserSearchAndMatchStrategy.b r110 = r18.j.get(UserSearchAndMatchStrategy.e(r17));
        if (r110 == null) goto L50;
        monitor-enter(r110);
        UserSearchAndMatchStrategy.BaseSearchStrategy r111 = r110.b;     // Catch: Throwable -> L46
        if (r111 == null) goto L39;
        ChatChatter r112 = r111.c();     // Catch: Throwable -> L46
    L40:
        monitor-exit(r110);
        if (r112 == null) goto L50;
        String r113 = r112.getId();
        if (r113 == null) goto L50;
        r19 = r113;
        goto L50
    L39:
        r112 = null;
    L46:
        th = move-exception;
        throw th;
    L50:
        if (r19 != null) goto L52;
    L57:
        boolean r114 = false;
    L58:
        if (r114 == false) goto L60;
        r16 = r16 + 1;
        boolean r115 = true;
    L61:
        if (r11 != null) goto L63;
    L65:
        boolean r116 = false;
    L66:
        if (r116 == false) goto L68;
        r15 = r15 + 1;
        boolean r117 = true;
    L69:
        ImmersiveVoiceViewModel$calculateAsrResult$1$saltUserId$1 r118 = ImmersiveVoiceViewModel$calculateAsrResult$1$saltUserId$1.INSTANCE;
        sob.b r119 = new sob.b(r115, r117, r17.e, r17.f, (String) r118.invoke(r17.g), (String) r118.invoke(r19));
        StringBuilder r20 = new StringBuilder("calculateAsrResult / asrUserInfo:");
        r20.append("AsrUserInfo(eventId=" + r119.a + ", isNameSearched=" + r119.b + ", isAccept=" + r119.c + ", resultCat=" + r119.d + ", resultCatRank=" + r119.e + "), uniqueId is equal " + Intrinsics.areEqual(r119.f, r119.g));
        Log.i(TAG, r20.toString());
        r0.add(r119);
        r4 = true;
        goto L26
    L68:
        r117 = false;
        goto L69
    L63:
        if (r11.contains(r19) != r4) goto L65;
        r116 = true;
        goto L66
    L60:
        r115 = false;
        goto L61
    L52:
        if (r19.length() <= 0) goto L54;
        boolean r120 = true;
    L55:
        if (r120 != r4) goto L57;
        r114 = true;
        goto L58
    L54:
        r120 = false;
        goto L55
    L49:
        r19 = null;
    L71:
        com.ss.android.lark.audio.voiceinput.c r22 = this._asrResult;
        if (r22 == null) goto L76;
        List r23 = r22.g;
        if (r23 == null) goto L76;
        r5 = r23.size();
    L76:
        AsrAdoptionRate r24 = new AsrAdoptionRate(r5, r16, r15);
        StringBuilder r25 = new StringBuilder("calculateAsrResult / searchNumCount:");
        r25.append(r16);
        r25.append(" acceptNumCount:");
        r25.append(r15);
        r25.append(", asrNerInfoList:");
        com.ss.android.lark.audio.voiceinput.c r26 = this._asrResult;
        if (r26 == null) goto L81;
        List r27 = r26.g;
        if (r27 == null) goto L81;
        Integer r28 = Integer.valueOf(r27.size());
    L82:
        r25.append(r28);
        Log.i(TAG, r25.toString());
        UserSearchAndMatchStrategy r29 = this._asrUserInfoMathStrategy;
        if (r29 == null) goto L86;
        r29.c();
    L86:
        return new sob.a(r0, r24);
    L81:
        r28 = null;
        goto L82
    L70:
        r15 = 0;
        r16 = 0;
    L21:
        r11 = null;
        goto L22
    }

    private final void delayTriggerAsrTimeOut(Function0<Unit> r10) {
        sob.c.e(this._asrSessionState, AsrSessionState.AsrSessionWaitRecognizing);
        Job r0 = this.asrTimeOutChecker;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.asrTimeOutChecker = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04151(this, r10, null), 2, null);
    }

    private final String formatTime(int r5) {
        int r6 = r5 / AudioViewModel.ASR_SESSION_IDLE;
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        return String.format("%01d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r6 / 60), Integer.valueOf(r6 % 60)}, 2));
    }

    private final boolean needUpdateAsrState(Function0<Unit> r4) {
        l r0 = (l) getImmersiveVoiceState().getValue();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getState() != 3) goto L7;
    L10:
        r4.invoke();
        return true;
    L7:
        if (r0.getState() == 5) goto L10;
        if (r0.getState() == 6) goto L10;
        return false;
    }

    private final void renderOriginRichText(com.ss.android.lark.audio.voiceinput.c r11) {
        RichText r1 = r11.i;
        if (r1 != null) goto L5;
        return;
    L5:
        sob.c.e(this.asrResultRichText, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c(r1, new SpannableStringBuilder(), r11.d, null, null, true, 24));
    }

    private final boolean shouldShowOrigin(com.ss.android.lark.audio.voiceinput.c r3) {
        if (r3.k == true) goto L6;
        return false;
    L6:
        if (r3.i != null) goto L9;
        return false;
    L9:
        return !com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.b();
    }

    private final void updateCacheState(String r4) {
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.g r0 = this._getEditTextAndSelectionDependency;
        String r1 = null;
        if (r0 == null) goto L5;
        Pair<String, Integer> r2 = r0.a();
    L6:
        com.ss.android.lark.audio.voiceinput.k r3 = this._smartPeriodOptimizer;
        if (r2 == null) goto L9;
        r1 = (String) r2.getFirst();
    L9:
        if (r2 == null) goto L11;
        int r5 = ((Number) r2.getSecond()).intValue();
    L12:
        r3.c(r4, r1, r5);
        return;
    L11:
        r5 = -1;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final void injectDependency(i r2) {
        Intrinsics.checkNotNullParameter(r2, "voiceViewModelDependency");
        this._voiceViewModelDependency = r2;
    }

    public final void injectIGetEditTextAndSelectionDependency(com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.g r3) {
        Intrinsics.checkNotNullParameter(r3, "getEditTextAndSelectionDependency");
        this._getEditTextAndSelectionDependency = r3;
        VoiceInputDelegate r0 = this._voiceInputDelegate;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "dependency");
        r0.l = r3;
    }

    public final Pair<String, List<SpeechRecognitionReportEditItem>> packReportEditItem(String r8) {
        Intrinsics.checkNotNullParameter(r8, "reportEditContent");
        KeyboardVoiceFGUtils r0 = KeyboardVoiceFGUtils.a;
        boolean r1 = ((Boolean) KeyboardVoiceFGUtils.b.getValue()).booleanValue();
        String r3 = null;
        if (this.isEnableVoiceInputSdk == true) goto L5;
    L35:
        ArrayList r2 = null;
    L36:
        if (r1 == false) goto L39;
        r3 = this._voiceInputDelegate.c;
    L39:
        return new Pair(r3, r2);
    L5:
        if (r0.f() == false) goto L35;
        if (r1 == false) goto L10;
        q r4 = (q) CollectionsKt.lastOrNull(this._voiceInputDelegate.b);
        if (r4 == null) goto L10;
        r4.g = r8;
    L10:
        CopyOnWriteArrayList<q> r9 = this._voiceInputDelegate.b;
        r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<q> r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L36;
        q r5 = r10.next();
        SpeechRecognitionReportEditItem.Builder r6 = new SpeechRecognitionReportEditItem.Builder().source_id(r5.c);
        if (this.isVoiceInputMarkdownFg == true) goto L16;
        com.ss.android.lark.audio.voiceinput.c r7 = r5.d;
        if (r7 == null) goto L30;
        String r11 = r7.c;
    L31:
        SpeechRecognitionReportEditItem.Builder r12 = r6.text_origin(r11);
        if (r1 == false) goto L34;
        r12.recording_device(r5.h).text_snapshot_before(r5.f).text_snapshot_after(r5.g);
    L34:
        r2.add(r12.build());
        goto L12
    L30:
        r11 = null;
        goto L31
    L16:
        if (r5.e == false) goto L22;
        com.ss.android.lark.audio.voiceinput.c r13 = r5.d;
        if (r13 == null) goto L20;
        RichText r14 = r13.i;
    L21:
        r11 = com.ss.android.lark.widget.richtext.i.g(r14, false);
        goto L31
    L20:
        r14 = null;
        goto L21
    L22:
        com.ss.android.lark.audio.voiceinput.c r15 = r5.d;
        if (r15 == null) goto L25;
        RichText r16 = r15.h;
    L26:
        r11 = com.ss.android.lark.widget.richtext.i.g(r16, false);
        goto L31
    L25:
        r16 = null;
        goto L26
    }

    public final void reportAsrEndEditContent(String r2) {
        q r0 = (q) CollectionsKt.lastOrNull(this._voiceInputDelegate.b);
        if (r0 == null) goto L6;
        r0.f = r2;
        return;
    }

    public final void resetLiveData(boolean r11) {
        sob.c.e(this._audioAsrResult, "");
        sob.c.e(this.asrResultRichText, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c(new RichText(), new SpannableStringBuilder(), false, null, null, false, 56));
        Job r0 = this.asrTimeOutChecker;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        cancelAsrWaitingTips();
        this.keepSessionOnNextPopupHide = false;
        this._lastFinishedAsrResult = null;
        MutableLiveData<Boolean> r3 = this._showOriginalButtonVisible;
        Boolean r4 = Boolean.FALSE;
        sob.c.e(r3, r4);
        this._userEditedAfterAsr = false;
        this._userClickedShowOriginal = false;
        q r5 = (q) CollectionsKt.lastOrNull(this._voiceInputDelegate.b);
        if (r5 == null) goto L8;
        r5.e = false;
    L8:
        sob.c.e(this._isAsrRecognizeFinish, r4);
        sob.c.e(this._shouldShowAsrWaitingPoorNetTips, r4);
        sob.c.e(this._shouldShowPoorNetTips, r4);
        sob.c.e(this._asrNeedRetry, r4);
        sob.c.e(this._asrSessionState, AsrSessionState.AsrSessionIdle);
        sob.c.e(this._isRecordHardwareReady, r4);
        sob.c.e(this._isPopUpTransitionEnd, r4);
        sob.c.e(this._voiceRecordTooShort, r4);
        updateVoiceStateIfNeed(new j());
        this._asrResult = null;
        this._voiceRecordEntity = null;
        this._beforeEditAsrResult = null;
        if (this.isEnableVoiceInputSdk == false) goto L17;
        this._voiceInputDelegate.b(r11);
        VoiceInputService r12 = this._voiceInputDelegate.a;
        if (r12 == null) goto L18;
        Job r6 = r12.e;
        if (r6 == null) goto L15;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L15:
        r12.e = null;
        r12.h = null;
        r12.i = 0;
        return;
    L18:
        return;
    }

    public final boolean retryLastVoiceInput(String r7) {
        Intrinsics.checkNotNullParameter(r7, "languageKey");
        this._userEditedAfterAsr = false;
        this._userClickedShowOriginal = false;
        this._lastFinishedAsrResult = null;
        q r3 = (q) CollectionsKt.lastOrNull(this._voiceInputDelegate.b);
        if (r3 == null) goto L5;
        r3.e = false;
    L5:
        MutableLiveData<Boolean> r4 = this._showOriginalButtonVisible;
        Boolean r5 = Boolean.FALSE;
        sob.c.e(r4, r5);
        sob.c.e(this._shouldShowPoorNetTips, r5);
        sob.c.e(this._asrNeedRetry, r5);
        sob.c.e(this._shouldShowAsrWaitingPoorNetTips, r5);
        sob.c.c(this._isAsrRecognizeFinish, r5);
        if (this.isEnableVoiceInputSdk == false) goto L17;
        VoiceInputDelegate r6 = this._voiceInputDelegate;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "languageKey");
        q r0 = (q) CollectionsKt.lastOrNull(r6.b);
        if (r0 == null) goto L23;
        com.ss.android.lark.audio.voiceinput.s r8 = r0.a;
        if (r8 == null) goto L23;
        VoiceInputService r9 = r6.a;
        if (r9 == null) goto L23;
        r0.d = null;
        r0.e = false;
        r9.f(r7, r8);
    L22:
        boolean r10 = true;
    L24:
        this.isProgrammaticUpdate = true;
        if (r10 == true) goto L28;
        Log.w(TAG, "retryLastVoiceInput failed: no last voice input");
        return false;
    L28:
        safeClearLoading();
        sob.c.e(this._asrSessionState, AsrSessionState.AsrSessionWaitRecognizing);
        return true;
    L23:
        r10 = false;
        goto L24
    L17:
        AudioRecordCoordinator r1 = this._audioRecordCoordinator;
        if (r1 == null) goto L21;
        r1.a(r7);
    L21:
        if (this._audioRecordCoordinator == null) goto L23;
        goto L22
    }

    public final void setAsrEnable(boolean r1) {
        this.isAsrEnable = r1;
    }

    public final void setAsrNerEnable(boolean r1) {
        this.isAsrNerEnable = r1;
    }

    public final void setAutoSendOnRecognizeFinish(boolean r1) {
        this.autoSendOnRecognizeFinish = r1;
    }

    public final void setBeforeInsetSelection(MutableLiveData<Pair<Integer, Integer>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.beforeInsetSelection = r2;
    }

    public final void setBeforeVoiceEditAsrResult(String r1) {
        this._beforeEditAsrResult = r1;
    }

    public final void setEnableVoiceInputSdk(boolean r1) {
        this.isEnableVoiceInputSdk = r1;
    }

    public final void setHidePopupOnReleaseKeepSession(boolean r1) {
        this.hidePopupOnReleaseKeepSession = r1;
    }

    public final void setInputStateController(r r1) {
        this._inputStateController = r1;
    }

    public final void setKeyboardController(h r2) {
        Intrinsics.checkNotNullParameter(r2, "kbController");
        this._keyboardController = r2;
    }

    public final void setMaxRecordTime(int r2) {
        if (this.isEnableVoiceInputSdk == false) goto L9;
        VoiceInputService r0 = this._voiceInputDelegate.a;
        if (r0 == null) goto L13;
        com.ss.android.lark.audio.voiceinput.d r1 = r0.b;
        if (r1 == null) goto L14;
        r1.p = r2;
        return;
    L14:
        return;
    L13:
        return;
    L9:
        AudioRecordCoordinator r3 = this._audioRecordCoordinator;
        if (r3 == null) goto L16;
        r3.d.p = r2;
        return;
    }

    public final void setOnlyAsrRecognizingTipsProvider(Function1<? super Context, ? extends CharSequence> r1) {
        this.onlyAsrRecognizingTipsProvider = r1;
    }

    public final void setProgrammaticUpdate(boolean r1) {
        this.isProgrammaticUpdate = r1;
    }

    public final void setSupportPartialUpload(boolean r1) {
        this.isSupportPartialUpload = r1;
    }

    public final boolean shouldShowPoorNetworkToast(String r6) {
        Intrinsics.checkNotNullParameter(r6, "sourceId");
        com.ss.android.lark.audio.voiceinput.d.d r1 = null;
        if (this.isEnableVoiceInputSdk == false) goto L5;
        String r0 = this._voiceInputDelegate.d();
    L10:
        if (this.isEnableVoiceInputSdk == false) goto L18;
        VoiceInputService r2 = this._voiceInputDelegate.a;
        if (r2 == null) goto L23;
        com.ss.android.lark.audio.voiceinput.d r3 = r2.b;
        if (r3 == null) goto L16;
        r1 = r3.w;
    L16:
        if (r1 == null) goto L23;
        boolean r4 = r1.isRecording();
    L24:
        if (r4 == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(r0, r6) == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        r4 = false;
        goto L24
    L18:
        com.ss.android.lark.audio.voiceinput.g r5 = this._audioRecordDelegate;
        if (r5 == null) goto L23;
        if (r5.isRecording() != true) goto L23;
        r4 = true;
        goto L24
    L5:
        com.ss.android.lark.keyboard.plugin.tool.voice.c r7 = this._audioMessageDelegate;
        if (r7 == null) goto L8;
        r0 = r7.a();
        goto L10
    L8:
        r0 = null;
        goto L10
    }

    public final void updateIsKeyboardShowing(boolean r2) {
        sob.c.e(this._isKeyboardShowing, Boolean.valueOf(r2));
    }

    public final void updateIsPanelShowing(boolean r2) {
        sob.c.e(this._isPanelShowing, Boolean.valueOf(r2));
    }

    public final void updatePopupWindowVisible(boolean r2) {
        sob.c.e(this._popupWindowVisible, Boolean.valueOf(r2));
    }

    public final void updateVoiceStateIfNeed(l r18) {
        Intrinsics.checkNotNullParameter(r18, "newVoiceState");
        l r3 = (l) this._immersiveVoiceState.getValue();
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L12;
        MutableLiveData<Boolean> r5 = this._isRecordHardwareReady;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Intrinsics.areEqual(r5.getValue(), Boolean.FALSE) == false) goto L12;
        boolean r6 = true;
    L14:
        if (r18.getState() <= 1) goto L16;
        boolean r7 = true;
    L18:
        if (r6 == false) goto L22;
        if (r7 == false) goto L22;
        Log.i(TAG, "updateVoiceStateIfNeed hardware not ready");
        return;
    L22:
        AsrSessionStateChecker r8 = this._asrSessionStateChecker;
        l r9 = (l) this._immersiveVoiceState.getValue();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r18, "newVoiceState");
        if (r9 != null) goto L26;
        Log.e(TAG, "[checkStateSwitchValid] currentState or newVoiceState is null");
    L37:
        boolean r2 = false;
    L38:
        if (r2 == false) goto L78;
        k r10 = this._immersivePerformance;
        int r11 = r18.getState();
        k.b r12 = r10.b;
        if (r12.a == r11) goto L58;
        r12.b.a();
        int r13 = r12.a;
        if (r13 == 2) goto L46;
        if (r13 == 3) goto L46;
        if (r13 == 4) goto L46;
    L57:
        r12.a = r11;
        VoiceInputAppreciablePerformance.b r14 = new VoiceInputAppreciablePerformance.b();
        r14.d();
        r12.b = r14;
    L46:
        List<Pair<String, Long>> r15 = r12.c;
        if (r13 == 0) goto L55;
        if (r13 == 2) goto L54;
        if (r13 == 3) goto L53;
        if (r13 == 4) goto L52;
        String r16 = InvRouter.UNKNOWN;
    L56:
        ((ArrayList) r15).add(new Pair(r16, Long.valueOf(r12.b.b())));
        goto L57
    L52:
        r16 = "canceling";
        goto L56
    L53:
        r16 = "recognition";
        goto L56
    L54:
        r16 = "record";
        goto L56
    L55:
        r16 = "idle";
    L58:
        StringBuilder r17 = new StringBuilder("updateVoiceStateIfNeed:");
        l r19 = (l) this._immersiveVoiceState.getValue();
        if (r19 == null) goto L61;
        String r20 = r19.getString();
    L62:
        r17.append(r20);
        r17.append(" -> ");
        r17.append(r18.getString());
        Log.i(TAG, r17.toString());
        l r21 = (l) this._immersiveVoiceState.getValue();
        if (r21 == null) goto L65;
        r18.d(r21);
    L65:
        sob.c.e(this._immersiveVoiceState, r18);
        int r1 = r18.getState();
        if (r1 == 3) goto L70;
        if (r1 != 4) goto L80;
        String r22 = this.currentRecordSourceId;
        sob.d r110 = sob.d.a;
        String r23 = this.chatId;
        Map<String, String> r24 = this.extraAnalyticParams;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r23, "chatId");
        Intrinsics.checkNotNullParameter(r22, "sourceId");
        Intrinsics.checkNotNullParameter(r24, "extraAnalyticParams");
        sob.d.e("im_voice_input_click", r24, new Pair[]{new Pair("chat_id", r23), new Pair("click", "slide_cancel"), new Pair("location", "im_input_button"), new Pair("source_id", r22), new Pair("text_len", 0)});
        return;
    L80:
        return;
    L70:
        sob.d r25 = sob.d.a;
        String r26 = this.chatId;
        String r111 = this.currentRecordSourceId;
        Map<String, String> r27 = this.extraAnalyticParams;
        r25.getClass();
        Intrinsics.checkNotNullParameter(r26, "chatId");
        Intrinsics.checkNotNullParameter(r111, "sourceId");
        Intrinsics.checkNotNullParameter(r27, "extraAnalyticParams");
        sob.d.e("im_voice_input_click", r27, new Pair[]{new Pair("chat_id", r26), new Pair("source_id", r111), new Pair("click", "slide_trans_text"), new Pair("location", "im_input_button")});
        return;
    L61:
        r20 = null;
        goto L62
    L78:
        return;
    L26:
        if (r9.getState() == r18.getState()) goto L37;
        Iterator r28 = ((ArrayList) r8.a.getValue()).iterator();
    L30:
        if (r28.hasNext() == false) goto L36;
        Pair r29 = (Pair) r28.next();
        if (((Number) r29.getFirst()).intValue() != r9.getState()) goto L30;
        if (((Number) r29.getSecond()).intValue() != r18.getState()) goto L30;
        r2 = true;
        goto L38
    L36:
        Log.e(TAG, "[checkStateSwitchValid] invalid state switch.currentState:" + r9.getString() + " newState:" + r18.getString());
        goto L37
    L16:
        r7 = false;
    L12:
        r6 = false;
        goto L14
    L5:
        if (r3.getState() != 0) goto L7;
        r4 = true;
        goto L8
    }

    public final void whenClickAsrResultEditText(String r13) {
        Intrinsics.checkNotNullParameter(r13, "clientAsrResult");
        boolean r3 = false;
        t.b().putBoolean(KV_STORAGE_SHOW_EDITABLE_TIPS, false);
        sob.c.e(this._isShowTipsResultCanEditable, Boolean.FALSE);
        sob.d r1 = sob.d.a;
        String r2 = this.chatId;
        String r4 = this.currentRecordSourceId;
        Map<String, String> r5 = this.extraAnalyticParams;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r4, "sourceId");
        Intrinsics.checkNotNullParameter(r13, "clientAsrResult");
        Intrinsics.checkNotNullParameter(r5, "extraAnalyticParams");
        sob.d.e("im_voice_input_click", r5, new Pair[]{new Pair("chat_id", r2), new Pair("source_id", r4), new Pair("click", "click_to_edit_text"), new Pair("location", "im_input_button")});
        cancelAsrTimeOut$default(this, CancelAsrTimeoutState.CancelByInputChange, !sob.c.b(r13), false, 4, null);
        String r0 = this._beforeEditAsrResult;
        if (r0 != null) goto L5;
    L6:
        r3 = true;
    L7:
        if (r3 == false) goto L10;
        this._beforeEditAsrResult = r13;
        return;
    L10:
        return;
    L5:
        if (r0.length() != 0) goto L7;
        goto L6
    }

    public final void whenClickSwitchSendType(SendType r4) {
        Intrinsics.checkNotNullParameter(r4, "sendType");
        int r5 = b.b[r4.ordinal()];
        if (r5 != 1) goto L5;
        sob.d r6 = sob.d.a;
        String r0 = this.chatId;
        String r1 = this.currentRecordSourceId;
        Map<String, String> r2 = this.extraAnalyticParams;
        r6.getClass();
        sob.d.g(r0, r1, "text_only", r2);
        return;
    L5:
        if (r5 != 2) goto L8;
        sob.d r7 = sob.d.a;
        String r3 = this.chatId;
        String r8 = this.currentRecordSourceId;
        Map<String, String> r9 = this.extraAnalyticParams;
        r7.getClass();
        sob.d.g(r3, r8, "text_and_voice", r9);
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ sob.a access$calculateAsrResult(ImmersiveVoiceViewModel r0, RichText r1) {
        return r0.calculateAsrResult(r1);
    }

    public static final /* synthetic */ void access$delayTriggerAsrTimeOut(ImmersiveVoiceViewModel r0, Function0 r1) {
        r0.delayTriggerAsrTimeOut(r1);
    }

    public static final /* synthetic */ String access$formatTime(ImmersiveVoiceViewModel r0, int r1) {
        return r0.formatTime(r1);
    }

    public static final /* synthetic */ boolean access$needUpdateAsrState(ImmersiveVoiceViewModel r0, Function0 r1) {
        return r0.needUpdateAsrState(r1);
    }

    public static final /* synthetic */ void access$renderOriginRichText(ImmersiveVoiceViewModel r0, com.ss.android.lark.audio.voiceinput.c r1) {
        r0.renderOriginRichText(r1);
    }

    public static final /* synthetic */ void access$set_asrFirstPiecePendingBlock$p(ImmersiveVoiceViewModel r0, Function0 r1) {
        r0._asrFirstPiecePendingBlock = r1;
    }

    public static final /* synthetic */ void access$set_asrNerInfoList$p(ImmersiveVoiceViewModel r0, List r1) {
        r0._asrNerInfoList = r1;
    }

    public static final /* synthetic */ void access$set_asrResult$p(ImmersiveVoiceViewModel r0, com.ss.android.lark.audio.voiceinput.c r1) {
        r0._asrResult = r1;
    }

    public static final /* synthetic */ void access$set_lastFinishedAsrResult$p(ImmersiveVoiceViewModel r0, com.ss.android.lark.audio.voiceinput.c r1) {
        r0._lastFinishedAsrResult = r1;
    }

    public static final /* synthetic */ void access$set_voiceRecordEntity$p(ImmersiveVoiceViewModel r0, com.ss.android.lark.audio.voiceinput.s r1) {
        r0._voiceRecordEntity = r1;
    }

    public static final /* synthetic */ boolean access$shouldShowOrigin(ImmersiveVoiceViewModel r0, com.ss.android.lark.audio.voiceinput.c r1) {
        return r0.shouldShowOrigin(r1);
    }

    public static final /* synthetic */ void access$updateCacheState(ImmersiveVoiceViewModel r0, String r1) {
        r0.updateCacheState(r1);
    }

    private final AsrNerStatisticV2 calculateAsrResultV2(RichText r7, ArrayList<UserInfoHitPoint> r8) {
        RichText.RichTextElements r9 = r7.getElements();
        if (r9 == null) goto L21;
        Map r10 = r9.getDictionary();
        if (r10 == null) goto L21;
        Set r11 = r10.entrySet();
        if (r11 == null) goto L21;
        ArrayList r2 = new ArrayList();
        Iterator r12 = r11.iterator();
    L10:
        if (r12.hasNext() == false) goto L17;
        Object r3 = r12.next();
        if (((RichTextElement) ((Map.Entry) r3).getValue()).getTag() != RichTextElement.RichTextTag.AT) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L10;
        r2.add(r3);
        goto L10
    L14:
        r4 = false;
        goto L15
    L17:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r5 = r2.iterator();
    L19:
        if (r5.hasNext() == false) goto L22;
        r13.add(((RichTextElement) ((Map.Entry) r5.next()).getValue()).getProperty().getUserId());
    L22:
        Iterator<T> r6 = r8.iterator();
        int r14 = 0;
    L24:
        if (r6.hasNext() == false) goto L35;
        UserInfoHitPoint r15 = (UserInfoHitPoint) r6.next();
        if (r13 != null) goto L28;
    L30:
        boolean r16 = false;
    L31:
        if (r16 == false) goto L33;
        r14 = r14 + 1;
    L33:
        r15.setUid(y.a(r15.getUid()));
        goto L24
    L28:
        if (r13.contains(r15.getUid()) != true) goto L30;
        r16 = true;
        goto L31
    L35:
        return new AsrNerStatisticV2(r8, new AsrAdoptionRate(r8.size(), 0, r14));
    L21:
        r13 = null;
        goto L22
    }

    private final void processSessionFinish(final String r12, com.ss.android.lark.audio.voiceinput.c r13) {
        StringBuilder r0 = new StringBuilder("processSessionFinish:");
        Pair<RichText, SpannableStringBuilder> r1 = null;
        if (r12 == null) goto L5;
        Integer r2 = Integer.valueOf(r12.length());
    L6:
        r0.append(r2);
        Log.i(TAG, r0.toString());
        if (this.isVoiceInputMarkdownFg == false) goto L11;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c r14 = packAudioAsrResult2AsrRichTextResult$default(this, r13, null, null, 6, null);
        if (r14 == null) goto L17;
        sob.c.e(this.asrResultRichText, r14);
    L17:
        needUpdateAsrState(new C04232(this, r12));
        CancelAsrTimeoutState r15 = CancelAsrTimeoutState.CancelByFinish;
        if (r12 == null) goto L25;
        boolean r3 = true;
        if (r12.length() <= 0) goto L22;
        boolean r4 = true;
    L23:
        if (r4 != true) goto L25;
    L26:
        cancelAsrTimeOut(r15, r3, false);
        updateCacheState(r12);
        return;
    L22:
        r4 = false;
    L25:
        r3 = false;
        goto L26
    L11:
        String r5 = this._smartPeriodOptimizer.b(r12);
        UserSearchAndMatchStrategy r6 = this._asrUserInfoMathStrategy;
        if (r6 == null) goto L14;
        r1 = r6.a(r5, r13.g, -1, null);
    L14:
        if (r1 == null) goto L16;
        sob.c.e(this.asrResultRichText, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c((RichText) r1.getFirst(), new SpannableStringBuilder(), r13.d, null, null, false, 56));
        goto L17
    L16:
        sob.c.e(this._audioAsrResult, r5);
        goto L17
    L5:
        r2 = null;
        goto L6
    }

    private final boolean startVoiceRecordV1Impl(p r9, String r10) {
        com.ss.android.lark.audio.voiceinput.g r0 = this._audioRecordDelegate;
        if (r0 == null) goto L36;
        com.ss.android.lark.audio.voiceinput.h r2 = this._audioResourceMutex;
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L14;
        Log.i(TAG, "failed to occupy resource");
        return false;
    L14:
        VoiceInputAppreciablePerformance.h();
        boolean r4 = this._asrPreemptiveOptimize.b();
        int r5 = b.a[r9.a.ordinal()];
        if (r5 != 1) goto L17;
        boolean r6 = r4;
    L28:
        Log.i(TAG, "startRecord needPreemptiveOptimize:" + r4 + " mode:" + r9.a.info() + " shouldStartWithAsr:" + r6 + ' ');
        registerListener();
        if (r6 == false) goto L31;
        boolean r11 = r0.b(AudioPluginFeature.WITH_TEXT, r10, false);
    L32:
        cancelAsrTimeOut(CancelAsrTimeoutState.CancelByReset, false, false);
        if (r11 == true) goto L36;
        unregisterListener();
        return false;
    L31:
        r11 = r0.b(AudioPluginFeature.RECORD, r10, false);
        goto L32
    L17:
        if (r5 != 2) goto L19;
        r6 = false;
        goto L28
    L19:
        if (r5 != 3) goto L21;
    L25:
        r6 = true;
        goto L28
    L21:
        if (r5 == 4) goto L25;
        throw new NoWhenBranchMatchedException();
    L7:
        if (r2.b() == true) goto L9;
        r3 = true;
    L36:
        return true;
    }

    public final RichText addPeriodForRichTextIfNeed(String r9, int r10) {
        com.ss.android.lark.audio.voiceinput.l r0 = this._voiceInputDelegate.k;
        r0.getClass();
        RichText r1 = new RichText();
        boolean r2 = false;
        if (r9 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
    L30:
        r0.e = true;
        r0.b = null;
        r0.d = -1;
        r0.c = null;
        return r1;
    L12:
        if (r0.e == true) goto L30;
        RichText r5 = r0.b;
        if (r5 != null) goto L17;
        return r1;
    L17:
        if (r10 == r0.d) goto L19;
        return r1;
    L19:
        if (Intrinsics.areEqual(r0.c, r9) == false) goto L34;
        String r11 = r0.c;
        if (r11 != null) goto L23;
    L28:
        if (r2 == false) goto L35;
        r0.e = true;
        r0.b = null;
        r0.d = -1;
        r0.c = null;
        return r5;
    L35:
        return r1;
    L23:
        if (r11.length() <= 0) goto L25;
        boolean r12 = true;
    L26:
        if (r12 != true) goto L28;
        r2 = true;
        goto L28
    L25:
        r12 = false;
        goto L26
    L34:
        return r1;
    L5:
        if (r9.length() == 0) goto L8;
        r4 = false;
        goto L10
    }

    public final String addPeriodIfNeed(String r2, int r3) {
        if (this.isEnableVoiceInputSdk == false) goto L6;
        return this._voiceInputDelegate.j.a(r2, r3);
    L6:
        return this._smartPeriodOptimizer.a(r2, r3);
    }

    public final void forceAsrSessionFinish(CancelAsrTimeoutState r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "cancelingState");
        cancelAsrWaitingTips();
        boolean r1 = false;
        if (this.isEnableVoiceInputSdk == false) goto L10;
        VoiceInputService r0 = this._voiceInputDelegate.a;
        if (r0 == null) goto L14;
        Job r4 = r0.e;
        if (r4 == null) goto L9;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L9:
        r0.e = null;
        r0.h = null;
        r0.i = 0;
    L14:
        safeClearLoading();
        if (r7 == CancelAsrTimeoutState.CancelByReset) goto L17;
        sob.c.c(this._isAsrRecognizeFinish, Boolean.TRUE);
    L17:
        this._immersivePerformance.a();
        int r2 = VoiceInputAppreciablePerformance.a;
        if (r7 != CancelAsrTimeoutState.CancelByFinish) goto L20;
        r1 = true;
    L20:
        VoiceInputAppreciablePerformance.e(r1, r8, r7.info());
        return;
    L10:
        Job r3 = this.asrTimeOutChecker;
        if (r3 == null) goto L13;
        Log.i(TAG, "forceCancelAsrTimeOut by " + r7.info());
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L13:
        this.asrTimeOutChecker = null;
        goto L14
    }

    public final void onlySendAudioMsg(RichText r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "richText");
        Intrinsics.checkNotNullParameter(r14, "content");
        ArrayList<UserInfoHitPoint> r5 = packAsrUserInfoList();
        String r3 = this.currentRecordSourceId;
        dismissPopupWindow();
        if (this.isEnableVoiceInputSdk == false) goto L9;
        com.ss.android.lark.audio.voiceinput.s r0 = this._voiceRecordEntity;
        if (r0 == null) goto L12;
        s r1 = this._voiceInputResultConsumer;
        if (r1 == null) goto L12;
        r1.c(r0);
    L12:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04212(this, r3, r13, r5, r14, null), 2, null);
        return;
    L9:
        com.ss.android.lark.keyboard.plugin.tool.voice.c r2 = this._audioMessageDelegate;
        if (r2 == null) goto L12;
        r2.b();
        goto L12
    }

    public final void onlySendTextMsg(String r19, RichText r20) {
        Intrinsics.checkNotNullParameter(r19, "content");
        Intrinsics.checkNotNullParameter(r20, "richText");
        Pair<String, List<SpeechRecognitionReportEditItem>> r0 = packReportEditItem(r19);
        String r7 = (String) r0.component1();
        List r6 = (List) r0.component2();
        ArrayList<UserInfoHitPoint> r4 = packAsrUserInfoList();
        String r2 = this.currentRecordSourceId;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04221(this, r2, r20, r4, r19, r6, r7, null), 2, null);
        dismissPopupWindow();
        if (this.isEnableVoiceInputSdk == false) goto L9;
        com.ss.android.lark.audio.voiceinput.s r1 = this._voiceRecordEntity;
        if (r1 == null) goto L13;
        s r3 = this._voiceInputResultConsumer;
        if (r3 == null) goto L14;
        r3.a(r1, r19, r20);
        return;
    L14:
        return;
    L13:
        return;
    L9:
        com.ss.android.lark.keyboard.plugin.tool.voice.c r5 = this._audioMessageDelegate;
        if (r5 == null) goto L16;
        r5.d(r19, r20, false);
        return;
    }

    public final void sendAudionWithTextMsg(String r19, RichText r20) {
        Intrinsics.checkNotNullParameter(r19, "content");
        Intrinsics.checkNotNullParameter(r20, "richText");
        Pair<String, List<SpeechRecognitionReportEditItem>> r0 = packReportEditItem(r19);
        String r7 = (String) r0.component1();
        List r6 = (List) r0.component2();
        ArrayList<UserInfoHitPoint> r4 = packAsrUserInfoList();
        String r2 = this.currentRecordSourceId;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04251(this, r2, r20, r4, r19, r6, r7, null), 2, null);
        dismissPopupWindow();
        if (this.isEnableVoiceInputSdk == false) goto L9;
        com.ss.android.lark.audio.voiceinput.s r1 = this._voiceRecordEntity;
        if (r1 == null) goto L13;
        s r3 = this._voiceInputResultConsumer;
        if (r3 == null) goto L14;
        r3.b(r1, r19, r20);
        return;
    L14:
        return;
    L13:
        return;
    L9:
        com.ss.android.lark.keyboard.plugin.tool.voice.c r5 = this._audioMessageDelegate;
        if (r5 == null) goto L16;
        r5.c(r19, r20);
        return;
    }

    public final void switchLanguage(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "languageName");
        Intrinsics.checkNotNullParameter(r9, "languageKey");
        this._immersivePerformance.c = true;
        this._userEditedAfterAsr = false;
        this._userClickedShowOriginal = false;
        q r2 = (q) CollectionsKt.lastOrNull(this._voiceInputDelegate.b);
        if (r2 == null) goto L5;
        r2.e = false;
    L5:
        MutableLiveData<Boolean> r3 = this._showOriginalButtonVisible;
        Boolean r4 = Boolean.FALSE;
        sob.c.e(r3, r4);
        sob.c.c(this._isAsrRecognizeFinish, r4);
        if (this.isEnableVoiceInputSdk == false) goto L17;
        VoiceInputDelegate r5 = this._voiceInputDelegate;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r9, "languageKey");
        if (r5.b.isEmpty() == true) goto L20;
        CopyOnWriteArrayList<q> r6 = r5.b;
        r6.subList(1, r6.size()).clear();
        r5.d.set(1);
        VoiceInputService r7 = r5.a;
        if (r7 == null) goto L20;
        q r10 = (q) CollectionsKt.firstOrNull(r5.b);
        if (r10 == null) goto L15;
        com.ss.android.lark.audio.voiceinput.s r11 = r10.a;
    L16:
        r7.f(r9, r11);
        goto L20
    L15:
        r11 = null;
    L20:
        this.isProgrammaticUpdate = true;
        sob.c.e(this._asrSessionState, AsrSessionState.AsrSessionSwitchLanguage);
        sob.d r12 = sob.d.a;
        String r13 = this.chatId;
        String r14 = this.currentRecordSourceId;
        Map<String, String> r15 = this.extraAnalyticParams;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "chatId");
        Intrinsics.checkNotNullParameter(r14, "sourceId");
        Intrinsics.checkNotNullParameter(r9, "languageKey");
        Intrinsics.checkNotNullParameter(r15, "extraAnalyticParams");
        sob.d.e("im_voice_input_more_click", r15, new Pair[]{new Pair("chat_id", r13), new Pair("source_id", r14), new Pair("click", "select_lng"), new Pair("location", "im_input_button"), new Pair("lan", r9)});
        return;
    L17:
        AudioRecordCoordinator r16 = this._audioRecordCoordinator;
        if (r16 == null) goto L20;
        r16.a(r9);
        goto L20
    }

    public static final /* synthetic */ AsrNerStatisticV2 access$calculateAsrResultV2(ImmersiveVoiceViewModel r0, RichText r1, ArrayList r2) {
        return r0.calculateAsrResultV2(r1, r2);
    }

    public static final /* synthetic */ void access$processSessionFinish(ImmersiveVoiceViewModel r0, String r1, com.ss.android.lark.audio.voiceinput.c r2) {
        r0.processSessionFinish(r1, r2);
    }

    private final com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c packAudioAsrResult2AsrRichTextResult(com.ss.android.lark.audio.voiceinput.c r11, SpannableStringBuilder r12, Boolean r13) {
        String r0 = null;
        if (r11 == null) goto L33;
        RichText r2 = r11.h;
        if (r2 != null) goto L7;
        return null;
    L7:
        if (r12 != null) goto L9;
        r12 = new SpannableStringBuilder();
    L9:
        SpannableStringBuilder r3 = r12;
        if (r13 == null) goto L12;
        boolean r14 = r13.booleanValue();
    L13:
        boolean r4 = r14;
        Boolean r5 = Boolean.valueOf(com.ss.android.lark.audio.voiceinput.b.c(r2));
        Intrinsics.checkNotNullParameter(r2, "richText");
        List r15 = r2.getElementIds();
        if (r15 == null) goto L32;
        RichText.RichTextElements r16 = r2.getElements();
        if (r16 == null) goto L32;
        Map r17 = r16.getDictionary();
        if (r17 == null) goto L32;
        String r18 = com.ss.android.lark.audio.voiceinput.b.a(r17, r15);
        if (r18 == null) goto L32;
        RichTextElement r19 = (RichTextElement) r17.get(r18);
        if (r19 == null) goto L32;
        RichTextElement.AtProperty r110 = r19.getProperty();
        if (r110 == null) goto L32;
        r0 = r110.getContent();
    L32:
        return new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c(r2, r3, r4, r5, r0, false, 32);
    L12:
        r14 = r11.d;
        goto L13
    L33:
        return null;
    }

    public final void advanceModeSendHitPoint(RichText r22, boolean r23, String r24) {
        Intrinsics.checkNotNullParameter(r22, "finalRichText");
        Intrinsics.checkNotNullParameter(r24, "editContent");
        if (this.isVoiceInputMarkdownFg == false) goto L5;
        sob.d r1 = sob.d.a;
        String r4 = this.chatId;
        String r15 = this.currentRecordSourceId;
        AsrNerStatisticV2 r0 = calculateAsrResultV2(r22, packAsrUserInfoList());
        Map<String, String> r5 = this.extraAnalyticParams;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "chatId");
        Intrinsics.checkNotNullParameter(r15, "sourceId");
        Intrinsics.checkNotNullParameter(r0, "asrNerStatistic");
        Intrinsics.checkNotNullParameter(r5, "extraAnalyticParams");
        JSONArray r2 = sob.d.c(r0);
        int r3 = AudioAsrLanguageSwitcher.i;
        sob.d.e("im_voice_advance_input_click", r5, new Pair[]{new Pair("source_id", r15), new Pair("click", "press_trans_text"), new Pair("user_info_list", r2), new Pair("accept_cnt", Integer.valueOf(r0.getAdoptionRate().getAcceptCount())), new Pair("sdk_result_cnt", Integer.valueOf(r0.getAdoptionRate().getAsrCount())), new Pair("is_result", Boolean.valueOf(r23)), new Pair("user_lng", AudioAsrLanguageSwitcher.a.a()), new Pair("chat_id", r4), new Pair("location", "im_input_button")});
    L6:
        Pair<String, List<SpeechRecognitionReportEditItem>> r6 = packReportEditItem(r24);
        String r7 = (String) r6.component1();
        List r8 = (List) r6.component2();
        VoiceInputDelegate r9 = this._voiceInputDelegate;
        int r10 = VoiceInputDelegate.p;
        r9.b(true);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r24, r8, r7, null), 2, null);
        return;
    L5:
        sob.d r16 = sob.d.a;
        String r11 = this.chatId;
        String r12 = this.currentRecordSourceId;
        sob.a r13 = calculateAsrResult(r22);
        Map<String, String> r17 = this.extraAnalyticParams;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r11, "chatId");
        Intrinsics.checkNotNullParameter(r12, "sourceId");
        Intrinsics.checkNotNullParameter(r13, "asrNerStatistic");
        Intrinsics.checkNotNullParameter(r17, "extraAnalyticParams");
        JSONArray r14 = sob.d.b(r13);
        int r18 = AudioAsrLanguageSwitcher.i;
        sob.d.e("im_voice_advance_input_click", r17, new Pair[]{new Pair("source_id", r12), new Pair("click", "press_trans_text"), new Pair("user_info_list", r14), new Pair("search_cnt", Integer.valueOf(r13.b.getSearchCount())), new Pair("asr_cnt", Integer.valueOf(r13.b.getAsrCount())), new Pair("is_result", Boolean.valueOf(r23)), new Pair("user_lng", AudioAsrLanguageSwitcher.a.a()), new Pair("chat_id", r11), new Pair("location", "im_input_button")});
        goto L6
    }

    public final void cancelAsrTimeOut(final CancelAsrTimeoutState r5, final boolean r6, final boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "cancelingState");
        cancelAsrWaitingTips();
        if (this.isEnableVoiceInputSdk == false) goto L7;
        VoiceInputDelegate r0 = this._voiceInputDelegate;
        Function0<Unit> r1 = new C04141(r7, r6, this, r5);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "cancelByReset");
        VoiceInputService r8 = r0.a;
        if (r8 == null) goto L23;
        r8.b(r5, r6, r1);
        Unit r9 = Unit.INSTANCE;
        return;
    L23:
        return;
    L7:
        Job r2 = this.asrTimeOutChecker;
        if (r2 == null) goto L21;
        Log.i(TAG, "cancelAsrTimeOut by " + r5.info());
        boolean r3 = true;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
        if (r7 == false) goto L14;
        if (r6 == false) goto L13;
        sob.c.e(this._asrSessionState, AsrSessionState.AsrSessionEndWithTextTimeout);
        goto L14
    L13:
        sob.c.e(this._asrSessionState, AsrSessionState.AsrSessionEndNoTextTimeout);
    L14:
        safeClearLoading();
        if (r5 == CancelAsrTimeoutState.CancelByReset) goto L21;
        sob.c.c(this._isAsrRecognizeFinish, Boolean.TRUE);
        this._immersivePerformance.a();
        int r10 = VoiceInputAppreciablePerformance.a;
        if (r5 == CancelAsrTimeoutState.CancelByFinish) goto L20;
        r3 = false;
    L20:
        VoiceInputAppreciablePerformance.e(r3, r6, r5.info());
    L21:
        this.asrTimeOutChecker = null;
    }

    public boolean startVoiceRecord(p r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r20, "voiceInputModeWithScene");
        Intrinsics.checkNotNullParameter(r21, "asrLocale");
        if (this.isEnableVoiceInputSdk == true) goto L5;
    L13:
        MutableLiveData<Boolean> r3 = this._isAsrRecognizeFinish;
        Boolean r9 = Boolean.FALSE;
        sob.c.c(r3, r9);
        this._isCancelingSession = false;
        this._userEditedAfterAsr = false;
        this._userClickedShowOriginal = false;
        sob.c.e(this._asrNeedRetry, r9);
        String r10 = "";
        if (r20.a == VoiceInputMode.SecondVoice) goto L16;
        sob.c.e(this.beforeInsetSelection, new Pair(0, 0));
        sob.c.e(this.insertPeriod, "");
        sob.c.e(this.insertPeriodRichText, new RichText());
        sob.c.e(this.asrResultRichText, new com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c(new RichText(), new SpannableStringBuilder(), false, null, null, false, 56));
    L16:
        this.currentRecordSourceId = "";
        if (this.isEnableVoiceInputSdk == false) goto L19;
        boolean r2 = this._voiceInputDelegate.g(r20, r21, r22);
    L20:
        if (r2 == true) goto L24;
        Log.e(TAG, "startRecord failed.voiceInputMode" + r20.a.info());
        return false;
    L24:
        if (this.isEnableVoiceInputSdk == false) goto L33;
        VoiceInputService r4 = this._voiceInputDelegate.a;
        if (r4 == null) goto L30;
        VoiceDataProcessDispatcher r5 = r4.c;
        if (r5 == null) goto L30;
        String r6 = r5.i();
    L31:
        if (r6 == null) goto L49;
    L48:
        r10 = r6;
    L49:
        this.currentRecordSourceId = r10;
        sob.c.e(this._asrSessionState, AsrSessionState.AsrSessionRecording);
        this.isProgrammaticUpdate = true;
        this._voiceInputMode = r20;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04261(this, null), 2, null);
        return true;
    L30:
        r6 = null;
        goto L31
    L33:
        AudioRecordCoordinator r7 = this._audioRecordCoordinator;
        if (r7 == null) goto L45;
        AudioRecordDataProcessor r8 = r7.a;
        if (r8 == null) goto L42;
        AudioRecordDataProcessor.RecognizeWithUploadAudioDataConsumer r11 = r8.k;
        if (r11 == null) goto L41;
        r6 = r11.c;
        if (r6 == null) goto L41;
    L43:
        if (r6 != null) goto L46;
        r6 = "";
    L46:
        if (r6 != null) goto L48;
    L41:
        r6 = "";
        goto L43
    L42:
        r6 = null;
        goto L43
    L45:
        r6 = null;
        goto L46
    L19:
        r2 = startVoiceRecordV1Impl(r20, r21);
        goto L20
    L5:
        if (getImmersiveVoiceMode().b() == false) goto L13;
        if (this.autoSendOnRecognizeFinish == false) goto L13;
        if (this.hidePopupOnReleaseKeepSession == false) goto L13;
        if (isSessionRunning() == false) goto L13;
        Log.i(TAG, "cancel previous asr session before start new");
        this.keepSessionOnNextPopupHide = false;
        cancelVoiceRecord();
        dismissPopupWindow();
        resetLiveData$default(this, false, 1, null);
        goto L13
    }

    public final void whenClickCancel(boolean r13, RichText r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "richText");
        Intrinsics.checkNotNullParameter(r15, "content");
        ArrayList<UserInfoHitPoint> r5 = packAsrUserInfoList();
        String r3 = this.currentRecordSourceId;
        dismissPopupWindow();
        cancelAsrTimeOut(CancelAsrTimeoutState.CancelByClickCancel, r13, false);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04291(this, r3, r14, r5, r15, null), 2, null);
    }

    private final void initWithCoordinator(x r11, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.w r12, qob.a r13, com.ss.android.lark.audio.voiceinput.h r14) {
        AudioRecordCoordinator r15 = new AudioRecordCoordinator(r11.b, r11.a, this.isSupportPartialUpload, r13, r12.d.b.toString(), r12.e, true, true, new C04181(this));
        this._audioRecordCoordinator = r15;
        this._audioRecordDelegate = r15.d.w;
        this._audioMessageDelegate = r15.e;
        this._speechRecognitionStatusPush = r11.c;
        this._audioResourceMutex = r14;
    }

    private final void initWithVoiceInputService(final x r26, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.w r27, com.ss.android.lark.audio.voiceinput.h r28, s r29) {
        String r3 = r27.g;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        VoiceInputDelegate r4 = this._voiceInputDelegate;
        CoroutineScope r5 = ViewModelKt.getViewModelScope(this);
        IAudioService r6 = r26.a;
        com.ss.android.lark.audio.voiceinput.service.l r7 = r26.b;
        com.ss.android.lark.audio.voiceinput.service.o r8 = r26.c;
        String r10 = r27.c;
        r4.e(r5, r6, r7, r8, r28, r10, r3, r27.d.b.toString(), r27.e, this.isAsrEnable, this.isAsrNerEnable, com.ss.android.lark.keyboard.plugin.tool.voice.utils.b.b(), this.isSupportPartialUpload, this._voiceRecordListener, this._voiceDataAsrListener, this._vcMeetingStatusListener, new C04191(r26), new C04202(r26), r27.r, r27.t);
        this._voiceInputResultConsumer = r29;
    }

    public static /* synthetic */ void resetLiveData$default(ImmersiveVoiceViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.resetLiveData(r1);
    }

    public final void init(final x r17, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.w r18, com.ss.android.lark.audio.voiceinput.h r19, s r20) {
        Intrinsics.checkNotNullParameter(r17, "voiceInputDependency");
        Intrinsics.checkNotNullParameter(r18, "voiceInputConfig");
        Intrinsics.checkNotNullParameter(r19, "recordMutex");
        String r4 = r18.g;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        this.chatId = r4;
        this.hitPointPageScene = r18.o;
        this.extraAnalyticParams = r18.p;
        boolean r5 = r18.b;
        this.isAsrNerEnable = r5;
        if (this.isEnableVoiceInputSdk == false) goto L9;
        initWithVoiceInputService(r17, r18, r19, r20);
        return;
    L9:
        if (r17.g == null) goto L28;
        if (r5 == false) goto L26;
        CoroutineScope r8 = ViewModelKt.getViewModelScope(this);
        String r9 = this.chatId;
        if (r9.length() != 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
        MatchMode r7 = MatchMode.ServerMode;
    L18:
        MatchMode r14 = r7;
        if (isEnterpriseAnswerScene() == false) goto L21;
    L24:
        boolean r15 = true;
    L25:
        this._asrUserInfoMathStrategy = new UserSearchAndMatchStrategy(r8, r9, new C04171(r17), new AnonymousClass2(r17), new AnonymousClass3(this), new AnonymousClass4(r17), r14, r15);
    L27:
        initWithCoordinator(r17, r18, r17.g, r19);
        return;
    L21:
        if (isCcmCommentScene() == true) goto L24;
        r15 = false;
        goto L25
    L17:
        r7 = MatchMode.ServerWithClientMode;
        goto L18
    L14:
        r6 = false;
        goto L15
    L26:
        Log.i(TAG, "initAsrNerStrategy: not enable asr ner");
        goto L27
    L28:
        Log.w(TAG, "initWithCoordinator:oldIAudioDataProcessorDependency is null");
        initWithVoiceInputService(r17, r18, r19, r20);
    }

    private final void submitAsrEditReportIfNeed(String r6, String r7, List<SpeechRecognitionReportEditItem> r8, SpeechRecognitionReportEditRequest.Scene r9, String r10) {
        boolean r0 = false;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == true) goto L39;
        if (r7 != null) goto L13;
    L14:
        r0 = true;
    L15:
        if (r0 == true) goto L39;
        SpeechRecognitionReportEditRequest.Builder r1 = new SpeechRecognitionReportEditRequest.Builder();
        if (KeyboardVoiceFGUtils.a.f() == false) goto L22;
        if (r8 == null) goto L37;
        r1.items(r8);
    L37:
        r1.text_edit(r7).scene(r9).text_init(r10);
        SdkSender.sendPassThroughRequest(Command.SPEECH_RECOGNITION_REPORT_EDIT, r1, new C04272(), g.a);
        return;
    L22:
        if (this.isEnableVoiceInputSdk == false) goto L24;
        String r11 = this._voiceInputDelegate.d();
    L29:
        StringBuilder r3 = new StringBuilder("[submitAsrEditReportIfNeed] sourceId:");
        r3.append(r11);
        r3.append(" origin:");
        Integer r4 = null;
        if (r6 == null) goto L32;
        Integer r5 = Integer.valueOf(r6.length());
    L33:
        r3.append(r5);
        r3.append(" edited:");
        if (r7 == null) goto L36;
        r4 = Integer.valueOf(r7.length());
    L36:
        r3.append(r4);
        Log.i(TAG, r3.toString());
        r1.source_id(r11).text_origin(r6);
        goto L37
    L32:
        r5 = null;
        goto L33
    L24:
        com.ss.android.lark.keyboard.plugin.tool.voice.c r12 = this._audioMessageDelegate;
        if (r12 == null) goto L28;
        r11 = r12.a();
        if (r11 != null) goto L29;
    L28:
        r11 = "";
        goto L29
    L13:
        if (r7.length() != 0) goto L15;
    L39:
        Log.w(TAG, "[submitAsrEditReportIfNeed] asrResult or editedAsrResult is empty");
        return;
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public static final /* synthetic */ void access$submitAsrEditReportIfNeed(ImmersiveVoiceViewModel r0, String r1, String r2, List r3, SpeechRecognitionReportEditRequest.Scene r4, String r5) {
        r0.submitAsrEditReportIfNeed(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void cancelAsrTimeOut$default(ImmersiveVoiceViewModel r0, CancelAsrTimeoutState r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = true;
    L5:
        r0.cancelAsrTimeOut(r1, r2, r3);
    }

    public static /* synthetic */ com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.c packAudioAsrResult2AsrRichTextResult$default(ImmersiveVoiceViewModel r1, com.ss.android.lark.audio.voiceinput.c r2, SpannableStringBuilder r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.packAudioAsrResult2AsrRichTextResult(r2, r3, r4);
    }

    public final void submitFeedback(String r17, List<String> r18, List<String> r19, String r20, Function0<Unit> r21, Function1<? super ErrorResult, Unit> r22) {
        Intrinsics.checkNotNullParameter(r17, "inputDesc");
        Intrinsics.checkNotNullParameter(r18, "descriptionList");
        Intrinsics.checkNotNullParameter(r19, "reasonIdtList");
        Intrinsics.checkNotNullParameter(r20, "clientResult");
        Intrinsics.checkNotNullParameter(r21, "onSuccess");
        Intrinsics.checkNotNullParameter(r22, "onError");
        sob.d r1 = sob.d.a;
        String r7 = this.chatId;
        String r9 = this.currentRecordSourceId;
        if (r17.length() <= 0) goto L5;
        boolean r10 = true;
    L6:
        Map<String, String> r13 = this.extraAnalyticParams;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "chatId");
        Intrinsics.checkNotNullParameter(r9, "sourceId");
        Intrinsics.checkNotNullParameter(r19, "reasonIds");
        Intrinsics.checkNotNullParameter(r13, "extraAnalyticParams");
        Iterator<T> r0 = r19.iterator();
        String r2 = "";
    L8:
        if (r0.hasNext() == false) goto L12;
        String r14 = sob.d.b.get((String) r0.next());
        if (r14 == null) goto L8;
        r2 = r2 + r14 + ',';
        goto L8
    L12:
        Pair[] r3 = new Pair[6];
        r3[0] = new Pair("chat_id", r7);
        r3[1] = new Pair("source_id", r9);
        r3[2] = new Pair("click", "submit");
        r3[3] = new Pair("location", "im_input_button");
        r3[4] = new Pair("feedback_class", r2);
        if (r10 == false) goto L15;
        String r8 = "true";
    L16:
        r3[5] = new Pair("more_info", r8);
        sob.d.e("im_voice_input_feedback_click", r13, r3);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04281(this, r18, r17, r20, r21, r22, null), 2, null);
        return;
    L15:
        r8 = "false";
        goto L16
    L5:
        r10 = false;
        goto L6
    }

    public static /* synthetic */ void init$default(ImmersiveVoiceViewModel r0, x r1, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.w r2, com.ss.android.lark.audio.voiceinput.h r3, s r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.init(r1, r2, r3, r4);
    }

    public static /* synthetic */ void initWithVoiceInputService$default(ImmersiveVoiceViewModel r0, x r1, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.w r2, com.ss.android.lark.audio.voiceinput.h r3, s r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.initWithVoiceInputService(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void submitAsrEditReportIfNeed$default(ImmersiveVoiceViewModel r6, String r7, String r8, List r9, SpeechRecognitionReportEditRequest.Scene r10, String r11, int r12, Object r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = null;
    L5:
        r6.submitAsrEditReportIfNeed(r7, r8, r9, r10, r11);
    }
}
