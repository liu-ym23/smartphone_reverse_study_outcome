package com.obric.aiproactive.ui.settings;

import androidx.lifecycle.ViewModel;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_initiativeLevel", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/aiproactive/ui/settings/InitiativeLevel;", "initiativeLevel", "Lkotlinx/coroutines/flow/StateFlow;", "getInitiativeLevel", "()Lkotlinx/coroutines/flow/StateFlow;", "repository", "Lcom/obric/aiproactive/ui/settings/InitiativeLevelRepository;", "boundUserId", "", "bind", "", "userId", "refresh", "select", "level", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveSettingsViewModel extends ViewModel {
    private final ae<InitiativeLevel> _initiativeLevel;
    private String boundUserId;
    private final ar<InitiativeLevel> initiativeLevel;
    private a repository;

    public ProactiveSettingsViewModel() {
        ae<InitiativeLevel> r0 = at.a(InitiativeLevel.BALANCED);
        this._initiativeLevel = r0;
        this.initiativeLevel = k.a(r0);
    }

    public static /* synthetic */ void bind$default(ProactiveSettingsViewModel r1, a r2, String r3, int r4, Object r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = AppContext.INSTANCE.getUserId();
    L5:
        r1.bind(r6, r3);
    }

    public final void bind(a r3, String r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "repository");
        this.repository = r5;
        this.boundUserId = r4;
        refresh();
    }

    public final ar<InitiativeLevel> getInitiativeLevel() {
        return this.initiativeLevel;
    }

    public final void refresh() {
        a r0 = this.repository;
        if (r0 != null) goto L5;
        return;
    L5:
        this._initiativeLevel.b(r0.a(this.boundUserId));
    }

    public final void select(InitiativeLevel r3) {
        Intrinsics.checkNotNullParameter(r3, "level");
        a r0 = this.repository;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this._initiativeLevel.c() != r3) goto L8;
        return;
    L8:
        r0.a(this.boundUserId, r3);
        this._initiativeLevel.b(r3);
    }
}
