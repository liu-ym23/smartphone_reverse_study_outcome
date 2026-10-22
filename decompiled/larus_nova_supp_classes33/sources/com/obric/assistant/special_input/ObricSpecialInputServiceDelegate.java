package com.obric.assistant.special_input;

import android.content.Context;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001f\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\u0011\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u0096\u0001¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/special_input/ObricSpecialInputServiceDelegate;", "Lcom/obric/assistant/special_input/IObricSpecialInputService;", "<init>", "()V", "closeSpecialInputBeforeMicOn", "", "getBuryPointState", "", "getComplexClarifyMessageExtra", "", "relatedTask", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "getObricVariantInputWidget", "", "context", "Landroid/content/Context;", "isAssistantRequestFromAIKey", "", "isFeatureEnable", "featureKey", "mapActionBarKey", "origin", "replayCallForMe", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSpecialInputServiceDelegate implements IObricSpecialInputService {
    public static final ObricSpecialInputServiceDelegate b = null;
    public final /* synthetic */ IObricSpecialInputService a;

    static {
        b = new ObricSpecialInputServiceDelegate();
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final void a() {
        this.a.a();
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final Object b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.b(r2);
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final boolean c() {
        Intrinsics.checkNotNullParameter("obric_feature_check_device_locked", "featureKey");
        return this.a.c();
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final void d() {
        this.a.d();
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final String e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        return this.a.e(r2);
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final String f() {
        return this.a.f();
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final Map<String, String> g(DMTaskState r2) {
        return this.a.g(r2);
    }

    @Override // com.obric.assistant.special_input.IObricSpecialInputService
    public final boolean isAssistantRequestFromAIKey() {
        return this.a.isAssistantRequestFromAIKey();
    }

    private ObricSpecialInputServiceDelegate() {
        this.a = (IObricSpecialInputService) ServiceManager.get().getService(IObricSpecialInputService.class);
    }
}
