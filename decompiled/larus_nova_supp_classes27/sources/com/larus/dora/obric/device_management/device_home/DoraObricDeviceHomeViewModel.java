package com.larus.dora.obric.device_management.device_home;

import android.app.Application;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.news.common.settings.SettingsManager;
import com.larus.account.base.api.ILoginService;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.dora.impl.core.BindAndConnectResult;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.OnlyBindResult;
import com.larus.dora.impl.core.OnlyConnectResult;
import com.larus.dora.impl.device.manage.DeviceMode;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveManager;
import com.larus.dora.impl.device.settings.lab.env.EnvObserveSettingAction;
import com.larus.dora.impl.device.settings.lab.env.timer.TimerJob;
import com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.impl.settings.DoraSetting;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Ç\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t*\u0007UX[^adg\b\u0000\u0018\u0000 \u0094\u00022\u00020\u0001:\b\u0091\u0002\u0092\u0002\u0093\u0002\u0094\u0002B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010i\u001a\u00020jH\u0002J\b\u0010k\u001a\u00020jH\u0002J\n\u0010l\u001a\u0004\u0018\u00010SH\u0002J\u0010\u0010m\u001a\u00020j2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010n\u001a\u00020j2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010o\u001a\u00020jJ\u0018\u0010p\u001a\u00020j2\u0006\u0010q\u001a\u00020\u001b2\b\b\u0002\u0010r\u001a\u00020\u0019J\u000e\u0010s\u001a\u00020j2\u0006\u0010t\u001a\u000208J\u0006\u0010u\u001a\u00020jJ\u0010\u0010v\u001a\u00020j2\b\b\u0002\u0010w\u001a\u00020\u0019J\u0010\u0010x\u001a\u00020\u00192\u0006\u0010y\u001a\u00020\u0019H\u0002J\u0010\u0010z\u001a\u00020\u00192\u0006\u0010q\u001a\u00020\u001bH\u0002J(\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00190|2\u0006\u0010}\u001a\u00020\u001b2\b\b\u0002\u0010w\u001a\u00020\u0019H\u0082@¢\u0006\u0004\b~\u0010\u007fJ\t\u0010\u0080\u0001\u001a\u00020\u001bH\u0002J\t\u0010\u0081\u0001\u001a\u00020\u001bH\u0002J\u0007\u0010\u0082\u0001\u001a\u00020jJ\u0007\u0010\u0083\u0001\u001a\u00020jJ\u0007\u0010\u0084\u0001\u001a\u00020jJ\u0012\u0010\u0085\u0001\u001a\u00020j2\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u001bJ\u0007\u0010\u0087\u0001\u001a\u00020jJ\u0010\u0010\u0088\u0001\u001a\u00020j2\u0007\u0010\u0086\u0001\u001a\u00020\u001bJ\u0011\u0010\u0089\u0001\u001a\u00020j2\b\u0010\u008a\u0001\u001a\u00030\u008b\u0001J\u0007\u0010\u008c\u0001\u001a\u00020jJ\u0007\u0010\u008d\u0001\u001a\u00020\u0019J\u0007\u0010\u008e\u0001\u001a\u00020\u0019J\u0007\u0010\u008f\u0001\u001a\u00020\u0019J\u0012\u0010\u0090\u0001\u001a\u00020j2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u0092\u0001\u001a\u00020j2\u0007\u0010\u0086\u0001\u001a\u00020\u001bJ\u0010\u0010\u0093\u0001\u001a\u00020j2\u0007\u0010\u0086\u0001\u001a\u00020\u001bJ\u0019\u0010\u0094\u0001\u001a\u00020j2\u0007\u0010\u0086\u0001\u001a\u00020\u001b2\u0007\u0010\u0095\u0001\u001a\u00020HJ\u0019\u0010\u0096\u0001\u001a\u00020j2\u0007\u0010\u0086\u0001\u001a\u00020\u001b2\u0007\u0010\u0095\u0001\u001a\u00020HJ\u0019\u0010\u0097\u0001\u001a\u00020j2\u0007\u0010\u0086\u0001\u001a\u00020\u001b2\u0007\u0010\u0095\u0001\u001a\u00020HJ\u0012\u0010\u0098\u0001\u001a\u00020j2\u0007\u0010\u0086\u0001\u001a\u00020\u001bH\u0002J%\u0010\u0099\u0001\u001a\u00020j2\u0007\u0010\u0086\u0001\u001a\u00020\u001b2\u0007\u0010\u009a\u0001\u001a\u00020\u00192\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0002J\t\u0010\u009d\u0001\u001a\u00020\u0019H\u0002J\t\u0010\u009e\u0001\u001a\u00020jH\u0002J\u0013\u0010\u009f\u0001\u001a\u00020j2\b\u0010\u008a\u0001\u001a\u00030 \u0001H\u0002J\t\u0010¡\u0001\u001a\u00020jH\u0002J\u0012\u0010¢\u0001\u001a\u00020j2\t\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001bJ\u0018\u0010£\u0001\u001a\u00020j2\u0006\u0010t\u001a\u000208H\u0082@¢\u0006\u0003\u0010¤\u0001J\u0018\u0010¥\u0001\u001a\u00020j2\u0006\u0010t\u001a\u000208H\u0086@¢\u0006\u0003\u0010¤\u0001J\u000f\u0010¦\u0001\u001a\u00020j2\u0006\u0010t\u001a\u000208J#\u0010§\u0001\u001a\u00020j2\u0006\u0010t\u001a\u0002082\b\b\u0002\u0010q\u001a\u00020\u001b2\b\b\u0002\u0010r\u001a\u00020\u0019J)\u0010¨\u0001\u001a\u00020j2\u0006\u0010t\u001a\u0002082\u0006\u0010q\u001a\u00020\u001b2\u0007\u0010©\u0001\u001a\u00020\u0019H\u0082@¢\u0006\u0003\u0010ª\u0001J\u0011\u0010«\u0001\u001a\u00020j2\b\u0010t\u001a\u0004\u0018\u000108J\t\u0010¬\u0001\u001a\u00020jH\u0014J\t\u0010\u00ad\u0001\u001a\u00020jH\u0002J\u001f\u0010®\u0001\u001a\u00020j2\u0007\u0010¯\u0001\u001a\u00020\u001b2\u000b\b\u0002\u0010°\u0001\u001a\u0004\u0018\u00010\u0017H\u0002J\t\u0010±\u0001\u001a\u00020\u0017H\u0002J\u0012\u0010²\u0001\u001a\u00020\u00172\u0007\u0010³\u0001\u001a\u000208H\u0002J\u0013\u0010´\u0001\u001a\u00020\u00172\n\b\u0002\u0010t\u001a\u0004\u0018\u000108J\u0017\u0010µ\u0001\u001a\u00020j*\u00020\u00172\b\u0010t\u001a\u0004\u0018\u000108H\u0002J\u0011\u0010¶\u0001\u001a\u00020$2\u0006\u0010t\u001a\u000208H\u0002J\u0013\u0010·\u0001\u001a\u00020\u00172\b\u0010t\u001a\u0004\u0018\u000108H\u0002J\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u001bJ\u0011\u0010¹\u0001\u001a\u00020j2\u0006\u0010t\u001a\u000208H\u0002J\u0015\u0010º\u0001\u001a\u0004\u0018\u0001082\b\u0010»\u0001\u001a\u00030\u008b\u0001H\u0002J\t\u0010¼\u0001\u001a\u00020\u0019H\u0002J\u001d\u0010½\u0001\u001a\u00020j2\t\u0010¾\u0001\u001a\u0004\u0018\u0001082\u0007\u0010¿\u0001\u001a\u00020\u001bH\u0002J\u0015\u0010À\u0001\u001a\u0004\u0018\u0001082\b\u0010»\u0001\u001a\u00030\u008b\u0001H\u0002J\u0019\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u000208072\b\u0010»\u0001\u001a\u00030\u008b\u0001H\u0002J\u0017\u0010Â\u0001\u001a\u00020\u0019*\u0002082\b\u0010»\u0001\u001a\u00030\u008b\u0001H\u0002J\u0013\u0010Ã\u0001\u001a\u00020\u001b2\b\u0010»\u0001\u001a\u00030\u008b\u0001H\u0002J\u0011\u0010Ä\u0001\u001a\u00020j2\u0006\u0010t\u001a\u000208H\u0002J\u0011\u0010Å\u0001\u001a\u00020j2\u0006\u0010t\u001a\u000208H\u0002J\u001c\u0010Æ\u0001\u001a\u00020j2\u0006\u0010t\u001a\u0002082\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\u001c\u0010È\u0001\u001a\u00020j2\u0006\u0010t\u001a\u0002082\t\u0010É\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\u001f\u0010Ê\u0001\u001a\u00020j2\r\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u00020807H\u0082@¢\u0006\u0003\u0010Ì\u0001J#\u0010Í\u0001\u001a\u0004\u0018\u0001082\r\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u000208072\u0007\u0010Î\u0001\u001a\u00020\u0019H\u0002J\u0011\u0010Ï\u0001\u001a\u00020j2\u0006\u0010t\u001a\u000208H\u0002J\u0019\u0010Ð\u0001\u001a\u00020j2\u0006\u0010t\u001a\u0002082\u0006\u0010q\u001a\u00020\u001bH\u0002J\u001c\u0010Ñ\u0001\u001a\u00020j2\u0006\u0010t\u001a\u0002082\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\u0011\u0010Ò\u0001\u001a\u00020j2\u0006\u0010q\u001a\u00020\u001bH\u0002J\u0016\u0010Ó\u0001\u001a\u00020j2\u000b\b\u0002\u0010Ô\u0001\u001a\u0004\u0018\u00010\u001bH\u0002J\u001b\u0010Õ\u0001\u001a\u00020j2\t\b\u0002\u0010Ö\u0001\u001a\u00020\u0019H\u0082@¢\u0006\u0003\u0010×\u0001J+\u0010Ø\u0001\u001a\u00020j2\r\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u000208072\t\u0010³\u0001\u001a\u0004\u0018\u0001082\u0006\u0010q\u001a\u00020\u001bH\u0002J\u0010\u0010Ù\u0001\u001a\u00020jH\u0082@¢\u0006\u0003\u0010Ú\u0001J\u0011\u0010Û\u0001\u001a\u00020j2\u0006\u0010q\u001a\u00020\u001bH\u0002J\u001b\u0010Ü\u0001\u001a\u00020j2\b\u0010t\u001a\u0004\u0018\u0001082\u0006\u0010q\u001a\u00020\u001bH\u0002J\u001d\u0010Ý\u0001\u001a\u00030Þ\u00012\u0006\u0010t\u001a\u0002082\t\b\u0002\u0010ß\u0001\u001a\u00020\u0019H\u0002J(\u0010à\u0001\u001a\t\u0012\u0005\u0012\u00030á\u0001072\r\u0010â\u0001\u001a\b\u0012\u0004\u0012\u000208072\u0007\u0010ã\u0001\u001a\u00020\u001bH\u0002J\n\u0010ä\u0001\u001a\u00030å\u0001H\u0002J\t\u0010æ\u0001\u001a\u00020jH\u0002J%\u0010ç\u0001\u001a\t\u0012\u0005\u0012\u00030è\u0001072\b\u0010é\u0001\u001a\u00030ê\u00012\t\u0010³\u0001\u001a\u0004\u0018\u000108H\u0002J\u001a\u0010ë\u0001\u001a\t\u0012\u0005\u0012\u00030ì\u0001072\b\u0010é\u0001\u001a\u00030ê\u0001H\u0002J\u0007\u0010í\u0001\u001a\u00020\u001bJ\t\u0010î\u0001\u001a\u00020\u0019H\u0002J\u000f\u0010ï\u0001\u001a\u00020\u0019*\u0004\u0018\u000108H\u0002J.\u0010ð\u0001\u001a\u00030ñ\u00012\u0006\u0010t\u001a\u0002082\b\u0010\u008a\u0001\u001a\u00030ò\u00012\u0007\u0010ó\u0001\u001a\u00020\u00192\u0007\u0010ô\u0001\u001a\u00020\u0019H\u0002J\u001c\u0010õ\u0001\u001a\u00030ñ\u00012\u0006\u0010t\u001a\u0002082\b\u0010\u008a\u0001\u001a\u00030ò\u0001H\u0002J\u0012\u0010ö\u0001\u001a\u00030ñ\u00012\u0006\u0010t\u001a\u000208H\u0002J\u0011\u0010÷\u0001\u001a\u00020\u001b2\u0006\u0010t\u001a\u000208H\u0002J\u0012\u0010ø\u0001\u001a\u00030ñ\u00012\u0006\u0010t\u001a\u000208H\u0002J\u001b\u0010ù\u0001\u001a\u00020\u001b2\u0007\u0010ú\u0001\u001a\u00020\u001b2\u0007\u0010û\u0001\u001a\u00020\u001bH\u0002J\u0014\u0010ü\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010ý\u0001\u001a\u00020$H\u0002J\u0012\u0010þ\u0001\u001a\u00020\u001b2\u0007\u0010ú\u0001\u001a\u00020\u001bH\u0002J\u0012\u0010ÿ\u0001\u001a\u00020$2\u0007\u0010\u0080\u0002\u001a\u00020\u001bH\u0002J\u0013\u0010\u0081\u0002\u001a\u00030ñ\u00012\u0007\u0010\u0082\u0002\u001a\u00020\u001bH\u0002J\u0010\u0010\u0083\u0002\u001a\u00030\u0084\u0002*\u0004\u0018\u000108H\u0002J\u0015\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u001e\u0010\u0086\u0002\u001a\b\u0012\u0004\u0012\u000208072\r\u0010â\u0001\u001a\b\u0012\u0004\u0012\u00020807H\u0002J\u0012\u0010\u0087\u0002\u001a\u00020j2\u0007\u0010\u0091\u0001\u001a\u00020\u001bH\u0002J\t\u0010\u0088\u0002\u001a\u00020jH\u0002J\u0018\u0010\u0089\u0002\u001a\u00020j2\u0006\u0010t\u001a\u000208H\u0082@¢\u0006\u0003\u0010¤\u0001J\"\u0010\u008a\u0002\u001a\u00020j2\u0006\u0010t\u001a\u0002082\b\u0010\u008b\u0002\u001a\u00030\u008c\u0002H\u0082@¢\u0006\u0003\u0010\u008d\u0002J&\u0010\u008e\u0002\u001a\u0004\u0018\u0001082\u0007\u0010\u0091\u0001\u001a\u00020\u001b2\t\b\u0002\u0010\u008f\u0002\u001a\u00020HH\u0082@¢\u0006\u0003\u0010\u0090\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001e0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001e0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u0004\u0018\u00010*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b+\u0010,R\u001d\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010.\u001a\u0004\b1\u00102R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u00020UX\u0082\u0004¢\u0006\u0004\n\u0002\u0010VR\u0010\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0004\n\u0002\u0010YR\u0010\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\\R\u0010\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0004\n\u0002\u0010_R\u0010\u0010`\u001a\u00020aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010bR\u0010\u0010c\u001a\u00020dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010eR\u0010\u0010f\u001a\u00020gX\u0082\u0004¢\u0006\u0004\n\u0002\u0010h¨\u0006\u0095\u0002"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$UiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_deviceIntentSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/obric/device_management/device_home/DeviceActionV2;", "deviceIntentSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getDeviceIntentSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_action", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeAction;", "action", "getAction", "arguments", "Landroid/os/Bundle;", "isHomeInitialized", "", "currentDeviceMac", "", "pendingEntryDeviceMac", "currentBatteryInfo", "", "currentChargeInfo", "batteryInfoByDeviceMac", "", "chargeInfoByDeviceMac", "lastKnownBindListSize", "", "deviceOrder", "", "usageRepository", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeUsageRepository;", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "Lkotlin/Lazy;", "doraService", "Lcom/larus/dora/api/IDoraService;", "getDoraService", "()Lcom/larus/dora/api/IDoraService;", "doraService$delegate", "usageEvidence", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeUsageEvidence;", "latestBoundDevices", "", "Lcom/bytedance/dora/device/DoraDevice;", "diaryDataAccountId", "connectingJob", "Lkotlinx/coroutines/Job;", "loadJob", "deviceStatusUpdateJob", "connectingDeviceMac", "batteryUpdateJob", "chargeUpdateJob", "deviceCardSelectionJob", "environmentMemoryUpdateJob", "environmentMemorySwitchCooldownPolicy", "Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemorySwitchCooldownPolicy;", "environmentMemoryAuthorizationContinuation", "Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryAuthorizationContinuation;", "environmentMemoryAuthorizationRequestId", "", "diaryDataJob", "diaryDataRequestId", "initialHomeStatePending", "deviceCardSelectionRequestId", "bindCheckJob", "bindCheckMac", "bindCheckRequestId", "needUnbindPromptMac", "currentConfirmedGlassesMode", "registeredAvLinkService", "Lcom/larus/avlink/api/IDoraAVLinkService;", "sceneStateListener", "com/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$sceneStateListener$1", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$sceneStateListener$1;", "environmentMemoryChangeListener", "com/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$environmentMemoryChangeListener$1", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$environmentMemoryChangeListener$1;", "doraVoiceCallback", "com/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$doraVoiceCallback$1", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$doraVoiceCallback$1;", "headphoneModeCallback", "com/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$headphoneModeCallback$1", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$headphoneModeCallback$1;", "deviceStateCallback", "com/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$deviceStateCallback$1", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$deviceStateCallback$1;", "batteryCallback", "com/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$batteryCallback$1", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$batteryCallback$1;", "settingsUpdateListener", "com/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$settingsUpdateListener$1", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$settingsUpdateListener$1;", "registerAvLinkListeners", "", "unregisterAvLinkListeners", "currentAvLinkService", "initialize", "onEntryArgumentsChanged", "onDeviceNameUpdated", "checkCurrentDeviceBindState", "source", "force", "onBindConflictActionStarted", "device", "load", "refreshDeviceHomeDiaryData", "forceRefresh", "isDiaryHomeStateUnchanged", "hasDiaryData", "publishHomeStatusFromLatestDevices", "queryDiaryData", "Lkotlin/Result;", "userId", "queryDiaryData-0E7RQCE", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetDiaryDataForAccountChange", "currentAccountId", "onAddDeviceClicked", "onBindDeviceClicked", "onDeviceCardClicked", "onReconnectStarted", "deviceMac", "onReconnectFailed", "onShutdownSucceeded", "onQuickActionClicked", "type", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickActionType;", "onAlbumSyncRequiresConnection", "onDiaryEntryRequested", "isDiaryEntryAvailable", "hasBoundGlasses", "setInitialDeviceMac", "mac", "onDeviceCardPageSelected", "toggleEnvironmentMemory", "onEnvironmentMemoryAuthorizationCompleted", "requestId", "onEnvironmentMemoryAuthorizationCanceled", "resumeEnvironmentMemoryAuthorization", "requestEnvironmentMemoryAuthorization", "updateEnvironmentMemorySwitch", "enabled", "requestedAction", "Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryClickAction;", "isEnvironmentMemorySwitchCoolingDown", "handleEnvironmentMemorySwitchFailure", "emitEnvironmentMemoryToast", "Lcom/larus/dora/obric/device_management/device_home/DoraObricEnvironmentMemoryToastType;", "invalidateDeviceCardSelection", "handleConnectRequest", "handleEarbudsConnectRequest", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onlyConnect", "replaceBind", "checkBindState", "emitNeedUnbindIfCurrent", "forcePrompt", "(Lcom/bytedance/dora/device/DoraDevice;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectAsync", "onCleared", "openAddDevicePage", "emitRoute", "route", "routeArguments", "createAddDeviceArguments", "createEarbudsSettingsArguments", "selectedDevice", "createDeviceRouteArguments", "appendDeviceParams", "resolveRouteProductId", "createSimultaneousInterpretArguments", "resolveDiaryGlassesMac", "openQuickNoteRecord", "requireConnectedDevice", "actionType", "hasConnectedGlasses", "showConnectionRequired", "reconnectDevice", "featureName", "resolveReconnectDevice", "resolveCompatibleDevices", "supportsQuickAction", "resolveQuickActionTitle", "onDeviceConnected", "onDeviceDisconnected", "updateBatteryFromCallback", "battery", "updateChargeFromCallback", "charge", "syncDeviceOrder", "bindList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectDevice", "hasNewDevice", "updateCachedBattery", "syncBatterySnapshot", "updateBatteryCache", "clearBatterySnapshot", "refreshDeviceList", "connectedDeviceMac", "updateDeviceStatusWithCurrentContent", "allowAutoSwitch", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "publishHomeStatus", "updateOnlyDeviceComponent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEmptyDeviceState", "cacheConnectedDeviceSnapshotIfNeeded", "buildDeviceCardUiState", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeDeviceCardUiState;", "isSelected", "buildDeviceCardItems", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeDeviceCardItem;", "devices", "selectedDeviceMac", "resolveDeviceMode", "Lcom/larus/dora/impl/device/manage/DeviceMode;", "refreshQuickActions", "buildQuickActions", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeQuickAction;", "featureSet", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeFeatureSet;", "buildBottomTabs", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeTab;", "healthEntryUrl", "hasHealthEntry", "shouldUseEarbudsCard", "getDeviceCardImage", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$DeviceCardImage;", "Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeDeviceCardType;", "isConnected", "shouldLog", "resolveDeviceCardImage", "resolveGlassesCardImage", "getGlassesCardImageProductCode", "resolveProductSkuCardImage", "normalizeDeviceCardImageSku", "productCode", "skuName", "getDeviceCardImageProductCode", "productId", "getDefaultDeviceCardImageSku", "getDrawableResId", "resName", "defaultDeviceCardImage", "requestedResName", "toGlassesResourceDeviceType", "Lcom/larus/dora/impl/resource/DoraResourceDeviceType;", "resolveInitialDeviceMac", "sortDeviceList", "moveDeviceToFront", "onConnectRequestFailed", "handleGConnectRequest", "handleDeviceNeedingUnbind", "bindResult", "Lcom/larus/dora/impl/core/OnlyBindResult;", "(Lcom/bytedance/dora/device/DoraDevice;Lcom/larus/dora/impl/core/OnlyBindResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanBleInfo", "timeout", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PageState", "UiState", "DeviceCardImage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceHomeViewModel extends ViewModel {
    public static final int BATTERY_COUNT = 3;
    public static final int BATTERY_INDEX_BOX = 2;
    public static final int BATTERY_INDEX_LEFT = 0;
    public static final int BATTERY_INDEX_RIGHT = 1;
    public static final int CHARGE_STATE_CHARGING = 1;
    private static final a Companion = null;
    public static final String DEFAULT_DEVICE_NAME = "Dora";
    public static final String DEFAULT_GLASSES_CARD_IMAGE_NAME = "larus_dora_obric_device_home_img_glasses";
    private static final List<m1> DEFAULT_GLASSES_QUICK_ACTIONS = null;
    private static final r1 DEVICE_BOTTOM_TAB = null;
    public static final String DEVICE_CARD_IMAGE_PREFIX = "larus_dora_obric_device_home_img_";
    public static final long DEVICE_STATE_DEBOUNCE_MS = 300;
    private static final r1 DIARY_BOTTOM_TAB = null;
    public static final long DIARY_DATA_QUERY_TIMEOUT_MS = 5000;
    private static final r1 DISCOVER_BOTTOM_TAB = null;
    public static final String ENTER_FROM_OBRIC_DEVICE_HOME = "obric_device_home";
    public static final String ENTER_METHOD_CLICK_BUTTON = "click_button";
    public static final String ENTER_METHOD_CLICK_CARD = "click_card";
    private static final r1 HEALTH_BOTTOM_TAB = null;
    public static final int INVALID_BATTERY = -1;
    public static final String PARAM_AUTO_START = "auto_start";
    public static final String PARAM_ENTER_FROM = "enter_from";
    public static final String PARAM_ENTER_METHOD = "enter_method";
    public static final String PARAM_PAGE_KEY = "page_key";
    public static final String PARAM_PREVIOUS_PAGE = "previous_page";
    public static final String PARAM_PRODUCT_ID = "product_id";
    public static final String PARAM_PRODUCT_MAC = "product_mac";
    public static final String PARAM_PRODUCT_MODEL = "model";
    public static final String PARAM_VENDOR_ID = "vendor_id";
    public static final String PREVIOUS_PAGE_DEVICE_HOME = "device_home";
    public static final String PRODUCT_CODE_G1 = "g1";
    public static final String PRODUCT_CODE_G2 = "g2";
    public static final String PRODUCT_CODE_LITE = "lite";
    public static final String PRODUCT_CODE_ROBIN = "robin";
    public static final String PRODUCT_CODE_ROBIN_HARDENED = "robin_hardened";
    public static final String PRODUCT_CODE_SAX = "sax";
    private static final List<m1> QUICK_ACTION_DISPLAY_ORDER = null;
    public static final long SCAN_TIMEOUT_MS = 15000;
    public static final String TAG = "DoraObricDeviceHomeViewModel";
    private static final String TITLE_DOUBAO_ASSISTANT = null;
    private static final String TITLE_NOTIFICATION_BROADCAST = null;
    private final MutableSharedFlow<com.larus.dora.obric.device_management.device_home.i> _action;
    private final MutableSharedFlow<com.larus.dora.obric.device_management.device_home.a> _deviceIntentSharedFlow;
    private final kotlinx.coroutines.flow.z0<c> _uiState;
    private final kotlinx.coroutines.flow.d1<com.larus.dora.obric.device_management.device_home.i> action;
    private Bundle arguments;
    private final e batteryCallback;
    private final Map<String, int[]> batteryInfoByDeviceMac;
    private Job batteryUpdateJob;
    private Job bindCheckJob;
    private String bindCheckMac;
    private long bindCheckRequestId;
    private final Map<String, int[]> chargeInfoByDeviceMac;
    private Job chargeUpdateJob;
    private String connectingDeviceMac;
    private Job connectingJob;
    private int[] currentBatteryInfo;
    private int[] currentChargeInfo;
    private int currentConfirmedGlassesMode;
    private String currentDeviceMac;
    private Job deviceCardSelectionJob;
    private long deviceCardSelectionRequestId;
    private final kotlinx.coroutines.flow.d1<com.larus.dora.obric.device_management.device_home.a> deviceIntentSharedFlow;
    private final List<String> deviceOrder;
    private final g deviceStateCallback;
    private Job deviceStatusUpdateJob;
    private String diaryDataAccountId;
    private Job diaryDataJob;
    private long diaryDataRequestId;
    private final Lazy doraPageConfig$delegate;
    private final Lazy doraService$delegate;
    private final h doraVoiceCallback;
    private final f2 environmentMemoryAuthorizationContinuation;
    private long environmentMemoryAuthorizationRequestId;
    private final i environmentMemoryChangeListener;
    private final j2 environmentMemorySwitchCooldownPolicy;
    private Job environmentMemoryUpdateJob;
    private final j headphoneModeCallback;
    private boolean initialHomeStatePending;
    private boolean isHomeInitialized;
    private int lastKnownBindListSize;
    private List<? extends DoraDevice> latestBoundDevices;
    private Job loadJob;
    private String needUnbindPromptMac;
    private String pendingEntryDeviceMac;
    private IDoraAVLinkService registeredAvLinkService;
    private final DoraObricDeviceHomeViewModel$sceneStateListener$1 sceneStateListener;
    private final DoraObricDeviceHomeViewModel$settingsUpdateListener$1 settingsUpdateListener;
    private final kotlinx.coroutines.flow.i1<c> uiState;
    private s1 usageEvidence;
    private final DoraObricDeviceHomeUsageRepository usageRepository;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeViewModel$PageState;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "Content", "Empty", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PageState extends Enum<PageState> {
        public static final PageState Content = null;
        public static final PageState Empty = null;
        public static final PageState Loading = null;
        public static final /* synthetic */ PageState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PageState> getEntries() {
            return b;
        }

        static {
            PageState r0 = new PageState("Loading", 0);
            Loading = r0;
            PageState r1 = new PageState("Content", 1);
            Content = r1;
            PageState r3 = new PageState("Empty", 2);
            Empty = r3;
            PageState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static PageState[] values() {
            return (PageState[]) a.clone();
        }

        public static PageState valueOf(String r1) {
            return (PageState) r27.a.a(PageState.class, r1);
        }

        public PageState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static Application a() {
            gd9.i r0 = com.larus.im.b.a;
            Intrinsics.checkNotNull(r0);
            return r0.getApplication();
        }

        public a() {
        }
    }

    public static final class b {
        public final int a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final DoraResourceDeviceType f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            String r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            DoraResourceDeviceType r8 = this.f;
            if (r8 == null) goto L15;
            r2 = r8.hashCode();
        L15:
            return r7 + r2;
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "DeviceCardImage(resId=" + this.a + ", resName=" + this.b + ", requestedResName=" + this.c + ", externalResourceName=" + this.d + ", externalFallbackResourceName=" + this.e + ", externalResourceDeviceType=" + this.f + ')';
        }

        public b(int r3, String r4, String r5, String r6, String r7, DoraResourceDeviceType r8, int r9) {
            if ((r9 & 4) == 0) goto L6;
            r5 = r4;
        L6:
            if ((r9 & 8) == 0) goto L9;
            r6 = null;
        L9:
            if ((r9 & 16) == 0) goto L12;
            r7 = null;
        L12:
            if ((r9 & 32) == 0) goto L14;
            r8 = null;
        L14:
            Intrinsics.checkNotNullParameter(r4, "resName");
            Intrinsics.checkNotNullParameter(r5, "requestedResName");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
        }
    }

    public static final class c {
        public final PageState a;
        public final DoraDevice b;
        public final String c;
        public final boolean d;
        public final String e;
        public final List<q> f;
        public final int g;
        public final r h;
        public final String i;
        public final boolean j;
        public final boolean k;
        public final List<m1> l;
        public final List<r1> m;

        public c() {
            this(null, false, null, null, 8191);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (this.j == r6.j) goto L39;
            return false;
        L39:
            if (this.k == r6.k) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L47;
            return false;
        L47:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            DoraDevice r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (((r0 + r2) * 31) + this.c.hashCode()) * 31;
            int r4 = 1231;
            if (this.d == false) goto L9;
            int r5 = 1231;
        L10:
            int r6 = (((((((((((r3 + r5) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
            if (this.j == false) goto L13;
            int r7 = 1231;
        L14:
            int r8 = (r6 + r7) * 31;
            if (this.k == true) goto L19;
            r4 = 1237;
        L19:
            return ((((r8 + r4) * 31) + this.l.hashCode()) * 31) + this.m.hashCode();
        L13:
            r7 = 1237;
            goto L14
        L9:
            r5 = 1237;
            goto L10
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "UiState(pageState=" + this.a + ", selectedDevice=" + this.b + ", selectedDeviceMac=" + this.c + ", isInitialized=" + this.d + ", pageTitle=" + this.e + ", deviceCards=" + this.f + ", selectedDeviceCardIndex=" + this.g + ", deviceCard=" + this.h + ", commonSectionTitle=" + this.i + ", hasDiaryData=" + this.j + ", showAlbumSection=" + this.k + ", quickActions=" + this.l + ", bottomTabs=" + this.m + ')';
        }

        public /* synthetic */ c(PageState r17, boolean r18, List r110, List r20, int r21) {
            if ((r21 & 1) == 0) goto L5;
            PageState r3 = PageState.Loading;
        L7:
            if ((r21 & 4) == 0) goto L9;
            String r5 = "";
        L11:
            if ((r21 & 8) == 0) goto L13;
            boolean r6 = false;
        L15:
            if ((r21 & 16) == 0) goto L17;
            int r1 = com.larus.utils.j0.a;
            String r7 = com.larus.utils.j0.d(2131903448);
        L19:
            if ((r21 & 32) == 0) goto L21;
            List r8 = CollectionsKt.emptyList();
        L23:
            if ((r21 & 128) == 0) goto L25;
            int r10 = com.larus.utils.j0.a;
            r r11 = new r(DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME, com.larus.utils.j0.d(2131902456), com.larus.dora.impl.device.manage.r0.b(-1), 261113);
        L27:
            if ((r21 & 256) == 0) goto L29;
            int r2 = com.larus.utils.j0.a;
            String r12 = com.larus.utils.j0.d(2131903446);
        L31:
            if ((r21 & 2048) == 0) goto L33;
            List r14 = CollectionsKt.emptyList();
        L35:
            if ((r21 & 4096) == 0) goto L37;
            List r15 = CollectionsKt.emptyList();
        L38:
            this(r3, null, r5, r6, r7, r8, 0, r11, r12, false, false, r14, r15);
            return;
        L37:
            r15 = r20;
            goto L38
        L33:
            r14 = r110;
            goto L35
        L29:
            r12 = null;
            goto L31
        L25:
            r11 = null;
            goto L27
        L21:
            r8 = null;
            goto L23
        L17:
            r7 = null;
            goto L19
        L13:
            r6 = r18;
            goto L15
        L9:
            r5 = null;
            goto L11
        L5:
            r3 = r17;
            goto L7
        }

        public c(PageState r2, DoraDevice r3, String r4, boolean r5, String r6, List<q> r7, int r8, r r9, String r10, boolean r11, boolean r12, List<m1> r13, List<r1> r14) {
            Intrinsics.checkNotNullParameter(r2, "pageState");
            Intrinsics.checkNotNullParameter(r4, "selectedDeviceMac");
            Intrinsics.checkNotNullParameter(r6, "pageTitle");
            Intrinsics.checkNotNullParameter(r7, "deviceCards");
            Intrinsics.checkNotNullParameter(r9, "deviceCard");
            Intrinsics.checkNotNullParameter(r10, "commonSectionTitle");
            Intrinsics.checkNotNullParameter(r13, "quickActions");
            Intrinsics.checkNotNullParameter(r14, "bottomTabs");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
        }

        public static c a(c r17, PageState r18, DoraDevice r110, String r20, boolean r21, List r22, int r23, r r24, boolean r25, boolean r26, List r27, List r28, int r210) {
            if ((r210 & 1) == 0) goto L5;
            PageState r4 = r17.a;
        L7:
            if ((r210 & 2) == 0) goto L9;
            DoraDevice r5 = r17.b;
        L11:
            if ((r210 & 4) == 0) goto L13;
            String r6 = r17.c;
        L15:
            if ((r210 & 8) == 0) goto L17;
            boolean r7 = r17.d;
        L19:
            if ((r210 & 16) == 0) goto L21;
            String r8 = r17.e;
        L23:
            if ((r210 & 32) == 0) goto L25;
            List r9 = r17.f;
        L27:
            if ((r210 & 64) == 0) goto L29;
            int r10 = r17.g;
        L31:
            if ((r210 & 128) == 0) goto L33;
            r r11 = r17.h;
        L35:
            if ((r210 & 256) == 0) goto L37;
            String r12 = r17.i;
        L39:
            if ((r210 & 512) == 0) goto L41;
            boolean r13 = r17.j;
        L43:
            if ((r210 & 1024) == 0) goto L45;
            boolean r14 = r17.k;
        L47:
            if ((r210 & 2048) == 0) goto L49;
            List r15 = r17.l;
        L51:
            if ((r210 & 4096) == 0) goto L53;
            List r1 = r17.m;
        L54:
            r17.getClass();
            Intrinsics.checkNotNullParameter(r4, "pageState");
            Intrinsics.checkNotNullParameter(r6, "selectedDeviceMac");
            Intrinsics.checkNotNullParameter(r8, "pageTitle");
            Intrinsics.checkNotNullParameter(r9, "deviceCards");
            Intrinsics.checkNotNullParameter(r11, "deviceCard");
            Intrinsics.checkNotNullParameter(r12, "commonSectionTitle");
            Intrinsics.checkNotNullParameter(r15, "quickActions");
            Intrinsics.checkNotNullParameter(r1, "bottomTabs");
            return new c(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
        L53:
            r1 = r28;
            goto L54
        L49:
            r15 = r27;
            goto L51
        L45:
            r14 = r26;
            goto L47
        L41:
            r13 = r25;
            goto L43
        L37:
            r12 = null;
            goto L39
        L33:
            r11 = r24;
            goto L35
        L29:
            r10 = r23;
            goto L31
        L25:
            r9 = r22;
            goto L27
        L21:
            r8 = null;
            goto L23
        L17:
            r7 = r21;
            goto L19
        L13:
            r6 = r20;
            goto L15
        L9:
            r5 = r110;
            goto L11
        L5:
            r4 = r18;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$cacheConnectedDeviceSnapshotIfNeeded$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$cacheConnectedDeviceSnapshotIfNeeded$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        final /* synthetic */ String $source;
        int label;

        public AnonymousClass1(DoraDevice r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$device = r1;
            this.$source = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$device, this.$source, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r3);
            if (kj4.a.g().getDoraLinkState(this.$device) != 2) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == false) goto L11;
            com.larus.dora.impl.device.manage.x0 r5 = com.larus.dora.impl.device.manage.x0.a;
            DoraDevice r0 = this.$device;
            String r1 = this.$source;
            r5.getClass();
            com.larus.dora.impl.device.manage.x0.b(r0, r1);
        L11:
            return Unit.INSTANCE;
        L7:
            r4 = false;
            goto L8
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$checkBindState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$checkBindState$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {1264, 1276, 1281, 1291}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $checkMac;
        final /* synthetic */ DoraDevice $device;
        final /* synthetic */ boolean $force;
        final /* synthetic */ long $requestId;
        final /* synthetic */ String $source;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04561(DoraDevice r1, String r2, long r3, DoraObricDeviceHomeViewModel r5, boolean r6, String r7, Continuation<? super C04561> r8) {
            this.$device = r1;
            this.$source = r2;
            this.$requestId = r3;
            this.this$0 = r5;
            this.$force = r6;
            this.$checkMac = r7;
            super(2, r8);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C04561(this.$device, this.$source, this.$requestId, this.this$0, this.$force, this.$checkMac, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r110) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L14;
            if (r0 == 1) goto L13;
            if (r0 == 2) goto L12;
            if (r0 == 3) goto L11;
            if (r0 == 4) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Object r1 = this.L$0;
            ResultKt.throwOnFailure(r110);
        L53:
            Object r12 = r1;
        L54:
            String r2 = this.$source;
            Throwable r3 = Result.exceptionOrNull-impl(r12);
            if (r3 == null) goto L58;
            g49.d.c(DoraObricDeviceHomeViewModel.TAG, "checkBindState failed, source=" + r2, r3);
        L58:
            return Unit.INSTANCE;
        L12:
            boolean r4 = this.Z$0;
            DoraDevice r5 = (DoraDevice) this.L$3;
            DoraObricDeviceHomeViewModel r6 = (DoraObricDeviceHomeViewModel) this.L$2;
            String r7 = (String) this.L$1;
            Object r9 = this.L$0;
            ResultKt.throwOnFailure(r110);
            boolean r10 = r4;
            Object r11 = r110;
        L35:
            DoraDevice r13 = (DoraDevice) r11;
            if (r13 == null) goto L38;
            r5.mode = r13.mode;
            r5.version = r13.version;
        L38:
            DoraDevice r15 = r5;
            DoraObricDeviceHomeViewModel r14 = r6;
            String r16 = r7;
            r1 = r9;
            boolean r17 = r10;
        L40:
            this.L$0 = r1;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 3;
            if (DoraObricDeviceHomeViewModel.access$emitNeedUnbindIfCurrent(r14, r15, r16, r17, this) != r8) goto L53;
            return r8;
        L13:
            ResultKt.throwOnFailure(r110);
            Object r18 = ((Result) r110).unbox-impl();
        L17:
            r12 = r18;
            r16 = this.$source;
            long r20 = this.$requestId;
            r14 = this.this$0;
            r15 = this.$device;
            r17 = this.$force;
            String r21 = this.$checkMac;
            if (Result.isSuccess-impl(r12) == false) goto L54;
            Integer r111 = ((com.larus.dora.impl.network.b) r12).b();
            if (r111 == null) goto L22;
            int r22 = r111.intValue();
        L23:
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, "checkBindState bindCode=" + r22 + " source=" + r16);
            if (r20 == DoraObricDeviceHomeViewModel.access$getBindCheckRequestId$p(r14)) goto L26;
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, "checkBindState ignored, stale request, source=" + r16);
            goto L54
        L26:
            if (r22 == 1) goto L43;
            if (r22 != 2) goto L54;
            if (o59.a.p(r15) == false) goto L39;
            String r23 = r15.mac;
            this.L$0 = r12;
            this.L$1 = r16;
            this.L$2 = r14;
            this.L$3 = r15;
            this.Z$0 = r17;
            this.label = 2;
            r10 = r17;
            r11 = DoraObricDeviceHomeViewModel.scanBleInfo$default(r14, r23, 0, this, 2, null);
            if (r11 != r8) goto L34;
            return r8;
        L34:
            r9 = r12;
            r7 = r16;
            r6 = r14;
            r5 = r15;
            goto L35
        L39:
            r1 = r12;
            goto L40
        L43:
            String r24 = DoraObricDeviceHomeViewModel.access$getCurrentDeviceMac$p(r14);
            if (r24 != null) goto L47;
            r24 = "";
        L47:
            if (Intrinsics.areEqual(r21, r24) == true) goto L49;
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, "checkBindState success ignored, device is no longer selected");
            goto L54
        L49:
            DoraObricDeviceHomeViewModel.access$setNeedUnbindPromptMac$p(r14, null);
            DoraObricDeviceHomeViewModel.refreshDeviceList$default(r14, null, 1, null);
            kj4.a r25 = kj4.a.g();
            this.L$0 = r12;
            this.label = 4;
            if (DoraAdapterExtKt.b(r25) != r8) goto L52;
            return r8;
        L52:
            r1 = r12;
            goto L53
        L22:
            r22 = 0;
            goto L23
        L14:
            ResultKt.throwOnFailure(r110);
            DoraNetworkApi r26 = DoraNetworkApi.a;
            DoraDevice r27 = this.$device;
            this.label = 1;
            r18 = r26.e(r27, true, this);
            if (r18 != r8) goto L17;
            return r8;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$connectAsync$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$connectAsync$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04571(DoraDevice r1, DoraObricDeviceHomeViewModel r2, Continuation<? super C04571> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04571(this.$device, this.this$0, r4);
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
            DoraDevice r3 = this.$device;
            if (r3 == null) goto L8;
            this.this$0.handleConnectRequest(r3.mac);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;
        public static final /* synthetic */ int[] e = null;
        public static final /* synthetic */ int[] f = null;

        static {
            int[] r0 = new int[DoraObricDeviceHomeQuickActionType.values().length];
            r0[DoraObricDeviceHomeQuickActionType.DOUBAO_ASSISTANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L44
        L96:
            r0[DoraObricDeviceHomeQuickActionType.NOTIFICATION_BROADCAST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L45
        L104:
            r0[DoraObricDeviceHomeQuickActionType.QUICK_NOTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L46
        L112:
            r0[DoraObricDeviceHomeQuickActionType.SIMULTANEOUS_INTERPRET.ordinal()] = 4;     // Catch: NoSuchFieldError -> L47
        L114:
            r0[DoraObricDeviceHomeQuickActionType.RECORD_MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L48
        L12:
            a = r0;
            int[] r1 = new int[DoraObricEnvironmentMemoryClickAction.values().length];
            r1[DoraObricEnvironmentMemoryClickAction.NO_OP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L49
        L72:
            r1[DoraObricEnvironmentMemoryClickAction.SHOW_UNAVAILABLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L50
        L80:
            r1[DoraObricEnvironmentMemoryClickAction.REQUEST_AUTHORIZATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L51
        L90:
            r1[DoraObricEnvironmentMemoryClickAction.DISABLE_SWITCH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L52
        L100:
            r1[DoraObricEnvironmentMemoryClickAction.ENABLE_SWITCH.ordinal()] = 5;     // Catch: NoSuchFieldError -> L53
        L106:
            r1[DoraObricEnvironmentMemoryClickAction.ENABLE_SWITCH_WITH_OVERRIDE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L54
        L116:
            r1[DoraObricEnvironmentMemoryClickAction.ACTIVATE_OVERRIDE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L55
        L22:
            b = r1;
            int[] r2 = new int[BindAndConnectResult.values().length];
            r2[BindAndConnectResult.SERVER_BIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L56
        L82:
            r2[BindAndConnectResult.SERVER_BIND_UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L57
        L92:
            r2[BindAndConnectResult.SERVER_BIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L58
        L102:
            r2[BindAndConnectResult.SERVER_BIND_NEED_UNBIND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L59
        L108:
            r2[BindAndConnectResult.CONNECT_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L60
        L118:
            r2[BindAndConnectResult.CONNECT_TIMEOUT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L61
        L122:
            r2[BindAndConnectResult.SUCCESS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L62
        L30:
            c = r2;
            int[] r3 = new int[OnlyConnectResult.values().length];
            r3[OnlyConnectResult.CONNECT_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L63
        L86:
            r3[OnlyConnectResult.CONNECT_TIMEOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L64
        L94:
            r3[OnlyConnectResult.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L65
        L34:
            d = r3;
            int[] r4 = new int[DoraObricDeviceHomeDeviceCardType.values().length];
            r4[DoraObricDeviceHomeDeviceCardType.GLASSES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L66
        L120:
            r4[DoraObricDeviceHomeDeviceCardType.EARBUDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L67
        L37:
            e = r4;
            int[] r5 = new int[OnlyBindResult.values().length];
            r5[OnlyBindResult.SERVER_BIND_NETWORK_ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L68
        L78:
            r5[OnlyBindResult.SERVER_BIND_UNKNOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L69
        L88:
            r5[OnlyBindResult.SERVER_BIND_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L70
        L98:
            r5[OnlyBindResult.SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L71
        L42:
            f = r5;
        }
    }

    public static final class e extends com.larus.dora.impl.util.r0 {
        public final /* synthetic */ DoraObricDeviceHomeViewModel a;

        public e(DoraObricDeviceHomeViewModel r1) {
            this.a = r1;
        }

        public final void D(DoraDevice r3, int[] r4) {
            StringBuilder r0 = new StringBuilder("onChargeStateChanged device=");
            r0.append(o59.a.h(r3));
            r0.append(" charge=");
            if (r4 == null) goto L5;
            String r1 = Arrays.toString(r4);
        L6:
            r0.append(r1);
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, r0.toString());
            DoraObricDeviceHomeViewModel.access$updateChargeFromCallback(this.a, r3, r4);
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final void b0(DoraDevice r3, int[] r4) {
            StringBuilder r0 = new StringBuilder("onBatteryChanged device=");
            r0.append(o59.a.h(r3));
            r0.append(" battery=");
            if (r4 == null) goto L5;
            String r1 = Arrays.toString(r4);
        L6:
            r0.append(r1);
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, r0.toString());
            if (kj4.a.g().getDoraLinkState(r3) != 2) goto L9;
            DoraObricDeviceHomeViewModel.access$updateBatteryCache(this.a, r3, r4);
        L14:
            if (Intrinsics.areEqual(r3.mac, DoraObricDeviceHomeViewModel.access$getCurrentDeviceMac$p(this.a)) == true) goto L16;
            return;
        L16:
            DoraObricDeviceHomeViewModel.access$updateBatteryFromCallback(this.a, r3, r4);
            return;
        L9:
            Map r2 = DoraObricDeviceHomeViewModel.access$getBatteryInfoByDeviceMac$p(this.a);
            String r5 = r3.mac;
            if (r5 != null) goto L12;
            r5 = "";
        L12:
            r2.remove(r5);
            goto L14
        L5:
            r1 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$emitEnvironmentMemoryToast$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$emitEnvironmentMemoryToast$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {1098}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraObricEnvironmentMemoryToastType $type;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04581(DoraObricDeviceHomeViewModel r1, DoraObricEnvironmentMemoryToastType r2, Continuation<? super C04581> r3) {
            this.this$0 = r1;
            this.$type = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04581(this.this$0, this.$type, r4);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MutableSharedFlow r6 = DoraObricDeviceHomeViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.device_home.i.c r2 = new com.larus.dora.obric.device_management.device_home.i.c(this.$type);
            this.label = 1;
            if (r6.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$emitRoute$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$emitRoute$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {1350}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $route;
        final /* synthetic */ Bundle $routeArguments;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04591(DoraObricDeviceHomeViewModel r1, String r2, Bundle r3, Continuation<? super C04591> r4) {
            this.this$0 = r1;
            this.$route = r2;
            this.$routeArguments = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C04591(this.this$0, this.$route, this.$routeArguments, r5);
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
            MutableSharedFlow r7 = DoraObricDeviceHomeViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.device_home.i.a r2 = new com.larus.dora.obric.device_management.device_home.i.a(this.$route, this.$routeArguments);
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class f<T> implements Comparator {
        public f() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((Number) ((Pair) r1).component2()).intValue()), Integer.valueOf(((Number) ((Pair) r2).component2()).intValue()));
        }
    }

    public static final class g extends com.larus.dora.impl.util.t0 {
        public final /* synthetic */ DoraObricDeviceHomeViewModel a;

        public g(DoraObricDeviceHomeViewModel r1) {
            this.a = r1;
        }

        public final void onDoraLinkStateChanged(DoraDevice r3, int r4, int r5) {
            super.onDoraLinkStateChanged(r3, r4, r5);
            StringBuilder r6 = new StringBuilder("onDoraLinkStateChanged device=");
            String r0 = null;
            if (r3 == null) goto L5;
            String r1 = o59.a.h(r3);
        L6:
            r6.append(r1);
            r6.append(" state=");
            r6.append(r5);
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, r6.toString());
            if (r3 != null) goto L9;
        L16:
            DoraObricDeviceHomeViewModel.access$refreshDeviceList(this.a, r0);
            return;
        L9:
            if (r5 == (-1)) goto L15;
            if (r5 == 0) goto L15;
            if (r5 != 2) goto L16;
            DoraObricDeviceHomeViewModel.access$onDeviceConnected(this.a, r3);
            r0 = r3.mac;
        L15:
            DoraObricDeviceHomeViewModel.access$onDeviceDisconnected(this.a, r3);
            goto L16
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class h implements f49.b {
        public final /* synthetic */ DoraObricDeviceHomeViewModel a;

        @Override // f49.b
        public final void b() {
        }

        @Override // f49.b
        public final void d(int r1) {
        }

        @Override // f49.b
        public final void h(int r1) {
        }

        @Override // f49.b
        public final void i() {
        }

        @Override // f49.b
        public final void j(byte[] r1, byte[] r2) {
        }

        @Override // f49.b
        public final void k() {
        }

        @Override // f49.b
        public final void m() {
        }

        @Override // f49.b
        public final void n() {
        }

        @Override // f49.b
        public final void o() {
        }

        @Override // f49.b
        public final void p() {
        }

        public h(DoraObricDeviceHomeViewModel r1) {
            this.a = r1;
        }

        @Override // f49.b
        public final void l(int r3, int r4, int r5) {
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, "onVoiceWakeUp state=" + r3 + " wakeMode=" + r4 + " query=" + r5);
            if (r4 != 11) goto L6;
            DoraObricDeviceHomeViewModel.refreshDeviceList$default(this.a, null, 1, null);
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$handleConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$handleConnectRequest$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {1115, 1128, 1129}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mac;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04601(DoraObricDeviceHomeViewModel r1, String r2, Continuation<? super C04601> r3) {
            this.this$0 = r1;
            this.$mac = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04601(this.this$0, this.$mac, r4);
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
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L20
        L32:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r10);     // Catch: Exception -> L20
        L17:
            DoraDevice r11 = (DoraDevice) r10;     // Catch: Exception -> L20
            if (r11 != null) goto L23;
            t19.s r12 = t19.s.a;     // Catch: Exception -> L20
            DoraObricDeviceHomeViewModel.access$getCompanion$p().getClass();     // Catch: Exception -> L20
            Application r2 = a.a();     // Catch: Exception -> L20
            r12.getClass();     // Catch: Exception -> L20
            t19.s.b(r2, 2131902626, false);     // Catch: Exception -> L20
            DoraObricDeviceHomeViewModel.access$onConnectRequestFailed(this.this$0);     // Catch: Exception -> L20
            goto L32
        L23:
            if (o59.a.p(r11) == false) goto L27;
            DoraObricDeviceHomeViewModel r3 = this.this$0;     // Catch: Exception -> L20
            this.label = 2;     // Catch: Exception -> L20
            if (DoraObricDeviceHomeViewModel.access$handleGConnectRequest(r3, r11, this) != r0) goto L32;
            return r0;
        L27:
            DoraObricDeviceHomeViewModel r4 = this.this$0;     // Catch: Exception -> L20
            this.label = 3;     // Catch: Exception -> L20
            if (DoraObricDeviceHomeViewModel.access$handleEarbudsConnectRequest(r4, r11, this) != r0) goto L32;
            return r0;
        L13:
            ResultKt.throwOnFailure(r10);
            CoroutineDispatcher r13 = Dispatchers.getIO();     // Catch: Exception -> L20
            DoraObricDeviceHomeViewModel$handleConnectRequest$1$device$1 r5 = new DoraObricDeviceHomeViewModel$handleConnectRequest$1$device$1(this.$mac, null);     // Catch: Exception -> L20
            this.label = 1;     // Catch: Exception -> L20
            r10 = BuildersKt.withContext(r13, r5, this);     // Catch: Exception -> L20
            if (r10 != r0) goto L17;
            return r0;
        L20:
            e = move-exception;
            g49.d.c(DoraObricDeviceHomeViewModel.TAG, "handleConnectRequest failed", e);
            t19.s r14 = t19.s.a;
            DoraObricDeviceHomeViewModel.access$getCompanion$p().getClass();
            Application r6 = a.a();
            r14.getClass();
            t19.s.b(r6, 2131902626, false);
            DoraObricDeviceHomeViewModel.access$onConnectRequestFailed(this.this$0);
            goto L32
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$handleDeviceNeedingUnbind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel", f = "DoraObricDeviceHomeViewModel.kt", i = {0}, l = {2452, 2456, 2466, 2469}, m = "handleDeviceNeedingUnbind", n = {"device"}, s = {"L$0"})
    public static final class C04611 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04611(DoraObricDeviceHomeViewModel r1, Continuation<? super C04611> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricDeviceHomeViewModel.access$handleDeviceNeedingUnbind(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$handleEarbudsConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel", f = "DoraObricDeviceHomeViewModel.kt", i = {0}, l = {1146, 1167, 1174, 1180}, m = "handleEarbudsConnectRequest", n = {"device"}, s = {"L$0"})
    public static final class C04621 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04621(DoraObricDeviceHomeViewModel r1, Continuation<? super C04621> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricDeviceHomeViewModel.access$handleEarbudsConnectRequest(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$handleGConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel", f = "DoraObricDeviceHomeViewModel.kt", i = {0, 1}, l = {2410, 2431, 2432, 2434}, m = "handleGConnectRequest", n = {"device", "device"}, s = {"L$0", "L$0"})
    public static final class C04631 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04631(DoraObricDeviceHomeViewModel r1, Continuation<? super C04631> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricDeviceHomeViewModel.access$handleGConnectRequest(this.this$0, null, this);
        }
    }

    public static final class i implements u39.b {
        public final /* synthetic */ DoraObricDeviceHomeViewModel a;

        public i(DoraObricDeviceHomeViewModel r1) {
            this.a = r1;
        }

        public final void a(boolean r3, EnvObserveChangeReason r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "reason");
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, "onEnvObserveChange ready=" + r3 + " reason=" + r4 + " reasonCode=" + r5);
            DoraObricDeviceHomeViewModel.refreshDeviceList$default(this.a, null, 1, null);
        }
    }

    public static final class j extends com.larus.dora.impl.util.r0 {
        public final /* synthetic */ DoraObricDeviceHomeViewModel a;

        public j(DoraObricDeviceHomeViewModel r1) {
            this.a = r1;
        }

        public final void f1(int r4, byte r5) {
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, "onDMSHeadphoneModeState nid=" + r4 + " mode=" + r5);
            DoraObricDeviceHomeViewModel r6 = this.a;
            Integer r7 = Integer.valueOf(r5);
            int r0 = r7.intValue();
            if (r0 >= 0) goto L5;
        L7:
            boolean r1 = false;
        L9:
            if (r1 == true) goto L12;
            r7 = null;
        L12:
            if (r7 == null) goto L15;
            DoraObricDeviceHomeViewModel.access$setCurrentConfirmedGlassesMode$p(r6, r7.intValue());
            DoraObricDeviceHomeViewModel.refreshDeviceList$default(this.a, null, 1, null);
            return;
        L15:
            return;
        L5:
            if (r0 >= 2) goto L7;
            r1 = true;
            goto L9
        }
    }

    public static final class k extends ScanCallback {
        public final /* synthetic */ CompletableDeferred<Unit> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Ref.ObjectRef<DoraDevice> c;

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int r3) {
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, "scanBleInfo failed errorCode=" + r3);
            this.a.complete(Unit.INSTANCE);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int r2, ScanResult r3) {
            DoraDevice r4 = kj4.a.g().convertScanResultToDoraDevice(r3);
            if (r4 == null) goto L5;
            String r5 = r4.mac;
        L7:
            if (Intrinsics.areEqual(r5, this.b) == false) goto L10;
            this.c.element = r4;
            kj4.a.g().stopScan(this);
            this.a.complete(Unit.INSTANCE);
            return;
        L10:
            return;
        L5:
            r5 = null;
            goto L7
        }

        public k(CompletableDeferred<Unit> r1, String r2, Ref.ObjectRef<DoraDevice> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class l<T> implements Comparator {
        public l() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Boolean.valueOf(o59.a.p((DoraDevice) r2)), Boolean.valueOf(o59.a.p((DoraDevice) r1)));
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$load$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$load$1", f = "DoraObricDeviceHomeViewModel.kt", i = {1, 1, 2, 2, 3, 3, 3, 4, 4}, l = {543, 548, 551, 575, 592}, m = "invokeSuspend", n = {"rawBindList", "accountId", "rawBindList", "boundDeviceEvidence", "rawBindList", "cachedDiaryData", "hasNewDevice", "cachedDiaryData", "selectedDevice"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1"})
    public static final class C04641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04641(DoraObricDeviceHomeViewModel r1, Continuation<? super C04641> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04641(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L24;
            if (r1 == 1) goto L22;
            if (r1 == 2) goto L20;
            if (r1 == 3) goto L17;
            if (r1 == 4) goto L14;
            if (r1 != 5) goto L13;
            DoraDevice r2 = (DoraDevice) this.L$1;
            Boolean r3 = (Boolean) this.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Exception -> L72
        L68:
            if (r3 != null) goto L70;
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, "defer diary data loading until first home status published");     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.refreshDeviceHomeDiaryData$default(this.this$0, false, 1, null);     // Catch: Exception -> L72
        L70:
            this.this$0.checkBindState(r2, "load", true);     // Catch: Exception -> L72
        L79:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            int r4 = this.I$0;
            Boolean r5 = (Boolean) this.L$1;
            List r6 = (List) this.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Exception -> L72
            Boolean r16 = r5;
        L53:
            List r7 = DoraObricDeviceHomeViewModel.access$sortDeviceList(this.this$0, r6);     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel r8 = this.this$0;     // Catch: Exception -> L72
            if (r4 == 0) goto L56;
            boolean r9 = true;
        L57:
            DoraDevice r10 = DoraObricDeviceHomeViewModel.access$selectDevice(r8, r7, r9);     // Catch: Exception -> L72
            if (r10 != null) goto L62;
            DoraObricDeviceHomeViewModel.access$setInitialHomeStatePending$p(this.this$0, false);     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$publishHomeStatus(this.this$0, r7, null, "load_no_selected_device");     // Catch: Exception -> L72
            return Unit.INSTANCE;
        L62:
            if (DoraObricDeviceHomeViewModel.access$getPendingEntryDeviceMac$p(this.this$0) != null) goto L64;
            DoraObricDeviceHomeViewModel.access$setCurrentDeviceMac$p(this.this$0, r10.mac);     // Catch: Exception -> L72
        L64:
            DoraObricDeviceHomeViewModel.access$updateCachedBattery(this.this$0, r10);     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$setInitialHomeStatePending$p(this.this$0, false);     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel r11 = this.this$0;     // Catch: Exception -> L72
            this.L$0 = r16;     // Catch: Exception -> L72
            this.L$1 = r10;     // Catch: Exception -> L72
            this.label = 5;     // Catch: Exception -> L72
            if (DoraObricDeviceHomeViewModel.access$updateDeviceStatusWithCurrentContent(r11, true, this) != r0) goto L67;
            return r0;
        L67:
            r2 = r10;
            r3 = r16;
            goto L68
        L56:
            r9 = false;
            goto L57
        L17:
            s1 r12 = (s1) this.L$1;
            r6 = (List) this.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Exception -> L72
        L36:
            r16 = (Boolean) r15;     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel r13 = this.this$0;     // Catch: Exception -> L72
            if (r16 == null) goto L39;
            boolean r14 = r16.booleanValue();     // Catch: Exception -> L72
        L40:
            DoraObricDeviceHomeViewModel.access$setUsageEvidence$p(r13, s1.a(r12, false, r14, 7));     // Catch: Exception -> L72
            if (r6.isEmpty() == false) goto L45;
            DoraObricDeviceHomeViewModel.access$setLastKnownBindListSize$p(this.this$0, 0);     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$getDeviceOrder$p(this.this$0).clear();     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$setPendingEntryDeviceMac$p(this.this$0, null);     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$setCurrentDeviceMac$p(this.this$0, null);     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$setCurrentBatteryInfo$p(this.this$0, null);     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$setCurrentChargeInfo$p(this.this$0, null);     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$getBatteryInfoByDeviceMac$p(this.this$0).clear();     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$getChargeInfoByDeviceMac$p(this.this$0).clear();     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$setInitialHomeStatePending$p(this.this$0, false);     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$publishHomeStatus(this.this$0, CollectionsKt.emptyList(), null, "load_no_bound_device");     // Catch: Exception -> L72
            return Unit.INSTANCE;
        L45:
            if (r6.size() > DoraObricDeviceHomeViewModel.access$getLastKnownBindListSize$p(this.this$0)) goto L47;
        L49:
            r4 = 0;
        L50:
            DoraObricDeviceHomeViewModel.access$setLastKnownBindListSize$p(this.this$0, r6.size());     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel r17 = this.this$0;     // Catch: Exception -> L72
            this.L$0 = r6;     // Catch: Exception -> L72
            this.L$1 = r16;     // Catch: Exception -> L72
            this.I$0 = r4;     // Catch: Exception -> L72
            this.label = 4;     // Catch: Exception -> L72
            if (DoraObricDeviceHomeViewModel.access$syncDeviceOrder(r17, r6, this) != r0) goto L53;
            return r0;
        L47:
            if (DoraObricDeviceHomeViewModel.access$getLastKnownBindListSize$p(this.this$0) <= 0) goto L49;
            r4 = 1;
            goto L50
        L39:
            r14 = false;
            goto L40
        L20:
            String r18 = (String) this.L$1;
            List r20 = (List) this.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Exception -> L72
        L32:
            s1 r110 = (s1) r15;     // Catch: Exception -> L72
            CoroutineDispatcher r111 = Dispatchers.getIO();     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel$load$1$cachedDiaryData$1 r112 = new DoraObricDeviceHomeViewModel$load$1$cachedDiaryData$1(this.this$0, r18, null);     // Catch: Exception -> L72
            this.L$0 = r20;     // Catch: Exception -> L72
            this.L$1 = r110;     // Catch: Exception -> L72
            this.label = 3;     // Catch: Exception -> L72
            Object r21 = BuildersKt.withContext(r111, r112, this);     // Catch: Exception -> L72
            if (r21 != r0) goto L35;
            return r0;
        L35:
            r6 = r20;
            r12 = r110;
            r15 = r21;
            goto L36
        L22:
            ResultKt.throwOnFailure(r15);     // Catch: Exception -> L72
        L28:
            List r113 = (List) r15;     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel.access$setLatestBoundDevices$p(this.this$0, r113);     // Catch: Exception -> L72
            r18 = DoraObricDeviceHomeViewModel.access$currentAccountId(this.this$0);     // Catch: Exception -> L72
            CoroutineDispatcher r114 = Dispatchers.getIO();     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel$load$1$boundDeviceEvidence$1 r115 = new DoraObricDeviceHomeViewModel$load$1$boundDeviceEvidence$1(this.this$0, r18, r113, null);     // Catch: Exception -> L72
            this.L$0 = r113;     // Catch: Exception -> L72
            this.L$1 = r18;     // Catch: Exception -> L72
            this.label = 2;     // Catch: Exception -> L72
            Object r22 = BuildersKt.withContext(r114, r115, this);     // Catch: Exception -> L72
            if (r22 != r0) goto L31;
            return r0;
        L31:
            r20 = r113;
            r15 = r22;
            goto L32
        L24:
            ResultKt.throwOnFailure(r15);
            CoroutineDispatcher r116 = Dispatchers.getIO();     // Catch: Exception -> L72
            DoraObricDeviceHomeViewModel$load$1$rawBindList$1 r23 = new DoraObricDeviceHomeViewModel$load$1$rawBindList$1(null);     // Catch: Exception -> L72
            this.label = 1;     // Catch: Exception -> L72
            r15 = BuildersKt.withContext(r116, r23, this);     // Catch: Exception -> L72
            if (r15 != r0) goto L28;
            return r0;
        L72:
            e = move-exception;
            if ((e instanceof CancellationException) == true) goto L80;
            DoraObricDeviceHomeViewModel.access$setInitialHomeStatePending$p(this.this$0, false);
            g49.d.c(DoraObricDeviceHomeViewModel.TAG, "load failed", e);
            if (((c) DoraObricDeviceHomeViewModel.access$get_uiState$p(this.this$0).getValue()).d == true) goto L79;
            DoraObricDeviceHomeViewModel.access$updateEmptyDeviceState(this.this$0, "load_failed");
            goto L79
        L80:
            throw e;
        }
    }

    public static final class m<T> implements Comparator {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ Map b;

        public m(n r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r0 = this.a.compare(r4, r5);
            if (r0 != 0) goto L22;
            Map r1 = this.b;
            String r6 = ((DoraDevice) r4).mac;
            String r2 = "";
            if (r6 != null) goto L8;
            r6 = "";
        L8:
            int r7 = (Integer) r1.get(r6);
            if (r7 != null) goto L12;
            r7 = Integer.MAX_VALUE;
        L12:
            Map r3 = this.b;
            String r8 = ((DoraDevice) r5).mac;
            if (r8 == null) goto L16;
            r2 = r8;
        L16:
            int r9 = (Integer) r3.get(r2);
            if (r9 != null) goto L21;
            r9 = Integer.MAX_VALUE;
        L21:
            return ComparisonsKt.compareValues(r7, r9);
        L22:
            return r0;
        }
    }

    public static final class n<T> implements Comparator {
        public final /* synthetic */ Comparator a;
        public final /* synthetic */ Set b;

        public n(l r1, Set r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            int r0 = this.a.compare(r3, r4);
            if (r0 != 0) goto L14;
            Set r1 = this.b;
            String r5 = ((DoraDevice) r4).mac;
            String r2 = "";
            if (r5 != null) goto L8;
            r5 = "";
        L8:
            Boolean r6 = Boolean.valueOf(r1.contains(r5));
            Set r7 = this.b;
            String r8 = ((DoraDevice) r3).mac;
            if (r8 == null) goto L13;
            r2 = r8;
        L13:
            return ComparisonsKt.compareValues(r6, Boolean.valueOf(r7.contains(r2)));
        L14:
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$onConnectRequestFailed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$onConnectRequestFailed$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04651(DoraObricDeviceHomeViewModel r1, Continuation<? super C04651> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04651(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            DoraObricDeviceHomeViewModel.refreshDeviceList$default(this.this$0, null, 1, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$onDeviceCardPageSelected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$onDeviceCardPageSelected$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {841}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceMac;
        final /* synthetic */ long $selectionRequestId;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04661(DoraObricDeviceHomeViewModel r1, long r2, String r4, Continuation<? super C04661> r5) {
            this.this$0 = r1;
            this.$selectionRequestId = r2;
            this.$deviceMac = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C04661(this.this$0, this.$selectionRequestId, this.$deviceMac, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            List r9 = DoraObricDeviceHomeViewModel.access$sortDeviceList(this.this$0, (List) r8);
            if (this.$selectionRequestId != DoraObricDeviceHomeViewModel.access$getDeviceCardSelectionRequestId$p(this.this$0)) goto L14;
            String r2 = this.$deviceMac;
            Iterator r3 = r9.iterator();
        L17:
            if (r3.hasNext() == false) goto L21;
            Object r4 = r3.next();
            if (Intrinsics.areEqual(((DoraDevice) r4).mac, r2) == false) goto L17;
        L22:
            DoraDevice r5 = (DoraDevice) r4;
            if (r5 != null) goto L26;
            g49.d.e(DoraObricDeviceHomeViewModel.TAG, "onDeviceCardPageSelected skipped, device not bound");
            return Unit.INSTANCE;
        L26:
            DoraObricDeviceHomeViewModel.access$setPendingEntryDeviceMac$p(this.this$0, null);
            DoraObricDeviceHomeViewModel.access$setCurrentDeviceMac$p(this.this$0, r5.mac);
            DoraObricDeviceHomeViewModel.access$setCurrentBatteryInfo$p(this.this$0, null);
            DoraObricDeviceHomeViewModel.access$setCurrentChargeInfo$p(this.this$0, null);
            DoraObricDeviceHomeViewModel.access$setNeedUnbindPromptMac$p(this.this$0, null);
            Job r6 = DoraObricDeviceHomeViewModel.access$getBatteryUpdateJob$p(this.this$0);
            if (r6 == null) goto L29;
            Job.DefaultImpls.cancel$default(r6, null, 1, null);
        L29:
            Job r7 = DoraObricDeviceHomeViewModel.access$getChargeUpdateJob$p(this.this$0);
            if (r7 == null) goto L32;
            Job.DefaultImpls.cancel$default(r7, null, 1, null);
        L32:
            DoraObricDeviceHomeViewModel.access$updateCachedBattery(this.this$0, r5);
            DoraObricDeviceHomeViewModel.access$publishHomeStatus(this.this$0, r9, r5, "device_card_selected");
            this.this$0.checkBindState(r5, "card_selected", true);
            return Unit.INSTANCE;
        L21:
            r4 = null;
            goto L22
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CoroutineDispatcher r10 = Dispatchers.getIO();
            DoraObricDeviceHomeViewModel$onDeviceCardPageSelected$1$rawBindList$1 r11 = new DoraObricDeviceHomeViewModel$onDeviceCardPageSelected$1$rawBindList$1(null);
            this.label = 1;
            r8 = BuildersKt.withContext(r10, r11, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$onDeviceConnected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$onDeviceConnected$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceMac;
        final /* synthetic */ DoraSimpleDevice $lastConnectedDevice;
        int label;

        public C04671(String r1, DoraSimpleDevice r2, Continuation<? super C04671> r3) {
            this.$deviceMac = r1;
            this.$lastConnectedDevice = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04671(this.$deviceMac, this.$lastConnectedDevice, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            com.larus.dora.impl.util.b0 r4 = com.larus.dora.impl.util.b0.a;
            String r0 = this.$deviceMac;
            DoraSimpleDevice r1 = this.$lastConnectedDevice;
            r4.getClass();
            com.larus.dora.impl.util.b0.D(r0, r1);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$onlyConnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel", f = "DoraObricDeviceHomeViewModel.kt", i = {0}, l = {1198, 1204, 1211}, m = "onlyConnect", n = {"device"}, s = {"L$0"})
    public static final class C04681 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04681(DoraObricDeviceHomeViewModel r1, Continuation<? super C04681> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.onlyConnect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$refreshDeviceHomeDiaryData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$refreshDeviceHomeDiaryData$1", f = "DoraObricDeviceHomeViewModel.kt", i = {1, 1}, l = {619, 633, 646}, m = "invokeSuspend", n = {"hasDiaryData", "previousHasDiaryData"}, s = {"Z$0", "Z$1"})
    public static final class C04691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $forceRefresh;
        final /* synthetic */ String $requestAccountId;
        final /* synthetic */ long $requestId;
        boolean Z$0;
        boolean Z$1;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$refreshDeviceHomeDiaryData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$refreshDeviceHomeDiaryData$1$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $hasDiaryData;
            final /* synthetic */ String $requestAccountId;
            int label;
            final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

            public C00981(DoraObricDeviceHomeViewModel r1, String r2, boolean r3, Continuation<? super C00981> r4) {
                this.this$0 = r1;
                this.$requestAccountId = r2;
                this.$hasDiaryData = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00981(this.this$0, this.$requestAccountId, this.$hasDiaryData, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r7) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L17;
                ResultKt.throwOnFailure(r7);
                DoraObricDeviceHomeUsageRepository r8 = DoraObricDeviceHomeViewModel.access$getUsageRepository$p(this.this$0);
                String r0 = this.$requestAccountId;
                boolean r1 = this.$hasDiaryData;
                r8.getClass();
                Intrinsics.checkNotNullParameter(r0, "userId");
                if (StringsKt.isBlank(r0) == true) goto L15;
                Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
                String r2 = "dora_obric_device_home_diary_data_" + r0;     // Catch: Throwable -> L9
                com.larus.dora.impl.util.b0.a.getClass();     // Catch: Throwable -> L9
                com.larus.dora.impl.util.b0.j().storeBoolean(r2, r1);     // Catch: Throwable -> L9
                com.larus.dora.impl.util.b0.j().storeLong(r2 + "_time", System.currentTimeMillis());     // Catch: Throwable -> L9
                StringBuilder r4 = new StringBuilder("diary cache updated hasDiaryData=");     // Catch: Throwable -> L9
                r4.append(r1);     // Catch: Throwable -> L9
                g49.d.d("DoraObricHomeUsageRepo", r4.toString());     // Catch: Throwable -> L9
                Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
            L11:
                Throwable r6 = Result.exceptionOrNull-impl(r5);
                if (r6 == null) goto L15;
                g49.d.e("DoraObricHomeUsageRepo", "write diary cache failed: " + r6.getMessage());
            L9:
                th = move-exception;
                Result.Companion r9 = Result.Companion;
                r5 = Result.constructor-impl(ResultKt.createFailure(th));
            L15:
                return Unit.INSTANCE;
            L17:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C04691(DoraObricDeviceHomeViewModel r1, String r2, boolean r3, long r4, Continuation<? super C04691> r6) {
            this.this$0 = r1;
            this.$requestAccountId = r2;
            this.$forceRefresh = r3;
            this.$requestId = r4;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C04691(this.this$0, this.$requestAccountId, this.$forceRefresh, this.$requestId, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r13);
        L36:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            boolean r2 = this.Z$1;
            boolean r5 = this.Z$0;
            ResultKt.throwOnFailure(r13);
        L26:
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, "refreshDeviceHomeDiaryData hasDiaryData=" + r5 + " previousHasDiaryData=" + r2);
            if (DoraObricDeviceHomeViewModel.access$isDiaryHomeStateUnchanged(this.this$0, r5) == false) goto L31;
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, "refreshDeviceHomeDiaryData skip unchanged home status");
            return Unit.INSTANCE;
        L31:
            if (DoraObricDeviceHomeViewModel.access$publishHomeStatusFromLatestDevices(this.this$0, "diary_data_changed") == true) goto L36;
            DoraObricDeviceHomeViewModel r14 = this.this$0;
            this.label = 3;
            if (DoraObricDeviceHomeViewModel.updateDeviceStatusWithCurrentContent$default(r14, false, this, 1, null) != r0) goto L36;
            return r0;
        L11:
            ResultKt.throwOnFailure(r13);
            Object r15 = ((Result) r13).unbox-impl();
        L16:
            if (this.$requestId != DoraObricDeviceHomeViewModel.access$getDiaryDataRequestId$p(this.this$0)) goto L40;
            if (Intrinsics.areEqual(this.$requestAccountId, DoraObricDeviceHomeViewModel.access$currentAccountId(this.this$0)) == false) goto L40;
            Throwable r3 = Result.exceptionOrNull-impl(r15);
            if (r3 != null) goto L37;
            boolean r16 = ((Boolean) r15).booleanValue();
            r2 = DoraObricDeviceHomeViewModel.access$getUsageEvidence$p(this.this$0).d;
            DoraObricDeviceHomeViewModel r8 = this.this$0;
            DoraObricDeviceHomeViewModel.access$setUsageEvidence$p(r8, s1.a(DoraObricDeviceHomeViewModel.access$getUsageEvidence$p(r8), false, r16, 7));
            CoroutineDispatcher r9 = Dispatchers.getIO();
            C00981 r10 = new C00981(this.this$0, this.$requestAccountId, r16, null);
            this.Z$0 = r16;
            this.Z$1 = r2;
            this.label = 2;
            if (BuildersKt.withContext(r9, r10, this) != r0) goto L25;
            return r0;
        L25:
            r5 = r16;
            goto L26
        L37:
            g49.d.c(DoraObricDeviceHomeViewModel.TAG, "refreshDeviceHomeDiaryData failed", r3);
            return Unit.INSTANCE;
        L40:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r13);
            DoraObricDeviceHomeViewModel r17 = this.this$0;
            String r4 = this.$requestAccountId;
            boolean r11 = this.$forceRefresh;
            this.label = 1;
            r15 = DoraObricDeviceHomeViewModel.m233access$queryDiaryData0E7RQCE(r17, r4, r11, this);
            if (r15 != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$refreshDeviceList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$refreshDeviceList$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {1752}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $connectedDeviceMac;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04701(String r1, DoraObricDeviceHomeViewModel r2, Continuation<? super C04701> r3) {
            this.$connectedDeviceMac = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04701(this.$connectedDeviceMac, this.this$0, r4);
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
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            String r6 = this.$connectedDeviceMac;
            if (r6 == null) goto L11;
            DoraObricDeviceHomeViewModel.access$moveDeviceToFront(this.this$0, r6);
        L11:
            DoraObricDeviceHomeViewModel r7 = this.this$0;
            this.label = 1;
            if (DoraObricDeviceHomeViewModel.updateDeviceStatusWithCurrentContent$default(r7, false, this, 1, null) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$replaceBind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$replaceBind$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {1229, 1234}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04711(DoraDevice r1, DoraObricDeviceHomeViewModel r2, Continuation<? super C04711> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04711(this.$device, this.this$0, r4);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r10);
        L21:
            Object r11 = r2;
        L23:
            Throwable r12 = Result.exceptionOrNull-impl(r11);
            if (r12 == null) goto L27;
            g49.d.c(DoraObricDeviceHomeViewModel.TAG, "replaceBind failed", r12);
            t19.s r13 = t19.s.a;
            DoraObricDeviceHomeViewModel.access$getCompanion$p().getClass();
            Application r3 = a.a();
            r13.getClass();
            t19.s.b(r3, 2131908080, false);
        L27:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
            r11 = ((Result) r10).unbox-impl();
        L13:
            DoraObricDeviceHomeViewModel r4 = this.this$0;
            if (Result.isSuccess-impl(r11) == false) goto L23;
            int r6 = ((Number) r11).intValue();
            g49.d.d(DoraObricDeviceHomeViewModel.TAG, "replaceBind replaceBindCode=" + r6);
            if (r6 != 1) goto L22;
            r4.load();
            kj4.a r5 = kj4.a.g();
            this.L$0 = r11;
            this.label = 2;
            if (DoraAdapterExtKt.b(r5) != r0) goto L20;
            return r0;
        L20:
            r2 = r11;
            goto L21
        L22:
            t19.s r7 = t19.s.a;
            DoraObricDeviceHomeViewModel.access$getCompanion$p().getClass();
            Application r8 = a.a();
            r7.getClass();
            t19.s.b(r8, 2131904024, false);
            Unit r9 = Unit.INSTANCE;
            goto L23
        L10:
            ResultKt.throwOnFailure(r10);
            DoraNetworkApi r14 = DoraNetworkApi.a;
            DoraDevice r15 = this.$device;
            this.label = 1;
            r11 = r14.w(r15, this);
            if (r11 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$requestEnvironmentMemoryAuthorization$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$requestEnvironmentMemoryAuthorization$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {990}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $deviceMac;
        final /* synthetic */ long $requestId;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04721(DoraObricDeviceHomeViewModel r1, String r2, long r3, Continuation<? super C04721> r5) {
            this.this$0 = r1;
            this.$deviceMac = r2;
            this.$requestId = r3;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C04721(this.this$0, this.$deviceMac, this.$requestId, r8);
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
            MutableSharedFlow r8 = DoraObricDeviceHomeViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.device_home.i.b r2 = new com.larus.dora.obric.device_management.device_home.i.b(this.$deviceMac, this.$requestId);
            this.label = 1;
            if (r8.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$scanBleInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel", f = "DoraObricDeviceHomeViewModel.kt", i = {0, 0, 0}, l = {2503}, m = "scanBleInfo", n = {"scannedDevice", "scanCallback", "startScanTimestamp"}, s = {"L$0", "L$1", "J$0"})
    public static final class C04731 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04731(DoraObricDeviceHomeViewModel r1, Continuation<? super C04731> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return DoraObricDeviceHomeViewModel.access$scanBleInfo(this.this$0, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$scanBleInfo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$scanBleInfo$2", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {2503}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $done;
        int label;

        public AnonymousClass2(CompletableDeferred<Unit> r1, Continuation<? super AnonymousClass2> r2) {
            this.$done = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$done, r3);
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
            CompletableDeferred<Unit> r5 = this.$done;
            this.label = 1;
            if (r5.await(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$showConnectionRequired$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$showConnectionRequired$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {1466}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $featureName;
        final /* synthetic */ DoraDevice $reconnectDevice;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04741(DoraObricDeviceHomeViewModel r1, DoraDevice r2, String r3, Continuation<? super C04741> r4) {
            this.this$0 = r1;
            this.$reconnectDevice = r2;
            this.$featureName = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C04741(this.this$0, this.$reconnectDevice, this.$featureName, r5);
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
            MutableSharedFlow r7 = DoraObricDeviceHomeViewModel.access$get_deviceIntentSharedFlow$p(this.this$0);
            com.larus.dora.obric.device_management.device_home.a.c r2 = new com.larus.dora.obric.device_management.device_home.a.c(this.$reconnectDevice, this.$featureName);
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$syncDeviceOrder$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel", f = "DoraObricDeviceHomeViewModel.kt", i = {0}, l = {1631}, m = "syncDeviceOrder", n = {"bindList"}, s = {"L$0"})
    public static final class C04751 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04751(DoraObricDeviceHomeViewModel r1, Continuation<? super C04751> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricDeviceHomeViewModel.access$syncDeviceOrder(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$toggleEnvironmentMemory$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$toggleEnvironmentMemory$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {891}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04761(DoraObricDeviceHomeViewModel r1, Continuation<? super C04761> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04761(this.this$0, r3);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MutableSharedFlow r6 = DoraObricDeviceHomeViewModel.access$get_action$p(this.this$0);
            com.larus.dora.obric.device_management.device_home.i.c r2 = new com.larus.dora.obric.device_management.device_home.i.c(DoraObricEnvironmentMemoryToastType.UNAVAILABLE);
            this.label = 1;
            if (r6.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$updateBatteryFromCallback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$updateBatteryFromCallback$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {1595, 1596}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04771(DoraObricDeviceHomeViewModel r1, Continuation<? super C04771> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04771(this.this$0, r3);
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
            DoraObricDeviceHomeViewModel r7 = this.this$0;
            this.label = 2;
            if (DoraObricDeviceHomeViewModel.access$updateOnlyDeviceComponent(r7, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(300, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$updateChargeFromCallback$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$updateChargeFromCallback$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {1623, 1624}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04781(DoraObricDeviceHomeViewModel r1, Continuation<? super C04781> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04781(this.this$0, r3);
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
            DoraObricDeviceHomeViewModel r7 = this.this$0;
            this.label = 2;
            if (DoraObricDeviceHomeViewModel.access$updateOnlyDeviceComponent(r7, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r6);
            this.label = 1;
            if (DelayKt.delay(300, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$updateDeviceStatusWithCurrentContent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel", f = "DoraObricDeviceHomeViewModel.kt", i = {0, 0, 1, 1}, l = {1769, 1773}, m = "updateDeviceStatusWithCurrentContent", n = {"accountId", "allowAutoSwitch", "rawBindList", "allowAutoSwitch"}, s = {"L$0", "Z$0", "L$0", "Z$0"})
    public static final class C04791 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04791(DoraObricDeviceHomeViewModel r1, Continuation<? super C04791> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricDeviceHomeViewModel.access$updateDeviceStatusWithCurrentContent(this.this$0, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$updateEnvironmentMemorySwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$updateEnvironmentMemorySwitch$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {1017, 1027, 1043}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        final /* synthetic */ String $deviceMac;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ DoraObricEnvironmentMemoryClickAction $requestedAction;
        int label;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$updateEnvironmentMemorySwitch$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$updateEnvironmentMemorySwitch$1$1", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $enabled;
            int label;
            final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

            public C00991(DoraObricDeviceHomeViewModel r1, boolean r2, Continuation<? super C00991> r3) {
                this.this$0 = r1;
                this.$enabled = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00991(this.this$0, this.$enabled, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L14;
                ResultKt.throwOnFailure(r5);
                IDoraPageConfig r6 = DoraObricDeviceHomeViewModel.access$getDoraPageConfig(this.this$0);
                if (r6 == null) goto L7;
                r6.a("dora_g_config_key_env_observe_enable", this.$enabled);
            L7:
                DoraBuryPointManager r7 = DoraBuryPointManager.a;
                if (this.$enabled == false) goto L10;
                String r0 = "on";
            L11:
                DoraBuryPointManager.J(r7, "dora_observation_settings_change", MapsKt.mapOf(TuplesKt.to("dora_g_observation_switch", r0)), false, 12);
                o49.b.b.a();
                EnvObserveChangeReason r8 = EnvObserveChangeReason.SWITCH_CHANGE;
                Intrinsics.checkNotNullParameter(r8, "reason");
                DoraEnvObserveManager.a.getClass();
                DoraEnvObserveManager.h(r8, 181);
                return Unit.INSTANCE;
            L10:
                r0 = "off";
                goto L11
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public C04801(DoraObricDeviceHomeViewModel r1, boolean r2, DoraObricEnvironmentMemoryClickAction r3, String r4, DoraDevice r5, Continuation<? super C04801> r6) {
            this.this$0 = r1;
            this.$enabled = r2;
            this.$requestedAction = r3;
            this.$deviceMac = r4;
            this.$device = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C04801(this.this$0, this.$enabled, this.$requestedAction, this.$deviceMac, this.$device, r9);
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
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L11;
            if (r1 != 3) goto L10;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
        L30:
            if (this.$enabled == false) goto L58;
            List<q> r10 = ((c) DoraObricDeviceHomeViewModel.access$get_uiState$p(this.this$0).getValue()).f;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            String r2 = this.$deviceMac;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            Iterator<T> r11 = r10.iterator();     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
        L33:
            if (r11.hasNext() == false) goto L37;
            Object r3 = r11.next();     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            if (Intrinsics.areEqual(((q) r3).a, r2) == false) goto L33;
        L38:
            q r4 = (q) r3;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            if (r4 == null) goto L45;
            h3 r12 = r4.d;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            if (r12 == null) goto L45;
            DoraObricEnvironmentMemoryState r13 = r12.i;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            if (r13 == null) goto L45;
        L46:
            int r5 = i2.a;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            h2 r14 = i2.a(this.$requestedAction, r13, TimerJob.j.a().e(Calendar.getInstance()));     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            if (r14.a == false) goto L55;
            DoraEnvObserveManager r6 = DoraEnvObserveManager.a;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            String r7 = this.$deviceMac;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            r6.getClass();     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            DoraEnvObserveManager.a(r7);     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            DoraObricDeviceHomeViewModel.refreshDeviceList$default(this.this$0, null, 1, null);     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
        L55:
            DoraObricDeviceHomeViewModel.access$emitEnvironmentMemoryToast(this.this$0, r14.b);     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
        L45:
            r13 = DoraObricEnvironmentMemoryState.UNKNOWN;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            goto L46
        L37:
            r3 = null;
        L58:
            DoraObricDeviceHomeViewModel.access$getEnvironmentMemorySwitchCooldownPolicy$p(this.this$0).a();
            DoraObricDeviceHomeViewModel.access$setEnvironmentMemoryUpdateJob$p(this.this$0, null);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
        L26:
            DoraObricDeviceHomeViewModel r15 = this.this$0;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            this.label = 3;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            if (DoraObricDeviceHomeViewModel.updateDeviceStatusWithCurrentContent$default(r15, false, this, 1, null) != r0) goto L30;
            return r0;
        L12:
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
        L19:
            if (((Boolean) r9).booleanValue() == true) goto L23;
            DoraObricDeviceHomeViewModel.access$handleEnvironmentMemorySwitchFailure(this.this$0);     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            DoraObricDeviceHomeViewModel.access$getEnvironmentMemorySwitchCooldownPolicy$p(this.this$0).a();
            DoraObricDeviceHomeViewModel.access$setEnvironmentMemoryUpdateJob$p(this.this$0, null);
            return r16;
        L23:
            CoroutineDispatcher r17 = Dispatchers.getIO();     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            C00991 r8 = new C00991(this.this$0, this.$enabled, null);     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            this.label = 2;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            if (BuildersKt.withContext(r17, r8, this) != r0) goto L26;
            return r0;
        L14:
            ResultKt.throwOnFailure(r9);
            CoroutineDispatcher r18 = Dispatchers.getIO();     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            DoraObricDeviceHomeViewModel$updateEnvironmentMemorySwitch$1$success$1 r20 = new DoraObricDeviceHomeViewModel$updateEnvironmentMemorySwitch$1$success$1(this.$device, this.$enabled, null);     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            this.label = 1;     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            r9 = BuildersKt.withContext(r18, r20, this);     // Catch: Throwable -> L49 Exception -> L51 CancellationException -> L53
            if (r9 != r0) goto L19;
            return r0;
        L49:
            th = move-exception;
            DoraObricDeviceHomeViewModel.access$getEnvironmentMemorySwitchCooldownPolicy$p(this.this$0).a();
            DoraObricDeviceHomeViewModel.access$setEnvironmentMemoryUpdateJob$p(this.this$0, null);
            throw th;
        L53:
            e = move-exception;
            throw e;     // Catch: Throwable -> L49
        L51:
            e = move-exception;
            g49.d.c(DoraObricDeviceHomeViewModel.TAG, "toggleEnvironmentMemory failed", e);     // Catch: Throwable -> L49
            DoraObricDeviceHomeViewModel.access$handleEnvironmentMemorySwitchFailure(this.this$0);     // Catch: Throwable -> L49
            goto L58
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$updateOnlyDeviceComponent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel", f = "DoraObricDeviceHomeViewModel.kt", i = {0}, l = {1870, 1875, 1889}, m = "updateOnlyDeviceComponent", n = {"selectedDeviceMac"}, s = {"L$0"})
    public static final class C04811 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

        public C04811(DoraObricDeviceHomeViewModel r1, Continuation<? super C04811> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricDeviceHomeViewModel.access$updateOnlyDeviceComponent(this.this$0, this);
        }
    }

    public static /* synthetic */ IDoraService Mo() {
        return doraService_delegate$lambda$1();
    }

    public static /* synthetic */ IDoraPageConfig No() {
        return doraPageConfig_delegate$lambda$0();
    }

    public static /* synthetic */ CharSequence Oo(m1 r0) {
        return publishHomeStatus$lambda$41(r0);
    }

    public static /* synthetic */ CharSequence Po(DoraObricDeviceHomeQuickActionConfigItem r0) {
        return buildQuickActions$lambda$48(r0);
    }

    private final void onConnectRequestFailed() {
        this.connectingDeviceMac = null;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04651(this, null), 3, null);
    }

    public static /* synthetic */ CharSequence yo(m1 r0) {
        return refreshQuickActions$lambda$47(r0);
    }

    static {
        Companion = new a();
        int r0 = com.larus.utils.j0.a;
        String r3 = com.larus.utils.j0.d(2131904124);
        TITLE_DOUBAO_ASSISTANT = r3;
        String r1 = com.larus.utils.j0.d(2131900385);
        TITLE_NOTIFICATION_BROADCAST = r1;
        List<m1> r2 = CollectionsKt.listOf(new m1[]{new m1(DoraObricDeviceHomeQuickActionType.DOUBAO_ASSISTANT, r3, 0, "larus_dora_obric_device_home_ic_doubao_assistant", 16), new m1(DoraObricDeviceHomeQuickActionType.QUICK_NOTE, com.larus.utils.j0.d(2131903042), 2131240565, null, 24), new m1(DoraObricDeviceHomeQuickActionType.RECORD_MINUTES, com.larus.utils.j0.d(2131902674), 2131240567, null, 24), new m1(DoraObricDeviceHomeQuickActionType.SIMULTANEOUS_INTERPRET, com.larus.utils.j0.d(2131903048), 2131240568, null, 24)});
        DEFAULT_GLASSES_QUICK_ACTIONS = r2;
        QUICK_ACTION_DISPLAY_ORDER = CollectionsKt.plus(r2, CollectionsKt.listOf(new m1(DoraObricDeviceHomeQuickActionType.NOTIFICATION_BROADCAST, r1, 2131240563, null, 24)));
        DEVICE_BOTTOM_TAB = new r1(com.larus.utils.j0.d(2131903447), DoraObricDeviceHomeTabPage.DEVICE, true);
        DIARY_BOTTOM_TAB = new r1(com.larus.utils.j0.d(2131902643), DoraObricDeviceHomeTabPage.DIARY, false);
        HEALTH_BOTTOM_TAB = new r1(com.larus.utils.j0.d(2131902652), DoraObricDeviceHomeTabPage.HEALTH, false);
        DISCOVER_BOTTOM_TAB = new r1(com.larus.utils.j0.d(2131902572), DoraObricDeviceHomeTabPage.DISCOVER, false);
    }

    private final Bundle createAddDeviceArguments() {
        Bundle r0 = new Bundle();
        r0.putString(PARAM_PAGE_KEY, "device_list_v2");
        r0.putString(PARAM_PREVIOUS_PAGE, PREVIOUS_PAGE_DEVICE_HOME);
        r0.putString(PARAM_ENTER_METHOD, ENTER_METHOD_CLICK_BUTTON);
        return r0;
    }

    private final String currentAccountId() {
        String r0 = ILoginService.a.getAccountInfo().c;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    private final IDoraAVLinkService currentAvLinkService() {
        IDoraAVLinkService r0 = this.registeredAvLinkService;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$0() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private static final IDoraService doraService_delegate$lambda$1() {
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    private final IDoraService getDoraService() {
        return (IDoraService) this.doraService$delegate.getValue();
    }

    private final void handleEnvironmentMemorySwitchFailure() {
        int r0 = k2.a;
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L5;
        DoraObricEnvironmentMemoryToastType r1 = DoraObricEnvironmentMemoryToastType.SWITCH_OPEN_NETWORK_ERROR;
    L7:
        if (r1 != DoraObricEnvironmentMemoryToastType.NONE) goto L10;
        t19.s r2 = t19.s.a;
        Companion.getClass();
        Application r3 = a.a();
        r2.getClass();
        t19.s.b(r3, 2131903992, false);
        return;
    L10:
        emitEnvironmentMemoryToast(r1);
        return;
    L5:
        r1 = DoraObricEnvironmentMemoryToastType.NONE;
        goto L7
    }

    private final boolean hasConnectedGlasses() {
        List<? extends DoraDevice> r0 = this.latestBoundDevices;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L25;
        DoraDevice r2 = (DoraDevice) r1.next();
        if (t.a(r2) == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L9;
        return true;
    L13:
        if (kj4.a.g().getDoraLinkState(r2) != 2) goto L15;
        r3 = true;
        goto L16
    L25:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    private final void invalidateDeviceCardSelection() {
        this.deviceCardSelectionRequestId++;
        Job r0 = this.deviceCardSelectionJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.deviceCardSelectionJob = null;
    }

    private final boolean isEnvironmentMemorySwitchCoolingDown() {
        j2 r0 = this.environmentMemorySwitchCooldownPolicy;
        Long r1 = r0.c;
        if (r1 == null) goto L7;
        long r2 = r1.longValue();
        if ((((Number) r0.a.invoke()).longValue() - r2) >= r0.b) goto L7;
        return true;
    L7:
        return false;
    }

    private final void openAddDevicePage() {
        emitRoute("//flow/dora/obric_device_list", createAddDeviceArguments());
    }

    private final void refreshQuickActions() {
        c r2 = (c) this._uiState.getValue();
        if (r2.d == true) goto L5;
        return;
    L5:
        if (r2.a != PageState.Content) goto L13;
        int r1 = s.a;
        List<m1> r3 = buildQuickActions(s.a(this.usageEvidence, hasHealthEntry()), r2.b);
        if (Intrinsics.areEqual(r3, r2.l) == false) goto L10;
        return;
    L10:
        this._uiState.setValue(c.a(r2, null, null, null, false, null, 0, null, false, false, r3, null, 6143));
        g49.d.d(TAG, "Settings updated quick actions=" + CollectionsKt.joinToString$default(r3, null, null, null, 0, null, new x1(), 31, null));
        return;
    }

    private final void registerAvLinkListeners() {
        if (this.registeredAvLinkService == null) goto L5;
        return;
    L5:
        IDoraAVLinkService r0 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r0 != null) goto L9;
        g49.d.e(TAG, "AVLink service unavailable, skip state listeners");
        return;
    L9:
        this.registeredAvLinkService = r0;
        r0.S0(this.sceneStateListener);
    }

    private final void unregisterAvLinkListeners() {
        IDoraAVLinkService r0 = this.registeredAvLinkService;
        if (r0 == null) goto L5;
        r0.v0(this.sceneStateListener);
    L5:
        this.registeredAvLinkService = null;
    }

    public final boolean hasBoundGlasses() {
        List<? extends DoraDevice> r0 = this.latestBoundDevices;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (t.a((DoraDevice) r1.next()) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public final String healthEntryUrl() {
        DoraSetting.a.getClass();
        return StringsKt.trim((String) com.larus.utils.l0.a("", new com.larus.dora.impl.settings.v())).toString();
    }

    public final boolean isDiaryEntryAvailable() {
        if (((c) this._uiState.getValue()).j == false) goto L5;
    L8:
        return true;
    L5:
        if (this.usageEvidence.c == true) goto L8;
        return false;
    }

    public final void load() {
        g49.d.d(TAG, "load start");
        registerAvLinkListeners();
        this.initialHomeStatePending = !((c) this._uiState.getValue()).d;
        resetDiaryDataForAccountChange();
        Job r0 = this.loadJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Job r1 = this.deviceStatusUpdateJob;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.loadJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04641(this, null), 3, null);
    }

    public final void onAddDeviceClicked() {
        g49.d.d(TAG, "onAddDeviceClicked");
        openAddDevicePage();
    }

    public final void onBindDeviceClicked() {
        g49.d.d(TAG, "onBindDeviceClicked");
        openAddDevicePage();
    }

    public void onCleared() {
        Job r0 = this.loadJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        Job r1 = this.bindCheckJob;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        Job r2 = this.deviceStatusUpdateJob;
        if (r2 == null) goto L11;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L11:
        Job r3 = this.deviceCardSelectionJob;
        if (r3 == null) goto L14;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L14:
        Job r4 = this.environmentMemoryUpdateJob;
        if (r4 == null) goto L17;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L17:
        Job r5 = this.diaryDataJob;
        if (r5 == null) goto L20;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L20:
        kj4.a.g().unregisterDoraLinkCallback(this.deviceStateCallback);
        kj4.a.g().E(this.batteryCallback);
        kj4.a.g().E(this.headphoneModeCallback);
        IDoraService r6 = getDoraService();
        if (r6 == null) goto L25;
        SessionService r7 = r6.d();
        if (r7 == null) goto L25;
        r7.x(this.doraVoiceCallback);
    L25:
        IDoraService r8 = getDoraService();
        if (r8 == null) goto L30;
        com.larus.dora.impl.serviceimpl.r r9 = r8.g1();
        if (r9 == null) goto L30;
        r9.d(this.environmentMemoryChangeListener);
    L30:
        unregisterAvLinkListeners();
        SettingsManager.unregisterListener(this.settingsUpdateListener);
        super.onCleared();
    }

    public final void onDeviceCardClicked() {
        DoraDevice r0 = ((c) this._uiState.getValue()).b;
        if (r0 != null) goto L5;
        return;
    L5:
        g49.d.d(TAG, "onDeviceCardClicked mac=" + r0.mac + " productId=" + r0.productId);
        if (t.a(r0) == false) goto L9;
        emitRoute("//flow/dora/obric_g_settings", createDeviceRouteArguments$default(this, null, 1, null));
        return;
    L9:
        emitRoute("//flow/dora/obric_earbuds_settings", createEarbudsSettingsArguments(r0));
    }

    public final void onDeviceNameUpdated() {
        g49.d.d(TAG, "onDeviceNameUpdated");
        refreshDeviceList$default(this, null, 1, null);
    }

    public final void onReconnectFailed() {
        g49.d.d(TAG, "onReconnectFailed");
        onConnectRequestFailed();
    }

    public final String resolveDiaryGlassesMac() {
        Iterator<T> r0 = this.latestBoundDevices.iterator();
    L3:
        boolean r2 = true;
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        DoraDevice r5 = (DoraDevice) r1;
        if (Intrinsics.areEqual(r5.mac, this.currentDeviceMac) == true) goto L8;
    L10:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L3;
    L14:
        DoraDevice r3 = (DoraDevice) r1;
        if (r3 == null) goto L24;
        String r4 = r3.mac;
        if (r4 == null) goto L24;
        if (r4.length() <= 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L24;
    L25:
        if (r4 != null) goto L43;
        Iterator<T> r8 = this.latestBoundDevices.iterator();
    L28:
        if (r8.hasNext() == false) goto L32;
        Object r9 = r8.next();
        if (t.a((DoraDevice) r9) == false) goto L28;
    L33:
        DoraDevice r10 = (DoraDevice) r9;
        if (r10 == null) goto L52;
        r4 = r10.mac;
        if (r4 != null) goto L38;
        return null;
    L38:
        if (r4.length() > 0) goto L41;
        r2 = false;
    L41:
        if (r2 == true) goto L43;
        return null;
    L52:
        return null;
    L32:
        r9 = null;
    L43:
        return r4;
    L21:
        r7 = false;
    L24:
        r4 = null;
        goto L25
    L8:
        if (t.a(r5) == false) goto L10;
        r6 = true;
        goto L11
    L13:
        r1 = null;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$sceneStateListener$1] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.bytedance.news.common.settings.SettingsUpdateListener, com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel$settingsUpdateListener$1] */
    public DoraObricDeviceHomeViewModel() {
        PageState r1 = null;
        boolean r2 = false;
        StateFlowImpl r0 = kotlinx.coroutines.flow.j1.a(new c(r1, r2, null, null, 8191));
        this._uiState = r0;
        this.uiState = r0;
        MutableSharedFlow<com.larus.dora.obric.device_management.device_home.a> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._deviceIntentSharedFlow = r3;
        this.deviceIntentSharedFlow = r3;
        MutableSharedFlow<com.larus.dora.obric.device_management.device_home.i> r4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._action = r4;
        this.action = r4;
        this.batteryInfoByDeviceMac = new LinkedHashMap();
        this.chargeInfoByDeviceMac = new LinkedHashMap();
        this.deviceOrder = new ArrayList();
        this.usageRepository = new DoraObricDeviceHomeUsageRepository();
        this.doraPageConfig$delegate = LazyKt.lazy(new v1());
        this.doraService$delegate = LazyKt.lazy(new w1());
        this.usageEvidence = new s1(false, false, false, 15);
        this.latestBoundDevices = CollectionsKt.emptyList();
        this.environmentMemorySwitchCooldownPolicy = new j2(DoraObricDeviceHomeViewModel$environmentMemorySwitchCooldownPolicy$1.INSTANCE);
        this.environmentMemoryAuthorizationContinuation = new f2();
        this.currentConfirmedGlassesMode = t69.b.c;
        this.sceneStateListener = new DoraObricDeviceHomeViewModel$sceneStateListener$1(this);
        i r5 = new i(this);
        this.environmentMemoryChangeListener = r5;
        h r6 = new h(this);
        this.doraVoiceCallback = r6;
        j r7 = new j(this);
        this.headphoneModeCallback = r7;
        g r8 = new g(this);
        this.deviceStateCallback = r8;
        e r9 = new e(this);
        this.batteryCallback = r9;
        ?? r10 = new DoraObricDeviceHomeViewModel$settingsUpdateListener$1(this);
        this.settingsUpdateListener = r10;
        g49.d.d(TAG, "init register device callbacks");
        kj4.a.g().registerDoraLinkCallback(r8, true);
        kj4.a.g().k(r9);
        kj4.a.g().k(r7);
        IDoraService r11 = getDoraService();
        if (r11 == null) goto L7;
        SessionService r12 = r11.d();
        if (r12 == null) goto L7;
        r12.i(r6);
    L7:
        IDoraService r13 = getDoraService();
        if (r13 == null) goto L12;
        com.larus.dora.impl.serviceimpl.r r14 = r13.g1();
        if (r14 == null) goto L12;
        r14.a(r5);
    L12:
        registerAvLinkListeners();
        SettingsManager.registerListener(r10, true);
    }

    private final boolean hasHealthEntry() {
        return !StringsKt.isBlank(healthEntryUrl());
    }

    private final String resetDiaryDataForAccountChange() {
        String r0 = currentAccountId();
        if (Intrinsics.areEqual(r0, this.diaryDataAccountId) == false) goto L5;
        return r0;
    L5:
        g49.d.d(TAG, "resetDiaryDataForAccountChange");
        Job r1 = this.diaryDataJob;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.diaryDataAccountId = r0;
        s1 r2 = this.usageEvidence;
        this.usageEvidence = s1.a(r2, r2.a, false, 3);
        return r0;
    }

    private final DeviceMode resolveDeviceMode() {
        IDoraAVLinkService r0 = currentAvLinkService();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L28;
        if (r0 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L29;
        if (r0 != null) goto L19;
    L21:
        if (r1 == true) goto L30;
        t69.b r2 = t69.b.a;
        if (t69.b.c != 1) goto L27;
        return DeviceMode.EARPHONE;
    L27:
        return DeviceMode.NORMAL;
    L30:
        return DeviceMode.VIDEO_CALL;
    L19:
        if (r0.c1(1) != true) goto L21;
        r1 = true;
        goto L21
    L29:
        return DeviceMode.INTERPRET;
    L12:
        if (r0.c1(6) != true) goto L14;
        r4 = true;
        goto L15
    L28:
        return DeviceMode.RECORDING;
    L5:
        if (r0.c1(7) != true) goto L7;
        r3 = true;
        goto L8
    }

    public final void onAlbumSyncRequiresConnection() {
        if (hasConnectedGlasses() == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.latestBoundDevices.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (t.a((DoraDevice) r1) == false) goto L7;
    L12:
        int r2 = com.larus.utils.j0.a;
        showConnectionRequired((DoraDevice) r1, com.larus.utils.j0.d(2131900060));
        return;
    L11:
        r1 = null;
        goto L12
    }

    public final boolean onDiaryEntryRequested() {
        if (isDiaryEntryAvailable() == false) goto L6;
        return true;
    L6:
        Iterator<T> r0 = this.latestBoundDevices.iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        Object r1 = r0.next();
        if (t.a((DoraDevice) r1) == false) goto L8;
    L13:
        int r2 = com.larus.utils.j0.a;
        showConnectionRequired((DoraDevice) r1, com.larus.utils.j0.d(2131902643));
        return false;
    L12:
        r1 = null;
        goto L13
    }

    public static final /* synthetic */ a access$getCompanion$p() {
        return Companion;
    }

    public static final /* synthetic */ List access$getDEFAULT_GLASSES_QUICK_ACTIONS$cp() {
        return DEFAULT_GLASSES_QUICK_ACTIONS;
    }

    public static final /* synthetic */ List access$getQUICK_ACTION_DISPLAY_ORDER$cp() {
        return QUICK_ACTION_DISPLAY_ORDER;
    }

    public static final /* synthetic */ String access$getTITLE_DOUBAO_ASSISTANT$cp() {
        return TITLE_DOUBAO_ASSISTANT;
    }

    public static final /* synthetic */ String access$getTITLE_NOTIFICATION_BROADCAST$cp() {
        return TITLE_NOTIFICATION_BROADCAST;
    }

    public final kotlinx.coroutines.flow.d1<com.larus.dora.obric.device_management.device_home.i> getAction() {
        return this.action;
    }

    public final kotlinx.coroutines.flow.d1<com.larus.dora.obric.device_management.device_home.a> getDeviceIntentSharedFlow() {
        return this.deviceIntentSharedFlow;
    }

    public final kotlinx.coroutines.flow.i1<c> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ String access$currentAccountId(DoraObricDeviceHomeViewModel r0) {
        return r0.currentAccountId();
    }

    public static final /* synthetic */ Map access$getBatteryInfoByDeviceMac$p(DoraObricDeviceHomeViewModel r0) {
        return r0.batteryInfoByDeviceMac;
    }

    public static final /* synthetic */ Job access$getBatteryUpdateJob$p(DoraObricDeviceHomeViewModel r0) {
        return r0.batteryUpdateJob;
    }

    public static final /* synthetic */ long access$getBindCheckRequestId$p(DoraObricDeviceHomeViewModel r2) {
        return r2.bindCheckRequestId;
    }

    public static final /* synthetic */ Map access$getChargeInfoByDeviceMac$p(DoraObricDeviceHomeViewModel r0) {
        return r0.chargeInfoByDeviceMac;
    }

    public static final /* synthetic */ Job access$getChargeUpdateJob$p(DoraObricDeviceHomeViewModel r0) {
        return r0.chargeUpdateJob;
    }

    public static final /* synthetic */ String access$getCurrentDeviceMac$p(DoraObricDeviceHomeViewModel r0) {
        return r0.currentDeviceMac;
    }

    public static final /* synthetic */ long access$getDeviceCardSelectionRequestId$p(DoraObricDeviceHomeViewModel r2) {
        return r2.deviceCardSelectionRequestId;
    }

    public static final /* synthetic */ List access$getDeviceOrder$p(DoraObricDeviceHomeViewModel r0) {
        return r0.deviceOrder;
    }

    public static final /* synthetic */ long access$getDiaryDataRequestId$p(DoraObricDeviceHomeViewModel r2) {
        return r2.diaryDataRequestId;
    }

    public static final /* synthetic */ IDoraPageConfig access$getDoraPageConfig(DoraObricDeviceHomeViewModel r0) {
        return r0.getDoraPageConfig();
    }

    public static final /* synthetic */ j2 access$getEnvironmentMemorySwitchCooldownPolicy$p(DoraObricDeviceHomeViewModel r0) {
        return r0.environmentMemorySwitchCooldownPolicy;
    }

    public static final /* synthetic */ int access$getLastKnownBindListSize$p(DoraObricDeviceHomeViewModel r0) {
        return r0.lastKnownBindListSize;
    }

    public static final /* synthetic */ String access$getPendingEntryDeviceMac$p(DoraObricDeviceHomeViewModel r0) {
        return r0.pendingEntryDeviceMac;
    }

    public static final /* synthetic */ s1 access$getUsageEvidence$p(DoraObricDeviceHomeViewModel r0) {
        return r0.usageEvidence;
    }

    public static final /* synthetic */ DoraObricDeviceHomeUsageRepository access$getUsageRepository$p(DoraObricDeviceHomeViewModel r0) {
        return r0.usageRepository;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_action$p(DoraObricDeviceHomeViewModel r0) {
        return r0._action;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_deviceIntentSharedFlow$p(DoraObricDeviceHomeViewModel r0) {
        return r0._deviceIntentSharedFlow;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.z0 access$get_uiState$p(DoraObricDeviceHomeViewModel r0) {
        return r0._uiState;
    }

    public static final /* synthetic */ void access$handleEnvironmentMemorySwitchFailure(DoraObricDeviceHomeViewModel r0) {
        r0.handleEnvironmentMemorySwitchFailure();
    }

    public static final /* synthetic */ void access$onConnectRequestFailed(DoraObricDeviceHomeViewModel r0) {
        r0.onConnectRequestFailed();
    }

    public static final /* synthetic */ void access$refreshQuickActions(DoraObricDeviceHomeViewModel r0) {
        r0.refreshQuickActions();
    }

    private final List<r1> buildBottomTabs(u r5) {
        r1[] r0 = new r1[4];
        r0[0] = DEVICE_BOTTOM_TAB;
        r1 r1 = DIARY_BOTTOM_TAB;
        r1 r3 = null;
        if (r5.c == true) goto L6;
        r1 = null;
    L6:
        r0[1] = r1;
        r1 r2 = HEALTH_BOTTOM_TAB;
        if (r5.d == false) goto L9;
        r3 = r2;
    L9:
        r0[2] = r3;
        r0[3] = DISCOVER_BOTTOM_TAB;
        return CollectionsKt.listOfNotNull(r0);
    }

    private static final CharSequence buildQuickActions$lambda$48(DoraObricDeviceHomeQuickActionConfigItem r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        return "key=" + r2.getKey() + ", enabled=" + r2.getEnabled() + ", order=" + r2.getOrder();
    }

    private final void clearBatterySnapshot(String r3) {
        if (this.currentBatteryInfo == null) goto L5;
    L7:
        g49.d.d(TAG, "clearBatterySnapshot source=" + r3);
        this.currentBatteryInfo = null;
        this.currentChargeInfo = null;
        return;
    L5:
        if (this.currentChargeInfo != null) goto L7;
    }

    private final Bundle createEarbudsSettingsArguments(DoraDevice r6) {
        Bundle r0 = createDeviceRouteArguments$default(this, null, 1, null);
        int r2 = r6.vendorId;
        if (r2 != 4096) goto L6;
        r0.putString(PARAM_PAGE_KEY, "device_manage_p_v3_h_g_o");
    L12:
        return r0;
    L6:
        if (r2 == 1) goto L8;
    L10:
        if (r2 != 0) goto L12;
        r0.putString(PARAM_PAGE_KEY, "device_manage_v3");
        goto L12
    L8:
        if (r6.productId != ProductNameType.DORA_LITE.id) goto L10;
        r0.putString(PARAM_PAGE_KEY, "device_manage_v3");
        goto L12
    }

    private final Bundle createSimultaneousInterpretArguments(DoraDevice r3) {
        Bundle r4 = createDeviceRouteArguments(r3);
        r4.putString(PARAM_ENTER_FROM, ENTER_FROM_OBRIC_DEVICE_HOME);
        r4.putString(PARAM_ENTER_METHOD, ENTER_METHOD_CLICK_CARD);
        r4.putBoolean(PARAM_AUTO_START, false);
        return r4;
    }

    private final b defaultDeviceCardImage(String r10) {
        return new b(0, DEFAULT_GLASSES_CARD_IMAGE_NAME, r10, DEFAULT_GLASSES_CARD_IMAGE_NAME, null, DoraResourceDeviceType.G1, 16);
    }

    private final void emitEnvironmentMemoryToast(DoraObricEnvironmentMemoryToastType r8) {
        if (r8 != DoraObricEnvironmentMemoryToastType.NONE) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04581(this, r8, null), 3, null);
    }

    private final String getDefaultDeviceCardImageSku(String r3) {
        switch(r3.hashCode()) {
            case 113642: goto L15;
            case 3322030: goto L11;
            case 108685738: goto L9;
            case 122023272: goto L6;
            default: goto L22;
        };
    L9:
        r3.equals(PRODUCT_CODE_ROBIN);
        return "white";
    L22:
        return "white";
    L6:
        if (r3.equals(PRODUCT_CODE_ROBIN_HARDENED) == false) goto L23;
        return "silver";
    L23:
        return "white";
    L11:
        if (r3.equals(PRODUCT_CODE_LITE) == false) goto L24;
        return "black";
    L24:
        return "white";
    L15:
        if (r3.equals(PRODUCT_CODE_SAX) == false) goto L25;
        return "gold";
    L25:
        return "white";
    }

    private final String getDeviceCardImageProductCode(int r2) {
        if (r2 != ProductNameType.H_FREE_CLIP_2.id) goto L6;
        return PRODUCT_CODE_ROBIN;
    L6:
        if (r2 != ProductNameType.H_FREE_CLIP_2_HE.id) goto L9;
        return PRODUCT_CODE_ROBIN_HARDENED;
    L9:
        if (r2 != ProductNameType.H_FREE_BUDS_PRO_5.id) goto L12;
        return PRODUCT_CODE_SAX;
    L12:
        if (r2 != ProductNameType.DORA_LITE.id) goto L14;
        return PRODUCT_CODE_LITE;
    L14:
        return null;
    }

    private final int getDrawableResId(String r4) {
        Companion.getClass();
        return a.a().getResources().getIdentifier(r4, "drawable", a.a().getPackageName());
    }

    private final String getGlassesCardImageProductCode(DoraDevice r4) {
        int r0 = r4.productId;
        if (r0 != ProductNameType.DORA_G2.id) goto L5;
    L10:
        return PRODUCT_CODE_G2;
    L5:
        if (r4.type == 17) goto L10;
        if (r0 != ProductNameType.DORA_G.id) goto L13;
        return PRODUCT_CODE_G1;
    L13:
        return PRODUCT_CODE_G1;
    }

    private final boolean isDiaryHomeStateUnchanged(boolean r3) {
        int r0 = s.a;
        u r1 = s.a(this.usageEvidence, hasHealthEntry());
        if (((c) this._uiState.getValue()).j == r3) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((c) this._uiState.getValue()).m, buildBottomTabs(r1)) == false) goto L7;
        return true;
    }

    private final void moveDeviceToFront(String r3) {
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.deviceOrder.remove(r3);
        ListProtector.add(this.deviceOrder, 0, r3);
        g49.d.d(TAG, "moveDeviceToFront");
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void onDeviceConnected(DoraDevice r21) {
        String r2 = r21.mac;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        boolean r5 = true;
        if (r2.length() <= 0) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
    L13:
        r5 = false;
    L15:
        if (r5 == false) goto L20;
        if (Intrinsics.areEqual(r21.mac, this.currentDeviceMac) == true) goto L20;
        invalidateDeviceCardSelection();
        g49.d.d(TAG, "onDeviceConnected switch selected card from=" + this.currentDeviceMac + " to=" + r2);
        this.currentDeviceMac = r21.mac;
        this.pendingEntryDeviceMac = null;
        this.currentBatteryInfo = null;
        this.currentChargeInfo = null;
    L20:
        if (Intrinsics.areEqual(r21.mac, this.currentDeviceMac) == false) goto L22;
        syncBatterySnapshot(r21, "link_state_connected");
    L22:
        cacheConnectedDeviceSnapshotIfNeeded(r21, "link_state_changed");
        String r7 = r21.name;
        if (r7 != null) goto L25;
        String r8 = "";
    L26:
        String r9 = r21.mac;
        if (r9 != null) goto L29;
        String r10 = "";
    L30:
        String r11 = r21.sn;
        if (r11 != null) goto L33;
        String r12 = "";
    L34:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04671(r2, new DoraSimpleDevice(r8, r10, r12, r21.sku, r21.type, r21.getSerialNumber()), null), 2, null);
        if (r5 == false) goto L38;
        this.connectingDeviceMac = null;
        return;
    L38:
        return;
    L33:
        r12 = r11;
        goto L34
    L29:
        r10 = r9;
        goto L30
    L25:
        r8 = r7;
        goto L26
    L11:
        if (Intrinsics.areEqual(r2, this.connectingDeviceMac) == false) goto L13;
    L8:
        r4 = false;
        goto L9
    }

    private final void onDeviceDisconnected(DoraDevice r3) {
        String r0 = r3.mac;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.batteryInfoByDeviceMac.remove(r0);
        this.chargeInfoByDeviceMac.remove(r0);
        if (Intrinsics.areEqual(r3.mac, this.currentDeviceMac) == true) goto L8;
        return;
    L8:
        g49.d.d(TAG, "onDeviceDisconnected current device=" + o59.a.h(r3) + " reconnectTarget=" + this.connectingDeviceMac);
        clearBatterySnapshot("link_state_disconnected");
    }

    private final void openQuickNoteRecord(DoraDevice r2) {
        QuickNoteRepo.a.getClass();
        QuickNoteRepo.h(r2);
    }

    private static final CharSequence publishHomeStatus$lambda$41(m1 r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.getType().getConfigKey();
    }

    private final boolean publishHomeStatusFromLatestDevices(String r7) {
        List<DoraDevice> r0 = sortDeviceList(this.latestBoundDevices);
        if (r0.isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<T> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r3 = r1.next();
        if (Intrinsics.areEqual(((DoraDevice) r3).mac, this.currentDeviceMac) == false) goto L7;
    L12:
        DoraDevice r4 = (DoraDevice) r3;
        if (r4 != null) goto L17;
        r4 = (DoraDevice) CollectionsKt.firstOrNull(r0);
        if (r4 != null) goto L17;
        return false;
    L17:
        publishHomeStatus(r0, r4, r7);
        return true;
    L11:
        r3 = null;
        goto L12
    }

    private final void refreshDeviceList(String r10) {
        Job r0 = this.deviceStatusUpdateJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.deviceStatusUpdateJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04701(r10, this, null), 3, null);
    }

    private static final CharSequence refreshQuickActions$lambda$47(m1 r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.getType().getConfigKey();
    }

    private final void requestEnvironmentMemoryAuthorization(String r14) {
        long r4 = this.environmentMemoryAuthorizationRequestId + 1;
        this.environmentMemoryAuthorizationRequestId = r4;
        f2 r1 = this.environmentMemoryAuthorizationContinuation;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r14, "deviceMac");
        Object r2 = r1.a;
        monitor-enter(r2);
        Long r3 = Long.valueOf(r4);     // Catch: Throwable -> L8
        r1.b.put(r14, r3);     // Catch: Throwable -> L8
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r2);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04721(this, r14, r4, null), 3, null);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private final DoraDevice requireConnectedDevice(DoraObricDeviceHomeQuickActionType r6) {
        Iterator<T> r0 = resolveCompatibleDevices(r6).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (kj4.a.g().getDoraLinkState((DoraDevice) r1) != 2) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        DoraDevice r2 = (DoraDevice) r1;
        if (r2 == null) goto L15;
        return r2;
    L15:
        showConnectionRequired(resolveReconnectDevice(r6), resolveQuickActionTitle(r6));
        return null;
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    private final List<DoraDevice> resolveCompatibleDevices(DoraObricDeviceHomeQuickActionType r5) {
        List<DoraDevice> r0 = sortDeviceList(this.latestBoundDevices);
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (supportsQuickAction((DoraDevice) r3, r5) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    private final b resolveGlassesCardImage(DoraDevice r11) {
        String r12 = getGlassesCardImageProductCode(r11);
        if (Intrinsics.areEqual(r12, PRODUCT_CODE_G1) == true) goto L5;
        String r0 = DEVICE_CARD_IMAGE_PREFIX + r12;
        if (Intrinsics.areEqual(r12, PRODUCT_CODE_G2) == true) goto L9;
        Integer r13 = Integer.valueOf(getDrawableResId(r0));
        if (r13.intValue() == 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == true) goto L17;
        r13 = null;
    L17:
        if (r13 == null) goto L21;
        return new b(r13.intValue(), r0, null, null, null, null, 60);
    L21:
        return defaultDeviceCardImage(r0);
    L13:
        r1 = false;
        goto L14
    L9:
        return new b(0, r0, null, r0, DEFAULT_GLASSES_CARD_IMAGE_NAME, DoraResourceDeviceType.G2, 4);
    L5:
        return defaultDeviceCardImage(DEFAULT_GLASSES_CARD_IMAGE_NAME);
    }

    private final String resolveInitialDeviceMac(Bundle r6) {
        boolean r0 = true;
        if (r6 == null) goto L15;
        String r3 = r6.getString(PARAM_PRODUCT_MAC);
        if (r3 == null) goto L15;
        if (r3.length() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        return r3;
    L9:
        r4 = false;
    L15:
        if (r6 == null) goto L26;
        String r7 = r6.getString("mac");
        if (r7 != null) goto L19;
        return null;
    L19:
        if (r7.length() > 0) goto L22;
        r0 = false;
    L22:
        if (r0 == true) goto L24;
        return null;
    L24:
        return r7;
    L26:
        return null;
    }

    private final b resolveProductSkuCardImage(DoraDevice r14) {
        String r0 = getDeviceCardImageProductCode(r14.productId);
        if (r0 == null) goto L5;
        String r15 = l59.a.c(r14);
        String r1 = normalizeDeviceCardImageSku(r0, r15);
        String r8 = DEVICE_CARD_IMAGE_PREFIX + r0 + '_' + r15;
        String r7 = DEVICE_CARD_IMAGE_PREFIX + r0 + '_' + r1;
        Integer r16 = Integer.valueOf(getDrawableResId(r7));
        boolean r2 = false;
        if (r16.intValue() == 0) goto L9;
        boolean r3 = true;
    L10:
        Integer r6 = null;
        if (r3 == true) goto L14;
        r16 = null;
    L14:
        if (r16 != null) goto L16;
        String r9 = DEVICE_CARD_IMAGE_PREFIX + r0 + '_' + getDefaultDeviceCardImageSku(r0);
        Integer r17 = Integer.valueOf(getDrawableResId(r9));
        if (r17.intValue() == 0) goto L20;
        r2 = true;
    L20:
        if (r2 == false) goto L22;
        r6 = r17;
    L22:
        if (r6 == null) goto L26;
        return new b(r6.intValue(), r9, r8, null, null, null, 56);
    L26:
        return defaultDeviceCardImage(r8);
    L16:
        return new b(r16.intValue(), r7, r8, null, null, null, 56);
    L9:
        r3 = false;
        goto L10
    L5:
        return defaultDeviceCardImage("unsupported_product");
    }

    private final String resolveQuickActionTitle(DoraObricDeviceHomeQuickActionType r5) {
        Iterator<T> r0 = ((c) this._uiState.getValue()).l.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((m1) r1).getType() != r5) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        m1 r2 = (m1) r1;
        if (r2 == null) goto L17;
        String r4 = r2.b;
        if (r4 == null) goto L17;
        return r4;
    L17:
        int r6 = d.a[r5.ordinal()];
        if (r6 == 1) goto L34;
        if (r6 == 2) goto L43;
        if (r6 != 3) goto L24;
        int r7 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131903042);
    L24:
        if (r6 != 4) goto L26;
        int r8 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131903048);
    L26:
        if (r6 != 5) goto L29;
        int r9 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(2131902674);
    L29:
        throw new NoWhenBranchMatchedException();
    L43:
        return TITLE_NOTIFICATION_BROADCAST;
    L34:
        return TITLE_DOUBAO_ASSISTANT;
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    private final DoraDevice resolveReconnectDevice(DoraObricDeviceHomeQuickActionType r1) {
        return (DoraDevice) CollectionsKt.firstOrNull(resolveCompatibleDevices(r1));
    }

    private final int resolveRouteProductId(DoraDevice r2) {
        int r0 = r2.productId;
        if (r0 == 0) goto L6;
        return r0;
    L6:
        if (t.a(r2) == false) goto L9;
        return ProductNameType.DORA_G.id;
    L9:
        return ProductNameType.DORA_LITE.id;
    }

    private final boolean shouldUseEarbudsCard(DoraDevice r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (t.a(r1) == true) goto L6;
        return true;
    }

    private final List<DoraDevice> sortDeviceList(List<? extends DoraDevice> r7) {
        Iterable r0 = CollectionsKt.withIndex(this.deviceOrder);
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        IndexedValue r3 = (IndexedValue) r1.next();
        Pair r4 = TuplesKt.to(r3.getValue(), Integer.valueOf(r3.getIndex()));
        r2.put(r4.getFirst(), r4.getSecond());
        goto L4
    L6:
        List<? extends DoraDevice> r8 = r7;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r8.iterator();
    L8:
        if (r6.hasNext() == false) goto L15;
        Object r9 = r6.next();
        kj4.a r10 = kj4.a.g();
        if (r10.getDoraLinkState((DoraDevice) r9) != 2) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L8;
        r5.add(r9);
        goto L8
    L12:
        r11 = false;
        goto L13
    L15:
        LinkedHashSet r12 = new LinkedHashSet();
        Iterator r13 = r5.iterator();
    L17:
        if (r13.hasNext() == false) goto L23;
        String r14 = ((DoraDevice) r13.next()).mac;
        if (r14 != null) goto L21;
        r14 = "";
    L21:
        r12.add(r14);
        goto L17
    L23:
        return CollectionsKt.sortedWith(r8, new m(new n(new l(), r12), r2));
    }

    private final DoraResourceDeviceType toGlassesResourceDeviceType(DoraDevice r5) {
        boolean r0 = true;
        if (r5 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L18;
        if (r5 != null) goto L11;
    L13:
        r0 = false;
    L14:
        if (r0 == true) goto L18;
        return DoraResourceDeviceType.G1;
    L11:
        if (r5.type != 17) goto L13;
    L18:
        return DoraResourceDeviceType.G2;
    L5:
        if (r5.productId != ProductNameType.DORA_G2.id) goto L7;
        r2 = true;
        goto L8
    }

    private final void updateCachedBattery(DoraDevice r3) {
        if (kj4.a.g().getDoraLinkState(r3) != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        clearBatterySnapshot("update_cache_disconnected");
        return;
    L9:
        syncBatterySnapshot(r3, "update_cache");
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void updateEmptyDeviceState(String r9) {
        g49.d.d(TAG, "updateEmptyDeviceState source=" + r9);
        this.pendingEntryDeviceMac = null;
        this.currentDeviceMac = null;
        this.currentBatteryInfo = null;
        this.currentChargeInfo = null;
        this.batteryInfoByDeviceMac.clear();
        this.chargeInfoByDeviceMac.clear();
        this.latestBoundDevices = CollectionsKt.emptyList();
        this._uiState.setValue(new c(PageState.Empty, true, CollectionsKt.emptyList(), CollectionsKt.emptyList(), 1014));
        this.needUnbindPromptMac = null;
    }

    private final Object updateOnlyDeviceComponent(Continuation<? super Unit> r23) {
        if ((r23 instanceof C04811) == false) goto L7;
        C04811 r2 = (C04811) r23;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        ResultKt.throwOnFailure(r1);
    L49:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r1);
    L31:
        return Unit.INSTANCE;
    L17:
        String r6 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L25:
        String r12 = r6;
        DoraDevice r11 = (DoraDevice) r1;
        if (r11 != null) goto L33;
        r2.L$0 = null;
        r2.label = 2;
        if (updateDeviceStatusWithCurrentContent$default(this, false, r2, 1, null) != r4) goto L31;
        return r4;
    L33:
        if (Intrinsics.areEqual(this.currentDeviceMac, r12) == false) goto L35;
        r r7 = buildDeviceCardUiState(r11, true);
        c r9 = (c) this._uiState.getValue();
        Iterator<q> r8 = r9.f.iterator();
        int r10 = 0;
    L38:
        if (r8.hasNext() == false) goto L43;
        if (Intrinsics.areEqual(r8.next().a, r12) == true) goto L44;
        r10 = r10 + 1;
    L44:
        if (r10 >= 0) goto L50;
        r2.L$0 = null;
        r2.label = 3;
        if (updateDeviceStatusWithCurrentContent$default(this, false, r2, 1, null) != r4) goto L49;
        return r4;
    L50:
        List r14 = CollectionsKt.toMutableList(r9.f);
        q r13 = (q) ListProtector.get(r14, r10);
        String r15 = r13.a;
        DoraObricDeviceModeEntryProduct r16 = r13.c;
        h3 r17 = r13.d;
        Intrinsics.checkNotNullParameter(r15, "deviceMac");
        Intrinsics.checkNotNullParameter(r7, "card");
        Intrinsics.checkNotNullParameter(r16, "modeEntryProduct");
        Intrinsics.checkNotNullParameter(r17, "glassesMode");
        ListProtector.set(r14, r10, new q(r15, r7, r16, r17));
        this._uiState.setValue(c.a(r9, null, r11, r12, false, r14, 0, r7, false, false, null, null, 8025));
        return Unit.INSTANCE;
    L43:
        r10 = -1;
        goto L44
    L35:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r1);
        r6 = this.currentDeviceMac;
        if (r6 == null) goto L21;
        CoroutineDispatcher r18 = Dispatchers.getIO();
        DoraObricDeviceHomeViewModel$updateOnlyDeviceComponent$selectedDevice$1 r20 = new DoraObricDeviceHomeViewModel$updateOnlyDeviceComponent$selectedDevice$1(r6, null);
        r2.L$0 = r6;
        r2.label = 1;
        r1 = BuildersKt.withContext(r18, r20, r2);
        if (r1 != r4) goto L25;
        return r4;
    L21:
        return Unit.INSTANCE;
    L7:
        r2 = new C04811(this, r23);
        goto L8
    }

    public final void connectAsync(DoraDevice r9) {
        g49.d.d(TAG, "connectAsync device=" + r9);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04571(r9, this, null), 3, null);
    }

    public final Bundle createDeviceRouteArguments(DoraDevice r3) {
        Bundle r0 = new Bundle();
        appendDeviceParams(r0, r3);
        r0.putString(PARAM_PREVIOUS_PAGE, PREVIOUS_PAGE_DEVICE_HOME);
        return r0;
    }

    public final void handleConnectRequest(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.connectingDeviceMac = r10;
        Job r0 = this.connectingJob;
        if (r0 == null) goto L7;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L7:
        this.connectingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04601(this, r10, null), 3, null);
    }

    public final void initialize(Bundle r2) {
        this.arguments = r2;
        if (this.isHomeInitialized == false) goto L5;
        return;
    L5:
        this.isHomeInitialized = true;
        setInitialDeviceMac(resolveInitialDeviceMac(r2));
        load();
    }

    public final void onBindConflictActionStarted(DoraDevice r6) {
        Intrinsics.checkNotNullParameter(r6, "device");
        if (Intrinsics.areEqual(r6.mac, this.needUnbindPromptMac) == false) goto L5;
        this.needUnbindPromptMac = null;
    L5:
        this.bindCheckRequestId++;
        Job r7 = this.bindCheckJob;
        if (r7 == null) goto L8;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L8:
        g49.d.d(TAG, "onBindConflictActionStarted");
    }

    public final void onDeviceCardPageSelected(String r13) {
        Intrinsics.checkNotNullParameter(r13, "deviceMac");
        if (r13.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r13, this.currentDeviceMac) == true) goto L16;
        long r8 = this.deviceCardSelectionRequestId + 1;
        this.deviceCardSelectionRequestId = r8;
        Job r1 = this.deviceCardSelectionJob;
        if (r1 == null) goto L13;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L13:
        g49.d.d(TAG, "onDeviceCardPageSelected mac=" + r13 + " requestId=" + r8);
        this.deviceCardSelectionJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04661(this, r8, r13, null), 3, null);
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onEntryArgumentsChanged(Bundle r3) {
        this.arguments = r3;
        String r4 = resolveInitialDeviceMac(r3);
        if (r4 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, this.currentDeviceMac) == true) goto L10;
        g49.d.d(TAG, "onEntryArgumentsChanged select targetDeviceMac=" + r4 + " currentDeviceMac=" + this.currentDeviceMac);
        invalidateDeviceCardSelection();
        this.pendingEntryDeviceMac = r4;
        this.currentDeviceMac = r4;
        this.currentBatteryInfo = null;
        this.currentChargeInfo = null;
        load();
        return;
    }

    public final void onQuickActionClicked(DoraObricDeviceHomeQuickActionType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        g49.d.d(TAG, "onQuickActionClicked type=" + r5);
        int[] r0 = d.a;
        if (r0[r5.ordinal()] != 1) goto L5;
        DoraDevice r1 = null;
    L8:
        int r6 = r0[r5.ordinal()];
        if (r6 != 1) goto L11;
        emitRoute("//flow/chat_page", null);
        return;
    L11:
        if (r6 != 2) goto L13;
        emitRoute("//flow/dora/obric_earbuds_broadcast_setting", createDeviceRouteArguments(r1));
        return;
    L13:
        if (r6 != 3) goto L15;
        if (r1 == null) goto L25;
        openQuickNoteRecord(r1);
        return;
    L25:
        throw new IllegalArgumentException("Required value was null.".toString());
    L15:
        if (r6 != 4) goto L17;
        emitRoute("//flow/dora/o/simul_interpret_detail", createSimultaneousInterpretArguments(r1));
        return;
    L17:
        if (r6 != 5) goto L20;
        emitRoute("//flow/dora/record_minutes_list", createDeviceRouteArguments(r1));
        return;
    L20:
        throw new NoWhenBranchMatchedException();
    L5:
        r1 = requireConnectedDevice(r5);
        if (r1 != null) goto L8;
    }

    public final void onReconnectStarted(String r4) {
        Intrinsics.checkNotNullParameter(r4, "deviceMac");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        g49.d.d(TAG, "onReconnectStarted mac=" + r4);
        this.connectingDeviceMac = r4;
        refreshDeviceList$default(this, null, 1, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void onShutdownSucceeded(String r4) {
        Intrinsics.checkNotNullParameter(r4, "deviceMac");
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L9;
    L11:
        refreshDeviceList$default(this, null, 1, null);
        return;
    L9:
        if (Intrinsics.areEqual(this.connectingDeviceMac, r4) == false) goto L11;
        this.connectingDeviceMac = null;
        goto L11
    L5:
        r0 = false;
        goto L7
    }

    public final void refreshDeviceHomeDiaryData(boolean r13) {
        String r2 = resetDiaryDataForAccountChange();
        long r4 = this.diaryDataRequestId + 1;
        this.diaryDataRequestId = r4;
        Job r0 = this.diaryDataJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.diaryDataJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04691(this, r2, r13, r4, null), 3, null);
    }

    public final void replaceBind(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04711(r8, this, null), 2, null);
    }

    public final void setInitialDeviceMac(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        if (this.currentDeviceMac != null) goto L14;
        g49.d.d(TAG, "setInitialDeviceMac");
        this.pendingEntryDeviceMac = r3;
        this.currentDeviceMac = r3;
        return;
    L14:
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final void toggleEnvironmentMemory(String r13) {
        Intrinsics.checkNotNullParameter(r13, "deviceMac");
        Iterator<T> r0 = ((c) this._uiState.getValue()).f.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((q) r1).a, r13) == false) goto L4;
    L9:
        q r2 = (q) r1;
        if (r2 != null) goto L12;
        return;
    L12:
        IDoraPageConfig r3 = getDoraPageConfig();
        if (r3 == null) goto L15;
        boolean r4 = r3.d("dora_g_config_key_env_observe_auth_enable", false);
    L16:
        int r5 = g2.a;
        boolean r6 = r2.b.d;
        boolean r7 = a2.a(r2.c);
        Job r8 = this.environmentMemoryUpdateJob;
        if (r8 != null) goto L19;
    L21:
        boolean r9 = false;
    L22:
        if (r9 == false) goto L24;
    L27:
        boolean r10 = true;
    L28:
        h3 r11 = r2.d;
        DoraObricGlassesMode r12 = r11.d;
        DoraObricEnvironmentMemoryState r14 = r11.i;
        Boolean r15 = r11.j;
        boolean r16 = TimerJob.j.a().e(Calendar.getInstance());
        Intrinsics.checkNotNullParameter(r12, "mode");
        Intrinsics.checkNotNullParameter(r14, "state");
        if (r6 == false) goto L63;
        if (r7 == false) goto L63;
        if (r10 == true) goto L63;
        if (r15 == null) goto L63;
        if (r12 != DoraObricGlassesMode.HEADPHONE) goto L40;
        if (r14 != DoraObricEnvironmentMemoryState.UNAVAILABLE) goto L40;
        DoraObricEnvironmentMemoryClickAction r17 = DoraObricEnvironmentMemoryClickAction.NO_OP;
    L65:
        switch(d.b[r17.ordinal()]) {
            case 1: goto L77;
            case 2: goto L72;
            case 3: goto L71;
            case 4: goto L70;
            case 5: goto L69;
            case 6: goto L69;
            case 7: goto L68;
            default: goto L67;
        };
    L68:
        DoraEnvObserveManager.a.getClass();
        DoraEnvObserveManager.a(r13);
        refreshDeviceList$default(this, null, 1, null);
        emitEnvironmentMemoryToast(DoraObricEnvironmentMemoryToastType.TEMPORARY_OVERRIDE);
        return;
    L69:
        updateEnvironmentMemorySwitch(r13, true, r17);
        return;
    L70:
        updateEnvironmentMemorySwitch(r13, false, r17);
        return;
    L71:
        requestEnvironmentMemoryAuthorization(r13);
        return;
    L72:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04761(this, null), 3, null);
        return;
    L77:
        return;
    L67:
        throw new NoWhenBranchMatchedException();
    L40:
        if (r12 != DoraObricGlassesMode.ASSISTANT) goto L45;
        if (r14 != DoraObricEnvironmentMemoryState.UNAVAILABLE) goto L45;
        r17 = DoraObricEnvironmentMemoryClickAction.SHOW_UNAVAILABLE;
    L45:
        if (r14 != DoraObricEnvironmentMemoryState.WORKING) goto L51;
        if (r15.booleanValue() == false) goto L49;
        r17 = DoraObricEnvironmentMemoryClickAction.DISABLE_SWITCH;
        goto L65
    L49:
        r17 = DoraObricEnvironmentMemoryClickAction.NO_OP;
        goto L65
    L51:
        if (r14 == DoraObricEnvironmentMemoryState.OFF) goto L54;
        r17 = DoraObricEnvironmentMemoryClickAction.NO_OP;
        goto L65
    L54:
        if (r15.booleanValue() == true) goto L60;
        if (r4 == true) goto L57;
        r17 = DoraObricEnvironmentMemoryClickAction.REQUEST_AUTHORIZATION;
        goto L65
    L57:
        if (r16 == false) goto L59;
        r17 = DoraObricEnvironmentMemoryClickAction.ENABLE_SWITCH;
        goto L65
    L59:
        r17 = DoraObricEnvironmentMemoryClickAction.ENABLE_SWITCH_WITH_OVERRIDE;
        goto L65
    L60:
        if (r16 == false) goto L62;
        r17 = DoraObricEnvironmentMemoryClickAction.NO_OP;
        goto L65
    L62:
        r17 = DoraObricEnvironmentMemoryClickAction.ACTIVATE_OVERRIDE;
    L63:
        r17 = DoraObricEnvironmentMemoryClickAction.NO_OP;
        goto L65
    L24:
        if (isEnvironmentMemorySwitchCoolingDown() == true) goto L27;
        r10 = false;
        goto L28
    L19:
        if (r8.isActive() != true) goto L21;
        r9 = true;
        goto L22
    L15:
        r4 = false;
        goto L16
    L8:
        r1 = null;
        goto L9
    }

    public static final /* synthetic */ void access$emitEnvironmentMemoryToast(DoraObricDeviceHomeViewModel r0, DoraObricEnvironmentMemoryToastType r1) {
        r0.emitEnvironmentMemoryToast(r1);
    }

    public static final /* synthetic */ boolean access$isDiaryHomeStateUnchanged(DoraObricDeviceHomeViewModel r0, boolean r1) {
        return r0.isDiaryHomeStateUnchanged(r1);
    }

    public static final /* synthetic */ void access$moveDeviceToFront(DoraObricDeviceHomeViewModel r0, String r1) {
        r0.moveDeviceToFront(r1);
    }

    public static final /* synthetic */ void access$onDeviceConnected(DoraObricDeviceHomeViewModel r0, DoraDevice r1) {
        r0.onDeviceConnected(r1);
    }

    public static final /* synthetic */ void access$onDeviceDisconnected(DoraObricDeviceHomeViewModel r0, DoraDevice r1) {
        r0.onDeviceDisconnected(r1);
    }

    public static final /* synthetic */ boolean access$publishHomeStatusFromLatestDevices(DoraObricDeviceHomeViewModel r0, String r1) {
        return r0.publishHomeStatusFromLatestDevices(r1);
    }

    public static final /* synthetic */ void access$refreshDeviceList(DoraObricDeviceHomeViewModel r0, String r1) {
        r0.refreshDeviceList(r1);
    }

    public static final /* synthetic */ void access$setCurrentBatteryInfo$p(DoraObricDeviceHomeViewModel r0, int[] r1) {
        r0.currentBatteryInfo = r1;
    }

    public static final /* synthetic */ void access$setCurrentChargeInfo$p(DoraObricDeviceHomeViewModel r0, int[] r1) {
        r0.currentChargeInfo = r1;
    }

    public static final /* synthetic */ void access$setCurrentConfirmedGlassesMode$p(DoraObricDeviceHomeViewModel r0, int r1) {
        r0.currentConfirmedGlassesMode = r1;
    }

    public static final /* synthetic */ void access$setCurrentDeviceMac$p(DoraObricDeviceHomeViewModel r0, String r1) {
        r0.currentDeviceMac = r1;
    }

    public static final /* synthetic */ void access$setEnvironmentMemoryUpdateJob$p(DoraObricDeviceHomeViewModel r0, Job r1) {
        r0.environmentMemoryUpdateJob = r1;
    }

    public static final /* synthetic */ void access$setInitialHomeStatePending$p(DoraObricDeviceHomeViewModel r0, boolean r1) {
        r0.initialHomeStatePending = r1;
    }

    public static final /* synthetic */ void access$setLastKnownBindListSize$p(DoraObricDeviceHomeViewModel r0, int r1) {
        r0.lastKnownBindListSize = r1;
    }

    public static final /* synthetic */ void access$setLatestBoundDevices$p(DoraObricDeviceHomeViewModel r0, List r1) {
        r0.latestBoundDevices = r1;
    }

    public static final /* synthetic */ void access$setNeedUnbindPromptMac$p(DoraObricDeviceHomeViewModel r0, String r1) {
        r0.needUnbindPromptMac = r1;
    }

    public static final /* synthetic */ void access$setPendingEntryDeviceMac$p(DoraObricDeviceHomeViewModel r0, String r1) {
        r0.pendingEntryDeviceMac = r1;
    }

    public static final /* synthetic */ void access$setUsageEvidence$p(DoraObricDeviceHomeViewModel r0, s1 r1) {
        r0.usageEvidence = r1;
    }

    public static final /* synthetic */ List access$sortDeviceList(DoraObricDeviceHomeViewModel r0, List r1) {
        return r0.sortDeviceList(r1);
    }

    public static final /* synthetic */ void access$updateCachedBattery(DoraObricDeviceHomeViewModel r0, DoraDevice r1) {
        r0.updateCachedBattery(r1);
    }

    public static final /* synthetic */ void access$updateEmptyDeviceState(DoraObricDeviceHomeViewModel r0, String r1) {
        r0.updateEmptyDeviceState(r1);
    }

    public static final /* synthetic */ Object access$updateOnlyDeviceComponent(DoraObricDeviceHomeViewModel r0, Continuation r1) {
        return r0.updateOnlyDeviceComponent(r1);
    }

    private final void appendDeviceParams(Bundle r4, DoraDevice r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        String r0 = r5.mac;
        String r1 = "";
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        if (r0.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        r4.putString(PARAM_PRODUCT_MAC, r0);
    L13:
        r4.putInt("product_id", resolveRouteProductId(r5));
        String r3 = r5.model;
        if (r3 == null) goto L17;
        r1 = r3;
    L17:
        r4.putString(PARAM_PRODUCT_MODEL, r1);
        r4.putInt(PARAM_VENDOR_ID, r5.vendorId);
        return;
    L10:
        r2 = false;
        goto L11
    }

    private final List<q> buildDeviceCardItems(List<? extends DoraDevice> r62, String r63) {
        String r1 = r63;
        IDoraPageConfig r2 = getDoraPageConfig();
        if (r2 == null) goto L5;
        boolean r3 = r2.d("dora_g_config_key_env_observe_enable", false);
    L6:
        DoraDevice r4 = DoraAdapterExtKt.h(kj4.a.g());
        if (r4 == null) goto L9;
        String r5 = r4.mac;
    L10:
        String r6 = "";
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        if (Intrinsics.areEqual(r5, r1) == false) goto L18;
        DoraEnvObserveManager.a.getClass();
        if (DoraEnvObserveManager.h == false) goto L18;
        boolean r7 = true;
    L20:
        if (Intrinsics.areEqual(r5, r1) == false) goto L31;
        IDoraService r8 = getDoraService();
        if (r8 == null) goto L28;
        com.larus.dora.impl.serviceimpl.r r9 = r8.g1();
        if (r9 == null) goto L28;
        if (r9.c() != true) goto L28;
        boolean r10 = true;
    L29:
        if (r10 == false) goto L31;
        boolean r11 = true;
    L32:
        IDoraAVLinkService r12 = currentAvLinkService();
        if (r11 == false) goto L41;
        if (r12 != null) goto L36;
    L38:
        boolean r13 = false;
    L39:
        if (r13 == false) goto L41;
        boolean r14 = true;
    L42:
        Set r15 = SetsKt.createSetBuilder();
        if (r12 != null) goto L45;
    L47:
        boolean r16 = false;
    L48:
        if (r16 == false) goto L50;
        r15.add(DoraObricGlassesBusinessState.INTERPRETING);
    L50:
        if (r12 != null) goto L52;
    L54:
        boolean r17 = false;
    L55:
        if (r17 == false) goto L57;
        r15.add(DoraObricGlassesBusinessState.RECORDING);
    L57:
        if (r12 != null) goto L59;
    L61:
        boolean r18 = false;
    L62:
        if (r18 == false) goto L64;
        r15.add(DoraObricGlassesBusinessState.VIDEO_RECORDING);
    L64:
        if (r12 != null) goto L66;
    L68:
        boolean r20 = false;
    L69:
        if (r20 == false) goto L71;
        r15.add(DoraObricGlassesBusinessState.VIDEO_CALL);
    L71:
        Set r21 = SetsKt.build(r15);
        List<? extends DoraDevice> r110 = r62;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r112 = r110.iterator();
    L73:
        if (r112.hasNext() == false) goto L227;
        DoraDevice r113 = (DoraDevice) r112.next();
        boolean r114 = Intrinsics.areEqual(r113.mac, r1);
        r r22 = buildDeviceCardUiState(r113, r114);
        int r115 = c2.a;
        DoraObricDeviceModeEntryProduct r23 = c2.a(Integer.valueOf(r113.productId), Integer.valueOf(r113.type));
        if (a2.a(r23) == false) goto L222;
        int r24 = com.larus.dora.obric.device_management.device_home.g.a;
        boolean r25 = r22.d;
        int r116 = r113.headphoneModeState;
        int r26 = this.currentConfirmedGlassesMode;
        Boolean r117 = Boolean.valueOf(r3);
        Intrinsics.checkNotNullParameter(r21, "activeScenes");
        if (r114 == false) goto L99;
        if (r25 == false) goto L99;
        Integer r27 = Integer.valueOf(r26);
        int r28 = r27.intValue();
        if (r28 >= 0) goto L82;
    L84:
        boolean r30 = false;
    L85:
        if (r30 == false) goto L87;
        Integer r31 = r27;
    L88:
        if (r31 != null) goto L107;
        r31 = Integer.valueOf(r116);
        int r32 = r31.intValue();
        if (r32 >= 0) goto L92;
    L94:
        boolean r33 = false;
    L95:
        if (r33 == true) goto L107;
    L106:
        r31 = null;
        goto L107
    L92:
        if (r32 >= 2) goto L94;
        r33 = true;
    L107:
        if (r31 == null) goto L109;
        int r34 = r31.intValue();
    L110:
        if (r114 == false) goto L114;
        if (r14 == false) goto L113;
        DoraObricEnvironmentMemory r35 = DoraObricEnvironmentMemory.ENABLED;
    L115:
        if (r114 == false) goto L117;
        Boolean r210 = r117;
    L118:
        if (r114 == false) goto L121;
        if (r11 == false) goto L121;
        boolean r211 = true;
    L122:
        if (r114 == false) goto L124;
        boolean r212 = r7;
    L125:
        if (r114 == false) goto L127;
        Set r118 = r21;
    L128:
        Intrinsics.checkNotNullParameter(r35, "environmentMemory");
        Intrinsics.checkNotNullParameter(r118, "activeScenes");
        int r119 = d2.a;
        boolean r120 = r3;
        boolean r36 = r22.d;
        boolean r213 = r113.isSupportGlassesModeControl();
        boolean r37 = r11;
        Intrinsics.checkNotNullParameter(r23, "product");
        Intrinsics.checkNotNullParameter(r35, "environmentMemory");
        Intrinsics.checkNotNullParameter(r118, "activeScenes");
        if (r34 != 0) goto L131;
        DoraObricGlassesMode r0 = DoraObricGlassesMode.ASSISTANT;
    L135:
        int r38 = s2.a;
        boolean r121 = a2.a(r23);
        DoraObricGlassesMode r40 = DoraObricGlassesMode.UNKNOWN;
        if (r0 == r40) goto L138;
        boolean r214 = true;
    L139:
        g3 r41 = new g3(r121, r36, r214, r213, r0, r35, r210, r211, r212, r118, 1024);
        Intrinsics.checkNotNullParameter(r41, "source");
        if (r41.a == true) goto L143;
        h3 r42 = new h3(false, false, false, null, false, false, false, null, null, null, false, null, null, 8191);
    L163:
        r7 = r7;
    L223:
        String r43 = r113.mac;
        if (r43 != null) goto L226;
        r43 = r6;
    L226:
        r111.add(new q(r43, r22, r23, r42));
        r1 = r63;
        r3 = r120;
        r6 = r6;
        r7 = r7;
        r11 = r37;
        goto L73
    L143:
        if (r41.b == true) goto L164;
        DoraObricGlassesMode r44 = r41.e;
        if (r44 != r40) goto L147;
        boolean r45 = true;
    L148:
        if (r45 == false) goto L151;
        r44 = null;
    L151:
        if (r44 != null) goto L153;
        r44 = DoraObricGlassesMode.ASSISTANT;
    L153:
        DoraObricGlassesMode r310 = r44;
        boolean r46 = r41.d;
        DoraObricEnvironmentMemory r47 = r41.f;
        if (r47 != DoraObricEnvironmentMemory.UNKNOWN) goto L156;
        boolean r48 = true;
    L157:
        if (r48 == false) goto L160;
        r47 = null;
    L160:
        if (r47 != null) goto L162;
        r47 = DoraObricEnvironmentMemory.DISABLED;
    L162:
        r42 = new h3(true, true, true, r310, r46, false, true, r47, DoraObricEnvironmentMemoryState.OFF, null, false, null, null, 6688);
        goto L163
    L156:
        r48 = false;
        goto L157
    L147:
        r45 = false;
        goto L148
    L164:
        DoraObricGlassesMode r50 = r41.e;
        if (r41.c == true) goto L168;
        r50 = null;
    L168:
        if (r50 != null) goto L171;
        r50 = r40;
    L171:
        if (r50 != DoraObricGlassesMode.ASSISTANT) goto L173;
        boolean r51 = true;
    L174:
        if (r50 != r40) goto L177;
        DoraObricEnvironmentMemoryState r52 = DoraObricEnvironmentMemoryState.UNKNOWN;
    L179:
        DoraObricEnvironmentMemoryState r410 = r52;
    L195:
        boolean r122 = r41.d;
        if (r41.c == false) goto L200;
        if (r122 == false) goto L200;
        if (r50 == r40) goto L200;
        boolean r311 = true;
    L201:
        if (r50 == r40) goto L203;
        boolean r312 = true;
    L204:
        DoraObricEnvironmentMemory r53 = r41.f;
        Boolean r123 = r41.g;
        boolean r54 = r41.h;
        if (r51 == false) goto L220;
        Set<DoraObricGlassesBusinessState> r55 = r41.j;
        DoraObricGlassesBusinessState r56 = DoraObricGlassesBusinessState.RECORDING;
        if (r55.contains(r56) == true) goto L219;
        r56 = DoraObricGlassesBusinessState.INTERPRETING;
        if (r55.contains(r56) == true) goto L219;
        r56 = DoraObricGlassesBusinessState.VIDEO_RECORDING;
        if (r55.contains(r56) == true) goto L219;
        r56 = DoraObricGlassesBusinessState.VIDEO_CALL;
        if (r55.contains(r56) == true) goto L219;
        r56 = DoraObricGlassesBusinessState.IDLE;
    L219:
        DoraObricGlassesBusinessState r411 = r56;
    L221:
        r42 = new h3(true, true, false, r50, r122, r311, r312, r53, r410, r123, r54, r411, r41.k, 4);
        goto L223
    L220:
        r411 = DoraObricGlassesBusinessState.IDLE;
        goto L221
    L203:
        r312 = false;
    L200:
        r311 = false;
        goto L201
    L177:
        if (r50 != DoraObricGlassesMode.HEADPHONE) goto L181;
        r52 = DoraObricEnvironmentMemoryState.UNAVAILABLE;
        goto L179
    L181:
        if ((!r41.j.isEmpty()) == false) goto L183;
        DoraObricEnvironmentMemoryState r57 = DoraObricEnvironmentMemoryState.UNAVAILABLE;
    L194:
        r410 = r57;
        goto L195
    L183:
        boolean r58 = r41.h;
        if (r58 == true) goto L187;
        r57 = DoraObricEnvironmentMemoryState.OFF;
        goto L194
    L187:
        if (r41.i == true) goto L189;
        r57 = DoraObricEnvironmentMemoryState.UNAVAILABLE;
        goto L194
    L189:
        if (r58 == true) goto L191;
    L193:
        r57 = DoraObricEnvironmentMemoryState.OFF;
        goto L194
    L191:
        if (r41.f != DoraObricEnvironmentMemory.ENABLED) goto L193;
        r57 = DoraObricEnvironmentMemoryState.WORKING;
        goto L194
    L173:
        r51 = false;
        goto L174
    L138:
        r214 = false;
        goto L139
    L131:
        if (r34 == 1) goto L133;
        r0 = DoraObricGlassesMode.UNKNOWN;
        goto L135
    L133:
        r0 = DoraObricGlassesMode.HEADPHONE;
        goto L135
    L127:
        r118 = SetsKt.emptySet();
        goto L128
    L124:
        r212 = true;
    L121:
        r211 = false;
        goto L122
    L117:
        r210 = null;
        goto L118
    L113:
        r35 = DoraObricEnvironmentMemory.DISABLED;
        goto L115
    L114:
        r35 = DoraObricEnvironmentMemory.UNKNOWN;
        goto L115
    L109:
        r34 = -1;
        goto L110
    L87:
        r31 = null;
        goto L88
    L82:
        if (r28 >= 2) goto L84;
        r30 = true;
    L99:
        r31 = Integer.valueOf(r116);
        int r60 = r31.intValue();
        if (r60 < 0) goto L103;
        if (r60 >= 2) goto L103;
        boolean r61 = true;
    L104:
        if (r61 == false) goto L106;
    L103:
        r61 = false;
        goto L104
    L222:
        r120 = r3;
        r37 = r11;
        r7 = r7;
        r42 = new h3(false, false, false, null, false, false, false, null, null, null, false, null, null, 8191);
        goto L223
    L227:
        return r111;
    L66:
        if (r12.c1(1) != true) goto L68;
        r20 = true;
        goto L69
    L59:
        if (r12.c1(3) != true) goto L61;
        r18 = true;
        goto L62
    L52:
        if (r12.c1(7) != true) goto L54;
        r17 = true;
        goto L55
    L45:
        if (r12.c1(6) != true) goto L47;
        r16 = true;
        goto L48
    L36:
        if (r12.c1(2) != true) goto L38;
        r13 = true;
    L41:
        r14 = false;
    L28:
        r10 = false;
    L31:
        r11 = false;
    L18:
        r7 = false;
        goto L20
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private final r buildDeviceCardUiState(DoraDevice r27, boolean r28) {
        boolean r5 = false;
        if (kj4.a.g().getDoraLinkState(r27) != 2) goto L5;
        boolean r11 = true;
    L6:
        Map<String, int[]> r3 = this.chargeInfoByDeviceMac;
        String r7 = r27.mac;
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        int[] r4 = r3.get(r7);
        Map<String, int[]> r8 = this.batteryInfoByDeviceMac;
        String r9 = r27.mac;
        if (r9 != null) goto L12;
        r9 = "";
    L12:
        int[] r10 = r8.get(r9);
        if (r11 == false) goto L22;
        if (r28 == false) goto L20;
        int[] r12 = this.currentBatteryInfo;
        if (r12 != null) goto L19;
        if (r10 != null) goto L23;
        r10 = o59.a.a(r27);
    L23:
        if (r11 == false) goto L32;
        if (r28 == false) goto L30;
        int[] r13 = this.currentChargeInfo;
        if (r13 != null) goto L29;
        if (r4 != null) goto L34;
        r4 = o59.a.b(r27);
    L34:
        if (shouldUseEarbudsCard(r27) == false) goto L36;
        DoraObricDeviceHomeDeviceCardType r14 = DoraObricDeviceHomeDeviceCardType.EARBUDS;
    L38:
        if (t.a(r27) == false) goto L40;
        DeviceMode r15 = resolveDeviceMode();
    L41:
        b r16 = getDeviceCardImage(r27, r14, r11, r28);
        String r17 = o59.a.d(r27);
        if (r17.length() != 0) goto L44;
        boolean r18 = true;
    L45:
        if (r18 == false) goto L47;
        r17 = DEFAULT_DEVICE_NAME;
    L47:
        int r110 = com.larus.utils.j0.a;
        if (r11 == false) goto L51;
        int r111 = 2131902454;
    L54:
        String r112 = com.larus.utils.j0.d(r111);
        if (r11 == false) goto L57;
    L59:
        boolean r1 = false;
    L60:
        int r20 = r16.a;
        String r6 = r16.d;
        String r21 = r16.e;
        DoraResourceDeviceType r113 = r16.f;
        if (r28 == false) goto L66;
        if (r11 == false) goto L66;
        if (r15 == DeviceMode.NORMAL) goto L66;
        String r2 = r15.getModeName();
    L67:
        if (r10 == null) goto L69;
        Integer r22 = ArraysKt.getOrNull(r10, 0);
    L70:
        String r114 = com.larus.dora.impl.device.manage.r0.b(r22);
        if (r4 == null) goto L78;
        Integer r23 = ArraysKt.getOrNull(r4, 0);
        if (r23 == null) goto L78;
        if (r23.intValue() != 1) goto L78;
        boolean r24 = true;
    L79:
        if (r10 == null) goto L81;
        Integer r25 = ArraysKt.getOrNull(r10, 0);
    L82:
        String r26 = com.larus.dora.impl.device.manage.r0.b(r25);
        if (r4 == null) goto L90;
        Integer r30 = ArraysKt.getOrNull(r4, 0);
        if (r30 == null) goto L90;
        int r115 = 1;
        if (r30.intValue() != 1) goto L91;
        boolean r210 = true;
    L92:
        if (r10 == null) goto L94;
        Integer r31 = ArraysKt.getOrNull(r10, r115);
    L95:
        String r211 = com.larus.dora.impl.device.manage.r0.b(r31);
        if (r4 == null) goto L103;
        Integer r32 = ArraysKt.getOrNull(r4, r115);
        if (r32 == null) goto L103;
        if (r32.intValue() != r115) goto L103;
        boolean r212 = true;
    L104:
        if (r10 == null) goto L106;
        int r33 = 2;
        Integer r116 = ArraysKt.getOrNull(r10, 2);
    L107:
        String r213 = com.larus.dora.impl.device.manage.r0.b(r116);
        if (r4 == null) goto L116;
        Integer r34 = ArraysKt.getOrNull(r4, r33);
        if (r34 == null) goto L116;
        if (r34.intValue() != 1) goto L116;
        r5 = true;
    L116:
        return new r(r14, r17, r112, r11, r1, r20, r6, r21, r113, r2, r114, r24, r26, r210, r211, r212, r213, r5);
    L106:
        r33 = 2;
        r116 = null;
    L103:
        r212 = false;
        goto L104
    L94:
        r31 = null;
    L91:
        r210 = false;
    L90:
        r115 = 1;
        goto L91
    L81:
        r25 = null;
    L78:
        r24 = false;
        goto L79
    L69:
        r22 = null;
    L66:
        r2 = "";
        goto L67
    L57:
        if (Intrinsics.areEqual(r27.mac, this.connectingDeviceMac) == false) goto L59;
        r1 = true;
        goto L60
    L51:
        if (Intrinsics.areEqual(r27.mac, this.connectingDeviceMac) == false) goto L53;
        r111 = 2131902420;
        goto L54
    L53:
        r111 = 2131902456;
        goto L54
    L44:
        r18 = false;
        goto L45
    L40:
        r15 = DeviceMode.NORMAL;
        goto L41
    L36:
        r14 = DoraObricDeviceHomeDeviceCardType.GLASSES;
        goto L38
    L29:
        r4 = r13;
        goto L34
    L30:
        if (r4 != null) goto L34;
        r4 = o59.a.b(r27);
        goto L34
    L32:
        r4 = null;
        goto L34
    L19:
        r10 = r12;
        goto L23
    L20:
        if (r10 != null) goto L23;
        r10 = o59.a.a(r27);
        goto L23
    L22:
        r10 = null;
        goto L23
    L5:
        r11 = false;
        goto L6
    }

    private final List<m1> buildQuickActions(u r16, DoraDevice r17) {
        int r1 = com.larus.utils.l0.a;
        DoraObricDeviceHomeQuickActionConfig r2 = (DoraObricDeviceHomeQuickActionConfig) com.larus.utils.l0.a(new DoraObricDeviceHomeQuickActionConfig(null, 1, null), new p1());
        g49.d.d(TAG, "Build quick actions settings: " + CollectionsKt.joinToString$default(r2.getActions(), null, null, null, 0, null, new t1(), 31, null));
        List<m1> r4 = QUICK_ACTION_DISPLAY_ORDER;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
        int r8 = 0;
    L4:
        if (r6.hasNext() == false) goto L9;
        Object r9 = r6.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        m1 r11 = (m1) r9;
        r5.add(TuplesKt.to(r11, Integer.valueOf(r2.resolveOrder(r11.getType().getConfigKey(), r8))));
        r8 = r10;
        goto L4
    L9:
        ArrayList r7 = new ArrayList();
        Iterator r12 = r5.iterator();
    L11:
        if (r12.hasNext() == false) goto L31;
        Object r13 = r12.next();
        m1 r14 = (m1) ((Pair) r13).component1();
        Iterator<T> r15 = r2.getActions().iterator();
    L14:
        if (r15.hasNext() == false) goto L18;
        Object r18 = r15.next();
        if (Intrinsics.areEqual(((DoraObricDeviceHomeQuickActionConfigItem) r18).getKey(), r14.getType().getConfigKey()) == false) goto L14;
    L19:
        DoraObricDeviceHomeQuickActionConfigItem r110 = (DoraObricDeviceHomeQuickActionConfigItem) r18;
        if (r110 == null) goto L22;
        Boolean r111 = Boolean.valueOf(r110.getEnabled());
    L23:
        if (r111 == null) goto L26;
        boolean r20 = r111.booleanValue();
    L29:
        if (r20 == false) goto L11;
        r7.add(r13);
        goto L11
    L26:
        if (r14.getType() == DoraObricDeviceHomeQuickActionType.NOTIFICATION_BROADCAST) goto L28;
        r20 = true;
        goto L29
    L28:
        r20 = false;
        goto L29
    L22:
        r111 = null;
        goto L23
    L18:
        r18 = null;
        goto L19
    L31:
        ArrayList r3 = new ArrayList();
        Iterator r21 = r7.iterator();
    L33:
        if (r21.hasNext() == false) goto L57;
        Object r22 = r21.next();
        DoraObricDeviceHomeQuickActionType r23 = ((m1) ((Pair) r22).component1()).getType();
        Set<Integer> r24 = t.a;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r23, "actionType");
        int r25 = t.a.a[r23.ordinal()];
        if (r25 != 1) goto L37;
    L54:
        boolean r26 = r16.a;
    L55:
        if (r26 == false) goto L33;
        r3.add(r22);
        goto L33
    L37:
        if (r25 == 2) goto L54;
        if (r25 == 3) goto L48;
        if (r25 == 4) goto L48;
        if (r25 != 5) goto L46;
        r26 = r16.b;
        goto L55
    L46:
        throw new NoWhenBranchMatchedException();
    L48:
        if (r16.a == false) goto L50;
    L53:
        r26 = true;
        goto L55
    L50:
        if (r16.b == true) goto L53;
        r26 = false;
        goto L55
    L57:
        List r0 = CollectionsKt.sortedWith(r3, new f());
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r28 = r0.iterator();
    L59:
        if (r28.hasNext() == false) goto L61;
        r27.add((m1) ((Pair) r28.next()).component1());
        goto L59
    L61:
        DoraResourceDeviceType r30 = toGlassesResourceDeviceType(r17);
        ArrayList r31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r32 = r27.iterator();
    L63:
        if (r32.hasNext() == false) goto L68;
        m1 r33 = (m1) r32.next();
        if (r33.getType() != DoraObricDeviceHomeQuickActionType.DOUBAO_ASSISTANT) goto L67;
        DoraObricDeviceHomeQuickActionType r34 = r33.a;
        String r35 = r33.b;
        int r112 = r33.c;
        String r113 = r33.d;
        Intrinsics.checkNotNullParameter(r34, "type");
        Intrinsics.checkNotNullParameter(r35, "title");
        r33 = new m1(r34, r35, r112, r113, r30);
    L67:
        r31.add(r33);
        goto L63
    L68:
        return r31;
    }

    private final void cacheConnectedDeviceSnapshotIfNeeded(DoraDevice r7, String r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r7, r8, null), 2, null);
    }

    private final void emitRoute(String r7, Bundle r8) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04591(this, r7, r8, null), 3, null);
    }

    private final Object handleEarbudsConnectRequest(DoraDevice r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof C04621) == false) goto L7;
        C04621 r2 = (C04621) r14;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r15 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L24;
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L19;
        if (r5 == 3) goto L18;
        if (r5 != 4) goto L17;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L44
    L51:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L44
    L38:
        onConnectRequestFailed();     // Catch: Throwable -> L44
        goto L51
    L19:
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L44
    L42:
        onConnectRequestFailed();     // Catch: Throwable -> L44
        goto L51
    L21:
        r13 = (DoraDevice) r2.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L44
    L28:
        BindAndConnectResult r16 = (BindAndConnectResult) r15;     // Catch: Throwable -> L44
        switch(d.c[r16.ordinal()]) {
            case 1: goto L46;
            case 2: goto L46;
            case 3: goto L43;
            case 4: goto L39;
            case 5: goto L35;
            case 6: goto L35;
            case 7: goto L32;
            default: goto L48;
        };
    L32:
        g49.d.d(TAG, "handleEarbudsConnectRequest success");     // Catch: Throwable -> L44
        r2.L$0 = null;     // Catch: Throwable -> L44
        r2.label = 4;     // Catch: Throwable -> L44
        if (updateDeviceStatusWithCurrentContent$default(this, false, r2, 1, null) != r4) goto L51;
        return r4;
    L35:
        g49.d.d(TAG, "handleEarbudsConnectRequest connect failed result=" + r16);     // Catch: Throwable -> L44
        MutableSharedFlow<com.larus.dora.obric.device_management.device_home.a> r17 = this._deviceIntentSharedFlow;     // Catch: Throwable -> L44
        com.larus.dora.obric.device_management.device_home.a.b r0 = new com.larus.dora.obric.device_management.device_home.a.b(r13);     // Catch: Throwable -> L44
        r2.L$0 = null;     // Catch: Throwable -> L44
        r2.label = 3;     // Catch: Throwable -> L44
        if (r17.emit(r0, r2) != r4) goto L38;
        return r4;
    L39:
        g49.d.d(TAG, "handleEarbudsConnectRequest need unbind");     // Catch: Throwable -> L44
        r2.L$0 = null;     // Catch: Throwable -> L44
        r2.label = 2;     // Catch: Throwable -> L44
        if (emitNeedUnbindIfCurrent(r13, "earbuds_connect", true, r2) != r4) goto L42;
        return r4;
    L43:
        g49.d.d(TAG, "handleEarbudsConnectRequest bind failed result=" + r16);     // Catch: Throwable -> L44
        t19.s r18 = t19.s.a;     // Catch: Throwable -> L44
        Companion.getClass();     // Catch: Throwable -> L44
        Application r110 = a.a();     // Catch: Throwable -> L44
        r18.getClass();     // Catch: Throwable -> L44
        t19.s.b(r110, 2131904024, false);     // Catch: Throwable -> L44
        onConnectRequestFailed();     // Catch: Throwable -> L44
        goto L51
    L46:
        g49.d.d(TAG, "handleEarbudsConnectRequest bind failed result=" + r16);     // Catch: Throwable -> L44
        t19.s r111 = t19.s.a;     // Catch: Throwable -> L44
        Companion.getClass();     // Catch: Throwable -> L44
        Application r112 = a.a();     // Catch: Throwable -> L44
        r111.getClass();     // Catch: Throwable -> L44
        t19.s.b(r112, 2131908080, false);     // Catch: Throwable -> L44
        onConnectRequestFailed();     // Catch: Throwable -> L44
        goto L51
    L48:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L44
    L24:
        ResultKt.throwOnFailure(r15);
        g49.d.d(TAG, "handleEarbudsConnectRequest device=" + o59.a.h(r13));     // Catch: Throwable -> L44
        CoroutineDispatcher r113 = Dispatchers.getIO();     // Catch: Throwable -> L44
        DoraObricDeviceHomeViewModel$handleEarbudsConnectRequest$result$1 r1 = new DoraObricDeviceHomeViewModel$handleEarbudsConnectRequest$result$1(r13, null);     // Catch: Throwable -> L44
        r2.L$0 = r13;     // Catch: Throwable -> L44
        r2.label = 1;     // Catch: Throwable -> L44
        r15 = BuildersKt.withContext(r113, r1, r2);     // Catch: Throwable -> L44
        if (r15 != r4) goto L28;
        return r4;
    L44:
        th = move-exception;
        g49.d.c(TAG, "handleEarbudsConnectRequest failed", th);
        t19.s r114 = t19.s.a;
        Companion.getClass();
        Application r115 = a.a();
        r114.getClass();
        t19.s.b(r115, 2131903672, false);
        onConnectRequestFailed();
    L7:
        r2 = new C04621(this, r14);
        goto L8
    }

    private final Object handleGConnectRequest(DoraDevice r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof C04631) == false) goto L7;
        C04631 r0 = (C04631) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L25;
        if (r3 == 1) goto L22;
        if (r3 == 2) goto L19;
        if (r3 == 3) goto L17;
        if (r3 == 4) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L44
    L50:
        return Unit.INSTANCE;
    L19:
        r11 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L44
    L40:
        r0.L$0 = null;     // Catch: Throwable -> L44
        r0.label = 3;     // Catch: Throwable -> L44
        if (onlyConnect(r11, r0) != r2) goto L50;
        return r2;
    L22:
        r11 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L44
    L29:
        OnlyBindResult r14 = (OnlyBindResult) r13;     // Catch: Throwable -> L44
        int r4 = d.f[r14.ordinal()];     // Catch: Throwable -> L44
        if (r4 == 1) goto L46;
        if (r4 == 2) goto L46;
        if (r4 == 3) goto L43;
        if (r4 == 4) goto L37;
        r0.L$0 = null;     // Catch: Throwable -> L44
        r0.label = 4;     // Catch: Throwable -> L44
        if (handleDeviceNeedingUnbind(r11, r14, r0) != r2) goto L50;
        return r2;
    L37:
        r0.L$0 = r11;     // Catch: Throwable -> L44
        r0.label = 2;     // Catch: Throwable -> L44
        if (updateDeviceStatusWithCurrentContent$default(this, false, r0, 1, null) != r2) goto L40;
        return r2;
    L43:
        t19.s r15 = t19.s.a;     // Catch: Throwable -> L44
        Companion.getClass();     // Catch: Throwable -> L44
        Application r5 = a.a();     // Catch: Throwable -> L44
        String r16 = a.a().getString(2131903938, new Object[]{o59.a.g(r11)});     // Catch: Throwable -> L44
        r15.getClass();     // Catch: Throwable -> L44
        t19.s.c(r5, r16);     // Catch: Throwable -> L44
        onConnectRequestFailed();     // Catch: Throwable -> L44
    L46:
        t19.s r17 = t19.s.a;     // Catch: Throwable -> L44
        Companion.getClass();     // Catch: Throwable -> L44
        Application r18 = a.a();     // Catch: Throwable -> L44
        r17.getClass();     // Catch: Throwable -> L44
        t19.s.b(r18, 2131908080, false);     // Catch: Throwable -> L44
        onConnectRequestFailed();     // Catch: Throwable -> L44
        goto L50
    L25:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r110 = Dispatchers.getIO();     // Catch: Throwable -> L44
        DoraObricDeviceHomeViewModel$handleGConnectRequest$bindResult$1 r6 = new DoraObricDeviceHomeViewModel$handleGConnectRequest$bindResult$1(r11, null);     // Catch: Throwable -> L44
        r0.L$0 = r11;     // Catch: Throwable -> L44
        r0.label = 1;     // Catch: Throwable -> L44
        r13 = BuildersKt.withContext(r110, r6, r0);     // Catch: Throwable -> L44
        if (r13 != r2) goto L29;
        return r2;
    L44:
        th = move-exception;
        g49.d.c(TAG, "handleGConnectRequest failed", th);
        t19.s r111 = t19.s.a;
        Companion.getClass();
        Application r112 = a.a();
        r111.getClass();
        t19.s.b(r112, 2131902626, false);
        onConnectRequestFailed();
    L7:
        r0 = new C04631(this, r12);
        goto L8
    }

    private final String normalizeDeviceCardImageSku(String r2, String r3) {
        if (Intrinsics.areEqual(r2, PRODUCT_CODE_LITE) == true) goto L6;
        return r3;
    L6:
        switch(r3.hashCode()) {
            case -245710322: goto L21;
            case -226427336: goto L17;
            case 1382553485: goto L13;
            case 1457185502: goto L9;
            default: goto L28;
        };
    L28:
        return r3;
    L9:
        if (r3.equals("round_silver") == false) goto L29;
        return "silver";
    L29:
        return r3;
    L13:
        if (r3.equals("round_purple") == false) goto L30;
        return "purple";
    L30:
        return r3;
    L17:
        if (r3.equals("round_white") == false) goto L31;
        return "white";
    L31:
        return r3;
    L21:
        if (r3.equals("round_black") == false) goto L32;
        return "black";
    L32:
        return r3;
    }

    private final b resolveDeviceCardImage(DoraDevice r2, DoraObricDeviceHomeDeviceCardType r3) {
        int r4 = d.e[r3.ordinal()];
        if (r4 == 1) goto L10;
        if (r4 != 2) goto L8;
        return resolveProductSkuCardImage(r2);
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return resolveGlassesCardImage(r2);
    }

    private final DoraDevice selectDevice(List<? extends DoraDevice> r7, boolean r8) {
        DoraDevice r9 = DoraAdapterExtKt.i(kj4.a.g(), false);
        if (r9 == null) goto L17;
        List<? extends DoraDevice> r3 = r7;
        if ((r3 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(((DoraDevice) r4.next()).mac, r9.mac) == false) goto L11;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
    L28:
        String r0 = this.pendingEntryDeviceMac;
        if (r0 == null) goto L38;
        Iterator<T> r1 = r7.iterator();
    L32:
        if (r1.hasNext() == false) goto L36;
        Object r6 = r1.next();
        if (Intrinsics.areEqual(((DoraDevice) r6).mac, r0) == false) goto L32;
    L37:
        DoraDevice r10 = (DoraDevice) r6;
    L39:
        if (r10 == null) goto L41;
        r9 = r10;
    L53:
        if (r10 == null) goto L55;
        this.pendingEntryDeviceMac = null;
    L55:
        if (r9 == null) goto L57;
        String r11 = r9.mac;
    L59:
        if (Intrinsics.areEqual(r11, this.currentDeviceMac) == true) goto L61;
        this.currentBatteryInfo = null;
        this.currentChargeInfo = null;
    L61:
        return r9;
    L57:
        r11 = null;
        goto L59
    L41:
        if (this.currentDeviceMac == null) goto L50;
        Iterator<T> r12 = r7.iterator();
    L44:
        if (r12.hasNext() == false) goto L48;
        Object r2 = r12.next();
        if (Intrinsics.areEqual(((DoraDevice) r2).mac, this.currentDeviceMac) == false) goto L44;
    L49:
        r9 = (DoraDevice) r2;
        goto L50
    L48:
        r2 = null;
    L50:
        if (r9 != null) goto L53;
        r9 = (DoraDevice) CollectionsKt.firstOrNull(r7);
        goto L53
    L36:
        r6 = null;
        goto L37
    L38:
        r10 = null;
    L8:
        r5 = false;
        goto L15
    L7:
        if (r3.isEmpty() == false) goto L9;
    L17:
        Iterator<T> r13 = r7.iterator();
    L19:
        if (r13.hasNext() == false) goto L26;
        Object r14 = r13.next();
        if (kj4.a.g().getDoraLinkState((DoraDevice) r14) != 2) goto L23;
        boolean r15 = true;
    L24:
        if (r15 == false) goto L19;
    L27:
        r9 = (DoraDevice) r14;
        goto L28
    L23:
        r15 = false;
        goto L24
    L26:
        r14 = null;
        goto L27
    }

    private final void showConnectionRequired(DoraDevice r9, String r10) {
        StringBuilder r0 = new StringBuilder("showConnectionRequired featureName=");
        r0.append(r10);
        r0.append(" hasReconnectDevice=");
        if (r9 == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        g49.d.d(TAG, r0.toString());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04741(this, r9, r10, null), 3, null);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private final boolean supportsQuickAction(DoraDevice r3, DoraObricDeviceHomeQuickActionType r4) {
        int r5 = d.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        return true;
    L5:
        if (r5 == 2) goto L22;
        if (r5 == 3) goto L16;
        if (r5 == 4) goto L16;
        if (r5 != 5) goto L14;
        return t.a(r3);
    L14:
        throw new NoWhenBranchMatchedException();
    L16:
        if (t.a(r3) == false) goto L18;
        return true;
    L18:
        if (t.b(r3) == true) goto L27;
        return false;
    L27:
        return true;
    L22:
        return t.b(r3);
    }

    private final void syncBatterySnapshot(DoraDevice r6, String r7) {
        DoraDevice r0 = DoraAdapterExtKt.i(kj4.a.g(), false);
        String r1 = null;
        if (r0 != null) goto L5;
    L9:
        r0 = r6;
    L10:
        updateBatteryCache(r6, o59.a.a(r0));
        Map<String, int[]> r2 = this.batteryInfoByDeviceMac;
        String r3 = r6.mac;
        String r4 = "";
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        int[] r5 = r2.get(r3);
        if (r5 == null) goto L17;
        int[] r8 = Arrays.copyOf(r5, r5.length);
        if (r8 == null) goto L17;
    L18:
        this.currentBatteryInfo = r8;
        Map<String, int[]> r9 = this.chargeInfoByDeviceMac;
        String r10 = r6.mac;
        if (r10 == null) goto L22;
        r4 = r10;
    L22:
        int[] r11 = r9.get(r4);
        if (r11 == null) goto L26;
        int[] r12 = Arrays.copyOf(r11, r11.length);
        if (r12 == null) goto L26;
    L27:
        this.currentChargeInfo = r12;
        StringBuilder r13 = new StringBuilder("syncBatterySnapshot source=");
        r13.append(r7);
        r13.append(" battery=");
        int[] r14 = this.currentBatteryInfo;
        if (r14 == null) goto L30;
        String r15 = Arrays.toString(r14);
    L31:
        r13.append(r15);
        r13.append(" charge=");
        int[] r16 = this.currentChargeInfo;
        if (r16 == null) goto L34;
        r1 = Arrays.toString(r16);
    L34:
        r13.append(r1);
        g49.d.d(TAG, r13.toString());
        return;
    L30:
        r15 = null;
    L26:
        int[] r17 = o59.a.b(r0);
        r12 = Arrays.copyOf(r17, r17.length);
    L17:
        int[] r18 = o59.a.a(r0);
        r8 = Arrays.copyOf(r18, r18.length);
        goto L18
    L5:
        if (Intrinsics.areEqual(r0.mac, r6.mac) == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        goto L9
    }

    private final Object syncDeviceOrder(List<? extends DoraDevice> r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof C04751) == false) goto L7;
        C04751 r0 = (C04751) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L19:
        List<String> r4 = this.deviceOrder;
        ArrayList r5 = new ArrayList();
        Iterator r12 = ((List) r11).iterator();
    L21:
        if (r12.hasNext() == false) goto L35;
        Object r6 = r12.next();
        String r7 = (String) r6;
        List<? extends DoraDevice> r8 = r9;
        if ((r8 instanceof Collection) == true) goto L25;
    L27:
        Iterator<T> r13 = r8.iterator();
    L29:
        if (r13.hasNext() == false) goto L26;
        if (Intrinsics.areEqual(((DoraDevice) r13.next()).mac, r7) == false) goto L29;
        boolean r14 = true;
    L33:
        if (r14 == false) goto L21;
        r5.add(r6);
    L26:
        r14 = false;
        goto L33
    L25:
        if (r8.isEmpty() == false) goto L27;
    L35:
        r4.addAll(r5);
    L36:
        List<? extends DoraDevice> r15 = r9;
        LinkedHashSet r16 = new LinkedHashSet();
        Iterator<T> r17 = r15.iterator();
    L37:
        String r18 = "";
        if (r17.hasNext() == false) goto L44;
        String r20 = ((DoraDevice) r17.next()).mac;
        if (r20 == null) goto L43;
        r18 = r20;
    L43:
        r16.add(r18);
        goto L37
    L44:
        this.deviceOrder.retainAll(r16);
        this.batteryInfoByDeviceMac.keySet().retainAll(r16);
        Iterator<T> r21 = r15.iterator();
    L46:
        if (r21.hasNext() == false) goto L59;
        String r110 = ((DoraDevice) r21.next()).mac;
        if (r110 != null) goto L51;
        r110 = "";
    L51:
        if (r110.length() <= 0) goto L53;
        boolean r22 = true;
    L54:
        if (r22 == false) goto L46;
        if (this.deviceOrder.contains(r110) == true) goto L46;
        this.deviceOrder.add(r110);
        goto L46
    L53:
        r22 = false;
        goto L54
    L59:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (this.deviceOrder.isEmpty() == false) goto L36;
        CoroutineDispatcher r111 = Dispatchers.getIO();
        DoraObricDeviceHomeViewModel$syncDeviceOrder$history$1 r23 = new DoraObricDeviceHomeViewModel$syncDeviceOrder$history$1(null);
        r0.L$0 = r9;
        r0.label = 1;
        r11 = BuildersKt.withContext(r111, r23, r0);
        if (r11 != r2) goto L19;
        return r2;
    L7:
        r0 = new C04751(this, r10);
        goto L8
    }

    private final void updateBatteryCache(DoraDevice r8, int[] r9) {
        String r0 = r8.mac;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        boolean r2 = true;
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (r9 != null) goto L13;
        r9 = o59.a.a(r8);
    L13:
        int[] r3 = new int[3];
        int r4 = 0;
    L14:
        int r5 = -1;
        if (r4 >= 3) goto L20;
        Integer r6 = ArraysKt.getOrNull(r9, r4);
        if (r6 == null) goto L19;
        r5 = r6.intValue();
    L19:
        r3[r4] = r5;
        r4 = r4 + 1;
        goto L14
    L20:
        int[] r10 = this.batteryInfoByDeviceMac.get(r0);
        if (r10 != null) goto L32;
        int r11 = 0;
    L23:
        if (r11 >= 3) goto L28;
        if (com.larus.dora.impl.device.manage.r0.a(Integer.valueOf(r3[r11])) == true) goto L29;
        r11 = r11 + 1;
    L29:
        if (r2 == false) goto L54;
        this.batteryInfoByDeviceMac.put(r0, r3);
        return;
    L54:
        return;
    L28:
        r2 = false;
        goto L29
    L32:
        IntIterator r12 = ArraysKt.getIndices(r3).iterator();
    L34:
        if (r12.hasNext() == false) goto L42;
        int r7 = r12.nextInt();
        if (com.larus.dora.impl.device.manage.r0.a(Integer.valueOf(r3[r7])) == true) goto L34;
        Integer r13 = ArraysKt.getOrNull(r10, r7);
        if (r13 == null) goto L40;
        int r14 = r13.intValue();
    L41:
        r3[r7] = r14;
        goto L34
    L40:
        r14 = -1;
        goto L41
    L42:
        this.batteryInfoByDeviceMac.put(r0, r3);
        return;
    L8:
        r1 = false;
        goto L9
    }

    private final void updateBatteryFromCallback(DoraDevice r12, int[] r13) {
        String r3 = "";
        if (kj4.a.g().getDoraLinkState(r12) == 2) goto L10;
        Map<String, int[]> r14 = this.batteryInfoByDeviceMac;
        String r15 = r12.mac;
        if (r15 == null) goto L8;
        r3 = r15;
    L8:
        r14.remove(r3);
        clearBatterySnapshot("battery_callback_disconnected");
        refreshDeviceList$default(this, null, 1, null);
        return;
    L10:
        Map<String, int[]> r0 = this.batteryInfoByDeviceMac;
        String r1 = r12.mac;
        if (r1 == null) goto L14;
        r3 = r1;
    L14:
        int[] r2 = r0.get(r3);
        if (r2 == null) goto L18;
        int[] r4 = Arrays.copyOf(r2, r2.length);
        if (r4 == null) goto L18;
    L21:
        this.currentBatteryInfo = r4;
        Job r16 = this.batteryUpdateJob;
        if (r16 == null) goto L24;
        Job.DefaultImpls.cancel$default(r16, null, 1, null);
    L24:
        this.batteryUpdateJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04771(this, null), 3, null);
        return;
    L18:
        if (r13 == null) goto L20;
        r4 = Arrays.copyOf(r13, r13.length);
        goto L21
    L20:
        int[] r17 = o59.a.a(r12);
        r4 = Arrays.copyOf(r17, r17.length);
        goto L21
    }

    private final void updateChargeFromCallback(DoraDevice r12, int[] r13) {
        String r0 = r12.mac;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return;
    L12:
        if (kj4.a.g().getDoraLinkState(r12) == 2) goto L18;
        this.chargeInfoByDeviceMac.remove(r0);
        if (Intrinsics.areEqual(r0, this.currentDeviceMac) == false) goto L16;
        clearBatterySnapshot("charge_callback_disconnected");
    L16:
        refreshDeviceList$default(this, null, 1, null);
        return;
    L18:
        if (r13 == null) goto L21;
        int[] r14 = Arrays.copyOf(r13, r13.length);
        if (r14 == null) goto L21;
    L22:
        this.chargeInfoByDeviceMac.put(r0, r14);
        if (Intrinsics.areEqual(r0, this.currentDeviceMac) == true) goto L26;
        refreshDeviceList$default(this, null, 1, null);
        return;
    L26:
        this.currentChargeInfo = r14;
        Job r15 = this.chargeUpdateJob;
        if (r15 == null) goto L29;
        Job.DefaultImpls.cancel$default(r15, null, 1, null);
    L29:
        this.chargeUpdateJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04781(this, null), 3, null);
        return;
    L21:
        int[] r16 = o59.a.b(r12);
        r14 = Arrays.copyOf(r16, r16.length);
        goto L22
    L8:
        r1 = false;
        goto L9
    }

    private final Object updateDeviceStatusWithCurrentContent(boolean r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof C04791) == false) goto L7;
        C04791 r0 = (C04791) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        r9 = r0.Z$0;
        List<? extends DoraDevice> r4 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L27:
        this.usageEvidence = s1.a((s1) r11, false, this.usageEvidence.d, 7);
        List<DoraDevice> r12 = sortDeviceList(r4);
        if (r12.isEmpty() == false) goto L31;
        this.pendingEntryDeviceMac = null;
        this.currentDeviceMac = null;
        this.currentBatteryInfo = null;
        this.currentChargeInfo = null;
        publishHomeStatus(CollectionsKt.emptyList(), null, "update_status_no_bound_device");
        return Unit.INSTANCE;
    L31:
        List<DoraDevice> r5 = r12;
        Iterator<T> r6 = r5.iterator();
    L33:
        if (r6.hasNext() == false) goto L37;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((DoraDevice) r7).mac, this.currentDeviceMac) == false) goto L33;
    L38:
        DoraDevice r8 = (DoraDevice) r7;
        if (r8 != null) goto L41;
        r8 = (DoraDevice) CollectionsKt.firstOrNull(r12);
    L41:
        if (r8 == null) goto L43;
        String r13 = r8.mac;
    L45:
        if (Intrinsics.areEqual(r13, this.pendingEntryDeviceMac) == false) goto L47;
        this.pendingEntryDeviceMac = null;
    L47:
        if (r9 == true) goto L49;
    L59:
        Iterator<T> r14 = r5.iterator();
    L61:
        if (r14.hasNext() == false) goto L65;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((DoraDevice) r15).mac, this.currentDeviceMac) == false) goto L61;
    L66:
        DoraDevice r16 = (DoraDevice) r15;
        if (r16 == null) goto L70;
        r8 = r16;
    L70:
        if (r8 != null) goto L73;
        publishHomeStatus(r12, null, "update_status_no_selected_device");
        return Unit.INSTANCE;
    L73:
        publishHomeStatus(r12, r8, "update_status");
        return Unit.INSTANCE;
    L65:
        r15 = null;
        goto L66
    L49:
        if (this.pendingEntryDeviceMac != null) goto L59;
        if (r8 == null) goto L52;
        String r17 = r8.mac;
    L54:
        if (Intrinsics.areEqual(r17, this.currentDeviceMac) == true) goto L59;
        if (r8 == null) goto L57;
        String r18 = r8.mac;
    L58:
        this.currentDeviceMac = r18;
        this.currentBatteryInfo = null;
        this.currentChargeInfo = null;
        goto L59
    L57:
        r18 = null;
        goto L58
    L52:
        r17 = null;
        goto L54
    L43:
        r13 = null;
        goto L45
    L37:
        r7 = null;
        goto L38
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = r0.Z$0;
        String r20 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L23:
        List<? extends DoraDevice> r110 = (List) r11;
        this.latestBoundDevices = r110;
        CoroutineDispatcher r21 = Dispatchers.getIO();
        DoraObricDeviceHomeViewModel$updateDeviceStatusWithCurrentContent$boundDeviceEvidence$1 r22 = new DoraObricDeviceHomeViewModel$updateDeviceStatusWithCurrentContent$boundDeviceEvidence$1(this, r20, r110, null);
        r0.L$0 = r110;
        r0.Z$0 = r9;
        r0.label = 2;
        Object r23 = BuildersKt.withContext(r21, r22, r0);
        if (r23 != r2) goto L26;
        return r2;
    L26:
        r4 = r110;
        r11 = r23;
        goto L27
    L16:
        ResultKt.throwOnFailure(r11);
        if (this.initialHomeStatePending == false) goto L20;
        g49.d.d(TAG, "updateDeviceStatusWithCurrentContent skipped before initial home state");
        return Unit.INSTANCE;
    L20:
        resetDiaryDataForAccountChange();
        r20 = currentAccountId();
        CoroutineDispatcher r111 = Dispatchers.getIO();
        DoraObricDeviceHomeViewModel$updateDeviceStatusWithCurrentContent$rawBindList$1 r24 = new DoraObricDeviceHomeViewModel$updateDeviceStatusWithCurrentContent$rawBindList$1(null);
        r0.L$0 = r20;
        r0.Z$0 = r9;
        r0.label = 1;
        r11 = BuildersKt.withContext(r111, r24, r0);
        if (r11 != r2) goto L23;
        return r2;
    L7:
        r0 = new C04791(this, r10);
        goto L8
    }

    public final void checkCurrentDeviceBindState(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        DoraDevice r0 = ((c) this._uiState.getValue()).b;
        if (r0 == null) goto L6;
        checkBindState(r0, r2, r3);
        return;
    }

    public final void onEnvironmentMemoryAuthorizationCanceled(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "deviceMac");
        this.environmentMemoryAuthorizationContinuation.a(r2, r3);
    }

    public final void onEnvironmentMemoryAuthorizationCompleted(String r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "deviceMac");
        f2 r1 = this.environmentMemoryAuthorizationContinuation;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "deviceMac");
        if (r1.a(r6, r7) == true) goto L5;
        return;
    L5:
        Iterator<T> r8 = ((c) this._uiState.getValue()).f.iterator();
    L7:
        if (r8.hasNext() == false) goto L11;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((q) r9).a, r6) == false) goto L7;
    L12:
        q r10 = (q) r9;
        if (r10 != null) goto L15;
        return;
    L15:
        h3 r11 = r10.d;
        boolean r3 = false;
        if (r11.d == DoraObricGlassesMode.HEADPHONE) goto L18;
    L20:
        boolean r12 = false;
    L22:
        if (r10.b.d == true) goto L24;
        return;
    L24:
        if (a2.a(r10.c) == false) goto L48;
        if (r12 == true) goto L50;
        IDoraPageConfig r13 = getDoraPageConfig();
        if (r13 == null) goto L30;
        r3 = r13.d("dora_g_config_key_env_observe_enable", false);
    L30:
        if (r3 == true) goto L38;
        if (TimerJob.j.a().e(Calendar.getInstance()) == false) goto L34;
        DoraObricEnvironmentMemoryClickAction r14 = DoraObricEnvironmentMemoryClickAction.ENABLE_SWITCH;
    L35:
        updateEnvironmentMemorySwitch(r6, true, r14);
        return;
    L34:
        r14 = DoraObricEnvironmentMemoryClickAction.ENABLE_SWITCH_WITH_OVERRIDE;
        goto L35
    L38:
        if (TimerJob.j.a().e(Calendar.getInstance()) == false) goto L40;
    L42:
        emitEnvironmentMemoryToast(DoraObricEnvironmentMemoryToastType.ENABLED);
        return;
    L40:
        if (r10.d.i != DoraObricEnvironmentMemoryState.OFF) goto L42;
        DoraEnvObserveManager.a.getClass();
        DoraEnvObserveManager.a(r6);
        refreshDeviceList$default(this, null, 1, null);
        emitEnvironmentMemoryToast(DoraObricEnvironmentMemoryToastType.TEMPORARY_OVERRIDE);
        return;
    L50:
        return;
    L48:
        return;
    L18:
        if (r11.i != DoraObricEnvironmentMemoryState.UNAVAILABLE) goto L20;
        r12 = true;
        goto L22
    L11:
        r9 = null;
        goto L12
    }

    public final Object onlyConnect(DoraDevice r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof C04681) == false) goto L7;
        C04681 r3 = (C04681) r13;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r14 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L24;
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L17;
        if (r6 != 3) goto L16;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L19
    L35:
        int r15 = ((Number) r14).intValue();     // Catch: Throwable -> L19
        g49.d.d(TAG, "onlyConnect state=" + r15);     // Catch: Throwable -> L19
        if (r15 == 2) goto L47;
        onConnectRequestFailed();     // Catch: Throwable -> L19
    L47:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L19
    L43:
        onConnectRequestFailed();     // Catch: Throwable -> L19
        goto L47
    L21:
        r12 = (DoraDevice) r3.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L19
    L28:
        OnlyConnectResult r16 = (OnlyConnectResult) r14;     // Catch: Throwable -> L19
        int r2 = d.d[r16.ordinal()];     // Catch: Throwable -> L19
        if (r2 == 1) goto L40;
        if (r2 == 2) goto L40;
        if (r2 != 3) goto L39;
        CoroutineDispatcher r17 = Dispatchers.getIO();     // Catch: Throwable -> L19
        DoraObricDeviceHomeViewModel$onlyConnect$state$1 r0 = new DoraObricDeviceHomeViewModel$onlyConnect$state$1(r12, null);     // Catch: Throwable -> L19
        r3.L$0 = null;     // Catch: Throwable -> L19
        r3.label = 3;     // Catch: Throwable -> L19
        r14 = BuildersKt.withContext(r17, r0, r3);     // Catch: Throwable -> L19
        if (r14 != r5) goto L35;
        return r5;
    L39:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L19
    L40:
        g49.d.d(TAG, "onlyConnect failed result=" + r16);     // Catch: Throwable -> L19
        MutableSharedFlow<com.larus.dora.obric.device_management.device_home.a> r18 = this._deviceIntentSharedFlow;     // Catch: Throwable -> L19
        com.larus.dora.obric.device_management.device_home.a.b r1 = new com.larus.dora.obric.device_management.device_home.a.b(r12);     // Catch: Throwable -> L19
        r3.L$0 = null;     // Catch: Throwable -> L19
        r3.label = 2;     // Catch: Throwable -> L19
        if (r18.emit(r1, r3) != r5) goto L43;
        return r5;
    L24:
        ResultKt.throwOnFailure(r14);
        g49.d.d(TAG, "onlyConnect device=" + o59.a.h(r12));     // Catch: Throwable -> L19
        CoroutineDispatcher r110 = Dispatchers.getIO();     // Catch: Throwable -> L19
        DoraObricDeviceHomeViewModel$onlyConnect$result$1 r7 = new DoraObricDeviceHomeViewModel$onlyConnect$result$1(r12, null);     // Catch: Throwable -> L19
        r3.L$0 = r12;     // Catch: Throwable -> L19
        r3.label = 1;     // Catch: Throwable -> L19
        r14 = BuildersKt.withContext(r110, r7, r3);     // Catch: Throwable -> L19
        if (r14 != r5) goto L28;
        return r5;
    L19:
        th = move-exception;
        g49.d.c(TAG, "onlyConnect failed", th);
        onConnectRequestFailed();
    L7:
        r3 = new C04681(this, r13);
        goto L8
    }

    public final void resumeEnvironmentMemoryAuthorization(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "deviceMac");
        IDoraPageConfig r0 = getDoraPageConfig();
        boolean r1 = false;
        if (r0 == null) goto L5;
        r1 = r0.d("dora_g_config_key_env_observe_auth_enable", false);
    L5:
        if (r1 == false) goto L7;
        onEnvironmentMemoryAuthorizationCompleted(r4, r5);
        return;
    L7:
        onEnvironmentMemoryAuthorizationCanceled(r4, r5);
    }

    public static final /* synthetic */ Object access$handleEarbudsConnectRequest(DoraObricDeviceHomeViewModel r0, DoraDevice r1, Continuation r2) {
        return r0.handleEarbudsConnectRequest(r1, r2);
    }

    public static final /* synthetic */ Object access$handleGConnectRequest(DoraObricDeviceHomeViewModel r0, DoraDevice r1, Continuation r2) {
        return r0.handleGConnectRequest(r1, r2);
    }

    public static final /* synthetic */ DoraDevice access$selectDevice(DoraObricDeviceHomeViewModel r0, List r1, boolean r2) {
        return r0.selectDevice(r1, r2);
    }

    public static final /* synthetic */ Object access$syncDeviceOrder(DoraObricDeviceHomeViewModel r0, List r1, Continuation r2) {
        return r0.syncDeviceOrder(r1, r2);
    }

    public static final /* synthetic */ void access$updateBatteryCache(DoraObricDeviceHomeViewModel r0, DoraDevice r1, int[] r2) {
        r0.updateBatteryCache(r1, r2);
    }

    public static final /* synthetic */ void access$updateBatteryFromCallback(DoraObricDeviceHomeViewModel r0, DoraDevice r1, int[] r2) {
        r0.updateBatteryFromCallback(r1, r2);
    }

    public static final /* synthetic */ void access$updateChargeFromCallback(DoraObricDeviceHomeViewModel r0, DoraDevice r1, int[] r2) {
        r0.updateChargeFromCallback(r1, r2);
    }

    public static final /* synthetic */ Object access$updateDeviceStatusWithCurrentContent(DoraObricDeviceHomeViewModel r0, boolean r1, Continuation r2) {
        return r0.updateDeviceStatusWithCurrentContent(r1, r2);
    }

    private final Object handleDeviceNeedingUnbind(DoraDevice r9, OnlyBindResult r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C04611) == false) goto L7;
        C04611 r0 = (C04611) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        ResultKt.throwOnFailure(r12);
    L43:
        onConnectRequestFailed();
    L45:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r12);
    L36:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r12);
    L28:
        onConnectRequestFailed();
        return Unit.INSTANCE;
    L19:
        r9 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L23:
        DoraDevice r13 = (DoraDevice) r12;
        if (r13 != null) goto L30;
        MutableSharedFlow<com.larus.dora.obric.device_management.device_home.a> r14 = this._deviceIntentSharedFlow;
        com.larus.dora.obric.device_management.device_home.a.b r15 = new com.larus.dora.obric.device_management.device_home.a.b(r9);
        r0.L$0 = null;
        r0.label = 2;
        if (r14.emit(r15, r0) != r2) goto L28;
        return r2;
    L30:
        r9.mode = r13.mode;
        r9.version = r13.version;
        if (o59.a.v(r9) == true) goto L38;
        r0.L$0 = null;
        r0.label = 3;
        if (onlyConnect(r9, r0) != r2) goto L36;
        return r2;
    L38:
        if (r9.isFactory() == false) goto L40;
        replaceBind(r9);
        goto L45
    L40:
        r0.L$0 = null;
        r0.label = 4;
        if (emitNeedUnbindIfCurrent(r9, "glasses_connect", true, r0) != r2) goto L43;
        return r2;
    L20:
        ResultKt.throwOnFailure(r12);
        g49.d.d(TAG, "handleDeviceNeedingUnbind bindResult=" + r10);
        CoroutineDispatcher r16 = Dispatchers.getIO();
        DoraObricDeviceHomeViewModel$handleDeviceNeedingUnbind$scannedDevice$1 r17 = new DoraObricDeviceHomeViewModel$handleDeviceNeedingUnbind$scannedDevice$1(this, r9, null);
        r0.L$0 = r9;
        r0.label = 1;
        r12 = BuildersKt.withContext(r16, r17, r0);
        if (r12 != r2) goto L23;
        return r2;
    L7:
        r0 = new C04611(this, r11);
        goto L8
    }

    private final void publishHomeStatus(List<? extends DoraDevice> r21, DoraDevice r22, String r23) {
        this.latestBoundDevices = r21;
        Iterator<T> r2 = r21.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        DoraDevice r4 = (DoraDevice) r2.next();
        if (kj4.a.g().getDoraLinkState(r4) != 2) goto L4;
        updateBatteryCache(r4, o59.a.a(r4));
        goto L4
    L8:
        int r3 = s.a;
        u r15 = s.a(this.usageEvidence, hasHealthEntry());
        if (r22 != null) goto L12;
        updateEmptyDeviceState(r23);
        return;
    L12:
        String r5 = r22.mac;
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        String r13 = r5;
        List<q> r6 = buildDeviceCardItems(r21, r13);
        List<m1> r16 = buildQuickActions(r15, r22);
        cacheConnectedDeviceSnapshotIfNeeded(r22, "update_status");
        kotlinx.coroutines.flow.z0<c> r12 = this._uiState;
        c r1 = (c) r12.getValue();
        PageState r7 = PageState.Content;
        Iterator<q> r8 = r6.iterator();
        int r9 = 0;
    L17:
        if (r8.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(r8.next().a, r13) == true) goto L23;
        r9 = r9 + 1;
    L23:
        r12.setValue(c.a(r1, r7, r22, r13, true, r6, RangesKt.coerceAtLeast(r9, 0), buildDeviceCardUiState(r22, true), this.usageEvidence.d, r15.a, r16, buildBottomTabs(r15), 272));
        g49.d.d(TAG, "publishHomeStatus source=" + r23 + " selectedDeviceMac=" + r13 + " showGFeatures=" + r15.a + " showEarbudsFeatures=" + r15.b + " showDiaryTab=" + r15.c + " hasBoundGlassesHistory=" + this.usageEvidence.c + " hasDiaryData=" + this.usageEvidence.d + " quickActions=" + CollectionsKt.joinToString$default(r16, null, null, null, 0, null, new u1(), 31, null));
        return;
    L22:
        r9 = -1;
        goto L23
    }

    /* JADX INFO: renamed from: queryDiaryData-0E7RQCE, reason: not valid java name */
    private final Object m234queryDiaryData0E7RQCE(String r5, boolean r6, Continuation<? super Result<Boolean>> r7) {
        if ((r7 instanceof DoraObricDeviceHomeViewModel$queryDiaryData$1) == false) goto L7;
        DoraObricDeviceHomeViewModel$queryDiaryData$1 r0 = (DoraObricDeviceHomeViewModel$queryDiaryData$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        Result r9 = (Result) r8;
        if (r9 != null) goto L22;
        Result.Companion r10 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("Query glasses diary data timed out")));
    L22:
        return r9.unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        DoraObricDeviceHomeViewModel$queryDiaryData$2 r11 = new DoraObricDeviceHomeViewModel$queryDiaryData$2(this, r5, r6, null);
        r0.label = 1;
        r8 = TimeoutKt.c(5000, r11, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new DoraObricDeviceHomeViewModel$queryDiaryData$1(this, r7);
        goto L8
    }

    private final Object scanBleInfo(String r10, long r11, Continuation<? super DoraDevice> r13) {
        if ((r13 instanceof C04731) == false) goto L7;
        C04731 r0 = (C04731) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r12 = r0.J$0;
        k r15 = (k) r0.L$1;
        Ref.ObjectRef r4 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        kj4.a.g().stopScan(r15);
        g49.d.d(TAG, "scanBleInfo cost=" + (System.currentTimeMillis() - r12));
        return r4.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        long r5 = System.currentTimeMillis();
        CompletableDeferred r6 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        k r8 = new k(r6, r10, r7);
        kj4.a.g().scan(CollectionsKt.mutableListOf(new String[]{"0000FD7B-0000-1000-8000-00805F9B34FB"}), r8);
        AnonymousClass2 r16 = new AnonymousClass2(r6, null);
        r0.L$0 = r7;
        r0.L$1 = r8;
        r0.J$0 = r5;
        r0.label = 1;
        if (TimeoutKt.c(r11, r16, r0) != r2) goto L17;
        return r2;
    L17:
        r12 = r5;
        r4 = r7;
        r15 = r8;
    L7:
        r0 = new C04731(this, r13);
        goto L8
    }

    private final void updateEnvironmentMemorySwitch(String r15, boolean r16, DoraObricEnvironmentMemoryClickAction r17) {
        Iterator<T> r0 = this.latestBoundDevices.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((DoraDevice) r1).mac, r15) == false) goto L4;
    L9:
        DoraDevice r5 = (DoraDevice) r1;
        if (r5 != null) goto L12;
        return;
    L12:
        DoraEnvObserveManager r2 = DoraEnvObserveManager.a;
        EnvObserveSettingAction r3 = EnvObserveSettingAction.ENV_SWITCH;
        r2.getClass();
        DoraEnvObserveManager.d(r15, r3);
        g49.d.d(TAG, "updateEnvironmentMemorySwitch enabled=" + r16);
        this.environmentMemoryUpdateJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04801(this, r16, r17, r15, r5, null), 3, null);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void checkBindState(DoraDevice r17, String r18, boolean r110) {
        Intrinsics.checkNotNullParameter(r17, "device");
        Intrinsics.checkNotNullParameter(r18, "source");
        String r0 = r17.mac;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r7 = r0;
        boolean r3 = false;
        if (r7.length() != 0) goto L8;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        g49.d.e(TAG, "checkBindState skipped, device mac is empty, source=" + r18);
        return;
    L13:
        if (r110 == true) goto L24;
        Job r2 = this.bindCheckJob;
        if (r2 != null) goto L17;
    L19:
        if (r3 == false) goto L24;
        if (Intrinsics.areEqual(this.bindCheckMac, r7) == false) goto L24;
        g49.d.d(TAG, "checkBindState skipped, request in flight, source=" + r18);
        return;
    L17:
        if (r2.isActive() != true) goto L19;
        r3 = true;
    L24:
        Job r4 = this.bindCheckJob;
        if (r4 == null) goto L27;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L27:
        this.bindCheckMac = r7;
        long r5 = this.bindCheckRequestId + 1;
        this.bindCheckRequestId = r5;
        this.bindCheckJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04561(r17, r18, r5, this, r110, r7, null), 2, null);
        return;
    L8:
        r1 = false;
        goto L10
    }

    public static final /* synthetic */ Object access$handleDeviceNeedingUnbind(DoraObricDeviceHomeViewModel r0, DoraDevice r1, OnlyBindResult r2, Continuation r3) {
        return r0.handleDeviceNeedingUnbind(r1, r2, r3);
    }

    public static final /* synthetic */ void access$publishHomeStatus(DoraObricDeviceHomeViewModel r0, List r1, DoraDevice r2, String r3) {
        r0.publishHomeStatus(r1, r2, r3);
    }

    /* JADX INFO: renamed from: access$queryDiaryData-0E7RQCE, reason: not valid java name */
    public static final /* synthetic */ Object m233access$queryDiaryData0E7RQCE(DoraObricDeviceHomeViewModel r0, String r1, boolean r2, Continuation r3) {
        return r0.m234queryDiaryData0E7RQCE(r1, r2, r3);
    }

    public static final /* synthetic */ Object access$scanBleInfo(DoraObricDeviceHomeViewModel r0, String r1, long r2, Continuation r4) {
        return r0.scanBleInfo(r1, r2, r4);
    }

    public static Bundle createDeviceRouteArguments$default(DoraObricDeviceHomeViewModel r0, DoraDevice r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = ((c) r0._uiState.getValue()).b;
    L6:
        return r0.createDeviceRouteArguments(r1);
    }

    private final Object emitNeedUnbindIfCurrent(DoraDevice r5, String r6, boolean r7, Continuation<? super Unit> r8) {
        String r0 = r5.mac;
        String r1 = "";
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r0.length() != 0) goto L8;
        boolean r2 = true;
    L10:
        if (r2 == true) goto L28;
        String r3 = this.currentDeviceMac;
        if (r3 == null) goto L16;
        r1 = r3;
    L16:
        if (Intrinsics.areEqual(r0, r1) == false) goto L28;
        if (r7 == false) goto L20;
    L23:
        this.needUnbindPromptMac = r0;
        Object r9 = this._deviceIntentSharedFlow.emit(new com.larus.dora.obric.device_management.device_home.a.C0100a(r5), r8);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r9;
    L27:
        return Unit.INSTANCE;
    L20:
        if (Intrinsics.areEqual(this.needUnbindPromptMac, r0) == false) goto L23;
        g49.d.d(TAG, "skip duplicate unbind prompt source=" + r6);
        return Unit.INSTANCE;
    L28:
        g49.d.d(TAG, "skip stale unbind prompt source=" + r6);
        return Unit.INSTANCE;
    L8:
        r2 = false;
        goto L10
    }

    private final b getDeviceCardImage(DoraDevice r3, DoraObricDeviceHomeDeviceCardType r4, boolean r5, boolean r6) {
        b r0 = resolveDeviceCardImage(r3, r4);
        if (r6 == false) goto L5;
        g49.d.d(TAG, "resolveDeviceHomeImage type=" + r4 + " connected=" + r5 + " productId=" + r3.productId + " sku=" + r3.sku + " requestedResName=" + r0.c + " resolvedResName=" + r0.b + " resId=" + r0.a);
    L5:
        return r0;
    }

    public static void onReconnectStarted$default(DoraObricDeviceHomeViewModel r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = ((c) r0._uiState.getValue()).c;
    L5:
        r0.onReconnectStarted(r1);
    }

    public static /* synthetic */ void refreshDeviceHomeDiaryData$default(DoraObricDeviceHomeViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.refreshDeviceHomeDiaryData(r1);
    }

    public static /* synthetic */ void refreshDeviceList$default(DoraObricDeviceHomeViewModel r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.refreshDeviceList(r1);
    }

    public static final /* synthetic */ Object access$emitNeedUnbindIfCurrent(DoraObricDeviceHomeViewModel r0, DoraDevice r1, String r2, boolean r3, Continuation r4) {
        return r0.emitNeedUnbindIfCurrent(r1, r2, r3, r4);
    }

    public static /* synthetic */ r buildDeviceCardUiState$default(DoraObricDeviceHomeViewModel r0, DoraDevice r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = Intrinsics.areEqual(r1.mac, r0.currentDeviceMac);
    L6:
        return r0.buildDeviceCardUiState(r1, r2);
    }

    public static /* synthetic */ void checkCurrentDeviceBindState$default(DoraObricDeviceHomeViewModel r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.checkCurrentDeviceBindState(r1, r2);
    }

    public static /* synthetic */ void emitRoute$default(DoraObricDeviceHomeViewModel r0, String r1, Bundle r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = r0.arguments;
    L5:
        r0.emitRoute(r1, r2);
    }

    public static /* synthetic */ Object updateDeviceStatusWithCurrentContent$default(DoraObricDeviceHomeViewModel r0, boolean r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return r0.updateDeviceStatusWithCurrentContent(r1, r2);
    }

    public static /* synthetic */ void checkBindState$default(DoraObricDeviceHomeViewModel r0, DoraDevice r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = "unknown";
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = false;
    L8:
        r0.checkBindState(r1, r2, r3);
    }

    /* JADX INFO: renamed from: queryDiaryData-0E7RQCE$default, reason: not valid java name */
    public static /* synthetic */ Object m235queryDiaryData0E7RQCE$default(DoraObricDeviceHomeViewModel r0, String r1, boolean r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.m234queryDiaryData0E7RQCE(r1, r2, r3);
    }

    public static /* synthetic */ Object scanBleInfo$default(DoraObricDeviceHomeViewModel r0, String r1, long r2, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = SCAN_TIMEOUT_MS;
    L6:
        return r0.scanBleInfo(r1, r2, r4);
    }
}
