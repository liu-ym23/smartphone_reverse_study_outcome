package com.larus.bmhome.video;

import android.content.Context;
import com.larus.bmhome.bigimg.download.b;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJË\u0001\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00112(\u0010\u0012\u001a$\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2 \b\u0002\u0010\u0017\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u001bJ*\u0010\u001c\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u0018H¦@¢\u0006\u0002\u0010\u001e¨\u0006 "}, d2 = {"Lcom/larus/bmhome/video/IVideoDownloadLoadingMgrService;", "", "saveVideoAndLoading", "", "context", "Landroid/content/Context;", "downloadTaskKey", "", "videoPlayData", "Lcom/larus/platform/model/video/VideoPlayData;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "traceBlk", "Lkotlin/Function0;", "enableUseSRDownLoad", "", "metaDataMap", "", "finishCallback", "Lkotlin/Function4;", "", "", "saveCreationTaskIdBlk", "onInterceptUrl", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "isAIGC", "(Landroid/content/Context;Ljava/lang/String;Lcom/larus/platform/model/video/VideoPlayData;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;ZLjava/util/Map;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "collectLoadingStatus", "urlLoadingAction", "(Lcom/larus/platform/model/video/VideoPlayData;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IVideoDownloadLoadingMgrService {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final Lazy<IVideoDownloadLoadingMgrService> b = null;

        public a() {
        }

        static {
            a = new a();
            b = LazyKt.lazy(new d());
        }
    }

    static {
        a = a.a;
    }

    Object a(nr9.g r1, b r2, Continuation r3);

    void b(Context r1, String r2, nr9.g r3, CoroutineScope r4, Function0<Unit> r5, boolean r6, Map<String, String> r7, Function4<? super Integer, ? super String, ? super Long, ? super Boolean, Unit> r8, Function0<Unit> r9, Function1<? super Continuation<? super String>, ? extends Object> r10, boolean r11);
}
