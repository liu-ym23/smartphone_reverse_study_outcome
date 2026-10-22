package com.larus.bmhome.block.holder.content.lynx;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.LynxBlock;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.e4;
import com.larus.platform.service.c1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CancellationException;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002WXB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0002H\u0016J\u0010\u00109\u001a\u00020:2\u0006\u00108\u001a\u00020\u0002H\u0016J\b\u0010;\u001a\u000207H\u0016J\u0018\u0010<\u001a\u0002072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0002H\u0002J\b\u0010=\u001a\u000207H\u0002J\u0012\u0010>\u001a\u0002072\b\u0010?\u001a\u0004\u0018\u00010\u0013H\u0002J\f\u0010@\u001a\u00020\u000b*\u00020\u000bH\u0002J\f\u0010A\u001a\u00020\u000b*\u00020\u000bH\u0002J\f\u0010B\u001a\u00020C*\u00020CH\u0002J\b\u0010D\u001a\u000207H\u0002J \u0010E\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\u00020I2\u0006\u0010\u0014\u001a\u00020\u000b2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00070KH\u0002J\b\u0010L\u001a\u00020\u000bH\u0016J.\u0010M\u001a\u0002072\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u00072\b\b\u0002\u0010O\u001a\u00020/2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010Q\u001a\u000207H\u0002J\u001e\u0010R\u001a\u0002072\b\b\u0002\u0010O\u001a\u00020/2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u000bH\u0002J3\u0010S\u001a\b\u0012\u0004\u0012\u0002070T2\u0006\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010O\u001a\u00020/2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\bU\u0010VR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001d\u0010#\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b%\u0010&R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/larus/bmhome/block/holder/content/lynx/LynxCardBlockHolder;", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "Lcom/larus/bmhome/block/model/content/LynxCardBlockBizModel;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "isInit", "", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "TAG", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "container", "Landroid/widget/FrameLayout;", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "lynxUrl", "loadingLynxUrl", "creatingLynxView", "initJob", "Lkotlinx/coroutines/Job;", "updateRunnable", "Ljava/lang/Runnable;", "blockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "ivyPool", "Lcom/larus/bmhome/chat/lynx/IIvyPluginViewPool;", "getIvyPool", "()Lcom/larus/bmhome/chat/lynx/IIvyPluginViewPool;", "ivyPool$delegate", "isCreateLynxView", "bindGeneration", "", "cachedBindData", "errorView", "Landroid/view/View;", "maxWidth", "", "startTime", "retryCount", "lastRetryTimeMs", "onCreatedBlockView", "viewGroup", "Landroid/view/ViewGroup;", "onBindBlockView", "", "blockModel", "getMarginParams", "Lcom/larus/bmhome/chat/block/base/BlockMargin;", "onViewRecycled", "initLynxView", "cancelLynxInitialization", "detachFromParent", "view", "getProcessedData", "convertToActualUrl", "appendParamsToInnerUrl", "Landroid/net/Uri;", "ensureLifecycle", "createIvyPluginView", "data", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createIvyPluginViewLifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", "releaseSignal", "Lkotlinx/coroutines/CompletableDeferred;", "getBlockHolderName", "reportPocketMessageCardShowed", "lynxViewLoadSuccess", "errorCode", "errorMsg", "delayReportPocketMessageCardShowTimeout", "reportPocketMessageCardError", "monitorLynxException", "Lkotlin/Result;", "monitorLynxException-0E7RQCE", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Object;", "LynxData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LynxCardBlockHolder extends jc8.b<fb8.g> implements LifecycleOwner {
    public static final /* synthetic */ int y = 0;
    public boolean d;
    public LifecycleRegistry e;
    public final String f;
    public FrameLayout g;
    public e4 h;
    public String i;
    public String j;
    public e4 k;
    public Job l;
    public Runnable m;
    public kc8.b n;
    public final Lazy o;
    public final Lazy p;
    public boolean q;
    public long r;
    public fb8.g s;
    public View t;
    public int u;
    public long v;
    public int w;
    public long x;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/block/holder/content/lynx/LynxCardBlockHolder$LynxData;", "", "messageData", "", "sessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessageData", "()Ljava/lang/String;", "getSessionId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b {

        @SerializedName("message_data")
        private final String messageData;

        @SerializedName("session_id")
        private final String sessionId;

        public b() {
            this(null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.messageData, r6.messageData) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sessionId, r6.sessionId) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.messageData;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.sessionId;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "LynxData(messageData=" + this.messageData + ", sessionId=" + this.sessionId + ')';
        }

        public b(String r1, String r2) {
            this.messageData = r1;
            this.sessionId = r2;
        }
    }

    static {
    }

    @Override // jc8.b
    public final String c() {
        return "LynxCardBlockHolder";
    }

    public final Lifecycle getLifecycle() {
        LifecycleRegistry r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        return null;
    L6:
        return r0;
    }

    public final void k() {
        this.r++;
        Job r0 = this.l;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.l = null;
        m(this.k);
        this.k = null;
        this.j = null;
        this.q = false;
    }

    public LynxCardBlockHolder() {
        this.d = true;
        this.f = "LynxCardBlockHolder-" + hashCode();
        this.o = LazyKt.lazy(new c(this));
        this.p = LazyKt.lazy(new d(this));
        this.w = 3;
    }

    @Override // jc8.b
    public final void i() {
        k();
        e4 r0 = this.h;
        if (r0 == null) goto L10;
        eh8.b r1 = (eh8.b) this.p.getValue();
        if (r1 == null) goto L10;
        String r2 = this.i;
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        r1.a(r2, r0);
    L10:
        LifecycleRegistry r3 = null;
        this.h = null;
        this.i = null;
        this.m = null;
        this.s = null;
        LifecycleRegistry r4 = this.e;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L14:
        r3.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.d = true;
        this.w = 3;
        return;
    L13:
        r3 = r4;
        goto L14
    }

    public static void r(LynxCardBlockHolder r5) {
        String r0 = r5.i;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r5.p(r0, DoraCallStateCode.DOUBAO_STOP_CALL_BY_CONVERSATION_MODE, null);
        FLogger.a.e(r5.f, "reportPocketMessageCardError: " + DoraCallStateCode.DOUBAO_STOP_CALL_BY_CONVERSATION_MODE + ", errorMsg: null");
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((fb8.g) r2, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    @Override // jc8.b
    public final void g(jc8.a r26) {
        final fb8.g r10 = (fb8.g) r26;
        Intrinsics.checkNotNullParameter(r10, "blockModel");
        this.n = (kc8.b) jc8.c.a(this, kc8.b.class);
        Integer r8 = null;
        if (this.d == false) goto L8;
        this.d = false;
        LifecycleRegistry r0 = new LifecycleRegistry(this);
        this.e = r0;
        r0.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        LifecycleRegistry r1 = this.e;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r1 = null;
    L7:
        r1.handleLifecycleEvent(Lifecycle.Event.ON_START);
    L8:
        BlockContent r2 = r10.a.getContent();
        if (r2 == null) goto L11;
        LynxBlock r11 = r2.getLynxBlock();
    L12:
        fb8.g r3 = this.s;
        if (r3 == null) goto L15;
        Message r4 = r3.j();
    L16:
        boolean r12 = true;
        if (r4 != null) goto L19;
    L21:
        final boolean r5 = false;
    L22:
        if (r11 == null) goto L31;
        String r6 = r11.lynxUrl;
        if (r6 == null) goto L31;
        if (o0.d(r6) == true) goto L29;
        r6 = null;
    L29:
        if (r6 == null) goto L31;
        final String r7 = l(r6);
    L32:
        String r9 = this.i;
        if (r9 != null) goto L35;
        r9 = this.j;
    L35:
        final String r13 = r9;
        if (r13 != null) goto L38;
    L40:
        boolean r14 = false;
    L41:
        if (r5 == true) goto L45;
        if (r14 == true) goto L45;
        boolean r15 = false;
    L46:
        FLogger r16 = FLogger.a;
        if (r16.isDebug() == false) goto L49;
        final LynxBlock r17 = r11;
        r16.g(this.f, new f(r10, r17, r5, r13, r7, this));
    L49:
        FrameLayout r18 = this.g;
        if (r18 == null) goto L130;
        kc8.b r19 = this.n;
        if (r19 == null) goto L59;
        y r20 = r19.a;
        if (r20 == null) goto L59;
        Function1<Boolean, Unit> r21 = r20.B;
        if (r21 == null) goto L59;
        r21.invoke(Boolean.FALSE);
    L59:
        final String r22 = "";
        if (r15 == false) goto L70;
        k();
        e4 r23 = this.h;
        if (r23 == null) goto L69;
        eh8.b r24 = (eh8.b) this.p.getValue();
        if (r24 == null) goto L69;
        String r25 = this.i;
        if (r25 != null) goto L68;
        r25 = "";
    L68:
        r24.a(r25, r23);
    L69:
        this.h = null;
        this.i = null;
        this.m = null;
    L70:
        this.s = r10;
        if (r11 == null) goto L75;
        String r27 = r11.lynxData;
        if (r27 == null) goto L75;
        String r28 = o(r27);
    L76:
        if (r28 == null) goto L79;
        r22 = r28;
    L79:
        final e4 r29 = this.h;
        if (r29 == null) goto L84;
        Runnable r30 = new g(r29, r22);
        this.m = r30;
        if (this.q == true) goto L124;
        r30.run();
        this.m = null;
    L124:
        if (r16.isDebug() == false) goto L129;
        r16.g(this.f, new i(r10));
        return;
    L129:
        return;
    L84:
        boolean r31 = this.q;
        if (r31 == false) goto L87;
        this.m = new h(this, r22);
        goto L124
    L87:
        if (r31 == false) goto L89;
        r16.e(this.f, "initLynxView return, cause isCreateLynxView = true");
        goto L124
    L89:
        this.q = true;
        long r32 = this.r;
        Message r33 = r10.j();
        BlockContent r34 = r10.a.getContent();
        if (r34 == null) goto L101;
        LynxBlock r35 = r34.getLynxBlock();
        if (r35 == null) goto L101;
        String r36 = r35.lynxUrl;
        if (r36 == null) goto L101;
        if (o0.d(r36) == true) goto L99;
        r36 = null;
    L99:
        if (r36 == null) goto L101;
        String r37 = l(r36);
    L102:
        this.j = r37;
        this.v = System.currentTimeMillis();
        w r110 = w.a;
        Context r111 = r18.getContext();
        Message r112 = r10.j();
        kc8.b r38 = this.n;
        if (r38 == null) goto L107;
        y r39 = r38.a;
        if (r39 == null) goto L107;
        Integer r113 = r39.j;
    L108:
        de8.c r40 = (de8.c) this.o.getValue();
        if (r40 == null) goto L111;
        r8 = r40.m();
    L111:
        if (r8 != null) goto L114;
        r12 = false;
    L114:
        Boolean r114 = Boolean.valueOf(r12);
        kc8.b r41 = this.n;
        if (r41 == null) goto L119;
        y r42 = r41.a;
        if (r42 == null) goto L119;
        boolean r210 = Intrinsics.areEqual(r42.h, Boolean.TRUE);
    L120:
        this.u = w.c(r110, r111, r112, r113, r114, r210, true, null, this.c, 64);
        ViewGroup.LayoutParams r43 = r18.getLayoutParams();
        if (r43 == null) goto L128;
        r43.width = this.u;
        r43.height = -2;
        r18.setLayoutParams(r43);
        r18.removeAllViews();
        r18.addView(this.t);
        this.l = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new LynxCardBlockHolder$initLynxView$2(r10, r37, this, r33, r32, r18, null), 3, null);
        goto L124
    L128:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L119:
        r210 = false;
    L107:
        r113 = null;
    L101:
        r37 = null;
    L75:
        r28 = null;
        goto L76
    L130:
        return;
    L45:
        r15 = true;
        goto L46
    L38:
        if (Intrinsics.areEqual(r13, r7) == true) goto L40;
        r14 = true;
    L31:
        r7 = null;
        goto L32
    L19:
        if (k.a(r4.getMessageId(), r4.getLocalMessageId(), r10.j().getMessageId(), r10.j().getLocalMessageId()) == true) goto L21;
        r5 = true;
        goto L22
    L15:
        r4 = null;
        goto L16
    L11:
        r11 = null;
        goto L12
    }

    @Override // jc8.b
    public final View h(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        FrameLayout r0 = new FrameLayout(r6.getContext());
        this.g = r0;
        FrameLayout r7 = new FrameLayout(r0.getContext());
        r7.setBackgroundResource(2131238666);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r7.setVisibility(8);
        ImageView r1 = new ImageView(r7.getContext());
        r1.setImageResource(2131241825);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(i5.Z(), i5.Z());
        r2.gravity = 17;
        Unit r3 = Unit.INSTANCE;
        r7.addView(r1, r2);
        e1.d(r7, new e(this));
        this.t = r7;
        return r0;
    }

    public final String l(String r3) {
        Uri r0 = y0.j(r3);
        if (r0 != null) goto L5;
        return r3;
    L5:
        Uri r4 = y0.l(y0.l(y0.l(r0, "loader_name", "forest"), "forest_newly_builtin", "1"), "enable_lynx_generic_fetcher", "1");
        if (AppHost.a.isTestChannel() == false) goto L22;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L14;
        FlowAppletServiceImpl r2 = r1.g0();
        if (r2 == null) goto L14;
        boolean r5 = true;
        if (r2.e() != true) goto L14;
    L15:
        if (r5 == false) goto L22;
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L22;
        FlowAppletServiceImpl r7 = r6.g0();
        if (r7 == null) goto L22;
        r4 = y0.a(r4, r7.f());
    L14:
        r5 = false;
    L22:
        return r4.toString();
    }

    public final void m(e4 r3) {
        if (r3 == null) goto L13;
        View r4 = r3.getView();
        if (r4 == null) goto L15;
        ViewParent r0 = r4.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L9;
        ViewGroup r1 = (ViewGroup) r0;
    L10:
        if (r1 == null) goto L14;
        r1.removeView(r4);
        return;
    L14:
        return;
    L9:
        r1 = null;
        goto L10
    L15:
        return;
    }

    public final String o(String r4) {
        kc8.b r0 = this.n;
        if (r0 == null) goto L9;
        y r1 = r0.a;
        if (r1 == null) goto L9;
        Fragment r2 = r1.a;
        if (r2 == null) goto L9;
        String r3 = Integer.valueOf(r2.hashCode()).toString();
    L10:
        zd9.h r5 = zd9.h.a;
        b r6 = new b(r4, r3);
        r5.getClass();
        String r7 = zd9.h.c(r6);
        if (r7 != null) goto L14;
        return "";
    L14:
        return r7;
    L9:
        r3 = null;
        goto L10
    }

    public final void p(String r9, int r10, String r11) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L8
        r3.put("load_time", System.currentTimeMillis() - this.v);     // Catch: Throwable -> L8
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L8
        r4.put("load_time", System.currentTimeMillis() - this.v);     // Catch: Throwable -> L8
        r4.put("lynx_url", r9);     // Catch: Throwable -> L8
        r4.put("error_code", r10);     // Catch: Throwable -> L8
        r4.put("error_msg", r11);     // Catch: Throwable -> L8
        fb8.g r12 = this.s;     // Catch: Throwable -> L8
        if (r12 == null) goto L6;
        r4.put("message_id", r12.j().getMessageId());     // Catch: Throwable -> L8
        r4.put("message_index", r12.j().getServerIndex());     // Catch: Throwable -> L8
    L6:
        com.larus.platform.service.o.a.reportEvent("dev_lynx_card_load_failed", r4);     // Catch: Throwable -> L8
        com.larus.platform.service.g.a.monitorEventForSlardar("dev_lynx_card_load_failed", r4, r3, null);     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static final Object j(LynxCardBlockHolder r11, String r12, String r13, Continuation r14) {
        r11.getClass();
        if ((r14 instanceof LynxCardBlockHolder$createIvyPluginView$1) == false) goto L7;
        LynxCardBlockHolder$createIvyPluginView$1 r1 = (LynxCardBlockHolder$createIvyPluginView$1) r14;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r15 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L17;
        long r16 = r1.J$1;
        long r5 = r1.J$0;
        e4 r6 = (e4) r1.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: CancellationException -> L14
    L28:
        boolean r17 = ((Boolean) r15).booleanValue();     // Catch: CancellationException -> L14
        long r7 = System.currentTimeMillis() - r5;     // Catch: CancellationException -> L14
        FLogger.a.i(r11.f, "createIvyPluginView, total=" + r7 + " ts1=" + (r16 - r5) + " ts2=" + (System.currentTimeMillis() - r16));     // Catch: CancellationException -> L14
        r11.k = null;     // Catch: CancellationException -> L14
        if (r17 == true) goto L39;
        r11.m(r6);     // Catch: CancellationException -> L14
    L44:
        return null;
    L39:
        return r6;
    L14:
        e = move-exception;
        e = e;
        e4 r18 = r6;
    L35:
        r11.m(r18);
        if (r11.k != r18) goto L38;
        r11.k = null;
    L38:
        throw e;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        long r8 = System.currentTimeMillis();
        FrameLayout r19 = r11.g;
        if (r19 == null) goto L44;
        Context r110 = r19.getContext();
        if (r110 == null) goto L44;
        CompletableDeferred r9 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r18 = c1.a.g(r110, r12, r13, new j(r11, r9, r12));
        r11.k = r18;
        long r111 = System.currentTimeMillis();
        r1.L$0 = r18;     // Catch: CancellationException -> L34
        r1.J$0 = r8;     // Catch: CancellationException -> L34
        r1.J$1 = r111;     // Catch: CancellationException -> L34
        r1.label = 1;     // Catch: CancellationException -> L34
        Object r10 = r9.await(r1);     // Catch: CancellationException -> L34
        if (r10 == r3) goto L45;
        r5 = r8;
        r6 = r18;
        r16 = r111;
        r15 = r10;
        goto L28
    L45:
        return r3;
    L34:
        e = e;
    L7:
        r1 = new LynxCardBlockHolder$createIvyPluginView$1(r11, r14);
        goto L8
    }

    public final void s(String r4, boolean r5, int r6, String r7) {
        if (r5 == true) goto L5;
        p(r4, r6, r7);
        FLogger.a.e(this.f, "reportPocketMessageCardShowed: lynxViewLoadSuccess=" + r5 + ", errorCode=" + r6 + ", errorMsg=" + r7);
        return;
    }
}
