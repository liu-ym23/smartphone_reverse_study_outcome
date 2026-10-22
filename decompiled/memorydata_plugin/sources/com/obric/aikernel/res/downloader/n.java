package com.obric.aikernel.res.downloader;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH&J\u0011\u0010\n\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u000b\u001a\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH&J\u0011\u0010\u000e\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u000f\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0010\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/obric/aikernel/res/downloader/IDownloadTask;", "", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "finish", "getDownloadInfos", "Lcom/google/gson/JsonObject;", "getId", "", "getProgress", "getStatus", "isDownloaded", "", "pause", "resume", CommonConsts.APM_INNER_EVENT_COST_START, "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface n {
    int a();

    Object a(Continuation<? super Unit> r1);

    Object b(Continuation<? super Unit> r1);

    boolean b();

    Object c(Continuation<? super Unit> r1);

    Object d(Continuation<? super Unit> r1);

    Object e(Continuation<? super Unit> r1);

    Object f(Continuation<? super Integer> r1);

    Object g(Continuation<? super Integer> r1);

    Object h(Continuation<? super JsonObject> r1);
}
