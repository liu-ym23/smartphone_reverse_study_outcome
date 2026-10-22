package com.bytedance.android.live.profit.lottery;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\bg\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0019R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0017\u001a\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/p;", "Lvh7/c;", "", "getPrizeId", "()J", "getPrizeId$annotations", "()V", "prizeId", "", "getType", "()I", "getType$annotations", "type", "", "getName", "()Ljava/lang/String;", "getName$annotations", "name", "getImage", "getImage$annotations", "image", "getPrizeDescription", "getPrizeDescription$annotations", "prizeDescription", "Companion", "a", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface p extends vh7.c<p> {
    public static final a Companion = null;
    public static final int PRIZE_TYPE_CUSTOM = 2;
    public static final int PRIZE_TYPE_CUSTOM_REAL = 4;
    public static final int PRIZE_TYPE_DIAMOND = 1;
    public static final int PRIZE_TYPE_GAMEINVITE = 3;
    public static final int PRIZE_TYPE_UNKNOWN = -1;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "image")
    String getImage();

    @FieldName(name = "name")
    String getName();

    @FieldName(name = "prize_description")
    String getPrizeDescription();

    @FieldName(name = "prize_id")
    long getPrizeId();

    @FieldName(name = "type")
    int getType();
}
