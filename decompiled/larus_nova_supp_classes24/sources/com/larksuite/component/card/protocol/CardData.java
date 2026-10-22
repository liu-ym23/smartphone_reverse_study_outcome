package com.larksuite.component.card.protocol;

import com.larksuite.component.card.protocol.data.CardContent;
import com.larksuite.component.card.protocol.data.CardTranslateInfo;
import com.larksuite.component.card.protocol.data.ComponentStatus;
import com.larksuite.component.card.protocol.data.StreamingConfig;
import com.larksuite.component.card.protocol.data.action.ActionInfo;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 52\u00020\u0001:\u00015B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010+R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001e¨\u00066"}, d2 = {"Lcom/larksuite/component/card/protocol/CardData;", "Ljava/io/Serializable;", "cardID", "", "universalCardID", "version", "universalCardVersion", "cardContent", "Lcom/larksuite/component/card/protocol/data/CardContent;", "translateContent", "translateInfo", "Lcom/larksuite/component/card/protocol/data/CardTranslateInfo;", "componentStatus", "Lcom/larksuite/component/card/protocol/data/ComponentStatus;", "actionInfo", "Lcom/larksuite/component/card/protocol/data/action/ActionInfo;", "isStreamingMode", "", "streamingConfig", "Lcom/larksuite/component/card/protocol/data/StreamingConfig;", "cardDataSource", "Lcom/larksuite/component/card/protocol/CardDataSource;", "actionDataSource", "Lcom/larksuite/component/card/protocol/CardActionDataSource;", "parseDataTrace", "Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "hostCardId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larksuite/component/card/protocol/data/CardContent;Lcom/larksuite/component/card/protocol/data/CardContent;Lcom/larksuite/component/card/protocol/data/CardTranslateInfo;Lcom/larksuite/component/card/protocol/data/ComponentStatus;Lcom/larksuite/component/card/protocol/data/action/ActionInfo;ZLcom/larksuite/component/card/protocol/data/StreamingConfig;Lcom/larksuite/component/card/protocol/CardDataSource;Lcom/larksuite/component/card/protocol/CardActionDataSource;Lcom/ss/android/lark/opmonitor/trace/OPTrace;Ljava/lang/String;)V", "getCardID", "()Ljava/lang/String;", "getUniversalCardID", "getVersion", "getUniversalCardVersion", "getCardContent", "()Lcom/larksuite/component/card/protocol/data/CardContent;", "getTranslateContent", "getTranslateInfo", "()Lcom/larksuite/component/card/protocol/data/CardTranslateInfo;", "getComponentStatus", "()Lcom/larksuite/component/card/protocol/data/ComponentStatus;", "getActionInfo", "()Lcom/larksuite/component/card/protocol/data/action/ActionInfo;", "()Z", "getStreamingConfig", "()Lcom/larksuite/component/card/protocol/data/StreamingConfig;", "getCardDataSource", "()Lcom/larksuite/component/card/protocol/CardDataSource;", "getActionDataSource", "()Lcom/larksuite/component/card/protocol/CardActionDataSource;", "getParseDataTrace", "()Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "getHostCardId", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardData implements Serializable {
    public static final a Companion = null;
    public static final String TAG = "CardData";
    private final CardActionDataSource actionDataSource;
    private final ActionInfo actionInfo;
    private final CardContent cardContent;
    private final CardDataSource cardDataSource;
    private final String cardID;
    private final ComponentStatus componentStatus;
    private final String hostCardId;
    private final boolean isStreamingMode;
    private final OPTrace parseDataTrace;
    private final StreamingConfig streamingConfig;
    private final CardContent translateContent;
    private final CardTranslateInfo translateInfo;
    private final String universalCardID;
    private final String universalCardVersion;
    private final String version;

    public static final class a {

        /* JADX INFO: renamed from: com.larksuite.component.card.protocol.CardData$a$a, reason: collision with other inner class name */
        public static final class C0027a {
            public String a;
            public String b;
            public String c;
            public String d;
            public CardContent e;
            public CardContent f;
            public ComponentStatus g;
            public CardTranslateInfo h;
            public ActionInfo i;
            public boolean j;
            public StreamingConfig k;
            public CardDataSource l;
            public CardActionDataSource m;
            public final OPTrace n;
            public String o;

            public final CardData a() {
                if (this.e == null) goto L10;
                String r2 = this.a;
                if (r2 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("cardID");
                r2 = null;
            L7:
                String r4 = this.b;
                String r5 = this.c;
                String r6 = this.d;
                CardContent r7 = this.e;
                Intrinsics.checkNotNull(r7);
                return new CardData(r2, r4, r5, r6, r7, this.f, this.h, this.g, this.i, this.j, this.k, this.l, this.m, this.n, this.o);
            L10:
                throw new Exception("card content is null");
            }

            public C0027a() {
                this.m = CardActionDataSource.IM_CONTENT;
                this.n = gyb.a.a().subTrace();
            }
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final CardActionDataSource getActionDataSource() {
        return this.actionDataSource;
    }

    public final ActionInfo getActionInfo() {
        return this.actionInfo;
    }

    public final CardContent getCardContent() {
        return this.cardContent;
    }

    public final CardDataSource getCardDataSource() {
        return this.cardDataSource;
    }

    public final String getCardID() {
        return this.cardID;
    }

    public final ComponentStatus getComponentStatus() {
        return this.componentStatus;
    }

    public final String getHostCardId() {
        return this.hostCardId;
    }

    public final OPTrace getParseDataTrace() {
        return this.parseDataTrace;
    }

    public final StreamingConfig getStreamingConfig() {
        return this.streamingConfig;
    }

    public final CardContent getTranslateContent() {
        return this.translateContent;
    }

    public final CardTranslateInfo getTranslateInfo() {
        return this.translateInfo;
    }

    public final String getUniversalCardID() {
        return this.universalCardID;
    }

    public final String getUniversalCardVersion() {
        return this.universalCardVersion;
    }

    public final String getVersion() {
        return this.version;
    }

    public final boolean isStreamingMode() {
        return this.isStreamingMode;
    }

    public CardData(String r7, String r8, String r9, String r10, CardContent r11, CardContent r12, CardTranslateInfo r13, ComponentStatus r14, ActionInfo r15, boolean r16, StreamingConfig r17, CardDataSource r19, CardActionDataSource r110, OPTrace r20, String r21) {
        Intrinsics.checkNotNullParameter(r7, "cardID");
        Intrinsics.checkNotNullParameter(r11, "cardContent");
        Intrinsics.checkNotNullParameter(r110, "actionDataSource");
        Intrinsics.checkNotNullParameter(r20, "parseDataTrace");
        this.cardID = r7;
        this.universalCardID = r8;
        this.version = r9;
        this.universalCardVersion = r10;
        this.cardContent = r11;
        this.translateContent = r12;
        this.translateInfo = r13;
        this.componentStatus = r14;
        this.actionInfo = r15;
        this.isStreamingMode = r16;
        this.streamingConfig = r17;
        this.cardDataSource = r19;
        this.actionDataSource = r110;
        this.parseDataTrace = r20;
        this.hostCardId = r21;
    }
}
