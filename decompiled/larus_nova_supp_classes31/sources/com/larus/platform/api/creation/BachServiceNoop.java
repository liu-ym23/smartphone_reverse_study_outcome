package com.larus.platform.api.creation;

import androidx.lifecycle.MutableLiveData;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zp9.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/larus/platform/api/creation/BachServiceNoop;", "Lcom/larus/platform/api/creation/IBachService;", "<init>", "()V", "digitalAvatarReadyLive", "Landroidx/lifecycle/MutableLiveData;", "", "getDigitalAvatarReadyLive", "()Landroidx/lifecycle/MutableLiveData;", "preLoad", "", "preLoadScene", "Lcom/larus/platform/api/creation/PreLoadScene;", "getDigitalAvatarBachAbility", "Lcom/larus/platform/api/creation/IBachAvatarDetectAbility;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BachServiceNoop implements IBachService {
    public final MutableLiveData<Boolean> b;

    public final i a() {
        return null;
    }

    public final void c(PreLoadScene r2) {
        Intrinsics.checkNotNullParameter(r2, "preLoadScene");
    }

    public BachServiceNoop() {
        this.b = new MutableLiveData(Boolean.FALSE);
    }

    public final MutableLiveData<Boolean> b() {
        return this.b;
    }
}
