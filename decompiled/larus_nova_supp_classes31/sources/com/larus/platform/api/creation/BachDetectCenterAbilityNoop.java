package com.larus.platform.api.creation;

import android.net.Uri;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001f\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¨\u0006\u0012"}, d2 = {"Lcom/larus/platform/api/creation/BachDetectCenterAbilityNoop;", "Lcom/larus/platform/api/creation/IBachDetectCenterAbility;", "<init>", "()V", "enableBachDetect", "", "detectAvatarUri", "", "uri", "Landroid/net/Uri;", "searchBachDetectResult", "remove", "(Landroid/net/Uri;Z)Ljava/lang/Boolean;", "cancelBachDetectTask", "redirectDetectUri", "oldUri", "newUri", "tryDetect", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BachDetectCenterAbilityNoop implements IBachDetectCenterAbility {
    public BachDetectCenterAbilityNoop() {
    }

    @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
    public final void a(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
    }

    @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
    public final boolean b() {
        return false;
    }

    @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
    public final Boolean c(Uri r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
    public final void d(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
    }

    @Override // com.larus.platform.api.creation.IBachDetectCenterAbility
    public final void e(Uri r1, Uri r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "oldUri");
        Intrinsics.checkNotNullParameter(r2, "newUri");
    }
}
