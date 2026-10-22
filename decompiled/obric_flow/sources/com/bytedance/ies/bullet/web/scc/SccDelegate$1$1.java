package com.bytedance.ies.bullet.web.scc;

import com.lynx.jsbridge.LynxResourceModule;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "eventName", "", LynxResourceModule.PARAMS_KEY, "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class SccDelegate$1$1 extends Lambda implements Function2<String, JSONObject, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Method f6251a;

    public SccDelegate$1$1(Method r5) {
        this.f6251a = r5;
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Unit mo2invoke(String r5, JSONObject r10) {
        String r11 = r5;
        JSONObject r12 = r10;
        this.f6251a.invoke(null, new Object[]{r11, r12});     // Catch: Exception -> L5
    L7:
        return Unit.INSTANCE;
    L5:
        com.bytedance.ies.bullet.base.utils.logger.a.f("SccDelegate", "has no tea reporter.");
        goto L7
    }
}
