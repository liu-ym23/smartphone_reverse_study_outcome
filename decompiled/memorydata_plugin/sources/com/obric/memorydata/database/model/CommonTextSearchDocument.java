package com.obric.memorydata.database.model;

import android.content.ContentValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/model/CommonTextSearchDocument;", "Lcom/obric/search/api/document/intf/IFullTextSearchDocument;", OaidModel.KEY_ID, "", "schemaName", "", "properties", "", "<init>", "(JLjava/lang/String;Ljava/util/Map;)V", "getId", "()J", "getSchemaName", "()Ljava/lang/String;", "toContentValues", "Landroid/content/ContentValues;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CommonTextSearchDocument implements com.obric.search.api.b.a.b {
    private final long id;

    @SerializedName("properties")
    private final Map<String, String> properties;

    @SerializedName("schema")
    private final String schemaName;

    public CommonTextSearchDocument(long r3, String r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "schemaName");
        Intrinsics.checkNotNullParameter(r7, "properties");
        this.id = r3;
        this.schemaName = r5;
        this.properties = r7;
    }

    @Override // com.obric.search.api.b.a.a
    public long getId() {
        return this.id;
    }

    @Override // com.obric.search.api.b.a.a
    public String getSchemaName() {
        return this.schemaName;
    }

    @Override // com.obric.search.api.b.a.b
    public ContentValues toContentValues() {
        ContentValues r0 = new ContentValues();
        Iterator<Map.Entry<String, String>> r5 = this.properties.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r1.getValue(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r0;
    }
}
