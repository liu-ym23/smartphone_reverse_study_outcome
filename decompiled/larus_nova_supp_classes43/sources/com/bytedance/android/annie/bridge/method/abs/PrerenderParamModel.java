package com.bytedance.android.annie.bridge.method.abs;

import com.bytedance.android.annie.bridge.method.util.EnumJsonAdapter;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel;", "", "", a.KEY_SCHEMA, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;", "strategy", "Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;", "c", "()Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;", "setStrategy", "(Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;)V", "", "expiredTime", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "setExpiredTime", "(Ljava/lang/Integer;)V", "<init>", "()V", "Strategy", "StrategyAdapter", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class PrerenderParamModel {

    @SerializedName("expiredTime")
    private Integer expiredTime;

    @SerializedName(a.KEY_SCHEMA)
    private String schema;

    @SerializedName("strategy")
    @JsonAdapter(StrategyAdapter.class)
    private Strategy strategy;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;", "", "", "toString", "Companion", "a", "Immediately", "Onidle", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Strategy extends Enum<Strategy> {
        public static final a Companion = null;
        public static final Strategy Immediately = null;
        public static final Strategy Onidle = null;
        public static final /* synthetic */ Strategy[] a = null;

        public static final class a {
            public a() {
            }
        }

        public static Strategy valueOf(String r1) {
            return (Strategy) r27.a.a(Strategy.class, r1);
        }

        public static Strategy[] values() {
            return (Strategy[]) a.clone();
        }

        static {
            Strategy r0 = new Strategy("Immediately", 0);
            Immediately = r0;
            Strategy r1 = new Strategy("Onidle", 1);
            Onidle = r1;
            a = new Strategy[]{r0, r1};
            Companion = new a();
        }

        @Override // java.lang.Enum
        public String toString() {
            if (this != Immediately) goto L6;
            return "immediately";
        L6:
            if (this != Onidle) goto L8;
            return "onidle";
        L8:
            return "";
        }

        public Strategy(String r1, int r10) {
            super(r1, r10);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$StrategyAdapter;", "Lcom/bytedance/android/annie/bridge/method/util/EnumJsonAdapter;", "Lcom/bytedance/android/annie/bridge/method/abs/PrerenderParamModel$Strategy;", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class StrategyAdapter extends EnumJsonAdapter<Strategy> {
        public StrategyAdapter() {
        }

        public final Object read(JsonReader r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            if (r10.peek() != JsonToken.NULL) goto L7;
            r10.nextNull();
            return null;
        L7:
            String r11 = r10.nextString();
            Strategy.Companion.getClass();
            Intrinsics.checkNotNullParameter(r11, "strategy");
            if (StringsKt.equals(r11, "immediately", true) == false) goto L11;
            return Strategy.Immediately;
        L11:
            if (StringsKt.equals(r11, "onidle", true) == true) goto L13;
            return null;
        L13:
            return Strategy.Onidle;
        }
    }

    public PrerenderParamModel() {
        this.strategy = Strategy.Onidle;
        this.expiredTime = 10;
    }

    public final Integer a() {
        return this.expiredTime;
    }

    public final String b() {
        return this.schema;
    }

    public final Strategy c() {
        return this.strategy;
    }
}
