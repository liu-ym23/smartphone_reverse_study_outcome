package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftSortStrategy")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b7\u00108R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\r0\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0010R+\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010 \u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR+\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\nR\u001b\u0010)\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020%8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0006\u001a\u0004\b+\u0010(R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0006\u001a\u0004\b.\u0010\u0010RC\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003008V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\u0006\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftSortStrategyFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/a2;", BuildConfig.FLAVOR, "<set-?>", "scene$delegate", "Ljava/lang/Object;", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "scene", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "giftIds$delegate", "getGiftIds", "()Ljava/util/List;", "setGiftIds", "(Ljava/util/List;)V", "giftIds", "tagIds$delegate", "getTagIds", "tagIds", "startTime$delegate", "getStartTime", "()J", "setStartTime", "(J)V", "startTime", "endTime$delegate", "getEndTime", "setEndTime", "endTime", "extra$delegate", "getExtra", "setExtra", "extra", BuildConfig.FLAVOR, "strategyType$delegate", "getStrategyType", "()I", "strategyType", "updateType$delegate", "getUpdateType", "updateType", "effectedGiftIds$delegate", "getEffectedGiftIds", "effectedGiftIds", BuildConfig.FLAVOR, "eventTrack$delegate", "getEventTrack", "()Ljava/util/Map;", "setEventTrack", "(Ljava/util/Map;)V", "eventTrack", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftSortStrategyFlexImpl extends FlexModelBase<a2> implements a2, vh7.h {

    @SerializedName("effected_gift_ids")
    protected List<Long> _$$effectedGiftIds;

    @SerializedName("end_time")
    protected long _$$endTime;

    @SerializedName("event_track")
    protected Map<String, String> _$$eventTrack;

    @SerializedName("extra")
    protected String _$$extra;

    @SerializedName("gift_ids")
    protected List<Long> _$$giftIds;

    @SerializedName("scene")
    protected String _$$scene;

    @SerializedName("start_time")
    protected long _$$startTime;

    @SerializedName("strategy_type")
    protected int _$$strategyType;

    @SerializedName("tag_ids")
    protected List<Long> _$$tagIds;

    @SerializedName("update_type")
    protected int _$$updateType;

    public IGiftSortStrategyFlexImpl() {
        super(a2.class);
        this._$$scene = BuildConfig.FLAVOR;
        this._$$giftIds = $defaultValue_giftIds$();
        this._$$tagIds = $defaultValue_tagIds$();
        this._$$extra = BuildConfig.FLAVOR;
        this._$$effectedGiftIds = $defaultValue_effectedGiftIds$();
        this._$$eventTrack = $defaultValue_eventTrack$();
    }

    public final List<Long> $defaultValue_effectedGiftIds$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final Map<String, String> $defaultValue_eventTrack$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    public final List<Long> $defaultValue_giftIds$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<Long> $defaultValue_tagIds$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final List<Long> getEffectedGiftIds() {
        return this._$$effectedGiftIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final long getEndTime() {
        return this._$$endTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final Map<String, String> getEventTrack() {
        return this._$$eventTrack;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final String getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final List<Long> getGiftIds() {
        return this._$$giftIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final String getScene() {
        return this._$$scene;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final long getStartTime() {
        return this._$$startTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final int getStrategyType() {
        return this._$$strategyType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final List<Long> getTagIds() {
        return this._$$tagIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final int getUpdateType() {
        return this._$$updateType;
    }

    public IGiftSortStrategyFlexImpl(am3.g r11) {
        super(a2.class);
        this._$$giftIds = new ArrayList();
        this._$$tagIds = new ArrayList();
        this._$$effectedGiftIds = new ArrayList();
        this._$$eventTrack = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L35;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        switch(r2) {
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L26;
            case 9: goto L25;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        long r6 = r11.c();
        String r3 = null;
        String r7 = null;
    L9:
        int r8 = r11.f();
        if (r8 == (-1)) goto L17;
        if (r8 != 1) goto L13;
        r3 = am3.h.c(r11);
        goto L9
    L13:
        if (r8 != 2) goto L14;
        r7 = am3.h.c(r11);
        goto L9
    L14:
        am3.h.e(r11);
        goto L9
    L17:
        r11.d(r6);
        Map<String, String> r4 = this._$$eventTrack;
        if (r3 == null) goto L24;
        if (r7 == null) goto L22;
        r4.put(r3, r7);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        List<Long> r9 = this._$$effectedGiftIds;
    L33:
        r9.add(Long.valueOf(r11.j()));
        goto L3
    L26:
        this._$$updateType = r11.i();
        goto L3
    L27:
        this._$$strategyType = r11.i();
        goto L3
    L28:
        this._$$extra = am3.h.c(r11);
        goto L3
    L29:
        this._$$endTime = r11.j();
        goto L3
    L30:
        this._$$startTime = r11.j();
        goto L3
    L31:
        r9 = this._$$tagIds;
        goto L33
    L32:
        r9 = this._$$giftIds;
        goto L33
    L34:
        this._$$scene = am3.h.c(r11);
        goto L3
    L7:
        am3.h.d(r5, r11);
        goto L3
    L35:
        r11.d(r0);
        setThreadSafe(true);
        if (this._$$scene != null) goto L39;
        this._$$scene = BuildConfig.FLAVOR;
    L39:
        if (this._$$giftIds.isEmpty() == false) goto L42;
        this._$$giftIds = $defaultValue_giftIds$();
    L42:
        if (this._$$tagIds.isEmpty() == false) goto L45;
        this._$$tagIds = $defaultValue_tagIds$();
    L45:
        if (this._$$extra != null) goto L48;
        this._$$extra = BuildConfig.FLAVOR;
    L48:
        if (this._$$effectedGiftIds.isEmpty() == false) goto L51;
        this._$$effectedGiftIds = $defaultValue_effectedGiftIds$();
    L51:
        if (this._$$eventTrack != null) goto L87;
        this._$$eventTrack = $defaultValue_eventTrack$();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setEndTime(long r1) {
        this._$$endTime = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setEventTrack(Map<String, String> r1) {
        this._$$eventTrack = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setExtra(String r1) {
        this._$$extra = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setGiftIds(List<Long> r1) {
        this._$$giftIds = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setScene(String r1) {
        this._$$scene = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.a2
    public final void setStartTime(long r1) {
        this._$$startTime = r1;
    }
}
