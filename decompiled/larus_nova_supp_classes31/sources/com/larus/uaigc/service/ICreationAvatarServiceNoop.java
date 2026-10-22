package com.larus.uaigc.service;

import androidx.fragment.app.DialogFragment;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u001dH\u0096@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016¨\u0006'"}, d2 = {"Lcom/larus/uaigc/service/ICreationAvatarServiceNoop;", "Lcom/larus/uaigc/service/ICreationAvatarService;", "<init>", "()V", "clearAvatarWhiteTUrl", "", "getDigitalAvatarOnboardingCacheManager", "Lcom/larus/platform/model/creation/IDigitalAvatarOnboardingCacheManager;", "createDigitalAvatarTemplateListDialogFragment", "Landroidx/fragment/app/DialogFragment;", "model", "Lcom/larus/uaigc/avatar/DigitalAvatarTemplateModel;", "createDigitalAvatarRouteInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "hasCreatedAvatar", "", "isAvatarInCreating", "isAvatarCreated", "initFetch", "getDigitalAvatarPreGenImagesOfScan", "", "Lcom/larus/uaigc/avatar/api/PreGenImage;", "getDigitalAvatarPreGenImagesOfUpload", "getDigitalAvatarPreGenImages", "getDigitalAvatarMasterPreGenImage", "getDigitalAvatarRefVideo", "Lcom/larus/uaigc/avatar/api/AiReplicaRefVideo;", "updateDigitalAvatarIpaMainTempUrl", "tempUrl", "", "updateDigitalAvatarIpaMainTempUri", "tempUri", "needCompleteVideoAvatar", "getAiReplicaInfo", "Lcom/larus/uaigc/api/AiReplicaInfoData;", "fetchAiReplicaIpaMainUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "avatarCleared", "avatarCreated", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ICreationAvatarServiceNoop implements ICreationAvatarService {
    public ICreationAvatarServiceNoop() {
    }

    public final Object C(Continuation<? super String> r1) {
        return null;
    }

    public final void F() {
    }

    public final com.larus.uaigc.api.a G() {
        return null;
    }

    public final List<ey9.k> K() {
        return null;
    }

    public final void O() {
    }

    public final void P() {
    }

    public final List<ey9.k> Q() {
        return null;
    }

    public final boolean S() {
        return false;
    }

    public final void T(String r1) {
    }

    public final boolean U() {
        return false;
    }

    public final q97.a a() {
        return null;
    }

    public final void c(String r1) {
    }

    public final sq9.u d() {
        return null;
    }

    public final boolean h() {
        return false;
    }

    public final void i() {
    }

    public final ey9.k p() {
        return null;
    }

    public final ey9.a q() {
        return null;
    }

    public final List<ey9.k> u() {
        return null;
    }

    public final boolean v() {
        return false;
    }

    public final DialogFragment R(dy9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        return new DialogFragment();
    }
}
