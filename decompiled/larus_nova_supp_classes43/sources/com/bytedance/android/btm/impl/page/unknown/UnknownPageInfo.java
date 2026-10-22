package com.bytedance.android.btm.impl.page.unknown;

import com.byted.cast.sink.api.IAPI;
import com.bytedance.android.btm.api.model.BufferBtm;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/btm/impl/page/unknown/UnknownPageInfo;", "Lcom/bytedance/android/btm/impl/page/unknown/UnionData;", "()V", "bufferBtm", "Lcom/bytedance/android/btm/api/model/BufferBtm;", "getBufferBtm", "()Lcom/bytedance/android/btm/api/model/BufferBtm;", "setBufferBtm", "(Lcom/bytedance/android/btm/api/model/BufferBtm;)V", "mountBtmIds", "", "", "getMountBtmIds", "()Ljava/util/List;", "setMountBtmIds", "(Ljava/util/List;)V", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "toString", "btm-impl_cnRelease"}, k = 1, mv = {1, 1, IAPI.OPTION_PLAYER_TYPE})
public final class UnknownPageInfo extends UnionData {
    private BufferBtm bufferBtm;
    private List<String> mountBtmIds;
    private String schema;

    public String toString() {
        JSONObject r0 = new JSONObject();
        r0.put("class_name", getClassName());     // Catch: Throwable -> L6
        r0.put("page_btm", getPageBtm());     // Catch: Throwable -> L6
        r0.put("union_pre", getUnionPre());     // Catch: Throwable -> L6
        r0.put("union_step", getUnionStep());     // Catch: Throwable -> L6
        r0.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, getPageId());     // Catch: Throwable -> L6
        r0.put("buffer_btm", this.bufferBtm);     // Catch: Throwable -> L6
    L5:
        return r0.toString();
    }

    public UnknownPageInfo() {
        this.mountBtmIds = new ArrayList();
    }

    public final BufferBtm getBufferBtm() {
        return this.bufferBtm;
    }

    public final List<String> getMountBtmIds() {
        return this.mountBtmIds;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final void setBufferBtm(BufferBtm r1) {
        this.bufferBtm = r1;
    }

    public final void setMountBtmIds(List<String> r1) {
        this.mountBtmIds = r1;
    }

    public final void setSchema(String r1) {
        this.schema = r1;
    }
}
