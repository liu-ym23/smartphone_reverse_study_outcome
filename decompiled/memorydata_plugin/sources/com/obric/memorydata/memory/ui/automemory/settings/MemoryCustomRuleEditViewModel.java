package com.obric.memorydata.memory.ui.automemory.settings;

import androidx.lifecycle.ViewModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryCustomRuleEditViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryCustomRuleEditUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", ObricMemoryConstants.KEY_SESSION_ID, "", "loaded", "", "bind", "", "sid", "onTextChanged", "newText", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryCustomRuleEditViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "MemoryCustomRuleEditVM";
    private final ae<d> _state;
    private boolean loaded;
    private String sessionId;
    private final ar<d> state;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryCustomRuleEditViewModel$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryCustomRuleEditViewModel() {
        ae<d> r0 = at.a(new d(null, 1, null));
        this._state = r0;
        this.state = k.a(r0);
        this.sessionId = "";
    }

    public static /* synthetic */ b lambda$1p2pqpKbQ781vhedif5bd4Wovv0(String r0, b r1) {
        return onTextChanged$lambda$0(r0, r1);
    }

    private static final b onTextChanged$lambda$0(String r30, b r31) {
        Intrinsics.checkNotNullParameter(r31, "draft");
        if (Intrinsics.areEqual(r31.r().d(), r30) == false) goto L6;
        return r31;
    L6:
        return b.a(r31, null, null, null, null, null, null, false, null, null, null, false, false, null, null, null, 0, 0, e.a(r31.r(), null, null, null, r30, null, null, null, null, 247, null), false, 393215, null);
    }

    public final void bind(String r7) {
        Intrinsics.checkNotNullParameter(r7, "sid");
        if (Intrinsics.areEqual(this.sessionId, r7) == false) goto L5;
        return;
    L5:
        this.sessionId = r7;
        b r0 = g.f10759a.b(r7);
        if (r0 != null) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "session not found: " + r7, null, 4, null);
        return;
    L9:
        this._state.b(new d(r0.r().d()));
        this.loaded = true;
    }

    public final ar<d> getState() {
        return this.state;
    }

    public final void onTextChanged(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "newText");
        if (this.loaded == true) goto L5;
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(((d) ZeusTransformUtils.preCheckCast(this._state.c(), d.class, "com.obric.memorydata.plugin")).a(), r5) == false) goto L13;
        return;
    L13:
        ae<d> r1 = this._state;
        r1.b(((d) ZeusTransformUtils.preCheckCast(r1.c(), d.class, "com.obric.memorydata.plugin")).a(r5));
        g.f10759a.update(this.sessionId, new $$Lambda$MemoryCustomRuleEditViewModel$1p2pqpKbQ781vhedif5bd4Wovv0(r5));
        return;
    L7:
        r0 = false;
        goto L8
    }
}
