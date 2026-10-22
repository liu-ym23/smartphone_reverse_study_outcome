package com.bytedance.ai.bridge.method.sqlite;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.bytedance.ai.bridge.core.AIBridgeMethod$Error;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.widgets.m;
import com.obric.widget.host.runtime.WidgetInstanceManager;
import com.obric.widget.host.runtime.WidgetInstanceRecord;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import m1.k;
import ym.j;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1988c;
    public final /* synthetic */ Object d;

    public /* synthetic */ b(Object r5, int r10, Object r11, Object r12) {
        this.f1986a = r10;
        this.f1988c = r5;
        this.f1987b = r11;
        this.d = r12;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r14) {
        int r5 = 1;
        Object r10 = this.d;
        Object r11 = this.f1987b;
        Object r12 = this.f1988c;
        switch(this.f1986a) {
            case 0: goto L17;
            case 1: goto L16;
            case 2: goto L14;
            default: goto L4;
        };
    L4:
        k r15 = (k) r14;
        m1.i r13 = (m1.i) r12;
        r13.getClass();
        j r16 = (j) r11;
        ProtocolMessage r17 = (ProtocolMessage) r16.f23302a;
        String r18 = r13.a(r17);
        AtomicBoolean r19 = (AtomicBoolean) r10;
        if (r15 == null) goto L8;
        Intrinsics.checkNotNullParameter(r17, "protocolMessage");
        ((Handler) m1.i.f19971j.getValue()).post(new m(new m1.b(r13, r16, r19, 0), new m1.b(r13, r16, r19, 1), (m1.i) r15, r18, r17, 4));
    L12:
        return Unit.INSTANCE;
    L8:
        if (td.d.f22127b == null) goto L10;
        a3.i r110 = a3.i.f83a;
        Intrinsics.checkNotNullParameter(r18, "traceId");
        a3.i.a(new a3.a(r18, r5));
    L10:
        r13.f(r16, new AIBridgeMethod$Error("can not find target runtime", 0), r19);
        String r111 = "[AIBridge] can not find target runtime with target: " + r17.g();
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r111, "msg");
        a1.a.f43a.e("ai_bridge", r111, null);
        goto L12
    L17:
        String r20 = (String) r12;
        o1.f r21 = (o1.f) r11;
        SQLiteDatabase r112 = (SQLiteDatabase) r14;
        Intrinsics.checkNotNullParameter(r112, "db");
        r112.execSQL(r20);     // Catch: SQLException -> L20
        Intrinsics.checkNotNullParameter(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class, "<this>");     // Catch: SQLException -> L20
        r21.b((ResultModel) com.lynx.tasm.behavior.ui.utils.e.c(AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionResultModel.class), "");     // Catch: SQLException -> L20
    L26:
        return Unit.INSTANCE;
    L20:
        e = move-exception;
        String r113 = "invalid sql(" + ((d) r10).f1993b + "): " + e;
        Intrinsics.checkNotNullParameter("ExecuteSqliteActionMethod", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L24;
        r22.e("ExecuteSqliteActionMethod", r113);
    L24:
        r21.a(r113);
        goto L26
    L14:
        return WidgetInstanceManager.a((Ref.BooleanRef) r11, (WidgetInstanceManager) r10, (String) r12, (WidgetInstanceRecord) r14);
    L16:
        return ExecuteSqliteActionMethod.b((ExecuteSqliteActionMethod) r12, (o1.f) r11, (AbsExecuteSqliteActionMethodIDL.ExecuteSqliteActionParamsModel) r10, (AppletRuntime) r14);
    }

    public /* synthetic */ b(Ref.BooleanRef r5, WidgetInstanceManager r10, String r11) {
        this.f1986a = 2;
        this.f1987b = r5;
        this.d = r10;
        this.f1988c = r11;
    }
}
