package com.obric.memorydata.personalcontext.datausage.plugin.action;

import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BasePCGetImageUrlIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCGetImageUrlParams;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.middleware.impl.image.ImageUploadResult;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/GetImageUrlIntent;", "Lcom/obric/capabilitykit/common/intent/BasePCGetImageUrlIntent;", "<init>", "()V", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "Lcom/obric/capabilitykit/common/intent/Empty;", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/PCGetImageUrlParams;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/obric/capabilitykit/common/intent/PCGetImageUrlParams;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GetImageUrlIntent extends BasePCGetImageUrlIntent {
    public static final a Companion = null;
    private static final String TAG = "GetImageUrlIntent";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/GetImageUrlIntent$Companion;", "", "<init>", "()V", "TAG", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public GetImageUrlIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCGetImageUrlIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, Continuation<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.memorydata.plugin");
        Continuation<? super IntentResult<Empty>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return doAction((PCGetImageUrlParams) ZeusTransformUtils.preCheckCast(r6, PCGetImageUrlParams.class, "com.obric.memorydata.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BasePCGetImageUrlIntent
    public Object doAction(PCGetImageUrlParams r31, DispatchContext r32, Continuation<? super IntentResult<Empty>> r33) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r33, Continuation.class, "com.obric.memorydata.plugin");
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "user not agree privacy", false, 4, null);
        return new IntentResult(0, null, null, null, false, false, 256, null, null, null, 958, null);
    L6:
        String r1 = r31.getQueryId();
        if (r1 == null) goto L11;
        List<ImageUploadResult> r2 = com.obric.memorydata.middleware.impl.image.a.f11712a.a(r1, TimeUnit.SECONDS.toMillis(5));
        RunLog.INSTANCE.debug(TAG, "response: " + r2);
        return new IntentResult(0, null, null, u.a().toJson(r2), false, false, 256, null, null, null, 950, null);
    L11:
        return new IntentResult(0, null, null, null, false, false, 256, null, null, null, 958, null);
    }
}
