package com.larus.bmhome.view.actionbar.edit;

import android.net.Uri;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.bmhome.actionbar.model.h1;
import com.larus.bmhome.actionbar.model.i0;
import com.larus.bmhome.actionbar.model.m0;
import com.larus.bmhome.actionbar.model.p1;
import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.actionbar.model.t1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.actionbar.model.y;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.trace.ChatRenderTrace;
import com.larus.bmhome.chat.trace.ReeditType;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.instruction.w1;
import com.larus.bmhome.instruction.z1;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.kmp.chat.TemplateInfo;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import od8.h0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ±\u00032\u00020\u00012\u00020\u0002:\u0002±\u0003B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u0012H\u0016J\"\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u0014H\u0016J\u0019\u0010ó\u0001\u001a\u00020\u000e2\u000e\u0010ô\u0001\u001a\t\u0012\u0004\u0012\u00020\u001a0Ü\u0001H\u0016J\u001c\u0010\u0081\u0002\u001a\u00020\u000e2\u0011\u0010\u0082\u0002\u001a\f\u0012\u0005\u0012\u00030\u0099\u0001\u0018\u00010\u0098\u0001H\u0016J\u0012\u0010\u0086\u0002\u001a\u00020\u000e2\u0007\u0010\u0087\u0002\u001a\u00020\u001aH\u0016J\u0012\u0010\u0088\u0002\u001a\u00020\u000e2\u0007\u0010\u0089\u0002\u001a\u00020\u001aH\u0016J)\u0010 \u0002\u001a\u00020\u000e2\u0015\u0010¡\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u0001022\u0007\u0010¢\u0002\u001a\u00020\u0014H\u0016J\u0015\u0010£\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u000102J\u0012\u0010µ\u0002\u001a\u00020\u000e2\u0007\u0010¶\u0002\u001a\u00020\u001aH\u0016J\u0014\u0010·\u0002\u001a\u00020\u000e2\t\u0010¸\u0002\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010¹\u0002\u001a\u00020\u000e2\u0007\u0010º\u0002\u001a\u00020\u001aH\u0016J\t\u0010»\u0002\u001a\u00020\u000eH\u0016J\u0012\u0010¼\u0002\u001a\u00020\u000e2\u0007\u0010½\u0002\u001a\u00020\u001aH\u0016J\u0012\u0010¾\u0002\u001a\u00020\u000e2\u0007\u0010¿\u0002\u001a\u00020\u001aH\u0016J\u0012\u0010Â\u0002\u001a\u00020\u000e2\u0007\u0010Ã\u0002\u001a\u00020\u001aH\u0002J\u0012\u0010Ê\u0002\u001a\u00020\u000e2\u0007\u0010¿\u0002\u001a\u00020\u001aH\u0016Ja\u0010Ë\u0002\u001a\u00020\u000e2\b\u0010Ì\u0002\u001a\u00030¥\u00022\t\u0010Í\u0002\u001a\u0004\u0018\u00010\u00122\u0007\u0010Î\u0002\u001a\u00020&2\t\u0010Ï\u0002\u001a\u0004\u0018\u00010\u00142\n\u0010Ð\u0002\u001a\u0005\u0018\u00010Ñ\u00022\t\u0010Ò\u0002\u001a\u0004\u0018\u00010&2\u0010\u0010Ó\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010Ü\u0001H\u0016¢\u0006\u0003\u0010Ô\u0002J\u001c\u0010Õ\u0002\u001a\u00020\u000e2\b\u0010Ö\u0002\u001a\u00030×\u00022\u0007\u0010Ø\u0002\u001a\u00020\u001aH\u0016J\u0012\u0010Ù\u0002\u001a\u00020\u000e2\u0007\u0010Ú\u0002\u001a\u00020hH\u0016J\u0012\u0010Û\u0002\u001a\u00020\u000e2\u0007\u0010\u0089\u0002\u001a\u00020\u001aH\u0016JZ\u0010Ý\u0002\u001a\u00020\u000e2\u0007\u0010Þ\u0002\u001a\u00020\u001a2\u0007\u0010ß\u0002\u001a\u00020\u001a2\u0007\u0010à\u0002\u001a\u00020\u001a2\u0019\u0010á\u0002\u001a\u0014\u0012\u0004\u0012\u00020&0È\u0001j\t\u0012\u0004\u0012\u00020&`É\u00012\u0007\u0010â\u0002\u001a\u00020\u001a2\u0007\u0010ã\u0002\u001a\u00020\u001a2\u0007\u0010ä\u0002\u001a\u00020&H\u0016J\u0013\u0010å\u0002\u001a\u00020\u000e2\b\u0010æ\u0002\u001a\u00030¢\u0001H\u0016J\u001c\u0010å\u0002\u001a\u00020\u000e2\u0007\u0010ç\u0002\u001a\u00020&2\b\u0010æ\u0002\u001a\u00030¢\u0001H\u0016J\u001c\u0010è\u0002\u001a\u00020\u001a2\u0007\u0010ç\u0002\u001a\u00020&2\b\u0010æ\u0002\u001a\u00030¢\u0001H\u0016J\u0013\u0010é\u0002\u001a\u00020\u001a2\b\u0010æ\u0002\u001a\u00030¢\u0001H\u0016J\u0013\u0010ê\u0002\u001a\u00020\u000e2\b\u0010æ\u0002\u001a\u00030¢\u0001H\u0016J\u0013\u0010ë\u0002\u001a\u00020\u000e2\b\u0010æ\u0002\u001a\u00030¢\u0001H\u0016J\u0012\u0010ì\u0002\u001a\u00020\u000e2\u0007\u0010í\u0002\u001a\u00020&H\u0016J\t\u0010î\u0002\u001a\u00020\u001aH\u0016J\u001a\u0010ï\u0002\u001a\u00020\u000e2\u000f\u0010ð\u0002\u001a\n\u0012\u0005\u0012\u00030\u0099\u00010\u0098\u0001H\u0016J\t\u0010ñ\u0002\u001a\u00020\u000eH\u0016J$\u0010ò\u0002\u001a\u00020\u000e2\u0007\u0010ó\u0002\u001a\u00020{2\u0007\u0010í\u0002\u001a\u00020&2\u0007\u0010ô\u0002\u001a\u00020\u0014H\u0016J\u0014\u0010õ\u0002\u001a\u00020\u000e2\t\u0010ö\u0002\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010÷\u0002\u001a\u00020\u000e2\u0007\u0010¶\u0002\u001a\u00020&2\u0012\b\u0002\u0010Ó\u0002\u001a\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010Ü\u0001J\t\u0010ø\u0002\u001a\u00020\u000eH\u0002J\u0014\u0010ù\u0002\u001a\u00020\u000e2\t\u0010ú\u0002\u001a\u0004\u0018\u00010AH\u0016J\u0012\u0010û\u0002\u001a\u00020\u000e2\u0007\u0010¶\u0002\u001a\u00020&H\u0016J\u0015\u0010ü\u0002\u001a\u00020\u000e2\n\u0010ý\u0002\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J!\u0010þ\u0002\u001a\u00020\u000e2\n\u0010ÿ\u0002\u001a\u0005\u0018\u00010\u0080\u00032\n\u0010\u0081\u0003\u001a\u0005\u0018\u00010\u0082\u0003H\u0016J\u0014\u0010\u0083\u0003\u001a\u00020\u000e2\t\u0010\u0084\u0003\u001a\u0004\u0018\u00010sH\u0016J\u0015\u0010\u0085\u0003\u001a\u00020\u000e2\n\u0010\u0086\u0003\u001a\u0005\u0018\u00010\u0082\u0001H\u0016J\u0015\u0010\u0087\u0003\u001a\u00020\u000e2\n\u0010ý\u0002\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J\u0013\u0010\u0088\u0003\u001a\u00020\u000e2\b\u0010\u0089\u0003\u001a\u00030\u008f\u0001H\u0016J\u0013\u0010\u008a\u0003\u001a\u00020\u000e2\b\u0010\u0089\u0003\u001a\u00030°\u0001H\u0016J\t\u0010\u008b\u0003\u001a\u00020\u000eH\u0016J\t\u0010\u008c\u0003\u001a\u00020\u000eH\u0016J\t\u0010\u008d\u0003\u001a\u00020\u000eH\u0016J\u0012\u0010\u008e\u0003\u001a\u00020\u000e2\u0007\u0010\u008f\u0003\u001a\u00020\u0014H\u0016J\u001d\u0010\u0090\u0003\u001a\u00020\u000e2\t\u0010\u0091\u0003\u001a\u0004\u0018\u00010\u00142\u0007\u0010\u0092\u0003\u001a\u00020\u0014H\u0016J\u000b\u0010\u0093\u0003\u001a\u0004\u0018\u00010\u0014H\u0016J\u0013\u0010\u0094\u0003\u001a\u00020\u000e2\b\u0010\u0095\u0003\u001a\u00030\u0094\u0002H\u0016J\u0019\u0010\u0097\u0003\u001a\u00020\u000e2\u0007\u0010\u0098\u0003\u001a\u00020\u00142\u0007\u0010\u0099\u0003\u001a\u00020\u0014J\u0013\u0010\u009a\u0003\u001a\u0005\u0018\u00010¥\u00022\u0007\u0010\u0098\u0003\u001a\u00020\u0014J\u001e\u0010 \u0003\u001a\u00020\u000e2\u0007\u0010¡\u0003\u001a\u00020&2\n\u0010¢\u0003\u001a\u0005\u0018\u00010\u009c\u0003H\u0016J\u001d\u0010£\u0003\u001a\u0004\u0018\u00010\u00142\u0007\u0010¡\u0003\u001a\u00020&2\u0007\u0010¤\u0003\u001a\u00020&H\u0016J\u0013\u0010¥\u0003\u001a\u00020\u000e2\b\u0010æ\u0002\u001a\u00030¢\u0001H\u0016J\u001a\u0010ª\u0003\u001a\u00020\u000e2\u000f\u0010«\u0003\u001a\n\u0012\u0005\u0012\u00030§\u00030\u0098\u0001H\u0016J\u0012\u0010¬\u0003\u001a\u00020\u001a2\u0007\u0010í\u0002\u001a\u00020&H\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001e\u0010%\u001a\u0004\u0018\u00010&X\u0096\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010,\u001a\u0004\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0002\b\u0003\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0002\b\u0003\u0018\u0001028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\u00120:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010.\"\u0004\b=\u00100R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010B\u001a\u0004\u0018\u00010A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020&0FX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020&0HX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020&0LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010M\u001a\b\u0012\u0004\u0012\u00020&0N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0014\u0010Q\u001a\b\u0012\u0004\u0012\u00020&0FX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\b\u0012\u0004\u0012\u00020&0HX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010JR\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001a0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u001a0HX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010JR\u0016\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010PR\u0014\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u001a0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001a0HX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010JR\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001a0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020\u001a0NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010PR\u0014\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000e0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\u000e0NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010PR\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020d0LX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020d0NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010PR\u0014\u0010g\u001a\b\u0012\u0004\u0012\u00020h0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020h0NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010PR\u0014\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00140LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00140NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010PR\u0014\u0010n\u001a\b\u0012\u0004\u0012\u00020o0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020o0NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010PR\u0014\u0010r\u001a\b\u0012\u0004\u0012\u00020s0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020s0NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010PR\u0016\u0010v\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010PR&\u0010y\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00140z0LX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010|\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020{\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00140z0NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010PR\u0014\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00140LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u00140N¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010PR\u0016\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010PR\u0015\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010PR\u0015\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010PR\u0015\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010PR\u0018\u0010\u008e\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u008f\u00010LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0090\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u008f\u00010NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010PR\"\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001d\u0010\u0097\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0099\u00010\u0098\u00010LX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u009a\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u0099\u00010\u0098\u00010NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009b\u0001\u0010PR)\u0010\u009c\u0001\u001a\f\u0012\u0005\u0012\u00030\u0099\u0001\u0018\u00010\u0098\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R%\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u0001X\u0096\u000e¢\u0006\u0015\n\u0003\u0010§\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\"\u0010©\u0001\u001a\u00020\u001a2\u0007\u0010¨\u0001\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001R\u0015\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b®\u0001\u0010PR\u0018\u0010¯\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010°\u00010LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010±\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010°\u00010NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b²\u0001\u0010PR\"\u0010³\u0001\u001a\u0005\u0018\u00010°\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0001\u0010µ\u0001\"\u0006\b¶\u0001\u0010·\u0001R#\u0010¸\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030º\u0001\u0012\u0004\u0012\u00020\u001a0¹\u00010LX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010»\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030º\u0001\u0012\u0004\u0012\u00020\u001a0¹\u00010NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b¼\u0001\u0010PR\u001b\u0010½\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140¾\u0001¢\u0006\n\n\u0000\u001a\u0006\b¿\u0001\u0010À\u0001R\u0015\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0HX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bÃ\u0001\u0010JR\u0015\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0H¢\u0006\t\n\u0000\u001a\u0005\bÆ\u0001\u0010JR'\u0010Ç\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020&0È\u0001j\t\u0012\u0004\u0012\u00020&`É\u00010FX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010Ê\u0001\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020&0È\u0001j\t\u0012\u0004\u0012\u00020&`É\u00010HX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bË\u0001\u0010JR\u0015\u0010Ì\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020\u001a0HX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bÎ\u0001\u0010JR\u0016\u0010Ï\u0001\u001a\t\u0012\u0005\u0012\u00030Ð\u00010LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010Ñ\u0001\u001a\t\u0012\u0005\u0012\u00030Ð\u00010NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bÒ\u0001\u0010PR%\u0010Ó\u0001\u001a\u0005\u0018\u00010¢\u0001X\u0096\u000e¢\u0006\u0015\n\u0003\u0010§\u0001\u001a\u0006\bÔ\u0001\u0010¤\u0001\"\u0006\bÕ\u0001\u0010¦\u0001R,\u0010Ö\u0001\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0005\u0012\u00030¢\u00010×\u0001X\u0096\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bØ\u0001\u00105\"\u0006\bÙ\u0001\u0010Ú\u0001R(\u0010Û\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001a\u0018\u00010Ü\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001R\u0018\u0010á\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010â\u00010FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010ã\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010â\u00010HX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bä\u0001\u0010JR%\u0010å\u0001\u001a\u0005\u0018\u00010¢\u0001X\u0096\u000e¢\u0006\u0015\n\u0003\u0010§\u0001\u001a\u0006\bæ\u0001\u0010¤\u0001\"\u0006\bç\u0001\u0010¦\u0001R\u0018\u0010è\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010â\u00010FX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010é\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010â\u00010FX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\bê\u0001\u0010ë\u0001R%\u0010ì\u0001\u001a\u0005\u0018\u00010¢\u0001X\u0096\u000e¢\u0006\u0015\n\u0003\u0010§\u0001\u001a\u0006\bí\u0001\u0010¤\u0001\"\u0006\bî\u0001\u0010¦\u0001R\u0016\u0010ï\u0001\u001a\t\u0012\u0005\u0012\u00030ð\u00010LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010ñ\u0001\u001a\t\u0012\u0005\u0012\u00030ð\u00010NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bò\u0001\u0010PR(\u0010õ\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001a\u0018\u00010Ü\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bö\u0001\u0010Þ\u0001\"\u0006\b÷\u0001\u0010à\u0001R5\u0010ø\u0001\u001a\u0018\u0012\u0005\u0012\u00030¢\u0001\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010ù\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bú\u0001\u0010û\u0001\"\u0006\bü\u0001\u0010ý\u0001R\u0019\u0010þ\u0001\u001a\f\u0012\u0005\u0012\u00030\u0099\u0001\u0018\u00010\u0098\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010ÿ\u0001\u001a\f\u0012\u0005\u0012\u00030\u0099\u0001\u0018\u00010\u0098\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0080\u0002\u0010\u009e\u0001R\u000f\u0010\u0083\u0002\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0084\u0002\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0085\u0002\u0010«\u0001R\u0015\u0010\u008a\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u008b\u0002\u001a\b\u0012\u0004\u0012\u00020\u00140N¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0002\u0010PR%\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u00142\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0014@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0002\u0010\u0016R\u0017\u0010\u008f\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0090\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0002\u0010PR\u0011\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0093\u0002\u001a\t\u0012\u0005\u0012\u00030\u0094\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0095\u0002\u001a\t\u0012\u0005\u0012\u00030\u0094\u00020NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0002\u0010PR\"\u0010\u0097\u0002\u001a\u0005\u0018\u00010\u0094\u0002X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0002\u0010\u0099\u0002\"\u0006\b\u009a\u0002\u0010\u009b\u0002R%\u0010\u009c\u0002\u001a\u0004\u0018\u00010\u00142\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0014@BX\u0086\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u009d\u0002\u0010\u0016R>\u0010\u009e\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u0001022\u0015\u0010¨\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u000102@BX\u0082\u000e¢\u0006\n\n\u0000\"\u0006\b\u009f\u0002\u0010Ú\u0001R\"\u0010¤\u0002\u001a\u0005\u0018\u00010¥\u0002X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0002\u0010§\u0002\"\u0006\b¨\u0002\u0010©\u0002R'\u0010ª\u0002\u001a\u0004\u0018\u00010&2\t\u0010¨\u0001\u001a\u0004\u0018\u00010&@BX\u0086\u000e¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\b«\u0002\u0010(R'\u0010¬\u0002\u001a\u0004\u0018\u00010&2\t\u0010¨\u0001\u001a\u0004\u0018\u00010&@BX\u0086\u000e¢\u0006\u000b\n\u0002\u0010+\u001a\u0005\b\u00ad\u0002\u0010(R\"\u0010®\u0002\u001a\u00020\u001a2\u0007\u0010¨\u0001\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b¯\u0002\u0010«\u0001R\"\u0010°\u0002\u001a\u00020\u001a2\u0007\u0010¨\u0001\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b±\u0002\u0010«\u0001R\u001f\u0010²\u0002\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b²\u0002\u0010«\u0001\"\u0006\b³\u0002\u0010´\u0002R\"\u0010À\u0002\u001a\u00020\u001a2\u0007\u0010¨\u0001\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0002\u0010«\u0001R\u0015\u0010Ä\u0002\u001a\b\u0012\u0004\u0012\u00020\u001a0LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010Å\u0002\u001a\u0004\u0018\u00010\u001a8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÆ\u0002\u0010\u001bR\u0013\u0010Ç\u0002\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u001c\u0010È\u0002\u001a\b\u0012\u0004\u0012\u00020\u001a0NX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\bÉ\u0002\u0010PR\u000f\u0010Ü\u0002\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0096\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0007\u0012\u0005\u0018\u00010¥\u00020×\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u009b\u0003\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0005\u0012\u00030\u009c\u00030×\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u009d\u0003\u001a\t\u0012\u0005\u0012\u00030¢\u00010FX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u009e\u0003\u001a\t\u0012\u0005\u0012\u00030¢\u00010HX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009f\u0003\u0010JR\u001d\u0010¦\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030§\u00030\u0098\u00010FX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010¨\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0005\u0012\u00030§\u00030\u0098\u00010HX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b©\u0003\u0010JR\u001e\u0010\u00ad\u0003\u001a\t\u0012\u0004\u0012\u00020\u000e0®\u0003X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¯\u0003\u0010°\u0003¨\u0006²\u0003"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/InstructionEditorViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "<init>", "()V", "getCurrentViewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "setChatParam", "(Lcom/larus/bmhome/chat/ChatParam;)V", "bindChatParam", "", "chatContext", "bindChatUsuallyStateConf", "instructionUsuallyStateConf", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionConf;", "actionBarName", "", "getActionBarName", "()Ljava/lang/String;", "setActionBarName", "(Ljava/lang/String;)V", "isCreationActionBar", "", "()Ljava/lang/Boolean;", "setCreationActionBar", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "actionBarType", "getActionBarType", "setActionBarType", "templateType", "getTemplateType", "setTemplateType", "instructionType", "", "getInstructionType", "()Ljava/lang/Integer;", "setInstructionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "instructionRebuildStateConf", "getInstructionRebuildStateConf", "()Lcom/larus/bmhome/actionbar/model/ActionBarInstructionConf;", "setInstructionRebuildStateConf", "(Lcom/larus/bmhome/actionbar/model/ActionBarInstructionConf;)V", "_instructionDefaultParams", "", "instructionDefaultParams", "getInstructionDefaultParams", "()Ljava/util/Map;", "currentInstructionUsuallyConfig", "getCurrentInstructionUsuallyConfig", "setCurrentInstructionUsuallyConfig", "instructionUsuallyStateConfList", "", "currentInstructionConf", "getCurrentInstructionConf", "setCurrentInstructionConf", "setCurrentInstructionConfig", "conf", "_instructionReferenceImage", "Lcom/larus/bmhome/view/AttachmentInfo;", "instructionReferenceImage", "getInstructionReferenceImage", "()Lcom/larus/bmhome/view/AttachmentInfo;", "_instructionSelectMenuPosition", "Lkotlinx/coroutines/flow/MutableStateFlow;", "instructionSelectMenuPosition", "Lkotlinx/coroutines/flow/StateFlow;", "getInstructionSelectMenuPosition", "()Lkotlinx/coroutines/flow/StateFlow;", "_instructionEditorViewStatus", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "instructionEditorViewStatus", "Lkotlinx/coroutines/flow/SharedFlow;", "getInstructionEditorViewStatus", "()Lkotlinx/coroutines/flow/SharedFlow;", "_instructionReferenceImageUploadStatus", "instructionReferenceImageUploadStatus", "getInstructionReferenceImageUploadStatus", "_chosenAvatarInstructionStatus", "chosenAvatarInstructionStatus", "getChosenAvatarInstructionStatus", "_chosenAvatarInstructionFlow", "chosenAvatarInstructionFlow", "getChosenAvatarInstructionFlow", "_avatarSelectFlow", "avatarSelectedFlow", "getAvatarSelectedFlow", "_avatarBtnClickFlow", "avatarBtnClickFlow", "getAvatarBtnClickFlow", "_avatarBtnCancelFlow", "avatarBtnCancelFlow", "getAvatarBtnCancelFlow", "_actionBarInstructionChanged", "Lcom/larus/bmhome/instruction/core/model/InstructionWithInputData;", "actionBarInstructionChanged", "getActionBarInstructionChanged", "_instructionTabSelected", "Lcom/larus/bmhome/actionbar/model/ActionBarSwitchTabSelectorTemplate;", "instructionTabSelected", "getInstructionTabSelected", "_instructionFeatureSelectedForPrompt", "instructionFeatureSelectedForPrompt", "getInstructionFeatureSelectedForPrompt", "_instructionPhotoTemplatePrompt", "Lcom/larus/bmhome/view/actionbar/edit/InstructionPhotoTemplateWrapper;", "instructionPhotoTemplatePrompt", "getInstructionPhotoTemplatePrompt", "_instructionDigitalAvatarTemplatePrompt", "Lcom/larus/bmhome/actionbar/model/ActionBarDigitalAvatarTemplateItem;", "instructionDigitalAvatarTemplatePrompt", "getInstructionDigitalAvatarTemplatePrompt", "_instructionVideoTemplatePrompt", "instructionVideoTemplatePrompt", "getInstructionVideoTemplatePrompt", "_digitalAvatarTemplateChooseFlow", "Lkotlin/Triple;", "Lcom/larus/bmhome/avatar/api/DigitalAvatarTemplate;", "digitalAvatarTemplateChooseFlow", "getDigitalAvatarTemplateChooseFlow", "_invokeSendMessage", "invokeSendMessage", "getInvokeSendMessage", "_instructionMusicTemplatePrompt", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "instructionMusicTemplatePrompt", "getInstructionMusicTemplatePrompt", "_instructionMusicTemplateDetailOpen", "instructionMusicTemplateDetailOpen", "getInstructionMusicTemplateDetailOpen", "_instructionFeatureUnSelectedForPrompt", "instructionFeatureUnSelectedForPrompt", "getInstructionFeatureUnSelectedForPrompt", "_instructionFeatureDialogDismiss", "instructionFeatureDialogDismiss", "getInstructionFeatureDialogDismiss", "_chosenMsgInstructionFlow", "Lcom/larus/bmhome/actionbar/model/MsgInstructionItem;", "chosenMsgInstructionFlow", "getChosenMsgInstructionFlow", "chosenMsgInstruction", "getChosenMsgInstruction", "()Lcom/larus/bmhome/actionbar/model/MsgInstructionItem;", "setChosenMsgInstruction", "(Lcom/larus/bmhome/actionbar/model/MsgInstructionItem;)V", "_imageListSelectorWithMoreRefreshFlow", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "imageListSelectorWithMoreRefreshFlow", "getImageListSelectorWithMoreRefreshFlow", "curImageList", "getCurImageList", "()Ljava/util/List;", "setCurImageList", "(Ljava/util/List;)V", "defaultSelectedImageStyleId", "", "getDefaultSelectedImageStyleId", "()Ljava/lang/Long;", "setDefaultSelectedImageStyleId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "value", "enableResetTemplateCacheAfterDetach", "getEnableResetTemplateCacheAfterDetach", "()Z", "_resetImageStyleListFlow", "resetImageStyleListFlow", "getResetImageStyleListFlow", "_chosenImgInspirationFlow", "Lcom/larus/bmhome/instruction/repo/ImgInspirePrompt;", "chosenImgInspirationFlow", "getChosenImgInspirationFlow", "chosenImgInspirePrompt", "getChosenImgInspirePrompt", "()Lcom/larus/bmhome/instruction/repo/ImgInspirePrompt;", "setChosenImgInspirePrompt", "(Lcom/larus/bmhome/instruction/repo/ImgInspirePrompt;)V", "_componentVisibilityChangedFlow", "Lkotlin/Pair;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "componentVisibilityChangedFlow", "getComponentVisibilityChangedFlow", "collegeEntranceExamClickLiveData", "Landroidx/lifecycle/MutableLiveData;", "getCollegeEntranceExamClickLiveData", "()Landroidx/lifecycle/MutableLiveData;", "_mediaSelectedFlow", "mediaSelectedFlow", "getMediaSelectedFlow", "_mediaUploadedFlow", "mediaUploadedFlow", "getMediaUploadedFlow", "_hideInstructionFlow", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "hideInstructionFlow", "getHideInstructionFlow", "_enableOriginalRatioFlow", "enableOriginalRatioFlow", "getEnableOriginalRatioFlow", "_selectRatioFlow", "Lcom/larus/bmhome/view/actionbar/edit/SelectedRatioInfo;", "selectRatioFlow", "getSelectRatioFlow", "selectedRatioId", "getSelectedRatioId", "setSelectedRatioId", "selectedClickRatioIdRegistry", "", "getSelectedClickRatioIdRegistry", "setSelectedClickRatioIdRegistry", "(Ljava/util/Map;)V", "dropDownSelectorClickInterceptor", "Lkotlin/Function0;", "getDropDownSelectorClickInterceptor", "()Lkotlin/jvm/functions/Function0;", "setDropDownSelectorClickInterceptor", "(Lkotlin/jvm/functions/Function0;)V", "_selectVideoModelFlow", "Lcom/larus/bmhome/view/actionbar/edit/SelectedModelInfo;", "selectVideoModelFlow", "getSelectVideoModelFlow", "selectedVideoModelId", "getSelectedVideoModelId", "setSelectedVideoModelId", "_selectModelFlow", "selectModelFlow", "getSelectModelFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "selectedModelId", "getSelectedModelId", "setSelectedModelId", "_selectDurationFlow", "Lcom/larus/bmhome/view/actionbar/edit/SelectedDurationInfo;", "selectDurationFlow", "getSelectDurationFlow", "setRatioDropDownSelectorClickInterceptor", "interceptor", "videoModelDropDownSelectorClickInterceptor", "getVideoModelDropDownSelectorClickInterceptor", "setVideoModelDropDownSelectorClickInterceptor", "videoModelSelectionInterceptor", "Lkotlin/Function2;", "getVideoModelSelectionInterceptor", "()Lkotlin/jvm/functions/Function2;", "setVideoModelSelectionInterceptor", "(Lkotlin/jvm/functions/Function2;)V", "_ratioOptionList", "ratioOptionList", "getRatioOptionList", "setRatioOptionList", "optionList", "_ratioCanBeEmpty", "ratioCanBeEmpty", "getRatioCanBeEmpty", "setRatioCanBeEmpty", "canBeEmpty", "setEnableResetTemplateCacheAfterDetach", "enable", "_instructionInputBoxTextChanged", "instructionInputBoxTextChanged", "getInstructionInputBoxTextChanged", "instructionInputBoxText", "getInstructionInputBoxText", "_inputBoxHintChanged", "inputBoxHintChanged", "getInputBoxHintChanged", "instructionInputBoxHint", "_optionParamFilterConfChanged", "Lcom/larus/bmhome/actionbar/model/ParamFilterConf;", "optionParamFilterConfChanged", "getOptionParamFilterConfChanged", "optionParamFilterConf", "getOptionParamFilterConf", "()Lcom/larus/bmhome/actionbar/model/ParamFilterConf;", "setOptionParamFilterConf", "(Lcom/larus/bmhome/actionbar/model/ParamFilterConf;)V", "messageExtMapJsonString", "getMessageExtMapJsonString", "_messageExtMap", "set_messageExtMap", "setMsgExtMap", "msgExtMap", "tag", "getMsgExtMap", "currentCustomActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "getCurrentCustomActionBarItem", "()Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "setCurrentCustomActionBarItem", "(Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;)V", "currentActionBarId", "getCurrentActionBarId", "currentOpenFrom", "getCurrentOpenFrom", "imageStyleRadioSelected", "getImageStyleRadioSelected", "needSaveDraft", "getNeedSaveDraft", "isModifying", "setModifying", "(Z)V", "setChosenAvatarInstructionStatus", "status", "onAvatarInstructionClicked", ShareType.URL, "onAvatarBtnClick", "isActiveClick", "onAvatarBtnCancel", "setImageStyleRadioSelected", "isSelected", "setActionBarInstructionInputSendReady", "ready", "imageReferenceUploaded", "getImageReferenceUploaded", "setImageReferenceUploaded", "isUploaded", "_actionBarInstructionInputSendReady", "actionBarInstructionInputSendReadyState", "getActionBarInstructionInputSendReadyState", "_actionBarInstructionInputSendReadyState", "actionBarInstructionInputSendReady", "getActionBarInstructionInputSendReady", "markInputSendReadyState", "onActionBarInstructionChanged", "actionBarItem", "instructionDefaultStateConf", "openFrom", "autoSendPrompt", "instructionExtraData", "Lcom/larus/bmhome/instruction/core/model/InstructionExtraData;", "selectInstructionType", "onInstructionCallback", "(Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Lcom/larus/bmhome/actionbar/model/ActionBarInstructionConf;ILjava/lang/String;Lcom/larus/bmhome/instruction/core/model/InstructionExtraData;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "onComponentVisibilityChanged", "component", "", "visible", "onTabSelected", "tabSelectorTemplate", "setOriginalRatioEnable", "uploadSuccessRefImgCnt", "onMediaContainerStatusChanged", "selected", "uploaded", "uploadFailed", "hideInstructionList", "forceInputSendReady", "hasChosenAvatar", "refImgCount", "selectRatio", "id", "parentInstructionType", "selectModel", "selectVideoModel", "syncVideoModel", "selectDuration", "selectInstructionMenu", "position", "isInVideoTab", "refreshImageListSelectorWithMore", "imageList", "resetImageStyleList", "onDigitalAvatarTemplateChoose", "templateInfo", "enterFrom", "onVideoTemplateChoose", "prompt", "onInstructionEditorViewChanged", "resetInstructionData", "onInstructionReferenceImageChanged", "referenceImage", "onInstructionReferenceImageUploadStatus", "onFeatureOptionSelected", "selectedOption", "onInstructionImageTemplateSelected", "imageTemplate", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "localImagePath", "Landroid/net/Uri;", "onInstructionDigitalAvatarTemplateSelected", "digitalAvatarTemplate", "onInstructionMusicTemplateSelected", "musicTemplate", "onFeatureOptionUnSelected", "onMsgInstructionClicked", "item", "onImgInspirationClick", "onMusicDetailDialogOpen", "onMusicDetailDialogDismiss", "onFeatureOptionDialogDismiss", "onInputBoxTextChanged", "inputContent", "onInputHintChanged", "hint", "from", "getInstructionInputBoxHint", "onParamFilterConfChanged", "paramFilterConf", "actionBarItemMap", "updateConversationId", "botId", "conversationId", "getCustomActionBarItem", "multiTabHintMap", "Lcom/larus/bmhome/actionbar/model/InputBoxContent;", "_selectedVideoStyle", "selectedVideoStyle", "getSelectedVideoStyle", "updateInputBoxPlaceHolder", "index", "content", "getHintStr", "hintMode", "selectedVideoStyleItem", "_attachmentResources", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "attachmentResources", "getAttachmentResources", "updateAttachmentResources", "resources", "selectedVideoMenu", "jumpToCompleteVideoAvatarEvent", "Lkotlinx/coroutines/flow/Flow;", "getJumpToCompleteVideoAvatarEvent", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstructionEditorViewModel extends ViewModel implements c {
    public static final a Companion = null;
    private static final String TAG = "InstructionEditorViewModel";
    private MutableSharedFlow<aq8.j> _actionBarInstructionChanged;
    private MutableSharedFlow<Boolean> _actionBarInstructionInputSendReady;
    private Boolean _actionBarInstructionInputSendReadyState;
    private final z0<List<ResourceItemBean>> _attachmentResources;
    private final MutableSharedFlow<Unit> _avatarBtnCancelFlow;
    private final MutableSharedFlow<Boolean> _avatarBtnClickFlow;
    private final z0<Boolean> _avatarSelectFlow;
    private final MutableSharedFlow<String> _chosenAvatarInstructionFlow;
    private final z0<Boolean> _chosenAvatarInstructionStatus;
    private final MutableSharedFlow<fq8.e> _chosenImgInspirationFlow;
    private final MutableSharedFlow<p1> _chosenMsgInstructionFlow;
    private final MutableSharedFlow<Pair<ConstraintLayout, Boolean>> _componentVisibilityChangedFlow;
    private final MutableSharedFlow<Triple<ab8.a, Integer, String>> _digitalAvatarTemplateChooseFlow;
    private final z0<Boolean> _enableOriginalRatioFlow;
    private final z0<ArrayList<Integer>> _hideInstructionFlow;
    private final MutableSharedFlow<List<w>> _imageListSelectorWithMoreRefreshFlow;
    private final MutableSharedFlow<String> _inputBoxHintChanged;
    private Map<String, ?> _instructionDefaultParams;
    private final MutableSharedFlow<com.larus.bmhome.actionbar.model.f> _instructionDigitalAvatarTemplatePrompt;
    private MutableSharedFlow<Integer> _instructionEditorViewStatus;
    private final MutableSharedFlow<Boolean> _instructionFeatureDialogDismiss;
    private final MutableSharedFlow<String> _instructionFeatureSelectedForPrompt;
    private final MutableSharedFlow<String> _instructionFeatureUnSelectedForPrompt;
    private final MutableSharedFlow<String> _instructionInputBoxTextChanged;
    private final MutableSharedFlow<Boolean> _instructionMusicTemplateDetailOpen;
    private final MutableSharedFlow<bq8.a> _instructionMusicTemplatePrompt;
    private final MutableSharedFlow<m> _instructionPhotoTemplatePrompt;
    private AttachmentInfo _instructionReferenceImage;
    private z0<Integer> _instructionReferenceImageUploadStatus;
    private z0<Integer> _instructionSelectMenuPosition;
    private final MutableSharedFlow<i0> _instructionTabSelected;
    private final MutableSharedFlow<String> _instructionVideoTemplatePrompt;
    private final MutableSharedFlow<String> _invokeSendMessage;
    private final z0<Boolean> _mediaSelectedFlow;
    private final z0<Boolean> _mediaUploadedFlow;
    private Map<String, String> _messageExtMap;
    private final MutableSharedFlow<t1> _optionParamFilterConfChanged;
    private boolean _ratioCanBeEmpty;
    private List<w> _ratioOptionList;
    private final MutableSharedFlow<Unit> _resetImageStyleListFlow;
    private final MutableSharedFlow<o> _selectDurationFlow;
    private final z0<p> _selectModelFlow;
    private final MutableSharedFlow<q> _selectRatioFlow;
    private final z0<p> _selectVideoModelFlow;
    private final z0<Long> _selectedVideoStyle;
    private final d1<aq8.j> actionBarInstructionChanged;
    private final d1<Boolean> actionBarInstructionInputSendReady;
    private final Map<String, com.larus.bmhome.actionbar.model.z0> actionBarItemMap;
    private String actionBarName;
    private String actionBarType;
    private final i1<List<ResourceItemBean>> attachmentResources;
    private final d1<Unit> avatarBtnCancelFlow;
    private final d1<Boolean> avatarBtnClickFlow;
    private final i1<Boolean> avatarSelectedFlow;
    private ChatParam chatParam;
    private final d1<String> chosenAvatarInstructionFlow;
    private final i1<Boolean> chosenAvatarInstructionStatus;
    private final d1<fq8.e> chosenImgInspirationFlow;
    private fq8.e chosenImgInspirePrompt;
    private p1 chosenMsgInstruction;
    private final d1<p1> chosenMsgInstructionFlow;
    private final MutableLiveData<String> collegeEntranceExamClickLiveData;
    private final d1<Pair<ConstraintLayout, Boolean>> componentVisibilityChangedFlow;
    private List<w> curImageList;
    private Integer currentActionBarId;
    private com.larus.bmhome.actionbar.model.z0 currentCustomActionBarItem;
    private r currentInstructionConf;
    private r currentInstructionUsuallyConfig;
    private Integer currentOpenFrom;
    private Long defaultSelectedImageStyleId;
    private final d1<Triple<ab8.a, Integer, String>> digitalAvatarTemplateChooseFlow;
    private Function0<Boolean> dropDownSelectorClickInterceptor;
    private final i1<Boolean> enableOriginalRatioFlow;
    private boolean enableResetTemplateCacheAfterDetach;
    private final i1<ArrayList<Integer>> hideInstructionFlow;
    private final d1<List<w>> imageListSelectorWithMoreRefreshFlow;
    private boolean imageReferenceUploaded;
    private boolean imageStyleRadioSelected;
    private final d1<String> inputBoxHintChanged;
    private final d1<com.larus.bmhome.actionbar.model.f> instructionDigitalAvatarTemplatePrompt;
    private final d1<Integer> instructionEditorViewStatus;
    private final d1<Boolean> instructionFeatureDialogDismiss;
    private final d1<String> instructionFeatureSelectedForPrompt;
    private final d1<String> instructionFeatureUnSelectedForPrompt;
    private String instructionInputBoxHint;
    private String instructionInputBoxText;
    private final d1<String> instructionInputBoxTextChanged;
    private final d1<Boolean> instructionMusicTemplateDetailOpen;
    private final d1<bq8.a> instructionMusicTemplatePrompt;
    private final d1<m> instructionPhotoTemplatePrompt;
    private r instructionRebuildStateConf;
    private final i1<Integer> instructionReferenceImageUploadStatus;
    private final i1<Integer> instructionSelectMenuPosition;
    private final d1<i0> instructionTabSelected;
    private Integer instructionType;
    private List<r> instructionUsuallyStateConfList;
    private final d1<String> instructionVideoTemplatePrompt;
    private final d1<String> invokeSendMessage;
    private Boolean isCreationActionBar;
    private boolean isModifying;
    private final Flow<Unit> jumpToCompleteVideoAvatarEvent;
    private final i1<Boolean> mediaSelectedFlow;
    private final i1<Boolean> mediaUploadedFlow;
    private String messageExtMapJsonString;
    private final Map<Integer, h1> multiTabHintMap;
    private boolean needSaveDraft;
    private t1 optionParamFilterConf;
    private final d1<t1> optionParamFilterConfChanged;
    private final d1<Unit> resetImageStyleListFlow;
    private final d1<o> selectDurationFlow;
    private final z0<p> selectModelFlow;
    private final d1<q> selectRatioFlow;
    private final i1<p> selectVideoModelFlow;
    private Map<Integer, Long> selectedClickRatioIdRegistry;
    private Long selectedModelId;
    private Long selectedRatioId;
    private Long selectedVideoModelId;
    private final i1<Long> selectedVideoStyle;
    private String templateType;
    private int uploadSuccessRefImgCnt;
    private Function0<Boolean> videoModelDropDownSelectorClickInterceptor;
    private Function2<? super Long, ? super Boolean, Boolean> videoModelSelectionInterceptor;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onActionBarInstructionChanged$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onActionBarInstructionChanged$1", f = "InstructionEditorViewModel.kt", i = {}, l = {520, 525, 533}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $actionBarItem;
        final /* synthetic */ String $autoSendPrompt;
        final /* synthetic */ r $instructionDefaultStateConf;
        final /* synthetic */ aq8.e $instructionExtraData;
        final /* synthetic */ Function0<Unit> $onInstructionCallback;
        final /* synthetic */ int $openFrom;
        final /* synthetic */ Integer $selectInstructionType;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public AnonymousClass1(InstructionEditorViewModel r1, com.larus.bmhome.actionbar.model.z0 r2, aq8.e r3, r r4, Integer r5, String r6, int r7, Function0<Unit> r8, Continuation<? super AnonymousClass1> r9) {
            this.this$0 = r1;
            this.$actionBarItem = r2;
            this.$instructionExtraData = r3;
            this.$instructionDefaultStateConf = r4;
            this.$selectInstructionType = r5;
            this.$autoSendPrompt = r6;
            this.$openFrom = r7;
            this.$onInstructionCallback = r8;
            super(2, r9);
        }

        public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
            return new AnonymousClass1(this.this$0, this.$actionBarItem, this.$instructionExtraData, this.$instructionDefaultStateConf, this.$selectInstructionType, this.$autoSendPrompt, this.$openFrom, this.$onInstructionCallback, r12);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r20);
        L92:
            InstructionEditorViewModel.access$setCurrentOpenFrom$p(this.this$0, Boxing.boxInt(this.$openFrom));
        L94:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r20);
            goto L94
        L12:
            ResultKt.throwOnFailure(r20);
            com.larus.bmhome.actionbar.model.z0 r3 = this.this$0.getCurrentCustomActionBarItem();
            Map<String, String> r6 = null;
            if (r3 == null) goto L17;
            r r4 = r3.q;
            if (r4 == null) goto L17;
            Integer r5 = r4.a;
        L18:
            r r7 = this.$actionBarItem.q;
            if (r7 == null) goto L21;
            Integer r8 = r7.a;
        L22:
            boolean r9 = Intrinsics.areEqual(r5, r8);
            boolean r10 = false;
            if (r9 == false) goto L43;
            r r11 = this.$actionBarItem.q;
            if (r11 == null) goto L31;
            List r12 = r11.b;
            if (r12 == null) goto L31;
            if ((!r12.isEmpty()) != true) goto L31;
            boolean r13 = true;
        L32:
            if (r13 == false) goto L43;
            aq8.e r14 = this.$instructionExtraData;
            if (r14 != null) goto L36;
        L38:
            boolean r15 = false;
        L39:
            if (r15 == false) goto L41;
            FLogger.a.d(InstructionEditorViewModel.TAG, "onActionBarInstructionChanged, same instruction type, but forceUpdate");
            goto L43
        L41:
            FLogger.a.d(InstructionEditorViewModel.TAG, "onActionBarInstructionChanged, same instruction type, do nothing");
            return Unit.INSTANCE;
        L36:
            if (r14.f != true) goto L38;
            r15 = true;
        L31:
            r13 = false;
        L43:
            InstructionEditorViewModel.access$setInstructionInputBoxHint$p(this.this$0, null);
            this.this$0.setCurrentCustomActionBarItem(this.$actionBarItem);
            InstructionEditorViewModel r16 = this.this$0;
            r r17 = this.$actionBarItem.q;
            if (r17 == null) goto L46;
            Integer r18 = r17.a;
        L47:
            InstructionEditorViewModel.access$setCurrentActionBarId$p(r16, r18);
            this.this$0.setCurrentInstructionConf(this.$actionBarItem.q);
            InstructionEditorViewModel r19 = this.this$0;
            r r21 = r19.getCurrentInstructionConf();
            if (r21 == null) goto L50;
            Integer r22 = r21.a;
        L51:
            r19.setInstructionType(r22);
            this.this$0.setInstructionRebuildStateConf(this.$instructionDefaultStateConf);
            InstructionEditorViewModel r23 = this.this$0;
            gq8.a r24 = gq8.a.a;
            Integer r110 = r23.getInstructionType();
            aq8.e r111 = this.$instructionExtraData;
            if (r111 == null) goto L54;
            String r112 = r111.d;
        L55:
            Integer r113 = this.$selectInstructionType;
            r24.getClass();
            InstructionEditorViewModel.access$set_instructionDefaultParams$p(r23, gq8.a.b(r110, r112, r113));
            boolean r25 = w1.a;
            final InstructionEditorViewModel r26 = this.this$0;
            w1.a(InstructionEditorViewModel.TAG, new k(r26));
            InstructionEditorViewModel r27 = this.this$0;
            List r28 = InstructionEditorViewModel.access$getInstructionUsuallyStateConfList$p(r27);
            com.larus.bmhome.actionbar.model.z0 r29 = this.$actionBarItem;
            ListIterator r30 = r28.listIterator(r28.size());
        L57:
            if (r30.hasPrevious() == false) goto L65;
            Object r114 = r30.previous();
            Integer r115 = ((r) r114).a;
            r r116 = r29.q;
            if (r116 == null) goto L61;
            Integer r117 = r116.a;
        L63:
            if (Intrinsics.areEqual(r115, r117) == false) goto L57;
        L66:
            r27.setCurrentInstructionUsuallyConfig((r) r114);
            String r31 = this.$autoSendPrompt;
            if (r31 != null) goto L69;
        L71:
            if (r10 == false) goto L79;
            InstructionEditorViewModel r32 = this.this$0;
            aq8.e r33 = this.$instructionExtraData;
            if (r33 == null) goto L75;
            r6 = r33.e;
        L75:
            r32.setMsgExtMap(r6, "autoSendPrompt onActionBarInstructionChanged");
            MutableSharedFlow r34 = InstructionEditorViewModel.access$get_invokeSendMessage$p(this.this$0);
            String r35 = this.$autoSendPrompt;
            this.label = 1;
            if (r34.emit(r35, this) != r1) goto L94;
            return r1;
        L79:
            if (this.$openFrom == 3) goto L89;
            InstructionEditorViewModel r36 = this.this$0;
            aq8.e r37 = this.$instructionExtraData;
            if (r37 == null) goto L83;
            r6 = r37.e;
        L83:
            r36.setMsgExtMap(r6, "onActionBarInstructionChanged");
            MutableSharedFlow r38 = InstructionEditorViewModel.access$get_actionBarInstructionChanged$p(this.this$0);
            com.larus.bmhome.actionbar.model.z0 r39 = this.$actionBarItem;
            aq8.e r40 = this.$instructionExtraData;
            if (r40 != null) goto L86;
            r40 = new aq8.e(null, null, null, null, null, false, null, null, null, null, 1023);
        L86:
            aq8.j r41 = new aq8.j(r39, r40, this.$onInstructionCallback);
            this.label = 2;
            if (r38.emit(r41, this) != r1) goto L92;
            return r1;
        L89:
            MutableSharedFlow r42 = InstructionEditorViewModel.access$get_actionBarInstructionChanged$p(this.this$0);
            aq8.j r43 = new aq8.j(this.$actionBarItem, null, this.$onInstructionCallback);
            this.label = 3;
            if (r42.emit(r43, this) != r1) goto L92;
            return r1;
        L69:
            if (o0.d(r31) != true) goto L71;
            r10 = true;
            goto L71
        L61:
            r117 = null;
            goto L63
        L65:
            r114 = null;
            goto L66
        L54:
            r112 = null;
            goto L55
        L50:
            r22 = null;
            goto L51
        L46:
            r18 = null;
            goto L47
        L21:
            r8 = null;
        L17:
            r5 = null;
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onAvatarBtnCancel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onAvatarBtnCancel$1", f = "InstructionEditorViewModel.kt", i = {}, l = {442}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01551(InstructionEditorViewModel r1, Continuation<? super C01551> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01551(this.this$0, r3);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_avatarBtnCancelFlow$p(this.this$0);
            Unit r2 = Unit.INSTANCE;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onAvatarBtnClick$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onAvatarBtnClick$1", f = "InstructionEditorViewModel.kt", i = {}, l = {436}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isActiveClick;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01561(InstructionEditorViewModel r1, boolean r2, Continuation<? super C01561> r3) {
            this.this$0 = r1;
            this.$isActiveClick = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01561(this.this$0, this.$isActiveClick, r4);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_avatarBtnClickFlow$p(this.this$0);
            Boolean r2 = Boxing.boxBoolean(this.$isActiveClick);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onAvatarInstructionClicked$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onAvatarInstructionClicked$1", f = "InstructionEditorViewModel.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01571(InstructionEditorViewModel r1, String r2, Continuation<? super C01571> r3) {
            this.this$0 = r1;
            this.$url = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01571(this.this$0, this.$url, r4);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_chosenAvatarInstructionFlow$p(this.this$0);
            String r2 = this.$url;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onDigitalAvatarTemplateChoose$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onDigitalAvatarTemplateChoose$1", f = "InstructionEditorViewModel.kt", i = {}, l = {665}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $enterFrom;
        final /* synthetic */ int $position;
        final /* synthetic */ ab8.a $templateInfo;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01581(InstructionEditorViewModel r1, ab8.a r2, int r3, String r4, Continuation<? super C01581> r5) {
            this.this$0 = r1;
            this.$templateInfo = r2;
            this.$position = r3;
            this.$enterFrom = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01581(this.this$0, this.$templateInfo, this.$position, this.$enterFrom, r8);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            MutableSharedFlow r8 = InstructionEditorViewModel.access$get_digitalAvatarTemplateChooseFlow$p(this.this$0);
            Triple r2 = new Triple(this.$templateInfo, Boxing.boxInt(this.$position), this.$enterFrom);
            this.label = 1;
            if (r8.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onFeatureOptionDialogDismiss$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onFeatureOptionDialogDismiss$1", f = "InstructionEditorViewModel.kt", i = {}, l = {798}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01591(InstructionEditorViewModel r1, Continuation<? super C01591> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01591(this.this$0, r3);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_instructionFeatureDialogDismiss$p(this.this$0);
            Boolean r2 = Boxing.boxBoolean(true);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onFeatureOptionSelected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onFeatureOptionSelected$1", f = "InstructionEditorViewModel.kt", i = {}, l = {719}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ w $selectedOption;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01601(w r1, InstructionEditorViewModel r2, Continuation<? super C01601> r3) {
            this.$selectedOption = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01601(this.$selectedOption, this.this$0, r4);
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
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            w r5 = this.$selectedOption;
            if (r5 == null) goto L16;
            String r6 = r5.b;
            if (r6 == null) goto L16;
            MutableSharedFlow r2 = InstructionEditorViewModel.access$get_instructionFeatureSelectedForPrompt$p(this.this$0);
            this.label = 1;
            if (r2.emit(r6, this) != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onFeatureOptionUnSelected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onFeatureOptionUnSelected$1", f = "InstructionEditorViewModel.kt", i = {}, l = {767}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ w $selectedOption;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01611(w r1, InstructionEditorViewModel r2, Continuation<? super C01611> r3) {
            this.$selectedOption = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01611(this.$selectedOption, this.this$0, r4);
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
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            w r5 = this.$selectedOption;
            if (r5 == null) goto L16;
            String r6 = r5.b;
            if (r6 == null) goto L16;
            MutableSharedFlow r2 = InstructionEditorViewModel.access$get_instructionFeatureUnSelectedForPrompt$p(this.this$0);
            this.label = 1;
            if (r2.emit(r6, this) != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onImgInspirationClick$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onImgInspirationClick$1", f = "InstructionEditorViewModel.kt", i = {}, l = {780}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ fq8.e $item;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01621(InstructionEditorViewModel r1, fq8.e r2, Continuation<? super C01621> r3) {
            this.this$0 = r1;
            this.$item = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01621(this.this$0, this.$item, r4);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_chosenImgInspirationFlow$p(this.this$0);
            fq8.e r2 = this.$item;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInputBoxTextChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInputBoxTextChanged$1", f = "InstructionEditorViewModel.kt", i = {}, l = {804}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $inputContent;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01631(InstructionEditorViewModel r1, String r2, Continuation<? super C01631> r3) {
            this.this$0 = r1;
            this.$inputContent = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01631(this.this$0, this.$inputContent, r4);
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
        L11:
            InstructionEditorViewModel.access$setInstructionInputBoxText$p(this.this$0, this.$inputContent);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_instructionInputBoxTextChanged$p(this.this$0);
            String r2 = this.$inputContent;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInputHintChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInputHintChanged$1", f = "InstructionEditorViewModel.kt", i = {}, l = {813}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $hint;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01641(InstructionEditorViewModel r1, String r2, Continuation<? super C01641> r3) {
            this.this$0 = r1;
            this.$hint = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01641(this.this$0, this.$hint, r4);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_inputBoxHintChanged$p(this.this$0);
            String r2 = this.$hint;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInstructionDigitalAvatarTemplateSelected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInstructionDigitalAvatarTemplateSelected$1", f = "InstructionEditorViewModel.kt", i = {}, l = {751}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.bmhome.actionbar.model.f $digitalAvatarTemplate;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01651(com.larus.bmhome.actionbar.model.f r1, InstructionEditorViewModel r2, Continuation<? super C01651> r3) {
            this.$digitalAvatarTemplate = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01651(this.$digitalAvatarTemplate, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            com.larus.bmhome.actionbar.model.f r10 = this.$digitalAvatarTemplate;
            if (r10 == null) goto L22;
            InstructionEditorViewModel r2 = this.this$0;
            ChatParam r3 = r2.getChatParam();
            if (r3 == null) goto L18;
            String r4 = r3.a;
            if (r4 == null) goto L18;
            String r5 = r10.c;
            if (r5 == null) goto L17;
            ChatRenderTrace.b.g(r4, r5);
        L17:
            ChatRenderTrace r6 = ChatRenderTrace.b;
            String r7 = String.valueOf(r10.a);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r4, "cvsId");
            Intrinsics.checkNotNullParameter(r7, "templateId");
            Intrinsics.checkNotNullParameter("replica", "templateType");
            ChatRenderTrace.n.put(r4, new Pair(r7, "replica"));
        L18:
            MutableSharedFlow r8 = InstructionEditorViewModel.access$get_instructionDigitalAvatarTemplatePrompt$p(r2);
            this.label = 1;
            if (r8.emit(r10, this) != r0) goto L22;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInstructionEditorViewChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInstructionEditorViewChanged$1", f = "InstructionEditorViewModel.kt", i = {}, l = {686}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onInstructionCallback;
        final /* synthetic */ int $status;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01661(int r1, InstructionEditorViewModel r2, Function0<Unit> r3, Continuation<? super C01661> r4) {
            this.$status = r1;
            this.this$0 = r2;
            this.$onInstructionCallback = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01661(this.$status, this.this$0, this.$onInstructionCallback, r5);
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
        L16:
            Function0<Unit> r5 = this.$onInstructionCallback;
            if (r5 == null) goto L20;
            r5.invoke();
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            if (this.$status != 0) goto L13;
            int r6 = h0.a;
            boolean r7 = h0.a(this.this$0.getInstructionType());
            InstructionEditorViewModel.access$resetInstructionData(this.this$0);
            if (r7 == true) goto L13;
            this.this$0.setImageStyleRadioSelected(false);
            InstructionEditorViewModel.access$setImageReferenceUploaded(this.this$0, false);
            this.this$0.onInstructionReferenceImageChanged(null);
        L13:
            MutableSharedFlow r8 = InstructionEditorViewModel.access$get_instructionEditorViewStatus$p(this.this$0);
            Integer r2 = Boxing.boxInt(this.$status);
            this.label = 1;
            if (r8.emit(r2, this) != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInstructionImageTemplateSelected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInstructionImageTemplateSelected$1", f = "InstructionEditorViewModel.kt", i = {}, l = {735}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TemplateInfo.TemplateInfo $imageTemplate;
        final /* synthetic */ Uri $localImagePath;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01671(TemplateInfo.TemplateInfo r1, InstructionEditorViewModel r2, Uri r3, Continuation<? super C01671> r4) {
            this.$imageTemplate = r1;
            this.this$0 = r2;
            this.$localImagePath = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01671(this.$imageTemplate, this.this$0, this.$localImagePath, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            TemplateInfo.TemplateInfo r11 = this.$imageTemplate;
            if (r11 == null) goto L22;
            InstructionEditorViewModel r2 = this.this$0;
            Uri r3 = this.$localImagePath;
            ChatParam r4 = r2.getChatParam();
            if (r4 == null) goto L18;
            String r5 = r4.a;
            if (r5 == null) goto L18;
            String r6 = r11.c;
            if (r6 == null) goto L17;
            ChatRenderTrace.b.g(r5, r6);
        L17:
            ChatRenderTrace r7 = ChatRenderTrace.b;
            String r8 = String.valueOf(r11.a);
            r7.getClass();
            Intrinsics.checkNotNullParameter(r5, "cvsId");
            Intrinsics.checkNotNullParameter(r8, "templateId");
            Intrinsics.checkNotNullParameter(ReeditType.IMAGE, "templateType");
            ChatRenderTrace.n.put(r5, new Pair(r8, ReeditType.IMAGE));
        L18:
            MutableSharedFlow r9 = InstructionEditorViewModel.access$get_instructionPhotoTemplatePrompt$p(r2);
            m r12 = new m(r11, r3);
            this.label = 1;
            if (r9.emit(r12, this) != r0) goto L22;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInstructionMusicTemplateSelected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInstructionMusicTemplateSelected$1", f = "InstructionEditorViewModel.kt", i = {}, l = {759}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ bq8.a $musicTemplate;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01681(bq8.a r1, InstructionEditorViewModel r2, Continuation<? super C01681> r3) {
            this.$musicTemplate = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01681(this.$musicTemplate, this.this$0, r4);
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
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            bq8.a r5 = this.$musicTemplate;
            if (r5 == null) goto L14;
            MutableSharedFlow r2 = InstructionEditorViewModel.access$get_instructionMusicTemplatePrompt$p(this.this$0);
            this.label = 1;
            if (r2.emit(r5, this) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInstructionReferenceImageUploadStatus$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onInstructionReferenceImageUploadStatus$1", f = "InstructionEditorViewModel.kt", i = {}, l = {712}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $status;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01691(InstructionEditorViewModel r1, int r2, Continuation<? super C01691> r3) {
            this.this$0 = r1;
            this.$status = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01691(this.this$0, this.$status, r4);
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
            z0 r5 = InstructionEditorViewModel.access$get_instructionReferenceImageUploadStatus$p(this.this$0);
            Integer r2 = Boxing.boxInt(this.$status);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onMediaContainerStatusChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onMediaContainerStatusChanged$1", f = "InstructionEditorViewModel.kt", i = {}, l = {584}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $forceInputSendReady;
        final /* synthetic */ boolean $hasChosenAvatar;
        final /* synthetic */ int $refImgCount;
        final /* synthetic */ boolean $selected;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01701(InstructionEditorViewModel r1, boolean r2, boolean r3, int r4, boolean r5, Continuation<? super C01701> r6) {
            this.this$0 = r1;
            this.$selected = r2;
            this.$hasChosenAvatar = r3;
            this.$refImgCount = r4;
            this.$forceInputSendReady = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C01701(this.this$0, this.$selected, this.$hasChosenAvatar, this.$refImgCount, this.$forceInputSendReady, r9);
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
        L51:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            MutableSharedFlow r8 = InstructionEditorViewModel.access$get_actionBarInstructionInputSendReady$p(this.this$0);
            boolean r3 = false;
            if (this.$selected == true) goto L11;
        L47:
            Boolean r2 = Boxing.boxBoolean(r3);
            this.label = 1;
            if (r8.emit(r2, this) != r0) goto L51;
            return r0;
        L11:
            if (this.$hasChosenAvatar == false) goto L15;
            if (this.$refImgCount <= 0) goto L15;
        L46:
            r3 = true;
        L15:
            if (this.this$0.getImageStyleRadioSelected() == true) goto L46;
            Integer r4 = this.this$0.getInstructionType();
            if (r4 != null) goto L20;
        L21:
            Integer r5 = this.this$0.getInstructionType();
            if (r5 == null) goto L27;
            if (r5.intValue() == 24) goto L46;
        L27:
            if (this.$forceInputSendReady == true) goto L46;
            r r6 = this.this$0.getCurrentInstructionConf();
            if (r6 == null) goto L44;
            y r9 = r6.i;
            if (r9 == null) goto L44;
            ArrayList r10 = r9.a;
            if (r10 == null) goto L44;
            com.larus.bmhome.actionbar.model.z0 r11 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r10, ((Number) this.this$0.getInstructionSelectMenuPosition().getValue()).intValue());
            if (r11 == null) goto L44;
            r r12 = r11.q;
            if (r12 == null) goto L44;
            Integer r13 = r12.a;
            if (r13 == null) goto L44;
            if (r13.intValue() != 18) goto L44;
            boolean r14 = true;
        L45:
            if (r14 == false) goto L47;
        L44:
            r14 = false;
            goto L45
        L20:
            if (r4.intValue() == 18) goto L46;
            goto L21
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onMsgInstructionClicked$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onMsgInstructionClicked$1", f = "InstructionEditorViewModel.kt", i = {}, l = {774}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ p1 $item;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01711(InstructionEditorViewModel r1, p1 r2, Continuation<? super C01711> r3) {
            this.this$0 = r1;
            this.$item = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01711(this.this$0, this.$item, r4);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_chosenMsgInstructionFlow$p(this.this$0);
            p1 r2 = this.$item;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onMusicDetailDialogDismiss$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onMusicDetailDialogDismiss$1", f = "InstructionEditorViewModel.kt", i = {}, l = {792}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01721(InstructionEditorViewModel r1, Continuation<? super C01721> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01721(this.this$0, r3);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_instructionMusicTemplateDetailOpen$p(this.this$0);
            Boolean r2 = Boxing.boxBoolean(false);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onMusicDetailDialogOpen$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onMusicDetailDialogOpen$1", f = "InstructionEditorViewModel.kt", i = {}, l = {786}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01731(InstructionEditorViewModel r1, Continuation<? super C01731> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01731(this.this$0, r3);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_instructionMusicTemplateDetailOpen$p(this.this$0);
            Boolean r2 = Boxing.boxBoolean(true);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onParamFilterConfChanged$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onParamFilterConfChanged$1", f = "InstructionEditorViewModel.kt", i = {}, l = {831}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ t1 $paramFilterConf;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01741(InstructionEditorViewModel r1, t1 r2, Continuation<? super C01741> r3) {
            this.this$0 = r1;
            this.$paramFilterConf = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01741(this.this$0, this.$paramFilterConf, r4);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_optionParamFilterConfChanged$p(this.this$0);
            t1 r2 = this.$paramFilterConf;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onTabSelected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onTabSelected$1", f = "InstructionEditorViewModel.kt", i = {}, l = {558}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ i0 $tabSelectorTemplate;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01751(InstructionEditorViewModel r1, i0 r2, Continuation<? super C01751> r3) {
            this.this$0 = r1;
            this.$tabSelectorTemplate = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01751(this.this$0, this.$tabSelectorTemplate, r4);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_instructionTabSelected$p(this.this$0);
            i0 r2 = this.$tabSelectorTemplate;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onVideoTemplateChoose$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$onVideoTemplateChoose$1", f = "InstructionEditorViewModel.kt", i = {}, l = {671}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $prompt;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01761(InstructionEditorViewModel r1, String r2, Continuation<? super C01761> r3) {
            this.this$0 = r1;
            this.$prompt = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01761(this.this$0, this.$prompt, r4);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_instructionVideoTemplatePrompt$p(this.this$0);
            String r2 = this.$prompt;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$refreshImageListSelectorWithMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$refreshImageListSelectorWithMore$1", f = "InstructionEditorViewModel.kt", i = {}, l = {653}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<w> $imageList;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01771(InstructionEditorViewModel r1, List<w> r2, Continuation<? super C01771> r3) {
            this.this$0 = r1;
            this.$imageList = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01771(this.this$0, this.$imageList, r4);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_imageListSelectorWithMoreRefreshFlow$p(this.this$0);
            List<w> r2 = this.$imageList;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$resetImageStyleList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$resetImageStyleList$1", f = "InstructionEditorViewModel.kt", i = {}, l = {659}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01781(InstructionEditorViewModel r1, Continuation<? super C01781> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01781(this.this$0, r3);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_resetImageStyleListFlow$p(this.this$0);
            Unit r2 = Unit.INSTANCE;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$selectDuration$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$selectDuration$1", f = "InstructionEditorViewModel.kt", i = {}, l = {637}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $id;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01791(InstructionEditorViewModel r1, long r2, Continuation<? super C01791> r4) {
            this.this$0 = r1;
            this.$id = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01791(this.this$0, this.$id, r5);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MutableSharedFlow r7 = InstructionEditorViewModel.access$get_selectDurationFlow$p(this.this$0);
            o r2 = new o(this.$id);
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$selectModel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$selectModel$1", f = "InstructionEditorViewModel.kt", i = {}, l = {613}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $id;
        final /* synthetic */ int $parentInstructionType;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01801(InstructionEditorViewModel r1, int r2, long r3, Continuation<? super C01801> r5) {
            this.this$0 = r1;
            this.$parentInstructionType = r2;
            this.$id = r3;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C01801(this.this$0, this.$parentInstructionType, this.$id, r8);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            z0 r8 = InstructionEditorViewModel.access$get_selectModelFlow$p(this.this$0);
            p r2 = new p(this.$parentInstructionType, this.$id);
            this.label = 1;
            if (r8.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$selectRatio$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$selectRatio$1", f = "InstructionEditorViewModel.kt", i = {}, l = {595}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $id;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01811(InstructionEditorViewModel r1, long r2, Continuation<? super C01811> r4) {
            this.this$0 = r1;
            this.$id = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01811(this.this$0, this.$id, r5);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            MutableSharedFlow r8 = InstructionEditorViewModel.access$get_selectRatioFlow$p(this.this$0);
            q r2 = new q(0, this.$id);
            this.label = 1;
            if (r8.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$selectRatio$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$selectRatio$2", f = "InstructionEditorViewModel.kt", i = {}, l = {601}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $id;
        final /* synthetic */ int $parentInstructionType;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public AnonymousClass2(InstructionEditorViewModel r1, int r2, long r3, Continuation<? super AnonymousClass2> r5) {
            this.this$0 = r1;
            this.$parentInstructionType = r2;
            this.$id = r3;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass2(this.this$0, this.$parentInstructionType, this.$id, r8);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            MutableSharedFlow r8 = InstructionEditorViewModel.access$get_selectRatioFlow$p(this.this$0);
            q r2 = new q(this.$parentInstructionType, this.$id);
            this.label = 1;
            if (r8.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$setActionBarInstructionInputSendReady$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$setActionBarInstructionInputSendReady$1", f = "InstructionEditorViewModel.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $ready;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01821(InstructionEditorViewModel r1, boolean r2, Continuation<? super C01821> r3) {
            this.this$0 = r1;
            this.$ready = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01821(this.this$0, this.$ready, r4);
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
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_actionBarInstructionInputSendReady$p(this.this$0);
            Boolean r2 = Boxing.boxBoolean(this.$ready);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$setChosenAvatarInstructionStatus$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$setChosenAvatarInstructionStatus$1", f = "InstructionEditorViewModel.kt", i = {}, l = {424}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $status;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01831(InstructionEditorViewModel r1, boolean r2, Continuation<? super C01831> r3) {
            this.this$0 = r1;
            this.$status = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01831(this.this$0, this.$status, r4);
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
            z0 r5 = InstructionEditorViewModel.access$get_chosenAvatarInstructionStatus$p(this.this$0);
            Boolean r2 = Boxing.boxBoolean(this.$status);
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$setImageReferenceUploaded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$setImageReferenceUploaded$1", f = "InstructionEditorViewModel.kt", i = {}, l = {466}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isUploaded;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01841(InstructionEditorViewModel r1, boolean r2, Continuation<? super C01841> r3) {
            this.this$0 = r1;
            this.$isUploaded = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01841(this.this$0, this.$isUploaded, r4);
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
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            InstructionEditorViewModel.access$setImageReferenceUploaded$p(this.this$0, this.$isUploaded);
            InstructionEditorViewModel.access$setNeedSaveDraft$p(this.this$0, this.$isUploaded);
            MutableSharedFlow r5 = InstructionEditorViewModel.access$get_actionBarInstructionInputSendReady$p(this.this$0);
            if (this.this$0.getImageReferenceUploaded() == true) goto L11;
        L13:
            boolean r2 = false;
        L14:
            Boolean r3 = Boxing.boxBoolean(r2);
            this.label = 1;
            if (r5.emit(r3, this) != r0) goto L18;
            return r0;
        L11:
            if (this.this$0.getImageStyleRadioSelected() == false) goto L13;
            r2 = true;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$setImageStyleRadioSelected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$setImageStyleRadioSelected$1", f = "InstructionEditorViewModel.kt", i = {}, l = {449}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isSelected;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01851(InstructionEditorViewModel r1, boolean r2, Continuation<? super C01851> r3) {
            this.this$0 = r1;
            this.$isSelected = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01851(this.this$0, this.$isSelected, r4);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L31:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            InstructionEditorViewModel.access$setImageStyleRadioSelected$p(this.this$0, this.$isSelected);
            MutableSharedFlow r6 = InstructionEditorViewModel.access$get_actionBarInstructionInputSendReady$p(this.this$0);
            if (this.this$0.getImageReferenceUploaded() == true) goto L13;
            if (((Boolean) this.this$0.getMediaSelectedFlow().getValue()).booleanValue() == true) goto L13;
        L25:
            boolean r2 = false;
        L27:
            Boolean r3 = Boxing.boxBoolean(r2);
            this.label = 1;
            if (r6.emit(r3, this) != r0) goto L31;
            return r0;
        L13:
            if (this.this$0.getImageStyleRadioSelected() == true) goto L26;
            Integer r4 = this.this$0.getInstructionType();
            if (r4 != null) goto L18;
        L19:
            Integer r7 = this.this$0.getInstructionType();
            if (r7 == null) goto L25;
            if (r7.intValue() != 24) goto L25;
        L18:
            if (r4.intValue() != 18) goto L19;
        L26:
            r2 = true;
            goto L27
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$syncVideoModel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$syncVideoModel$1", f = "InstructionEditorViewModel.kt", i = {}, l = {631}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $id;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01861(InstructionEditorViewModel r1, long r2, Continuation<? super C01861> r4) {
            this.this$0 = r1;
            this.$id = r2;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01861(this.this$0, this.$id, r5);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            z0 r8 = InstructionEditorViewModel.access$get_selectVideoModelFlow$p(this.this$0);
            p r2 = new p(18, this.$id);
            this.label = 1;
            if (r8.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$updateConversationId$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$updateConversationId$1", f = "InstructionEditorViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $botId;
        final /* synthetic */ String $conversationId;
        int label;
        final /* synthetic */ InstructionEditorViewModel this$0;

        public C01871(InstructionEditorViewModel r1, String r2, String r3, Continuation<? super C01871> r4) {
            this.this$0 = r1;
            this.$botId = r2;
            this.$conversationId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01871(this.this$0, this.$botId, this.$conversationId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r4);
            if (InstructionEditorViewModel.access$getActionBarItemMap$p(this.this$0).containsKey(this.$botId) == true) goto L7;
            InstructionEditorViewModel.access$getActionBarItemMap$p(this.this$0).put(this.$botId, null);
            BotRepo r5 = z1.a;
            final String r6 = this.$botId;
            String r0 = this.$conversationId;
            final InstructionEditorViewModel r1 = this.this$0;
            z1.a(r6, r0, new l(r1, r6));
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    private final void resetInstructionData() {
        setOptionParamFilterConf(null);
        setCurrentCustomActionBarItem(null);
        setCurrentInstructionConf(null);
        setInstructionType(0);
        this.currentOpenFrom = 0;
        this.instructionInputBoxText = null;
        this.instructionInputBoxHint = null;
        setMsgExtMap(null, "resetInstructionData");
    }

    public static /* synthetic */ String yo(InstructionEditorViewModel r0, String r1) {
        return setMsgExtMap$lambda$0(r0, r1);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public String getInstructionInputBoxHint() {
        if (o0.d(this.instructionInputBoxHint) == true) goto L28;
        Integer r0 = getInstructionType();
        String r1 = null;
        if (r0 != null) goto L9;
    L21:
        r r2 = getCurrentInstructionConf();
        if (r2 == null) goto L27;
        h1 r3 = r2.c;
        if (r3 == null) goto L27;
        return r3.a;
    L27:
        return r1;
    L9:
        if (r0.intValue() != 21) goto L21;
        com.larus.bmhome.view.actionbar.deepresearch.b r4 = com.larus.bmhome.view.actionbar.deepresearch.b.a;
        com.larus.bmhome.actionbar.model.z0 r5 = com.larus.bmhome.view.actionbar.deepresearch.b.c;
        if (r5 == null) goto L27;
        if (com.larus.bmhome.view.actionbar.deepresearch.b.d() == false) goto L18;
        m0 r6 = r5.u;
        if (r6 == null) goto L27;
        r1 = r6.t;
        goto L27
    L18:
        m0 r7 = r5.u;
        if (r7 == null) goto L27;
        r1 = r7.s;
        goto L27
    L28:
        return this.instructionInputBoxHint;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.larus.bmhome.view.actionbar.edit.InstructionEditorViewModel$special$$inlined$filter$1] */
    public InstructionEditorViewModel() {
        this.instructionType = 0;
        this.instructionUsuallyStateConfList = new ArrayList();
        StateFlowImpl r2 = j1.a(0);
        this._instructionSelectMenuPosition = r2;
        this.instructionSelectMenuPosition = r2;
        MutableSharedFlow<Integer> r4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._instructionEditorViewStatus = r4;
        this.instructionEditorViewStatus = r4;
        StateFlowImpl r5 = j1.a(0);
        this._instructionReferenceImageUploadStatus = r5;
        this.instructionReferenceImageUploadStatus = r5;
        Boolean r6 = Boolean.FALSE;
        StateFlowImpl r7 = j1.a(r6);
        this._chosenAvatarInstructionStatus = r7;
        this.chosenAvatarInstructionStatus = kotlinx.coroutines.flow.e.b(r7);
        MutableSharedFlow<String> r8 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._chosenAvatarInstructionFlow = r8;
        this.chosenAvatarInstructionFlow = r8;
        StateFlowImpl r9 = j1.a(r6);
        this._avatarSelectFlow = r9;
        this.avatarSelectedFlow = kotlinx.coroutines.flow.e.b(r9);
        MutableSharedFlow<Boolean> r10 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._avatarBtnClickFlow = r10;
        this.avatarBtnClickFlow = kotlinx.coroutines.flow.e.a(r10);
        MutableSharedFlow<Unit> r11 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._avatarBtnCancelFlow = r11;
        this.avatarBtnCancelFlow = kotlinx.coroutines.flow.e.a(r11);
        MutableSharedFlow<aq8.j> r12 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._actionBarInstructionChanged = r12;
        this.actionBarInstructionChanged = r12;
        MutableSharedFlow<i0> r13 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._instructionTabSelected = r13;
        this.instructionTabSelected = r13;
        MutableSharedFlow<String> r14 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._instructionFeatureSelectedForPrompt = r14;
        this.instructionFeatureSelectedForPrompt = r14;
        MutableSharedFlow<m> r15 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._instructionPhotoTemplatePrompt = r15;
        this.instructionPhotoTemplatePrompt = r15;
        MutableSharedFlow<com.larus.bmhome.actionbar.model.f> r16 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._instructionDigitalAvatarTemplatePrompt = r16;
        this.instructionDigitalAvatarTemplatePrompt = r16;
        MutableSharedFlow<String> r17 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._instructionVideoTemplatePrompt = r17;
        this.instructionVideoTemplatePrompt = r17;
        MutableSharedFlow<Triple<ab8.a, Integer, String>> r18 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._digitalAvatarTemplateChooseFlow = r18;
        this.digitalAvatarTemplateChooseFlow = kotlinx.coroutines.flow.e.a(r18);
        MutableSharedFlow<String> r19 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._invokeSendMessage = r19;
        this.invokeSendMessage = r19;
        MutableSharedFlow<bq8.a> r20 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._instructionMusicTemplatePrompt = r20;
        this.instructionMusicTemplatePrompt = r20;
        MutableSharedFlow<Boolean> r21 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._instructionMusicTemplateDetailOpen = r21;
        this.instructionMusicTemplateDetailOpen = r21;
        MutableSharedFlow<String> r22 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._instructionFeatureUnSelectedForPrompt = r22;
        this.instructionFeatureUnSelectedForPrompt = r22;
        MutableSharedFlow<Boolean> r23 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._instructionFeatureDialogDismiss = r23;
        this.instructionFeatureDialogDismiss = r23;
        MutableSharedFlow<p1> r24 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._chosenMsgInstructionFlow = r24;
        this.chosenMsgInstructionFlow = kotlinx.coroutines.flow.e.a(r24);
        MutableSharedFlow<List<w>> r25 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._imageListSelectorWithMoreRefreshFlow = r25;
        this.imageListSelectorWithMoreRefreshFlow = kotlinx.coroutines.flow.e.a(r25);
        this.enableResetTemplateCacheAfterDetach = true;
        MutableSharedFlow<Unit> r26 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._resetImageStyleListFlow = r26;
        this.resetImageStyleListFlow = kotlinx.coroutines.flow.e.a(r26);
        MutableSharedFlow<fq8.e> r27 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._chosenImgInspirationFlow = r27;
        this.chosenImgInspirationFlow = kotlinx.coroutines.flow.e.a(r27);
        MutableSharedFlow<Pair<ConstraintLayout, Boolean>> r28 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._componentVisibilityChangedFlow = r28;
        this.componentVisibilityChangedFlow = kotlinx.coroutines.flow.e.a(r28);
        this.collegeEntranceExamClickLiveData = new MutableLiveData();
        StateFlowImpl r29 = j1.a(r6);
        this._mediaSelectedFlow = r29;
        this.mediaSelectedFlow = kotlinx.coroutines.flow.e.b(r29);
        StateFlowImpl r30 = j1.a(r6);
        this._mediaUploadedFlow = r30;
        this.mediaUploadedFlow = kotlinx.coroutines.flow.e.b(r30);
        StateFlowImpl r31 = j1.a(new ArrayList());
        this._hideInstructionFlow = r31;
        this.hideInstructionFlow = kotlinx.coroutines.flow.e.b(r31);
        StateFlowImpl r32 = j1.a(r6);
        this._enableOriginalRatioFlow = r32;
        this.enableOriginalRatioFlow = kotlinx.coroutines.flow.e.b(r32);
        MutableSharedFlow<q> r33 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._selectRatioFlow = r33;
        this.selectRatioFlow = kotlinx.coroutines.flow.e.a(r33);
        this.selectedClickRatioIdRegistry = new LinkedHashMap();
        StateFlowImpl r34 = j1.a(null);
        this._selectVideoModelFlow = r34;
        this.selectVideoModelFlow = r34;
        StateFlowImpl r35 = j1.a(null);
        this._selectModelFlow = r35;
        this.selectModelFlow = r35;
        MutableSharedFlow<o> r36 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._selectDurationFlow = r36;
        this.selectDurationFlow = kotlinx.coroutines.flow.e.a(r36);
        MutableSharedFlow<String> r37 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._instructionInputBoxTextChanged = r37;
        this.instructionInputBoxTextChanged = r37;
        this.instructionInputBoxText = "";
        MutableSharedFlow<String> r38 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._inputBoxHintChanged = r38;
        this.inputBoxHintChanged = r38;
        MutableSharedFlow<t1> r39 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._optionParamFilterConfChanged = r39;
        this.optionParamFilterConfChanged = r39;
        this.currentOpenFrom = 0;
        MutableSharedFlow<Boolean> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._actionBarInstructionInputSendReady = r0;
        this.actionBarInstructionInputSendReady = r0;
        this.actionBarItemMap = new LinkedHashMap();
        this.multiTabHintMap = new LinkedHashMap();
        StateFlowImpl r1 = j1.a(0L);
        this._selectedVideoStyle = r1;
        this.selectedVideoStyle = r1;
        StateFlowImpl r3 = j1.a(CollectionsKt.emptyList());
        this._attachmentResources = r3;
        this.attachmentResources = r3;
        final Flow r40 = kotlinx.coroutines.flow.e.n(kotlinx.coroutines.flow.e.k(this._instructionSelectMenuPosition, r7, r34, r35, new InstructionEditorViewModel$jumpToCompleteVideoAvatarEvent$1(this, null)));
        final ?? r41 = new InstructionEditorViewModel$special$$inlined$filter$1(r40);
        this.jumpToCompleteVideoAvatarEvent = new InstructionEditorViewModel$special$$inlined$map$1(r41);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public CoroutineScope getCurrentViewModelScope() {
        return ViewModelKt.getViewModelScope(this);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public /* bridge */ /* synthetic */ i1 getSelectModelFlow() {
        return m24getSelectModelFlow();
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public boolean isInVideoTab() {
        r r0 = getCurrentInstructionConf();
        if (r0 == null) goto L19;
        y r1 = r0.i;
        if (r1 == null) goto L20;
        ArrayList r2 = r1.a;
        if (r2 == null) goto L21;
        com.larus.bmhome.actionbar.model.z0 r3 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r2, ((Number) getInstructionSelectMenuPosition().getValue()).intValue());
        if (r3 == null) goto L22;
        r r4 = r3.q;
        if (r4 == null) goto L23;
        Integer r5 = r4.a;
        if (r5 != null) goto L16;
        return false;
    L16:
        if (r5.intValue() != 18) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L19:
        return false;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onAvatarBtnCancel() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01551(this, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onFeatureOptionDialogDismiss() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01591(this, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onMusicDetailDialogDismiss() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01721(this, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onMusicDetailDialogOpen() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01731(this, null), 3, null);
    }

    public void resetImageStyleList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01781(this, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<aq8.j> getActionBarInstructionChanged() {
        return this.actionBarInstructionChanged;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<Boolean> getActionBarInstructionInputSendReady() {
        return this.actionBarInstructionInputSendReady;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Boolean getActionBarInstructionInputSendReadyState() {
        return this._actionBarInstructionInputSendReadyState;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public String getActionBarName() {
        return this.actionBarName;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public String getActionBarType() {
        return this.actionBarType;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public i1<List<ResourceItemBean>> getAttachmentResources() {
        return this.attachmentResources;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<Unit> getAvatarBtnCancelFlow() {
        return this.avatarBtnCancelFlow;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<Boolean> getAvatarBtnClickFlow() {
        return this.avatarBtnClickFlow;
    }

    public i1<Boolean> getAvatarSelectedFlow() {
        return this.avatarSelectedFlow;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public ChatParam getChatParam() {
        return this.chatParam;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<String> getChosenAvatarInstructionFlow() {
        return this.chosenAvatarInstructionFlow;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public i1<Boolean> getChosenAvatarInstructionStatus() {
        return this.chosenAvatarInstructionStatus;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<fq8.e> getChosenImgInspirationFlow() {
        return this.chosenImgInspirationFlow;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public fq8.e getChosenImgInspirePrompt() {
        return this.chosenImgInspirePrompt;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public p1 getChosenMsgInstruction() {
        return this.chosenMsgInstruction;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<p1> getChosenMsgInstructionFlow() {
        return this.chosenMsgInstructionFlow;
    }

    public final MutableLiveData<String> getCollegeEntranceExamClickLiveData() {
        return this.collegeEntranceExamClickLiveData;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<Pair<ConstraintLayout, Boolean>> getComponentVisibilityChangedFlow() {
        return this.componentVisibilityChangedFlow;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public List<w> getCurImageList() {
        return this.curImageList;
    }

    public final Integer getCurrentActionBarId() {
        return this.currentActionBarId;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public com.larus.bmhome.actionbar.model.z0 getCurrentCustomActionBarItem() {
        return this.currentCustomActionBarItem;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public r getCurrentInstructionConf() {
        return this.currentInstructionConf;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public r getCurrentInstructionUsuallyConfig() {
        return this.currentInstructionUsuallyConfig;
    }

    public final Integer getCurrentOpenFrom() {
        return this.currentOpenFrom;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Long getDefaultSelectedImageStyleId() {
        return this.defaultSelectedImageStyleId;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<Triple<ab8.a, Integer, String>> getDigitalAvatarTemplateChooseFlow() {
        return this.digitalAvatarTemplateChooseFlow;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Function0<Boolean> getDropDownSelectorClickInterceptor() {
        return this.dropDownSelectorClickInterceptor;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public i1<Boolean> getEnableOriginalRatioFlow() {
        return this.enableOriginalRatioFlow;
    }

    public final boolean getEnableResetTemplateCacheAfterDetach() {
        return this.enableResetTemplateCacheAfterDetach;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public i1<ArrayList<Integer>> getHideInstructionFlow() {
        return this.hideInstructionFlow;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<List<w>> getImageListSelectorWithMoreRefreshFlow() {
        return this.imageListSelectorWithMoreRefreshFlow;
    }

    public final boolean getImageReferenceUploaded() {
        return this.imageReferenceUploaded;
    }

    public final boolean getImageStyleRadioSelected() {
        return this.imageStyleRadioSelected;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<String> getInputBoxHintChanged() {
        return this.inputBoxHintChanged;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Map<String, ?> getInstructionDefaultParams() {
        return this._instructionDefaultParams;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<com.larus.bmhome.actionbar.model.f> getInstructionDigitalAvatarTemplatePrompt() {
        return this.instructionDigitalAvatarTemplatePrompt;
    }

    public final d1<Integer> getInstructionEditorViewStatus() {
        return this.instructionEditorViewStatus;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<Boolean> getInstructionFeatureDialogDismiss() {
        return this.instructionFeatureDialogDismiss;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<String> getInstructionFeatureSelectedForPrompt() {
        return this.instructionFeatureSelectedForPrompt;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<String> getInstructionFeatureUnSelectedForPrompt() {
        return this.instructionFeatureUnSelectedForPrompt;
    }

    public final String getInstructionInputBoxText() {
        return this.instructionInputBoxText;
    }

    public final d1<String> getInstructionInputBoxTextChanged() {
        return this.instructionInputBoxTextChanged;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<Boolean> getInstructionMusicTemplateDetailOpen() {
        return this.instructionMusicTemplateDetailOpen;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<bq8.a> getInstructionMusicTemplatePrompt() {
        return this.instructionMusicTemplatePrompt;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<m> getInstructionPhotoTemplatePrompt() {
        return this.instructionPhotoTemplatePrompt;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public r getInstructionRebuildStateConf() {
        return this.instructionRebuildStateConf;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public AttachmentInfo getInstructionReferenceImage() {
        return this._instructionReferenceImage;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public i1<Integer> getInstructionReferenceImageUploadStatus() {
        return this.instructionReferenceImageUploadStatus;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public i1<Integer> getInstructionSelectMenuPosition() {
        return this.instructionSelectMenuPosition;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<i0> getInstructionTabSelected() {
        return this.instructionTabSelected;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Integer getInstructionType() {
        return this.instructionType;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<String> getInstructionVideoTemplatePrompt() {
        return this.instructionVideoTemplatePrompt;
    }

    public final d1<String> getInvokeSendMessage() {
        return this.invokeSendMessage;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Flow<Unit> getJumpToCompleteVideoAvatarEvent() {
        return this.jumpToCompleteVideoAvatarEvent;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public i1<Boolean> getMediaSelectedFlow() {
        return this.mediaSelectedFlow;
    }

    public final i1<Boolean> getMediaUploadedFlow() {
        return this.mediaUploadedFlow;
    }

    public final String getMessageExtMapJsonString() {
        return this.messageExtMapJsonString;
    }

    public final Map<String, String> getMsgExtMap() {
        return this._messageExtMap;
    }

    public final boolean getNeedSaveDraft() {
        return this.needSaveDraft;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public t1 getOptionParamFilterConf() {
        return this.optionParamFilterConf;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<t1> getOptionParamFilterConfChanged() {
        return this.optionParamFilterConfChanged;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public boolean getRatioCanBeEmpty() {
        return this._ratioCanBeEmpty;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public List<w> getRatioOptionList() {
        return this._ratioOptionList;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<Unit> getResetImageStyleListFlow() {
        return this.resetImageStyleListFlow;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<o> getSelectDurationFlow() {
        return this.selectDurationFlow;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public d1<q> getSelectRatioFlow() {
        return this.selectRatioFlow;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public i1<p> getSelectVideoModelFlow() {
        return this.selectVideoModelFlow;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Map<Integer, Long> getSelectedClickRatioIdRegistry() {
        return this.selectedClickRatioIdRegistry;
    }

    public Long getSelectedModelId() {
        return this.selectedModelId;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Long getSelectedRatioId() {
        return this.selectedRatioId;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Long getSelectedVideoModelId() {
        return this.selectedVideoModelId;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public i1<Long> getSelectedVideoStyle() {
        return this.selectedVideoStyle;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public String getTemplateType() {
        return this.templateType;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Function0<Boolean> getVideoModelDropDownSelectorClickInterceptor() {
        return this.videoModelDropDownSelectorClickInterceptor;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Function2<Long, Boolean, Boolean> getVideoModelSelectionInterceptor() {
        return this.videoModelSelectionInterceptor;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public Boolean isCreationActionBar() {
        return this.isCreationActionBar;
    }

    public final boolean isModifying() {
        return this.isModifying;
    }

    /* JADX INFO: renamed from: getSelectModelFlow, reason: collision with other method in class */
    public z0<p> m24getSelectModelFlow() {
        return this.selectModelFlow;
    }

    public static final /* synthetic */ Map access$getActionBarItemMap$p(InstructionEditorViewModel r0) {
        return r0.actionBarItemMap;
    }

    public static final /* synthetic */ List access$getInstructionUsuallyStateConfList$p(InstructionEditorViewModel r0) {
        return r0.instructionUsuallyStateConfList;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionBarInstructionChanged$p(InstructionEditorViewModel r0) {
        return r0._actionBarInstructionChanged;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionBarInstructionInputSendReady$p(InstructionEditorViewModel r0) {
        return r0._actionBarInstructionInputSendReady;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_avatarBtnCancelFlow$p(InstructionEditorViewModel r0) {
        return r0._avatarBtnCancelFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_avatarBtnClickFlow$p(InstructionEditorViewModel r0) {
        return r0._avatarBtnClickFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_chosenAvatarInstructionFlow$p(InstructionEditorViewModel r0) {
        return r0._chosenAvatarInstructionFlow;
    }

    public static final /* synthetic */ z0 access$get_chosenAvatarInstructionStatus$p(InstructionEditorViewModel r0) {
        return r0._chosenAvatarInstructionStatus;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_chosenImgInspirationFlow$p(InstructionEditorViewModel r0) {
        return r0._chosenImgInspirationFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_chosenMsgInstructionFlow$p(InstructionEditorViewModel r0) {
        return r0._chosenMsgInstructionFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_componentVisibilityChangedFlow$p(InstructionEditorViewModel r0) {
        return r0._componentVisibilityChangedFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_digitalAvatarTemplateChooseFlow$p(InstructionEditorViewModel r0) {
        return r0._digitalAvatarTemplateChooseFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_imageListSelectorWithMoreRefreshFlow$p(InstructionEditorViewModel r0) {
        return r0._imageListSelectorWithMoreRefreshFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_inputBoxHintChanged$p(InstructionEditorViewModel r0) {
        return r0._inputBoxHintChanged;
    }

    public static final /* synthetic */ Map access$get_instructionDefaultParams$p(InstructionEditorViewModel r0) {
        return r0._instructionDefaultParams;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_instructionDigitalAvatarTemplatePrompt$p(InstructionEditorViewModel r0) {
        return r0._instructionDigitalAvatarTemplatePrompt;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_instructionEditorViewStatus$p(InstructionEditorViewModel r0) {
        return r0._instructionEditorViewStatus;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_instructionFeatureDialogDismiss$p(InstructionEditorViewModel r0) {
        return r0._instructionFeatureDialogDismiss;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_instructionFeatureSelectedForPrompt$p(InstructionEditorViewModel r0) {
        return r0._instructionFeatureSelectedForPrompt;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_instructionFeatureUnSelectedForPrompt$p(InstructionEditorViewModel r0) {
        return r0._instructionFeatureUnSelectedForPrompt;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_instructionInputBoxTextChanged$p(InstructionEditorViewModel r0) {
        return r0._instructionInputBoxTextChanged;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_instructionMusicTemplateDetailOpen$p(InstructionEditorViewModel r0) {
        return r0._instructionMusicTemplateDetailOpen;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_instructionMusicTemplatePrompt$p(InstructionEditorViewModel r0) {
        return r0._instructionMusicTemplatePrompt;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_instructionPhotoTemplatePrompt$p(InstructionEditorViewModel r0) {
        return r0._instructionPhotoTemplatePrompt;
    }

    public static final /* synthetic */ z0 access$get_instructionReferenceImageUploadStatus$p(InstructionEditorViewModel r0) {
        return r0._instructionReferenceImageUploadStatus;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_instructionTabSelected$p(InstructionEditorViewModel r0) {
        return r0._instructionTabSelected;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_instructionVideoTemplatePrompt$p(InstructionEditorViewModel r0) {
        return r0._instructionVideoTemplatePrompt;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_invokeSendMessage$p(InstructionEditorViewModel r0) {
        return r0._invokeSendMessage;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_optionParamFilterConfChanged$p(InstructionEditorViewModel r0) {
        return r0._optionParamFilterConfChanged;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_resetImageStyleListFlow$p(InstructionEditorViewModel r0) {
        return r0._resetImageStyleListFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_selectDurationFlow$p(InstructionEditorViewModel r0) {
        return r0._selectDurationFlow;
    }

    public static final /* synthetic */ z0 access$get_selectModelFlow$p(InstructionEditorViewModel r0) {
        return r0._selectModelFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_selectRatioFlow$p(InstructionEditorViewModel r0) {
        return r0._selectRatioFlow;
    }

    public static final /* synthetic */ z0 access$get_selectVideoModelFlow$p(InstructionEditorViewModel r0) {
        return r0._selectVideoModelFlow;
    }

    public static final /* synthetic */ void access$resetInstructionData(InstructionEditorViewModel r0) {
        r0.resetInstructionData();
    }

    private final boolean selectedVideoMenu(int r3) {
        r r0 = getCurrentInstructionConf();
        if (r0 == null) goto L19;
        y r1 = r0.i;
        if (r1 == null) goto L20;
        ArrayList r2 = r1.a;
        if (r2 == null) goto L21;
        com.larus.bmhome.actionbar.model.z0 r4 = (com.larus.bmhome.actionbar.model.z0) CollectionsKt.getOrNull(r2, r3);
        if (r4 == null) goto L22;
        r r5 = r4.q;
        if (r5 == null) goto L23;
        Integer r6 = r5.a;
        if (r6 != null) goto L16;
        return false;
    L16:
        if (r6.intValue() != 18) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L19:
        return false;
    }

    private final void setImageReferenceUploaded(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01841(this, r7, null), 3, null);
    }

    private final void set_messageExtMap(Map<String, String> r4) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("_messageExtMap:");
        Map<String, String> r2 = this._messageExtMap;
        if (r2 == null) goto L5;
        int r3 = r2.size();
    L6:
        r1.append(r3);
        r0.i(TAG, r1.toString());
        if (r4 == null) goto L9;
        String r5 = HttpExtKt.p(r4);
    L10:
        this.messageExtMapJsonString = r5;
        this._messageExtMap = r4;
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void bindChatParam(ChatParam r2) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        setChatParam(r2);
    }

    public final void bindChatUsuallyStateConf(r r2) {
        if (r2 == null) goto L5;
        this.instructionUsuallyStateConfList.clear();
        this.instructionUsuallyStateConfList.add(r2);
        return;
    }

    public final com.larus.bmhome.actionbar.model.z0 getCustomActionBarItem(String r2) {
        Intrinsics.checkNotNullParameter(r2, "botId");
        return this.actionBarItemMap.get(r2);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void markInputSendReadyState(boolean r1) {
        this._actionBarInstructionInputSendReadyState = Boolean.valueOf(r1);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onAvatarBtnClick(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01561(this, r7, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onAvatarInstructionClicked(String r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01571(this, r7, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onFeatureOptionSelected(w r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01601(r7, this, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onFeatureOptionUnSelected(w r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01611(r7, this, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onImgInspirationClick(fq8.e r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01621(this, r8, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onInputBoxTextChanged(String r8) {
        Intrinsics.checkNotNullParameter(r8, "inputContent");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01631(this, r8, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onInstructionDigitalAvatarTemplateSelected(com.larus.bmhome.actionbar.model.f r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01651(r7, this, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onInstructionMusicTemplateSelected(bq8.a r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01681(r7, this, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onInstructionReferenceImageChanged(AttachmentInfo r1) {
        this._instructionReferenceImage = r1;
        if (getInstructionReferenceImage() == null) goto L5;
        boolean r2 = true;
    L6:
        setImageReferenceUploaded(r2);
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onInstructionReferenceImageUploadStatus(int r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01691(this, r7, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onMsgInstructionClicked(p1 r8) {
        Intrinsics.checkNotNullParameter(r8, "item");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01711(this, r8, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onParamFilterConfChanged(t1 r8) {
        Intrinsics.checkNotNullParameter(r8, "paramFilterConf");
        setOptionParamFilterConf(r8);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01741(this, r8, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onTabSelected(i0 r8) {
        Intrinsics.checkNotNullParameter(r8, "tabSelectorTemplate");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01751(this, r8, null), 3, null);
    }

    public void onVideoTemplateChoose(String r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01761(this, r7, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void refreshImageListSelectorWithMore(List<w> r8) {
        Intrinsics.checkNotNullParameter(r8, "imageList");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01771(this, r8, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void selectDuration(long r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01791(this, r7, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void selectInstructionMenu(int r2) {
        this._instructionSelectMenuPosition.setValue(Integer.valueOf(r2));
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void selectRatio(long r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01811(this, r7, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public boolean selectVideoModel(long r6) {
        Long r0 = getSelectedVideoModelId();
        if (r0 != null) goto L6;
    L7:
        Function2<Long, Boolean, Boolean> r1 = getVideoModelSelectionInterceptor();
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        return false;
    L15:
        syncVideoModel(r6);
        return true;
    L10:
        if (((Boolean) r1.invoke(Long.valueOf(r6), Boolean.TRUE)).booleanValue() != true) goto L12;
        r2 = true;
        goto L13
    L6:
        if (r0.longValue() == r6) goto L15;
        goto L7
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void selectedVideoStyleItem(long r2) {
        this._selectedVideoStyle.setValue(Long.valueOf(r2));
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setActionBarInstructionInputSendReady(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01821(this, r7, null), 3, null);
    }

    public void setActionBarName(String r1) {
        this.actionBarName = r1;
    }

    public void setActionBarType(String r1) {
        this.actionBarType = r1;
    }

    public void setChatParam(ChatParam r1) {
        this.chatParam = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setChosenAvatarInstructionStatus(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01831(this, r7, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setChosenImgInspirePrompt(fq8.e r1) {
        this.chosenImgInspirePrompt = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setChosenMsgInstruction(p1 r1) {
        this.chosenMsgInstruction = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setCreationActionBar(Boolean r1) {
        this.isCreationActionBar = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setCurImageList(List<w> r1) {
        this.curImageList = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setCurrentCustomActionBarItem(com.larus.bmhome.actionbar.model.z0 r1) {
        this.currentCustomActionBarItem = r1;
    }

    public void setCurrentInstructionConf(r r1) {
        this.currentInstructionConf = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setCurrentInstructionConfig(r r2) {
        Intrinsics.checkNotNullParameter(r2, "conf");
        setCurrentInstructionConf(r2);
        setInstructionType(r2.a);
    }

    public void setCurrentInstructionUsuallyConfig(r r1) {
        this.currentInstructionUsuallyConfig = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setDefaultSelectedImageStyleId(Long r1) {
        this.defaultSelectedImageStyleId = r1;
    }

    public void setDropDownSelectorClickInterceptor(Function0<Boolean> r1) {
        this.dropDownSelectorClickInterceptor = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setEnableResetTemplateCacheAfterDetach(boolean r1) {
        this.enableResetTemplateCacheAfterDetach = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setImageStyleRadioSelected(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01851(this, r7, null), 3, null);
    }

    public void setInstructionRebuildStateConf(r r1) {
        this.instructionRebuildStateConf = r1;
    }

    public void setInstructionType(Integer r1) {
        this.instructionType = r1;
    }

    public final void setModifying(boolean r1) {
        this.isModifying = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setOptionParamFilterConf(t1 r1) {
        this.optionParamFilterConf = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setOriginalRatioEnable(boolean r2) {
        this._enableOriginalRatioFlow.setValue(Boolean.valueOf(r2));
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setRatioCanBeEmpty(boolean r1) {
        this._ratioCanBeEmpty = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setRatioDropDownSelectorClickInterceptor(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        setDropDownSelectorClickInterceptor(r2);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setRatioOptionList(List<w> r1) {
        this._ratioOptionList = r1;
    }

    public void setSelectedClickRatioIdRegistry(Map<Integer, Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selectedClickRatioIdRegistry = r2;
    }

    public void setSelectedModelId(Long r1) {
        this.selectedModelId = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setSelectedRatioId(Long r1) {
        this.selectedRatioId = r1;
    }

    public void setSelectedVideoModelId(Long r1) {
        this.selectedVideoModelId = r1;
    }

    public void setTemplateType(String r1) {
        this.templateType = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setVideoModelDropDownSelectorClickInterceptor(Function0<Boolean> r1) {
        this.videoModelDropDownSelectorClickInterceptor = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setVideoModelSelectionInterceptor(Function2<? super Long, ? super Boolean, Boolean> r1) {
        this.videoModelSelectionInterceptor = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void syncVideoModel(long r8) {
        setSelectedVideoModelId(Long.valueOf(r8));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01861(this, r8, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void updateAttachmentResources(List<ResourceItemBean> r2) {
        Intrinsics.checkNotNullParameter(r2, "resources");
        this._attachmentResources.tryEmit(CollectionsKt.toList(r2));
    }

    public static final /* synthetic */ boolean access$selectedVideoMenu(InstructionEditorViewModel r0, int r1) {
        return r0.selectedVideoMenu(r1);
    }

    public static final /* synthetic */ void access$setCurrentActionBarId$p(InstructionEditorViewModel r0, Integer r1) {
        r0.currentActionBarId = r1;
    }

    public static final /* synthetic */ void access$setCurrentOpenFrom$p(InstructionEditorViewModel r0, Integer r1) {
        r0.currentOpenFrom = r1;
    }

    public static final /* synthetic */ void access$setImageReferenceUploaded(InstructionEditorViewModel r0, boolean r1) {
        r0.setImageReferenceUploaded(r1);
    }

    public static final /* synthetic */ void access$setImageReferenceUploaded$p(InstructionEditorViewModel r0, boolean r1) {
        r0.imageReferenceUploaded = r1;
    }

    public static final /* synthetic */ void access$setImageStyleRadioSelected$p(InstructionEditorViewModel r0, boolean r1) {
        r0.imageStyleRadioSelected = r1;
    }

    public static final /* synthetic */ void access$setInstructionInputBoxHint$p(InstructionEditorViewModel r0, String r1) {
        r0.instructionInputBoxHint = r1;
    }

    public static final /* synthetic */ void access$setInstructionInputBoxText$p(InstructionEditorViewModel r0, String r1) {
        r0.instructionInputBoxText = r1;
    }

    public static final /* synthetic */ void access$setNeedSaveDraft$p(InstructionEditorViewModel r0, boolean r1) {
        r0.needSaveDraft = r1;
    }

    public static final /* synthetic */ void access$set_instructionDefaultParams$p(InstructionEditorViewModel r0, Map r1) {
        r0._instructionDefaultParams = r1;
    }

    private static final String setMsgExtMap$lambda$0(InstructionEditorViewModel r2, String r3) {
        return "debug messageExtMap:" + r2.messageExtMapJsonString + ", scene:" + r3;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public String getHintStr(int r9, int r10) {
        boolean r2 = true;
        if (((Boolean) getChosenAvatarInstructionStatus().getValue()).booleanValue() == false) goto L12;
        if (r10 != 1) goto L8;
        h1 r11 = this.multiTabHintMap.get(Integer.valueOf(r9));
        if (r11 != null) goto L59;
        return null;
    L59:
        return r11.g;
    L8:
        h1 r12 = this.multiTabHintMap.get(Integer.valueOf(r9));
        if (r12 != null) goto L61;
        return null;
    L61:
        return r12.a;
    L12:
        if (selectedVideoMenu(((Number) getInstructionSelectMenuPosition().getValue()).intValue()) == true) goto L14;
        h1 r13 = this.multiTabHintMap.get(Integer.valueOf(r9));
        if (r13 != null) goto L50;
        return null;
    L50:
        return r13.a;
    L14:
        if (((Number) this._selectedVideoStyle.getValue()).longValue() == 0) goto L16;
        boolean r0 = true;
    L17:
        Iterable r3 = (Iterable) this._attachmentResources.getValue();
        if ((r3 instanceof Collection) == true) goto L20;
    L22:
        Iterator r4 = r3.iterator();
        int r5 = 0;
    L24:
        if (r4.hasNext() == false) goto L36;
        ResourceItemBean r6 = (ResourceItemBean) r4.next();
        if (r6.getResourceType() != ResourceType.IMAGE) goto L28;
    L31:
        boolean r7 = true;
    L32:
        if (r7 == false) goto L24;
        r5 = r5 + 1;
        if (r5 >= 0) goto L24;
        CollectionsKt.throwCountOverflow();
        goto L24
    L28:
        if (r6.getResourceType() == ResourceType.VIDEO) goto L31;
        r7 = false;
    L36:
        if (r5 == 0) goto L39;
        r2 = false;
    L39:
        if (r0 == false) goto L44;
        if (r2 == false) goto L44;
        h1 r14 = this.multiTabHintMap.get(Integer.valueOf(r9));
        if (r14 != null) goto L63;
        return null;
    L63:
        return r14.i;
    L44:
        h1 r15 = this.multiTabHintMap.get(Integer.valueOf(r9));
        if (r15 != null) goto L65;
        return null;
    L65:
        return r15.a;
    L20:
        if (((Collection) r3).isEmpty() == false) goto L22;
        r5 = 0;
        goto L36
    L16:
        r0 = false;
        goto L17
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onComponentVisibilityChanged(Object r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "component");
        if ((r9 instanceof AbsInstructionWidget) == false) goto L5;
        AbsInstructionWidget r0 = (AbsInstructionWidget) r9;
    L6:
        if (r0 == null) goto L9;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InstructionEditorViewModel$onComponentVisibilityChanged$1$1(this, r9, r10, null), 3, null);
        return;
    L9:
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onInputHintChanged(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "from");
        FLogger.a.i(TAG, "onInputHintChanged, hint: " + r9 + ", from: " + r10);
        this.instructionInputBoxHint = r9;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01641(this, r9, null), 3, null);
    }

    public final void onInstructionEditorViewChanged(int r7, Function0<Unit> r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01661(r7, this, r8, null), 3, null);
        if (r7 != 0) goto L6;
        this.isModifying = false;
        return;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onInstructionImageTemplateSelected(TemplateInfo.TemplateInfo r7, Uri r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01671(r7, this, r8, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public boolean selectModel(int r11, long r12) {
        if (r11 != 18) goto L13;
        Long r0 = getSelectedVideoModelId();
        if (r0 == null) goto L10;
        if (r0.longValue() == r12) goto L13;
    L10:
        if (selectVideoModel(r12) == true) goto L13;
        return false;
    L13:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01801(this, r11, r12, null), 3, null);
        return true;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void selectRatio(int r11, long r12) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, r11, r12, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setMsgExtMap(Map<String, String> r4, final String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        set_messageExtMap(r4);
        w1.a(TAG, new j(this, r5));
        FLogger r6 = FLogger.a;
        StringBuilder r1 = new StringBuilder("set has messageExtMap:");
        Map<String, String> r2 = this._messageExtMap;
        if (r2 == null) goto L5;
        int r3 = r2.size();
    L6:
        r1.append(r3);
        r1.append(", scene:");
        r1.append(r5);
        r6.i(TAG, r1.toString());
        return;
    L5:
        r3 = 0;
        goto L6
    }

    public final void updateConversationId(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "botId");
        Intrinsics.checkNotNullParameter(r9, "conversationId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01871(this, r8, r9, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void updateInputBoxPlaceHolder(int r3, h1 r4) {
        if (r4 != null) goto L4;
        h1 r5 = this.multiTabHintMap.remove(Integer.valueOf(r3));
        return;
    L4:
        Map<Integer, h1> r0 = this.multiTabHintMap;
        Integer r6 = Integer.valueOf(r3);
        h1 r1 = r0.get(r6);
        if (r1 != null) goto L7;
        r0.put(r6, r4);
    L9:
        return;
    L7:
        r4 = r1;
        goto L9
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onDigitalAvatarTemplateChoose(ab8.a r11, int r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "templateInfo");
        Intrinsics.checkNotNullParameter(r13, "enterFrom");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01581(this, r11, r12, r13, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void setActionBarName(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "actionBarName");
        Intrinsics.checkNotNullParameter(r3, "actionBarType");
        setActionBarName(r2);
        setActionBarType(r3);
        setTemplateType(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onInstructionEditorViewChanged$default(InstructionEditorViewModel r0, int r1, Function0 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.onInstructionEditorViewChanged(r1, r2);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onActionBarInstructionChanged(com.larus.bmhome.actionbar.model.z0 r15, r r16, int r17, String r18, aq8.e r19, Integer r20, Function0<Unit> r21) {
        Intrinsics.checkNotNullParameter(r15, "actionBarItem");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r15, r19, r16, r20, r18, r17, r21, null), 3, null);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.c
    public void onMediaContainerStatusChanged(boolean r13, boolean r14, boolean r15, ArrayList<Integer> r16, boolean r17, boolean r18, int r19) {
        Intrinsics.checkNotNullParameter(r16, "hideInstructionList");
        this._mediaUploadedFlow.setValue(Boolean.valueOf(r14));
        this._mediaSelectedFlow.setValue(Boolean.valueOf(r13));
        this._hideInstructionFlow.setValue(r16);
        z0<Boolean> r0 = this._enableOriginalRatioFlow;
        if (r13 == false) goto L6;
        if (r15 == true) goto L6;
        boolean r1 = true;
    L7:
        r0.setValue(Boolean.valueOf(r1));
        this._avatarSelectFlow.setValue(Boolean.valueOf(r18));
        this.uploadSuccessRefImgCnt = r19;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01701(this, r13, r18, r19, r17, null), 3, null);
        return;
    L6:
        r1 = false;
        goto L7
    }
}
