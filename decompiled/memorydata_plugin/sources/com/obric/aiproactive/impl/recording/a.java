package com.obric.aiproactive.impl.recording;

import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/aiproactive/impl/recording/AiProactiveDbRequestFactory;", "", "<init>", "()V", "USER_REQUIREMENT_EVENT_NAME", "", "buildEnsureReady", "Lorg/json/JSONObject;", "buildUserRequirementExtra", "", Params.CONTENT, "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6505a = null;

    static {
        f6505a = new a();
    }

    private a() {
    }

    public final Map<String, Object> a(String r2) {
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        return (Map) ZeusTransformUtils.preCheckCast(MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(Params.CONTENT, r2)}), Map.class, "com.obric.memorydata.plugin");
    }

    public final JSONObject a() {
        return new JSONObject();
    }
}
