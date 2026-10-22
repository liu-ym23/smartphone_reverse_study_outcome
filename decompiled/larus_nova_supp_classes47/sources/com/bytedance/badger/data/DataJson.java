package com.bytedance.badger.data;

import com.bytedance.android.live.profile.ui.component.model.ProfileButtonType;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/badger/data/DataJson;", "Lcom/bytedance/badger/data/IBadgerData;", Constants.Keys.DATA, "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getData", "toString", "", "badger-api_release"}, k = 1, mv = {1, 1, ProfileButtonType.FANS_GROUP_CREATE})
public final class DataJson implements IBadgerData {
    private final JSONObject data;

    public String toString() {
        return this.data.toString();
    }

    public final JSONObject getData() {
        return this.data;
    }

    public DataJson(JSONObject r1) {
        this.data = r1;
    }
}
