package com.ss.android.lark.chameleon.container.webcontainer.preload;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/preload/IPreloaderStrategy;", BuildConfig.FLAVOR, ChameleonOpenTracker.Stage.PRELOAD, BuildConfig.FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IPreloaderStrategy {
    Object preload(Continuation<? super Boolean> r1);
}
