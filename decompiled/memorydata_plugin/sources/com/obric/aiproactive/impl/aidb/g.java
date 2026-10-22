package com.obric.aiproactive.impl.aidb;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\b\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/AiProactiveFeedbackReportConfig;", "", "<init>", "()V", "TAG", "", "policy", "Lcom/obric/aiproactive/impl/aidb/FeedbackReportPolicy;", "settingsChangeListener", "com/obric/aiproactive/impl/aidb/AiProactiveFeedbackReportConfig$settingsChangeListener$1", "Lcom/obric/aiproactive/impl/aidb/AiProactiveFeedbackReportConfig$settingsChangeListener$1;", "shouldUploadFeedback", "", "uid", "loadPolicy", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f6361a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile r f6362b;
    private static final a c = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/aiproactive/impl/aidb/AiProactiveFeedbackReportConfig$settingsChangeListener$1", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements SettingsChangeListener {
        a() {
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r7) {
            Intrinsics.checkNotNullParameter(r7, "key");
            if (Intrinsics.areEqual(r7, SettingsManager.KEY_AI_PROACTIVE_DATA_COLLECTION_WHITELIST) == true) goto L5;
            return;
        L5:
            r r6 = g.a(g.f6361a);
            g r8 = g.f6361a;
            g.a(r6);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AiProactiveFeedbackReportConfig", "feedback report config changed, enabled=" + r6.a() + ", blacklistSize=" + r6.b().size(), false, 4, null);
        }
    }

    static {
        g r0 = new g();
        f6361a = r0;
        f6362b = r0.a();
        a r1 = new a();
        c = r1;
        SettingsManager.INSTANCE.registerChangeListener(SettingsManager.KEY_AI_PROACTIVE_DATA_COLLECTION_WHITELIST, (SettingsChangeListener) ZeusTransformUtils.preCheckCast(r1, SettingsChangeListener.class, "com.obric.memorydata.plugin"));
    }

    private g() {
    }

    private final r a() {
        return f.c(SettingsManager.INSTANCE.getSettingsStr(SettingsManager.KEY_AI_PROACTIVE_DATA_COLLECTION_WHITELIST));
    }

    public static final /* synthetic */ r a(g r0) {
        return r0.a();
    }

    public static final /* synthetic */ void a(r r0) {
        f6362b = r0;
    }

    public final boolean a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        r r3 = f6362b;
        if (r3.a() == true) goto L5;
    L9:
        return false;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L9;
        if (r3.b().contains(r4) == true) goto L9;
        return true;
    }
}
