package com.obric.sva.sdk.session;

import android.content.Context;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.session.legacy.LegacyWakeupSession;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\r"}, d2 = {"Lcom/obric/sva/sdk/session/BreathWakeupSession;", "Lcom/obric/sva/sdk/session/legacy/LegacyWakeupSession;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getSessionType", "Lcom/obric/sva/sdk/session/SessionType;", "getModelUuid", "", "getModelIndex", "", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class BreathWakeupSession extends LegacyWakeupSession {
    public static final int BREATH_INDEX = 0;
    public static final String BREATH_UUID = "06200920-34d0-7424-2415-232243156984";
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/sva/sdk/session/BreathWakeupSession$Companion;", "", "<init>", "()V", "BREATH_UUID", "", "BREATH_INDEX", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.obric.sva.sdk.session.legacy.LegacyWakeupSession
    public int getModelIndex() {
        return 0;
    }

    @Override // com.obric.sva.sdk.session.legacy.LegacyWakeupSession
    public String getModelUuid() {
        return BREATH_UUID;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public SessionType getSessionType() {
        return SessionType.BREATH;
    }

    public BreathWakeupSession(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }
}
