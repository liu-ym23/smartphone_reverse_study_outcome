package com.bytedance.forest.model;

import android.net.Uri;
import androidx.annotation.Keep;
import com.bytedance.forest.Forest;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b_\b\u0017\u0018\u00002\u00020\u0001B\u009b\u0003\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\n\u0012\b\b\u0002\u0010\u001d\u001a\u00020\n\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\b\b\u0002\u0010!\u001a\u00020\n\u0012\b\b\u0002\u0010\"\u001a\u00020\n\u0012\b\b\u0002\u0010#\u001a\u00020\n\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010&\u001a\u00020\n\u0012\b\b\u0002\u0010'\u001a\u00020\n\u0012\b\b\u0002\u0010(\u001a\u00020\u0015\u0012\b\b\u0002\u0010)\u001a\u00020\n\u0012\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\n\u0012\b\b\u0002\u0010.\u001a\u00020\n\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010/¢\u0006\u0004\b1\u00102B\u0011\b\u0016\u0012\u0006\u00103\u001a\u00020\u0000¢\u0006\u0004\b1\u00104J\u000f\u00105\u001a\u00020\u0002H\u0016¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\n¢\u0006\u0004\b7\u00108R\u0017\u0010:\u001a\u0002098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\"\u0010?\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010E\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u00108\"\u0004\bH\u0010IR\"\u0010J\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010F\u001a\u0004\bK\u00108\"\u0004\bL\u0010IR\"\u0010N\u001a\u00020M8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR(\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010Z\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010F\u001a\u0004\b[\u00108\"\u0004\b\\\u0010IR(\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00020]8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR*\u0010e\u001a\u00020\u00022\u0006\u0010d\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u00106\"\u0004\bh\u0010iR\"\u0010j\u001a\u0002098\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bj\u0010;\u001a\u0004\bk\u0010=\"\u0004\bl\u0010mR\u001d\u0010s\u001a\u0004\u0018\u00010n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010f\u001a\u0004\bt\u00106R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010u\u001a\u0004\bv\u0010wR.\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010}\u001a\u0004\b~\u0010\u007fR$\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u000b\u0010F\u001a\u0005\b\u0080\u0001\u00108\"\u0005\b\u0081\u0001\u0010IR$\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\f\u0010F\u001a\u0005\b\u0082\u0001\u00108\"\u0005\b\u0083\u0001\u0010IR$\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\r\u0010F\u001a\u0005\b\u0084\u0001\u00108\"\u0005\b\u0085\u0001\u0010IR$\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u000e\u0010F\u001a\u0005\b\u0086\u0001\u00108\"\u0005\b\u0087\u0001\u0010IR$\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u000f\u0010F\u001a\u0005\b\u0088\u0001\u00108\"\u0005\b\u0089\u0001\u0010IR$\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u0010\u0010F\u001a\u0005\b\u008a\u0001\u00108\"\u0005\b\u008b\u0001\u0010IR$\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u0011\u0010F\u001a\u0005\b\u008c\u0001\u00108\"\u0005\b\u008d\u0001\u0010IR$\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u0012\u0010F\u001a\u0005\b\u008e\u0001\u00108\"\u0005\b\u008f\u0001\u0010IR$\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u0013\u0010F\u001a\u0005\b\u0090\u0001\u00108\"\u0005\b\u0091\u0001\u0010IR$\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u0014\u0010F\u001a\u0005\b\u0092\u0001\u00108\"\u0005\b\u0093\u0001\u0010IR'\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0016\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R'\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0018\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R#\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b\u0019\u0010F\u001a\u0004\b\u0019\u00108\"\u0005\b\u009e\u0001\u0010IR$\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u001a\u0010f\u001a\u0005\b\u009f\u0001\u00106\"\u0005\b \u0001\u0010iR$\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u001b\u0010F\u001a\u0005\b¡\u0001\u00108\"\u0005\b¢\u0001\u0010IR$\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u001c\u0010F\u001a\u0005\b£\u0001\u00108\"\u0005\b¤\u0001\u0010IR$\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\u001d\u0010F\u001a\u0005\b¥\u0001\u00108\"\u0005\b¦\u0001\u0010IR*\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b \u0010U\u001a\u0005\b§\u0001\u0010W\"\u0005\b¨\u0001\u0010YR#\u0010!\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b!\u0010F\u001a\u0004\b!\u00108\"\u0005\b©\u0001\u0010IR$\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\"\u0010F\u001a\u0005\bª\u0001\u00108\"\u0005\b«\u0001\u0010IR$\u0010#\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b#\u0010F\u001a\u0005\b¬\u0001\u00108\"\u0005\b\u00ad\u0001\u0010IR&\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b$\u0010f\u001a\u0005\b®\u0001\u00106\"\u0005\b¯\u0001\u0010iR)\u0010%\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b%\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R$\u0010&\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b&\u0010F\u001a\u0005\bµ\u0001\u00108\"\u0005\b¶\u0001\u0010IR$\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b'\u0010F\u001a\u0005\b·\u0001\u00108\"\u0005\b¸\u0001\u0010IR'\u0010(\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b(\u0010\u0094\u0001\u001a\u0006\b¹\u0001\u0010\u0096\u0001\"\u0006\bº\u0001\u0010\u0098\u0001R$\u0010)\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b)\u0010F\u001a\u0005\b»\u0001\u00108\"\u0005\b¼\u0001\u0010IR$\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\r\n\u0004\b*\u0010x\u001a\u0005\b½\u0001\u0010zR%\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+8\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\b,\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001R$\u0010-\u001a\u00020\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\b-\u0010F\u001a\u0005\bÁ\u0001\u00108\"\u0005\bÂ\u0001\u0010IR$\u0010.\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b.\u0010F\u001a\u0005\bÃ\u0001\u00108\"\u0005\bÄ\u0001\u0010IR,\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b0\u0010U\u001a\u0005\bÅ\u0001\u0010W\"\u0005\bÆ\u0001\u0010YR+\u0010É\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010d\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÇ\u0001\u00106\"\u0005\bÈ\u0001\u0010iR+\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010d\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÊ\u0001\u00106\"\u0005\bË\u0001\u0010i¨\u0006Í\u0001"}, d2 = {"Lcom/bytedance/forest/model/Request;", "", "", "originUrl", "Lcom/bytedance/forest/Forest;", "forest", "", "customParams", "Lcom/bytedance/forest/model/m;", "geckoModel", "", "waitGeckoUpdate", "onlyLocal", "disableCdn", "disableBuiltin", "disableOffline", "disableGeckoUpdate", "loadToMemory", "useConcurrentBuffer", "allowIOOnMainThread", "checkGeckoFileAvailable", "", "loadRetryTimes", "Lcom/bytedance/forest/model/Scene;", "scene", "isASync", "groupId", "enableNegotiation", "enableMemoryCache", "enableCDNCache", "", "Lcom/bytedance/forest/model/FetcherType;", "fetcherSequence", "isPreload", "enableRequestReuse", "ignoreWaitReusedRequest", "sessionId", "webResourceRequest", "needLocalFile", "streamingLoad", "customHttpMaxAge", "useGeckoNewlyBuiltin", "injectedHttpHeaders", "", "cacheKeySensitiveQueries", "cacheKeyUASensitive", "cdnRegionRedirect", "", "redirectRegions", "<init>", "(Ljava/lang/String;Lcom/bytedance/forest/Forest;Ljava/util/Map;Lcom/bytedance/forest/model/m;ZZZZZZZZZZILcom/bytedance/forest/model/Scene;ZLjava/lang/String;ZZZLjava/util/List;ZZZLjava/lang/String;Ljava/lang/Object;ZZIZLjava/util/Map;Ljava/util/Set;ZZLjava/util/List;)V", "request", "(Lcom/bytedance/forest/model/Request;)V", "toString", "()Ljava/lang/String;", "isWebRequest", "()Z", "Landroid/net/Uri;", "originUri", "Landroid/net/Uri;", "getOriginUri", "()Landroid/net/Uri;", "Lcom/bytedance/forest/model/GeckoSource;", "geckoSource", "Lcom/bytedance/forest/model/GeckoSource;", "getGeckoSource", "()Lcom/bytedance/forest/model/GeckoSource;", "setGeckoSource", "(Lcom/bytedance/forest/model/GeckoSource;)V", "useInteraction", "Z", "getUseInteraction", "setUseInteraction", "(Z)V", "onlyOnline", "getOnlyOnline", "setOnlyOnline", "Lcom/bytedance/forest/pollyfill/m;", "netDepender", "Lcom/bytedance/forest/pollyfill/m;", "getNetDepender$forest_release", "()Lcom/bytedance/forest/pollyfill/m;", "setNetDepender$forest_release", "(Lcom/bytedance/forest/pollyfill/m;)V", "fallbackDomains", "Ljava/util/List;", "getFallbackDomains", "()Ljava/util/List;", "setFallbackDomains", "(Ljava/util/List;)V", "supportShuffle", "getSupportShuffle", "setSupportShuffle", "Ljava/util/LinkedList;", "remainedFallbackDomains", "Ljava/util/LinkedList;", "getRemainedFallbackDomains$forest_release", "()Ljava/util/LinkedList;", "setRemainedFallbackDomains$forest_release", "(Ljava/util/LinkedList;)V", "value", "url", "Ljava/lang/String;", "getUrl", "setUrl", "(Ljava/lang/String;)V", LynxResourceModule.URI_KEY, "getUri$forest_release", "setUri$forest_release", "(Landroid/net/Uri;)V", "Lcom/bytedance/forest/utils/a;", "cacheKey$delegate", "Lkotlin/Lazy;", "getCacheKey$forest_release", "()Lcom/bytedance/forest/utils/a;", "cacheKey", "getOriginUrl", "Lcom/bytedance/forest/Forest;", "getForest", "()Lcom/bytedance/forest/Forest;", "Ljava/util/Map;", "getCustomParams", "()Ljava/util/Map;", "setCustomParams", "(Ljava/util/Map;)V", "Lcom/bytedance/forest/model/m;", "getGeckoModel", "()Lcom/bytedance/forest/model/m;", "getWaitGeckoUpdate", "setWaitGeckoUpdate", "getOnlyLocal", "setOnlyLocal", "getDisableCdn", "setDisableCdn", "getDisableBuiltin", "setDisableBuiltin", "getDisableOffline", "setDisableOffline", "getDisableGeckoUpdate", "setDisableGeckoUpdate", "getLoadToMemory", "setLoadToMemory", "getUseConcurrentBuffer", "setUseConcurrentBuffer", "getAllowIOOnMainThread", "setAllowIOOnMainThread", "getCheckGeckoFileAvailable", "setCheckGeckoFileAvailable", "I", "getLoadRetryTimes", "()I", "setLoadRetryTimes", "(I)V", "Lcom/bytedance/forest/model/Scene;", "getScene", "()Lcom/bytedance/forest/model/Scene;", "setScene", "(Lcom/bytedance/forest/model/Scene;)V", "setASync", "getGroupId", "setGroupId", "getEnableNegotiation", "setEnableNegotiation", "getEnableMemoryCache", "setEnableMemoryCache", "getEnableCDNCache", "setEnableCDNCache", "getFetcherSequence", "setFetcherSequence", "setPreload", "getEnableRequestReuse", "setEnableRequestReuse", "getIgnoreWaitReusedRequest", "setIgnoreWaitReusedRequest", "getSessionId", "setSessionId", "Ljava/lang/Object;", "getWebResourceRequest", "()Ljava/lang/Object;", "setWebResourceRequest", "(Ljava/lang/Object;)V", "getNeedLocalFile", "setNeedLocalFile", "getStreamingLoad", "setStreamingLoad", "getCustomHttpMaxAge", "setCustomHttpMaxAge", "getUseGeckoNewlyBuiltin", "setUseGeckoNewlyBuiltin", "getInjectedHttpHeaders", "Ljava/util/Set;", "getCacheKeySensitiveQueries$forest_release", "()Ljava/util/Set;", "getCacheKeyUASensitive$forest_release", "setCacheKeyUASensitive$forest_release", "getCdnRegionRedirect", "setCdnRegionRedirect", "getRedirectRegions", "setRedirectRegions", "getPreloadFrom", "setPreloadFrom", "preloadFrom", "getInjectedUserAgent", "setInjectedUserAgent", "injectedUserAgent", "forest_release"}, k = 1, mv = {1, 4, 0})
public class Request {
    private boolean allowIOOnMainThread;
    private final Lazy cacheKey$delegate;
    private final Set<String> cacheKeySensitiveQueries;
    private boolean cacheKeyUASensitive;
    private boolean cdnRegionRedirect;
    private boolean checkGeckoFileAvailable;
    private int customHttpMaxAge;
    private Map<String, Object> customParams;
    private boolean disableBuiltin;
    private boolean disableCdn;
    private boolean disableGeckoUpdate;
    private boolean disableOffline;
    private boolean enableCDNCache;
    private boolean enableMemoryCache;
    private boolean enableNegotiation;
    private boolean enableRequestReuse;
    private List<String> fallbackDomains;
    private List<FetcherType> fetcherSequence;
    private final Forest forest;
    private final m geckoModel;
    private GeckoSource geckoSource;
    private String groupId;
    private boolean ignoreWaitReusedRequest;
    private final Map<String, String> injectedHttpHeaders;
    private boolean isASync;
    private boolean isPreload;
    private int loadRetryTimes;
    private boolean loadToMemory;
    private boolean needLocalFile;
    public com.bytedance.forest.pollyfill.m netDepender;
    private boolean onlyLocal;
    private boolean onlyOnline;
    private final Uri originUri;
    private final String originUrl;
    private List<String> redirectRegions;
    private LinkedList<String> remainedFallbackDomains;
    private Scene scene;
    private String sessionId;
    private boolean streamingLoad;
    private boolean supportShuffle;
    private Uri uri;
    private String url;
    private boolean useConcurrentBuffer;
    private boolean useGeckoNewlyBuiltin;
    private boolean useInteraction;
    private boolean waitGeckoUpdate;
    private Object webResourceRequest;

    public Request(String r5, Forest r10, Map<String, Object> r11, m r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r110, boolean r111, boolean r112, int r113, Scene r20, boolean r21, String r22, boolean r23, boolean r24, boolean r25, List<FetcherType> r26, boolean r27, boolean r28, boolean r29, String r30, Object r31, boolean r32, boolean r33, int r34, boolean r35, Map<String, String> r36, Set<String> r37, boolean r38, boolean r39, List<String> r40) {
        this.originUrl = r5;
        this.forest = r10;
        this.customParams = r11;
        this.geckoModel = r12;
        this.waitGeckoUpdate = r13;
        this.onlyLocal = r14;
        this.disableCdn = r15;
        this.disableBuiltin = r16;
        this.disableOffline = r17;
        this.disableGeckoUpdate = r18;
        this.loadToMemory = r19;
        this.useConcurrentBuffer = r110;
        this.allowIOOnMainThread = r111;
        this.checkGeckoFileAvailable = r112;
        this.loadRetryTimes = r113;
        this.scene = r20;
        this.isASync = r21;
        this.groupId = r22;
        this.enableNegotiation = r23;
        this.enableMemoryCache = r24;
        this.enableCDNCache = r25;
        this.fetcherSequence = r26;
        this.isPreload = r27;
        this.enableRequestReuse = r28;
        this.ignoreWaitReusedRequest = r29;
        this.sessionId = r30;
        this.webResourceRequest = r31;
        this.needLocalFile = r32;
        this.streamingLoad = r33;
        this.customHttpMaxAge = r34;
        this.useGeckoNewlyBuiltin = r35;
        this.injectedHttpHeaders = r36;
        this.cacheKeySensitiveQueries = r37;
        this.cacheKeyUASensitive = r38;
        this.cdnRegionRedirect = r39;
        this.redirectRegions = r40;
        Uri r41 = Uri.parse(r5);
        this.originUri = r41;
        this.geckoSource = GeckoSource.f4322b;
        this.fallbackDomains = CollectionsKt.emptyList();
        this.remainedFallbackDomains = new LinkedList();
        this.url = r5;
        this.uri = r41;
        this.cacheKey$delegate = LazyKt.lazy(new Request$cacheKey$2(this));
    }

    public final boolean getAllowIOOnMainThread() {
        return this.allowIOOnMainThread;
    }

    public final com.bytedance.forest.utils.a getCacheKey$forest_release() {
        return (com.bytedance.forest.utils.a) this.cacheKey$delegate.getValue();
    }

    public final Set<String> getCacheKeySensitiveQueries$forest_release() {
        return this.cacheKeySensitiveQueries;
    }

    public final boolean getCacheKeyUASensitive$forest_release() {
        return this.cacheKeyUASensitive;
    }

    public final boolean getCdnRegionRedirect() {
        return this.cdnRegionRedirect;
    }

    public final boolean getCheckGeckoFileAvailable() {
        return this.checkGeckoFileAvailable;
    }

    public final int getCustomHttpMaxAge() {
        return this.customHttpMaxAge;
    }

    public final Map<String, Object> getCustomParams() {
        return this.customParams;
    }

    public final boolean getDisableBuiltin() {
        return this.disableBuiltin;
    }

    public final boolean getDisableCdn() {
        return this.disableCdn;
    }

    public final boolean getDisableGeckoUpdate() {
        return this.disableGeckoUpdate;
    }

    public final boolean getDisableOffline() {
        return this.disableOffline;
    }

    public final boolean getEnableCDNCache() {
        return this.enableCDNCache;
    }

    public final boolean getEnableMemoryCache() {
        return this.enableMemoryCache;
    }

    public final boolean getEnableNegotiation() {
        return this.enableNegotiation;
    }

    public final boolean getEnableRequestReuse() {
        return this.enableRequestReuse;
    }

    public final List<String> getFallbackDomains() {
        return this.fallbackDomains;
    }

    public final List<FetcherType> getFetcherSequence() {
        return this.fetcherSequence;
    }

    public final Forest getForest() {
        return this.forest;
    }

    public final m getGeckoModel() {
        return this.geckoModel;
    }

    public final GeckoSource getGeckoSource() {
        return this.geckoSource;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final boolean getIgnoreWaitReusedRequest() {
        return this.ignoreWaitReusedRequest;
    }

    public final Map<String, String> getInjectedHttpHeaders() {
        return this.injectedHttpHeaders;
    }

    public final String getInjectedUserAgent() {
        Object r5 = this.customParams.get("x-forest-injected-ua");
        if ((r5 instanceof String) == true) goto L6;
        r5 = null;
    L6:
        return (String) r5;
    }

    public final int getLoadRetryTimes() {
        return this.loadRetryTimes;
    }

    public final boolean getLoadToMemory() {
        return this.loadToMemory;
    }

    public final boolean getNeedLocalFile() {
        return this.needLocalFile;
    }

    public final com.bytedance.forest.pollyfill.m getNetDepender$forest_release() {
        com.bytedance.forest.pollyfill.m r5 = this.netDepender;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("netDepender");
    L5:
        return r5;
    }

    public final boolean getOnlyLocal() {
        return this.onlyLocal;
    }

    public final boolean getOnlyOnline() {
        return this.onlyOnline;
    }

    public final Uri getOriginUri() {
        return this.originUri;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final String getPreloadFrom() {
        Object r5 = this.customParams.get("x-forest-preload-from");
        if ((r5 instanceof String) == true) goto L6;
        r5 = null;
    L6:
        return (String) r5;
    }

    public final List<String> getRedirectRegions() {
        return this.redirectRegions;
    }

    public final LinkedList<String> getRemainedFallbackDomains$forest_release() {
        return this.remainedFallbackDomains;
    }

    public final Scene getScene() {
        return this.scene;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final boolean getStreamingLoad() {
        return this.streamingLoad;
    }

    public final boolean getSupportShuffle() {
        return this.supportShuffle;
    }

    public final Uri getUri$forest_release() {
        return this.uri;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean getUseConcurrentBuffer() {
        return this.useConcurrentBuffer;
    }

    public final boolean getUseGeckoNewlyBuiltin() {
        return this.useGeckoNewlyBuiltin;
    }

    public final boolean getUseInteraction() {
        return this.useInteraction;
    }

    public final boolean getWaitGeckoUpdate() {
        return this.waitGeckoUpdate;
    }

    public final Object getWebResourceRequest() {
        return this.webResourceRequest;
    }

    public final boolean isASync() {
        return this.isASync;
    }

    public final boolean isPreload() {
        return this.isPreload;
    }

    public final boolean isWebRequest() {
        if (this.webResourceRequest != null) goto L11;
        Scene r5 = this.scene;
        if (r5 != Scene.f4352l) goto L7;
        return true;
    L7:
        if (r5 == Scene.f4351k) goto L14;
        return false;
    L14:
        return true;
    L11:
        return true;
    }

    public final void setASync(boolean r5) {
        this.isASync = r5;
    }

    public final void setAllowIOOnMainThread(boolean r5) {
        this.allowIOOnMainThread = r5;
    }

    public final void setCacheKeyUASensitive$forest_release(boolean r5) {
        this.cacheKeyUASensitive = r5;
    }

    public final void setCdnRegionRedirect(boolean r5) {
        this.cdnRegionRedirect = r5;
    }

    public final void setCheckGeckoFileAvailable(boolean r5) {
        this.checkGeckoFileAvailable = r5;
    }

    public final void setCustomHttpMaxAge(int r5) {
        this.customHttpMaxAge = r5;
    }

    public final void setCustomParams(Map<String, Object> r5) {
        this.customParams = r5;
    }

    public final void setDisableBuiltin(boolean r5) {
        this.disableBuiltin = r5;
    }

    public final void setDisableCdn(boolean r5) {
        this.disableCdn = r5;
    }

    public final void setDisableGeckoUpdate(boolean r5) {
        this.disableGeckoUpdate = r5;
    }

    public final void setDisableOffline(boolean r5) {
        this.disableOffline = r5;
    }

    public final void setEnableCDNCache(boolean r5) {
        this.enableCDNCache = r5;
    }

    public final void setEnableMemoryCache(boolean r5) {
        this.enableMemoryCache = r5;
    }

    public final void setEnableNegotiation(boolean r5) {
        this.enableNegotiation = r5;
    }

    public final void setEnableRequestReuse(boolean r5) {
        this.enableRequestReuse = r5;
    }

    public final void setFallbackDomains(List<String> r5) {
        this.fallbackDomains = r5;
    }

    public final void setFetcherSequence(List<FetcherType> r5) {
        this.fetcherSequence = r5;
    }

    public final void setGeckoSource(GeckoSource r5) {
        this.geckoSource = r5;
    }

    public final void setGroupId(String r5) {
        this.groupId = r5;
    }

    public final void setIgnoreWaitReusedRequest(boolean r5) {
        this.ignoreWaitReusedRequest = r5;
    }

    public final void setInjectedUserAgent(String r5) {
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        this.customParams.put("x-forest-injected-ua", r5);
    }

    public final void setLoadRetryTimes(int r5) {
        this.loadRetryTimes = r5;
    }

    public final void setLoadToMemory(boolean r5) {
        this.loadToMemory = r5;
    }

    public final void setNeedLocalFile(boolean r5) {
        this.needLocalFile = r5;
    }

    public final void setNetDepender$forest_release(com.bytedance.forest.pollyfill.m r5) {
        this.netDepender = r5;
    }

    public final void setOnlyLocal(boolean r5) {
        this.onlyLocal = r5;
    }

    public final void setOnlyOnline(boolean r5) {
        this.onlyOnline = r5;
    }

    public final void setPreload(boolean r5) {
        this.isPreload = r5;
    }

    public final void setPreloadFrom(String r5) {
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        this.customParams.put("x-forest-preload-from", r5);
    }

    public final void setRedirectRegions(List<String> r5) {
        this.redirectRegions = r5;
    }

    public final void setRemainedFallbackDomains$forest_release(LinkedList<String> r5) {
        this.remainedFallbackDomains = r5;
    }

    public final void setScene(Scene r5) {
        this.scene = r5;
    }

    public final void setSessionId(String r5) {
        this.sessionId = r5;
    }

    public final void setStreamingLoad(boolean r5) {
        this.streamingLoad = r5;
    }

    public final void setSupportShuffle(boolean r5) {
        this.supportShuffle = r5;
    }

    public final void setUri$forest_release(Uri r5) {
        this.uri = r5;
    }

    public final void setUrl(String r5) {
        if (Intrinsics.areEqual(this.url, r5) == false) goto L5;
        return;
    L5:
        this.url = r5;
        this.uri = Uri.parse(r5);
    }

    public final void setUseConcurrentBuffer(boolean r5) {
        this.useConcurrentBuffer = r5;
    }

    public final void setUseGeckoNewlyBuiltin(boolean r5) {
        this.useGeckoNewlyBuiltin = r5;
    }

    public final void setUseInteraction(boolean r5) {
        this.useInteraction = r5;
    }

    public final void setWaitGeckoUpdate(boolean r5) {
        this.waitGeckoUpdate = r5;
    }

    public final void setWebResourceRequest(Object r5) {
        this.webResourceRequest = r5;
    }

    public String toString() {
        return super.toString() + "(geckoModel=" + this.geckoModel + ", waitGeckoUpdate=" + this.waitGeckoUpdate + ", disableGeckoUpdate=" + this.disableGeckoUpdate + ",  onlyLocal=" + this.onlyLocal + ", disableCdn=" + this.disableCdn + ", disableBuiltin=" + this.disableBuiltin + ", disableOffline=" + this.disableOffline + ", loadToMemory=" + this.loadToMemory + ", ioConcurrency=" + this.useConcurrentBuffer + ", allowIOOnMainThread=" + this.allowIOOnMainThread + ", checkGeckoFileAvailable=" + this.checkGeckoFileAvailable + ", loadRetryTimes=" + this.loadRetryTimes + ", scene=" + this.scene + ", isASync=" + this.isASync + ", groupId='" + this.groupId + "', enableNegotiation=" + this.enableNegotiation + ", enableMemoryCache=" + this.enableMemoryCache + ", enableCDNCache=" + this.enableCDNCache + ", fetcherSequence=" + this.fetcherSequence + ", isPreload=" + this.isPreload + ", enableRequestReuse=" + this.enableRequestReuse + ", ignoreWaitReusedRequest=" + this.ignoreWaitReusedRequest + ",sessionId=" + this.sessionId + ", geckoSource=" + this.geckoSource + ", useInteraction=" + this.useInteraction + ", onlyOnline=" + this.onlyOnline + ", customHttpMaxAge=" + this.customHttpMaxAge + ", useGeckoNewlyBuiltin=" + this.useGeckoNewlyBuiltin + ", requestHeaders=" + this.injectedHttpHeaders + ", cacheKeyUASensitive=" + this.cacheKeyUASensitive + ", cacheKeySensitiveQueries=" + this.cacheKeySensitiveQueries + " originUrl='" + this.originUrl + "', customParams=" + this.customParams + ')';
    }

    public /* synthetic */ Request(String r42, Forest r43, Map r44, m r45, boolean r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, boolean r53, boolean r54, boolean r55, int r56, Scene r57, boolean r58, String r59, boolean r60, boolean r61, boolean r62, List r63, boolean r64, boolean r65, boolean r66, String r67, Object r68, boolean r69, boolean r70, int r71, boolean r72, Map r73, Set r74, boolean r75, boolean r76, List r77, int r78, int r79, DefaultConstructorMarker r80) {
        if ((r78 & 8) == 0) goto L5;
        m r10 = new m("", "", "");
    L7:
        if ((r78 & 16) == 0) goto L9;
        boolean r11 = false;
    L11:
        if ((r78 & 32) == 0) goto L13;
        boolean r12 = false;
    L15:
        if ((r78 & 64) == 0) goto L17;
        boolean r13 = false;
    L19:
        if ((r78 & 128) == 0) goto L21;
        boolean r14 = false;
    L23:
        if ((r78 & 256) == 0) goto L25;
        boolean r15 = false;
    L27:
        if ((r78 & 512) == 0) goto L29;
        boolean r16 = false;
    L31:
        if ((r78 & 1024) == 0) goto L33;
        boolean r17 = false;
    L35:
        if ((r78 & 2048) == 0) goto L37;
        boolean r18 = false;
    L39:
        if ((r78 & 4096) == 0) goto L41;
        boolean r19 = false;
    L43:
        if ((r78 & 8192) == 0) goto L45;
        boolean r110 = true;
    L47:
        if ((r78 & 16384) == 0) goto L49;
        int r111 = 0;
    L51:
        if ((32768 & r78) == 0) goto L53;
        Scene r20 = Scene.f4354n;
    L55:
        if ((65536 & r78) == 0) goto L57;
        boolean r21 = false;
    L59:
        if ((131072 & r78) == 0) goto L61;
        String r22 = "";
    L63:
        if ((262144 & r78) == 0) goto L65;
        boolean r23 = false;
    L67:
        if ((524288 & r78) == 0) goto L69;
        List r5 = b.f4359a;
        boolean r24 = false;
    L71:
        if ((1048576 & r78) == 0) goto L73;
        List r25 = b.f4359a;
        boolean r26 = true;
    L75:
        if ((2097152 & r78) == 0) goto L77;
        List r27 = new ArrayList();
    L79:
        if ((4194304 & r78) == 0) goto L81;
        boolean r28 = false;
    L83:
        if ((8388608 & r78) == 0) goto L85;
        boolean r29 = false;
    L87:
        if ((16777216 & r78) == 0) goto L89;
        boolean r210 = false;
    L91:
        if ((33554432 & r78) == 0) goto L93;
        String r30 = null;
    L95:
        if ((67108864 & r78) == 0) goto L97;
        Object r31 = null;
    L99:
        if ((134217728 & r78) == 0) goto L101;
        boolean r32 = false;
    L103:
        if ((268435456 & r78) == 0) goto L105;
        boolean r33 = false;
    L107:
        if ((536870912 & r78) == 0) goto L109;
        int r34 = 0;
    L111:
        if ((1073741824 & r78) == 0) goto L113;
        boolean r35 = false;
    L115:
        if ((r78 & Integer.MIN_VALUE) == 0) goto L117;
        Map r36 = new LinkedHashMap();
    L119:
        if ((r79 & 1) == 0) goto L121;
        Set r37 = null;
    L123:
        if ((r79 & 2) == 0) goto L125;
        boolean r38 = false;
    L127:
        if ((r79 & 4) == 0) goto L129;
        boolean r39 = false;
    L131:
        if ((r79 & 8) == 0) goto L133;
        List r40 = null;
    L134:
        this(r42, r43, r44, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r22, r23, r24, r26, r27, r28, r29, r210, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40);
        return;
    L133:
        r40 = r77;
        goto L134
    L129:
        r39 = r76;
        goto L131
    L125:
        r38 = r75;
        goto L127
    L121:
        r37 = r74;
        goto L123
    L117:
        r36 = r73;
        goto L119
    L113:
        r35 = r72;
        goto L115
    L109:
        r34 = r71;
        goto L111
    L105:
        r33 = r70;
        goto L107
    L101:
        r32 = r69;
        goto L103
    L97:
        r31 = r68;
        goto L99
    L93:
        r30 = r67;
        goto L95
    L89:
        r210 = r66;
        goto L91
    L85:
        r29 = r65;
        goto L87
    L81:
        r28 = r64;
        goto L83
    L77:
        r27 = r63;
        goto L79
    L73:
        r26 = r62;
        goto L75
    L69:
        r24 = r61;
        goto L71
    L65:
        r23 = r60;
        goto L67
    L61:
        r22 = r59;
        goto L63
    L57:
        r21 = r58;
        goto L59
    L53:
        r20 = r57;
        goto L55
    L49:
        r111 = r56;
        goto L51
    L45:
        r110 = r55;
        goto L47
    L41:
        r19 = r54;
        goto L43
    L37:
        r18 = r53;
        goto L39
    L33:
        r17 = r52;
        goto L35
    L29:
        r16 = r51;
        goto L31
    L25:
        r15 = r50;
        goto L27
    L21:
        r14 = r49;
        goto L23
    L17:
        r13 = r48;
        goto L19
    L13:
        r12 = r47;
        goto L15
    L9:
        r11 = r46;
        goto L11
    L5:
        r10 = r45;
        goto L7
    }

    public Request(Request r40) {
        this(r40.originUrl, r40.forest, r40.customParams, r40.geckoModel, r40.waitGeckoUpdate, r40.onlyLocal, r40.disableCdn, r40.disableBuiltin, r40.disableOffline, r40.disableGeckoUpdate, r40.loadToMemory, r40.useConcurrentBuffer, r40.allowIOOnMainThread, r40.checkGeckoFileAvailable, r40.loadRetryTimes, r40.scene, r40.isASync, r40.groupId, r40.enableNegotiation, r40.enableMemoryCache, r40.enableCDNCache, r40.fetcherSequence, r40.isPreload, r40.enableRequestReuse, r40.ignoreWaitReusedRequest, r40.sessionId, r40.webResourceRequest, r40.needLocalFile, r40.streamingLoad, r40.customHttpMaxAge, r40.useGeckoNewlyBuiltin, r40.injectedHttpHeaders, r40.cacheKeySensitiveQueries, r40.cacheKeyUASensitive, r40.cdnRegionRedirect, r40.redirectRegions);
        this.geckoSource = r40.geckoSource;
        this.useInteraction = r40.useInteraction;
        this.onlyOnline = r40.onlyOnline;
        com.bytedance.forest.pollyfill.m r5 = r40.netDepender;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("netDepender");
    L5:
        this.netDepender = r5;
        this.fallbackDomains = r40.fallbackDomains;
        this.supportShuffle = r40.supportShuffle;
        this.remainedFallbackDomains.addAll(r40.remainedFallbackDomains);
    }
}
