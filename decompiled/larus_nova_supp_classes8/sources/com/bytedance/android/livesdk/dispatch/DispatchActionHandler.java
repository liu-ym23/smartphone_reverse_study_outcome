package com.bytedance.android.livesdk.dispatch;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.dispatch.handler.GeneralPathDispatchHandler;
import com.bytedance.android.livesdk.dispatch.utils.DispatchLogUtil;
import com.bytedance.android.livesdk.schema.interfaces.BaseSchemaModel;
import com.bytedance.android.livesdk.schema.interfaces.IBaseCallbackSchemaHandler;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J1\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00038\u0006X\u0086D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00038\u0006X\u0086D¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00038\u0006X\u0086D¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/dispatch/DispatchActionHandler;", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseCallbackSchemaHandler;", "Lcom/bytedance/android/livesdk/dispatch/b;", "", "Landroid/net/Uri;", "uri", "", "canHandle", "Landroid/content/Context;", "context", "model", "Lcom/bytedance/android/livesdk/schema/interfaces/IBaseCallbackSchemaHandler$SchemaCallback;", "schemaCallback", "handle", "(Landroid/content/Context;Lcom/bytedance/android/livesdk/dispatch/b;Lcom/bytedance/android/livesdk/schema/interfaces/IBaseCallbackSchemaHandler$SchemaCallback;)Ljava/lang/Boolean;", "LIVE_GENERAL_WAY", "Ljava/lang/String;", "getLIVE_GENERAL_WAY", "()Ljava/lang/String;", "TAG", "getTAG", "isDebug$delegate", "Lkotlin/Lazy;", "isDebug", "()Z", "SlardarErrorTag", "getSlardarErrorTag", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DispatchActionHandler implements IBaseCallbackSchemaHandler<b, String> {
    private final String LIVE_GENERAL_WAY;
    private final String SlardarErrorTag;
    private final String TAG;
    private final Lazy isDebug$delegate;

    private final boolean isDebug() {
        return ((Boolean) this.isDebug$delegate.getValue()).booleanValue();
    }

    public DispatchActionHandler() {
        int r0 = com.bytedance.android.livesdk.dispatch.utils.b.a;
        this.LIVE_GENERAL_WAY = "webcast_dispatch";
        this.TAG = "DispatchActionHandler";
        this.isDebug$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
        this.SlardarErrorTag = "DispatchInvokeException";
    }

    public final String getLIVE_GENERAL_WAY() {
        return this.LIVE_GENERAL_WAY;
    }

    public final String getSlardarErrorTag() {
        return this.SlardarErrorTag;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public boolean canHandle(Uri r5) {
        if (r5 == null) goto L8;
        String r6 = r5.getHost();
        if (r6 != null) goto L7;
        return false;
    L7:
        return StringsKt.startsWith$default(r6, this.LIVE_GENERAL_WAY, false, 2, null);
    L8:
        return false;
    }

    public boolean handle(Context r2, b r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        return IBaseCallbackSchemaHandler.DefaultImpls.handle(this, r2, r3);
    }

    public /* bridge */ /* synthetic */ boolean handle(Context r1, BaseSchemaModel r2) {
        return handle(r1, (b) r2);
    }

    public Boolean handle(Context r6, b r7, IBaseCallbackSchemaHandler.SchemaCallback<String> r8) {
        Intrinsics.checkNotNullParameter(r7, "model");
        if (r7.getUri() == null) goto L5;
        RoomContext r9 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r9 == null) goto L11;
        j r10 = r9.getDispatchContext();
        if (r10 == null) goto L11;
        DataContext r11 = (DataContext) r10.getValue();
    L13:
        if ((r11 instanceof DispatchContext) == true) goto L15;
        r11 = null;
    L15:
        DispatchContext r12 = (DispatchContext) r11;
        if (r12 != null) goto L19;
        r12 = new DispatchContext();
    L19:
        if (r12.getHasInit() == true) goto L36;
        r12.initProxy();
    L36:
        Uri r1 = r7.getUri();     // Catch: Exception -> L30
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L30
        a r0 = new a(r1);     // Catch: Exception -> L30
        r0.a();     // Catch: Exception -> L30
        Lazy r2 = DispatchLogUtil.a;     // Catch: Exception -> L30
        DispatchLogUtil.f(2, r0.a, r0.b, r12);     // Catch: Exception -> L30
        ArrayList r3 = new ArrayList();     // Catch: Exception -> L30
        r3.add(new GeneralPathDispatchHandler());     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(r0, "card");     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(r12, "dispatchContext");     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(r0, "card");     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(r0, "card");     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(r0, "card");     // Catch: Exception -> L30
        Intrinsics.checkNotNullParameter(r12, "dispatchContext");     // Catch: Exception -> L30
        Iterator r4 = r3.iterator();     // Catch: Exception -> L30
        if (r4.hasNext() == false) goto L24;
        Object r5 = r4.next();     // Catch: Exception -> L30
        ((com.bytedance.android.livesdk.dispatch.handler.a) r5).a(r0);     // Catch: Exception -> L30
    L25:
        com.bytedance.android.livesdk.dispatch.handler.a r13 = (com.bytedance.android.livesdk.dispatch.handler.a) r5;     // Catch: Exception -> L30
        if (r13 == null) goto L29;
        r13.b(r0, r8, r12);     // Catch: Exception -> L30
    L29:
        return Boolean.TRUE;
    L24:
        r5 = null;
    L30:
        e = move-exception;
        Lazy r14 = DispatchLogUtil.a;
        DispatchLogUtil.e(100, String.valueOf(r7.getUri()), null);
        ALogger.e(this.TAG, "exception is " + e.toString());
        String r15 = this.SlardarErrorTag;
        SafetyGuard.a(r15, e, r15);
        if (isDebug() == false) goto L34;
        throw e;
    L34:
        return Boolean.FALSE;
    L11:
        r11 = null;
        goto L13
    L5:
        return Boolean.FALSE;
    }

    public /* bridge */ /* synthetic */ Boolean handle(Context r1, BaseSchemaModel r2, IBaseCallbackSchemaHandler.SchemaCallback r3) {
        return handle(r1, (b) r2, r3);
    }
}
