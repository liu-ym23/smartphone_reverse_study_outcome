package com.larksuite.component.card.protocol;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import com.larksuite.component.card.protocol.context.ActionContext;
import com.larksuite.component.card.protocol.context.BizContext;
import com.larksuite.component.card.protocol.context.CardStyle;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.card.protocol.context.StreamingState;
import com.larksuite.component.card.protocol.data.action.CardActionDependencyData;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 82\u00020\u0001:\u00018Bw\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/larksuite/component/card/protocol/CardContext;", "Ljava/io/Serializable;", "key", "", "context", "Landroid/content/Context;", "fragment", "Landroidx/fragment/app/Fragment;", "bizContext", "Lcom/larksuite/component/card/protocol/context/BizContext;", "actionContext", "Lcom/larksuite/component/card/protocol/context/ActionContext;", "host", "monitorData", "Lcom/larksuite/component/card/monitor/UniversalCardMonitorData;", "deliveryType", "cardActionDependencyData", "Lcom/larksuite/component/card/protocol/data/action/CardActionDependencyData;", "dependency", "Lcom/larksuite/component/card/protocol/context/ICardDependency;", "cardStyle", "Lcom/larksuite/component/card/protocol/context/CardStyle;", "renderTrace", "Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "streamingState", "Lcom/larksuite/component/card/protocol/context/StreamingState;", "<init>", "(Ljava/lang/String;Landroid/content/Context;Landroidx/fragment/app/Fragment;Lcom/larksuite/component/card/protocol/context/BizContext;Lcom/larksuite/component/card/protocol/context/ActionContext;Ljava/lang/String;Lcom/larksuite/component/card/monitor/UniversalCardMonitorData;Ljava/lang/String;Lcom/larksuite/component/card/protocol/data/action/CardActionDependencyData;Lcom/larksuite/component/card/protocol/context/ICardDependency;Lcom/larksuite/component/card/protocol/context/CardStyle;Lcom/ss/android/lark/opmonitor/trace/OPTrace;Lcom/larksuite/component/card/protocol/context/StreamingState;)V", "getKey", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getBizContext", "()Lcom/larksuite/component/card/protocol/context/BizContext;", "getActionContext", "()Lcom/larksuite/component/card/protocol/context/ActionContext;", "getHost", "getMonitorData", "()Lcom/larksuite/component/card/monitor/UniversalCardMonitorData;", "getDeliveryType", "getCardActionDependencyData", "()Lcom/larksuite/component/card/protocol/data/action/CardActionDependencyData;", "getDependency", "()Lcom/larksuite/component/card/protocol/context/ICardDependency;", "getCardStyle", "()Lcom/larksuite/component/card/protocol/context/CardStyle;", "getRenderTrace", "()Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "setRenderTrace", "(Lcom/ss/android/lark/opmonitor/trace/OPTrace;)V", "getStreamingState", "()Lcom/larksuite/component/card/protocol/context/StreamingState;", "setStreamingState", "(Lcom/larksuite/component/card/protocol/context/StreamingState;)V", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardContext implements Serializable {
    public static final a Companion = null;
    public final transient Context a;
    private final ActionContext actionContext;
    public final transient Fragment b;
    private final BizContext bizContext;
    private final CardActionDependencyData cardActionDependencyData;
    private final CardStyle cardStyle;
    private final String deliveryType;
    private final ICardDependency dependency;
    private final String host;
    private final String key;
    private final UniversalCardMonitorData monitorData;
    private OPTrace renderTrace;
    private StreamingState streamingState;

    public static final class a {

        /* JADX INFO: renamed from: com.larksuite.component.card.protocol.CardContext$a$a, reason: collision with other inner class name */
        public static final class C0026a {
            public String a;
            public OPTrace b;
            public Context c;
            public Fragment d;
            public UniversalCardMonitorData e;
            public BizContext f;
            public ActionContext g;
            public String h;
            public String i;
            public CardActionDependencyData j;
            public ICardDependency k;
            public CardStyle l;
            public StreamingState m;

            public final CardContext a() {
                String r2 = this.a;
                Context r1 = this.c;
                if (r1 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("context");
                Context r4 = null;
            L6:
                Fragment r5 = this.d;
                BizContext r3 = this.f;
                if (r3 != null) goto L9;
                Intrinsics.throwUninitializedPropertyAccessException("bizContext");
                BizContext r6 = null;
            L10:
                ActionContext r7 = this.g;
                String r8 = this.h;
                UniversalCardMonitorData r9 = this.e;
                if (r9 != null) goto L13;
                Intrinsics.throwUninitializedPropertyAccessException("monitorData");
                UniversalCardMonitorData r10 = null;
            L14:
                String r11 = this.i;
                CardActionDependencyData r12 = this.j;
                if (r12 != null) goto L17;
                Intrinsics.throwUninitializedPropertyAccessException("cardActionDependencyData");
                CardActionDependencyData r13 = null;
            L18:
                ICardDependency r14 = this.k;
                if (r14 != null) goto L21;
                Intrinsics.throwUninitializedPropertyAccessException("dependency");
                ICardDependency r15 = null;
            L22:
                CardStyle r16 = this.l;
                if (r16 != null) goto L25;
                Intrinsics.throwUninitializedPropertyAccessException("cardStyle");
                CardStyle r17 = null;
            L26:
                OPTrace r19 = this.b;
                if (r19 != null) goto L29;
                Intrinsics.throwUninitializedPropertyAccessException("renderTrace");
                OPTrace r110 = null;
            L31:
                return new CardContext(r2, r4, r5, r6, r7, r8, r10, r11, r13, r15, r17, r110, this.m, null);
            L29:
                r110 = r19;
                goto L31
            L25:
                r17 = r16;
                goto L26
            L21:
                r15 = r14;
                goto L22
            L17:
                r13 = r12;
                goto L18
            L13:
                r10 = r9;
                goto L14
            L9:
                r6 = r3;
                goto L10
            L5:
                r4 = r1;
                goto L6
            }

            public C0026a() {
                this.a = "";
                this.h = "";
                this.i = "";
            }
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final ActionContext getActionContext() {
        return this.actionContext;
    }

    public final BizContext getBizContext() {
        return this.bizContext;
    }

    public final CardActionDependencyData getCardActionDependencyData() {
        return this.cardActionDependencyData;
    }

    public final CardStyle getCardStyle() {
        return this.cardStyle;
    }

    public final Context getContext() {
        return this.a;
    }

    public final String getDeliveryType() {
        return this.deliveryType;
    }

    public final ICardDependency getDependency() {
        return this.dependency;
    }

    public final Fragment getFragment() {
        return this.b;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getKey() {
        return this.key;
    }

    public final UniversalCardMonitorData getMonitorData() {
        return this.monitorData;
    }

    public final OPTrace getRenderTrace() {
        return this.renderTrace;
    }

    public final StreamingState getStreamingState() {
        return this.streamingState;
    }

    public final void setRenderTrace(OPTrace r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.renderTrace = r2;
    }

    public final void setStreamingState(StreamingState r1) {
        this.streamingState = r1;
    }

    public CardContext(String r1, Context r2, Fragment r3, BizContext r4, ActionContext r5, String r6, UniversalCardMonitorData r7, String r8, CardActionDependencyData r9, ICardDependency r10, CardStyle r11, OPTrace r12, StreamingState r13, DefaultConstructorMarker r14) {
        this.key = r1;
        this.a = r2;
        this.b = r3;
        this.bizContext = r4;
        this.actionContext = r5;
        this.host = r6;
        this.monitorData = r7;
        this.deliveryType = r8;
        this.cardActionDependencyData = r9;
        this.dependency = r10;
        this.cardStyle = r11;
        this.renderTrace = r12;
        this.streamingState = r13;
    }
}
