package com.larus.bmhome.block.holder.content.lynx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.SpringLynxBlock;
import com.larus.platform.api.e4;
import com.larus.platform.service.c1;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002QRB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u00100\u001a\u00020$2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u0002H\u0016J\u0018\u00107\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u0002H\u0002J\f\u00108\u001a\u00020\u0013*\u00020\u0013H\u0002J\u0014\u00109\u001a\u00020\u0013*\u00020\u00132\u0006\u0010:\u001a\u00020\u0013H\u0002J\f\u0010;\u001a\u00020<*\u00020<H\u0002J\b\u0010=\u001a\u000204H\u0002J \u0010>\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010@J\u0016\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070DH\u0002J\u0012\u0010E\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J&\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020\u00072\b\b\u0002\u0010J\u001a\u00020'2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010L\u001a\u00020M2\u0006\u00106\u001a\u00020\u0002H\u0016J\b\u0010N\u001a\u000204H\u0002J\b\u0010O\u001a\u00020\u0013H\u0016J\u001e\u0010P\u001a\u0002042\b\b\u0002\u0010J\u001a\u00020'2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/larus/bmhome/block/holder/content/lynx/SpringLynxBlockHolder;", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "Lcom/larus/bmhome/block/model/content/SpringLynxBlockBizModel;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "isInit", "", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "container", "Landroid/widget/FrameLayout;", "lynxView", "Lcom/larus/platform/api/IvyPluginView;", "lynxUrl", "", "updateRunnable", "Ljava/lang/Runnable;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "ivyPool", "Lcom/larus/bmhome/chat/lynx/IIvyPluginViewPool;", "getIvyPool", "()Lcom/larus/bmhome/chat/lynx/IIvyPluginViewPool;", "ivyPool$delegate", "isCreateLynxView", "cachedBindData", "loadingView", "Landroid/view/View;", "errorView", "maxWidth", "", "startTime", "", "reportPocketMessageCardShowTimeoutJob", "Lkotlinx/coroutines/Job;", "retryCount", "lastRetryTimeMs", "blockDependConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockDependConfig;", "onCreatedBlockView", "viewGroup", "Landroid/view/ViewGroup;", "onViewRecycled", "", "onBindBlockView", "blockModel", "initLynxView", "getProcessedData", "convertToActualUrl", "msgId", "appendParamsToInnerUrl", "Landroid/net/Uri;", "ensureLifecycle", "createIvyPluginView", "data", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createIvyPluginViewLifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", "releaseSignal", "Lkotlinx/coroutines/CompletableDeferred;", "isLotteryMsg", "message", "Lcom/larus/im/bean/message/Message;", "reportPocketMessageCardShowed", "lynxViewLoadSuccess", "errorCode", "errorMsg", "getMarginParams", "Lcom/larus/bmhome/chat/block/base/BlockMargin;", "delayReportPocketMessageCardShowTimeout", "getBlockHolderName", "reportPocketMessageCardError", "LynxData", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class SpringLynxBlockHolder extends jc8.b<fb8.k> implements LifecycleOwner {
    public static final /* synthetic */ int v = 0;
    public boolean d;
    public LifecycleRegistry e;
    public FrameLayout f;
    public e4 g;
    public String h;
    public Runnable i;
    public final Lazy j;
    public final Lazy k;
    public boolean l;
    public fb8.k m;
    public View n;
    public View o;
    public int p;
    public long q;
    public Job r;
    public int s;
    public long t;
    public kc8.b u;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/block/holder/content/lynx/SpringLynxBlockHolder$LynxData;", "", "messageData", "", "sessionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessageData", "()Ljava/lang/String;", "getSessionId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
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

    @Override // jc8.b
    public final String c() {
        return "SpringLynxBlockHolder";
    }

    static {
        new Gson();
    }

    public final Lifecycle getLifecycle() {
        LifecycleRegistry r0 = this.e;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        return null;
    L6:
        return r0;
    }

    @Override // jc8.b
    public final void i() {
        e4 r0 = this.g;
        if (r0 == null) goto L10;
        eh8.b r1 = (eh8.b) this.k.getValue();
        if (r1 == null) goto L10;
        String r2 = this.h;
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        r1.a(r2, r0);
    L10:
        LifecycleRegistry r3 = null;
        this.g = null;
        LifecycleRegistry r4 = this.e;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L14:
        r3.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.d = true;
        this.s = 3;
        return;
    L13:
        r3 = r4;
        goto L14
    }

    public SpringLynxBlockHolder() {
        this.d = true;
        this.j = LazyKt.lazy(new l(this));
        this.k = LazyKt.lazy(new m(this));
        this.s = 3;
    }

    @Override // jc8.b
    public final jc8.d f(jc8.a r2) {
        Intrinsics.checkNotNullParameter((fb8.k) r2, "blockModel");
        return new jc8.d(0, 0, 0, 0);
    }

    @Override // jc8.b
    public final void g(jc8.a r20) {
        final fb8.k r1 = (fb8.k) r20;
        Intrinsics.checkNotNullParameter(r1, "blockModel");
        this.u = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (this.d == false) goto L8;
        this.d = false;
        LifecycleRegistry r2 = new LifecycleRegistry(this);
        this.e = r2;
        r2.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        LifecycleRegistry r3 = this.e;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r3 = null;
    L7:
        r3.handleLifecycleEvent(Lifecycle.Event.ON_START);
    L8:
        String r4 = r1.j().getMessageId();
        fb8.k r5 = this.m;
        if (r5 == null) goto L11;
        String r6 = r5.j().getMessageId();
    L12:
        boolean r7 = Intrinsics.areEqual(r4, r6);
        boolean r8 = true;
        boolean r9 = !r7;
        this.m = r1;
        FrameLayout r10 = this.f;
        if (r10 == null) goto L74;
        kc8.b r11 = this.u;
        if (r11 == null) goto L22;
        y r12 = r11.a;
        if (r12 == null) goto L22;
        Function1<Boolean, Unit> r13 = r12.B;
        if (r13 == null) goto L22;
        r13.invoke(Boolean.FALSE);
    L22:
        final e4 r14 = this.g;
        if (r14 == null) goto L33;
        if ((!r9) == true) goto L28;
        r14 = null;
    L28:
        if (r14 == null) goto L33;
        Runnable r15 = new o(r1, r14, this);
        this.i = r15;
        if (this.l == true) goto L71;
        r15.run();
        this.i = null;
        return;
    L71:
        return;
    L33:
        if (this.l == false) goto L35;
        FLogger.a.i("SpringLynxBlockHolder", "initLynxView return, cause isCreateLynxView = true");
        return;
    L35:
        this.l = true;
        this.q = System.currentTimeMillis();
        w r16 = w.a;
        Context r17 = r10.getContext();
        Message r18 = r1.j();
        kc8.b r19 = this.u;
        if (r19 == null) goto L40;
        y r21 = r19.a;
        if (r21 == null) goto L40;
        Integer r110 = r21.j;
    L41:
        de8.c r22 = (de8.c) this.j.getValue();
        if (r22 == null) goto L44;
        Integer r23 = r22.m();
    L45:
        if (r23 != null) goto L48;
        r8 = false;
    L48:
        Boolean r111 = Boolean.valueOf(r8);
        kc8.b r24 = this.u;
        if (r24 == null) goto L53;
        y r25 = r24.a;
        if (r25 == null) goto L53;
        boolean r112 = Intrinsics.areEqual(r25.h, Boolean.TRUE);
    L54:
        this.p = Math.min(w.c(r16, r17, r18, r110, r111, r112, true, null, this.c, 64), ((Number) i5.T1.getValue()).intValue());
        ViewGroup.LayoutParams r26 = r10.getLayoutParams();
        if (r26 == null) goto L70;
        int r27 = this.p;
        r26.width = r27;
        double r28 = r27;
        BlockContent r29 = r1.a.getContent();
        if (r29 == null) goto L63;
        SpringLynxBlock r30 = r29.getSpringLynxBlock();
        if (r30 == null) goto L63;
        Double r31 = r30.ratio;
        if (r31 == null) goto L63;
        double r32 = r31.doubleValue();
    L64:
        r26.height = (int) (r28 * r32);
        r10.setLayoutParams(r26);
        r10.removeAllViews();
        r10.addView(this.n);
        r10.addView(this.o);
        View r33 = this.n;
        if (r33 == null) goto L67;
        r33.setVisibility(0);
    L67:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new SpringLynxBlockHolder$initLynxView$2(this, r1, r10, null), 2, null);
        return;
    L63:
        r32 = 1.0d;
        goto L64
    L70:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L53:
        r112 = false;
        goto L54
    L44:
        r23 = null;
    L40:
        r110 = null;
        goto L41
    L74:
        return;
    L11:
        r6 = null;
        goto L12
    }

    @Override // jc8.b
    public final View h(ViewGroup r6) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        FrameLayout r0 = new FrameLayout(r6.getContext());
        this.f = r0;
        FrameLayout r7 = new FrameLayout(r0.getContext());
        r7.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r7.setBackgroundResource(2131238666);
        r7.setVisibility(8);
        this.n = r7;
        FrameLayout r8 = new FrameLayout(r0.getContext());
        r8.setBackgroundResource(2131238666);
        r8.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r8.setVisibility(8);
        ImageView r1 = new ImageView(r8.getContext());
        r1.setImageResource(2131241825);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(i5.Z(), i5.Z());
        r2.gravity = 17;
        Unit r3 = Unit.INSTANCE;
        r8.addView(r1, r2);
        e1.d(r8, new n(this));
        this.o = r8;
        return r0;
    }

    public final String k(String r4) {
        kc8.b r0 = this.u;
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

    public final void l(boolean r11, int r12, String r13) {
        Job r0 = this.r;
        Message r1 = null;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        fb8.k r2 = this.m;
        if (r2 == null) goto L8;
        r1 = r2.j();
    L8:
        if (r1 == null) goto L10;
        boolean r3 = com.larus.bmhome.chat.bean.d.t0(r1);
    L11:
        if (r3 == false) goto L14;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SpringLynxBlockHolder$reportPocketMessageCardShowed$1(this, r11, r12, r13, null), 3, null);
        return;
    L14:
        return;
    L10:
        r3 = false;
        goto L11
    }

    public static final Object j(SpringLynxBlockHolder r12, String r13, String r14, Continuation r15) {
        r12.getClass();
        if ((r15 instanceof SpringLynxBlockHolder$createIvyPluginView$1) == false) goto L7;
        SpringLynxBlockHolder$createIvyPluginView$1 r0 = (SpringLynxBlockHolder$createIvyPluginView$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        e4 r17 = (e4) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L12:
        e4 r4 = r17;
        if (((Boolean) r16).booleanValue() == false) goto L42;
        return r4;
    L42:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        FLogger.a.i("SpringLynxBlockHolder", "createIvyPluginView, lynxUrl: " + r13);
        c1 r18 = c1.a;
        if (r18.d() == true) goto L18;
        r18.f();
    L18:
        FrameLayout r5 = r12.f;
        if (r5 == null) goto L42;
        Context r6 = r5.getContext();
        if (r6 == null) goto L42;
        fb8.k r7 = r12.m;
        if (r7 == null) goto L26;
        Message r8 = r7.j();
    L27:
        if (r8 == null) goto L29;
        boolean r9 = com.larus.bmhome.chat.bean.d.t0(r8);
    L30:
        if (r9 == false) goto L35;
        Job r10 = r12.r;
        if (r10 == null) goto L34;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L34:
        r12.r = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r12), null, null, new SpringLynxBlockHolder$delayReportPocketMessageCardShowTimeout$1(r12, null), 3, null);
    L35:
        CompletableDeferred r11 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r17 = r18.g(r6, r13, r14, new p(r11, r12));
        r0.L$0 = r17;
        r0.label = 1;
        r16 = r11.await(r0);
        if (r16 != r2) goto L12;
        return r2;
    L29:
        r9 = false;
        goto L30
    L26:
        r8 = null;
    L7:
        r0 = new SpringLynxBlockHolder$createIvyPluginView$1(r12, r15);
        goto L8
    }
}
