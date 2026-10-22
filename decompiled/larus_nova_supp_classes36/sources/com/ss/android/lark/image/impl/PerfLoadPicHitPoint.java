package com.ss.android.lark.image.impl;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.statistics.Statistics;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J \u0010/\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\"J3\u0010/\u001a\u00020,2\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\"2\b\u00102\u001a\u0004\u0018\u00010\"2\b\u00100\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00104J \u00105\u001a\u00020,2\b\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\"J3\u00105\u001a\u00020,2\b\u00103\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\"2\b\u00102\u001a\u0004\u0018\u00010\"2\b\u00100\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00104J\b\u00106\u001a\u00020,H\u0002J\b\u00107\u001a\u00020,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000eR\u0014\u0010\u001d\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000eR\u0014\u0010\u001f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000eR\u0014\u0010!\u001a\u00020\"X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\"X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020\"X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0014\u0010)\u001a\u00020\"X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$¨\u00068"}, d2 = {"Lcom/ss/android/lark/image/impl/PerfLoadPicHitPoint;", "", "<init>", "()V", "TAG", "", "defaultParamsMap", "Ljava/util/HashMap;", "getDefaultParamsMap", "()Ljava/util/HashMap;", "setDefaultParamsMap", "(Ljava/util/HashMap;)V", "EVENT_PERF_LOAD_PIC", "getEVENT_PERF_LOAD_PIC", "()Ljava/lang/String;", "KEY_LOAD_START_TIME", "getKEY_LOAD_START_TIME", "KEY_LOAD_END_TIME", "getKEY_LOAD_END_TIME", "KEY_LOAD_DIFF_TIME", "getKEY_LOAD_DIFF_TIME", "KEY_LOAD_STATE", "getKEY_LOAD_STATE", "KEY_PIC_TYPE", "getKEY_PIC_TYPE", "KEY_PIC_KEY", "getKEY_PIC_KEY", "KEY_IS_THUMBNAIL", "getKEY_IS_THUMBNAIL", "KEY_PIC_WIDTH", "getKEY_PIC_WIDTH", "KEY_PIC_HEIGHT", "getKEY_PIC_HEIGHT", "VALUE_LOAD_STATE_SUCCESS", "", "getVALUE_LOAD_STATE_SUCCESS", "()I", "VALUE_LOAD_STATE_FAIL", "getVALUE_LOAD_STATE_FAIL", "VALUE_IS_THUMBNAIL_ORIGIN", "getVALUE_IS_THUMBNAIL_ORIGIN", "VALUE_IS_THUMBNAIL_THUMBNAIL", "getVALUE_IS_THUMBNAIL_THUMBNAIL", "startLoadPic", "", "isThumbnail", "", "loadPicFail", "picId", "width", "height", "format", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "loadPicSuccess", "computeEndTime", "innerSend", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class PerfLoadPicHitPoint {
    private final String EVENT_PERF_LOAD_PIC;
    private final String KEY_IS_THUMBNAIL;
    private final String KEY_LOAD_DIFF_TIME;
    private final String KEY_LOAD_END_TIME;
    private final String KEY_LOAD_START_TIME;
    private final String KEY_LOAD_STATE;
    private final String KEY_PIC_HEIGHT;
    private final String KEY_PIC_KEY;
    private final String KEY_PIC_TYPE;
    private final String KEY_PIC_WIDTH;
    private String TAG;
    private final int VALUE_IS_THUMBNAIL_ORIGIN;
    private final int VALUE_IS_THUMBNAIL_THUMBNAIL;
    private final int VALUE_LOAD_STATE_FAIL;
    private final int VALUE_LOAD_STATE_SUCCESS;
    private HashMap<String, Object> defaultParamsMap;

    private final void computeEndTime() {
        this.defaultParamsMap.put(this.KEY_LOAD_END_TIME, Long.valueOf(System.currentTimeMillis()));
        HashMap<String, Object> r0 = this.defaultParamsMap;
        String r1 = this.KEY_LOAD_DIFF_TIME;
        Object r2 = r0.get(this.KEY_LOAD_END_TIME);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Long");
        long r4 = ((Long) r2).longValue();
        Object r3 = this.defaultParamsMap.get(this.KEY_LOAD_START_TIME);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.Long");
        r0.put(r1, Long.valueOf(r4 - ((Long) r3).longValue()));
    }

    private final void innerSend() {
        JSONObject r0 = new JSONObject();
        String r1 = this.KEY_LOAD_START_TIME;
        JSONObject r2 = r0.put(r1, this.defaultParamsMap.get(r1));
        String r3 = this.KEY_LOAD_END_TIME;
        JSONObject r4 = r2.put(r3, this.defaultParamsMap.get(r3));
        String r5 = this.KEY_LOAD_DIFF_TIME;
        JSONObject r6 = r4.put(r5, this.defaultParamsMap.get(r5));
        String r7 = this.KEY_LOAD_STATE;
        JSONObject r8 = r6.put(r7, this.defaultParamsMap.get(r7));
        String r9 = this.KEY_PIC_TYPE;
        JSONObject r10 = r8.put(r9, this.defaultParamsMap.get(r9));
        String r11 = this.KEY_IS_THUMBNAIL;
        JSONObject r12 = r10.put(r11, this.defaultParamsMap.get(r11));
        String r13 = this.KEY_PIC_WIDTH;
        JSONObject r14 = r12.put(r13, this.defaultParamsMap.get(r13));
        String r15 = this.KEY_PIC_HEIGHT;
        JSONObject r16 = r14.put(r15, this.defaultParamsMap.get(r15));
        String r17 = this.KEY_PIC_KEY;
        Statistics.sendEvent("perf_load_pic", r16.put(r17, this.defaultParamsMap.get(r17)));
    }

    public PerfLoadPicHitPoint() {
        this.TAG = "PerfLoadPicMonitor";
        this.defaultParamsMap = new HashMap();
        this.EVENT_PERF_LOAD_PIC = "perf_load_pic";
        this.KEY_LOAD_START_TIME = "load_start_time";
        this.KEY_LOAD_END_TIME = "load_end_time";
        this.KEY_LOAD_DIFF_TIME = "load_diff_time";
        this.KEY_LOAD_STATE = "load_state";
        this.KEY_PIC_TYPE = "pic_type";
        this.KEY_PIC_KEY = "pic_key";
        this.KEY_IS_THUMBNAIL = "is_thumbnail";
        this.KEY_PIC_WIDTH = "width";
        this.KEY_PIC_HEIGHT = "height";
        this.VALUE_LOAD_STATE_SUCCESS = 1;
        this.VALUE_LOAD_STATE_FAIL = 2;
        this.VALUE_IS_THUMBNAIL_THUMBNAIL = 1;
    }

    public final void startLoadPic(boolean r5) {
        this.defaultParamsMap.put(this.KEY_LOAD_START_TIME, Long.valueOf(System.currentTimeMillis()));
        int r0 = this.VALUE_IS_THUMBNAIL_ORIGIN;
        if (r5 == false) goto L5;
        r0 = this.VALUE_IS_THUMBNAIL_THUMBNAIL;
    L5:
        Integer r6 = Integer.valueOf(r0);
        this.defaultParamsMap.put(this.KEY_IS_THUMBNAIL, r6);
    }

    public final void loadPicSuccess(String r2, int r3, int r4) {
        computeEndTime();
        Integer r5 = Integer.valueOf(r3);
        this.defaultParamsMap.put(this.KEY_PIC_WIDTH, r5);
        Integer r6 = Integer.valueOf(r4);
        this.defaultParamsMap.put(this.KEY_PIC_HEIGHT, r6);
        this.defaultParamsMap.put(this.KEY_LOAD_STATE, Integer.valueOf(this.VALUE_LOAD_STATE_SUCCESS));
        innerSend();
    }
}
