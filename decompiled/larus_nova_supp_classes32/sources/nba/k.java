package nba;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public /* synthetic */ k(boolean r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke(Object r11) {
        boolean r1 = this.a;
        String r2 = this.b;
        String r3 = this.c;
        String r4 = this.d;
        String r5 = this.e;
        String r6 = this.f;
        String r7 = this.g;
        IFlowAppLogDataObserverIDL r0 = (IFlowAppLogDataObserverIDL) r11;
        Intrinsics.checkNotNullParameter(r0, "it");
        FLogger.a.d("AppLogIDLStub", "dataObserverList, onRemoteIdGet");
        r0.onRemoteIdGet(r1, r2, r3, r4, r5, r6, r7);
        return Unit.INSTANCE;
    }
}
