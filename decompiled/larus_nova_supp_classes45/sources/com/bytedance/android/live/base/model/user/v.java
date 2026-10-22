package com.bytedance.android.live.base.model.user;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u001bR\"\u0010\n\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000e\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000b\u0010\u0005\"\u0004\b\f\u0010\u0007R\"\u0010\u0012\u001a\u00020\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/base/model/user/v;", "Lvh7/c;", "", "", "getBuffLevel", "()I", "setBuffLevel", "(I)V", "getBuffLevel$annotations", "()V", "buffLevel", "getEndTime", "setEndTime", "getEndTime$annotations", "endTime", "getStatus", "setStatus", "getStatus$annotations", "status", "Lpy/k;", "getBuffBadge", "()Lpy/k;", "setBuffBadge", "(Lpy/k;)V", "getBuffBadge$annotations", "buffBadge", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v extends vh7.c<v> {
    public static final int BUFF_LEVEL_1 = 1;
    public static final int BUFF_LEVEL_2 = 101;
    public static final int BUFF_LEVEL_3 = 201;
    public static final int BUFF_LEVEL_4 = 301;
    public static final a Companion = null;

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

    @FieldName(name = "buff_badge")
    py.k getBuffBadge();

    @FieldName(name = "buff_level")
    int getBuffLevel();

    @FieldName(name = "end_time")
    int getEndTime();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = "buff_badge#setter")
    void setBuffBadge(py.k r1);

    @FieldName(name = "buff_level#setter")
    void setBuffLevel(int r1);

    @FieldName(name = "end_time#setter")
    void setEndTime(int r1);

    @FieldName(name = "status#setter")
    void setStatus(int r1);
}
