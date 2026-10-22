package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003:\u0005;<=>?R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\n\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\n\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\n\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R0\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010,8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\n\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00109\u001a\u0004\u0018\u0001038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b8\u0010\n\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006@"}, d2 = {"Lcom/bytedance/android/live/base/model/message/n5;", "Lvh7/c;", "Lcom/bytedance/android/live/base/model/message/c3;", "", "", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getScene$annotations", "()V", "scene", "getSubScene", "setSubScene", "getSubScene$annotations", "subScene", "Lcom/bytedance/android/live/base/model/message/d;", "getContent", "()Lcom/bytedance/android/live/base/model/message/d;", "setContent", "(Lcom/bytedance/android/live/base/model/message/d;)V", "getContent$annotations", "content", "Lcom/bytedance/android/live/base/model/message/n5$a;", "getBackground", "()Lcom/bytedance/android/live/base/model/message/n5$a;", "setBackground", "(Lcom/bytedance/android/live/base/model/message/n5$a;)V", "getBackground$annotations", KtvSubElement.BACKGROUND, "Lcom/bytedance/android/live/base/model/message/n5$e;", "getDynamicConfig", "()Lcom/bytedance/android/live/base/model/message/n5$e;", "setDynamicConfig", "(Lcom/bytedance/android/live/base/model/message/n5$e;)V", "getDynamicConfig$annotations", "dynamicConfig", "Lcom/bytedance/android/live/base/model/message/n5$f;", "getPriorityConfig", "()Lcom/bytedance/android/live/base/model/message/n5$f;", "setPriorityConfig", "(Lcom/bytedance/android/live/base/model/message/n5$f;)V", "getPriorityConfig$annotations", "priorityConfig", "", "getEventParams", "()Ljava/util/Map;", "setEventParams", "(Ljava/util/Map;)V", "getEventParams$annotations", "eventParams", "Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "getHighlightAreaPriorityConfig", "()Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;", "setHighlightAreaPriorityConfig", "(Lcom/bytedance/android/livesdkapi/message/HighlightAreaPriorityConfig;)V", "getHighlightAreaPriorityConfig$annotations", "highlightAreaPriorityConfig", "Companion", "a", "b", "c", "e", "f", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n5 extends vh7.c<n5>, c3 {
    public static final c Companion = null;
    public static final long DEFAULT_SHOW_DURATION = 5000;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/base/model/message/n5$a;", "", "Lpy/k;", "backgroundImage", "Lpy/k;", "", "backgroundColor", "Ljava/lang/String;", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a implements vh7.h {

        @SerializedName("background_color")
        public String backgroundColor;

        @SerializedName("background_image")
        public py.k backgroundImage;

        public a() {
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
        public a(am3.g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            this.backgroundImage = vh7.f.a(r5, py.k.class);
            goto L3
        L8:
            if (r2 != 2) goto L9;
            this.backgroundColor = am3.h.c(r5);
            goto L3
        L9:
            am3.h.e(r5);
            goto L3
        L12:
            r5.d(r0);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/base/model/message/n5$b;", "", "", "seqId", "J", "", "numList", "Ljava/util/List;", "durationList", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b implements vh7.h {

        @SerializedName("duration_list")
        public List<Long> durationList;

        @SerializedName("num_list")
        public List<Long> numList;

        @SerializedName("seq_id")
        public long seqId;

        public b() {
        }

        public b(am3.g r6) {
            this.numList = new ArrayList();
            this.durationList = new ArrayList();
            long r0 = r6.c();
        L3:
            int r2 = r6.f();
            if (r2 == (-1)) goto L16;
            if (r2 != 1) goto L8;
            this.seqId = r6.j();
            goto L3
        L8:
            if (r2 == 2) goto L13;
            if (r2 != 3) goto L11;
            List<Long> r3 = this.durationList;
        L14:
            r3.add(Long.valueOf(r6.j()));
            goto L3
        L11:
            am3.h.e(r6);
            goto L3
        L13:
            r3 = this.numList;
            goto L14
        L16:
            r6.d(r0);
        }
    }

    public static final class c {
        public static final /* synthetic */ c a = null;

        public c() {
        }

        static {
            a = new c();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class d {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/message/n5$e;", "", "", "delayTime", "I", "", "startTimestamp", "J", "allowExceedTime", "endTimestamp", "duration", "displayEffectType", "Lcom/bytedance/android/live/base/model/message/n5$b;", "comboInfo", "Lcom/bytedance/android/live/base/model/message/n5$b;", "", "isAssemble", "Z", "<init>", "()V", "a", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e implements vh7.h {

        @SerializedName("allow_exceed_time")
        public long allowExceedTime;

        @SerializedName("combo_info")
        public b comboInfo;

        @SerializedName("delay_time")
        public int delayTime;

        @SerializedName("display_effect_type")
        public int displayEffectType;

        @SerializedName("duration")
        public int duration;

        @SerializedName("end_time_stamp")
        public long endTimestamp;

        @SerializedName("is_assemble")
        public boolean isAssemble;

        @SerializedName("start_time_stamp")
        public long startTimestamp;

        public static final class a {
        }

        static {
        }

        public e() {
        }

        public e(am3.g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L15;
            switch(r2) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            this.isAssemble = am3.h.a(r5);
            goto L3
        L8:
            this.comboInfo = new b(r5);
            goto L3
        L9:
            this.displayEffectType = r5.i();
            goto L3
        L10:
            this.duration = r5.i();
            goto L3
        L11:
            this.endTimestamp = r5.j();
            goto L3
        L12:
            this.allowExceedTime = r5.j();
            goto L3
        L13:
            this.startTimestamp = r5.j();
            goto L3
        L14:
            this.delayTime = r5.i();
            goto L3
        L6:
            am3.h.e(r5);
            goto L3
        L15:
            r5.d(r0);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/base/model/message/n5$f;", "", "", "priority", "I", "priorityLowerStrategy", "priorityEqualStrategy", "priorityHigherStrategy", "<init>", "()V", "a", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f implements vh7.h {

        @SerializedName("priority")
        public int priority;

        @SerializedName("priority_equal_strategy")
        public int priorityEqualStrategy;

        @SerializedName("priority_higher_strategy")
        public int priorityHigherStrategy;

        @SerializedName("priority_lower_strategy")
        public int priorityLowerStrategy;

        public static final class a {
        }

        static {
        }

        public f() {
            this.priorityEqualStrategy = 1;
            this.priorityHigherStrategy = 2;
        }

        public f(am3.g r8) {
            long r0 = r8.c();
            int r2 = 0;
        L3:
            int r3 = r8.f();
            if (r3 == (-1)) goto L16;
            if (r3 != 1) goto L6;
            this.priority = r8.i();
            goto L3
        L6:
            if (r3 != 2) goto L8;
            this.priorityLowerStrategy = r8.i();
            goto L3
        L8:
            if (r3 != 3) goto L10;
            this.priorityEqualStrategy = r8.i();
            r2 = r2 | 1;
            goto L3
        L10:
            if (r3 != 4) goto L11;
            this.priorityHigherStrategy = r8.i();
            r2 = r2 | 2;
            goto L3
        L11:
            am3.h.e(r8);
            goto L3
        L16:
            r8.d(r0);
            if ((r2 & 1) != 0) goto L20;
            this.priorityEqualStrategy = 1;
        L20:
            if ((r2 & 2) != 0) goto L38;
            this.priorityHigherStrategy = 2;
            return;
        }
    }

    static {
        Companion = c.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = KtvSubElement.BACKGROUND)
    a getBackground();

    /* synthetic */ m0 getCommon();

    /* synthetic */ long getConsumeTime();

    @FieldName(name = "content")
    com.bytedance.android.live.base.model.message.d getContent();

    /* synthetic */ long getDecodeEndTime();

    /* synthetic */ long getDecodeStartTime();

    /* synthetic */ long getDelayDispatchMs();

    @FieldName(name = "dynamic_config")
    e getDynamicConfig();

    /* synthetic */ long getEnqueueDispatchTime();

    @FieldName(name = "event_params")
    Map<String, String> getEventParams();

    /* synthetic */ int getGeneralMessageType();

    @FieldName(name = "highlight_area_priority_config")
    HighlightAreaPriorityConfig getHighlightAreaPriorityConfig();

    /* synthetic */ long getHttpSendTime();

    /* synthetic */ int getIntType();

    /* synthetic */ Map<String, String> getMessageExtra();

    /* synthetic */ int getMessageFrom();

    /* synthetic */ long getMessageId();

    /* synthetic */ String getMessageMethod();

    /* synthetic */ int getPriority();

    @FieldName(name = "priority_config")
    f getPriorityConfig();

    /* synthetic */ byte[] getRawPayload();

    /* synthetic */ long getReceiveTime();

    /* synthetic */ long getRoomId();

    @FieldName(name = "scene")
    String getScene();

    /* synthetic */ long getShowTimestamp();

    @FieldName(name = "sub_scene")
    String getSubScene();

    /* synthetic */ long getTimestamp();

    /* synthetic */ String getWRDSKey();

    /* synthetic */ String getWRDSSubKey();

    /* synthetic */ long getWRDSVersion();

    /* synthetic */ boolean isFromFirstRequest();

    /* synthetic */ boolean isGlobalMessage();

    /* synthetic */ boolean isTimeCostCanUse();

    /* synthetic */ boolean isWRDSMessage();

    /* synthetic */ boolean needMonitor();

    @FieldName(name = "background#setter")
    void setBackground(a r1);

    /* synthetic */ void setCommon(m0 r1);

    /* synthetic */ void setCommonMessageData(m0 r1);

    /* synthetic */ void setConsumeTime(long r1);

    @FieldName(name = "content#setter")
    void setContent(com.bytedance.android.live.base.model.message.d r1);

    /* synthetic */ void setDecodeEndTime(long r1);

    /* synthetic */ void setDecodeStartTime(long r1);

    @FieldName(name = "dynamic_config#setter")
    void setDynamicConfig(e r1);

    /* synthetic */ void setEnqueueDispatchTime(long r1);

    @FieldName(name = "event_params#setter")
    void setEventParams(Map<String, String> r1);

    /* synthetic */ void setGeneralMessageType(int r1);

    @FieldName(name = "highlight_area_priority_config#setter")
    void setHighlightAreaPriorityConfig(HighlightAreaPriorityConfig r1);

    /* synthetic */ void setHttpSendTime(long r1);

    /* synthetic */ void setIsFromFirstRequest(boolean r1);

    /* synthetic */ void setIsInsert(boolean r1);

    /* synthetic */ void setMessageExtra(Map<String, String> r1);

    /* synthetic */ void setMessageFrom(int r1);

    /* synthetic */ void setMessageMethod(String r1);

    @FieldName(name = "priority_config#setter")
    void setPriorityConfig(f r1);

    /* synthetic */ void setRawPayload(byte[] r1);

    /* synthetic */ void setReceiveTime(long r1);

    @FieldName(name = "scene#setter")
    void setScene(String r1);

    /* synthetic */ void setShowTimestamp(long r1);

    @FieldName(name = "sub_scene#setter")
    void setSubScene(String r1);

    /* synthetic */ void setTimestamp(long r1);

    /* synthetic */ void setWRDSMessage(boolean r1);

    /* synthetic */ void setWRDSSubKey(String r1);

    /* synthetic */ void setWRDSVersion(long r1);
}
