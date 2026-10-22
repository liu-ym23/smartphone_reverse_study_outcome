package com.ss.ugc.effectplatform;

import bytekn.foundation.concurrent.executor.AsyncExecutor;
import bytekn.foundation.encryption.d;
import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.extension.ByteArrayExKt;
import com.ss.ugc.effectplatform.listener.IDownloadInfoStickerEffectProgressListener;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.EffectCategoryModelList;
import com.ss.ugc.effectplatform.model.EffectChannelResponse;
import com.ss.ugc.effectplatform.model.EffectQRCode;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.ProviderEffectModel;
import com.ss.ugc.effectplatform.model.QueryTopChecklistEffectsModel;
import com.ss.ugc.effectplatform.model.RankingCategoryListModel;
import com.ss.ugc.effectplatform.model.RankingDesignerInfoConvertModel;
import com.ss.ugc.effectplatform.model.RankingEffectInfoModel;
import com.ss.ugc.effectplatform.model.ResourceListModel;
import com.ss.ugc.effectplatform.model.net.AddCustomizedEffectResponse;
import com.ss.ugc.effectplatform.model.net.CategoryEffectsWithThemeData;
import com.ss.ugc.effectplatform.model.net.ConvertOidToUrlResponse;
import com.ss.ugc.effectplatform.model.net.CustomizedStickerCreateResponse;
import com.ss.ugc.effectplatform.model.net.EffectListPreloadResponse;
import com.ss.ugc.effectplatform.model.net.EffectListResponse;
import com.ss.ugc.effectplatform.model.net.FetchFavoriteListResponse;
import com.ss.ugc.effectplatform.model.net.FetchHotEffectResponse;
import com.ss.ugc.effectplatform.model.net.GetCustomizedEffectIDData;
import com.ss.ugc.effectplatform.model.net.GifProviderEffectListResponse;
import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;
import com.ss.ugc.effectplatform.model.net.InfoStickerListResponse;
import com.ss.ugc.effectplatform.model.net.PanelInfoWithOneEffectData;
import com.ss.ugc.effectplatform.model.net.PreloadDataModel;
import com.ss.ugc.effectplatform.model.net.PreloadedEffectsRecord;
import com.ss.ugc.effectplatform.model.net.QueryCustomizedEffectsData;
import com.ss.ugc.effectplatform.model.net.QueryInfoStickerResponse;
import com.ss.ugc.effectplatform.model.net.QueryRewardEffectsResponse;
import com.ss.ugc.effectplatform.model.net.RecommendSearchWordsResponse;
import com.ss.ugc.effectplatform.model.net.SearchEffectResponse;
import com.ss.ugc.effectplatform.model.net.SearchEffectResponseV2;
import com.ss.ugc.effectplatform.model.net.StickerCategoryListResponse;
import com.ss.ugc.effectplatform.model.net.StickerUploadAuthKeyResponse;
import com.ss.ugc.effectplatform.repository.AlgorithmRepository;
import com.ss.ugc.effectplatform.repository.EffectRepository;
import com.ss.ugc.effectplatform.repository.e;
import com.ss.ugc.effectplatform.repository.l;
import com.ss.ugc.effectplatform.task.DownloadInfoProviderEffectTask;
import com.ss.ugc.effectplatform.task.DownloadProviderEffectTask;
import com.ss.ugc.effectplatform.task.FetchEffectListByIdsTask;
import com.ss.ugc.effectplatform.task.FetchPanelInfoCheckedCacheTask;
import com.ss.ugc.effectplatform.task.FetchPanelInfoPagingCheckedCacheTask;
import com.ss.ugc.effectplatform.task.ReadUpdateTagTask;
import com.ss.ugc.effectplatform.task.b0;
import com.ss.ugc.effectplatform.task.b1;
import com.ss.ugc.effectplatform.task.c0;
import com.ss.ugc.effectplatform.task.c1;
import com.ss.ugc.effectplatform.task.e0;
import com.ss.ugc.effectplatform.task.f0;
import com.ss.ugc.effectplatform.task.f1;
import com.ss.ugc.effectplatform.task.g;
import com.ss.ugc.effectplatform.task.g0;
import com.ss.ugc.effectplatform.task.g1;
import com.ss.ugc.effectplatform.task.h0;
import com.ss.ugc.effectplatform.task.h1;
import com.ss.ugc.effectplatform.task.i0;
import com.ss.ugc.effectplatform.task.j0;
import com.ss.ugc.effectplatform.task.j1;
import com.ss.ugc.effectplatform.task.k1;
import com.ss.ugc.effectplatform.task.m;
import com.ss.ugc.effectplatform.task.m0;
import com.ss.ugc.effectplatform.task.m1;
import com.ss.ugc.effectplatform.task.n0;
import com.ss.ugc.effectplatform.task.n1;
import com.ss.ugc.effectplatform.task.p;
import com.ss.ugc.effectplatform.task.p0;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.task.r0;
import com.ss.ugc.effectplatform.task.s0;
import com.ss.ugc.effectplatform.task.t0;
import com.ss.ugc.effectplatform.task.u;
import com.ss.ugc.effectplatform.task.u0;
import com.ss.ugc.effectplatform.task.v0;
import com.ss.ugc.effectplatform.task.w0;
import com.ss.ugc.effectplatform.task.z0;
import com.ss.ugc.effectplatform.util.EffectPlatformAES;
import com.ss.ugc.effectplatform.util.PlatformType;
import com.ss.ugc.effectplatform.util.n;
import com.ss.ugc.effectplatform.util.q;
import com.ss.ugc.effectplatform.util.r;
import e0.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ®\u00022\u00020\u0001:\u0002¯\u0002B\u0011\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0006\b¬\u0002\u0010\u00ad\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0016H\u0002J>\u0010!\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJ\u001e\u0010\"\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJH\u0010(\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001eJ@\u0010+\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001eJ8\u0010-\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u001eJ\u0080\u0001\u00109\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020#2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u001eJ6\u0010;\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010:\u0018\u00010\u001eJL\u0010@\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u00192\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010?\u0018\u00010\u001eJ\b\u0010A\u001a\u0004\u0018\u00010\u001fJL\u0010!\u001a\u00020\u00042\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\u0006\u0010\u001b\u001a\u00020\u000e2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0016\b\u0002\u0010'\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0016\u0018\u00010\u001eJ@\u0010E\u001a\u00020\u00042\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00162\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u001eJb\u0010J\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00192\u0006\u0010G\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\u0010H\u001a\u0004\u0018\u00010\u00192\b\u0010I\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0016\b\u0002\u0010'\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0016\u0018\u00010\u001eJI\u0010M\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010K\u001a\u0004\u0018\u00010\u000e2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010\u001e¢\u0006\u0004\bM\u0010NJL\u0010Q\u001a\u00020\u00042\u001a\u0010B\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010Oj\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`P2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u001eJP\u0010T\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010R\u001a\u00020\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010\u001eH\u0007JN\u0010X\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010\u001eJX\u0010X\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020W\u0018\u00010\u001eJ\u0018\u0010Z\u001a\u00020\u00042\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010\u001eJ\"\u0010Z\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010\u001eJ\u0018\u0010]\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\\\u001a\u0004\u0018\u00010[J\"\u0010_\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010^\u001a\u00020\u000e2\b\u0010\\\u001a\u0004\u0018\u00010[J\u000e\u0010`\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\"\u0010b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010a\u001a\u00020\u000e2\b\b\u0002\u0010^\u001a\u00020\u000eJ\u000e\u0010c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ0\u0010]\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\b\u0010\\\u001a\u0004\u0018\u00010[J6\u0010g\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00162\u0014\u0010d\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0016\u0018\u00010\u001e2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010eJ,\u0010j\u001a\u00020\u00042\u0014\u0010h\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010\u001eJ<\u0010n\u001a\u00020\u00042\u0014\u0010h\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000e\u0010k\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010\u001e2\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020l\u0018\u00010\u001eJ\u0018\u0010q\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020o2\b\u0010'\u001a\u0004\u0018\u00010pJ,\u0010r\u001a\u00020\u00042\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u001eJZ\u0010u\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\u001eJd\u0010u\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\b\b\u0002\u0010v\u001a\u00020\u000e2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\u001eJB\u0010w\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\u001eJD\u0010z\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010x\u001a\b\u0012\u0004\u0012\u00020#0\u00162\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020y\u0018\u00010\u001eJD\u0010{\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010x\u001a\b\u0012\u0004\u0012\u00020#0\u00162\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020y\u0018\u00010\u001eJd\u0010~\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010|\u001a\u00020#2\b\u0010}\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001eJd\u0010\u007f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010|\u001a\u00020#2\b\u0010}\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001eJe\u0010\u0080\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010|\u001a\u00020#2\b\u0010}\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001eJM\u0010\u0081\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010|\u001a\u00020#2\b\u0010}\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\u001eJ8\u0010\u0083\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000f\u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001eJ8\u0010\u0084\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000f\u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001eJ?\u0010\u0085\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001eJ7\u0010\u0086\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001eJJ\u0010\u0089\u0001\u001a\u00020\u00042\u0007\u0010\u0087\u0001\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0007\u0010\u0088\u0001\u001a\u00020#2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000f\u0010\u0082\u0001\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001eJ!\u0010]\u001a\u00020\u00042\u0007\u0010\r\u001a\u00030\u008a\u00012\u0010\b\u0002\u0010\\\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001eJ!\u0010\u008b\u0001\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eJ`\u0010\u008f\u0001\u001a\u00020\u00042\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010\u001eJH\u0010\u0090\u0001\u001a\u00020\u00042\u0006\u0010R\u001a\u00020\u00192\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00192\u0006\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00192\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010\u001eJ'\u0010\u0093\u0001\u001a\u00020\u00042\u0007\u0010\u0091\u0001\u001a\u00020\u00192\u0015\u0010'\u001a\u0011\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0092\u00010\u0016\u0018\u00010\u001eJ\u0018\u0010\u0095\u0001\u001a\u00020\u00042\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030\u0094\u0001\u0018\u00010\u001eJ1\u0010\u0098\u0001\u001a\u00020\u00042\u0007\u0010\u0096\u0001\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030\u0097\u0001\u0018\u00010\u001eJP\u0010\u009b\u0001\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00192\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030\u009a\u0001\u0018\u00010\u001eJ>\u0010\u009d\u0001\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030\u009c\u0001\u0018\u00010\u001eJ:\u0010\u009f\u0001\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030\u009e\u0001\u0018\u00010\u001eJV\u0010¡\u0001\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\u0007\u0010 \u0001\u001a\u00020\u000e2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0014\u0010'\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0016\u0018\u00010\u001eJ#\u0010¤\u0001\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00192\u0007\u0010¢\u0001\u001a\u00020\u00192\t\u0010'\u001a\u0005\u0018\u00010£\u0001J(\u0010¥\u0001\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00192\u0007\u0010¢\u0001\u001a\u00020\u00192\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001eJf\u0010u\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u000b\b\u0002\u0010¦\u0001\u001a\u0004\u0018\u00010\u00192\u000b\b\u0002\u0010§\u0001\u001a\u0004\u0018\u00010#2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0011\b\u0002\u0010'\u001a\u000b\u0012\u0005\u0012\u00030¨\u0001\u0018\u00010\u001e2\t\b\u0002\u0010©\u0001\u001a\u00020\u000e¢\u0006\u0005\bu\u0010ª\u0001Je\u0010«\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010|\u001a\u00020#2\b\u0010}\u001a\u0004\u0018\u00010\u00192\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\u001eJM\u0010¬\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010|\u001a\u00020#2\b\u0010}\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\u001eJd\u0010®\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0007\u0010\u00ad\u0001\u001a\u00020\u000e2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\u001eJn\u0010¯\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u00192\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010|\u001a\u00020#2\b\u0010}\u001a\u0004\u0018\u00010\u00192\u0007\u0010\u00ad\u0001\u001a\u00020\u000e2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020t\u0018\u00010\u001eJc\u0010~\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00192\u000b\b\u0002\u0010¦\u0001\u001a\u0004\u0018\u00010\u00192\u000b\b\u0002\u0010§\u0001\u001a\u0004\u0018\u00010#2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0011\b\u0002\u0010'\u001a\u000b\u0012\u0005\u0012\u00030°\u0001\u0018\u00010\u001e¢\u0006\u0005\b~\u0010±\u0001JN\u0010³\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020#2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0011\b\u0002\u0010'\u001a\u000b\u0012\u0005\u0012\u00030²\u0001\u0018\u00010\u001eJ[\u0010´\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010#2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001c2\u0011\b\u0002\u0010'\u001a\u000b\u0012\u0005\u0012\u00030²\u0001\u0018\u00010\u001e¢\u0006\u0006\b´\u0001\u0010µ\u0001J\u008d\u0001\u0010½\u0001\u001a\u00020\u00042\u0007\u0010¶\u0001\u001a\u00020#2\u0007\u0010·\u0001\u001a\u00020\u00192\u0007\u0010¸\u0001\u001a\u00020\u00192\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010#2\u000b\b\u0002\u0010¹\u0001\u001a\u0004\u0018\u00010\u00192*\b\u0002\u0010\u001d\u001a$\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010º\u0001j\u0011\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u0001`»\u00012\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030¼\u0001\u0018\u00010\u001e¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u008d\u0001\u0010À\u0001\u001a\u00020\u00042\u0007\u0010·\u0001\u001a\u00020\u00192\u0007\u0010¸\u0001\u001a\u00020\u00192\u0007\u0010¿\u0001\u001a\u00020\u00192\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010#2\u000b\b\u0002\u0010¹\u0001\u001a\u0004\u0018\u00010\u00192*\b\u0002\u0010\u001d\u001a$\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u00010º\u0001j\u0011\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0018\u0001`»\u00012\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030¼\u0001\u0018\u00010\u001e¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\"\u0010Ä\u0001\u001a\u00020\u00042\b\u0010Ã\u0001\u001a\u00030Â\u00012\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030¼\u0001\u0018\u00010\u001eJ\"\u0010Æ\u0001\u001a\u00020\u00042\b\u0010Ã\u0001\u001a\u00030Å\u00012\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030¼\u0001\u0018\u00010\u001eJ\"\u0010É\u0001\u001a\u00020\u00042\b\u0010Ã\u0001\u001a\u00030Ç\u00012\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030È\u0001\u0018\u00010\u001eJ\"\u0010Ì\u0001\u001a\u00020\u00042\b\u0010Ã\u0001\u001a\u00030Ê\u00012\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030Ë\u0001\u0018\u00010\u001eJ\"\u0010Ï\u0001\u001a\u00020\u00042\b\u0010Ã\u0001\u001a\u00030Í\u00012\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030Î\u0001\u0018\u00010\u001eJ\"\u0010Ñ\u0001\u001a\u00020\u00042\b\u0010Ã\u0001\u001a\u00030Ð\u00012\u000f\u0010'\u001a\u000b\u0012\u0005\u0012\u00030¼\u0001\u0018\u00010\u001eJ\u001e\u0010Õ\u0001\u001a\u00020\u00042\b\u0010Ó\u0001\u001a\u00030Ò\u00012\u000b\b\u0002\u0010'\u001a\u0005\u0018\u00010Ô\u0001J\u0011\u0010Ö\u0001\u001a\u00020\u000e2\b\u0010Ó\u0001\u001a\u00030Ò\u0001J\u000f\u0010×\u0001\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000f\u0010Ø\u0001\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u0011\u0010Ù\u0001\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0007\u0010Ú\u0001\u001a\u00020\u0004J\u0011\u0010Û\u0001\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0007\u0010Ü\u0001\u001a\u00020\u0004J\u000f\u0010Ý\u0001\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019J%\u0010à\u0001\u001a\u00020\u00192\u0011\b\u0002\u0010'\u001a\u000b\u0012\u0005\u0012\u00030Þ\u0001\u0018\u00010\u001e2\t\b\u0002\u0010ß\u0001\u001a\u00020\u000eJ7\u0010å\u0001\u001a\u00020\u00042\b\u0010â\u0001\u001a\u00030á\u00012\u0011\b\u0002\u0010ã\u0001\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00162\u0011\b\u0002\u0010ä\u0001\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016J\u001b\u0010è\u0001\u001a\u0004\u0018\u00010\u00192\u0007\u0010æ\u0001\u001a\u00020#2\u0007\u0010ç\u0001\u001a\u00020\u0019J-\u0010ë\u0001\u001a\u00020\u00042\r\u0010é\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\u0015\u0010'\u001a\u0011\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00190ê\u0001\u0018\u00010\u001eJK\u0010í\u0001\u001a\u00020\u00042\u000e\u0010é\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190ê\u00012\u0019\u0010ì\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00160\u001c2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u001e¢\u0006\u0006\bí\u0001\u0010î\u0001J\u000f\u0010ï\u0001\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000f\u0010ð\u0001\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000f\u0010ñ\u0001\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010ó\u0001\u001a\u00020\u00042\u0007\u0010ò\u0001\u001a\u00020.J\u0007\u0010ô\u0001\u001a\u00020\u0004J3\u0010ö\u0001\u001a\u00020\u00042\u0007\u0010æ\u0001\u001a\u00020#2\u0007\u0010õ\u0001\u001a\u00020\u00192\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001cJ\u0010\u0010÷\u0001\u001a\u00020\u00042\u0007\u0010õ\u0001\u001a\u00020\u0019J\u009c\u0001\u0010\u0082\u0002\u001a\u00020\u00042\u0011\b\u0002\u0010ø\u0001\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00162\u0011\b\u0002\u0010ù\u0001\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00162\u0011\b\u0002\u0010ú\u0001\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00162Z\b\u0002\u0010\u0081\u0002\u001aS\u0012\u0016\u0012\u00140\u000e¢\u0006\u000f\bü\u0001\u0012\n\bý\u0001\u0012\u0005\b\b(þ\u0001\u0012\u0016\u0012\u00140#¢\u0006\u000f\bü\u0001\u0012\n\bý\u0001\u0012\u0005\b\b(ÿ\u0001\u0012\u0016\u0012\u00140\u0019¢\u0006\u000f\bü\u0001\u0012\n\bý\u0001\u0012\u0005\b\b(\u0080\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010û\u0001J\u000f\u0010\u0083\u0002\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0019J \u0010\u0085\u0002\u001a\u00020\u00042\u0007\u0010\u0084\u0002\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u0019R!\u0010\u008b\u0002\u001a\u00030\u0086\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002R!\u0010\u0090\u0002\u001a\u00030\u008c\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008d\u0002\u0010\u0088\u0002\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002R!\u0010\u0095\u0002\u001a\u00030\u0091\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0092\u0002\u0010\u0088\u0002\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002R!\u0010\u009a\u0002\u001a\u00030\u0096\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0097\u0002\u0010\u0088\u0002\u001a\u0006\b\u0098\u0002\u0010\u0099\u0002R!\u0010\u009f\u0002\u001a\u00030\u009b\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009c\u0002\u0010\u0088\u0002\u001a\u0006\b\u009d\u0002\u0010\u009e\u0002R!\u0010¤\u0002\u001a\u00030 \u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b¡\u0002\u0010\u0088\u0002\u001a\u0006\b¢\u0002\u0010£\u0002R1\u0010§\u0002\u001a\u001c\u0012\u0004\u0012\u00020\u0019\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000e0¦\u00020¥\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b§\u0002\u0010¨\u0002R\u001a\u0010\n\u001a\u00020\u00028\u0006¢\u0006\u000f\n\u0005\b\n\u0010©\u0002\u001a\u0006\bª\u0002\u0010«\u0002¨\u0006°\u0002"}, d2 = {"Lcom/ss/ugc/effectplatform/EffectPlatform;", "", "Lcom/ss/ugc/effectplatform/EffectConfig;", "configuration", "", "checkConfiguration", "Lbytekn/foundation/concurrent/executor/a;", "executorService", "Lcom/ss/ugc/effectplatform/task/q1;", "createTaskManager", "effectConfig", "initCache", "Lcom/ss/ugc/effectplatform/model/Effect;", "effect", "", "isLite", "isEffectDownloadedInternal", "areRequirementsReady", "isFromFullCheck", "isEffectReadyMemoryCache", "markEffectUsedAsync", "markEffectUsedSync", "", "effectList", "getNeedDownloadEffectList", "", EffectConfiguration.KEY_PANEL, "downloadAfterFetch", "", "extraParams", "Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;", "Lcom/ss/ugc/effectplatform/model/EffectChannelResponse;", "iFetchEffectChannelListener", "fetchEffectList", "fetchEffectListFromCache", "", EffectConfiguration.KEY_COUNT, EffectConfiguration.KEY_CURSOR, "Lcom/ss/ugc/effectplatform/model/net/QueryRewardEffectsResponse;", "listener", "fetchRewardEffects", EffectConfiguration.KEY_CATEGORY, "Lcom/ss/ugc/effectplatform/model/CategoryPageModel;", "fetchCustomizedEffects", "Lcom/ss/ugc/effectplatform/model/net/QueryCustomizedEffectsData;", "queryCustomizedEffects", "", EffectConfiguration.KEY_APP_ID, "effectId", "effectSourceId", "fileUrlType", "effectFile", "fileMd5", "iconUrlType", "icon", "effectDescription", "Lcom/ss/ugc/effectplatform/model/net/AddCustomizedEffectResponse;", "addCustomizedEffect", "Lcom/ss/ugc/effectplatform/model/net/GetCustomizedEffectIDData;", "getCustomizedEffectId", "requestUrl", "scene", "oidList", "Lcom/ss/ugc/effectplatform/model/net/ConvertOidToUrlResponse;", "convertOidToUrl", "getCurrentEffectChannel", "effectIds", "resourceIds", "Lcom/ss/ugc/effectplatform/model/net/EffectListResponse;", "fetchEffectListByResourceIds", "host", "inspirationCategory", "insertIds", "enterFrom", "fetchInspirationFeedEffects", "showFilteredEffects", "Lcom/ss/ugc/effectplatform/model/QueryTopChecklistEffectsModel;", "queryTopChecklistEffects", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/Map;Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fetchEffectListByEffectIds", "keyWord", "Lcom/ss/ugc/effectplatform/model/net/SearchEffectResponse;", "searchEffect", "searchId", EffectConfiguration.KEY_SEARCH_KEYWORD, "Lcom/ss/ugc/effectplatform/model/net/SearchEffectResponseV2;", "searchEffects", "Lcom/ss/ugc/effectplatform/model/net/RecommendSearchWordsResponse;", "recommendSearchWords", "Lhlc/d;", "iFetchEffectListener", "fetchEffect", "isCancelDownloading", "fetchEffectFirst", "pauseEffectTask", "isAddFirst", "resumeEffectTask", "cancelEffectTask", "listListener", "Lcom/ss/ugc/effectplatform/model/a;", DBDefinition.EXTRA, "downloadEffectList", "map", "Lcom/ss/ugc/effectplatform/model/ResourceListModel;", "fetchResourceList", "resourceListListener", "Lcom/ss/ugc/effectplatform/model/g;", "resourceDownloadListener", "fetchResourceListWithDownload", "Lcom/ss/ugc/effectplatform/model/ProviderEffect;", "Lhlc/b;", "downloadProviderEffect", "queryVideoUsedStickers", "withCategoryEffects", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "fetchPanelInfo", "hasChildrenCategory", "fetchPanelInfoFromCache", "categoryIds", "Lcom/ss/ugc/effectplatform/model/EffectCategoryModelList;", "fetchCategoryInfo", "fetchCategoryInfoFromCache", "sortingPosition", EffectConfiguration.KEY_VERSION, "fetchCategoryEffect", "fetchCategoryPagingEffect", "fetchCategoryPagingEffectFromCache", "fetchCategoryEffectFromCache", "checkChannelListener", "checkedEffectListUpdate", "checkPanelIsUpdate", "checkCategoryIsUpdate", "checkInfoStickerUpdate", "checkKey", EffectConfiguration.KEY_TYPE, "checkUpdate", "Lcom/ss/ugc/effectplatform/model/EffectQRCode;", "fetchDownloadedEffectList", "providerName", "giphyType", "Lcom/ss/ugc/effectplatform/model/ProviderEffectModel;", "fetchProviderEffect", "searchProviderEffect", "rankingCategory", "Lcom/ss/ugc/effectplatform/model/RankingEffectInfoModel;", "fetchRankingEffectList", "Lcom/ss/ugc/effectplatform/model/RankingDesignerInfoConvertModel;", "fetchRankingDesignerList", "isShowList", "Lcom/ss/ugc/effectplatform/model/RankingCategoryListModel;", "fetchRankingCategoryList", "giphyIds", "Lcom/ss/ugc/effectplatform/model/net/GifProviderEffectListResponse;", "fetchProviderEffectsByGiphyIds", "Lcom/ss/ugc/effectplatform/model/net/FetchHotEffectResponse;", "fetchHotEffect", "Lcom/ss/ugc/effectplatform/model/net/FetchFavoriteListResponse;", "fetchFavoriteList", "isFavorite", "modifyFavoriteList", "updateTime", "Lhlc/f;", "updateTag", "isTagUpdated", "specCategory", "needPersonalRecommend", "Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;", "isThemeApi", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;Z)V", "fetchPanelInfoPaging", "fetchPanelInfoPagingFromCache", "fromCache", "fetchPanelInfoChecked", "fetchPanelInfoPagingChecked", "Lcom/ss/ugc/effectplatform/model/net/CategoryEffectsWithThemeData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;)V", "Lcom/ss/ugc/effectplatform/model/net/QueryInfoStickerResponse;", "queryInfoStickerList", "queryInfoStickerListFromCache", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;)V", "source", "creationId", "imageUri", EffectConfiguration.KEY_PROVIDER_NAME, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Lcom/ss/ugc/effectplatform/model/net/InfoStickerListResponse;", "queryRecommendStickerList", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/HashMap;Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;)V", EffectConfiguration.KEY_SEARCH_WORD, "searchStickerList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/HashMap;Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;)V", "Lcom/ss/ugc/effectplatform/task/g;", "config", "queryRecommendStickerListCS", "Lcom/ss/ugc/effectplatform/task/i;", "searchStickerListCS", "Lcom/ss/ugc/effectplatform/task/k;", "Lcom/ss/ugc/effectplatform/model/net/StickerCategoryListResponse;", "queryStickerCategoryListCS", "Lcom/ss/ugc/effectplatform/task/m;", "Lcom/ss/ugc/effectplatform/model/net/StickerUploadAuthKeyResponse;", "uploadStickerAuthKeyCS", "Lcom/ss/ugc/effectplatform/task/c;", "Lcom/ss/ugc/effectplatform/model/net/CustomizedStickerCreateResponse;", "createCustomizedStickerCS", "Lcom/ss/ugc/effectplatform/task/e;", "queryCustomizedStickerListCS", "Lcom/ss/ugc/effectplatform/model/net/InfoStickerEffect;", "sticker", "Lcom/ss/ugc/effectplatform/listener/IDownloadInfoStickerEffectProgressListener;", "downloadInfoStickerEffect", "isInfoStickerEffectDownloaded", "isEffectDownloaded", "isEffectDownloading", "deleteEffect", "clearEffects", "clearCache", "removeAllListener", "clearVersion", "Lcom/ss/ugc/effectplatform/model/net/EffectListPreloadResponse;", "requestWithGlExtension", "preFetchEffectInfo", "Lcom/ss/ugc/effectplatform/model/net/PreloadedEffectsRecord;", "preloadedRecord", "effectIdWhiteList", "modelsIdWhiteList", "recordPreloadedEffects", "businessId", "modelName", "findResourceUri", "requirements", "", "fetchResourcesNeededByRequirements", "modelNames", "fetchResourcesByRequirementsAndModelNames", "([Ljava/lang/String;Ljava/util/Map;Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;)V", "isEffectReady", "isEffectReadyLite", "markEffectUsed", "time", "removeUnused", "destroy", "businessKey", "preloadResource", "pausePreload", "allowList", "md5AllowList", "clearList", "Lkotlin/Function3;", "Lkotlin/ParameterName;", DBDefinition.NAME, "isSuccess", "errorCode", "errorMsg", "onFinish", "cleanResourcesByServerStrategyWithAllowList", "onEnterScene", "suc", "onEffectUsed", "Lcom/ss/ugc/effectplatform/repository/EffectRepository;", "effectRepository$delegate", "Lkotlin/Lazy;", "getEffectRepository", "()Lcom/ss/ugc/effectplatform/repository/EffectRepository;", "effectRepository", "Lcom/ss/ugc/effectplatform/repository/e;", "effectListRepository$delegate", "getEffectListRepository", "()Lcom/ss/ugc/effectplatform/repository/e;", "effectListRepository", "Lcom/ss/ugc/effectplatform/repository/l;", "userEffectRepository$delegate", "getUserEffectRepository", "()Lcom/ss/ugc/effectplatform/repository/l;", "userEffectRepository", "Lcom/ss/ugc/effectplatform/repository/AlgorithmRepository;", "algorithmRepository$delegate", "getAlgorithmRepository", "()Lcom/ss/ugc/effectplatform/repository/AlgorithmRepository;", "algorithmRepository", "Lcom/ss/ugc/effectplatform/repository/k;", "resourceRepository$delegate", "getResourceRepository", "()Lcom/ss/ugc/effectplatform/repository/k;", "resourceRepository", "Lcom/ss/ugc/effectplatform/repository/h;", "effectListStore$delegate", "getEffectListStore", "()Lcom/ss/ugc/effectplatform/repository/h;", "effectListStore", "Lz/b;", "Lkotlin/Pair;", "checkMemoryMap", "Lz/b;", "Lcom/ss/ugc/effectplatform/EffectConfig;", "getEffectConfig", "()Lcom/ss/ugc/effectplatform/EffectConfig;", "<init>", "(Lcom/ss/ugc/effectplatform/EffectConfig;)V", "Companion", "b", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class EffectPlatform {
    public static final b Companion = null;
    private static final String SDK_TAG = "EffectPlatform";
    private final Lazy algorithmRepository$delegate;
    private final z.b<String, Pair<Long, Boolean>> checkMemoryMap;
    private final EffectConfig effectConfig;
    private final Lazy effectListRepository$delegate;
    private final Lazy effectListStore$delegate;
    private final Lazy effectRepository$delegate;
    private final Lazy resourceRepository$delegate;
    private final Lazy userEffectRepository$delegate;

    public static final class a implements j {
        public a() {
        }

        @Override // com.ss.ugc.effectplatform.j
        public final String decrypt(String r2) {
            return EffectPlatformAES.a(r2, (byte[]) EffectPlatformAES.c.getValue());
        }

        @Override // com.ss.ugc.effectplatform.j
        public final String decrypt(String r3, String r4) {
            String r0 = EffectPlatformAES.a;
            if (StringsKt.isBlank(r4) == true) goto L11;
            String r5 = bytekn.foundation.encryption.b.a(d.a(ByteArrayExKt.a(r4 + ":android")));
            if (r5 == null) goto L10;
            return EffectPlatformAES.a(r3, ByteArrayExKt.a(r5.substring(8, 24)));
        L10:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        L11:
            return EffectPlatformAES.a(r3, (byte[]) EffectPlatformAES.c.getValue());
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class i implements IEffectPlatformBaseListener<EffectChannelResponse> {
        public final /* synthetic */ EffectPlatform a;
        public final /* synthetic */ IEffectPlatformBaseListener b;

        @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
        public final void onSuccess(EffectChannelResponse r2) {
            EffectChannelResponse r3 = r2;
            EffectPlatform.access$getEffectListStore$p(this.a).a.a = r3;
            IEffectPlatformBaseListener r0 = this.b;
            if (r0 == null) goto L6;
            r0.onSuccess(r3);
            return;
        }

        public i(EffectPlatform r1, IEffectPlatformBaseListener r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
        public final void onFail(EffectChannelResponse r2, ExceptionResult r3) {
            EffectChannelResponse r4 = r2;
            IEffectPlatformBaseListener r0 = this.b;
            if (r0 == null) goto L6;
            r0.onFail(r4, r3);
            return;
        }
    }

    private final AlgorithmRepository getAlgorithmRepository() {
        return (AlgorithmRepository) this.algorithmRepository$delegate.getValue();
    }

    private final e getEffectListRepository() {
        return (e) this.effectListRepository$delegate.getValue();
    }

    private final com.ss.ugc.effectplatform.repository.h getEffectListStore() {
        return (com.ss.ugc.effectplatform.repository.h) this.effectListStore$delegate.getValue();
    }

    private final EffectRepository getEffectRepository() {
        return (EffectRepository) this.effectRepository$delegate.getValue();
    }

    private final com.ss.ugc.effectplatform.repository.k getResourceRepository() {
        return (com.ss.ugc.effectplatform.repository.k) this.resourceRepository$delegate.getValue();
    }

    private final l getUserEffectRepository() {
        return (l) this.userEffectRepository$delegate.getValue();
    }

    static {
        Companion = new b();
        SDK_TAG = "EffectPlatform";
    }

    public final void destroy() {
        q1 r0 = this.effectConfig.D;
        if (r0 != null) goto L5;
    L11:
        this.effectConfig.M.getClass();
        com.ss.ugc.effectplatform.repository.d.b.clear();
        this.effectConfig.N.a.clear();
        return;
    L5:
        if ((!r0.b.isEmpty()) == false) goto L10;
        Iterator r1 = r0.b.entrySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) r1.next();
        String r3 = (String) r2.getKey();
        ((c) r2.getValue()).cancel();
    L10:
        r0.b.clear();
        goto L11
    }

    public final void removeAllListener() {
        this.effectConfig.N.a.clear();
    }

    public final void clearEffects() {
        c r1 = new c(this, q.a());
        q1 r0 = this.effectConfig.D;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public final EffectChannelResponse getCurrentEffectChannel() {
        return (EffectChannelResponse) getEffectListStore().a.a;
    }

    public final EffectConfig getEffectConfig() {
        return this.effectConfig;
    }

    public EffectPlatform(EffectConfig r2) {
        this.effectConfig = r2;
        this.effectRepository$delegate = LazyKt.lazy(new EffectPlatform$effectRepository$2(this));
        this.effectListRepository$delegate = LazyKt.lazy(new EffectPlatform$effectListRepository$2(this));
        this.userEffectRepository$delegate = LazyKt.lazy(new EffectPlatform$userEffectRepository$2(this));
        this.algorithmRepository$delegate = LazyKt.lazy(new EffectPlatform$algorithmRepository$2(this));
        this.resourceRepository$delegate = LazyKt.lazy(new EffectPlatform$resourceRepository$2(this));
        this.effectListStore$delegate = LazyKt.lazy(EffectPlatform$effectListStore$2.INSTANCE);
        checkConfiguration(r2);
        if (r2.D != null) goto L5;
        r2.D = createTaskManager(r2.x);
    L5:
        initCache(r2);
        int r0 = n.a;
        PlatformType r1 = PlatformType.ANDROID;
        String r3 = EffectPlatformAES.a;
        a0.b<klc.a> r4 = EffectPlatformAES.b;
        r4.a = r2.v.a;
        j r5 = f.a;
        f.a = new a();
        this.checkMemoryMap = new z.b(true);
    }

    public static final /* synthetic */ e access$getEffectListRepository$p(EffectPlatform r0) {
        return r0.getEffectListRepository();
    }

    public static final /* synthetic */ com.ss.ugc.effectplatform.repository.h access$getEffectListStore$p(EffectPlatform r0) {
        return r0.getEffectListStore();
    }

    public static final /* synthetic */ com.ss.ugc.effectplatform.repository.k access$getResourceRepository$p(EffectPlatform r0) {
        return r0.getResourceRepository();
    }

    private final boolean areRequirementsReady(Effect r2) {
        return getAlgorithmRepository().a(r2);
    }

    private final void checkConfiguration(EffectConfig r8) {
        if (r8 == null) goto L25;
        if (r8.E == null) goto L23;
        if (r8.t == null) goto L21;
        int r0 = r.a;
        if (r.b(r8.i) == true) goto L19;
        String r1 = FileManager.a;
        if (FileManager.d(r8.i) == true) goto L15;
        FileManager.i(r8.i);
        if (FileManager.d(r8.i) == true) goto L15;
        Logger.e$default(Logger.INSTANCE, SDK_TAG, "Cache directory error" + r8.i, null, 4, null);
    L15:
        if (FileManager.d(r8.K) == true) goto L26;
        FileManager.i(r8.K);
        return;
    L26:
        return;
    L19:
        throw new IllegalArgumentException("EffectConfiguration Error! Cache directory error");
    L21:
        throw new IllegalArgumentException("EffectConfiguration Error! Not set json convert");
    L23:
        throw new IllegalArgumentException("EffectConfiguration Error! Not set host !!!");
    L25:
        throw new IllegalArgumentException("EffectConfiguration Error! Not set configuration");
    }

    private final q1 createTaskManager(bytekn.foundation.concurrent.executor.a r3) {
        q1.a r0 = new q1.a();
        r0.b = this.effectConfig.y;
        if (r3 != null) goto L6;
        r3 = new AsyncExecutor();
    L6:
        r0.a = r3;
        return r0.a();
    }

    private final List<Effect> getNeedDownloadEffectList(List<? extends Effect> r5) {
        ArrayList r0 = new ArrayList();
        Iterator<? extends Effect> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Effect r1 = r6.next();
        com.ss.ugc.effectplatform.repository.d r2 = this.effectConfig.M;
        String r3 = com.ss.ugc.effectplatform.model.b.a(r1);
        r2.getClass();
        if (com.ss.ugc.effectplatform.repository.d.c(r3) == true) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    private final void initCache(EffectConfig r9) {
        String r0 = r9.i;
        String r1 = FileManager.a;
        if (FileManager.d(r0) == true) goto L7;
        FileManager.i(r9.i);
        if (FileManager.d(r9.i) == true) goto L7;
        Logger.e$default(Logger.INSTANCE, SDK_TAG, "Cache directory error" + r9.i, null, 4, null);
    L7:
        Object r2 = r9.A.a;
        if (r2 == null) goto L10;
        z.b<String, com.ss.ugc.effectplatform.cache.j> r3 = com.ss.ugc.effectplatform.cache.h.a;
        com.ss.ugc.effectplatform.cache.h.a.put(r0, (com.ss.ugc.effectplatform.cache.j) r2);
    L20:
        if (r9.T == false) goto L25;
        Object r10 = r9.G;
        if (r10 == null) goto L26;
        com.ss.ugc.effectplatform.preload.b.d.getClass();
        com.ss.ugc.effectplatform.preload.b.a.a(r10);
        return;
    L26:
        return;
    L25:
        return;
    L10:
        if (com.ss.ugc.effectplatform.cache.h.a(r0) != null) goto L12;
        com.ss.ugc.effectplatform.cache.h.a.put(r0, new com.ss.ugc.effectplatform.cache.i(r9));
    L12:
        List<String> r4 = r9.F;
        if (r4 == null) goto L17;
        com.ss.ugc.effectplatform.cache.j r5 = com.ss.ugc.effectplatform.cache.h.a(r0);
        if (r5 == null) goto L17;
        r5.c(r4);
    L17:
        r9.A.a = com.ss.ugc.effectplatform.cache.h.a(r0);
        goto L20
    }

    private final void markEffectUsedAsync(Effect r5) {
        if (a0.a.a() == true) goto L5;
        markEffectUsedSync(r5);
        return;
    L5:
        q1 r0 = this.effectConfig.D;
        if (r0 == null) goto L10;
        r0.a(new b0(q.a(), new markEffectUsedAsync.1(this, r5)));
        return;
    }

    private final void markEffectUsedSync(Effect r10) {
        EffectRepository r0 = getEffectRepository();
        if (((com.ss.ugc.effectplatform.cache.j) r0.d.A.a) != null) goto L5;
    L19:
        AlgorithmRepository r1 = getAlgorithmRepository();
        r1.getClass();
        Logger r2 = Logger.INSTANCE;
        r2.d("AlgorithmRepository", "effect: " + r10.getEffect_id() + ", name: " + r10.getName() + " markModelUsed");
        if (com.ss.ugc.effectplatform.util.a.b(r10) == false) goto L22;
        Logger.e$default(r2, "AlgorithmRepository", "decrypt error effect: " + r10.getEffect_id() + ", name: " + r10.getName() + ", requirements_sec: " + r10.getRequirements_sec(), null, 4, null);
        return;
    L22:
        EffectConfig r3 = r1.f;
        String[] r4 = com.ss.ugc.effectplatform.util.a.a(r10, r3.t, r3.G);
        int r6 = 0;
        boolean r7 = true;
        if (r4 != null) goto L25;
    L31:
        if (r7 == false) goto L33;
        r2.d("AlgorithmRepository", "effect: " + r10.getEffect_id() + ", name: " + r10.getName() + " returned empty resourceNameArrayOfEffect");
        return;
    L33:
        r1.c.e();
        int r11 = r4.length;
    L34:
        if (r6 >= r11) goto L39;
        String r5 = r4[r6];
        Logger.INSTANCE.d("AlgorithmRepository", "markModelUsed: resourceName: " + r5);
        r1.e().markModelUsed(r5);
        r6 = r6 + 1;
        goto L34
    L39:
        return;
    L25:
        if (r4.length != 0) goto L27;
        boolean r8 = true;
    L28:
        if (r8 == true) goto L31;
        r7 = false;
        goto L31
    L27:
        r8 = false;
        goto L28
    L5:
        if (StringsKt.isBlank(r10.getUnzipPath()) == true) goto L19;
        String r9 = FileManager.a;
        String r12 = FileManager.e(r10.getUnzipPath());
        if (r12 == null) goto L12;
        com.ss.ugc.effectplatform.cache.j r13 = (com.ss.ugc.effectplatform.cache.j) r0.d.A.a;
        if (r13 == null) goto L12;
        com.ss.ugc.effectplatform.cache.disklrucache.a.w.getClass();
        r13.d(com.ss.ugc.effectplatform.cache.disklrucache.a.C0011a.c(r12));
    L12:
        EffectConfig r14 = r0.d;
        if (r14.Z == false) goto L19;
        if (r14.b0 == false) goto L19;
        com.ss.ugc.effectplatform.cache.l.a r15 = com.ss.ugc.effectplatform.cache.l.c;
        Object r16 = r14.G;
        r15.getClass();
        if (com.ss.ugc.effectplatform.cache.l.a.a(r16) == null) goto L19;
        new com.ss.ugc.effectplatform.cache.k(r10);
        goto L19
    }

    public final void cancelEffectTask(Effect r10) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r11 = com.ss.ugc.effectplatform.model.b.a(r10);
        if (r.b(r11) == true) goto L25;
        String r1 = (String) r0.a.get(r11);
        if (r1 == null) goto L29;
        q1 r2 = r0.d.D;
        if (r2 == null) goto L20;
        c r3 = (c) r2.b.get(r1);
        if (r3 == null) goto L11;
        Logger.INSTANCE.w("JKL", "[取消][TaskManager][执行队列][" + r1 + ']');
        r3.cancel();
        goto L20
    L11:
        c r4 = (c) r2.g.get(r1);
        if (r4 == null) goto L14;
        Logger.INSTANCE.w("JKL", "[取消][TaskManager][等待队列][" + r1 + ']');
        r4.cancel();
        r2.g.remove(r1);
        goto L20
    L14:
        Iterator r5 = r2.c.iterator();
    L16:
        if (r5.hasNext() == false) goto L20;
        c r7 = (c) r5.next();
        if (Intrinsics.areEqual(r7.getId(), r1) == false) goto L16;
        Logger.INSTANCE.d("JKL", "[取消][TaskManager][等待队列][" + r1 + ']');
        r7.cancel();
        r2.c.remove(r7);
    L20:
        z.b<String, String> r6 = r0.a;
        if (r6 == null) goto L24;
        String r12 = (String) TypeIntrinsics.asMutableMap(r6).remove(r11);
        return;
    L24:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L29:
        return;
    }

    public final void clearCache(String r5) {
        if (r5 == null) goto L23;
        com.ss.ugc.effectplatform.cache.j r0 = (com.ss.ugc.effectplatform.cache.j) this.effectConfig.A.a;
        if (r0 == null) goto L6;
        int r2 = com.ss.ugc.effectplatform.util.f.a;
        r0.removePattern("effectchannel" + r5 + "(.*)");
    L6:
        com.ss.ugc.effectplatform.cache.j r1 = (com.ss.ugc.effectplatform.cache.j) this.effectConfig.A.a;
        if (r1 == null) goto L9;
        int r3 = com.ss.ugc.effectplatform.util.f.a;
        r1.removePattern(r5 + FileManager.a + "effect_version(.*)");
    L9:
        com.ss.ugc.effectplatform.cache.j r4 = (com.ss.ugc.effectplatform.cache.j) this.effectConfig.A.a;
        if (r4 == null) goto L12;
        int r6 = com.ss.ugc.effectplatform.util.f.a;
        r4.removePattern(r5 + FileManager.a + "effectchannel(.*)");
    L12:
        com.ss.ugc.effectplatform.cache.j r7 = (com.ss.ugc.effectplatform.cache.j) this.effectConfig.A.a;
        if (r7 == null) goto L15;
        int r8 = com.ss.ugc.effectplatform.util.f.a;
        r7.removePattern(r5 + FileManager.a + "category_version(.*)");
    L15:
        com.ss.ugc.effectplatform.cache.j r9 = (com.ss.ugc.effectplatform.cache.j) this.effectConfig.A.a;
        if (r9 == null) goto L18;
        int r10 = com.ss.ugc.effectplatform.util.f.a;
        r9.removePattern("effectchannelinfosticker" + r5 + "(.*)");
    L18:
        com.ss.ugc.effectplatform.cache.j r11 = (com.ss.ugc.effectplatform.cache.j) this.effectConfig.A.a;
        if (r11 == null) goto L21;
        int r12 = com.ss.ugc.effectplatform.util.f.a;
        r11.removePattern(r5 + FileManager.a + "info_sticker_version(.*)");
    L21:
        clearVersion(r5);
        return;
    }

    public final void clearVersion(String r4) {
        com.ss.ugc.effectplatform.cache.j r0 = (com.ss.ugc.effectplatform.cache.j) this.effectConfig.A.a;
        if (r0 == null) goto L6;
        r0.remove("effect_version" + r4);
        return;
    }

    public final void deleteEffect(Effect r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.ss.ugc.effectplatform.cache.j r0 = (com.ss.ugc.effectplatform.cache.j) this.effectConfig.A.a;
        if (r0 == null) goto L7;
        r0.remove(r3.getId());
    L7:
        com.ss.ugc.effectplatform.cache.j r1 = (com.ss.ugc.effectplatform.cache.j) this.effectConfig.A.a;
        if (r1 == null) goto L11;
        r1.remove(r3.getId() + ".zip");
        return;
    }

    public final void fetchRankingDesignerList(IEffectPlatformBaseListener<RankingDesignerInfoConvertModel> r4) {
        e r0 = getEffectListRepository();
        r0.getClass();
        String r1 = q.a();
        if (r4 == null) goto L5;
        r0.a.N.b(r1, r4);
    L5:
        c r5 = new e0(r0.a, r1);
        q1 r2 = r0.a.D;
        if (r2 == null) goto L9;
        r2.a(r5);
        return;
    }

    public final boolean isEffectDownloaded(Effect r2) {
        int r0 = h.a;
        return isEffectDownloadedInternal(r2, false);
    }

    public final boolean isEffectDownloading(Effect r4) {
        com.ss.ugc.effectplatform.util.h.a.getClass();
        if (r4 != null) goto L5;
        boolean r2 = false;
    L6:
        if (r2 == false) goto L11;
        com.ss.ugc.effectplatform.repository.d r3 = this.effectConfig.M;
        String r5 = r4.getEffect_id();
        r3.getClass();
        if (com.ss.ugc.effectplatform.repository.d.c(r5) == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L5:
        r2 = !com.ss.ugc.effectplatform.util.h.c(r4.getFile_url());
        goto L6
    }

    public final boolean isEffectReady(Effect r7) {
        int r0 = h.a;
        if (isEffectReadyMemoryCache(r7, true) == false) goto L5;
        return true;
    L5:
        int r1 = b0.a.a;
        System.currentTimeMillis();
        boolean r2 = false;
        if (isEffectDownloadedInternal(r7, false) == false) goto L8;
        System.currentTimeMillis();
        r2 = areRequirementsReady(r7);
    L8:
        if (r2 == false) goto L10;
        this.checkMemoryMap.put(r7.getEffect_id(), new Pair(Long.valueOf(System.currentTimeMillis()), Boolean.TRUE));
    L10:
        int r3 = bytekn.foundation.logger.a.a;
        r7.getEffect_id();
        r7.getName();
        r7.getPanel();
        System.currentTimeMillis();
        System.currentTimeMillis();
        ThreadMethodProxy.currentThread().getName();
        return r2;
    }

    public final boolean isEffectReadyLite(Effect r2) {
        int r0 = h.a;
        return isEffectReady(r2);
    }

    public final boolean isInfoStickerEffectDownloaded(InfoStickerEffect r20) {
        Integer r0 = r20.getSource();
        if (r0 == null) goto L9;
        if (r0.intValue() != 1) goto L9;
        return isEffectDownloaded(r20.getLoki_effect());
    L9:
        if (r0 != null) goto L12;
        return false;
    L12:
        if (r0.intValue() != 2) goto L26;
        EffectRepository r1 = getEffectRepository();
        ProviderEffect r3 = r20.getSticker();
        r1.getClass();
        int r4 = r.a;
        if (r.b(r3.getPath()) == false) goto L24;
        com.ss.ugc.effectplatform.util.h.a.getClass();
        String r5 = com.ss.ugc.effectplatform.util.h.b(r3);
        int r10 = StringsKt.lastIndexOf$default(r5, "/", 0, false, 6, null);
        int r11 = StringsKt.lastIndexOf$default(r5, ".", 0, false, 6, null);
        int r6 = StringsKt.lastIndexOf$default(r5, "?", 0, false, 6, null);
        if (1 > r10) goto L22;
        if (r11 <= r10) goto L22;
        if (r11 < r6) goto L21;
        r6 = r5.length();
    L21:
        String r2 = r5.substring(r11, r6);
    L23:
        r3.setPath(r1.d.i + FileManager.a + r3.getId() + ("_" + r5.hashCode()) + r2);
    L22:
        r2 = "";
    L24:
        String r7 = FileManager.a;
        return FileManager.d(r3.getPath());
    L26:
        return false;
    }

    public final void markEffectUsed(Effect r7) {
        int r0 = b0.a.a;
        long r1 = System.currentTimeMillis();
        if (this.effectConfig.X == false) goto L5;
        markEffectUsedAsync(r7);
        Logger.INSTANCE.d("JKL-markEffectUsed", "markEffectUsedAsync, time cost: " + (System.currentTimeMillis() - r1));
        return;
    L5:
        markEffectUsedSync(r7);
        Logger.INSTANCE.d("JKL-markEffectUsed", "markEffectUsedSync, time cost: " + (System.currentTimeMillis() - r1));
    }

    public final void onEnterScene(String r4) {
        if (com.ss.ugc.effectplatform.task.algorithm.a.c == true) goto L5;
        return;
    L5:
        q1 r0 = this.effectConfig.D;
        if (r0 == null) goto L9;
        r0.b("EnterScene", new com.ss.ugc.effectplatform.task.b(new onEnterScene.1(this, r4)));
        return;
    }

    public final void pauseEffectTask(Effect r8) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r9 = com.ss.ugc.effectplatform.model.b.a(r8);
        if (r.b(r9) == true) goto L21;
        String r10 = (String) r0.a.get(r9);
        if (r10 == null) goto L22;
        q1 r1 = r0.d.D;
        if (r1 == null) goto L23;
        c r2 = (c) r1.b.get(r10);
        if (r2 == null) goto L11;
        Logger.INSTANCE.w("JKL", "[暂停][TaskManager][执行队列][" + r10 + ']');
        r2.pause();
        r1.g.put(r10, r2);
        return;
    L11:
        Iterator r3 = r1.c.iterator();
    L13:
        if (r3.hasNext() == false) goto L25;
        c r4 = (c) r3.next();
        if (Intrinsics.areEqual(r4.getId(), r10) == false) goto L13;
        Logger.INSTANCE.d("JKL", "[暂停][TaskManager][等待队列][" + r10 + ']');
        r4.pause();
        r1.c.remove(r4);
        return;
    L25:
        return;
    L23:
        return;
    L22:
        return;
    }

    public final void pausePreload(String r4) {
        getEffectListRepository().getClass();
        com.ss.ugc.effectplatform.preload.h.d = false;
        Iterator r0 = com.ss.ugc.effectplatform.preload.h.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        b1 r1 = (b1) r0.next();
        if (Intrinsics.areEqual(r1.k, r4) == false) goto L4;
        r1.pause();
        goto L4
    }

    public final void recommendSearchWords(IEffectPlatformBaseListener<RecommendSearchWordsResponse> r3) {
        getEffectRepository().d(null, r3);
    }

    public final void removeUnused(long r2) {
        getEffectRepository().e(r2);
        getAlgorithmRepository().f(r2);
    }

    public static final /* synthetic */ List access$getNeedDownloadEffectList(EffectPlatform r0, List r1) {
        return r0.getNeedDownloadEffectList(r1);
    }

    public static final /* synthetic */ void access$markEffectUsedSync(EffectPlatform r0, Effect r1) {
        r0.markEffectUsedSync(r1);
    }

    private final boolean isEffectDownloadedInternal(Effect r10, boolean r11) {
        if (this.effectConfig.T == false) goto L10;
        StringBuilder r0 = new StringBuilder();
        r0.append(this.effectConfig.j);
        String r2 = FileManager.a;
        r0.append(FileManager.a);
        r0.append(r10.getId());
        String r1 = r0.toString();
        if (FileManager.d(r1) == false) goto L10;
        com.ss.ugc.effectplatform.util.h.a.getClass();
        if ((!com.ss.ugc.effectplatform.util.h.c(r10.getFile_url())) == false) goto L10;
        Logger.e$default(Logger.INSTANCE, "JKL", "[预加载][读取][特效][检测到已有预加载资源!][" + r10.getId() + ']', null, 4, null);
        r10.setUnzipPath(r1);
        return true;
    L10:
        EffectConfig r3 = this.effectConfig;
        if (r3.b0 == false) goto L19;
        Object r4 = r3.G;
        if (r4 == null) goto L15;
        com.ss.ugc.effectplatform.cache.l.c.getClass();
        com.ss.ugc.effectplatform.cache.l r5 = com.ss.ugc.effectplatform.cache.l.a.a(r4);
    L16:
        if (r5 == null) goto L19;
        new com.ss.ugc.effectplatform.cache.k(r10);
        goto L19
    L15:
        r5 = null;
    L19:
        if (StringsKt.isBlank(r10.getUnzipPath()) == false) goto L21;
        return false;
    L21:
        getEffectRepository().b(r10, true, false, false, null);
        com.ss.ugc.effectplatform.repository.d r6 = this.effectConfig.M;
        z.b<String, Effect> r7 = com.ss.ugc.effectplatform.repository.d.a;
        Boolean r8 = Boolean.FALSE;
        r6.getClass();
        if (com.ss.ugc.effectplatform.repository.d.b(r10, r11, r8) == false) goto L26;
        com.ss.ugc.effectplatform.util.h.a.getClass();
        if ((!com.ss.ugc.effectplatform.util.h.c(r10.getFile_url())) == false) goto L26;
        return true;
    L26:
        return false;
    }

    private final boolean isEffectReadyMemoryCache(Effect r1, boolean r2) {
        int r3 = b0.a.a;
        System.currentTimeMillis();
        int r4 = h.a;
        return false;
    }

    public final void createCustomizedStickerCS(com.ss.ugc.effectplatform.task.c r3, IEffectPlatformBaseListener<CustomizedStickerCreateResponse> r4) {
        e r5 = getEffectListRepository();
        r5.getClass();
        String r0 = q.a();
        if (r4 == null) goto L5;
        r5.a.N.b(r0, r4);
    L5:
        c r6 = new com.ss.ugc.effectplatform.task.d(r5.a, r0);
        q1 r7 = r5.a.D;
        if (r7 == null) goto L9;
        r7.a(r6);
        return;
    }

    public final void downloadInfoStickerEffect(InfoStickerEffect r7, IDownloadInfoStickerEffectProgressListener r8) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        Integer r1 = r7.getSource();
        if (r1 != null) goto L6;
    L8:
        if (r1 != null) goto L11;
    L15:
        if (r8 == null) goto L21;
        r8.onFail(r7, new ExceptionResult(new IllegalArgumentException("sticker source illegal")));
        return;
    L21:
        return;
    L11:
        if (r1.intValue() != 2) goto L15;
        ProviderEffect r2 = r7.getSticker();
        com.ss.ugc.effectplatform.repository.j r3 = new com.ss.ugc.effectplatform.repository.j(r8, r7);
        String r9 = q.a();
        r0.d.N.b(r9, r3);
        EffectConfig r4 = r0.d;
        c r10 = new DownloadInfoProviderEffectTask(r4, r2, r9);
        q1 r11 = r4.D;
        if (r11 == null) goto L19;
        r11.a(r10);
        return;
    L19:
        return;
    L6:
        if (r1.intValue() != 1) goto L8;
        r0.b(r7.getLoki_effect(), false, false, false, new com.ss.ugc.effectplatform.repository.i(r8, r7));
    }

    public final void downloadProviderEffect(ProviderEffect r4, hlc.b r5) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r1 = q.a();
        if (r5 == null) goto L5;
        r0.d.N.b(r1, r5);
    L5:
        EffectConfig r2 = r0.d;
        c r6 = new DownloadProviderEffectTask(r2, r4, r1);
        q1 r7 = r2.D;
        if (r7 == null) goto L9;
        r7.a(r6);
        return;
    }

    public final void fetchDownloadedEffectList(String r2, IEffectPlatformBaseListener<EffectChannelResponse> r3) {
        if (r.b(r2) == true) goto L5;
        getEffectListRepository().e(r2, r3);
        return;
    L5:
        getEffectListRepository().e("default", r3);
    }

    public final void fetchEffect(EffectQRCode r4, IEffectPlatformBaseListener<Effect> r5) {
        f r0 = new f(this, r5);
        e r6 = getEffectListRepository();
        r6.getClass();
        String r1 = q.a();
        r6.a.N.b(r1, r0);
        c r2 = new f0(r6.a, r4, r1);
        q1 r7 = r6.a.D;
        if (r7 == null) goto L6;
        r7.a(r2);
        return;
    }

    public final void fetchEffectListFromCache(String r4, IEffectPlatformBaseListener<EffectChannelResponse> r5) {
        i r0 = new i(this, r5);
        if (r.b(r4) == true) goto L5;
        getEffectListRepository().f(r4, true, null, r0);
        return;
    L5:
        getEffectListRepository().f("default", true, null, r0);
    }

    public final void fetchRankingEffectList(String r4, IEffectPlatformBaseListener<List<RankingEffectInfoModel>> r5) {
        e r0 = getEffectListRepository();
        r0.getClass();
        String r1 = q.a();
        if (r5 == null) goto L5;
        r0.a.N.b(r1, r5);
    L5:
        c r6 = new g0(r0.a, r1, r4);
        q1 r7 = r0.a.D;
        if (r7 == null) goto L9;
        r7.a(r6);
        return;
    }

    public final void fetchResourceList(Map<String, String> r4, IEffectPlatformBaseListener<ResourceListModel> r5) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r1 = q.a();
        if (r5 == null) goto L5;
        r0.d.N.b(r1, r5);
    L5:
        EffectConfig r6 = r0.d;
        q1 r2 = r6.D;
        if (r2 == null) goto L9;
        r2.a(new u0(r6, r1, r4));
        return;
    }

    public final void fetchResourcesNeededByRequirements(List<String> r5, IEffectPlatformBaseListener<String[]> r6) {
        AlgorithmRepository r0 = getAlgorithmRepository();
        q1 r1 = r0.f.D;
        if (r1 == null) goto L6;
        r1.a(new com.ss.ugc.effectplatform.repository.b(r0, r5, r6, q.a()));
        return;
    }

    public final String findResourceUri(int r3, String r4) {
        return getAlgorithmRepository().e().realFindResourceUri(r3, null, r4);
    }

    public final String preFetchEffectInfo(IEffectPlatformBaseListener<EffectListPreloadResponse> r4, boolean r5) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r1 = q.a();
        if (r4 == null) goto L5;
        r0.d.N.b(r1, r4);
    L5:
        EffectConfig r6 = r0.d;
        q1 r2 = r6.D;
        if (r2 == null) goto L8;
        r2.a(new z0(r6, r1, r5));
    L8:
        return r1;
    }

    public final void queryCustomizedStickerListCS(com.ss.ugc.effectplatform.task.e r3, IEffectPlatformBaseListener<InfoStickerListResponse> r4) {
        e r5 = getEffectListRepository();
        r5.getClass();
        String r0 = q.a();
        if (r4 == null) goto L5;
        r5.a.N.b(r0, r4);
    L5:
        c r6 = new com.ss.ugc.effectplatform.task.f(r5.a, r0);
        q1 r7 = r5.a.D;
        if (r7 == null) goto L9;
        r7.a(r6);
        return;
    }

    public final void queryRecommendStickerListCS(g r3, IEffectPlatformBaseListener<InfoStickerListResponse> r4) {
        e r5 = getEffectListRepository();
        r5.getClass();
        String r0 = q.a();
        if (r4 == null) goto L5;
        r5.a.N.b(r0, r4);
    L5:
        c r6 = new com.ss.ugc.effectplatform.task.h(r5.a, r0);
        q1 r7 = r5.a.D;
        if (r7 == null) goto L9;
        r7.a(r6);
        return;
    }

    public final void queryStickerCategoryListCS(com.ss.ugc.effectplatform.task.k r3, IEffectPlatformBaseListener<StickerCategoryListResponse> r4) {
        e r5 = getEffectListRepository();
        r5.getClass();
        String r0 = q.a();
        if (r4 == null) goto L5;
        r5.a.N.b(r0, r4);
    L5:
        c r6 = new com.ss.ugc.effectplatform.task.l(r5.a, r0);
        q1 r7 = r5.a.D;
        if (r7 == null) goto L9;
        r7.a(r6);
        return;
    }

    public final void queryVideoUsedStickers(Map<String, String> r4, IEffectPlatformBaseListener<EffectListResponse> r5) {
        e r0 = getEffectListRepository();
        r0.getClass();
        String r1 = q.a();
        if (r5 == null) goto L5;
        r0.a.N.b(r1, r5);
    L5:
        c r6 = new h1(r0.a, r4, r1);
        q1 r7 = r0.a.D;
        if (r7 == null) goto L9;
        r7.a(r6);
        return;
    }

    public final void recommendSearchWords(String r2, IEffectPlatformBaseListener<RecommendSearchWordsResponse> r3) {
        getEffectRepository().d(r2, r3);
    }

    public final void searchStickerListCS(com.ss.ugc.effectplatform.task.i r3, IEffectPlatformBaseListener<InfoStickerListResponse> r4) {
        e r5 = getEffectListRepository();
        r5.getClass();
        String r0 = q.a();
        if (r4 == null) goto L5;
        r5.a.N.b(r0, r4);
    L5:
        c r6 = new com.ss.ugc.effectplatform.task.j(r5.a, r0);
        q1 r7 = r5.a.D;
        if (r7 == null) goto L9;
        r7.a(r6);
        return;
    }

    public final void uploadStickerAuthKeyCS(m r3, IEffectPlatformBaseListener<StickerUploadAuthKeyResponse> r4) {
        e r5 = getEffectListRepository();
        r5.getClass();
        String r0 = q.a();
        if (r4 == null) goto L5;
        r5.a.N.b(r0, r4);
    L5:
        c r6 = new com.ss.ugc.effectplatform.task.n(r5.a, r0);
        q1 r7 = r5.a.D;
        if (r7 == null) goto L9;
        r7.a(r6);
        return;
    }

    public final void fetchEffect(Effect r7, hlc.d r8) {
        getEffectRepository().b(r7, false, false, false, r8);
    }

    public final void checkInfoStickerUpdate(String r7, Map<String, String> r8, IEffectPlatformBaseListener<Boolean> r9) {
        checkUpdate(r7, null, 3, r8, r9);
    }

    public final void checkPanelIsUpdate(String r7, Map<String, String> r8, IEffectPlatformBaseListener<Boolean> r9) {
        checkUpdate(r7, null, 2, r8, r9);
    }

    public final void checkedEffectListUpdate(String r7, Map<String, String> r8, IEffectPlatformBaseListener<Boolean> r9) {
        checkUpdate(r7, null, 0, r8, r9);
    }

    public final void downloadEffectList(List<? extends Effect> r10, IEffectPlatformBaseListener<List<Effect>> r11, com.ss.ugc.effectplatform.model.a r12) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r1 = q.a();
        ArrayList r3 = new ArrayList();
        Iterator<T> r2 = r10.iterator();
    L4:
        if (r2.hasNext() == false) goto L21;
        Object r4 = r2.next();
        Effect r5 = (Effect) r4;
        Integer r6 = r5.getFile_url().getUrl_type();
        boolean r7 = false;
        if (r6 != null) goto L9;
    L19:
        if (r7 == false) goto L4;
        r3.add(r4);
        goto L4
    L9:
        if (r6.intValue() != 1) goto L19;
        String r8 = r5.getFile_url().getUri();
        if (r8 != null) goto L13;
    L16:
        boolean r9 = true;
    L17:
        if (r9 == true) goto L19;
        r7 = true;
        goto L19
    L13:
        if (StringsKt.isBlank(r8) == true) goto L16;
        r9 = false;
        goto L17
    L21:
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r14 = r3.iterator();
    L23:
        if (r14.hasNext() == false) goto L25;
        r13.add(((Effect) r14.next()).getFile_url().getUri());
        goto L23
    L25:
        CollectionsKt.filterNotNull(r13);
        r0.d.getClass();
        r0.d.getClass();
        if (r11 == null) goto L28;
        r0.d.N.b(r1, r11);
    L28:
        q1 r15 = r0.d.D;
        if (r15 == null) goto L38;
        r15.a(new u(r0.d, r10, r1, r12));
        return;
    }

    public final void fetchEffect(String r2, Map<String, String> r3, hlc.d r4) {
        ArrayList r0 = new ArrayList();
        r0.add(r2);
        fetchEffectList(r0, true, r3, new e(r4));
    }

    public final void fetchEffectFirst(Effect r8, boolean r9, hlc.d r10) {
        if (ArraysKt.contains(this.effectConfig.S, r8.getPanel()) == true) goto L5;
    L7:
        fetchEffect(r8, r10);
        return;
    L5:
        if (this.effectConfig.R == false) goto L7;
        getEffectRepository().b(r8, false, true, r9, r10);
    }

    public final void fetchEffectListByEffectIds(ArrayList<String> r10, Map<String, String> r11, IEffectPlatformBaseListener<EffectListResponse> r12) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r4 = q.a();
        if (r12 == null) goto L5;
        r0.d.N.b(r4, r12);
    L5:
        EffectConfig r2 = r0.d;
        q1 r13 = r2.D;
        if (r13 == null) goto L9;
        r13.a(new FetchEffectListByIdsTask(r2, r10, r4, r11, true, r0.c));
        return;
    }

    public final void fetchEffectListByResourceIds(List<String> r10, Map<String, String> r11, IEffectPlatformBaseListener<EffectListResponse> r12) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r4 = q.a();
        if (r12 == null) goto L5;
        r0.d.N.b(r4, r12);
    L5:
        EffectConfig r2 = r0.d;
        q1 r13 = r2.D;
        if (r13 == null) goto L9;
        r13.a(new FetchEffectListByIdsTask(r2, r10, r4, r11, false, r0.c));
        return;
    }

    public final void fetchFavoriteList(String r4, Map<String, String> r5, IEffectPlatformBaseListener<FetchFavoriteListResponse> r6) {
        l r0 = getUserEffectRepository();
        r0.getClass();
        String r1 = q.a();
        if (r6 == null) goto L5;
        r0.b.N.b(r1, r6);
    L5:
        c r7 = new h0(r0.b, r4, r1, r5);
        q1 r8 = r0.b.D;
        if (r8 == null) goto L9;
        r8.a(r7);
        return;
    }

    public final void fetchResourceListWithDownload(Map<String, String> r2, IEffectPlatformBaseListener<ResourceListModel> r3, IEffectPlatformBaseListener<com.ss.ugc.effectplatform.model.g> r4) {
        fetchResourceList(r2, new j(this, r3, r4));
    }

    public final void fetchResourcesByRequirementsAndModelNames(String[] r9, Map<String, ? extends List<String>> r10, IEffectPlatformBaseListener<Long> r11) {
        AlgorithmRepository r1 = getAlgorithmRepository();
        q1 r6 = r1.f.D;
        if (r6 == null) goto L6;
        r6.a(new com.ss.ugc.effectplatform.repository.a(r1, r9, r10, r11, q.a()));
        return;
    }

    public final void getCustomizedEffectId(long r9, Map<String, String> r11, IEffectPlatformBaseListener<GetCustomizedEffectIDData> r12) {
        e r0 = getEffectListRepository();
        r0.getClass();
        String r5 = q.a();
        if (r12 == null) goto L5;
        r0.a.N.b(r5, r12);
    L5:
        q1 r13 = r0.a.D;
        if (r13 == null) goto L9;
        r13.a(new v0(r0.a, r9, r5, r11));
        return;
    }

    public final void isTagUpdated(String r4, String r5, IEffectPlatformBaseListener<Boolean> r6) {
        l r0 = getUserEffectRepository();
        r0.getClass();
        String r1 = q.a();
        if (r0.a.a != null) goto L7;
        com.ss.ugc.effectplatform.repository.m r2 = new com.ss.ugc.effectplatform.repository.m(r0, r4, r5, r6);
        r0.b.N.b(r1, r2);
        EffectConfig r7 = r0.b;
        c r8 = new ReadUpdateTagTask(r7, r1);
        q1 r9 = r7.D;
        if (r9 == null) goto L9;
        r9.a(r8);
        return;
    L9:
        return;
    L7:
        r0.a(r4, r5, r6);
    }

    public final void onEffectUsed(boolean r4, Effect r5, String r6) {
        q1 r0 = this.effectConfig.D;
        if (r0 == null) goto L6;
        r0.b("EffectUsed", new com.ss.ugc.effectplatform.task.b(new onEffectUsed.1(this, r5, r6, r4)));
        return;
    }

    public final void preloadResource(int r12, String r13, Map<String, ? extends Object> r14) {
        e r0 = getEffectListRepository();
        r0.getClass();
        z.d r1 = com.ss.ugc.effectplatform.preload.h.a;
        com.ss.ugc.effectplatform.preload.g r2 = new com.ss.ugc.effectplatform.preload.g(r13, r0.a);
        String r8 = q.a();
        r0.a.N.b(r8, r2);
        int r3 = b0.a.a;
        long r4 = System.currentTimeMillis();
        Long r5 = (Long) com.ss.ugc.effectplatform.preload.h.b.get(r13);
        if (r5 == null) goto L5;
        long r6 = r5.longValue();
    L7:
        if ((r4 - r6) <= com.ss.ugc.effectplatform.preload.h.c) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == false) goto L14;
        q1 r9 = r0.a.D;
        if (r9 == null) goto L14;
        r9.a(new c1(r0.a, r12, r13, r14, r8));
    L14:
        EffectConfig r15 = r0.a;
        com.ss.ugc.effectplatform.preload.h.d = true;
        z.d r16 = com.ss.ugc.effectplatform.preload.h.a;
        ArrayList r10 = new ArrayList();
        Iterator r17 = r16.iterator();
    L16:
        if (r17.hasNext() == false) goto L20;
        Object r11 = r17.next();
        if (Intrinsics.areEqual(((b1) r11).k, r13) == false) goto L16;
        r10.add(r11);
        goto L16
    L20:
        com.ss.ugc.effectplatform.preload.h.a.removeAll(r10);
        Iterator r18 = r10.iterator();
    L22:
        if (r18.hasNext() == false) goto L26;
        b1 r19 = (b1) r18.next();
        r19.b = false;
        com.ss.ugc.effectplatform.preload.h.a.add(r19);
        q1 r20 = r15.D;
        if (r20 == null) goto L22;
        r20.a(r19);
        goto L22
    L26:
        return;
    L9:
        r7 = false;
        goto L10
    L5:
        r6 = 0;
        goto L7
    }

    public final void queryCustomizedEffects(String r2, Map<String, String> r3, IEffectPlatformBaseListener<QueryCustomizedEffectsData> r4) {
        getEffectListRepository().i(r2, r3, r4);
    }

    public final void recordPreloadedEffects(PreloadedEffectsRecord r9, List<String> r10, List<String> r11) {
        EffectRepository r0 = getEffectRepository();
        if (r10 != null) goto L6;
        r10 = new ArrayList();
    L6:
        if (r11 != null) goto L9;
        r11 = new ArrayList();
    L9:
        com.ss.ugc.effectplatform.cache.j r1 = (com.ss.ugc.effectplatform.cache.j) r0.d.A.a;
        Long r3 = null;
        if (r1 == null) goto L12;
        String r2 = r1.queryToValue("preloaded_effects");
    L13:
        List r4 = new ArrayList();
        List r5 = new ArrayList();
        if (r2 != null) goto L16;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == false) goto L79;
    L59:
        List r12 = r9.getEffect_list();
        if (r12 == null) goto L62;
        r12.addAll(r4);
        r4 = r12;
    L62:
        r9.setEffect_list(r4);
        List r13 = r9.getModel_list();
        if (r13 == null) goto L65;
        r13.addAll(r5);
        r5 = r13;
    L65:
        r9.setModel_list(r5);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L76
        dlc.a r15 = r0.d.t;     // Catch: Throwable -> L76
        if (r15 == null) goto L69;
        Reflection.getOrCreateKotlinClass(PreloadedEffectsRecord.class);     // Catch: Throwable -> L76
        String r16 = r15.a.convertObjToJson(r9);     // Catch: Throwable -> L76
    L70:
        if (r16 == null) goto L74;
        com.ss.ugc.effectplatform.cache.j r17 = (com.ss.ugc.effectplatform.cache.j) r0.d.A.a;     // Catch: Throwable -> L76
        if (r17 == null) goto L74;
        r3 = Long.valueOf(r17.save("preloaded_effects", r16));     // Catch: Throwable -> L76
    L74:
        Result.constructor-impl(r3);     // Catch: Throwable -> L76
        return;
    L69:
        r16 = null;
    L76:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L79:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L27
        dlc.a r8 = r0.d.t;     // Catch: Throwable -> L27
        if (r8 == null) goto L24;
        PreloadedEffectsRecord r19 = (PreloadedEffectsRecord) r8.a.convertJsonToObj(r2, JvmClassMappingKt.getJavaClass(Reflection.getOrCreateKotlinClass(PreloadedEffectsRecord.class)));     // Catch: Throwable -> L27
    L25:
        Object r20 = Result.constructor-impl(r19);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r20) == false) goto L32;
        r20 = null;
    L32:
        PreloadedEffectsRecord r21 = (PreloadedEffectsRecord) r20;
        if (r21 == null) goto L59;
        List r22 = r21.getEffect_list();
        if (r22 == null) goto L45;
        ArrayList r23 = new ArrayList();
        Iterator r24 = r22.iterator();
    L38:
        if (r24.hasNext() == false) goto L42;
        Object r25 = r24.next();
        if (r10.contains(((PreloadDataModel) r25).getId()) == false) goto L38;
        r23.add(r25);
        goto L38
    L42:
        List r110 = CollectionsKt.toMutableList(r23);
        if (r110 == null) goto L45;
    L46:
        r4 = r110;
        List r111 = r21.getModel_list();
        if (r111 == null) goto L57;
        ArrayList r26 = new ArrayList();
        Iterator r112 = r111.iterator();
    L50:
        if (r112.hasNext() == false) goto L54;
        Object r27 = r112.next();
        if (r11.contains(((PreloadDataModel) r27).getId()) == false) goto L50;
        r26.add(r27);
        goto L50
    L54:
        List r113 = CollectionsKt.toMutableList(r26);
        if (r113 == null) goto L57;
    L58:
        r5 = r113;
    L57:
        r113 = new ArrayList();
    L45:
        r110 = new ArrayList();
        goto L46
    L24:
        r19 = null;
    L27:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L16:
        if (StringsKt.isBlank(r2) == true) goto L19;
        r6 = false;
        goto L20
    L12:
        r2 = null;
        goto L13
    }

    public final void resumeEffectTask(Effect r7, boolean r8, boolean r9) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r1 = com.ss.ugc.effectplatform.model.b.a(r7);
        if (r.b(r1) == true) goto L11;
        String r2 = (String) r0.a.get(r1);
        if (r2 == null) goto L12;
        IEffectPlatformBaseListener r3 = r0.d.N.a(r2);
        if ((r3 instanceof hlc.d) == true) goto L9;
        r3 = null;
    L9:
        r0.b(r7, false, r8, r9, (hlc.d) r3);
        return;
    L12:
        return;
    }

    public final void updateTag(String r10, String r11, hlc.f r12) {
        l r6 = getUserEffectRepository();
        r6.getClass();
        String r7 = q.a();
        if (r6.a.a != null) goto L7;
        com.ss.ugc.effectplatform.repository.n r8 = new com.ss.ugc.effectplatform.repository.n(r6, r7, r10, r11, r12);
        r6.b.N.b(r7, r8);
        EffectConfig r13 = r6.b;
        c r14 = new ReadUpdateTagTask(r13, r7);
        q1 r15 = r13.D;
        if (r15 == null) goto L9;
        r15.a(r14);
        return;
    L9:
        return;
    L7:
        r6.b(r7, r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void recommendSearchWords$default(EffectPlatform r0, IEffectPlatformBaseListener r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.recommendSearchWords(r1);
    }

    public final void checkCategoryIsUpdate(String r7, String r8, Map<String, String> r9, IEffectPlatformBaseListener<Boolean> r10) {
        checkUpdate(r7, r8, 1, r9, r10);
    }

    public final void cleanResourcesByServerStrategyWithAllowList(List<String> r2, List<String> r3, List<String> r4, Function3<? super Boolean, ? super Integer, ? super String, Unit> r5) {
        getEffectRepository().a(r2, r3, r4, r5);
    }

    public final void fetchCategoryInfo(String r7, List<Integer> r8, Map<String, String> r9, IEffectPlatformBaseListener<EffectCategoryModelList> r10) {
        getEffectListRepository().c(r7, r8, false, r9, r10);
    }

    public final void fetchCategoryInfoFromCache(String r7, List<Integer> r8, Map<String, String> r9, IEffectPlatformBaseListener<EffectCategoryModelList> r10) {
        getEffectListRepository().c(r7, r8, true, r9, r10);
    }

    public final void fetchCustomizedEffects(String r7, String r8, Map<String, String> r9, IEffectPlatformBaseListener<CategoryPageModel> r10) {
        e r0 = getEffectListRepository();
        d r1 = new d(this, r10, r7, r9);
        r0.getClass();
        r0.a(r7, r8, 1, null, new com.ss.ugc.effectplatform.repository.g(r0, r7, r8, r1));
    }

    public final void fetchEffectList(String r2, boolean r3, Map<String, String> r4, IEffectPlatformBaseListener<EffectChannelResponse> r5) {
        h r0 = new h(this, r3, r5);
        if (r.b(r2) == true) goto L5;
        getEffectListRepository().f(r2, false, r4, r0);
        return;
    L5:
        getEffectListRepository().f("default", false, r4, r0);
    }

    public final void fetchHotEffect(int r8, int r9, Map<String, String> r10, IEffectPlatformBaseListener<FetchHotEffectResponse> r11) {
        e r0 = getEffectListRepository();
        r0.getClass();
        String r5 = q.a();
        if (r11 == null) goto L5;
        r0.a.N.b(r5, r11);
    L5:
        c r12 = new i0(r0.a, r8, r9, r5, r10);
        q1 r13 = r0.a.D;
        if (r13 == null) goto L9;
        r13.a(r12);
        return;
    }

    public final void fetchRankingCategoryList(int r8, int r9, int r10, IEffectPlatformBaseListener<RankingCategoryListModel> r11) {
        e r0 = getEffectListRepository();
        r0.getClass();
        String r6 = q.a();
        if (r11 == null) goto L5;
        r0.a.N.b(r6, r11);
    L5:
        c r12 = new t0(r0.a, r8, r9, r10, r6);
        q1 r13 = r0.a.D;
        if (r13 == null) goto L9;
        r13.a(r12);
        return;
    }

    public final void queryTopChecklistEffects(String r9, Boolean r10, Map<String, String> r11, IEffectPlatformBaseListener<QueryTopChecklistEffectsModel> r12) {
        e r0 = getEffectListRepository();
        r0.getClass();
        String r6 = q.a();
        if (r12 == null) goto L5;
        r0.a.N.b(r6, r12);
    L5:
        q1 r13 = r0.a.D;
        if (r13 == null) goto L9;
        r13.a(new g1(r0.a, r9, r10, r11, r6));
        return;
    }

    public final void fetchEffectList(List<String> r1, boolean r2, Map<String, String> r3, IEffectPlatformBaseListener<List<Effect>> r4) {
        if (r2 == false) goto L4;
        g r5 = new g(this, r4);
        getEffectRepository().c(r1, r3, r5);
        return;
    L4:
        getEffectRepository().c(r1, r3, r4);
    }

    public static /* synthetic */ void downloadInfoStickerEffect$default(EffectPlatform r0, InfoStickerEffect r1, IDownloadInfoStickerEffectProgressListener r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.downloadInfoStickerEffect(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchEffect$default(EffectPlatform r0, EffectQRCode r1, IEffectPlatformBaseListener r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.fetchEffect(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String preFetchEffectInfo$default(EffectPlatform r0, IEffectPlatformBaseListener r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = false;
    L9:
        return r0.preFetchEffectInfo(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void recommendSearchWords$default(EffectPlatform r0, String r1, IEffectPlatformBaseListener r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.recommendSearchWords(r1, r2);
    }

    public final void checkUpdate(String r7, String r8, int r9, Map<String, String> r10, IEffectPlatformBaseListener<Boolean> r11) {
        getEffectListRepository().a(r7, r8, r9, r10, r11);
    }

    public final void convertOidToUrl(String r10, String r11, List<String> r12, Map<String, String> r13, IEffectPlatformBaseListener<ConvertOidToUrlResponse> r14) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r6 = q.a();
        if (r14 == null) goto L5;
        r0.d.N.b(r6, r14);
    L5:
        q1 r15 = r0.d.D;
        if (r15 == null) goto L9;
        r15.a(new p(r0.d, r10, r11, r12, r6, r13));
        return;
    }

    public final void fetchProviderEffectsByGiphyIds(String r9, String r10, Map<String, String> r11, boolean r12, IEffectPlatformBaseListener<GifProviderEffectListResponse> r13) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r3 = q.a();
        if (r13 == null) goto L5;
        r0.d.N.b(r3, r13);
    L5:
        c r14 = new r0(r0.d, r3, r9, r10, r11, r12);
        q1 r15 = r0.d.D;
        if (r15 == null) goto L9;
        r15.a(r14);
        return;
    }

    public final void fetchRewardEffects(String r10, int r11, int r12, Map<String, String> r13, IEffectPlatformBaseListener<QueryRewardEffectsResponse> r14) {
        e r0 = getEffectListRepository();
        r0.getClass();
        String r4 = q.a();
        if (r14 == null) goto L5;
        r0.a.N.b(r4, r14);
    L5:
        q1 r15 = r0.a.D;
        if (r15 == null) goto L9;
        r15.a(new f1(r0.a, r10, r4, r11, r12, r13));
        return;
    }

    public final void modifyFavoriteList(String r9, List<String> r10, boolean r11, Map<String, String> r12, IEffectPlatformBaseListener<List<String>> r13) {
        l r0 = getUserEffectRepository();
        r0.getClass();
        String r4 = q.a();
        if (r13 == null) goto L5;
        r0.b.N.b(r4, r13);
    L5:
        c r14 = new w0(r0.b, r9, r4, r10, r11, r12);
        q1 r15 = r0.b.D;
        if (r15 == null) goto L9;
        r15.a(r14);
        return;
    }

    public final void queryInfoStickerList(String r8, int r9, int r10, Map<String, String> r11, IEffectPlatformBaseListener<QueryInfoStickerResponse> r12) {
        getEffectListRepository().j(r8, Integer.valueOf(r9), Integer.valueOf(r10), r11, false, r12);
    }

    public final void queryInfoStickerListFromCache(String r8, Integer r9, Integer r10, Map<String, String> r11, IEffectPlatformBaseListener<QueryInfoStickerResponse> r12) {
        getEffectListRepository().j(r8, r9, r10, r11, true, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkInfoStickerUpdate$default(EffectPlatform r0, String r1, Map r2, IEffectPlatformBaseListener r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.checkInfoStickerUpdate(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkPanelIsUpdate$default(EffectPlatform r0, String r1, Map r2, IEffectPlatformBaseListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.checkPanelIsUpdate(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkedEffectListUpdate$default(EffectPlatform r0, String r1, Map r2, IEffectPlatformBaseListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.checkedEffectListUpdate(r1, r2, r3);
    }

    public static /* synthetic */ void downloadEffectList$default(EffectPlatform r0, List r1, IEffectPlatformBaseListener r2, com.ss.ugc.effectplatform.model.a r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.downloadEffectList(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchEffect$default(EffectPlatform r0, String r1, Map r2, hlc.d r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.fetchEffect(r1, r2, r3);
    }

    public static /* synthetic */ void fetchEffectFirst$default(EffectPlatform r0, Effect r1, boolean r2, hlc.d r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.fetchEffectFirst(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchEffectListByEffectIds$default(EffectPlatform r1, ArrayList r2, Map r3, IEffectPlatformBaseListener r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.fetchEffectListByEffectIds(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchEffectListByResourceIds$default(EffectPlatform r1, List r2, Map r3, IEffectPlatformBaseListener r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.fetchEffectListByResourceIds(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchFavoriteList$default(EffectPlatform r0, String r1, Map r2, IEffectPlatformBaseListener r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.fetchFavoriteList(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void preloadResource$default(EffectPlatform r0, int r1, String r2, Map r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.preloadResource(r1, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void queryCustomizedEffects$default(EffectPlatform r1, String r2, Map r3, IEffectPlatformBaseListener r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.queryCustomizedEffects(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void recordPreloadedEffects$default(EffectPlatform r1, PreloadedEffectsRecord r2, List r3, List r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        r1.recordPreloadedEffects(r2, r3, r4);
    }

    public static /* synthetic */ void resumeEffectTask$default(EffectPlatform r1, Effect r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        r1.resumeEffectTask(r2, r3, r4);
    }

    public final void fetchCategoryEffect(String r12, String r13, String r14, Integer r15, Map<String, String> r16, IEffectPlatformBaseListener<CategoryEffectsWithThemeData> r17) {
        e r1 = getEffectListRepository();
        r1.getClass();
        String r6 = q.a();
        if (r17 == null) goto L5;
        r1.a.N.b(r6, r17);
    L5:
        q1 r0 = r1.a.D;
        if (r0 == null) goto L9;
        r0.a(new c0(r1.a, r12, r13, r6, r14, r15, r16));
        return;
    }

    public final void fetchPanelInfo(String r12, String r13, Integer r14, Map<String, String> r15, IEffectPlatformBaseListener<PanelInfoWithOneEffectData> r16, boolean r17) {
        e r1 = getEffectListRepository();
        r1.getClass();
        String r5 = q.a();
        if (r16 == null) goto L5;
        r1.a.N.b(r5, r16);
    L5:
        q1 r0 = r1.a.D;
        if (r0 == null) goto L9;
        r0.a(new p0(r1.a, r12, r5, r13, r14, r15, r17));
        return;
    }

    public final void fetchPanelInfoFromCache(String r11, boolean r12, String r13, int r14, int r15, IEffectPlatformBaseListener<PanelInfoModel> r16) {
        getEffectListRepository().g(r11, r12, r13, r14, r15, true, false, null, r16);
    }

    @Deprecated(message = "replace with searchEffects()")
    public final void searchEffect(String r10, String r11, int r12, int r13, Map<String, String> r14, IEffectPlatformBaseListener<SearchEffectResponse> r15) {
        EffectRepository r0 = getEffectRepository();
        r0.getClass();
        String r8 = q.a();
        if (r15 == null) goto L5;
        r0.d.N.b(r8, r15);
    L5:
        EffectConfig r2 = r0.d;
        q1 r16 = r2.D;
        if (r16 == null) goto L9;
        r16.a(new k1(r2, r10, r11, r12, r13, r14, r8));
        return;
    }

    public final void searchEffects(String r9, String r10, int r11, int r12, Map<String, String> r13, IEffectPlatformBaseListener<SearchEffectResponseV2> r14) {
        getEffectRepository().f(r9, r10, r11, r12, null, r13, r14);
    }

    public final void searchProviderEffect(String r10, String r11, int r12, int r13, String r14, IEffectPlatformBaseListener<ProviderEffectModel> r15) {
        e r0 = getEffectListRepository();
        r0.getClass();
        String r3 = q.a();
        if (r15 == null) goto L5;
        r0.a.N.b(r3, r15);
    L5:
        c r16 = new m1(r0.a, r3, r10, r11, r12, r13, r14);
        q1 r17 = r0.a.D;
        if (r17 == null) goto L9;
        r17.a(r16);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void checkCategoryIsUpdate$default(EffectPlatform r0, String r1, String r2, Map r3, IEffectPlatformBaseListener r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.checkCategoryIsUpdate(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void cleanResourcesByServerStrategyWithAllowList$default(EffectPlatform r1, List r2, List r3, List r4, Function3 r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        r1.cleanResourcesByServerStrategyWithAllowList(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchCategoryInfo$default(EffectPlatform r0, String r1, List r2, Map r3, IEffectPlatformBaseListener r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.fetchCategoryInfo(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchCategoryInfoFromCache$default(EffectPlatform r0, String r1, List r2, Map r3, IEffectPlatformBaseListener r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.fetchCategoryInfoFromCache(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchCustomizedEffects$default(EffectPlatform r1, String r2, String r3, Map r4, IEffectPlatformBaseListener r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.fetchCustomizedEffects(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchEffectList$default(EffectPlatform r1, List r2, boolean r3, Map r4, IEffectPlatformBaseListener r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.fetchEffectList(r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void queryTopChecklistEffects$default(EffectPlatform r1, String r2, Boolean r3, Map r4, IEffectPlatformBaseListener r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.queryTopChecklistEffects(r2, r3, r4, r5);
    }

    public final void fetchCategoryEffectFromCache(String r11, String r12, int r13, int r14, int r15, String r16, IEffectPlatformBaseListener<CategoryPageModel> r17) {
        getEffectListRepository().b(r11, r12, r13, r14, r15, r16, true, null, r17);
    }

    public final void fetchInspirationFeedEffects(String r12, int r13, int r14, String r15, String r16, Map<String, String> r17, IEffectPlatformBaseListener<List<Effect>> r18) {
        e r1 = getEffectListRepository();
        r1.getClass();
        String r10 = q.a();
        if (r18 == null) goto L5;
        r1.a.N.b(r10, r18);
    L5:
        c r0 = new j0(r1.a, r12, r13, r14, r15, r16, r17, r10);
        q1 r2 = r1.a.D;
        if (r2 == null) goto L9;
        r2.a(r0);
        return;
    }

    public final void fetchPanelInfo(String r11, boolean r12, String r13, int r14, int r15, Map<String, String> r16, IEffectPlatformBaseListener<PanelInfoModel> r17) {
        getEffectListRepository().g(r11, r12, r13, r14, r15, false, false, r16, r17);
    }

    public final void fetchPanelInfoPagingFromCache(String r11, String r12, int r13, int r14, int r15, String r16, IEffectPlatformBaseListener<PanelInfoModel> r17) {
        getEffectListRepository().h(r11, r12, r13, r14, r15, r16, true, null, r17);
    }

    public final void fetchProviderEffect(String r9, boolean r10, int r11, int r12, String r13, Map<String, String> r14, IEffectPlatformBaseListener<ProviderEffectModel> r15) {
        e r16 = getEffectListRepository();
        r16.getClass();
        String r2 = q.a();
        if (r15 == null) goto L5;
        r16.a.N.b(r2, r15);
    L5:
        c r17 = new s0(r16.a, r2, r9, r11, r12, r13, r14);
        q1 r18 = r16.a.D;
        if (r18 == null) goto L9;
        r18.a(r17);
        return;
    }

    public final void searchEffects(String r9, String r10, int r11, int r12, String r13, Map<String, String> r14, IEffectPlatformBaseListener<SearchEffectResponseV2> r15) {
        getEffectRepository().f(r9, r10, r11, r12, r13, r14, r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchEffectList$default(EffectPlatform r0, String r1, boolean r2, Map r3, IEffectPlatformBaseListener r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.fetchEffectList(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchProviderEffectsByGiphyIds$default(EffectPlatform r7, String r8, String r9, Map r10, boolean r11, IEffectPlatformBaseListener r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        Map r4 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        boolean r5 = false;
    L14:
        r7.fetchProviderEffectsByGiphyIds(r8, r3, r4, r5, r12);
        return;
    L13:
        r5 = r11;
        goto L14
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchRewardEffects$default(EffectPlatform r7, String r8, int r9, int r10, Map r11, IEffectPlatformBaseListener r12, int r13, Object r14) {
        if ((r13 & 8) == 0) goto L5;
        Map r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        IEffectPlatformBaseListener r6 = null;
    L10:
        r7.fetchRewardEffects(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void modifyFavoriteList$default(EffectPlatform r6, String r7, List r8, boolean r9, Map r10, IEffectPlatformBaseListener r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = null;
    L5:
        r6.modifyFavoriteList(r7, r8, r9, r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void queryInfoStickerList$default(EffectPlatform r7, String r8, int r9, int r10, Map r11, IEffectPlatformBaseListener r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r13 & 4) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r13 & 8) == 0) goto L13;
        Map r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L17;
        IEffectPlatformBaseListener r6 = null;
    L18:
        r7.queryInfoStickerList(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void queryInfoStickerListFromCache$default(EffectPlatform r7, String r8, Integer r9, Integer r10, Map r11, IEffectPlatformBaseListener r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        Integer r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        Integer r4 = null;
    L11:
        if ((r13 & 8) == 0) goto L13;
        Map r5 = null;
    L15:
        if ((r13 & 16) == 0) goto L17;
        IEffectPlatformBaseListener r6 = null;
    L18:
        r7.queryInfoStickerListFromCache(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public final void fetchCategoryEffect(String r11, String r12, int r13, int r14, int r15, String r16, Map<String, String> r17, IEffectPlatformBaseListener<CategoryPageModel> r18) {
        getEffectListRepository().b(r11, r12, r13, r14, r15, r16, false, r17, r18);
    }

    public final void fetchCategoryPagingEffect(String r11, String r12, int r13, int r14, int r15, String r16, Map<String, String> r17, IEffectPlatformBaseListener<CategoryPageModel> r18) {
        getEffectListRepository().d(r11, r12, r13, r14, r15, r16, false, r17, r18);
    }

    public final void fetchCategoryPagingEffectFromCache(String r11, String r12, int r13, int r14, int r15, String r16, Map<String, String> r17, IEffectPlatformBaseListener<CategoryPageModel> r18) {
        getEffectListRepository().d(r11, r12, r13, r14, r15, r16, true, r17, r18);
    }

    public final void fetchPanelInfo(String r11, boolean r12, String r13, int r14, int r15, boolean r16, Map<String, String> r17, IEffectPlatformBaseListener<PanelInfoModel> r18) {
        getEffectListRepository().g(r11, r12, r13, r14, r15, false, r16, r17, r18);
    }

    public final void fetchPanelInfoChecked(String r12, boolean r13, String r14, int r15, int r16, boolean r17, Map<String, String> r18, IEffectPlatformBaseListener<PanelInfoModel> r19) {
        e r1 = getEffectListRepository();
        r1.getClass();
        String r5 = q.a();
        if (r19 == null) goto L5;
        r1.a.N.b(r5, r19);
    L5:
        if (r17 == false) goto L7;
        FetchPanelInfoCheckedCacheTask r0 = new FetchPanelInfoCheckedCacheTask(r1.a, r12, r5, r13, r14, r15, r16);
    L8:
        q1 r2 = r1.a.D;
        if (r2 == null) goto L12;
        r2.a(r0);
        return;
    L12:
        return;
    L7:
        r0 = new m0(r1.a, r12, r5, r13, r14, r15, r16, r18);
        goto L8
    }

    public final void fetchPanelInfoPaging(String r11, String r12, int r13, int r14, int r15, String r16, Map<String, String> r17, IEffectPlatformBaseListener<PanelInfoModel> r18) {
        getEffectListRepository().h(r11, r12, r13, r14, r15, r16, false, r17, r18);
    }

    public final void queryRecommendStickerList(int r13, String r14, String r15, Integer r16, Integer r17, String r18, HashMap<String, String> r19, IEffectPlatformBaseListener<InfoStickerListResponse> r20) {
        e r1 = getEffectListRepository();
        r1.getClass();
        String r11 = q.a();
        if (r20 == null) goto L5;
        r1.a.N.b(r11, r20);
    L5:
        c r0 = new j1(r1.a, r13, r14, r15, r16, r17, r18, r19, r11);
        q1 r2 = r1.a.D;
        if (r2 == null) goto L9;
        r2.a(r0);
        return;
    }

    public final void searchStickerList(String r13, String r14, String r15, Integer r16, Integer r17, String r18, HashMap<String, String> r19, IEffectPlatformBaseListener<InfoStickerListResponse> r20) {
        e r1 = getEffectListRepository();
        r1.getClass();
        String r11 = q.a();
        if (r20 == null) goto L5;
        r1.a.N.b(r11, r20);
    L5:
        c r0 = new n1(r1.a, r13, r14, r15, r16, r17, r18, r19, r11);
        q1 r2 = r1.a.D;
        if (r2 == null) goto L9;
        r2.a(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchCategoryEffect$default(EffectPlatform r9, String r10, String r11, String r12, Integer r13, Map r14, IEffectPlatformBaseListener r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        Integer r6 = null;
    L11:
        if ((r16 & 16) == 0) goto L13;
        Map r7 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        IEffectPlatformBaseListener r8 = null;
    L18:
        r9.fetchCategoryEffect(r10, r11, r5, r6, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchPanelInfo$default(EffectPlatform r5, String r6, String r7, Integer r8, Map r9, IEffectPlatformBaseListener r10, boolean r11, int r12, Object r13) {
        IEffectPlatformBaseListener r1 = null;
        if ((r12 & 2) == 0) goto L5;
        String r0 = null;
    L7:
        if ((r12 & 4) == 0) goto L9;
        Integer r2 = null;
    L11:
        if ((r12 & 8) == 0) goto L13;
        Map r3 = null;
    L15:
        if ((r12 & 16) != 0) goto L19;
        r1 = r10;
    L19:
        if ((r12 & 32) == 0) goto L21;
        boolean r4 = false;
    L22:
        r5.fetchPanelInfo(r6, r0, r2, r3, r1, r4);
        return;
    L21:
        r4 = r11;
        goto L22
    L13:
        r3 = r9;
        goto L15
    L9:
        r2 = r8;
        goto L11
    L5:
        r0 = r7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchPanelInfoFromCache$default(EffectPlatform r7, String r8, boolean r9, String r10, int r11, int r12, IEffectPlatformBaseListener r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = null;
    L5:
        r7.fetchPanelInfoFromCache(r8, r9, r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void searchEffect$default(EffectPlatform r7, String r8, String r9, int r10, int r11, Map r12, IEffectPlatformBaseListener r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = null;
    L5:
        r7.searchEffect(r8, r9, r10, r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void searchEffects$default(EffectPlatform r7, String r8, String r9, int r10, int r11, Map r12, IEffectPlatformBaseListener r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = null;
    L5:
        r7.searchEffects(r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ void searchProviderEffect$default(EffectPlatform r7, String r8, String r9, int r10, int r11, String r12, IEffectPlatformBaseListener r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        r12 = null;
    L5:
        r7.searchProviderEffect(r8, r9, r10, r11, r12, r13);
    }

    public final void fetchPanelInfoPagingChecked(String r13, String r14, int r15, int r16, int r17, String r18, boolean r19, Map<String, String> r20, IEffectPlatformBaseListener<PanelInfoModel> r21) {
        e r1 = getEffectListRepository();
        r1.getClass();
        String r5 = q.a();
        if (r21 == null) goto L5;
        r1.a.N.b(r5, r21);
    L5:
        if (r19 == false) goto L7;
        FetchPanelInfoPagingCheckedCacheTask r0 = new FetchPanelInfoPagingCheckedCacheTask(r1.a, r13, r5, r14, r15, r16, r17, r18);
    L8:
        q1 r2 = r1.a.D;
        if (r2 == null) goto L12;
        r2.a(r0);
        return;
    L12:
        return;
    L7:
        r0 = new n0(r1.a, r13, r5, r14, r15, r16, r17, r18, r20);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchCategoryEffectFromCache$default(EffectPlatform r9, String r10, String r11, int r12, int r13, int r14, String r15, IEffectPlatformBaseListener r16, int r17, Object r18) {
        if ((r17 & 64) == 0) goto L5;
        IEffectPlatformBaseListener r8 = null;
    L6:
        r9.fetchCategoryEffectFromCache(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchInspirationFeedEffects$default(EffectPlatform r10, String r11, int r12, int r13, String r14, String r15, Map r16, IEffectPlatformBaseListener r17, int r18, Object r19) {
        if ((r18 & 32) == 0) goto L5;
        Map r8 = null;
    L7:
        if ((r18 & 64) == 0) goto L9;
        IEffectPlatformBaseListener r9 = null;
    L10:
        r10.fetchInspirationFeedEffects(r11, r12, r13, r14, r15, r8, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r8 = r16;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchPanelInfo$default(EffectPlatform r10, String r11, boolean r12, String r13, int r14, int r15, Map r16, IEffectPlatformBaseListener r17, int r18, Object r19) {
        if ((r18 & 32) == 0) goto L5;
        Map r8 = null;
    L7:
        if ((r18 & 64) == 0) goto L9;
        IEffectPlatformBaseListener r9 = null;
    L10:
        r10.fetchPanelInfo(r11, r12, r13, r14, r15, r8, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r8 = r16;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchPanelInfoPagingFromCache$default(EffectPlatform r9, String r10, String r11, int r12, int r13, int r14, String r15, IEffectPlatformBaseListener r16, int r17, Object r18) {
        if ((r17 & 64) == 0) goto L5;
        IEffectPlatformBaseListener r8 = null;
    L6:
        r9.fetchPanelInfoPagingFromCache(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchProviderEffect$default(EffectPlatform r10, String r11, boolean r12, int r13, int r14, String r15, Map r16, IEffectPlatformBaseListener r17, int r18, Object r19) {
        if ((r18 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        Map r8 = null;
    L10:
        r10.fetchProviderEffect(r11, r12, r13, r14, r7, r8, r17);
        return;
    L9:
        r8 = r16;
        goto L10
    L5:
        r7 = r15;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void searchEffects$default(EffectPlatform r9, String r10, String r11, int r12, int r13, String r14, Map r15, IEffectPlatformBaseListener r16, int r17, Object r18) {
        if ((r17 & 64) == 0) goto L5;
        IEffectPlatformBaseListener r8 = null;
    L6:
        r9.searchEffects(r10, r11, r12, r13, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchCategoryEffect$default(EffectPlatform r12, String r13, String r14, int r15, int r16, int r17, String r18, Map r19, IEffectPlatformBaseListener r20, int r21, Object r22) {
        if ((r21 & 64) == 0) goto L5;
        Map r10 = null;
    L7:
        if ((r21 & 128) == 0) goto L9;
        IEffectPlatformBaseListener r11 = null;
    L10:
        r12.fetchCategoryEffect(r13, r14, r15, r16, r17, r18, r10, r11);
        return;
    L9:
        r11 = r20;
        goto L10
    L5:
        r10 = r19;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchCategoryPagingEffect$default(EffectPlatform r12, String r13, String r14, int r15, int r16, int r17, String r18, Map r19, IEffectPlatformBaseListener r20, int r21, Object r22) {
        if ((r21 & 64) == 0) goto L5;
        Map r10 = null;
    L7:
        if ((r21 & 128) == 0) goto L9;
        IEffectPlatformBaseListener r11 = null;
    L10:
        r12.fetchCategoryPagingEffect(r13, r14, r15, r16, r17, r18, r10, r11);
        return;
    L9:
        r11 = r20;
        goto L10
    L5:
        r10 = r19;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchCategoryPagingEffectFromCache$default(EffectPlatform r12, String r13, String r14, int r15, int r16, int r17, String r18, Map r19, IEffectPlatformBaseListener r20, int r21, Object r22) {
        if ((r21 & 64) == 0) goto L5;
        Map r10 = null;
    L7:
        if ((r21 & 128) == 0) goto L9;
        IEffectPlatformBaseListener r11 = null;
    L10:
        r12.fetchCategoryPagingEffectFromCache(r13, r14, r15, r16, r17, r18, r10, r11);
        return;
    L9:
        r11 = r20;
        goto L10
    L5:
        r10 = r19;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchPanelInfo$default(EffectPlatform r11, String r12, boolean r13, String r14, int r15, int r16, boolean r17, Map r18, IEffectPlatformBaseListener r19, int r20, Object r21) {
        if ((r20 & 32) == 0) goto L5;
        boolean r8 = false;
    L7:
        if ((r20 & 64) == 0) goto L9;
        Map r9 = null;
    L11:
        if ((r20 & 128) == 0) goto L13;
        IEffectPlatformBaseListener r10 = null;
    L14:
        r11.fetchPanelInfo(r12, r13, r14, r15, r16, r8, r9, r10);
        return;
    L13:
        r10 = r19;
        goto L14
    L9:
        r9 = r18;
        goto L11
    L5:
        r8 = r17;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchPanelInfoChecked$default(EffectPlatform r12, String r13, boolean r14, String r15, int r16, int r17, boolean r18, Map r19, IEffectPlatformBaseListener r20, int r21, Object r22) {
        if ((r21 & 64) == 0) goto L5;
        Map r10 = null;
    L7:
        if ((r21 & 128) == 0) goto L9;
        IEffectPlatformBaseListener r11 = null;
    L10:
        r12.fetchPanelInfoChecked(r13, r14, r15, r16, r17, r18, r10, r11);
        return;
    L9:
        r11 = r20;
        goto L10
    L5:
        r10 = r19;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchPanelInfoPaging$default(EffectPlatform r12, String r13, String r14, int r15, int r16, int r17, String r18, Map r19, IEffectPlatformBaseListener r20, int r21, Object r22) {
        if ((r21 & 64) == 0) goto L5;
        Map r10 = null;
    L7:
        if ((r21 & 128) == 0) goto L9;
        IEffectPlatformBaseListener r11 = null;
    L10:
        r12.fetchPanelInfoPaging(r13, r14, r15, r16, r17, r18, r10, r11);
        return;
    L9:
        r11 = r20;
        goto L10
    L5:
        r10 = r19;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void queryRecommendStickerList$default(EffectPlatform r11, int r12, String r13, String r14, Integer r15, Integer r16, String r17, HashMap r18, IEffectPlatformBaseListener r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        Integer r6 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        Integer r7 = null;
    L11:
        if ((r20 & 32) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r20 & 64) == 0) goto L17;
        HashMap r9 = null;
    L18:
        r11.queryRecommendStickerList(r12, r13, r14, r6, r7, r8, r9, r19);
        return;
    L17:
        r9 = r18;
        goto L18
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void searchStickerList$default(EffectPlatform r11, String r12, String r13, String r14, Integer r15, Integer r16, String r17, HashMap r18, IEffectPlatformBaseListener r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        Integer r6 = null;
    L7:
        if ((r20 & 16) == 0) goto L9;
        Integer r7 = null;
    L11:
        if ((r20 & 32) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r20 & 64) == 0) goto L17;
        HashMap r9 = null;
    L18:
        r11.searchStickerList(r12, r13, r14, r6, r7, r8, r9, r19);
        return;
    L17:
        r9 = r18;
        goto L18
    L13:
        r8 = r17;
        goto L15
    L9:
        r7 = r16;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    public final void addCustomizedEffect(long r17, String r19, String r20, int r21, String r22, String r23, int r24, String r25, String r26, Map<String, ? extends Object> r27, IEffectPlatformBaseListener<AddCustomizedEffectResponse> r28) {
        e r1 = getEffectListRepository();
        r1.getClass();
        String r14 = q.a();
        if (r28 == null) goto L5;
        r1.a.N.b(r14, r28);
    L5:
        q1 r0 = r1.a.D;
        if (r0 == null) goto L9;
        r0.a(new com.ss.ugc.effectplatform.task.a(r1.a, r17, r19, r20, r21, r22, r23, r24, r25, r26, r14, r27));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void fetchPanelInfoPagingChecked$default(EffectPlatform r13, String r14, String r15, int r16, int r17, int r18, String r19, boolean r20, Map r21, IEffectPlatformBaseListener r22, int r23, Object r24) {
        if ((r23 & 128) == 0) goto L5;
        Map r11 = null;
    L7:
        if ((r23 & 256) == 0) goto L9;
        IEffectPlatformBaseListener r12 = null;
    L10:
        r13.fetchPanelInfoPagingChecked(r14, r15, r16, r17, r18, r19, r20, r11, r12);
        return;
    L9:
        r12 = r22;
        goto L10
    L5:
        r11 = r21;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addCustomizedEffect$default(EffectPlatform r16, long r17, String r19, String r20, int r21, String r22, String r23, int r24, String r25, String r26, Map r27, IEffectPlatformBaseListener r28, int r29, Object r30) {
        if ((r29 & 128) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r29 & 256) == 0) goto L9;
        String r13 = null;
    L11:
        if ((r29 & 512) == 0) goto L13;
        Map r14 = null;
    L15:
        if ((r29 & 1024) == 0) goto L17;
        IEffectPlatformBaseListener r15 = null;
    L18:
        r16.addCustomizedEffect(r17, r19, r20, r21, r22, r23, r24, r12, r13, r14, r15);
        return;
    L17:
        r15 = r28;
        goto L18
    L13:
        r14 = r27;
        goto L15
    L9:
        r13 = r26;
        goto L11
    L5:
        r12 = r25;
        goto L7
    }
}
