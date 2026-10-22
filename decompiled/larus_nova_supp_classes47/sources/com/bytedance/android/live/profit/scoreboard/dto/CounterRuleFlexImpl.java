package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.open.api.CounterRule")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/CounterRuleFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/scoreboard/dto/f;", "", "index$delegate", "Ljava/lang/Object;", "getIndex", "()J", "index", "", "name$delegate", "getName", "()Ljava/lang/String;", "name", "description$delegate", "getDescription", "description", "", "Lcom/bytedance/android/live/profit/scoreboard/dto/CounterGiftChoiceFlexImpl;", "giftChoices$delegate", "getGiftChoices", "()Ljava/util/List;", "giftChoices", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CounterRuleFlexImpl extends FlexModelBase<f> implements f, vh7.h {

    @SerializedName("description")
    protected String _$$description;

    @SerializedName("gift_choices")
    protected List<CounterGiftChoiceFlexImpl> _$$giftChoices;

    @SerializedName("index")
    protected long _$$index;

    @SerializedName("name")
    protected String _$$name;

    public CounterRuleFlexImpl() {
        super(f.class);
        this._$$name = "";
        this._$$description = "";
        this._$$giftChoices = $defaultValue_giftChoices$();
    }

    public final List<CounterGiftChoiceFlexImpl> $defaultValue_giftChoices$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.f
    public final String getDescription() {
        return this._$$description;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.f
    public final List<CounterGiftChoiceFlexImpl> getGiftChoices() {
        return this._$$giftChoices;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.f
    public final long getIndex() {
        return this._$$index;
    }

    @Override // com.bytedance.android.live.profit.scoreboard.dto.f
    public final String getName() {
        return this._$$name;
    }

    public CounterRuleFlexImpl(am3.g r6) {
        super(f.class);
        this._$$giftChoices = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$index = r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$name = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$description = am3.h.c(r6);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this._$$giftChoices.add(new CounterGiftChoiceFlexImpl(r6));
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$name != null) goto L22;
        this._$$name = "";
    L22:
        if (this._$$description != null) goto L25;
        this._$$description = "";
    L25:
        if (this._$$giftChoices.isEmpty() == false) goto L43;
        this._$$giftChoices = $defaultValue_giftChoices$();
        return;
    }
}
